package j$.time;

import j$.time.temporal.p;
import j$.time.temporal.q;
import j$.util.Collection;
import j$.util.Comparator;
import j$.util.List;
import j$.util.Optional;
import j$.util.Set;
import j$.util.Spliterator;
import j$.util.function.BiConsumer;
import j$.util.function.Consumer;
import j$.util.o;
import j$.util.r;
import j$.util.stream.C2;
import j$.util.u;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes2.dex */
public /* synthetic */ class a {
    public static /* synthetic */ long A(long j, long j2) {
        long j3 = j / j2;
        return (j - (j2 * j3) != 0 && (((j ^ j2) >> 63) | 1) < 0) ? j3 - 1 : j3;
    }

    public static /* synthetic */ long B(long j, long j2) {
        int iNumberOfLeadingZeros = Long.numberOfLeadingZeros((-1) ^ j2) + Long.numberOfLeadingZeros(j2) + Long.numberOfLeadingZeros(j ^ (-1)) + Long.numberOfLeadingZeros(j);
        if (iNumberOfLeadingZeros > 65) {
            return j * j2;
        }
        if (iNumberOfLeadingZeros >= 64) {
            if ((j >= 0) | (j2 != Long.MIN_VALUE)) {
                long j3 = j * j2;
                if (j == 0 || j3 / j == j2) {
                    return j3;
                }
            }
        }
        throw new ArithmeticException();
    }

    public static /* synthetic */ void C(List list, Comparator comparator) {
        if (list instanceof j$.util.List) {
            ((j$.util.List) list).sort(comparator);
        } else {
            List.CC.$default$sort(list, comparator);
        }
    }

    public static Spliterator D(Collection collection) {
        return collection instanceof j$.util.Collection ? ((j$.util.Collection) collection).spliterator() : collection instanceof LinkedHashSet ? u.m((LinkedHashSet) collection, 17) : collection instanceof SortedSet ? r.d((SortedSet) collection) : collection instanceof Set ? Set.CC.$default$spliterator((java.util.Set) collection) : collection instanceof java.util.List ? List.CC.$default$spliterator((java.util.List) collection) : Collection.CC.$default$spliterator(collection);
    }

    public static /* synthetic */ Comparator E(Comparator comparator, Comparator comparator2) {
        return comparator instanceof j$.util.Comparator ? ((j$.util.Comparator) comparator).thenComparing(comparator2) : Comparator.CC.$default$thenComparing(comparator, comparator2);
    }

    public static void a(C2 c2) {
        throw new IllegalStateException("called wrong accept method");
    }

    public static void b(C2 c2) {
        throw new IllegalStateException("called wrong accept method");
    }

    public static void c(C2 c2) {
        throw new IllegalStateException("called wrong accept method");
    }

    public static int d(j$.time.chrono.c cVar, j$.time.chrono.c cVar2) {
        int iS = cVar.c().compareTo(cVar2.c());
        if (iS != 0) {
            return iS;
        }
        int iT = cVar.b().compareTo(cVar2.b());
        return iT == 0 ? cVar.a().compareTo(cVar2.a()) : iT;
    }

    public static void e(ConcurrentMap concurrentMap, BiConsumer biConsumer) {
        biConsumer.getClass();
        for (Map.Entry entry : concurrentMap.entrySet()) {
            try {
                biConsumer.accept(entry.getKey(), entry.getValue());
            } catch (IllegalStateException unused) {
            }
        }
    }

    public static int f(j$.time.temporal.k kVar, j$.time.temporal.l lVar) {
        q qVarJ = kVar.j(lVar);
        if (!qVarJ.g()) {
            throw new p("Invalid field " + lVar + " for get() method, use getLong() instead");
        }
        long jL = kVar.l(lVar);
        if (qVarJ.h(jL)) {
            return (int) jL;
        }
        throw new c("Invalid value for " + lVar + " (valid values " + qVarJ + "): " + jL);
    }

    public static long g(Spliterator spliterator) {
        if ((spliterator.characteristics() & 64) == 0) {
            return -1L;
        }
        return spliterator.estimateSize();
    }

    public static boolean h(Spliterator spliterator, int i) {
        return (spliterator.characteristics() & i) == i;
    }

    public static Object i(j$.time.chrono.c cVar, j$.time.temporal.n nVar) {
        int i = j$.time.temporal.m.a;
        if (nVar == j$.time.temporal.d.a || nVar == j$.time.temporal.g.a || nVar == j$.time.temporal.c.a) {
            return null;
        }
        return nVar == j$.time.temporal.f.a ? cVar.b() : nVar == j$.time.temporal.b.a ? cVar.a() : nVar == j$.time.temporal.e.a ? j$.time.temporal.i.NANOS : nVar.a(cVar);
    }

    public static Object j(j$.time.temporal.k kVar, j$.time.temporal.n nVar) {
        int i = j$.time.temporal.m.a;
        if (nVar == j$.time.temporal.d.a || nVar == j$.time.temporal.b.a || nVar == j$.time.temporal.e.a) {
            return null;
        }
        return nVar.a(kVar);
    }

    public static q k(j$.time.temporal.k kVar, j$.time.temporal.l lVar) {
        if (!(lVar instanceof j$.time.temporal.h)) {
            if (lVar != null) {
                return lVar.t(kVar);
            }
            throw new NullPointerException("field");
        }
        if (kVar.d(lVar)) {
            return lVar.h();
        }
        throw new p("Unsupported field: " + lVar);
    }

    public static long l(j$.time.chrono.c cVar, m mVar) {
        if (mVar != null) {
            return ((cVar.c().m() * 86400) + cVar.b().C()) - mVar.y();
        }
        throw new NullPointerException("offset");
    }

    public static Optional m(java.util.Optional optional) {
        if (optional == null) {
            return null;
        }
        return optional.isPresent() ? Optional.of(optional.get()) : Optional.empty();
    }

    public static o n(OptionalDouble optionalDouble) {
        if (optionalDouble == null) {
            return null;
        }
        return optionalDouble.isPresent() ? o.d(optionalDouble.getAsDouble()) : o.a();
    }

    public static j$.util.p o(OptionalInt optionalInt) {
        if (optionalInt == null) {
            return null;
        }
        return optionalInt.isPresent() ? j$.util.p.d(optionalInt.getAsInt()) : j$.util.p.a();
    }

    public static j$.util.q p(OptionalLong optionalLong) {
        if (optionalLong == null) {
            return null;
        }
        return optionalLong.isPresent() ? j$.util.q.d(optionalLong.getAsLong()) : j$.util.q.a();
    }

    public static java.util.Optional q(Optional optional) {
        if (optional == null) {
            return null;
        }
        return optional.isPresent() ? java.util.Optional.of(optional.a()) : java.util.Optional.empty();
    }

    public static OptionalDouble r(o oVar) {
        if (oVar == null) {
            return null;
        }
        return oVar.c() ? OptionalDouble.of(oVar.b()) : OptionalDouble.empty();
    }

    public static OptionalInt s(j$.util.p pVar) {
        if (pVar == null) {
            return null;
        }
        return pVar.c() ? OptionalInt.of(pVar.b()) : OptionalInt.empty();
    }

    public static OptionalLong t(j$.util.q qVar) {
        if (qVar == null) {
            return null;
        }
        return qVar.c() ? OptionalLong.of(qVar.b()) : OptionalLong.empty();
    }

    public static void u(java.util.Collection collection, Consumer consumer) {
        if (collection instanceof j$.util.Collection) {
            ((j$.util.Collection) collection).forEach(consumer);
            return;
        }
        consumer.getClass();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            consumer.accept(it.next());
        }
    }

    public static /* synthetic */ int v(int i, int i2) {
        if (i == i2) {
            return 0;
        }
        return i < i2 ? -1 : 1;
    }

    public static /* synthetic */ long w(long j, long j2) {
        long j3 = j + j2;
        if (((j2 ^ j) < 0) || ((j ^ j3) >= 0)) {
            return j3;
        }
        throw new ArithmeticException();
    }

    public static /* synthetic */ Object x(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }

    public static /* synthetic */ boolean y(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static /* synthetic */ long z(long j, long j2) {
        long j3 = j % j2;
        if (j3 == 0) {
            return 0L;
        }
        return (((j ^ j2) >> 63) | 1) > 0 ? j3 : j3 + j2;
    }
}
