package ir.nasim;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.compose.ui.platform.ComposeView;

/* loaded from: classes4.dex */
public abstract class VG5 {

    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC15796kB2 a;

        /* renamed from: ir.nasim.VG5$a$a, reason: collision with other inner class name */
        static final class C0699a implements InterfaceC14603iB2 {
            final /* synthetic */ InterfaceC15796kB2 a;

            C0699a(InterfaceC15796kB2 interfaceC15796kB2) {
                this.a = interfaceC15796kB2;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    double d = 16;
                    this.a.q(AbstractC22050ua8.c(androidx.compose.ui.e.a, AbstractC21393ta8.a(0, 0, (int) ((AbstractC3742Cd6.c() * d) + 0.5d), (int) ((d * AbstractC3742Cd6.c()) + 0.5d))), interfaceC22053ub1, 0);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        a(InterfaceC15796kB2 interfaceC15796kB2) {
            this.a = interfaceC15796kB2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(367137625, true, new C0699a(this.a), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(FrameLayout frameLayout, Context context, InterfaceC15796kB2 interfaceC15796kB2, InterfaceC18633oz3 interfaceC18633oz3) {
        ComposeView composeView = new ComposeView(context, null, 0, 6, null);
        composeView.setContent(AbstractC19242q11.c(882519156, true, new a(interfaceC15796kB2)));
        frameLayout.setId(android.R.id.content);
        frameLayout.setLayoutDirection(JF5.g() ? 1 : 2);
        VX7.b(composeView, interfaceC18633oz3);
        AbstractC13042fc3.g(interfaceC18633oz3, "null cannot be cast to non-null type androidx.savedstate.SavedStateRegistryOwner");
        XX7.b(frameLayout, (InterfaceC7760Tb6) interfaceC18633oz3);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        frameLayout.measure(View.MeasureSpec.makeMeasureSpec(frameLayout.getWidth(), frameLayout.getWidth() <= 0 ? 0 : 1073741824), View.MeasureSpec.makeMeasureSpec(frameLayout.getHeight(), frameLayout.getHeight() <= 0 ? 0 : 1073741824));
        frameLayout.addView(composeView);
    }
}
