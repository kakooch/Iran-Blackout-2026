package ir.eitaa.ui.ActionBar;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.PopupMenu;
import ir.eitaa.messenger.AndroidUtilities;
import java.util.Arrays;

@TargetApi(23)
/* loaded from: classes3.dex */
public final class FloatingActionMode extends ActionMode {
    private final int mBottomAllowance;
    private final ActionMode.Callback2 mCallback;
    private final Rect mContentRect;
    private final Rect mContentRectOnScreen;
    private final Context mContext;
    private final Point mDisplaySize;
    private FloatingToolbar mFloatingToolbar;
    private FloatingToolbarVisibilityHelper mFloatingToolbarVisibilityHelper;
    private final Menu mMenu;
    private final View mOriginatingView;
    private final Rect mPreviousContentRectOnScreen;
    private final int[] mPreviousViewPositionOnScreen;
    private final Rect mPreviousViewRectOnScreen;
    private final int[] mRootViewPositionOnScreen;
    private final Rect mScreenRect;
    private final int[] mViewPositionOnScreen;
    private final Rect mViewRectOnScreen;
    private final Runnable mMovingOff = new Runnable() { // from class: ir.eitaa.ui.ActionBar.FloatingActionMode.1
        @Override // java.lang.Runnable
        public void run() {
            if (FloatingActionMode.this.isViewStillActive()) {
                FloatingActionMode.this.mFloatingToolbarVisibilityHelper.setMoving(false);
                FloatingActionMode.this.mFloatingToolbarVisibilityHelper.updateToolbarVisibility();
            }
        }
    };
    private final Runnable mHideOff = new Runnable() { // from class: ir.eitaa.ui.ActionBar.FloatingActionMode.2
        @Override // java.lang.Runnable
        public void run() {
            if (FloatingActionMode.this.isViewStillActive()) {
                FloatingActionMode.this.mFloatingToolbarVisibilityHelper.setHideRequested(false);
                FloatingActionMode.this.mFloatingToolbarVisibilityHelper.updateToolbarVisibility();
            }
        }
    };

    @Override // android.view.ActionMode
    public View getCustomView() {
        return null;
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return null;
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return null;
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int resId) {
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence subtitle) {
    }

    @Override // android.view.ActionMode
    public void setTitle(int resId) {
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence title) {
    }

