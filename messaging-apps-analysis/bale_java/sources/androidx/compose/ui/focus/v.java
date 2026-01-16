package androidx.compose.ui.focus;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.C12544en4;
import ir.nasim.C3419Au3;
import ir.nasim.KG1;
import java.util.Comparator;

/* loaded from: classes2.dex */
final class v implements Comparator {
    public static final v a = new v();

    private v() {
    }

    private final C12544en4 b(C3419Au3 c3419Au3) {
        C12544en4 c12544en4 = new C12544en4(new C3419Au3[16], 0);
        while (c3419Au3 != null) {
            c12544en4.a(0, c3419Au3);
            c3419Au3 = c3419Au3.A0();
        }
        return c12544en4;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(FocusTargetNode focusTargetNode, FocusTargetNode focusTargetNode2) {
        int i = 0;
        if (!t.g(focusTargetNode) || !t.g(focusTargetNode2)) {
            if (t.g(focusTargetNode)) {
                return -1;
            }
            return t.g(focusTargetNode2) ? 1 : 0;
        }
        C3419Au3 c3419Au3O = KG1.o(focusTargetNode);
        C3419Au3 c3419Au3O2 = KG1.o(focusTargetNode2);
        if (AbstractC13042fc3.d(c3419Au3O, c3419Au3O2)) {
            return 0;
        }
        C12544en4 c12544en4B = b(c3419Au3O);
        C12544en4 c12544en4B2 = b(c3419Au3O2);
        int iMin = Math.min(c12544en4B.o() - 1, c12544en4B2.o() - 1);
        if (iMin >= 0) {
            while (AbstractC13042fc3.d(c12544en4B.a[i], c12544en4B2.a[i])) {
                if (i != iMin) {
                    i++;
                }
            }
            return AbstractC13042fc3.k(((C3419Au3) c12544en4B.a[i]).B0(), ((C3419Au3) c12544en4B2.a[i]).B0());
        }
        throw new IllegalStateException("Could not find a common ancestor between the two FocusModifiers.".toString());
    }
}
