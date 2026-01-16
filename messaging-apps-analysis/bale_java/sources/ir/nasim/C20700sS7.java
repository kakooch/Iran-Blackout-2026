package ir.nasim;

import android.graphics.drawable.Drawable;
import ir.nasim.designsystem.ImageViewCrossFade;

/* renamed from: ir.nasim.sS7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C20700sS7 extends AbstractC17168mW3 {
    private final ImageViewCrossFade d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C20700sS7(byte[] bArr, ImageViewCrossFade imageViewCrossFade, XV4 xv4, Drawable drawable) {
        super(drawable, bArr, xv4);
        AbstractC13042fc3.i(imageViewCrossFade, "imageView");
        AbstractC13042fc3.i(xv4, "measuredSize");
        this.d = imageViewCrossFade;
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void a() {
        ImageViewCrossFade imageViewCrossFade = this.d;
        imageViewCrossFade.f();
        imageViewCrossFade.setImageDrawable(null);
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void m(float f, boolean z) {
        super.m(f, z);
        AbstractC17168mW3.A(this, x(), false, 2, null);
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void n(C4512Fl2 c4512Fl2, float f, long j) {
        AbstractC13042fc3.i(c4512Fl2, "localSource");
        super.n(c4512Fl2, f, j);
        AbstractC17168mW3.A(this, x(), false, 2, null);
    }

    @Override // ir.nasim.AbstractC17168mW3
    public void z(byte[] bArr, boolean z) {
        if (bArr != null) {
            this.d.o(bArr, y(z));
        }
    }
}
