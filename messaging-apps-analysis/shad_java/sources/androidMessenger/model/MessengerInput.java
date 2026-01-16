package androidMessenger.model;

import androidMessenger.model.MessangerInput2;
import androidMessenger.network.EncryptionHelper;
import androidMessenger.utilites.MyLog;
import androidMessenger.utilites.UpdateUtils;
import io.github.inflationx.calligraphy3.BuildConfig;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.LocaleController;

/* loaded from: classes.dex */
public class MessengerInput<T> {
    public String app_version;
    public String auth;
    public MessangerInput2.ClientInfo client;
    public T data;
    public String data_enc;
    public String platform;
    public String tmp_session;
    public String api_version = "4";
    public String method = BuildConfig.FLAVOR;

    public static class DataV5<T> {
        public MessangerInput2.ClientInfo client;
        public T input;
        public String method;
    }

    public MessengerInput(String str) {
        MessangerInput2.ClientInfo clientInfo = new MessangerInput2.ClientInfo();
        this.client = clientInfo;
        this.auth = str;
        clientInfo.app_version = UpdateUtils.getAppVersion(ApplicationLoader.applicationContext);
        MessangerInput2.ClientInfo clientInfo2 = this.client;
        clientInfo2.packageName = org.rbmain.messenger.BuildConfig.APPLICATION_ID;
        clientInfo2.lang_code = LocaleController.getInstance().getCurrentLocale().getLanguage();
        if (MyLog.isDebugAble) {
            MessangerInput2.ClientInfo clientInfo3 = this.client;
            clientInfo3.packageName = clientInfo3.packageName.replace(".debug", BuildConfig.FLAVOR);
        }
        this.client.app_name = "Main";
    }

    public void setBookStoreInput() {
        this.api_version = "0";
    }

    public void setCommentInput() {
        this.api_version = "0";
    }

    public void setAppStoreInput() {
        this.api_version = "0";
    }

    public void setIptvInput() {
        this.api_version = "0";
    }

    public void setSettingInput() {
        this.api_version = "1";
    }

    public void setBasketInput() {
        this.api_version = "0";
    }

    public void setPaymentInput() {
        this.api_version = "1";
    }

    public void setBarcodeInput() {
        this.api_version = "0";
    }

    public void setGameInput() {
        this.api_version = "0";
    }

    public void setVodInput() {
        this.api_version = "1";
    }

    public void setWebAppInput() {
        this.api_version = "1";
    }

    public void makeData() {
        String str;
        if (MyLog.isDebugAble) {
            Thread.currentThread();
            ApplicationLoader.applicationHandler.getLooper().getThread();
        }
        if (this.data == null || (str = this.auth) == null || str.isEmpty()) {
            return;
        }
        String json = ApplicationLoader.getGson().toJson(this.data);
        try {
            this.data_enc = EncryptionHelper.encryptAuth(json, this.auth);
            if (MyLog.isDebugAble) {
                MyLog.e("LogAPIMessenger", json);
            }
            this.data = null;
        } catch (Exception unused) {
        }
    }

    public void makeDataV5() {
        String str;
        if (MyLog.isDebugAble) {
            Thread.currentThread();
            ApplicationLoader.applicationHandler.getLooper().getThread();
        }
        if (this.data_enc != null) {
            return;
        }
        String str2 = this.auth;
        if (str2 != null && !str2.isEmpty()) {
            str = this.auth;
        } else {
            String str3 = this.tmp_session;
            str = (str3 == null || str3.isEmpty()) ? null : this.tmp_session;
        }
        if (str != null) {
            DataV5 dataV5 = new DataV5();
            dataV5.client = this.client;
            this.client = null;
            dataV5.method = this.method;
            this.method = null;
            dataV5.input = this.data;
            this.api_version = "5";
            String json = ApplicationLoader.getGson().toJson(dataV5);
            try {
                this.data_enc = EncryptionHelper.encryptAuth(json, str);
                if (MyLog.isDebugAble) {
                    MyLog.e("LogAPIMessenger json Input", json);
                }
                this.data = null;
            } catch (Exception unused) {
            }
        }
    }
}
