package ir.nasim;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import ir.nasim.InterfaceC22855vv7;

/* renamed from: ir.nasim.m33, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC16900m33 extends PX7 implements InterfaceC22855vv7.a {
    private Animatable h;

    public AbstractC16900m33(ImageView imageView) {
        super(imageView);
    }

    private void p(Object obj) {
        if (!(obj instanceof Animatable)) {
            this.h = null;
            return;
        }
        Animatable animatable = (Animatable) obj;
        this.h = animatable;
        animatable.start();
    }

    private void r(Object obj) {
        q(obj);
        p(obj);
    }

    @Override // ir.nasim.InterfaceC21549tj7
    public void a(Object obj, InterfaceC22855vv7 interfaceC22855vv7) {
        if (interfaceC22855vv7 == null || !interfaceC22855vv7.a(obj, this)) {
            r(obj);
        } else {
            p(obj);
        }
    }

    @Override // ir.nasim.InterfaceC22855vv7.a
    public void b(Drawable drawable) {
        ((ImageView) this.a).setImageDrawable(drawable);
    }

    @Override // ir.nasim.InterfaceC22855vv7.a
    public Drawable d() {
        return ((ImageView) this.a).getDrawable();
    }

    @Override // ir.nasim.PX7, ir.nasim.AbstractC9823ad0, ir.nasim.InterfaceC21549tj7
    public void e(Drawable drawable) {
        super.e(drawable);
        r(null);
        b(drawable);
    }

    @Override // ir.nasim.InterfaceC17451mz3
    public void f() {
        Animatable animatable = this.h;
        if (animatable != null) {
            animatable.start();
        }
    }

    @Override // ir.nasim.PX7, ir.nasim.AbstractC9823ad0, ir.nasim.InterfaceC21549tj7
    public void g(Drawable drawable) {
        super.g(drawable);
        Animatable animatable = this.h;
        if (animatable != null) {
            animatable.stop();
        }
        r(null);
        b(drawable);
    }

    @Override // ir.nasim.InterfaceC17451mz3
    public void i() {
        Animatable animatable = this.h;
        if (animatable != null) {
            animatable.stop();
        }
    }

    @Override // ir.nasim.AbstractC9823ad0, ir.nasim.InterfaceC21549tj7
    public void k(Drawable drawable) {
        super.k(drawable);
        r(null);
        b(drawable);
    }

    protected abstract void q(Object obj);
}
