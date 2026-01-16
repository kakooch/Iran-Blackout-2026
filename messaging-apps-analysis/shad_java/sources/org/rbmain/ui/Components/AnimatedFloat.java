package org.rbmain.ui.Components;

import android.animation.TimeInterpolator;
import android.os.SystemClock;
import android.view.View;
import androidx.core.math.MathUtils;
import org.rbmain.messenger.AndroidUtilities;

/* loaded from: classes5.dex */
public class AnimatedFloat {
    private boolean firstSet;
    private Runnable invalidate;
    private View parent;
    private float startValue;
    private float targetValue;
    private boolean transition;
    private long transitionDelay;
    private long transitionDuration;
    private TimeInterpolator transitionInterpolator;
    private long transitionStart;
    private float value;

    public AnimatedFloat(long j, TimeInterpolator timeInterpolator) {
        this.transitionDelay = 0L;
        this.transitionDuration = 200L;
        this.transitionInterpolator = CubicBezierInterpolator.DEFAULT;
        this.parent = null;
        this.transitionDuration = j;
        this.transitionInterpolator = timeInterpolator;
        this.firstSet = true;
    }

    public AnimatedFloat(long j, long j2, TimeInterpolator timeInterpolator) {
        this.transitionDelay = 0L;
        this.transitionDuration = 200L;
        this.transitionInterpolator = CubicBezierInterpolator.DEFAULT;
        this.parent = null;
        this.transitionDelay = j;
        this.transitionDuration = j2;
        this.transitionInterpolator = timeInterpolator;
        this.firstSet = true;
    }

    public AnimatedFloat(View view) {
        this.transitionDelay = 0L;
        this.transitionDuration = 200L;
        this.transitionInterpolator = CubicBezierInterpolator.DEFAULT;
        this.parent = view;
        this.firstSet = true;
    }

    public AnimatedFloat(View view, long j, TimeInterpolator timeInterpolator) {
        this.transitionDelay = 0L;
        this.transitionDuration = 200L;
        this.transitionInterpolator = CubicBezierInterpolator.DEFAULT;
        this.parent = view;
        this.transitionDuration = j;
        this.transitionInterpolator = timeInterpolator;
        this.firstSet = true;
    }

    public AnimatedFloat(View view, long j, long j2, TimeInterpolator timeInterpolator) {
        this.transitionDelay = 0L;
        this.transitionDuration = 200L;
        this.transitionInterpolator = CubicBezierInterpolator.DEFAULT;
        this.parent = view;
        this.transitionDelay = j;
        this.transitionDuration = j2;
        this.transitionInterpolator = timeInterpolator;
        this.firstSet = true;
    }

    public AnimatedFloat(float f, View view) {
        this.transitionDelay = 0L;
        this.transitionDuration = 200L;
        this.transitionInterpolator = CubicBezierInterpolator.DEFAULT;
        this.parent = view;
        this.targetValue = f;
        this.value = f;
        this.firstSet = false;
    }

    public AnimatedFloat(float f, View view, long j, long j2, TimeInterpolator timeInterpolator) {
        this.transitionDelay = 0L;
        this.transitionDuration = 200L;
        this.transitionInterpolator = CubicBezierInterpolator.DEFAULT;
        this.parent = view;
        this.targetValue = f;
        this.value = f;
        this.transitionDelay = j;
        this.transitionDuration = j2;
        this.transitionInterpolator = timeInterpolator;
        this.firstSet = false;
    }

    public AnimatedFloat(float f, Runnable runnable, long j, long j2, TimeInterpolator timeInterpolator) {
        this.transitionDelay = 0L;
        this.transitionDuration = 200L;
        this.transitionInterpolator = CubicBezierInterpolator.DEFAULT;
        this.invalidate = runnable;
        this.targetValue = f;
        this.value = f;
        this.transitionDelay = j;
        this.transitionDuration = j2;
        this.transitionInterpolator = timeInterpolator;
        this.firstSet = false;
    }

    public float get() {
        return this.value;
    }

    public float set(float f) {
        return set(f, false);
    }

    public float set(float f, boolean z) {
        if (z || this.transitionDuration <= 0 || this.firstSet) {
            this.targetValue = f;
            this.value = f;
            this.transition = false;
            this.firstSet = false;
        } else if (Math.abs(this.targetValue - f) > 1.0E-4f) {
            this.transition = true;
            this.targetValue = f;
            this.startValue = this.value;
            this.transitionStart = SystemClock.elapsedRealtime();
        }
        if (this.transition) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            float fClamp = MathUtils.clamp(((jElapsedRealtime - this.transitionStart) - this.transitionDelay) / this.transitionDuration, 0.0f, 1.0f);
            if (jElapsedRealtime - this.transitionStart >= this.transitionDelay) {
                TimeInterpolator timeInterpolator = this.transitionInterpolator;
                if (timeInterpolator == null) {
                    this.value = AndroidUtilities.lerp(this.startValue, this.targetValue, fClamp);
                } else {
                    this.value = AndroidUtilities.lerp(this.startValue, this.targetValue, timeInterpolator.getInterpolation(fClamp));
                }
            }
            if (fClamp >= 1.0f) {
                this.transition = false;
            } else {
                View view = this.parent;
                if (view != null) {
                    view.invalidate();
                }
                Runnable runnable = this.invalidate;
                if (runnable != null) {
                    runnable.run();
                }
            }
        }
        return this.value;
    }

    public void setParent(View view) {
        this.parent = view;
    }
}
