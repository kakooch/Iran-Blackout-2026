package ir.nasim;

import ir.nasim.VZ6;

/* renamed from: ir.nasim.tw3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C21674tw3 implements VZ6 {
    private final C19197pw3 a;
    private final C3348Am4 b = AbstractC21866uG4.b();

    public C21674tw3(C19197pw3 c19197pw3) {
        this.a = c19197pw3;
    }

    @Override // ir.nasim.VZ6
    public boolean a(Object obj, Object obj2) {
        return AbstractC13042fc3.d(this.a.c(obj), this.a.c(obj2));
    }

    @Override // ir.nasim.VZ6
    public void b(VZ6.a aVar) {
        this.b.j();
        for (Object obj : aVar) {
            Object objC = this.a.c(obj);
            int iE = this.b.e(objC, 0);
            if (iE == 7) {
                aVar.remove(obj);
            } else {
                this.b.u(objC, iE + 1);
            }
        }
    }
}
