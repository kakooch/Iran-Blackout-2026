package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class adg implements abx {
    private final abx a;
    private long b;
    private Uri c;
    private Map<String, List<String>> d;

    public adg(abx abxVar) {
        ary.t(abxVar);
        this.a = abxVar;
        this.c = Uri.EMPTY;
        this.d = Collections.emptyMap();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abu
    public final int a(byte[] bArr, int i, int i2) throws IOException {
        int iA = this.a.a(bArr, i, i2);
        if (iA != -1) {
            this.b += iA;
        }
        return iA;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abx
    public final void b(adh adhVar) {
        ary.t(adhVar);
        this.a.b(adhVar);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abx
    public final long c(acb acbVar) throws IOException {
        this.c = acbVar.a;
        this.d = Collections.emptyMap();
        long jC = this.a.c(acbVar);
        Uri uriD = d();
        ary.t(uriD);
        this.c = uriD;
        this.d = e();
        return jC;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abx
    public final Uri d() {
        return this.a.d();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abx
    public final Map<String, List<String>> e() {
        return this.a.e();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abx
    public final void f() throws IOException {
        this.a.f();
    }

    public final void g() {
        this.b = 0L;
    }

    public final long h() {
        return this.b;
    }

    public final Uri i() {
        return this.c;
    }

    public final Map<String, List<String>> j() {
        return this.d;
    }
}
