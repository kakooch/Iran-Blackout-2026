package j$.util.stream;

/* loaded from: classes2.dex */
public final /* synthetic */ class F implements j$.util.function.f {
    public final /* synthetic */ int a = 1;
    public final /* synthetic */ Object b;

    @Override // j$.util.function.f
    public final void accept(double d) {
        switch (this.a) {
            case 0:
                ((InterfaceC0192m3) this.b).accept(d);
                break;
            default:
                ((J) this.b).a.accept(d);
                break;
        }
    }

    @Override // j$.util.function.f
    public j$.util.function.f k(j$.util.function.f fVar) {
        switch (this.a) {
            case 0:
                fVar.getClass();
                break;
            default:
                fVar.getClass();
                break;
        }
        return new j$.util.function.e(this, fVar);
    }
}
