package ir.nasim;

import android.graphics.Bitmap;
import java.io.ByteArrayOutputStream;

/* renamed from: ir.nasim.Pf0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C6841Pf0 implements RW5 {
    private final Bitmap.CompressFormat a;
    private final int b;

    public C6841Pf0() {
        this(Bitmap.CompressFormat.JPEG, 100);
    }

    @Override // ir.nasim.RW5
    public DW5 a(DW5 dw5, HL4 hl4) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ((Bitmap) dw5.get()).compress(this.a, this.b, byteArrayOutputStream);
        dw5.a();
        return new C9116Yo0(byteArrayOutputStream.toByteArray());
    }

    public C6841Pf0(Bitmap.CompressFormat compressFormat, int i) {
        this.a = compressFormat;
        this.b = i;
    }
}
