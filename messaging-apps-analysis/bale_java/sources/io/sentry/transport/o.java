package io.sentry.transport;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.SIPHeaderNames;
import io.sentry.C3134j2;
import io.sentry.C3155n3;
import io.sentry.C3227y1;
import io.sentry.ILogger;
import io.sentry.Y2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes3.dex */
final class o {
    private static final Charset e = Charset.forName("UTF-8");
    private final Proxy a;
    private final C3227y1 b;
    private final C3155n3 c;
    private final A d;

    public o(C3155n3 c3155n3, C3227y1 c3227y1, A a) {
        this(c3155n3, c3227y1, m.a(), a);
    }

    private void a(HttpURLConnection httpURLConnection) {
        try {
            httpURLConnection.getInputStream().close();
        } catch (IOException unused) {
        } catch (Throwable th) {
            httpURLConnection.disconnect();
            throw th;
        }
        httpURLConnection.disconnect();
    }

    private HttpURLConnection b() throws IOException {
        HttpURLConnection httpURLConnectionE = e();
        for (Map.Entry entry : this.b.a().entrySet()) {
            httpURLConnectionE.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        httpURLConnectionE.setRequestMethod("POST");
        httpURLConnectionE.setDoOutput(true);
        httpURLConnectionE.setRequestProperty(SIPHeaderNames.CONTENT_ENCODING, "gzip");
        httpURLConnectionE.setRequestProperty(SIPHeaderNames.CONTENT_TYPE, "application/x-sentry-envelope");
        httpURLConnectionE.setRequestProperty(SIPHeaderNames.ACCEPT, "application/json");
        httpURLConnectionE.setRequestProperty("Connection", "close");
        httpURLConnectionE.setConnectTimeout(this.c.getConnectionTimeoutMillis());
        httpURLConnectionE.setReadTimeout(this.c.getReadTimeoutMillis());
        SSLSocketFactory sslSocketFactory = this.c.getSslSocketFactory();
        if ((httpURLConnectionE instanceof HttpsURLConnection) && sslSocketFactory != null) {
            ((HttpsURLConnection) httpURLConnectionE).setSSLSocketFactory(sslSocketFactory);
        }
        httpURLConnectionE.connect();
        return httpURLConnectionE;
    }

    private String c(HttpURLConnection httpURLConnection) throws IOException {
        try {
            InputStream errorStream = httpURLConnection.getErrorStream();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(errorStream, e));
                try {
                    StringBuilder sb = new StringBuilder();
                    boolean z = true;
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        if (!z) {
                            sb.append(Separators.RETURN);
                        }
                        sb.append(line);
                        z = false;
                    }
                    String string = sb.toString();
                    bufferedReader.close();
                    if (errorStream != null) {
                        errorStream.close();
                    }
                    return string;
                } finally {
                }
            } finally {
            }
        } catch (IOException unused) {
            return "Failed to obtain error message while analyzing send failure.";
        }
    }

    private boolean d(int i) {
        return i == 200;
    }

    private C f(HttpURLConnection httpURLConnection) {
        try {
            try {
                int responseCode = httpURLConnection.getResponseCode();
                i(httpURLConnection, responseCode);
                if (d(responseCode)) {
                    this.c.getLogger().c(Y2.DEBUG, "Envelope sent successfully.", new Object[0]);
                    C cE = C.e();
                    a(httpURLConnection);
                    return cE;
                }
                ILogger logger = this.c.getLogger();
                Y2 y2 = Y2.ERROR;
                logger.c(y2, "Request failed, API returned %s", Integer.valueOf(responseCode));
                if (this.c.isDebug()) {
                    this.c.getLogger().c(y2, "%s", c(httpURLConnection));
                }
                C cB = C.b(responseCode);
                a(httpURLConnection);
                return cB;
            } catch (IOException e2) {
                this.c.getLogger().a(Y2.ERROR, e2, "Error reading and logging the response stream", new Object[0]);
                a(httpURLConnection);
                return C.a();
            }
        } catch (Throwable th) {
            a(httpURLConnection);
            throw th;
        }
    }

    private Proxy g(C3155n3.j jVar) {
        if (jVar != null) {
            String strC = jVar.c();
            String strA = jVar.a();
            if (strC != null && strA != null) {
                try {
                    return new Proxy(jVar.d() != null ? jVar.d() : Proxy.Type.HTTP, new InetSocketAddress(strA, Integer.parseInt(strC)));
                } catch (NumberFormatException e2) {
                    this.c.getLogger().a(Y2.ERROR, e2, "Failed to parse Sentry Proxy port: " + jVar.c() + ". Proxy is ignored", new Object[0]);
                }
            }
        }
        return null;
    }

    HttpURLConnection e() {
        return (HttpURLConnection) (this.a == null ? this.b.b().openConnection() : this.b.b().openConnection(this.a));
    }

    public C h(C3134j2 c3134j2) {
        C cF;
        this.c.getSocketTagger().b();
        try {
            OutputStream outputStream = b().getOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                try {
                    this.c.getSerializer().b(c3134j2, gZIPOutputStream);
                    gZIPOutputStream.close();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                } finally {
                }
            } finally {
            }
        } finally {
            try {
            } finally {
            }
        }
        return cF;
    }

    public void i(HttpURLConnection httpURLConnection, int i) {
        String headerField = httpURLConnection.getHeaderField(SIPHeaderNames.RETRY_AFTER);
        this.d.H(httpURLConnection.getHeaderField("X-Sentry-Rate-Limits"), headerField, i);
    }

    o(C3155n3 c3155n3, C3227y1 c3227y1, m mVar, A a) {
        this.b = c3227y1;
        this.c = c3155n3;
        this.d = a;
        Proxy proxyG = g(c3155n3.getProxy());
        this.a = proxyG;
        if (proxyG == null || c3155n3.getProxy() == null) {
            return;
        }
        String strE = c3155n3.getProxy().e();
        String strB = c3155n3.getProxy().b();
        if (strE == null || strB == null) {
            return;
        }
        mVar.b(new v(strE, strB));
    }
}
