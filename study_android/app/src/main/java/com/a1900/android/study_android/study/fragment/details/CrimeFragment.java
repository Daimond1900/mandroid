package com.a1900.android.study_android.study.fragment.details;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.a1900.android.study_android.R;
import com.a1900.android.study_android.study.fragment.dialog.DatePickerFragment;
import com.a1900.android.study_android.study.fragment.model.Crime;
import com.a1900.android.study_android.study.fragment.model.CrimeLab;
import com.allen.apputils.DateTimeUtil;
import com.allen.apputils.ToastUtils;
import com.allen.apputils.Utils;

import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 1900 on 2017/6/15.
 */

public class CrimeFragment extends Fragment {
    private static final String ARG_EXTRA_INFO = "com.a1900.android.study_android.study.fragment.details.CrimeFragment.position";
    public static final String RETURN_EXTRA_POSTION = "com.a1900.android.study_android.study.fragment.details.CrimeFragment.return.position";
    private static final String TAG = "CrimeFragment";
    private static final String DIALOG_DATE = "DialogDate";
    private static final String DIALOG_TIME = "DialogTime";
    private static final int REQUEST_DATE = 0;
    @BindView(R.id.crime_title)
    EditText mCrimeTitle;
    Unbinder unbinder;
    @BindView(R.id.crime_date)
    Button mCrimeDate;
    @BindView(R.id.crime_solved)
    CheckBox mCrimeSolved;
    private Crime mCrime;
    private static int returnPostion;


    public void returnResult() {
        Intent intent = new Intent();
        intent.putExtra(RETURN_EXTRA_POSTION, returnPostion);

        Log.d(TAG, "onActivityResult: 列表页面返回的数据： " + returnPostion);

        getActivity().setResult(Activity.RESULT_OK, intent);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCrime = CrimeLab.get(getActivity()).getCrimeList().get(getArguments().getInt(ARG_EXTRA_INFO));
        returnResult();
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        /*第三个参数告知布局生成器是否将生成的视图添加给父视图
          false : 因为我们要通过activity代码的方式添加视图*/
        View view = inflater.inflate(R.layout.fragment_crime, container, false);
        unbinder = ButterKnife.bind(this, view);

        mCrimeTitle.setText(mCrime.getmTitle());
        mCrimeSolved.setChecked(mCrime.ismSolved());

        mCrimeTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCrime.setmTitle(s.toString()); /*标题改变了*/
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        // 时间按钮的设置
        updateDate();
//        mCrimeDate.setEnabled(false); /*禁用按钮*/


        mCrimeDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                DatePickerFragment df = DatePickerFragment.newInstance(mCrime.getmDate());
                df.setTargetFragment(CrimeFragment.this, REQUEST_DATE);  //设置了一个目标fragment，需要从这个f中返回数据
                df.show(fm, DIALOG_DATE);
            }
        });

        // 是否处理的checkbox的设置
        mCrimeSolved.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mCrime.setmSolved(isChecked);
            }
        });
        return view;
    }

    private void updateDate() {
        mCrimeDate.setText(DateTimeUtil.formatDateTime0(mCrime.getmDate().getTime()));
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) {
            return;
        }
        if (requestCode == REQUEST_DATE) {
            Date date = (Date) data.getSerializableExtra(DatePickerFragment.EXTRA_DATE);
            mCrime.setmDate(date);
            updateDate();
        }
    }

    /**
     * 新建CrimeFragment
     *
     * @param postion
     * @return
     */
    public static CrimeFragment newCrimeFragment(int postion) {
        Log.d(TAG, "newCrimeFragment: ----------" + postion);
        returnPostion = postion;
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_EXTRA_INFO, postion);
        CrimeFragment fragment = new CrimeFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_crime_delete, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_delete_crime:
                Utils.init(getActivity());
                ToastUtils.init(true);
                ToastUtils.showShortToast("删除");
                deleteCrime(returnPostion);
                getActivity().finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void deleteCrime(int index) {
        CrimeLab crimeLab = CrimeLab.get(getActivity());
        List<Crime> crimeList = crimeLab.getCrimeList();
        crimeList.remove(index);
    }
}
