package ir.nasim;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: ir.nasim.jX0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC15401jX0 extends AbstractC14812iX0 {

    /* renamed from: ir.nasim.jX0$a */
    public static final class a implements InterfaceC23384wp6 {
        final /* synthetic */ Iterable a;

        public a(Iterable iterable) {
            this.a = iterable;
        }

        @Override // ir.nasim.InterfaceC23384wp6
        public Iterator iterator() {
            return this.a.iterator();
        }
    }

    /* renamed from: ir.nasim.jX0$b */
    static final class b extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Iterable e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Iterable iterable) {
            super(0);
            this.e = iterable;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Iterator invoke() {
            return this.e.iterator();
        }
    }

    public static /* synthetic */ String A0(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, UA2 ua2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i2 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i2 & 4) == 0 ? charSequence3 : "";
        if ((i2 & 8) != 0) {
            i = -1;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i2 & 32) != 0) {
            ua2 = null;
        }
        return z0(iterable, charSequence, charSequence5, charSequence6, i3, charSequence7, ua2);
    }

    public static Object B0(Iterable iterable) {
        AbstractC13042fc3.i(iterable, "<this>");
        if (iterable instanceof List) {
            return C0((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        Object next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    public static Object C0(List list) {
        AbstractC13042fc3.i(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(AbstractC10360bX0.o(list));
    }

    public static int D0(List list, Object obj) {
        AbstractC13042fc3.i(list, "<this>");
        return list.lastIndexOf(obj);
    }

    public static Object E0(Iterable iterable) {
        AbstractC13042fc3.i(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return list.get(list.size() - 1);
        }
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Object next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    public static Object F0(List list) {
        AbstractC13042fc3.i(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public static List G0(Iterable iterable, UA2 ua2) {
        AbstractC13042fc3.i(iterable, "<this>");
        AbstractC13042fc3.i(ua2, "transform");
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(iterable, 10));
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(ua2.invoke(it.next()));
        }
        return arrayList;
    }

    public static Comparable H0(Iterable iterable) {
        AbstractC13042fc3.i(iterable, "<this>");
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Comparable comparable = (Comparable) it.next();
        while (it.hasNext()) {
            Comparable comparable2 = (Comparable) it.next();
            if (comparable.compareTo(comparable2) < 0) {
                comparable = comparable2;
            }
        }
        return comparable;
    }

    public static Float I0(Iterable iterable) {
        AbstractC13042fc3.i(iterable, "<this>");
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float fFloatValue = ((Number) it.next()).floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, ((Number) it.next()).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    public static Comparable J0(Iterable iterable) {
        AbstractC13042fc3.i(iterable, "<this>");
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Comparable comparable = (Comparable) it.next();
        while (it.hasNext()) {
            Comparable comparable2 = (Comparable) it.next();
            if (comparable.compareTo(comparable2) < 0) {
                comparable = comparable2;
            }
        }
        return comparable;
    }

    public static Comparable K0(Iterable iterable) {
        AbstractC13042fc3.i(iterable, "<this>");
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Comparable comparable = (Comparable) it.next();
        while (it.hasNext()) {
            Comparable comparable2 = (Comparable) it.next();
            if (comparable.compareTo(comparable2) > 0) {
                comparable = comparable2;
            }
        }
        return comparable;
    }

    public static Float L0(Iterable iterable) {
        AbstractC13042fc3.i(iterable, "<this>");
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float fFloatValue = ((Number) it.next()).floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, ((Number) it.next()).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    public static Comparable M0(Iterable iterable) {
        AbstractC13042fc3.i(iterable, "<this>");
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Comparable comparable = (Comparable) it.next();
        while (it.hasNext()) {
            Comparable comparable2 = (Comparable) it.next();
            if (comparable.compareTo(comparable2) > 0) {
                comparable = comparable2;
            }
        }
        return comparable;
    }

    public static List N0(Iterable iterable, Iterable iterable2) {
        AbstractC13042fc3.i(iterable, "<this>");
        AbstractC13042fc3.i(iterable2, "elements");
        Collection collectionF = AbstractC13610gX0.F(iterable2);
        if (collectionF.isEmpty()) {
            return m1(iterable);
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : iterable) {
            if (!collectionF.contains(obj)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static List O0(Iterable iterable, Object obj) {
        AbstractC13042fc3.i(iterable, "<this>");
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(iterable, 10));
        boolean z = false;
        for (Object obj2 : iterable) {
            boolean z2 = true;
            if (!z && AbstractC13042fc3.d(obj2, obj)) {
                z = true;
                z2 = false;
            }
            if (z2) {
                arrayList.add(obj2);
            }
        }
        return arrayList;
    }

    public static List P0(Iterable iterable, Iterable iterable2) {
        AbstractC13042fc3.i(iterable, "<this>");
        AbstractC13042fc3.i(iterable2, "elements");
        if (iterable instanceof Collection) {
            return R0((Collection) iterable, iterable2);
        }
        ArrayList arrayList = new ArrayList();
        AbstractC13610gX0.D(arrayList, iterable);
        AbstractC13610gX0.D(arrayList, iterable2);
        return arrayList;
    }

    public static List Q0(Iterable iterable, Object obj) {
        AbstractC13042fc3.i(iterable, "<this>");
        if (iterable instanceof Collection) {
            return S0((Collection) iterable, obj);
        }
        ArrayList arrayList = new ArrayList();
        AbstractC13610gX0.D(arrayList, iterable);
        arrayList.add(obj);
        return arrayList;
    }

    public static List R0(Collection collection, Iterable iterable) {
        AbstractC13042fc3.i(collection, "<this>");
        AbstractC13042fc3.i(iterable, "elements");
        if (!(iterable instanceof Collection)) {
            ArrayList arrayList = new ArrayList(collection);
            AbstractC13610gX0.D(arrayList, iterable);
            return arrayList;
        }
        Collection collection2 = (Collection) iterable;
        ArrayList arrayList2 = new ArrayList(collection.size() + collection2.size());
        arrayList2.addAll(collection);
        arrayList2.addAll(collection2);
        return arrayList2;
    }

    public static List S0(Collection collection, Object obj) {
        AbstractC13042fc3.i(collection, "<this>");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(obj);
        return arrayList;
    }

    public static List T0(Iterable iterable) {
        AbstractC13042fc3.i(iterable, "<this>");
        if ((iterable instanceof Collection) && ((Collection) iterable).size() <= 1) {
            return m1(iterable);
        }
        List listO1 = o1(iterable);
        AbstractC14812iX0.b0(listO1);
        return listO1;
    }

    public static Object U0(Iterable iterable) {
        AbstractC13042fc3.i(iterable, "<this>");
        if (iterable instanceof List) {
            return V0((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        Object next = it.next();
        if (it.hasNext()) {
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        return next;
    }

    public static Object V0(List list) {
        AbstractC13042fc3.i(list, "<this>");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        }
        if (size == 1) {
            return list.get(0);
        }
        throw new IllegalArgumentException("List has more than one element.");
    }

    public static Object W0(Iterable iterable) {
        AbstractC13042fc3.i(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.size() == 1) {
                return list.get(0);
            }
            return null;
        }
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Object next = it.next();
        if (it.hasNext()) {
            return null;
        }
        return next;
    }

    public static Object X0(List list) {
        AbstractC13042fc3.i(list, "<this>");
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    public static List Y0(List list, C24411ya3 c24411ya3) {
        AbstractC13042fc3.i(list, "<this>");
        AbstractC13042fc3.i(c24411ya3, "indices");
        return c24411ya3.isEmpty() ? AbstractC10360bX0.m() : m1(list.subList(c24411ya3.f().intValue(), c24411ya3.j().intValue() + 1));
    }

    public static List Z0(Iterable iterable) {
        AbstractC13042fc3.i(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            List listO1 = o1(iterable);
            AbstractC12992fX0.A(listO1);
            return listO1;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return m1(iterable);
        }
        Object[] array = collection.toArray(new Comparable[0]);
        AbstractC9648aK.J((Comparable[]) array);
        return AbstractC9648aK.d(array);
    }

    public static List a1(Iterable iterable, Comparator comparator) {
        AbstractC13042fc3.i(iterable, "<this>");
        AbstractC13042fc3.i(comparator, "comparator");
        if (!(iterable instanceof Collection)) {
            List listO1 = o1(iterable);
            AbstractC12992fX0.B(listO1, comparator);
            return listO1;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return m1(iterable);
        }
        Object[] array = collection.toArray(new Object[0]);
        AbstractC9648aK.K(array, comparator);
        return AbstractC9648aK.d(array);
    }

    public static Set b1(Iterable iterable, Iterable iterable2) {
        AbstractC13042fc3.i(iterable, "<this>");
        AbstractC13042fc3.i(iterable2, "other");
        Set setQ1 = q1(iterable);
        AbstractC13610gX0.J(setQ1, iterable2);
        return setQ1;
    }

    public static float c1(Iterable iterable) {
        AbstractC13042fc3.i(iterable, "<this>");
        Iterator it = iterable.iterator();
        float fFloatValue = 0.0f;
        while (it.hasNext()) {
            fFloatValue += ((Number) it.next()).floatValue();
        }
        return fFloatValue;
    }

    public static int d1(Iterable iterable) {
        AbstractC13042fc3.i(iterable, "<this>");
        Iterator it = iterable.iterator();
        int iIntValue = 0;
        while (it.hasNext()) {
            iIntValue += ((Number) it.next()).intValue();
        }
        return iIntValue;
    }

    public static boolean e0(Iterable iterable, UA2 ua2) {
        AbstractC13042fc3.i(iterable, "<this>");
        AbstractC13042fc3.i(ua2, "predicate");
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return true;
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            if (!((Boolean) ua2.invoke(it.next())).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static long e1(Iterable iterable) {
        AbstractC13042fc3.i(iterable, "<this>");
        Iterator it = iterable.iterator();
        long jLongValue = 0;
        while (it.hasNext()) {
            jLongValue += ((Number) it.next()).longValue();
        }
        return jLongValue;
    }

    public static boolean f0(Iterable iterable) {
        AbstractC13042fc3.i(iterable, "<this>");
        return iterable instanceof Collection ? !((Collection) iterable).isEmpty() : iterable.iterator().hasNext();
    }

    public static List f1(Iterable iterable, int i) {
        AbstractC13042fc3.i(iterable, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        if (i == 0) {
            return AbstractC10360bX0.m();
        }
        if (iterable instanceof Collection) {
            if (i >= ((Collection) iterable).size()) {
                return m1(iterable);
            }
            if (i == 1) {
                return AbstractC9766aX0.e(p0(iterable));
            }
        }
        ArrayList arrayList = new ArrayList(i);
        Iterator it = iterable.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            arrayList.add(it.next());
            i2++;
            if (i2 == i) {
                break;
            }
        }
        return AbstractC10360bX0.t(arrayList);
    }

    public static InterfaceC23384wp6 g0(Iterable iterable) {
        AbstractC13042fc3.i(iterable, "<this>");
        return new a(iterable);
    }

    public static List g1(List list, int i) {
        AbstractC13042fc3.i(list, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        if (i == 0) {
            return AbstractC10360bX0.m();
        }
        int size = list.size();
        if (i >= size) {
            return m1(list);
        }
        if (i == 1) {
            return AbstractC9766aX0.e(C0(list));
        }
        ArrayList arrayList = new ArrayList(i);
        if (list instanceof RandomAccess) {
            for (int i2 = size - i; i2 < size; i2++) {
                arrayList.add(list.get(i2));
            }
        } else {
            ListIterator listIterator = list.listIterator(size - i);
            while (listIterator.hasNext()) {
                arrayList.add(listIterator.next());
            }
        }
        return arrayList;
    }

    public static List h0(Iterable iterable, int i) {
        AbstractC13042fc3.i(iterable, "<this>");
        return t1(iterable, i, i, true);
    }

    public static boolean[] h1(Collection collection) {
        AbstractC13042fc3.i(collection, "<this>");
        boolean[] zArr = new boolean[collection.size()];
        Iterator it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            zArr[i] = ((Boolean) it.next()).booleanValue();
            i++;
        }
        return zArr;
    }

    public static boolean i0(Iterable iterable, Object obj) {
        AbstractC13042fc3.i(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).contains(obj) : u0(iterable, obj) >= 0;
    }

    public static Collection i1(Iterable iterable, Collection collection) {
        AbstractC13042fc3.i(iterable, "<this>");
        AbstractC13042fc3.i(collection, "destination");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            collection.add(it.next());
        }
        return collection;
    }

    public static List j0(Iterable iterable) {
        AbstractC13042fc3.i(iterable, "<this>");
        return m1(q1(iterable));
    }

    public static float[] j1(Collection collection) {
        AbstractC13042fc3.i(collection, "<this>");
        float[] fArr = new float[collection.size()];
        Iterator it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            fArr[i] = ((Number) it.next()).floatValue();
            i++;
        }
        return fArr;
    }

    public static List k0(Iterable iterable, int i) {
        ArrayList arrayList;
        AbstractC13042fc3.i(iterable, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        if (i == 0) {
            return m1(iterable);
        }
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size() - i;
            if (size <= 0) {
                return AbstractC10360bX0.m();
            }
            if (size == 1) {
                return AbstractC9766aX0.e(B0(iterable));
            }
            arrayList = new ArrayList(size);
            if (iterable instanceof List) {
                if (iterable instanceof RandomAccess) {
                    int size2 = collection.size();
                    while (i < size2) {
                        arrayList.add(((List) iterable).get(i));
                        i++;
                    }
                } else {
                    ListIterator listIterator = ((List) iterable).listIterator(i);
                    while (listIterator.hasNext()) {
                        arrayList.add(listIterator.next());
                    }
                }
                return arrayList;
            }
        } else {
            arrayList = new ArrayList();
        }
        int i2 = 0;
        for (Object obj : iterable) {
            if (i2 >= i) {
                arrayList.add(obj);
            } else {
                i2++;
            }
        }
        return AbstractC10360bX0.t(arrayList);
    }

    public static HashSet k1(Iterable iterable) {
        AbstractC13042fc3.i(iterable, "<this>");
        return (HashSet) i1(iterable, new HashSet(AbstractC19460qO3.f(AbstractC10976cX0.x(iterable, 12))));
    }

    public static List l0(List list, int i) {
        AbstractC13042fc3.i(list, "<this>");
        if (i >= 0) {
            return f1(list, AbstractC23053wG5.e(list.size() - i, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    public static int[] l1(Collection collection) {
        AbstractC13042fc3.i(collection, "<this>");
        int[] iArr = new int[collection.size()];
        Iterator it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            iArr[i] = ((Number) it.next()).intValue();
            i++;
        }
        return iArr;
    }

    public static List m0(Iterable iterable, UA2 ua2) {
        AbstractC13042fc3.i(iterable, "<this>");
        AbstractC13042fc3.i(ua2, "predicate");
        ArrayList arrayList = new ArrayList();
        for (Object obj : iterable) {
            if (((Boolean) ua2.invoke(obj)).booleanValue()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static List m1(Iterable iterable) {
        AbstractC13042fc3.i(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return AbstractC10360bX0.t(o1(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return AbstractC10360bX0.m();
        }
        if (size != 1) {
            return p1(collection);
        }
        return AbstractC9766aX0.e(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    public static List n0(Iterable iterable) {
        AbstractC13042fc3.i(iterable, "<this>");
        return (List) o0(iterable, new ArrayList());
    }

    public static long[] n1(Collection collection) {
        AbstractC13042fc3.i(collection, "<this>");
        long[] jArr = new long[collection.size()];
        Iterator it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            jArr[i] = ((Number) it.next()).longValue();
            i++;
        }
        return jArr;
    }

    public static final Collection o0(Iterable iterable, Collection collection) {
        AbstractC13042fc3.i(iterable, "<this>");
        AbstractC13042fc3.i(collection, "destination");
        for (Object obj : iterable) {
            if (obj != null) {
                collection.add(obj);
            }
        }
        return collection;
    }

    public static final List o1(Iterable iterable) {
        AbstractC13042fc3.i(iterable, "<this>");
        return iterable instanceof Collection ? p1((Collection) iterable) : (List) i1(iterable, new ArrayList());
    }

    public static Object p0(Iterable iterable) {
        AbstractC13042fc3.i(iterable, "<this>");
        if (iterable instanceof List) {
            return q0((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static List p1(Collection collection) {
        AbstractC13042fc3.i(collection, "<this>");
        return new ArrayList(collection);
    }

    public static Object q0(List list) {
        AbstractC13042fc3.i(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    public static Set q1(Iterable iterable) {
        AbstractC13042fc3.i(iterable, "<this>");
        return iterable instanceof Collection ? new LinkedHashSet((Collection) iterable) : (Set) i1(iterable, new LinkedHashSet());
    }

    public static Object r0(Iterable iterable) {
        AbstractC13042fc3.i(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return list.get(0);
        }
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public static Set r1(Iterable iterable) {
        AbstractC13042fc3.i(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return AbstractC4597Fu6.h((Set) i1(iterable, new LinkedHashSet()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return AbstractC4597Fu6.d();
        }
        if (size != 1) {
            return (Set) i1(iterable, new LinkedHashSet(AbstractC19460qO3.f(collection.size())));
        }
        return AbstractC4363Eu6.c(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    public static Object s0(List list) {
        AbstractC13042fc3.i(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static Set s1(Iterable iterable, Iterable iterable2) {
        AbstractC13042fc3.i(iterable, "<this>");
        AbstractC13042fc3.i(iterable2, "other");
        Set setQ1 = q1(iterable);
        AbstractC13610gX0.D(setQ1, iterable2);
        return setQ1;
    }

    public static Object t0(List list, int i) {
        AbstractC13042fc3.i(list, "<this>");
        if (i < 0 || i >= list.size()) {
            return null;
        }
        return list.get(i);
    }

    public static final List t1(Iterable iterable, int i, int i2, boolean z) {
        AbstractC13042fc3.i(iterable, "<this>");
        AbstractC20573sE6.a(i, i2);
        if (!(iterable instanceof RandomAccess) || !(iterable instanceof List)) {
            ArrayList arrayList = new ArrayList();
            Iterator itB = AbstractC20573sE6.b(iterable.iterator(), i, i2, z, false);
            while (itB.hasNext()) {
                arrayList.add((List) itB.next());
            }
            return arrayList;
        }
        List list = (List) iterable;
        int size = list.size();
        ArrayList arrayList2 = new ArrayList((size / i2) + (size % i2 == 0 ? 0 : 1));
        int i3 = 0;
        while (i3 >= 0 && i3 < size) {
            int i4 = AbstractC23053wG5.i(i, size - i3);
            if (i4 < i && !z) {
                break;
            }
            ArrayList arrayList3 = new ArrayList(i4);
            for (int i5 = 0; i5 < i4; i5++) {
                arrayList3.add(list.get(i5 + i3));
            }
            arrayList2.add(arrayList3);
            i3 += i2;
        }
        return arrayList2;
    }

    public static int u0(Iterable iterable, Object obj) {
        AbstractC13042fc3.i(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(obj);
        }
        int i = 0;
        for (Object obj2 : iterable) {
            if (i < 0) {
                AbstractC10360bX0.w();
            }
            if (AbstractC13042fc3.d(obj, obj2)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static Iterable u1(Iterable iterable) {
        AbstractC13042fc3.i(iterable, "<this>");
        return new C15157j63(new b(iterable));
    }

    public static int v0(List list, Object obj) {
        AbstractC13042fc3.i(list, "<this>");
        return list.indexOf(obj);
    }

    public static List v1(Iterable iterable, Iterable iterable2) {
        AbstractC13042fc3.i(iterable, "<this>");
        AbstractC13042fc3.i(iterable2, "other");
        Iterator it = iterable.iterator();
        Iterator it2 = iterable2.iterator();
        ArrayList arrayList = new ArrayList(Math.min(AbstractC10976cX0.x(iterable, 10), AbstractC10976cX0.x(iterable2, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(AbstractC4616Fw7.a(it.next(), it2.next()));
        }
        return arrayList;
    }

    public static Set w0(Iterable iterable, Iterable iterable2) {
        AbstractC13042fc3.i(iterable, "<this>");
        AbstractC13042fc3.i(iterable2, "other");
        Set setQ1 = q1(iterable);
        AbstractC13610gX0.Q(setQ1, iterable2);
        return setQ1;
    }

    public static final Appendable x0(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, UA2 ua2) throws IOException {
        AbstractC13042fc3.i(iterable, "<this>");
        AbstractC13042fc3.i(appendable, "buffer");
        AbstractC13042fc3.i(charSequence, "separator");
        AbstractC13042fc3.i(charSequence2, "prefix");
        AbstractC13042fc3.i(charSequence3, "postfix");
        AbstractC13042fc3.i(charSequence4, "truncated");
        appendable.append(charSequence2);
        int i2 = 0;
        for (Object obj : iterable) {
            i2++;
            if (i2 > 1) {
                appendable.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            AbstractC15425jZ6.b(appendable, obj, ua2);
        }
        if (i >= 0 && i2 > i) {
            appendable.append(charSequence4);
        }
        appendable.append(charSequence3);
        return appendable;
    }

    public static String z0(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, UA2 ua2) {
        AbstractC13042fc3.i(iterable, "<this>");
        AbstractC13042fc3.i(charSequence, "separator");
        AbstractC13042fc3.i(charSequence2, "prefix");
        AbstractC13042fc3.i(charSequence3, "postfix");
        AbstractC13042fc3.i(charSequence4, "truncated");
        String string = ((StringBuilder) x0(iterable, new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, ua2)).toString();
        AbstractC13042fc3.h(string, "toString(...)");
        return string;
    }
}
