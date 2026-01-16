package ir.nasim;

/* renamed from: ir.nasim.mR7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C17127mR7 implements InterfaceC10929cR7 {
    private final int a;
    private final int b;
    private final K22 c;
    private final C12336eR7 d;

    public C17127mR7(int i, int i2, K22 k22) {
        this.a = i;
        this.b = i2;
        this.c = k22;
        this.d = new C12336eR7(new C17954nq2(e(), d(), k22));
    }

    @Override // ir.nasim.ZQ7
    public AbstractC8151Ut c(long j, AbstractC8151Ut abstractC8151Ut, AbstractC8151Ut abstractC8151Ut2, AbstractC8151Ut abstractC8151Ut3) {
        return this.d.c(j, abstractC8151Ut, abstractC8151Ut2, abstractC8151Ut3);
    }

    @Override // ir.nasim.InterfaceC10929cR7
    public int d() {
        return this.b;
    }

    @Override // ir.nasim.InterfaceC10929cR7
    public int e() {
        return this.a;
    }

    @Override // ir.nasim.ZQ7
    public AbstractC8151Ut f(long j, AbstractC8151Ut abstractC8151Ut, AbstractC8151Ut abstractC8151Ut2, AbstractC8151Ut abstractC8151Ut3) {
        return this.d.f(j, abstractC8151Ut, abstractC8151Ut2, abstractC8151Ut3);
    }
}
