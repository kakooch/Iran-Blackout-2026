package ir.nasim;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.G;
import ir.nasim.AbstractC14677iJ0;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.UI0;
import ir.nasim.features.root.AbstractC13089g;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0019\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001f\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lir/nasim/UI0;", "Lir/nasim/ua0;", "<init>", "()V", "Lir/nasim/gJ0;", "changePhoneNumberViewModel", "Lir/nasim/rB7;", "U9", "(Lir/nasim/gJ0;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "h1", "Lir/nasim/Yu3;", "W9", "()Lir/nasim/gJ0;", "viewModel", "Lir/nasim/Fx2;", "i1", "Lir/nasim/bW7;", "V9", "()Lir/nasim/Fx2;", "binding", "settings_productionRelease"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes7.dex */
public final class UI0 extends AbstractC10353bW2 {
    static final /* synthetic */ InterfaceC5239Im3[] j1 = {AbstractC10882cM5.i(new C25226zw5(UI0.class, "binding", "getBinding()Lir/nasim/settings/databinding/FragmentChangePhoneNumberBinding;", 0))};
    public static final int k1 = 8;

    /* renamed from: h1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;

    /* renamed from: i1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C13484gJ0 c;
        final /* synthetic */ UI0 d;

        /* renamed from: ir.nasim.UI0$a$a, reason: collision with other inner class name */
        static final class C0678a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ UI0 d;
            final /* synthetic */ C13484gJ0 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0678a(UI0 ui0, C13484gJ0 c13484gJ0, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = ui0;
                this.e = c13484gJ0;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                C0678a c0678a = new C0678a(this.d, this.e, interfaceC20295rm1);
                c0678a.c = obj;
                return c0678a;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                if (((C23726xP7) this.c).h()) {
                    UI0 ui0 = this.d;
                    ui0.l9(ui0, true);
                    this.e.i1();
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C23726xP7 c23726xP7, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C0678a) create(c23726xP7, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C13484gJ0 c13484gJ0, UI0 ui0, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c13484gJ0;
            this.d = ui0;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10258bL6 interfaceC10258bL6C1 = this.c.c1();
                C0678a c0678a = new C0678a(this.d, this.c, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC10258bL6C1, c0678a, this) == objE) {
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

    static final class b implements InterfaceC14603iB2 {

        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ UI0 a;

            /* renamed from: ir.nasim.UI0$b$a$a, reason: collision with other inner class name */
            static final class C0679a implements InterfaceC16978mB2 {
                final /* synthetic */ UI0 a;
                final /* synthetic */ C8588Wp4 b;

                /* renamed from: ir.nasim.UI0$b$a$a$a, reason: collision with other inner class name */
                /* synthetic */ class C0680a extends EB2 implements SA2 {
                    C0680a(Object obj) {
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

                C0679a(UI0 ui0, C8588Wp4 c8588Wp4) {
                    this.a = ui0;
                    this.b = c8588Wp4;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 f(C8588Wp4 c8588Wp4) throws Resources.NotFoundException {
                    AbstractC13042fc3.i(c8588Wp4, "$navController");
                    c8588Wp4.R(new AbstractC14677iJ0.b().a(), new UA2() { // from class: ir.nasim.bJ0
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return UI0.b.a.C0679a.h((androidx.navigation.n) obj);
                        }
                    });
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 h(androidx.navigation.n nVar) {
                    AbstractC13042fc3.i(nVar, "$this$navigate");
                    androidx.navigation.n.e(nVar, 0, null, 2, null);
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 i() {
                    C18987pb3.a.q1(AbstractC13089g.e1, null, true);
                    return C19938rB7.a;
                }

                public final void d(InterfaceC5757Ks interfaceC5757Ks, androidx.navigation.d dVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    AbstractC13042fc3.i(interfaceC5757Ks, "$this$composable");
                    AbstractC13042fc3.i(dVar, "it");
                    FragmentActivity fragmentActivityQ7 = this.a.Q7();
                    interfaceC22053ub1.W(458043705);
                    boolean zD = interfaceC22053ub1.D(fragmentActivityQ7);
                    Object objB = interfaceC22053ub1.B();
                    if (zD || objB == InterfaceC22053ub1.a.a()) {
                        objB = new C0680a(fragmentActivityQ7);
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    SA2 sa2 = (SA2) ((InterfaceC16733lm3) objB);
                    interfaceC22053ub1.W(458046224);
                    boolean zD2 = interfaceC22053ub1.D(this.b);
                    final C8588Wp4 c8588Wp4 = this.b;
                    Object objB2 = interfaceC22053ub1.B();
                    if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                        objB2 = new SA2() { // from class: ir.nasim.ZI0
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return UI0.b.a.C0679a.f(c8588Wp4);
                            }
                        };
                        interfaceC22053ub1.s(objB2);
                    }
                    SA2 sa22 = (SA2) objB2;
                    interfaceC22053ub1.Q();
                    interfaceC22053ub1.W(458054395);
                    Object objB3 = interfaceC22053ub1.B();
                    if (objB3 == InterfaceC22053ub1.a.a()) {
                        objB3 = new SA2() { // from class: ir.nasim.aJ0
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return UI0.b.a.C0679a.i();
                            }
                        };
                        interfaceC22053ub1.s(objB3);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC5217Ik.m(sa2, sa22, (SA2) objB3, (AbstractC20864sk) AbstractC10222bH6.b(this.a.W9().e1(), null, interfaceC22053ub1, 0, 1).getValue(), interfaceC22053ub1, 384, 0);
                }

                @Override // ir.nasim.InterfaceC16978mB2
                public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                    d((InterfaceC5757Ks) obj, (androidx.navigation.d) obj2, (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
                    return C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.UI0$b$a$b, reason: collision with other inner class name */
            static final class C0681b implements InterfaceC16978mB2 {
                final /* synthetic */ UI0 a;
                final /* synthetic */ C8588Wp4 b;

                /* renamed from: ir.nasim.UI0$b$a$b$a, reason: collision with other inner class name */
                /* synthetic */ class C0682a extends EB2 implements SA2 {
                    C0682a(Object obj) {
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

                /* renamed from: ir.nasim.UI0$b$a$b$b, reason: collision with other inner class name */
                /* synthetic */ class C0683b extends EB2 implements UA2 {
                    C0683b(Object obj) {
                        super(1, obj, C13484gJ0.class, "updatePhoneNumber", "updatePhoneNumber(Ljava/lang/String;)V", 0);
                    }

                    @Override // ir.nasim.UA2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        y((String) obj);
                        return C19938rB7.a;
                    }

                    public final void y(String str) {
                        AbstractC13042fc3.i(str, "p0");
                        ((C13484gJ0) this.receiver).m1(str);
                    }
                }

                C0681b(UI0 ui0, C8588Wp4 c8588Wp4) {
                    this.a = ui0;
                    this.b = c8588Wp4;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 d(UI0 ui0, final C8588Wp4 c8588Wp4, long j) {
                    AbstractC13042fc3.i(ui0, "this$0");
                    AbstractC13042fc3.i(c8588Wp4, "$navController");
                    ui0.W9().f1(j, new SA2() { // from class: ir.nasim.dJ0
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return UI0.b.a.C0681b.f(c8588Wp4);
                        }
                    });
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 f(C8588Wp4 c8588Wp4) throws Resources.NotFoundException {
                    AbstractC13042fc3.i(c8588Wp4, "$navController");
                    androidx.navigation.e.S(c8588Wp4, AbstractC14677iJ0.b.c.b.a(), null, null, 6, null);
                    return C19938rB7.a;
                }

                public final void c(InterfaceC5757Ks interfaceC5757Ks, androidx.navigation.d dVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    AbstractC13042fc3.i(interfaceC5757Ks, "$this$composable");
                    AbstractC13042fc3.i(dVar, "it");
                    FragmentActivity fragmentActivityQ7 = this.a.Q7();
                    interfaceC22053ub1.W(1375539320);
                    boolean zD = interfaceC22053ub1.D(fragmentActivityQ7);
                    Object objB = interfaceC22053ub1.B();
                    if (zD || objB == InterfaceC22053ub1.a.a()) {
                        objB = new C0682a(fragmentActivityQ7);
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    SA2 sa2 = (SA2) ((InterfaceC16733lm3) objB);
                    C8588Wp4 c8588Wp4 = this.b;
                    String strD = ((C13967h73) AbstractC10222bH6.b(this.a.W9().Z0(), null, interfaceC22053ub1, 0, 1).getValue()).d().d();
                    String strC = ((C13967h73) AbstractC10222bH6.b(this.a.W9().Z0(), null, interfaceC22053ub1, 0, 1).getValue()).d().c();
                    String strE = ((C13967h73) AbstractC10222bH6.b(this.a.W9().Z0(), null, interfaceC22053ub1, 0, 1).getValue()).d().e();
                    String strC2 = ((C13967h73) AbstractC10222bH6.b(this.a.W9().Z0(), null, interfaceC22053ub1, 0, 1).getValue()).c();
                    String strF = ((C13967h73) AbstractC10222bH6.b(this.a.W9().Z0(), null, interfaceC22053ub1, 0, 1).getValue()).d().f();
                    C13484gJ0 c13484gJ0W9 = this.a.W9();
                    interfaceC22053ub1.W(1375563124);
                    boolean zD2 = interfaceC22053ub1.D(c13484gJ0W9);
                    Object objB2 = interfaceC22053ub1.B();
                    if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                        objB2 = new C0683b(c13484gJ0W9);
                        interfaceC22053ub1.s(objB2);
                    }
                    interfaceC22053ub1.Q();
                    UA2 ua2 = (UA2) ((InterfaceC16733lm3) objB2);
                    interfaceC22053ub1.W(1375565900);
                    boolean zD3 = interfaceC22053ub1.D(this.a) | interfaceC22053ub1.D(this.b);
                    final UI0 ui0 = this.a;
                    final C8588Wp4 c8588Wp42 = this.b;
                    Object objB3 = interfaceC22053ub1.B();
                    if (zD3 || objB3 == InterfaceC22053ub1.a.a()) {
                        objB3 = new UA2() { // from class: ir.nasim.cJ0
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return UI0.b.a.C0681b.d(ui0, c8588Wp42, ((Long) obj).longValue());
                            }
                        };
                        interfaceC22053ub1.s(objB3);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC17531n73.b(sa2, c8588Wp4, strD, strC, strE, strC2, strF, ua2, (UA2) objB3, ((C13967h73) AbstractC10222bH6.b(this.a.W9().Z0(), null, interfaceC22053ub1, 0, 1).getValue()).e(), interfaceC22053ub1, 0);
                }

                @Override // ir.nasim.InterfaceC16978mB2
                public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                    c((InterfaceC5757Ks) obj, (androidx.navigation.d) obj2, (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
                    return C19938rB7.a;
                }
            }

            static final class c implements InterfaceC16978mB2 {
                final /* synthetic */ UI0 a;
                final /* synthetic */ C8588Wp4 b;

                /* renamed from: ir.nasim.UI0$b$a$c$a, reason: collision with other inner class name */
                static final class C0684a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                    int b;
                    final /* synthetic */ UI0 c;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C0684a(UI0 ui0, InterfaceC20295rm1 interfaceC20295rm1) {
                        super(2, interfaceC20295rm1);
                        this.c = ui0;
                    }

                    @Override // ir.nasim.E90
                    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                        return new C0684a(this.c, interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        AbstractC14862ic3.e();
                        if (this.b != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                        UI0 ui0 = this.c;
                        ui0.U9(ui0.W9());
                        return C19938rB7.a;
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    /* renamed from: n, reason: merged with bridge method [inline-methods] */
                    public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                        return ((C0684a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                    }
                }

                /* renamed from: ir.nasim.UI0$b$a$c$b, reason: collision with other inner class name */
                /* synthetic */ class C0685b extends EB2 implements UA2 {
                    C0685b(Object obj) {
                        super(1, obj, C13484gJ0.class, "updateValidationCode", "updateValidationCode(Ljava/lang/String;)V", 0);
                    }

                    @Override // ir.nasim.UA2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        y((String) obj);
                        return C19938rB7.a;
                    }

                    public final void y(String str) {
                        AbstractC13042fc3.i(str, "p0");
                        ((C13484gJ0) this.receiver).o1(str);
                    }
                }

                /* renamed from: ir.nasim.UI0$b$a$c$c, reason: collision with other inner class name */
                /* synthetic */ class C0686c extends EB2 implements SA2 {
                    C0686c(Object obj) {
                        super(0, obj, C13484gJ0.class, "updateCountDown", "updateCountDown()V", 0);
                    }

                    @Override // ir.nasim.SA2
                    public /* bridge */ /* synthetic */ Object invoke() {
                        y();
                        return C19938rB7.a;
                    }

                    public final void y() {
                        ((C13484gJ0) this.receiver).j1();
                    }
                }

                /* synthetic */ class d extends C23553x7 implements UA2 {
                    d(Object obj) {
                        super(1, obj, C13484gJ0.class, "initPhoneForValidation", "initPhoneForValidation(JLkotlin/jvm/functions/Function0;)Lkotlinx/coroutines/Job;", 8);
                    }

                    public final void a(long j) {
                        C13484gJ0.g1((C13484gJ0) this.a, j, null, 2, null);
                    }

                    @Override // ir.nasim.UA2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        a(((Number) obj).longValue());
                        return C19938rB7.a;
                    }
                }

                /* synthetic */ class e extends C23553x7 implements UA2 {
                    e(Object obj) {
                        super(1, obj, C13484gJ0.class, "validateCode", "validateCode(Ljava/lang/String;)Lkotlinx/coroutines/Job;", 8);
                    }

                    public final void a(String str) {
                        AbstractC13042fc3.i(str, "p0");
                        ((C13484gJ0) this.a).p1(str);
                    }

                    @Override // ir.nasim.UA2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        a((String) obj);
                        return C19938rB7.a;
                    }
                }

                c(UI0 ui0, C8588Wp4 c8588Wp4) {
                    this.a = ui0;
                    this.b = c8588Wp4;
                }

                public final void a(InterfaceC5757Ks interfaceC5757Ks, androidx.navigation.d dVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    AbstractC13042fc3.i(interfaceC5757Ks, "$this$composable");
                    AbstractC13042fc3.i(dVar, "it");
                    C19938rB7 c19938rB7 = C19938rB7.a;
                    interfaceC22053ub1.W(1375584772);
                    boolean zD = interfaceC22053ub1.D(this.a);
                    UI0 ui0 = this.a;
                    Object objB = interfaceC22053ub1.B();
                    if (zD || objB == InterfaceC22053ub1.a.a()) {
                        objB = new C0684a(ui0, null);
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC10721c52.e(c19938rB7, (InterfaceC14603iB2) objB, interfaceC22053ub1, 6);
                    C8588Wp4 c8588Wp4 = this.b;
                    String strF = ((C23726xP7) AbstractC10222bH6.b(this.a.W9().c1(), null, interfaceC22053ub1, 0, 1).getValue()).f();
                    String strG = ((C23726xP7) AbstractC10222bH6.b(this.a.W9().c1(), null, interfaceC22053ub1, 0, 1).getValue()).g();
                    C13484gJ0 c13484gJ0W9 = this.a.W9();
                    interfaceC22053ub1.W(1375600311);
                    boolean zD2 = interfaceC22053ub1.D(c13484gJ0W9);
                    Object objB2 = interfaceC22053ub1.B();
                    if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                        objB2 = new C0685b(c13484gJ0W9);
                        interfaceC22053ub1.s(objB2);
                    }
                    interfaceC22053ub1.Q();
                    UA2 ua2 = (UA2) ((InterfaceC16733lm3) objB2);
                    int seconds = (int) TimeUnit.MILLISECONDS.toSeconds(((C23726xP7) AbstractC10222bH6.b(this.a.W9().c1(), null, interfaceC22053ub1, 0, 1).getValue()).e());
                    C13484gJ0 c13484gJ0W92 = this.a.W9();
                    interfaceC22053ub1.W(1375611698);
                    boolean zD3 = interfaceC22053ub1.D(c13484gJ0W92);
                    Object objB3 = interfaceC22053ub1.B();
                    if (zD3 || objB3 == InterfaceC22053ub1.a.a()) {
                        objB3 = new C0686c(c13484gJ0W92);
                        interfaceC22053ub1.s(objB3);
                    }
                    interfaceC22053ub1.Q();
                    SA2 sa2 = (SA2) ((InterfaceC16733lm3) objB3);
                    C13484gJ0 c13484gJ0W93 = this.a.W9();
                    interfaceC22053ub1.W(1375614169);
                    boolean zD4 = interfaceC22053ub1.D(c13484gJ0W93);
                    Object objB4 = interfaceC22053ub1.B();
                    if (zD4 || objB4 == InterfaceC22053ub1.a.a()) {
                        objB4 = new d(c13484gJ0W93);
                        interfaceC22053ub1.s(objB4);
                    }
                    UA2 ua22 = (UA2) objB4;
                    interfaceC22053ub1.Q();
                    long jD = ((C23726xP7) AbstractC10222bH6.b(this.a.W9().c1(), null, interfaceC22053ub1, 0, 1).getValue()).d();
                    String strC = ((C23726xP7) AbstractC10222bH6.b(this.a.W9().c1(), null, interfaceC22053ub1, 0, 1).getValue()).c();
                    boolean zI = ((C23726xP7) AbstractC10222bH6.b(this.a.W9().c1(), null, interfaceC22053ub1, 0, 1).getValue()).i();
                    C13484gJ0 c13484gJ0W94 = this.a.W9();
                    interfaceC22053ub1.W(1375627055);
                    boolean zD5 = interfaceC22053ub1.D(c13484gJ0W94);
                    Object objB5 = interfaceC22053ub1.B();
                    if (zD5 || objB5 == InterfaceC22053ub1.a.a()) {
                        objB5 = new e(c13484gJ0W94);
                        interfaceC22053ub1.s(objB5);
                    }
                    interfaceC22053ub1.Q();
                    EP7.g(c8588Wp4, strF, strG, ua2, seconds, sa2, ua22, jD, strC, zI, (UA2) objB5, interfaceC22053ub1, 0, 0);
                }

                @Override // ir.nasim.InterfaceC16978mB2
                public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                    a((InterfaceC5757Ks) obj, (androidx.navigation.d) obj2, (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
                    return C19938rB7.a;
                }
            }

            static final class d implements InterfaceC16978mB2 {
                final /* synthetic */ C8588Wp4 a;
                final /* synthetic */ UI0 b;

                /* renamed from: ir.nasim.UI0$b$a$d$a, reason: collision with other inner class name */
                /* synthetic */ class C0687a extends EB2 implements UA2 {
                    C0687a(Object obj) {
                        super(1, obj, C13484gJ0.class, "updateCountryQuery", "updateCountryQuery(Ljava/lang/String;)V", 0);
                    }

                    @Override // ir.nasim.UA2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        y((String) obj);
                        return C19938rB7.a;
                    }

                    public final void y(String str) {
                        AbstractC13042fc3.i(str, "p0");
                        ((C13484gJ0) this.receiver).l1(str);
                    }
                }

                /* renamed from: ir.nasim.UI0$b$a$d$b, reason: collision with other inner class name */
                /* synthetic */ class C0688b extends EB2 implements InterfaceC15796kB2 {
                    C0688b(Object obj) {
                        super(3, obj, C13484gJ0.class, "updateCountryCode", "updateCountryCode(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", 0);
                    }

                    @Override // ir.nasim.InterfaceC15796kB2
                    public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                        y((String) obj, (String) obj2, (String) obj3);
                        return C19938rB7.a;
                    }

                    public final void y(String str, String str2, String str3) {
                        AbstractC13042fc3.i(str, "p0");
                        AbstractC13042fc3.i(str2, "p1");
                        ((C13484gJ0) this.receiver).k1(str, str2, str3);
                    }
                }

                d(C8588Wp4 c8588Wp4, UI0 ui0) {
                    this.a = c8588Wp4;
                    this.b = ui0;
                }

                public final void a(InterfaceC5757Ks interfaceC5757Ks, androidx.navigation.d dVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    AbstractC13042fc3.i(interfaceC5757Ks, "$this$composable");
                    AbstractC13042fc3.i(dVar, "it");
                    C12561ep1 c12561ep1D = AbstractC14677iJ0.b.a.b.d();
                    C8588Wp4 c8588Wp4 = this.a;
                    String str = (String) AbstractC10222bH6.b(this.b.W9().b1(), null, interfaceC22053ub1, 0, 1).getValue();
                    C13484gJ0 c13484gJ0W9 = this.b.W9();
                    interfaceC22053ub1.W(1375643317);
                    boolean zD = interfaceC22053ub1.D(c13484gJ0W9);
                    Object objB = interfaceC22053ub1.B();
                    if (zD || objB == InterfaceC22053ub1.a.a()) {
                        objB = new C0687a(c13484gJ0W9);
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    UA2 ua2 = (UA2) ((InterfaceC16733lm3) objB);
                    C13484gJ0 c13484gJ0W92 = this.b.W9();
                    interfaceC22053ub1.W(1375645332);
                    boolean zD2 = interfaceC22053ub1.D(c13484gJ0W92);
                    Object objB2 = interfaceC22053ub1.B();
                    if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                        objB2 = new C0688b(c13484gJ0W92);
                        interfaceC22053ub1.s(objB2);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC11704dT0.d(c12561ep1D, c8588Wp4, str, ua2, (InterfaceC15796kB2) ((InterfaceC16733lm3) objB2), interfaceC22053ub1, C12561ep1.b);
                }

                @Override // ir.nasim.InterfaceC16978mB2
                public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                    a((InterfaceC5757Ks) obj, (androidx.navigation.d) obj2, (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
                    return C19938rB7.a;
                }
            }

            a(UI0 ui0) {
                this.a = ui0;
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
            public static final C19938rB7 k(final UI0 ui0, final C8588Wp4 c8588Wp4, C8120Up4 c8120Up4) {
                AbstractC13042fc3.i(ui0, "this$0");
                AbstractC13042fc3.i(c8588Wp4, "$navController");
                AbstractC13042fc3.i(c8120Up4, "$this$NavHost");
                AbstractC8354Vp4.c(c8120Up4, AbstractC14677iJ0.a.a.a(), null, null, null, null, null, null, AbstractC19242q11.c(748054063, true, new C0679a(ui0, c8588Wp4)), 126, null);
                AbstractC8354Vp4.f(c8120Up4, AbstractC14677iJ0.b.C1290b.b.a(), new AbstractC14677iJ0.b().a(), null, null, null, null, null, null, new UA2() { // from class: ir.nasim.YI0
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return UI0.b.a.n(ui0, c8588Wp4, (C8120Up4) obj);
                    }
                }, 252, null);
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 n(UI0 ui0, C8588Wp4 c8588Wp4, C8120Up4 c8120Up4) {
                AbstractC13042fc3.i(ui0, "this$0");
                AbstractC13042fc3.i(c8588Wp4, "$navController");
                AbstractC13042fc3.i(c8120Up4, "$this$navigation");
                AbstractC8354Vp4.c(c8120Up4, AbstractC14677iJ0.b.C1290b.b.a(), null, null, null, null, null, null, AbstractC19242q11.c(-1558158428, true, new C0681b(ui0, c8588Wp4)), 126, null);
                AbstractC8354Vp4.c(c8120Up4, AbstractC14677iJ0.b.c.b.a(), null, null, null, null, null, null, AbstractC19242q11.c(-1199201395, true, new c(ui0, c8588Wp4)), 126, null);
                AbstractC8354Vp4.c(c8120Up4, AbstractC14677iJ0.b.a.b.a(), null, null, null, null, null, null, AbstractC19242q11.c(-1904061716, true, new d(c8588Wp4, ui0)), 126, null);
                return C19938rB7.a;
            }

            public final void f(InterfaceC22053ub1 interfaceC22053ub1, int i) throws Resources.NotFoundException {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                final C8588Wp4 c8588Wp4E = AbstractC8854Xp4.e(new androidx.navigation.p[0], interfaceC22053ub1, 0);
                String strA = AbstractC14677iJ0.a.a.a();
                UA2 ua2E = AbstractC8216Va1.e(interfaceC22053ub1, 0);
                interfaceC22053ub1.W(-58543405);
                Object objB = interfaceC22053ub1.B();
                InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
                if (objB == aVar.a()) {
                    objB = new UA2() { // from class: ir.nasim.VI0
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return UI0.b.a.h((androidx.compose.animation.d) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                UA2 ua2 = (UA2) objB;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(-58541292);
                Object objB2 = interfaceC22053ub1.B();
                if (objB2 == aVar.a()) {
                    objB2 = new UA2() { // from class: ir.nasim.WI0
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return UI0.b.a.i((androidx.compose.animation.d) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB2);
                }
                UA2 ua22 = (UA2) objB2;
                interfaceC22053ub1.Q();
                UA2 ua2H = AbstractC8216Va1.h(interfaceC22053ub1, 0);
                interfaceC22053ub1.W(-58533217);
                boolean zD = interfaceC22053ub1.D(this.a) | interfaceC22053ub1.D(c8588Wp4E);
                final UI0 ui0 = this.a;
                Object objB3 = interfaceC22053ub1.B();
                if (zD || objB3 == aVar.a()) {
                    objB3 = new UA2() { // from class: ir.nasim.XI0
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return UI0.b.a.k(ui0, c8588Wp4E, (C8120Up4) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB3);
                }
                interfaceC22053ub1.Q();
                AbstractC9129Yp4.b(c8588Wp4E, strA, null, null, null, ua2E, ua2, ua22, ua2H, (UA2) objB3, interfaceC22053ub1, 14155824, 28);
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
                M10.f(false, AbstractC19242q11.e(1406851665, true, new a(UI0.this), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final class c extends AbstractC8614Ws3 implements UA2 {
        public c() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C4620Fx2.a(fragment.V7());
        }
    }

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

    public UI0() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new e(new d(this)));
        this.viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C13484gJ0.class), new f(interfaceC9173Yu3B), new g(null, interfaceC9173Yu3B), new h(this, interfaceC9173Yu3B));
        this.binding = AbstractC6056Lz2.f(this, new c(), AbstractC20046rN7.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U9(C13484gJ0 changePhoneNumberViewModel) {
        AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new a(changePhoneNumberViewModel, this, null), 3, null);
    }

    private final C4620Fx2 V9() {
        Object objA = this.binding.a(this, j1[0]);
        AbstractC13042fc3.h(objA, "getValue(...)");
        return (C4620Fx2) objA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C13484gJ0 W9() {
        return (C13484gJ0) this.viewModel.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        ConstraintLayout root = C4620Fx2.c(inflater, container, false).getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        W9().d1();
        V9().b.setContent(AbstractC19242q11.c(276584918, true, new b()));
    }
}
