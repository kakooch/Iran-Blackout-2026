package ir.nasim;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.X;
import ir.nasim.InterfaceC22148uk6;
import java.util.ArrayList;

/* renamed from: ir.nasim.yV, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C24362yV implements InterfaceC9262Ze2 {
    private int c;
    private C24956zV e;
    private long h;
    private OT0 i;
    private int m;
    private boolean n;
    private final EW4 a = new EW4(12);
    private final c b = new c();
    private InterfaceC10465bf2 d = new O12();
    private OT0[] g = new OT0[0];
    private long k = -1;
    private long l = -1;
    private int j = -1;
    private long f = -9223372036854775807L;

    /* renamed from: ir.nasim.yV$b */
    private class b implements InterfaceC22148uk6 {
        private final long a;

        public b(long j) {
            this.a = j;
        }

        @Override // ir.nasim.InterfaceC22148uk6
        public InterfaceC22148uk6.a c(long j) {
            InterfaceC22148uk6.a aVarI = C24362yV.this.g[0].i(j);
            for (int i = 1; i < C24362yV.this.g.length; i++) {
                InterfaceC22148uk6.a aVarI2 = C24362yV.this.g[i].i(j);
                if (aVarI2.a.b < aVarI.a.b) {
                    aVarI = aVarI2;
                }
            }
            return aVarI;
        }

        @Override // ir.nasim.InterfaceC22148uk6
        public boolean g() {
            return true;
        }

        @Override // ir.nasim.InterfaceC22148uk6
        public long i() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.yV$c */
    private static class c {
        public int a;
        public int b;
        public int c;

        private c() {
        }

        public void a(EW4 ew4) {
            this.a = ew4.s();
            this.b = ew4.s();
            this.c = 0;
        }

        public void b(EW4 ew4) throws ParserException {
            a(ew4);
            if (this.a == 1414744396) {
                this.c = ew4.s();
                return;
            }
            throw ParserException.a("LIST expected, found: " + this.a, null);
        }
    }

    private static void f(InterfaceC9845af2 interfaceC9845af2) {
        if ((interfaceC9845af2.getPosition() & 1) == 1) {
            interfaceC9845af2.k(1);
        }
    }

    private OT0 g(int i) {
        for (OT0 ot0 : this.g) {
            if (ot0.j(i)) {
                return ot0;
            }
        }
        return null;
    }

    private void h(EW4 ew4) throws ParserException {
        CB3 cb3C = CB3.c(1819436136, ew4);
        if (cb3C.getType() != 1819436136) {
            throw ParserException.a("Unexpected header list type " + cb3C.getType(), null);
        }
        C24956zV c24956zV = (C24956zV) cb3C.b(C24956zV.class);
        if (c24956zV == null) {
            throw ParserException.a("AviHeader not found", null);
        }
        this.e = c24956zV;
        this.f = c24956zV.c * c24956zV.a;
        ArrayList arrayList = new ArrayList();
        DB7 it = cb3C.a.iterator();
        int i = 0;
        while (it.hasNext()) {
            InterfaceC23772xV interfaceC23772xV = (InterfaceC23772xV) it.next();
            if (interfaceC23772xV.getType() == 1819440243) {
                int i2 = i + 1;
                OT0 ot0K = k((CB3) interfaceC23772xV, i);
                if (ot0K != null) {
                    arrayList.add(ot0K);
                }
                i = i2;
            }
        }
        this.g = (OT0[]) arrayList.toArray(new OT0[0]);
        this.d.s();
    }

    private void i(EW4 ew4) {
        long j = j(ew4);
        while (ew4.a() >= 16) {
            int iS = ew4.s();
            int iS2 = ew4.s();
            long jS = ew4.s() + j;
            ew4.s();
            OT0 ot0G = g(iS);
            if (ot0G != null) {
                if ((iS2 & 16) == 16) {
                    ot0G.b(jS);
                }
                ot0G.k();
            }
        }
        for (OT0 ot0 : this.g) {
            ot0.c();
        }
        this.n = true;
        this.d.o(new b(this.f));
    }

    private long j(EW4 ew4) {
        if (ew4.a() < 16) {
            return 0L;
        }
        int iF = ew4.f();
        ew4.T(8);
        long jS = ew4.s();
        long j = this.k;
        long j2 = jS <= j ? j + 8 : 0L;
        ew4.S(iF);
        return j2;
    }

    private OT0 k(CB3 cb3, int i) {
        AV av = (AV) cb3.b(AV.class);
        TX6 tx6 = (TX6) cb3.b(TX6.class);
        if (av == null) {
            AbstractC18815pI3.k("AviExtractor", "Missing Stream Header");
            return null;
        }
        if (tx6 == null) {
            AbstractC18815pI3.k("AviExtractor", "Missing Stream Format");
            return null;
        }
        long jA = av.a();
        com.google.android.exoplayer2.X x = tx6.a;
        X.b bVarC = x.c();
        bVarC.T(i);
        int i2 = av.f;
        if (i2 != 0) {
            bVarC.Y(i2);
        }
        XX6 xx6 = (XX6) cb3.b(XX6.class);
        if (xx6 != null) {
            bVarC.W(xx6.a);
        }
        int iK = AbstractC24462yf4.k(x.l);
        if (iK != 1 && iK != 2) {
            return null;
        }
        InterfaceC4589Ft7 interfaceC4589Ft7B = this.d.b(i, iK);
        interfaceC4589Ft7B.c(bVarC.G());
        OT0 ot0 = new OT0(i, iK, jA, av.e, interfaceC4589Ft7B);
        this.f = jA;
        return ot0;
    }

    private int l(InterfaceC9845af2 interfaceC9845af2) {
        if (interfaceC9845af2.getPosition() >= this.l) {
            return -1;
        }
        OT0 ot0 = this.i;
        if (ot0 == null) {
            f(interfaceC9845af2);
            interfaceC9845af2.m(this.a.e(), 0, 12);
            this.a.S(0);
            int iS = this.a.s();
            if (iS == 1414744396) {
                this.a.S(8);
                interfaceC9845af2.k(this.a.s() != 1769369453 ? 8 : 12);
                interfaceC9845af2.e();
                return 0;
            }
            int iS2 = this.a.s();
            if (iS == 1263424842) {
                this.h = interfaceC9845af2.getPosition() + iS2 + 8;
                return 0;
            }
            interfaceC9845af2.k(8);
            interfaceC9845af2.e();
            OT0 ot0G = g(iS);
            if (ot0G == null) {
                this.h = interfaceC9845af2.getPosition() + iS2;
                return 0;
            }
            ot0G.n(iS2);
            this.i = ot0G;
        } else if (ot0.m(interfaceC9845af2)) {
            this.i = null;
        }
        return 0;
    }

    private boolean m(InterfaceC9845af2 interfaceC9845af2, C8292Vi5 c8292Vi5) {
        boolean z;
        if (this.h != -1) {
            long position = interfaceC9845af2.getPosition();
            long j = this.h;
            if (j < position || j > 262144 + position) {
                c8292Vi5.a = j;
                z = true;
            } else {
                interfaceC9845af2.k((int) (j - position));
                z = false;
            }
        } else {
            z = false;
        }
        this.h = -1L;
        return z;
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public void a(long j, long j2) {
        this.h = -1L;
        this.i = null;
        for (OT0 ot0 : this.g) {
            ot0.o(j);
        }
        if (j != 0) {
            this.c = 6;
        } else if (this.g.length == 0) {
            this.c = 0;
        } else {
            this.c = 3;
        }
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public void b(InterfaceC10465bf2 interfaceC10465bf2) {
        this.c = 0;
        this.d = interfaceC10465bf2;
        this.h = -1L;
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public boolean d(InterfaceC9845af2 interfaceC9845af2) {
        interfaceC9845af2.m(this.a.e(), 0, 12);
        this.a.S(0);
        if (this.a.s() != 1179011410) {
            return false;
        }
        this.a.T(4);
        return this.a.s() == 541677121;
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public int e(InterfaceC9845af2 interfaceC9845af2, C8292Vi5 c8292Vi5) throws ParserException {
        if (m(interfaceC9845af2, c8292Vi5)) {
            return 1;
        }
        switch (this.c) {
            case 0:
                if (!d(interfaceC9845af2)) {
                    throw ParserException.a("AVI Header List not found", null);
                }
                interfaceC9845af2.k(12);
                this.c = 1;
                return 0;
            case 1:
                interfaceC9845af2.readFully(this.a.e(), 0, 12);
                this.a.S(0);
                this.b.b(this.a);
                c cVar = this.b;
                if (cVar.c == 1819436136) {
                    this.j = cVar.b;
                    this.c = 2;
                    return 0;
                }
                throw ParserException.a("hdrl expected, found: " + this.b.c, null);
            case 2:
                int i = this.j - 4;
                EW4 ew4 = new EW4(i);
                interfaceC9845af2.readFully(ew4.e(), 0, i);
                h(ew4);
                this.c = 3;
                return 0;
            case 3:
                if (this.k != -1) {
                    long position = interfaceC9845af2.getPosition();
                    long j = this.k;
                    if (position != j) {
                        this.h = j;
                        return 0;
                    }
                }
                interfaceC9845af2.m(this.a.e(), 0, 12);
                interfaceC9845af2.e();
                this.a.S(0);
                this.b.a(this.a);
                int iS = this.a.s();
                int i2 = this.b.a;
                if (i2 == 1179011410) {
                    interfaceC9845af2.k(12);
                    return 0;
                }
                if (i2 != 1414744396 || iS != 1769369453) {
                    this.h = interfaceC9845af2.getPosition() + this.b.b + 8;
                    return 0;
                }
                long position2 = interfaceC9845af2.getPosition();
                this.k = position2;
                this.l = position2 + this.b.b + 8;
                if (!this.n) {
                    if (((C24956zV) AbstractC20011rK.e(this.e)).a()) {
                        this.c = 4;
                        this.h = this.l;
                        return 0;
                    }
                    this.d.o(new InterfaceC22148uk6.b(this.f));
                    this.n = true;
                }
                this.h = interfaceC9845af2.getPosition() + 12;
                this.c = 6;
                return 0;
            case 4:
                interfaceC9845af2.readFully(this.a.e(), 0, 8);
                this.a.S(0);
                int iS2 = this.a.s();
                int iS3 = this.a.s();
                if (iS2 == 829973609) {
                    this.c = 5;
                    this.m = iS3;
                } else {
                    this.h = interfaceC9845af2.getPosition() + iS3;
                }
                return 0;
            case 5:
                EW4 ew42 = new EW4(this.m);
                interfaceC9845af2.readFully(ew42.e(), 0, this.m);
                i(ew42);
                this.c = 6;
                this.h = this.k;
                return 0;
            case 6:
                return l(interfaceC9845af2);
            default:
                throw new AssertionError();
        }
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public void release() {
    }
}
