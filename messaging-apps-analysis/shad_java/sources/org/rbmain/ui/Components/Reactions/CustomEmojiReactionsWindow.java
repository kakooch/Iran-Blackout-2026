package org.rbmain.ui.Components.Reactions;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.facebook.stetho.websocket.CloseCodes;
import ir.medu.shad.R;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.AnimationNotificationsLocker;
import org.rbmain.messenger.LiteMode;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.SharedConfig;
import org.rbmain.messenger.UserConfig;
import org.rbmain.messenger.Utilities;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ChatActivity;
import org.rbmain.ui.Components.Bulletin;
import org.rbmain.ui.Components.CubicBezierInterpolator;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.Reactions.ReactionsLayoutInBubble;
import org.rbmain.ui.Components.ReactionsContainerLayout;

/* loaded from: classes5.dex */
public class CustomEmojiReactionsWindow {
    ArrayList<ValueAnimator> animators;
    BaseFragment baseFragment;
    private boolean cascadeAnimation;
    ContainerView containerView;
    private float dismissProgress;
    private boolean dismissed;
    boolean enterTransitionFinished;
    float enterTransitionProgress;
    RectF fromRect = new RectF();
    float keyboardHeight;
    int[] location;
    final AnimationNotificationsLocker notificationsLocker;
    private Runnable onDismiss;
    List<ReactionsLayoutInBubble.VisibleReaction> reactions;
    ReactionsContainerLayout reactionsContainerLayout;
    Theme.ResourcesProvider resourcesProvider;
    private ValueAnimator valueAnimator;
    private boolean wasFocused;
    WindowManager windowManager;
    FrameLayout windowView;
    float yTranslation;

    /* JADX INFO: Access modifiers changed from: private */
    public void syncReactionFrames(boolean z) {
    }

    private void updateCascadeEnter(float f) {
    }

