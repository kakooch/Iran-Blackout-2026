package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class akg implements agu {
    final /* synthetic */ akz a;
    final /* synthetic */ agt b;

    akg(akz akzVar, agt agtVar) {
        this.a = akzVar;
        this.b = agtVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agu
    public final <T> agt<T> a(age ageVar, akz<T> akzVar) {
        if (akzVar.equals(this.a)) {
            return this.b;
        }
        return null;
    }
}
