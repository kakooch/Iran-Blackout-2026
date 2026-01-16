package com.google.ads.interactivemedia.v3.internal;

import android.util.Log;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class ox implements pr {
    private final oh a;
    private final aed b = new aed(new byte[10]);
    private int c = 0;
    private int d;
    private aes e;
    private boolean f;
    private boolean g;
    private boolean h;
    private int i;
    private int j;
    private boolean k;
    private long l;

    public ox(oh ohVar) {
        this.a = ohVar;
    }

    private final void d(int i) {
        this.c = i;
        this.d = 0;
    }

    private final boolean e(aee aeeVar, byte[] bArr, int i) {
        int iMin = Math.min(aeeVar.d(), i - this.d);
        if (iMin <= 0) {
            return true;
        }
        if (bArr == null) {
            aeeVar.k(iMin);
        } else {
            aeeVar.m(bArr, this.d, iMin);
        }
        int i2 = this.d + iMin;
        this.d = i2;
        return i2 == i;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.pr
    public final void a(aes aesVar, ka kaVar, pq pqVar) {
        this.e = aesVar;
        this.a.b(kaVar, pqVar);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.pr
    public final void b() {
        this.c = 0;
        this.d = 0;
        this.h = false;
        this.a.a();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.pr
    public final void c(aee aeeVar, int i) throws dt {
        ary.s(this.e);
        int i2 = -1;
        int i3 = 2;
        if ((i & 1) != 0) {
            int i4 = this.c;
            if (i4 != 0 && i4 != 1) {
                if (i4 != 2) {
                    int i5 = this.j;
                    if (i5 != -1) {
                        StringBuilder sb = new StringBuilder(59);
                        sb.append("Unexpected start indicator: expected ");
                        sb.append(i5);
                        sb.append(" more bytes");
                        Log.w("PesReader", sb.toString());
                    }
                    this.a.e();
                } else {
                    Log.w("PesReader", "Unexpected start indicator reading extended header");
                }
            }
            d(1);
        }
        int i6 = i;
        while (aeeVar.d() > 0) {
            int i7 = this.c;
            if (i7 != 0) {
                if (i7 != 1) {
                    if (i7 != i3) {
                        int iD = aeeVar.d();
                        int i8 = this.j;
                        int i9 = i8 != i2 ? iD - i8 : 0;
                        if (i9 > 0) {
                            iD -= i9;
                            aeeVar.f(aeeVar.g() + iD);
                        }
                        this.a.d(aeeVar);
                        int i10 = this.j;
                        if (i10 != i2) {
                            int i11 = i10 - iD;
                            this.j = i11;
                            if (i11 == 0) {
                                this.a.e();
                                d(1);
                            }
                        }
                    } else {
                        if (e(aeeVar, this.b.a, Math.min(10, this.i)) && e(aeeVar, null, this.i)) {
                            this.b.e(0);
                            long jF = -9223372036854775807L;
                            this.l = -9223372036854775807L;
                            if (this.f) {
                                this.b.g(4);
                                int i12 = this.b.i(3);
                                this.b.g(1);
                                int i13 = this.b.i(15);
                                this.b.g(1);
                                long jI = (i13 << 15) | (i12 << 30) | this.b.i(15);
                                this.b.g(1);
                                if (!this.h && this.g) {
                                    this.b.g(4);
                                    int i14 = this.b.i(3);
                                    this.b.g(1);
                                    int i15 = this.b.i(15);
                                    this.b.g(1);
                                    int i16 = this.b.i(15);
                                    this.b.g(1);
                                    this.e.f((i14 << 30) | (i15 << 15) | i16);
                                    this.h = true;
                                }
                                jF = this.e.f(jI);
                                this.l = jF;
                            }
                            i6 |= true != this.k ? 0 : 4;
                            this.a.c(jF, i6);
                            d(3);
                            i2 = -1;
                        }
                    }
                } else if (e(aeeVar, this.b.a, 9)) {
                    int i17 = 0;
                    this.b.e(0);
                    int i18 = this.b.i(24);
                    if (i18 != 1) {
                        StringBuilder sb2 = new StringBuilder(41);
                        sb2.append("Unexpected start code prefix: ");
                        sb2.append(i18);
                        Log.w("PesReader", sb2.toString());
                        i2 = -1;
                        this.j = -1;
                    } else {
                        this.b.g(8);
                        int i19 = this.b.i(16);
                        this.b.g(5);
                        this.k = this.b.h();
                        this.b.g(2);
                        this.f = this.b.h();
                        this.g = this.b.h();
                        this.b.g(6);
                        int i20 = this.b.i(8);
                        this.i = i20;
                        if (i19 == 0) {
                            this.j = -1;
                        } else {
                            int i21 = (i19 - 3) - i20;
                            this.j = i21;
                            if (i21 < 0) {
                                StringBuilder sb3 = new StringBuilder(47);
                                sb3.append("Found negative packet payload size: ");
                                sb3.append(i21);
                                Log.w("PesReader", sb3.toString());
                                i2 = -1;
                                this.j = -1;
                            }
                            i17 = 2;
                        }
                        i2 = -1;
                        i17 = 2;
                    }
                    d(i17);
                } else {
                    i2 = -1;
                }
            } else {
                aeeVar.k(aeeVar.d());
            }
            i3 = 2;
        }
    }
}
