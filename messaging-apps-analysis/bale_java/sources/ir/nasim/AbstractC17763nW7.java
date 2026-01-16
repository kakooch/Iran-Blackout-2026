package ir.nasim;

import androidx.compose.ui.platform.AbstractComposeView;
import androidx.lifecycle.j;

/* renamed from: ir.nasim.nW7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC17763nW7 {

    /* renamed from: ir.nasim.nW7$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ androidx.lifecycle.j e;
        final /* synthetic */ androidx.lifecycle.n f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(androidx.lifecycle.j jVar, androidx.lifecycle.n nVar) {
            super(0);
            this.e = jVar;
            this.f = nVar;
        }

        public final void a() {
            this.e.d(this.f);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SA2 c(final AbstractComposeView abstractComposeView, androidx.lifecycle.j jVar) {
        if (jVar.b().compareTo(j.b.DESTROYED) > 0) {
            androidx.lifecycle.n nVar = new androidx.lifecycle.n() { // from class: ir.nasim.mW7
                @Override // androidx.lifecycle.n
                public final void s(InterfaceC18633oz3 interfaceC18633oz3, j.a aVar) {
                    AbstractC17763nW7.d(abstractComposeView, interfaceC18633oz3, aVar);
                }
            };
            jVar.a(nVar);
            return new a(jVar, nVar);
        }
        throw new IllegalStateException(("Cannot configure " + abstractComposeView + " to disposeComposition at Lifecycle ON_DESTROY: " + jVar + "is already destroyed").toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(AbstractComposeView abstractComposeView, InterfaceC18633oz3 interfaceC18633oz3, j.a aVar) {
        if (aVar == j.a.ON_DESTROY) {
            abstractComposeView.h();
        }
    }
}
