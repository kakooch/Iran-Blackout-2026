package j$.util.stream;

/* renamed from: j$.util.stream.i1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C0166i1 extends AbstractC0172j1 implements InterfaceC0174j3 {
    final /* synthetic */ EnumC0178k1 c;
    final /* synthetic */ j$.wrappers.D d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0166i1(EnumC0178k1 enumC0178k1, j$.wrappers.D d) {
        super(enumC0178k1);
        this.c = enumC0178k1;
        this.d = d;
    }

    @Override // j$.util.function.Consumer
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void accept(Double d) {
        AbstractC0202o1.a(this, d);
    }

    @Override // j$.util.stream.AbstractC0172j1, j$.util.stream.InterfaceC0192m3
    public void accept(double d) {
        if (this.a || this.d.b(d) != this.c.a) {
            return;
        }
        this.a = true;
        this.b = this.c.b;
    }

    @Override // j$.util.function.f
    public j$.util.function.f k(j$.util.function.f fVar) {
        fVar.getClass();
        return new j$.util.function.e(this, fVar);
    }
}
