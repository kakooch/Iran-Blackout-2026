package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class anm implements atn<com.google.ads.interactivemedia.v3.impl.data.bi> {
    final /* synthetic */ String a;
    final /* synthetic */ anp b;

    anm(anp anpVar, String str) {
        this.b = anpVar;
        this.a = str;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.atn
    public final void a(Throwable th) {
        yy.e("Failure to make Native-layer network request", th);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.atn
    public final /* bridge */ /* synthetic */ void b(com.google.ads.interactivemedia.v3.impl.data.bi biVar) {
        this.b.b.n(new amx(amv.nativeXhr, amw.nativeResponse, this.a, biVar));
    }
}
