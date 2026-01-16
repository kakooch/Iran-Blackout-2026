package ir.nasim;

import android.graphics.drawable.Drawable;
import ir.nasim.designsystem.ImageViewCrossFade;

/* loaded from: classes5.dex */
public class P03 extends AbstractC17168mW3 {
    private final ImageViewCrossFade d;
    private String e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public P03(byte[] bArr, ImageViewCrossFade imageViewCrossFade, XV4 xv4, Drawable drawable) {
        super(drawable, bArr, xv4);
        AbstractC13042fc3.i(imageViewCrossFade, "imageView");
        AbstractC13042fc3.i(xv4, "measuredSize");
        this.d = imageViewCrossFade;
    }

    @Override // ir.nasim.AbstractC17168mW3
    public void B(XV4 xv4) {
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

    protected void D(String str) {
        AbstractC13042fc3.i(str, "descriptor");
        AbstractC6302Na0 abstractC6302Na0D = ((C20107rU5) new C20107rU5().c0(((Number) v().e()).intValue(), ((Number) v().f()).intValue())).d();
        AbstractC13042fc3.h(abstractC6302Na0D, "centerCrop(...)");
        this.d.m(str, (C20107rU5) abstractC6302Na0D);
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void a() {
        ImageViewCrossFade imageViewCrossFade = this.d;
        imageViewCrossFade.f();
        imageViewCrossFade.setImageDrawable(null);
    }

    @Override // ir.nasim.AbstractC22597vW1, ir.nasim.InterfaceC8091Um2
    public void d(InterfaceC3346Am2 interfaceC3346Am2) {
        AbstractC13042fc3.i(interfaceC3346Am2, "reference");
        this.e = interfaceC3346Am2.getDescriptor();
        D(interfaceC3346Am2.getDescriptor());
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void m(float f, boolean z) {
        AbstractC17168mW3.A(this, x(), false, 2, null);
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void n(C4512Fl2 c4512Fl2, float f, long j) {
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
