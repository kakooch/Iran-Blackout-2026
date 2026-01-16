package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class aji<T> extends agt<T> {
    final age a;
    private final agp<T> b;
    private final agi<T> c;
    private final akz<T> d;
    private final agu e;
    private final ajg f = new ajg();
    private agt<T> g;

    public aji(agp<T> agpVar, agi<T> agiVar, age ageVar, akz<T> akzVar, agu aguVar) {
        this.b = agpVar;
        this.c = agiVar;
        this.a = ageVar;
        this.d = akzVar;
        this.e = aguVar;
    }

    public static agu a(akz<?> akzVar, Object obj) {
        return new ajh(obj, akzVar, akzVar.b() == akzVar.a());
    }

    private final agt<T> b() {
        agt<T> agtVar = this.g;
        if (agtVar != null) {
            return agtVar;
        }
        agt<T> agtVarC = this.a.c(this.e, this.d);
        this.g = agtVarC;
        return agtVarC;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final T read(alb albVar) throws IOException {
        if (this.c == null) {
            return b().read(albVar);
        }
        if (com.google.ads.interactivemedia.v3.impl.data.ax.a(albVar) instanceof agl) {
            return null;
        }
        agi<T> agiVar = this.c;
        this.d.b();
        return agiVar.a();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final void write(ald aldVar, T t) throws IOException {
        agp<T> agpVar = this.b;
        if (agpVar == null) {
            b().write(aldVar, t);
        } else if (t == null) {
            aldVar.g();
        } else {
            this.d.b();
            com.google.ads.interactivemedia.v3.impl.data.ax.b(agpVar.a(t), aldVar);
        }
    }
}
