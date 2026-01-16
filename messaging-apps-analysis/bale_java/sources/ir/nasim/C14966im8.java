package ir.nasim;

/* renamed from: ir.nasim.im8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C14966im8 extends Cm8 {
    final /* synthetic */ String e;
    final /* synthetic */ Object f;
    final /* synthetic */ C15566jn8 g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C14966im8(C15566jn8 c15566jn8, boolean z, int i, String str, Object obj, Object obj2, Object obj3) {
        super(c15566jn8, false);
        this.g = c15566jn8;
        this.e = str;
        this.f = obj;
    }

    @Override // ir.nasim.Cm8
    final void a() {
        ((InterfaceC15546jl8) AbstractC3795Cj5.j(this.g.i)).logHealthData(5, this.e, CG4.E2(this.f), CG4.E2(null), CG4.E2(null));
    }
}
