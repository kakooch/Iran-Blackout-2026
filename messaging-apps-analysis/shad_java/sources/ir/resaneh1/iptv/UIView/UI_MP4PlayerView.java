package ir.resaneh1.iptv.UIView;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.stetho.common.Utf8Charset;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import ir.appp.rghapp.components.ExtendedDefaultDataSourceFactory;
import ir.appp.rghapp.rubinoPostSlider.FileLoaderRubinoPost;
import ir.appp.rghapp.rubinoPostSlider.PhotoViewerObject;
import ir.iranlms.asemnavideoplayerlibrary.player.PlayerBaseFragment;
import ir.medu.shad.R;
import ir.resaneh1.iptv.logger.MyLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.UserConfig;

/* loaded from: classes3.dex */
public class UI_MP4PlayerView {
    private static final DefaultBandwidthMeter BANDWIDTH_METER = new DefaultBandwidthMeter();
    public Context context;
    int currentAccount = UserConfig.selectedAccount;
    private PhotoViewerObject currentObject;
    public SimpleExoPlayer exoPlayer;
    public PlayerView exoPlayerView;
    private Handler mainHandler;
    private ExtendedDefaultDataSourceFactory mediaDataSourceFactory;
    private Player.EventListener playerEventLister;
    public int playingItemId;
    public View view;

    public UI_MP4PlayerView() {
        new Handler();
        this.playingItemId = -1;
        new Runnable() { // from class: ir.resaneh1.iptv.UIView.UI_MP4PlayerView.2
            @Override // java.lang.Runnable
            public void run() {
                UI_MP4PlayerView.this.stopPlayer();
            }
        };
    }

    public View createView(Activity activity) {
        this.context = activity;
        View viewInflate = activity.getLayoutInflater().inflate(R.layout.player_view, (ViewGroup) null);
        PlayerView playerView = (PlayerView) viewInflate.findViewById(R.id.simpleExoPlayerView);
        this.exoPlayerView = playerView;
        playerView.setVisibility(4);
        this.view = viewInflate;
        return viewInflate;
    }

