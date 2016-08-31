package com.srain.srbanner.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

/**
 * Created by srain on 16/8/31.
 * @description
 *  用来判断版本标识、存入版本记录和最新版本判断
 *  Used to determine the version identification,
 *  stored version records and the latest version of the judgment
 */
public class VersionJudgeUtil {

    private Context mContext;
    public  VersionJudgeUtil(Context context){
        mContext = context;
        settings = mContext.getSharedPreferences(Constant.VERSION_SP_NANME, 0);
    }

    private SharedPreferences settings;
    /**
     * 判断是否最后版本
     * @return
     */
    public boolean versionIsLast(){
        boolean return_value;
        int versionCode = settings.getInt(Constant.VERSION_STRING, -1);
        //第一次开启默认不是最后版本
        //The first time to open the default is not the final version
        if(versionCode<0){
            return_value = false;
            return  return_value;
        }
        try {
            PackageInfo pi = mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 0);
            if (versionCode < pi.versionCode){
                return_value =  false;
            }else {
                return_value =  true;
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(VersionJudgeUtil.class.toString(),"对比版本号时，获取apk信息失败！");
            e.printStackTrace();
            return_value = true;
        }

        return  return_value;

    }


    /**
     * 存入
     * @return
     */
    public boolean saveVersionCode(){
        boolean return_value;
        SharedPreferences.Editor editor = settings.edit();
        try {
            PackageInfo pi = mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 0);
            editor.putInt(Constant.VERSION_STRING, pi.versionCode);
            editor.commit();
            //成功
            return_value = true;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(VersionJudgeUtil.class.toString(),"存入version_code时，获取apk信息失败！");
            e.printStackTrace();
            //失败
            return_value = false;
        }
        return  return_value;
    }











}
