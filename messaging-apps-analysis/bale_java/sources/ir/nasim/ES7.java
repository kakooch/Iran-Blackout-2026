package ir.nasim;

import android.graphics.drawable.Drawable;
import ir.nasim.designsystem.ImageViewCrossFade;

/* loaded from: classes5.dex */
public final class ES7 extends AbstractC17168mW3 {
    private final ImageViewCrossFade d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ES7(byte[] bArr, ImageViewCrossFade imageViewCrossFade, XV4 xv4, Drawable drawable) {
        super(drawable, bArr, xv4);
        AbstractC13042fc3.i(imageViewCrossFade, "imageView");
        AbstractC13042fc3.i(xv4, "measuredSize");
        this.d = imageViewCrossFade;
        AbstractC17168mW3.A(this, bArr, false, 2, null);
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void a() {
        ImageViewCrossFade imageViewCrossFade = this.d;
        imageViewCrossFade.f();
        imageViewCrossFade.setImageDrawable(null);
    }

    @Override // ir.nasim.AbstractC17168mW3
    public void z(byte[] bArr, boolean z) {
        if (bArr != null) {
            this.d.o(bArr, y(z));
        }
    }
}
