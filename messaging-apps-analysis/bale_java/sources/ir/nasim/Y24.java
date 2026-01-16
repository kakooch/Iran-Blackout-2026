package ir.nasim;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes8.dex */
public abstract class Y24 {
    public static final Set a(Iterable iterable) {
        AbstractC13042fc3.i(iterable, "<this>");
        HashSet hashSet = new HashSet();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            Set setG = ((W24) it.next()).g();
            if (setG == null) {
                return null;
            }
            AbstractC13610gX0.D(hashSet, setG);
        }
        return hashSet;
    }
}
