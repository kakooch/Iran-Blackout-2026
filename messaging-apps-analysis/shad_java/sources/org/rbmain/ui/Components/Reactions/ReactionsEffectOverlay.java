package org.rbmain.ui.Components.Reactions;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ImageReceiver;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.Cells.ChatMessageCell;
import org.rbmain.ui.ChatActivity;
import org.rbmain.ui.Components.AnimatedEmojiDrawable;
import org.rbmain.ui.Components.BackupImageView;
import org.rbmain.ui.Components.Reactions.ReactionsLayoutInBubble;
import org.rbmain.ui.Components.ReactionsContainerLayout;

/* loaded from: classes5.dex */
public class ReactionsEffectOverlay {
    public static ReactionsEffectOverlay currentOverlay;
    public static ReactionsEffectOverlay currentShortOverlay;
    private static long lastHapticTime;
    private static int uniqPrefix;
    float animateInProgress;
    float animateOutProgress;
    private final int animationType;
    private ChatMessageCell cell;
    private final FrameLayout container;
    private ViewGroup decorView;
    private float dismissProgress;
    private boolean dismissed;
    private final AnimationView effectImageView;
    private final AnimationView emojiImageView;
    private final AnimationView emojiStaticImageView;
    private boolean finished;
    private final long groupId;
    private ReactionsContainerLayout.ReactionHolderView holderView;
    private float lastDrawnToX;
    private float lastDrawnToY;
    private final long messageId;
    private final ReactionsLayoutInBubble.VisibleReaction reaction;
    long startTime;
    private boolean started;
    private boolean useWindow;
    private boolean wasScrolled;
    private WindowManager windowManager;
    FrameLayout windowView;
    int[] loc = new int[2];
    ArrayList<AvatarParticle> avatars = new ArrayList<>();

