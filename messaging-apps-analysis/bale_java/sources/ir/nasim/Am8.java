package ir.nasim;

/* loaded from: classes3.dex */
final class Am8 extends Cm8 {
    final /* synthetic */ String e;
    final /* synthetic */ String f;
    final /* synthetic */ Object g;
    final /* synthetic */ boolean h;
    final /* synthetic */ C15566jn8 i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Am8(C15566jn8 c15566jn8, String str, String str2, Object obj, boolean z) {
        super(c15566jn8, true);
        this.i = c15566jn8;
        this.e = str;
        this.f = str2;
        this.g = obj;
        this.h = z;
    }

    @Override // ir.nasim.Cm8
    final void a() {
        ((InterfaceC15546jl8) AbstractC3795Cj5.j(this.i.i)).setUserProperty(this.e, this.f, CG4.E2(this.g), this.h, this.a);
    }
}
