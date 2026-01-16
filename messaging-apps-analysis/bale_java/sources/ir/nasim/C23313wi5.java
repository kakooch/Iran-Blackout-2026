package ir.nasim;

/* renamed from: ir.nasim.wi5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C23313wi5 extends C22127ui5 {
    private final Object c;

    public C23313wi5(int i) {
        super(i);
        this.c = new Object();
    }

    @Override // ir.nasim.C22127ui5, ir.nasim.InterfaceC20850si5
    public boolean a(Object obj) {
        boolean zA;
        AbstractC13042fc3.i(obj, "instance");
        synchronized (this.c) {
            zA = super.a(obj);
        }
        return zA;
    }

    @Override // ir.nasim.C22127ui5, ir.nasim.InterfaceC20850si5
    public Object b() {
        Object objB;
        synchronized (this.c) {
            objB = super.b();
        }
        return objB;
    }
}
