package ir.nasim;

import com.google.android.exoplayer2.ParserException;

/* renamed from: ir.nasim.gH4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C13470gH4 implements InterfaceC9262Ze2 {
    public static final InterfaceC12462ef2 d = new InterfaceC12462ef2() { // from class: ir.nasim.fH4
        @Override // ir.nasim.InterfaceC12462ef2
        public final InterfaceC9262Ze2[] c() {
            return C13470gH4.f();
        }
    };
    private InterfaceC10465bf2 a;
    private YX6 b;
    private boolean c;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ InterfaceC9262Ze2[] f() {
        return new InterfaceC9262Ze2[]{new C13470gH4()};
    }

    private static EW4 g(EW4 ew4) {
        ew4.S(0);
        return ew4;
    }

    private boolean h(InterfaceC9845af2 interfaceC9845af2) {
        C14663iH4 c14663iH4 = new C14663iH4();
        if (c14663iH4.a(interfaceC9845af2, true) && (c14663iH4.b & 2) == 2) {
            int iMin = Math.min(c14663iH4.i, 8);
            EW4 ew4 = new EW4(iMin);
            interfaceC9845af2.m(ew4.e(), 0, iMin);
            if (C3373Ap2.p(g(ew4))) {
                this.b = new C3373Ap2();
            } else if (C15703k18.r(g(ew4))) {
                this.b = new C15703k18();
            } else if (ML4.o(g(ew4))) {
                this.b = new ML4();
            }
            return true;
        }
        return false;
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public void a(long j, long j2) {
        YX6 yx6 = this.b;
        if (yx6 != null) {
            yx6.m(j, j2);
        }
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public void b(InterfaceC10465bf2 interfaceC10465bf2) {
        this.a = interfaceC10465bf2;
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public boolean d(InterfaceC9845af2 interfaceC9845af2) {
        try {
            return h(interfaceC9845af2);
        } catch (ParserException unused) {
            return false;
        }
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public int e(InterfaceC9845af2 interfaceC9845af2, C8292Vi5 c8292Vi5) throws ParserException {
        AbstractC20011rK.i(this.a);
        if (this.b == null) {
            if (!h(interfaceC9845af2)) {
                throw ParserException.a("Failed to determine bitstream type", null);
            }
            interfaceC9845af2.e();
        }
        if (!this.c) {
            InterfaceC4589Ft7 interfaceC4589Ft7B = this.a.b(0, 1);
            this.a.s();
            this.b.d(this.a, interfaceC4589Ft7B);
            this.c = true;
        }
        return this.b.g(interfaceC9845af2, c8292Vi5);
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public void release() {
    }
}
