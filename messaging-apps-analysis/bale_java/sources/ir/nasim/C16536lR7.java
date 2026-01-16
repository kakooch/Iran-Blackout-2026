package ir.nasim;

/* renamed from: ir.nasim.lR7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C16536lR7 implements InterfaceC11693dR7 {
    private final float a;
    private final float b;
    private final /* synthetic */ C12336eR7 c;

    private C16536lR7(float f, float f2, InterfaceC8619Wt interfaceC8619Wt) {
        this.a = f;
        this.b = f2;
        this.c = new C12336eR7(interfaceC8619Wt);
    }

    @Override // ir.nasim.InterfaceC11693dR7, ir.nasim.ZQ7
    public boolean a() {
        return this.c.a();
    }

    @Override // ir.nasim.ZQ7
    public long b(AbstractC8151Ut abstractC8151Ut, AbstractC8151Ut abstractC8151Ut2, AbstractC8151Ut abstractC8151Ut3) {
        return this.c.b(abstractC8151Ut, abstractC8151Ut2, abstractC8151Ut3);
    }

    @Override // ir.nasim.ZQ7
    public AbstractC8151Ut c(long j, AbstractC8151Ut abstractC8151Ut, AbstractC8151Ut abstractC8151Ut2, AbstractC8151Ut abstractC8151Ut3) {
        return this.c.c(j, abstractC8151Ut, abstractC8151Ut2, abstractC8151Ut3);
    }

    @Override // ir.nasim.ZQ7
    public AbstractC8151Ut f(long j, AbstractC8151Ut abstractC8151Ut, AbstractC8151Ut abstractC8151Ut2, AbstractC8151Ut abstractC8151Ut3) {
        return this.c.f(j, abstractC8151Ut, abstractC8151Ut2, abstractC8151Ut3);
    }

    @Override // ir.nasim.ZQ7
    public AbstractC8151Ut g(AbstractC8151Ut abstractC8151Ut, AbstractC8151Ut abstractC8151Ut2, AbstractC8151Ut abstractC8151Ut3) {
        return this.c.g(abstractC8151Ut, abstractC8151Ut2, abstractC8151Ut3);
    }

    public C16536lR7(float f, float f2, AbstractC8151Ut abstractC8151Ut) {
        this(f, f2, AbstractC9719aR7.f(abstractC8151Ut, f, f2));
    }
}
