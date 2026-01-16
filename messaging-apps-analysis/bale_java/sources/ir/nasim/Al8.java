package ir.nasim;

import android.os.Bundle;

/* loaded from: classes3.dex */
final class Al8 extends Cm8 {
    final /* synthetic */ String e;
    final /* synthetic */ String f;
    final /* synthetic */ Bundle g;
    final /* synthetic */ C15566jn8 h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Al8(C15566jn8 c15566jn8, String str, String str2, Bundle bundle) {
        super(c15566jn8, true);
        this.h = c15566jn8;
        this.e = str;
        this.f = str2;
        this.g = bundle;
    }

    @Override // ir.nasim.Cm8
    final void a() {
        ((InterfaceC15546jl8) AbstractC3795Cj5.j(this.h.i)).clearConditionalUserProperty(this.e, this.f, this.g);
    }
}
