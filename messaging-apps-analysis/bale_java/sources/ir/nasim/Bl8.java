package ir.nasim;

/* loaded from: classes3.dex */
final class Bl8 extends Cm8 {
    final /* synthetic */ String e;
    final /* synthetic */ String f;
    final /* synthetic */ Ck8 g;
    final /* synthetic */ C15566jn8 h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Bl8(C15566jn8 c15566jn8, String str, String str2, Ck8 ck8) {
        super(c15566jn8, true);
        this.h = c15566jn8;
        this.e = str;
        this.f = str2;
        this.g = ck8;
    }

    @Override // ir.nasim.Cm8
    final void a() {
        ((InterfaceC15546jl8) AbstractC3795Cj5.j(this.h.i)).getConditionalUserProperties(this.e, this.f, this.g);
    }

    @Override // ir.nasim.Cm8
    protected final void b() {
        this.g.F1(null);
    }
}
