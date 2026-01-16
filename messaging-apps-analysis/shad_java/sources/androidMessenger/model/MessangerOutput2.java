package androidMessenger.model;

import androidMessenger.network.EncryptionHelper;
import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class MessangerOutput2 {
    private static final Gson jsonHelper = new Gson();
    public String cache = null;
    public Object client_show_message;
    public String data;
    public String data_enc;
    public Object message_data;
    public EnumStatus status;
    public EnumStatusDet status_det;

    public static class ClientShowMessage {
        public ir.aaap.messengercore.model.Link link;
        public String unique_id;
    }

    public enum EnumStatus {
        OK,
        ERROR_BAD_ENC,
        ERROR_TRY_AGAIN,
        ERROR_IGNORE,
        ERROR_MESSAGE_TRY,
        ERROR_MESSAGE_IGN,
        ERROR_GENERIC,
        ERROR_ACTION,
        NOT_REGISTERED
    }

    public enum EnumStatusDet {
        OK,
        INVALID_INPUT,
        NOT_SUPPORTED_API_VERSION,
        SERVER_ERROR,
        INVALID_METHOD,
        CODE_IS_USED,
        NOT_REGISTERED,
        INVALID_AUTH,
        CODE_IS_EXPIRED,
        USERNAME_NOT_EXIST,
        TOO_REQUESTS,
        SHOW_MESSAGE
    }

    public void makeData(String str) {
        String str2;
        if (this.data != null || (str2 = this.data_enc) == null) {
            return;
        }
        try {
            this.data = EncryptionHelper.decryptAuth(str2, str);
        } catch (Exception unused) {
            this.status = EnumStatus.ERROR_BAD_ENC;
        }
    }

    public static MessangerOutput2 getFromJsonV4(JSONObject jSONObject, String str) throws JSONException {
        MessangerOutput2 messangerOutput2 = new MessangerOutput2();
        if (jSONObject.has("status")) {
            messangerOutput2.status = EnumStatus.valueOf(jSONObject.getString("status"));
        }
        if (jSONObject.has("status_det")) {
            messangerOutput2.status_det = EnumStatusDet.valueOf(jSONObject.getString("status_det"));
        }
        if (jSONObject.has("data_enc")) {
            messangerOutput2.data_enc = jSONObject.getString("data_enc");
        }
        if (jSONObject.has("data")) {
            messangerOutput2.data = jSONObject.getString("data");
        }
        if (jSONObject.has("client_show_message")) {
            messangerOutput2.client_show_message = jSONObject.get("client_show_message");
        }
        messangerOutput2.makeData(str);
        return messangerOutput2;
    }

    public static MessangerOutput2 getFromJson(JSONObject jSONObject, String str, String str2) throws JSONException {
        if (str == null) {
            str = str2;
        }
        if (jSONObject.has("status") || jSONObject.has("status_det")) {
            return getFromJsonV4(jSONObject, str);
        }
        return getFromJsonV5(jSONObject, str);
    }

    private static MessangerOutput2 getFromJsonV5(JSONObject jSONObject, String str) {
        MessangerOutput2 messangerOutput2 = new MessangerOutput2();
        try {
            if (jSONObject.has("data_enc")) {
                messangerOutput2.data_enc = jSONObject.getString("data_enc");
            }
            if (jSONObject.has("data")) {
                messangerOutput2.data = jSONObject.getString("data");
            }
            messangerOutput2.makeData(str);
            JSONObject jSONObject2 = new JSONObject(messangerOutput2.data);
            if (jSONObject2.has("status")) {
                messangerOutput2.status = EnumStatus.valueOf(jSONObject2.getString("status"));
            }
            if (jSONObject2.has("status_det")) {
                messangerOutput2.status_det = EnumStatusDet.valueOf(jSONObject2.getString("status_det"));
            }
            if (jSONObject2.has("client_show_message")) {
                messangerOutput2.client_show_message = jSONObject2.get("client_show_message");
            }
        } catch (Exception unused) {
        }
        return messangerOutput2;
    }
}
