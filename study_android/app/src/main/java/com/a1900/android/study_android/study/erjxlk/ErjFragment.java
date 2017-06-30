package com.a1900.android.study_android.study.erjxlk;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.a1900.android.study_android.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by m1900 on 2017/6/30.
 */

public class ErjFragment extends Fragment {

    private ExpandableListView listview;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.erspinner_fragment_layout, container, false);


        // 查找控件
        listview = ((ExpandableListView) view.findViewById(R.id.tree_view_simple));


        //SimpleExpandableListViewAdapter adapter = new SimpleExpandableListViewAdapter(colleges,this);


        // 初始化数据
        List<Classes> classesList = new ArrayList<>();

        for(int i = 1 ;i<3;i++) {
            Classes classes = new Classes();

            classes.name = "计算机"+i+"班";

            List<String> list = new ArrayList<>();

            list.add("mm");
            list.add("dd");
            classes.students = list;

            classesList.add(classes);
        }

        // 构造适配器
        ClassesExpandableListViewAdapter adapter = new ClassesExpandableListViewAdapter(classesList,this);


        // 设置适配器
        listview.setAdapter(adapter);


        return view;
    }

}
