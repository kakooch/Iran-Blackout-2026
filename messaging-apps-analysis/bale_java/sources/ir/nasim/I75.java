package ir.nasim;

import android.graphics.Bitmap;
import ir.nasim.C14451hw1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.zip.Inflater;

/* loaded from: classes2.dex */
public final class I75 extends WC6 {
    private final EW4 o;
    private final EW4 p;
    private final a q;
    private Inflater r;

    private static final class a {
        private final EW4 a = new EW4();
        private final int[] b = new int[256];
        private boolean c;
        private int d;
        private int e;
        private int f;
        private int g;
        private int h;
        private int i;

        /* JADX INFO: Access modifiers changed from: private */
        public void e(EW4 ew4, int i) {
            int I;
            if (i < 4) {
                return;
            }
            ew4.T(3);
            int i2 = i - 4;
            if ((ew4.F() & 128) != 0) {
                if (i2 < 7 || (I = ew4.I()) < 4) {
                    return;
                }
                this.h = ew4.L();
                this.i = ew4.L();
                this.a.O(I - 4);
                i2 = i - 11;
            }
            int iF = this.a.f();
            int iG = this.a.g();
            if (iF >= iG || i2 <= 0) {
                return;
            }
            int iMin = Math.min(i2, iG - iF);
            ew4.j(this.a.e(), iF, iMin);
            this.a.S(iF + iMin);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f(EW4 ew4, int i) {
            if (i < 19) {
                return;
            }
            this.d = ew4.L();
            this.e = ew4.L();
            ew4.T(11);
            this.f = ew4.L();
            this.g = ew4.L();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g(EW4 ew4, int i) {
            if (i % 5 != 2) {
                return;
            }
            ew4.T(2);
            Arrays.fill(this.b, 0);
            int i2 = i / 5;
            for (int i3 = 0; i3 < i2; i3++) {
                int iF = ew4.F();
                int iF2 = ew4.F();
                int iF3 = ew4.F();
                int iF4 = ew4.F();
                double d = iF2;
                double d2 = iF3 - 128;
                double d3 = iF4 - 128;
                this.b[iF] = (AbstractC9683aN7.p((int) ((d - (0.34414d * d3)) - (d2 * 0.71414d)), 0, 255) << 8) | (ew4.F() << 24) | (AbstractC9683aN7.p((int) ((1.402d * d2) + d), 0, 255) << 16) | AbstractC9683aN7.p((int) (d + (d3 * 1.772d)), 0, 255);
            }
            this.c = true;
        }

        public C14451hw1 d() {
            int iF;
            if (this.d == 0 || this.e == 0 || this.h == 0 || this.i == 0 || this.a.g() == 0 || this.a.f() != this.a.g() || !this.c) {
                return null;
            }
            this.a.S(0);
            int i = this.h * this.i;
            int[] iArr = new int[i];
            int i2 = 0;
            while (i2 < i) {
                int iF2 = this.a.F();
                if (iF2 != 0) {
                    iF = i2 + 1;
                    iArr[i2] = this.b[iF2];
                } else {
                    int iF3 = this.a.F();
                    if (iF3 != 0) {
                        iF = ((iF3 & 64) == 0 ? iF3 & 63 : ((iF3 & 63) << 8) | this.a.F()) + i2;
                        Arrays.fill(iArr, i2, iF, (iF3 & 128) == 0 ? 0 : this.b[this.a.F()]);
                    }
                }
                i2 = iF;
            }
            return new C14451hw1.b().f(Bitmap.createBitmap(iArr, this.h, this.i, Bitmap.Config.ARGB_8888)).k(this.f / this.d).l(0).h(this.g / this.e, 0).i(0).n(this.h / this.d).g(this.i / this.e).a();
        }

        public void h() {
            this.d = 0;
            this.e = 0;
            this.f = 0;
            this.g = 0;
            this.h = 0;
            this.i = 0;
            this.a.O(0);
            this.c = false;
        }
    }

    public I75() {
        super("PgsDecoder");
        this.o = new EW4();
        this.p = new EW4();
        this.q = new a();
    }

    private void B(EW4 ew4) {
        if (ew4.a() <= 0 || ew4.h() != 120) {
            return;
        }
        if (this.r == null) {
            this.r = new Inflater();
        }
        if (AbstractC9683aN7.q0(ew4, this.p, this.r)) {
            ew4.Q(this.p.e(), this.p.g());
        }
    }

    private static C14451hw1 C(EW4 ew4, a aVar) {
        int iG = ew4.g();
        int iF = ew4.F();
        int iL = ew4.L();
        int iF2 = ew4.f() + iL;
        C14451hw1 c14451hw1D = null;
        if (iF2 > iG) {
            ew4.S(iG);
            return null;
        }
        if (iF != 128) {
            switch (iF) {
                case 20:
                    aVar.g(ew4, iL);
                    break;
                case 21:
                    aVar.e(ew4, iL);
                    break;
                case 22:
                    aVar.f(ew4, iL);
                    break;
            }
        } else {
            c14451hw1D = aVar.d();
            aVar.h();
        }
        ew4.S(iF2);
        return c14451hw1D;
    }

    @Override // ir.nasim.WC6
    protected InterfaceC24081y07 A(byte[] bArr, int i, boolean z) {
        this.o.Q(bArr, i);
        B(this.o);
        this.q.h();
        ArrayList arrayList = new ArrayList();
        while (this.o.a() >= 3) {
            C14451hw1 c14451hw1C = C(this.o, this.q);
            if (c14451hw1C != null) {
                arrayList.add(c14451hw1C);
            }
        }
        return new J75(Collections.unmodifiableList(arrayList));
    }
}
