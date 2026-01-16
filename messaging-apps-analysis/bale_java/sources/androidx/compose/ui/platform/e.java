package androidx.compose.ui.platform;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;

/* loaded from: classes2.dex */
public final class e extends AbstractC1931a {
    public static final a c = new a(null);
    private static e d;

    public static final class a {
        private a() {
        }

        public final e a() {
            if (e.d == null) {
                e.d = new e(null);
            }
            e eVar = e.d;
            AbstractC13042fc3.g(eVar, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.ParagraphTextSegmentIterator");
            return eVar;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ e(ED1 ed1) {
        this();
    }

    private final boolean i(int i) {
        return i > 0 && d().charAt(i + (-1)) != '\n' && (i == d().length() || d().charAt(i) == '\n');
    }

    private final boolean j(int i) {
        return d().charAt(i) != '\n' && (i == 0 || d().charAt(i - 1) == '\n');
    }

    @Override // ir.nasim.InterfaceC24683z2
    public int[] a(int i) {
        int length = d().length();
        if (length <= 0 || i >= length) {
            return null;
        }
        if (i < 0) {
            i = 0;
        }
        while (i < length && d().charAt(i) == '\n' && !j(i)) {
            i++;
        }
        if (i >= length) {
            return null;
        }
        int i2 = i + 1;
        while (i2 < length && !i(i2)) {
            i2++;
        }
        return c(i, i2);
    }

    @Override // ir.nasim.InterfaceC24683z2
    public int[] b(int i) {
        int length = d().length();
        if (length <= 0 || i <= 0) {
            return null;
        }
        if (i > length) {
            i = length;
        }
        while (i > 0 && d().charAt(i - 1) == '\n' && !i(i)) {
            i--;
        }
        if (i <= 0) {
            return null;
        }
        int i2 = i - 1;
        while (i2 > 0 && !j(i2)) {
            i2--;
        }
        return c(i2, i);
    }

    private e() {
    }
}
