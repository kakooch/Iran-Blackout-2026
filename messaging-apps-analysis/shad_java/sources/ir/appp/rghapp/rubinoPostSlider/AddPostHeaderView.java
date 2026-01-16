package ir.appp.rghapp.rubinoPostSlider;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import ir.appp.rghapp.RGHMediaHelper$PhotoEntry;
import ir.appp.rghapp.components.SSHPlayAnimatedDrawable;
import ir.appp.rghapp.rubinoPostSlider.AddPostPermissionView;
import ir.medu.shad.R;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class AddPostHeaderView extends FrameLayout {
    HeaderViewDelegate delegate;
    private final AddPostHeaderMediaView mediaView;
    private final AddPostPermissionView permissionRequestFrame;
    private final SSHPlayAnimatedDrawable playButton;
    private final View playView;
    private final ImageView scaleImageView;
    private final Paint selectModeBackgroundPaint;
    private final ImageView selectModeImageView;
    private final TextView unsupportedMedia;

    public interface HeaderViewDelegate {
        void didPressedSelectionButton();

        void didRequestStoragePermission();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public AddPostHeaderView(Context context) {
        super(context);
        AddPostHeaderMediaView addPostHeaderMediaView = new AddPostHeaderMediaView(context);
        this.mediaView = addPostHeaderMediaView;
        addView(addPostHeaderMediaView, LayoutHelper.createFrame(-1, -1.0f));
        ImageView imageView = new ImageView(this, context) { // from class: ir.appp.rghapp.rubinoPostSlider.AddPostHeaderView.1
            private final RectF rect = new RectF();

            @Override // android.widget.ImageView, android.view.View
            protected void onDraw(Canvas canvas) {
                this.rect.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
                canvas.drawRoundRect(this.rect, AndroidUtilities.dp(18.0f), AndroidUtilities.dp(18.0f), Theme.rubino_add_post_iconPaint);
                super.onDraw(canvas);
            }
        };
        this.scaleImageView = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setImageResource(R.drawable.rubino_add_post_expand);
        int iDp = AndroidUtilities.dp(10.0f);
        imageView.setPadding(iDp, iDp, iDp, iDp);
        imageView.setColorFilter(-1);
        addView(imageView, LayoutHelper.createFrame(36, 36.0f, 83, 12.0f, 0.0f, 0.0f, 12.0f));
        Paint paint = new Paint(1);
        this.selectModeBackgroundPaint = paint;
        paint.setColor(Theme.getColor(Theme.key_rubino_add_post_iconBackground));
        ImageView imageView2 = new ImageView(context) { // from class: ir.appp.rghapp.rubinoPostSlider.AddPostHeaderView.2
            private final RectF rect = new RectF();

            @Override // android.widget.ImageView, android.view.View
            protected void onDraw(Canvas canvas) {
                this.rect.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
                canvas.drawRoundRect(this.rect, AndroidUtilities.dp(18.0f), AndroidUtilities.dp(18.0f), AddPostHeaderView.this.selectModeBackgroundPaint);
                super.onDraw(canvas);
            }
        };
        this.selectModeImageView = imageView2;
        imageView2.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView2.setImageResource(R.drawable.rubino_add_post_multi_select);
        imageView2.setPadding(iDp, iDp, iDp, iDp);
        addView(imageView2, LayoutHelper.createFrame(36, 36.0f, 85, 0.0f, 0.0f, 12.0f, 12.0f));
        View view = new View(context);
        this.playView = view;
        SSHPlayAnimatedDrawable sSHPlayAnimatedDrawable = new SSHPlayAnimatedDrawable(context);
        this.playButton = sSHPlayAnimatedDrawable;
        view.setBackground(sSHPlayAnimatedDrawable);
        addView(view, LayoutHelper.createFrame(48, 48, 17));
        AddPostPermissionView addPostPermissionView = new AddPostPermissionView(context);
        this.permissionRequestFrame = addPostPermissionView;
        addPostPermissionView.setRequestForPermissions(new AddPostPermissionView.PermissionType[]{AddPostPermissionView.PermissionType.GALLERY});
        addPostPermissionView.setPermissionDescription(LocaleController.formatString(R.string.rubinoAddPostStoragePermissionDesc, LocaleController.getString(R.string.AppName)).toString());
        addPostPermissionView.setDelegate(new AddPostPermissionView.AddPostPermissionDelegate() { // from class: ir.appp.rghapp.rubinoPostSlider.AddPostHeaderView$$ExternalSyntheticLambda0
            @Override // ir.appp.rghapp.rubinoPostSlider.AddPostPermissionView.AddPostPermissionDelegate
            public final void didRequestPermission(AddPostPermissionView.PermissionType[] permissionTypeArr) {
                this.f$0.lambda$new$0(permissionTypeArr);
            }
        });
        addView(addPostPermissionView, LayoutHelper.createFrame(-1, -1.0f));
        addPostPermissionView.setVisibility(8);
        TextView textView = new TextView(context);
        this.unsupportedMedia = textView;
        textView.setGravity(17);
        textView.setText(LocaleController.getString("AddPostUnsupportedMedia", R.string.rubinoAddPostUnsupportedMedia));
        addView(textView, LayoutHelper.createFrame(-1, -1.0f));
        textView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(AddPostPermissionView.PermissionType[] permissionTypeArr) {
        this.delegate.didRequestStoragePermission();
    }

    public void setDelegate(HeaderViewDelegate headerViewDelegate) {
        this.delegate = headerViewDelegate;
    }

    public void hidePlayAnimation() {
        this.playButton.setIsVisible(false, false);
    }

    public void updateMediaIfNeeded(RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry) {
        if (this.mediaView.getCurrentObject() == null || this.mediaView.getCurrentObject().imageId != rGHMediaHelper$PhotoEntry.imageId || (this.mediaView.getCurrentObject().isVideo && !this.mediaView.isPlaying())) {
            if (!this.mediaView.setMedia(rGHMediaHelper$PhotoEntry)) {
                this.unsupportedMedia.setVisibility(0);
            } else {
                this.unsupportedMedia.setVisibility(8);
            }
        }
    }

    protected void onResume() {
        this.mediaView.onResume();
    }

    protected void onPause() {
        this.mediaView.onPause();
    }

    public void onDestroy() {
        this.mediaView.destroyPhotoViewer();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (getBottom() <= ActionBar.getCurrentActionBarHeight()) {
            return true;
        }
        if (new Rect(this.scaleImageView.getLeft(), this.scaleImageView.getTop(), this.scaleImageView.getRight(), this.scaleImageView.getBottom()).contains((int) motionEvent.getX(), (int) motionEvent.getY()) && this.mediaView.isVisible()) {
            this.mediaView.changeScale();
            return true;
        }
        if (new Rect(this.selectModeImageView.getLeft(), this.selectModeImageView.getTop(), this.selectModeImageView.getRight(), this.selectModeImageView.getBottom()).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            HeaderViewDelegate headerViewDelegate = this.delegate;
            if (headerViewDelegate != null) {
                headerViewDelegate.didPressedSelectionButton();
            }
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i);
    }

    public AddPostHeaderMediaView getMediaView() {
        return this.mediaView;
    }

    public SSHPlayAnimatedDrawable getPlayButton() {
        return this.playButton;
    }

    public void shouldLockContainer(boolean z) {
        if (z) {
            this.scaleImageView.setVisibility(4);
            this.mediaView.lockContainerRatio();
        } else {
            this.scaleImageView.setVisibility(0);
            this.mediaView.unlockContainerRatio();
        }
    }

    public void updateMultiSelectButtonBackground() {
        int color = this.selectModeBackgroundPaint.getColor();
        int i = Theme.key_rubino_add_post_iconBackground;
        if (color == Theme.getColor(i)) {
            this.selectModeBackgroundPaint.setColor(Theme.getColor(Theme.key_rubino_add_postCheckBoxBackground));
        } else {
            this.selectModeBackgroundPaint.setColor(Theme.getColor(i));
        }
        this.selectModeImageView.invalidate();
    }

    public void togglePermissionView(boolean z) {
        this.scaleImageView.setVisibility(z ? 8 : 0);
        this.selectModeImageView.setVisibility(z ? 8 : 0);
        this.permissionRequestFrame.setVisibility(z ? 0 : 8);
    }
}
