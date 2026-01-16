package ir.nasim;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.v;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.G;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.C21854uF1;
import ir.nasim.features.root.AbstractC13089g;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ+\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0017¢\u0006\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001d²\u0006\f\u0010\u001c\u001a\u00020\u001b8\nX\u008a\u0084\u0002"}, d2 = {"Lir/nasim/uF1;", "Lir/nasim/ua0;", "<init>", "()V", "Lir/nasim/oF1;", "Y9", "()Lir/nasim/oF1;", "", "tabIndex", "Lir/nasim/rB7;", "ca", "(I)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Lir/nasim/BF1;", "h1", "Lir/nasim/Yu3;", "X9", "()Lir/nasim/BF1;", "viewModel", "Lir/nasim/AF1;", "state", "settings_productionRelease"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.uF1, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C21854uF1 extends AbstractC20122rW2 {

    /* renamed from: h1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;

    /* renamed from: ir.nasim.uF1$a */
    static final class a implements InterfaceC14603iB2 {

        /* renamed from: ir.nasim.uF1$a$a, reason: collision with other inner class name */
        static final class C1628a implements InterfaceC14603iB2 {
            final /* synthetic */ C21854uF1 a;

            C1628a(C21854uF1 c21854uF1) {
                this.a = c21854uF1;
            }

            private static final AF1 d(InterfaceC9664aL6 interfaceC9664aL6) {
                return (AF1) interfaceC9664aL6.getValue();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 f(C21854uF1 c21854uF1) {
                AbstractC13042fc3.i(c21854uF1, "this$0");
                c21854uF1.Q7().onBackPressed();
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 h(C21854uF1 c21854uF1) {
                AbstractC13042fc3.i(c21854uF1, "this$0");
                c21854uF1.X9().T0();
                return C19938rB7.a;
            }

            public final void c(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                AF1 af1D = d(AbstractC5976Lq2.c(this.a.X9().S0(), null, null, null, interfaceC22053ub1, 0, 7));
                interfaceC22053ub1.W(1809051118);
                boolean zD = interfaceC22053ub1.D(this.a);
                final C21854uF1 c21854uF1 = this.a;
                Object objB = interfaceC22053ub1.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    objB = new SA2() { // from class: ir.nasim.sF1
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C21854uF1.a.C1628a.f(c21854uF1);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                SA2 sa2 = (SA2) objB;
                interfaceC22053ub1.Q();
                C18195oF1 c18195oF1Y9 = this.a.Y9();
                interfaceC22053ub1.W(1809057178);
                boolean zD2 = interfaceC22053ub1.D(this.a);
                final C21854uF1 c21854uF12 = this.a;
                Object objB2 = interfaceC22053ub1.B();
                if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                    objB2 = new SA2() { // from class: ir.nasim.tF1
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C21854uF1.a.C1628a.h(c21854uF12);
                        }
                    };
                    interfaceC22053ub1.s(objB2);
                }
                interfaceC22053ub1.Q();
                AbstractC24220yF1.e(af1D, sa2, c18195oF1Y9, (SA2) objB2, interfaceC22053ub1, 0);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        a() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(-1231896905, true, new C1628a(C21854uF1.this), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.uF1$b */
    public static final class b extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Fragment invoke() {
            return this.e;
        }
    }

    /* renamed from: ir.nasim.uF1$c */
    public static final class c extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return (InterfaceC15408jX7) this.e.invoke();
        }
    }

    /* renamed from: ir.nasim.uF1$d */
    public static final class d extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9173Yu3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return AbstractC6550Nz2.c(this.e).d1();
        }
    }

    /* renamed from: ir.nasim.uF1$e */
    public static final class e extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(SA2 sa2, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    /* renamed from: ir.nasim.uF1$f */
    public static final class f extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Fragment fragment, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    public C21854uF1() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new c(new b(this)));
        this.viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(BF1.class), new d(interfaceC9173Yu3B), new e(null, interfaceC9173Yu3B), new f(this, interfaceC9173Yu3B));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BF1 X9() {
        return (BF1) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C18195oF1 Y9() {
        return new C18195oF1(new SA2() { // from class: ir.nasim.pF1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C21854uF1.Z9(this.a);
            }
        }, new SA2() { // from class: ir.nasim.qF1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C21854uF1.aa(this.a);
            }
        }, new SA2() { // from class: ir.nasim.rF1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C21854uF1.ba(this.a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Z9(C21854uF1 c21854uF1) {
        AbstractC13042fc3.i(c21854uF1, "this$0");
        BF1 bf1X9 = c21854uF1.X9();
        EnumC15002iq4 enumC15002iq4 = EnumC15002iq4.b;
        String strH6 = c21854uF1.h6(QD5.tab_title_chat);
        AbstractC13042fc3.h(strH6, "getString(...)");
        bf1X9.U0(enumC15002iq4, strH6);
        c21854uF1.ca(enumC15002iq4.ordinal());
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 aa(C21854uF1 c21854uF1) {
        AbstractC13042fc3.i(c21854uF1, "this$0");
        BF1 bf1X9 = c21854uF1.X9();
        EnumC15002iq4 enumC15002iq4 = EnumC15002iq4.c;
        String strH6 = c21854uF1.h6(QD5.jaryan);
        AbstractC13042fc3.h(strH6, "getString(...)");
        bf1X9.U0(enumC15002iq4, strH6);
        c21854uF1.ca(enumC15002iq4.ordinal());
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ba(C21854uF1 c21854uF1) {
        AbstractC13042fc3.i(c21854uF1, "this$0");
        BF1 bf1X9 = c21854uF1.X9();
        EnumC15002iq4 enumC15002iq4 = EnumC15002iq4.d;
        String strH6 = c21854uF1.h6(QD5.tab_title_khadamat);
        AbstractC13042fc3.h(strH6, "getString(...)");
        bf1X9.U0(enumC15002iq4, strH6);
        c21854uF1.ca(enumC15002iq4.ordinal());
        return C19938rB7.a;
    }

    private final void ca(int tabIndex) {
        AbstractC13089g abstractC13089gK = C5735Kp4.w().k();
        AbstractC13042fc3.h(abstractC13089gK, "getRootFragment(...)");
        abstractC13089gK.ma(tabIndex);
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        ComposeView composeView = new ComposeView(contextS7, null, 0, 6, null);
        composeView.setViewCompositionStrategy(v.d.b);
        composeView.setContent(AbstractC19242q11.c(-1432457774, true, new a()));
        return composeView;
    }
}
