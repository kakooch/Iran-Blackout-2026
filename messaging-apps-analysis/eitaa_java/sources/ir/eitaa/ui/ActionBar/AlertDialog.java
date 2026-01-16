package ir.eitaa.ui.ActionBar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.R;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.LineProgressView;
import ir.eitaa.ui.Components.RLottieImageView;
import ir.eitaa.ui.Components.RadialProgressView;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class AlertDialog extends Dialog implements Drawable.Callback {
    private float aspectRatio;
    private Rect backgroundPaddings;
    protected ViewGroup buttonsLayout;
    private boolean canCacnel;
    private AlertDialog cancelDialog;
    private boolean checkFocusable;
    private ScrollView contentScrollView;
    private int currentProgress;
    private View customView;
    private int customViewHeight;
    private int customViewOffset;
    private String dialogButtonColorKey;
    private boolean dimEnabled;
    private boolean dismissDialogByButtons;
    private Runnable dismissRunnable;
    private boolean drawBackground;
    private boolean focusable;
    private boolean isDifferentNeutralButton;
    private int[] itemIcons;
    private ArrayList<AlertDialogCell> itemViews;
    private CharSequence[] items;
    private int lastScreenWidth;
    private LineProgressView lineProgressView;
    private TextView lineProgressViewPercent;
    private CharSequence message;
    private TextView messageTextView;
    private boolean messageTextViewClickable;
    private DialogInterface.OnClickListener negativeButtonListener;
    private CharSequence negativeButtonText;
    private DialogInterface.OnClickListener neutralButtonListener;
    private CharSequence neutralButtonText;
    private boolean notDrawBackgroundOnTopView;
    private DialogInterface.OnClickListener onBackButtonListener;
    private DialogInterface.OnCancelListener onCancelListener;
    private DialogInterface.OnClickListener onClickListener;
    private DialogInterface.OnDismissListener onDismissListener;
    private ViewTreeObserver.OnScrollChangedListener onScrollChangedListener;
    private DialogInterface.OnClickListener positiveButtonListener;
    private CharSequence positiveButtonText;
    private FrameLayout progressViewContainer;
    private int progressViewStyle;
    private final Theme.ResourcesProvider resourcesProvider;
    private LinearLayout scrollContainer;
    private CharSequence secondTitle;
    private TextView secondTitleTextView;
    private BitmapDrawable[] shadow;
    private AnimatorSet[] shadowAnimation;
    private Drawable shadowDrawable;
    private boolean[] shadowVisibility;
    private Runnable showRunnable;
    private CharSequence subtitle;
    private TextView subtitleTextView;
    private CharSequence title;
    private FrameLayout titleContainer;
    private TextView titleTextView;
    private int topAnimationId;
    private int topBackgroundColor;
    private Drawable topDrawable;
    private int topHeight;
    private RLottieImageView topImageView;
    private int topResId;
    private View topView;
    private boolean verticalButtons;

    public ArrayList<ThemeDescription> getThemeDescriptions() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$AlertDialog() {
        if (isShowing()) {
            return;
        }
        try {
            show();
        } catch (Exception unused) {
        }
    }

    public static class AlertDialogCell extends FrameLayout {
        private ImageView imageView;
        private final Theme.ResourcesProvider resourcesProvider;
        private TextView textView;

        public AlertDialogCell(Context context, Theme.ResourcesProvider resourcesProvider) {
            super(context);
            this.resourcesProvider = resourcesProvider;
            setBackgroundDrawable(Theme.createSelectorDrawable(getThemedColor("dialogButtonSelector"), 2));
            setPadding(AndroidUtilities.dp(23.0f), 0, AndroidUtilities.dp(23.0f), 0);
            ImageView imageView = new ImageView(context);
            this.imageView = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            this.imageView.setColorFilter(new PorterDuffColorFilter(getThemedColor("dialogIcon"), PorterDuff.Mode.MULTIPLY));
            addView(this.imageView, LayoutHelper.createFrame(-2, 40, (LocaleController.isRTL ? 5 : 3) | 16));
            TextView textView = new TextView(context);
            this.textView = textView;
            textView.setLines(1);
            this.textView.setSingleLine(true);
            this.textView.setGravity(1);
            this.textView.setEllipsize(TextUtils.TruncateAt.END);
            this.textView.setTextColor(getThemedColor("dialogTextBlack"));
            this.textView.setTextSize(1, 16.0f);
            this.textView.setTypeface(AndroidUtilities.getFontFamily(false));
            addView(this.textView, LayoutHelper.createFrame(-2, -2, (LocaleController.isRTL ? 5 : 3) | 16));
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(48.0f), 1073741824));
        }

        public void setTextColor(int color) {
            this.textView.setTextColor(color);
        }

        public void setGravity(int gravity) {
            this.textView.setGravity(gravity);
        }

        public void setTextAndIcon(CharSequence text, int icon) {
            this.textView.setText(text);
            if (icon != 0) {
                this.imageView.setImageResource(icon);
                this.imageView.setVisibility(0);
                this.textView.setPadding(LocaleController.isRTL ? 0 : AndroidUtilities.dp(56.0f), 0, LocaleController.isRTL ? AndroidUtilities.dp(56.0f) : 0, 0);
            } else {
                this.imageView.setVisibility(4);
                this.textView.setPadding(0, 0, 0, 0);
            }
        }

        private int getThemedColor(String key) {
            Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
            Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
            return color != null ? color.intValue() : Theme.getColor(key);
        }
    }

    public AlertDialog(Context context, int progressStyle) {
        this(context, progressStyle, null);
    }

    public AlertDialog(Context context, int progressStyle, Theme.ResourcesProvider resourcesProvider) {
        super(context, R.style.TransparentDialog);
        this.customViewHeight = -2;
        this.shadow = new BitmapDrawable[2];
        this.shadowVisibility = new boolean[2];
        this.shadowAnimation = new AnimatorSet[2];
        this.customViewOffset = 20;
        this.dialogButtonColorKey = "dialogButton";
        this.topHeight = 132;
        this.messageTextViewClickable = true;
        this.canCacnel = true;
        this.dismissDialogByButtons = true;
        this.isDifferentNeutralButton = false;
        this.checkFocusable = true;
        this.dismissRunnable = new Runnable() { // from class: ir.eitaa.ui.ActionBar.-$$Lambda$As9UG-BvbNIOvAvsbyQiR2CNscw
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.dismiss();
            }
        };
        this.showRunnable = new Runnable() { // from class: ir.eitaa.ui.ActionBar.-$$Lambda$AlertDialog$Fo2yUe_GEU4vfrYS5uh1pYsHPgQ
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$0$AlertDialog();
            }
        };
        this.itemViews = new ArrayList<>();
        this.dimEnabled = true;
        this.resourcesProvider = resourcesProvider;
        this.backgroundPaddings = new Rect();
        if (progressStyle != 3) {
            Drawable drawableMutate = context.getResources().getDrawable(R.drawable.popup_fixed_alert).mutate();
            this.shadowDrawable = drawableMutate;
            drawableMutate.setColorFilter(new PorterDuffColorFilter(getThemedColor("dialogBackground"), PorterDuff.Mode.MULTIPLY));
            this.shadowDrawable.getPadding(this.backgroundPaddings);
        }
        this.progressViewStyle = progressStyle;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) throws NoSuchFieldException {
        int iDp;
        super.onCreate(savedInstanceState);
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(getContext());
        anonymousClass1.setOrientation(1);
        if (this.progressViewStyle == 3) {
            anonymousClass1.setBackgroundDrawable(null);
            anonymousClass1.setPadding(0, 0, 0, 0);
            this.drawBackground = false;
        } else if (this.notDrawBackgroundOnTopView) {
            Rect rect = new Rect();
            this.shadowDrawable.getPadding(rect);
            anonymousClass1.setPadding(rect.left, rect.top, rect.right, rect.bottom);
            this.drawBackground = true;
        } else {
            anonymousClass1.setBackgroundDrawable(null);
            anonymousClass1.setPadding(0, 0, 0, 0);
            anonymousClass1.setBackgroundDrawable(this.shadowDrawable);
            this.drawBackground = false;
        }
        anonymousClass1.setFitsSystemWindows(Build.VERSION.SDK_INT >= 21);
        setContentView(anonymousClass1);
        boolean z = (this.positiveButtonText == null && this.negativeButtonText == null && this.neutralButtonText == null) ? false : true;
        if (this.topResId != 0 || this.topAnimationId != 0 || this.topDrawable != null) {
            RLottieImageView rLottieImageView = new RLottieImageView(getContext());
            this.topImageView = rLottieImageView;
            Drawable drawable = this.topDrawable;
            if (drawable != null) {
                rLottieImageView.setImageDrawable(drawable);
            } else {
                int i = this.topResId;
                if (i != 0) {
                    rLottieImageView.setImageResource(i);
                } else {
                    rLottieImageView.setAutoRepeat(true);
                    this.topImageView.setAnimation(this.topAnimationId, 94, 94);
                    this.topImageView.playAnimation();
                }
            }
            this.topImageView.setScaleType(ImageView.ScaleType.CENTER);
            this.topImageView.setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.popup_fixed_top));
            this.topImageView.getBackground().setColorFilter(new PorterDuffColorFilter(this.topBackgroundColor, PorterDuff.Mode.MULTIPLY));
            this.topImageView.setPadding(0, 0, 0, 0);
            anonymousClass1.addView(this.topImageView, LayoutHelper.createLinear(-1, this.topHeight, 51, -8, -8, 0, 0));
        } else {
            View view = this.topView;
            if (view != null) {
                view.setPadding(0, 0, 0, 0);
                anonymousClass1.addView(this.topView, LayoutHelper.createLinear(-1, this.topHeight, 51, 0, 0, 0, 0));
            }
        }
        if (this.title != null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            this.titleContainer = frameLayout;
            anonymousClass1.addView(frameLayout, LayoutHelper.createLinear(-2, -2, 24.0f, 0.0f, 24.0f, 0.0f));
            TextView textView = new TextView(getContext());
            this.titleTextView = textView;
            textView.setText(this.title);
            this.titleTextView.setTextColor(getThemedColor("dialogTextBlack"));
            this.titleTextView.setTextSize(1, 20.0f);
            this.titleTextView.setTypeface(AndroidUtilities.getFontFamily(true));
            this.titleTextView.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
            this.titleContainer.addView(this.titleTextView, LayoutHelper.createFrame(-2, -2.0f, (LocaleController.isRTL ? 5 : 3) | 48, 0.0f, 19.0f, 0.0f, this.subtitle != null ? 2 : this.items != null ? 14 : 10));
        }
        if (this.secondTitle != null && this.title != null) {
            TextView textView2 = new TextView(getContext());
            this.secondTitleTextView = textView2;
            textView2.setText(this.secondTitle);
            this.secondTitleTextView.setTextColor(getThemedColor("dialogTextGray3"));
            this.secondTitleTextView.setTextSize(1, 18.0f);
            this.secondTitleTextView.setTypeface(AndroidUtilities.getFontFamily(false));
            this.secondTitleTextView.setGravity((LocaleController.isRTL ? 3 : 5) | 48);
            this.titleContainer.addView(this.secondTitleTextView, LayoutHelper.createFrame(-2, -2.0f, (LocaleController.isRTL ? 3 : 5) | 48, 0.0f, 21.0f, 0.0f, 0.0f));
        }
        if (this.subtitle != null) {
            TextView textView3 = new TextView(getContext());
            this.subtitleTextView = textView3;
            textView3.setText(this.subtitle);
            this.subtitleTextView.setTextColor(getThemedColor("dialogIcon"));
            this.subtitleTextView.setTextSize(1, 14.0f);
            this.subtitleTextView.setTypeface(AndroidUtilities.getFontFamily(false));
            this.subtitleTextView.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
            anonymousClass1.addView(this.subtitleTextView, LayoutHelper.createLinear(-2, -2, (LocaleController.isRTL ? 5 : 3) | 48, 24, 0, 24, this.items != null ? 14 : 10));
        }
        if (this.progressViewStyle == 0) {
            this.shadow[0] = (BitmapDrawable) getContext().getResources().getDrawable(R.drawable.header_shadow).mutate();
            this.shadow[1] = (BitmapDrawable) getContext().getResources().getDrawable(R.drawable.header_shadow_reverse).mutate();
            this.shadow[0].setAlpha(0);
            this.shadow[1].setAlpha(0);
            this.shadow[0].setCallback(this);
            this.shadow[1].setCallback(this);
            ScrollView scrollView = new ScrollView(getContext()) { // from class: ir.eitaa.ui.ActionBar.AlertDialog.2
                @Override // android.view.ViewGroup
                protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
                    boolean zDrawChild = super.drawChild(canvas, child, drawingTime);
                    if (AlertDialog.this.shadow[0].getPaint().getAlpha() != 0) {
                        AlertDialog.this.shadow[0].setBounds(0, getScrollY(), getMeasuredWidth(), getScrollY() + AndroidUtilities.dp(3.0f));
                        AlertDialog.this.shadow[0].draw(canvas);
                    }
                    if (AlertDialog.this.shadow[1].getPaint().getAlpha() != 0) {
                        AlertDialog.this.shadow[1].setBounds(0, (getScrollY() + getMeasuredHeight()) - AndroidUtilities.dp(3.0f), getMeasuredWidth(), getScrollY() + getMeasuredHeight());
                        AlertDialog.this.shadow[1].draw(canvas);
                    }
                    return zDrawChild;
                }
            };
            this.contentScrollView = scrollView;
            scrollView.setVerticalScrollBarEnabled(false);
            AndroidUtilities.setScrollViewEdgeEffectColor(this.contentScrollView, getThemedColor("dialogScrollGlow"));
            anonymousClass1.addView(this.contentScrollView, LayoutHelper.createLinear(-1, -2, 0.0f, 0.0f, 0.0f, 0.0f));
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.scrollContainer = linearLayout;
            linearLayout.setOrientation(1);
            this.contentScrollView.addView(this.scrollContainer, new FrameLayout.LayoutParams(-1, -2));
        }
        TextView textView4 = new TextView(getContext());
        this.messageTextView = textView4;
        textView4.setTextColor(getThemedColor("dialogTextBlack"));
        this.messageTextView.setTextSize(1, 16.0f);
        this.messageTextView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.messageTextView.setMovementMethod(new AndroidUtilities.LinkMovementMethodMy());
        this.messageTextView.setLinkTextColor(getThemedColor("dialogTextLink"));
        if (!this.messageTextViewClickable) {
            this.messageTextView.setClickable(false);
            this.messageTextView.setEnabled(false);
        }
        this.messageTextView.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
        int i2 = this.progressViewStyle;
        if (i2 == 1) {
            FrameLayout frameLayout2 = new FrameLayout(getContext());
            this.progressViewContainer = frameLayout2;
            anonymousClass1.addView(frameLayout2, LayoutHelper.createLinear(-1, 44, 51, 23, this.title == null ? 24 : 0, 23, 24));
            RadialProgressView radialProgressView = new RadialProgressView(getContext(), this.resourcesProvider);
            radialProgressView.setProgressColor(getThemedColor("dialogProgressCircle"));
            this.progressViewContainer.addView(radialProgressView, LayoutHelper.createFrame(44, 44, (LocaleController.isRTL ? 5 : 3) | 48));
            this.messageTextView.setLines(1);
            this.messageTextView.setEllipsize(TextUtils.TruncateAt.END);
            FrameLayout frameLayout3 = this.progressViewContainer;
            TextView textView5 = this.messageTextView;
            boolean z2 = LocaleController.isRTL;
            frameLayout3.addView(textView5, LayoutHelper.createFrame(-2, -2.0f, (z2 ? 5 : 3) | 16, z2 ? 0 : 62, 0.0f, z2 ? 62 : 0, 0.0f));
        } else if (i2 == 2) {
            anonymousClass1.addView(this.messageTextView, LayoutHelper.createLinear(-2, -2, (LocaleController.isRTL ? 5 : 3) | 48, 24, this.title == null ? 19 : 0, 24, 20));
            LineProgressView lineProgressView = new LineProgressView(getContext());
            this.lineProgressView = lineProgressView;
            lineProgressView.setProgress(this.currentProgress / 100.0f, false);
            this.lineProgressView.setProgressColor(getThemedColor("dialogLineProgress"));
            this.lineProgressView.setBackColor(getThemedColor("dialogLineProgressBackground"));
            anonymousClass1.addView(this.lineProgressView, LayoutHelper.createLinear(-1, 4, 19, 24, 0, 24, 0));
            TextView textView6 = new TextView(getContext());
            this.lineProgressViewPercent = textView6;
            textView6.setTypeface(AndroidUtilities.getFontFamily(true));
            this.lineProgressViewPercent.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
            this.lineProgressViewPercent.setTextColor(getThemedColor("dialogTextGray2"));
            this.lineProgressViewPercent.setTextSize(1, 14.0f);
            anonymousClass1.addView(this.lineProgressViewPercent, LayoutHelper.createLinear(-2, -2, (LocaleController.isRTL ? 5 : 3) | 48, 23, 4, 23, 24));
            updateLineProgressTextView();
        } else if (i2 == 3) {
            setCanceledOnTouchOutside(false);
            setCancelable(false);
            FrameLayout frameLayout4 = new FrameLayout(getContext());
            this.progressViewContainer = frameLayout4;
            frameLayout4.setBackgroundDrawable(Theme.createRoundRectDrawable(AndroidUtilities.dp(18.0f), getThemedColor("dialog_inlineProgressBackground")));
            anonymousClass1.addView(this.progressViewContainer, LayoutHelper.createLinear(86, 86, 17));
            RadialProgressView radialProgressView2 = new RadialProgressView(getContext(), this.resourcesProvider);
            radialProgressView2.setProgressColor(getThemedColor("dialog_inlineProgress"));
            this.progressViewContainer.addView(radialProgressView2, LayoutHelper.createLinear(86, 86));
        } else {
            this.scrollContainer.addView(this.messageTextView, LayoutHelper.createLinear(-2, -2, (LocaleController.isRTL ? 5 : 3) | 48, 24, 0, 24, (this.customView == null && this.items == null) ? 0 : this.customViewOffset));
        }
        if (!TextUtils.isEmpty(this.message)) {
            this.messageTextView.setText(this.message);
            this.messageTextView.setVisibility(0);
        } else {
            this.messageTextView.setVisibility(8);
        }
        if (this.items != null) {
            int i3 = 0;
            while (true) {
                CharSequence[] charSequenceArr = this.items;
                if (i3 >= charSequenceArr.length) {
                    break;
                }
                if (charSequenceArr[i3] != null) {
                    AlertDialogCell alertDialogCell = new AlertDialogCell(getContext(), this.resourcesProvider);
                    CharSequence charSequence = this.items[i3];
                    int[] iArr = this.itemIcons;
                    alertDialogCell.setTextAndIcon(charSequence, iArr != null ? iArr[i3] : 0);
                    alertDialogCell.setTag(Integer.valueOf(i3));
                    this.itemViews.add(alertDialogCell);
                    this.scrollContainer.addView(alertDialogCell, LayoutHelper.createLinear(-1, 50));
                    alertDialogCell.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.ActionBar.-$$Lambda$AlertDialog$CSbZyWhCPQ_ms7Zqyiksr3788HY
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            this.f$0.lambda$onCreate$1$AlertDialog(view2);
                        }
                    });
                }
                i3++;
            }
        }
        View view2 = this.customView;
        if (view2 != null) {
            if (view2.getParent() != null) {
                ((ViewGroup) this.customView.getParent()).removeView(this.customView);
            }
            this.scrollContainer.addView(this.customView, LayoutHelper.createLinear(-1, this.customViewHeight));
        }
        if (z) {
            if (!this.verticalButtons) {
                TextPaint textPaint = new TextPaint();
                textPaint.setTextSize(AndroidUtilities.dp(14.0f));
                CharSequence charSequence2 = this.positiveButtonText;
                int iMeasureText = charSequence2 != null ? (int) (0 + textPaint.measureText(charSequence2, 0, charSequence2.length()) + AndroidUtilities.dp(10.0f)) : 0;
                CharSequence charSequence3 = this.negativeButtonText;
                if (charSequence3 != null) {
                    iMeasureText = (int) (iMeasureText + textPaint.measureText(charSequence3, 0, charSequence3.length()) + AndroidUtilities.dp(10.0f));
                }
                CharSequence charSequence4 = this.neutralButtonText;
                if (charSequence4 != null) {
                    iMeasureText = (int) (iMeasureText + textPaint.measureText(charSequence4, 0, charSequence4.length()) + AndroidUtilities.dp(10.0f));
                }
                if (iMeasureText > AndroidUtilities.dp(320.0f)) {
                    this.verticalButtons = true;
                }
            }
            if (this.verticalButtons) {
                LinearLayout linearLayout2 = new LinearLayout(getContext());
                linearLayout2.setOrientation(1);
                this.buttonsLayout = linearLayout2;
            } else {
                this.buttonsLayout = new FrameLayout(getContext()) { // from class: ir.eitaa.ui.ActionBar.AlertDialog.3
                    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
                    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
                        int left2;
                        int top2;
                        int childCount = getChildCount();
                        int i4 = right - left;
                        View view3 = null;
                        for (int i5 = 0; i5 < childCount; i5++) {
                            View childAt = getChildAt(i5);
                            Integer num = (Integer) childAt.getTag();
                            if (num != null) {
                                if (num.intValue() == -1) {
                                    if (LocaleController.isRTL) {
                                        childAt.layout(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + childAt.getMeasuredWidth(), getPaddingTop() + childAt.getMeasuredHeight());
                                    } else {
                                        childAt.layout((i4 - getPaddingRight()) - childAt.getMeasuredWidth(), getPaddingTop(), i4 - getPaddingRight(), getPaddingTop() + childAt.getMeasuredHeight());
                                    }
                                    view3 = childAt;
                                } else if (num.intValue() == -2) {
                                    if (LocaleController.isRTL) {
                                        int paddingLeft = getPaddingLeft();
                                        if (view3 != null) {
                                            paddingLeft += view3.getMeasuredWidth() + AndroidUtilities.dp(8.0f);
                                        }
                                        childAt.layout(paddingLeft, getPaddingTop(), childAt.getMeasuredWidth() + paddingLeft, getPaddingTop() + childAt.getMeasuredHeight());
                                    } else {
                                        int paddingRight = (i4 - getPaddingRight()) - childAt.getMeasuredWidth();
                                        if (view3 != null) {
                                            paddingRight -= view3.getMeasuredWidth() + AndroidUtilities.dp(8.0f);
                                        }
                                        childAt.layout(paddingRight, getPaddingTop(), childAt.getMeasuredWidth() + paddingRight, getPaddingTop() + childAt.getMeasuredHeight());
                                    }
                                } else if (num.intValue() == -3) {
                                    if (LocaleController.isRTL) {
                                        childAt.layout((i4 - getPaddingRight()) - childAt.getMeasuredWidth(), getPaddingTop(), i4 - getPaddingRight(), getPaddingTop() + childAt.getMeasuredHeight());
                                    } else {
                                        childAt.layout(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + childAt.getMeasuredWidth(), getPaddingTop() + childAt.getMeasuredHeight());
                                    }
                                }
                            } else {
                                int measuredWidth = childAt.getMeasuredWidth();
                                int measuredHeight = childAt.getMeasuredHeight();
                                if (view3 != null) {
                                    left2 = view3.getLeft() + ((view3.getMeasuredWidth() - measuredWidth) / 2);
                                    top2 = view3.getTop() + ((view3.getMeasuredHeight() - measuredHeight) / 2);
                                } else {
                                    left2 = 0;
                                    top2 = 0;
                                }
                                childAt.layout(left2, top2, measuredWidth + left2, measuredHeight + top2);
                            }
                        }
                    }

                    @Override // android.widget.FrameLayout, android.view.View
                    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
                        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
                        int childCount = getChildCount();
                        int measuredWidth2 = 0;
                        for (int i4 = 0; i4 < childCount; i4++) {
                            View childAt = getChildAt(i4);
                            if ((childAt instanceof TextView) && childAt.getTag() != null) {
                                measuredWidth2 += childAt.getMeasuredWidth();
                            }
                        }
                        if (measuredWidth2 > measuredWidth) {
                            View viewFindViewWithTag = findViewWithTag(-2);
                            View viewFindViewWithTag2 = findViewWithTag(-3);
                            if (viewFindViewWithTag == null || viewFindViewWithTag2 == null) {
                                return;
                            }
                            if (viewFindViewWithTag.getMeasuredWidth() < viewFindViewWithTag2.getMeasuredWidth()) {
                                viewFindViewWithTag2.measure(View.MeasureSpec.makeMeasureSpec(viewFindViewWithTag2.getMeasuredWidth() - (measuredWidth2 - measuredWidth), 1073741824), View.MeasureSpec.makeMeasureSpec(viewFindViewWithTag2.getMeasuredHeight(), 1073741824));
                            } else {
                                viewFindViewWithTag.measure(View.MeasureSpec.makeMeasureSpec(viewFindViewWithTag.getMeasuredWidth() - (measuredWidth2 - measuredWidth), 1073741824), View.MeasureSpec.makeMeasureSpec(viewFindViewWithTag.getMeasuredHeight(), 1073741824));
                            }
                        }
                    }
                };
            }
            this.buttonsLayout.setPadding(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f));
            anonymousClass1.addView(this.buttonsLayout, LayoutHelper.createLinear(-1, 52));
            if (this.positiveButtonText != null) {
                TextView textView7 = new TextView(getContext()) { // from class: ir.eitaa.ui.ActionBar.AlertDialog.4
                    @Override // android.widget.TextView, android.view.View
                    public void setEnabled(boolean enabled) {
                        super.setEnabled(enabled);
                        setAlpha(enabled ? 1.0f : 0.5f);
                    }

                    @Override // android.widget.TextView
                    public void setTextColor(int color) {
                        super.setTextColor(color);
                        setBackgroundDrawable(Theme.getRoundRectSelectorDrawable(color));
                    }
                };
                textView7.setMinWidth(AndroidUtilities.dp(64.0f));
                textView7.setTag(-1);
                textView7.setTextSize(1, 14.0f);
                textView7.setTextColor(getThemedColor(this.dialogButtonColorKey));
                textView7.setGravity(17);
                textView7.setTypeface(AndroidUtilities.getFontFamily(true));
                textView7.setText(this.positiveButtonText.toString().toUpperCase());
                textView7.setBackgroundDrawable(Theme.getRoundRectSelectorDrawable(getThemedColor(this.dialogButtonColorKey)));
                textView7.setPadding(AndroidUtilities.dp(10.0f), 0, AndroidUtilities.dp(10.0f), 0);
                if (this.verticalButtons) {
                    this.buttonsLayout.addView(textView7, LayoutHelper.createLinear(-2, 36, LocaleController.isRTL ? 3 : 5));
                } else {
                    this.buttonsLayout.addView(textView7, LayoutHelper.createFrame(-2, 36, 53));
                }
                textView7.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.ActionBar.-$$Lambda$AlertDialog$WC6mpfo0YAme-Os7SMLlb3ma2II
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        this.f$0.lambda$onCreate$2$AlertDialog(view3);
                    }
                });
            }
            if (this.negativeButtonText != null) {
                TextView textView8 = new TextView(getContext()) { // from class: ir.eitaa.ui.ActionBar.AlertDialog.5
                    @Override // android.widget.TextView, android.view.View
                    public void setEnabled(boolean enabled) {
                        super.setEnabled(enabled);
                        setAlpha(enabled ? 1.0f : 0.5f);
                    }

                    @Override // android.widget.TextView
                    public void setTextColor(int color) {
                        super.setTextColor(color);
                        setBackgroundDrawable(Theme.getRoundRectSelectorDrawable(color));
                    }
                };
                textView8.setMinWidth(AndroidUtilities.dp(64.0f));
                textView8.setTag(-2);
                textView8.setTextSize(1, 14.0f);
                textView8.setTextColor(getThemedColor(this.dialogButtonColorKey));
                textView8.setGravity(17);
                textView8.setTypeface(AndroidUtilities.getFontFamily(true));
                textView8.setEllipsize(TextUtils.TruncateAt.END);
                textView8.setSingleLine(true);
                textView8.setText(this.negativeButtonText.toString().toUpperCase());
                textView8.setBackgroundDrawable(Theme.getRoundRectSelectorDrawable(getThemedColor(this.dialogButtonColorKey)));
                textView8.setPadding(AndroidUtilities.dp(10.0f), 0, AndroidUtilities.dp(10.0f), 0);
                if (this.verticalButtons) {
                    this.buttonsLayout.addView(textView8, 0, LayoutHelper.createLinear(-2, 36, LocaleController.isRTL ? 3 : 5));
                } else {
                    this.buttonsLayout.addView(textView8, LayoutHelper.createFrame(-2, 36, 53));
                }
                textView8.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.ActionBar.-$$Lambda$AlertDialog$-TOs1SOkcKfcAGxtKPsYAk8mj5s
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        this.f$0.lambda$onCreate$3$AlertDialog(view3);
                    }
                });
            }
            if (this.neutralButtonText != null) {
                TextView textView9 = new TextView(getContext()) { // from class: ir.eitaa.ui.ActionBar.AlertDialog.6
                    @Override // android.widget.TextView, android.view.View
                    public void setEnabled(boolean enabled) {
                        super.setEnabled(enabled);
                        setAlpha(enabled ? 1.0f : 0.5f);
                    }

                    @Override // android.widget.TextView
                    public void setTextColor(int color) {
                        super.setTextColor(color);
                        setBackgroundDrawable(Theme.getRoundRectSelectorDrawable(color));
                    }
                };
                textView9.setMinWidth(AndroidUtilities.dp(64.0f));
                textView9.setTag(-3);
                textView9.setTextSize(1, 14.0f);
                textView9.setTextColor(getThemedColor(this.dialogButtonColorKey));
                textView9.setGravity(17);
                textView9.setTypeface(AndroidUtilities.getFontFamily(true));
                textView9.setEllipsize(TextUtils.TruncateAt.END);
                textView9.setSingleLine(true);
                textView9.setText(this.neutralButtonText.toString().toUpperCase());
                textView9.setBackgroundDrawable(this.isDifferentNeutralButton ? Theme.createRoundRectDrawable(AndroidUtilities.dp(8.0f), ColorUtils.setAlphaComponent(Theme.getColor(this.dialogButtonColorKey), 50)) : Theme.getRoundRectSelectorDrawable(getThemedColor(this.dialogButtonColorKey)));
                textView9.setPadding(AndroidUtilities.dp(10.0f), 0, AndroidUtilities.dp(10.0f), 0);
                if (this.verticalButtons) {
                    this.buttonsLayout.addView(textView9, 1, LayoutHelper.createLinear(-2, 36, LocaleController.isRTL ? 3 : 5));
                } else {
                    this.buttonsLayout.addView(textView9, LayoutHelper.createFrame(-2, 36, 51));
                }
                textView9.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.ActionBar.-$$Lambda$AlertDialog$DD43rG6-F-BXk5smzadLfmaCMDA
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        this.f$0.lambda$onCreate$4$AlertDialog(view3);
                    }
                });
            }
            if (this.verticalButtons) {
                for (int i4 = 1; i4 < this.buttonsLayout.getChildCount(); i4++) {
                    ((ViewGroup.MarginLayoutParams) this.buttonsLayout.getChildAt(i4).getLayoutParams()).topMargin = AndroidUtilities.dp(6.0f);
                }
            }
        }
        Window window = getWindow();
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(window.getAttributes());
        if (this.progressViewStyle == 3) {
            layoutParams.width = -1;
        } else {
            if (this.dimEnabled) {
                layoutParams.dimAmount = 0.6f;
                layoutParams.flags |= 2;
            }
            int i5 = AndroidUtilities.displaySize.x;
            this.lastScreenWidth = i5;
            int iDp2 = i5 - AndroidUtilities.dp(48.0f);
            if (AndroidUtilities.isTablet()) {
                if (AndroidUtilities.isSmallTablet()) {
                    iDp = AndroidUtilities.dp(446.0f);
                } else {
                    iDp = AndroidUtilities.dp(496.0f);
                }
            } else {
                iDp = AndroidUtilities.dp(356.0f);
            }
            int iMin = Math.min(iDp, iDp2);
            Rect rect2 = this.backgroundPaddings;
            layoutParams.width = iMin + rect2.left + rect2.right;
        }
        View view3 = this.customView;
        if (view3 != null && this.checkFocusable && canTextInput(view3)) {
            layoutParams.softInputMode = 4;
        } else {
            layoutParams.flags |= 131072;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            layoutParams.layoutInDisplayCutoutMode = 0;
        }
        window.setAttributes(layoutParams);
    }

    /* renamed from: ir.eitaa.ui.ActionBar.AlertDialog$1, reason: invalid class name */
    class AnonymousClass1 extends LinearLayout {
        private boolean inLayout;

        @Override // android.view.View
        public boolean hasOverlappingRendering() {
            return false;
        }

        AnonymousClass1(Context context) {
            super(context);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent event) {
            if (AlertDialog.this.progressViewStyle == 3) {
                AlertDialog.this.showCancelAlert();
                return false;
            }
            return super.onTouchEvent(event);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent ev) {
            if (AlertDialog.this.progressViewStyle == 3) {
                AlertDialog.this.showCancelAlert();
                return false;
            }
            return super.onInterceptTouchEvent(ev);
        }

        /* JADX WARN: Removed duplicated region for block: B:85:0x032d  */
        @Override // android.widget.LinearLayout, android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected void onMeasure(int r13, int r14) {
            /*
                Method dump skipped, instructions count: 940
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ActionBar.AlertDialog.AnonymousClass1.onMeasure(int, int):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onMeasure$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onMeasure$0$AlertDialog$1() {
            int iDp;
            AlertDialog.this.lastScreenWidth = AndroidUtilities.displaySize.x;
            int iDp2 = AndroidUtilities.displaySize.x - AndroidUtilities.dp(56.0f);
            if (AndroidUtilities.isTablet()) {
                if (AndroidUtilities.isSmallTablet()) {
                    iDp = AndroidUtilities.dp(446.0f);
                } else {
                    iDp = AndroidUtilities.dp(496.0f);
                }
            } else {
                iDp = AndroidUtilities.dp(356.0f);
            }
            Window window = AlertDialog.this.getWindow();
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.copyFrom(window.getAttributes());
            layoutParams.width = Math.min(iDp, iDp2) + AlertDialog.this.backgroundPaddings.left + AlertDialog.this.backgroundPaddings.right;
            try {
                window.setAttributes(layoutParams);
            } catch (Throwable th) {
                FileLog.e(th);
            }
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean changed, int l, int t, int r, int b) {
            super.onLayout(changed, l, t, r, b);
            if (AlertDialog.this.progressViewStyle == 3) {
                int measuredWidth = ((r - l) - AlertDialog.this.progressViewContainer.getMeasuredWidth()) / 2;
                int measuredHeight = ((b - t) - AlertDialog.this.progressViewContainer.getMeasuredHeight()) / 2;
                AlertDialog.this.progressViewContainer.layout(measuredWidth, measuredHeight, AlertDialog.this.progressViewContainer.getMeasuredWidth() + measuredWidth, AlertDialog.this.progressViewContainer.getMeasuredHeight() + measuredHeight);
            } else if (AlertDialog.this.contentScrollView != null) {
                if (AlertDialog.this.onScrollChangedListener == null) {
                    AlertDialog.this.onScrollChangedListener = new ViewTreeObserver.OnScrollChangedListener() { // from class: ir.eitaa.ui.ActionBar.-$$Lambda$AlertDialog$1$49tA5W4fDOxxV9tb6Km-pJICXr4
                        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                        public final void onScrollChanged() {
                            this.f$0.lambda$onLayout$1$AlertDialog$1();
                        }
                    };
                    AlertDialog.this.contentScrollView.getViewTreeObserver().addOnScrollChangedListener(AlertDialog.this.onScrollChangedListener);
                }
                AlertDialog.this.onScrollChangedListener.onScrollChanged();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onLayout$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onLayout$1$AlertDialog$1() {
            AlertDialog alertDialog = AlertDialog.this;
            boolean z = false;
            alertDialog.runShadowAnimation(0, alertDialog.titleTextView != null && AlertDialog.this.contentScrollView.getScrollY() > AlertDialog.this.scrollContainer.getTop());
            AlertDialog alertDialog2 = AlertDialog.this;
            if (alertDialog2.buttonsLayout != null && alertDialog2.contentScrollView.getScrollY() + AlertDialog.this.contentScrollView.getHeight() < AlertDialog.this.scrollContainer.getBottom()) {
                z = true;
            }
            alertDialog2.runShadowAnimation(1, z);
            AlertDialog.this.contentScrollView.invalidate();
        }

        @Override // android.view.View, android.view.ViewParent
        public void requestLayout() {
            if (this.inLayout) {
                return;
            }
            super.requestLayout();
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            if (AlertDialog.this.drawBackground) {
                AlertDialog.this.shadowDrawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
                if (AlertDialog.this.topView == null || !AlertDialog.this.notDrawBackgroundOnTopView) {
                    AlertDialog.this.shadowDrawable.draw(canvas);
                } else {
                    int bottom = AlertDialog.this.topView.getBottom();
                    canvas.save();
                    canvas.clipRect(0, bottom, getMeasuredWidth(), getMeasuredHeight());
                    AlertDialog.this.shadowDrawable.draw(canvas);
                    canvas.restore();
                }
            }
            super.dispatchDraw(canvas);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onCreate$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onCreate$1$AlertDialog(View view) {
        DialogInterface.OnClickListener onClickListener = this.onClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(this, ((Integer) view.getTag()).intValue());
        }
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onCreate$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onCreate$2$AlertDialog(View view) {
        DialogInterface.OnClickListener onClickListener = this.positiveButtonListener;
        if (onClickListener != null) {
            onClickListener.onClick(this, -1);
        }
        if (this.dismissDialogByButtons) {
            dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onCreate$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onCreate$3$AlertDialog(View view) {
        DialogInterface.OnClickListener onClickListener = this.negativeButtonListener;
        if (onClickListener != null) {
            onClickListener.onClick(this, -2);
        }
        if (this.dismissDialogByButtons) {
            cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onCreate$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onCreate$4$AlertDialog(View view) {
        DialogInterface.OnClickListener onClickListener = this.neutralButtonListener;
        if (onClickListener != null) {
            onClickListener.onClick(this, -2);
        }
        if (this.dismissDialogByButtons) {
            dismiss();
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        DialogInterface.OnClickListener onClickListener = this.onBackButtonListener;
        if (onClickListener != null) {
            onClickListener.onClick(this, -2);
        }
    }

    public void setFocusable(boolean value) {
        if (this.focusable == value) {
            return;
        }
        this.focusable = value;
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (this.focusable) {
            attributes.softInputMode = 16;
            attributes.flags &= -131073;
        } else {
            attributes.softInputMode = 48;
            attributes.flags |= 131072;
        }
        window.setAttributes(attributes);
    }

    public void setBackgroundColor(int color) {
        this.shadowDrawable.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.MULTIPLY));
    }

    public void setTextColor(int color) {
        TextView textView = this.titleTextView;
        if (textView != null) {
            textView.setTextColor(color);
        }
        TextView textView2 = this.messageTextView;
        if (textView2 != null) {
            textView2.setTextColor(color);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showCancelAlert() {
        if (this.canCacnel && this.cancelDialog == null) {
            Builder builder = new Builder(getContext());
            builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
            builder.setMessage(LocaleController.getString("StopLoading", R.string.StopLoading));
            builder.setPositiveButton(LocaleController.getString("WaitMore", R.string.WaitMore), null);
            builder.setNegativeButton(LocaleController.getString("Stop", R.string.Stop), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.ActionBar.-$$Lambda$AlertDialog$iwnUUVJs3UzYb1ENHiQQtTX06Eo
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$showCancelAlert$5$AlertDialog(dialogInterface, i);
                }
            });
            builder.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: ir.eitaa.ui.ActionBar.-$$Lambda$AlertDialog$RfT4ecy2VBYKjTAt_xfVd_OHQL8
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    this.f$0.lambda$showCancelAlert$6$AlertDialog(dialogInterface);
                }
            });
            try {
                this.cancelDialog = builder.show();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showCancelAlert$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showCancelAlert$5$AlertDialog(DialogInterface dialogInterface, int i) {
        DialogInterface.OnCancelListener onCancelListener = this.onCancelListener;
        if (onCancelListener != null) {
            onCancelListener.onCancel(this);
        }
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showCancelAlert$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showCancelAlert$6$AlertDialog(DialogInterface dialogInterface) {
        this.cancelDialog = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runShadowAnimation(final int num, final boolean show) {
        if ((!show || this.shadowVisibility[num]) && (show || !this.shadowVisibility[num])) {
            return;
        }
        this.shadowVisibility[num] = show;
        AnimatorSet[] animatorSetArr = this.shadowAnimation;
        if (animatorSetArr[num] != null) {
            animatorSetArr[num].cancel();
        }
        this.shadowAnimation[num] = new AnimatorSet();
        BitmapDrawable[] bitmapDrawableArr = this.shadow;
        if (bitmapDrawableArr[num] != null) {
            AnimatorSet animatorSet = this.shadowAnimation[num];
            Animator[] animatorArr = new Animator[1];
            BitmapDrawable bitmapDrawable = bitmapDrawableArr[num];
            int[] iArr = new int[1];
            iArr[0] = show ? 255 : 0;
            animatorArr[0] = ObjectAnimator.ofInt(bitmapDrawable, "alpha", iArr);
            animatorSet.playTogether(animatorArr);
        }
        this.shadowAnimation[num].setDuration(150L);
        this.shadowAnimation[num].addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.ActionBar.AlertDialog.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                if (AlertDialog.this.shadowAnimation[num] == null || !AlertDialog.this.shadowAnimation[num].equals(animation)) {
                    return;
                }
                AlertDialog.this.shadowAnimation[num] = null;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                if (AlertDialog.this.shadowAnimation[num] == null || !AlertDialog.this.shadowAnimation[num].equals(animation)) {
                    return;
                }
                AlertDialog.this.shadowAnimation[num] = null;
            }
        });
        try {
            this.shadowAnimation[num].start();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void setProgress(int progress) {
        this.currentProgress = progress;
        LineProgressView lineProgressView = this.lineProgressView;
        if (lineProgressView != null) {
            lineProgressView.setProgress(progress / 100.0f, true);
            updateLineProgressTextView();
        }
    }

    private void updateLineProgressTextView() {
        this.lineProgressViewPercent.setText(String.format("%d%%", Integer.valueOf(this.currentProgress)));
    }

    public void setCanCacnel(boolean value) {
        this.canCacnel = value;
    }

    private boolean canTextInput(View v) {
        if (v.onCheckIsTextEditor()) {
            return true;
        }
        if (!(v instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) v;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (canTextInput(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        DialogInterface.OnDismissListener onDismissListener = this.onDismissListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(this);
        }
        AlertDialog alertDialog = this.cancelDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        try {
            super.dismiss();
        } catch (Throwable unused) {
        }
        AndroidUtilities.cancelRunOnUIThread(this.showRunnable);
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean cancel) {
        super.setCanceledOnTouchOutside(cancel);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence text) {
        this.title = text;
        TextView textView = this.titleTextView;
        if (textView != null) {
            textView.setText(text);
        }
    }

    public void setNegativeButton(CharSequence text, final DialogInterface.OnClickListener listener) {
        this.negativeButtonText = text;
        this.negativeButtonListener = listener;
    }

    public void setNeutralButton(CharSequence text, final DialogInterface.OnClickListener listener) {
        this.neutralButtonText = text;
        this.neutralButtonListener = listener;
    }

    public void setItemColor(int item, int color, int icon) {
        if (item < 0 || item >= this.itemViews.size()) {
            return;
        }
        AlertDialogCell alertDialogCell = this.itemViews.get(item);
        alertDialogCell.textView.setTextColor(color);
        alertDialogCell.imageView.setColorFilter(new PorterDuffColorFilter(icon, PorterDuff.Mode.MULTIPLY));
    }

    public int getItemsCount() {
        return this.itemViews.size();
    }

    public void setMessage(CharSequence text) {
        this.message = text;
        if (this.messageTextView != null) {
            if (!TextUtils.isEmpty(text)) {
                this.messageTextView.setText(this.message);
                this.messageTextView.setVisibility(0);
            } else {
                this.messageTextView.setVisibility(8);
            }
        }
    }

    public void setButton(int type, CharSequence text, final DialogInterface.OnClickListener listener) {
        if (type == -3) {
            this.neutralButtonText = text;
            this.neutralButtonListener = listener;
        } else if (type == -2) {
            this.negativeButtonText = text;
            this.negativeButtonListener = listener;
        } else {
            if (type != -1) {
                return;
            }
            this.positiveButtonText = text;
            this.positiveButtonListener = listener;
        }
    }

    public View getButton(int type) {
        ViewGroup viewGroup = this.buttonsLayout;
        if (viewGroup != null) {
            return viewGroup.findViewWithTag(Integer.valueOf(type));
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable who) {
        this.contentScrollView.invalidate();
        this.scrollContainer.invalidate();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        ScrollView scrollView = this.contentScrollView;
        if (scrollView != null) {
            scrollView.postDelayed(what, when);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable who, Runnable what) {
        ScrollView scrollView = this.contentScrollView;
        if (scrollView != null) {
            scrollView.removeCallbacks(what);
        }
    }

    @Override // android.app.Dialog
    public void setOnCancelListener(DialogInterface.OnCancelListener listener) {
        this.onCancelListener = listener;
        super.setOnCancelListener(listener);
    }

    public void setPositiveButtonListener(final DialogInterface.OnClickListener listener) {
        this.positiveButtonListener = listener;
    }

    protected int getThemedColor(String key) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
        return color != null ? color.intValue() : Theme.getColor(key);
    }

    public void showDelayed(long delay) {
        AndroidUtilities.cancelRunOnUIThread(this.showRunnable);
        AndroidUtilities.runOnUIThread(this.showRunnable, delay);
    }

    public static class Builder {
        private AlertDialog alertDialog;

        protected Builder(AlertDialog alert) {
            this.alertDialog = alert;
        }

        public Builder(Context context) {
            this(context, null);
        }

        public Builder(Context context, Theme.ResourcesProvider resourcesProvider) {
            this(context, 0, resourcesProvider);
        }

        public Builder(Context context, int progressViewStyle, Theme.ResourcesProvider resourcesProvider) {
            this.alertDialog = new AlertDialog(context, progressViewStyle, resourcesProvider);
        }

        public Context getContext() {
            return this.alertDialog.getContext();
        }

        public Builder setItems(CharSequence[] items, final DialogInterface.OnClickListener onClickListener) {
            this.alertDialog.items = items;
            this.alertDialog.onClickListener = onClickListener;
            return this;
        }

        public Builder setCheckFocusable(boolean value) {
            this.alertDialog.checkFocusable = value;
            return this;
        }

        public Builder setItems(CharSequence[] items, int[] icons, final DialogInterface.OnClickListener onClickListener) {
            this.alertDialog.items = items;
            this.alertDialog.itemIcons = icons;
            this.alertDialog.onClickListener = onClickListener;
            return this;
        }

        public Builder setView(View view) {
            return setView(view, -2);
        }

        public Builder setView(View view, int height) {
            this.alertDialog.customView = view;
            this.alertDialog.customViewHeight = height;
            return this;
        }

        public Builder setTitle(CharSequence title) {
            this.alertDialog.title = title;
            return this;
        }

        public Builder setSubtitle(CharSequence subtitle) {
            this.alertDialog.subtitle = subtitle;
            return this;
        }

        public Builder setTopImage(int resId, int backgroundColor) {
            this.alertDialog.topResId = resId;
            this.alertDialog.topBackgroundColor = backgroundColor;
            return this;
        }

        public Builder setTopView(View view) {
            this.alertDialog.topView = view;
            return this;
        }

        public Builder setDialogButtonColorKey(String key) {
            this.alertDialog.dialogButtonColorKey = key;
            return this;
        }

        public Builder setMessage(CharSequence message) {
            this.alertDialog.message = message;
            return this;
        }

        public Builder setPositiveButton(CharSequence text, final DialogInterface.OnClickListener listener) {
            this.alertDialog.positiveButtonText = text;
            this.alertDialog.positiveButtonListener = listener;
            return this;
        }

        public Builder setNegativeButton(CharSequence text, final DialogInterface.OnClickListener listener) {
            this.alertDialog.negativeButtonText = text;
            this.alertDialog.negativeButtonListener = listener;
            return this;
        }

        public Builder setNeutralButton(CharSequence text, boolean isDifferent, final DialogInterface.OnClickListener listener) {
            this.alertDialog.isDifferentNeutralButton = isDifferent;
            return setNeutralButton(text, listener);
        }

        public Builder setNeutralButton(CharSequence text, final DialogInterface.OnClickListener listener) {
            this.alertDialog.neutralButtonText = text;
            this.alertDialog.neutralButtonListener = listener;
            return this;
        }

        public Builder setOnBackButtonListener(final DialogInterface.OnClickListener listener) {
            this.alertDialog.onBackButtonListener = listener;
            return this;
        }

        public Builder setOnCancelListener(DialogInterface.OnCancelListener listener) {
            this.alertDialog.setOnCancelListener(listener);
            return this;
        }

        public Builder setCustomViewOffset(int offset) {
            this.alertDialog.customViewOffset = offset;
            return this;
        }

        public Builder setMessageTextViewClickable(boolean value) {
            this.alertDialog.messageTextViewClickable = value;
            return this;
        }

        public AlertDialog create() {
            return this.alertDialog;
        }

        public AlertDialog show() {
            this.alertDialog.show();
            return this.alertDialog;
        }

        public Runnable getDismissRunnable() {
            return this.alertDialog.dismissRunnable;
        }

        public Builder setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
            this.alertDialog.setOnDismissListener(onDismissListener);
            return this;
        }

        public void setTopViewAspectRatio(float aspectRatio) {
            this.alertDialog.aspectRatio = aspectRatio;
        }

        public Builder setDimEnabled(boolean dimEnabled) {
            this.alertDialog.dimEnabled = dimEnabled;
            return this;
        }

        public void notDrawBackgroundOnTopView(boolean b) {
            this.alertDialog.notDrawBackgroundOnTopView = b;
        }

        public void setButtonsVertical(boolean vertical) {
            this.alertDialog.verticalButtons = vertical;
        }

        public Builder setOnPreDismissListener(DialogInterface.OnDismissListener onDismissListener) {
            this.alertDialog.onDismissListener = onDismissListener;
            return this;
        }
    }
}
