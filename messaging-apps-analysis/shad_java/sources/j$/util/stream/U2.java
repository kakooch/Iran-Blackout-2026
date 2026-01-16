package j$.util.stream;

/* loaded from: classes2.dex */
abstract class U2 implements O4 {
    private final EnumC0151f4 a;

    U2(EnumC0151f4 enumC0151f4) {
        this.a = enumC0151f4;
    }

    @Override // j$.util.stream.O4
    public /* synthetic */ int a() {
        return 0;
    }

    public abstract S2 b();

    @Override // j$.util.stream.O4
    public Object c(AbstractC0256y2 abstractC0256y2, j$.util.t tVar) {
        return ((S2) new V2(this, abstractC0256y2, tVar).invoke()).get();
    }

    @Override // j$.util.stream.O4
    public Object d(AbstractC0256y2 abstractC0256y2, j$.util.t tVar) {
        S2 s2B = b();
        AbstractC0128c abstractC0128c = (AbstractC0128c) abstractC0256y2;
        s2B.getClass();
        abstractC0128c.o0(abstractC0128c.w0(s2B), tVar);
        return s2B.get();
    }
}
