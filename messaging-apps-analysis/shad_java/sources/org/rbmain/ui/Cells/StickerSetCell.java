package org.rbmain.ui.Cells;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
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
import ir.medu.shad.R;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.DocumentObject;
import org.rbmain.messenger.FileLoader;
import org.rbmain.messenger.ImageLocation;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.SvgHelper;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$Document;
import org.rbmain.tgnet.TLRPC$PhotoSize;
import org.rbmain.tgnet.TLRPC$TL_messages_stickerSet;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.BackupImageView;
import org.rbmain.ui.Components.CheckBox2;
import org.rbmain.ui.Components.Easings;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.RadialProgressView;

/* loaded from: classes4.dex */
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

    public StickerSetCell(Context context, int i) {
        super(context);
        this.rect = new Rect();
        this.option = i;
        TextView textView = new TextView(context);
        this.textView = textView;
        textView.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteBlackText));
        this.textView.setTextSize(1, 16.0f);
        this.textView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        this.textView.setLines(1);
        this.textView.setMaxLines(1);
        this.textView.setSingleLine(true);
        this.textView.setEllipsize(TextUtils.TruncateAt.END);
        this.textView.setGravity(LayoutHelper.getAbsoluteGravityStart());
        addView(this.textView, LayoutHelper.createFrameRelatively(-2.0f, -2.0f, 8388611, 71.0f, 9.0f, 46.0f, 0.0f));
        TextView textView2 = new TextView(context);
        this.valueTextView = textView2;
        textView2.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteGrayText2));
        this.valueTextView.setTextSize(1, 13.0f);
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
        if (i == 2) {
            RadialProgressView radialProgressView = new RadialProgressView(getContext());
            this.progressView = radialProgressView;
            radialProgressView.setProgressColor(Color.parseColor("#ff289deb"));
            this.progressView.setSize(AndroidUtilities.dp(30.0f));
            RadialProgressView radialProgressView2 = this.progressView;
            boolean z2 = LocaleController.isRTL;
            addView(radialProgressView2, LayoutHelper.createFrame(48, 48.0f, (z2 ? 5 : 3) | 48, z2 ? 0.0f : 12.0f, 5.0f, z2 ? 12.0f : 0.0f, 0.0f));
            return;
        }
        if (i != 0) {
            ImageView imageView = new ImageView(context);
            this.optionsButton = imageView;
            imageView.setFocusable(false);
            this.optionsButton.setScaleType(ImageView.ScaleType.CENTER);
            this.optionsButton.setBackgroundDrawable(Theme.createSelectorDrawable(Theme.getColor(Theme.key_stickers_menuSelector)));
            if (i != 1) {
                if (i == 3) {
                    this.optionsButton.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_featuredStickers_addedIcon), PorterDuff.Mode.MULTIPLY));
                    this.optionsButton.setImageResource(R.drawable.sticker_added);
                    ImageView imageView2 = this.optionsButton;
                    boolean z3 = LocaleController.isRTL;
                    addView(imageView2, LayoutHelper.createFrame(40, 40.0f, (z3 ? 3 : 5) | 48, z3 ? 10 : 0, 9.0f, z3 ? 0 : 10, 0.0f));
                    return;
                }
                return;
            }
            ImageView imageView3 = this.optionsButton;
            int i2 = Theme.key_stickers_menu;
            imageView3.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i2), PorterDuff.Mode.MULTIPLY));
            this.optionsButton.setImageResource(R.drawable.msg_actions);
            addView(this.optionsButton, LayoutHelper.createFrame(40, 40, (LocaleController.isRTL ? 3 : 5) | 16));
            ImageView imageView4 = new ImageView(context);
            this.reorderButton = imageView4;
            imageView4.setAlpha(0.0f);
            this.reorderButton.setVisibility(8);
            this.reorderButton.setScaleType(ImageView.ScaleType.CENTER);
            this.reorderButton.setImageResource(R.drawable.list_reorder);
            this.reorderButton.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i2), PorterDuff.Mode.MULTIPLY));
            addView(this.reorderButton, LayoutHelper.createFrameRelatively(58.0f, 58.0f, 8388613));
            CheckBox2 checkBox2 = new CheckBox2(context, 21);
            this.checkBox = checkBox2;
            checkBox2.setColor(-1, Theme.key_windowBackgroundWhite, Theme.key_checkboxCheck);
            this.checkBox.setDrawUnchecked(false);
            this.checkBox.setDrawBackgroundAsArc(3);
            addView(this.checkBox, LayoutHelper.createFrameRelatively(24.0f, 24.0f, 8388611, 34.0f, 30.0f, 0.0f, 0.0f));
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(58.0f) + (this.needDivider ? 1 : 0), 1073741824));
    }

    public void setText(String str, String str2, int i, boolean z) throws Resources.NotFoundException {
        this.needDivider = z;
        this.stickersSet = null;
        this.textView.setText(str);
        this.valueTextView.setText(str2);
        if (TextUtils.isEmpty(str2)) {
            this.textView.setTranslationY(AndroidUtilities.dp(10.0f));
        } else {
            this.textView.setTranslationY(0.0f);
        }
        if (i != 0) {
            this.imageView.setImageResource(i, Theme.getColor(Theme.key_windowBackgroundWhiteGrayIcon));
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

    public void setNeedDivider(boolean z) {
        this.needDivider = z;
    }

    public void setStickersSet(TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet, boolean z) {
        ImageLocation forSticker;
        this.needDivider = z;
        this.stickersSet = tLRPC$TL_messages_stickerSet;
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
        ArrayList<TLRPC$Document> arrayList = tLRPC$TL_messages_stickerSet.documents;
        if (arrayList != null && !arrayList.isEmpty()) {
            this.valueTextView.setText(LocaleController.formatPluralString("Stickers", arrayList.size()));
            TLRPC$Document tLRPC$Document = arrayList.get(0);
            TLObject closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(tLRPC$TL_messages_stickerSet.set.thumbs, 90);
            if (closestPhotoSizeWithSize == null) {
                closestPhotoSizeWithSize = tLRPC$Document;
            }
            SvgHelper.SvgDrawable svgThumb = DocumentObject.getSvgThumb(tLRPC$TL_messages_stickerSet.set.thumbs, Theme.key_windowBackgroundGray, 1.0f);
            boolean z2 = closestPhotoSizeWithSize instanceof TLRPC$Document;
            if (z2) {
                forSticker = ImageLocation.getForDocument(FileLoader.getClosestPhotoSizeWithSize(tLRPC$Document.thumbs, 90), tLRPC$Document);
            } else {
                forSticker = ImageLocation.getForSticker((TLRPC$PhotoSize) closestPhotoSizeWithSize, tLRPC$Document);
            }
            if (z2 && MessageObject.isAnimatedStickerDocument(tLRPC$Document, true)) {
                if (svgThumb != null) {
                    this.imageView.setImage(ImageLocation.getForDocument(tLRPC$Document), "50_50", svgThumb, 0, tLRPC$TL_messages_stickerSet);
                    return;
                } else {
                    this.imageView.setImage(ImageLocation.getForDocument(tLRPC$Document), "50_50", forSticker, (String) null, 0, tLRPC$TL_messages_stickerSet);
                    return;
                }
            }
            if (forSticker != null && forSticker.imageType == 1) {
                this.imageView.setImage(forSticker, "50_50", "tgs", svgThumb, tLRPC$TL_messages_stickerSet);
                return;
            } else {
                this.imageView.setImage(forSticker, "50_50", "webp", svgThumb, tLRPC$TL_messages_stickerSet);
                return;
            }
        }
        this.valueTextView.setText(LocaleController.formatPluralString("Stickers", 0));
        this.imageView.setImageDrawable(null);
    }

    public void setChecked(boolean z) {
        setChecked(z, true);
    }

    public void setChecked(boolean z, boolean z2) {
        int i = this.option;
        if (i == 1) {
            this.checkBox.setChecked(z, z2);
        } else {
            if (i != 3) {
                return;
            }
            this.optionsButton.setVisibility(z ? 0 : 4);
        }
    }

    public void setReorderable(boolean z) {
        setReorderable(z, true);
    }

    public void setReorderable(final boolean z, boolean z2) {
        if (this.option == 1) {
            float[] fArr = new float[2];
            fArr[0] = z ? 1.0f : 0.0f;
            fArr[1] = z ? 0.0f : 1.0f;
            float[] fArr2 = new float[2];
            fArr2[0] = z ? 1.0f : 0.66f;
            fArr2[1] = z ? 0.66f : 1.0f;
            if (z2) {
                this.reorderButton.setVisibility(0);
                ViewPropertyAnimator duration = this.reorderButton.animate().alpha(fArr[0]).scaleX(fArr2[0]).scaleY(fArr2[0]).setDuration(200L);
                Interpolator interpolator = Easings.easeOutSine;
                duration.setInterpolator(interpolator).withEndAction(new Runnable() { // from class: org.rbmain.ui.Cells.StickerSetCell$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$setReorderable$0(z);
                    }
                }).start();
                this.optionsButton.setVisibility(0);
                this.optionsButton.animate().alpha(fArr[1]).scaleX(fArr2[1]).scaleY(fArr2[1]).setDuration(200L).setInterpolator(interpolator).withEndAction(new Runnable() { // from class: org.rbmain.ui.Cells.StickerSetCell$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$setReorderable$1(z);
                    }
                }).start();
                return;
            }
            this.reorderButton.setVisibility(z ? 0 : 8);
            this.reorderButton.setAlpha(fArr[0]);
            this.reorderButton.setScaleX(fArr2[0]);
            this.reorderButton.setScaleY(fArr2[0]);
            this.optionsButton.setVisibility(z ? 8 : 0);
            this.optionsButton.setAlpha(fArr[1]);
            this.optionsButton.setScaleX(fArr2[1]);
            this.optionsButton.setScaleY(fArr2[1]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setReorderable$0(boolean z) {
        if (z) {
            return;
        }
        this.reorderButton.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setReorderable$1(boolean z) {
        if (z) {
            this.optionsButton.setVisibility(8);
        }
    }

    public void setOnReorderButtonTouchListener(View.OnTouchListener onTouchListener) {
        this.reorderButton.setOnTouchListener(onTouchListener);
    }

    public void setOnOptionsClick(View.OnClickListener onClickListener) {
        ImageView imageView = this.optionsButton;
        if (imageView == null) {
            return;
        }
        imageView.setOnClickListener(onClickListener);
    }

    public TLRPC$TL_messages_stickerSet getStickersSet() {
        return this.stickersSet;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ImageView imageView;
        if (Build.VERSION.SDK_INT >= 21 && getBackground() != null && (imageView = this.optionsButton) != null) {
            imageView.getHitRect(this.rect);
            if (this.rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return true;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.needDivider) {
            canvas.drawLine(0.0f, getHeight() - 1, getWidth() - getPaddingRight(), getHeight() - 1, Theme.dividerPaint);
        }
    }
}
