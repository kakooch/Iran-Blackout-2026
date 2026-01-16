package com.google.android.gms.measurement.internal;

import android.os.Build;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzhr extends zzgf {
    private final SSLSocketFactory zza;

    zzhr(zzfl zzflVar) {
        super(zzflVar);
        this.zza = Build.VERSION.SDK_INT < 19 ? new zzkm(HttpsURLConnection.getDefaultSSLSocketFactory()) : null;
    }

    @Override // com.google.android.gms.measurement.internal.zzgf
    protected final boolean zza() {
        return false;
    }

    protected final HttpURLConnection zzd(URL url) throws IOException {
        URLConnection uRLConnectionOpenConnection = url.openConnection();
        if (!(uRLConnectionOpenConnection instanceof HttpURLConnection)) {
            throw new IOException("Failed to obtain HTTP connection");
        }
        SSLSocketFactory sSLSocketFactory = this.zza;
        if (sSLSocketFactory != null && (uRLConnectionOpenConnection instanceof HttpsURLConnection)) {
            ((HttpsURLConnection) uRLConnectionOpenConnection).setSSLSocketFactory(sSLSocketFactory);
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        httpURLConnection.setDefaultUseCaches(false);
        this.zzx.zzc();
        httpURLConnection.setConnectTimeout(60000);
        this.zzx.zzc();
        httpURLConnection.setReadTimeout(61000);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setDoInput(true);
        return httpURLConnection;
    }
}
