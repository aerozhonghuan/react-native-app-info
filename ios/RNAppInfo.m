
#import "RNAppInfo.h"

@implementation RNAppInfo

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}
RCT_EXPORT_MODULE()

/**
 获取app版本号
 @param callback:结果回调
 */
RCT_EXPORT_METHOD(getAppVersion:(RCTResponseSenderBlock)callback){
  
  BOOL isSucc = YES;
  NSDictionary *info = [self getMainBundle];
  NSString* appVersion = info["CFBundleShortVersionString"];
  //准备回调回去的数据
  callback(@[appVersion]);
}

/**
 获取app名称
 @param callback:结果回调
 */
RCT_EXPORT_METHOD(getAppName:(RCTResponseSenderBlock)callback){
    
    BOOL isSucc = YES;
    NSDictionary *info = [self getMainBundle];
    NSString* appName = info["CFBundleDisplayName"];
    //准备回调回去的数据
    callback(@[appName]);
}

- (NSDictionary *)getMainBundle{
    return [[NSBundle mainBundle] infoDictionary];
}

@end
