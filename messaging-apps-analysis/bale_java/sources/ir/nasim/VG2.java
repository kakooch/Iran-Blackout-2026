package ir.nasim;

import android.graphics.drawable.Drawable;
import ir.nasim.designsystem.ImageViewCrossFade;
import java.io.File;

/* loaded from: classes5.dex */
public final class VG2 extends AbstractC17168mW3 {
    private final ImageViewCrossFade d;
    private String e;
    private C8610Ws f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VG2(byte[] bArr, ImageViewCrossFade imageViewCrossFade, XV4 xv4, Drawable drawable) {
        super(drawable, bArr, xv4);
        AbstractC13042fc3.i(imageViewCrossFade, "imageView");
        AbstractC13042fc3.i(xv4, "measuredSize");
        AbstractC13042fc3.i(drawable, "placeHolder");
        this.d = imageViewCrossFade;
    }

    private final void D(String str) throws InterruptedException {
        E();
        C8610Ws c8610Ws = new C8610Ws(new File(str), false);
        this.d.j(c8610Ws, true);
        this.f = c8610Ws;
    }

    private final void E() {
        C8610Ws c8610Ws = this.f;
        if (c8610Ws != null) {
            c8610Ws.stop();
            c8610Ws.S(null);
        }
        this.f = null;
    }

    @Override // ir.nasim.AbstractC17168mW3
    public void B(XV4 xv4) throws InterruptedException {
        AbstractC13042fc3.i(xv4, "measuredWidthAndHeight");
        if (AbstractC13042fc3.d(v(), xv4)) {
            return;
        }
        C(xv4);
        String str = this.e;
        if (str != null) {
            D(str);
        } else {
            z(x(), false);
        }
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void a() {
        ImageViewCrossFade imageViewCrossFade = this.d;
        imageViewCrossFade.f();
        imageViewCrossFade.setImageDrawable(null);
        E();
    }

    @Override // ir.nasim.AbstractC22597vW1, ir.nasim.InterfaceC8091Um2
    public void d(InterfaceC3346Am2 interfaceC3346Am2) throws InterruptedException {
        AbstractC13042fc3.i(interfaceC3346Am2, "reference");
        this.e = interfaceC3346Am2.getDescriptor();
        D(interfaceC3346Am2.getDescriptor());
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void m(float f, boolean z) {
        AbstractC17168mW3.A(this, x(), false, 2, null);
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void n(C4512Fl2 c4512Fl2, float f, long j) throws InterruptedException {
        AbstractC13042fc3.i(c4512Fl2, "localSource");
        String str = c4512Fl2.c;
        this.e = str;
        D(str);
    }

    @Override // ir.nasim.AbstractC17168mW3
    public void z(byte[] bArr, boolean z) {
        if (bArr != null) {
            this.d.o(bArr, y(z));
        }
    }
}
