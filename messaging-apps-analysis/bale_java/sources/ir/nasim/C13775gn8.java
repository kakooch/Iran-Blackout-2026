package ir.nasim;

import android.app.Activity;

/* renamed from: ir.nasim.gn8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C13775gn8 extends Cm8 {
    final /* synthetic */ Activity e;
    final /* synthetic */ Ck8 f;
    final /* synthetic */ C14976in8 g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C13775gn8(C14976in8 c14976in8, Activity activity, Ck8 ck8) {
        super(c14976in8.a, true);
        this.g = c14976in8;
        this.e = activity;
        this.f = ck8;
    }

    @Override // ir.nasim.Cm8
    final void a() {
        ((InterfaceC15546jl8) AbstractC3795Cj5.j(this.g.a.i)).onActivitySaveInstanceState(CG4.E2(this.e), this.f, this.b);
    }
}
