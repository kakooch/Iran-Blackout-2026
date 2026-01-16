package ir.nasim;

import android.app.Activity;
import android.os.Bundle;

/* loaded from: classes3.dex */
final class Hm8 extends Cm8 {
    final /* synthetic */ Bundle e;
    final /* synthetic */ Activity f;
    final /* synthetic */ C14976in8 g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Hm8(C14976in8 c14976in8, Bundle bundle, Activity activity) {
        super(c14976in8.a, true);
        this.g = c14976in8;
        this.e = bundle;
        this.f = activity;
    }

    @Override // ir.nasim.Cm8
    final void a() {
        Bundle bundle;
        if (this.e != null) {
            bundle = new Bundle();
            if (this.e.containsKey("com.google.app_measurement.screen_service")) {
                Object obj = this.e.get("com.google.app_measurement.screen_service");
                if (obj instanceof Bundle) {
                    bundle.putBundle("com.google.app_measurement.screen_service", (Bundle) obj);
                }
            }
        } else {
            bundle = null;
        }
        ((InterfaceC15546jl8) AbstractC3795Cj5.j(this.g.a.i)).onActivityCreated(CG4.E2(this.f), bundle, this.b);
    }
}
