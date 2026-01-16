package ir.eitaa.ui.ActionBar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.transition.TransitionValues;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Adapters.FiltersView;
import ir.eitaa.ui.Components.CubicBezierInterpolator;
import ir.eitaa.ui.Components.EllipsizeSpanAnimator;
import ir.eitaa.ui.Components.FireworksEffect;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.SnowflakesEffect;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class ActionBar extends FrameLayout {
    private int actionBarColor;
    public ActionBarMenuOnItemClick actionBarMenuOnItemClick;
    private ActionBarMenu actionMode;
    private AnimatorSet actionModeAnimation;
    private int actionModeColor;
    private View actionModeExtraView;
    private View[] actionModeHidingViews;
    private View actionModeShowingView;
    private String actionModeTag;
    private View actionModeTop;
    private View actionModeTranslationView;
    private boolean actionModeVisible;
    private boolean addToContainer;
    private SimpleTextView additionalSubtitleTextView;
    private boolean allowOverlayTitle;
    private ImageView backButtonImageView;
    private boolean castShadows;
    private boolean centerScale;
    private boolean clipContent;
    EllipsizeSpanAnimator ellipsizeSpanAnimator;
    private int extraHeight;
    private FireworksEffect fireworksEffect;
    private Paint.FontMetricsInt fontMetricsInt;
    private boolean fromBottom;
    private boolean ignoreLayoutRequest;
    private View.OnTouchListener interceptTouchEventListener;
    private boolean interceptTouches;
    public boolean isProfile;
    protected boolean isSearchFieldVisible;
    protected int itemsActionModeBackgroundColor;
    protected int itemsActionModeColor;
    protected int itemsBackgroundColor;
    protected int itemsColor;
    private CharSequence lastOverlayTitle;
    private Runnable lastRunnable;
    private CharSequence lastTitle;
    private boolean manualStart;
    private ActionBarMenu menu;
    private boolean occupyStatusBar;
    private boolean overlayTitleAnimation;
    boolean overlayTitleAnimationInProgress;
    private Object[] overlayTitleToSet;
    protected BaseFragment parentFragment;
    private Rect rect;
    private final Theme.ResourcesProvider resourcesProvider;
    AnimatorSet searchVisibleAnimator;
    private SnowflakesEffect snowflakesEffect;
    private CharSequence subtitle;
    private SimpleTextView subtitleTextView;
    private boolean supportsHolidayImage;
    private Runnable titleActionRunnable;
    private boolean titleAnimationRunning;
    private int titleColorToSet;
    private boolean titleOverlayShown;
    private int titleRightMargin;
    private SimpleTextView[] titleTextView;

    public static class ActionBarMenuOnItemClick {
        public boolean canOpenMenu() {
            return true;
        }

        public void onItemClick(int id) {
            throw null;
        }
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    public ActionBar(Context context) {
        this(context, null);
    }

    public ActionBar(Context context, Theme.ResourcesProvider resourcesProvider) {
        super(context);
        this.isProfile = false;
        this.titleTextView = new SimpleTextView[2];
        this.occupyStatusBar = Build.VERSION.SDK_INT >= 21;
        this.addToContainer = true;
        this.interceptTouches = true;
        this.overlayTitleToSet = new Object[3];
        this.castShadows = true;
        this.titleColorToSet = 0;
        this.ellipsizeSpanAnimator = new EllipsizeSpanAnimator(this);
        this.resourcesProvider = resourcesProvider;
        setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.ActionBar.-$$Lambda$ActionBar$_sNmBhmLqWJeqHRQLmXQSBEwnHs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$0$ActionBar(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$ActionBar(View view) {
        Runnable runnable;
        if (isSearchFieldVisible() || (runnable = this.titleActionRunnable) == null) {
            return;
        }
        runnable.run();
    }

    public void createBackButtonImage() {
        if (this.backButtonImageView != null) {
            if (this.isProfile) {
                setBackgroundColor(0);
                this.isProfile = false;
                return;
            }
            return;
        }
        ImageView imageView = new ImageView(getContext());
        this.backButtonImageView = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        this.backButtonImageView.setBackgroundDrawable(Theme.createSelectorDrawable(this.itemsBackgroundColor));
        if (this.itemsColor != 0) {
            this.backButtonImageView.setColorFilter(new PorterDuffColorFilter(this.itemsColor, PorterDuff.Mode.MULTIPLY));
        }
        this.backButtonImageView.setPadding(AndroidUtilities.dp(1.0f), 0, 0, 0);
        addView(this.backButtonImageView, LayoutHelper.createFrame(54, 54, 51));
        if (this.isProfile) {
            setBackgroundColor(0);
            this.isProfile = false;
        }
        this.backButtonImageView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.ActionBar.-$$Lambda$ActionBar$O4cEqA5cvXW0on3Qte7ZHQZzUQM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createBackButtonImage$1$ActionBar(view);
            }
        });
        this.backButtonImageView.setContentDescription(LocaleController.getString("AccDescrGoBack", R.string.AccDescrGoBack));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createBackButtonImage$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createBackButtonImage$1$ActionBar(View view) {
        if (!this.actionModeVisible && this.isSearchFieldVisible) {
            closeSearchField();
            return;
        }
        ActionBarMenuOnItemClick actionBarMenuOnItemClick = this.actionBarMenuOnItemClick;
        if (actionBarMenuOnItemClick != null) {
            actionBarMenuOnItemClick.onItemClick(-1);
        }
    }

    public void setBackButtonDrawable(Drawable drawable) {
        if (this.backButtonImageView == null) {
            createBackButtonImage();
        }
        this.backButtonImageView.setVisibility(drawable == null ? 8 : 0);
        this.backButtonImageView.setImageDrawable(drawable);
        if (drawable instanceof BackDrawable) {
            BackDrawable backDrawable = (BackDrawable) drawable;
            backDrawable.setRotation(isActionModeShowed() ? 1.0f : 0.0f, false);
            backDrawable.setRotatedColor(this.itemsActionModeColor);
            backDrawable.setColor(this.itemsColor);
            return;
        }
        if (drawable instanceof MenuDrawable) {
            MenuDrawable menuDrawable = (MenuDrawable) drawable;
            menuDrawable.setBackColor(this.actionBarColor);
            menuDrawable.setIconColor(this.itemsColor);
        }
    }

    public void setBackButtonContentDescription(CharSequence description) {
        ImageView imageView = this.backButtonImageView;
        if (imageView != null) {
            imageView.setContentDescription(description);
        }
    }

    public void setSupportsHolidayImage(boolean value) {
        this.supportsHolidayImage = value;
        if (value) {
            this.fontMetricsInt = new Paint.FontMetricsInt();
            this.rect = new Rect();
        }
        invalidate();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Drawable currentHolidayDrawable;
        if (this.supportsHolidayImage && !this.titleOverlayShown && !LocaleController.isRTL && ev.getAction() == 0 && (currentHolidayDrawable = Theme.getCurrentHolidayDrawable()) != null && currentHolidayDrawable.getBounds().contains((int) ev.getX(), (int) ev.getY())) {
            this.manualStart = true;
            if (this.snowflakesEffect == null) {
                this.fireworksEffect = null;
                this.snowflakesEffect = new SnowflakesEffect();
                this.titleTextView[0].invalidate();
                invalidate();
            } else {
                this.snowflakesEffect = null;
                this.fireworksEffect = new FireworksEffect();
                this.titleTextView[0].invalidate();
                invalidate();
            }
        }
        View.OnTouchListener onTouchListener = this.interceptTouchEventListener;
        return (onTouchListener != null && onTouchListener.onTouch(this, ev)) || super.onInterceptTouchEvent(ev);
    }

    protected boolean shouldClipChild(View child) {
        if (this.clipContent) {
            SimpleTextView[] simpleTextViewArr = this.titleTextView;
            if (child == simpleTextViewArr[0] || child == simpleTextViewArr[1] || child == this.subtitleTextView || child == this.menu || child == this.backButtonImageView || child == this.additionalSubtitleTextView) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        Drawable currentHolidayDrawable;
        boolean zShouldClipChild = shouldClipChild(child);
        if (zShouldClipChild) {
            canvas.save();
            canvas.clipRect(0.0f, (-getTranslationY()) + (this.occupyStatusBar ? AndroidUtilities.statusBarHeight : 0), getMeasuredWidth(), getMeasuredHeight());
        }
        boolean zDrawChild = super.drawChild(canvas, child, drawingTime);
        if (this.supportsHolidayImage && !this.titleOverlayShown && !LocaleController.isRTL) {
            SimpleTextView[] simpleTextViewArr = this.titleTextView;
            if ((child == simpleTextViewArr[0] || child == simpleTextViewArr[1]) && (currentHolidayDrawable = Theme.getCurrentHolidayDrawable()) != null) {
                SimpleTextView simpleTextView = (SimpleTextView) child;
                if (simpleTextView.getVisibility() == 0 && (simpleTextView.getText() instanceof String)) {
                    TextPaint textPaint = simpleTextView.getTextPaint();
                    textPaint.getFontMetricsInt(this.fontMetricsInt);
                    textPaint.getTextBounds((String) simpleTextView.getText(), 0, 1, this.rect);
                    int textStartX = simpleTextView.getTextStartX() + Theme.getCurrentHolidayDrawableXOffset() + ((this.rect.width() - (currentHolidayDrawable.getIntrinsicWidth() + Theme.getCurrentHolidayDrawableXOffset())) / 2);
                    int textStartY = simpleTextView.getTextStartY() + Theme.getCurrentHolidayDrawableYOffset() + ((int) Math.ceil((simpleTextView.getTextHeight() - this.rect.height()) / 2.0f));
                    currentHolidayDrawable.setBounds(textStartX, textStartY - currentHolidayDrawable.getIntrinsicHeight(), currentHolidayDrawable.getIntrinsicWidth() + textStartX, textStartY);
                    currentHolidayDrawable.setAlpha((int) (simpleTextView.getAlpha() * 255.0f));
                    currentHolidayDrawable.draw(canvas);
                    if (this.overlayTitleAnimationInProgress) {
                        child.invalidate();
                        invalidate();
                    }
                }
                if (Theme.canStartHolidayAnimation()) {
                    if (this.snowflakesEffect == null) {
                        this.snowflakesEffect = new SnowflakesEffect();
                    }
                } else if (!this.manualStart && this.snowflakesEffect != null) {
                    this.snowflakesEffect = null;
                }
                SnowflakesEffect snowflakesEffect = this.snowflakesEffect;
                if (snowflakesEffect != null) {
                    snowflakesEffect.onDraw(this, canvas);
                } else {
                    FireworksEffect fireworksEffect = this.fireworksEffect;
                    if (fireworksEffect != null) {
                        fireworksEffect.onDraw(this, canvas);
                    }
                }
            }
        }
        if (zShouldClipChild) {
            canvas.restore();
        }
        return zDrawChild;
    }

    @Override // android.view.View
    public void setTranslationY(float translationY) {
        super.setTranslationY(translationY);
        if (this.clipContent) {
            invalidate();
        }
    }

    public void setBackButtonImage(int resource) {
        if (this.backButtonImageView == null) {
            createBackButtonImage();
        }
        this.backButtonImageView.setVisibility(resource == 0 ? 8 : 0);
        this.backButtonImageView.setImageResource(resource);
    }

    private void createSubtitleTextView() {
        if (this.subtitleTextView != null) {
            return;
        }
        SimpleTextView simpleTextView = new SimpleTextView(getContext());
        this.subtitleTextView = simpleTextView;
        simpleTextView.setGravity(3);
        this.subtitleTextView.setVisibility(8);
        this.subtitleTextView.setTextColor(getThemedColor("actionBarDefaultSubtitle"));
        this.subtitleTextView.setTypeface(AndroidUtilities.getFontFamily(false));
        addView(this.subtitleTextView, 0, LayoutHelper.createFrame(-2, -2, 51));
    }

    public void createAdditionalSubtitleTextView() {
        if (this.additionalSubtitleTextView != null) {
            return;
        }
        SimpleTextView simpleTextView = new SimpleTextView(getContext());
        this.additionalSubtitleTextView = simpleTextView;
        simpleTextView.setGravity(3);
        this.additionalSubtitleTextView.setVisibility(8);
        this.additionalSubtitleTextView.setTextColor(getThemedColor("actionBarDefaultSubtitle"));
        this.additionalSubtitleTextView.setTypeface(AndroidUtilities.getFontFamily(false));
        addView(this.additionalSubtitleTextView, 0, LayoutHelper.createFrame(-2, -2, 51));
    }

    public SimpleTextView getAdditionalSubtitleTextView() {
        return this.additionalSubtitleTextView;
    }

    public void setAddToContainer(boolean value) {
        this.addToContainer = value;
    }

    public boolean shouldAddToContainer() {
        return this.addToContainer;
    }

    public void setClipContent(boolean value) {
        this.clipContent = value;
    }

    public void setSubtitle(CharSequence value) {
        if (value != null && this.subtitleTextView == null) {
            createSubtitleTextView();
        }
        if (this.subtitleTextView != null) {
            boolean zIsEmpty = TextUtils.isEmpty(value);
            this.subtitleTextView.setVisibility((zIsEmpty || this.isSearchFieldVisible) ? 8 : 0);
            this.subtitleTextView.setAlpha(1.0f);
            if (!zIsEmpty) {
                this.subtitleTextView.setText(value);
            }
            this.subtitle = value;
        }
    }

    private void createTitleTextView(int i) {
        SimpleTextView[] simpleTextViewArr = this.titleTextView;
        if (simpleTextViewArr[i] != null) {
            return;
        }
        simpleTextViewArr[i] = new SimpleTextView(getContext());
        this.titleTextView[i].setGravity(3);
        int i2 = this.titleColorToSet;
        if (i2 != 0) {
            this.titleTextView[i].setTextColor(i2);
        } else {
            this.titleTextView[i].setTextColor(getThemedColor("actionBarDefaultTitle"));
        }
        this.titleTextView[i].setTypeface(AndroidUtilities.getFontFamily(true));
        addView(this.titleTextView[i], 0, LayoutHelper.createFrame(-2, -2, 51));
    }

    public void setTitleRightMargin(int value) {
        this.titleRightMargin = value;
    }

    public void setTitle(CharSequence value) {
        if (value != null && this.titleTextView[0] == null) {
            createTitleTextView(0);
        }
        SimpleTextView[] simpleTextViewArr = this.titleTextView;
        if (simpleTextViewArr[0] != null) {
            this.lastTitle = value;
            simpleTextViewArr[0].setVisibility((value == null || this.isSearchFieldVisible) ? 4 : 0);
            this.titleTextView[0].setText(value);
        }
        this.fromBottom = false;
    }

    public void setTitleColor(int color) {
        if (this.titleTextView[0] == null) {
            createTitleTextView(0);
        }
        this.titleColorToSet = color;
        this.titleTextView[0].setTextColor(color);
        SimpleTextView[] simpleTextViewArr = this.titleTextView;
        if (simpleTextViewArr[1] != null) {
            simpleTextViewArr[1].setTextColor(color);
        }
    }

    public void setSubtitleColor(int color) {
        if (this.subtitleTextView == null) {
            createSubtitleTextView();
        }
        this.subtitleTextView.setTextColor(color);
    }

    public void setTitleScrollNonFitText(boolean b) {
        this.titleTextView[0].setScrollNonFitText(b);
    }

    public void setPopupItemsColor(int color, boolean icon, boolean forActionMode) {
        ActionBarMenu actionBarMenu;
        ActionBarMenu actionBarMenu2;
        if (forActionMode && (actionBarMenu2 = this.actionMode) != null) {
            actionBarMenu2.setPopupItemsColor(color, icon);
        } else {
            if (forActionMode || (actionBarMenu = this.menu) == null) {
                return;
            }
            actionBarMenu.setPopupItemsColor(color, icon);
        }
    }

    public void setPopupItemsSelectorColor(int color, boolean forActionMode) {
        ActionBarMenu actionBarMenu;
        ActionBarMenu actionBarMenu2;
        if (forActionMode && (actionBarMenu2 = this.actionMode) != null) {
            actionBarMenu2.setPopupItemsSelectorColor(color);
        } else {
            if (forActionMode || (actionBarMenu = this.menu) == null) {
                return;
            }
            actionBarMenu.setPopupItemsSelectorColor(color);
        }
    }

    public void setPopupBackgroundColor(int color, boolean forActionMode) {
        ActionBarMenu actionBarMenu;
        ActionBarMenu actionBarMenu2;
        if (forActionMode && (actionBarMenu2 = this.actionMode) != null) {
            actionBarMenu2.redrawPopup(color);
        } else {
            if (forActionMode || (actionBarMenu = this.menu) == null) {
                return;
            }
            actionBarMenu.redrawPopup(color);
        }
    }

    public SimpleTextView getSubtitleTextView() {
        return this.subtitleTextView;
    }

    public SimpleTextView getTitleTextView() {
        return this.titleTextView[0];
    }

    public String getTitle() {
        SimpleTextView[] simpleTextViewArr = this.titleTextView;
        if (simpleTextViewArr[0] == null) {
            return null;
        }
        return simpleTextViewArr[0].getText().toString();
    }

    public String getSubtitle() {
        CharSequence charSequence;
        if (this.subtitleTextView == null || (charSequence = this.subtitle) == null) {
            return null;
        }
        return charSequence.toString();
    }

    public ActionBarMenu createMenu() {
        ActionBarMenu actionBarMenu = this.menu;
        if (actionBarMenu != null) {
            return actionBarMenu;
        }
        ActionBarMenu actionBarMenu2 = new ActionBarMenu(getContext(), this);
        this.menu = actionBarMenu2;
        addView(actionBarMenu2, 0, LayoutHelper.createFrame(-2, -1, 5));
        return this.menu;
    }

    public void setActionBarMenuOnItemClick(ActionBarMenuOnItemClick listener) {
        this.actionBarMenuOnItemClick = listener;
    }

    public ActionBarMenuOnItemClick getActionBarMenuOnItemClick() {
        return this.actionBarMenuOnItemClick;
    }

    public ImageView getBackButton() {
        return this.backButtonImageView;
    }

    public ActionBarMenu createActionMode() {
        return createActionMode(true, null);
    }

    public boolean actionModeIsExist(String tag) {
        if (this.actionMode == null) {
            return false;
        }
        String str = this.actionModeTag;
        if (str == null && tag == null) {
            return true;
        }
        return str != null && str.equals(tag);
    }

    public ActionBarMenu createActionMode(boolean needTop, String tag) {
        if (actionModeIsExist(tag)) {
            return this.actionMode;
        }
        ActionBarMenu actionBarMenu = this.actionMode;
        if (actionBarMenu != null) {
            removeView(actionBarMenu);
            this.actionMode = null;
        }
        this.actionModeTag = tag;
        ActionBarMenu actionBarMenu2 = new ActionBarMenu(getContext(), this) { // from class: ir.eitaa.ui.ActionBar.ActionBar.1
            @Override // android.view.View
            public void setBackgroundColor(int color) {
                super.setBackgroundColor(ActionBar.this.actionModeColor = color);
            }
        };
        this.actionMode = actionBarMenu2;
        actionBarMenu2.isActionMode = true;
        actionBarMenu2.setClickable(true);
        this.actionMode.setBackgroundColor(getThemedColor("actionBarActionModeDefault"));
        addView(this.actionMode, indexOfChild(this.backButtonImageView));
        this.actionMode.setPadding(0, this.occupyStatusBar ? AndroidUtilities.statusBarHeight : 0, 0, 0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.actionMode.getLayoutParams();
        layoutParams.height = -1;
        layoutParams.width = -1;
        layoutParams.bottomMargin = this.extraHeight;
        layoutParams.gravity = 5;
        this.actionMode.setLayoutParams(layoutParams);
        this.actionMode.setVisibility(4);
        if (this.occupyStatusBar && needTop && this.actionModeTop == null) {
            View view = new View(getContext());
            this.actionModeTop = view;
            view.setBackgroundColor(getThemedColor("actionBarActionModeDefaultTop"));
            addView(this.actionModeTop);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.actionModeTop.getLayoutParams();
            layoutParams2.height = AndroidUtilities.statusBarHeight;
            layoutParams2.width = -1;
            layoutParams2.gravity = 51;
            this.actionModeTop.setLayoutParams(layoutParams2);
            this.actionModeTop.setVisibility(4);
        }
        return this.actionMode;
    }

    public void showActionMode() {
        showActionMode(true, null, null, null, null, null, 0);
    }

    public void showActionMode(boolean animated, View extraView, View showingView, View[] hidingViews, final boolean[] hideView, View translationView, int translation) {
        View view;
        View view2;
        View view3;
        ActionBarMenu actionBarMenu = this.actionMode;
        if (actionBarMenu == null || this.actionModeVisible) {
            return;
        }
        this.actionModeVisible = true;
        if (animated) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this.actionMode, (Property<ActionBarMenu, Float>) View.ALPHA, 0.0f, 1.0f));
            if (hidingViews != null) {
                for (int i = 0; i < hidingViews.length; i++) {
                    if (hidingViews[i] != null) {
                        arrayList.add(ObjectAnimator.ofFloat(hidingViews[i], (Property<View, Float>) View.ALPHA, 1.0f, 0.0f));
                    }
                }
            }
            if (showingView != null) {
                arrayList.add(ObjectAnimator.ofFloat(showingView, (Property<View, Float>) View.ALPHA, 0.0f, 1.0f));
            }
            if (translationView != null) {
                arrayList.add(ObjectAnimator.ofFloat(translationView, (Property<View, Float>) View.TRANSLATION_Y, translation));
                this.actionModeTranslationView = translationView;
            }
            this.actionModeExtraView = extraView;
            this.actionModeShowingView = showingView;
            this.actionModeHidingViews = hidingViews;
            if (this.occupyStatusBar && (view3 = this.actionModeTop) != null && !SharedConfig.noStatusBar) {
                arrayList.add(ObjectAnimator.ofFloat(view3, (Property<View, Float>) View.ALPHA, 0.0f, 1.0f));
            }
            if (SharedConfig.noStatusBar) {
                if (AndroidUtilities.computePerceivedBrightness(this.actionModeColor) < 0.721f) {
                    AndroidUtilities.setLightStatusBar(((Activity) getContext()).getWindow(), false);
                } else {
                    AndroidUtilities.setLightStatusBar(((Activity) getContext()).getWindow(), true);
                }
            }
            AnimatorSet animatorSet = this.actionModeAnimation;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.actionModeAnimation = animatorSet2;
            animatorSet2.playTogether(arrayList);
            this.actionModeAnimation.setDuration(200L);
            this.actionModeAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.ActionBar.ActionBar.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                    ActionBar.this.actionMode.setVisibility(0);
                    if (!ActionBar.this.occupyStatusBar || ActionBar.this.actionModeTop == null || SharedConfig.noStatusBar) {
                        return;
                    }
                    ActionBar.this.actionModeTop.setVisibility(0);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    boolean[] zArr;
                    if (ActionBar.this.actionModeAnimation == null || !ActionBar.this.actionModeAnimation.equals(animation)) {
                        return;
                    }
                    ActionBar.this.actionModeAnimation = null;
                    if (ActionBar.this.titleTextView[0] != null) {
                        ActionBar.this.titleTextView[0].setVisibility(4);
                    }
                    if (ActionBar.this.subtitleTextView != null && !TextUtils.isEmpty(ActionBar.this.subtitle)) {
                        ActionBar.this.subtitleTextView.setVisibility(4);
                    }
                    if (ActionBar.this.menu != null) {
                        ActionBar.this.menu.setVisibility(4);
                    }
                    if (ActionBar.this.actionModeHidingViews != null) {
                        for (int i2 = 0; i2 < ActionBar.this.actionModeHidingViews.length; i2++) {
                            if (ActionBar.this.actionModeHidingViews[i2] != null && ((zArr = hideView) == null || i2 >= zArr.length || zArr[i2])) {
                                ActionBar.this.actionModeHidingViews[i2].setVisibility(4);
                            }
                        }
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                    if (ActionBar.this.actionModeAnimation == null || !ActionBar.this.actionModeAnimation.equals(animation)) {
                        return;
                    }
                    ActionBar.this.actionModeAnimation = null;
                }
            });
            this.actionModeAnimation.start();
            ImageView imageView = this.backButtonImageView;
            if (imageView != null) {
                Drawable drawable = imageView.getDrawable();
                if (drawable instanceof BackDrawable) {
                    ((BackDrawable) drawable).setRotation(1.0f, true);
                }
                this.backButtonImageView.setBackgroundDrawable(Theme.createSelectorDrawable(this.itemsActionModeBackgroundColor));
                return;
            }
            return;
        }
        actionBarMenu.setAlpha(1.0f);
        if (hidingViews != null) {
            for (int i2 = 0; i2 < hidingViews.length; i2++) {
                if (hidingViews[i2] != null) {
                    hidingViews[i2].setAlpha(0.0f);
                }
            }
        }
        if (showingView != null) {
            showingView.setAlpha(1.0f);
        }
        if (translationView != null) {
            translationView.setTranslationY(translation);
            this.actionModeTranslationView = translationView;
        }
        this.actionModeExtraView = extraView;
        this.actionModeShowingView = showingView;
        this.actionModeHidingViews = hidingViews;
        if (this.occupyStatusBar && (view2 = this.actionModeTop) != null && !SharedConfig.noStatusBar) {
            view2.setAlpha(1.0f);
        }
        if (SharedConfig.noStatusBar) {
            if (AndroidUtilities.computePerceivedBrightness(this.actionModeColor) < 0.721f) {
                AndroidUtilities.setLightStatusBar(((Activity) getContext()).getWindow(), false);
            } else {
                AndroidUtilities.setLightStatusBar(((Activity) getContext()).getWindow(), true);
            }
        }
        this.actionMode.setVisibility(0);
        if (this.occupyStatusBar && (view = this.actionModeTop) != null && !SharedConfig.noStatusBar) {
            view.setVisibility(0);
        }
        SimpleTextView[] simpleTextViewArr = this.titleTextView;
        if (simpleTextViewArr[0] != null) {
            simpleTextViewArr[0].setVisibility(4);
        }
        if (this.subtitleTextView != null && !TextUtils.isEmpty(this.subtitle)) {
            this.subtitleTextView.setVisibility(4);
        }
        ActionBarMenu actionBarMenu2 = this.menu;
        if (actionBarMenu2 != null) {
            actionBarMenu2.setVisibility(4);
        }
        if (this.actionModeHidingViews != null) {
            int i3 = 0;
            while (true) {
                View[] viewArr = this.actionModeHidingViews;
                if (i3 >= viewArr.length) {
                    break;
                }
                if (viewArr[i3] != null && (hideView == null || i3 >= hideView.length || hideView[i3])) {
                    viewArr[i3].setVisibility(4);
                }
                i3++;
            }
        }
        ImageView imageView2 = this.backButtonImageView;
        if (imageView2 != null) {
            Drawable drawable2 = imageView2.getDrawable();
            if (drawable2 instanceof BackDrawable) {
                ((BackDrawable) drawable2).setRotation(1.0f, false);
            }
            this.backButtonImageView.setBackgroundDrawable(Theme.createSelectorDrawable(this.itemsActionModeBackgroundColor));
        }
    }

    public void hideActionMode() {
        View view;
        ActionBarMenu actionBarMenu = this.actionMode;
        if (actionBarMenu == null || !this.actionModeVisible) {
            return;
        }
        actionBarMenu.hideAllPopupMenus();
        this.actionModeVisible = false;
        ArrayList arrayList = new ArrayList();
        arrayList.add(ObjectAnimator.ofFloat(this.actionMode, (Property<ActionBarMenu, Float>) View.ALPHA, 0.0f));
        if (this.actionModeHidingViews != null) {
            int i = 0;
            while (true) {
                View[] viewArr = this.actionModeHidingViews;
                if (i >= viewArr.length) {
                    break;
                }
                if (viewArr[i] != null) {
                    viewArr[i].setVisibility(0);
                    arrayList.add(ObjectAnimator.ofFloat(this.actionModeHidingViews[i], (Property<View, Float>) View.ALPHA, 1.0f));
                }
                i++;
            }
        }
        View view2 = this.actionModeTranslationView;
        if (view2 != null) {
            arrayList.add(ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, 0.0f));
            this.actionModeTranslationView = null;
        }
        View view3 = this.actionModeShowingView;
        if (view3 != null) {
            arrayList.add(ObjectAnimator.ofFloat(view3, (Property<View, Float>) View.ALPHA, 0.0f));
        }
        if (this.occupyStatusBar && (view = this.actionModeTop) != null && !SharedConfig.noStatusBar) {
            arrayList.add(ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, 0.0f));
        }
        if (SharedConfig.noStatusBar) {
            if (AndroidUtilities.computePerceivedBrightness(this.actionBarColor) < 0.721f) {
                AndroidUtilities.setLightStatusBar(((Activity) getContext()).getWindow(), false);
            } else {
                AndroidUtilities.setLightStatusBar(((Activity) getContext()).getWindow(), true);
            }
        }
        AnimatorSet animatorSet = this.actionModeAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.actionModeAnimation = animatorSet2;
        animatorSet2.playTogether(arrayList);
        this.actionModeAnimation.setDuration(200L);
        this.actionModeAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.ActionBar.ActionBar.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                if (ActionBar.this.actionModeAnimation == null || !ActionBar.this.actionModeAnimation.equals(animation)) {
                    return;
                }
                ActionBar.this.actionModeAnimation = null;
                ActionBar.this.actionMode.setVisibility(4);
                if (ActionBar.this.occupyStatusBar && ActionBar.this.actionModeTop != null && !SharedConfig.noStatusBar) {
                    ActionBar.this.actionModeTop.setVisibility(4);
                }
                if (ActionBar.this.actionModeExtraView != null) {
                    ActionBar.this.actionModeExtraView.setVisibility(4);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                if (ActionBar.this.actionModeAnimation == null || !ActionBar.this.actionModeAnimation.equals(animation)) {
                    return;
                }
                ActionBar.this.actionModeAnimation = null;
            }
        });
        this.actionModeAnimation.start();
        if (!this.isSearchFieldVisible) {
            SimpleTextView[] simpleTextViewArr = this.titleTextView;
            if (simpleTextViewArr[0] != null) {
                simpleTextViewArr[0].setVisibility(0);
            }
            if (this.subtitleTextView != null && !TextUtils.isEmpty(this.subtitle)) {
                this.subtitleTextView.setVisibility(0);
            }
        }
        ActionBarMenu actionBarMenu2 = this.menu;
        if (actionBarMenu2 != null) {
            actionBarMenu2.setVisibility(0);
        }
        ImageView imageView = this.backButtonImageView;
        if (imageView != null) {
            Drawable drawable = imageView.getDrawable();
            if (drawable instanceof BackDrawable) {
                ((BackDrawable) drawable).setRotation(0.0f, true);
            }
            this.backButtonImageView.setBackgroundDrawable(Theme.createSelectorDrawable(this.itemsBackgroundColor));
        }
    }

    public void showActionModeTop() {
        if (this.occupyStatusBar && this.actionModeTop == null) {
            View view = new View(getContext());
            this.actionModeTop = view;
            view.setBackgroundColor(getThemedColor("actionBarActionModeDefaultTop"));
            addView(this.actionModeTop);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.actionModeTop.getLayoutParams();
            layoutParams.height = AndroidUtilities.statusBarHeight;
            layoutParams.width = -1;
            layoutParams.gravity = 51;
            this.actionModeTop.setLayoutParams(layoutParams);
        }
    }

    public void setActionModeTopColor(int color) {
        View view = this.actionModeTop;
        if (view != null) {
            view.setBackgroundColor(color);
        }
    }

    public void setSearchTextColor(int color, boolean placeholder) {
        ActionBarMenu actionBarMenu = this.menu;
        if (actionBarMenu != null) {
            actionBarMenu.setSearchTextColor(color, placeholder);
        }
    }

    public void setActionModeColor(int color) {
        ActionBarMenu actionBarMenu = this.actionMode;
        if (actionBarMenu != null) {
            actionBarMenu.setBackgroundColor(color);
        }
    }

    public void setActionModeOverrideColor(int color) {
        this.actionModeColor = color;
    }

    @Override // android.view.View
    public void setBackgroundColor(int color) {
        this.actionBarColor = color;
        super.setBackgroundColor(color);
        ImageView imageView = this.backButtonImageView;
        if (imageView != null) {
            Drawable drawable = imageView.getDrawable();
            if (drawable instanceof MenuDrawable) {
                ((MenuDrawable) drawable).setBackColor(color);
            }
        }
    }

    public boolean isActionModeShowed() {
        return this.actionMode != null && this.actionModeVisible;
    }

    public boolean isActionModeShowed(String tag) {
        String str;
        return this.actionMode != null && this.actionModeVisible && (((str = this.actionModeTag) == null && tag == null) || (str != null && str.equals(tag)));
    }

    public void onSearchFieldVisibilityChanged(final boolean visible) {
        this.isSearchFieldVisible = visible;
        AnimatorSet animatorSet = this.searchVisibleAnimator;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.searchVisibleAnimator = new AnimatorSet();
        final ArrayList arrayList = new ArrayList();
        SimpleTextView[] simpleTextViewArr = this.titleTextView;
        if (simpleTextViewArr[0] != null) {
            arrayList.add(simpleTextViewArr[0]);
        }
        if (this.subtitleTextView != null && !TextUtils.isEmpty(this.subtitle)) {
            arrayList.add(this.subtitleTextView);
            this.subtitleTextView.setVisibility(visible ? 4 : 0);
        }
        int i = 0;
        while (true) {
            float f = 1.0f;
            if (i >= arrayList.size()) {
                break;
            }
            View view = (View) arrayList.get(i);
            if (!visible) {
                view.setVisibility(0);
                view.setAlpha(0.0f);
                view.setScaleX(0.95f);
                view.setScaleY(0.95f);
            }
            AnimatorSet animatorSet2 = this.searchVisibleAnimator;
            Animator[] animatorArr = new Animator[1];
            Property property = View.ALPHA;
            float[] fArr = new float[1];
            fArr[0] = visible ? 0.0f : 1.0f;
            animatorArr[0] = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, fArr);
            animatorSet2.playTogether(animatorArr);
            AnimatorSet animatorSet3 = this.searchVisibleAnimator;
            Animator[] animatorArr2 = new Animator[1];
            Property property2 = View.SCALE_Y;
            float[] fArr2 = new float[1];
            fArr2[0] = visible ? 0.95f : 1.0f;
            animatorArr2[0] = ObjectAnimator.ofFloat(view, (Property<View, Float>) property2, fArr2);
            animatorSet3.playTogether(animatorArr2);
            AnimatorSet animatorSet4 = this.searchVisibleAnimator;
            Animator[] animatorArr3 = new Animator[1];
            Property property3 = View.SCALE_X;
            float[] fArr3 = new float[1];
            if (visible) {
                f = 0.95f;
            }
            fArr3[0] = f;
            animatorArr3[0] = ObjectAnimator.ofFloat(view, (Property<View, Float>) property3, fArr3);
            animatorSet4.playTogether(animatorArr3);
            i++;
        }
        this.centerScale = true;
        requestLayout();
        this.searchVisibleAnimator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.ActionBar.ActionBar.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    View view2 = (View) arrayList.get(i2);
                    if (visible) {
                        view2.setVisibility(4);
                        view2.setAlpha(0.0f);
                    } else {
                        view2.setAlpha(1.0f);
                    }
                }
                if (visible) {
                    if (ActionBar.this.titleTextView[0] != null) {
                        ActionBar.this.titleTextView[0].setVisibility(8);
                    }
                    if (ActionBar.this.titleTextView[1] != null) {
                        ActionBar.this.titleTextView[1].setVisibility(8);
                    }
                }
            }
        });
        this.searchVisibleAnimator.setDuration(150L).start();
        Drawable drawable = this.backButtonImageView.getDrawable();
        if (drawable instanceof MenuDrawable) {
            MenuDrawable menuDrawable = (MenuDrawable) drawable;
            menuDrawable.setRotateToBack(true);
            menuDrawable.setRotation(visible ? 1.0f : 0.0f, true);
        }
    }

    public void setInterceptTouches(boolean value) {
        this.interceptTouches = value;
    }

    public void setInterceptTouchEventListener(View.OnTouchListener listener) {
        this.interceptTouchEventListener = listener;
    }

    public void setExtraHeight(int value) {
        this.extraHeight = value;
        ActionBarMenu actionBarMenu = this.actionMode;
        if (actionBarMenu != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) actionBarMenu.getLayoutParams();
            layoutParams.bottomMargin = this.extraHeight;
            this.actionMode.setLayoutParams(layoutParams);
        }
    }

    public void closeSearchField() {
        closeSearchField(true);
    }

    public void closeSearchField(boolean closeKeyboard) {
        ActionBarMenu actionBarMenu;
        if (!this.isSearchFieldVisible || (actionBarMenu = this.menu) == null) {
            return;
        }
        actionBarMenu.closeSearchField(closeKeyboard);
    }

    public void openSearchField(String text, boolean animated) {
        ActionBarMenu actionBarMenu = this.menu;
        if (actionBarMenu == null || text == null) {
            return;
        }
        actionBarMenu.openSearchField(!this.isSearchFieldVisible, text, animated);
    }

    public void setSearchFilter(FiltersView.MediaFilterData filter) {
        ActionBarMenu actionBarMenu = this.menu;
        if (actionBarMenu != null) {
            actionBarMenu.setFilter(filter);
        }
    }

    public void setSearchFieldText(String text) {
        this.menu.setSearchFieldText(text);
    }

    public void onSearchPressed() {
        this.menu.onSearchPressed();
    }

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        ImageView imageView = this.backButtonImageView;
        if (imageView != null) {
            imageView.setEnabled(enabled);
        }
        ActionBarMenu actionBarMenu = this.menu;
        if (actionBarMenu != null) {
            actionBarMenu.setEnabled(enabled);
        }
        ActionBarMenu actionBarMenu2 = this.actionMode;
        if (actionBarMenu2 != null) {
            actionBarMenu2.setEnabled(enabled);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.ignoreLayoutRequest) {
            return;
        }
        super.requestLayout();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int iDp;
        SimpleTextView simpleTextView;
        SimpleTextView simpleTextView2;
        int iMakeMeasureSpec;
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        View.MeasureSpec.getSize(heightMeasureSpec);
        int currentActionBarHeight = getCurrentActionBarHeight();
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(currentActionBarHeight, 1073741824);
        this.ignoreLayoutRequest = true;
        View view = this.actionModeTop;
        if (view != null) {
            ((FrameLayout.LayoutParams) view.getLayoutParams()).height = AndroidUtilities.statusBarHeight;
        }
        ActionBarMenu actionBarMenu = this.actionMode;
        if (actionBarMenu != null) {
            actionBarMenu.setPadding(0, this.occupyStatusBar ? AndroidUtilities.statusBarHeight : 0, 0, 0);
        }
        this.ignoreLayoutRequest = false;
        setMeasuredDimension(size, currentActionBarHeight + (this.occupyStatusBar ? AndroidUtilities.statusBarHeight : 0) + this.extraHeight);
        ImageView imageView = this.backButtonImageView;
        if (imageView != null && imageView.getVisibility() != 8) {
            this.backButtonImageView.measure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(54.0f), 1073741824), iMakeMeasureSpec2);
            iDp = AndroidUtilities.dp(AndroidUtilities.isTablet() ? 80.0f : 72.0f);
        } else {
            iDp = AndroidUtilities.dp(AndroidUtilities.isTablet() ? 26.0f : 18.0f);
        }
        ActionBarMenu actionBarMenu2 = this.menu;
        if (actionBarMenu2 != null && actionBarMenu2.getVisibility() != 8) {
            if (this.menu.searchFieldVisible() && !this.isSearchFieldVisible) {
                this.menu.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), iMakeMeasureSpec2);
                int itemsMeasuredWidth = this.menu.getItemsMeasuredWidth();
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec((size - AndroidUtilities.dp(AndroidUtilities.isTablet() ? 74.0f : 66.0f)) + this.menu.getItemsMeasuredWidth(), 1073741824);
                this.menu.translateXItems(-itemsMeasuredWidth);
            } else if (this.isSearchFieldVisible) {
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size - AndroidUtilities.dp(AndroidUtilities.isTablet() ? 74.0f : 66.0f), 1073741824);
                this.menu.translateXItems(0);
            } else {
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
                this.menu.translateXItems(0);
            }
            this.menu.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        }
        for (int i = 0; i < 2; i++) {
            SimpleTextView[] simpleTextViewArr = this.titleTextView;
            if ((simpleTextViewArr[0] != null && simpleTextViewArr[0].getVisibility() != 8) || ((simpleTextView = this.subtitleTextView) != null && simpleTextView.getVisibility() != 8)) {
                ActionBarMenu actionBarMenu3 = this.menu;
                int measuredWidth = (((size - (actionBarMenu3 != null ? actionBarMenu3.getMeasuredWidth() : 0)) - AndroidUtilities.dp(16.0f)) - iDp) - this.titleRightMargin;
                boolean z = this.fromBottom;
                if (((z && i == 0) || (!z && i == 1)) && this.overlayTitleAnimation && this.titleAnimationRunning) {
                    this.titleTextView[i].setTextSize((AndroidUtilities.isTablet() || getResources().getConfiguration().orientation != 2) ? 20 : 18);
                } else {
                    SimpleTextView[] simpleTextViewArr2 = this.titleTextView;
                    if (simpleTextViewArr2[0] != null && simpleTextViewArr2[0].getVisibility() != 8 && (simpleTextView2 = this.subtitleTextView) != null && simpleTextView2.getVisibility() != 8) {
                        SimpleTextView[] simpleTextViewArr3 = this.titleTextView;
                        if (simpleTextViewArr3[i] != null) {
                            simpleTextViewArr3[i].setTextSize(AndroidUtilities.isTablet() ? 20 : 18);
                        }
                        this.subtitleTextView.setTextSize(AndroidUtilities.isTablet() ? 16 : 14);
                        SimpleTextView simpleTextView3 = this.additionalSubtitleTextView;
                        if (simpleTextView3 != null) {
                            simpleTextView3.setTextSize(AndroidUtilities.isTablet() ? 16 : 14);
                        }
                    } else {
                        SimpleTextView[] simpleTextViewArr4 = this.titleTextView;
                        if (simpleTextViewArr4[i] != null && simpleTextViewArr4[i].getVisibility() != 8) {
                            this.titleTextView[i].setTextSize((AndroidUtilities.isTablet() || getResources().getConfiguration().orientation != 2) ? 20 : 18);
                        }
                        SimpleTextView simpleTextView4 = this.subtitleTextView;
                        if (simpleTextView4 != null && simpleTextView4.getVisibility() != 8) {
                            this.subtitleTextView.setTextSize((AndroidUtilities.isTablet() || getResources().getConfiguration().orientation != 2) ? 16 : 14);
                        }
                        SimpleTextView simpleTextView5 = this.additionalSubtitleTextView;
                        if (simpleTextView5 != null) {
                            simpleTextView5.setTextSize((AndroidUtilities.isTablet() || getResources().getConfiguration().orientation != 2) ? 16 : 14);
                        }
                    }
                }
                SimpleTextView[] simpleTextViewArr5 = this.titleTextView;
                if (simpleTextViewArr5[i] != null && simpleTextViewArr5[i].getVisibility() != 8) {
                    this.titleTextView[i].measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(24.0f), Integer.MIN_VALUE));
                    if (this.centerScale) {
                        CharSequence text = this.titleTextView[i].getText();
                        SimpleTextView[] simpleTextViewArr6 = this.titleTextView;
                        simpleTextViewArr6[i].setPivotX(simpleTextViewArr6[i].getTextPaint().measureText(text, 0, text.length()) / 2.0f);
                        this.titleTextView[i].setPivotY(AndroidUtilities.dp(24.0f) >> 1);
                    } else {
                        this.titleTextView[i].setPivotX(0.0f);
                        this.titleTextView[i].setPivotY(0.0f);
                    }
                }
                SimpleTextView simpleTextView6 = this.subtitleTextView;
                if (simpleTextView6 != null && simpleTextView6.getVisibility() != 8) {
                    this.subtitleTextView.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(20.0f), Integer.MIN_VALUE));
                }
                SimpleTextView simpleTextView7 = this.additionalSubtitleTextView;
                if (simpleTextView7 != null && simpleTextView7.getVisibility() != 8) {
                    this.additionalSubtitleTextView.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(20.0f), Integer.MIN_VALUE));
                }
            }
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                SimpleTextView[] simpleTextViewArr7 = this.titleTextView;
                if (childAt != simpleTextViewArr7[0] && childAt != simpleTextViewArr7[1] && childAt != this.subtitleTextView && childAt != this.menu && childAt != this.backButtonImageView && childAt != this.additionalSubtitleTextView) {
                    measureChildWithMargins(childAt, widthMeasureSpec, 0, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824), 0);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x020e  */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onLayout(boolean r15, int r16, int r17, int r18, int r19) {
        /*
            Method dump skipped, instructions count: 546
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ActionBar.ActionBar.onLayout(boolean, int, int, int, int):void");
    }

    public void onMenuButtonPressed() {
        ActionBarMenu actionBarMenu;
        if (isActionModeShowed() || (actionBarMenu = this.menu) == null) {
            return;
        }
        actionBarMenu.onMenuButtonPressed();
    }

    protected void onPause() {
        ActionBarMenu actionBarMenu = this.menu;
        if (actionBarMenu != null) {
            actionBarMenu.hideAllPopupMenus();
        }
    }

    public void setAllowOverlayTitle(boolean value) {
        this.allowOverlayTitle = value;
    }

    public void setTitleActionRunnable(Runnable action) {
        this.titleActionRunnable = action;
        this.lastRunnable = action;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0125  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setTitleOverlayText(java.lang.String r5, int r6, java.lang.Runnable r7) {
        /*
            Method dump skipped, instructions count: 346
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ActionBar.ActionBar.setTitleOverlayText(java.lang.String, int, java.lang.Runnable):void");
    }

    public boolean isSearchFieldVisible() {
        return this.isSearchFieldVisible;
    }

    public void setOccupyStatusBar(boolean value) {
        this.occupyStatusBar = value;
        ActionBarMenu actionBarMenu = this.actionMode;
        if (actionBarMenu != null) {
            actionBarMenu.setPadding(0, value ? AndroidUtilities.statusBarHeight : 0, 0, 0);
        }
    }

    public boolean getOccupyStatusBar() {
        return this.occupyStatusBar;
    }

    public void setItemsBackgroundColor(int color, boolean isActionMode) {
        ImageView imageView;
        if (isActionMode) {
            this.itemsActionModeBackgroundColor = color;
            if (this.actionModeVisible && (imageView = this.backButtonImageView) != null) {
                imageView.setBackgroundDrawable(Theme.createSelectorDrawable(color));
            }
            ActionBarMenu actionBarMenu = this.actionMode;
            if (actionBarMenu != null) {
                actionBarMenu.updateItemsBackgroundColor();
                return;
            }
            return;
        }
        this.itemsBackgroundColor = color;
        ImageView imageView2 = this.backButtonImageView;
        if (imageView2 != null) {
            imageView2.setBackgroundDrawable(Theme.createSelectorDrawable(color));
        }
        ActionBarMenu actionBarMenu2 = this.menu;
        if (actionBarMenu2 != null) {
            actionBarMenu2.updateItemsBackgroundColor();
        }
    }

    public void setItemsColor(int color, boolean isActionMode) {
        if (isActionMode) {
            this.itemsActionModeColor = color;
            ActionBarMenu actionBarMenu = this.actionMode;
            if (actionBarMenu != null) {
                actionBarMenu.updateItemsColor();
            }
            ImageView imageView = this.backButtonImageView;
            if (imageView != null) {
                Drawable drawable = imageView.getDrawable();
                if (drawable instanceof BackDrawable) {
                    ((BackDrawable) drawable).setRotatedColor(color);
                    return;
                }
                return;
            }
            return;
        }
        this.itemsColor = color;
        ImageView imageView2 = this.backButtonImageView;
        if (imageView2 != null && color != 0) {
            imageView2.setColorFilter(new PorterDuffColorFilter(this.itemsColor, PorterDuff.Mode.MULTIPLY));
            Drawable drawable2 = this.backButtonImageView.getDrawable();
            if (drawable2 instanceof BackDrawable) {
                ((BackDrawable) drawable2).setColor(color);
            } else if (drawable2 instanceof MenuDrawable) {
                ((MenuDrawable) drawable2).setIconColor(color);
            }
        }
        ActionBarMenu actionBarMenu2 = this.menu;
        if (actionBarMenu2 != null) {
            actionBarMenu2.updateItemsColor();
        }
    }

    public void setCastShadows(boolean value) {
        this.castShadows = value;
    }

    public boolean getCastShadows() {
        return this.castShadows;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event) || this.interceptTouches;
    }

    public static int getCurrentActionBarHeight() {
        if (AndroidUtilities.isTablet()) {
            return AndroidUtilities.dp(64.0f);
        }
        Point point = AndroidUtilities.displaySize;
        if (point.x > point.y) {
            return AndroidUtilities.dp(48.0f);
        }
        return AndroidUtilities.dp(56.0f);
    }

    public void setTitleAnimated(CharSequence title, final boolean fromBottom, long duration) {
        if (this.titleTextView[0] == null || title == null) {
            setTitle(title);
            return;
        }
        final boolean z = this.overlayTitleAnimation && !TextUtils.isEmpty(this.subtitle);
        if (z) {
            if (this.subtitleTextView.getVisibility() != 0) {
                this.subtitleTextView.setVisibility(0);
                this.subtitleTextView.setAlpha(0.0f);
            }
            this.subtitleTextView.animate().alpha(fromBottom ? 0.0f : 1.0f).setDuration(220L).start();
        }
        SimpleTextView[] simpleTextViewArr = this.titleTextView;
        if (simpleTextViewArr[1] != null) {
            if (simpleTextViewArr[1].getParent() != null) {
                ((ViewGroup) this.titleTextView[1].getParent()).removeView(this.titleTextView[1]);
            }
            this.titleTextView[1] = null;
        }
        SimpleTextView[] simpleTextViewArr2 = this.titleTextView;
        simpleTextViewArr2[1] = simpleTextViewArr2[0];
        simpleTextViewArr2[0] = null;
        setTitle(title);
        this.fromBottom = fromBottom;
        this.titleTextView[0].setAlpha(0.0f);
        if (!z) {
            SimpleTextView simpleTextView = this.titleTextView[0];
            int iDp = AndroidUtilities.dp(20.0f);
            if (!fromBottom) {
                iDp = -iDp;
            }
            simpleTextView.setTranslationY(iDp);
        }
        this.titleTextView[0].animate().alpha(1.0f).translationY(0.0f).setDuration(duration).start();
        this.titleAnimationRunning = true;
        ViewPropertyAnimator viewPropertyAnimatorAlpha = this.titleTextView[1].animate().alpha(0.0f);
        if (!z) {
            int iDp2 = AndroidUtilities.dp(20.0f);
            if (fromBottom) {
                iDp2 = -iDp2;
            }
            viewPropertyAnimatorAlpha.translationY(iDp2);
        }
        viewPropertyAnimatorAlpha.setDuration(duration).setListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.ActionBar.ActionBar.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                if (ActionBar.this.titleTextView[1] != null && ActionBar.this.titleTextView[1].getParent() != null) {
                    ((ViewGroup) ActionBar.this.titleTextView[1].getParent()).removeView(ActionBar.this.titleTextView[1]);
                }
                ActionBar.this.titleTextView[1] = null;
                ActionBar.this.titleAnimationRunning = false;
                if (z && fromBottom) {
                    ActionBar.this.subtitleTextView.setVisibility(8);
                }
                ActionBar.this.requestLayout();
            }
        }).start();
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.ellipsizeSpanAnimator.onAttachedToWindow();
        if (SharedConfig.noStatusBar && this.actionModeVisible) {
            if (AndroidUtilities.computePerceivedBrightness(this.actionModeColor) < 0.721f) {
                AndroidUtilities.setLightStatusBar(((Activity) getContext()).getWindow(), false);
            } else {
                AndroidUtilities.setLightStatusBar(((Activity) getContext()).getWindow(), true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.ellipsizeSpanAnimator.onDetachedFromWindow();
        if (SharedConfig.noStatusBar && this.actionModeVisible) {
            if (AndroidUtilities.computePerceivedBrightness(this.actionBarColor) < 0.721f) {
                AndroidUtilities.setLightStatusBar(((Activity) getContext()).getWindow(), false);
            } else {
                AndroidUtilities.setLightStatusBar(((Activity) getContext()).getWindow(), true);
            }
        }
    }

    public ActionBarMenu getActionMode() {
        return this.actionMode;
    }

    public void setOverlayTitleAnimation(boolean ovelayTitleAnimation) {
        this.overlayTitleAnimation = ovelayTitleAnimation;
    }

    public void beginDelayedTransition() {
        if (Build.VERSION.SDK_INT >= 19) {
            TransitionSet transitionSet = new TransitionSet();
            transitionSet.setOrdering(0);
            transitionSet.addTransition(new Fade());
            transitionSet.addTransition(new ChangeBounds() { // from class: ir.eitaa.ui.ActionBar.ActionBar.7
                @Override // android.transition.ChangeBounds, android.transition.Transition
                public void captureStartValues(TransitionValues transitionValues) {
                    super.captureStartValues(transitionValues);
                    View view = transitionValues.view;
                    if (view instanceof SimpleTextView) {
                        transitionValues.values.put("text_size", Float.valueOf(((SimpleTextView) view).getTextPaint().getTextSize()));
                    }
                }

                @Override // android.transition.ChangeBounds, android.transition.Transition
                public void captureEndValues(TransitionValues transitionValues) {
                    super.captureEndValues(transitionValues);
                    View view = transitionValues.view;
                    if (view instanceof SimpleTextView) {
                        transitionValues.values.put("text_size", Float.valueOf(((SimpleTextView) view).getTextPaint().getTextSize()));
                    }
                }

                @Override // android.transition.ChangeBounds, android.transition.Transition
                public Animator createAnimator(ViewGroup sceneRoot, final TransitionValues startValues, TransitionValues endValues) {
                    if (startValues != null && (startValues.view instanceof SimpleTextView)) {
                        AnimatorSet animatorSet = new AnimatorSet();
                        if (endValues != null) {
                            Animator animatorCreateAnimator = super.createAnimator(sceneRoot, startValues, endValues);
                            float fFloatValue = ((Float) startValues.values.get("text_size")).floatValue() / ((Float) endValues.values.get("text_size")).floatValue();
                            startValues.view.setScaleX(fFloatValue);
                            startValues.view.setScaleY(fFloatValue);
                            if (animatorCreateAnimator != null) {
                                animatorSet.playTogether(animatorCreateAnimator);
                            }
                        }
                        animatorSet.playTogether(ObjectAnimator.ofFloat(startValues.view, (Property<View, Float>) View.SCALE_X, 1.0f));
                        animatorSet.playTogether(ObjectAnimator.ofFloat(startValues.view, (Property<View, Float>) View.SCALE_Y, 1.0f));
                        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.ActionBar.ActionBar.7.1
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animation) {
                                super.onAnimationStart(animation);
                                startValues.view.setLayerType(2, null);
                            }

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animation) {
                                super.onAnimationEnd(animation);
                                startValues.view.setLayerType(0, null);
                            }
                        });
                        return animatorSet;
                    }
                    return super.createAnimator(sceneRoot, startValues, endValues);
                }
            });
            this.centerScale = false;
            transitionSet.setDuration(220L);
            transitionSet.setInterpolator((TimeInterpolator) CubicBezierInterpolator.DEFAULT);
            TransitionManager.beginDelayedTransition(this, transitionSet);
        }
    }

    private int getThemedColor(String key) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
        if (color == null) {
            BaseFragment baseFragment = this.parentFragment;
            color = baseFragment != null ? Integer.valueOf(baseFragment.getThemedColor(key)) : null;
        }
        return color != null ? color.intValue() : Theme.getColor(key);
    }
}
