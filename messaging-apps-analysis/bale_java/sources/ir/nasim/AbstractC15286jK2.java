package ir.nasim;

/* renamed from: ir.nasim.jK2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC15286jK2 implements InterfaceC24524yl6 {
    @Override // ir.nasim.InterfaceC24524yl6
    public int a(int i) {
        int iE = e(i);
        if (iE == -1 || e(iE) == -1) {
            return -1;
        }
        return iE;
    }

    @Override // ir.nasim.InterfaceC24524yl6
    public int b(int i) {
        return f(i);
    }

    @Override // ir.nasim.InterfaceC24524yl6
    public int c(int i) {
        return e(i);
    }

    @Override // ir.nasim.InterfaceC24524yl6
    public int d(int i) {
        int iF = f(i);
        if (iF == -1 || f(iF) == -1) {
            return -1;
        }
        return iF;
    }

    public abstract int e(int i);

    public abstract int f(int i);
}
