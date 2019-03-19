
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
  public void getAppVersion(final Callback successCallback) {
    JSONObject versionInfo = new JSONObject();
    JSONObject callback = new JSONObject();
    try {
      versionInfo.put("versionCode", getVersionCode(reactContext));
      versionInfo.put("versionName", getVersionName(reactContext));
      successCallback.invoke(versionInfo.toString());
    } catch (JSONException e) {
      e.printStackTrace();
    }
  }

  /**
   * 获取appVersionCode
   * @param callback 回调
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
   * @param callback 回调
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