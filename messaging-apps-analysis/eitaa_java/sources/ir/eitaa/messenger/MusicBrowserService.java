package ir.eitaa.messenger;

import android.annotation.TargetApi;
import android.app.PendingIntent;
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
import androidx.collection.LongSparseArray;
import ir.eitaa.SQLite.SQLiteCursor;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.audioinfo.AudioInfo;
import ir.eitaa.tgnet.NativeByteBuffer;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$ChatPhoto;
import ir.eitaa.tgnet.TLRPC$FileLocation;
import ir.eitaa.tgnet.TLRPC$Message;
import ir.eitaa.tgnet.TLRPC$TL_fileLocationUnavailable;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.tgnet.TLRPC$UserProfilePhoto;
import ir.eitaa.ui.LaunchActivity;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@TargetApi(21)
/* loaded from: classes.dex */
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
    private long lastSelectedDialog;
    private boolean loadingChats;
    private MediaSession mediaSession;
    private Paint roundPaint;
    private boolean serviceStarted;
    private int currentAccount = UserConfig.selectedAccount;
    private ArrayList<Long> dialogs = new ArrayList<>();
    private LongSparseArray<TLRPC$User> users = new LongSparseArray<>();
    private LongSparseArray<TLRPC$Chat> chats = new LongSparseArray<>();
    private LongSparseArray<ArrayList<MessageObject>> musicObjects = new LongSparseArray<>();
    private LongSparseArray<ArrayList<MediaSession.QueueItem>> musicQueues = new LongSparseArray<>();
    private DelayedStopHandler delayedStopHandler = new DelayedStopHandler();

    @Override // android.app.Service
    public int onStartCommand(Intent startIntent, int flags, int startId) {
        return 1;
    }

    @Override // android.service.media.MediaBrowserService, android.app.Service
    public void onCreate() {
        super.onCreate();
        ApplicationLoader.postInitApplication();
        this.lastSelectedDialog = AndroidUtilities.getPrefIntOrLong(MessagesController.getNotificationsSettings(this.currentAccount), "auto_lastSelectedDialog", 0L);
        MediaSession mediaSession = new MediaSession(this, "MusicService");
        this.mediaSession = mediaSession;
        setSessionToken(mediaSession.getSessionToken());
        this.mediaSession.setCallback(new MediaSessionCallback());
        this.mediaSession.setFlags(3);
        Context applicationContext = getApplicationContext();
        this.mediaSession.setSessionActivity(PendingIntent.getActivity(applicationContext, 99, new Intent(applicationContext, (Class<?>) LaunchActivity.class), 134217728));
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
    public MediaBrowserService.BrowserRoot onGetRoot(String clientPackageName, int clientUid, Bundle rootHints) {
        if (clientPackageName == null || !(1000 == clientUid || Process.myUid() == clientUid || clientPackageName.equals("com.google.android.mediasimulator") || clientPackageName.equals("com.google.android.projection.gearhead"))) {
            return null;
        }
        return new MediaBrowserService.BrowserRoot(MEDIA_ID_ROOT, null);
    }

    @Override // android.service.media.MediaBrowserService
    public void onLoadChildren(final String parentMediaId, final MediaBrowserService.Result<List<MediaBrowser.MediaItem>> result) throws NumberFormatException {
        if (!this.chatsLoaded) {
            result.detach();
            if (this.loadingChats) {
                return;
            }
            this.loadingChats = true;
            final MessagesStorage messagesStorage = MessagesStorage.getInstance(this.currentAccount);
            messagesStorage.getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MusicBrowserService$C8i37o4taThfICoKmpp1L6leYeY
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onLoadChildren$1$MusicBrowserService(messagesStorage, parentMediaId, result);
                }
            });
            return;
        }
        loadChildrenImpl(parentMediaId, result);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onLoadChildren$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onLoadChildren$1$MusicBrowserService(MessagesStorage messagesStorage, final String str, final MediaBrowserService.Result result) {
        try {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            SQLiteCursor sQLiteCursorQueryFinalized = messagesStorage.getDatabase().queryFinalized(String.format(Locale.US, "SELECT DISTINCT uid FROM media_v3 WHERE uid != 0 AND mid > 0 AND type = %d", 4), new Object[0]);
            while (sQLiteCursorQueryFinalized.next()) {
                long jLongValue = sQLiteCursorQueryFinalized.longValue(0);
                if (!DialogObject.isEncryptedDialog(jLongValue)) {
                    this.dialogs.add(Long.valueOf(jLongValue));
                    if (DialogObject.isUserDialog(jLongValue)) {
                        arrayList.add(Long.valueOf(jLongValue));
                    } else {
                        arrayList2.add(Long.valueOf(-jLongValue));
                    }
                }
            }
            sQLiteCursorQueryFinalized.dispose();
            if (!this.dialogs.isEmpty()) {
                SQLiteCursor sQLiteCursorQueryFinalized2 = messagesStorage.getDatabase().queryFinalized(String.format(Locale.US, "SELECT uid, data, mid FROM media_v3 WHERE uid IN (%s) AND mid > 0 AND type = %d ORDER BY date DESC, mid DESC", TextUtils.join(",", this.dialogs), 4), new Object[0]);
                while (sQLiteCursorQueryFinalized2.next()) {
                    NativeByteBuffer nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized2.byteBufferValue(1);
                    if (nativeByteBufferByteBufferValue != null) {
                        TLRPC$Message tLRPC$MessageTLdeserialize = TLRPC$Message.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                        tLRPC$MessageTLdeserialize.readAttachPath(nativeByteBufferByteBufferValue, UserConfig.getInstance(this.currentAccount).clientUserId);
                        nativeByteBufferByteBufferValue.reuse();
                        if (MessageObject.isMusicMessage(tLRPC$MessageTLdeserialize)) {
                            long jLongValue2 = sQLiteCursorQueryFinalized2.longValue(0);
                            tLRPC$MessageTLdeserialize.id = sQLiteCursorQueryFinalized2.intValue(2);
                            tLRPC$MessageTLdeserialize.dialog_id = jLongValue2;
                            ArrayList<MessageObject> arrayList3 = this.musicObjects.get(jLongValue2);
                            ArrayList<MediaSession.QueueItem> arrayList4 = this.musicQueues.get(jLongValue2);
                            if (arrayList3 == null) {
                                arrayList3 = new ArrayList<>();
                                this.musicObjects.put(jLongValue2, arrayList3);
                                arrayList4 = new ArrayList<>();
                                this.musicQueues.put(jLongValue2, arrayList4);
                            }
                            MessageObject messageObject = new MessageObject(this.currentAccount, tLRPC$MessageTLdeserialize, false, true);
                            arrayList3.add(0, messageObject);
                            MediaDescription.Builder mediaId = new MediaDescription.Builder().setMediaId(jLongValue2 + "_" + arrayList3.size());
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
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MusicBrowserService$7D4f4RO3K1e-QDUcpT6hT3GDDzk
            @Override // java.lang.Runnable
            public final void run() throws NumberFormatException {
                this.f$0.lambda$onLoadChildren$0$MusicBrowserService(str, result);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onLoadChildren$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onLoadChildren$0$MusicBrowserService(String str, MediaBrowserService.Result result) throws NumberFormatException {
        this.chatsLoaded = true;
        this.loadingChats = false;
        loadChildrenImpl(str, result);
        if (this.lastSelectedDialog == 0 && !this.dialogs.isEmpty()) {
            this.lastSelectedDialog = this.dialogs.get(0).longValue();
        }
        long j = this.lastSelectedDialog;
        if (j != 0) {
            ArrayList<MessageObject> arrayList = this.musicObjects.get(j);
            ArrayList<MediaSession.QueueItem> arrayList2 = this.musicQueues.get(this.lastSelectedDialog);
            if (arrayList != null && !arrayList.isEmpty()) {
                this.mediaSession.setQueue(arrayList2);
                long j2 = this.lastSelectedDialog;
                if (j2 > 0) {
                    TLRPC$User tLRPC$User = this.users.get(j2);
                    if (tLRPC$User != null) {
                        this.mediaSession.setQueueTitle(ContactsController.formatName(tLRPC$User.first_name, tLRPC$User.last_name));
                    } else {
                        this.mediaSession.setQueueTitle("DELETED USER");
                    }
                } else {
                    TLRPC$Chat tLRPC$Chat = this.chats.get(-j2);
                    if (tLRPC$Chat != null) {
                        this.mediaSession.setQueueTitle(tLRPC$Chat.title);
                    } else {
                        this.mediaSession.setQueueTitle("DELETED CHAT");
                    }
                }
                MessageObject messageObject = arrayList.get(0);
                MediaMetadata.Builder builder = new MediaMetadata.Builder();
                builder.putLong("android.media.metadata.DURATION", messageObject.getDuration() * 1000);
                builder.putString("android.media.metadata.ARTIST", messageObject.getMusicAuthor());
                builder.putString("android.media.metadata.TITLE", messageObject.getMusicTitle());
                this.mediaSession.setMetadata(builder.build());
            }
        }
        updatePlaybackState(null);
    }

    private void loadChildrenImpl(String parentMediaId, MediaBrowserService.Result<List<MediaBrowser.MediaItem>> result) throws NumberFormatException {
        int i;
        TLRPC$FileLocation tLRPC$FileLocation;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        if (MEDIA_ID_ROOT.equals(parentMediaId)) {
            while (i2 < this.dialogs.size()) {
                long jLongValue = this.dialogs.get(i2).longValue();
                MediaDescription.Builder mediaId = new MediaDescription.Builder().setMediaId("__CHAT_" + jLongValue);
                Bitmap bitmapCreateRoundBitmap = null;
                if (DialogObject.isUserDialog(jLongValue)) {
                    TLRPC$User tLRPC$User = this.users.get(jLongValue);
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
                    TLRPC$Chat tLRPC$Chat = this.chats.get(-jLongValue);
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
        } else if (parentMediaId != null && parentMediaId.startsWith("__CHAT_")) {
            try {
                i = Integer.parseInt(parentMediaId.replace("__CHAT_", ""));
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

    private Bitmap createRoundBitmap(File path) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 2;
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(path.toString(), options);
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
        public void onPlay() throws NumberFormatException, IOException {
            MessageObject playingMessageObject = MediaController.getInstance().getPlayingMessageObject();
            if (playingMessageObject == null) {
                onPlayFromMediaId(MusicBrowserService.this.lastSelectedDialog + "_0", null);
                return;
            }
            MediaController.getInstance().playMessage(playingMessageObject);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSkipToQueueItem(long queueId) throws IOException {
            MediaController.getInstance().playMessageAtIndex((int) queueId);
            MusicBrowserService.this.handlePlayRequest();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSeekTo(long position) {
            MessageObject playingMessageObject = MediaController.getInstance().getPlayingMessageObject();
            if (playingMessageObject != null) {
                MediaController.getInstance().seekToProgress(playingMessageObject, (position / 1000) / playingMessageObject.getDuration());
            }
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPlayFromMediaId(String mediaId, Bundle extras) throws NumberFormatException {
            long j;
            int i;
            ArrayList<MessageObject> arrayList;
            ArrayList arrayList2;
            String[] strArrSplit = mediaId.split("_");
            if (strArrSplit.length != 2) {
                return;
            }
            try {
                j = Long.parseLong(strArrSplit[0]);
                i = Integer.parseInt(strArrSplit[1]);
                arrayList = (ArrayList) MusicBrowserService.this.musicObjects.get(j);
                arrayList2 = (ArrayList) MusicBrowserService.this.musicQueues.get(j);
            } catch (Exception e) {
                FileLog.e(e);
            }
            if (arrayList != null && i >= 0 && i < arrayList.size()) {
                MusicBrowserService.this.lastSelectedDialog = j;
                MessagesController.getNotificationsSettings(MusicBrowserService.this.currentAccount).edit().putLong("auto_lastSelectedDialog", j).commit();
                MediaController.getInstance().setPlaylist(arrayList, arrayList.get(i), 0L, false, null);
                MusicBrowserService.this.mediaSession.setQueue(arrayList2);
                if (j > 0) {
                    TLRPC$User tLRPC$User = (TLRPC$User) MusicBrowserService.this.users.get(j);
                    if (tLRPC$User != null) {
                        MusicBrowserService.this.mediaSession.setQueueTitle(ContactsController.formatName(tLRPC$User.first_name, tLRPC$User.last_name));
                    } else {
                        MusicBrowserService.this.mediaSession.setQueueTitle("DELETED USER");
                    }
                } else {
                    TLRPC$Chat tLRPC$Chat = (TLRPC$Chat) MusicBrowserService.this.chats.get(-j);
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
        public void onSkipToNext() throws InterruptedException, IOException {
            MediaController.getInstance().playNextMessage();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSkipToPrevious() throws IOException {
            MediaController.getInstance().playPreviousMessage();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPlayFromSearch(String query, Bundle extras) throws NumberFormatException {
            String str;
            String str2;
            String str3;
            if (query == null || query.length() == 0) {
                return;
            }
            String lowerCase = query.toLowerCase();
            for (int i = 0; i < MusicBrowserService.this.dialogs.size(); i++) {
                long jLongValue = ((Long) MusicBrowserService.this.dialogs.get(i)).longValue();
                if (DialogObject.isUserDialog(jLongValue)) {
                    TLRPC$User tLRPC$User = (TLRPC$User) MusicBrowserService.this.users.get(jLongValue);
                    if (tLRPC$User != null && (((str2 = tLRPC$User.first_name) != null && str2.startsWith(lowerCase)) || ((str3 = tLRPC$User.last_name) != null && str3.startsWith(lowerCase)))) {
                        onPlayFromMediaId(jLongValue + "_0", null);
                        return;
                    }
                } else {
                    TLRPC$Chat tLRPC$Chat = (TLRPC$Chat) MusicBrowserService.this.chats.get(-jLongValue);
                    if (tLRPC$Chat != null && (str = tLRPC$Chat.title) != null && str.toLowerCase().contains(lowerCase)) {
                        onPlayFromMediaId(jLongValue + "_0", null);
                        return;
                    }
                }
            }
        }
    }

    private void updatePlaybackState(String error) {
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
        if (error != null) {
            actions.setErrorMessage(error);
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
    public void handleStopRequest(String withError) {
        this.delayedStopHandler.removeCallbacksAndMessages(null);
        this.delayedStopHandler.sendEmptyMessageDelayed(0, 30000L);
        updatePlaybackState(withError);
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
        builder.putLong("android.media.metadata.DURATION", playingMessageObject.getDuration() * 1000);
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
        MediaController.getInstance().lambda$startAudioAgain$7$MediaController(MediaController.getInstance().getPlayingMessageObject());
        this.delayedStopHandler.removeCallbacksAndMessages(null);
        this.delayedStopHandler.sendEmptyMessageDelayed(0, 30000L);
    }

    @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        updatePlaybackState(null);
        handlePlayRequest();
    }

    private static class DelayedStopHandler extends Handler {
        private final WeakReference<MusicBrowserService> mWeakReference;

        private DelayedStopHandler(MusicBrowserService service) {
            this.mWeakReference = new WeakReference<>(service);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
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
