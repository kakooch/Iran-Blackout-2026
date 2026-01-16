package ir.nasim;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.v;
import androidx.fragment.app.FragmentActivity;
import ir.nasim.A98;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.MX7;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lir/nasim/MX7;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "Landroid/os/Bundle;", "bundle", "Lir/nasim/rB7;", "w8", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroidx/compose/ui/platform/ComposeView;", "x8", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroidx/compose/ui/platform/ComposeView;", "b1", "a", "ui_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class MX7 extends AbstractC10397bY2 {

    /* renamed from: b1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: ir.nasim.MX7$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ MX7 b(Companion companion, String str, LX7 lx7, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            return companion.a(str, lx7);
        }

        public final MX7 a(String str, LX7 lx7) {
            AbstractC13042fc3.i(lx7, "content");
            MX7 mx7 = new MX7();
            mx7.a8(AbstractC23348wm0.b(AbstractC4616Fw7.a("CONTENT_ARG", lx7), AbstractC4616Fw7.a("NOTIFIER_KEY_ARG", str)));
            return mx7;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    static final class b implements InterfaceC14603iB2 {
        final /* synthetic */ LX7 a;
        final /* synthetic */ MX7 b;

        /* synthetic */ class a extends EB2 implements SA2 {
            a(Object obj) {
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

        b(LX7 lx7, MX7 mx7) {
            this.a = lx7;
            this.b = mx7;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(MX7 mx7, Bundle bundle) {
            AbstractC13042fc3.i(mx7, "this$0");
            AbstractC13042fc3.i(bundle, "bundle");
            mx7.w8(bundle);
            return C19938rB7.a;
        }

        public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            androidx.compose.ui.e eVarF = androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null);
            A98.a aVar = A98.a;
            androidx.compose.ui.e eVarC = AbstractC22050ua8.c(AbstractC22050ua8.c(AbstractC22050ua8.c(eVarF, AbstractC24416ya8.f(aVar, interfaceC22053ub1, 6)), AbstractC24416ya8.c(aVar, interfaceC22053ub1, 6)), AbstractC24416ya8.b(aVar, interfaceC22053ub1, 6));
            LX7 lx7 = this.a;
            final MX7 mx7 = this.b;
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(InterfaceC12529em.a.o(), false);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarC);
            InterfaceC16030kb1.a aVar2 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar2.a();
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar2.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
            androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
            Object objQ7 = mx7.Q7();
            interfaceC22053ub1.W(1225697530);
            boolean zD = interfaceC22053ub1.D(objQ7);
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new a(objQ7);
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            SA2 sa2 = (SA2) ((InterfaceC16733lm3) objB);
            interfaceC22053ub1.W(1225700208);
            boolean zV = interfaceC22053ub1.V(mx7);
            Object objB2 = interfaceC22053ub1.B();
            if (zV || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new UA2() { // from class: ir.nasim.NX7
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return MX7.b.c(mx7, (Bundle) obj);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            lx7.I(sa2, (UA2) objB2, interfaceC22053ub1, 0);
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w8(Bundle bundle) {
        Object serializable;
        if (Build.VERSION.SDK_INT >= 33) {
            serializable = R7().getSerializable("NOTIFIER_KEY_ARG", String.class);
        } else {
            Object obj = R7().get("NOTIFIER_KEY_ARG");
            if (!(obj instanceof String)) {
                obj = null;
            }
            serializable = (String) obj;
        }
        String str = (String) serializable;
        if (str == null) {
            return;
        }
        V5().G1(str, bundle);
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: x8, reason: merged with bridge method [inline-methods] */
    public ComposeView Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Object serializable;
        AbstractC13042fc3.i(inflater, "inflater");
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        ComposeView composeView = new ComposeView(contextS7, null, 0, 6, null);
        if (Build.VERSION.SDK_INT >= 33) {
            serializable = R7().getSerializable("CONTENT_ARG", LX7.class);
        } else {
            Object obj = R7().get("CONTENT_ARG");
            if (!(obj instanceof LX7)) {
                obj = null;
            }
            serializable = (LX7) obj;
        }
        AbstractC13042fc3.f(serializable);
        LX7 lx7 = (LX7) serializable;
        composeView.setLayoutParams(lx7.o());
        composeView.setViewCompositionStrategy(v.d.b);
        composeView.setContent(AbstractC19242q11.c(873642438, true, new b(lx7, this)));
        return composeView;
    }
}
