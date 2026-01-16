package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import com.google.ads.interactivemedia.v3.api.AdsRequest;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class alq extends AsyncTask<String, Void, alr> {
    final /* synthetic */ alv a;
    private final AdsRequest b;
    private final String c;

    alq(alv alvVar, AdsRequest adsRequest, String str) {
        this.a = alvVar;
        this.b = adsRequest;
        this.c = str;
    }

    @Override // android.os.AsyncTask
    protected final /* bridge */ /* synthetic */ alr doInBackground(String[] strArr) {
        String string = strArr[0];
        synchronized (this.a.m) {
            if (this.a.n == null) {
                alv alvVar = this.a;
                alvVar.n = new apk(apj.q(alvVar.a));
            }
            if (string != null) {
                Uri uri = Uri.parse(string);
                if (this.a.n.a(uri)) {
                    try {
                        string = this.a.n.c(uri, this.a.a).toString();
                    } catch (apl unused) {
                    }
                }
            }
        }
        return new alr(new aon(this.a.a), string, alv.e(this.a));
    }

    @Override // android.os.AsyncTask
    protected final /* bridge */ /* synthetic */ void onPostExecute(alr alrVar) {
        alr alrVar2 = alrVar;
        this.b.setAdTagUrl(alrVar2.a);
        amx amxVar = new amx(amv.adsLoader, amw.requestAds, this.c, com.google.ads.interactivemedia.v3.impl.data.bd.create(this.b, String.format("android%s:%s:%s", Build.VERSION.RELEASE, "3.21.0", this.a.a.getPackageName()), alrVar2.b, alv.g(this.a), this.a.i, alv.i(this.a), yy.g(this.a.a, this.a.j), alrVar2.c, this.a.l));
        this.a.b.q();
        this.a.b.n(amxVar);
    }
}
