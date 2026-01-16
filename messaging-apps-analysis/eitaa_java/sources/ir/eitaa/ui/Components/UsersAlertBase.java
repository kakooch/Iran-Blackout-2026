package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Property;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.R;
import ir.eitaa.ui.ActionBar.AdjustPanLayoutHelper;
import ir.eitaa.ui.ActionBar.BottomSheet;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Cells.GraySectionCell;
import ir.eitaa.ui.Cells.GroupCallTextCell;
import ir.eitaa.ui.Cells.GroupCallUserCell;
import ir.eitaa.ui.Components.AnimationProperties;
import ir.eitaa.ui.Components.RecyclerListView;

/* loaded from: classes3.dex */
public class UsersAlertBase extends BottomSheet {
    public static final Property<UsersAlertBase, Float> COLOR_PROGRESS = new AnimationProperties.FloatProperty<UsersAlertBase>("colorProgress") { // from class: ir.eitaa.ui.Components.UsersAlertBase.3
        @Override // ir.eitaa.ui.Components.AnimationProperties.FloatProperty
        public void setValue(UsersAlertBase object, float value) {
            object.setColorProgress(value);
        }

        @Override // android.util.Property
        public Float get(UsersAlertBase object) {
            return Float.valueOf(object.getColorProgress());
        }
    };
    private int backgroundColor;
    private float colorProgress;
    protected StickerEmptyView emptyView;
    protected FlickerLoadingView flickerLoadingView;
    protected FrameLayout frameLayout;
    protected String keyActionBarUnscrolled;
    protected String keyInviteMembersBackground;
    protected String keyLastSeenText;
    protected String keyLastSeenTextUnscrolled;
    protected String keyListSelector;
    protected String keyListViewBackground;
    protected String keyNameText;
    protected String keyScrollUp;
    protected String keySearchBackground;
    protected String keySearchIcon;
    protected String keySearchIconUnscrolled;
    protected String keySearchPlaceholder;
    protected String keySearchText;
    protected final FillLastLinearLayoutManager layoutManager;
    protected RecyclerListView listView;
    protected RecyclerListView.SelectionAdapter listViewAdapter;
    protected boolean needSnapToTop;
    private RectF rect;
    protected int scrollOffsetY;
    protected RecyclerListView.SelectionAdapter searchListViewAdapter;
    protected SearchField searchView;
    protected View shadow;
    protected AnimatorSet shadowAnimation;
    protected Drawable shadowDrawable;

    @Override // ir.eitaa.ui.ActionBar.BottomSheet
    protected boolean canDismissWithSwipe() {
        return false;
    }

    protected void onSearchViewTouched(MotionEvent ev, EditTextBoldCursor searchEditText) {
    }

    protected void search(String text) {
    }

    protected void updateColorKeys() {
    }

