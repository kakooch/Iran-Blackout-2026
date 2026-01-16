package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class FadingTextViewLayout extends FrameLayout {
    private final ValueAnimator animator;
    private TextView currentView;
    private TextView foregroundView;
    private TextView nextView;
    private CharSequence text;

    protected int getStaticCharsCount() {
        return 0;
    }

    public FadingTextViewLayout(Context context) {
        this(context, false);
    }

    public FadingTextViewLayout(Context context, boolean z) {
        super(context);
        for (int i = 0; i < (z ? 1 : 0) + 2; i++) {
            TextView textView = new TextView(context);
            onTextViewCreated(textView);
            addView(textView);
            if (i == 0) {
                this.currentView = textView;
            } else {
                textView.setVisibility(8);
                if (i == 1) {
                    textView.setAlpha(0.0f);
                    this.nextView = textView;
                } else {
                    this.foregroundView = textView;
                }
            }
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.animator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(200L);
        valueAnimatorOfFloat.setInterpolator(null);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$FadingTextViewLayout$IXeFxhaPxi-j8syUHi_WTrrvL1c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.lambda$new$0$FadingTextViewLayout(valueAnimator);
            }
        });
        valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.FadingTextViewLayout.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                FadingTextViewLayout.this.currentView.setLayerType(0, null);
                FadingTextViewLayout.this.nextView.setLayerType(0, null);
                FadingTextViewLayout.this.nextView.setVisibility(8);
                if (FadingTextViewLayout.this.foregroundView != null) {
                    FadingTextViewLayout.this.currentView.setText(FadingTextViewLayout.this.text);
                    FadingTextViewLayout.this.foregroundView.setVisibility(8);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                FadingTextViewLayout.this.currentView.setLayerType(2, null);
                FadingTextViewLayout.this.nextView.setLayerType(2, null);
                if (ViewCompat.isAttachedToWindow(FadingTextViewLayout.this.currentView)) {
                    FadingTextViewLayout.this.currentView.buildLayer();
                }
                if (ViewCompat.isAttachedToWindow(FadingTextViewLayout.this.nextView)) {
                    FadingTextViewLayout.this.nextView.buildLayer();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$FadingTextViewLayout(ValueAnimator valueAnimator) {
        float animatedFraction = valueAnimator.getAnimatedFraction();
        TextView textView = this.currentView;
        CubicBezierInterpolator cubicBezierInterpolator = CubicBezierInterpolator.DEFAULT;
        textView.setAlpha(cubicBezierInterpolator.getInterpolation(animatedFraction));
        this.nextView.setAlpha(cubicBezierInterpolator.getInterpolation(1.0f - animatedFraction));
    }

    public void setText(CharSequence text) {
        setText(text, true, true);
    }

    public void setText(CharSequence text, boolean animated) {
        setText(text, animated, true);
    }

    public void setText(CharSequence text, boolean animated, boolean dontAnimateUnchangedStaticChars) {
        int staticCharsCount;
        if (TextUtils.equals(text, this.currentView.getText())) {
            return;
        }
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.end();
        }
        this.text = text;
        if (animated) {
            if (dontAnimateUnchangedStaticChars && this.foregroundView != null && (staticCharsCount = getStaticCharsCount()) > 0) {
                CharSequence text2 = this.currentView.getText();
                int iMin = Math.min(staticCharsCount, Math.min(text.length(), text2.length()));
                ArrayList arrayList = new ArrayList();
                int i = -1;
                for (int i2 = 0; i2 < iMin; i2++) {
                    if (text.charAt(i2) == text2.charAt(i2)) {
                        if (i >= 0) {
                            arrayList.add(new android.graphics.Point(i, i2));
                            i = -1;
                        }
                    } else if (i == -1) {
                        i = i2;
                    }
                }
                if (i != 0) {
                    if (i > 0) {
                        arrayList.add(new android.graphics.Point(i, iMin));
                    } else {
                        arrayList.add(new android.graphics.Point(iMin, 0));
                    }
                }
                if (!arrayList.isEmpty()) {
                    SpannableString spannableString = new SpannableString(text.subSequence(0, iMin));
                    SpannableString spannableString2 = new SpannableString(text2);
                    SpannableString spannableString3 = new SpannableString(text);
                    int size = arrayList.size();
                    int i3 = 0;
                    for (int i4 = 0; i4 < size; i4++) {
                        android.graphics.Point point = (android.graphics.Point) arrayList.get(i4);
                        if (point.y > point.x) {
                            spannableString.setSpan(new ForegroundColorSpan(0), point.x, point.y, 17);
                        }
                        if (point.x > i3) {
                            spannableString2.setSpan(new ForegroundColorSpan(0), i3, point.x, 17);
                            spannableString3.setSpan(new ForegroundColorSpan(0), i3, point.x, 17);
                        }
                        i3 = point.y;
                    }
                    this.foregroundView.setVisibility(0);
                    this.foregroundView.setText(spannableString);
                    this.currentView.setText(spannableString2);
                    text = spannableString3;
                }
            }
            this.nextView.setVisibility(0);
            this.nextView.setText(text);
            showNext();
            return;
        }
        this.currentView.setText(text);
    }

    public CharSequence getText() {
        return this.text;
    }

    public TextView getCurrentView() {
        return this.currentView;
    }

    public TextView getNextView() {
        return this.nextView;
    }

    private void showNext() {
        TextView textView = this.currentView;
        this.currentView = this.nextView;
        this.nextView = textView;
        this.animator.start();
    }

    protected void onTextViewCreated(TextView textView) {
        textView.setSingleLine(true);
        textView.setMaxLines(1);
    }
}
