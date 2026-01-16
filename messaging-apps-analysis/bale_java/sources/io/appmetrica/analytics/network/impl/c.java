package io.appmetrica.analytics.network.impl;

import io.appmetrica.analytics.network.internal.Call;
import io.appmetrica.analytics.network.internal.NetworkClient;
import io.appmetrica.analytics.network.internal.Request;
import io.appmetrica.analytics.network.internal.Response;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C19938rB7;
import ir.nasim.YV0;
import java.io.OutputStream;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes3.dex */
public final class c implements Call {
    public final NetworkClient a;
    public final Request b;
    public final d c;

    public c(NetworkClient networkClient, Request request, d dVar) {
        this.a = networkClient;
        this.b = request;
        this.c = dVar;
    }

    public final void a(HttpsURLConnection httpsURLConnection) throws ProtocolException {
        Iterator<T> it = this.b.getHeaders().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            httpsURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        Integer readTimeout = this.a.getReadTimeout();
        if (readTimeout != null) {
            httpsURLConnection.setReadTimeout(readTimeout.intValue());
        }
        Integer connectTimeout = this.a.getConnectTimeout();
        if (connectTimeout != null) {
            httpsURLConnection.setConnectTimeout(connectTimeout.intValue());
        }
        Boolean useCaches = this.a.getUseCaches();
        if (useCaches != null) {
            httpsURLConnection.setUseCaches(useCaches.booleanValue());
        }
        Boolean instanceFollowRedirects = this.a.getInstanceFollowRedirects();
        if (instanceFollowRedirects != null) {
            httpsURLConnection.setInstanceFollowRedirects(instanceFollowRedirects.booleanValue());
        }
        httpsURLConnection.setRequestMethod(this.b.getMethod());
        SSLSocketFactory sslSocketFactory = this.a.getSslSocketFactory();
        if (sslSocketFactory != null) {
            httpsURLConnection.setSSLSocketFactory(sslSocketFactory);
        }
    }

    @Override // io.appmetrica.analytics.network.internal.Call
    public final Response execute() {
        Map<String, List<String>> headerFields;
        Throwable th;
        int responseCode;
        boolean z;
        Throwable th2;
        byte[] bArr;
        byte[] bArrA;
        int i;
        try {
            d dVar = this.c;
            String url = this.b.getUrl();
            dVar.getClass();
            URLConnection uRLConnectionOpenConnection = new URL(url).openConnection();
            HttpsURLConnection httpsURLConnection = uRLConnectionOpenConnection instanceof HttpsURLConnection ? (HttpsURLConnection) uRLConnectionOpenConnection : null;
            if (httpsURLConnection == null) {
                return new Response(new IllegalArgumentException("Connection created for " + this.b.getUrl() + " does not represent https connection"));
            }
            byte[] bArrA2 = new byte[0];
            byte[] bArr2 = new byte[0];
            try {
                a(httpsURLConnection);
                if (AbstractC13042fc3.d(this.b.getMethod(), "POST")) {
                    httpsURLConnection.setDoOutput(true);
                    OutputStream outputStream = httpsURLConnection.getOutputStream();
                    if (outputStream != null) {
                        try {
                            outputStream.write(this.b.getBody());
                            outputStream.flush();
                            C19938rB7 c19938rB7 = C19938rB7.a;
                            YV0.a(outputStream, null);
                        } finally {
                        }
                    }
                }
                responseCode = httpsURLConnection.getResponseCode();
                try {
                    headerFields = httpsURLConnection.getHeaderFields();
                    try {
                        bArrA2 = e.a(this.a.getMaxResponseSize(), new a(httpsURLConnection));
                        th2 = null;
                        bArr = bArrA2;
                        bArrA = e.a(this.a.getMaxResponseSize(), new b(httpsURLConnection));
                        i = responseCode;
                        z = true;
                    } catch (Throwable th3) {
                        th = th3;
                        z = false;
                        th2 = th;
                        bArr = bArrA2;
                        bArrA = bArr2;
                        i = responseCode;
                        Map<String, List<String>> map = headerFields;
                        httpsURLConnection.disconnect();
                        return new Response(z, i, bArr, bArrA, map, th2);
                    }
                } catch (Throwable th4) {
                    headerFields = null;
                    th = th4;
                }
            } catch (Throwable th5) {
                headerFields = null;
                th = th5;
                responseCode = 0;
            }
            Map<String, List<String>> map2 = headerFields;
            try {
                httpsURLConnection.disconnect();
            } catch (Throwable unused) {
            }
            return new Response(z, i, bArr, bArrA, map2, th2);
        } catch (Throwable th6) {
            return new Response(th6);
        }
    }

    public c(NetworkClient networkClient, Request request) {
        this(networkClient, request, new d());
    }
}
