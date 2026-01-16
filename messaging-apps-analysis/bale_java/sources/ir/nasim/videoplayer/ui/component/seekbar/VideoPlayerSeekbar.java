package ir.nasim.videoplayer.ui.component.seekbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatSeekBar;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC15790kA5;
import ir.nasim.AbstractC4597Fu6;
import ir.nasim.C17942np0;
import ir.nasim.C8792Xi5;
import ir.nasim.ED1;
import ir.nasim.EnumC4870Gx3;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.QY0;
import ir.nasim.SA2;
import ir.nasim.videoplayer.ui.component.seekbar.VideoPlayerSeekbar;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ#\u0010\u000e\u001a\u00020\r*\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u0010\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\nH\u0014¢\u0006\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001d\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!¨\u0006#"}, d2 = {"Lir/nasim/videoplayer/ui/component/seekbar/VideoPlayerSeekbar;", "Landroidx/appcompat/widget/AppCompatSeekBar;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/graphics/Canvas;", "progress", "max", "Lir/nasim/rB7;", "d", "(Landroid/graphics/Canvas;II)V", "getProgressHeight", "()Ljava/lang/Integer;", "Lir/nasim/Xi5;", "positionState", "b", "(Lir/nasim/Xi5;)V", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "Landroid/graphics/Paint;", "Lir/nasim/Yu3;", "getCacheSpanPaint", "()Landroid/graphics/Paint;", "cacheSpanPaint", "", "Lir/nasim/np0;", "c", "Ljava/util/Set;", "cachedSpans", "videoplayer_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes8.dex */
public final class VideoPlayerSeekbar extends AppCompatSeekBar {

    /* renamed from: b, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 cacheSpanPaint;

    /* renamed from: c, reason: from kotlin metadata */
    private Set cachedSpans;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VideoPlayerSeekbar(Context context) {
        this(context, null, 0, 6, null);
        AbstractC13042fc3.i(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Paint c() {
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.BEVEL);
        paint.setColor(QY0.k(-1, 102));
        return paint;
    }

    private final void d(Canvas canvas, int i, int i2) {
        float paddingTop = getPaddingTop() + ((canvas.getHeight() - (getPaddingTop() + getPaddingBottom())) / 2.0f);
        int width = canvas.getWidth() - (getPaddingLeft() + getPaddingRight());
        Integer progressHeight = getProgressHeight();
        if (progressHeight != null) {
            float f = paddingTop - (r2 / 2);
            float fIntValue = progressHeight.intValue() + f;
            float f2 = i / i2;
            for (C17942np0 c17942np0 : this.cachedSpans) {
                if (c17942np0.a() > f2) {
                    float f3 = width;
                    canvas.drawRect((Math.max(c17942np0.b(), f2) * f3) + getPaddingLeft(), f, getPaddingLeft() + (c17942np0.a() * f3), fIntValue, getCacheSpanPaint());
                }
            }
        }
    }

    private final Paint getCacheSpanPaint() {
        return (Paint) this.cacheSpanPaint.getValue();
    }

    private final Integer getProgressHeight() {
        Drawable progressDrawable = getProgressDrawable();
        LayerDrawable layerDrawable = progressDrawable instanceof LayerDrawable ? (LayerDrawable) progressDrawable : null;
        if (layerDrawable != null && layerDrawable.getNumberOfLayers() >= 1) {
            return Integer.valueOf(layerDrawable.getDrawable(0).getBounds().height());
        }
        return null;
    }

    public final void b(C8792Xi5 positionState) {
        AbstractC13042fc3.i(positionState, "positionState");
        this.cachedSpans = positionState.b();
        long j = 10;
        setMax((int) (positionState.c() / j));
        if (!positionState.e()) {
            setProgress((int) (positionState.a() / j));
        }
        invalidate();
    }

    @Override // androidx.appcompat.widget.AppCompatSeekBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected void onDraw(Canvas canvas) {
        AbstractC13042fc3.i(canvas, "canvas");
        d(canvas, getProgress(), getMax());
        super.onDraw(canvas);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VideoPlayerSeekbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        AbstractC13042fc3.i(context, "context");
    }

    public /* synthetic */ VideoPlayerSeekbar(Context context, AttributeSet attributeSet, int i, int i2, ED1 ed1) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? AbstractC15790kA5.seekBarStyle : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoPlayerSeekbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        this.cacheSpanPaint = AbstractC13269fw3.b(EnumC4870Gx3.c, new SA2() { // from class: ir.nasim.kU7
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return VideoPlayerSeekbar.c();
            }
        });
        this.cachedSpans = AbstractC4597Fu6.d();
    }
}
