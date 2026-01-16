package com.github.chrisbanes.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import ir.nasim.CJ4;
import ir.nasim.InterfaceC10863cK4;
import ir.nasim.InterfaceC17061mK4;
import ir.nasim.InterfaceC18243oK4;
import ir.nasim.JJ4;
import ir.nasim.K95;
import ir.nasim.NJ4;
import ir.nasim.XJ4;

/* loaded from: classes2.dex */
public class PhotoView extends AppCompatImageView {
    private K95 d;
    private ImageView.ScaleType e;

    public PhotoView(Context context) {
        this(context, null);
    }

    private void c() {
        this.d = new K95(this);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        ImageView.ScaleType scaleType = this.e;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.e = null;
        }
    }

    public K95 getAttacher() {
        return this.d;
    }

    public RectF getDisplayRect() {
        return this.d.B();
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return this.d.E();
    }

    public float getMaximumScale() {
        return this.d.H();
    }

    public float getMediumScale() {
        return this.d.I();
    }

    public float getMinimumScale() {
        return this.d.J();
    }

    public float getScale() {
        return this.d.K();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.d.L();
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.d.O(z);
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super.setFrame(i, i2, i3, i4);
        if (frame) {
            this.d.m0();
        }
        return frame;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        K95 k95 = this.d;
        if (k95 != null) {
            k95.m0();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        K95 k95 = this.d;
        if (k95 != null) {
            k95.m0();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        K95 k95 = this.d;
        if (k95 != null) {
            k95.m0();
        }
    }

    public void setMaximumScale(float f) {
        this.d.Q(f);
    }

    public void setMediumScale(float f) {
        this.d.R(f);
    }

    public void setMinimumScale(float f) {
        this.d.S(f);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.d.T(onClickListener);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.d.U(onDoubleTapListener);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.d.V(onLongClickListener);
    }

    public void setOnMatrixChangeListener(CJ4 cj4) {
        this.d.W(cj4);
    }

    public void setOnOutsidePhotoTapListener(JJ4 jj4) {
        this.d.X(jj4);
    }

    public void setOnPhotoTapListener(NJ4 nj4) {
        this.d.Y(nj4);
    }

    public void setOnScaleChangeListener(XJ4 xj4) {
        this.d.Z(xj4);
    }

    public void setOnSingleFlingListener(InterfaceC10863cK4 interfaceC10863cK4) {
        this.d.a0(interfaceC10863cK4);
    }

    public void setOnViewDragListener(InterfaceC17061mK4 interfaceC17061mK4) {
        this.d.b0(interfaceC17061mK4);
    }

    public void setOnViewTapListener(InterfaceC18243oK4 interfaceC18243oK4) {
        this.d.c0(interfaceC18243oK4);
    }

    public void setRotationBy(float f) {
        this.d.d0(f);
    }

    public void setRotationTo(float f) {
        this.d.e0(f);
    }

    public void setScale(float f) {
        this.d.f0(f);
    }

    public void setScaleLevels(float f, float f2, float f3) {
        this.d.i0(f, f2, f3);
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        K95 k95 = this.d;
        if (k95 == null) {
            this.e = scaleType;
        } else {
            k95.j0(scaleType);
        }
    }

    public void setZoomTransitionDuration(int i) {
        this.d.k0(i);
    }

    public void setZoomable(boolean z) {
        this.d.l0(z);
    }

    public PhotoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setScale(float f, boolean z) {
        this.d.h0(f, z);
    }

    public PhotoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c();
    }

    public void setScale(float f, float f2, float f3, boolean z) {
        this.d.g0(f, f2, f3, z);
    }
}
