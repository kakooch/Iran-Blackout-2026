package ir.nasim;

import android.util.Size;
import androidx.camera.camera2.internal.compat.quirk.ExtraCroppingQuirk;
import ir.nasim.AbstractC19849r27;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.sW5, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C20734sW5 {
    private final ExtraCroppingQuirk a;

    public C20734sW5() {
        this((ExtraCroppingQuirk) androidx.camera.camera2.internal.compat.quirk.b.b(ExtraCroppingQuirk.class));
    }

    public List a(AbstractC19849r27.b bVar, List list) {
        Size sizeC;
        ExtraCroppingQuirk extraCroppingQuirk = this.a;
        if (extraCroppingQuirk == null || (sizeC = extraCroppingQuirk.c(bVar)) == null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(sizeC);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Size size = (Size) it.next();
            if (!size.equals(sizeC)) {
                arrayList.add(size);
            }
        }
        return arrayList;
    }

    C20734sW5(ExtraCroppingQuirk extraCroppingQuirk) {
        this.a = extraCroppingQuirk;
    }
}
