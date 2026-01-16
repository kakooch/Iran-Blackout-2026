package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class aiv<K, V> extends agt<Map<K, V>> {
    final /* synthetic */ aiw a;
    private final agt<K> b;
    private final agt<V> c;
    private final aid<? extends Map<K, V>> d;

    public aiv(aiw aiwVar, age ageVar, Type type, agt<K> agtVar, Type type2, agt<V> agtVar2, aid<? extends Map<K, V>> aidVar) {
        this.a = aiwVar;
        this.b = new ajj(ageVar, agtVar, type);
        this.c = new ajj(ageVar, agtVar2, type2);
        this.d = aidVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final /* bridge */ /* synthetic */ Object read(alb albVar) throws IOException {
        int iP = albVar.p();
        if (iP == 9) {
            albVar.i();
            return null;
        }
        Map<K, V> mapA = this.d.a();
        if (iP == 1) {
            albVar.a();
            while (albVar.e()) {
                albVar.a();
                K k = this.b.read(albVar);
                if (mapA.put(k, this.c.read(albVar)) != null) {
                    throw new agq("duplicate key: " + k);
                }
                albVar.b();
            }
            albVar.b();
        } else {
            albVar.c();
            while (albVar.e()) {
                aht.a.a(albVar);
                K k2 = this.b.read(albVar);
                if (mapA.put(k2, this.c.read(albVar)) != null) {
                    throw new agq("duplicate key: " + k2);
                }
            }
            albVar.d();
        }
        return mapA;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final /* bridge */ /* synthetic */ void write(ald aldVar, Object obj) throws IOException {
        Map map = (Map) obj;
        if (map == null) {
            aldVar.g();
            return;
        }
        boolean z = this.a.a;
        aldVar.c();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            aldVar.f(String.valueOf(entry.getKey()));
            this.c.write(aldVar, entry.getValue());
        }
        aldVar.e();
    }
}
