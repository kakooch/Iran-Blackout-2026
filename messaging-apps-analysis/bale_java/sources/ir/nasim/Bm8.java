package ir.nasim;

/* loaded from: classes3.dex */
final class Bm8 extends AbstractC25130zm8 {
    static final AbstractC25130zm8 e = new Bm8(new Object[0], 0);
    final transient Object[] c;
    private final transient int d;

    Bm8(Object[] objArr, int i) {
        this.c = objArr;
        this.d = i;
    }

    @Override // ir.nasim.AbstractC20893sm8
    final boolean C() {
        return false;
    }

    @Override // ir.nasim.AbstractC20893sm8
    final Object[] D() {
        return this.c;
    }

    @Override // ir.nasim.AbstractC25130zm8, ir.nasim.AbstractC20893sm8
    final int f(Object[] objArr, int i) {
        System.arraycopy(this.c, 0, objArr, 0, this.d);
        return this.d;
    }

    @Override // java.util.List
    public final Object get(int i) {
        AbstractC18511om8.a(i, this.d, "index");
        Object obj = this.c[i];
        obj.getClass();
        return obj;
    }

    @Override // ir.nasim.AbstractC20893sm8
    final int j() {
        return this.d;
    }

    @Override // ir.nasim.AbstractC20893sm8
    final int r() {
        return 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.d;
    }
}
