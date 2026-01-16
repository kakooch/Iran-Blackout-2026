package ir.nasim;

import com.google.android.exoplayer2.X;
import ir.nasim.InterfaceC22268uw7;
import java.util.Collections;

/* loaded from: classes2.dex */
public final class SS2 implements B52 {
    private final C3580Bl6 a;
    private String b;
    private InterfaceC4589Ft7 c;
    private a d;
    private boolean e;
    private long l;
    private final boolean[] f = new boolean[3];
    private final C5960Lo4 g = new C5960Lo4(32, 128);
    private final C5960Lo4 h = new C5960Lo4(33, 128);
    private final C5960Lo4 i = new C5960Lo4(34, 128);
    private final C5960Lo4 j = new C5960Lo4(39, 128);
    private final C5960Lo4 k = new C5960Lo4(40, 128);
    private long m = -9223372036854775807L;
    private final EW4 n = new EW4();

    private static final class a {
        private final InterfaceC4589Ft7 a;
        private long b;
        private boolean c;
        private int d;
        private long e;
        private boolean f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private long k;
        private long l;
        private boolean m;

        public a(InterfaceC4589Ft7 interfaceC4589Ft7) {
            this.a = interfaceC4589Ft7;
        }

        private static boolean b(int i) {
            return (32 <= i && i <= 35) || i == 39;
        }

        private static boolean c(int i) {
            return i < 32 || i == 40;
        }

        private void d(int i) {
            long j = this.l;
            if (j == -9223372036854775807L) {
                return;
            }
            boolean z = this.m;
            this.a.b(j, z ? 1 : 0, (int) (this.b - this.k), i, null);
        }

        public void a(long j, int i, boolean z) {
            if (this.j && this.g) {
                this.m = this.c;
                this.j = false;
            } else if (this.h || this.g) {
                if (z && this.i) {
                    d(i + ((int) (j - this.b)));
                }
                this.k = this.b;
                this.l = this.e;
                this.m = this.c;
                this.i = true;
            }
        }

        public void e(byte[] bArr, int i, int i2) {
            if (this.f) {
                int i3 = this.d;
                int i4 = (i + 2) - i3;
                if (i4 >= i2) {
                    this.d = i3 + (i2 - i);
                } else {
                    this.g = (bArr[i4] & 128) != 0;
                    this.f = false;
                }
            }
        }

        public void f() {
            this.f = false;
            this.g = false;
            this.h = false;
            this.i = false;
            this.j = false;
        }

        public void g(long j, int i, int i2, long j2, boolean z) {
            this.g = false;
            this.h = false;
            this.e = j2;
            this.d = 0;
            this.b = j;
            if (!c(i2)) {
                if (this.i && !this.j) {
                    if (z) {
                        d(i);
                    }
                    this.i = false;
                }
                if (b(i2)) {
                    this.h = !this.j;
                    this.j = true;
                }
            }
            boolean z2 = i2 >= 16 && i2 <= 21;
            this.c = z2;
            this.f = z2 || i2 <= 9;
        }
    }

    public SS2(C3580Bl6 c3580Bl6) {
        this.a = c3580Bl6;
    }

    private void f() {
        AbstractC20011rK.i(this.c);
        AbstractC9683aN7.j(this.d);
    }

    private void g(long j, int i, int i2, long j2) {
        this.d.a(j, i, this.e);
        if (!this.e) {
            this.g.b(i2);
            this.h.b(i2);
            this.i.b(i2);
            if (this.g.c() && this.h.c() && this.i.c()) {
                this.c.c(i(this.b, this.g, this.h, this.i));
                this.e = true;
            }
        }
        if (this.j.b(i2)) {
            C5960Lo4 c5960Lo4 = this.j;
            this.n.Q(this.j.d, AbstractC6193Mo4.q(c5960Lo4.d, c5960Lo4.e));
            this.n.T(5);
            this.a.a(j2, this.n);
        }
        if (this.k.b(i2)) {
            C5960Lo4 c5960Lo42 = this.k;
            this.n.Q(this.k.d, AbstractC6193Mo4.q(c5960Lo42.d, c5960Lo42.e));
            this.n.T(5);
            this.a.a(j2, this.n);
        }
    }

