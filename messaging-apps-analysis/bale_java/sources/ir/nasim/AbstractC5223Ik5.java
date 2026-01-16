package ir.nasim;

import android.os.Build;
import android.view.View;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import java.util.Locale;

/* renamed from: ir.nasim.Ik5, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC5223Ik5 {
    private static final a a;

    static {
        String lowerCase = Build.FINGERPRINT.toLowerCase(Locale.ROOT);
        AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
        a = AbstractC13042fc3.d(lowerCase, "robolectric") ? new a() : null;
    }

    public static final InterfaceC4989Hk5 a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(1141871251, i, -1, "androidx.compose.foundation.lazy.layout.rememberDefaultPrefetchScheduler (PrefetchScheduler.android.kt:32)");
        }
        InterfaceC4989Hk5 interfaceC4989Hk5 = a;
        if (interfaceC4989Hk5 != null) {
            interfaceC22053ub1.W(1213893039);
            interfaceC22053ub1.Q();
        } else {
            interfaceC22053ub1.W(1213931944);
            View view = (View) interfaceC22053ub1.H(AndroidCompositionLocals_androidKt.k());
            boolean zV = interfaceC22053ub1.V(view);
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new RunnableC6939Pq(view);
                interfaceC22053ub1.s(objB);
            }
            interfaceC4989Hk5 = (RunnableC6939Pq) objB;
            interfaceC22053ub1.Q();
        }
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return interfaceC4989Hk5;
    }

    /* renamed from: ir.nasim.Ik5$a */
    public static final class a implements InterfaceC4989Hk5 {
        a() {
        }

        @Override // ir.nasim.InterfaceC4989Hk5
        public void a(InterfaceC4506Fk5 interfaceC4506Fk5) {
        }
    }
}
