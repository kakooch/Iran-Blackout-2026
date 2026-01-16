package ir.nasim;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata;
import ir.nasim.AbstractC24560yp2;
import ir.nasim.AbstractC25154zp2;
import ir.nasim.InterfaceC22148uk6;

/* renamed from: ir.nasim.xp2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C23970xp2 implements InterfaceC9262Ze2 {
    public static final InterfaceC12462ef2 o = new InterfaceC12462ef2() { // from class: ir.nasim.wp2
        @Override // ir.nasim.InterfaceC12462ef2
        public final InterfaceC9262Ze2[] c() {
            return C23970xp2.j();
        }
    };
    private final byte[] a;
    private final EW4 b;
    private final boolean c;
    private final AbstractC24560yp2.a d;
    private InterfaceC10465bf2 e;
    private InterfaceC4589Ft7 f;
    private int g;
    private Metadata h;
    private C3846Cp2 i;
    private int j;
    private int k;
    private C22784vp2 l;
    private int m;
    private long n;

    public C23970xp2() {
        this(0);
    }

    private long f(EW4 ew4, boolean z) {
        boolean zD;
        AbstractC20011rK.e(this.i);
        int iF = ew4.f();
        while (iF <= ew4.g() - 16) {
            ew4.S(iF);
            if (AbstractC24560yp2.d(ew4, this.i, this.k, this.d)) {
                ew4.S(iF);
                return this.d.a;
            }
            iF++;
        }
        if (!z) {
            ew4.S(iF);
            return -1L;
        }
        while (iF <= ew4.g() - this.j) {
            ew4.S(iF);
            try {
                zD = AbstractC24560yp2.d(ew4, this.i, this.k, this.d);
            } catch (IndexOutOfBoundsException unused) {
                zD = false;
            }
            if (ew4.f() <= ew4.g() ? zD : false) {
                ew4.S(iF);
                return this.d.a;
            }
            iF++;
        }
        ew4.S(ew4.g());
        return -1L;
    }

    private void g(InterfaceC9845af2 interfaceC9845af2) {
        this.k = AbstractC25154zp2.b(interfaceC9845af2);
        ((InterfaceC10465bf2) AbstractC9683aN7.j(this.e)).o(h(interfaceC9845af2.getPosition(), interfaceC9845af2.getLength()));
        this.g = 5;
    }

    private InterfaceC22148uk6 h(long j, long j2) {
        AbstractC20011rK.e(this.i);
        C3846Cp2 c3846Cp2 = this.i;
        if (c3846Cp2.k != null) {
            return new C3612Bp2(c3846Cp2, j);
        }
        if (j2 == -1 || c3846Cp2.j <= 0) {
            return new InterfaceC22148uk6.b(c3846Cp2.f());
        }
        C22784vp2 c22784vp2 = new C22784vp2(c3846Cp2, this.k, j, j2);
        this.l = c22784vp2;
        return c22784vp2.b();
    }

    private void i(InterfaceC9845af2 interfaceC9845af2) {
        byte[] bArr = this.a;
        interfaceC9845af2.m(bArr, 0, bArr.length);
        interfaceC9845af2.e();
        this.g = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ InterfaceC9262Ze2[] j() {
        return new InterfaceC9262Ze2[]{new C23970xp2()};
    }

    private void k() {
        ((InterfaceC4589Ft7) AbstractC9683aN7.j(this.f)).b((this.n * 1000000) / ((C3846Cp2) AbstractC9683aN7.j(this.i)).e, 1, this.m, 0, null);
    }

    private int l(InterfaceC9845af2 interfaceC9845af2, C8292Vi5 c8292Vi5) {
        boolean z;
        AbstractC20011rK.e(this.f);
        AbstractC20011rK.e(this.i);
        C22784vp2 c22784vp2 = this.l;
        if (c22784vp2 != null && c22784vp2.d()) {
            return this.l.c(interfaceC9845af2, c8292Vi5);
        }
        if (this.n == -1) {
            this.n = AbstractC24560yp2.i(interfaceC9845af2, this.i);
            return 0;
        }
        int iG = this.b.g();
        if (iG < 32768) {
            int i = interfaceC9845af2.read(this.b.e(), iG, 32768 - iG);
            z = i == -1;
            if (!z) {
                this.b.R(iG + i);
            } else if (this.b.a() == 0) {
                k();
                return -1;
            }
        } else {
            z = false;
        }
        int iF = this.b.f();
        int i2 = this.m;
        int i3 = this.j;
        if (i2 < i3) {
            EW4 ew4 = this.b;
            ew4.T(Math.min(i3 - i2, ew4.a()));
        }
        long jF = f(this.b, z);
        int iF2 = this.b.f() - iF;
        this.b.S(iF);
        this.f.d(this.b, iF2);
        this.m += iF2;
        if (jF != -1) {
            k();
            this.m = 0;
            this.n = jF;
        }
        if (this.b.a() < 16) {
            int iA = this.b.a();
            System.arraycopy(this.b.e(), this.b.f(), this.b.e(), 0, iA);
            this.b.S(0);
            this.b.R(iA);
        }
        return 0;
    }

    private void m(InterfaceC9845af2 interfaceC9845af2) {
        this.h = AbstractC25154zp2.d(interfaceC9845af2, !this.c);
        this.g = 1;
    }

    private void n(InterfaceC9845af2 interfaceC9845af2) {
        AbstractC25154zp2.a aVar = new AbstractC25154zp2.a(this.i);
        boolean zE = false;
        while (!zE) {
            zE = AbstractC25154zp2.e(interfaceC9845af2, aVar);
            this.i = (C3846Cp2) AbstractC9683aN7.j(aVar.a);
        }
        AbstractC20011rK.e(this.i);
        this.j = Math.max(this.i.c, 6);
        ((InterfaceC4589Ft7) AbstractC9683aN7.j(this.f)).c(this.i.g(this.a, this.h));
        this.g = 4;
    }

    private void o(InterfaceC9845af2 interfaceC9845af2) throws ParserException {
        AbstractC25154zp2.i(interfaceC9845af2);
        this.g = 3;
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public void a(long j, long j2) {
        if (j == 0) {
            this.g = 0;
        } else {
            C22784vp2 c22784vp2 = this.l;
            if (c22784vp2 != null) {
                c22784vp2.h(j2);
            }
        }
        this.n = j2 != 0 ? -1L : 0L;
        this.m = 0;
        this.b.O(0);
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public void b(InterfaceC10465bf2 interfaceC10465bf2) {
        this.e = interfaceC10465bf2;
        this.f = interfaceC10465bf2.b(0, 1);
        interfaceC10465bf2.s();
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public boolean d(InterfaceC9845af2 interfaceC9845af2) {
        AbstractC25154zp2.c(interfaceC9845af2, false);
        return AbstractC25154zp2.a(interfaceC9845af2);
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public int e(InterfaceC9845af2 interfaceC9845af2, C8292Vi5 c8292Vi5) throws ParserException {
        int i = this.g;
        if (i == 0) {
            m(interfaceC9845af2);
            return 0;
        }
        if (i == 1) {
            i(interfaceC9845af2);
            return 0;
        }
        if (i == 2) {
            o(interfaceC9845af2);
            return 0;
        }
        if (i == 3) {
            n(interfaceC9845af2);
            return 0;
        }
        if (i == 4) {
            g(interfaceC9845af2);
            return 0;
        }
        if (i == 5) {
            return l(interfaceC9845af2, c8292Vi5);
        }
        throw new IllegalStateException();
    }

    public C23970xp2(int i) {
        this.a = new byte[42];
        this.b = new EW4(new byte[32768], 0);
        this.c = (i & 1) != 0;
        this.d = new AbstractC24560yp2.a();
        this.g = 0;
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public void release() {
    }
}
