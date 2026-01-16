package ir.nasim;

import android.view.MotionEvent;
import java.util.List;

/* renamed from: ir.nasim.Rb3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C7286Rb3 {
    private final C21892uJ3 a;
    private final C7099Qg5 b;
    private boolean c;

    public C7286Rb3(C21892uJ3 c21892uJ3, C7099Qg5 c7099Qg5) {
        this.a = c21892uJ3;
        this.b = c7099Qg5;
    }

    public final boolean a(long j) {
        Object obj;
        List listB = this.b.b();
        int size = listB.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                obj = null;
                break;
            }
            obj = listB.get(i);
            if (AbstractC6122Mg5.b(((C7333Rg5) obj).d(), j)) {
                break;
            }
            i++;
        }
        C7333Rg5 c7333Rg5 = (C7333Rg5) obj;
        if (c7333Rg5 != null) {
            return c7333Rg5.a();
        }
        return false;
    }

    public final C21892uJ3 b() {
        return this.a;
    }

    public final MotionEvent c() {
        return this.b.a();
    }

    public final boolean d() {
        return this.c;
    }

    public final void e(boolean z) {
        this.c = z;
    }
}
