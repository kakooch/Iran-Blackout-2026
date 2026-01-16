package com.skydoves.balloon.overlay;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import ir.nasim.AbstractC10882cM5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C5942Lm4;
import ir.nasim.CX7;
import ir.nasim.DX7;
import ir.nasim.ED1;
import ir.nasim.InterfaceC5239Im3;
import ir.nasim.T20;
import ir.nasim.U20;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0010\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\n¢\u0006\u0004\b\u0014\u0010\fJ\u0017\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u0015\u0010\u0016J7\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u001d\u0010\u001eR/\u0010%\u001a\u0004\u0018\u00010\u00012\b\u0010\u001f\u001a\u0004\u0018\u00010\u00018F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R;\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010&2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010&8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010 \u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R+\u0010/\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00068G@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010 \u001a\u0004\b,\u0010\u0013\"\u0004\b-\u0010.R+\u00103\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00068G@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b0\u0010 \u001a\u0004\b1\u0010\u0013\"\u0004\b2\u0010.R+\u0010:\u001a\u0002042\u0006\u0010\u001f\u001a\u0002048G@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b5\u0010 \u001a\u0004\b6\u00107\"\u0004\b8\u00109R/\u0010A\u001a\u0004\u0018\u00010;2\b\u0010\u001f\u001a\u0004\u0018\u00010;8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b<\u0010 \u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R+\u0010H\u001a\u00020B2\u0006\u0010\u001f\u001a\u00020B8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bC\u0010 \u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u0018\u0010L\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0014\u0010P\u001a\u00020M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0014\u0010R\u001a\u00020M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010OR\u0016\u0010U\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010T¨\u0006V"}, d2 = {"Lcom/skydoves/balloon/overlay/BalloonAnchorOverlayView;", "Landroid/view/View;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lir/nasim/rB7;", "c", "()V", "view", "Landroid/graphics/Canvas;", "canvas", "a", "(Landroid/view/View;Landroid/graphics/Canvas;)V", "getStatusBarHeight", "()I", "b", "dispatchDraw", "(Landroid/graphics/Canvas;)V", "", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "<set-?>", "Lir/nasim/CX7;", "getAnchorView", "()Landroid/view/View;", "setAnchorView", "(Landroid/view/View;)V", "anchorView", "", "getAnchorViewList", "()Ljava/util/List;", "setAnchorViewList", "(Ljava/util/List;)V", "anchorViewList", "getOverlayColor", "setOverlayColor", "(I)V", "overlayColor", "d", "getOverlayPaddingColor", "setOverlayPaddingColor", "overlayPaddingColor", "", "e", "getOverlayPadding", "()F", "setOverlayPadding", "(F)V", "overlayPadding", "Landroid/graphics/Point;", "f", "getOverlayPosition", "()Landroid/graphics/Point;", "setOverlayPosition", "(Landroid/graphics/Point;)V", "overlayPosition", "Lir/nasim/U20;", "g", "getBalloonOverlayShape", "()Lir/nasim/U20;", "setBalloonOverlayShape", "(Lir/nasim/U20;)V", "balloonOverlayShape", "Landroid/graphics/Bitmap;", "h", "Landroid/graphics/Bitmap;", "bitmap", "Landroid/graphics/Paint;", "i", "Landroid/graphics/Paint;", "paint", "j", "paddingColorPaint", "k", "Z", "invalidated", "balloon_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class BalloonAnchorOverlayView extends View {
    static final /* synthetic */ InterfaceC5239Im3[] l = {AbstractC10882cM5.f(new C5942Lm4(BalloonAnchorOverlayView.class, "anchorView", "getAnchorView()Landroid/view/View;", 0)), AbstractC10882cM5.f(new C5942Lm4(BalloonAnchorOverlayView.class, "anchorViewList", "getAnchorViewList()Ljava/util/List;", 0)), AbstractC10882cM5.f(new C5942Lm4(BalloonAnchorOverlayView.class, "overlayColor", "getOverlayColor()I", 0)), AbstractC10882cM5.f(new C5942Lm4(BalloonAnchorOverlayView.class, "overlayPaddingColor", "getOverlayPaddingColor()I", 0)), AbstractC10882cM5.f(new C5942Lm4(BalloonAnchorOverlayView.class, "overlayPadding", "getOverlayPadding()F", 0)), AbstractC10882cM5.f(new C5942Lm4(BalloonAnchorOverlayView.class, "overlayPosition", "getOverlayPosition()Landroid/graphics/Point;", 0)), AbstractC10882cM5.f(new C5942Lm4(BalloonAnchorOverlayView.class, "balloonOverlayShape", "getBalloonOverlayShape()Lcom/skydoves/balloon/overlay/BalloonOverlayShape;", 0))};

    /* renamed from: a, reason: from kotlin metadata */
    private final CX7 anchorView;

    /* renamed from: b, reason: from kotlin metadata */
    private final CX7 anchorViewList;

    /* renamed from: c, reason: from kotlin metadata */
    private final CX7 overlayColor;

    /* renamed from: d, reason: from kotlin metadata */
    private final CX7 overlayPaddingColor;

    /* renamed from: e, reason: from kotlin metadata */
    private final CX7 overlayPadding;

    /* renamed from: f, reason: from kotlin metadata */
    private final CX7 overlayPosition;

    /* renamed from: g, reason: from kotlin metadata */
    private final CX7 balloonOverlayShape;

    /* renamed from: h, reason: from kotlin metadata */
    private Bitmap bitmap;

    /* renamed from: i, reason: from kotlin metadata */
    private final Paint paint;

    /* renamed from: j, reason: from kotlin metadata */
    private final Paint paddingColorPaint;

    /* renamed from: k, reason: from kotlin metadata */
    private boolean invalidated;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BalloonAnchorOverlayView(Context context) {
        this(context, null, 0, 6, null);
        AbstractC13042fc3.i(context, "context");
    }

    private final void a(View view, Canvas canvas) {
        if (view != null) {
            view.getGlobalVisibleRect(new Rect());
            RectF rectF = getOverlayPosition() != null ? new RectF(r1.x - getOverlayPadding(), (r1.y - getOverlayPadding()) + getStatusBarHeight(), r1.x + view.getWidth() + getOverlayPadding(), r1.y + view.getHeight() + getOverlayPadding() + getStatusBarHeight()) : new RectF(r0.left - getOverlayPadding(), r0.top - getOverlayPadding(), r0.right + getOverlayPadding(), r0.bottom + getOverlayPadding());
            float overlayPadding = getOverlayPadding() / 2;
            RectF rectF2 = new RectF(rectF);
            rectF2.inset(overlayPadding, overlayPadding);
            if (!(getBalloonOverlayShape() instanceof T20)) {
                throw new NoWhenBranchMatchedException();
            }
            canvas.drawOval(rectF, this.paint);
            canvas.drawOval(rectF2, this.paddingColorPaint);
        }
    }

    private final void c() {
        if (getWidth() == 0 || getHeight() == 0) {
            return;
        }
        View anchorView = getAnchorView();
        if (anchorView == null || anchorView.getWidth() != 0) {
            View anchorView2 = getAnchorView();
            if (anchorView2 == null || anchorView2.getHeight() != 0) {
                Bitmap bitmap = this.bitmap;
                if (bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
                this.bitmap = bitmapCreateBitmap;
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                Paint paint = this.paint;
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
                paint.setColor(getOverlayColor());
                canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.paint);
                Paint paint2 = this.paint;
                paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
                paint2.setColor(0);
                Paint paint3 = this.paddingColorPaint;
                paint3.setColor(getOverlayPaddingColor());
                paint3.setStyle(Paint.Style.STROKE);
                paint3.setStrokeWidth(getOverlayPadding());
                List<View> anchorViewList = getAnchorViewList();
                if (anchorViewList == null || anchorViewList.isEmpty()) {
                    a(getAnchorView(), canvas);
                } else {
                    List<View> anchorViewList2 = getAnchorViewList();
                    if (anchorViewList2 != null) {
                        Iterator<T> it = anchorViewList2.iterator();
                        while (it.hasNext()) {
                            a((View) it.next(), canvas);
                        }
                    }
                }
                this.invalidated = false;
            }
        }
    }

    private final int getStatusBarHeight() {
        Rect rect = new Rect();
        Context context = getContext();
        if (!(context instanceof Activity)) {
            return 0;
        }
        ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return rect.top;
    }

    public final void b() {
        this.invalidated = true;
        invalidate();
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Bitmap bitmap;
        AbstractC13042fc3.i(canvas, "canvas");
        if (this.invalidated || (bitmap = this.bitmap) == null || (bitmap != null && bitmap.isRecycled())) {
            c();
        }
        Bitmap bitmap2 = this.bitmap;
        if (bitmap2 == null || bitmap2.isRecycled()) {
            return;
        }
        canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
    }

    public final View getAnchorView() {
        return (View) this.anchorView.a(this, l[0]);
    }

    public final List<View> getAnchorViewList() {
        return (List) this.anchorViewList.a(this, l[1]);
    }

    public final U20 getBalloonOverlayShape() {
        return (U20) this.balloonOverlayShape.a(this, l[6]);
    }

    public final int getOverlayColor() {
        return ((Number) this.overlayColor.a(this, l[2])).intValue();
    }

    public final float getOverlayPadding() {
        return ((Number) this.overlayPadding.a(this, l[4])).floatValue();
    }

    public final int getOverlayPaddingColor() {
        return ((Number) this.overlayPaddingColor.a(this, l[3])).intValue();
    }

    public final Point getOverlayPosition() {
        return (Point) this.overlayPosition.a(this, l[5]);
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        this.invalidated = true;
    }

    public final void setAnchorView(View view) {
        this.anchorView.b(this, l[0], view);
    }

    public final void setAnchorViewList(List<? extends View> list) {
        this.anchorViewList.b(this, l[1], list);
    }

    public final void setBalloonOverlayShape(U20 u20) {
        AbstractC13042fc3.i(u20, "<set-?>");
        this.balloonOverlayShape.b(this, l[6], u20);
    }

    public final void setOverlayColor(int i) {
        this.overlayColor.b(this, l[2], Integer.valueOf(i));
    }

    public final void setOverlayPadding(float f) {
        this.overlayPadding.b(this, l[4], Float.valueOf(f));
    }

    public final void setOverlayPaddingColor(int i) {
        this.overlayPaddingColor.b(this, l[3], Integer.valueOf(i));
    }

    public final void setOverlayPosition(Point point) {
        this.overlayPosition.b(this, l[5], point);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BalloonAnchorOverlayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        AbstractC13042fc3.i(context, "context");
    }

    public /* synthetic */ BalloonAnchorOverlayView(Context context, AttributeSet attributeSet, int i, int i2, ED1 ed1) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BalloonAnchorOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        this.anchorView = DX7.a(this, null);
        this.anchorViewList = DX7.a(this, null);
        this.overlayColor = DX7.a(this, 0);
        this.overlayPaddingColor = DX7.a(this, 0);
        this.overlayPadding = DX7.a(this, Float.valueOf(0.0f));
        this.overlayPosition = DX7.a(this, null);
        this.balloonOverlayShape = DX7.a(this, T20.a);
        Paint paint = new Paint(1);
        this.paint = paint;
        Paint paint2 = new Paint(1);
        this.paddingColorPaint = paint2;
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        paint2.setAntiAlias(true);
        paint2.setFilterBitmap(true);
        paint2.setDither(true);
    }
}
