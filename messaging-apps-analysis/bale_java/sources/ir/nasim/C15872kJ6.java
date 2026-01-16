package ir.nasim;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/* renamed from: ir.nasim.kJ6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C15872kJ6 {
    private final ArrayList a;

    public C15872kJ6(int i) {
        this.a = new ArrayList(i);
    }

    public void a(Object obj) {
        this.a.add(obj);
    }

    public void b(Object obj) {
        if (obj == null) {
            return;
        }
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length > 0) {
                ArrayList arrayList = this.a;
                arrayList.ensureCapacity(arrayList.size() + objArr.length);
                Collections.addAll(this.a, objArr);
                return;
            }
            return;
        }
        if (obj instanceof Collection) {
            this.a.addAll((Collection) obj);
            return;
        }
        if (obj instanceof Iterable) {
            Iterator it = ((Iterable) obj).iterator();
            while (it.hasNext()) {
                this.a.add(it.next());
            }
            return;
        }
        if (obj instanceof Iterator) {
            Iterator it2 = (Iterator) obj;
            while (it2.hasNext()) {
                this.a.add(it2.next());
            }
        } else {
            throw new UnsupportedOperationException("Don't know how to spread " + obj.getClass());
        }
    }

    public int c() {
        return this.a.size();
    }

    public Object[] d(Object[] objArr) {
        return this.a.toArray(objArr);
    }
}
