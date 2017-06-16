package com.a1900.android.study_android.study.fragment.list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.a1900.android.study_android.R;
import com.a1900.android.study_android.study.fragment.model.Crime;
import com.a1900.android.study_android.study.fragment.model.CrimeLab;
import com.allen.apputils.DateTimeUtil;
import com.allen.apputils.ToastUtils;
import com.allen.apputils.Utils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 列表界面
 * Created by 1900 on 2017/6/15.
 */

public class CrimeListFragment extends Fragment {

    @BindView(R.id.crime_recycler_view)
    RecyclerView mCrimeRecyclerView;
    Unbinder unbinder;

    private CrimeListAdapter mCrimeListAdapter;

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

        updateDataUI();

        return view;
    }

    private void updateDataUI() {
        mCrimeListAdapter = new CrimeListAdapter(CrimeLab.get(getActivity()).getCrimeList());
        mCrimeRecyclerView.setAdapter(mCrimeListAdapter);
    }

    public class CrimeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mCrimeTitle, mCrimeDate;
        private CheckBox mCrimeSolve;
        private Crime mCrime;

        public CrimeHolder(View itemView) {
            super(itemView);
            mCrimeTitle = (TextView) itemView.findViewById(R.id.crime_list_title);
            mCrimeDate = (TextView) itemView.findViewById(R.id.crime_list_date);
            mCrimeSolve = (CheckBox) itemView.findViewById(R.id.crime_list_checkbox);
            itemView.setOnClickListener(this);
        }

        /*绑定数据*/
        public void bindDateView(Crime crime) {
            mCrime = crime;
            mCrimeTitle.setText(mCrime.getmTitle());
            mCrimeDate.setText(DateTimeUtil.formatDateTime0(mCrime.getmDate().getTime()));
            mCrimeSolve.setChecked(mCrime.ismSolved());
        }

        @Override
        public void onClick(View v) {
            Utils.init(getActivity());
            ToastUtils.init(true);
            ToastUtils.showShortToast("我是" + mCrime.getmTitle());
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
            holder.bindDateView(mCrimeList.get(position));
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
