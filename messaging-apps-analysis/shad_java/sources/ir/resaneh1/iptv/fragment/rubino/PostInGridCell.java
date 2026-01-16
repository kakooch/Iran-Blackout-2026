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
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.model.Rubino;
import ir.resaneh1.iptv.model.RubinoPostObject;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class PostInGridCell extends FrameLayout {
    private Paint backgroundPaint;
    private SharedPhotoVideoCellDelegate delegate;
    private boolean ignoreLayout;
    private int[] indexes;
    private boolean isFirst;
    private int itemsCount;
    private PhotoVideoView[] photoVideoViews;
    private RubinoPostObject[] posts;

    public interface SharedPhotoVideoCellDelegate {
        void didClickItem(PostInGridCell postInGridCell, int i, RubinoPostObject rubinoPostObject, int i2);
    }

    private class PhotoVideoView extends FrameLayout {
        private AnimatorSet animator;
        private FrameLayout container;
        private Context context;
        private RubinoPostObject currentPostObject;
        private ImageView imageView;
        private ImageView smallIcon;

        public PhotoVideoView(Context context) {
            super(context);
            this.context = context;
            setWillNotDraw(false);
            FrameLayout frameLayout = new FrameLayout(context);
            this.container = frameLayout;
            addView(frameLayout, LayoutHelper.createFrame(-1, -1.0f));
            ImageView imageView = new ImageView(context);
            this.imageView = imageView;
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            this.container.addView(this.imageView, LayoutHelper.createFrame(-1, -1.0f));
            ImageView imageView2 = new ImageView(context);
            this.smallIcon = imageView2;
            this.container.addView(imageView2, LayoutHelper.createFrame(32, 32.0f, 53, 0.0f, 0.0f, 0.0f, 0.0f));
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        public void setObject(RubinoPostObject rubinoPostObject) {
            Rubino.FileTypeEnum fileTypeEnum;
            Rubino.FileTypeEnum fileTypeEnum2;
            this.currentPostObject = rubinoPostObject;
            this.imageView.setVisibility(0);
            Rubino.PostObjectFromServer postObjectFromServer = this.currentPostObject.post;
            if (postObjectFromServer != null && ((fileTypeEnum = postObjectFromServer.file_type) == (fileTypeEnum2 = Rubino.FileTypeEnum.Video) || postObjectFromServer.is_multi_file || postObjectFromServer.is_for_sale)) {
                if (postObjectFromServer.is_multi_file) {
                    this.smallIcon.setImageDrawable(this.context.getResources().getDrawable(R.drawable.rubino_multi_grid_album_icon));
                } else if (postObjectFromServer.is_for_sale) {
                    this.smallIcon.setImageDrawable(this.context.getResources().getDrawable(R.drawable.rubino_grid_shopping_icon));
                } else if (fileTypeEnum == fileTypeEnum2) {
                    this.smallIcon.setImageDrawable(this.context.getResources().getDrawable(R.drawable.rubino_play_filled_32));
                }
                this.smallIcon.setVisibility(0);
            } else {
                this.smallIcon.setVisibility(8);
            }
            GlideHelper.loadWithColorPlaceHolder(this.context, this.imageView, this.currentPostObject.post.full_thumbnail_url, Theme.getColor(Theme.key_actionBarDefault));
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
                canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), PostInGridCell.this.backgroundPaint);
            }
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            Rubino.PostObjectFromServer postObjectFromServer = this.currentPostObject.post;
            if (postObjectFromServer != null && postObjectFromServer.file_type == Rubino.FileTypeEnum.Video) {
                accessibilityNodeInfo.setText(LocaleController.getString(R.string.video));
            } else {
                accessibilityNodeInfo.setText(LocaleController.getString(R.string.photo));
            }
        }
    }

    public PostInGridCell(Context context) {
        super(context);
        this.backgroundPaint = new Paint();
        this.posts = new RubinoPostObject[6];
        this.photoVideoViews = new PhotoVideoView[6];
        this.indexes = new int[6];
        for (int i = 0; i < 6; i++) {
            this.photoVideoViews[i] = new PhotoVideoView(context);
            addView(this.photoVideoViews[i]);
            this.photoVideoViews[i].setVisibility(4);
            this.photoVideoViews[i].setTag(Integer.valueOf(i));
            this.photoVideoViews[i].setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.PostInGridCell$$ExternalSyntheticLambda0
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

    public void setItem(int i, int i2, RubinoPostObject rubinoPostObject) {
        this.posts[i] = rubinoPostObject;
        this.indexes[i] = i2;
        if (rubinoPostObject != null) {
            this.photoVideoViews[i].setVisibility(0);
            this.photoVideoViews[i].setObject(rubinoPostObject);
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
            layoutParams.height = itemSize;
            layoutParams.gravity = 51;
            this.photoVideoViews[i3].setLayoutParams(layoutParams);
        }
        this.ignoreLayout = false;
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec((this.isFirst ? 0 : AndroidUtilities.dp(2.0f)) + itemSize, 1073741824));
    }

    public static int getItemSize(int i) {
        if (AndroidUtilities.isTablet()) {
            return (AndroidUtilities.dp(490.0f) - ((i - 1) * AndroidUtilities.dp(2.0f))) / i;
        }
        return (AndroidUtilities.displaySize.x - ((i - 1) * AndroidUtilities.dp(2.0f))) / i;
    }
}
