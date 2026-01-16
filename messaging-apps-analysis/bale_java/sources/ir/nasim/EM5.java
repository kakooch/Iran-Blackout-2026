package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
final class EM5 extends AbstractC13937h43 {
    static final AbstractC13937h43 h = new EM5(null, new Object[0], 0);
    private final transient Object e;
    final transient Object[] f;
    private final transient int g;

    static class a extends AbstractC14535i43 {
        private final transient AbstractC13937h43 c;
        private final transient Object[] d;
        private final transient int e;
        private final transient int f;

        /* renamed from: ir.nasim.EM5$a$a, reason: collision with other inner class name */
        class C0339a extends AbstractC12710f43 {
            C0339a() {
            }

            @Override // ir.nasim.Z33
            public boolean D() {
                return true;
            }

            @Override // java.util.List
            /* renamed from: c0, reason: merged with bridge method [inline-methods] */
            public Map.Entry get(int i) {
                AbstractC4029Dj5.h(i, a.this.f);
                int i2 = i * 2;
                Object obj = a.this.d[a.this.e + i2];
                Objects.requireNonNull(obj);
                Object obj2 = a.this.d[i2 + (a.this.e ^ 1)];
                Objects.requireNonNull(obj2);
                return new AbstractMap.SimpleImmutableEntry(obj, obj2);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return a.this.f;
            }
        }

        a(AbstractC13937h43 abstractC13937h43, Object[] objArr, int i, int i2) {
            this.c = abstractC13937h43;
            this.d = objArr;
            this.e = i;
            this.f = i2;
        }

        @Override // ir.nasim.Z33
        boolean D() {
            return true;
        }

        @Override // ir.nasim.AbstractC14535i43
        AbstractC12710f43 R() {
            return new C0339a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* renamed from: V */
        public DB7 iterator() {
            return f().iterator();
        }

        @Override // ir.nasim.Z33, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            return value != null && value.equals(this.c.get(key));
        }

        @Override // ir.nasim.Z33
        int j(Object[] objArr, int i) {
            return f().j(objArr, i);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f;
        }
    }

    static final class b extends AbstractC14535i43 {
        private final transient AbstractC13937h43 c;
        private final transient AbstractC12710f43 d;

        b(AbstractC13937h43 abstractC13937h43, AbstractC12710f43 abstractC12710f43) {
            this.c = abstractC13937h43;
            this.d = abstractC12710f43;
        }

        @Override // ir.nasim.Z33
        boolean D() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* renamed from: V */
        public DB7 iterator() {
            return f().iterator();
        }

        @Override // ir.nasim.Z33, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.c.get(obj) != null;
        }

        @Override // ir.nasim.AbstractC14535i43, ir.nasim.Z33
        public AbstractC12710f43 f() {
            return this.d;
        }

