package ir.nasim;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.v;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.G;
import androidx.lifecycle.j;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AS1;
import ir.nasim.AbstractC4820Gr7;
import ir.nasim.C21753u45;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.designsystem.modal.dialog.AlertDialog;
import ir.nasim.features.root.AbstractC13089g;
import ir.nasim.features.root.EmptyStateOnboardingItemAction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xbill.DNS.Type;

/* loaded from: classes5.dex */
public final class AS1 extends AbstractC23194wW2 {
    public static final a O1 = new a(null);
    public static final int P1 = 8;
    private final OP1 C1;
    private final InterfaceC9173Yu3 D1;
    private final InterfaceC9173Yu3 E1;
    private ComposeView F1;
    private C15871kJ5 G1;
    public InterfaceC7565Sg3 H1;
    public InterfaceC8288Vi1 I1;
    public DK4 J1;
    public C8054Ui1 K1;
    private InterfaceC9336Zm4 L1;
    private InterfaceC9336Zm4 M1;
    private final InterfaceC9173Yu3 N1;

    public static final class a {
        private a() {
        }

        public final AS1 a(OP1 op1, GN1 gn1, RecyclerView.t tVar) {
            AbstractC13042fc3.i(op1, "dialogType");
            AS1 as1 = new AS1(gn1, tVar, op1);
            Bundle bundle = new Bundle();
            bundle.putString("dialogFragmentType", op1.name());
            as1.a8(bundle);
            return as1;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public static final class b implements ZJ4 {
        final /* synthetic */ C17067mL1 a;

        b(C17067mL1 c17067mL1) {
            this.a = c17067mL1;
        }

        @Override // ir.nasim.ZJ4
        public void a() {
            C18987pb3.x1(C18987pb3.a, this.a.R(), null, null, false, null, "recommendation_group_tab", false, null, null, false, null, 1984, null);
        }
    }

    public static final class c implements InterfaceC22483vJ4 {
        c() {
        }

        @Override // ir.nasim.InterfaceC22483vJ4
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void e(C17067mL1 c17067mL1) {
            AbstractC13042fc3.i(c17067mL1, "item");
            AS1.this.Aa(c17067mL1);
            if (AS1.this.C1 == OP1.GROUP) {
                AS1.this.Za().p2("Recommended_group_click", AbstractC20051rO3.n(AbstractC4616Fw7.a("action_type", 2), AbstractC4616Fw7.a("peer_id", Integer.valueOf(c17067mL1.R().getPeerId())), AbstractC4616Fw7.a("peer_type", "GROUP")));
            }
        }

        @Override // ir.nasim.InterfaceC22483vJ4
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean v(C17067mL1 c17067mL1) {
            AbstractC13042fc3.i(c17067mL1, "item");
            return AS1.this.Ba(c17067mL1);
        }
    }

    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ AS1 c;

            /* renamed from: ir.nasim.AS1$d$a$a, reason: collision with other inner class name */
            static final class C0261a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                /* synthetic */ Object c;
                final /* synthetic */ AS1 d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0261a(AS1 as1, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = as1;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    C0261a c0261a = new C0261a(this.d, interfaceC20295rm1);
                    c0261a.c = obj;
                    return c0261a;
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    if (((EnumC11273cj7) this.c) == EnumC11273cj7.e) {
                        RecyclerView recyclerViewCa = this.d.ca();
                        RecyclerView.p layoutManager = recyclerViewCa != null ? recyclerViewCa.getLayoutManager() : null;
                        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
                        if (linearLayoutManager != null && linearLayoutManager.e2() == linearLayoutManager.Z() - 1) {
                            this.d.Za().v2();
                        }
                    }
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(EnumC11273cj7 enumC11273cj7, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C0261a) create(enumC11273cj7, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(AS1 as1, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = as1;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC10258bL6 interfaceC10258bL6W1 = this.c.Za().w1();
                    C0261a c0261a = new C0261a(this.c, null);
                    this.b = 1;
                    if (AbstractC6459Nq2.l(interfaceC10258bL6W1, c0261a, this) == objE) {
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
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return AS1.this.new d(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC18633oz3 interfaceC18633oz3P6 = AS1.this.p6();
                AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
                j.b bVar = j.b.STARTED;
                a aVar = new a(AS1.this, null);
                this.b = 1;
                if (androidx.lifecycle.w.b(interfaceC18633oz3P6, bVar, aVar, this) == objE) {
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
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ AS1 c;

            /* renamed from: ir.nasim.AS1$e$a$a, reason: collision with other inner class name */
            static final class C0262a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                /* synthetic */ Object c;
                final /* synthetic */ AS1 d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0262a(AS1 as1, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = as1;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    C0262a c0262a = new C0262a(this.d, interfaceC20295rm1);
                    c0262a.c = obj;
                    return c0262a;
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    List list = (List) this.c;
                    C15871kJ5 c15871kJ5 = this.d.G1;
                    if (c15871kJ5 != null) {
                        c15871kJ5.z(AbstractC15401jX0.f1(list, 5));
                    }
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(List list, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C0262a) create(list, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(AS1 as1, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = as1;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC9336Zm4 interfaceC9336Zm4K1 = this.c.Za().K1();
                    C0262a c0262a = new C0262a(this.c, null);
                    this.b = 1;
                    if (AbstractC6459Nq2.l(interfaceC9336Zm4K1, c0262a, this) == objE) {
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
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            e eVar = AS1.this.new e(interfaceC20295rm1);
            eVar.c = obj;
            return eVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            AbstractC10533bm0.d((InterfaceC20315ro1) this.c, null, null, new a(AS1.this, null), 3, null);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ AS1 c;

            /* renamed from: ir.nasim.AS1$f$a$a, reason: collision with other inner class name */
            static final class C0263a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                /* synthetic */ Object c;
                final /* synthetic */ AS1 d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0263a(AS1 as1, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = as1;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    C0263a c0263a = new C0263a(this.d, interfaceC20295rm1);
                    c0263a.c = obj;
                    return c0263a;
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    List list = (List) this.c;
                    C15871kJ5 c15871kJ5 = this.d.G1;
                    if (c15871kJ5 != null) {
                        c15871kJ5.z(AbstractC15401jX0.f1(list, 5));
                    }
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(List list, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C0263a) create(list, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(AS1 as1, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = as1;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC9336Zm4 interfaceC9336Zm4L1 = this.c.Za().L1();
                    C0263a c0263a = new C0263a(this.c, null);
                    this.b = 1;
                    if (AbstractC6459Nq2.l(interfaceC9336Zm4L1, c0263a, this) == objE) {
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
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            f fVar = AS1.this.new f(interfaceC20295rm1);
            fVar.c = obj;
            return fVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            AbstractC10533bm0.d((InterfaceC20315ro1) this.c, null, null, new a(AS1.this, null), 3, null);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class g implements QG4, InterfaceC22409vB2 {
        private final /* synthetic */ UA2 a;

        g(UA2 ua2) {
            AbstractC13042fc3.i(ua2, "function");
            this.a = ua2;
        }

        @Override // ir.nasim.QG4
        public final /* synthetic */ void a(Object obj) {
            this.a.invoke(obj);
        }

        @Override // ir.nasim.InterfaceC22409vB2
        public final InterfaceC18751pB2 b() {
            return this.a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof QG4) && (obj instanceof InterfaceC22409vB2)) {
                return AbstractC13042fc3.d(b(), ((InterfaceC22409vB2) obj).b());
            }
            return false;
        }

        public final int hashCode() {
            return b().hashCode();
        }
    }

    static final class h implements InterfaceC16978mB2 {
        h() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(C11458d25 c11458d25, EmptyStateOnboardingItemAction emptyStateOnboardingItemAction) {
            AbstractC13042fc3.i(c11458d25, "peer");
            AbstractC13042fc3.i(emptyStateOnboardingItemAction, "emptyStateOnboardingItemAction");
            C18987pb3.x1(C18987pb3.a, c11458d25, null, null, false, null, null, false, null, null, false, emptyStateOnboardingItemAction, 1022, null);
            return C19938rB7.a;
        }

        public final void b(boolean z, boolean z2, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 129) == 128 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            InterfaceC15796kB2 interfaceC15796kB2E = AS1.this.cb().e();
            interfaceC22053ub1.W(-1989646623);
            Object objB = interfaceC22053ub1.B();
            if (objB == InterfaceC22053ub1.a.a()) {
                objB = new InterfaceC14603iB2() { // from class: ir.nasim.BS1
                    @Override // ir.nasim.InterfaceC14603iB2
                    public final Object invoke(Object obj, Object obj2) {
                        return AS1.h.c((C11458d25) obj, (EmptyStateOnboardingItemAction) obj2);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            interfaceC15796kB2E.q((InterfaceC14603iB2) objB, interfaceC22053ub1, 6);
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            b(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
            return C19938rB7.a;
        }
    }

    static final class i implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC10258bL6 a;
        final /* synthetic */ AS1 b;
        final /* synthetic */ InterfaceC16978mB2 c;

        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ InterfaceC16978mB2 a;
            final /* synthetic */ InterfaceC9664aL6 b;
            final /* synthetic */ InterfaceC9664aL6 c;

            a(InterfaceC16978mB2 interfaceC16978mB2, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9664aL6 interfaceC9664aL62) {
                this.a = interfaceC16978mB2;
                this.b = interfaceC9664aL6;
                this.c = interfaceC9664aL62;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    this.a.e(Boolean.valueOf(i.f(this.b)), Boolean.valueOf(i.d(this.c)), interfaceC22053ub1, 0);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        i(InterfaceC10258bL6 interfaceC10258bL6, AS1 as1, InterfaceC16978mB2 interfaceC16978mB2) {
            this.a = interfaceC10258bL6;
            this.b = as1;
            this.c = interfaceC16978mB2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean d(InterfaceC9664aL6 interfaceC9664aL6) {
            return ((Boolean) interfaceC9664aL6.getValue()).booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean f(InterfaceC9664aL6 interfaceC9664aL6) {
            return ((Boolean) interfaceC9664aL6.getValue()).booleanValue();
        }

        public final void c(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            InterfaceC9664aL6 interfaceC9664aL6B = AbstractC10222bH6.b(this.a, null, interfaceC22053ub1, 0, 1);
            InterfaceC9664aL6 interfaceC9664aL6B2 = AbstractC10222bH6.b(this.b.M1, null, interfaceC22053ub1, 0, 1);
            if (d(interfaceC9664aL6B) || f(interfaceC9664aL6B2)) {
                M10.f(false, AbstractC19242q11.e(-538148819, true, new a(this.c, interfaceC9664aL6B2, interfaceC9664aL6B), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            c((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class j extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        /* synthetic */ int c;
        /* synthetic */ boolean d;
        final /* synthetic */ InterfaceC14603iB2 e;
        final /* synthetic */ ComposeView f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(InterfaceC14603iB2 interfaceC14603iB2, ComposeView composeView, InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
            this.e = interfaceC14603iB2;
            this.f = composeView;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            boolean zBooleanValue = ((Boolean) this.e.invoke(AbstractC6392Nk0.d(this.c), AbstractC6392Nk0.a(this.d))).booleanValue();
            this.f.setVisibility(zBooleanValue ? 0 : 8);
            return AbstractC6392Nk0.a(zBooleanValue);
        }

        public final Object n(int i, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            j jVar = new j(this.e, this.f, interfaceC20295rm1);
            jVar.c = i;
            jVar.d = z;
            return jVar.invokeSuspend(C19938rB7.a);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return n(((Number) obj).intValue(), ((Boolean) obj2).booleanValue(), (InterfaceC20295rm1) obj3);
        }
    }

    static final class k extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ C10298bQ1 d;
        final /* synthetic */ AS1 e;

        public static final class a extends RecyclerView.j {
            final /* synthetic */ InterfaceC16204ks5 a;
            final /* synthetic */ C10298bQ1 b;
            final /* synthetic */ AS1 c;

            a(InterfaceC16204ks5 interfaceC16204ks5, C10298bQ1 c10298bQ1, AS1 as1) {
                this.a = interfaceC16204ks5;
                this.b = c10298bQ1;
                this.c = as1;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.j
            public void b(int i, int i2) {
                this.a.h(Integer.valueOf(this.b.getItemCount()));
            }

            @Override // androidx.recyclerview.widget.RecyclerView.j
            public void c(int i, int i2, Object obj) {
                this.a.h(Integer.valueOf(this.b.getItemCount()));
                if (this.c.C1 == OP1.ALL) {
                    this.c.Za().t2(this.b.getItemCount());
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.j
            public void d(int i, int i2) {
                this.a.h(Integer.valueOf(this.b.getItemCount()));
                if (this.c.C1 == OP1.ALL) {
                    this.c.Za().t2(this.b.getItemCount());
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.j
            public void e(int i, int i2, int i3) {
                this.a.h(Integer.valueOf(this.b.getItemCount()));
                if (this.c.C1 == OP1.ALL) {
                    this.c.Za().t2(this.b.getItemCount());
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.j
            public void f(int i, int i2) {
                this.a.h(Integer.valueOf(this.b.getItemCount()));
                if (this.c.C1 == OP1.ALL) {
                    this.c.Za().t2(this.b.getItemCount());
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.j
            public void g() {
                this.a.h(Integer.valueOf(this.b.getItemCount()));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(C10298bQ1 c10298bQ1, AS1 as1, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c10298bQ1;
            this.e = as1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 y(C10298bQ1 c10298bQ1, a aVar) {
            c10298bQ1.unregisterAdapterDataObserver(aVar);
            return C19938rB7.a;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            k kVar = new k(this.d, this.e, interfaceC20295rm1);
            kVar.c = obj;
            return kVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC16204ks5 interfaceC16204ks5 = (InterfaceC16204ks5) this.c;
                if (this.d.getItemCount() > 0) {
                    interfaceC16204ks5.h(AbstractC6392Nk0.d(this.d.getItemCount()));
                    if (this.e.C1 == OP1.ALL) {
                        this.e.Za().t2(this.d.getItemCount());
                    }
                }
                final a aVar = new a(interfaceC16204ks5, this.d, this.e);
                this.d.registerAdapterDataObserver(aVar);
                final C10298bQ1 c10298bQ1 = this.d;
                SA2 sa2 = new SA2() { // from class: ir.nasim.CS1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AS1.k.y(c10298bQ1, aVar);
                    }
                };
                this.b = 1;
                if (AbstractC13822gs5.a(interfaceC16204ks5, sa2, this) == objE) {
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
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((k) create(interfaceC16204ks5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class l implements InterfaceC16978mB2 {

        /* synthetic */ class a extends EB2 implements SA2 {
            a(Object obj) {
                super(0, obj, AS1.class, "createPermissionDialog", "createPermissionDialog()V", 0);
            }

            @Override // ir.nasim.SA2
            public /* bridge */ /* synthetic */ Object invoke() {
                y();
                return C19938rB7.a;
            }

            public final void y() {
                ((AS1) this.receiver).Wa();
            }
        }

        l() {
        }

        private static final boolean d(InterfaceC9664aL6 interfaceC9664aL6) {
            return ((Boolean) interfaceC9664aL6.getValue()).booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(AS1 as1) {
            AbstractC13042fc3.i(as1, "this$0");
            C22042ua0.A9(as1, as1.Ya().b(EnumC6843Pf2.b), false, null, 6, null);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 h(AS1 as1, int i) {
            AbstractC13042fc3.i(as1, "this$0");
            C22042ua0.A9(as1, as1.ab().h(i, new ArrayList()), false, null, 6, null);
            return C19938rB7.a;
        }

        public final void c(boolean z, boolean z2, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            int i2;
            if ((i & 6) == 0) {
                i2 = i | (interfaceC22053ub1.a(z) ? 4 : 2);
            } else {
                i2 = i;
            }
            if ((i2 & 131) == 130 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            InterfaceC9664aL6 interfaceC9664aL6B = AbstractC10222bH6.b(AS1.this.db(), null, interfaceC22053ub1, 0, 1);
            androidx.compose.ui.e eVarM = z ? androidx.compose.foundation.layout.q.m(androidx.compose.ui.e.a, 0.0f, C17784nZ1.q(Type.AMTRELAY), 0.0f, 0.0f, 13, null) : androidx.compose.foundation.layout.q.m(androidx.compose.ui.e.a, 0.0f, C17784nZ1.q(115), 0.0f, 0.0f, 13, null);
            long jA = WX0.a(TA5.background_2, interfaceC22053ub1, 0);
            NI4 ni4Bb = AS1.this.bb();
            boolean z3 = !d(interfaceC9664aL6B);
            AS1 as1 = AS1.this;
            interfaceC22053ub1.W(1634995380);
            boolean zD = interfaceC22053ub1.D(as1);
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new a(as1);
                interfaceC22053ub1.s(objB);
            }
            InterfaceC16733lm3 interfaceC16733lm3 = (InterfaceC16733lm3) objB;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(1634970562);
            boolean zD2 = interfaceC22053ub1.D(AS1.this);
            final AS1 as12 = AS1.this;
            Object objB2 = interfaceC22053ub1.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.DS1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AS1.l.f(as12);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            SA2 sa2 = (SA2) objB2;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(1634979524);
            boolean zD3 = interfaceC22053ub1.D(AS1.this);
            final AS1 as13 = AS1.this;
            Object objB3 = interfaceC22053ub1.B();
            if (zD3 || objB3 == InterfaceC22053ub1.a.a()) {
                objB3 = new UA2() { // from class: ir.nasim.ES1
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AS1.l.h(as13, ((Integer) obj).intValue());
                    }
                };
                interfaceC22053ub1.s(objB3);
            }
            interfaceC22053ub1.Q();
            LI4.d(eVarM, sa2, (UA2) objB3, ni4Bb, jA, false, z3, (SA2) interfaceC16733lm3, interfaceC22053ub1, 0, 32);
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            c(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
            return C19938rB7.a;
        }
    }

    public static final class m extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            C14819iX7 c14819iX7D1 = this.e.Q7().d1();
            AbstractC13042fc3.h(c14819iX7D1, "requireActivity().viewModelStore");
            return c14819iX7D1;
        }
    }

    public static final class n extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ Fragment f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(SA2 sa2, Fragment fragment) {
            super(0);
            this.e = sa2;
            this.f = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC20375ru1 invoke() {
            AbstractC20375ru1 abstractC20375ru1;
            SA2 sa2 = this.e;
            if (sa2 != null && (abstractC20375ru1 = (AbstractC20375ru1) sa2.invoke()) != null) {
                return abstractC20375ru1;
            }
            AbstractC20375ru1 abstractC20375ru1P3 = this.f.Q7().p3();
            AbstractC13042fc3.h(abstractC20375ru1P3, "requireActivity().defaultViewModelCreationExtras");
            return abstractC20375ru1P3;
        }
    }

    public static final class o extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final G.c invoke() {
            G.c cVarN3 = this.e.Q7().n3();
            AbstractC13042fc3.h(cVarN3, "requireActivity().defaultViewModelProviderFactory");
            return cVarN3;
        }
    }

    public static final class p extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            C14819iX7 c14819iX7D1 = this.e.Q7().d1();
            AbstractC13042fc3.h(c14819iX7D1, "requireActivity().viewModelStore");
            return c14819iX7D1;
        }
    }

    public static final class q extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ Fragment f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(SA2 sa2, Fragment fragment) {
            super(0);
            this.e = sa2;
            this.f = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC20375ru1 invoke() {
            AbstractC20375ru1 abstractC20375ru1;
            SA2 sa2 = this.e;
            if (sa2 != null && (abstractC20375ru1 = (AbstractC20375ru1) sa2.invoke()) != null) {
                return abstractC20375ru1;
            }
            AbstractC20375ru1 abstractC20375ru1P3 = this.f.Q7().p3();
            AbstractC13042fc3.h(abstractC20375ru1P3, "requireActivity().defaultViewModelCreationExtras");
            return abstractC20375ru1P3;
        }
    }

    public static final class r extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final G.c invoke() {
            G.c cVarN3 = this.e.Q7().n3();
            AbstractC13042fc3.h(cVarN3, "requireActivity().defaultViewModelProviderFactory");
            return cVarN3;
        }
    }

    public AS1(GN1 gn1, RecyclerView.t tVar, OP1 op1) {
        AbstractC13042fc3.i(op1, "dialogType");
        this.C1 = op1;
        this.D1 = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(NI4.class), new m(this), new n(null, this), new o(this));
        this.E1 = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C20085rS1.class), new p(this), new q(null, this), new r(this));
        Ca(gn1);
        Da(tVar);
        this.L1 = AbstractC12281eL6.a(Boolean.valueOf(C5735Kp4.w().i().O().a().b() == EnumC12820fE.LOADED || C5735Kp4.w().i().O().a().b() == EnumC12820fE.EMPTY));
        this.M1 = AbstractC12281eL6.a(Boolean.valueOf(C5735Kp4.w().i().O().a().b() == EnumC12820fE.EMPTY));
        this.N1 = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.xS1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return AS1.jb(this.a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Wa() {
        C21753u45.a.a1(this, 301, C21753u45.c.d, (56 & 8) != 0 ? null : null, (56 & 16) != 0 ? new SA2() { // from class: ir.nasim.e45
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C21753u45.c1();
            }
        } : null, (56 & 32) != 0 ? new SA2() { // from class: ir.nasim.f45
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C21753u45.d1();
            }
        } : null, C21753u45.d.h, C21753u45.d.i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C20085rS1 Za() {
        return (C20085rS1) this.E1.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NI4 bb() {
        return (NI4) this.D1.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC9336Zm4 db() {
        return (InterfaceC9336Zm4) this.N1.getValue();
    }

    private final void eb(C17067mL1 c17067mL1) {
        C14733iO2 c14733iO2;
        List list = (List) Za().M1().f();
        List list2 = list;
        if (list2 != null && !list2.isEmpty() && c17067mL1.V() == null) {
            if (list.contains(c17067mL1)) {
                C20085rS1.D2(Za(), false, -1, 1, null);
                Integer num = (Integer) Za().N1().f();
                if (num != null && num.intValue() == 0) {
                    Za().E2(AbstractC4820Gr7.c.a);
                }
                Za().p1(c17067mL1);
            } else {
                Za().i2(c17067mL1);
                C20085rS1.D2(Za(), false, 1, 1, null);
            }
            pb();
            return;
        }
        C11458d25 c11458d25R = c17067mL1.R();
        AbstractC13089g abstractC13089gK = C5735Kp4.w().k();
        if (abstractC13089gK == null) {
            C19406qI3.j("DialogsDefaultFragment", "rootFragment is null in handleItemClick; skipping.", new Object[0]);
            return;
        }
        if (abstractC13089gK.getDialogsMode() != AbstractC13089g.b.a && c11458d25R.s() == W25.b && ((c14733iO2 = (C14733iO2) AbstractC5969Lp4.b().n(c11458d25R.getPeerId())) == null || ((c14733iO2.f() != null && !((Boolean) c14733iO2.f().b()).booleanValue()) || !GM2.b(c14733iO2, false, 2, null)))) {
            Toast.makeText(A5(), AbstractC12217eE5.error_not_allowed_share, 0).show();
            return;
        }
        if (abstractC13089gK.getDialogsMode() != AbstractC13089g.b.c) {
            GN1 dialogItemClickCallback = getDialogItemClickCallback();
            if (dialogItemClickCallback != null) {
                dialogItemClickCallback.a();
            }
            C18987pb3.x1(C18987pb3.a, c17067mL1.R(), null, null, false, null, "recommendation_group_tab", false, null, null, true, null, 1472, null);
            return;
        }
        String strJ = c17067mL1.J();
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        AlertDialog alertDialogD = C18045nz6.d(fragmentActivityQ7, c17067mL1.R(), strJ, new b(c17067mL1));
        q9(alertDialogD);
        alertDialogD.setCanceledOnTouchOutside(true);
    }

    private final boolean fb() {
        return AbstractC4043Dl1.a(S7(), "android.permission.READ_CONTACTS") == 0;
    }

    private final void gb() {
        Za().M1().j(p6(), new g(new UA2() { // from class: ir.nasim.zS1
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return AS1.hb(this.a, (List) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 hb(AS1 as1, List list) {
        AbstractC13042fc3.i(as1, "this$0");
        AbstractC13042fc3.i(list, DialogEntity.TABLE_NAME);
        if (list.isEmpty()) {
            C10298bQ1 dialogsAdapter = as1.getDialogsAdapter();
            if (dialogsAdapter != null) {
                dialogsAdapter.J();
            }
        } else {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(((C17067mL1) it.next()).R().u()));
            }
            C10298bQ1 dialogsAdapter2 = as1.getDialogsAdapter();
            if (dialogsAdapter2 != null) {
                dialogsAdapter2.P(arrayList);
            }
        }
        C10298bQ1 dialogsAdapter3 = as1.getDialogsAdapter();
        if (dialogsAdapter3 != null) {
            dialogsAdapter3.notifyDataSetChanged();
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ib(AS1 as1, String str, Map map) {
        AbstractC13042fc3.i(as1, "this$0");
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(map, "param");
        as1.Za().p2(str, map);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC9336Zm4 jb(AS1 as1) {
        AbstractC13042fc3.i(as1, "this$0");
        return AbstractC12281eL6.a(Boolean.valueOf(as1.fb()));
    }

    private final void kb(ComposeView composeView) {
        mb(composeView, new InterfaceC14603iB2() { // from class: ir.nasim.vS1
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(AS1.lb(this.a, ((Integer) obj).intValue(), ((Boolean) obj2).booleanValue()));
            }
        }, AbstractC19242q11.c(2013809183, true, new h()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean lb(AS1 as1, int i2, boolean z) {
        OP1 op1;
        AbstractC13042fc3.i(as1, "this$0");
        return i2 < 16 && z && ((op1 = as1.C1) == OP1.BOT || op1 == OP1.ALL);
    }

    private final void mb(ComposeView composeView, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC16978mB2 interfaceC16978mB2) {
        C10298bQ1 dialogsAdapter = getDialogsAdapter();
        if (dialogsAdapter == null) {
            return;
        }
        InterfaceC10258bL6 interfaceC10258bL6O0 = AbstractC6459Nq2.o0(AbstractC6459Nq2.S(AbstractC6459Nq2.v(AbstractC6459Nq2.f(new k(dialogsAdapter, this, null))), this.L1, new j(interfaceC14603iB2, composeView, null)), AbstractC19224pz3.a(this), InterfaceC16863lz6.a.c(), Boolean.FALSE);
        composeView.setVisibility(0);
        composeView.setContent(AbstractC19242q11.c(1855132909, true, new i(interfaceC10258bL6O0, this, interfaceC16978mB2)));
        composeView.setViewCompositionStrategy(v.b.b);
        Q9(composeView);
    }

    private final void nb(ComposeView composeView) {
        mb(composeView, new InterfaceC14603iB2() { // from class: ir.nasim.wS1
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(AS1.ob(this.a, ((Integer) obj).intValue(), ((Boolean) obj2).booleanValue()));
            }
        }, AbstractC19242q11.c(-689492293, true, new l()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ob(AS1 as1, int i2, boolean z) {
        OP1 op1;
        AbstractC13042fc3.i(as1, "this$0");
        return i2 < 3 && z && (op1 = as1.C1) != OP1.CHANNEL && op1 != OP1.GROUP;
    }

    private final void pb() {
        List list;
        EnumC7306Rd5 enumC7306Rd5;
        if ((Za().Q1().f() instanceof AbstractC4820Gr7.c) || (Za().Q1().f() instanceof AbstractC4820Gr7.b) || (list = (List) Za().M1().f()) == null) {
            return;
        }
        EnumC18517on4 enumC18517on4 = AbstractC5969Lp4.d().A0(((C17067mL1) list.get(0)).R()) ? EnumC18517on4.b : EnumC18517on4.a;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                enumC7306Rd5 = EnumC7306Rd5.a;
                break;
            }
            if (!((C17067mL1) it.next()).e0()) {
                Iterator it2 = list.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        enumC7306Rd5 = EnumC7306Rd5.b;
                        break;
                    } else if (((C17067mL1) it2.next()).e0()) {
                        enumC7306Rd5 = EnumC7306Rd5.c;
                        break;
                    }
                }
            }
        }
        C20085rS1 c20085rS1Za = Za();
        c20085rS1Za.y2(enumC18517on4);
        c20085rS1Za.A2(enumC7306Rd5);
    }

    @Override // ir.nasim.J90
    protected void Aa(C17067mL1 c17067mL1) {
        AbstractC13042fc3.i(c17067mL1, "item");
        eb(c17067mL1);
    }

    @Override // ir.nasim.J90
    protected boolean Ba(C17067mL1 c17067mL1) {
        AbstractC13042fc3.i(c17067mL1, "dialog");
        if (c17067mL1.V() != null) {
            return false;
        }
        List list = (List) Za().M1().f();
        if (list != null && list.isEmpty()) {
            C20085rS1 c20085rS1Za = Za();
            c20085rS1Za.i2(c17067mL1);
            c20085rS1Za.E2(new AbstractC4820Gr7.a(EnumC11273cj7.b));
            C20085rS1.D2(c20085rS1Za, false, 1, 1, null);
            pb();
        }
        return true;
    }

    @Override // ir.nasim.J90, ir.nasim.R90
    public void J3(EnumC12820fE enumC12820fE) {
        Object value;
        Object value2;
        AbstractC13042fc3.i(enumC12820fE, "state");
        super.J3(enumC12820fE);
        boolean z = enumC12820fE == EnumC12820fE.LOADED || enumC12820fE == EnumC12820fE.EMPTY;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.L1;
        do {
            value = interfaceC9336Zm4.getValue();
            ((Boolean) value).booleanValue();
        } while (!interfaceC9336Zm4.f(value, Boolean.valueOf(z)));
        InterfaceC9336Zm4 interfaceC9336Zm42 = this.M1;
        do {
            value2 = interfaceC9336Zm42.getValue();
            ((Boolean) value2).booleanValue();
        } while (!interfaceC9336Zm42.f(value2, Boolean.valueOf(enumC12820fE == EnumC12820fE.EMPTY)));
    }

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle bundle) {
        super.M6(bundle);
        OP1 op1 = this.C1;
        if (op1 == OP1.CHANNEL || op1 == OP1.GROUP) {
            Context contextS7 = S7();
            AbstractC13042fc3.h(contextS7, "requireContext(...)");
            C15871kJ5 c15871kJ5 = new C15871kJ5(contextS7, new c(), this, this.C1, new InterfaceC14603iB2() { // from class: ir.nasim.yS1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AS1.ib(this.a, (String) obj, (Map) obj2);
                }
            });
            getAdapters().add(c15871kJ5);
            this.G1 = c15871kJ5;
        }
    }

    @Override // ir.nasim.J90, ir.nasim.AV1, ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void T6() {
        super.T6();
        C8();
        Ca(null);
        this.G1 = null;
        Da(null);
        ma(null);
        AbstractC4177Ea0 abstractC4177Ea0 = this.basePresenter;
        if (abstractC4177Ea0 != null) {
            abstractC4177Ea0.b();
        }
        this.basePresenter = null;
    }

    @Override // ir.nasim.J90, ir.nasim.AV1, ir.nasim.AbstractC22588vV1.e
    public void X0() {
        L9(ca(), false);
    }

    public final C8054Ui1 Xa() {
        C8054Ui1 c8054Ui1 = this.K1;
        if (c8054Ui1 != null) {
            return c8054Ui1;
        }
        AbstractC13042fc3.y("contactsModule");
        return null;
    }

    public final InterfaceC8288Vi1 Ya() {
        InterfaceC8288Vi1 interfaceC8288Vi1 = this.I1;
        if (interfaceC8288Vi1 != null) {
            return interfaceC8288Vi1;
        }
        AbstractC13042fc3.y("contactsNavigator");
        return null;
    }

    @Override // ir.nasim.C22042ua0
    public boolean a() {
        return true;
    }

    public final InterfaceC7565Sg3 ab() {
        InterfaceC7565Sg3 interfaceC7565Sg3 = this.H1;
        if (interfaceC7565Sg3 != null) {
            return interfaceC7565Sg3;
        }
        AbstractC13042fc3.y("jaryanNavigator");
        return null;
    }

    public final DK4 cb() {
        DK4 dk4 = this.J1;
        if (dk4 != null) {
            return dk4;
        }
        AbstractC13042fc3.y("onBoardingNavigator");
        return null;
    }

    @Override // ir.nasim.AV1
    protected void ea() {
        L9(ca(), false);
    }

    @Override // androidx.fragment.app.Fragment
    public void g7(int i2, String[] strArr, int[] iArr) {
        Object value;
        Object value2;
        AbstractC13042fc3.i(strArr, "permissions");
        AbstractC13042fc3.i(iArr, "grantResults");
        if (i2 != 301) {
            super.g7(i2, strArr, iArr);
            return;
        }
        Integer numD0 = AbstractC10242bK.d0(iArr);
        if (numD0 == null || numD0.intValue() != 0) {
            InterfaceC9336Zm4 interfaceC9336Zm4Db = db();
            do {
                value = interfaceC9336Zm4Db.getValue();
                ((Boolean) value).booleanValue();
            } while (!interfaceC9336Zm4Db.f(value, Boolean.FALSE));
            return;
        }
        Xa().p0();
        InterfaceC9336Zm4 interfaceC9336Zm4Db2 = db();
        do {
            value2 = interfaceC9336Zm4Db2.getValue();
            ((Boolean) value2).booleanValue();
        } while (!interfaceC9336Zm4Db2.f(value2, Boolean.TRUE));
    }

    @Override // ir.nasim.AV1, ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void h7() {
        Object value;
        boolean zFb;
        if (!((Boolean) db().getValue()).booleanValue()) {
            InterfaceC9336Zm4 interfaceC9336Zm4Db = db();
            do {
                value = interfaceC9336Zm4Db.getValue();
                ((Boolean) value).booleanValue();
                zFb = fb();
                if (zFb) {
                    Xa().p0();
                }
            } while (!interfaceC9336Zm4Db.f(value, Boolean.valueOf(zFb)));
        }
        super.h7();
    }

    @Override // ir.nasim.AV1, androidx.fragment.app.Fragment
    public void l7(View view, Bundle bundle) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, bundle);
        gb();
        if (getListsScrollListener() != null) {
            ma(getListsScrollListener());
        }
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        ComposeView composeView = new ComposeView(contextS7, null, 0, 6, null);
        if (C8386Vt0.k6()) {
            kb(composeView);
        } else {
            nb(composeView);
        }
        this.F1 = composeView;
        if (C8386Vt0.J9()) {
            AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new d(null), 3, null);
        }
        if (this.C1 == OP1.CHANNEL && C8386Vt0.F9()) {
            AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new e(null), 3, null);
        }
        if (this.C1 == OP1.GROUP && C8386Vt0.J9()) {
            AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new f(null), 3, null);
        }
    }
}
