package androidx.compose.ui.input.rotary;

import androidx.compose.ui.e;
import ir.nasim.E46;
import ir.nasim.F46;
import ir.nasim.UA2;

/* loaded from: classes2.dex */
final class b extends e.c implements E46 {
    private UA2 o;
    private UA2 p;

    public b(UA2 ua2, UA2 ua22) {
        this.o = ua2;
        this.p = ua22;
    }

    @Override // ir.nasim.E46
    public boolean M1(F46 f46) {
        UA2 ua2 = this.p;
        if (ua2 != null) {
            return ((Boolean) ua2.invoke(f46)).booleanValue();
        }
        return false;
    }

    @Override // ir.nasim.E46
    public boolean e1(F46 f46) {
        UA2 ua2 = this.o;
        if (ua2 != null) {
            return ((Boolean) ua2.invoke(f46)).booleanValue();
        }
        return false;
    }

    public final void v2(UA2 ua2) {
        this.o = ua2;
    }

    public final void w2(UA2 ua2) {
        this.p = ua2;
    }
}