        @Override // ir.nasim.Z33
        int j(Object[] objArr, int i) {
            return f().j(objArr, i);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.c.size();
        }
    }

    static final class c extends AbstractC12710f43 {
        private final transient Object[] c;
        private final transient int d;
        private final transient int e;

        c(Object[] objArr, int i, int i2) {
            this.c = objArr;
            this.d = i;
            this.e = i2;
        }

        @Override // ir.nasim.Z33
        boolean D() {
            return true;
        }

        @Override // java.util.List
        public Object get(int i) {
            AbstractC4029Dj5.h(i, this.e);
            Object obj = this.c[(i * 2) + this.d];
            Objects.requireNonNull(obj);
            return obj;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.e;
        }
    }

    private EM5(Object obj, Object[] objArr, int i) {
        this.e = obj;
        this.f = objArr;
        this.g = i;
    }

    static EM5 s(int i, Object[] objArr) {
        if (i == 0) {
            return (EM5) h;
        }
        if (i != 1) {
            AbstractC4029Dj5.l(i, objArr.length >> 1);
            return new EM5(u(objArr, i, AbstractC14535i43.N(i), 0), objArr, i);
        }
        Object obj = objArr[0];
        Objects.requireNonNull(obj);
        Object obj2 = objArr[1];
        Objects.requireNonNull(obj2);
        MW0.a(obj, obj2);
        return new EM5(null, objArr, 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0045, code lost:
    
        r11[r5] = (byte) r1;
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x008b, code lost:
    
        r11[r5] = (short) r1;
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00c8, code lost:
    
        r11[r6] = r1;
        r2 = r2 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static java.lang.Object u(java.lang.Object[] r9, int r10, int r11, int r12) {
        /*
            Method dump skipped, instructions count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.EM5.u(java.lang.Object[], int, int, int):java.lang.Object");
    }

    private static IllegalArgumentException y(Object obj, Object obj2, Object[] objArr, int i) {
        String strValueOf = String.valueOf(obj);
        String strValueOf2 = String.valueOf(obj2);
        String strValueOf3 = String.valueOf(objArr[i]);
        String strValueOf4 = String.valueOf(objArr[i ^ 1]);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 39 + strValueOf2.length() + strValueOf3.length() + strValueOf4.length());
        sb.append("Multiple entries with same key: ");
        sb.append(strValueOf);
        sb.append(Separators.EQUALS);
        sb.append(strValueOf2);
        sb.append(" and ");
        sb.append(strValueOf3);
        sb.append(Separators.EQUALS);
        sb.append(strValueOf4);
        return new IllegalArgumentException(sb.toString());
    }

    static Object z(Object obj, Object[] objArr, int i, int i2, Object obj2) {
        if (obj2 == null) {
            return null;
        }
        if (i == 1) {
            Object obj3 = objArr[i2];
            Objects.requireNonNull(obj3);
            if (!obj3.equals(obj2)) {
                return null;
            }
            Object obj4 = objArr[i2 ^ 1];
            Objects.requireNonNull(obj4);
            return obj4;
        }
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            int length = bArr.length - 1;
            int iB = BU2.b(obj2.hashCode());
            while (true) {
                int i3 = iB & length;
                int i4 = bArr[i3] & 255;
                if (i4 == 255) {
                    return null;
                }
                if (obj2.equals(objArr[i4])) {
                    return objArr[i4 ^ 1];
                }
                iB = i3 + 1;
            }
        } else if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            int length2 = sArr.length - 1;
            int iB2 = BU2.b(obj2.hashCode());
            while (true) {
                int i5 = iB2 & length2;
                int i6 = sArr[i5] & 65535;
                if (i6 == 65535) {
                    return null;
                }
                if (obj2.equals(objArr[i6])) {
                    return objArr[i6 ^ 1];
                }
                iB2 = i5 + 1;
            }
        } else {
            int[] iArr = (int[]) obj;
            int length3 = iArr.length - 1;
            int iB3 = BU2.b(obj2.hashCode());
            while (true) {
                int i7 = iB3 & length3;
                int i8 = iArr[i7];
                if (i8 == -1) {
                    return null;
                }
                if (obj2.equals(objArr[i8])) {
                    return objArr[i8 ^ 1];
                }
                iB3 = i7 + 1;
            }
        }
    }

    @Override // ir.nasim.AbstractC13937h43
    AbstractC14535i43 f() {
        return new a(this, this.f, 0, this.g);
    }

    @Override // ir.nasim.AbstractC13937h43
    AbstractC14535i43 g() {
        return new b(this, new c(this.f, 0, this.g));
    }

    @Override // ir.nasim.AbstractC13937h43, java.util.Map
    public Object get(Object obj) {
        Object objZ = z(this.e, this.f, this.g, 0, obj);
        if (objZ == null) {
            return null;
        }
        return objZ;
    }

    @Override // ir.nasim.AbstractC13937h43
    Z33 j() {
        return new c(this.f, 1, this.g);
    }

    @Override // ir.nasim.AbstractC13937h43
    boolean l() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.g;
    }
}
