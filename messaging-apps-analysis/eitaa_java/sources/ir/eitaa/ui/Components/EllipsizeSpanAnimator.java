package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.view.View;
import ir.eitaa.messenger.ImageReceiver;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class EllipsizeSpanAnimator {
    boolean attachedToWindow;
    private final AnimatorSet ellAnimator;
    private final TextAlphaSpan[] ellSpans;
    public ArrayList<View> ellipsizedViews;

    public EllipsizeSpanAnimator(final View parentView) {
        TextAlphaSpan[] textAlphaSpanArr = {new TextAlphaSpan(), new TextAlphaSpan(), new TextAlphaSpan()};
        this.ellSpans = textAlphaSpanArr;
        this.ellipsizedViews = new ArrayList<>();
        AnimatorSet animatorSet = new AnimatorSet();
        this.ellAnimator = animatorSet;
        animatorSet.playTogether(createEllipsizeAnimator(textAlphaSpanArr[0], 0, 255, 0, 300), createEllipsizeAnimator(textAlphaSpanArr[1], 0, 255, ImageReceiver.DEFAULT_CROSSFADE_DURATION, 300), createEllipsizeAnimator(textAlphaSpanArr[2], 0, 255, 300, 300), createEllipsizeAnimator(textAlphaSpanArr[0], 255, 0, 1000, 400), createEllipsizeAnimator(textAlphaSpanArr[1], 255, 0, 1000, 400), createEllipsizeAnimator(textAlphaSpanArr[2], 255, 0, 1000, 400));
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.EllipsizeSpanAnimator.1
            private Runnable restarter = new Runnable() { // from class: ir.eitaa.ui.Components.EllipsizeSpanAnimator.1.1
                @Override // java.lang.Runnable
                public void run() {
                    EllipsizeSpanAnimator ellipsizeSpanAnimator = EllipsizeSpanAnimator.this;
                    if (!ellipsizeSpanAnimator.attachedToWindow || ellipsizeSpanAnimator.ellipsizedViews.isEmpty() || EllipsizeSpanAnimator.this.ellAnimator.isRunning()) {
                        return;
                    }
                    try {
                        EllipsizeSpanAnimator.this.ellAnimator.start();
                    } catch (Exception unused) {
                    }
                }
            };

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                if (EllipsizeSpanAnimator.this.attachedToWindow) {
                    parentView.postDelayed(this.restarter, 300L);
                }
            }
        });
    }

    public void wrap(SpannableString string, int start) {
        int i = start + 1;
        string.setSpan(this.ellSpans[0], start, i, 0);
        int i2 = start + 2;
        string.setSpan(this.ellSpans[1], i, i2, 0);
        string.setSpan(this.ellSpans[2], i2, start + 3, 0);
    }

    public void onAttachedToWindow() {
        this.attachedToWindow = true;
        if (this.ellAnimator.isRunning()) {
            return;
        }
        this.ellAnimator.start();
    }

    public void onDetachedFromWindow() {
        this.attachedToWindow = false;
        this.ellAnimator.cancel();
    }

    public void reset() {
        for (TextAlphaSpan textAlphaSpan : this.ellSpans) {
            textAlphaSpan.setAlpha(0);
        }
    }

    private Animator createEllipsizeAnimator(final TextAlphaSpan target, int startVal, int endVal, int startDelay, int duration) {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(startVal, endVal);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$EllipsizeSpanAnimator$a93Enz9DypjUqAFKMASqQAdg4rM
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.lambda$createEllipsizeAnimator$0$EllipsizeSpanAnimator(target, valueAnimator);
            }
        });
        valueAnimatorOfInt.setDuration(duration);
        valueAnimatorOfInt.setStartDelay(startDelay);
        valueAnimatorOfInt.setInterpolator(CubicBezierInterpolator.DEFAULT);
        return valueAnimatorOfInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createEllipsizeAnimator$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createEllipsizeAnimator$0$EllipsizeSpanAnimator(TextAlphaSpan textAlphaSpan, ValueAnimator valueAnimator) {
        textAlphaSpan.setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
        for (int i = 0; i < this.ellipsizedViews.size(); i++) {
            this.ellipsizedViews.get(i).invalidate();
        }
    }

    public void addView(View view) {
        if (this.ellipsizedViews.isEmpty()) {
            this.ellAnimator.start();
        }
        if (this.ellipsizedViews.contains(view)) {
            return;
        }
        this.ellipsizedViews.add(view);
    }

    public void removeView(View view) {
        this.ellipsizedViews.remove(view);
        if (this.ellipsizedViews.isEmpty()) {
            this.ellAnimator.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class TextAlphaSpan extends CharacterStyle {
        private int alpha = 0;

        public void setAlpha(int alpha) {
            this.alpha = alpha;
        }

        @Override // android.text.style.CharacterStyle
        public void updateDrawState(TextPaint tp) {
            tp.setAlpha(this.alpha);
        }
    }
}
