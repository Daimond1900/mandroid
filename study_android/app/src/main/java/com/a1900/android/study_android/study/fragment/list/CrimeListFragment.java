package com.a1900.android.study_android.study.fragment.list;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.a1900.android.study_android.R;
import com.a1900.android.study_android.study.fragment.details.CrimeFragment;
import com.a1900.android.study_android.study.fragment.details_view_pager.CrimePagerActivity;
import com.a1900.android.study_android.study.fragment.model.Crime;
import com.a1900.android.study_android.study.fragment.model.CrimeLab;
import com.allen.apputils.DateTimeUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 列表界面
 * Created by 1900 on 2017/6/15.
 */

public class CrimeListFragment extends Fragment {

    private static final int REQUEST_CRIME = 1;
    private static final String TAG = "CrimeListFragment";

    @BindView(R.id.crime_recycler_view)
    RecyclerView mCrimeRecyclerView;
    Unbinder unbinder;

    private CrimeListAdapter mCrimeListAdapter;
    private int updateInex;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_crime, container, false);
        unbinder = ButterKnife.bind(this, view);
        mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    /**
     * 更新数据
     */
    private void updateDataUI() {
        List<Crime> crimeList = CrimeLab.get(getActivity()).getCrimeList();
        if (mCrimeListAdapter == null) {
            mCrimeListAdapter = new CrimeListAdapter(crimeList);
            mCrimeRecyclerView.setAdapter(mCrimeListAdapter);
        } else {
            mCrimeListAdapter.notifyDataSetChanged();/*更新全部*/
//            mCrimeListAdapter.notifyItemChanged(updateInex);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        updateDataUI(); /*更新数据*/
    }

    public class CrimeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mCrimeTitle, mCrimeDate;
        private CheckBox mCrimeSolve;
        private Crime mCrime;
        private int cPosition;

        public CrimeHolder(View itemView) {
            super(itemView);
            mCrimeTitle = (TextView) itemView.findViewById(R.id.crime_list_title);
            mCrimeDate = (TextView) itemView.findViewById(R.id.crime_list_date);
            mCrimeSolve = (CheckBox) itemView.findViewById(R.id.crime_list_checkbox);
            mCrimeSolve.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    mCrime.setmSolved(isChecked);
                }
            });
            itemView.setOnClickListener(this);
        }

        /*绑定数据*/
        public void bindDateView(Crime crime, int cPosition) {
            mCrime = crime;
            this.cPosition = cPosition;
            mCrimeTitle.setText(mCrime.getmTitle());
            mCrimeDate.setText(DateTimeUtil.formatDateTime0(mCrime.getmDate().getTime()));
            mCrimeSolve.setChecked(mCrime.ismSolved());
        }

        @Override
        public void onClick(View v) {
//            Utils.init(getActivity());
//            ToastUtils.init(true);
//            ToastUtils.showShortToast("我是" + mCrime.getmTitle());
//            startActivity(CrimeActivity.newCrimeActivity(getActivity(), cPosition));

//            startActivityForResult(CrimePagerActivity.newCrimePagerActivity(getActivity(), cPosition), REQUEST_CRIME);
            startActivityForResult(CrimePagerActivity.newCrimePagerActivity(getActivity(), cPosition),REQUEST_CRIME);

        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == REQUEST_CRIME) {

                updateInex = data.getIntExtra(CrimeFragment.RETURN_EXTRA_POSTION, 0);/*拿出返回的数据*/

                Log.d(TAG, "onActivityResult: 列表页面拿到的数据： " + updateInex);
            }
        }
    }

    public class CrimeListAdapter extends RecyclerView.Adapter<CrimeHolder> {
        private List<Crime> mCrimeList;

        public CrimeListAdapter(List<Crime> mCrimeList) {
            this.mCrimeList = mCrimeList;
        }

        @Override
        public CrimeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.fragment_list_item_crime, parent, false);
            return new CrimeHolder(view);
        }

        @Override
        public void onBindViewHolder(CrimeHolder holder, int position) {
            holder.bindDateView(mCrimeList.get(position), position);
        }

        @Override
        public int getItemCount() {
            return mCrimeList.size();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}