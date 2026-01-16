package ir.nasim;

import ir.nasim.InterfaceC20297rm3;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: classes8.dex */
public final class JN3 implements Map, Serializable, InterfaceC20297rm3 {
    public static final a n = new a(null);
    private static final JN3 o;
    private Object[] a;
    private Object[] b;
    private int[] c;
    private int[] d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private LN3 j;
    private MN3 k;
    private KN3 l;
    private boolean m;

    public static final class a {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int c(int i) {
            return Integer.highestOneBit(AbstractC23053wG5.e(i, 1) * 3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int d(int i) {
            return Integer.numberOfLeadingZeros(i) + 1;
        }

        public final JN3 e() {
            return JN3.o;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public static final class b extends d implements Iterator, InterfaceC17915nm3 {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(JN3 jn3) {
            super(jn3);
            AbstractC13042fc3.i(jn3, "map");
        }

        @Override // java.util.Iterator
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public c next() {
            b();
            if (c() >= e().f) {
                throw new NoSuchElementException();
            }
            int iC = c();
            g(iC + 1);
            h(iC);
            c cVar = new c(e(), d());
            f();
            return cVar;
        }

        public final void k(StringBuilder sb) {
            AbstractC13042fc3.i(sb, "sb");
            if (c() >= e().f) {
                throw new NoSuchElementException();
            }
            int iC = c();
            g(iC + 1);
            h(iC);
            Object obj = e().a[d()];
            if (obj == e()) {
                sb.append("(this Map)");
            } else {
                sb.append(obj);
            }
            sb.append('=');
            Object[] objArr = e().b;
            AbstractC13042fc3.f(objArr);
            Object obj2 = objArr[d()];
            if (obj2 == e()) {
                sb.append("(this Map)");
            } else {
                sb.append(obj2);
            }
            f();
        }

        public final int l() {
            if (c() >= e().f) {
                throw new NoSuchElementException();
            }
            int iC = c();
            g(iC + 1);
            h(iC);
            Object obj = e().a[d()];
            int iHashCode = obj != null ? obj.hashCode() : 0;
            Object[] objArr = e().b;
            AbstractC13042fc3.f(objArr);
            Object obj2 = objArr[d()];
            int iHashCode2 = iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
            f();
            return iHashCode2;
        }
    }

    public static final class c implements Map.Entry, InterfaceC20297rm3.a {
        private final JN3 a;
        private final int b;

        public c(JN3 jn3, int i) {
            AbstractC13042fc3.i(jn3, "map");
            this.a = jn3;
            this.b = i;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                if (AbstractC13042fc3.d(entry.getKey(), getKey()) && AbstractC13042fc3.d(entry.getValue(), getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.a.a[this.b];
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            Object[] objArr = this.a.b;
            AbstractC13042fc3.f(objArr);
            return objArr[this.b];
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            Object key = getKey();
            int iHashCode = key != null ? key.hashCode() : 0;
            Object value = getValue();
            return iHashCode ^ (value != null ? value.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            this.a.q();
            Object[] objArrN = this.a.n();
            int i = this.b;
            Object obj2 = objArrN[i];
            objArrN[i] = obj;
            return obj2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getKey());
            sb.append('=');
            sb.append(getValue());
            return sb.toString();
        }
    }

    public static class d {
        private final JN3 a;
        private int b;
        private int c;
        private int d;

        public d(JN3 jn3) {
            AbstractC13042fc3.i(jn3, "map");
            this.a = jn3;
            this.c = -1;
            this.d = jn3.h;
            f();
        }

        public final void b() {
            if (this.a.h != this.d) {
                throw new ConcurrentModificationException();
            }
        }

        public final int c() {
            return this.b;
        }

        public final int d() {
            return this.c;
        }

        public final JN3 e() {
            return this.a;
        }

        public final void f() {
            while (this.b < this.a.f) {
                int[] iArr = this.a.c;
                int i = this.b;
                if (iArr[i] >= 0) {
                    return;
                } else {
                    this.b = i + 1;
                }
            }
        }

        public final void g(int i) {
            this.b = i;
        }

        public final void h(int i) {
            this.c = i;
        }

        public final boolean hasNext() {
            return this.b < this.a.f;
        }

        public final void remove() {
            b();
            if (this.c == -1) {
                throw new IllegalStateException("Call next() before removing element from the iterator.".toString());
            }
            this.a.q();
            this.a.Y(this.c);
            this.c = -1;
            this.d = this.a.h;
        }
    }

    public static final class e extends d implements Iterator, InterfaceC17915nm3 {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(JN3 jn3) {
            super(jn3);
            AbstractC13042fc3.i(jn3, "map");
        }

        @Override // java.util.Iterator
        public Object next() {
            b();
            if (c() >= e().f) {
                throw new NoSuchElementException();
            }
            int iC = c();
            g(iC + 1);
            h(iC);
            Object obj = e().a[d()];
            f();
            return obj;
        }
    }

    public static final class f extends d implements Iterator, InterfaceC17915nm3 {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(JN3 jn3) {
            super(jn3);
            AbstractC13042fc3.i(jn3, "map");
        }

        @Override // java.util.Iterator
        public Object next() {
            b();
            if (c() >= e().f) {
                throw new NoSuchElementException();
            }
            int iC = c();
            g(iC + 1);
            h(iC);
            Object[] objArr = e().b;
            AbstractC13042fc3.f(objArr);
            Object obj = objArr[d()];
            f();
            return obj;
        }
    }

    static {
        JN3 jn3 = new JN3(0);
        jn3.m = true;
        o = jn3;
    }

    private JN3(Object[] objArr, Object[] objArr2, int[] iArr, int[] iArr2, int i, int i2) {
        this.a = objArr;
        this.b = objArr2;
        this.c = iArr;
        this.d = iArr2;
        this.e = i;
        this.f = i2;
        this.g = n.d(M());
    }

    private final boolean C(Map map) {
        return size() == map.size() && u(map.entrySet());
    }

    private final void E(int i) {
        if (i < 0) {
            throw new OutOfMemoryError();
        }
        if (i > K()) {
            int iE = AbstractC11442d1.Companion.e(K(), i);
            this.a = BB3.e(this.a, iE);
            Object[] objArr = this.b;
            this.b = objArr != null ? BB3.e(objArr, iE) : null;
            int[] iArrCopyOf = Arrays.copyOf(this.c, iE);
            AbstractC13042fc3.h(iArrCopyOf, "copyOf(...)");
            this.c = iArrCopyOf;
            int iC = n.c(iE);
            if (iC > M()) {
                W(iC);
            }
        }
    }

    private final void F(int i) {
        if (c0(i)) {
            s(true);
        } else {
            E(this.f + i);
        }
    }

    private final int H(Object obj) {
        int iQ = Q(obj);
        int i = this.e;
        while (true) {
            int i2 = this.d[iQ];
            if (i2 == 0) {
                return -1;
            }
            if (i2 > 0) {
                int i3 = i2 - 1;
                if (AbstractC13042fc3.d(this.a[i3], obj)) {
                    return i3;
                }
            }
            i--;
            if (i < 0) {
                return -1;
            }
            iQ = iQ == 0 ? M() - 1 : iQ - 1;
        }
    }

    private final int J(Object obj) {
        int i = this.f;
        while (true) {
            i--;
            if (i < 0) {
                return -1;
            }
            if (this.c[i] >= 0) {
                Object[] objArr = this.b;
                AbstractC13042fc3.f(objArr);
                if (AbstractC13042fc3.d(objArr[i], obj)) {
                    return i;
                }
            }
        }
    }

    private final int M() {
        return this.d.length;
    }

    private final int Q(Object obj) {
        return ((obj != null ? obj.hashCode() : 0) * (-1640531527)) >>> this.g;
    }

    private final boolean S(Collection collection) {
        boolean z = false;
        if (collection.isEmpty()) {
            return false;
        }
        F(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (T((Map.Entry) it.next())) {
                z = true;
            }
        }
        return z;
    }

    private final boolean T(Map.Entry entry) {
        int iL = l(entry.getKey());
        Object[] objArrN = n();
        if (iL >= 0) {
            objArrN[iL] = entry.getValue();
            return true;
        }
        int i = (-iL) - 1;
        if (AbstractC13042fc3.d(entry.getValue(), objArrN[i])) {
            return false;
        }
        objArrN[i] = entry.getValue();
        return true;
    }

    private final boolean U(int i) {
        int iQ = Q(this.a[i]);
        int i2 = this.e;
        while (true) {
            int[] iArr = this.d;
            if (iArr[iQ] == 0) {
                iArr[iQ] = i + 1;
                this.c[i] = iQ;
                return true;
            }
            i2--;
            if (i2 < 0) {
                return false;
            }
            iQ = iQ == 0 ? M() - 1 : iQ - 1;
        }
    }

    private final void V() {
        this.h++;
    }

    private final void W(int i) {
        V();
        int i2 = 0;
        if (this.f > size()) {
            s(false);
        }
        this.d = new int[i];
        this.g = n.d(i);
        while (i2 < this.f) {
            int i3 = i2 + 1;
            if (!U(i2)) {
                throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
            }
            i2 = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y(int i) {
        BB3.f(this.a, i);
        Object[] objArr = this.b;
        if (objArr != null) {
            BB3.f(objArr, i);
        }
        Z(this.c[i]);
        this.c[i] = -1;
        this.i = size() - 1;
        V();
    }

    private final void Z(int i) {
        int i2 = AbstractC23053wG5.i(this.e * 2, M() / 2);
        int i3 = 0;
        int i4 = i;
        do {
            i = i == 0 ? M() - 1 : i - 1;
            i3++;
            if (i3 > this.e) {
                this.d[i4] = 0;
                return;
            }
            int[] iArr = this.d;
            int i5 = iArr[i];
            if (i5 == 0) {
                iArr[i4] = 0;
                return;
            }
            if (i5 < 0) {
                iArr[i4] = -1;
            } else {
                int i6 = i5 - 1;
                if (((Q(this.a[i6]) - i) & (M() - 1)) >= i3) {
                    this.d[i4] = i5;
                    this.c[i6] = i4;
                }
                i2--;
            }
            i4 = i;
            i3 = 0;
            i2--;
        } while (i2 >= 0);
        this.d[i4] = -1;
    }

    private final boolean c0(int i) {
        int iK = K();
        int i2 = this.f;
        int i3 = iK - i2;
        int size = i2 - size();
        return i3 < i && i3 + size >= i && size >= K() / 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object[] n() {
        Object[] objArr = this.b;
        if (objArr != null) {
            return objArr;
        }
        Object[] objArrD = BB3.d(K());
        this.b = objArrD;
        return objArrD;
    }

    private final void s(boolean z) {
        int i;
        Object[] objArr = this.b;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = this.f;
            if (i2 >= i) {
                break;
            }
            int[] iArr = this.c;
            int i4 = iArr[i2];
            if (i4 >= 0) {
                Object[] objArr2 = this.a;
                objArr2[i3] = objArr2[i2];
                if (objArr != null) {
                    objArr[i3] = objArr[i2];
                }
                if (z) {
                    iArr[i3] = i4;
                    this.d[i4] = i3 + 1;
                }
                i3++;
            }
            i2++;
        }
        BB3.g(this.a, i3, i);
        if (objArr != null) {
            BB3.g(objArr, i3, this.f);
        }
        this.f = i3;
    }

    public final b G() {
        return new b(this);
    }

    public final int K() {
        return this.a.length;
    }

    public Set L() {
        KN3 kn3 = this.l;
        if (kn3 != null) {
            return kn3;
        }
        KN3 kn32 = new KN3(this);
        this.l = kn32;
        return kn32;
    }

    public Set N() {
        LN3 ln3 = this.j;
        if (ln3 != null) {
            return ln3;
        }
        LN3 ln32 = new LN3(this);
        this.j = ln32;
        return ln32;
    }

    public int O() {
        return this.i;
    }

    public Collection P() {
        MN3 mn3 = this.k;
        if (mn3 != null) {
            return mn3;
        }
        MN3 mn32 = new MN3(this);
        this.k = mn32;
        return mn32;
    }

    public final e R() {
        return new e(this);
    }

    public final boolean X(Map.Entry entry) {
        AbstractC13042fc3.i(entry, "entry");
        q();
        int iH = H(entry.getKey());
        if (iH < 0) {
            return false;
        }
        Object[] objArr = this.b;
        AbstractC13042fc3.f(objArr);
        if (!AbstractC13042fc3.d(objArr[iH], entry.getValue())) {
            return false;
        }
        Y(iH);
        return true;
    }

    public final boolean a0(Object obj) {
        q();
        int iH = H(obj);
        if (iH < 0) {
            return false;
        }
        Y(iH);
        return true;
    }

    public final boolean b0(Object obj) {
        q();
        int iJ = J(obj);
        if (iJ < 0) {
            return false;
        }
        Y(iJ);
        return true;
    }

    @Override // java.util.Map
    public void clear() {
        q();
        int i = this.f - 1;
        if (i >= 0) {
            int i2 = 0;
            while (true) {
                int[] iArr = this.c;
                int i3 = iArr[i2];
                if (i3 >= 0) {
                    this.d[i3] = 0;
                    iArr[i2] = -1;
                }
                if (i2 == i) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        BB3.g(this.a, 0, this.f);
        Object[] objArr = this.b;
        if (objArr != null) {
            BB3.g(objArr, 0, this.f);
        }
        this.i = 0;
        this.f = 0;
        V();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return H(obj) >= 0;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return J(obj) >= 0;
    }

    public final f d0() {
        return new f(this);
    }

    @Override // java.util.Map
    public final /* bridge */ Set entrySet() {
        return L();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof Map) && C((Map) obj));
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        int iH = H(obj);
        if (iH < 0) {
            return null;
        }
        Object[] objArr = this.b;
        AbstractC13042fc3.f(objArr);
        return objArr[iH];
    }

    @Override // java.util.Map
    public int hashCode() {
        b bVarG = G();
        int iL = 0;
        while (bVarG.hasNext()) {
            iL += bVarG.l();
        }
        return iL;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public final /* bridge */ Set keySet() {
        return N();
    }

    public final int l(Object obj) {
        q();
        while (true) {
            int iQ = Q(obj);
            int i = AbstractC23053wG5.i(this.e * 2, M() / 2);
            int i2 = 0;
            while (true) {
                int i3 = this.d[iQ];
                if (i3 <= 0) {
                    if (this.f < K()) {
                        int i4 = this.f;
                        int i5 = i4 + 1;
                        this.f = i5;
                        this.a[i4] = obj;
                        this.c[i4] = iQ;
                        this.d[iQ] = i5;
                        this.i = size() + 1;
                        V();
                        if (i2 > this.e) {
                            this.e = i2;
                        }
                        return i4;
                    }
                    F(1);
                } else {
                    if (AbstractC13042fc3.d(this.a[i3 - 1], obj)) {
                        return -i3;
                    }
                    i2++;
                    if (i2 > i) {
                        W(M() * 2);
                        break;
                    }
                    iQ = iQ == 0 ? M() - 1 : iQ - 1;
                }
            }
        }
    }

    public final Map p() {
        q();
        this.m = true;
        if (size() > 0) {
            return this;
        }
        JN3 jn3 = o;
        AbstractC13042fc3.g(jn3, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.builders.MapBuilder, V of kotlin.collections.builders.MapBuilder>");
        return jn3;
    }

    @Override // java.util.Map
    public Object put(Object obj, Object obj2) {
        q();
        int iL = l(obj);
        Object[] objArrN = n();
        if (iL >= 0) {
            objArrN[iL] = obj2;
            return null;
        }
        int i = (-iL) - 1;
        Object obj3 = objArrN[i];
        objArrN[i] = obj2;
        return obj3;
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        AbstractC13042fc3.i(map, "from");
        q();
        S(map.entrySet());
    }

    public final void q() {
        if (this.m) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        q();
        int iH = H(obj);
        if (iH < 0) {
            return null;
        }
        Object[] objArr = this.b;
        AbstractC13042fc3.f(objArr);
        Object obj2 = objArr[iH];
        Y(iH);
        return obj2;
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return O();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((size() * 3) + 2);
        sb.append("{");
        b bVarG = G();
        int i = 0;
        while (bVarG.hasNext()) {
            if (i > 0) {
                sb.append(", ");
            }
            bVarG.k(sb);
            i++;
        }
        sb.append("}");
        String string = sb.toString();
        AbstractC13042fc3.h(string, "toString(...)");
        return string;
    }

    public final boolean u(Collection collection) {
        AbstractC13042fc3.i(collection, "m");
        for (Object obj : collection) {
            if (obj != null) {
                try {
                    if (!y((Map.Entry) obj)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.Map
    public final /* bridge */ Collection values() {
        return P();
    }

    public final boolean y(Map.Entry entry) {
        AbstractC13042fc3.i(entry, "entry");
        int iH = H(entry.getKey());
        if (iH < 0) {
            return false;
        }
        Object[] objArr = this.b;
        AbstractC13042fc3.f(objArr);
        return AbstractC13042fc3.d(objArr[iH], entry.getValue());
    }

    public JN3() {
        this(8);
    }

    public JN3(int i) {
        this(BB3.d(i), null, new int[i], new int[n.c(i)], 2, 0);
    }
}
