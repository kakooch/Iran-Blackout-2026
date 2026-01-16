package j$.util.stream;

/* loaded from: classes2.dex */
public final /* synthetic */ class B0 implements j$.util.function.l {
    public final /* synthetic */ int a = 1;
    public final /* synthetic */ Object b;

    @Override // j$.util.function.l
    public final void accept(int i) {
        switch (this.a) {
            case 0:
                ((InterfaceC0192m3) this.b).accept(i);
                break;
            default:
                ((F0) this.b).a.accept(i);
                break;
        }
    }

    @Override // j$.util.function.l
    public j$.util.function.l m(j$.util.function.l lVar) {
        switch (this.a) {
            case 0:
                lVar.getClass();
                break;
            default:
                lVar.getClass();
                break;
        }
        return new j$.util.function.k(this, lVar);
    }
}
