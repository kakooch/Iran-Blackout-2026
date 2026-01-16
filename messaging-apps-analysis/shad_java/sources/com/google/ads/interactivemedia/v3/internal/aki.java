package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class aki implements agu {
    final /* synthetic */ Class a;
    final /* synthetic */ Class b;
    final /* synthetic */ agt c;

    aki(Class cls, Class cls2, agt agtVar) {
        this.a = cls;
        this.b = cls2;
        this.c = agtVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agu
    public final <T> agt<T> a(age ageVar, akz<T> akzVar) {
        Class<? super T> clsA = akzVar.a();
        if (clsA == this.a || clsA == this.b) {
            return this.c;
        }
        return null;
    }

    public final String toString() {
        return "Factory[type=" + this.b.getName() + "+" + this.a.getName() + ",adapter=" + this.c + "]";
    }
}
