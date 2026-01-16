package ir.nasim;

import android.graphics.ImageDecoder;
import java.nio.ByteBuffer;

/* renamed from: ir.nasim.Bo0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C3601Bo0 implements HW5 {
    private final C11063cg0 a = new C11063cg0();

    @Override // ir.nasim.HW5
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public DW5 a(ByteBuffer byteBuffer, int i, int i2, HL4 hl4) {
        return this.a.c(ImageDecoder.createSource(byteBuffer), i, i2, hl4);
    }

    @Override // ir.nasim.HW5
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(ByteBuffer byteBuffer, HL4 hl4) {
        return true;
    }
}
