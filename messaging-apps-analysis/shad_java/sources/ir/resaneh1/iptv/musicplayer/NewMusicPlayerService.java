package ir.resaneh1.iptv.musicplayer;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.target.NotificationTarget;
import com.google.android.exoplayer2t.DefaultLoadControl;
import com.google.android.exoplayer2t.ExoPlaybackException;
import com.google.android.exoplayer2t.ExoPlayerFactory;
import com.google.android.exoplayer2t.PlaybackParameters;
import com.google.android.exoplayer2t.Player;
import com.google.android.exoplayer2t.SimpleExoPlayer;
import com.google.android.exoplayer2t.Timeline;
import com.google.android.exoplayer2t.source.TrackGroupArray;
import com.google.android.exoplayer2t.source.hls.HlsMediaSource;
import com.google.android.exoplayer2t.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2t.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2t.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2t.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2t.util.Util;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.GetStreamUrlInput;
import ir.resaneh1.iptv.model.GetStreamUrlOutput;
import ir.resaneh1.iptv.model.Link;
import ir.resaneh1.iptv.model.PushNotificationObject;
import ir.resaneh1.iptv.model.TagObject;
import ir.resaneh1.iptv.model.ViewStreamInput;
import ir.resaneh1.iptv.musicplayer.PlayableAudioObject;
import java.util.ArrayList;
import java.util.List;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.ui.LaunchActivity;
import org.webrtc.MediaStreamTrack;
import retrofit2.Call;
import retrofit2.Response;

