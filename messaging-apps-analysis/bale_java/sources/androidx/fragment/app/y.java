package androidx.fragment.app;

import android.view.View;
import androidx.transition.C1981d;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.AbstractC9203Yx6;
import ir.nasim.KJ;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class y {
    public static final y a;
    public static final A b;
    public static final A c;

    static {
        y yVar = new y();
        a = yVar;
        b = new z();
        c = yVar.c();
    }

    private y() {
    }

    public static final void a(Fragment fragment, Fragment fragment2, boolean z, KJ kj, boolean z2) {
        AbstractC13042fc3.i(fragment, "inFragment");
        AbstractC13042fc3.i(fragment2, "outFragment");
        AbstractC13042fc3.i(kj, "sharedElements");
        AbstractC9203Yx6 abstractC9203Yx6J5 = z ? fragment2.J5() : fragment.J5();
        if (abstractC9203Yx6J5 != null) {
            ArrayList arrayList = new ArrayList(kj.size());
            Iterator it = kj.entrySet().iterator();
            while (it.hasNext()) {
                arrayList.add((View) ((Map.Entry) it.next()).getValue());
            }
            ArrayList arrayList2 = new ArrayList(kj.size());
            Iterator it2 = kj.entrySet().iterator();
            while (it2.hasNext()) {
                arrayList2.add((String) ((Map.Entry) it2.next()).getKey());
            }
            if (z2) {
                abstractC9203Yx6J5.h(arrayList2, arrayList, null);
            } else {
                abstractC9203Yx6J5.g(arrayList2, arrayList, null);
            }
        }
    }

    public static final String b(KJ kj, String str) {
        AbstractC13042fc3.i(kj, "<this>");
        AbstractC13042fc3.i(str, "value");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : kj.entrySet()) {
            if (AbstractC13042fc3.d(entry.getValue(), str)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add((String) ((Map.Entry) it.next()).getKey());
        }
        return (String) AbstractC15401jX0.s0(arrayList);
    }

    private final A c() {
        try {
            AbstractC13042fc3.g(C1981d.class, "null cannot be cast to non-null type java.lang.Class<androidx.fragment.app.FragmentTransitionImpl>");
            return (A) C1981d.class.getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }

    public static final void d(KJ kj, KJ kj2) {
        AbstractC13042fc3.i(kj, "<this>");
        AbstractC13042fc3.i(kj2, "namedViews");
        int size = kj.size();
        while (true) {
            size--;
            if (-1 >= size) {
                return;
            }
            if (!kj2.containsKey((String) kj.k(size))) {
                kj.i(size);
            }
        }
    }

    public static final void e(List list, int i) {
        AbstractC13042fc3.i(list, "views");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((View) it.next()).setVisibility(i);
        }
    }
}
