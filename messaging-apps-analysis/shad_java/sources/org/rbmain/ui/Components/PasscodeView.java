package org.rbmain.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Typeface;
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
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.os.CancellationSignal;
import com.facebook.stetho.websocket.CloseCodes;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import java.util.ArrayList;
import java.util.Locale;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.SharedConfig;
import org.rbmain.messenger.support.fingerprint.FingerprintManagerCompat;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.Theme;

/* loaded from: classes5.dex */
public class PasscodeView extends FrameLayout {
    private static final int[] ids = {R.id.passcode_btn_0, R.id.passcode_btn_1, R.id.passcode_btn_2, R.id.passcode_btn_3, R.id.passcode_btn_4, R.id.passcode_btn_5, R.id.passcode_btn_6, R.id.passcode_btn_7, R.id.passcode_btn_8, R.id.passcode_btn_9, R.id.passcode_btn_backspace};
    private Drawable backgroundDrawable;
    private FrameLayout backgroundFrameLayout;
    private CancellationSignal cancellationSignal;
    private ImageView checkImage;
    private Runnable checkRunnable;
    private PasscodeViewDelegate delegate;
    private ImageView eraseView;
    private AlertDialog fingerprintDialog;
    private ImageView fingerprintImageView;
    private TextView fingerprintStatusTextView;
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
    private android.graphics.Rect rect;
    private TextView retryTextView;
    private boolean selfCancelled;

    public interface PasscodeViewDelegate {
        void didAcceptedPassword();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$onShow$6(View view, MotionEvent motionEvent) {
        return true;
    }

    private class AnimatingTextView extends FrameLayout {
        private ArrayList<TextView> characterTextViews;
        private AnimatorSet currentAnimation;
        private Runnable dotRunnable;
        private ArrayList<TextView> dotTextViews;
        private StringBuilder stringBuilder;

        public AnimatingTextView(PasscodeView passcodeView, Context context) {
            super(context);
            this.characterTextViews = new ArrayList<>(4);
            this.dotTextViews = new ArrayList<>(4);
            this.stringBuilder = new StringBuilder(4);
            for (int i = 0; i < 4; i++) {
                TextView textView = new TextView(context);
                textView.setTextColor(-1);
                textView.setTextSize(1, 36.0f);
                textView.setGravity(17);
                textView.setAlpha(0.0f);
                textView.setPivotX(AndroidUtilities.dp(25.0f));
                textView.setPivotY(AndroidUtilities.dp(25.0f));
                addView(textView);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) textView.getLayoutParams();
                layoutParams.width = AndroidUtilities.dp(50.0f);
                layoutParams.height = AndroidUtilities.dp(50.0f);
                layoutParams.gravity = 51;
                textView.setLayoutParams(layoutParams);
                this.characterTextViews.add(textView);
                TextView textView2 = new TextView(context);
                textView2.setTextColor(-1);
                textView2.setTextSize(1, 36.0f);
                textView2.setGravity(17);
                textView2.setAlpha(0.0f);
                textView2.setText("•");
                textView2.setPivotX(AndroidUtilities.dp(25.0f));
                textView2.setPivotY(AndroidUtilities.dp(25.0f));
                addView(textView2);
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) textView2.getLayoutParams();
                layoutParams2.width = AndroidUtilities.dp(50.0f);
                layoutParams2.height = AndroidUtilities.dp(50.0f);
                layoutParams2.gravity = 51;
                textView2.setLayoutParams(layoutParams2);
                this.dotTextViews.add(textView2);
            }
        }

        private int getXForTextView(int i) {
            return (((getMeasuredWidth() - (this.stringBuilder.length() * AndroidUtilities.dp(30.0f))) / 2) + (i * AndroidUtilities.dp(30.0f))) - AndroidUtilities.dp(10.0f);
        }

