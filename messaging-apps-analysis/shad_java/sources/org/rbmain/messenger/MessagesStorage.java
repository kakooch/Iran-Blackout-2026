package org.rbmain.messenger;

import android.appwidget.AppWidgetManager;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseIntArray;
import androidMessenger.proxy.FileLoadProxy;
import androidMessenger.proxy.IdStorage;
import androidx.collection.LongSparseArray;
import ir.aaap.messengercore.model.Chat;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;
import org.rbmain.SQLite.SQLiteCursor;
import org.rbmain.SQLite.SQLiteDatabase;
import org.rbmain.SQLite.SQLitePreparedStatement;
import org.rbmain.messenger.ContactsController;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.support.SparseLongArray;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.NativeByteBuffer;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$BotInfo;
import org.rbmain.tgnet.TLRPC$ChannelParticipant;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$ChatFull;
import org.rbmain.tgnet.TLRPC$ChatParticipant;
import org.rbmain.tgnet.TLRPC$ChatParticipants;
import org.rbmain.tgnet.TLRPC$Dialog;
import org.rbmain.tgnet.TLRPC$Document;
import org.rbmain.tgnet.TLRPC$DraftMessage;
import org.rbmain.tgnet.TLRPC$EncryptedChat;
import org.rbmain.tgnet.TLRPC$Message;
import org.rbmain.tgnet.TLRPC$MessageAction;
import org.rbmain.tgnet.TLRPC$MessageEntity;
import org.rbmain.tgnet.TLRPC$MessageFwdHeader;
import org.rbmain.tgnet.TLRPC$MessageMedia;
import org.rbmain.tgnet.TLRPC$MessageReplies;
import org.rbmain.tgnet.TLRPC$Peer;
import org.rbmain.tgnet.TLRPC$Photo;
import org.rbmain.tgnet.TLRPC$PhotoSize;
import org.rbmain.tgnet.TLRPC$Poll;
import org.rbmain.tgnet.TLRPC$PollResults;
import org.rbmain.tgnet.TLRPC$ReplyMarkup;
import org.rbmain.tgnet.TLRPC$TL_channelFull;
import org.rbmain.tgnet.TLRPC$TL_chatAdminRights;
import org.rbmain.tgnet.TLRPC$TL_chatBannedRights;
import org.rbmain.tgnet.TLRPC$TL_chatChannelParticipant;
import org.rbmain.tgnet.TLRPC$TL_chatFull;
import org.rbmain.tgnet.TLRPC$TL_chatParticipant;
import org.rbmain.tgnet.TLRPC$TL_chatParticipantAdmin;
import org.rbmain.tgnet.TLRPC$TL_chatParticipants;
import org.rbmain.tgnet.TLRPC$TL_contact;
import org.rbmain.tgnet.TLRPC$TL_dialog;
import org.rbmain.tgnet.TLRPC$TL_dialogFolder;
import org.rbmain.tgnet.TLRPC$TL_documentEmpty;
import org.rbmain.tgnet.TLRPC$TL_folder;
import org.rbmain.tgnet.TLRPC$TL_folderPeer;
import org.rbmain.tgnet.TLRPC$TL_inputFolderPeer;
import org.rbmain.tgnet.TLRPC$TL_inputMessageEntityMentionName;
import org.rbmain.tgnet.TLRPC$TL_message;
import org.rbmain.tgnet.TLRPC$TL_messageActionChatAddUser;
import org.rbmain.tgnet.TLRPC$TL_messageActionGameScore;
import org.rbmain.tgnet.TLRPC$TL_messageActionGeoProximityReached;
import org.rbmain.tgnet.TLRPC$TL_messageActionPaymentSent;
import org.rbmain.tgnet.TLRPC$TL_messageActionPinMessage;
import org.rbmain.tgnet.TLRPC$TL_messageEntityMentionName;
import org.rbmain.tgnet.TLRPC$TL_messageMediaDocument;
import org.rbmain.tgnet.TLRPC$TL_messageMediaPhoto;
import org.rbmain.tgnet.TLRPC$TL_messageMediaPoll;
import org.rbmain.tgnet.TLRPC$TL_messageMediaUnsupported;
import org.rbmain.tgnet.TLRPC$TL_messageMediaUnsupported_old;
import org.rbmain.tgnet.TLRPC$TL_messageMediaWebPage;
import org.rbmain.tgnet.TLRPC$TL_messageReactions;
import org.rbmain.tgnet.TLRPC$TL_messageReplies;
import org.rbmain.tgnet.TLRPC$TL_messageReplyHeader;
import org.rbmain.tgnet.TLRPC$TL_message_secret;
import org.rbmain.tgnet.TLRPC$TL_messages_botCallbackAnswer;
import org.rbmain.tgnet.TLRPC$TL_messages_botResults;
import org.rbmain.tgnet.TLRPC$TL_messages_dialogs;
import org.rbmain.tgnet.TLRPC$TL_messages_messages;
import org.rbmain.tgnet.TLRPC$TL_peerChannel;
import org.rbmain.tgnet.TLRPC$TL_peerChat;
import org.rbmain.tgnet.TLRPC$TL_peerNotifySettings;
import org.rbmain.tgnet.TLRPC$TL_peerNotifySettingsEmpty_layer77;
import org.rbmain.tgnet.TLRPC$TL_peerUser;
import org.rbmain.tgnet.TLRPC$TL_photoEmpty;
import org.rbmain.tgnet.TLRPC$TL_photos_photos;
import org.rbmain.tgnet.TLRPC$TL_replyInlineMarkup;
import org.rbmain.tgnet.TLRPC$TL_updates;
import org.rbmain.tgnet.TLRPC$TL_updates_channelDifferenceTooLong;
import org.rbmain.tgnet.TLRPC$TL_userStatusLastMonth;
import org.rbmain.tgnet.TLRPC$TL_userStatusLastWeek;
import org.rbmain.tgnet.TLRPC$TL_userStatusRecently;
import org.rbmain.tgnet.TLRPC$TL_wallPaper;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.tgnet.TLRPC$UserFull;
import org.rbmain.tgnet.TLRPC$UserProfilePhoto;
import org.rbmain.tgnet.TLRPC$UserStatus;
import org.rbmain.tgnet.TLRPC$Vector;
import org.rbmain.tgnet.TLRPC$WallPaper;
import org.rbmain.tgnet.TLRPC$WebPage;
import org.rbmain.tgnet.TLRPC$messages_Dialogs;
import org.rbmain.tgnet.TLRPC$messages_Messages;
import org.rbmain.tgnet.TLRPC$photos_Photos;
import org.rbmain.ui.Adapters.DialogsSearchAdapter;

/* loaded from: classes4.dex */
public class MessagesStorage extends BaseController {
    private static volatile MessagesStorage[] Instance = new MessagesStorage[3];
    private static final int LAST_DB_VERSION = 78;
    private int archiveUnreadCount;
    private int[][] bots;
    private File cacheFile;
    private int[][] channels;
    private int[][] contacts;
    private SQLiteDatabase database;
    private ArrayList<MessagesController.DialogFilter> dialogFilters;
    private SparseArray<MessagesController.DialogFilter> dialogFiltersMap;
    private LongSparseArray<Integer> dialogsWithMentions;
    private LongSparseArray<Integer> dialogsWithUnread;
    private int[][] groups;
    private int lastDateValue;
    private int lastPtsValue;
    private int lastQtsValue;
    private int lastSavedDate;
    private int lastSavedPts;
    private int lastSavedQts;
    private int lastSavedSeq;
    private int lastSecretVersion;
    private int lastSeqValue;
    private AtomicLong lastTaskId;
    private int mainUnreadCount;
    private int[] mentionChannels;
    private int[] mentionGroups;
    private int[][] nonContacts;
    private CountDownLatch openSync;
    private volatile int pendingArchiveUnreadCount;
    private volatile int pendingMainUnreadCount;
    private int secretG;
    private byte[] secretPBytes;
    private File shmCacheFile;
    private DispatchQueue storageQueue;
    private SparseArray<ArrayList<Runnable>> tasks;
    private LongSparseArray<Boolean> unknownDialogsIds;
    private File walCacheFile;

    public interface BooleanCallback {
        void run(boolean z);
    }

    public interface IntCallback {
        void run(int i);
    }

    private void calcUnreadCounters(boolean z) {
    }

    private void loadDialogFilters() {
    }

    private void loadPendingTasks() {
    }

    private void resetAllUnreadCounters(boolean z) {
    }

    private void updateDialogsWithReadMessagesInternal(ArrayList<Long> arrayList, SparseLongArray sparseLongArray, SparseLongArray sparseLongArray2, ArrayList<Long> arrayList2) {
    }

    private void updateFiltersReadCounter(LongSparseArray<Integer> longSparseArray, LongSparseArray<Integer> longSparseArray2, boolean z) throws Exception {
    }

    public void getDialogMaxMessageId(long j, IntCallback intCallback) {
    }

    public void loadUnreadMessages() {
    }

    /* renamed from: markMessageReactionsAsReadInternal, reason: merged with bridge method [inline-methods] */
    public void lambda$markMessageReactionsAsRead$156(long j, int i, long j2) {
    }

    public void putPushMessage(MessageObject messageObject) {
    }

    public void saveDialogFilter(MessagesController.DialogFilter dialogFilter, boolean z, boolean z2) {
    }

    public void updateMessageCustomParams(long j, TLRPC$Message tLRPC$Message) {
    }

    public static MessagesStorage getInstance(int i) {
        MessagesStorage messagesStorage = Instance[i];
        if (messagesStorage == null) {
            synchronized (MessagesStorage.class) {
                messagesStorage = Instance[i];
                if (messagesStorage == null) {
                    MessagesStorage[] messagesStorageArr = Instance;
                    MessagesStorage messagesStorage2 = new MessagesStorage(i);
                    messagesStorageArr[i] = messagesStorage2;
                    messagesStorage = messagesStorage2;
                }
            }
        }
        return messagesStorage;
    }

    private void ensureOpened() {
        try {
            this.openSync.await();
        } catch (Throwable unused) {
        }
    }

    public int getLastDateValue() {
        ensureOpened();
        return this.lastDateValue;
    }

    public void setLastDateValue(int i) {
        ensureOpened();
        this.lastDateValue = i;
    }

    public int getLastPtsValue() {
        ensureOpened();
        return this.lastPtsValue;
    }

    public int getMainUnreadCount() {
        return this.mainUnreadCount;
    }

    public int getArchiveUnreadCount() {
        return this.archiveUnreadCount;
    }

    public void setLastPtsValue(int i) {
        ensureOpened();
        this.lastPtsValue = i;
    }

    public int getLastQtsValue() {
        ensureOpened();
        return this.lastQtsValue;
    }

    public void setLastQtsValue(int i) {
        ensureOpened();
        this.lastQtsValue = i;
    }

    public int getLastSeqValue() {
        ensureOpened();
        return this.lastSeqValue;
    }

    public void setLastSeqValue(int i) {
        ensureOpened();
        this.lastSeqValue = i;
    }

    public int getLastSecretVersion() {
        ensureOpened();
        return this.lastSecretVersion;
    }

    public void setLastSecretVersion(int i) {
        ensureOpened();
        this.lastSecretVersion = i;
    }

    public byte[] getSecretPBytes() {
        ensureOpened();
        return this.secretPBytes;
    }

    public void setSecretPBytes(byte[] bArr) {
        ensureOpened();
        this.secretPBytes = bArr;
    }

    public int getSecretG() {
        ensureOpened();
        return this.secretG;
    }

    public void setSecretG(int i) {
        ensureOpened();
        this.secretG = i;
    }

    public MessagesStorage(int i) {
        super(i);
        this.storageQueue = new DispatchQueue("storageQueue");
        this.lastTaskId = new AtomicLong(System.currentTimeMillis());
        this.tasks = new SparseArray<>();
        this.lastDateValue = 0;
        this.lastPtsValue = 0;
        this.lastQtsValue = 0;
        this.lastSeqValue = 0;
        this.lastSecretVersion = 0;
        this.secretPBytes = null;
        this.secretG = 0;
        this.lastSavedSeq = 0;
        this.lastSavedPts = 0;
        this.lastSavedDate = 0;
        this.lastSavedQts = 0;
        this.dialogFilters = new ArrayList<>();
        this.dialogFiltersMap = new SparseArray<>();
        this.unknownDialogsIds = new LongSparseArray<>();
        this.openSync = new CountDownLatch(1);
        this.contacts = new int[][]{new int[2], new int[2]};
        this.nonContacts = new int[][]{new int[2], new int[2]};
        this.bots = new int[][]{new int[2], new int[2]};
        this.channels = new int[][]{new int[2], new int[2]};
        this.groups = new int[][]{new int[2], new int[2]};
        this.mentionChannels = new int[2];
        this.mentionGroups = new int[2];
        this.dialogsWithMentions = new LongSparseArray<>();
        this.dialogsWithUnread = new LongSparseArray<>();
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() throws Exception {
                this.f$0.lambda$new$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() throws Exception {
        openDatabase(1);
    }

    public SQLiteDatabase getDatabase() {
        return this.database;
    }

    public DispatchQueue getStorageQueue() {
        return this.storageQueue;
    }

    public void bindTaskToGuid(Runnable runnable, int i) {
        ArrayList<Runnable> arrayList = this.tasks.get(i);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.tasks.put(i, arrayList);
        }
        arrayList.add(runnable);
    }

    public void cancelTasksForGuid(int i) {
        ArrayList<Runnable> arrayList = this.tasks.get(i);
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.storageQueue.cancelRunnable(arrayList.get(i2));
        }
        this.tasks.remove(i);
    }

    public void completeTaskForGuid(Runnable runnable, int i) {
        ArrayList<Runnable> arrayList = this.tasks.get(i);
        if (arrayList == null) {
            return;
        }
        arrayList.remove(runnable);
        if (arrayList.isEmpty()) {
            this.tasks.remove(i);
        }
    }

    public long getDatabaseSize() {
        File file = this.cacheFile;
        long length = file != null ? 0 + file.length() : 0L;
        File file2 = this.shmCacheFile;
        return file2 != null ? length + file2.length() : length;
    }

    public void openDatabase(int i) throws Exception {
        File filesDirFixed = ApplicationLoader.getFilesDirFixed();
        if (this.currentAccount != 0) {
            File file = new File(filesDirFixed, "account" + this.currentAccount + "/");
            file.mkdirs();
            filesDirFixed = file;
        }
        this.cacheFile = new File(filesDirFixed, "cache4.db");
        this.walCacheFile = new File(filesDirFixed, "cache4.db-wal");
        this.shmCacheFile = new File(filesDirFixed, "cache4.db-shm");
        boolean z = !this.cacheFile.exists();
        try {
            SQLiteDatabase sQLiteDatabase = new SQLiteDatabase(this.cacheFile.getPath());
            this.database = sQLiteDatabase;
            sQLiteDatabase.executeFast("PRAGMA secure_delete = ON").stepThis().dispose();
            this.database.executeFast("PRAGMA temp_store = MEMORY").stepThis().dispose();
            this.database.executeFast("PRAGMA journal_mode = WAL").stepThis().dispose();
            this.database.executeFast("PRAGMA journal_size_limit = 10485760").stepThis().dispose();
            if (z) {
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("create new database");
                }
                this.database.executeFast("CREATE TABLE messages_holes(uid INTEGER, start INTEGER, end INTEGER, PRIMARY KEY(uid, start));").stepThis().dispose();
                this.database.executeFast("CREATE INDEX IF NOT EXISTS uid_end_messages_holes ON messages_holes(uid, end);").stepThis().dispose();
                this.database.executeFast("CREATE TABLE media_holes_v2(uid INTEGER, type INTEGER, start INTEGER, end INTEGER, PRIMARY KEY(uid, type, start));").stepThis().dispose();
                this.database.executeFast("CREATE INDEX IF NOT EXISTS uid_end_media_holes_v2 ON media_holes_v2(uid, type, end);").stepThis().dispose();
                this.database.executeFast("CREATE TABLE scheduled_messages(mid INTEGER PRIMARY KEY, uid INTEGER, send_state INTEGER, date INTEGER, data BLOB, ttl INTEGER, replydata BLOB)").stepThis().dispose();
                this.database.executeFast("CREATE INDEX IF NOT EXISTS send_state_idx_scheduled_messages ON scheduled_messages(mid, send_state, date);").stepThis().dispose();
                this.database.executeFast("CREATE INDEX IF NOT EXISTS uid_date_idx_scheduled_messages ON scheduled_messages(uid, date);").stepThis().dispose();
                this.database.executeFast("CREATE TABLE messages(mid INTEGER PRIMARY KEY, uid INTEGER, read_state INTEGER, send_state INTEGER, date INTEGER, data BLOB, out INTEGER, ttl INTEGER, media INTEGER, replydata BLOB, imp INTEGER, mention INTEGER, forwards INTEGER, replies_data BLOB, thread_reply_id INTEGER)").stepThis().dispose();
                this.database.executeFast("CREATE INDEX IF NOT EXISTS uid_mid_read_out_idx_messages ON messages(uid, mid, read_state, out);").stepThis().dispose();
                this.database.executeFast("CREATE INDEX IF NOT EXISTS uid_date_mid_idx_messages ON messages(uid, date, mid);").stepThis().dispose();
                this.database.executeFast("CREATE INDEX IF NOT EXISTS mid_out_idx_messages ON messages(mid, out);").stepThis().dispose();
                this.database.executeFast("CREATE INDEX IF NOT EXISTS task_idx_messages ON messages(uid, out, read_state, ttl, date, send_state);").stepThis().dispose();
                this.database.executeFast("CREATE INDEX IF NOT EXISTS send_state_idx_messages2 ON messages(mid, send_state, date);").stepThis().dispose();
                this.database.executeFast("CREATE INDEX IF NOT EXISTS uid_mention_idx_messages ON messages(uid, mention, read_state);").stepThis().dispose();
                this.database.executeFast("CREATE TABLE download_queue(uid INTEGER, type INTEGER, date INTEGER, data BLOB, parent TEXT, PRIMARY KEY (uid, type));").stepThis().dispose();
                this.database.executeFast("CREATE INDEX IF NOT EXISTS type_date_idx_download_queue ON download_queue(type, date);").stepThis().dispose();
                this.database.executeFast("CREATE TABLE user_contacts_v7(key TEXT PRIMARY KEY, uid INTEGER, fname TEXT, sname TEXT, imported INTEGER)").stepThis().dispose();
                this.database.executeFast("CREATE TABLE user_phones_v7(key TEXT, phone TEXT, sphone TEXT, deleted INTEGER, PRIMARY KEY (key, phone))").stepThis().dispose();
                this.database.executeFast("CREATE INDEX IF NOT EXISTS sphone_deleted_idx_user_phones ON user_phones_v7(sphone, deleted);").stepThis().dispose();
                this.database.executeFast("CREATE TABLE dialogs(did INTEGER PRIMARY KEY, date INTEGER, unread_count INTEGER, last_mid INTEGER, inbox_max INTEGER, outbox_max INTEGER, last_mid_i INTEGER, unread_count_i INTEGER, pts INTEGER, date_i INTEGER, pinned INTEGER, flags INTEGER, folder_id INTEGER, data BLOB)").stepThis().dispose();
                this.database.executeFast("CREATE INDEX IF NOT EXISTS date_idx_dialogs ON dialogs(date);").stepThis().dispose();
                this.database.executeFast("CREATE INDEX IF NOT EXISTS last_mid_idx_dialogs ON dialogs(last_mid);").stepThis().dispose();
                this.database.executeFast("CREATE INDEX IF NOT EXISTS unread_count_idx_dialogs ON dialogs(unread_count);").stepThis().dispose();
                this.database.executeFast("CREATE INDEX IF NOT EXISTS last_mid_i_idx_dialogs ON dialogs(last_mid_i);").stepThis().dispose();
                this.database.executeFast("CREATE INDEX IF NOT EXISTS unread_count_i_idx_dialogs ON dialogs(unread_count_i);").stepThis().dispose();
                this.database.executeFast("CREATE INDEX IF NOT EXISTS folder_id_idx_dialogs ON dialogs(folder_id);").stepThis().dispose();
                this.database.executeFast("CREATE INDEX IF NOT EXISTS flags_idx_dialogs ON dialogs(flags);").stepThis().dispose();
                this.database.executeFast("CREATE TABLE dialog_filter(id INTEGER PRIMARY KEY, ord INTEGER, unread_count INTEGER, flags INTEGER, title TEXT)").stepThis().dispose();
                this.database.executeFast("CREATE TABLE dialog_filter_ep(id INTEGER, peer INTEGER, PRIMARY KEY (id, peer))").stepThis().dispose();
                this.database.executeFast("CREATE TABLE dialog_filter_pin_v2(id INTEGER, peer INTEGER, pin INTEGER, PRIMARY KEY (id, peer))").stepThis().dispose();
                this.database.executeFast("CREATE TABLE randoms(random_id INTEGER, mid INTEGER, PRIMARY KEY (random_id, mid))").stepThis().dispose();
                this.database.executeFast("CREATE INDEX IF NOT EXISTS mid_idx_randoms ON randoms(mid);").stepThis().dispose();
                this.database.executeFast("CREATE TABLE enc_tasks_v2(mid INTEGER PRIMARY KEY, date INTEGER, media INTEGER)").stepThis().dispose();
                this.database.executeFast("CREATE INDEX IF NOT EXISTS date_idx_enc_tasks_v2 ON enc_tasks_v2(date);").stepThis().dispose();
                this.database.executeFast("CREATE TABLE messages_seq(mid INTEGER PRIMARY KEY, seq_in INTEGER, seq_out INTEGER);").stepThis().dispose();
                this.database.executeFast("CREATE INDEX IF NOT EXISTS seq_idx_messages_seq ON messages_seq(seq_in, seq_out);").stepThis().dispose();
                this.database.executeFast("CREATE TABLE params(id INTEGER PRIMARY KEY, seq INTEGER, pts INTEGER, date INTEGER, qts INTEGER, lsv INTEGER, sg INTEGER, pbytes BLOB)").stepThis().dispose();
                this.database.executeFast("INSERT INTO params VALUES(1, 0, 0, 0, 0, 0, 0, NULL)").stepThis().dispose();
                this.database.executeFast("CREATE TABLE media_v2(mid INTEGER PRIMARY KEY, uid INTEGER, date INTEGER, type INTEGER, data BLOB)").stepThis().dispose();
                this.database.executeFast("CREATE INDEX IF NOT EXISTS uid_mid_type_date_idx_media ON media_v2(uid, mid, type, date);").stepThis().dispose();
                this.database.executeFast("CREATE TABLE bot_keyboard(uid INTEGER PRIMARY KEY, mid INTEGER, info BLOB)").stepThis().dispose();
                this.database.executeFast("CREATE INDEX IF NOT EXISTS bot_keyboard_idx_mid ON bot_keyboard(mid);").stepThis().dispose();
                this.database.executeFast("CREATE TABLE chat_settings_v2(uid INTEGER PRIMARY KEY, info BLOB, pinned INTEGER, online INTEGER, inviter INTEGER, links INTEGER)").stepThis().dispose();
                this.database.executeFast("CREATE INDEX IF NOT EXISTS chat_settings_pinned_idx ON chat_settings_v2(uid, pinned) WHERE pinned != 0;").stepThis().dispose();
                this.database.executeFast("CREATE TABLE user_settings(uid INTEGER PRIMARY KEY, info BLOB, pinned INTEGER)").stepThis().dispose();
                this.database.executeFast("CREATE INDEX IF NOT EXISTS user_settings_pinned_idx ON user_settings(uid, pinned) WHERE pinned != 0;").stepThis().dispose();
                this.database.executeFast("CREATE TABLE chat_pinned_v2(uid INTEGER, mid INTEGER, data BLOB, PRIMARY KEY (uid, mid));").stepThis().dispose();
                this.database.executeFast("CREATE TABLE chat_pinned_count(uid INTEGER PRIMARY KEY, count INTEGER, end INTEGER);").stepThis().dispose();
                this.database.executeFast("CREATE TABLE chat_hints(did INTEGER, type INTEGER, rating REAL, date INTEGER, PRIMARY KEY(did, type))").stepThis().dispose();
                this.database.executeFast("CREATE INDEX IF NOT EXISTS chat_hints_rating_idx ON chat_hints(rating);").stepThis().dispose();
                this.database.executeFast("CREATE TABLE botcache(id TEXT PRIMARY KEY, date INTEGER, data BLOB)").stepThis().dispose();
                this.database.executeFast("CREATE INDEX IF NOT EXISTS botcache_date_idx ON botcache(date);").stepThis().dispose();
                this.database.executeFast("CREATE TABLE users_data(uid INTEGER PRIMARY KEY, about TEXT)").stepThis().dispose();
                this.database.executeFast("CREATE TABLE users(uid INTEGER PRIMARY KEY, name TEXT, status INTEGER, data BLOB)").stepThis().dispose();
                this.database.executeFast("CREATE TABLE chats(uid INTEGER PRIMARY KEY, name TEXT, data BLOB)").stepThis().dispose();
                this.database.executeFast("CREATE TABLE enc_chats(uid INTEGER PRIMARY KEY, user INTEGER, name TEXT, data BLOB, g BLOB, authkey BLOB, ttl INTEGER, layer INTEGER, seq_in INTEGER, seq_out INTEGER, use_count INTEGER, exchange_id INTEGER, key_date INTEGER, fprint INTEGER, fauthkey BLOB, khash BLOB, in_seq_no INTEGER, admin_id INTEGER, mtproto_seq INTEGER)").stepThis().dispose();
                this.database.executeFast("CREATE TABLE channel_users_v2(did INTEGER, uid INTEGER, date INTEGER, data BLOB, PRIMARY KEY(did, uid))").stepThis().dispose();
                this.database.executeFast("CREATE TABLE channel_admins_v3(did INTEGER, uid INTEGER, data BLOB, PRIMARY KEY(did, uid))").stepThis().dispose();
                this.database.executeFast("CREATE TABLE contacts(uid INTEGER PRIMARY KEY, mutual INTEGER)").stepThis().dispose();
                this.database.executeFast("CREATE TABLE user_photos(uid INTEGER, id INTEGER, data BLOB, PRIMARY KEY (uid, id))").stepThis().dispose();
                this.database.executeFast("CREATE TABLE dialog_settings(did INTEGER PRIMARY KEY, flags INTEGER);").stepThis().dispose();
                this.database.executeFast("CREATE TABLE web_recent_v3(id TEXT, type INTEGER, image_url TEXT, thumb_url TEXT, local_url TEXT, width INTEGER, height INTEGER, size INTEGER, date INTEGER, document BLOB, PRIMARY KEY (id, type));").stepThis().dispose();
                this.database.executeFast("CREATE TABLE stickers_v2(id INTEGER PRIMARY KEY, data BLOB, date INTEGER, hash INTEGER);").stepThis().dispose();
                this.database.executeFast("CREATE TABLE stickers_featured(id INTEGER PRIMARY KEY, data BLOB, unread BLOB, date INTEGER, hash INTEGER);").stepThis().dispose();
                this.database.executeFast("CREATE TABLE stickers_dice(emoji TEXT PRIMARY KEY, data BLOB, date INTEGER);").stepThis().dispose();
                this.database.executeFast("CREATE TABLE hashtag_recent_v2(id TEXT PRIMARY KEY, date INTEGER);").stepThis().dispose();
                this.database.executeFast("CREATE TABLE webpage_pending(id INTEGER, mid INTEGER, PRIMARY KEY (id, mid));").stepThis().dispose();
                this.database.executeFast("CREATE TABLE sent_files_v2(uid TEXT, type INTEGER, data BLOB, parent TEXT, PRIMARY KEY (uid, type))").stepThis().dispose();
                this.database.executeFast("CREATE TABLE search_recent(did INTEGER PRIMARY KEY, date INTEGER);").stepThis().dispose();
                this.database.executeFast("CREATE TABLE media_counts_v2(uid INTEGER, type INTEGER, count INTEGER, old INTEGER, PRIMARY KEY(uid, type))").stepThis().dispose();
                this.database.executeFast("CREATE TABLE keyvalue(id TEXT PRIMARY KEY, value TEXT)").stepThis().dispose();
                this.database.executeFast("CREATE TABLE bot_info(uid INTEGER PRIMARY KEY, info BLOB)").stepThis().dispose();
                this.database.executeFast("CREATE TABLE pending_tasks(id INTEGER PRIMARY KEY, data BLOB);").stepThis().dispose();
                this.database.executeFast("CREATE TABLE requested_holes(uid INTEGER, seq_out_start INTEGER, seq_out_end INTEGER, PRIMARY KEY (uid, seq_out_start, seq_out_end));").stepThis().dispose();
                this.database.executeFast("CREATE TABLE sharing_locations(uid INTEGER PRIMARY KEY, mid INTEGER, date INTEGER, period INTEGER, message BLOB, proximity INTEGER);").stepThis().dispose();
                this.database.executeFast("CREATE TABLE shortcut_widget(id INTEGER, did INTEGER, ord INTEGER, PRIMARY KEY (id, did));").stepThis().dispose();
                this.database.executeFast("CREATE INDEX IF NOT EXISTS shortcut_widget_did ON shortcut_widget(did);").stepThis().dispose();
                this.database.executeFast("CREATE TABLE emoji_keywords_v2(lang TEXT, keyword TEXT, emoji TEXT, PRIMARY KEY(lang, keyword, emoji));").stepThis().dispose();
                this.database.executeFast("CREATE INDEX IF NOT EXISTS emoji_keywords_v2_keyword ON emoji_keywords_v2(keyword);").stepThis().dispose();
                this.database.executeFast("CREATE TABLE emoji_keywords_info_v2(lang TEXT PRIMARY KEY, alias TEXT, version INTEGER, date INTEGER);").stepThis().dispose();
                this.database.executeFast("CREATE TABLE wallpapers2(uid INTEGER PRIMARY KEY, data BLOB, num INTEGER)").stepThis().dispose();
                this.database.executeFast("CREATE INDEX IF NOT EXISTS wallpapers_num ON wallpapers2(num);").stepThis().dispose();
                this.database.executeFast("CREATE TABLE unread_push_messages(uid INTEGER, mid INTEGER, random INTEGER, date INTEGER, data BLOB, fm TEXT, name TEXT, uname TEXT, flags INTEGER, PRIMARY KEY(uid, mid))").stepThis().dispose();
                this.database.executeFast("CREATE INDEX IF NOT EXISTS unread_push_messages_idx_date ON unread_push_messages(date);").stepThis().dispose();
                this.database.executeFast("CREATE INDEX IF NOT EXISTS unread_push_messages_idx_random ON unread_push_messages(random);").stepThis().dispose();
                this.database.executeFast("CREATE TABLE polls(mid INTEGER PRIMARY KEY, id INTEGER);").stepThis().dispose();
                this.database.executeFast("CREATE INDEX IF NOT EXISTS polls_id ON polls(id);").stepThis().dispose();
                this.database.executeFast("PRAGMA user_version = 78").stepThis().dispose();
            } else {
                int iIntValue = this.database.executeInt("PRAGMA user_version", new Object[0]).intValue();
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("current db version = " + iIntValue);
                }
                if (iIntValue == 0) {
                    throw new Exception("malformed");
                }
                try {
                    SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized("SELECT seq, pts, date, qts, lsv, sg, pbytes FROM params WHERE id = 1", new Object[0]);
                    if (sQLiteCursorQueryFinalized.next()) {
                        this.lastSeqValue = sQLiteCursorQueryFinalized.intValue(0);
                        this.lastPtsValue = sQLiteCursorQueryFinalized.intValue(1);
                        this.lastDateValue = sQLiteCursorQueryFinalized.intValue(2);
                        this.lastQtsValue = sQLiteCursorQueryFinalized.intValue(3);
                        this.lastSecretVersion = sQLiteCursorQueryFinalized.intValue(4);
                        this.secretG = sQLiteCursorQueryFinalized.intValue(5);
                        if (sQLiteCursorQueryFinalized.isNull(6)) {
                            this.secretPBytes = null;
                        } else {
                            byte[] bArrByteArrayValue = sQLiteCursorQueryFinalized.byteArrayValue(6);
                            this.secretPBytes = bArrByteArrayValue;
                            if (bArrByteArrayValue != null && bArrByteArrayValue.length == 1) {
                                this.secretPBytes = null;
                            }
                        }
                    }
                    sQLiteCursorQueryFinalized.dispose();
                } catch (Exception e) {
                    FileLog.e(e);
                    try {
                        this.database.executeFast("CREATE TABLE IF NOT EXISTS params(id INTEGER PRIMARY KEY, seq INTEGER, pts INTEGER, date INTEGER, qts INTEGER, lsv INTEGER, sg INTEGER, pbytes BLOB)").stepThis().dispose();
                        this.database.executeFast("INSERT INTO params VALUES(1, 0, 0, 0, 0, 0, 0, NULL)").stepThis().dispose();
                    } catch (Exception e2) {
                        FileLog.e(e2);
                    }
                }
                if (iIntValue < 78) {
                    updateDbToLastVersion(iIntValue);
                }
            }
        } catch (Exception e3) {
            FileLog.e(e3);
            if (i < 3 && e3.getMessage().contains("malformed")) {
                if (i == 2) {
                    cleanupInternal(true);
                    for (int i2 = 0; i2 < 2; i2++) {
                        getUserConfig().setDialogsLoadOffset(i2, 0L, 0, 0, 0, 0, 0L);
                        getUserConfig().setTotalDialogsCount(i2, 0);
                    }
                    getUserConfig().saveConfig(false);
                } else {
                    cleanupInternal(false);
                }
                openDatabase(i == 1 ? 2 : 3);
            }
        }
        loadDialogFilters();
        loadUnreadMessages();
        loadPendingTasks();
        try {
            this.openSync.countDown();
        } catch (Throwable unused) {
        }
    }

    private void updateDbToLastVersion(final int i) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda20
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateDbToLastVersion$1(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateDbToLastVersion$1(int i) {
        if (i < 4) {
            try {
                this.database.executeFast("CREATE TABLE IF NOT EXISTS user_photos(uid INTEGER, id INTEGER, data BLOB, PRIMARY KEY (uid, id))").stepThis().dispose();
                this.database.executeFast("DROP INDEX IF EXISTS read_state_out_idx_messages;").stepThis().dispose();
                this.database.executeFast("DROP INDEX IF EXISTS ttl_idx_messages;").stepThis().dispose();
                this.database.executeFast("DROP INDEX IF EXISTS date_idx_messages;").stepThis().dispose();
                this.database.executeFast("CREATE INDEX IF NOT EXISTS mid_out_idx_messages ON messages(mid, out);").stepThis().dispose();
                this.database.executeFast("CREATE INDEX IF NOT EXISTS task_idx_messages ON messages(uid, out, read_state, ttl, date, send_state);").stepThis().dispose();
                this.database.executeFast("CREATE INDEX IF NOT EXISTS uid_date_mid_idx_messages ON messages(uid, date, mid);").stepThis().dispose();
                this.database.executeFast("CREATE TABLE IF NOT EXISTS user_contacts_v6(uid INTEGER PRIMARY KEY, fname TEXT, sname TEXT)").stepThis().dispose();
                this.database.executeFast("CREATE TABLE IF NOT EXISTS user_phones_v6(uid INTEGER, phone TEXT, sphone TEXT, deleted INTEGER, PRIMARY KEY (uid, phone))").stepThis().dispose();
                this.database.executeFast("CREATE INDEX IF NOT EXISTS sphone_deleted_idx_user_phones ON user_phones_v6(sphone, deleted);").stepThis().dispose();
                this.database.executeFast("CREATE INDEX IF NOT EXISTS mid_idx_randoms ON randoms(mid);").stepThis().dispose();
                this.database.executeFast("CREATE TABLE IF NOT EXISTS sent_files_v2(uid TEXT, type INTEGER, data BLOB, PRIMARY KEY (uid, type))").stepThis().dispose();
                this.database.executeFast("CREATE TABLE IF NOT EXISTS download_queue(uid INTEGER, type INTEGER, date INTEGER, data BLOB, PRIMARY KEY (uid, type));").stepThis().dispose();
                this.database.executeFast("CREATE INDEX IF NOT EXISTS type_date_idx_download_queue ON download_queue(type, date);").stepThis().dispose();
                this.database.executeFast("CREATE TABLE IF NOT EXISTS dialog_settings(did INTEGER PRIMARY KEY, flags INTEGER);").stepThis().dispose();
                this.database.executeFast("CREATE INDEX IF NOT EXISTS unread_count_idx_dialogs ON dialogs(unread_count);").stepThis().dispose();
                this.database.executeFast("UPDATE messages SET send_state = 2 WHERE mid < 0 AND send_state = 1").stepThis().dispose();
                fixNotificationSettings();
                this.database.executeFast("PRAGMA user_version = 4").stepThis().dispose();
                i = 4;
            } catch (Exception e) {
                FileLog.e(e);
                return;
            }
        }
        if (i == 4) {
            this.database.executeFast("CREATE TABLE IF NOT EXISTS enc_tasks_v2(mid INTEGER PRIMARY KEY, date INTEGER)").stepThis().dispose();
            this.database.executeFast("CREATE INDEX IF NOT EXISTS date_idx_enc_tasks_v2 ON enc_tasks_v2(date);").stepThis().dispose();
            this.database.beginTransaction();
            SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized("SELECT date, data FROM enc_tasks WHERE 1", new Object[0]);
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("REPLACE INTO enc_tasks_v2 VALUES(?, ?)");
            if (sQLiteCursorQueryFinalized.next()) {
                int iIntValue = sQLiteCursorQueryFinalized.intValue(0);
                NativeByteBuffer nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized.byteBufferValue(1);
                if (nativeByteBufferByteBufferValue != null) {
                    int iLimit = nativeByteBufferByteBufferValue.limit();
                    for (int i2 = 0; i2 < iLimit / 4; i2++) {
                        sQLitePreparedStatementExecuteFast.requery();
                        sQLitePreparedStatementExecuteFast.bindInteger(1, nativeByteBufferByteBufferValue.readInt32(false));
                        sQLitePreparedStatementExecuteFast.bindInteger(2, iIntValue);
                        sQLitePreparedStatementExecuteFast.step();
                    }
                    nativeByteBufferByteBufferValue.reuse();
                }
            }
            sQLitePreparedStatementExecuteFast.dispose();
            sQLiteCursorQueryFinalized.dispose();
            this.database.commitTransaction();
            this.database.executeFast("DROP INDEX IF EXISTS date_idx_enc_tasks;").stepThis().dispose();
            this.database.executeFast("DROP TABLE IF EXISTS enc_tasks;").stepThis().dispose();
            this.database.executeFast("ALTER TABLE messages ADD COLUMN media INTEGER default 0").stepThis().dispose();
            this.database.executeFast("PRAGMA user_version = 6").stepThis().dispose();
            i = 6;
        }
        if (i == 6) {
            this.database.executeFast("CREATE TABLE IF NOT EXISTS messages_seq(mid INTEGER PRIMARY KEY, seq_in INTEGER, seq_out INTEGER);").stepThis().dispose();
            this.database.executeFast("CREATE INDEX IF NOT EXISTS seq_idx_messages_seq ON messages_seq(seq_in, seq_out);").stepThis().dispose();
            this.database.executeFast("ALTER TABLE enc_chats ADD COLUMN layer INTEGER default 0").stepThis().dispose();
            this.database.executeFast("ALTER TABLE enc_chats ADD COLUMN seq_in INTEGER default 0").stepThis().dispose();
            this.database.executeFast("ALTER TABLE enc_chats ADD COLUMN seq_out INTEGER default 0").stepThis().dispose();
            this.database.executeFast("PRAGMA user_version = 7").stepThis().dispose();
            i = 7;
        }
        if (i == 7 || i == 8 || i == 9) {
            this.database.executeFast("ALTER TABLE enc_chats ADD COLUMN use_count INTEGER default 0").stepThis().dispose();
            this.database.executeFast("ALTER TABLE enc_chats ADD COLUMN exchange_id INTEGER default 0").stepThis().dispose();
            this.database.executeFast("ALTER TABLE enc_chats ADD COLUMN key_date INTEGER default 0").stepThis().dispose();
            this.database.executeFast("ALTER TABLE enc_chats ADD COLUMN fprint INTEGER default 0").stepThis().dispose();
            this.database.executeFast("ALTER TABLE enc_chats ADD COLUMN fauthkey BLOB default NULL").stepThis().dispose();
            this.database.executeFast("ALTER TABLE enc_chats ADD COLUMN khash BLOB default NULL").stepThis().dispose();
            this.database.executeFast("PRAGMA user_version = 10").stepThis().dispose();
            i = 10;
        }
        if (i == 10) {
            this.database.executeFast("CREATE TABLE IF NOT EXISTS web_recent_v3(id TEXT, type INTEGER, image_url TEXT, thumb_url TEXT, local_url TEXT, width INTEGER, height INTEGER, size INTEGER, date INTEGER, PRIMARY KEY (id, type));").stepThis().dispose();
            this.database.executeFast("PRAGMA user_version = 11").stepThis().dispose();
            i = 11;
        }
        if (i == 11 || i == 12) {
            this.database.executeFast("DROP INDEX IF EXISTS uid_mid_idx_media;").stepThis().dispose();
            this.database.executeFast("DROP INDEX IF EXISTS mid_idx_media;").stepThis().dispose();
            this.database.executeFast("DROP INDEX IF EXISTS uid_date_mid_idx_media;").stepThis().dispose();
            this.database.executeFast("DROP TABLE IF EXISTS media;").stepThis().dispose();
            this.database.executeFast("DROP TABLE IF EXISTS media_counts;").stepThis().dispose();
            this.database.executeFast("CREATE TABLE IF NOT EXISTS media_v2(mid INTEGER PRIMARY KEY, uid INTEGER, date INTEGER, type INTEGER, data BLOB)").stepThis().dispose();
            this.database.executeFast("CREATE TABLE IF NOT EXISTS media_counts_v2(uid INTEGER, type INTEGER, count INTEGER, PRIMARY KEY(uid, type))").stepThis().dispose();
            this.database.executeFast("CREATE INDEX IF NOT EXISTS uid_mid_type_date_idx_media ON media_v2(uid, mid, type, date);").stepThis().dispose();
            this.database.executeFast("CREATE TABLE IF NOT EXISTS keyvalue(id TEXT PRIMARY KEY, value TEXT)").stepThis().dispose();
            this.database.executeFast("PRAGMA user_version = 13").stepThis().dispose();
            i = 13;
        }
        if (i == 13) {
            this.database.executeFast("ALTER TABLE messages ADD COLUMN replydata BLOB default NULL").stepThis().dispose();
            this.database.executeFast("PRAGMA user_version = 14").stepThis().dispose();
            i = 14;
        }
        if (i == 14) {
            this.database.executeFast("CREATE TABLE IF NOT EXISTS hashtag_recent_v2(id TEXT PRIMARY KEY, date INTEGER);").stepThis().dispose();
            this.database.executeFast("PRAGMA user_version = 15").stepThis().dispose();
            i = 15;
        }
        if (i == 15) {
            this.database.executeFast("CREATE TABLE IF NOT EXISTS webpage_pending(id INTEGER, mid INTEGER, PRIMARY KEY (id, mid));").stepThis().dispose();
            this.database.executeFast("PRAGMA user_version = 16").stepThis().dispose();
            i = 16;
        }
        if (i == 16) {
            this.database.executeFast("ALTER TABLE dialogs ADD COLUMN inbox_max INTEGER default 0").stepThis().dispose();
            this.database.executeFast("ALTER TABLE dialogs ADD COLUMN outbox_max INTEGER default 0").stepThis().dispose();
            this.database.executeFast("PRAGMA user_version = 17").stepThis().dispose();
            i = 17;
        }
        if (i == 17) {
            this.database.executeFast("CREATE TABLE bot_info(uid INTEGER PRIMARY KEY, info BLOB)").stepThis().dispose();
            this.database.executeFast("PRAGMA user_version = 18").stepThis().dispose();
            i = 18;
        }
        if (i == 18) {
            this.database.executeFast("DROP TABLE IF EXISTS stickers;").stepThis().dispose();
            this.database.executeFast("CREATE TABLE IF NOT EXISTS stickers_v2(id INTEGER PRIMARY KEY, data BLOB, date INTEGER, hash INTEGER);").stepThis().dispose();
            this.database.executeFast("PRAGMA user_version = 19").stepThis().dispose();
            i = 19;
        }
        if (i == 19) {
            this.database.executeFast("CREATE TABLE IF NOT EXISTS bot_keyboard(uid INTEGER PRIMARY KEY, mid INTEGER, info BLOB)").stepThis().dispose();
            this.database.executeFast("CREATE INDEX IF NOT EXISTS bot_keyboard_idx_mid ON bot_keyboard(mid);").stepThis().dispose();
            this.database.executeFast("PRAGMA user_version = 20").stepThis().dispose();
            i = 20;
        }
        if (i == 20) {
            this.database.executeFast("CREATE TABLE search_recent(did INTEGER PRIMARY KEY, date INTEGER);").stepThis().dispose();
            this.database.executeFast("PRAGMA user_version = 21").stepThis().dispose();
            i = 21;
        }
        if (i == 21) {
            this.database.executeFast("CREATE TABLE IF NOT EXISTS chat_settings_v2(uid INTEGER PRIMARY KEY, info BLOB)").stepThis().dispose();
            SQLiteCursor sQLiteCursorQueryFinalized2 = this.database.queryFinalized("SELECT uid, participants FROM chat_settings WHERE uid < 0", new Object[0]);
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast2 = this.database.executeFast("REPLACE INTO chat_settings_v2 VALUES(?, ?)");
            while (sQLiteCursorQueryFinalized2.next()) {
                int iIntValue2 = sQLiteCursorQueryFinalized2.intValue(0);
                NativeByteBuffer nativeByteBufferByteBufferValue2 = sQLiteCursorQueryFinalized2.byteBufferValue(1);
                if (nativeByteBufferByteBufferValue2 != null) {
                    TLRPC$ChatParticipants tLRPC$ChatParticipantsTLdeserialize = TLRPC$ChatParticipants.TLdeserialize(nativeByteBufferByteBufferValue2, nativeByteBufferByteBufferValue2.readInt32(false), false);
                    nativeByteBufferByteBufferValue2.reuse();
                    if (tLRPC$ChatParticipantsTLdeserialize != null) {
                        TLRPC$TL_chatFull tLRPC$TL_chatFull = new TLRPC$TL_chatFull();
                        tLRPC$TL_chatFull.id = iIntValue2;
                        tLRPC$TL_chatFull.chat_photo = new TLRPC$TL_photoEmpty();
                        tLRPC$TL_chatFull.notify_settings = new TLRPC$TL_peerNotifySettingsEmpty_layer77();
                        tLRPC$TL_chatFull.exported_invite = null;
                        tLRPC$TL_chatFull.participants = tLRPC$ChatParticipantsTLdeserialize;
                        NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(tLRPC$TL_chatFull.getObjectSize());
                        tLRPC$TL_chatFull.serializeToStream(nativeByteBuffer);
                        sQLitePreparedStatementExecuteFast2.requery();
                        sQLitePreparedStatementExecuteFast2.bindInteger(1, iIntValue2);
                        sQLitePreparedStatementExecuteFast2.bindByteBuffer(2, nativeByteBuffer);
                        sQLitePreparedStatementExecuteFast2.step();
                        nativeByteBuffer.reuse();
                    }
                }
            }
            sQLitePreparedStatementExecuteFast2.dispose();
            sQLiteCursorQueryFinalized2.dispose();
            this.database.executeFast("DROP TABLE IF EXISTS chat_settings;").stepThis().dispose();
            this.database.executeFast("ALTER TABLE dialogs ADD COLUMN last_mid_i INTEGER default 0").stepThis().dispose();
            this.database.executeFast("ALTER TABLE dialogs ADD COLUMN unread_count_i INTEGER default 0").stepThis().dispose();
            this.database.executeFast("ALTER TABLE dialogs ADD COLUMN pts INTEGER default 0").stepThis().dispose();
            this.database.executeFast("ALTER TABLE dialogs ADD COLUMN date_i INTEGER default 0").stepThis().dispose();
            this.database.executeFast("CREATE INDEX IF NOT EXISTS last_mid_i_idx_dialogs ON dialogs(last_mid_i);").stepThis().dispose();
            this.database.executeFast("CREATE INDEX IF NOT EXISTS unread_count_i_idx_dialogs ON dialogs(unread_count_i);").stepThis().dispose();
            this.database.executeFast("ALTER TABLE messages ADD COLUMN imp INTEGER default 0").stepThis().dispose();
            this.database.executeFast("CREATE TABLE IF NOT EXISTS messages_holes(uid INTEGER, start INTEGER, end INTEGER, PRIMARY KEY(uid, start));").stepThis().dispose();
            this.database.executeFast("CREATE INDEX IF NOT EXISTS uid_end_messages_holes ON messages_holes(uid, end);").stepThis().dispose();
            this.database.executeFast("PRAGMA user_version = 22").stepThis().dispose();
            i = 22;
        }
        if (i == 22) {
            this.database.executeFast("CREATE TABLE IF NOT EXISTS media_holes_v2(uid INTEGER, type INTEGER, start INTEGER, end INTEGER, PRIMARY KEY(uid, type, start));").stepThis().dispose();
            this.database.executeFast("CREATE INDEX IF NOT EXISTS uid_end_media_holes_v2 ON media_holes_v2(uid, type, end);").stepThis().dispose();
            this.database.executeFast("PRAGMA user_version = 23").stepThis().dispose();
            i = 23;
        }
        if (i == 23 || i == 24) {
            this.database.executeFast("DELETE FROM media_holes_v2 WHERE uid != 0 AND type >= 0 AND start IN (0, 1)").stepThis().dispose();
            this.database.executeFast("PRAGMA user_version = 25").stepThis().dispose();
            i = 25;
        }
        if (i == 25 || i == 26) {
            this.database.executeFast("CREATE TABLE IF NOT EXISTS channel_users_v2(did INTEGER, uid INTEGER, date INTEGER, data BLOB, PRIMARY KEY(did, uid))").stepThis().dispose();
            this.database.executeFast("PRAGMA user_version = 27").stepThis().dispose();
            i = 27;
        }
        if (i == 27) {
            this.database.executeFast("ALTER TABLE web_recent_v3 ADD COLUMN document BLOB default NULL").stepThis().dispose();
            this.database.executeFast("PRAGMA user_version = 28").stepThis().dispose();
            i = 28;
        }
        if (i == 28 || i == 29) {
            this.database.executeFast("DELETE FROM sent_files_v2 WHERE 1").stepThis().dispose();
            this.database.executeFast("DELETE FROM download_queue WHERE 1").stepThis().dispose();
            this.database.executeFast("PRAGMA user_version = 30").stepThis().dispose();
            i = 30;
        }
        if (i == 30) {
            this.database.executeFast("ALTER TABLE chat_settings_v2 ADD COLUMN pinned INTEGER default 0").stepThis().dispose();
            this.database.executeFast("CREATE INDEX IF NOT EXISTS chat_settings_pinned_idx ON chat_settings_v2(uid, pinned) WHERE pinned != 0;").stepThis().dispose();
            this.database.executeFast("CREATE TABLE IF NOT EXISTS users_data(uid INTEGER PRIMARY KEY, about TEXT)").stepThis().dispose();
            this.database.executeFast("PRAGMA user_version = 31").stepThis().dispose();
            i = 31;
        }
        if (i == 31) {
            this.database.executeFast("DROP TABLE IF EXISTS bot_recent;").stepThis().dispose();
            this.database.executeFast("CREATE TABLE IF NOT EXISTS chat_hints(did INTEGER, type INTEGER, rating REAL, date INTEGER, PRIMARY KEY(did, type))").stepThis().dispose();
            this.database.executeFast("CREATE INDEX IF NOT EXISTS chat_hints_rating_idx ON chat_hints(rating);").stepThis().dispose();
            this.database.executeFast("PRAGMA user_version = 32").stepThis().dispose();
            i = 32;
        }
        if (i == 32) {
            this.database.executeFast("DROP INDEX IF EXISTS uid_mid_idx_imp_messages;").stepThis().dispose();
            this.database.executeFast("DROP INDEX IF EXISTS uid_date_mid_imp_idx_messages;").stepThis().dispose();
            this.database.executeFast("PRAGMA user_version = 33").stepThis().dispose();
            i = 33;
        }
        if (i == 33) {
            this.database.executeFast("CREATE TABLE IF NOT EXISTS pending_tasks(id INTEGER PRIMARY KEY, data BLOB);").stepThis().dispose();
            this.database.executeFast("PRAGMA user_version = 34").stepThis().dispose();
            i = 34;
        }
        if (i == 34) {
            this.database.executeFast("CREATE TABLE IF NOT EXISTS stickers_featured(id INTEGER PRIMARY KEY, data BLOB, unread BLOB, date INTEGER, hash INTEGER);").stepThis().dispose();
            this.database.executeFast("PRAGMA user_version = 35").stepThis().dispose();
            i = 35;
        }
        if (i == 35) {
            this.database.executeFast("CREATE TABLE IF NOT EXISTS requested_holes(uid INTEGER, seq_out_start INTEGER, seq_out_end INTEGER, PRIMARY KEY (uid, seq_out_start, seq_out_end));").stepThis().dispose();
            this.database.executeFast("PRAGMA user_version = 36").stepThis().dispose();
            i = 36;
        }
        if (i == 36) {
            this.database.executeFast("ALTER TABLE enc_chats ADD COLUMN in_seq_no INTEGER default 0").stepThis().dispose();
            this.database.executeFast("PRAGMA user_version = 37").stepThis().dispose();
            i = 37;
        }
        if (i == 37) {
            this.database.executeFast("CREATE TABLE IF NOT EXISTS botcache(id TEXT PRIMARY KEY, date INTEGER, data BLOB)").stepThis().dispose();
            this.database.executeFast("CREATE INDEX IF NOT EXISTS botcache_date_idx ON botcache(date);").stepThis().dispose();
            this.database.executeFast("PRAGMA user_version = 38").stepThis().dispose();
            i = 38;
        }
        if (i == 38) {
            this.database.executeFast("ALTER TABLE dialogs ADD COLUMN pinned INTEGER default 0").stepThis().dispose();
            this.database.executeFast("PRAGMA user_version = 39").stepThis().dispose();
            i = 39;
        }
        if (i == 39) {
            this.database.executeFast("ALTER TABLE enc_chats ADD COLUMN admin_id INTEGER default 0").stepThis().dispose();
            this.database.executeFast("PRAGMA user_version = 40").stepThis().dispose();
            i = 40;
        }
        if (i == 40) {
            fixNotificationSettings();
            this.database.executeFast("PRAGMA user_version = 41").stepThis().dispose();
            i = 41;
        }
        if (i == 41) {
            this.database.executeFast("ALTER TABLE messages ADD COLUMN mention INTEGER default 0").stepThis().dispose();
            this.database.executeFast("ALTER TABLE user_contacts_v6 ADD COLUMN imported INTEGER default 0").stepThis().dispose();
            this.database.executeFast("CREATE INDEX IF NOT EXISTS uid_mention_idx_messages ON messages(uid, mention, read_state);").stepThis().dispose();
            this.database.executeFast("PRAGMA user_version = 42").stepThis().dispose();
            i = 42;
        }
        if (i == 42) {
            this.database.executeFast("CREATE TABLE IF NOT EXISTS sharing_locations(uid INTEGER PRIMARY KEY, mid INTEGER, date INTEGER, period INTEGER, message BLOB);").stepThis().dispose();
            this.database.executeFast("PRAGMA user_version = 43").stepThis().dispose();
            i = 43;
        }
        if (i == 43) {
            this.database.executeFast("PRAGMA user_version = 44").stepThis().dispose();
            i = 44;
        }
        if (i == 44) {
            this.database.executeFast("CREATE TABLE IF NOT EXISTS user_contacts_v7(key TEXT PRIMARY KEY, uid INTEGER, fname TEXT, sname TEXT, imported INTEGER)").stepThis().dispose();
            this.database.executeFast("CREATE TABLE IF NOT EXISTS user_phones_v7(key TEXT, phone TEXT, sphone TEXT, deleted INTEGER, PRIMARY KEY (key, phone))").stepThis().dispose();
            this.database.executeFast("CREATE INDEX IF NOT EXISTS sphone_deleted_idx_user_phones ON user_phones_v7(sphone, deleted);").stepThis().dispose();
            this.database.executeFast("PRAGMA user_version = 45").stepThis().dispose();
            i = 45;
        }
        if (i == 45) {
            this.database.executeFast("ALTER TABLE enc_chats ADD COLUMN mtproto_seq INTEGER default 0").stepThis().dispose();
            this.database.executeFast("PRAGMA user_version = 46").stepThis().dispose();
            i = 46;
        }
        if (i == 46) {
            this.database.executeFast("DELETE FROM botcache WHERE 1").stepThis().dispose();
            this.database.executeFast("PRAGMA user_version = 47").stepThis().dispose();
            i = 47;
        }
        if (i == 47) {
            this.database.executeFast("ALTER TABLE dialogs ADD COLUMN flags INTEGER default 0").stepThis().dispose();
            this.database.executeFast("PRAGMA user_version = 48").stepThis().dispose();
            i = 48;
        }
        if (i == 48) {
            this.database.executeFast("CREATE TABLE IF NOT EXISTS unread_push_messages(uid INTEGER, mid INTEGER, random INTEGER, date INTEGER, data BLOB, fm TEXT, name TEXT, uname TEXT, flags INTEGER, PRIMARY KEY(uid, mid))").stepThis().dispose();
            this.database.executeFast("CREATE INDEX IF NOT EXISTS unread_push_messages_idx_date ON unread_push_messages(date);").stepThis().dispose();
            this.database.executeFast("CREATE INDEX IF NOT EXISTS unread_push_messages_idx_random ON unread_push_messages(random);").stepThis().dispose();
            this.database.executeFast("PRAGMA user_version = 49").stepThis().dispose();
            i = 49;
        }
        if (i == 49) {
            this.database.executeFast("CREATE TABLE IF NOT EXISTS user_settings(uid INTEGER PRIMARY KEY, info BLOB, pinned INTEGER)").stepThis().dispose();
            this.database.executeFast("CREATE INDEX IF NOT EXISTS user_settings_pinned_idx ON user_settings(uid, pinned) WHERE pinned != 0;").stepThis().dispose();
            this.database.executeFast("PRAGMA user_version = 50").stepThis().dispose();
            i = 50;
        }
        if (i == 50) {
            this.database.executeFast("DELETE FROM sent_files_v2 WHERE 1").stepThis().dispose();
            this.database.executeFast("ALTER TABLE sent_files_v2 ADD COLUMN parent TEXT").stepThis().dispose();
            this.database.executeFast("DELETE FROM download_queue WHERE 1").stepThis().dispose();
            this.database.executeFast("ALTER TABLE download_queue ADD COLUMN parent TEXT").stepThis().dispose();
            this.database.executeFast("PRAGMA user_version = 51").stepThis().dispose();
            i = 51;
        }
        if (i == 51) {
            this.database.executeFast("ALTER TABLE media_counts_v2 ADD COLUMN old INTEGER").stepThis().dispose();
            this.database.executeFast("PRAGMA user_version = 52").stepThis().dispose();
            i = 52;
        }
        if (i == 52) {
            this.database.executeFast("CREATE TABLE IF NOT EXISTS polls(mid INTEGER PRIMARY KEY, id INTEGER);").stepThis().dispose();
            this.database.executeFast("CREATE INDEX IF NOT EXISTS polls_id ON polls(id);").stepThis().dispose();
            this.database.executeFast("PRAGMA user_version = 53").stepThis().dispose();
            i = 53;
        }
        if (i == 53) {
            this.database.executeFast("ALTER TABLE chat_settings_v2 ADD COLUMN online INTEGER default 0").stepThis().dispose();
            this.database.executeFast("PRAGMA user_version = 54").stepThis().dispose();
            i = 54;
        }
        if (i == 54) {
            this.database.executeFast("DROP TABLE IF EXISTS wallpapers;").stepThis().dispose();
            this.database.executeFast("PRAGMA user_version = 55").stepThis().dispose();
            i = 55;
        }
        if (i == 55) {
            this.database.executeFast("CREATE TABLE IF NOT EXISTS wallpapers2(uid INTEGER PRIMARY KEY, data BLOB, num INTEGER)").stepThis().dispose();
            this.database.executeFast("CREATE INDEX IF NOT EXISTS wallpapers_num ON wallpapers2(num);").stepThis().dispose();
            this.database.executeFast("PRAGMA user_version = 56").stepThis().dispose();
            i = 56;
        }
        if (i == 56 || i == 57) {
            this.database.executeFast("CREATE TABLE IF NOT EXISTS emoji_keywords_v2(lang TEXT, keyword TEXT, emoji TEXT, PRIMARY KEY(lang, keyword, emoji));").stepThis().dispose();
            this.database.executeFast("CREATE TABLE IF NOT EXISTS emoji_keywords_info_v2(lang TEXT PRIMARY KEY, alias TEXT, version INTEGER);").stepThis().dispose();
            this.database.executeFast("PRAGMA user_version = 58").stepThis().dispose();
            i = 58;
        }
        if (i == 58) {
            this.database.executeFast("CREATE INDEX IF NOT EXISTS emoji_keywords_v2_keyword ON emoji_keywords_v2(keyword);").stepThis().dispose();
            this.database.executeFast("ALTER TABLE emoji_keywords_info_v2 ADD COLUMN date INTEGER default 0").stepThis().dispose();
            this.database.executeFast("PRAGMA user_version = 59").stepThis().dispose();
            i = 59;
        }
        if (i == 59) {
            this.database.executeFast("ALTER TABLE dialogs ADD COLUMN folder_id INTEGER default 0").stepThis().dispose();
            this.database.executeFast("ALTER TABLE dialogs ADD COLUMN data BLOB default NULL").stepThis().dispose();
            this.database.executeFast("CREATE INDEX IF NOT EXISTS folder_id_idx_dialogs ON dialogs(folder_id);").stepThis().dispose();
            this.database.executeFast("PRAGMA user_version = 60").stepThis().dispose();
            i = 60;
        }
        if (i == 60) {
            this.database.executeFast("DROP TABLE IF EXISTS channel_admins;").stepThis().dispose();
            this.database.executeFast("DROP TABLE IF EXISTS blocked_users;").stepThis().dispose();
            this.database.executeFast("PRAGMA user_version = 61").stepThis().dispose();
            i = 61;
        }
        if (i == 61) {
            this.database.executeFast("DROP INDEX IF EXISTS send_state_idx_messages;").stepThis().dispose();
            this.database.executeFast("CREATE INDEX IF NOT EXISTS send_state_idx_messages2 ON messages(mid, send_state, date);").stepThis().dispose();
            this.database.executeFast("PRAGMA user_version = 62").stepThis().dispose();
            i = 62;
        }
        if (i == 62) {
            this.database.executeFast("CREATE TABLE IF NOT EXISTS scheduled_messages(mid INTEGER PRIMARY KEY, uid INTEGER, send_state INTEGER, date INTEGER, data BLOB, ttl INTEGER, replydata BLOB)").stepThis().dispose();
            this.database.executeFast("CREATE INDEX IF NOT EXISTS send_state_idx_scheduled_messages ON scheduled_messages(mid, send_state, date);").stepThis().dispose();
            this.database.executeFast("CREATE INDEX IF NOT EXISTS uid_date_idx_scheduled_messages ON scheduled_messages(uid, date);").stepThis().dispose();
            this.database.executeFast("PRAGMA user_version = 63").stepThis().dispose();
            i = 63;
        }
        if (i == 63) {
            this.database.executeFast("DELETE FROM download_queue WHERE 1").stepThis().dispose();
            this.database.executeFast("PRAGMA user_version = 64").stepThis().dispose();
            i = 64;
        }
        if (i == 64) {
            this.database.executeFast("CREATE TABLE IF NOT EXISTS dialog_filter(id INTEGER PRIMARY KEY, ord INTEGER, unread_count INTEGER, flags INTEGER, title TEXT)").stepThis().dispose();
            this.database.executeFast("CREATE TABLE IF NOT EXISTS dialog_filter_ep(id INTEGER, peer INTEGER, PRIMARY KEY (id, peer))").stepThis().dispose();
            this.database.executeFast("PRAGMA user_version = 65").stepThis().dispose();
            i = 65;
        }
        if (i == 65) {
            this.database.executeFast("CREATE INDEX IF NOT EXISTS flags_idx_dialogs ON dialogs(flags);").stepThis().dispose();
            this.database.executeFast("PRAGMA user_version = 66").stepThis().dispose();
            i = 66;
        }
        if (i == 66) {
            this.database.executeFast("CREATE TABLE dialog_filter_pin_v2(id INTEGER, peer INTEGER, pin INTEGER, PRIMARY KEY (id, peer))").stepThis().dispose();
            this.database.executeFast("PRAGMA user_version = 67").stepThis().dispose();
            i = 67;
        }
        if (i == 67) {
            this.database.executeFast("CREATE TABLE IF NOT EXISTS stickers_dice(emoji TEXT PRIMARY KEY, data BLOB, date INTEGER);").stepThis().dispose();
            this.database.executeFast("PRAGMA user_version = 68").stepThis().dispose();
            i = 68;
        }
        if (i == 68) {
            executeNoException("ALTER TABLE messages ADD COLUMN forwards INTEGER default 0");
            this.database.executeFast("PRAGMA user_version = 69").stepThis().dispose();
            i = 69;
        }
        if (i == 69) {
            executeNoException("ALTER TABLE messages ADD COLUMN replies_data BLOB default NULL");
            executeNoException("ALTER TABLE messages ADD COLUMN thread_reply_id INTEGER default 0");
            this.database.executeFast("PRAGMA user_version = 70").stepThis().dispose();
            i = 70;
        }
        if (i == 70) {
            this.database.executeFast("CREATE TABLE IF NOT EXISTS chat_pinned_v2(uid INTEGER, mid INTEGER, data BLOB, PRIMARY KEY (uid, mid));").stepThis().dispose();
            this.database.executeFast("PRAGMA user_version = 71").stepThis().dispose();
            i = 71;
        }
        if (i == 71) {
            executeNoException("ALTER TABLE sharing_locations ADD COLUMN proximity INTEGER default 0");
            this.database.executeFast("PRAGMA user_version = 72").stepThis().dispose();
            i = 72;
        }
        if (i == 72) {
            this.database.executeFast("CREATE TABLE IF NOT EXISTS chat_pinned_count(uid INTEGER PRIMARY KEY, count INTEGER, end INTEGER);").stepThis().dispose();
            this.database.executeFast("PRAGMA user_version = 73").stepThis().dispose();
            i = 73;
        }
        if (i == 73) {
            executeNoException("ALTER TABLE chat_settings_v2 ADD COLUMN inviter INTEGER default 0");
            this.database.executeFast("PRAGMA user_version = 74").stepThis().dispose();
            i = 74;
        }
        if (i == 74) {
            this.database.executeFast("CREATE TABLE IF NOT EXISTS shortcut_widget(id INTEGER, did INTEGER, ord INTEGER, PRIMARY KEY (id, did));").stepThis().dispose();
            this.database.executeFast("CREATE INDEX IF NOT EXISTS shortcut_widget_did ON shortcut_widget(did);").stepThis().dispose();
            this.database.executeFast("PRAGMA user_version = 75").stepThis().dispose();
            i = 75;
        }
        if (i == 75) {
            executeNoException("ALTER TABLE chat_settings_v2 ADD COLUMN links INTEGER default 0");
            this.database.executeFast("PRAGMA user_version = 76").stepThis().dispose();
            i = 76;
        }
        if (i == 76) {
            executeNoException("ALTER TABLE enc_tasks_v2 ADD COLUMN media INTEGER default -1");
            this.database.executeFast("PRAGMA user_version = 77").stepThis().dispose();
            i = 77;
        }
        if (i == 77) {
            this.database.executeFast("DROP TABLE IF EXISTS channel_admins_v2;").stepThis().dispose();
            this.database.executeFast("CREATE TABLE IF NOT EXISTS channel_admins_v3(did INTEGER, uid INTEGER, data BLOB, PRIMARY KEY(did, uid))").stepThis().dispose();
            this.database.executeFast("PRAGMA user_version = 78").stepThis().dispose();
        }
    }

    private void executeNoException(String str) {
        try {
            this.database.executeFast(str).stepThis().dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    private void cleanupInternal(boolean z) {
        this.lastDateValue = 0;
        this.lastSeqValue = 0;
        this.lastPtsValue = 0;
        this.lastQtsValue = 0;
        this.lastSecretVersion = 0;
        this.mainUnreadCount = 0;
        this.archiveUnreadCount = 0;
        this.pendingMainUnreadCount = 0;
        this.pendingArchiveUnreadCount = 0;
        this.dialogFilters.clear();
        this.dialogFiltersMap.clear();
        this.unknownDialogsIds.clear();
        this.lastSavedSeq = 0;
        this.lastSavedPts = 0;
        this.lastSavedDate = 0;
        this.lastSavedQts = 0;
        this.secretPBytes = null;
        this.secretG = 0;
        SQLiteDatabase sQLiteDatabase = this.database;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.close();
            this.database = null;
        }
        if (z) {
            File file = this.cacheFile;
            if (file != null) {
                file.delete();
                this.cacheFile = null;
            }
            File file2 = this.walCacheFile;
            if (file2 != null) {
                file2.delete();
                this.walCacheFile = null;
            }
            File file3 = this.shmCacheFile;
            if (file3 != null) {
                file3.delete();
                this.shmCacheFile = null;
            }
        }
    }

    public void cleanup(final boolean z) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda143
            @Override // java.lang.Runnable
            public final void run() throws Exception {
                this.f$0.lambda$cleanup$3(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$cleanup$3(boolean z) throws Exception {
        cleanupInternal(true);
        openDatabase(1);
        if (z) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda11
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$cleanup$2();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$cleanup$2() {
        getMessagesController().getDifference();
    }

    public void saveSecretParams(final int i, final int i2, final byte[] bArr) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda33
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$saveSecretParams$4(i, i2, bArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveSecretParams$4(int i, int i2, byte[] bArr) {
        try {
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("UPDATE params SET lsv = ?, sg = ?, pbytes = ? WHERE id = 1");
            sQLitePreparedStatementExecuteFast.bindInteger(1, i);
            sQLitePreparedStatementExecuteFast.bindInteger(2, i2);
            NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(bArr != null ? bArr.length : 1);
            if (bArr != null) {
                nativeByteBuffer.writeBytes(bArr);
            }
            sQLitePreparedStatementExecuteFast.bindByteBuffer(3, nativeByteBuffer);
            sQLitePreparedStatementExecuteFast.step();
            sQLitePreparedStatementExecuteFast.dispose();
            nativeByteBuffer.reuse();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    private void fixNotificationSettings() {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$fixNotificationSettings$5();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fixNotificationSettings$5() {
        try {
            LongSparseArray longSparseArray = new LongSparseArray();
            Map<String, ?> all = MessagesController.getNotificationsSettings(this.currentAccount).getAll();
            for (Map.Entry<String, ?> entry : all.entrySet()) {
                String key = entry.getKey();
                if (key.startsWith(NotificationsSettingsFacade.PROPERTY_NOTIFY)) {
                    Integer num = (Integer) entry.getValue();
                    if (num.intValue() == 2 || num.intValue() == 3) {
                        String strReplace = key.replace(NotificationsSettingsFacade.PROPERTY_NOTIFY, io.github.inflationx.calligraphy3.BuildConfig.FLAVOR);
                        long jIntValue = 1;
                        if (num.intValue() != 2) {
                            if (((Integer) all.get(NotificationsSettingsFacade.PROPERTY_NOTIFY_UNTIL + strReplace)) != null) {
                                jIntValue = 1 | (r4.intValue() << 32);
                            }
                        }
                        try {
                            longSparseArray.put(Long.parseLong(strReplace), Long.valueOf(jIntValue));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            try {
                this.database.beginTransaction();
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("REPLACE INTO dialog_settings VALUES(?, ?)");
                for (int i = 0; i < longSparseArray.size(); i++) {
                    sQLitePreparedStatementExecuteFast.requery();
                    sQLitePreparedStatementExecuteFast.bindLong(1, longSparseArray.keyAt(i));
                    sQLitePreparedStatementExecuteFast.bindLong(2, ((Long) longSparseArray.valueAt(i)).longValue());
                    sQLitePreparedStatementExecuteFast.step();
                }
                sQLitePreparedStatementExecuteFast.dispose();
                this.database.commitTransaction();
            } catch (Exception e2) {
                FileLog.e(e2);
            }
        } catch (Throwable th) {
            FileLog.e(th);
        }
    }

    public long createPendingTask(final NativeByteBuffer nativeByteBuffer) {
        if (nativeByteBuffer == null) {
            return 0L;
        }
        final long andAdd = this.lastTaskId.getAndAdd(1L);
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda76
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createPendingTask$6(andAdd, nativeByteBuffer);
            }
        });
        return andAdd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createPendingTask$6(long j, NativeByteBuffer nativeByteBuffer) {
        try {
            try {
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("REPLACE INTO pending_tasks VALUES(?, ?)");
                sQLitePreparedStatementExecuteFast.bindLong(1, j);
                sQLitePreparedStatementExecuteFast.bindByteBuffer(2, nativeByteBuffer);
                sQLitePreparedStatementExecuteFast.step();
                sQLitePreparedStatementExecuteFast.dispose();
            } catch (Exception e) {
                FileLog.e(e);
            }
        } finally {
            nativeByteBuffer.reuse();
        }
    }

    public void removePendingTask(final long j) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda57
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$removePendingTask$7(j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removePendingTask$7(long j) {
        try {
            this.database.executeFast("DELETE FROM pending_tasks WHERE id = " + j).stepThis().dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void saveChannelPts(final int i, final int i2) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda26
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$saveChannelPts$8(i2, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveChannelPts$8(int i, int i2) {
        try {
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("UPDATE dialogs SET pts = ? WHERE did = ?");
            sQLitePreparedStatementExecuteFast.bindInteger(1, i);
            sQLitePreparedStatementExecuteFast.bindInteger(2, -i2);
            sQLitePreparedStatementExecuteFast.step();
            sQLitePreparedStatementExecuteFast.dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: saveDiffParamsInternal, reason: merged with bridge method [inline-methods] */
    public void lambda$saveDiffParams$9(int i, int i2, int i3, int i4) {
        try {
            if (this.lastSavedSeq == i && this.lastSavedPts == i2 && this.lastSavedDate == i3 && this.lastQtsValue == i4) {
                return;
            }
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("UPDATE params SET seq = ?, pts = ?, date = ?, qts = ? WHERE id = 1");
            sQLitePreparedStatementExecuteFast.bindInteger(1, i);
            sQLitePreparedStatementExecuteFast.bindInteger(2, i2);
            sQLitePreparedStatementExecuteFast.bindInteger(3, i3);
            sQLitePreparedStatementExecuteFast.bindInteger(4, i4);
            sQLitePreparedStatementExecuteFast.step();
            sQLitePreparedStatementExecuteFast.dispose();
            this.lastSavedSeq = i;
            this.lastSavedPts = i2;
            this.lastSavedDate = i3;
            this.lastSavedQts = i4;
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void saveDiffParams(final int i, final int i2, final int i3, final int i4) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda28
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$saveDiffParams$9(i, i2, i3, i4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateMutedDialogsFiltersCounters$10() {
        resetAllUnreadCounters(true);
    }

    public void updateMutedDialogsFiltersCounters() {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateMutedDialogsFiltersCounters$10();
            }
        });
    }

    public void setDialogFlags(final long j, final long j2) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda66
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setDialogFlags$11(j, j2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setDialogFlags$11(long j, long j2) {
        try {
            SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized("SELECT flags FROM dialog_settings WHERE did = " + j, new Object[0]);
            int iIntValue = sQLiteCursorQueryFinalized.next() ? sQLiteCursorQueryFinalized.intValue(0) : 0;
            sQLiteCursorQueryFinalized.dispose();
            if (j2 == iIntValue) {
                return;
            }
            this.database.executeFast(String.format(Locale.US, "REPLACE INTO dialog_settings VALUES(%d, %d)", Long.valueOf(j), Long.valueOf(j2))).stepThis().dispose();
            resetAllUnreadCounters(true);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    private static class ReadDialog {
        public int date;
        public int lastMid;
        public int unreadCount;

        private ReadDialog() {
        }
    }

    public void readAllDialogs(final int i) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda15
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$readAllDialogs$13(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$readAllDialogs$13(int i) {
        SQLiteCursor sQLiteCursorQueryFinalized;
        try {
            ArrayList<Integer> arrayList = new ArrayList<>();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            final LongSparseArray longSparseArray = new LongSparseArray();
            if (i >= 0) {
                sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT did, last_mid, unread_count, date FROM dialogs WHERE unread_count > 0 AND folder_id = %1$d", Integer.valueOf(i)), new Object[0]);
            } else {
                sQLiteCursorQueryFinalized = this.database.queryFinalized("SELECT did, last_mid, unread_count, date FROM dialogs WHERE unread_count > 0", new Object[0]);
            }
            while (sQLiteCursorQueryFinalized.next()) {
                long jLongValue = sQLiteCursorQueryFinalized.longValue(0);
                if (!DialogObject.isFolderDialogId(jLongValue)) {
                    ReadDialog readDialog = new ReadDialog();
                    readDialog.lastMid = sQLiteCursorQueryFinalized.intValue(1);
                    readDialog.unreadCount = sQLiteCursorQueryFinalized.intValue(2);
                    readDialog.date = sQLiteCursorQueryFinalized.intValue(3);
                    longSparseArray.put(jLongValue, readDialog);
                    int i2 = (int) jLongValue;
                    int i3 = (int) (jLongValue >> 32);
                    if (i2 != 0) {
                        if (i2 < 0) {
                            int i4 = -i2;
                            if (!arrayList2.contains(Integer.valueOf(i4))) {
                                arrayList2.add(Integer.valueOf(i4));
                            }
                        } else if (!arrayList.contains(Integer.valueOf(i2))) {
                            arrayList.add(Integer.valueOf(i2));
                        }
                    } else if (!arrayList3.contains(Integer.valueOf(i3))) {
                        arrayList3.add(Integer.valueOf(i3));
                    }
                }
            }
            sQLiteCursorQueryFinalized.dispose();
            final ArrayList<TLRPC$User> arrayList4 = new ArrayList<>();
            final ArrayList<TLRPC$Chat> arrayList5 = new ArrayList<>();
            final ArrayList<TLRPC$EncryptedChat> arrayList6 = new ArrayList<>();
            if (!arrayList3.isEmpty()) {
                getEncryptedChatsInternal(TextUtils.join(",", arrayList3), arrayList6, arrayList);
            }
            if (!arrayList.isEmpty()) {
                getUsersInternal(TextUtils.join(",", arrayList), arrayList4);
            }
            if (!arrayList2.isEmpty()) {
                getChatsInternal(TextUtils.join(",", arrayList2), arrayList5);
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda112
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$readAllDialogs$12(arrayList4, arrayList5, arrayList6, longSparseArray);
                }
            });
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$readAllDialogs$12(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, LongSparseArray longSparseArray) {
        getMessagesController().putUsers(arrayList, true);
        getMessagesController().putChats(arrayList2, true);
        getMessagesController().putEncryptedChats(arrayList3, true);
        for (int i = 0; i < longSparseArray.size(); i++) {
            long jKeyAt = longSparseArray.keyAt(i);
            ReadDialog readDialog = (ReadDialog) longSparseArray.valueAt(i);
            MessagesController messagesController = getMessagesController();
            int i2 = readDialog.lastMid;
            messagesController.markDialogAsRead(jKeyAt, i2, i2, readDialog.date, false, 0L, readDialog.unreadCount, true, 0);
        }
    }

    private TLRPC$messages_Dialogs loadDialogsByIds(String str, ArrayList<Integer> arrayList, ArrayList<Integer> arrayList2, ArrayList<Integer> arrayList3) throws Exception {
        TLRPC$Message tLRPC$Message;
        NativeByteBuffer nativeByteBufferByteBufferValue;
        TLRPC$TL_messages_dialogs tLRPC$TL_messages_dialogs = new TLRPC$TL_messages_dialogs();
        ArrayList arrayList4 = new ArrayList();
        LongSparseArray longSparseArray = new LongSparseArray();
        int i = 1;
        SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT d.did, d.last_mid, d.unread_count, d.date, m.data, m.read_state, m.mid, m.send_state, s.flags, m.date, d.pts, d.inbox_max, d.outbox_max, m.replydata, d.pinned, d.unread_count_i, d.flags, d.folder_id, d.data FROM dialogs as d LEFT JOIN messages as m ON d.last_mid = m.mid LEFT JOIN dialog_settings as s ON d.did = s.did WHERE d.did IN (%s) ORDER BY d.pinned DESC, d.date DESC", str), new Object[0]);
        while (sQLiteCursorQueryFinalized.next()) {
            long jLongValue = sQLiteCursorQueryFinalized.longValue(0);
            TLRPC$TL_dialog tLRPC$TL_dialog = new TLRPC$TL_dialog();
            tLRPC$TL_dialog.id = jLongValue;
            tLRPC$TL_dialog.top_message = sQLiteCursorQueryFinalized.intValue(i);
            tLRPC$TL_dialog.unread_count = sQLiteCursorQueryFinalized.intValue(2);
            tLRPC$TL_dialog.last_message_date = sQLiteCursorQueryFinalized.intValue(3);
            int iIntValue = sQLiteCursorQueryFinalized.intValue(10);
            tLRPC$TL_dialog.pts = iIntValue;
            tLRPC$TL_dialog.flags = (iIntValue == 0 || ((int) tLRPC$TL_dialog.id) > 0) ? 0 : 1;
            tLRPC$TL_dialog.read_inbox_max_id = sQLiteCursorQueryFinalized.intValue(11);
            tLRPC$TL_dialog.read_outbox_max_id = sQLiteCursorQueryFinalized.intValue(12);
            int iIntValue2 = sQLiteCursorQueryFinalized.intValue(14);
            tLRPC$TL_dialog.pinnedNum = iIntValue2;
            tLRPC$TL_dialog.pinned = iIntValue2 != 0;
            tLRPC$TL_dialog.unread_mentions_count = sQLiteCursorQueryFinalized.intValue(15);
            tLRPC$TL_dialog.unread_mark = (sQLiteCursorQueryFinalized.intValue(16) & i) != 0;
            long jLongValue2 = sQLiteCursorQueryFinalized.longValue(8);
            TLRPC$TL_peerNotifySettings tLRPC$TL_peerNotifySettings = new TLRPC$TL_peerNotifySettings();
            tLRPC$TL_dialog.notify_settings = tLRPC$TL_peerNotifySettings;
            if ((((int) jLongValue2) & i) != 0) {
                int i2 = (int) (jLongValue2 >> 32);
                tLRPC$TL_peerNotifySettings.mute_until = i2;
                if (i2 == 0) {
                    tLRPC$TL_peerNotifySettings.mute_until = ConnectionsManager.DEFAULT_DATACENTER_ID;
                }
            }
            tLRPC$TL_dialog.folder_id = sQLiteCursorQueryFinalized.intValue(17);
            tLRPC$TL_messages_dialogs.dialogs.add(tLRPC$TL_dialog);
            NativeByteBuffer nativeByteBufferByteBufferValue2 = sQLiteCursorQueryFinalized.byteBufferValue(4);
            if (nativeByteBufferByteBufferValue2 != null) {
                TLRPC$Message tLRPC$MessageTLdeserialize = TLRPC$Message.TLdeserialize(nativeByteBufferByteBufferValue2, nativeByteBufferByteBufferValue2.readInt32(false), false);
                if (tLRPC$MessageTLdeserialize != null) {
                    tLRPC$MessageTLdeserialize.readAttachPath(nativeByteBufferByteBufferValue2, getUserConfig().clientUserId);
                    nativeByteBufferByteBufferValue2.reuse();
                    MessageObject.setUnreadFlags(tLRPC$MessageTLdeserialize, sQLiteCursorQueryFinalized.intValue(5));
                    tLRPC$MessageTLdeserialize.id = sQLiteCursorQueryFinalized.intValue(6);
                    int iIntValue3 = sQLiteCursorQueryFinalized.intValue(9);
                    if (iIntValue3 != 0) {
                        tLRPC$TL_dialog.last_message_date = iIntValue3;
                    }
                    tLRPC$MessageTLdeserialize.send_state = sQLiteCursorQueryFinalized.intValue(7);
                    tLRPC$MessageTLdeserialize.dialog_id = tLRPC$TL_dialog.id;
                    tLRPC$TL_messages_dialogs.messages.add(tLRPC$MessageTLdeserialize);
                    addUsersAndChatsFromMessage(tLRPC$MessageTLdeserialize, arrayList, arrayList2);
                    try {
                        TLRPC$TL_messageReplyHeader tLRPC$TL_messageReplyHeader = tLRPC$MessageTLdeserialize.reply_to;
                        if (tLRPC$TL_messageReplyHeader != null && tLRPC$TL_messageReplyHeader.reply_to_msg_id != 0) {
                            TLRPC$MessageAction tLRPC$MessageAction = tLRPC$MessageTLdeserialize.action;
                            if ((tLRPC$MessageAction instanceof TLRPC$TL_messageActionPinMessage) || (tLRPC$MessageAction instanceof TLRPC$TL_messageActionPaymentSent) || (tLRPC$MessageAction instanceof TLRPC$TL_messageActionGameScore)) {
                                if (!sQLiteCursorQueryFinalized.isNull(13) && (nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized.byteBufferValue(13)) != null) {
                                    TLRPC$Message tLRPC$MessageTLdeserialize2 = TLRPC$Message.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                                    tLRPC$MessageTLdeserialize.replyMessage = tLRPC$MessageTLdeserialize2;
                                    tLRPC$MessageTLdeserialize2.readAttachPath(nativeByteBufferByteBufferValue, getUserConfig().clientUserId);
                                    nativeByteBufferByteBufferValue.reuse();
                                    TLRPC$Message tLRPC$Message2 = tLRPC$MessageTLdeserialize.replyMessage;
                                    if (tLRPC$Message2 != null) {
                                        addUsersAndChatsFromMessage(tLRPC$Message2, arrayList, arrayList2);
                                    }
                                }
                                if (tLRPC$MessageTLdeserialize.replyMessage == null) {
                                    TLRPC$TL_messageReplyHeader tLRPC$TL_messageReplyHeader2 = tLRPC$MessageTLdeserialize.reply_to;
                                    long j = tLRPC$TL_messageReplyHeader2.reply_to_msg_id;
                                    TLRPC$Peer tLRPC$Peer = tLRPC$TL_messageReplyHeader2.reply_to_peer_id;
                                    if (tLRPC$Peer != null) {
                                        int i3 = tLRPC$Peer.channel_id;
                                        if (i3 != 0) {
                                            j |= i3 << 32;
                                            tLRPC$Message = tLRPC$MessageTLdeserialize;
                                        } else {
                                            tLRPC$Message = tLRPC$MessageTLdeserialize;
                                        }
                                    } else {
                                        tLRPC$Message = tLRPC$MessageTLdeserialize;
                                        int i4 = tLRPC$Message.peer_id.channel_id;
                                        if (i4 != 0) {
                                            j |= i4 << 32;
                                        }
                                    }
                                    if (!arrayList4.contains(Long.valueOf(j))) {
                                        arrayList4.add(Long.valueOf(j));
                                    }
                                    longSparseArray.put(tLRPC$TL_dialog.id, tLRPC$Message);
                                }
                            }
                        }
                    } catch (Exception e) {
                        FileLog.e(e);
                    }
                } else {
                    nativeByteBufferByteBufferValue2.reuse();
                }
            }
            long j2 = tLRPC$TL_dialog.id;
            int i5 = (int) j2;
            int i6 = (int) (j2 >> 32);
            if (i5 != 0) {
                if (i5 > 0) {
                    if (!arrayList.contains(Integer.valueOf(i5))) {
                        arrayList.add(Integer.valueOf(i5));
                    }
                } else {
                    int i7 = -i5;
                    if (!arrayList2.contains(Integer.valueOf(i7))) {
                        arrayList2.add(Integer.valueOf(i7));
                    }
                }
            } else if (!arrayList3.contains(Integer.valueOf(i6))) {
                arrayList3.add(Integer.valueOf(i6));
            }
            i = 1;
        }
        sQLiteCursorQueryFinalized.dispose();
        if (!arrayList4.isEmpty()) {
            SQLiteCursor sQLiteCursorQueryFinalized2 = this.database.queryFinalized(String.format(Locale.US, "SELECT data, mid, date, uid FROM messages WHERE mid IN(%s)", TextUtils.join(",", arrayList4)), new Object[0]);
            while (sQLiteCursorQueryFinalized2.next()) {
                NativeByteBuffer nativeByteBufferByteBufferValue3 = sQLiteCursorQueryFinalized2.byteBufferValue(0);
                if (nativeByteBufferByteBufferValue3 != null) {
                    TLRPC$Message tLRPC$MessageTLdeserialize3 = TLRPC$Message.TLdeserialize(nativeByteBufferByteBufferValue3, nativeByteBufferByteBufferValue3.readInt32(false), false);
                    tLRPC$MessageTLdeserialize3.readAttachPath(nativeByteBufferByteBufferValue3, getUserConfig().clientUserId);
                    nativeByteBufferByteBufferValue3.reuse();
                    tLRPC$MessageTLdeserialize3.id = sQLiteCursorQueryFinalized2.intValue(1);
                    tLRPC$MessageTLdeserialize3.date = sQLiteCursorQueryFinalized2.intValue(2);
                    tLRPC$MessageTLdeserialize3.dialog_id = sQLiteCursorQueryFinalized2.longValue(3);
                    addUsersAndChatsFromMessage(tLRPC$MessageTLdeserialize3, arrayList, arrayList2);
                    TLRPC$Message tLRPC$Message3 = (TLRPC$Message) longSparseArray.get(tLRPC$MessageTLdeserialize3.dialog_id);
                    if (tLRPC$Message3 != null) {
                        tLRPC$Message3.replyMessage = tLRPC$MessageTLdeserialize3;
                        tLRPC$MessageTLdeserialize3.dialog_id = tLRPC$Message3.dialog_id;
                    }
                }
            }
            sQLiteCursorQueryFinalized2.dispose();
        }
        return tLRPC$TL_messages_dialogs;
    }

    private void saveDialogFilterInternal(MessagesController.DialogFilter dialogFilter, boolean z, boolean z2) {
        try {
            if (!this.dialogFilters.contains(dialogFilter)) {
                if (z) {
                    this.dialogFilters.add(0, dialogFilter);
                } else {
                    this.dialogFilters.add(dialogFilter);
                }
                this.dialogFiltersMap.put(dialogFilter.id, dialogFilter);
            }
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("REPLACE INTO dialog_filter VALUES(?, ?, ?, ?, ?)");
            sQLitePreparedStatementExecuteFast.bindInteger(1, dialogFilter.id);
            sQLitePreparedStatementExecuteFast.bindInteger(2, dialogFilter.order);
            sQLitePreparedStatementExecuteFast.bindInteger(3, dialogFilter.unreadCount);
            sQLitePreparedStatementExecuteFast.bindInteger(4, dialogFilter.flags);
            sQLitePreparedStatementExecuteFast.bindString(5, dialogFilter.name);
            sQLitePreparedStatementExecuteFast.step();
            sQLitePreparedStatementExecuteFast.dispose();
            if (z2) {
                this.database.executeFast("DELETE FROM dialog_filter_ep WHERE id = " + dialogFilter.id).stepThis().dispose();
                this.database.executeFast("DELETE FROM dialog_filter_pin_v2 WHERE id = " + dialogFilter.id).stepThis().dispose();
                this.database.beginTransaction();
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast2 = this.database.executeFast("REPLACE INTO dialog_filter_pin_v2 VALUES(?, ?, ?)");
                int size = dialogFilter.alwaysShow.size();
                for (int i = 0; i < size; i++) {
                    long jIntValue = dialogFilter.alwaysShow.get(i).intValue();
                    sQLitePreparedStatementExecuteFast2.requery();
                    sQLitePreparedStatementExecuteFast2.bindInteger(1, dialogFilter.id);
                    sQLitePreparedStatementExecuteFast2.bindLong(2, jIntValue);
                    sQLitePreparedStatementExecuteFast2.bindInteger(3, dialogFilter.pinnedDialogs.get(jIntValue, Integer.MIN_VALUE).intValue());
                    sQLitePreparedStatementExecuteFast2.step();
                }
                int size2 = dialogFilter.pinnedDialogs.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    long jKeyAt = dialogFilter.pinnedDialogs.keyAt(i2);
                    if (((int) jKeyAt) == 0) {
                        sQLitePreparedStatementExecuteFast2.requery();
                        sQLitePreparedStatementExecuteFast2.bindInteger(1, dialogFilter.id);
                        sQLitePreparedStatementExecuteFast2.bindLong(2, jKeyAt);
                        sQLitePreparedStatementExecuteFast2.bindInteger(3, dialogFilter.pinnedDialogs.valueAt(i2).intValue());
                        sQLitePreparedStatementExecuteFast2.step();
                    }
                }
                sQLitePreparedStatementExecuteFast2.dispose();
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast3 = this.database.executeFast("REPLACE INTO dialog_filter_ep VALUES(?, ?)");
                int size3 = dialogFilter.neverShow.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    sQLitePreparedStatementExecuteFast3.requery();
                    sQLitePreparedStatementExecuteFast3.bindInteger(1, dialogFilter.id);
                    sQLitePreparedStatementExecuteFast3.bindLong(2, dialogFilter.neverShow.get(i3).intValue());
                    sQLitePreparedStatementExecuteFast3.step();
                }
                sQLitePreparedStatementExecuteFast3.dispose();
                this.database.commitTransaction();
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void checkLoadedRemoteFilters(final TLRPC$Vector tLRPC$Vector) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda137
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$checkLoadedRemoteFilters$15(tLRPC$Vector);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0366 A[Catch: Exception -> 0x05bf, TryCatch #0 {Exception -> 0x05bf, blocks: (B:10:0x0064, B:15:0x0087, B:19:0x008e, B:23:0x0095, B:27:0x009c, B:31:0x00a3, B:35:0x00aa, B:39:0x00b1, B:43:0x00b8, B:45:0x00c6, B:47:0x00d7, B:49:0x00de, B:51:0x00e2, B:53:0x00e8, B:55:0x0107, B:57:0x011b, B:60:0x012c, B:63:0x0142, B:65:0x0158, B:69:0x0175, B:68:0x016a, B:74:0x018e, B:76:0x0197, B:80:0x01af, B:79:0x01a1, B:84:0x01ba, B:87:0x01c1, B:90:0x01c8, B:92:0x01d8, B:94:0x01e8, B:101:0x01fc, B:103:0x0204, B:104:0x0209, B:106:0x0213, B:108:0x021f, B:109:0x023b, B:111:0x0258, B:113:0x025e, B:115:0x0266, B:96:0x01ef, B:100:0x01f6, B:99:0x01f4, B:118:0x0286, B:119:0x028e, B:121:0x0294, B:124:0x02c3, B:126:0x02ca, B:128:0x02d6, B:130:0x02e0, B:132:0x02e8, B:133:0x02eb, B:135:0x02f1, B:152:0x0341, B:139:0x0304, B:143:0x030d, B:145:0x0320, B:147:0x0326, B:148:0x0329, B:150:0x0331, B:142:0x030b, B:153:0x034d, B:88:0x01c4, B:85:0x01bd, B:154:0x035e, B:156:0x0366, B:158:0x0377, B:160:0x037d, B:163:0x038f, B:166:0x0399, B:221:0x04c4, B:169:0x03b0, B:173:0x03d3, B:175:0x03dc, B:177:0x03ea, B:184:0x03fe, B:186:0x0406, B:187:0x040b, B:189:0x042d, B:190:0x0433, B:179:0x03f1, B:183:0x03f8, B:182:0x03f6, B:193:0x044b, B:196:0x0452, B:198:0x0457, B:200:0x045e, B:202:0x0468, B:204:0x0472, B:205:0x0475, B:207:0x047b, B:218:0x04ab, B:208:0x0482, B:212:0x0489, B:214:0x049c, B:215:0x049f, B:217:0x04a5, B:211:0x0487, B:219:0x04ae, B:197:0x0455, B:194:0x044e, B:220:0x04ba, B:222:0x04db, B:225:0x04f2), top: B:255:0x0064 }] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0375  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x037d A[Catch: Exception -> 0x05bf, TryCatch #0 {Exception -> 0x05bf, blocks: (B:10:0x0064, B:15:0x0087, B:19:0x008e, B:23:0x0095, B:27:0x009c, B:31:0x00a3, B:35:0x00aa, B:39:0x00b1, B:43:0x00b8, B:45:0x00c6, B:47:0x00d7, B:49:0x00de, B:51:0x00e2, B:53:0x00e8, B:55:0x0107, B:57:0x011b, B:60:0x012c, B:63:0x0142, B:65:0x0158, B:69:0x0175, B:68:0x016a, B:74:0x018e, B:76:0x0197, B:80:0x01af, B:79:0x01a1, B:84:0x01ba, B:87:0x01c1, B:90:0x01c8, B:92:0x01d8, B:94:0x01e8, B:101:0x01fc, B:103:0x0204, B:104:0x0209, B:106:0x0213, B:108:0x021f, B:109:0x023b, B:111:0x0258, B:113:0x025e, B:115:0x0266, B:96:0x01ef, B:100:0x01f6, B:99:0x01f4, B:118:0x0286, B:119:0x028e, B:121:0x0294, B:124:0x02c3, B:126:0x02ca, B:128:0x02d6, B:130:0x02e0, B:132:0x02e8, B:133:0x02eb, B:135:0x02f1, B:152:0x0341, B:139:0x0304, B:143:0x030d, B:145:0x0320, B:147:0x0326, B:148:0x0329, B:150:0x0331, B:142:0x030b, B:153:0x034d, B:88:0x01c4, B:85:0x01bd, B:154:0x035e, B:156:0x0366, B:158:0x0377, B:160:0x037d, B:163:0x038f, B:166:0x0399, B:221:0x04c4, B:169:0x03b0, B:173:0x03d3, B:175:0x03dc, B:177:0x03ea, B:184:0x03fe, B:186:0x0406, B:187:0x040b, B:189:0x042d, B:190:0x0433, B:179:0x03f1, B:183:0x03f8, B:182:0x03f6, B:193:0x044b, B:196:0x0452, B:198:0x0457, B:200:0x045e, B:202:0x0468, B:204:0x0472, B:205:0x0475, B:207:0x047b, B:218:0x04ab, B:208:0x0482, B:212:0x0489, B:214:0x049c, B:215:0x049f, B:217:0x04a5, B:211:0x0487, B:219:0x04ae, B:197:0x0455, B:194:0x044e, B:220:0x04ba, B:222:0x04db, B:225:0x04f2), top: B:255:0x0064 }] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0389  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x038f A[Catch: Exception -> 0x05bf, TryCatch #0 {Exception -> 0x05bf, blocks: (B:10:0x0064, B:15:0x0087, B:19:0x008e, B:23:0x0095, B:27:0x009c, B:31:0x00a3, B:35:0x00aa, B:39:0x00b1, B:43:0x00b8, B:45:0x00c6, B:47:0x00d7, B:49:0x00de, B:51:0x00e2, B:53:0x00e8, B:55:0x0107, B:57:0x011b, B:60:0x012c, B:63:0x0142, B:65:0x0158, B:69:0x0175, B:68:0x016a, B:74:0x018e, B:76:0x0197, B:80:0x01af, B:79:0x01a1, B:84:0x01ba, B:87:0x01c1, B:90:0x01c8, B:92:0x01d8, B:94:0x01e8, B:101:0x01fc, B:103:0x0204, B:104:0x0209, B:106:0x0213, B:108:0x021f, B:109:0x023b, B:111:0x0258, B:113:0x025e, B:115:0x0266, B:96:0x01ef, B:100:0x01f6, B:99:0x01f4, B:118:0x0286, B:119:0x028e, B:121:0x0294, B:124:0x02c3, B:126:0x02ca, B:128:0x02d6, B:130:0x02e0, B:132:0x02e8, B:133:0x02eb, B:135:0x02f1, B:152:0x0341, B:139:0x0304, B:143:0x030d, B:145:0x0320, B:147:0x0326, B:148:0x0329, B:150:0x0331, B:142:0x030b, B:153:0x034d, B:88:0x01c4, B:85:0x01bd, B:154:0x035e, B:156:0x0366, B:158:0x0377, B:160:0x037d, B:163:0x038f, B:166:0x0399, B:221:0x04c4, B:169:0x03b0, B:173:0x03d3, B:175:0x03dc, B:177:0x03ea, B:184:0x03fe, B:186:0x0406, B:187:0x040b, B:189:0x042d, B:190:0x0433, B:179:0x03f1, B:183:0x03f8, B:182:0x03f6, B:193:0x044b, B:196:0x0452, B:198:0x0457, B:200:0x045e, B:202:0x0468, B:204:0x0472, B:205:0x0475, B:207:0x047b, B:218:0x04ab, B:208:0x0482, B:212:0x0489, B:214:0x049c, B:215:0x049f, B:217:0x04a5, B:211:0x0487, B:219:0x04ae, B:197:0x0455, B:194:0x044e, B:220:0x04ba, B:222:0x04db, B:225:0x04f2), top: B:255:0x0064 }] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0395  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0399 A[Catch: Exception -> 0x05bf, TryCatch #0 {Exception -> 0x05bf, blocks: (B:10:0x0064, B:15:0x0087, B:19:0x008e, B:23:0x0095, B:27:0x009c, B:31:0x00a3, B:35:0x00aa, B:39:0x00b1, B:43:0x00b8, B:45:0x00c6, B:47:0x00d7, B:49:0x00de, B:51:0x00e2, B:53:0x00e8, B:55:0x0107, B:57:0x011b, B:60:0x012c, B:63:0x0142, B:65:0x0158, B:69:0x0175, B:68:0x016a, B:74:0x018e, B:76:0x0197, B:80:0x01af, B:79:0x01a1, B:84:0x01ba, B:87:0x01c1, B:90:0x01c8, B:92:0x01d8, B:94:0x01e8, B:101:0x01fc, B:103:0x0204, B:104:0x0209, B:106:0x0213, B:108:0x021f, B:109:0x023b, B:111:0x0258, B:113:0x025e, B:115:0x0266, B:96:0x01ef, B:100:0x01f6, B:99:0x01f4, B:118:0x0286, B:119:0x028e, B:121:0x0294, B:124:0x02c3, B:126:0x02ca, B:128:0x02d6, B:130:0x02e0, B:132:0x02e8, B:133:0x02eb, B:135:0x02f1, B:152:0x0341, B:139:0x0304, B:143:0x030d, B:145:0x0320, B:147:0x0326, B:148:0x0329, B:150:0x0331, B:142:0x030b, B:153:0x034d, B:88:0x01c4, B:85:0x01bd, B:154:0x035e, B:156:0x0366, B:158:0x0377, B:160:0x037d, B:163:0x038f, B:166:0x0399, B:221:0x04c4, B:169:0x03b0, B:173:0x03d3, B:175:0x03dc, B:177:0x03ea, B:184:0x03fe, B:186:0x0406, B:187:0x040b, B:189:0x042d, B:190:0x0433, B:179:0x03f1, B:183:0x03f8, B:182:0x03f6, B:193:0x044b, B:196:0x0452, B:198:0x0457, B:200:0x045e, B:202:0x0468, B:204:0x0472, B:205:0x0475, B:207:0x047b, B:218:0x04ab, B:208:0x0482, B:212:0x0489, B:214:0x049c, B:215:0x049f, B:217:0x04a5, B:211:0x0487, B:219:0x04ae, B:197:0x0455, B:194:0x044e, B:220:0x04ba, B:222:0x04db, B:225:0x04f2), top: B:255:0x0064 }] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0197 A[Catch: Exception -> 0x05bf, TryCatch #0 {Exception -> 0x05bf, blocks: (B:10:0x0064, B:15:0x0087, B:19:0x008e, B:23:0x0095, B:27:0x009c, B:31:0x00a3, B:35:0x00aa, B:39:0x00b1, B:43:0x00b8, B:45:0x00c6, B:47:0x00d7, B:49:0x00de, B:51:0x00e2, B:53:0x00e8, B:55:0x0107, B:57:0x011b, B:60:0x012c, B:63:0x0142, B:65:0x0158, B:69:0x0175, B:68:0x016a, B:74:0x018e, B:76:0x0197, B:80:0x01af, B:79:0x01a1, B:84:0x01ba, B:87:0x01c1, B:90:0x01c8, B:92:0x01d8, B:94:0x01e8, B:101:0x01fc, B:103:0x0204, B:104:0x0209, B:106:0x0213, B:108:0x021f, B:109:0x023b, B:111:0x0258, B:113:0x025e, B:115:0x0266, B:96:0x01ef, B:100:0x01f6, B:99:0x01f4, B:118:0x0286, B:119:0x028e, B:121:0x0294, B:124:0x02c3, B:126:0x02ca, B:128:0x02d6, B:130:0x02e0, B:132:0x02e8, B:133:0x02eb, B:135:0x02f1, B:152:0x0341, B:139:0x0304, B:143:0x030d, B:145:0x0320, B:147:0x0326, B:148:0x0329, B:150:0x0331, B:142:0x030b, B:153:0x034d, B:88:0x01c4, B:85:0x01bd, B:154:0x035e, B:156:0x0366, B:158:0x0377, B:160:0x037d, B:163:0x038f, B:166:0x0399, B:221:0x04c4, B:169:0x03b0, B:173:0x03d3, B:175:0x03dc, B:177:0x03ea, B:184:0x03fe, B:186:0x0406, B:187:0x040b, B:189:0x042d, B:190:0x0433, B:179:0x03f1, B:183:0x03f8, B:182:0x03f6, B:193:0x044b, B:196:0x0452, B:198:0x0457, B:200:0x045e, B:202:0x0468, B:204:0x0472, B:205:0x0475, B:207:0x047b, B:218:0x04ab, B:208:0x0482, B:212:0x0489, B:214:0x049c, B:215:0x049f, B:217:0x04a5, B:211:0x0487, B:219:0x04ae, B:197:0x0455, B:194:0x044e, B:220:0x04ba, B:222:0x04db, B:225:0x04f2), top: B:255:0x0064 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$checkLoadedRemoteFilters$15(org.rbmain.tgnet.TLRPC$Vector r38) {
        /*
            Method dump skipped, instructions count: 1480
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.MessagesStorage.lambda$checkLoadedRemoteFilters$15(org.rbmain.tgnet.TLRPC$Vector):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$checkLoadedRemoteFilters$14(LongSparseArray longSparseArray, Long l, Long l2) {
        int iIntValue = ((Integer) longSparseArray.get(l.longValue())).intValue();
        int iIntValue2 = ((Integer) longSparseArray.get(l2.longValue())).intValue();
        if (iIntValue > iIntValue2) {
            return 1;
        }
        return iIntValue < iIntValue2 ? -1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: processLoadedFilterPeersInternal, reason: merged with bridge method [inline-methods] */
    public void lambda$processLoadedFilterPeers$17(TLRPC$messages_Dialogs tLRPC$messages_Dialogs, TLRPC$messages_Dialogs tLRPC$messages_Dialogs2, ArrayList<TLRPC$User> arrayList, ArrayList<TLRPC$Chat> arrayList2, ArrayList<MessagesController.DialogFilter> arrayList3, SparseArray<MessagesController.DialogFilter> sparseArray, ArrayList<Integer> arrayList4, HashMap<Integer, HashSet<Integer>> map, HashMap<Integer, HashSet<Integer>> map2, HashSet<Integer> hashSet) {
        putUsersAndChats(arrayList, arrayList2, true, false);
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            lambda$deleteDialogFilter$18(sparseArray.valueAt(i));
        }
        Iterator<Integer> it = hashSet.iterator();
        while (it.hasNext()) {
            MessagesController.DialogFilter dialogFilter = this.dialogFiltersMap.get(it.next().intValue());
            if (dialogFilter != null) {
                dialogFilter.pendingUnreadCount = -1;
            }
        }
        for (Map.Entry<Integer, HashSet<Integer>> entry : map2.entrySet()) {
            MessagesController.DialogFilter dialogFilter2 = this.dialogFiltersMap.get(entry.getKey().intValue());
            if (dialogFilter2 != null) {
                HashSet<Integer> value = entry.getValue();
                dialogFilter2.alwaysShow.removeAll(value);
                dialogFilter2.neverShow.removeAll(value);
            }
        }
        for (Map.Entry<Integer, HashSet<Integer>> entry2 : map.entrySet()) {
            MessagesController.DialogFilter dialogFilter3 = this.dialogFiltersMap.get(entry2.getKey().intValue());
            if (dialogFilter3 != null) {
                Iterator<Integer> it2 = entry2.getValue().iterator();
                while (it2.hasNext()) {
                    dialogFilter3.pinnedDialogs.remove(it2.next().intValue());
                }
            }
        }
        int size2 = arrayList3.size();
        for (int i2 = 0; i2 < size2; i2++) {
            saveDialogFilterInternal(arrayList3.get(i2), false, true);
        }
        int size3 = this.dialogFilters.size();
        boolean z = false;
        for (int i3 = 0; i3 < size3; i3++) {
            MessagesController.DialogFilter dialogFilter4 = this.dialogFilters.get(i3);
            int iIndexOf = arrayList4.indexOf(Integer.valueOf(dialogFilter4.id));
            if (dialogFilter4.order != iIndexOf) {
                dialogFilter4.order = iIndexOf;
                z = true;
            }
        }
        if (z) {
            Collections.sort(this.dialogFilters, new Comparator() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda155
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return MessagesStorage.lambda$processLoadedFilterPeersInternal$16((MessagesController.DialogFilter) obj, (MessagesController.DialogFilter) obj2);
                }
            });
            saveDialogFiltersOrderInternal();
        }
        calcUnreadCounters(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$processLoadedFilterPeersInternal$16(MessagesController.DialogFilter dialogFilter, MessagesController.DialogFilter dialogFilter2) {
        int i = dialogFilter.order;
        int i2 = dialogFilter2.order;
        if (i > i2) {
            return 1;
        }
        return i < i2 ? -1 : 0;
    }

    protected void processLoadedFilterPeers(final TLRPC$messages_Dialogs tLRPC$messages_Dialogs, final TLRPC$messages_Dialogs tLRPC$messages_Dialogs2, final ArrayList<TLRPC$User> arrayList, final ArrayList<TLRPC$Chat> arrayList2, final ArrayList<MessagesController.DialogFilter> arrayList3, final SparseArray<MessagesController.DialogFilter> sparseArray, final ArrayList<Integer> arrayList4, final HashMap<Integer, HashSet<Integer>> map, final HashMap<Integer, HashSet<Integer>> map2, final HashSet<Integer> hashSet) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda140
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processLoadedFilterPeers$17(tLRPC$messages_Dialogs, tLRPC$messages_Dialogs2, arrayList, arrayList2, arrayList3, sparseArray, arrayList4, map, map2, hashSet);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: deleteDialogFilterInternal, reason: merged with bridge method [inline-methods] */
    public void lambda$deleteDialogFilter$18(MessagesController.DialogFilter dialogFilter) {
        try {
            this.dialogFilters.remove(dialogFilter);
            this.dialogFiltersMap.remove(dialogFilter.id);
            this.database.executeFast("DELETE FROM dialog_filter WHERE id = " + dialogFilter.id).stepThis().dispose();
            this.database.executeFast("DELETE FROM dialog_filter_ep WHERE id = " + dialogFilter.id).stepThis().dispose();
            this.database.executeFast("DELETE FROM dialog_filter_pin_v2 WHERE id = " + dialogFilter.id).stepThis().dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void deleteDialogFilter(final MessagesController.DialogFilter dialogFilter) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda118
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$deleteDialogFilter$18(dialogFilter);
            }
        });
    }

    public void saveDialogFiltersOrderInternal() {
        try {
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("UPDATE dialog_filter SET ord = ?, flags = ? WHERE id = ?");
            int size = this.dialogFilters.size();
            for (int i = 0; i < size; i++) {
                MessagesController.DialogFilter dialogFilter = this.dialogFilters.get(i);
                sQLitePreparedStatementExecuteFast.requery();
                sQLitePreparedStatementExecuteFast.bindInteger(1, dialogFilter.order);
                sQLitePreparedStatementExecuteFast.bindInteger(2, dialogFilter.flags);
                sQLitePreparedStatementExecuteFast.bindInteger(3, dialogFilter.id);
                sQLitePreparedStatementExecuteFast.step();
            }
            sQLitePreparedStatementExecuteFast.dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void saveDialogFiltersOrder() {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.saveDialogFiltersOrderInternal();
            }
        });
    }

    public void putWallpapers(final ArrayList<TLRPC$WallPaper> arrayList, final int i) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda42
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$putWallpapers$19(i, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$putWallpapers$19(int i, ArrayList arrayList) {
        SQLitePreparedStatement sQLitePreparedStatementExecuteFast;
        if (i == 1) {
            try {
                this.database.executeFast("DELETE FROM wallpapers2 WHERE 1").stepThis().dispose();
            } catch (Exception e) {
                FileLog.e(e);
                return;
            }
        }
        this.database.beginTransaction();
        if (i != 0) {
            sQLitePreparedStatementExecuteFast = this.database.executeFast("REPLACE INTO wallpapers2 VALUES(?, ?, ?)");
        } else {
            sQLitePreparedStatementExecuteFast = this.database.executeFast("UPDATE wallpapers2 SET data = ? WHERE uid = ?");
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            TLRPC$TL_wallPaper tLRPC$TL_wallPaper = (TLRPC$TL_wallPaper) arrayList.get(i2);
            sQLitePreparedStatementExecuteFast.requery();
            NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(tLRPC$TL_wallPaper.getObjectSize());
            tLRPC$TL_wallPaper.serializeToStream(nativeByteBuffer);
            if (i != 0) {
                sQLitePreparedStatementExecuteFast.bindLong(1, tLRPC$TL_wallPaper.id);
                sQLitePreparedStatementExecuteFast.bindByteBuffer(2, nativeByteBuffer);
                sQLitePreparedStatementExecuteFast.bindInteger(3, i == 2 ? -1 : i2);
            } else {
                sQLitePreparedStatementExecuteFast.bindByteBuffer(1, nativeByteBuffer);
                sQLitePreparedStatementExecuteFast.bindLong(2, tLRPC$TL_wallPaper.id);
            }
            sQLitePreparedStatementExecuteFast.step();
            nativeByteBuffer.reuse();
        }
        sQLitePreparedStatementExecuteFast.dispose();
        this.database.commitTransaction();
    }

    public void getWallpapers() {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getWallpapers$21();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getWallpapers$21() {
        SQLiteCursor sQLiteCursorQueryFinalized = null;
        try {
            try {
                sQLiteCursorQueryFinalized = this.database.queryFinalized("SELECT data FROM wallpapers2 WHERE 1 ORDER BY num ASC", new Object[0]);
                final ArrayList arrayList = new ArrayList();
                while (sQLiteCursorQueryFinalized.next()) {
                    NativeByteBuffer nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized.byteBufferValue(0);
                    if (nativeByteBufferByteBufferValue != null) {
                        TLRPC$TL_wallPaper tLRPC$TL_wallPaper = (TLRPC$TL_wallPaper) TLRPC$WallPaper.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                        nativeByteBufferByteBufferValue.reuse();
                        if (tLRPC$TL_wallPaper != null) {
                            arrayList.add(tLRPC$TL_wallPaper);
                        }
                    }
                }
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        MessagesStorage.lambda$getWallpapers$20(arrayList);
                    }
                });
            } catch (Exception e) {
                FileLog.e(e);
                if (sQLiteCursorQueryFinalized == null) {
                    return;
                }
            }
            sQLiteCursorQueryFinalized.dispose();
        } catch (Throwable th) {
            if (sQLiteCursorQueryFinalized != null) {
                sQLiteCursorQueryFinalized.dispose();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getWallpapers$20(ArrayList arrayList) {
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.wallpapersDidLoad, arrayList);
    }

    public void addRecentLocalFile(final String str, final String str2, final TLRPC$Document tLRPC$Document) {
        if (str == null || str.length() == 0) {
            return;
        }
        if ((str2 == null || str2.length() == 0) && tLRPC$Document == null) {
            return;
        }
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda126
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$addRecentLocalFile$22(tLRPC$Document, str, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addRecentLocalFile$22(TLRPC$Document tLRPC$Document, String str, String str2) {
        try {
            if (tLRPC$Document != null) {
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("UPDATE web_recent_v3 SET document = ? WHERE image_url = ?");
                sQLitePreparedStatementExecuteFast.requery();
                NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(tLRPC$Document.getObjectSize());
                tLRPC$Document.serializeToStream(nativeByteBuffer);
                sQLitePreparedStatementExecuteFast.bindByteBuffer(1, nativeByteBuffer);
                sQLitePreparedStatementExecuteFast.bindString(2, str);
                sQLitePreparedStatementExecuteFast.step();
                sQLitePreparedStatementExecuteFast.dispose();
                nativeByteBuffer.reuse();
            } else {
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast2 = this.database.executeFast("UPDATE web_recent_v3 SET local_url = ? WHERE image_url = ?");
                sQLitePreparedStatementExecuteFast2.requery();
                sQLitePreparedStatementExecuteFast2.bindString(1, str2);
                sQLitePreparedStatementExecuteFast2.bindString(2, str);
                sQLitePreparedStatementExecuteFast2.step();
                sQLitePreparedStatementExecuteFast2.dispose();
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void deleteUserChatHistory(final long j, final int i, final int i2) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda60
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$deleteUserChatHistory$25(j, i2, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cb A[Catch: Exception -> 0x00d4, TRY_LEAVE, TryCatch #1 {Exception -> 0x00d4, blocks: (B:3:0x0006, B:31:0x009d, B:32:0x00a0, B:34:0x00cb), top: B:41:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r12v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$deleteUserChatHistory$25(final long r19, int r21, final int r22) {
        /*
            r18 = this;
            r7 = r18
            r0 = r21
            r8 = r22
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch: java.lang.Exception -> Ld4
            r9.<init>()     // Catch: java.lang.Exception -> Ld4
            org.rbmain.SQLite.SQLiteDatabase r1 = r7.database     // Catch: java.lang.Exception -> Ld4
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Ld4
            r2.<init>()     // Catch: java.lang.Exception -> Ld4
            java.lang.String r3 = "SELECT data FROM messages WHERE uid = "
            r2.append(r3)     // Catch: java.lang.Exception -> Ld4
            r10 = r19
            r2.append(r10)     // Catch: java.lang.Exception -> Ld4
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> Ld4
            r12 = 0
            java.lang.Object[] r3 = new java.lang.Object[r12]     // Catch: java.lang.Exception -> Ld4
            org.rbmain.SQLite.SQLiteCursor r13 = r1.queryFinalized(r2, r3)     // Catch: java.lang.Exception -> Ld4
            java.util.ArrayList r14 = new java.util.ArrayList     // Catch: java.lang.Exception -> Ld4
            r14.<init>()     // Catch: java.lang.Exception -> Ld4
            java.util.ArrayList r15 = new java.util.ArrayList     // Catch: java.lang.Exception -> Ld4
            r15.<init>()     // Catch: java.lang.Exception -> Ld4
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch: java.lang.Exception -> Ld4
            r6.<init>()     // Catch: java.lang.Exception -> Ld4
        L36:
            boolean r1 = r13.next()     // Catch: java.lang.Exception -> L9b
            if (r1 == 0) goto L99
            org.rbmain.tgnet.NativeByteBuffer r5 = r13.byteBufferValue(r12)     // Catch: java.lang.Exception -> L9b
            if (r5 == 0) goto L95
            int r1 = r5.readInt32(r12)     // Catch: java.lang.Exception -> L9b
            org.rbmain.tgnet.TLRPC$Message r2 = org.rbmain.tgnet.TLRPC$Message.TLdeserialize(r5, r1, r12)     // Catch: java.lang.Exception -> L9b
            if (r2 == 0) goto L8c
            org.rbmain.messenger.UserConfig r1 = r18.getUserConfig()     // Catch: java.lang.Exception -> L9b
            int r1 = r1.clientUserId     // Catch: java.lang.Exception -> L9b
            r2.readAttachPath(r5, r1)     // Catch: java.lang.Exception -> L9b
            boolean r1 = org.rbmain.messenger.UserObject.isReplyUser(r19)     // Catch: java.lang.Exception -> L9b
            if (r1 == 0) goto L65
            org.rbmain.tgnet.TLRPC$MessageFwdHeader r1 = r2.fwd_from     // Catch: java.lang.Exception -> L9b
            org.rbmain.tgnet.TLRPC$Peer r1 = r1.from_id     // Catch: java.lang.Exception -> L9b
            int r1 = org.rbmain.messenger.MessageObject.getPeerId(r1)     // Catch: java.lang.Exception -> L9b
            if (r1 == r0) goto L73
        L65:
            int r1 = org.rbmain.messenger.MessageObject.getFromChatId(r2)     // Catch: java.lang.Exception -> L9b
            if (r1 != r0) goto L8c
            long r3 = r2.id     // Catch: java.lang.Exception -> L9b
            r16 = 1
            int r1 = (r3 > r16 ? 1 : (r3 == r16 ? 0 : -1))
            if (r1 == 0) goto L8c
        L73:
            long r3 = r2.id     // Catch: java.lang.Exception -> L9b
            java.lang.Long r1 = java.lang.Long.valueOf(r3)     // Catch: java.lang.Exception -> L9b
            r9.add(r1)     // Catch: java.lang.Exception -> L9b
            r16 = 0
            r1 = r18
            r3 = r14
            r4 = r6
            r17 = r5
            r5 = r15
            r12 = r6
            r6 = r16
            r1.addFilesToDelete(r2, r3, r4, r5, r6)     // Catch: java.lang.Exception -> L93
            goto L8f
        L8c:
            r17 = r5
            r12 = r6
        L8f:
            r17.reuse()     // Catch: java.lang.Exception -> L93
            goto L96
        L93:
            r0 = move-exception
            goto L9d
        L95:
            r12 = r6
        L96:
            r6 = r12
            r12 = 0
            goto L36
        L99:
            r12 = r6
            goto La0
        L9b:
            r0 = move-exception
            r12 = r6
        L9d:
            org.rbmain.messenger.FileLog.e(r0)     // Catch: java.lang.Exception -> Ld4
        La0:
            r13.dispose()     // Catch: java.lang.Exception -> Ld4
            r0 = 1
            r7.deleteFromDownloadQueue(r12, r0)     // Catch: java.lang.Exception -> Ld4
            org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda111 r0 = new org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda111     // Catch: java.lang.Exception -> Ld4
            r1 = r0
            r2 = r18
            r3 = r15
            r4 = r9
            r5 = r19
            r1.<init>()     // Catch: java.lang.Exception -> Ld4
            org.rbmain.messenger.AndroidUtilities.runOnUIThread(r0)     // Catch: java.lang.Exception -> Ld4
            r1 = 0
            r7.lambda$markMessagesAsDeleted$133(r9, r8, r1, r1)     // Catch: java.lang.Exception -> Ld4
            r0 = 0
            r7.lambda$updateDialogsWithDeletedMessages$132(r9, r0, r8)     // Catch: java.lang.Exception -> Ld4
            org.rbmain.messenger.FileLoader r0 = r18.getFileLoader()     // Catch: java.lang.Exception -> Ld4
            r0.deleteFiles(r14, r1)     // Catch: java.lang.Exception -> Ld4
            boolean r0 = r9.isEmpty()     // Catch: java.lang.Exception -> Ld4
            if (r0 != 0) goto Ld8
            org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda104 r0 = new org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda104     // Catch: java.lang.Exception -> Ld4
            r0.<init>()     // Catch: java.lang.Exception -> Ld4
            org.rbmain.messenger.AndroidUtilities.runOnUIThread(r0)     // Catch: java.lang.Exception -> Ld4
            goto Ld8
        Ld4:
            r0 = move-exception
            org.rbmain.messenger.FileLog.e(r0)
        Ld8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.MessagesStorage.lambda$deleteUserChatHistory$25(long, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteUserChatHistory$23(ArrayList arrayList, ArrayList arrayList2, long j) {
        getFileLoader().cancelLoadFiles(arrayList);
        getMessagesController().markDialogMessageAsDeleted(arrayList2, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteUserChatHistory$24(ArrayList arrayList, int i) {
        getNotificationCenter().postNotificationName(NotificationCenter.messagesDeleted, arrayList, Integer.valueOf(i), Boolean.FALSE);
    }

    private boolean addFilesToDelete(TLRPC$Message tLRPC$Message, ArrayList<File> arrayList, ArrayList<Pair<Long, Integer>> arrayList2, ArrayList<String> arrayList3, boolean z) {
        long j;
        int i;
        int i2 = 0;
        if (tLRPC$Message == null) {
            return false;
        }
        TLRPC$Document document = MessageObject.getDocument(tLRPC$Message);
        TLRPC$Photo photo = MessageObject.getPhoto(tLRPC$Message);
        if (MessageObject.isVoiceMessage(tLRPC$Message)) {
            j = document.id;
            i = 2;
        } else {
            if (MessageObject.isStickerMessage(tLRPC$Message) || MessageObject.isAnimatedStickerMessage(tLRPC$Message)) {
                j = document.id;
            } else if (MessageObject.isVideoMessage(tLRPC$Message) || MessageObject.isRoundVideoMessage(tLRPC$Message) || MessageObject.isGifMessage(tLRPC$Message)) {
                j = document.id;
                i = 4;
            } else if (document != null) {
                j = document.id;
                i = 8;
            } else if (photo == null || FileLoader.getClosestPhotoSizeWithSize(photo.sizes, AndroidUtilities.getPhotoSize()) == null) {
                j = 0;
                i = 0;
            } else {
                j = photo.id;
            }
            i = 1;
        }
        if (j != 0) {
            arrayList2.add(new Pair<>(Long.valueOf(j), Integer.valueOf(i)));
        }
        if (photo != null) {
            int size = photo.sizes.size();
            while (i2 < size) {
                TLRPC$PhotoSize tLRPC$PhotoSize = photo.sizes.get(i2);
                String attachFileName = FileLoader.getAttachFileName(tLRPC$PhotoSize);
                if (!TextUtils.isEmpty(attachFileName)) {
                    arrayList3.add(attachFileName);
                }
                File pathToAttach = FileLoader.getPathToAttach(tLRPC$PhotoSize, z);
                if (pathToAttach.toString().length() > 0) {
                    arrayList.add(pathToAttach);
                }
                i2++;
            }
            return true;
        }
        if (document == null) {
            return false;
        }
        String attachFileName2 = FileLoader.getAttachFileName(document);
        if (!TextUtils.isEmpty(attachFileName2)) {
            arrayList3.add(attachFileName2);
        }
        File pathToAttach2 = FileLoader.getPathToAttach(document, z);
        if (pathToAttach2.toString().length() > 0) {
            arrayList.add(pathToAttach2);
        }
        int size2 = document.thumbs.size();
        while (i2 < size2) {
            File pathToAttach3 = FileLoader.getPathToAttach(document.thumbs.get(i2));
            if (pathToAttach3.toString().length() > 0) {
                arrayList.add(pathToAttach3);
            }
            i2++;
        }
        return true;
    }

    public void deleteDialog(final long j, final int i) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda34
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$deleteDialog$28(i, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0276 A[Catch: Exception -> 0x0036, TryCatch #1 {Exception -> 0x0036, blocks: (B:5:0x000d, B:7:0x002c, B:8:0x0030, B:43:0x00fa, B:45:0x011a, B:66:0x0199, B:67:0x019c, B:69:0x0276, B:70:0x027f, B:72:0x028b, B:80:0x0382, B:75:0x029b, B:78:0x0344, B:79:0x0364, B:18:0x0047, B:34:0x00ca, B:35:0x00cd), top: B:86:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x029b A[Catch: Exception -> 0x0036, TryCatch #1 {Exception -> 0x0036, blocks: (B:5:0x000d, B:7:0x002c, B:8:0x0030, B:43:0x00fa, B:45:0x011a, B:66:0x0199, B:67:0x019c, B:69:0x0276, B:70:0x027f, B:72:0x028b, B:80:0x0382, B:75:0x029b, B:78:0x0344, B:79:0x0364, B:18:0x0047, B:34:0x00ca, B:35:0x00cd), top: B:86:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0364 A[Catch: Exception -> 0x0036, TryCatch #1 {Exception -> 0x0036, blocks: (B:5:0x000d, B:7:0x002c, B:8:0x0030, B:43:0x00fa, B:45:0x011a, B:66:0x0199, B:67:0x019c, B:69:0x0276, B:70:0x027f, B:72:0x028b, B:80:0x0382, B:75:0x029b, B:78:0x0344, B:79:0x0364, B:18:0x0047, B:34:0x00ca, B:35:0x00cd), top: B:86:0x000d }] */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v3, types: [boolean, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$deleteDialog$28(int r26, long r27) {
        /*
            Method dump skipped, instructions count: 1124
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.MessagesStorage.lambda$deleteDialog$28(int, long):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteDialog$26(ArrayList arrayList) {
        getFileLoader().cancelLoadFiles(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteDialog$27() {
        getNotificationCenter().postNotificationName(NotificationCenter.needReloadRecentDialogsSearch, new Object[0]);
    }

    public void onDeleteQueryComplete(final long j) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda56
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onDeleteQueryComplete$29(j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onDeleteQueryComplete$29(long j) {
        try {
            this.database.executeFast("DELETE FROM media_counts_v2 WHERE uid = " + j).stepThis().dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void getDialogPhotos(final int i, final int i2, final long j, final int i3) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda61
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getDialogPhotos$31(j, i, i2, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getDialogPhotos$31(final long j, final int i, final int i2, final int i3) {
        SQLiteCursor sQLiteCursorQueryFinalized;
        try {
            if (j != 0) {
                sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT data FROM user_photos WHERE uid = %d AND id < %d ORDER BY rowid ASC LIMIT %d", Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2)), new Object[0]);
            } else {
                sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT data FROM user_photos WHERE uid = %d ORDER BY rowid ASC LIMIT %d", Integer.valueOf(i), Integer.valueOf(i2)), new Object[0]);
            }
            final TLRPC$TL_photos_photos tLRPC$TL_photos_photos = new TLRPC$TL_photos_photos();
            final ArrayList arrayList = new ArrayList();
            while (sQLiteCursorQueryFinalized.next()) {
                NativeByteBuffer nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized.byteBufferValue(0);
                if (nativeByteBufferByteBufferValue != null) {
                    TLRPC$Photo tLRPC$PhotoTLdeserialize = TLRPC$Photo.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                    if (nativeByteBufferByteBufferValue.remaining() > 0) {
                        arrayList.add(TLRPC$Message.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false));
                    } else {
                        arrayList.add(null);
                    }
                    nativeByteBufferByteBufferValue.reuse();
                    tLRPC$TL_photos_photos.photos.add(tLRPC$PhotoTLdeserialize);
                }
            }
            sQLiteCursorQueryFinalized.dispose();
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda141
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$getDialogPhotos$30(tLRPC$TL_photos_photos, arrayList, i, i2, j, i3);
                }
            });
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getDialogPhotos$30(TLRPC$photos_Photos tLRPC$photos_Photos, ArrayList arrayList, int i, int i2, long j, int i3) {
        getMessagesController().processLoadedUserPhotos(tLRPC$photos_Photos, arrayList, i, i2, j, true, i3);
    }

    public void clearUserPhotos(final int i) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda21
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$clearUserPhotos$32(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$clearUserPhotos$32(int i) {
        try {
            this.database.executeFast("DELETE FROM user_photos WHERE uid = " + i).stepThis().dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void clearUserPhoto(final int i, final long j) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda35
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$clearUserPhoto$33(i, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$clearUserPhoto$33(int i, long j) {
        try {
            this.database.executeFast("DELETE FROM user_photos WHERE uid = " + i + " AND id = " + j).stepThis().dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void resetDialogs(final TLRPC$messages_Dialogs tLRPC$messages_Dialogs, final int i, final int i2, final int i3, final int i4, final int i5, final LongSparseArray<TLRPC$Dialog> longSparseArray, final LongSparseArray<MessageObject> longSparseArray2, final TLRPC$Message tLRPC$Message, final int i6) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda139
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$resetDialogs$35(tLRPC$messages_Dialogs, i6, i2, i3, i4, i5, tLRPC$Message, i, longSparseArray, longSparseArray2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$resetDialogs$35(TLRPC$messages_Dialogs tLRPC$messages_Dialogs, int i, int i2, int i3, int i4, int i5, TLRPC$Message tLRPC$Message, int i6, LongSparseArray longSparseArray, LongSparseArray longSparseArray2) {
        int i7;
        int i8;
        long j;
        int i9;
        long j2;
        long j3;
        try {
            ArrayList arrayList = new ArrayList();
            int size = tLRPC$messages_Dialogs.dialogs.size() - i;
            final LongSparseArray longSparseArray3 = new LongSparseArray();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            for (int i10 = i; i10 < tLRPC$messages_Dialogs.dialogs.size(); i10++) {
                arrayList3.add(Long.valueOf(tLRPC$messages_Dialogs.dialogs.get(i10).id));
            }
            SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized("SELECT did, pinned FROM dialogs WHERE 1", new Object[0]);
            int iMax = 0;
            while (sQLiteCursorQueryFinalized.next()) {
                long jLongValue = sQLiteCursorQueryFinalized.longValue(0);
                int iIntValue = sQLiteCursorQueryFinalized.intValue(1);
                int i11 = (int) jLongValue;
                if (i11 != 0) {
                    arrayList.add(Integer.valueOf(i11));
                    if (iIntValue > 0) {
                        iMax = Math.max(iIntValue, iMax);
                        longSparseArray3.put(jLongValue, Integer.valueOf(iIntValue));
                        arrayList2.add(Long.valueOf(jLongValue));
                    }
                }
            }
            Collections.sort(arrayList2, new Comparator() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda154
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return MessagesStorage.lambda$resetDialogs$34(longSparseArray3, (Long) obj, (Long) obj2);
                }
            });
            while (arrayList2.size() < size) {
                arrayList2.add(0, 0L);
            }
            sQLiteCursorQueryFinalized.dispose();
            String str = "(" + TextUtils.join(",", arrayList) + ")";
            this.database.beginTransaction();
            this.database.executeFast("DELETE FROM chat_pinned_count WHERE uid IN " + str).stepThis().dispose();
            this.database.executeFast("DELETE FROM chat_pinned_v2 WHERE uid IN " + str).stepThis().dispose();
            this.database.executeFast("DELETE FROM dialogs WHERE did IN " + str).stepThis().dispose();
            this.database.executeFast("DELETE FROM messages WHERE uid IN " + str).stepThis().dispose();
            this.database.executeFast("DELETE FROM polls WHERE 1").stepThis().dispose();
            this.database.executeFast("DELETE FROM bot_keyboard WHERE uid IN " + str).stepThis().dispose();
            this.database.executeFast("DELETE FROM media_v2 WHERE uid IN " + str).stepThis().dispose();
            this.database.executeFast("DELETE FROM messages_holes WHERE uid IN " + str).stepThis().dispose();
            this.database.executeFast("DELETE FROM media_holes_v2 WHERE uid IN " + str).stepThis().dispose();
            this.database.commitTransaction();
            for (int i12 = 0; i12 < size; i12++) {
                TLRPC$Dialog tLRPC$Dialog = tLRPC$messages_Dialogs.dialogs.get(i + i12);
                if (!(tLRPC$Dialog instanceof TLRPC$TL_dialog) || tLRPC$Dialog.pinned) {
                    int iIndexOf = arrayList2.indexOf(Long.valueOf(tLRPC$Dialog.id));
                    int iIndexOf2 = arrayList3.indexOf(Long.valueOf(tLRPC$Dialog.id));
                    if (iIndexOf != -1 && iIndexOf2 != -1) {
                        if (iIndexOf == iIndexOf2) {
                            Integer num = (Integer) longSparseArray3.get(tLRPC$Dialog.id);
                            if (num != null) {
                                tLRPC$Dialog.pinnedNum = num.intValue();
                            }
                        } else {
                            Integer num2 = (Integer) longSparseArray3.get(((Long) arrayList2.get(iIndexOf2)).longValue());
                            if (num2 != null) {
                                tLRPC$Dialog.pinnedNum = num2.intValue();
                            }
                        }
                    }
                    if (tLRPC$Dialog.pinnedNum == 0) {
                        tLRPC$Dialog.pinnedNum = (size - i12) + iMax;
                    }
                }
            }
            putDialogsInternal(tLRPC$messages_Dialogs, 0);
            lambda$saveDiffParams$9(i2, i3, i4, i5);
            int totalDialogsCount = getUserConfig().getTotalDialogsCount(0);
            getUserConfig().getDialogLoadOffsets(0);
            int size2 = totalDialogsCount + tLRPC$messages_Dialogs.dialogs.size();
            long j4 = tLRPC$Message.id;
            int i13 = tLRPC$Message.date;
            TLRPC$Peer tLRPC$Peer = tLRPC$Message.peer_id;
            int i14 = tLRPC$Peer.channel_id;
            if (i14 != 0) {
                int i15 = 0;
                while (true) {
                    if (i15 >= tLRPC$messages_Dialogs.chats.size()) {
                        j3 = 0;
                        break;
                    }
                    TLRPC$Chat tLRPC$Chat = tLRPC$messages_Dialogs.chats.get(i15);
                    if (tLRPC$Chat.id == i14) {
                        j3 = tLRPC$Chat.access_hash;
                        break;
                    }
                    i15++;
                }
                j = j3;
                i9 = i14;
                i7 = 0;
                i8 = 0;
            } else {
                i7 = tLRPC$Peer.chat_id;
                if (i7 != 0) {
                    int i16 = 0;
                    while (true) {
                        if (i16 >= tLRPC$messages_Dialogs.chats.size()) {
                            j2 = 0;
                            break;
                        }
                        TLRPC$Chat tLRPC$Chat2 = tLRPC$messages_Dialogs.chats.get(i16);
                        if (tLRPC$Chat2.id == i7) {
                            j2 = tLRPC$Chat2.access_hash;
                            break;
                        }
                        i16++;
                    }
                    j = j2;
                    i8 = 0;
                } else {
                    int i17 = tLRPC$Peer.user_id;
                    if (i17 != 0) {
                        for (int i18 = 0; i18 < tLRPC$messages_Dialogs.users.size(); i18++) {
                            TLRPC$User tLRPC$User = tLRPC$messages_Dialogs.users.get(i18);
                            if (tLRPC$User.id == i17) {
                                j = tLRPC$User.access_hash;
                                i9 = 0;
                                i8 = i17;
                                i7 = 0;
                                break;
                            }
                        }
                        i8 = i17;
                        i7 = 0;
                    } else {
                        i7 = 0;
                        i8 = 0;
                    }
                    j = 0;
                }
                i9 = 0;
            }
            int i19 = 0;
            while (i19 < 2) {
                int i20 = i19;
                getUserConfig().setDialogsLoadOffset(i19, j4, i13, i8, i7, i9, j);
                getUserConfig().setTotalDialogsCount(i20, size2);
                i19 = i20 + 1;
            }
            getUserConfig().draftsLoaded = false;
            getUserConfig().saveConfig(false);
            getMessagesController().completeDialogsReset(tLRPC$messages_Dialogs, i6, i2, i3, i4, i5, longSparseArray, longSparseArray2, tLRPC$Message);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$resetDialogs$34(LongSparseArray longSparseArray, Long l, Long l2) {
        Integer num = (Integer) longSparseArray.get(l.longValue());
        Integer num2 = (Integer) longSparseArray.get(l2.longValue());
        if (num.intValue() < num2.intValue()) {
            return 1;
        }
        return num.intValue() > num2.intValue() ? -1 : 0;
    }

    public void putDialogPhotos(final int i, final TLRPC$photos_Photos tLRPC$photos_Photos, final ArrayList<TLRPC$Message> arrayList) {
        if (tLRPC$photos_Photos == null) {
            return;
        }
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda49
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$putDialogPhotos$36(i, tLRPC$photos_Photos, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$putDialogPhotos$36(int i, TLRPC$photos_Photos tLRPC$photos_Photos, ArrayList arrayList) {
        try {
            this.database.executeFast("DELETE FROM user_photos WHERE uid = " + i).stepThis().dispose();
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("REPLACE INTO user_photos VALUES(?, ?, ?)");
            int size = tLRPC$photos_Photos.photos.size();
            for (int i2 = 0; i2 < size; i2++) {
                TLRPC$Photo tLRPC$Photo = tLRPC$photos_Photos.photos.get(i2);
                if (!(tLRPC$Photo instanceof TLRPC$TL_photoEmpty)) {
                    sQLitePreparedStatementExecuteFast.requery();
                    int objectSize = tLRPC$Photo.getObjectSize();
                    if (arrayList != null) {
                        objectSize += ((TLRPC$Message) arrayList.get(i2)).getObjectSize();
                    }
                    NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(objectSize);
                    tLRPC$Photo.serializeToStream(nativeByteBuffer);
                    if (arrayList != null) {
                        ((TLRPC$Message) arrayList.get(i2)).serializeToStream(nativeByteBuffer);
                    }
                    sQLitePreparedStatementExecuteFast.bindInteger(1, i);
                    sQLitePreparedStatementExecuteFast.bindLong(2, tLRPC$Photo.id);
                    sQLitePreparedStatementExecuteFast.bindByteBuffer(3, nativeByteBuffer);
                    sQLitePreparedStatementExecuteFast.step();
                    nativeByteBuffer.reuse();
                }
            }
            sQLitePreparedStatementExecuteFast.dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void emptyMessagesMedia(final ArrayList<Long> arrayList) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda97
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$emptyMessagesMedia$39(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r12v3 */
    public /* synthetic */ void lambda$emptyMessagesMedia$39(ArrayList arrayList) {
        int i;
        int i2;
        try {
            ArrayList<File> arrayList2 = new ArrayList<>();
            final ArrayList<String> arrayList3 = new ArrayList<>();
            ArrayList<Pair<Long, Integer>> arrayList4 = new ArrayList<>();
            final ArrayList arrayList5 = new ArrayList();
            ?? r12 = 0;
            SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT data, mid, date, uid FROM messages WHERE mid IN (%s)", TextUtils.join(",", arrayList)), new Object[0]);
            while (true) {
                i = 3;
                i2 = 2;
                if (!sQLiteCursorQueryFinalized.next()) {
                    break;
                }
                NativeByteBuffer nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized.byteBufferValue(r12);
                if (nativeByteBufferByteBufferValue != 0) {
                    TLRPC$Message tLRPC$MessageTLdeserialize = TLRPC$Message.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(r12), r12);
                    tLRPC$MessageTLdeserialize.readAttachPath(nativeByteBufferByteBufferValue, getUserConfig().clientUserId);
                    nativeByteBufferByteBufferValue.reuse();
                    if (tLRPC$MessageTLdeserialize.media != null && addFilesToDelete(tLRPC$MessageTLdeserialize, arrayList2, arrayList4, arrayList3, true)) {
                        TLRPC$MessageMedia tLRPC$MessageMedia = tLRPC$MessageTLdeserialize.media;
                        if (tLRPC$MessageMedia.document != null) {
                            tLRPC$MessageMedia.document = new TLRPC$TL_documentEmpty();
                        } else if (tLRPC$MessageMedia.photo != null) {
                            tLRPC$MessageMedia.photo = new TLRPC$TL_photoEmpty();
                        }
                        tLRPC$MessageTLdeserialize.media.flags &= -2;
                        tLRPC$MessageTLdeserialize.id = sQLiteCursorQueryFinalized.intValue(1);
                        tLRPC$MessageTLdeserialize.date = sQLiteCursorQueryFinalized.intValue(2);
                        tLRPC$MessageTLdeserialize.dialog_id = sQLiteCursorQueryFinalized.longValue(3);
                        arrayList5.add(tLRPC$MessageTLdeserialize);
                    }
                }
                r12 = 0;
            }
            sQLiteCursorQueryFinalized.dispose();
            deleteFromDownloadQueue(arrayList4, true);
            if (!arrayList5.isEmpty()) {
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("REPLACE INTO messages VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, NULL, ?, ?, ?, ?, ?)");
                int i3 = 0;
                while (i3 < arrayList5.size()) {
                    TLRPC$Message tLRPC$Message = (TLRPC$Message) arrayList5.get(i3);
                    NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(tLRPC$Message.getObjectSize());
                    tLRPC$Message.serializeToStream(nativeByteBuffer);
                    sQLitePreparedStatementExecuteFast.requery();
                    sQLitePreparedStatementExecuteFast.bindLong(1, tLRPC$Message.id);
                    sQLitePreparedStatementExecuteFast.bindLong(i2, tLRPC$Message.dialog_id);
                    sQLitePreparedStatementExecuteFast.bindInteger(i, MessageObject.getUnreadFlags(tLRPC$Message));
                    sQLitePreparedStatementExecuteFast.bindInteger(4, tLRPC$Message.send_state);
                    sQLitePreparedStatementExecuteFast.bindInteger(5, tLRPC$Message.date);
                    sQLitePreparedStatementExecuteFast.bindByteBuffer(6, nativeByteBuffer);
                    sQLitePreparedStatementExecuteFast.bindInteger(7, (MessageObject.isOut(tLRPC$Message) || tLRPC$Message.from_scheduled) ? 1 : 0);
                    sQLitePreparedStatementExecuteFast.bindInteger(8, tLRPC$Message.ttl);
                    if ((tLRPC$Message.flags & 1024) != 0) {
                        sQLitePreparedStatementExecuteFast.bindInteger(9, tLRPC$Message.views);
                    } else {
                        sQLitePreparedStatementExecuteFast.bindInteger(9, getMessageMediaType(tLRPC$Message));
                    }
                    int i4 = tLRPC$Message.stickerVerified;
                    sQLitePreparedStatementExecuteFast.bindInteger(10, i4 == 0 ? 1 : i4 == i2 ? 2 : 0);
                    sQLitePreparedStatementExecuteFast.bindInteger(11, tLRPC$Message.mentioned ? 1 : 0);
                    sQLitePreparedStatementExecuteFast.bindInteger(12, tLRPC$Message.forwards);
                    NativeByteBuffer nativeByteBuffer2 = null;
                    if (tLRPC$Message.replies != null) {
                        nativeByteBuffer2 = new NativeByteBuffer(tLRPC$Message.replies.getObjectSize());
                        tLRPC$Message.replies.serializeToStream(nativeByteBuffer2);
                        sQLitePreparedStatementExecuteFast.bindByteBuffer(13, nativeByteBuffer2);
                    } else {
                        sQLitePreparedStatementExecuteFast.bindNull(13);
                    }
                    TLRPC$TL_messageReplyHeader tLRPC$TL_messageReplyHeader = tLRPC$Message.reply_to;
                    if (tLRPC$TL_messageReplyHeader != null) {
                        long j = tLRPC$TL_messageReplyHeader.reply_to_top_id;
                        if (j == 0) {
                            j = tLRPC$TL_messageReplyHeader.reply_to_msg_id;
                        }
                        sQLitePreparedStatementExecuteFast.bindLong(14, j);
                    } else {
                        sQLitePreparedStatementExecuteFast.bindLong(14, 0L);
                    }
                    sQLitePreparedStatementExecuteFast.step();
                    nativeByteBuffer.reuse();
                    if (nativeByteBuffer2 != null) {
                        nativeByteBuffer2.reuse();
                    }
                    i3++;
                    i = 3;
                    i2 = 2;
                }
                sQLitePreparedStatementExecuteFast.dispose();
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda98
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$emptyMessagesMedia$37(arrayList5);
                    }
                });
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda90
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$emptyMessagesMedia$38(arrayList3);
                }
            });
            getFileLoader().deleteFiles(arrayList2, 0);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$emptyMessagesMedia$37(ArrayList arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            getNotificationCenter().postNotificationName(NotificationCenter.updateMessageMedia, arrayList.get(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$emptyMessagesMedia$38(ArrayList arrayList) {
        getFileLoader().cancelLoadFiles(arrayList);
    }

    public void updateMessagePollResults(final long j, final TLRPC$Poll tLRPC$Poll, final TLRPC$PollResults tLRPC$PollResults) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda77
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateMessagePollResults$40(j, tLRPC$Poll, tLRPC$PollResults);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateMessagePollResults$40(long j, TLRPC$Poll tLRPC$Poll, TLRPC$PollResults tLRPC$PollResults) {
        ArrayList arrayList = null;
        try {
            SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT mid FROM polls WHERE id = %d", Long.valueOf(j)), new Object[0]);
            while (sQLiteCursorQueryFinalized.next()) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(Long.valueOf(sQLiteCursorQueryFinalized.longValue(0)));
            }
            sQLiteCursorQueryFinalized.dispose();
            if (arrayList != null) {
                this.database.beginTransaction();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    Long l = (Long) arrayList.get(i);
                    SQLiteDatabase sQLiteDatabase = this.database;
                    Locale locale = Locale.US;
                    SQLiteCursor sQLiteCursorQueryFinalized2 = sQLiteDatabase.queryFinalized(String.format(locale, "SELECT data FROM messages WHERE mid = %d", l), new Object[0]);
                    if (sQLiteCursorQueryFinalized2.next()) {
                        NativeByteBuffer nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized2.byteBufferValue(0);
                        if (nativeByteBufferByteBufferValue != null) {
                            TLRPC$Message tLRPC$MessageTLdeserialize = TLRPC$Message.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                            tLRPC$MessageTLdeserialize.readAttachPath(nativeByteBufferByteBufferValue, getUserConfig().clientUserId);
                            nativeByteBufferByteBufferValue.reuse();
                            TLRPC$MessageMedia tLRPC$MessageMedia = tLRPC$MessageTLdeserialize.media;
                            if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaPoll) {
                                TLRPC$TL_messageMediaPoll tLRPC$TL_messageMediaPoll = (TLRPC$TL_messageMediaPoll) tLRPC$MessageMedia;
                                if (tLRPC$Poll != null) {
                                    tLRPC$TL_messageMediaPoll.poll = tLRPC$Poll;
                                }
                                if (tLRPC$PollResults != null) {
                                    MessageObject.updatePollResults(tLRPC$TL_messageMediaPoll, tLRPC$PollResults);
                                }
                                SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("UPDATE messages SET data = ? WHERE mid = ?");
                                NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(tLRPC$MessageTLdeserialize.getObjectSize());
                                tLRPC$MessageTLdeserialize.serializeToStream(nativeByteBuffer);
                                sQLitePreparedStatementExecuteFast.requery();
                                sQLitePreparedStatementExecuteFast.bindByteBuffer(1, nativeByteBuffer);
                                sQLitePreparedStatementExecuteFast.bindLong(2, l.longValue());
                                sQLitePreparedStatementExecuteFast.step();
                                nativeByteBuffer.reuse();
                                sQLitePreparedStatementExecuteFast.dispose();
                            }
                        }
                    } else {
                        this.database.executeFast(String.format(locale, "DELETE FROM polls WHERE mid = %d", l)).stepThis().dispose();
                    }
                    sQLiteCursorQueryFinalized2.dispose();
                }
                this.database.commitTransaction();
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void updateMessageReactions(long j, final long j2, final int i, final TLRPC$TL_messageReactions tLRPC$TL_messageReactions) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda65
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateMessageReactions$41(j2, i, tLRPC$TL_messageReactions);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateMessageReactions$41(long j, int i, TLRPC$TL_messageReactions tLRPC$TL_messageReactions) {
        NativeByteBuffer nativeByteBufferByteBufferValue;
        try {
            this.database.beginTransaction();
            if (i != 0) {
                j |= i << 32;
            }
            SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT data FROM messages WHERE mid = %d", Long.valueOf(j)), new Object[0]);
            if (sQLiteCursorQueryFinalized.next() && (nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized.byteBufferValue(0)) != null) {
                TLRPC$Message tLRPC$MessageTLdeserialize = TLRPC$Message.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                if (tLRPC$MessageTLdeserialize != null) {
                    tLRPC$MessageTLdeserialize.readAttachPath(nativeByteBufferByteBufferValue, getUserConfig().clientUserId);
                    nativeByteBufferByteBufferValue.reuse();
                    MessageObject.updateReactions(tLRPC$MessageTLdeserialize, tLRPC$TL_messageReactions);
                    SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("UPDATE messages SET data = ? WHERE mid = ?");
                    NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(tLRPC$MessageTLdeserialize.getObjectSize());
                    tLRPC$MessageTLdeserialize.serializeToStream(nativeByteBuffer);
                    sQLitePreparedStatementExecuteFast.requery();
                    sQLitePreparedStatementExecuteFast.bindByteBuffer(1, nativeByteBuffer);
                    sQLitePreparedStatementExecuteFast.bindLong(2, j);
                    sQLitePreparedStatementExecuteFast.step();
                    nativeByteBuffer.reuse();
                    sQLitePreparedStatementExecuteFast.dispose();
                } else {
                    nativeByteBufferByteBufferValue.reuse();
                }
            }
            sQLiteCursorQueryFinalized.dispose();
            this.database.commitTransaction();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void getNewTask(final ArrayList<Long> arrayList, final int i) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda102
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getNewTask$42(arrayList, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getNewTask$42(ArrayList arrayList, int i) {
        boolean z;
        String strJoin;
        try {
            if (arrayList != null) {
                if (i != 0) {
                    StringBuilder sb = new StringBuilder();
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        long jLongValue = ((Long) arrayList.get(i2)).longValue() | (i << 32);
                        if (sb.length() > 0) {
                            sb.append(",");
                        }
                        sb.append(jLongValue);
                    }
                    strJoin = sb.toString();
                } else {
                    strJoin = TextUtils.join(",", arrayList);
                }
                this.database.executeFast(String.format(Locale.US, "DELETE FROM enc_tasks_v2 WHERE mid IN(%s)", strJoin)).stepThis().dispose();
            }
            ArrayList<Long> arrayList2 = null;
            SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized("SELECT mid, date, media FROM enc_tasks_v2 WHERE date = (SELECT min(date) FROM enc_tasks_v2)", new Object[0]);
            int i3 = -1;
            int i4 = 0;
            boolean z2 = false;
            while (sQLiteCursorQueryFinalized.next()) {
                long jLongValue2 = sQLiteCursorQueryFinalized.longValue(0);
                if (i3 == -1 && (i3 = (int) (jLongValue2 >> 32)) < 0) {
                    i3 = 0;
                }
                int iIntValue = sQLiteCursorQueryFinalized.intValue(1);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>();
                }
                arrayList2.add(Long.valueOf(jLongValue2));
                int iIntValue2 = sQLiteCursorQueryFinalized.intValue(2);
                if (iIntValue2 == -1) {
                    z = jLongValue2 > 0;
                } else if (iIntValue2 != 0) {
                }
                z2 = z;
                i4 = iIntValue;
            }
            sQLiteCursorQueryFinalized.dispose();
            getMessagesController().processLoadedDeleteTask(i4, arrayList2, z2, i3);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void markMentionMessageAsRead(final long j, final int i, final long j2) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda63
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$markMentionMessageAsRead$43(j, i, j2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$markMentionMessageAsRead$43(long j, int i, long j2) {
        if (i != 0) {
            j |= i << 32;
        }
        try {
            SQLiteDatabase sQLiteDatabase = this.database;
            Locale locale = Locale.US;
            sQLiteDatabase.executeFast(String.format(locale, "UPDATE messages SET read_state = read_state | 2 WHERE mid = %d", Long.valueOf(j))).stepThis().dispose();
            SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized("SELECT unread_count_i FROM dialogs WHERE did = " + j2, new Object[0]);
            int iMax = sQLiteCursorQueryFinalized.next() ? Math.max(0, sQLiteCursorQueryFinalized.intValue(0) - 1) : 0;
            sQLiteCursorQueryFinalized.dispose();
            this.database.executeFast(String.format(locale, "UPDATE dialogs SET unread_count_i = %d WHERE did = %d", Integer.valueOf(iMax), Long.valueOf(j2))).stepThis().dispose();
            LongSparseArray<Integer> longSparseArray = new LongSparseArray<>(1);
            longSparseArray.put(j2, Integer.valueOf(iMax));
            if (iMax == 0) {
                updateFiltersReadCounter(null, longSparseArray, true);
            }
            getMessagesController().processDialogsUpdateRead(null, longSparseArray);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void markMessageAsMention(final long j) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda54
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$markMessageAsMention$44(j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$markMessageAsMention$44(long j) {
        try {
            this.database.executeFast(String.format(Locale.US, "UPDATE messages SET mention = 1, read_state = read_state & ~2 WHERE mid = %d", Long.valueOf(j))).stepThis().dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void resetMentionsCount(final long j, final int i) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda58
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$resetMentionsCount$45(j, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$resetMentionsCount$45(long j, int i) {
        try {
            SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized("SELECT unread_count_i FROM dialogs WHERE did = " + j, new Object[0]);
            int iIntValue = sQLiteCursorQueryFinalized.next() ? sQLiteCursorQueryFinalized.intValue(0) : 0;
            sQLiteCursorQueryFinalized.dispose();
            if (iIntValue == 0 && i == 0) {
                return;
            }
            if (i == 0) {
                this.database.executeFast(String.format(Locale.US, "UPDATE messages SET read_state = read_state | 2 WHERE uid = %d AND mention = 1 AND read_state IN(0, 1)", Long.valueOf(j))).stepThis().dispose();
            }
            this.database.executeFast(String.format(Locale.US, "UPDATE dialogs SET unread_count_i = %d WHERE did = %d", Integer.valueOf(i), Long.valueOf(j))).stepThis().dispose();
            LongSparseArray<Integer> longSparseArray = new LongSparseArray<>(1);
            longSparseArray.put(j, Integer.valueOf(i));
            getMessagesController().processDialogsUpdateRead(null, longSparseArray);
            if (i == 0) {
                updateFiltersReadCounter(null, longSparseArray, true);
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void createTaskForMid(final long j, final int i, final int i2, final int i3, final int i4, final boolean z) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda30
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createTaskForMid$47(i2, i3, i4, j, i, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createTaskForMid$47(int i, int i2, int i3, long j, int i4, final boolean z) {
        try {
            int iMax = Math.max(i, i2) + i3;
            SparseArray<ArrayList<Long>> sparseArray = new SparseArray<>();
            final ArrayList<Long> arrayList = new ArrayList<>();
            if (i4 != 0) {
                j |= i4 << 32;
            }
            arrayList.add(Long.valueOf(j));
            sparseArray.put(iMax, arrayList);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda146
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$createTaskForMid$46(z, arrayList);
                }
            });
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("REPLACE INTO enc_tasks_v2 VALUES(?, ?, ?)");
            for (int i5 = 0; i5 < sparseArray.size(); i5++) {
                int iKeyAt = sparseArray.keyAt(i5);
                ArrayList<Long> arrayList2 = sparseArray.get(iKeyAt);
                for (int i6 = 0; i6 < arrayList2.size(); i6++) {
                    sQLitePreparedStatementExecuteFast.requery();
                    sQLitePreparedStatementExecuteFast.bindLong(1, arrayList2.get(i6).longValue());
                    sQLitePreparedStatementExecuteFast.bindInteger(2, iKeyAt);
                    sQLitePreparedStatementExecuteFast.bindInteger(3, 1);
                    sQLitePreparedStatementExecuteFast.step();
                }
            }
            sQLitePreparedStatementExecuteFast.dispose();
            this.database.executeFast(String.format(Locale.US, "UPDATE messages SET ttl = 0 WHERE mid = %d", Long.valueOf(j))).stepThis().dispose();
            getMessagesController().didAddedNewTask(iMax, sparseArray);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createTaskForMid$46(boolean z, ArrayList arrayList) {
        if (!z) {
            markMessagesContentAsRead(arrayList, 0);
        }
        getNotificationCenter().postNotificationName(NotificationCenter.messagesReadContent, arrayList);
    }

    public void createTaskForSecretChat(final int i, final int i2, final int i3, final int i4, final ArrayList<Long> arrayList) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda106
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createTaskForSecretChat$49(arrayList, i, i4, i2, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createTaskForSecretChat$49(ArrayList arrayList, int i, int i2, int i3, int i4) {
        SparseArray<ArrayList<Long>> sparseArray;
        SQLiteCursor sQLiteCursorQueryFinalized;
        try {
            SparseArray<ArrayList<Long>> sparseArray2 = new SparseArray<>();
            final ArrayList arrayList2 = new ArrayList();
            StringBuilder sb = new StringBuilder();
            if (arrayList == null) {
                sparseArray = sparseArray2;
                sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT mid, ttl FROM messages WHERE uid = %d AND out = %d AND read_state > 0 AND ttl > 0 AND date <= %d AND send_state = 0 AND media != 1", Long.valueOf(i << 32), Integer.valueOf(i2), Integer.valueOf(i3)), new Object[0]);
            } else {
                sparseArray = sparseArray2;
                sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT m.mid, m.ttl FROM messages as m INNER JOIN randoms as r ON m.mid = r.mid WHERE r.random_id IN (%s)", TextUtils.join(",", arrayList)), new Object[0]);
            }
            int iMin = ConnectionsManager.DEFAULT_DATACENTER_ID;
            while (sQLiteCursorQueryFinalized.next()) {
                int iIntValue = sQLiteCursorQueryFinalized.intValue(1);
                long jIntValue = sQLiteCursorQueryFinalized.intValue(0);
                if (arrayList != null) {
                    arrayList2.add(Long.valueOf(jIntValue));
                }
                if (iIntValue > 0) {
                    int iMax = Math.max(i3, i4) + iIntValue;
                    iMin = Math.min(iMin, iMax);
                    SparseArray<ArrayList<Long>> sparseArray3 = sparseArray;
                    ArrayList<Long> arrayList3 = sparseArray3.get(iMax);
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList<>();
                        sparseArray3.put(iMax, arrayList3);
                    }
                    if (sb.length() != 0) {
                        sb.append(",");
                    }
                    sb.append(jIntValue);
                    arrayList3.add(Long.valueOf(jIntValue));
                    sparseArray = sparseArray3;
                }
            }
            SparseArray<ArrayList<Long>> sparseArray4 = sparseArray;
            sQLiteCursorQueryFinalized.dispose();
            if (arrayList != null) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda91
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$createTaskForSecretChat$48(arrayList2);
                    }
                });
            }
            if (sparseArray4.size() != 0) {
                this.database.beginTransaction();
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("REPLACE INTO enc_tasks_v2 VALUES(?, ?, ?)");
                for (int i5 = 0; i5 < sparseArray4.size(); i5++) {
                    int iKeyAt = sparseArray4.keyAt(i5);
                    ArrayList<Long> arrayList4 = sparseArray4.get(iKeyAt);
                    for (int i6 = 0; i6 < arrayList4.size(); i6++) {
                        sQLitePreparedStatementExecuteFast.requery();
                        sQLitePreparedStatementExecuteFast.bindLong(1, arrayList4.get(i6).longValue());
                        sQLitePreparedStatementExecuteFast.bindInteger(2, iKeyAt);
                        sQLitePreparedStatementExecuteFast.bindInteger(3, 0);
                        sQLitePreparedStatementExecuteFast.step();
                    }
                }
                sQLitePreparedStatementExecuteFast.dispose();
                this.database.commitTransaction();
                this.database.executeFast(String.format(Locale.US, "UPDATE messages SET ttl = 0 WHERE mid IN(%s)", sb.toString())).stepThis().dispose();
                getMessagesController().didAddedNewTask(iMin, sparseArray4);
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createTaskForSecretChat$48(ArrayList arrayList) {
        markMessagesContentAsRead(arrayList, 0);
        getNotificationCenter().postNotificationName(NotificationCenter.messagesReadContent, arrayList);
    }

    private static boolean isEmpty(SparseArray<?> sparseArray) {
        return sparseArray == null || sparseArray.size() == 0;
    }

    private static boolean isEmpty(SparseLongArray sparseLongArray) {
        return sparseLongArray == null || sparseLongArray.size() == 0;
    }

    private static boolean isEmpty(List<?> list) {
        return list == null || list.isEmpty();
    }

    private static boolean isEmpty(SparseIntArray sparseIntArray) {
        return sparseIntArray == null || sparseIntArray.size() == 0;
    }

    private static boolean isEmpty(LongSparseArray<?> longSparseArray) {
        return longSparseArray == null || longSparseArray.size() == 0;
    }

    public void updateDialogsWithReadMessages(final SparseLongArray sparseLongArray, final SparseLongArray sparseLongArray2, final ArrayList<Long> arrayList, boolean z) {
        if (isEmpty(sparseLongArray) && isEmpty(sparseLongArray2) && isEmpty(arrayList)) {
            return;
        }
        if (z) {
            this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda120
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$updateDialogsWithReadMessages$50(sparseLongArray, sparseLongArray2, arrayList);
                }
            });
        } else {
            updateDialogsWithReadMessagesInternal(null, sparseLongArray, sparseLongArray2, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateDialogsWithReadMessages$50(SparseLongArray sparseLongArray, SparseLongArray sparseLongArray2, ArrayList arrayList) {
        updateDialogsWithReadMessagesInternal(null, sparseLongArray, sparseLongArray2, arrayList);
    }

    public void updateChatParticipants(final TLRPC$ChatParticipants tLRPC$ChatParticipants) {
        if (tLRPC$ChatParticipants == null) {
            return;
        }
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda125
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateChatParticipants$52(tLRPC$ChatParticipants);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateChatParticipants$52(TLRPC$ChatParticipants tLRPC$ChatParticipants) {
        NativeByteBuffer nativeByteBufferByteBufferValue;
        try {
            SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized("SELECT info, pinned, online, inviter FROM chat_settings_v2 WHERE uid = " + tLRPC$ChatParticipants.chat_id, new Object[0]);
            final TLRPC$ChatFull tLRPC$ChatFullTLdeserialize = null;
            new ArrayList();
            if (sQLiteCursorQueryFinalized.next() && (nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized.byteBufferValue(0)) != null) {
                tLRPC$ChatFullTLdeserialize = TLRPC$ChatFull.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                nativeByteBufferByteBufferValue.reuse();
                tLRPC$ChatFullTLdeserialize.pinned_msg_id = sQLiteCursorQueryFinalized.intValue(1);
                tLRPC$ChatFullTLdeserialize.online_count = sQLiteCursorQueryFinalized.intValue(2);
                tLRPC$ChatFullTLdeserialize.inviterId = sQLiteCursorQueryFinalized.intValue(3);
            }
            sQLiteCursorQueryFinalized.dispose();
            if (tLRPC$ChatFullTLdeserialize instanceof TLRPC$TL_chatFull) {
                tLRPC$ChatFullTLdeserialize.participants = tLRPC$ChatParticipants;
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda122
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$updateChatParticipants$51(tLRPC$ChatFullTLdeserialize);
                    }
                });
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("REPLACE INTO chat_settings_v2 VALUES(?, ?, ?, ?, ?, ?)");
                NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(tLRPC$ChatFullTLdeserialize.getObjectSize());
                tLRPC$ChatFullTLdeserialize.serializeToStream(nativeByteBuffer);
                sQLitePreparedStatementExecuteFast.bindInteger(1, tLRPC$ChatFullTLdeserialize.id);
                sQLitePreparedStatementExecuteFast.bindByteBuffer(2, nativeByteBuffer);
                sQLitePreparedStatementExecuteFast.bindLong(3, tLRPC$ChatFullTLdeserialize.pinned_msg_id);
                sQLitePreparedStatementExecuteFast.bindInteger(4, tLRPC$ChatFullTLdeserialize.online_count);
                sQLitePreparedStatementExecuteFast.bindInteger(5, tLRPC$ChatFullTLdeserialize.inviterId);
                sQLitePreparedStatementExecuteFast.bindInteger(6, tLRPC$ChatFullTLdeserialize.invitesCount);
                sQLitePreparedStatementExecuteFast.step();
                sQLitePreparedStatementExecuteFast.dispose();
                nativeByteBuffer.reuse();
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateChatParticipants$51(TLRPC$ChatFull tLRPC$ChatFull) {
        NotificationCenter notificationCenter = getNotificationCenter();
        int i = NotificationCenter.chatInfoDidLoad;
        Boolean bool = Boolean.FALSE;
        notificationCenter.postNotificationName(i, tLRPC$ChatFull, 0, bool, bool);
    }

    public void loadChannelAdmins(final int i) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadChannelAdmins$53(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadChannelAdmins$53(int i) {
        try {
            SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized("SELECT uid, data FROM channel_admins_v3 WHERE did = " + i, new Object[0]);
            SparseArray<TLRPC$ChannelParticipant> sparseArray = new SparseArray<>();
            while (sQLiteCursorQueryFinalized.next()) {
                NativeByteBuffer nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized.byteBufferValue(1);
                if (nativeByteBufferByteBufferValue != null) {
                    TLRPC$ChannelParticipant tLRPC$ChannelParticipantTLdeserialize = TLRPC$ChannelParticipant.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                    nativeByteBufferByteBufferValue.reuse();
                    if (tLRPC$ChannelParticipantTLdeserialize != null) {
                        sparseArray.put(sQLiteCursorQueryFinalized.intValue(0), tLRPC$ChannelParticipantTLdeserialize);
                    }
                }
            }
            sQLiteCursorQueryFinalized.dispose();
            getMessagesController().processLoadedChannelAdmins(sparseArray, i, true);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void putChannelAdmins(final int i, final SparseArray<TLRPC$ChannelParticipant> sparseArray) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda40
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$putChannelAdmins$54(i, sparseArray);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$putChannelAdmins$54(int i, SparseArray sparseArray) {
        try {
            this.database.executeFast("DELETE FROM channel_admins_v3 WHERE did = " + i).stepThis().dispose();
            this.database.beginTransaction();
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("REPLACE INTO channel_admins_v3 VALUES(?, ?, ?)");
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                sQLitePreparedStatementExecuteFast.requery();
                sQLitePreparedStatementExecuteFast.bindInteger(1, i);
                sQLitePreparedStatementExecuteFast.bindInteger(2, sparseArray.keyAt(i2));
                TLRPC$ChannelParticipant tLRPC$ChannelParticipant = (TLRPC$ChannelParticipant) sparseArray.valueAt(i2);
                NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(tLRPC$ChannelParticipant.getObjectSize());
                tLRPC$ChannelParticipant.serializeToStream(nativeByteBuffer);
                sQLitePreparedStatementExecuteFast.bindByteBuffer(3, nativeByteBuffer);
                sQLitePreparedStatementExecuteFast.step();
                nativeByteBuffer.reuse();
            }
            sQLitePreparedStatementExecuteFast.dispose();
            this.database.commitTransaction();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void updateChannelUsers(final int i, final ArrayList<TLRPC$ChannelParticipant> arrayList) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda43
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateChannelUsers$55(i, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateChannelUsers$55(int i, ArrayList arrayList) {
        long j = -i;
        try {
            this.database.executeFast("DELETE FROM channel_users_v2 WHERE did = " + j).stepThis().dispose();
            this.database.beginTransaction();
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("REPLACE INTO channel_users_v2 VALUES(?, ?, ?, ?)");
            int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                TLRPC$ChannelParticipant tLRPC$ChannelParticipant = (TLRPC$ChannelParticipant) arrayList.get(i2);
                sQLitePreparedStatementExecuteFast.requery();
                sQLitePreparedStatementExecuteFast.bindLong(1, j);
                sQLitePreparedStatementExecuteFast.bindInteger(2, MessageObject.getPeerId(tLRPC$ChannelParticipant.peer));
                sQLitePreparedStatementExecuteFast.bindInteger(3, iCurrentTimeMillis);
                NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(tLRPC$ChannelParticipant.getObjectSize());
                tLRPC$ChannelParticipant.serializeToStream(nativeByteBuffer);
                sQLitePreparedStatementExecuteFast.bindByteBuffer(4, nativeByteBuffer);
                sQLitePreparedStatementExecuteFast.step();
                nativeByteBuffer.reuse();
                iCurrentTimeMillis--;
            }
            sQLitePreparedStatementExecuteFast.dispose();
            this.database.commitTransaction();
            loadChatInfo(i, true, null, false, true);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void saveBotCache(final String str, final TLObject tLObject) {
        if (tLObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda121
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$saveBotCache$56(tLObject, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveBotCache$56(TLObject tLObject, String str) {
        int i;
        try {
            int currentTime = getConnectionsManager().getCurrentTime();
            if (tLObject instanceof TLRPC$TL_messages_botCallbackAnswer) {
                i = ((TLRPC$TL_messages_botCallbackAnswer) tLObject).cache_time;
            } else {
                if (tLObject instanceof TLRPC$TL_messages_botResults) {
                    i = ((TLRPC$TL_messages_botResults) tLObject).cache_time;
                }
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("REPLACE INTO botcache VALUES(?, ?, ?)");
                NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(tLObject.getObjectSize());
                tLObject.serializeToStream(nativeByteBuffer);
                sQLitePreparedStatementExecuteFast.bindString(1, str);
                sQLitePreparedStatementExecuteFast.bindInteger(2, currentTime);
                sQLitePreparedStatementExecuteFast.bindByteBuffer(3, nativeByteBuffer);
                sQLitePreparedStatementExecuteFast.step();
                sQLitePreparedStatementExecuteFast.dispose();
                nativeByteBuffer.reuse();
            }
            currentTime += i;
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast2 = this.database.executeFast("REPLACE INTO botcache VALUES(?, ?, ?)");
            NativeByteBuffer nativeByteBuffer2 = new NativeByteBuffer(tLObject.getObjectSize());
            tLObject.serializeToStream(nativeByteBuffer2);
            sQLitePreparedStatementExecuteFast2.bindString(1, str);
            sQLitePreparedStatementExecuteFast2.bindInteger(2, currentTime);
            sQLitePreparedStatementExecuteFast2.bindByteBuffer(3, nativeByteBuffer2);
            sQLitePreparedStatementExecuteFast2.step();
            sQLitePreparedStatementExecuteFast2.dispose();
            nativeByteBuffer2.reuse();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void getBotCache(final String str, final RequestDelegate requestDelegate) {
        if (str == null || requestDelegate == null) {
            return;
        }
        final int currentTime = getConnectionsManager().getCurrentTime();
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda41
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f$0.lambda$getBotCache$57(currentTime, str, requestDelegate);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$getBotCache$57(int r5, java.lang.String r6, org.rbmain.tgnet.RequestDelegate r7) throws java.lang.Throwable {
        /*
            r4 = this;
            r0 = 0
            org.rbmain.SQLite.SQLiteDatabase r1 = r4.database     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L60
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L60
            r2.<init>()     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L60
            java.lang.String r3 = "DELETE FROM botcache WHERE date < "
            r2.append(r3)     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L60
            r2.append(r5)     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L60
            java.lang.String r5 = r2.toString()     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L60
            org.rbmain.SQLite.SQLitePreparedStatement r5 = r1.executeFast(r5)     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L60
            org.rbmain.SQLite.SQLitePreparedStatement r5 = r5.stepThis()     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L60
            r5.dispose()     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L60
            org.rbmain.SQLite.SQLiteDatabase r5 = r4.database     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L60
            java.lang.String r1 = "SELECT data FROM botcache WHERE id = ?"
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L60
            r3 = 0
            r2[r3] = r6     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L60
            org.rbmain.SQLite.SQLiteCursor r5 = r5.queryFinalized(r1, r2)     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L60
            boolean r6 = r5.next()     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L60
            if (r6 == 0) goto L56
            org.rbmain.tgnet.NativeByteBuffer r6 = r5.byteBufferValue(r3)     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L5d
            if (r6 == 0) goto L56
            int r1 = r6.readInt32(r3)     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L5d
            int r2 = org.rbmain.tgnet.TLRPC$TL_messages_botCallbackAnswer.constructor     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L5d
            if (r1 != r2) goto L46
            org.rbmain.tgnet.TLRPC$TL_messages_botCallbackAnswer r1 = org.rbmain.tgnet.TLRPC$TL_messages_botCallbackAnswer.TLdeserialize(r6, r1, r3)     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L5d
            goto L4a
        L46:
            org.rbmain.tgnet.TLRPC$messages_BotResults r1 = org.rbmain.tgnet.TLRPC$messages_BotResults.TLdeserialize(r6, r1, r3)     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L5d
        L4a:
            r6.reuse()     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L69
            goto L57
        L4e:
            r6 = move-exception
            goto L52
        L50:
            r6 = move-exception
            r1 = r0
        L52:
            org.rbmain.messenger.FileLog.e(r6)     // Catch: java.lang.Exception -> L5b java.lang.Throwable -> L69
            goto L57
        L56:
            r1 = r0
        L57:
            r5.dispose()     // Catch: java.lang.Exception -> L5b java.lang.Throwable -> L69
            goto L65
        L5b:
            r5 = move-exception
            goto L62
        L5d:
            r5 = move-exception
            r1 = r0
            goto L6a
        L60:
            r5 = move-exception
            r1 = r0
        L62:
            org.rbmain.messenger.FileLog.e(r5)     // Catch: java.lang.Throwable -> L69
        L65:
            r7.run(r1, r0)
            return
        L69:
            r5 = move-exception
        L6a:
            r7.run(r1, r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.MessagesStorage.lambda$getBotCache$57(int, java.lang.String, org.rbmain.tgnet.RequestDelegate):void");
    }

    public void loadUserInfo(final TLRPC$User tLRPC$User, final boolean z, final int i, long j) {
        if (tLRPC$User == null) {
            return;
        }
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda136
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f$0.lambda$loadUserInfo$58(tLRPC$User, z, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadUserInfo$58(TLRPC$User tLRPC$User, boolean z, int i) throws Throwable {
        TLRPC$UserFull tLRPC$UserFull;
        Throwable th;
        Exception e;
        boolean z2;
        Throwable th2;
        MessagesController messagesController;
        boolean z3;
        TLRPC$User tLRPC$User2;
        boolean z4;
        int i2;
        TLRPC$UserFull tLRPC$UserFull2;
        int i3;
        boolean z5;
        ArrayList<MessageObject> arrayListLoadPinnedMessages;
        NativeByteBuffer nativeByteBufferByteBufferValue;
        HashMap<Long, MessageObject> map = new HashMap<>();
        ArrayList<Long> arrayList = new ArrayList<>();
        int i4 = 0;
        try {
            SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized("SELECT info, pinned FROM user_settings WHERE uid = " + tLRPC$User.id, new Object[0]);
            if (!sQLiteCursorQueryFinalized.next() || (nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized.byteBufferValue(0)) == null) {
                tLRPC$UserFull2 = null;
            } else {
                TLRPC$UserFull tLRPC$UserFullTLdeserialize = TLRPC$UserFull.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                try {
                    tLRPC$UserFullTLdeserialize.pinned_msg_id = sQLiteCursorQueryFinalized.intValue(1);
                    nativeByteBufferByteBufferValue.reuse();
                    tLRPC$UserFull2 = tLRPC$UserFullTLdeserialize;
                } catch (Exception e2) {
                    e = e2;
                    tLRPC$UserFull = tLRPC$UserFullTLdeserialize;
                    z2 = false;
                    try {
                        FileLog.e(e);
                        messagesController = getMessagesController();
                        z3 = true;
                        tLRPC$User2 = tLRPC$User;
                        z4 = z;
                        i2 = i;
                        messagesController.processUserInfo(tLRPC$User2, tLRPC$UserFull, z3, z4, i2, arrayList, map, i4, z2);
                    } catch (Throwable th3) {
                        th2 = th3;
                        th = th2;
                        getMessagesController().processUserInfo(tLRPC$User, tLRPC$UserFull, true, z, i, arrayList, map, i4, z2);
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    tLRPC$UserFull = tLRPC$UserFullTLdeserialize;
                    z2 = false;
                    getMessagesController().processUserInfo(tLRPC$User, tLRPC$UserFull, true, z, i, arrayList, map, i4, z2);
                    throw th;
                }
            }
            try {
                sQLiteCursorQueryFinalized.dispose();
                SQLiteCursor sQLiteCursorQueryFinalized2 = getMessagesStorage().getDatabase().queryFinalized(String.format(Locale.US, "SELECT mid FROM chat_pinned_v2 WHERE uid = %d ORDER BY mid DESC", Integer.valueOf(tLRPC$User.id)), new Object[0]);
                while (sQLiteCursorQueryFinalized2.next()) {
                    long jLongValue = sQLiteCursorQueryFinalized2.longValue(0);
                    arrayList.add(Long.valueOf(jLongValue));
                    map.put(Long.valueOf(jLongValue), null);
                }
                sQLiteCursorQueryFinalized2.dispose();
                SQLiteCursor sQLiteCursorQueryFinalized3 = this.database.queryFinalized("SELECT count, end FROM chat_pinned_count WHERE uid = " + tLRPC$User.id, new Object[0]);
                if (sQLiteCursorQueryFinalized3.next()) {
                    int iIntValue = sQLiteCursorQueryFinalized3.intValue(0);
                    try {
                        i3 = iIntValue;
                        z5 = sQLiteCursorQueryFinalized3.intValue(1) != 0;
                    } catch (Exception e3) {
                        e = e3;
                        i4 = iIntValue;
                        tLRPC$UserFull = tLRPC$UserFull2;
                        z2 = false;
                        FileLog.e(e);
                        messagesController = getMessagesController();
                        z3 = true;
                        tLRPC$User2 = tLRPC$User;
                        z4 = z;
                        i2 = i;
                        messagesController.processUserInfo(tLRPC$User2, tLRPC$UserFull, z3, z4, i2, arrayList, map, i4, z2);
                    } catch (Throwable th5) {
                        th = th5;
                        i4 = iIntValue;
                        tLRPC$UserFull = tLRPC$UserFull2;
                        z2 = false;
                        getMessagesController().processUserInfo(tLRPC$User, tLRPC$UserFull, true, z, i, arrayList, map, i4, z2);
                        throw th;
                    }
                } else {
                    i3 = 0;
                    z5 = false;
                }
                try {
                    sQLiteCursorQueryFinalized3.dispose();
                    if (tLRPC$UserFull2 != null && tLRPC$UserFull2.pinned_msg_id != 0 && (arrayList.isEmpty() || tLRPC$UserFull2.pinned_msg_id > arrayList.get(0).longValue())) {
                        arrayList.clear();
                        arrayList.add(Long.valueOf(tLRPC$UserFull2.pinned_msg_id));
                        map.put(Long.valueOf(tLRPC$UserFull2.pinned_msg_id), null);
                    }
                    if (!arrayList.isEmpty() && (arrayListLoadPinnedMessages = getMediaDataController().loadPinnedMessages(tLRPC$User.id, 0, arrayList, false)) != null) {
                        int size = arrayListLoadPinnedMessages.size();
                        while (i4 < size) {
                            MessageObject messageObject = arrayListLoadPinnedMessages.get(i4);
                            map.put(Long.valueOf(messageObject.getId()), messageObject);
                            i4++;
                        }
                    }
                    messagesController = getMessagesController();
                    z3 = true;
                    tLRPC$User2 = tLRPC$User;
                    tLRPC$UserFull = tLRPC$UserFull2;
                    z4 = z;
                    i2 = i;
                    i4 = i3;
                    z2 = z5;
                } catch (Exception e4) {
                    e = e4;
                    tLRPC$UserFull = tLRPC$UserFull2;
                    i4 = i3;
                    z2 = z5;
                    FileLog.e(e);
                    messagesController = getMessagesController();
                    z3 = true;
                    tLRPC$User2 = tLRPC$User;
                    z4 = z;
                    i2 = i;
                    messagesController.processUserInfo(tLRPC$User2, tLRPC$UserFull, z3, z4, i2, arrayList, map, i4, z2);
                } catch (Throwable th6) {
                    th2 = th6;
                    tLRPC$UserFull = tLRPC$UserFull2;
                    i4 = i3;
                    z2 = z5;
                    th = th2;
                    getMessagesController().processUserInfo(tLRPC$User, tLRPC$UserFull, true, z, i, arrayList, map, i4, z2);
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
            } catch (Throwable th7) {
                th = th7;
            }
        } catch (Exception e6) {
            tLRPC$UserFull = null;
            e = e6;
        } catch (Throwable th8) {
            tLRPC$UserFull = null;
            th = th8;
        }
        messagesController.processUserInfo(tLRPC$User2, tLRPC$UserFull, z3, z4, i2, arrayList, map, i4, z2);
    }

    public void updateUserInfo(final TLRPC$UserFull tLRPC$UserFull, final boolean z) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda149
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateUserInfo$59(z, tLRPC$UserFull);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateUserInfo$59(boolean z, TLRPC$UserFull tLRPC$UserFull) {
        if (z) {
            try {
                SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized("SELECT uid FROM user_settings WHERE uid = " + tLRPC$UserFull.user.id, new Object[0]);
                boolean next = sQLiteCursorQueryFinalized.next();
                sQLiteCursorQueryFinalized.dispose();
                if (!next) {
                    return;
                }
            } catch (Exception e) {
                FileLog.e(e);
                return;
            }
        }
        SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("REPLACE INTO user_settings VALUES(?, ?, ?)");
        NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(tLRPC$UserFull.getObjectSize());
        tLRPC$UserFull.serializeToStream(nativeByteBuffer);
        sQLitePreparedStatementExecuteFast.bindInteger(1, tLRPC$UserFull.user.id);
        sQLitePreparedStatementExecuteFast.bindByteBuffer(2, nativeByteBuffer);
        sQLitePreparedStatementExecuteFast.bindLong(3, tLRPC$UserFull.pinned_msg_id);
        sQLitePreparedStatementExecuteFast.step();
        sQLitePreparedStatementExecuteFast.dispose();
        nativeByteBuffer.reuse();
        if ((tLRPC$UserFull.flags & 2048) != 0) {
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast2 = this.database.executeFast("UPDATE dialogs SET folder_id = ? WHERE did = ?");
            sQLitePreparedStatementExecuteFast2.bindInteger(1, tLRPC$UserFull.folder_id);
            sQLitePreparedStatementExecuteFast2.bindLong(2, tLRPC$UserFull.user.id);
            sQLitePreparedStatementExecuteFast2.step();
            sQLitePreparedStatementExecuteFast2.dispose();
            this.unknownDialogsIds.remove(tLRPC$UserFull.user.id);
        }
    }

    public void saveChatInviter(final int i, final int i2) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda27
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$saveChatInviter$60(i2, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveChatInviter$60(int i, int i2) {
        try {
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("UPDATE chat_settings_v2 SET inviter = ? WHERE uid = ?");
            sQLitePreparedStatementExecuteFast.requery();
            sQLitePreparedStatementExecuteFast.bindInteger(1, i);
            sQLitePreparedStatementExecuteFast.bindInteger(2, i2);
            sQLitePreparedStatementExecuteFast.step();
            sQLitePreparedStatementExecuteFast.dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void saveChatLinksCount(final int i, final int i2) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda24
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$saveChatLinksCount$61(i2, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveChatLinksCount$61(int i, int i2) {
        try {
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("UPDATE chat_settings_v2 SET links = ? WHERE uid = ?");
            sQLitePreparedStatementExecuteFast.requery();
            sQLitePreparedStatementExecuteFast.bindInteger(1, i);
            sQLitePreparedStatementExecuteFast.bindInteger(2, i2);
            sQLitePreparedStatementExecuteFast.step();
            sQLitePreparedStatementExecuteFast.dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void updateChatInfo(final TLRPC$ChatFull tLRPC$ChatFull, final boolean z) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda124
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateChatInfo$62(tLRPC$ChatFull, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateChatInfo$62(TLRPC$ChatFull tLRPC$ChatFull, boolean z) {
        int iIntValue;
        int iIntValue2;
        try {
            SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized("SELECT online, inviter, links FROM chat_settings_v2 WHERE uid = " + tLRPC$ChatFull.id, new Object[0]);
            if (sQLiteCursorQueryFinalized.next()) {
                iIntValue = sQLiteCursorQueryFinalized.intValue(0);
                tLRPC$ChatFull.inviterId = sQLiteCursorQueryFinalized.intValue(1);
                iIntValue2 = sQLiteCursorQueryFinalized.intValue(2);
            } else {
                iIntValue = -1;
                iIntValue2 = 0;
            }
            sQLiteCursorQueryFinalized.dispose();
            if (z && iIntValue == -1) {
                return;
            }
            if (iIntValue >= 0 && (tLRPC$ChatFull.flags & 8192) == 0) {
                tLRPC$ChatFull.online_count = iIntValue;
            }
            if (iIntValue2 >= 0) {
                tLRPC$ChatFull.invitesCount = iIntValue2;
            }
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("REPLACE INTO chat_settings_v2 VALUES(?, ?, ?, ?, ?, ?)");
            NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(tLRPC$ChatFull.getObjectSize());
            tLRPC$ChatFull.serializeToStream(nativeByteBuffer);
            sQLitePreparedStatementExecuteFast.bindInteger(1, tLRPC$ChatFull.id);
            sQLitePreparedStatementExecuteFast.bindByteBuffer(2, nativeByteBuffer);
            sQLitePreparedStatementExecuteFast.bindLong(3, tLRPC$ChatFull.pinned_msg_id);
            sQLitePreparedStatementExecuteFast.bindInteger(4, tLRPC$ChatFull.online_count);
            sQLitePreparedStatementExecuteFast.bindInteger(5, tLRPC$ChatFull.inviterId);
            sQLitePreparedStatementExecuteFast.bindInteger(6, tLRPC$ChatFull.invitesCount);
            sQLitePreparedStatementExecuteFast.step();
            sQLitePreparedStatementExecuteFast.dispose();
            nativeByteBuffer.reuse();
            if (tLRPC$ChatFull instanceof TLRPC$TL_channelFull) {
                SQLiteCursor sQLiteCursorQueryFinalized2 = this.database.queryFinalized("SELECT inbox_max, outbox_max FROM dialogs WHERE did = " + (-tLRPC$ChatFull.id), new Object[0]);
                if (sQLiteCursorQueryFinalized2.next() && sQLiteCursorQueryFinalized2.intValue(0) < tLRPC$ChatFull.read_inbox_max_id) {
                    int iIntValue3 = sQLiteCursorQueryFinalized2.intValue(1);
                    SQLitePreparedStatement sQLitePreparedStatementExecuteFast2 = this.database.executeFast("UPDATE dialogs SET unread_count = ?, inbox_max = ?, outbox_max = ? WHERE did = ?");
                    sQLitePreparedStatementExecuteFast2.bindInteger(1, tLRPC$ChatFull.unread_count);
                    sQLitePreparedStatementExecuteFast2.bindInteger(2, tLRPC$ChatFull.read_inbox_max_id);
                    sQLitePreparedStatementExecuteFast2.bindInteger(3, Math.max(iIntValue3, tLRPC$ChatFull.read_outbox_max_id));
                    sQLitePreparedStatementExecuteFast2.bindLong(4, -tLRPC$ChatFull.id);
                    sQLitePreparedStatementExecuteFast2.step();
                    sQLitePreparedStatementExecuteFast2.dispose();
                }
                sQLiteCursorQueryFinalized2.dispose();
            }
            if ((tLRPC$ChatFull.flags & 2048) != 0) {
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast3 = this.database.executeFast("UPDATE dialogs SET folder_id = ? WHERE did = ?");
                sQLitePreparedStatementExecuteFast3.bindInteger(1, tLRPC$ChatFull.folder_id);
                sQLitePreparedStatementExecuteFast3.bindLong(2, -tLRPC$ChatFull.id);
                sQLitePreparedStatementExecuteFast3.step();
                sQLitePreparedStatementExecuteFast3.dispose();
                this.unknownDialogsIds.remove(-tLRPC$ChatFull.id);
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void updateChatOnlineCount(final int i, final int i2) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda25
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateChatOnlineCount$63(i2, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateChatOnlineCount$63(int i, int i2) {
        try {
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("UPDATE chat_settings_v2 SET online = ? WHERE uid = ?");
            sQLitePreparedStatementExecuteFast.requery();
            sQLitePreparedStatementExecuteFast.bindInteger(1, i);
            sQLitePreparedStatementExecuteFast.bindInteger(2, i2);
            sQLitePreparedStatementExecuteFast.step();
            sQLitePreparedStatementExecuteFast.dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void updatePinnedMessages(final long j, final ArrayList<Long> arrayList, final boolean z, final int i, final long j2, final boolean z2, final HashMap<Long, MessageObject> map) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda148
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updatePinnedMessages$66(z, map, j2, j, arrayList, i, z2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updatePinnedMessages$66(boolean z, final HashMap map, final long j, final long j2, final ArrayList arrayList, int i, boolean z2) {
        final boolean z3;
        int iMax;
        final int iMax2;
        int iIntValue;
        int iIntValue2;
        int iMax3;
        final boolean z4;
        int i2 = 1;
        try {
            if (z) {
                this.database.beginTransaction();
                if (map != null) {
                    if (j == 0) {
                        this.database.executeFast("DELETE FROM chat_pinned_v2 WHERE uid = " + j2).stepThis().dispose();
                    }
                    iIntValue = 0;
                } else {
                    SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT COUNT(mid) FROM chat_pinned_v2 WHERE uid = %d AND mid IN (%s)", Long.valueOf(j2), TextUtils.join(",", arrayList)), new Object[0]);
                    iIntValue = sQLiteCursorQueryFinalized.next() ? sQLiteCursorQueryFinalized.intValue(0) : 0;
                    sQLiteCursorQueryFinalized.dispose();
                }
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("REPLACE INTO chat_pinned_v2 VALUES(?, ?, ?)");
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Long l = (Long) arrayList.get(i3);
                    sQLitePreparedStatementExecuteFast.requery();
                    sQLitePreparedStatementExecuteFast.bindLong(i2, j2);
                    sQLitePreparedStatementExecuteFast.bindLong(2, l.longValue());
                    NativeByteBuffer nativeByteBuffer = null;
                    MessageObject messageObject = map != null ? (MessageObject) map.get(l) : null;
                    if (messageObject != null) {
                        nativeByteBuffer = new NativeByteBuffer(messageObject.messageOwner.getObjectSize());
                        messageObject.messageOwner.serializeToStream(nativeByteBuffer);
                        sQLitePreparedStatementExecuteFast.bindByteBuffer(3, nativeByteBuffer);
                    } else {
                        sQLitePreparedStatementExecuteFast.bindNull(3);
                    }
                    sQLitePreparedStatementExecuteFast.step();
                    if (nativeByteBuffer != null) {
                        nativeByteBuffer.reuse();
                    }
                    i3++;
                    i2 = 1;
                }
                sQLitePreparedStatementExecuteFast.dispose();
                this.database.commitTransaction();
                SQLiteDatabase sQLiteDatabase = this.database;
                Locale locale = Locale.US;
                SQLiteCursor sQLiteCursorQueryFinalized2 = sQLiteDatabase.queryFinalized(String.format(locale, "SELECT COUNT(mid) FROM chat_pinned_v2 WHERE uid = %d", Long.valueOf(j2)), new Object[0]);
                int iIntValue3 = sQLiteCursorQueryFinalized2.next() ? sQLiteCursorQueryFinalized2.intValue(0) : 0;
                sQLiteCursorQueryFinalized2.dispose();
                if (map != null) {
                    iMax3 = Math.max(i, iIntValue3);
                    z4 = z2;
                } else {
                    SQLiteCursor sQLiteCursorQueryFinalized3 = this.database.queryFinalized(String.format(locale, "SELECT count, end FROM chat_pinned_count WHERE uid = %d", Long.valueOf(j2)), new Object[0]);
                    if (sQLiteCursorQueryFinalized3.next()) {
                        iIntValue2 = sQLiteCursorQueryFinalized3.intValue(0);
                        boolean z5 = sQLiteCursorQueryFinalized3.intValue(1) != 0;
                        sQLiteCursorQueryFinalized3.dispose();
                        iMax3 = Math.max(iIntValue2 + (arrayList.size() - iIntValue), iIntValue3);
                        z4 = z5;
                    } else {
                        iIntValue2 = 0;
                    }
                    sQLiteCursorQueryFinalized3.dispose();
                    iMax3 = Math.max(iIntValue2 + (arrayList.size() - iIntValue), iIntValue3);
                    z4 = z5;
                }
                final int i4 = iMax3;
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast2 = this.database.executeFast("REPLACE INTO chat_pinned_count VALUES(?, ?, ?)");
                sQLitePreparedStatementExecuteFast2.requery();
                sQLitePreparedStatementExecuteFast2.bindLong(1, j2);
                sQLitePreparedStatementExecuteFast2.bindInteger(2, i4);
                sQLitePreparedStatementExecuteFast2.bindInteger(3, z4 ? 1 : 0);
                sQLitePreparedStatementExecuteFast2.step();
                sQLitePreparedStatementExecuteFast2.dispose();
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda71
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$updatePinnedMessages$64(j2, arrayList, map, j, i4, z4);
                    }
                });
                return;
            }
            if (arrayList == null) {
                this.database.executeFast("DELETE FROM chat_pinned_v2 WHERE uid = " + j2).stepThis().dispose();
                if (j2 < 0) {
                    this.database.executeFast(String.format(Locale.US, "UPDATE chat_settings_v2 SET pinned = 0 WHERE uid = %d", Long.valueOf(-j2))).stepThis().dispose();
                } else {
                    this.database.executeFast(String.format(Locale.US, "UPDATE user_settings SET pinned = 0 WHERE uid = %d", Long.valueOf(j2))).stepThis().dispose();
                }
                iMax2 = 0;
                z3 = true;
            } else {
                String strJoin = TextUtils.join(",", arrayList);
                if (j2 < 0) {
                    this.database.executeFast(String.format(Locale.US, "UPDATE chat_settings_v2 SET pinned = 0 WHERE uid = %d AND pinned IN (%s)", Long.valueOf(-j2), strJoin)).stepThis().dispose();
                } else {
                    this.database.executeFast(String.format(Locale.US, "UPDATE user_settings SET pinned = 0 WHERE uid = %d AND pinned IN (%s)", Long.valueOf(j2), strJoin)).stepThis().dispose();
                }
                SQLiteDatabase sQLiteDatabase2 = this.database;
                Locale locale2 = Locale.US;
                sQLiteDatabase2.executeFast(String.format(locale2, "DELETE FROM chat_pinned_v2 WHERE uid = %d AND mid IN(%s)", Long.valueOf(j2), strJoin)).stepThis().dispose();
                SQLiteCursor sQLiteCursorQueryFinalized4 = this.database.queryFinalized("SELECT changes()", new Object[0]);
                int iIntValue4 = sQLiteCursorQueryFinalized4.next() ? sQLiteCursorQueryFinalized4.intValue(0) : 0;
                sQLiteCursorQueryFinalized4.dispose();
                SQLiteCursor sQLiteCursorQueryFinalized5 = this.database.queryFinalized(String.format(locale2, "SELECT COUNT(mid) FROM chat_pinned_v2 WHERE uid = %d", Long.valueOf(j2)), new Object[0]);
                int iIntValue5 = sQLiteCursorQueryFinalized5.next() ? sQLiteCursorQueryFinalized5.intValue(0) : 0;
                sQLiteCursorQueryFinalized5.dispose();
                SQLiteCursor sQLiteCursorQueryFinalized6 = this.database.queryFinalized(String.format(locale2, "SELECT count, end FROM chat_pinned_count WHERE uid = %d", Long.valueOf(j2)), new Object[0]);
                if (sQLiteCursorQueryFinalized6.next()) {
                    iMax = Math.max(0, sQLiteCursorQueryFinalized6.intValue(0) - iIntValue4);
                    z3 = sQLiteCursorQueryFinalized6.intValue(1) != 0;
                } else {
                    z3 = false;
                    iMax = 0;
                }
                sQLiteCursorQueryFinalized6.dispose();
                iMax2 = Math.max(iIntValue5, iMax);
            }
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast3 = this.database.executeFast("REPLACE INTO chat_pinned_count VALUES(?, ?, ?)");
            sQLitePreparedStatementExecuteFast3.requery();
            sQLitePreparedStatementExecuteFast3.bindLong(1, j2);
            sQLitePreparedStatementExecuteFast3.bindInteger(2, iMax2);
            sQLitePreparedStatementExecuteFast3.bindInteger(3, z3 ? 1 : 0);
            sQLitePreparedStatementExecuteFast3.step();
            sQLitePreparedStatementExecuteFast3.dispose();
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda72
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$updatePinnedMessages$65(j2, arrayList, map, j, iMax2, z3);
                }
            });
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updatePinnedMessages$64(long j, ArrayList arrayList, HashMap map, long j2, int i, boolean z) {
        getNotificationCenter().postNotificationName(NotificationCenter.didLoadPinnedMessages, Long.valueOf(j), arrayList, Boolean.TRUE, null, map, Long.valueOf(j2), Integer.valueOf(i), Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updatePinnedMessages$65(long j, ArrayList arrayList, HashMap map, long j2, int i, boolean z) {
        getNotificationCenter().postNotificationName(NotificationCenter.didLoadPinnedMessages, Long.valueOf(j), arrayList, Boolean.FALSE, null, map, Long.valueOf(j2), Integer.valueOf(i), Boolean.valueOf(z));
    }

    public void updateChatInfo(final int i, final int i2, final int i3, final int i4, final int i5) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda29
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateChatInfo$68(i, i3, i2, i4, i5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateChatInfo$68(int i, int i2, int i3, int i4, int i5) {
        TLRPC$ChatParticipant tLRPC$TL_chatParticipant;
        NativeByteBuffer nativeByteBufferByteBufferValue;
        try {
            int i6 = 0;
            SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized("SELECT info, pinned, online, inviter FROM chat_settings_v2 WHERE uid = " + i, new Object[0]);
            final TLRPC$ChatFull tLRPC$ChatFullTLdeserialize = null;
            new ArrayList();
            if (sQLiteCursorQueryFinalized.next() && (nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized.byteBufferValue(0)) != null) {
                tLRPC$ChatFullTLdeserialize = TLRPC$ChatFull.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                nativeByteBufferByteBufferValue.reuse();
                tLRPC$ChatFullTLdeserialize.pinned_msg_id = sQLiteCursorQueryFinalized.intValue(1);
                tLRPC$ChatFullTLdeserialize.online_count = sQLiteCursorQueryFinalized.intValue(2);
                tLRPC$ChatFullTLdeserialize.inviterId = sQLiteCursorQueryFinalized.intValue(3);
            }
            sQLiteCursorQueryFinalized.dispose();
            if (tLRPC$ChatFullTLdeserialize instanceof TLRPC$TL_chatFull) {
                if (i2 == 1) {
                    while (true) {
                        if (i6 >= tLRPC$ChatFullTLdeserialize.participants.participants.size()) {
                            break;
                        }
                        if (tLRPC$ChatFullTLdeserialize.participants.participants.get(i6).user_id == i3) {
                            tLRPC$ChatFullTLdeserialize.participants.participants.remove(i6);
                            break;
                        }
                        i6++;
                    }
                } else if (i2 == 0) {
                    Iterator<TLRPC$ChatParticipant> it = tLRPC$ChatFullTLdeserialize.participants.participants.iterator();
                    while (it.hasNext()) {
                        if (it.next().user_id == i3) {
                            return;
                        }
                    }
                    TLRPC$TL_chatParticipant tLRPC$TL_chatParticipant2 = new TLRPC$TL_chatParticipant();
                    tLRPC$TL_chatParticipant2.user_id = i3;
                    tLRPC$TL_chatParticipant2.inviter_id = i4;
                    tLRPC$TL_chatParticipant2.date = getConnectionsManager().getCurrentTime();
                    tLRPC$ChatFullTLdeserialize.participants.participants.add(tLRPC$TL_chatParticipant2);
                } else if (i2 == 2) {
                    while (true) {
                        if (i6 >= tLRPC$ChatFullTLdeserialize.participants.participants.size()) {
                            break;
                        }
                        TLRPC$ChatParticipant tLRPC$ChatParticipant = tLRPC$ChatFullTLdeserialize.participants.participants.get(i6);
                        if (tLRPC$ChatParticipant.user_id == i3) {
                            if (i4 == 1) {
                                tLRPC$TL_chatParticipant = new TLRPC$TL_chatParticipantAdmin();
                            } else {
                                tLRPC$TL_chatParticipant = new TLRPC$TL_chatParticipant();
                            }
                            tLRPC$TL_chatParticipant.user_id = tLRPC$ChatParticipant.user_id;
                            tLRPC$TL_chatParticipant.date = tLRPC$ChatParticipant.date;
                            tLRPC$TL_chatParticipant.inviter_id = tLRPC$ChatParticipant.inviter_id;
                            tLRPC$ChatFullTLdeserialize.participants.participants.set(i6, tLRPC$TL_chatParticipant);
                        } else {
                            i6++;
                        }
                    }
                }
                tLRPC$ChatFullTLdeserialize.participants.version = i5;
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda123
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$updateChatInfo$67(tLRPC$ChatFullTLdeserialize);
                    }
                });
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("REPLACE INTO chat_settings_v2 VALUES(?, ?, ?, ?, ?, ?)");
                NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(tLRPC$ChatFullTLdeserialize.getObjectSize());
                tLRPC$ChatFullTLdeserialize.serializeToStream(nativeByteBuffer);
                sQLitePreparedStatementExecuteFast.bindInteger(1, i);
                sQLitePreparedStatementExecuteFast.bindByteBuffer(2, nativeByteBuffer);
                sQLitePreparedStatementExecuteFast.bindLong(3, tLRPC$ChatFullTLdeserialize.pinned_msg_id);
                sQLitePreparedStatementExecuteFast.bindInteger(4, tLRPC$ChatFullTLdeserialize.online_count);
                sQLitePreparedStatementExecuteFast.bindInteger(5, tLRPC$ChatFullTLdeserialize.inviterId);
                sQLitePreparedStatementExecuteFast.bindInteger(6, tLRPC$ChatFullTLdeserialize.invitesCount);
                sQLitePreparedStatementExecuteFast.step();
                sQLitePreparedStatementExecuteFast.dispose();
                nativeByteBuffer.reuse();
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateChatInfo$67(TLRPC$ChatFull tLRPC$ChatFull) {
        NotificationCenter notificationCenter = getNotificationCenter();
        int i = NotificationCenter.chatInfoDidLoad;
        Boolean bool = Boolean.FALSE;
        notificationCenter.postNotificationName(i, tLRPC$ChatFull, 0, bool, bool);
    }

    public boolean isMigratedChat(final int i) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final boolean[] zArr = new boolean[1];
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda53
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$isMigratedChat$69(i, zArr, countDownLatch);
            }
        });
        try {
            countDownLatch.await();
        } catch (Exception e) {
            FileLog.e(e);
        }
        return zArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$isMigratedChat$69(int i, boolean[] zArr, CountDownLatch countDownLatch) {
        NativeByteBuffer nativeByteBufferByteBufferValue;
        try {
            try {
                SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized("SELECT info FROM chat_settings_v2 WHERE uid = " + i, new Object[0]);
                TLRPC$ChatFull tLRPC$ChatFullTLdeserialize = null;
                new ArrayList();
                if (sQLiteCursorQueryFinalized.next() && (nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized.byteBufferValue(0)) != null) {
                    tLRPC$ChatFullTLdeserialize = TLRPC$ChatFull.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                    nativeByteBufferByteBufferValue.reuse();
                }
                sQLiteCursorQueryFinalized.dispose();
                zArr[0] = (tLRPC$ChatFullTLdeserialize instanceof TLRPC$TL_channelFull) && tLRPC$ChatFullTLdeserialize.migrated_from_chat_id != 0;
                countDownLatch.countDown();
            } catch (Exception e) {
                FileLog.e(e);
            }
        } finally {
            countDownLatch.countDown();
        }
    }

    public boolean hasInviteMeMessage(final int i) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final boolean[] zArr = new boolean[1];
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda52
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$hasInviteMeMessage$70(i, zArr, countDownLatch);
            }
        });
        try {
            countDownLatch.await();
        } catch (Exception e) {
            FileLog.e(e);
        }
        return zArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$hasInviteMeMessage$70(int i, boolean[] zArr, CountDownLatch countDownLatch) {
        try {
            try {
                int clientUserId = getUserConfig().getClientUserId();
                SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized("SELECT data FROM messages WHERE uid = " + (-i) + " AND out = 0 ORDER BY mid DESC LIMIT 100", new Object[0]);
                while (true) {
                    if (!sQLiteCursorQueryFinalized.next()) {
                        break;
                    }
                    NativeByteBuffer nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized.byteBufferValue(0);
                    if (nativeByteBufferByteBufferValue != null) {
                        TLRPC$Message tLRPC$MessageTLdeserialize = TLRPC$Message.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                        nativeByteBufferByteBufferValue.reuse();
                        TLRPC$MessageAction tLRPC$MessageAction = tLRPC$MessageTLdeserialize.action;
                        if ((tLRPC$MessageAction instanceof TLRPC$TL_messageActionChatAddUser) && tLRPC$MessageAction.users.contains(Integer.valueOf(clientUserId))) {
                            zArr[0] = true;
                            break;
                        }
                    }
                }
                sQLiteCursorQueryFinalized.dispose();
            } catch (Exception e) {
                FileLog.e(e);
            }
        } finally {
            countDownLatch.countDown();
        }
    }

    private TLRPC$ChatFull loadChatInfoInternal(int i, boolean z, boolean z2, boolean z3, long j) throws Throwable {
        TLRPC$ChatFull tLRPC$ChatFull;
        TLRPC$ChatFull tLRPC$ChatFull2;
        int i2;
        boolean z4;
        MessagesController messagesController;
        boolean z5;
        int i3;
        TLRPC$ChatFull tLRPC$ChatFull3;
        boolean z6;
        boolean z7;
        TLRPC$ChatFull tLRPC$ChatFull4;
        TLRPC$User tLRPC$UserTLdeserialize;
        TLRPC$ChannelParticipant tLRPC$ChannelParticipantTLdeserialize;
        int i4;
        boolean z8;
        NativeByteBuffer nativeByteBufferByteBufferValue;
        ArrayList<TLRPC$User> arrayList = new ArrayList<>();
        HashMap<Long, MessageObject> map = new HashMap<>();
        ArrayList<Long> arrayList2 = new ArrayList<>();
        try {
            SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized("SELECT info, pinned, online, inviter, links FROM chat_settings_v2 WHERE uid = " + i, new Object[0]);
            int i5 = 2;
            if (!sQLiteCursorQueryFinalized.next() || (nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized.byteBufferValue(0)) == null) {
                tLRPC$ChatFull4 = null;
            } else {
                TLRPC$ChatFull tLRPC$ChatFullTLdeserialize = TLRPC$ChatFull.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                try {
                    nativeByteBufferByteBufferValue.reuse();
                    tLRPC$ChatFullTLdeserialize.pinned_msg_id = sQLiteCursorQueryFinalized.intValue(1);
                    tLRPC$ChatFullTLdeserialize.online_count = sQLiteCursorQueryFinalized.intValue(2);
                    tLRPC$ChatFullTLdeserialize.inviterId = sQLiteCursorQueryFinalized.intValue(3);
                    tLRPC$ChatFullTLdeserialize.invitesCount = sQLiteCursorQueryFinalized.intValue(4);
                    tLRPC$ChatFull4 = tLRPC$ChatFullTLdeserialize;
                } catch (Exception e) {
                    e = e;
                    tLRPC$ChatFull2 = tLRPC$ChatFullTLdeserialize;
                    i2 = 0;
                    z4 = false;
                    try {
                        FileLog.e(e);
                        messagesController = getMessagesController();
                        z5 = true;
                        i3 = i;
                        tLRPC$ChatFull3 = tLRPC$ChatFull2;
                        z6 = z2;
                        z7 = z3;
                        messagesController.processChatInfo(i3, tLRPC$ChatFull3, arrayList, z5, z6, z7, arrayList2, map, i2, z4);
                        return tLRPC$ChatFull2;
                    } catch (Throwable th) {
                        th = th;
                        tLRPC$ChatFull = tLRPC$ChatFull2;
                        getMessagesController().processChatInfo(i, tLRPC$ChatFull, arrayList, true, z2, z3, arrayList2, map, i2, z4);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    tLRPC$ChatFull = tLRPC$ChatFullTLdeserialize;
                    i2 = 0;
                    z4 = false;
                    getMessagesController().processChatInfo(i, tLRPC$ChatFull, arrayList, true, z2, z3, arrayList2, map, i2, z4);
                    throw th;
                }
            }
            try {
                try {
                    sQLiteCursorQueryFinalized.dispose();
                } catch (Throwable th3) {
                    th = th3;
                    tLRPC$ChatFull = tLRPC$ChatFull4;
                }
                try {
                    if (tLRPC$ChatFull4 instanceof TLRPC$TL_chatFull) {
                        StringBuilder sb = new StringBuilder();
                        for (int i6 = 0; i6 < tLRPC$ChatFull4.participants.participants.size(); i6++) {
                            TLRPC$ChatParticipant tLRPC$ChatParticipant = tLRPC$ChatFull4.participants.participants.get(i6);
                            if (sb.length() != 0) {
                                sb.append(",");
                            }
                            sb.append(tLRPC$ChatParticipant.user_id);
                        }
                        if (sb.length() != 0) {
                            getUsersInternal(sb.toString(), arrayList);
                        }
                    } else if (tLRPC$ChatFull4 instanceof TLRPC$TL_channelFull) {
                        SQLiteCursor sQLiteCursorQueryFinalized2 = this.database.queryFinalized("SELECT us.data, us.status, cu.data, cu.date FROM channel_users_v2 as cu LEFT JOIN users as us ON us.uid = cu.uid WHERE cu.did = " + (-i) + " ORDER BY cu.date DESC", new Object[0]);
                        tLRPC$ChatFull4.participants = new TLRPC$TL_chatParticipants();
                        while (sQLiteCursorQueryFinalized2.next()) {
                            try {
                                NativeByteBuffer nativeByteBufferByteBufferValue2 = sQLiteCursorQueryFinalized2.byteBufferValue(0);
                                if (nativeByteBufferByteBufferValue2 != null) {
                                    tLRPC$UserTLdeserialize = TLRPC$User.TLdeserialize(nativeByteBufferByteBufferValue2, nativeByteBufferByteBufferValue2.readInt32(false), false);
                                    nativeByteBufferByteBufferValue2.reuse();
                                } else {
                                    tLRPC$UserTLdeserialize = null;
                                }
                                NativeByteBuffer nativeByteBufferByteBufferValue3 = sQLiteCursorQueryFinalized2.byteBufferValue(i5);
                                if (nativeByteBufferByteBufferValue3 != null) {
                                    tLRPC$ChannelParticipantTLdeserialize = TLRPC$ChannelParticipant.TLdeserialize(nativeByteBufferByteBufferValue3, nativeByteBufferByteBufferValue3.readInt32(false), false);
                                    nativeByteBufferByteBufferValue3.reuse();
                                } else {
                                    tLRPC$ChannelParticipantTLdeserialize = null;
                                }
                                if (tLRPC$UserTLdeserialize != null && tLRPC$ChannelParticipantTLdeserialize != null) {
                                    TLRPC$UserStatus tLRPC$UserStatus = tLRPC$UserTLdeserialize.status;
                                    if (tLRPC$UserStatus != null) {
                                        tLRPC$UserStatus.expires = sQLiteCursorQueryFinalized2.intValue(1);
                                    }
                                    arrayList.add(tLRPC$UserTLdeserialize);
                                    tLRPC$ChannelParticipantTLdeserialize.date = sQLiteCursorQueryFinalized2.intValue(3);
                                    TLRPC$TL_chatChannelParticipant tLRPC$TL_chatChannelParticipant = new TLRPC$TL_chatChannelParticipant();
                                    tLRPC$TL_chatChannelParticipant.user_id = MessageObject.getPeerId(tLRPC$ChannelParticipantTLdeserialize.peer);
                                    tLRPC$TL_chatChannelParticipant.date = tLRPC$ChannelParticipantTLdeserialize.date;
                                    tLRPC$TL_chatChannelParticipant.inviter_id = tLRPC$ChannelParticipantTLdeserialize.inviter_id;
                                    tLRPC$TL_chatChannelParticipant.channelParticipant = tLRPC$ChannelParticipantTLdeserialize;
                                    tLRPC$ChatFull4.participants.participants.add(tLRPC$TL_chatChannelParticipant);
                                }
                            } catch (Exception e2) {
                                FileLog.e(e2);
                            }
                            i5 = 2;
                        }
                        sQLiteCursorQueryFinalized2.dispose();
                        StringBuilder sb2 = new StringBuilder();
                        for (int i7 = 0; i7 < tLRPC$ChatFull4.bot_info.size(); i7++) {
                            TLRPC$BotInfo tLRPC$BotInfo = tLRPC$ChatFull4.bot_info.get(i7);
                            if (sb2.length() != 0) {
                                sb2.append(",");
                            }
                            sb2.append(tLRPC$BotInfo.user_id);
                        }
                        if (sb2.length() != 0) {
                            getUsersInternal(sb2.toString(), arrayList);
                        }
                    }
                    if (tLRPC$ChatFull4 != null && tLRPC$ChatFull4.inviterId != 0) {
                        getUsersInternal(io.github.inflationx.calligraphy3.BuildConfig.FLAVOR + tLRPC$ChatFull4.inviterId, arrayList);
                    }
                    int i8 = -i;
                    SQLiteCursor sQLiteCursorQueryFinalized3 = getMessagesStorage().getDatabase().queryFinalized(String.format(Locale.US, "SELECT mid FROM chat_pinned_v2 WHERE uid = %d ORDER BY mid DESC", Integer.valueOf(i8)), new Object[0]);
                    while (sQLiteCursorQueryFinalized3.next()) {
                        long jLongValue = sQLiteCursorQueryFinalized3.longValue(0);
                        arrayList2.add(Long.valueOf(jLongValue));
                        map.put(Long.valueOf(jLongValue), null);
                    }
                    sQLiteCursorQueryFinalized3.dispose();
                    SQLiteCursor sQLiteCursorQueryFinalized4 = this.database.queryFinalized("SELECT count, end FROM chat_pinned_count WHERE uid = " + i8, new Object[0]);
                    if (sQLiteCursorQueryFinalized4.next()) {
                        int iIntValue = sQLiteCursorQueryFinalized4.intValue(0);
                        try {
                            i4 = iIntValue;
                            z8 = sQLiteCursorQueryFinalized4.intValue(1) != 0;
                        } catch (Exception e3) {
                            e = e3;
                            tLRPC$ChatFull2 = tLRPC$ChatFull4;
                            i2 = iIntValue;
                            z4 = false;
                            FileLog.e(e);
                            messagesController = getMessagesController();
                            z5 = true;
                            i3 = i;
                            tLRPC$ChatFull3 = tLRPC$ChatFull2;
                            z6 = z2;
                            z7 = z3;
                            messagesController.processChatInfo(i3, tLRPC$ChatFull3, arrayList, z5, z6, z7, arrayList2, map, i2, z4);
                            return tLRPC$ChatFull2;
                        } catch (Throwable th4) {
                            th = th4;
                            tLRPC$ChatFull = tLRPC$ChatFull4;
                            i2 = iIntValue;
                            z4 = false;
                            getMessagesController().processChatInfo(i, tLRPC$ChatFull, arrayList, true, z2, z3, arrayList2, map, i2, z4);
                            throw th;
                        }
                    } else {
                        i4 = 0;
                        z8 = false;
                    }
                    try {
                        try {
                            sQLiteCursorQueryFinalized4.dispose();
                            if (tLRPC$ChatFull4 != null) {
                                try {
                                    if (tLRPC$ChatFull4.pinned_msg_id != 0 && (arrayList2.isEmpty() || tLRPC$ChatFull4.pinned_msg_id > arrayList2.get(0).longValue())) {
                                        arrayList2.clear();
                                        arrayList2.add(Long.valueOf(tLRPC$ChatFull4.pinned_msg_id));
                                        map.put(Long.valueOf(tLRPC$ChatFull4.pinned_msg_id), null);
                                    }
                                } catch (Throwable th5) {
                                    th = th5;
                                    tLRPC$ChatFull = tLRPC$ChatFull4;
                                    i2 = i4;
                                    z4 = z8;
                                    getMessagesController().processChatInfo(i, tLRPC$ChatFull, arrayList, true, z2, z3, arrayList2, map, i2, z4);
                                    throw th;
                                }
                            }
                            if (!arrayList2.isEmpty()) {
                                ArrayList<MessageObject> arrayListLoadPinnedMessages = getMediaDataController().loadPinnedMessages(i8, z ? i : 0, arrayList2, false);
                                if (arrayListLoadPinnedMessages != null) {
                                    int size = arrayListLoadPinnedMessages.size();
                                    for (int i9 = 0; i9 < size; i9++) {
                                        MessageObject messageObject = arrayListLoadPinnedMessages.get(i9);
                                        map.put(Long.valueOf(messageObject.getId()), messageObject);
                                    }
                                }
                            }
                            messagesController = getMessagesController();
                            i3 = i;
                            tLRPC$ChatFull3 = tLRPC$ChatFull4;
                            tLRPC$ChatFull2 = tLRPC$ChatFull4;
                            z5 = true;
                            z6 = z2;
                            z7 = z3;
                            i2 = i4;
                            z4 = z8;
                        } catch (Exception e4) {
                            e = e4;
                            tLRPC$ChatFull2 = tLRPC$ChatFull4;
                            i2 = i4;
                            z4 = z8;
                            FileLog.e(e);
                            messagesController = getMessagesController();
                            z5 = true;
                            i3 = i;
                            tLRPC$ChatFull3 = tLRPC$ChatFull2;
                            z6 = z2;
                            z7 = z3;
                            messagesController.processChatInfo(i3, tLRPC$ChatFull3, arrayList, z5, z6, z7, arrayList2, map, i2, z4);
                            return tLRPC$ChatFull2;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        tLRPC$ChatFull = tLRPC$ChatFull4;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    tLRPC$ChatFull = tLRPC$ChatFull4;
                    i2 = 0;
                    z4 = false;
                    getMessagesController().processChatInfo(i, tLRPC$ChatFull, arrayList, true, z2, z3, arrayList2, map, i2, z4);
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                tLRPC$ChatFull2 = tLRPC$ChatFull4;
                i2 = 0;
                z4 = false;
                FileLog.e(e);
                messagesController = getMessagesController();
                z5 = true;
                i3 = i;
                tLRPC$ChatFull3 = tLRPC$ChatFull2;
                z6 = z2;
                z7 = z3;
                messagesController.processChatInfo(i3, tLRPC$ChatFull3, arrayList, z5, z6, z7, arrayList2, map, i2, z4);
                return tLRPC$ChatFull2;
            }
        } catch (Exception e6) {
            e = e6;
            tLRPC$ChatFull2 = null;
        } catch (Throwable th8) {
            th = th8;
            tLRPC$ChatFull = null;
        }
        messagesController.processChatInfo(i3, tLRPC$ChatFull3, arrayList, z5, z6, z7, arrayList2, map, i2, z4);
        return tLRPC$ChatFull2;
    }

    public TLRPC$ChatFull loadChatInfo(int i, boolean z, CountDownLatch countDownLatch, boolean z2, boolean z3) {
        return loadChatInfo(i, z, countDownLatch, z2, z3, 0L);
    }

    public TLRPC$ChatFull loadChatInfo(final int i, final boolean z, final CountDownLatch countDownLatch, final boolean z2, final boolean z3, final long j) {
        final TLRPC$ChatFull[] tLRPC$ChatFullArr = new TLRPC$ChatFull[1];
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda151
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadChatInfo$71(tLRPC$ChatFullArr, i, z, z2, z3, j, countDownLatch);
            }
        });
        if (countDownLatch != null) {
            try {
                countDownLatch.await();
            } catch (Throwable unused) {
            }
        }
        return tLRPC$ChatFullArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadChatInfo$71(TLRPC$ChatFull[] tLRPC$ChatFullArr, int i, boolean z, boolean z2, boolean z3, long j, CountDownLatch countDownLatch) {
        tLRPC$ChatFullArr[0] = loadChatInfoInternal(i, z, z2, z3, j);
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    public void processPendingRead(final long j, final long j2, final long j3, final boolean z, final int i) {
        final int i2 = this.lastSavedDate;
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda68
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processPendingRead$72(j, j2, z, i, i2, j3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processPendingRead$72(long j, long j2, boolean z, int i, int i2, long j3) {
        long j4;
        long jLongValue;
        int iIntValue;
        int i3;
        long jMax;
        try {
            int iMax = 0;
            SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized("SELECT unread_count, inbox_max, last_mid FROM dialogs WHERE did = " + j, new Object[0]);
            if (sQLiteCursorQueryFinalized.next()) {
                iIntValue = sQLiteCursorQueryFinalized.intValue(0);
                long jIntValue = sQLiteCursorQueryFinalized.intValue(1);
                jLongValue = sQLiteCursorQueryFinalized.longValue(2);
                j4 = jIntValue;
                i3 = iIntValue;
            } else {
                j4 = 0;
                jLongValue = 0;
                iIntValue = 0;
                i3 = 0;
            }
            sQLiteCursorQueryFinalized.dispose();
            this.database.beginTransaction();
            if (((int) j) != 0) {
                jMax = Math.max(j4, (int) j2);
                if (z) {
                    jMax |= (-r0) << 32;
                }
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("UPDATE messages SET read_state = read_state | 1 WHERE uid = ? AND mid <= ? AND read_state IN(0,2) AND out = 0");
                sQLitePreparedStatementExecuteFast.requery();
                sQLitePreparedStatementExecuteFast.bindLong(1, j);
                sQLitePreparedStatementExecuteFast.bindLong(2, jMax);
                sQLitePreparedStatementExecuteFast.step();
                sQLitePreparedStatementExecuteFast.dispose();
                if (jMax < jLongValue) {
                    SQLiteCursor sQLiteCursorQueryFinalized2 = this.database.queryFinalized("SELECT changes()", new Object[0]);
                    int iIntValue2 = sQLiteCursorQueryFinalized2.next() ? sQLiteCursorQueryFinalized2.intValue(0) + i : 0;
                    sQLiteCursorQueryFinalized2.dispose();
                    iMax = Math.max(0, iIntValue - iIntValue2);
                }
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast2 = this.database.executeFast("DELETE FROM unread_push_messages WHERE uid = ? AND mid <= ?");
                sQLitePreparedStatementExecuteFast2.requery();
                sQLitePreparedStatementExecuteFast2.bindLong(1, j);
                sQLitePreparedStatementExecuteFast2.bindLong(2, jMax);
                sQLitePreparedStatementExecuteFast2.step();
                sQLitePreparedStatementExecuteFast2.dispose();
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast3 = this.database.executeFast("DELETE FROM unread_push_messages WHERE uid = ? AND date <= ?");
                sQLitePreparedStatementExecuteFast3.requery();
                sQLitePreparedStatementExecuteFast3.bindLong(1, j);
                sQLitePreparedStatementExecuteFast3.bindLong(2, i2);
                sQLitePreparedStatementExecuteFast3.step();
                sQLitePreparedStatementExecuteFast3.dispose();
            } else {
                jMax = (int) j3;
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast4 = this.database.executeFast("UPDATE messages SET read_state = read_state | 1 WHERE uid = ? AND mid >= ? AND read_state IN(0,2) AND out = 0");
                sQLitePreparedStatementExecuteFast4.requery();
                sQLitePreparedStatementExecuteFast4.bindLong(1, j);
                sQLitePreparedStatementExecuteFast4.bindLong(2, jMax);
                sQLitePreparedStatementExecuteFast4.step();
                sQLitePreparedStatementExecuteFast4.dispose();
                if (jMax > jLongValue) {
                    SQLiteCursor sQLiteCursorQueryFinalized3 = this.database.queryFinalized("SELECT changes()", new Object[0]);
                    int iIntValue3 = sQLiteCursorQueryFinalized3.next() ? sQLiteCursorQueryFinalized3.intValue(0) + i : 0;
                    sQLiteCursorQueryFinalized3.dispose();
                    iMax = Math.max(0, iIntValue - iIntValue3);
                }
            }
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast5 = this.database.executeFast("UPDATE dialogs SET unread_count = ?, inbox_max = ? WHERE did = ?");
            sQLitePreparedStatementExecuteFast5.requery();
            sQLitePreparedStatementExecuteFast5.bindInteger(1, iMax);
            sQLitePreparedStatementExecuteFast5.bindInteger(2, (int) jMax);
            sQLitePreparedStatementExecuteFast5.bindLong(3, j);
            sQLitePreparedStatementExecuteFast5.step();
            sQLitePreparedStatementExecuteFast5.dispose();
            this.database.commitTransaction();
            if (i3 != 0 && iMax == 0) {
                LongSparseArray<Integer> longSparseArray = new LongSparseArray<>();
                longSparseArray.put(j, Integer.valueOf(iMax));
                updateFiltersReadCounter(longSparseArray, null, true);
            }
            updateWidgets(j);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void putContacts(ArrayList<TLRPC$TL_contact> arrayList, final boolean z) {
        if (!arrayList.isEmpty() || z) {
            final ArrayList arrayList2 = new ArrayList(arrayList);
            this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda147
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$putContacts$73(z, arrayList2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$putContacts$73(boolean z, ArrayList arrayList) {
        if (z) {
            try {
                this.database.executeFast("DELETE FROM contacts WHERE 1").stepThis().dispose();
            } catch (Exception e) {
                FileLog.e(e);
                return;
            }
        }
        this.database.beginTransaction();
        SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("REPLACE INTO contacts VALUES(?, ?)");
        for (int i = 0; i < arrayList.size(); i++) {
            TLRPC$TL_contact tLRPC$TL_contact = (TLRPC$TL_contact) arrayList.get(i);
            sQLitePreparedStatementExecuteFast.requery();
            int i2 = 1;
            sQLitePreparedStatementExecuteFast.bindInteger(1, tLRPC$TL_contact.user_id);
            if (!tLRPC$TL_contact.mutual) {
                i2 = 0;
            }
            sQLitePreparedStatementExecuteFast.bindInteger(2, i2);
            sQLitePreparedStatementExecuteFast.step();
        }
        sQLitePreparedStatementExecuteFast.dispose();
        this.database.commitTransaction();
    }

    public void deleteContacts(final ArrayList<Integer> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda88
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$deleteContacts$74(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteContacts$74(ArrayList arrayList) {
        try {
            String strJoin = TextUtils.join(",", arrayList);
            this.database.executeFast("DELETE FROM contacts WHERE uid IN(" + strJoin + ")").stepThis().dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void applyPhoneBookUpdates(final String str, final String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda85
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$applyPhoneBookUpdates$75(str, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$applyPhoneBookUpdates$75(String str, String str2) {
        try {
            if (str.length() != 0) {
                this.database.executeFast(String.format(Locale.US, "UPDATE user_phones_v7 SET deleted = 0 WHERE sphone IN(%s)", str)).stepThis().dispose();
            }
            if (str2.length() != 0) {
                this.database.executeFast(String.format(Locale.US, "UPDATE user_phones_v7 SET deleted = 1 WHERE sphone IN(%s)", str2)).stepThis().dispose();
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void putCachedPhoneBook(final HashMap<String, ContactsController.Contact> map, final boolean z, boolean z2) {
        if (map != null) {
            if (!map.isEmpty() || z || z2) {
                this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda116
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$putCachedPhoneBook$76(map, z);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$putCachedPhoneBook$76(HashMap map, boolean z) {
        try {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d(this.currentAccount + " save contacts to db " + map.size());
            }
            this.database.executeFast("DELETE FROM user_contacts_v7 WHERE 1").stepThis().dispose();
            this.database.executeFast("DELETE FROM user_phones_v7 WHERE 1").stepThis().dispose();
            this.database.beginTransaction();
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("REPLACE INTO user_contacts_v7 VALUES(?, ?, ?, ?, ?)");
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast2 = this.database.executeFast("REPLACE INTO user_phones_v7 VALUES(?, ?, ?, ?)");
            Iterator it = map.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ContactsController.Contact contact = (ContactsController.Contact) ((Map.Entry) it.next()).getValue();
                if (!contact.phones.isEmpty() && !contact.shortPhones.isEmpty()) {
                    sQLitePreparedStatementExecuteFast.requery();
                    sQLitePreparedStatementExecuteFast.bindString(1, contact.key);
                    sQLitePreparedStatementExecuteFast.bindInteger(2, contact.contact_id);
                    sQLitePreparedStatementExecuteFast.bindString(3, contact.first_name);
                    sQLitePreparedStatementExecuteFast.bindString(4, contact.last_name);
                    sQLitePreparedStatementExecuteFast.bindInteger(5, contact.imported);
                    sQLitePreparedStatementExecuteFast.step();
                    for (int i = 0; i < contact.phones.size(); i++) {
                        sQLitePreparedStatementExecuteFast2.requery();
                        sQLitePreparedStatementExecuteFast2.bindString(1, contact.key);
                        sQLitePreparedStatementExecuteFast2.bindString(2, contact.phones.get(i));
                        sQLitePreparedStatementExecuteFast2.bindString(3, contact.shortPhones.get(i));
                        sQLitePreparedStatementExecuteFast2.bindInteger(4, contact.phoneDeleted.get(i).intValue());
                        sQLitePreparedStatementExecuteFast2.step();
                    }
                }
            }
            sQLitePreparedStatementExecuteFast.dispose();
            sQLitePreparedStatementExecuteFast2.dispose();
            this.database.commitTransaction();
            if (z) {
                this.database.executeFast("DROP TABLE IF EXISTS user_contacts_v6;").stepThis().dispose();
                this.database.executeFast("DROP TABLE IF EXISTS user_phones_v6;").stepThis().dispose();
                getCachedPhoneBook(false);
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void getCachedPhoneBook(final boolean z) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda142
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getCachedPhoneBook$77(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f9 A[Catch: all -> 0x0132, TRY_LEAVE, TryCatch #2 {all -> 0x0132, blocks: (B:51:0x00e9, B:53:0x00f9), top: B:132:0x00e9 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x012e A[PHI: r3 r8 r10 r14
      0x012e: PHI (r3v11 int) = (r3v3 int), (r3v13 int), (r3v14 int), (r3v14 int) binds: [B:72:0x013a, B:66:0x012a, B:59:0x010a, B:60:0x010c] A[DONT_GENERATE, DONT_INLINE]
      0x012e: PHI (r8v19 int) = (r8v1 int), (r8v21 int), (r8v22 int), (r8v22 int) binds: [B:72:0x013a, B:66:0x012a, B:59:0x010a, B:60:0x010c] A[DONT_GENERATE, DONT_INLINE]
      0x012e: PHI (r10v9 org.rbmain.SQLite.SQLiteCursor) = 
      (r10v4 org.rbmain.SQLite.SQLiteCursor)
      (r10v10 org.rbmain.SQLite.SQLiteCursor)
      (r10v10 org.rbmain.SQLite.SQLiteCursor)
      (r10v10 org.rbmain.SQLite.SQLiteCursor)
     binds: [B:72:0x013a, B:66:0x012a, B:59:0x010a, B:60:0x010c] A[DONT_GENERATE, DONT_INLINE]
      0x012e: PHI (r14v8 int) = (r14v1 int), (r14v9 int), (r14v11 int), (r14v11 int) binds: [B:72:0x013a, B:66:0x012a, B:59:0x010a, B:60:0x010c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0144 A[Catch: all -> 0x01ee, Exception -> 0x01f0, TRY_ENTER, TryCatch #0 {Exception -> 0x01f0, blocks: (B:76:0x0144, B:79:0x0169, B:81:0x016f, B:83:0x017b, B:85:0x019d, B:86:0x019f, B:88:0x01a3, B:89:0x01a5, B:90:0x01a8, B:93:0x01b0, B:96:0x01bc, B:98:0x01c2, B:100:0x01c8, B:101:0x01cc, B:103:0x01ea, B:77:0x015e), top: B:128:0x0142, outer: #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x015e A[Catch: all -> 0x01ee, Exception -> 0x01f0, TryCatch #0 {Exception -> 0x01f0, blocks: (B:76:0x0144, B:79:0x0169, B:81:0x016f, B:83:0x017b, B:85:0x019d, B:86:0x019f, B:88:0x01a3, B:89:0x01a5, B:90:0x01a8, B:93:0x01b0, B:96:0x01bc, B:98:0x01c2, B:100:0x01c8, B:101:0x01cc, B:103:0x01ea, B:77:0x015e), top: B:128:0x0142, outer: #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x016f A[Catch: all -> 0x01ee, Exception -> 0x01f0, TryCatch #0 {Exception -> 0x01f0, blocks: (B:76:0x0144, B:79:0x0169, B:81:0x016f, B:83:0x017b, B:85:0x019d, B:86:0x019f, B:88:0x01a3, B:89:0x01a5, B:90:0x01a8, B:93:0x01b0, B:96:0x01bc, B:98:0x01c2, B:100:0x01c8, B:101:0x01cc, B:103:0x01ea, B:77:0x015e), top: B:128:0x0142, outer: #8 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$getCachedPhoneBook$77(boolean r25) {
        /*
            Method dump skipped, instructions count: 554
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.MessagesStorage.lambda$getCachedPhoneBook$77(boolean):void");
    }

    public void getContacts() {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getContacts$78();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getContacts$78() {
        ArrayList<TLRPC$TL_contact> arrayList = new ArrayList<>();
        ArrayList<TLRPC$User> arrayList2 = new ArrayList<>();
        try {
            SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized("SELECT * FROM contacts WHERE 1", new Object[0]);
            StringBuilder sb = new StringBuilder();
            while (sQLiteCursorQueryFinalized.next()) {
                int iIntValue = sQLiteCursorQueryFinalized.intValue(0);
                TLRPC$TL_contact tLRPC$TL_contact = new TLRPC$TL_contact();
                tLRPC$TL_contact.user_id = iIntValue;
                tLRPC$TL_contact.mutual = sQLiteCursorQueryFinalized.intValue(1) == 1;
                if (sb.length() != 0) {
                    sb.append(",");
                }
                arrayList.add(tLRPC$TL_contact);
                sb.append(tLRPC$TL_contact.user_id);
            }
            sQLiteCursorQueryFinalized.dispose();
            if (sb.length() != 0) {
                getUsersInternal(sb.toString(), arrayList2);
            }
        } catch (Exception e) {
            arrayList.clear();
            arrayList2.clear();
            FileLog.e(e);
        }
        getContactsController().processLoadedContacts(arrayList, arrayList2, 1);
    }

    public void getUnsentMessages(final int i) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda18
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getUnsentMessages$79(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0203  */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r12v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$getUnsentMessages$79(int r22) {
        /*
            Method dump skipped, instructions count: 617
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.MessagesStorage.lambda$getUnsentMessages$79(int):void");
    }

    public boolean checkMessageByRandomId(final long j) throws InterruptedException {
        final boolean[] zArr = new boolean[1];
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda80
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$checkMessageByRandomId$80(j, zArr, countDownLatch);
            }
        });
        try {
            countDownLatch.await();
        } catch (Exception e) {
            FileLog.e(e);
        }
        return zArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkMessageByRandomId$80(long j, boolean[] zArr, CountDownLatch countDownLatch) {
        SQLiteCursor sQLiteCursorQueryFinalized = null;
        try {
            try {
                sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT random_id FROM randoms WHERE random_id = %d", Long.valueOf(j)), new Object[0]);
                if (sQLiteCursorQueryFinalized.next()) {
                    zArr[0] = true;
                }
            } catch (Exception e) {
                FileLog.e(e);
                if (sQLiteCursorQueryFinalized != null) {
                }
            }
            sQLiteCursorQueryFinalized.dispose();
            countDownLatch.countDown();
        } catch (Throwable th) {
            if (sQLiteCursorQueryFinalized != null) {
                sQLiteCursorQueryFinalized.dispose();
            }
            throw th;
        }
    }

    public boolean checkMessageId(final long j, final boolean z, final long j2) throws InterruptedException {
        final boolean[] zArr = new boolean[1];
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda79
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$checkMessageId$81(j2, z, j, zArr, countDownLatch);
            }
        });
        try {
            countDownLatch.await();
        } catch (Exception e) {
            FileLog.e(e);
        }
        return zArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkMessageId$81(long j, boolean z, long j2, boolean[] zArr, CountDownLatch countDownLatch) {
        if (z) {
            j |= (-j2) << 32;
        }
        SQLiteCursor sQLiteCursorQueryFinalized = null;
        try {
            try {
                sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT mid FROM messages WHERE uid = %d AND mid = %d", Long.valueOf(j2), Long.valueOf(j)), new Object[0]);
                if (sQLiteCursorQueryFinalized.next()) {
                    zArr[0] = true;
                }
            } catch (Exception e) {
                FileLog.e(e);
                if (sQLiteCursorQueryFinalized != null) {
                }
            }
            sQLiteCursorQueryFinalized.dispose();
            countDownLatch.countDown();
        } catch (Throwable th) {
            if (sQLiteCursorQueryFinalized != null) {
                sQLiteCursorQueryFinalized.dispose();
            }
            throw th;
        }
    }

    public void getUnreadMention(final long j, final IntCallback intCallback) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda74
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getUnreadMention$83(j, intCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getUnreadMention$83(long j, final IntCallback intCallback) {
        try {
            SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT MIN(mid) FROM messages WHERE uid = %d AND mention = 1 AND read_state IN(0, 1)", Long.valueOf(j)), new Object[0]);
            final int iIntValue = sQLiteCursorQueryFinalized.next() ? sQLiteCursorQueryFinalized.intValue(0) : 0;
            sQLiteCursorQueryFinalized.dispose();
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    intCallback.run(iIntValue);
                }
            });
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void getMessagesCount(final long j, final IntCallback intCallback) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda75
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getMessagesCount$85(j, intCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getMessagesCount$85(long j, final IntCallback intCallback) {
        try {
            SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT COUNT(mid) FROM messages WHERE uid = %d", Long.valueOf(j)), new Object[0]);
            final int iIntValue = sQLiteCursorQueryFinalized.next() ? sQLiteCursorQueryFinalized.intValue(0) : 0;
            sQLiteCursorQueryFinalized.dispose();
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    intCallback.run(iIntValue);
                }
            });
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:96)
        */
    /* JADX WARN: Not initialized variable reg: 37, insn: 0x04f1: MOVE (r34 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r37 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:222:0x04ec */
    public java.lang.Runnable getMessagesInternal(long r50, long r52, int r54, long r55, int r57, int r58, int r59, int r60, boolean r61, boolean r62, long r63, int r65, boolean r66) {
        /*
            Method dump skipped, instructions count: 5723
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.MessagesStorage.getMessagesInternal(long, long, int, long, int, int, int, int, boolean, boolean, long, int, boolean):java.lang.Runnable");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$getMessagesInternal$86(TLRPC$Message tLRPC$Message, TLRPC$Message tLRPC$Message2) {
        long j = tLRPC$Message.id;
        if (j > 0) {
            long j2 = tLRPC$Message2.id;
            if (j2 > 0) {
                if (j > j2) {
                    return -1;
                }
                return j < j2 ? 1 : 0;
            }
        }
        if (j < 0) {
            long j3 = tLRPC$Message2.id;
            if (j3 < 0) {
                if (j < j3) {
                    return -1;
                }
                return j > j3 ? 1 : 0;
            }
        }
        int i = tLRPC$Message.date;
        int i2 = tLRPC$Message2.date;
        if (i > i2) {
            return -1;
        }
        return i < i2 ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getMessagesInternal$87(TLRPC$TL_messages_messages tLRPC$TL_messages_messages, int i, long j, long j2, int i2, long j3, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z, boolean z2, boolean z3, long j4, int i10, boolean z4, int i11, boolean z5) {
        getMessagesController().processLoadedMessages(tLRPC$TL_messages_messages, i, j, j2, i2, j3, i3, true, i4, i5, i6, i7, i8, i9, z, z2, z3 ? 1 : 0, j4, i10, z4, i11, z5, null);
    }

    public void getMessages(final long j, final long j2, boolean z, final int i, final long j3, final int i2, final int i3, final int i4, final int i5, final boolean z2, final boolean z3, final long j4, final int i6, final boolean z4) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda67
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getMessages$88(j2, j, i, j3, i2, i3, i4, i5, z2, z3, j4, i6, z4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getMessages$88(long j, long j2, int i, long j3, int i2, int i3, int i4, int i5, boolean z, boolean z2, long j4, int i6, boolean z3) {
        Utilities.stageQueue.postRunnable(getMessagesInternal(j2, j, i, j3, i2, i3, i4, i5, z, z2, j4, i6, z3));
    }

    public void clearSentMedia() {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$clearSentMedia$89();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$clearSentMedia$89() {
        try {
            this.database.executeFast("DELETE FROM sent_files_v2 WHERE 1").stepThis().dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public Object[] getSentFile(final String str, int i) throws InterruptedException {
        if (str == null || str.toLowerCase().endsWith("attheme")) {
            return null;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final Object[] objArr = new Object[2];
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda87
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getSentFile$90(str, objArr, countDownLatch);
            }
        });
        try {
            countDownLatch.await();
        } catch (Exception e) {
            FileLog.e(e);
        }
        if (objArr[0] != null) {
            return objArr;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getSentFile$90(String str, Object[] objArr, CountDownLatch countDownLatch) {
        try {
            try {
                String strMD5 = Utilities.MD5(str);
                if (strMD5 != null) {
                    TLRPC$MessageMedia sentFile = FileLoadProxy.getInstance(this.currentAccount).getSentFile(strMD5);
                    if (sentFile instanceof TLRPC$TL_messageMediaDocument) {
                        objArr[0] = ((TLRPC$TL_messageMediaDocument) sentFile).document;
                    } else if (sentFile instanceof TLRPC$TL_messageMediaPhoto) {
                        objArr[0] = ((TLRPC$TL_messageMediaPhoto) sentFile).photo;
                    }
                }
            } catch (Exception e) {
                FileLog.e(e);
            }
        } finally {
            countDownLatch.countDown();
        }
    }

    private void updateWidgets(long j) {
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(Long.valueOf(j));
        updateWidgets(arrayList);
    }

    private void updateWidgets(ArrayList<Long> arrayList) {
        if (arrayList.isEmpty()) {
            return;
        }
        AppWidgetManager appWidgetManager = null;
        try {
            TextUtils.join(",", arrayList);
            SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT DISTINCT id FROM shortcut_widget WHERE did IN(%s,-1)", TextUtils.join(",", arrayList)), new Object[0]);
            while (sQLiteCursorQueryFinalized.next()) {
                if (appWidgetManager == null) {
                    appWidgetManager = AppWidgetManager.getInstance(ApplicationLoader.applicationContext);
                }
                appWidgetManager.notifyAppWidgetViewDataChanged(sQLiteCursorQueryFinalized.intValue(0), ir.medu.shad.R.id.list_view);
            }
            sQLiteCursorQueryFinalized.dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void putWidgetDialogs(final int i, final ArrayList<Long> arrayList) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda45
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$putWidgetDialogs$91(i, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$putWidgetDialogs$91(int i, ArrayList arrayList) {
        try {
            this.database.beginTransaction();
            this.database.executeFast("DELETE FROM shortcut_widget WHERE id = " + i).stepThis().dispose();
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("REPLACE INTO shortcut_widget VALUES(?, ?, ?)");
            if (arrayList.isEmpty()) {
                sQLitePreparedStatementExecuteFast.requery();
                sQLitePreparedStatementExecuteFast.bindInteger(1, i);
                sQLitePreparedStatementExecuteFast.bindLong(2, -1L);
                sQLitePreparedStatementExecuteFast.bindInteger(3, 0);
                sQLitePreparedStatementExecuteFast.step();
            } else {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    long jLongValue = ((Long) arrayList.get(i2)).longValue();
                    sQLitePreparedStatementExecuteFast.requery();
                    sQLitePreparedStatementExecuteFast.bindInteger(1, i);
                    sQLitePreparedStatementExecuteFast.bindLong(2, jLongValue);
                    sQLitePreparedStatementExecuteFast.bindInteger(3, i2);
                    sQLitePreparedStatementExecuteFast.step();
                }
            }
            sQLitePreparedStatementExecuteFast.dispose();
            this.database.commitTransaction();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void clearWidgetDialogs(final int i) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$clearWidgetDialogs$92(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$clearWidgetDialogs$92(int i) {
        try {
            this.database.executeFast("DELETE FROM shortcut_widget WHERE id = " + i).stepThis().dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void getWidgetDialogIds(final int i, final int i2, final ArrayList<Long> arrayList, final ArrayList<TLRPC$User> arrayList2, final ArrayList<TLRPC$Chat> arrayList3, final boolean z) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda47
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getWidgetDialogIds$93(i, arrayList, arrayList2, arrayList3, z, i2, countDownLatch);
            }
        });
        try {
            countDownLatch.await();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getWidgetDialogIds$93(int i, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, boolean z, int i2, CountDownLatch countDownLatch) {
        try {
            try {
                ArrayList arrayList4 = new ArrayList();
                ArrayList arrayList5 = new ArrayList();
                SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT did FROM shortcut_widget WHERE id = %d ORDER BY ord ASC", Integer.valueOf(i)), new Object[0]);
                while (sQLiteCursorQueryFinalized.next()) {
                    long jLongValue = sQLiteCursorQueryFinalized.longValue(0);
                    if (jLongValue != -1) {
                        arrayList.add(Long.valueOf(jLongValue));
                        if (arrayList2 != null && arrayList3 != null) {
                            int i3 = (int) jLongValue;
                            if (i3 > 0) {
                                arrayList4.add(Integer.valueOf(i3));
                            } else {
                                arrayList5.add(Integer.valueOf(-i3));
                            }
                        }
                    }
                }
                sQLiteCursorQueryFinalized.dispose();
                if (!z && arrayList.isEmpty()) {
                    if (i2 == 0) {
                        SQLiteCursor sQLiteCursorQueryFinalized2 = this.database.queryFinalized("SELECT did FROM dialogs WHERE folder_id = 0 ORDER BY pinned DESC, date DESC LIMIT 0,10", new Object[0]);
                        while (sQLiteCursorQueryFinalized2.next()) {
                            long jLongValue2 = sQLiteCursorQueryFinalized2.longValue(0);
                            if (!DialogObject.isFolderDialogId(jLongValue2)) {
                                arrayList.add(Long.valueOf(jLongValue2));
                                if (arrayList2 != null && arrayList3 != null) {
                                    int i4 = (int) jLongValue2;
                                    if (i4 > 0) {
                                        arrayList4.add(Integer.valueOf(i4));
                                    } else {
                                        arrayList5.add(Integer.valueOf(-i4));
                                    }
                                }
                            }
                        }
                        sQLiteCursorQueryFinalized2.dispose();
                    } else {
                        SQLiteCursor sQLiteCursorQueryFinalized3 = getMessagesStorage().getDatabase().queryFinalized("SELECT did FROM chat_hints WHERE type = 0 ORDER BY rating DESC LIMIT 4", new Object[0]);
                        while (sQLiteCursorQueryFinalized3.next()) {
                            long jLongValue3 = sQLiteCursorQueryFinalized3.longValue(0);
                            arrayList.add(Long.valueOf(jLongValue3));
                            if (arrayList2 != null && arrayList3 != null) {
                                int i5 = (int) jLongValue3;
                                if (i5 > 0) {
                                    arrayList4.add(Integer.valueOf(i5));
                                } else {
                                    arrayList5.add(Integer.valueOf(-i5));
                                }
                            }
                        }
                        sQLiteCursorQueryFinalized3.dispose();
                    }
                }
                if (arrayList2 != null && arrayList3 != null) {
                    if (!arrayList5.isEmpty()) {
                        getChatsInternal(TextUtils.join(",", arrayList5), arrayList3);
                    }
                    if (!arrayList4.isEmpty()) {
                        getUsersInternal(TextUtils.join(",", arrayList4), arrayList2);
                    }
                }
            } catch (Exception e) {
                FileLog.e(e);
            }
        } finally {
            countDownLatch.countDown();
        }
    }

    public void getWidgetDialogs(final int i, final int i2, final ArrayList<Long> arrayList, final LongSparseArray<TLRPC$Dialog> longSparseArray, final LongSparseArray<TLRPC$Message> longSparseArray2, final ArrayList<TLRPC$User> arrayList2, final ArrayList<TLRPC$Chat> arrayList3) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda46
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getWidgetDialogs$94(i, arrayList, i2, longSparseArray, longSparseArray2, arrayList3, arrayList2, countDownLatch);
            }
        });
        try {
            countDownLatch.await();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getWidgetDialogs$94(int i, ArrayList arrayList, int i2, LongSparseArray longSparseArray, LongSparseArray longSparseArray2, ArrayList arrayList2, ArrayList arrayList3, CountDownLatch countDownLatch) {
        SQLiteCursor sQLiteCursorQueryFinalized;
        boolean z;
        try {
            try {
                ArrayList arrayList4 = new ArrayList();
                ArrayList arrayList5 = new ArrayList();
                SQLiteCursor sQLiteCursorQueryFinalized2 = this.database.queryFinalized(String.format(Locale.US, "SELECT did FROM shortcut_widget WHERE id = %d ORDER BY ord ASC", Integer.valueOf(i)), new Object[0]);
                while (sQLiteCursorQueryFinalized2.next()) {
                    long jLongValue = sQLiteCursorQueryFinalized2.longValue(0);
                    if (jLongValue != -1) {
                        arrayList.add(Long.valueOf(jLongValue));
                        int i3 = (int) jLongValue;
                        if (i3 > 0) {
                            arrayList4.add(Integer.valueOf(i3));
                        } else {
                            arrayList5.add(Integer.valueOf(-i3));
                        }
                    }
                }
                sQLiteCursorQueryFinalized2.dispose();
                if (arrayList.isEmpty() && i2 == 1) {
                    SQLiteCursor sQLiteCursorQueryFinalized3 = getMessagesStorage().getDatabase().queryFinalized("SELECT did FROM chat_hints WHERE type = 0 ORDER BY rating DESC LIMIT 4", new Object[0]);
                    while (sQLiteCursorQueryFinalized3.next()) {
                        long jLongValue2 = sQLiteCursorQueryFinalized3.longValue(0);
                        arrayList.add(Long.valueOf(jLongValue2));
                        int i4 = (int) jLongValue2;
                        if (i4 > 0) {
                            arrayList4.add(Integer.valueOf(i4));
                        } else {
                            arrayList5.add(Integer.valueOf(-i4));
                        }
                    }
                    sQLiteCursorQueryFinalized3.dispose();
                }
                if (arrayList.isEmpty()) {
                    sQLiteCursorQueryFinalized = this.database.queryFinalized("SELECT d.did, d.last_mid, d.unread_count, d.date, m.data, m.read_state, m.mid, m.send_state, m.date FROM dialogs as d LEFT JOIN messages as m ON d.last_mid = m.mid WHERE d.folder_id = 0 ORDER BY d.pinned DESC, d.date DESC LIMIT 0,10", new Object[0]);
                    z = true;
                } else {
                    sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT d.did, d.last_mid, d.unread_count, d.date, m.data, m.read_state, m.mid, m.send_state, m.date FROM dialogs as d LEFT JOIN messages as m ON d.last_mid = m.mid WHERE d.did IN(%s)", TextUtils.join(",", arrayList)), new Object[0]);
                    z = false;
                }
                while (sQLiteCursorQueryFinalized.next()) {
                    long jLongValue3 = sQLiteCursorQueryFinalized.longValue(0);
                    if (!DialogObject.isFolderDialogId(jLongValue3)) {
                        if (z) {
                            arrayList.add(Long.valueOf(jLongValue3));
                        }
                        TLRPC$TL_dialog tLRPC$TL_dialog = new TLRPC$TL_dialog();
                        tLRPC$TL_dialog.id = jLongValue3;
                        tLRPC$TL_dialog.top_message = sQLiteCursorQueryFinalized.intValue(1);
                        tLRPC$TL_dialog.unread_count = sQLiteCursorQueryFinalized.intValue(2);
                        tLRPC$TL_dialog.last_message_date = sQLiteCursorQueryFinalized.intValue(3);
                        longSparseArray.put(tLRPC$TL_dialog.id, tLRPC$TL_dialog);
                        NativeByteBuffer nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized.byteBufferValue(4);
                        if (nativeByteBufferByteBufferValue != null) {
                            TLRPC$Message tLRPC$MessageTLdeserialize = TLRPC$Message.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                            tLRPC$MessageTLdeserialize.readAttachPath(nativeByteBufferByteBufferValue, getUserConfig().clientUserId);
                            nativeByteBufferByteBufferValue.reuse();
                            MessageObject.setUnreadFlags(tLRPC$MessageTLdeserialize, sQLiteCursorQueryFinalized.intValue(5));
                            tLRPC$MessageTLdeserialize.id = sQLiteCursorQueryFinalized.intValue(6);
                            tLRPC$MessageTLdeserialize.send_state = sQLiteCursorQueryFinalized.intValue(7);
                            int iIntValue = sQLiteCursorQueryFinalized.intValue(8);
                            if (iIntValue != 0) {
                                tLRPC$TL_dialog.last_message_date = iIntValue;
                            }
                            long j = tLRPC$TL_dialog.id;
                            tLRPC$MessageTLdeserialize.dialog_id = j;
                            longSparseArray2.put(j, tLRPC$MessageTLdeserialize);
                            addUsersAndChatsFromMessage(tLRPC$MessageTLdeserialize, arrayList4, arrayList5);
                        }
                    }
                }
                sQLiteCursorQueryFinalized.dispose();
                if (!z && arrayList.size() > longSparseArray.size()) {
                    int size = arrayList.size();
                    for (int i5 = 0; i5 < size; i5++) {
                        long jLongValue4 = ((Long) arrayList.get(i5)).longValue();
                        if (longSparseArray.get(((Long) arrayList.get(i5)).longValue()) == null) {
                            TLRPC$TL_dialog tLRPC$TL_dialog2 = new TLRPC$TL_dialog();
                            tLRPC$TL_dialog2.id = jLongValue4;
                            longSparseArray.put(jLongValue4, tLRPC$TL_dialog2);
                            int i6 = (int) jLongValue4;
                            if (i6 < 0) {
                                int i7 = -i6;
                                if (arrayList5.contains(Integer.valueOf(i7))) {
                                    arrayList5.add(Integer.valueOf(i7));
                                }
                            } else if (arrayList4.contains(Integer.valueOf(i6))) {
                                arrayList4.add(Integer.valueOf(i6));
                            }
                        }
                    }
                }
                if (!arrayList5.isEmpty()) {
                    getChatsInternal(TextUtils.join(",", arrayList5), arrayList2);
                }
                if (!arrayList4.isEmpty()) {
                    getUsersInternal(TextUtils.join(",", arrayList4), arrayList3);
                }
            } catch (Exception e) {
                FileLog.e(e);
            }
        } finally {
            countDownLatch.countDown();
        }
    }

    public void putSentFile(final String str, final TLObject tLObject, int i, String str2) {
        if (str == null || tLObject == null || str2 == null) {
            return;
        }
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda86
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$putSentFile$95(str, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$putSentFile$95(String str, TLObject tLObject) {
        try {
            String strMD5 = Utilities.MD5(str);
            if (strMD5 != null) {
                TLRPC$MessageMedia tLRPC$TL_messageMediaDocument = null;
                if (tLObject instanceof TLRPC$Photo) {
                    tLRPC$TL_messageMediaDocument = new TLRPC$TL_messageMediaPhoto();
                    tLRPC$TL_messageMediaDocument.photo = (TLRPC$Photo) tLObject;
                    tLRPC$TL_messageMediaDocument.flags |= 1;
                } else if (tLObject instanceof TLRPC$Document) {
                    tLRPC$TL_messageMediaDocument = new TLRPC$TL_messageMediaDocument();
                    tLRPC$TL_messageMediaDocument.document = (TLRPC$Document) tLObject;
                    tLRPC$TL_messageMediaDocument.flags |= 1;
                }
                if (tLRPC$TL_messageMediaDocument == null) {
                    return;
                }
                FileLoadProxy.getInstance(this.currentAccount).saveSentFile(strMD5, tLRPC$TL_messageMediaDocument);
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void updateEncryptedChatSeq(final TLRPC$EncryptedChat tLRPC$EncryptedChat, final boolean z) {
        if (tLRPC$EncryptedChat == null) {
            return;
        }
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda131
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateEncryptedChatSeq$96(tLRPC$EncryptedChat, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateEncryptedChatSeq$96(TLRPC$EncryptedChat tLRPC$EncryptedChat, boolean z) {
        SQLitePreparedStatement sQLitePreparedStatementExecuteFast = null;
        try {
            try {
                sQLitePreparedStatementExecuteFast = this.database.executeFast("UPDATE enc_chats SET seq_in = ?, seq_out = ?, use_count = ?, in_seq_no = ?, mtproto_seq = ? WHERE uid = ?");
                sQLitePreparedStatementExecuteFast.bindInteger(1, tLRPC$EncryptedChat.seq_in);
                sQLitePreparedStatementExecuteFast.bindInteger(2, tLRPC$EncryptedChat.seq_out);
                sQLitePreparedStatementExecuteFast.bindInteger(3, (tLRPC$EncryptedChat.key_use_count_in << 16) | tLRPC$EncryptedChat.key_use_count_out);
                sQLitePreparedStatementExecuteFast.bindInteger(4, tLRPC$EncryptedChat.in_seq_no);
                sQLitePreparedStatementExecuteFast.bindInteger(5, tLRPC$EncryptedChat.mtproto_seq);
                sQLitePreparedStatementExecuteFast.bindInteger(6, tLRPC$EncryptedChat.id);
                sQLitePreparedStatementExecuteFast.step();
                if (z && tLRPC$EncryptedChat.in_seq_no != 0) {
                    this.database.executeFast(String.format(Locale.US, "DELETE FROM messages WHERE mid IN (SELECT m.mid FROM messages as m LEFT JOIN messages_seq as s ON m.mid = s.mid WHERE m.uid = %d AND m.date = 0 AND m.mid < 0 AND s.seq_out <= %d)", Long.valueOf(tLRPC$EncryptedChat.id << 32), Integer.valueOf(tLRPC$EncryptedChat.in_seq_no))).stepThis().dispose();
                }
            } catch (Exception e) {
                FileLog.e(e);
                if (sQLitePreparedStatementExecuteFast == null) {
                    return;
                }
            }
            sQLitePreparedStatementExecuteFast.dispose();
        } catch (Throwable th) {
            if (sQLitePreparedStatementExecuteFast != null) {
                sQLitePreparedStatementExecuteFast.dispose();
            }
            throw th;
        }
    }

    public void updateEncryptedChatTTL(final TLRPC$EncryptedChat tLRPC$EncryptedChat) {
        if (tLRPC$EncryptedChat == null) {
            return;
        }
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda128
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateEncryptedChatTTL$97(tLRPC$EncryptedChat);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateEncryptedChatTTL$97(TLRPC$EncryptedChat tLRPC$EncryptedChat) {
        SQLitePreparedStatement sQLitePreparedStatementExecuteFast = null;
        try {
            try {
                sQLitePreparedStatementExecuteFast = this.database.executeFast("UPDATE enc_chats SET ttl = ? WHERE uid = ?");
                sQLitePreparedStatementExecuteFast.bindInteger(1, tLRPC$EncryptedChat.ttl);
                sQLitePreparedStatementExecuteFast.bindInteger(2, tLRPC$EncryptedChat.id);
                sQLitePreparedStatementExecuteFast.step();
            } catch (Exception e) {
                FileLog.e(e);
                if (sQLitePreparedStatementExecuteFast == null) {
                    return;
                }
            }
            sQLitePreparedStatementExecuteFast.dispose();
        } catch (Throwable th) {
            if (sQLitePreparedStatementExecuteFast != null) {
                sQLitePreparedStatementExecuteFast.dispose();
            }
            throw th;
        }
    }

    public void updateEncryptedChatLayer(final TLRPC$EncryptedChat tLRPC$EncryptedChat) {
        if (tLRPC$EncryptedChat == null) {
            return;
        }
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda127
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateEncryptedChatLayer$98(tLRPC$EncryptedChat);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateEncryptedChatLayer$98(TLRPC$EncryptedChat tLRPC$EncryptedChat) {
        SQLitePreparedStatement sQLitePreparedStatementExecuteFast = null;
        try {
            try {
                sQLitePreparedStatementExecuteFast = this.database.executeFast("UPDATE enc_chats SET layer = ? WHERE uid = ?");
                sQLitePreparedStatementExecuteFast.bindInteger(1, tLRPC$EncryptedChat.layer);
                sQLitePreparedStatementExecuteFast.bindInteger(2, tLRPC$EncryptedChat.id);
                sQLitePreparedStatementExecuteFast.step();
            } catch (Exception e) {
                FileLog.e(e);
                if (sQLitePreparedStatementExecuteFast == null) {
                    return;
                }
            }
            sQLitePreparedStatementExecuteFast.dispose();
        } catch (Throwable th) {
            if (sQLitePreparedStatementExecuteFast != null) {
                sQLitePreparedStatementExecuteFast.dispose();
            }
            throw th;
        }
    }

    public void updateEncryptedChat(final TLRPC$EncryptedChat tLRPC$EncryptedChat) {
        if (tLRPC$EncryptedChat == null) {
            return;
        }
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda129
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateEncryptedChat$99(tLRPC$EncryptedChat);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateEncryptedChat$99(TLRPC$EncryptedChat tLRPC$EncryptedChat) {
        byte[] bArr;
        SQLitePreparedStatement sQLitePreparedStatementExecuteFast = null;
        try {
            try {
                byte[] bArr2 = tLRPC$EncryptedChat.key_hash;
                if ((bArr2 == null || bArr2.length < 16) && (bArr = tLRPC$EncryptedChat.auth_key) != null) {
                    tLRPC$EncryptedChat.key_hash = AndroidUtilities.calcAuthKeyHash(bArr);
                }
                sQLitePreparedStatementExecuteFast = this.database.executeFast("UPDATE enc_chats SET data = ?, g = ?, authkey = ?, ttl = ?, layer = ?, seq_in = ?, seq_out = ?, use_count = ?, exchange_id = ?, key_date = ?, fprint = ?, fauthkey = ?, khash = ?, in_seq_no = ?, admin_id = ?, mtproto_seq = ? WHERE uid = ?");
                NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(tLRPC$EncryptedChat.getObjectSize());
                byte[] bArr3 = tLRPC$EncryptedChat.a_or_b;
                NativeByteBuffer nativeByteBuffer2 = new NativeByteBuffer(bArr3 != null ? bArr3.length : 1);
                byte[] bArr4 = tLRPC$EncryptedChat.auth_key;
                NativeByteBuffer nativeByteBuffer3 = new NativeByteBuffer(bArr4 != null ? bArr4.length : 1);
                byte[] bArr5 = tLRPC$EncryptedChat.future_auth_key;
                NativeByteBuffer nativeByteBuffer4 = new NativeByteBuffer(bArr5 != null ? bArr5.length : 1);
                byte[] bArr6 = tLRPC$EncryptedChat.key_hash;
                NativeByteBuffer nativeByteBuffer5 = new NativeByteBuffer(bArr6 != null ? bArr6.length : 1);
                tLRPC$EncryptedChat.serializeToStream(nativeByteBuffer);
                sQLitePreparedStatementExecuteFast.bindByteBuffer(1, nativeByteBuffer);
                byte[] bArr7 = tLRPC$EncryptedChat.a_or_b;
                if (bArr7 != null) {
                    nativeByteBuffer2.writeBytes(bArr7);
                }
                byte[] bArr8 = tLRPC$EncryptedChat.auth_key;
                if (bArr8 != null) {
                    nativeByteBuffer3.writeBytes(bArr8);
                }
                byte[] bArr9 = tLRPC$EncryptedChat.future_auth_key;
                if (bArr9 != null) {
                    nativeByteBuffer4.writeBytes(bArr9);
                }
                byte[] bArr10 = tLRPC$EncryptedChat.key_hash;
                if (bArr10 != null) {
                    nativeByteBuffer5.writeBytes(bArr10);
                }
                sQLitePreparedStatementExecuteFast.bindByteBuffer(2, nativeByteBuffer2);
                sQLitePreparedStatementExecuteFast.bindByteBuffer(3, nativeByteBuffer3);
                sQLitePreparedStatementExecuteFast.bindInteger(4, tLRPC$EncryptedChat.ttl);
                sQLitePreparedStatementExecuteFast.bindInteger(5, tLRPC$EncryptedChat.layer);
                sQLitePreparedStatementExecuteFast.bindInteger(6, tLRPC$EncryptedChat.seq_in);
                sQLitePreparedStatementExecuteFast.bindInteger(7, tLRPC$EncryptedChat.seq_out);
                sQLitePreparedStatementExecuteFast.bindInteger(8, (tLRPC$EncryptedChat.key_use_count_in << 16) | tLRPC$EncryptedChat.key_use_count_out);
                sQLitePreparedStatementExecuteFast.bindLong(9, tLRPC$EncryptedChat.exchange_id);
                sQLitePreparedStatementExecuteFast.bindInteger(10, tLRPC$EncryptedChat.key_create_date);
                sQLitePreparedStatementExecuteFast.bindLong(11, tLRPC$EncryptedChat.future_key_fingerprint);
                sQLitePreparedStatementExecuteFast.bindByteBuffer(12, nativeByteBuffer4);
                sQLitePreparedStatementExecuteFast.bindByteBuffer(13, nativeByteBuffer5);
                sQLitePreparedStatementExecuteFast.bindInteger(14, tLRPC$EncryptedChat.in_seq_no);
                sQLitePreparedStatementExecuteFast.bindInteger(15, tLRPC$EncryptedChat.admin_id);
                sQLitePreparedStatementExecuteFast.bindInteger(16, tLRPC$EncryptedChat.mtproto_seq);
                sQLitePreparedStatementExecuteFast.bindInteger(17, tLRPC$EncryptedChat.id);
                sQLitePreparedStatementExecuteFast.step();
                nativeByteBuffer.reuse();
                nativeByteBuffer2.reuse();
                nativeByteBuffer3.reuse();
                nativeByteBuffer4.reuse();
                nativeByteBuffer5.reuse();
            } catch (Exception e) {
                FileLog.e(e);
                if (sQLitePreparedStatementExecuteFast == null) {
                    return;
                }
            }
            sQLitePreparedStatementExecuteFast.dispose();
        } catch (Throwable th) {
            if (sQLitePreparedStatementExecuteFast != null) {
                sQLitePreparedStatementExecuteFast.dispose();
            }
            throw th;
        }
    }

    public void isDialogHasTopMessage(final long j, final Runnable runnable) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda70
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$isDialogHasTopMessage$100(j, runnable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$isDialogHasTopMessage$100(long j, Runnable runnable) {
        boolean z = false;
        try {
            SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT last_mid FROM dialogs WHERE did = %d", Long.valueOf(j)), new Object[0]);
            if (sQLiteCursorQueryFinalized.next() && sQLiteCursorQueryFinalized.intValue(0) != 0) {
                z = true;
            }
            sQLiteCursorQueryFinalized.dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
        if (z) {
            return;
        }
        AndroidUtilities.runOnUIThread(runnable);
    }

    public boolean hasAuthMessage(final int i) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final boolean[] zArr = new boolean[1];
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda51
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$hasAuthMessage$101(i, zArr, countDownLatch);
            }
        });
        try {
            countDownLatch.await();
        } catch (Exception e) {
            FileLog.e(e);
        }
        return zArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$hasAuthMessage$101(int i, boolean[] zArr, CountDownLatch countDownLatch) {
        try {
            try {
                SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT mid FROM messages WHERE uid = 777000 AND date = %d AND mid < 0 LIMIT 1", Integer.valueOf(i)), new Object[0]);
                zArr[0] = sQLiteCursorQueryFinalized.next();
                sQLiteCursorQueryFinalized.dispose();
            } catch (Exception e) {
                FileLog.e(e);
            }
        } finally {
            countDownLatch.countDown();
        }
    }

    public void getEncryptedChat(final int i, final CountDownLatch countDownLatch, final ArrayList<TLObject> arrayList) {
        if (countDownLatch == null || arrayList == null) {
            return;
        }
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda48
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getEncryptedChat$102(i, arrayList, countDownLatch);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getEncryptedChat$102(int i, ArrayList arrayList, CountDownLatch countDownLatch) {
        try {
            try {
                ArrayList<Integer> arrayList2 = new ArrayList<>();
                ArrayList<TLRPC$EncryptedChat> arrayList3 = new ArrayList<>();
                getEncryptedChatsInternal(io.github.inflationx.calligraphy3.BuildConfig.FLAVOR + i, arrayList3, arrayList2);
                if (!arrayList3.isEmpty() && !arrayList2.isEmpty()) {
                    ArrayList<TLRPC$User> arrayList4 = new ArrayList<>();
                    getUsersInternal(TextUtils.join(",", arrayList2), arrayList4);
                    if (!arrayList4.isEmpty()) {
                        arrayList.add(arrayList3.get(0));
                        arrayList.add(arrayList4.get(0));
                    }
                }
            } catch (Exception e) {
                FileLog.e(e);
            }
        } finally {
            countDownLatch.countDown();
        }
    }

    public void putEncryptedChat(final TLRPC$EncryptedChat tLRPC$EncryptedChat, final TLRPC$User tLRPC$User, final TLRPC$Dialog tLRPC$Dialog) {
        if (tLRPC$EncryptedChat == null) {
            return;
        }
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda130
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$putEncryptedChat$103(tLRPC$EncryptedChat, tLRPC$User, tLRPC$Dialog);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$putEncryptedChat$103(TLRPC$EncryptedChat tLRPC$EncryptedChat, TLRPC$User tLRPC$User, TLRPC$Dialog tLRPC$Dialog) {
        byte[] bArr;
        try {
            byte[] bArr2 = tLRPC$EncryptedChat.key_hash;
            if ((bArr2 == null || bArr2.length < 16) && (bArr = tLRPC$EncryptedChat.auth_key) != null) {
                tLRPC$EncryptedChat.key_hash = AndroidUtilities.calcAuthKeyHash(bArr);
            }
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("REPLACE INTO enc_chats VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(tLRPC$EncryptedChat.getObjectSize());
            byte[] bArr3 = tLRPC$EncryptedChat.a_or_b;
            NativeByteBuffer nativeByteBuffer2 = new NativeByteBuffer(bArr3 != null ? bArr3.length : 1);
            byte[] bArr4 = tLRPC$EncryptedChat.auth_key;
            NativeByteBuffer nativeByteBuffer3 = new NativeByteBuffer(bArr4 != null ? bArr4.length : 1);
            byte[] bArr5 = tLRPC$EncryptedChat.future_auth_key;
            NativeByteBuffer nativeByteBuffer4 = new NativeByteBuffer(bArr5 != null ? bArr5.length : 1);
            byte[] bArr6 = tLRPC$EncryptedChat.key_hash;
            NativeByteBuffer nativeByteBuffer5 = new NativeByteBuffer(bArr6 != null ? bArr6.length : 1);
            tLRPC$EncryptedChat.serializeToStream(nativeByteBuffer);
            sQLitePreparedStatementExecuteFast.bindInteger(1, tLRPC$EncryptedChat.id);
            sQLitePreparedStatementExecuteFast.bindInteger(2, tLRPC$User.id);
            sQLitePreparedStatementExecuteFast.bindString(3, formatUserSearchName(tLRPC$User));
            sQLitePreparedStatementExecuteFast.bindByteBuffer(4, nativeByteBuffer);
            byte[] bArr7 = tLRPC$EncryptedChat.a_or_b;
            if (bArr7 != null) {
                nativeByteBuffer2.writeBytes(bArr7);
            }
            byte[] bArr8 = tLRPC$EncryptedChat.auth_key;
            if (bArr8 != null) {
                nativeByteBuffer3.writeBytes(bArr8);
            }
            byte[] bArr9 = tLRPC$EncryptedChat.future_auth_key;
            if (bArr9 != null) {
                nativeByteBuffer4.writeBytes(bArr9);
            }
            byte[] bArr10 = tLRPC$EncryptedChat.key_hash;
            if (bArr10 != null) {
                nativeByteBuffer5.writeBytes(bArr10);
            }
            sQLitePreparedStatementExecuteFast.bindByteBuffer(5, nativeByteBuffer2);
            sQLitePreparedStatementExecuteFast.bindByteBuffer(6, nativeByteBuffer3);
            sQLitePreparedStatementExecuteFast.bindInteger(7, tLRPC$EncryptedChat.ttl);
            sQLitePreparedStatementExecuteFast.bindInteger(8, tLRPC$EncryptedChat.layer);
            sQLitePreparedStatementExecuteFast.bindInteger(9, tLRPC$EncryptedChat.seq_in);
            sQLitePreparedStatementExecuteFast.bindInteger(10, tLRPC$EncryptedChat.seq_out);
            sQLitePreparedStatementExecuteFast.bindInteger(11, tLRPC$EncryptedChat.key_use_count_out | (tLRPC$EncryptedChat.key_use_count_in << 16));
            sQLitePreparedStatementExecuteFast.bindLong(12, tLRPC$EncryptedChat.exchange_id);
            sQLitePreparedStatementExecuteFast.bindInteger(13, tLRPC$EncryptedChat.key_create_date);
            sQLitePreparedStatementExecuteFast.bindLong(14, tLRPC$EncryptedChat.future_key_fingerprint);
            sQLitePreparedStatementExecuteFast.bindByteBuffer(15, nativeByteBuffer4);
            sQLitePreparedStatementExecuteFast.bindByteBuffer(16, nativeByteBuffer5);
            sQLitePreparedStatementExecuteFast.bindInteger(17, tLRPC$EncryptedChat.in_seq_no);
            sQLitePreparedStatementExecuteFast.bindInteger(18, tLRPC$EncryptedChat.admin_id);
            sQLitePreparedStatementExecuteFast.bindInteger(19, tLRPC$EncryptedChat.mtproto_seq);
            sQLitePreparedStatementExecuteFast.step();
            sQLitePreparedStatementExecuteFast.dispose();
            nativeByteBuffer.reuse();
            nativeByteBuffer2.reuse();
            nativeByteBuffer3.reuse();
            nativeByteBuffer4.reuse();
            nativeByteBuffer5.reuse();
            if (tLRPC$Dialog != null) {
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast2 = this.database.executeFast("REPLACE INTO dialogs VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                sQLitePreparedStatementExecuteFast2.bindLong(1, tLRPC$Dialog.id);
                sQLitePreparedStatementExecuteFast2.bindInteger(2, tLRPC$Dialog.last_message_date);
                sQLitePreparedStatementExecuteFast2.bindInteger(3, tLRPC$Dialog.unread_count);
                sQLitePreparedStatementExecuteFast2.bindLong(4, tLRPC$Dialog.top_message);
                sQLitePreparedStatementExecuteFast2.bindLong(5, tLRPC$Dialog.read_inbox_max_id);
                sQLitePreparedStatementExecuteFast2.bindLong(6, tLRPC$Dialog.read_outbox_max_id);
                sQLitePreparedStatementExecuteFast2.bindInteger(7, 0);
                sQLitePreparedStatementExecuteFast2.bindInteger(8, tLRPC$Dialog.unread_mentions_count);
                sQLitePreparedStatementExecuteFast2.bindInteger(9, tLRPC$Dialog.pts);
                sQLitePreparedStatementExecuteFast2.bindInteger(10, 0);
                sQLitePreparedStatementExecuteFast2.bindInteger(11, tLRPC$Dialog.pinnedNum);
                sQLitePreparedStatementExecuteFast2.bindInteger(12, tLRPC$Dialog.flags);
                sQLitePreparedStatementExecuteFast2.bindInteger(13, tLRPC$Dialog.folder_id);
                sQLitePreparedStatementExecuteFast2.bindNull(14);
                sQLitePreparedStatementExecuteFast2.step();
                sQLitePreparedStatementExecuteFast2.dispose();
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    private String formatUserSearchName(TLRPC$User tLRPC$User) {
        StringBuilder sb = new StringBuilder();
        String str = tLRPC$User.first_name;
        if (str != null && str.length() > 0) {
            sb.append(tLRPC$User.first_name);
        }
        String str2 = tLRPC$User.last_name;
        if (str2 != null && str2.length() > 0) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(tLRPC$User.last_name);
        }
        sb.append(";;;");
        String str3 = tLRPC$User.username;
        if (str3 != null && str3.length() > 0) {
            sb.append(tLRPC$User.username);
        }
        return sb.toString().toLowerCase();
    }

    private void putUsersInternal(ArrayList<TLRPC$User> arrayList) throws Exception {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("REPLACE INTO users VALUES(?, ?, ?, ?)");
        for (int i = 0; i < arrayList.size(); i++) {
            TLRPC$User tLRPC$User = arrayList.get(i);
            if (tLRPC$User.min) {
                SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT data FROM users WHERE uid = %d", Integer.valueOf(tLRPC$User.id)), new Object[0]);
                if (sQLiteCursorQueryFinalized.next()) {
                    try {
                        NativeByteBuffer nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized.byteBufferValue(0);
                        if (nativeByteBufferByteBufferValue != null) {
                            TLRPC$User tLRPC$UserTLdeserialize = TLRPC$User.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                            nativeByteBufferByteBufferValue.reuse();
                            if (tLRPC$UserTLdeserialize != null) {
                                String str = tLRPC$User.username;
                                if (str != null) {
                                    tLRPC$UserTLdeserialize.username = str;
                                    tLRPC$UserTLdeserialize.flags |= 8;
                                } else {
                                    tLRPC$UserTLdeserialize.username = null;
                                    tLRPC$UserTLdeserialize.flags &= -9;
                                }
                                if (tLRPC$User.apply_min_photo) {
                                    TLRPC$UserProfilePhoto tLRPC$UserProfilePhoto = tLRPC$User.photo;
                                    if (tLRPC$UserProfilePhoto != null) {
                                        tLRPC$UserTLdeserialize.photo = tLRPC$UserProfilePhoto;
                                        tLRPC$UserTLdeserialize.flags |= 32;
                                    } else {
                                        tLRPC$UserTLdeserialize.photo = null;
                                        tLRPC$UserTLdeserialize.flags &= -33;
                                    }
                                }
                                tLRPC$User = tLRPC$UserTLdeserialize;
                            }
                        }
                    } catch (Exception e) {
                        FileLog.e(e);
                    }
                }
                sQLiteCursorQueryFinalized.dispose();
            }
            sQLitePreparedStatementExecuteFast.requery();
            NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(tLRPC$User.getObjectSize());
            tLRPC$User.serializeToStream(nativeByteBuffer);
            sQLitePreparedStatementExecuteFast.bindInteger(1, tLRPC$User.id);
            sQLitePreparedStatementExecuteFast.bindString(2, formatUserSearchName(tLRPC$User));
            TLRPC$UserStatus tLRPC$UserStatus = tLRPC$User.status;
            if (tLRPC$UserStatus != null) {
                if (tLRPC$UserStatus instanceof TLRPC$TL_userStatusRecently) {
                    tLRPC$UserStatus.expires = -100;
                } else if (tLRPC$UserStatus instanceof TLRPC$TL_userStatusLastWeek) {
                    tLRPC$UserStatus.expires = -101;
                } else if (tLRPC$UserStatus instanceof TLRPC$TL_userStatusLastMonth) {
                    tLRPC$UserStatus.expires = -102;
                }
                sQLitePreparedStatementExecuteFast.bindInteger(3, tLRPC$UserStatus.expires);
            } else {
                sQLitePreparedStatementExecuteFast.bindInteger(3, 0);
            }
            sQLitePreparedStatementExecuteFast.bindByteBuffer(4, nativeByteBuffer);
            sQLitePreparedStatementExecuteFast.step();
            nativeByteBuffer.reuse();
        }
        sQLitePreparedStatementExecuteFast.dispose();
    }

    public void updateChatDefaultBannedRights(final int i, final TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights, final int i2) {
        if (tLRPC$TL_chatBannedRights == null || i == 0) {
            return;
        }
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda31
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateChatDefaultBannedRights$104(i, i2, tLRPC$TL_chatBannedRights);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateChatDefaultBannedRights$104(int i, int i2, TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights) {
        NativeByteBuffer nativeByteBufferByteBufferValue;
        TLRPC$Chat tLRPC$ChatTLdeserialize = null;
        try {
            SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT data FROM chats WHERE uid = %d", Integer.valueOf(i)), new Object[0]);
            if (sQLiteCursorQueryFinalized.next() && (nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized.byteBufferValue(0)) != null) {
                tLRPC$ChatTLdeserialize = TLRPC$Chat.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                nativeByteBufferByteBufferValue.reuse();
            }
            sQLiteCursorQueryFinalized.dispose();
            if (tLRPC$ChatTLdeserialize != null) {
                if (tLRPC$ChatTLdeserialize.default_banned_rights == null || i2 >= tLRPC$ChatTLdeserialize.version) {
                    tLRPC$ChatTLdeserialize.default_banned_rights = tLRPC$TL_chatBannedRights;
                    tLRPC$ChatTLdeserialize.flags |= MessagesController.UPDATE_MASK_CHAT_MUTE;
                    tLRPC$ChatTLdeserialize.version = i2;
                    SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("UPDATE chats SET data = ? WHERE uid = ?");
                    NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(tLRPC$ChatTLdeserialize.getObjectSize());
                    tLRPC$ChatTLdeserialize.serializeToStream(nativeByteBuffer);
                    sQLitePreparedStatementExecuteFast.bindByteBuffer(1, nativeByteBuffer);
                    sQLitePreparedStatementExecuteFast.bindInteger(2, tLRPC$ChatTLdeserialize.id);
                    sQLitePreparedStatementExecuteFast.step();
                    nativeByteBuffer.reuse();
                    sQLitePreparedStatementExecuteFast.dispose();
                }
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    private void putChatsInternal(ArrayList<TLRPC$Chat> arrayList) throws Exception {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("REPLACE INTO chats VALUES(?, ?, ?)");
        for (int i = 0; i < arrayList.size(); i++) {
            TLRPC$Chat tLRPC$Chat = arrayList.get(i);
            if (tLRPC$Chat.min) {
                SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT data FROM chats WHERE uid = %d", Integer.valueOf(tLRPC$Chat.id)), new Object[0]);
                if (sQLiteCursorQueryFinalized.next()) {
                    try {
                        NativeByteBuffer nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized.byteBufferValue(0);
                        if (nativeByteBufferByteBufferValue != null) {
                            TLRPC$Chat tLRPC$ChatTLdeserialize = TLRPC$Chat.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                            nativeByteBufferByteBufferValue.reuse();
                            if (tLRPC$ChatTLdeserialize != null) {
                                tLRPC$ChatTLdeserialize.title = tLRPC$Chat.title;
                                tLRPC$ChatTLdeserialize.photo = tLRPC$Chat.photo;
                                tLRPC$ChatTLdeserialize.broadcast = tLRPC$Chat.broadcast;
                                tLRPC$ChatTLdeserialize.verified = tLRPC$Chat.verified;
                                tLRPC$ChatTLdeserialize.megagroup = tLRPC$Chat.megagroup;
                                tLRPC$ChatTLdeserialize.call_not_empty = tLRPC$Chat.call_not_empty;
                                tLRPC$ChatTLdeserialize.call_active = tLRPC$Chat.call_active;
                                TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights = tLRPC$Chat.default_banned_rights;
                                if (tLRPC$TL_chatBannedRights != null) {
                                    tLRPC$ChatTLdeserialize.default_banned_rights = tLRPC$TL_chatBannedRights;
                                    tLRPC$ChatTLdeserialize.flags |= MessagesController.UPDATE_MASK_CHAT_MUTE;
                                }
                                TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights = tLRPC$Chat.admin_rights;
                                if (tLRPC$TL_chatAdminRights != null) {
                                    tLRPC$ChatTLdeserialize.admin_rights = tLRPC$TL_chatAdminRights;
                                    tLRPC$ChatTLdeserialize.flags |= LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM;
                                }
                                TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights2 = tLRPC$Chat.banned_rights;
                                if (tLRPC$TL_chatBannedRights2 != null) {
                                    tLRPC$ChatTLdeserialize.banned_rights = tLRPC$TL_chatBannedRights2;
                                    tLRPC$ChatTLdeserialize.flags |= 32768;
                                }
                                String str = tLRPC$Chat.username;
                                if (str != null) {
                                    tLRPC$ChatTLdeserialize.username = str;
                                    tLRPC$ChatTLdeserialize.flags |= 64;
                                } else {
                                    tLRPC$ChatTLdeserialize.username = null;
                                    tLRPC$ChatTLdeserialize.flags &= -65;
                                }
                                tLRPC$Chat = tLRPC$ChatTLdeserialize;
                            }
                        }
                    } catch (Exception e) {
                        FileLog.e(e);
                    }
                }
                sQLiteCursorQueryFinalized.dispose();
            }
            sQLitePreparedStatementExecuteFast.requery();
            tLRPC$Chat.flags |= MessagesController.UPDATE_MASK_REORDER;
            NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(tLRPC$Chat.getObjectSize());
            tLRPC$Chat.serializeToStream(nativeByteBuffer);
            sQLitePreparedStatementExecuteFast.bindInteger(1, tLRPC$Chat.id);
            String str2 = tLRPC$Chat.title;
            if (str2 != null) {
                sQLitePreparedStatementExecuteFast.bindString(2, str2.toLowerCase());
            } else {
                sQLitePreparedStatementExecuteFast.bindString(2, io.github.inflationx.calligraphy3.BuildConfig.FLAVOR);
            }
            sQLitePreparedStatementExecuteFast.bindByteBuffer(3, nativeByteBuffer);
            sQLitePreparedStatementExecuteFast.step();
            nativeByteBuffer.reuse();
        }
        sQLitePreparedStatementExecuteFast.dispose();
    }

    public void getUsersInternal(String str, ArrayList<TLRPC$User> arrayList) throws Exception {
        if (str == null || str.length() == 0 || arrayList == null) {
            return;
        }
        SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT data, status FROM users WHERE uid IN(%s)", str), new Object[0]);
        while (sQLiteCursorQueryFinalized.next()) {
            try {
                NativeByteBuffer nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized.byteBufferValue(0);
                if (nativeByteBufferByteBufferValue != null) {
                    TLRPC$User tLRPC$UserTLdeserialize = TLRPC$User.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                    nativeByteBufferByteBufferValue.reuse();
                    if (tLRPC$UserTLdeserialize != null) {
                        TLRPC$UserStatus tLRPC$UserStatus = tLRPC$UserTLdeserialize.status;
                        if (tLRPC$UserStatus != null) {
                            tLRPC$UserStatus.expires = sQLiteCursorQueryFinalized.intValue(1);
                        }
                        arrayList.add(tLRPC$UserTLdeserialize);
                    }
                }
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
        sQLiteCursorQueryFinalized.dispose();
    }

    public void getChatsInternal(String str, ArrayList<TLRPC$Chat> arrayList) throws Exception {
        if (str == null || str.length() == 0 || arrayList == null) {
            return;
        }
        SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT data FROM chats WHERE uid IN(%s)", str), new Object[0]);
        while (sQLiteCursorQueryFinalized.next()) {
            try {
                NativeByteBuffer nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized.byteBufferValue(0);
                if (nativeByteBufferByteBufferValue != null) {
                    TLRPC$Chat tLRPC$ChatTLdeserialize = TLRPC$Chat.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                    nativeByteBufferByteBufferValue.reuse();
                    if (tLRPC$ChatTLdeserialize != null) {
                        arrayList.add(tLRPC$ChatTLdeserialize);
                    }
                }
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
        sQLiteCursorQueryFinalized.dispose();
    }

    public void getEncryptedChatsInternal(String str, ArrayList<TLRPC$EncryptedChat> arrayList, ArrayList<Integer> arrayList2) throws Exception {
        if (str == null || str.length() == 0 || arrayList == null) {
            return;
        }
        SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT data, user, g, authkey, ttl, layer, seq_in, seq_out, use_count, exchange_id, key_date, fprint, fauthkey, khash, in_seq_no, admin_id, mtproto_seq FROM enc_chats WHERE uid IN(%s)", str), new Object[0]);
        while (sQLiteCursorQueryFinalized.next()) {
            try {
                NativeByteBuffer nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized.byteBufferValue(0);
                if (nativeByteBufferByteBufferValue != null) {
                    TLRPC$EncryptedChat tLRPC$EncryptedChatTLdeserialize = TLRPC$EncryptedChat.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                    nativeByteBufferByteBufferValue.reuse();
                    if (tLRPC$EncryptedChatTLdeserialize != null) {
                        int iIntValue = sQLiteCursorQueryFinalized.intValue(1);
                        tLRPC$EncryptedChatTLdeserialize.user_id = iIntValue;
                        if (arrayList2 != null && !arrayList2.contains(Integer.valueOf(iIntValue))) {
                            arrayList2.add(Integer.valueOf(tLRPC$EncryptedChatTLdeserialize.user_id));
                        }
                        tLRPC$EncryptedChatTLdeserialize.a_or_b = sQLiteCursorQueryFinalized.byteArrayValue(2);
                        tLRPC$EncryptedChatTLdeserialize.auth_key = sQLiteCursorQueryFinalized.byteArrayValue(3);
                        tLRPC$EncryptedChatTLdeserialize.ttl = sQLiteCursorQueryFinalized.intValue(4);
                        tLRPC$EncryptedChatTLdeserialize.layer = sQLiteCursorQueryFinalized.intValue(5);
                        tLRPC$EncryptedChatTLdeserialize.seq_in = sQLiteCursorQueryFinalized.intValue(6);
                        tLRPC$EncryptedChatTLdeserialize.seq_out = sQLiteCursorQueryFinalized.intValue(7);
                        int iIntValue2 = sQLiteCursorQueryFinalized.intValue(8);
                        tLRPC$EncryptedChatTLdeserialize.key_use_count_in = (short) (iIntValue2 >> 16);
                        tLRPC$EncryptedChatTLdeserialize.key_use_count_out = (short) iIntValue2;
                        tLRPC$EncryptedChatTLdeserialize.exchange_id = sQLiteCursorQueryFinalized.longValue(9);
                        tLRPC$EncryptedChatTLdeserialize.key_create_date = sQLiteCursorQueryFinalized.intValue(10);
                        tLRPC$EncryptedChatTLdeserialize.future_key_fingerprint = sQLiteCursorQueryFinalized.longValue(11);
                        tLRPC$EncryptedChatTLdeserialize.future_auth_key = sQLiteCursorQueryFinalized.byteArrayValue(12);
                        tLRPC$EncryptedChatTLdeserialize.key_hash = sQLiteCursorQueryFinalized.byteArrayValue(13);
                        tLRPC$EncryptedChatTLdeserialize.in_seq_no = sQLiteCursorQueryFinalized.intValue(14);
                        int iIntValue3 = sQLiteCursorQueryFinalized.intValue(15);
                        if (iIntValue3 != 0) {
                            tLRPC$EncryptedChatTLdeserialize.admin_id = iIntValue3;
                        }
                        tLRPC$EncryptedChatTLdeserialize.mtproto_seq = sQLiteCursorQueryFinalized.intValue(16);
                        arrayList.add(tLRPC$EncryptedChatTLdeserialize);
                    }
                }
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
        sQLiteCursorQueryFinalized.dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: putUsersAndChatsInternal, reason: merged with bridge method [inline-methods] */
    public void lambda$putUsersAndChats$105(ArrayList<TLRPC$User> arrayList, ArrayList<TLRPC$Chat> arrayList2, boolean z) {
        if (z) {
            try {
                this.database.beginTransaction();
            } catch (Exception e) {
                FileLog.e(e);
                return;
            }
        }
        putUsersInternal(arrayList);
        putChatsInternal(arrayList2);
        if (z) {
            this.database.commitTransaction();
        }
    }

    public void putUsersAndChats(final ArrayList<TLRPC$User> arrayList, final ArrayList<TLRPC$Chat> arrayList2, final boolean z, boolean z2) {
        if (arrayList == null || !arrayList.isEmpty() || arrayList2 == null || !arrayList2.isEmpty()) {
            if (z2) {
                this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda113
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$putUsersAndChats$105(arrayList, arrayList2, z);
                    }
                });
            } else {
                lambda$putUsersAndChats$105(arrayList, arrayList2, z);
            }
        }
    }

    public void removeFromDownloadQueue(final long j, final int i, final boolean z) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda144
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$removeFromDownloadQueue$106(z, i, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removeFromDownloadQueue$106(boolean z, int i, long j) {
        try {
            if (!z) {
                this.database.executeFast(String.format(Locale.US, "DELETE FROM download_queue WHERE uid = %d AND type = %d", Long.valueOf(j), Integer.valueOf(i))).stepThis().dispose();
                return;
            }
            SQLiteDatabase sQLiteDatabase = this.database;
            Locale locale = Locale.US;
            SQLiteCursor sQLiteCursorQueryFinalized = sQLiteDatabase.queryFinalized(String.format(locale, "SELECT min(date) FROM download_queue WHERE type = %d", Integer.valueOf(i)), new Object[0]);
            int iIntValue = sQLiteCursorQueryFinalized.next() ? sQLiteCursorQueryFinalized.intValue(0) : -1;
            sQLiteCursorQueryFinalized.dispose();
            if (iIntValue != -1) {
                this.database.executeFast(String.format(locale, "UPDATE download_queue SET date = %d WHERE uid = %d AND type = %d", Integer.valueOf(iIntValue - 1), Long.valueOf(j), Integer.valueOf(i))).stepThis().dispose();
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    private void deleteFromDownloadQueue(final ArrayList<Pair<Long, Integer>> arrayList, boolean z) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (z) {
            try {
                this.database.beginTransaction();
            } catch (Exception e) {
                FileLog.e(e);
                return;
            }
        }
        SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("DELETE FROM download_queue WHERE uid = ? AND type = ?");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Pair<Long, Integer> pair = arrayList.get(i);
            sQLitePreparedStatementExecuteFast.requery();
            sQLitePreparedStatementExecuteFast.bindLong(1, ((Long) pair.first).longValue());
            sQLitePreparedStatementExecuteFast.bindInteger(2, ((Integer) pair.second).intValue());
            sQLitePreparedStatementExecuteFast.step();
        }
        sQLitePreparedStatementExecuteFast.dispose();
        if (z) {
            this.database.commitTransaction();
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda89
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$deleteFromDownloadQueue$107(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteFromDownloadQueue$107(ArrayList arrayList) {
        getDownloadController().cancelDownloading(arrayList);
    }

    public void clearDownloadQueue(final int i) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda23
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$clearDownloadQueue$108(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$clearDownloadQueue$108(int i) {
        try {
            if (i == 0) {
                this.database.executeFast("DELETE FROM download_queue WHERE 1").stepThis().dispose();
            } else {
                this.database.executeFast(String.format(Locale.US, "DELETE FROM download_queue WHERE type = %d", Integer.valueOf(i))).stepThis().dispose();
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void getDownloadQueue(final int i) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda22
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getDownloadQueue$110(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getDownloadQueue$110(final int i) {
        int i2;
        try {
            final ArrayList arrayList = new ArrayList();
            SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT uid, type, data, parent FROM download_queue WHERE type = %d ORDER BY date DESC LIMIT 3", Integer.valueOf(i)), new Object[0]);
            while (sQLiteCursorQueryFinalized.next()) {
                DownloadObject downloadObject = new DownloadObject();
                downloadObject.type = sQLiteCursorQueryFinalized.intValue(1);
                downloadObject.id = sQLiteCursorQueryFinalized.longValue(0);
                downloadObject.parent = sQLiteCursorQueryFinalized.stringValue(3);
                NativeByteBuffer nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized.byteBufferValue(2);
                if (nativeByteBufferByteBufferValue != null) {
                    TLRPC$MessageMedia tLRPC$MessageMediaTLdeserialize = TLRPC$MessageMedia.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                    nativeByteBufferByteBufferValue.reuse();
                    TLRPC$Document tLRPC$Document = tLRPC$MessageMediaTLdeserialize.document;
                    if (tLRPC$Document != null) {
                        downloadObject.object = tLRPC$Document;
                        downloadObject.secret = MessageObject.isVideoDocument(tLRPC$Document) && (i2 = tLRPC$MessageMediaTLdeserialize.ttl_seconds) > 0 && i2 <= 60;
                    } else {
                        TLRPC$Photo tLRPC$Photo = tLRPC$MessageMediaTLdeserialize.photo;
                        if (tLRPC$Photo != null) {
                            downloadObject.object = tLRPC$Photo;
                            int i3 = tLRPC$MessageMediaTLdeserialize.ttl_seconds;
                            downloadObject.secret = i3 > 0 && i3 <= 60;
                        }
                    }
                    downloadObject.forceCache = (tLRPC$MessageMediaTLdeserialize.flags & Integer.MIN_VALUE) != 0;
                }
                arrayList.add(downloadObject);
            }
            sQLiteCursorQueryFinalized.dispose();
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda44
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$getDownloadQueue$109(i, arrayList);
                }
            });
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getDownloadQueue$109(int i, ArrayList arrayList) {
        getDownloadController().processDownloadObjects(i, arrayList);
    }

    private int getMessageMediaType(TLRPC$Message tLRPC$Message) {
        int i;
        if (tLRPC$Message instanceof TLRPC$TL_message_secret) {
            if ((((tLRPC$Message.media instanceof TLRPC$TL_messageMediaPhoto) || MessageObject.isGifMessage(tLRPC$Message)) && (i = tLRPC$Message.ttl) > 0 && i <= 60) || MessageObject.isVoiceMessage(tLRPC$Message) || MessageObject.isVideoMessage(tLRPC$Message) || MessageObject.isRoundVideoMessage(tLRPC$Message)) {
                return 1;
            }
            return ((tLRPC$Message.media instanceof TLRPC$TL_messageMediaPhoto) || MessageObject.isVideoMessage(tLRPC$Message)) ? 0 : -1;
        }
        if (tLRPC$Message instanceof TLRPC$TL_message) {
            TLRPC$MessageMedia tLRPC$MessageMedia = tLRPC$Message.media;
            if (((tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaPhoto) || (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaDocument)) && tLRPC$MessageMedia.ttl_seconds != 0) {
                return 1;
            }
        }
        return ((tLRPC$Message.media instanceof TLRPC$TL_messageMediaPhoto) || MessageObject.isVideoMessage(tLRPC$Message)) ? 0 : -1;
    }

    public void putWebPages(final LongSparseArray<TLRPC$WebPage> longSparseArray) {
        if (isEmpty(longSparseArray)) {
            return;
        }
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda82
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$putWebPages$112(longSparseArray);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$putWebPages$112(LongSparseArray longSparseArray) {
        try {
            final ArrayList arrayList = new ArrayList();
            for (int i = 0; i < longSparseArray.size(); i++) {
                SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized("SELECT mid FROM webpage_pending WHERE id = " + longSparseArray.keyAt(i), new Object[0]);
                ArrayList arrayList2 = new ArrayList();
                while (sQLiteCursorQueryFinalized.next()) {
                    arrayList2.add(Long.valueOf(sQLiteCursorQueryFinalized.longValue(0)));
                }
                sQLiteCursorQueryFinalized.dispose();
                if (!arrayList2.isEmpty()) {
                    SQLiteCursor sQLiteCursorQueryFinalized2 = this.database.queryFinalized(String.format(Locale.US, "SELECT mid, data FROM messages WHERE mid IN (%s)", TextUtils.join(",", arrayList2)), new Object[0]);
                    while (sQLiteCursorQueryFinalized2.next()) {
                        long jIntValue = sQLiteCursorQueryFinalized2.intValue(0);
                        NativeByteBuffer nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized2.byteBufferValue(1);
                        if (nativeByteBufferByteBufferValue != null) {
                            TLRPC$Message tLRPC$MessageTLdeserialize = TLRPC$Message.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                            tLRPC$MessageTLdeserialize.readAttachPath(nativeByteBufferByteBufferValue, getUserConfig().clientUserId);
                            nativeByteBufferByteBufferValue.reuse();
                            TLRPC$MessageMedia tLRPC$MessageMedia = tLRPC$MessageTLdeserialize.media;
                            if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaWebPage) {
                                tLRPC$MessageTLdeserialize.id = jIntValue;
                                tLRPC$MessageMedia.webpage = (TLRPC$WebPage) longSparseArray.valueAt(i);
                                arrayList.add(tLRPC$MessageTLdeserialize);
                            }
                        }
                    }
                    sQLiteCursorQueryFinalized2.dispose();
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            this.database.beginTransaction();
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("UPDATE messages SET data = ? WHERE mid = ?");
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast2 = this.database.executeFast("UPDATE media_v2 SET data = ? WHERE mid = ?");
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                TLRPC$Message tLRPC$Message = (TLRPC$Message) arrayList.get(i2);
                NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(tLRPC$Message.getObjectSize());
                tLRPC$Message.serializeToStream(nativeByteBuffer);
                long j = tLRPC$Message.id;
                int i3 = tLRPC$Message.peer_id.channel_id;
                if (i3 != 0) {
                    j |= i3 << 32;
                }
                sQLitePreparedStatementExecuteFast.requery();
                sQLitePreparedStatementExecuteFast.bindByteBuffer(1, nativeByteBuffer);
                sQLitePreparedStatementExecuteFast.bindLong(2, j);
                sQLitePreparedStatementExecuteFast.step();
                sQLitePreparedStatementExecuteFast2.requery();
                sQLitePreparedStatementExecuteFast2.bindByteBuffer(1, nativeByteBuffer);
                sQLitePreparedStatementExecuteFast2.bindLong(2, j);
                sQLitePreparedStatementExecuteFast2.step();
                nativeByteBuffer.reuse();
            }
            sQLitePreparedStatementExecuteFast.dispose();
            sQLitePreparedStatementExecuteFast2.dispose();
            this.database.commitTransaction();
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda96
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$putWebPages$111(arrayList);
                }
            });
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$putWebPages$111(ArrayList arrayList) {
        getNotificationCenter().postNotificationName(NotificationCenter.didReceivedWebpages, arrayList);
    }

    public void overwriteChannel(final int i, final TLRPC$TL_updates_channelDifferenceTooLong tLRPC$TL_updates_channelDifferenceTooLong, final int i2) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda32
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$overwriteChannel$114(i, i2, tLRPC$TL_updates_channelDifferenceTooLong);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$overwriteChannel$114(int r11, int r12, org.rbmain.tgnet.TLRPC$TL_updates_channelDifferenceTooLong r13) {
        /*
            Method dump skipped, instructions count: 390
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.MessagesStorage.lambda$overwriteChannel$114(int, int, org.rbmain.tgnet.TLRPC$TL_updates_channelDifferenceTooLong):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$overwriteChannel$113(long j) {
        getNotificationCenter().postNotificationName(NotificationCenter.removeAllMessagesFromDialog, Long.valueOf(j), Boolean.TRUE);
    }

    public void putChannelViews(final SparseArray<LongSparseArray<Integer>> sparseArray, final SparseArray<LongSparseArray<Integer>> sparseArray2, final SparseArray<LongSparseArray<TLRPC$TL_messageReplies>> sparseArray3, final boolean z, final boolean z2) {
        if (isEmpty(sparseArray) && isEmpty(sparseArray2) && isEmpty(sparseArray3)) {
            return;
        }
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda81
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$putChannelViews$115(sparseArray, z2, sparseArray2, sparseArray3, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$putChannelViews$115(SparseArray sparseArray, boolean z, SparseArray sparseArray2, SparseArray sparseArray3, boolean z2) {
        LongSparseArray longSparseArray;
        int i;
        NativeByteBuffer nativeByteBufferByteBufferValue;
        try {
            this.database.beginTransaction();
            char c = ' ';
            if (!isEmpty((SparseArray<?>) sparseArray)) {
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("UPDATE messages SET media = max((SELECT media FROM messages WHERE mid = ?), ?) WHERE mid = ?");
                for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                    LongSparseArray longSparseArray2 = (LongSparseArray) sparseArray.get(sparseArray.keyAt(i2));
                    for (int i3 = 0; i3 < longSparseArray2.size(); i3++) {
                        int iIntValue = ((Integer) longSparseArray2.get(longSparseArray2.keyAt(i3))).intValue();
                        long jKeyAt = longSparseArray2.keyAt(i3);
                        if (z) {
                            jKeyAt |= (-r11) << 32;
                        }
                        long j = jKeyAt;
                        sQLitePreparedStatementExecuteFast.requery();
                        sQLitePreparedStatementExecuteFast.bindLong(1, j);
                        sQLitePreparedStatementExecuteFast.bindInteger(2, iIntValue);
                        sQLitePreparedStatementExecuteFast.bindLong(3, j);
                        sQLitePreparedStatementExecuteFast.step();
                    }
                }
                sQLitePreparedStatementExecuteFast.dispose();
            }
            if (!isEmpty((SparseArray<?>) sparseArray2)) {
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast2 = this.database.executeFast("UPDATE messages SET forwards = max((SELECT forwards FROM messages WHERE mid = ?), ?) WHERE mid = ?");
                for (int i4 = 0; i4 < sparseArray2.size(); i4++) {
                    LongSparseArray longSparseArray3 = (LongSparseArray) sparseArray2.get(sparseArray2.keyAt(i4));
                    for (int i5 = 0; i5 < longSparseArray3.size(); i5++) {
                        long jIntValue = ((Integer) longSparseArray3.get(longSparseArray3.keyAt(i5))).intValue();
                        long jKeyAt2 = longSparseArray3.keyAt(i5);
                        if (z) {
                            jKeyAt2 |= (-r7) << 32;
                        }
                        sQLitePreparedStatementExecuteFast2.requery();
                        sQLitePreparedStatementExecuteFast2.bindLong(1, jKeyAt2);
                        sQLitePreparedStatementExecuteFast2.bindLong(2, jIntValue);
                        sQLitePreparedStatementExecuteFast2.bindLong(3, jKeyAt2);
                        sQLitePreparedStatementExecuteFast2.step();
                    }
                }
                sQLitePreparedStatementExecuteFast2.dispose();
            }
            if (!isEmpty((SparseArray<?>) sparseArray3)) {
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast3 = this.database.executeFast("UPDATE messages SET replies_data = ? WHERE mid = ?");
                int i6 = 0;
                while (i6 < sparseArray3.size()) {
                    LongSparseArray longSparseArray4 = (LongSparseArray) sparseArray3.get(sparseArray3.keyAt(i6));
                    int i7 = 0;
                    while (i7 < longSparseArray4.size()) {
                        long jKeyAt3 = longSparseArray4.keyAt(i7);
                        if (z) {
                            jKeyAt3 |= (-r4) << c;
                        }
                        TLRPC$MessageReplies tLRPC$MessageRepliesTLdeserialize = null;
                        SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized("SELECT replies_data FROM messages WHERE mid = " + jKeyAt3, new Object[0]);
                        boolean next = sQLiteCursorQueryFinalized.next();
                        if (next && (nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized.byteBufferValue(0)) != null) {
                            tLRPC$MessageRepliesTLdeserialize = TLRPC$MessageReplies.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                            nativeByteBufferByteBufferValue.reuse();
                        }
                        sQLiteCursorQueryFinalized.dispose();
                        if (next) {
                            TLRPC$MessageReplies tLRPC$MessageReplies = (TLRPC$MessageReplies) longSparseArray4.get(longSparseArray4.keyAt(i7));
                            if (z2 || tLRPC$MessageRepliesTLdeserialize == null || (i = tLRPC$MessageRepliesTLdeserialize.replies_pts) == 0 || tLRPC$MessageReplies.replies_pts > i) {
                                longSparseArray = longSparseArray4;
                            } else {
                                longSparseArray = longSparseArray4;
                                if (tLRPC$MessageReplies.read_max_id <= tLRPC$MessageRepliesTLdeserialize.read_max_id && tLRPC$MessageReplies.max_id <= tLRPC$MessageRepliesTLdeserialize.max_id) {
                                }
                            }
                            if (z2) {
                                if (tLRPC$MessageRepliesTLdeserialize == null) {
                                    TLRPC$TL_messageReplies tLRPC$TL_messageReplies = new TLRPC$TL_messageReplies();
                                    tLRPC$TL_messageReplies.flags |= 2;
                                    tLRPC$MessageRepliesTLdeserialize = tLRPC$TL_messageReplies;
                                }
                                tLRPC$MessageRepliesTLdeserialize.replies += tLRPC$MessageReplies.replies;
                                int size = tLRPC$MessageReplies.recent_repliers.size();
                                for (int i8 = 0; i8 < size; i8++) {
                                    int peerId = MessageObject.getPeerId(tLRPC$MessageReplies.recent_repliers.get(i8));
                                    int size2 = tLRPC$MessageRepliesTLdeserialize.recent_repliers.size();
                                    int i9 = 0;
                                    while (i9 < size2) {
                                        if (peerId == MessageObject.getPeerId(tLRPC$MessageRepliesTLdeserialize.recent_repliers.get(i9))) {
                                            tLRPC$MessageRepliesTLdeserialize.recent_repliers.remove(i9);
                                            i9--;
                                            size2--;
                                        }
                                        i9++;
                                    }
                                }
                                tLRPC$MessageRepliesTLdeserialize.recent_repliers.addAll(0, tLRPC$MessageReplies.recent_repliers);
                                while (tLRPC$MessageRepliesTLdeserialize.recent_repliers.size() > 3) {
                                    tLRPC$MessageRepliesTLdeserialize.recent_repliers.remove(0);
                                }
                                tLRPC$MessageReplies = tLRPC$MessageRepliesTLdeserialize;
                            }
                            if (tLRPC$MessageRepliesTLdeserialize != null) {
                                long j2 = tLRPC$MessageRepliesTLdeserialize.read_max_id;
                                if (j2 > tLRPC$MessageReplies.read_max_id) {
                                    tLRPC$MessageReplies.read_max_id = j2;
                                }
                            }
                            sQLitePreparedStatementExecuteFast3.requery();
                            NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(tLRPC$MessageReplies.getObjectSize());
                            tLRPC$MessageReplies.serializeToStream(nativeByteBuffer);
                            sQLitePreparedStatementExecuteFast3.bindByteBuffer(1, nativeByteBuffer);
                            sQLitePreparedStatementExecuteFast3.bindLong(2, jKeyAt3);
                            sQLitePreparedStatementExecuteFast3.step();
                            nativeByteBuffer.reuse();
                            i7++;
                            longSparseArray4 = longSparseArray;
                            c = ' ';
                        } else {
                            longSparseArray = longSparseArray4;
                        }
                        i7++;
                        longSparseArray4 = longSparseArray;
                        c = ' ';
                    }
                    i6++;
                    c = ' ';
                }
                sQLitePreparedStatementExecuteFast3.dispose();
            }
            this.database.commitTransaction();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateRepliesMaxReadIdInternal, reason: merged with bridge method [inline-methods] */
    public void lambda$updateRepliesMaxReadId$116(int i, long j, long j2) {
        NativeByteBuffer nativeByteBufferByteBufferValue;
        try {
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("UPDATE messages SET replies_data = ? WHERE mid = ?");
            long j3 = j | (i << 32);
            TLRPC$MessageReplies tLRPC$MessageRepliesTLdeserialize = null;
            SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized("SELECT replies_data FROM messages WHERE mid = " + j3, new Object[0]);
            if (sQLiteCursorQueryFinalized.next() && (nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized.byteBufferValue(0)) != null) {
                tLRPC$MessageRepliesTLdeserialize = TLRPC$MessageReplies.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                nativeByteBufferByteBufferValue.reuse();
            }
            sQLiteCursorQueryFinalized.dispose();
            if (tLRPC$MessageRepliesTLdeserialize != null) {
                tLRPC$MessageRepliesTLdeserialize.read_max_id = j2;
                sQLitePreparedStatementExecuteFast.requery();
                NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(tLRPC$MessageRepliesTLdeserialize.getObjectSize());
                tLRPC$MessageRepliesTLdeserialize.serializeToStream(nativeByteBuffer);
                sQLitePreparedStatementExecuteFast.bindByteBuffer(1, nativeByteBuffer);
                sQLitePreparedStatementExecuteFast.bindLong(2, j3);
                sQLitePreparedStatementExecuteFast.step();
                nativeByteBuffer.reuse();
            }
            sQLitePreparedStatementExecuteFast.dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void updateRepliesMaxReadId(final int i, final long j, final long j2, boolean z) {
        if (z) {
            this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda38
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$updateRepliesMaxReadId$116(i, j, j2);
                }
            });
        } else {
            lambda$updateRepliesMaxReadId$116(i, j, j2);
        }
    }

    public void updateRepliesCount(final int i, final long j, final ArrayList<TLRPC$Peer> arrayList, final long j2, final int i2) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda62
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateRepliesCount$117(j, i, i2, arrayList, j2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateRepliesCount$117(long j, int i, int i2, ArrayList arrayList, long j2) {
        NativeByteBuffer nativeByteBufferByteBufferValue;
        try {
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("UPDATE messages SET replies_data = ? WHERE mid = ?");
            long j3 = j | (i << 32);
            TLRPC$MessageReplies tLRPC$MessageRepliesTLdeserialize = null;
            SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized("SELECT replies_data FROM messages WHERE mid = " + j3, new Object[0]);
            if (sQLiteCursorQueryFinalized.next() && (nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized.byteBufferValue(0)) != null) {
                tLRPC$MessageRepliesTLdeserialize = TLRPC$MessageReplies.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                nativeByteBufferByteBufferValue.reuse();
            }
            sQLiteCursorQueryFinalized.dispose();
            if (tLRPC$MessageRepliesTLdeserialize != null) {
                int i3 = tLRPC$MessageRepliesTLdeserialize.replies + i2;
                tLRPC$MessageRepliesTLdeserialize.replies = i3;
                if (i3 < 0) {
                    tLRPC$MessageRepliesTLdeserialize.replies = 0;
                }
                if (arrayList != null) {
                    tLRPC$MessageRepliesTLdeserialize.recent_repliers = arrayList;
                    tLRPC$MessageRepliesTLdeserialize.flags |= 2;
                }
                if (j2 != 0) {
                    tLRPC$MessageRepliesTLdeserialize.max_id = j2;
                }
                sQLitePreparedStatementExecuteFast.requery();
                NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(tLRPC$MessageRepliesTLdeserialize.getObjectSize());
                tLRPC$MessageRepliesTLdeserialize.serializeToStream(nativeByteBuffer);
                sQLitePreparedStatementExecuteFast.bindByteBuffer(1, nativeByteBuffer);
                sQLitePreparedStatementExecuteFast.bindLong(2, j3);
                sQLitePreparedStatementExecuteFast.step();
                nativeByteBuffer.reuse();
            }
            sQLitePreparedStatementExecuteFast.dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    private boolean isValidKeyboardToSave(TLRPC$Message tLRPC$Message) {
        TLRPC$ReplyMarkup tLRPC$ReplyMarkup = tLRPC$Message.reply_markup;
        return (tLRPC$ReplyMarkup == null || (tLRPC$ReplyMarkup instanceof TLRPC$TL_replyInlineMarkup) || (tLRPC$ReplyMarkup.selective && !tLRPC$Message.mentioned)) ? false : true;
    }

    public void updateMessageVerifyFlags(final ArrayList<TLRPC$Message> arrayList) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda93
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateMessageVerifyFlags$118(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateMessageVerifyFlags$118(ArrayList arrayList) {
        try {
            this.database.beginTransaction();
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("UPDATE messages SET imp = ? WHERE mid = ?");
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                TLRPC$Message tLRPC$Message = (TLRPC$Message) arrayList.get(i);
                sQLitePreparedStatementExecuteFast.requery();
                int i2 = tLRPC$Message.stickerVerified;
                sQLitePreparedStatementExecuteFast.bindInteger(1, i2 == 0 ? 1 : i2 == 2 ? 2 : 0);
                sQLitePreparedStatementExecuteFast.bindLong(2, tLRPC$Message.id);
                sQLitePreparedStatementExecuteFast.step();
            }
            sQLitePreparedStatementExecuteFast.dispose();
            this.database.commitTransaction();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0561 A[Catch: Exception -> 0x0121, TryCatch #1 {Exception -> 0x0121, blocks: (B:5:0x0010, B:6:0x0015, B:7:0x0029, B:9:0x002f, B:25:0x00b5, B:12:0x003c, B:16:0x0050, B:18:0x0056, B:19:0x0059, B:21:0x0091, B:22:0x00a1, B:24:0x00ae, B:26:0x00bf, B:28:0x00c7, B:29:0x00cc, B:31:0x00d3, B:33:0x00e1, B:35:0x00f0, B:36:0x00f3, B:38:0x0115, B:40:0x011b, B:46:0x0127, B:47:0x012c, B:48:0x018e, B:50:0x0194, B:52:0x01ac, B:53:0x01af, B:55:0x01b5, B:57:0x01c8, B:59:0x01cc, B:61:0x01d0, B:62:0x01d9, B:65:0x01e1, B:67:0x01e7, B:69:0x01eb, B:71:0x01f6, B:92:0x0279, B:95:0x0281, B:97:0x0299, B:99:0x029f, B:100:0x02a2, B:102:0x02c2, B:104:0x02c8, B:106:0x02d2, B:108:0x02da, B:109:0x02df, B:75:0x0202, B:77:0x020c, B:79:0x0231, B:81:0x023e, B:83:0x024a, B:85:0x0252, B:87:0x025d, B:89:0x0263, B:90:0x0266, B:80:0x023a, B:111:0x0302, B:113:0x0308, B:117:0x0320, B:118:0x0342, B:120:0x0348, B:122:0x0363, B:125:0x036d, B:126:0x0372, B:128:0x0383, B:129:0x0394, B:131:0x039a, B:133:0x03be, B:136:0x03df, B:137:0x03e4, B:139:0x03f5, B:141:0x0406, B:143:0x040e, B:146:0x0425, B:147:0x042a, B:144:0x041c, B:148:0x0437, B:134:0x03d3, B:151:0x044b, B:153:0x0451, B:154:0x0472, B:156:0x0478, B:157:0x0488, B:158:0x048e, B:160:0x0494, B:162:0x04a8, B:163:0x04ad, B:165:0x04c3, B:167:0x04c9, B:169:0x04dd, B:170:0x04e2, B:174:0x0503, B:176:0x0509, B:180:0x052a, B:182:0x0534, B:184:0x053e, B:186:0x0551, B:188:0x0557, B:196:0x0594, B:198:0x05a1, B:200:0x05a7, B:202:0x05af, B:208:0x05c0, B:214:0x05d4, B:216:0x0600, B:221:0x0608, B:223:0x0619, B:225:0x062a, B:233:0x0639, B:237:0x0643, B:239:0x0651, B:241:0x066e, B:243:0x0672, B:247:0x067f, B:249:0x0690, B:251:0x069b, B:253:0x06b4, B:256:0x06bc, B:257:0x06c4, B:259:0x06e9, B:261:0x06ed, B:264:0x06f8, B:266:0x0702, B:269:0x0727, B:272:0x072f, B:273:0x0737, B:279:0x0770, B:280:0x0773, B:282:0x0778, B:284:0x077e, B:286:0x0782, B:288:0x0790, B:290:0x079b, B:292:0x07a1, B:294:0x07a5, B:296:0x07a9, B:298:0x07b7, B:324:0x085b, B:326:0x0861, B:327:0x086c, B:329:0x08a1, B:331:0x08a5, B:333:0x08c7, B:299:0x07ca, B:301:0x07d0, B:304:0x07d8, B:306:0x07de, B:308:0x07e4, B:312:0x07ed, B:314:0x0806, B:316:0x0812, B:318:0x0827, B:320:0x0832, B:321:0x0848, B:275:0x0752, B:277:0x0756, B:246:0x067d, B:248:0x0687, B:240:0x0668, B:224:0x0621, B:212:0x05c9, B:191:0x0561, B:193:0x0565, B:334:0x08da, B:336:0x08f0, B:338:0x08f5, B:340:0x0902, B:341:0x0905, B:342:0x0924, B:344:0x092a, B:416:0x0b1b, B:347:0x0951, B:349:0x095a, B:351:0x0961, B:353:0x0981, B:358:0x09b7, B:360:0x09cc, B:364:0x09e9, B:415:0x0b14, B:366:0x09f4, B:362:0x09d7, B:356:0x09aa, B:417:0x0b2c, B:419:0x0b3c, B:420:0x0b45, B:422:0x0b4b, B:423:0x0b58, B:425:0x0b5e, B:427:0x0b8e, B:429:0x0b9a, B:431:0x0ba0, B:433:0x0bcb, B:434:0x0bd2, B:435:0x0be1, B:438:0x0beb, B:439:0x0bf0, B:441:0x0c03, B:442:0x0c0d), top: B:448:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:271:0x072d  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x0752 A[Catch: Exception -> 0x0121, TryCatch #1 {Exception -> 0x0121, blocks: (B:5:0x0010, B:6:0x0015, B:7:0x0029, B:9:0x002f, B:25:0x00b5, B:12:0x003c, B:16:0x0050, B:18:0x0056, B:19:0x0059, B:21:0x0091, B:22:0x00a1, B:24:0x00ae, B:26:0x00bf, B:28:0x00c7, B:29:0x00cc, B:31:0x00d3, B:33:0x00e1, B:35:0x00f0, B:36:0x00f3, B:38:0x0115, B:40:0x011b, B:46:0x0127, B:47:0x012c, B:48:0x018e, B:50:0x0194, B:52:0x01ac, B:53:0x01af, B:55:0x01b5, B:57:0x01c8, B:59:0x01cc, B:61:0x01d0, B:62:0x01d9, B:65:0x01e1, B:67:0x01e7, B:69:0x01eb, B:71:0x01f6, B:92:0x0279, B:95:0x0281, B:97:0x0299, B:99:0x029f, B:100:0x02a2, B:102:0x02c2, B:104:0x02c8, B:106:0x02d2, B:108:0x02da, B:109:0x02df, B:75:0x0202, B:77:0x020c, B:79:0x0231, B:81:0x023e, B:83:0x024a, B:85:0x0252, B:87:0x025d, B:89:0x0263, B:90:0x0266, B:80:0x023a, B:111:0x0302, B:113:0x0308, B:117:0x0320, B:118:0x0342, B:120:0x0348, B:122:0x0363, B:125:0x036d, B:126:0x0372, B:128:0x0383, B:129:0x0394, B:131:0x039a, B:133:0x03be, B:136:0x03df, B:137:0x03e4, B:139:0x03f5, B:141:0x0406, B:143:0x040e, B:146:0x0425, B:147:0x042a, B:144:0x041c, B:148:0x0437, B:134:0x03d3, B:151:0x044b, B:153:0x0451, B:154:0x0472, B:156:0x0478, B:157:0x0488, B:158:0x048e, B:160:0x0494, B:162:0x04a8, B:163:0x04ad, B:165:0x04c3, B:167:0x04c9, B:169:0x04dd, B:170:0x04e2, B:174:0x0503, B:176:0x0509, B:180:0x052a, B:182:0x0534, B:184:0x053e, B:186:0x0551, B:188:0x0557, B:196:0x0594, B:198:0x05a1, B:200:0x05a7, B:202:0x05af, B:208:0x05c0, B:214:0x05d4, B:216:0x0600, B:221:0x0608, B:223:0x0619, B:225:0x062a, B:233:0x0639, B:237:0x0643, B:239:0x0651, B:241:0x066e, B:243:0x0672, B:247:0x067f, B:249:0x0690, B:251:0x069b, B:253:0x06b4, B:256:0x06bc, B:257:0x06c4, B:259:0x06e9, B:261:0x06ed, B:264:0x06f8, B:266:0x0702, B:269:0x0727, B:272:0x072f, B:273:0x0737, B:279:0x0770, B:280:0x0773, B:282:0x0778, B:284:0x077e, B:286:0x0782, B:288:0x0790, B:290:0x079b, B:292:0x07a1, B:294:0x07a5, B:296:0x07a9, B:298:0x07b7, B:324:0x085b, B:326:0x0861, B:327:0x086c, B:329:0x08a1, B:331:0x08a5, B:333:0x08c7, B:299:0x07ca, B:301:0x07d0, B:304:0x07d8, B:306:0x07de, B:308:0x07e4, B:312:0x07ed, B:314:0x0806, B:316:0x0812, B:318:0x0827, B:320:0x0832, B:321:0x0848, B:275:0x0752, B:277:0x0756, B:246:0x067d, B:248:0x0687, B:240:0x0668, B:224:0x0621, B:212:0x05c9, B:191:0x0561, B:193:0x0565, B:334:0x08da, B:336:0x08f0, B:338:0x08f5, B:340:0x0902, B:341:0x0905, B:342:0x0924, B:344:0x092a, B:416:0x0b1b, B:347:0x0951, B:349:0x095a, B:351:0x0961, B:353:0x0981, B:358:0x09b7, B:360:0x09cc, B:364:0x09e9, B:415:0x0b14, B:366:0x09f4, B:362:0x09d7, B:356:0x09aa, B:417:0x0b2c, B:419:0x0b3c, B:420:0x0b45, B:422:0x0b4b, B:423:0x0b58, B:425:0x0b5e, B:427:0x0b8e, B:429:0x0b9a, B:431:0x0ba0, B:433:0x0bcb, B:434:0x0bd2, B:435:0x0be1, B:438:0x0beb, B:439:0x0bf0, B:441:0x0c03, B:442:0x0c0d), top: B:448:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:279:0x0770 A[Catch: Exception -> 0x0121, TryCatch #1 {Exception -> 0x0121, blocks: (B:5:0x0010, B:6:0x0015, B:7:0x0029, B:9:0x002f, B:25:0x00b5, B:12:0x003c, B:16:0x0050, B:18:0x0056, B:19:0x0059, B:21:0x0091, B:22:0x00a1, B:24:0x00ae, B:26:0x00bf, B:28:0x00c7, B:29:0x00cc, B:31:0x00d3, B:33:0x00e1, B:35:0x00f0, B:36:0x00f3, B:38:0x0115, B:40:0x011b, B:46:0x0127, B:47:0x012c, B:48:0x018e, B:50:0x0194, B:52:0x01ac, B:53:0x01af, B:55:0x01b5, B:57:0x01c8, B:59:0x01cc, B:61:0x01d0, B:62:0x01d9, B:65:0x01e1, B:67:0x01e7, B:69:0x01eb, B:71:0x01f6, B:92:0x0279, B:95:0x0281, B:97:0x0299, B:99:0x029f, B:100:0x02a2, B:102:0x02c2, B:104:0x02c8, B:106:0x02d2, B:108:0x02da, B:109:0x02df, B:75:0x0202, B:77:0x020c, B:79:0x0231, B:81:0x023e, B:83:0x024a, B:85:0x0252, B:87:0x025d, B:89:0x0263, B:90:0x0266, B:80:0x023a, B:111:0x0302, B:113:0x0308, B:117:0x0320, B:118:0x0342, B:120:0x0348, B:122:0x0363, B:125:0x036d, B:126:0x0372, B:128:0x0383, B:129:0x0394, B:131:0x039a, B:133:0x03be, B:136:0x03df, B:137:0x03e4, B:139:0x03f5, B:141:0x0406, B:143:0x040e, B:146:0x0425, B:147:0x042a, B:144:0x041c, B:148:0x0437, B:134:0x03d3, B:151:0x044b, B:153:0x0451, B:154:0x0472, B:156:0x0478, B:157:0x0488, B:158:0x048e, B:160:0x0494, B:162:0x04a8, B:163:0x04ad, B:165:0x04c3, B:167:0x04c9, B:169:0x04dd, B:170:0x04e2, B:174:0x0503, B:176:0x0509, B:180:0x052a, B:182:0x0534, B:184:0x053e, B:186:0x0551, B:188:0x0557, B:196:0x0594, B:198:0x05a1, B:200:0x05a7, B:202:0x05af, B:208:0x05c0, B:214:0x05d4, B:216:0x0600, B:221:0x0608, B:223:0x0619, B:225:0x062a, B:233:0x0639, B:237:0x0643, B:239:0x0651, B:241:0x066e, B:243:0x0672, B:247:0x067f, B:249:0x0690, B:251:0x069b, B:253:0x06b4, B:256:0x06bc, B:257:0x06c4, B:259:0x06e9, B:261:0x06ed, B:264:0x06f8, B:266:0x0702, B:269:0x0727, B:272:0x072f, B:273:0x0737, B:279:0x0770, B:280:0x0773, B:282:0x0778, B:284:0x077e, B:286:0x0782, B:288:0x0790, B:290:0x079b, B:292:0x07a1, B:294:0x07a5, B:296:0x07a9, B:298:0x07b7, B:324:0x085b, B:326:0x0861, B:327:0x086c, B:329:0x08a1, B:331:0x08a5, B:333:0x08c7, B:299:0x07ca, B:301:0x07d0, B:304:0x07d8, B:306:0x07de, B:308:0x07e4, B:312:0x07ed, B:314:0x0806, B:316:0x0812, B:318:0x0827, B:320:0x0832, B:321:0x0848, B:275:0x0752, B:277:0x0756, B:246:0x067d, B:248:0x0687, B:240:0x0668, B:224:0x0621, B:212:0x05c9, B:191:0x0561, B:193:0x0565, B:334:0x08da, B:336:0x08f0, B:338:0x08f5, B:340:0x0902, B:341:0x0905, B:342:0x0924, B:344:0x092a, B:416:0x0b1b, B:347:0x0951, B:349:0x095a, B:351:0x0961, B:353:0x0981, B:358:0x09b7, B:360:0x09cc, B:364:0x09e9, B:415:0x0b14, B:366:0x09f4, B:362:0x09d7, B:356:0x09aa, B:417:0x0b2c, B:419:0x0b3c, B:420:0x0b45, B:422:0x0b4b, B:423:0x0b58, B:425:0x0b5e, B:427:0x0b8e, B:429:0x0b9a, B:431:0x0ba0, B:433:0x0bcb, B:434:0x0bd2, B:435:0x0be1, B:438:0x0beb, B:439:0x0bf0, B:441:0x0c03, B:442:0x0c0d), top: B:448:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:282:0x0778 A[Catch: Exception -> 0x0121, TryCatch #1 {Exception -> 0x0121, blocks: (B:5:0x0010, B:6:0x0015, B:7:0x0029, B:9:0x002f, B:25:0x00b5, B:12:0x003c, B:16:0x0050, B:18:0x0056, B:19:0x0059, B:21:0x0091, B:22:0x00a1, B:24:0x00ae, B:26:0x00bf, B:28:0x00c7, B:29:0x00cc, B:31:0x00d3, B:33:0x00e1, B:35:0x00f0, B:36:0x00f3, B:38:0x0115, B:40:0x011b, B:46:0x0127, B:47:0x012c, B:48:0x018e, B:50:0x0194, B:52:0x01ac, B:53:0x01af, B:55:0x01b5, B:57:0x01c8, B:59:0x01cc, B:61:0x01d0, B:62:0x01d9, B:65:0x01e1, B:67:0x01e7, B:69:0x01eb, B:71:0x01f6, B:92:0x0279, B:95:0x0281, B:97:0x0299, B:99:0x029f, B:100:0x02a2, B:102:0x02c2, B:104:0x02c8, B:106:0x02d2, B:108:0x02da, B:109:0x02df, B:75:0x0202, B:77:0x020c, B:79:0x0231, B:81:0x023e, B:83:0x024a, B:85:0x0252, B:87:0x025d, B:89:0x0263, B:90:0x0266, B:80:0x023a, B:111:0x0302, B:113:0x0308, B:117:0x0320, B:118:0x0342, B:120:0x0348, B:122:0x0363, B:125:0x036d, B:126:0x0372, B:128:0x0383, B:129:0x0394, B:131:0x039a, B:133:0x03be, B:136:0x03df, B:137:0x03e4, B:139:0x03f5, B:141:0x0406, B:143:0x040e, B:146:0x0425, B:147:0x042a, B:144:0x041c, B:148:0x0437, B:134:0x03d3, B:151:0x044b, B:153:0x0451, B:154:0x0472, B:156:0x0478, B:157:0x0488, B:158:0x048e, B:160:0x0494, B:162:0x04a8, B:163:0x04ad, B:165:0x04c3, B:167:0x04c9, B:169:0x04dd, B:170:0x04e2, B:174:0x0503, B:176:0x0509, B:180:0x052a, B:182:0x0534, B:184:0x053e, B:186:0x0551, B:188:0x0557, B:196:0x0594, B:198:0x05a1, B:200:0x05a7, B:202:0x05af, B:208:0x05c0, B:214:0x05d4, B:216:0x0600, B:221:0x0608, B:223:0x0619, B:225:0x062a, B:233:0x0639, B:237:0x0643, B:239:0x0651, B:241:0x066e, B:243:0x0672, B:247:0x067f, B:249:0x0690, B:251:0x069b, B:253:0x06b4, B:256:0x06bc, B:257:0x06c4, B:259:0x06e9, B:261:0x06ed, B:264:0x06f8, B:266:0x0702, B:269:0x0727, B:272:0x072f, B:273:0x0737, B:279:0x0770, B:280:0x0773, B:282:0x0778, B:284:0x077e, B:286:0x0782, B:288:0x0790, B:290:0x079b, B:292:0x07a1, B:294:0x07a5, B:296:0x07a9, B:298:0x07b7, B:324:0x085b, B:326:0x0861, B:327:0x086c, B:329:0x08a1, B:331:0x08a5, B:333:0x08c7, B:299:0x07ca, B:301:0x07d0, B:304:0x07d8, B:306:0x07de, B:308:0x07e4, B:312:0x07ed, B:314:0x0806, B:316:0x0812, B:318:0x0827, B:320:0x0832, B:321:0x0848, B:275:0x0752, B:277:0x0756, B:246:0x067d, B:248:0x0687, B:240:0x0668, B:224:0x0621, B:212:0x05c9, B:191:0x0561, B:193:0x0565, B:334:0x08da, B:336:0x08f0, B:338:0x08f5, B:340:0x0902, B:341:0x0905, B:342:0x0924, B:344:0x092a, B:416:0x0b1b, B:347:0x0951, B:349:0x095a, B:351:0x0961, B:353:0x0981, B:358:0x09b7, B:360:0x09cc, B:364:0x09e9, B:415:0x0b14, B:366:0x09f4, B:362:0x09d7, B:356:0x09aa, B:417:0x0b2c, B:419:0x0b3c, B:420:0x0b45, B:422:0x0b4b, B:423:0x0b58, B:425:0x0b5e, B:427:0x0b8e, B:429:0x0b9a, B:431:0x0ba0, B:433:0x0bcb, B:434:0x0bd2, B:435:0x0be1, B:438:0x0beb, B:439:0x0bf0, B:441:0x0c03, B:442:0x0c0d), top: B:448:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:332:0x08c1  */
    /* JADX WARN: Removed duplicated region for block: B:382:0x0a29 A[Catch: Exception -> 0x0a0b, TryCatch #0 {Exception -> 0x0a0b, blocks: (B:370:0x0a08, B:375:0x0a15, B:382:0x0a29, B:385:0x0a34, B:387:0x0a3a, B:390:0x0a44, B:392:0x0a4a, B:394:0x0a52, B:396:0x0a61, B:400:0x0a6a, B:402:0x0a71, B:403:0x0aa8, B:407:0x0abc, B:409:0x0ac1, B:413:0x0af0, B:373:0x0a10), top: B:446:0x0a08 }] */
    /* JADX WARN: Removed duplicated region for block: B:383:0x0a30  */
    /* JADX WARN: Removed duplicated region for block: B:388:0x0a40  */
    /* JADX WARN: Removed duplicated region for block: B:393:0x0a50  */
    /* JADX WARN: Removed duplicated region for block: B:396:0x0a61 A[Catch: Exception -> 0x0a0b, TryCatch #0 {Exception -> 0x0a0b, blocks: (B:370:0x0a08, B:375:0x0a15, B:382:0x0a29, B:385:0x0a34, B:387:0x0a3a, B:390:0x0a44, B:392:0x0a4a, B:394:0x0a52, B:396:0x0a61, B:400:0x0a6a, B:402:0x0a71, B:403:0x0aa8, B:407:0x0abc, B:409:0x0ac1, B:413:0x0af0, B:373:0x0a10), top: B:446:0x0a08 }] */
    /* JADX WARN: Removed duplicated region for block: B:403:0x0aa8 A[Catch: Exception -> 0x0a0b, TryCatch #0 {Exception -> 0x0a0b, blocks: (B:370:0x0a08, B:375:0x0a15, B:382:0x0a29, B:385:0x0a34, B:387:0x0a3a, B:390:0x0a44, B:392:0x0a4a, B:394:0x0a52, B:396:0x0a61, B:400:0x0a6a, B:402:0x0a71, B:403:0x0aa8, B:407:0x0abc, B:409:0x0ac1, B:413:0x0af0, B:373:0x0a10), top: B:446:0x0a08 }] */
    /* renamed from: putMessagesInternal, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void lambda$putMessages$120(java.util.ArrayList<org.rbmain.tgnet.TLRPC$Message> r42, boolean r43, boolean r44, int r45, boolean r46, boolean r47) {
        /*
            Method dump skipped, instructions count: 3095
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.MessagesStorage.lambda$putMessages$120(java.util.ArrayList, boolean, boolean, int, boolean, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$putMessagesInternal$119(int i) {
        getDownloadController().newDownloadObjectsAvailable(i);
    }

    public void putMessages(ArrayList<TLRPC$Message> arrayList, boolean z, boolean z2, boolean z3, int i, boolean z4) {
        putMessages(arrayList, z, z2, z3, i, false, z4);
    }

    public void putMessages(final ArrayList<TLRPC$Message> arrayList, final boolean z, boolean z2, final boolean z3, final int i, final boolean z4, final boolean z5) {
        if (arrayList.size() == 0) {
            return;
        }
        if (z2) {
            this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda115
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$putMessages$120(arrayList, z, z3, i, z4, z5);
                }
            });
        } else {
            lambda$putMessages$120(arrayList, z, z3, i, z4, z5);
        }
    }

    public void markMessageAsSendError(final TLRPC$Message tLRPC$Message, final boolean z) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda132
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$markMessageAsSendError$121(tLRPC$Message, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$markMessageAsSendError$121(TLRPC$Message tLRPC$Message, boolean z) {
        try {
            long j = tLRPC$Message.id;
            int i = tLRPC$Message.peer_id.channel_id;
            if (i != 0) {
                j |= i << 32;
            }
            if (z) {
                this.database.executeFast("UPDATE scheduled_messages SET send_state = 2 WHERE mid = " + j).stepThis().dispose();
                return;
            }
            this.database.executeFast("UPDATE messages SET send_state = 2 WHERE mid = " + j).stepThis().dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void setMessageSeq(final long j, final int i, final int i2) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda59
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setMessageSeq$122(j, i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMessageSeq$122(long j, int i, int i2) {
        try {
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("REPLACE INTO messages_seq VALUES(?, ?, ?)");
            sQLitePreparedStatementExecuteFast.requery();
            sQLitePreparedStatementExecuteFast.bindLong(1, j);
            sQLitePreparedStatementExecuteFast.bindInteger(2, i);
            sQLitePreparedStatementExecuteFast.bindInteger(3, i2);
            sQLitePreparedStatementExecuteFast.step();
            sQLitePreparedStatementExecuteFast.dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0196 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x027a A[PHI: r2
      0x027a: PHI (r2v11 org.rbmain.SQLite.SQLitePreparedStatement) = (r2v7 org.rbmain.SQLite.SQLitePreparedStatement), (r2v12 org.rbmain.SQLite.SQLitePreparedStatement) binds: [B:151:0x0278, B:143:0x0240] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0122 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:215:0x015e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0141 A[Catch: all -> 0x014d, Exception -> 0x0150, TRY_LEAVE, TryCatch #12 {Exception -> 0x0150, blocks: (B:75:0x0122, B:77:0x0141), top: B:213:0x0122, outer: #22 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x017d A[Catch: all -> 0x0188, Exception -> 0x018b, TRY_LEAVE, TryCatch #14 {Exception -> 0x018b, blocks: (B:89:0x015e, B:91:0x017d), top: B:215:0x015e, outer: #18 }] */
    /* JADX WARN: Type inference failed for: r0v28, types: [org.rbmain.SQLite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v4, types: [int] */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v8, types: [org.rbmain.SQLite.SQLitePreparedStatement] */
    /* JADX WARN: Type inference failed for: r5v11, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v28, types: [org.rbmain.SQLite.SQLitePreparedStatement] */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v30 */
    /* JADX WARN: Type inference failed for: r5v31 */
    /* JADX WARN: Type inference failed for: r5v32, types: [org.rbmain.SQLite.SQLitePreparedStatement] */
    /* JADX WARN: Type inference failed for: r5v33, types: [org.rbmain.SQLite.SQLitePreparedStatement] */
    /* JADX WARN: Type inference failed for: r5v43 */
    /* JADX WARN: Type inference failed for: r5v44 */
    /* JADX WARN: Type inference failed for: r5v45 */
    /* JADX WARN: Type inference failed for: r5v46 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* renamed from: updateMessageStateAndIdInternal, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long[] lambda$updateMessageStateAndId$124(long r22, java.lang.Long r24, long r25, int r27, int r28, int r29) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 790
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.MessagesStorage.lambda$updateMessageStateAndId$124(long, java.lang.Long, long, int, int, int):long[]");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateMessageStateAndIdInternal$123(TLRPC$TL_updates tLRPC$TL_updates) {
        getMessagesController().processUpdates(tLRPC$TL_updates, false);
    }

    public long[] updateMessageStateAndId(final long j, final Long l, final long j2, final int i, boolean z, final int i2, final int i3) {
        if (z) {
            this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda69
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    this.f$0.lambda$updateMessageStateAndId$124(j, l, j2, i, i2, i3);
                }
            });
            return null;
        }
        return lambda$updateMessageStateAndId$124(j, l, j2, i, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateUsersInternal, reason: merged with bridge method [inline-methods] */
    public void lambda$updateUsers$125(ArrayList<TLRPC$User> arrayList, boolean z, boolean z2) {
        try {
            if (z) {
                if (z2) {
                    this.database.beginTransaction();
                }
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("UPDATE users SET status = ? WHERE uid = ?");
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    TLRPC$User tLRPC$User = arrayList.get(i);
                    sQLitePreparedStatementExecuteFast.requery();
                    TLRPC$UserStatus tLRPC$UserStatus = tLRPC$User.status;
                    if (tLRPC$UserStatus != null) {
                        sQLitePreparedStatementExecuteFast.bindInteger(1, tLRPC$UserStatus.expires);
                    } else {
                        sQLitePreparedStatementExecuteFast.bindInteger(1, 0);
                    }
                    sQLitePreparedStatementExecuteFast.bindInteger(2, tLRPC$User.id);
                    sQLitePreparedStatementExecuteFast.step();
                }
                sQLitePreparedStatementExecuteFast.dispose();
                if (z2) {
                    this.database.commitTransaction();
                    return;
                }
                return;
            }
            StringBuilder sb = new StringBuilder();
            SparseArray sparseArray = new SparseArray();
            int size2 = arrayList.size();
            for (int i2 = 0; i2 < size2; i2++) {
                TLRPC$User tLRPC$User2 = arrayList.get(i2);
                if (sb.length() != 0) {
                    sb.append(",");
                }
                sb.append(tLRPC$User2.id);
                sparseArray.put(tLRPC$User2.id, tLRPC$User2);
            }
            ArrayList<TLRPC$User> arrayList2 = new ArrayList<>();
            getUsersInternal(sb.toString(), arrayList2);
            int size3 = arrayList2.size();
            for (int i3 = 0; i3 < size3; i3++) {
                TLRPC$User tLRPC$User3 = arrayList2.get(i3);
                TLRPC$User tLRPC$User4 = (TLRPC$User) sparseArray.get(tLRPC$User3.id);
                if (tLRPC$User4 != null) {
                    if (tLRPC$User4.first_name != null && tLRPC$User4.last_name != null) {
                        if (!UserObject.isContact(tLRPC$User3)) {
                            tLRPC$User3.first_name = tLRPC$User4.first_name;
                            tLRPC$User3.last_name = tLRPC$User4.last_name;
                        }
                        tLRPC$User3.username = tLRPC$User4.username;
                    } else {
                        TLRPC$UserProfilePhoto tLRPC$UserProfilePhoto = tLRPC$User4.photo;
                        if (tLRPC$UserProfilePhoto != null) {
                            tLRPC$User3.photo = tLRPC$UserProfilePhoto;
                        } else {
                            String str = tLRPC$User4.phone;
                            if (str != null) {
                                tLRPC$User3.phone = str;
                            }
                        }
                    }
                }
            }
            if (arrayList2.isEmpty()) {
                return;
            }
            if (z2) {
                this.database.beginTransaction();
            }
            putUsersInternal(arrayList2);
            if (z2) {
                this.database.commitTransaction();
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void updateUsers(final ArrayList<TLRPC$User> arrayList, final boolean z, final boolean z2, boolean z3) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (z3) {
            this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda114
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$updateUsers$125(arrayList, z, z2);
                }
            });
        } else {
            lambda$updateUsers$125(arrayList, z, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: markMessagesAsReadInternal, reason: merged with bridge method [inline-methods] */
    public void lambda$markMessagesAsRead$127(SparseLongArray sparseLongArray, SparseLongArray sparseLongArray2, SparseIntArray sparseIntArray) {
        try {
            if (!isEmpty(sparseLongArray)) {
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("DELETE FROM unread_push_messages WHERE uid = ? AND mid <= ?");
                for (int i = 0; i < sparseLongArray.size(); i++) {
                    int iKeyAt = sparseLongArray.keyAt(i);
                    long j = sparseLongArray.get(iKeyAt);
                    this.database.executeFast(String.format(Locale.US, "UPDATE messages SET read_state = read_state | 1 WHERE uid = %d AND mid > 0 AND mid <= %d AND read_state IN(0,2) AND out = 0", Integer.valueOf(iKeyAt), Long.valueOf(j))).stepThis().dispose();
                    sQLitePreparedStatementExecuteFast.requery();
                    sQLitePreparedStatementExecuteFast.bindLong(1, iKeyAt);
                    sQLitePreparedStatementExecuteFast.bindLong(2, j);
                    sQLitePreparedStatementExecuteFast.step();
                }
                sQLitePreparedStatementExecuteFast.dispose();
            }
            if (!isEmpty(sparseLongArray2)) {
                for (int i2 = 0; i2 < sparseLongArray2.size(); i2++) {
                    int iKeyAt2 = sparseLongArray2.keyAt(i2);
                    this.database.executeFast(String.format(Locale.US, "UPDATE messages SET read_state = read_state | 1 WHERE uid = %d AND mid > 0 AND mid <= %d AND read_state IN(0,2) AND out = 1", Integer.valueOf(iKeyAt2), Long.valueOf(sparseLongArray2.get(iKeyAt2)))).stepThis().dispose();
                }
            }
            if (sparseIntArray == null || isEmpty(sparseIntArray)) {
                return;
            }
            for (int i3 = 0; i3 < sparseIntArray.size(); i3++) {
                int iValueAt = sparseIntArray.valueAt(i3);
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast2 = this.database.executeFast("UPDATE messages SET read_state = read_state | 1 WHERE uid = ? AND date <= ? AND read_state IN(0,2) AND out = 1");
                sQLitePreparedStatementExecuteFast2.requery();
                sQLitePreparedStatementExecuteFast2.bindLong(1, sparseIntArray.keyAt(i3) << 32);
                sQLitePreparedStatementExecuteFast2.bindInteger(2, iValueAt);
                sQLitePreparedStatementExecuteFast2.step();
                sQLitePreparedStatementExecuteFast2.dispose();
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void markMessagesContentAsRead(final ArrayList<Long> arrayList, final int i) {
        if (isEmpty(arrayList)) {
            return;
        }
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda103
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$markMessagesContentAsRead$126(arrayList, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$markMessagesContentAsRead$126(ArrayList arrayList, int i) {
        try {
            String strJoin = TextUtils.join(",", arrayList);
            SQLiteDatabase sQLiteDatabase = this.database;
            Locale locale = Locale.US;
            sQLiteDatabase.executeFast(String.format(locale, "UPDATE messages SET read_state = read_state | 2 WHERE mid IN (%s)", strJoin)).stepThis().dispose();
            if (i != 0) {
                SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(locale, "SELECT mid, ttl FROM messages WHERE mid IN (%s) AND ttl > 0", strJoin), new Object[0]);
                ArrayList<Long> arrayList2 = null;
                while (sQLiteCursorQueryFinalized.next()) {
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList<>();
                    }
                    arrayList2.add(Long.valueOf(sQLiteCursorQueryFinalized.longValue(0)));
                }
                if (arrayList2 != null) {
                    emptyMessagesMedia(arrayList2);
                }
                sQLiteCursorQueryFinalized.dispose();
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void markMessagesAsRead(final SparseLongArray sparseLongArray, final SparseLongArray sparseLongArray2, final SparseIntArray sparseIntArray, boolean z) {
        if (z) {
            this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda119
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$markMessagesAsRead$127(sparseLongArray, sparseLongArray2, sparseIntArray);
                }
            });
        } else {
            lambda$markMessagesAsRead$127(sparseLongArray, sparseLongArray2, sparseIntArray);
        }
    }

    public void markMessagesAsDeletedByRandoms(final ArrayList<Long> arrayList) {
        if (arrayList.isEmpty()) {
            return;
        }
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda95
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$markMessagesAsDeletedByRandoms$129(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$markMessagesAsDeletedByRandoms$129(ArrayList arrayList) {
        try {
            SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT mid FROM randoms WHERE random_id IN(%s)", TextUtils.join(",", arrayList)), new Object[0]);
            final ArrayList<Long> arrayList2 = new ArrayList<>();
            while (sQLiteCursorQueryFinalized.next()) {
                arrayList2.add(Long.valueOf(sQLiteCursorQueryFinalized.longValue(0)));
            }
            sQLiteCursorQueryFinalized.dispose();
            if (arrayList2.isEmpty()) {
                return;
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda92
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$markMessagesAsDeletedByRandoms$128(arrayList2);
                }
            });
            updateDialogsWithReadMessagesInternal(arrayList2, null, null, null);
            lambda$markMessagesAsDeleted$133(arrayList2, 0, true, false);
            lambda$updateDialogsWithDeletedMessages$132(arrayList2, null, 0);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$markMessagesAsDeletedByRandoms$128(ArrayList arrayList) {
        getNotificationCenter().postNotificationName(NotificationCenter.messagesDeleted, arrayList, 0, Boolean.FALSE);
    }

    protected void deletePushMessages(long j, ArrayList<Long> arrayList) {
        try {
            this.database.executeFast(String.format(Locale.US, "DELETE FROM unread_push_messages WHERE uid = %d AND mid IN(%s)", Long.valueOf(j), TextUtils.join(",", arrayList))).stepThis().dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    private void broadcastScheduledMessagesChange(final Long l) {
        try {
            SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT COUNT(mid) FROM scheduled_messages WHERE uid = %d", l), new Object[0]);
            final int iIntValue = sQLiteCursorQueryFinalized.next() ? sQLiteCursorQueryFinalized.intValue(0) : 0;
            sQLiteCursorQueryFinalized.dispose();
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda84
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$broadcastScheduledMessagesChange$130(l, iIntValue);
                }
            });
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$broadcastScheduledMessagesChange$130(Long l, int i) {
        getNotificationCenter().postNotificationName(NotificationCenter.scheduledMessagesUpdated, l, Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:103:0x02e7 A[Catch: Exception -> 0x05b8, TryCatch #3 {Exception -> 0x05b8, blocks: (B:3:0x0006, B:7:0x0017, B:8:0x0021, B:10:0x0027, B:12:0x003c, B:13:0x003f, B:14:0x0047, B:16:0x0054, B:25:0x008e, B:27:0x00b0, B:24:0x008b, B:15:0x004e, B:29:0x00c0, B:31:0x00d3, B:32:0x00dd, B:34:0x00e3, B:36:0x00f6, B:37:0x00f9, B:38:0x0100, B:40:0x0109, B:92:0x023c, B:93:0x023f, B:94:0x025b, B:96:0x0261, B:98:0x028b, B:100:0x0297, B:101:0x02de, B:103:0x02e7, B:106:0x02fc, B:109:0x034f, B:111:0x0382, B:113:0x0388, B:115:0x038d, B:117:0x03ab, B:118:0x03ce, B:119:0x03d1, B:107:0x0324, B:120:0x03d8, B:122:0x0444, B:123:0x0459, B:125:0x045f, B:127:0x046a, B:128:0x046f, B:130:0x0477, B:133:0x048e, B:134:0x0493, B:131:0x0485, B:135:0x04a2, B:137:0x04a7, B:138:0x04b0, B:140:0x04b6, B:141:0x04c1, B:143:0x04c7, B:145:0x04f8, B:147:0x0504, B:149:0x0509, B:151:0x0532, B:152:0x0539, B:153:0x0545, B:159:0x0582, B:161:0x05ae, B:162:0x05b2, B:157:0x0554, B:158:0x0564, B:39:0x0105, B:17:0x006e, B:19:0x0074, B:21:0x0082), top: B:173:0x0006, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0444 A[Catch: Exception -> 0x05b8, TryCatch #3 {Exception -> 0x05b8, blocks: (B:3:0x0006, B:7:0x0017, B:8:0x0021, B:10:0x0027, B:12:0x003c, B:13:0x003f, B:14:0x0047, B:16:0x0054, B:25:0x008e, B:27:0x00b0, B:24:0x008b, B:15:0x004e, B:29:0x00c0, B:31:0x00d3, B:32:0x00dd, B:34:0x00e3, B:36:0x00f6, B:37:0x00f9, B:38:0x0100, B:40:0x0109, B:92:0x023c, B:93:0x023f, B:94:0x025b, B:96:0x0261, B:98:0x028b, B:100:0x0297, B:101:0x02de, B:103:0x02e7, B:106:0x02fc, B:109:0x034f, B:111:0x0382, B:113:0x0388, B:115:0x038d, B:117:0x03ab, B:118:0x03ce, B:119:0x03d1, B:107:0x0324, B:120:0x03d8, B:122:0x0444, B:123:0x0459, B:125:0x045f, B:127:0x046a, B:128:0x046f, B:130:0x0477, B:133:0x048e, B:134:0x0493, B:131:0x0485, B:135:0x04a2, B:137:0x04a7, B:138:0x04b0, B:140:0x04b6, B:141:0x04c1, B:143:0x04c7, B:145:0x04f8, B:147:0x0504, B:149:0x0509, B:151:0x0532, B:152:0x0539, B:153:0x0545, B:159:0x0582, B:161:0x05ae, B:162:0x05b2, B:157:0x0554, B:158:0x0564, B:39:0x0105, B:17:0x006e, B:19:0x0074, B:21:0x0082), top: B:173:0x0006, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x054e  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x05ae A[Catch: Exception -> 0x05b8, TryCatch #3 {Exception -> 0x05b8, blocks: (B:3:0x0006, B:7:0x0017, B:8:0x0021, B:10:0x0027, B:12:0x003c, B:13:0x003f, B:14:0x0047, B:16:0x0054, B:25:0x008e, B:27:0x00b0, B:24:0x008b, B:15:0x004e, B:29:0x00c0, B:31:0x00d3, B:32:0x00dd, B:34:0x00e3, B:36:0x00f6, B:37:0x00f9, B:38:0x0100, B:40:0x0109, B:92:0x023c, B:93:0x023f, B:94:0x025b, B:96:0x0261, B:98:0x028b, B:100:0x0297, B:101:0x02de, B:103:0x02e7, B:106:0x02fc, B:109:0x034f, B:111:0x0382, B:113:0x0388, B:115:0x038d, B:117:0x03ab, B:118:0x03ce, B:119:0x03d1, B:107:0x0324, B:120:0x03d8, B:122:0x0444, B:123:0x0459, B:125:0x045f, B:127:0x046a, B:128:0x046f, B:130:0x0477, B:133:0x048e, B:134:0x0493, B:131:0x0485, B:135:0x04a2, B:137:0x04a7, B:138:0x04b0, B:140:0x04b6, B:141:0x04c1, B:143:0x04c7, B:145:0x04f8, B:147:0x0504, B:149:0x0509, B:151:0x0532, B:152:0x0539, B:153:0x0545, B:159:0x0582, B:161:0x05ae, B:162:0x05b2, B:157:0x0554, B:158:0x0564, B:39:0x0105, B:17:0x006e, B:19:0x0074, B:21:0x0082), top: B:173:0x0006, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01d7 A[Catch: Exception -> 0x021e, TryCatch #1 {Exception -> 0x021e, blocks: (B:55:0x0180, B:70:0x01cb, B:75:0x01d7, B:77:0x01de, B:65:0x01ad), top: B:169:0x0180 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01de A[Catch: Exception -> 0x021e, TRY_LEAVE, TryCatch #1 {Exception -> 0x021e, blocks: (B:55:0x0180, B:70:0x01cb, B:75:0x01d7, B:77:0x01de, B:65:0x01ad), top: B:169:0x0180 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0261 A[Catch: Exception -> 0x05b8, TryCatch #3 {Exception -> 0x05b8, blocks: (B:3:0x0006, B:7:0x0017, B:8:0x0021, B:10:0x0027, B:12:0x003c, B:13:0x003f, B:14:0x0047, B:16:0x0054, B:25:0x008e, B:27:0x00b0, B:24:0x008b, B:15:0x004e, B:29:0x00c0, B:31:0x00d3, B:32:0x00dd, B:34:0x00e3, B:36:0x00f6, B:37:0x00f9, B:38:0x0100, B:40:0x0109, B:92:0x023c, B:93:0x023f, B:94:0x025b, B:96:0x0261, B:98:0x028b, B:100:0x0297, B:101:0x02de, B:103:0x02e7, B:106:0x02fc, B:109:0x034f, B:111:0x0382, B:113:0x0388, B:115:0x038d, B:117:0x03ab, B:118:0x03ce, B:119:0x03d1, B:107:0x0324, B:120:0x03d8, B:122:0x0444, B:123:0x0459, B:125:0x045f, B:127:0x046a, B:128:0x046f, B:130:0x0477, B:133:0x048e, B:134:0x0493, B:131:0x0485, B:135:0x04a2, B:137:0x04a7, B:138:0x04b0, B:140:0x04b6, B:141:0x04c1, B:143:0x04c7, B:145:0x04f8, B:147:0x0504, B:149:0x0509, B:151:0x0532, B:152:0x0539, B:153:0x0545, B:159:0x0582, B:161:0x05ae, B:162:0x05b2, B:157:0x0554, B:158:0x0564, B:39:0x0105, B:17:0x006e, B:19:0x0074, B:21:0x0082), top: B:173:0x0006, inners: #2 }] */
    /* renamed from: markMessagesAsDeletedInternal, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.ArrayList<java.lang.Long> lambda$markMessagesAsDeleted$133(java.util.ArrayList<java.lang.Long> r24, int r25, boolean r26, boolean r27) {
        /*
            Method dump skipped, instructions count: 1470
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.MessagesStorage.lambda$markMessagesAsDeleted$133(java.util.ArrayList, int, boolean, boolean):java.util.ArrayList");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$markMessagesAsDeletedInternal$131(ArrayList arrayList) {
        getFileLoader().cancelLoadFiles(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* renamed from: updateDialogsWithDeletedMessagesInternal, reason: merged with bridge method [inline-methods] */
    public void lambda$updateDialogsWithDeletedMessages$132(ArrayList<Long> arrayList, ArrayList<Long> arrayList2, int i) {
        TLRPC$TL_dialog tLRPC$TL_dialog;
        SQLitePreparedStatement sQLitePreparedStatementExecuteFast;
        try {
            ArrayList arrayList3 = new ArrayList();
            ?? r9 = 0;
            if (!arrayList.isEmpty()) {
                if (i != 0) {
                    arrayList3.add(Long.valueOf(-i));
                    sQLitePreparedStatementExecuteFast = this.database.executeFast("UPDATE dialogs SET last_mid = (SELECT mid FROM messages WHERE uid = ? AND date = (SELECT MAX(date) FROM messages WHERE uid = ?)) WHERE did = ?");
                } else {
                    SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT did FROM dialogs WHERE last_mid IN(%s)", TextUtils.join(",", arrayList)), new Object[0]);
                    while (sQLiteCursorQueryFinalized.next()) {
                        arrayList3.add(Long.valueOf(sQLiteCursorQueryFinalized.longValue(0)));
                    }
                    sQLiteCursorQueryFinalized.dispose();
                    sQLitePreparedStatementExecuteFast = this.database.executeFast("UPDATE dialogs SET last_mid = (SELECT mid FROM messages WHERE uid = ? AND date = (SELECT MAX(date) FROM messages WHERE uid = ? AND date != 0)) WHERE did = ?");
                }
                this.database.beginTransaction();
                for (int i2 = 0; i2 < arrayList3.size(); i2++) {
                    long jLongValue = ((Long) arrayList3.get(i2)).longValue();
                    sQLitePreparedStatementExecuteFast.requery();
                    sQLitePreparedStatementExecuteFast.bindLong(1, jLongValue);
                    sQLitePreparedStatementExecuteFast.bindLong(2, jLongValue);
                    sQLitePreparedStatementExecuteFast.bindLong(3, jLongValue);
                    sQLitePreparedStatementExecuteFast.step();
                }
                sQLitePreparedStatementExecuteFast.dispose();
                this.database.commitTransaction();
            } else {
                arrayList3.add(Long.valueOf(-i));
            }
            if (arrayList2 != null) {
                for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                    Long l = arrayList2.get(i3);
                    if (!arrayList3.contains(l)) {
                        arrayList3.add(l);
                    }
                }
            }
            String strJoin = TextUtils.join(",", arrayList3);
            TLRPC$TL_messages_dialogs tLRPC$TL_messages_dialogs = new TLRPC$TL_messages_dialogs();
            ArrayList<TLRPC$EncryptedChat> arrayList4 = new ArrayList<>();
            ArrayList<Integer> arrayList5 = new ArrayList<>();
            ArrayList arrayList6 = new ArrayList();
            ArrayList arrayList7 = new ArrayList();
            SQLiteCursor sQLiteCursorQueryFinalized2 = this.database.queryFinalized(String.format(Locale.US, "SELECT d.did, d.last_mid, d.unread_count, d.date, m.data, m.read_state, m.mid, m.send_state, m.date, d.pts, d.inbox_max, d.outbox_max, d.pinned, d.unread_count_i, d.flags, d.folder_id, d.data FROM dialogs as d LEFT JOIN messages as m ON d.last_mid = m.mid WHERE d.did IN(%s)", strJoin), new Object[0]);
            while (sQLiteCursorQueryFinalized2.next()) {
                long jLongValue2 = sQLiteCursorQueryFinalized2.longValue(r9);
                if (DialogObject.isFolderDialogId(jLongValue2)) {
                    TLRPC$TL_dialogFolder tLRPC$TL_dialogFolder = new TLRPC$TL_dialogFolder();
                    tLRPC$TL_dialog = tLRPC$TL_dialogFolder;
                    if (!sQLiteCursorQueryFinalized2.isNull(16)) {
                        NativeByteBuffer nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized2.byteBufferValue(16);
                        if (nativeByteBufferByteBufferValue != 0) {
                            tLRPC$TL_dialogFolder.folder = TLRPC$TL_folder.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(r9), r9);
                            nativeByteBufferByteBufferValue.reuse();
                            tLRPC$TL_dialog = tLRPC$TL_dialogFolder;
                        } else {
                            TLRPC$TL_folder tLRPC$TL_folder = new TLRPC$TL_folder();
                            tLRPC$TL_dialogFolder.folder = tLRPC$TL_folder;
                            tLRPC$TL_folder.id = sQLiteCursorQueryFinalized2.intValue(15);
                            tLRPC$TL_dialog = tLRPC$TL_dialogFolder;
                        }
                    }
                } else {
                    tLRPC$TL_dialog = new TLRPC$TL_dialog();
                }
                tLRPC$TL_dialog.id = jLongValue2;
                tLRPC$TL_dialog.top_message = sQLiteCursorQueryFinalized2.intValue(1);
                tLRPC$TL_dialog.read_inbox_max_id = sQLiteCursorQueryFinalized2.intValue(10);
                tLRPC$TL_dialog.read_outbox_max_id = sQLiteCursorQueryFinalized2.intValue(11);
                tLRPC$TL_dialog.unread_count = sQLiteCursorQueryFinalized2.intValue(2);
                tLRPC$TL_dialog.unread_mentions_count = sQLiteCursorQueryFinalized2.intValue(13);
                tLRPC$TL_dialog.last_message_date = sQLiteCursorQueryFinalized2.intValue(3);
                tLRPC$TL_dialog.pts = sQLiteCursorQueryFinalized2.intValue(9);
                tLRPC$TL_dialog.flags = i == 0 ? 0 : 1;
                int iIntValue = sQLiteCursorQueryFinalized2.intValue(12);
                tLRPC$TL_dialog.pinnedNum = iIntValue;
                tLRPC$TL_dialog.pinned = iIntValue != 0;
                tLRPC$TL_dialog.unread_mark = (sQLiteCursorQueryFinalized2.intValue(14) & 1) != 0;
                tLRPC$TL_dialog.folder_id = sQLiteCursorQueryFinalized2.intValue(15);
                tLRPC$TL_messages_dialogs.dialogs.add(tLRPC$TL_dialog);
                NativeByteBuffer nativeByteBufferByteBufferValue2 = sQLiteCursorQueryFinalized2.byteBufferValue(4);
                if (nativeByteBufferByteBufferValue2 != 0) {
                    TLRPC$Message tLRPC$MessageTLdeserialize = TLRPC$Message.TLdeserialize(nativeByteBufferByteBufferValue2, nativeByteBufferByteBufferValue2.readInt32(r9), r9);
                    tLRPC$MessageTLdeserialize.readAttachPath(nativeByteBufferByteBufferValue2, getUserConfig().clientUserId);
                    nativeByteBufferByteBufferValue2.reuse();
                    MessageObject.setUnreadFlags(tLRPC$MessageTLdeserialize, sQLiteCursorQueryFinalized2.intValue(5));
                    tLRPC$MessageTLdeserialize.id = sQLiteCursorQueryFinalized2.intValue(6);
                    tLRPC$MessageTLdeserialize.send_state = sQLiteCursorQueryFinalized2.intValue(7);
                    int iIntValue2 = sQLiteCursorQueryFinalized2.intValue(8);
                    if (iIntValue2 != 0) {
                        tLRPC$TL_dialog.last_message_date = iIntValue2;
                    }
                    tLRPC$MessageTLdeserialize.dialog_id = tLRPC$TL_dialog.id;
                    tLRPC$TL_messages_dialogs.messages.add(tLRPC$MessageTLdeserialize);
                    addUsersAndChatsFromMessage(tLRPC$MessageTLdeserialize, arrayList5, arrayList6);
                }
                long j = tLRPC$TL_dialog.id;
                int i4 = (int) j;
                int i5 = (int) (j >> 32);
                if (i4 != 0) {
                    if (i4 > 0) {
                        if (!arrayList5.contains(Integer.valueOf(i4))) {
                            arrayList5.add(Integer.valueOf(i4));
                        }
                    } else {
                        int i6 = -i4;
                        if (!arrayList6.contains(Integer.valueOf(i6))) {
                            arrayList6.add(Integer.valueOf(i6));
                        }
                    }
                } else if (!arrayList7.contains(Integer.valueOf(i5))) {
                    arrayList7.add(Integer.valueOf(i5));
                }
                r9 = 0;
            }
            sQLiteCursorQueryFinalized2.dispose();
            if (!arrayList7.isEmpty()) {
                getEncryptedChatsInternal(TextUtils.join(",", arrayList7), arrayList4, arrayList5);
            }
            if (!arrayList6.isEmpty()) {
                getChatsInternal(TextUtils.join(",", arrayList6), tLRPC$TL_messages_dialogs.chats);
            }
            if (!arrayList5.isEmpty()) {
                getUsersInternal(TextUtils.join(",", arrayList5), tLRPC$TL_messages_dialogs.users);
            }
            if (tLRPC$TL_messages_dialogs.dialogs.isEmpty() && arrayList4.isEmpty()) {
                return;
            }
            getMessagesController().processDialogsUpdate(tLRPC$TL_messages_dialogs, arrayList4, true);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void updateDialogsWithDeletedMessages(final ArrayList<Long> arrayList, final ArrayList<Long> arrayList2, boolean z, final int i) {
        if (arrayList.isEmpty() && i == 0) {
            return;
        }
        if (z) {
            this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda109
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$updateDialogsWithDeletedMessages$132(arrayList, arrayList2, i);
                }
            });
        } else {
            lambda$updateDialogsWithDeletedMessages$132(arrayList, arrayList2, i);
        }
    }

    public ArrayList<Long> markMessagesAsDeleted(final ArrayList<Long> arrayList, boolean z, final int i, final boolean z2, final boolean z3) {
        if (arrayList.isEmpty()) {
            return null;
        }
        if (z) {
            this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda107
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$markMessagesAsDeleted$133(arrayList, i, z2, z3);
                }
            });
            return null;
        }
        return lambda$markMessagesAsDeleted$133(arrayList, i, z2, z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x012e A[Catch: Exception -> 0x02b4, TryCatch #4 {Exception -> 0x02b4, blocks: (B:41:0x0114, B:42:0x0128, B:44:0x012e, B:46:0x0158, B:48:0x0163, B:49:0x01a3, B:51:0x01fb, B:53:0x0201, B:55:0x0206, B:57:0x0223, B:59:0x024a, B:61:0x0250), top: B:79:0x0114 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01fb A[Catch: Exception -> 0x02b4, TryCatch #4 {Exception -> 0x02b4, blocks: (B:41:0x0114, B:42:0x0128, B:44:0x012e, B:46:0x0158, B:48:0x0163, B:49:0x01a3, B:51:0x01fb, B:53:0x0201, B:55:0x0206, B:57:0x0223, B:59:0x024a, B:61:0x0250), top: B:79:0x0114 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0206 A[Catch: Exception -> 0x02b4, TryCatch #4 {Exception -> 0x02b4, blocks: (B:41:0x0114, B:42:0x0128, B:44:0x012e, B:46:0x0158, B:48:0x0163, B:49:0x01a3, B:51:0x01fb, B:53:0x0201, B:55:0x0206, B:57:0x0223, B:59:0x024a, B:61:0x0250), top: B:79:0x0114 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x024e  */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* renamed from: markMessagesAsDeletedInternal, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.ArrayList<java.lang.Long> lambda$markMessagesAsDeleted$135(int r20, long r21, boolean r23) {
        /*
            Method dump skipped, instructions count: 705
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.MessagesStorage.lambda$markMessagesAsDeleted$135(int, long, boolean):java.util.ArrayList");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$markMessagesAsDeletedInternal$134(ArrayList arrayList) {
        getFileLoader().cancelLoadFiles(arrayList);
    }

    public ArrayList<Long> markMessagesAsDeleted(final int i, final long j, boolean z, final boolean z2) {
        if (z) {
            this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda39
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$markMessagesAsDeleted$135(i, j, z2);
                }
            });
            return null;
        }
        return lambda$markMessagesAsDeleted$135(i, j, z2);
    }

    private void fixUnsupportedMedia(TLRPC$Message tLRPC$Message) {
        if (tLRPC$Message == null) {
            return;
        }
        TLRPC$MessageMedia tLRPC$MessageMedia = tLRPC$Message.media;
        if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaUnsupported_old) {
            if (tLRPC$MessageMedia.bytes.length == 0) {
                tLRPC$MessageMedia.bytes = new byte[]{127};
            }
        } else if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaUnsupported) {
            TLRPC$TL_messageMediaUnsupported_old tLRPC$TL_messageMediaUnsupported_old = new TLRPC$TL_messageMediaUnsupported_old();
            tLRPC$Message.media = tLRPC$TL_messageMediaUnsupported_old;
            tLRPC$TL_messageMediaUnsupported_old.bytes = new byte[]{127};
            tLRPC$Message.flags |= 512;
        }
    }

    private void doneHolesInTable(String str, long j, long j2) throws Exception {
        if (j2 == 0) {
            this.database.executeFast(String.format(Locale.US, "DELETE FROM " + str + " WHERE uid = %d", Long.valueOf(j))).stepThis().dispose();
        } else {
            this.database.executeFast(String.format(Locale.US, "DELETE FROM " + str + " WHERE uid = %d AND start = 0", Long.valueOf(j))).stepThis().dispose();
        }
        SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("REPLACE INTO " + str + " VALUES(?, ?, ?)");
        sQLitePreparedStatementExecuteFast.requery();
        sQLitePreparedStatementExecuteFast.bindLong(1, j);
        sQLitePreparedStatementExecuteFast.bindInteger(2, 1);
        sQLitePreparedStatementExecuteFast.bindInteger(3, 1);
        sQLitePreparedStatementExecuteFast.step();
        sQLitePreparedStatementExecuteFast.dispose();
    }

    public void doneHolesInMedia(long j, long j2, int i) throws Exception {
        if (i == -1) {
            if (j2 == 0) {
                this.database.executeFast(String.format(Locale.US, "DELETE FROM media_holes_v2 WHERE uid = %d", Long.valueOf(j))).stepThis().dispose();
            } else {
                this.database.executeFast(String.format(Locale.US, "DELETE FROM media_holes_v2 WHERE uid = %d AND start = 0", Long.valueOf(j))).stepThis().dispose();
            }
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("REPLACE INTO media_holes_v2 VALUES(?, ?, ?, ?)");
            for (int i2 = 0; i2 < 6; i2++) {
                sQLitePreparedStatementExecuteFast.requery();
                sQLitePreparedStatementExecuteFast.bindLong(1, j);
                sQLitePreparedStatementExecuteFast.bindInteger(2, i2);
                sQLitePreparedStatementExecuteFast.bindInteger(3, 1);
                sQLitePreparedStatementExecuteFast.bindInteger(4, 1);
                sQLitePreparedStatementExecuteFast.step();
            }
            sQLitePreparedStatementExecuteFast.dispose();
            return;
        }
        if (j2 == 0) {
            this.database.executeFast(String.format(Locale.US, "DELETE FROM media_holes_v2 WHERE uid = %d AND type = %d", Long.valueOf(j), Integer.valueOf(i))).stepThis().dispose();
        } else {
            this.database.executeFast(String.format(Locale.US, "DELETE FROM media_holes_v2 WHERE uid = %d AND type = %d AND start = 0", Long.valueOf(j), Integer.valueOf(i))).stepThis().dispose();
        }
        SQLitePreparedStatement sQLitePreparedStatementExecuteFast2 = this.database.executeFast("REPLACE INTO media_holes_v2 VALUES(?, ?, ?, ?)");
        sQLitePreparedStatementExecuteFast2.requery();
        sQLitePreparedStatementExecuteFast2.bindLong(1, j);
        sQLitePreparedStatementExecuteFast2.bindInteger(2, i);
        sQLitePreparedStatementExecuteFast2.bindInteger(3, 1);
        sQLitePreparedStatementExecuteFast2.bindInteger(4, 1);
        sQLitePreparedStatementExecuteFast2.step();
        sQLitePreparedStatementExecuteFast2.dispose();
    }

    private static class Hole {
        public int end;
        public int start;
        public int type;

        public Hole(int i, int i2) {
            this.start = i;
            this.end = i2;
        }

        public Hole(int i, int i2, int i3) {
            this.type = i;
            this.start = i2;
            this.end = i3;
        }
    }

    public void closeHolesInMedia(long j, long j2, long j3, int i) {
        SQLiteCursor sQLiteCursorQueryFinalized;
        int i2 = 4;
        int i3 = 2;
        try {
            if (i < 0) {
                sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT type, start, end FROM media_holes_v2 WHERE uid = %d AND type >= 0 AND ((end >= %d AND end <= %d) OR (start >= %d AND start <= %d) OR (start >= %d AND end <= %d) OR (start <= %d AND end >= %d))", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j2), Long.valueOf(j3)), new Object[0]);
            } else {
                sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT type, start, end FROM media_holes_v2 WHERE uid = %d AND type = %d AND ((end >= %d AND end <= %d) OR (start >= %d AND start <= %d) OR (start >= %d AND end <= %d) OR (start <= %d AND end >= %d))", Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j2), Long.valueOf(j3)), new Object[0]);
            }
            ArrayList arrayList = null;
            while (sQLiteCursorQueryFinalized.next()) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                int iIntValue = sQLiteCursorQueryFinalized.intValue(0);
                int iIntValue2 = sQLiteCursorQueryFinalized.intValue(1);
                int iIntValue3 = sQLiteCursorQueryFinalized.intValue(i3);
                if (iIntValue2 != iIntValue3 || iIntValue2 != 1) {
                    arrayList.add(new Hole(iIntValue, iIntValue2, iIntValue3));
                }
                i3 = 2;
            }
            sQLiteCursorQueryFinalized.dispose();
            if (arrayList != null) {
                int i4 = 0;
                while (i4 < arrayList.size()) {
                    Hole hole = (Hole) arrayList.get(i4);
                    int i5 = hole.end;
                    if (j3 >= i5 - 1 && j2 <= hole.start + 1) {
                        SQLiteDatabase sQLiteDatabase = this.database;
                        Locale locale = Locale.US;
                        Object[] objArr = new Object[i2];
                        objArr[0] = Long.valueOf(j);
                        objArr[1] = Integer.valueOf(hole.type);
                        objArr[2] = Integer.valueOf(hole.start);
                        objArr[3] = Integer.valueOf(hole.end);
                        sQLiteDatabase.executeFast(String.format(locale, "DELETE FROM media_holes_v2 WHERE uid = %d AND type = %d AND start = %d AND end = %d", objArr)).stepThis().dispose();
                    } else if (j3 < i5 - 1) {
                        int i6 = hole.start;
                        if (j2 > i6 + 1) {
                            this.database.executeFast(String.format(Locale.US, "DELETE FROM media_holes_v2 WHERE uid = %d AND type = %d AND start = %d AND end = %d", Long.valueOf(j), Integer.valueOf(hole.type), Integer.valueOf(hole.start), Integer.valueOf(hole.end))).stepThis().dispose();
                            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("REPLACE INTO media_holes_v2 VALUES(?, ?, ?, ?)");
                            sQLitePreparedStatementExecuteFast.requery();
                            sQLitePreparedStatementExecuteFast.bindLong(1, j);
                            sQLitePreparedStatementExecuteFast.bindInteger(2, hole.type);
                            sQLitePreparedStatementExecuteFast.bindInteger(3, hole.start);
                            sQLitePreparedStatementExecuteFast.bindLong(4, j2);
                            sQLitePreparedStatementExecuteFast.step();
                            sQLitePreparedStatementExecuteFast.requery();
                            sQLitePreparedStatementExecuteFast.bindLong(1, j);
                            sQLitePreparedStatementExecuteFast.bindInteger(2, hole.type);
                            sQLitePreparedStatementExecuteFast.bindLong(3, j3);
                            sQLitePreparedStatementExecuteFast.bindInteger(4, hole.end);
                            sQLitePreparedStatementExecuteFast.step();
                            sQLitePreparedStatementExecuteFast.dispose();
                            i4++;
                            i2 = 4;
                        } else if (i6 != j3) {
                            try {
                                this.database.executeFast(String.format(Locale.US, "UPDATE media_holes_v2 SET start = %d WHERE uid = %d AND type = %d AND start = %d AND end = %d", Long.valueOf(j3), Long.valueOf(j), Integer.valueOf(hole.type), Integer.valueOf(hole.start), Integer.valueOf(hole.end))).stepThis().dispose();
                            } catch (Exception e) {
                                FileLog.e(e);
                            }
                        }
                    } else if (i5 != j2) {
                        try {
                            this.database.executeFast(String.format(Locale.US, "UPDATE media_holes_v2 SET end = %d WHERE uid = %d AND type = %d AND start = %d AND end = %d", Long.valueOf(j2), Long.valueOf(j), Integer.valueOf(hole.type), Integer.valueOf(hole.start), Integer.valueOf(hole.end))).stepThis().dispose();
                        } catch (Exception e2) {
                            FileLog.e(e2);
                        }
                    }
                    i4++;
                    i2 = 4;
                }
            }
        } catch (Exception e3) {
            FileLog.e(e3);
        }
    }

    private void closeHolesInTable(String str, long j, long j2, long j3) {
        ArrayList arrayList;
        try {
            SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT start, end FROM " + str + " WHERE uid = %d AND ((end >= %d AND end <= %d) OR (start >= %d AND start <= %d) OR (start >= %d AND end <= %d) OR (start <= %d AND end >= %d))", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j2), Long.valueOf(j3)), new Object[0]);
            ArrayList arrayList2 = null;
            while (sQLiteCursorQueryFinalized.next()) {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                int iIntValue = sQLiteCursorQueryFinalized.intValue(0);
                int iIntValue2 = sQLiteCursorQueryFinalized.intValue(1);
                if (iIntValue != iIntValue2 || iIntValue != 1) {
                    arrayList2.add(new Hole(iIntValue, iIntValue2));
                }
            }
            sQLiteCursorQueryFinalized.dispose();
            if (arrayList2 != null) {
                int i = 0;
                while (i < arrayList2.size()) {
                    Hole hole = (Hole) arrayList2.get(i);
                    int i2 = hole.end;
                    if (j3 < i2 - 1 || j2 > hole.start + 1) {
                        arrayList = arrayList2;
                        if (j3 < i2 - 1) {
                            int i3 = hole.start;
                            if (j2 <= i3 + 1) {
                                if (i3 != j3) {
                                    try {
                                    } catch (Exception e) {
                                        e = e;
                                    }
                                    try {
                                        this.database.executeFast(String.format(Locale.US, "UPDATE " + str + " SET start = %d WHERE uid = %d AND start = %d AND end = %d", Long.valueOf(j3), Long.valueOf(j), Integer.valueOf(hole.start), Integer.valueOf(hole.end))).stepThis().dispose();
                                    } catch (Exception e2) {
                                        e = e2;
                                        FileLog.e(e);
                                        i++;
                                        arrayList2 = arrayList;
                                    }
                                }
                                i++;
                                arrayList2 = arrayList;
                            } else {
                                this.database.executeFast(String.format(Locale.US, "DELETE FROM " + str + " WHERE uid = %d AND start = %d AND end = %d", Long.valueOf(j), Integer.valueOf(hole.start), Integer.valueOf(hole.end))).stepThis().dispose();
                                SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("REPLACE INTO " + str + " VALUES(?, ?, ?)");
                                sQLitePreparedStatementExecuteFast.requery();
                                sQLitePreparedStatementExecuteFast.bindLong(1, j);
                                sQLitePreparedStatementExecuteFast.bindInteger(2, hole.start);
                                sQLitePreparedStatementExecuteFast.bindLong(3, j2);
                                sQLitePreparedStatementExecuteFast.step();
                                sQLitePreparedStatementExecuteFast.requery();
                                sQLitePreparedStatementExecuteFast.bindLong(1, j);
                                sQLitePreparedStatementExecuteFast.bindLong(2, j3);
                                sQLitePreparedStatementExecuteFast.bindInteger(3, hole.end);
                                sQLitePreparedStatementExecuteFast.step();
                                sQLitePreparedStatementExecuteFast.dispose();
                                i++;
                                arrayList2 = arrayList;
                            }
                        } else if (i2 != j2) {
                            try {
                                this.database.executeFast(String.format(Locale.US, "UPDATE " + str + " SET end = %d WHERE uid = %d AND start = %d AND end = %d", Long.valueOf(j2), Long.valueOf(j), Integer.valueOf(hole.start), Integer.valueOf(hole.end))).stepThis().dispose();
                            } catch (Exception e3) {
                                FileLog.e(e3);
                            }
                        }
                    } else {
                        this.database.executeFast(String.format(Locale.US, "DELETE FROM " + str + " WHERE uid = %d AND start = %d AND end = %d", Long.valueOf(j), Integer.valueOf(hole.start), Integer.valueOf(hole.end))).stepThis().dispose();
                        arrayList = arrayList2;
                    }
                    i++;
                    arrayList2 = arrayList;
                }
            }
        } catch (Exception e4) {
            FileLog.e(e4);
        }
    }

    public void replaceMessageIfExists(final TLRPC$Message tLRPC$Message, final ArrayList<TLRPC$User> arrayList, final ArrayList<TLRPC$Chat> arrayList2, final boolean z) {
        if (tLRPC$Message == null) {
            return;
        }
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda133
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f$0.lambda$replaceMessageIfExists$137(tLRPC$Message, z, arrayList, arrayList2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0064 A[Catch: Exception -> 0x01cb, TryCatch #2 {Exception -> 0x01cb, blocks: (B:3:0x0004, B:10:0x0031, B:12:0x0035, B:23:0x0047, B:25:0x0064, B:26:0x0067, B:28:0x00a1, B:33:0x00a9, B:35:0x00bb, B:37:0x00c8, B:43:0x00d3, B:47:0x00e1, B:49:0x00f1, B:51:0x0109, B:53:0x010f, B:57:0x011a, B:59:0x0123, B:61:0x012c, B:64:0x0153, B:65:0x0156, B:67:0x0166, B:68:0x0171, B:70:0x0177, B:71:0x018b, B:73:0x0191, B:74:0x01a5, B:56:0x0118, B:58:0x011e, B:50:0x0105, B:36:0x00c1, B:78:0x01c7, B:79:0x01ca), top: B:85:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00bb A[Catch: Exception -> 0x01cb, TryCatch #2 {Exception -> 0x01cb, blocks: (B:3:0x0004, B:10:0x0031, B:12:0x0035, B:23:0x0047, B:25:0x0064, B:26:0x0067, B:28:0x00a1, B:33:0x00a9, B:35:0x00bb, B:37:0x00c8, B:43:0x00d3, B:47:0x00e1, B:49:0x00f1, B:51:0x0109, B:53:0x010f, B:57:0x011a, B:59:0x0123, B:61:0x012c, B:64:0x0153, B:65:0x0156, B:67:0x0166, B:68:0x0171, B:70:0x0177, B:71:0x018b, B:73:0x0191, B:74:0x01a5, B:56:0x0118, B:58:0x011e, B:50:0x0105, B:36:0x00c1, B:78:0x01c7, B:79:0x01ca), top: B:85:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c1 A[Catch: Exception -> 0x01cb, TryCatch #2 {Exception -> 0x01cb, blocks: (B:3:0x0004, B:10:0x0031, B:12:0x0035, B:23:0x0047, B:25:0x0064, B:26:0x0067, B:28:0x00a1, B:33:0x00a9, B:35:0x00bb, B:37:0x00c8, B:43:0x00d3, B:47:0x00e1, B:49:0x00f1, B:51:0x0109, B:53:0x010f, B:57:0x011a, B:59:0x0123, B:61:0x012c, B:64:0x0153, B:65:0x0156, B:67:0x0166, B:68:0x0171, B:70:0x0177, B:71:0x018b, B:73:0x0191, B:74:0x01a5, B:56:0x0118, B:58:0x011e, B:50:0x0105, B:36:0x00c1, B:78:0x01c7, B:79:0x01ca), top: B:85:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f1 A[Catch: Exception -> 0x01cb, TryCatch #2 {Exception -> 0x01cb, blocks: (B:3:0x0004, B:10:0x0031, B:12:0x0035, B:23:0x0047, B:25:0x0064, B:26:0x0067, B:28:0x00a1, B:33:0x00a9, B:35:0x00bb, B:37:0x00c8, B:43:0x00d3, B:47:0x00e1, B:49:0x00f1, B:51:0x0109, B:53:0x010f, B:57:0x011a, B:59:0x0123, B:61:0x012c, B:64:0x0153, B:65:0x0156, B:67:0x0166, B:68:0x0171, B:70:0x0177, B:71:0x018b, B:73:0x0191, B:74:0x01a5, B:56:0x0118, B:58:0x011e, B:50:0x0105, B:36:0x00c1, B:78:0x01c7, B:79:0x01ca), top: B:85:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0105 A[Catch: Exception -> 0x01cb, TryCatch #2 {Exception -> 0x01cb, blocks: (B:3:0x0004, B:10:0x0031, B:12:0x0035, B:23:0x0047, B:25:0x0064, B:26:0x0067, B:28:0x00a1, B:33:0x00a9, B:35:0x00bb, B:37:0x00c8, B:43:0x00d3, B:47:0x00e1, B:49:0x00f1, B:51:0x0109, B:53:0x010f, B:57:0x011a, B:59:0x0123, B:61:0x012c, B:64:0x0153, B:65:0x0156, B:67:0x0166, B:68:0x0171, B:70:0x0177, B:71:0x018b, B:73:0x0191, B:74:0x01a5, B:56:0x0118, B:58:0x011e, B:50:0x0105, B:36:0x00c1, B:78:0x01c7, B:79:0x01ca), top: B:85:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x010f A[Catch: Exception -> 0x01cb, TryCatch #2 {Exception -> 0x01cb, blocks: (B:3:0x0004, B:10:0x0031, B:12:0x0035, B:23:0x0047, B:25:0x0064, B:26:0x0067, B:28:0x00a1, B:33:0x00a9, B:35:0x00bb, B:37:0x00c8, B:43:0x00d3, B:47:0x00e1, B:49:0x00f1, B:51:0x0109, B:53:0x010f, B:57:0x011a, B:59:0x0123, B:61:0x012c, B:64:0x0153, B:65:0x0156, B:67:0x0166, B:68:0x0171, B:70:0x0177, B:71:0x018b, B:73:0x0191, B:74:0x01a5, B:56:0x0118, B:58:0x011e, B:50:0x0105, B:36:0x00c1, B:78:0x01c7, B:79:0x01ca), top: B:85:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x011e A[Catch: Exception -> 0x01cb, TryCatch #2 {Exception -> 0x01cb, blocks: (B:3:0x0004, B:10:0x0031, B:12:0x0035, B:23:0x0047, B:25:0x0064, B:26:0x0067, B:28:0x00a1, B:33:0x00a9, B:35:0x00bb, B:37:0x00c8, B:43:0x00d3, B:47:0x00e1, B:49:0x00f1, B:51:0x0109, B:53:0x010f, B:57:0x011a, B:59:0x0123, B:61:0x012c, B:64:0x0153, B:65:0x0156, B:67:0x0166, B:68:0x0171, B:70:0x0177, B:71:0x018b, B:73:0x0191, B:74:0x01a5, B:56:0x0118, B:58:0x011e, B:50:0x0105, B:36:0x00c1, B:78:0x01c7, B:79:0x01ca), top: B:85:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x012c A[Catch: Exception -> 0x01cb, TryCatch #2 {Exception -> 0x01cb, blocks: (B:3:0x0004, B:10:0x0031, B:12:0x0035, B:23:0x0047, B:25:0x0064, B:26:0x0067, B:28:0x00a1, B:33:0x00a9, B:35:0x00bb, B:37:0x00c8, B:43:0x00d3, B:47:0x00e1, B:49:0x00f1, B:51:0x0109, B:53:0x010f, B:57:0x011a, B:59:0x0123, B:61:0x012c, B:64:0x0153, B:65:0x0156, B:67:0x0166, B:68:0x0171, B:70:0x0177, B:71:0x018b, B:73:0x0191, B:74:0x01a5, B:56:0x0118, B:58:0x011e, B:50:0x0105, B:36:0x00c1, B:78:0x01c7, B:79:0x01ca), top: B:85:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0153 A[Catch: Exception -> 0x01cb, TryCatch #2 {Exception -> 0x01cb, blocks: (B:3:0x0004, B:10:0x0031, B:12:0x0035, B:23:0x0047, B:25:0x0064, B:26:0x0067, B:28:0x00a1, B:33:0x00a9, B:35:0x00bb, B:37:0x00c8, B:43:0x00d3, B:47:0x00e1, B:49:0x00f1, B:51:0x0109, B:53:0x010f, B:57:0x011a, B:59:0x0123, B:61:0x012c, B:64:0x0153, B:65:0x0156, B:67:0x0166, B:68:0x0171, B:70:0x0177, B:71:0x018b, B:73:0x0191, B:74:0x01a5, B:56:0x0118, B:58:0x011e, B:50:0x0105, B:36:0x00c1, B:78:0x01c7, B:79:0x01ca), top: B:85:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0166 A[Catch: Exception -> 0x01cb, TryCatch #2 {Exception -> 0x01cb, blocks: (B:3:0x0004, B:10:0x0031, B:12:0x0035, B:23:0x0047, B:25:0x0064, B:26:0x0067, B:28:0x00a1, B:33:0x00a9, B:35:0x00bb, B:37:0x00c8, B:43:0x00d3, B:47:0x00e1, B:49:0x00f1, B:51:0x0109, B:53:0x010f, B:57:0x011a, B:59:0x0123, B:61:0x012c, B:64:0x0153, B:65:0x0156, B:67:0x0166, B:68:0x0171, B:70:0x0177, B:71:0x018b, B:73:0x0191, B:74:0x01a5, B:56:0x0118, B:58:0x011e, B:50:0x0105, B:36:0x00c1, B:78:0x01c7, B:79:0x01ca), top: B:85:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01c7 A[Catch: Exception -> 0x01cb, TryCatch #2 {Exception -> 0x01cb, blocks: (B:3:0x0004, B:10:0x0031, B:12:0x0035, B:23:0x0047, B:25:0x0064, B:26:0x0067, B:28:0x00a1, B:33:0x00a9, B:35:0x00bb, B:37:0x00c8, B:43:0x00d3, B:47:0x00e1, B:49:0x00f1, B:51:0x0109, B:53:0x010f, B:57:0x011a, B:59:0x0123, B:61:0x012c, B:64:0x0153, B:65:0x0156, B:67:0x0166, B:68:0x0171, B:70:0x0177, B:71:0x018b, B:73:0x0191, B:74:0x01a5, B:56:0x0118, B:58:0x011e, B:50:0x0105, B:36:0x00c1, B:78:0x01c7, B:79:0x01ca), top: B:85:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$replaceMessageIfExists$137(org.rbmain.tgnet.TLRPC$Message r20, boolean r21, java.util.ArrayList r22, java.util.ArrayList r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 464
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.MessagesStorage.lambda$replaceMessageIfExists$137(org.rbmain.tgnet.TLRPC$Message, boolean, java.util.ArrayList, java.util.ArrayList):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$replaceMessageIfExists$136(MessageObject messageObject, ArrayList arrayList) {
        getNotificationCenter().postNotificationName(NotificationCenter.replaceMessagesObjects, Long.valueOf(messageObject.getDialogId()), arrayList);
    }

    public void putMessages(final TLRPC$messages_Messages tLRPC$messages_Messages, final long j, final int i, final long j2, final boolean z, final boolean z2) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda145
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$putMessages$139(z2, j, tLRPC$messages_Messages, i, j2, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0319  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x055c A[Catch: Exception -> 0x06dd, TryCatch #1 {Exception -> 0x06dd, blocks: (B:4:0x000e, B:6:0x003c, B:16:0x0092, B:9:0x004c, B:11:0x0050, B:12:0x0054, B:14:0x005a, B:15:0x005d, B:17:0x0095, B:18:0x00b0, B:21:0x00bd, B:23:0x00d3, B:25:0x00dc, B:43:0x0182, B:45:0x01b8, B:47:0x01c6, B:48:0x01ca, B:50:0x01d1, B:54:0x01de, B:56:0x0204, B:58:0x020b, B:60:0x0228, B:62:0x0235, B:64:0x023b, B:66:0x0241, B:68:0x0245, B:70:0x0249, B:86:0x0271, B:88:0x029a, B:92:0x02a5, B:96:0x02b4, B:98:0x02d9, B:100:0x02e2, B:105:0x02f2, B:112:0x0314, B:215:0x0620, B:119:0x0336, B:121:0x0356, B:123:0x036e, B:125:0x0373, B:127:0x03fe, B:129:0x0407, B:131:0x0441, B:136:0x0449, B:138:0x0459, B:140:0x046a, B:147:0x047c, B:151:0x0486, B:153:0x0496, B:155:0x04b3, B:157:0x04b7, B:161:0x04c4, B:163:0x04d3, B:165:0x04dc, B:181:0x055c, B:182:0x055f, B:184:0x0566, B:187:0x0570, B:189:0x057b, B:193:0x05b2, B:196:0x05ba, B:198:0x05c5, B:206:0x0607, B:210:0x0611, B:199:0x05de, B:202:0x05e4, B:204:0x05ef, B:166:0x04ff, B:168:0x0507, B:178:0x0554, B:160:0x04c2, B:162:0x04ca, B:154:0x04ad, B:139:0x0461, B:126:0x03a1, B:106:0x02f5, B:108:0x02f9, B:73:0x0253, B:75:0x0257, B:77:0x025d, B:79:0x0261, B:81:0x0265, B:216:0x0634, B:218:0x0648, B:220:0x064d, B:222:0x065a, B:224:0x065f, B:225:0x0666, B:227:0x0690, B:228:0x06cb, B:230:0x06d2, B:28:0x010f, B:42:0x0158, B:41:0x014d), top: B:237:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0566 A[Catch: Exception -> 0x06dd, TryCatch #1 {Exception -> 0x06dd, blocks: (B:4:0x000e, B:6:0x003c, B:16:0x0092, B:9:0x004c, B:11:0x0050, B:12:0x0054, B:14:0x005a, B:15:0x005d, B:17:0x0095, B:18:0x00b0, B:21:0x00bd, B:23:0x00d3, B:25:0x00dc, B:43:0x0182, B:45:0x01b8, B:47:0x01c6, B:48:0x01ca, B:50:0x01d1, B:54:0x01de, B:56:0x0204, B:58:0x020b, B:60:0x0228, B:62:0x0235, B:64:0x023b, B:66:0x0241, B:68:0x0245, B:70:0x0249, B:86:0x0271, B:88:0x029a, B:92:0x02a5, B:96:0x02b4, B:98:0x02d9, B:100:0x02e2, B:105:0x02f2, B:112:0x0314, B:215:0x0620, B:119:0x0336, B:121:0x0356, B:123:0x036e, B:125:0x0373, B:127:0x03fe, B:129:0x0407, B:131:0x0441, B:136:0x0449, B:138:0x0459, B:140:0x046a, B:147:0x047c, B:151:0x0486, B:153:0x0496, B:155:0x04b3, B:157:0x04b7, B:161:0x04c4, B:163:0x04d3, B:165:0x04dc, B:181:0x055c, B:182:0x055f, B:184:0x0566, B:187:0x0570, B:189:0x057b, B:193:0x05b2, B:196:0x05ba, B:198:0x05c5, B:206:0x0607, B:210:0x0611, B:199:0x05de, B:202:0x05e4, B:204:0x05ef, B:166:0x04ff, B:168:0x0507, B:178:0x0554, B:160:0x04c2, B:162:0x04ca, B:154:0x04ad, B:139:0x0461, B:126:0x03a1, B:106:0x02f5, B:108:0x02f9, B:73:0x0253, B:75:0x0257, B:77:0x025d, B:79:0x0261, B:81:0x0265, B:216:0x0634, B:218:0x0648, B:220:0x064d, B:222:0x065a, B:224:0x065f, B:225:0x0666, B:227:0x0690, B:228:0x06cb, B:230:0x06d2, B:28:0x010f, B:42:0x0158, B:41:0x014d), top: B:237:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:191:0x05a9 A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Removed duplicated region for block: B:195:0x05b8  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x05de A[Catch: Exception -> 0x06dd, TryCatch #1 {Exception -> 0x06dd, blocks: (B:4:0x000e, B:6:0x003c, B:16:0x0092, B:9:0x004c, B:11:0x0050, B:12:0x0054, B:14:0x005a, B:15:0x005d, B:17:0x0095, B:18:0x00b0, B:21:0x00bd, B:23:0x00d3, B:25:0x00dc, B:43:0x0182, B:45:0x01b8, B:47:0x01c6, B:48:0x01ca, B:50:0x01d1, B:54:0x01de, B:56:0x0204, B:58:0x020b, B:60:0x0228, B:62:0x0235, B:64:0x023b, B:66:0x0241, B:68:0x0245, B:70:0x0249, B:86:0x0271, B:88:0x029a, B:92:0x02a5, B:96:0x02b4, B:98:0x02d9, B:100:0x02e2, B:105:0x02f2, B:112:0x0314, B:215:0x0620, B:119:0x0336, B:121:0x0356, B:123:0x036e, B:125:0x0373, B:127:0x03fe, B:129:0x0407, B:131:0x0441, B:136:0x0449, B:138:0x0459, B:140:0x046a, B:147:0x047c, B:151:0x0486, B:153:0x0496, B:155:0x04b3, B:157:0x04b7, B:161:0x04c4, B:163:0x04d3, B:165:0x04dc, B:181:0x055c, B:182:0x055f, B:184:0x0566, B:187:0x0570, B:189:0x057b, B:193:0x05b2, B:196:0x05ba, B:198:0x05c5, B:206:0x0607, B:210:0x0611, B:199:0x05de, B:202:0x05e4, B:204:0x05ef, B:166:0x04ff, B:168:0x0507, B:178:0x0554, B:160:0x04c2, B:162:0x04ca, B:154:0x04ad, B:139:0x0461, B:126:0x03a1, B:106:0x02f5, B:108:0x02f9, B:73:0x0253, B:75:0x0257, B:77:0x025d, B:79:0x0261, B:81:0x0265, B:216:0x0634, B:218:0x0648, B:220:0x064d, B:222:0x065a, B:224:0x065f, B:225:0x0666, B:227:0x0690, B:228:0x06cb, B:230:0x06d2, B:28:0x010f, B:42:0x0158, B:41:0x014d), top: B:237:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0607 A[Catch: Exception -> 0x06dd, TryCatch #1 {Exception -> 0x06dd, blocks: (B:4:0x000e, B:6:0x003c, B:16:0x0092, B:9:0x004c, B:11:0x0050, B:12:0x0054, B:14:0x005a, B:15:0x005d, B:17:0x0095, B:18:0x00b0, B:21:0x00bd, B:23:0x00d3, B:25:0x00dc, B:43:0x0182, B:45:0x01b8, B:47:0x01c6, B:48:0x01ca, B:50:0x01d1, B:54:0x01de, B:56:0x0204, B:58:0x020b, B:60:0x0228, B:62:0x0235, B:64:0x023b, B:66:0x0241, B:68:0x0245, B:70:0x0249, B:86:0x0271, B:88:0x029a, B:92:0x02a5, B:96:0x02b4, B:98:0x02d9, B:100:0x02e2, B:105:0x02f2, B:112:0x0314, B:215:0x0620, B:119:0x0336, B:121:0x0356, B:123:0x036e, B:125:0x0373, B:127:0x03fe, B:129:0x0407, B:131:0x0441, B:136:0x0449, B:138:0x0459, B:140:0x046a, B:147:0x047c, B:151:0x0486, B:153:0x0496, B:155:0x04b3, B:157:0x04b7, B:161:0x04c4, B:163:0x04d3, B:165:0x04dc, B:181:0x055c, B:182:0x055f, B:184:0x0566, B:187:0x0570, B:189:0x057b, B:193:0x05b2, B:196:0x05ba, B:198:0x05c5, B:206:0x0607, B:210:0x0611, B:199:0x05de, B:202:0x05e4, B:204:0x05ef, B:166:0x04ff, B:168:0x0507, B:178:0x0554, B:160:0x04c2, B:162:0x04ca, B:154:0x04ad, B:139:0x0461, B:126:0x03a1, B:106:0x02f5, B:108:0x02f9, B:73:0x0253, B:75:0x0257, B:77:0x025d, B:79:0x0261, B:81:0x0265, B:216:0x0634, B:218:0x0648, B:220:0x064d, B:222:0x065a, B:224:0x065f, B:225:0x0666, B:227:0x0690, B:228:0x06cb, B:230:0x06d2, B:28:0x010f, B:42:0x0158, B:41:0x014d), top: B:237:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:213:0x061c  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0253 A[Catch: Exception -> 0x06dd, TryCatch #1 {Exception -> 0x06dd, blocks: (B:4:0x000e, B:6:0x003c, B:16:0x0092, B:9:0x004c, B:11:0x0050, B:12:0x0054, B:14:0x005a, B:15:0x005d, B:17:0x0095, B:18:0x00b0, B:21:0x00bd, B:23:0x00d3, B:25:0x00dc, B:43:0x0182, B:45:0x01b8, B:47:0x01c6, B:48:0x01ca, B:50:0x01d1, B:54:0x01de, B:56:0x0204, B:58:0x020b, B:60:0x0228, B:62:0x0235, B:64:0x023b, B:66:0x0241, B:68:0x0245, B:70:0x0249, B:86:0x0271, B:88:0x029a, B:92:0x02a5, B:96:0x02b4, B:98:0x02d9, B:100:0x02e2, B:105:0x02f2, B:112:0x0314, B:215:0x0620, B:119:0x0336, B:121:0x0356, B:123:0x036e, B:125:0x0373, B:127:0x03fe, B:129:0x0407, B:131:0x0441, B:136:0x0449, B:138:0x0459, B:140:0x046a, B:147:0x047c, B:151:0x0486, B:153:0x0496, B:155:0x04b3, B:157:0x04b7, B:161:0x04c4, B:163:0x04d3, B:165:0x04dc, B:181:0x055c, B:182:0x055f, B:184:0x0566, B:187:0x0570, B:189:0x057b, B:193:0x05b2, B:196:0x05ba, B:198:0x05c5, B:206:0x0607, B:210:0x0611, B:199:0x05de, B:202:0x05e4, B:204:0x05ef, B:166:0x04ff, B:168:0x0507, B:178:0x0554, B:160:0x04c2, B:162:0x04ca, B:154:0x04ad, B:139:0x0461, B:126:0x03a1, B:106:0x02f5, B:108:0x02f9, B:73:0x0253, B:75:0x0257, B:77:0x025d, B:79:0x0261, B:81:0x0265, B:216:0x0634, B:218:0x0648, B:220:0x064d, B:222:0x065a, B:224:0x065f, B:225:0x0666, B:227:0x0690, B:228:0x06cb, B:230:0x06d2, B:28:0x010f, B:42:0x0158, B:41:0x014d), top: B:237:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x028e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$putMessages$139(boolean r38, long r39, org.rbmain.tgnet.TLRPC$messages_Messages r41, int r42, long r43, boolean r45) {
        /*
            Method dump skipped, instructions count: 1762
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.MessagesStorage.lambda$putMessages$139(boolean, long, org.rbmain.tgnet.TLRPC$messages_Messages, int, long, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$putMessages$138(ArrayList arrayList) {
        getFileLoader().cancelLoadFiles(arrayList);
    }

    public static void addUsersAndChatsFromMessage(TLRPC$Message tLRPC$Message, ArrayList<Integer> arrayList, ArrayList<Integer> arrayList2) {
        TLRPC$Peer tLRPC$Peer;
        int fromChatId = MessageObject.getFromChatId(tLRPC$Message);
        if (fromChatId > 0) {
            if (!arrayList.contains(Integer.valueOf(fromChatId))) {
                arrayList.add(Integer.valueOf(fromChatId));
            }
        } else if (fromChatId < 0) {
            int i = -fromChatId;
            if (!arrayList2.contains(Integer.valueOf(i))) {
                arrayList2.add(Integer.valueOf(i));
            }
        }
        int i2 = tLRPC$Message.via_bot_id;
        if (i2 != 0 && !arrayList.contains(Integer.valueOf(i2))) {
            arrayList.add(Integer.valueOf(tLRPC$Message.via_bot_id));
        }
        TLRPC$MessageAction tLRPC$MessageAction = tLRPC$Message.action;
        if (tLRPC$MessageAction != null) {
            int i3 = tLRPC$MessageAction.user_id;
            if (i3 != 0 && !arrayList.contains(Integer.valueOf(i3))) {
                arrayList.add(Integer.valueOf(tLRPC$Message.action.user_id));
            }
            int i4 = tLRPC$Message.action.channel_id;
            if (i4 != 0 && !arrayList2.contains(Integer.valueOf(i4))) {
                arrayList2.add(Integer.valueOf(tLRPC$Message.action.channel_id));
            }
            int i5 = tLRPC$Message.action.chat_id;
            if (i5 != 0 && !arrayList2.contains(Integer.valueOf(i5))) {
                arrayList2.add(Integer.valueOf(tLRPC$Message.action.chat_id));
            }
            TLRPC$MessageAction tLRPC$MessageAction2 = tLRPC$Message.action;
            if (tLRPC$MessageAction2 instanceof TLRPC$TL_messageActionGeoProximityReached) {
                TLRPC$TL_messageActionGeoProximityReached tLRPC$TL_messageActionGeoProximityReached = (TLRPC$TL_messageActionGeoProximityReached) tLRPC$MessageAction2;
                Integer numValueOf = Integer.valueOf(MessageObject.getPeerId(tLRPC$TL_messageActionGeoProximityReached.from_id));
                if (numValueOf.intValue() > 0) {
                    if (!arrayList.contains(numValueOf)) {
                        arrayList.add(numValueOf);
                    }
                } else if (!arrayList2.contains(Integer.valueOf(-numValueOf.intValue()))) {
                    arrayList2.add(Integer.valueOf(-numValueOf.intValue()));
                }
                Integer numValueOf2 = Integer.valueOf(MessageObject.getPeerId(tLRPC$TL_messageActionGeoProximityReached.to_id));
                if (numValueOf2.intValue() > 0) {
                    if (!arrayList.contains(numValueOf2)) {
                        arrayList.add(numValueOf2);
                    }
                } else if (!arrayList2.contains(Integer.valueOf(-numValueOf2.intValue()))) {
                    arrayList2.add(Integer.valueOf(-numValueOf2.intValue()));
                }
            }
            if (!tLRPC$Message.action.users.isEmpty()) {
                for (int i6 = 0; i6 < tLRPC$Message.action.users.size(); i6++) {
                    Integer num = tLRPC$Message.action.users.get(i6);
                    if (!arrayList.contains(num)) {
                        arrayList.add(num);
                    }
                }
            }
        }
        if (!tLRPC$Message.entities.isEmpty()) {
            for (int i7 = 0; i7 < tLRPC$Message.entities.size(); i7++) {
                TLRPC$MessageEntity tLRPC$MessageEntity = tLRPC$Message.entities.get(i7);
                if (tLRPC$MessageEntity instanceof TLRPC$TL_messageEntityMentionName) {
                    arrayList.add(Integer.valueOf(((TLRPC$TL_messageEntityMentionName) tLRPC$MessageEntity).user_id));
                } else if (tLRPC$MessageEntity instanceof TLRPC$TL_inputMessageEntityMentionName) {
                    arrayList.add(Integer.valueOf(((TLRPC$TL_inputMessageEntityMentionName) tLRPC$MessageEntity).user_id.user_id));
                }
            }
        }
        TLRPC$MessageMedia tLRPC$MessageMedia = tLRPC$Message.media;
        if (tLRPC$MessageMedia != null) {
            int i8 = tLRPC$MessageMedia.user_id;
            if (i8 != 0 && !arrayList.contains(Integer.valueOf(i8))) {
                arrayList.add(Integer.valueOf(tLRPC$Message.media.user_id));
            }
            TLRPC$MessageMedia tLRPC$MessageMedia2 = tLRPC$Message.media;
            if (tLRPC$MessageMedia2 instanceof TLRPC$TL_messageMediaPoll) {
                TLRPC$TL_messageMediaPoll tLRPC$TL_messageMediaPoll = (TLRPC$TL_messageMediaPoll) tLRPC$MessageMedia2;
                if (!tLRPC$TL_messageMediaPoll.results.recent_voters.isEmpty()) {
                    arrayList.addAll(tLRPC$TL_messageMediaPoll.results.recent_voters);
                }
            }
        }
        TLRPC$MessageReplies tLRPC$MessageReplies = tLRPC$Message.replies;
        if (tLRPC$MessageReplies != null) {
            int size = tLRPC$MessageReplies.recent_repliers.size();
            for (int i9 = 0; i9 < size; i9++) {
                int peerId = MessageObject.getPeerId(tLRPC$Message.replies.recent_repliers.get(i9));
                if (peerId > 0) {
                    if (!arrayList.contains(Integer.valueOf(peerId))) {
                        arrayList.add(Integer.valueOf(peerId));
                    }
                } else if (peerId < 0) {
                    int i10 = -peerId;
                    if (!arrayList2.contains(Integer.valueOf(i10))) {
                        arrayList2.add(Integer.valueOf(i10));
                    }
                }
            }
        }
        TLRPC$TL_messageReplyHeader tLRPC$TL_messageReplyHeader = tLRPC$Message.reply_to;
        if (tLRPC$TL_messageReplyHeader != null && (tLRPC$Peer = tLRPC$TL_messageReplyHeader.reply_to_peer_id) != null) {
            int peerId2 = MessageObject.getPeerId(tLRPC$Peer);
            if (peerId2 > 0) {
                if (!arrayList.contains(Integer.valueOf(peerId2))) {
                    arrayList.add(Integer.valueOf(peerId2));
                }
            } else if (peerId2 < 0) {
                int i11 = -peerId2;
                if (!arrayList2.contains(Integer.valueOf(i11))) {
                    arrayList2.add(Integer.valueOf(i11));
                }
            }
        }
        TLRPC$MessageFwdHeader tLRPC$MessageFwdHeader = tLRPC$Message.fwd_from;
        if (tLRPC$MessageFwdHeader != null) {
            TLRPC$Peer tLRPC$Peer2 = tLRPC$MessageFwdHeader.from_id;
            if (tLRPC$Peer2 instanceof TLRPC$TL_peerUser) {
                if (!arrayList.contains(Integer.valueOf(tLRPC$Peer2.user_id))) {
                    arrayList.add(Integer.valueOf(tLRPC$Message.fwd_from.from_id.user_id));
                }
            } else if (tLRPC$Peer2 instanceof TLRPC$TL_peerChannel) {
                if (!arrayList2.contains(Integer.valueOf(tLRPC$Peer2.channel_id))) {
                    arrayList2.add(Integer.valueOf(tLRPC$Message.fwd_from.from_id.channel_id));
                }
            } else if ((tLRPC$Peer2 instanceof TLRPC$TL_peerChat) && !arrayList2.contains(Integer.valueOf(tLRPC$Peer2.chat_id))) {
                arrayList2.add(Integer.valueOf(tLRPC$Message.fwd_from.from_id.chat_id));
            }
            TLRPC$Peer tLRPC$Peer3 = tLRPC$Message.fwd_from.saved_from_peer;
            if (tLRPC$Peer3 != null) {
                int i12 = tLRPC$Peer3.user_id;
                if (i12 != 0) {
                    if (!arrayList2.contains(Integer.valueOf(i12))) {
                        arrayList.add(Integer.valueOf(tLRPC$Message.fwd_from.saved_from_peer.user_id));
                    }
                } else {
                    int i13 = tLRPC$Peer3.channel_id;
                    if (i13 != 0) {
                        if (!arrayList2.contains(Integer.valueOf(i13))) {
                            arrayList2.add(Integer.valueOf(tLRPC$Message.fwd_from.saved_from_peer.channel_id));
                        }
                    } else {
                        int i14 = tLRPC$Peer3.chat_id;
                        if (i14 != 0 && !arrayList2.contains(Integer.valueOf(i14))) {
                            arrayList2.add(Integer.valueOf(tLRPC$Message.fwd_from.saved_from_peer.chat_id));
                        }
                    }
                }
            }
        }
        int i15 = tLRPC$Message.ttl;
        if (i15 >= 0 || arrayList2.contains(Integer.valueOf(-i15))) {
            return;
        }
        arrayList2.add(Integer.valueOf(-tLRPC$Message.ttl));
    }

    public void getDialogs(final int i, final long j, final int i2, boolean z) {
        LongSparseArray<LongSparseArray<TLRPC$DraftMessage>> drafts;
        int size;
        long[] jArr = null;
        if (z && (size = (drafts = getMediaDataController().getDrafts()).size()) > 0) {
            jArr = new long[size];
            for (int i3 = 0; i3 < size; i3++) {
                if (drafts.valueAt(i3).get(0L) != null) {
                    jArr[i3] = drafts.keyAt(i3);
                }
            }
        }
        final long[] jArr2 = jArr;
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda37
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getDialogs$141(i, j, i2, jArr2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:109:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x029f A[Catch: Exception -> 0x0439, TryCatch #2 {Exception -> 0x0439, blocks: (B:13:0x006d, B:14:0x0094, B:16:0x009a, B:18:0x00a6, B:20:0x00b3, B:22:0x00b9, B:26:0x00db, B:28:0x00ee, B:30:0x0112, B:35:0x011b, B:39:0x013b, B:43:0x0152, B:45:0x016a, B:47:0x0171, B:48:0x0176, B:50:0x0185, B:51:0x018c, B:53:0x0193, B:55:0x019e, B:57:0x01c1, B:58:0x01c3, B:110:0x0270, B:113:0x027a, B:115:0x0284, B:116:0x028c, B:118:0x0297, B:119:0x029f, B:121:0x02a9, B:107:0x025e, B:108:0x0262, B:23:0x00ca, B:27:0x00e7, B:123:0x02b7, B:126:0x02cf), top: B:198:0x006d }] */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0233 A[EXC_TOP_SPLITTER, PHI: r0 r11
      0x0233: PHI (r0v96 int) = (r0v95 int), (r0v103 int) binds: [B:86:0x0231, B:82:0x0229] A[DONT_GENERATE, DONT_INLINE]
      0x0233: PHI (r11v22 java.util.ArrayList) = (r11v21 java.util.ArrayList), (r11v25 java.util.ArrayList) binds: [B:86:0x0231, B:82:0x0229] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0243 A[Catch: Exception -> 0x0254, TryCatch #7 {Exception -> 0x0254, blocks: (B:90:0x023d, B:92:0x0243, B:93:0x024a), top: B:208:0x023d }] */
    /* JADX WARN: Type inference failed for: r0v114, types: [org.rbmain.tgnet.TLRPC$TL_dialogFolder] */
    /* JADX WARN: Type inference failed for: r0v22, types: [org.rbmain.SQLite.SQLiteCursor] */
    /* JADX WARN: Type inference failed for: r0v35, types: [org.rbmain.tgnet.TLRPC$TL_dialog] */
    /* JADX WARN: Type inference failed for: r0v36 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v15, types: [org.rbmain.tgnet.AbstractSerializedData, org.rbmain.tgnet.NativeByteBuffer] */
    /* JADX WARN: Type inference failed for: r8v15, types: [org.rbmain.tgnet.TLRPC$Message] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$getDialogs$141(int r27, long r28, int r30, long[] r31) {
        /*
            Method dump skipped, instructions count: 1131
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.MessagesStorage.lambda$getDialogs$141(int, long, int, long[]):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getDialogs$140(LongSparseArray longSparseArray) {
        MediaDataController mediaDataController = getMediaDataController();
        mediaDataController.clearDraftsFolderIds();
        if (longSparseArray != null) {
            int size = longSparseArray.size();
            for (int i = 0; i < size; i++) {
                mediaDataController.setDraftFolderId(longSparseArray.keyAt(i), ((Integer) longSparseArray.valueAt(i)).intValue());
            }
        }
    }

    public static void createFirstHoles(long j, SQLitePreparedStatement sQLitePreparedStatement, SQLitePreparedStatement sQLitePreparedStatement2, long j2) throws Exception {
        sQLitePreparedStatement.requery();
        sQLitePreparedStatement.bindLong(1, j);
        sQLitePreparedStatement.bindInteger(2, j2 == 1 ? 1 : 0);
        sQLitePreparedStatement.bindLong(3, j2);
        sQLitePreparedStatement.step();
        for (int i = 0; i < 6; i++) {
            sQLitePreparedStatement2.requery();
            sQLitePreparedStatement2.bindLong(1, j);
            sQLitePreparedStatement2.bindInteger(2, i);
            sQLitePreparedStatement2.bindInteger(3, j2 == 1 ? 1 : 0);
            sQLitePreparedStatement2.bindLong(4, j2);
            sQLitePreparedStatement2.step();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0121, code lost:
    
        if (r12 < 0) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x037c A[Catch: Exception -> 0x040f, TryCatch #0 {Exception -> 0x040f, blocks: (B:3:0x0006, B:4:0x0017, B:6:0x001f, B:7:0x0031, B:9:0x0039, B:10:0x006f, B:12:0x0077, B:14:0x008f, B:126:0x03c5, B:37:0x012f, B:39:0x013c, B:41:0x0149, B:43:0x0155, B:45:0x0172, B:46:0x0176, B:48:0x01a7, B:53:0x01af, B:55:0x01bf, B:57:0x01c3, B:65:0x01d7, B:69:0x01e1, B:71:0x01f1, B:73:0x020e, B:75:0x0212, B:79:0x021f, B:81:0x022d, B:83:0x0236, B:86:0x0262, B:87:0x0265, B:89:0x026c, B:92:0x0276, B:93:0x027e, B:95:0x02a1, B:98:0x02ac, B:99:0x02b4, B:102:0x02cd, B:106:0x0317, B:108:0x031d, B:110:0x0321, B:111:0x0325, B:113:0x037c, B:115:0x039b, B:117:0x03a0, B:118:0x03a3, B:120:0x03a7, B:124:0x03bc, B:114:0x0395, B:103:0x02f1, B:78:0x021d, B:80:0x0225, B:72:0x0208, B:19:0x00b9, B:21:0x00db, B:23:0x00df, B:26:0x00e9, B:29:0x00f0, B:31:0x0112, B:33:0x011a, B:127:0x03d2, B:129:0x03e9, B:131:0x03f6, B:132:0x03f9), top: B:137:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0395 A[Catch: Exception -> 0x040f, TryCatch #0 {Exception -> 0x040f, blocks: (B:3:0x0006, B:4:0x0017, B:6:0x001f, B:7:0x0031, B:9:0x0039, B:10:0x006f, B:12:0x0077, B:14:0x008f, B:126:0x03c5, B:37:0x012f, B:39:0x013c, B:41:0x0149, B:43:0x0155, B:45:0x0172, B:46:0x0176, B:48:0x01a7, B:53:0x01af, B:55:0x01bf, B:57:0x01c3, B:65:0x01d7, B:69:0x01e1, B:71:0x01f1, B:73:0x020e, B:75:0x0212, B:79:0x021f, B:81:0x022d, B:83:0x0236, B:86:0x0262, B:87:0x0265, B:89:0x026c, B:92:0x0276, B:93:0x027e, B:95:0x02a1, B:98:0x02ac, B:99:0x02b4, B:102:0x02cd, B:106:0x0317, B:108:0x031d, B:110:0x0321, B:111:0x0325, B:113:0x037c, B:115:0x039b, B:117:0x03a0, B:118:0x03a3, B:120:0x03a7, B:124:0x03bc, B:114:0x0395, B:103:0x02f1, B:78:0x021d, B:80:0x0225, B:72:0x0208, B:19:0x00b9, B:21:0x00db, B:23:0x00df, B:26:0x00e9, B:29:0x00f0, B:31:0x0112, B:33:0x011a, B:127:0x03d2, B:129:0x03e9, B:131:0x03f6, B:132:0x03f9), top: B:137:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x03a0 A[Catch: Exception -> 0x040f, TryCatch #0 {Exception -> 0x040f, blocks: (B:3:0x0006, B:4:0x0017, B:6:0x001f, B:7:0x0031, B:9:0x0039, B:10:0x006f, B:12:0x0077, B:14:0x008f, B:126:0x03c5, B:37:0x012f, B:39:0x013c, B:41:0x0149, B:43:0x0155, B:45:0x0172, B:46:0x0176, B:48:0x01a7, B:53:0x01af, B:55:0x01bf, B:57:0x01c3, B:65:0x01d7, B:69:0x01e1, B:71:0x01f1, B:73:0x020e, B:75:0x0212, B:79:0x021f, B:81:0x022d, B:83:0x0236, B:86:0x0262, B:87:0x0265, B:89:0x026c, B:92:0x0276, B:93:0x027e, B:95:0x02a1, B:98:0x02ac, B:99:0x02b4, B:102:0x02cd, B:106:0x0317, B:108:0x031d, B:110:0x0321, B:111:0x0325, B:113:0x037c, B:115:0x039b, B:117:0x03a0, B:118:0x03a3, B:120:0x03a7, B:124:0x03bc, B:114:0x0395, B:103:0x02f1, B:78:0x021d, B:80:0x0225, B:72:0x0208, B:19:0x00b9, B:21:0x00db, B:23:0x00df, B:26:0x00e9, B:29:0x00f0, B:31:0x0112, B:33:0x011a, B:127:0x03d2, B:129:0x03e9, B:131:0x03f6, B:132:0x03f9), top: B:137:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x03a7 A[Catch: Exception -> 0x040f, TryCatch #0 {Exception -> 0x040f, blocks: (B:3:0x0006, B:4:0x0017, B:6:0x001f, B:7:0x0031, B:9:0x0039, B:10:0x006f, B:12:0x0077, B:14:0x008f, B:126:0x03c5, B:37:0x012f, B:39:0x013c, B:41:0x0149, B:43:0x0155, B:45:0x0172, B:46:0x0176, B:48:0x01a7, B:53:0x01af, B:55:0x01bf, B:57:0x01c3, B:65:0x01d7, B:69:0x01e1, B:71:0x01f1, B:73:0x020e, B:75:0x0212, B:79:0x021f, B:81:0x022d, B:83:0x0236, B:86:0x0262, B:87:0x0265, B:89:0x026c, B:92:0x0276, B:93:0x027e, B:95:0x02a1, B:98:0x02ac, B:99:0x02b4, B:102:0x02cd, B:106:0x0317, B:108:0x031d, B:110:0x0321, B:111:0x0325, B:113:0x037c, B:115:0x039b, B:117:0x03a0, B:118:0x03a3, B:120:0x03a7, B:124:0x03bc, B:114:0x0395, B:103:0x02f1, B:78:0x021d, B:80:0x0225, B:72:0x0208, B:19:0x00b9, B:21:0x00db, B:23:0x00df, B:26:0x00e9, B:29:0x00f0, B:31:0x0112, B:33:0x011a, B:127:0x03d2, B:129:0x03e9, B:131:0x03f6, B:132:0x03f9), top: B:137:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x03c3  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x013c A[Catch: Exception -> 0x040f, TryCatch #0 {Exception -> 0x040f, blocks: (B:3:0x0006, B:4:0x0017, B:6:0x001f, B:7:0x0031, B:9:0x0039, B:10:0x006f, B:12:0x0077, B:14:0x008f, B:126:0x03c5, B:37:0x012f, B:39:0x013c, B:41:0x0149, B:43:0x0155, B:45:0x0172, B:46:0x0176, B:48:0x01a7, B:53:0x01af, B:55:0x01bf, B:57:0x01c3, B:65:0x01d7, B:69:0x01e1, B:71:0x01f1, B:73:0x020e, B:75:0x0212, B:79:0x021f, B:81:0x022d, B:83:0x0236, B:86:0x0262, B:87:0x0265, B:89:0x026c, B:92:0x0276, B:93:0x027e, B:95:0x02a1, B:98:0x02ac, B:99:0x02b4, B:102:0x02cd, B:106:0x0317, B:108:0x031d, B:110:0x0321, B:111:0x0325, B:113:0x037c, B:115:0x039b, B:117:0x03a0, B:118:0x03a3, B:120:0x03a7, B:124:0x03bc, B:114:0x0395, B:103:0x02f1, B:78:0x021d, B:80:0x0225, B:72:0x0208, B:19:0x00b9, B:21:0x00db, B:23:0x00df, B:26:0x00e9, B:29:0x00f0, B:31:0x0112, B:33:0x011a, B:127:0x03d2, B:129:0x03e9, B:131:0x03f6, B:132:0x03f9), top: B:137:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void putDialogsInternal(org.rbmain.tgnet.TLRPC$messages_Dialogs r36, int r37) {
        /*
            Method dump skipped, instructions count: 1044
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.MessagesStorage.putDialogsInternal(org.rbmain.tgnet.TLRPC$messages_Dialogs, int):void");
    }

    public void getDialogFolderId(final long j, final IntCallback intCallback) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda73
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getDialogFolderId$143(j, intCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getDialogFolderId$143(long j, final IntCallback intCallback) {
        try {
            if (this.unknownDialogsIds.get(j) == null) {
                SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized("SELECT folder_id FROM dialogs WHERE did = ?", Long.valueOf(j));
                iIntValue = sQLiteCursorQueryFinalized.next() ? sQLiteCursorQueryFinalized.intValue(0) : -1;
                sQLiteCursorQueryFinalized.dispose();
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    intCallback.run(iIntValue);
                }
            });
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void setDialogsFolderId(final ArrayList<TLRPC$TL_folderPeer> arrayList, final ArrayList<TLRPC$TL_inputFolderPeer> arrayList2, final long j, final int i) {
        if (arrayList == null && arrayList2 == null && j == 0) {
            return;
        }
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda110
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setDialogsFolderId$144(arrayList, arrayList2, i, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setDialogsFolderId$144(ArrayList arrayList, ArrayList arrayList2, int i, long j) {
        try {
            this.database.beginTransaction();
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("UPDATE dialogs SET folder_id = ?, pinned = ? WHERE did = ?");
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    TLRPC$TL_folderPeer tLRPC$TL_folderPeer = (TLRPC$TL_folderPeer) arrayList.get(i2);
                    long peerDialogId = DialogObject.getPeerDialogId(tLRPC$TL_folderPeer.peer);
                    sQLitePreparedStatementExecuteFast.requery();
                    sQLitePreparedStatementExecuteFast.bindInteger(1, tLRPC$TL_folderPeer.folder_id);
                    sQLitePreparedStatementExecuteFast.bindInteger(2, 0);
                    sQLitePreparedStatementExecuteFast.bindLong(3, peerDialogId);
                    sQLitePreparedStatementExecuteFast.step();
                    this.unknownDialogsIds.remove(peerDialogId);
                }
            } else if (arrayList2 != null) {
                int size2 = arrayList2.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    TLRPC$TL_inputFolderPeer tLRPC$TL_inputFolderPeer = (TLRPC$TL_inputFolderPeer) arrayList2.get(i3);
                    long peerDialogId2 = DialogObject.getPeerDialogId(tLRPC$TL_inputFolderPeer.peer);
                    sQLitePreparedStatementExecuteFast.requery();
                    sQLitePreparedStatementExecuteFast.bindInteger(1, tLRPC$TL_inputFolderPeer.folder_id);
                    sQLitePreparedStatementExecuteFast.bindInteger(2, 0);
                    sQLitePreparedStatementExecuteFast.bindLong(3, peerDialogId2);
                    sQLitePreparedStatementExecuteFast.step();
                    this.unknownDialogsIds.remove(peerDialogId2);
                }
            } else {
                sQLitePreparedStatementExecuteFast.requery();
                sQLitePreparedStatementExecuteFast.bindInteger(1, i);
                sQLitePreparedStatementExecuteFast.bindInteger(2, 0);
                sQLitePreparedStatementExecuteFast.bindLong(3, j);
                sQLitePreparedStatementExecuteFast.step();
            }
            sQLitePreparedStatementExecuteFast.dispose();
            this.database.commitTransaction();
            lambda$checkIfFolderEmpty$146(1);
            resetAllUnreadCounters(false);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: checkIfFolderEmptyInternal, reason: merged with bridge method [inline-methods] */
    public void lambda$checkIfFolderEmpty$146(final int i) {
        try {
            boolean z = true;
            SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized("SELECT did FROM dialogs WHERE folder_id = ?", Integer.valueOf(i));
            while (sQLiteCursorQueryFinalized.next()) {
                long jLongValue = sQLiteCursorQueryFinalized.longValue(0);
                int i2 = (int) jLongValue;
                int i3 = (int) (jLongValue >> 32);
                if (i2 <= 0 && (i3 == 0 || i2 != 0)) {
                    TLRPC$Chat chat = getChat(-i2);
                    if (ChatObject.isNotInChat(chat) || chat.migrated_to != null) {
                    }
                }
                z = false;
            }
            sQLiteCursorQueryFinalized.dispose();
            if (z) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda19
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$checkIfFolderEmptyInternal$145(i);
                    }
                });
                this.database.executeFast("DELETE FROM dialogs WHERE did = " + DialogObject.makeFolderDialogId(i)).stepThis().dispose();
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkIfFolderEmptyInternal$145(int i) {
        getMessagesController().onFolderEmpty(i);
    }

    public void checkIfFolderEmpty(final int i) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda16
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$checkIfFolderEmpty$146(i);
            }
        });
    }

    public void unpinAllDialogsExceptNew(final ArrayList<Long> arrayList, final int i) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda105
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$unpinAllDialogsExceptNew$147(arrayList, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$unpinAllDialogsExceptNew$147(ArrayList arrayList, int i) {
        try {
            ArrayList arrayList2 = new ArrayList();
            SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT did, folder_id FROM dialogs WHERE pinned > 0 AND did NOT IN (%s)", TextUtils.join(",", arrayList)), new Object[0]);
            while (sQLiteCursorQueryFinalized.next()) {
                long jLongValue = sQLiteCursorQueryFinalized.longValue(0);
                if (sQLiteCursorQueryFinalized.intValue(1) == i && ((int) jLongValue) != 0 && !DialogObject.isFolderDialogId(jLongValue)) {
                    arrayList2.add(Long.valueOf(sQLiteCursorQueryFinalized.longValue(0)));
                }
            }
            sQLiteCursorQueryFinalized.dispose();
            if (arrayList2.isEmpty()) {
                return;
            }
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("UPDATE dialogs SET pinned = ? WHERE did = ?");
            for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                long jLongValue2 = ((Long) arrayList2.get(i2)).longValue();
                sQLitePreparedStatementExecuteFast.requery();
                sQLitePreparedStatementExecuteFast.bindInteger(1, 0);
                sQLitePreparedStatementExecuteFast.bindLong(2, jLongValue2);
                sQLitePreparedStatementExecuteFast.step();
            }
            sQLitePreparedStatementExecuteFast.dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void setDialogUnread(final long j, final boolean z) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda78
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setDialogUnread$148(j, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Finally extract failed */
    public /* synthetic */ void lambda$setDialogUnread$148(long j, boolean z) {
        int iIntValue;
        SQLiteCursor sQLiteCursorQueryFinalized = null;
        try {
            try {
                try {
                    sQLiteCursorQueryFinalized = this.database.queryFinalized("SELECT flags FROM dialogs WHERE did = " + j, new Object[0]);
                    iIntValue = sQLiteCursorQueryFinalized.next() ? sQLiteCursorQueryFinalized.intValue(0) : 0;
                    sQLiteCursorQueryFinalized.dispose();
                } catch (Exception e) {
                    FileLog.e(e);
                    if (sQLiteCursorQueryFinalized != null) {
                        sQLiteCursorQueryFinalized.dispose();
                    }
                    iIntValue = 0;
                }
                int i = z ? iIntValue | 1 : iIntValue & (-2);
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("UPDATE dialogs SET flags = ? WHERE did = ?");
                sQLitePreparedStatementExecuteFast.bindInteger(1, i);
                sQLitePreparedStatementExecuteFast.bindLong(2, j);
                sQLitePreparedStatementExecuteFast.step();
                sQLitePreparedStatementExecuteFast.dispose();
                resetAllUnreadCounters(false);
            } catch (Throwable th) {
                if (sQLiteCursorQueryFinalized != null) {
                    sQLiteCursorQueryFinalized.dispose();
                }
                throw th;
            }
        } catch (Exception e2) {
            FileLog.e(e2);
        }
    }

    public void setDialogPinned(final long j, final int i) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda36
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setDialogPinned$149(i, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setDialogPinned$149(int i, long j) {
        try {
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("UPDATE dialogs SET pinned = ? WHERE did = ?");
            sQLitePreparedStatementExecuteFast.bindInteger(1, i);
            sQLitePreparedStatementExecuteFast.bindLong(2, j);
            sQLitePreparedStatementExecuteFast.step();
            sQLitePreparedStatementExecuteFast.dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void setDialogsPinned(final ArrayList<Long> arrayList, final ArrayList<Integer> arrayList2) {
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda108
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setDialogsPinned$150(arrayList, arrayList2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setDialogsPinned$150(ArrayList arrayList, ArrayList arrayList2) {
        try {
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("UPDATE dialogs SET pinned = ? WHERE did = ?");
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                sQLitePreparedStatementExecuteFast.requery();
                sQLitePreparedStatementExecuteFast.bindInteger(1, ((Integer) arrayList2.get(i)).intValue());
                sQLitePreparedStatementExecuteFast.bindLong(2, ((Long) arrayList.get(i)).longValue());
                sQLitePreparedStatementExecuteFast.step();
            }
            sQLitePreparedStatementExecuteFast.dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void putDialogs(final TLRPC$messages_Dialogs tLRPC$messages_Dialogs, final int i) {
        if (tLRPC$messages_Dialogs.dialogs.isEmpty()) {
            return;
        }
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda138
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$putDialogs$151(tLRPC$messages_Dialogs, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$putDialogs$151(TLRPC$messages_Dialogs tLRPC$messages_Dialogs, int i) {
        putDialogsInternal(tLRPC$messages_Dialogs, i);
        try {
            loadUnreadMessages();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public long getDialogReadMax(boolean z, long j) {
        Chat chatInstant;
        if (j == 0 || (chatInstant = getAccountInstance().getCoreMainClass().getChatInstant(IdStorage.getInstance().getDialogId(j))) == null) {
            return 0L;
        }
        if (z) {
            return chatInstant.last_seen_peer_mid;
        }
        return chatInstant.lastSeenMyMid;
    }

    public int getChannelPtsSync(final int i) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final Integer[] numArr = {0};
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda50
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getChannelPtsSync$152(i, numArr, countDownLatch);
            }
        });
        try {
            countDownLatch.await();
        } catch (Exception e) {
            FileLog.e(e);
        }
        return numArr[0].intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getChannelPtsSync$152(int i, Integer[] numArr, CountDownLatch countDownLatch) {
        SQLiteCursor sQLiteCursorQueryFinalized = null;
        try {
            try {
                sQLiteCursorQueryFinalized = this.database.queryFinalized("SELECT pts FROM dialogs WHERE did = " + (-i), new Object[0]);
                if (sQLiteCursorQueryFinalized.next()) {
                    numArr[0] = Integer.valueOf(sQLiteCursorQueryFinalized.intValue(0));
                }
            } catch (Exception e) {
                FileLog.e(e);
                if (sQLiteCursorQueryFinalized != null) {
                }
            }
            sQLiteCursorQueryFinalized.dispose();
            try {
                countDownLatch.countDown();
            } catch (Exception e2) {
                FileLog.e(e2);
            }
        } catch (Throwable th) {
            if (sQLiteCursorQueryFinalized != null) {
                sQLiteCursorQueryFinalized.dispose();
            }
            throw th;
        }
    }

    public TLRPC$User getUserSync(final int i) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final TLRPC$User[] tLRPC$UserArr = new TLRPC$User[1];
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda152
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getUserSync$153(tLRPC$UserArr, i, countDownLatch);
            }
        });
        try {
            countDownLatch.await();
        } catch (Exception e) {
            FileLog.e(e);
        }
        return tLRPC$UserArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getUserSync$153(TLRPC$User[] tLRPC$UserArr, int i, CountDownLatch countDownLatch) {
        tLRPC$UserArr[0] = getUser(i);
        countDownLatch.countDown();
    }

    public TLRPC$Chat getChatSync(final int i) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final TLRPC$Chat[] tLRPC$ChatArr = new TLRPC$Chat[1];
        this.storageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda150
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getChatSync$154(tLRPC$ChatArr, i, countDownLatch);
            }
        });
        try {
            countDownLatch.await();
        } catch (Exception e) {
            FileLog.e(e);
        }
        return tLRPC$ChatArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getChatSync$154(TLRPC$Chat[] tLRPC$ChatArr, int i, CountDownLatch countDownLatch) {
        tLRPC$ChatArr[0] = getChat(i);
        countDownLatch.countDown();
    }

    public TLRPC$User getUser(int i) {
        try {
            ArrayList<TLRPC$User> arrayList = new ArrayList<>();
            getUsersInternal(io.github.inflationx.calligraphy3.BuildConfig.FLAVOR + i, arrayList);
            if (arrayList.isEmpty()) {
                return null;
            }
            return arrayList.get(0);
        } catch (Exception e) {
            FileLog.e(e);
            return null;
        }
    }

    public ArrayList<TLRPC$User> getUsers(ArrayList<Integer> arrayList) {
        ArrayList<TLRPC$User> arrayList2 = new ArrayList<>();
        try {
            getUsersInternal(TextUtils.join(",", arrayList), arrayList2);
        } catch (Exception e) {
            arrayList2.clear();
            FileLog.e(e);
        }
        return arrayList2;
    }

    public TLRPC$Chat getChat(int i) {
        try {
            ArrayList<TLRPC$Chat> arrayList = new ArrayList<>();
            getChatsInternal(io.github.inflationx.calligraphy3.BuildConfig.FLAVOR + i, arrayList);
            if (arrayList.isEmpty()) {
                return null;
            }
            return arrayList.get(0);
        } catch (Exception e) {
            FileLog.e(e);
            return null;
        }
    }

    public TLRPC$EncryptedChat getEncryptedChat(int i) {
        try {
            ArrayList<TLRPC$EncryptedChat> arrayList = new ArrayList<>();
            getEncryptedChatsInternal(io.github.inflationx.calligraphy3.BuildConfig.FLAVOR + i, arrayList, null);
            if (arrayList.isEmpty()) {
                return null;
            }
            return arrayList.get(0);
        } catch (Exception e) {
            FileLog.e(e);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:165:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x04e0 A[Catch: Exception -> 0x063e, LOOP:6: B:150:0x0370->B:188:0x04e0, LOOP_END, TryCatch #0 {Exception -> 0x063e, blocks: (B:3:0x0012, B:6:0x0021, B:8:0x003e, B:15:0x004c, B:17:0x0053, B:18:0x0055, B:20:0x006b, B:22:0x008d, B:24:0x0093, B:33:0x00bd, B:35:0x00c7, B:39:0x00d3, B:41:0x00de, B:45:0x00eb, B:47:0x00f5, B:49:0x0101, B:51:0x010b, B:55:0x0117, B:57:0x0138, B:60:0x0146, B:61:0x0162, B:63:0x0168, B:66:0x017c, B:68:0x0183, B:72:0x0191, B:74:0x019b, B:77:0x01b2, B:79:0x01b8, B:83:0x01d0, B:89:0x01de, B:91:0x01e5, B:93:0x0200, B:95:0x0208, B:97:0x023a, B:96:0x0213, B:98:0x023f, B:101:0x0256, B:103:0x0262, B:105:0x0268, B:106:0x0284, B:108:0x028a, B:113:0x02a1, B:115:0x02a9, B:118:0x02c0, B:120:0x02c6, B:123:0x02dc, B:124:0x02df, B:126:0x02e6, B:128:0x02f3, B:130:0x02f7, B:132:0x02fd, B:134:0x0303, B:135:0x031c, B:136:0x031f, B:138:0x0325, B:139:0x0341, B:141:0x0347, B:145:0x035d, B:147:0x0366, B:151:0x0372, B:153:0x037a, B:156:0x0391, B:158:0x0397, B:162:0x03af, B:167:0x03ba, B:169:0x03c1, B:171:0x03cf, B:173:0x03d6, B:177:0x03e8, B:179:0x046e, B:180:0x0470, B:182:0x047c, B:185:0x0486, B:187:0x04d6, B:186:0x04af, B:188:0x04e0, B:191:0x04ec, B:193:0x04f4, B:194:0x04fa, B:196:0x0500, B:198:0x050a, B:200:0x050e, B:201:0x0511, B:202:0x0514, B:203:0x051a, B:205:0x0520, B:208:0x0540, B:209:0x054d, B:211:0x0553, B:214:0x0560, B:217:0x0574, B:219:0x057b, B:223:0x0587, B:225:0x058f, B:228:0x05a6, B:230:0x05ac, B:234:0x05c4, B:239:0x05cf, B:241:0x05d6, B:243:0x05e6, B:245:0x05ee, B:247:0x0623, B:246:0x05fb, B:249:0x062a, B:252:0x063a, B:53:0x0111, B:21:0x0080), top: B:257:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:237:0x05cc  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x062a A[Catch: Exception -> 0x063e, LOOP:10: B:222:0x0585->B:249:0x062a, LOOP_END, TryCatch #0 {Exception -> 0x063e, blocks: (B:3:0x0012, B:6:0x0021, B:8:0x003e, B:15:0x004c, B:17:0x0053, B:18:0x0055, B:20:0x006b, B:22:0x008d, B:24:0x0093, B:33:0x00bd, B:35:0x00c7, B:39:0x00d3, B:41:0x00de, B:45:0x00eb, B:47:0x00f5, B:49:0x0101, B:51:0x010b, B:55:0x0117, B:57:0x0138, B:60:0x0146, B:61:0x0162, B:63:0x0168, B:66:0x017c, B:68:0x0183, B:72:0x0191, B:74:0x019b, B:77:0x01b2, B:79:0x01b8, B:83:0x01d0, B:89:0x01de, B:91:0x01e5, B:93:0x0200, B:95:0x0208, B:97:0x023a, B:96:0x0213, B:98:0x023f, B:101:0x0256, B:103:0x0262, B:105:0x0268, B:106:0x0284, B:108:0x028a, B:113:0x02a1, B:115:0x02a9, B:118:0x02c0, B:120:0x02c6, B:123:0x02dc, B:124:0x02df, B:126:0x02e6, B:128:0x02f3, B:130:0x02f7, B:132:0x02fd, B:134:0x0303, B:135:0x031c, B:136:0x031f, B:138:0x0325, B:139:0x0341, B:141:0x0347, B:145:0x035d, B:147:0x0366, B:151:0x0372, B:153:0x037a, B:156:0x0391, B:158:0x0397, B:162:0x03af, B:167:0x03ba, B:169:0x03c1, B:171:0x03cf, B:173:0x03d6, B:177:0x03e8, B:179:0x046e, B:180:0x0470, B:182:0x047c, B:185:0x0486, B:187:0x04d6, B:186:0x04af, B:188:0x04e0, B:191:0x04ec, B:193:0x04f4, B:194:0x04fa, B:196:0x0500, B:198:0x050a, B:200:0x050e, B:201:0x0511, B:202:0x0514, B:203:0x051a, B:205:0x0520, B:208:0x0540, B:209:0x054d, B:211:0x0553, B:214:0x0560, B:217:0x0574, B:219:0x057b, B:223:0x0587, B:225:0x058f, B:228:0x05a6, B:230:0x05ac, B:234:0x05c4, B:239:0x05cf, B:241:0x05d6, B:243:0x05e6, B:245:0x05ee, B:247:0x0623, B:246:0x05fb, B:249:0x062a, B:252:0x063a, B:53:0x0111, B:21:0x0080), top: B:257:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:275:0x01de A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:298:0x03ba A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:311:0x05cf A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x023f A[Catch: Exception -> 0x063e, LOOP:2: B:71:0x018f->B:98:0x023f, LOOP_END, TryCatch #0 {Exception -> 0x063e, blocks: (B:3:0x0012, B:6:0x0021, B:8:0x003e, B:15:0x004c, B:17:0x0053, B:18:0x0055, B:20:0x006b, B:22:0x008d, B:24:0x0093, B:33:0x00bd, B:35:0x00c7, B:39:0x00d3, B:41:0x00de, B:45:0x00eb, B:47:0x00f5, B:49:0x0101, B:51:0x010b, B:55:0x0117, B:57:0x0138, B:60:0x0146, B:61:0x0162, B:63:0x0168, B:66:0x017c, B:68:0x0183, B:72:0x0191, B:74:0x019b, B:77:0x01b2, B:79:0x01b8, B:83:0x01d0, B:89:0x01de, B:91:0x01e5, B:93:0x0200, B:95:0x0208, B:97:0x023a, B:96:0x0213, B:98:0x023f, B:101:0x0256, B:103:0x0262, B:105:0x0268, B:106:0x0284, B:108:0x028a, B:113:0x02a1, B:115:0x02a9, B:118:0x02c0, B:120:0x02c6, B:123:0x02dc, B:124:0x02df, B:126:0x02e6, B:128:0x02f3, B:130:0x02f7, B:132:0x02fd, B:134:0x0303, B:135:0x031c, B:136:0x031f, B:138:0x0325, B:139:0x0341, B:141:0x0347, B:145:0x035d, B:147:0x0366, B:151:0x0372, B:153:0x037a, B:156:0x0391, B:158:0x0397, B:162:0x03af, B:167:0x03ba, B:169:0x03c1, B:171:0x03cf, B:173:0x03d6, B:177:0x03e8, B:179:0x046e, B:180:0x0470, B:182:0x047c, B:185:0x0486, B:187:0x04d6, B:186:0x04af, B:188:0x04e0, B:191:0x04ec, B:193:0x04f4, B:194:0x04fa, B:196:0x0500, B:198:0x050a, B:200:0x050e, B:201:0x0511, B:202:0x0514, B:203:0x051a, B:205:0x0520, B:208:0x0540, B:209:0x054d, B:211:0x0553, B:214:0x0560, B:217:0x0574, B:219:0x057b, B:223:0x0587, B:225:0x058f, B:228:0x05a6, B:230:0x05ac, B:234:0x05c4, B:239:0x05cf, B:241:0x05d6, B:243:0x05e6, B:245:0x05ee, B:247:0x0623, B:246:0x05fb, B:249:0x062a, B:252:0x063a, B:53:0x0111, B:21:0x0080), top: B:257:0x0012 }] */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r24v0, types: [java.util.ArrayList, java.util.ArrayList<java.lang.Object>] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void localSearch(int r22, java.lang.String r23, java.util.ArrayList<java.lang.Object> r24, java.util.ArrayList<java.lang.CharSequence> r25, java.util.ArrayList<org.rbmain.tgnet.TLRPC$User> r26, int r27) {
        /*
            Method dump skipped, instructions count: 1603
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.MessagesStorage.localSearch(int, java.lang.String, java.util.ArrayList, java.util.ArrayList, java.util.ArrayList, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$localSearch$155(DialogsSearchAdapter.DialogSearchResult dialogSearchResult, DialogsSearchAdapter.DialogSearchResult dialogSearchResult2) {
        int i = dialogSearchResult.date;
        int i2 = dialogSearchResult2.date;
        if (i < i2) {
            return 1;
        }
        return i > i2 ? -1 : 0;
    }

    public void markMessageReactionsAsRead(final long j, final int i, final long j2, boolean z) {
        if (z) {
            getStorageQueue().postRunnable(new Runnable() { // from class: org.rbmain.messenger.MessagesStorage$$ExternalSyntheticLambda64
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$markMessageReactionsAsRead$156(j, i, j2);
                }
            });
        } else {
            lambda$markMessageReactionsAsRead$156(j, i, j2);
        }
    }
}
