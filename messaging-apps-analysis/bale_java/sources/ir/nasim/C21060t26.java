package ir.nasim;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* renamed from: ir.nasim.t26, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C21060t26 extends Drawable implements InterfaceC4873Gx6 {
    private b a;

    @Override // android.graphics.drawable.Drawable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C21060t26 mutate() {
        this.a = new b(this.a);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        b bVar = this.a;
        if (bVar.b) {
            bVar.a.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.a.a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.a.a.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean zOnStateChange = super.onStateChange(iArr);
        if (this.a.a.setState(iArr)) {
            zOnStateChange = true;
        }
        boolean zE = AbstractC24690z26.e(iArr);
        b bVar = this.a;
        if (bVar.b == zE) {
            return zOnStateChange;
        }
        bVar.b = zE;
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.a.a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.a.a.setColorFilter(colorFilter);
    }

    @Override // ir.nasim.InterfaceC4873Gx6
    public void setShapeAppearanceModel(C11411cx6 c11411cx6) {
        this.a.a.setShapeAppearanceModel(c11411cx6);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i) {
        this.a.a.setTint(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.a.a.setTintList(colorStateList);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.a.a.setTintMode(mode);
    }

    public C21060t26(C11411cx6 c11411cx6) {
        this(new b(new C10345bV3(c11411cx6)));
    }

    /* renamed from: ir.nasim.t26$b */
    static final class b extends Drawable.ConstantState {
        C10345bV3 a;
        boolean b;

        public b(C10345bV3 c10345bV3) {
            this.a = c10345bV3;
            this.b = false;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C21060t26 newDrawable() {
            return new C21060t26(new b(this));
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        public b(b bVar) {
            this.a = (C10345bV3) bVar.a.getConstantState().newDrawable();
            this.b = bVar.b;
        }
    }

    private C21060t26(b bVar) {
        this.a = bVar;
    }
}
