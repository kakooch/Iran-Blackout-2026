package ir.eitaa.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ImageReceiver;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.ActionBarMenuItem;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Components.EditTextBoldCursor;
import ir.eitaa.ui.Components.EditTextEmoji;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.Components.ScrollSlidingTextTabStrip;
import ir.eitaa.ui.Components.SizeNotifierFrameLayout;
import ir.eitaa.ui.PhotoPickerActivity;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class PhotoPickerSearchActivity extends BaseFragment {
    private static final Interpolator interpolator = new Interpolator() { // from class: ir.eitaa.ui.-$$Lambda$PhotoPickerSearchActivity$PThv8mx0_9Y1GWI7JRH4BwoTSaQ
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            return PhotoPickerSearchActivity.lambda$static$0(f);
        }
    };
    private boolean animatingForward;
    private boolean backAnimation;
    private EditTextEmoji commentTextView;
    private PhotoPickerActivity gifsSearch;
    private PhotoPickerActivity imagesSearch;
    private int maximumVelocity;
    private ScrollSlidingTextTabStrip scrollSlidingTextTabStrip;
    private ActionBarMenuItem searchItem;
    private AnimatorSet tabsAnimation;
    private boolean tabsAnimationInProgress;
    private boolean swipeBackEnabled = true;
    private Paint backgroundPaint = new Paint();
    private ViewPage[] viewPages = new ViewPage[2];

    static /* synthetic */ float lambda$static$0(float f) {
        float f2 = f - 1.0f;
        return (f2 * f2 * f2 * f2 * f2) + 1.0f;
    }

    private static class ViewPage extends FrameLayout {
        private ActionBar actionBar;
        private FrameLayout fragmentView;
        private RecyclerListView listView;
        private BaseFragment parentFragment;
        private int selectedType;

        public ViewPage(Context context) {
            super(context);
        }
    }

    public PhotoPickerSearchActivity(HashMap<Object, Object> selectedPhotos, ArrayList<Object> selectedPhotosOrder, int selectPhotoType, boolean allowCaption, ChatActivity chatActivity) {
        this.imagesSearch = new PhotoPickerActivity(0, null, selectedPhotos, selectedPhotosOrder, selectPhotoType, allowCaption, chatActivity, false);
        this.gifsSearch = new PhotoPickerActivity(1, null, selectedPhotos, selectedPhotosOrder, selectPhotoType, allowCaption, chatActivity, false);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        View view;
        this.actionBar.setBackgroundColor(Theme.getColor("dialogBackground"));
        this.actionBar.setTitleColor(Theme.getColor("dialogTextBlack"));
        this.actionBar.setItemsColor(Theme.getColor("dialogTextBlack"), false);
        this.actionBar.setItemsBackgroundColor(Theme.getColor("dialogButtonSelector"), false);
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        if (AndroidUtilities.isTablet()) {
            this.actionBar.setOccupyStatusBar(false);
        }
        this.actionBar.setExtraHeight(AndroidUtilities.dp(44.0f));
        this.actionBar.setAllowOverlayTitle(false);
        this.actionBar.setAddToContainer(false);
        this.actionBar.setClipContent(true);
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.eitaa.ui.PhotoPickerSearchActivity.1
            @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int id) {
                if (id == -1) {
                    PhotoPickerSearchActivity.this.finishFragment();
                }
            }
        });
        this.hasOwnBackground = true;
        ActionBarMenuItem actionBarMenuItemSearchListener = this.actionBar.createMenu().addItem(0, R.drawable.ic_ab_search).setIsSearchField(true).setActionBarMenuItemSearchListener(new ActionBarMenuItem.ActionBarMenuItemSearchListener() { // from class: ir.eitaa.ui.PhotoPickerSearchActivity.2
            @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
            public void onSearchExpand() {
                PhotoPickerSearchActivity.this.imagesSearch.getActionBar().openSearchField("", false);
                PhotoPickerSearchActivity.this.gifsSearch.getActionBar().openSearchField("", false);
                PhotoPickerSearchActivity.this.searchItem.getSearchField().requestFocus();
            }

            @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
            public boolean canCollapseSearch() {
                PhotoPickerSearchActivity.this.finishFragment();
                return false;
            }

            @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
            public void onTextChanged(EditText editText) {
                PhotoPickerSearchActivity.this.imagesSearch.getActionBar().setSearchFieldText(editText.getText().toString());
                PhotoPickerSearchActivity.this.gifsSearch.getActionBar().setSearchFieldText(editText.getText().toString());
            }

            @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
            public void onSearchPressed(EditText editText) {
                PhotoPickerSearchActivity.this.imagesSearch.getActionBar().onSearchPressed();
                PhotoPickerSearchActivity.this.gifsSearch.getActionBar().onSearchPressed();
            }
        });
        this.searchItem = actionBarMenuItemSearchListener;
        actionBarMenuItemSearchListener.setSearchFieldHint(LocaleController.getString("SearchImagesTitle", R.string.SearchImagesTitle));
        EditTextBoldCursor searchField = this.searchItem.getSearchField();
        searchField.setTextColor(Theme.getColor("dialogTextBlack"));
        searchField.setCursorColor(Theme.getColor("dialogTextBlack"));
        searchField.setHintTextColor(Theme.getColor("chat_messagePanelHint"));
        ScrollSlidingTextTabStrip scrollSlidingTextTabStrip = new ScrollSlidingTextTabStrip(context);
        this.scrollSlidingTextTabStrip = scrollSlidingTextTabStrip;
        scrollSlidingTextTabStrip.setUseSameWidth(true);
        this.scrollSlidingTextTabStrip.setColors("chat_attachActiveTab", "chat_attachActiveTab", "chat_attachUnactiveTab", "dialogButtonSelector");
        this.actionBar.addView(this.scrollSlidingTextTabStrip, LayoutHelper.createFrame(-1, 44, 83));
        this.scrollSlidingTextTabStrip.setDelegate(new ScrollSlidingTextTabStrip.ScrollSlidingTabStripDelegate() { // from class: ir.eitaa.ui.PhotoPickerSearchActivity.3
            @Override // ir.eitaa.ui.Components.ScrollSlidingTextTabStrip.ScrollSlidingTabStripDelegate
            public /* synthetic */ void onSamePageSelected() {
                ScrollSlidingTextTabStrip.ScrollSlidingTabStripDelegate.CC.$default$onSamePageSelected(this);
            }

            @Override // ir.eitaa.ui.Components.ScrollSlidingTextTabStrip.ScrollSlidingTabStripDelegate
            public void onPageSelected(int id, boolean forward) {
                if (PhotoPickerSearchActivity.this.viewPages[0].selectedType == id) {
                    return;
                }
                PhotoPickerSearchActivity photoPickerSearchActivity = PhotoPickerSearchActivity.this;
                photoPickerSearchActivity.swipeBackEnabled = id == photoPickerSearchActivity.scrollSlidingTextTabStrip.getFirstTabId();
                PhotoPickerSearchActivity.this.viewPages[1].selectedType = id;
                PhotoPickerSearchActivity.this.viewPages[1].setVisibility(0);
                PhotoPickerSearchActivity.this.switchToCurrentSelectedMode(true);
                PhotoPickerSearchActivity.this.animatingForward = forward;
                if (id == 0) {
                    PhotoPickerSearchActivity.this.searchItem.setSearchFieldHint(LocaleController.getString("SearchImagesTitle", R.string.SearchImagesTitle));
                } else {
                    PhotoPickerSearchActivity.this.searchItem.setSearchFieldHint(LocaleController.getString("SearchGifsTitle", R.string.SearchGifsTitle));
                }
            }

            @Override // ir.eitaa.ui.Components.ScrollSlidingTextTabStrip.ScrollSlidingTabStripDelegate
            public void onPageScrolled(float progress) {
                if (progress != 1.0f || PhotoPickerSearchActivity.this.viewPages[1].getVisibility() == 0) {
                    if (PhotoPickerSearchActivity.this.animatingForward) {
                        PhotoPickerSearchActivity.this.viewPages[0].setTranslationX((-progress) * PhotoPickerSearchActivity.this.viewPages[0].getMeasuredWidth());
                        PhotoPickerSearchActivity.this.viewPages[1].setTranslationX(PhotoPickerSearchActivity.this.viewPages[0].getMeasuredWidth() - (PhotoPickerSearchActivity.this.viewPages[0].getMeasuredWidth() * progress));
                    } else {
                        PhotoPickerSearchActivity.this.viewPages[0].setTranslationX(PhotoPickerSearchActivity.this.viewPages[0].getMeasuredWidth() * progress);
                        PhotoPickerSearchActivity.this.viewPages[1].setTranslationX((PhotoPickerSearchActivity.this.viewPages[0].getMeasuredWidth() * progress) - PhotoPickerSearchActivity.this.viewPages[0].getMeasuredWidth());
                    }
                    if (progress == 1.0f) {
                        ViewPage viewPage = PhotoPickerSearchActivity.this.viewPages[0];
                        PhotoPickerSearchActivity.this.viewPages[0] = PhotoPickerSearchActivity.this.viewPages[1];
                        PhotoPickerSearchActivity.this.viewPages[1] = viewPage;
                        PhotoPickerSearchActivity.this.viewPages[1].setVisibility(8);
                    }
                }
            }
        });
        this.maximumVelocity = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
        SizeNotifierFrameLayout sizeNotifierFrameLayout = new SizeNotifierFrameLayout(context) { // from class: ir.eitaa.ui.PhotoPickerSearchActivity.4
            private boolean globalIgnoreLayout;
            private boolean maybeStartTracking;
            private boolean startedTracking;
            private int startedTrackingPointerId;
            private int startedTrackingX;
            private int startedTrackingY;
            private VelocityTracker velocityTracker;

            private boolean prepareForMoving(MotionEvent ev, boolean forward) {
                int nextPageId = PhotoPickerSearchActivity.this.scrollSlidingTextTabStrip.getNextPageId(forward);
                if (nextPageId < 0) {
                    return false;
                }
                getParent().requestDisallowInterceptTouchEvent(true);
                this.maybeStartTracking = false;
                this.startedTracking = true;
                this.startedTrackingX = (int) ev.getX();
                ((BaseFragment) PhotoPickerSearchActivity.this).actionBar.setEnabled(false);
                PhotoPickerSearchActivity.this.scrollSlidingTextTabStrip.setEnabled(false);
                PhotoPickerSearchActivity.this.viewPages[1].selectedType = nextPageId;
                PhotoPickerSearchActivity.this.viewPages[1].setVisibility(0);
                PhotoPickerSearchActivity.this.animatingForward = forward;
                PhotoPickerSearchActivity.this.switchToCurrentSelectedMode(true);
                if (forward) {
                    PhotoPickerSearchActivity.this.viewPages[1].setTranslationX(PhotoPickerSearchActivity.this.viewPages[0].getMeasuredWidth());
                } else {
                    PhotoPickerSearchActivity.this.viewPages[1].setTranslationX(-PhotoPickerSearchActivity.this.viewPages[0].getMeasuredWidth());
                }
                return true;
            }

            @Override // android.view.View
            public void forceHasOverlappingRendering(boolean hasOverlappingRendering) {
                super.forceHasOverlappingRendering(hasOverlappingRendering);
            }

            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                int size = View.MeasureSpec.getSize(widthMeasureSpec);
                int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
                setMeasuredDimension(size, size2);
                measureChildWithMargins(((BaseFragment) PhotoPickerSearchActivity.this).actionBar, widthMeasureSpec, 0, heightMeasureSpec, 0);
                if ((SharedConfig.smoothKeyboard ? 0 : measureKeyboardHeight()) <= AndroidUtilities.dp(20.0f)) {
                    if (!AndroidUtilities.isInMultiwindow) {
                        size2 -= PhotoPickerSearchActivity.this.commentTextView.getEmojiPadding();
                        heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(size2, 1073741824);
                    }
                } else {
                    this.globalIgnoreLayout = true;
                    PhotoPickerSearchActivity.this.commentTextView.hideEmojiView();
                    this.globalIgnoreLayout = false;
                }
                int measuredHeight = ((BaseFragment) PhotoPickerSearchActivity.this).actionBar.getMeasuredHeight();
                this.globalIgnoreLayout = true;
                for (int i = 0; i < PhotoPickerSearchActivity.this.viewPages.length; i++) {
                    if (PhotoPickerSearchActivity.this.viewPages[i] != null && PhotoPickerSearchActivity.this.viewPages[i].listView != null) {
                        PhotoPickerSearchActivity.this.viewPages[i].listView.setPadding(AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f) + measuredHeight, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f));
                    }
                }
                this.globalIgnoreLayout = false;
                int childCount = getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = getChildAt(i2);
                    if (childAt != null && childAt.getVisibility() != 8 && childAt != ((BaseFragment) PhotoPickerSearchActivity.this).actionBar) {
                        if (PhotoPickerSearchActivity.this.commentTextView != null && PhotoPickerSearchActivity.this.commentTextView.isPopupView(childAt)) {
                            if (AndroidUtilities.isInMultiwindow || AndroidUtilities.isTablet()) {
                                if (AndroidUtilities.isTablet()) {
                                    childAt.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(Math.min(AndroidUtilities.dp(AndroidUtilities.isTablet() ? 200.0f : 320.0f), (size2 - AndroidUtilities.statusBarHeight) + getPaddingTop()), 1073741824));
                                } else {
                                    childAt.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec((size2 - AndroidUtilities.statusBarHeight) + getPaddingTop(), 1073741824));
                                }
                            } else {
                                childAt.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt.getLayoutParams().height, 1073741824));
                            }
                        } else {
                            measureChildWithMargins(childAt, widthMeasureSpec, 0, heightMeasureSpec, 0);
                        }
                    }
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:32:0x0083  */
            /* JADX WARN: Removed duplicated region for block: B:39:0x009d  */
            /* JADX WARN: Removed duplicated region for block: B:43:0x00b2  */
            /* JADX WARN: Removed duplicated region for block: B:47:0x00c4  */
            /* JADX WARN: Removed duplicated region for block: B:48:0x00cd  */
            @Override // ir.eitaa.ui.Components.SizeNotifierFrameLayout, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            protected void onLayout(boolean r11, int r12, int r13, int r14, int r15) {
                /*
                    Method dump skipped, instructions count: 228
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.PhotoPickerSearchActivity.AnonymousClass4.onLayout(boolean, int, int, int, int):void");
            }

            @Override // android.view.ViewGroup, android.view.View
            protected void dispatchDraw(Canvas canvas) {
                super.dispatchDraw(canvas);
                if (((BaseFragment) PhotoPickerSearchActivity.this).parentLayout != null) {
                    ((BaseFragment) PhotoPickerSearchActivity.this).parentLayout.drawHeaderShadow(canvas, ((BaseFragment) PhotoPickerSearchActivity.this).actionBar.getMeasuredHeight() + ((int) ((BaseFragment) PhotoPickerSearchActivity.this).actionBar.getTranslationY()));
                }
            }

            @Override // android.view.View, android.view.ViewParent
            public void requestLayout() {
                if (this.globalIgnoreLayout) {
                    return;
                }
                super.requestLayout();
            }

            /* JADX WARN: Removed duplicated region for block: B:19:0x009d  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public boolean checkTabsAnimationInProgress() {
                /*
                    r7 = this;
                    ir.eitaa.ui.PhotoPickerSearchActivity r0 = ir.eitaa.ui.PhotoPickerSearchActivity.this
                    boolean r0 = ir.eitaa.ui.PhotoPickerSearchActivity.access$1900(r0)
                    r1 = 0
                    if (r0 == 0) goto Lc3
                    ir.eitaa.ui.PhotoPickerSearchActivity r0 = ir.eitaa.ui.PhotoPickerSearchActivity.this
                    boolean r0 = ir.eitaa.ui.PhotoPickerSearchActivity.access$2000(r0)
                    r2 = -1
                    r3 = 0
                    r4 = 1065353216(0x3f800000, float:1.0)
                    r5 = 1
                    if (r0 == 0) goto L59
                    ir.eitaa.ui.PhotoPickerSearchActivity r0 = ir.eitaa.ui.PhotoPickerSearchActivity.this
                    ir.eitaa.ui.PhotoPickerSearchActivity$ViewPage[] r0 = ir.eitaa.ui.PhotoPickerSearchActivity.access$300(r0)
                    r0 = r0[r1]
                    float r0 = r0.getTranslationX()
                    float r0 = java.lang.Math.abs(r0)
                    int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                    if (r0 >= 0) goto L9d
                    ir.eitaa.ui.PhotoPickerSearchActivity r0 = ir.eitaa.ui.PhotoPickerSearchActivity.this
                    ir.eitaa.ui.PhotoPickerSearchActivity$ViewPage[] r0 = ir.eitaa.ui.PhotoPickerSearchActivity.access$300(r0)
                    r0 = r0[r1]
                    r0.setTranslationX(r3)
                    ir.eitaa.ui.PhotoPickerSearchActivity r0 = ir.eitaa.ui.PhotoPickerSearchActivity.this
                    ir.eitaa.ui.PhotoPickerSearchActivity$ViewPage[] r0 = ir.eitaa.ui.PhotoPickerSearchActivity.access$300(r0)
                    r0 = r0[r5]
                    ir.eitaa.ui.PhotoPickerSearchActivity r3 = ir.eitaa.ui.PhotoPickerSearchActivity.this
                    ir.eitaa.ui.PhotoPickerSearchActivity$ViewPage[] r3 = ir.eitaa.ui.PhotoPickerSearchActivity.access$300(r3)
                    r3 = r3[r1]
                    int r3 = r3.getMeasuredWidth()
                    ir.eitaa.ui.PhotoPickerSearchActivity r4 = ir.eitaa.ui.PhotoPickerSearchActivity.this
                    boolean r4 = ir.eitaa.ui.PhotoPickerSearchActivity.access$800(r4)
                    if (r4 == 0) goto L52
                    r2 = 1
                L52:
                    int r3 = r3 * r2
                    float r2 = (float) r3
                    r0.setTranslationX(r2)
                    goto L9e
                L59:
                    ir.eitaa.ui.PhotoPickerSearchActivity r0 = ir.eitaa.ui.PhotoPickerSearchActivity.this
                    ir.eitaa.ui.PhotoPickerSearchActivity$ViewPage[] r0 = ir.eitaa.ui.PhotoPickerSearchActivity.access$300(r0)
                    r0 = r0[r5]
                    float r0 = r0.getTranslationX()
                    float r0 = java.lang.Math.abs(r0)
                    int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                    if (r0 >= 0) goto L9d
                    ir.eitaa.ui.PhotoPickerSearchActivity r0 = ir.eitaa.ui.PhotoPickerSearchActivity.this
                    ir.eitaa.ui.PhotoPickerSearchActivity$ViewPage[] r0 = ir.eitaa.ui.PhotoPickerSearchActivity.access$300(r0)
                    r0 = r0[r1]
                    ir.eitaa.ui.PhotoPickerSearchActivity r4 = ir.eitaa.ui.PhotoPickerSearchActivity.this
                    ir.eitaa.ui.PhotoPickerSearchActivity$ViewPage[] r4 = ir.eitaa.ui.PhotoPickerSearchActivity.access$300(r4)
                    r4 = r4[r1]
                    int r4 = r4.getMeasuredWidth()
                    ir.eitaa.ui.PhotoPickerSearchActivity r6 = ir.eitaa.ui.PhotoPickerSearchActivity.this
                    boolean r6 = ir.eitaa.ui.PhotoPickerSearchActivity.access$800(r6)
                    if (r6 == 0) goto L8a
                    goto L8b
                L8a:
                    r2 = 1
                L8b:
                    int r4 = r4 * r2
                    float r2 = (float) r4
                    r0.setTranslationX(r2)
                    ir.eitaa.ui.PhotoPickerSearchActivity r0 = ir.eitaa.ui.PhotoPickerSearchActivity.this
                    ir.eitaa.ui.PhotoPickerSearchActivity$ViewPage[] r0 = ir.eitaa.ui.PhotoPickerSearchActivity.access$300(r0)
                    r0 = r0[r5]
                    r0.setTranslationX(r3)
                    goto L9e
                L9d:
                    r5 = 0
                L9e:
                    if (r5 == 0) goto Lbc
                    ir.eitaa.ui.PhotoPickerSearchActivity r0 = ir.eitaa.ui.PhotoPickerSearchActivity.this
                    android.animation.AnimatorSet r0 = ir.eitaa.ui.PhotoPickerSearchActivity.access$2100(r0)
                    if (r0 == 0) goto Lb7
                    ir.eitaa.ui.PhotoPickerSearchActivity r0 = ir.eitaa.ui.PhotoPickerSearchActivity.this
                    android.animation.AnimatorSet r0 = ir.eitaa.ui.PhotoPickerSearchActivity.access$2100(r0)
                    r0.cancel()
                    ir.eitaa.ui.PhotoPickerSearchActivity r0 = ir.eitaa.ui.PhotoPickerSearchActivity.this
                    r2 = 0
                    ir.eitaa.ui.PhotoPickerSearchActivity.access$2102(r0, r2)
                Lb7:
                    ir.eitaa.ui.PhotoPickerSearchActivity r0 = ir.eitaa.ui.PhotoPickerSearchActivity.this
                    ir.eitaa.ui.PhotoPickerSearchActivity.access$1902(r0, r1)
                Lbc:
                    ir.eitaa.ui.PhotoPickerSearchActivity r0 = ir.eitaa.ui.PhotoPickerSearchActivity.this
                    boolean r0 = ir.eitaa.ui.PhotoPickerSearchActivity.access$1900(r0)
                    return r0
                Lc3:
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.PhotoPickerSearchActivity.AnonymousClass4.checkTabsAnimationInProgress():boolean");
            }

            @Override // android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent ev) {
                return checkTabsAnimationInProgress() || PhotoPickerSearchActivity.this.scrollSlidingTextTabStrip.isAnimatingIndicator() || onTouchEvent(ev);
            }

            @Override // ir.eitaa.ui.Components.SizeNotifierFrameLayout, android.view.View
            protected void onDraw(Canvas canvas) {
                PhotoPickerSearchActivity.this.backgroundPaint.setColor(Theme.getColor("windowBackgroundGray"));
                canvas.drawRect(0.0f, ((BaseFragment) PhotoPickerSearchActivity.this).actionBar.getMeasuredHeight() + ((BaseFragment) PhotoPickerSearchActivity.this).actionBar.getTranslationY(), getMeasuredWidth(), getMeasuredHeight(), PhotoPickerSearchActivity.this.backgroundPaint);
            }

            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent ev) {
                float xVelocity;
                float yVelocity;
                float measuredWidth;
                int measuredWidth2;
                if (((BaseFragment) PhotoPickerSearchActivity.this).parentLayout.checkTransitionAnimation() || checkTabsAnimationInProgress()) {
                    return false;
                }
                if (ev != null) {
                    if (this.velocityTracker == null) {
                        this.velocityTracker = VelocityTracker.obtain();
                    }
                    this.velocityTracker.addMovement(ev);
                }
                if (ev != null && ev.getAction() == 0 && !this.startedTracking && !this.maybeStartTracking) {
                    this.startedTrackingPointerId = ev.getPointerId(0);
                    this.maybeStartTracking = true;
                    this.startedTrackingX = (int) ev.getX();
                    this.startedTrackingY = (int) ev.getY();
                    this.velocityTracker.clear();
                } else if (ev != null && ev.getAction() == 2 && ev.getPointerId(0) == this.startedTrackingPointerId) {
                    int x = (int) (ev.getX() - this.startedTrackingX);
                    int iAbs = Math.abs(((int) ev.getY()) - this.startedTrackingY);
                    if (this.startedTracking && ((PhotoPickerSearchActivity.this.animatingForward && x > 0) || (!PhotoPickerSearchActivity.this.animatingForward && x < 0))) {
                        if (!prepareForMoving(ev, x < 0)) {
                            this.maybeStartTracking = true;
                            this.startedTracking = false;
                            PhotoPickerSearchActivity.this.viewPages[0].setTranslationX(0.0f);
                            PhotoPickerSearchActivity.this.viewPages[1].setTranslationX(PhotoPickerSearchActivity.this.animatingForward ? PhotoPickerSearchActivity.this.viewPages[0].getMeasuredWidth() : -PhotoPickerSearchActivity.this.viewPages[0].getMeasuredWidth());
                            PhotoPickerSearchActivity.this.scrollSlidingTextTabStrip.selectTabWithId(PhotoPickerSearchActivity.this.viewPages[1].selectedType, 0.0f);
                        }
                    }
                    if (!this.maybeStartTracking || this.startedTracking) {
                        if (this.startedTracking) {
                            PhotoPickerSearchActivity.this.viewPages[0].setTranslationX(x);
                            if (PhotoPickerSearchActivity.this.animatingForward) {
                                PhotoPickerSearchActivity.this.viewPages[1].setTranslationX(PhotoPickerSearchActivity.this.viewPages[0].getMeasuredWidth() + x);
                            } else {
                                PhotoPickerSearchActivity.this.viewPages[1].setTranslationX(x - PhotoPickerSearchActivity.this.viewPages[0].getMeasuredWidth());
                            }
                            PhotoPickerSearchActivity.this.scrollSlidingTextTabStrip.selectTabWithId(PhotoPickerSearchActivity.this.viewPages[1].selectedType, Math.abs(x) / PhotoPickerSearchActivity.this.viewPages[0].getMeasuredWidth());
                        }
                    } else if (Math.abs(x) >= AndroidUtilities.getPixelsInCM(0.3f, true) && Math.abs(x) > iAbs) {
                        prepareForMoving(ev, x < 0);
                    }
                } else if (ev == null || (ev.getPointerId(0) == this.startedTrackingPointerId && (ev.getAction() == 3 || ev.getAction() == 1 || ev.getAction() == 6))) {
                    this.velocityTracker.computeCurrentVelocity(1000, PhotoPickerSearchActivity.this.maximumVelocity);
                    if (ev == null || ev.getAction() == 3) {
                        xVelocity = 0.0f;
                        yVelocity = 0.0f;
                    } else {
                        xVelocity = this.velocityTracker.getXVelocity();
                        yVelocity = this.velocityTracker.getYVelocity();
                        if (!this.startedTracking && Math.abs(xVelocity) >= 3000.0f && Math.abs(xVelocity) > Math.abs(yVelocity)) {
                            prepareForMoving(ev, xVelocity < 0.0f);
                        }
                    }
                    if (this.startedTracking) {
                        float x2 = PhotoPickerSearchActivity.this.viewPages[0].getX();
                        PhotoPickerSearchActivity.this.tabsAnimation = new AnimatorSet();
                        PhotoPickerSearchActivity.this.backAnimation = Math.abs(x2) < ((float) PhotoPickerSearchActivity.this.viewPages[0].getMeasuredWidth()) / 3.0f && (Math.abs(xVelocity) < 3500.0f || Math.abs(xVelocity) < Math.abs(yVelocity));
                        if (!PhotoPickerSearchActivity.this.backAnimation) {
                            measuredWidth = PhotoPickerSearchActivity.this.viewPages[0].getMeasuredWidth() - Math.abs(x2);
                            if (PhotoPickerSearchActivity.this.animatingForward) {
                                PhotoPickerSearchActivity.this.tabsAnimation.playTogether(ObjectAnimator.ofFloat(PhotoPickerSearchActivity.this.viewPages[0], (Property<ViewPage, Float>) View.TRANSLATION_X, -PhotoPickerSearchActivity.this.viewPages[0].getMeasuredWidth()), ObjectAnimator.ofFloat(PhotoPickerSearchActivity.this.viewPages[1], (Property<ViewPage, Float>) View.TRANSLATION_X, 0.0f));
                            } else {
                                PhotoPickerSearchActivity.this.tabsAnimation.playTogether(ObjectAnimator.ofFloat(PhotoPickerSearchActivity.this.viewPages[0], (Property<ViewPage, Float>) View.TRANSLATION_X, PhotoPickerSearchActivity.this.viewPages[0].getMeasuredWidth()), ObjectAnimator.ofFloat(PhotoPickerSearchActivity.this.viewPages[1], (Property<ViewPage, Float>) View.TRANSLATION_X, 0.0f));
                            }
                        } else {
                            measuredWidth = Math.abs(x2);
                            if (PhotoPickerSearchActivity.this.animatingForward) {
                                PhotoPickerSearchActivity.this.tabsAnimation.playTogether(ObjectAnimator.ofFloat(PhotoPickerSearchActivity.this.viewPages[0], (Property<ViewPage, Float>) View.TRANSLATION_X, 0.0f), ObjectAnimator.ofFloat(PhotoPickerSearchActivity.this.viewPages[1], (Property<ViewPage, Float>) View.TRANSLATION_X, PhotoPickerSearchActivity.this.viewPages[1].getMeasuredWidth()));
                            } else {
                                PhotoPickerSearchActivity.this.tabsAnimation.playTogether(ObjectAnimator.ofFloat(PhotoPickerSearchActivity.this.viewPages[0], (Property<ViewPage, Float>) View.TRANSLATION_X, 0.0f), ObjectAnimator.ofFloat(PhotoPickerSearchActivity.this.viewPages[1], (Property<ViewPage, Float>) View.TRANSLATION_X, -PhotoPickerSearchActivity.this.viewPages[1].getMeasuredWidth()));
                            }
                        }
                        PhotoPickerSearchActivity.this.tabsAnimation.setInterpolator(PhotoPickerSearchActivity.interpolator);
                        int measuredWidth3 = getMeasuredWidth();
                        float f = measuredWidth3 / 2;
                        float fDistanceInfluenceForSnapDuration = f + (AndroidUtilities.distanceInfluenceForSnapDuration(Math.min(1.0f, (measuredWidth * 1.0f) / measuredWidth3)) * f);
                        float fAbs = Math.abs(xVelocity);
                        if (fAbs > 0.0f) {
                            measuredWidth2 = Math.round(Math.abs(fDistanceInfluenceForSnapDuration / fAbs) * 1000.0f) * 4;
                        } else {
                            measuredWidth2 = (int) (((measuredWidth / getMeasuredWidth()) + 1.0f) * 100.0f);
                        }
                        PhotoPickerSearchActivity.this.tabsAnimation.setDuration(Math.max(ImageReceiver.DEFAULT_CROSSFADE_DURATION, Math.min(measuredWidth2, 600)));
                        PhotoPickerSearchActivity.this.tabsAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.PhotoPickerSearchActivity.4.1
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                PhotoPickerSearchActivity.this.tabsAnimation = null;
                                if (PhotoPickerSearchActivity.this.backAnimation) {
                                    PhotoPickerSearchActivity.this.viewPages[1].setVisibility(8);
                                } else {
                                    ViewPage viewPage = PhotoPickerSearchActivity.this.viewPages[0];
                                    PhotoPickerSearchActivity.this.viewPages[0] = PhotoPickerSearchActivity.this.viewPages[1];
                                    PhotoPickerSearchActivity.this.viewPages[1] = viewPage;
                                    PhotoPickerSearchActivity.this.viewPages[1].setVisibility(8);
                                    PhotoPickerSearchActivity photoPickerSearchActivity = PhotoPickerSearchActivity.this;
                                    photoPickerSearchActivity.swipeBackEnabled = photoPickerSearchActivity.viewPages[0].selectedType == PhotoPickerSearchActivity.this.scrollSlidingTextTabStrip.getFirstTabId();
                                    PhotoPickerSearchActivity.this.scrollSlidingTextTabStrip.selectTabWithId(PhotoPickerSearchActivity.this.viewPages[0].selectedType, 1.0f);
                                }
                                PhotoPickerSearchActivity.this.tabsAnimationInProgress = false;
                                AnonymousClass4.this.maybeStartTracking = false;
                                AnonymousClass4.this.startedTracking = false;
                                ((BaseFragment) PhotoPickerSearchActivity.this).actionBar.setEnabled(true);
                                PhotoPickerSearchActivity.this.scrollSlidingTextTabStrip.setEnabled(true);
                            }
                        });
                        PhotoPickerSearchActivity.this.tabsAnimation.start();
                        PhotoPickerSearchActivity.this.tabsAnimationInProgress = true;
                        this.startedTracking = false;
                    } else {
                        this.maybeStartTracking = false;
                        ((BaseFragment) PhotoPickerSearchActivity.this).actionBar.setEnabled(true);
                        PhotoPickerSearchActivity.this.scrollSlidingTextTabStrip.setEnabled(true);
                    }
                    VelocityTracker velocityTracker = this.velocityTracker;
                    if (velocityTracker != null) {
                        velocityTracker.recycle();
                        this.velocityTracker = null;
                    }
                }
                return this.startedTracking;
            }
        };
        this.fragmentView = sizeNotifierFrameLayout;
        sizeNotifierFrameLayout.setWillNotDraw(false);
        this.imagesSearch.setParentFragment(this);
        EditTextEmoji editTextEmoji = this.imagesSearch.commentTextView;
        this.commentTextView = editTextEmoji;
        editTextEmoji.setSizeNotifierLayout(sizeNotifierFrameLayout);
        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                view = this.imagesSearch.frameLayout2;
            } else if (i == 1) {
                view = this.imagesSearch.writeButtonContainer;
            } else if (i == 2) {
                view = this.imagesSearch.selectedCountView;
            } else {
                view = this.imagesSearch.shadow;
            }
            ((ViewGroup) view.getParent()).removeView(view);
        }
        PhotoPickerActivity photoPickerActivity = this.gifsSearch;
        PhotoPickerActivity photoPickerActivity2 = this.imagesSearch;
        photoPickerActivity.setLayoutViews(photoPickerActivity2.frameLayout2, photoPickerActivity2.writeButtonContainer, photoPickerActivity2.selectedCountView, photoPickerActivity2.shadow, photoPickerActivity2.commentTextView);
        this.gifsSearch.setParentFragment(this);
        int i2 = 0;
        while (true) {
            ViewPage[] viewPageArr = this.viewPages;
            if (i2 >= viewPageArr.length) {
                break;
            }
            viewPageArr[i2] = new ViewPage(context) { // from class: ir.eitaa.ui.PhotoPickerSearchActivity.5
                @Override // android.view.View
                public void setTranslationX(float translationX) {
                    super.setTranslationX(translationX);
                    if (PhotoPickerSearchActivity.this.tabsAnimationInProgress && PhotoPickerSearchActivity.this.viewPages[0] == this) {
                        PhotoPickerSearchActivity.this.scrollSlidingTextTabStrip.selectTabWithId(PhotoPickerSearchActivity.this.viewPages[1].selectedType, Math.abs(PhotoPickerSearchActivity.this.viewPages[0].getTranslationX()) / PhotoPickerSearchActivity.this.viewPages[0].getMeasuredWidth());
                    }
                }
            };
            sizeNotifierFrameLayout.addView(this.viewPages[i2], LayoutHelper.createFrame(-1, -1.0f));
            if (i2 == 0) {
                this.viewPages[i2].parentFragment = this.imagesSearch;
                this.viewPages[i2].listView = this.imagesSearch.getListView();
            } else if (i2 == 1) {
                this.viewPages[i2].parentFragment = this.gifsSearch;
                this.viewPages[i2].listView = this.gifsSearch.getListView();
                this.viewPages[i2].setVisibility(8);
            }
            this.viewPages[i2].listView.setScrollingTouchSlop(1);
            ViewPage[] viewPageArr2 = this.viewPages;
            viewPageArr2[i2].fragmentView = (FrameLayout) viewPageArr2[i2].parentFragment.getFragmentView();
            this.viewPages[i2].listView.setClipToPadding(false);
            ViewPage[] viewPageArr3 = this.viewPages;
            viewPageArr3[i2].actionBar = viewPageArr3[i2].parentFragment.getActionBar();
            ViewPage[] viewPageArr4 = this.viewPages;
            viewPageArr4[i2].addView(viewPageArr4[i2].fragmentView, LayoutHelper.createFrame(-1, -1.0f));
            ViewPage[] viewPageArr5 = this.viewPages;
            viewPageArr5[i2].addView(viewPageArr5[i2].actionBar, LayoutHelper.createFrame(-1, -2.0f));
            this.viewPages[i2].actionBar.setVisibility(8);
            final RecyclerView.OnScrollListener onScrollListener = this.viewPages[i2].listView.getOnScrollListener();
            this.viewPages[i2].listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.eitaa.ui.PhotoPickerSearchActivity.6
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                    onScrollListener.onScrollStateChanged(recyclerView, newState);
                    if (newState != 1) {
                        int i3 = (int) (-((BaseFragment) PhotoPickerSearchActivity.this).actionBar.getTranslationY());
                        int currentActionBarHeight = ActionBar.getCurrentActionBarHeight();
                        if (i3 == 0 || i3 == currentActionBarHeight) {
                            return;
                        }
                        if (i3 < currentActionBarHeight / 2) {
                            PhotoPickerSearchActivity.this.viewPages[0].listView.smoothScrollBy(0, -i3);
                        } else {
                            PhotoPickerSearchActivity.this.viewPages[0].listView.smoothScrollBy(0, currentActionBarHeight - i3);
                        }
                    }
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    onScrollListener.onScrolled(recyclerView, dx, dy);
                    if (recyclerView == PhotoPickerSearchActivity.this.viewPages[0].listView) {
                        float translationY = ((BaseFragment) PhotoPickerSearchActivity.this).actionBar.getTranslationY();
                        float f = translationY - dy;
                        if (f < (-ActionBar.getCurrentActionBarHeight())) {
                            f = -ActionBar.getCurrentActionBarHeight();
                        } else if (f > 0.0f) {
                            f = 0.0f;
                        }
                        if (f != translationY) {
                            PhotoPickerSearchActivity.this.setScrollY(f);
                        }
                    }
                }
            });
            i2++;
        }
        sizeNotifierFrameLayout.addView(this.actionBar, LayoutHelper.createFrame(-1, -2.0f));
        sizeNotifierFrameLayout.addView(this.imagesSearch.shadow, LayoutHelper.createFrame(-1, 3.0f, 83, 0.0f, 0.0f, 0.0f, 48.0f));
        sizeNotifierFrameLayout.addView(this.imagesSearch.frameLayout2, LayoutHelper.createFrame(-1, 48, 83));
        sizeNotifierFrameLayout.addView(this.imagesSearch.writeButtonContainer, LayoutHelper.createFrame(60, 60.0f, 85, 0.0f, 0.0f, 12.0f, 10.0f));
        sizeNotifierFrameLayout.addView(this.imagesSearch.selectedCountView, LayoutHelper.createFrame(42, 24.0f, 85, 0.0f, 0.0f, -2.0f, 9.0f));
        updateTabs();
        switchToCurrentSelectedMode(false);
        this.swipeBackEnabled = this.scrollSlidingTextTabStrip.getCurrentTabId() == this.scrollSlidingTextTabStrip.getFirstTabId();
        return this.fragmentView;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        ActionBarMenuItem actionBarMenuItem = this.searchItem;
        if (actionBarMenuItem != null) {
            actionBarMenuItem.openSearch(true);
            getParentActivity().getWindow().setSoftInputMode(SharedConfig.smoothKeyboard ? 32 : 16);
        }
        PhotoPickerActivity photoPickerActivity = this.imagesSearch;
        if (photoPickerActivity != null) {
            photoPickerActivity.onResume();
        }
        PhotoPickerActivity photoPickerActivity2 = this.gifsSearch;
        if (photoPickerActivity2 != null) {
            photoPickerActivity2.onResume();
        }
    }

    public void setCaption(CharSequence text) {
        PhotoPickerActivity photoPickerActivity = this.imagesSearch;
        if (photoPickerActivity != null) {
            photoPickerActivity.setCaption(text);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
        PhotoPickerActivity photoPickerActivity = this.imagesSearch;
        if (photoPickerActivity != null) {
            photoPickerActivity.onPause();
        }
        PhotoPickerActivity photoPickerActivity2 = this.gifsSearch;
        if (photoPickerActivity2 != null) {
            photoPickerActivity2.onPause();
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean isSwipeBackEnabled(MotionEvent event) {
        return this.swipeBackEnabled;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() throws InterruptedException {
        PhotoPickerActivity photoPickerActivity = this.imagesSearch;
        if (photoPickerActivity != null) {
            photoPickerActivity.onFragmentDestroy();
        }
        PhotoPickerActivity photoPickerActivity2 = this.gifsSearch;
        if (photoPickerActivity2 != null) {
            photoPickerActivity2.onFragmentDestroy();
        }
        super.onFragmentDestroy();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        PhotoPickerActivity photoPickerActivity = this.imagesSearch;
        if (photoPickerActivity != null) {
            photoPickerActivity.onConfigurationChanged(newConfig);
        }
        PhotoPickerActivity photoPickerActivity2 = this.gifsSearch;
        if (photoPickerActivity2 != null) {
            photoPickerActivity2.onConfigurationChanged(newConfig);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScrollY(float value) {
        this.actionBar.setTranslationY(value);
        int i = 0;
        while (true) {
            ViewPage[] viewPageArr = this.viewPages;
            if (i < viewPageArr.length) {
                viewPageArr[i].listView.setPinnedSectionOffsetY((int) value);
                i++;
            } else {
                this.fragmentView.invalidate();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void searchText(String text) {
        this.searchItem.getSearchField().setText(text);
        this.searchItem.getSearchField().setSelection(text.length());
        this.actionBar.onSearchPressed();
    }

    public void setDelegate(PhotoPickerActivity.PhotoPickerActivityDelegate delegate) {
        this.imagesSearch.setDelegate(delegate);
        this.gifsSearch.setDelegate(delegate);
        this.imagesSearch.setSearchDelegate(new PhotoPickerActivity.PhotoPickerActivitySearchDelegate() { // from class: ir.eitaa.ui.PhotoPickerSearchActivity.7
            @Override // ir.eitaa.ui.PhotoPickerActivity.PhotoPickerActivitySearchDelegate
            public void shouldSearchText(String text) {
                PhotoPickerSearchActivity.this.searchText(text);
            }

            @Override // ir.eitaa.ui.PhotoPickerActivity.PhotoPickerActivitySearchDelegate
            public void shouldClearRecentSearch() {
                PhotoPickerSearchActivity.this.imagesSearch.clearRecentSearch();
                PhotoPickerSearchActivity.this.gifsSearch.clearRecentSearch();
            }
        });
        this.gifsSearch.setSearchDelegate(new PhotoPickerActivity.PhotoPickerActivitySearchDelegate() { // from class: ir.eitaa.ui.PhotoPickerSearchActivity.8
            @Override // ir.eitaa.ui.PhotoPickerActivity.PhotoPickerActivitySearchDelegate
            public void shouldSearchText(String text) {
                PhotoPickerSearchActivity.this.searchText(text);
            }

            @Override // ir.eitaa.ui.PhotoPickerActivity.PhotoPickerActivitySearchDelegate
            public void shouldClearRecentSearch() {
                PhotoPickerSearchActivity.this.imagesSearch.clearRecentSearch();
                PhotoPickerSearchActivity.this.gifsSearch.clearRecentSearch();
            }
        });
    }

    public void setMaxSelectedPhotos(int value, boolean order) {
        this.imagesSearch.setMaxSelectedPhotos(value, order);
        this.gifsSearch.setMaxSelectedPhotos(value, order);
    }

    private void updateTabs() {
        ScrollSlidingTextTabStrip scrollSlidingTextTabStrip = this.scrollSlidingTextTabStrip;
        if (scrollSlidingTextTabStrip == null) {
            return;
        }
        scrollSlidingTextTabStrip.addTextTab(0, LocaleController.getString("ImagesTab2", R.string.ImagesTab2));
        this.scrollSlidingTextTabStrip.addTextTab(1, LocaleController.getString("GifsTab2", R.string.GifsTab2));
        this.scrollSlidingTextTabStrip.setVisibility(0);
        this.actionBar.setExtraHeight(AndroidUtilities.dp(44.0f));
        int currentTabId = this.scrollSlidingTextTabStrip.getCurrentTabId();
        if (currentTabId >= 0) {
            this.viewPages[0].selectedType = currentTabId;
        }
        this.scrollSlidingTextTabStrip.finishAddingTabs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchToCurrentSelectedMode(boolean z) {
        ViewPage[] viewPageArr;
        int i = 0;
        while (true) {
            viewPageArr = this.viewPages;
            if (i >= viewPageArr.length) {
                break;
            }
            viewPageArr[i].listView.stopScroll();
            i++;
        }
        viewPageArr[z ? 1 : 0].listView.getAdapter();
        this.viewPages[z ? 1 : 0].listView.setPinnedHeaderShadowDrawable(null);
        if (this.actionBar.getTranslationY() != 0.0f) {
            ((LinearLayoutManager) this.viewPages[z ? 1 : 0].listView.getLayoutManager()).scrollToPositionWithOffset(0, (int) this.actionBar.getTranslationY());
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "dialogBackground"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "dialogBackground"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, "dialogTextBlack"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, "dialogTextBlack"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "dialogButtonSelector"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SEARCH, null, null, null, null, "dialogTextBlack"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SEARCHPLACEHOLDER, null, null, null, null, "chat_messagePanelHint"));
        arrayList.add(new ThemeDescription(this.searchItem.getSearchField(), ThemeDescription.FLAG_CURSORCOLOR, null, null, null, null, "dialogTextBlack"));
        arrayList.add(new ThemeDescription(this.scrollSlidingTextTabStrip.getTabsContainer(), ThemeDescription.FLAG_CHECKTAG | ThemeDescription.FLAG_TEXTCOLOR, new Class[]{TextView.class}, null, null, null, "chat_attachActiveTab"));
        arrayList.add(new ThemeDescription(this.scrollSlidingTextTabStrip.getTabsContainer(), ThemeDescription.FLAG_TEXTCOLOR | ThemeDescription.FLAG_CHECKTAG, new Class[]{TextView.class}, null, null, null, "chat_attachUnactiveTab"));
        arrayList.add(new ThemeDescription(this.scrollSlidingTextTabStrip.getTabsContainer(), ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, new Class[]{TextView.class}, null, null, null, "dialogButtonSelector"));
        arrayList.add(new ThemeDescription(null, 0, null, null, new Drawable[]{this.scrollSlidingTextTabStrip.getSelectorDrawable()}, null, "chat_attachActiveTab"));
        arrayList.addAll(this.imagesSearch.getThemeDescriptions());
        arrayList.addAll(this.gifsSearch.getThemeDescriptions());
        return arrayList;
    }
}
