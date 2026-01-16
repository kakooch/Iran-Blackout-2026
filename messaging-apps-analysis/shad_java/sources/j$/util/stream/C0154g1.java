package j$.util.stream;

/* renamed from: j$.util.stream.g1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C0154g1 extends AbstractC0172j1 implements InterfaceC0180k3 {
    final /* synthetic */ EnumC0178k1 c;
    final /* synthetic */ j$.wrappers.U d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0154g1(EnumC0178k1 enumC0178k1, j$.wrappers.U u) {
        super(enumC0178k1);
        this.c = enumC0178k1;
        this.d = u;
    }

    @Override // j$.util.function.Consumer
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void accept(Integer num) {
        AbstractC0202o1.b(this, num);
    }

    @Override // j$.util.stream.AbstractC0172j1, j$.util.stream.InterfaceC0192m3
    public void accept(int i) {
        if (this.a || this.d.b(i) != this.c.a) {
            return;
        }
        this.a = true;
        this.b = this.c.b;
    }

    @Override // j$.util.function.l
    public j$.util.function.l m(j$.util.function.l lVar) {
        lVar.getClass();
        return new j$.util.function.k(this, lVar);
    }
}
