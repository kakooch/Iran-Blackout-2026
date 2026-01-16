package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.SystemClock;
import android.os.Vibrator;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.Property;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import androidx.core.os.CancellationSignal;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.messenger.support.fingerprint.FingerprintManagerCompat;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.Theme;
import java.util.ArrayList;
import java.util.Locale;

/* loaded from: classes3.dex */
public class PasscodeView extends FrameLayout {
    private static int badPasscodeTries = 0;
    private static final int[] ids = {R.id.passcode_btn_0, R.id.passcode_btn_1, R.id.passcode_btn_2, R.id.passcode_btn_3, R.id.passcode_btn_4, R.id.passcode_btn_5, R.id.passcode_btn_6, R.id.passcode_btn_7, R.id.passcode_btn_8, R.id.passcode_btn_9, R.id.passcode_btn_backspace, R.id.passcode_btn_fingerprint};
    private static long lastUptimeMillis = 0;
    private static long passcodeRetryInMs = 0;
    private static int passcodeType = 0;
    private static boolean useFingerprint = true;
    private ImageView backButton;
    private Drawable backgroundDrawable;
    private FrameLayout backgroundFrameLayout;
    private CancellationSignal cancellationSignal;
    private ImageView checkImage;
    private Runnable checkRunnable;
    private PasscodeViewDelegate delegate;
    private ImageView eraseView;
    private AlertDialog fingerprintDialog;
    private ImageView fingerprintImage;
    private ImageView fingerprintImageView;
    private TextView fingerprintStatusTextView;
    private ImageView fingerprintView;
    private RLottieImageView imageView;
    private int imageY;
    private ArrayList<InnerAnimator> innerAnimators;
    public boolean isChatLock;
    private int keyboardHeight;
    private int lastValue;
    private ArrayList<TextView> lettersTextViews;
    private ArrayList<FrameLayout> numberFrameLayouts;
    private ArrayList<TextView> numberTextViews;
    private FrameLayout numbersFrameLayout;
    private TextView passcodeTextView;
    private EditTextBoldCursor passwordEditText;
    private AnimatingTextView passwordEditText2;
    private FrameLayout passwordFrameLayout;
    private int[] pos;
    private android.graphics.Rect rect;
    private TextView retryTextView;
    private boolean selfCancelled;

    public interface PasscodeViewDelegate {
        void didAcceptedPassword();

        void onFinish();
    }

    static /* synthetic */ boolean lambda$onShow$8(View view, MotionEvent motionEvent) {
        return true;
    }

    private static class AnimatingTextView extends FrameLayout {
        private ArrayList<TextView> characterTextViews;
        private AnimatorSet currentAnimation;
        private Runnable dotRunnable;
        private ArrayList<TextView> dotTextViews;
        private StringBuilder stringBuilder;

        public AnimatingTextView(Context context) {
            super(context);
            this.characterTextViews = new ArrayList<>(4);
            this.dotTextViews = new ArrayList<>(4);
            this.stringBuilder = new StringBuilder(4);
            for (int i = 0; i < 4; i++) {
                TextView textView = new TextView(context);
                textView.setTextColor(-1);
                textView.setTextSize(1, 36.0f);
                textView.setTypeface(AndroidUtilities.getFontFamily(false));
                textView.setGravity(17);
                textView.setAlpha(0.0f);
                textView.setPivotX(AndroidUtilities.dp(25.0f));
                textView.setPivotY(AndroidUtilities.dp(25.0f));
                addView(textView, LayoutHelper.createFrame(50, 50, 51));
                this.characterTextViews.add(textView);
                TextView textView2 = new TextView(context);
                textView2.setTextColor(-1);
                textView2.setTextSize(1, 36.0f);
                textView2.setTypeface(AndroidUtilities.getFontFamily(false));
                textView2.setGravity(17);
                textView2.setAlpha(0.0f);
                textView2.setText("•");
                textView2.setPivotX(AndroidUtilities.dp(25.0f));
                textView2.setPivotY(AndroidUtilities.dp(25.0f));
                addView(textView2, LayoutHelper.createFrame(50, 50, 51));
                this.dotTextViews.add(textView2);
            }
        }

        private int getXForTextView(int pos) {
            return (((getMeasuredWidth() - (this.stringBuilder.length() * AndroidUtilities.dp(30.0f))) / 2) + (pos * AndroidUtilities.dp(30.0f))) - AndroidUtilities.dp(10.0f);
        }

