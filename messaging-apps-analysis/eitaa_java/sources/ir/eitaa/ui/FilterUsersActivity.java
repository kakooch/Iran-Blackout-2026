package ir.eitaa.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.Property;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.ScrollView;
import androidx.annotation.Keep;
import androidx.collection.LongSparseArray;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ContactsController;
import ir.eitaa.messenger.DialogObject;
import ir.eitaa.messenger.DispatchQueue;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserObject;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$Dialog;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Adapters.SearchAdapterHelper;
import ir.eitaa.ui.Cells.GraySectionCell;
import ir.eitaa.ui.Cells.GroupCreateUserCell;
import ir.eitaa.ui.Components.CombinedDrawable;
import ir.eitaa.ui.Components.EditTextBoldCursor;
import ir.eitaa.ui.Components.EmptyTextProgressView;
import ir.eitaa.ui.Components.GroupCreateSpan;
import ir.eitaa.ui.Components.RecyclerListView;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class FilterUsersActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate, View.OnClickListener {
    private GroupCreateAdapter adapter;
    private int containerHeight;
    private GroupCreateSpan currentDeletingSpan;
    private FilterUsersActivityDelegate delegate;
    private EditTextBoldCursor editText;
    private EmptyTextProgressView emptyView;
    private int fieldY;
    private int filterFlags;
    private ImageView floatingButton;
    private boolean ignoreScrollEvent;
    private ArrayList<Long> initialIds;
    private boolean isInclude;
    private RecyclerListView listView;
    private ScrollView scrollView;
    private boolean searchWas;
    private boolean searching;
    private int selectedCount;
    private SpansContainer spansContainer;
    private LongSparseArray<GroupCreateSpan> selectedContacts = new LongSparseArray<>();
    private ArrayList<GroupCreateSpan> allSpans = new ArrayList<>();

    public interface FilterUsersActivityDelegate {
        void didSelectChats(ArrayList<Long> ids, int flags);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateHint() {
    }

    static /* synthetic */ int access$1972(FilterUsersActivity filterUsersActivity, int i) {
        int i2 = i & filterUsersActivity.filterFlags;
        filterUsersActivity.filterFlags = i2;
        return i2;
    }

    static /* synthetic */ int access$508(FilterUsersActivity filterUsersActivity) {
        int i = filterUsersActivity.selectedCount;
        filterUsersActivity.selectedCount = i + 1;
        return i;
    }

    static /* synthetic */ int access$510(FilterUsersActivity filterUsersActivity) {
        int i = filterUsersActivity.selectedCount;
        filterUsersActivity.selectedCount = i - 1;
        return i;
    }

    private static class ItemDecoration extends RecyclerView.ItemDecoration {
        private boolean single;
        private int skipRows;

        private ItemDecoration() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
            int width = recyclerView.getWidth();
            int childCount = recyclerView.getChildCount() - (!this.single ? 1 : 0);
            int i = 0;
            while (i < childCount) {
                View childAt = recyclerView.getChildAt(i);
                View childAt2 = i < childCount + (-1) ? recyclerView.getChildAt(i + 1) : null;
                if (recyclerView.getChildAdapterPosition(childAt) >= this.skipRows && !(childAt instanceof GraySectionCell) && !(childAt2 instanceof GraySectionCell)) {
                    float bottom = childAt.getBottom();
                    canvas.drawLine(LocaleController.isRTL ? 0.0f : AndroidUtilities.dp(72.0f), bottom, width - (LocaleController.isRTL ? AndroidUtilities.dp(72.0f) : 0), bottom, Theme.dividerPaint);
                }
                i++;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.top = 1;
        }
    }

    private class SpansContainer extends ViewGroup {
        private View addingSpan;
        private boolean animationStarted;
        private ArrayList<Animator> animators;
        private AnimatorSet currentAnimation;
        private View removingSpan;

        public SpansContainer(Context context) {
            super(context);
            this.animators = new ArrayList<>();
        }

        @Override // android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            int iMin;
            int childCount = getChildCount();
            int size = View.MeasureSpec.getSize(widthMeasureSpec);
            int iDp = size - AndroidUtilities.dp(26.0f);
            int iDp2 = AndroidUtilities.dp(10.0f);
            int iDp3 = AndroidUtilities.dp(10.0f);
            int measuredWidth = 0;
            int measuredWidth2 = 0;
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof GroupCreateSpan) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(32.0f), 1073741824));
                    if (childAt != this.removingSpan && childAt.getMeasuredWidth() + measuredWidth > iDp) {
                        iDp2 += childAt.getMeasuredHeight() + AndroidUtilities.dp(8.0f);
                        measuredWidth = 0;
                    }
                    if (childAt.getMeasuredWidth() + measuredWidth2 > iDp) {
                        iDp3 += childAt.getMeasuredHeight() + AndroidUtilities.dp(8.0f);
                        measuredWidth2 = 0;
                    }
                    int iDp4 = AndroidUtilities.dp(13.0f) + measuredWidth;
                    if (!this.animationStarted) {
                        View view = this.removingSpan;
                        if (childAt == view) {
                            childAt.setTranslationX(AndroidUtilities.dp(13.0f) + measuredWidth2);
                            childAt.setTranslationY(iDp3);
                        } else if (view != null) {
                            float f = iDp4;
                            if (childAt.getTranslationX() != f) {
                                this.animators.add(ObjectAnimator.ofFloat(childAt, (Property<View, Float>) View.TRANSLATION_X, f));
                            }
                            float f2 = iDp2;
                            if (childAt.getTranslationY() != f2) {
                                this.animators.add(ObjectAnimator.ofFloat(childAt, (Property<View, Float>) View.TRANSLATION_Y, f2));
                            }
                        } else {
                            childAt.setTranslationX(iDp4);
                            childAt.setTranslationY(iDp2);
                        }
                    }
                    if (childAt != this.removingSpan) {
                        measuredWidth += childAt.getMeasuredWidth() + AndroidUtilities.dp(9.0f);
                    }
                    measuredWidth2 += childAt.getMeasuredWidth() + AndroidUtilities.dp(9.0f);
                }
            }
            if (AndroidUtilities.isTablet()) {
                iMin = AndroidUtilities.dp(372.0f) / 3;
            } else {
                Point point = AndroidUtilities.displaySize;
                iMin = (Math.min(point.x, point.y) - AndroidUtilities.dp(158.0f)) / 3;
            }
            if (iDp - measuredWidth < iMin) {
                iDp2 += AndroidUtilities.dp(40.0f);
                measuredWidth = 0;
            }
            if (iDp - measuredWidth2 < iMin) {
                iDp3 += AndroidUtilities.dp(40.0f);
            }
            FilterUsersActivity.this.editText.measure(View.MeasureSpec.makeMeasureSpec(iDp - measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(32.0f), 1073741824));
            if (!this.animationStarted) {
                int iDp5 = iDp3 + AndroidUtilities.dp(42.0f);
                int iDp6 = measuredWidth + AndroidUtilities.dp(16.0f);
                FilterUsersActivity.this.fieldY = iDp2;
                if (this.currentAnimation == null) {
                    FilterUsersActivity.this.containerHeight = iDp5;
                    FilterUsersActivity.this.editText.setTranslationX(iDp6);
                    FilterUsersActivity.this.editText.setTranslationY(FilterUsersActivity.this.fieldY);
                } else {
                    int iDp7 = iDp2 + AndroidUtilities.dp(42.0f);
                    if (FilterUsersActivity.this.containerHeight != iDp7) {
                        this.animators.add(ObjectAnimator.ofInt(FilterUsersActivity.this, "containerHeight", iDp7));
                    }
                    float f3 = iDp6;
                    if (FilterUsersActivity.this.editText.getTranslationX() != f3) {
                        this.animators.add(ObjectAnimator.ofFloat(FilterUsersActivity.this.editText, (Property<EditTextBoldCursor, Float>) View.TRANSLATION_X, f3));
                    }
                    if (FilterUsersActivity.this.editText.getTranslationY() != FilterUsersActivity.this.fieldY) {
                        this.animators.add(ObjectAnimator.ofFloat(FilterUsersActivity.this.editText, (Property<EditTextBoldCursor, Float>) View.TRANSLATION_Y, FilterUsersActivity.this.fieldY));
                    }
                    FilterUsersActivity.this.editText.setAllowDrawCursor(false);
                    this.currentAnimation.playTogether(this.animators);
                    this.currentAnimation.start();
                    this.animationStarted = true;
                }
            } else if (this.currentAnimation != null && !FilterUsersActivity.this.ignoreScrollEvent && this.removingSpan == null) {
                FilterUsersActivity.this.editText.bringPointIntoView(FilterUsersActivity.this.editText.getSelectionStart());
            }
            setMeasuredDimension(size, FilterUsersActivity.this.containerHeight);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                childAt.layout(0, 0, childAt.getMeasuredWidth(), childAt.getMeasuredHeight());
            }
        }

        public void addSpan(final GroupCreateSpan span, boolean animated) {
            FilterUsersActivity.this.allSpans.add(span);
            long uid = span.getUid();
            if (uid > -2147483638) {
                FilterUsersActivity.access$508(FilterUsersActivity.this);
            }
            FilterUsersActivity.this.selectedContacts.put(uid, span);
            FilterUsersActivity.this.editText.setHintVisible(false);
            AnimatorSet animatorSet = this.currentAnimation;
            if (animatorSet != null) {
                animatorSet.setupEndValues();
                this.currentAnimation.cancel();
            }
            this.animationStarted = false;
            if (animated) {
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.currentAnimation = animatorSet2;
                animatorSet2.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.FilterUsersActivity.SpansContainer.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        SpansContainer.this.addingSpan = null;
                        SpansContainer.this.currentAnimation = null;
                        SpansContainer.this.animationStarted = false;
                        FilterUsersActivity.this.editText.setAllowDrawCursor(true);
                    }
                });
                this.currentAnimation.setDuration(150L);
                this.addingSpan = span;
                this.animators.clear();
                this.animators.add(ObjectAnimator.ofFloat(this.addingSpan, (Property<View, Float>) View.SCALE_X, 0.01f, 1.0f));
                this.animators.add(ObjectAnimator.ofFloat(this.addingSpan, (Property<View, Float>) View.SCALE_Y, 0.01f, 1.0f));
                this.animators.add(ObjectAnimator.ofFloat(this.addingSpan, (Property<View, Float>) View.ALPHA, 0.0f, 1.0f));
            }
            addView(span);
        }

        public void removeSpan(final GroupCreateSpan span) {
            FilterUsersActivity.this.ignoreScrollEvent = true;
            long uid = span.getUid();
            if (uid > -2147483641) {
                FilterUsersActivity.access$510(FilterUsersActivity.this);
            }
            FilterUsersActivity.this.selectedContacts.remove(uid);
            FilterUsersActivity.this.allSpans.remove(span);
            span.setOnClickListener(null);
            AnimatorSet animatorSet = this.currentAnimation;
            if (animatorSet != null) {
                animatorSet.setupEndValues();
                this.currentAnimation.cancel();
            }
            this.animationStarted = false;
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.currentAnimation = animatorSet2;
            animatorSet2.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.FilterUsersActivity.SpansContainer.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    SpansContainer.this.removeView(span);
                    SpansContainer.this.removingSpan = null;
                    SpansContainer.this.currentAnimation = null;
                    SpansContainer.this.animationStarted = false;
                    FilterUsersActivity.this.editText.setAllowDrawCursor(true);
                    if (FilterUsersActivity.this.allSpans.isEmpty()) {
                        FilterUsersActivity.this.editText.setHintVisible(true);
                    }
                }
            });
            this.currentAnimation.setDuration(150L);
            this.removingSpan = span;
            this.animators.clear();
            this.animators.add(ObjectAnimator.ofFloat(this.removingSpan, (Property<View, Float>) View.SCALE_X, 1.0f, 0.01f));
            this.animators.add(ObjectAnimator.ofFloat(this.removingSpan, (Property<View, Float>) View.SCALE_Y, 1.0f, 0.01f));
            this.animators.add(ObjectAnimator.ofFloat(this.removingSpan, (Property<View, Float>) View.ALPHA, 1.0f, 0.0f));
            requestLayout();
        }
    }

    public FilterUsersActivity(boolean include, ArrayList<Long> arrayList, int flags) {
        this.isInclude = include;
        this.filterFlags = flags;
        this.initialIds = arrayList;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.contactsDidLoad);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.updateInterfaces);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.chatDidCreated);
        return super.onFragmentCreate();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() throws InterruptedException {
        super.onFragmentDestroy();
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.contactsDidLoad);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.updateInterfaces);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.chatDidCreated);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        GroupCreateSpan groupCreateSpan = (GroupCreateSpan) v;
        if (groupCreateSpan.isDeleting()) {
            this.currentDeletingSpan = null;
            this.spansContainer.removeSpan(groupCreateSpan);
            if (groupCreateSpan.getUid() == -2147483648L) {
                this.filterFlags &= MessagesController.DIALOG_FILTER_FLAG_CONTACTS ^ (-1);
            } else if (groupCreateSpan.getUid() == -2147483647L) {
                this.filterFlags &= MessagesController.DIALOG_FILTER_FLAG_NON_CONTACTS ^ (-1);
            } else if (groupCreateSpan.getUid() == -2147483646) {
                this.filterFlags &= MessagesController.DIALOG_FILTER_FLAG_GROUPS ^ (-1);
            } else if (groupCreateSpan.getUid() == -2147483645) {
                this.filterFlags &= MessagesController.DIALOG_FILTER_FLAG_CHANNELS ^ (-1);
            } else if (groupCreateSpan.getUid() == -2147483644) {
                this.filterFlags &= MessagesController.DIALOG_FILTER_FLAG_BOTS ^ (-1);
            } else if (groupCreateSpan.getUid() == -2147483643) {
                this.filterFlags &= MessagesController.DIALOG_FILTER_FLAG_EXCLUDE_MUTED ^ (-1);
            } else if (groupCreateSpan.getUid() == -2147483642) {
                this.filterFlags &= MessagesController.DIALOG_FILTER_FLAG_EXCLUDE_READ ^ (-1);
            } else if (groupCreateSpan.getUid() == -2147483641) {
                this.filterFlags &= MessagesController.DIALOG_FILTER_FLAG_EXCLUDE_ARCHIVED ^ (-1);
            }
            updateHint();
            checkVisibleRows();
            return;
        }
        GroupCreateSpan groupCreateSpan2 = this.currentDeletingSpan;
        if (groupCreateSpan2 != null) {
            groupCreateSpan2.cancelDeleteAnimation();
        }
        this.currentDeletingSpan = groupCreateSpan;
        groupCreateSpan.startDeleteAnimation();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public View createView(Context context) throws NoSuchFieldException {
        Object chat;
        int i;
        String str;
        this.searching = false;
        this.searchWas = false;
        this.allSpans.clear();
        this.selectedContacts.clear();
        this.currentDeletingSpan = null;
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setAllowOverlayTitle(true);
        if (this.isInclude) {
            this.actionBar.setTitle(LocaleController.getString("FilterAlwaysShow", R.string.FilterAlwaysShow));
        } else {
            this.actionBar.setTitle(LocaleController.getString("FilterNeverShow", R.string.FilterNeverShow));
        }
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.eitaa.ui.FilterUsersActivity.1
            @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int id) {
                if (id == -1) {
                    FilterUsersActivity.this.finishFragment();
                } else if (id == 1) {
                    FilterUsersActivity.this.onDonePressed(true);
                }
            }
        });
        ViewGroup viewGroup = new ViewGroup(context) { // from class: ir.eitaa.ui.FilterUsersActivity.2
            @Override // android.view.View
            protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                int iDp;
                int size = View.MeasureSpec.getSize(widthMeasureSpec);
                int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
                setMeasuredDimension(size, size2);
                if (AndroidUtilities.isTablet() || size2 > size) {
                    iDp = AndroidUtilities.dp(144.0f);
                } else {
                    iDp = AndroidUtilities.dp(56.0f);
                }
                FilterUsersActivity.this.scrollView.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(iDp, Integer.MIN_VALUE));
                FilterUsersActivity.this.listView.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2 - FilterUsersActivity.this.scrollView.getMeasuredHeight(), 1073741824));
                FilterUsersActivity.this.emptyView.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2 - FilterUsersActivity.this.scrollView.getMeasuredHeight(), 1073741824));
                if (FilterUsersActivity.this.floatingButton != null) {
                    int iDp2 = AndroidUtilities.dp(Build.VERSION.SDK_INT < 21 ? 60.0f : 56.0f);
                    FilterUsersActivity.this.floatingButton.measure(View.MeasureSpec.makeMeasureSpec(iDp2, 1073741824), View.MeasureSpec.makeMeasureSpec(iDp2, 1073741824));
                }
            }

            @Override // android.view.ViewGroup, android.view.View
            protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
                FilterUsersActivity.this.scrollView.layout(0, 0, FilterUsersActivity.this.scrollView.getMeasuredWidth(), FilterUsersActivity.this.scrollView.getMeasuredHeight());
                FilterUsersActivity.this.listView.layout(0, FilterUsersActivity.this.scrollView.getMeasuredHeight(), FilterUsersActivity.this.listView.getMeasuredWidth(), FilterUsersActivity.this.scrollView.getMeasuredHeight() + FilterUsersActivity.this.listView.getMeasuredHeight());
                FilterUsersActivity.this.emptyView.layout(0, FilterUsersActivity.this.scrollView.getMeasuredHeight(), FilterUsersActivity.this.emptyView.getMeasuredWidth(), FilterUsersActivity.this.scrollView.getMeasuredHeight() + FilterUsersActivity.this.emptyView.getMeasuredHeight());
                if (FilterUsersActivity.this.floatingButton != null) {
                    int iDp = LocaleController.isRTL ? AndroidUtilities.dp(14.0f) : ((right - left) - AndroidUtilities.dp(14.0f)) - FilterUsersActivity.this.floatingButton.getMeasuredWidth();
                    int iDp2 = ((bottom - top) - AndroidUtilities.dp(14.0f)) - FilterUsersActivity.this.floatingButton.getMeasuredHeight();
                    FilterUsersActivity.this.floatingButton.layout(iDp, iDp2, FilterUsersActivity.this.floatingButton.getMeasuredWidth() + iDp, FilterUsersActivity.this.floatingButton.getMeasuredHeight() + iDp2);
                }
            }

            @Override // android.view.ViewGroup
            protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
                boolean zDrawChild = super.drawChild(canvas, child, drawingTime);
                if (child == FilterUsersActivity.this.listView || child == FilterUsersActivity.this.emptyView) {
                    ((BaseFragment) FilterUsersActivity.this).parentLayout.drawHeaderShadow(canvas, FilterUsersActivity.this.scrollView.getMeasuredHeight());
                }
                return zDrawChild;
            }
        };
        this.fragmentView = viewGroup;
        ViewGroup viewGroup2 = viewGroup;
        ScrollView scrollView = new ScrollView(context) { // from class: ir.eitaa.ui.FilterUsersActivity.3
            @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewParent
            public boolean requestChildRectangleOnScreen(View child, Rect rectangle, boolean immediate) {
                if (FilterUsersActivity.this.ignoreScrollEvent) {
                    FilterUsersActivity.this.ignoreScrollEvent = false;
                    return false;
                }
                rectangle.offset(child.getLeft() - child.getScrollX(), child.getTop() - child.getScrollY());
                rectangle.top += FilterUsersActivity.this.fieldY + AndroidUtilities.dp(20.0f);
                rectangle.bottom += FilterUsersActivity.this.fieldY + AndroidUtilities.dp(50.0f);
                return super.requestChildRectangleOnScreen(child, rectangle, immediate);
            }
        };
        this.scrollView = scrollView;
        scrollView.setVerticalScrollBarEnabled(false);
        AndroidUtilities.setScrollViewEdgeEffectColor(this.scrollView, Theme.getColor("windowBackgroundWhite"));
        viewGroup2.addView(this.scrollView);
        this.spansContainer = new SpansContainer(context);
        EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(context) { // from class: ir.eitaa.ui.FilterUsersActivity.4
            @Override // android.widget.TextView, android.view.View
            public boolean onTouchEvent(MotionEvent event) {
                if (FilterUsersActivity.this.currentDeletingSpan != null) {
                    FilterUsersActivity.this.currentDeletingSpan.cancelDeleteAnimation();
                    FilterUsersActivity.this.currentDeletingSpan = null;
                }
                if (event.getAction() == 0 && !AndroidUtilities.showKeyboard(this)) {
                    clearFocus();
                    requestFocus();
                }
                return super.onTouchEvent(event);
            }
        };
        this.editText = editTextBoldCursor;
        editTextBoldCursor.setTextSize(1, 16.0f);
        this.editText.setHintColor(Theme.getColor("groupcreate_hintText"));
        this.editText.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        this.editText.setCursorColor(Theme.getColor("groupcreate_cursor"));
        this.editText.setCursorWidth(1.5f);
        this.editText.setInputType(655536);
        this.editText.setSingleLine(true);
        this.editText.setBackgroundDrawable(null);
        this.editText.setVerticalScrollBarEnabled(false);
        this.editText.setHorizontalScrollBarEnabled(false);
        this.editText.setTextIsSelectable(false);
        this.editText.setPadding(0, 0, 0, 0);
        this.editText.setImeOptions(268435462);
        this.editText.setGravity((LocaleController.isRTL ? 5 : 3) | 16);
        this.editText.setHintText(LocaleController.getString("SearchForPeopleAndGroups", R.string.SearchForPeopleAndGroups));
        this.editText.setCustomSelectionActionModeCallback(new ActionMode.Callback() { // from class: ir.eitaa.ui.FilterUsersActivity.5
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
        this.editText.setOnKeyListener(new View.OnKeyListener() { // from class: ir.eitaa.ui.FilterUsersActivity.6
            private boolean wasEmpty;

            @Override // android.view.View.OnKeyListener
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == 67) {
                    if (event.getAction() == 0) {
                        this.wasEmpty = FilterUsersActivity.this.editText.length() == 0;
                    } else if (event.getAction() == 1 && this.wasEmpty && !FilterUsersActivity.this.allSpans.isEmpty()) {
                        GroupCreateSpan groupCreateSpan = (GroupCreateSpan) FilterUsersActivity.this.allSpans.get(FilterUsersActivity.this.allSpans.size() - 1);
                        FilterUsersActivity.this.spansContainer.removeSpan(groupCreateSpan);
                        if (groupCreateSpan.getUid() == -2147483648L) {
                            FilterUsersActivity.access$1972(FilterUsersActivity.this, MessagesController.DIALOG_FILTER_FLAG_CONTACTS ^ (-1));
                        } else if (groupCreateSpan.getUid() == -2147483647L) {
                            FilterUsersActivity.access$1972(FilterUsersActivity.this, MessagesController.DIALOG_FILTER_FLAG_NON_CONTACTS ^ (-1));
                        } else if (groupCreateSpan.getUid() == -2147483646) {
                            FilterUsersActivity.access$1972(FilterUsersActivity.this, MessagesController.DIALOG_FILTER_FLAG_GROUPS ^ (-1));
                        } else if (groupCreateSpan.getUid() == -2147483645) {
                            FilterUsersActivity.access$1972(FilterUsersActivity.this, MessagesController.DIALOG_FILTER_FLAG_CHANNELS ^ (-1));
                        } else if (groupCreateSpan.getUid() == -2147483644) {
                            FilterUsersActivity.access$1972(FilterUsersActivity.this, MessagesController.DIALOG_FILTER_FLAG_BOTS ^ (-1));
                        } else if (groupCreateSpan.getUid() == -2147483643) {
                            FilterUsersActivity.access$1972(FilterUsersActivity.this, MessagesController.DIALOG_FILTER_FLAG_EXCLUDE_MUTED ^ (-1));
                        } else if (groupCreateSpan.getUid() == -2147483642) {
                            FilterUsersActivity.access$1972(FilterUsersActivity.this, MessagesController.DIALOG_FILTER_FLAG_EXCLUDE_READ ^ (-1));
                        } else if (groupCreateSpan.getUid() == -2147483641) {
                            FilterUsersActivity.access$1972(FilterUsersActivity.this, MessagesController.DIALOG_FILTER_FLAG_EXCLUDE_ARCHIVED ^ (-1));
                        }
                        FilterUsersActivity.this.updateHint();
                        FilterUsersActivity.this.checkVisibleRows();
                        return true;
                    }
                }
                return false;
            }
        });
        this.editText.addTextChangedListener(new TextWatcher() { // from class: ir.eitaa.ui.FilterUsersActivity.7
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) throws InterruptedException {
                if (FilterUsersActivity.this.editText.length() == 0) {
                    FilterUsersActivity.this.closeSearch();
                    return;
                }
                if (!FilterUsersActivity.this.adapter.searching) {
                    FilterUsersActivity.this.searching = true;
                    FilterUsersActivity.this.searchWas = true;
                    FilterUsersActivity.this.adapter.setSearching(true);
                    FilterUsersActivity.this.listView.setFastScrollVisible(false);
                    FilterUsersActivity.this.listView.setVerticalScrollBarEnabled(true);
                    FilterUsersActivity.this.emptyView.setText(LocaleController.getString("NoResult", R.string.NoResult));
                    FilterUsersActivity.this.emptyView.showProgress();
                }
                FilterUsersActivity.this.adapter.searchDialogs(FilterUsersActivity.this.editText.getText().toString());
            }
        });
        this.emptyView = new EmptyTextProgressView(context);
        if (ContactsController.getInstance(this.currentAccount).isLoadingContacts()) {
            this.emptyView.showProgress();
        } else {
            this.emptyView.showTextView();
        }
        this.emptyView.setShowAtCenter(true);
        this.emptyView.setText(LocaleController.getString("NoContacts", R.string.NoContacts));
        viewGroup2.addView(this.emptyView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, 1, false);
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        recyclerListView.setFastScrollEnabled();
        this.listView.setEmptyView(this.emptyView);
        RecyclerListView recyclerListView2 = this.listView;
        GroupCreateAdapter groupCreateAdapter = new GroupCreateAdapter(context);
        this.adapter = groupCreateAdapter;
        recyclerListView2.setAdapter(groupCreateAdapter);
        this.listView.setLayoutManager(linearLayoutManager);
        this.listView.setVerticalScrollBarEnabled(false);
        this.listView.setVerticalScrollbarPosition(LocaleController.isRTL ? 1 : 2);
        this.listView.addItemDecoration(new ItemDecoration());
        viewGroup2.addView(this.listView);
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.-$$Lambda$FilterUsersActivity$0hPpkvx7RaMlKGEHqZFTTQAsREA
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i2) {
                this.f$0.lambda$createView$0$FilterUsersActivity(view, i2);
            }
        });
        this.listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.eitaa.ui.FilterUsersActivity.8
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState == 1) {
                    AndroidUtilities.hideKeyboard(FilterUsersActivity.this.editText);
                }
            }
        });
        ImageView imageView = new ImageView(context);
        this.floatingButton = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        Drawable drawableCreateSimpleSelectorCircleDrawable = Theme.createSimpleSelectorCircleDrawable(AndroidUtilities.dp(56.0f), Theme.getColor("chats_actionBackground"), Theme.getColor("chats_actionPressedBackground"));
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 21) {
            Drawable drawableMutate = context.getResources().getDrawable(R.drawable.floating_shadow).mutate();
            drawableMutate.setColorFilter(new PorterDuffColorFilter(-16777216, PorterDuff.Mode.MULTIPLY));
            CombinedDrawable combinedDrawable = new CombinedDrawable(drawableMutate, drawableCreateSimpleSelectorCircleDrawable, 0, 0);
            combinedDrawable.setIconSize(AndroidUtilities.dp(56.0f), AndroidUtilities.dp(56.0f));
            drawableCreateSimpleSelectorCircleDrawable = combinedDrawable;
        }
        this.floatingButton.setBackgroundDrawable(drawableCreateSimpleSelectorCircleDrawable);
        this.floatingButton.setColorFilter(new PorterDuffColorFilter(Theme.getColor("chats_actionIcon"), PorterDuff.Mode.MULTIPLY));
        this.floatingButton.setImageResource(R.drawable.floating_check);
        if (i2 >= 21) {
            StateListAnimator stateListAnimator = new StateListAnimator();
            int[] iArr = {android.R.attr.state_pressed};
            ImageView imageView2 = this.floatingButton;
            Property property = View.TRANSLATION_Z;
            stateListAnimator.addState(iArr, ObjectAnimator.ofFloat(imageView2, (Property<ImageView, Float>) property, AndroidUtilities.dp(2.0f), AndroidUtilities.dp(4.0f)).setDuration(200L));
            stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(this.floatingButton, (Property<ImageView, Float>) property, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(2.0f)).setDuration(200L));
            this.floatingButton.setStateListAnimator(stateListAnimator);
            this.floatingButton.setOutlineProvider(new ViewOutlineProvider() { // from class: ir.eitaa.ui.FilterUsersActivity.9
                @Override // android.view.ViewOutlineProvider
                @SuppressLint({"NewApi"})
                public void getOutline(View view, Outline outline) {
                    outline.setOval(0, 0, AndroidUtilities.dp(56.0f), AndroidUtilities.dp(56.0f));
                }
            });
        }
        viewGroup2.addView(this.floatingButton);
        this.floatingButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$FilterUsersActivity$DF6vH-PqGFRPTwvO6TEcBSfhwpY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createView$1$FilterUsersActivity(view);
            }
        });
        this.floatingButton.setContentDescription(LocaleController.getString("Next", R.string.Next));
        int i3 = this.isInclude ? 5 : 3;
        for (int i4 = 1; i4 <= i3; i4++) {
            if (this.isInclude) {
                if (i4 == 1) {
                    i = MessagesController.DIALOG_FILTER_FLAG_CONTACTS;
                    str = "contacts";
                } else if (i4 == 2) {
                    i = MessagesController.DIALOG_FILTER_FLAG_NON_CONTACTS;
                    str = "non_contacts";
                } else if (i4 == 3) {
                    i = MessagesController.DIALOG_FILTER_FLAG_GROUPS;
                    str = "groups";
                } else if (i4 == 4) {
                    i = MessagesController.DIALOG_FILTER_FLAG_CHANNELS;
                    str = "channels";
                } else {
                    i = MessagesController.DIALOG_FILTER_FLAG_BOTS;
                    str = "bots";
                }
            } else if (i4 == 1) {
                i = MessagesController.DIALOG_FILTER_FLAG_EXCLUDE_MUTED;
                str = "muted";
            } else if (i4 == 2) {
                i = MessagesController.DIALOG_FILTER_FLAG_EXCLUDE_READ;
                str = "read";
            } else {
                i = MessagesController.DIALOG_FILTER_FLAG_EXCLUDE_ARCHIVED;
                str = "archived";
            }
            if ((i & this.filterFlags) != 0) {
                GroupCreateSpan groupCreateSpan = new GroupCreateSpan(this.editText.getContext(), str);
                this.spansContainer.addSpan(groupCreateSpan, false);
                groupCreateSpan.setOnClickListener(this);
            }
        }
        ArrayList<Long> arrayList = this.initialIds;
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = this.initialIds.size();
            for (int i5 = 0; i5 < size; i5++) {
                Long l = this.initialIds.get(i5);
                if (l.longValue() > 0) {
                    chat = getMessagesController().getUser(l);
                } else {
                    chat = getMessagesController().getChat(Long.valueOf(-l.longValue()));
                }
                if (chat != null) {
                    GroupCreateSpan groupCreateSpan2 = new GroupCreateSpan(this.editText.getContext(), chat);
                    this.spansContainer.addSpan(groupCreateSpan2, false);
                    groupCreateSpan2.setOnClickListener(this);
                }
            }
        }
        updateHint();
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$0$FilterUsersActivity(View view, int i) {
        long j;
        int i2;
        if (view instanceof GroupCreateUserCell) {
            GroupCreateUserCell groupCreateUserCell = (GroupCreateUserCell) view;
            Object object = groupCreateUserCell.getObject();
            boolean z = object instanceof String;
            if (z) {
                if (this.isInclude) {
                    if (i == 1) {
                        i2 = MessagesController.DIALOG_FILTER_FLAG_CONTACTS;
                        j = -2147483648L;
                    } else if (i == 2) {
                        i2 = MessagesController.DIALOG_FILTER_FLAG_NON_CONTACTS;
                        j = -2147483647L;
                    } else if (i == 3) {
                        i2 = MessagesController.DIALOG_FILTER_FLAG_GROUPS;
                        j = -2147483646;
                    } else if (i == 4) {
                        i2 = MessagesController.DIALOG_FILTER_FLAG_CHANNELS;
                        j = -2147483645;
                    } else if (i == 5) {
                        i2 = MessagesController.DIALOG_FILTER_FLAG_MEDIA_CHANNEL;
                        j = -2147483640;
                    } else if (i == 6) {
                        i2 = MessagesController.DIALOG_FILTER_FLAG_ADMIN;
                        j = -2147483639;
                    } else {
                        i2 = MessagesController.DIALOG_FILTER_FLAG_FAVORITE;
                        j = -2147483638;
                    }
                } else if (i == 1) {
                    i2 = MessagesController.DIALOG_FILTER_FLAG_EXCLUDE_MUTED;
                    j = -2147483643;
                } else if (i == 2) {
                    i2 = MessagesController.DIALOG_FILTER_FLAG_EXCLUDE_READ;
                    j = -2147483642;
                } else {
                    i2 = MessagesController.DIALOG_FILTER_FLAG_EXCLUDE_ARCHIVED;
                    j = -2147483641;
                }
                if (groupCreateUserCell.isChecked()) {
                    this.filterFlags = (i2 ^ (-1)) & this.filterFlags;
                } else {
                    this.filterFlags = i2 | this.filterFlags;
                }
            } else if (object instanceof TLRPC$User) {
                j = ((TLRPC$User) object).id;
            } else if (!(object instanceof TLRPC$Chat)) {
                return;
            } else {
                j = -((TLRPC$Chat) object).id;
            }
            boolean z2 = this.selectedContacts.indexOfKey(j) >= 0;
            if (z2) {
                this.spansContainer.removeSpan(this.selectedContacts.get(j));
            } else {
                if (!z && this.selectedCount >= 100) {
                    return;
                }
                if (object instanceof TLRPC$User) {
                    MessagesController.getInstance(this.currentAccount).putUser((TLRPC$User) object, !this.searching);
                } else if (object instanceof TLRPC$Chat) {
                    MessagesController.getInstance(this.currentAccount).putChat((TLRPC$Chat) object, !this.searching);
                }
                GroupCreateSpan groupCreateSpan = new GroupCreateSpan(this.editText.getContext(), object);
                this.spansContainer.addSpan(groupCreateSpan, true);
                groupCreateSpan.setOnClickListener(this);
            }
            updateHint();
            if (this.searching || this.searchWas) {
                AndroidUtilities.showKeyboard(this.editText);
            } else {
                groupCreateUserCell.setChecked(!z2, true);
            }
            if (this.editText.length() > 0) {
                this.editText.setText((CharSequence) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$1$FilterUsersActivity(View view) {
        onDonePressed(true);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        EditTextBoldCursor editTextBoldCursor = this.editText;
        if (editTextBoldCursor != null) {
            editTextBoldCursor.requestFocus();
        }
        AndroidUtilities.requestAdjustResize(getParentActivity(), this.classGuid);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment, ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        if (id == NotificationCenter.contactsDidLoad) {
            EmptyTextProgressView emptyTextProgressView = this.emptyView;
            if (emptyTextProgressView != null) {
                emptyTextProgressView.showTextView();
            }
            GroupCreateAdapter groupCreateAdapter = this.adapter;
            if (groupCreateAdapter != null) {
                groupCreateAdapter.notifyDataSetChanged();
                return;
            }
            return;
        }
        if (id == NotificationCenter.updateInterfaces) {
            if (this.listView != null) {
                int iIntValue = ((Integer) args[0]).intValue();
                int childCount = this.listView.getChildCount();
                if ((MessagesController.UPDATE_MASK_AVATAR & iIntValue) == 0 && (MessagesController.UPDATE_MASK_NAME & iIntValue) == 0 && (MessagesController.UPDATE_MASK_STATUS & iIntValue) == 0) {
                    return;
                }
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.listView.getChildAt(i);
                    if (childAt instanceof GroupCreateUserCell) {
                        ((GroupCreateUserCell) childAt).update(iIntValue);
                    }
                }
                return;
            }
            return;
        }
        if (id == NotificationCenter.chatDidCreated) {
            removeSelfFromStack();
        }
    }

    @Keep
    public void setContainerHeight(int value) {
        this.containerHeight = value;
        SpansContainer spansContainer = this.spansContainer;
        if (spansContainer != null) {
            spansContainer.requestLayout();
        }
    }

    @Keep
    public int getContainerHeight() {
        return this.containerHeight;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkVisibleRows() {
        long j;
        int childCount = this.listView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.listView.getChildAt(i);
            if (childAt instanceof GroupCreateUserCell) {
                GroupCreateUserCell groupCreateUserCell = (GroupCreateUserCell) childAt;
                Object object = groupCreateUserCell.getObject();
                if (object instanceof String) {
                    switch ((String) object) {
                        case "contacts":
                            j = -2147483648L;
                            break;
                        case "non_contacts":
                            j = -2147483647L;
                            break;
                        case "groups":
                            j = -2147483646;
                            break;
                        case "channels":
                            j = -2147483645;
                            break;
                        case "bots":
                            j = -2147483644;
                            break;
                        case "muted":
                            j = -2147483643;
                            break;
                        case "read":
                            j = -2147483642;
                            break;
                        case "archived":
                        default:
                            j = -2147483641;
                            break;
                    }
                } else if (object instanceof TLRPC$User) {
                    j = ((TLRPC$User) object).id;
                } else {
                    j = object instanceof TLRPC$Chat ? -((TLRPC$Chat) object).id : 0L;
                }
                if (j != 0) {
                    groupCreateUserCell.setChecked(this.selectedContacts.indexOfKey(j) >= 0, true);
                    groupCreateUserCell.setCheckBoxEnabled(true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean onDonePressed(boolean alert) {
        ArrayList<Long> arrayList = new ArrayList<>();
        for (int i = 0; i < this.selectedContacts.size(); i++) {
            if (this.selectedContacts.keyAt(i) > -2147483638) {
                arrayList.add(Long.valueOf(this.selectedContacts.keyAt(i)));
            }
        }
        FilterUsersActivityDelegate filterUsersActivityDelegate = this.delegate;
        if (filterUsersActivityDelegate != null) {
            filterUsersActivityDelegate.didSelectChats(arrayList, this.filterFlags);
        }
        finishFragment();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeSearch() throws InterruptedException {
        this.searching = false;
        this.searchWas = false;
        this.adapter.setSearching(false);
        this.adapter.searchDialogs(null);
        this.listView.setFastScrollVisible(true);
        this.listView.setVerticalScrollBarEnabled(false);
        this.emptyView.setText(LocaleController.getString("NoContacts", R.string.NoContacts));
    }

    public void setDelegate(FilterUsersActivityDelegate filterUsersActivityDelegate) {
        this.delegate = filterUsersActivityDelegate;
    }

    public class GroupCreateAdapter extends RecyclerListView.FastScrollAdapter {
        private Context context;
        private SearchAdapterHelper searchAdapterHelper;
        private Runnable searchRunnable;
        private boolean searching;
        private final int usersStartRow;
        private ArrayList<Object> searchResult = new ArrayList<>();
        private ArrayList<CharSequence> searchResultNames = new ArrayList<>();
        private ArrayList<TLObject> contacts = new ArrayList<>();

        @Override // ir.eitaa.ui.Components.RecyclerListView.FastScrollAdapter
        public String getLetter(int position) {
            return null;
        }

        public GroupCreateAdapter(Context ctx) {
            this.usersStartRow = FilterUsersActivity.this.isInclude ? 8 : 4;
            this.context = ctx;
            ArrayList<TLRPC$Dialog> allDialogs = FilterUsersActivity.this.getMessagesController().getAllDialogs();
            int size = allDialogs.size();
            boolean z = false;
            for (int i = 0; i < size; i++) {
                TLRPC$Dialog tLRPC$Dialog = allDialogs.get(i);
                if (!DialogObject.isEncryptedDialog(tLRPC$Dialog.id)) {
                    if (DialogObject.isUserDialog(tLRPC$Dialog.id)) {
                        TLRPC$User user = FilterUsersActivity.this.getMessagesController().getUser(Long.valueOf(tLRPC$Dialog.id));
                        if (user != null) {
                            this.contacts.add(user);
                            if (UserObject.isUserSelf(user)) {
                                z = true;
                            }
                        }
                    } else {
                        TLRPC$Chat chat = FilterUsersActivity.this.getMessagesController().getChat(Long.valueOf(-tLRPC$Dialog.id));
                        if (chat != null) {
                            this.contacts.add(chat);
                        }
                    }
                }
            }
            if (!z) {
                this.contacts.add(0, FilterUsersActivity.this.getMessagesController().getUser(Long.valueOf(FilterUsersActivity.this.getUserConfig().clientUserId)));
            }
            SearchAdapterHelper searchAdapterHelper = new SearchAdapterHelper(false);
            this.searchAdapterHelper = searchAdapterHelper;
            searchAdapterHelper.setAllowGlobalResults(false);
            this.searchAdapterHelper.setDelegate(new SearchAdapterHelper.SearchAdapterHelperDelegate() { // from class: ir.eitaa.ui.-$$Lambda$FilterUsersActivity$GroupCreateAdapter$OSXja_TNW1eTu4iFexBIsvGY_h0
                @Override // ir.eitaa.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                public /* synthetic */ boolean canApplySearchResults(int i2) {
                    return SearchAdapterHelper.SearchAdapterHelperDelegate.CC.$default$canApplySearchResults(this, i2);
                }

                @Override // ir.eitaa.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                public /* synthetic */ LongSparseArray getExcludeCallParticipants() {
                    return SearchAdapterHelper.SearchAdapterHelperDelegate.CC.$default$getExcludeCallParticipants(this);
                }

                @Override // ir.eitaa.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                public /* synthetic */ LongSparseArray getExcludeUsers() {
                    return SearchAdapterHelper.SearchAdapterHelperDelegate.CC.$default$getExcludeUsers(this);
                }

                @Override // ir.eitaa.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                public final void onDataSetChanged(int i2) {
                    this.f$0.lambda$new$0$FilterUsersActivity$GroupCreateAdapter(i2);
                }

                @Override // ir.eitaa.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                public /* synthetic */ void onSetHashtags(ArrayList arrayList, HashMap map) {
                    SearchAdapterHelper.SearchAdapterHelperDelegate.CC.$default$onSetHashtags(this, arrayList, map);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$0$FilterUsersActivity$GroupCreateAdapter(int i) {
            if (this.searchRunnable == null && !this.searchAdapterHelper.isSearchInProgress()) {
                FilterUsersActivity.this.emptyView.showTextView();
            }
            notifyDataSetChanged();
        }

        public void setSearching(boolean value) {
            if (this.searching == value) {
                return;
            }
            this.searching = value;
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (this.searching) {
                return this.searchResult.size() + this.searchAdapterHelper.getLocalServerSearch().size() + this.searchAdapterHelper.getGlobalSearch().size();
            }
            return FilterUsersActivity.this.isInclude ? 8 : 4;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View groupCreateUserCell;
            if (viewType == 1) {
                groupCreateUserCell = new GroupCreateUserCell(this.context, 1, 0, true);
            } else {
                groupCreateUserCell = new GraySectionCell(this.context);
            }
            return new RecyclerListView.Holder(groupCreateUserCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            String string;
            int i;
            String str;
            String str2;
            int itemViewType = holder.getItemViewType();
            if (itemViewType == 1) {
                GroupCreateUserCell groupCreateUserCell = (GroupCreateUserCell) holder.itemView;
                Object obj = null;
                if (this.searching) {
                    int size = this.searchResult.size();
                    int size2 = this.searchAdapterHelper.getGlobalSearch().size();
                    int size3 = this.searchAdapterHelper.getLocalServerSearch().size();
                    if (position >= 0 && position < size) {
                        obj = this.searchResult.get(position);
                    } else if (position >= size && position < size3 + size) {
                        obj = this.searchAdapterHelper.getLocalServerSearch().get(position - size);
                    } else if (position > size + size3 && position < size2 + size + size3) {
                        obj = this.searchAdapterHelper.getGlobalSearch().get((position - size) - size3);
                    }
                    if (obj != null) {
                        if (obj instanceof TLRPC$User) {
                            str2 = ((TLRPC$User) obj).username;
                        } else {
                            str2 = ((TLRPC$Chat) obj).username;
                        }
                        if (position < size) {
                            CharSequence charSequence = this.searchResultNames.get(position);
                            if (charSequence != null && !TextUtils.isEmpty(str2)) {
                                charSequence.toString().startsWith("@" + str2);
                            }
                        } else if (position > size && !TextUtils.isEmpty(str2)) {
                            String lastFoundUsername = this.searchAdapterHelper.getLastFoundUsername();
                            if (lastFoundUsername.startsWith("@")) {
                                lastFoundUsername = lastFoundUsername.substring(1);
                            }
                            try {
                                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                                spannableStringBuilder.append((CharSequence) "@");
                                spannableStringBuilder.append((CharSequence) str2);
                                int iIndexOfIgnoreCase = AndroidUtilities.indexOfIgnoreCase(str2, lastFoundUsername);
                                if (iIndexOfIgnoreCase != -1) {
                                    int length = lastFoundUsername.length();
                                    if (iIndexOfIgnoreCase == 0) {
                                        length++;
                                    } else {
                                        iIndexOfIgnoreCase++;
                                    }
                                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Theme.getColor("windowBackgroundWhiteBlueText4")), iIndexOfIgnoreCase, length + iIndexOfIgnoreCase, 33);
                                }
                            } catch (Exception unused) {
                            }
                        }
                    }
                } else if (position < this.usersStartRow) {
                    if (FilterUsersActivity.this.isInclude) {
                        if (position == 1) {
                            string = LocaleController.getString("FilterContacts", R.string.FilterContacts);
                            i = MessagesController.DIALOG_FILTER_FLAG_CONTACTS;
                            str = "contacts";
                        } else if (position == 2) {
                            string = LocaleController.getString("FilterNonContacts", R.string.FilterNonContacts);
                            i = MessagesController.DIALOG_FILTER_FLAG_NON_CONTACTS;
                            str = "non_contacts";
                        } else if (position == 3) {
                            string = LocaleController.getString("FilterGroups", R.string.FilterGroups);
                            i = MessagesController.DIALOG_FILTER_FLAG_GROUPS;
                            str = "groups";
                        } else if (position == 4) {
                            string = LocaleController.getString("FilterChannels", R.string.FilterChannels);
                            i = MessagesController.DIALOG_FILTER_FLAG_CHANNELS;
                            str = "channels";
                        } else if (position == 5) {
                            string = LocaleController.getString("SocialMediaFilter", R.string.SocialMediaFilter);
                            i = MessagesController.DIALOG_FILTER_FLAG_MEDIA_CHANNEL;
                            str = "socialMedia";
                        } else if (position == 6) {
                            string = LocaleController.getString("AdminFilter", R.string.AdminFilter);
                            i = MessagesController.DIALOG_FILTER_FLAG_ADMIN;
                            str = "admin";
                        } else {
                            string = LocaleController.getString("FavoriteFilter", R.string.FavoriteFilter);
                            i = MessagesController.DIALOG_FILTER_FLAG_FAVORITE;
                            str = "favorite";
                        }
                    } else if (position == 1) {
                        string = LocaleController.getString("FilterMuted", R.string.FilterMuted);
                        i = MessagesController.DIALOG_FILTER_FLAG_EXCLUDE_MUTED;
                        str = "muted";
                    } else if (position == 2) {
                        string = LocaleController.getString("FilterRead", R.string.FilterRead);
                        i = MessagesController.DIALOG_FILTER_FLAG_EXCLUDE_READ;
                        str = "read";
                    } else {
                        string = LocaleController.getString("FilterArchived", R.string.FilterArchived);
                        i = MessagesController.DIALOG_FILTER_FLAG_EXCLUDE_ARCHIVED;
                        str = "archived";
                    }
                    groupCreateUserCell.setObject(str, string, null);
                    groupCreateUserCell.setChecked((FilterUsersActivity.this.filterFlags & i) == i, false);
                    groupCreateUserCell.setCheckBoxEnabled(true);
                    return;
                }
            } else if (itemViewType != 2) {
                return;
            }
            GraySectionCell graySectionCell = (GraySectionCell) holder.itemView;
            if (position == 0) {
                graySectionCell.setText(LocaleController.getString("FilterChatTypes", R.string.FilterChatTypes));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            if (this.searching) {
                return 1;
            }
            if (FilterUsersActivity.this.isInclude) {
                if (position == 0 || position == 8) {
                    return 2;
                }
            } else if (position == 0 || position == 4) {
                return 2;
            }
            return 1;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.FastScrollAdapter
        public int getPositionForScrollProgress(float progress) {
            return (int) (getItemCount() * progress);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewRecycled(RecyclerView.ViewHolder holder) {
            View view = holder.itemView;
            if (view instanceof GroupCreateUserCell) {
                ((GroupCreateUserCell) view).recycle();
            }
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            return holder.getItemViewType() == 1;
        }

        public void searchDialogs(final String query) throws InterruptedException {
            if (this.searchRunnable != null) {
                Utilities.searchQueue.cancelRunnable(this.searchRunnable);
                this.searchRunnable = null;
            }
            if (query == null) {
                this.searchResult.clear();
                this.searchResultNames.clear();
                this.searchAdapterHelper.mergeResults(null);
                this.searchAdapterHelper.queryServerSearch(null, true, true, false, false, false, 0L, false, 0, 0);
                notifyDataSetChanged();
                return;
            }
            DispatchQueue dispatchQueue = Utilities.searchQueue;
            Runnable runnable = new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$FilterUsersActivity$GroupCreateAdapter$k0NP6ZFfDnarDX5S1O0Jl4DEuMs
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$searchDialogs$3$FilterUsersActivity$GroupCreateAdapter(query);
                }
            };
            this.searchRunnable = runnable;
            dispatchQueue.postRunnable(runnable, 300L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$searchDialogs$3, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$searchDialogs$3$FilterUsersActivity$GroupCreateAdapter(final String str) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$FilterUsersActivity$GroupCreateAdapter$lFjzkay83b4z8c1XmK6qA18a7iM
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$searchDialogs$2$FilterUsersActivity$GroupCreateAdapter(str);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$searchDialogs$2, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$searchDialogs$2$FilterUsersActivity$GroupCreateAdapter(final String str) {
            this.searchAdapterHelper.queryServerSearch(str, true, true, true, true, false, 0L, false, 0, 0);
            DispatchQueue dispatchQueue = Utilities.searchQueue;
            Runnable runnable = new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$FilterUsersActivity$GroupCreateAdapter$3zng0Ic-Hzu98UsEIiGTZ5CgwyA
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$searchDialogs$1$FilterUsersActivity$GroupCreateAdapter(str);
                }
            };
            this.searchRunnable = runnable;
            dispatchQueue.postRunnable(runnable);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$searchDialogs$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$searchDialogs$1$FilterUsersActivity$GroupCreateAdapter(String str) {
            String str2;
            int i;
            String str3;
            String lowerCase = str.trim().toLowerCase();
            if (lowerCase.length() == 0) {
                updateSearchResults(new ArrayList<>(), new ArrayList<>());
                return;
            }
            String translitString = LocaleController.getInstance().getTranslitString(lowerCase);
            String str4 = null;
            if (lowerCase.equals(translitString) || translitString.length() == 0) {
                translitString = null;
            }
            char c = 0;
            char c2 = 1;
            int i2 = (translitString != null ? 1 : 0) + 1;
            String[] strArr = new String[i2];
            strArr[0] = lowerCase;
            if (translitString != null) {
                strArr[1] = translitString;
            }
            ArrayList<Object> arrayList = new ArrayList<>();
            ArrayList<CharSequence> arrayList2 = new ArrayList<>();
            int i3 = 0;
            while (i3 < this.contacts.size()) {
                TLObject tLObject = this.contacts.get(i3);
                String[] strArr2 = new String[3];
                boolean z = tLObject instanceof TLRPC$User;
                if (z) {
                    TLRPC$User tLRPC$User = (TLRPC$User) tLObject;
                    strArr2[c] = ContactsController.formatName(tLRPC$User.first_name, tLRPC$User.last_name).toLowerCase();
                    str2 = tLRPC$User.username;
                    if (UserObject.isReplyUser(tLRPC$User)) {
                        strArr2[2] = LocaleController.getString("RepliesTitle", R.string.RepliesTitle).toLowerCase();
                    } else if (tLRPC$User.self) {
                        strArr2[2] = LocaleController.getString("SavedMessages", R.string.SavedMessages).toLowerCase();
                    }
                } else {
                    TLRPC$Chat tLRPC$Chat = (TLRPC$Chat) tLObject;
                    strArr2[c] = tLRPC$Chat.title.toLowerCase();
                    str2 = tLRPC$Chat.username;
                }
                strArr2[c2] = LocaleController.getInstance().getTranslitString(strArr2[c]);
                if (strArr2[c].equals(strArr2[c2])) {
                    strArr2[c2] = str4;
                }
                int i4 = 0;
                char c3 = 0;
                while (true) {
                    if (i4 >= i2) {
                        i = i2;
                        str3 = str4;
                        break;
                    }
                    String str5 = strArr[i4];
                    int i5 = 0;
                    while (i5 < 3) {
                        String str6 = strArr2[i5];
                        if (str6 != null) {
                            if (str6.startsWith(str5)) {
                                i = i2;
                            } else {
                                StringBuilder sb = new StringBuilder();
                                i = i2;
                                sb.append(" ");
                                sb.append(str5);
                                if (str6.contains(sb.toString())) {
                                }
                            }
                            c3 = 1;
                            break;
                        }
                        i = i2;
                        i5++;
                        i2 = i;
                    }
                    i = i2;
                    if (c3 == 0 && str2 != null && str2.toLowerCase().startsWith(str5)) {
                        c3 = 2;
                    }
                    if (c3 != 0) {
                        if (c3 == 1) {
                            if (z) {
                                TLRPC$User tLRPC$User2 = (TLRPC$User) tLObject;
                                arrayList2.add(AndroidUtilities.generateSearchName(tLRPC$User2.first_name, tLRPC$User2.last_name, str5));
                            } else {
                                arrayList2.add(AndroidUtilities.generateSearchName(((TLRPC$Chat) tLObject).title, null, str5));
                            }
                            str3 = null;
                        } else {
                            str3 = null;
                            arrayList2.add(AndroidUtilities.generateSearchName("@" + str2, null, "@" + str5));
                        }
                        arrayList.add(tLObject);
                    } else {
                        i4++;
                        str4 = null;
                        i2 = i;
                    }
                }
                i3++;
                str4 = str3;
                i2 = i;
                c = 0;
                c2 = 1;
            }
            updateSearchResults(arrayList, arrayList2);
        }

        private void updateSearchResults(final ArrayList<Object> users, final ArrayList<CharSequence> names) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$FilterUsersActivity$GroupCreateAdapter$L1nZL38ughgpd-WTjZ6nQD3hkH4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$updateSearchResults$4$FilterUsersActivity$GroupCreateAdapter(users, names);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$updateSearchResults$4, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$updateSearchResults$4$FilterUsersActivity$GroupCreateAdapter(ArrayList arrayList, ArrayList arrayList2) {
            if (this.searching) {
                this.searchRunnable = null;
                this.searchResult = arrayList;
                this.searchResultNames = arrayList2;
                this.searchAdapterHelper.mergeResults(arrayList);
                if (this.searching && !this.searchAdapterHelper.isSearchInProgress()) {
                    FilterUsersActivity.this.emptyView.showTextView();
                }
                notifyDataSetChanged();
            }
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: ir.eitaa.ui.-$$Lambda$FilterUsersActivity$WQAGDWCejWR8BrkHWwHOT_HYyhI
            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public final void didSetColor() {
                this.f$0.lambda$getThemeDescriptions$2$FilterUsersActivity();
            }

            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public /* synthetic */ void onAnimationProgress(float f) {
                ThemeDescription.ThemeDescriptionDelegate.CC.$default$onAnimationProgress(this, f);
            }
        };
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, "actionBarDefaultIcon"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, "actionBarDefaultTitle"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "actionBarDefaultSelector"));
        arrayList.add(new ThemeDescription(this.scrollView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_FASTSCROLL, null, null, null, null, "fastScrollActive"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_FASTSCROLL, null, null, null, null, "fastScrollInactive"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_FASTSCROLL, null, null, null, null, "fastScrollText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, "divider"));
        arrayList.add(new ThemeDescription(this.emptyView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "emptyListPlaceholder"));
        arrayList.add(new ThemeDescription(this.emptyView, ThemeDescription.FLAG_PROGRESSBAR, null, null, null, null, "progressCircle"));
        arrayList.add(new ThemeDescription(this.editText, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.editText, ThemeDescription.FLAG_HINTTEXTCOLOR, null, null, null, null, "groupcreate_hintText"));
        arrayList.add(new ThemeDescription(this.editText, ThemeDescription.FLAG_CURSORCOLOR, null, null, null, null, "groupcreate_cursor"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{GraySectionCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "key_graySectionText"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{GraySectionCell.class}, null, null, null, "graySection"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{GroupCreateUserCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "groupcreate_sectionText"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{GroupCreateUserCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "checkbox"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{GroupCreateUserCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "checkboxDisabled"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{GroupCreateUserCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "checkboxCheck"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_TEXTCOLOR | ThemeDescription.FLAG_CHECKTAG, new Class[]{GroupCreateUserCell.class}, new String[]{"statusTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueText"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_TEXTCOLOR | ThemeDescription.FLAG_CHECKTAG, new Class[]{GroupCreateUserCell.class}, new String[]{"statusTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{GroupCreateUserCell.class}, null, Theme.avatarDrawables, null, "avatar_text"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundRed"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundOrange"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundViolet"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundGreen"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundCyan"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundBlue"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundPink"));
        arrayList.add(new ThemeDescription(this.spansContainer, 0, new Class[]{GroupCreateSpan.class}, null, null, null, "groupcreate_spanBackground"));
        arrayList.add(new ThemeDescription(this.spansContainer, 0, new Class[]{GroupCreateSpan.class}, null, null, null, "groupcreate_spanText"));
        arrayList.add(new ThemeDescription(this.spansContainer, 0, new Class[]{GroupCreateSpan.class}, null, null, null, "groupcreate_spanDelete"));
        arrayList.add(new ThemeDescription(this.spansContainer, 0, new Class[]{GroupCreateSpan.class}, null, null, null, "avatar_backgroundBlue"));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getThemeDescriptions$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getThemeDescriptions$2$FilterUsersActivity() {
        RecyclerListView recyclerListView = this.listView;
        if (recyclerListView != null) {
            int childCount = recyclerListView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.listView.getChildAt(i);
                if (childAt instanceof GroupCreateUserCell) {
                    ((GroupCreateUserCell) childAt).update(0);
                }
            }
        }
    }
}
