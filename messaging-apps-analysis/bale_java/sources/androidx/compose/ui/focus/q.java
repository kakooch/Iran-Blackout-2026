package androidx.compose.ui.focus;

import ir.nasim.InterfaceC5517Jr2;
import ir.nasim.JG1;

/* loaded from: classes2.dex */
public interface q extends JG1 {
    static /* synthetic */ boolean p0(q qVar, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestFocus-3ESFkO8");
        }
        if ((i2 & 1) != 0) {
            i = d.b.b();
        }
        return qVar.M(i);
    }

    boolean M(int i);

    InterfaceC5517Jr2 W();
}
