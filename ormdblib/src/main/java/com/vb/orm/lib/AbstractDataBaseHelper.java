package com.vb.orm.lib;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Vieboo on 2016/4/19.
 */
public abstract class AbstractDataBaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String TAG = "AbstractDataBaseHelper";

    private List<Class> tableBeans;
    private Map<String, Dao> daos = new HashMap<String, Dao>();

    public AbstractDataBaseHelper(Context context, String dbName, int dbVersion, List<Class> beans) {
        super(context, dbName, null, dbVersion);
        this.tableBeans = beans;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        Log.i(TAG, "ORMLite数据库创建----->onCreate");
        createTable(connectionSource);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {
        Log.i(TAG, "ORMLite数据库更新----->onUpgrade");
        dropTable(connectionSource);
        //重新创建新版的表
        createTable(connectionSource);
    }

    @Override
    public void close() {
        super.close();
        for (String key : daos.keySet()) {
            Dao dao = daos.get(key);
            dao = null;
        }
        daos.clear();
    }

    /**
     * 创建所有的表
     * @param connectionSource
     */
    protected void createTable(ConnectionSource connectionSource) {
        if(null == tableBeans) return ;
        try {
            //这里创建表
            for(Class clazz : tableBeans) {
                TableUtils.createTableIfNotExists(connectionSource, clazz);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * 删除所有的表
     * @param connectionSource
     */
    protected void dropTable(ConnectionSource connectionSource) {
        if(null == tableBeans) return ;
        try {
            //删除旧的数据库表
            for(Class clazz : tableBeans) {
                TableUtils.dropTable(connectionSource, clazz, true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 每一个数据库中的表，要有一个获得Dao的方法。 可以使用一种更通用的模板方法如：
     *
     * public Dao<Class, Integer> getORMLiteDao(Class cls) throws SQLException {
     * if (dao == null) { dao = getDao(cls); }
     *
     * return dao; }
     */
    public synchronized Dao getDao(Class clazz) {
        Dao dao = null;
        String className = clazz.getSimpleName();
        if(daos.containsKey(className)) {
            dao = daos.get(className);
        }
        if (dao == null) {
            try {
                dao = super.getDao(clazz);
                daos.put(className, dao);
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return dao;
    }
}
