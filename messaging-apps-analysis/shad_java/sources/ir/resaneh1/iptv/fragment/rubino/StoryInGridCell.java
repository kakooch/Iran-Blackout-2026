package ir.resaneh1.iptv.fragment.rubino;

import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import ir.appp.common.utils.LayoutHelper;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.model.StoryObject;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.CheckBox2;

/* loaded from: classes3.dex */
public class StoryInGridCell extends FrameLayout {
    private Paint backgroundPaint;
    private SharedPhotoVideoCellDelegate delegate;
    private boolean ignoreLayout;
    private int[] indexes;
    private boolean isFirst;
    private int itemsCount;
    private PhotoVideoView[] photoVideoViews;
    private StoryObject[] posts;

    public interface SharedPhotoVideoCellDelegate {
        void didClickItem(StoryInGridCell storyInGridCell, int i, StoryObject storyObject, int i2);
    }

    private class PhotoVideoView extends FrameLayout {
        private AnimatorSet animator;
        private CheckBox2 checkBox;
        private FrameLayout container;
        private Context context;
        private StoryObject currentStoryObject;
        private ImageView imageView;

        public PhotoVideoView(Context context) {
            super(context);
            this.context = context;
            setWillNotDraw(false);
            FrameLayout frameLayout = new FrameLayout(context);
            this.container = frameLayout;
            addView(frameLayout, LayoutHelper.createFrame(-1, -1));
            ImageView imageView = new ImageView(context);
            this.imageView = imageView;
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            this.container.addView(this.imageView, LayoutHelper.createFrame(-1, -1));
            CheckBox2 checkBox2 = new CheckBox2(context, 21);
            this.checkBox = checkBox2;
            checkBox2.setVisibility(4);
            this.checkBox.setColor(Theme.key_rubino_add_postCheckBoxBackground, Theme.key_rubino_add_post_photoPlaceholder, Theme.key_rubino_add_post_CheckBoxCheck);
            this.checkBox.setDrawUnchecked(true);
            this.checkBox.setDrawBackgroundAsArc(6);
            addView(this.checkBox, LayoutHelper.createFrame(24, 24, 85, 0.0f, 0.0f, 4.0f, 4.0f));
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        public void setObject(StoryObject storyObject) {
            this.currentStoryObject = storyObject;
            this.imageView.setVisibility(0);
            GlideHelper.loadWithColorPlaceHolder(this.context, this.imageView, this.currentStoryObject.full_thumbnail_url, Theme.getColor(Theme.key_actionBarDefault));
        }

        @Override // android.view.View
        public void clearAnimation() {
            super.clearAnimation();
            AnimatorSet animatorSet = this.animator;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.animator = null;
            }
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            if (this.imageView.getAlpha() != 1.0f) {
                canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), StoryInGridCell.this.backgroundPaint);
            }
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setText(LocaleController.getString(R.string.story));
        }

        public void setChecked(boolean z, boolean z2) {
            if (this.checkBox.getVisibility() != 0) {
                this.checkBox.setVisibility(0);
            }
            this.checkBox.setChecked(z, z2);
        }
    }

    public StoryInGridCell(Context context) {
        super(context);
        this.backgroundPaint = new Paint();
        this.posts = new StoryObject[6];
        this.photoVideoViews = new PhotoVideoView[6];
        this.indexes = new int[6];
        for (int i = 0; i < 6; i++) {
            this.photoVideoViews[i] = new PhotoVideoView(context);
            addView(this.photoVideoViews[i]);
            this.photoVideoViews[i].setVisibility(4);
            this.photoVideoViews[i].setTag(Integer.valueOf(i));
            this.photoVideoViews[i].setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.StoryInGridCell$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$0(view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view) {
        if (this.delegate != null) {
            int iIntValue = ((Integer) view.getTag()).intValue();
            this.delegate.didClickItem(this, this.indexes[iIntValue], this.posts[iIntValue], iIntValue);
        }
    }

    @Override // android.view.View
    public void invalidate() {
        for (int i = 0; i < 6; i++) {
            this.photoVideoViews[i].invalidate();
        }
        super.invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void setDelegate(SharedPhotoVideoCellDelegate sharedPhotoVideoCellDelegate) {
        this.delegate = sharedPhotoVideoCellDelegate;
    }

    public void setItemsCount(int i) {
        int i2 = 0;
        while (true) {
            PhotoVideoView[] photoVideoViewArr = this.photoVideoViews;
            if (i2 < photoVideoViewArr.length) {
                photoVideoViewArr[i2].clearAnimation();
                this.photoVideoViews[i2].setVisibility(i2 < i ? 0 : 4);
                i2++;
            } else {
                this.itemsCount = i;
                return;
            }
        }
    }

    public void setIsFirst(boolean z) {
        this.isFirst = z;
    }

    public void setItem(int i, int i2, StoryObject storyObject, boolean z) {
        this.posts[i] = storyObject;
        this.indexes[i] = i2;
        if (storyObject != null) {
            this.photoVideoViews[i].setVisibility(0);
            this.photoVideoViews[i].setObject(storyObject);
            this.photoVideoViews[i].setChecked(z, false);
        } else {
            this.photoVideoViews[i].clearAnimation();
            this.photoVideoViews[i].setVisibility(4);
            this.posts[i] = null;
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.ignoreLayout) {
            return;
        }
        super.requestLayout();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int itemSize = getItemSize(this.itemsCount);
        int itemHeight = getItemHeight(this.itemsCount);
        this.ignoreLayout = true;
        for (int i3 = 0; i3 < this.itemsCount; i3++) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.photoVideoViews[i3].getLayoutParams();
            layoutParams.topMargin = this.isFirst ? 0 : AndroidUtilities.dp(2.0f);
            layoutParams.leftMargin = (AndroidUtilities.dp(2.0f) + itemSize) * i3;
            if (i3 == this.itemsCount - 1) {
                if (AndroidUtilities.isTablet()) {
                    layoutParams.width = AndroidUtilities.dp(490.0f) - ((this.itemsCount - 1) * (AndroidUtilities.dp(2.0f) + itemSize));
                } else {
                    layoutParams.width = AndroidUtilities.displaySize.x - ((this.itemsCount - 1) * (AndroidUtilities.dp(2.0f) + itemSize));
                }
            } else {
                layoutParams.width = itemSize;
            }
            layoutParams.height = itemHeight;
            layoutParams.gravity = 51;
            this.photoVideoViews[i3].setLayoutParams(layoutParams);
        }
        this.ignoreLayout = false;
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec((this.isFirst ? 0 : AndroidUtilities.dp(2.0f)) + itemHeight, 1073741824));
    }

    public static int getItemSize(int i) {
        if (AndroidUtilities.isTablet()) {
            return (AndroidUtilities.dp(490.0f) - ((i - 1) * AndroidUtilities.dp(2.0f))) / i;
        }
        return (AndroidUtilities.displaySize.x - ((i - 1) * AndroidUtilities.dp(2.0f))) / i;
    }

    public static int getItemHeight(int i) {
        double itemSize = getItemSize(i);
        Double.isNaN(itemSize);
        return (int) (itemSize * 1.5d);
    }

    public void setChecked(int i, boolean z) {
        this.photoVideoViews[i].setChecked(z, true);
    }
}
