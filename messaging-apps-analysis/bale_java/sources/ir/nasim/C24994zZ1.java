package ir.nasim;

import androidx.compose.ui.e;

/* renamed from: ir.nasim.zZ1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C24994zZ1 extends e.c implements InterfaceC8645Wv7, JG1, BZ1, InterfaceC9398Zt3 {
    private static final a u = new a(null);
    public static final int v = 8;
    private InterfaceC14603iB2 o;
    private final UA2 p;
    private final Object q;
    private C24994zZ1 r;
    private BZ1 s;
    private long t;

    /* renamed from: ir.nasim.zZ1$a */
    private static final class a {

        /* renamed from: ir.nasim.zZ1$a$a, reason: collision with other inner class name */
        private static final class C1819a {
            public static final C1819a a = new C1819a();

            private C1819a() {
            }
        }

        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.zZ1$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C23810xZ1 e;
        final /* synthetic */ C24994zZ1 f;
        final /* synthetic */ C9663aL5 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(C23810xZ1 c23810xZ1, C24994zZ1 c24994zZ1, C9663aL5 c9663aL5) {
            super(1);
            this.e = c23810xZ1;
            this.f = c24994zZ1;
            this.g = c9663aL5;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final EnumC8411Vv7 invoke(C24994zZ1 c24994zZ1) {
            if (!c24994zZ1.b2()) {
                return EnumC8411Vv7.b;
            }
            if (!(c24994zZ1.s == null)) {
                M73.b("DragAndDropTarget self reference must be null at the start of a drag and drop session");
            }
            UA2 ua2 = c24994zZ1.p;
            c24994zZ1.s = ua2 != null ? (BZ1) ua2.invoke(this.e) : null;
            boolean z = c24994zZ1.s != null;
            if (z) {
                this.f.B2().b(c24994zZ1);
            }
            C9663aL5 c9663aL5 = this.g;
            c9663aL5.a = c9663aL5.a || z;
            return EnumC8411Vv7.a;
        }
    }

    /* renamed from: ir.nasim.zZ1$c */
    static final class c extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C23810xZ1 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(C23810xZ1 c23810xZ1) {
            super(1);
            this.e = c23810xZ1;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final EnumC8411Vv7 invoke(C24994zZ1 c24994zZ1) {
            if (!c24994zZ1.h().b2()) {
                return EnumC8411Vv7.b;
            }
            BZ1 bz1 = c24994zZ1.s;
            if (bz1 != null) {
                bz1.q0(this.e);
            }
            c24994zZ1.s = null;
            c24994zZ1.r = null;
            return EnumC8411Vv7.a;
        }
    }

    /* renamed from: ir.nasim.zZ1$d */
    public static final class d extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C12889fL5 e;
        final /* synthetic */ C24994zZ1 f;
        final /* synthetic */ C23810xZ1 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(C12889fL5 c12889fL5, C24994zZ1 c24994zZ1, C23810xZ1 c23810xZ1) {
            super(1);
            this.e = c12889fL5;
            this.f = c24994zZ1;
            this.g = c23810xZ1;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final EnumC8411Vv7 invoke(InterfaceC8645Wv7 interfaceC8645Wv7) {
            C24994zZ1 c24994zZ1 = (C24994zZ1) interfaceC8645Wv7;
            if (!this.f.B2().a(c24994zZ1) || !AZ1.d(c24994zZ1, DZ1.a(this.g))) {
                return EnumC8411Vv7.a;
            }
            this.e.a = interfaceC8645Wv7;
            return EnumC8411Vv7.c;
        }
    }

    public /* synthetic */ C24994zZ1(InterfaceC14603iB2 interfaceC14603iB2, UA2 ua2, int i, ED1 ed1) {
        this((i & 1) != 0 ? null : interfaceC14603iB2, (i & 2) != 0 ? null : ua2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC24400yZ1 B2() {
        return KG1.p(this).getDragAndDropManager();
    }

    public final long C2() {
        return this.t;
    }

    @Override // ir.nasim.BZ1
    public void N(C23810xZ1 c23810xZ1) {
        BZ1 bz1 = this.s;
        if (bz1 != null) {
            bz1.N(c23810xZ1);
            return;
        }
        C24994zZ1 c24994zZ1 = this.r;
        if (c24994zZ1 != null) {
            c24994zZ1.N(c23810xZ1);
        }
    }

    @Override // ir.nasim.InterfaceC8645Wv7
    public Object P() {
        return this.q;
    }

    @Override // ir.nasim.BZ1
    public boolean P0(C23810xZ1 c23810xZ1) {
        C24994zZ1 c24994zZ1 = this.r;
        if (c24994zZ1 != null) {
            return c24994zZ1.P0(c23810xZ1);
        }
        BZ1 bz1 = this.s;
        if (bz1 != null) {
            return bz1.P0(c23810xZ1);
        }
        return false;
    }

    @Override // ir.nasim.InterfaceC9398Zt3
    public void S(long j) {
        this.t = j;
    }

    @Override // ir.nasim.BZ1
    public void a0(C23810xZ1 c23810xZ1) {
        InterfaceC8645Wv7 interfaceC8645Wv7;
        C24994zZ1 c24994zZ1;
        C24994zZ1 c24994zZ12 = this.r;
        if (c24994zZ12 == null || !AZ1.d(c24994zZ12, DZ1.a(c23810xZ1))) {
            if (h().b2()) {
                C12889fL5 c12889fL5 = new C12889fL5();
                AbstractC8931Xv7.f(this, new d(c12889fL5, this, c23810xZ1));
                interfaceC8645Wv7 = (InterfaceC8645Wv7) c12889fL5.a;
            } else {
                interfaceC8645Wv7 = null;
            }
            c24994zZ1 = (C24994zZ1) interfaceC8645Wv7;
        } else {
            c24994zZ1 = c24994zZ12;
        }
        if (c24994zZ1 != null && c24994zZ12 == null) {
            AZ1.e(c24994zZ1, c23810xZ1);
            BZ1 bz1 = this.s;
            if (bz1 != null) {
                bz1.v0(c23810xZ1);
            }
        } else if (c24994zZ1 == null && c24994zZ12 != null) {
            BZ1 bz12 = this.s;
            if (bz12 != null) {
                AZ1.e(bz12, c23810xZ1);
            }
            c24994zZ12.v0(c23810xZ1);
        } else if (!AbstractC13042fc3.d(c24994zZ1, c24994zZ12)) {
            if (c24994zZ1 != null) {
                AZ1.e(c24994zZ1, c23810xZ1);
            }
            if (c24994zZ12 != null) {
                c24994zZ12.v0(c23810xZ1);
            }
        } else if (c24994zZ1 != null) {
            c24994zZ1.a0(c23810xZ1);
        } else {
            BZ1 bz13 = this.s;
            if (bz13 != null) {
                bz13.a0(c23810xZ1);
            }
        }
        this.r = c24994zZ1;
    }

    @Override // ir.nasim.BZ1
    public void e0(C23810xZ1 c23810xZ1) {
        BZ1 bz1 = this.s;
        if (bz1 != null) {
            bz1.e0(c23810xZ1);
            return;
        }
        C24994zZ1 c24994zZ1 = this.r;
        if (c24994zZ1 != null) {
            c24994zZ1.e0(c23810xZ1);
        }
    }

    @Override // androidx.compose.ui.e.c
    public void f2() {
        this.s = null;
        this.r = null;
    }

    @Override // ir.nasim.BZ1
    public void q0(C23810xZ1 c23810xZ1) {
        AZ1.f(this, new c(c23810xZ1));
    }

    @Override // ir.nasim.BZ1
    public void v0(C23810xZ1 c23810xZ1) {
        BZ1 bz1 = this.s;
        if (bz1 != null) {
            bz1.v0(c23810xZ1);
        }
        C24994zZ1 c24994zZ1 = this.r;
        if (c24994zZ1 != null) {
            c24994zZ1.v0(c23810xZ1);
        }
        this.r = null;
    }

    public boolean v2(C23810xZ1 c23810xZ1) {
        C9663aL5 c9663aL5 = new C9663aL5();
        AZ1.f(this, new b(c23810xZ1, this, c9663aL5));
        return c9663aL5.a;
    }

    public C24994zZ1(InterfaceC14603iB2 interfaceC14603iB2, UA2 ua2) {
        this.o = interfaceC14603iB2;
        this.p = ua2;
        this.q = a.C1819a.a;
        this.t = C4414Fa3.b.a();
    }
}
