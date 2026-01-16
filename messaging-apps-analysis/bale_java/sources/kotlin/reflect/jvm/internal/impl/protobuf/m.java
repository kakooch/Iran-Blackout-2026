package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;
import kotlin.reflect.jvm.internal.impl.protobuf.d;

/* loaded from: classes8.dex */
class m extends kotlin.reflect.jvm.internal.impl.protobuf.d {
    private static final int[] h;
    private final int b;
    private final kotlin.reflect.jvm.internal.impl.protobuf.d c;
    private final kotlin.reflect.jvm.internal.impl.protobuf.d d;
    private final int e;
    private final int f;
    private int g;

    private static class b {
        private final Stack a;

        private b() {
            this.a = new Stack();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public kotlin.reflect.jvm.internal.impl.protobuf.d b(kotlin.reflect.jvm.internal.impl.protobuf.d dVar, kotlin.reflect.jvm.internal.impl.protobuf.d dVar2) {
            c(dVar);
            c(dVar2);
            kotlin.reflect.jvm.internal.impl.protobuf.d mVar = (kotlin.reflect.jvm.internal.impl.protobuf.d) this.a.pop();
            while (!this.a.isEmpty()) {
                mVar = new m((kotlin.reflect.jvm.internal.impl.protobuf.d) this.a.pop(), mVar);
            }
            return mVar;
        }

        private void c(kotlin.reflect.jvm.internal.impl.protobuf.d dVar) {
            if (dVar.x()) {
                e(dVar);
                return;
            }
            if (dVar instanceof m) {
                m mVar = (m) dVar;
                c(mVar.c);
                c(mVar.d);
            } else {
                String strValueOf = String.valueOf(dVar.getClass());
                StringBuilder sb = new StringBuilder(strValueOf.length() + 49);
                sb.append("Has a new type of ByteString been created? Found ");
                sb.append(strValueOf);
                throw new IllegalArgumentException(sb.toString());
            }
        }

        private int d(int i) {
            int iBinarySearch = Arrays.binarySearch(m.h, i);
            return iBinarySearch < 0 ? (-(iBinarySearch + 1)) - 1 : iBinarySearch;
        }

        private void e(kotlin.reflect.jvm.internal.impl.protobuf.d dVar) {
            int iD = d(dVar.size());
            int i = m.h[iD + 1];
            if (this.a.isEmpty() || ((kotlin.reflect.jvm.internal.impl.protobuf.d) this.a.peek()).size() >= i) {
                this.a.push(dVar);
                return;
            }
            int i2 = m.h[iD];
            kotlin.reflect.jvm.internal.impl.protobuf.d mVar = (kotlin.reflect.jvm.internal.impl.protobuf.d) this.a.pop();
            while (true) {
                if (this.a.isEmpty() || ((kotlin.reflect.jvm.internal.impl.protobuf.d) this.a.peek()).size() >= i2) {
                    break;
                } else {
                    mVar = new m((kotlin.reflect.jvm.internal.impl.protobuf.d) this.a.pop(), mVar);
                }
            }
            m mVar2 = new m(mVar, dVar);
            while (!this.a.isEmpty()) {
                if (((kotlin.reflect.jvm.internal.impl.protobuf.d) this.a.peek()).size() >= m.h[d(mVar2.size()) + 1]) {
                    break;
                } else {
                    mVar2 = new m((kotlin.reflect.jvm.internal.impl.protobuf.d) this.a.pop(), mVar2);
                }
            }
            this.a.push(mVar2);
        }
    }

    private static class c implements Iterator {
        private final Stack a;
        private k b;

        private k a(kotlin.reflect.jvm.internal.impl.protobuf.d dVar) {
            while (dVar instanceof m) {
                m mVar = (m) dVar;
                this.a.push(mVar);
                dVar = mVar.c;
            }
            return (k) dVar;
        }

        private k b() {
            while (!this.a.isEmpty()) {
                k kVarA = a(((m) this.a.pop()).d);
                if (!kVarA.isEmpty()) {
                    return kVarA;
                }
            }
            return null;
        }

        @Override // java.util.Iterator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public k next() {
            k kVar = this.b;
            if (kVar == null) {
                throw new NoSuchElementException();
            }
            this.b = b();
            return kVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private c(kotlin.reflect.jvm.internal.impl.protobuf.d dVar) {
            this.a = new Stack();
            this.b = a(dVar);
        }
    }

