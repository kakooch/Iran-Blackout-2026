package androidx.compose.ui.platform;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;
import java.text.BreakIterator;
import java.util.Locale;

/* loaded from: classes2.dex */
public class b extends AbstractC1931a {
    public static final a d = new a(null);
    public static final int e = 8;
    private static b f;
    private BreakIterator c;

    public static final class a {
        private a() {
        }

        public final b a(Locale locale) {
            if (b.f == null) {
                b.f = new b(locale, null);
            }
            b bVar = b.f;
            AbstractC13042fc3.g(bVar, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.CharacterTextSegmentIterator");
            return bVar;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ b(Locale locale, ED1 ed1) {
        this(locale);
    }

    private final void i(Locale locale) {
        this.c = BreakIterator.getCharacterInstance(locale);
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
        do {
            BreakIterator breakIterator = this.c;
            if (breakIterator == null) {
                AbstractC13042fc3.y("impl");
                breakIterator = null;
            }
            if (breakIterator.isBoundary(i)) {
                BreakIterator breakIterator2 = this.c;
                if (breakIterator2 == null) {
                    AbstractC13042fc3.y("impl");
                    breakIterator2 = null;
                }
                int iFollowing = breakIterator2.following(i);
                if (iFollowing == -1) {
                    return null;
                }
                return c(i, iFollowing);
            }
            BreakIterator breakIterator3 = this.c;
            if (breakIterator3 == null) {
                AbstractC13042fc3.y("impl");
                breakIterator3 = null;
            }
            i = breakIterator3.following(i);
        } while (i != -1);
        return null;
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
        do {
            BreakIterator breakIterator = this.c;
            if (breakIterator == null) {
                AbstractC13042fc3.y("impl");
                breakIterator = null;
            }
            if (breakIterator.isBoundary(i)) {
                BreakIterator breakIterator2 = this.c;
                if (breakIterator2 == null) {
                    AbstractC13042fc3.y("impl");
                    breakIterator2 = null;
                }
                int iPreceding = breakIterator2.preceding(i);
                if (iPreceding == -1) {
                    return null;
                }
                return c(iPreceding, i);
            }
            BreakIterator breakIterator3 = this.c;
            if (breakIterator3 == null) {
                AbstractC13042fc3.y("impl");
                breakIterator3 = null;
            }
            i = breakIterator3.preceding(i);
        } while (i != -1);
        return null;
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

    private b(Locale locale) {
        i(locale);
    }
}
