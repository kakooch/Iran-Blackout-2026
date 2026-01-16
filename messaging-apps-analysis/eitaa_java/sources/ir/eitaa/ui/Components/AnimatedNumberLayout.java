package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.Property;
import android.view.View;
import ir.eitaa.ui.Components.AnimationProperties;
import java.util.ArrayList;
import java.util.Locale;

/* loaded from: classes3.dex */
public class AnimatedNumberLayout {
    public static final Property<AnimatedNumberLayout, Float> PROGRESS = new AnimationProperties.FloatProperty<AnimatedNumberLayout>("progress") { // from class: ir.eitaa.ui.Components.AnimatedNumberLayout.1
        @Override // ir.eitaa.ui.Components.AnimationProperties.FloatProperty
        public void setValue(AnimatedNumberLayout object, float value) {
            object.setProgress(value);
        }

        @Override // android.util.Property
        public Float get(AnimatedNumberLayout object) {
            return Float.valueOf(object.progress);
        }
    };
    private ObjectAnimator animator;
    private final View parentView;
    private final TextPaint textPaint;
    private ArrayList<StaticLayout> letters = new ArrayList<>();
    private ArrayList<StaticLayout> oldLetters = new ArrayList<>();
    private float progress = 0.0f;
    private int currentNumber = 1;

    public AnimatedNumberLayout(View parent, TextPaint paint) {
        this.textPaint = paint;
        this.parentView = parent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgress(float value) {
        if (this.progress == value) {
            return;
        }
        this.progress = value;
        this.parentView.invalidate();
    }

    public int getWidth() {
        int size = this.letters.size();
        float lineWidth = 0.0f;
        for (int i = 0; i < size; i++) {
            lineWidth += this.letters.get(i).getLineWidth(0);
        }
        return (int) Math.ceil(lineWidth);
    }

    public void setNumber(int number, boolean animated) {
        if (this.currentNumber != number || this.letters.isEmpty()) {
            ObjectAnimator objectAnimator = this.animator;
            if (objectAnimator != null) {
                objectAnimator.cancel();
                this.animator = null;
            }
            this.oldLetters.clear();
            this.oldLetters.addAll(this.letters);
            this.letters.clear();
            Locale locale = Locale.US;
            String str = String.format(locale, "%d", Integer.valueOf(this.currentNumber));
            String str2 = String.format(locale, "%d", Integer.valueOf(number));
            boolean z = number > this.currentNumber;
            this.currentNumber = number;
            this.progress = 0.0f;
            int i = 0;
            while (i < str2.length()) {
                int i2 = i + 1;
                String strSubstring = str2.substring(i, i2);
                String strSubstring2 = (this.oldLetters.isEmpty() || i >= str.length()) ? null : str.substring(i, i2);
                if (strSubstring2 != null && strSubstring2.equals(strSubstring)) {
                    this.letters.add(this.oldLetters.get(i));
                    this.oldLetters.set(i, null);
                } else {
                    this.letters.add(new StaticLayout(strSubstring, this.textPaint, (int) Math.ceil(r12.measureText(strSubstring)), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false));
                }
                i = i2;
            }
            if (animated && !this.oldLetters.isEmpty()) {
                Property<AnimatedNumberLayout, Float> property = PROGRESS;
                float[] fArr = new float[2];
                fArr[0] = z ? -1.0f : 1.0f;
                fArr[1] = 0.0f;
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, property, fArr);
                this.animator = objectAnimatorOfFloat;
                objectAnimatorOfFloat.setDuration(150L);
                this.animator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.AnimatedNumberLayout.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        AnimatedNumberLayout.this.animator = null;
                        AnimatedNumberLayout.this.oldLetters.clear();
                    }
                });
                this.animator.start();
            }
            this.parentView.invalidate();
        }
    }

    public void draw(Canvas canvas) {
        if (this.letters.isEmpty()) {
            return;
        }
        float height = this.letters.get(0).getHeight();
        int iMax = Math.max(this.letters.size(), this.oldLetters.size());
        canvas.save();
        int alpha = this.textPaint.getAlpha();
        int i = 0;
        while (i < iMax) {
            canvas.save();
            StaticLayout staticLayout = i < this.oldLetters.size() ? this.oldLetters.get(i) : null;
            StaticLayout staticLayout2 = i < this.letters.size() ? this.letters.get(i) : null;
            float f = this.progress;
            if (f > 0.0f) {
                if (staticLayout != null) {
                    float f2 = alpha;
                    this.textPaint.setAlpha((int) (f * f2));
                    canvas.save();
                    canvas.translate(0.0f, (this.progress - 1.0f) * height);
                    staticLayout.draw(canvas);
                    canvas.restore();
                    if (staticLayout2 != null) {
                        this.textPaint.setAlpha((int) (f2 * (1.0f - this.progress)));
                        canvas.translate(0.0f, this.progress * height);
                    }
                } else {
                    this.textPaint.setAlpha(alpha);
                }
            } else if (f < 0.0f) {
                if (staticLayout != null) {
                    this.textPaint.setAlpha((int) (alpha * (-f)));
                    canvas.save();
                    canvas.translate(0.0f, (this.progress + 1.0f) * height);
                    staticLayout.draw(canvas);
                    canvas.restore();
                }
                if (staticLayout2 != null) {
                    if (i == iMax - 1 || staticLayout != null) {
                        this.textPaint.setAlpha((int) (alpha * (this.progress + 1.0f)));
                        canvas.translate(0.0f, this.progress * height);
                    } else {
                        this.textPaint.setAlpha(alpha);
                    }
                }
            } else if (staticLayout2 != null) {
                this.textPaint.setAlpha(alpha);
            }
            if (staticLayout2 != null) {
                staticLayout2.draw(canvas);
            }
            canvas.restore();
            canvas.translate(staticLayout2 != null ? staticLayout2.getLineWidth(0) : staticLayout.getLineWidth(0), 0.0f);
            i++;
        }
        canvas.restore();
    }
}
