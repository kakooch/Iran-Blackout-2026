package ir.nasim;

import androidx.compose.ui.semantics.AppendedSemanticsElement;
import androidx.compose.ui.semantics.ClearAndSetSemanticsElement;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: ir.nasim.Pn6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC6919Pn6 {
    private static AtomicInteger a = new AtomicInteger(0);

    public static final androidx.compose.ui.e a(androidx.compose.ui.e eVar, UA2 ua2) {
        return eVar.i(new ClearAndSetSemanticsElement(ua2));
    }

    public static final int b() {
        return a.addAndGet(1);
    }

    public static final androidx.compose.ui.e c(androidx.compose.ui.e eVar, boolean z, UA2 ua2) {
        return eVar.i(new AppendedSemanticsElement(z, ua2));
    }

    public static /* synthetic */ androidx.compose.ui.e d(androidx.compose.ui.e eVar, boolean z, UA2 ua2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return c(eVar, z, ua2);
    }
}
