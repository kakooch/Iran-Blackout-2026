package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.cg3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C11066cg3 extends AbstractC11442d1 {
    private final int a;
    private final int b;
    private final List c;

    public C11066cg3(int i, int i2, List list) {
        AbstractC13042fc3.i(list, "items");
        this.a = i;
        this.b = i2;
        this.c = list;
    }

    public final List f() {
        return this.c;
    }

    @Override // ir.nasim.AbstractC11442d1, java.util.List
    public Object get(int i) {
        if (i >= 0 && i < this.a) {
            return null;
        }
        int i2 = this.a;
        if (i < this.c.size() + i2 && i2 <= i) {
            return this.c.get(i - this.a);
        }
        int size = this.a + this.c.size();
        if (i < size() && size <= i) {
            return null;
        }
        throw new IndexOutOfBoundsException("Illegal attempt to access index " + i + " in ItemSnapshotList of size " + size());
    }

    @Override // ir.nasim.G0
    public int getSize() {
        return this.a + this.c.size() + this.b;
    }
}
