package ir.resaneh1.iptv.helper;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import ir.medu.shad.R;
import ir.resaneh1.iptv.logger.MyLog;

/* loaded from: classes3.dex */
final class StoryProgressBar extends FrameLayout {
    public PausableScaleAnimation animation;
    private Callback callback;
    private long duration;
    private View frontProgressView;

    interface Callback {
        void onFinishProgress(boolean z);

        void onStartProgress();
    }

    public StoryProgressBar(Context context) {
        this(context, null);
    }

    public StoryProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StoryProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.duration = 2000L;
        LayoutInflater.from(context).inflate(R.layout.story_progress_view, this);
        this.frontProgressView = findViewById(R.id.front_progress);
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    void setMinWithoutCallback() {
        PausableScaleAnimation pausableScaleAnimation = this.animation;
        if (pausableScaleAnimation != null) {
            pausableScaleAnimation.setAnimationListener(null);
            this.animation.cancel();
        }
        this.frontProgressView.setVisibility(8);
    }

    void setMaxWithoutCallback() {
        PausableScaleAnimation pausableScaleAnimation = this.animation;
        if (pausableScaleAnimation != null) {
            pausableScaleAnimation.setAnimationListener(null);
            this.animation.cancel();
        }
        this.frontProgressView.setVisibility(0);
        this.frontProgressView.setScaleX(1.0f);
    }

    public void startProgress(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        }
        this.frontProgressView.setVisibility(0);
        PausableScaleAnimation pausableScaleAnimation = this.animation;
        if (pausableScaleAnimation != null) {
            pausableScaleAnimation.setAnimationListener(null);
            this.animation.cancel();
        }
        PausableScaleAnimation pausableScaleAnimation2 = new PausableScaleAnimation(this, f, 1.0f, 1.0f, 1.0f, 1, 1.0f, 1, 0.0f);
        this.animation = pausableScaleAnimation2;
        pausableScaleAnimation2.setDuration((long) (this.duration * (1.0f - f)));
        this.animation.setInterpolator(new LinearInterpolator());
        this.animation.setAnimationListener(new Animation.AnimationListener() { // from class: ir.resaneh1.iptv.helper.StoryProgressBar.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                PausableScaleAnimation pausableScaleAnimation3 = StoryProgressBar.this.animation;
                if (pausableScaleAnimation3 == null || !pausableScaleAnimation3.equals(animation) || StoryProgressBar.this.callback == null) {
                    return;
                }
                StoryProgressBar.this.callback.onStartProgress();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PausableScaleAnimation pausableScaleAnimation3 = StoryProgressBar.this.animation;
                if (pausableScaleAnimation3 == null || !pausableScaleAnimation3.equals(animation)) {
                    return;
                }
                StoryProgressBar.this.animation.setAnimationListener(null);
                if (StoryProgressBar.this.callback != null) {
                    StoryProgressBar.this.callback.onFinishProgress(false);
                }
            }
        });
        this.animation.setRepeatCount(0);
        this.frontProgressView.startAnimation(this.animation);
    }

    public void pauseProgress() {
        PausableScaleAnimation pausableScaleAnimation = this.animation;
        if (pausableScaleAnimation != null) {
            pausableScaleAnimation.pause();
            this.frontProgressView.setVisibility(8);
            MyLog.e("StoryProgressBar", " pause ");
        }
    }

    public void resumeProgress() {
        if (this.animation != null) {
            this.frontProgressView.setVisibility(0);
            this.animation.resume();
            MyLog.e("StoryProgressBar", " resume ");
        }
    }

    void clear() {
        PausableScaleAnimation pausableScaleAnimation = this.animation;
        if (pausableScaleAnimation != null) {
            pausableScaleAnimation.setAnimationListener(null);
            this.animation.cancel();
            this.animation = null;
        }
        this.callback = null;
    }

    public class PausableScaleAnimation extends ScaleAnimation {
        private long mElapsedAtPause;
        private boolean mPaused;

        PausableScaleAnimation(StoryProgressBar storyProgressBar, float f, float f2, float f3, float f4, int i, float f5, int i2, float f6) {
            super(f, f2, f3, f4, i, f5, i2, f6);
            this.mElapsedAtPause = 0L;
            this.mPaused = false;
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation, float f) {
            if (this.mPaused && this.mElapsedAtPause == 0) {
                this.mElapsedAtPause = j - getStartTime();
            }
            if (this.mPaused) {
                setStartTime(j - this.mElapsedAtPause);
            }
            return super.getTransformation(j, transformation, f);
        }

        void pause() {
            if (this.mPaused) {
                return;
            }
            this.mElapsedAtPause = 0L;
            this.mPaused = true;
        }

        void resume() {
            this.mPaused = false;
        }
    }
}
