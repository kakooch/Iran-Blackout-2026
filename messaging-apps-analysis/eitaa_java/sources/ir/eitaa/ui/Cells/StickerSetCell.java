package ir.eitaa.ui.Cells;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.DocumentObject;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SvgHelper;
import ir.eitaa.tgnet.TLRPC$Document;
import ir.eitaa.tgnet.TLRPC$PhotoSize;
import ir.eitaa.tgnet.TLRPC$TL_messages_stickerSet;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.BackupImageView;
import ir.eitaa.ui.Components.CheckBox2;
import ir.eitaa.ui.Components.Easings;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.RadialProgressView;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class StickerSetCell extends FrameLayout {
    private CheckBox2 checkBox;
    private BackupImageView imageView;
    private boolean needDivider;
    private final int option;
    private ImageView optionsButton;
    private RadialProgressView progressView;
    private Rect rect;
    private ImageView reorderButton;
    private TLRPC$TL_messages_stickerSet stickersSet;
    private TextView textView;
    private TextView valueTextView;

    public StickerSetCell(Context context, int option) {
        super(context);
        this.rect = new Rect();
        this.option = option;
        TextView textView = new TextView(context);
        this.textView = textView;
        textView.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        this.textView.setTextSize(1, 16.0f);
        this.textView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.textView.setLines(1);
        this.textView.setMaxLines(1);
        this.textView.setSingleLine(true);
        this.textView.setEllipsize(TextUtils.TruncateAt.END);
        this.textView.setGravity(LayoutHelper.getAbsoluteGravityStart());
        addView(this.textView, LayoutHelper.createFrameRelatively(-2.0f, -2.0f, 8388611, 71.0f, 9.0f, 46.0f, 0.0f));
        TextView textView2 = new TextView(context);
        this.valueTextView = textView2;
        textView2.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText2"));
        this.valueTextView.setTextSize(1, 13.0f);
        this.valueTextView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.valueTextView.setLines(1);
        this.valueTextView.setMaxLines(1);
        this.valueTextView.setSingleLine(true);
        this.valueTextView.setGravity(LayoutHelper.getAbsoluteGravityStart());
        addView(this.valueTextView, LayoutHelper.createFrameRelatively(-2.0f, -2.0f, 8388611, 71.0f, 32.0f, 46.0f, 0.0f));
        BackupImageView backupImageView = new BackupImageView(context);
        this.imageView = backupImageView;
        backupImageView.setAspectFit(true);
        this.imageView.setLayerNum(1);
        BackupImageView backupImageView2 = this.imageView;
        boolean z = LocaleController.isRTL;
        addView(backupImageView2, LayoutHelper.createFrame(40, 40.0f, (z ? 5 : 3) | 48, z ? 0.0f : 13.0f, 9.0f, z ? 13.0f : 0.0f, 0.0f));
        if (option == 2) {
            RadialProgressView radialProgressView = new RadialProgressView(getContext());
            this.progressView = radialProgressView;
            radialProgressView.setProgressColor(Theme.getColor("dialogProgressCircle"));
            this.progressView.setSize(AndroidUtilities.dp(30.0f));
            RadialProgressView radialProgressView2 = this.progressView;
            boolean z2 = LocaleController.isRTL;
            addView(radialProgressView2, LayoutHelper.createFrame(48, 48.0f, (z2 ? 5 : 3) | 48, z2 ? 0.0f : 12.0f, 5.0f, z2 ? 12.0f : 0.0f, 0.0f));
            return;
        }
        if (option != 0) {
            ImageView imageView = new ImageView(context);
            this.optionsButton = imageView;
            imageView.setFocusable(false);
            this.optionsButton.setScaleType(ImageView.ScaleType.CENTER);
            this.optionsButton.setBackgroundDrawable(Theme.createSelectorDrawable(Theme.getColor("stickers_menuSelector")));
            if (option != 1) {
                if (option == 3) {
                    this.optionsButton.setColorFilter(new PorterDuffColorFilter(Theme.getColor("featuredStickers_addedIcon"), PorterDuff.Mode.MULTIPLY));
                    this.optionsButton.setImageResource(R.drawable.sticker_added);
                    ImageView imageView2 = this.optionsButton;
                    boolean z3 = LocaleController.isRTL;
                    addView(imageView2, LayoutHelper.createFrame(40, 40.0f, (z3 ? 3 : 5) | 48, z3 ? 10 : 0, 9.0f, z3 ? 0 : 10, 0.0f));
                    return;
                }
                return;
            }
            this.optionsButton.setColorFilter(new PorterDuffColorFilter(Theme.getColor("stickers_menu"), PorterDuff.Mode.MULTIPLY));
            this.optionsButton.setImageResource(R.drawable.msg_actions);
            addView(this.optionsButton, LayoutHelper.createFrame(40, 40, (LocaleController.isRTL ? 3 : 5) | 16));
            ImageView imageView3 = new ImageView(context);
            this.reorderButton = imageView3;
            imageView3.setAlpha(0.0f);
            this.reorderButton.setVisibility(8);
            this.reorderButton.setScaleType(ImageView.ScaleType.CENTER);
            this.reorderButton.setImageResource(R.drawable.list_reorder);
            this.reorderButton.setColorFilter(new PorterDuffColorFilter(Theme.getColor("stickers_menu"), PorterDuff.Mode.MULTIPLY));
            addView(this.reorderButton, LayoutHelper.createFrameRelatively(58.0f, 58.0f, 8388613));
            CheckBox2 checkBox2 = new CheckBox2(context, 21);
            this.checkBox = checkBox2;
            checkBox2.setColor(null, "windowBackgroundWhite", "checkboxCheck");
            this.checkBox.setDrawUnchecked(false);
            this.checkBox.setDrawBackgroundAsArc(3);
            addView(this.checkBox, LayoutHelper.createFrameRelatively(24.0f, 24.0f, 8388611, 34.0f, 30.0f, 0.0f, 0.0f));
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(58.0f) + (this.needDivider ? 1 : 0), 1073741824));
    }

    public void setText(String title, String subtitle, int icon, boolean divider) throws Resources.NotFoundException {
        this.needDivider = divider;
        this.stickersSet = null;
        this.textView.setText(title);
        this.valueTextView.setText(subtitle);
        if (TextUtils.isEmpty(subtitle)) {
            this.textView.setTranslationY(AndroidUtilities.dp(10.0f));
        } else {
            this.textView.setTranslationY(0.0f);
        }
        if (icon != 0) {
            this.imageView.setImageResource(icon, Theme.getColor("windowBackgroundWhiteGrayIcon"));
            this.imageView.setVisibility(0);
            RadialProgressView radialProgressView = this.progressView;
            if (radialProgressView != null) {
                radialProgressView.setVisibility(4);
                return;
            }
            return;
        }
        this.imageView.setVisibility(4);
        RadialProgressView radialProgressView2 = this.progressView;
        if (radialProgressView2 != null) {
            radialProgressView2.setVisibility(0);
        }
    }

    public void setNeedDivider(boolean needDivider) {
        this.needDivider = needDivider;
    }

    public void setStickersSet(TLRPC$TL_messages_stickerSet set, boolean divider) {
        ImageLocation forSticker;
        this.needDivider = divider;
        this.stickersSet = set;
        this.imageView.setVisibility(0);
        RadialProgressView radialProgressView = this.progressView;
        if (radialProgressView != null) {
            radialProgressView.setVisibility(4);
        }
        this.textView.setTranslationY(0.0f);
        this.textView.setText(this.stickersSet.set.title);
        if (this.stickersSet.set.archived) {
            this.textView.setAlpha(0.5f);
            this.valueTextView.setAlpha(0.5f);
            this.imageView.setAlpha(0.5f);
        } else {
            this.textView.setAlpha(1.0f);
            this.valueTextView.setAlpha(1.0f);
            this.imageView.setAlpha(1.0f);
        }
        ArrayList<TLRPC$Document> arrayList = set.documents;
        if (arrayList != null && !arrayList.isEmpty()) {
            this.valueTextView.setText(LocaleController.formatPluralString("Stickers", arrayList.size()));
            TLRPC$Document tLRPC$Document = arrayList.get(0);
            Object closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(set.set.thumbs, 90);
            if (closestPhotoSizeWithSize == null) {
                closestPhotoSizeWithSize = tLRPC$Document;
            }
            SvgHelper.SvgDrawable svgThumb = DocumentObject.getSvgThumb(set.set.thumbs, "windowBackgroundGray", 1.0f);
            boolean z = closestPhotoSizeWithSize instanceof TLRPC$Document;
            if (z) {
                forSticker = ImageLocation.getForDocument(FileLoader.getClosestPhotoSizeWithSize(tLRPC$Document.thumbs, 90), tLRPC$Document);
            } else {
                forSticker = ImageLocation.getForSticker((TLRPC$PhotoSize) closestPhotoSizeWithSize, tLRPC$Document, set.set.thumb_version);
            }
            if (z && MessageObject.isAnimatedStickerDocument(tLRPC$Document, true)) {
                if (svgThumb != null) {
                    this.imageView.setImage(ImageLocation.getForDocument(tLRPC$Document), "50_50", svgThumb, 0, set);
                    return;
                } else {
                    this.imageView.setImage(ImageLocation.getForDocument(tLRPC$Document), "50_50", forSticker, (String) null, 0, set);
                    return;
                }
            }
            if (forSticker != null && forSticker.imageType == 1) {
                this.imageView.setImage(forSticker, "50_50", "tgs", svgThumb, set);
                return;
            } else {
                this.imageView.setImage(forSticker, "50_50", "webp", svgThumb, set);
                return;
            }
        }
        this.valueTextView.setText(LocaleController.formatPluralString("Stickers", 0));
        this.imageView.setImageDrawable(null);
    }

    public void setChecked(boolean checked) {
        setChecked(checked, true);
    }

    public void setChecked(boolean checked, boolean animated) {
        int i = this.option;
        if (i == 1) {
            this.checkBox.setChecked(checked, animated);
        } else {
            if (i != 3) {
                return;
            }
            this.optionsButton.setVisibility(checked ? 0 : 4);
        }
    }

    public void setReorderable(boolean reorderable) {
        setReorderable(reorderable, true);
    }

    public void setReorderable(final boolean reorderable, boolean animated) {
        if (this.option == 1) {
            float[] fArr = new float[2];
            fArr[0] = reorderable ? 1.0f : 0.0f;
            fArr[1] = reorderable ? 0.0f : 1.0f;
            float[] fArr2 = new float[2];
            fArr2[0] = reorderable ? 1.0f : 0.66f;
            fArr2[1] = reorderable ? 0.66f : 1.0f;
            if (animated) {
                this.reorderButton.setVisibility(0);
                ViewPropertyAnimator duration = this.reorderButton.animate().alpha(fArr[0]).scaleX(fArr2[0]).scaleY(fArr2[0]).setDuration(200L);
                Interpolator interpolator = Easings.easeOutSine;
                duration.setInterpolator(interpolator).withEndAction(new Runnable() { // from class: ir.eitaa.ui.Cells.-$$Lambda$StickerSetCell$Qoq6etCEmI3_bTrmllF1Z03SntE
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$setReorderable$0$StickerSetCell(reorderable);
                    }
                }).start();
                this.optionsButton.setVisibility(0);
                this.optionsButton.animate().alpha(fArr[1]).scaleX(fArr2[1]).scaleY(fArr2[1]).setDuration(200L).setInterpolator(interpolator).withEndAction(new Runnable() { // from class: ir.eitaa.ui.Cells.-$$Lambda$StickerSetCell$aWnmbq9EPAOPVW_RXlLPKJ9pStw
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$setReorderable$1$StickerSetCell(reorderable);
                    }
                }).start();
                return;
            }
            this.reorderButton.setVisibility(reorderable ? 0 : 8);
            this.reorderButton.setAlpha(fArr[0]);
            this.reorderButton.setScaleX(fArr2[0]);
            this.reorderButton.setScaleY(fArr2[0]);
            this.optionsButton.setVisibility(reorderable ? 8 : 0);
            this.optionsButton.setAlpha(fArr[1]);
            this.optionsButton.setScaleX(fArr2[1]);
            this.optionsButton.setScaleY(fArr2[1]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setReorderable$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setReorderable$0$StickerSetCell(boolean z) {
        if (z) {
            return;
        }
        this.reorderButton.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setReorderable$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setReorderable$1$StickerSetCell(boolean z) {
        if (z) {
            this.optionsButton.setVisibility(8);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void setOnReorderButtonTouchListener(View.OnTouchListener listener) {
        this.reorderButton.setOnTouchListener(listener);
    }

    public void setOnOptionsClick(View.OnClickListener listener) {
        ImageView imageView = this.optionsButton;
        if (imageView == null) {
            return;
        }
        imageView.setOnClickListener(listener);
    }

    public TLRPC$TL_messages_stickerSet getStickersSet() {
        return this.stickersSet;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        ImageView imageView;
        if (Build.VERSION.SDK_INT >= 21 && getBackground() != null && (imageView = this.optionsButton) != null) {
            imageView.getHitRect(this.rect);
            if (this.rect.contains((int) event.getX(), (int) event.getY())) {
                return true;
            }
        }
        return super.onTouchEvent(event);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.needDivider) {
            canvas.drawLine(0.0f, getHeight() - 1, getWidth() - getPaddingRight(), getHeight() - 1, Theme.dividerPaint);
        }
    }
}
