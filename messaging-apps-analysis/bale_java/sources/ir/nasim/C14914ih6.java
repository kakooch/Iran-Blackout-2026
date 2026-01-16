package ir.nasim;

import android.gov.nist.core.Separators;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.C13122fh6;
import ir.nasim.C22698vg6;

/* renamed from: ir.nasim.ih6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C14914ih6 extends AbstractC16640ld0 {
    public static final a y = new a(null);
    public static final int z = 8;
    private final C7556Sf3 v;
    private final C13122fh6.b w;
    private InterfaceC20315ro1 x;

    /* renamed from: ir.nasim.ih6$a */
    public static final class a {
        private a() {
        }

        private final void b(C7556Sf3 c7556Sf3) {
            c7556Sf3.e.setTypeface(C6011Lu2.k());
            c7556Sf3.c.setTypeface(C6011Lu2.k());
            c7556Sf3.b.B(22.0f, true);
        }

        public final C14914ih6 a(ViewGroup viewGroup, C13122fh6.b bVar) {
            AbstractC13042fc3.i(viewGroup, "parent");
            C7556Sf3 c7556Sf3C = C7556Sf3.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            AbstractC13042fc3.h(c7556Sf3C, "inflate(...)");
            b(c7556Sf3C);
            return new C14914ih6(c7556Sf3C, bVar, null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.ih6$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ C22698vg6.b d;
        final /* synthetic */ C14914ih6 e;

        /* renamed from: ir.nasim.ih6$b$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C14914ih6 c;
            final /* synthetic */ C14733iO2 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C14914ih6 c14914ih6, C14733iO2 c14733iO2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c14914ih6;
                this.d = c14733iO2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                this.c.J0(this.d);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(C22698vg6.b bVar, C14914ih6 c14914ih6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = bVar;
            this.e = c14914ih6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = new b(this.d, this.e, interfaceC20295rm1);
            bVar.c = obj;
            return bVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                C14733iO2 c14733iO2V = AbstractC5969Lp4.e().H().V(this.d.d());
                if (c14733iO2V != null && AbstractC20906so1.g(interfaceC20315ro1)) {
                    WM3 wm3C = C12366eV1.c();
                    a aVar = new a(this.e, c14733iO2V, null);
                    this.b = 1;
                    if (AbstractC9323Zl0.g(wm3C, aVar, this) == objE) {
                        return objE;
                    }
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

    public /* synthetic */ C14914ih6(C7556Sf3 c7556Sf3, C13122fh6.b bVar, ED1 ed1) {
        this(c7556Sf3, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(C14914ih6 c14914ih6, C22698vg6.b bVar, View view) {
        AbstractC13042fc3.i(c14914ih6, "this$0");
        AbstractC13042fc3.i(bVar, "$peer");
        C13122fh6.b bVar2 = c14914ih6.w;
        if (bVar2 != null) {
            bVar2.z1(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J0(C14733iO2 c14733iO2) {
        this.v.b.q(c14733iO2);
    }

    private final void L0(C22698vg6.b bVar) {
        try {
            InterfaceC20315ro1 interfaceC20315ro1 = this.x;
            if (interfaceC20315ro1 != null) {
                AbstractC10533bm0.d(interfaceC20315ro1, null, null, new b(bVar, this, null), 3, null);
            }
        } catch (Exception e) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e);
        }
    }

    public final void F0(final C22698vg6.b bVar) {
        Drawable drawableC;
        AbstractC13042fc3.i(bVar, "peer");
        this.x = AbstractC20906so1.a(C12366eV1.b());
        this.v.e.setText(bVar.f());
        if (!AbstractC20762sZ6.n0(bVar.a())) {
            this.v.c.setText(bVar.a());
        } else {
            this.v.c.setText(bVar.e() + Separators.AT);
        }
        String strB = bVar.b();
        if (strB == null || AbstractC20762sZ6.n0(strB) || (drawableC = bVar.c(C0())) == null) {
            this.v.f.setVisibility(8);
        } else {
            this.v.f.setVisibility(0);
            this.v.f.setImageDrawable(drawableC);
        }
        L0(bVar);
        this.v.d.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.hh6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C14914ih6.H0(this.a, bVar, view);
            }
        });
    }

    public final void M0() {
        this.v.b.D();
        InterfaceC20315ro1 interfaceC20315ro1 = this.x;
        if (interfaceC20315ro1 != null) {
            AbstractC20906so1.d(interfaceC20315ro1, null, 1, null);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private C14914ih6(C7556Sf3 c7556Sf3, C13122fh6.b bVar) {
        ConstraintLayout constraintLayout = c7556Sf3.d;
        AbstractC13042fc3.h(constraintLayout, "root");
        super(constraintLayout);
        this.v = c7556Sf3;
        this.w = bVar;
    }
}
