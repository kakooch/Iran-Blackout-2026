package ir.nasim;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes8.dex */
public abstract class U1 extends G0 implements Set, InterfaceC17915nm3 {
    public static final a a = new a(null);

    public static final class a {
        private a() {
        }

        public final boolean a(Set set, Set set2) {
            AbstractC13042fc3.i(set, "c");
            AbstractC13042fc3.i(set2, "other");
            if (set.size() != set2.size()) {
                return false;
            }
            return set.containsAll(set2);
        }

        public final int b(Collection collection) {
            AbstractC13042fc3.i(collection, "c");
            Iterator it = collection.iterator();
            int iHashCode = 0;
            while (it.hasNext()) {
                Object next = it.next();
                iHashCode += next != null ? next.hashCode() : 0;
            }
            return iHashCode;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    protected U1() {
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            return a.a(this, (Set) obj);
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return a.b(this);
    }
}
