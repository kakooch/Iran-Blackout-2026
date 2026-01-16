package j$.util.stream;

/* loaded from: classes2.dex */
public final /* synthetic */ class W0 implements j$.util.function.q {
    public final /* synthetic */ int a = 1;
    public final /* synthetic */ Object b;

    @Override // j$.util.function.q
    public final void accept(long j) {
        switch (this.a) {
            case 0:
                ((InterfaceC0192m3) this.b).accept(j);
                break;
            default:
                ((Z0) this.b).a.accept(j);
                break;
        }
    }

    @Override // j$.util.function.q
    public j$.util.function.q f(j$.util.function.q qVar) {
        switch (this.a) {
            case 0:
                qVar.getClass();
                break;
            default:
                qVar.getClass();
                break;
        }
        return new j$.util.function.p(this, qVar);
    }
}