    public UsersAlertBase(Context context, boolean needFocus, int account, Theme.ResourcesProvider resourcesProvider) {
        super(context, needFocus, resourcesProvider);
        this.rect = new RectF();
        this.needSnapToTop = true;
        this.keyScrollUp = "key_sheet_scrollUp";
        this.keyListSelector = "listSelectorSDK21";
        this.keySearchBackground = "dialogSearchBackground";
        this.keyInviteMembersBackground = "windowBackgroundWhite";
        this.keyListViewBackground = "windowBackgroundWhite";
        this.keyActionBarUnscrolled = "windowBackgroundWhite";
        this.keyNameText = "windowBackgroundWhiteBlackText";
        this.keyLastSeenText = "windowBackgroundWhiteGrayText";
        this.keyLastSeenTextUnscrolled = "windowBackgroundWhiteGrayText";
        this.keySearchPlaceholder = "dialogSearchHint";
        this.keySearchText = "dialogSearchText";
        this.keySearchIcon = "dialogSearchIcon";
        this.keySearchIconUnscrolled = "dialogSearchIcon";
        updateColorKeys();
        setDimBehindAlpha(75);
        this.currentAccount = account;
        this.shadowDrawable = context.getResources().getDrawable(R.drawable.sheet_shadow_round).mutate();
        ContainerView containerViewCreateContainerView = createContainerView(context);
        this.containerView = containerViewCreateContainerView;
        containerViewCreateContainerView.setWillNotDraw(false);
        this.containerView.setClipChildren(false);
        ViewGroup viewGroup = this.containerView;
        int i = this.backgroundPaddingLeft;
        viewGroup.setPadding(i, 0, i, 0);
        this.frameLayout = new FrameLayout(context);
        SearchField searchField = new SearchField(context);
        this.searchView = searchField;
        this.frameLayout.addView(searchField, LayoutHelper.createFrame(-1, -1, 51));
        FlickerLoadingView flickerLoadingView = new FlickerLoadingView(context);
        this.flickerLoadingView = flickerLoadingView;
        flickerLoadingView.setViewType(6);
        this.flickerLoadingView.showDate(false);
        this.flickerLoadingView.setUseHeaderOffset(true);
        this.flickerLoadingView.setColors(this.keyInviteMembersBackground, this.keySearchBackground, this.keyActionBarUnscrolled);
        StickerEmptyView stickerEmptyView = new StickerEmptyView(context, this.flickerLoadingView, 1);
        this.emptyView = stickerEmptyView;
        stickerEmptyView.addView(this.flickerLoadingView, 0, LayoutHelper.createFrame(-1, -1.0f, 0, 0.0f, 2.0f, 0.0f, 0.0f));
        this.emptyView.title.setText(LocaleController.getString("NoResult", R.string.NoResult));
        this.emptyView.setVisibility(8);
        this.emptyView.setAnimateLayoutChange(true);
        this.emptyView.showProgress(true, false);
        this.emptyView.setColors(this.keyNameText, this.keyLastSeenText, this.keyInviteMembersBackground, this.keySearchBackground);
        this.containerView.addView(this.emptyView, LayoutHelper.createFrame(-1, -1.0f, 51, 0.0f, 62.0f, 0.0f, 0.0f));
        RecyclerListView recyclerListView = new RecyclerListView(context) { // from class: ir.eitaa.ui.Components.UsersAlertBase.1
            @Override // ir.eitaa.ui.Components.RecyclerListView
            protected boolean allowSelectChildAtPosition(float x, float y) {
                return y >= ((float) (AndroidUtilities.dp(58.0f) + (Build.VERSION.SDK_INT >= 21 ? AndroidUtilities.statusBarHeight : 0)));
            }

            @Override // ir.eitaa.ui.Components.RecyclerListView, android.view.View
            public void setTranslationY(float translationY) {
                super.setTranslationY(translationY);
                getLocationInWindow(new int[2]);
            }

            @Override // ir.eitaa.ui.Components.RecyclerListView
            protected boolean emptyViewIsVisible() {
                return getAdapter() != null && getAdapter().getItemCount() <= 2;
            }
        };
        this.listView = recyclerListView;
        recyclerListView.setTag(13);
        this.listView.setPadding(0, 0, 0, AndroidUtilities.dp(48.0f));
        this.listView.setClipToPadding(false);
        this.listView.setHideIfEmpty(false);
        this.listView.setSelectorDrawableColor(Theme.getColor(this.keyListSelector));
        FillLastLinearLayoutManager fillLastLinearLayoutManager = new FillLastLinearLayoutManager(getContext(), 1, false, AndroidUtilities.dp(8.0f), this.listView);
        this.layoutManager = fillLastLinearLayoutManager;
        fillLastLinearLayoutManager.setBind(false);
        this.listView.setLayoutManager(fillLastLinearLayoutManager);
        this.listView.setHorizontalScrollBarEnabled(false);
        this.listView.setVerticalScrollBarEnabled(false);
        this.containerView.addView(this.listView, LayoutHelper.createFrame(-1, -1.0f, 51, 0.0f, 0.0f, 0.0f, 0.0f));
        this.listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.eitaa.ui.Components.UsersAlertBase.2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                UsersAlertBase.this.updateLayout();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                RecyclerListView.Holder holder;
                if (newState == 0) {
                    UsersAlertBase usersAlertBase = UsersAlertBase.this;
                    if (!usersAlertBase.needSnapToTop || usersAlertBase.scrollOffsetY + ((BottomSheet) usersAlertBase).backgroundPaddingTop + AndroidUtilities.dp(13.0f) >= AndroidUtilities.statusBarHeight * 2 || !UsersAlertBase.this.listView.canScrollVertically(1) || (holder = (RecyclerListView.Holder) UsersAlertBase.this.listView.findViewHolderForAdapterPosition(0)) == null || holder.itemView.getTop() <= 0) {
                        return;
                    }
                    UsersAlertBase.this.listView.smoothScrollBy(0, holder.itemView.getTop());
                }
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, AndroidUtilities.getShadowHeight(), 51);
        layoutParams.topMargin = AndroidUtilities.dp(58.0f);
        View view = new View(context);
        this.shadow = view;
        view.setBackgroundColor(Theme.getColor("dialogShadowLine"));
        this.shadow.setAlpha(0.0f);
        this.shadow.setTag(1);
        this.containerView.addView(this.shadow, layoutParams);
        this.containerView.addView(this.frameLayout, LayoutHelper.createFrame(-1, 58, 51));
        setColorProgress(0.0f);
        this.listView.setEmptyView(this.emptyView);
        this.listView.setAnimateEmptyView(true, 0);
    }

    protected ContainerView createContainerView(Context context) {
        return new ContainerView(context);
    }

    protected class SearchField extends FrameLayout {
        private final ImageView clearSearchImageView;
        private final CloseProgressDrawable2 progressDrawable;
        private final View searchBackground;
        protected EditTextBoldCursor searchEditText;
        private final ImageView searchIconImageView;

        public SearchField(Context context) {
            super(context);
            View view = new View(context);
            this.searchBackground = view;
            view.setBackgroundDrawable(Theme.createRoundRectDrawable(AndroidUtilities.dp(18.0f), Theme.getColor(UsersAlertBase.this.keySearchBackground)));
            addView(view, LayoutHelper.createFrame(-1, 36.0f, 51, 14.0f, 11.0f, 14.0f, 0.0f));
            ImageView imageView = new ImageView(context);
            this.searchIconImageView = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            imageView.setImageResource(R.drawable.smiles_inputsearch);
            imageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor(UsersAlertBase.this.keySearchPlaceholder), PorterDuff.Mode.MULTIPLY));
            addView(imageView, LayoutHelper.createFrame(36, 36.0f, 51, 16.0f, 11.0f, 0.0f, 0.0f));
            ImageView imageView2 = new ImageView(context);
            this.clearSearchImageView = imageView2;
            imageView2.setScaleType(ImageView.ScaleType.CENTER);
            CloseProgressDrawable2 closeProgressDrawable2 = new CloseProgressDrawable2();
            this.progressDrawable = closeProgressDrawable2;
            imageView2.setImageDrawable(closeProgressDrawable2);
            closeProgressDrawable2.setSide(AndroidUtilities.dp(7.0f));
            imageView2.setScaleX(0.1f);
            imageView2.setScaleY(0.1f);
            imageView2.setAlpha(0.0f);
            imageView2.setColorFilter(new PorterDuffColorFilter(Theme.getColor(UsersAlertBase.this.keySearchPlaceholder), PorterDuff.Mode.MULTIPLY));
            addView(imageView2, LayoutHelper.createFrame(36, 36.0f, 53, 14.0f, 11.0f, 14.0f, 0.0f));
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$UsersAlertBase$SearchField$L0jAaCgmyADqBPSh7HiWOEXxoQo
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$new$0$UsersAlertBase$SearchField(view2);
                }
            });
            EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(context) { // from class: ir.eitaa.ui.Components.UsersAlertBase.SearchField.1
                @Override // android.view.View
                public boolean dispatchTouchEvent(MotionEvent event) {
                    MotionEvent motionEventObtain = MotionEvent.obtain(event);
                    motionEventObtain.setLocation(motionEventObtain.getRawX(), motionEventObtain.getRawY() - ((BottomSheet) UsersAlertBase.this).containerView.getTranslationY());
                    if (motionEventObtain.getAction() == 1) {
                        motionEventObtain.setAction(3);
                    }
                    UsersAlertBase.this.listView.dispatchTouchEvent(motionEventObtain);
                    motionEventObtain.recycle();
                    return super.dispatchTouchEvent(event);
                }
            };
            this.searchEditText = editTextBoldCursor;
            editTextBoldCursor.setTextSize(1, 16.0f);
            this.searchEditText.setHintTextColor(Theme.getColor(UsersAlertBase.this.keySearchPlaceholder));
            this.searchEditText.setTextColor(Theme.getColor(UsersAlertBase.this.keySearchText));
            this.searchEditText.setBackgroundDrawable(null);
            this.searchEditText.setPadding(0, 0, 0, 0);
            this.searchEditText.setMaxLines(1);
            this.searchEditText.setLines(1);
            this.searchEditText.setSingleLine(true);
            this.searchEditText.setImeOptions(268435459);
            this.searchEditText.setHint(LocaleController.getString("VoipGroupSearchMembers", R.string.VoipGroupSearchMembers));
            this.searchEditText.setCursorColor(Theme.getColor(UsersAlertBase.this.keySearchText));
            this.searchEditText.setCursorSize(AndroidUtilities.dp(20.0f));
            this.searchEditText.setCursorWidth(1.5f);
            addView(this.searchEditText, LayoutHelper.createFrame(-1, 40.0f, 51, 54.0f, 9.0f, 46.0f, 0.0f));
            this.searchEditText.addTextChangedListener(new TextWatcher() { // from class: ir.eitaa.ui.Components.UsersAlertBase.SearchField.2
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable s) {
                    RecyclerListView recyclerListView;
                    boolean z = SearchField.this.searchEditText.length() > 0;
                    if (z != (SearchField.this.clearSearchImageView.getAlpha() != 0.0f)) {
                        SearchField.this.clearSearchImageView.animate().alpha(z ? 1.0f : 0.0f).setDuration(150L).scaleX(z ? 1.0f : 0.1f).scaleY(z ? 1.0f : 0.1f).start();
                    }
                    String string = SearchField.this.searchEditText.getText().toString();
                    int itemCount = UsersAlertBase.this.listView.getAdapter() == null ? 0 : UsersAlertBase.this.listView.getAdapter().getItemCount();
                    UsersAlertBase.this.search(string);
                    if (TextUtils.isEmpty(string) && (recyclerListView = UsersAlertBase.this.listView) != null) {
                        RecyclerView.Adapter adapter = recyclerListView.getAdapter();
                        UsersAlertBase usersAlertBase = UsersAlertBase.this;
                        if (adapter != usersAlertBase.listViewAdapter) {
                            usersAlertBase.listView.setAnimateEmptyView(false, 0);
                            UsersAlertBase usersAlertBase2 = UsersAlertBase.this;
                            usersAlertBase2.listView.setAdapter(usersAlertBase2.listViewAdapter);
                            UsersAlertBase.this.listView.setAnimateEmptyView(true, 0);
                            if (itemCount == 0) {
                                UsersAlertBase.this.showItemsAnimated(0);
                            }
                        }
                    }
                    UsersAlertBase.this.flickerLoadingView.setVisibility(0);
                }
            });
            this.searchEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$UsersAlertBase$SearchField$OXFRmURwypVg3Y5j8PYZHO5UpsY
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    return this.f$0.lambda$new$1$UsersAlertBase$SearchField(textView, i, keyEvent);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$0$UsersAlertBase$SearchField(View view) {
            this.searchEditText.setText("");
            AndroidUtilities.showKeyboard(this.searchEditText);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ boolean lambda$new$1$UsersAlertBase$SearchField(TextView textView, int i, KeyEvent keyEvent) {
            if (keyEvent == null) {
                return false;
            }
            if ((keyEvent.getAction() != 1 || keyEvent.getKeyCode() != 84) && (keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 66)) {
                return false;
            }
            AndroidUtilities.hideKeyboard(this.searchEditText);
            return false;
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent ev) {
            UsersAlertBase.this.onSearchViewTouched(ev, this.searchEditText);
            return super.onInterceptTouchEvent(ev);
        }

        public void closeSearch() {
            this.clearSearchImageView.callOnClick();
            AndroidUtilities.hideKeyboard(this.searchEditText);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getColorProgress() {
        return this.colorProgress;
    }

    protected void setColorProgress(float progress) {
        this.colorProgress = progress;
        this.backgroundColor = AndroidUtilities.getOffsetColor(Theme.getColor(this.keyInviteMembersBackground), Theme.getColor(this.keyListViewBackground), progress, 1.0f);
        this.shadowDrawable.setColorFilter(new PorterDuffColorFilter(this.backgroundColor, PorterDuff.Mode.MULTIPLY));
        this.frameLayout.setBackgroundColor(this.backgroundColor);
        int i = this.backgroundColor;
        this.navBarColor = i;
        this.listView.setGlowColor(i);
        int offsetColor = AndroidUtilities.getOffsetColor(Theme.getColor(this.keyLastSeenTextUnscrolled), Theme.getColor(this.keyLastSeenText), progress, 1.0f);
        int offsetColor2 = AndroidUtilities.getOffsetColor(Theme.getColor(this.keySearchIconUnscrolled), Theme.getColor(this.keySearchIcon), progress, 1.0f);
        int childCount = this.listView.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.listView.getChildAt(i2);
            if (childAt instanceof GroupCallTextCell) {
                ((GroupCallTextCell) childAt).setColors(offsetColor, offsetColor);
            } else if (childAt instanceof GroupCallUserCell) {
                ((GroupCallUserCell) childAt).setGrayIconColor(this.shadow.getTag() != null ? this.keySearchIcon : this.keySearchIconUnscrolled, offsetColor2);
            }
        }
        this.containerView.invalidate();
        this.listView.invalidate();
        this.container.invalidate();
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        AndroidUtilities.hideKeyboard(this.searchView.searchEditText);
        super.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public void updateLayout() {
        if (this.listView.getChildCount() <= 0) {
            return;
        }
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = this.listView.findViewHolderForAdapterPosition(0);
        int top = viewHolderFindViewHolderForAdapterPosition != null ? viewHolderFindViewHolderForAdapterPosition.itemView.getTop() - AndroidUtilities.dp(8.0f) : 0;
        int i = (top <= 0 || viewHolderFindViewHolderForAdapterPosition == null || viewHolderFindViewHolderForAdapterPosition.getAdapterPosition() != 0) ? 0 : top;
        if (top >= 0 && viewHolderFindViewHolderForAdapterPosition != null && viewHolderFindViewHolderForAdapterPosition.getAdapterPosition() == 0) {
            runShadowAnimation(false);
        } else {
            runShadowAnimation(true);
            top = i;
        }
        if (this.scrollOffsetY != top) {
            RecyclerListView recyclerListView = this.listView;
            this.scrollOffsetY = top;
            recyclerListView.setTopGlowOffset(top);
            this.frameLayout.setTranslationY(this.scrollOffsetY);
            this.emptyView.setTranslationY(this.scrollOffsetY);
            this.containerView.invalidate();
        }
    }

    private void runShadowAnimation(final boolean show) {
        if ((!show || this.shadow.getTag() == null) && (show || this.shadow.getTag() != null)) {
            return;
        }
        this.shadow.setTag(show ? null : 1);
        if (show) {
            this.shadow.setVisibility(0);
        }
        AnimatorSet animatorSet = this.shadowAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.shadowAnimation = animatorSet2;
        Animator[] animatorArr = new Animator[1];
        View view = this.shadow;
        Property property = View.ALPHA;
        float[] fArr = new float[1];
        fArr[0] = show ? 1.0f : 0.0f;
        animatorArr[0] = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, fArr);
        animatorSet2.playTogether(animatorArr);
        this.shadowAnimation.setDuration(150L);
        this.shadowAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.UsersAlertBase.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                AnimatorSet animatorSet3 = UsersAlertBase.this.shadowAnimation;
                if (animatorSet3 == null || !animatorSet3.equals(animation)) {
                    return;
                }
                if (!show) {
                    UsersAlertBase.this.shadow.setVisibility(4);
                }
                UsersAlertBase.this.shadowAnimation = null;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                AnimatorSet animatorSet3 = UsersAlertBase.this.shadowAnimation;
                if (animatorSet3 == null || !animatorSet3.equals(animation)) {
                    return;
                }
                UsersAlertBase.this.shadowAnimation = null;
            }
        });
        this.shadowAnimation.start();
    }

    protected void showItemsAnimated(final int from) {
        if (isShowing()) {
            this.listView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: ir.eitaa.ui.Components.UsersAlertBase.5
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    UsersAlertBase.this.listView.getViewTreeObserver().removeOnPreDrawListener(this);
                    int childCount = UsersAlertBase.this.listView.getChildCount();
                    AnimatorSet animatorSet = new AnimatorSet();
                    for (int i = 0; i < childCount; i++) {
                        View childAt = UsersAlertBase.this.listView.getChildAt(i);
                        int childAdapterPosition = UsersAlertBase.this.listView.getChildAdapterPosition(childAt);
                        if (childAdapterPosition >= from) {
                            if (childAdapterPosition == 1 && UsersAlertBase.this.listView.getAdapter() == UsersAlertBase.this.searchListViewAdapter && (childAt instanceof GraySectionCell)) {
                                childAt = ((GraySectionCell) childAt).getTextView();
                            }
                            childAt.setAlpha(0.0f);
                            int iMin = (int) ((Math.min(UsersAlertBase.this.listView.getMeasuredHeight(), Math.max(0, childAt.getTop())) / UsersAlertBase.this.listView.getMeasuredHeight()) * 100.0f);
                            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(childAt, (Property<View, Float>) View.ALPHA, 0.0f, 1.0f);
                            objectAnimatorOfFloat.setStartDelay(iMin);
                            objectAnimatorOfFloat.setDuration(200L);
                            animatorSet.playTogether(objectAnimatorOfFloat);
                        }
                    }
                    animatorSet.start();
                    return true;
                }
            });
        }
    }

    protected class ContainerView extends FrameLayout {
        private boolean ignoreLayout;
        float snapToTopOffset;
        ValueAnimator valueAnimator;

        public ContainerView(Context context) {
            super(context);
            this.ignoreLayout = false;
        }

        @Override // android.view.View
        public void setTranslationY(float translationY) {
            super.setTranslationY(translationY);
            invalidate();
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            int iDp;
            int size = View.MeasureSpec.getSize(heightMeasureSpec);
            if (Build.VERSION.SDK_INT >= 21) {
                this.ignoreLayout = true;
                setPadding(((BottomSheet) UsersAlertBase.this).backgroundPaddingLeft, AndroidUtilities.statusBarHeight, ((BottomSheet) UsersAlertBase.this).backgroundPaddingLeft, 0);
                this.ignoreLayout = false;
            }
            int paddingTop = size - getPaddingTop();
            if (((BottomSheet) UsersAlertBase.this).keyboardVisible) {
                iDp = AndroidUtilities.dp(8.0f);
                UsersAlertBase.this.setAllowNestedScroll(false);
                int i = UsersAlertBase.this.scrollOffsetY;
                if (i != 0) {
                    float f = i;
                    this.snapToTopOffset = f;
                    setTranslationY(f);
                    ValueAnimator valueAnimator = this.valueAnimator;
                    if (valueAnimator != null) {
                        valueAnimator.removeAllListeners();
                        this.valueAnimator.cancel();
                    }
                    ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.snapToTopOffset, 0.0f);
                    this.valueAnimator = valueAnimatorOfFloat;
                    valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$UsersAlertBase$ContainerView$IsnopVb-X53kDKYHQycIVp4Ow74
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                            this.f$0.lambda$onMeasure$0$UsersAlertBase$ContainerView(valueAnimator2);
                        }
                    });
                    this.valueAnimator.setDuration(250L);
                    this.valueAnimator.setInterpolator(AdjustPanLayoutHelper.keyboardInterpolator);
                    this.valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.UsersAlertBase.ContainerView.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            ContainerView containerView = ContainerView.this;
                            containerView.snapToTopOffset = 0.0f;
                            containerView.setTranslationY(0.0f);
                            ContainerView.this.valueAnimator = null;
                        }
                    });
                    this.valueAnimator.start();
                } else if (this.valueAnimator != null) {
                    setTranslationY(this.snapToTopOffset);
                }
            } else {
                iDp = (paddingTop - ((paddingTop / 5) * 3)) + AndroidUtilities.dp(8.0f);
                UsersAlertBase.this.setAllowNestedScroll(true);
            }
            if (UsersAlertBase.this.listView.getPaddingTop() != iDp) {
                this.ignoreLayout = true;
                UsersAlertBase.this.listView.setPadding(0, iDp, 0, 0);
                this.ignoreLayout = false;
            }
            super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(size, 1073741824));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onMeasure$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onMeasure$0$UsersAlertBase$ContainerView(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.snapToTopOffset = fFloatValue;
            setTranslationY(fFloatValue);
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean changed, int l, int t, int r, int b) {
            super.onLayout(changed, l, t, r, b);
            UsersAlertBase.this.updateLayout();
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent ev) {
            if (ev.getAction() == 0) {
                float y = ev.getY();
                UsersAlertBase usersAlertBase = UsersAlertBase.this;
                if (y < usersAlertBase.scrollOffsetY) {
                    usersAlertBase.dismiss();
                    return true;
                }
            }
            return super.onInterceptTouchEvent(ev);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent e) {
            return !UsersAlertBase.this.isDismissed() && super.onTouchEvent(e);
        }

        @Override // android.view.View, android.view.ViewParent
        public void requestLayout() {
            if (this.ignoreLayout) {
                return;
            }
            super.requestLayout();
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x00c3  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x016a  */
        @Override // android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected void onDraw(android.graphics.Canvas r14) {
            /*
                Method dump skipped, instructions count: 466
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.UsersAlertBase.ContainerView.onDraw(android.graphics.Canvas):void");
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            canvas.save();
            canvas.clipRect(0, getPaddingTop(), getMeasuredWidth(), getMeasuredHeight());
            super.dispatchDraw(canvas);
            canvas.restore();
        }
    }
}
