package org.rbmain.messenger;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.media.MediaDescription;
import android.media.MediaMetadata;
import android.media.browse.MediaBrowser;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.service.media.MediaBrowserService;
import android.text.TextUtils;
import android.util.SparseArray;
import androidMessenger.utilites.PendingIntentUtils;
import com.facebook.stetho.websocket.CloseCodes;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.rbmain.SQLite.SQLiteCursor;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.audioinfo.AudioInfo;
import org.rbmain.tgnet.NativeByteBuffer;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$ChatPhoto;
import org.rbmain.tgnet.TLRPC$FileLocation;
import org.rbmain.tgnet.TLRPC$Message;
import org.rbmain.tgnet.TLRPC$TL_fileLocationUnavailable;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.tgnet.TLRPC$UserProfilePhoto;
import org.rbmain.ui.LaunchActivity;

/* loaded from: classes4.dex */
public class MusicBrowserService extends MediaBrowserService implements NotificationCenter.NotificationCenterDelegate {
    public static final String ACTION_CMD = "com.example.android.mediabrowserservice.ACTION_CMD";
    public static final String CMD_NAME = "CMD_NAME";
    public static final String CMD_PAUSE = "CMD_PAUSE";
    private static final String MEDIA_ID_ROOT = "__ROOT__";
    private static final String SLOT_RESERVATION_QUEUE = "com.google.android.gms.car.media.ALWAYS_RESERVE_SPACE_FOR.ACTION_QUEUE";
    private static final String SLOT_RESERVATION_SKIP_TO_NEXT = "com.google.android.gms.car.media.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_NEXT";
    private static final String SLOT_RESERVATION_SKIP_TO_PREV = "com.google.android.gms.car.media.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_PREVIOUS";
    private static final int STOP_DELAY = 30000;
    private RectF bitmapRect;
    private boolean chatsLoaded;
    private int lastSelectedDialog;
    private boolean loadingChats;
    private MediaSession mediaSession;
    private Paint roundPaint;
    private boolean serviceStarted;
    private int currentAccount = UserConfig.selectedAccount;
    private ArrayList<Integer> dialogs = new ArrayList<>();
    private SparseArray<TLRPC$User> users = new SparseArray<>();
    private SparseArray<TLRPC$Chat> chats = new SparseArray<>();
    private SparseArray<ArrayList<MessageObject>> musicObjects = new SparseArray<>();
    private SparseArray<ArrayList<MediaSession.QueueItem>> musicQueues = new SparseArray<>();
    private DelayedStopHandler delayedStopHandler = new DelayedStopHandler();

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return 1;
    }

    @Override // android.service.media.MediaBrowserService, android.app.Service
    public void onCreate() {
        super.onCreate();
        ApplicationLoader.postInitApplication();
        this.lastSelectedDialog = MessagesController.getNotificationsSettings(this.currentAccount).getInt("auto_lastSelectedDialog", 0);
        MediaSession mediaSession = new MediaSession(this, "MusicService");
        this.mediaSession = mediaSession;
        setSessionToken(mediaSession.getSessionToken());
        this.mediaSession.setCallback(new MediaSessionCallback());
        this.mediaSession.setFlags(3);
        Context applicationContext = getApplicationContext();
        this.mediaSession.setSessionActivity(PendingIntentUtils.getPendingIntentActivity(applicationContext, 99, new Intent(applicationContext, (Class<?>) LaunchActivity.class), 134217728));
        Bundle bundle = new Bundle();
        bundle.putBoolean(SLOT_RESERVATION_QUEUE, true);
        bundle.putBoolean(SLOT_RESERVATION_SKIP_TO_PREV, true);
        bundle.putBoolean(SLOT_RESERVATION_SKIP_TO_NEXT, true);
        this.mediaSession.setExtras(bundle);
        updatePlaybackState(null);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.messagePlayingPlayStateChanged);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.messagePlayingDidStart);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.messagePlayingDidReset);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        handleStopRequest(null);
        this.delayedStopHandler.removeCallbacksAndMessages(null);
        this.mediaSession.release();
    }

    @Override // android.service.media.MediaBrowserService
    public MediaBrowserService.BrowserRoot onGetRoot(String str, int i, Bundle bundle) {
        if (str == null || !(1000 == i || Process.myUid() == i || str.equals("com.google.android.mediasimulator") || str.equals("com.google.android.projection.gearhead"))) {
            return null;
        }
        return new MediaBrowserService.BrowserRoot(MEDIA_ID_ROOT, null);
    }

    @Override // android.service.media.MediaBrowserService
    public void onLoadChildren(final String str, final MediaBrowserService.Result<List<MediaBrowser.MediaItem>> result) throws NumberFormatException {
        if (!this.chatsLoaded) {
            result.detach();
            if (this.loadingChats) {
                return;
            }
            this.loadingChats = true;
            final MessagesStorage messagesStorage = MessagesStorage.getInstance(this.currentAccount);
            messagesStorage.getStorageQueue().postRunnable(new Runnable() { // from class: org.rbmain.messenger.MusicBrowserService$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onLoadChildren$1(messagesStorage, str, result);
                }
            });
            return;
        }
        loadChildrenImpl(str, result);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onLoadChildren$1(MessagesStorage messagesStorage, final String str, final MediaBrowserService.Result result) {
        try {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            SQLiteCursor sQLiteCursorQueryFinalized = messagesStorage.getDatabase().queryFinalized(String.format(Locale.US, "SELECT DISTINCT uid FROM media_v2 WHERE uid != 0 AND mid > 0 AND type = %d", 4), new Object[0]);
            while (sQLiteCursorQueryFinalized.next()) {
                int iLongValue = (int) sQLiteCursorQueryFinalized.longValue(0);
                if (iLongValue != 0) {
                    this.dialogs.add(Integer.valueOf(iLongValue));
                    if (iLongValue > 0) {
                        arrayList.add(Integer.valueOf(iLongValue));
                    } else {
                        arrayList2.add(Integer.valueOf(-iLongValue));
                    }
                }
            }
            sQLiteCursorQueryFinalized.dispose();
            if (!this.dialogs.isEmpty()) {
                SQLiteCursor sQLiteCursorQueryFinalized2 = messagesStorage.getDatabase().queryFinalized(String.format(Locale.US, "SELECT uid, data, mid FROM media_v2 WHERE uid IN (%s) AND mid > 0 AND type = %d ORDER BY date DESC, mid DESC", TextUtils.join(",", this.dialogs), 4), new Object[0]);
                while (sQLiteCursorQueryFinalized2.next()) {
                    NativeByteBuffer nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized2.byteBufferValue(1);
                    if (nativeByteBufferByteBufferValue != null) {
                        TLRPC$Message tLRPC$MessageTLdeserialize = TLRPC$Message.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                        tLRPC$MessageTLdeserialize.readAttachPath(nativeByteBufferByteBufferValue, UserConfig.getInstance(this.currentAccount).clientUserId);
                        nativeByteBufferByteBufferValue.reuse();
                        if (MessageObject.isMusicMessage(tLRPC$MessageTLdeserialize)) {
                            int iIntValue = sQLiteCursorQueryFinalized2.intValue(0);
                            tLRPC$MessageTLdeserialize.id = sQLiteCursorQueryFinalized2.intValue(2);
                            tLRPC$MessageTLdeserialize.dialog_id = iIntValue;
                            ArrayList<MessageObject> arrayList3 = this.musicObjects.get(iIntValue);
                            ArrayList<MediaSession.QueueItem> arrayList4 = this.musicQueues.get(iIntValue);
                            if (arrayList3 == null) {
                                arrayList3 = new ArrayList<>();
                                this.musicObjects.put(iIntValue, arrayList3);
                                arrayList4 = new ArrayList<>();
                                this.musicQueues.put(iIntValue, arrayList4);
                            }
                            MessageObject messageObject = new MessageObject(this.currentAccount, tLRPC$MessageTLdeserialize, false, true);
                            arrayList3.add(0, messageObject);
                            MediaDescription.Builder mediaId = new MediaDescription.Builder().setMediaId(iIntValue + "_" + arrayList3.size());
                            mediaId.setTitle(messageObject.getMusicTitle());
                            mediaId.setSubtitle(messageObject.getMusicAuthor());
                            arrayList4.add(0, new MediaSession.QueueItem(mediaId.build(), (long) arrayList4.size()));
                        }
                    }
                }
                sQLiteCursorQueryFinalized2.dispose();
                if (!arrayList.isEmpty()) {
                    ArrayList<TLRPC$User> arrayList5 = new ArrayList<>();
                    messagesStorage.getUsersInternal(TextUtils.join(",", arrayList), arrayList5);
                    for (int i = 0; i < arrayList5.size(); i++) {
                        TLRPC$User tLRPC$User = arrayList5.get(i);
                        this.users.put(tLRPC$User.id, tLRPC$User);
                    }
                }
                if (!arrayList2.isEmpty()) {
                    ArrayList<TLRPC$Chat> arrayList6 = new ArrayList<>();
                    messagesStorage.getChatsInternal(TextUtils.join(",", arrayList2), arrayList6);
                    for (int i2 = 0; i2 < arrayList6.size(); i2++) {
                        TLRPC$Chat tLRPC$Chat = arrayList6.get(i2);
                        this.chats.put(tLRPC$Chat.id, tLRPC$Chat);
                    }
                }
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MusicBrowserService$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() throws NumberFormatException {
                this.f$0.lambda$onLoadChildren$0(str, result);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onLoadChildren$0(String str, MediaBrowserService.Result result) throws NumberFormatException {
        this.chatsLoaded = true;
        this.loadingChats = false;
        loadChildrenImpl(str, result);
        if (this.lastSelectedDialog == 0 && !this.dialogs.isEmpty()) {
            this.lastSelectedDialog = this.dialogs.get(0).intValue();
        }
        int i = this.lastSelectedDialog;
        if (i != 0) {
            ArrayList<MessageObject> arrayList = this.musicObjects.get(i);
            ArrayList<MediaSession.QueueItem> arrayList2 = this.musicQueues.get(this.lastSelectedDialog);
            if (arrayList != null && !arrayList.isEmpty()) {
                this.mediaSession.setQueue(arrayList2);
                int i2 = this.lastSelectedDialog;
                if (i2 > 0) {
                    TLRPC$User tLRPC$User = this.users.get(i2);
                    if (tLRPC$User != null) {
                        this.mediaSession.setQueueTitle(ContactsController.formatName(tLRPC$User.first_name, tLRPC$User.last_name));
                    } else {
                        this.mediaSession.setQueueTitle("DELETED USER");
                    }
                } else {
                    TLRPC$Chat tLRPC$Chat = this.chats.get(-i2);
                    if (tLRPC$Chat != null) {
                        this.mediaSession.setQueueTitle(tLRPC$Chat.title);
                    } else {
                        this.mediaSession.setQueueTitle("DELETED CHAT");
                    }
                }
                MessageObject messageObject = arrayList.get(0);
                MediaMetadata.Builder builder = new MediaMetadata.Builder();
                builder.putLong("android.media.metadata.DURATION", messageObject.getDuration() * CloseCodes.NORMAL_CLOSURE);
                builder.putString("android.media.metadata.ARTIST", messageObject.getMusicAuthor());
                builder.putString("android.media.metadata.TITLE", messageObject.getMusicTitle());
                this.mediaSession.setMetadata(builder.build());
            }
        }
        updatePlaybackState(null);
    }

    private void loadChildrenImpl(String str, MediaBrowserService.Result<List<MediaBrowser.MediaItem>> result) throws NumberFormatException {
        int i;
        TLRPC$FileLocation tLRPC$FileLocation;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        if (MEDIA_ID_ROOT.equals(str)) {
            while (i2 < this.dialogs.size()) {
                int iIntValue = this.dialogs.get(i2).intValue();
                MediaDescription.Builder mediaId = new MediaDescription.Builder().setMediaId("__CHAT_" + iIntValue);
                Bitmap bitmapCreateRoundBitmap = null;
                if (iIntValue > 0) {
                    TLRPC$User tLRPC$User = this.users.get(iIntValue);
                    if (tLRPC$User != null) {
                        mediaId.setTitle(ContactsController.formatName(tLRPC$User.first_name, tLRPC$User.last_name));
                        TLRPC$UserProfilePhoto tLRPC$UserProfilePhoto = tLRPC$User.photo;
                        if (tLRPC$UserProfilePhoto != null) {
                            tLRPC$FileLocation = tLRPC$UserProfilePhoto.photo_small;
                            if (tLRPC$FileLocation instanceof TLRPC$TL_fileLocationUnavailable) {
                            }
                        }
                    } else {
                        mediaId.setTitle("DELETED USER");
                    }
                    tLRPC$FileLocation = null;
                } else {
                    TLRPC$Chat tLRPC$Chat = this.chats.get(-iIntValue);
                    if (tLRPC$Chat != null) {
                        mediaId.setTitle(tLRPC$Chat.title);
                        TLRPC$ChatPhoto tLRPC$ChatPhoto = tLRPC$Chat.photo;
                        if (tLRPC$ChatPhoto != null) {
                            tLRPC$FileLocation = tLRPC$ChatPhoto.photo_small;
                            if (tLRPC$FileLocation instanceof TLRPC$TL_fileLocationUnavailable) {
                            }
                        }
                    } else {
                        mediaId.setTitle("DELETED CHAT");
                    }
                    tLRPC$FileLocation = null;
                }
                if (tLRPC$FileLocation != null && (bitmapCreateRoundBitmap = createRoundBitmap(FileLoader.getPathToAttach(tLRPC$FileLocation, true))) != null) {
                    mediaId.setIconBitmap(bitmapCreateRoundBitmap);
                }
                if (tLRPC$FileLocation == null || bitmapCreateRoundBitmap == null) {
                    mediaId.setIconUri(Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/drawable/contact_blue"));
                }
                arrayList.add(new MediaBrowser.MediaItem(mediaId.build(), 1));
                i2++;
            }
        } else if (str != null && str.startsWith("__CHAT_")) {
            try {
                i = Integer.parseInt(str.replace("__CHAT_", io.github.inflationx.calligraphy3.BuildConfig.FLAVOR));
            } catch (Exception e) {
                FileLog.e(e);
                i = 0;
            }
            ArrayList<MessageObject> arrayList2 = this.musicObjects.get(i);
            if (arrayList2 != null) {
                while (i2 < arrayList2.size()) {
                    MessageObject messageObject = arrayList2.get(i2);
                    MediaDescription.Builder mediaId2 = new MediaDescription.Builder().setMediaId(i + "_" + i2);
                    mediaId2.setTitle(messageObject.getMusicTitle());
                    mediaId2.setSubtitle(messageObject.getMusicAuthor());
                    arrayList.add(new MediaBrowser.MediaItem(mediaId2.build(), 2));
                    i2++;
                }
            }
        }
        result.sendResult(arrayList);
    }

    private Bitmap createRoundBitmap(File file) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 2;
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(file.toString(), options);
            if (bitmapDecodeFile == null) {
                return null;
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeFile.getWidth(), bitmapDecodeFile.getHeight(), Bitmap.Config.ARGB_8888);
            bitmapCreateBitmap.eraseColor(0);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            BitmapShader bitmapShader = new BitmapShader(bitmapDecodeFile, tileMode, tileMode);
            if (this.roundPaint == null) {
                this.roundPaint = new Paint(1);
                this.bitmapRect = new RectF();
            }
            this.roundPaint.setShader(bitmapShader);
            this.bitmapRect.set(0.0f, 0.0f, bitmapDecodeFile.getWidth(), bitmapDecodeFile.getHeight());
            canvas.drawRoundRect(this.bitmapRect, bitmapDecodeFile.getWidth(), bitmapDecodeFile.getHeight(), this.roundPaint);
            return bitmapCreateBitmap;
        } catch (Throwable th) {
            FileLog.e(th);
            return null;
        }
    }

    private final class MediaSessionCallback extends MediaSession.Callback {
        private MediaSessionCallback() {
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPlay() throws NumberFormatException {
            MessageObject playingMessageObject = MediaController.getInstance().getPlayingMessageObject();
            if (playingMessageObject == null) {
                onPlayFromMediaId(MusicBrowserService.this.lastSelectedDialog + "_0", null);
                return;
            }
            MediaController.getInstance().playMessage(playingMessageObject);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSkipToQueueItem(long j) {
            MediaController.getInstance().playMessageAtIndex((int) j);
            MusicBrowserService.this.handlePlayRequest();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSeekTo(long j) {
            MessageObject playingMessageObject = MediaController.getInstance().getPlayingMessageObject();
            if (playingMessageObject != null) {
                MediaController.getInstance().seekToProgress(playingMessageObject, (j / 1000) / playingMessageObject.getDuration());
            }
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPlayFromMediaId(String str, Bundle bundle) throws NumberFormatException {
            int i;
            int i2;
            ArrayList<MessageObject> arrayList;
            ArrayList arrayList2;
            String[] strArrSplit = str.split("_");
            if (strArrSplit.length != 2) {
                return;
            }
            try {
                i = Integer.parseInt(strArrSplit[0]);
                i2 = Integer.parseInt(strArrSplit[1]);
                arrayList = (ArrayList) MusicBrowserService.this.musicObjects.get(i);
                arrayList2 = (ArrayList) MusicBrowserService.this.musicQueues.get(i);
            } catch (Exception e) {
                FileLog.e(e);
            }
            if (arrayList != null && i2 >= 0 && i2 < arrayList.size()) {
                MusicBrowserService.this.lastSelectedDialog = i;
                MessagesController.getNotificationsSettings(MusicBrowserService.this.currentAccount).edit().putInt("auto_lastSelectedDialog", i).apply();
                MediaController.getInstance().setPlaylist(arrayList, arrayList.get(i2), 0L, false, null);
                MusicBrowserService.this.mediaSession.setQueue(arrayList2);
                if (i > 0) {
                    TLRPC$User tLRPC$User = (TLRPC$User) MusicBrowserService.this.users.get(i);
                    if (tLRPC$User != null) {
                        MusicBrowserService.this.mediaSession.setQueueTitle(ContactsController.formatName(tLRPC$User.first_name, tLRPC$User.last_name));
                    } else {
                        MusicBrowserService.this.mediaSession.setQueueTitle("DELETED USER");
                    }
                } else {
                    TLRPC$Chat tLRPC$Chat = (TLRPC$Chat) MusicBrowserService.this.chats.get(-i);
                    if (tLRPC$Chat != null) {
                        MusicBrowserService.this.mediaSession.setQueueTitle(tLRPC$Chat.title);
                    } else {
                        MusicBrowserService.this.mediaSession.setQueueTitle("DELETED CHAT");
                    }
                }
                MusicBrowserService.this.handlePlayRequest();
            }
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPause() {
            MusicBrowserService.this.handlePauseRequest();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onStop() {
            MusicBrowserService.this.handleStopRequest(null);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSkipToNext() {
            MediaController.getInstance().playNextMessage();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSkipToPrevious() {
            MediaController.getInstance().playPreviousMessage();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPlayFromSearch(String str, Bundle bundle) throws NumberFormatException {
            String str2;
            String str3;
            String str4;
            if (str == null || str.length() == 0) {
                return;
            }
            String lowerCase = str.toLowerCase();
            for (int i = 0; i < MusicBrowserService.this.dialogs.size(); i++) {
                int iIntValue = ((Integer) MusicBrowserService.this.dialogs.get(i)).intValue();
                if (iIntValue > 0) {
                    TLRPC$User tLRPC$User = (TLRPC$User) MusicBrowserService.this.users.get(iIntValue);
                    if (tLRPC$User != null && (((str3 = tLRPC$User.first_name) != null && str3.startsWith(lowerCase)) || ((str4 = tLRPC$User.last_name) != null && str4.startsWith(lowerCase)))) {
                        onPlayFromMediaId(iIntValue + "_0", null);
                        return;
                    }
                } else {
                    TLRPC$Chat tLRPC$Chat = (TLRPC$Chat) MusicBrowserService.this.chats.get(-iIntValue);
                    if (tLRPC$Chat != null && (str2 = tLRPC$Chat.title) != null && str2.toLowerCase().contains(lowerCase)) {
                        onPlayFromMediaId(iIntValue + "_0", null);
                        return;
                    }
                }
            }
        }
    }

    private void updatePlaybackState(String str) {
        int i;
        int i2;
        MessageObject playingMessageObject = MediaController.getInstance().getPlayingMessageObject();
        long j = playingMessageObject != null ? playingMessageObject.audioProgressSec * 1000 : -1L;
        PlaybackState.Builder actions = new PlaybackState.Builder().setActions(getAvailableActions());
        if (playingMessageObject == null) {
            i = 1;
        } else if (MediaController.getInstance().isDownloadingCurrentMessage()) {
            i = 6;
        } else {
            i = MediaController.getInstance().isMessagePaused() ? 2 : 3;
        }
        if (str != null) {
            actions.setErrorMessage(str);
            i2 = 7;
        } else {
            i2 = i;
        }
        actions.setState(i2, j, 1.0f, SystemClock.elapsedRealtime());
        if (playingMessageObject != null) {
            actions.setActiveQueueItemId(MediaController.getInstance().getPlayingMessageObjectNum());
        } else {
            actions.setActiveQueueItemId(0L);
        }
        this.mediaSession.setPlaybackState(actions.build());
    }

    private long getAvailableActions() {
        if (MediaController.getInstance().getPlayingMessageObject() != null) {
            return (MediaController.getInstance().isMessagePaused() ? 3076L : 3078L) | 16 | 32;
        }
        return 3076L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStopRequest(String str) {
        this.delayedStopHandler.removeCallbacksAndMessages(null);
        this.delayedStopHandler.sendEmptyMessageDelayed(0, 30000L);
        updatePlaybackState(str);
        stopSelf();
        this.serviceStarted = false;
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.messagePlayingPlayStateChanged);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.messagePlayingDidStart);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.messagePlayingDidReset);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlePlayRequest() {
        Bitmap cover;
        this.delayedStopHandler.removeCallbacksAndMessages(null);
        if (!this.serviceStarted) {
            try {
                startService(new Intent(getApplicationContext(), (Class<?>) MusicBrowserService.class));
            } catch (Throwable th) {
                FileLog.e(th);
            }
            this.serviceStarted = true;
        }
        if (!this.mediaSession.isActive()) {
            this.mediaSession.setActive(true);
        }
        MessageObject playingMessageObject = MediaController.getInstance().getPlayingMessageObject();
        if (playingMessageObject == null) {
            return;
        }
        MediaMetadata.Builder builder = new MediaMetadata.Builder();
        builder.putLong("android.media.metadata.DURATION", playingMessageObject.getDuration() * CloseCodes.NORMAL_CLOSURE);
        builder.putString("android.media.metadata.ARTIST", playingMessageObject.getMusicAuthor());
        builder.putString("android.media.metadata.TITLE", playingMessageObject.getMusicTitle());
        AudioInfo audioInfo = MediaController.getInstance().getAudioInfo();
        if (audioInfo != null && (cover = audioInfo.getCover()) != null) {
            builder.putBitmap("android.media.metadata.ALBUM_ART", cover);
        }
        this.mediaSession.setMetadata(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlePauseRequest() {
        MediaController.getInstance().lambda$startAudioAgain$7(MediaController.getInstance().getPlayingMessageObject());
        this.delayedStopHandler.removeCallbacksAndMessages(null);
        this.delayedStopHandler.sendEmptyMessageDelayed(0, 30000L);
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        updatePlaybackState(null);
        handlePlayRequest();
    }

    private static class DelayedStopHandler extends Handler {
        private final WeakReference<MusicBrowserService> mWeakReference;

        private DelayedStopHandler(MusicBrowserService musicBrowserService) {
            this.mWeakReference = new WeakReference<>(musicBrowserService);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            MusicBrowserService musicBrowserService = this.mWeakReference.get();
            if (musicBrowserService != null) {
                if (MediaController.getInstance().getPlayingMessageObject() == null || MediaController.getInstance().isMessagePaused()) {
                    musicBrowserService.stopSelf();
                    musicBrowserService.serviceStarted = false;
                }
            }
        }
    }
}
