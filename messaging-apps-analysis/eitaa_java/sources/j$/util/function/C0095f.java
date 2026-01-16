package j$.util.function;

/* renamed from: j$.util.function.f, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0095f implements s {
    public final /* synthetic */ s a;
    public final /* synthetic */ s b;

    public /* synthetic */ C0095f(s sVar, s sVar2) {
        this.a = sVar;
        this.b = sVar2;
    }

    @Override // j$.util.function.s
    public final void accept(double d) {
        s sVar = this.a;
        s sVar2 = this.b;
        sVar.accept(d);
        sVar2.accept(d);
    }

    @Override // j$.util.function.s
    public s j(s sVar) {
        sVar.getClass();
        return new C0095f(this, sVar);
    }
}
