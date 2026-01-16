package ir.nasim;

import java.util.ListIterator;

/* renamed from: ir.nasim.v55, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C22353v55 extends AbstractC23493x1 implements InterfaceC19877r55 {
    private final Object[] a;
    private final Object[] b;
    private final int c;
    private final int d;

    public C22353v55(Object[] objArr, Object[] objArr2, int i, int i2) {
        AbstractC13042fc3.i(objArr, "root");
        AbstractC13042fc3.i(objArr2, "tail");
        this.a = objArr;
        this.b = objArr2;
        this.c = i;
        this.d = i2;
        if (size() > 32) {
            WZ0.a(size() - AbstractC23708xN7.c(size()) <= AbstractC23053wG5.i(objArr2.length, 32));
            return;
        }
        throw new IllegalArgumentException(("Trie-based persistent vector should have at least 33 elements, got " + size()).toString());
    }

    private final int E() {
        return AbstractC23708xN7.c(size());
    }

    private final Object[] j(int i) {
        if (E() <= i) {
            return this.b;
        }
        Object[] objArr = this.a;
        for (int i2 = this.d; i2 > 0; i2 -= 5) {
            Object[] objArr2 = objArr[AbstractC23708xN7.a(i, i2)];
            AbstractC13042fc3.g(objArr2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArr = objArr2;
        }
        return objArr;
    }

    @Override // ir.nasim.InterfaceC19877r55
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public C23539x55 m() {
        return new C23539x55(this, this.a, this.b, this.d);
    }

    @Override // ir.nasim.AbstractC11442d1, java.util.List
    public Object get(int i) {
        LB3.a(i, size());
        return j(i)[i & 31];
    }

    @Override // ir.nasim.G0
    public int getSize() {
        return this.c;
    }

    @Override // ir.nasim.AbstractC11442d1, java.util.List
    public ListIterator listIterator(int i) {
        LB3.b(i, size());
        return new C24719z55(this.a, this.b, i, size(), (this.d / 5) + 1);
    }
}
