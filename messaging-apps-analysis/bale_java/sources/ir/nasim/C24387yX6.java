package ir.nasim;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import ir.nasim.AbstractC10289bP1;
import ir.nasim.C24387yX6;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.components.appbar.view.BaleToolbar;

/* renamed from: ir.nasim.yX6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C24387yX6 extends WX2 {
    public static final a n1 = new a(null);
    public static final int o1 = 8;
    private final InterfaceC15279jJ4 h1;
    public InterfaceC10241bJ7 i1;
    private C3936Cz2 j1;
    private C22021uX6 k1;
    private String l1;
    private final InterfaceC9173Yu3 m1;

    /* renamed from: ir.nasim.yX6$a */
    public static final class a {
        private a() {
        }

        public final C24387yX6 a(String str, InterfaceC15279jJ4 interfaceC15279jJ4) {
            AbstractC13042fc3.i(str, "storyId");
            AbstractC13042fc3.i(interfaceC15279jJ4, "onFragmentCloseListener");
            C24387yX6 c24387yX6 = new C24387yX6(interfaceC15279jJ4);
            Bundle bundle = new Bundle();
            bundle.putString("BUNDLE_STORY_ID_TAG", str);
            c24387yX6.a8(bundle);
            return c24387yX6;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.yX6$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.yX6$b$a */
        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ C24387yX6 a;
            final /* synthetic */ String b;

            a(C24387yX6 c24387yX6, String str) {
                this.a = c24387yX6;
                this.b = str;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(NT4 nt4, InterfaceC20295rm1 interfaceC20295rm1) {
                C22021uX6 c22021uX6;
                this.a.ma();
                if (!AbstractC13042fc3.d(this.b, this.a.ba().N3()) || (c22021uX6 = this.a.k1) == null) {
                    return C19938rB7.a;
                }
                Object objL = c22021uX6.L(nt4, interfaceC20295rm1);
                return objL == AbstractC14862ic3.e() ? objL : C19938rB7.a;
            }
        }

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C24387yX6.this.new b(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                String str = C24387yX6.this.l1;
                if (str != null) {
                    C24387yX6 c24387yX6 = C24387yX6.this;
                    InterfaceC4557Fq2 interfaceC4557Fq2P4 = c24387yX6.ba().P4(str);
                    a aVar = new a(c24387yX6, str);
                    this.b = 1;
                    if (interfaceC4557Fq2P4.b(aVar, this) == objE) {
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

    /* renamed from: ir.nasim.yX6$c */
    static final class c implements InterfaceC15796kB2 {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(Dialog dialog, C24387yX6 c24387yX6) {
            AbstractC13042fc3.i(dialog, "$it");
            AbstractC13042fc3.i(c24387yX6, "this$0");
            dialog.dismiss();
            C10366bX6 c10366bX6Ba = c24387yX6.ba();
            String str = c24387yX6.l1;
            AbstractC13042fc3.f(str);
            c10366bX6Ba.o5(str);
            c24387yX6.Q7().B0().k1();
            c24387yX6.Q7().onBackPressed();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(Dialog dialog) {
            AbstractC13042fc3.i(dialog, "$it");
            dialog.dismiss();
            return C19938rB7.a;
        }

        public final void c(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(dialog, "it");
            U91 u91 = U91.a;
            InterfaceC14603iB2 interfaceC14603iB2A = u91.a();
            AbstractC10289bP1.b.C0905b c0905b = AbstractC10289bP1.b.C0905b.b;
            InterfaceC14603iB2 interfaceC14603iB2B = u91.b();
            AbstractC10289bP1.a.c cVar = AbstractC10289bP1.a.c.a;
            InterfaceC19114po0.c.a aVar = InterfaceC19114po0.c.a.a;
            interfaceC22053ub1.W(1760796100);
            boolean zD = interfaceC22053ub1.D(dialog) | interfaceC22053ub1.D(C24387yX6.this);
            final C24387yX6 c24387yX6 = C24387yX6.this;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.zX6
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C24387yX6.c.d(dialog, c24387yX6);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1.Q();
            int i2 = SD5.story_delete_button;
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            interfaceC22053ub1.W(1760808777);
            boolean zD2 = interfaceC22053ub1.D(dialog);
            Object objB2 = interfaceC22053ub1.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.AX6
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C24387yX6.c.f(dialog);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.E(interfaceC14603iB2A, c0905b, interfaceC14603iB2B, cVar, aVar, sa2, i2, c1454b, (SA2) objB2, SD5.story_cancel_button, null, interfaceC22053ub1, (AbstractC10289bP1.b.C0905b.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.c.a.b << 12) | (InterfaceC19114po0.b.C1454b.b << 21), 0, 1024);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public C24387yX6(InterfaceC15279jJ4 interfaceC15279jJ4) {
        AbstractC13042fc3.i(interfaceC15279jJ4, "onFragmentCloseListener");
        this.h1 = interfaceC15279jJ4;
        this.l1 = "";
        this.m1 = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.wX6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C24387yX6.na(this.a);
            }
        });
    }

    private final C3936Cz2 Z9() {
        C3936Cz2 c3936Cz2 = this.j1;
        AbstractC13042fc3.f(c3936Cz2);
        return c3936Cz2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C10366bX6 ba() {
        return (C10366bX6) this.m1.getValue();
    }

    private final void ca() {
        Z9().f.setVisibility(8);
    }

    private final void da() {
        Z9().g.setLayoutManager(new LinearLayoutManager(S7(), 1, false));
        Z9().g.setAdapter(this.k1);
    }

    private final void ea() {
        Z9().d.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.xX6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C24387yX6.fa(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fa(C24387yX6 c24387yX6, View view) {
        AbstractC13042fc3.i(c24387yX6, "this$0");
        c24387yX6.la();
    }

    private final void ga() {
        da();
        ea();
    }

    private final void ha() {
        this.k1 = new C22021uX6(new UA2() { // from class: ir.nasim.vX6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C24387yX6.ia(this.a, ((Integer) obj).intValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ia(C24387yX6 c24387yX6, int i) {
        AbstractC13042fc3.i(c24387yX6, "this$0");
        C22042ua0.A9(c24387yX6, InterfaceC10241bJ7.c(c24387yX6.aa(), i, false, 2, null), false, null, 6, null);
        return C19938rB7.a;
    }

    private final void ja() {
        Z9().h.setTitle(h6(SD5.story_viewers));
        BaleToolbar baleToolbar = Z9().h;
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        BaleToolbar.setHasBackButton$default(baleToolbar, fragmentActivityQ7, true, false, 4, null);
    }

    private final void ka() {
        Z9().f.setVisibility(0);
    }

    private final void la() {
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        AbstractC21375tZ.c(contextS7, interfaceC18633oz3P6, null, AbstractC19242q11.c(442825851, true, new c()), 4, null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ma() {
        String strValueOf;
        strValueOf = "0";
        if (!AbstractC13042fc3.d(this.l1, ba().N3())) {
            Z9().i.setText(JF5.g() ? XY6.e("0") : "0");
            ka();
            return;
        }
        if (ba().R4() == 0) {
            ka();
            Z9().c.setVisibility(8);
        } else {
            ca();
            strValueOf = String.valueOf(ba().R4());
            if (ba().P3() > 0) {
                Z9().c.setVisibility(0);
                String strValueOf2 = String.valueOf(ba().P3());
                if (JF5.g()) {
                    strValueOf2 = XY6.e(strValueOf2);
                }
                Z9().c.setText(strValueOf2);
            }
        }
        if (JF5.g()) {
            strValueOf = XY6.e(strValueOf);
        }
        Z9().i.setText(strValueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C10366bX6 na(C24387yX6 c24387yX6) {
        AbstractC13042fc3.i(c24387yX6, "this$0");
        FragmentActivity fragmentActivityQ7 = c24387yX6.Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        return (C10366bX6) new androidx.lifecycle.G(fragmentActivityQ7).b(C10366bX6.class);
    }

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle bundle) {
        super.M6(bundle);
        Bundle bundleE5 = E5();
        if (bundleE5 != null) {
            this.l1 = bundleE5.getString("BUNDLE_STORY_ID_TAG");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AbstractC13042fc3.i(layoutInflater, "inflater");
        this.j1 = C3936Cz2.c(Q5(), viewGroup, false);
        ConstraintLayout root = Z9().getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void T6() {
        this.h1.onClose();
        super.T6();
        ba().d6();
    }

    public final InterfaceC10241bJ7 aa() {
        InterfaceC10241bJ7 interfaceC10241bJ7 = this.i1;
        if (interfaceC10241bJ7 != null) {
            return interfaceC10241bJ7;
        }
        AbstractC13042fc3.y("userProfileNavigator");
        return null;
    }

    @Override // ir.nasim.C22042ua0
    public void i9() {
        super.i9();
        ba().Y4();
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle bundle) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, bundle);
        ha();
        ja();
        ga();
        AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new b(null), 3, null);
    }
}
