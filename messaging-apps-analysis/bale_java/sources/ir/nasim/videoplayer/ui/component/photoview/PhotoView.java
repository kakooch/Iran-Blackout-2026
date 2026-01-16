package ir.nasim.videoplayer.ui.component.photoview;

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
import ir.nasim.AbstractC13042fc3;
import ir.nasim.BJ4;
import ir.nasim.ED1;
import ir.nasim.IJ4;
import ir.nasim.InterfaceC10247bK4;
import ir.nasim.InterfaceC17652nK4;
import ir.nasim.J95;
import ir.nasim.MJ4;
import ir.nasim.WJ4;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0016\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001d\u001a\u00020\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b \u0010!J\u0019\u0010$\u001a\u00020\u00122\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0004\b$\u0010%J/\u0010*\u001a\u00020)2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0006H\u0014¢\u0006\u0004\b*\u0010+J\u0015\u0010.\u001a\u00020\u00122\u0006\u0010-\u001a\u00020,¢\u0006\u0004\b.\u0010/J\u0015\u00100\u001a\u00020\u00122\u0006\u0010-\u001a\u00020,¢\u0006\u0004\b0\u0010/J\u0015\u00102\u001a\u00020\u00122\u0006\u00101\u001a\u00020)¢\u0006\u0004\b2\u00103J\u0017\u00106\u001a\u00020\u00122\b\u00105\u001a\u0004\u0018\u000104¢\u0006\u0004\b6\u00107J\u0017\u00109\u001a\u00020\u00122\b\u00105\u001a\u0004\u0018\u000108¢\u0006\u0004\b9\u0010:J\u0017\u0010<\u001a\u00020\u00122\b\u00105\u001a\u0004\u0018\u00010;¢\u0006\u0004\b<\u0010=J\u0017\u0010?\u001a\u00020\u00122\b\u00105\u001a\u0004\u0018\u00010>¢\u0006\u0004\b?\u0010@J\u001d\u0010C\u001a\u00020\u00122\u0006\u0010A\u001a\u00020,2\u0006\u0010B\u001a\u00020)¢\u0006\u0004\bC\u0010DJ-\u0010C\u001a\u00020\u00122\u0006\u0010A\u001a\u00020,2\u0006\u0010E\u001a\u00020,2\u0006\u0010F\u001a\u00020,2\u0006\u0010B\u001a\u00020)¢\u0006\u0004\bC\u0010GJ\u0015\u0010I\u001a\u00020\u00122\u0006\u0010H\u001a\u00020\u0006¢\u0006\u0004\bI\u0010!J\u0017\u0010L\u001a\u00020\u00122\b\u0010K\u001a\u0004\u0018\u00010J¢\u0006\u0004\bL\u0010MJ\u0017\u0010P\u001a\u00020\u00122\b\u0010O\u001a\u0004\u0018\u00010N¢\u0006\u0004\bP\u0010QJ\u0017\u0010T\u001a\u00020\u00122\b\u0010S\u001a\u0004\u0018\u00010R¢\u0006\u0004\bT\u0010UR\u0017\u0010[\u001a\u00020V8\u0006¢\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010ZR\u0018\u0010^\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R$\u0010`\u001a\u00020)2\u0006\u0010_\u001a\u00020)8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b`\u0010a\"\u0004\bb\u00103R\u0013\u0010f\u001a\u0004\u0018\u00010c8F¢\u0006\u0006\u001a\u0004\bd\u0010eR$\u0010g\u001a\u00020,2\u0006\u0010g\u001a\u00020,8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bh\u0010i\"\u0004\bj\u0010/R$\u0010k\u001a\u00020,2\u0006\u0010k\u001a\u00020,8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bl\u0010i\"\u0004\bm\u0010/R$\u0010A\u001a\u00020,2\u0006\u0010A\u001a\u00020,8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bn\u0010i\"\u0004\bC\u0010/¨\u0006o"}, d2 = {"Lir/nasim/videoplayer/ui/component/photoview/PhotoView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/widget/ImageView$ScaleType;", "getScaleType", "()Landroid/widget/ImageView$ScaleType;", "Landroid/graphics/Matrix;", "getImageMatrix", "()Landroid/graphics/Matrix;", "Landroid/view/View$OnLongClickListener;", "l", "Lir/nasim/rB7;", "setOnLongClickListener", "(Landroid/view/View$OnLongClickListener;)V", "Landroid/view/View$OnClickListener;", "setOnClickListener", "(Landroid/view/View$OnClickListener;)V", "scaleType", "setScaleType", "(Landroid/widget/ImageView$ScaleType;)V", "Landroid/graphics/drawable/Drawable;", "drawable", "setImageDrawable", "(Landroid/graphics/drawable/Drawable;)V", "resId", "setImageResource", "(I)V", "Landroid/net/Uri;", "uri", "setImageURI", "(Landroid/net/Uri;)V", "t", "r", "b", "", "setFrame", "(IIII)Z", "", "rotationDegree", "setRotationTo", "(F)V", "setRotationBy", "allow", "setAllowParentInterceptOnEdge", "(Z)V", "Lir/nasim/BJ4;", "listener", "setOnMatrixChangeListener", "(Lir/nasim/BJ4;)V", "Lir/nasim/MJ4;", "setOnPhotoTapListener", "(Lir/nasim/MJ4;)V", "Lir/nasim/IJ4;", "setOnOutsidePhotoTapListener", "(Lir/nasim/IJ4;)V", "Lir/nasim/nK4;", "setOnViewTapListener", "(Lir/nasim/nK4;)V", "scale", "animate", "setScale", "(FZ)V", "focalX", "focalY", "(FFFZ)V", "milliseconds", "setZoomTransitionDuration", "Landroid/view/GestureDetector$OnDoubleTapListener;", "onDoubleTapListener", "setOnDoubleTapListener", "(Landroid/view/GestureDetector$OnDoubleTapListener;)V", "Lir/nasim/WJ4;", "onScaleChangedListener", "setOnScaleChangeListener", "(Lir/nasim/WJ4;)V", "Lir/nasim/bK4;", "onSingleFlingListener", "setOnSingleFlingListener", "(Lir/nasim/bK4;)V", "Lir/nasim/J95;", "d", "Lir/nasim/J95;", "getAttacher", "()Lir/nasim/J95;", "attacher", "e", "Landroid/widget/ImageView$ScaleType;", "pendingScaleType", "zoomable", "isZoomable", "()Z", "setZoomable", "Landroid/graphics/RectF;", "getDisplayRect", "()Landroid/graphics/RectF;", "displayRect", "minimumScale", "getMinimumScale", "()F", "setMinimumScale", "maximumScale", "getMaximumScale", "setMaximumScale", "getScale", "videoplayer_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes8.dex */
public final class PhotoView extends AppCompatImageView {

    /* renamed from: d, reason: from kotlin metadata */
    private final J95 attacher;

    /* renamed from: e, reason: from kotlin metadata */
    private ImageView.ScaleType pendingScaleType;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PhotoView(Context context) {
        this(context, null, 0, 6, null);
        AbstractC13042fc3.i(context, "context");
    }

    public final J95 getAttacher() {
        return this.attacher;
    }

    public final RectF getDisplayRect() {
        return this.attacher.C();
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return this.attacher.F();
    }

    public final float getMaximumScale() {
        return this.attacher.K();
    }

    public final float getMinimumScale() {
        return this.attacher.L();
    }

    public final float getScale() {
        return this.attacher.M();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.attacher.N();
    }

    public final void setAllowParentInterceptOnEdge(boolean allow) {
        this.attacher.Q(allow);
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int l, int t, int r, int b) {
        boolean frame = super.setFrame(l, t, r, b);
        if (frame) {
            this.attacher.l0();
        }
        return frame;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        this.attacher.l0();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int resId) {
        super.setImageResource(resId);
        this.attacher.l0();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        this.attacher.l0();
    }

    public final void setMaximumScale(float f) {
        this.attacher.S(f);
    }

    public final void setMinimumScale(float f) {
        this.attacher.T(f);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener l) {
        this.attacher.U(l);
    }

    public final void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.attacher.V(onDoubleTapListener);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener l) {
        this.attacher.W(l);
    }

    public final void setOnMatrixChangeListener(BJ4 listener) {
        this.attacher.X(listener);
    }

    public final void setOnOutsidePhotoTapListener(IJ4 listener) {
        this.attacher.Y(listener);
    }

    public final void setOnPhotoTapListener(MJ4 listener) {
        this.attacher.Z(listener);
    }

    public final void setOnScaleChangeListener(WJ4 onScaleChangedListener) {
        this.attacher.a0(onScaleChangedListener);
    }

    public final void setOnSingleFlingListener(InterfaceC10247bK4 onSingleFlingListener) {
        this.attacher.b0(onSingleFlingListener);
    }

    public final void setOnViewTapListener(InterfaceC17652nK4 listener) {
        this.attacher.c0(listener);
    }

    public final void setRotationBy(float rotationDegree) {
        this.attacher.d0(rotationDegree);
    }

    public final void setRotationTo(float rotationDegree) {
        this.attacher.e0(rotationDegree);
    }

    public final void setScale(float f) {
        this.attacher.f0(f);
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        AbstractC13042fc3.i(scaleType, "scaleType");
        this.attacher.i0(scaleType);
    }

    public final void setZoomTransitionDuration(int milliseconds) {
        this.attacher.j0(milliseconds);
    }

    public final void setZoomable(boolean z) {
        this.attacher.k0(z);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PhotoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        AbstractC13042fc3.i(context, "context");
    }

    public final void setScale(float scale, boolean animate) {
        this.attacher.h0(scale, animate);
    }

    public /* synthetic */ PhotoView(Context context, AttributeSet attributeSet, int i, int i2, ED1 ed1) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void setScale(float scale, float focalX, float focalY, boolean animate) {
        this.attacher.g0(scale, focalX, focalY, animate);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhotoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        this.attacher = new J95(this);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        ImageView.ScaleType scaleType = this.pendingScaleType;
        if (scaleType != null) {
            AbstractC13042fc3.f(scaleType);
            setScaleType(scaleType);
            this.pendingScaleType = null;
        }
    }
}
