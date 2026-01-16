package ir.nasim;

import android.content.Context;
import android.view.View;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.Iy6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC5350Iy6 extends RecyclerView.C {
    private final InterfaceC9173Yu3 A;
    private InterfaceC20315ro1 B;
    private InterfaceC7857Tm2 D;
    private InterfaceC8807Xk2 G;
    private InterfaceC17445my6 H;
    private Long J;
    private final InterfaceC10258bL6 u;
    private final UA2 v;
    private final InterfaceC14603iB2 w;
    private final InterfaceC20315ro1 x;
    private final View y;
    private final AppCompatCheckBox z;

    /* renamed from: ir.nasim.Iy6$a */
    public static final class a implements InterfaceC8807Xk2 {
        a() {
        }

        @Override // ir.nasim.InterfaceC8807Xk2
        public void c(float f) {
            InterfaceC17445my6 interfaceC17445my6S0 = AbstractC5350Iy6.this.S0();
            if (interfaceC17445my6S0 != null) {
                AbstractC5350Iy6.this.d1(interfaceC17445my6S0, f);
            }
        }

        @Override // ir.nasim.InterfaceC8807Xk2
        public void d(InterfaceC3346Am2 interfaceC3346Am2) {
            AbstractC13042fc3.i(interfaceC3346Am2, "reference");
            InterfaceC17445my6 interfaceC17445my6S0 = AbstractC5350Iy6.this.S0();
            if (interfaceC17445my6S0 != null) {
                AbstractC5350Iy6.this.c1(interfaceC17445my6S0, interfaceC3346Am2);
            }
        }

        @Override // ir.nasim.InterfaceC8807Xk2
        public void e() {
            InterfaceC17445my6 interfaceC17445my6S0 = AbstractC5350Iy6.this.S0();
            if (interfaceC17445my6S0 != null) {
                AbstractC5350Iy6.this.e1(interfaceC17445my6S0);
            }
        }
    }

    /* renamed from: ir.nasim.Iy6$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.Iy6$b$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ boolean c;
            final /* synthetic */ AbstractC5350Iy6 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(AbstractC5350Iy6 abstractC5350Iy6, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = abstractC5350Iy6;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = ((Boolean) obj).booleanValue();
                return aVar;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return n(((Boolean) obj).booleanValue(), (InterfaceC20295rm1) obj2);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                this.d.N0(this.c);
                return C19938rB7.a;
            }

            public final Object n(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(Boolean.valueOf(z), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return AbstractC5350Iy6.this.new b(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10258bL6 interfaceC10258bL6 = AbstractC5350Iy6.this.u;
                a aVar = new a(AbstractC5350Iy6.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC10258bL6, aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC5350Iy6(InterfaceC10258bL6 interfaceC10258bL6, UA2 ua2, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20315ro1 interfaceC20315ro1, View view, View view2, AppCompatCheckBox appCompatCheckBox) {
        super(view);
        AbstractC13042fc3.i(interfaceC10258bL6, "isSelectedMode");
        AbstractC13042fc3.i(ua2, "onItemSelectChange");
        AbstractC13042fc3.i(interfaceC14603iB2, "onLongClickListener");
        AbstractC13042fc3.i(interfaceC20315ro1, "observableCoroutineScope");
        AbstractC13042fc3.i(view, "view");
        AbstractC13042fc3.i(view2, "mediaContainer");
        AbstractC13042fc3.i(appCompatCheckBox, "checkBox");
        this.u = interfaceC10258bL6;
        this.v = ua2;
        this.w = interfaceC14603iB2;
        this.x = interfaceC20315ro1;
        this.y = view2;
        this.z = appCompatCheckBox;
        this.A = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Dy6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return AbstractC5350Iy6.a1(this.a);
            }
        });
        this.B = AbstractC20906so1.a(C12366eV1.c());
        this.G = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W0(AbstractC5350Iy6 abstractC5350Iy6, View view) {
        AbstractC13042fc3.i(abstractC5350Iy6, "this$0");
        abstractC5350Iy6.v.invoke(Integer.valueOf(abstractC5350Iy6.I()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X0(AbstractC5350Iy6 abstractC5350Iy6, View view) {
        AbstractC13042fc3.i(abstractC5350Iy6, "this$0");
        if (((Boolean) abstractC5350Iy6.u.getValue()).booleanValue()) {
            abstractC5350Iy6.v.invoke(Integer.valueOf(abstractC5350Iy6.I()));
            InterfaceC17445my6 interfaceC17445my6 = abstractC5350Iy6.H;
            abstractC5350Iy6.z.setChecked(interfaceC17445my6 != null ? interfaceC17445my6.a() : false);
        } else {
            InterfaceC17445my6 interfaceC17445my62 = abstractC5350Iy6.H;
            if (interfaceC17445my62 != null) {
                abstractC5350Iy6.Q0().invoke(interfaceC17445my62);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Y0(AbstractC5350Iy6 abstractC5350Iy6, View view) {
        AbstractC13042fc3.i(abstractC5350Iy6, "this$0");
        if (((Boolean) abstractC5350Iy6.u.getValue()).booleanValue()) {
            return false;
        }
        abstractC5350Iy6.w.invoke(Integer.valueOf(abstractC5350Iy6.I()), Boolean.valueOf(!((Boolean) abstractC5350Iy6.u.getValue()).booleanValue()));
        abstractC5350Iy6.v.invoke(Integer.valueOf(abstractC5350Iy6.I()));
        abstractC5350Iy6.z.setChecked(true);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z0(AbstractC5350Iy6 abstractC5350Iy6, View view) {
        AbstractC13042fc3.i(abstractC5350Iy6, "this$0");
        abstractC5350Iy6.v.invoke(Integer.valueOf(abstractC5350Iy6.I()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC24602yt4 a1(AbstractC5350Iy6 abstractC5350Iy6) {
        AbstractC13042fc3.i(abstractC5350Iy6, "this$0");
        Context applicationContext = abstractC5350Iy6.a.getContext().getApplicationContext();
        AbstractC13042fc3.h(applicationContext, "getApplicationContext(...)");
        return (InterfaceC24602yt4) C92.a(applicationContext, InterfaceC24602yt4.class);
    }

    public void L0(InterfaceC17445my6 interfaceC17445my6) {
        this.H = interfaceC17445my6;
        if (interfaceC17445my6 != null) {
            this.J = Long.valueOf(interfaceC17445my6.b().getFileId());
            this.D = C14494i07.r(T0().a0(), interfaceC17445my6.b(), this.G, false, false, false, 20, null);
        }
    }

    public void M0(InterfaceC17445my6 interfaceC17445my6, long j) {
        L0(interfaceC17445my6);
    }

    public void N0(boolean z) {
        boolean z2 = false;
        if (!z) {
            this.z.setVisibility(8);
            InterfaceC17445my6 interfaceC17445my6 = this.H;
            if (interfaceC17445my6 != null) {
                interfaceC17445my6.c(false);
                return;
            }
            return;
        }
        this.z.setVisibility(0);
        AppCompatCheckBox appCompatCheckBox = this.z;
        InterfaceC17445my6 interfaceC17445my62 = this.H;
        if (interfaceC17445my62 != null && interfaceC17445my62.a()) {
            z2 = true;
        }
        appCompatCheckBox.setChecked(z2);
    }

    public final InterfaceC20315ro1 O0() {
        return this.B;
    }

    public final InterfaceC8807Xk2 P0() {
        return this.G;
    }

    public abstract UA2 Q0();

    public final InterfaceC17445my6 S0() {
        return this.H;
    }

    protected final InterfaceC24602yt4 T0() {
        return (InterfaceC24602yt4) this.A.getValue();
    }

    protected final InterfaceC20315ro1 U0() {
        return this.x;
    }

    public final void V0() {
        AbstractC10533bm0.d(this.x, null, null, new b(null), 3, null);
        this.z.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Ey6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AbstractC5350Iy6.W0(this.a, view);
            }
        });
        this.y.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Fy6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AbstractC5350Iy6.X0(this.a, view);
            }
        });
        this.y.setOnLongClickListener(new View.OnLongClickListener() { // from class: ir.nasim.Gy6
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return AbstractC5350Iy6.Y0(this.a, view);
            }
        });
        this.z.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Hy6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AbstractC5350Iy6.Z0(this.a, view);
            }
        });
    }

    public abstract void c1(InterfaceC17445my6 interfaceC17445my6, InterfaceC3346Am2 interfaceC3346Am2);

    public abstract void d1(InterfaceC17445my6 interfaceC17445my6, float f);

    public abstract void e1(InterfaceC17445my6 interfaceC17445my6);

    public void f1() {
        InterfaceC7857Tm2 interfaceC7857Tm2 = this.D;
        if (interfaceC7857Tm2 != null) {
            interfaceC7857Tm2.b();
        }
        this.D = null;
        AbstractC20267rj3.j(this.B.getCoroutineContext(), null, 1, null);
    }
}