    public FloatingActionMode(Context context, ActionMode.Callback2 callback, View originatingView, FloatingToolbar floatingToolbar) {
        this.mContext = context;
        this.mCallback = callback;
        PopupMenu popupMenu = new PopupMenu(context, null);
        this.mMenu = popupMenu.getMenu();
        setType(1);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: ir.eitaa.ui.ActionBar.-$$Lambda$FloatingActionMode$9gHh85wKxfZrpwZLOPu25112N0s
            @Override // android.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return this.f$0.lambda$new$0$FloatingActionMode(menuItem);
            }
        });
        this.mContentRect = new Rect();
        this.mContentRectOnScreen = new Rect();
        this.mPreviousContentRectOnScreen = new Rect();
        int[] iArr = new int[2];
        this.mViewPositionOnScreen = iArr;
        this.mPreviousViewPositionOnScreen = new int[2];
        this.mRootViewPositionOnScreen = new int[2];
        this.mViewRectOnScreen = new Rect();
        this.mPreviousViewRectOnScreen = new Rect();
        this.mScreenRect = new Rect();
        this.mOriginatingView = originatingView;
        originatingView.getLocationOnScreen(iArr);
        this.mBottomAllowance = AndroidUtilities.dp(20.0f);
        this.mDisplaySize = new Point();
        setFloatingToolbar(floatingToolbar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$new$0$FloatingActionMode(MenuItem menuItem) {
        return this.mCallback.onActionItemClicked(this, menuItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setFloatingToolbar$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$setFloatingToolbar$1$FloatingActionMode(MenuItem menuItem) {
        return this.mCallback.onActionItemClicked(this, menuItem);
    }

    private void setFloatingToolbar(FloatingToolbar floatingToolbar) {
        FloatingToolbar onMenuItemClickListener = floatingToolbar.setMenu(this.mMenu).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { // from class: ir.eitaa.ui.ActionBar.-$$Lambda$FloatingActionMode$XZ1m3Et8yyuNY566PRE_vh4ca2E
            @Override // android.view.MenuItem.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return this.f$0.lambda$setFloatingToolbar$1$FloatingActionMode(menuItem);
            }
        });
        this.mFloatingToolbar = onMenuItemClickListener;
        FloatingToolbarVisibilityHelper floatingToolbarVisibilityHelper = new FloatingToolbarVisibilityHelper(onMenuItemClickListener);
        this.mFloatingToolbarVisibilityHelper = floatingToolbarVisibilityHelper;
        floatingToolbarVisibilityHelper.activate();
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.mCallback.onPrepareActionMode(this, this.mMenu);
        invalidateContentRect();
    }

    @Override // android.view.ActionMode
    public void invalidateContentRect() {
        this.mCallback.onGetContentRect(this, this.mOriginatingView, this.mContentRect);
        Rect rect = this.mContentRect;
        if (rect.left == 0 && rect.right == 0) {
            rect.left = 1;
            rect.right = 1;
        }
        repositionToolbar();
    }

    public void updateViewLocationInWindow() {
        this.mOriginatingView.getLocationOnScreen(this.mViewPositionOnScreen);
        this.mOriginatingView.getRootView().getLocationOnScreen(this.mRootViewPositionOnScreen);
        this.mOriginatingView.getGlobalVisibleRect(this.mViewRectOnScreen);
        Rect rect = this.mViewRectOnScreen;
        int[] iArr = this.mRootViewPositionOnScreen;
        rect.offset(iArr[0], iArr[1]);
        if (Arrays.equals(this.mViewPositionOnScreen, this.mPreviousViewPositionOnScreen) && this.mViewRectOnScreen.equals(this.mPreviousViewRectOnScreen)) {
            return;
        }
        repositionToolbar();
        int[] iArr2 = this.mPreviousViewPositionOnScreen;
        int[] iArr3 = this.mViewPositionOnScreen;
        iArr2[0] = iArr3[0];
        iArr2[1] = iArr3[1];
        this.mPreviousViewRectOnScreen.set(this.mViewRectOnScreen);
    }

    private void repositionToolbar() {
        this.mContentRectOnScreen.set(this.mContentRect);
        ViewParent parent = this.mOriginatingView.getParent();
        if (parent instanceof ViewGroup) {
            parent.getChildVisibleRect(this.mOriginatingView, this.mContentRectOnScreen, null);
            Rect rect = this.mContentRectOnScreen;
            int[] iArr = this.mRootViewPositionOnScreen;
            rect.offset(iArr[0], iArr[1]);
        } else {
            Rect rect2 = this.mContentRectOnScreen;
            int[] iArr2 = this.mViewPositionOnScreen;
            rect2.offset(iArr2[0], iArr2[1]);
        }
        if (isContentRectWithinBounds()) {
            this.mFloatingToolbarVisibilityHelper.setOutOfBounds(false);
            Rect rect3 = this.mContentRectOnScreen;
            rect3.set(Math.max(rect3.left, this.mViewRectOnScreen.left), Math.max(this.mContentRectOnScreen.top, this.mViewRectOnScreen.top), Math.min(this.mContentRectOnScreen.right, this.mViewRectOnScreen.right), Math.min(this.mContentRectOnScreen.bottom, this.mViewRectOnScreen.bottom + this.mBottomAllowance));
            if (!this.mContentRectOnScreen.equals(this.mPreviousContentRectOnScreen)) {
                this.mOriginatingView.removeCallbacks(this.mMovingOff);
                this.mFloatingToolbarVisibilityHelper.setMoving(true);
                this.mOriginatingView.postDelayed(this.mMovingOff, 50L);
                this.mFloatingToolbar.setContentRect(this.mContentRectOnScreen);
                this.mFloatingToolbar.updateLayout();
            }
        } else {
            this.mFloatingToolbarVisibilityHelper.setOutOfBounds(true);
            this.mContentRectOnScreen.setEmpty();
        }
        this.mFloatingToolbarVisibilityHelper.updateToolbarVisibility();
        this.mPreviousContentRectOnScreen.set(this.mContentRectOnScreen);
    }

    private boolean isContentRectWithinBounds() {
        ((WindowManager) this.mContext.getSystemService(WindowManager.class)).getDefaultDisplay().getRealSize(this.mDisplaySize);
        Rect rect = this.mScreenRect;
        Point point = this.mDisplaySize;
        rect.set(0, 0, point.x, point.y);
        return intersectsClosed(this.mContentRectOnScreen, this.mScreenRect) && intersectsClosed(this.mContentRectOnScreen, this.mViewRectOnScreen);
    }

    private static boolean intersectsClosed(Rect a, Rect b) {
        return a.left <= b.right && b.left <= a.right && a.top <= b.bottom && b.top <= a.bottom;
    }

    @Override // android.view.ActionMode
    public void hide(long duration) {
        if (duration == -1) {
            duration = ViewConfiguration.getDefaultActionModeHideDuration();
        }
        long jMin = Math.min(3000L, duration);
        this.mOriginatingView.removeCallbacks(this.mHideOff);
        if (jMin <= 0) {
            this.mHideOff.run();
            return;
        }
        this.mFloatingToolbarVisibilityHelper.setHideRequested(true);
        this.mFloatingToolbarVisibilityHelper.updateToolbarVisibility();
        this.mOriginatingView.postDelayed(this.mHideOff, jMin);
    }

    @Override // android.view.ActionMode
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        this.mFloatingToolbarVisibilityHelper.setWindowFocused(hasWindowFocus);
        this.mFloatingToolbarVisibilityHelper.updateToolbarVisibility();
    }

    @Override // android.view.ActionMode
    public void finish() {
        reset();
        this.mCallback.onDestroyActionMode(this);
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return this.mMenu;
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return new MenuInflater(this.mContext);
    }

    private void reset() {
        this.mFloatingToolbar.dismiss();
        this.mFloatingToolbarVisibilityHelper.deactivate();
        this.mOriginatingView.removeCallbacks(this.mMovingOff);
        this.mOriginatingView.removeCallbacks(this.mHideOff);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isViewStillActive() {
        return this.mOriginatingView.getWindowVisibility() == 0 && this.mOriginatingView.isShown();
    }

    private static final class FloatingToolbarVisibilityHelper {
        private boolean mActive;
        private boolean mHideRequested;
        private long mLastShowTime;
        private boolean mMoving;
        private boolean mOutOfBounds;
        private final FloatingToolbar mToolbar;
        private boolean mWindowFocused = true;

        public FloatingToolbarVisibilityHelper(FloatingToolbar toolbar) {
            this.mToolbar = toolbar;
        }

        public void activate() {
            this.mHideRequested = false;
            this.mMoving = false;
            this.mOutOfBounds = false;
            this.mWindowFocused = true;
            this.mActive = true;
        }

        public void deactivate() {
            this.mActive = false;
            this.mToolbar.dismiss();
        }

        public void setHideRequested(boolean hide) {
            this.mHideRequested = hide;
        }

        public void setMoving(boolean moving) {
            boolean z = System.currentTimeMillis() - this.mLastShowTime > 500;
            if (!moving || z) {
                this.mMoving = moving;
            }
        }

        public void setOutOfBounds(boolean outOfBounds) {
            this.mOutOfBounds = outOfBounds;
        }

        public void setWindowFocused(boolean windowFocused) {
            this.mWindowFocused = windowFocused;
        }

        public void updateToolbarVisibility() {
            if (this.mActive) {
                if (this.mHideRequested || this.mMoving || this.mOutOfBounds || !this.mWindowFocused) {
                    this.mToolbar.hide();
                } else {
                    this.mToolbar.show();
                    this.mLastShowTime = System.currentTimeMillis();
                }
            }
        }
    }
}
