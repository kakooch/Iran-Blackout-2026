package ir.nasim;

import android.graphics.drawable.Drawable;
import com.airbnb.lottie.LottieAnimationView;
import ir.nasim.AbstractC17757nW1;
import java.io.File;
import java.io.FileInputStream;

/* renamed from: ir.nasim.jt, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C15617jt extends AbstractC22597vW1 {
    private final AbstractC17757nW1.c.AbstractC1416c.a a;
    private final LottieAnimationView b;
    private final XV4 c;
    private final Drawable d;

    public C15617jt(AbstractC17757nW1.c.AbstractC1416c.a aVar, LottieAnimationView lottieAnimationView, XV4 xv4, Drawable drawable) {
        AbstractC13042fc3.i(aVar, "animatedSticker");
        AbstractC13042fc3.i(lottieAnimationView, "animationView");
        AbstractC13042fc3.i(xv4, "originalSize");
        this.a = aVar;
        this.b = lottieAnimationView;
        this.c = xv4;
        this.d = drawable;
    }

    private final void v(String str) {
        OI2.b(C5721Ko.a.d()).n(this.b);
        this.b.setAnimation(new FileInputStream(new File(str)), this.a.g());
        this.b.x();
    }

    private final void w(byte[] bArr) {
        OI2.b(C5721Ko.a.d()).z(bArr).f0(this.d).c0(((Number) this.c.e()).intValue(), ((Number) this.c.f()).intValue()).u0(new C5191Ih0(10, 3)).Q0(this.b);
    }

    @Override // ir.nasim.AbstractC22597vW1, ir.nasim.InterfaceC8091Um2
    public void d(InterfaceC3346Am2 interfaceC3346Am2) {
        AbstractC13042fc3.i(interfaceC3346Am2, "reference");
        v(interfaceC3346Am2.getDescriptor());
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void m(float f, boolean z) {
        byte[] bArrE = this.a.e();
        if (bArrE != null) {
            w(bArrE);
        }
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void n(C4512Fl2 c4512Fl2, float f, long j) {
        AbstractC13042fc3.i(c4512Fl2, "localSource");
        v(c4512Fl2.c);
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void a() {
    }
}
