package ir.nasim.features.settings.component;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatSeekBar;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC21139tA5;
import ir.nasim.AbstractC8943Xx1;
import ir.nasim.ED1;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.JF5;
import ir.nasim.OY0;
import ir.nasim.SA2;
import ir.nasim.features.settings.component.AutoDownloadSeekBar;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\f\u001a\u00020\u000b*\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000f\u0010\rR\u001b\u0010\u0015\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0019\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001c\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0018¨\u0006\u001f"}, d2 = {"Lir/nasim/features/settings/component/AutoDownloadSeekBar;", "Landroidx/appcompat/widget/AppCompatSeekBar;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/graphics/Canvas;", "Lir/nasim/rB7;", "f", "(Landroid/graphics/Canvas;)V", "canvas", "onDraw", "Landroid/graphics/Paint;", "b", "Lir/nasim/Yu3;", "getPaint", "()Landroid/graphics/Paint;", "paint", "c", "getActiveColor", "()I", "activeColor", "d", "getDisActiveColor", "disActiveColor", "e", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class AutoDownloadSeekBar extends AppCompatSeekBar {
    private static final a e = new a(null);
    public static final int f = 8;
    private static final int g = AbstractC8943Xx1.c(12);

    /* renamed from: b, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 paint;

    /* renamed from: c, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 activeColor;

    /* renamed from: d, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 disActiveColor;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AutoDownloadSeekBar(Context context) {
        this(context, null, 0, 6, null);
        AbstractC13042fc3.i(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int d(Context context) {
        AbstractC13042fc3.i(context, "$context");
        return OY0.b(context, AbstractC21139tA5.colorPrimary);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int e(Context context) {
        AbstractC13042fc3.i(context, "$context");
        return OY0.b(context, AbstractC21139tA5.n40);
    }

    private final void f(Canvas canvas) {
        float paddingLeft;
        float width;
        float paddingRight;
        int width2 = (canvas.getWidth() - (getPaddingLeft() + getPaddingRight())) + (getThumbOffset() * 2);
        float paddingTop = getPaddingTop() + ((canvas.getHeight() - (getPaddingTop() + getPaddingBottom())) / 2.0f);
        int max = getMax() + 1;
        int i = g;
        int max2 = (width2 - (max * i)) / getMax();
        float f2 = i / 2.0f;
        int max3 = getMax();
        if (max3 < 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            getPaint().setColor(i2 <= getProgress() ? getActiveColor() : getDisActiveColor());
            if (JF5.g()) {
                if (i2 == getMax()) {
                    paddingLeft = getPaddingLeft();
                } else {
                    width = canvas.getWidth();
                    paddingRight = getPaddingRight() + ((g + max2) * i2);
                    paddingLeft = width - paddingRight;
                }
            } else if (i2 == getMax()) {
                width = canvas.getWidth();
                paddingRight = getPaddingRight();
                paddingLeft = width - paddingRight;
            } else {
                paddingLeft = getPaddingLeft() + ((g + max2) * i2);
            }
            canvas.drawCircle(paddingLeft, paddingTop, f2, getPaint());
            if (i2 == max3) {
                return;
            } else {
                i2++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Paint g() {
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        return paint;
    }

    private final int getActiveColor() {
        return ((Number) this.activeColor.getValue()).intValue();
    }

    private final int getDisActiveColor() {
        return ((Number) this.disActiveColor.getValue()).intValue();
    }

    private final Paint getPaint() {
        return (Paint) this.paint.getValue();
    }

    @Override // androidx.appcompat.widget.AppCompatSeekBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected void onDraw(Canvas canvas) {
        AbstractC13042fc3.i(canvas, "canvas");
        super.onDraw(canvas);
        f(canvas);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AutoDownloadSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        AbstractC13042fc3.i(context, "context");
    }

    public /* synthetic */ AutoDownloadSeekBar(Context context, AttributeSet attributeSet, int i, int i2, ED1 ed1) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? AbstractC21139tA5.seekBarStyle : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoDownloadSeekBar(final Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        this.paint = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.pS
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return AutoDownloadSeekBar.g();
            }
        });
        this.activeColor = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.qS
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Integer.valueOf(AutoDownloadSeekBar.d(context));
            }
        });
        this.disActiveColor = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.rS
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Integer.valueOf(AutoDownloadSeekBar.e(context));
            }
        });
        Drawable tickMark = getTickMark();
        if (tickMark != null) {
            tickMark.setBounds(0, 0, 0, 0);
        }
        setTickMarkTintList(null);
    }
}
