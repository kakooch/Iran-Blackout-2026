package ir.nasim;

import android.os.LocaleList;
import android.text.style.LocaleSpan;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes2.dex */
public final class LH3 {
    public static final LH3 a = new LH3();

    private LH3() {
    }

    public final Object a(IH3 ih3) {
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(ih3, 10));
        Iterator<E> it = ih3.iterator();
        while (it.hasNext()) {
            arrayList.add(((CH3) it.next()).a());
        }
        Locale[] localeArr = (Locale[]) arrayList.toArray(new Locale[0]);
        return new LocaleSpan(new LocaleList((Locale[]) Arrays.copyOf(localeArr, localeArr.length)));
    }

    public final void b(C13806gr c13806gr, IH3 ih3) {
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(ih3, 10));
        Iterator<E> it = ih3.iterator();
        while (it.hasNext()) {
            arrayList.add(((CH3) it.next()).a());
        }
        Locale[] localeArr = (Locale[]) arrayList.toArray(new Locale[0]);
        c13806gr.setTextLocales(new LocaleList((Locale[]) Arrays.copyOf(localeArr, localeArr.length)));
    }
}
