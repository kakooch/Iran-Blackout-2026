package ir.eitaa.ui.Components.voip;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.R;
import ir.eitaa.ui.Components.CubicBezierInterpolator;
import ir.eitaa.ui.Components.EllipsizeSpanAnimator;
import ir.eitaa.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class VoIPStatusTextView extends FrameLayout {
    boolean animationInProgress;
    ValueAnimator animator;
    private boolean attachedToWindow;
    EllipsizeSpanAnimator ellipsizeAnimator;
    CharSequence nextTextToSet;
    TextView reconnectTextView;
    TextView[] textView;
    boolean timerShowing;
    VoIPTimerView timerView;

    public VoIPStatusTextView(Context context) {
        super(context);
        this.textView = new TextView[2];
        for (int i = 0; i < 2; i++) {
            this.textView[i] = new TextView(context);
            this.textView[i].setTextSize(1, 15.0f);
            this.textView[i].setTypeface(AndroidUtilities.getFontFamily(false));
            this.textView[i].setShadowLayer(AndroidUtilities.dp(3.0f), 0.0f, AndroidUtilities.dp(0.6666667f), 1275068416);
            this.textView[i].setTextColor(-1);
            this.textView[i].setGravity(1);
            addView(this.textView[i]);
        }
        TextView textView = new TextView(context);
        this.reconnectTextView = textView;
        textView.setTextSize(1, 15.0f);
        this.reconnectTextView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.reconnectTextView.setShadowLayer(AndroidUtilities.dp(3.0f), 0.0f, AndroidUtilities.dp(0.6666667f), 1275068416);
        this.reconnectTextView.setTextColor(-1);
        this.reconnectTextView.setGravity(1);
        addView(this.reconnectTextView, LayoutHelper.createFrame(-1, -2.0f, 0, 0.0f, 22.0f, 0.0f, 0.0f));
        this.ellipsizeAnimator = new EllipsizeSpanAnimator(this);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(LocaleController.getString("VoipReconnecting", R.string.VoipReconnecting));
        SpannableString spannableString = new SpannableString("...");
        this.ellipsizeAnimator.wrap(spannableString, 0);
        spannableStringBuilder.append((CharSequence) spannableString);
        this.reconnectTextView.setText(spannableStringBuilder);
        this.reconnectTextView.setVisibility(8);
        VoIPTimerView voIPTimerView = new VoIPTimerView(context);
        this.timerView = voIPTimerView;
        addView(voIPTimerView, LayoutHelper.createFrame(-1, -2.0f));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setText(String text, boolean ellipsis, boolean animated) {
        if (ellipsis) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(text);
            this.ellipsizeAnimator.reset();
            SpannableString spannableString = new SpannableString("...");
            this.ellipsizeAnimator.wrap(spannableString, 0);
            spannableStringBuilder.append((CharSequence) spannableString);
            this.ellipsizeAnimator.addView(this.textView[0]);
            this.ellipsizeAnimator.addView(this.textView[1]);
            text = spannableStringBuilder;
        } else {
            this.ellipsizeAnimator.removeView(this.textView[0]);
            this.ellipsizeAnimator.removeView(this.textView[1]);
        }
        if (TextUtils.isEmpty(this.textView[0].getText())) {
            animated = false;
        }
        if (!animated) {
            ValueAnimator valueAnimator = this.animator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            this.animationInProgress = false;
            this.textView[0].setText(text);
            this.textView[0].setVisibility(0);
            this.textView[1].setVisibility(8);
            this.timerView.setVisibility(8);
            return;
        }
        if (this.animationInProgress) {
            this.nextTextToSet = text;
            return;
        }
        if (this.timerShowing) {
            this.textView[0].setText(text);
            replaceViews(this.timerView, this.textView[0], null);
        } else {
            if (this.textView[0].getText().equals(text)) {
                return;
            }
            this.textView[1].setText(text);
            TextView[] textViewArr = this.textView;
            replaceViews(textViewArr[0], textViewArr[1], new Runnable() { // from class: ir.eitaa.ui.Components.voip.-$$Lambda$VoIPStatusTextView$7YL1-nMSE21IudXRVh7dwTBkcuA
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setText$0$VoIPStatusTextView();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setText$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setText$0$VoIPStatusTextView() {
        TextView[] textViewArr = this.textView;
        TextView textView = textViewArr[0];
        textViewArr[0] = textViewArr[1];
        textViewArr[1] = textView;
    }

    public void showTimer(boolean animated) {
        if (TextUtils.isEmpty(this.textView[0].getText())) {
            animated = false;
        }
        if (this.timerShowing) {
            return;
        }
        this.timerView.updateTimer();
        if (!animated) {
            ValueAnimator valueAnimator = this.animator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            this.timerShowing = true;
            this.animationInProgress = false;
            this.textView[0].setVisibility(8);
            this.textView[1].setVisibility(8);
            this.timerView.setVisibility(0);
        } else if (this.animationInProgress) {
            this.nextTextToSet = "timer";
            return;
        } else {
            this.timerShowing = true;
            replaceViews(this.textView[0], this.timerView, null);
        }
        this.ellipsizeAnimator.removeView(this.textView[0]);
        this.ellipsizeAnimator.removeView(this.textView[1]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void replaceViews(final View out, final View in, Runnable onEnd) {
        out.setVisibility(0);
        in.setVisibility(0);
        in.setTranslationY(AndroidUtilities.dp(15.0f));
        in.setAlpha(0.0f);
        this.animationInProgress = true;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.animator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.voip.-$$Lambda$VoIPStatusTextView$vqEVG5NB4Cu7NLU0QvyYSX0XxB4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                VoIPStatusTextView.lambda$replaceViews$1(in, out, valueAnimator);
            }
        });
        this.animator.addListener(new AnonymousClass1(out, in, onEnd));
        this.animator.setDuration(250L).setInterpolator(CubicBezierInterpolator.DEFAULT);
        this.animator.start();
    }

    static /* synthetic */ void lambda$replaceViews$1(View view, View view2, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        float f = (fFloatValue * 0.6f) + 0.4f;
        float f2 = 1.0f - fFloatValue;
        float f3 = (0.6f * f2) + 0.4f;
        view.setTranslationY(AndroidUtilities.dp(10.0f) * f2);
        view.setAlpha(fFloatValue);
        view.setScaleX(f);
        view.setScaleY(f);
        view2.setTranslationY((-AndroidUtilities.dp(10.0f)) * fFloatValue);
        view2.setAlpha(f2);
        view2.setScaleX(f3);
        view2.setScaleY(f3);
    }

    /* renamed from: ir.eitaa.ui.Components.voip.VoIPStatusTextView$1, reason: invalid class name */
    class AnonymousClass1 extends AnimatorListenerAdapter {
        final /* synthetic */ View val$in;
        final /* synthetic */ Runnable val$onEnd;
        final /* synthetic */ View val$out;

        AnonymousClass1(final View val$out, final View val$in, final Runnable val$onEnd) {
            this.val$out = val$out;
            this.val$in = val$in;
            this.val$onEnd = val$onEnd;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            this.val$out.setVisibility(8);
            this.val$out.setAlpha(1.0f);
            this.val$out.setTranslationY(0.0f);
            this.val$out.setScaleY(1.0f);
            this.val$out.setScaleX(1.0f);
            this.val$in.setAlpha(1.0f);
            this.val$in.setTranslationY(0.0f);
            this.val$in.setVisibility(0);
            this.val$in.setScaleY(1.0f);
            this.val$in.setScaleX(1.0f);
            Runnable runnable = this.val$onEnd;
            if (runnable != null) {
                runnable.run();
            }
            VoIPStatusTextView voIPStatusTextView = VoIPStatusTextView.this;
            voIPStatusTextView.animationInProgress = false;
            CharSequence charSequence = voIPStatusTextView.nextTextToSet;
            if (charSequence != null) {
                if (charSequence.equals("timer")) {
                    VoIPStatusTextView.this.showTimer(true);
                } else {
                    VoIPStatusTextView voIPStatusTextView2 = VoIPStatusTextView.this;
                    voIPStatusTextView2.textView[1].setText(voIPStatusTextView2.nextTextToSet);
                    VoIPStatusTextView voIPStatusTextView3 = VoIPStatusTextView.this;
                    TextView[] textViewArr = voIPStatusTextView3.textView;
                    voIPStatusTextView3.replaceViews(textViewArr[0], textViewArr[1], new Runnable() { // from class: ir.eitaa.ui.Components.voip.-$$Lambda$VoIPStatusTextView$1$T4WH8NvMuV3Y0l_f0kEyl4RIbks
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onAnimationEnd$0$VoIPStatusTextView$1();
                        }
                    });
                }
                VoIPStatusTextView.this.nextTextToSet = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onAnimationEnd$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onAnimationEnd$0$VoIPStatusTextView$1() {
            TextView[] textViewArr = VoIPStatusTextView.this.textView;
            TextView textView = textViewArr[0];
            textViewArr[0] = textViewArr[1];
            textViewArr[1] = textView;
        }
    }

    public void setSignalBarCount(int count) {
        this.timerView.setSignalBarCount(count);
    }

    public void showReconnect(boolean showReconnecting, boolean animated) {
        if (!animated) {
            this.reconnectTextView.animate().setListener(null).cancel();
            this.reconnectTextView.setVisibility(showReconnecting ? 0 : 8);
        } else if (showReconnecting) {
            if (this.reconnectTextView.getVisibility() != 0) {
                this.reconnectTextView.setVisibility(0);
                this.reconnectTextView.setAlpha(0.0f);
            }
            this.reconnectTextView.animate().setListener(null).cancel();
            this.reconnectTextView.animate().alpha(1.0f).setDuration(150L).start();
        } else {
            this.reconnectTextView.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.voip.VoIPStatusTextView.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    VoIPStatusTextView.this.reconnectTextView.setVisibility(8);
                }
            }).setDuration(150L).start();
        }
        if (showReconnecting) {
            this.ellipsizeAnimator.addView(this.reconnectTextView);
        } else {
            this.ellipsizeAnimator.removeView(this.reconnectTextView);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.attachedToWindow = true;
        this.ellipsizeAnimator.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.attachedToWindow = false;
        this.ellipsizeAnimator.onDetachedFromWindow();
    }
}
