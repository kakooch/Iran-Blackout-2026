package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class add<T> implements acw {
    public final long a;
    public final acb b;
    public final int c;
    private final adg d;
    private final adc<? extends T> e;
    private volatile T f;

    public add(abx abxVar, Uri uri, int i, adc<? extends T> adcVar) {
        aca acaVar = new aca();
        acaVar.g(uri);
        acaVar.b(1);
        acb acbVarA = acaVar.a();
        this.d = new adg(abxVar);
        this.b = acbVarA;
        this.c = i;
        this.e = adcVar;
        this.a = to.a();
    }

    public final T a() {
        return this.f;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.acw
    public final void b() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.acw
    public final void c() throws IOException {
        this.d.g();
        abz abzVar = new abz(this.d, this.b);
        try {
            abzVar.a();
            Uri uriD = this.d.d();
            ary.t(uriD);
            this.f = this.e.a(uriD, abzVar);
        } finally {
            aeu.r(abzVar);
        }
    }

    public final long d() {
        return this.d.h();
    }

    public final Uri e() {
        return this.d.i();
    }

    public final Map<String, List<String>> f() {
        return this.d.j();
    }
}
