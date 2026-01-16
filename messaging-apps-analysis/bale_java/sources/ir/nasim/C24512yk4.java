package ir.nasim;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.X;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import ir.nasim.AbstractC4754Gk4;
import ir.nasim.E03;
import ir.nasim.InterfaceC24514yk6;
import java.io.EOFException;
import org.xbill.DNS.WKSRecord;

/* renamed from: ir.nasim.yk4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C24512yk4 implements InterfaceC9262Ze2 {
    public static final InterfaceC12462ef2 u = new InterfaceC12462ef2() { // from class: ir.nasim.wk4
        @Override // ir.nasim.InterfaceC12462ef2
        public final InterfaceC9262Ze2[] c() {
            return C24512yk4.o();
        }
    };
    private static final E03.a v = new E03.a() { // from class: ir.nasim.xk4
        @Override // ir.nasim.E03.a
        public final boolean a(int i, int i2, int i3, int i4, int i5) {
            return C24512yk4.p(i, i2, i3, i4, i5);
        }
    };
    private final int a;
    private final long b;
    private final EW4 c;
    private final AbstractC4754Gk4.a d;
    private final ED2 e;
    private final F03 f;
    private final InterfaceC4589Ft7 g;
    private InterfaceC10465bf2 h;
    private InterfaceC4589Ft7 i;
    private InterfaceC4589Ft7 j;
    private int k;
    private Metadata l;
    private long m;
    private long n;
    private long o;
    private int p;
    private InterfaceC24514yk6 q;
    private boolean r;
    private boolean s;
    private long t;

    public C24512yk4() {
        this(0);
    }

    private void g() {
        AbstractC20011rK.i(this.i);
        AbstractC9683aN7.j(this.h);
    }

    private InterfaceC24514yk6 h(InterfaceC9845af2 interfaceC9845af2) {
        long jL;
        long jF;
        InterfaceC24514yk6 interfaceC24514yk6R = r(interfaceC9845af2);
        C8030Uf4 c8030Uf4Q = q(this.l, interfaceC9845af2.getPosition());
        if (this.r) {
            return new InterfaceC24514yk6.a();
        }
        if ((this.a & 4) != 0) {
            if (c8030Uf4Q != null) {
                jL = c8030Uf4Q.i();
                jF = c8030Uf4Q.f();
            } else if (interfaceC24514yk6R != null) {
                jL = interfaceC24514yk6R.i();
                jF = interfaceC24514yk6R.f();
            } else {
                jL = l(this.l);
                jF = -1;
            }
            interfaceC24514yk6R = new C13366g63(jL, interfaceC9845af2.getPosition(), jF);
        } else if (c8030Uf4Q != null) {
            interfaceC24514yk6R = c8030Uf4Q;
        } else if (interfaceC24514yk6R == null) {
            interfaceC24514yk6R = null;
        }
        if (interfaceC24514yk6R == null || !(interfaceC24514yk6R.g() || (this.a & 1) == 0)) {
            return k(interfaceC9845af2, (this.a & 2) != 0);
        }
        return interfaceC24514yk6R;
    }

    private long i(long j) {
        return this.m + ((j * 1000000) / this.d.d);
    }

    private InterfaceC24514yk6 k(InterfaceC9845af2 interfaceC9845af2, boolean z) {
        interfaceC9845af2.m(this.c.e(), 0, 4);
        this.c.S(0);
        this.d.a(this.c.o());
        return new C6824Pd1(interfaceC9845af2.getLength(), interfaceC9845af2.getPosition(), this.d, z);
    }

    private static long l(Metadata metadata) {
        if (metadata == null) {
            return -9223372036854775807L;
        }
        int iE = metadata.e();
        for (int i = 0; i < iE; i++) {
            Metadata.Entry entryD = metadata.d(i);
            if (entryD instanceof TextInformationFrame) {
                TextInformationFrame textInformationFrame = (TextInformationFrame) entryD;
                if (textInformationFrame.a.equals("TLEN")) {
                    return AbstractC9683aN7.B0(Long.parseLong((String) textInformationFrame.d.get(0)));
                }
            }
        }
        return -9223372036854775807L;
    }

    private static int m(EW4 ew4, int i) {
        if (ew4.g() >= i + 4) {
            ew4.S(i);
            int iO = ew4.o();
            if (iO == 1483304551 || iO == 1231971951) {
                return iO;
            }
        }
        if (ew4.g() < 40) {
            return 0;
        }
        ew4.S(36);
        return ew4.o() == 1447187017 ? 1447187017 : 0;
    }

    private static boolean n(int i, long j) {
        return ((long) (i & (-128000))) == (j & (-128000));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ InterfaceC9262Ze2[] o() {
        return new InterfaceC9262Ze2[]{new C24512yk4()};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean p(int i, int i2, int i3, int i4, int i5) {
        return (i2 == 67 && i3 == 79 && i4 == 77 && (i5 == 77 || i == 2)) || (i2 == 77 && i3 == 76 && i4 == 76 && (i5 == 84 || i == 2));
    }

    private static C8030Uf4 q(Metadata metadata, long j) {
        if (metadata == null) {
            return null;
        }
        int iE = metadata.e();
        for (int i = 0; i < iE; i++) {
            Metadata.Entry entryD = metadata.d(i);
            if (entryD instanceof MlltFrame) {
                return C8030Uf4.a(j, (MlltFrame) entryD, l(metadata));
            }
        }
        return null;
    }

    private InterfaceC24514yk6 r(InterfaceC9845af2 interfaceC9845af2) {
        EW4 ew4 = new EW4(this.d.c);
        interfaceC9845af2.m(ew4.e(), 0, this.d.c);
        AbstractC4754Gk4.a aVar = this.d;
        int i = 21;
        if ((aVar.a & 1) != 0) {
            if (aVar.e != 1) {
                i = 36;
            }
        } else if (aVar.e == 1) {
            i = 13;
        }
        int i2 = i;
        int iM = m(ew4, i2);
        if (iM != 1483304551 && iM != 1231971951) {
            if (iM != 1447187017) {
                interfaceC9845af2.e();
                return null;
            }
            NQ7 nq7A = NQ7.a(interfaceC9845af2.getLength(), interfaceC9845af2.getPosition(), this.d, ew4);
            interfaceC9845af2.k(this.d.c);
            return nq7A;
        }
        C16047kc8 c16047kc8A = C16047kc8.a(interfaceC9845af2.getLength(), interfaceC9845af2.getPosition(), this.d, ew4);
        if (c16047kc8A != null && !this.e.a()) {
            interfaceC9845af2.e();
            interfaceC9845af2.h(i2 + WKSRecord.Service.EMFIS_CNTL);
            interfaceC9845af2.m(this.c.e(), 0, 3);
            this.c.S(0);
            this.e.d(this.c.I());
        }
        interfaceC9845af2.k(this.d.c);
        return (c16047kc8A == null || c16047kc8A.g() || iM != 1231971951) ? c16047kc8A : k(interfaceC9845af2, false);
    }

    private boolean s(InterfaceC9845af2 interfaceC9845af2) {
        InterfaceC24514yk6 interfaceC24514yk6 = this.q;
        if (interfaceC24514yk6 != null) {
            long jF = interfaceC24514yk6.f();
            if (jF != -1 && interfaceC9845af2.g() > jF - 4) {
                return true;
            }
        }
        try {
            return !interfaceC9845af2.c(this.c.e(), 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    private int t(InterfaceC9845af2 interfaceC9845af2) throws ParserException {
        if (this.k == 0) {
            try {
                v(interfaceC9845af2, false);
            } catch (EOFException unused) {
                return -1;
            }
        }
        if (this.q == null) {
            InterfaceC24514yk6 interfaceC24514yk6H = h(interfaceC9845af2);
            this.q = interfaceC24514yk6H;
            this.h.o(interfaceC24514yk6H);
            this.j.c(new X.b().g0(this.d.b).Y(4096).J(this.d.e).h0(this.d.d).P(this.e.a).Q(this.e.b).Z((this.a & 8) != 0 ? null : this.l).G());
            this.o = interfaceC9845af2.getPosition();
        } else if (this.o != 0) {
            long position = interfaceC9845af2.getPosition();
            long j = this.o;
            if (position < j) {
                interfaceC9845af2.k((int) (j - position));
            }
        }
        return u(interfaceC9845af2);
    }

    private int u(InterfaceC9845af2 interfaceC9845af2) {
        if (this.p == 0) {
            interfaceC9845af2.e();
            if (s(interfaceC9845af2)) {
                return -1;
            }
            this.c.S(0);
            int iO = this.c.o();
            if (!n(iO, this.k) || AbstractC4754Gk4.j(iO) == -1) {
                interfaceC9845af2.k(1);
                this.k = 0;
                return 0;
            }
            this.d.a(iO);
            if (this.m == -9223372036854775807L) {
                this.m = this.q.h(interfaceC9845af2.getPosition());
                if (this.b != -9223372036854775807L) {
                    this.m += this.b - this.q.h(0L);
                }
            }
            this.p = this.d.c;
            InterfaceC24514yk6 interfaceC24514yk6 = this.q;
            if (interfaceC24514yk6 instanceof C13366g63) {
                C13366g63 c13366g63 = (C13366g63) interfaceC24514yk6;
                c13366g63.b(i(this.n + r0.g), interfaceC9845af2.getPosition() + this.d.c);
                if (this.s && c13366g63.a(this.t)) {
                    this.s = false;
                    this.j = this.i;
                }
            }
        }
        int iF = this.j.f(interfaceC9845af2, this.p, true);
        if (iF == -1) {
            return -1;
        }
        int i = this.p - iF;
        this.p = i;
        if (i > 0) {
            return 0;
        }
        this.j.b(i(this.n), 1, this.d.c, 0, null);
        this.n += this.d.g;
        this.p = 0;
        return 0;
    }

    private boolean v(InterfaceC9845af2 interfaceC9845af2, boolean z) throws ParserException, EOFException {
        int iG;
        int i;
        int iJ;
        int i2 = z ? 32768 : 131072;
        interfaceC9845af2.e();
        if (interfaceC9845af2.getPosition() == 0) {
            Metadata metadataA = this.f.a(interfaceC9845af2, (this.a & 8) == 0 ? null : v);
            this.l = metadataA;
            if (metadataA != null) {
                this.e.c(metadataA);
            }
            iG = (int) interfaceC9845af2.g();
            if (!z) {
                interfaceC9845af2.k(iG);
            }
            i = 0;
        } else {
            iG = 0;
            i = 0;
        }
        int i3 = i;
        int i4 = i3;
        while (true) {
            if (!s(interfaceC9845af2)) {
                this.c.S(0);
                int iO = this.c.o();
                if ((i == 0 || n(iO, i)) && (iJ = AbstractC4754Gk4.j(iO)) != -1) {
                    i3++;
                    if (i3 != 1) {
                        if (i3 == 4) {
                            break;
                        }
                    } else {
                        this.d.a(iO);
                        i = iO;
                    }
                    interfaceC9845af2.h(iJ - 4);
                } else {
                    int i5 = i4 + 1;
                    if (i4 == i2) {
                        if (z) {
                            return false;
                        }
                        throw ParserException.a("Searched too many bytes.", null);
                    }
                    if (z) {
                        interfaceC9845af2.e();
                        interfaceC9845af2.h(iG + i5);
                    } else {
                        interfaceC9845af2.k(1);
                    }
                    i3 = 0;
                    i4 = i5;
                    i = 0;
                }
            } else if (i3 <= 0) {
                throw new EOFException();
            }
        }
        if (z) {
            interfaceC9845af2.k(iG + i4);
        } else {
            interfaceC9845af2.e();
        }
        this.k = i;
        return true;
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public void a(long j, long j2) {
        this.k = 0;
        this.m = -9223372036854775807L;
        this.n = 0L;
        this.p = 0;
        this.t = j2;
        InterfaceC24514yk6 interfaceC24514yk6 = this.q;
        if (!(interfaceC24514yk6 instanceof C13366g63) || ((C13366g63) interfaceC24514yk6).a(j2)) {
            return;
        }
        this.s = true;
        this.j = this.g;
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public void b(InterfaceC10465bf2 interfaceC10465bf2) {
        this.h = interfaceC10465bf2;
        InterfaceC4589Ft7 interfaceC4589Ft7B = interfaceC10465bf2.b(0, 1);
        this.i = interfaceC4589Ft7B;
        this.j = interfaceC4589Ft7B;
        this.h.s();
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public boolean d(InterfaceC9845af2 interfaceC9845af2) {
        return v(interfaceC9845af2, true);
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public int e(InterfaceC9845af2 interfaceC9845af2, C8292Vi5 c8292Vi5) throws ParserException {
        g();
        int iT = t(interfaceC9845af2);
        if (iT == -1 && (this.q instanceof C13366g63)) {
            long jI = i(this.n);
            if (this.q.i() != jI) {
                ((C13366g63) this.q).d(jI);
                this.h.o(this.q);
            }
        }
        return iT;
    }

    public void j() {
        this.r = true;
    }

    public C24512yk4(int i) {
        this(i, -9223372036854775807L);
    }

    public C24512yk4(int i, long j) {
        this.a = (i & 2) != 0 ? i | 1 : i;
        this.b = j;
        this.c = new EW4(10);
        this.d = new AbstractC4754Gk4.a();
        this.e = new ED2();
        this.m = -9223372036854775807L;
        this.f = new F03();
        P12 p12 = new P12();
        this.g = p12;
        this.j = p12;
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public void release() {
    }
}
