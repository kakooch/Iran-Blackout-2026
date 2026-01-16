package ir.nasim;

import android.content.Context;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;

/* renamed from: ir.nasim.w23, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC22917w23 {

    /* renamed from: ir.nasim.w23$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        public static final a e = new a();

        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC18663p23 invoke() {
            return null;
        }
    }

    public static /* synthetic */ AbstractC6535Nx5 b(AbstractC6535Nx5 abstractC6535Nx5, int i, ED1 ed1) {
        if ((i & 1) != 0) {
            abstractC6535Nx5 = AbstractC11024cc1.f(a.e);
        }
        return a(abstractC6535Nx5);
    }

    public static final InterfaceC18663p23 c(AbstractC6535Nx5 abstractC6535Nx5, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-617597678, i, -1, "coil.compose.ImageLoaderProvidableCompositionLocal.<get-current> (LocalImageLoader.kt:49)");
        }
        InterfaceC18663p23 interfaceC18663p23A = (InterfaceC18663p23) interfaceC22053ub1.H(abstractC6535Nx5);
        if (interfaceC18663p23A == null) {
            interfaceC18663p23A = JW0.a((Context) interfaceC22053ub1.H(AndroidCompositionLocals_androidKt.g()));
        }
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return interfaceC18663p23A;
    }

    public static AbstractC6535Nx5 a(AbstractC6535Nx5 abstractC6535Nx5) {
        return abstractC6535Nx5;
    }
}
