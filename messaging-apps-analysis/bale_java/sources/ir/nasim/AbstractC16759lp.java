package ir.nasim;

import ir.nasim.core.runtime.http.HTTPError;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import javax.net.ssl.HttpsURLConnection;

/* renamed from: ir.nasim.lp, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC16759lp implements InterfaceC18376oZ2 {
    private final String a = "AndroidHttpProvider";
    private final int b = 128000;
    private final int c = 15000;

    private HttpURLConnection c(String str, String str2) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        if (str.startsWith("https")) {
            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(D86.a(str, "SHA256:" + str2));
        }
        return httpURLConnection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(String str, String str2, Integer num, String[] strArr, String[] strArr2, String str3, byte[] bArr, C7234Qv5 c7234Qv5) throws IOException {
        int length;
        HttpURLConnection httpURLConnection = null;
        byte[] bArr2 = null;
        try {
            HttpURLConnection httpURLConnectionC = c(str, str2);
            try {
                httpURLConnectionC.setRequestMethod("POST");
                httpURLConnectionC.setConnectTimeout(15000);
                if (num != null) {
                    httpURLConnectionC.setReadTimeout(num.intValue());
                }
                for (int i = 0; i < strArr.length; i++) {
                    httpURLConnectionC.setRequestProperty(strArr[i], strArr2[i]);
                }
                httpURLConnectionC.setRequestProperty("Content-type", str3);
                if (bArr.length > 0) {
                    httpURLConnectionC.setDoOutput(true);
                    httpURLConnectionC.setFixedLengthStreamingMode(bArr.length);
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnectionC.getOutputStream());
                    int iMin = 0;
                    while (iMin < bArr.length) {
                        bufferedOutputStream.write(bArr, iMin, Math.min(128000, bArr.length - iMin));
                        iMin += Math.min(128000, bArr.length - iMin);
                    }
                    bufferedOutputStream.flush();
                }
                int responseCode = httpURLConnectionC.getResponseCode();
                HashMap map = new HashMap();
                if (responseCode < 200 || responseCode >= 300) {
                    C19406qI3.a("AndroidHttpProvider", "error in http postMethod", new Object[0]);
                    c7234Qv5.a(new HTTPError(httpURLConnectionC.getResponseCode(), YS2.b(map)));
                    return;
                }
                int contentLength = httpURLConnectionC.getContentLength();
                if (contentLength > 0) {
                    byte[] bArr3 = new byte[contentLength];
                    int i2 = 0;
                    while (i2 < contentLength) {
                        int i3 = httpURLConnectionC.getInputStream().read(bArr3, i2, contentLength - i2);
                        if (i3 > 0) {
                            i2 += i3;
                        }
                    }
                    for (String str4 : httpURLConnectionC.getHeaderFields().keySet()) {
                        if (str4 != null) {
                            map.put(str4, httpURLConnectionC.getHeaderFields().get(str4));
                        }
                    }
                    c7234Qv5.b(new ZS2(httpURLConnectionC.getResponseCode(), bArr3, YS2.b(map)));
                    return;
                }
                byte[] bArr4 = new byte[128000];
                int i4 = 0;
                while (i4 >= 0) {
                    i4 = httpURLConnectionC.getInputStream().read(bArr4, 0, 128000);
                    if (i4 > 0) {
                        byte[] bArr5 = bArr2 == null ? new byte[i4] : new byte[bArr2.length + i4];
                        if (bArr2 != null) {
                            length = bArr2.length;
                            System.arraycopy(bArr2, 0, bArr5, 0, length);
                        } else {
                            length = 0;
                        }
                        System.arraycopy(bArr4, 0, bArr5, length, i4);
                        bArr2 = bArr5;
                    }
                }
                for (String str5 : httpURLConnectionC.getHeaderFields().keySet()) {
                    if (str5 != null) {
                        map.put(str5, httpURLConnectionC.getHeaderFields().get(str5));
                    }
                }
                c7234Qv5.b(new ZS2(httpURLConnectionC.getResponseCode(), bArr2, YS2.b(map)));
            } catch (Exception e) {
                e = e;
                httpURLConnection = httpURLConnectionC;
                C19406qI3.d("AndroidHttpProvider", e);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                c7234Qv5.a(new HTTPError(0));
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    @Override // ir.nasim.InterfaceC18376oZ2
    public C6517Nv5 a(final String str, final String str2, final String str3, final byte[] bArr, final String[] strArr, final String[] strArr2, final Integer num) {
        return new C6517Nv5(new InterfaceC6990Pv5() { // from class: ir.nasim.kp
            @Override // ir.nasim.InterfaceC6990Pv5
            public final void a(C7234Qv5 c7234Qv5) throws IOException {
                this.a.d(str, str2, num, strArr, strArr2, str3, bArr, c7234Qv5);
            }
        });
    }
}
