package ir.nasim;

import android.gov.nist.core.Separators;
import android.os.Build;

/* renamed from: ir.nasim.xI3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C23659xI3 implements InterfaceC23069wI3 {
    @Override // ir.nasim.InterfaceC23069wI3
    public boolean a() {
        if (AbstractC21784u76.c()) {
            return true;
        }
        return !C8386Vt0.fa() && C7183Qq.p().h("ENABLED_SEND_LOG", true);
    }

    @Override // ir.nasim.InterfaceC23069wI3
    public String b() {
        String strA0 = AbstractC15401jX0.A0(C8386Vt0.L3(), ",", null, null, 0, null, null, 62, null);
        String strA02 = AbstractC15401jX0.A0(C8386Vt0.K3(), ",", null, null, 0, null, null, 62, null);
        C5721Ko c5721Ko = C5721Ko.a;
        return AbstractC16016kZ6.i("<-----  Start logging  ----->\n                |    App and Device Detail:\n                |    App Version Name: " + c5721Ko.i() + "\n                |    App Version Code: " + c5721Ko.h() + "\n                |    Android Version: " + Build.VERSION.RELEASE + "\n                |    Android API Level: " + Build.VERSION.SDK_INT + "\n                |    Device Brand: " + Build.BRAND + "\n                |    Device Model: " + Build.MODEL + "\n                |    \n                |    ------------------- AvailableFeaturesOnCurrentVersion --------------------\n                |    [" + strA0 + "]\n                |            \n                |    ------------------- AvailableConfigOnCurrentVersion --------------------\n                |    [" + strA02 + "]\n                |    \n                |___________________________________________________ \n        ", null, 1, null) + Separators.RETURN;
    }
}
