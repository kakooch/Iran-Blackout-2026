package io.sentry;

import android.gov.nist.javax.sip.header.SIPHeaderNames;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import io.sentry.C3155n3;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.concurrent.RejectedExecutionException;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes3.dex */
public final class SpotlightIntegration implements InterfaceC3157o0, C3155n3.b, Closeable {
    private C3155n3 a;
    private ILogger b = L0.e();
    private InterfaceC3097c0 c = X0.f();

    private void d(HttpURLConnection httpURLConnection) {
        try {
            httpURLConnection.getInputStream().close();
        } catch (IOException unused) {
        } catch (Throwable th) {
            httpURLConnection.disconnect();
            throw th;
        }
        httpURLConnection.disconnect();
    }

    private HttpURLConnection e(String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) URI.create(str).toURL().openConnection();
        httpURLConnection.setReadTimeout(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT);
        httpURLConnection.setConnectTimeout(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestProperty(SIPHeaderNames.CONTENT_ENCODING, "gzip");
        httpURLConnection.setRequestProperty(SIPHeaderNames.CONTENT_TYPE, "application/x-sentry-envelope");
        httpURLConnection.setRequestProperty(SIPHeaderNames.ACCEPT, "application/json");
        httpURLConnection.setRequestProperty("Connection", "close");
        httpURLConnection.connect();
        return httpURLConnection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void j(C3134j2 c3134j2) throws IOException {
        try {
            if (this.a == null) {
                throw new IllegalArgumentException("SentryOptions are required to send envelopes.");
            }
            HttpURLConnection httpURLConnectionE = e(g());
            try {
                OutputStream outputStream = httpURLConnectionE.getOutputStream();
                try {
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                    try {
                        this.a.getSerializer().b(c3134j2, gZIPOutputStream);
                        gZIPOutputStream.close();
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        this.b.c(Y2.DEBUG, "Envelope sent to spotlight: %d", Integer.valueOf(httpURLConnectionE.getResponseCode()));
                    } finally {
                    }
                } finally {
                }
            } catch (Throwable th) {
                try {
                    this.b.b(Y2.ERROR, "An exception occurred while submitting the envelope to the Sentry server.", th);
                    this.b.c(Y2.DEBUG, "Envelope sent to spotlight: %d", Integer.valueOf(httpURLConnectionE.getResponseCode()));
                } catch (Throwable th2) {
                    this.b.c(Y2.DEBUG, "Envelope sent to spotlight: %d", Integer.valueOf(httpURLConnectionE.getResponseCode()));
                    d(httpURLConnectionE);
                    throw th2;
                }
            }
            d(httpURLConnectionE);
        } catch (Exception e) {
            this.b.b(Y2.ERROR, "An exception occurred while creating the connection to spotlight.", e);
        }
    }

    @Override // io.sentry.C3155n3.b
    public void a(final C3134j2 c3134j2, I i) {
        try {
            this.c.submit(new Runnable() { // from class: io.sentry.P3
                @Override // java.lang.Runnable
                public final void run() throws IOException {
                    this.a.j(c3134j2);
                }
            });
        } catch (RejectedExecutionException e) {
            this.b.b(Y2.WARNING, "Spotlight envelope submission rejected.", e);
        }
    }

    @Override // io.sentry.InterfaceC3157o0
    public void c(Z z, C3155n3 c3155n3) {
        this.a = c3155n3;
        this.b = c3155n3.getLogger();
        if (c3155n3.getBeforeEnvelopeCallback() != null || !c3155n3.isEnableSpotlight()) {
            this.b.c(Y2.DEBUG, "SpotlightIntegration is not enabled. BeforeEnvelopeCallback is already set or spotlight is not enabled.", new Object[0]);
            return;
        }
        this.c = new P2(c3155n3);
        c3155n3.setBeforeEnvelopeCallback(this);
        this.b.c(Y2.DEBUG, "SpotlightIntegration enabled.", new Object[0]);
        io.sentry.util.o.a("Spotlight");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.c.b(0L);
        C3155n3 c3155n3 = this.a;
        if (c3155n3 == null || c3155n3.getBeforeEnvelopeCallback() != this) {
            return;
        }
        this.a.setBeforeEnvelopeCallback(null);
    }

    public String g() {
        C3155n3 c3155n3 = this.a;
        return (c3155n3 == null || c3155n3.getSpotlightConnectionUrl() == null) ? io.sentry.util.w.a() ? "http://10.0.2.2:8969/stream" : "http://localhost:8969/stream" : this.a.getSpotlightConnectionUrl();
    }
}
