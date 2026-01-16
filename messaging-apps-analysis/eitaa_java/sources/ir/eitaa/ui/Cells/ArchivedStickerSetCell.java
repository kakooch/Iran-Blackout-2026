package ir.eitaa.ui.Cells;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.FrameLayout;
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
import ir.eitaa.tgnet.TLRPC$StickerSetCovered;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.BackupImageView;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.ProgressButton;
import ir.eitaa.ui.Components.ViewHelper;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public class ArchivedStickerSetCell extends FrameLayout implements Checkable {
    private final ProgressButton addButton;
    private AnimatorSet animatorSet;
    private final boolean checkable;
    private boolean checked;
    private Button currentButton;
    private final Button deleteButton;
    private final BackupImageView imageView;
    private boolean needDivider;
    private OnCheckedChangeListener onCheckedChangeListener;
    private TLRPC$StickerSetCovered stickersSet;
    private final TextView textView;
    private final TextView valueTextView;

    public interface OnCheckedChangeListener {
        void onCheckedChanged(ArchivedStickerSetCell cell, boolean isChecked);
    }

    public ArchivedStickerSetCell(Context context, boolean checkable) {
        super(context);
        this.checkable = checkable;
        if (checkable) {
            ProgressButton progressButton = new ProgressButton(context);
            this.addButton = progressButton;
            this.currentButton = progressButton;
            progressButton.setText(LocaleController.getString("Add", R.string.Add));
            progressButton.setTextColor(Theme.getColor("featuredStickers_buttonText"));
            progressButton.setProgressColor(Theme.getColor("featuredStickers_buttonProgress"));
            progressButton.setBackgroundRoundRect(Theme.getColor("featuredStickers_addButton"), Theme.getColor("featuredStickers_addButtonPressed"));
            addView(progressButton, LayoutHelper.createFrameRelatively(-2.0f, 28.0f, 8388661, 0.0f, 18.0f, 14.0f, 0.0f));
            int iDp = AndroidUtilities.dp(60.0f);
            ProgressButton progressButton2 = new ProgressButton(context);
            this.deleteButton = progressButton2;
            progressButton2.setAllCaps(false);
            progressButton2.setMinWidth(iDp);
            progressButton2.setMinimumWidth(iDp);
            progressButton2.setTextSize(1, 14.0f);
            progressButton2.setTextColor(Theme.getColor("featuredStickers_removeButtonText"));
            progressButton2.setText(LocaleController.getString("StickersRemove", R.string.StickersRemove));
            progressButton2.setBackground(Theme.getRoundRectSelectorDrawable(Theme.getColor("featuredStickers_removeButtonText")));
            progressButton2.setTypeface(AndroidUtilities.getFontFamily(true));
            ViewHelper.setPadding(progressButton2, 8.0f, 0.0f, 8.0f, 0.0f);
            if (Build.VERSION.SDK_INT >= 21) {
                progressButton2.setOutlineProvider(null);
            }
            addView(progressButton2, LayoutHelper.createFrameRelatively(-2.0f, 28.0f, 8388661, 0.0f, 18.0f, 14.0f, 0.0f));
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: ir.eitaa.ui.Cells.-$$Lambda$ArchivedStickerSetCell$jGRBcesg9o2k2Nu6ZiJFWK3fQIg
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$0$ArchivedStickerSetCell(view);
                }
            };
            progressButton.setOnClickListener(onClickListener);
            progressButton2.setOnClickListener(onClickListener);
            syncButtons(false);
        } else {
            this.addButton = null;
            this.deleteButton = null;
        }
        TextView textView = new TextView(context);
        this.textView = textView;
        textView.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        textView.setTextSize(1, 16.0f);
        textView.setTypeface(AndroidUtilities.getFontFamily(false));
        textView.setLines(1);
        textView.setMaxLines(1);
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setGravity(LayoutHelper.getAbsoluteGravityStart());
        addView(textView, LayoutHelper.createFrameRelatively(-2.0f, -2.0f, 8388611, 71.0f, 10.0f, 21.0f, 0.0f));
        TextView textView2 = new TextView(context);
        this.valueTextView = textView2;
        textView2.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText2"));
        textView2.setTextSize(1, 13.0f);
        textView2.setTypeface(AndroidUtilities.getFontFamily(false));
        textView2.setLines(1);
        textView2.setMaxLines(1);
        textView2.setSingleLine(true);
        textView2.setGravity(LayoutHelper.getAbsoluteGravityStart());
        addView(textView2, LayoutHelper.createFrameRelatively(-2.0f, -2.0f, 8388611, 71.0f, 35.0f, 21.0f, 0.0f));
        BackupImageView backupImageView = new BackupImageView(context);
        this.imageView = backupImageView;
        backupImageView.setAspectFit(true);
        backupImageView.setLayerNum(1);
        addView(backupImageView, LayoutHelper.createFrameRelatively(48.0f, 48.0f, 8388659, 12.0f, 8.0f, 0.0f, 0.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$ArchivedStickerSetCell(View view) {
        toggle();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(64.0f) + (this.needDivider ? 1 : 0), 1073741824));
    }

    @Override // android.view.ViewGroup
    protected void measureChildWithMargins(View child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed) {
        if (this.checkable && child == this.textView) {
            widthUsed += Math.max(this.addButton.getMeasuredWidth(), this.deleteButton.getMeasuredWidth());
        }
        super.measureChildWithMargins(child, parentWidthMeasureSpec, widthUsed, parentHeightMeasureSpec, heightUsed);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.needDivider) {
            canvas.drawLine(0.0f, getHeight() - 1, getWidth() - getPaddingRight(), getHeight() - 1, Theme.dividerPaint);
        }
    }

    public void setDrawProgress(boolean drawProgress, boolean animated) {
        ProgressButton progressButton = this.addButton;
        if (progressButton != null) {
            progressButton.setDrawProgress(drawProgress, animated);
        }
    }

    public void setStickersSet(TLRPC$StickerSetCovered set, boolean divider) {
        ImageLocation forSticker;
        this.needDivider = divider;
        this.stickersSet = set;
        setWillNotDraw(!divider);
        this.textView.setText(this.stickersSet.set.title);
        this.valueTextView.setText(LocaleController.formatPluralString("Stickers", set.set.count));
        TLRPC$Document tLRPC$Document = set.cover;
        if (tLRPC$Document == null) {
            tLRPC$Document = !set.covers.isEmpty() ? set.covers.get(0) : null;
        }
        if (tLRPC$Document != null) {
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
            ImageLocation imageLocation = forSticker;
            if (z && MessageObject.isAnimatedStickerDocument(tLRPC$Document, true)) {
                if (svgThumb != null) {
                    this.imageView.setImage(ImageLocation.getForDocument(tLRPC$Document), "50_50", svgThumb, 0, set);
                    return;
                } else {
                    this.imageView.setImage(ImageLocation.getForDocument(tLRPC$Document), "50_50", imageLocation, (String) null, 0, set);
                    return;
                }
            }
            if (imageLocation != null && imageLocation.imageType == 1) {
                this.imageView.setImage(imageLocation, "50_50", "tgs", svgThumb, set);
                return;
            } else {
                this.imageView.setImage(imageLocation, "50_50", "webp", svgThumb, set);
                return;
            }
        }
        this.imageView.setImage((ImageLocation) null, (String) null, "webp", (Drawable) null, set);
    }

    public TLRPC$StickerSetCovered getStickersSet() {
        return this.stickersSet;
    }

    private void syncButtons(boolean animated) {
        if (this.checkable) {
            AnimatorSet animatorSet = this.animatorSet;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            boolean z = this.checked;
            float f = z ? 1.0f : 0.0f;
            float f2 = z ? 0.0f : 1.0f;
            if (animated) {
                this.currentButton = z ? this.deleteButton : this.addButton;
                this.addButton.setVisibility(0);
                this.deleteButton.setVisibility(0);
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.animatorSet = animatorSet2;
                animatorSet2.setDuration(250L);
                this.animatorSet.playTogether(ObjectAnimator.ofFloat(this.deleteButton, (Property<Button, Float>) View.ALPHA, f), ObjectAnimator.ofFloat(this.deleteButton, (Property<Button, Float>) View.SCALE_X, f), ObjectAnimator.ofFloat(this.deleteButton, (Property<Button, Float>) View.SCALE_Y, f), ObjectAnimator.ofFloat(this.addButton, (Property<ProgressButton, Float>) View.ALPHA, f2), ObjectAnimator.ofFloat(this.addButton, (Property<ProgressButton, Float>) View.SCALE_X, f2), ObjectAnimator.ofFloat(this.addButton, (Property<ProgressButton, Float>) View.SCALE_Y, f2));
                this.animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Cells.ArchivedStickerSetCell.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        if (ArchivedStickerSetCell.this.currentButton == ArchivedStickerSetCell.this.addButton) {
                            ArchivedStickerSetCell.this.deleteButton.setVisibility(4);
                        } else {
                            ArchivedStickerSetCell.this.addButton.setVisibility(4);
                        }
                    }
                });
                this.animatorSet.setInterpolator(new OvershootInterpolator(1.02f));
                this.animatorSet.start();
                return;
            }
            this.deleteButton.setVisibility(z ? 0 : 4);
            this.deleteButton.setAlpha(f);
            this.deleteButton.setScaleX(f);
            this.deleteButton.setScaleY(f);
            this.addButton.setVisibility(this.checked ? 4 : 0);
            this.addButton.setAlpha(f2);
            this.addButton.setScaleX(f2);
            this.addButton.setScaleY(f2);
        }
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener listener) {
        this.onCheckedChangeListener = listener;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean checked) {
        setChecked(checked, true);
    }

    public void setChecked(boolean checked, boolean animated) {
        setChecked(checked, animated, true);
    }

    public void setChecked(boolean checked, boolean animated, boolean notify) {
        OnCheckedChangeListener onCheckedChangeListener;
        if (!this.checkable || this.checked == checked) {
            return;
        }
        this.checked = checked;
        syncButtons(animated);
        if (!notify || (onCheckedChangeListener = this.onCheckedChangeListener) == null) {
            return;
        }
        onCheckedChangeListener.onCheckedChanged(this, checked);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.checked;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        if (this.checkable) {
            setChecked(!isChecked());
        }
    }
}
