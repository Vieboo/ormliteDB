package com.vb.ormlite.db.dao;

import android.content.Context;

import com.vb.orm.lib.AbstractDao;
import com.vb.ormlite.bean.TestBeanA;
import com.vb.ormlite.bean.TestBeanB;
import com.vb.ormlite.db.DataBaseHelper;

/**
 * Created by Administrator on 2016/10/13 0013.
 */
public class TestBDao extends AbstractDao<TestBeanB, String> {

    public TestBDao(Context context) {
        super(DataBaseHelper.getInstance(context).getDao(TestBeanB.class));
    }

    @Override
    public String getTableName() {
        return "table_testb";
    }
}