        public void appendCharacter(String c) {
            if (this.stringBuilder.length() == 4) {
                return;
            }
            try {
                performHapticFeedback(3);
            } catch (Exception e) {
                FileLog.e(e);
            }
            ArrayList arrayList = new ArrayList();
            final int length = this.stringBuilder.length();
            this.stringBuilder.append(c);
            TextView textView = this.characterTextViews.get(length);
            textView.setText(c);
            textView.setTranslationX(getXForTextView(length));
            arrayList.add(ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.SCALE_X, 0.0f, 1.0f));
            arrayList.add(ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.SCALE_Y, 0.0f, 1.0f));
            arrayList.add(ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.ALPHA, 0.0f, 1.0f));
            arrayList.add(ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.TRANSLATION_Y, AndroidUtilities.dp(20.0f), 0.0f));
            TextView textView2 = this.dotTextViews.get(length);
            textView2.setTranslationX(getXForTextView(length));
            textView2.setAlpha(0.0f);
            arrayList.add(ObjectAnimator.ofFloat(textView2, (Property<TextView, Float>) View.SCALE_X, 0.0f, 1.0f));
            arrayList.add(ObjectAnimator.ofFloat(textView2, (Property<TextView, Float>) View.SCALE_Y, 0.0f, 1.0f));
            arrayList.add(ObjectAnimator.ofFloat(textView2, (Property<TextView, Float>) View.TRANSLATION_Y, AndroidUtilities.dp(20.0f), 0.0f));
            for (int i = length + 1; i < 4; i++) {
                TextView textView3 = this.characterTextViews.get(i);
                if (textView3.getAlpha() != 0.0f) {
                    arrayList.add(ObjectAnimator.ofFloat(textView3, (Property<TextView, Float>) View.SCALE_X, 0.0f));
                    arrayList.add(ObjectAnimator.ofFloat(textView3, (Property<TextView, Float>) View.SCALE_Y, 0.0f));
                    arrayList.add(ObjectAnimator.ofFloat(textView3, (Property<TextView, Float>) View.ALPHA, 0.0f));
                }
                TextView textView4 = this.dotTextViews.get(i);
                if (textView4.getAlpha() != 0.0f) {
                    arrayList.add(ObjectAnimator.ofFloat(textView4, (Property<TextView, Float>) View.SCALE_X, 0.0f));
                    arrayList.add(ObjectAnimator.ofFloat(textView4, (Property<TextView, Float>) View.SCALE_Y, 0.0f));
                    arrayList.add(ObjectAnimator.ofFloat(textView4, (Property<TextView, Float>) View.ALPHA, 0.0f));
                }
            }
            Runnable runnable = this.dotRunnable;
            if (runnable != null) {
                AndroidUtilities.cancelRunOnUIThread(runnable);
            }
            Runnable runnable2 = new Runnable() { // from class: ir.eitaa.ui.Components.PasscodeView.AnimatingTextView.1
                @Override // java.lang.Runnable
                public void run() {
                    if (AnimatingTextView.this.dotRunnable != this) {
                        return;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    TextView textView5 = (TextView) AnimatingTextView.this.characterTextViews.get(length);
                    arrayList2.add(ObjectAnimator.ofFloat(textView5, (Property<TextView, Float>) View.SCALE_X, 0.0f));
                    arrayList2.add(ObjectAnimator.ofFloat(textView5, (Property<TextView, Float>) View.SCALE_Y, 0.0f));
                    arrayList2.add(ObjectAnimator.ofFloat(textView5, (Property<TextView, Float>) View.ALPHA, 0.0f));
                    TextView textView6 = (TextView) AnimatingTextView.this.dotTextViews.get(length);
                    arrayList2.add(ObjectAnimator.ofFloat(textView6, (Property<TextView, Float>) View.SCALE_X, 1.0f));
                    arrayList2.add(ObjectAnimator.ofFloat(textView6, (Property<TextView, Float>) View.SCALE_Y, 1.0f));
                    arrayList2.add(ObjectAnimator.ofFloat(textView6, (Property<TextView, Float>) View.ALPHA, 1.0f));
                    AnimatingTextView.this.currentAnimation = new AnimatorSet();
                    AnimatingTextView.this.currentAnimation.setDuration(150L);
                    AnimatingTextView.this.currentAnimation.playTogether(arrayList2);
                    AnimatingTextView.this.currentAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.PasscodeView.AnimatingTextView.1.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animation) {
                            if (AnimatingTextView.this.currentAnimation == null || !AnimatingTextView.this.currentAnimation.equals(animation)) {
                                return;
                            }
                            AnimatingTextView.this.currentAnimation = null;
                        }
                    });
                    AnimatingTextView.this.currentAnimation.start();
                }
            };
            this.dotRunnable = runnable2;
            AndroidUtilities.runOnUIThread(runnable2, 1500L);
            for (int i2 = 0; i2 < length; i2++) {
                TextView textView5 = this.characterTextViews.get(i2);
                arrayList.add(ObjectAnimator.ofFloat(textView5, (Property<TextView, Float>) View.TRANSLATION_X, getXForTextView(i2)));
                arrayList.add(ObjectAnimator.ofFloat(textView5, (Property<TextView, Float>) View.SCALE_X, 0.0f));
                arrayList.add(ObjectAnimator.ofFloat(textView5, (Property<TextView, Float>) View.SCALE_Y, 0.0f));
                arrayList.add(ObjectAnimator.ofFloat(textView5, (Property<TextView, Float>) View.ALPHA, 0.0f));
                arrayList.add(ObjectAnimator.ofFloat(textView5, (Property<TextView, Float>) View.TRANSLATION_Y, 0.0f));
                TextView textView6 = this.dotTextViews.get(i2);
                arrayList.add(ObjectAnimator.ofFloat(textView6, (Property<TextView, Float>) View.TRANSLATION_X, getXForTextView(i2)));
                arrayList.add(ObjectAnimator.ofFloat(textView6, (Property<TextView, Float>) View.SCALE_X, 1.0f));
                arrayList.add(ObjectAnimator.ofFloat(textView6, (Property<TextView, Float>) View.SCALE_Y, 1.0f));
                arrayList.add(ObjectAnimator.ofFloat(textView6, (Property<TextView, Float>) View.ALPHA, 1.0f));
                arrayList.add(ObjectAnimator.ofFloat(textView6, (Property<TextView, Float>) View.TRANSLATION_Y, 0.0f));
            }
            AnimatorSet animatorSet = this.currentAnimation;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.currentAnimation = animatorSet2;
            animatorSet2.setDuration(150L);
            this.currentAnimation.playTogether(arrayList);
            this.currentAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.PasscodeView.AnimatingTextView.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    if (AnimatingTextView.this.currentAnimation == null || !AnimatingTextView.this.currentAnimation.equals(animation)) {
                        return;
                    }
                    AnimatingTextView.this.currentAnimation = null;
                }
            });
            this.currentAnimation.start();
        }

        public String getString() {
            return this.stringBuilder.toString();
        }

        public int length() {
            return this.stringBuilder.length();
        }

        public boolean eraseLastCharacter() {
            if (this.stringBuilder.length() == 0) {
                return false;
            }
            try {
                performHapticFeedback(3);
            } catch (Exception e) {
                FileLog.e(e);
            }
            ArrayList arrayList = new ArrayList();
            int length = this.stringBuilder.length() - 1;
            if (length != 0) {
                this.stringBuilder.deleteCharAt(length);
            }
            for (int i = length; i < 4; i++) {
                TextView textView = this.characterTextViews.get(i);
                if (textView.getAlpha() != 0.0f) {
                    arrayList.add(ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.SCALE_X, 0.0f));
                    arrayList.add(ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.SCALE_Y, 0.0f));
                    arrayList.add(ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.ALPHA, 0.0f));
                    arrayList.add(ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.TRANSLATION_Y, 0.0f));
                    arrayList.add(ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.TRANSLATION_X, getXForTextView(i)));
                }
                TextView textView2 = this.dotTextViews.get(i);
                if (textView2.getAlpha() != 0.0f) {
                    arrayList.add(ObjectAnimator.ofFloat(textView2, (Property<TextView, Float>) View.SCALE_X, 0.0f));
                    arrayList.add(ObjectAnimator.ofFloat(textView2, (Property<TextView, Float>) View.SCALE_Y, 0.0f));
                    arrayList.add(ObjectAnimator.ofFloat(textView2, (Property<TextView, Float>) View.ALPHA, 0.0f));
                    arrayList.add(ObjectAnimator.ofFloat(textView2, (Property<TextView, Float>) View.TRANSLATION_Y, 0.0f));
                    arrayList.add(ObjectAnimator.ofFloat(textView2, (Property<TextView, Float>) View.TRANSLATION_X, getXForTextView(i)));
                }
            }
            if (length == 0) {
                this.stringBuilder.deleteCharAt(length);
            }
            for (int i2 = 0; i2 < length; i2++) {
                arrayList.add(ObjectAnimator.ofFloat(this.characterTextViews.get(i2), (Property<TextView, Float>) View.TRANSLATION_X, getXForTextView(i2)));
                arrayList.add(ObjectAnimator.ofFloat(this.dotTextViews.get(i2), (Property<TextView, Float>) View.TRANSLATION_X, getXForTextView(i2)));
            }
            Runnable runnable = this.dotRunnable;
            if (runnable != null) {
                AndroidUtilities.cancelRunOnUIThread(runnable);
                this.dotRunnable = null;
            }
            AnimatorSet animatorSet = this.currentAnimation;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.currentAnimation = animatorSet2;
            animatorSet2.setDuration(150L);
            this.currentAnimation.playTogether(arrayList);
            this.currentAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.PasscodeView.AnimatingTextView.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    if (AnimatingTextView.this.currentAnimation == null || !AnimatingTextView.this.currentAnimation.equals(animation)) {
                        return;
                    }
                    AnimatingTextView.this.currentAnimation = null;
                }
            });
            this.currentAnimation.start();
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void eraseAllCharacters(final boolean animated) {
            if (this.stringBuilder.length() == 0) {
                return;
            }
            Runnable runnable = this.dotRunnable;
            if (runnable != null) {
                AndroidUtilities.cancelRunOnUIThread(runnable);
                this.dotRunnable = null;
            }
            AnimatorSet animatorSet = this.currentAnimation;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.currentAnimation = null;
            }
            StringBuilder sb = this.stringBuilder;
            sb.delete(0, sb.length());
            if (!animated) {
                for (int i = 0; i < 4; i++) {
                    this.characterTextViews.get(i).setAlpha(0.0f);
                    this.dotTextViews.get(i).setAlpha(0.0f);
                }
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < 4; i2++) {
                TextView textView = this.characterTextViews.get(i2);
                if (textView.getAlpha() != 0.0f) {
                    arrayList.add(ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.SCALE_X, 0.0f));
                    arrayList.add(ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.SCALE_Y, 0.0f));
                    arrayList.add(ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.ALPHA, 0.0f));
                }
                TextView textView2 = this.dotTextViews.get(i2);
                if (textView2.getAlpha() != 0.0f) {
                    arrayList.add(ObjectAnimator.ofFloat(textView2, (Property<TextView, Float>) View.SCALE_X, 0.0f));
                    arrayList.add(ObjectAnimator.ofFloat(textView2, (Property<TextView, Float>) View.SCALE_Y, 0.0f));
                    arrayList.add(ObjectAnimator.ofFloat(textView2, (Property<TextView, Float>) View.ALPHA, 0.0f));
                }
            }
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.currentAnimation = animatorSet2;
            animatorSet2.setDuration(150L);
            this.currentAnimation.playTogether(arrayList);
            this.currentAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.PasscodeView.AnimatingTextView.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    if (AnimatingTextView.this.currentAnimation == null || !AnimatingTextView.this.currentAnimation.equals(animation)) {
                        return;
                    }
                    AnimatingTextView.this.currentAnimation = null;
                }
            });
            this.currentAnimation.start();
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
            Runnable runnable = this.dotRunnable;
            if (runnable != null) {
                AndroidUtilities.cancelRunOnUIThread(runnable);
                this.dotRunnable = null;
            }
            AnimatorSet animatorSet = this.currentAnimation;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.currentAnimation = null;
            }
            for (int i = 0; i < 4; i++) {
                if (i < this.stringBuilder.length()) {
                    TextView textView = this.characterTextViews.get(i);
                    textView.setAlpha(0.0f);
                    textView.setScaleX(1.0f);
                    textView.setScaleY(1.0f);
                    textView.setTranslationY(0.0f);
                    textView.setTranslationX(getXForTextView(i));
                    TextView textView2 = this.dotTextViews.get(i);
                    textView2.setAlpha(1.0f);
                    textView2.setScaleX(1.0f);
                    textView2.setScaleY(1.0f);
                    textView2.setTranslationY(0.0f);
                    textView2.setTranslationX(getXForTextView(i));
                } else {
                    this.characterTextViews.get(i).setAlpha(0.0f);
                    this.dotTextViews.get(i).setAlpha(0.0f);
                }
            }
            super.onLayout(changed, left, top, right, bottom);
        }
    }

    private static class InnerAnimator {
        private AnimatorSet animatorSet;
        private float startRadius;

        private InnerAnimator() {
        }
    }

    public PasscodeView(final Context context) {
        super(context);
        int i = 0;
        this.keyboardHeight = 0;
        this.isChatLock = false;
        this.rect = new android.graphics.Rect();
        this.innerAnimators = new ArrayList<>();
        this.checkRunnable = new Runnable() { // from class: ir.eitaa.ui.Components.PasscodeView.8
            @Override // java.lang.Runnable
            public void run() {
                PasscodeView.this.checkRetryTextView();
                AndroidUtilities.runOnUIThread(PasscodeView.this.checkRunnable, 100L);
            }
        };
        this.pos = new int[2];
        setWillNotDraw(false);
        setVisibility(8);
        FrameLayout frameLayout = new FrameLayout(context) { // from class: ir.eitaa.ui.Components.PasscodeView.1
            private Paint paint = new Paint();

            @Override // android.view.View
            protected void onDraw(Canvas canvas) {
                if (PasscodeView.this.backgroundDrawable != null) {
                    if ((PasscodeView.this.backgroundDrawable instanceof MotionBackgroundDrawable) || (PasscodeView.this.backgroundDrawable instanceof ColorDrawable) || (PasscodeView.this.backgroundDrawable instanceof GradientDrawable)) {
                        PasscodeView.this.backgroundDrawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
                        PasscodeView.this.backgroundDrawable.draw(canvas);
                    } else {
                        float fMax = Math.max(getMeasuredWidth() / PasscodeView.this.backgroundDrawable.getIntrinsicWidth(), (getMeasuredHeight() + PasscodeView.this.keyboardHeight) / PasscodeView.this.backgroundDrawable.getIntrinsicHeight());
                        int iCeil = (int) Math.ceil(PasscodeView.this.backgroundDrawable.getIntrinsicWidth() * fMax);
                        int iCeil2 = (int) Math.ceil(PasscodeView.this.backgroundDrawable.getIntrinsicHeight() * fMax);
                        int measuredWidth = (getMeasuredWidth() - iCeil) / 2;
                        int measuredHeight = ((getMeasuredHeight() - iCeil2) + PasscodeView.this.keyboardHeight) / 2;
                        PasscodeView.this.backgroundDrawable.setBounds(measuredWidth, measuredHeight, iCeil + measuredWidth, iCeil2 + measuredHeight);
                        PasscodeView.this.backgroundDrawable.draw(canvas);
                    }
                } else {
                    super.onDraw(canvas);
                }
                canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.paint);
            }

            @Override // android.view.View
            public void setBackgroundColor(int color) {
                this.paint.setColor(color);
            }
        };
        this.backgroundFrameLayout = frameLayout;
        frameLayout.setWillNotDraw(false);
        int i2 = -1;
        addView(this.backgroundFrameLayout, LayoutHelper.createFrame(-1, -1.0f));
        ImageView imageView = new ImageView(getContext());
        this.backButton = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        this.backButton.setImageResource(R.drawable.ic_ab_back);
        this.backButton.setBackgroundDrawable(Theme.createCircleSelectorDrawable(ColorUtils.setAlphaComponent(Theme.getColor("chats_actionBackground"), 50), 0, 0));
        addView(this.backButton, LayoutHelper.createFrame(32, 32.0f, 51, 16.0f, 64.0f, 16.0f, 16.0f));
        this.backButton.setVisibility(8);
        this.backButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.PasscodeView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                PasscodeView.this.dismiss();
            }
        });
        RLottieImageView rLottieImageView = new RLottieImageView(context);
        this.imageView = rLottieImageView;
        rLottieImageView.setAnimation(R.raw.passcode_lock_close, 58, 58);
        this.imageView.setAutoRepeat(false);
        addView(this.imageView, LayoutHelper.createFrame(58, 58, 51));
        FrameLayout frameLayout2 = new FrameLayout(context);
        this.passwordFrameLayout = frameLayout2;
        this.backgroundFrameLayout.addView(frameLayout2, LayoutHelper.createFrame(-1, -1.0f));
        TextView textView = new TextView(context);
        this.passcodeTextView = textView;
        textView.setTextColor(-1);
        this.passcodeTextView.setTextSize(1, 14.0f);
        this.passcodeTextView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.passcodeTextView.setGravity(1);
        this.passwordFrameLayout.addView(this.passcodeTextView, LayoutHelper.createFrame(-2, -2.0f, 81, 0.0f, 0.0f, 0.0f, 74.0f));
        TextView textView2 = new TextView(context);
        this.retryTextView = textView2;
        textView2.setTextColor(-1);
        this.retryTextView.setTextSize(1, 15.0f);
        this.retryTextView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.retryTextView.setGravity(1);
        this.retryTextView.setVisibility(4);
        this.backgroundFrameLayout.addView(this.retryTextView, LayoutHelper.createFrame(-2, -2, 17));
        AnimatingTextView animatingTextView = new AnimatingTextView(context);
        this.passwordEditText2 = animatingTextView;
        this.passwordFrameLayout.addView(animatingTextView, LayoutHelper.createFrame(-1, -2.0f, 81, 70.0f, 0.0f, 70.0f, 6.0f));
        EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(context);
        this.passwordEditText = editTextBoldCursor;
        float f = 36.0f;
        editTextBoldCursor.setTextSize(1, 36.0f);
        this.passwordEditText.setTypeface(AndroidUtilities.getFontFamily(false));
        this.passwordEditText.setTextColor(-1);
        this.passwordEditText.setMaxLines(1);
        this.passwordEditText.setLines(1);
        this.passwordEditText.setGravity(1);
        this.passwordEditText.setSingleLine(true);
        this.passwordEditText.setImeOptions(6);
        this.passwordEditText.setTypeface(AndroidUtilities.getFontFamily(false));
        this.passwordEditText.setBackgroundDrawable(null);
        this.passwordEditText.setCursorColor(-1);
        this.passwordEditText.setCursorSize(AndroidUtilities.dp(32.0f));
        this.passwordFrameLayout.addView(this.passwordEditText, LayoutHelper.createFrame(-1, -2.0f, 81, 70.0f, 0.0f, 70.0f, 0.0f));
        this.passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$PasscodeView$TLd26v8u-NK9v8fDaRNeAz706lU
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView3, int i3, KeyEvent keyEvent) {
                return this.f$0.lambda$new$0$PasscodeView(textView3, i3, keyEvent);
            }
        });
        this.passwordEditText.addTextChangedListener(new TextWatcher() { // from class: ir.eitaa.ui.Components.PasscodeView.3
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (PasscodeView.this.backgroundDrawable instanceof MotionBackgroundDrawable) {
                    if (count == 0 && after == 1) {
                        ((MotionBackgroundDrawable) PasscodeView.this.backgroundDrawable).switchToNextPosition(true);
                    } else if (count == 1 && after == 0) {
                        ((MotionBackgroundDrawable) PasscodeView.this.backgroundDrawable).switchToPrevPosition(true);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (PasscodeView.this.passwordEditText.length() == 4 && PasscodeView.passcodeType == 0) {
                    PasscodeView.this.processDone(false);
                }
            }
        });
        this.passwordEditText.setCustomSelectionActionModeCallback(new ActionMode.Callback() { // from class: ir.eitaa.ui.Components.PasscodeView.4
            @Override // android.view.ActionMode.Callback
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                return false;
            }

            @Override // android.view.ActionMode.Callback
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override // android.view.ActionMode.Callback
            public void onDestroyActionMode(ActionMode mode) {
            }

            @Override // android.view.ActionMode.Callback
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }
        });
        ImageView imageView2 = new ImageView(context);
        this.checkImage = imageView2;
        imageView2.setImageResource(R.drawable.passcode_check);
        this.checkImage.setScaleType(ImageView.ScaleType.CENTER);
        this.checkImage.setBackgroundResource(R.drawable.bar_selector_lock);
        this.passwordFrameLayout.addView(this.checkImage, LayoutHelper.createFrame(60, 60.0f, 85, 0.0f, 0.0f, 10.0f, 4.0f));
        this.checkImage.setContentDescription(LocaleController.getString("Done", R.string.Done));
        this.checkImage.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$PasscodeView$TAWjBiYWq-j-YH9NH-wkI8cN0n4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$1$PasscodeView(view);
            }
        });
        ImageView imageView3 = new ImageView(context);
        this.fingerprintImage = imageView3;
        imageView3.setImageResource(R.drawable.fingerprint);
        this.fingerprintImage.setScaleType(ImageView.ScaleType.CENTER);
        this.fingerprintImage.setBackgroundResource(R.drawable.bar_selector_lock);
        this.passwordFrameLayout.addView(this.fingerprintImage, LayoutHelper.createFrame(60, 60.0f, 83, 10.0f, 0.0f, 0.0f, 4.0f));
        this.fingerprintImage.setContentDescription(LocaleController.getString("AccDescrFingerprint", R.string.AccDescrFingerprint));
        this.fingerprintImage.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$PasscodeView$xykMWJkq36NuA0oz6_zsAkoyqc8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$2$PasscodeView(view);
            }
        });
        FrameLayout frameLayout3 = new FrameLayout(context);
        frameLayout3.setBackgroundColor(654311423);
        this.passwordFrameLayout.addView(frameLayout3, LayoutHelper.createFrame(-1, 1.0f, 83, 20.0f, 0.0f, 20.0f, 0.0f));
        FrameLayout frameLayout4 = new FrameLayout(context);
        this.numbersFrameLayout = frameLayout4;
        this.backgroundFrameLayout.addView(frameLayout4, LayoutHelper.createFrame(-1, -1, 51));
        this.lettersTextViews = new ArrayList<>(10);
        this.numberTextViews = new ArrayList<>(10);
        this.numberFrameLayouts = new ArrayList<>(10);
        int i3 = 0;
        for (int i4 = 10; i3 < i4; i4 = 10) {
            TextView textView3 = new TextView(context);
            textView3.setTextColor(i2);
            textView3.setTextSize(1, f);
            textView3.setTypeface(AndroidUtilities.getFontFamily(false));
            textView3.setGravity(17);
            textView3.setText(String.format(Locale.US, "%d", Integer.valueOf(i3)));
            this.numbersFrameLayout.addView(textView3, LayoutHelper.createFrame(50, 50, 51));
            textView3.setImportantForAccessibility(2);
            this.numberTextViews.add(textView3);
            TextView textView4 = new TextView(context);
            textView4.setTextSize(1, 12.0f);
            textView4.setTypeface(AndroidUtilities.getFontFamily(false));
            textView4.setTextColor(ConnectionsManager.DEFAULT_DATACENTER_ID);
            textView4.setGravity(17);
            this.numbersFrameLayout.addView(textView4, LayoutHelper.createFrame(50, 50, 51));
            textView4.setImportantForAccessibility(2);
            if (i3 == 0) {
                textView4.setText("+");
            } else {
                switch (i3) {
                    case 2:
                        textView4.setText("ABC");
                        break;
                    case 3:
                        textView4.setText("DEF");
                        break;
                    case 4:
                        textView4.setText("GHI");
                        break;
                    case 5:
                        textView4.setText("JKL");
                        break;
                    case 6:
                        textView4.setText("MNO");
                        break;
                    case 7:
                        textView4.setText("PQRS");
                        break;
                    case 8:
                        textView4.setText("TUV");
                        break;
                    case 9:
                        textView4.setText("WXYZ");
                        break;
                }
            }
            this.lettersTextViews.add(textView4);
            i3++;
            i2 = -1;
            f = 36.0f;
        }
        ImageView imageView4 = new ImageView(context);
        this.eraseView = imageView4;
        imageView4.setScaleType(ImageView.ScaleType.CENTER);
        this.eraseView.setImageResource(R.drawable.passcode_delete);
        this.numbersFrameLayout.addView(this.eraseView, LayoutHelper.createFrame(50, 50, 51));
        ImageView imageView5 = new ImageView(context);
        this.fingerprintView = imageView5;
        imageView5.setScaleType(ImageView.ScaleType.CENTER);
        this.fingerprintView.setImageResource(R.drawable.fingerprint);
        this.fingerprintView.setVisibility(8);
        this.numbersFrameLayout.addView(this.fingerprintView, LayoutHelper.createFrame(50, 50, 51));
        checkFingerprintButton();
        while (true) {
            if (i >= 12) {
                for (int i5 = 11; i5 >= 0; i5--) {
                    this.numbersFrameLayout.addView(this.numberFrameLayouts.get(i5), LayoutHelper.createFrame(100, 100, 51));
                }
                return;
            }
            FrameLayout frameLayout5 = new FrameLayout(context) { // from class: ir.eitaa.ui.Components.PasscodeView.5
                @Override // android.view.View
                public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
                    super.onInitializeAccessibilityNodeInfo(info);
                    info.setClassName("android.widget.Button");
                }
            };
            frameLayout5.setBackgroundResource(R.drawable.bar_selector_lock);
            frameLayout5.setTag(Integer.valueOf(i));
            if (i == 11) {
                frameLayout5.setContentDescription(LocaleController.getString("AccDescrFingerprint", R.string.AccDescrFingerprint));
                setNextFocus(frameLayout5, R.id.passcode_btn_0);
            } else if (i == 10) {
                frameLayout5.setOnLongClickListener(new View.OnLongClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$PasscodeView$8rXlK19XmPyGGKhH1n0p4YobeEE
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view) {
                        return this.f$0.lambda$new$3$PasscodeView(view);
                    }
                });
                frameLayout5.setContentDescription(LocaleController.getString("AccDescrBackspace", R.string.AccDescrBackspace));
                setNextFocus(frameLayout5, R.id.passcode_btn_1);
            } else {
                frameLayout5.setContentDescription(i + "");
                if (i == 0) {
                    setNextFocus(frameLayout5, R.id.passcode_btn_backspace);
                } else if (i == 9) {
                    if (this.fingerprintView.getVisibility() == 0) {
                        setNextFocus(frameLayout5, R.id.passcode_btn_fingerprint);
                    } else {
                        setNextFocus(frameLayout5, R.id.passcode_btn_0);
                    }
                } else {
                    setNextFocus(frameLayout5, ids[i + 1]);
                }
            }
            frameLayout5.setId(ids[i]);
            frameLayout5.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$PasscodeView$prZOKsK0rkXDEpwacaFfjpgyyvI
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$4$PasscodeView(view);
                }
            });
            this.numberFrameLayouts.add(frameLayout5);
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$new$0$PasscodeView(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        processDone(false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$1$PasscodeView(View view) {
        processDone(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$2$PasscodeView(View view) {
        checkFingerprint();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$new$3$PasscodeView(View view) {
        this.passwordEditText.setText("");
        this.passwordEditText2.eraseAllCharacters(true);
        Drawable drawable = this.backgroundDrawable;
        if (drawable instanceof MotionBackgroundDrawable) {
            ((MotionBackgroundDrawable) drawable).switchToPrevPosition(true);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: lambda$new$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$4$PasscodeView(View view) {
        boolean zEraseLastCharacter;
        int iIntValue = ((Integer) view.getTag()).intValue();
        switch (iIntValue) {
            case 0:
                this.passwordEditText2.appendCharacter("0");
                zEraseLastCharacter = false;
                break;
            case 1:
                this.passwordEditText2.appendCharacter("1");
                zEraseLastCharacter = false;
                break;
            case 2:
                this.passwordEditText2.appendCharacter("2");
                zEraseLastCharacter = false;
                break;
            case 3:
                this.passwordEditText2.appendCharacter("3");
                zEraseLastCharacter = false;
                break;
            case 4:
                this.passwordEditText2.appendCharacter("4");
                zEraseLastCharacter = false;
                break;
            case 5:
                this.passwordEditText2.appendCharacter("5");
                zEraseLastCharacter = false;
                break;
            case 6:
                this.passwordEditText2.appendCharacter("6");
                zEraseLastCharacter = false;
                break;
            case 7:
                this.passwordEditText2.appendCharacter("7");
                zEraseLastCharacter = false;
                break;
            case 8:
                this.passwordEditText2.appendCharacter("8");
                zEraseLastCharacter = false;
                break;
            case 9:
                this.passwordEditText2.appendCharacter("9");
                zEraseLastCharacter = false;
                break;
            case 10:
                zEraseLastCharacter = this.passwordEditText2.eraseLastCharacter();
                break;
            case 11:
                checkFingerprint();
                zEraseLastCharacter = false;
                break;
            default:
                zEraseLastCharacter = false;
                break;
        }
        if (this.passwordEditText2.length() == 4) {
            processDone(false);
        }
        if (iIntValue == 11) {
            return;
        }
        if (iIntValue != 10) {
            Drawable drawable = this.backgroundDrawable;
            if (drawable instanceof MotionBackgroundDrawable) {
                ((MotionBackgroundDrawable) drawable).switchToNextPosition(true);
                return;
            }
            return;
        }
        if (zEraseLastCharacter) {
            Drawable drawable2 = this.backgroundDrawable;
            if (drawable2 instanceof MotionBackgroundDrawable) {
                ((MotionBackgroundDrawable) drawable2).switchToPrevPosition(true);
            }
        }
    }

    private void setNextFocus(View view, int nextId) {
        view.setNextFocusForwardId(nextId);
        if (Build.VERSION.SDK_INT >= 22) {
            view.setAccessibilityTraversalBefore(nextId);
        }
    }

    public void setDelegate(PasscodeViewDelegate delegate) {
        this.delegate = delegate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processDone(boolean fingerprint) {
        String string;
        if (!fingerprint) {
            if (passcodeRetryInMs > 0) {
                return;
            }
            int i = passcodeType;
            if (i == 0) {
                string = this.passwordEditText2.getString();
            } else {
                string = i == 1 ? this.passwordEditText.getText().toString() : "";
            }
            if (string.length() == 0) {
                onPasscodeError();
                return;
            }
            if (!checkPasscode(string)) {
                increaseBadPasscodeTries();
                if (passcodeRetryInMs > 0) {
                    checkRetryTextView();
                }
                this.passwordEditText.setText("");
                this.passwordEditText2.eraseAllCharacters(true);
                onPasscodeError();
                Drawable drawable = this.backgroundDrawable;
                if (drawable instanceof MotionBackgroundDrawable) {
                    ((MotionBackgroundDrawable) drawable).rotatePreview(true);
                    return;
                }
                return;
            }
        }
        badPasscodeTries = 0;
        this.passwordEditText.clearFocus();
        AndroidUtilities.hideKeyboard(this.passwordEditText);
        if (!this.isChatLock) {
            SharedConfig.appLocked = false;
        }
        saveConfig();
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.didSetPasscode, new Object[0]);
        setOnTouchListener(null);
        PasscodeViewDelegate passcodeViewDelegate = this.delegate;
        if (passcodeViewDelegate != null) {
            passcodeViewDelegate.didAcceptedPassword();
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$PasscodeView$41Kx21uTpECvtMHmgc2E67EEHEM
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processDone$5$PasscodeView();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processDone$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processDone$5$PasscodeView() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(200L);
        animatorSet.playTogether(ObjectAnimator.ofFloat(this, (Property<PasscodeView, Float>) View.TRANSLATION_Y, AndroidUtilities.dp(20.0f)), ObjectAnimator.ofFloat(this, (Property<PasscodeView, Float>) View.ALPHA, AndroidUtilities.dp(0.0f)));
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.PasscodeView.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                PasscodeView.this.setVisibility(8);
            }
        });
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void shakeTextView(final float x, final int num) {
        if (num == 6) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.passcodeTextView, (Property<TextView, Float>) View.TRANSLATION_X, AndroidUtilities.dp(x)));
        animatorSet.setDuration(50L);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.PasscodeView.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                PasscodeView passcodeView = PasscodeView.this;
                int i = num;
                passcodeView.shakeTextView(i == 5 ? 0.0f : -x, i + 1);
            }
        });
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkRetryTextView() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = lastUptimeMillis;
        if (jElapsedRealtime > j) {
            long j2 = passcodeRetryInMs - (jElapsedRealtime - j);
            passcodeRetryInMs = j2;
            if (j2 < 0) {
                passcodeRetryInMs = 0L;
            }
        }
        lastUptimeMillis = jElapsedRealtime;
        saveConfig();
        long j3 = passcodeRetryInMs;
        if (j3 > 0) {
            double d = j3;
            Double.isNaN(d);
            int iMax = Math.max(1, (int) Math.ceil(d / 1000.0d));
            if (iMax != this.lastValue) {
                this.retryTextView.setText(LocaleController.formatString("TooManyTries", R.string.TooManyTries, LocaleController.formatPluralString("Seconds", iMax)));
                this.lastValue = iMax;
            }
            if (this.retryTextView.getVisibility() != 0) {
                this.retryTextView.setVisibility(0);
                this.passwordFrameLayout.setVisibility(4);
                if (this.numbersFrameLayout.getVisibility() == 0) {
                    this.numbersFrameLayout.setVisibility(4);
                }
                AndroidUtilities.hideKeyboard(this.passwordEditText);
            }
            AndroidUtilities.cancelRunOnUIThread(this.checkRunnable);
            AndroidUtilities.runOnUIThread(this.checkRunnable, 100L);
            return;
        }
        AndroidUtilities.cancelRunOnUIThread(this.checkRunnable);
        if (this.passwordFrameLayout.getVisibility() != 0) {
            this.retryTextView.setVisibility(4);
            this.passwordFrameLayout.setVisibility(0);
            int i = passcodeType;
            if (i == 0) {
                this.numbersFrameLayout.setVisibility(0);
            } else if (i == 1) {
                AndroidUtilities.showKeyboard(this.passwordEditText);
            }
        }
    }

    private void onPasscodeError() {
        Vibrator vibrator = (Vibrator) getContext().getSystemService("vibrator");
        if (vibrator != null) {
            vibrator.vibrate(200L);
        }
        shakeTextView(2.0f, 0);
    }

    public void onResume() {
        checkRetryTextView();
        if (this.retryTextView.getVisibility() != 0) {
            if (passcodeType == 1) {
                EditTextBoldCursor editTextBoldCursor = this.passwordEditText;
                if (editTextBoldCursor != null) {
                    editTextBoldCursor.requestFocus();
                    AndroidUtilities.showKeyboard(this.passwordEditText);
                }
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$PasscodeView$uU66jByL8Ar7cY4_nkR43ZG5L5k
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onResume$6$PasscodeView();
                    }
                }, 200L);
            }
            checkFingerprint();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onResume$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onResume$6$PasscodeView() {
        EditTextBoldCursor editTextBoldCursor;
        if (this.retryTextView.getVisibility() == 0 || (editTextBoldCursor = this.passwordEditText) == null) {
            return;
        }
        editTextBoldCursor.requestFocus();
        AndroidUtilities.showKeyboard(this.passwordEditText);
    }

    public void onPause() {
        CancellationSignal cancellationSignal;
        AndroidUtilities.cancelRunOnUIThread(this.checkRunnable);
        AlertDialog alertDialog = this.fingerprintDialog;
        if (alertDialog != null) {
            try {
                if (alertDialog.isShowing()) {
                    this.fingerprintDialog.dismiss();
                }
                this.fingerprintDialog = null;
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
        try {
            if (Build.VERSION.SDK_INT < 23 || (cancellationSignal = this.cancellationSignal) == null) {
                return;
            }
            cancellationSignal.cancel();
            this.cancellationSignal = null;
        } catch (Exception e2) {
            FileLog.e(e2);
        }
    }

    private void checkFingerprint() {
        if (Build.VERSION.SDK_INT >= 23 && ((Activity) getContext()) != null && this.fingerprintView.getVisibility() == 0 && !ApplicationLoader.mainInterfacePaused) {
            try {
                AlertDialog alertDialog = this.fingerprintDialog;
                if (alertDialog != null) {
                    if (alertDialog.isShowing()) {
                        return;
                    }
                }
            } catch (Exception e) {
                FileLog.e(e);
            }
            try {
                FingerprintManagerCompat fingerprintManagerCompatFrom = FingerprintManagerCompat.from(ApplicationLoader.applicationContext);
                if (fingerprintManagerCompatFrom.isHardwareDetected() && fingerprintManagerCompatFrom.hasEnrolledFingerprints()) {
                    RelativeLayout relativeLayout = new RelativeLayout(getContext());
                    relativeLayout.setPadding(AndroidUtilities.dp(24.0f), 0, AndroidUtilities.dp(24.0f), 0);
                    TextView textView = new TextView(getContext());
                    textView.setId(1000);
                    textView.setTextAppearance(android.R.style.TextAppearance.Material.Subhead);
                    textView.setTextColor(Theme.getColor("dialogTextBlack"));
                    textView.setText(LocaleController.getString("FingerprintInfo", R.string.FingerprintInfo));
                    textView.setTypeface(AndroidUtilities.getFontFamily(false));
                    relativeLayout.addView(textView);
                    RelativeLayout.LayoutParams layoutParamsCreateRelative = LayoutHelper.createRelative(-2, -2);
                    layoutParamsCreateRelative.addRule(10);
                    layoutParamsCreateRelative.addRule(20);
                    textView.setLayoutParams(layoutParamsCreateRelative);
                    ImageView imageView = new ImageView(getContext());
                    this.fingerprintImageView = imageView;
                    imageView.setImageResource(R.drawable.ic_fp_40px);
                    this.fingerprintImageView.setId(1001);
                    relativeLayout.addView(this.fingerprintImageView, LayoutHelper.createRelative(-2.0f, -2.0f, 0, 20, 0, 0, 20, 3, 1000));
                    TextView textView2 = new TextView(getContext());
                    this.fingerprintStatusTextView = textView2;
                    textView2.setGravity(16);
                    this.fingerprintStatusTextView.setText(LocaleController.getString("FingerprintHelp", R.string.FingerprintHelp));
                    this.fingerprintStatusTextView.setTypeface(AndroidUtilities.getFontFamily(false));
                    this.fingerprintStatusTextView.setTextAppearance(android.R.style.TextAppearance.Material.Body1);
                    this.fingerprintStatusTextView.setTextColor(Theme.getColor("dialogTextBlack") & 1124073471);
                    relativeLayout.addView(this.fingerprintStatusTextView);
                    RelativeLayout.LayoutParams layoutParamsCreateRelative2 = LayoutHelper.createRelative(-2, -2);
                    layoutParamsCreateRelative2.setMarginStart(AndroidUtilities.dp(16.0f));
                    layoutParamsCreateRelative2.addRule(8, 1001);
                    layoutParamsCreateRelative2.addRule(6, 1001);
                    layoutParamsCreateRelative2.addRule(17, 1001);
                    this.fingerprintStatusTextView.setLayoutParams(layoutParamsCreateRelative2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
                    builder.setView(relativeLayout);
                    builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                    builder.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$PasscodeView$QxYtivumPw9pE-roleWmLcifT8E
                        @Override // android.content.DialogInterface.OnDismissListener
                        public final void onDismiss(DialogInterface dialogInterface) {
                            this.f$0.lambda$checkFingerprint$7$PasscodeView(dialogInterface);
                        }
                    });
                    AlertDialog alertDialog2 = this.fingerprintDialog;
                    if (alertDialog2 != null) {
                        try {
                            if (alertDialog2.isShowing()) {
                                this.fingerprintDialog.dismiss();
                            }
                        } catch (Exception e2) {
                            FileLog.e(e2);
                        }
                    }
                    this.fingerprintDialog = builder.show();
                    CancellationSignal cancellationSignal = new CancellationSignal();
                    this.cancellationSignal = cancellationSignal;
                    this.selfCancelled = false;
                    fingerprintManagerCompatFrom.authenticate(null, 0, cancellationSignal, new FingerprintManagerCompat.AuthenticationCallback() { // from class: ir.eitaa.ui.Components.PasscodeView.9
                        @Override // ir.eitaa.messenger.support.fingerprint.FingerprintManagerCompat.AuthenticationCallback
                        public void onAuthenticationError(int errMsgId, CharSequence errString) {
                            if (errMsgId == 10) {
                                try {
                                    if (PasscodeView.this.fingerprintDialog.isShowing()) {
                                        PasscodeView.this.fingerprintDialog.dismiss();
                                    }
                                } catch (Exception e3) {
                                    FileLog.e(e3);
                                }
                                PasscodeView.this.fingerprintDialog = null;
                                return;
                            }
                            if (PasscodeView.this.selfCancelled || errMsgId == 5) {
                                return;
                            }
                            PasscodeView.this.showFingerprintError(errString);
                        }

                        @Override // ir.eitaa.messenger.support.fingerprint.FingerprintManagerCompat.AuthenticationCallback
                        public void onAuthenticationHelp(int helpMsgId, CharSequence helpString) {
                            PasscodeView.this.showFingerprintError(helpString);
                        }

                        @Override // ir.eitaa.messenger.support.fingerprint.FingerprintManagerCompat.AuthenticationCallback
                        public void onAuthenticationFailed() {
                            PasscodeView.this.showFingerprintError(LocaleController.getString("FingerprintNotRecognized", R.string.FingerprintNotRecognized));
                        }

                        @Override // ir.eitaa.messenger.support.fingerprint.FingerprintManagerCompat.AuthenticationCallback
                        public void onAuthenticationSucceeded(FingerprintManagerCompat.AuthenticationResult result) {
                            try {
                                if (PasscodeView.this.fingerprintDialog.isShowing()) {
                                    PasscodeView.this.fingerprintDialog.dismiss();
                                }
                            } catch (Exception e3) {
                                FileLog.e(e3);
                            }
                            PasscodeView.this.fingerprintDialog = null;
                            PasscodeView.this.processDone(true);
                        }
                    }, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkFingerprint$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkFingerprint$7$PasscodeView(DialogInterface dialogInterface) {
        CancellationSignal cancellationSignal = this.cancellationSignal;
        if (cancellationSignal != null) {
            this.selfCancelled = true;
            try {
                cancellationSignal.cancel();
            } catch (Exception e) {
                FileLog.e(e);
            }
            this.cancellationSignal = null;
        }
    }

    public void onShow(boolean fingerprint, boolean animated) {
        onShow(fingerprint, animated, -1, -1, null, null);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0043 -> B:33:0x0051). Please report as a decompilation issue!!! */
    private void checkFingerprintButton() {
        Activity activity = (Activity) getContext();
        if (Build.VERSION.SDK_INT >= 23 && activity != null && useFingerprint) {
            try {
                AlertDialog alertDialog = this.fingerprintDialog;
                if (alertDialog != null) {
                    if (alertDialog.isShowing()) {
                        return;
                    }
                }
            } catch (Exception e) {
                FileLog.e(e);
            }
            try {
                FingerprintManagerCompat fingerprintManagerCompatFrom = FingerprintManagerCompat.from(ApplicationLoader.applicationContext);
                if (fingerprintManagerCompatFrom.isHardwareDetected() && fingerprintManagerCompatFrom.hasEnrolledFingerprints()) {
                    this.fingerprintView.setVisibility(0);
                } else {
                    this.fingerprintView.setVisibility(8);
                }
            } catch (Throwable th) {
                FileLog.e(th);
                this.fingerprintView.setVisibility(8);
            }
        } else {
            this.fingerprintView.setVisibility(8);
        }
        if (passcodeType == 1) {
            this.fingerprintImage.setVisibility(this.fingerprintView.getVisibility());
        }
        if (this.numberFrameLayouts.size() >= 11) {
            this.numberFrameLayouts.get(11).setVisibility(this.fingerprintView.getVisibility());
        }
    }

    public void onShow(boolean fingerprint, boolean animated, int x, int y, Runnable onShow, Runnable onStart) {
        onShow(fingerprint, animated, false, x, y, onShow, onStart);
    }

    public void onShow(boolean fingerprint, boolean animated, boolean isChatLock, int x, int y, Runnable onShow, Runnable onStart) {
        View currentFocus;
        EditTextBoldCursor editTextBoldCursor;
        this.isChatLock = isChatLock;
        initConfig();
        checkFingerprintButton();
        checkRetryTextView();
        Activity activity = (Activity) getContext();
        if (passcodeType == 1) {
            if (!animated && this.retryTextView.getVisibility() != 0 && (editTextBoldCursor = this.passwordEditText) != null) {
                editTextBoldCursor.requestFocus();
                AndroidUtilities.showKeyboard(this.passwordEditText);
            }
        } else if (activity != null && (currentFocus = activity.getCurrentFocus()) != null) {
            currentFocus.clearFocus();
            AndroidUtilities.hideKeyboard(((Activity) getContext()).getCurrentFocus());
        }
        if (fingerprint && this.retryTextView.getVisibility() != 0) {
            checkFingerprint();
        }
        if (getVisibility() == 0) {
            return;
        }
        setTranslationY(0.0f);
        this.backgroundDrawable = null;
        if (Theme.getCachedWallpaper() instanceof MotionBackgroundDrawable) {
            this.backgroundDrawable = Theme.getCachedWallpaper();
            this.backgroundFrameLayout.setBackgroundColor(-1090519040);
        } else if (Theme.isCustomTheme() && !"CJz3BZ6YGEYBAAAABboWp6SAv04".equals(Theme.getSelectedBackgroundSlug()) && !"qeZWES8rGVIEAAAARfWlK1lnfiI".equals(Theme.getSelectedBackgroundSlug())) {
            BackgroundGradientDrawable currentGradientWallpaper = Theme.getCurrentGradientWallpaper();
            this.backgroundDrawable = currentGradientWallpaper;
            if (currentGradientWallpaper == null) {
                this.backgroundDrawable = Theme.getCachedWallpaper();
            }
            if (this.backgroundDrawable instanceof BackgroundGradientDrawable) {
                this.backgroundFrameLayout.setBackgroundColor(570425344);
            } else {
                this.backgroundFrameLayout.setBackgroundColor(-1090519040);
            }
        } else if ("d".equals(Theme.getSelectedBackgroundSlug()) || Theme.isPatternWallpaper()) {
            this.backgroundFrameLayout.setBackgroundColor(-11436898);
        } else {
            Drawable cachedWallpaper = Theme.getCachedWallpaper();
            this.backgroundDrawable = cachedWallpaper;
            if (cachedWallpaper instanceof BackgroundGradientDrawable) {
                this.backgroundFrameLayout.setBackgroundColor(570425344);
            } else if (cachedWallpaper != null) {
                this.backgroundFrameLayout.setBackgroundColor(-1090519040);
            } else {
                this.backgroundFrameLayout.setBackgroundColor(-11436898);
            }
        }
        Drawable drawable = this.backgroundDrawable;
        if (drawable instanceof MotionBackgroundDrawable) {
            MotionBackgroundDrawable motionBackgroundDrawable = (MotionBackgroundDrawable) drawable;
            int[] colors = motionBackgroundDrawable.getColors();
            this.backgroundDrawable = new MotionBackgroundDrawable(colors[0], colors[1], colors[2], colors[3], false);
            if (motionBackgroundDrawable.hasPattern() && motionBackgroundDrawable.getIntensity() < 0) {
                this.backgroundFrameLayout.setBackgroundColor(2130706432);
            } else {
                this.backgroundFrameLayout.setBackgroundColor(570425344);
            }
            ((MotionBackgroundDrawable) this.backgroundDrawable).setParentView(this.backgroundFrameLayout);
        }
        if (isChatLock) {
            this.passcodeTextView.setText(LocaleController.getString("EnterDialogPassword", R.string.EnterDialogPassword));
            this.backButton.setVisibility(0);
        } else {
            this.passcodeTextView.setText(LocaleController.getString("EnterYourEitaaPasscode", R.string.EnterYourEitaaPasscode));
            this.backButton.setVisibility(8);
        }
        int i = passcodeType;
        if (i == 0) {
            if (this.retryTextView.getVisibility() != 0) {
                this.numbersFrameLayout.setVisibility(0);
            }
            this.passwordEditText.setVisibility(8);
            this.passwordEditText2.setVisibility(0);
            this.checkImage.setVisibility(8);
            this.fingerprintImage.setVisibility(8);
        } else if (i == 1) {
            this.passwordEditText.setFilters(new InputFilter[0]);
            this.passwordEditText.setInputType(129);
            this.numbersFrameLayout.setVisibility(8);
            this.passwordEditText.setFocusable(true);
            this.passwordEditText.setFocusableInTouchMode(true);
            this.passwordEditText.setVisibility(0);
            this.passwordEditText2.setVisibility(8);
            this.checkImage.setVisibility(0);
            this.fingerprintImage.setVisibility(this.fingerprintView.getVisibility());
        }
        setVisibility(0);
        this.passwordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        this.passwordEditText.setText("");
        this.passwordEditText2.eraseAllCharacters(false);
        if (animated) {
            setAlpha(0.0f);
            getViewTreeObserver().addOnGlobalLayoutListener(new AnonymousClass10(x, y, onShow));
            requestLayout();
        } else {
            setAlpha(1.0f);
            this.imageView.setScaleX(1.0f);
            this.imageView.setScaleY(1.0f);
            this.imageView.stopAnimation();
            this.imageView.getAnimatedDrawable().setCurrentFrame(38, false);
            if (onShow != null) {
                onShow.run();
            }
        }
        setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$PasscodeView$hbE7qE5BOzRlfAGYcyootsAHFDQ
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return PasscodeView.lambda$onShow$8(view, motionEvent);
            }
        });
    }

    /* renamed from: ir.eitaa.ui.Components.PasscodeView$10, reason: invalid class name */
    class AnonymousClass10 implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ Runnable val$onShow;
        final /* synthetic */ int val$x;
        final /* synthetic */ int val$y;

        AnonymousClass10(final int val$x, final int val$y, final Runnable val$onShow) {
            this.val$x = val$x;
            this.val$y = val$y;
            this.val$onShow = val$onShow;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int i;
            int i2;
            int iDp;
            int i3;
            final AnimatorSet animatorSet;
            char c;
            float f = 1.0f;
            PasscodeView.this.setAlpha(1.0f);
            PasscodeView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            float f2 = 0.0f;
            PasscodeView.this.imageView.setProgress(0.0f);
            PasscodeView.this.imageView.playAnimation();
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$PasscodeView$10$1VsgbokmCW6vVWFCwXBpqeWfTD0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onGlobalLayout$0$PasscodeView$10();
                }
            }, 350L);
            AnimatorSet animatorSet2 = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            android.graphics.Point point = AndroidUtilities.displaySize;
            int i4 = point.x;
            int i5 = point.y;
            int i6 = Build.VERSION.SDK_INT;
            char c2 = 0;
            int i7 = i5 + (i6 >= 21 ? AndroidUtilities.statusBarHeight : 0);
            if (i6 < 21) {
                arrayList.add(ObjectAnimator.ofFloat(PasscodeView.this.backgroundFrameLayout, (Property<FrameLayout, Float>) View.ALPHA, 0.0f, 1.0f));
                animatorSet2.setDuration(350L);
            } else {
                int i8 = this.val$x;
                int i9 = (i4 - i8) * (i4 - i8);
                int i10 = this.val$y;
                double dSqrt = Math.sqrt(i9 + ((i7 - i10) * (i7 - i10)));
                int i11 = this.val$x;
                int i12 = this.val$y;
                double dSqrt2 = Math.sqrt((i11 * i11) + ((i7 - i12) * (i7 - i12)));
                int i13 = this.val$x;
                int i14 = this.val$y;
                double dSqrt3 = Math.sqrt((i13 * i13) + (i14 * i14));
                int i15 = this.val$x;
                int i16 = (i4 - i15) * (i4 - i15);
                int i17 = this.val$y;
                final double dMax = Math.max(Math.max(Math.max(dSqrt, dSqrt2), dSqrt3), Math.sqrt(i16 + (i17 * i17)));
                PasscodeView.this.innerAnimators.clear();
                int childCount = PasscodeView.this.numbersFrameLayout.getChildCount();
                int i18 = -1;
                int i19 = -1;
                while (i19 < childCount) {
                    View childAt = i19 == i18 ? PasscodeView.this.passcodeTextView : PasscodeView.this.numbersFrameLayout.getChildAt(i19);
                    if ((childAt instanceof TextView) || (childAt instanceof ImageView)) {
                        childAt.setScaleX(0.7f);
                        childAt.setScaleY(0.7f);
                        childAt.setAlpha(f2);
                        InnerAnimator innerAnimator = new InnerAnimator();
                        childAt.getLocationInWindow(PasscodeView.this.pos);
                        int measuredWidth = PasscodeView.this.pos[c2] + (childAt.getMeasuredWidth() / 2);
                        int measuredHeight = PasscodeView.this.pos[1] + (childAt.getMeasuredHeight() / 2);
                        int i20 = this.val$x;
                        int i21 = (i20 - measuredWidth) * (i20 - measuredWidth);
                        int i22 = this.val$y;
                        innerAnimator.startRadius = ((float) Math.sqrt(i21 + ((i22 - measuredHeight) * (i22 - measuredHeight)))) - AndroidUtilities.dp(40.0f);
                        if (i19 != i18) {
                            animatorSet = new AnimatorSet();
                            Animator[] animatorArr = new Animator[2];
                            Property property = View.SCALE_X;
                            i3 = childCount;
                            float[] fArr = new float[1];
                            fArr[c2] = f;
                            animatorArr[c2] = ObjectAnimator.ofFloat(childAt, (Property<View, Float>) property, fArr);
                            Property property2 = View.SCALE_Y;
                            float[] fArr2 = new float[1];
                            fArr2[c2] = f;
                            animatorArr[1] = ObjectAnimator.ofFloat(childAt, (Property<View, Float>) property2, fArr2);
                            animatorSet.playTogether(animatorArr);
                            animatorSet.setDuration(140L);
                            animatorSet.setInterpolator(new DecelerateInterpolator());
                        } else {
                            i3 = childCount;
                            animatorSet = null;
                        }
                        innerAnimator.animatorSet = new AnimatorSet();
                        AnimatorSet animatorSet3 = innerAnimator.animatorSet;
                        Animator[] animatorArr2 = new Animator[3];
                        Property property3 = View.SCALE_X;
                        float[] fArr3 = new float[2];
                        fArr3[c2] = i19 == -1 ? 0.9f : 0.6f;
                        float f3 = 1.04f;
                        fArr3[1] = i19 == -1 ? 1.0f : 1.04f;
                        animatorArr2[c2] = ObjectAnimator.ofFloat(childAt, (Property<View, Float>) property3, fArr3);
                        Property property4 = View.SCALE_Y;
                        float[] fArr4 = new float[2];
                        fArr4[0] = i19 == -1 ? 0.9f : 0.6f;
                        if (i19 == -1) {
                            c = 1;
                            f3 = 1.0f;
                        } else {
                            c = 1;
                        }
                        fArr4[c] = f3;
                        animatorArr2[c] = ObjectAnimator.ofFloat(childAt, (Property<View, Float>) property4, fArr4);
                        animatorArr2[2] = ObjectAnimator.ofFloat(childAt, (Property<View, Float>) View.ALPHA, 0.0f, 1.0f);
                        animatorSet3.playTogether(animatorArr2);
                        innerAnimator.animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.PasscodeView.10.1
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animation) {
                                AnimatorSet animatorSet4 = animatorSet;
                                if (animatorSet4 != null) {
                                    animatorSet4.start();
                                }
                            }
                        });
                        innerAnimator.animatorSet.setDuration(i19 == -1 ? 232L : 200L);
                        innerAnimator.animatorSet.setInterpolator(new DecelerateInterpolator());
                        PasscodeView.this.innerAnimators.add(innerAnimator);
                    } else {
                        i3 = childCount;
                    }
                    i19++;
                    childCount = i3;
                    f = 1.0f;
                    f2 = 0.0f;
                    i18 = -1;
                    c2 = 0;
                }
                arrayList.add(ViewAnimationUtils.createCircularReveal(PasscodeView.this.backgroundFrameLayout, this.val$x, this.val$y, 0.0f, (float) dMax));
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                arrayList.add(valueAnimatorOfFloat);
                valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$PasscodeView$10$rCTQNp_X7zdq68f6d2JfogByANI
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        this.f$0.lambda$onGlobalLayout$1$PasscodeView$10(dMax, valueAnimator);
                    }
                });
                animatorSet2.setInterpolator(Easings.easeInOutQuad);
                animatorSet2.setDuration(498L);
            }
            animatorSet2.playTogether(arrayList);
            animatorSet2.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.PasscodeView.10.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    Runnable runnable = AnonymousClass10.this.val$onShow;
                    if (runnable != null) {
                        runnable.run();
                    }
                    if (PasscodeView.passcodeType != 1 || PasscodeView.this.retryTextView.getVisibility() == 0 || PasscodeView.this.passwordEditText == null) {
                        return;
                    }
                    PasscodeView.this.passwordEditText.requestFocus();
                    AndroidUtilities.showKeyboard(PasscodeView.this.passwordEditText);
                }
            });
            animatorSet2.start();
            AnimatorSet animatorSet4 = new AnimatorSet();
            animatorSet4.setDuration(332L);
            if (!AndroidUtilities.isTablet()) {
                i = 2;
                if (PasscodeView.this.getContext().getResources().getConfiguration().orientation == 2) {
                    if (PasscodeView.passcodeType == 0) {
                        i4 /= 2;
                    }
                    i2 = i4 / 2;
                    iDp = AndroidUtilities.dp(30.0f);
                }
                float f4 = i2 - iDp;
                RLottieImageView rLottieImageView = PasscodeView.this.imageView;
                Property property5 = View.TRANSLATION_X;
                float[] fArr5 = new float[i];
                fArr5[0] = this.val$x - AndroidUtilities.dp(29.0f);
                fArr5[1] = f4;
                animatorSet4.playTogether(ObjectAnimator.ofFloat(rLottieImageView, (Property<RLottieImageView, Float>) property5, fArr5), ObjectAnimator.ofFloat(PasscodeView.this.imageView, (Property<RLottieImageView, Float>) View.TRANSLATION_Y, this.val$y - AndroidUtilities.dp(29.0f), PasscodeView.this.imageY), ObjectAnimator.ofFloat(PasscodeView.this.imageView, (Property<RLottieImageView, Float>) View.SCALE_X, 0.5f, 1.0f), ObjectAnimator.ofFloat(PasscodeView.this.imageView, (Property<RLottieImageView, Float>) View.SCALE_Y, 0.5f, 1.0f));
                animatorSet4.setInterpolator(CubicBezierInterpolator.EASE_OUT);
                animatorSet4.start();
            }
            i = 2;
            i2 = i4 / i;
            iDp = AndroidUtilities.dp(29.0f);
            float f42 = i2 - iDp;
            RLottieImageView rLottieImageView2 = PasscodeView.this.imageView;
            Property property52 = View.TRANSLATION_X;
            float[] fArr52 = new float[i];
            fArr52[0] = this.val$x - AndroidUtilities.dp(29.0f);
            fArr52[1] = f42;
            animatorSet4.playTogether(ObjectAnimator.ofFloat(rLottieImageView2, (Property<RLottieImageView, Float>) property52, fArr52), ObjectAnimator.ofFloat(PasscodeView.this.imageView, (Property<RLottieImageView, Float>) View.TRANSLATION_Y, this.val$y - AndroidUtilities.dp(29.0f), PasscodeView.this.imageY), ObjectAnimator.ofFloat(PasscodeView.this.imageView, (Property<RLottieImageView, Float>) View.SCALE_X, 0.5f, 1.0f), ObjectAnimator.ofFloat(PasscodeView.this.imageView, (Property<RLottieImageView, Float>) View.SCALE_Y, 0.5f, 1.0f));
            animatorSet4.setInterpolator(CubicBezierInterpolator.EASE_OUT);
            animatorSet4.start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onGlobalLayout$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onGlobalLayout$0$PasscodeView$10() {
            PasscodeView.this.imageView.performHapticFeedback(3, 2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onGlobalLayout$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onGlobalLayout$1$PasscodeView$10(double d, ValueAnimator valueAnimator) {
            double animatedFraction = valueAnimator.getAnimatedFraction();
            Double.isNaN(animatedFraction);
            double d2 = d * animatedFraction;
            int i = 0;
            while (i < PasscodeView.this.innerAnimators.size()) {
                InnerAnimator innerAnimator = (InnerAnimator) PasscodeView.this.innerAnimators.get(i);
                if (innerAnimator.startRadius <= d2) {
                    innerAnimator.animatorSet.start();
                    PasscodeView.this.innerAnimators.remove(i);
                    i--;
                }
                i++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showFingerprintError(CharSequence error) {
        this.fingerprintImageView.setImageResource(R.drawable.ic_fingerprint_error);
        this.fingerprintStatusTextView.setText(error);
        this.fingerprintStatusTextView.setTextColor(-765666);
        Vibrator vibrator = (Vibrator) getContext().getSystemService("vibrator");
        if (vibrator != null) {
            vibrator.vibrate(200L);
        }
        AndroidUtilities.shakeView(this.fingerprintStatusTextView, 2.0f, 0);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int iDp;
        int i;
        FrameLayout.LayoutParams layoutParams;
        int iDp2;
        FrameLayout.LayoutParams layoutParams2;
        int iDp3;
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int i2 = AndroidUtilities.displaySize.y;
        int i3 = Build.VERSION.SDK_INT;
        int i4 = 0;
        int iDp4 = i2 - (i3 >= 21 ? 0 : AndroidUtilities.statusBarHeight);
        if (!AndroidUtilities.isTablet() && getContext().getResources().getConfiguration().orientation == 2) {
            this.imageView.setTranslationX(((passcodeType == 0 ? size / 2 : size) / 2) - AndroidUtilities.dp(29.0f));
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.passwordFrameLayout.getLayoutParams();
            layoutParams3.width = passcodeType == 0 ? size / 2 : size;
            layoutParams3.height = AndroidUtilities.dp(140.0f);
            layoutParams3.topMargin = ((iDp4 - AndroidUtilities.dp(140.0f)) / 2) + (passcodeType == 0 ? AndroidUtilities.dp(40.0f) : 0);
            this.passwordFrameLayout.setLayoutParams(layoutParams3);
            layoutParams = (FrameLayout.LayoutParams) this.numbersFrameLayout.getLayoutParams();
            layoutParams.height = iDp4;
            int i5 = size / 2;
            layoutParams.leftMargin = i5;
            layoutParams.topMargin = (iDp4 - iDp4) + (i3 >= 21 ? AndroidUtilities.statusBarHeight : 0);
            layoutParams.width = i5;
            this.numbersFrameLayout.setLayoutParams(layoutParams);
        } else {
            this.imageView.setTranslationX((size / 2) - AndroidUtilities.dp(29.0f));
            if (AndroidUtilities.isTablet()) {
                if (size > AndroidUtilities.dp(498.0f)) {
                    iDp2 = (size - AndroidUtilities.dp(498.0f)) / 2;
                    size = AndroidUtilities.dp(498.0f);
                } else {
                    iDp2 = 0;
                }
                if (iDp4 > AndroidUtilities.dp(528.0f)) {
                    int i6 = iDp2;
                    iDp = (iDp4 - AndroidUtilities.dp(528.0f)) / 2;
                    iDp4 = AndroidUtilities.dp(528.0f);
                    i = i6;
                } else {
                    i = iDp2;
                    iDp = 0;
                }
            } else {
                iDp = 0;
                i = 0;
            }
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.passwordFrameLayout.getLayoutParams();
            int i7 = iDp4 / 3;
            layoutParams4.height = (passcodeType == 0 ? AndroidUtilities.dp(40.0f) : 0) + i7;
            layoutParams4.width = size;
            layoutParams4.topMargin = iDp;
            layoutParams4.leftMargin = i;
            this.passwordFrameLayout.setTag(Integer.valueOf(iDp));
            this.passwordFrameLayout.setLayoutParams(layoutParams4);
            layoutParams = (FrameLayout.LayoutParams) this.numbersFrameLayout.getLayoutParams();
            layoutParams.height = i7 * 2;
            layoutParams.leftMargin = i;
            if (AndroidUtilities.isTablet()) {
                layoutParams.topMargin = (iDp4 - layoutParams.height) + iDp + AndroidUtilities.dp(20.0f);
            } else {
                layoutParams.topMargin = (iDp4 - layoutParams.height) + iDp + (passcodeType == 0 ? AndroidUtilities.dp(40.0f) : 0);
            }
            layoutParams.width = size;
            this.numbersFrameLayout.setLayoutParams(layoutParams);
        }
        int iDp5 = (layoutParams.width - (AndroidUtilities.dp(50.0f) * 3)) / 4;
        int iDp6 = (layoutParams.height - (AndroidUtilities.dp(50.0f) * 4)) / 5;
        while (i4 < 12) {
            int i8 = 11;
            if (i4 == 0) {
                i8 = 10;
            } else if (i4 != 10) {
                i8 = i4 == 11 ? 9 : i4 - 1;
            }
            int i9 = i8 / 3;
            int i10 = i8 % 3;
            if (i4 < 10) {
                TextView textView = this.numberTextViews.get(i4);
                TextView textView2 = this.lettersTextViews.get(i4);
                layoutParams2 = (FrameLayout.LayoutParams) textView.getLayoutParams();
                FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) textView2.getLayoutParams();
                iDp3 = ((AndroidUtilities.dp(50.0f) + iDp6) * i9) + iDp6;
                layoutParams2.topMargin = iDp3;
                layoutParams5.topMargin = iDp3;
                int iDp7 = ((AndroidUtilities.dp(50.0f) + iDp5) * i10) + iDp5;
                layoutParams2.leftMargin = iDp7;
                layoutParams5.leftMargin = iDp7;
                layoutParams5.topMargin += AndroidUtilities.dp(40.0f);
                textView.setLayoutParams(layoutParams2);
                textView2.setLayoutParams(layoutParams5);
            } else if (i4 == 10) {
                layoutParams2 = (FrameLayout.LayoutParams) this.eraseView.getLayoutParams();
                int iDp8 = ((AndroidUtilities.dp(50.0f) + iDp6) * i9) + iDp6 + AndroidUtilities.dp(8.0f);
                layoutParams2.topMargin = iDp8;
                layoutParams2.leftMargin = ((AndroidUtilities.dp(50.0f) + iDp5) * i10) + iDp5;
                iDp3 = iDp8 - AndroidUtilities.dp(8.0f);
                this.eraseView.setLayoutParams(layoutParams2);
            } else {
                layoutParams2 = (FrameLayout.LayoutParams) this.fingerprintView.getLayoutParams();
                int iDp9 = ((AndroidUtilities.dp(50.0f) + iDp6) * i9) + iDp6 + AndroidUtilities.dp(8.0f);
                layoutParams2.topMargin = iDp9;
                layoutParams2.leftMargin = ((AndroidUtilities.dp(50.0f) + iDp5) * i10) + iDp5;
                iDp3 = iDp9 - AndroidUtilities.dp(8.0f);
                this.fingerprintView.setLayoutParams(layoutParams2);
            }
            FrameLayout frameLayout = this.numberFrameLayouts.get(i4);
            FrameLayout.LayoutParams layoutParams6 = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
            layoutParams6.topMargin = iDp3 - AndroidUtilities.dp(17.0f);
            layoutParams6.leftMargin = layoutParams2.leftMargin - AndroidUtilities.dp(25.0f);
            frameLayout.setLayoutParams(layoutParams6);
            i4++;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        View rootView = getRootView();
        int height = (rootView.getHeight() - AndroidUtilities.statusBarHeight) - AndroidUtilities.getViewInset(rootView);
        getWindowVisibleDisplayFrame(this.rect);
        android.graphics.Rect rect = this.rect;
        this.keyboardHeight = height - (rect.bottom - rect.top);
        if (passcodeType == 1 && (AndroidUtilities.isTablet() || getContext().getResources().getConfiguration().orientation != 2)) {
            int iIntValue = this.passwordFrameLayout.getTag() != null ? ((Integer) this.passwordFrameLayout.getTag()).intValue() : 0;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.passwordFrameLayout.getLayoutParams();
            layoutParams.topMargin = ((iIntValue + layoutParams.height) - (this.keyboardHeight / 2)) - (Build.VERSION.SDK_INT >= 21 ? AndroidUtilities.statusBarHeight : 0);
            this.passwordFrameLayout.setLayoutParams(layoutParams);
        }
        super.onLayout(changed, left, top, right, bottom);
        this.passcodeTextView.getLocationInWindow(this.pos);
        if (!AndroidUtilities.isTablet() && getContext().getResources().getConfiguration().orientation == 2) {
            RLottieImageView rLottieImageView = this.imageView;
            int iDp = this.pos[1] - AndroidUtilities.dp(100.0f);
            this.imageY = iDp;
            rLottieImageView.setTranslationY(iDp);
            return;
        }
        RLottieImageView rLottieImageView2 = this.imageView;
        int iDp2 = this.pos[1] - AndroidUtilities.dp(100.0f);
        this.imageY = iDp2;
        rLottieImageView2.setTranslationY(iDp2);
    }

    private void initConfig() {
        if (this.isChatLock) {
            passcodeRetryInMs = SharedConfig.chatLockPasscodeRetryInMs;
            passcodeType = SharedConfig.chatLockPasscodeType;
            badPasscodeTries = SharedConfig.chatLockBadPasscodeTries;
            useFingerprint = SharedConfig.chatLockUseFingerprint;
            lastUptimeMillis = SharedConfig.chatLockLastUptimeMillis;
            return;
        }
        passcodeRetryInMs = SharedConfig.passcodeRetryInMs;
        passcodeType = SharedConfig.passcodeType;
        badPasscodeTries = SharedConfig.badPasscodeTries;
        useFingerprint = SharedConfig.useFingerprint;
        lastUptimeMillis = SharedConfig.lastUptimeMillis;
    }

    private void saveConfig() {
        if (this.isChatLock) {
            SharedConfig.chatLockPasscodeRetryInMs = passcodeRetryInMs;
            SharedConfig.chatLockPasscodeType = passcodeType;
            SharedConfig.chatLockBadPasscodeTries = badPasscodeTries;
            SharedConfig.chatLockUseFingerprint = useFingerprint;
            SharedConfig.chatLockLastUptimeMillis = lastUptimeMillis;
        } else {
            SharedConfig.passcodeRetryInMs = passcodeRetryInMs;
            SharedConfig.passcodeType = passcodeType;
            SharedConfig.badPasscodeTries = badPasscodeTries;
            SharedConfig.useFingerprint = useFingerprint;
            SharedConfig.lastUptimeMillis = lastUptimeMillis;
        }
        SharedConfig.saveConfig();
    }

    private boolean checkPasscode(String passcode) {
        if (this.isChatLock) {
            return SharedConfig.checkChatLockPasscode(passcode);
        }
        return SharedConfig.checkPasscode(passcode);
    }

    private void increaseBadPasscodeTries() {
        if (this.isChatLock) {
            SharedConfig.increaseChatLockBadPasscodeTries();
        } else {
            SharedConfig.increaseBadPasscodeTries();
        }
    }

    public void dismiss() {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$PasscodeView$J9ztuiLe20ioexbxGpDm9i3Falk
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$dismiss$9$PasscodeView();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$dismiss$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$dismiss$9$PasscodeView() {
        PasscodeViewDelegate passcodeViewDelegate;
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(200L);
        animatorSet.playTogether(ObjectAnimator.ofFloat(this, (Property<PasscodeView, Float>) View.TRANSLATION_Y, AndroidUtilities.dp(20.0f)), ObjectAnimator.ofFloat(this, (Property<PasscodeView, Float>) View.ALPHA, AndroidUtilities.dp(0.0f)));
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.PasscodeView.11
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                PasscodeView.this.setVisibility(8);
            }
        });
        animatorSet.start();
        if (!this.isChatLock || (passcodeViewDelegate = this.delegate) == null) {
            return;
        }
        passcodeViewDelegate.onFinish();
    }
}
