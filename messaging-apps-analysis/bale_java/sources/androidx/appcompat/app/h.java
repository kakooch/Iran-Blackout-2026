package androidx.appcompat.app;

import ir.nasim.JH3;
import java.util.LinkedHashSet;
import java.util.Locale;

/* loaded from: classes.dex */
abstract class h {
    private static JH3 a(JH3 jh3, JH3 jh32) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int i = 0;
        while (i < jh3.f() + jh32.f()) {
            Locale localeC = i < jh3.f() ? jh3.c(i) : jh32.c(i - jh3.f());
            if (localeC != null) {
                linkedHashSet.add(localeC);
            }
            i++;
        }
        return JH3.a((Locale[]) linkedHashSet.toArray(new Locale[linkedHashSet.size()]));
    }

    static JH3 b(JH3 jh3, JH3 jh32) {
        return (jh3 == null || jh3.e()) ? JH3.d() : a(jh3, jh32);
    }
}
