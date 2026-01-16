package org.rbmain.ui.ActionBar;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Outline;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.Property;
import android.util.Size;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidMessenger.proxy.CallProxy$$ExternalSyntheticBackport0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ImageReceiver;
import org.rbmain.messenger.LocaleController;

/* loaded from: classes4.dex */
public final class FloatingToolbar {
    private static final MenuItem.OnMenuItemClickListener NO_OP_MENUITEM_CLICK_LISTENER = new MenuItem.OnMenuItemClickListener() { // from class: org.rbmain.ui.ActionBar.FloatingToolbar$$ExternalSyntheticLambda0
        @Override // android.view.MenuItem.OnMenuItemClickListener
        public final boolean onMenuItemClick(MenuItem menuItem) {
            return FloatingToolbar.lambda$static$0(menuItem);
        }
    };
    private int currentStyle;
    private Menu mMenu;
    private final FloatingToolbarPopup mPopup;
    private int mSuggestedWidth;
    private final View mWindowView;
    private final Rect mContentRect = new Rect();
    private final Rect mPreviousContentRect = new Rect();
    private List<MenuItem> mShowingMenuItems = new ArrayList();
    private MenuItem.OnMenuItemClickListener mMenuItemClickListener = NO_OP_MENUITEM_CLICK_LISTENER;
    private boolean mWidthChanged = true;
    private final View.OnLayoutChangeListener mOrientationChangeHandler = new View.OnLayoutChangeListener() { // from class: org.rbmain.ui.ActionBar.FloatingToolbar.1
        private final Rect mNewRect = new Rect();
        private final Rect mOldRect = new Rect();

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.mNewRect.set(i, i2, i3, i4);
            this.mOldRect.set(i5, i6, i7, i8);
            if (!FloatingToolbar.this.mPopup.isShowing() || this.mNewRect.equals(this.mOldRect)) {
                return;
            }
            FloatingToolbar.this.mWidthChanged = true;
            FloatingToolbar.this.updateLayout();
        }
    };
    private final Comparator<MenuItem> mMenuItemComparator = new Comparator() { // from class: org.rbmain.ui.ActionBar.FloatingToolbar$$ExternalSyntheticLambda1
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return FloatingToolbar.lambda$new$1((MenuItem) obj, (MenuItem) obj2);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$static$0(MenuItem menuItem) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$new$1(MenuItem menuItem, MenuItem menuItem2) {
        return menuItem.getOrder() - menuItem2.getOrder();
    }

    public FloatingToolbar(Context context, View view, int i) {
        this.mWindowView = view;
        this.currentStyle = i;
        this.mPopup = new FloatingToolbarPopup(context, view);
    }

    public FloatingToolbar setMenu(Menu menu) {
        this.mMenu = menu;
        return this;
    }

    public FloatingToolbar setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        if (onMenuItemClickListener != null) {
            this.mMenuItemClickListener = onMenuItemClickListener;
        } else {
            this.mMenuItemClickListener = NO_OP_MENUITEM_CLICK_LISTENER;
        }
        return this;
    }

    public FloatingToolbar setContentRect(Rect rect) {
        this.mContentRect.set(rect);
        return this;
    }

    public FloatingToolbar show() {
        registerOrientationHandler();
        doShow();
        return this;
    }

    public FloatingToolbar updateLayout() {
        if (this.mPopup.isShowing()) {
            doShow();
        }
        return this;
    }

    public void dismiss() {
        unregisterOrientationHandler();
        this.mPopup.dismiss();
    }

    public void hide() {
        this.mPopup.hide();
    }

    private void doShow() {
        List<MenuItem> visibleAndEnabledMenuItems = getVisibleAndEnabledMenuItems(this.mMenu);
        Collections.sort(visibleAndEnabledMenuItems, this.mMenuItemComparator);
        if (!isCurrentlyShowing(visibleAndEnabledMenuItems) || this.mWidthChanged) {
            this.mPopup.dismiss();
            this.mPopup.layoutMenuItems(visibleAndEnabledMenuItems, this.mMenuItemClickListener, this.mSuggestedWidth);
            this.mShowingMenuItems = visibleAndEnabledMenuItems;
        }
        if (!this.mPopup.isShowing()) {
            this.mPopup.show(this.mContentRect);
        } else if (!this.mPreviousContentRect.equals(this.mContentRect)) {
            this.mPopup.updateCoordinates(this.mContentRect);
        }
        this.mWidthChanged = false;
        this.mPreviousContentRect.set(this.mContentRect);
    }

    private boolean isCurrentlyShowing(List<MenuItem> list) {
        if (this.mShowingMenuItems == null || list.size() != this.mShowingMenuItems.size()) {
            return false;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            MenuItem menuItem = list.get(i);
            MenuItem menuItem2 = this.mShowingMenuItems.get(i);
            if (menuItem.getItemId() != menuItem2.getItemId() || !TextUtils.equals(menuItem.getTitle(), menuItem2.getTitle()) || !CallProxy$$ExternalSyntheticBackport0.m(menuItem.getIcon(), menuItem2.getIcon()) || menuItem.getGroupId() != menuItem2.getGroupId()) {
                return false;
            }
        }
        return true;
    }

    private List<MenuItem> getVisibleAndEnabledMenuItems(Menu menu) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; menu != null && i < menu.size(); i++) {
            MenuItem item = menu.getItem(i);
            if (item.isVisible() && item.isEnabled()) {
                SubMenu subMenu = item.getSubMenu();
                if (subMenu != null) {
                    arrayList.addAll(getVisibleAndEnabledMenuItems(subMenu));
                } else {
                    arrayList.add(item);
                }
            }
        }
        return arrayList;
    }

    private void registerOrientationHandler() {
        unregisterOrientationHandler();
        this.mWindowView.addOnLayoutChangeListener(this.mOrientationChangeHandler);
    }

    private void unregisterOrientationHandler() {
        this.mWindowView.removeOnLayoutChangeListener(this.mOrientationChangeHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class FloatingToolbarPopup {
        private final Drawable mArrow;
        private final AnimationSet mCloseOverflowAnimation;
        private final ViewGroup mContentContainer;
        private final Context mContext;
        private final AnimatorSet mDismissAnimation;
        private final Interpolator mFastOutLinearInInterpolator;
        private final Interpolator mFastOutSlowInInterpolator;
        private boolean mHidden;
        private final AnimatorSet mHideAnimation;
        private final int mIconTextSpacing;
        private boolean mIsOverflowOpen;
        private final int mLineHeight;
        private final Interpolator mLinearOutSlowInInterpolator;
        private final Interpolator mLogAccelerateInterpolator;
        private final ViewGroup mMainPanel;
        private Size mMainPanelSize;
        private final int mMarginHorizontal;
        private final int mMarginVertical;
        private MenuItem.OnMenuItemClickListener mOnMenuItemClickListener;
        private final AnimationSet mOpenOverflowAnimation;
        private boolean mOpenOverflowUpwards;
        private final Drawable mOverflow;
        private final ImageButton mOverflowButton;
        private final Size mOverflowButtonSize;
        private final OverflowPanel mOverflowPanel;
        private Size mOverflowPanelSize;
        private final OverflowPanelViewHelper mOverflowPanelViewHelper;
        private final View mParent;
        private final PopupWindow mPopupWindow;
        private final AnimatorSet mShowAnimation;
        private final AnimatedVectorDrawable mToArrow;
        private final AnimatedVectorDrawable mToOverflow;
        private int mTransitionDurationScale;
        private final Rect mViewPortOnScreen = new Rect();
        private final Point mCoordsOnWindow = new Point();
        private final int[] mTmpCoords = new int[2];
        private final Region mTouchableRegion = new Region();
        private final Runnable mPreparePopupContentRTLHelper = new Runnable() { // from class: org.rbmain.ui.ActionBar.FloatingToolbar.FloatingToolbarPopup.1
            @Override // java.lang.Runnable
            public void run() {
                FloatingToolbarPopup.this.setPanelsStatesAtRestingPosition();
                FloatingToolbarPopup.this.setContentAreaAsTouchableSurface();
                FloatingToolbarPopup.this.mContentContainer.setAlpha(1.0f);
            }
        };
        private boolean mDismissed = true;
        private final View.OnClickListener mMenuItemButtonOnClickListener = new View.OnClickListener() { // from class: org.rbmain.ui.ActionBar.FloatingToolbar.FloatingToolbarPopup.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!(view.getTag() instanceof MenuItem) || FloatingToolbarPopup.this.mOnMenuItemClickListener == null) {
                    return;
                }
                FloatingToolbarPopup.this.mOnMenuItemClickListener.onMenuItemClick((MenuItem) view.getTag());
            }
        };

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isInRTLMode() {
            return false;
        }

        private void setTouchableSurfaceInsetsComputer() {
        }

        public FloatingToolbarPopup(Context context, View view) {
            this.mParent = view;
            this.mContext = context;
            ViewGroup viewGroupCreateContentContainer = FloatingToolbar.this.createContentContainer(context);
            this.mContentContainer = viewGroupCreateContentContainer;
            this.mPopupWindow = FloatingToolbar.createPopupWindow(viewGroupCreateContentContainer);
            this.mMarginHorizontal = AndroidUtilities.dp(16.0f);
            this.mMarginVertical = AndroidUtilities.dp(8.0f);
            this.mLineHeight = AndroidUtilities.dp(48.0f);
            int iDp = AndroidUtilities.dp(8.0f);
            this.mIconTextSpacing = iDp;
            this.mLogAccelerateInterpolator = new LogAccelerateInterpolator();
            this.mFastOutSlowInInterpolator = AnimationUtils.loadInterpolator(context, R.interpolator.fast_out_slow_in);
            this.mLinearOutSlowInInterpolator = AnimationUtils.loadInterpolator(context, R.interpolator.linear_out_slow_in);
            this.mFastOutLinearInInterpolator = AnimationUtils.loadInterpolator(context, R.interpolator.fast_out_linear_in);
            Drawable drawableMutate = context.getDrawable(ir.medu.shad.R.drawable.ft_avd_tooverflow).mutate();
            this.mArrow = drawableMutate;
            drawableMutate.setAutoMirrored(true);
            Drawable drawableMutate2 = context.getDrawable(ir.medu.shad.R.drawable.ft_avd_toarrow).mutate();
            this.mOverflow = drawableMutate2;
            drawableMutate2.setAutoMirrored(true);
            AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) context.getDrawable(ir.medu.shad.R.drawable.ft_avd_toarrow_animation).mutate();
            this.mToArrow = animatedVectorDrawable;
            animatedVectorDrawable.setAutoMirrored(true);
            AnimatedVectorDrawable animatedVectorDrawable2 = (AnimatedVectorDrawable) context.getDrawable(ir.medu.shad.R.drawable.ft_avd_tooverflow_animation).mutate();
            this.mToOverflow = animatedVectorDrawable2;
            animatedVectorDrawable2.setAutoMirrored(true);
            ImageButton imageButtonCreateOverflowButton = createOverflowButton();
            this.mOverflowButton = imageButtonCreateOverflowButton;
            this.mOverflowButtonSize = measure(imageButtonCreateOverflowButton);
            this.mMainPanel = createMainPanel();
            this.mOverflowPanelViewHelper = new OverflowPanelViewHelper(context, iDp);
            this.mOverflowPanel = createOverflowPanel();
            Animation.AnimationListener animationListenerCreateOverflowAnimationListener = createOverflowAnimationListener();
            AnimationSet animationSet = new AnimationSet(true);
            this.mOpenOverflowAnimation = animationSet;
            animationSet.setAnimationListener(animationListenerCreateOverflowAnimationListener);
            AnimationSet animationSet2 = new AnimationSet(true);
            this.mCloseOverflowAnimation = animationSet2;
            animationSet2.setAnimationListener(animationListenerCreateOverflowAnimationListener);
            this.mShowAnimation = FloatingToolbar.createEnterAnimation(viewGroupCreateContentContainer);
            this.mDismissAnimation = FloatingToolbar.createExitAnimation(viewGroupCreateContentContainer, ImageReceiver.DEFAULT_CROSSFADE_DURATION, new AnimatorListenerAdapter(FloatingToolbar.this) { // from class: org.rbmain.ui.ActionBar.FloatingToolbar.FloatingToolbarPopup.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    FloatingToolbarPopup.this.mPopupWindow.dismiss();
                    FloatingToolbarPopup.this.mContentContainer.removeAllViews();
                }
            });
            this.mHideAnimation = FloatingToolbar.createExitAnimation(viewGroupCreateContentContainer, 0, new AnimatorListenerAdapter(FloatingToolbar.this) { // from class: org.rbmain.ui.ActionBar.FloatingToolbar.FloatingToolbarPopup.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    FloatingToolbarPopup.this.mPopupWindow.dismiss();
                }
            });
        }

        public void layoutMenuItems(List<MenuItem> list, MenuItem.OnMenuItemClickListener onMenuItemClickListener, int i) {
            this.mOnMenuItemClickListener = onMenuItemClickListener;
            cancelOverflowAnimations();
            clearPanels();
            List<MenuItem> listLayoutMainPanelItems = layoutMainPanelItems(list, getAdjustedToolbarWidth(i));
            if (!listLayoutMainPanelItems.isEmpty()) {
                layoutOverflowPanelItems(listLayoutMainPanelItems);
            }
            updatePopupSize();
        }

        public void show(Rect rect) {
            if (isShowing()) {
                return;
            }
            this.mHidden = false;
            this.mDismissed = false;
            cancelDismissAndHideAnimations();
            cancelOverflowAnimations();
            refreshCoordinatesAndOverflowDirection(rect);
            preparePopupContent();
            PopupWindow popupWindow = this.mPopupWindow;
            View view = this.mParent;
            Point point = this.mCoordsOnWindow;
            popupWindow.showAtLocation(view, 0, point.x, point.y);
            setTouchableSurfaceInsetsComputer();
            runShowAnimation();
        }

        public void dismiss() {
            if (this.mDismissed) {
                return;
            }
            this.mHidden = false;
            this.mDismissed = true;
            this.mHideAnimation.cancel();
            runDismissAnimation();
            setZeroTouchableSurface();
        }

        public void hide() {
            if (isShowing()) {
                this.mHidden = true;
                runHideAnimation();
                setZeroTouchableSurface();
            }
        }

        public boolean isShowing() {
            return (this.mDismissed || this.mHidden) ? false : true;
        }

        public void updateCoordinates(Rect rect) {
            if (isShowing() && this.mPopupWindow.isShowing()) {
                cancelOverflowAnimations();
                refreshCoordinatesAndOverflowDirection(rect);
                preparePopupContent();
                PopupWindow popupWindow = this.mPopupWindow;
                Point point = this.mCoordsOnWindow;
                popupWindow.update(point.x, point.y, popupWindow.getWidth(), this.mPopupWindow.getHeight());
            }
        }

        private void refreshCoordinatesAndOverflowDirection(Rect rect) {
            int height;
            refreshViewPort();
            int iMin = Math.min(rect.centerX() - (this.mPopupWindow.getWidth() / 2), this.mViewPortOnScreen.right - this.mPopupWindow.getWidth());
            int i = rect.top;
            Rect rect2 = this.mViewPortOnScreen;
            int i2 = i - rect2.top;
            int i3 = rect2.bottom - rect.bottom;
            int i4 = this.mMarginVertical * 2;
            int i5 = this.mLineHeight + i4;
            if (hasOverflow()) {
                int iCalculateOverflowHeight = calculateOverflowHeight(2) + i4;
                Rect rect3 = this.mViewPortOnScreen;
                int i6 = (rect3.bottom - rect.top) + i5;
                int i7 = (rect.bottom - rect3.top) + i5;
                if (i2 >= iCalculateOverflowHeight) {
                    updateOverflowHeight(i2 - i4);
                    height = rect.top - this.mPopupWindow.getHeight();
                    this.mOpenOverflowUpwards = true;
                } else if (i2 >= i5 && i6 >= iCalculateOverflowHeight) {
                    updateOverflowHeight(i6 - i4);
                    height = rect.top - i5;
                    this.mOpenOverflowUpwards = false;
                } else if (i3 >= iCalculateOverflowHeight) {
                    updateOverflowHeight(i3 - i4);
                    height = rect.bottom;
                    this.mOpenOverflowUpwards = false;
                } else if (i3 >= i5 && rect3.height() >= iCalculateOverflowHeight) {
                    updateOverflowHeight(i7 - i4);
                    height = (rect.bottom + i5) - this.mPopupWindow.getHeight();
                    this.mOpenOverflowUpwards = true;
                } else {
                    updateOverflowHeight(this.mViewPortOnScreen.height() - i4);
                    height = this.mViewPortOnScreen.top;
                    this.mOpenOverflowUpwards = false;
                }
            } else if (i2 >= i5) {
                height = rect.top - i5;
            } else if (i3 >= i5) {
                height = rect.bottom;
            } else if (i3 >= this.mLineHeight) {
                height = rect.bottom - this.mMarginVertical;
            } else {
                height = Math.max(this.mViewPortOnScreen.top, rect.top - i5);
            }
            this.mParent.getRootView().getLocationOnScreen(this.mTmpCoords);
            int[] iArr = this.mTmpCoords;
            int i8 = iArr[0];
            int i9 = iArr[1];
            this.mParent.getRootView().getLocationInWindow(this.mTmpCoords);
            int[] iArr2 = this.mTmpCoords;
            this.mCoordsOnWindow.set(Math.max(0, iMin - (i8 - iArr2[0])), Math.max(0, height - (i9 - iArr2[1])));
        }

        private void runShowAnimation() {
            this.mShowAnimation.start();
        }

        private void runDismissAnimation() {
            this.mDismissAnimation.start();
        }

        private void runHideAnimation() {
            this.mHideAnimation.start();
        }

        private void cancelDismissAndHideAnimations() {
            this.mDismissAnimation.cancel();
            this.mHideAnimation.cancel();
        }

        private void cancelOverflowAnimations() {
            this.mContentContainer.clearAnimation();
            this.mMainPanel.animate().cancel();
            this.mOverflowPanel.animate().cancel();
            this.mToArrow.stop();
            this.mToOverflow.stop();
        }

        private void openOverflow() {
            final int width = this.mOverflowPanelSize.getWidth();
            final int height = this.mOverflowPanelSize.getHeight();
            final int width2 = this.mContentContainer.getWidth();
            final int height2 = this.mContentContainer.getHeight();
            final float y = this.mContentContainer.getY();
            final float x = this.mContentContainer.getX();
            final float width3 = x + this.mContentContainer.getWidth();
            Animation animation = new Animation() { // from class: org.rbmain.ui.ActionBar.FloatingToolbar.FloatingToolbarPopup.5
                @Override // android.view.animation.Animation
                protected void applyTransformation(float f, Transformation transformation) {
                    FloatingToolbarPopup floatingToolbarPopup = FloatingToolbarPopup.this;
                    floatingToolbarPopup.setWidth(floatingToolbarPopup.mContentContainer, width2 + ((int) (f * (width - width2))));
                    if (FloatingToolbarPopup.this.isInRTLMode()) {
                        FloatingToolbarPopup.this.mContentContainer.setX(x);
                        FloatingToolbarPopup.this.mMainPanel.setX(0.0f);
                        FloatingToolbarPopup.this.mOverflowPanel.setX(0.0f);
                    } else {
                        FloatingToolbarPopup.this.mContentContainer.setX(width3 - FloatingToolbarPopup.this.mContentContainer.getWidth());
                        FloatingToolbarPopup.this.mMainPanel.setX(FloatingToolbarPopup.this.mContentContainer.getWidth() - width2);
                        FloatingToolbarPopup.this.mOverflowPanel.setX(FloatingToolbarPopup.this.mContentContainer.getWidth() - width);
                    }
                }
            };
            Animation animation2 = new Animation() { // from class: org.rbmain.ui.ActionBar.FloatingToolbar.FloatingToolbarPopup.6
                @Override // android.view.animation.Animation
                protected void applyTransformation(float f, Transformation transformation) {
                    FloatingToolbarPopup floatingToolbarPopup = FloatingToolbarPopup.this;
                    floatingToolbarPopup.setHeight(floatingToolbarPopup.mContentContainer, height2 + ((int) (f * (height - height2))));
                    if (FloatingToolbarPopup.this.mOpenOverflowUpwards) {
                        FloatingToolbarPopup.this.mContentContainer.setY(y - (FloatingToolbarPopup.this.mContentContainer.getHeight() - height2));
                        FloatingToolbarPopup.this.positionContentYCoordinatesIfOpeningOverflowUpwards();
                    }
                }
            };
            final float x2 = this.mOverflowButton.getX();
            float f = width;
            final float width4 = isInRTLMode() ? (f + x2) - this.mOverflowButton.getWidth() : (x2 - f) + this.mOverflowButton.getWidth();
            Animation animation3 = new Animation() { // from class: org.rbmain.ui.ActionBar.FloatingToolbar.FloatingToolbarPopup.7
                @Override // android.view.animation.Animation
                protected void applyTransformation(float f2, Transformation transformation) {
                    float f3 = x2;
                    FloatingToolbarPopup.this.mOverflowButton.setX(f3 + (f2 * (width4 - f3)) + (FloatingToolbarPopup.this.isInRTLMode() ? 0.0f : FloatingToolbarPopup.this.mContentContainer.getWidth() - width2));
                }
            };
            animation.setInterpolator(this.mLogAccelerateInterpolator);
            animation.setDuration(getAdjustedDuration(250));
            animation2.setInterpolator(this.mFastOutSlowInInterpolator);
            animation2.setDuration(getAdjustedDuration(250));
            animation3.setInterpolator(this.mFastOutSlowInInterpolator);
            animation3.setDuration(getAdjustedDuration(250));
            this.mOpenOverflowAnimation.getAnimations().clear();
            this.mOpenOverflowAnimation.addAnimation(animation);
            this.mOpenOverflowAnimation.addAnimation(animation2);
            this.mOpenOverflowAnimation.addAnimation(animation3);
            this.mContentContainer.startAnimation(this.mOpenOverflowAnimation);
            this.mIsOverflowOpen = true;
            this.mMainPanel.animate().alpha(0.0f).withLayer().setInterpolator(this.mLinearOutSlowInInterpolator).setDuration(250L).start();
            this.mOverflowPanel.setAlpha(1.0f);
        }

        private void closeOverflow() {
            final int width = this.mMainPanelSize.getWidth();
            final int width2 = this.mContentContainer.getWidth();
            final float x = this.mContentContainer.getX();
            final float width3 = x + this.mContentContainer.getWidth();
            Animation animation = new Animation() { // from class: org.rbmain.ui.ActionBar.FloatingToolbar.FloatingToolbarPopup.8
                @Override // android.view.animation.Animation
                protected void applyTransformation(float f, Transformation transformation) {
                    FloatingToolbarPopup floatingToolbarPopup = FloatingToolbarPopup.this;
                    floatingToolbarPopup.setWidth(floatingToolbarPopup.mContentContainer, width2 + ((int) (f * (width - width2))));
                    if (FloatingToolbarPopup.this.isInRTLMode()) {
                        FloatingToolbarPopup.this.mContentContainer.setX(x);
                        FloatingToolbarPopup.this.mMainPanel.setX(0.0f);
                        FloatingToolbarPopup.this.mOverflowPanel.setX(0.0f);
                    } else {
                        FloatingToolbarPopup.this.mContentContainer.setX(width3 - FloatingToolbarPopup.this.mContentContainer.getWidth());
                        FloatingToolbarPopup.this.mMainPanel.setX(FloatingToolbarPopup.this.mContentContainer.getWidth() - width);
                        FloatingToolbarPopup.this.mOverflowPanel.setX(FloatingToolbarPopup.this.mContentContainer.getWidth() - width2);
                    }
                }
            };
            final int height = this.mMainPanelSize.getHeight();
            final int height2 = this.mContentContainer.getHeight();
            final float y = this.mContentContainer.getY() + this.mContentContainer.getHeight();
            Animation animation2 = new Animation() { // from class: org.rbmain.ui.ActionBar.FloatingToolbar.FloatingToolbarPopup.9
                @Override // android.view.animation.Animation
                protected void applyTransformation(float f, Transformation transformation) {
                    FloatingToolbarPopup floatingToolbarPopup = FloatingToolbarPopup.this;
                    floatingToolbarPopup.setHeight(floatingToolbarPopup.mContentContainer, height2 + ((int) (f * (height - height2))));
                    if (FloatingToolbarPopup.this.mOpenOverflowUpwards) {
                        FloatingToolbarPopup.this.mContentContainer.setY(y - FloatingToolbarPopup.this.mContentContainer.getHeight());
                        FloatingToolbarPopup.this.positionContentYCoordinatesIfOpeningOverflowUpwards();
                    }
                }
            };
            final float x2 = this.mOverflowButton.getX();
            final float width4 = isInRTLMode() ? (x2 - width2) + this.mOverflowButton.getWidth() : (width2 + x2) - this.mOverflowButton.getWidth();
            Animation animation3 = new Animation() { // from class: org.rbmain.ui.ActionBar.FloatingToolbar.FloatingToolbarPopup.10
                @Override // android.view.animation.Animation
                protected void applyTransformation(float f, Transformation transformation) {
                    float f2 = x2;
                    FloatingToolbarPopup.this.mOverflowButton.setX(f2 + (f * (width4 - f2)) + (FloatingToolbarPopup.this.isInRTLMode() ? 0.0f : FloatingToolbarPopup.this.mContentContainer.getWidth() - width2));
                }
            };
            animation.setInterpolator(this.mFastOutSlowInInterpolator);
            animation.setDuration(getAdjustedDuration(250));
            animation2.setInterpolator(this.mLogAccelerateInterpolator);
            animation2.setDuration(getAdjustedDuration(250));
            animation3.setInterpolator(this.mFastOutSlowInInterpolator);
            animation3.setDuration(getAdjustedDuration(250));
            this.mCloseOverflowAnimation.getAnimations().clear();
            this.mCloseOverflowAnimation.addAnimation(animation);
            this.mCloseOverflowAnimation.addAnimation(animation2);
            this.mCloseOverflowAnimation.addAnimation(animation3);
            this.mContentContainer.startAnimation(this.mCloseOverflowAnimation);
            this.mIsOverflowOpen = false;
            this.mMainPanel.animate().alpha(1.0f).withLayer().setInterpolator(this.mFastOutLinearInInterpolator).setDuration(100L).start();
            this.mOverflowPanel.animate().alpha(0.0f).withLayer().setInterpolator(this.mLinearOutSlowInInterpolator).setDuration(150L).start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPanelsStatesAtRestingPosition() {
            this.mOverflowButton.setEnabled(true);
            this.mOverflowPanel.awakenScrollBars();
            if (this.mIsOverflowOpen) {
                setSize(this.mContentContainer, this.mOverflowPanelSize);
                this.mMainPanel.setAlpha(0.0f);
                this.mMainPanel.setVisibility(4);
                this.mOverflowPanel.setAlpha(1.0f);
                this.mOverflowPanel.setVisibility(0);
                this.mOverflowButton.setImageDrawable(this.mArrow);
                this.mOverflowButton.setContentDescription(LocaleController.getString("AccDescrMoreOptions", ir.medu.shad.R.string.AccDescrMoreOptions));
                if (isInRTLMode()) {
                    this.mContentContainer.setX(this.mMarginHorizontal);
                    this.mMainPanel.setX(0.0f);
                    this.mOverflowButton.setX(r0.getWidth() - this.mOverflowButtonSize.getWidth());
                    this.mOverflowPanel.setX(0.0f);
                } else {
                    this.mContentContainer.setX((this.mPopupWindow.getWidth() - r0.getWidth()) - this.mMarginHorizontal);
                    this.mMainPanel.setX(-this.mContentContainer.getX());
                    this.mOverflowButton.setX(0.0f);
                    this.mOverflowPanel.setX(0.0f);
                }
                if (this.mOpenOverflowUpwards) {
                    this.mContentContainer.setY(this.mMarginVertical);
                    this.mMainPanel.setY(r0.getHeight() - this.mContentContainer.getHeight());
                    this.mOverflowButton.setY(r0.getHeight() - this.mOverflowButtonSize.getHeight());
                    this.mOverflowPanel.setY(0.0f);
                    return;
                }
                this.mContentContainer.setY(this.mMarginVertical);
                this.mMainPanel.setY(0.0f);
                this.mOverflowButton.setY(0.0f);
                this.mOverflowPanel.setY(this.mOverflowButtonSize.getHeight());
                return;
            }
            setSize(this.mContentContainer, this.mMainPanelSize);
            this.mMainPanel.setAlpha(1.0f);
            this.mMainPanel.setVisibility(0);
            this.mOverflowPanel.setAlpha(0.0f);
            this.mOverflowPanel.setVisibility(4);
            this.mOverflowButton.setImageDrawable(this.mOverflow);
            this.mOverflowButton.setContentDescription(LocaleController.getString("AccDescrMoreOptions", ir.medu.shad.R.string.AccDescrMoreOptions));
            if (hasOverflow()) {
                if (isInRTLMode()) {
                    this.mContentContainer.setX(this.mMarginHorizontal);
                    this.mMainPanel.setX(0.0f);
                    this.mOverflowButton.setX(0.0f);
                    this.mOverflowPanel.setX(0.0f);
                } else {
                    this.mContentContainer.setX((this.mPopupWindow.getWidth() - r0.getWidth()) - this.mMarginHorizontal);
                    this.mMainPanel.setX(0.0f);
                    this.mOverflowButton.setX(r0.getWidth() - this.mOverflowButtonSize.getWidth());
                    this.mOverflowPanel.setX(r0.getWidth() - this.mOverflowPanelSize.getWidth());
                }
                if (this.mOpenOverflowUpwards) {
                    this.mContentContainer.setY((this.mMarginVertical + this.mOverflowPanelSize.getHeight()) - r0.getHeight());
                    this.mMainPanel.setY(0.0f);
                    this.mOverflowButton.setY(0.0f);
                    this.mOverflowPanel.setY(r0.getHeight() - this.mOverflowPanelSize.getHeight());
                    return;
                }
                this.mContentContainer.setY(this.mMarginVertical);
                this.mMainPanel.setY(0.0f);
                this.mOverflowButton.setY(0.0f);
                this.mOverflowPanel.setY(this.mOverflowButtonSize.getHeight());
                return;
            }
            this.mContentContainer.setX(this.mMarginHorizontal);
            this.mContentContainer.setY(this.mMarginVertical);
            this.mMainPanel.setX(0.0f);
            this.mMainPanel.setY(0.0f);
        }

        private void updateOverflowHeight(int i) {
            if (hasOverflow()) {
                int iCalculateOverflowHeight = calculateOverflowHeight((i - this.mOverflowButtonSize.getHeight()) / this.mLineHeight);
                if (this.mOverflowPanelSize.getHeight() != iCalculateOverflowHeight) {
                    this.mOverflowPanelSize = new Size(this.mOverflowPanelSize.getWidth(), iCalculateOverflowHeight);
                }
                setSize(this.mOverflowPanel, this.mOverflowPanelSize);
                if (this.mIsOverflowOpen) {
                    setSize(this.mContentContainer, this.mOverflowPanelSize);
                    if (this.mOpenOverflowUpwards) {
                        int height = this.mOverflowPanelSize.getHeight() - iCalculateOverflowHeight;
                        ViewGroup viewGroup = this.mContentContainer;
                        float f = height;
                        viewGroup.setY(viewGroup.getY() + f);
                        ImageButton imageButton = this.mOverflowButton;
                        imageButton.setY(imageButton.getY() - f);
                    }
                } else {
                    setSize(this.mContentContainer, this.mMainPanelSize);
                }
                updatePopupSize();
            }
        }

        private void updatePopupSize() {
            int iMax;
            Size size = this.mMainPanelSize;
            int iMax2 = 0;
            if (size != null) {
                iMax2 = Math.max(0, size.getWidth());
                iMax = Math.max(0, this.mMainPanelSize.getHeight());
            } else {
                iMax = 0;
            }
            Size size2 = this.mOverflowPanelSize;
            if (size2 != null) {
                iMax2 = Math.max(iMax2, size2.getWidth());
                iMax = Math.max(iMax, this.mOverflowPanelSize.getHeight());
            }
            this.mPopupWindow.setWidth(iMax2 + (this.mMarginHorizontal * 2));
            this.mPopupWindow.setHeight(iMax + (this.mMarginVertical * 2));
            maybeComputeTransitionDurationScale();
        }

        private void refreshViewPort() {
            this.mParent.getWindowVisibleDisplayFrame(this.mViewPortOnScreen);
        }

        private int getAdjustedToolbarWidth(int i) {
            refreshViewPort();
            int iWidth = this.mViewPortOnScreen.width() - (AndroidUtilities.dp(16.0f) * 2);
            if (i <= 0) {
                i = AndroidUtilities.dp(400.0f);
            }
            return Math.min(i, iWidth);
        }

        private void setZeroTouchableSurface() {
            this.mTouchableRegion.setEmpty();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setContentAreaAsTouchableSurface() {
            int width;
            int height;
            if (this.mIsOverflowOpen) {
                width = this.mOverflowPanelSize.getWidth();
                height = this.mOverflowPanelSize.getHeight();
            } else {
                width = this.mMainPanelSize.getWidth();
                height = this.mMainPanelSize.getHeight();
            }
            this.mTouchableRegion.set((int) this.mContentContainer.getX(), (int) this.mContentContainer.getY(), ((int) this.mContentContainer.getX()) + width, ((int) this.mContentContainer.getY()) + height);
        }

        private boolean hasOverflow() {
            return this.mOverflowPanelSize != null;
        }

        public List<MenuItem> layoutMainPanelItems(List<MenuItem> list, int i) {
            LinkedList linkedList = new LinkedList(list);
            this.mMainPanel.removeAllViews();
            this.mMainPanel.setPaddingRelative(0, 0, 0, 0);
            int i2 = i;
            boolean z = true;
            while (!linkedList.isEmpty()) {
                MenuItem menuItem = (MenuItem) linkedList.peek();
                View viewCreateMenuItemButton = FloatingToolbar.this.createMenuItemButton(this.mContext, menuItem, this.mIconTextSpacing);
                if (viewCreateMenuItemButton instanceof LinearLayout) {
                    ((LinearLayout) viewCreateMenuItemButton).setGravity(17);
                }
                if (z) {
                    double paddingStart = viewCreateMenuItemButton.getPaddingStart();
                    Double.isNaN(paddingStart);
                    viewCreateMenuItemButton.setPaddingRelative((int) (paddingStart * 1.5d), viewCreateMenuItemButton.getPaddingTop(), viewCreateMenuItemButton.getPaddingEnd(), viewCreateMenuItemButton.getPaddingBottom());
                }
                boolean z2 = linkedList.size() == 1;
                if (z2) {
                    int paddingStart2 = viewCreateMenuItemButton.getPaddingStart();
                    int paddingTop = viewCreateMenuItemButton.getPaddingTop();
                    double paddingEnd = viewCreateMenuItemButton.getPaddingEnd();
                    Double.isNaN(paddingEnd);
                    viewCreateMenuItemButton.setPaddingRelative(paddingStart2, paddingTop, (int) (paddingEnd * 1.5d), viewCreateMenuItemButton.getPaddingBottom());
                }
                viewCreateMenuItemButton.measure(0, 0);
                int iMin = Math.min(viewCreateMenuItemButton.getMeasuredWidth(), i);
                boolean z3 = iMin <= i2 - this.mOverflowButtonSize.getWidth();
                boolean z4 = z2 && iMin <= i2;
                if (!z3 && !z4) {
                    break;
                }
                setButtonTagAndClickListener(viewCreateMenuItemButton, menuItem);
                this.mMainPanel.addView(viewCreateMenuItemButton);
                ViewGroup.LayoutParams layoutParams = viewCreateMenuItemButton.getLayoutParams();
                layoutParams.width = iMin;
                viewCreateMenuItemButton.setLayoutParams(layoutParams);
                i2 -= iMin;
                linkedList.pop();
                z = false;
            }
            if (!linkedList.isEmpty()) {
                this.mMainPanel.setPaddingRelative(0, 0, this.mOverflowButtonSize.getWidth(), 0);
            }
            this.mMainPanelSize = measure(this.mMainPanel);
            return linkedList;
        }

        private void layoutOverflowPanelItems(List<MenuItem> list) {
            ArrayAdapter arrayAdapter = (ArrayAdapter) this.mOverflowPanel.getAdapter();
            arrayAdapter.clear();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                arrayAdapter.add(list.get(i));
            }
            this.mOverflowPanel.setAdapter((ListAdapter) arrayAdapter);
            if (this.mOpenOverflowUpwards) {
                this.mOverflowPanel.setY(0.0f);
            } else {
                this.mOverflowPanel.setY(this.mOverflowButtonSize.getHeight());
            }
            Size size2 = new Size(Math.max(getOverflowWidth(), this.mOverflowButtonSize.getWidth()), calculateOverflowHeight(4));
            this.mOverflowPanelSize = size2;
            setSize(this.mOverflowPanel, size2);
        }

        private void preparePopupContent() {
            this.mContentContainer.removeAllViews();
            if (hasOverflow()) {
                this.mContentContainer.addView(this.mOverflowPanel);
            }
            this.mContentContainer.addView(this.mMainPanel);
            if (hasOverflow()) {
                this.mContentContainer.addView(this.mOverflowButton);
            }
            setPanelsStatesAtRestingPosition();
            setContentAreaAsTouchableSurface();
            if (isInRTLMode()) {
                this.mContentContainer.setAlpha(0.0f);
                this.mContentContainer.post(this.mPreparePopupContentRTLHelper);
            }
        }

        private void clearPanels() {
            this.mOverflowPanelSize = null;
            this.mMainPanelSize = null;
            this.mIsOverflowOpen = false;
            this.mMainPanel.removeAllViews();
            ArrayAdapter arrayAdapter = (ArrayAdapter) this.mOverflowPanel.getAdapter();
            arrayAdapter.clear();
            this.mOverflowPanel.setAdapter((ListAdapter) arrayAdapter);
            this.mContentContainer.removeAllViews();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void positionContentYCoordinatesIfOpeningOverflowUpwards() {
            if (this.mOpenOverflowUpwards) {
                this.mMainPanel.setY(this.mContentContainer.getHeight() - this.mMainPanelSize.getHeight());
                this.mOverflowButton.setY(this.mContentContainer.getHeight() - this.mOverflowButton.getHeight());
                this.mOverflowPanel.setY(this.mContentContainer.getHeight() - this.mOverflowPanelSize.getHeight());
            }
        }

        private int getOverflowWidth() {
            int count = this.mOverflowPanel.getAdapter().getCount();
            int iMax = 0;
            for (int i = 0; i < count; i++) {
                iMax = Math.max(this.mOverflowPanelViewHelper.calculateWidth((MenuItem) this.mOverflowPanel.getAdapter().getItem(i)), iMax);
            }
            return iMax;
        }

        private int calculateOverflowHeight(int i) {
            int iMin = Math.min(4, Math.min(Math.max(2, i), this.mOverflowPanel.getCount()));
            return (iMin * this.mLineHeight) + this.mOverflowButtonSize.getHeight() + (iMin < this.mOverflowPanel.getCount() ? (int) (this.mLineHeight * 0.5f) : 0);
        }

        private void setButtonTagAndClickListener(View view, MenuItem menuItem) {
            view.setTag(menuItem);
            view.setOnClickListener(this.mMenuItemButtonOnClickListener);
        }

        private int getAdjustedDuration(int i) {
            int i2 = this.mTransitionDurationScale;
            if (i2 < 150) {
                return Math.max(i - 50, 0);
            }
            return i2 > 300 ? i + 50 : i;
        }

        private void maybeComputeTransitionDurationScale() {
            Size size = this.mMainPanelSize;
            if (size == null || this.mOverflowPanelSize == null) {
                return;
            }
            int width = size.getWidth() - this.mOverflowPanelSize.getWidth();
            int height = this.mOverflowPanelSize.getHeight() - this.mMainPanelSize.getHeight();
            double dSqrt = Math.sqrt((width * width) + (height * height));
            double d = this.mContentContainer.getContext().getResources().getDisplayMetrics().density;
            Double.isNaN(d);
            this.mTransitionDurationScale = (int) (dSqrt / d);
        }

        private ViewGroup createMainPanel() {
            return new LinearLayout(this.mContext) { // from class: org.rbmain.ui.ActionBar.FloatingToolbar.FloatingToolbarPopup.11
                @Override // android.widget.LinearLayout, android.view.View
                protected void onMeasure(int i, int i2) {
                    if (FloatingToolbarPopup.this.isOverflowAnimating()) {
                        i = View.MeasureSpec.makeMeasureSpec(FloatingToolbarPopup.this.mMainPanelSize.getWidth(), 1073741824);
                    }
                    super.onMeasure(i, i2);
                }

                @Override // android.view.ViewGroup
                public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
                    return FloatingToolbarPopup.this.isOverflowAnimating();
                }
            };
        }

        private ImageButton createOverflowButton() {
            int color;
            final ImageButton imageButton = new ImageButton(this.mContext);
            imageButton.setLayoutParams(new ViewGroup.LayoutParams(AndroidUtilities.dp(56.0f), AndroidUtilities.dp(48.0f)));
            imageButton.setPaddingRelative(AndroidUtilities.dp(16.0f), AndroidUtilities.dp(12.0f), AndroidUtilities.dp(16.0f), AndroidUtilities.dp(12.0f));
            imageButton.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageButton.setImageDrawable(this.mOverflow);
            if (FloatingToolbar.this.currentStyle != 0) {
                if (FloatingToolbar.this.currentStyle == 2) {
                    color = -328966;
                    imageButton.setBackgroundDrawable(Theme.createSelectorDrawable(1090519039, 1));
                } else {
                    color = Theme.getColor(Theme.key_windowBackgroundWhiteBlackText);
                    imageButton.setBackgroundDrawable(Theme.createSelectorDrawable(Theme.getColor(Theme.key_listSelector), 1));
                }
            } else {
                color = Theme.getColor(Theme.key_dialogTextBlack);
                imageButton.setBackgroundDrawable(Theme.createSelectorDrawable(Theme.getColor(Theme.key_listSelector), 1));
            }
            this.mOverflow.setTint(color);
            this.mArrow.setTint(color);
            this.mToArrow.setTint(color);
            this.mToOverflow.setTint(color);
            imageButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.ActionBar.FloatingToolbar$FloatingToolbarPopup$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$createOverflowButton$0(imageButton, view);
                }
            });
            return imageButton;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$createOverflowButton$0(ImageButton imageButton, View view) {
            if (this.mIsOverflowOpen) {
                imageButton.setImageDrawable(this.mToOverflow);
                this.mToOverflow.start();
                closeOverflow();
            } else {
                imageButton.setImageDrawable(this.mToArrow);
                this.mToArrow.start();
                openOverflow();
            }
        }

        private OverflowPanel createOverflowPanel() {
            final OverflowPanel overflowPanel = new OverflowPanel(this, this);
            overflowPanel.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            overflowPanel.setDivider(null);
            overflowPanel.setDividerHeight(0);
            overflowPanel.setAdapter((ListAdapter) new ArrayAdapter<MenuItem>(this.mContext, 0) { // from class: org.rbmain.ui.ActionBar.FloatingToolbar.FloatingToolbarPopup.12
                @Override // android.widget.ArrayAdapter, android.widget.Adapter
                public View getView(int i, View view, ViewGroup viewGroup) {
                    return FloatingToolbarPopup.this.mOverflowPanelViewHelper.getView(getItem(i), FloatingToolbarPopup.this.mOverflowPanelSize.getWidth(), view);
                }
            });
            overflowPanel.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: org.rbmain.ui.ActionBar.FloatingToolbar$FloatingToolbarPopup$$ExternalSyntheticLambda1
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                    this.f$0.lambda$createOverflowPanel$1(overflowPanel, adapterView, view, i, j);
                }
            });
            return overflowPanel;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$createOverflowPanel$1(OverflowPanel overflowPanel, AdapterView adapterView, View view, int i, long j) {
            MenuItem menuItem = (MenuItem) overflowPanel.getAdapter().getItem(i);
            MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.mOnMenuItemClickListener;
            if (onMenuItemClickListener != null) {
                onMenuItemClickListener.onMenuItemClick(menuItem);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isOverflowAnimating() {
            return (this.mOpenOverflowAnimation.hasStarted() && !this.mOpenOverflowAnimation.hasEnded()) || (this.mCloseOverflowAnimation.hasStarted() && !this.mCloseOverflowAnimation.hasEnded());
        }

        /* renamed from: org.rbmain.ui.ActionBar.FloatingToolbar$FloatingToolbarPopup$13, reason: invalid class name */
        class AnonymousClass13 implements Animation.AnimationListener {
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            AnonymousClass13() {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                FloatingToolbarPopup.this.mOverflowButton.setEnabled(false);
                FloatingToolbarPopup.this.mMainPanel.setVisibility(0);
                FloatingToolbarPopup.this.mOverflowPanel.setVisibility(0);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                FloatingToolbarPopup.this.mContentContainer.post(new Runnable() { // from class: org.rbmain.ui.ActionBar.FloatingToolbar$FloatingToolbarPopup$13$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onAnimationEnd$0();
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onAnimationEnd$0() {
                FloatingToolbarPopup.this.setPanelsStatesAtRestingPosition();
                FloatingToolbarPopup.this.setContentAreaAsTouchableSurface();
            }
        }

        private Animation.AnimationListener createOverflowAnimationListener() {
            return new AnonymousClass13();
        }

        private Size measure(View view) {
            view.measure(0, 0);
            return new Size(view.getMeasuredWidth(), view.getMeasuredHeight());
        }

        private void setSize(View view, int i, int i2) {
            view.setMinimumWidth(i);
            view.setMinimumHeight(i2);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(0, 0);
            }
            layoutParams.width = i;
            layoutParams.height = i2;
            view.setLayoutParams(layoutParams);
        }

        private void setSize(View view, Size size) {
            setSize(view, size.getWidth(), size.getHeight());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setWidth(View view, int i) {
            setSize(view, i, view.getLayoutParams().height);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setHeight(View view, int i) {
            setSize(view, view.getLayoutParams().width, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        final class OverflowPanel extends ListView {
            private final FloatingToolbarPopup mPopup;

            OverflowPanel(FloatingToolbarPopup floatingToolbarPopup, FloatingToolbarPopup floatingToolbarPopup2) {
                super(floatingToolbarPopup2.mContext);
                this.mPopup = floatingToolbarPopup2;
                setVerticalScrollBarEnabled(false);
                setOutlineProvider(new ViewOutlineProvider(this, floatingToolbarPopup) { // from class: org.rbmain.ui.ActionBar.FloatingToolbar.FloatingToolbarPopup.OverflowPanel.1
                    @Override // android.view.ViewOutlineProvider
                    public void getOutline(View view, Outline outline) {
                        outline.setRoundRect(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight(), AndroidUtilities.dp(6.0f));
                    }
                });
                setClipToOutline(true);
            }

            @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
            protected void onMeasure(int i, int i2) {
                super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(this.mPopup.mOverflowPanelSize.getHeight() - this.mPopup.mOverflowButtonSize.getHeight(), 1073741824));
            }

            @Override // android.view.ViewGroup, android.view.View
            public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                if (this.mPopup.isOverflowAnimating()) {
                    return true;
                }
                return super.dispatchTouchEvent(motionEvent);
            }

            @Override // android.view.View
            protected boolean awakenScrollBars() {
                return super.awakenScrollBars();
            }
        }

        private final class LogAccelerateInterpolator implements Interpolator {
            private final float LOGS_SCALE;

            private LogAccelerateInterpolator(FloatingToolbarPopup floatingToolbarPopup) {
                this.LOGS_SCALE = 1.0f / computeLog(1.0f, 100);
            }

            private float computeLog(float f, int i) {
                return (float) (1.0d - Math.pow(i, -f));
            }

            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                return 1.0f - (computeLog(1.0f - f, 100) * this.LOGS_SCALE);
            }
        }

        private final class OverflowPanelViewHelper {
            private final Context mContext;
            private final int mIconTextSpacing;
            private final int mSidePadding = AndroidUtilities.dp(18.0f);
            private final View mCalculator = createMenuButton(null);

            public OverflowPanelViewHelper(Context context, int i) {
                this.mContext = context;
                this.mIconTextSpacing = i;
            }

            public View getView(MenuItem menuItem, int i, View view) {
                if (view != null) {
                    FloatingToolbar.updateMenuItemButton(view, menuItem, this.mIconTextSpacing);
                } else {
                    view = createMenuButton(menuItem);
                }
                view.setMinimumWidth(i);
                return view;
            }

            public int calculateWidth(MenuItem menuItem) {
                FloatingToolbar.updateMenuItemButton(this.mCalculator, menuItem, this.mIconTextSpacing);
                this.mCalculator.measure(0, 0);
                return this.mCalculator.getMeasuredWidth();
            }

            private View createMenuButton(MenuItem menuItem) {
                View viewCreateMenuItemButton = FloatingToolbar.this.createMenuItemButton(this.mContext, menuItem, this.mIconTextSpacing);
                int i = this.mSidePadding;
                viewCreateMenuItemButton.setPadding(i, 0, i, 0);
                return viewCreateMenuItemButton;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View createMenuItemButton(Context context, MenuItem menuItem, int i) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        linearLayout.setOrientation(0);
        linearLayout.setMinimumWidth(AndroidUtilities.dp(48.0f));
        linearLayout.setMinimumHeight(AndroidUtilities.dp(48.0f));
        linearLayout.setPaddingRelative(AndroidUtilities.dp(16.0f), 0, AndroidUtilities.dp(16.0f), 0);
        TextView textView = new TextView(context);
        textView.setGravity(17);
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        textView.setTextSize(1, 14.0f);
        textView.setFocusable(false);
        textView.setImportantForAccessibility(2);
        textView.setFocusableInTouchMode(false);
        int i2 = this.currentStyle;
        if (i2 == 0) {
            textView.setTextColor(Theme.getColor(Theme.key_dialogTextBlack));
            linearLayout.setBackgroundDrawable(Theme.getSelectorDrawable(false));
        } else if (i2 == 2) {
            textView.setTextColor(-328966);
            linearLayout.setBackgroundDrawable(Theme.getSelectorDrawable(1090519039, false));
        } else if (i2 == 1) {
            textView.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteBlackText));
            linearLayout.setBackgroundDrawable(Theme.getSelectorDrawable(false));
        }
        textView.setPaddingRelative(AndroidUtilities.dp(11.0f), 0, 0, 0);
        linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, AndroidUtilities.dp(48.0f)));
        if (menuItem != null) {
            updateMenuItemButton(linearLayout, menuItem, i);
        }
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void updateMenuItemButton(View view, MenuItem menuItem, int i) {
        TextView textView = (TextView) ((ViewGroup) view).getChildAt(0);
        textView.setEllipsize(null);
        if (TextUtils.isEmpty(menuItem.getTitle())) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(menuItem.getTitle());
        }
        textView.setPaddingRelative(0, 0, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ViewGroup createContentContainer(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        int iDp = AndroidUtilities.dp(20.0f);
        marginLayoutParams.rightMargin = iDp;
        marginLayoutParams.topMargin = iDp;
        marginLayoutParams.leftMargin = iDp;
        marginLayoutParams.bottomMargin = iDp;
        relativeLayout.setLayoutParams(marginLayoutParams);
        relativeLayout.setElevation(AndroidUtilities.dp(2.0f));
        relativeLayout.setFocusable(true);
        relativeLayout.setFocusableInTouchMode(true);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        float fDp = AndroidUtilities.dp(6.0f);
        gradientDrawable.setCornerRadii(new float[]{fDp, fDp, fDp, fDp, fDp, fDp, fDp, fDp});
        int i = this.currentStyle;
        if (i == 0) {
            gradientDrawable.setColor(Theme.getColor(Theme.key_dialogBackground));
        } else if (i == 2) {
            gradientDrawable.setColor(-115203550);
        } else if (i == 1) {
            gradientDrawable.setColor(Theme.getColor(Theme.key_windowBackgroundWhite));
        }
        relativeLayout.setBackgroundDrawable(gradientDrawable);
        relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        relativeLayout.setClipToOutline(true);
        return relativeLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static PopupWindow createPopupWindow(ViewGroup viewGroup) {
        LinearLayout linearLayout = new LinearLayout(viewGroup.getContext());
        PopupWindow popupWindow = new PopupWindow(linearLayout);
        popupWindow.setClippingEnabled(false);
        popupWindow.setAnimationStyle(0);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        viewGroup.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        linearLayout.addView(viewGroup);
        return popupWindow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AnimatorSet createEnterAnimation(View view) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, 0.0f, 1.0f).setDuration(150L));
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AnimatorSet createExitAnimation(View view, int i, Animator.AnimatorListener animatorListener) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, 1.0f, 0.0f).setDuration(100L));
        animatorSet.setStartDelay(i);
        animatorSet.addListener(animatorListener);
        return animatorSet;
    }
}
