package j$.util.stream;

/* renamed from: j$.util.stream.d0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0135d0 implements O4 {
    private final EnumC0151f4 a;
    final boolean b;
    final Object c;
    final j$.util.function.y d;
    final j$.util.function.z e;

    C0135d0(boolean z, EnumC0151f4 enumC0151f4, Object obj, j$.util.function.y yVar, j$.util.function.z zVar) {
        this.b = z;
        this.a = enumC0151f4;
        this.c = obj;
        this.d = yVar;
        this.e = zVar;
    }

    @Override // j$.util.stream.O4
    public int a() {
        return EnumC0145e4.u | (this.b ? 0 : EnumC0145e4.r);
    }

    @Override // j$.util.stream.O4
    public Object c(AbstractC0256y2 abstractC0256y2, j$.util.t tVar) {
        return new C0171j0(this, abstractC0256y2, tVar).invoke();
    }

    @Override // j$.util.stream.O4
    public Object d(AbstractC0256y2 abstractC0256y2, j$.util.t tVar) {
        P4 p4 = (P4) this.e.get();
        AbstractC0128c abstractC0128c = (AbstractC0128c) abstractC0256y2;
        p4.getClass();
        abstractC0128c.o0(abstractC0128c.w0(p4), tVar);
        Object obj = p4.get();
        return obj != null ? obj : this.c;
    }
}
