package ir.nasim;

/* renamed from: ir.nasim.z55, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C24719z55 extends AbstractC12085e1 {
    private final Object[] c;
    private final C11403cw7 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C24719z55(Object[] objArr, Object[] objArr2, int i, int i2, int i3) {
        super(i, i2);
        AbstractC13042fc3.i(objArr, "root");
        AbstractC13042fc3.i(objArr2, "tail");
        this.c = objArr2;
        int iC = AbstractC23708xN7.c(i2);
        this.d = new C11403cw7(objArr, AbstractC23053wG5.i(i, iC), iC, i3);
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
