package j$.util.function;

/* renamed from: j$.util.function.i, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0098i implements y {
    public final /* synthetic */ y a;
    public final /* synthetic */ y b;

    public /* synthetic */ C0098i(y yVar, y yVar2) {
        this.a = yVar;
        this.b = yVar2;
    }

    @Override // j$.util.function.y
    public final void accept(int i) {
        y yVar = this.a;
        y yVar2 = this.b;
        yVar.accept(i);
        yVar2.accept(i);
    }

    @Override // j$.util.function.y
    public y k(y yVar) {
        yVar.getClass();
        return new C0098i(this, yVar);
    }
}
