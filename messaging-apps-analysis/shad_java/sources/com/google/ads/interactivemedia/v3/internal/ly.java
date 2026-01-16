package com.google.ads.interactivemedia.v3.internal;

import java.io.EOFException;
import java.io.IOException;
import org.rbmain.messenger.MessagesController;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class ly implements jy {
    public static final /* synthetic */ int a = 0;
    private final long b;
    private final aee c;
    private final ik d;
    private final ki e;
    private final kj f;
    private final kr g;
    private ka h;
    private kr i;
    private kr j;
    private int k;
    private qz l;
    private long m;
    private long n;
    private long o;
    private int p;
    private lz q;
    private boolean r;
    private long s;

    static {
        int i = lx.b;
    }

    public ly() {
        this((byte[]) null);
    }

    private final long b(long j) {
        return this.m + ((j * 1000000) / this.d.d);
    }

    private static boolean c(int i, long j) {
        return ((long) (i & (-128000))) == (j & (-128000));
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:123:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x015c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int i(com.google.ads.interactivemedia.v3.internal.jv r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 633
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.ly.i(com.google.ads.interactivemedia.v3.internal.jv):int");
    }

    private final boolean j(jv jvVar, boolean z) throws IOException {
        int i;
        int iK;
        int iA;
        int i2 = true != z ? MessagesController.UPDATE_MASK_REORDER : 32768;
        jvVar.j();
        if (jvVar.l() == 0) {
            qz qzVarA = this.f.a(jvVar, null);
            this.l = qzVarA;
            if (qzVarA != null) {
                this.e.b(qzVarA);
            }
            iK = (int) jvVar.k();
            if (!z) {
                jvVar.d(iK);
            }
            i = 0;
        } else {
            i = 0;
            iK = 0;
        }
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (!k(jvVar)) {
                this.c.h(0);
                int iV = this.c.v();
                if ((i == 0 || c(iV, i)) && (iA = il.a(iV)) != -1) {
                    i3++;
                    if (i3 != 1) {
                        if (i3 == 4) {
                            break;
                        }
                    } else {
                        this.d.a(iV);
                        i = iV;
                    }
                    jvVar.i(iA - 4);
                } else {
                    int i5 = i4 + 1;
                    if (i4 == i2) {
                        if (z) {
                            return false;
                        }
                        throw new dt("Searched too many bytes.");
                    }
                    if (z) {
                        jvVar.j();
                        jvVar.i(iK + i5);
                    } else {
                        jvVar.d(1);
                    }
                    i4 = i5;
                    i = 0;
                    i3 = 0;
                }
            } else if (i3 <= 0) {
                throw new EOFException();
            }
        }
        if (z) {
            jvVar.d(iK + i4);
        } else {
            jvVar.j();
        }
        this.k = i;
        return true;
    }

    private final boolean k(jv jvVar) throws IOException {
        lz lzVar = this.q;
        if (lzVar != null) {
            long jE = lzVar.e();
            if (jE != -1 && jvVar.k() > jE - 4) {
                return true;
            }
        }
        try {
            return !jvVar.f(this.c.i(), 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    private final lz l(jv jvVar) throws IOException {
        jvVar.g(this.c.i(), 0, 4);
        this.c.h(0);
        this.d.a(this.c.v());
        return new lu(jvVar.m(), jvVar.l(), this.d);
    }

    public final void a() {
        this.r = true;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final void d(ka kaVar) {
        this.h = kaVar;
        kr krVarAk = kaVar.ak(0, 1);
        this.i = krVarAk;
        this.j = krVarAk;
        this.h.al();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final void e(long j, long j2) {
        this.k = 0;
        this.m = -9223372036854775807L;
        this.n = 0L;
        this.p = 0;
        this.s = j2;
        lz lzVar = this.q;
        if (lzVar instanceof lv) {
            throw null;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final void f() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final boolean g(jv jvVar) throws IOException {
        return j(jvVar, true);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final int h(jv jvVar, kl klVar) throws IOException {
        ary.s(this.i);
        int i = aeu.a;
        int i2 = i(jvVar);
        if (i2 != -1) {
            return i2;
        }
        if (this.q instanceof lv) {
            if (this.q.c() != b(this.n)) {
                throw null;
            }
        }
        return -1;
    }

    public ly(byte[] bArr) {
        this(-9223372036854775807L);
    }

    public ly(long j) {
        this.b = j;
        this.c = new aee(10);
        this.d = new ik();
        this.e = new ki();
        this.m = -9223372036854775807L;
        this.f = new kj();
        jx jxVar = new jx();
        this.g = jxVar;
        this.j = jxVar;
    }
}
