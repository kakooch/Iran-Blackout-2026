package ir.nasim;

import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.G;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.shimmer.ShimmerFrameLayout;
import ir.nasim.AbstractC13460gG3;
import ir.nasim.components.appbar.view.BaleToolbar;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\b\u0007\u0018\u0000 =2\u00020\u0001:\u0001>B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0003R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001d\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00103\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00100R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00106R\u0011\u0010<\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b:\u0010;¨\u0006?"}, d2 = {"Lir/nasim/t17;", "Lir/nasim/ua0;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "Lir/nasim/rB7;", "M6", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "T6", "Lir/nasim/Fz2;", "c1", "Lir/nasim/Fz2;", "_binding", "Lir/nasim/Kj2;", "d1", "Lir/nasim/Yu3;", "Y9", "()Lir/nasim/Kj2;", "feedViewModel", "Lir/nasim/q17;", "e1", "Lir/nasim/q17;", "suggestersAdapter", "Landroidx/recyclerview/widget/f;", "f1", "Landroidx/recyclerview/widget/f;", "concatSuggestersAdapterAdapter", "Lir/nasim/lm1;", "g1", "Lir/nasim/lm1;", "contextThemeWrapper", "", "h1", "Z", "isUpvotedByMe", "", "i1", TokenNames.I, "countSuggester", "j1", "peerId", "", "k1", "J", "feedRid", "l1", "feedDate", "X9", "()Lir/nasim/Fz2;", "binding", "m1", "a", "jaryan_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.t17, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C21051t17 extends C22042ua0 {

    /* renamed from: m1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int n1 = 8;

    /* renamed from: c1, reason: from kotlin metadata */
    private C4653Fz2 _binding;

    /* renamed from: d1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 feedViewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C5679Kj2.class), new c(this), new d(null, this), new e(this));

    /* renamed from: e1, reason: from kotlin metadata */
    private final C19248q17 suggestersAdapter;

    /* renamed from: f1, reason: from kotlin metadata */
    private final androidx.recyclerview.widget.f concatSuggestersAdapterAdapter;

    /* renamed from: g1, reason: from kotlin metadata */
    private C16731lm1 contextThemeWrapper;

    /* renamed from: h1, reason: from kotlin metadata */
    private boolean isUpvotedByMe;

    /* renamed from: i1, reason: from kotlin metadata */
    private int countSuggester;

    /* renamed from: j1, reason: from kotlin metadata */
    private int peerId;

    /* renamed from: k1, reason: from kotlin metadata */
    private long feedRid;

    /* renamed from: l1, reason: from kotlin metadata */
    private long feedDate;

    /* renamed from: ir.nasim.t17$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final C21051t17 a(boolean z, int i, int i2, long j, long j2) {
            C21051t17 c21051t17 = new C21051t17();
            Bundle bundle = new Bundle();
            bundle.putBoolean("KEY_IS_UP_VOTED_BY_ME", z);
            bundle.putInt("KEY_COUNT_SUGGESTER", i);
            bundle.putInt("KEY_PEER_ID_FEED", i2);
            bundle.putLong("KEY_RID_FEED", j);
            bundle.putLong("KEY_DATE_FEED", j2);
            c21051t17.a8(bundle);
            return c21051t17;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.t17$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        /* renamed from: ir.nasim.t17$b$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C21051t17 c;

            /* renamed from: ir.nasim.t17$b$a$a, reason: collision with other inner class name */
            static final class C1566a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                /* synthetic */ Object c;
                final /* synthetic */ C21051t17 d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1566a(C21051t17 c21051t17, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = c21051t17;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    C1566a c1566a = new C1566a(this.d, interfaceC20295rm1);
                    c1566a.c = obj;
                    return c1566a;
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    this.d.Y9().v2(((C13628gZ0) this.c).d() instanceof AbstractC13460gG3.c);
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(C13628gZ0 c13628gZ0, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C1566a) create(c13628gZ0, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C21051t17 c21051t17, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c21051t17;
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
                    InterfaceC4557Fq2 interfaceC4557Fq2E = this.c.suggestersAdapter.E();
                    C1566a c1566a = new C1566a(this.c, null);
                    this.b = 1;
                    if (AbstractC6459Nq2.l(interfaceC4557Fq2E, c1566a, this) == objE) {
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

        /* renamed from: ir.nasim.t17$b$b, reason: collision with other inner class name */
        static final class C1567b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C21051t17 c;

            /* renamed from: ir.nasim.t17$b$b$a */
            static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                /* synthetic */ Object c;
                final /* synthetic */ C21051t17 d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(C21051t17 c21051t17, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = c21051t17;
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
                        C19248q17 c19248q17 = this.d.suggestersAdapter;
                        this.b = 1;
                        if (c19248q17.L(nt4, this) == objE) {
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
                public final Object invoke(NT4 nt4, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((a) create(nt4, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1567b(C21051t17 c21051t17, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c21051t17;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C1567b(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4557Fq2 interfaceC4557Fq2J1 = this.c.Y9().J1(this.c.isUpvotedByMe, this.c.peerId, this.c.feedRid, this.c.feedDate);
                    a aVar = new a(this.c, null);
                    this.b = 1;
                    if (AbstractC6459Nq2.l(interfaceC4557Fq2J1, aVar, this) == objE) {
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
                return ((C1567b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.t17$b$c */
        static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C21051t17 c;

            /* renamed from: ir.nasim.t17$b$c$a */
            static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                /* synthetic */ Object c;
                final /* synthetic */ C21051t17 d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(C21051t17 c21051t17, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = c21051t17;
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
                    C22315v17 c22315v17 = (C22315v17) this.c;
                    ShimmerFrameLayout shimmerFrameLayout = this.d.X9().k;
                    AbstractC13042fc3.h(shimmerFrameLayout, "suggestersShimmerRv");
                    shimmerFrameLayout.setVisibility(c22315v17.b() ^ true ? 0 : 8);
                    RecyclerView recyclerView = this.d.X9().j;
                    AbstractC13042fc3.h(recyclerView, "suggestersRv");
                    recyclerView.setVisibility(c22315v17.b() ? 0 : 8);
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(C22315v17 c22315v17, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((a) create(c22315v17, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(C21051t17 c21051t17, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c21051t17;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new c(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC10258bL6 interfaceC10258bL6L1 = this.c.Y9().L1();
                    a aVar = new a(this.c, null);
                    this.b = 1;
                    if (AbstractC6459Nq2.l(interfaceC10258bL6L1, aVar, this) == objE) {
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
                return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = C21051t17.this.new b(interfaceC20295rm1);
            bVar.c = obj;
            return bVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
            AbstractC10533bm0.d(interfaceC20315ro1, null, null, new a(C21051t17.this, null), 3, null);
            AbstractC10533bm0.d(interfaceC20315ro1, null, null, new C1567b(C21051t17.this, null), 3, null);
            AbstractC10533bm0.d(interfaceC20315ro1, null, null, new c(C21051t17.this, null), 3, null);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.t17$c */
    public static final class c extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Fragment fragment) {
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

    /* renamed from: ir.nasim.t17$d */
    public static final class d extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ Fragment f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(SA2 sa2, Fragment fragment) {
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

    /* renamed from: ir.nasim.t17$e */
    public static final class e extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Fragment fragment) {
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

    public C21051t17() {
        C19248q17 c19248q17 = new C19248q17();
        this.suggestersAdapter = c19248q17;
        this.concatSuggestersAdapterAdapter = c19248q17.N(new C13729gj2(new SA2() { // from class: ir.nasim.r17
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C21051t17.W9(this.a);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 W9(C21051t17 c21051t17) {
        AbstractC13042fc3.i(c21051t17, "this$0");
        c21051t17.suggestersAdapter.J();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C5679Kj2 Y9() {
        return (C5679Kj2) this.feedViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z9(C21051t17 c21051t17, View view) {
        AbstractC13042fc3.i(c21051t17, "this$0");
        Group group = c21051t17.X9().b;
        AbstractC13042fc3.h(group, "groupBanner");
        group.setVisibility(8);
        c21051t17.Y9().n2(false);
    }

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle savedInstanceState) {
        super.M6(savedInstanceState);
        Bundle bundleE5 = E5();
        if (bundleE5 != null) {
            this.isUpvotedByMe = bundleE5.getBoolean("KEY_IS_UP_VOTED_BY_ME");
            this.countSuggester = bundleE5.getInt("KEY_COUNT_SUGGESTER");
            this.peerId = bundleE5.getInt("KEY_PEER_ID_FEED");
            this.feedRid = bundleE5.getLong("KEY_RID_FEED");
            this.feedDate = bundleE5.getLong("KEY_DATE_FEED");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        C16731lm1 c16731lm1 = new C16731lm1(S7(), AbstractC14035hE5.Theme_Bale_Feed);
        this.contextThemeWrapper = c16731lm1;
        this._binding = C4653Fz2.c(inflater.cloneInContext(c16731lm1), container, false);
        ConstraintLayout root = X9().getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void T6() {
        super.T6();
        Y9().v2(false);
        this._binding = null;
    }

    public final C4653Fz2 X9() {
        C4653Fz2 c4653Fz2 = this._binding;
        AbstractC13042fc3.f(c4653Fz2);
        return c4653Fz2;
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        BaleToolbar baleToolbar = X9().m;
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        BaleToolbar.setHasBackButton$default(baleToolbar, fragmentActivityQ7, true, false, 4, null);
        X9().j.setAdapter(this.concatSuggestersAdapterAdapter);
        AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new b(null), 3, null);
        String strG = GY6.g(String.valueOf(this.countSuggester));
        X9().i.setText(i6(ID5.feed_suggesters_person_number, JF5.g() ? GY6.a(strG) : GY6.b(strG)));
        if (!Y9().K1()) {
            Group group = X9().b;
            AbstractC13042fc3.h(group, "groupBanner");
            group.setVisibility(8);
        } else {
            Group group2 = X9().b;
            AbstractC13042fc3.h(group2, "groupBanner");
            group2.setVisibility(0);
            X9().e.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.s17
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    C21051t17.Z9(this.a, view2);
                }
            });
        }
    }
}
