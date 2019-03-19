
import { NativeModules } from 'react-native';

const { RNAppInfo } = NativeModules;

export default {
    getAppVersion(callback) {
        return RNAppInfo.getAppVersion(callback);
    },
};
