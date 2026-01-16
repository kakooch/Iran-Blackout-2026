package androidx.recyclerview.widget;

import ir.nasim.C23258wd0;
import ir.nasim.InterfaceC12197eC3;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class i {
    private static final Comparator a = new a();

    class a implements Comparator {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(d dVar, d dVar2) {
            return dVar.a - dVar2.a;
        }
    }

    public static abstract class b {
        public abstract boolean a(int i, int i2);

        public abstract boolean b(int i, int i2);

        public abstract Object c(int i, int i2);

        public abstract int d();

        public abstract int e();
    }

    static class c {
        private final int[] a;
        private final int b;

        c(int i) {
            int[] iArr = new int[i];
            this.a = iArr;
            this.b = iArr.length / 2;
        }

        int[] a() {
            return this.a;
        }

        int b(int i) {
            return this.a[i + this.b];
        }

        void c(int i, int i2) {
            this.a[i + this.b] = i2;
        }
    }

    static class d {
        public final int a;
        public final int b;
        public final int c;

        d(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
        }

        int a() {
            return this.a + this.c;
        }

        int b() {
            return this.b + this.c;
        }
    }

    public static class e {
        private final List a;
        private final int[] b;
        private final int[] c;
        private final b d;
        private final int e;
        private final int f;
        private final boolean g;

        e(b bVar, List list, int[] iArr, int[] iArr2, boolean z) {
            this.a = list;
            this.b = iArr;
            this.c = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 0);
            this.d = bVar;
            this.e = bVar.e();
            this.f = bVar.d();
            this.g = z;
            a();
            e();
        }

        private void a() {
            d dVar = this.a.isEmpty() ? null : (d) this.a.get(0);
            if (dVar == null || dVar.a != 0 || dVar.b != 0) {
                this.a.add(0, new d(0, 0, 0));
            }
            this.a.add(new d(this.e, this.f, 0));
        }

        private void d(int i) {
            int size = this.a.size();
            int iB = 0;
            for (int i2 = 0; i2 < size; i2++) {
                d dVar = (d) this.a.get(i2);
                while (iB < dVar.b) {
                    if (this.c[iB] == 0 && this.d.b(i, iB)) {
                        int i3 = this.d.a(i, iB) ? 8 : 4;
                        this.b[i] = (iB << 4) | i3;
                        this.c[iB] = (i << 4) | i3;
                        return;
                    }
                    iB++;
                }
                iB = dVar.b();
            }
        }

        private void e() {
            for (d dVar : this.a) {
                for (int i = 0; i < dVar.c; i++) {
                    int i2 = dVar.a + i;
                    int i3 = dVar.b + i;
                    int i4 = this.d.a(i2, i3) ? 1 : 2;
                    this.b[i2] = (i3 << 4) | i4;
                    this.c[i3] = (i2 << 4) | i4;
                }
            }
            if (this.g) {
                f();
            }
        }

        private void f() {
            int iA = 0;
            for (d dVar : this.a) {
                while (iA < dVar.a) {
                    if (this.b[iA] == 0) {
                        d(iA);
                    }
                    iA++;
                }
                iA = dVar.a();
            }
        }

        private static g g(Collection collection, int i, boolean z) {
            g gVar;
            Iterator it = collection.iterator();
            while (true) {
                if (!it.hasNext()) {
                    gVar = null;
                    break;
                }
                gVar = (g) it.next();
                if (gVar.a == i && gVar.c == z) {
                    it.remove();
                    break;
                }
            }
            while (it.hasNext()) {
                g gVar2 = (g) it.next();
                if (z) {
                    gVar2.b--;
                } else {
                    gVar2.b++;
                }
            }
            return gVar;
        }

        public int b(int i) {
            if (i >= 0 && i < this.e) {
                int i2 = this.b[i];
                if ((i2 & 15) == 0) {
                    return -1;
                }
                return i2 >> 4;
            }
            throw new IndexOutOfBoundsException("Index out of bounds - passed position = " + i + ", old list size = " + this.e);
        }

        public void c(InterfaceC12197eC3 interfaceC12197eC3) {
            int i;
            C23258wd0 c23258wd0 = interfaceC12197eC3 instanceof C23258wd0 ? (C23258wd0) interfaceC12197eC3 : new C23258wd0(interfaceC12197eC3);
            int i2 = this.e;
            ArrayDeque arrayDeque = new ArrayDeque();
            int i3 = this.e;
            int i4 = this.f;
            for (int size = this.a.size() - 1; size >= 0; size--) {
                d dVar = (d) this.a.get(size);
                int iA = dVar.a();
                int iB = dVar.b();
                while (true) {
                    if (i3 <= iA) {
                        break;
                    }
                    i3--;
                    int i5 = this.b[i3];
                    if ((i5 & 12) != 0) {
                        int i6 = i5 >> 4;
                        g gVarG = g(arrayDeque, i6, false);
                        if (gVarG != null) {
                            int i7 = (i2 - gVarG.b) - 1;
                            c23258wd0.d(i3, i7);
                            if ((i5 & 4) != 0) {
                                c23258wd0.c(i7, 1, this.d.c(i3, i6));
                            }
                        } else {
                            arrayDeque.add(new g(i3, (i2 - i3) - 1, true));
                        }
                    } else {
                        c23258wd0.b(i3, 1);
                        i2--;
                    }
                }
                while (i4 > iB) {
                    i4--;
                    int i8 = this.c[i4];
                    if ((i8 & 12) != 0) {
                        int i9 = i8 >> 4;
                        g gVarG2 = g(arrayDeque, i9, true);
                        if (gVarG2 == null) {
                            arrayDeque.add(new g(i4, i2 - i3, false));
                        } else {
                            c23258wd0.d((i2 - gVarG2.b) - 1, i3);
                            if ((i8 & 4) != 0) {
                                c23258wd0.c(i3, 1, this.d.c(i9, i4));
                            }
                        }
                    } else {
                        c23258wd0.a(i3, 1);
                        i2++;
                    }
                }
                int i10 = dVar.a;
                int i11 = dVar.b;
                for (i = 0; i < dVar.c; i++) {
                    if ((this.b[i10] & 15) == 2) {
                        c23258wd0.c(i10, 1, this.d.c(i10, i11));
                    }
                    i10++;
                    i11++;
                }
                i3 = dVar.a;
                i4 = dVar.b;
            }
            c23258wd0.e();
        }
    }

    public static abstract class f {
        public abstract boolean a(Object obj, Object obj2);

        public abstract boolean b(Object obj, Object obj2);

        public Object c(Object obj, Object obj2) {
            return null;
        }
    }

    private static class g {
        int a;
        int b;
        boolean c;

        g(int i, int i2, boolean z) {
            this.a = i;
            this.b = i2;
            this.c = z;
        }
    }

    static class h {
        int a;
        int b;
        int c;
        int d;

        public h() {
        }

        int a() {
            return this.d - this.c;
        }

        int b() {
            return this.b - this.a;
        }

        public h(int i, int i2, int i3, int i4) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }
    }

    /* renamed from: androidx.recyclerview.widget.i$i, reason: collision with other inner class name */
    static class C0114i {
        public int a;
        public int b;
        public int c;
        public int d;
        public boolean e;

        C0114i() {
        }

        int a() {
            return Math.min(this.c - this.a, this.d - this.b);
        }

        boolean b() {
            return this.d - this.b != this.c - this.a;
        }

        boolean c() {
            return this.d - this.b > this.c - this.a;
        }

        d d() {
            if (b()) {
                return this.e ? new d(this.a, this.b, a()) : c() ? new d(this.a, this.b + 1, a()) : new d(this.a + 1, this.b, a());
            }
            int i = this.a;
            return new d(i, this.b, this.c - i);
        }
    }

    private static C0114i a(h hVar, b bVar, c cVar, c cVar2, int i) {
        int iB;
        int i2;
        int i3;
        boolean z = (hVar.b() - hVar.a()) % 2 == 0;
        int iB2 = hVar.b() - hVar.a();
        int i4 = -i;
        for (int i5 = i4; i5 <= i; i5 += 2) {
            if (i5 == i4 || (i5 != i && cVar2.b(i5 + 1) < cVar2.b(i5 - 1))) {
                iB = cVar2.b(i5 + 1);
                i2 = iB;
            } else {
                iB = cVar2.b(i5 - 1);
                i2 = iB - 1;
            }
            int i6 = hVar.d - ((hVar.b - i2) - i5);
            int i7 = (i == 0 || i2 != iB) ? i6 : i6 + 1;
            while (i2 > hVar.a && i6 > hVar.c && bVar.b(i2 - 1, i6 - 1)) {
                i2--;
                i6--;
            }
            cVar2.c(i5, i2);
            if (z && (i3 = iB2 - i5) >= i4 && i3 <= i && cVar.b(i3) >= i2) {
                C0114i c0114i = new C0114i();
                c0114i.a = i2;
                c0114i.b = i6;
                c0114i.c = iB;
                c0114i.d = i7;
                c0114i.e = true;
                return c0114i;
            }
        }
        return null;
    }

    public static e b(b bVar) {
        return c(bVar, true);
    }

    public static e c(b bVar, boolean z) {
        int iE = bVar.e();
        int iD = bVar.d();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new h(0, iE, 0, iD));
        int i = ((((iE + iD) + 1) / 2) * 2) + 1;
        c cVar = new c(i);
        c cVar2 = new c(i);
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            h hVar = (h) arrayList2.remove(arrayList2.size() - 1);
            C0114i c0114iE = e(hVar, bVar, cVar, cVar2);
            if (c0114iE != null) {
                if (c0114iE.a() > 0) {
                    arrayList.add(c0114iE.d());
                }
                h hVar2 = arrayList3.isEmpty() ? new h() : (h) arrayList3.remove(arrayList3.size() - 1);
                hVar2.a = hVar.a;
                hVar2.c = hVar.c;
                hVar2.b = c0114iE.a;
                hVar2.d = c0114iE.b;
                arrayList2.add(hVar2);
                hVar.b = hVar.b;
                hVar.d = hVar.d;
                hVar.a = c0114iE.c;
                hVar.c = c0114iE.d;
                arrayList2.add(hVar);
            } else {
                arrayList3.add(hVar);
            }
        }
        Collections.sort(arrayList, a);
        return new e(bVar, arrayList, cVar.a(), cVar2.a(), z);
    }

    private static C0114i d(h hVar, b bVar, c cVar, c cVar2, int i) {
        int iB;
        int i2;
        int i3;
        boolean z = Math.abs(hVar.b() - hVar.a()) % 2 == 1;
        int iB2 = hVar.b() - hVar.a();
        int i4 = -i;
        for (int i5 = i4; i5 <= i; i5 += 2) {
            if (i5 == i4 || (i5 != i && cVar.b(i5 + 1) > cVar.b(i5 - 1))) {
                iB = cVar.b(i5 + 1);
                i2 = iB;
            } else {
                iB = cVar.b(i5 - 1);
                i2 = iB + 1;
            }
            int i6 = (hVar.c + (i2 - hVar.a)) - i5;
            int i7 = (i == 0 || i2 != iB) ? i6 : i6 - 1;
            while (i2 < hVar.b && i6 < hVar.d && bVar.b(i2, i6)) {
                i2++;
                i6++;
            }
            cVar.c(i5, i2);
            if (z && (i3 = iB2 - i5) >= i4 + 1 && i3 <= i - 1 && cVar2.b(i3) <= i2) {
                C0114i c0114i = new C0114i();
                c0114i.a = iB;
                c0114i.b = i7;
                c0114i.c = i2;
                c0114i.d = i6;
                c0114i.e = false;
                return c0114i;
            }
        }
        return null;
    }

    private static C0114i e(h hVar, b bVar, c cVar, c cVar2) {
        if (hVar.b() >= 1 && hVar.a() >= 1) {
            int iB = ((hVar.b() + hVar.a()) + 1) / 2;
            cVar.c(1, hVar.a);
            cVar2.c(1, hVar.b);
            for (int i = 0; i < iB; i++) {
                C0114i c0114iD = d(hVar, bVar, cVar, cVar2, i);
                if (c0114iD != null) {
                    return c0114iD;
                }
                C0114i c0114iA = a(hVar, bVar, cVar, cVar2, i);
                if (c0114iA != null) {
                    return c0114iA;
                }
            }
        }
        return null;
    }
}
