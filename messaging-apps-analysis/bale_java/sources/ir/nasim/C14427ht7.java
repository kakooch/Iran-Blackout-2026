package ir.nasim;

import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.internal.compat.quirk.TorchIsClosedAfterImageCapturingQuirk;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.i;
import ir.nasim.BB0;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.ht7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C14427ht7 {
    private final boolean a;

    public C14427ht7() {
        this.a = androidx.camera.camera2.internal.compat.quirk.b.b(TorchIsClosedAfterImageCapturingQuirk.class) != null;
    }

    public androidx.camera.core.impl.i a(androidx.camera.core.impl.i iVar) {
        i.a aVar = new i.a();
        aVar.r(iVar.k());
        Iterator it = iVar.i().iterator();
        while (it.hasNext()) {
            aVar.f((DeferrableSurface) it.next());
        }
        aVar.e(iVar.g());
        BB0.a aVar2 = new BB0.a();
        aVar2.f(CaptureRequest.FLASH_MODE, 0);
        aVar.e(aVar2.c());
        return aVar.h();
    }

    public boolean b(List list, boolean z) {
        if (!this.a || !z) {
            return false;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) ((CaptureRequest) it.next()).get(CaptureRequest.FLASH_MODE);
            if (num != null && num.intValue() == 2) {
                return true;
            }
        }
        return false;
    }
}
