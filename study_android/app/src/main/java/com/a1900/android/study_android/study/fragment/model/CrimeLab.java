package com.a1900.android.study_android.study.fragment.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by 1900 on 2017/6/15.
 */

public class CrimeLab {

    private static CrimeLab sCrimeLab;

    private List<Crime> crimeList;


    public static CrimeLab get(Context context) {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    private CrimeLab(Context context) {
        /*组装数据*/
        crimeList = new ArrayList<>();

        /*-------------start 模拟Crime对象------------*/
        for (int i = 0; i < 100; i++) {
            Crime crime = new Crime();
            crime.setmTitle("Crime #" + i);
            crime.setmSolved(i % 2 == 0);
            crimeList.add(crime);
        }
        /*-------------end 模拟Crime对象------------*/
    }


    //--------------对外提供，获取数据的接口

    /*
        获取Crime列表对象
     */
    public List<Crime> getCrimeList() {
        return crimeList;
    }

    /*
        根据UUID获取Crime对象
     */
    public Crime getCrimeByUUID(UUID uuid) {
        for (Crime crime : crimeList) {
            if (crime.getmId().equals(uuid)) {
                return crime;
            }
        }
        return null;
    }
}
