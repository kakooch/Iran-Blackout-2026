package ir.nasim;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* renamed from: ir.nasim.zm8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC25130zm8 extends AbstractC20893sm8 implements List, RandomAccess {
    private static final Em8 b = new C22170um8(Bm8.e, 0);

    AbstractC25130zm8() {
    }

    static AbstractC25130zm8 F(Object[] objArr, int i) {
        return i == 0 ? Bm8.e : new Bm8(objArr, i);
    }

    public static AbstractC25130zm8 L(Collection collection) {
        if (collection instanceof AbstractC20893sm8) {
            AbstractC25130zm8 abstractC25130zm8W = ((AbstractC20893sm8) collection).w();
            if (!abstractC25130zm8W.C()) {
                return abstractC25130zm8W;
            }
            Object[] array = abstractC25130zm8W.toArray();
            return F(array, array.length);
        }
        Object[] array2 = collection.toArray();
        int length = array2.length;
        for (int i = 0; i < length; i++) {
            if (array2[i] == null) {
                throw new NullPointerException("at index " + i);
            }
        }
        return F(array2, length);
    }

    public static AbstractC25130zm8 N() {
        return Bm8.e;
    }

    @Override // java.util.List
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public AbstractC25130zm8 subList(int i, int i2) {
        AbstractC18511om8.c(i, i2, size());
        int i3 = i2 - i;
        return i3 == size() ? this : i3 == 0 ? Bm8.e : new C23356wm8(this, i, i3);
    }

    @Override // java.util.List
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public final Em8 listIterator(int i) {
        AbstractC18511om8.b(i, size(), "index");
        return isEmpty() ? b : new C22170um8(this, i);
    }

    @Override // java.util.List
    public final void add(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    for (int i = 0; i < size; i++) {
                        if (AbstractC17920nm8.a(get(i), list.get(i))) {
                        }
                    }
                    return true;
                }
                Iterator it = iterator();
                Iterator it2 = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (!it2.hasNext() || !AbstractC17920nm8.a(it.next(), it2.next())) {
                            break;
                        }
                    } else if (!it2.hasNext()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // ir.nasim.AbstractC20893sm8
    int f(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i2] = get(i2);
        }
        return size;
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        int size = size();
        int iHashCode = 1;
        for (int i = 0; i < size; i++) {
            iHashCode = (iHashCode * 31) + get(i).hashCode();
        }
        return iHashCode;
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (obj.equals(get(i))) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final /* synthetic */ Iterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public final /* synthetic */ ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public final Object remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final Object set(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // ir.nasim.AbstractC20893sm8
    public final AbstractC25130zm8 w() {
        return this;
    }
}
