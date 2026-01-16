package ir.appp.rghapp.rubinoPostSlider;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import ir.medu.shad.R;

/* loaded from: classes3.dex */
public class PhotoViewerHeartView extends View {
    long animationStartTime;
    DecelerateInterpolator decelerateInterpolator;
    Drawable drawable;
    Rect drawableBound;
    boolean isAnimating;
    RubinoLikeInterpolator overshootInterpolator;
    float scale;

    public PhotoViewerHeartView(Context context) {
        super(context);
        this.scale = 1.0f;
        this.isAnimating = false;
        init(context);
    }

    private void init(Context context) {
        this.overshootInterpolator = new RubinoLikeInterpolator();
        this.decelerateInterpolator = new DecelerateInterpolator();
        this.drawable = context.getResources().getDrawable(R.drawable.rubino_big_like).mutate();
        this.drawableBound = new Rect(0, 0, 0, 0);
    }

    public void showHeart() {
        this.animationStartTime = System.currentTimeMillis();
        this.isAnimating = true;
        setAlpha(0.5f);
        updateAnimationStatus();
    }

    public void stopAnimating() {
        if (this.isAnimating) {
            this.isAnimating = false;
            setAlpha(0.0f);
            this.scale = 0.0f;
        }
    }

    private void updateAnimationStatus() {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.animationStartTime;
        if (jCurrentTimeMillis < 500) {
            float f = jCurrentTimeMillis / 500.0f;
            this.scale = this.overshootInterpolator.getInterpolation(f);
            if (getAlpha() < 1.0f) {
                setAlpha(f + 0.5f);
            }
        } else if (jCurrentTimeMillis < 800) {
            this.scale = 1.0f;
        } else if (jCurrentTimeMillis < 950) {
            float f2 = 1.0f - ((jCurrentTimeMillis - 800) / 150.0f);
            this.scale = this.decelerateInterpolator.getInterpolation(f2);
            setAlpha(f2);
        } else {
            this.isAnimating = false;
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.drawableBound.right = View.MeasureSpec.getSize(i);
        this.drawableBound.bottom = View.MeasureSpec.getSize(i2);
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.drawable == null || !this.isAnimating) {
            return;
        }
        float f = this.scale;
        canvas.scale(f, f, getWidth() / 2, getHeight() / 2);
        this.drawable.setBounds(this.drawableBound);
        this.drawable.draw(canvas);
        updateAnimationStatus();
    }
}
