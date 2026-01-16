package ir.eitaa.messenger;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaMetadata;
import android.media.RemoteControlClient;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import ir.eitaa.messenger.ImageReceiver;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.audioinfo.AudioInfo;
import ir.eitaa.ui.LaunchActivity;
import java.io.File;
import java.io.IOException;
import org.webrtc.MediaStreamTrack;

/* loaded from: classes.dex */
public class MusicPlayerService extends Service implements NotificationCenter.NotificationCenterDelegate {
    private static final int ID_NOTIFICATION = 5;
    public static final String NOTIFY_CLOSE = "ir.eitaa.android.musicplayer.close";
    public static final String NOTIFY_NEXT = "ir.eitaa.android.musicplayer.next";
    public static final String NOTIFY_PAUSE = "ir.eitaa.android.musicplayer.pause";
    public static final String NOTIFY_PLAY = "ir.eitaa.android.musicplayer.play";
    public static final String NOTIFY_PREVIOUS = "ir.eitaa.android.musicplayer.previous";
    public static final String NOTIFY_SEEK = "ir.eitaa.android.musicplayer.seek";
    private static boolean supportBigNotifications;
    private static boolean supportLockScreenControls;
    private Bitmap albumArtPlaceholder;
    private AudioManager audioManager;
    private BroadcastReceiver headsetPlugReceiver = new BroadcastReceiver() { // from class: ir.eitaa.messenger.MusicPlayerService.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
                MediaController.getInstance().lambda$startAudioAgain$7$MediaController(MediaController.getInstance().getPlayingMessageObject());
            }
        }
    };
    private ImageReceiver imageReceiver;
    private String loadingFilePath;
    private MediaSession mediaSession;
    private int notificationMessageID;
    private PlaybackState.Builder playbackState;
    private RemoteControlClient remoteControlClient;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    static {
        int i = Build.VERSION.SDK_INT;
        boolean z = true;
        supportBigNotifications = i >= 16;
        if (i >= 21 && TextUtils.isEmpty(AndroidUtilities.getSystemProperty("ro.miui.ui.version.code"))) {
            z = false;
        }
        supportLockScreenControls = z;
    }

    @Override // android.app.Service
    public void onCreate() throws Resources.NotFoundException {
        this.audioManager = (AudioManager) getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        for (int i = 0; i < 3; i++) {
            NotificationCenter.getInstance(i).addObserver(this, NotificationCenter.messagePlayingDidSeek);
            NotificationCenter.getInstance(i).addObserver(this, NotificationCenter.messagePlayingPlayStateChanged);
            NotificationCenter.getInstance(i).addObserver(this, NotificationCenter.httpFileDidLoad);
            NotificationCenter.getInstance(i).addObserver(this, NotificationCenter.fileLoaded);
        }
        ImageReceiver imageReceiver = new ImageReceiver(null);
        this.imageReceiver = imageReceiver;
        imageReceiver.setDelegate(new ImageReceiver.ImageReceiverDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$MusicPlayerService$UAQQZyC9hooMdD--VwIMg3NOPVs
            @Override // ir.eitaa.messenger.ImageReceiver.ImageReceiverDelegate
            public final void didSetImage(ImageReceiver imageReceiver2, boolean z, boolean z2, boolean z3) throws IllegalArgumentException {
                this.f$0.lambda$onCreate$0$MusicPlayerService(imageReceiver2, z, z2, z3);
            }

            @Override // ir.eitaa.messenger.ImageReceiver.ImageReceiverDelegate
            public /* synthetic */ void onAnimationReady(ImageReceiver imageReceiver2) {
                ImageReceiver.ImageReceiverDelegate.CC.$default$onAnimationReady(this, imageReceiver2);
            }
        });
        if (Build.VERSION.SDK_INT >= 21) {
            this.mediaSession = new MediaSession(this, "eitaaAudioPlayer");
            this.playbackState = new PlaybackState.Builder();
            this.albumArtPlaceholder = Bitmap.createBitmap(AndroidUtilities.dp(102.0f), AndroidUtilities.dp(102.0f), Bitmap.Config.ARGB_8888);
            Drawable drawable = getResources().getDrawable(R.drawable.nocover_big);
            drawable.setBounds(0, 0, this.albumArtPlaceholder.getWidth(), this.albumArtPlaceholder.getHeight());
            drawable.draw(new Canvas(this.albumArtPlaceholder));
            this.mediaSession.setCallback(new MediaSession.Callback() { // from class: ir.eitaa.messenger.MusicPlayerService.2
                @Override // android.media.session.MediaSession.Callback
                public void onStop() {
                }

                @Override // android.media.session.MediaSession.Callback
                public void onPlay() throws IOException {
                    MediaController.getInstance().playMessage(MediaController.getInstance().getPlayingMessageObject());
                }

                @Override // android.media.session.MediaSession.Callback
                public void onPause() {
                    MediaController.getInstance().lambda$startAudioAgain$7$MediaController(MediaController.getInstance().getPlayingMessageObject());
                }

                @Override // android.media.session.MediaSession.Callback
                public void onSkipToNext() throws InterruptedException, IOException {
                    MediaController.getInstance().playNextMessage();
                }

                @Override // android.media.session.MediaSession.Callback
                public void onSkipToPrevious() throws IOException {
                    MediaController.getInstance().playPreviousMessage();
                }

                @Override // android.media.session.MediaSession.Callback
                public void onSeekTo(long pos) {
                    MessageObject playingMessageObject = MediaController.getInstance().getPlayingMessageObject();
                    if (playingMessageObject != null) {
                        MediaController.getInstance().seekToProgress(playingMessageObject, (pos / 1000) / playingMessageObject.getDuration());
                        MusicPlayerService.this.updatePlaybackState(pos);
                    }
                }
            });
            this.mediaSession.setActive(true);
        }
        registerReceiver(this.headsetPlugReceiver, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
        super.onCreate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onCreate$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onCreate$0$MusicPlayerService(ImageReceiver imageReceiver, boolean z, boolean z2, boolean z3) throws IllegalArgumentException {
        if (!z || TextUtils.isEmpty(this.loadingFilePath)) {
            return;
        }
        MessageObject playingMessageObject = MediaController.getInstance().getPlayingMessageObject();
        if (playingMessageObject != null) {
            createNotification(playingMessageObject, true);
        }
        this.loadingFilePath = null;
    }

    @Override // android.app.Service
    @SuppressLint({"NewApi"})
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null) {
            try {
                if ((getPackageName() + ".STOP_PLAYER").equals(intent.getAction())) {
                    MediaController.getInstance().cleanupPlayer(true, true);
                    return 2;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        MessageObject playingMessageObject = MediaController.getInstance().getPlayingMessageObject();
        if (playingMessageObject == null) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$wM1C1qnTi0-YG5NMFMvGi2IJ4cI
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.stopSelf();
                }
            });
            return 1;
        }
        if (supportLockScreenControls) {
            ComponentName componentName = new ComponentName(getApplicationContext(), MusicPlayerReceiver.class.getName());
            try {
                if (this.remoteControlClient == null) {
                    this.audioManager.registerMediaButtonEventReceiver(componentName);
                    Intent intent2 = new Intent("android.intent.action.MEDIA_BUTTON");
                    intent2.setComponent(componentName);
                    RemoteControlClient remoteControlClient = new RemoteControlClient(PendingIntent.getBroadcast(this, 0, intent2, 0));
                    this.remoteControlClient = remoteControlClient;
                    this.audioManager.registerRemoteControlClient(remoteControlClient);
                }
                this.remoteControlClient.setTransportControlFlags(189);
            } catch (Exception e2) {
                FileLog.e(e2);
            }
        }
        createNotification(playingMessageObject, false);
        return 1;
    }

    private Bitmap loadArtworkFromUrl(String artworkUrl, boolean big, boolean tryLoad) {
        ImageLoader.getHttpFileName(artworkUrl);
        File httpFilePath = ImageLoader.getHttpFilePath(artworkUrl, "jpg");
        if (httpFilePath.exists()) {
            return ImageLoader.loadBitmap(httpFilePath.getAbsolutePath(), null, big ? 600.0f : 100.0f, big ? 600.0f : 100.0f, false);
        }
        if (tryLoad) {
            this.loadingFilePath = httpFilePath.getAbsolutePath();
            if (!big) {
                this.imageReceiver.setImage(artworkUrl, "48_48", (Drawable) null, (String) null, 0);
            }
        } else {
            this.loadingFilePath = null;
        }
        return null;
    }

    @SuppressLint({"NewApi"})
    private void createNotification(MessageObject messageObject, boolean forBitmap) throws IllegalArgumentException {
        String str;
        float f;
        int i;
        String str2;
        String str3;
        int i2;
        String str4;
        String musicTitle = messageObject.getMusicTitle();
        String musicAuthor = messageObject.getMusicAuthor();
        AudioInfo audioInfo = MediaController.getInstance().getAudioInfo();
        Intent intent = new Intent(ApplicationLoader.applicationContext, (Class<?>) LaunchActivity.class);
        intent.setAction("com.tmessages.openplayer");
        intent.addCategory("android.intent.category.LAUNCHER");
        PendingIntent activity = PendingIntent.getActivity(ApplicationLoader.applicationContext, 0, intent, 0);
        String artworkUrl = messageObject.getArtworkUrl(true);
        String artworkUrl2 = messageObject.getArtworkUrl(false);
        long duration = messageObject.getDuration() * 1000;
        Bitmap smallCover = audioInfo != null ? audioInfo.getSmallCover() : null;
        Bitmap cover = audioInfo != null ? audioInfo.getCover() : null;
        this.loadingFilePath = null;
        this.imageReceiver.setImageBitmap((Drawable) null);
        if (smallCover == null && !TextUtils.isEmpty(artworkUrl)) {
            cover = loadArtworkFromUrl(artworkUrl2, true, !forBitmap);
            if (cover == null) {
                smallCover = loadArtworkFromUrl(artworkUrl, false, !forBitmap);
                cover = smallCover;
            } else {
                smallCover = loadArtworkFromUrl(artworkUrl2, false, !forBitmap);
            }
        } else {
            this.loadingFilePath = FileLoader.getPathToAttach(messageObject.getDocument()).getAbsolutePath();
        }
        int i3 = Build.VERSION.SDK_INT;
        Bitmap bitmap = smallCover;
        if (i3 >= 21) {
            boolean z = !MediaController.getInstance().isMessagePaused();
            PendingIntent broadcast = PendingIntent.getBroadcast(getApplicationContext(), 0, new Intent(NOTIFY_PREVIOUS).setComponent(new ComponentName(this, (Class<?>) MusicPlayerReceiver.class)), 268435456);
            PendingIntent service = PendingIntent.getService(getApplicationContext(), 0, new Intent(this, getClass()).setAction(getPackageName() + ".STOP_PLAYER"), 268435456);
            PendingIntent broadcast2 = PendingIntent.getBroadcast(getApplicationContext(), 0, new Intent(z ? NOTIFY_PAUSE : NOTIFY_PLAY).setComponent(new ComponentName(this, (Class<?>) MusicPlayerReceiver.class)), 268435456);
            PendingIntent broadcast3 = PendingIntent.getBroadcast(getApplicationContext(), 0, new Intent(NOTIFY_NEXT).setComponent(new ComponentName(this, (Class<?>) MusicPlayerReceiver.class)), 268435456);
            PendingIntent.getBroadcast(getApplicationContext(), 0, new Intent(NOTIFY_SEEK).setComponent(new ComponentName(this, (Class<?>) MusicPlayerReceiver.class)), 268435456);
            Notification.Builder builder = new Notification.Builder(this);
            builder.setSmallIcon(R.drawable.player).setOngoing(z).setContentTitle(musicTitle).setContentText(musicAuthor).setSubText(audioInfo != null ? audioInfo.getAlbum() : null).setContentIntent(activity).setDeleteIntent(service).setShowWhen(false).setCategory("transport").setPriority(2).setStyle(new Notification.MediaStyle().setMediaSession(this.mediaSession.getSessionToken()).setShowActionsInCompactView(0, 1, 2));
            if (i3 >= 26) {
                NotificationsController.checkOtherNotificationsChannel();
                builder.setChannelId(NotificationsController.OTHER_NOTIFICATIONS_CHANNEL);
            }
            if (bitmap != null) {
                builder.setLargeIcon(bitmap);
            } else {
                builder.setLargeIcon(this.albumArtPlaceholder);
            }
            String string = LocaleController.getString("Next", R.string.Next);
            String string2 = LocaleController.getString("AccDescrPrevious", R.string.AccDescrPrevious);
            if (MediaController.getInstance().isDownloadingCurrentMessage()) {
                f = 1.0f;
                this.playbackState.setState(6, 0L, 1.0f).setActions(0L);
                builder.addAction(new Notification.Action.Builder(R.drawable.ic_action_previous, string2, broadcast).build()).addAction(new Notification.Action.Builder(R.drawable.loading_animation2, LocaleController.getString("Loading", R.string.Loading), (PendingIntent) null).build()).addAction(new Notification.Action.Builder(R.drawable.ic_action_next, string, broadcast3).build());
                str2 = musicTitle;
                str3 = musicAuthor;
            } else {
                f = 1.0f;
                str2 = musicTitle;
                str3 = musicAuthor;
                this.playbackState.setState(z ? 3 : 2, MediaController.getInstance().getPlayingMessageObject().audioProgressSec * 1000, z ? 1.0f : 0.0f).setActions(822L);
                if (z) {
                    i2 = R.string.AccActionPause;
                    str4 = "AccActionPause";
                } else {
                    i2 = R.string.AccActionPlay;
                    str4 = "AccActionPlay";
                }
                builder.addAction(new Notification.Action.Builder(R.drawable.ic_action_previous, string2, broadcast).build()).addAction(new Notification.Action.Builder(z ? R.drawable.ic_action_pause : R.drawable.ic_action_play, LocaleController.getString(str4, i2), broadcast2).build()).addAction(new Notification.Action.Builder(R.drawable.ic_action_next, string, broadcast3).build());
            }
            this.mediaSession.setPlaybackState(this.playbackState.build());
            musicAuthor = str3;
            str = str2;
            this.mediaSession.setMetadata(new MediaMetadata.Builder().putBitmap("android.media.metadata.ALBUM_ART", cover).putString("android.media.metadata.ALBUM_ARTIST", musicAuthor).putString("android.media.metadata.ARTIST", musicAuthor).putLong("android.media.metadata.DURATION", duration).putString("android.media.metadata.TITLE", str).putString("android.media.metadata.ALBUM", audioInfo != null ? audioInfo.getAlbum() : null).build());
            builder.setVisibility(1);
            Notification notificationBuild = builder.build();
            if (z) {
                startForeground(5, notificationBuild);
            } else {
                stopForeground(false);
                ((NotificationManager) getSystemService("notification")).notify(5, notificationBuild);
            }
        } else {
            str = musicTitle;
            f = 1.0f;
            RemoteViews remoteViews = new RemoteViews(getApplicationContext().getPackageName(), R.layout.player_small_notification);
            RemoteViews remoteViews2 = supportBigNotifications ? new RemoteViews(getApplicationContext().getPackageName(), R.layout.player_big_notification) : null;
            Notification notificationBuild2 = new NotificationCompat.Builder(getApplicationContext()).setSmallIcon(R.drawable.player).setContentIntent(activity).setChannelId(NotificationsController.OTHER_NOTIFICATIONS_CHANNEL).setContentTitle(str).build();
            notificationBuild2.contentView = remoteViews;
            if (supportBigNotifications) {
                notificationBuild2.bigContentView = remoteViews2;
            }
            setListeners(remoteViews);
            if (supportBigNotifications) {
                setListeners(remoteViews2);
            }
            if (bitmap != null) {
                notificationBuild2.contentView.setImageViewBitmap(R.id.player_album_art, bitmap);
                if (supportBigNotifications) {
                    notificationBuild2.bigContentView.setImageViewBitmap(R.id.player_album_art, bitmap);
                }
            } else {
                notificationBuild2.contentView.setImageViewResource(R.id.player_album_art, R.drawable.nocover_small);
                if (supportBigNotifications) {
                    notificationBuild2.bigContentView.setImageViewResource(R.id.player_album_art, R.drawable.nocover_big);
                }
            }
            if (MediaController.getInstance().isDownloadingCurrentMessage()) {
                notificationBuild2.contentView.setViewVisibility(R.id.player_pause, 8);
                notificationBuild2.contentView.setViewVisibility(R.id.player_play, 8);
                notificationBuild2.contentView.setViewVisibility(R.id.player_next, 8);
                notificationBuild2.contentView.setViewVisibility(R.id.player_previous, 8);
                notificationBuild2.contentView.setViewVisibility(R.id.player_progress_bar, 0);
                if (supportBigNotifications) {
                    notificationBuild2.bigContentView.setViewVisibility(R.id.player_pause, 8);
                    notificationBuild2.bigContentView.setViewVisibility(R.id.player_play, 8);
                    notificationBuild2.bigContentView.setViewVisibility(R.id.player_next, 8);
                    notificationBuild2.bigContentView.setViewVisibility(R.id.player_previous, 8);
                    notificationBuild2.bigContentView.setViewVisibility(R.id.player_progress_bar, 0);
                }
            } else {
                notificationBuild2.contentView.setViewVisibility(R.id.player_progress_bar, 8);
                notificationBuild2.contentView.setViewVisibility(R.id.player_next, 0);
                notificationBuild2.contentView.setViewVisibility(R.id.player_previous, 0);
                if (supportBigNotifications) {
                    notificationBuild2.bigContentView.setViewVisibility(R.id.player_next, 0);
                    notificationBuild2.bigContentView.setViewVisibility(R.id.player_previous, 0);
                    i = 8;
                    notificationBuild2.bigContentView.setViewVisibility(R.id.player_progress_bar, 8);
                } else {
                    i = 8;
                }
                if (MediaController.getInstance().isMessagePaused()) {
                    notificationBuild2.contentView.setViewVisibility(R.id.player_pause, i);
                    notificationBuild2.contentView.setViewVisibility(R.id.player_play, 0);
                    if (supportBigNotifications) {
                        notificationBuild2.bigContentView.setViewVisibility(R.id.player_pause, i);
                        notificationBuild2.bigContentView.setViewVisibility(R.id.player_play, 0);
                    }
                } else {
                    notificationBuild2.contentView.setViewVisibility(R.id.player_pause, 0);
                    notificationBuild2.contentView.setViewVisibility(R.id.player_play, i);
                    if (supportBigNotifications) {
                        notificationBuild2.bigContentView.setViewVisibility(R.id.player_pause, 0);
                        notificationBuild2.bigContentView.setViewVisibility(R.id.player_play, i);
                    }
                }
            }
            notificationBuild2.contentView.setTextViewText(R.id.player_song_name, str);
            notificationBuild2.contentView.setTextViewText(R.id.player_author_name, musicAuthor);
            if (supportBigNotifications) {
                notificationBuild2.bigContentView.setTextViewText(R.id.player_song_name, str);
                notificationBuild2.bigContentView.setTextViewText(R.id.player_author_name, musicAuthor);
                notificationBuild2.bigContentView.setTextViewText(R.id.player_album_title, (audioInfo == null || TextUtils.isEmpty(audioInfo.getAlbum())) ? "" : audioInfo.getAlbum());
            }
            notificationBuild2.flags |= 2;
            startForeground(5, notificationBuild2);
        }
        if (this.remoteControlClient != null) {
            int id = MediaController.getInstance().getPlayingMessageObject().getId();
            if (this.notificationMessageID != id) {
                this.notificationMessageID = id;
                RemoteControlClient.MetadataEditor metadataEditorEditMetadata = this.remoteControlClient.editMetadata(true);
                metadataEditorEditMetadata.putString(2, musicAuthor);
                metadataEditorEditMetadata.putString(7, str);
                if (audioInfo != null && !TextUtils.isEmpty(audioInfo.getAlbum())) {
                    metadataEditorEditMetadata.putString(1, audioInfo.getAlbum());
                }
                metadataEditorEditMetadata.putLong(9, MediaController.getInstance().getPlayingMessageObject().audioPlayerDuration * 1000);
                if (cover != null) {
                    try {
                        metadataEditorEditMetadata.putBitmap(100, cover);
                    } catch (Throwable th) {
                        FileLog.e(th);
                    }
                }
                metadataEditorEditMetadata.apply();
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.MusicPlayerService.3
                    @Override // java.lang.Runnable
                    public void run() throws IllegalArgumentException {
                        if (MusicPlayerService.this.remoteControlClient == null || MediaController.getInstance().getPlayingMessageObject() == null) {
                            return;
                        }
                        if (MediaController.getInstance().getPlayingMessageObject().audioPlayerDuration != -9223372036854775807L) {
                            RemoteControlClient.MetadataEditor metadataEditorEditMetadata2 = MusicPlayerService.this.remoteControlClient.editMetadata(false);
                            metadataEditorEditMetadata2.putLong(9, MediaController.getInstance().getPlayingMessageObject().audioPlayerDuration * 1000);
                            metadataEditorEditMetadata2.apply();
                            if (Build.VERSION.SDK_INT < 18) {
                                MusicPlayerService.this.remoteControlClient.setPlaybackState(MediaController.getInstance().isMessagePaused() ? 2 : 3);
                                return;
                            } else {
                                MusicPlayerService.this.remoteControlClient.setPlaybackState(MediaController.getInstance().isMessagePaused() ? 2 : 3, Math.max(MediaController.getInstance().getPlayingMessageObject().audioProgressSec * 1000, 100L), MediaController.getInstance().isMessagePaused() ? 0.0f : 1.0f);
                                return;
                            }
                        }
                        AndroidUtilities.runOnUIThread(this, 500L);
                    }
                }, 1000L);
            }
            if (MediaController.getInstance().isDownloadingCurrentMessage()) {
                this.remoteControlClient.setPlaybackState(8);
                return;
            }
            RemoteControlClient.MetadataEditor metadataEditorEditMetadata2 = this.remoteControlClient.editMetadata(false);
            metadataEditorEditMetadata2.putLong(9, MediaController.getInstance().getPlayingMessageObject().audioPlayerDuration * 1000);
            metadataEditorEditMetadata2.apply();
            if (Build.VERSION.SDK_INT >= 18) {
                RemoteControlClient remoteControlClient = this.remoteControlClient;
                int i4 = MediaController.getInstance().isMessagePaused() ? 2 : 3;
                long jMax = Math.max(MediaController.getInstance().getPlayingMessageObject().audioProgressSec * 1000, 100L);
                if (MediaController.getInstance().isMessagePaused()) {
                    f = 0.0f;
                }
                remoteControlClient.setPlaybackState(i4, jMax, f);
                return;
            }
            this.remoteControlClient.setPlaybackState(MediaController.getInstance().isMessagePaused() ? 2 : 3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePlaybackState(long seekTo) {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        boolean z = !MediaController.getInstance().isMessagePaused();
        if (MediaController.getInstance().isDownloadingCurrentMessage()) {
            this.playbackState.setState(6, 0L, 1.0f).setActions(0L);
        } else {
            this.playbackState.setState(z ? 3 : 2, seekTo, z ? 1.0f : 0.0f).setActions(822L);
        }
        this.mediaSession.setPlaybackState(this.playbackState.build());
    }

    public void setListeners(RemoteViews view) {
        view.setOnClickPendingIntent(R.id.player_previous, PendingIntent.getBroadcast(getApplicationContext(), 0, new Intent(NOTIFY_PREVIOUS), 134217728));
        view.setOnClickPendingIntent(R.id.player_close, PendingIntent.getBroadcast(getApplicationContext(), 0, new Intent(NOTIFY_CLOSE), 134217728));
        view.setOnClickPendingIntent(R.id.player_pause, PendingIntent.getBroadcast(getApplicationContext(), 0, new Intent(NOTIFY_PAUSE), 134217728));
        view.setOnClickPendingIntent(R.id.player_next, PendingIntent.getBroadcast(getApplicationContext(), 0, new Intent(NOTIFY_NEXT), 134217728));
        view.setOnClickPendingIntent(R.id.player_play, PendingIntent.getBroadcast(getApplicationContext(), 0, new Intent(NOTIFY_PLAY), 134217728));
    }

    @Override // android.app.Service
    @SuppressLint({"NewApi"})
    public void onDestroy() {
        unregisterReceiver(this.headsetPlugReceiver);
        super.onDestroy();
        RemoteControlClient remoteControlClient = this.remoteControlClient;
        if (remoteControlClient != null) {
            RemoteControlClient.MetadataEditor metadataEditorEditMetadata = remoteControlClient.editMetadata(true);
            metadataEditorEditMetadata.clear();
            metadataEditorEditMetadata.apply();
            this.audioManager.unregisterRemoteControlClient(this.remoteControlClient);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.mediaSession.release();
        }
        for (int i = 0; i < 3; i++) {
            NotificationCenter.getInstance(i).removeObserver(this, NotificationCenter.messagePlayingDidSeek);
            NotificationCenter.getInstance(i).removeObserver(this, NotificationCenter.messagePlayingPlayStateChanged);
            NotificationCenter.getInstance(i).removeObserver(this, NotificationCenter.httpFileDidLoad);
            NotificationCenter.getInstance(i).removeObserver(this, NotificationCenter.fileLoaded);
        }
    }

    @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) throws IllegalArgumentException {
        String str;
        String str2;
        if (id == NotificationCenter.messagePlayingPlayStateChanged) {
            MessageObject playingMessageObject = MediaController.getInstance().getPlayingMessageObject();
            if (playingMessageObject != null) {
                createNotification(playingMessageObject, false);
                return;
            } else {
                stopSelf();
                return;
            }
        }
        if (id == NotificationCenter.messagePlayingDidSeek) {
            MessageObject playingMessageObject2 = MediaController.getInstance().getPlayingMessageObject();
            if (this.remoteControlClient == null || Build.VERSION.SDK_INT < 18) {
                return;
            }
            this.remoteControlClient.setPlaybackState(MediaController.getInstance().isMessagePaused() ? 2 : 3, Math.round(playingMessageObject2.audioPlayerDuration * ((Float) args[1]).floatValue()) * 1000, MediaController.getInstance().isMessagePaused() ? 0.0f : 1.0f);
            return;
        }
        if (id == NotificationCenter.httpFileDidLoad) {
            String str3 = (String) args[0];
            MessageObject playingMessageObject3 = MediaController.getInstance().getPlayingMessageObject();
            if (playingMessageObject3 == null || (str2 = this.loadingFilePath) == null || !str2.equals(str3)) {
                return;
            }
            createNotification(playingMessageObject3, false);
            return;
        }
        if (id == NotificationCenter.fileLoaded) {
            String str4 = (String) args[0];
            MessageObject playingMessageObject4 = MediaController.getInstance().getPlayingMessageObject();
            if (playingMessageObject4 == null || (str = this.loadingFilePath) == null || !str.equals(str4)) {
                return;
            }
            createNotification(playingMessageObject4, false);
        }
    }
}