    static /* synthetic */ float access$216(ReactionsEffectOverlay reactionsEffectOverlay, float f) {
        float f2 = reactionsEffectOverlay.dismissProgress + f;
        reactionsEffectOverlay.dismissProgress = f2;
        return f2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x03c3  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x03ea  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0537  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x05c7  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0602  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0626  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0328  */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v4, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v27, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v45 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private ReactionsEffectOverlay(android.content.Context r35, org.rbmain.ui.ActionBar.BaseFragment r36, org.rbmain.ui.Components.ReactionsContainerLayout r37, org.rbmain.ui.Cells.ChatMessageCell r38, android.view.View r39, float r40, float r41, org.rbmain.ui.Components.Reactions.ReactionsLayoutInBubble.VisibleReaction r42, int r43, int r44) {
        /*
            Method dump skipped, instructions count: 1723
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.Reactions.ReactionsEffectOverlay.<init>(android.content.Context, org.rbmain.ui.ActionBar.BaseFragment, org.rbmain.ui.Components.ReactionsContainerLayout, org.rbmain.ui.Cells.ChatMessageCell, android.view.View, float, float, org.rbmain.ui.Components.Reactions.ReactionsLayoutInBubble$VisibleReaction, int, int):void");
    }

    /* renamed from: org.rbmain.ui.Components.Reactions.ReactionsEffectOverlay$1, reason: invalid class name */
    class AnonymousClass1 extends FrameLayout {
        final /* synthetic */ int val$animationType;
        final /* synthetic */ ChatMessageCell val$cell;
        final /* synthetic */ ChatActivity val$chatActivity;
        final /* synthetic */ int val$emojiSize;
        final /* synthetic */ BaseFragment val$fragment;
        final /* synthetic */ boolean val$fromHolder;
        final /* synthetic */ float val$fromScale;
        final /* synthetic */ float val$fromX;
        final /* synthetic */ float val$fromY;
        final /* synthetic */ ReactionsLayoutInBubble.VisibleReaction val$visibleReaction;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Context context, BaseFragment baseFragment, ChatMessageCell chatMessageCell, ChatActivity chatActivity, int i, int i2, boolean z, float f, float f2, float f3, ReactionsLayoutInBubble.VisibleReaction visibleReaction) {
            super(context);
            this.val$fragment = baseFragment;
            this.val$cell = chatMessageCell;
            this.val$chatActivity = chatActivity;
            this.val$emojiSize = i;
            this.val$animationType = i2;
            this.val$fromHolder = z;
            this.val$fromScale = f;
            this.val$fromX = f2;
            this.val$fromY = f3;
            this.val$visibleReaction = visibleReaction;
        }

        /* JADX WARN: Removed duplicated region for block: B:174:0x0478  */
        /* JADX WARN: Removed duplicated region for block: B:181:0x04a1  */
        @Override // android.view.ViewGroup, android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected void dispatchDraw(android.graphics.Canvas r20) {
            /*
                Method dump skipped, instructions count: 1486
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.Reactions.ReactionsEffectOverlay.AnonymousClass1.dispatchDraw(android.graphics.Canvas):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$dispatchDraw$0() {
            ReactionsEffectOverlay.this.removeCurrentView();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$dispatchDraw$1() {
            ReactionsEffectOverlay.this.removeCurrentView();
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            for (int i = 0; i < ReactionsEffectOverlay.this.avatars.size(); i++) {
                ReactionsEffectOverlay.this.avatars.get(i).imageReceiver.onAttachedToWindow();
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            for (int i = 0; i < ReactionsEffectOverlay.this.avatars.size(); i++) {
                ReactionsEffectOverlay.this.avatars.get(i).imageReceiver.onDetachedFromWindow();
            }
        }
    }

    public static String getFilterForAroundAnimation() {
        return sizeForAroundReaction() + "_" + sizeForAroundReaction() + "_nolimit_pcache";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeCurrentView() {
        try {
            if (this.useWindow) {
                this.windowManager.removeView(this.windowView);
            } else {
                this.decorView.removeView(this.windowView);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void show(org.rbmain.ui.ActionBar.BaseFragment r16, org.rbmain.ui.Components.ReactionsContainerLayout r17, org.rbmain.ui.Cells.ChatMessageCell r18, android.view.View r19, float r20, float r21, org.rbmain.ui.Components.Reactions.ReactionsLayoutInBubble.VisibleReaction r22, int r23, int r24) {
        /*
            r11 = r16
            r12 = r24
            if (r18 == 0) goto Lc8
            if (r22 == 0) goto Lc8
            if (r11 == 0) goto Lc8
            android.app.Activity r0 = r16.getParentActivity()
            if (r0 != 0) goto L12
            goto Lc8
        L12:
            android.content.SharedPreferences r0 = org.rbmain.messenger.MessagesController.getGlobalMainSettings()
            java.lang.String r1 = "view_animations"
            r13 = 1
            boolean r0 = r0.getBoolean(r1, r13)
            if (r0 != 0) goto L20
            return
        L20:
            r14 = 2
            if (r12 == r14) goto L25
            if (r12 != 0) goto L36
        L25:
            r1 = 0
            r4 = 0
            r5 = 0
            r8 = 1
            r0 = r16
            r2 = r18
            r3 = r19
            r6 = r22
            r7 = r23
            show(r0, r1, r2, r3, r4, r5, r6, r7, r8)
        L36:
            org.rbmain.ui.Components.Reactions.ReactionsEffectOverlay r15 = new org.rbmain.ui.Components.Reactions.ReactionsEffectOverlay
            android.app.Activity r1 = r16.getParentActivity()
            r0 = r15
            r2 = r16
            r3 = r17
            r4 = r18
            r5 = r19
            r6 = r20
            r7 = r21
            r8 = r22
            r9 = r23
            r10 = r24
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            if (r12 != r13) goto L57
            org.rbmain.ui.Components.Reactions.ReactionsEffectOverlay.currentShortOverlay = r15
            goto L59
        L57:
            org.rbmain.ui.Components.Reactions.ReactionsEffectOverlay.currentOverlay = r15
        L59:
            r0 = 0
            boolean r1 = r11 instanceof org.rbmain.ui.ChatActivity
            if (r1 == 0) goto L70
            r1 = r11
            org.rbmain.ui.ChatActivity r1 = (org.rbmain.ui.ChatActivity) r1
            if (r12 == 0) goto L65
            if (r12 != r14) goto L70
        L65:
            org.rbmain.ui.ActionBar.ActionBarPopupWindow r1 = r1.scrimPopupWindow
            if (r1 == 0) goto L70
            boolean r1 = r1.isShowing()
            if (r1 == 0) goto L70
            goto L71
        L70:
            r13 = 0
        L71:
            r15.useWindow = r13
            if (r13 == 0) goto L9b
            android.view.WindowManager$LayoutParams r0 = new android.view.WindowManager$LayoutParams
            r0.<init>()
            r1 = -1
            r0.height = r1
            r0.width = r1
            r1 = 1000(0x3e8, float:1.401E-42)
            r0.type = r1
            r1 = 65816(0x10118, float:9.2228E-41)
            r0.flags = r1
            r1 = -3
            r0.format = r1
            android.app.Activity r1 = r16.getParentActivity()
            android.view.WindowManager r1 = r1.getWindowManager()
            r15.windowManager = r1
            android.widget.FrameLayout r2 = r15.windowView
            r1.addView(r2, r0)
            goto Lb0
        L9b:
            android.app.Activity r0 = r16.getParentActivity()
            android.view.Window r0 = r0.getWindow()
            android.view.View r0 = r0.getDecorView()
            android.widget.FrameLayout r0 = (android.widget.FrameLayout) r0
            r15.decorView = r0
            android.widget.FrameLayout r1 = r15.windowView
            r0.addView(r1)
        Lb0:
            r18.invalidate()
            org.rbmain.messenger.MessageObject$GroupedMessages r0 = r18.getCurrentMessagesGroup()
            if (r0 == 0) goto Lc8
            android.view.ViewParent r0 = r18.getParent()
            if (r0 == 0) goto Lc8
            android.view.ViewParent r0 = r18.getParent()
            android.view.View r0 = (android.view.View) r0
            r0.invalidate()
        Lc8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.Reactions.ReactionsEffectOverlay.show(org.rbmain.ui.ActionBar.BaseFragment, org.rbmain.ui.Components.ReactionsContainerLayout, org.rbmain.ui.Cells.ChatMessageCell, android.view.View, float, float, org.rbmain.ui.Components.Reactions.ReactionsLayoutInBubble$VisibleReaction, int, int):void");
    }

    public static void startAnimation() {
        ReactionsEffectOverlay reactionsEffectOverlay = currentOverlay;
        if (reactionsEffectOverlay != null) {
            reactionsEffectOverlay.started = true;
            reactionsEffectOverlay.startTime = System.currentTimeMillis();
            if (currentOverlay.animationType != 0 || System.currentTimeMillis() - lastHapticTime <= 200) {
                return;
            }
            lastHapticTime = System.currentTimeMillis();
            currentOverlay.cell.performHapticFeedback(3);
            return;
        }
        startShortAnimation();
        ReactionsEffectOverlay reactionsEffectOverlay2 = currentShortOverlay;
        if (reactionsEffectOverlay2 != null) {
            reactionsEffectOverlay2.cell.reactionsLayoutInBubble.animateReaction(reactionsEffectOverlay2.reaction);
        }
    }

    public static void startShortAnimation() {
        ReactionsEffectOverlay reactionsEffectOverlay = currentShortOverlay;
        if (reactionsEffectOverlay == null || reactionsEffectOverlay.started) {
            return;
        }
        reactionsEffectOverlay.started = true;
        reactionsEffectOverlay.startTime = System.currentTimeMillis();
        if (currentShortOverlay.animationType != 1 || System.currentTimeMillis() - lastHapticTime <= 200) {
            return;
        }
        lastHapticTime = System.currentTimeMillis();
        currentShortOverlay.cell.performHapticFeedback(3);
    }

    public static void removeCurrent(boolean z) {
        int i = 0;
        while (i < 2) {
            ReactionsEffectOverlay reactionsEffectOverlay = i == 0 ? currentOverlay : currentShortOverlay;
            if (reactionsEffectOverlay != null) {
                if (z) {
                    reactionsEffectOverlay.removeCurrentView();
                } else {
                    reactionsEffectOverlay.dismissed = true;
                }
            }
            i++;
        }
        currentShortOverlay = null;
        currentOverlay = null;
    }

    public static boolean isPlaying(long j, long j2, ReactionsLayoutInBubble.VisibleReaction visibleReaction) {
        ReactionsEffectOverlay reactionsEffectOverlay = currentOverlay;
        if (reactionsEffectOverlay == null) {
            return false;
        }
        int i = reactionsEffectOverlay.animationType;
        if (i != 2 && i != 0) {
            return false;
        }
        long j3 = reactionsEffectOverlay.groupId;
        return ((j3 != 0 && j2 == j3) || j == reactionsEffectOverlay.messageId) && reactionsEffectOverlay.reaction.equals(visibleReaction);
    }

    private class AnimationView extends BackupImageView {
        AnimatedEmojiDrawable animatedEmojiDrawable;
        boolean attached;
        AnimatedEmojiEffect emojiEffect;
        boolean wasPlaying;

        public AnimationView(Context context) {
            super(context);
            getImageReceiver().setFileLoadingPriority(3);
        }

        @Override // org.rbmain.ui.Components.BackupImageView, android.view.View
        protected void onDraw(Canvas canvas) {
            AnimatedEmojiDrawable animatedEmojiDrawable = this.animatedEmojiDrawable;
            if (animatedEmojiDrawable != null) {
                animatedEmojiDrawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
                this.animatedEmojiDrawable.setAlpha(255);
                this.animatedEmojiDrawable.draw(canvas);
                this.wasPlaying = true;
                return;
            }
            AnimatedEmojiEffect animatedEmojiEffect = this.emojiEffect;
            if (animatedEmojiEffect != null) {
                animatedEmojiEffect.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
                this.emojiEffect.draw(canvas);
                this.wasPlaying = true;
                return;
            }
            if (getImageReceiver().getLottieAnimation() != null && getImageReceiver().getLottieAnimation().isRunning()) {
                this.wasPlaying = true;
            }
            if (!this.wasPlaying && getImageReceiver().getLottieAnimation() != null && !getImageReceiver().getLottieAnimation().isRunning()) {
                if (ReactionsEffectOverlay.this.animationType == 2) {
                    getImageReceiver().getLottieAnimation().setCurrentFrame(getImageReceiver().getLottieAnimation().getFramesCount() - 1, false);
                } else {
                    getImageReceiver().getLottieAnimation().setCurrentFrame(0, false);
                    getImageReceiver().getLottieAnimation().start();
                }
            }
            super.onDraw(canvas);
        }

        @Override // org.rbmain.ui.Components.BackupImageView, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            this.attached = true;
            AnimatedEmojiDrawable animatedEmojiDrawable = this.animatedEmojiDrawable;
            if (animatedEmojiDrawable != null) {
                animatedEmojiDrawable.addView(this);
            }
            AnimatedEmojiEffect animatedEmojiEffect = this.emojiEffect;
            if (animatedEmojiEffect != null) {
                animatedEmojiEffect.setView(this);
            }
        }

        @Override // org.rbmain.ui.Components.BackupImageView, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            this.attached = false;
            AnimatedEmojiDrawable animatedEmojiDrawable = this.animatedEmojiDrawable;
            if (animatedEmojiDrawable != null) {
                animatedEmojiDrawable.removeView(this);
            }
            AnimatedEmojiEffect animatedEmojiEffect = this.emojiEffect;
            if (animatedEmojiEffect != null) {
                animatedEmojiEffect.removeView(this);
            }
        }

        public void setAnimatedReactionDrawable(AnimatedEmojiDrawable animatedEmojiDrawable) {
            if (animatedEmojiDrawable != null) {
                animatedEmojiDrawable.removeView(this);
            }
            this.animatedEmojiDrawable = animatedEmojiDrawable;
            if (!this.attached || animatedEmojiDrawable == null) {
                return;
            }
            animatedEmojiDrawable.addView(this);
        }

        public void setAnimatedEmojiEffect(AnimatedEmojiEffect animatedEmojiEffect) {
            this.emojiEffect = animatedEmojiEffect;
        }
    }

    public static void onScrolled(int i) {
        ReactionsEffectOverlay reactionsEffectOverlay = currentOverlay;
        if (reactionsEffectOverlay != null) {
            reactionsEffectOverlay.lastDrawnToY -= i;
            if (i != 0) {
                reactionsEffectOverlay.wasScrolled = true;
            }
        }
    }

    public static int sizeForBigReaction() {
        int iDp = AndroidUtilities.dp(350.0f);
        Point point = AndroidUtilities.displaySize;
        return (int) (Math.round(Math.min(iDp, Math.min(point.x, point.y)) * 0.7f) / AndroidUtilities.density);
    }

    public static int sizeForAroundReaction() {
        return (int) ((AndroidUtilities.dp(40.0f) * 2.0f) / AndroidUtilities.density);
    }

    public static void dismissAll() {
        ReactionsEffectOverlay reactionsEffectOverlay = currentOverlay;
        if (reactionsEffectOverlay != null) {
            reactionsEffectOverlay.dismissed = true;
        }
        ReactionsEffectOverlay reactionsEffectOverlay2 = currentShortOverlay;
        if (reactionsEffectOverlay2 != null) {
            reactionsEffectOverlay2.dismissed = true;
        }
    }

    private class AvatarParticle {
        float currentRotation;
        float fromX;
        float fromY;
        float globalTranslationY;
        ImageReceiver imageReceiver;
        boolean incrementRotation;
        float jumpY;
        public int leftTime;
        float outProgress;
        float progress;
        float randomRotation;
        float randomScale;
        float toX;
        float toY;

        private AvatarParticle(ReactionsEffectOverlay reactionsEffectOverlay) {
        }

        /* synthetic */ AvatarParticle(ReactionsEffectOverlay reactionsEffectOverlay, AnonymousClass1 anonymousClass1) {
            this(reactionsEffectOverlay);
        }
    }
}
