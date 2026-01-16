package ir.nasim;

/* renamed from: ir.nasim.gm8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C13765gm8 extends Cm8 {
    final /* synthetic */ Ck8 e;
    final /* synthetic */ C15566jn8 f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C13765gm8(C15566jn8 c15566jn8, Ck8 ck8) {
        super(c15566jn8, true);
        this.f = c15566jn8;
        this.e = ck8;
    }

    @Override // ir.nasim.Cm8
    final void a() {
        ((InterfaceC15546jl8) AbstractC3795Cj5.j(this.f.i)).getCurrentScreenClass(this.e);
    }

    @Override // ir.nasim.Cm8
    protected final void b() {
        this.e.F1(null);
    }
}
