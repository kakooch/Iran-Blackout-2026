package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class aim<E> extends agt<Collection<E>> {
    private final agt<E> a;
    private final aid<? extends Collection<E>> b;

    public aim(age ageVar, Type type, agt<E> agtVar, aid<? extends Collection<E>> aidVar) {
        this.a = new ajj(ageVar, agtVar, type);
        this.b = aidVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final /* bridge */ /* synthetic */ Object read(alb albVar) throws IOException {
        if (albVar.p() == 9) {
            albVar.i();
            return null;
        }
        Collection<E> collectionA = this.b.a();
        albVar.a();
        while (albVar.e()) {
            collectionA.add(this.a.read(albVar));
        }
        albVar.b();
        return collectionA;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final /* bridge */ /* synthetic */ void write(ald aldVar, Object obj) throws IOException {
        Collection collection = (Collection) obj;
        if (collection == null) {
            aldVar.g();
            return;
        }
        aldVar.b();
        Iterator<E> it = collection.iterator();
        while (it.hasNext()) {
            this.a.write(aldVar, it.next());
        }
        aldVar.d();
    }
}