    public CustomEmojiReactionsWindow(BaseFragment baseFragment, List<ReactionsLayoutInBubble.VisibleReaction> list, HashSet<ReactionsLayoutInBubble.VisibleReaction> hashSet, final ReactionsContainerLayout reactionsContainerLayout, Theme.ResourcesProvider resourcesProvider) {
        new RectF();
        new Path();
        this.location = new int[2];
        this.notificationsLocker = new AnimationNotificationsLocker();
        new HashSet();
        this.animators = new ArrayList<>();
        this.reactions = list;
        this.baseFragment = baseFragment;
        this.resourcesProvider = resourcesProvider;
        Context context = baseFragment.getContext();
        FrameLayout frameLayout = new FrameLayout(context) { // from class: org.rbmain.ui.Components.Reactions.CustomEmojiReactionsWindow.1
            @Override // android.view.ViewGroup, android.view.View
            protected void dispatchSetPressed(boolean z) {
            }

            @Override // android.view.ViewGroup, android.view.View
            public boolean dispatchKeyEvent(KeyEvent keyEvent) {
                if (keyEvent.getAction() == 1 && keyEvent.getKeyCode() == 4) {
                    CustomEmojiReactionsWindow customEmojiReactionsWindow = CustomEmojiReactionsWindow.this;
                    if (customEmojiReactionsWindow.enterTransitionFinished) {
                        customEmojiReactionsWindow.dismiss();
                    }
                    return true;
                }
                return super.dispatchKeyEvent(keyEvent);
            }

            @Override // android.view.View
            protected boolean fitSystemWindows(Rect rect) {
                CustomEmojiReactionsWindow customEmojiReactionsWindow = CustomEmojiReactionsWindow.this;
                if (customEmojiReactionsWindow.keyboardHeight != rect.bottom && customEmojiReactionsWindow.wasFocused) {
                    CustomEmojiReactionsWindow customEmojiReactionsWindow2 = CustomEmojiReactionsWindow.this;
                    customEmojiReactionsWindow2.keyboardHeight = rect.bottom;
                    customEmojiReactionsWindow2.updateWindowPosition();
                }
                return super.fitSystemWindows(rect);
            }
        };
        this.windowView = frameLayout;
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.Reactions.CustomEmojiReactionsWindow$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$0(view);
            }
        });
        ContainerView containerView = new ContainerView(this, context);
        this.containerView = containerView;
        this.windowView.addView(containerView, LayoutHelper.createFrame(-1, -1.0f, 48, 16.0f, 16.0f, 16.0f, 16.0f));
        this.windowView.setClipChildren(false);
        WindowManager.LayoutParams layoutParamsCreateLayoutParams = createLayoutParams(false);
        WindowManager windowManager = baseFragment.getParentActivity().getWindowManager();
        this.windowManager = windowManager;
        windowManager.addView(this.windowView, layoutParamsCreateLayoutParams);
        this.reactionsContainerLayout = reactionsContainerLayout;
        reactionsContainerLayout.prepareAnimation(true);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.Reactions.CustomEmojiReactionsWindow$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$1(reactionsContainerLayout);
            }
        }, 50L);
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.stopAllHeavyOperations, 7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view) {
        if (this.enterTransitionFinished) {
            dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(ReactionsContainerLayout reactionsContainerLayout) {
        this.containerView.invalidate();
        reactionsContainerLayout.prepareAnimation(false);
        createTransition(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateWindowPosition() {
        if (this.dismissed) {
            return;
        }
        float measuredHeight = this.yTranslation;
        if (this.containerView.getMeasuredHeight() + measuredHeight > (this.windowView.getMeasuredHeight() - this.keyboardHeight) - AndroidUtilities.dp(32.0f)) {
            measuredHeight = ((this.windowView.getMeasuredHeight() - this.keyboardHeight) - this.containerView.getMeasuredHeight()) - AndroidUtilities.dp(32.0f);
        }
        if (measuredHeight < 0.0f) {
            measuredHeight = 0.0f;
        }
        this.containerView.animate().translationY(measuredHeight).setDuration(250L).setInterpolator(CubicBezierInterpolator.DEFAULT).start();
    }

    private WindowManager.LayoutParams createLayoutParams(boolean z) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.height = -1;
        layoutParams.width = -1;
        layoutParams.type = CloseCodes.NORMAL_CLOSURE;
        layoutParams.softInputMode = 16;
        if (z) {
            layoutParams.flags = 65792;
        } else {
            layoutParams.flags = 65800;
        }
        layoutParams.format = -3;
        return layoutParams;
    }

    private void createTransition(final boolean z) {
        this.fromRect.set(this.reactionsContainerLayout.rect);
        ReactionsContainerLayout reactionsContainerLayout = this.reactionsContainerLayout;
        float f = reactionsContainerLayout.radius;
        int[] iArr = new int[2];
        if (z) {
            reactionsContainerLayout.getLocationOnScreen(this.location);
        }
        this.windowView.getLocationOnScreen(iArr);
        float fDp = (((this.location[1] - iArr[1]) - AndroidUtilities.dp(44.0f)) - AndroidUtilities.dp(52.0f)) - 0;
        if (this.containerView.getMeasuredHeight() + fDp > this.windowView.getMeasuredHeight() - AndroidUtilities.dp(32.0f)) {
            fDp = (this.windowView.getMeasuredHeight() - AndroidUtilities.dp(32.0f)) - this.containerView.getMeasuredHeight();
        }
        if (fDp < AndroidUtilities.dp(16.0f)) {
            fDp = AndroidUtilities.dp(16.0f);
        }
        this.containerView.setTranslationX((this.location[0] - iArr[0]) - AndroidUtilities.dp(2.0f));
        if (!z) {
            this.yTranslation = this.containerView.getTranslationY();
        } else {
            this.yTranslation = fDp;
            this.containerView.setTranslationY(fDp);
        }
        this.fromRect.offset((this.location[0] - iArr[0]) - this.containerView.getX(), (this.location[1] - iArr[1]) - this.containerView.getY());
        this.reactionsContainerLayout.setCustomEmojiEnterProgress(this.enterTransitionProgress);
        if (z) {
            this.cascadeAnimation = SharedConfig.getDevicePerformanceClass() >= 2 && LiteMode.isEnabled(LiteMode.FLAG_ANIMATED_EMOJI_REACTIONS);
            this.enterTransitionFinished = false;
        } else {
            this.cascadeAnimation = false;
        }
        if (this.cascadeAnimation) {
            updateCascadeEnter(0.0f);
        }
        int i = UserConfig.selectedAccount;
        this.notificationsLocker.lock();
        float[] fArr = new float[2];
        fArr[0] = this.enterTransitionProgress;
        fArr[1] = z ? 1.0f : 0.0f;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        this.valueAnimator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.Components.Reactions.CustomEmojiReactionsWindow$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.lambda$createTransition$2(valueAnimator);
            }
        });
        if (!z) {
            syncReactionFrames(z);
        }
        this.valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.Reactions.CustomEmojiReactionsWindow.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                CustomEmojiReactionsWindow.this.checkAnimationEnd();
                CustomEmojiReactionsWindow customEmojiReactionsWindow = CustomEmojiReactionsWindow.this;
                boolean z2 = z;
                customEmojiReactionsWindow.enterTransitionProgress = z2 ? 1.0f : 0.0f;
                if (z2) {
                    customEmojiReactionsWindow.enterTransitionFinished = true;
                    customEmojiReactionsWindow.reactionsContainerLayout.onCustomEmojiWindowOpened();
                    CustomEmojiReactionsWindow.this.containerView.invalidate();
                }
                CustomEmojiReactionsWindow customEmojiReactionsWindow2 = CustomEmojiReactionsWindow.this;
                customEmojiReactionsWindow2.reactionsContainerLayout.setCustomEmojiEnterProgress(Utilities.clamp(customEmojiReactionsWindow2.enterTransitionProgress, 1.0f, 0.0f));
                boolean z3 = z;
                if (z3) {
                    CustomEmojiReactionsWindow.this.syncReactionFrames(z3);
                }
                if (!z) {
                    CustomEmojiReactionsWindow.this.reactionsContainerLayout.setSkipDraw(false);
                }
                if (z) {
                    return;
                }
                CustomEmojiReactionsWindow.this.removeView();
            }
        });
        this.valueAnimator.setStartDelay(30L);
        if (this.cascadeAnimation) {
            this.valueAnimator.setDuration(450L);
            this.valueAnimator.setInterpolator(new OvershootInterpolator(0.5f));
        } else {
            this.valueAnimator.setDuration(350L);
            this.valueAnimator.setInterpolator(CubicBezierInterpolator.DEFAULT);
        }
        this.valueAnimator.start();
        this.containerView.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createTransition$2(ValueAnimator valueAnimator) {
        this.valueAnimator = null;
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.enterTransitionProgress = fFloatValue;
        this.reactionsContainerLayout.setCustomEmojiEnterProgress(Utilities.clamp(fFloatValue, 1.0f, 0.0f));
        this.containerView.invalidate();
        if (this.cascadeAnimation) {
            updateCascadeEnter(this.enterTransitionProgress);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkAnimationEnd() {
        if (this.animators.isEmpty()) {
            this.notificationsLocker.unlock();
        }
    }

    public void removeView() {
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.startAllHeavyOperations, 7);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.Reactions.CustomEmojiReactionsWindow$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$removeView$3();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removeView$3() {
        if (this.windowView.getParent() == null) {
            return;
        }
        try {
            this.windowManager.removeView(this.windowView);
        } catch (Exception unused) {
        }
        Runnable runnable = this.onDismiss;
        if (runnable != null) {
            runnable.run();
        }
    }

    public void dismiss() {
        if (this.dismissed) {
            return;
        }
        Bulletin.hideVisible();
        this.dismissed = true;
        AndroidUtilities.hideKeyboard(this.windowView);
        createTransition(false);
        if (this.wasFocused) {
            BaseFragment baseFragment = this.baseFragment;
            if (baseFragment instanceof ChatActivity) {
                ((ChatActivity) baseFragment).onEditTextDialogClose(true, true);
            }
        }
    }

    public void onDismissListener(Runnable runnable) {
        this.onDismiss = runnable;
    }

    public void dismiss(boolean z) {
        if (this.dismissed && z) {
            return;
        }
        this.dismissed = true;
        if (!z) {
            removeView();
            return;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.Components.Reactions.CustomEmojiReactionsWindow$$ExternalSyntheticLambda1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.lambda$dismiss$4(valueAnimator);
            }
        });
        valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.Reactions.CustomEmojiReactionsWindow.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                CustomEmojiReactionsWindow.this.removeView();
            }
        });
        valueAnimatorOfFloat.setDuration(150L);
        valueAnimatorOfFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$dismiss$4(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.dismissProgress = fFloatValue;
        this.containerView.setAlpha(1.0f - fFloatValue);
    }

    private class ContainerView extends FrameLayout {
        Paint backgroundPaint;
        Drawable shadow;
        Rect shadowPad;

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
        }

        public ContainerView(CustomEmojiReactionsWindow customEmojiReactionsWindow, Context context) {
            super(context);
            this.shadowPad = new Rect();
            this.backgroundPaint = new Paint(1);
            this.shadow = ContextCompat.getDrawable(context, R.drawable.reactions_bubble_shadow).mutate();
            Rect rect = this.shadowPad;
            int iDp = AndroidUtilities.dp(7.0f);
            rect.bottom = iDp;
            rect.right = iDp;
            rect.top = iDp;
            rect.left = iDp;
            this.shadow.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_chat_messagePanelShadow, customEmojiReactionsWindow.resourcesProvider), PorterDuff.Mode.MULTIPLY));
            this.backgroundPaint.setColor(Theme.getColor(Theme.key_actionBarDefaultSubmenuBackground, customEmojiReactionsWindow.resourcesProvider));
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            int iMin = Math.min(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
            int iDp = (AndroidUtilities.dp(36.0f) * 8) + AndroidUtilities.dp(12.0f);
            if (iDp < iMin) {
                iMin = iDp;
            }
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), View.MeasureSpec.makeMeasureSpec(iMin, 1073741824));
        }
    }
}
