package com.srain.srbanner.manager;

import android.content.Context;

import com.srain.srbanner.util.VersionJudgeUtil;

/**
 * Created by srain on 16/8/31.
 *  @description
 *   SRManger 核心控制类
 *   core manger class
 */
public class SRManger {


    private static SRManger mManger;
    private Context mContext;
    private  SRManger(Context context){
        mContext = context;
    }

    //版本判断工具
    private static VersionJudgeUtil versionUtil;

    public  static synchronized SRManger getInstance(Context context){
        if (mManger == null){
            mManger = new SRManger(context);
            versionUtil = new VersionJudgeUtil(context);
        }

        return  mManger;
    }
    //初始化方法
    public SRManger init(){


        //1.首次打开计算 并且设置关闭开关
        // * 判断启动页类型
        //2.创建遍历背景列表
        //3.加载小配置文件
        //4.

        return mManger;
    }







}
