package com.vb.ormlite.db;

import android.content.Context;

import com.vb.orm.lib.AbstractDataBaseHelper;
import com.vb.ormlite.bean.TestBeanA;
import com.vb.ormlite.bean.TestBeanB;
import com.vb.ormlite.bean.TestBeanC;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/13 0013.
 */
public class DataBaseHelper extends AbstractDataBaseHelper {


    private static final String DB_NAME = "ormlite_lib.db";
    private static final int DB_VERSION = 1;

    private static DataBaseHelper dbHelper;

    public DataBaseHelper(Context context, List<Class> beans) {
        super(context, DB_NAME, DB_VERSION, beans);
    }

    public static synchronized DataBaseHelper getInstance(Context context) {
        if(null == dbHelper) {
            synchronized (DataBaseHelper.class) {
                if(null == dbHelper) {
                    List<Class> list = new ArrayList<>();
                    list.add(TestBeanA.class);
                    list.add(TestBeanB.class);
                    list.add(TestBeanC.class);
                    dbHelper = new DataBaseHelper(context, list);
                }
            }
        }
        return dbHelper;
    }
}
