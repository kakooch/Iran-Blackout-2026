package ir.nasim;

import ai.bale.proto.PeersStruct$ExPeer;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.v;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.G;
import ir.nasim.C7164Qn7;
import ir.nasim.InterfaceC10294bP6;
import ir.nasim.database.dailogLists.DialogEntity;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 22\u00020\u0001:\u00013B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\bJ+\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0018\u0010\u0003J\u000f\u0010\u0019\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0019\u0010\u0003J\u000f\u0010\u001a\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001a\u0010\u0003R\u001b\u0010 \u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010&\u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\"\u0010.\u001a\u00020'8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0016\u00101\u001a\u00020\u00048\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b/\u00100¨\u00064"}, d2 = {"Lir/nasim/Qn7;", "Lir/nasim/ua0;", "<init>", "()V", "", "string", "Lir/nasim/rB7;", "U9", "(Ljava/lang/String;)V", DialogEntity.COLUMN_DRAFT, "W9", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroidx/constraintlayout/widget/ConstraintLayout;", "V9", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "i9", "T6", "U6", "Lir/nasim/Gz2;", "c1", "Lir/nasim/bW7;", "R9", "()Lir/nasim/Gz2;", "binding", "Lir/nasim/bX6;", "d1", "Lir/nasim/Yu3;", "T9", "()Lir/nasim/bX6;", "viewModel", "Lai/bale/proto/PeersStruct$ExPeer;", "e1", "Lai/bale/proto/PeersStruct$ExPeer;", "S9", "()Lai/bale/proto/PeersStruct$ExPeer;", "X9", "(Lai/bale/proto/PeersStruct$ExPeer;)V", "exPeer", "f1", "Ljava/lang/String;", "thoughts", "g1", "a", "story_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.Qn7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C7164Qn7 extends C22042ua0 {

    /* renamed from: c1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding = AbstractC6056Lz2.f(this, new f(), AbstractC20046rN7.c());

    /* renamed from: d1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C10366bX6.class), new c(this), new d(null, this), new e(this));

    /* renamed from: e1, reason: from kotlin metadata */
    public PeersStruct$ExPeer exPeer;

    /* renamed from: f1, reason: from kotlin metadata */
    private String thoughts;
    static final /* synthetic */ InterfaceC5239Im3[] h1 = {AbstractC10882cM5.i(new C25226zw5(C7164Qn7.class, "binding", "getBinding()Lir/nasim/story/databinding/FragmentTextStoryBinding;", 0))};

    /* renamed from: g1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int i1 = 8;

    /* renamed from: ir.nasim.Qn7$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final C7164Qn7 a() {
            return new C7164Qn7();
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Qn7$b */
    static final class b implements InterfaceC14603iB2 {

        /* renamed from: ir.nasim.Qn7$b$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ C7164Qn7 a;

            a(C7164Qn7 c7164Qn7) {
                this.a = c7164Qn7;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 h(C7164Qn7 c7164Qn7, String str) {
                AbstractC13042fc3.i(c7164Qn7, "this$0");
                AbstractC13042fc3.i(str, ParameterNames.TEXT);
                c7164Qn7.thoughts = "";
                c7164Qn7.U9(str);
                C22042ua0.m9(c7164Qn7, c7164Qn7, false, 2, null);
                c7164Qn7.Q7().onBackPressed();
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 i(C7164Qn7 c7164Qn7, String str) {
                AbstractC13042fc3.i(c7164Qn7, "this$0");
                AbstractC13042fc3.i(str, DialogEntity.COLUMN_DRAFT);
                c7164Qn7.thoughts = str;
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 k(C7164Qn7 c7164Qn7) {
                AbstractC13042fc3.i(c7164Qn7, "this$0");
                c7164Qn7.Q7().onBackPressed();
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 n(C7164Qn7 c7164Qn7) {
                AbstractC13042fc3.i(c7164Qn7, "this$0");
                c7164Qn7.T9().X5("");
                return C19938rB7.a;
            }

            public final void f(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                String strF4 = this.a.T9().F4();
                if (strF4 == null) {
                    strF4 = "";
                }
                String str = strF4;
                interfaceC22053ub1.W(-363407750);
                boolean zD = interfaceC22053ub1.D(this.a);
                final C7164Qn7 c7164Qn7 = this.a;
                Object objB = interfaceC22053ub1.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    objB = new UA2() { // from class: ir.nasim.Rn7
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return C7164Qn7.b.a.h(c7164Qn7, (String) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                UA2 ua2 = (UA2) objB;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(-363397701);
                boolean zD2 = interfaceC22053ub1.D(this.a);
                final C7164Qn7 c7164Qn72 = this.a;
                Object objB2 = interfaceC22053ub1.B();
                if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                    objB2 = new UA2() { // from class: ir.nasim.Sn7
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return C7164Qn7.b.a.i(c7164Qn72, (String) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB2);
                }
                UA2 ua22 = (UA2) objB2;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(-363393373);
                boolean zD3 = interfaceC22053ub1.D(this.a);
                final C7164Qn7 c7164Qn73 = this.a;
                Object objB3 = interfaceC22053ub1.B();
                if (zD3 || objB3 == InterfaceC22053ub1.a.a()) {
                    objB3 = new SA2() { // from class: ir.nasim.Tn7
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C7164Qn7.b.a.k(c7164Qn73);
                        }
                    };
                    interfaceC22053ub1.s(objB3);
                }
                SA2 sa2 = (SA2) objB3;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(-363388767);
                boolean zD4 = interfaceC22053ub1.D(this.a);
                final C7164Qn7 c7164Qn74 = this.a;
                Object objB4 = interfaceC22053ub1.B();
                if (zD4 || objB4 == InterfaceC22053ub1.a.a()) {
                    objB4 = new SA2() { // from class: ir.nasim.Un7
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C7164Qn7.b.a.n(c7164Qn74);
                        }
                    };
                    interfaceC22053ub1.s(objB4);
                }
                interfaceC22053ub1.Q();
                AbstractC19664qk.v(null, ua2, ua22, str, sa2, (SA2) objB4, interfaceC22053ub1, 0, 1);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                f((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        b() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(-747625050, true, new a(C7164Qn7.this), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Qn7$c */
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

    /* renamed from: ir.nasim.Qn7$d */
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

    /* renamed from: ir.nasim.Qn7$e */
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

    /* renamed from: ir.nasim.Qn7$f */
    public static final class f extends AbstractC8614Ws3 implements UA2 {
        public f() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C4887Gz2.a(fragment.V7());
        }
    }

    private final C4887Gz2 R9() {
        Object objA = this.binding.a(this, h1[0]);
        AbstractC13042fc3.h(objA, "getValue(...)");
        return (C4887Gz2) objA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C10366bX6 T9() {
        return (C10366bX6) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U9(String string) {
        long jA = AbstractC19981rG5.a();
        T9().k3(S9(), jA);
        T9().C2(string, jA, S9());
        C23144wQ6.a.g("send");
    }

    private final void W9(String draft) {
        T9().X5(draft);
    }

    public final PeersStruct$ExPeer S9() {
        PeersStruct$ExPeer peersStruct$ExPeer = this.exPeer;
        if (peersStruct$ExPeer != null) {
            return peersStruct$ExPeer;
        }
        AbstractC13042fc3.y("exPeer");
        return null;
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void T6() {
        super.T6();
        T9().d6();
    }

    @Override // androidx.fragment.app.Fragment
    public void U6() {
        String str = this.thoughts;
        if (str != null) {
            if (str == null) {
                AbstractC13042fc3.y("thoughts");
                str = null;
            }
            W9(str);
        }
        super.U6();
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: V9, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        ConstraintLayout root = C4887Gz2.c(inflater, container, false).getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    public final void X9(PeersStruct$ExPeer peersStruct$ExPeer) {
        AbstractC13042fc3.i(peersStruct$ExPeer, "<set-?>");
        this.exPeer = peersStruct$ExPeer;
    }

    @Override // ir.nasim.C22042ua0
    public void i9() {
        super.i9();
        T9().Y4();
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        C22548vQ6 c22548vQ6M4 = T9().m4();
        if (c22548vQ6M4 != null) {
            T9().H5(new InterfaceC10294bP6.a(c22548vQ6M4.a()));
            ComposeView composeView = R9().b;
            composeView.setViewCompositionStrategy(v.d.b);
            composeView.setContent(AbstractC19242q11.c(145509889, true, new b()));
            X9(T9().i4());
        }
    }
}
