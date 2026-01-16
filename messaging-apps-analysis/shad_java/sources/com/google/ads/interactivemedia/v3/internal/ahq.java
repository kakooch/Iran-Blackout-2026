package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ahq extends agt {
    final /* synthetic */ boolean a;
    final /* synthetic */ boolean b;
    final /* synthetic */ age c;
    final /* synthetic */ akz d;
    final /* synthetic */ ahr e;
    private agt f;

    ahq(ahr ahrVar, boolean z, boolean z2, age ageVar, akz akzVar) {
        this.e = ahrVar;
        this.a = z;
        this.b = z2;
        this.c = ageVar;
        this.d = akzVar;
    }

    private final agt a() {
        agt agtVar = this.f;
        if (agtVar != null) {
            return agtVar;
        }
        agt agtVarC = this.c.c(this.e, this.d);
        this.f = agtVarC;
        return agtVarC;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final Object read(alb albVar) throws IOException {
        if (!this.a) {
            return a().read(albVar);
        }
        albVar.m();
        return null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final void write(ald aldVar, Object obj) throws IOException {
        if (this.b) {
            aldVar.g();
        } else {
            a().write(aldVar, obj);
        }
    }
}
