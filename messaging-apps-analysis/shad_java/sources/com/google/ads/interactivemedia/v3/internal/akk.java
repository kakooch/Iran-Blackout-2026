package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class akk extends agt {
    final /* synthetic */ Class a;
    final /* synthetic */ akl b;

    akk(akl aklVar, Class cls) {
        this.b = aklVar;
        this.a = cls;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final Object read(alb albVar) throws IOException {
        Object obj = this.b.b.read(albVar);
        if (obj == null || this.a.isInstance(obj)) {
            return obj;
        }
        throw new agq("Expected a " + this.a.getName() + " but was " + obj.getClass().getName());
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final void write(ald aldVar, Object obj) throws IOException {
        this.b.b.write(aldVar, obj);
    }
}
