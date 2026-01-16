package com.google.ads.interactivemedia.v3.internal;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ux {
    private final int a;
    private final aee b;
    private uw c;
    private uw d;
    private uw e;
    private long f;
    private final acc g;

    public ux(acc accVar) {
        this.g = accVar;
        int iH = accVar.h();
        this.a = iH;
        this.b = new aee(32);
        uw uwVar = new uw(0L, iH);
        this.c = uwVar;
        this.d = uwVar;
        this.e = uwVar;
    }

    private final void i(long j, ByteBuffer byteBuffer, int i) {
        k(j);
        while (i > 0) {
            int iMin = Math.min(i, (int) (this.d.b - j));
            uw uwVar = this.d;
            byteBuffer.put(uwVar.d.a, uwVar.a(j), iMin);
            i -= iMin;
            j += iMin;
            uw uwVar2 = this.d;
            if (j == uwVar2.b) {
                this.d = uwVar2.e;
            }
        }
    }

    private final void j(long j, byte[] bArr, int i) {
        k(j);
        int i2 = i;
        while (i2 > 0) {
            int iMin = Math.min(i2, (int) (this.d.b - j));
            uw uwVar = this.d;
            System.arraycopy(uwVar.d.a, uwVar.a(j), bArr, i - i2, iMin);
            i2 -= iMin;
            j += iMin;
            uw uwVar2 = this.d;
            if (j == uwVar2.b) {
                this.d = uwVar2.e;
            }
        }
    }

    private final void k(long j) {
        while (true) {
            uw uwVar = this.d;
            if (j < uwVar.b) {
                return;
            } else {
                this.d = uwVar.e;
            }
        }
    }

    private final void l(uw uwVar) {
        if (uwVar.c) {
            uw uwVar2 = this.e;
            boolean z = uwVar2.c;
            int i = (z ? 1 : 0) + (((int) (uwVar2.a - uwVar.a)) / this.a);
            abj[] abjVarArr = new abj[i];
            for (int i2 = 0; i2 < i; i2++) {
                abjVarArr[i2] = uwVar.d;
                uwVar = uwVar.b();
            }
            this.g.e(abjVarArr);
        }
    }

    private final int m(int i) {
        uw uwVar = this.e;
        if (!uwVar.c) {
            abj abjVarC = this.g.c();
            uw uwVar2 = new uw(this.e.b, this.a);
            uwVar.d = abjVarC;
            uwVar.e = uwVar2;
            uwVar.c = true;
        }
        return Math.min(i, (int) (this.e.b - this.f));
    }

    private final void n(int i) {
        long j = this.f + i;
        this.f = j;
        uw uwVar = this.e;
        if (j == uwVar.b) {
            this.e = uwVar.e;
        }
    }

    public final void a() {
        l(this.c);
        uw uwVar = new uw(0L, this.a);
        this.c = uwVar;
        this.d = uwVar;
        this.e = uwVar;
        this.f = 0L;
        this.g.f();
    }

    public final void b(long j) {
        this.f = j;
        if (j != 0) {
            uw uwVar = this.c;
            if (j != uwVar.a) {
                while (this.f > uwVar.b) {
                    uwVar = uwVar.e;
                }
                uw uwVar2 = uwVar.e;
                l(uwVar2);
                uw uwVar3 = new uw(uwVar.b, this.a);
                uwVar.e = uwVar3;
                if (this.f == uwVar.b) {
                    uwVar = uwVar3;
                }
                this.e = uwVar;
                if (this.d == uwVar2) {
                    this.d = uwVar3;
                    return;
                }
                return;
            }
        }
        l(this.c);
        uw uwVar4 = new uw(this.f, this.a);
        this.c = uwVar4;
        this.d = uwVar4;
        this.e = uwVar4;
    }

    public final void c() {
        this.d = this.c;
    }

    public final void d(iw iwVar, uy uyVar) {
        int iO;
        if (iwVar.k()) {
            long j = uyVar.b;
            this.b.a(1);
            j(j, this.b.i(), 1);
            long j2 = j + 1;
            byte b = this.b.i()[0];
            int i = b & 128;
            int i2 = b & 127;
            it itVar = iwVar.a;
            byte[] bArr = itVar.a;
            if (bArr == null) {
                itVar.a = new byte[16];
            } else {
                Arrays.fill(bArr, (byte) 0);
            }
            j(j2, itVar.a, i2);
            long j3 = j2 + i2;
            if (i != 0) {
                this.b.a(2);
                j(j3, this.b.i(), 2);
                j3 += 2;
                iO = this.b.o();
            } else {
                iO = 1;
            }
            int[] iArr = itVar.b;
            if (iArr == null || iArr.length < iO) {
                iArr = new int[iO];
            }
            int[] iArr2 = iArr;
            int[] iArr3 = itVar.c;
            if (iArr3 == null || iArr3.length < iO) {
                iArr3 = new int[iO];
            }
            int[] iArr4 = iArr3;
            if (i != 0) {
                int i3 = iO * 6;
                this.b.a(i3);
                j(j3, this.b.i(), i3);
                j3 += i3;
                this.b.h(0);
                for (int i4 = 0; i4 < iO; i4++) {
                    iArr2[i4] = this.b.o();
                    iArr4[i4] = this.b.B();
                }
            } else {
                iArr2[0] = 0;
                iArr4[0] = uyVar.a - ((int) (j3 - uyVar.b));
            }
            kq kqVar = uyVar.c;
            int i5 = aeu.a;
            itVar.a(iO, iArr2, iArr4, kqVar.b, itVar.a, kqVar.a, kqVar.c, kqVar.d);
            long j4 = uyVar.b;
            int i6 = (int) (j3 - j4);
            uyVar.b = j4 + i6;
            uyVar.a -= i6;
        }
        if (!iwVar.e()) {
            iwVar.i(uyVar.a);
            i(uyVar.b, iwVar.b, uyVar.a);
            return;
        }
        this.b.a(4);
        j(uyVar.b, this.b.i(), 4);
        int iB = this.b.B();
        uyVar.b += 4;
        uyVar.a -= 4;
        iwVar.i(iB);
        i(uyVar.b, iwVar.b, iB);
        uyVar.b += iB;
        int i7 = uyVar.a - iB;
        uyVar.a = i7;
        ByteBuffer byteBuffer = iwVar.e;
        if (byteBuffer == null || byteBuffer.capacity() < i7) {
            iwVar.e = ByteBuffer.allocate(i7);
        } else {
            iwVar.e.clear();
        }
        i(uyVar.b, iwVar.e, uyVar.a);
    }

    public final void e(long j) {
        uw uwVar;
        if (j != -1) {
            while (true) {
                uwVar = this.c;
                if (j < uwVar.b) {
                    break;
                }
                this.g.d(uwVar.d);
                this.c = this.c.b();
            }
            if (this.d.a < uwVar.a) {
                this.d = uwVar;
            }
        }
    }

    public final long f() {
        return this.f;
    }

    public final int g(abu abuVar, int i, boolean z) throws IOException {
        int iM = m(i);
        uw uwVar = this.e;
        int iA = abuVar.a(uwVar.d.a, uwVar.a(this.f), iM);
        if (iA != -1) {
            n(iA);
            return iA;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    public final void h(aee aeeVar, int i) {
        while (i > 0) {
            int iM = m(i);
            uw uwVar = this.e;
            aeeVar.m(uwVar.d.a, uwVar.a(this.f), iM);
            i -= iM;
            n(iM);
        }
    }
}
