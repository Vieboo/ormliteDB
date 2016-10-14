package com.vb.ormlite.db.dao;

import android.content.Context;

import com.vb.orm.lib.AbstractDao;
import com.vb.ormlite.bean.TestBeanA;
import com.vb.ormlite.bean.TestBeanC;
import com.vb.ormlite.db.DataBaseHelper;

/**
 * Created by Administrator on 2016/10/13 0013.
 */
public class TestCDao extends AbstractDao<TestBeanC, Integer> {

    public TestCDao(Context context) {
        super(DataBaseHelper.getInstance(context).getDao(TestBeanC.class));
    }

    @Override
    public String getTableName() {
        return "table_testc";
    }
}
