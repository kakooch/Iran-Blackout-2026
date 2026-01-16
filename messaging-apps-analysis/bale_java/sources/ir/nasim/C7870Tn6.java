package ir.nasim;

import androidx.compose.ui.semantics.SemanticsConfiguration;
import java.util.List;

/* renamed from: ir.nasim.Tn6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C7870Tn6 {
    private final SemanticsConfiguration a;
    private final C17325mm4 b;

    public C7870Tn6(C7631Sn6 c7631Sn6, AbstractC20768sa3 abstractC20768sa3) {
        this.a = c7631Sn6.w();
        this.b = new C17325mm4(c7631Sn6.t().size());
        List listT = c7631Sn6.t();
        int size = listT.size();
        for (int i = 0; i < size; i++) {
            C7631Sn6 c7631Sn62 = (C7631Sn6) listT.get(i);
            if (abstractC20768sa3.a(c7631Sn62.o())) {
                this.b.g(c7631Sn62.o());
            }
        }
    }

    public final C17325mm4 a() {
        return this.b;
    }

    public final SemanticsConfiguration b() {
        return this.a;
    }
}
