package ir.nasim;

import java.util.Comparator;

/* renamed from: ir.nasim.mI1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC17040mI1 {
    private static final Comparator a = new a();

    /* renamed from: ir.nasim.mI1$a */
    public static final class a implements Comparator {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C3419Au3 c3419Au3, C3419Au3 c3419Au32) {
            int iK = AbstractC13042fc3.k(c3419Au3.U(), c3419Au32.U());
            return iK != 0 ? iK : AbstractC13042fc3.k(c3419Au3.hashCode(), c3419Au32.hashCode());
        }
    }
}
