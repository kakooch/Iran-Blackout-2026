package ir.nasim;

import android.text.Layout;

/* renamed from: ir.nasim.Ok7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C6659Ok7 {
    public static final C6659Ok7 a = new C6659Ok7();
    private static final Layout.Alignment b;
    private static final Layout.Alignment c;

    static {
        Layout.Alignment[] alignmentArrValues = Layout.Alignment.values();
        Layout.Alignment alignment = Layout.Alignment.ALIGN_NORMAL;
        Layout.Alignment alignment2 = alignment;
        for (Layout.Alignment alignment3 : alignmentArrValues) {
            if (AbstractC13042fc3.d(alignment3.name(), "ALIGN_LEFT")) {
                alignment = alignment3;
            } else if (AbstractC13042fc3.d(alignment3.name(), "ALIGN_RIGHT")) {
                alignment2 = alignment3;
            }
        }
        b = alignment;
        c = alignment2;
    }

    private C6659Ok7() {
    }

    public final Layout.Alignment a(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? Layout.Alignment.ALIGN_NORMAL : c : b : Layout.Alignment.ALIGN_CENTER : Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL;
    }
}
