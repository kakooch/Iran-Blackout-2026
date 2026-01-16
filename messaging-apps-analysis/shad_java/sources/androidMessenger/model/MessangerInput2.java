package androidMessenger.model;

import androidMessenger.network.EncryptionHelper;
import androidMessenger.utilites.MyLog;
import androidMessenger.utilites.UpdateUtils;
import com.google.gson.annotations.SerializedName;
import io.github.inflationx.calligraphy3.BuildConfig;
import java.security.PrivateKey;
import org.json.JSONException;
import org.json.JSONObject;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.LocaleController;

/* loaded from: classes.dex */
public class MessangerInput2 {
    public String auth;
    public ClientInfo client;
    public String data;
    public JSONObject dataJson;
    public String data_enc;
    public String tmp_session;
    public String api_version = "4";
    public String method = BuildConfig.FLAVOR;

    public static class DataV5<T> {
        public ClientInfo client;
        public T input;
        public String method;
    }

    public MessangerInput2(String str) {
        ClientInfo clientInfo = new ClientInfo();
        this.client = clientInfo;
        this.auth = str;
        clientInfo.app_version = UpdateUtils.getAppVersion(ApplicationLoader.applicationContext);
        this.client.lang_code = LocaleController.getInstance().getCurrentLocale().getLanguage();
        ClientInfo clientInfo2 = this.client;
        clientInfo2.packageName = org.rbmain.messenger.BuildConfig.APPLICATION_ID;
        clientInfo2.app_name = "Main";
        clientInfo2.platform = "Android";
    }

    public JSONObject getJsonObject(String str, String str2) throws JSONException {
        this.data = str2;
        this.method = str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("auth", this.auth);
            jSONObject.put("api_version", 4);
            jSONObject.put("client", this.client.getClientJsonObject());
            makeData();
            jSONObject.put("data_enc", this.data_enc);
            jSONObject.put("method", str);
        } catch (JSONException e) {
            MyLog.handleException(e);
        }
        return jSONObject;
    }

    public JSONObject getJsonObjectWithVersion(String str, String str2, JSONObject jSONObject) throws JSONException {
        this.data = jSONObject != null ? jSONObject.toString() : null;
        this.method = str2;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("auth", this.auth);
            jSONObject2.put("api_version", str);
            jSONObject2.put("client", this.client.getClientJsonObject());
            jSONObject2.put("data", jSONObject);
            jSONObject2.put("method", str2);
        } catch (JSONException e) {
            MyLog.handleException(e);
        }
        return jSONObject2;
    }

    public JSONObject getJsonObjectV5(String str, JSONObject jSONObject) throws JSONException {
        this.dataJson = jSONObject;
        this.method = str;
        JSONObject jSONObject2 = new JSONObject();
        try {
            String str2 = this.auth;
            if (str2 != null) {
                jSONObject2.put("auth", str2);
            } else {
                jSONObject2.put("tmp_session", this.tmp_session);
            }
            jSONObject2.put("api_version", 5);
            makeDataV5();
            jSONObject2.put("data_enc", this.data_enc);
        } catch (JSONException e) {
            MyLog.handleException(e);
        }
        return jSONObject2;
    }

    public void makeData() {
        String str;
        if (this.data == null || (str = this.auth) == null || str.isEmpty()) {
            return;
        }
        try {
            this.data_enc = EncryptionHelper.encryptAuth(this.data, this.auth);
            this.data = null;
        } catch (Exception unused) {
        }
    }

    public JSONObject getJsonObjectV6(String str, JSONObject jSONObject, PrivateKey privateKey) throws JSONException {
        JSONObject jsonObjectV5 = getJsonObjectV5(str, jSONObject);
        try {
            jsonObjectV5.put("api_version", 6);
            String str2 = this.auth;
            if (str2 != null) {
                jsonObjectV5.put("auth", EncryptionHelper.encodeChars(str2));
                jsonObjectV5.put("sign", EncryptionHelper.signRsa(privateKey, jsonObjectV5.getString("data_enc")));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jsonObjectV5;
    }

    public void makeDataV5() throws JSONException {
        String str;
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
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("input", this.dataJson);
                jSONObject.put("client", this.client.getClientJsonObject());
                jSONObject.put("method", this.method);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.client = null;
            this.method = null;
            this.api_version = "5";
            try {
                this.data_enc = EncryptionHelper.encryptAuth(jSONObject.toString(), str);
                this.data = null;
                this.dataJson = null;
            } catch (Exception unused) {
            }
        }
    }

    public static class ClientInfo {
        public String app_version;

        @SerializedName("package")
        public String packageName;
        public String platform = "Android";
        public String app_name = "Main";
        public String lang_code = "fa";
        public String temp_code = "27";

        public JSONObject getClientJsonObject() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("app_name", this.app_name);
                jSONObject.put("app_version", this.app_version);
                jSONObject.put("lang_code", this.lang_code);
                jSONObject.put("package", this.packageName);
                jSONObject.put("temp_code", this.temp_code);
                jSONObject.put("platform", this.platform);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
    }
}
