package ir.nasim;

import java.io.Serializable;

/* loaded from: classes8.dex */
final class H92 extends AbstractC11442d1 implements F92, Serializable {
    private final Enum[] a;

    public H92(Enum[] enumArr) {
        AbstractC13042fc3.i(enumArr, "entries");
        this.a = enumArr;
    }

    public int C(Enum r3) {
        AbstractC13042fc3.i(r3, "element");
        int iOrdinal = r3.ordinal();
        if (((Enum) AbstractC10242bK.n0(this.a, iOrdinal)) == r3) {
            return iOrdinal;
        }
        return -1;
    }

    public int E(Enum r2) {
        AbstractC13042fc3.i(r2, "element");
        return indexOf(r2);
    }

    @Override // ir.nasim.G0, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Enum) {
            return f((Enum) obj);
        }
        return false;
    }

    public boolean f(Enum r3) {
        AbstractC13042fc3.i(r3, "element");
        return ((Enum) AbstractC10242bK.n0(this.a, r3.ordinal())) == r3;
    }

    @Override // ir.nasim.G0
    public int getSize() {
        return this.a.length;
    }

    @Override // ir.nasim.AbstractC11442d1, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Enum) {
            return C((Enum) obj);
        }
        return -1;
    }

    @Override // ir.nasim.AbstractC11442d1, java.util.List
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Enum get(int i) {
        AbstractC11442d1.Companion.b(i, this.a.length);
        return this.a[i];
    }

    @Override // ir.nasim.AbstractC11442d1, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Enum) {
            return E((Enum) obj);
        }
        return -1;
    }
}
