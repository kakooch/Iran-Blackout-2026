package ir.nasim;

/* loaded from: classes8.dex */
public final class JL5 extends AbstractC23098wL5 implements InterfaceC14311hi3 {
    private final Enum c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JL5(C6432No4 c6432No4, Enum r3) {
        super(c6432No4);
        AbstractC13042fc3.i(r3, "value");
        this.c = r3;
    }

    @Override // ir.nasim.InterfaceC14311hi3
    public C24948zU0 d() {
        Class<?> enclosingClass = this.c.getClass();
        if (!enclosingClass.isEnum()) {
            enclosingClass = enclosingClass.getEnclosingClass();
        }
        AbstractC13042fc3.h(enclosingClass, "enumClass");
        return AbstractC21912uL5.b(enclosingClass);
    }

    @Override // ir.nasim.InterfaceC14311hi3
    public C6432No4 e() {
        return C6432No4.p(this.c.name());
    }
}
