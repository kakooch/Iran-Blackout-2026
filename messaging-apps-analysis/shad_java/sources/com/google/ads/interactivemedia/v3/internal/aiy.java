package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.ArrayList;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class aiy extends agt<Object> {
    public static final agu a = new aix();
    private final age b;

    aiy(age ageVar) {
        this.b = ageVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final Object read(alb albVar) throws IOException {
        int iP = albVar.p();
        int i = iP - 1;
        if (iP == 0) {
            throw null;
        }
        if (i == 0) {
            ArrayList arrayList = new ArrayList();
            albVar.a();
            while (albVar.e()) {
                arrayList.add(read(albVar));
            }
            albVar.b();
            return arrayList;
        }
        if (i == 2) {
            aic aicVar = new aic();
            albVar.c();
            while (albVar.e()) {
                aicVar.put(albVar.f(), read(albVar));
            }
            albVar.d();
            return aicVar;
        }
        if (i == 5) {
            return albVar.g();
        }
        if (i == 6) {
            return Double.valueOf(albVar.j());
        }
        if (i == 7) {
            return Boolean.valueOf(albVar.h());
        }
        if (i != 8) {
            throw new IllegalStateException();
        }
        albVar.i();
        return null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final void write(ald aldVar, Object obj) throws IOException {
        if (obj == null) {
            aldVar.g();
            return;
        }
        agt agtVarD = this.b.d(obj.getClass());
        if (!(agtVarD instanceof aiy)) {
            agtVarD.write(aldVar, obj);
        } else {
            aldVar.c();
            aldVar.e();
        }
    }
}
