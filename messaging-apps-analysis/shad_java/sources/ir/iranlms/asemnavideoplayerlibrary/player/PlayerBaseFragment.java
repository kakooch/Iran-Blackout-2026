package ir.iranlms.asemnavideoplayerlibrary.player;

import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.facebook.stetho.websocket.CloseCodes;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MergingMediaSource;
import com.google.android.exoplayer2.source.SingleSampleMediaSource;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.source.dash.DefaultDashChunkSource;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.source.smoothstreaming.DefaultSsChunkSource;
import com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.FixedTrackSelection;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.google.android.exoplayer2.upstream.FileDataSource;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.cache.CacheDataSink;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.upstream.cache.LeastRecentlyUsedCacheEvictor;
import com.google.android.exoplayer2.upstream.cache.SimpleCache;
import com.google.android.exoplayer2.util.Util;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.Observable;
import ir.iranlms.asemnavideoplayerlibrary.player.MyPlaybackControlView;
import ir.iranlms.asemnavideoplayerlibrary.player.interfaces.AsemanPlayerListener;
import ir.iranlms.asemnavideoplayerlibrary.player.models.PlayObject;
import ir.iranlms.asemnavideoplayerlibrary.player.models.SubtitleObject;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.PlayerStateObject;
import java.io.File;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.Iterator;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.NotificationCenter;

/* loaded from: classes3.dex */
public class PlayerBaseFragment extends PresenterFragment implements View.OnClickListener, Player.EventListener, MyPlaybackControlView.VisibilityListener, NotificationCenter.NotificationCenterDelegate {
    private static final CookieManager DEFAULT_COOKIE_MANAGER;
    private static PlayerBaseFragment instance;
    private AsemanPlayerListener asemanPlayerListener;
    public Context context;
    private EventLogger eventLogger;
    private TrackGroupArray lastSeenTrackGroupArray;
    private Handler mainHandler;
    private DataSource.Factory mediaDataSourceFactory;
    public boolean needRetrySource;
    PlayObject playObject;
    private SimpleExoPlayer player;
    private View rootView;
    public MySimpleExoPlayerView simpleExoPlayerView;
    public DefaultTrackSelector trackSelector;
    private static final DefaultBandwidthMeter BANDWIDTH_METER = new DefaultBandwidthMeter();
    public static boolean instaIsMute = true;
    int retryCount = 0;
    boolean isInitialized = false;
    Runnable runnableRetry = new Runnable() { // from class: ir.iranlms.asemnavideoplayerlibrary.player.PlayerBaseFragment.2
        @Override // java.lang.Runnable
        public void run() {
            PlayerBaseFragment.this.initializePlayer();
            PlayerBaseFragment.this.retryCount++;
        }
    };

    private void clearResumePosition() {
    }

