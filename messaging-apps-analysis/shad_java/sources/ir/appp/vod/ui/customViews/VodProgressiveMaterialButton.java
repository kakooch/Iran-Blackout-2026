package ir.appp.vod.ui.customViews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.google.android.material.button.MaterialButton;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import org.rbmain.messenger.AndroidUtilities;

/* compiled from: VodProgressiveMaterialButton.kt */
/* loaded from: classes3.dex */
public final class VodProgressiveMaterialButton extends MaterialButton {
    private ColorBarDrawable bgDrawable;
    private boolean isDisable;
    private Function0<Unit> onTimeEnded;
    private Job progressUpdateJob;

    public final Function0<Unit> getOnTimeEnded() {
        return this.onTimeEnded;
    }

    public final void setOnTimeEnded(Function0<Unit> function0) {
        this.onTimeEnded = function0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VodProgressiveMaterialButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        new LinkedHashMap();
        this.isDisable = true;
        ColorBarDrawable colorBarDrawable = new ColorBarDrawable(this);
        this.bgDrawable = colorBarDrawable;
        setBackground(colorBarDrawable);
    }

    private final synchronized void setProgress(float f) {
        this.bgDrawable.setProgress(f);
        invalidate();
    }

    public final void stopWatchVideoTimer() {
        Job job;
        this.isDisable = true;
        Job job2 = this.progressUpdateJob;
        if (job2 == null) {
            return;
        }
        if ((job2.isCancelled() && job2.isCompleted()) || (job = this.progressUpdateJob) == null) {
            return;
        }
        Job.DefaultImpls.cancel$default(job, null, 1, null);
    }

    /* compiled from: VodProgressiveMaterialButton.kt */
    private final class ColorBarDrawable extends Drawable {
        private int backgroundColor;
        private int foregroundColor;
        private float progress;
        final /* synthetic */ VodProgressiveMaterialButton this$0;

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -1;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }

        public ColorBarDrawable(VodProgressiveMaterialButton this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this.this$0 = this$0;
            this.backgroundColor = -1;
        }

        public final int getBackgroundColor() {
            return this.backgroundColor;
        }

        public final int getForegroundColor() {
            return this.foregroundColor;
        }

        public final void setProgress(float f) {
            this.progress = f;
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Paint paint = new Paint();
            paint.setColor(getBackgroundColor());
            paint.setFlags(1);
            Paint paint2 = new Paint();
            paint2.setColor(getForegroundColor());
            paint2.setFlags(1);
            float fWidth = (getBounds().width() * this.progress) / 100.0f;
            canvas.clipPath(roundedRect(0.0f, this.this$0.getInsetTop(), getBounds().width(), getBounds().height() - this.this$0.getInsetBottom(), AndroidUtilities.dp(5.0f), AndroidUtilities.dp(5.0f), true, true, true, true));
            canvas.drawRect(new RectF(0.0f, this.this$0.getInsetTop(), fWidth, getBounds().height() - this.this$0.getInsetBottom()), paint2);
            canvas.drawRect(new RectF(fWidth, 0.0f, getBounds().width(), getBounds().height()), paint);
        }

        public final Path roundedRect(float f, float f2, float f3, float f4, float f5, float f6, boolean z, boolean z2, boolean z3, boolean z4) {
            Path path = new Path();
            if (f5 < 0.0f) {
                f5 = 0.0f;
            }
            if (f6 < 0.0f) {
                f6 = 0.0f;
            }
            float f7 = f3 - f;
            float f8 = f4 - f2;
            float f9 = 2;
            float f10 = f7 / f9;
            if (f5 > f10) {
                f5 = f10;
            }
            float f11 = f8 / f9;
            if (f6 > f11) {
                f6 = f11;
            }
            float f12 = f7 - (f9 * f5);
            float f13 = f8 - (f9 * f6);
            path.moveTo(f3, f2 + f6);
            if (z2) {
                float f14 = -f6;
                path.rQuadTo(0.0f, f14, -f5, f14);
            } else {
                path.rLineTo(0.0f, -f6);
                path.rLineTo(-f5, 0.0f);
            }
            path.rLineTo(-f12, 0.0f);
            if (z) {
                float f15 = -f5;
                path.rQuadTo(f15, 0.0f, f15, f6);
            } else {
                path.rLineTo(-f5, 0.0f);
                path.rLineTo(0.0f, f6);
            }
            path.rLineTo(0.0f, f13);
            if (z4) {
                path.rQuadTo(0.0f, f6, f5, f6);
            } else {
                path.rLineTo(0.0f, f6);
                path.rLineTo(f5, 0.0f);
            }
            path.rLineTo(f12, 0.0f);
            if (z3) {
                path.rQuadTo(f5, 0.0f, f5, -f6);
            } else {
                path.rLineTo(f5, 0.0f);
                path.rLineTo(0.0f, -f6);
            }
            path.rLineTo(0.0f, -f13);
            path.close();
            return path;
        }
    }
}