        public void appendCharacter(String str) {
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
            this.stringBuilder.append(str);
            TextView textView = this.characterTextViews.get(length);
            textView.setText(str);
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
            Runnable runnable2 = new Runnable() { // from class: org.rbmain.ui.Components.PasscodeView.AnimatingTextView.1
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
                    AnimatingTextView.this.currentAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.PasscodeView.AnimatingTextView.1.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            if (AnimatingTextView.this.currentAnimation == null || !AnimatingTextView.this.currentAnimation.equals(animator)) {
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
            this.currentAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.PasscodeView.AnimatingTextView.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (AnimatingTextView.this.currentAnimation == null || !AnimatingTextView.this.currentAnimation.equals(animator)) {
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

        public void eraseLastCharacter() {
            if (this.stringBuilder.length() == 0) {
                return;
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
            this.currentAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.PasscodeView.AnimatingTextView.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (AnimatingTextView.this.currentAnimation == null || !AnimatingTextView.this.currentAnimation.equals(animator)) {
                        return;
                    }
                    AnimatingTextView.this.currentAnimation = null;
                }
            });
            this.currentAnimation.start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void eraseAllCharacters(boolean z) {
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
            if (!z) {
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
            this.currentAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.PasscodeView.AnimatingTextView.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (AnimatingTextView.this.currentAnimation == null || !AnimatingTextView.this.currentAnimation.equals(animator)) {
                        return;
                    }
                    AnimatingTextView.this.currentAnimation = null;
                }
            });
            this.currentAnimation.start();
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
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
            for (int i5 = 0; i5 < 4; i5++) {
                if (i5 < this.stringBuilder.length()) {
                    TextView textView = this.characterTextViews.get(i5);
                    textView.setAlpha(0.0f);
                    textView.setScaleX(1.0f);
                    textView.setScaleY(1.0f);
                    textView.setTranslationY(0.0f);
                    textView.setTranslationX(getXForTextView(i5));
                    TextView textView2 = this.dotTextViews.get(i5);
                    textView2.setAlpha(1.0f);
                    textView2.setScaleX(1.0f);
                    textView2.setScaleY(1.0f);
                    textView2.setTranslationY(0.0f);
                    textView2.setTranslationX(getXForTextView(i5));
                } else {
                    this.characterTextViews.get(i5).setAlpha(0.0f);
                    this.dotTextViews.get(i5).setAlpha(0.0f);
                }
            }
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    public PasscodeView(Context context) {
        super(context);
        char c = 0;
        this.keyboardHeight = 0;
        this.rect = new android.graphics.Rect();
        this.checkRunnable = new Runnable() { // from class: org.rbmain.ui.Components.PasscodeView.6
            @Override // java.lang.Runnable
            public void run() {
                PasscodeView.this.checkRetryTextView();
                AndroidUtilities.runOnUIThread(PasscodeView.this.checkRunnable, 100L);
            }
        };
        setWillNotDraw(false);
        setVisibility(8);
        FrameLayout frameLayout = new FrameLayout(context);
        this.backgroundFrameLayout = frameLayout;
        addView(frameLayout);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.backgroundFrameLayout.getLayoutParams();
        int i = -1;
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.backgroundFrameLayout.setLayoutParams(layoutParams);
        FrameLayout frameLayout2 = new FrameLayout(context);
        this.passwordFrameLayout = frameLayout2;
        addView(frameLayout2);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.passwordFrameLayout.getLayoutParams();
        layoutParams2.width = -1;
        layoutParams2.height = -1;
        layoutParams2.gravity = 51;
        this.passwordFrameLayout.setLayoutParams(layoutParams2);
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(R.drawable.ic_notif_shad);
        this.passwordFrameLayout.addView(imageView);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) imageView.getLayoutParams();
        if (AndroidUtilities.density < 1.0f) {
            layoutParams3.width = AndroidUtilities.dp(30.0f);
            layoutParams3.height = AndroidUtilities.dp(30.0f);
        } else {
            layoutParams3.width = AndroidUtilities.dp(40.0f);
            layoutParams3.height = AndroidUtilities.dp(40.0f);
        }
        layoutParams3.gravity = 81;
        layoutParams3.bottomMargin = AndroidUtilities.dp(100.0f);
        imageView.setLayoutParams(layoutParams3);
        TextView textView = new TextView(context);
        this.passcodeTextView = textView;
        textView.setTextColor(-1);
        this.passcodeTextView.setTextSize(1, 14.0f);
        this.passcodeTextView.setGravity(1);
        this.passwordFrameLayout.addView(this.passcodeTextView, LayoutHelper.createFrame(-2, -2.0f, 81, 0.0f, 0.0f, 0.0f, 62.0f));
        TextView textView2 = new TextView(context);
        this.retryTextView = textView2;
        textView2.setTextColor(-1);
        this.retryTextView.setTextSize(1, 15.0f);
        this.retryTextView.setGravity(1);
        this.retryTextView.setVisibility(4);
        addView(this.retryTextView, LayoutHelper.createFrame(-2, -2, 17));
        AnimatingTextView animatingTextView = new AnimatingTextView(this, context);
        this.passwordEditText2 = animatingTextView;
        this.passwordFrameLayout.addView(animatingTextView);
        FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.passwordEditText2.getLayoutParams();
        layoutParams4.height = -2;
        layoutParams4.width = -1;
        layoutParams4.leftMargin = AndroidUtilities.dp(70.0f);
        layoutParams4.rightMargin = AndroidUtilities.dp(70.0f);
        layoutParams4.bottomMargin = AndroidUtilities.dp(6.0f);
        layoutParams4.gravity = 81;
        this.passwordEditText2.setLayoutParams(layoutParams4);
        EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(context);
        this.passwordEditText = editTextBoldCursor;
        editTextBoldCursor.setTextSize(1, 36.0f);
        this.passwordEditText.setTextColor(-1);
        this.passwordEditText.setMaxLines(1);
        this.passwordEditText.setLines(1);
        this.passwordEditText.setGravity(1);
        this.passwordEditText.setSingleLine(true);
        this.passwordEditText.setImeOptions(6);
        this.passwordEditText.setTypeface(Typeface.DEFAULT);
        this.passwordEditText.setBackgroundDrawable(null);
        this.passwordEditText.setCursorColor(-1);
        this.passwordEditText.setCursorSize(AndroidUtilities.dp(32.0f));
        this.passwordFrameLayout.addView(this.passwordEditText);
        FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) this.passwordEditText.getLayoutParams();
        layoutParams5.height = -2;
        layoutParams5.width = -1;
        layoutParams5.leftMargin = AndroidUtilities.dp(70.0f);
        layoutParams5.rightMargin = AndroidUtilities.dp(70.0f);
        layoutParams5.gravity = 81;
        this.passwordEditText.setLayoutParams(layoutParams5);
        this.passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: org.rbmain.ui.Components.PasscodeView$$ExternalSyntheticLambda5
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView3, int i2, KeyEvent keyEvent) {
                return this.f$0.lambda$new$0(textView3, i2, keyEvent);
            }
        });
        this.passwordEditText.addTextChangedListener(new TextWatcher() { // from class: org.rbmain.ui.Components.PasscodeView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (PasscodeView.this.passwordEditText.length() == 4 && SharedConfig.passcodeType == 0) {
                    PasscodeView.this.processDone(false);
                }
            }
        });
        this.passwordEditText.setCustomSelectionActionModeCallback(new ActionMode.Callback(this) { // from class: org.rbmain.ui.Components.PasscodeView.2
            @Override // android.view.ActionMode.Callback
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                return false;
            }

            @Override // android.view.ActionMode.Callback
            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            @Override // android.view.ActionMode.Callback
            public void onDestroyActionMode(ActionMode actionMode) {
            }

            @Override // android.view.ActionMode.Callback
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }
        });
        ImageView imageView2 = new ImageView(context);
        this.checkImage = imageView2;
        imageView2.setImageResource(R.drawable.passcode_check);
        this.checkImage.setScaleType(ImageView.ScaleType.CENTER);
        this.checkImage.setBackgroundResource(R.drawable.bar_selector_lock);
        this.passwordFrameLayout.addView(this.checkImage);
        FrameLayout.LayoutParams layoutParams6 = (FrameLayout.LayoutParams) this.checkImage.getLayoutParams();
        layoutParams6.width = AndroidUtilities.dp(60.0f);
        layoutParams6.height = AndroidUtilities.dp(60.0f);
        layoutParams6.bottomMargin = AndroidUtilities.dp(4.0f);
        layoutParams6.rightMargin = AndroidUtilities.dp(10.0f);
        layoutParams6.gravity = 85;
        this.checkImage.setLayoutParams(layoutParams6);
        this.checkImage.setContentDescription(LocaleController.getString("Done", R.string.Done));
        this.checkImage.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.PasscodeView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$1(view);
            }
        });
        FrameLayout frameLayout3 = new FrameLayout(context);
        frameLayout3.setBackgroundColor(654311423);
        this.passwordFrameLayout.addView(frameLayout3);
        FrameLayout.LayoutParams layoutParams7 = (FrameLayout.LayoutParams) frameLayout3.getLayoutParams();
        layoutParams7.width = -1;
        layoutParams7.height = AndroidUtilities.dp(1.0f);
        layoutParams7.gravity = 83;
        layoutParams7.leftMargin = AndroidUtilities.dp(20.0f);
        layoutParams7.rightMargin = AndroidUtilities.dp(20.0f);
        frameLayout3.setLayoutParams(layoutParams7);
        FrameLayout frameLayout4 = new FrameLayout(context);
        this.numbersFrameLayout = frameLayout4;
        addView(frameLayout4);
        FrameLayout.LayoutParams layoutParams8 = (FrameLayout.LayoutParams) this.numbersFrameLayout.getLayoutParams();
        layoutParams8.width = -1;
        layoutParams8.height = -1;
        layoutParams8.gravity = 51;
        this.numbersFrameLayout.setLayoutParams(layoutParams8);
        this.lettersTextViews = new ArrayList<>(10);
        this.numberTextViews = new ArrayList<>(10);
        this.numberFrameLayouts = new ArrayList<>(10);
        int i2 = 0;
        while (i2 < 10) {
            TextView textView3 = new TextView(context);
            textView3.setTextColor(i);
            textView3.setTextSize(1, 36.0f);
            textView3.setGravity(17);
            Locale locale = Locale.US;
            Object[] objArr = new Object[1];
            objArr[c] = Integer.valueOf(i2);
            textView3.setText(String.format(locale, "%d", objArr));
            this.numbersFrameLayout.addView(textView3);
            FrameLayout.LayoutParams layoutParams9 = (FrameLayout.LayoutParams) textView3.getLayoutParams();
            layoutParams9.width = AndroidUtilities.dp(50.0f);
            layoutParams9.height = AndroidUtilities.dp(50.0f);
            layoutParams9.gravity = 51;
            textView3.setLayoutParams(layoutParams9);
            textView3.setImportantForAccessibility(2);
            this.numberTextViews.add(textView3);
            TextView textView4 = new TextView(context);
            textView4.setTextSize(1, 12.0f);
            textView4.setTextColor(ConnectionsManager.DEFAULT_DATACENTER_ID);
            textView4.setGravity(17);
            this.numbersFrameLayout.addView(textView4);
            FrameLayout.LayoutParams layoutParams10 = (FrameLayout.LayoutParams) textView4.getLayoutParams();
            layoutParams10.width = AndroidUtilities.dp(50.0f);
            layoutParams10.height = AndroidUtilities.dp(20.0f);
            layoutParams10.gravity = 51;
            textView4.setLayoutParams(layoutParams10);
            textView4.setImportantForAccessibility(2);
            if (i2 == 0) {
                textView4.setText("+");
            } else {
                switch (i2) {
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
            i2++;
            c = 0;
            i = -1;
        }
        ImageView imageView3 = new ImageView(context);
        this.eraseView = imageView3;
        imageView3.setScaleType(ImageView.ScaleType.CENTER);
        this.eraseView.setImageResource(R.drawable.passcode_delete);
        this.numbersFrameLayout.addView(this.eraseView);
        FrameLayout.LayoutParams layoutParams11 = (FrameLayout.LayoutParams) this.eraseView.getLayoutParams();
        layoutParams11.width = AndroidUtilities.dp(50.0f);
        layoutParams11.height = AndroidUtilities.dp(50.0f);
        layoutParams11.gravity = 51;
        this.eraseView.setLayoutParams(layoutParams11);
        for (int i3 = 0; i3 < 11; i3++) {
            FrameLayout frameLayout5 = new FrameLayout(this, context) { // from class: org.rbmain.ui.Components.PasscodeView.3
                @Override // android.view.View
                public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
                    super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
                    accessibilityNodeInfo.setClassName("android.widget.Button");
                }
            };
            frameLayout5.setBackgroundResource(R.drawable.bar_selector_lock);
            frameLayout5.setTag(Integer.valueOf(i3));
            if (i3 == 10) {
                frameLayout5.setOnLongClickListener(new View.OnLongClickListener() { // from class: org.rbmain.ui.Components.PasscodeView$$ExternalSyntheticLambda3
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view) {
                        return this.f$0.lambda$new$2(view);
                    }
                });
                frameLayout5.setContentDescription(LocaleController.getString("AccDescrBackspace", R.string.AccDescrBackspace));
                setNextFocus(frameLayout5, R.id.passcode_btn_1);
            } else {
                frameLayout5.setContentDescription(i3 + BuildConfig.FLAVOR);
                if (i3 == 0) {
                    setNextFocus(frameLayout5, R.id.passcode_btn_backspace);
                } else if (i3 == 9) {
                    setNextFocus(frameLayout5, R.id.passcode_btn_0);
                } else {
                    setNextFocus(frameLayout5, ids[i3 + 1]);
                }
            }
            frameLayout5.setId(ids[i3]);
            frameLayout5.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.PasscodeView$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$3(view);
                }
            });
            this.numberFrameLayouts.add(frameLayout5);
        }
        for (int i4 = 10; i4 >= 0; i4--) {
            FrameLayout frameLayout6 = this.numberFrameLayouts.get(i4);
            this.numbersFrameLayout.addView(frameLayout6);
            FrameLayout.LayoutParams layoutParams12 = (FrameLayout.LayoutParams) frameLayout6.getLayoutParams();
            layoutParams12.width = AndroidUtilities.dp(100.0f);
            layoutParams12.height = AndroidUtilities.dp(100.0f);
            layoutParams12.gravity = 51;
            frameLayout6.setLayoutParams(layoutParams12);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$0(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        processDone(false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(View view) {
        processDone(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$2(View view) {
        this.passwordEditText.setText(BuildConfig.FLAVOR);
        this.passwordEditText2.eraseAllCharacters(true);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$3(View view) {
        switch (((Integer) view.getTag()).intValue()) {
            case 0:
                this.passwordEditText2.appendCharacter("0");
                break;
            case 1:
                this.passwordEditText2.appendCharacter("1");
                break;
            case 2:
                this.passwordEditText2.appendCharacter("2");
                break;
            case 3:
                this.passwordEditText2.appendCharacter("3");
                break;
            case 4:
                this.passwordEditText2.appendCharacter("4");
                break;
            case 5:
                this.passwordEditText2.appendCharacter("5");
                break;
            case 6:
                this.passwordEditText2.appendCharacter("6");
                break;
            case 7:
                this.passwordEditText2.appendCharacter("7");
                break;
            case 8:
                this.passwordEditText2.appendCharacter("8");
                break;
            case 9:
                this.passwordEditText2.appendCharacter("9");
                break;
            case 10:
                this.passwordEditText2.eraseLastCharacter();
                break;
        }
        if (this.passwordEditText2.length() == 4) {
            processDone(false);
        }
    }

    private void setNextFocus(View view, int i) {
        view.setNextFocusForwardId(i);
        if (Build.VERSION.SDK_INT >= 22) {
            view.setAccessibilityTraversalBefore(i);
        }
    }

    public void setDelegate(PasscodeViewDelegate passcodeViewDelegate) {
        this.delegate = passcodeViewDelegate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processDone(boolean z) {
        String string;
        if (!z) {
            if (SharedConfig.passcodeRetryInMs > 0) {
                return;
            }
            int i = SharedConfig.passcodeType;
            if (i == 0) {
                string = this.passwordEditText2.getString();
            } else {
                string = i == 1 ? this.passwordEditText.getText().toString() : BuildConfig.FLAVOR;
            }
            if (string.length() == 0) {
                onPasscodeError();
                return;
            }
            if (!SharedConfig.checkPasscode(string)) {
                SharedConfig.increaseBadPasscodeTries();
                if (SharedConfig.passcodeRetryInMs > 0) {
                    checkRetryTextView();
                }
                this.passwordEditText.setText(BuildConfig.FLAVOR);
                this.passwordEditText2.eraseAllCharacters(true);
                onPasscodeError();
                return;
            }
        }
        SharedConfig.badPasscodeTries = 0;
        this.passwordEditText.clearFocus();
        AndroidUtilities.hideKeyboard(this.passwordEditText);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(200L);
        animatorSet.playTogether(ObjectAnimator.ofFloat(this, (Property<PasscodeView, Float>) View.TRANSLATION_Y, AndroidUtilities.dp(20.0f)), ObjectAnimator.ofFloat(this, (Property<PasscodeView, Float>) View.ALPHA, AndroidUtilities.dp(0.0f)));
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.PasscodeView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PasscodeView.this.setVisibility(8);
            }
        });
        animatorSet.start();
        SharedConfig.appLocked = false;
        SharedConfig.saveConfig();
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.didSetPasscode, new Object[0]);
        setOnTouchListener(null);
        PasscodeViewDelegate passcodeViewDelegate = this.delegate;
        if (passcodeViewDelegate != null) {
            passcodeViewDelegate.didAcceptedPassword();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void shakeTextView(final float f, final int i) {
        if (i == 6) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.passcodeTextView, (Property<TextView, Float>) View.TRANSLATION_X, AndroidUtilities.dp(f)));
        animatorSet.setDuration(50L);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.PasscodeView.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PasscodeView passcodeView = PasscodeView.this;
                int i2 = i;
                passcodeView.shakeTextView(i2 == 5 ? 0.0f : -f, i2 + 1);
            }
        });
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkRetryTextView() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime > SharedConfig.lastUptimeMillis) {
            long j = SharedConfig.passcodeRetryInMs - (jElapsedRealtime - SharedConfig.lastUptimeMillis);
            SharedConfig.passcodeRetryInMs = j;
            if (j < 0) {
                SharedConfig.passcodeRetryInMs = 0L;
            }
        }
        SharedConfig.lastUptimeMillis = jElapsedRealtime;
        SharedConfig.saveConfig();
        long j2 = SharedConfig.passcodeRetryInMs;
        if (j2 > 0) {
            double d = j2;
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
                AndroidUtilities.cancelRunOnUIThread(this.checkRunnable);
                AndroidUtilities.runOnUIThread(this.checkRunnable, 100L);
                return;
            }
            return;
        }
        AndroidUtilities.cancelRunOnUIThread(this.checkRunnable);
        if (this.passwordFrameLayout.getVisibility() != 0) {
            this.retryTextView.setVisibility(4);
            this.passwordFrameLayout.setVisibility(0);
            int i = SharedConfig.passcodeType;
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
            if (SharedConfig.passcodeType == 1) {
                EditTextBoldCursor editTextBoldCursor = this.passwordEditText;
                if (editTextBoldCursor != null) {
                    editTextBoldCursor.requestFocus();
                    AndroidUtilities.showKeyboard(this.passwordEditText);
                }
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.PasscodeView$$ExternalSyntheticLambda6
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onResume$4();
                    }
                }, 200L);
            }
            checkFingerprint();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onResume$4() {
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
        Activity activity = (Activity) getContext();
        if (Build.VERSION.SDK_INT < 23 || activity == null || !SharedConfig.useFingerprint || ApplicationLoader.mainInterfacePaused) {
            return;
        }
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
                textView.setId(CloseCodes.NORMAL_CLOSURE);
                textView.setTextAppearance(android.R.style.TextAppearance.Material.Subhead);
                int i = Theme.key_dialogTextBlack;
                textView.setTextColor(Theme.getColor(i));
                textView.setText(LocaleController.getString("FingerprintInfo", R.string.FingerprintInfo));
                relativeLayout.addView(textView);
                RelativeLayout.LayoutParams layoutParamsCreateRelative = LayoutHelper.createRelative(-2, -2);
                layoutParamsCreateRelative.addRule(10);
                layoutParamsCreateRelative.addRule(20);
                textView.setLayoutParams(layoutParamsCreateRelative);
                ImageView imageView = new ImageView(getContext());
                this.fingerprintImageView = imageView;
                imageView.setImageResource(R.drawable.ic_fp_40px);
                this.fingerprintImageView.setId(1001);
                relativeLayout.addView(this.fingerprintImageView, LayoutHelper.createRelative(-2.0f, -2.0f, 0, 20, 0, 0, 20, 3, CloseCodes.NORMAL_CLOSURE));
                TextView textView2 = new TextView(getContext());
                this.fingerprintStatusTextView = textView2;
                textView2.setGravity(16);
                this.fingerprintStatusTextView.setText(LocaleController.getString("FingerprintHelp", R.string.FingerprintHelp));
                this.fingerprintStatusTextView.setTextAppearance(android.R.style.TextAppearance.Material.Body1);
                this.fingerprintStatusTextView.setTextColor(Theme.getColor(i) & 1124073471);
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
                builder.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: org.rbmain.ui.Components.PasscodeView$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        this.f$0.lambda$checkFingerprint$5(dialogInterface);
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
                fingerprintManagerCompatFrom.authenticate(null, 0, cancellationSignal, new FingerprintManagerCompat.AuthenticationCallback() { // from class: org.rbmain.ui.Components.PasscodeView.7
                    @Override // org.rbmain.messenger.support.fingerprint.FingerprintManagerCompat.AuthenticationCallback
                    public void onAuthenticationError(int i2, CharSequence charSequence) {
                        if (PasscodeView.this.selfCancelled || i2 == 5) {
                            return;
                        }
                        PasscodeView.this.showFingerprintError(charSequence);
                    }

                    @Override // org.rbmain.messenger.support.fingerprint.FingerprintManagerCompat.AuthenticationCallback
                    public void onAuthenticationHelp(int i2, CharSequence charSequence) {
                        PasscodeView.this.showFingerprintError(charSequence);
                    }

                    @Override // org.rbmain.messenger.support.fingerprint.FingerprintManagerCompat.AuthenticationCallback
                    public void onAuthenticationFailed() {
                        PasscodeView.this.showFingerprintError(LocaleController.getString("FingerprintNotRecognized", R.string.FingerprintNotRecognized));
                    }

                    @Override // org.rbmain.messenger.support.fingerprint.FingerprintManagerCompat.AuthenticationCallback
                    public void onAuthenticationSucceeded(FingerprintManagerCompat.AuthenticationResult authenticationResult) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkFingerprint$5(DialogInterface dialogInterface) {
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

    public void onShow() {
        View currentFocus;
        EditTextBoldCursor editTextBoldCursor;
        checkRetryTextView();
        Activity activity = (Activity) getContext();
        if (SharedConfig.passcodeType == 1) {
            if (this.retryTextView.getVisibility() != 0 && (editTextBoldCursor = this.passwordEditText) != null) {
                editTextBoldCursor.requestFocus();
                AndroidUtilities.showKeyboard(this.passwordEditText);
            }
        } else if (activity != null && (currentFocus = activity.getCurrentFocus()) != null) {
            currentFocus.clearFocus();
            AndroidUtilities.hideKeyboard(((Activity) getContext()).getCurrentFocus());
        }
        if (this.retryTextView.getVisibility() != 0) {
            checkFingerprint();
        }
        if (getVisibility() == 0) {
            return;
        }
        setAlpha(1.0f);
        setTranslationY(0.0f);
        if (Theme.isCustomTheme()) {
            this.backgroundDrawable = Theme.getCachedWallpaper();
            this.backgroundFrameLayout.setBackgroundColor(-1090519040);
        } else if ("d".equals(Theme.getSelectedBackgroundSlug())) {
            this.backgroundFrameLayout.setBackgroundColor(-11436898);
        } else {
            Drawable cachedWallpaper = Theme.getCachedWallpaper();
            this.backgroundDrawable = cachedWallpaper;
            if (cachedWallpaper != null) {
                this.backgroundFrameLayout.setBackgroundColor(-1090519040);
            } else {
                this.backgroundFrameLayout.setBackgroundColor(-11436898);
            }
        }
        this.passcodeTextView.setText(LocaleController.getString("EnterYourPasscode", R.string.EnterYourPasscode));
        int i = SharedConfig.passcodeType;
        if (i == 0) {
            if (this.retryTextView.getVisibility() != 0) {
                this.numbersFrameLayout.setVisibility(0);
            }
            this.passwordEditText.setVisibility(8);
            this.passwordEditText2.setVisibility(0);
            this.checkImage.setVisibility(8);
        } else if (i == 1) {
            this.passwordEditText.setFilters(new InputFilter[0]);
            this.passwordEditText.setInputType(129);
            this.numbersFrameLayout.setVisibility(8);
            this.passwordEditText.setFocusable(true);
            this.passwordEditText.setFocusableInTouchMode(true);
            this.passwordEditText.setVisibility(0);
            this.passwordEditText2.setVisibility(8);
            this.checkImage.setVisibility(0);
        }
        setVisibility(0);
        this.passwordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        this.passwordEditText.setText(BuildConfig.FLAVOR);
        this.passwordEditText2.eraseAllCharacters(false);
        setOnTouchListener(new View.OnTouchListener() { // from class: org.rbmain.ui.Components.PasscodeView$$ExternalSyntheticLambda4
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return PasscodeView.lambda$onShow$6(view, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showFingerprintError(CharSequence charSequence) {
        this.fingerprintImageView.setImageResource(R.drawable.ic_fingerprint_error);
        this.fingerprintStatusTextView.setText(charSequence);
        this.fingerprintStatusTextView.setTextColor(-765666);
        Vibrator vibrator = (Vibrator) getContext().getSystemService("vibrator");
        if (vibrator != null) {
            vibrator.vibrate(200L);
        }
        AndroidUtilities.shakeView(this.fingerprintStatusTextView, 2.0f, 0);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int iDp;
        int i3;
        FrameLayout.LayoutParams layoutParams;
        int iDp2;
        FrameLayout.LayoutParams layoutParams2;
        int iDp3;
        int size = View.MeasureSpec.getSize(i);
        int i4 = 0;
        int iDp4 = AndroidUtilities.displaySize.y - (Build.VERSION.SDK_INT >= 21 ? 0 : AndroidUtilities.statusBarHeight);
        if (!AndroidUtilities.isTablet() && getContext().getResources().getConfiguration().orientation == 2) {
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.passwordFrameLayout.getLayoutParams();
            layoutParams3.width = SharedConfig.passcodeType == 0 ? size / 2 : size;
            layoutParams3.height = AndroidUtilities.dp(140.0f);
            layoutParams3.topMargin = (iDp4 - AndroidUtilities.dp(140.0f)) / 2;
            this.passwordFrameLayout.setLayoutParams(layoutParams3);
            layoutParams = (FrameLayout.LayoutParams) this.numbersFrameLayout.getLayoutParams();
            layoutParams.height = iDp4;
            int i5 = size / 2;
            layoutParams.leftMargin = i5;
            layoutParams.topMargin = iDp4 - iDp4;
            layoutParams.width = i5;
            this.numbersFrameLayout.setLayoutParams(layoutParams);
        } else {
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
                    i3 = i6;
                } else {
                    i3 = iDp2;
                    iDp = 0;
                }
            } else {
                iDp = 0;
                i3 = 0;
            }
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.passwordFrameLayout.getLayoutParams();
            int i7 = iDp4 / 3;
            layoutParams4.height = i7;
            layoutParams4.width = size;
            layoutParams4.topMargin = iDp;
            layoutParams4.leftMargin = i3;
            this.passwordFrameLayout.setTag(Integer.valueOf(iDp));
            this.passwordFrameLayout.setLayoutParams(layoutParams4);
            FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) this.numbersFrameLayout.getLayoutParams();
            int i8 = i7 * 2;
            layoutParams5.height = i8;
            layoutParams5.leftMargin = i3;
            layoutParams5.topMargin = (iDp4 - i8) + iDp;
            layoutParams5.width = size;
            this.numbersFrameLayout.setLayoutParams(layoutParams5);
            layoutParams = layoutParams5;
        }
        int iDp5 = (layoutParams.width - (AndroidUtilities.dp(50.0f) * 3)) / 4;
        int iDp6 = (layoutParams.height - (AndroidUtilities.dp(50.0f) * 4)) / 5;
        while (true) {
            int i9 = 11;
            if (i4 < 11) {
                if (i4 == 0) {
                    i9 = 10;
                } else if (i4 != 10) {
                    i9 = i4 - 1;
                }
                int i10 = i9 / 3;
                int i11 = i9 % 3;
                if (i4 < 10) {
                    TextView textView = this.numberTextViews.get(i4);
                    TextView textView2 = this.lettersTextViews.get(i4);
                    layoutParams2 = (FrameLayout.LayoutParams) textView.getLayoutParams();
                    FrameLayout.LayoutParams layoutParams6 = (FrameLayout.LayoutParams) textView2.getLayoutParams();
                    iDp3 = ((AndroidUtilities.dp(50.0f) + iDp6) * i10) + iDp6;
                    layoutParams2.topMargin = iDp3;
                    layoutParams6.topMargin = iDp3;
                    int iDp7 = ((AndroidUtilities.dp(50.0f) + iDp5) * i11) + iDp5;
                    layoutParams2.leftMargin = iDp7;
                    layoutParams6.leftMargin = iDp7;
                    layoutParams6.topMargin += AndroidUtilities.dp(40.0f);
                    textView.setLayoutParams(layoutParams2);
                    textView2.setLayoutParams(layoutParams6);
                } else {
                    layoutParams2 = (FrameLayout.LayoutParams) this.eraseView.getLayoutParams();
                    int iDp8 = ((AndroidUtilities.dp(50.0f) + iDp6) * i10) + iDp6 + AndroidUtilities.dp(8.0f);
                    layoutParams2.topMargin = iDp8;
                    layoutParams2.leftMargin = ((AndroidUtilities.dp(50.0f) + iDp5) * i11) + iDp5;
                    iDp3 = iDp8 - AndroidUtilities.dp(8.0f);
                    this.eraseView.setLayoutParams(layoutParams2);
                }
                FrameLayout frameLayout = this.numberFrameLayouts.get(i4);
                FrameLayout.LayoutParams layoutParams7 = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
                layoutParams7.topMargin = iDp3 - AndroidUtilities.dp(17.0f);
                layoutParams7.leftMargin = layoutParams2.leftMargin - AndroidUtilities.dp(25.0f);
                frameLayout.setLayoutParams(layoutParams7);
                i4++;
            } else {
                super.onMeasure(i, i2);
                return;
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View rootView = getRootView();
        int height = (rootView.getHeight() - AndroidUtilities.statusBarHeight) - AndroidUtilities.getViewInset(rootView);
        getWindowVisibleDisplayFrame(this.rect);
        android.graphics.Rect rect = this.rect;
        this.keyboardHeight = height - (rect.bottom - rect.top);
        if (SharedConfig.passcodeType == 1 && (AndroidUtilities.isTablet() || getContext().getResources().getConfiguration().orientation != 2)) {
            int iIntValue = this.passwordFrameLayout.getTag() != null ? ((Integer) this.passwordFrameLayout.getTag()).intValue() : 0;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.passwordFrameLayout.getLayoutParams();
            layoutParams.topMargin = ((iIntValue + layoutParams.height) - (this.keyboardHeight / 2)) - (Build.VERSION.SDK_INT >= 21 ? AndroidUtilities.statusBarHeight : 0);
            this.passwordFrameLayout.setLayoutParams(layoutParams);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (getVisibility() != 0) {
            return;
        }
        Drawable drawable = this.backgroundDrawable;
        if (drawable != null) {
            if ((drawable instanceof ColorDrawable) || (drawable instanceof GradientDrawable)) {
                drawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
                this.backgroundDrawable.draw(canvas);
                return;
            }
            float measuredWidth = getMeasuredWidth() / this.backgroundDrawable.getIntrinsicWidth();
            float measuredHeight = (getMeasuredHeight() + this.keyboardHeight) / this.backgroundDrawable.getIntrinsicHeight();
            if (measuredWidth < measuredHeight) {
                measuredWidth = measuredHeight;
            }
            int iCeil = (int) Math.ceil(this.backgroundDrawable.getIntrinsicWidth() * measuredWidth);
            int iCeil2 = (int) Math.ceil(this.backgroundDrawable.getIntrinsicHeight() * measuredWidth);
            int measuredWidth2 = (getMeasuredWidth() - iCeil) / 2;
            int measuredHeight2 = ((getMeasuredHeight() - iCeil2) + this.keyboardHeight) / 2;
            this.backgroundDrawable.setBounds(measuredWidth2, measuredHeight2, iCeil + measuredWidth2, iCeil2 + measuredHeight2);
            this.backgroundDrawable.draw(canvas);
            return;
        }
        super.onDraw(canvas);
    }
}