    private void h(byte[] bArr, int i, int i2) {
        this.d.e(bArr, i, i2);
        if (!this.e) {
            this.g.a(bArr, i, i2);
            this.h.a(bArr, i, i2);
            this.i.a(bArr, i, i2);
        }
        this.j.a(bArr, i, i2);
        this.k.a(bArr, i, i2);
    }

    private static com.google.android.exoplayer2.X i(String str, C5960Lo4 c5960Lo4, C5960Lo4 c5960Lo42, C5960Lo4 c5960Lo43) {
        int i = c5960Lo4.e;
        byte[] bArr = new byte[c5960Lo42.e + i + c5960Lo43.e];
        int i2 = 0;
        System.arraycopy(c5960Lo4.d, 0, bArr, 0, i);
        System.arraycopy(c5960Lo42.d, 0, bArr, c5960Lo4.e, c5960Lo42.e);
        System.arraycopy(c5960Lo43.d, 0, bArr, c5960Lo4.e + c5960Lo42.e, c5960Lo43.e);
        FW4 fw4 = new FW4(c5960Lo42.d, 0, c5960Lo42.e);
        fw4.l(44);
        int iE = fw4.e(3);
        fw4.k();
        int iE2 = fw4.e(2);
        boolean zD = fw4.d();
        int iE3 = fw4.e(5);
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i4 >= 32) {
                break;
            }
            if (fw4.d()) {
                i3 |= 1 << i4;
            }
            i4++;
        }
        int[] iArr = new int[6];
        for (int i5 = 0; i5 < 6; i5++) {
            iArr[i5] = fw4.e(8);
        }
        int iE4 = fw4.e(8);
        for (int i6 = 0; i6 < iE; i6++) {
            if (fw4.d()) {
                i2 += 89;
            }
            if (fw4.d()) {
                i2 += 8;
            }
        }
        fw4.l(i2);
        if (iE > 0) {
            fw4.l((8 - iE) * 2);
        }
        fw4.h();
        int iH = fw4.h();
        if (iH == 3) {
            fw4.k();
        }
        int iH2 = fw4.h();
        int iH3 = fw4.h();
        if (fw4.d()) {
            int iH4 = fw4.h();
            int iH5 = fw4.h();
            int iH6 = fw4.h();
            int iH7 = fw4.h();
            iH2 -= ((iH == 1 || iH == 2) ? 2 : 1) * (iH4 + iH5);
            iH3 -= (iH == 1 ? 2 : 1) * (iH6 + iH7);
        }
        fw4.h();
        fw4.h();
        int iH8 = fw4.h();
        for (int i7 = fw4.d() ? 0 : iE; i7 <= iE; i7++) {
            fw4.h();
            fw4.h();
            fw4.h();
        }
        fw4.h();
        fw4.h();
        fw4.h();
        fw4.h();
        fw4.h();
        fw4.h();
        if (fw4.d() && fw4.d()) {
            j(fw4);
        }
        fw4.l(2);
        if (fw4.d()) {
            fw4.l(8);
            fw4.h();
            fw4.h();
            fw4.k();
        }
        k(fw4);
        if (fw4.d()) {
            for (int i8 = 0; i8 < fw4.h(); i8++) {
                fw4.l(iH8 + 5);
            }
        }
        fw4.l(2);
        float f = 1.0f;
        if (fw4.d()) {
            if (fw4.d()) {
                int iE5 = fw4.e(8);
                if (iE5 == 255) {
                    int iE6 = fw4.e(16);
                    int iE7 = fw4.e(16);
                    if (iE6 != 0 && iE7 != 0) {
                        f = iE6 / iE7;
                    }
                } else {
                    float[] fArr = AbstractC6193Mo4.b;
                    if (iE5 < fArr.length) {
                        f = fArr[iE5];
                    } else {
                        AbstractC18815pI3.k("H265Reader", "Unexpected aspect_ratio_idc value: " + iE5);
                    }
                }
            }
            if (fw4.d()) {
                fw4.k();
            }
            if (fw4.d()) {
                fw4.l(4);
                if (fw4.d()) {
                    fw4.l(24);
                }
            }
            if (fw4.d()) {
                fw4.h();
                fw4.h();
            }
            fw4.k();
            if (fw4.d()) {
                iH3 *= 2;
            }
        }
        return new X.b().U(str).g0("video/hevc").K(GW0.c(iE2, zD, iE3, i3, iArr, iE4)).n0(iH2).S(iH3).c0(f).V(Collections.singletonList(bArr)).G();
    }

    private static void j(FW4 fw4) {
        for (int i = 0; i < 4; i++) {
            int i2 = 0;
            while (i2 < 6) {
                int i3 = 1;
                if (fw4.d()) {
                    int iMin = Math.min(64, 1 << ((i << 1) + 4));
                    if (i > 1) {
                        fw4.g();
                    }
                    for (int i4 = 0; i4 < iMin; i4++) {
                        fw4.g();
                    }
                } else {
                    fw4.h();
                }
                if (i == 3) {
                    i3 = 3;
                }
                i2 += i3;
            }
        }
    }

    private static void k(FW4 fw4) {
        int iH = fw4.h();
        boolean zD = false;
        int i = 0;
        for (int i2 = 0; i2 < iH; i2++) {
            if (i2 != 0) {
                zD = fw4.d();
            }
            if (zD) {
                fw4.k();
                fw4.h();
                for (int i3 = 0; i3 <= i; i3++) {
                    if (fw4.d()) {
                        fw4.k();
                    }
                }
            } else {
                int iH2 = fw4.h();
                int iH3 = fw4.h();
                int i4 = iH2 + iH3;
                for (int i5 = 0; i5 < iH2; i5++) {
                    fw4.h();
                    fw4.k();
                }
                for (int i6 = 0; i6 < iH3; i6++) {
                    fw4.h();
                    fw4.k();
                }
                i = i4;
            }
        }
    }

    private void l(long j, int i, int i2, long j2) {
        this.d.g(j, i, i2, j2, this.e);
        if (!this.e) {
            this.g.e(i2);
            this.h.e(i2);
            this.i.e(i2);
        }
        this.j.e(i2);
        this.k.e(i2);
    }

    @Override // ir.nasim.B52
    public void a(EW4 ew4) {
        f();
        while (ew4.a() > 0) {
            int iF = ew4.f();
            int iG = ew4.g();
            byte[] bArrE = ew4.e();
            this.l += ew4.a();
            this.c.d(ew4, ew4.a());
            while (iF < iG) {
                int iC = AbstractC6193Mo4.c(bArrE, iF, iG, this.f);
                if (iC == iG) {
                    h(bArrE, iF, iG);
                    return;
                }
                int iE = AbstractC6193Mo4.e(bArrE, iC);
                int i = iC - iF;
                if (i > 0) {
                    h(bArrE, iF, iC);
                }
                int i2 = iG - iC;
                long j = this.l - i2;
                g(j, i2, i < 0 ? -i : 0, this.m);
                l(j, i2, iE, this.m);
                iF = iC + 3;
            }
        }
    }

    @Override // ir.nasim.B52
    public void b() {
        this.l = 0L;
        this.m = -9223372036854775807L;
        AbstractC6193Mo4.a(this.f);
        this.g.d();
        this.h.d();
        this.i.d();
        this.j.d();
        this.k.d();
        a aVar = this.d;
        if (aVar != null) {
            aVar.f();
        }
    }

    @Override // ir.nasim.B52
    public void c(InterfaceC10465bf2 interfaceC10465bf2, InterfaceC22268uw7.d dVar) {
        dVar.a();
        this.b = dVar.b();
        InterfaceC4589Ft7 interfaceC4589Ft7B = interfaceC10465bf2.b(dVar.c(), 2);
        this.c = interfaceC4589Ft7B;
        this.d = new a(interfaceC4589Ft7B);
        this.a.b(interfaceC10465bf2, dVar);
    }

    @Override // ir.nasim.B52
    public void e(long j, int i) {
        if (j != -9223372036854775807L) {
            this.m = j;
        }
    }

    @Override // ir.nasim.B52
    public void d() {
    }
}
