package ir.aaap.messengercore.network;

import ir.aaap.messengercore.network.NetworkHelper;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public interface Network {

    public interface BodyResponseListener {
        void onError(Exception exc);

        void onResponse(int i, byte[] bArr);
    }

    public interface NetworkErrorListener {
        void handleError(ApiServerException apiServerException, Object obj);

        void onGetFileError(String str);

        void onInvalidAuth();

        void onNetworkError(boolean z);

        void onNotRegistered();

        void onShowMessage(Object obj);
    }

    public interface ResponseListener {
        void onError(Exception exc);

        void onResponse(String str);
    }

    void cancelCall(int i);

    void checkDisposables();

    void disposeObservables();

    int getBytes(String str, String str2, RetryObject retryObject, BodyResponseListener bodyResponseListener) throws Exception;

    int getBytes(String str, String str2, HashMap<String, String> map, RetryObject retryObject, BodyResponseListener bodyResponseListener) throws Exception;

    int getBytesCdn(String str, String str2, String str3, HashMap<String, String> map, RetryObject retryObject, BodyResponseListener bodyResponseListener) throws Exception;

    String getDefaultDcMessUrl();

    String getDefaultMessengerUrl();

    String getDefaultSocketUrl();

    void init(String str);

    int sendBytes(String str, String str2, byte[] bArr, HashMap<String, String> map, RetryObject retryObject, ResponseListener responseListener) throws Exception;

    int sendTempSessionV6(String str, String str2, JSONObject jSONObject, RetryObject retryObject, ResponseListener responseListener) throws Exception;

    int sendV4(String str, String str2, String str3, JSONObject jSONObject, RetryObject retryObject, ResponseListener responseListener) throws Exception;

    int sendV5(String str, String str2, JSONObject jSONObject, RetryObject retryObject, ResponseListener responseListener) throws Exception;

    int sendV5OrV6(String str, String str2, String str3, JSONObject jSONObject, RetryObject retryObject, ResponseListener responseListener) throws Exception;

    int sendV5OrV6(String str, String str2, JSONObject jSONObject, RetryObject retryObject, ResponseListener responseListener) throws Exception;

    void setMessengerUrl(String str);

    void setNetworkErrorListener(NetworkErrorListener networkErrorListener);

    void setVersionHelper(NetworkHelper.VersionEncryptionHelper versionEncryptionHelper);
}
