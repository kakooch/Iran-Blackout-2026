package ir.nasim;

import androidx.compose.ui.e;
import ir.nasim.AbstractC4236Eg5;
import java.util.List;

/* renamed from: ir.nasim.dZ2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC11760dZ2 extends e.c implements InterfaceC8645Wv7, InterfaceC8508Wg5, InterfaceC9814ac1 {
    private C20757sZ1 o;
    private InterfaceC4953Hg5 p;
    private boolean q;
    private boolean r;

    /* renamed from: ir.nasim.dZ2$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C12889fL5 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C12889fL5 c12889fL5) {
            super(1);
            this.e = c12889fL5;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(AbstractC11760dZ2 abstractC11760dZ2) {
            if (this.e.a == null && abstractC11760dZ2.r) {
                this.e.a = abstractC11760dZ2;
            } else if (this.e.a != null && abstractC11760dZ2.D2() && abstractC11760dZ2.r) {
                this.e.a = abstractC11760dZ2;
            }
            return Boolean.TRUE;
        }
    }

    /* renamed from: ir.nasim.dZ2$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C9663aL5 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(C9663aL5 c9663aL5) {
            super(1);
            this.e = c9663aL5;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final EnumC8411Vv7 invoke(AbstractC11760dZ2 abstractC11760dZ2) {
            if (!abstractC11760dZ2.r) {
                return EnumC8411Vv7.a;
            }
            this.e.a = false;
            return EnumC8411Vv7.c;
        }
    }

    /* renamed from: ir.nasim.dZ2$c */
    static final class c extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C12889fL5 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(C12889fL5 c12889fL5) {
            super(1);
            this.e = c12889fL5;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final EnumC8411Vv7 invoke(AbstractC11760dZ2 abstractC11760dZ2) {
            EnumC8411Vv7 enumC8411Vv7 = EnumC8411Vv7.a;
            if (!abstractC11760dZ2.r) {
                return enumC8411Vv7;
            }
            this.e.a = abstractC11760dZ2;
            return abstractC11760dZ2.D2() ? EnumC8411Vv7.b : enumC8411Vv7;
        }
    }

    /* renamed from: ir.nasim.dZ2$d */
    static final class d extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C12889fL5 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(C12889fL5 c12889fL5) {
            super(1);
            this.e = c12889fL5;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(AbstractC11760dZ2 abstractC11760dZ2) {
            if (abstractC11760dZ2.D2() && abstractC11760dZ2.r) {
                this.e.a = abstractC11760dZ2;
            }
            return Boolean.TRUE;
        }
    }

    public /* synthetic */ AbstractC11760dZ2(InterfaceC4953Hg5 interfaceC4953Hg5, boolean z, C20757sZ1 c20757sZ1, int i, ED1 ed1) {
        this(interfaceC4953Hg5, (i & 2) != 0 ? false : z, (i & 4) != 0 ? null : c20757sZ1);
    }

    private final void A2() {
        C9663aL5 c9663aL5 = new C9663aL5();
        c9663aL5.a = true;
        if (!this.q) {
            AbstractC8931Xv7.f(this, new b(c9663aL5));
        }
        if (c9663aL5.a) {
            w2();
        }
    }

    private final AbstractC11760dZ2 B2() {
        C12889fL5 c12889fL5 = new C12889fL5();
        AbstractC8931Xv7.f(this, new c(c12889fL5));
        return (AbstractC11760dZ2) c12889fL5.a;
    }

    private final AbstractC11760dZ2 C2() {
        C12889fL5 c12889fL5 = new C12889fL5();
        AbstractC8931Xv7.d(this, new d(c12889fL5));
        return (AbstractC11760dZ2) c12889fL5.a;
    }

    private final void G2() {
        this.r = true;
        A2();
    }

    private final void H2() {
        if (this.r) {
            this.r = false;
            if (b2()) {
                y2();
            }
        }
    }

    private final void w2() {
        InterfaceC4953Hg5 interfaceC4953Hg5;
        AbstractC11760dZ2 abstractC11760dZ2C2 = C2();
        if (abstractC11760dZ2C2 == null || (interfaceC4953Hg5 = abstractC11760dZ2C2.p) == null) {
            interfaceC4953Hg5 = this.p;
        }
        x2(interfaceC4953Hg5);
    }

    private final void y2() {
        C19938rB7 c19938rB7;
        C12889fL5 c12889fL5 = new C12889fL5();
        AbstractC8931Xv7.d(this, new a(c12889fL5));
        AbstractC11760dZ2 abstractC11760dZ2 = (AbstractC11760dZ2) c12889fL5.a;
        if (abstractC11760dZ2 != null) {
            abstractC11760dZ2.w2();
            c19938rB7 = C19938rB7.a;
        } else {
            c19938rB7 = null;
        }
        if (c19938rB7 == null) {
            x2(null);
        }
    }

    private final void z2() {
        AbstractC11760dZ2 abstractC11760dZ2B2;
        if (this.r) {
            if (this.q || (abstractC11760dZ2B2 = B2()) == null) {
                abstractC11760dZ2B2 = this;
            }
            abstractC11760dZ2B2.w2();
        }
    }

    public final boolean D2() {
        return this.q;
    }

    protected final InterfaceC5655Kg5 E2() {
        return (InterfaceC5655Kg5) AbstractC10434bc1.a(this, AbstractC13040fc1.o());
    }

    public abstract boolean F2(int i);

    public final void I2(C20757sZ1 c20757sZ1) {
        this.o = c20757sZ1;
    }

    public final void J2(InterfaceC4953Hg5 interfaceC4953Hg5) {
        if (AbstractC13042fc3.d(this.p, interfaceC4953Hg5)) {
            return;
        }
        this.p = interfaceC4953Hg5;
        if (this.r) {
            A2();
        }
    }

    public final void K2(boolean z) {
        if (this.q != z) {
            this.q = z;
            if (z) {
                if (this.r) {
                    w2();
                }
            } else if (this.r) {
                z2();
            }
        }
    }

    @Override // ir.nasim.InterfaceC8508Wg5
    public long T0() {
        C20757sZ1 c20757sZ1 = this.o;
        return c20757sZ1 != null ? c20757sZ1.a(KG1.k(this)) : AbstractC15034it7.a.b();
    }

    @Override // androidx.compose.ui.e.c
    public void f2() {
        H2();
        super.f2();
    }

    @Override // ir.nasim.InterfaceC8508Wg5
    public void i1() {
        H2();
    }

    @Override // ir.nasim.InterfaceC8508Wg5
    public void k1(C3534Bg5 c3534Bg5, EnumC4002Dg5 enumC4002Dg5, long j) {
        if (enumC4002Dg5 == EnumC4002Dg5.b) {
            List listC = c3534Bg5.c();
            int size = listC.size();
            for (int i = 0; i < size; i++) {
                if (F2(((C6616Og5) listC.get(i)).n())) {
                    int iG = c3534Bg5.g();
                    AbstractC4236Eg5.a aVar = AbstractC4236Eg5.a;
                    if (AbstractC4236Eg5.i(iG, aVar.a())) {
                        G2();
                        return;
                    } else {
                        if (AbstractC4236Eg5.i(c3534Bg5.g(), aVar.b())) {
                            H2();
                            return;
                        }
                        return;
                    }
                }
            }
        }
    }

    public abstract void x2(InterfaceC4953Hg5 interfaceC4953Hg5);

    public AbstractC11760dZ2(InterfaceC4953Hg5 interfaceC4953Hg5, boolean z, C20757sZ1 c20757sZ1) {
        this.o = c20757sZ1;
        this.p = interfaceC4953Hg5;
        this.q = z;
    }
}
