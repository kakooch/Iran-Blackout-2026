package androidx.compose.ui.platform;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;
import java.text.BreakIterator;
import java.util.Locale;

/* loaded from: classes2.dex */
public final class f extends AbstractC1931a {
    public static final a d = new a(null);
    public static final int e = 8;
    private static f f;
    private BreakIterator c;

    public static final class a {
        private a() {
        }

        public final f a(Locale locale) {
            if (f.f == null) {
                f.f = new f(locale, null);
            }
            f fVar = f.f;
            AbstractC13042fc3.g(fVar, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.WordTextSegmentIterator");
            return fVar;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ f(Locale locale, ED1 ed1) {
        this(locale);
    }

    private final boolean i(int i) {
        return i > 0 && j(i + (-1)) && (i == d().length() || !j(i));
    }

    private final boolean j(int i) {
        if (i < 0 || i >= d().length()) {
            return false;
        }
        return Character.isLetterOrDigit(d().codePointAt(i));
    }

    private final boolean k(int i) {
        return j(i) && (i == 0 || !j(i - 1));
    }

    private final void l(Locale locale) {
        this.c = BreakIterator.getWordInstance(locale);
    }

    @Override // ir.nasim.InterfaceC24683z2
    public int[] a(int i) {
        if (d().length() <= 0 || i >= d().length()) {
            return null;
        }
        if (i < 0) {
            i = 0;
        }
        while (!j(i) && !k(i)) {
            BreakIterator breakIterator = this.c;
            if (breakIterator == null) {
                AbstractC13042fc3.y("impl");
                breakIterator = null;
            }
            i = breakIterator.following(i);
            if (i == -1) {
                return null;
            }
        }
        BreakIterator breakIterator2 = this.c;
        if (breakIterator2 == null) {
            AbstractC13042fc3.y("impl");
            breakIterator2 = null;
        }
        int iFollowing = breakIterator2.following(i);
        if (iFollowing == -1 || !i(iFollowing)) {
            return null;
        }
        return c(i, iFollowing);
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
        while (i > 0 && !j(i - 1) && !i(i)) {
            BreakIterator breakIterator = this.c;
            if (breakIterator == null) {
                AbstractC13042fc3.y("impl");
                breakIterator = null;
            }
            i = breakIterator.preceding(i);
            if (i == -1) {
                return null;
            }
        }
        BreakIterator breakIterator2 = this.c;
        if (breakIterator2 == null) {
            AbstractC13042fc3.y("impl");
            breakIterator2 = null;
        }
        int iPreceding = breakIterator2.preceding(i);
        if (iPreceding == -1 || !k(iPreceding)) {
            return null;
        }
        return c(iPreceding, i);
    }

    @Override // androidx.compose.ui.platform.AbstractC1931a
    public void e(String str) {
        super.e(str);
        BreakIterator breakIterator = this.c;
        if (breakIterator == null) {
            AbstractC13042fc3.y("impl");
            breakIterator = null;
        }
        breakIterator.setText(str);
    }

    private f(Locale locale) {
        l(locale);
    }
}
