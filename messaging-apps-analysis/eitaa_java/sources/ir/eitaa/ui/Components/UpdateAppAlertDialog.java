package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.DocumentObject;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SvgHelper;
import ir.eitaa.tgnet.TLRPC$TL_help_appUpdate;
import ir.eitaa.ui.ActionBar.BottomSheet;
import ir.eitaa.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class UpdateAppAlertDialog extends BottomSheet {
    private int accountNum;
    private boolean animationInProgress;
    private TLRPC$TL_help_appUpdate appUpdate;
    private LinearLayout linearLayout;
    private int[] location;
    private int scrollOffsetY;
    private NestedScrollView scrollView;
    private View shadow;
    private AnimatorSet shadowAnimation;
    private Drawable shadowDrawable;

    @Override // ir.eitaa.ui.ActionBar.BottomSheet
    protected boolean canDismissWithSwipe() {
        return false;
    }

    public class BottomSheetCell extends FrameLayout {
        private View background;
        private boolean hasBackground;
        private TextView[] textView;

        public BottomSheetCell(Context context, boolean withoutBackground) {
            super(context);
            this.textView = new TextView[2];
            this.hasBackground = !withoutBackground;
            setBackground(null);
            View view = new View(context);
            this.background = view;
            if (this.hasBackground) {
                view.setBackground(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(4.0f), Theme.getColor("featuredStickers_addButton"), Theme.getColor("featuredStickers_addButtonPressed")));
            }
            addView(this.background, LayoutHelper.createFrame(-1, -1.0f, 0, 16.0f, withoutBackground ? 0.0f : 16.0f, 16.0f, 16.0f));
            for (int i = 0; i < 2; i++) {
                this.textView[i] = new TextView(context);
                this.textView[i].setLines(1);
                this.textView[i].setSingleLine(true);
                this.textView[i].setGravity(1);
                this.textView[i].setEllipsize(TextUtils.TruncateAt.END);
                this.textView[i].setGravity(17);
                if (this.hasBackground) {
                    this.textView[i].setTextColor(Theme.getColor("featuredStickers_buttonText"));
                    this.textView[i].setTypeface(AndroidUtilities.getFontFamily(true));
                } else {
                    this.textView[i].setTextColor(Theme.getColor("featuredStickers_addButton"));
                }
                this.textView[i].setTextSize(1, 14.0f);
                this.textView[i].setPadding(0, 0, 0, this.hasBackground ? 0 : AndroidUtilities.dp(13.0f));
                addView(this.textView[i], LayoutHelper.createFrame(-2, -2, 17));
                if (i == 1) {
                    this.textView[i].setAlpha(0.0f);
                }
            }
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(this.hasBackground ? 80.0f : 50.0f), 1073741824));
        }

        public void setText(CharSequence text, boolean animated) {
            if (!animated) {
                this.textView[0].setText(text);
                return;
            }
            this.textView[1].setText(text);
            UpdateAppAlertDialog.this.animationInProgress = true;
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(180L);
            animatorSet.setInterpolator(CubicBezierInterpolator.EASE_OUT);
            animatorSet.playTogether(ObjectAnimator.ofFloat(this.textView[0], (Property<TextView, Float>) View.ALPHA, 1.0f, 0.0f), ObjectAnimator.ofFloat(this.textView[0], (Property<TextView, Float>) View.TRANSLATION_Y, 0.0f, -AndroidUtilities.dp(10.0f)), ObjectAnimator.ofFloat(this.textView[1], (Property<TextView, Float>) View.ALPHA, 0.0f, 1.0f), ObjectAnimator.ofFloat(this.textView[1], (Property<TextView, Float>) View.TRANSLATION_Y, AndroidUtilities.dp(10.0f), 0.0f));
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.UpdateAppAlertDialog.BottomSheetCell.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    UpdateAppAlertDialog.this.animationInProgress = false;
                    TextView textView = BottomSheetCell.this.textView[0];
                    BottomSheetCell.this.textView[0] = BottomSheetCell.this.textView[1];
                    BottomSheetCell.this.textView[1] = textView;
                }
            });
            animatorSet.start();
        }
    }

    public UpdateAppAlertDialog(Context context, TLRPC$TL_help_appUpdate update, int account) {
        super(context, false);
        this.location = new int[2];
        this.appUpdate = update;
        this.accountNum = account;
        setCanceledOnTouchOutside(false);
        setApplyTopPadding(false);
        setApplyBottomPadding(false);
        Drawable drawableMutate = context.getResources().getDrawable(R.drawable.sheet_shadow_round).mutate();
        this.shadowDrawable = drawableMutate;
        drawableMutate.setColorFilter(new PorterDuffColorFilter(Theme.getColor("dialogBackground"), PorterDuff.Mode.MULTIPLY));
        FrameLayout frameLayout = new FrameLayout(context) { // from class: ir.eitaa.ui.Components.UpdateAppAlertDialog.1
            @Override // android.view.View
            public void setTranslationY(float translationY) {
                super.setTranslationY(translationY);
                UpdateAppAlertDialog.this.updateLayout();
            }

            @Override // android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent ev) {
                if (ev.getAction() == 0 && UpdateAppAlertDialog.this.scrollOffsetY != 0 && ev.getY() < UpdateAppAlertDialog.this.scrollOffsetY) {
                    UpdateAppAlertDialog.this.dismiss();
                    return true;
                }
                return super.onInterceptTouchEvent(ev);
            }

            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent e) {
                return !UpdateAppAlertDialog.this.isDismissed() && super.onTouchEvent(e);
            }

            @Override // android.view.View
            protected void onDraw(Canvas canvas) {
                UpdateAppAlertDialog.this.shadowDrawable.setBounds(0, (int) ((UpdateAppAlertDialog.this.scrollOffsetY - ((BottomSheet) UpdateAppAlertDialog.this).backgroundPaddingTop) - getTranslationY()), getMeasuredWidth(), getMeasuredHeight());
                UpdateAppAlertDialog.this.shadowDrawable.draw(canvas);
            }
        };
        frameLayout.setWillNotDraw(false);
        this.containerView = frameLayout;
        NestedScrollView nestedScrollView = new NestedScrollView(context) { // from class: ir.eitaa.ui.Components.UpdateAppAlertDialog.2
            private boolean ignoreLayout;

            @Override // androidx.core.widget.NestedScrollView, android.widget.FrameLayout, android.view.View
            protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                int size = View.MeasureSpec.getSize(heightMeasureSpec);
                measureChildWithMargins(UpdateAppAlertDialog.this.linearLayout, widthMeasureSpec, 0, heightMeasureSpec, 0);
                int measuredHeight = UpdateAppAlertDialog.this.linearLayout.getMeasuredHeight();
                int i = (size / 5) * 2;
                if (measuredHeight - (size - i) < AndroidUtilities.dp(90.0f) || measuredHeight < (size / 2) + AndroidUtilities.dp(90.0f)) {
                    i = size - measuredHeight;
                }
                if (i < 0) {
                    i = 0;
                }
                if (getPaddingTop() != i) {
                    this.ignoreLayout = true;
                    setPadding(0, i, 0, 0);
                    this.ignoreLayout = false;
                }
                super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(size, 1073741824));
            }

            @Override // androidx.core.widget.NestedScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
                super.onLayout(changed, left, top, right, bottom);
                UpdateAppAlertDialog.this.updateLayout();
            }

            @Override // androidx.core.widget.NestedScrollView, android.view.View, android.view.ViewParent
            public void requestLayout() {
                if (this.ignoreLayout) {
                    return;
                }
                super.requestLayout();
            }

            @Override // androidx.core.widget.NestedScrollView, android.view.View
            protected void onScrollChanged(int l, int t, int oldl, int oldt) {
                super.onScrollChanged(l, t, oldl, oldt);
                UpdateAppAlertDialog.this.updateLayout();
            }
        };
        this.scrollView = nestedScrollView;
        nestedScrollView.setFillViewport(true);
        this.scrollView.setWillNotDraw(false);
        this.scrollView.setClipToPadding(false);
        this.scrollView.setVerticalScrollBarEnabled(false);
        frameLayout.addView(this.scrollView, LayoutHelper.createFrame(-1, -1.0f, 51, 0.0f, 0.0f, 0.0f, 130.0f));
        LinearLayout linearLayout = new LinearLayout(context);
        this.linearLayout = linearLayout;
        linearLayout.setOrientation(1);
        this.scrollView.addView(this.linearLayout, LayoutHelper.createScroll(-1, -2, 51));
        if (this.appUpdate.sticker != null) {
            BackupImageView backupImageView = new BackupImageView(context);
            SvgHelper.SvgDrawable svgThumb = DocumentObject.getSvgThumb(this.appUpdate.sticker.thumbs, "windowBackgroundGray", 1.0f);
            ImageLocation forDocument = ImageLocation.getForDocument(FileLoader.getClosestPhotoSizeWithSize(this.appUpdate.sticker.thumbs, 90), this.appUpdate.sticker);
            if (svgThumb != null) {
                backupImageView.setImage(ImageLocation.getForDocument(this.appUpdate.sticker), "50_50", svgThumb, 0, "update");
            } else {
                backupImageView.setImage(ImageLocation.getForDocument(this.appUpdate.sticker), "50_50", forDocument, (String) null, 0, "update");
            }
            this.linearLayout.addView(backupImageView, LayoutHelper.createLinear(160, 160, 49, 17, 8, 17, 0));
        }
        TextView textView = new TextView(context);
        textView.setTypeface(AndroidUtilities.getFontFamily(true));
        textView.setTextSize(1, 20.0f);
        textView.setTextColor(Theme.getColor("dialogTextBlack"));
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setText(LocaleController.getString("AppUpdate", R.string.AppUpdate));
        this.linearLayout.addView(textView, LayoutHelper.createLinear(-2, -2, 49, 23, 16, 23, 0));
        TextView textView2 = new TextView(getContext());
        textView2.setTextColor(Theme.getColor("dialogTextGray3"));
        textView2.setTextSize(1, 14.0f);
        textView2.setMovementMethod(new AndroidUtilities.LinkMovementMethodMy());
        textView2.setLinkTextColor(Theme.getColor("dialogTextLink"));
        textView2.setText(LocaleController.formatString("AppUpdateVersionAndSize", R.string.AppUpdateVersionAndSize, this.appUpdate.version, AndroidUtilities.formatFileSize(r14.document.size)));
        textView2.setGravity(49);
        this.linearLayout.addView(textView2, LayoutHelper.createLinear(-2, -2, 49, 23, 0, 23, 5));
        TextView textView3 = new TextView(getContext());
        textView3.setTextColor(Theme.getColor("dialogTextBlack"));
        textView3.setTextSize(1, 14.0f);
        textView3.setMovementMethod(new AndroidUtilities.LinkMovementMethodMy());
        textView3.setLinkTextColor(Theme.getColor("dialogTextLink"));
        if (TextUtils.isEmpty(this.appUpdate.text)) {
            textView3.setText(AndroidUtilities.replaceTags(LocaleController.getString("AppUpdateChangelogEmpty", R.string.AppUpdateChangelogEmpty)));
        } else {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.appUpdate.text);
            MessageObject.addEntitiesToText(spannableStringBuilder, update.entities, false, false, false, false);
            textView3.setText(spannableStringBuilder);
        }
        textView3.setGravity(51);
        this.linearLayout.addView(textView3, LayoutHelper.createLinear(-2, -2, 51, 23, 15, 23, 0));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, AndroidUtilities.getShadowHeight(), 83);
        layoutParams.bottomMargin = AndroidUtilities.dp(130.0f);
        View view = new View(context);
        this.shadow = view;
        view.setBackgroundColor(Theme.getColor("dialogShadowLine"));
        this.shadow.setAlpha(0.0f);
        this.shadow.setTag(1);
        frameLayout.addView(this.shadow, layoutParams);
        BottomSheetCell bottomSheetCell = new BottomSheetCell(context, false);
        bottomSheetCell.setText(LocaleController.formatString("AppUpdateDownloadNow", R.string.AppUpdateDownloadNow, new Object[0]), false);
        bottomSheetCell.background.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$UpdateAppAlertDialog$u0fBW1mPircu--E_sLJpNmu1EIk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$new$0$UpdateAppAlertDialog(view2);
            }
        });
        frameLayout.addView(bottomSheetCell, LayoutHelper.createFrame(-1, 50.0f, 83, 0.0f, 0.0f, 0.0f, 50.0f));
        BottomSheetCell bottomSheetCell2 = new BottomSheetCell(context, true);
        bottomSheetCell2.setText(LocaleController.getString("AppUpdateRemindMeLater", R.string.AppUpdateRemindMeLater), false);
        bottomSheetCell2.background.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$UpdateAppAlertDialog$ZJZKrdt4HurBkV7jpmCVVXD81KM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$new$1$UpdateAppAlertDialog(view2);
            }
        });
        frameLayout.addView(bottomSheetCell2, LayoutHelper.createFrame(-1, 50.0f, 83, 0.0f, 0.0f, 0.0f, 0.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$UpdateAppAlertDialog(View view) {
        FileLoader.getInstance(this.accountNum).loadFile(this.appUpdate.document, "update", 1, 1);
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$1$UpdateAppAlertDialog(View view) {
        dismiss();
    }

    private void runShadowAnimation(final int num, final boolean show) {
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
        this.shadowAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.UpdateAppAlertDialog.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                if (UpdateAppAlertDialog.this.shadowAnimation == null || !UpdateAppAlertDialog.this.shadowAnimation.equals(animation)) {
                    return;
                }
                if (!show) {
                    UpdateAppAlertDialog.this.shadow.setVisibility(4);
                }
                UpdateAppAlertDialog.this.shadowAnimation = null;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                if (UpdateAppAlertDialog.this.shadowAnimation == null || !UpdateAppAlertDialog.this.shadowAnimation.equals(animation)) {
                    return;
                }
                UpdateAppAlertDialog.this.shadowAnimation = null;
            }
        });
        this.shadowAnimation.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLayout() {
        this.linearLayout.getChildAt(0).getLocationInWindow(this.location);
        int iMax = Math.max(this.location[1] - AndroidUtilities.dp(24.0f), 0);
        if (this.location[1] + this.linearLayout.getMeasuredHeight() <= (this.container.getMeasuredHeight() - AndroidUtilities.dp(113.0f)) + this.containerView.getTranslationY()) {
            runShadowAnimation(0, false);
        } else {
            runShadowAnimation(0, true);
        }
        if (this.scrollOffsetY != iMax) {
            this.scrollOffsetY = iMax;
            this.scrollView.invalidate();
        }
    }
}
