package ir.iranlms.asemnavideoplayerlibrary.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.text.CaptionStyleCompat;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import com.google.android.exoplayer2.ui.SubtitleView;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.video.VideoListener;
import ir.iranlms.asemnavideoplayerlibrary.player.MyPlaybackControlView;
import ir.iranlms.asemnavideoplayerlibrary.player.models.PlayObject;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.GlideHelper;
import java.util.List;
import org.rbmain.messenger.MessagesController;

/* loaded from: classes3.dex */
public final class MySimpleExoPlayerView extends FrameLayout {
    private final ImageView artworkView;
    private final ComponentListener componentListener;
    private final AspectRatioFrameLayout contentFrame;
    public final MyPlaybackControlView controller;
    private int controllerShowTimeoutMs;
    private Bitmap defaultArtwork;
    private final FrameLayout overlayFrameLayout;
    private PlayObject playObject;
    private SimpleExoPlayer player;
    private final View shutterView;
    private final SubtitleView subtitleView;
    private final View surfaceView;
    private boolean useArtwork;
    private boolean useController;

    public void hideController() {
    }

    public MySimpleExoPlayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MySimpleExoPlayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.my_exo_simple_player_view, this);
        this.componentListener = new ComponentListener();
        setDescendantFocusability(MessagesController.UPDATE_MASK_CHAT_MUTE);
        AspectRatioFrameLayout aspectRatioFrameLayout = (AspectRatioFrameLayout) findViewById(R.id.exo_content_frame);
        this.contentFrame = aspectRatioFrameLayout;
        if (aspectRatioFrameLayout != null) {
            setResizeModeRaw(aspectRatioFrameLayout, 2);
        }
        this.shutterView = findViewById(R.id.exo_shutter);
        setBackgroundColor(context.getResources().getColor(R.color.transparent));
        if (aspectRatioFrameLayout != null) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            TextureView textureView = new TextureView(context);
            this.surfaceView = textureView;
            textureView.setLayoutParams(layoutParams);
            aspectRatioFrameLayout.addView(textureView, 0);
        } else {
            this.surfaceView = null;
        }
        this.overlayFrameLayout = (FrameLayout) findViewById(R.id.exo_overlay);
        ImageView imageView = (ImageView) findViewById(R.id.exo_artwork);
        this.artworkView = imageView;
        this.useArtwork = imageView != null;
        SubtitleView subtitleView = (SubtitleView) findViewById(R.id.exo_subtitles);
        this.subtitleView = subtitleView;
        if (subtitleView != null) {
            subtitleView.setUserDefaultStyle();
            subtitleView.setUserDefaultTextSize();
            subtitleView.setStyle(new CaptionStyleCompat(-1, 1426063360, 0, 1, -16777216, Typeface.createFromAsset(getContext().getAssets(), "fonts/iranyekanwebregular.ttf")));
        }
        View viewFindViewById = findViewById(R.id.exo_controller_placeholder);
        if (viewFindViewById != null) {
            MyPlaybackControlView myPlaybackControlView = new MyPlaybackControlView(context, attributeSet);
            this.controller = myPlaybackControlView;
            myPlaybackControlView.setLayoutParams(viewFindViewById.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) viewFindViewById.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(viewFindViewById);
            viewGroup.removeView(viewFindViewById);
            viewGroup.addView(myPlaybackControlView, iIndexOfChild);
        } else {
            this.controller = null;
        }
        MyPlaybackControlView myPlaybackControlView2 = this.controller;
        this.controllerShowTimeoutMs = myPlaybackControlView2 != null ? 3500 : 0;
        this.useController = myPlaybackControlView2 != null;
        hideController();
    }

    public SimpleExoPlayer getPlayer() {
        return this.player;
    }

    public void setPlayer(SimpleExoPlayer simpleExoPlayer) {
        if (simpleExoPlayer == null) {
            this.player = null;
            this.controller.setPlayer(null);
        }
        SimpleExoPlayer simpleExoPlayer2 = this.player;
        if (simpleExoPlayer2 == simpleExoPlayer) {
            return;
        }
        if (simpleExoPlayer2 != null) {
            simpleExoPlayer2.setTextOutput(null);
            this.player.setVideoListener(null);
            this.player.removeListener(this.componentListener);
            this.player.setVideoSurface(null);
        }
        this.player = simpleExoPlayer;
        if (this.useController) {
            this.controller.setPlayer(simpleExoPlayer);
        }
        View view = this.shutterView;
        if (view != null) {
            view.setVisibility(0);
        }
        if (simpleExoPlayer != null) {
            View view2 = this.surfaceView;
            if (view2 instanceof TextureView) {
                simpleExoPlayer.setVideoTextureView((TextureView) view2);
            } else if (view2 instanceof SurfaceView) {
                simpleExoPlayer.setVideoSurfaceView((SurfaceView) view2);
            }
            simpleExoPlayer.setVideoListener(this.componentListener);
            simpleExoPlayer.addListener(this.componentListener);
            simpleExoPlayer.setTextOutput(this.componentListener);
            maybeShowController(false);
            updateForCurrentTrackSelections();
            setResizeMode(0);
            return;
        }
        hideController();
        hideArtwork();
    }

    public void setResizeMode(int i) {
        Assertions.checkState(this.contentFrame != null);
        this.contentFrame.setResizeMode(i);
    }

    public boolean getUseArtwork() {
        return this.useArtwork;
    }

    public void setUseArtwork(boolean z) {
        Assertions.checkState((z && this.artworkView == null) ? false : true);
        if (this.useArtwork != z) {
            this.useArtwork = z;
            updateForCurrentTrackSelections();
        }
    }

    public Bitmap getDefaultArtwork() {
        return this.defaultArtwork;
    }

    public void setDefaultArtwork(Bitmap bitmap) {
        if (this.defaultArtwork != bitmap) {
            this.defaultArtwork = bitmap;
            updateForCurrentTrackSelections();
        }
    }

    public boolean getUseController() {
        return this.useController;
    }

    public void setUseController(boolean z) {
        Assertions.checkState((z && this.controller == null) ? false : true);
        if (this.useController == z) {
            return;
        }
        this.useController = z;
        if (z) {
            this.controller.setPlayer(this.player);
            return;
        }
        MyPlaybackControlView myPlaybackControlView = this.controller;
        if (myPlaybackControlView != null) {
            myPlaybackControlView.hide();
            this.controller.setPlayer(null);
        }
    }

    public int getControllerShowTimeoutMs() {
        return this.controllerShowTimeoutMs;
    }

    public void setControllerShowTimeoutMs(int i) {
        Assertions.checkState(this.controller != null);
        this.controllerShowTimeoutMs = i;
    }

    public void setControllerVisibilityListener(MyPlaybackControlView.VisibilityListener visibilityListener) {
        Assertions.checkState(this.controller != null);
        this.controller.setVisibilityListener(visibilityListener);
    }

    public void setSeekDispatcher(MyPlaybackControlView.SeekDispatcher seekDispatcher) {
        Assertions.checkState(this.controller != null);
        this.controller.setSeekDispatcher(seekDispatcher);
    }

    public void setRewindIncrementMs(int i) {
        Assertions.checkState(this.controller != null);
        this.controller.setRewindIncrementMs(i);
    }

    public void setFastForwardIncrementMs(int i) {
        Assertions.checkState(this.controller != null);
        this.controller.setFastForwardIncrementMs(i);
    }

    public View getVideoSurfaceView() {
        return this.surfaceView;
    }

    public FrameLayout getOverlayFrameLayout() {
        return this.overlayFrameLayout;
    }

    public SubtitleView getSubtitleView() {
        return this.subtitleView;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.useController || this.player == null || motionEvent.getActionMasked() != 0) {
            return false;
        }
        if (!this.controller.isVisible()) {
            maybeShowController(true);
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!this.useController || this.player == null) {
            return false;
        }
        maybeShowController(true);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeShowController(boolean z) {
        SimpleExoPlayer simpleExoPlayer;
        if (!this.useController || (simpleExoPlayer = this.player) == null) {
            return;
        }
        int playbackState = simpleExoPlayer.getPlaybackState();
        boolean z2 = playbackState == 1 || playbackState == 4 || !this.player.getPlayWhenReady();
        boolean z3 = this.controller.isVisible() && this.controller.getShowTimeoutMs() <= 0;
        this.controller.setShowTimeoutMs(z2 ? 0 : this.controllerShowTimeoutMs);
        if (z || z2 || z3) {
            this.controller.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateForCurrentTrackSelections() {
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer == null) {
            return;
        }
        TrackSelectionArray currentTrackSelections = simpleExoPlayer.getCurrentTrackSelections();
        for (int i = 0; i < currentTrackSelections.length; i++) {
            if (this.player.getRendererType(i) == 2 && currentTrackSelections.get(i) != null) {
                hideArtwork();
                return;
            }
        }
        View view = this.shutterView;
        if (view != null) {
            view.setVisibility(0);
        }
        if (this.useArtwork) {
            for (int i2 = 0; i2 < currentTrackSelections.length; i2++) {
                TrackSelection trackSelection = currentTrackSelections.get(i2);
                if (trackSelection != null) {
                    for (int i3 = 0; i3 < trackSelection.length(); i3++) {
                        Metadata metadata = trackSelection.getFormat(i3).metadata;
                        if (metadata != null && setArtworkFromMetadata(metadata)) {
                            return;
                        }
                    }
                }
            }
            if (setArtworkFromBitmap(this.defaultArtwork)) {
                return;
            }
        }
        hideArtwork();
    }

    private boolean setArtworkFromMetadata(Metadata metadata) {
        for (int i = 0; i < metadata.length(); i++) {
            Metadata.Entry entry = metadata.get(i);
            if (entry instanceof ApicFrame) {
                byte[] bArr = ((ApicFrame) entry).pictureData;
                return setArtworkFromBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
            }
        }
        return false;
    }

    private boolean setArtworkFromBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width > 0 && height > 0) {
                AspectRatioFrameLayout aspectRatioFrameLayout = this.contentFrame;
                if (aspectRatioFrameLayout != null) {
                    aspectRatioFrameLayout.setAspectRatio(width / height);
                }
                this.artworkView.setImageBitmap(bitmap);
                this.artworkView.setVisibility(0);
                return true;
            }
        }
        return false;
    }

    private boolean setArtworkUrl(String str) {
        GlideHelper.load(getContext(), this.artworkView, str, R.color.grey_200);
        this.artworkView.setVisibility(0);
        return true;
    }

    private void hideArtwork() {
        ImageView imageView;
        PlayObject playObject = this.playObject;
        if ((playObject == null || !playObject.isForInsta) && (imageView = this.artworkView) != null) {
            imageView.setImageResource(android.R.color.transparent);
            this.artworkView.setVisibility(4);
        }
    }

    private static void setResizeModeRaw(AspectRatioFrameLayout aspectRatioFrameLayout, int i) {
        aspectRatioFrameLayout.setResizeMode(i);
    }

    public void setPlayObject(PlayObject playObject) {
        this.playObject = playObject;
        String str = playObject.imageUrl;
        if (str != null && str.length() > 0) {
            setArtworkUrl(playObject.imageUrl);
        }
        if (playObject.isForInsta) {
            setResizeMode(4);
        } else {
            setResizeMode(0);
        }
    }

    private final class ComponentListener implements SimpleExoPlayer.VideoListener, TextOutput, Player.EventListener {
        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onExperimentalOffloadSchedulingEnabledChanged(boolean z) {
            Player.EventListener.CC.$default$onExperimentalOffloadSchedulingEnabledChanged(this, z);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onIsLoadingChanged(boolean z) {
            onLoadingChanged(z);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onIsPlayingChanged(boolean z) {
            Player.EventListener.CC.$default$onIsPlayingChanged(this, z);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onLoadingChanged(boolean z) {
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onMediaItemTransition(MediaItem mediaItem, int i) {
            Player.EventListener.CC.$default$onMediaItemTransition(this, mediaItem, i);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onPlayWhenReadyChanged(boolean z, int i) {
            Player.EventListener.CC.$default$onPlayWhenReadyChanged(this, z, i);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onPlaybackStateChanged(int i) {
            Player.EventListener.CC.$default$onPlaybackStateChanged(this, i);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i) {
            Player.EventListener.CC.$default$onPlaybackSuppressionReasonChanged(this, i);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onPlayerError(ExoPlaybackException exoPlaybackException) {
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onPositionDiscontinuity(int i) {
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onRepeatModeChanged(int i) {
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onSeekProcessed() {
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onShuffleModeEnabledChanged(boolean z) {
        }

        @Override // com.google.android.exoplayer2.video.VideoListener
        public /* synthetic */ void onSurfaceSizeChanged(int i, int i2) {
            VideoListener.CC.$default$onSurfaceSizeChanged(this, i, i2);
        }

        /* JADX WARN: Failed to inline method: com.google.android.exoplayer2.Player.EventListener.-CC.$default$onTimelineChanged(com.google.android.exoplayer2.Player$EventListener, com.google.android.exoplayer2.Timeline, int):void */
        /* JADX WARN: Not passed register '(r1v0 'timeline' com.google.android.exoplayer2.Timeline)' in method call: com.google.android.exoplayer2.Player.EventListener.-CC.$default$onTimelineChanged(com.google.android.exoplayer2.Player$EventListener, com.google.android.exoplayer2.Timeline, int):void */
        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onTimelineChanged(Timeline timeline, int i) {
            Player.EventListener.CC.$default$onTimelineChanged(this, timeline, i);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onTimelineChanged(Timeline timeline, Object obj, int i) {
        }

        private ComponentListener() {
        }

        @Override // com.google.android.exoplayer2.text.TextOutput
        public void onCues(List<Cue> list) {
            if (MySimpleExoPlayerView.this.subtitleView != null) {
                MySimpleExoPlayerView.this.subtitleView.onCues(list);
            }
        }

        @Override // com.google.android.exoplayer2.video.VideoListener
        public void onVideoSizeChanged(int i, int i2, int i3, float f) {
            if (MySimpleExoPlayerView.this.contentFrame != null) {
                MySimpleExoPlayerView.this.contentFrame.setAspectRatio(i2 == 0 ? 1.0f : (i * f) / i2);
            }
        }

        @Override // com.google.android.exoplayer2.video.VideoListener
        public void onRenderedFirstFrame() {
            if (MySimpleExoPlayerView.this.shutterView != null) {
                MySimpleExoPlayerView.this.shutterView.setVisibility(4);
                if (MySimpleExoPlayerView.this.playObject != null) {
                    if (MySimpleExoPlayerView.this.playObject.isForInsta || MySimpleExoPlayerView.this.playObject.isForExplore) {
                        MySimpleExoPlayerView.this.artworkView.setImageResource(android.R.color.transparent);
                        MySimpleExoPlayerView.this.artworkView.setVisibility(4);
                    }
                }
            }
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
            MySimpleExoPlayerView.this.updateForCurrentTrackSelections();
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onPlayerStateChanged(boolean z, int i) {
            MySimpleExoPlayerView.this.maybeShowController(false);
        }
    }
}
