package ir.nasim;

import androidx.camera.camera2.internal.compat.quirk.ExcludedSupportedSizesQuirk;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.Uc2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C8001Uc2 {
    private final String a;

    public C8001Uc2(String str) {
        this.a = str;
    }

    public List a(int i) {
        ExcludedSupportedSizesQuirk excludedSupportedSizesQuirk = (ExcludedSupportedSizesQuirk) androidx.camera.camera2.internal.compat.quirk.b.b(ExcludedSupportedSizesQuirk.class);
        return excludedSupportedSizesQuirk == null ? new ArrayList() : excludedSupportedSizesQuirk.c(this.a, i);
    }
}
