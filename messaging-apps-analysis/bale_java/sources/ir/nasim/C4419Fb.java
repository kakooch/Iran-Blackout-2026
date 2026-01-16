package ir.nasim;

import com.google.android.exoplayer2.ParserException;
import ir.nasim.InterfaceC22148uk6;
import ir.nasim.InterfaceC22268uw7;
import java.io.EOFException;

/* renamed from: ir.nasim.Fb, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C4419Fb implements InterfaceC9262Ze2 {
    public static final InterfaceC12462ef2 m = new InterfaceC12462ef2() { // from class: ir.nasim.Eb
        @Override // ir.nasim.InterfaceC12462ef2
        public final InterfaceC9262Ze2[] c() {
            return C4419Fb.i();
        }
    };
    private final int a;
    private final C4668Gb b;
    private final EW4 c;
    private final EW4 d;
    private final DW4 e;
    private InterfaceC10465bf2 f;
    private long g;
    private long h;
    private int i;
    private boolean j;
    private boolean k;
    private boolean l;

    public C4419Fb() {
        this(0);
    }

    private void f(InterfaceC9845af2 interfaceC9845af2) throws ParserException {
        int iH;
        if (this.j) {
            return;
        }
        this.i = -1;
        interfaceC9845af2.e();
        long j = 0;
        if (interfaceC9845af2.getPosition() == 0) {
            k(interfaceC9845af2);
        }
        int i = 0;
        int i2 = 0;
        do {
            try {
                if (!interfaceC9845af2.c(this.d.e(), 0, 2, true)) {
                    break;
                }
                this.d.S(0);
                if (!C4668Gb.m(this.d.L())) {
                    break;
                }
                if (!interfaceC9845af2.c(this.d.e(), 0, 4, true)) {
                    break;
                }
                this.e.p(14);
                iH = this.e.h(13);
                if (iH <= 6) {
                    this.j = true;
                    throw ParserException.a("Malformed ADTS stream", null);
                }
                j += iH;
                i2++;
                if (i2 == 1000) {
                    break;
                }
            } catch (EOFException unused) {
            }
        } while (interfaceC9845af2.l(iH - 6, true));
        i = i2;
        interfaceC9845af2.e();
        if (i > 0) {
            this.i = (int) (j / i);
        } else {
            this.i = -1;
        }
        this.j = true;
    }

    private static int g(int i, long j) {
        return (int) ((i * 8000000) / j);
    }

    private InterfaceC22148uk6 h(long j, boolean z) {
        return new C6585Od1(j, this.h, g(this.i, this.b.k()), this.i, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ InterfaceC9262Ze2[] i() {
        return new InterfaceC9262Ze2[]{new C4419Fb()};
    }

    private void j(long j, boolean z) {
        if (this.l) {
            return;
        }
        boolean z2 = (this.a & 1) != 0 && this.i > 0;
        if (z2 && this.b.k() == -9223372036854775807L && !z) {
            return;
        }
        if (!z2 || this.b.k() == -9223372036854775807L) {
            this.f.o(new InterfaceC22148uk6.b(-9223372036854775807L));
        } else {
            this.f.o(h(j, (this.a & 2) != 0));
        }
        this.l = true;
    }

    private int k(InterfaceC9845af2 interfaceC9845af2) {
        int i = 0;
        while (true) {
            interfaceC9845af2.m(this.d.e(), 0, 10);
            this.d.S(0);
            if (this.d.I() != 4801587) {
                break;
            }
            this.d.T(3);
            int iE = this.d.E();
            i += iE + 10;
            interfaceC9845af2.h(iE);
        }
        interfaceC9845af2.e();
        interfaceC9845af2.h(i);
        if (this.h == -1) {
            this.h = i;
        }
        return i;
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public void a(long j, long j2) {
        this.k = false;
        this.b.b();
        this.g = j2;
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public void b(InterfaceC10465bf2 interfaceC10465bf2) {
        this.f = interfaceC10465bf2;
        this.b.c(interfaceC10465bf2, new InterfaceC22268uw7.d(0, 1));
        interfaceC10465bf2.s();
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public boolean d(InterfaceC9845af2 interfaceC9845af2) {
        int iK = k(interfaceC9845af2);
        int i = iK;
        int i2 = 0;
        int i3 = 0;
        do {
            interfaceC9845af2.m(this.d.e(), 0, 2);
            this.d.S(0);
            if (C4668Gb.m(this.d.L())) {
                i2++;
                if (i2 >= 4 && i3 > 188) {
                    return true;
                }
                interfaceC9845af2.m(this.d.e(), 0, 4);
                this.e.p(14);
                int iH = this.e.h(13);
                if (iH <= 6) {
                    i++;
                    interfaceC9845af2.e();
                    interfaceC9845af2.h(i);
                } else {
                    interfaceC9845af2.h(iH - 6);
                    i3 += iH;
                }
            } else {
                i++;
                interfaceC9845af2.e();
                interfaceC9845af2.h(i);
            }
            i2 = 0;
            i3 = 0;
        } while (i - iK < 8192);
        return false;
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public int e(InterfaceC9845af2 interfaceC9845af2, C8292Vi5 c8292Vi5) throws ParserException {
        AbstractC20011rK.i(this.f);
        long length = interfaceC9845af2.getLength();
        int i = this.a;
        if ((i & 2) != 0 || ((i & 1) != 0 && length != -1)) {
            f(interfaceC9845af2);
        }
        int i2 = interfaceC9845af2.read(this.c.e(), 0, 2048);
        boolean z = i2 == -1;
        j(length, z);
        if (z) {
            return -1;
        }
        this.c.S(0);
        this.c.R(i2);
        if (!this.k) {
            this.b.e(this.g, 4);
            this.k = true;
        }
        this.b.a(this.c);
        return 0;
    }

    public C4419Fb(int i) {
        this.a = (i & 2) != 0 ? i | 1 : i;
        this.b = new C4668Gb(true);
        this.c = new EW4(2048);
        this.i = -1;
        this.h = -1L;
        EW4 ew4 = new EW4(10);
        this.d = ew4;
        this.e = new DW4(ew4.e());
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public void release() {
    }
}
