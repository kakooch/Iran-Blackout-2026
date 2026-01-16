package ir.nasim;

/* renamed from: ir.nasim.kR7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C15945kR7 implements InterfaceC10929cR7 {
    private final int a;

    public C15945kR7(int i) {
        this.a = i;
    }

    @Override // ir.nasim.ZQ7
    public AbstractC8151Ut c(long j, AbstractC8151Ut abstractC8151Ut, AbstractC8151Ut abstractC8151Ut2, AbstractC8151Ut abstractC8151Ut3) {
        return j < ((long) d()) * 1000000 ? abstractC8151Ut : abstractC8151Ut2;
    }

    @Override // ir.nasim.InterfaceC10929cR7
    public int d() {
        return this.a;
    }

    @Override // ir.nasim.InterfaceC10929cR7
    public int e() {
        return 0;
    }

    @Override // ir.nasim.ZQ7
    public AbstractC8151Ut f(long j, AbstractC8151Ut abstractC8151Ut, AbstractC8151Ut abstractC8151Ut2, AbstractC8151Ut abstractC8151Ut3) {
        return abstractC8151Ut3;
    }
}
