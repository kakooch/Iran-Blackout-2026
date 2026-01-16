package ir.nasim;

/* renamed from: ir.nasim.x93, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C23577x93 implements InterfaceC22987w93 {
    private final UA2 a;
    private final InterfaceC9102Ym4 b;

    public /* synthetic */ C23577x93(int i, UA2 ua2, ED1 ed1) {
        this(i, ua2);
    }

    @Override // ir.nasim.InterfaceC22987w93
    public int a() {
        return ((C22391v93) this.b.getValue()).i();
    }

    public void b(int i) {
        this.b.setValue(C22391v93.c(i));
    }

    private C23577x93(int i, UA2 ua2) {
        this.a = ua2;
        this.b = AbstractC13472gH6.d(C22391v93.c(i), null, 2, null);
    }
}
