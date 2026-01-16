package ir.nasim;

import android.text.TextUtils;

/* loaded from: classes7.dex */
public abstract class LI7 {
    public static String a(AbstractC19652qi7 abstractC19652qi7) {
        return b(abstractC19652qi7, true);
    }

    public static String b(AbstractC19652qi7 abstractC19652qi7, boolean z) {
        if (abstractC19652qi7 == null || f(abstractC19652qi7)) {
            return "DELETED";
        }
        String str = abstractC19652qi7.c;
        if (TextUtils.isEmpty(str)) {
            str = abstractC19652qi7.d;
        } else if (!z && str.length() <= 2) {
            return AbstractC4007Dh1.h(abstractC19652qi7.c, abstractC19652qi7.d);
        }
        return !TextUtils.isEmpty(str) ? str : FH3.E("HiddenName", TD5.tgwidget_HiddenName);
    }

    public static String c(AbstractC19652qi7 abstractC19652qi7) {
        return d(abstractC19652qi7, false);
    }

    public static String d(AbstractC19652qi7 abstractC19652qi7, boolean z) {
        if (abstractC19652qi7 == null) {
            return null;
        }
        if (!TextUtils.isEmpty(abstractC19652qi7.e)) {
            return abstractC19652qi7.e;
        }
        if (abstractC19652qi7.O != null) {
            for (int i = 0; i < abstractC19652qi7.O.size(); i++) {
                C4730Gh7 c4730Gh7 = (C4730Gh7) abstractC19652qi7.O.get(i);
                if (c4730Gh7 != null && (((c4730Gh7.d && !z) || c4730Gh7.c) && !TextUtils.isEmpty(c4730Gh7.e))) {
                    return c4730Gh7.e;
                }
            }
        }
        return null;
    }

    public static String e(AbstractC19652qi7 abstractC19652qi7) {
        return "USERNAME";
    }

    public static boolean f(AbstractC19652qi7 abstractC19652qi7) {
        return abstractC19652qi7 == null || (abstractC19652qi7 instanceof C9870ah7) || (abstractC19652qi7 instanceof C11080ch7) || abstractC19652qi7.o;
    }

    public static boolean g(AbstractC19652qi7 abstractC19652qi7) {
        return abstractC19652qi7 != null && ((abstractC19652qi7 instanceof C19642qh7) || abstractC19652qi7.l);
    }
}
