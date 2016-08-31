package com.srain.srbanner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.srain.srbanner.util.VersionJudgeUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.demo_test)
    TextView demoTest;

    //版本判断工具
    private static VersionJudgeUtil versionUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        versionUtil = new VersionJudgeUtil(this);

        //
        String value = String.valueOf(versionUtil.versionIsLast());
        demoTest.setText(value);

        if(!Boolean.valueOf(value)){
            versionUtil.saveVersionCode();
        }
    }
}
