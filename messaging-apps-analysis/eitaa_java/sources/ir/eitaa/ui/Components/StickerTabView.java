package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.SvgHelper;
import ir.eitaa.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class StickerTabView extends FrameLayout {
    private static int indexPointer;
    public float dragOffset;
    ValueAnimator dragOffsetAnimator;
    boolean expanded;
    boolean hasSavedLeft;
    ImageView iconView;
    BackupImageView imageView;
    public final int index;
    public boolean inited;
    public boolean isChatSticker;
    float lastLeft;
    boolean roundImage;
    public SvgHelper.SvgDrawable svgThumb;
    TextView textView;
    public int type;
    View visibleView;

    public StickerTabView(Context context, int type) {
        super(context);
        this.type = type;
        int i = indexPointer;
        indexPointer = i + 1;
        this.index = i;
        if (type == 2) {
            BackupImageView backupImageView = new BackupImageView(getContext());
            this.imageView = backupImageView;
            backupImageView.setLayerNum(1);
            this.imageView.setAspectFit(false);
            addView(this.imageView, LayoutHelper.createFrame(36, 36, 17));
            this.visibleView = this.imageView;
        } else if (type == 1) {
            ImageView imageView = new ImageView(context);
            this.iconView = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            addView(this.iconView, LayoutHelper.createFrame(24, 24, 17));
            this.visibleView = this.iconView;
        } else {
            BackupImageView backupImageView2 = new BackupImageView(getContext());
            this.imageView = backupImageView2;
            backupImageView2.setLayerNum(1);
            this.imageView.setAspectFit(true);
            addView(this.imageView, LayoutHelper.createFrame(30, 30, 17));
            this.visibleView = this.imageView;
        }
        TextView textView = new TextView(context);
        this.textView = textView;
        textView.setLines(1);
        this.textView.setEllipsize(TextUtils.TruncateAt.END);
        this.textView.setTextSize(1, 11.0f);
        this.textView.setGravity(1);
        this.textView.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        addView(this.textView, LayoutHelper.createFrame(-1, -2.0f, 81, 8.0f, 0.0f, 8.0f, 10.0f));
        this.textView.setVisibility(8);
    }

    public void setExpanded(boolean expanded) {
        int i = this.type;
        if (i == 2) {
            return;
        }
        this.expanded = expanded;
        float f = i == 1 ? 24.0f : 30.0f;
        float f2 = i == 1 ? 38.0f : 56.0f;
        this.visibleView.getLayoutParams().width = AndroidUtilities.dp(expanded ? f2 : f);
        ViewGroup.LayoutParams layoutParams = this.visibleView.getLayoutParams();
        if (expanded) {
            f = f2;
        }
        layoutParams.height = AndroidUtilities.dp(f);
        this.textView.setVisibility(expanded ? 0 : 8);
        if (this.type == 1 || !this.roundImage) {
            return;
        }
        this.imageView.setRoundRadius(AndroidUtilities.dp(this.visibleView.getLayoutParams().width / 2.0f));
    }

    public void updateExpandProgress(float expandProgress) {
        int i = this.type;
        if (i == 2) {
            return;
        }
        if (this.expanded) {
            float f = i == 1 ? 24.0f : 30.0f;
            float f2 = i == 1 ? 38.0f : 56.0f;
            float f3 = 1.0f - expandProgress;
            this.visibleView.setTranslationY((((AndroidUtilities.dp(48.0f - f) / 2.0f) - (AndroidUtilities.dp(98.0f - f2) / 2.0f)) * f3) - (AndroidUtilities.dp(8.0f) * expandProgress));
            this.visibleView.setTranslationX(((AndroidUtilities.dp(52.0f - f) / 2.0f) - (AndroidUtilities.dp(86.0f - f2) / 2.0f)) * f3);
            this.textView.setAlpha(Math.max(0.0f, (expandProgress - 0.5f) / 0.5f));
            this.textView.setTranslationY((-AndroidUtilities.dp(40.0f)) * f3);
            this.textView.setTranslationX((-AndroidUtilities.dp(12.0f)) * f3);
            this.visibleView.setPivotX(0.0f);
            this.visibleView.setPivotY(0.0f);
            float f4 = ((f / f2) * f3) + expandProgress;
            this.visibleView.setScaleX(f4);
            this.visibleView.setScaleY(f4);
            return;
        }
        this.visibleView.setTranslationX(0.0f);
        this.visibleView.setTranslationY(0.0f);
        this.visibleView.setScaleX(1.0f);
        this.visibleView.setScaleY(1.0f);
    }

    public void saveXPosition() {
        this.lastLeft = getLeft();
        this.hasSavedLeft = true;
        invalidate();
    }

    public void animateIfPositionChanged(final ViewGroup parent) {
        float left = getLeft();
        float f = this.lastLeft;
        if (left != f && this.hasSavedLeft) {
            this.dragOffset = f - getLeft();
            ValueAnimator valueAnimator = this.dragOffsetAnimator;
            if (valueAnimator != null) {
                valueAnimator.removeAllListeners();
                this.dragOffsetAnimator.cancel();
            }
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.dragOffset, 0.0f);
            this.dragOffsetAnimator = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.StickerTabView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    StickerTabView.this.dragOffset = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                    StickerTabView.this.invalidate();
                    parent.invalidate();
                }
            });
            this.dragOffsetAnimator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.StickerTabView.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    StickerTabView stickerTabView = StickerTabView.this;
                    stickerTabView.dragOffset = 0.0f;
                    stickerTabView.invalidate();
                    parent.invalidate();
                }
            });
            this.dragOffsetAnimator.start();
        }
        this.hasSavedLeft = false;
    }

    public void setRoundImage() {
        this.roundImage = true;
    }
}