    private class d implements d.a {
        private final c a;
        private d.a b;
        int c;

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Byte next() {
            return Byte.valueOf(j());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.c > 0;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.d.a
        public byte j() {
            if (!this.b.hasNext()) {
                this.b = this.a.next().iterator();
            }
            this.c--;
            return this.b.j();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private d() {
            c cVar = new c(m.this);
            this.a = cVar;
            this.b = cVar.next().iterator();
            this.c = m.this.size();
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int i2 = 1;
        while (i > 0) {
            arrayList.add(Integer.valueOf(i));
            int i3 = i2 + i;
            i2 = i;
            i = i3;
        }
        arrayList.add(Integer.MAX_VALUE);
        h = new int[arrayList.size()];
        int i4 = 0;
        while (true) {
            int[] iArr = h;
            if (i4 >= iArr.length) {
                return;
            }
            iArr[i4] = ((Integer) arrayList.get(i4)).intValue();
            i4++;
        }
    }

    static kotlin.reflect.jvm.internal.impl.protobuf.d S(kotlin.reflect.jvm.internal.impl.protobuf.d dVar, kotlin.reflect.jvm.internal.impl.protobuf.d dVar2) {
        m mVar = dVar instanceof m ? (m) dVar : null;
        if (dVar2.size() == 0) {
            return dVar;
        }
        if (dVar.size() != 0) {
            int size = dVar.size() + dVar2.size();
            if (size < 128) {
                return V(dVar, dVar2);
            }
            if (mVar != null && mVar.d.size() + dVar2.size() < 128) {
                dVar2 = new m(mVar.c, V(mVar.d, dVar2));
            } else {
                if (mVar == null || mVar.c.w() <= mVar.d.w() || mVar.w() <= dVar2.w()) {
                    return size >= h[Math.max(dVar.w(), dVar2.w()) + 1] ? new m(dVar, dVar2) : new b().b(dVar, dVar2);
                }
                dVar2 = new m(mVar.c, new m(mVar.d, dVar2));
            }
        }
        return dVar2;
    }

    private static k V(kotlin.reflect.jvm.internal.impl.protobuf.d dVar, kotlin.reflect.jvm.internal.impl.protobuf.d dVar2) {
        int size = dVar.size();
        int size2 = dVar2.size();
        byte[] bArr = new byte[size + size2];
        dVar.t(bArr, 0, 0, size);
        dVar2.t(bArr, 0, size, size2);
        return new k(bArr);
    }

    private boolean W(kotlin.reflect.jvm.internal.impl.protobuf.d dVar) {
        c cVar = new c(this);
        k kVar = (k) cVar.next();
        c cVar2 = new c(dVar);
        k kVar2 = (k) cVar2.next();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int size = kVar.size() - i;
            int size2 = kVar2.size() - i2;
            int iMin = Math.min(size, size2);
            if (!(i == 0 ? kVar.P(kVar2, i2, iMin) : kVar2.P(kVar, i, iMin))) {
                return false;
            }
            i3 += iMin;
            int i4 = this.b;
            if (i3 >= i4) {
                if (i3 == i4) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (iMin == size) {
                kVar = (k) cVar.next();
                i = 0;
            } else {
                i += iMin;
            }
            if (iMin == size2) {
                kVar2 = (k) cVar2.next();
                i2 = 0;
            } else {
                i2 += iMin;
            }
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public boolean A() {
        int iD = this.c.D(0, 0, this.e);
        kotlin.reflect.jvm.internal.impl.protobuf.d dVar = this.d;
        return dVar.D(iD, 0, dVar.size()) == 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected int C(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.e;
        if (i4 <= i5) {
            return this.c.C(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.d.C(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.d.C(this.c.C(i, i2, i6), 0, i3 - i6);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected int D(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.e;
        if (i4 <= i5) {
            return this.c.D(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.d.D(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.d.D(this.c.D(i, i2, i6), 0, i3 - i6);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected int E() {
        return this.g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public String I(String str) {
        return new String(F(), str);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    void O(OutputStream outputStream, int i, int i2) {
        int i3 = i + i2;
        int i4 = this.e;
        if (i3 <= i4) {
            this.c.O(outputStream, i, i2);
        } else {
            if (i >= i4) {
                this.d.O(outputStream, i - i4, i2);
                return;
            }
            int i5 = i4 - i;
            this.c.O(outputStream, i, i5);
            this.d.O(outputStream, 0, i2 - i5);
        }
    }

    @Override // java.lang.Iterable
    /* renamed from: Y, reason: merged with bridge method [inline-methods] */
    public d.a iterator() {
        return new d();
    }

    public boolean equals(Object obj) {
        int iE;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof kotlin.reflect.jvm.internal.impl.protobuf.d)) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.protobuf.d dVar = (kotlin.reflect.jvm.internal.impl.protobuf.d) obj;
        if (this.b != dVar.size()) {
            return false;
        }
        if (this.b == 0) {
            return true;
        }
        if (this.g == 0 || (iE = dVar.E()) == 0 || this.g == iE) {
            return W(dVar);
        }
        return false;
    }

    public int hashCode() {
        int iC = this.g;
        if (iC == 0) {
            int i = this.b;
            iC = C(i, 0, i);
            if (iC == 0) {
                iC = 1;
            }
            this.g = iC;
        }
        return iC;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public int size() {
        return this.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected void v(byte[] bArr, int i, int i2, int i3) {
        int i4 = i + i3;
        int i5 = this.e;
        if (i4 <= i5) {
            this.c.v(bArr, i, i2, i3);
        } else {
            if (i >= i5) {
                this.d.v(bArr, i - i5, i2, i3);
                return;
            }
            int i6 = i5 - i;
            this.c.v(bArr, i, i2, i6);
            this.d.v(bArr, 0, i2 + i6, i3 - i6);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected int w() {
        return this.f;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected boolean x() {
        return this.b >= h[this.f];
    }

    private m(kotlin.reflect.jvm.internal.impl.protobuf.d dVar, kotlin.reflect.jvm.internal.impl.protobuf.d dVar2) {
        this.g = 0;
        this.c = dVar;
        this.d = dVar2;
        int size = dVar.size();
        this.e = size;
        this.b = size + dVar2.size();
        this.f = Math.max(dVar.w(), dVar2.w()) + 1;
    }
}
