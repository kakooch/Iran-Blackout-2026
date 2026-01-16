package ir.nasim;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/* loaded from: classes2.dex */
public abstract class D02 implements DW5, B73 {
    protected final Drawable a;

    public D02(Drawable drawable) {
        this.a = (Drawable) AbstractC3322Aj5.d(drawable);
    }

    @Override // ir.nasim.DW5
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final Drawable get() {
        Drawable.ConstantState constantState = this.a.getConstantState();
        return constantState == null ? this.a : constantState.newDrawable();
    }

    @Override // ir.nasim.B73
    public void initialize() {
        Drawable drawable = this.a;
        if (drawable instanceof BitmapDrawable) {
            ((BitmapDrawable) drawable).getBitmap().prepareToDraw();
        } else if (drawable instanceof C11598dH2) {
            ((C11598dH2) drawable).e().prepareToDraw();
        }
    }
}
