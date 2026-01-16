package com.google.ads.interactivemedia.v3.internal;

import java.util.ArrayList;
import java.util.Arrays;
import org.rbmain.messenger.MediaController;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class op implements oh {
    private final pf a;
    private final boolean b;
    private final boolean c;
    private long g;
    private String i;
    private kr j;
    private oo k;
    private boolean l;
    private long m;
    private boolean n;
    private final boolean[] h = new boolean[3];
    private final ov d = new ov(7);
    private final ov e = new ov(8);
    private final ov f = new ov(6);
    private final aee o = new aee();

    public op(pf pfVar, boolean z, boolean z2) {
        this.a = pfVar;
        this.b = z;
        this.c = z2;
    }

    private final void f(byte[] bArr, int i, int i2) {
        if (!this.l || this.k.a()) {
            this.d.d(bArr, i, i2);
            this.e.d(bArr, i, i2);
        }
        this.f.d(bArr, i, i2);
        this.k.f(bArr, i, i2);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.oh
    public final void a() {
        this.g = 0L;
        this.n = false;
        aec.d(this.h);
        this.d.a();
        this.e.a();
        this.f.a();
        oo ooVar = this.k;
        if (ooVar != null) {
            ooVar.d();
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.oh
    public final void b(ka kaVar, pq pqVar) {
        pqVar.a();
        this.i = pqVar.c();
        kr krVarAk = kaVar.ak(pqVar.b(), 2);
        this.j = krVarAk;
        this.k = new oo(krVarAk, this.b, this.c);
        this.a.a(kaVar, pqVar);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.oh
    public final void c(long j, int i) {
        this.m = j;
        this.n |= (i & 2) != 0;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.oh
    public final void d(aee aeeVar) {
        ary.s(this.j);
        int i = aeu.a;
        int iG = aeeVar.g();
        int iE = aeeVar.e();
        byte[] bArrI = aeeVar.i();
        this.g += aeeVar.d();
        this.j.d(aeeVar, aeeVar.d());
        while (true) {
            int iC = aec.c(bArrI, iG, iE, this.h);
            if (iC == iE) {
                f(bArrI, iG, iE);
                return;
            }
            int i2 = iC + 3;
            int i3 = bArrI[i2] & 31;
            int i4 = iC - iG;
            if (i4 > 0) {
                f(bArrI, iG, iC);
            }
            int i5 = iE - iC;
            long j = this.g - i5;
            int i6 = i4 < 0 ? -i4 : 0;
            long j2 = this.m;
            if (!this.l || this.k.a()) {
                this.d.e(i6);
                this.e.e(i6);
                if (this.l) {
                    if (this.d.b()) {
                        ov ovVar = this.d;
                        this.k.b(aec.b(ovVar.a, 3, ovVar.b));
                        this.d.a();
                    } else if (this.e.b()) {
                        ov ovVar2 = this.e;
                        this.k.c(aec.e(ovVar2.a, ovVar2.b));
                        this.e.a();
                    }
                } else if (this.d.b() && this.e.b()) {
                    ArrayList arrayList = new ArrayList();
                    ov ovVar3 = this.d;
                    arrayList.add(Arrays.copyOf(ovVar3.a, ovVar3.b));
                    ov ovVar4 = this.e;
                    arrayList.add(Arrays.copyOf(ovVar4.a, ovVar4.b));
                    ov ovVar5 = this.d;
                    aeb aebVarB = aec.b(ovVar5.a, 3, ovVar5.b);
                    ov ovVar6 = this.e;
                    aea aeaVarE = aec.e(ovVar6.a, ovVar6.b);
                    int i7 = aebVarB.a;
                    int i8 = aebVarB.b;
                    int i9 = aebVarB.c;
                    int i10 = adl.a;
                    String str = String.format("avc1.%02X%02X%02X", Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9));
                    kr krVar = this.j;
                    cx cxVar = new cx();
                    cxVar.S(this.i);
                    cxVar.ae(MediaController.VIDEO_MIME_TYPE);
                    cxVar.I(str);
                    cxVar.aj(aebVarB.e);
                    cxVar.Q(aebVarB.f);
                    cxVar.aa(aebVarB.g);
                    cxVar.T(arrayList);
                    krVar.a(cxVar.a());
                    this.l = true;
                    this.k.b(aebVarB);
                    this.k.c(aeaVarE);
                    this.d.a();
                    this.e.a();
                }
            }
            if (this.f.e(i6)) {
                ov ovVar7 = this.f;
                this.o.c(this.f.a, aec.a(ovVar7.a, ovVar7.b));
                this.o.h(4);
                this.a.b(j2, this.o);
            }
            if (this.k.g(j, i5, this.l, this.n)) {
                this.n = false;
            }
            long j3 = this.m;
            if (!this.l || this.k.a()) {
                this.d.c(i3);
                this.e.c(i3);
            }
            this.f.c(i3);
            this.k.e(j, i3, j3);
            iG = i2;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.oh
    public final void e() {
    }
}
