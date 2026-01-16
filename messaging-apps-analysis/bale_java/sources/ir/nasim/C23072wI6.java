package ir.nasim;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* renamed from: ir.nasim.wI6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C23072wI6 {
    public static final C23072wI6 a = new C23072wI6();
    private static final Set b;

    static {
        List listP = AbstractC10360bX0.p(AbstractC24521yl3.a, AbstractC24521yl3.i, AbstractC24521yl3.j, AbstractC24521yl3.d, AbstractC24521yl3.e, AbstractC24521yl3.g);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = listP.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(C24948zU0.m((C9424Zw2) it.next()));
        }
        b = linkedHashSet;
    }

    private C23072wI6() {
    }

    public final Set a() {
        return b;
    }
}
