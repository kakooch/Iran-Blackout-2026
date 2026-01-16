package ir.nasim;

import android.util.SparseArray;
import com.google.android.exoplayer2.X;
import ir.nasim.AbstractC6193Mo4;
import ir.nasim.InterfaceC22268uw7;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class RS2 implements B52 {
    private final C3580Bl6 a;
    private final boolean b;
    private final boolean c;
    private long g;
    private String i;
    private InterfaceC4589Ft7 j;
    private b k;
    private boolean l;
    private boolean n;
    private final boolean[] h = new boolean[3];
    private final C5960Lo4 d = new C5960Lo4(7, 128);
    private final C5960Lo4 e = new C5960Lo4(8, 128);
    private final C5960Lo4 f = new C5960Lo4(6, 128);
    private long m = -9223372036854775807L;
    private final EW4 o = new EW4();

    private static final class b {
        private final InterfaceC4589Ft7 a;
        private final boolean b;
        private final boolean c;
        private final SparseArray d = new SparseArray();
        private final SparseArray e = new SparseArray();
        private final FW4 f;
        private byte[] g;
        private int h;
        private int i;
        private long j;
        private boolean k;
        private long l;
        private a m;
        private a n;
        private boolean o;
        private long p;
        private long q;
        private boolean r;

        private static final class a {
            private boolean a;
            private boolean b;
            private AbstractC6193Mo4.c c;
            private int d;
            private int e;
            private int f;
            private int g;
            private boolean h;
            private boolean i;
            private boolean j;
            private boolean k;
            private int l;
            private int m;
            private int n;
            private int o;
            private int p;

            private a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public boolean c(a aVar) {
                int i;
                int i2;
                int i3;
                boolean z;
                if (!this.a) {
                    return false;
                }
                if (!aVar.a) {
                    return true;
                }
                AbstractC6193Mo4.c cVar = (AbstractC6193Mo4.c) AbstractC20011rK.i(this.c);
                AbstractC6193Mo4.c cVar2 = (AbstractC6193Mo4.c) AbstractC20011rK.i(aVar.c);
                return (this.f == aVar.f && this.g == aVar.g && this.h == aVar.h && (!this.i || !aVar.i || this.j == aVar.j) && (((i = this.d) == (i2 = aVar.d) || (i != 0 && i2 != 0)) && (((i3 = cVar.l) != 0 || cVar2.l != 0 || (this.m == aVar.m && this.n == aVar.n)) && ((i3 != 1 || cVar2.l != 1 || (this.o == aVar.o && this.p == aVar.p)) && (z = this.k) == aVar.k && (!z || this.l == aVar.l))))) ? false : true;
            }

            public void b() {
                this.b = false;
                this.a = false;
            }

            public boolean d() {
                int i;
                return this.b && ((i = this.e) == 7 || i == 2);
            }

            public void e(AbstractC6193Mo4.c cVar, int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4, int i5, int i6, int i7, int i8, int i9) {
                this.c = cVar;
                this.d = i;
                this.e = i2;
                this.f = i3;
                this.g = i4;
                this.h = z;
                this.i = z2;
                this.j = z3;
                this.k = z4;
                this.l = i5;
                this.m = i6;
                this.n = i7;
                this.o = i8;
                this.p = i9;
                this.a = true;
                this.b = true;
            }

            public void f(int i) {
                this.e = i;
                this.b = true;
            }
        }

        public b(InterfaceC4589Ft7 interfaceC4589Ft7, boolean z, boolean z2) {
            this.a = interfaceC4589Ft7;
            this.b = z;
            this.c = z2;
            this.m = new a();
            this.n = new a();
            byte[] bArr = new byte[128];
            this.g = bArr;
            this.f = new FW4(bArr, 0, 0);
            g();
        }

        private void d(int i) {
            long j = this.q;
            if (j == -9223372036854775807L) {
                return;
            }
            boolean z = this.r;
            this.a.b(j, z ? 1 : 0, (int) (this.j - this.p), i, null);
        }

        /* JADX WARN: Removed duplicated region for block: B:53:0x0100  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x0103  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x0107  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x0119  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x011f  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x0157  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void a(byte[] r24, int r25, int r26) {
            /*
                Method dump skipped, instructions count: 416
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.RS2.b.a(byte[], int, int):void");
        }

        public boolean b(long j, int i, boolean z, boolean z2) {
            boolean z3 = false;
            if (this.i == 9 || (this.c && this.n.c(this.m))) {
                if (z && this.o) {
                    d(i + ((int) (j - this.j)));
                }
                this.p = this.j;
                this.q = this.l;
                this.r = false;
                this.o = true;
            }
            if (this.b) {
                z2 = this.n.d();
            }
            boolean z4 = this.r;
            int i2 = this.i;
            if (i2 == 5 || (z2 && i2 == 1)) {
                z3 = true;
            }
            boolean z5 = z4 | z3;
            this.r = z5;
            return z5;
        }

        public boolean c() {
            return this.c;
        }

        public void e(AbstractC6193Mo4.b bVar) {
            this.e.append(bVar.a, bVar);
        }

        public void f(AbstractC6193Mo4.c cVar) {
            this.d.append(cVar.d, cVar);
        }

        public void g() {
            this.k = false;
            this.o = false;
            this.n.b();
        }

        public void h(long j, int i, long j2) {
            this.i = i;
            this.l = j2;
            this.j = j;
            if (!this.b || i != 1) {
                if (!this.c) {
                    return;
                }
                if (i != 5 && i != 1 && i != 2) {
                    return;
                }
            }
            a aVar = this.m;
            this.m = this.n;
            this.n = aVar;
            aVar.b();
            this.h = 0;
            this.k = true;
        }
    }

    public RS2(C3580Bl6 c3580Bl6, boolean z, boolean z2) {
        this.a = c3580Bl6;
        this.b = z;
        this.c = z2;
    }

    private void f() {
        AbstractC20011rK.i(this.j);
        AbstractC9683aN7.j(this.k);
    }

    private void g(long j, int i, int i2, long j2) {
        if (!this.l || this.k.c()) {
            this.d.b(i2);
            this.e.b(i2);
            if (this.l) {
                if (this.d.c()) {
                    C5960Lo4 c5960Lo4 = this.d;
                    this.k.f(AbstractC6193Mo4.l(c5960Lo4.d, 3, c5960Lo4.e));
                    this.d.d();
                } else if (this.e.c()) {
                    C5960Lo4 c5960Lo42 = this.e;
                    this.k.e(AbstractC6193Mo4.j(c5960Lo42.d, 3, c5960Lo42.e));
                    this.e.d();
                }
            } else if (this.d.c() && this.e.c()) {
                ArrayList arrayList = new ArrayList();
                C5960Lo4 c5960Lo43 = this.d;
                arrayList.add(Arrays.copyOf(c5960Lo43.d, c5960Lo43.e));
                C5960Lo4 c5960Lo44 = this.e;
                arrayList.add(Arrays.copyOf(c5960Lo44.d, c5960Lo44.e));
                C5960Lo4 c5960Lo45 = this.d;
                AbstractC6193Mo4.c cVarL = AbstractC6193Mo4.l(c5960Lo45.d, 3, c5960Lo45.e);
                C5960Lo4 c5960Lo46 = this.e;
                AbstractC6193Mo4.b bVarJ = AbstractC6193Mo4.j(c5960Lo46.d, 3, c5960Lo46.e);
                this.j.c(new X.b().U(this.i).g0("video/avc").K(GW0.a(cVarL.a, cVarL.b, cVarL.c)).n0(cVarL.f).S(cVarL.g).c0(cVarL.h).V(arrayList).G());
                this.l = true;
                this.k.f(cVarL);
                this.k.e(bVarJ);
                this.d.d();
                this.e.d();
            }
        }
        if (this.f.b(i2)) {
            C5960Lo4 c5960Lo47 = this.f;
            this.o.Q(this.f.d, AbstractC6193Mo4.q(c5960Lo47.d, c5960Lo47.e));
            this.o.S(4);
            this.a.a(j2, this.o);
        }
        if (this.k.b(j, i, this.l, this.n)) {
            this.n = false;
        }
    }

    private void h(byte[] bArr, int i, int i2) {
        if (!this.l || this.k.c()) {
            this.d.a(bArr, i, i2);
            this.e.a(bArr, i, i2);
        }
        this.f.a(bArr, i, i2);
        this.k.a(bArr, i, i2);
    }

    private void i(long j, int i, long j2) {
        if (!this.l || this.k.c()) {
            this.d.e(i);
            this.e.e(i);
        }
        this.f.e(i);
        this.k.h(j, i, j2);
    }

    @Override // ir.nasim.B52
    public void a(EW4 ew4) {
        f();
        int iF = ew4.f();
        int iG = ew4.g();
        byte[] bArrE = ew4.e();
        this.g += ew4.a();
        this.j.d(ew4, ew4.a());
        while (true) {
            int iC = AbstractC6193Mo4.c(bArrE, iF, iG, this.h);
            if (iC == iG) {
                h(bArrE, iF, iG);
                return;
            }
            int iF2 = AbstractC6193Mo4.f(bArrE, iC);
            int i = iC - iF;
            if (i > 0) {
                h(bArrE, iF, iC);
            }
            int i2 = iG - iC;
            long j = this.g - i2;
            g(j, i2, i < 0 ? -i : 0, this.m);
            i(j, iF2, this.m);
            iF = iC + 3;
        }
    }

    @Override // ir.nasim.B52
    public void b() {
        this.g = 0L;
        this.n = false;
        this.m = -9223372036854775807L;
        AbstractC6193Mo4.a(this.h);
        this.d.d();
        this.e.d();
        this.f.d();
        b bVar = this.k;
        if (bVar != null) {
            bVar.g();
        }
    }

    @Override // ir.nasim.B52
    public void c(InterfaceC10465bf2 interfaceC10465bf2, InterfaceC22268uw7.d dVar) {
        dVar.a();
        this.i = dVar.b();
        InterfaceC4589Ft7 interfaceC4589Ft7B = interfaceC10465bf2.b(dVar.c(), 2);
        this.j = interfaceC4589Ft7B;
        this.k = new b(interfaceC4589Ft7B, this.b, this.c);
        this.a.b(interfaceC10465bf2, dVar);
    }

    @Override // ir.nasim.B52
    public void e(long j, int i) {
        if (j != -9223372036854775807L) {
            this.m = j;
        }
        this.n |= (i & 2) != 0;
    }

    @Override // ir.nasim.B52
    public void d() {
    }
}
