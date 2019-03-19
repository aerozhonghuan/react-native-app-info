declare module "react-native-app-info" {
    declare const AppInfo: {
        getAppVersion(callback?:()=>void) : void;
    }
    export default AppInfo;
}