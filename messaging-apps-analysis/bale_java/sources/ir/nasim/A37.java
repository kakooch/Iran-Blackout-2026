package ir.nasim;

import android.graphics.drawable.PictureDrawable;

/* loaded from: classes5.dex */
public final class A37 implements RW5 {
    @Override // ir.nasim.RW5
    public DW5 a(DW5 dw5, HL4 hl4) {
        AbstractC13042fc3.i(dw5, "toTranscode");
        AbstractC13042fc3.i(hl4, "options");
        Object obj = dw5.get();
        AbstractC13042fc3.h(obj, "get(...)");
        return new SC6(new PictureDrawable(((com.caverock.androidsvg.g) obj).t()));
    }
}
