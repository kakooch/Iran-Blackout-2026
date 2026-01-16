package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.util.SparseArray;
import ir.nasim.InterfaceC22148uk6;
import ir.nasim.InterfaceC22268uw7;

/* renamed from: ir.nasim.hy5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C14473hy5 implements InterfaceC9262Ze2 {
    public static final InterfaceC12462ef2 l = new InterfaceC12462ef2() { // from class: ir.nasim.gy5
        @Override // ir.nasim.InterfaceC12462ef2
        public final InterfaceC9262Ze2[] c() {
            return C14473hy5.f();
        }
    };
    private final C5045Hq7 a;
    private final SparseArray b;
    private final EW4 c;
    private final C13289fy5 d;
    private boolean e;
    private boolean f;
    private boolean g;
    private long h;
    private C12653ey5 i;
    private InterfaceC10465bf2 j;
    private boolean k;

    /* renamed from: ir.nasim.hy5$a */
    private static final class a {
        private final B52 a;
        private final C5045Hq7 b;
        private final DW4 c = new DW4(new byte[64]);
        private boolean d;
        private boolean e;
        private boolean f;
        private int g;
        private long h;

        public a(B52 b52, C5045Hq7 c5045Hq7) {
            this.a = b52;
            this.b = c5045Hq7;
        }

        private void b() {
            this.c.r(8);
            this.d = this.c.g();
            this.e = this.c.g();
            this.c.r(6);
            this.g = this.c.h(8);
        }

        private void c() {
            this.h = 0L;
            if (this.d) {
                this.c.r(4);
                this.c.r(1);
                this.c.r(1);
                long jH = (this.c.h(3) << 30) | (this.c.h(15) << 15) | this.c.h(15);
                this.c.r(1);
                if (!this.f && this.e) {
                    this.c.r(4);
                    this.c.r(1);
                    this.c.r(1);
                    this.c.r(1);
                    this.b.b((this.c.h(3) << 30) | (this.c.h(15) << 15) | this.c.h(15));
                    this.f = true;
                }
                this.h = this.b.b(jH);
            }
        }

        public void a(EW4 ew4) {
            ew4.j(this.c.a, 0, 3);
            this.c.p(0);
            b();
            ew4.j(this.c.a, 0, this.g);
            this.c.p(0);
            c();
            this.a.e(this.h, 4);
            this.a.a(ew4);
            this.a.d();
        }

        public void d() {
            this.f = false;
            this.a.b();
        }
    }

    public C14473hy5() {
        this(new C5045Hq7(0L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ InterfaceC9262Ze2[] f() {
        return new InterfaceC9262Ze2[]{new C14473hy5()};
    }

    private void g(long j) {
        if (this.k) {
            return;
        }
        this.k = true;
        if (this.d.c() == -9223372036854775807L) {
            this.j.o(new InterfaceC22148uk6.b(this.d.c()));
            return;
        }
        C12653ey5 c12653ey5 = new C12653ey5(this.d.d(), this.d.c(), j);
        this.i = c12653ey5;
        this.j.o(c12653ey5.b());
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public void a(long j, long j2) {
        boolean z = this.a.e() == -9223372036854775807L;
        if (!z) {
            long jC = this.a.c();
            z = (jC == -9223372036854775807L || jC == 0 || jC == j2) ? false : true;
        }
        if (z) {
            this.a.g(j2);
        }
        C12653ey5 c12653ey5 = this.i;
        if (c12653ey5 != null) {
            c12653ey5.h(j2);
        }
        for (int i = 0; i < this.b.size(); i++) {
            ((a) this.b.valueAt(i)).d();
        }
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public void b(InterfaceC10465bf2 interfaceC10465bf2) {
        this.j = interfaceC10465bf2;
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public boolean d(InterfaceC9845af2 interfaceC9845af2) {
        byte[] bArr = new byte[14];
        interfaceC9845af2.m(bArr, 0, 14);
        if (442 != (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        interfaceC9845af2.h(bArr[13] & 7);
        interfaceC9845af2.m(bArr, 0, 3);
        return 1 == ((((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8)) | (bArr[2] & 255));
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public int e(InterfaceC9845af2 interfaceC9845af2, C8292Vi5 c8292Vi5) {
        B52 ps2;
        AbstractC20011rK.i(this.j);
        long length = interfaceC9845af2.getLength();
        if (length != -1 && !this.d.e()) {
            return this.d.g(interfaceC9845af2, c8292Vi5);
        }
        g(length);
        C12653ey5 c12653ey5 = this.i;
        if (c12653ey5 != null && c12653ey5.d()) {
            return this.i.c(interfaceC9845af2, c8292Vi5);
        }
        interfaceC9845af2.e();
        long jG = length != -1 ? length - interfaceC9845af2.g() : -1L;
        if ((jG != -1 && jG < 4) || !interfaceC9845af2.c(this.c.e(), 0, 4, true)) {
            return -1;
        }
        this.c.S(0);
        int iO = this.c.o();
        if (iO == 441) {
            return -1;
        }
        if (iO == 442) {
            interfaceC9845af2.m(this.c.e(), 0, 10);
            this.c.S(9);
            interfaceC9845af2.k((this.c.F() & 7) + 14);
            return 0;
        }
        if (iO == 443) {
            interfaceC9845af2.m(this.c.e(), 0, 2);
            this.c.S(0);
            interfaceC9845af2.k(this.c.L() + 6);
            return 0;
        }
        if (((iO & (-256)) >> 8) != 1) {
            interfaceC9845af2.k(1);
            return 0;
        }
        int i = iO & 255;
        a aVar = (a) this.b.get(i);
        if (!this.e) {
            if (aVar == null) {
                if (i == 189) {
                    ps2 = new C15113j2();
                    this.f = true;
                    this.h = interfaceC9845af2.getPosition();
                } else if ((iO & 224) == 192) {
                    ps2 = new C4505Fk4();
                    this.f = true;
                    this.h = interfaceC9845af2.getPosition();
                } else if ((iO & SetRpcStruct$ComposedRpc.RESPONSE_STICKERS_REPONSE_FIELD_NUMBER) == 224) {
                    ps2 = new PS2();
                    this.g = true;
                    this.h = interfaceC9845af2.getPosition();
                } else {
                    ps2 = null;
                }
                if (ps2 != null) {
                    ps2.c(this.j, new InterfaceC22268uw7.d(i, 256));
                    aVar = new a(ps2, this.a);
                    this.b.put(i, aVar);
                }
            }
            if (interfaceC9845af2.getPosition() > ((this.f && this.g) ? this.h + 8192 : 1048576L)) {
                this.e = true;
                this.j.s();
            }
        }
        interfaceC9845af2.m(this.c.e(), 0, 2);
        this.c.S(0);
        int iL = this.c.L() + 6;
        if (aVar == null) {
            interfaceC9845af2.k(iL);
        } else {
            this.c.O(iL);
            interfaceC9845af2.readFully(this.c.e(), 0, iL);
            this.c.S(6);
            aVar.a(this.c);
            EW4 ew4 = this.c;
            ew4.R(ew4.b());
        }
        return 0;
    }

    public C14473hy5(C5045Hq7 c5045Hq7) {
        this.a = c5045Hq7;
        this.c = new EW4(4096);
        this.b = new SparseArray();
        this.d = new C13289fy5();
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public void release() {
    }
}
