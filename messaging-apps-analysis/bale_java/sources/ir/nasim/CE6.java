package ir.nasim;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* loaded from: classes8.dex */
public class CE6 extends AbstractList implements RandomAccess {
    private int a;
    private Object b;

    private static class b implements Iterator {
        private static final b a = new b();

        private b() {
        }

        public static b a() {
            return a;
        }

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
            throw new IllegalStateException();
        }
    }

    private class c extends d {
        private final int b;

        public c() {
            super();
            this.b = ((AbstractList) CE6.this).modCount;
        }

        @Override // ir.nasim.CE6.d
        protected void a() {
            if (((AbstractList) CE6.this).modCount == this.b) {
                return;
            }
            throw new ConcurrentModificationException("ModCount: " + ((AbstractList) CE6.this).modCount + "; expected: " + this.b);
        }

        @Override // ir.nasim.CE6.d
        protected Object b() {
            return CE6.this.b;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            CE6.this.clear();
        }
    }

    private static abstract class d implements Iterator {
        private boolean a;

        private d() {
        }

        protected abstract void a();

        protected abstract Object b();

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return !this.a;
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (this.a) {
                throw new NoSuchElementException();
            }
            this.a = true;
            a();
            return b();
        }
    }

    private static /* synthetic */ void f(int i) {
        String str = (i == 2 || i == 3 || i == 5 || i == 6 || i == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 2 || i == 3 || i == 5 || i == 6 || i == 7) ? 2 : 3];
        switch (i) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
                break;
            case 4:
                objArr[0] = "a";
                break;
            default:
                objArr[0] = "elements";
                break;
        }
        if (i == 2 || i == 3) {
            objArr[1] = "iterator";
        } else if (i == 5 || i == 6 || i == 7) {
            objArr[1] = "toArray";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
        }
        switch (i) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                break;
            case 4:
                objArr[2] = "toArray";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 2 && i != 3 && i != 5 && i != 6 && i != 7) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        int i = this.a;
        if (i == 0) {
            this.b = obj;
        } else if (i == 1) {
            this.b = new Object[]{this.b, obj};
        } else {
            Object[] objArr = (Object[]) this.b;
            int length = objArr.length;
            if (i >= length) {
                int i2 = ((length * 3) / 2) + 1;
                int i3 = i + 1;
                if (i2 < i3) {
                    i2 = i3;
                }
                Object[] objArr2 = new Object[i2];
                this.b = objArr2;
                System.arraycopy(objArr, 0, objArr2, 0, length);
                objArr = objArr2;
            }
            objArr[this.a] = obj;
        }
        this.a++;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.b = null;
        this.a = 0;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i) {
        int i2;
        if (i >= 0 && i < (i2 = this.a)) {
            return i2 == 1 ? this.b : ((Object[]) this.b)[i];
        }
        throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + this.a);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        int i = this.a;
        if (i == 0) {
            b bVarA = b.a();
            if (bVarA == null) {
                f(2);
            }
            return bVarA;
        }
        if (i == 1) {
            return new c();
        }
        Iterator it = super.iterator();
        if (it == null) {
            f(3);
        }
        return it;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object remove(int i) {
        int i2;
        Object obj;
        if (i < 0 || i >= (i2 = this.a)) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + this.a);
        }
        if (i2 == 1) {
            obj = this.b;
            this.b = null;
        } else {
            Object[] objArr = (Object[]) this.b;
            Object obj2 = objArr[i];
            if (i2 == 2) {
                this.b = objArr[1 - i];
            } else {
                int i3 = (i2 - i) - 1;
                if (i3 > 0) {
                    System.arraycopy(objArr, i + 1, objArr, i, i3);
                }
                objArr[this.a - 1] = null;
            }
            obj = obj2;
        }
        this.a--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i, Object obj) {
        int i2;
        if (i < 0 || i >= (i2 = this.a)) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + this.a);
        }
        if (i2 == 1) {
            Object obj2 = this.b;
            this.b = obj;
            return obj2;
        }
        Object[] objArr = (Object[]) this.b;
        Object obj3 = objArr[i];
        objArr[i] = obj;
        return obj3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.a;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray(Object[] objArr) {
        if (objArr == null) {
            f(4);
        }
        int length = objArr.length;
        int i = this.a;
        if (i == 1) {
            if (length == 0) {
                Object[] objArr2 = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), 1);
                objArr2[0] = this.b;
                return objArr2;
            }
            objArr[0] = this.b;
        } else {
            if (length < i) {
                Object[] objArrCopyOf = Arrays.copyOf((Object[]) this.b, i, objArr.getClass());
                if (objArrCopyOf == null) {
                    f(6);
                }
                return objArrCopyOf;
            }
            if (i != 0) {
                System.arraycopy(this.b, 0, objArr, 0, i);
            }
        }
        int i2 = this.a;
        if (length > i2) {
            objArr[i2] = null;
        }
        return objArr;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, Object obj) {
        int i2;
        if (i >= 0 && i <= (i2 = this.a)) {
            if (i2 == 0) {
                this.b = obj;
            } else if (i2 == 1 && i == 0) {
                this.b = new Object[]{obj, this.b};
            } else {
                Object[] objArr = new Object[i2 + 1];
                if (i2 == 1) {
                    objArr[0] = this.b;
                } else {
                    Object[] objArr2 = (Object[]) this.b;
                    System.arraycopy(objArr2, 0, objArr, 0, i);
                    System.arraycopy(objArr2, i, objArr, i + 1, this.a - i);
                }
                objArr[i] = obj;
                this.b = objArr;
            }
            this.a++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + this.a);
    }
}
