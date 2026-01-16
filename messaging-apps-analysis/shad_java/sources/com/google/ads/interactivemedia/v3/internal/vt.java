package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import java.util.List;
import java.util.Map;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public abstract class vt implements acw {
    public final long c;
    public final acb d;
    public final int e;
    public final cy f;
    public final int g;
    public final Object h;
    public final long i;
    public final long j;
    protected final adg k;

    public vt(abx abxVar, acb acbVar, int i, cy cyVar, int i2, Object obj, long j, long j2) {
        this.k = new adg(abxVar);
        ary.t(acbVar);
        this.d = acbVar;
        this.e = i;
        this.f = cyVar;
        this.g = i2;
        this.h = obj;
        this.i = j;
        this.j = j2;
        this.c = to.a();
    }

    public final long f() {
        return this.k.h();
    }

    public final Uri g() {
        return this.k.i();
    }

    public final Map<String, List<String>> h() {
        return this.k.j();
    }
}
