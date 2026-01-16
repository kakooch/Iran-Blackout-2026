package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class akl implements agu {
    final /* synthetic */ Class a;
    final /* synthetic */ agt b;

    akl(Class cls, agt agtVar) {
        this.a = cls;
        this.b = agtVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agu
    public final <T2> agt<T2> a(age ageVar, akz<T2> akzVar) {
        Class<? super T2> clsA = akzVar.a();
        if (this.a.isAssignableFrom(clsA)) {
            return new akk(this, clsA);
        }
        return null;
    }

    public final String toString() {
        return "Factory[typeHierarchy=" + this.a.getName() + ",adapter=" + this.b + "]";
    }
}
