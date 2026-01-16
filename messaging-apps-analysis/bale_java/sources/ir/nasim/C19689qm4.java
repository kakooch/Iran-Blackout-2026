package ir.nasim;

import ir.nasim.InterfaceC8727Xb3;

/* renamed from: ir.nasim.qm4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C19689qm4 implements InterfaceC8727Xb3 {
    private final C12544en4 a = new C12544en4(new InterfaceC8727Xb3.a[16], 0);
    private int b;
    private InterfaceC8727Xb3.a c;

    private final boolean c(InterfaceC8727Xb3.a aVar, int i) {
        return i < aVar.b() + aVar.a() && aVar.b() <= i;
    }

    private final InterfaceC8727Xb3.a d(int i) {
        InterfaceC8727Xb3.a aVar = this.c;
        if (aVar != null && c(aVar, i)) {
            return aVar;
        }
        C12544en4 c12544en4 = this.a;
        InterfaceC8727Xb3.a aVar2 = (InterfaceC8727Xb3.a) c12544en4.a[AbstractC8981Yb3.b(c12544en4, i)];
        this.c = aVar2;
        return aVar2;
    }

    @Override // ir.nasim.InterfaceC8727Xb3
    public void a(int i, int i2, UA2 ua2) {
        if (i < 0 || i >= f()) {
            P73.d("Index " + i + ", size " + f());
        }
        if (i2 < 0 || i2 >= f()) {
            P73.d("Index " + i2 + ", size " + f());
        }
        if (!(i2 >= i)) {
            P73.a("toIndex (" + i2 + ") should be not smaller than fromIndex (" + i + ')');
        }
        int iB = AbstractC8981Yb3.b(this.a, i);
        int iB2 = ((InterfaceC8727Xb3.a) this.a.a[iB]).b();
        while (iB2 <= i2) {
            InterfaceC8727Xb3.a aVar = (InterfaceC8727Xb3.a) this.a.a[iB];
            ua2.invoke(aVar);
            iB2 += aVar.a();
            iB++;
        }
    }

    public final void b(int i, Object obj) {
        if (!(i >= 0)) {
            P73.a("size should be >=0");
        }
        if (i == 0) {
            return;
        }
        InterfaceC8727Xb3.a aVar = new InterfaceC8727Xb3.a(f(), i, obj);
        this.b = f() + i;
        this.a.d(aVar);
    }

    @Override // ir.nasim.InterfaceC8727Xb3
    public int f() {
        return this.b;
    }

    @Override // ir.nasim.InterfaceC8727Xb3
    public InterfaceC8727Xb3.a get(int i) {
        if (i < 0 || i >= f()) {
            P73.d("Index " + i + ", size " + f());
        }
        return d(i);
    }
}
