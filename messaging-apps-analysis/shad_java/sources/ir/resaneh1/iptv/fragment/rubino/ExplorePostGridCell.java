package ir.resaneh1.iptv.fragment.rubino;

import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.facebook.stetho.common.Utf8Charset;
import ir.appp.rghapp.rubinoPostSlider.ExploreVideoPlayer;
import ir.appp.rghapp.rubinoPostSlider.FileLoaderRubinoPost;
import ir.appp.rghapp.rubinoPostSlider.PhotoViewerObject;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.Rubino;
import ir.resaneh1.iptv.model.RubinoPostObject;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.UserConfig;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class ExplorePostGridCell extends FrameLayout implements NotificationCenter.NotificationCenterDelegate {
    private boolean allowPlayingVideo;
    private int classGuid;
    private int column;
    int currentAccount;
    private SharedPhotoVideoCellDelegate delegate;
    private PhotoVideoView photoVideoView;
    private RubinoPostObject post;
    private int row;

    public interface SharedPhotoVideoCellDelegate {
        void didClickItem(ExplorePostGridCell explorePostGridCell, RubinoPostObject rubinoPostObject, int i, int i2);

        boolean didLongPressedItem(ExplorePostGridCell explorePostGridCell, RubinoPostObject rubinoPostObject, int i, int i2);
    }

    static class PhotoVideoView extends FrameLayout {
        private boolean allowPlayVideo;
        private AnimatorSet animator;
        private Paint backgroundPaint;
        private FrameLayout containerView;
        private Context context;
        private int currentAccount;
        private RubinoPostObject currentPostObject;
        private ImageView imageView;
        private boolean isPlaying;
        private PhotoViewerObject playingObject;
        private ImageView smallIcon;
        private boolean textureUploaded;
        private FrameLayout videoContainerFrameLayout;
        private ExploreVideoPlayer videoPlayer;
        private TextureView videoTextureView;

        public PhotoVideoView(Context context) {
            super(context);
            this.backgroundPaint = new Paint();
            this.currentAccount = UserConfig.selectedAccount;
            this.context = context;
            FrameLayout frameLayout = new FrameLayout(context);
            this.containerView = frameLayout;
            addView(frameLayout, LayoutHelper.createFrame(-1, -1.0f));
            ImageView imageView = new ImageView(context);
            this.imageView = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.containerView.addView(this.imageView, LayoutHelper.createFrame(-1, -1.0f));
            ImageView imageView2 = new ImageView(context);
            this.smallIcon = imageView2;
            this.containerView.addView(imageView2, LayoutHelper.createFrame(32, 32.0f, 53, 0.0f, 0.0f, 0.0f, 0.0f));
        }

        void setAllowPlayVideo(boolean z) {
            this.allowPlayVideo = z;
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        public void setObject(RubinoPostObject rubinoPostObject) {
            Rubino.FileTypeEnum fileTypeEnum;
            Rubino.FileTypeEnum fileTypeEnum2;
            FrameLayout frameLayout;
            this.currentPostObject = rubinoPostObject;
            this.imageView.setVisibility(0);
            if (this.allowPlayVideo && (frameLayout = this.videoContainerFrameLayout) != null) {
                frameLayout.setVisibility(4);
            }
            this.playingObject = null;
            this.isPlaying = false;
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
                canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.backgroundPaint);
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

        private void createVideoTextureView() {
            if (this.videoTextureView != null) {
                return;
            }
            FrameLayout frameLayout = new FrameLayout(this.context);
            this.videoContainerFrameLayout = frameLayout;
            frameLayout.setVisibility(4);
            this.containerView.addView(this.videoContainerFrameLayout, 0, LayoutHelper.createFrame(-1, -1, 17));
            TextureView textureView = new TextureView(this.context);
            this.videoTextureView = textureView;
            textureView.setPivotX(0.0f);
            this.videoTextureView.setPivotY(0.0f);
            this.videoTextureView.setOpaque(false);
            this.videoTextureView.setAlpha(0.0f);
            this.videoContainerFrameLayout.addView(this.videoTextureView, LayoutHelper.createFrame(-1, -1, 17));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void scaleVideoTextureIfNeeded(int i, int i2, int i3) {
            if (this.videoTextureView == null) {
                return;
            }
            if (i3 != 90 && i3 != 270) {
                i2 = i;
                i = i2;
            }
            float measuredWidth = getMeasuredWidth();
            float measuredHeight = getMeasuredHeight();
            int i4 = (int) (measuredWidth / 2.0f);
            int i5 = (int) (measuredHeight / 2.0f);
            float f = i / i2;
            if (measuredHeight / measuredWidth <= f) {
                float f2 = (f * measuredWidth) / measuredHeight;
                if (f2 >= 1.0f) {
                    Matrix matrix = new Matrix();
                    matrix.setScale(1.0f, f2, i4, i5);
                    this.videoTextureView.setTransform(matrix);
                    this.videoTextureView.invalidate();
                    return;
                }
                return;
            }
            float f3 = (measuredHeight / f) / measuredWidth;
            if (f3 >= 1.0f) {
                Matrix matrix2 = new Matrix();
                matrix2.setScale(f3, 1.0f, i4, i5);
                this.videoTextureView.setTransform(matrix2);
                this.videoTextureView.invalidate();
            }
        }

        private void preparePlayer(Uri uri, PhotoViewerObject photoViewerObject) {
            boolean z = false;
            releasePlayer(false);
            if (getParent() instanceof ExplorePostGridCell) {
                ((ExplorePostGridCell) getParent()).addNotificationCenterObserver();
            }
            createVideoTextureView();
            this.textureUploaded = false;
            if (this.videoPlayer == null) {
                ExploreVideoPlayer exploreVideoPlayer = new ExploreVideoPlayer(this) { // from class: ir.resaneh1.iptv.fragment.rubino.ExplorePostGridCell.PhotoVideoView.1
                    @Override // ir.appp.rghapp.rubinoPostSlider.ExploreVideoPlayer
                    public void play() {
                        super.play();
                    }

                    @Override // ir.appp.rghapp.rubinoPostSlider.ExploreVideoPlayer
                    public void pause() {
                        super.pause();
                    }
                };
                this.videoPlayer = exploreVideoPlayer;
                TextureView textureView = this.videoTextureView;
                if (textureView != null) {
                    exploreVideoPlayer.setTextureView(textureView);
                }
                this.videoPlayer.setDelegate(new ExploreVideoPlayer.VideoPlayerDelegate() { // from class: ir.resaneh1.iptv.fragment.rubino.ExplorePostGridCell.PhotoVideoView.2
                    @Override // ir.appp.rghapp.rubinoPostSlider.ExploreVideoPlayer.VideoPlayerDelegate
                    public void onStateChanged(boolean z2, int i, boolean z3) {
                        if (!z3 && i != 1) {
                            PhotoVideoView.this.updatePlayerState(z2, i);
                            return;
                        }
                        if (MyLog.isDebugAble && i == 1) {
                            MyLog.e("ExploreVideo", "state idle occurred");
                        }
                        PhotoVideoView.this.releasePlayer(false);
                    }

                    @Override // ir.appp.rghapp.rubinoPostSlider.ExploreVideoPlayer.VideoPlayerDelegate
                    public void onError(ExploreVideoPlayer exploreVideoPlayer2, Exception exc) {
                        ExploreVideoPlayer unused = PhotoVideoView.this.videoPlayer;
                    }

                    @Override // ir.appp.rghapp.rubinoPostSlider.ExploreVideoPlayer.VideoPlayerDelegate
                    public void onVideoSizeChanged(int i, int i2, int i3, float f) {
                        PhotoVideoView.this.scaleVideoTextureIfNeeded(i, i2, i3);
                        if (PhotoVideoView.this.videoTextureView != null) {
                            PhotoVideoView.this.videoTextureView.setAlpha(1.0f);
                        }
                        PhotoVideoView.this.imageView.setVisibility(8);
                        PhotoVideoView.this.smallIcon.setVisibility(8);
                    }

                    @Override // ir.appp.rghapp.rubinoPostSlider.ExploreVideoPlayer.VideoPlayerDelegate
                    public void onRenderedFirstFrame() {
                        if (PhotoVideoView.this.textureUploaded) {
                            return;
                        }
                        PhotoVideoView.this.textureUploaded = true;
                        PhotoVideoView.this.containerView.invalidate();
                    }
                });
                z = true;
            }
            if (z) {
                this.videoPlayer.preparePlayer(uri, "other");
                this.videoPlayer.setPlayWhenReady(true);
            }
            this.videoPlayer.setLooping(true);
            this.videoPlayer.setMute(true);
            this.isPlaying = true;
            this.playingObject = photoViewerObject;
        }

        public void considerAutoPlayingCurrentVideo() {
            if (!this.allowPlayVideo || this.isPlaying) {
                return;
            }
            RubinoPostObject rubinoPostObject = this.currentPostObject;
            if (rubinoPostObject.post.file_type == Rubino.FileTypeEnum.Video) {
                PhotoViewerObject photoViewerObject = rubinoPostObject.photoSlideObject.getPhotos().get(0);
                if (photoViewerObject.checkIsFileExist()) {
                    preparePlayer(Uri.fromFile(photoViewerObject.getDownloadFile()), photoViewerObject);
                    return;
                }
                try {
                    String str = null;
                    FileLoaderRubinoPost.getInstance(this.currentAccount).loadFile(photoViewerObject, null, 4, 0);
                    photoViewerObject.size = 400000000;
                    try {
                        str = "?url=" + URLEncoder.encode(photoViewerObject.filePath, Utf8Charset.NAME) + "&postid=" + URLEncoder.encode(photoViewerObject.postId, Utf8Charset.NAME) + "&size=" + photoViewerObject.size;
                    } catch (UnsupportedEncodingException unused) {
                    }
                    preparePlayer(Uri.parse("ru://" + photoViewerObject.getFileDownloadedName() + str), photoViewerObject);
                } catch (Exception unused2) {
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updatePlayerState(boolean z, int i) {
            MyLog.e("UpdatePlayerState", "state = " + i + " - playWhenReady = " + z);
            if (this.videoPlayer == null) {
                return;
            }
            if (i == 3) {
                if (this.videoContainerFrameLayout.getVisibility() != 0) {
                    this.videoContainerFrameLayout.setVisibility(0);
                }
            } else if (this.videoContainerFrameLayout.getVisibility() != 4) {
                this.videoContainerFrameLayout.setVisibility(4);
            }
            invalidate();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void releasePlayer(boolean z) {
            this.imageView.setVisibility(0);
            this.smallIcon.setVisibility(0);
            ExploreVideoPlayer exploreVideoPlayer = this.videoPlayer;
            if (exploreVideoPlayer == null) {
                return;
            }
            if (z) {
                exploreVideoPlayer.releasePlayer();
            } else {
                exploreVideoPlayer.setDelegate(null);
                this.videoPlayer.pause();
                RubinoController.shouldReleasePlayersInExplore.add(this.videoPlayer);
            }
            if (this.playingObject != null) {
                FileLoaderRubinoPost.getInstance(this.currentAccount).cancelLoadFile(this.playingObject);
            }
            this.videoPlayer = null;
            this.isPlaying = false;
            this.playingObject = null;
            if (getParent() instanceof ExplorePostGridCell) {
                ((ExplorePostGridCell) getParent()).removeNotificationCenterObserver();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeVideoContainer() {
            FrameLayout frameLayout = this.videoContainerFrameLayout;
            if (frameLayout != null) {
                try {
                    this.containerView.removeView(frameLayout);
                } catch (Throwable unused) {
                }
                this.videoContainerFrameLayout = null;
            }
            if (this.videoTextureView != null) {
                this.videoTextureView = null;
            }
        }
    }

    public ExplorePostGridCell(Context context) {
        super(context);
        this.currentAccount = UserConfig.selectedAccount;
        PhotoVideoView photoVideoView = new PhotoVideoView(context);
        this.photoVideoView = photoVideoView;
        photoVideoView.setLongClickable(true);
        addView(this.photoVideoView);
        this.photoVideoView.setVisibility(4);
        this.photoVideoView.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.ExplorePostGridCell$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$0(view);
            }
        });
        this.photoVideoView.setOnLongClickListener(new View.OnLongClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.ExplorePostGridCell$$ExternalSyntheticLambda1
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.f$0.lambda$new$1(view);
            }
        });
        this.photoVideoView.setForeground(Theme.getSelectorDrawable(false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view) {
        SharedPhotoVideoCellDelegate sharedPhotoVideoCellDelegate = this.delegate;
        if (sharedPhotoVideoCellDelegate != null) {
            sharedPhotoVideoCellDelegate.didClickItem(this, this.post, this.row, this.column);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$1(View view) {
        SharedPhotoVideoCellDelegate sharedPhotoVideoCellDelegate = this.delegate;
        if (sharedPhotoVideoCellDelegate != null) {
            return sharedPhotoVideoCellDelegate.didLongPressedItem(this, this.post, this.row, this.column);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.photoVideoView.releasePlayer(false);
        this.photoVideoView.removeVideoContainer();
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void setDelegate(SharedPhotoVideoCellDelegate sharedPhotoVideoCellDelegate) {
        this.delegate = sharedPhotoVideoCellDelegate;
    }

    public ImageView getImageView() {
        PhotoVideoView photoVideoView = this.photoVideoView;
        if (photoVideoView == null) {
            return null;
        }
        return photoVideoView.imageView;
    }

    public void setItem(RubinoPostObject rubinoPostObject, int i, int i2) {
        this.post = rubinoPostObject;
        if (rubinoPostObject != null) {
            this.photoVideoView.setVisibility(0);
            this.photoVideoView.setObject(rubinoPostObject);
        } else {
            this.photoVideoView.clearAnimation();
            this.photoVideoView.setVisibility(4);
            this.post = null;
        }
        this.row = i;
        this.column = i2;
    }

    public void setItem(RubinoPostObject rubinoPostObject, boolean z, int i, int i2, int i3) {
        this.post = rubinoPostObject;
        this.classGuid = i;
        this.allowPlayingVideo = z;
        this.photoVideoView.setAllowPlayVideo(z);
        if (rubinoPostObject != null) {
            this.photoVideoView.setVisibility(0);
            this.photoVideoView.setObject(rubinoPostObject);
        } else {
            this.photoVideoView.clearAnimation();
            this.photoVideoView.setVisibility(4);
            this.post = null;
        }
        this.row = i2;
        this.column = i3;
    }

    public void playVideo() {
        if (this.allowPlayingVideo) {
            this.photoVideoView.considerAutoPlayingCurrentVideo();
        }
    }

    public void addNotificationCenterObserver() {
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.explorePlayersShouldPause);
    }

    public void removeNotificationCenterObserver() {
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.explorePlayersShouldPause);
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        if (i == NotificationCenter.explorePlayersShouldPause) {
            int iIntValue = ((Integer) objArr[0]).intValue();
            if (this.allowPlayingVideo && iIntValue == this.classGuid) {
                this.photoVideoView.releasePlayer(false);
            }
        }
    }
}
