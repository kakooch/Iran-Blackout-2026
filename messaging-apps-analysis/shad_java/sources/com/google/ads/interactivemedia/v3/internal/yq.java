package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class yq extends wc {
    private static final AtomicInteger o = new AtomicInteger();
    private final boolean A;
    private zc B;
    private int C;
    private boolean D;
    private volatile boolean E;
    private boolean F;
    private arn<Integer> G;
    private boolean H;
    private final yf I;
    private yf J;
    public final int a;
    public final int b;
    public final Uri m;
    public final boolean n;
    private final abx p;
    private final acb q;
    private final boolean r;
    private final boolean s;
    private final aes t;
    private final yp u;
    private final List<cy> v;
    private final jc w;
    private final sa x;
    private final aee y;
    private final boolean z;

    private yq(yp ypVar, abx abxVar, acb acbVar, cy cyVar, boolean z, abx abxVar2, acb acbVar2, boolean z2, Uri uri, List list, int i, Object obj, long j, long j2, long j3, int i2, boolean z3, boolean z4, aes aesVar, jc jcVar, yf yfVar, sa saVar, aee aeeVar, boolean z5) {
        super(abxVar, acbVar, cyVar, i, obj, j, j2, j3);
        this.z = z;
        this.b = i2;
        this.q = acbVar2;
        this.p = abxVar2;
        this.D = acbVar2 != null;
        this.A = z2;
        this.m = uri;
        this.r = z4;
        this.t = aesVar;
        this.s = z3;
        this.u = ypVar;
        this.v = list;
        this.w = jcVar;
        this.I = yfVar;
        this.x = saVar;
        this.y = aeeVar;
        this.n = z5;
        this.G = arn.i();
        this.a = o.getAndIncrement();
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.ads.interactivemedia.v3.internal.yq a(com.google.ads.interactivemedia.v3.internal.yp r37, com.google.ads.interactivemedia.v3.internal.abx r38, com.google.ads.interactivemedia.v3.internal.cy r39, long r40, com.google.ads.interactivemedia.v3.internal.zt r42, int r43, android.net.Uri r44, java.util.List<com.google.ads.interactivemedia.v3.internal.cy> r45, int r46, java.lang.Object r47, boolean r48, com.google.ads.interactivemedia.v3.internal.zi r49, com.google.ads.interactivemedia.v3.internal.yq r50, byte[] r51, byte[] r52) {
        /*
            Method dump skipped, instructions count: 284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.yq.a(com.google.ads.interactivemedia.v3.internal.yp, com.google.ads.interactivemedia.v3.internal.abx, com.google.ads.interactivemedia.v3.internal.cy, long, com.google.ads.interactivemedia.v3.internal.zt, int, android.net.Uri, java.util.List, int, java.lang.Object, boolean, com.google.ads.interactivemedia.v3.internal.zi, com.google.ads.interactivemedia.v3.internal.yq, byte[], byte[]):com.google.ads.interactivemedia.v3.internal.yq");
    }

    private static byte[] m(String str) {
        if (aeu.C(str).startsWith("0x")) {
            str = str.substring(2);
        }
        byte[] byteArray = new BigInteger(str, 16).toByteArray();
        byte[] bArr = new byte[16];
        int length = byteArray.length;
        int i = length > 16 ? length - 16 : 0;
        System.arraycopy(byteArray, i, bArr, (16 - length) + i, length - i);
        return bArr;
    }

    private static abx n(abx abxVar, byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return abxVar;
        }
        ary.t(bArr2);
        return new ye(abxVar, bArr, bArr2);
    }

    private final long o(jv jvVar) throws Throwable {
        jvVar.j();
        try {
            jvVar.g(this.y.i(), 0, 10);
            this.y.a(10);
        } catch (EOFException unused) {
        }
        if (this.y.r() != 4801587) {
            return -9223372036854775807L;
        }
        this.y.k(3);
        int iA = this.y.A();
        int i = iA + 10;
        if (i > this.y.j()) {
            byte[] bArrI = this.y.i();
            this.y.a(i);
            System.arraycopy(bArrI, 0, this.y.i(), 0, 10);
        }
        jvVar.g(this.y.i(), 10, iA);
        qz qzVarC = this.x.c(this.y.i(), iA);
        if (qzVarC == null) {
            return -9223372036854775807L;
        }
        int iA2 = qzVarC.a();
        for (int i2 = 0; i2 < iA2; i2++) {
            qy qyVarB = qzVarC.b(i2);
            if (qyVarB instanceof sh) {
                sh shVar = (sh) qyVarB;
                if ("com.apple.streaming.transportStreamTimestamp".equals(shVar.a)) {
                    System.arraycopy(shVar.b, 0, this.y.i(), 0, 8);
                    this.y.a(8);
                    return this.y.x() & 8589934591L;
                }
            }
        }
        return -9223372036854775807L;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.acw
    public final void b() {
        this.E = true;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.acw
    public final void c() throws IOException {
        yf yfVar;
        ary.t(this.B);
        if (this.J == null && (yfVar = this.I) != null && yfVar.c()) {
            this.J = this.I;
            this.D = false;
        }
        if (this.D) {
            ary.t(this.p);
            ary.t(this.q);
            l(this.p, this.q, this.A);
            this.C = 0;
            this.D = false;
        }
        if (this.E) {
            return;
        }
        if (!this.s) {
            if (!this.r) {
                try {
                    this.t.h();
                } catch (InterruptedException unused) {
                    throw new InterruptedIOException();
                }
            } else if (this.t.b() == Long.MAX_VALUE) {
                this.t.a(this.i);
            }
            l(this.k, this.d, this.z);
        }
        this.F = !this.E;
    }

    public final void d(zc zcVar, arn<Integer> arnVar) {
        this.B = zcVar;
        this.G = arnVar;
    }

    public final int e(int i) {
        ary.q(!this.n);
        if (i >= this.G.size()) {
            return 0;
        }
        return this.G.get(i).intValue();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.wc
    public final boolean j() {
        return this.F;
    }

    public final void k() {
        this.H = true;
    }

    private final void l(abx abxVar, acb acbVar, boolean z) throws IOException {
        acb acbVarC;
        abx abxVar2;
        jv jvVar;
        yf yfVarA;
        if (z) {
            z = this.C != 0;
            abxVar2 = abxVar;
            acbVarC = acbVar;
        } else {
            acbVarC = acbVar.c(this.C);
            abxVar2 = abxVar;
        }
        try {
            jv jvVar2 = new jv(abxVar, acbVarC.e, abxVar2.c(acbVarC));
            if (this.J == null) {
                long jO = o(jvVar2);
                jvVar2.j();
                yf yfVar = this.I;
                if (yfVar != null) {
                    yfVarA = yfVar.e();
                    jvVar = jvVar2;
                } else {
                    jvVar = jvVar2;
                    yfVarA = this.u.a(acbVarC.a, this.f, this.v, this.t, abxVar.e(), jvVar);
                }
                this.J = yfVarA;
                if (yfVarA.b()) {
                    this.B.D(jO != -9223372036854775807L ? this.t.f(jO) : this.i);
                } else {
                    this.B.D(0L);
                }
                this.B.C();
                this.J.a(this.B);
            } else {
                jvVar = jvVar2;
            }
            this.B.E(this.w);
            if (z) {
                jvVar.d(this.C);
            }
            do {
                try {
                    if (this.E) {
                        break;
                    }
                } finally {
                    this.C = (int) (jvVar.l() - acbVar.e);
                }
            } while (this.J.d(jvVar));
        } finally {
            aeu.q(abxVar);
        }
    }
}
