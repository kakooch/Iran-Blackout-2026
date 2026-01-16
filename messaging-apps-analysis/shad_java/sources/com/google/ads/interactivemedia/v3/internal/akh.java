package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class akh implements agu {
    final /* synthetic */ Class a;
    final /* synthetic */ agt b;

    akh(Class cls, agt agtVar) {
        this.a = cls;
        this.b = agtVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agu
    public final <T> agt<T> a(age ageVar, akz<T> akzVar) {
        if (akzVar.a() == this.a) {
            return this.b;
        }
        return null;
    }

    public final String toString() {
        return "Factory[type=" + this.a.getName() + ",adapter=" + this.b + "]";
    }
}
