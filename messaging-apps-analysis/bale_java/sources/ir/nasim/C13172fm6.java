package ir.nasim;

/* renamed from: ir.nasim.fm6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C13172fm6 implements InterfaceC12536em6 {
    private final Object a;
    private final InterfaceC15796kB2 b;
    private final InterfaceC15796kB2 c;
    private final InterfaceC15796kB2 d;

    public C13172fm6(Object obj, InterfaceC15796kB2 interfaceC15796kB2, InterfaceC15796kB2 interfaceC15796kB22) {
        this.a = obj;
        this.b = interfaceC15796kB2;
        this.c = interfaceC15796kB22;
        this.d = AbstractC16736lm6.a;
    }

    @Override // ir.nasim.InterfaceC14964im6
    public InterfaceC15796kB2 a() {
        return this.b;
    }

    @Override // ir.nasim.InterfaceC14964im6
    public InterfaceC15796kB2 b() {
        return this.c;
    }

    @Override // ir.nasim.InterfaceC14964im6
    public InterfaceC15796kB2 c() {
        return this.d;
    }

    @Override // ir.nasim.InterfaceC14964im6
    public Object d() {
        return this.a;
    }

    public /* synthetic */ C13172fm6(Object obj, InterfaceC15796kB2 interfaceC15796kB2, InterfaceC15796kB2 interfaceC15796kB22, int i, ED1 ed1) {
        this(obj, interfaceC15796kB2, (i & 4) != 0 ? null : interfaceC15796kB22);
    }
}
