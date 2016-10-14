package com.vb.ormlite.db.dao;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.vb.orm.lib.AbstractDao;
import com.vb.ormlite.bean.TestBeanA;
import com.vb.ormlite.db.DataBaseHelper;

/**
 * Created by Administrator on 2016/10/13 0013.
 */
public class TestADao extends AbstractDao<TestBeanA, String> {

    public TestADao(Context context) {
        super(DataBaseHelper.getInstance(context).getDao(TestBeanA.class));
    }

    @Override
    public String getTableName() {
        return "table_testa";
    }
}
