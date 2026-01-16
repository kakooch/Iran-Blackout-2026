package ir.nasim;

import android.os.LocaleList;
import android.view.inputmethod.EditorInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes.dex */
public final class KH3 {
    public static final KH3 a = new KH3();

    private KH3() {
    }

    public final void a(EditorInfo editorInfo, IH3 ih3) {
        if (AbstractC13042fc3.d(ih3, IH3.c.b())) {
            editorInfo.hintLocales = null;
            return;
        }
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(ih3, 10));
        Iterator<E> it = ih3.iterator();
        while (it.hasNext()) {
            arrayList.add(((CH3) it.next()).a());
        }
        Locale[] localeArr = (Locale[]) arrayList.toArray(new Locale[0]);
        editorInfo.hintLocales = new LocaleList((Locale[]) Arrays.copyOf(localeArr, localeArr.length));
    }
}
