package ir.appp.rghapp.rubinoPostSlider;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import ir.appp.rghapp.RGHMediaHelper$PhotoEntry;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.BackupImageView;
import org.rbmain.ui.Components.CheckBox2;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class AddPostPhotoCell extends FrameLayout {
    private AnimatorSet animator;
    private AnimatorSet animatorSet;
    private CheckBox2 checkBox;
    private FrameLayout container;
    private AddPostPhotoCellDelegate delegate;
    private BackupImageView imageView;
    private boolean isLast;
    private boolean isVertical;
    private int itemSize;
    private boolean itemSizeChanged;
    private RGHMediaHelper$PhotoEntry photoEntry;
    private boolean pressed;
    private Rect rect;
    private TextView videoTextView;
    private FrameLayout whiteCurtain;

    public interface AddPostPhotoCellDelegate {
        void didClickCheckBox(AddPostPhotoCell addPostPhotoCell);
    }

    public boolean isInSelectionMode() {
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public AddPostPhotoCell(Context context) {
        super(context);
        this.rect = new Rect();
        new Paint();
        setWillNotDraw(false);
        FrameLayout frameLayout = new FrameLayout(context);
        this.container = frameLayout;
        addView(frameLayout, LayoutHelper.createFrame(80, 80.0f));
        BackupImageView backupImageView = new BackupImageView(context);
        this.imageView = backupImageView;
        this.container.addView(backupImageView, LayoutHelper.createFrame(-1, -1.0f));
        FrameLayout frameLayout2 = new FrameLayout(context);
        this.whiteCurtain = frameLayout2;
        frameLayout2.setBackgroundColor(-1426063361);
        this.container.addView(this.whiteCurtain, LayoutHelper.createFrame(-1, -1.0f));
        this.whiteCurtain.setAlpha(0.0f);
        TextView textView = new TextView(context);
        this.videoTextView = textView;
        textView.setTextColor(-1);
        this.videoTextView.setTypeface(Theme.getRubinoTypeFaceRegular());
        this.videoTextView.setTextSize(1, 12.0f);
        this.videoTextView.setImportantForAccessibility(2);
        this.container.addView(this.videoTextView, LayoutHelper.createFrame(-2, -2.0f, 85, 0.0f, 0.0f, 4.0f, 2.0f));
        this.videoTextView.setVisibility(4);
        CheckBox2 checkBox2 = new CheckBox2(context, 24);
        this.checkBox = checkBox2;
        checkBox2.setDrawBackgroundAsArc(7);
        this.checkBox.setColor(Theme.key_rubino_add_postCheckBoxBackground, Theme.key_rubino_add_post_photoPlaceholder, Theme.key_rubino_add_post_CheckBoxCheck);
        addView(this.checkBox, LayoutHelper.createFrame(26, 26.0f, 51, 52.0f, 4.0f, 0.0f, 0.0f));
        this.checkBox.setVisibility(0);
        this.checkBox.setAlpha(0.0f);
        setFocusable(true);
        setClickable(true);
        this.itemSize = AndroidUtilities.dp(80.0f);
        this.pressed = false;
    }

    private boolean isCheckBoxClicked(MotionEvent motionEvent) {
        this.checkBox.getHitRect(this.rect);
        return isInSelectionMode() && this.rect.contains((int) motionEvent.getX(), (int) motionEvent.getY()) && this.checkBox.getAlpha() != 0.0f;
    }

    public void setIsVertical(boolean z) {
        this.isVertical = z;
    }

    public void setItemSize(int i) {
        this.itemSize = i;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.container.getLayoutParams();
        int i2 = this.itemSize;
        layoutParams.height = i2;
        layoutParams.width = i2;
        layoutParams.rightMargin = AndroidUtilities.dp(2.0f);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.checkBox.getLayoutParams();
        layoutParams2.gravity = 53;
        layoutParams2.leftMargin = 0;
        int iDp = AndroidUtilities.dp(5.0f);
        layoutParams2.topMargin = iDp;
        layoutParams2.rightMargin = iDp;
        this.checkBox.setDrawBackgroundAsArc(6);
        this.itemSizeChanged = true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.itemSizeChanged) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.itemSize, 1073741824), View.MeasureSpec.makeMeasureSpec(this.itemSize + AndroidUtilities.dp(1.0f), 1073741824));
            return;
        }
        if (this.isVertical) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(80.0f), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp((this.isLast ? 0 : 6) + 80), 1073741824));
        } else {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp((this.isLast ? 0 : 6) + 80), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(80.0f), 1073741824));
        }
    }

    public RGHMediaHelper$PhotoEntry getPhotoEntry() {
        return this.photoEntry;
    }

    public BackupImageView getImageView() {
        return this.imageView;
    }

    public float getScale() {
        return this.container.getScaleX();
    }

    public CheckBox2 getCheckBox() {
        return this.checkBox;
    }

    public FrameLayout getWhiteCurtain() {
        return this.whiteCurtain;
    }

    public void setPhotoEntry(RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry, boolean z, boolean z2) {
        this.pressed = false;
        this.photoEntry = rGHMediaHelper$PhotoEntry;
        this.isLast = z2;
        if (rGHMediaHelper$PhotoEntry.isVideo) {
            this.imageView.setOrientation(0, true);
            this.videoTextView.setVisibility(0);
            this.videoTextView.setText(AndroidUtilities.formatDurationNoHours((int) (this.photoEntry.duration / 1000), false));
        } else {
            this.videoTextView.setVisibility(4);
        }
        RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry2 = this.photoEntry;
        if (rGHMediaHelper$PhotoEntry2.thumbPath == null) {
            if (rGHMediaHelper$PhotoEntry2.path != null) {
                if (rGHMediaHelper$PhotoEntry2.isVideo) {
                    this.imageView.setImage("vthumb://" + this.photoEntry.imageId + ":" + this.photoEntry.path, null, null);
                } else {
                    this.imageView.setOrientation(rGHMediaHelper$PhotoEntry2.orientation, true);
                    this.imageView.setImage("thumb://" + this.photoEntry.imageId + ":" + this.photoEntry.path, null, null);
                }
            } else {
                this.imageView.setImageDrawable(null);
            }
        }
        this.imageView.getImageReceiver().setVisible(true, true);
        requestLayout();
    }

    public boolean isChecked() {
        return this.checkBox.isChecked();
    }

    public void setChecked(int i, boolean z, boolean z2) {
        this.checkBox.setChecked(i, z, z2);
    }

    public void setInSelectMode(boolean z, boolean z2) {
        showCheck(z, false);
    }

    public void setNum(int i) {
        this.checkBox.setNum(i);
    }

    public void setDelegate(AddPostPhotoCellDelegate addPostPhotoCellDelegate) {
        this.delegate = addPostPhotoCellDelegate;
    }

    public void showCheck(boolean z, boolean z2) {
        if (z2) {
            AnimatorSet animatorSet = this.animatorSet;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.animatorSet = null;
            }
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.animatorSet = animatorSet2;
            animatorSet2.setInterpolator(new DecelerateInterpolator());
            this.animatorSet.setDuration(180L);
            AnimatorSet animatorSet3 = this.animatorSet;
            CheckBox2 checkBox2 = this.checkBox;
            Property property = View.ALPHA;
            float[] fArr = new float[1];
            fArr[0] = z ? 1.0f : 0.0f;
            animatorSet3.play(ObjectAnimator.ofFloat(checkBox2, (Property<CheckBox2, Float>) property, fArr));
            this.animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.appp.rghapp.rubinoPostSlider.AddPostPhotoCell.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (animator.equals(AddPostPhotoCell.this.animatorSet)) {
                        AddPostPhotoCell.this.animatorSet = null;
                    }
                }
            });
            this.animatorSet.start();
            return;
        }
        this.checkBox.setAlpha(z ? 1.0f : 0.0f);
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    public void clearAnimation() {
        super.clearAnimation();
        AnimatorSet animatorSet = this.animator;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.animator = null;
            this.container.setScaleX(this.checkBox.isChecked() ? 0.787f : 1.0f);
            this.container.setScaleY(this.checkBox.isChecked() ? 0.787f : 1.0f);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.checkBox.getHitRect(this.rect);
        if (motionEvent.getAction() == 0) {
            if (isCheckBoxClicked(motionEvent)) {
                this.pressed = true;
                invalidate();
                return true;
            }
        } else if (this.pressed) {
            if (motionEvent.getAction() == 1) {
                getParent().requestDisallowInterceptTouchEvent(true);
                this.pressed = false;
                this.delegate.didClickCheckBox(this);
                invalidate();
            } else if (motionEvent.getAction() == 3) {
                this.pressed = false;
                invalidate();
            } else if (motionEvent.getAction() == 2 && !isCheckBoxClicked(motionEvent)) {
                this.pressed = false;
                invalidate();
            }
        }
        return false;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setEnabled(true);
        RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry = this.photoEntry;
        if (rGHMediaHelper$PhotoEntry != null) {
            boolean z = rGHMediaHelper$PhotoEntry.isVideo;
        }
        if (this.checkBox.isChecked()) {
            accessibilityNodeInfo.setSelected(true);
        }
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i, Bundle bundle) {
        return super.performAccessibilityAction(i, bundle);
    }
}
