package ir.nasim;

/* loaded from: classes.dex */
public final class A55 extends AbstractC12676f1 {
    private final Object[] c;
    private final C12046dw7 d;

    public A55(Object[] objArr, Object[] objArr2, int i, int i2, int i3) {
        super(i, i2);
        this.c = objArr2;
        int iD = AbstractC24298yN7.d(i2);
        this.d = new C12046dw7(objArr, AbstractC23053wG5.i(i, iD), iD, i3);
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public Object next() {
        b();
        if (this.d.hasNext()) {
            f(d() + 1);
            return this.d.next();
        }
        Object[] objArr = this.c;
        int iD = d();
        f(iD + 1);
        return objArr[iD - this.d.e()];
    }

    @Override // java.util.ListIterator
    public Object previous() {
        c();
        if (d() <= this.d.e()) {
            f(d() - 1);
            return this.d.previous();
        }
        Object[] objArr = this.c;
        f(d() - 1);
        return objArr[d() - this.d.e()];
    }
}
