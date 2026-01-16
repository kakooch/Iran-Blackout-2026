package com.google.ads.interactivemedia.v3.internal;

import android.util.SparseArray;
import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class vs implements ka {
    private static final kl b = new kl();
    private final jy c;
    private final int d;
    private final cy e;
    private final SparseArray<vr> f = new SparseArray<>();
    private boolean g;
    private long h;
    private ko i;
    private cy[] j;
    private vq k;

    public vs(jy jyVar, int i, cy cyVar) {
        this.c = jyVar;
        this.d = i;
        this.e = cyVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ka
    public final kr ak(int i, int i2) {
        vr vrVar = this.f.get(i);
        if (vrVar == null) {
            ary.q(this.j == null);
            vrVar = new vr(i, i2, i2 == this.d ? this.e : null);
            vrVar.g(this.k, this.h);
            this.f.put(i, vrVar);
        }
        return vrVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ka
    public final void al() {
        cy[] cyVarArr = new cy[this.f.size()];
        for (int i = 0; i < this.f.size(); i++) {
            cy cyVar = this.f.valueAt(i).a;
            ary.s(cyVar);
            cyVarArr[i] = cyVar;
        }
        this.j = cyVarArr;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ka
    public final void am(ko koVar) {
        this.i = koVar;
    }

    public final jt d() {
        ko koVar = this.i;
        if (koVar instanceof jt) {
            return (jt) koVar;
        }
        return null;
    }

    public final cy[] e() {
        return this.j;
    }

    public final void f() {
        this.c.f();
    }

    public final void g(vq vqVar, long j, long j2) {
        this.k = vqVar;
        this.h = j2;
        if (!this.g) {
            this.c.d(this);
            if (j != -9223372036854775807L) {
                this.c.e(0L, j);
            }
            this.g = true;
            return;
        }
        jy jyVar = this.c;
        if (j == -9223372036854775807L) {
            j = 0;
        }
        jyVar.e(0L, j);
        for (int i = 0; i < this.f.size(); i++) {
            this.f.valueAt(i).g(vqVar, j2);
        }
    }

    public final boolean h(jv jvVar) throws IOException {
        int iH = this.c.h(jvVar, b);
        ary.q(iH != 1);
        return iH == 0;
    }
}
