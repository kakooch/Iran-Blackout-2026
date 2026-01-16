package ir.nasim;

import android.app.Activity;

/* renamed from: ir.nasim.hn8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C14368hn8 extends Cm8 {
    final /* synthetic */ Activity e;
    final /* synthetic */ C14976in8 f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C14368hn8(C14976in8 c14976in8, Activity activity) {
        super(c14976in8.a, true);
        this.f = c14976in8;
        this.e = activity;
    }

    @Override // ir.nasim.Cm8
    final void a() {
        ((InterfaceC15546jl8) AbstractC3795Cj5.j(this.f.a.i)).onActivityDestroyed(CG4.E2(this.e), this.b);
    }
}
