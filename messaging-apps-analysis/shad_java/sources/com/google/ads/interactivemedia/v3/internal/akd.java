package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class akd extends agt<agj> {
    akd() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final agj read(alb albVar) throws IOException {
        int iP = albVar.p();
        int i = iP - 1;
        if (iP == 0) {
            throw null;
        }
        if (i == 0) {
            agh aghVar = new agh();
            albVar.a();
            while (albVar.e()) {
                aghVar.a(read(albVar));
            }
            albVar.b();
            return aghVar;
        }
        if (i == 2) {
            agm agmVar = new agm();
            albVar.c();
            while (albVar.e()) {
                agmVar.a(albVar.f(), read(albVar));
            }
            albVar.d();
            return agmVar;
        }
        if (i == 5) {
            return new ago(albVar.g());
        }
        if (i == 6) {
            return new ago(new ahu(albVar.g()));
        }
        if (i == 7) {
            return new ago(Boolean.valueOf(albVar.h()));
        }
        if (i != 8) {
            throw new IllegalArgumentException();
        }
        albVar.i();
        return agl.a;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final void write(ald aldVar, agj agjVar) throws IOException {
        if (agjVar == null || (agjVar instanceof agl)) {
            aldVar.g();
            return;
        }
        if (agjVar instanceof ago) {
            ago agoVar = (ago) agjVar;
            if (agoVar.e()) {
                aldVar.j(agoVar.f());
                return;
            } else if (agoVar.b()) {
                aldVar.l(agoVar.d());
                return;
            } else {
                aldVar.k(agoVar.h());
                return;
            }
        }
        if (agjVar instanceof agh) {
            aldVar.b();
            Iterator<agj> it = ((agh) agjVar).iterator();
            while (it.hasNext()) {
                write(aldVar, it.next());
            }
            aldVar.d();
            return;
        }
        if (!(agjVar instanceof agm)) {
            throw new IllegalArgumentException("Couldn't write " + agjVar.getClass());
        }
        aldVar.c();
        for (Map.Entry<String, agj> entry : ((agm) agjVar).b()) {
            aldVar.f(entry.getKey());
            write(aldVar, entry.getValue());
        }
        aldVar.e();
    }
}
