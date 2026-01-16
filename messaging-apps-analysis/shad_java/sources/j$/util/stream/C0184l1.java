package j$.util.stream;

/* renamed from: j$.util.stream.l1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0184l1 implements O4 {
    private final EnumC0151f4 a;
    final EnumC0178k1 b;
    final j$.util.function.z c;

    C0184l1(EnumC0151f4 enumC0151f4, EnumC0178k1 enumC0178k1, j$.util.function.z zVar) {
        this.a = enumC0151f4;
        this.b = enumC0178k1;
        this.c = zVar;
    }

    @Override // j$.util.stream.O4
    public int a() {
        return EnumC0145e4.u | EnumC0145e4.r;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // j$.util.stream.O4
    public Object c(AbstractC0256y2 abstractC0256y2, j$.util.t tVar) {
        return (Boolean) new C0190m1(this, abstractC0256y2, tVar).invoke();
    }

    @Override // j$.util.stream.O4
    public Object d(AbstractC0256y2 abstractC0256y2, j$.util.t tVar) {
        AbstractC0172j1 abstractC0172j1 = (AbstractC0172j1) this.c.get();
        AbstractC0128c abstractC0128c = (AbstractC0128c) abstractC0256y2;
        abstractC0172j1.getClass();
        abstractC0128c.o0(abstractC0128c.w0(abstractC0172j1), tVar);
        return Boolean.valueOf(abstractC0172j1.b);
    }
}
