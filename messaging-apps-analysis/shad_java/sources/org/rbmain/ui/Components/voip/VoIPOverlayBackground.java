package org.rbmain.ui.Components.voip;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.widget.ImageView;
import androidx.core.graphics.ColorUtils;
import androidx.palette.graphics.Palette;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ImageReceiver;
import org.rbmain.messenger.Utilities;

/* loaded from: classes5.dex */
public class VoIPOverlayBackground extends ImageView {
    float blackoutProgress;
    boolean showBlackout;

    public VoIPOverlayBackground(Context context) {
        super(context);
        ColorUtils.setAlphaComponent(-16777216, 102);
        setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        float f = this.blackoutProgress;
        if (f == 1.0f) {
            canvas.drawColor(ColorUtils.setAlphaComponent(-16777216, 102));
            return;
        }
        if (f == 0.0f) {
            setImageAlpha(255);
            super.onDraw(canvas);
        } else {
            canvas.drawColor(ColorUtils.setAlphaComponent(-16777216, (int) (f * 102.0f)));
            setImageAlpha((int) ((1.0f - this.blackoutProgress) * 255.0f));
            super.onDraw(canvas);
        }
    }

    public void setBackground(final ImageReceiver.BitmapHolder bitmapHolder) {
        new Thread(new Runnable() { // from class: org.rbmain.ui.Components.voip.VoIPOverlayBackground$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setBackground$1(bitmapHolder);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setBackground$1(final ImageReceiver.BitmapHolder bitmapHolder) {
        try {
            final Bitmap bitmapCreateBitmap = Bitmap.createBitmap(ImageReceiver.DEFAULT_CROSSFADE_DURATION, ImageReceiver.DEFAULT_CROSSFADE_DURATION, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            canvas.drawBitmap(bitmapHolder.bitmap, (Rect) null, new Rect(0, 0, ImageReceiver.DEFAULT_CROSSFADE_DURATION, ImageReceiver.DEFAULT_CROSSFADE_DURATION), new Paint(2));
            Utilities.blurBitmap(bitmapCreateBitmap, 3, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight(), bitmapCreateBitmap.getRowBytes());
            Palette paletteGenerate = Palette.from(bitmapHolder.bitmap).generate();
            Paint paint = new Paint();
            paint.setColor((paletteGenerate.getDarkMutedColor(-11242343) & 16777215) | 1140850688);
            canvas.drawColor(637534208);
            canvas.drawRect(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), paint);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.voip.VoIPOverlayBackground$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setBackground$0(bitmapCreateBitmap, bitmapHolder);
                }
            });
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setBackground$0(Bitmap bitmap, ImageReceiver.BitmapHolder bitmapHolder) {
        setImageBitmap(bitmap);
        bitmapHolder.release();
    }

    public void setShowBlackout(boolean z, boolean z2) {
        if (this.showBlackout == z) {
            return;
        }
        this.showBlackout = z;
        if (!z2) {
            this.blackoutProgress = z ? 1.0f : 0.0f;
            return;
        }
        float[] fArr = new float[2];
        fArr[0] = this.blackoutProgress;
        fArr[1] = z ? 1.0f : 0.0f;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.Components.voip.VoIPOverlayBackground$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.lambda$setShowBlackout$2(valueAnimator);
            }
        });
        valueAnimatorOfFloat.setDuration(150L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setShowBlackout$2(ValueAnimator valueAnimator) {
        this.blackoutProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }
}
