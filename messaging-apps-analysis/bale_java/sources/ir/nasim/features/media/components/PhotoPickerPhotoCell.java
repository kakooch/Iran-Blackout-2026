package ir.nasim.features.media.components;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.FrameLayout;
import ir.nasim.AbstractC9160Yt;
import ir.nasim.C14433hu3;
import ir.nasim.C22078ud6;
import ir.nasim.C5495Jo7;
import ir.nasim.KB5;
import ir.nasim.components.checkbox.view.CheckBox;

/* loaded from: classes6.dex */
public class PhotoPickerPhotoCell extends FrameLayout {
    private AnimatorSet a;
    public CheckBox checkBox;
    public FrameLayout checkFrame;
    public int itemWidth;
    public BackupImageView photoImage;

    class a extends AbstractC9160Yt {
        final /* synthetic */ boolean a;

        a(boolean z) {
            this.a = z;
        }

        @Override // ir.nasim.AbstractC9160Yt, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (PhotoPickerPhotoCell.this.a == null || !PhotoPickerPhotoCell.this.a.equals(animator)) {
                return;
            }
            PhotoPickerPhotoCell.this.a = null;
        }

        @Override // ir.nasim.AbstractC9160Yt, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (PhotoPickerPhotoCell.this.a == null || !PhotoPickerPhotoCell.this.a.equals(animator)) {
                return;
            }
            PhotoPickerPhotoCell.this.a = null;
            if (this.a) {
                return;
            }
            PhotoPickerPhotoCell.this.setBackgroundColor(0);
        }
    }

    public PhotoPickerPhotoCell(Context context, String str) {
        super(context);
        BackupImageView backupImageView = new BackupImageView(context);
        this.photoImage = backupImageView;
        addView(backupImageView, C14433hu3.a(-1, -1.0f));
        FrameLayout frameLayout = new FrameLayout(context);
        this.checkFrame = frameLayout;
        addView(frameLayout, C14433hu3.c(42, 42, 53));
        CheckBox checkBox = new CheckBox(context, KB5.checkbig);
        this.checkBox = checkBox;
        checkBox.setSize(30);
        this.checkBox.setCheckOffset(C22078ud6.a(1.0f));
        this.checkBox.setDrawBackground(true);
        if (str != null) {
            this.checkBox.setColor(Color.parseColor(str));
        } else {
            this.checkBox.setColor(C5495Jo7.a.t2());
        }
        addView(this.checkBox, C14433hu3.b(30, 30.0f, 53, 0.0f, 4.0f, 4.0f, 0.0f));
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.itemWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.itemWidth, 1073741824));
    }

    public void setChecked(boolean z, boolean z2) {
        this.checkBox.setChecked(z, z2);
        AnimatorSet animatorSet = this.a;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.a = null;
        }
        if (!z2) {
            setBackgroundColor(z ? C5495Jo7.a.j2() : 0);
            this.photoImage.setScaleX(z ? 0.85f : 1.0f);
            this.photoImage.setScaleY(z ? 0.85f : 1.0f);
            return;
        }
        if (z) {
            setBackgroundColor(C5495Jo7.a.j2());
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.a = animatorSet2;
        animatorSet2.playTogether(ObjectAnimator.ofFloat(this.photoImage, "scaleX", z ? 0.85f : 1.0f), ObjectAnimator.ofFloat(this.photoImage, "scaleY", z ? 0.85f : 1.0f));
        this.a.setDuration(200L);
        this.a.addListener(new a(z));
        this.a.start();
    }
}