    private void showControls() {
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    public int getLayoutId() {
        return R.layout.player_fragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

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

    @Override // ir.iranlms.asemnavideoplayerlibrary.player.MyPlaybackControlView.VisibilityListener
    public void onVisibilityChange(int i) {
    }

    static {
        CookieManager cookieManager = new CookieManager();
        DEFAULT_COOKIE_MANAGER = cookieManager;
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ORIGINAL_SERVER);
        new FixedTrackSelection.Factory();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public Context getContext() {
        return this.context;
    }

    public static PlayerBaseFragment getInstance(PlayObject playObject, Context context) {
        PlayerBaseFragment playerBaseFragment = new PlayerBaseFragment(playObject, context);
        instance = playerBaseFragment;
        playerBaseFragment.context = context;
        playerBaseFragment.setPlayObject(playObject);
        return instance;
    }

    public PlayerBaseFragment(PlayObject playObject, Context context) {
        this.context = context;
        setPlayObject(playObject);
        createView(context);
        getNotificationCenter().addObserver(this, NotificationCenter.myMuteInsta);
    }

    public void setPlayObject(PlayObject playObject) {
        this.playObject = (PlayObject) ApplicationLoader.getGson().fromJson(ApplicationLoader.getGson().toJson(playObject), PlayObject.class);
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void init() {
        super.init();
        initPlayer();
    }

    void initPlayer() {
        clearResumePosition();
        this.mediaDataSourceFactory = buildDataSourceFactory(true);
        this.mainHandler = new Handler();
        CookieHandler cookieHandler = CookieHandler.getDefault();
        CookieManager cookieManager = DEFAULT_COOKIE_MANAGER;
        if (cookieHandler != cookieManager) {
            CookieHandler.setDefault(cookieManager);
        }
        View viewFindViewById = findViewById(R.id.root);
        this.rootView = viewFindViewById;
        viewFindViewById.setOnClickListener(this);
        MySimpleExoPlayerView mySimpleExoPlayerView = (MySimpleExoPlayerView) this.rootView.findViewById(R.id.player_view);
        this.simpleExoPlayerView = mySimpleExoPlayerView;
        mySimpleExoPlayerView.setControllerVisibilityListener(this);
        this.simpleExoPlayerView.requestFocus();
        this.simpleExoPlayerView.setPlayObject(this.playObject);
        this.simpleExoPlayerView.controller.setPlayObject(this.playObject);
        this.simpleExoPlayerView.controller.setAsemanPlayerListener(this.asemanPlayerListener);
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        PlayObject playObject;
        if (Util.SDK_INT <= 23 || this.player == null) {
            initializePlayer();
        }
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer == null || (playObject = this.playObject) == null) {
            return;
        }
        if (playObject.isForInsta) {
            simpleExoPlayer.setPlayWhenReady(true);
            if (this.playObject.isForExplore) {
                this.player.setVolume(0.0f);
                return;
            }
            return;
        }
        simpleExoPlayer.setPlayWhenReady(false);
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onPause() {
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer != null && simpleExoPlayer.getContentPosition() > 0) {
            this.playObject.setting.startTime = (int) (this.player.getCurrentPosition() / 1000);
            this.playObject.setting.autoStart = this.player.getPlayWhenReady();
        }
        try {
            this.simpleExoPlayerView.controller.hideAds();
        } catch (Exception unused) {
        }
        SimpleExoPlayer simpleExoPlayer2 = this.player;
        if (simpleExoPlayer2 != null) {
            simpleExoPlayer2.setPlayWhenReady(false);
        }
        if (Util.SDK_INT <= 23) {
            releasePlayer();
        }
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        getNotificationCenter().removeObserver(this, NotificationCenter.myMuteInsta);
        AndroidUtilities.cancelRunOnUIThread(this.runnableRetry);
        super.onFragmentDestroy();
    }

    public void initializePlayer() {
        MediaSource mediaSourceBuildMediaSource;
        if (this.playObject == null || this.simpleExoPlayerView == null) {
            return;
        }
        if (this.player == null) {
            DefaultRenderersFactory defaultRenderersFactory = new DefaultRenderersFactory(getContext(), 0);
            DefaultTrackSelector defaultTrackSelector = new DefaultTrackSelector(new AdaptiveTrackSelection.Factory());
            this.trackSelector = defaultTrackSelector;
            this.lastSeenTrackGroupArray = null;
            SimpleExoPlayer simpleExoPlayerNewSimpleInstance = ExoPlayerFactory.newSimpleInstance(this.mContext, defaultRenderersFactory, defaultTrackSelector);
            this.player = simpleExoPlayerNewSimpleInstance;
            simpleExoPlayerNewSimpleInstance.addListener(this);
            this.simpleExoPlayerView.setPlayer(this.player);
            this.simpleExoPlayerView.controller.setTrackSelector(this.trackSelector);
            this.player.setPlayWhenReady(this.playObject.setting.autoStart);
        }
        PlayObject playObject = this.playObject;
        if (!playObject.isForInsta) {
            String str = playObject.streamUrl;
            if (str == null) {
                return;
            }
            Uri uri = Uri.parse(str);
            if (this.playObject.isHls) {
                mediaSourceBuildMediaSource = buildMediaSource(uri, "m3u8");
            } else {
                mediaSourceBuildMediaSource = buildMediaSource(uri, BuildConfig.FLAVOR);
            }
            int size = this.playObject.subtitleObjects.size() + 1;
            MediaSource[] mediaSourceArr = new MediaSource[size];
            mediaSourceArr[0] = mediaSourceBuildMediaSource;
            Iterator<SubtitleObject> it = this.playObject.subtitleObjects.iterator();
            int i = 1;
            while (it.hasNext()) {
                SubtitleObject next = it.next();
                Integer num = -1;
                if (this.playObject.setting.subtitle_id == next.id) {
                    num = 1;
                }
                mediaSourceArr[i] = new SingleSampleMediaSource(Uri.parse(next.file_url), buildDataSourceFactory(false), Format.createTextSampleFormat(next.id + BuildConfig.FLAVOR, "application/x-subrip", num.intValue(), next.title), -9223372036854775807L);
                i++;
            }
            MergingMediaSource mergingMediaSource = new MergingMediaSource(mediaSourceArr);
            if (size > 1) {
                this.player.prepare(mergingMediaSource, true, true);
            } else {
                this.player.prepare(mediaSourceBuildMediaSource, true, true);
            }
        } else {
            String str2 = playObject.streamUrl;
            if (str2 == null) {
                return;
            }
            ExtractorMediaSource extractorMediaSource = new ExtractorMediaSource(Uri.parse(str2), new CacheDataSourceFactory(this.context, 104857600L, 10485760L), new DefaultExtractorsFactory(), null, null);
            this.player.setRepeatMode(1);
            this.player.prepare(extractorMediaSource, true, true);
        }
        PlayObject.Setting setting = this.playObject.setting;
        if (setting.isForcePlayFromFirst) {
            this.player.seekTo(0L);
        } else {
            if (setting.startTime >= 0) {
                this.player.seekTo(r1 * CloseCodes.NORMAL_CLOSURE);
            }
        }
        PlayObject playObject2 = this.playObject;
        if (playObject2.isForInsta) {
            long j = playObject2.startTimeForInsta;
            if (j > 0) {
                this.player.seekTo(j);
            }
        }
        if (!this.playObject.setting.autoStart) {
            this.player.setPlayWhenReady(false);
        } else {
            this.player.setPlayWhenReady(true);
        }
        PlayObject playObject3 = this.playObject;
        if (playObject3 != null && playObject3.isForInsta) {
            if (instaIsMute || playObject3.isForExplore) {
                this.player.setVolume(0.0f);
            } else {
                this.player.setVolume(1.0f);
            }
        }
        PlayObject playObject4 = this.playObject;
        if (playObject4.isForInsta || playObject4.isForExplore) {
            this.simpleExoPlayerView.setResizeMode(4);
        } else {
            this.simpleExoPlayerView.setResizeMode(0);
        }
        updateButtonVisibilities();
    }

    void setDefaultSubtitle() {
        MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo = this.trackSelector.getCurrentMappedTrackInfo();
        if (currentMappedTrackInfo != null) {
            for (int i = 0; i < currentMappedTrackInfo.length; i++) {
                TrackGroupArray trackGroups = currentMappedTrackInfo.getTrackGroups(i);
                if (trackGroups.length != 0 && this.player.getRendererType(i) == 3) {
                    MyLog.e("trackGropus Subtitle", trackGroups.length + " " + trackGroups.toString());
                    for (int i2 = 0; i2 < trackGroups.length; i2++) {
                        String str = trackGroups.get(i2).getFormat(0).id;
                        MyLog.e("playObject Subtittel", "subtitle id" + str);
                        str.equals(this.playObject.setting.subtitle_id + BuildConfig.FLAVOR);
                    }
                }
            }
        }
    }

    void setDefaultQuality() {
        DefaultTrackSelector defaultTrackSelector;
        MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo;
        if (this.playObject.setting.quality_id < 0 || (defaultTrackSelector = this.trackSelector) == null || (currentMappedTrackInfo = defaultTrackSelector.getCurrentMappedTrackInfo()) == null) {
            return;
        }
        for (int i = 0; i < currentMappedTrackInfo.length; i++) {
            TrackGroupArray trackGroups = currentMappedTrackInfo.getTrackGroups(i);
            if (trackGroups.length != 0 && this.player.getRendererType(i) == 2) {
                TrackGroup trackGroup = trackGroups.get(0);
                int i2 = trackGroup.length;
                int i3 = this.playObject.setting.quality_id;
                if (i2 > i3) {
                    trackGroup.getFormat(i3);
                }
            }
        }
    }

    private MediaSource buildMediaSource(Uri uri, String str) {
        int iInferContentType;
        if (TextUtils.isEmpty(str)) {
            iInferContentType = Util.inferContentType(uri);
        } else {
            iInferContentType = Util.inferContentType("." + str);
        }
        if (iInferContentType == 0) {
            return new DashMediaSource(uri, buildDataSourceFactory(false), new DefaultDashChunkSource.Factory(this.mediaDataSourceFactory), this.mainHandler, this.eventLogger);
        }
        if (iInferContentType == 1) {
            return new SsMediaSource(uri, buildDataSourceFactory(false), new DefaultSsChunkSource.Factory(this.mediaDataSourceFactory), this.mainHandler, this.eventLogger);
        }
        if (iInferContentType == 2) {
            return new HlsMediaSource.Factory(this.mediaDataSourceFactory).createMediaSource(uri);
        }
        if (iInferContentType == 3) {
            return new ExtractorMediaSource(uri, this.mediaDataSourceFactory, new DefaultExtractorsFactory(), this.mainHandler, this.eventLogger);
        }
        throw new IllegalStateException("Unsupported type: " + iInferContentType);
    }

    public void releasePlayer() {
        this.isInitialized = false;
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.getPlayWhenReady();
            updateResumePosition();
            this.player.release();
            this.player = null;
            this.trackSelector = null;
            this.simpleExoPlayerView.setPlayer(null);
        }
        try {
            this.simpleExoPlayerView.controller.hideAds();
        } catch (Exception unused) {
        }
    }

    public Observable<PlayerStateObject> getPlayerStateObjectObservable() {
        MyPlaybackControlView myPlaybackControlView;
        MySimpleExoPlayerView mySimpleExoPlayerView = this.simpleExoPlayerView;
        if (mySimpleExoPlayerView == null || (myPlaybackControlView = mySimpleExoPlayerView.controller) == null) {
            return null;
        }
        return myPlaybackControlView.getPlayerStateObjectObservable();
    }

    private void updateResumePosition() {
        this.player.getCurrentWindowIndex();
        if (this.player.isCurrentWindowSeekable()) {
            Math.max(0L, this.player.getCurrentPosition());
        }
    }

    private DataSource.Factory buildDataSourceFactory(boolean z) {
        return new DefaultDataSourceFactory(getContext(), z ? BANDWIDTH_METER : null, buildHttpDataSourceFactory(z));
    }

    private HttpDataSource.Factory buildHttpDataSourceFactory(boolean z) {
        return new DefaultHttpDataSourceFactory(Util.getUserAgent(getContext(), "AsemanVideoPlayer"), z ? BANDWIDTH_METER : null);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onPlayerStateChanged(boolean z, int i) {
        if (i == 3) {
            try {
                this.retryCount = 0;
                this.simpleExoPlayerView.controller.retryImageView.setVisibility(4);
            } catch (Exception e) {
                MyLog.handleException(e);
                return;
            }
        }
        if (i == 4) {
            showControls();
        }
        if (i == 3 && !this.isInitialized) {
            MyLog.e("stateeee", "changed");
            this.isInitialized = true;
            setDefaultSubtitle();
            setDefaultQuality();
        }
        updateButtonVisibilities();
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onPlayerError(ExoPlaybackException exoPlaybackException) {
        try {
            this.playObject.setting.startTime = ((int) this.player.getContentPosition()) / CloseCodes.NORMAL_CLOSURE;
            if (this.retryCount > 10) {
                this.simpleExoPlayerView.controller.retryImageView.setVisibility(0);
                this.simpleExoPlayerView.controller.loadingProgressBar.setVisibility(4);
                this.simpleExoPlayerView.controller.retryImageView.setOnClickListener(new View.OnClickListener() { // from class: ir.iranlms.asemnavideoplayerlibrary.player.PlayerBaseFragment.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        try {
                            PlayerBaseFragment playerBaseFragment = PlayerBaseFragment.this;
                            playerBaseFragment.retryCount = 0;
                            playerBaseFragment.simpleExoPlayerView.controller.retryImageView.setVisibility(4);
                            PlayerBaseFragment.this.simpleExoPlayerView.controller.loadingProgressBar.setVisibility(0);
                            PlayerBaseFragment.this.initializePlayer();
                        } catch (Exception e) {
                            MyLog.handleException(e);
                        }
                    }
                });
            } else {
                this.simpleExoPlayerView.controller.retryImageView.setVisibility(4);
                this.simpleExoPlayerView.controller.loadingProgressBar.setVisibility(0);
                AndroidUtilities.cancelRunOnUIThread(this.runnableRetry);
                AndroidUtilities.runOnUIThread(this.runnableRetry, 5000L);
            }
        } catch (Exception e) {
            MyLog.handleException(e);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
        updateButtonVisibilities();
        if (trackGroupArray != this.lastSeenTrackGroupArray) {
            this.trackSelector.getCurrentMappedTrackInfo();
            this.lastSeenTrackGroupArray = trackGroupArray;
        }
        PlayObject playObject = this.playObject;
        if (playObject == null || !playObject.isForInsta) {
            return;
        }
        long j = playObject.startTimeForInsta;
        if (j > 0) {
            this.player.seekTo(j);
        }
    }

    private void updateButtonVisibilities() {
        if (this.player == null) {
            return;
        }
        this.trackSelector.getCurrentMappedTrackInfo();
    }

    public boolean consumeBackPress() {
        if (this.simpleExoPlayerView.controller.consumeBackPress()) {
            return true;
        }
        MyPlaybackControlView myPlaybackControlView = this.simpleExoPlayerView.controller;
        if (myPlaybackControlView.isCurrentFullScreen && !myPlaybackControlView.isJustFullScreen) {
            myPlaybackControlView.showVideoInNormalMode();
            return true;
        }
        return false;
    }

    public void setAsemanPlayerListener(AsemanPlayerListener asemanPlayerListener) {
        this.asemanPlayerListener = asemanPlayerListener;
        MySimpleExoPlayerView mySimpleExoPlayerView = this.simpleExoPlayerView;
        if (mySimpleExoPlayerView != null) {
            mySimpleExoPlayerView.controller.setAsemanPlayerListener(asemanPlayerListener);
        }
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onConfigurationChanged(Configuration configuration) {
        MyLog.e("newCofig", "new");
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        PlayObject playObject;
        try {
            if (i == NotificationCenter.myMuteInsta) {
                boolean zBooleanValue = ((Boolean) objArr[0]).booleanValue();
                instaIsMute = zBooleanValue;
                if (zBooleanValue || ((playObject = this.playObject) != null && playObject.isForExplore)) {
                    this.player.setVolume(0.0f);
                } else {
                    this.player.setVolume(1.0f);
                }
                this.simpleExoPlayerView.controller.refreshMuteImageView();
            }
        } catch (Exception unused) {
        }
    }

    public static class CacheDataSourceFactory implements DataSource.Factory {
        static SimpleCache simpleCache;
        private final Context context;
        private final DefaultDataSourceFactory defaultDatasourceFactory;
        private final long maxCacheSize;
        private final long maxFileSize;

        public CacheDataSourceFactory(Context context, long j, long j2) {
            this.context = context;
            this.maxCacheSize = j;
            this.maxFileSize = j2;
            String userAgent = Util.getUserAgent(context, "AsemanVideoPlayer");
            DefaultBandwidthMeter defaultBandwidthMeter = new DefaultBandwidthMeter();
            this.defaultDatasourceFactory = new DefaultDataSourceFactory(context, defaultBandwidthMeter, new DefaultHttpDataSourceFactory(userAgent, defaultBandwidthMeter));
        }

        @Override // com.google.android.exoplayer2.upstream.DataSource.Factory
        public DataSource createDataSource() {
            if (simpleCache == null) {
                simpleCache = new SimpleCache(new File(this.context.getCacheDir(), "media"), new LeastRecentlyUsedCacheEvictor(this.maxCacheSize));
            }
            return new CacheDataSource(simpleCache, this.defaultDatasourceFactory.createDataSource(), new FileDataSource(), new CacheDataSink(simpleCache, this.maxFileSize), 3, null);
        }
    }
}
