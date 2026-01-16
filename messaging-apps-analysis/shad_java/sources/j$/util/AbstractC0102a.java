package j$.util;

import j$.util.function.Consumer;
import j$.util.stream.AbstractC0202o1;
import j$.util.stream.InterfaceC0127b4;
import j$.util.t;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.Set;
import java.util.SortedSet;

/* renamed from: j$.util.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract /* synthetic */ class AbstractC0102a {
    public static void a(Collection collection, Consumer consumer) {
        consumer.getClass();
        java.util.Iterator it = collection.iterator();
        while (it.hasNext()) {
            consumer.accept(it.next());
        }
    }

    public static void b(t.a aVar, Consumer consumer) {
        if (consumer instanceof j$.util.function.f) {
            aVar.e((j$.util.function.f) consumer);
        } else {
            if (L.a) {
                L.a(aVar.getClass(), "{0} calling Spliterator.OfDouble.forEachRemaining((DoubleConsumer) action::accept)");
                throw null;
            }
            consumer.getClass();
            aVar.e(new m(consumer));
        }
    }

    public static void c(t.b bVar, Consumer consumer) {
        if (consumer instanceof j$.util.function.l) {
            bVar.e((j$.util.function.l) consumer);
        } else {
            if (L.a) {
                L.a(bVar.getClass(), "{0} calling Spliterator.OfInt.forEachRemaining((IntConsumer) action::accept)");
                throw null;
            }
            consumer.getClass();
            bVar.e(new o(consumer));
        }
    }

    public static void d(t.c cVar, Consumer consumer) {
        if (consumer instanceof j$.util.function.q) {
            cVar.e((j$.util.function.q) consumer);
        } else {
            if (L.a) {
                L.a(cVar.getClass(), "{0} calling Spliterator.OfLong.forEachRemaining((LongConsumer) action::accept)");
                throw null;
            }
            consumer.getClass();
            cVar.e(new q(consumer));
        }
    }

    public static long e(t tVar) {
        if ((tVar.characteristics() & 64) == 0) {
            return -1L;
        }
        return tVar.estimateSize();
    }

    public static boolean f(t tVar, int i) {
        return (tVar.characteristics() & i) == i;
    }

    public static InterfaceC0127b4 g(Collection collection) {
        return AbstractC0202o1.y(x(collection), true);
    }

    public static boolean h(Collection collection, j$.util.function.y yVar) {
        if (DesugarCollections.a.isInstance(collection)) {
            return DesugarCollections.d(collection, yVar);
        }
        yVar.getClass();
        boolean z = false;
        java.util.Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (yVar.test(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public static InterfaceC0127b4 i(Collection collection) {
        return AbstractC0202o1.y(x(collection), false);
    }

    public static boolean j(t.a aVar, Consumer consumer) {
        if (consumer instanceof j$.util.function.f) {
            return aVar.j((j$.util.function.f) consumer);
        }
        if (L.a) {
            L.a(aVar.getClass(), "{0} calling Spliterator.OfDouble.tryAdvance((DoubleConsumer) action::accept)");
            throw null;
        }
        consumer.getClass();
        return aVar.j(new m(consumer));
    }

    public static boolean k(t.b bVar, Consumer consumer) {
        if (consumer instanceof j$.util.function.l) {
            return bVar.j((j$.util.function.l) consumer);
        }
        if (L.a) {
            L.a(bVar.getClass(), "{0} calling Spliterator.OfInt.tryAdvance((IntConsumer) action::accept)");
            throw null;
        }
        consumer.getClass();
        return bVar.j(new o(consumer));
    }

    public static boolean l(t.c cVar, Consumer consumer) {
        if (consumer instanceof j$.util.function.q) {
            return cVar.j((j$.util.function.q) consumer);
        }
        if (L.a) {
            L.a(cVar.getClass(), "{0} calling Spliterator.OfLong.tryAdvance((LongConsumer) action::accept)");
            throw null;
        }
        consumer.getClass();
        return cVar.j(new q(consumer));
    }

    public static Optional m(java.util.Optional optional) {
        if (optional == null) {
            return null;
        }
        return optional.isPresent() ? Optional.of(optional.get()) : Optional.empty();
    }

    public static C0113j n(OptionalDouble optionalDouble) {
        if (optionalDouble == null) {
            return null;
        }
        return optionalDouble.isPresent() ? C0113j.d(optionalDouble.getAsDouble()) : C0113j.a();
    }

    public static C0114k o(OptionalInt optionalInt) {
        if (optionalInt == null) {
            return null;
        }
        return optionalInt.isPresent() ? C0114k.d(optionalInt.getAsInt()) : C0114k.a();
    }

    public static C0115l p(OptionalLong optionalLong) {
        if (optionalLong == null) {
            return null;
        }
        return optionalLong.isPresent() ? C0115l.d(optionalLong.getAsLong()) : C0115l.a();
    }

    public static java.util.Optional q(Optional optional) {
        if (optional == null) {
            return null;
        }
        return optional.isPresent() ? java.util.Optional.of(optional.get()) : java.util.Optional.empty();
    }

    public static OptionalDouble r(C0113j c0113j) {
        if (c0113j == null) {
            return null;
        }
        return c0113j.c() ? OptionalDouble.of(c0113j.b()) : OptionalDouble.empty();
    }

    public static OptionalInt s(C0114k c0114k) {
        if (c0114k == null) {
            return null;
        }
        return c0114k.c() ? OptionalInt.of(c0114k.b()) : OptionalInt.empty();
    }

    public static OptionalLong t(C0115l c0115l) {
        if (c0115l == null) {
            return null;
        }
        return c0115l.c() ? OptionalLong.of(c0115l.b()) : OptionalLong.empty();
    }

    public static boolean u(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static /* synthetic */ void v(Collection collection, Consumer consumer) {
        if (collection instanceof InterfaceC0103b) {
            ((InterfaceC0103b) collection).a(consumer);
        } else {
            a(collection, consumer);
        }
    }

    public static Object w(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }

    public static t x(Collection collection) {
        if (collection instanceof InterfaceC0103b) {
            return ((InterfaceC0103b) collection).spliterator();
        }
        if (collection instanceof LinkedHashSet) {
            LinkedHashSet linkedHashSet = (LinkedHashSet) collection;
            linkedHashSet.getClass();
            return new H(linkedHashSet, 17);
        }
        if (collection instanceof SortedSet) {
            SortedSet sortedSet = (SortedSet) collection;
            return new s(sortedSet, sortedSet, 21);
        }
        if (collection instanceof Set) {
            Set set = (Set) collection;
            set.getClass();
            return new H(set, 1);
        }
        if (!(collection instanceof List)) {
            collection.getClass();
            return new H(collection, 0);
        }
        List list = (List) collection;
        list.getClass();
        return new H(list, 16);
    }

    public static Comparator y(Comparator comparator, Comparator comparator2) {
        if (comparator instanceof InterfaceC0106e) {
            return ((EnumC0107f) ((InterfaceC0106e) comparator)).thenComparing(comparator2);
        }
        comparator2.getClass();
        return new C0104c(comparator, comparator2);
    }
}
