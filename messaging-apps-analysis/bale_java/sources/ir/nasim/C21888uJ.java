package ir.nasim;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.v;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.G;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.InterfaceC22053ub1;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000  2\u00020\u0001:\u0001!B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001f\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006&²\u0006\f\u0010#\u001a\u00020\"8\nX\u008a\u0084\u0002²\u0006\u000e\u0010%\u001a\u00020$8\n@\nX\u008a\u008e\u0002"}, d2 = {"Lir/nasim/uJ;", "Lir/nasim/ua0;", "<init>", "()V", "Lir/nasim/rB7;", "ia", "ka", "W9", "(Lir/nasim/ub1;I)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Lir/nasim/wx2;", "h1", "Lir/nasim/wx2;", "ga", "()Lir/nasim/wx2;", "ja", "(Lir/nasim/wx2;)V", "binding", "Lir/nasim/XB4;", "i1", "Lir/nasim/Yu3;", "ha", "()Lir/nasim/XB4;", "viewModel", "j1", "a", "Lir/nasim/hQ1;", "appBarState", "", "showArchiveInfoBottomSheet", "dialogList_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.uJ, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C21888uJ extends NV2 {

    /* renamed from: j1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int k1 = 8;

    /* renamed from: h1, reason: from kotlin metadata */
    public C23458wx2 binding;

    /* renamed from: i1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(XB4.class), new e(this), new f(null, this), new g(this));

    /* renamed from: ir.nasim.uJ$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final C21888uJ a() {
            C21888uJ c21888uJ = new C21888uJ();
            c21888uJ.a8(new Bundle());
            return c21888uJ;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.uJ$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.uJ$b$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C21888uJ d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C21888uJ c21888uJ, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c21888uJ;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                if (((List) this.c).isEmpty()) {
                    this.d.Q7().onBackPressed();
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(List list, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(list, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C21888uJ.this.new b(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10258bL6 interfaceC10258bL6C2 = C21888uJ.this.ha().c2();
                a aVar = new a(C21888uJ.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC10258bL6C2, aVar, this) == objE) {
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

    /* renamed from: ir.nasim.uJ$c */
    public static final class c extends RecyclerView.t {
        c() {
        }
    }

    /* renamed from: ir.nasim.uJ$d */
    static final class d implements InterfaceC14603iB2 {

        /* renamed from: ir.nasim.uJ$d$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ C21888uJ a;

            a(C21888uJ c21888uJ) {
                this.a = c21888uJ;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    this.a.W9(interfaceC22053ub1, 0);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        d() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(58831152, true, new a(C21888uJ.this), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.uJ$e */
    public static final class e extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return this.e.Q7().d1();
        }
    }

    /* renamed from: ir.nasim.uJ$f */
    public static final class f extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ Fragment f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(SA2 sa2, Fragment fragment) {
            super(0);
            this.e = sa2;
            this.f = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC20375ru1 invoke() {
            AbstractC20375ru1 abstractC20375ru1;
            SA2 sa2 = this.e;
            return (sa2 == null || (abstractC20375ru1 = (AbstractC20375ru1) sa2.invoke()) == null) ? this.f.Q7().p3() : abstractC20375ru1;
        }
    }

    /* renamed from: ir.nasim.uJ$g */
    public static final class g extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final G.c invoke() {
            return this.e.Q7().n3();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W9(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1789422137);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(this) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            InterfaceC9664aL6 interfaceC9664aL6C = AbstractC5976Lq2.c(ha().Z(), null, null, null, interfaceC22053ub1J, 0, 7);
            interfaceC22053ub1J.W(266770179);
            Object objB = interfaceC22053ub1J.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = AbstractC13472gH6.d(Boolean.FALSE, null, 2, null);
                interfaceC22053ub1J.s(objB);
            }
            final InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB;
            interfaceC22053ub1J.Q();
            C19818qz6 c19818qz6L = AbstractC9273Zf4.l(true, null, interfaceC22053ub1J, 6, 2);
            InterfaceC14139hQ1 interfaceC14139hQ1X9 = X9(interfaceC9664aL6C);
            InterfaceC12321eQ1 interfaceC12321eQ1Z1 = ha().Z1();
            interfaceC22053ub1J.W(266777638);
            boolean zD = interfaceC22053ub1J.D(this);
            Object objB2 = interfaceC22053ub1J.B();
            if (zD || objB2 == aVar.a()) {
                objB2 = new SA2() { // from class: ir.nasim.qJ
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C21888uJ.ca(this.a);
                    }
                };
                interfaceC22053ub1J.s(objB2);
            }
            SA2 sa2 = (SA2) objB2;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(266779910);
            Object objB3 = interfaceC22053ub1J.B();
            if (objB3 == aVar.a()) {
                objB3 = new SA2() { // from class: ir.nasim.rJ
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C21888uJ.da(interfaceC9102Ym4);
                    }
                };
                interfaceC22053ub1J.s(objB3);
            }
            interfaceC22053ub1J.Q();
            AbstractC12865fJ.j(interfaceC14139hQ1X9, interfaceC12321eQ1Z1, null, sa2, (SA2) objB3, null, interfaceC22053ub1J, 24576, 36);
            boolean zAa = aa(interfaceC9102Ym4);
            interfaceC22053ub1J.W(266786343);
            Object objB4 = interfaceC22053ub1J.B();
            if (objB4 == aVar.a()) {
                objB4 = new SA2() { // from class: ir.nasim.sJ
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C21888uJ.Y9(interfaceC9102Ym4);
                    }
                };
                interfaceC22053ub1J.s(objB4);
            }
            interfaceC22053ub1J.Q();
            AbstractC17638nJ.b(zAa, c19818qz6L, (SA2) objB4, interfaceC22053ub1J, 384);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.tJ
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return C21888uJ.Z9(this.a, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final InterfaceC14139hQ1 X9(InterfaceC9664aL6 interfaceC9664aL6) {
        return (InterfaceC14139hQ1) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Y9(InterfaceC9102Ym4 interfaceC9102Ym4) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$showArchiveInfoBottomSheet$delegate");
        ba(interfaceC9102Ym4, false);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Z9(C21888uJ c21888uJ, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(c21888uJ, "$tmp4_rcvr");
        c21888uJ.W9(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    private static final boolean aa(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
    }

    private static final void ba(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
        interfaceC9102Ym4.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ca(C21888uJ c21888uJ) {
        AbstractC13042fc3.i(c21888uJ, "this$0");
        c21888uJ.Q7().onBackPressed();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 da(InterfaceC9102Ym4 interfaceC9102Ym4) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$showArchiveInfoBottomSheet$delegate");
        ba(interfaceC9102Ym4, true);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final XB4 ha() {
        return (XB4) this.viewModel.getValue();
    }

    private final void ia() {
        InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        AbstractC10533bm0.d(AbstractC19224pz3.a(interfaceC18633oz3P6), null, null, new b(null), 3, null);
    }

    private final void ka() {
        ComposeView composeView = ga().c;
        composeView.setViewCompositionStrategy(v.d.b);
        composeView.setContent(AbstractC19242q11.c(145422837, true, new d()));
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        ja(C23458wx2.c(Q5()));
        ka();
        ia();
        F5().s().q(AbstractC10792cC5.archived_dialog_fragment, C14166hT1.B1.a(11, new c())).h();
        LinearLayout root = ga().getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    public final C23458wx2 ga() {
        C23458wx2 c23458wx2 = this.binding;
        if (c23458wx2 != null) {
            return c23458wx2;
        }
        AbstractC13042fc3.y("binding");
        return null;
    }

    public final void ja(C23458wx2 c23458wx2) {
        AbstractC13042fc3.i(c23458wx2, "<set-?>");
        this.binding = c23458wx2;
    }
}
