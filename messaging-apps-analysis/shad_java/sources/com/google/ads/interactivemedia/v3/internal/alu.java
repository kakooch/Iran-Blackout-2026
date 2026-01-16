package com.google.ads.interactivemedia.v3.internal;

import android.os.AsyncTask;
import android.os.Build;
import com.google.ads.interactivemedia.v3.api.StreamRequest;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class alu extends AsyncTask<Void, Void, als> {
    final /* synthetic */ alv a;
    private final StreamRequest b;
    private final String c;

    alu(alv alvVar, StreamRequest streamRequest, String str) {
        this.a = alvVar;
        this.b = streamRequest;
        this.c = str;
    }

    @Override // android.os.AsyncTask
    protected final /* bridge */ /* synthetic */ als doInBackground(Void[] voidArr) {
        String strA;
        synchronized (this.a.m) {
            if (this.a.n == null) {
                alv alvVar = this.a;
                alvVar.n = new apk(apj.q(alvVar.a));
            }
            strA = this.a.n.b().a(this.a.a);
        }
        return new als(new aon(this.a.a), strA, alv.e(this.a));
    }

    @Override // android.os.AsyncTask
    protected final /* bridge */ /* synthetic */ void onPostExecute(als alsVar) {
        als alsVar2 = alsVar;
        amx amxVar = new amx(amv.adsLoader, amw.requestStream, this.c, com.google.ads.interactivemedia.v3.impl.data.bd.createFromStreamRequest(this.b, String.format("android%s:%s:%s", Build.VERSION.RELEASE, "3.21.0", this.a.a.getPackageName()), alsVar2.a, alv.g(this.a), this.a.i, alv.i(this.a), yy.g(this.a.a, this.a.j), alsVar2.c, alsVar2.b, this.a.k));
        this.a.b.q();
        this.a.b.n(amxVar);
    }
}
