package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.s;
import ir.nasim.C22127ui5;
import ir.nasim.InterfaceC20850si5;
import java.util.ArrayList;
import java.util.List;

/* renamed from: androidx.recyclerview.widget.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C1975a implements s.a {
    private InterfaceC20850si5 a;
    final ArrayList b;
    final ArrayList c;
    final InterfaceC0110a d;
    Runnable e;
    final boolean f;
    final s g;
    private int h;

    /* renamed from: androidx.recyclerview.widget.a$a, reason: collision with other inner class name */
    interface InterfaceC0110a {
        void a(int i, int i2);

        void b(b bVar);

        void c(b bVar);

        void d(int i, int i2);

        void e(int i, int i2, Object obj);

        RecyclerView.C f(int i);

        void g(int i, int i2);

        void h(int i, int i2);
    }

    /* renamed from: androidx.recyclerview.widget.a$b */
    static final class b {
        int a;
        int b;
        Object c;
        int d;

        b(int i, int i2, int i3, Object obj) {
            this.a = i;
            this.b = i2;
            this.d = i3;
            this.c = obj;
        }

        String a() {
            int i = this.a;
            return i != 1 ? i != 2 ? i != 4 ? i != 8 ? "??" : "mv" : "up" : "rm" : "add";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            int i = this.a;
            if (i != bVar.a) {
                return false;
            }
            if (i == 8 && Math.abs(this.d - this.b) == 1 && this.d == bVar.b && this.b == bVar.d) {
                return true;
            }
            if (this.d != bVar.d || this.b != bVar.b) {
                return false;
            }
            Object obj2 = this.c;
            if (obj2 != null) {
                if (!obj2.equals(bVar.c)) {
                    return false;
                }
            } else if (bVar.c != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.a * 31) + this.b) * 31) + this.d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.b + "c:" + this.d + ",p:" + this.c + "]";
        }
    }

    C1975a(InterfaceC0110a interfaceC0110a) {
        this(interfaceC0110a, false);
    }

    private void c(b bVar) {
        v(bVar);
    }

    private void d(b bVar) {
        v(bVar);
    }

    private void f(b bVar) {
        boolean z;
        char c;
        int i = bVar.b;
        int i2 = bVar.d + i;
        char c2 = 65535;
        int i3 = i;
        int i4 = 0;
        while (i3 < i2) {
            if (this.d.f(i3) != null || h(i3)) {
                if (c2 == 0) {
                    k(a(2, i, i4, null));
                    z = true;
                } else {
                    z = false;
                }
                c = 1;
            } else {
                if (c2 == 1) {
                    v(a(2, i, i4, null));
                    z = true;
                } else {
                    z = false;
                }
                c = 0;
            }
            if (z) {
                i3 -= i4;
                i2 -= i4;
                i4 = 1;
            } else {
                i4++;
            }
            i3++;
            c2 = c;
        }
        if (i4 != bVar.d) {
            b(bVar);
            bVar = a(2, i, i4, null);
        }
        if (c2 == 0) {
            k(bVar);
        } else {
            v(bVar);
        }
    }

    private void g(b bVar) {
        int i = bVar.b;
        int i2 = bVar.d + i;
        int i3 = 0;
        boolean z = -1;
        int i4 = i;
        while (i < i2) {
            if (this.d.f(i) != null || h(i)) {
                if (!z) {
                    k(a(4, i4, i3, bVar.c));
                    i4 = i;
                    i3 = 0;
                }
                z = true;
            } else {
                if (z) {
                    v(a(4, i4, i3, bVar.c));
                    i4 = i;
                    i3 = 0;
                }
                z = false;
            }
            i3++;
            i++;
        }
        if (i3 != bVar.d) {
            Object obj = bVar.c;
            b(bVar);
            bVar = a(4, i4, i3, obj);
        }
        if (z) {
            v(bVar);
        } else {
            k(bVar);
        }
    }

    private boolean h(int i) {
        int size = this.c.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = (b) this.c.get(i2);
            int i3 = bVar.a;
            if (i3 == 8) {
                if (n(bVar.d, i2 + 1) == i) {
                    return true;
                }
            } else if (i3 == 1) {
                int i4 = bVar.b;
                int i5 = bVar.d + i4;
                while (i4 < i5) {
                    if (n(i4, i2 + 1) == i) {
                        return true;
                    }
                    i4++;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    private void k(b bVar) {
        int i;
        int i2 = bVar.a;
        if (i2 == 1 || i2 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int iZ = z(bVar.b, i2);
        int i3 = bVar.b;
        int i4 = bVar.a;
        if (i4 == 2) {
            i = 0;
        } else {
            if (i4 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + bVar);
            }
            i = 1;
        }
        int i5 = 1;
        for (int i6 = 1; i6 < bVar.d; i6++) {
            int iZ2 = z(bVar.b + (i * i6), bVar.a);
            int i7 = bVar.a;
            if (i7 == 2 ? iZ2 != iZ : !(i7 == 4 && iZ2 == iZ + 1)) {
                b bVarA = a(i7, iZ, i5, bVar.c);
                l(bVarA, i3);
                b(bVarA);
                if (bVar.a == 4) {
                    i3 += i5;
                }
                i5 = 1;
                iZ = iZ2;
            } else {
                i5++;
            }
        }
        Object obj = bVar.c;
        b(bVar);
        if (i5 > 0) {
            b bVarA2 = a(bVar.a, iZ, i5, obj);
            l(bVarA2, i3);
            b(bVarA2);
        }
    }

    private void v(b bVar) {
        this.c.add(bVar);
        int i = bVar.a;
        if (i == 1) {
            this.d.g(bVar.b, bVar.d);
            return;
        }
        if (i == 2) {
            this.d.d(bVar.b, bVar.d);
            return;
        }
        if (i == 4) {
            this.d.e(bVar.b, bVar.d, bVar.c);
        } else {
            if (i == 8) {
                this.d.a(bVar.b, bVar.d);
                return;
            }
            throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    private int z(int i, int i2) {
        int i3;
        int i4;
        for (int size = this.c.size() - 1; size >= 0; size--) {
            b bVar = (b) this.c.get(size);
            int i5 = bVar.a;
            if (i5 == 8) {
                int i6 = bVar.b;
                int i7 = bVar.d;
                if (i6 < i7) {
                    i4 = i6;
                    i3 = i7;
                } else {
                    i3 = i6;
                    i4 = i7;
                }
                if (i < i4 || i > i3) {
                    if (i < i6) {
                        if (i2 == 1) {
                            bVar.b = i6 + 1;
                            bVar.d = i7 + 1;
                        } else if (i2 == 2) {
                            bVar.b = i6 - 1;
                            bVar.d = i7 - 1;
                        }
                    }
                } else if (i4 == i6) {
                    if (i2 == 1) {
                        bVar.d = i7 + 1;
                    } else if (i2 == 2) {
                        bVar.d = i7 - 1;
                    }
                    i++;
                } else {
                    if (i2 == 1) {
                        bVar.b = i6 + 1;
                    } else if (i2 == 2) {
                        bVar.b = i6 - 1;
                    }
                    i--;
                }
            } else {
                int i8 = bVar.b;
                if (i8 <= i) {
                    if (i5 == 1) {
                        i -= bVar.d;
                    } else if (i5 == 2) {
                        i += bVar.d;
                    }
                } else if (i2 == 1) {
                    bVar.b = i8 + 1;
                } else if (i2 == 2) {
                    bVar.b = i8 - 1;
                }
            }
        }
        for (int size2 = this.c.size() - 1; size2 >= 0; size2--) {
            b bVar2 = (b) this.c.get(size2);
            if (bVar2.a == 8) {
                int i9 = bVar2.d;
                if (i9 == bVar2.b || i9 < 0) {
                    this.c.remove(size2);
                    b(bVar2);
                }
            } else if (bVar2.d <= 0) {
                this.c.remove(size2);
                b(bVar2);
            }
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.s.a
    public b a(int i, int i2, int i3, Object obj) {
        b bVar = (b) this.a.b();
        if (bVar == null) {
            return new b(i, i2, i3, obj);
        }
        bVar.a = i;
        bVar.b = i2;
        bVar.d = i3;
        bVar.c = obj;
        return bVar;
    }

    @Override // androidx.recyclerview.widget.s.a
    public void b(b bVar) {
        if (this.f) {
            return;
        }
        bVar.c = null;
        this.a.a(bVar);
    }

    public int e(int i) {
        int size = this.b.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = (b) this.b.get(i2);
            int i3 = bVar.a;
            if (i3 != 1) {
                if (i3 == 2) {
                    int i4 = bVar.b;
                    if (i4 <= i) {
                        int i5 = bVar.d;
                        if (i4 + i5 > i) {
                            return -1;
                        }
                        i -= i5;
                    } else {
                        continue;
                    }
                } else if (i3 == 8) {
                    int i6 = bVar.b;
                    if (i6 == i) {
                        i = bVar.d;
                    } else {
                        if (i6 < i) {
                            i--;
                        }
                        if (bVar.d <= i) {
                            i++;
                        }
                    }
                }
            } else if (bVar.b <= i) {
                i += bVar.d;
            }
        }
        return i;
    }

    void i() {
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            this.d.c((b) this.c.get(i));
        }
        x(this.c);
        this.h = 0;
    }

    void j() {
        i();
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            b bVar = (b) this.b.get(i);
            int i2 = bVar.a;
            if (i2 == 1) {
                this.d.c(bVar);
                this.d.g(bVar.b, bVar.d);
            } else if (i2 == 2) {
                this.d.c(bVar);
                this.d.h(bVar.b, bVar.d);
            } else if (i2 == 4) {
                this.d.c(bVar);
                this.d.e(bVar.b, bVar.d, bVar.c);
            } else if (i2 == 8) {
                this.d.c(bVar);
                this.d.a(bVar.b, bVar.d);
            }
            Runnable runnable = this.e;
            if (runnable != null) {
                runnable.run();
            }
        }
        x(this.b);
        this.h = 0;
    }

    void l(b bVar, int i) {
        this.d.b(bVar);
        int i2 = bVar.a;
        if (i2 == 2) {
            this.d.h(i, bVar.d);
        } else {
            if (i2 != 4) {
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            }
            this.d.e(i, bVar.d, bVar.c);
        }
    }

    int m(int i) {
        return n(i, 0);
    }

    int n(int i, int i2) {
        int size = this.c.size();
        while (i2 < size) {
            b bVar = (b) this.c.get(i2);
            int i3 = bVar.a;
            if (i3 == 8) {
                int i4 = bVar.b;
                if (i4 == i) {
                    i = bVar.d;
                } else {
                    if (i4 < i) {
                        i--;
                    }
                    if (bVar.d <= i) {
                        i++;
                    }
                }
            } else {
                int i5 = bVar.b;
                if (i5 > i) {
                    continue;
                } else if (i3 == 2) {
                    int i6 = bVar.d;
                    if (i < i5 + i6) {
                        return -1;
                    }
                    i -= i6;
                } else if (i3 == 1) {
                    i += bVar.d;
                }
            }
            i2++;
        }
        return i;
    }

    boolean o(int i) {
        return (i & this.h) != 0;
    }

    boolean p() {
        return this.b.size() > 0;
    }

    boolean q() {
        return (this.c.isEmpty() || this.b.isEmpty()) ? false : true;
    }

    boolean r(int i, int i2, Object obj) {
        if (i2 < 1) {
            return false;
        }
        this.b.add(a(4, i, i2, obj));
        this.h |= 4;
        return this.b.size() == 1;
    }

    boolean s(int i, int i2) {
        if (i2 < 1) {
            return false;
        }
        this.b.add(a(1, i, i2, null));
        this.h |= 1;
        return this.b.size() == 1;
    }

    boolean t(int i, int i2, int i3) {
        if (i == i2) {
            return false;
        }
        if (i3 != 1) {
            throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
        }
        this.b.add(a(8, i, i2, null));
        this.h |= 8;
        return this.b.size() == 1;
    }

    boolean u(int i, int i2) {
        if (i2 < 1) {
            return false;
        }
        this.b.add(a(2, i, i2, null));
        this.h |= 2;
        return this.b.size() == 1;
    }

    void w() {
        this.g.b(this.b);
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            b bVar = (b) this.b.get(i);
            int i2 = bVar.a;
            if (i2 == 1) {
                c(bVar);
            } else if (i2 == 2) {
                f(bVar);
            } else if (i2 == 4) {
                g(bVar);
            } else if (i2 == 8) {
                d(bVar);
            }
            Runnable runnable = this.e;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.b.clear();
    }

    void x(List list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            b((b) list.get(i));
        }
        list.clear();
    }

    void y() {
        x(this.b);
        x(this.c);
        this.h = 0;
    }

    C1975a(InterfaceC0110a interfaceC0110a, boolean z) {
        this.a = new C22127ui5(30);
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.h = 0;
        this.d = interfaceC0110a;
        this.f = z;
        this.g = new s(this);
    }
}
