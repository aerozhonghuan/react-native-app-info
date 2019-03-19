
package com.carrot.appInfo;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

public class RNAppInfoModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNAppInfoModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNAppInfo";
  }

  @ReactMethod
  /**
   * 获取app名称
   * @param callback 回调
   */
  public void getAppName(final Callback callback) {
    //

  }

  @ReactMethod
  /**
   * 获取app 版本号 versionName
   * @param callback 回调
   */
  public void getAppVersion(final Callback callback) {
    callback.invoke(getVersionName(reactContext));
  }

  @ReactMethod
  /**
   * 获取app版本号 versionCode
   * @param callback 回调
   */
  public void getAppVersionCode(final Callback callback) {
    callback.invoke(getVersionCode(reactContext));
  }

  //ACTIONS
  /**
   * 获取appVersionCode
   */
  public static int getVersionCode(Context mContext) {
    if (mContext != null) {
      try {
        return mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 0).versionCode;
      } catch (PackageManager.NameNotFoundException ignored) {
      }
    }
    return 0;
  }

  /**
   * 获取app版本号
   */
  public static String getVersionName(Context mContext) {
    if (mContext != null) {
      try {
        return mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 0).versionName;
      } catch (PackageManager.NameNotFoundException ignored) {
      }
    }

    return "";
  }
}