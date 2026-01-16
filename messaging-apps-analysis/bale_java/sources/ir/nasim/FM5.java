package ir.nasim;

/* loaded from: classes3.dex */
final class FM5 extends AbstractC14535i43 {
    private static final Object[] h;
    static final FM5 i;
    final transient Object[] c;
    private final transient int d;
    final transient Object[] e;
    private final transient int f;
    private final transient int g;

    static {
        Object[] objArr = new Object[0];
        h = objArr;
        i = new FM5(objArr, 0, objArr, 0, 0);
    }

    FM5(Object[] objArr, int i2, Object[] objArr2, int i3, int i4) {
        this.c = objArr;
        this.d = i2;
        this.e = objArr2;
        this.f = i3;
        this.g = i4;
    }

    @Override // ir.nasim.Z33
    int C() {
        return 0;
    }

    @Override // ir.nasim.Z33
    boolean D() {
        return false;
    }

    @Override // ir.nasim.AbstractC14535i43
    AbstractC12710f43 R() {
        return AbstractC12710f43.F(this.c, this.g);
    }

    @Override // ir.nasim.AbstractC14535i43
    boolean S() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public DB7 iterator() {
        return f().iterator();
    }

    @Override // ir.nasim.Z33, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        Object[] objArr = this.e;
        if (obj == null || objArr.length == 0) {
            return false;
        }
        int iC = BU2.c(obj);
        while (true) {
            int i2 = iC & this.f;
            Object obj2 = objArr[i2];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            iC = i2 + 1;
        }
    }

    @Override // ir.nasim.AbstractC14535i43, java.util.Collection, java.util.Set
    public int hashCode() {
        return this.d;
    }

    @Override // ir.nasim.Z33
    int j(Object[] objArr, int i2) {
        System.arraycopy(this.c, 0, objArr, i2, this.g);
        return i2 + this.g;
    }

    @Override // ir.nasim.Z33
    Object[] r() {
        return this.c;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.g;
    }

    @Override // ir.nasim.Z33
    int w() {
        return this.g;
    }
}
