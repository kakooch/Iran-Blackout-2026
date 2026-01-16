package ir.nasim;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: ir.nasim.uE6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C21850uE6 implements InterfaceC7518Sb1, Iterable, InterfaceC17915nm3 {
    private int b;
    private int d;
    private int e;
    private boolean g;
    private int h;
    private HashMap j;
    private C16734lm4 k;
    private int[] a = new int[0];
    private Object[] c = new Object[0];
    private final Object f = new Object();
    private ArrayList i = new ArrayList();

    private final C6669Om b0(int i) {
        int i2;
        if (!(!this.g)) {
            AbstractC5138Ib1.s("use active SlotWriter to crate an anchor for location instead");
        }
        if (i < 0 || i >= (i2 = this.b)) {
            return null;
        }
        return AbstractC23036wE6.o(this.i, i, i2);
    }

    public final void A() {
        this.k = new C16734lm4(0, 1, null);
    }

    public final void B() {
        this.j = new HashMap();
    }

    public final boolean C() {
        return this.b > 0 && (this.a[1] & 67108864) != 0;
    }

    public final ArrayList E() {
        return this.i;
    }

    public final C16734lm4 F() {
        return this.k;
    }

    public final int[] I() {
        return this.a;
    }

    public final int L() {
        return this.b;
    }

    public final Object[] N() {
        return this.c;
    }

    public final int O() {
        return this.d;
    }

    public final HashMap P() {
        return this.j;
    }

    public final int Q() {
        return this.h;
    }

    public final boolean R() {
        return this.g;
    }

    public final boolean S(int i, C6669Om c6669Om) {
        if (!(!this.g)) {
            AbstractC5138Ib1.s("Writer is active");
        }
        if (!(i >= 0 && i < this.b)) {
            AbstractC5138Ib1.s("Invalid group index");
        }
        if (Y(c6669Om)) {
            int iP = AbstractC23036wE6.p(this.a, i) + i;
            int iA = c6669Om.a();
            if (i <= iA && iA < iP) {
                return true;
            }
        }
        return false;
    }

    public final C21176tE6 V() {
        if (this.g) {
            throw new IllegalStateException("Cannot read while a writer is pending".toString());
        }
        this.e++;
        return new C21176tE6(this);
    }

    public final C24216yE6 W() {
        if (!(!this.g)) {
            AbstractC5138Ib1.s("Cannot start a writer when another writer is pending");
        }
        if (!(this.e <= 0)) {
            AbstractC5138Ib1.s("Cannot start a writer when a reader is pending");
        }
        this.g = true;
        this.h++;
        return new C24216yE6(this);
    }

    public final boolean Y(C6669Om c6669Om) {
        int iT;
        return c6669Om.b() && (iT = AbstractC23036wE6.t(this.i, c6669Om.a(), this.b)) >= 0 && AbstractC13042fc3.d(this.i.get(iT), c6669Om);
    }

    public final void Z(int[] iArr, int i, Object[] objArr, int i2, ArrayList arrayList, HashMap map, C16734lm4 c16734lm4) {
        this.a = iArr;
        this.b = i;
        this.c = objArr;
        this.d = i2;
        this.i = arrayList;
        this.j = map;
        this.k = c16734lm4;
    }

    public final VN2 a0(int i) {
        C6669Om c6669OmB0;
        HashMap map = this.j;
        if (map == null || (c6669OmB0 = b0(i)) == null) {
            return null;
        }
        return (VN2) map.get(c6669OmB0);
    }

    public boolean isEmpty() {
        return this.b == 0;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return new C19441qM2(this, 0, this.b);
    }

    public final C6669Om o(int i) {
        if (!(!this.g)) {
            AbstractC5138Ib1.s("use active SlotWriter to create an anchor location instead");
        }
        boolean z = false;
        if (i >= 0 && i < this.b) {
            z = true;
        }
        if (!z) {
            AbstractC5214Ij5.a("Parameter index is out of range");
        }
        ArrayList arrayList = this.i;
        int iT = AbstractC23036wE6.t(arrayList, i, this.b);
        if (iT >= 0) {
            return (C6669Om) arrayList.get(iT);
        }
        C6669Om c6669Om = new C6669Om(i);
        arrayList.add(-(iT + 1), c6669Om);
        return c6669Om;
    }

    public final int t(C6669Om c6669Om) {
        if (!(!this.g)) {
            AbstractC5138Ib1.s("Use active SlotWriter to determine anchor location instead");
        }
        if (!c6669Om.b()) {
            AbstractC5214Ij5.a("Anchor refers to a group that was removed");
        }
        return c6669Om.a();
    }

    public final void v(C21176tE6 c21176tE6, HashMap map) {
        if (!(c21176tE6.y() == this && this.e > 0)) {
            AbstractC5138Ib1.s("Unexpected reader close()");
        }
        this.e--;
        if (map != null) {
            synchronized (this.f) {
                try {
                    HashMap map2 = this.j;
                    if (map2 != null) {
                        map2.putAll(map);
                    } else {
                        this.j = map;
                    }
                    C19938rB7 c19938rB7 = C19938rB7.a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final void x(C24216yE6 c24216yE6, int[] iArr, int i, Object[] objArr, int i2, ArrayList arrayList, HashMap map, C16734lm4 c16734lm4) {
        if (!(c24216yE6.e0() == this && this.g)) {
            AbstractC5214Ij5.a("Unexpected writer close()");
        }
        this.g = false;
        Z(iArr, i, objArr, i2, arrayList, map, c16734lm4);
    }

    @Override // ir.nasim.InterfaceC7518Sb1
    public Iterable f() {
        return this;
    }
}
