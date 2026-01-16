package ir.eitaa.ui.ActionBar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Property;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import androidx.annotation.Keep;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.ImageReceiver;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.LayoutHelper;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class ActionBarPopupWindow extends PopupWindow {
    private static final ViewTreeObserver.OnScrollChangedListener NOP;
    private static final boolean allowAnimation;
    private static DecelerateInterpolator decelerateInterpolator;
    private static Method layoutInScreenMethod;
    private static final Field superListenerField;
    private boolean animationEnabled;
    private int currentAccount;
    private int dismissAnimationDuration;
    private boolean isClosingAnimated;
    private ViewTreeObserver.OnScrollChangedListener mSuperScrollListener;
    private ViewTreeObserver mViewTreeObserver;
    private long outEmptyTime;
    private boolean pauseNotifications;
    private int popupAnimationIndex;
    private AnimatorSet windowAnimatorSet;

    public interface OnDispatchKeyEventListener {
        void onDispatchKeyEvent(KeyEvent keyEvent);
    }

    static /* synthetic */ void lambda$static$0() {
    }

    static {
        allowAnimation = Build.VERSION.SDK_INT >= 18;
        decelerateInterpolator = new DecelerateInterpolator();
        Field declaredField = null;
        try {
            declaredField = PopupWindow.class.getDeclaredField("mOnScrollChangedListener");
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException unused) {
        }
        superListenerField = declaredField;
        NOP = new ViewTreeObserver.OnScrollChangedListener() { // from class: ir.eitaa.ui.ActionBar.-$$Lambda$ActionBarPopupWindow$vhSnJ1Yo8rnMRgZFlyDMgYG8-zs
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                ActionBarPopupWindow.lambda$static$0();
            }
        };
    }

    public static class ActionBarPopupWindowLayout extends FrameLayout {
        private boolean animationEnabled;
        private int backAlpha;
        private float backScaleX;
        private float backScaleY;
        private int backgroundColor;
        protected Drawable backgroundDrawable;
        private Rect bgPaddings;
        private boolean fitItems;
        private int gapEndY;
        private int gapStartY;
        private ArrayList<AnimatorSet> itemAnimators;
        private int lastStartedChild;
        protected LinearLayout linearLayout;
        private OnDispatchKeyEventListener mOnDispatchKeyEventListener;
        private HashMap<View, Integer> positions;
        private final Theme.ResourcesProvider resourcesProvider;
        private ScrollView scrollView;
        private boolean shownFromBotton;

        public ActionBarPopupWindowLayout(Context context) {
            this(context, null);
        }

        public ActionBarPopupWindowLayout(Context context, Theme.ResourcesProvider resourcesProvider) {
            this(context, R.drawable.popup_fixed_alert2, resourcesProvider);
        }

        public ActionBarPopupWindowLayout(Context context, int resId, Theme.ResourcesProvider resourcesProvider) {
            super(context);
            this.backScaleX = 1.0f;
            this.backScaleY = 1.0f;
            this.backAlpha = 255;
            this.lastStartedChild = 0;
            this.animationEnabled = ActionBarPopupWindow.allowAnimation;
            this.positions = new HashMap<>();
            this.gapStartY = -1000000;
            this.gapEndY = -1000000;
            this.bgPaddings = new Rect();
            this.backgroundColor = -1;
            this.resourcesProvider = resourcesProvider;
            Drawable drawableMutate = getResources().getDrawable(resId).mutate();
            this.backgroundDrawable = drawableMutate;
            if (drawableMutate != null) {
                drawableMutate.getPadding(this.bgPaddings);
            }
            setBackgroundColor(getThemedColor("actionBarDefaultSubmenuBackground"));
            setPadding(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f));
            setWillNotDraw(false);
            try {
                ScrollView scrollView = new ScrollView(context);
                this.scrollView = scrollView;
                scrollView.setVerticalScrollBarEnabled(false);
                addView(this.scrollView, LayoutHelper.createFrame(-2, -2.0f));
            } catch (Throwable th) {
                FileLog.e(th);
            }
            LinearLayout linearLayout = new LinearLayout(context) { // from class: ir.eitaa.ui.ActionBar.ActionBarPopupWindow.ActionBarPopupWindowLayout.1
                @Override // android.widget.LinearLayout, android.view.View
                protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                    if (ActionBarPopupWindowLayout.this.fitItems) {
                        ActionBarPopupWindowLayout.this.gapStartY = -1000000;
                        ActionBarPopupWindowLayout.this.gapEndY = -1000000;
                        int childCount = getChildCount();
                        ArrayList arrayList = null;
                        int iMax = 0;
                        int i = 0;
                        for (int i2 = 0; i2 < childCount; i2++) {
                            View childAt = getChildAt(i2);
                            if (childAt.getVisibility() != 8) {
                                Object tag = childAt.getTag(R.id.width_tag);
                                Object tag2 = childAt.getTag(R.id.object_tag);
                                if (tag != null) {
                                    childAt.getLayoutParams().width = -2;
                                }
                                measureChildWithMargins(childAt, widthMeasureSpec, 0, heightMeasureSpec, 0);
                                boolean z = tag instanceof Integer;
                                if (!z && tag2 == null) {
                                    iMax = Math.max(iMax, childAt.getMeasuredWidth());
                                } else {
                                    if (z) {
                                        int iMax2 = Math.max(((Integer) tag).intValue(), childAt.getMeasuredWidth());
                                        ActionBarPopupWindowLayout.this.gapStartY = childAt.getMeasuredHeight();
                                        ActionBarPopupWindowLayout actionBarPopupWindowLayout = ActionBarPopupWindowLayout.this;
                                        actionBarPopupWindowLayout.gapEndY = actionBarPopupWindowLayout.gapStartY + AndroidUtilities.dp(6.0f);
                                        i = iMax2;
                                    }
                                    if (arrayList == null) {
                                        arrayList = new ArrayList();
                                    }
                                    arrayList.add(childAt);
                                }
                            }
                        }
                        if (arrayList != null) {
                            int size = arrayList.size();
                            for (int i3 = 0; i3 < size; i3++) {
                                ((View) arrayList.get(i3)).getLayoutParams().width = Math.max(iMax, i);
                            }
                        }
                    }
                    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
                }
            };
            this.linearLayout = linearLayout;
            linearLayout.setOrientation(1);
            ScrollView scrollView2 = this.scrollView;
            if (scrollView2 != null) {
                scrollView2.addView(this.linearLayout, new FrameLayout.LayoutParams(-2, -2));
            } else {
                addView(this.linearLayout, LayoutHelper.createFrame(-2, -2.0f));
            }
        }

        public void setFitItems(boolean value) {
            this.fitItems = value;
        }

        public void setShownFromBotton(boolean value) {
            this.shownFromBotton = value;
        }

        public void setDispatchKeyEventListener(OnDispatchKeyEventListener listener) {
            this.mOnDispatchKeyEventListener = listener;
        }

        public int getBackgroundColor() {
            return this.backgroundColor;
        }

        @Override // android.view.View
        public void setBackgroundColor(int color) {
            if (this.backgroundColor != color) {
                Drawable drawable = this.backgroundDrawable;
                this.backgroundColor = color;
                drawable.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.MULTIPLY));
            }
        }

        @Keep
        public void setBackAlpha(int value) {
            this.backAlpha = value;
        }

        @Keep
        public int getBackAlpha() {
            return this.backAlpha;
        }

        @Keep
        public void setBackScaleX(float value) {
            this.backScaleX = value;
            invalidate();
        }

        @Keep
        public void setBackScaleY(float value) {
            this.backScaleY = value;
            if (this.animationEnabled) {
                int measuredHeight = getMeasuredHeight() - AndroidUtilities.dp(16.0f);
                if (this.shownFromBotton) {
                    for (int i = this.lastStartedChild; i >= 0; i--) {
                        View itemAt = getItemAt(i);
                        if (itemAt.getVisibility() == 0) {
                            if (this.positions.get(itemAt) != null && measuredHeight - ((r3.intValue() * AndroidUtilities.dp(48.0f)) + AndroidUtilities.dp(32.0f)) > measuredHeight * value) {
                                break;
                            }
                            this.lastStartedChild = i - 1;
                            startChildAnimation(itemAt);
                        }
                    }
                } else {
                    int itemsCount = getItemsCount();
                    int measuredHeight2 = 0;
                    for (int i2 = 0; i2 < itemsCount; i2++) {
                        View itemAt2 = getItemAt(i2);
                        if (itemAt2.getVisibility() == 0) {
                            measuredHeight2 += itemAt2.getMeasuredHeight();
                            if (i2 < this.lastStartedChild) {
                                continue;
                            } else {
                                if (this.positions.get(itemAt2) != null && measuredHeight2 - AndroidUtilities.dp(24.0f) > measuredHeight * value) {
                                    break;
                                }
                                this.lastStartedChild = i2 + 1;
                                startChildAnimation(itemAt2);
                            }
                        }
                    }
                }
            }
            invalidate();
        }

        @Override // android.view.View
        public void setBackgroundDrawable(Drawable drawable) {
            this.backgroundColor = -1;
            this.backgroundDrawable = drawable;
            if (drawable != null) {
                drawable.getPadding(this.bgPaddings);
            }
        }

        private void startChildAnimation(View child) {
            if (this.animationEnabled) {
                final AnimatorSet animatorSet = new AnimatorSet();
                Animator[] animatorArr = new Animator[2];
                animatorArr[0] = ObjectAnimator.ofFloat(child, (Property<View, Float>) View.ALPHA, 0.0f, 1.0f);
                Property property = View.TRANSLATION_Y;
                float[] fArr = new float[2];
                fArr[0] = AndroidUtilities.dp(this.shownFromBotton ? 6.0f : -6.0f);
                fArr[1] = 0.0f;
                animatorArr[1] = ObjectAnimator.ofFloat(child, (Property<View, Float>) property, fArr);
                animatorSet.playTogether(animatorArr);
                animatorSet.setDuration(180L);
                animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.ActionBar.ActionBarPopupWindow.ActionBarPopupWindowLayout.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        ActionBarPopupWindowLayout.this.itemAnimators.remove(animatorSet);
                    }
                });
                animatorSet.setInterpolator(ActionBarPopupWindow.decelerateInterpolator);
                animatorSet.start();
                if (this.itemAnimators == null) {
                    this.itemAnimators = new ArrayList<>();
                }
                this.itemAnimators.add(animatorSet);
            }
        }

        public void setAnimationEnabled(boolean value) {
            this.animationEnabled = value;
        }

        @Override // android.view.ViewGroup
        public void addView(View child) {
            this.linearLayout.addView(child);
        }

        public void addView(View child, LinearLayout.LayoutParams layoutParams) {
            this.linearLayout.addView(child, layoutParams);
        }

        public void removeInnerViews() {
            this.linearLayout.removeAllViews();
        }

        public float getBackScaleX() {
            return this.backScaleX;
        }

        public float getBackScaleY() {
            return this.backScaleY;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent event) {
            OnDispatchKeyEventListener onDispatchKeyEventListener = this.mOnDispatchKeyEventListener;
            if (onDispatchKeyEventListener != null) {
                onDispatchKeyEventListener.onDispatchKeyEvent(event);
            }
            return super.dispatchKeyEvent(event);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            if (this.backgroundDrawable != null) {
                int scrollY = this.gapStartY - this.scrollView.getScrollY();
                int scrollY2 = this.gapEndY - this.scrollView.getScrollY();
                for (int i = 0; i < 2; i++) {
                    if (i == 1 && scrollY < (-AndroidUtilities.dp(16.0f))) {
                        return;
                    }
                    if (this.gapStartY != -1000000) {
                        canvas.save();
                        canvas.clipRect(0, this.bgPaddings.top, getMeasuredWidth(), getMeasuredHeight());
                    }
                    this.backgroundDrawable.setAlpha(this.backAlpha);
                    if (this.shownFromBotton) {
                        int measuredHeight = getMeasuredHeight();
                        this.backgroundDrawable.setBounds(0, (int) (measuredHeight * (1.0f - this.backScaleY)), (int) (getMeasuredWidth() * this.backScaleX), measuredHeight);
                    } else if (scrollY > (-AndroidUtilities.dp(16.0f))) {
                        int measuredHeight2 = (int) (getMeasuredHeight() * this.backScaleY);
                        if (i == 0) {
                            Drawable drawable = this.backgroundDrawable;
                            int iDp = (-this.scrollView.getScrollY()) + (this.gapStartY != -1000000 ? AndroidUtilities.dp(1.0f) : 0);
                            int measuredWidth = (int) (getMeasuredWidth() * this.backScaleX);
                            if (this.gapStartY != -1000000) {
                                measuredHeight2 = Math.min(measuredHeight2, AndroidUtilities.dp(16.0f) + scrollY);
                            }
                            drawable.setBounds(0, iDp, measuredWidth, measuredHeight2);
                        } else if (measuredHeight2 < scrollY2) {
                            if (this.gapStartY != -1000000) {
                                canvas.restore();
                            }
                        } else {
                            this.backgroundDrawable.setBounds(0, scrollY2, (int) (getMeasuredWidth() * this.backScaleX), measuredHeight2);
                        }
                    } else {
                        this.backgroundDrawable.setBounds(0, this.gapStartY < 0 ? 0 : -AndroidUtilities.dp(16.0f), (int) (getMeasuredWidth() * this.backScaleX), (int) (getMeasuredHeight() * this.backScaleY));
                    }
                    this.backgroundDrawable.draw(canvas);
                    if (this.gapStartY != -1000000) {
                        canvas.restore();
                    }
                }
            }
        }

        public Drawable getBackgroundDrawable() {
            return this.backgroundDrawable;
        }

        public int getItemsCount() {
            return this.linearLayout.getChildCount();
        }

        public View getItemAt(int index) {
            return this.linearLayout.getChildAt(index);
        }

        public void scrollToTop() {
            ScrollView scrollView = this.scrollView;
            if (scrollView != null) {
                scrollView.scrollTo(0, 0);
            }
        }

        public void setupRadialSelectors(int color) {
            int childCount = this.linearLayout.getChildCount();
            int i = 0;
            while (i < childCount) {
                View childAt = this.linearLayout.getChildAt(i);
                int i2 = 6;
                int i3 = i == 0 ? 6 : 0;
                if (i != childCount - 1) {
                    i2 = 0;
                }
                childAt.setBackground(Theme.createRadSelectorDrawable(color, i3, i2));
                i++;
            }
        }

        public void updateRadialSelectors() {
            int childCount = this.linearLayout.getChildCount();
            View view = null;
            View view2 = null;
            for (int i = 0; i < childCount; i++) {
                View childAt = this.linearLayout.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    if (view == null) {
                        view = childAt;
                    }
                    view2 = childAt;
                }
            }
            boolean z = false;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt2 = this.linearLayout.getChildAt(i2);
                if (childAt2.getVisibility() == 0) {
                    Object tag = childAt2.getTag(R.id.object_tag);
                    if (childAt2 instanceof ActionBarMenuSubItem) {
                        ((ActionBarMenuSubItem) childAt2).updateSelectorBackground(childAt2 == view || z, childAt2 == view2);
                    }
                    z = tag != null;
                }
            }
        }

        private int getThemedColor(String key) {
            Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
            Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
            return color != null ? color.intValue() : Theme.getColor(key);
        }
    }

    public ActionBarPopupWindow(View contentView, int width, int height) throws IllegalAccessException, IllegalArgumentException {
        super(contentView, width, height);
        this.animationEnabled = allowAnimation;
        this.dismissAnimationDuration = ImageReceiver.DEFAULT_CROSSFADE_DURATION;
        this.currentAccount = UserConfig.selectedAccount;
        this.outEmptyTime = -1L;
        this.popupAnimationIndex = -1;
        init();
    }

    public void setAnimationEnabled(boolean value) {
        this.animationEnabled = value;
    }

    public void setLayoutInScreen(boolean value) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            if (layoutInScreenMethod == null) {
                Method declaredMethod = PopupWindow.class.getDeclaredMethod("setLayoutInScreenEnabled", Boolean.TYPE);
                layoutInScreenMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            layoutInScreenMethod.invoke(this, Boolean.TRUE);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    private void init() throws IllegalAccessException, IllegalArgumentException {
        Field field = superListenerField;
        if (field != null) {
            try {
                this.mSuperScrollListener = (ViewTreeObserver.OnScrollChangedListener) field.get(this);
                field.set(this, NOP);
            } catch (Exception unused) {
                this.mSuperScrollListener = null;
            }
        }
    }

    public void setDismissAnimationDuration(int value) {
        this.dismissAnimationDuration = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unregisterListener() {
        ViewTreeObserver viewTreeObserver;
        if (this.mSuperScrollListener == null || (viewTreeObserver = this.mViewTreeObserver) == null) {
            return;
        }
        if (viewTreeObserver.isAlive()) {
            this.mViewTreeObserver.removeOnScrollChangedListener(this.mSuperScrollListener);
        }
        this.mViewTreeObserver = null;
    }

    private void registerListener(View anchor) {
        if (this.mSuperScrollListener != null) {
            ViewTreeObserver viewTreeObserver = anchor.getWindowToken() != null ? anchor.getViewTreeObserver() : null;
            ViewTreeObserver viewTreeObserver2 = this.mViewTreeObserver;
            if (viewTreeObserver != viewTreeObserver2) {
                if (viewTreeObserver2 != null && viewTreeObserver2.isAlive()) {
                    this.mViewTreeObserver.removeOnScrollChangedListener(this.mSuperScrollListener);
                }
                this.mViewTreeObserver = viewTreeObserver;
                if (viewTreeObserver != null) {
                    viewTreeObserver.addOnScrollChangedListener(this.mSuperScrollListener);
                }
            }
        }
    }

    public void dimBehind() {
        View rootView = getContentView().getRootView();
        WindowManager windowManager = (WindowManager) getContentView().getContext().getSystemService("window");
        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) rootView.getLayoutParams();
        layoutParams.flags |= 2;
        layoutParams.dimAmount = 0.2f;
        windowManager.updateViewLayout(rootView, layoutParams);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View anchor, int xoff, int yoff) {
        try {
            super.showAsDropDown(anchor, xoff, yoff);
            registerListener(anchor);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void startAnimation() {
        if (this.animationEnabled && this.windowAnimatorSet == null) {
            ActionBarPopupWindowLayout actionBarPopupWindowLayout = (ActionBarPopupWindowLayout) getContentView();
            actionBarPopupWindowLayout.setTranslationY(0.0f);
            actionBarPopupWindowLayout.setAlpha(1.0f);
            actionBarPopupWindowLayout.setPivotX(actionBarPopupWindowLayout.getMeasuredWidth());
            actionBarPopupWindowLayout.setPivotY(0.0f);
            int itemsCount = actionBarPopupWindowLayout.getItemsCount();
            actionBarPopupWindowLayout.positions.clear();
            int i = 0;
            for (int i2 = 0; i2 < itemsCount; i2++) {
                View itemAt = actionBarPopupWindowLayout.getItemAt(i2);
                itemAt.setAlpha(0.0f);
                if (itemAt.getVisibility() == 0) {
                    actionBarPopupWindowLayout.positions.put(itemAt, Integer.valueOf(i));
                    i++;
                }
            }
            if (actionBarPopupWindowLayout.shownFromBotton) {
                actionBarPopupWindowLayout.lastStartedChild = itemsCount - 1;
            } else {
                actionBarPopupWindowLayout.lastStartedChild = 0;
            }
            AnimatorSet animatorSet = new AnimatorSet();
            this.windowAnimatorSet = animatorSet;
            animatorSet.playTogether(ObjectAnimator.ofFloat(actionBarPopupWindowLayout, "backScaleY", 0.0f, 1.0f), ObjectAnimator.ofInt(actionBarPopupWindowLayout, "backAlpha", 0, 255));
            this.windowAnimatorSet.setDuration((i * 16) + ImageReceiver.DEFAULT_CROSSFADE_DURATION);
            this.windowAnimatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.ActionBar.ActionBarPopupWindow.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    ActionBarPopupWindow.this.windowAnimatorSet = null;
                    ActionBarPopupWindowLayout actionBarPopupWindowLayout2 = (ActionBarPopupWindowLayout) ActionBarPopupWindow.this.getContentView();
                    int itemsCount2 = actionBarPopupWindowLayout2.getItemsCount();
                    for (int i3 = 0; i3 < itemsCount2; i3++) {
                        actionBarPopupWindowLayout2.getItemAt(i3).setAlpha(1.0f);
                    }
                }
            });
            this.windowAnimatorSet.start();
        }
    }

    @Override // android.widget.PopupWindow
    public void update(View anchor, int xoff, int yoff, int width, int height) {
        super.update(anchor, xoff, yoff, width, height);
        registerListener(anchor);
    }

    @Override // android.widget.PopupWindow
    public void update(View anchor, int width, int height) {
        super.update(anchor, width, height);
        registerListener(anchor);
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(View parent, int gravity, int x, int y) {
        super.showAtLocation(parent, gravity, x, y);
        unregisterListener();
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        dismiss(true);
    }

    public void setPauseNotifications(boolean value) {
        this.pauseNotifications = value;
    }

    public void dismiss(boolean animated) {
        setFocusable(false);
        AnimatorSet animatorSet = this.windowAnimatorSet;
        if (animatorSet != null) {
            if (animated && this.isClosingAnimated) {
                return;
            }
            animatorSet.cancel();
            this.windowAnimatorSet = null;
        }
        this.isClosingAnimated = false;
        if (this.animationEnabled && animated) {
            this.isClosingAnimated = true;
            ViewGroup viewGroup = (ViewGroup) getContentView();
            ActionBarPopupWindowLayout actionBarPopupWindowLayout = null;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                if (viewGroup.getChildAt(i) instanceof ActionBarPopupWindowLayout) {
                    actionBarPopupWindowLayout = (ActionBarPopupWindowLayout) viewGroup.getChildAt(i);
                }
            }
            if (actionBarPopupWindowLayout != null && actionBarPopupWindowLayout.itemAnimators != null && !actionBarPopupWindowLayout.itemAnimators.isEmpty()) {
                int size = actionBarPopupWindowLayout.itemAnimators.size();
                for (int i2 = 0; i2 < size; i2++) {
                    AnimatorSet animatorSet2 = (AnimatorSet) actionBarPopupWindowLayout.itemAnimators.get(i2);
                    animatorSet2.removeAllListeners();
                    animatorSet2.cancel();
                }
                actionBarPopupWindowLayout.itemAnimators.clear();
            }
            AnimatorSet animatorSet3 = new AnimatorSet();
            this.windowAnimatorSet = animatorSet3;
            if (this.outEmptyTime > 0) {
                animatorSet3.playTogether(ValueAnimator.ofFloat(0.0f, 1.0f));
                this.windowAnimatorSet.setDuration(this.outEmptyTime);
            } else {
                Animator[] animatorArr = new Animator[2];
                Property property = View.TRANSLATION_Y;
                float[] fArr = new float[1];
                fArr[0] = AndroidUtilities.dp((actionBarPopupWindowLayout == null || !actionBarPopupWindowLayout.shownFromBotton) ? -5.0f : 5.0f);
                animatorArr[0] = ObjectAnimator.ofFloat(viewGroup, (Property<ViewGroup, Float>) property, fArr);
                animatorArr[1] = ObjectAnimator.ofFloat(viewGroup, (Property<ViewGroup, Float>) View.ALPHA, 0.0f);
                animatorSet3.playTogether(animatorArr);
                this.windowAnimatorSet.setDuration(this.dismissAnimationDuration);
            }
            this.windowAnimatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.ActionBar.ActionBarPopupWindow.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    ActionBarPopupWindow.this.windowAnimatorSet = null;
                    ActionBarPopupWindow.this.isClosingAnimated = false;
                    ActionBarPopupWindow.this.setFocusable(false);
                    try {
                        ActionBarPopupWindow.super.dismiss();
                    } catch (Exception unused) {
                    }
                    ActionBarPopupWindow.this.unregisterListener();
                    if (ActionBarPopupWindow.this.pauseNotifications) {
                        NotificationCenter.getInstance(ActionBarPopupWindow.this.currentAccount).onAnimationFinish(ActionBarPopupWindow.this.popupAnimationIndex);
                    }
                }
            });
            if (this.pauseNotifications) {
                this.popupAnimationIndex = NotificationCenter.getInstance(this.currentAccount).setAnimationInProgress(this.popupAnimationIndex, null);
            }
            this.windowAnimatorSet.start();
            return;
        }
        try {
            super.dismiss();
        } catch (Exception unused) {
        }
        unregisterListener();
    }
}
