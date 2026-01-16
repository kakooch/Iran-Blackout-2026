package ir.nasim;

import android.util.Size;
import androidx.camera.camera2.internal.compat.quirk.ExtraSupportedOutputSizeQuirk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class GN4 {
    private final String a;
    private final ExtraSupportedOutputSizeQuirk b = (ExtraSupportedOutputSizeQuirk) androidx.camera.camera2.internal.compat.quirk.b.b(ExtraSupportedOutputSizeQuirk.class);
    private final C8001Uc2 c;

    public GN4(String str) {
        this.a = str;
        this.c = new C8001Uc2(str);
    }

    private void a(List list, int i) {
        ExtraSupportedOutputSizeQuirk extraSupportedOutputSizeQuirk = this.b;
        if (extraSupportedOutputSizeQuirk == null) {
            return;
        }
        Size[] sizeArrC = extraSupportedOutputSizeQuirk.c(i);
        if (sizeArrC.length > 0) {
            list.addAll(Arrays.asList(sizeArrC));
        }
    }

    private void c(List list, int i) {
        List listA = this.c.a(i);
        if (listA.isEmpty()) {
            return;
        }
        list.removeAll(listA);
    }

    public Size[] b(Size[] sizeArr, int i) {
        ArrayList arrayList = new ArrayList(Arrays.asList(sizeArr));
        a(arrayList, i);
        c(arrayList, i);
        if (arrayList.isEmpty()) {
            PI3.l("OutputSizesCorrector", "Sizes array becomes empty after excluding problematic output sizes.");
        }
        return (Size[]) arrayList.toArray(new Size[0]);
    }
}
