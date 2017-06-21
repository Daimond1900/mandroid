package com.a1900.android.study_android.study.seachedit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.a1900.android.study_android.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by 1900 on 2017/6/21.
 */

public class SeachFragment extends Fragment {

    @BindView(R.id.seach_et)
    EditText mSeachEt;
    @BindView(R.id.show_seach_txt_tv)
    TextView mShowSeachTxtTv;
    Unbinder unbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_softkey_seach, container, false);
        unbinder = ButterKnife.bind(this, view);
        mSeachEt.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                if (actionId == EditorInfo.IME_ACTION_SEARCH || actionId == EditorInfo.IME_ACTION_UNSPECIFIED) {
                    mShowSeachTxtTv.setText(mSeachEt.getText().toString().trim());
                    return true;
                }
                return false;
            }
        });
        return view;
    }

    @OnClick(R.id.seach_et)
    public void onViewClicked() {
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
