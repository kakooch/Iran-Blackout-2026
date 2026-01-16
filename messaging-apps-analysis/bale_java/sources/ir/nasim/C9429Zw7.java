package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.e;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.G;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.AbstractC4625Fx7;
import ir.nasim.C9429Zw7;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.P72;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0016\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001c\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006$²\u0006\u000e\u0010 \u001a\u00020\u001f8\n@\nX\u008a\u008e\u0002²\u0006\f\u0010\"\u001a\u00020!8\nX\u008a\u0084\u0002²\u0006\u000e\u0010#\u001a\u0004\u0018\u00010!8\nX\u008a\u0084\u0002"}, d2 = {"Lir/nasim/Zw7;", "Lir/nasim/ua0;", "<init>", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "Lir/nasim/rB7;", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lir/nasim/Iz2;", "h1", "Lir/nasim/bW7;", "T9", "()Lir/nasim/Iz2;", "binding", "Lir/nasim/Gx7;", "i1", "Lir/nasim/Yu3;", "U9", "()Lir/nasim/Gx7;", "viewModel", "j1", "a", "", "openDialog", "", "emailState", "error", "settings_productionRelease"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.Zw7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C9429Zw7 extends YX2 {

    /* renamed from: h1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding = AbstractC6056Lz2.f(this, new c(), AbstractC20046rN7.c());

    /* renamed from: i1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;
    static final /* synthetic */ InterfaceC5239Im3[] k1 = {AbstractC10882cM5.i(new C25226zw5(C9429Zw7.class, "binding", "getBinding()Lir/nasim/settings/databinding/FragmentTwoStepVerificationBinding;", 0))};

    /* renamed from: j1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int l1 = 8;

    /* renamed from: ir.nasim.Zw7$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final C9429Zw7 a() {
            return new C9429Zw7();
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Zw7$b */
    static final class b implements InterfaceC14603iB2 {

        /* renamed from: ir.nasim.Zw7$b$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ C9429Zw7 a;

            /* renamed from: ir.nasim.Zw7$b$a$a, reason: collision with other inner class name */
            static final class C0821a implements InterfaceC16978mB2 {
                final /* synthetic */ C9429Zw7 a;
                final /* synthetic */ C8588Wp4 b;

                /* renamed from: ir.nasim.Zw7$b$a$a$a, reason: collision with other inner class name */
                static final class C0822a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                    int b;
                    final /* synthetic */ C9429Zw7 c;
                    final /* synthetic */ C8588Wp4 d;

                    /* renamed from: ir.nasim.Zw7$b$a$a$a$a, reason: collision with other inner class name */
                    static final class C0823a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                        int b;
                        /* synthetic */ Object c;
                        final /* synthetic */ C9429Zw7 d;
                        final /* synthetic */ C8588Wp4 e;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C0823a(C9429Zw7 c9429Zw7, C8588Wp4 c8588Wp4, InterfaceC20295rm1 interfaceC20295rm1) {
                            super(2, interfaceC20295rm1);
                            this.d = c9429Zw7;
                            this.e = c8588Wp4;
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public static final C19938rB7 y(androidx.navigation.n nVar) {
                            androidx.navigation.n.e(nVar, 0, null, 2, null);
                            return C19938rB7.a;
                        }

                        @Override // ir.nasim.E90
                        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                            C0823a c0823a = new C0823a(this.d, this.e, interfaceC20295rm1);
                            c0823a.c = obj;
                            return c0823a;
                        }

                        @Override // ir.nasim.E90
                        public final Object invokeSuspend(Object obj) throws Resources.NotFoundException {
                            AbstractC14862ic3.e();
                            if (this.b != 0) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            AbstractC10685c16.b(obj);
                            if (((C17100mO7) this.c).e()) {
                                this.d.U9().k1();
                                this.e.R(AbstractC4625Fx7.c.a.a(), new UA2() { // from class: ir.nasim.gx7
                                    @Override // ir.nasim.UA2
                                    public final Object invoke(Object obj2) {
                                        return C9429Zw7.b.a.C0821a.C0822a.C0823a.y((androidx.navigation.n) obj2);
                                    }
                                });
                            }
                            return C19938rB7.a;
                        }

                        @Override // ir.nasim.InterfaceC14603iB2
                        /* renamed from: w, reason: merged with bridge method [inline-methods] */
                        public final Object invoke(C17100mO7 c17100mO7, InterfaceC20295rm1 interfaceC20295rm1) {
                            return ((C0823a) create(c17100mO7, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C0822a(C9429Zw7 c9429Zw7, C8588Wp4 c8588Wp4, InterfaceC20295rm1 interfaceC20295rm1) {
                        super(2, interfaceC20295rm1);
                        this.c = c9429Zw7;
                        this.d = c8588Wp4;
                    }

                    @Override // ir.nasim.E90
                    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                        return new C0822a(this.c, this.d, interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        Object objE = AbstractC14862ic3.e();
                        int i = this.b;
                        if (i == 0) {
                            AbstractC10685c16.b(obj);
                            InterfaceC10258bL6 interfaceC10258bL6D1 = this.c.U9().d1();
                            C0823a c0823a = new C0823a(this.c, this.d, null);
                            this.b = 1;
                            if (AbstractC6459Nq2.l(interfaceC10258bL6D1, c0823a, this) == objE) {
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
                        return ((C0822a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                    }
                }

                /* renamed from: ir.nasim.Zw7$b$a$a$b, reason: collision with other inner class name */
                /* synthetic */ class C0824b extends EB2 implements SA2 {
                    C0824b(Object obj) {
                        super(0, obj, FragmentActivity.class, "onBackPressed", "onBackPressed()V", 0);
                    }

                    @Override // ir.nasim.SA2
                    public /* bridge */ /* synthetic */ Object invoke() {
                        y();
                        return C19938rB7.a;
                    }

                    public final void y() {
                        ((FragmentActivity) this.receiver).onBackPressed();
                    }
                }

                /* renamed from: ir.nasim.Zw7$b$a$a$c */
                /* synthetic */ class c extends EB2 implements UA2 {
                    c(Object obj) {
                        super(1, obj, C4874Gx7.class, "updateTwoFAPassword", "updateTwoFAPassword(Ljava/lang/String;)V", 0);
                    }

                    @Override // ir.nasim.UA2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        y((String) obj);
                        return C19938rB7.a;
                    }

                    public final void y(String str) {
                        AbstractC13042fc3.i(str, "p0");
                        ((C4874Gx7) this.receiver).G1(str);
                    }
                }

                /* renamed from: ir.nasim.Zw7$b$a$a$d */
                /* synthetic */ class d extends EB2 implements UA2 {
                    d(Object obj) {
                        super(1, obj, C4874Gx7.class, "updateErrorTwoFAPassword", "updateErrorTwoFAPassword(Ljava/lang/String;)V", 0);
                    }

                    @Override // ir.nasim.UA2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        y((String) obj);
                        return C19938rB7.a;
                    }

                    public final void y(String str) {
                        AbstractC13042fc3.i(str, "p0");
                        ((C4874Gx7) this.receiver).z1(str);
                    }
                }

                C0821a(C9429Zw7 c9429Zw7, C8588Wp4 c8588Wp4) {
                    this.a = c9429Zw7;
                    this.b = c8588Wp4;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 d(C9429Zw7 c9429Zw7, String str) {
                    AbstractC13042fc3.i(c9429Zw7, "this$0");
                    AbstractC13042fc3.i(str, "it");
                    c9429Zw7.U9().J1(str);
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 f(C8588Wp4 c8588Wp4) throws Resources.NotFoundException {
                    AbstractC13042fc3.i(c8588Wp4, "$navController");
                    androidx.navigation.e.S(c8588Wp4, new AbstractC4625Fx7.e().a(), null, null, 6, null);
                    return C19938rB7.a;
                }

                public final void c(InterfaceC5757Ks interfaceC5757Ks, androidx.navigation.d dVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    AbstractC13042fc3.i(interfaceC5757Ks, "$this$composable");
                    AbstractC13042fc3.i(dVar, "it");
                    C19938rB7 c19938rB7 = C19938rB7.a;
                    interfaceC22053ub1.W(-1599398029);
                    boolean zD = interfaceC22053ub1.D(this.a) | interfaceC22053ub1.D(this.b);
                    C9429Zw7 c9429Zw7 = this.a;
                    C8588Wp4 c8588Wp4 = this.b;
                    Object objB = interfaceC22053ub1.B();
                    if (zD || objB == InterfaceC22053ub1.a.a()) {
                        objB = new C0822a(c9429Zw7, c8588Wp4, null);
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC10721c52.e(c19938rB7, (InterfaceC14603iB2) objB, interfaceC22053ub1, 6);
                    FragmentActivity fragmentActivityQ7 = this.a.Q7();
                    interfaceC22053ub1.W(-1599377410);
                    boolean zD2 = interfaceC22053ub1.D(fragmentActivityQ7);
                    Object objB2 = interfaceC22053ub1.B();
                    if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                        objB2 = new C0824b(fragmentActivityQ7);
                        interfaceC22053ub1.s(objB2);
                    }
                    InterfaceC16733lm3 interfaceC16733lm3 = (InterfaceC16733lm3) objB2;
                    interfaceC22053ub1.Q();
                    String strD = ((C17100mO7) AbstractC10222bH6.b(this.a.U9().d1(), null, interfaceC22053ub1, 0, 1).getValue()).d();
                    C4874Gx7 c4874Gx7U9 = this.a.U9();
                    interfaceC22053ub1.W(-1599370724);
                    boolean zD3 = interfaceC22053ub1.D(c4874Gx7U9);
                    Object objB3 = interfaceC22053ub1.B();
                    if (zD3 || objB3 == InterfaceC22053ub1.a.a()) {
                        objB3 = new c(c4874Gx7U9);
                        interfaceC22053ub1.s(objB3);
                    }
                    InterfaceC16733lm3 interfaceC16733lm32 = (InterfaceC16733lm3) objB3;
                    interfaceC22053ub1.Q();
                    String strC = ((C17100mO7) AbstractC10222bH6.b(this.a.U9().d1(), null, interfaceC22053ub1, 0, 1).getValue()).c();
                    C4874Gx7 c4874Gx7U92 = this.a.U9();
                    interfaceC22053ub1.W(-1599352511);
                    boolean zD4 = interfaceC22053ub1.D(c4874Gx7U92);
                    Object objB4 = interfaceC22053ub1.B();
                    if (zD4 || objB4 == InterfaceC22053ub1.a.a()) {
                        objB4 = new d(c4874Gx7U92);
                        interfaceC22053ub1.s(objB4);
                    }
                    InterfaceC16733lm3 interfaceC16733lm33 = (InterfaceC16733lm3) objB4;
                    interfaceC22053ub1.Q();
                    boolean zF = ((C17100mO7) AbstractC10222bH6.b(this.a.U9().d1(), null, interfaceC22053ub1, 0, 1).getValue()).f();
                    SA2 sa2 = (SA2) interfaceC16733lm3;
                    interfaceC22053ub1.W(-1599357492);
                    boolean zD5 = interfaceC22053ub1.D(this.a);
                    final C9429Zw7 c9429Zw72 = this.a;
                    Object objB5 = interfaceC22053ub1.B();
                    if (zD5 || objB5 == InterfaceC22053ub1.a.a()) {
                        objB5 = new UA2() { // from class: ir.nasim.ex7
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return C9429Zw7.b.a.C0821a.d(c9429Zw72, (String) obj);
                            }
                        };
                        interfaceC22053ub1.s(objB5);
                    }
                    UA2 ua2 = (UA2) objB5;
                    interfaceC22053ub1.Q();
                    UA2 ua22 = (UA2) interfaceC16733lm32;
                    interfaceC22053ub1.W(-1599364223);
                    boolean zD6 = interfaceC22053ub1.D(this.b);
                    final C8588Wp4 c8588Wp42 = this.b;
                    Object objB6 = interfaceC22053ub1.B();
                    if (zD6 || objB6 == InterfaceC22053ub1.a.a()) {
                        objB6 = new SA2() { // from class: ir.nasim.fx7
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return C9429Zw7.b.a.C0821a.f(c8588Wp42);
                            }
                        };
                        interfaceC22053ub1.s(objB6);
                    }
                    interfaceC22053ub1.Q();
                    M05.d(sa2, ua2, strD, ua22, strC, (SA2) objB6, (UA2) interfaceC16733lm33, zF, interfaceC22053ub1, 0, 0);
                }

                @Override // ir.nasim.InterfaceC16978mB2
                public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                    c((InterfaceC5757Ks) obj, (androidx.navigation.d) obj2, (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
                    return C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.Zw7$b$a$b, reason: collision with other inner class name */
            static final class C0825b implements InterfaceC16978mB2 {
                final /* synthetic */ C9429Zw7 a;
                final /* synthetic */ C8588Wp4 b;

                /* renamed from: ir.nasim.Zw7$b$a$b$a, reason: collision with other inner class name */
                /* synthetic */ class C0826a extends EB2 implements SA2 {
                    C0826a(Object obj) {
                        super(0, obj, FragmentActivity.class, "onBackPressed", "onBackPressed()V", 0);
                    }

                    @Override // ir.nasim.SA2
                    public /* bridge */ /* synthetic */ Object invoke() {
                        y();
                        return C19938rB7.a;
                    }

                    public final void y() {
                        ((FragmentActivity) this.receiver).onBackPressed();
                    }
                }

                C0825b(C9429Zw7 c9429Zw7, C8588Wp4 c8588Wp4) {
                    this.a = c9429Zw7;
                    this.b = c8588Wp4;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 i(C9429Zw7 c9429Zw7, final C8588Wp4 c8588Wp4) {
                    AbstractC13042fc3.i(c9429Zw7, "this$0");
                    AbstractC13042fc3.i(c8588Wp4, "$navController");
                    c9429Zw7.U9().Z0(new SA2() { // from class: ir.nasim.hx7
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C9429Zw7.b.a.C0825b.k(c8588Wp4);
                        }
                    }, new SA2() { // from class: ir.nasim.ix7
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C9429Zw7.b.a.C0825b.o(c8588Wp4);
                        }
                    });
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 k(C8588Wp4 c8588Wp4) throws Resources.NotFoundException {
                    AbstractC13042fc3.i(c8588Wp4, "$navController");
                    c8588Wp4.R(AbstractC4625Fx7.a.a.a(), new UA2() { // from class: ir.nasim.kx7
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return C9429Zw7.b.a.C0825b.n((androidx.navigation.n) obj);
                        }
                    });
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 n(androidx.navigation.n nVar) {
                    AbstractC13042fc3.i(nVar, "$this$navigate");
                    androidx.navigation.n.e(nVar, 0, null, 2, null);
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 o(C8588Wp4 c8588Wp4) throws Resources.NotFoundException {
                    AbstractC13042fc3.i(c8588Wp4, "$navController");
                    c8588Wp4.R(AbstractC4625Fx7.d.a.a(), new UA2() { // from class: ir.nasim.jx7
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return C9429Zw7.b.a.C0825b.p((androidx.navigation.n) obj);
                        }
                    });
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 p(androidx.navigation.n nVar) {
                    AbstractC13042fc3.i(nVar, "$this$navigate");
                    androidx.navigation.n.e(nVar, 0, null, 2, null);
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC16978mB2
                public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                    h((InterfaceC5757Ks) obj, (androidx.navigation.d) obj2, (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
                    return C19938rB7.a;
                }

                public final void h(InterfaceC5757Ks interfaceC5757Ks, androidx.navigation.d dVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    AbstractC13042fc3.i(interfaceC5757Ks, "$this$composable");
                    AbstractC13042fc3.i(dVar, "it");
                    FragmentActivity fragmentActivityQ7 = this.a.Q7();
                    interfaceC22053ub1.W(-1599339490);
                    boolean zD = interfaceC22053ub1.D(fragmentActivityQ7);
                    Object objB = interfaceC22053ub1.B();
                    if (zD || objB == InterfaceC22053ub1.a.a()) {
                        objB = new C0826a(fragmentActivityQ7);
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    SA2 sa2 = (SA2) ((InterfaceC16733lm3) objB);
                    interfaceC22053ub1.W(-1599335802);
                    boolean zD2 = interfaceC22053ub1.D(this.a) | interfaceC22053ub1.D(this.b);
                    final C9429Zw7 c9429Zw7 = this.a;
                    final C8588Wp4 c8588Wp4 = this.b;
                    Object objB2 = interfaceC22053ub1.B();
                    if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                        objB2 = new SA2() { // from class: ir.nasim.lx7
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return C9429Zw7.b.a.C0825b.i(c9429Zw7, c8588Wp4);
                            }
                        };
                        interfaceC22053ub1.s(objB2);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC6817Pc3.d(sa2, (SA2) objB2, interfaceC22053ub1, 0, 0);
                }
            }

            /* renamed from: ir.nasim.Zw7$b$a$c */
            static final class c implements InterfaceC16978mB2 {
                final /* synthetic */ C9429Zw7 a;
                final /* synthetic */ C8588Wp4 b;

                /* renamed from: ir.nasim.Zw7$b$a$c$a, reason: collision with other inner class name */
                /* synthetic */ class C0827a extends EB2 implements SA2 {
                    C0827a(Object obj) {
                        super(0, obj, FragmentActivity.class, "onBackPressed", "onBackPressed()V", 0);
                    }

                    @Override // ir.nasim.SA2
                    public /* bridge */ /* synthetic */ Object invoke() {
                        y();
                        return C19938rB7.a;
                    }

                    public final void y() {
                        ((FragmentActivity) this.receiver).onBackPressed();
                    }
                }

                c(C9429Zw7 c9429Zw7, C8588Wp4 c8588Wp4) {
                    this.a = c9429Zw7;
                    this.b = c8588Wp4;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 d(C9429Zw7 c9429Zw7, C8588Wp4 c8588Wp4) throws Resources.NotFoundException {
                    AbstractC13042fc3.i(c9429Zw7, "this$0");
                    AbstractC13042fc3.i(c8588Wp4, "$navController");
                    c9429Zw7.U9().o1();
                    c8588Wp4.R(AbstractC4625Fx7.f.a.a(), new UA2() { // from class: ir.nasim.mx7
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return C9429Zw7.b.a.c.f((androidx.navigation.n) obj);
                        }
                    });
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 f(androidx.navigation.n nVar) {
                    AbstractC13042fc3.i(nVar, "$this$navigate");
                    androidx.navigation.n.e(nVar, 0, null, 2, null);
                    return C19938rB7.a;
                }

                public final void c(InterfaceC5757Ks interfaceC5757Ks, androidx.navigation.d dVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    AbstractC13042fc3.i(interfaceC5757Ks, "$this$composable");
                    AbstractC13042fc3.i(dVar, "it");
                    FragmentActivity fragmentActivityQ7 = this.a.Q7();
                    interfaceC22053ub1.W(-1599301762);
                    boolean zD = interfaceC22053ub1.D(fragmentActivityQ7);
                    Object objB = interfaceC22053ub1.B();
                    if (zD || objB == InterfaceC22053ub1.a.a()) {
                        objB = new C0827a(fragmentActivityQ7);
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    SA2 sa2 = (SA2) ((InterfaceC16733lm3) objB);
                    interfaceC22053ub1.W(-1599299319);
                    boolean zD2 = interfaceC22053ub1.D(this.a) | interfaceC22053ub1.D(this.b);
                    final C9429Zw7 c9429Zw7 = this.a;
                    final C8588Wp4 c8588Wp4 = this.b;
                    Object objB2 = interfaceC22053ub1.B();
                    if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                        objB2 = new SA2() { // from class: ir.nasim.nx7
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return C9429Zw7.b.a.c.d(c9429Zw7, c8588Wp4);
                            }
                        };
                        interfaceC22053ub1.s(objB2);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC5451Jk.d(sa2, (SA2) objB2, interfaceC22053ub1, 0, 0);
                }

                @Override // ir.nasim.InterfaceC16978mB2
                public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                    c((InterfaceC5757Ks) obj, (androidx.navigation.d) obj2, (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
                    return C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.Zw7$b$a$d */
            static final class d implements InterfaceC16978mB2 {
                final /* synthetic */ C9429Zw7 a;
                final /* synthetic */ C8588Wp4 b;

                /* renamed from: ir.nasim.Zw7$b$a$d$a, reason: collision with other inner class name */
                /* synthetic */ class C0828a extends EB2 implements SA2 {
                    C0828a(Object obj) {
                        super(0, obj, FragmentActivity.class, "onBackPressed", "onBackPressed()V", 0);
                    }

                    @Override // ir.nasim.SA2
                    public /* bridge */ /* synthetic */ Object invoke() {
                        y();
                        return C19938rB7.a;
                    }

                    public final void y() {
                        ((FragmentActivity) this.receiver).onBackPressed();
                    }
                }

                /* renamed from: ir.nasim.Zw7$b$a$d$b, reason: collision with other inner class name */
                /* synthetic */ class C0829b extends EB2 implements UA2 {
                    C0829b(Object obj) {
                        super(1, obj, C4874Gx7.class, "updatePasswordError", "updatePasswordError(Ljava/lang/String;)V", 0);
                    }

                    @Override // ir.nasim.UA2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        y((String) obj);
                        return C19938rB7.a;
                    }

                    public final void y(String str) {
                        AbstractC13042fc3.i(str, "p0");
                        ((C4874Gx7) this.receiver).A1(str);
                    }
                }

                /* renamed from: ir.nasim.Zw7$b$a$d$c */
                /* synthetic */ class c extends EB2 implements UA2 {
                    c(Object obj) {
                        super(1, obj, C4874Gx7.class, "updatePasswordState", "updatePasswordState(Ljava/lang/String;)V", 0);
                    }

                    @Override // ir.nasim.UA2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        y((String) obj);
                        return C19938rB7.a;
                    }

                    public final void y(String str) {
                        AbstractC13042fc3.i(str, "p0");
                        ((C4874Gx7) this.receiver).B1(str);
                    }
                }

                d(C9429Zw7 c9429Zw7, C8588Wp4 c8588Wp4) {
                    this.a = c9429Zw7;
                    this.b = c8588Wp4;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 c(C8588Wp4 c8588Wp4) throws Resources.NotFoundException {
                    AbstractC13042fc3.i(c8588Wp4, "$navController");
                    androidx.navigation.e.S(c8588Wp4, AbstractC4625Fx7.b.a.a(), null, null, 6, null);
                    return C19938rB7.a;
                }

                public final void b(InterfaceC5757Ks interfaceC5757Ks, androidx.navigation.d dVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    AbstractC13042fc3.i(interfaceC5757Ks, "$this$composable");
                    AbstractC13042fc3.i(dVar, "it");
                    FragmentActivity fragmentActivityQ7 = this.a.Q7();
                    interfaceC22053ub1.W(-1599283106);
                    boolean zD = interfaceC22053ub1.D(fragmentActivityQ7);
                    Object objB = interfaceC22053ub1.B();
                    if (zD || objB == InterfaceC22053ub1.a.a()) {
                        objB = new C0828a(fragmentActivityQ7);
                        interfaceC22053ub1.s(objB);
                    }
                    InterfaceC16733lm3 interfaceC16733lm3 = (InterfaceC16733lm3) objB;
                    interfaceC22053ub1.Q();
                    String strC = ((A05) AbstractC10222bH6.b(this.a.U9().e1(), null, interfaceC22053ub1, 0, 1).getValue()).c();
                    String strD = ((A05) AbstractC10222bH6.b(this.a.U9().e1(), null, interfaceC22053ub1, 0, 1).getValue()).d();
                    C4874Gx7 c4874Gx7U9 = this.a.U9();
                    interfaceC22053ub1.W(-1599266948);
                    boolean zD2 = interfaceC22053ub1.D(c4874Gx7U9);
                    Object objB2 = interfaceC22053ub1.B();
                    if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                        objB2 = new C0829b(c4874Gx7U9);
                        interfaceC22053ub1.s(objB2);
                    }
                    InterfaceC16733lm3 interfaceC16733lm32 = (InterfaceC16733lm3) objB2;
                    interfaceC22053ub1.Q();
                    C4874Gx7 c4874Gx7U92 = this.a.U9();
                    interfaceC22053ub1.W(-1599264164);
                    boolean zD3 = interfaceC22053ub1.D(c4874Gx7U92);
                    Object objB3 = interfaceC22053ub1.B();
                    if (zD3 || objB3 == InterfaceC22053ub1.a.a()) {
                        objB3 = new c(c4874Gx7U92);
                        interfaceC22053ub1.s(objB3);
                    }
                    InterfaceC16733lm3 interfaceC16733lm33 = (InterfaceC16733lm3) objB3;
                    interfaceC22053ub1.Q();
                    SA2 sa2 = (SA2) interfaceC16733lm3;
                    interfaceC22053ub1.W(-1599280384);
                    boolean zD4 = interfaceC22053ub1.D(this.b);
                    final C8588Wp4 c8588Wp4 = this.b;
                    Object objB4 = interfaceC22053ub1.B();
                    if (zD4 || objB4 == InterfaceC22053ub1.a.a()) {
                        objB4 = new SA2() { // from class: ir.nasim.ox7
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return C9429Zw7.b.a.d.c(c8588Wp4);
                            }
                        };
                        interfaceC22053ub1.s(objB4);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC18589ou6.e(sa2, (SA2) objB4, strD, (UA2) interfaceC16733lm33, strC, (UA2) interfaceC16733lm32, false, null, interfaceC22053ub1, 0, 192);
                }

                @Override // ir.nasim.InterfaceC16978mB2
                public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                    b((InterfaceC5757Ks) obj, (androidx.navigation.d) obj2, (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
                    return C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.Zw7$b$a$e */
            static final class e implements InterfaceC16978mB2 {
                final /* synthetic */ C8588Wp4 a;
                final /* synthetic */ C9429Zw7 b;

                /* renamed from: ir.nasim.Zw7$b$a$e$a, reason: collision with other inner class name */
                /* synthetic */ class C0830a extends C23553x7 implements SA2 {
                    C0830a(Object obj) {
                        super(0, obj, C8588Wp4.class, "popBackStack", "popBackStack()Z", 8);
                    }

                    public final void a() {
                        ((C8588Wp4) this.a).V();
                    }

                    @Override // ir.nasim.SA2
                    public /* bridge */ /* synthetic */ Object invoke() {
                        a();
                        return C19938rB7.a;
                    }
                }

                /* renamed from: ir.nasim.Zw7$b$a$e$b, reason: collision with other inner class name */
                /* synthetic */ class C0831b extends EB2 implements UA2 {
                    C0831b(Object obj) {
                        super(1, obj, C4874Gx7.class, "updateConfirmPasswordState", "updateConfirmPasswordState(Ljava/lang/String;)V", 0);
                    }

                    @Override // ir.nasim.UA2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        y((String) obj);
                        return C19938rB7.a;
                    }

                    public final void y(String str) {
                        AbstractC13042fc3.i(str, "p0");
                        ((C4874Gx7) this.receiver).v1(str);
                    }
                }

                /* renamed from: ir.nasim.Zw7$b$a$e$c */
                /* synthetic */ class c extends EB2 implements UA2 {
                    c(Object obj) {
                        super(1, obj, C4874Gx7.class, "updateConfirmPasswordError", "updateConfirmPasswordError(Ljava/lang/String;)V", 0);
                    }

                    @Override // ir.nasim.UA2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        y((String) obj);
                        return C19938rB7.a;
                    }

                    public final void y(String str) {
                        AbstractC13042fc3.i(str, "p0");
                        ((C4874Gx7) this.receiver).u1(str);
                    }
                }

                e(C8588Wp4 c8588Wp4, C9429Zw7 c9429Zw7) {
                    this.a = c8588Wp4;
                    this.b = c9429Zw7;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 c(C8588Wp4 c8588Wp4) throws Resources.NotFoundException {
                    AbstractC13042fc3.i(c8588Wp4, "$navController");
                    androidx.navigation.e.S(c8588Wp4, AbstractC4625Fx7.g.a.a(), null, null, 6, null);
                    return C19938rB7.a;
                }

                public final void b(InterfaceC5757Ks interfaceC5757Ks, androidx.navigation.d dVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    AbstractC13042fc3.i(interfaceC5757Ks, "$this$composable");
                    AbstractC13042fc3.i(dVar, "it");
                    C8588Wp4 c8588Wp4 = this.a;
                    interfaceC22053ub1.W(-1599255047);
                    boolean zD = interfaceC22053ub1.D(c8588Wp4);
                    Object objB = interfaceC22053ub1.B();
                    if (zD || objB == InterfaceC22053ub1.a.a()) {
                        objB = new C0830a(c8588Wp4);
                        interfaceC22053ub1.s(objB);
                    }
                    SA2 sa2 = (SA2) objB;
                    interfaceC22053ub1.Q();
                    String strD = ((A05) AbstractC10222bH6.b(this.b.U9().b1(), null, interfaceC22053ub1, 0, 1).getValue()).d();
                    String strC = ((A05) AbstractC10222bH6.b(this.b.U9().b1(), null, interfaceC22053ub1, 0, 1).getValue()).c();
                    C4874Gx7 c4874Gx7U9 = this.b.U9();
                    interfaceC22053ub1.W(-1599238269);
                    boolean zD2 = interfaceC22053ub1.D(c4874Gx7U9);
                    Object objB2 = interfaceC22053ub1.B();
                    if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                        objB2 = new C0831b(c4874Gx7U9);
                        interfaceC22053ub1.s(objB2);
                    }
                    InterfaceC16733lm3 interfaceC16733lm3 = (InterfaceC16733lm3) objB2;
                    interfaceC22053ub1.Q();
                    C4874Gx7 c4874Gx7U92 = this.b.U9();
                    interfaceC22053ub1.W(-1599235549);
                    boolean zD3 = interfaceC22053ub1.D(c4874Gx7U92);
                    Object objB3 = interfaceC22053ub1.B();
                    if (zD3 || objB3 == InterfaceC22053ub1.a.a()) {
                        objB3 = new c(c4874Gx7U92);
                        interfaceC22053ub1.s(objB3);
                    }
                    InterfaceC16733lm3 interfaceC16733lm32 = (InterfaceC16733lm3) objB3;
                    interfaceC22053ub1.Q();
                    String strD2 = ((A05) AbstractC10222bH6.b(this.b.U9().e1(), null, interfaceC22053ub1, 0, 1).getValue()).d();
                    interfaceC22053ub1.W(-1599252479);
                    boolean zD4 = interfaceC22053ub1.D(this.a);
                    final C8588Wp4 c8588Wp42 = this.a;
                    Object objB4 = interfaceC22053ub1.B();
                    if (zD4 || objB4 == InterfaceC22053ub1.a.a()) {
                        objB4 = new SA2() { // from class: ir.nasim.px7
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return C9429Zw7.b.a.e.c(c8588Wp42);
                            }
                        };
                        interfaceC22053ub1.s(objB4);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC18589ou6.e(sa2, (SA2) objB4, strD, (UA2) interfaceC16733lm3, strC, (UA2) interfaceC16733lm32, true, strD2, interfaceC22053ub1, 1572864, 0);
                }

                @Override // ir.nasim.InterfaceC16978mB2
                public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                    b((InterfaceC5757Ks) obj, (androidx.navigation.d) obj2, (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
                    return C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.Zw7$b$a$f */
            static final class f implements InterfaceC16978mB2 {
                final /* synthetic */ C9429Zw7 a;
                final /* synthetic */ C8588Wp4 b;

                /* renamed from: ir.nasim.Zw7$b$a$f$a, reason: collision with other inner class name */
                static final class C0832a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                    int b;
                    final /* synthetic */ C9429Zw7 c;
                    final /* synthetic */ C8588Wp4 d;

                    /* renamed from: ir.nasim.Zw7$b$a$f$a$a, reason: collision with other inner class name */
                    static final class C0833a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                        int b;
                        /* synthetic */ Object c;
                        final /* synthetic */ C8588Wp4 d;
                        final /* synthetic */ C9429Zw7 e;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C0833a(C8588Wp4 c8588Wp4, C9429Zw7 c9429Zw7, InterfaceC20295rm1 interfaceC20295rm1) {
                            super(2, interfaceC20295rm1);
                            this.d = c8588Wp4;
                            this.e = c9429Zw7;
                        }

                        @Override // ir.nasim.E90
                        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                            C0833a c0833a = new C0833a(this.d, this.e, interfaceC20295rm1);
                            c0833a.c = obj;
                            return c0833a;
                        }

                        @Override // ir.nasim.E90
                        public final Object invokeSuspend(Object obj) throws Resources.NotFoundException {
                            AbstractC14862ic3.e();
                            if (this.b != 0) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            AbstractC10685c16.b(obj);
                            if (((N52) this.c).e()) {
                                androidx.navigation.e.S(this.d, AbstractC4625Fx7.h.a.a(), null, null, 6, null);
                                this.e.U9().k1();
                            }
                            return C19938rB7.a;
                        }

                        @Override // ir.nasim.InterfaceC14603iB2
                        /* renamed from: n, reason: merged with bridge method [inline-methods] */
                        public final Object invoke(N52 n52, InterfaceC20295rm1 interfaceC20295rm1) {
                            return ((C0833a) create(n52, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C0832a(C9429Zw7 c9429Zw7, C8588Wp4 c8588Wp4, InterfaceC20295rm1 interfaceC20295rm1) {
                        super(2, interfaceC20295rm1);
                        this.c = c9429Zw7;
                        this.d = c8588Wp4;
                    }

                    @Override // ir.nasim.E90
                    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                        return new C0832a(this.c, this.d, interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        Object objE = AbstractC14862ic3.e();
                        int i = this.b;
                        if (i == 0) {
                            AbstractC10685c16.b(obj);
                            InterfaceC10258bL6 interfaceC10258bL6G1 = this.c.U9().g1();
                            C0833a c0833a = new C0833a(this.d, this.c, null);
                            this.b = 1;
                            if (AbstractC6459Nq2.l(interfaceC10258bL6G1, c0833a, this) == objE) {
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
                        return ((C0832a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                    }
                }

                /* renamed from: ir.nasim.Zw7$b$a$f$b, reason: collision with other inner class name */
                /* synthetic */ class C0834b extends C23553x7 implements SA2 {
                    C0834b(Object obj) {
                        super(0, obj, C8588Wp4.class, "popBackStack", "popBackStack()Z", 8);
                    }

                    public final void a() {
                        ((C8588Wp4) this.a).V();
                    }

                    @Override // ir.nasim.SA2
                    public /* bridge */ /* synthetic */ Object invoke() {
                        a();
                        return C19938rB7.a;
                    }
                }

                /* renamed from: ir.nasim.Zw7$b$a$f$c */
                /* synthetic */ class c extends EB2 implements UA2 {
                    c(Object obj) {
                        super(1, obj, C4874Gx7.class, "updateConfirmEmailState", "updateConfirmEmailState(Ljava/lang/String;)V", 0);
                    }

                    @Override // ir.nasim.UA2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        y((String) obj);
                        return C19938rB7.a;
                    }

                    public final void y(String str) {
                        AbstractC13042fc3.i(str, "p0");
                        ((C4874Gx7) this.receiver).t1(str);
                    }
                }

                /* renamed from: ir.nasim.Zw7$b$a$f$d */
                /* synthetic */ class d extends EB2 implements UA2 {
                    d(Object obj) {
                        super(1, obj, C4874Gx7.class, "updateConfirmEmailError", "updateConfirmEmailError(Ljava/lang/String;)V", 0);
                    }

                    @Override // ir.nasim.UA2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        y((String) obj);
                        return C19938rB7.a;
                    }

                    public final void y(String str) {
                        AbstractC13042fc3.i(str, "p0");
                        ((C4874Gx7) this.receiver).s1(str);
                    }
                }

                /* renamed from: ir.nasim.Zw7$b$a$f$e */
                /* synthetic */ class e extends EB2 implements UA2 {
                    e(Object obj) {
                        super(1, obj, C4874Gx7.class, "isValidEmail", "isValidEmail(Ljava/lang/String;)Z", 0);
                    }

                    @Override // ir.nasim.UA2
                    /* renamed from: y, reason: merged with bridge method [inline-methods] */
                    public final Boolean invoke(String str) {
                        AbstractC13042fc3.i(str, "p0");
                        return Boolean.valueOf(((C4874Gx7) this.receiver).j1(str));
                    }
                }

                f(C9429Zw7 c9429Zw7, C8588Wp4 c8588Wp4) {
                    this.a = c9429Zw7;
                    this.b = c8588Wp4;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 c(C9429Zw7 c9429Zw7) {
                    AbstractC13042fc3.i(c9429Zw7, "this$0");
                    c9429Zw7.U9().a1();
                    return C19938rB7.a;
                }

                public final void b(InterfaceC5757Ks interfaceC5757Ks, androidx.navigation.d dVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    AbstractC13042fc3.i(interfaceC5757Ks, "$this$composable");
                    AbstractC13042fc3.i(dVar, "it");
                    C19938rB7 c19938rB7 = C19938rB7.a;
                    interfaceC22053ub1.W(-1599220693);
                    boolean zD = interfaceC22053ub1.D(this.a) | interfaceC22053ub1.D(this.b);
                    C9429Zw7 c9429Zw7 = this.a;
                    C8588Wp4 c8588Wp4 = this.b;
                    Object objB = interfaceC22053ub1.B();
                    if (zD || objB == InterfaceC22053ub1.a.a()) {
                        objB = new C0832a(c9429Zw7, c8588Wp4, null);
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC10721c52.e(c19938rB7, (InterfaceC14603iB2) objB, interfaceC22053ub1, 6);
                    C8588Wp4 c8588Wp42 = this.b;
                    interfaceC22053ub1.W(-1599203495);
                    boolean zD2 = interfaceC22053ub1.D(c8588Wp42);
                    Object objB2 = interfaceC22053ub1.B();
                    if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                        objB2 = new C0834b(c8588Wp42);
                        interfaceC22053ub1.s(objB2);
                    }
                    SA2 sa2 = (SA2) objB2;
                    interfaceC22053ub1.Q();
                    String strC = ((N52) AbstractC10222bH6.b(this.a.U9().g1(), null, interfaceC22053ub1, 0, 1).getValue()).c();
                    String strD = ((N52) AbstractC10222bH6.b(this.a.U9().g1(), null, interfaceC22053ub1, 0, 1).getValue()).d();
                    C4874Gx7 c4874Gx7U9 = this.a.U9();
                    interfaceC22053ub1.W(-1599189056);
                    boolean zD3 = interfaceC22053ub1.D(c4874Gx7U9);
                    Object objB3 = interfaceC22053ub1.B();
                    if (zD3 || objB3 == InterfaceC22053ub1.a.a()) {
                        objB3 = new c(c4874Gx7U9);
                        interfaceC22053ub1.s(objB3);
                    }
                    InterfaceC16733lm3 interfaceC16733lm3 = (InterfaceC16733lm3) objB3;
                    interfaceC22053ub1.Q();
                    C4874Gx7 c4874Gx7U92 = this.a.U9();
                    interfaceC22053ub1.W(-1599186432);
                    boolean zD4 = interfaceC22053ub1.D(c4874Gx7U92);
                    Object objB4 = interfaceC22053ub1.B();
                    if (zD4 || objB4 == InterfaceC22053ub1.a.a()) {
                        objB4 = new d(c4874Gx7U92);
                        interfaceC22053ub1.s(objB4);
                    }
                    InterfaceC16733lm3 interfaceC16733lm32 = (InterfaceC16733lm3) objB4;
                    interfaceC22053ub1.Q();
                    C4874Gx7 c4874Gx7U93 = this.a.U9();
                    interfaceC22053ub1.W(-1599183659);
                    boolean zD5 = interfaceC22053ub1.D(c4874Gx7U93);
                    Object objB5 = interfaceC22053ub1.B();
                    if (zD5 || objB5 == InterfaceC22053ub1.a.a()) {
                        objB5 = new e(c4874Gx7U93);
                        interfaceC22053ub1.s(objB5);
                    }
                    InterfaceC16733lm3 interfaceC16733lm33 = (InterfaceC16733lm3) objB5;
                    interfaceC22053ub1.Q();
                    boolean zF = ((N52) AbstractC10222bH6.b(this.a.U9().g1(), null, interfaceC22053ub1, 0, 1).getValue()).f();
                    interfaceC22053ub1.W(-1599200987);
                    boolean zD6 = interfaceC22053ub1.D(this.a);
                    final C9429Zw7 c9429Zw72 = this.a;
                    Object objB6 = interfaceC22053ub1.B();
                    if (zD6 || objB6 == InterfaceC22053ub1.a.a()) {
                        objB6 = new SA2() { // from class: ir.nasim.qx7
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return C9429Zw7.b.a.f.c(c9429Zw72);
                            }
                        };
                        interfaceC22053ub1.s(objB6);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC24269yK5.e(sa2, (SA2) objB6, strC, (UA2) interfaceC16733lm3, strD, (UA2) interfaceC16733lm32, (UA2) interfaceC16733lm33, zF, interfaceC22053ub1, 0, 0);
                }

                @Override // ir.nasim.InterfaceC16978mB2
                public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                    b((InterfaceC5757Ks) obj, (androidx.navigation.d) obj2, (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
                    return C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.Zw7$b$a$g */
            static final class g implements InterfaceC16978mB2 {
                final /* synthetic */ C9429Zw7 a;
                final /* synthetic */ C8588Wp4 b;

                /* renamed from: ir.nasim.Zw7$b$a$g$a, reason: collision with other inner class name */
                static final class C0835a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                    int b;
                    final /* synthetic */ C9429Zw7 c;
                    final /* synthetic */ InterfaceC9102Ym4 d;

                    /* renamed from: ir.nasim.Zw7$b$a$g$a$a, reason: collision with other inner class name */
                    static final class C0836a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                        int b;
                        /* synthetic */ Object c;
                        final /* synthetic */ C9429Zw7 d;
                        final /* synthetic */ InterfaceC9102Ym4 e;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C0836a(C9429Zw7 c9429Zw7, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC20295rm1 interfaceC20295rm1) {
                            super(2, interfaceC20295rm1);
                            this.d = c9429Zw7;
                            this.e = interfaceC9102Ym4;
                        }

                        @Override // ir.nasim.E90
                        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                            C0836a c0836a = new C0836a(this.d, this.e, interfaceC20295rm1);
                            c0836a.c = obj;
                            return c0836a;
                        }

                        @Override // ir.nasim.E90
                        public final Object invokeSuspend(Object obj) {
                            AbstractC14862ic3.e();
                            if (this.b != 0) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            AbstractC10685c16.b(obj);
                            if (((C10902cO7) this.c).f()) {
                                g.w(this.e, true);
                                this.d.U9().k1();
                            }
                            return C19938rB7.a;
                        }

                        @Override // ir.nasim.InterfaceC14603iB2
                        /* renamed from: n, reason: merged with bridge method [inline-methods] */
                        public final Object invoke(C10902cO7 c10902cO7, InterfaceC20295rm1 interfaceC20295rm1) {
                            return ((C0836a) create(c10902cO7, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C0835a(C9429Zw7 c9429Zw7, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC20295rm1 interfaceC20295rm1) {
                        super(2, interfaceC20295rm1);
                        this.c = c9429Zw7;
                        this.d = interfaceC9102Ym4;
                    }

                    @Override // ir.nasim.E90
                    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                        return new C0835a(this.c, this.d, interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        Object objE = AbstractC14862ic3.e();
                        int i = this.b;
                        if (i == 0) {
                            AbstractC10685c16.b(obj);
                            InterfaceC10258bL6 interfaceC10258bL6H1 = this.c.U9().h1();
                            C0836a c0836a = new C0836a(this.c, this.d, null);
                            this.b = 1;
                            if (AbstractC6459Nq2.l(interfaceC10258bL6H1, c0836a, this) == objE) {
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
                        return ((C0835a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                    }
                }

                /* renamed from: ir.nasim.Zw7$b$a$g$b, reason: collision with other inner class name */
                /* synthetic */ class C0837b extends C23553x7 implements SA2 {
                    C0837b(Object obj) {
                        super(0, obj, C8588Wp4.class, "popBackStack", "popBackStack()Z", 8);
                    }

                    public final void a() {
                        ((C8588Wp4) this.a).V();
                    }

                    @Override // ir.nasim.SA2
                    public /* bridge */ /* synthetic */ Object invoke() {
                        a();
                        return C19938rB7.a;
                    }
                }

                /* renamed from: ir.nasim.Zw7$b$a$g$c */
                /* synthetic */ class c extends EB2 implements UA2 {
                    c(Object obj) {
                        super(1, obj, C4874Gx7.class, "updateValidateEmailState", "updateValidateEmailState(Ljava/lang/String;)V", 0);
                    }

                    @Override // ir.nasim.UA2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        y((String) obj);
                        return C19938rB7.a;
                    }

                    public final void y(String str) {
                        AbstractC13042fc3.i(str, "p0");
                        ((C4874Gx7) this.receiver).I1(str);
                    }
                }

                /* renamed from: ir.nasim.Zw7$b$a$g$d */
                /* synthetic */ class d extends EB2 implements UA2 {
                    d(Object obj) {
                        super(1, obj, C4874Gx7.class, "updateValidateEmailError", "updateValidateEmailError(Ljava/lang/String;)V", 0);
                    }

                    @Override // ir.nasim.UA2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        y((String) obj);
                        return C19938rB7.a;
                    }

                    public final void y(String str) {
                        AbstractC13042fc3.i(str, "p0");
                        ((C4874Gx7) this.receiver).H1(str);
                    }
                }

                /* renamed from: ir.nasim.Zw7$b$a$g$e */
                /* synthetic */ class e extends C23553x7 implements SA2 {
                    e(Object obj) {
                        super(0, obj, C4874Gx7.class, "requestTwoFARecoveryPassword", "requestTwoFARecoveryPassword()Lkotlinx/coroutines/Job;", 8);
                    }

                    public final void a() {
                        ((C4874Gx7) this.a).m1();
                    }

                    @Override // ir.nasim.SA2
                    public /* bridge */ /* synthetic */ Object invoke() {
                        a();
                        return C19938rB7.a;
                    }
                }

                /* renamed from: ir.nasim.Zw7$b$a$g$f */
                /* synthetic */ class f extends EB2 implements SA2 {
                    f(Object obj) {
                        super(0, obj, C4874Gx7.class, "updateSetTwoFAEmailCodeCountDown", "updateSetTwoFAEmailCodeCountDown()V", 0);
                    }

                    @Override // ir.nasim.SA2
                    public /* bridge */ /* synthetic */ Object invoke() {
                        y();
                        return C19938rB7.a;
                    }

                    public final void y() {
                        ((C4874Gx7) this.receiver).F1();
                    }
                }

                g(C9429Zw7 c9429Zw7, C8588Wp4 c8588Wp4) {
                    this.a = c9429Zw7;
                    this.b = c8588Wp4;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final InterfaceC9102Ym4 k() {
                    return AbstractC13472gH6.d(Boolean.FALSE, null, 2, null);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 n(C9429Zw7 c9429Zw7, String str) {
                    AbstractC13042fc3.i(c9429Zw7, "this$0");
                    AbstractC13042fc3.i(str, "it");
                    c9429Zw7.U9().K1(AbstractC20762sZ6.n1(str).toString());
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 o(InterfaceC9102Ym4 interfaceC9102Ym4) {
                    AbstractC13042fc3.i(interfaceC9102Ym4, "$openDialog$delegate");
                    w(interfaceC9102Ym4, false);
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 p(C8588Wp4 c8588Wp4) throws Resources.NotFoundException {
                    AbstractC13042fc3.i(c8588Wp4, "$navController");
                    c8588Wp4.R(AbstractC4625Fx7.c.a.a(), new UA2() { // from class: ir.nasim.rx7
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return C9429Zw7.b.a.g.t((androidx.navigation.n) obj);
                        }
                    });
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 t(androidx.navigation.n nVar) {
                    AbstractC13042fc3.i(nVar, "$this$navigate");
                    androidx.navigation.n.e(nVar, 0, null, 2, null);
                    return C19938rB7.a;
                }

                private static final boolean v(InterfaceC9102Ym4 interfaceC9102Ym4) {
                    return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final void w(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
                    interfaceC9102Ym4.setValue(Boolean.valueOf(z));
                }

                @Override // ir.nasim.InterfaceC16978mB2
                public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                    i((InterfaceC5757Ks) obj, (androidx.navigation.d) obj2, (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
                    return C19938rB7.a;
                }

                public final void i(InterfaceC5757Ks interfaceC5757Ks, androidx.navigation.d dVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    AbstractC13042fc3.i(interfaceC5757Ks, "$this$composable");
                    AbstractC13042fc3.i(dVar, "it");
                    Object[] objArr = new Object[0];
                    interfaceC22053ub1.W(-1599171721);
                    Object objB = interfaceC22053ub1.B();
                    InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
                    if (objB == aVar.a()) {
                        objB = new SA2() { // from class: ir.nasim.sx7
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return C9429Zw7.b.a.g.k();
                            }
                        };
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    final InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) AbstractC9681aN5.e(objArr, null, null, (SA2) objB, interfaceC22053ub1, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 6);
                    C19938rB7 c19938rB7 = C19938rB7.a;
                    interfaceC22053ub1.W(-1599168820);
                    boolean zD = interfaceC22053ub1.D(this.a) | interfaceC22053ub1.V(interfaceC9102Ym4);
                    C9429Zw7 c9429Zw7 = this.a;
                    Object objB2 = interfaceC22053ub1.B();
                    if (zD || objB2 == aVar.a()) {
                        objB2 = new C0835a(c9429Zw7, interfaceC9102Ym4, null);
                        interfaceC22053ub1.s(objB2);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC10721c52.e(c19938rB7, (InterfaceC14603iB2) objB2, interfaceC22053ub1, 6);
                    Object obj = this.b;
                    interfaceC22053ub1.W(-1599153575);
                    boolean zD2 = interfaceC22053ub1.D(obj);
                    Object objB3 = interfaceC22053ub1.B();
                    if (zD2 || objB3 == aVar.a()) {
                        objB3 = new C0837b(obj);
                        interfaceC22053ub1.s(objB3);
                    }
                    SA2 sa2 = (SA2) objB3;
                    interfaceC22053ub1.Q();
                    String strC = ((N52) AbstractC10222bH6.b(this.a.U9().g1(), null, interfaceC22053ub1, 0, 1).getValue()).c();
                    String strC2 = ((C10902cO7) AbstractC10222bH6.b(this.a.U9().h1(), null, interfaceC22053ub1, 0, 1).getValue()).c();
                    String strD = ((C10902cO7) AbstractC10222bH6.b(this.a.U9().h1(), null, interfaceC22053ub1, 0, 1).getValue()).d();
                    Object objU9 = this.a.U9();
                    interfaceC22053ub1.W(-1599135231);
                    boolean zD3 = interfaceC22053ub1.D(objU9);
                    Object objB4 = interfaceC22053ub1.B();
                    if (zD3 || objB4 == aVar.a()) {
                        objB4 = new c(objU9);
                        interfaceC22053ub1.s(objB4);
                    }
                    InterfaceC16733lm3 interfaceC16733lm3 = (InterfaceC16733lm3) objB4;
                    interfaceC22053ub1.Q();
                    Object objU92 = this.a.U9();
                    interfaceC22053ub1.W(-1599132575);
                    boolean zD4 = interfaceC22053ub1.D(objU92);
                    Object objB5 = interfaceC22053ub1.B();
                    if (zD4 || objB5 == aVar.a()) {
                        objB5 = new d(objU92);
                        interfaceC22053ub1.s(objB5);
                    }
                    InterfaceC16733lm3 interfaceC16733lm32 = (InterfaceC16733lm3) objB5;
                    interfaceC22053ub1.Q();
                    boolean zG = ((C10902cO7) AbstractC10222bH6.b(this.a.U9().h1(), null, interfaceC22053ub1, 0, 1).getValue()).g();
                    boolean zV = v(interfaceC9102Ym4);
                    Object objU93 = this.a.U9();
                    interfaceC22053ub1.W(-1599111323);
                    boolean zD5 = interfaceC22053ub1.D(objU93);
                    Object objB6 = interfaceC22053ub1.B();
                    if (zD5 || objB6 == aVar.a()) {
                        objB6 = new e(objU93);
                        interfaceC22053ub1.s(objB6);
                    }
                    SA2 sa22 = (SA2) objB6;
                    interfaceC22053ub1.Q();
                    int iE = ((C10902cO7) AbstractC10222bH6.b(this.a.U9().h1(), null, interfaceC22053ub1, 0, 1).getValue()).e();
                    Object objU94 = this.a.U9();
                    interfaceC22053ub1.W(-1599104439);
                    boolean zD6 = interfaceC22053ub1.D(objU94);
                    Object objB7 = interfaceC22053ub1.B();
                    if (zD6 || objB7 == aVar.a()) {
                        objB7 = new f(objU94);
                        interfaceC22053ub1.s(objB7);
                    }
                    InterfaceC16733lm3 interfaceC16733lm33 = (InterfaceC16733lm3) objB7;
                    interfaceC22053ub1.Q();
                    interfaceC22053ub1.W(-1599151051);
                    boolean zD7 = interfaceC22053ub1.D(this.a);
                    final C9429Zw7 c9429Zw72 = this.a;
                    Object objB8 = interfaceC22053ub1.B();
                    if (zD7 || objB8 == aVar.a()) {
                        objB8 = new UA2() { // from class: ir.nasim.tx7
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj2) {
                                return C9429Zw7.b.a.g.n(c9429Zw72, (String) obj2);
                            }
                        };
                        interfaceC22053ub1.s(objB8);
                    }
                    UA2 ua2 = (UA2) objB8;
                    interfaceC22053ub1.Q();
                    UA2 ua22 = (UA2) interfaceC16733lm3;
                    UA2 ua23 = (UA2) interfaceC16733lm32;
                    interfaceC22053ub1.W(-1599113740);
                    boolean zV2 = interfaceC22053ub1.V(interfaceC9102Ym4);
                    Object objB9 = interfaceC22053ub1.B();
                    if (zV2 || objB9 == aVar.a()) {
                        objB9 = new SA2() { // from class: ir.nasim.ux7
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return C9429Zw7.b.a.g.o(interfaceC9102Ym4);
                            }
                        };
                        interfaceC22053ub1.s(objB9);
                    }
                    SA2 sa23 = (SA2) objB9;
                    interfaceC22053ub1.Q();
                    interfaceC22053ub1.W(-1599123559);
                    boolean zD8 = interfaceC22053ub1.D(this.b);
                    final C8588Wp4 c8588Wp4 = this.b;
                    Object objB10 = interfaceC22053ub1.B();
                    if (zD8 || objB10 == aVar.a()) {
                        objB10 = new SA2() { // from class: ir.nasim.vx7
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return C9429Zw7.b.a.g.p(c8588Wp4);
                            }
                        };
                        interfaceC22053ub1.s(objB10);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC13536gO7.d(sa2, ua2, strC, strC2, ua22, strD, ua23, zV, sa23, (SA2) objB10, zG, iE, (SA2) interfaceC16733lm33, sa22, interfaceC22053ub1, 0, 0, 0);
                }
            }

            /* renamed from: ir.nasim.Zw7$b$a$h */
            static final class h implements InterfaceC16978mB2 {
                final /* synthetic */ C9429Zw7 a;
                final /* synthetic */ C8588Wp4 b;

                /* renamed from: ir.nasim.Zw7$b$a$h$a, reason: collision with other inner class name */
                static final class C0838a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                    int b;
                    final /* synthetic */ C9429Zw7 c;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C0838a(C9429Zw7 c9429Zw7, InterfaceC20295rm1 interfaceC20295rm1) {
                        super(2, interfaceC20295rm1);
                        this.c = c9429Zw7;
                    }

                    @Override // ir.nasim.E90
                    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                        return new C0838a(this.c, interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        AbstractC14862ic3.e();
                        if (this.b != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                        this.c.U9().l1();
                        return C19938rB7.a;
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    /* renamed from: n, reason: merged with bridge method [inline-methods] */
                    public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                        return ((C0838a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                    }
                }

                /* renamed from: ir.nasim.Zw7$b$a$h$b, reason: collision with other inner class name */
                /* synthetic */ class C0839b extends C23553x7 implements SA2 {
                    C0839b(Object obj) {
                        super(0, obj, C8588Wp4.class, "popBackStack", "popBackStack()Z", 8);
                    }

                    public final void a() {
                        ((C8588Wp4) this.a).V();
                    }

                    @Override // ir.nasim.SA2
                    public /* bridge */ /* synthetic */ Object invoke() {
                        a();
                        return C19938rB7.a;
                    }
                }

                /* renamed from: ir.nasim.Zw7$b$a$h$c */
                /* synthetic */ class c extends EB2 implements UA2 {
                    c(Object obj) {
                        super(1, obj, C4874Gx7.class, "updateRecoverPasswordError", "updateRecoverPasswordError(Ljava/lang/String;)V", 0);
                    }

                    @Override // ir.nasim.UA2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        y((String) obj);
                        return C19938rB7.a;
                    }

                    public final void y(String str) {
                        AbstractC13042fc3.i(str, "p0");
                        ((C4874Gx7) this.receiver).C1(str);
                    }
                }

                /* renamed from: ir.nasim.Zw7$b$a$h$d */
                /* synthetic */ class d extends C23553x7 implements SA2 {
                    d(Object obj) {
                        super(0, obj, C4874Gx7.class, "requestRecoveryPassword", "requestRecoveryPassword()Lkotlinx/coroutines/Job;", 8);
                    }

                    public final void a() {
                        ((C4874Gx7) this.a).l1();
                    }

                    @Override // ir.nasim.SA2
                    public /* bridge */ /* synthetic */ Object invoke() {
                        a();
                        return C19938rB7.a;
                    }
                }

                /* renamed from: ir.nasim.Zw7$b$a$h$e */
                /* synthetic */ class e extends EB2 implements SA2 {
                    e(Object obj) {
                        super(0, obj, C4874Gx7.class, "updateEmailCodeCountDown", "updateEmailCodeCountDown()V", 0);
                    }

                    @Override // ir.nasim.SA2
                    public /* bridge */ /* synthetic */ Object invoke() {
                        y();
                        return C19938rB7.a;
                    }

                    public final void y() {
                        ((C4874Gx7) this.receiver).y1();
                    }
                }

                /* renamed from: ir.nasim.Zw7$b$a$h$f */
                static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
                    int b;
                    /* synthetic */ Object c;

                    f(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(2, interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                        f fVar = new f(interfaceC20295rm1);
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
                        return ((C12880fK5) this.c).f();
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    /* renamed from: n, reason: merged with bridge method [inline-methods] */
                    public final Object invoke(C12880fK5 c12880fK5, InterfaceC20295rm1 interfaceC20295rm1) {
                        return ((f) create(c12880fK5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                    }
                }

                /* renamed from: ir.nasim.Zw7$b$a$h$g */
                public static final class g implements InterfaceC4557Fq2 {
                    final /* synthetic */ InterfaceC4557Fq2 a;

                    /* renamed from: ir.nasim.Zw7$b$a$h$g$a, reason: collision with other inner class name */
                    public static final class C0840a implements InterfaceC4806Gq2 {
                        final /* synthetic */ InterfaceC4806Gq2 a;

                        /* renamed from: ir.nasim.Zw7$b$a$h$g$a$a, reason: collision with other inner class name */
                        public static final class C0841a extends AbstractC22163um1 {
                            /* synthetic */ Object a;
                            int b;

                            public C0841a(InterfaceC20295rm1 interfaceC20295rm1) {
                                super(interfaceC20295rm1);
                            }

                            @Override // ir.nasim.E90
                            public final Object invokeSuspend(Object obj) {
                                this.a = obj;
                                this.b |= RecyclerView.UNDEFINED_DURATION;
                                return C0840a.this.a(null, this);
                            }
                        }

                        public C0840a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                            this.a = interfaceC4806Gq2;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                        @Override // ir.nasim.InterfaceC4806Gq2
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                            /*
                                r4 = this;
                                boolean r0 = r6 instanceof ir.nasim.C9429Zw7.b.a.h.g.C0840a.C0841a
                                if (r0 == 0) goto L13
                                r0 = r6
                                ir.nasim.Zw7$b$a$h$g$a$a r0 = (ir.nasim.C9429Zw7.b.a.h.g.C0840a.C0841a) r0
                                int r1 = r0.b
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.b = r1
                                goto L18
                            L13:
                                ir.nasim.Zw7$b$a$h$g$a$a r0 = new ir.nasim.Zw7$b$a$h$g$a$a
                                r0.<init>(r6)
                            L18:
                                java.lang.Object r6 = r0.a
                                java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                                int r2 = r0.b
                                r3 = 1
                                if (r2 == 0) goto L31
                                if (r2 != r3) goto L29
                                ir.nasim.AbstractC10685c16.b(r6)
                                goto L47
                            L29:
                                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                                r5.<init>(r6)
                                throw r5
                            L31:
                                ir.nasim.AbstractC10685c16.b(r6)
                                ir.nasim.Gq2 r6 = r4.a
                                ir.nasim.fK5 r5 = (ir.nasim.C12880fK5) r5
                                java.lang.String r5 = r5.e()
                                if (r5 == 0) goto L47
                                r0.b = r3
                                java.lang.Object r5 = r6.a(r5, r0)
                                if (r5 != r1) goto L47
                                return r1
                            L47:
                                ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                                return r5
                            */
                            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C9429Zw7.b.a.h.g.C0840a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                        }
                    }

                    public g(InterfaceC4557Fq2 interfaceC4557Fq2) {
                        this.a = interfaceC4557Fq2;
                    }

                    @Override // ir.nasim.InterfaceC4557Fq2
                    public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                        Object objB = this.a.b(new C0840a(interfaceC4806Gq2), interfaceC20295rm1);
                        return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
                    }
                }

                h(C9429Zw7 c9429Zw7, C8588Wp4 c8588Wp4) {
                    this.a = c9429Zw7;
                    this.b = c8588Wp4;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 h(C9429Zw7 c9429Zw7, final C8588Wp4 c8588Wp4, String str) {
                    AbstractC13042fc3.i(c9429Zw7, "this$0");
                    AbstractC13042fc3.i(c8588Wp4, "$navController");
                    AbstractC13042fc3.i(str, "it");
                    c9429Zw7.U9().q1(str, new SA2() { // from class: ir.nasim.wx7
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C9429Zw7.b.a.h.i(c8588Wp4);
                        }
                    });
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 i(C8588Wp4 c8588Wp4) throws Resources.NotFoundException {
                    AbstractC13042fc3.i(c8588Wp4, "$navController");
                    androidx.navigation.e.S(c8588Wp4, AbstractC4625Fx7.e.c.b.a(), null, null, 6, null);
                    return C19938rB7.a;
                }

                private static final String k(InterfaceC9664aL6 interfaceC9664aL6) {
                    return (String) interfaceC9664aL6.getValue();
                }

                private static final String n(InterfaceC9664aL6 interfaceC9664aL6) {
                    return (String) interfaceC9664aL6.getValue();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 o(C9429Zw7 c9429Zw7, final C8588Wp4 c8588Wp4, String str) {
                    AbstractC13042fc3.i(c9429Zw7, "this$0");
                    AbstractC13042fc3.i(c8588Wp4, "$navController");
                    AbstractC13042fc3.i(str, "it");
                    c9429Zw7.U9().L1(str, new SA2() { // from class: ir.nasim.xx7
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C9429Zw7.b.a.h.p(c8588Wp4);
                        }
                    });
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 p(C8588Wp4 c8588Wp4) throws Resources.NotFoundException {
                    AbstractC13042fc3.i(c8588Wp4, "$navController");
                    androidx.navigation.e.S(c8588Wp4, AbstractC4625Fx7.e.c.b.a(), null, null, 6, null);
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC16978mB2
                public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                    f((InterfaceC5757Ks) obj, (androidx.navigation.d) obj2, (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
                    return C19938rB7.a;
                }

                public final void f(InterfaceC5757Ks interfaceC5757Ks, androidx.navigation.d dVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    AbstractC13042fc3.i(interfaceC5757Ks, "$this$composable");
                    AbstractC13042fc3.i(dVar, "it");
                    C19938rB7 c19938rB7 = C19938rB7.a;
                    interfaceC22053ub1.W(1170999888);
                    boolean zD = interfaceC22053ub1.D(this.a);
                    C9429Zw7 c9429Zw7 = this.a;
                    Object objB = interfaceC22053ub1.B();
                    if (zD || objB == InterfaceC22053ub1.a.a()) {
                        objB = new C0838a(c9429Zw7, null);
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC10721c52.e(c19938rB7, (InterfaceC14603iB2) objB, interfaceC22053ub1, 6);
                    InterfaceC9664aL6 interfaceC9664aL6A = AbstractC10222bH6.a(new g(this.a.U9().f1()), "", null, interfaceC22053ub1, 48, 2);
                    InterfaceC10258bL6 interfaceC10258bL6F1 = this.a.U9().f1();
                    interfaceC22053ub1.W(1171010825);
                    Object objB2 = interfaceC22053ub1.B();
                    InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
                    if (objB2 == aVar.a()) {
                        objB2 = new f(null);
                        interfaceC22053ub1.s(objB2);
                    }
                    interfaceC22053ub1.Q();
                    InterfaceC9664aL6 interfaceC9664aL6A2 = AbstractC10222bH6.a(AbstractC6459Nq2.X(interfaceC10258bL6F1, (InterfaceC14603iB2) objB2), null, null, interfaceC22053ub1, 48, 2);
                    if (k(interfaceC9664aL6A).length() <= 0) {
                        interfaceC22053ub1.W(1943506840);
                        e.a aVar2 = androidx.compose.ui.e.a;
                        androidx.compose.ui.e eVarF = androidx.compose.foundation.layout.t.f(aVar2, 0.0f, 1, null);
                        InterfaceC12529em.a aVar3 = InterfaceC12529em.a;
                        InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar3.o(), false);
                        int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                        InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                        androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarF);
                        InterfaceC16030kb1.a aVar4 = InterfaceC16030kb1.d0;
                        SA2 sa2A = aVar4.a();
                        if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                            AbstractC6797Pa1.c();
                        }
                        interfaceC22053ub1.G();
                        if (interfaceC22053ub1.h()) {
                            interfaceC22053ub1.g(sa2A);
                        } else {
                            interfaceC22053ub1.r();
                        }
                        InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1);
                        DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar4.e());
                        DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar4.g());
                        InterfaceC14603iB2 interfaceC14603iB2B = aVar4.b();
                        if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                            interfaceC22053ub1A.s(Integer.valueOf(iA));
                            interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                        }
                        DG7.c(interfaceC22053ub1A, eVarE, aVar4.f());
                        AbstractC10628bv5.a(androidx.compose.foundation.layout.h.a.h(aVar2, aVar3.e()), G10.a.a(interfaceC22053ub1, G10.b).I(), 0.0f, 0L, 0, interfaceC22053ub1, 0, 28);
                        interfaceC22053ub1.u();
                        interfaceC22053ub1.Q();
                        return;
                    }
                    interfaceC22053ub1.W(1941761602);
                    C8588Wp4 c8588Wp4 = this.b;
                    interfaceC22053ub1.W(1171018200);
                    boolean zD2 = interfaceC22053ub1.D(c8588Wp4);
                    Object objB3 = interfaceC22053ub1.B();
                    if (zD2 || objB3 == aVar.a()) {
                        objB3 = new C0839b(c8588Wp4);
                        interfaceC22053ub1.s(objB3);
                    }
                    SA2 sa2 = (SA2) objB3;
                    interfaceC22053ub1.Q();
                    interfaceC22053ub1.W(1171021199);
                    boolean zD3 = interfaceC22053ub1.D(this.a) | interfaceC22053ub1.D(this.b);
                    final C9429Zw7 c9429Zw72 = this.a;
                    final C8588Wp4 c8588Wp42 = this.b;
                    Object objB4 = interfaceC22053ub1.B();
                    if (zD3 || objB4 == aVar.a()) {
                        objB4 = new UA2() { // from class: ir.nasim.yx7
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return C9429Zw7.b.a.h.o(c9429Zw72, c8588Wp42, (String) obj);
                            }
                        };
                        interfaceC22053ub1.s(objB4);
                    }
                    UA2 ua2 = (UA2) objB4;
                    interfaceC22053ub1.Q();
                    String strK = k(interfaceC9664aL6A);
                    String strC = ((C12880fK5) AbstractC10222bH6.b(this.a.U9().f1(), null, interfaceC22053ub1, 0, 1).getValue()).c();
                    interfaceC22053ub1.W(1171039574);
                    boolean zD4 = interfaceC22053ub1.D(this.a) | interfaceC22053ub1.D(this.b);
                    final C9429Zw7 c9429Zw73 = this.a;
                    final C8588Wp4 c8588Wp43 = this.b;
                    Object objB5 = interfaceC22053ub1.B();
                    if (zD4 || objB5 == aVar.a()) {
                        objB5 = new UA2() { // from class: ir.nasim.zx7
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return C9429Zw7.b.a.h.h(c9429Zw73, c8588Wp43, (String) obj);
                            }
                        };
                        interfaceC22053ub1.s(objB5);
                    }
                    UA2 ua22 = (UA2) objB5;
                    interfaceC22053ub1.Q();
                    String strN = n(interfaceC9664aL6A2);
                    C4874Gx7 c4874Gx7U9 = this.a.U9();
                    interfaceC22053ub1.W(1171053986);
                    boolean zD5 = interfaceC22053ub1.D(c4874Gx7U9);
                    Object objB6 = interfaceC22053ub1.B();
                    if (zD5 || objB6 == aVar.a()) {
                        objB6 = new c(c4874Gx7U9);
                        interfaceC22053ub1.s(objB6);
                    }
                    interfaceC22053ub1.Q();
                    UA2 ua23 = (UA2) ((InterfaceC16733lm3) objB6);
                    C4874Gx7 c4874Gx7U92 = this.a.U9();
                    interfaceC22053ub1.W(1171057119);
                    boolean zD6 = interfaceC22053ub1.D(c4874Gx7U92);
                    Object objB7 = interfaceC22053ub1.B();
                    if (zD6 || objB7 == aVar.a()) {
                        objB7 = new d(c4874Gx7U92);
                        interfaceC22053ub1.s(objB7);
                    }
                    SA2 sa22 = (SA2) objB7;
                    interfaceC22053ub1.Q();
                    int iH = ((C12880fK5) AbstractC10222bH6.b(this.a.U9().f1(), null, interfaceC22053ub1, 0, 1).getValue()).h();
                    C4874Gx7 c4874Gx7U93 = this.a.U9();
                    interfaceC22053ub1.W(1171064224);
                    boolean zD7 = interfaceC22053ub1.D(c4874Gx7U93);
                    Object objB8 = interfaceC22053ub1.B();
                    if (zD7 || objB8 == aVar.a()) {
                        objB8 = new e(c4874Gx7U93);
                        interfaceC22053ub1.s(objB8);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC15289jK5.d(sa2, ua2, strK, strC, ua22, strN, ua23, sa22, iH, (SA2) ((InterfaceC16733lm3) objB8), ((C12880fK5) AbstractC10222bH6.b(this.a.U9().f1(), null, interfaceC22053ub1, 0, 1).getValue()).i(), interfaceC22053ub1, 0, 0, 0);
                    interfaceC22053ub1.Q();
                }
            }

            /* renamed from: ir.nasim.Zw7$b$a$i */
            static final class i implements InterfaceC16978mB2 {
                final /* synthetic */ C8588Wp4 a;
                final /* synthetic */ C9429Zw7 b;

                /* renamed from: ir.nasim.Zw7$b$a$i$a, reason: collision with other inner class name */
                /* synthetic */ class C0842a extends C23553x7 implements SA2 {
                    C0842a(Object obj) {
                        super(0, obj, C8588Wp4.class, "popBackStack", "popBackStack()Z", 8);
                    }

                    public final void a() {
                        ((C8588Wp4) this.a).V();
                    }

                    @Override // ir.nasim.SA2
                    public /* bridge */ /* synthetic */ Object invoke() {
                        a();
                        return C19938rB7.a;
                    }
                }

                /* renamed from: ir.nasim.Zw7$b$a$i$b, reason: collision with other inner class name */
                /* synthetic */ class C0843b extends EB2 implements UA2 {
                    C0843b(Object obj) {
                        super(1, obj, C4874Gx7.class, "updateSetNewPassword", "updateSetNewPassword(Ljava/lang/String;)V", 0);
                    }

                    @Override // ir.nasim.UA2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        y((String) obj);
                        return C19938rB7.a;
                    }

                    public final void y(String str) {
                        AbstractC13042fc3.i(str, "p0");
                        ((C4874Gx7) this.receiver).D1(str);
                    }
                }

                /* renamed from: ir.nasim.Zw7$b$a$i$c */
                /* synthetic */ class c extends EB2 implements UA2 {
                    c(Object obj) {
                        super(1, obj, C4874Gx7.class, "updateSetNewPasswordError", "updateSetNewPasswordError(Ljava/lang/String;)V", 0);
                    }

                    @Override // ir.nasim.UA2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        y((String) obj);
                        return C19938rB7.a;
                    }

                    public final void y(String str) {
                        AbstractC13042fc3.i(str, "p0");
                        ((C4874Gx7) this.receiver).E1(str);
                    }
                }

                i(C8588Wp4 c8588Wp4, C9429Zw7 c9429Zw7) {
                    this.a = c8588Wp4;
                    this.b = c9429Zw7;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 c(C8588Wp4 c8588Wp4) throws Resources.NotFoundException {
                    AbstractC13042fc3.i(c8588Wp4, "$navController");
                    androidx.navigation.e.S(c8588Wp4, AbstractC4625Fx7.e.a.b.a(), null, null, 6, null);
                    return C19938rB7.a;
                }

                public final void b(InterfaceC5757Ks interfaceC5757Ks, androidx.navigation.d dVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    AbstractC13042fc3.i(interfaceC5757Ks, "$this$composable");
                    AbstractC13042fc3.i(dVar, "it");
                    C8588Wp4 c8588Wp4 = this.a;
                    interfaceC22053ub1.W(1171094936);
                    boolean zD = interfaceC22053ub1.D(c8588Wp4);
                    Object objB = interfaceC22053ub1.B();
                    if (zD || objB == InterfaceC22053ub1.a.a()) {
                        objB = new C0842a(c8588Wp4);
                        interfaceC22053ub1.s(objB);
                    }
                    SA2 sa2 = (SA2) objB;
                    interfaceC22053ub1.Q();
                    String strD = ((C12880fK5) AbstractC10222bH6.b(this.b.U9().f1(), null, interfaceC22053ub1, 0, 1).getValue()).g().d();
                    String strC = ((C12880fK5) AbstractC10222bH6.b(this.b.U9().f1(), null, interfaceC22053ub1, 0, 1).getValue()).g().c();
                    C4874Gx7 c4874Gx7U9 = this.b.U9();
                    interfaceC22053ub1.W(1171114012);
                    boolean zD2 = interfaceC22053ub1.D(c4874Gx7U9);
                    Object objB2 = interfaceC22053ub1.B();
                    if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                        objB2 = new C0843b(c4874Gx7U9);
                        interfaceC22053ub1.s(objB2);
                    }
                    InterfaceC16733lm3 interfaceC16733lm3 = (InterfaceC16733lm3) objB2;
                    interfaceC22053ub1.Q();
                    C4874Gx7 c4874Gx7U92 = this.b.U9();
                    interfaceC22053ub1.W(1171116673);
                    boolean zD3 = interfaceC22053ub1.D(c4874Gx7U92);
                    Object objB3 = interfaceC22053ub1.B();
                    if (zD3 || objB3 == InterfaceC22053ub1.a.a()) {
                        objB3 = new c(c4874Gx7U92);
                        interfaceC22053ub1.s(objB3);
                    }
                    InterfaceC16733lm3 interfaceC16733lm32 = (InterfaceC16733lm3) objB3;
                    interfaceC22053ub1.Q();
                    interfaceC22053ub1.W(1171097666);
                    boolean zD4 = interfaceC22053ub1.D(this.a);
                    final C8588Wp4 c8588Wp42 = this.a;
                    Object objB4 = interfaceC22053ub1.B();
                    if (zD4 || objB4 == InterfaceC22053ub1.a.a()) {
                        objB4 = new SA2() { // from class: ir.nasim.Ax7
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return C9429Zw7.b.a.i.c(c8588Wp42);
                            }
                        };
                        interfaceC22053ub1.s(objB4);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC18589ou6.e(sa2, (SA2) objB4, strD, (UA2) interfaceC16733lm3, strC, (UA2) interfaceC16733lm32, false, null, interfaceC22053ub1, 0, 192);
                }

                @Override // ir.nasim.InterfaceC16978mB2
                public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                    b((InterfaceC5757Ks) obj, (androidx.navigation.d) obj2, (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
                    return C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.Zw7$b$a$j */
            static final class j implements InterfaceC16978mB2 {
                final /* synthetic */ C8588Wp4 a;
                final /* synthetic */ C9429Zw7 b;

                /* renamed from: ir.nasim.Zw7$b$a$j$a, reason: collision with other inner class name */
                /* synthetic */ class C0844a extends C23553x7 implements SA2 {
                    C0844a(Object obj) {
                        super(0, obj, C8588Wp4.class, "popBackStack", "popBackStack()Z", 8);
                    }

                    public final void a() {
                        ((C8588Wp4) this.a).V();
                    }

                    @Override // ir.nasim.SA2
                    public /* bridge */ /* synthetic */ Object invoke() {
                        a();
                        return C19938rB7.a;
                    }
                }

                /* renamed from: ir.nasim.Zw7$b$a$j$b, reason: collision with other inner class name */
                /* synthetic */ class C0845b extends EB2 implements UA2 {
                    C0845b(Object obj) {
                        super(1, obj, C4874Gx7.class, "updateConfirmSetNewPassword", "updateConfirmSetNewPassword(Ljava/lang/String;)V", 0);
                    }

                    @Override // ir.nasim.UA2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        y((String) obj);
                        return C19938rB7.a;
                    }

                    public final void y(String str) {
                        AbstractC13042fc3.i(str, "p0");
                        ((C4874Gx7) this.receiver).w1(str);
                    }
                }

                /* renamed from: ir.nasim.Zw7$b$a$j$c */
                /* synthetic */ class c extends EB2 implements UA2 {
                    c(Object obj) {
                        super(1, obj, C4874Gx7.class, "updateConfirmSetNewPasswordError", "updateConfirmSetNewPasswordError(Ljava/lang/String;)V", 0);
                    }

                    @Override // ir.nasim.UA2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        y((String) obj);
                        return C19938rB7.a;
                    }

                    public final void y(String str) {
                        AbstractC13042fc3.i(str, "p0");
                        ((C4874Gx7) this.receiver).x1(str);
                    }
                }

                j(C8588Wp4 c8588Wp4, C9429Zw7 c9429Zw7) {
                    this.a = c8588Wp4;
                    this.b = c9429Zw7;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 f(C9429Zw7 c9429Zw7, final C8588Wp4 c8588Wp4) {
                    AbstractC13042fc3.i(c9429Zw7, "this$0");
                    AbstractC13042fc3.i(c8588Wp4, "$navController");
                    c9429Zw7.U9().p1(((C12880fK5) c9429Zw7.U9().f1().getValue()).d().d(), new SA2() { // from class: ir.nasim.Bx7
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C9429Zw7.b.a.j.h(c8588Wp4);
                        }
                    });
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 h(C8588Wp4 c8588Wp4) throws Resources.NotFoundException {
                    AbstractC13042fc3.i(c8588Wp4, "$navController");
                    c8588Wp4.R(AbstractC4625Fx7.c.a.a(), new UA2() { // from class: ir.nasim.Cx7
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return C9429Zw7.b.a.j.i((androidx.navigation.n) obj);
                        }
                    });
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 i(androidx.navigation.n nVar) {
                    AbstractC13042fc3.i(nVar, "$this$navigate");
                    androidx.navigation.n.e(nVar, 0, null, 2, null);
                    return C19938rB7.a;
                }

                public final void d(InterfaceC5757Ks interfaceC5757Ks, androidx.navigation.d dVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    AbstractC13042fc3.i(interfaceC5757Ks, "$this$composable");
                    AbstractC13042fc3.i(dVar, "it");
                    C8588Wp4 c8588Wp4 = this.a;
                    interfaceC22053ub1.W(1171127480);
                    boolean zD = interfaceC22053ub1.D(c8588Wp4);
                    Object objB = interfaceC22053ub1.B();
                    if (zD || objB == InterfaceC22053ub1.a.a()) {
                        objB = new C0844a(c8588Wp4);
                        interfaceC22053ub1.s(objB);
                    }
                    SA2 sa2 = (SA2) objB;
                    interfaceC22053ub1.Q();
                    String strD = ((C12880fK5) AbstractC10222bH6.b(this.b.U9().f1(), null, interfaceC22053ub1, 0, 1).getValue()).d().d();
                    String strC = ((C12880fK5) AbstractC10222bH6.b(this.b.U9().f1(), null, interfaceC22053ub1, 0, 1).getValue()).d().c();
                    C4874Gx7 c4874Gx7U9 = this.b.U9();
                    interfaceC22053ub1.W(1171155875);
                    boolean zD2 = interfaceC22053ub1.D(c4874Gx7U9);
                    Object objB2 = interfaceC22053ub1.B();
                    if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                        objB2 = new C0845b(c4874Gx7U9);
                        interfaceC22053ub1.s(objB2);
                    }
                    InterfaceC16733lm3 interfaceC16733lm3 = (InterfaceC16733lm3) objB2;
                    interfaceC22053ub1.Q();
                    C4874Gx7 c4874Gx7U92 = this.b.U9();
                    interfaceC22053ub1.W(1171158760);
                    boolean zD3 = interfaceC22053ub1.D(c4874Gx7U92);
                    Object objB3 = interfaceC22053ub1.B();
                    if (zD3 || objB3 == InterfaceC22053ub1.a.a()) {
                        objB3 = new c(c4874Gx7U92);
                        interfaceC22053ub1.s(objB3);
                    }
                    InterfaceC16733lm3 interfaceC16733lm32 = (InterfaceC16733lm3) objB3;
                    interfaceC22053ub1.Q();
                    String strD2 = ((C12880fK5) AbstractC10222bH6.b(this.b.U9().f1(), null, interfaceC22053ub1, 0, 1).getValue()).g().d();
                    interfaceC22053ub1.W(1171130487);
                    boolean zD4 = interfaceC22053ub1.D(this.b) | interfaceC22053ub1.D(this.a);
                    final C9429Zw7 c9429Zw7 = this.b;
                    final C8588Wp4 c8588Wp42 = this.a;
                    Object objB4 = interfaceC22053ub1.B();
                    if (zD4 || objB4 == InterfaceC22053ub1.a.a()) {
                        objB4 = new SA2() { // from class: ir.nasim.Dx7
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return C9429Zw7.b.a.j.f(c9429Zw7, c8588Wp42);
                            }
                        };
                        interfaceC22053ub1.s(objB4);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC18589ou6.e(sa2, (SA2) objB4, strD, (UA2) interfaceC16733lm3, strC, (UA2) interfaceC16733lm32, true, strD2, interfaceC22053ub1, 1572864, 0);
                }

                @Override // ir.nasim.InterfaceC16978mB2
                public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                    d((InterfaceC5757Ks) obj, (androidx.navigation.d) obj2, (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
                    return C19938rB7.a;
                }
            }

            a(C9429Zw7 c9429Zw7) {
                this.a = c9429Zw7;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final androidx.compose.animation.j h(androidx.compose.animation.d dVar) {
                AbstractC13042fc3.i(dVar, "$this$NavHost");
                return androidx.compose.animation.j.a.a();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final androidx.compose.animation.h i(androidx.compose.animation.d dVar) {
                AbstractC13042fc3.i(dVar, "$this$NavHost");
                return androidx.compose.animation.h.a.a();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 k(final C9429Zw7 c9429Zw7, final C8588Wp4 c8588Wp4, C8120Up4 c8120Up4) {
                AbstractC13042fc3.i(c9429Zw7, "this$0");
                AbstractC13042fc3.i(c8588Wp4, "$navController");
                AbstractC13042fc3.i(c8120Up4, "$this$NavHost");
                AbstractC8354Vp4.c(c8120Up4, AbstractC4625Fx7.d.a.a(), null, null, null, null, null, null, AbstractC19242q11.c(195850004, true, new C0821a(c9429Zw7, c8588Wp4)), 126, null);
                AbstractC8354Vp4.c(c8120Up4, AbstractC4625Fx7.c.a.a(), null, null, null, null, null, null, AbstractC19242q11.c(-1280918133, true, new C0825b(c9429Zw7, c8588Wp4)), 126, null);
                AbstractC8354Vp4.c(c8120Up4, AbstractC4625Fx7.a.a.a(), null, null, null, null, null, null, AbstractC19242q11.c(810611404, true, new c(c9429Zw7, c8588Wp4)), 126, null);
                AbstractC8354Vp4.c(c8120Up4, AbstractC4625Fx7.f.a.a(), null, null, null, null, null, null, AbstractC19242q11.c(-1392826355, true, new d(c9429Zw7, c8588Wp4)), 126, null);
                AbstractC8354Vp4.c(c8120Up4, AbstractC4625Fx7.b.a.a(), null, null, null, null, null, null, AbstractC19242q11.c(698703182, true, new e(c8588Wp4, c9429Zw7)), 126, null);
                AbstractC8354Vp4.c(c8120Up4, AbstractC4625Fx7.g.a.a(), null, null, null, null, null, null, AbstractC19242q11.c(-1504734577, true, new f(c9429Zw7, c8588Wp4)), 126, null);
                AbstractC8354Vp4.c(c8120Up4, AbstractC4625Fx7.h.a.a(), null, null, null, null, null, null, AbstractC19242q11.c(586794960, true, new g(c9429Zw7, c8588Wp4)), 126, null);
                AbstractC8354Vp4.f(c8120Up4, AbstractC4625Fx7.e.b.b.a(), new AbstractC4625Fx7.e().a(), null, null, null, null, null, null, new UA2() { // from class: ir.nasim.dx7
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C9429Zw7.b.a.n(c9429Zw7, c8588Wp4, (C8120Up4) obj);
                    }
                }, 252, null);
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 n(C9429Zw7 c9429Zw7, C8588Wp4 c8588Wp4, C8120Up4 c8120Up4) {
                AbstractC13042fc3.i(c9429Zw7, "this$0");
                AbstractC13042fc3.i(c8588Wp4, "$navController");
                AbstractC13042fc3.i(c8120Up4, "$this$navigation");
                AbstractC8354Vp4.c(c8120Up4, AbstractC4625Fx7.e.b.b.a(), null, null, null, null, null, null, AbstractC19242q11.c(32251391, true, new h(c9429Zw7, c8588Wp4)), 126, null);
                AbstractC8354Vp4.c(c8120Up4, AbstractC4625Fx7.e.c.b.a(), null, null, null, null, null, null, AbstractC19242q11.c(1786447862, true, new i(c8588Wp4, c9429Zw7)), 126, null);
                AbstractC8354Vp4.c(c8120Up4, AbstractC4625Fx7.e.a.b.a(), null, null, null, null, null, null, AbstractC19242q11.c(775781815, true, new j(c8588Wp4, c9429Zw7)), 126, null);
                return C19938rB7.a;
            }

            public final void f(InterfaceC22053ub1 interfaceC22053ub1, int i2) throws Resources.NotFoundException {
                if ((i2 & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                P72 p72 = (P72) AbstractC10222bH6.b(this.a.U9().c1(), null, interfaceC22053ub1, 0, 1).getValue();
                if (AbstractC13042fc3.d(p72, P72.c.a)) {
                    interfaceC22053ub1.W(-403272092);
                    e.a aVar = androidx.compose.ui.e.a;
                    androidx.compose.ui.e eVarF = androidx.compose.foundation.layout.t.f(aVar, 0.0f, 1, null);
                    InterfaceC12529em.a aVar2 = InterfaceC12529em.a;
                    InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar2.o(), false);
                    int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                    InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                    androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarF);
                    InterfaceC16030kb1.a aVar3 = InterfaceC16030kb1.d0;
                    SA2 sa2A = aVar3.a();
                    if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                        AbstractC6797Pa1.c();
                    }
                    interfaceC22053ub1.G();
                    if (interfaceC22053ub1.h()) {
                        interfaceC22053ub1.g(sa2A);
                    } else {
                        interfaceC22053ub1.r();
                    }
                    InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1);
                    DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar3.e());
                    DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar3.g());
                    InterfaceC14603iB2 interfaceC14603iB2B = aVar3.b();
                    if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                        interfaceC22053ub1A.s(Integer.valueOf(iA));
                        interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                    }
                    DG7.c(interfaceC22053ub1A, eVarE, aVar3.f());
                    AbstractC10628bv5.a(androidx.compose.foundation.layout.h.a.h(aVar, aVar2.e()), G10.a.a(interfaceC22053ub1, G10.b).I(), 0.0f, 0L, 0, interfaceC22053ub1, 0, 28);
                    interfaceC22053ub1.u();
                    interfaceC22053ub1.Q();
                    return;
                }
                if (p72 instanceof P72.a) {
                    interfaceC22053ub1.W(-402867077);
                    e.a aVar4 = androidx.compose.ui.e.a;
                    androidx.compose.ui.e eVarF2 = androidx.compose.foundation.layout.t.f(aVar4, 0.0f, 1, null);
                    InterfaceC12529em.a aVar5 = InterfaceC12529em.a;
                    InterfaceC10970cW3 interfaceC10970cW3G2 = androidx.compose.foundation.layout.f.g(aVar5.o(), false);
                    int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                    InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1.q();
                    androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarF2);
                    InterfaceC16030kb1.a aVar6 = InterfaceC16030kb1.d0;
                    SA2 sa2A2 = aVar6.a();
                    if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                        AbstractC6797Pa1.c();
                    }
                    interfaceC22053ub1.G();
                    if (interfaceC22053ub1.h()) {
                        interfaceC22053ub1.g(sa2A2);
                    } else {
                        interfaceC22053ub1.r();
                    }
                    InterfaceC22053ub1 interfaceC22053ub1A2 = DG7.a(interfaceC22053ub1);
                    DG7.c(interfaceC22053ub1A2, interfaceC10970cW3G2, aVar6.e());
                    DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar6.g());
                    InterfaceC14603iB2 interfaceC14603iB2B2 = aVar6.b();
                    if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                        interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                        interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
                    }
                    DG7.c(interfaceC22053ub1A2, eVarE2, aVar6.f());
                    androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
                    String strC = UY6.c(AbstractC12217eE5.auth_error_unknown, interfaceC22053ub1, 0);
                    androidx.compose.ui.e eVarH = hVar.h(aVar4, aVar5.e());
                    G10 g10 = G10.a;
                    int i3 = G10.b;
                    AbstractC9105Ym7.b(strC, androidx.compose.foundation.layout.q.i(eVarH, g10.c(interfaceC22053ub1, i3).b().c()), g10.a(interfaceC22053ub1, i3).t(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i3).a(), interfaceC22053ub1, 0, 0, 65528);
                    interfaceC22053ub1.u();
                    interfaceC22053ub1.Q();
                    return;
                }
                if (!(p72 instanceof P72.d)) {
                    interfaceC22053ub1.W(-386340481);
                    interfaceC22053ub1.Q();
                    return;
                }
                interfaceC22053ub1.W(-401729935);
                final C8588Wp4 c8588Wp4E = AbstractC8854Xp4.e(new androidx.navigation.p[0], interfaceC22053ub1, 0);
                String strA = ((P72.d) p72).a() ? AbstractC4625Fx7.d.a.a() : AbstractC4625Fx7.a.a.a();
                UA2 ua2E = AbstractC8216Va1.e(interfaceC22053ub1, 0);
                interfaceC22053ub1.W(-844244040);
                Object objB = interfaceC22053ub1.B();
                InterfaceC22053ub1.a aVar7 = InterfaceC22053ub1.a;
                if (objB == aVar7.a()) {
                    objB = new UA2() { // from class: ir.nasim.ax7
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return C9429Zw7.b.a.h((androidx.compose.animation.d) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                UA2 ua2 = (UA2) objB;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(-844241671);
                Object objB2 = interfaceC22053ub1.B();
                if (objB2 == aVar7.a()) {
                    objB2 = new UA2() { // from class: ir.nasim.bx7
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return C9429Zw7.b.a.i((androidx.compose.animation.d) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB2);
                }
                UA2 ua22 = (UA2) objB2;
                interfaceC22053ub1.Q();
                UA2 ua2H = AbstractC8216Va1.h(interfaceC22053ub1, 0);
                interfaceC22053ub1.W(-844222368);
                boolean zD = interfaceC22053ub1.D(this.a) | interfaceC22053ub1.D(c8588Wp4E);
                final C9429Zw7 c9429Zw7 = this.a;
                Object objB3 = interfaceC22053ub1.B();
                if (zD || objB3 == aVar7.a()) {
                    objB3 = new UA2() { // from class: ir.nasim.cx7
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return C9429Zw7.b.a.k(c9429Zw7, c8588Wp4E, (C8120Up4) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB3);
                }
                interfaceC22053ub1.Q();
                AbstractC9129Yp4.b(c8588Wp4E, strA, null, null, null, ua2E, ua2, ua22, ua2H, (UA2) objB3, interfaceC22053ub1, 14155776, 28);
                interfaceC22053ub1.Q();
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws Resources.NotFoundException {
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
                M10.f(false, AbstractC19242q11.e(-939736462, true, new a(C9429Zw7.this), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Zw7$c */
    public static final class c extends AbstractC8614Ws3 implements UA2 {
        public c() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C5355Iz2.a(fragment.V7());
        }
    }

    /* renamed from: ir.nasim.Zw7$d */
    public static final class d extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Fragment invoke() {
            return this.e;
        }
    }

    /* renamed from: ir.nasim.Zw7$e */
    public static final class e extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return (InterfaceC15408jX7) this.e.invoke();
        }
    }

    /* renamed from: ir.nasim.Zw7$f */
    public static final class f extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9173Yu3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return AbstractC6550Nz2.c(this.e).d1();
        }
    }

    /* renamed from: ir.nasim.Zw7$g */
    public static final class g extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(SA2 sa2, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    /* renamed from: ir.nasim.Zw7$h */
    public static final class h extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(Fragment fragment, InterfaceC9173Yu3 interfaceC9173Yu3) {
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
            if (hVar != null && (cVarN3 = hVar.n3()) != null) {
                return cVarN3;
            }
            G.c cVarN32 = this.e.n3();
            AbstractC13042fc3.h(cVarN32, "defaultViewModelProviderFactory");
            return cVarN32;
        }
    }

    public C9429Zw7() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new e(new d(this)));
        this.viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C4874Gx7.class), new f(interfaceC9173Yu3B), new g(null, interfaceC9173Yu3B), new h(this, interfaceC9173Yu3B));
    }

    private final C5355Iz2 T9() {
        Object objA = this.binding.a(this, k1[0]);
        AbstractC13042fc3.h(objA, "getValue(...)");
        return (C5355Iz2) objA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C4874Gx7 U9() {
        return (C4874Gx7) this.viewModel.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        ConstraintLayout root = C5355Iz2.c(inflater, container, false).getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        U9().i1();
        T9().b.setContent(AbstractC19242q11.c(163702925, true, new b()));
    }
}
