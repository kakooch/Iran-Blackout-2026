package ir.nasim;

import android.app.Activity;

/* loaded from: classes3.dex */
final class El8 extends Cm8 {
    final /* synthetic */ Activity e;
    final /* synthetic */ String f;
    final /* synthetic */ String g;
    final /* synthetic */ C15566jn8 h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    El8(C15566jn8 c15566jn8, Activity activity, String str, String str2) {
        super(c15566jn8, true);
        this.h = c15566jn8;
        this.e = activity;
        this.f = str;
        this.g = str2;
    }

    @Override // ir.nasim.Cm8
    final void a() {
        ((InterfaceC15546jl8) AbstractC3795Cj5.j(this.h.i)).setCurrentScreen(CG4.E2(this.e), this.f, this.g, this.a);
    }
}
