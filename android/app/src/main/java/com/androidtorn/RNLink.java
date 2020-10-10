package com.androidtorn;

import android.app.Activity;
import android.content.Intent;

import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class RNLink extends ReactContextBaseJavaModule {
    public RNLink(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "RNLink";//这里定义的是该模块名字
    }

    @ReactMethod
    public void startActivity(String name, String params){//该模块的方法
        try{
            Activity currentActivity = getCurrentActivity();
            if(null!=currentActivity){
//                Class toActivity = Class.forName("com.androidtorn."+name);
//                Intent intent = new Intent(currentActivity,toActivity);
//                intent.putExtra("params", params);
//                currentActivity.startActivity(intent);
                currentActivity.finish();
            }
        }catch(Exception e){
            throw new JSApplicationCausedNativeException("不能打开Activity : "+e.getMessage());
        }
    }
}