/* loaded from: classes3.dex */
public class NewMusicPlayerService extends Service {
    public static String NEXT_ACTION = "ir.resaneh1.iptv.action.next";
    public static String PAUSE_ACTION = "ir.resaneh1.iptv.action.pause";
    public static String PLAY_ACTION = "ir.resaneh1.iptv.action.play";
    public static String PREV_ACTION = "ir.resaneh1.iptv.action.prev";
    public static String RUBIKA_MUSIC_GROUP_ID = " music_id";
    public static String RUBIKA_MUSIC_GROUP_NAME = "Music Group";
    public static int RUBIKA_MUSIC_PLAYER_NOTIFICATION_ID = 1;
    public static String RUBIKA_NOTIFICATION_CHANNEL_DESC = "Music Player";
    public static String RUBIKA_NOTIFICATION_CHANNEL_ID = "1846734";
    public static String RUBIKA_NOTIFICATION_CHANNEL_NAME = "Music Channel";
    public static String STARTFOREGROUND_ACTION = "ir.resaneh1.iptv.action.startforeground";
    public static String STOPFOREGROUND_ACTION = "ir.resaneh1.iptv.action.stopforeground";
    public static NewMusicPlayerService instance;
    public SimpleExoPlayer exoPlayer;
    private AudioManager mAudioManager;
    public PlayableAudioObject mCurrentMediaItem;
    NotificationManager mNotificationManager;
    Notification mPlayerNotification;
    public PlayState currentMediaState = PlayState.none;
    public ArrayList<PlayableAudioObject> playList = new ArrayList<>();
    private boolean isLastPlaying = false;
    private Handler mMediaPlayerHandler = new Handler() { // from class: ir.resaneh1.iptv.musicplayer.NewMusicPlayerService.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 2) {
                return;
            }
            int i = message.arg1;
            if (i == -3) {
                MyLog.e("MusicPlaybackService", "AudioFocus: Received AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK.");
                NewMusicPlayerService newMusicPlayerService = NewMusicPlayerService.this;
                newMusicPlayerService.isLastPlaying = newMusicPlayerService.isPlaying();
                if (NewMusicPlayerService.this.getCurrentMediaItem() == null || !NewMusicPlayerService.this.isPlaying()) {
                    return;
                }
                NewMusicPlayerService.this.pause();
                return;
            }
            if (i == -2) {
                MyLog.e("MusicPlaybackService", "AudioFocus: Received AUDIOFOCUS_LOSS_TRANSIENT.");
                NewMusicPlayerService newMusicPlayerService2 = NewMusicPlayerService.this;
                newMusicPlayerService2.isLastPlaying = newMusicPlayerService2.isPlaying();
                if (NewMusicPlayerService.this.getCurrentMediaItem() == null || !NewMusicPlayerService.this.isPlaying()) {
                    return;
                }
                NewMusicPlayerService.this.pause();
                return;
            }
            if (i != -1) {
                if (i != 1) {
                    return;
                }
                MyLog.e("MusicPlaybackService", "AudioFocus: Received AUDIOFOCUS_GAIN.");
                if (NewMusicPlayerService.this.getCurrentMediaItem() == null || !NewMusicPlayerService.this.isLastPlaying) {
                    return;
                }
                NewMusicPlayerService.this.play();
                return;
            }
            if (NewMusicPlayerService.this.mAudioManager.abandonAudioFocus(NewMusicPlayerService.this.mOnAudioFocusChangeListener) != 1) {
                MyLog.e("MusicPlaybackService", "abandonAudioFocus after AudioFocus_LOSS failed!");
            }
            MyLog.e("MusicPlaybackService", "AudioFocus: Received AUDIOFOCUS_LOSS.");
            NewMusicPlayerService newMusicPlayerService3 = NewMusicPlayerService.this;
            newMusicPlayerService3.isLastPlaying = newMusicPlayerService3.isPlaying();
            if (NewMusicPlayerService.this.getCurrentMediaItem() == null || !NewMusicPlayerService.this.isPlaying()) {
                return;
            }
            NewMusicPlayerService.this.pause();
        }
    };
    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() { // from class: ir.resaneh1.iptv.musicplayer.NewMusicPlayerService.2
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            NewMusicPlayerService.this.mMediaPlayerHandler.obtainMessage(2, i, 0).sendToTarget();
        }
    };
    private String logTag = "musicService";
    private Handler handler = new Handler();
    private int viewStreamCallPeriod = 30000;
    private int retryCount = 0;
    private List<ServiceCallback> mServiceCallbacks = new ArrayList();
    private final IBinder mBinder = new LocalBinder();
    Runnable retryRunnable = new Runnable() { // from class: ir.resaneh1.iptv.musicplayer.NewMusicPlayerService.6
        @Override // java.lang.Runnable
        public void run() {
            NewMusicPlayerService newMusicPlayerService = NewMusicPlayerService.this;
            PlayableAudioObject playableAudioObject = newMusicPlayerService.mCurrentMediaItem;
            if (playableAudioObject == null || newMusicPlayerService.exoPlayer == null) {
                return;
            }
            newMusicPlayerService.playMedia(playableAudioObject);
        }
    };
    Runnable runnable = new Runnable() { // from class: ir.resaneh1.iptv.musicplayer.NewMusicPlayerService.7
        @Override // java.lang.Runnable
        public void run() {
            if (NewMusicPlayerService.this.callViewStream()) {
                NewMusicPlayerService newMusicPlayerService = NewMusicPlayerService.this;
                newMusicPlayerService.startTimer(newMusicPlayerService.viewStreamCallPeriod);
            }
        }
    };

    public interface ServiceCallback {
        void onMediaStateChangedByPlaybackService(PlayableAudioObject playableAudioObject, PlayState playState);
    }

    public void play() {
        try {
            this.retryCount = 0;
            SimpleExoPlayer simpleExoPlayer = this.exoPlayer;
            if (simpleExoPlayer == null) {
                return;
            }
            simpleExoPlayer.setPlayWhenReady(true);
            startTimer(this.viewStreamCallPeriod);
        } catch (Exception unused) {
        }
    }

    public void pause() {
        try {
            this.retryCount = 0;
            SimpleExoPlayer simpleExoPlayer = this.exoPlayer;
            if (simpleExoPlayer == null) {
                return;
            }
            simpleExoPlayer.setPlayWhenReady(false);
            cancelTimer();
        } catch (Exception unused) {
        }
    }

    public boolean isPlayButtonInvisible() {
        SimpleExoPlayer simpleExoPlayer = this.exoPlayer;
        return simpleExoPlayer != null && simpleExoPlayer.getPlayWhenReady();
    }

    public void tenSecondForward() {
        this.retryCount = 0;
        try {
            SimpleExoPlayer simpleExoPlayer = this.exoPlayer;
            if (simpleExoPlayer != null) {
                simpleExoPlayer.seekTo(simpleExoPlayer.getCurrentPosition() + 10000);
            }
        } catch (Exception unused) {
        }
    }

    public void tenSecondBackward() {
        this.retryCount = 0;
        try {
            SimpleExoPlayer simpleExoPlayer = this.exoPlayer;
            if (simpleExoPlayer != null) {
                simpleExoPlayer.seekTo(simpleExoPlayer.getCurrentPosition() - 10000);
            }
        } catch (Exception unused) {
        }
    }

    public void registerServiceCallback(ServiceCallback serviceCallback) {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("The provided service callback is null.");
        }
        this.mServiceCallbacks.add(serviceCallback);
        PlayableAudioObject playableAudioObject = this.mCurrentMediaItem;
        if (playableAudioObject != null) {
            serviceCallback.onMediaStateChangedByPlaybackService(playableAudioObject, this.currentMediaState);
        }
    }

    public static void staticStopService(Context context) {
        ServiceConnection serviceConnection = new ServiceConnection() { // from class: ir.resaneh1.iptv.musicplayer.NewMusicPlayerService.3
            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                MyLog.e("MusicPlaybackService", "service Connected");
                ((LocalBinder) iBinder).getService().stopService();
            }
        };
        Intent intent = new Intent(context, (Class<?>) NewMusicPlayerService.class);
        context.startService(intent);
        context.bindService(intent, serviceConnection, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopService() {
        Log.d("MusicPlaybackService", "stop service");
        MyLog.e("MusicPlaybackService", "stop service");
        try {
            SimpleExoPlayer simpleExoPlayer = this.exoPlayer;
            if (simpleExoPlayer != null) {
                simpleExoPlayer.release(false);
            }
            notifyMediaStateChanged(PlayState.serviceDestroyed);
            cancelTimer();
            stopSelf();
        } catch (Exception e) {
            MyLog.e("MusicPlaybackService", "exception" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyMediaStateChanged(PlayState playState) {
        this.currentMediaState = playState;
        MyLog.e("mediaState:", this.currentMediaState + BuildConfig.FLAVOR);
        if (playState != PlayState.serviceDestroyed) {
            showNotification();
        }
        for (int size = this.mServiceCallbacks.size() - 1; size >= 0; size--) {
            this.mServiceCallbacks.get(size).onMediaStateChangedByPlaybackService(this.mCurrentMediaItem, playState);
        }
    }

    public class LocalBinder extends Binder {
        public LocalBinder() {
        }

        public NewMusicPlayerService getService() {
            return NewMusicPlayerService.this;
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        MyLog.e(this.logTag, "created");
        new DefaultTrackSelector();
        this.mAudioManager = (AudioManager) getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        MyLog.e("MusicPlaybackService", "onCreate: ");
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        MyLog.e("NewMusicPlayerService", "onStartCommand");
        if (intent == null || intent.getAction() == null) {
            return 2;
        }
        MyLog.e("NewMusicPlayerService", "onStartCommand " + intent.getAction());
        if (intent.getAction().equals(STARTFOREGROUND_ACTION)) {
            showNotification();
            return 2;
        }
        if (intent.getAction().equals(PREV_ACTION)) {
            playPrevious();
            return 2;
        }
        if (intent.getAction().equals(PLAY_ACTION)) {
            MyLog.e("NewMusicPlayerService", "onStartCommand play");
            play();
            return 2;
        }
        if (intent.getAction().equals(PAUSE_ACTION)) {
            MyLog.e("NewMusicPlayerService", "onStartCommand pause");
            pause();
            return 2;
        }
        if (intent.getAction().equals(NEXT_ACTION)) {
            playNext();
            return 2;
        }
        if (!intent.getAction().equals(STOPFOREGROUND_ACTION)) {
            return 2;
        }
        MyLog.e("NewMusicPlayerService", "onStartCommand stop");
        if (Build.VERSION.SDK_INT >= 26) {
            stopForeground(false);
            NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
            this.mNotificationManager = notificationManager;
            if (notificationManager != null) {
                notificationManager.deleteNotificationChannel(RUBIKA_NOTIFICATION_CHANNEL_ID);
            }
        } else {
            stopForeground(true);
        }
        stopSelf();
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playMediaItem(PlayableAudioObject playableAudioObject) {
        try {
            cancelTimerRetry();
            cancelTimer();
            startTimer(this.viewStreamCallPeriod);
            if (playableAudioObject == null) {
                return;
            }
            if (this.mAudioManager.requestAudioFocus(this.mOnAudioFocusChangeListener, 3, 1) != 1) {
                MyLog.e("MusicPlaybackService", "playMediaItem cannot obtain audio focus!");
                return;
            }
            if (this.exoPlayer == null) {
                SimpleExoPlayer simpleExoPlayerNewSimpleInstance = ExoPlayerFactory.newSimpleInstance(this, new DefaultTrackSelector(), new DefaultLoadControl());
                this.exoPlayer = simpleExoPlayerNewSimpleInstance;
                simpleExoPlayerNewSimpleInstance.addListener(new Player.EventListener() { // from class: ir.resaneh1.iptv.musicplayer.NewMusicPlayerService.4
                    @Override // com.google.android.exoplayer2t.Player.EventListener
                    public /* synthetic */ void onIsPlayingChanged(boolean z) {
                        Player.EventListener.CC.$default$onIsPlayingChanged(this, z);
                    }

                    @Override // com.google.android.exoplayer2t.Player.EventListener
                    public void onLoadingChanged(boolean z) {
                    }

                    @Override // com.google.android.exoplayer2t.Player.EventListener
                    public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
                    }

                    @Override // com.google.android.exoplayer2t.Player.EventListener
                    public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i) {
                        Player.EventListener.CC.$default$onPlaybackSuppressionReasonChanged(this, i);
                    }

                    @Override // com.google.android.exoplayer2t.Player.EventListener
                    public void onPositionDiscontinuity(int i) {
                    }

                    @Override // com.google.android.exoplayer2t.Player.EventListener
                    public void onRepeatModeChanged(int i) {
                    }

                    @Override // com.google.android.exoplayer2t.Player.EventListener
                    public void onSeekProcessed() {
                    }

                    /* JADX WARN: Failed to inline method: com.google.android.exoplayer2t.Player.EventListener.-CC.$default$onTimelineChanged(com.google.android.exoplayer2t.Player$EventListener, com.google.android.exoplayer2t.Timeline, int):void */
                    /* JADX WARN: Not passed register '(r1v0 'timeline' com.google.android.exoplayer2t.Timeline)' in method call: com.google.android.exoplayer2t.Player.EventListener.-CC.$default$onTimelineChanged(com.google.android.exoplayer2t.Player$EventListener, com.google.android.exoplayer2t.Timeline, int):void */
                    @Override // com.google.android.exoplayer2t.Player.EventListener
                    public /* synthetic */ void onTimelineChanged(Timeline timeline, int i) {
                        Player.EventListener.CC.$default$onTimelineChanged(this, timeline, i);
                    }

                    @Override // com.google.android.exoplayer2t.Player.EventListener
                    public void onTimelineChanged(Timeline timeline, Object obj, int i) {
                    }

                    @Override // com.google.android.exoplayer2t.Player.EventListener
                    public void onPlayerStateChanged(boolean z, int i) {
                        MyLog.e("MusicPlaybackService", "Listener-onPlayerStateChanged..." + z + " " + i);
                        if (i == 3 && z) {
                            NewMusicPlayerService.this.notifyMediaStateChanged(PlayState.mediaPlaying);
                            NewMusicPlayerService.this.retryCount = 0;
                        } else if (i == 3 && !z) {
                            NewMusicPlayerService.this.notifyMediaStateChanged(PlayState.mediaPaused);
                        } else if (i == 4) {
                            NewMusicPlayerService.this.playNext();
                        } else if (i == 2) {
                            NewMusicPlayerService.this.notifyMediaStateChanged(PlayState.preparingMedia);
                        }
                    }

                    @Override // com.google.android.exoplayer2t.Player.EventListener
                    public void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
                        MyLog.e("MusicPlaybackService", "Listener-onTracksChanged...");
                    }

                    @Override // com.google.android.exoplayer2t.Player.EventListener
                    public void onPlayerError(ExoPlaybackException exoPlaybackException) {
                        try {
                            NewMusicPlayerService newMusicPlayerService = NewMusicPlayerService.this;
                            newMusicPlayerService.mCurrentMediaItem.startTime = newMusicPlayerService.exoPlayer.getCurrentPosition() / 1000;
                            NewMusicPlayerService.this.startTimerRetry();
                        } catch (Exception unused) {
                        }
                    }
                });
            }
            this.exoPlayer.prepare(new HlsMediaSource.Factory(new DefaultDataSourceFactory(this, Util.getUserAgent(this, "exoplayer2example"), new DefaultBandwidthMeter())).createMediaSource(Uri.parse(playableAudioObject.streamUrl)));
            this.exoPlayer.setPlayWhenReady(true);
            this.mNotificationManager = (NotificationManager) getSystemService("notification");
            notifyMediaStateChanged(PlayState.preparingMedia);
            long j = this.mCurrentMediaItem.startTime;
            if (j > 0) {
                try {
                    this.exoPlayer.seekTo(j * 1000);
                } catch (Exception unused) {
                }
                this.mCurrentMediaItem.startTime = 0L;
            }
        } catch (Exception e) {
            MyLog.handleException(e);
        }
    }

    public void playMedia(PlayableAudioObject playableAudioObject) {
        if (playableAudioObject == null) {
            return;
        }
        this.mCurrentMediaItem = playableAudioObject;
        callGetStream(playableAudioObject);
    }

    private void callGetStream(final PlayableAudioObject playableAudioObject) {
        notifyMediaStateChanged(PlayState.prepareStreamUrl);
        if (playableAudioObject.streamUrl == null) {
            if (playableAudioObject.type == PlayableAudioObject.Type.aod) {
                ApiRequestIPTV.getInstance(playableAudioObject.currentAccount).getStreamUrl(new GetStreamUrlInput(playableAudioObject.getId(), TagObject.TagType.aod_track.name()), new ApiRequestIPTV.Listener() { // from class: ir.resaneh1.iptv.musicplayer.NewMusicPlayerService.5
                    @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
                    public void onResponse(Call call, Response response) {
                        GetStreamUrlOutput getStreamUrlOutput = (GetStreamUrlOutput) response.body();
                        PlayableAudioObject playableAudioObject2 = playableAudioObject;
                        playableAudioObject2.streamUrl = getStreamUrlOutput.playObject.streamUrl;
                        playableAudioObject2.aodViewId = getStreamUrlOutput.viewId;
                        NewMusicPlayerService.this.playMediaItem(playableAudioObject2);
                    }

                    @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
                    public void onFailure(Call call, Throwable th) {
                        NewMusicPlayerService.this.startTimerRetry();
                    }
                });
                return;
            }
            return;
        }
        playMediaItem(playableAudioObject);
    }

    public boolean isPlaying() {
        SimpleExoPlayer simpleExoPlayer = this.exoPlayer;
        return simpleExoPlayer != null && simpleExoPlayer.getPlayWhenReady() && this.exoPlayer.getPlaybackState() == 3;
    }

    public int getCurrentPosition() {
        try {
            MyLog.e(this.logTag, this.exoPlayer.getPlaybackState() + " state");
            SimpleExoPlayer simpleExoPlayer = this.exoPlayer;
            if (simpleExoPlayer == null) {
                return 0;
            }
            if (simpleExoPlayer.getPlaybackState() == 3 || this.exoPlayer.getPlaybackState() == 2) {
                return (int) this.exoPlayer.getCurrentPosition();
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    public int getDuration() {
        try {
            SimpleExoPlayer simpleExoPlayer = this.exoPlayer;
            if (simpleExoPlayer == null) {
                return 0;
            }
            if ((simpleExoPlayer.getPlaybackState() == 3 || this.exoPlayer.getPlaybackState() == 2) && ((int) this.exoPlayer.getDuration()) == this.exoPlayer.getDuration()) {
                return (int) this.exoPlayer.getDuration();
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    public PlayableAudioObject getCurrentMediaItem() {
        return this.mCurrentMediaItem;
    }

    public void seekTo(int i) {
        SimpleExoPlayer simpleExoPlayer = this.exoPlayer;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.seekTo(i);
            notifyMediaStateChanged(this.currentMediaState);
        }
    }

    public boolean isLoading() {
        try {
            PlayState playState = this.currentMediaState;
            if (playState == PlayState.prepareStreamUrl || playState == PlayState.waitForRetry || playState == PlayState.preparingMedia) {
                return true;
            }
            SimpleExoPlayer simpleExoPlayer = this.exoPlayer;
            if (simpleExoPlayer != null) {
                return simpleExoPlayer.getPlaybackState() == 2;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private void showNotification() {
        Intent intent;
        try {
            RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.music_notification_collapsed);
            RemoteViews remoteViews2 = new RemoteViews(getPackageName(), R.layout.music_notification_expanded);
            this.mNotificationManager = (NotificationManager) getSystemService("notification");
            if (this.mCurrentMediaItem != null) {
                PushNotificationObject pushNotificationObject = new PushNotificationObject();
                Link link = new Link();
                pushNotificationObject.link = link;
                link.type = Link.LinkTypeEnum.action;
                link.action = Link.EnumBannerAction.openPlayingMusic;
                intent = LaunchActivity.createIntent(this, pushNotificationObject, this.mCurrentMediaItem.currentAccount);
            } else {
                intent = new Intent(this, (Class<?>) LaunchActivity.class);
            }
            PendingIntent activity = PendingIntent.getActivity(this, 0, intent, 167772160);
            Intent intent2 = new Intent(this, (Class<?>) NewMusicPlayerService.class);
            intent2.setAction(PREV_ACTION);
            PendingIntent service = PendingIntent.getService(this, 0, intent2, ConnectionsManager.FileTypeVideo);
            Intent intent3 = new Intent(this, (Class<?>) NewMusicPlayerService.class);
            intent3.setAction(PLAY_ACTION);
            PendingIntent service2 = PendingIntent.getService(this, 0, intent3, ConnectionsManager.FileTypeVideo);
            Intent intent4 = new Intent(this, (Class<?>) NewMusicPlayerService.class);
            intent4.setAction(PAUSE_ACTION);
            PendingIntent service3 = PendingIntent.getService(this, 0, intent4, ConnectionsManager.FileTypeVideo);
            Intent intent5 = new Intent(this, (Class<?>) NewMusicPlayerService.class);
            intent5.setAction(NEXT_ACTION);
            PendingIntent service4 = PendingIntent.getService(this, 0, intent5, ConnectionsManager.FileTypeVideo);
            Intent intent6 = new Intent(this, (Class<?>) NewMusicPlayerService.class);
            intent6.setAction(STOPFOREGROUND_ACTION);
            PendingIntent service5 = PendingIntent.getService(this, 0, intent6, ConnectionsManager.FileTypeVideo);
            remoteViews.setOnClickPendingIntent(R.id.status_bar_play, service2);
            remoteViews2.setOnClickPendingIntent(R.id.status_bar_play, service2);
            remoteViews.setOnClickPendingIntent(R.id.status_bar_pause, service3);
            remoteViews2.setOnClickPendingIntent(R.id.status_bar_pause, service3);
            remoteViews.setOnClickPendingIntent(R.id.status_bar_next, service4);
            remoteViews2.setOnClickPendingIntent(R.id.status_bar_next, service4);
            remoteViews.setOnClickPendingIntent(R.id.status_bar_prev, service);
            remoteViews2.setOnClickPendingIntent(R.id.status_bar_prev, service);
            remoteViews.setOnClickPendingIntent(R.id.status_bar_collapse, service5);
            remoteViews2.setOnClickPendingIntent(R.id.status_bar_collapse, service5);
            if (isPlayButtonInvisible()) {
                remoteViews.setViewVisibility(R.id.status_bar_pause, 0);
                remoteViews2.setViewVisibility(R.id.status_bar_pause, 0);
                remoteViews.setViewVisibility(R.id.status_bar_play, 8);
                remoteViews2.setViewVisibility(R.id.status_bar_play, 8);
            } else {
                remoteViews.setViewVisibility(R.id.status_bar_play, 0);
                remoteViews2.setViewVisibility(R.id.status_bar_play, 0);
                remoteViews.setViewVisibility(R.id.status_bar_pause, 8);
                remoteViews2.setViewVisibility(R.id.status_bar_pause, 8);
            }
            if (isLoading()) {
                remoteViews.setViewVisibility(R.id.status_bar_progress, 0);
                remoteViews2.setViewVisibility(R.id.status_bar_progress, 0);
            } else {
                remoteViews.setViewVisibility(R.id.status_bar_progress, 8);
                remoteViews2.setViewVisibility(R.id.status_bar_progress, 8);
            }
            remoteViews.setTextViewText(R.id.status_bar_track_name, this.mCurrentMediaItem.getTitle());
            remoteViews2.setTextViewText(R.id.status_bar_track_name, this.mCurrentMediaItem.getTitle());
            remoteViews.setTextViewText(R.id.status_bar_artist_name, this.mCurrentMediaItem.getSubtitle());
            remoteViews2.setTextViewText(R.id.status_bar_artist_name, this.mCurrentMediaItem.getSubtitle());
            remoteViews2.setTextViewText(R.id.status_bar_album_name, BuildConfig.FLAVOR);
            int i = Build.VERSION.SDK_INT;
            if (i >= 26) {
                NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
                if (notificationManager.getNotificationChannel(RUBIKA_NOTIFICATION_CHANNEL_ID) == null) {
                    if (i >= 28 && notificationManager.getNotificationChannelGroup(RUBIKA_MUSIC_GROUP_ID) == null) {
                        notificationManager.createNotificationChannelGroup(new NotificationChannelGroup(RUBIKA_MUSIC_GROUP_ID, RUBIKA_MUSIC_GROUP_NAME));
                    }
                    NotificationChannel notificationChannel = new NotificationChannel(RUBIKA_NOTIFICATION_CHANNEL_ID, RUBIKA_NOTIFICATION_CHANNEL_NAME, 3);
                    notificationChannel.setDescription(RUBIKA_NOTIFICATION_CHANNEL_DESC);
                    notificationChannel.setSound(null, null);
                    notificationChannel.setShowBadge(false);
                    if (i >= 28) {
                        notificationChannel.setGroup(RUBIKA_MUSIC_GROUP_ID);
                    }
                    notificationManager.createNotificationChannel(notificationChannel);
                }
            }
            Notification notificationBuild = new NotificationCompat.Builder(this, RUBIKA_NOTIFICATION_CHANNEL_ID).setPriority(1).setSmallIcon(android.R.drawable.ic_media_play).setVisibility(1).setCustomContentView(remoteViews).setCustomBigContentView(remoteViews2).setGroup(RUBIKA_MUSIC_GROUP_ID).build();
            this.mPlayerNotification = notificationBuild;
            notificationBuild.flags = 2;
            notificationBuild.icon = android.R.drawable.ic_media_play;
            notificationBuild.contentIntent = activity;
            NotificationTarget notificationTarget = new NotificationTarget(this, R.id.status_bar_album_art, remoteViews2, notificationBuild, RUBIKA_MUSIC_PLAYER_NOTIFICATION_ID);
            Glide.with(this).asBitmap().load(this.mCurrentMediaItem.getImageUrl()).into((RequestBuilder<Bitmap>) new NotificationTarget(this, R.id.status_bar_album_art, remoteViews, this.mPlayerNotification, RUBIKA_MUSIC_PLAYER_NOTIFICATION_ID));
            Glide.with(this).asBitmap().load(this.mCurrentMediaItem.getImageUrl()).into((RequestBuilder<Bitmap>) notificationTarget);
            startForeground(RUBIKA_MUSIC_PLAYER_NOTIFICATION_ID, this.mPlayerNotification);
        } catch (Exception unused) {
        }
    }

    public void playPrevious() {
        try {
            this.retryCount = 0;
            if (this.exoPlayer == null) {
                return;
            }
            if (this.mCurrentMediaItem != null) {
                int currentMediaItemPosition = getCurrentMediaItemPosition();
                if (currentMediaItemPosition == 0) {
                    playMedia(this.playList.get(r0.size() - 1));
                } else if (currentMediaItemPosition > 0) {
                    playMedia(this.playList.get(currentMediaItemPosition - 1));
                } else {
                    playMedia(this.mCurrentMediaItem);
                }
            }
        } catch (Exception unused) {
        }
    }

    public void playNext() {
        try {
            this.retryCount = 0;
            if (this.mCurrentMediaItem != null) {
                if (getCurrentMediaItemPosition() < this.playList.size() - 1) {
                    playMedia(this.playList.get(getCurrentMediaItemPosition() + 1));
                } else if (getCurrentMediaItemPosition() == this.playList.size() - 1 && this.playList.size() > 0) {
                    playMedia(this.playList.get(0));
                } else {
                    playMedia(this.mCurrentMediaItem);
                }
            }
        } catch (Exception unused) {
        }
    }

    public int getCurrentMediaItemPosition() {
        if (this.mCurrentMediaItem == null || this.playList.size() <= 0) {
            return -1;
        }
        for (int i = 0; i < this.playList.size(); i++) {
            if (this.playList.get(i).getId().equals(this.mCurrentMediaItem.getId())) {
                return i;
            }
        }
        return -1;
    }

    @Override // android.app.Service
    public void onDestroy() {
        instance = null;
        MyLog.e("NewMusicPlayerService", "onDestroy");
        if (Build.VERSION.SDK_INT >= 26) {
            MyLog.e("NewMusicPlayerService", "onDestroy 1");
            stopForeground(false);
            NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
            this.mNotificationManager = notificationManager;
            if (notificationManager != null) {
                MyLog.e("NewMusicPlayerService", "onDestroy 2");
                this.mNotificationManager.deleteNotificationChannel(RUBIKA_NOTIFICATION_CHANNEL_ID);
            }
        } else {
            MyLog.e("NewMusicPlayerService", "onDestroy 3");
            stopForeground(true);
        }
        this.mAudioManager.abandonAudioFocus(this.mOnAudioFocusChangeListener);
        this.mMediaPlayerHandler.removeCallbacksAndMessages(null);
        SimpleExoPlayer simpleExoPlayer = this.exoPlayer;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.release(false);
            this.exoPlayer = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }

    public void setList(ArrayList<PlayableAudioObject> arrayList) {
        this.playList.clear();
        this.playList.addAll(arrayList);
    }

    public boolean callViewStream() {
        String str;
        PlayableAudioObject playableAudioObject = this.mCurrentMediaItem;
        if (playableAudioObject == null || playableAudioObject.type != PlayableAudioObject.Type.aod || (str = playableAudioObject.aodViewId) == null || str.length() == 0 || !isPlaying()) {
            return false;
        }
        ViewStreamInput viewStreamInput = new ViewStreamInput();
        viewStreamInput.view_id = this.mCurrentMediaItem.aodViewId;
        viewStreamInput.view_point = (this.exoPlayer.getCurrentPosition() / 1000) + BuildConfig.FLAVOR;
        ApiRequestIPTV.getInstance(this.mCurrentMediaItem.currentAccount).viewStream(viewStreamInput, new ApiRequestIPTV.Listener(this) { // from class: ir.resaneh1.iptv.musicplayer.NewMusicPlayerService.8
            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onFailure(Call call, Throwable th) {
            }

            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onResponse(Call call, Response response) {
            }
        });
        return true;
    }

    public void startTimer(int i) {
        this.handler.postDelayed(this.runnable, i);
    }

    public void cancelTimer() {
        this.handler.removeCallbacks(this.runnable);
    }

    public void startTimerRetry() {
        cancelTimerRetry();
        notifyMediaStateChanged(PlayState.waitForRetry);
        int i = this.retryCount;
        if (i >= 5) {
            stopService();
        } else if (i < 2) {
            startTimerRetry(3000);
        } else if (i < 4) {
            startTimerRetry(8000);
        } else {
            startTimerRetry(20000);
        }
        this.retryCount++;
    }

    public void startTimerRetry(int i) {
        this.handler.postDelayed(this.retryRunnable, i);
    }

    public void cancelTimerRetry() {
        this.handler.removeCallbacks(this.retryRunnable);
    }
}
