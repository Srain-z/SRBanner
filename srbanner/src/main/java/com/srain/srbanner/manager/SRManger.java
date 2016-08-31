package com.dbtest.srain.srbanner.manager;

import android.content.Context;

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

    public  static synchronized SRManger getInstance(Context context){
        if (mManger == null){
            mManger = new SRManger(context);
        }
        return  mManger;
    }
    

}
