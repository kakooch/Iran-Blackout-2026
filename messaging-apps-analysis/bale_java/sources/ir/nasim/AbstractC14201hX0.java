package ir.nasim;

import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: ir.nasim.hX0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC14201hX0 extends AbstractC13610gX0 {
    public static List U(List list) {
        AbstractC13042fc3.i(list, "<this>");
        return new F16(list);
    }

    public static List V(List list) {
        AbstractC13042fc3.i(list, "<this>");
        return new E16(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int W(List list, int i) {
        if (i >= 0 && i <= AbstractC10360bX0.o(list)) {
            return AbstractC10360bX0.o(list) - i;
        }
        throw new IndexOutOfBoundsException("Element index " + i + " must be in range [" + new C24411ya3(0, AbstractC10360bX0.o(list)) + "].");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int X(List list, int i) {
        return AbstractC10360bX0.o(list) - i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int Y(List list, int i) {
        if (i >= 0 && i <= list.size()) {
            return list.size() - i;
        }
        throw new IndexOutOfBoundsException("Position index " + i + " must be in range [" + new C24411ya3(0, list.size()) + "].");
    }
}
