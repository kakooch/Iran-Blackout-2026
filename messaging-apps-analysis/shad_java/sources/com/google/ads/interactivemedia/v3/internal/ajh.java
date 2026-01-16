package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ajh implements agu {
    private final akz<?> a;
    private final boolean b;
    private final agp<?> c;
    private final agi<?> d;

    ajh(Object obj, akz<?> akzVar, boolean z) {
        agp<?> agpVar = obj instanceof agp ? (agp) obj : null;
        this.c = agpVar;
        agi<?> agiVar = obj instanceof agi ? (agi) obj : null;
        this.d = agiVar;
        boolean z2 = true;
        if (agpVar == null && agiVar == null) {
            z2 = false;
        }
        com.google.ads.interactivemedia.v3.impl.data.ax.e(z2);
        this.a = akzVar;
        this.b = z;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agu
    public final <T> agt<T> a(age ageVar, akz<T> akzVar) {
        if (this.a.equals(akzVar) || (this.b && this.a.b() == akzVar.a())) {
            return new aji(this.c, this.d, ageVar, akzVar, this);
        }
        return null;
    }
}
