package com.yangpf.xdroidmvp.V;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yangpf.xdroidmvp.P.PAlarm;
import com.yangpf.xdroidmvp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.droidlover.xdroidmvp.kit.KnifeKit;
import cn.droidlover.xdroidmvp.log.XLog;
import cn.droidlover.xdroidmvp.mvp.XActivity;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;
import static android.os.Build.VERSION_CODES.O;
import static com.yangpf.xdroidmvp.R.id.textview1;

/**
 * Created by Administrator on 2018/7/1 0001.
 */

public class AlarmView extends XActivity<PAlarm> implements IAlarmV {


    private  TextView tv1;
    private  ImageView img1;
    private  Button settingBtn;



    @Override
    public void initData(Bundle savedInstanceState) {

        setContentView(R.layout.alarm_view);

        final RelativeLayout root = (RelativeLayout) findViewById(R.id.rootview);





        getP().startLogin();
        getP().startAlarm();
//        getP().getAlarmData();
        tv1 = (TextView) findViewById(R.id.textview1);
        img1 = (ImageView) findViewById(R.id.img1);
        settingBtn = (Button) findViewById(R.id.setting);
        settingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View mView = getLayoutInflater().inflate(R.layout.settingview, null);
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);

                root.addView(mView,params );

            }
        });


//        getP().downloadPic(getApplicationContext(), img1);
    }

    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public PAlarm newP() {
        return new PAlarm();
    }

    @Override
    public void loginEX(String e) {
        XLog.e(e);
    }

    @Override
    public void loginSuc() {
        XLog.d("loginSuc");
    }

    @Override
    public void AlarmEX(String e) {
        XLog.e(e);
    }

    @Override
    public void AlarmSuc() {
        XLog.d("AlarmSuc");
    }

    @Override
    public void showText(String t) {
        XLog.d(t);
        if (tv1 != null) {

            tv1.setText(t);
        } else
        {
            XLog.d("textview == null");
        }
    }
}

