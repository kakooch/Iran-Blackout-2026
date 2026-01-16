package ir.nasim;

import androidx.compose.ui.e;
import ir.nasim.AbstractC5581Jy3;
import kotlin.KotlinNothingValueException;

/* renamed from: ir.nasim.sy3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C21005sy3 extends e.c implements InterfaceC20820sf5, InterfaceC9814ac1, InterfaceC15868kJ2, AbstractC5581Jy3.a {
    private AbstractC5581Jy3 o;
    private C6542Ny3 p;
    private C19101pm7 q;
    private final InterfaceC9102Ym4 r = AbstractC13472gH6.d(null, null, 2, null);

    /* renamed from: ir.nasim.sy3$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC14603iB2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC14603iB2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C21005sy3.this.new a(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C21005sy3 c21005sy3 = C21005sy3.this;
                InterfaceC14603iB2 interfaceC14603iB2 = this.d;
                this.b = 1;
                if (AbstractC21440tf5.b(c21005sy3, interfaceC14603iB2, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            throw new KotlinNothingValueException();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C21005sy3(AbstractC5581Jy3 abstractC5581Jy3, C6542Ny3 c6542Ny3, C19101pm7 c19101pm7) {
        this.o = abstractC5581Jy3;
        this.p = c6542Ny3;
        this.q = c19101pm7;
    }

    private void v2(InterfaceC11379cu3 interfaceC11379cu3) {
        this.r.setValue(interfaceC11379cu3);
    }

    @Override // ir.nasim.AbstractC5581Jy3.a
    public C6542Ny3 K1() {
        return this.p;
    }

    @Override // androidx.compose.ui.e.c
    public void e2() {
        this.o.j(this);
    }

    @Override // androidx.compose.ui.e.c
    public void f2() {
        this.o.l(this);
    }

    @Override // ir.nasim.AbstractC5581Jy3.a
    public InterfaceC20600sH6 getSoftwareKeyboardController() {
        return (InterfaceC20600sH6) AbstractC10434bc1.a(this, AbstractC13040fc1.r());
    }

    @Override // ir.nasim.AbstractC5581Jy3.a
    public InterfaceC18354oW7 getViewConfiguration() {
        return (InterfaceC18354oW7) AbstractC10434bc1.a(this, AbstractC13040fc1.u());
    }

    @Override // ir.nasim.AbstractC5581Jy3.a
    public InterfaceC13730gj3 h0(InterfaceC14603iB2 interfaceC14603iB2) {
        if (b2()) {
            return AbstractC10533bm0.d(U1(), null, EnumC23959xo1.UNDISPATCHED, new a(interfaceC14603iB2, null), 1, null);
        }
        return null;
    }

    @Override // ir.nasim.AbstractC5581Jy3.a
    public C19101pm7 h1() {
        return this.q;
    }

    @Override // ir.nasim.InterfaceC15868kJ2
    public void u(InterfaceC11379cu3 interfaceC11379cu3) {
        v2(interfaceC11379cu3);
    }

    @Override // ir.nasim.AbstractC5581Jy3.a
    public InterfaceC11379cu3 u0() {
        return (InterfaceC11379cu3) this.r.getValue();
    }

    public void w2(C6542Ny3 c6542Ny3) {
        this.p = c6542Ny3;
    }

    public final void x2(AbstractC5581Jy3 abstractC5581Jy3) {
        if (b2()) {
            this.o.e();
            this.o.l(this);
        }
        this.o = abstractC5581Jy3;
        if (b2()) {
            this.o.j(this);
        }
    }

    public void y2(C19101pm7 c19101pm7) {
        this.q = c19101pm7;
    }
}
