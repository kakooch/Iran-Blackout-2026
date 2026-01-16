package ir.nasim;

/* renamed from: ir.nasim.bF2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C10200bF2 extends AbstractC8114Uo7 {
    private final ThreadLocal a = new ThreadLocal();

    @Override // ir.nasim.AbstractC8114Uo7
    public Object a() {
        return this.a.get();
    }

    @Override // ir.nasim.AbstractC8114Uo7
    public void b(Object obj) {
        this.a.set(obj);
    }
}
