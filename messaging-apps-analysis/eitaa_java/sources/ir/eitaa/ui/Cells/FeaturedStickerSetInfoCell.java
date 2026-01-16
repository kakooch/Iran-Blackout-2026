package ir.eitaa.ui.Cells;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Property;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MediaDataController;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.tgnet.TLRPC$StickerSetCovered;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Components.ColorSpanUnderline;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.ProgressButton;
import ir.eitaa.ui.Components.RecyclerListView;
import java.util.List;

/* loaded from: classes3.dex */
public class FeaturedStickerSetInfoCell extends FrameLayout {
    private ProgressButton addButton;
    private AnimatorSet animatorSet;
    private boolean canAddRemove;
    private int currentAccount;
    private TextView delButton;
    private boolean hasOnClick;
    private TextView infoTextView;
    private boolean isInstalled;
    private boolean isUnread;
    private TextView nameTextView;
    private boolean needDivider;
    private Paint paint;
    private final Theme.ResourcesProvider resourcesProvider;
    private TLRPC$StickerSetCovered set;
    private int stickerSetNameSearchIndex;
    private int stickerSetNameSearchLength;
    float unreadProgress;
    private CharSequence url;
    private int urlSearchLength;

    public FeaturedStickerSetInfoCell(Context context, int left, boolean supportRtl, boolean canAddRemove, Theme.ResourcesProvider resourcesProvider) {
        FrameLayout.LayoutParams layoutParamsCreateFrame;
        FrameLayout.LayoutParams layoutParamsCreateFrame2;
        FrameLayout.LayoutParams layoutParamsCreateFrame3;
        FrameLayout.LayoutParams layoutParamsCreateFrame4;
        super(context);
        this.currentAccount = UserConfig.selectedAccount;
        this.paint = new Paint(1);
        this.canAddRemove = canAddRemove;
        this.resourcesProvider = resourcesProvider;
        TextView textView = new TextView(context);
        this.nameTextView = textView;
        textView.setTextColor(getThemedColor("chat_emojiPanelTrendingTitle"));
        this.nameTextView.setTextSize(1, 17.0f);
        this.nameTextView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.nameTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.nameTextView.setSingleLine(true);
        if (supportRtl) {
            layoutParamsCreateFrame = LayoutHelper.createFrameRelatively(-2.0f, -2.0f, 8388659, left, 8.0f, 40.0f, 0.0f);
        } else {
            layoutParamsCreateFrame = LayoutHelper.createFrame(-2, -2.0f, 51, left, 8.0f, 40.0f, 0.0f);
        }
        addView(this.nameTextView, layoutParamsCreateFrame);
        TextView textView2 = new TextView(context);
        this.infoTextView = textView2;
        textView2.setTextColor(getThemedColor("chat_emojiPanelTrendingDescription"));
        this.infoTextView.setTextSize(1, 13.0f);
        this.infoTextView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.infoTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.infoTextView.setSingleLine(true);
        if (supportRtl) {
            layoutParamsCreateFrame2 = LayoutHelper.createFrameRelatively(-2.0f, -2.0f, 8388659, left, 30.0f, 100.0f, 0.0f);
        } else {
            layoutParamsCreateFrame2 = LayoutHelper.createFrame(-2, -2.0f, 51, left, 30.0f, 100.0f, 0.0f);
        }
        addView(this.infoTextView, layoutParamsCreateFrame2);
        if (canAddRemove) {
            ProgressButton progressButton = new ProgressButton(context);
            this.addButton = progressButton;
            progressButton.setTextColor(getThemedColor("featuredStickers_buttonText"));
            this.addButton.setText(LocaleController.getString("Add", R.string.Add));
            if (supportRtl) {
                layoutParamsCreateFrame3 = LayoutHelper.createFrameRelatively(-2.0f, 28.0f, 8388661, 0.0f, 16.0f, 14.0f, 0.0f);
            } else {
                layoutParamsCreateFrame3 = LayoutHelper.createFrame(-2, 28.0f, 53, 0.0f, 16.0f, 14.0f, 0.0f);
            }
            addView(this.addButton, layoutParamsCreateFrame3);
            TextView textView3 = new TextView(context);
            this.delButton = textView3;
            textView3.setGravity(17);
            this.delButton.setTextColor(getThemedColor("featuredStickers_removeButtonText"));
            this.delButton.setTextSize(1, 14.0f);
            this.delButton.setTypeface(AndroidUtilities.getFontFamily(true));
            this.delButton.setText(LocaleController.getString("StickersRemove", R.string.StickersRemove));
            if (supportRtl) {
                layoutParamsCreateFrame4 = LayoutHelper.createFrameRelatively(-2.0f, 28.0f, 8388661, 0.0f, 16.0f, 14.0f, 0.0f);
            } else {
                layoutParamsCreateFrame4 = LayoutHelper.createFrame(-2, 28.0f, 53, 0.0f, 16.0f, 14.0f, 0.0f);
            }
            addView(this.delButton, layoutParamsCreateFrame4);
        }
        setWillNotDraw(false);
        updateColors();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(60.0f), 1073741824));
        if (this.canAddRemove) {
            int measuredWidth = this.addButton.getMeasuredWidth();
            int measuredWidth2 = this.delButton.getMeasuredWidth();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.delButton.getLayoutParams();
            if (measuredWidth2 < measuredWidth) {
                layoutParams.rightMargin = AndroidUtilities.dp(14.0f) + ((measuredWidth - measuredWidth2) / 2);
            } else {
                layoutParams.rightMargin = AndroidUtilities.dp(14.0f);
            }
            measureChildWithMargins(this.nameTextView, widthMeasureSpec, measuredWidth, heightMeasureSpec, 0);
        }
    }

    public void setAddOnClickListener(View.OnClickListener onClickListener) {
        if (this.canAddRemove) {
            this.hasOnClick = true;
            this.addButton.setOnClickListener(onClickListener);
            this.delButton.setOnClickListener(onClickListener);
        }
    }

    public void setAddDrawProgress(boolean drawProgress, boolean animated) {
        if (this.canAddRemove) {
            this.addButton.setDrawProgress(drawProgress, animated);
        }
    }

    public void setStickerSet(TLRPC$StickerSetCovered stickerSet, boolean unread) {
        setStickerSet(stickerSet, unread, false, 0, 0, false);
    }

    public void setStickerSet(TLRPC$StickerSetCovered stickerSet, boolean unread, boolean animated, int index, int searchLength) {
        setStickerSet(stickerSet, unread, animated, index, searchLength, false);
    }

    public void setStickerSet(TLRPC$StickerSetCovered stickerSet, boolean unread, boolean animated, int index, int searchLength, boolean forceInstalled) {
        AnimatorSet animatorSet = this.animatorSet;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.animatorSet = null;
        }
        if (this.set != stickerSet) {
            this.unreadProgress = unread ? 1.0f : 0.0f;
            invalidate();
        }
        this.set = stickerSet;
        this.stickerSetNameSearchIndex = index;
        this.stickerSetNameSearchLength = searchLength;
        if (searchLength != 0) {
            updateStickerSetNameSearchSpan();
        } else {
            this.nameTextView.setText(stickerSet.set.title);
        }
        this.infoTextView.setText(LocaleController.formatPluralString("Stickers", stickerSet.set.count));
        this.isUnread = unread;
        if (this.canAddRemove) {
            if (this.hasOnClick) {
                this.addButton.setVisibility(0);
                boolean z = forceInstalled || MediaDataController.getInstance(this.currentAccount).isStickerPackInstalled(stickerSet.set.id);
                this.isInstalled = z;
                if (!animated) {
                    if (z) {
                        this.delButton.setVisibility(0);
                        this.delButton.setAlpha(1.0f);
                        this.delButton.setScaleX(1.0f);
                        this.delButton.setScaleY(1.0f);
                        this.addButton.setVisibility(4);
                        this.addButton.setAlpha(0.0f);
                        this.addButton.setScaleX(0.0f);
                        this.addButton.setScaleY(0.0f);
                        return;
                    }
                    this.addButton.setVisibility(0);
                    this.addButton.setAlpha(1.0f);
                    this.addButton.setScaleX(1.0f);
                    this.addButton.setScaleY(1.0f);
                    this.delButton.setVisibility(4);
                    this.delButton.setAlpha(0.0f);
                    this.delButton.setScaleX(0.0f);
                    this.delButton.setScaleY(0.0f);
                    return;
                }
                if (z) {
                    this.delButton.setVisibility(0);
                } else {
                    this.addButton.setVisibility(0);
                }
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.animatorSet = animatorSet2;
                animatorSet2.setDuration(250L);
                AnimatorSet animatorSet3 = this.animatorSet;
                Animator[] animatorArr = new Animator[6];
                TextView textView = this.delButton;
                Property property = View.ALPHA;
                float[] fArr = new float[1];
                fArr[0] = this.isInstalled ? 1.0f : 0.0f;
                animatorArr[0] = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) property, fArr);
                TextView textView2 = this.delButton;
                Property property2 = View.SCALE_X;
                float[] fArr2 = new float[1];
                fArr2[0] = this.isInstalled ? 1.0f : 0.0f;
                animatorArr[1] = ObjectAnimator.ofFloat(textView2, (Property<TextView, Float>) property2, fArr2);
                TextView textView3 = this.delButton;
                Property property3 = View.SCALE_Y;
                float[] fArr3 = new float[1];
                fArr3[0] = this.isInstalled ? 1.0f : 0.0f;
                animatorArr[2] = ObjectAnimator.ofFloat(textView3, (Property<TextView, Float>) property3, fArr3);
                ProgressButton progressButton = this.addButton;
                Property property4 = View.ALPHA;
                float[] fArr4 = new float[1];
                fArr4[0] = this.isInstalled ? 0.0f : 1.0f;
                animatorArr[3] = ObjectAnimator.ofFloat(progressButton, (Property<ProgressButton, Float>) property4, fArr4);
                ProgressButton progressButton2 = this.addButton;
                Property property5 = View.SCALE_X;
                float[] fArr5 = new float[1];
                fArr5[0] = this.isInstalled ? 0.0f : 1.0f;
                animatorArr[4] = ObjectAnimator.ofFloat(progressButton2, (Property<ProgressButton, Float>) property5, fArr5);
                ProgressButton progressButton3 = this.addButton;
                Property property6 = View.SCALE_Y;
                float[] fArr6 = new float[1];
                fArr6[0] = this.isInstalled ? 0.0f : 1.0f;
                animatorArr[5] = ObjectAnimator.ofFloat(progressButton3, (Property<ProgressButton, Float>) property6, fArr6);
                animatorSet3.playTogether(animatorArr);
                this.animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Cells.FeaturedStickerSetInfoCell.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        if (FeaturedStickerSetInfoCell.this.isInstalled) {
                            FeaturedStickerSetInfoCell.this.addButton.setVisibility(4);
                        } else {
                            FeaturedStickerSetInfoCell.this.delButton.setVisibility(4);
                        }
                    }
                });
                this.animatorSet.setInterpolator(new OvershootInterpolator(1.02f));
                this.animatorSet.start();
                return;
            }
            this.addButton.setVisibility(8);
        }
    }

    private void updateStickerSetNameSearchSpan() {
        if (this.stickerSetNameSearchLength != 0) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.set.set.title);
            try {
                ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(getThemedColor("windowBackgroundWhiteBlueText4"));
                int i = this.stickerSetNameSearchIndex;
                spannableStringBuilder.setSpan(foregroundColorSpan, i, this.stickerSetNameSearchLength + i, 33);
            } catch (Exception unused) {
            }
            this.nameTextView.setText(spannableStringBuilder);
        }
    }

    public void setUrl(CharSequence text, int searchLength) {
        this.url = text;
        this.urlSearchLength = searchLength;
        updateUrlSearchSpan();
    }

    private void updateUrlSearchSpan() {
        if (this.url != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.url);
            try {
                spannableStringBuilder.setSpan(new ColorSpanUnderline(getThemedColor("windowBackgroundWhiteBlueText4")), 0, this.urlSearchLength, 33);
                spannableStringBuilder.setSpan(new ColorSpanUnderline(getThemedColor("chat_emojiPanelTrendingDescription")), this.urlSearchLength, this.url.length(), 33);
            } catch (Exception unused) {
            }
            this.infoTextView.setText(spannableStringBuilder);
        }
    }

    public boolean isInstalled() {
        return this.isInstalled;
    }

    public TLRPC$StickerSetCovered getStickerSet() {
        return this.set;
    }

    public void setNeedDivider(boolean needDivider) {
        this.needDivider = needDivider;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0026  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onDraw(android.graphics.Canvas r8) {
        /*
            r7 = this;
            boolean r0 = r7.isUnread
            r1 = 0
            if (r0 != 0) goto Lb
            float r2 = r7.unreadProgress
            int r2 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r2 == 0) goto L6b
        Lb:
            r2 = 1042536202(0x3e23d70a, float:0.16)
            if (r0 == 0) goto L26
            float r3 = r7.unreadProgress
            r4 = 1065353216(0x3f800000, float:1.0)
            int r5 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r5 == 0) goto L26
            float r3 = r3 + r2
            r7.unreadProgress = r3
            int r0 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r0 <= 0) goto L22
            r7.unreadProgress = r4
            goto L3b
        L22:
            r7.invalidate()
            goto L3b
        L26:
            if (r0 != 0) goto L3b
            float r0 = r7.unreadProgress
            int r3 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r3 == 0) goto L3b
            float r0 = r0 - r2
            r7.unreadProgress = r0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L38
            r7.unreadProgress = r1
            goto L3b
        L38:
            r7.invalidate()
        L3b:
            android.graphics.Paint r0 = r7.paint
            java.lang.String r1 = "featuredStickers_unread"
            int r1 = r7.getThemedColor(r1)
            r0.setColor(r1)
            android.widget.TextView r0 = r7.nameTextView
            int r0 = r0.getRight()
            r1 = 1094713344(0x41400000, float:12.0)
            int r1 = ir.eitaa.messenger.AndroidUtilities.dp(r1)
            int r0 = r0 + r1
            float r0 = (float) r0
            r1 = 1101004800(0x41a00000, float:20.0)
            int r1 = ir.eitaa.messenger.AndroidUtilities.dp(r1)
            float r1 = (float) r1
            r2 = 1082130432(0x40800000, float:4.0)
            int r2 = ir.eitaa.messenger.AndroidUtilities.dp(r2)
            float r2 = (float) r2
            float r3 = r7.unreadProgress
            float r2 = r2 * r3
            android.graphics.Paint r3 = r7.paint
            r8.drawCircle(r0, r1, r2, r3)
        L6b:
            boolean r0 = r7.needDivider
            if (r0 == 0) goto L7d
            r2 = 0
            r3 = 0
            int r0 = r7.getWidth()
            float r4 = (float) r0
            r5 = 0
            android.graphics.Paint r6 = ir.eitaa.ui.ActionBar.Theme.dividerPaint
            r1 = r8
            r1.drawLine(r2, r3, r4, r5, r6)
        L7d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.FeaturedStickerSetInfoCell.onDraw(android.graphics.Canvas):void");
    }

    public void updateColors() {
        if (this.canAddRemove) {
            this.addButton.setProgressColor(getThemedColor("featuredStickers_buttonProgress"));
            this.addButton.setBackgroundRoundRect(getThemedColor("featuredStickers_addButton"), getThemedColor("featuredStickers_addButtonPressed"));
        }
        updateStickerSetNameSearchSpan();
        updateUrlSearchSpan();
    }

    public static void createThemeDescriptions(List<ThemeDescription> descriptions, RecyclerListView listView, ThemeDescription.ThemeDescriptionDelegate delegate) {
        descriptions.add(new ThemeDescription(listView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{FeaturedStickerSetInfoCell.class}, new String[]{"nameTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "chat_emojiPanelTrendingTitle"));
        descriptions.add(new ThemeDescription(listView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{FeaturedStickerSetInfoCell.class}, new String[]{"infoTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "chat_emojiPanelTrendingDescription"));
        descriptions.add(new ThemeDescription(listView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{FeaturedStickerSetInfoCell.class}, new String[]{"addButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "featuredStickers_buttonText"));
        descriptions.add(new ThemeDescription(listView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{FeaturedStickerSetInfoCell.class}, new String[]{"delButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "featuredStickers_removeButtonText"));
        descriptions.add(new ThemeDescription(listView, 0, new Class[]{FeaturedStickerSetInfoCell.class}, null, null, null, "featuredStickers_unread"));
        descriptions.add(new ThemeDescription(listView, 0, new Class[]{FeaturedStickerSetInfoCell.class}, Theme.dividerPaint, null, null, "divider"));
        descriptions.add(new ThemeDescription(null, 0, null, null, null, delegate, "featuredStickers_buttonProgress"));
        descriptions.add(new ThemeDescription(null, 0, null, null, null, delegate, "featuredStickers_addButton"));
        descriptions.add(new ThemeDescription(null, 0, null, null, null, delegate, "featuredStickers_addButtonPressed"));
        descriptions.add(new ThemeDescription(null, 0, null, null, null, delegate, "windowBackgroundWhiteBlueText4"));
        descriptions.add(new ThemeDescription(null, 0, null, null, null, delegate, "chat_emojiPanelTrendingDescription"));
    }

    private int getThemedColor(String key) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
        return color != null ? color.intValue() : Theme.getColor(key);
    }
}
