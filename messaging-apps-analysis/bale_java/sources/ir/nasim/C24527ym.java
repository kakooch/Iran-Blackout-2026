package ir.nasim;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.X;
import ir.nasim.InterfaceC22148uk6;
import java.io.EOFException;
import java.util.Arrays;

/* renamed from: ir.nasim.ym, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C24527ym implements InterfaceC9262Ze2 {
    private static final int[] r;
    private static final int u;
    private final byte[] a;
    private final int b;
    private boolean c;
    private long d;
    private int e;
    private int f;
    private boolean g;
    private long h;
    private int i;
    private int j;
    private long k;
    private InterfaceC10465bf2 l;
    private InterfaceC4589Ft7 m;
    private InterfaceC22148uk6 n;
    private boolean o;
    public static final InterfaceC12462ef2 p = new InterfaceC12462ef2() { // from class: ir.nasim.xm
        @Override // ir.nasim.InterfaceC12462ef2
        public final InterfaceC9262Ze2[] c() {
            return C24527ym.m();
        }
    };
    private static final int[] q = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};
    private static final byte[] s = AbstractC9683aN7.m0("#!AMR\n");
    private static final byte[] t = AbstractC9683aN7.m0("#!AMR-WB\n");

    static {
        int[] iArr = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
        r = iArr;
        u = iArr[8];
    }

    public C24527ym() {
        this(0);
    }

    private void f() {
        AbstractC20011rK.i(this.m);
        AbstractC9683aN7.j(this.l);
    }

    private static int g(int i, long j) {
        return (int) ((i * 8000000) / j);
    }

    private InterfaceC22148uk6 h(long j, boolean z) {
        return new C6585Od1(j, this.h, g(this.i, 20000L), this.i, z);
    }

    private int i(int i) throws ParserException {
        if (k(i)) {
            return this.c ? r[i] : q[i];
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Illegal AMR ");
        sb.append(this.c ? "WB" : "NB");
        sb.append(" frame type ");
        sb.append(i);
        throw ParserException.a(sb.toString(), null);
    }

    private boolean j(int i) {
        return !this.c && (i < 12 || i > 14);
    }

    private boolean k(int i) {
        return i >= 0 && i <= 15 && (l(i) || j(i));
    }

    private boolean l(int i) {
        return this.c && (i < 10 || i > 13);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ InterfaceC9262Ze2[] m() {
        return new InterfaceC9262Ze2[]{new C24527ym()};
    }

    private void n() {
        if (this.o) {
            return;
        }
        this.o = true;
        boolean z = this.c;
        this.m.c(new X.b().g0(z ? "audio/amr-wb" : "audio/3gpp").Y(u).J(1).h0(z ? 16000 : 8000).G());
    }

    private void o(long j, int i) {
        int i2;
        if (this.g) {
            return;
        }
        int i3 = this.b;
        if ((i3 & 1) == 0 || j == -1 || !((i2 = this.i) == -1 || i2 == this.e)) {
            InterfaceC22148uk6.b bVar = new InterfaceC22148uk6.b(-9223372036854775807L);
            this.n = bVar;
            this.l.o(bVar);
            this.g = true;
            return;
        }
        if (this.j >= 20 || i == -1) {
            InterfaceC22148uk6 interfaceC22148uk6H = h(j, (i3 & 2) != 0);
            this.n = interfaceC22148uk6H;
            this.l.o(interfaceC22148uk6H);
            this.g = true;
        }
    }

    private static boolean p(InterfaceC9845af2 interfaceC9845af2, byte[] bArr) {
        interfaceC9845af2.e();
        byte[] bArr2 = new byte[bArr.length];
        interfaceC9845af2.m(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, bArr);
    }

    private int q(InterfaceC9845af2 interfaceC9845af2) throws ParserException {
        interfaceC9845af2.e();
        interfaceC9845af2.m(this.a, 0, 1);
        byte b = this.a[0];
        if ((b & 131) <= 0) {
            return i((b >> 3) & 15);
        }
        throw ParserException.a("Invalid padding bits for frame header " + ((int) b), null);
    }

    private boolean r(InterfaceC9845af2 interfaceC9845af2) {
        byte[] bArr = s;
        if (p(interfaceC9845af2, bArr)) {
            this.c = false;
            interfaceC9845af2.k(bArr.length);
            return true;
        }
        byte[] bArr2 = t;
        if (!p(interfaceC9845af2, bArr2)) {
            return false;
        }
        this.c = true;
        interfaceC9845af2.k(bArr2.length);
        return true;
    }

    private int s(InterfaceC9845af2 interfaceC9845af2) throws ParserException {
        if (this.f == 0) {
            try {
                int iQ = q(interfaceC9845af2);
                this.e = iQ;
                this.f = iQ;
                if (this.i == -1) {
                    this.h = interfaceC9845af2.getPosition();
                    this.i = this.e;
                }
                if (this.i == this.e) {
                    this.j++;
                }
            } catch (EOFException unused) {
                return -1;
            }
        }
        int iF = this.m.f(interfaceC9845af2, this.f, true);
        if (iF == -1) {
            return -1;
        }
        int i = this.f - iF;
        this.f = i;
        if (i > 0) {
            return 0;
        }
        this.m.b(this.k + this.d, 1, this.e, 0, null);
        this.d += 20000;
        return 0;
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public void a(long j, long j2) {
        this.d = 0L;
        this.e = 0;
        this.f = 0;
        if (j != 0) {
            InterfaceC22148uk6 interfaceC22148uk6 = this.n;
            if (interfaceC22148uk6 instanceof C6585Od1) {
                this.k = ((C6585Od1) interfaceC22148uk6).b(j);
                return;
            }
        }
        this.k = 0L;
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public void b(InterfaceC10465bf2 interfaceC10465bf2) {
        this.l = interfaceC10465bf2;
        this.m = interfaceC10465bf2.b(0, 1);
        interfaceC10465bf2.s();
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public boolean d(InterfaceC9845af2 interfaceC9845af2) {
        return r(interfaceC9845af2);
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public int e(InterfaceC9845af2 interfaceC9845af2, C8292Vi5 c8292Vi5) throws ParserException {
        f();
        if (interfaceC9845af2.getPosition() == 0 && !r(interfaceC9845af2)) {
            throw ParserException.a("Could not find AMR header.", null);
        }
        n();
        int iS = s(interfaceC9845af2);
        o(interfaceC9845af2.getLength(), iS);
        return iS;
    }

    public C24527ym(int i) {
        this.b = (i & 2) != 0 ? i | 1 : i;
        this.a = new byte[1];
        this.i = -1;
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public void release() {
    }
}
