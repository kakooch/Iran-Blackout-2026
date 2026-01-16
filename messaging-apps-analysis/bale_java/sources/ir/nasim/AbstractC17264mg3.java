package ir.nasim;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* renamed from: ir.nasim.mg3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC17264mg3 {
    public static boolean a(Iterable iterable, InterfaceC11281ck5 interfaceC11281ck5) {
        return AbstractC17855ng3.b(iterable.iterator(), interfaceC11281ck5);
    }

    public static Object b(Iterable iterable, Object obj) {
        return AbstractC17855ng3.k(iterable.iterator(), obj);
    }

    public static Object c(Iterable iterable) {
        if (!(iterable instanceof List)) {
            return AbstractC17855ng3.i(iterable.iterator());
        }
        List list = (List) iterable;
        if (list.isEmpty()) {
            throw new NoSuchElementException();
        }
        return e(list);
    }

    public static Object d(Iterable iterable, Object obj) {
        if (iterable instanceof Collection) {
            if (((Collection) iterable).isEmpty()) {
                return obj;
            }
            if (iterable instanceof List) {
                return e(AbstractC18170oC3.a(iterable));
            }
        }
        return AbstractC17855ng3.j(iterable.iterator(), obj);
    }

    private static Object e(List list) {
        return list.get(list.size() - 1);
    }

    public static boolean f(Iterable iterable, InterfaceC11281ck5 interfaceC11281ck5) {
        return ((iterable instanceof RandomAccess) && (iterable instanceof List)) ? g((List) iterable, (InterfaceC11281ck5) AbstractC4029Dj5.j(interfaceC11281ck5)) : AbstractC17855ng3.o(iterable.iterator(), interfaceC11281ck5);
    }

    private static boolean g(List list, InterfaceC11281ck5 interfaceC11281ck5) {
        int i = 0;
        int i2 = 0;
        while (i < list.size()) {
            Object obj = list.get(i);
            if (!interfaceC11281ck5.apply(obj)) {
                if (i > i2) {
                    try {
                        list.set(i2, obj);
                    } catch (IllegalArgumentException unused) {
                        h(list, interfaceC11281ck5, i2, i);
                        return true;
                    } catch (UnsupportedOperationException unused2) {
                        h(list, interfaceC11281ck5, i2, i);
                        return true;
                    }
                }
                i2++;
            }
            i++;
        }
        list.subList(i2, list.size()).clear();
        return i != i2;
    }

    private static void h(List list, InterfaceC11281ck5 interfaceC11281ck5, int i, int i2) {
        for (int size = list.size() - 1; size > i2; size--) {
            if (interfaceC11281ck5.apply(list.get(size))) {
                list.remove(size);
            }
        }
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            list.remove(i3);
        }
    }
}
