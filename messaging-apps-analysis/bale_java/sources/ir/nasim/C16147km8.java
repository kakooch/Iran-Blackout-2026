package ir.nasim;

/* renamed from: ir.nasim.km8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C16147km8 extends Cm8 {
    final /* synthetic */ String e;
    final /* synthetic */ Ck8 f;
    final /* synthetic */ C15566jn8 g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C16147km8(C15566jn8 c15566jn8, String str, Ck8 ck8) {
        super(c15566jn8, true);
        this.g = c15566jn8;
        this.e = str;
        this.f = ck8;
    }

    @Override // ir.nasim.Cm8
    final void a() {
        ((InterfaceC15546jl8) AbstractC3795Cj5.j(this.g.i)).getMaxUserProperties(this.e, this.f);
    }

    @Override // ir.nasim.Cm8
    protected final void b() {
        this.f.F1(null);
    }
}
