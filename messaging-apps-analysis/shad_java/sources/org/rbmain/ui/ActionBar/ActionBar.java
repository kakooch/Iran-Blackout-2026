package org.rbmain.ui.ActionBar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidMessenger.model.GetBaseInfoOutput;
import androidMessenger.model.LogoAdditionObject;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.AppPreferences;
import ir.resaneh1.iptv.helper.FlavorHelper;
import ir.resaneh1.iptv.helper.GlideHelper;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.SharedConfig;
import org.rbmain.messenger.UserConfig;
import org.rbmain.ui.ActionBar.ActionBarLayout;
import org.rbmain.ui.Adapters.FiltersView;
import org.rbmain.ui.Components.EllipsizeSpanAnimator;
import org.rbmain.ui.Components.FireworksEffect;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.SizeNotifierFrameLayout;
import org.rbmain.ui.Components.SnowflakesEffect;

/* loaded from: classes4.dex */
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
    private Drawable backButtonDrawable;
    public ImageView backButtonImageView;
    private ActionBarLayout.BackButtonState backButtonState;
    public Paint blurScrimPaint;
    boolean blurredBackground;
    private boolean castShadows;
    public FrameLayout centerImageFrameLayout;
    public ImageView centerImageView;
    public TextView centerTitleTextView1;
    private boolean clipContent;
    SizeNotifierFrameLayout contentView;
    EllipsizeSpanAnimator ellipsizeSpanAnimator;
    private int extraHeight;
    private boolean fromBottom;
    private boolean ignoreLayoutRequest;
    private boolean interceptTouches;
    private boolean isMenuOffsetSuppressed;
    protected boolean isSearchFieldVisible;
    public boolean isSmallActionBar;
    protected int itemsActionModeBackgroundColor;
    protected int itemsActionModeColor;
    protected int itemsBackgroundColor;
    protected int itemsColor;
    private CharSequence lastOverlayTitle;
    private Runnable lastRunnable;
    private CharSequence lastTitle;
    public ImageView logoAdditionView;
    private ActionBarMenu menu;
    private boolean occupyStatusBar;
    private boolean overlayTitleAnimation;
    boolean overlayTitleAnimationInProgress;
    private Object[] overlayTitleToSet;
    protected BaseFragment parentFragment;
    Rect rectTmp;
    private boolean rtlLayout;
    private int rubikaLogoHeight;
    AnimatorSet searchVisibleAnimator;
    private int shadLogoHeight;
    private SnowflakesEffect snowflakesEffect;
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

        public void onItemClick(int i) {
            throw null;
        }
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    public ActionBar(Context context) {
        super(context);
        this.isSmallActionBar = false;
        this.rubikaLogoHeight = 24;
        this.shadLogoHeight = 48;
        this.titleTextView = new SimpleTextView[2];
        this.occupyStatusBar = false;
        this.addToContainer = true;
        this.interceptTouches = true;
        this.overlayTitleToSet = new Object[3];
        this.castShadows = true;
        this.titleColorToSet = 0;
        this.rtlLayout = true;
        this.backButtonState = ActionBarLayout.BackButtonState.BACK;
        this.ellipsizeSpanAnimator = new EllipsizeSpanAnimator(this);
        this.blurScrimPaint = new Paint();
        this.rectTmp = new Rect();
        setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.ActionBar.ActionBar$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view) {
        Runnable runnable;
        if (isSearchFieldVisible() || (runnable = this.titleActionRunnable) == null) {
            return;
        }
        runnable.run();
    }

    public void createCenterTitleTextView() {
        if (this.centerTitleTextView1 != null) {
            return;
        }
        TextView textView = new TextView(getContext());
        this.centerTitleTextView1 = textView;
        textView.setGravity(17);
        this.centerTitleTextView1.setTextSize((AndroidUtilities.isTablet() || getResources().getConfiguration().orientation != 2) ? 16.0f : 14.0f);
        this.centerTitleTextView1.setTextColor(Theme.getColor(Theme.key_actionBarDefaultTitle));
        this.centerTitleTextView1.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        addView(this.centerTitleTextView1, 0, LayoutHelper.createFrame(-2, -2, 17));
    }

    private void createBackButtonImage() {
        if (this.backButtonImageView != null) {
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
        if (this.isSmallActionBar) {
            addView(this.backButtonImageView, LayoutHelper.createFrame(48, 48, 53));
        } else {
            addView(this.backButtonImageView, LayoutHelper.createFrame(54, 54, 53));
        }
        this.backButtonImageView.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.ActionBar.ActionBar$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createBackButtonImage$1(view);
            }
        });
        this.backButtonImageView.setContentDescription(LocaleController.getString("AccDescrGoBack", R.string.AccDescrGoBack));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createBackButtonImage$1(View view) {
        if (!this.actionModeVisible && this.isSearchFieldVisible) {
            closeSearchField();
            return;
        }
        ActionBarMenuOnItemClick actionBarMenuOnItemClick = this.actionBarMenuOnItemClick;
        if (actionBarMenuOnItemClick != null) {
            actionBarMenuOnItemClick.onItemClick(-1);
        }
    }

    public Drawable getBackButtonDrawable() {
        return this.backButtonDrawable;
    }

    public void setBackButtonDrawable(Drawable drawable) {
        if (this.backButtonImageView == null) {
            createBackButtonImage();
        }
        this.backButtonImageView.setVisibility(drawable == null ? 8 : 0);
        ImageView imageView = this.backButtonImageView;
        this.backButtonDrawable = drawable;
        imageView.setImageDrawable(drawable);
        if (drawable instanceof BackDrawable) {
            BackDrawable backDrawable = (BackDrawable) drawable;
            backDrawable.setRtlLayout(this.rtlLayout);
            backDrawable.setRotation(isActionModeShowed() ? 1.0f : 0.0f, false);
            backDrawable.setRotatedColor(this.itemsActionModeColor);
            backDrawable.setColor(this.itemsColor);
        }
    }

    public void setBackButtonContentDescription(CharSequence charSequence) {
        ImageView imageView = this.backButtonImageView;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setSupportsHolidayImage(boolean z) {
        this.supportsHolidayImage = z;
        if (z) {
            new Paint.FontMetricsInt();
            new Rect();
        }
        invalidate();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        Drawable currentHolidayDrawable;
        if (this.supportsHolidayImage && !this.titleOverlayShown && !LocaleController.isRTL && motionEvent.getAction() == 0 && (currentHolidayDrawable = Theme.getCurrentHolidayDrawable()) != null && currentHolidayDrawable.getBounds().contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            if (this.snowflakesEffect == null) {
                this.snowflakesEffect = new SnowflakesEffect(0);
                this.titleTextView[0].invalidate();
                invalidate();
            } else {
                this.snowflakesEffect = null;
                new FireworksEffect();
                this.titleTextView[0].invalidate();
                invalidate();
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    @Override // android.view.View
    public void setTranslationY(float f) {
        super.setTranslationY(f);
        if (this.clipContent) {
            invalidate();
        }
    }

    public void setRtlLayout(boolean z) {
        this.rtlLayout = z;
    }

    public boolean isRtlLayout() {
        return LocaleController.isRTL && this.rtlLayout;
    }

    public void setBackButtonImage(int i) {
        if (i == R.drawable.ic_ab_back && isRtlLayout()) {
            i = R.drawable.ic_arrow_back_white;
        } else if ((i == R.drawable.ic_arrow_back_white || i == R.drawable.arrow_back_grey) && !isRtlLayout()) {
            i = R.drawable.ic_ab_back;
        }
        if (this.backButtonImageView == null) {
            createBackButtonImage();
        }
        this.backButtonImageView.setVisibility(i == 0 ? 8 : 0);
        this.backButtonImageView.setImageResource(i);
    }

    private void createSubtitleTextView() {
        if (this.subtitleTextView != null) {
            return;
        }
        SimpleTextView simpleTextView = new SimpleTextView(getContext());
        this.subtitleTextView = simpleTextView;
        simpleTextView.setGravity(isRtlLayout() ? 5 : 3);
        this.subtitleTextView.setVisibility(8);
        this.subtitleTextView.setTextColor(Theme.getColor(Theme.key_actionBarDefaultSubtitle));
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
        this.additionalSubtitleTextView.setTextColor(getThemedColor(Theme.key_actionBarDefaultSubtitle));
        addView(this.additionalSubtitleTextView, 0, LayoutHelper.createFrame(-2, -2, 51));
    }

    public SimpleTextView getAdditionalSubtitleTextView() {
        return this.additionalSubtitleTextView;
    }

    public void setAddToContainer(boolean z) {
        this.addToContainer = z;
    }

    public boolean shouldAddToContainer() {
        return this.addToContainer;
    }

    public void setClipContent(boolean z) {
        this.clipContent = z;
    }

    public void setSubtitle(CharSequence charSequence) {
        if (charSequence != null && this.subtitleTextView == null) {
            createSubtitleTextView();
        }
        SimpleTextView simpleTextView = this.subtitleTextView;
        if (simpleTextView != null) {
            simpleTextView.setVisibility((TextUtils.isEmpty(charSequence) || this.isSearchFieldVisible) ? 8 : 0);
            this.subtitleTextView.setAlpha(1.0f);
            this.subtitleTextView.setText(charSequence);
        }
    }

    private void createTitleTextView(int i) {
        SimpleTextView[] simpleTextViewArr = this.titleTextView;
        if (simpleTextViewArr[i] != null) {
            return;
        }
        simpleTextViewArr[i] = new SimpleTextView(getContext());
        this.titleTextView[i].setGravity(isRtlLayout() ? 5 : 3);
        int i2 = this.titleColorToSet;
        if (i2 != 0) {
            this.titleTextView[i].setTextColor(i2);
        } else {
            this.titleTextView[i].setTextColor(Theme.getColor(Theme.key_actionBarDefaultTitle));
        }
        this.titleTextView[i].setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        addView(this.titleTextView[i], 0, LayoutHelper.createFrame(-2, -2, (isRtlLayout() ? 5 : 3) | 48));
    }

    public void createCenterImageView() {
        if (this.centerImageFrameLayout != null) {
            return;
        }
        this.centerImageView = new ImageView(getContext());
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.centerImageFrameLayout = frameLayout;
        frameLayout.setVisibility(0);
        this.centerImageView.setImageResource(R.drawable.ic_home_logo);
        if (!FlavorHelper.isShad()) {
            this.centerImageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_actionBarDefaultIcon), PorterDuff.Mode.MULTIPLY));
        }
        this.centerImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.centerImageFrameLayout.addView(this.centerImageView, LayoutHelper.createFrame(-2, -1, 17));
        addView(this.centerImageFrameLayout, 0, LayoutHelper.createFrame(-1, FlavorHelper.isShad() ? this.shadLogoHeight : this.rubikaLogoHeight, 17, 0.0f, 0.0f, 0.0f, 0.0f));
        setLogoAddition();
    }

    private LogoAdditionObject getLogoAddition() {
        String string = getAppPreferences().getString(AppPreferences.Key.baseInfoObject, null);
        if (string == null || string.isEmpty()) {
            return null;
        }
        return ((GetBaseInfoOutput) ApplicationLoader.getGson().fromJson(string, GetBaseInfoOutput.class)).logo_addition;
    }

    private final AppPreferences getAppPreferences() {
        return AppPreferences.getInstance(UserConfig.selectedAccount);
    }

    public void setLogoAddition() {
        int i;
        int i2;
        int i3;
        LogoAdditionObject logoAddition = getLogoAddition();
        if (this.centerImageFrameLayout == null) {
            return;
        }
        if (this.logoAdditionView == null) {
            ImageView imageView = new ImageView(getContext());
            this.logoAdditionView = imageView;
            this.centerImageFrameLayout.addView(imageView, LayoutHelper.createFrame(-2, -2, 17));
        }
        if (logoAddition == null || logoAddition.width == 0.0f || logoAddition.height == 0.0f) {
            this.logoAdditionView.setVisibility(8);
            return;
        }
        float f = FlavorHelper.isShad() ? this.shadLogoHeight : this.rubikaLogoHeight * 1.0f;
        int i4 = 0;
        this.logoAdditionView.setVisibility(0);
        int i5 = (int) (logoAddition.width * f);
        int i6 = (int) (logoAddition.height * f);
        float f2 = logoAddition.Y;
        if (f2 > 0.0f) {
            i2 = (int) (f2 * f);
            i = 0;
        } else {
            i = (int) (-(f2 * f));
            i2 = 0;
        }
        float f3 = logoAddition.X;
        if (f3 > 0.0f) {
            i4 = (int) (f3 * f);
            i3 = 0;
        } else {
            i3 = (int) (-(f3 * f));
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.logoAdditionView.getLayoutParams();
        layoutParams.width = AndroidUtilities.dp(i5);
        layoutParams.height = AndroidUtilities.dp(i6);
        layoutParams.leftMargin = AndroidUtilities.dp(i4);
        layoutParams.rightMargin = AndroidUtilities.dp(i3);
        layoutParams.topMargin = AndroidUtilities.dp(i);
        layoutParams.bottomMargin = AndroidUtilities.dp(i2);
        layoutParams.gravity = 17;
        this.logoAdditionView.setLayoutParams(layoutParams);
        this.logoAdditionView.requestLayout();
        GlideHelper.loadWithoutPlaceHolder(getContext(), this.logoAdditionView, logoAddition.url);
    }

    public void setTitleRightMargin(int i) {
        this.titleRightMargin = i;
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null && this.titleTextView[0] == null) {
            createTitleTextView(0);
        }
        SimpleTextView[] simpleTextViewArr = this.titleTextView;
        if (simpleTextViewArr[0] != null) {
            this.lastTitle = charSequence;
            simpleTextViewArr[0].setVisibility((charSequence == null || this.isSearchFieldVisible) ? 4 : 0);
            this.titleTextView[0].setText(charSequence);
        }
        this.fromBottom = false;
    }

    public void setTitleColor(int i) {
        if (this.titleTextView[0] == null) {
            createTitleTextView(0);
        }
        this.titleColorToSet = i;
        this.titleTextView[0].setTextColor(i);
        SimpleTextView[] simpleTextViewArr = this.titleTextView;
        if (simpleTextViewArr[1] != null) {
            simpleTextViewArr[1].setTextColor(i);
        }
    }

    public void setSubtitleColor(int i) {
        if (this.subtitleTextView == null) {
            createSubtitleTextView();
        }
        this.subtitleTextView.setTextColor(i);
    }

    public void setTitleScrollNonFitText(boolean z) {
        this.titleTextView[0].setScrollNonFitText(z);
    }

    public void setPopupItemsColor(int i, boolean z, boolean z2) {
        ActionBarMenu actionBarMenu;
        ActionBarMenu actionBarMenu2;
        if (z2 && (actionBarMenu2 = this.actionMode) != null) {
            actionBarMenu2.setPopupItemsColor(i, z);
        } else {
            if (z2 || (actionBarMenu = this.menu) == null) {
                return;
            }
            actionBarMenu.setPopupItemsColor(i, z);
        }
    }

    public void setPopupItemsSelectorColor(int i, boolean z) {
        ActionBarMenu actionBarMenu;
        ActionBarMenu actionBarMenu2;
        if (z && (actionBarMenu2 = this.actionMode) != null) {
            actionBarMenu2.setPopupItemsSelectorColor(i);
        } else {
            if (z || (actionBarMenu = this.menu) == null) {
                return;
            }
            actionBarMenu.setPopupItemsSelectorColor(i);
        }
    }

    public void setPopupBackgroundColor(int i, boolean z) {
        ActionBarMenu actionBarMenu;
        ActionBarMenu actionBarMenu2;
        if (z && (actionBarMenu2 = this.actionMode) != null) {
            actionBarMenu2.redrawPopup(i);
        } else {
            if (z || (actionBarMenu = this.menu) == null) {
                return;
            }
            actionBarMenu.redrawPopup(i);
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
        SimpleTextView simpleTextView = this.subtitleTextView;
        if (simpleTextView == null) {
            return null;
        }
        return simpleTextView.getText().toString();
    }

    public ActionBarMenu createMenu() {
        ActionBarMenu actionBarMenu = this.menu;
        if (actionBarMenu != null) {
            return actionBarMenu;
        }
        ActionBarMenu actionBarMenu2 = new ActionBarMenu(getContext(), this);
        this.menu = actionBarMenu2;
        actionBarMenu2.setRtlLayout(this.rtlLayout);
        if (isRtlLayout()) {
            addView(this.menu, 0, LayoutHelper.createFrame(-2, this.isSmallActionBar ? 48 : 54, 3));
        } else {
            addView(this.menu, 0, LayoutHelper.createFrame(-2, this.isSmallActionBar ? 48 : 54, 5));
        }
        return this.menu;
    }

    public void setActionBarMenuOnItemClick(ActionBarMenuOnItemClick actionBarMenuOnItemClick) {
        this.actionBarMenuOnItemClick = actionBarMenuOnItemClick;
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

    public boolean actionModeIsExist(String str) {
        if (this.actionMode == null) {
            return false;
        }
        String str2 = this.actionModeTag;
        if (str2 == null && str == null) {
            return true;
        }
        return str2 != null && str2.equals(str);
    }

    public ActionBarMenu createActionMode(boolean z, String str) {
        if (actionModeIsExist(str)) {
            return this.actionMode;
        }
        ActionBarMenu actionBarMenu = this.actionMode;
        if (actionBarMenu != null) {
            removeView(actionBarMenu);
            this.actionMode = null;
        }
        this.actionModeTag = str;
        ActionBarMenu actionBarMenu2 = new ActionBarMenu(getContext(), this) { // from class: org.rbmain.ui.ActionBar.ActionBar.1
            @Override // android.view.View
            public void setBackgroundColor(int i) {
                ActionBar.this.actionModeColor = i;
                ActionBar actionBar = ActionBar.this;
                if (actionBar.blurredBackground) {
                    return;
                }
                super.setBackgroundColor(actionBar.actionModeColor);
            }

            @Override // android.view.ViewGroup, android.view.View
            protected void dispatchDraw(Canvas canvas) {
                ActionBar actionBar = ActionBar.this;
                if (actionBar.blurredBackground && this.drawBlur) {
                    actionBar.rectTmp.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
                    ActionBar actionBar2 = ActionBar.this;
                    actionBar2.blurScrimPaint.setColor(actionBar2.actionModeColor);
                    ActionBar actionBar3 = ActionBar.this;
                    actionBar3.contentView.drawBlurRect(canvas, 0.0f, actionBar3.rectTmp, actionBar3.blurScrimPaint, true);
                }
                super.dispatchDraw(canvas);
            }

            @Override // android.view.ViewGroup, android.view.View
            protected void onAttachedToWindow() {
                super.onAttachedToWindow();
                SizeNotifierFrameLayout sizeNotifierFrameLayout = ActionBar.this.contentView;
                if (sizeNotifierFrameLayout != null) {
                    sizeNotifierFrameLayout.blurBehindViews.add(this);
                }
            }

            @Override // android.view.ViewGroup, android.view.View
            protected void onDetachedFromWindow() {
                super.onDetachedFromWindow();
                SizeNotifierFrameLayout sizeNotifierFrameLayout = ActionBar.this.contentView;
                if (sizeNotifierFrameLayout != null) {
                    sizeNotifierFrameLayout.blurBehindViews.remove(this);
                }
            }
        };
        this.actionMode = actionBarMenu2;
        actionBarMenu2.setRtlLayout(this.rtlLayout);
        ActionBarMenu actionBarMenu3 = this.actionMode;
        actionBarMenu3.isActionMode = true;
        actionBarMenu3.setClickable(true);
        this.actionMode.setBackgroundColor(Theme.getColor(Theme.key_actionBarActionModeDefault));
        addView(this.actionMode, indexOfChild(this.backButtonImageView));
        this.actionMode.setPadding(0, this.occupyStatusBar ? AndroidUtilities.statusBarHeight : 0, 0, 0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.actionMode.getLayoutParams();
        layoutParams.height = -1;
        layoutParams.width = -1;
        layoutParams.bottomMargin = this.extraHeight;
        layoutParams.gravity = 5;
        this.actionMode.setLayoutParams(layoutParams);
        this.actionMode.setVisibility(4);
        if (this.occupyStatusBar && z && this.actionModeTop == null) {
            View view = new View(getContext());
            this.actionModeTop = view;
            view.setBackgroundColor(Theme.getColor(Theme.key_actionBarActionModeDefaultTop));
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

    public void showActionMode(boolean z, View view, View view2, View[] viewArr, final boolean[] zArr, View view3, int i) {
        View view4;
        View view5;
        View view6;
        ActionBarMenu actionBarMenu = this.actionMode;
        if (actionBarMenu == null || this.actionModeVisible) {
            return;
        }
        this.actionModeVisible = true;
        if (z) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this.actionMode, (Property<ActionBarMenu, Float>) View.ALPHA, 0.0f, 1.0f));
            if (viewArr != null) {
                for (int i2 = 0; i2 < viewArr.length; i2++) {
                    if (viewArr[i2] != null) {
                        arrayList.add(ObjectAnimator.ofFloat(viewArr[i2], (Property<View, Float>) View.ALPHA, 1.0f, 0.0f));
                    }
                }
            }
            if (view2 != null) {
                arrayList.add(ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.ALPHA, 0.0f, 1.0f));
            }
            if (view3 != null) {
                arrayList.add(ObjectAnimator.ofFloat(view3, (Property<View, Float>) View.TRANSLATION_Y, i));
                this.actionModeTranslationView = view3;
            }
            this.actionModeExtraView = view;
            this.actionModeShowingView = view2;
            this.actionModeHidingViews = viewArr;
            if (this.occupyStatusBar && (view6 = this.actionModeTop) != null && !SharedConfig.noStatusBar) {
                arrayList.add(ObjectAnimator.ofFloat(view6, (Property<View, Float>) View.ALPHA, 0.0f, 1.0f));
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
            this.actionModeAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.ActionBar.ActionBar.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    ActionBar.this.actionMode.setVisibility(0);
                    if (!ActionBar.this.occupyStatusBar || ActionBar.this.actionModeTop == null || SharedConfig.noStatusBar) {
                        return;
                    }
                    ActionBar.this.actionModeTop.setVisibility(0);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    boolean[] zArr2;
                    if (ActionBar.this.actionModeAnimation == null || !ActionBar.this.actionModeAnimation.equals(animator)) {
                        return;
                    }
                    ActionBar.this.actionModeAnimation = null;
                    if (ActionBar.this.titleTextView[0] != null) {
                        ActionBar.this.titleTextView[0].setVisibility(4);
                    }
                    if (ActionBar.this.subtitleTextView != null && !TextUtils.isEmpty(ActionBar.this.subtitleTextView.getText())) {
                        ActionBar.this.subtitleTextView.setVisibility(4);
                    }
                    if (ActionBar.this.menu != null) {
                        ActionBar.this.menu.setVisibility(4);
                    }
                    if (ActionBar.this.actionModeHidingViews != null) {
                        for (int i3 = 0; i3 < ActionBar.this.actionModeHidingViews.length; i3++) {
                            if (ActionBar.this.actionModeHidingViews[i3] != null && ((zArr2 = zArr) == null || i3 >= zArr2.length || zArr2[i3])) {
                                ActionBar.this.actionModeHidingViews[i3].setVisibility(4);
                            }
                        }
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    if (ActionBar.this.actionModeAnimation == null || !ActionBar.this.actionModeAnimation.equals(animator)) {
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
        if (viewArr != null) {
            for (int i3 = 0; i3 < viewArr.length; i3++) {
                if (viewArr[i3] != null) {
                    viewArr[i3].setAlpha(0.0f);
                }
            }
        }
        if (view2 != null) {
            view2.setAlpha(1.0f);
        }
        if (view3 != null) {
            view3.setTranslationY(i);
            this.actionModeTranslationView = view3;
        }
        this.actionModeExtraView = view;
        this.actionModeShowingView = view2;
        this.actionModeHidingViews = viewArr;
        if (this.occupyStatusBar && (view5 = this.actionModeTop) != null && !SharedConfig.noStatusBar) {
            view5.setAlpha(1.0f);
        }
        if (SharedConfig.noStatusBar) {
            if (AndroidUtilities.computePerceivedBrightness(this.actionModeColor) < 0.721f) {
                AndroidUtilities.setLightStatusBar(((Activity) getContext()).getWindow(), false);
            } else {
                AndroidUtilities.setLightStatusBar(((Activity) getContext()).getWindow(), true);
            }
        }
        this.actionMode.setVisibility(0);
        if (this.occupyStatusBar && (view4 = this.actionModeTop) != null && !SharedConfig.noStatusBar) {
            view4.setVisibility(0);
        }
        SimpleTextView[] simpleTextViewArr = this.titleTextView;
        if (simpleTextViewArr[0] != null) {
            simpleTextViewArr[0].setVisibility(4);
        }
        SimpleTextView simpleTextView = this.subtitleTextView;
        if (simpleTextView != null && !TextUtils.isEmpty(simpleTextView.getText())) {
            this.subtitleTextView.setVisibility(4);
        }
        ActionBarMenu actionBarMenu2 = this.menu;
        if (actionBarMenu2 != null) {
            actionBarMenu2.setVisibility(4);
        }
        if (this.actionModeHidingViews != null) {
            int i4 = 0;
            while (true) {
                View[] viewArr2 = this.actionModeHidingViews;
                if (i4 >= viewArr2.length) {
                    break;
                }
                if (viewArr2[i4] != null && (zArr == null || i4 >= zArr.length || zArr[i4])) {
                    viewArr2[i4].setVisibility(4);
                }
                i4++;
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
        this.actionModeAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.ActionBar.ActionBar.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (ActionBar.this.actionModeAnimation == null || !ActionBar.this.actionModeAnimation.equals(animator)) {
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
            public void onAnimationCancel(Animator animator) {
                if (ActionBar.this.actionModeAnimation == null || !ActionBar.this.actionModeAnimation.equals(animator)) {
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
            SimpleTextView simpleTextView = this.subtitleTextView;
            if (simpleTextView != null && !TextUtils.isEmpty(simpleTextView.getText())) {
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
            view.setBackgroundColor(Theme.getColor(Theme.key_actionBarActionModeDefaultTop));
            addView(this.actionModeTop);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.actionModeTop.getLayoutParams();
            layoutParams.height = AndroidUtilities.statusBarHeight;
            layoutParams.width = -1;
            layoutParams.gravity = 51;
            this.actionModeTop.setLayoutParams(layoutParams);
        }
    }

    public void setActionModeTopColor(int i) {
        View view = this.actionModeTop;
        if (view != null) {
            view.setBackgroundColor(i);
        }
    }

    public void setSearchTextColor(int i, boolean z) {
        ActionBarMenu actionBarMenu = this.menu;
        if (actionBarMenu != null) {
            actionBarMenu.setSearchTextColor(i, z);
        }
    }

    public void setActionModeColor(int i) {
        ActionBarMenu actionBarMenu = this.actionMode;
        if (actionBarMenu != null) {
            actionBarMenu.setBackgroundColor(i);
        }
    }

    public void setActionModeOverrideColor(int i) {
        this.actionModeColor = i;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.actionBarColor = i;
        super.setBackgroundColor(i);
    }

    public boolean isActionModeShowed() {
        return this.actionMode != null && this.actionModeVisible;
    }

    public void onSearchFieldVisibilityChanged(final boolean z) {
        this.isSearchFieldVisible = z;
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
        SimpleTextView simpleTextView = this.subtitleTextView;
        if (simpleTextView != null && !TextUtils.isEmpty(simpleTextView.getText())) {
            arrayList.add(this.subtitleTextView);
            this.subtitleTextView.setVisibility(z ? 4 : 0);
        }
        int i = 0;
        while (true) {
            float f = 1.0f;
            if (i >= arrayList.size()) {
                break;
            }
            View view = (View) arrayList.get(i);
            if (!z) {
                view.setVisibility(0);
                view.setAlpha(0.0f);
                view.setScaleX(0.95f);
                view.setScaleY(0.95f);
            }
            AnimatorSet animatorSet2 = this.searchVisibleAnimator;
            Animator[] animatorArr = new Animator[1];
            Property property = View.ALPHA;
            float[] fArr = new float[1];
            fArr[0] = z ? 0.0f : 1.0f;
            animatorArr[0] = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, fArr);
            animatorSet2.playTogether(animatorArr);
            AnimatorSet animatorSet3 = this.searchVisibleAnimator;
            Animator[] animatorArr2 = new Animator[1];
            Property property2 = View.SCALE_Y;
            float[] fArr2 = new float[1];
            fArr2[0] = z ? 0.95f : 1.0f;
            animatorArr2[0] = ObjectAnimator.ofFloat(view, (Property<View, Float>) property2, fArr2);
            animatorSet3.playTogether(animatorArr2);
            AnimatorSet animatorSet4 = this.searchVisibleAnimator;
            Animator[] animatorArr3 = new Animator[1];
            Property property3 = View.SCALE_X;
            float[] fArr3 = new float[1];
            if (z) {
                f = 0.95f;
            }
            fArr3[0] = f;
            animatorArr3[0] = ObjectAnimator.ofFloat(view, (Property<View, Float>) property3, fArr3);
            animatorSet4.playTogether(animatorArr3);
            i++;
        }
        this.searchVisibleAnimator.addListener(new AnimatorListenerAdapter(this) { // from class: org.rbmain.ui.ActionBar.ActionBar.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    View view2 = (View) arrayList.get(i2);
                    if (z) {
                        view2.setVisibility(4);
                        view2.setAlpha(0.0f);
                    } else {
                        view2.setAlpha(1.0f);
                    }
                }
            }
        });
        this.searchVisibleAnimator.setDuration(150L).start();
        Drawable drawable = this.backButtonImageView.getDrawable();
        if (drawable instanceof MenuDrawable) {
            MenuDrawable menuDrawable = (MenuDrawable) drawable;
            menuDrawable.setRotateToBack(true);
            menuDrawable.setRotation(z ? 1.0f : 0.0f, true);
            this.backButtonImageView.setVisibility(z ? 0 : 4);
        }
    }

    public void setInterceptTouches(boolean z) {
        this.interceptTouches = z;
    }

    public void setExtraHeight(int i) {
        this.extraHeight = i;
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

    public void closeSearchField(boolean z) {
        ActionBarMenu actionBarMenu;
        if (!this.isSearchFieldVisible || (actionBarMenu = this.menu) == null) {
            return;
        }
        actionBarMenu.closeSearchField(z);
    }

    public void openSearchField(String str, boolean z) {
        ActionBarMenu actionBarMenu = this.menu;
        if (actionBarMenu == null || str == null) {
            return;
        }
        boolean z2 = this.isSearchFieldVisible;
        actionBarMenu.openSearchField(!z2, !z2, str, z);
    }

    public void setSearchFilter(FiltersView.MediaFilterData mediaFilterData) {
        ActionBarMenu actionBarMenu = this.menu;
        if (actionBarMenu != null) {
            actionBarMenu.setFilter(mediaFilterData);
        }
    }

    public void setSearchFieldText(String str) {
        this.menu.setSearchFieldText(str);
    }

    public void onSearchPressed() {
        this.menu.onSearchPressed();
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        ImageView imageView = this.backButtonImageView;
        if (imageView != null) {
            imageView.setEnabled(z);
        }
        ActionBarMenu actionBarMenu = this.menu;
        if (actionBarMenu != null) {
            actionBarMenu.setEnabled(z);
        }
        ActionBarMenu actionBarMenu2 = this.actionMode;
        if (actionBarMenu2 != null) {
            actionBarMenu2.setEnabled(z);
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
    protected void onMeasure(int i, int i2) {
        int iDp;
        SimpleTextView simpleTextView;
        SimpleTextView simpleTextView2;
        int iMakeMeasureSpec;
        int size = View.MeasureSpec.getSize(i);
        View.MeasureSpec.getSize(i2);
        int currentActionBarHeight = getCurrentActionBarHeight();
        if (this.isSmallActionBar) {
            currentActionBarHeight = AndroidUtilities.dp(48.0f);
        }
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
                if (!this.isMenuOffsetSuppressed) {
                    this.menu.translateXItems(-itemsMeasuredWidth);
                }
            } else if (this.isSearchFieldVisible) {
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size - AndroidUtilities.dp(AndroidUtilities.isTablet() ? 74.0f : 66.0f), 1073741824);
                if (!this.isMenuOffsetSuppressed) {
                    this.menu.translateXItems(0.0f);
                }
            } else {
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
                if (!this.isMenuOffsetSuppressed) {
                    this.menu.translateXItems(0.0f);
                }
            }
            this.menu.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        }
        for (int i3 = 0; i3 < 2; i3++) {
            SimpleTextView[] simpleTextViewArr = this.titleTextView;
            if ((simpleTextViewArr[0] != null && simpleTextViewArr[0].getVisibility() != 8) || ((simpleTextView = this.subtitleTextView) != null && simpleTextView.getVisibility() != 8)) {
                ActionBarMenu actionBarMenu3 = this.menu;
                int measuredWidth = (((size - (actionBarMenu3 != null ? actionBarMenu3.getMeasuredWidth() : 0)) - AndroidUtilities.dp(16.0f)) - iDp) - this.titleRightMargin;
                boolean z = this.fromBottom;
                if (((z && i3 == 0) || (!z && i3 == 1)) && this.overlayTitleAnimation && this.titleAnimationRunning) {
                    this.titleTextView[i3].setTextSize((AndroidUtilities.isTablet() || getResources().getConfiguration().orientation != 2) ? 16 : 14);
                } else {
                    SimpleTextView[] simpleTextViewArr2 = this.titleTextView;
                    if (simpleTextViewArr2[0] != null && simpleTextViewArr2[0].getVisibility() != 8 && (simpleTextView2 = this.subtitleTextView) != null && simpleTextView2.getVisibility() != 8) {
                        SimpleTextView[] simpleTextViewArr3 = this.titleTextView;
                        if (simpleTextViewArr3[i3] != null) {
                            simpleTextViewArr3[i3].setTextSize(AndroidUtilities.isTablet() ? 16 : 14);
                        }
                        this.subtitleTextView.setTextSize(AndroidUtilities.isTablet() ? 16 : 14);
                        SimpleTextView simpleTextView3 = this.additionalSubtitleTextView;
                        if (simpleTextView3 != null) {
                            simpleTextView3.setTextSize(AndroidUtilities.isTablet() ? 16 : 14);
                        }
                    } else {
                        SimpleTextView[] simpleTextViewArr4 = this.titleTextView;
                        if (simpleTextViewArr4[i3] != null && simpleTextViewArr4[i3].getVisibility() != 8) {
                            this.titleTextView[i3].setTextSize((AndroidUtilities.isTablet() || getResources().getConfiguration().orientation != 2) ? 16 : 14);
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
                if (simpleTextViewArr5[i3] != null && simpleTextViewArr5[i3].getVisibility() != 8) {
                    CharSequence text = this.titleTextView[i3].getText();
                    SimpleTextView[] simpleTextViewArr6 = this.titleTextView;
                    simpleTextViewArr6[i3].setPivotX(simpleTextViewArr6[i3].getTextPaint().measureText(text, 0, text.length()) / 2.0f);
                    this.titleTextView[i3].setPivotY(AndroidUtilities.dp(24.0f) >> 1);
                    this.titleTextView[i3].measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(24.0f), Integer.MIN_VALUE));
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
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                SimpleTextView[] simpleTextViewArr7 = this.titleTextView;
                if (childAt != simpleTextViewArr7[0] && childAt != simpleTextViewArr7[1] && childAt != this.subtitleTextView && childAt != this.menu && childAt != this.backButtonImageView && childAt != this.additionalSubtitleTextView) {
                    measureChildWithMargins(childAt, i, 0, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824), 0);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x029e  */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onLayout(boolean r16, int r17, int r18, int r19, int r20) {
        /*
            Method dump skipped, instructions count: 690
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.ActionBar.ActionBar.onLayout(boolean, int, int, int, int):void");
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

    public void setAllowOverlayTitle(boolean z) {
        this.allowOverlayTitle = z;
    }

    public void setTitleActionRunnable(Runnable runnable) {
        this.titleActionRunnable = runnable;
        this.lastRunnable = runnable;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0120  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setTitleOverlayText(java.lang.String r5, int r6, java.lang.Runnable r7) {
        /*
            Method dump skipped, instructions count: 341
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.ActionBar.ActionBar.setTitleOverlayText(java.lang.String, int, java.lang.Runnable):void");
    }

    public boolean isSearchFieldVisible() {
        return this.isSearchFieldVisible;
    }

    public void setOccupyStatusBar(boolean z) {
        this.occupyStatusBar = z;
        ActionBarMenu actionBarMenu = this.actionMode;
        if (actionBarMenu != null) {
            actionBarMenu.setPadding(0, z ? AndroidUtilities.statusBarHeight : 0, 0, 0);
        }
    }

    public boolean getOccupyStatusBar() {
        return this.occupyStatusBar;
    }

    public void setItemsBackgroundColor(int i, boolean z) {
        ImageView imageView;
        if (z) {
            this.itemsActionModeBackgroundColor = i;
            if (this.actionModeVisible && (imageView = this.backButtonImageView) != null) {
                imageView.setBackgroundDrawable(Theme.createSelectorDrawable(i));
            }
            ActionBarMenu actionBarMenu = this.actionMode;
            if (actionBarMenu != null) {
                actionBarMenu.updateItemsBackgroundColor();
                return;
            }
            return;
        }
        this.itemsBackgroundColor = i;
        ImageView imageView2 = this.backButtonImageView;
        if (imageView2 != null) {
            imageView2.setBackgroundDrawable(Theme.createSelectorDrawable(i));
        }
        ActionBarMenu actionBarMenu2 = this.menu;
        if (actionBarMenu2 != null) {
            actionBarMenu2.updateItemsBackgroundColor();
        }
    }

    public void setItemsColor(int i, boolean z) {
        if (z) {
            this.itemsActionModeColor = i;
            ActionBarMenu actionBarMenu = this.actionMode;
            if (actionBarMenu != null) {
                actionBarMenu.updateItemsColor();
            }
            ImageView imageView = this.backButtonImageView;
            if (imageView != null) {
                Drawable drawable = imageView.getDrawable();
                if (drawable instanceof BackDrawable) {
                    ((BackDrawable) drawable).setRotatedColor(i);
                    return;
                }
                return;
            }
            return;
        }
        this.itemsColor = i;
        ImageView imageView2 = this.backButtonImageView;
        if (imageView2 != null && i != 0) {
            imageView2.setColorFilter(new PorterDuffColorFilter(this.itemsColor, PorterDuff.Mode.MULTIPLY));
            Drawable drawable2 = this.backButtonImageView.getDrawable();
            if (drawable2 instanceof BackDrawable) {
                ((BackDrawable) drawable2).setColor(i);
            } else if (drawable2 instanceof MenuDrawable) {
                ((MenuDrawable) drawable2).setIconColor(i);
            }
        }
        ActionBarMenu actionBarMenu2 = this.menu;
        if (actionBarMenu2 != null) {
            actionBarMenu2.updateItemsColor();
        }
    }

    public void setCastShadows(boolean z) {
        this.castShadows = z;
    }

    public boolean getCastShadows() {
        return this.castShadows;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent) || this.interceptTouches;
    }

    public static int getCurrentActionBarHeight() {
        try {
            if (ApplicationLoader.applicationActivity.getLastFragment().isSmallActionBar) {
                return AndroidUtilities.dp(48.0f);
            }
        } catch (Exception unused) {
        }
        if (AndroidUtilities.isTablet()) {
            return AndroidUtilities.dp(64.0f);
        }
        Point point = AndroidUtilities.displaySize;
        if (point.x > point.y) {
            return AndroidUtilities.dp(48.0f);
        }
        return AndroidUtilities.dp(56.0f);
    }

    public void setTitleAnimated(CharSequence charSequence, final boolean z, long j) {
        if (this.titleTextView[0] == null || charSequence == null) {
            setTitle(charSequence);
            return;
        }
        final boolean z2 = this.overlayTitleAnimation && !TextUtils.isEmpty(this.subtitleTextView.getText());
        if (z2) {
            if (this.subtitleTextView.getVisibility() != 0) {
                this.subtitleTextView.setVisibility(0);
                this.subtitleTextView.setAlpha(0.0f);
            }
            this.subtitleTextView.animate().alpha(z ? 0.0f : 1.0f).setDuration(220L).start();
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
        setTitle(charSequence);
        this.fromBottom = z;
        this.titleTextView[0].setAlpha(0.0f);
        if (!z2) {
            SimpleTextView simpleTextView = this.titleTextView[0];
            int iDp = AndroidUtilities.dp(20.0f);
            if (!z) {
                iDp = -iDp;
            }
            simpleTextView.setTranslationY(iDp);
        }
        this.titleTextView[0].animate().alpha(1.0f).translationY(0.0f).setDuration(j).start();
        this.titleAnimationRunning = true;
        ViewPropertyAnimator viewPropertyAnimatorAlpha = this.titleTextView[1].animate().alpha(0.0f);
        if (!z2) {
            int iDp2 = AndroidUtilities.dp(20.0f);
            if (z) {
                iDp2 = -iDp2;
            }
            viewPropertyAnimatorAlpha.translationY(iDp2);
        }
        viewPropertyAnimatorAlpha.setDuration(j).setListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.ActionBar.ActionBar.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (ActionBar.this.titleTextView[1] != null && ActionBar.this.titleTextView[1].getParent() != null) {
                    ((ViewGroup) ActionBar.this.titleTextView[1].getParent()).removeView(ActionBar.this.titleTextView[1]);
                }
                ActionBar.this.titleTextView[1] = null;
                ActionBar.this.titleAnimationRunning = false;
                if (z2 && z) {
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

    public void setOverlayTitleAnimation(boolean z) {
        this.overlayTitleAnimation = z;
    }

    public boolean getAddToContainer() {
        return this.addToContainer;
    }

    public void setMenuOffsetSuppressed(boolean z) {
        this.isMenuOffsetSuppressed = z;
    }

    public ActionBarLayout.BackButtonState getBackButtonState() {
        Object obj = this.backButtonDrawable;
        if (obj instanceof ActionBarLayout.IBackButtonDrawable) {
            return ((ActionBarLayout.IBackButtonDrawable) obj).getBackButtonState();
        }
        return this.backButtonState;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.blurredBackground && this.actionBarColor != 0) {
            this.rectTmp.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
            this.blurScrimPaint.setColor(this.actionBarColor);
            this.contentView.drawBlurRect(canvas, getY(), this.rectTmp, this.blurScrimPaint, true);
        }
        super.dispatchDraw(canvas);
    }

    public void setDrawBlurBackground(SizeNotifierFrameLayout sizeNotifierFrameLayout) {
        this.blurredBackground = true;
        this.contentView = sizeNotifierFrameLayout;
        sizeNotifierFrameLayout.blurBehindViews.add(this);
        setBackground(null);
    }

    private int getThemedColor(int i) {
        return Theme.getColor(i);
    }
}
