package ir.nasim;

import android.graphics.ImageDecoder;
import java.io.InputStream;

/* loaded from: classes2.dex */
public final class A93 implements HW5 {
    private final C11063cg0 a = new C11063cg0();

    @Override // ir.nasim.HW5
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public DW5 a(InputStream inputStream, int i, int i2, HL4 hl4) {
        return this.a.c(ImageDecoder.createSource(AbstractC5254Io0.b(inputStream)), i, i2, hl4);
    }

    @Override // ir.nasim.HW5
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(InputStream inputStream, HL4 hl4) {
        return true;
    }
}
