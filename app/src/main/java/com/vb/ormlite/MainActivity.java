package com.vb.ormlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.vb.ormlite.bean.TestBeanA;
import com.vb.ormlite.bean.TestBeanB;
import com.vb.ormlite.bean.TestBeanC;
import com.vb.ormlite.db.dao.TestADao;
import com.vb.ormlite.db.dao.TestBDao;
import com.vb.ormlite.db.dao.TestCDao;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button add, delete, deleteAll, update, select, selectAll, addAll;
    TestADao aDao;
    TestBDao bDao;
    TestCDao cDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add = (Button) findViewById(R.id.add);
        delete = (Button) findViewById(R.id.delete);
        deleteAll = (Button) findViewById(R.id.deleteAll);
        update = (Button) findViewById(R.id.update);
        select = (Button) findViewById(R.id.select);
        selectAll = (Button) findViewById(R.id.selectAll);
        addAll = (Button) findViewById(R.id.addAll);

        add.setOnClickListener(this);
        delete.setOnClickListener(this);
        deleteAll.setOnClickListener(this);
        update.setOnClickListener(this);
        select.setOnClickListener(this);
        selectAll.setOnClickListener(this);
        addAll.setOnClickListener(this);

        aDao = new TestADao(this);
        bDao = new TestBDao(this);
        cDao = new TestCDao(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add:
                TestBeanA a = new TestBeanA("_a1", "标题A1","","a_1990" );
                TestBeanA a2 = new TestBeanA("_a2", "标题A2","","a_1990" );
                TestBeanB b = new TestBeanB("_b1", "标题B1","","b_1990" );
                TestBeanB b2 = new TestBeanB("_b2", "标题B2","","b_1990" );
                TestBeanC c = new TestBeanC(100861, "标题C1","","c_1990" );
                TestBeanC c2 = new TestBeanC(100862, "标题C2","","c_1990" );
                aDao.add(a);
                aDao.add(a2);
                bDao.add(b);
                bDao.add(b2);
                cDao.add(c);
                cDao.add(c2);

                break;
            case R.id.delete:
                aDao.deleteById("_a2");
                break;
            case R.id.deleteAll:
                bDao.deleteAll();
                break;
            case R.id.update:
                TestBeanA a2u = new TestBeanA("_a2", "XXXXXXX标题A2","","a_1990" );
                aDao.update(a2u);
                break;
            case R.id.select:
                TestBeanC cc = cDao.getSingleById(100861);
                Log.e("~~~~~~", cc.get_id() + "  " + cc.getTitle());
                break;
            case R.id.selectAll:
                Log.e("~~~~~~", cDao.getAll().size() + "");
                break;
            case R.id.addAll:

                TestBeanA a3 = new TestBeanA("_a3", "标题A3","","a_1990" );
                TestBeanA a4 = new TestBeanA("_a4", "标题A4","","a_1990" );

                List<TestBeanA> list = new ArrayList<>();
                list.add(a3);
                list.add(a4);
                aDao.addAll(list);
                break;
        }
    }
}
