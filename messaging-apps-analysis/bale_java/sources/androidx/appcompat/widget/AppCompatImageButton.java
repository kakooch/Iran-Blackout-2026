package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;
import ir.nasim.AbstractC15790kA5;

/* loaded from: classes.dex */
public class AppCompatImageButton extends ImageButton {
    private final C1917d a;
    private final k b;
    private boolean c;

    public AppCompatImageButton(Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        C1917d c1917d = this.a;
        if (c1917d != null) {
            c1917d.b();
        }
        k kVar = this.b;
        if (kVar != null) {
            kVar.c();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C1917d c1917d = this.a;
        if (c1917d != null) {
            return c1917d.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C1917d c1917d = this.a;
        if (c1917d != null) {
            return c1917d.d();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        k kVar = this.b;
        if (kVar != null) {
            return kVar.d();
        }
        return null;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        k kVar = this.b;
        if (kVar != null) {
            return kVar.e();
        }
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        return this.b.f() && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C1917d c1917d = this.a;
        if (c1917d != null) {
            c1917d.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        C1917d c1917d = this.a;
        if (c1917d != null) {
            c1917d.g(i);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        k kVar = this.b;
        if (kVar != null) {
            kVar.c();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        k kVar = this.b;
        if (kVar != null && drawable != null && !this.c) {
            kVar.h(drawable);
        }
        super.setImageDrawable(drawable);
        k kVar2 = this.b;
        if (kVar2 != null) {
            kVar2.c();
            if (this.c) {
                return;
            }
            this.b.b();
        }
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int i) {
        super.setImageLevel(i);
        this.c = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.b.i(i);
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        k kVar = this.b;
        if (kVar != null) {
            kVar.c();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C1917d c1917d = this.a;
        if (c1917d != null) {
            c1917d.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C1917d c1917d = this.a;
        if (c1917d != null) {
            c1917d.j(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        k kVar = this.b;
        if (kVar != null) {
            kVar.j(colorStateList);
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        k kVar = this.b;
        if (kVar != null) {
            kVar.k(mode);
        }
    }

    public AppCompatImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC15790kA5.imageButtonStyle);
    }

    public AppCompatImageButton(Context context, AttributeSet attributeSet, int i) {
        super(z.b(context), attributeSet, i);
        this.c = false;
        y.a(this, getContext());
        C1917d c1917d = new C1917d(this);
        this.a = c1917d;
        c1917d.e(attributeSet, i);
        k kVar = new k(this);
        this.b = kVar;
        kVar.g(attributeSet, i);
    }
}
