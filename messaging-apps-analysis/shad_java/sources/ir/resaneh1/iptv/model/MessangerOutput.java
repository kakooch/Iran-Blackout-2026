package ir.resaneh1.iptv.model;

import com.google.gson.reflect.TypeToken;
import ir.resaneh1.iptv.apiMessanger.ApiServerException;
import ir.resaneh1.iptv.helper.AppPreferences;
import ir.resaneh1.iptv.helper.EncryptionHelper;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.Link;
import java.lang.reflect.Type;
import org.rbmain.messenger.ApplicationLoader;

/* loaded from: classes3.dex */
public class MessangerOutput<T> {
    public String cache = null;
    public ClientShowMessage client_show_message;
    public T data;
    public String data_enc;
    public Link.AlertData message_data;
    public EnumStatus status;
    public EnumStatusDet status_det;

    public static class ClientShowMessage {
        public Link link;
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

    public void makeData(int i, Class<?> cls) {
        if (this.data != null || this.data_enc == null) {
            return;
        }
        try {
            new TypeToken<T>(this) { // from class: ir.resaneh1.iptv.model.MessangerOutput.1
            };
            this.data = (T) ApplicationLoader.getGson().fromJson(EncryptionHelper.decryptAuth(this.data_enc, AppPreferences.getInstance(i).getAuth()), (Class) cls);
        } catch (Exception unused) {
            this.status = EnumStatus.ERROR_BAD_ENC;
        }
    }

    public void makeDataT(Class<?> cls, String str) throws ApiServerException {
        String str2;
        if (this.data != null || (str2 = this.data_enc) == null) {
            return;
        }
        try {
            this.data = (T) ApplicationLoader.getGson().fromJson(EncryptionHelper.decryptAuth(str2, str), (Class) cls);
        } catch (Exception unused) {
            throw new ApiServerException(EnumStatus.ERROR_BAD_ENC, EnumStatusDet.SERVER_ERROR);
        }
    }

    public void makeDataV5(TypeToken typeToken, String str) throws ApiServerException {
        if (this.data != null || this.data_enc == null) {
            return;
        }
        try {
            Type type = typeToken.getType();
            String strDecryptAuth = EncryptionHelper.decryptAuth(this.data_enc, str);
            DataOutputV5 dataOutputV5 = (DataOutputV5) ApplicationLoader.getGson().fromJson(strDecryptAuth, type);
            if (MyLog.isDebugAble) {
                MyLog.e("LogAPIMessenger json output", strDecryptAuth);
            }
            this.data = dataOutputV5.data;
            this.status = dataOutputV5.status;
            this.status_det = dataOutputV5.status_det;
            this.client_show_message = dataOutputV5.client_show_message;
        } catch (Exception unused) {
            throw new ApiServerException(EnumStatus.ERROR_BAD_ENC, EnumStatusDet.SERVER_ERROR);
        }
    }
}
