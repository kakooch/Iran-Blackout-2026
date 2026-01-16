package ir.nasim;

import ir.nasim.AbstractC17757nW1;
import ir.nasim.designsystem.ImageViewCrossFade;

/* renamed from: ir.nasim.hE1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C14031hE1 extends AbstractC17168mW3 {
    private final AbstractC17757nW1.c.b.C1415b d;
    private final ImageViewCrossFade e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C14031hE1(AbstractC17757nW1.c.b.C1415b c1415b, ImageViewCrossFade imageViewCrossFade) {
        super(null, null, AbstractC4616Fw7.a(0, 0));
        AbstractC13042fc3.i(c1415b, "defaultImage");
        AbstractC13042fc3.i(imageViewCrossFade, "imageView");
        this.d = c1415b;
        this.e = imageViewCrossFade;
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void a() {
        ImageViewCrossFade imageViewCrossFade = this.e;
        imageViewCrossFade.setImageDrawable(null);
        imageViewCrossFade.setBackgroundColor(0);
    }

    @Override // ir.nasim.AbstractC22597vW1, ir.nasim.InterfaceC8091Um2
    public void d(InterfaceC3346Am2 interfaceC3346Am2) {
        AbstractC13042fc3.i(interfaceC3346Am2, "reference");
        this.e.setImageDrawable(this.d.h());
        this.e.setBackgroundColor(this.d.g());
    }

    @Override // ir.nasim.AbstractC17168mW3
    public void z(byte[] bArr, boolean z) {
    }
}
