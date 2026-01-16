package ir.resaneh1.iptv.musicplayer;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.text.format.DateUtils;
import com.facebook.stetho.websocket.CloseCodes;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.ChildLockCheck;
import ir.resaneh1.iptv.musicplayer.NewMusicPlayerService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.rbmain.messenger.ApplicationLoader;

/* loaded from: classes3.dex */
public class AudioPlayManager {
    private static volatile AudioPlayManager Instance;
    private boolean mOnBindServiceHasBeenCalled;
    private NewMusicPlayerService mPlaybackService;
    private ScheduledFuture<?> mScheduleFuture;
    private boolean mServiceCallbackRegistered;
    private ArrayList<PlayableAudioObject> playListAfterBind;
    private PlayableAudioObject playableAudioObjectAfterBind;
    private ArrayList<Listener> listeners = new ArrayList<>();
    private final Handler mHandler = new Handler();
    private final ScheduledExecutorService mExecutorService = Executors.newSingleThreadScheduledExecutor();
    private ServiceConnection mPlaybackServiceConnection = new ServiceConnection() { // from class: ir.resaneh1.iptv.musicplayer.AudioPlayManager.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MyLog.e("MusicPlayerService", "service Connected");
            AudioPlayManager.this.mPlaybackService = ((NewMusicPlayerService.LocalBinder) iBinder).getService();
            AudioPlayManager.this.mPlaybackService.registerServiceCallback(AudioPlayManager.this.serviceCallback);
            AudioPlayManager.this.mServiceCallbackRegistered = true;
            MyLog.e("MusicPlayerService", "mPlaybackServiceConnection connected!");
            if (AudioPlayManager.this.playableAudioObjectAfterBind != null) {
                AudioPlayManager audioPlayManager = AudioPlayManager.this;
                audioPlayManager.play(audioPlayManager.playableAudioObjectAfterBind);
                AudioPlayManager.this.playableAudioObjectAfterBind = null;
            }
            if (AudioPlayManager.this.playListAfterBind != null) {
                AudioPlayManager audioPlayManager2 = AudioPlayManager.this;
                audioPlayManager2.setPlayList(audioPlayManager2.playListAfterBind);
                AudioPlayManager.this.playListAfterBind = null;
            }
            AudioPlayManager.this.callListenersUpdateViews();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            MyLog.e("MusicPlayerService", "mPlaybackServiceConnection disconnected!");
            AudioPlayManager.this.mOnBindServiceHasBeenCalled = false;
            AudioPlayManager.this.mPlaybackService = null;
            AudioPlayManager.this.serviceCallback.onMediaStateChangedByPlaybackService(null, PlayState.serviceDestroyed);
        }
    };
    NewMusicPlayerService.ServiceCallback serviceCallback = new NewMusicPlayerService.ServiceCallback() { // from class: ir.resaneh1.iptv.musicplayer.AudioPlayManager.2
        @Override // ir.resaneh1.iptv.musicplayer.NewMusicPlayerService.ServiceCallback
        public void onMediaStateChangedByPlaybackService(PlayableAudioObject playableAudioObject, PlayState playState) {
            AudioPlayManager.this.callListenersUpdateViews();
            if (playState == PlayState.mediaPlaying) {
                AudioPlayManager.this.scheduleSeekbarUpdate();
            } else {
                AudioPlayManager.this.stopSeekbarUpdate();
            }
        }
    };
    private final Runnable mUpdateProgressTask = new Runnable() { // from class: ir.resaneh1.iptv.musicplayer.AudioPlayManager.3
        @Override // java.lang.Runnable
        public void run() {
            AudioPlayManager.this.updateProgress();
        }
    };

    public interface Listener {
        void updateJustProgressText(String str);

        void updateProgress();

        void updateView();
    }

    public static AudioPlayManager getInstance() {
        AudioPlayManager audioPlayManager = Instance;
        if (audioPlayManager == null) {
            synchronized (AudioPlayManager.class) {
                audioPlayManager = Instance;
                if (audioPlayManager == null) {
                    audioPlayManager = new AudioPlayManager();
                    Instance = audioPlayManager;
                }
            }
        }
        return audioPlayManager;
    }

    public void removeListener(Listener listener) {
        this.listeners.remove(listener);
    }

    public void setPlayList(ArrayList<PlayableAudioObject> arrayList) {
        NewMusicPlayerService newMusicPlayerService = this.mPlaybackService;
        if (newMusicPlayerService != null) {
            newMusicPlayerService.setList(arrayList);
        } else {
            this.playListAfterBind = arrayList;
            startAndBindToServiceIfNeeded();
        }
    }

    public void playNext() {
        NewMusicPlayerService newMusicPlayerService = this.mPlaybackService;
        if (newMusicPlayerService != null) {
            newMusicPlayerService.playNext();
        } else {
            startAndBindToServiceIfNeeded();
        }
    }

    public void playPrevious() {
        NewMusicPlayerService newMusicPlayerService = this.mPlaybackService;
        if (newMusicPlayerService != null) {
            newMusicPlayerService.playPrevious();
        } else {
            startAndBindToServiceIfNeeded();
        }
    }

    public ArrayList<PlayableAudioObject> getPlaylist() {
        NewMusicPlayerService newMusicPlayerService = this.mPlaybackService;
        if (newMusicPlayerService != null) {
            return newMusicPlayerService.playList;
        }
        return null;
    }

    public void tenSecondForward() {
        NewMusicPlayerService newMusicPlayerService = this.mPlaybackService;
        if (newMusicPlayerService != null) {
            newMusicPlayerService.tenSecondForward();
        }
    }

    public void tenSecondBackward() {
        NewMusicPlayerService newMusicPlayerService = this.mPlaybackService;
        if (newMusicPlayerService != null) {
            newMusicPlayerService.tenSecondBackward();
        }
    }

    public void startAndBindToServiceIfNeeded() {
        if (this.mOnBindServiceHasBeenCalled || this.mPlaybackService != null) {
            return;
        }
        MyLog.e("AudioPlayer", "startAndBind");
        Intent intent = new Intent(ApplicationLoader.applicationContext, (Class<?>) NewMusicPlayerService.class);
        ApplicationLoader.applicationContext.startService(intent);
        ApplicationLoader.applicationContext.bindService(intent, this.mPlaybackServiceConnection, 0);
        this.mOnBindServiceHasBeenCalled = true;
    }

    public void addListener(Listener listener) {
        this.listeners.add(listener);
        listener.updateView();
    }

    public void play(PlayableAudioObject playableAudioObject) {
        if (ChildLockCheck.canPlayAudioWithAlert()) {
            startAndBindToServiceIfNeeded();
            NewMusicPlayerService newMusicPlayerService = this.mPlaybackService;
            if (newMusicPlayerService != null) {
                if (newMusicPlayerService.getCurrentMediaItem() == null) {
                    this.mPlaybackService.playMedia(playableAudioObject);
                    return;
                } else if (!this.mPlaybackService.mCurrentMediaItem.getId().equals(playableAudioObject.getId())) {
                    this.mPlaybackService.playMedia(playableAudioObject);
                    return;
                } else {
                    this.mPlaybackService.play();
                    return;
                }
            }
            this.playableAudioObjectAfterBind = playableAudioObject;
        }
    }

    void callListenersUpdateViews() {
        Iterator<Listener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().updateView();
        }
    }

    void callListenersUpdateProgress() {
        Iterator<Listener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().updateProgress();
        }
    }

    void callListenersUpdateJustProgressText(String str) {
        Iterator<Listener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().updateJustProgressText(str);
        }
    }

    public void pause(PlayableAudioObject playableAudioObject) {
        startAndBindToServiceIfNeeded();
        NewMusicPlayerService newMusicPlayerService = this.mPlaybackService;
        if (newMusicPlayerService != null) {
            newMusicPlayerService.pause();
        }
    }

    public PlayableAudioObject getCurrentPlayingObject() {
        NewMusicPlayerService newMusicPlayerService = this.mPlaybackService;
        if (newMusicPlayerService != null) {
            return newMusicPlayerService.getCurrentMediaItem();
        }
        if (NewMusicPlayerService.instance == null) {
            return null;
        }
        startAndBindToServiceIfNeeded();
        return NewMusicPlayerService.instance.getCurrentMediaItem();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateProgress() {
        if (this.mPlaybackService != null) {
            try {
                callListenersUpdateProgress();
            } catch (Exception unused) {
                stopSeekbarUpdate();
            }
        }
    }

    public String getCurrentPositionText(PlayableAudioObject playableAudioObject) {
        PlayableAudioObject playableAudioObject2;
        NewMusicPlayerService newMusicPlayerService = this.mPlaybackService;
        return (newMusicPlayerService == null || (playableAudioObject2 = newMusicPlayerService.mCurrentMediaItem) == null || newMusicPlayerService.exoPlayer == null || !playableAudioObject2.getId().equals(playableAudioObject.getId())) ? "۰۰:۰۰" : NumberUtils.toPersian(DateUtils.formatElapsedTime(this.mPlaybackService.exoPlayer.getCurrentPosition() / 1000));
    }

    public String getDurationText(PlayableAudioObject playableAudioObject) {
        PlayableAudioObject playableAudioObject2;
        NewMusicPlayerService newMusicPlayerService = this.mPlaybackService;
        if (newMusicPlayerService == null || (playableAudioObject2 = newMusicPlayerService.mCurrentMediaItem) == null || newMusicPlayerService.exoPlayer == null || !playableAudioObject2.getId().equals(playableAudioObject.getId())) {
            return "۰۰:۰۰";
        }
        return this.mPlaybackService.mCurrentMediaItem.streamUrl != null ? NumberUtils.toPersian(DateUtils.formatElapsedTime(r5.getDuration() / 1000)) : "۰۰:۰۰";
    }

    public int getDuration(PlayableAudioObject playableAudioObject) {
        PlayableAudioObject playableAudioObject2;
        NewMusicPlayerService newMusicPlayerService = this.mPlaybackService;
        if (newMusicPlayerService == null || (playableAudioObject2 = newMusicPlayerService.mCurrentMediaItem) == null || newMusicPlayerService.exoPlayer == null || !playableAudioObject2.getId().equals(playableAudioObject.getId())) {
            return 0;
        }
        if (this.mPlaybackService.mCurrentMediaItem.streamUrl != null) {
            return r3.getDuration();
        }
        return 0;
    }

    public int getCurrentPosition(PlayableAudioObject playableAudioObject) {
        PlayableAudioObject playableAudioObject2;
        NewMusicPlayerService newMusicPlayerService = this.mPlaybackService;
        if (newMusicPlayerService == null || (playableAudioObject2 = newMusicPlayerService.mCurrentMediaItem) == null || newMusicPlayerService.exoPlayer == null || !playableAudioObject2.getId().equals(playableAudioObject.getId())) {
            return 0;
        }
        if (this.mPlaybackService.mCurrentMediaItem.streamUrl != null) {
            return r3.getCurrentPosition();
        }
        return 0;
    }

    public void stopSeekbarUpdate() {
        ScheduledFuture<?> scheduledFuture = this.mScheduleFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scheduleSeekbarUpdate() {
        stopSeekbarUpdate();
        MyLog.e("updateProgress", "schedulesekkbar ..");
        if (this.mExecutorService.isShutdown()) {
            return;
        }
        MyLog.e("updateProgress", " in if schedulesekkbar ..");
        this.mScheduleFuture = this.mExecutorService.scheduleAtFixedRate(new Runnable() { // from class: ir.resaneh1.iptv.musicplayer.AudioPlayManager.4
            @Override // java.lang.Runnable
            public void run() {
                MyLog.e("updateProgress", "in run schedulesekkbar ..");
                AudioPlayManager.this.mHandler.post(AudioPlayManager.this.mUpdateProgressTask);
            }
        }, 100L, 300L, TimeUnit.MILLISECONDS);
    }

    public boolean isVisiblePlayButton(PlayableAudioObject playableAudioObject) {
        PlayableAudioObject playableAudioObject2;
        NewMusicPlayerService newMusicPlayerService = this.mPlaybackService;
        return newMusicPlayerService == null || (playableAudioObject2 = newMusicPlayerService.mCurrentMediaItem) == null || !playableAudioObject2.getId().equals(playableAudioObject.getId()) || !this.mPlaybackService.isPlayButtonInvisible();
    }

    public boolean isVisiblePauseButton(PlayableAudioObject playableAudioObject) {
        return !isVisiblePlayButton(playableAudioObject);
    }

    public boolean iscurrentlyPlay(PlayableAudioObject playableAudioObject) {
        PlayableAudioObject playableAudioObject2;
        NewMusicPlayerService newMusicPlayerService = this.mPlaybackService;
        return (newMusicPlayerService == null || (playableAudioObject2 = newMusicPlayerService.mCurrentMediaItem) == null || !playableAudioObject2.getId().equals(playableAudioObject.getId())) ? false : true;
    }

    public boolean isVisibleProgressView(PlayableAudioObject playableAudioObject) {
        return iscurrentlyPlay(playableAudioObject) && this.mPlaybackService.isLoading();
    }

    public void seekByUser(PlayableAudioObject playableAudioObject, int i) {
        if (iscurrentlyPlay(playableAudioObject)) {
            callListenersUpdateJustProgressText(NumberUtils.toPersian(DateUtils.formatElapsedTime(i / CloseCodes.NORMAL_CLOSURE)));
        }
    }

    public void stopSeekbarTouchUser(PlayableAudioObject playableAudioObject, int i) {
        if (iscurrentlyPlay(playableAudioObject)) {
            this.mPlaybackService.seekTo(i);
            scheduleSeekbarUpdate();
        }
    }

    public void startSeekBarTouch(PlayableAudioObject playableAudioObject) {
        if (iscurrentlyPlay(playableAudioObject)) {
            stopSeekbarUpdate();
        }
    }
}
