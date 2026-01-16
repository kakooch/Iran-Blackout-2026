package ir.nasim;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.v;
import ir.nasim.C11577dF;
import ir.nasim.designsystem.BackgroundPreviewViewGlide;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lir/nasim/dF;", "Lir/nasim/ua0;", "<init>", "()V", "Lir/nasim/fF;", "X9", "()Lir/nasim/fF;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "settings_productionRelease"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.dF, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C11577dF extends MV2 {

    /* renamed from: ir.nasim.dF$a */
    static final class a implements InterfaceC14603iB2 {

        /* renamed from: ir.nasim.dF$a$a, reason: collision with other inner class name */
        static final class C1003a implements InterfaceC14603iB2 {
            final /* synthetic */ C11577dF a;

            C1003a(C11577dF c11577dF) {
                this.a = c11577dF;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 c(C11577dF c11577dF) {
                AbstractC13042fc3.i(c11577dF, "this$0");
                c11577dF.Q7().onBackPressed();
                return C19938rB7.a;
            }

            public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                interfaceC22053ub1.W(-31697604);
                boolean zV = interfaceC22053ub1.V(this.a);
                final C11577dF c11577dF = this.a;
                Object objB = interfaceC22053ub1.B();
                if (zV || objB == InterfaceC22053ub1.a.a()) {
                    objB = new SA2() { // from class: ir.nasim.cF
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C11577dF.a.C1003a.c(c11577dF);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                interfaceC22053ub1.Q();
                AbstractC14640iF.c((SA2) objB, this.a.X9(), interfaceC22053ub1, 0);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        a() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(-795790075, true, new C1003a(C11577dF.this), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C12829fF X9() {
        return new C12829fF(new SA2() { // from class: ir.nasim.YE
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C11577dF.Y9(this.a);
            }
        }, new SA2() { // from class: ir.nasim.ZE
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C11577dF.Z9(this.a);
            }
        }, new SA2() { // from class: ir.nasim.aF
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C11577dF.aa(this.a);
            }
        }, new SA2() { // from class: ir.nasim.bF
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C11577dF.ba(this.a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Y9(C11577dF c11577dF) {
        AbstractC13042fc3.i(c11577dF, "this$0");
        C22042ua0.A9(c11577dF, new JP1(), false, null, 6, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Z9(C11577dF c11577dF) {
        AbstractC13042fc3.i(c11577dF, "this$0");
        C22042ua0.A9(c11577dF, new D74(), false, null, 6, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 aa(C11577dF c11577dF) {
        AbstractC13042fc3.i(c11577dF, "this$0");
        C11038cd5 c11038cd5Ba = C11038cd5.ba(BackgroundPreviewViewGlide.getSelectedBackgroundIndex());
        AbstractC13042fc3.h(c11038cd5Ba, "chooseWallpaper(...)");
        C22042ua0.A9(c11577dF, c11038cd5Ba, false, null, 6, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ba(C11577dF c11577dF) {
        AbstractC13042fc3.i(c11577dF, "this$0");
        C22042ua0.A9(c11577dF, new KD(), false, null, 6, null);
        return C19938rB7.a;
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        ComposeView composeView = new ComposeView(contextS7, null, 0, 6, null);
        composeView.setViewCompositionStrategy(v.d.b);
        composeView.setContent(AbstractC19242q11.c(1576757578, true, new a()));
        return composeView;
    }
}
