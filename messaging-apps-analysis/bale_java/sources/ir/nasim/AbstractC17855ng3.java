package ir.nasim;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: ir.nasim.ng3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC17855ng3 {

    /* renamed from: ir.nasim.ng3$a */
    class a extends X0 {
        final /* synthetic */ Iterator c;
        final /* synthetic */ InterfaceC11281ck5 d;

        a(Iterator it, InterfaceC11281ck5 interfaceC11281ck5) {
            this.c = it;
            this.d = interfaceC11281ck5;
        }

        @Override // ir.nasim.X0
        protected Object a() {
            while (this.c.hasNext()) {
                Object next = this.c.next();
                if (this.d.apply(next)) {
                    return next;
                }
            }
            return b();
        }
    }

    /* renamed from: ir.nasim.ng3$b */
    class b extends DB7 {
        boolean a;
        final /* synthetic */ Object b;

        b(Object obj) {
            this.b = obj;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.a;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (this.a) {
                throw new NoSuchElementException();
            }
            this.a = true;
            return this.b;
        }
    }

    /* renamed from: ir.nasim.ng3$c */
    private enum c implements Iterator {
        INSTANCE;

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            MW0.c(false);
        }
    }

    public static boolean a(Collection collection, Iterator it) {
        AbstractC4029Dj5.j(collection);
        AbstractC4029Dj5.j(it);
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= collection.add(it.next());
        }
        return zAdd;
    }

    public static boolean b(Iterator it, InterfaceC11281ck5 interfaceC11281ck5) {
        return l(it, interfaceC11281ck5) != -1;
    }

    static void c(Iterator it) {
        AbstractC4029Dj5.j(it);
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    public static boolean d(Iterator it, Object obj) {
        if (obj == null) {
            while (it.hasNext()) {
                if (it.next() == null) {
                    return true;
                }
            }
            return false;
        }
        while (it.hasNext()) {
            if (obj.equals(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean e(Iterator it, Iterator it2) {
        while (it.hasNext()) {
            if (!it2.hasNext() || !EG4.a(it.next(), it2.next())) {
                return false;
            }
        }
        return !it2.hasNext();
    }

    static Iterator f() {
        return c.INSTANCE;
    }

    public static DB7 g(Iterator it, InterfaceC11281ck5 interfaceC11281ck5) {
        AbstractC4029Dj5.j(it);
        AbstractC4029Dj5.j(interfaceC11281ck5);
        return new a(it, interfaceC11281ck5);
    }

    public static Object h(Iterator it, InterfaceC11281ck5 interfaceC11281ck5) {
        AbstractC4029Dj5.j(it);
        AbstractC4029Dj5.j(interfaceC11281ck5);
        while (it.hasNext()) {
            Object next = it.next();
            if (interfaceC11281ck5.apply(next)) {
                return next;
            }
        }
        throw new NoSuchElementException();
    }

    public static Object i(Iterator it) {
        Object next;
        do {
            next = it.next();
        } while (it.hasNext());
        return next;
    }

    public static Object j(Iterator it, Object obj) {
        return it.hasNext() ? i(it) : obj;
    }

    public static Object k(Iterator it, Object obj) {
        return it.hasNext() ? it.next() : obj;
    }

    public static int l(Iterator it, InterfaceC11281ck5 interfaceC11281ck5) {
        AbstractC4029Dj5.k(interfaceC11281ck5, "predicate");
        int i = 0;
        while (it.hasNext()) {
            if (interfaceC11281ck5.apply(it.next())) {
                return i;
            }
            i++;
        }
        return -1;
    }

    static Object m(Iterator it) {
        if (!it.hasNext()) {
            return null;
        }
        Object next = it.next();
        it.remove();
        return next;
    }

    public static boolean n(Iterator it, Collection collection) {
        AbstractC4029Dj5.j(collection);
        boolean z = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public static boolean o(Iterator it, InterfaceC11281ck5 interfaceC11281ck5) {
        AbstractC4029Dj5.j(interfaceC11281ck5);
        boolean z = false;
        while (it.hasNext()) {
            if (interfaceC11281ck5.apply(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public static DB7 p(Object obj) {
        return new b(obj);
    }
}
