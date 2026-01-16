package ir.eitaa.helper.http;

import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.BuildVars;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.tgnet.NativeByteBuffer;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.ui.LoginActivity;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
public class HelperHttp {
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    public static final MediaType TEXT = MediaType.parse("text/stream");
    public static String URL = "https://dev3.eitaa.com/eitaa/index.php";
    private static int connectionTimeout = 60000;
    private static final OkHttpClient httpClient;
    private String url;

    static {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        long j = connectionTimeout;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        httpClient = builder.connectTimeout(j, timeUnit).readTimeout(connectionTimeout, timeUnit).writeTimeout(connectionTimeout, timeUnit).build();
    }

    public HelperHttp(String ip_address, int port, String url) {
        if (BuildVars.DEBUG_PRIVATE_VERSION) {
            try {
                URL = ApplicationLoader.applicationContext.getSharedPreferences("mainconfig", 0).getString("http_url", URL);
            } catch (Exception unused) {
            }
        }
        this.url = (port == 443 ? "https" : "http").concat("://").concat(ip_address == null ? "armita.eitaa.com" : ip_address).concat(":").concat(String.valueOf(port)).concat(url);
        new LoginActivity();
    }

    public NativeByteBuffer send(TLObject object, byte[] request) {
        Request requestBuild;
        Response responseExecute;
        try {
            requestBuild = new Request.Builder().url(this.url).post(RequestBody.create(TEXT, request)).build();
        } catch (Exception e) {
            FileLog.e("HelperHttp", e);
            requestBuild = new Request.Builder().url("https://armita.eitaa.com/eitaa/index.php").post(RequestBody.create(TEXT, request)).build();
        }
        try {
            responseExecute = httpClient.newCall(requestBuild).execute();
        } catch (IOException e2) {
            FileLog.e("HelperHttp/IOException: " + object, e2);
            e2.printStackTrace();
        } catch (Exception e3) {
            FileLog.e("HelperHttp/Exception: " + object, e3);
            e3.printStackTrace();
        }
        if (responseExecute.isSuccessful()) {
            byte[] byteArray = toByteArray(responseExecute.body().byteStream());
            NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(byteArray.length);
            nativeByteBuffer.writeBytes(byteArray);
            nativeByteBuffer.rewind();
            responseExecute.body().close();
            responseExecute.close();
            return nativeByteBuffer;
        }
        FileLog.e("HelperHttp/is_not_successful: " + object + " " + responseExecute.body().string());
        responseExecute.body().close();
        responseExecute.close();
        FileLog.e("response_is_null request: " + object + "server: " + this.url);
        return null;
    }

    public static byte[] toByteArray(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[Factory.DEVICE_HAS_CRAPPY_AAUDIO];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int i = inputStream.read(bArr);
            if (i != -1) {
                byteArrayOutputStream.write(bArr, 0, i);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }
}
