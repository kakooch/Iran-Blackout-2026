package j$.util.stream;

/* loaded from: classes2.dex */
class L2 extends U2 {
    final /* synthetic */ j$.util.function.j b;
    final /* synthetic */ int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    L2(EnumC0151f4 enumC0151f4, j$.util.function.j jVar, int i) {
        super(enumC0151f4);
        this.b = jVar;
        this.c = i;
    }

    @Override // j$.util.stream.U2
    public S2 b() {
        return new M2(this.c, this.b);
    }
}
