package com.a1900.android.study_android.study.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.a1900.android.study_android.R;
import com.a1900.android.study_android.study.fragment.model.Crime;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 1900 on 2017/6/15.
 */

public class CrimeFragment extends Fragment {

    @BindView(R.id.crime_title)
    EditText mCrimeTitle;
    Unbinder unbinder;
    private Crime mCrime;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCrime = new Crime();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        /*第三个参数告知布局生成器是否将生成的视图添加给父视图
          false : 因为我们要通过activity代码的方式添加视图*/
        View view = inflater.inflate(R.layout.fragment_crime, container, false);
        unbinder = ButterKnife.bind(this, view);
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
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
