package ir.nasim;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* renamed from: ir.nasim.f01, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C12668f01 extends AbstractMap implements Serializable {
    private static final Object j = new Object();
    private transient Object a;
    transient int[] b;
    transient Object[] c;
    transient Object[] d;
    private transient int e;
    private transient int f;
    private transient Set g;
    private transient Set h;
    private transient Collection i;

    /* renamed from: ir.nasim.f01$a */
    class a extends e {
        a() {
            super(C12668f01.this, null);
        }

        @Override // ir.nasim.C12668f01.e
        Object b(int i) {
            return C12668f01.this.U(i);
        }
    }

    /* renamed from: ir.nasim.f01$b */
    class b extends e {
        b() {
            super(C12668f01.this, null);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ir.nasim.C12668f01.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Map.Entry b(int i) {
            return C12668f01.this.new g(i);
        }
    }

    /* renamed from: ir.nasim.f01$c */
    class c extends e {
        c() {
            super(C12668f01.this, null);
        }

        @Override // ir.nasim.C12668f01.e
        Object b(int i) {
            return C12668f01.this.k0(i);
        }
    }

    /* renamed from: ir.nasim.f01$d */
    class d extends AbstractSet {
        d() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            C12668f01.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map mapK = C12668f01.this.K();
            if (mapK != null) {
                return mapK.entrySet().contains(obj);
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int iR = C12668f01.this.R(entry.getKey());
            return iR != -1 && EG4.a(C12668f01.this.k0(iR), entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return C12668f01.this.M();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map mapK = C12668f01.this.K();
            if (mapK != null) {
                return mapK.entrySet().remove(obj);
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (C12668f01.this.X()) {
                return false;
            }
            int iP = C12668f01.this.P();
            int iF = AbstractC13304g01.f(entry.getKey(), entry.getValue(), iP, C12668f01.this.b0(), C12668f01.this.Z(), C12668f01.this.a0(), C12668f01.this.c0());
            if (iF == -1) {
                return false;
            }
            C12668f01.this.W(iF, iP);
            C12668f01.f(C12668f01.this);
            C12668f01.this.Q();
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return C12668f01.this.size();
        }
    }

    /* renamed from: ir.nasim.f01$f */
    class f extends AbstractSet {
        f() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            C12668f01.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return C12668f01.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return C12668f01.this.V();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map mapK = C12668f01.this.K();
            return mapK != null ? mapK.keySet().remove(obj) : C12668f01.this.Y(obj) != C12668f01.j;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return C12668f01.this.size();
        }
    }

    /* renamed from: ir.nasim.f01$g */
    final class g extends AbstractC16285l1 {
        private final Object a;
        private int b;

        g(int i) {
            this.a = C12668f01.this.U(i);
            this.b = i;
        }

        private void a() {
            int i = this.b;
            if (i == -1 || i >= C12668f01.this.size() || !EG4.a(this.a, C12668f01.this.U(this.b))) {
                this.b = C12668f01.this.R(this.a);
            }
        }

        @Override // ir.nasim.AbstractC16285l1, java.util.Map.Entry
        public Object getKey() {
            return this.a;
        }

        @Override // ir.nasim.AbstractC16285l1, java.util.Map.Entry
        public Object getValue() {
            Map mapK = C12668f01.this.K();
            if (mapK != null) {
                return AbstractC22447vF4.a(mapK.get(this.a));
            }
            a();
            int i = this.b;
            return i == -1 ? AbstractC22447vF4.b() : C12668f01.this.k0(i);
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            Map mapK = C12668f01.this.K();
            if (mapK != null) {
                return AbstractC22447vF4.a(mapK.put(this.a, obj));
            }
            a();
            int i = this.b;
            if (i == -1) {
                C12668f01.this.put(this.a, obj);
                return AbstractC22447vF4.b();
            }
            Object objK0 = C12668f01.this.k0(i);
            C12668f01.this.j0(this.b, obj);
            return objK0;
        }
    }

    /* renamed from: ir.nasim.f01$h */
    class h extends AbstractCollection {
        h() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            C12668f01.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return C12668f01.this.l0();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return C12668f01.this.size();
        }
    }

    C12668f01(int i) {
        S(i);
    }

    public static C12668f01 J(int i) {
        return new C12668f01(i);
    }

    private int L(int i) {
        return Z()[i];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int P() {
        return (1 << (this.e & 31)) - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int R(Object obj) {
        if (X()) {
            return -1;
        }
        int iC = BU2.c(obj);
        int iP = P();
        int iH = AbstractC13304g01.h(b0(), iC & iP);
        if (iH == 0) {
            return -1;
        }
        int iB = AbstractC13304g01.b(iC, iP);
        do {
            int i = iH - 1;
            int iL = L(i);
            if (AbstractC13304g01.b(iL, iP) == iB && EG4.a(obj, U(i))) {
                return i;
            }
            iH = AbstractC13304g01.c(iL, iP);
        } while (iH != 0);
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object U(int i) {
        return a0()[i];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object Y(Object obj) {
        if (X()) {
            return j;
        }
        int iP = P();
        int iF = AbstractC13304g01.f(obj, null, iP, b0(), Z(), a0(), null);
        if (iF == -1) {
            return j;
        }
        Object objK0 = k0(iF);
        W(iF, iP);
        this.f--;
        Q();
        return objK0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] Z() {
        int[] iArr = this.b;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object[] a0() {
        Object[] objArr = this.c;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object b0() {
        Object obj = this.a;
        Objects.requireNonNull(obj);
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object[] c0() {
        Object[] objArr = this.d;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    private void e0(int i) {
        int iMin;
        int length = Z().length;
        if (i <= length || (iMin = Math.min(1073741823, (Math.max(1, length >>> 1) + length) | 1)) == length) {
            return;
        }
        d0(iMin);
    }

    static /* synthetic */ int f(C12668f01 c12668f01) {
        int i = c12668f01.f;
        c12668f01.f = i - 1;
        return i;
    }

    private int f0(int i, int i2, int i3, int i4) {
        Object objA = AbstractC13304g01.a(i2);
        int i5 = i2 - 1;
        if (i4 != 0) {
            AbstractC13304g01.i(objA, i3 & i5, i4 + 1);
        }
        Object objB0 = b0();
        int[] iArrZ = Z();
        for (int i6 = 0; i6 <= i; i6++) {
            int iH = AbstractC13304g01.h(objB0, i6);
            while (iH != 0) {
                int i7 = iH - 1;
                int i8 = iArrZ[i7];
                int iB = AbstractC13304g01.b(i8, i) | i6;
                int i9 = iB & i5;
                int iH2 = AbstractC13304g01.h(objA, i9);
                AbstractC13304g01.i(objA, i9, iH);
                iArrZ[i7] = AbstractC13304g01.d(iB, iH2, i5);
                iH = AbstractC13304g01.c(i8, i);
            }
        }
        this.a = objA;
        h0(i5);
        return i5;
    }

    private void g0(int i, int i2) {
        Z()[i] = i2;
    }

    private void h0(int i) {
        this.e = AbstractC13304g01.d(this.e, 32 - Integer.numberOfLeadingZeros(i), 31);
    }

    private void i0(int i, Object obj) {
        a0()[i] = obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0(int i, Object obj) {
        c0()[i] = obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object k0(int i) {
        return c0()[i];
    }

    Map C() {
        Map mapF = F(P() + 1);
        int iN = N();
        while (iN >= 0) {
            mapF.put(U(iN), k0(iN));
            iN = O(iN);
        }
        this.a = mapF;
        this.b = null;
        this.c = null;
        this.d = null;
        Q();
        return mapF;
    }

    Set E() {
        return new d();
    }

    Map F(int i) {
        return new LinkedHashMap(i, 1.0f);
    }

    Set G() {
        return new f();
    }

    Collection H() {
        return new h();
    }

    Map K() {
        Object obj = this.a;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    Iterator M() {
        Map mapK = K();
        return mapK != null ? mapK.entrySet().iterator() : new b();
    }

    int N() {
        return isEmpty() ? -1 : 0;
    }

    int O(int i) {
        int i2 = i + 1;
        if (i2 < this.f) {
            return i2;
        }
        return -1;
    }

    void Q() {
        this.e += 32;
    }

    void S(int i) {
        AbstractC4029Dj5.e(i >= 0, "Expected size must be >= 0");
        this.e = AbstractC8236Vc3.f(i, 1, 1073741823);
    }

    void T(int i, Object obj, Object obj2, int i2, int i3) {
        g0(i, AbstractC13304g01.d(i2, 0, i3));
        i0(i, obj);
        j0(i, obj2);
    }

    Iterator V() {
        Map mapK = K();
        return mapK != null ? mapK.keySet().iterator() : new a();
    }

    void W(int i, int i2) {
        Object objB0 = b0();
        int[] iArrZ = Z();
        Object[] objArrA0 = a0();
        Object[] objArrC0 = c0();
        int size = size();
        int i3 = size - 1;
        if (i >= i3) {
            objArrA0[i] = null;
            objArrC0[i] = null;
            iArrZ[i] = 0;
            return;
        }
        Object obj = objArrA0[i3];
        objArrA0[i] = obj;
        objArrC0[i] = objArrC0[i3];
        objArrA0[i3] = null;
        objArrC0[i3] = null;
        iArrZ[i] = iArrZ[i3];
        iArrZ[i3] = 0;
        int iC = BU2.c(obj) & i2;
        int iH = AbstractC13304g01.h(objB0, iC);
        if (iH == size) {
            AbstractC13304g01.i(objB0, iC, i + 1);
            return;
        }
        while (true) {
            int i4 = iH - 1;
            int i5 = iArrZ[i4];
            int iC2 = AbstractC13304g01.c(i5, i2);
            if (iC2 == size) {
                iArrZ[i4] = AbstractC13304g01.d(i5, i + 1, i2);
                return;
            }
            iH = iC2;
        }
    }

    boolean X() {
        return this.a == null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        if (X()) {
            return;
        }
        Q();
        Map mapK = K();
        if (mapK != null) {
            this.e = AbstractC8236Vc3.f(size(), 3, 1073741823);
            mapK.clear();
            this.a = null;
            this.f = 0;
            return;
        }
        Arrays.fill(a0(), 0, this.f, (Object) null);
        Arrays.fill(c0(), 0, this.f, (Object) null);
        AbstractC13304g01.g(b0());
        Arrays.fill(Z(), 0, this.f, 0);
        this.f = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Map mapK = K();
        return mapK != null ? mapK.containsKey(obj) : R(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        Map mapK = K();
        if (mapK != null) {
            return mapK.containsValue(obj);
        }
        for (int i = 0; i < this.f; i++) {
            if (EG4.a(obj, k0(i))) {
                return true;
            }
        }
        return false;
    }

    void d0(int i) {
        this.b = Arrays.copyOf(Z(), i);
        this.c = Arrays.copyOf(a0(), i);
        this.d = Arrays.copyOf(c0(), i);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        Set set = this.h;
        if (set != null) {
            return set;
        }
        Set setE = E();
        this.h = setE;
        return setE;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        Map mapK = K();
        if (mapK != null) {
            return mapK.get(obj);
        }
        int iR = R(obj);
        if (iR == -1) {
            return null;
        }
        u(iR);
        return k0(iR);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set keySet() {
        Set set = this.g;
        if (set != null) {
            return set;
        }
        Set setG = G();
        this.g = setG;
        return setG;
    }

    Iterator l0() {
        Map mapK = K();
        return mapK != null ? mapK.values().iterator() : new c();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        int iF0;
        int i;
        if (X()) {
            z();
        }
        Map mapK = K();
        if (mapK != null) {
            return mapK.put(obj, obj2);
        }
        int[] iArrZ = Z();
        Object[] objArrA0 = a0();
        Object[] objArrC0 = c0();
        int i2 = this.f;
        int i3 = i2 + 1;
        int iC = BU2.c(obj);
        int iP = P();
        int i4 = iC & iP;
        int iH = AbstractC13304g01.h(b0(), i4);
        if (iH != 0) {
            int iB = AbstractC13304g01.b(iC, iP);
            int i5 = 0;
            while (true) {
                int i6 = iH - 1;
                int i7 = iArrZ[i6];
                if (AbstractC13304g01.b(i7, iP) == iB && EG4.a(obj, objArrA0[i6])) {
                    Object obj3 = objArrC0[i6];
                    objArrC0[i6] = obj2;
                    u(i6);
                    return obj3;
                }
                int iC2 = AbstractC13304g01.c(i7, iP);
                i5++;
                if (iC2 != 0) {
                    iH = iC2;
                } else {
                    if (i5 >= 9) {
                        return C().put(obj, obj2);
                    }
                    if (i3 > iP) {
                        iF0 = f0(iP, AbstractC13304g01.e(iP), iC, i2);
                    } else {
                        iArrZ[i6] = AbstractC13304g01.d(i7, i3, iP);
                    }
                }
            }
            i = iP;
        } else if (i3 > iP) {
            iF0 = f0(iP, AbstractC13304g01.e(iP), iC, i2);
            i = iF0;
        } else {
            AbstractC13304g01.i(b0(), i4, i3);
            i = iP;
        }
        e0(i3);
        T(i2, obj, obj2, iC, i);
        this.f = i3;
        Q();
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        Map mapK = K();
        if (mapK != null) {
            return mapK.remove(obj);
        }
        Object objY = Y(obj);
        if (objY == j) {
            return null;
        }
        return objY;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        Map mapK = K();
        return mapK != null ? mapK.size() : this.f;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection values() {
        Collection collection = this.i;
        if (collection != null) {
            return collection;
        }
        Collection collectionH = H();
        this.i = collectionH;
        return collectionH;
    }

    int y(int i, int i2) {
        return i - 1;
    }

    int z() {
        AbstractC4029Dj5.p(X(), "Arrays already allocated");
        int i = this.e;
        int iJ = AbstractC13304g01.j(i);
        this.a = AbstractC13304g01.a(iJ);
        h0(iJ - 1);
        this.b = new int[i];
        this.c = new Object[i];
        this.d = new Object[i];
        return i;
    }

    /* renamed from: ir.nasim.f01$e */
    private abstract class e implements Iterator {
        int a;
        int b;
        int c;

        private e() {
            this.a = C12668f01.this.e;
            this.b = C12668f01.this.N();
            this.c = -1;
        }

        private void a() {
            if (C12668f01.this.e != this.a) {
                throw new ConcurrentModificationException();
            }
        }

        abstract Object b(int i);

        void c() {
            this.a += 32;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b >= 0;
        }

        @Override // java.util.Iterator
        public Object next() {
            a();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int i = this.b;
            this.c = i;
            Object objB = b(i);
            this.b = C12668f01.this.O(this.b);
            return objB;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            MW0.c(this.c >= 0);
            c();
            C12668f01 c12668f01 = C12668f01.this;
            c12668f01.remove(c12668f01.U(this.c));
            this.b = C12668f01.this.y(this.b, this.c);
            this.c = -1;
        }

        /* synthetic */ e(C12668f01 c12668f01, a aVar) {
            this();
        }
    }

    void u(int i) {
    }
}
