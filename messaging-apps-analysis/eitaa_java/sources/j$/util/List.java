package j$.util;

import j$.util.function.UnaryOperator;
import j$.util.u;
import java.util.Arrays;
import java.util.ListIterator;

/* loaded from: classes2.dex */
public interface List<E> extends Collection<E> {

    /* renamed from: j$.util.List$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        /* JADX WARN: Multi-variable type inference failed */
        public static void $default$replaceAll(java.util.List list, UnaryOperator unaryOperator) {
            if (DesugarCollections.b.isInstance(list)) {
                DesugarCollections.e(list, unaryOperator);
                return;
            }
            unaryOperator.getClass();
            ListIterator listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                listIterator.set(unaryOperator.apply(listIterator.next()));
            }
        }

        public static void $default$sort(java.util.List list, java.util.Comparator comparator) {
            if (DesugarCollections.b.isInstance(list)) {
                DesugarCollections.f(list, comparator);
                return;
            }
            Object[] array = list.toArray();
            Arrays.sort(array, comparator);
            ListIterator<E> listIterator = list.listIterator();
            for (Object obj : array) {
                listIterator.next();
                listIterator.set(obj);
            }
        }

        public static Spliterator $default$spliterator(java.util.List list) {
            list.getClass();
            return new u.i(list, 16);
        }
    }

    void add(int i, Object obj);

    @Override // j$.util.Collection, java.util.Set, j$.util.Set
    boolean add(Object obj);

    boolean addAll(int i, java.util.Collection collection);

    @Override // j$.util.Collection, java.util.Set, j$.util.Set
    boolean addAll(java.util.Collection collection);

    @Override // j$.util.Collection, java.util.Set, j$.util.Set
    void clear();

    @Override // j$.util.Collection, java.util.Set, j$.util.Set
    boolean contains(Object obj);

    @Override // j$.util.Collection, java.util.Set, j$.util.Set
    boolean containsAll(java.util.Collection collection);

    @Override // j$.util.Collection, java.util.Set, j$.util.Set
    boolean equals(Object obj);

    Object get(int i);

    @Override // j$.util.Collection, java.util.Set, j$.util.Set
    int hashCode();

    int indexOf(Object obj);

    @Override // j$.util.Collection, java.util.Set, j$.util.Set
    boolean isEmpty();

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List, j$.util.List, j$.util.Collection, java.util.Set, j$.lang.Iterable
    java.util.Iterator iterator();

    int lastIndexOf(Object obj);

    ListIterator listIterator();

    ListIterator listIterator(int i);

    Object remove(int i);

    @Override // j$.util.Collection, java.util.Set, j$.util.Set
    boolean remove(Object obj);

    @Override // j$.util.Collection, java.util.Set, j$.util.Set
    boolean removeAll(java.util.Collection collection);

    void replaceAll(UnaryOperator unaryOperator);

    @Override // j$.util.Collection, java.util.Set, j$.util.Set
    boolean retainAll(java.util.Collection collection);

    Object set(int i, Object obj);

    @Override // java.util.Collection, java.util.List, j$.util.List, j$.util.Collection, java.util.Set, j$.util.Set
    int size();

    void sort(java.util.Comparator comparator);

    @Override // java.lang.Iterable, java.util.List, j$.util.List, j$.util.Collection, java.util.Set, j$.lang.Iterable
    Spliterator spliterator();

    java.util.List subList(int i, int i2);

    @Override // j$.util.Collection, java.util.Set, j$.util.Set
    Object[] toArray();

    @Override // j$.util.Collection, java.util.Set, j$.util.Set
    Object[] toArray(Object[] objArr);
}
