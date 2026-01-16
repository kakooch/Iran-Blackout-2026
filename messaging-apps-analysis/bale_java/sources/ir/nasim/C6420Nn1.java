package ir.nasim;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: ir.nasim.Nn1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C6420Nn1 implements Iterable {
    private final Object a = new Object();
    private final Map b = new HashMap();
    private Set c = Collections.emptySet();
    private List d = Collections.emptyList();

    public Set W0() {
        Set set;
        synchronized (this.a) {
            set = this.c;
        }
        return set;
    }

    public void f(Object obj) {
        synchronized (this.a) {
            try {
                ArrayList arrayList = new ArrayList(this.d);
                arrayList.add(obj);
                this.d = Collections.unmodifiableList(arrayList);
                Integer num = (Integer) this.b.get(obj);
                if (num == null) {
                    HashSet hashSet = new HashSet(this.c);
                    hashSet.add(obj);
                    this.c = Collections.unmodifiableSet(hashSet);
                }
                this.b.put(obj, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int h(Object obj) {
        int iIntValue;
        synchronized (this.a) {
            try {
                iIntValue = this.b.containsKey(obj) ? ((Integer) this.b.get(obj)).intValue() : 0;
            } catch (Throwable th) {
                throw th;
            }
        }
        return iIntValue;
    }

    public void i(Object obj) {
        synchronized (this.a) {
            try {
                Integer num = (Integer) this.b.get(obj);
                if (num == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList(this.d);
                arrayList.remove(obj);
                this.d = Collections.unmodifiableList(arrayList);
                if (num.intValue() == 1) {
                    this.b.remove(obj);
                    HashSet hashSet = new HashSet(this.c);
                    hashSet.remove(obj);
                    this.c = Collections.unmodifiableSet(hashSet);
                } else {
                    this.b.put(obj, Integer.valueOf(num.intValue() - 1));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        Iterator it;
        synchronized (this.a) {
            it = this.d.iterator();
        }
        return it;
    }
}
