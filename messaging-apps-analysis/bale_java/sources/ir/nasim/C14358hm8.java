package ir.nasim;

/* renamed from: ir.nasim.hm8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C14358hm8 extends Cm8 {
    final /* synthetic */ String e;
    final /* synthetic */ String f;
    final /* synthetic */ boolean g;
    final /* synthetic */ Ck8 h;
    final /* synthetic */ C15566jn8 i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C14358hm8(C15566jn8 c15566jn8, String str, String str2, boolean z, Ck8 ck8) {
        super(c15566jn8, true);
        this.i = c15566jn8;
        this.e = str;
        this.f = str2;
        this.g = z;
        this.h = ck8;
    }

    @Override // ir.nasim.Cm8
    final void a() {
        ((InterfaceC15546jl8) AbstractC3795Cj5.j(this.i.i)).getUserProperties(this.e, this.f, this.g, this.h);
    }

    @Override // ir.nasim.Cm8
    protected final void b() {
        this.h.F1(null);
    }
}
