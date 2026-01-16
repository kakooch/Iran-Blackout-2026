package ir.nasim;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.G;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.f;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.AbstractC25195zt3;
import ir.nasim.C11669dP1;
import ir.nasim.C14166hT1;
import ir.nasim.C15225jD4;
import ir.nasim.C21753u45;
import ir.nasim.C24904zP1;
import ir.nasim.InterfaceC14139hQ1;
import ir.nasim.TO1;
import ir.nasim.UO1;
import ir.nasim.dialoglist.data.model.DialogDTO;
import ir.nasim.dialoglist.ui.noneCompose.DialogLayoutManager;
import ir.nasim.features.root.EmptyStateOnboardingItemAction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: ir.nasim.hT1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C14166hT1 extends AbstractC23784xW2 {
    public static final a B1 = new a(null);
    public static final int C1 = 8;
    private final InterfaceC9336Zm4 A1;
    private C15225jD4.b h1;
    private RecyclerView.t i1;
    private final InterfaceC9173Yu3 j1;
    public InterfaceC8288Vi1 k1;
    public DK4 l1;
    public InterfaceC18012nw0 m1;
    public InterfaceC7565Sg3 n1;
    public TP1 o1;
    public C24904zP1.c p1;
    public InterfaceC8898Xu3 q1;
    public QM1 r1;
    private C10652by2 s1;
    private final InterfaceC9173Yu3 t1;
    private final InterfaceC9173Yu3 u1;
    public TO1.a v1;
    private final InterfaceC9173Yu3 w1;
    private final InterfaceC9173Yu3 x1;
    private C11669dP1 y1;
    private AtomicInteger z1;

    /* renamed from: ir.nasim.hT1$a */
    public static final class a {
        private a() {
        }

        public final C14166hT1 a(int i, RecyclerView.t tVar) {
            AbstractC13042fc3.i(tVar, "onScrollListener");
            C14166hT1 c14166hT1 = new C14166hT1(tVar);
            Bundle bundle = new Bundle();
            bundle.putInt("arg_folder_id", i);
            c14166hT1.a8(bundle);
            return c14166hT1;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.hT1$b */
    public static final class b implements HI4 {
        b() {
        }

        @Override // ir.nasim.HI4
        public void T0() {
            C14166hT1 c14166hT1 = C14166hT1.this;
            C22042ua0.A9(c14166hT1, c14166hT1.qa().b(EnumC6843Pf2.d), false, null, 6, null);
        }

        @Override // ir.nasim.HI4
        public void W1(int i) {
            C14166hT1 c14166hT1 = C14166hT1.this;
            C22042ua0.A9(c14166hT1, c14166hT1.xa().h(i, new ArrayList()), false, null, 6, null);
        }
    }

    /* renamed from: ir.nasim.hT1$c */
    /* synthetic */ class c extends EB2 implements SA2 {
        c(Object obj) {
            super(0, obj, C14166hT1.class, "createPermissionDialog", "createPermissionDialog()V", 0);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            y();
            return C19938rB7.a;
        }

        public final void y() {
            ((C14166hT1) this.receiver).la();
        }
    }

    /* renamed from: ir.nasim.hT1$d */
    static final class d implements InterfaceC14603iB2 {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(C11458d25 c11458d25, EmptyStateOnboardingItemAction emptyStateOnboardingItemAction) {
            AbstractC13042fc3.i(c11458d25, "peer");
            AbstractC13042fc3.i(emptyStateOnboardingItemAction, "dialogEmptyStateOnboardingMode");
            C18987pb3.x1(C18987pb3.a, c11458d25, null, null, false, null, null, false, null, null, false, emptyStateOnboardingItemAction, 1022, null);
            return C19938rB7.a;
        }

        public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            InterfaceC15796kB2 interfaceC15796kB2E = C14166hT1.this.Aa().e();
            interfaceC22053ub1.W(886288391);
            Object objB = interfaceC22053ub1.B();
            if (objB == InterfaceC22053ub1.a.a()) {
                objB = new InterfaceC14603iB2() { // from class: ir.nasim.iT1
                    @Override // ir.nasim.InterfaceC14603iB2
                    public final Object invoke(Object obj, Object obj2) {
                        return C14166hT1.d.c((C11458d25) obj, (EmptyStateOnboardingItemAction) obj2);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            interfaceC15796kB2E.q((InterfaceC14603iB2) objB, interfaceC22053ub1, 6);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.hT1$e */
    public static final class e extends RecyclerView.j {
        e() {
        }

        private final void h() {
            int iD2;
            RecyclerView.p layoutManager = C14166hT1.this.oa().b.getLayoutManager();
            LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
            if (linearLayoutManager != null && (iD2 = linearLayoutManager.d2()) >= 0 && iD2 < 5) {
                C14166hT1.this.oa().b.scrollToPosition(0);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public void d(int i, int i2) {
            super.d(i, i2);
            if (i != 0 || i2 <= 0) {
                return;
            }
            h();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public void e(int i, int i2, int i3) {
            if (i2 == 0 || i == 0) {
                h();
            }
        }
    }

    /* renamed from: ir.nasim.hT1$f */
    public static final class f implements C15225jD4.b {
        final /* synthetic */ int a;
        final /* synthetic */ C14166hT1 b;

        f(int i, C14166hT1 c14166hT1) {
            this.a = i;
            this.b = c14166hT1;
        }

        @Override // ir.nasim.C15225jD4.b
        public void didReceivedNotification(int i, Object... objArr) {
            AbstractC13042fc3.i(objArr, "args");
            if (i != this.a) {
                return;
            }
            this.b.Ka();
        }
    }

    /* renamed from: ir.nasim.hT1$g */
    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.hT1$g$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C14166hT1 c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C14166hT1 c14166hT1, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c14166hT1;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                C11669dP1 c11669dP1 = this.c.y1;
                if (c11669dP1 != null) {
                    c11669dP1.G();
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(Map map, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(map, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.hT1$g$b */
        public static final class b implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            /* renamed from: ir.nasim.hT1$g$b$a */
            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.hT1$g$b$a$a, reason: collision with other inner class name */
                public static final class C1269a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C1269a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return a.this.a(null, this);
                    }
                }

                public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                    this.a = interfaceC4806Gq2;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r8, ir.nasim.InterfaceC20295rm1 r9) {
                    /*
                        r7 = this;
                        boolean r0 = r9 instanceof ir.nasim.C14166hT1.g.b.a.C1269a
                        if (r0 == 0) goto L13
                        r0 = r9
                        ir.nasim.hT1$g$b$a$a r0 = (ir.nasim.C14166hT1.g.b.a.C1269a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.hT1$g$b$a$a r0 = new ir.nasim.hT1$g$b$a$a
                        r0.<init>(r9)
                    L18:
                        java.lang.Object r9 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        ir.nasim.AbstractC10685c16.b(r9)
                        goto La9
                    L2a:
                        java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                        java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                        r8.<init>(r9)
                        throw r8
                    L32:
                        ir.nasim.AbstractC10685c16.b(r9)
                        ir.nasim.Gq2 r9 = r7.a
                        java.util.Map r8 = (java.util.Map) r8
                        java.util.Collection r8 = r8.values()
                        java.lang.Iterable r8 = (java.lang.Iterable) r8
                        java.util.ArrayList r2 = new java.util.ArrayList
                        r2.<init>()
                        java.util.Iterator r8 = r8.iterator()
                    L48:
                        boolean r4 = r8.hasNext()
                        if (r4 == 0) goto L5f
                        java.lang.Object r4 = r8.next()
                        r5 = r4
                        ir.nasim.SP1 r5 = (ir.nasim.SP1) r5
                        java.lang.Boolean r5 = r5.l()
                        if (r5 == 0) goto L48
                        r2.add(r4)
                        goto L48
                    L5f:
                        r8 = 10
                        int r8 = ir.nasim.ZW0.x(r2, r8)
                        int r8 = ir.nasim.AbstractC18278oO3.f(r8)
                        r4 = 16
                        int r8 = ir.nasim.AbstractC21867uG5.e(r8, r4)
                        java.util.LinkedHashMap r4 = new java.util.LinkedHashMap
                        r4.<init>(r8)
                        java.util.Iterator r8 = r2.iterator()
                    L78:
                        boolean r2 = r8.hasNext()
                        if (r2 == 0) goto La0
                        java.lang.Object r2 = r8.next()
                        ir.nasim.SP1 r2 = (ir.nasim.SP1) r2
                        long r5 = r2.i()
                        java.lang.Long r5 = ir.nasim.AbstractC6392Nk0.e(r5)
                        java.lang.Boolean r2 = r2.l()
                        ir.nasim.XV4 r2 = ir.nasim.AbstractC4616Fw7.a(r5, r2)
                        java.lang.Object r5 = r2.e()
                        java.lang.Object r2 = r2.f()
                        r4.put(r5, r2)
                        goto L78
                    La0:
                        r0.b = r3
                        java.lang.Object r8 = r9.a(r4, r0)
                        if (r8 != r1) goto La9
                        return r1
                    La9:
                        ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
                        return r8
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C14166hT1.g.b.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public b(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C14166hT1.this.new g(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2V = AbstractC6459Nq2.v(new b(C14166hT1.this.va().f()));
                a aVar = new a(C14166hT1.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2V, aVar, this) == objE) {
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
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.hT1$h */
    public static final class h extends RecyclerView.t {
        private int a = -1;
        private int b = -1;

        h() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void b(RecyclerView recyclerView, int i, int i2) {
            AbstractC13042fc3.i(recyclerView, "rv");
            super.b(recyclerView, i, i2);
            C11669dP1 c11669dP1 = C14166hT1.this.y1;
            if (c11669dP1 != null) {
                C14166hT1 c14166hT1 = C14166hT1.this;
                RecyclerView.p layoutManager = recyclerView.getLayoutManager();
                LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
                if (linearLayoutManager == null) {
                    return;
                }
                int iD2 = linearLayoutManager.d2();
                int iG2 = linearLayoutManager.g2();
                if (iD2 == -1 || iG2 == -1) {
                    return;
                }
                if (iD2 == this.a && iG2 == this.b) {
                    return;
                }
                this.a = iD2;
                this.b = iG2;
                List listF = c11669dP1.K().f();
                C24411ya3 c24411ya3 = new C24411ya3(iD2, iG2);
                ArrayList arrayList = new ArrayList();
                Iterator it = c24411ya3.iterator();
                while (it.hasNext()) {
                    DialogDTO dialogDTO = (DialogDTO) AbstractC15401jX0.t0(listF, ((AbstractC18386oa3) it).b());
                    if (dialogDTO != null) {
                        arrayList.add(dialogDTO);
                    }
                }
                InterfaceC14603iB2 interfaceC14603iB2L = c14166hT1.sa().l();
                Integer numValueOf = Integer.valueOf(c14166hT1.wa());
                ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(arrayList, 10));
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(Long.valueOf(((DialogDTO) it2.next()).getPeerUniqueId()));
                }
                interfaceC14603iB2L.invoke(numValueOf, arrayList2);
                ArrayList arrayList3 = new ArrayList();
                for (Object obj : arrayList) {
                    DialogDTO dialogDTO2 = (DialogDTO) obj;
                    if ((dialogDTO2.getPreviewLastMessage() instanceof AbstractC25195zt3.b) && ((AbstractC25195zt3.b) dialogDTO2.getPreviewLastMessage()).c() && dialogDTO2.getUnreadMessageCount() == 1) {
                        arrayList3.add(obj);
                    }
                }
                c14166hT1.Ba().e2().addAll(arrayList3);
            }
        }
    }

    /* renamed from: ir.nasim.hT1$i */
    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        /* renamed from: ir.nasim.hT1$i$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C14166hT1 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C14166hT1 c14166hT1, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c14166hT1;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    NT4 nt4 = (NT4) this.c;
                    UO1.d.a.b(this.d.wa(), "AdapterEmitted: Let's Submit", "FRAGMENT");
                    C11669dP1 c11669dP1 = this.d.y1;
                    if (c11669dP1 != null) {
                        this.b = 1;
                        if (c11669dP1.L(nt4, this) == objE) {
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
            public final Object invoke(NT4 nt4, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(nt4, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        i(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            i iVar = C14166hT1.this.new i(interfaceC20295rm1);
            iVar.c = obj;
            return iVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2V = AbstractC6459Nq2.v(C14166hT1.this.Ba().h2(C14166hT1.this.wa(), (InterfaceC20315ro1) this.c));
                a aVar = new a(C14166hT1.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2V, aVar, this) == objE) {
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
            return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.hT1$j */
    static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.hT1$j$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C14166hT1 c;
            final /* synthetic */ C11669dP1 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C14166hT1 c14166hT1, C11669dP1 c11669dP1, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c14166hT1;
                this.d = c11669dP1;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object value;
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                InterfaceC9336Zm4 interfaceC9336Zm4 = this.c.A1;
                C11669dP1 c11669dP1 = this.d;
                do {
                    value = interfaceC9336Zm4.getValue();
                    ((Number) value).intValue();
                } while (!interfaceC9336Zm4.f(value, AbstractC6392Nk0.d(c11669dP1.getItemCount())));
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C19938rB7 c19938rB7, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(c19938rB7, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        j(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C14166hT1.this.new j(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C11669dP1 c11669dP1 = C14166hT1.this.y1;
                if (c11669dP1 == null) {
                    return C19938rB7.a;
                }
                InterfaceC4557Fq2 interfaceC4557Fq2F = c11669dP1.F();
                a aVar = new a(C14166hT1.this, c11669dP1, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2F, aVar, this) == objE) {
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
            return ((j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.hT1$k */
    static final class k extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.hT1$k$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C11669dP1 c;
            final /* synthetic */ C14166hT1 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C11669dP1 c11669dP1, C14166hT1 c14166hT1, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c11669dP1;
                this.d = c14166hT1;
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
                int itemCount = this.c.getItemCount();
                if (this.d.z1.get() == 0 && itemCount > 0) {
                    this.d.oa().b.scrollToPosition(0);
                    this.d.z1.set(itemCount);
                }
                this.d.Ja(itemCount);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C13628gZ0 c13628gZ0, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(c13628gZ0, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        k(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C14166hT1.this.new k(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C11669dP1 c11669dP1 = C14166hT1.this.y1;
                if (c11669dP1 == null) {
                    return C19938rB7.a;
                }
                InterfaceC4557Fq2 interfaceC4557Fq2E = c11669dP1.E();
                a aVar = new a(c11669dP1, C14166hT1.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2E, aVar, this) == objE) {
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
            return ((k) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.hT1$l */
    public static final class l implements SA2 {
        l() {
        }

        public void a() {
            C11669dP1 c11669dP1 = C14166hT1.this.y1;
            if (c11669dP1 != null) {
                c11669dP1.I(this);
            }
            C14166hT1.this.Ba().c3(C14166hT1.this.wa());
            UO1.d.a.b(C14166hT1.this.wa(), "Pages updated for the first time.", "FRAGMENT");
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.hT1$m */
    static final class m extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;

        m(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C14166hT1.this.new m(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            C14166hT1 c14166hT1;
            C14166hT1 c14166hT12;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                RecyclerView.p layoutManager = C14166hT1.this.oa().b.getLayoutManager();
                AbstractC13042fc3.g(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                c14166hT1 = C14166hT1.this;
                if (((LinearLayoutManager) layoutManager).d2() >= 15) {
                    c14166hT1.oa().b.scrollToPosition(7);
                    this.b = c14166hT1;
                    this.c = 1;
                    if (HG1.b(150L, this) == objE) {
                        return objE;
                    }
                    c14166hT12 = c14166hT1;
                }
                c14166hT1.oa().b.smoothScrollToPosition(0);
                return C19938rB7.a;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c14166hT12 = (C14166hT1) this.b;
            AbstractC10685c16.b(obj);
            c14166hT1 = c14166hT12;
            c14166hT1.oa().b.smoothScrollToPosition(0);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((m) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.hT1$n */
    static final class n extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.hT1$n$a */
        static final class a extends AbstractC19859r37 implements InterfaceC15796kB2 {
            int b;
            /* synthetic */ Object c;
            /* synthetic */ Object d;

            a(InterfaceC20295rm1 interfaceC20295rm1) {
                super(3, interfaceC20295rm1);
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x002c  */
            @Override // ir.nasim.E90
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r3) {
                /*
                    r2 = this;
                    ir.nasim.AbstractC13660gc3.e()
                    int r0 = r2.b
                    if (r0 != 0) goto L32
                    ir.nasim.AbstractC10685c16.b(r3)
                    java.lang.Object r3 = r2.c
                    ir.nasim.gZ0 r3 = (ir.nasim.C13628gZ0) r3
                    java.lang.Object r0 = r2.d
                    ir.nasim.xd1 r0 = (ir.nasim.EnumC23849xd1) r0
                    ir.nasim.iG3 r3 = r3.b()
                    if (r3 == 0) goto L2c
                    boolean r3 = r3.g()
                    r1 = 1
                    if (r3 != r1) goto L2c
                    ir.nasim.xd1 r3 = ir.nasim.EnumC23849xd1.b
                    if (r0 == r3) goto L2d
                    ir.nasim.xd1 r3 = ir.nasim.EnumC23849xd1.c
                    if (r0 == r3) goto L2d
                    ir.nasim.xd1 r3 = ir.nasim.EnumC23849xd1.d
                    if (r0 != r3) goto L2c
                    goto L2d
                L2c:
                    r1 = 0
                L2d:
                    java.lang.Boolean r3 = ir.nasim.AbstractC6392Nk0.a(r1)
                    return r3
                L32:
                    java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r3.<init>(r0)
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C14166hT1.n.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // ir.nasim.InterfaceC15796kB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object q(C13628gZ0 c13628gZ0, EnumC23849xd1 enumC23849xd1, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(interfaceC20295rm1);
                aVar.c = c13628gZ0;
                aVar.d = enumC23849xd1;
                return aVar.invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.hT1$n$b */
        static final class b implements InterfaceC4806Gq2 {
            final /* synthetic */ C14166hT1 a;

            b(C14166hT1 c14166hT1) {
                this.a = c14166hT1;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            public /* bridge */ /* synthetic */ Object a(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return b(((Boolean) obj).booleanValue(), interfaceC20295rm1);
            }

            public final Object b(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
                if (!z) {
                    return C19938rB7.a;
                }
                C11669dP1 c11669dP1 = this.a.y1;
                if (c11669dP1 != null) {
                    c11669dP1.J();
                }
                UO1.d.a.b(this.a.wa(), "Mediator retried.", "FRAGMENT");
                return C19938rB7.a;
            }
        }

        n(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C14166hT1.this.new n(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            InterfaceC4557Fq2 interfaceC4557Fq2E;
            InterfaceC4557Fq2 interfaceC4557Fq2S;
            InterfaceC4557Fq2 interfaceC4557Fq2V;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C11669dP1 c11669dP1 = C14166hT1.this.y1;
                if (c11669dP1 != null && (interfaceC4557Fq2E = c11669dP1.E()) != null && (interfaceC4557Fq2S = AbstractC6459Nq2.S(interfaceC4557Fq2E, C14166hT1.this.Ba().m2(), new a(null))) != null && (interfaceC4557Fq2V = AbstractC6459Nq2.v(interfaceC4557Fq2S)) != null) {
                    b bVar = new b(C14166hT1.this);
                    this.b = 1;
                    if (interfaceC4557Fq2V.b(bVar, this) == objE) {
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
            return ((n) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.hT1$o */
    public static final class o extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return (InterfaceC15408jX7) this.e.invoke();
        }
    }

    /* renamed from: ir.nasim.hT1$p */
    public static final class p extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9173Yu3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return AbstractC6550Nz2.c(this.e).d1();
        }
    }

    /* renamed from: ir.nasim.hT1$q */
    public static final class q extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(SA2 sa2, InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = sa2;
            this.f = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC20375ru1 invoke() {
            AbstractC20375ru1 abstractC20375ru1;
            SA2 sa2 = this.e;
            if (sa2 != null && (abstractC20375ru1 = (AbstractC20375ru1) sa2.invoke()) != null) {
                return abstractC20375ru1;
            }
            InterfaceC15408jX7 interfaceC15408jX7C = AbstractC6550Nz2.c(this.f);
            androidx.lifecycle.h hVar = interfaceC15408jX7C instanceof androidx.lifecycle.h ? (androidx.lifecycle.h) interfaceC15408jX7C : null;
            return hVar != null ? hVar.p3() : AbstractC20375ru1.a.b;
        }
    }

    /* renamed from: ir.nasim.hT1$r */
    public static final class r extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(Fragment fragment, InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = fragment;
            this.f = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final G.c invoke() {
            G.c cVarN3;
            InterfaceC15408jX7 interfaceC15408jX7C = AbstractC6550Nz2.c(this.f);
            androidx.lifecycle.h hVar = interfaceC15408jX7C instanceof androidx.lifecycle.h ? (androidx.lifecycle.h) interfaceC15408jX7C : null;
            return (hVar == null || (cVarN3 = hVar.n3()) == null) ? this.e.n3() : cVarN3;
        }
    }

    /* renamed from: ir.nasim.hT1$s */
    public static final class s extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Fragment invoke() {
            return this.e;
        }
    }

    /* renamed from: ir.nasim.hT1$t */
    public static final class t extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return (InterfaceC15408jX7) this.e.invoke();
        }
    }

    /* renamed from: ir.nasim.hT1$u */
    public static final class u extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9173Yu3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return AbstractC6550Nz2.c(this.e).d1();
        }
    }

    /* renamed from: ir.nasim.hT1$v */
    public static final class v extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(SA2 sa2, InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = sa2;
            this.f = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC20375ru1 invoke() {
            AbstractC20375ru1 abstractC20375ru1;
            SA2 sa2 = this.e;
            if (sa2 != null && (abstractC20375ru1 = (AbstractC20375ru1) sa2.invoke()) != null) {
                return abstractC20375ru1;
            }
            InterfaceC15408jX7 interfaceC15408jX7C = AbstractC6550Nz2.c(this.f);
            androidx.lifecycle.h hVar = interfaceC15408jX7C instanceof androidx.lifecycle.h ? (androidx.lifecycle.h) interfaceC15408jX7C : null;
            return hVar != null ? hVar.p3() : AbstractC20375ru1.a.b;
        }
    }

    /* renamed from: ir.nasim.hT1$w */
    public static final class w extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public w(Fragment fragment, InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = fragment;
            this.f = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final G.c invoke() {
            G.c cVarN3;
            InterfaceC15408jX7 interfaceC15408jX7C = AbstractC6550Nz2.c(this.f);
            androidx.lifecycle.h hVar = interfaceC15408jX7C instanceof androidx.lifecycle.h ? (androidx.lifecycle.h) interfaceC15408jX7C : null;
            return (hVar == null || (cVarN3 = hVar.n3()) == null) ? this.e.n3() : cVarN3;
        }
    }

    public C14166hT1(RecyclerView.t tVar) {
        AbstractC13042fc3.i(tVar, "listsScrollListener");
        this.i1 = tVar;
        this.j1 = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.bT1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C14166hT1.Ea(this.a);
            }
        });
        this.t1 = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.cT1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Integer.valueOf(C14166hT1.na(this.a));
            }
        });
        SA2 sa2 = new SA2() { // from class: ir.nasim.dT1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C14166hT1.La(this.a);
            }
        };
        EnumC4870Gx3 enumC4870Gx3 = EnumC4870Gx3.c;
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(enumC4870Gx3, new o(sa2));
        this.u1 = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(XB4.class), new p(interfaceC9173Yu3B), new q(null, interfaceC9173Yu3B), new r(this, interfaceC9173Yu3B));
        InterfaceC9173Yu3 interfaceC9173Yu3B2 = AbstractC13269fw3.b(enumC4870Gx3, new t(new s(this)));
        this.w1 = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C6243Mu0.class), new u(interfaceC9173Yu3B2), new v(null, interfaceC9173Yu3B2), new w(this, interfaceC9173Yu3B2));
        this.x1 = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.eT1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C14166hT1.ma(this.a);
            }
        });
        this.z1 = new AtomicInteger(0);
        this.A1 = AbstractC12281eL6.a(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final XB4 Ba() {
        return (XB4) this.u1.getValue();
    }

    private final void Ca() {
        int i2 = C15225jD4.i;
        f fVar = new f(i2, this);
        this.h1 = fVar;
        C15225jD4.b().a(fVar, i2);
    }

    private final void Da() {
        if (wa() == 10) {
            InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
            AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
            AbstractC10533bm0.d(AbstractC19224pz3.a(interfaceC18633oz3P6), null, null, new g(null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final h Ea(C14166hT1 c14166hT1) {
        AbstractC13042fc3.i(c14166hT1, "this$0");
        return c14166hT1.new h();
    }

    private final void Fa() {
        l lVar = new l();
        C11669dP1 c11669dP1 = this.y1;
        if (c11669dP1 != null) {
            c11669dP1.C(lVar);
        }
    }

    private final void Ga() {
        C15225jD4.b bVar = this.h1;
        if (bVar != null) {
            C15225jD4.b().e(bVar, C15225jD4.i);
            this.h1 = null;
        }
    }

    private final void Ia() {
        InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        AbstractC10533bm0.d(AbstractC19224pz3.a(interfaceC18633oz3P6), null, null, new n(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ka() {
        RecyclerView recyclerView = oa().b;
        int childCount = recyclerView.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            RecyclerView.C cFindContainingViewHolder = recyclerView.findContainingViewHolder(recyclerView.getChildAt(i2));
            C11669dP1.c cVar = cFindContainingViewHolder instanceof C11669dP1.c ? (C11669dP1.c) cFindContainingViewHolder : null;
            if (cVar != null) {
                cVar.i();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC15408jX7 La(C14166hT1 c14166hT1) {
        AbstractC13042fc3.i(c14166hT1, "this$0");
        FragmentActivity fragmentActivityQ7 = c14166hT1.Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        return fragmentActivityQ7;
    }

    private final void ha() {
        RecyclerView recyclerView = oa().b;
        Context context = recyclerView.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        recyclerView.setLayoutManager(new DialogLayoutManager(context, 1, false));
        RecyclerView.m itemAnimator = recyclerView.getItemAnimator();
        androidx.recyclerview.widget.x xVar = itemAnimator instanceof androidx.recyclerview.widget.x ? (androidx.recyclerview.widget.x) itemAnimator : null;
        if (xVar != null) {
            xVar.V(false);
        }
        recyclerView.setHasFixedSize(true);
        RecyclerView.t tVar = this.i1;
        if (tVar != null) {
            recyclerView.addOnScrollListener(tVar);
        }
        recyclerView.addOnScrollListener(za());
        C11669dP1 c11669dP1Ja = ja();
        ArrayList arrayList = new ArrayList();
        if (C8386Vt0.I3() && wa() == 0) {
            arrayList.add(new C18229oJ(Ba().c2(), new SA2() { // from class: ir.nasim.fT1
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C14166hT1.ia(this.a);
                }
            }));
        }
        if (wa() != 11) {
            arrayList.add(new C17094mO1(Ba().Y1(), Ba().g2(), sa().c()));
        }
        arrayList.add(c11669dP1Ja.N(new C15312jN1(wa(), new b(), Ba().k2(), new c(this), this.A1, AbstractC19242q11.c(58193391, true, new d()))));
        recyclerView.setAdapter(new androidx.recyclerview.widget.f(new f.a.C0112a().b(true).a(), arrayList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ia(C14166hT1 c14166hT1) {
        AbstractC13042fc3.i(c14166hT1, "this$0");
        if (c14166hT1.Ba().Z().getValue() instanceof InterfaceC14139hQ1.a) {
            C22042ua0.A9(c14166hT1, C21888uJ.INSTANCE.a(), false, null, 6, null);
        }
        return C19938rB7.a;
    }

    private final C11669dP1 ja() {
        UA2 ua2H = sa().h();
        InterfaceC14603iB2 interfaceC14603iB2N = sa().n();
        UA2 ua2E = sa().e();
        C24904zP1 c24904zP1A = ua().a(wa(), AbstractC16751lo1.a(this), Ba().u2(), Ba().D2());
        int iWa = wa();
        QM1 qm1Ra = ra();
        Object obj = ya().get();
        AbstractC13042fc3.h(obj, "get(...)");
        C11669dP1 c11669dP1 = new C11669dP1(ua2H, new UA2() { // from class: ir.nasim.gT1
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj2) {
                return C14166hT1.ka(this.a, (DialogDTO) obj2);
            }
        }, interfaceC14603iB2N, ua2E, c24904zP1A, iWa, ((Number) obj).intValue(), qm1Ra);
        c11669dP1.registerAdapterDataObserver(new e());
        this.y1 = c11669dP1;
        return c11669dP1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ka(C14166hT1 c14166hT1, DialogDTO dialogDTO) {
        AbstractC13042fc3.i(c14166hT1, "this$0");
        AbstractC13042fc3.i(dialogDTO, "it");
        c14166hT1.sa().m().invoke(dialogDTO, Integer.valueOf(c14166hT1.wa()));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void la() {
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
    public static final TO1 ma(C14166hT1 c14166hT1) {
        AbstractC13042fc3.i(c14166hT1, "this$0");
        return c14166hT1.ta().a(c14166hT1, c14166hT1.Ba(), c14166hT1.pa(), c14166hT1.wa());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int na(C14166hT1 c14166hT1) {
        AbstractC13042fc3.i(c14166hT1, "this$0");
        return c14166hT1.R7().getInt("arg_folder_id");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C10652by2 oa() {
        C10652by2 c10652by2 = this.s1;
        AbstractC13042fc3.f(c10652by2);
        return c10652by2;
    }

    private final C6243Mu0 pa() {
        return (C6243Mu0) this.w1.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final KO1 sa() {
        return (KO1) this.x1.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int wa() {
        return ((Number) this.t1.getValue()).intValue();
    }

    private final h za() {
        return (h) this.j1.getValue();
    }

    public final DK4 Aa() {
        DK4 dk4 = this.l1;
        if (dk4 != null) {
            return dk4;
        }
        AbstractC13042fc3.y("onboardingNavigator");
        return null;
    }

    public final void Ha() {
        InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        AbstractC10533bm0.d(AbstractC19224pz3.a(interfaceC18633oz3P6), null, null, new m(null), 3, null);
    }

    public final void Ja(int i2) {
        LinearLayout linearLayout = oa().c;
        AbstractC13042fc3.h(linearLayout, "emptyStatePlaceHolder");
        linearLayout.setVisibility(wa() == 10 && i2 == 0 ? 0 : 8);
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AbstractC13042fc3.i(layoutInflater, "inflater");
        this.s1 = C10652by2.c(layoutInflater.cloneInContext(new C16731lm1(S7(), AbstractC12826fE5.Theme_Bale_Base)), viewGroup, false);
        FrameLayout root = oa().getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void T6() {
        super.T6();
        oa().b.clearOnScrollListeners();
        this.i1 = null;
        this.y1 = null;
        oa().b.setAdapter(null);
        this.s1 = null;
        Ga();
    }

    @Override // androidx.fragment.app.Fragment
    public void g7(int i2, String[] strArr, int[] iArr) {
        AbstractC13042fc3.i(strArr, "permissions");
        AbstractC13042fc3.i(iArr, "grantResults");
        if (i2 != 301) {
            super.g7(i2, strArr, iArr);
            return;
        }
        Integer numD0 = AbstractC10242bK.d0(iArr);
        if (numD0 != null && numD0.intValue() == 0) {
            Ba().C3();
        } else {
            Ba().E3(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle bundle) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, bundle);
        oa().c.bringToFront();
        UO1.b(UO1.a, "ListFragment", "onViewCreated: for folderId: " + wa(), null, 4, null);
        ha();
        AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new i(null), 3, null);
        InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        AbstractC10533bm0.d(AbstractC19224pz3.a(interfaceC18633oz3P6), null, null, new j(null), 3, null);
        Da();
        InterfaceC18633oz3 interfaceC18633oz3P62 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P62, "getViewLifecycleOwner(...)");
        AbstractC10533bm0.d(AbstractC19224pz3.a(interfaceC18633oz3P62), null, null, new k(null), 3, null);
        Fa();
        Ia();
        Ca();
        ra().g();
    }

    public final InterfaceC8288Vi1 qa() {
        InterfaceC8288Vi1 interfaceC8288Vi1 = this.k1;
        if (interfaceC8288Vi1 != null) {
            return interfaceC8288Vi1;
        }
        AbstractC13042fc3.y("contactsNavigator");
        return null;
    }

    public final QM1 ra() {
        QM1 qm1 = this.r1;
        if (qm1 != null) {
            return qm1;
        }
        AbstractC13042fc3.y("contentDescriptionMapper");
        return null;
    }

    public final TO1.a ta() {
        TO1.a aVar = this.v1;
        if (aVar != null) {
            return aVar;
        }
        AbstractC13042fc3.y("dialogListUiActionFactory");
        return null;
    }

    public final C24904zP1.c ua() {
        C24904zP1.c cVar = this.p1;
        if (cVar != null) {
            return cVar;
        }
        AbstractC13042fc3.y("dialogStateBinderFactory");
        return null;
    }

    public final TP1 va() {
        TP1 tp1 = this.o1;
        if (tp1 != null) {
            return tp1;
        }
        AbstractC13042fc3.y("dialogUpdatesProvider");
        return null;
    }

    public final InterfaceC7565Sg3 xa() {
        InterfaceC7565Sg3 interfaceC7565Sg3 = this.n1;
        if (interfaceC7565Sg3 != null) {
            return interfaceC7565Sg3;
        }
        AbstractC13042fc3.y("jaryanNavigator");
        return null;
    }

    public final InterfaceC8898Xu3 ya() {
        InterfaceC8898Xu3 interfaceC8898Xu3 = this.q1;
        if (interfaceC8898Xu3 != null) {
            return interfaceC8898Xu3;
        }
        AbstractC13042fc3.y("myUid");
        return null;
    }
}