    public void setExoPlayerEventListener(Player.EventListener eventListener) {
        SimpleExoPlayer simpleExoPlayer = this.exoPlayer;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.removeListener(eventListener);
            this.exoPlayer.addListener(eventListener);
        }
        this.playerEventLister = eventListener;
    }

    public void playMP4(String str) {
        playMP4(-1, str);
    }

    public void playMP4(int i, String str) {
        if (this.view == null) {
            return;
        }
        stopPlayer();
        this.playingItemId = i;
        ExtractorMediaSource extractorMediaSource = new ExtractorMediaSource(Uri.parse(str), new PlayerBaseFragment.CacheDataSourceFactory(this.context, 104857600L, 10485760L), new DefaultExtractorsFactory(), null, null);
        if (this.exoPlayer == null) {
            initExoPlayer();
        }
        this.exoPlayer.prepare(extractorMediaSource);
        this.exoPlayer.setPlayWhenReady(true);
    }

    public void playNew(int i, PhotoViewerObject photoViewerObject) {
        if (this.view == null) {
            return;
        }
        if (this.mediaDataSourceFactory == null) {
            Context context = ApplicationLoader.applicationContext;
            DefaultBandwidthMeter defaultBandwidthMeter = BANDWIDTH_METER;
            this.mediaDataSourceFactory = new ExtendedDefaultDataSourceFactory(context, defaultBandwidthMeter, new DefaultHttpDataSourceFactory("Mozilla/5.0 (X11; Linux x86_64; rv:10.0) Gecko/20150101 Firefox/47.0 (Chrome)", defaultBandwidthMeter));
        }
        if (this.mainHandler == null) {
            this.mainHandler = new Handler();
        }
        stopAndReleasePlayer();
        this.playingItemId = i;
        if (photoViewerObject.checkIsFileExist()) {
            preparePlayer(i, Uri.fromFile(photoViewerObject.getDownloadFile()));
            MyLog.e("autoPlay", "autoPlay Video offline " + photoViewerObject.postId);
            return;
        }
        try {
            String str = null;
            FileLoaderRubinoPost.getInstance(this.currentAccount).loadFile(photoViewerObject, null, 4, 0);
            photoViewerObject.size = 400000000;
            try {
                str = "?url=" + URLEncoder.encode(photoViewerObject.filePath, Utf8Charset.NAME) + "&storyid=" + URLEncoder.encode(photoViewerObject.storyId, Utf8Charset.NAME) + "&size=" + photoViewerObject.size;
            } catch (UnsupportedEncodingException unused) {
            }
            Uri uri = Uri.parse("ru://" + photoViewerObject.getFileDownloadedName() + str);
            StringBuilder sb = new StringBuilder();
            sb.append("autoPlay Video OnLine ");
            sb.append(photoViewerObject.postId);
            MyLog.e("autoPlay", sb.toString());
            preparePlayer(i, uri);
        } catch (Exception unused2) {
        }
        this.currentObject = photoViewerObject;
    }

    private void preparePlayer(int i, Uri uri) {
        this.playingItemId = i;
        ExtractorMediaSource extractorMediaSource = new ExtractorMediaSource(uri, this.mediaDataSourceFactory, new DefaultExtractorsFactory(), this.mainHandler, null);
        if (this.exoPlayer == null) {
            initExoPlayer();
        }
        this.exoPlayer.prepare(extractorMediaSource);
        this.exoPlayer.setPlayWhenReady(true);
    }

    public void stopPlayer() {
        SimpleExoPlayer simpleExoPlayer = this.exoPlayer;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setPlayWhenReady(false);
            this.exoPlayer.stop();
            this.playingItemId = -1;
            this.exoPlayerView.setVisibility(4);
        }
    }

    public void cancelDownloadFile() {
        if (this.currentObject != null) {
            MyLog.e("StoryLogPreload2", "cancel cancelDownloadFile in player " + this.currentObject.storyId);
            FileLoaderRubinoPost.getInstance(this.currentAccount).cancelLoadFile(this.currentObject);
            this.currentObject = null;
        }
    }

    public void pausePlayer() {
        SimpleExoPlayer simpleExoPlayer = this.exoPlayer;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setPlayWhenReady(false);
        }
    }

    public void resumePlayer() {
        SimpleExoPlayer simpleExoPlayer = this.exoPlayer;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setPlayWhenReady(true);
        }
    }

    public void stopAndReleasePlayer() {
        if (this.exoPlayer != null) {
            stopPlayer();
            this.exoPlayer.release();
            this.exoPlayer = null;
            this.playingItemId = -1;
            this.currentObject = null;
        }
    }

    private void initExoPlayer() {
        SimpleExoPlayer simpleExoPlayer = this.exoPlayer;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.stop();
            this.exoPlayer.release();
            this.exoPlayer = null;
        }
        if (this.exoPlayer == null) {
            this.exoPlayer = ExoPlayerFactory.newSimpleInstance(this.context, new DefaultTrackSelector(new AdaptiveTrackSelection.Factory()));
        }
        this.exoPlayer.setPlayWhenReady(true);
        this.exoPlayer.setRepeatMode(1);
        this.exoPlayerView.setPlayer(this.exoPlayer);
        this.exoPlayerView.setUseController(false);
        this.exoPlayerView.setResizeMode(4);
        this.exoPlayerView.setVisibility(4);
        this.exoPlayerView.setBackgroundColor(0);
        this.exoPlayer.addListener(new Player.EventListener() { // from class: ir.resaneh1.iptv.UIView.UI_MP4PlayerView.1
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

            /* JADX WARN: Failed to inline method: com.google.android.exoplayer2.Player.EventListener.-CC.$default$onTimelineChanged(com.google.android.exoplayer2.Player$EventListener, com.google.android.exoplayer2.Timeline, int):void */
            /* JADX WARN: Not passed register '(r1v0 'timeline' com.google.android.exoplayer2.Timeline)' in method call: com.google.android.exoplayer2.Player.EventListener.-CC.$default$onTimelineChanged(com.google.android.exoplayer2.Player$EventListener, com.google.android.exoplayer2.Timeline, int):void */
            @Override // com.google.android.exoplayer2.Player.EventListener
            public /* synthetic */ void onTimelineChanged(Timeline timeline, int i) {
                Player.EventListener.CC.$default$onTimelineChanged(this, timeline, i);
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public void onTimelineChanged(Timeline timeline, Object obj, int i) {
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public void onPlayerStateChanged(boolean z, int i) {
                if (i == 3) {
                    UI_MP4PlayerView.this.exoPlayerView.setVisibility(0);
                }
            }
        });
        Player.EventListener eventListener = this.playerEventLister;
        if (eventListener != null) {
            this.exoPlayer.addListener(eventListener);
        }
    }
}
