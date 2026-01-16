package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.Property;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.util.Consumer;
import androidx.core.view.ViewCompat;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.R;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ChatActivity;
import ir.eitaa.ui.Components.AnimationProperties;
import ir.eitaa.ui.Components.Bulletin;
import ir.eitaa.ui.DialogsActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes3.dex */
public final class Bulletin {
    private static final HashMap<FrameLayout, Delegate> delegates = new HashMap<>();

    @SuppressLint({"StaticFieldLeak"})
    private static Bulletin visibleBulletin;
    private boolean canHide;
    private final FrameLayout containerLayout;
    public int currentBottomOffset;
    private Delegate currentDelegate;
    private int duration;
    private final Runnable hideRunnable = new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$UAwxKzHm4mLB9o-O9HnYJ5k4cas
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.hide();
        }
    };
    private final Layout layout;
    private Layout.Transition layoutTransition;
    private final ParentLayout parentLayout;
    private boolean showing;
    public int tag;

    public interface Delegate {

        /* renamed from: ir.eitaa.ui.Components.Bulletin$Delegate$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static int $default$getBottomOffset(Delegate delegate, int i) {
                return 0;
            }

            public static void $default$onHide(Delegate delegate, Bulletin bulletin) {
            }

            public static void $default$onOffsetChange(Delegate delegate, float f) {
            }

            public static void $default$onShow(Delegate delegate, Bulletin bulletin) {
            }
        }

        int getBottomOffset(int tag);

        void onHide(Bulletin bulletin);

        void onOffsetChange(float offset);

        void onShow(Bulletin bulletin);
    }

    public static Bulletin make(FrameLayout containerLayout, Layout contentLayout, int duration) {
        return new Bulletin(containerLayout, contentLayout, duration);
    }

    @SuppressLint({"RtlHardcoded"})
    public static Bulletin make(BaseFragment fragment, Layout contentLayout, int duration) {
        if (!(fragment instanceof ChatActivity)) {
            if (fragment instanceof DialogsActivity) {
                contentLayout.setWideScreenParams(-1, 0);
            }
        } else {
            contentLayout.setWideScreenParams(-2, 5);
        }
        return new Bulletin(fragment.getLayoutContainer(), contentLayout, duration);
    }

    public static Bulletin find(FrameLayout containerLayout) {
        int childCount = containerLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = containerLayout.getChildAt(i);
            if (childAt instanceof Layout) {
                return ((Layout) childAt).bulletin;
            }
        }
        return null;
    }

    public static void hide(FrameLayout containerLayout) {
        hide(containerLayout, true);
    }

    public static void hide(FrameLayout containerLayout, boolean animated) {
        Bulletin bulletinFind = find(containerLayout);
        if (bulletinFind != null) {
            bulletinFind.hide(animated && isTransitionsEnabled(), 0L);
        }
    }

    private Bulletin(final FrameLayout containerLayout, Layout layout, int duration) {
        this.layout = layout;
        this.parentLayout = new ParentLayout(layout) { // from class: ir.eitaa.ui.Components.Bulletin.1
            @Override // ir.eitaa.ui.Components.Bulletin.ParentLayout
            protected void onPressedStateChanged(boolean pressed) {
                Bulletin.this.setCanHide(!pressed);
                if (containerLayout.getParent() != null) {
                    containerLayout.getParent().requestDisallowInterceptTouchEvent(pressed);
                }
            }

            @Override // ir.eitaa.ui.Components.Bulletin.ParentLayout
            protected void onHide() {
                Bulletin.this.hide();
            }
        };
        this.containerLayout = containerLayout;
        this.duration = duration;
    }

    public static Bulletin getVisibleBulletin() {
        return visibleBulletin;
    }

    public Bulletin show() {
        if (!this.showing && this.containerLayout != null) {
            this.showing = true;
            if (this.layout.getParent() != this.parentLayout) {
                throw new IllegalStateException("Layout has incorrect parent");
            }
            Bulletin bulletin = visibleBulletin;
            if (bulletin != null) {
                bulletin.hide();
            }
            visibleBulletin = this;
            this.layout.onAttach(this);
            this.layout.addOnLayoutChangeListener(new AnonymousClass2());
            this.layout.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: ir.eitaa.ui.Components.Bulletin.3
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View v) {
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View v) {
                    Bulletin.this.layout.removeOnAttachStateChangeListener(this);
                    Bulletin.this.hide(false, 0L);
                }
            });
            this.containerLayout.addView(this.parentLayout);
        }
        return this;
    }

    /* renamed from: ir.eitaa.ui.Components.Bulletin$2, reason: invalid class name */
    class AnonymousClass2 implements View.OnLayoutChangeListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            Bulletin.this.layout.removeOnLayoutChangeListener(this);
            if (Bulletin.this.showing) {
                Bulletin.this.layout.onShow();
                Bulletin.this.currentDelegate = (Delegate) Bulletin.delegates.get(Bulletin.this.containerLayout);
                Bulletin bulletin = Bulletin.this;
                bulletin.currentBottomOffset = bulletin.currentDelegate != null ? Bulletin.this.currentDelegate.getBottomOffset(Bulletin.this.tag) : 0;
                if (Bulletin.this.currentDelegate != null) {
                    Bulletin.this.currentDelegate.onShow(Bulletin.this);
                }
                if (Bulletin.isTransitionsEnabled()) {
                    Bulletin.this.ensureLayoutTransitionCreated();
                    Bulletin.this.layout.transitionRunning = true;
                    Bulletin.this.layout.delegate = Bulletin.this.currentDelegate;
                    Bulletin.this.layout.invalidate();
                    Layout.Transition transition = Bulletin.this.layoutTransition;
                    Layout layout = Bulletin.this.layout;
                    final Layout layout2 = Bulletin.this.layout;
                    layout2.getClass();
                    transition.animateEnter(layout, new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$d6d6CWqUVQh1ZE57UyeEV6e1hR0
                        @Override // java.lang.Runnable
                        public final void run() {
                            layout2.onEnterTransitionStart();
                        }
                    }, new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$Bulletin$2$TP6OWHcz9FC2raKTkveVGAmJQT0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onLayoutChange$0$Bulletin$2();
                        }
                    }, new Consumer() { // from class: ir.eitaa.ui.Components.-$$Lambda$Bulletin$2$zTg8h1I34VDu6ZOjl6FgwXd3yHM
                        @Override // androidx.core.util.Consumer
                        public final void accept(Object obj) {
                            this.f$0.lambda$onLayoutChange$1$Bulletin$2((Float) obj);
                        }
                    }, Bulletin.this.currentBottomOffset);
                    return;
                }
                if (Bulletin.this.currentDelegate != null) {
                    Bulletin.this.currentDelegate.onOffsetChange(Bulletin.this.layout.getHeight() - Bulletin.this.currentBottomOffset);
                }
                Bulletin.this.updatePosition();
                Bulletin.this.layout.onEnterTransitionStart();
                Bulletin.this.layout.onEnterTransitionEnd();
                Bulletin.this.setCanHide(true);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onLayoutChange$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onLayoutChange$0$Bulletin$2() {
            Bulletin.this.layout.transitionRunning = false;
            Bulletin.this.layout.onEnterTransitionEnd();
            Bulletin.this.setCanHide(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onLayoutChange$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onLayoutChange$1$Bulletin$2(Float f) {
            if (Bulletin.this.currentDelegate != null) {
                Bulletin.this.currentDelegate.onOffsetChange(Bulletin.this.layout.getHeight() - f.floatValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanHide(boolean canHide) {
        if (this.canHide != canHide) {
            this.canHide = canHide;
            if (canHide) {
                this.layout.postDelayed(this.hideRunnable, this.duration);
            } else {
                this.layout.removeCallbacks(this.hideRunnable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ensureLayoutTransitionCreated() {
        if (this.layoutTransition == null) {
            this.layoutTransition = this.layout.createTransition();
        }
    }

    public void hide() {
        hide(isTransitionsEnabled(), 0L);
    }

    public void hide(long duration) {
        hide(isTransitionsEnabled(), duration);
    }

    public void hide(boolean animated, long duration) {
        if (this.showing) {
            this.showing = false;
            if (visibleBulletin == this) {
                visibleBulletin = null;
            }
            int i = this.currentBottomOffset;
            this.currentBottomOffset = 0;
            if (ViewCompat.isLaidOut(this.layout)) {
                this.layout.removeCallbacks(this.hideRunnable);
                if (animated) {
                    Layout layout = this.layout;
                    layout.transitionRunning = true;
                    layout.delegate = this.currentDelegate;
                    layout.invalidate();
                    if (duration >= 0) {
                        Layout.DefaultTransition defaultTransition = new Layout.DefaultTransition();
                        defaultTransition.duration = duration;
                        this.layoutTransition = defaultTransition;
                    } else {
                        ensureLayoutTransitionCreated();
                    }
                    Layout.Transition transition = this.layoutTransition;
                    final Layout layout2 = this.layout;
                    layout2.getClass();
                    transition.animateExit(layout2, new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$dwGdRI0cjeBtOt-rhT2_--k8Dno
                        @Override // java.lang.Runnable
                        public final void run() {
                            layout2.onExitTransitionStart();
                        }
                    }, new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$Bulletin$7Kxz-gfl8zBzhAhDByAybdHO67I
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$hide$0$Bulletin();
                        }
                    }, new Consumer() { // from class: ir.eitaa.ui.Components.-$$Lambda$Bulletin$PwU2Ldh-eAGFfYKfrlDRSU7l200
                        @Override // androidx.core.util.Consumer
                        public final void accept(Object obj) {
                            this.f$0.lambda$hide$1$Bulletin((Float) obj);
                        }
                    }, i);
                    return;
                }
            }
            Delegate delegate = this.currentDelegate;
            if (delegate != null) {
                delegate.onOffsetChange(0.0f);
                this.currentDelegate.onHide(this);
            }
            this.layout.onExitTransitionStart();
            this.layout.onExitTransitionEnd();
            this.layout.onHide();
            if (this.containerLayout != null) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$Bulletin$_XTHB13MRRMKfiOrwnpL9yJkxHU
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$hide$2$Bulletin();
                    }
                });
            }
            this.layout.onDetach();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$hide$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$hide$0$Bulletin() {
        Delegate delegate = this.currentDelegate;
        if (delegate != null) {
            delegate.onOffsetChange(0.0f);
            this.currentDelegate.onHide(this);
        }
        Layout layout = this.layout;
        layout.transitionRunning = false;
        layout.onExitTransitionEnd();
        this.layout.onHide();
        this.containerLayout.removeView(this.parentLayout);
        this.layout.onDetach();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$hide$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$hide$1$Bulletin(Float f) {
        Delegate delegate = this.currentDelegate;
        if (delegate != null) {
            delegate.onOffsetChange(this.layout.getHeight() - f.floatValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$hide$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$hide$2$Bulletin() {
        this.containerLayout.removeView(this.parentLayout);
    }

    public boolean isShowing() {
        return this.showing;
    }

    public Layout getLayout() {
        return this.layout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isTransitionsEnabled() {
        return MessagesController.getGlobalMainSettings().getBoolean("view_animations", true) && Build.VERSION.SDK_INT >= 18;
    }

    public void updatePosition() {
        Layout layout = this.layout;
        if (layout != null) {
            layout.updatePosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static abstract class ParentLayout extends FrameLayout {
        private final GestureDetector gestureDetector;
        private boolean hideAnimationRunning;
        private final Layout layout;
        private boolean needLeftAlphaAnimation;
        private boolean needRightAlphaAnimation;
        private boolean pressed;
        private final android.graphics.Rect rect;
        private float translationX;

        protected abstract void onHide();

        protected abstract void onPressedStateChanged(boolean pressed);

        static /* synthetic */ float access$1424(ParentLayout parentLayout, float f) {
            float f2 = parentLayout.translationX - f;
            parentLayout.translationX = f2;
            return f2;
        }

        public ParentLayout(Layout layout) {
            super(layout.getContext());
            this.rect = new android.graphics.Rect();
            this.layout = layout;
            GestureDetector gestureDetector = new GestureDetector(layout.getContext(), new AnonymousClass1(layout));
            this.gestureDetector = gestureDetector;
            gestureDetector.setIsLongpressEnabled(false);
            addView(layout);
        }

        /* renamed from: ir.eitaa.ui.Components.Bulletin$ParentLayout$1, reason: invalid class name */
        class AnonymousClass1 extends GestureDetector.SimpleOnGestureListener {
            final /* synthetic */ Layout val$layout;

            AnonymousClass1(final Layout val$layout) {
                this.val$layout = val$layout;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent e) {
                if (ParentLayout.this.hideAnimationRunning) {
                    return false;
                }
                ParentLayout.this.needLeftAlphaAnimation = this.val$layout.isNeedSwipeAlphaAnimation(true);
                ParentLayout.this.needRightAlphaAnimation = this.val$layout.isNeedSwipeAlphaAnimation(false);
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                this.val$layout.setTranslationX(ParentLayout.access$1424(ParentLayout.this, distanceX));
                if (ParentLayout.this.translationX != 0.0f && ((ParentLayout.this.translationX >= 0.0f || !ParentLayout.this.needLeftAlphaAnimation) && (ParentLayout.this.translationX <= 0.0f || !ParentLayout.this.needRightAlphaAnimation))) {
                    return true;
                }
                this.val$layout.setAlpha(1.0f - (Math.abs(ParentLayout.this.translationX) / this.val$layout.getWidth()));
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                boolean z = false;
                if (Math.abs(velocityX) <= 2000.0f) {
                    return false;
                }
                if ((velocityX < 0.0f && ParentLayout.this.needLeftAlphaAnimation) || (velocityX > 0.0f && ParentLayout.this.needRightAlphaAnimation)) {
                    z = true;
                }
                SpringAnimation springAnimation = new SpringAnimation(this.val$layout, DynamicAnimation.TRANSLATION_X, Math.signum(velocityX) * this.val$layout.getWidth() * 2.0f);
                if (!z) {
                    springAnimation.addEndListener(new DynamicAnimation.OnAnimationEndListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$Bulletin$ParentLayout$1$cJa3E5QmQANHMLyKHBHTK7v5W4s
                        @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
                        public final void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z2, float f, float f2) {
                            this.f$0.lambda$onFling$0$Bulletin$ParentLayout$1(dynamicAnimation, z2, f, f2);
                        }
                    });
                    final Layout layout = this.val$layout;
                    springAnimation.addUpdateListener(new DynamicAnimation.OnAnimationUpdateListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$Bulletin$ParentLayout$1$rdBir6nqZAc_J7xnk0ab1WHmyB0
                        @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
                        public final void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f2) {
                            Bulletin.ParentLayout.AnonymousClass1.lambda$onFling$1(layout, dynamicAnimation, f, f2);
                        }
                    });
                }
                springAnimation.getSpring().setDampingRatio(1.0f);
                springAnimation.getSpring().setStiffness(100.0f);
                springAnimation.setStartVelocity(velocityX);
                springAnimation.start();
                if (z) {
                    SpringAnimation springAnimation2 = new SpringAnimation(this.val$layout, DynamicAnimation.ALPHA, 0.0f);
                    springAnimation2.addEndListener(new DynamicAnimation.OnAnimationEndListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$Bulletin$ParentLayout$1$9LqW35EdQJq7Zp74w2wFafRysGo
                        @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
                        public final void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z2, float f, float f2) {
                            this.f$0.lambda$onFling$2$Bulletin$ParentLayout$1(dynamicAnimation, z2, f, f2);
                        }
                    });
                    springAnimation2.addUpdateListener(new DynamicAnimation.OnAnimationUpdateListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$Bulletin$ParentLayout$1$_viMLwqFi_pgofGWuWIRjDDjNqM
                        @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
                        public final void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f2) {
                            Bulletin.ParentLayout.AnonymousClass1.lambda$onFling$3(dynamicAnimation, f, f2);
                        }
                    });
                    springAnimation.getSpring().setDampingRatio(1.0f);
                    springAnimation.getSpring().setStiffness(10.0f);
                    springAnimation.setStartVelocity(velocityX);
                    springAnimation2.start();
                }
                ParentLayout.this.hideAnimationRunning = true;
                return true;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: lambda$onFling$0, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void lambda$onFling$0$Bulletin$ParentLayout$1(DynamicAnimation dynamicAnimation, boolean z, float f, float f2) {
                ParentLayout.this.onHide();
            }

            static /* synthetic */ void lambda$onFling$1(Layout layout, DynamicAnimation dynamicAnimation, float f, float f2) {
                if (Math.abs(f) > layout.getWidth()) {
                    dynamicAnimation.cancel();
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: lambda$onFling$2, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void lambda$onFling$2$Bulletin$ParentLayout$1(DynamicAnimation dynamicAnimation, boolean z, float f, float f2) {
                ParentLayout.this.onHide();
            }

            static /* synthetic */ void lambda$onFling$3(DynamicAnimation dynamicAnimation, float f, float f2) {
                if (f <= 0.0f) {
                    dynamicAnimation.cancel();
                }
            }
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent event) {
            if (!this.pressed && !inLayoutHitRect(event.getX(), event.getY())) {
                return false;
            }
            this.gestureDetector.onTouchEvent(event);
            int actionMasked = event.getActionMasked();
            if (actionMasked == 0) {
                if (!this.pressed && !this.hideAnimationRunning) {
                    this.layout.animate().cancel();
                    this.translationX = this.layout.getTranslationX();
                    this.pressed = true;
                    onPressedStateChanged(true);
                }
            } else if ((actionMasked == 1 || actionMasked == 3) && this.pressed) {
                if (!this.hideAnimationRunning) {
                    if (Math.abs(this.translationX) > this.layout.getWidth() / 3.0f) {
                        final float fSignum = Math.signum(this.translationX) * this.layout.getWidth();
                        float f = this.translationX;
                        this.layout.animate().translationX(fSignum).alpha(((f > 0.0f ? 1 : (f == 0.0f ? 0 : -1)) < 0 && this.needLeftAlphaAnimation) || ((f > 0.0f ? 1 : (f == 0.0f ? 0 : -1)) > 0 && this.needRightAlphaAnimation) ? 0.0f : 1.0f).setDuration(200L).setInterpolator(AndroidUtilities.accelerateInterpolator).withEndAction(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$Bulletin$ParentLayout$6zvUXtC5RMnNoKpyxaLXHcdeoyA
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$onTouchEvent$0$Bulletin$ParentLayout(fSignum);
                            }
                        }).start();
                    } else {
                        this.layout.animate().translationX(0.0f).alpha(1.0f).setDuration(200L).start();
                    }
                }
                this.pressed = false;
                onPressedStateChanged(false);
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onTouchEvent$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onTouchEvent$0$Bulletin$ParentLayout(float f) {
            if (this.layout.getTranslationX() == f) {
                onHide();
            }
        }

        private boolean inLayoutHitRect(float x, float y) {
            this.layout.getHitRect(this.rect);
            return this.rect.contains((int) x, (int) y);
        }
    }

    public static void addDelegate(BaseFragment fragment, Delegate delegate) {
        FrameLayout layoutContainer = fragment.getLayoutContainer();
        if (layoutContainer != null) {
            addDelegate(layoutContainer, delegate);
        }
    }

    public static void addDelegate(FrameLayout containerLayout, Delegate delegate) {
        delegates.put(containerLayout, delegate);
    }

    public static void removeDelegate(BaseFragment fragment) {
        FrameLayout layoutContainer = fragment.getLayoutContainer();
        if (layoutContainer != null) {
            removeDelegate(layoutContainer);
        }
    }

    public static void removeDelegate(FrameLayout containerLayout) {
        delegates.remove(containerLayout);
    }

    public static abstract class Layout extends FrameLayout {
        public static final FloatPropertyCompat<Layout> IN_OUT_OFFSET_Y;
        public static final Property<Layout, Float> IN_OUT_OFFSET_Y2;
        Drawable background;
        protected Bulletin bulletin;
        private final List<Callback> callbacks;
        Delegate delegate;
        public float inOutOffset;
        private final Theme.ResourcesProvider resourcesProvider;
        public boolean transitionRunning;
        private int wideScreenGravity;
        private int wideScreenWidth;

        public interface Callback {
            void onAttach(Layout layout, Bulletin bulletin);

            void onDetach(Layout layout);

            void onEnterTransitionEnd(Layout layout);

            void onEnterTransitionStart(Layout layout);

            void onExitTransitionEnd(Layout layout);

            void onExitTransitionStart(Layout layout);

            void onHide(Layout layout);

            void onShow(Layout layout);
        }

        public interface Transition {
            void animateEnter(Layout layout, Runnable startAction, Runnable endAction, Consumer<Float> onUpdate, int bottomOffset);

            void animateExit(Layout layout, Runnable startAction, Runnable endAction, Consumer<Float> onUpdate, int bottomOffset);
        }

        public Layout(Context context, Theme.ResourcesProvider resourcesProvider) {
            super(context);
            this.callbacks = new ArrayList();
            this.wideScreenWidth = -2;
            this.wideScreenGravity = 1;
            this.resourcesProvider = resourcesProvider;
            setMinimumHeight(AndroidUtilities.dp(48.0f));
            setBackground(getThemedColor("undo_background"));
            updateSize();
            setPadding(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f));
            setWillNotDraw(false);
        }

        protected void setBackground(int color) {
            this.background = Theme.createRoundRectDrawable(AndroidUtilities.dp(6.0f), color);
        }

        static {
            String str = "offsetY";
            IN_OUT_OFFSET_Y = new FloatPropertyCompat<Layout>(str) { // from class: ir.eitaa.ui.Components.Bulletin.Layout.1
                @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
                public float getValue(Layout object) {
                    return object.inOutOffset;
                }

                @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
                public void setValue(Layout object, float value) {
                    object.setInOutOffset(value);
                }
            };
            IN_OUT_OFFSET_Y2 = new AnimationProperties.FloatProperty<Layout>(str) { // from class: ir.eitaa.ui.Components.Bulletin.Layout.2
                @Override // android.util.Property
                public Float get(Layout layout) {
                    return Float.valueOf(layout.inOutOffset);
                }

                @Override // ir.eitaa.ui.Components.AnimationProperties.FloatProperty
                public void setValue(Layout object, float value) {
                    object.setInOutOffset(value);
                }
            };
        }

        @Override // android.view.View
        protected void onConfigurationChanged(Configuration newConfig) {
            super.onConfigurationChanged(newConfig);
            updateSize();
        }

        private void updateSize() {
            boolean zIsWideScreen = isWideScreen();
            setLayoutParams(LayoutHelper.createFrame(zIsWideScreen ? this.wideScreenWidth : -1, -2, zIsWideScreen ? 80 | this.wideScreenGravity : 80));
        }

        private boolean isWideScreen() {
            if (!AndroidUtilities.isTablet()) {
                android.graphics.Point point = AndroidUtilities.displaySize;
                if (point.x < point.y) {
                    return false;
                }
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setWideScreenParams(int width, int gravity) {
            boolean z;
            boolean z2 = true;
            if (this.wideScreenWidth != width) {
                this.wideScreenWidth = width;
                z = true;
            } else {
                z = false;
            }
            if (this.wideScreenGravity != gravity) {
                this.wideScreenGravity = gravity;
            } else {
                z2 = z;
            }
            if (isWideScreen() && z2) {
                updateSize();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @SuppressLint({"RtlHardcoded"})
        public boolean isNeedSwipeAlphaAnimation(boolean swipeLeft) {
            if (!isWideScreen() || this.wideScreenWidth == -1) {
                return false;
            }
            int i = this.wideScreenGravity;
            if (i == 1) {
                return true;
            }
            return swipeLeft ? i == 5 : i != 5;
        }

        public Bulletin getBulletin() {
            return this.bulletin;
        }

        protected void onAttach(Bulletin bulletin) {
            this.bulletin = bulletin;
            int size = this.callbacks.size();
            for (int i = 0; i < size; i++) {
                this.callbacks.get(i).onAttach(this, bulletin);
            }
        }

        protected void onDetach() {
            this.bulletin = null;
            int size = this.callbacks.size();
            for (int i = 0; i < size; i++) {
                this.callbacks.get(i).onDetach(this);
            }
        }

        protected void onShow() {
            int size = this.callbacks.size();
            for (int i = 0; i < size; i++) {
                this.callbacks.get(i).onShow(this);
            }
        }

        protected void onHide() {
            int size = this.callbacks.size();
            for (int i = 0; i < size; i++) {
                this.callbacks.get(i).onHide(this);
            }
        }

        protected void onEnterTransitionStart() {
            int size = this.callbacks.size();
            for (int i = 0; i < size; i++) {
                this.callbacks.get(i).onEnterTransitionStart(this);
            }
        }

        protected void onEnterTransitionEnd() {
            int size = this.callbacks.size();
            for (int i = 0; i < size; i++) {
                this.callbacks.get(i).onEnterTransitionEnd(this);
            }
        }

        protected void onExitTransitionStart() {
            int size = this.callbacks.size();
            for (int i = 0; i < size; i++) {
                this.callbacks.get(i).onExitTransitionStart(this);
            }
        }

        protected void onExitTransitionEnd() {
            int size = this.callbacks.size();
            for (int i = 0; i < size; i++) {
                this.callbacks.get(i).onExitTransitionEnd(this);
            }
        }

        public void addCallback(Callback callback) {
            this.callbacks.add(callback);
        }

        public void removeCallback(Callback callback) {
            this.callbacks.remove(callback);
        }

        public void updatePosition() {
            float bottomOffset = 0.0f;
            if (this.delegate != null) {
                bottomOffset = 0.0f + r0.getBottomOffset(this.bulletin != null ? r2.tag : 0);
            }
            setTranslationY((-bottomOffset) + this.inOutOffset);
        }

        public Transition createTransition() {
            return new SpringTransition();
        }

        public static class DefaultTransition implements Transition {
            long duration = 255;

            @Override // ir.eitaa.ui.Components.Bulletin.Layout.Transition
            public void animateEnter(final Layout layout, final Runnable startAction, final Runnable endAction, final Consumer<Float> onUpdate, int bottomOffset) {
                layout.setInOutOffset(layout.getMeasuredHeight());
                if (onUpdate != null) {
                    onUpdate.accept(Float.valueOf(layout.getTranslationY()));
                }
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(layout, Layout.IN_OUT_OFFSET_Y2, 0.0f);
                objectAnimatorOfFloat.setDuration(this.duration);
                objectAnimatorOfFloat.setInterpolator(Easings.easeOutQuad);
                if (startAction != null || endAction != null) {
                    objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.Bulletin.Layout.DefaultTransition.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animation) {
                            Runnable runnable = startAction;
                            if (runnable != null) {
                                runnable.run();
                            }
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animation) {
                            Runnable runnable = endAction;
                            if (runnable != null) {
                                runnable.run();
                            }
                        }
                    });
                }
                if (onUpdate != null) {
                    objectAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$Bulletin$Layout$DefaultTransition$lDM6-yme4QUKblmhvTS12lzULwg
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            onUpdate.accept(Float.valueOf(layout.getTranslationY()));
                        }
                    });
                }
                objectAnimatorOfFloat.start();
            }

            @Override // ir.eitaa.ui.Components.Bulletin.Layout.Transition
            public void animateExit(final Layout layout, final Runnable startAction, final Runnable endAction, final Consumer<Float> onUpdate, int bottomOffset) {
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(layout, Layout.IN_OUT_OFFSET_Y2, layout.getHeight());
                objectAnimatorOfFloat.setDuration(175L);
                objectAnimatorOfFloat.setInterpolator(Easings.easeInQuad);
                if (startAction != null || endAction != null) {
                    objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.Bulletin.Layout.DefaultTransition.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animation) {
                            Runnable runnable = startAction;
                            if (runnable != null) {
                                runnable.run();
                            }
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animation) {
                            Runnable runnable = endAction;
                            if (runnable != null) {
                                runnable.run();
                            }
                        }
                    });
                }
                if (onUpdate != null) {
                    objectAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$Bulletin$Layout$DefaultTransition$gi5uHVEmr1yIjQqSQRdxhgoZYxU
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            onUpdate.accept(Float.valueOf(layout.getTranslationY()));
                        }
                    });
                }
                objectAnimatorOfFloat.start();
            }
        }

        public static class SpringTransition implements Transition {
            @Override // ir.eitaa.ui.Components.Bulletin.Layout.Transition
            public void animateEnter(final Layout layout, Runnable startAction, final Runnable endAction, final Consumer<Float> onUpdate, int bottomOffset) {
                layout.setInOutOffset(layout.getMeasuredHeight());
                if (onUpdate != null) {
                    onUpdate.accept(Float.valueOf(layout.getTranslationY()));
                }
                SpringAnimation springAnimation = new SpringAnimation(layout, Layout.IN_OUT_OFFSET_Y, 0.0f);
                springAnimation.getSpring().setDampingRatio(0.8f);
                springAnimation.getSpring().setStiffness(400.0f);
                if (endAction != null) {
                    springAnimation.addEndListener(new DynamicAnimation.OnAnimationEndListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$Bulletin$Layout$SpringTransition$nlFc9ixrzP2GaI-Tb_Bac7Puf1s
                        @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
                        public final void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z, float f, float f2) {
                            Bulletin.Layout.SpringTransition.lambda$animateEnter$0(layout, endAction, dynamicAnimation, z, f, f2);
                        }
                    });
                }
                if (onUpdate != null) {
                    springAnimation.addUpdateListener(new DynamicAnimation.OnAnimationUpdateListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$Bulletin$Layout$SpringTransition$VVjB1UGFSvXaYI23uzWlVHMn9nc
                        @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
                        public final void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f2) {
                            onUpdate.accept(Float.valueOf(layout.getTranslationY()));
                        }
                    });
                }
                springAnimation.start();
                if (startAction != null) {
                    startAction.run();
                }
            }

            static /* synthetic */ void lambda$animateEnter$0(Layout layout, Runnable runnable, DynamicAnimation dynamicAnimation, boolean z, float f, float f2) {
                layout.setInOutOffset(0.0f);
                if (z) {
                    return;
                }
                runnable.run();
            }

            @Override // ir.eitaa.ui.Components.Bulletin.Layout.Transition
            public void animateExit(final Layout layout, Runnable startAction, final Runnable endAction, final Consumer<Float> onUpdate, int bottomOffset) {
                SpringAnimation springAnimation = new SpringAnimation(layout, Layout.IN_OUT_OFFSET_Y, layout.getHeight());
                springAnimation.getSpring().setDampingRatio(0.8f);
                springAnimation.getSpring().setStiffness(400.0f);
                if (endAction != null) {
                    springAnimation.addEndListener(new DynamicAnimation.OnAnimationEndListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$Bulletin$Layout$SpringTransition$-idkrI8Ck42MNv_zMfYxbJ46Ig0
                        @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
                        public final void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z, float f, float f2) {
                            Bulletin.Layout.SpringTransition.lambda$animateExit$2(endAction, dynamicAnimation, z, f, f2);
                        }
                    });
                }
                if (onUpdate != null) {
                    springAnimation.addUpdateListener(new DynamicAnimation.OnAnimationUpdateListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$Bulletin$Layout$SpringTransition$l9YAvwhPrOdM7lFqm1oTC6Rp7os
                        @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
                        public final void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f2) {
                            onUpdate.accept(Float.valueOf(layout.getTranslationY()));
                        }
                    });
                }
                springAnimation.start();
                if (startAction != null) {
                    startAction.run();
                }
            }

            static /* synthetic */ void lambda$animateExit$2(Runnable runnable, DynamicAnimation dynamicAnimation, boolean z, float f, float f2) {
                if (z) {
                    return;
                }
                runnable.run();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setInOutOffset(float offset) {
            this.inOutOffset = offset;
            updatePosition();
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            this.background.setBounds(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), getMeasuredWidth() - AndroidUtilities.dp(8.0f), getMeasuredHeight() - AndroidUtilities.dp(8.0f));
            if (this.transitionRunning && this.delegate != null) {
                int measuredHeight = ((View) getParent()).getMeasuredHeight() - this.delegate.getBottomOffset(this.bulletin.tag);
                int y = (int) (getY() + getMeasuredHeight());
                canvas.save();
                canvas.clipRect(0, 0, getMeasuredWidth(), getMeasuredHeight() - (y - measuredHeight));
                this.background.draw(canvas);
                super.dispatchDraw(canvas);
                canvas.restore();
                invalidate();
                return;
            }
            this.background.draw(canvas);
            super.dispatchDraw(canvas);
        }

        protected int getThemedColor(String key) {
            Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
            Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
            return color != null ? color.intValue() : Theme.getColor(key);
        }
    }

    @SuppressLint({"ViewConstructor"})
    public static class ButtonLayout extends Layout {
        private Button button;
        private int childrenMeasuredWidth;

        public ButtonLayout(Context context, Theme.ResourcesProvider resourcesProvider) {
            super(context, resourcesProvider);
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            this.childrenMeasuredWidth = 0;
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            if (this.button == null || View.MeasureSpec.getMode(widthMeasureSpec) != Integer.MIN_VALUE) {
                return;
            }
            setMeasuredDimension(this.childrenMeasuredWidth + this.button.getMeasuredWidth(), getMeasuredHeight());
        }

        @Override // android.view.ViewGroup
        protected void measureChildWithMargins(View child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed) {
            Button button = this.button;
            if (button != null && child != button) {
                widthUsed += button.getMeasuredWidth() - AndroidUtilities.dp(12.0f);
            }
            super.measureChildWithMargins(child, parentWidthMeasureSpec, widthUsed, parentHeightMeasureSpec, heightUsed);
            if (child != this.button) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) child.getLayoutParams();
                this.childrenMeasuredWidth = Math.max(this.childrenMeasuredWidth, marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + child.getMeasuredWidth());
            }
        }

        public Button getButton() {
            return this.button;
        }

        public void setButton(Button button) {
            Button button2 = this.button;
            if (button2 != null) {
                removeCallback(button2);
                removeView(this.button);
            }
            this.button = button;
            if (button != null) {
                addCallback(button);
                addView(button, 0, LayoutHelper.createFrameRelatively(-2.0f, -2.0f, 8388629));
            }
        }
    }

    public static class SimpleLayout extends ButtonLayout {
        public final ImageView imageView;
        public final TextView textView;

        public SimpleLayout(Context context, Theme.ResourcesProvider resourcesProvider) {
            super(context, resourcesProvider);
            int themedColor = getThemedColor("undo_infoColor");
            ImageView imageView = new ImageView(context);
            this.imageView = imageView;
            imageView.setColorFilter(new PorterDuffColorFilter(themedColor, PorterDuff.Mode.MULTIPLY));
            addView(imageView, LayoutHelper.createFrameRelatively(24.0f, 24.0f, 8388627, 16.0f, 12.0f, 16.0f, 12.0f));
            TextView textView = new TextView(context);
            this.textView = textView;
            textView.setSingleLine();
            textView.setTextColor(themedColor);
            textView.setTypeface(AndroidUtilities.getFontFamily(false));
            textView.setTextSize(1, 15.0f);
            addView(textView, LayoutHelper.createFrameRelatively(-2.0f, -2.0f, 8388627, 56.0f, 0.0f, 16.0f, 0.0f));
        }
    }

    @SuppressLint({"ViewConstructor"})
    public static class TwoLineLayout extends ButtonLayout {
        public final BackupImageView imageView;
        public final TextView subtitleTextView;
        public final TextView titleTextView;

        public TwoLineLayout(Context context, Theme.ResourcesProvider resourcesProvider) {
            super(context, resourcesProvider);
            int themedColor = getThemedColor("undo_infoColor");
            BackupImageView backupImageView = new BackupImageView(context);
            this.imageView = backupImageView;
            addView(backupImageView, LayoutHelper.createFrameRelatively(29.0f, 29.0f, 8388627, 12.0f, 12.0f, 12.0f, 12.0f));
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            addView(linearLayout, LayoutHelper.createFrameRelatively(-2.0f, -2.0f, 8388627, 54.0f, 8.0f, 12.0f, 8.0f));
            TextView textView = new TextView(context);
            this.titleTextView = textView;
            textView.setSingleLine();
            textView.setTextColor(themedColor);
            textView.setTextSize(1, 14.0f);
            textView.setTypeface(AndroidUtilities.getFontFamily(true));
            linearLayout.addView(textView);
            TextView textView2 = new TextView(context);
            this.subtitleTextView = textView2;
            textView2.setMaxLines(2);
            textView2.setTextColor(themedColor);
            textView2.setTypeface(AndroidUtilities.getFontFamily(false));
            textView2.setTextSize(1, 13.0f);
            linearLayout.addView(textView2);
        }
    }

    public static class TwoLineLottieLayout extends ButtonLayout {
        public final RLottieImageView imageView;
        public final TextView subtitleTextView;
        private final int textColor;
        public final TextView titleTextView;

        public TwoLineLottieLayout(Context context, Theme.ResourcesProvider resourcesProvider) {
            super(context, resourcesProvider);
            this.textColor = getThemedColor("undo_infoColor");
            setBackground(getThemedColor("undo_background"));
            RLottieImageView rLottieImageView = new RLottieImageView(context);
            this.imageView = rLottieImageView;
            rLottieImageView.setScaleType(ImageView.ScaleType.CENTER);
            addView(rLottieImageView, LayoutHelper.createFrameRelatively(56.0f, 48.0f, 8388627));
            int themedColor = getThemedColor("undo_infoColor");
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            addView(linearLayout, LayoutHelper.createFrameRelatively(-2.0f, -2.0f, 8388627, 56.0f, 8.0f, 12.0f, 8.0f));
            TextView textView = new TextView(context);
            this.titleTextView = textView;
            textView.setSingleLine();
            textView.setTextColor(themedColor);
            textView.setTextSize(1, 14.0f);
            textView.setTypeface(AndroidUtilities.getFontFamily(true));
            linearLayout.addView(textView);
            TextView textView2 = new TextView(context);
            this.subtitleTextView = textView2;
            textView2.setTextColor(themedColor);
            textView2.setTypeface(AndroidUtilities.getFontFamily(false));
            textView2.setTextSize(1, 13.0f);
            linearLayout.addView(textView2);
        }

        @Override // ir.eitaa.ui.Components.Bulletin.Layout
        protected void onShow() {
            super.onShow();
            this.imageView.playAnimation();
        }

        public void setAnimation(int resId, int w, int h, String... layers) {
            this.imageView.setAnimation(resId, w, h);
            for (String str : layers) {
                this.imageView.setLayerColor(str + ".**", this.textColor);
            }
        }
    }

    public static class LottieLayout extends ButtonLayout {
        public RLottieImageView imageView;
        private int textColor;
        public TextView textView;

        public LottieLayout(Context context, Theme.ResourcesProvider resourcesProvider) {
            super(context, resourcesProvider);
            RLottieImageView rLottieImageView = new RLottieImageView(context);
            this.imageView = rLottieImageView;
            rLottieImageView.setScaleType(ImageView.ScaleType.CENTER);
            addView(this.imageView, LayoutHelper.createFrameRelatively(56.0f, 48.0f, 8388627));
            TextView textView = new TextView(context);
            this.textView = textView;
            textView.setSingleLine();
            this.textView.setTypeface(AndroidUtilities.getFontFamily(false));
            this.textView.setTextSize(1, 15.0f);
            this.textView.setEllipsize(TextUtils.TruncateAt.END);
            this.textView.setPadding(0, AndroidUtilities.dp(8.0f), 0, AndroidUtilities.dp(8.0f));
            addView(this.textView, LayoutHelper.createFrameRelatively(-2.0f, -2.0f, 8388627, 56.0f, 0.0f, 16.0f, 0.0f));
            setTextColor(getThemedColor("undo_infoColor"));
            setBackground(getThemedColor("undo_background"));
        }

        public LottieLayout(Context context, Theme.ResourcesProvider resourcesProvider, int backgroundColor, int textColor) {
            this(context, resourcesProvider);
            setBackground(backgroundColor);
            setTextColor(textColor);
        }

        public void setTextColor(int textColor) {
            this.textColor = textColor;
            this.textView.setTextColor(textColor);
        }

        @Override // ir.eitaa.ui.Components.Bulletin.Layout
        protected void onShow() {
            super.onShow();
            this.imageView.playAnimation();
        }

        public void setAnimation(int resId, String... layers) {
            setAnimation(resId, 32, 32, layers);
        }

        public void setAnimation(int resId, int w, int h, String... layers) {
            this.imageView.setAnimation(resId, w, h);
            for (String str : layers) {
                this.imageView.setLayerColor(str + ".**", this.textColor);
            }
        }

        public void setIconPaddingBottom(int paddingBottom) {
            this.imageView.setLayoutParams(LayoutHelper.createFrameRelatively(56.0f, 48 - paddingBottom, 8388627, 0.0f, 0.0f, 0.0f, paddingBottom));
        }
    }

    @SuppressLint({"ViewConstructor"})
    public static abstract class Button extends FrameLayout implements Layout.Callback {
        @Override // ir.eitaa.ui.Components.Bulletin.Layout.Callback
        public void onEnterTransitionEnd(Layout layout) {
        }

        @Override // ir.eitaa.ui.Components.Bulletin.Layout.Callback
        public void onEnterTransitionStart(Layout layout) {
        }

        @Override // ir.eitaa.ui.Components.Bulletin.Layout.Callback
        public void onExitTransitionEnd(Layout layout) {
        }

        @Override // ir.eitaa.ui.Components.Bulletin.Layout.Callback
        public void onExitTransitionStart(Layout layout) {
        }

        @Override // ir.eitaa.ui.Components.Bulletin.Layout.Callback
        public void onHide(Layout layout) {
        }

        @Override // ir.eitaa.ui.Components.Bulletin.Layout.Callback
        public void onShow(Layout layout) {
        }

        public Button(Context context) {
            super(context);
        }
    }

    @SuppressLint({"ViewConstructor"})
    public static final class UndoButton extends Button {
        private Bulletin bulletin;
        private Runnable delayedAction;
        private boolean isUndone;
        private final Theme.ResourcesProvider resourcesProvider;
        private Runnable undoAction;

        public UndoButton(Context context, boolean text) {
            this(context, text, null);
        }

        public UndoButton(Context context, boolean text, Theme.ResourcesProvider resourcesProvider) {
            super(context);
            this.resourcesProvider = resourcesProvider;
            int themedColor = getThemedColor("undo_cancelColor");
            if (text) {
                TextView textView = new TextView(context);
                textView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$Bulletin$UndoButton$60T_pcuRtm6vW8VA0_siw3JdEZo
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$new$0$Bulletin$UndoButton(view);
                    }
                });
                textView.setBackground(Theme.createCircleSelectorDrawable(419430400 | (16777215 & themedColor), LocaleController.isRTL ? AndroidUtilities.dp(16.0f) : 0, LocaleController.isRTL ? 0 : AndroidUtilities.dp(16.0f)));
                textView.setTextSize(1, 14.0f);
                textView.setTypeface(AndroidUtilities.getFontFamily(true));
                textView.setTextColor(themedColor);
                textView.setText(LocaleController.getString("Undo", R.string.Undo));
                textView.setGravity(16);
                ViewHelper.setPaddingRelative(textView, 16.0f, 0.0f, 16.0f, 0.0f);
                addView(textView, LayoutHelper.createFrameRelatively(-2.0f, 48.0f, 16, 8.0f, 0.0f, 0.0f, 0.0f));
                return;
            }
            ImageView imageView = new ImageView(getContext());
            imageView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$Bulletin$UndoButton$VIHWJ7T6MIR1rrWFVkLpTMQ7hcM
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$1$Bulletin$UndoButton(view);
                }
            });
            imageView.setImageResource(R.drawable.chats_undo);
            imageView.setColorFilter(new PorterDuffColorFilter(themedColor, PorterDuff.Mode.MULTIPLY));
            imageView.setBackground(Theme.createSelectorDrawable((themedColor & 16777215) | 419430400));
            ViewHelper.setPaddingRelative(imageView, 0.0f, 12.0f, 0.0f, 12.0f);
            addView(imageView, LayoutHelper.createFrameRelatively(56.0f, 48.0f, 16));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$0$Bulletin$UndoButton(View view) {
            undo();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$1$Bulletin$UndoButton(View view) {
            undo();
        }

        public void undo() {
            if (this.bulletin != null) {
                this.isUndone = true;
                Runnable runnable = this.undoAction;
                if (runnable != null) {
                    runnable.run();
                }
                this.bulletin.hide();
            }
        }

        @Override // ir.eitaa.ui.Components.Bulletin.Layout.Callback
        public void onAttach(Layout layout, Bulletin bulletin) {
            this.bulletin = bulletin;
        }

        @Override // ir.eitaa.ui.Components.Bulletin.Layout.Callback
        public void onDetach(Layout layout) {
            this.bulletin = null;
            Runnable runnable = this.delayedAction;
            if (runnable == null || this.isUndone) {
                return;
            }
            runnable.run();
        }

        public UndoButton setUndoAction(Runnable undoAction) {
            this.undoAction = undoAction;
            return this;
        }

        public UndoButton setDelayedAction(Runnable delayedAction) {
            this.delayedAction = delayedAction;
            return this;
        }

        private int getThemedColor(String key) {
            Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
            Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
            return color != null ? color.intValue() : Theme.getColor(key);
        }
    }
}
