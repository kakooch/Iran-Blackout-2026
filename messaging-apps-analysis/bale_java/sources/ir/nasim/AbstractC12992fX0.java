package ir.nasim;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* renamed from: ir.nasim.fX0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
abstract class AbstractC12992fX0 extends AbstractC12383eX0 {
    public static void A(List list) {
        AbstractC13042fc3.i(list, "<this>");
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }

    public static void B(List list, Comparator comparator) {
        AbstractC13042fc3.i(list, "<this>");
        AbstractC13042fc3.i(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}
