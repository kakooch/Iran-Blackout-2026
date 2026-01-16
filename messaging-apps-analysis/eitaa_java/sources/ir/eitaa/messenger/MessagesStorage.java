package ir.eitaa.messenger;

import android.appwidget.AppWidgetManager;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseIntArray;
import androidx.collection.LongSparseArray;
import ir.eitaa.SQLite.SQLiteCursor;
import ir.eitaa.SQLite.SQLiteDatabase;
import ir.eitaa.SQLite.SQLiteException;
import ir.eitaa.SQLite.SQLitePreparedStatement;
import ir.eitaa.messenger.ContactsController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.support.LongSparseIntArray;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.NativeByteBuffer;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$ChannelParticipant;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$ChatFull;
import ir.eitaa.tgnet.TLRPC$ChatParticipant;
import ir.eitaa.tgnet.TLRPC$ChatParticipants;
import ir.eitaa.tgnet.TLRPC$Dialog;
import ir.eitaa.tgnet.TLRPC$Document;
import ir.eitaa.tgnet.TLRPC$DraftMessage;
import ir.eitaa.tgnet.TLRPC$EncryptedChat;
import ir.eitaa.tgnet.TLRPC$InputChannel;
import ir.eitaa.tgnet.TLRPC$InputDialogPeer;
import ir.eitaa.tgnet.TLRPC$InputMedia;
import ir.eitaa.tgnet.TLRPC$InputPeer;
import ir.eitaa.tgnet.TLRPC$Message;
import ir.eitaa.tgnet.TLRPC$MessageAction;
import ir.eitaa.tgnet.TLRPC$MessageEntity;
import ir.eitaa.tgnet.TLRPC$MessageFwdHeader;
import ir.eitaa.tgnet.TLRPC$MessageMedia;
import ir.eitaa.tgnet.TLRPC$MessageReplies;
import ir.eitaa.tgnet.TLRPC$Peer;
import ir.eitaa.tgnet.TLRPC$Photo;
import ir.eitaa.tgnet.TLRPC$PhotoSize;
import ir.eitaa.tgnet.TLRPC$Poll;
import ir.eitaa.tgnet.TLRPC$PollResults;
import ir.eitaa.tgnet.TLRPC$ReplyMarkup;
import ir.eitaa.tgnet.TLRPC$TL_channelFull;
import ir.eitaa.tgnet.TLRPC$TL_channels_deleteMessages;
import ir.eitaa.tgnet.TLRPC$TL_chatAdminRights;
import ir.eitaa.tgnet.TLRPC$TL_chatBannedRights;
import ir.eitaa.tgnet.TLRPC$TL_chatFull;
import ir.eitaa.tgnet.TLRPC$TL_chatParticipant;
import ir.eitaa.tgnet.TLRPC$TL_chatParticipantAdmin;
import ir.eitaa.tgnet.TLRPC$TL_contact;
import ir.eitaa.tgnet.TLRPC$TL_dialog;
import ir.eitaa.tgnet.TLRPC$TL_dialogFilter;
import ir.eitaa.tgnet.TLRPC$TL_dialogFolder;
import ir.eitaa.tgnet.TLRPC$TL_documentEmpty;
import ir.eitaa.tgnet.TLRPC$TL_folder;
import ir.eitaa.tgnet.TLRPC$TL_folderPeer;
import ir.eitaa.tgnet.TLRPC$TL_inputFolderPeer;
import ir.eitaa.tgnet.TLRPC$TL_inputMediaGame;
import ir.eitaa.tgnet.TLRPC$TL_inputMessageEntityMentionName;
import ir.eitaa.tgnet.TLRPC$TL_message;
import ir.eitaa.tgnet.TLRPC$TL_messageActionChatAddUser;
import ir.eitaa.tgnet.TLRPC$TL_messageActionGeoProximityReached;
import ir.eitaa.tgnet.TLRPC$TL_messageEntityMentionName;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaDocument;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaLiveStream;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaPhoto;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaPoll;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaUnsupported;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaUnsupported_old;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaWebPage;
import ir.eitaa.tgnet.TLRPC$TL_messageReactions;
import ir.eitaa.tgnet.TLRPC$TL_messageReplies;
import ir.eitaa.tgnet.TLRPC$TL_messageReplyHeader;
import ir.eitaa.tgnet.TLRPC$TL_message_secret;
import ir.eitaa.tgnet.TLRPC$TL_messages_botCallbackAnswer;
import ir.eitaa.tgnet.TLRPC$TL_messages_botResults;
import ir.eitaa.tgnet.TLRPC$TL_messages_deleteMessages;
import ir.eitaa.tgnet.TLRPC$TL_messages_deleteScheduledMessages;
import ir.eitaa.tgnet.TLRPC$TL_messages_dialogs;
import ir.eitaa.tgnet.TLRPC$TL_messages_messages;
import ir.eitaa.tgnet.TLRPC$TL_peerChannel;
import ir.eitaa.tgnet.TLRPC$TL_peerChat;
import ir.eitaa.tgnet.TLRPC$TL_peerNotifySettingsEmpty_layer77;
import ir.eitaa.tgnet.TLRPC$TL_peerUser;
import ir.eitaa.tgnet.TLRPC$TL_photoEmpty;
import ir.eitaa.tgnet.TLRPC$TL_photos_photos;
import ir.eitaa.tgnet.TLRPC$TL_replyInlineMarkup;
import ir.eitaa.tgnet.TLRPC$TL_restrictionReason;
import ir.eitaa.tgnet.TLRPC$TL_updates;
import ir.eitaa.tgnet.TLRPC$TL_updates_channelDifferenceTooLong;
import ir.eitaa.tgnet.TLRPC$TL_userStatusLastMonth;
import ir.eitaa.tgnet.TLRPC$TL_userStatusLastWeek;
import ir.eitaa.tgnet.TLRPC$TL_userStatusRecently;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.tgnet.TLRPC$UserFull;
import ir.eitaa.tgnet.TLRPC$UserProfilePhoto;
import ir.eitaa.tgnet.TLRPC$UserStatus;
import ir.eitaa.tgnet.TLRPC$Vector;
import ir.eitaa.tgnet.TLRPC$WallPaper;
import ir.eitaa.tgnet.TLRPC$WebPage;
import ir.eitaa.tgnet.TLRPC$messages_Dialogs;
import ir.eitaa.tgnet.TLRPC$messages_Messages;
import ir.eitaa.tgnet.TLRPC$photos_Photos;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Adapters.DialogsSearchAdapter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;
import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
public class MessagesStorage extends BaseController {
    private static volatile MessagesStorage[] Instance = new MessagesStorage[3];
    private static final int LAST_DB_VERSION = 84;
    private int[][] admin;
    private int archiveUnreadCount;
    private int[][] bots;
    private File cacheFile;
    private int[][] channels;
    private int[][] contacts;
    private SQLiteDatabase database;
    private boolean databaseMigrationInProgress;
    private ArrayList<MessagesController.DialogFilter> dialogFilters;
    private SparseArray<MessagesController.DialogFilter> dialogFiltersMap;
    private LongSparseArray<Integer> dialogsWithMentions;
    private LongSparseArray<Integer> dialogsWithUnread;
    private int[][] favorite;
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
    private int[][] media_channel;
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
        void run(boolean param);
    }

    public interface IntCallback {
        void run(int param);
    }

    public interface LongCallback {
        void run(long param);
    }

    public interface StringCallback {
        void run(String param);
    }

    public static MessagesStorage getInstance(int num) {
        MessagesStorage messagesStorage = Instance[num];
        if (messagesStorage == null) {
            synchronized (MessagesStorage.class) {
                messagesStorage = Instance[num];
                if (messagesStorage == null) {
                    MessagesStorage[] messagesStorageArr = Instance;
                    MessagesStorage messagesStorage2 = new MessagesStorage(num);
                    messagesStorageArr[num] = messagesStorage2;
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

    public void setLastDateValue(int value) {
        ensureOpened();
        this.lastDateValue = value;
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

    public void setLastPtsValue(int value) {
        ensureOpened();
        this.lastPtsValue = value;
    }

    public int getLastQtsValue() {
        ensureOpened();
        return this.lastQtsValue;
    }

    public void setLastQtsValue(int value) {
        ensureOpened();
        this.lastQtsValue = value;
    }

    public int getLastSeqValue() {
        ensureOpened();
        return this.lastSeqValue;
    }

    public void setLastSeqValue(int value) {
        ensureOpened();
        this.lastSeqValue = value;
    }

    public int getLastSecretVersion() {
        ensureOpened();
        return this.lastSecretVersion;
    }

    public void setLastSecretVersion(int value) {
        ensureOpened();
        this.lastSecretVersion = value;
    }

    public byte[] getSecretPBytes() {
        ensureOpened();
        return this.secretPBytes;
    }

    public void setSecretPBytes(byte[] value) {
        ensureOpened();
        this.secretPBytes = value;
    }

    public int getSecretG() {
        ensureOpened();
        return this.secretG;
    }

    public void setSecretG(int value) {
        ensureOpened();
        this.secretG = value;
    }

    public MessagesStorage(int instance) {
        super(instance);
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
        this.favorite = new int[][]{new int[2], new int[2]};
        this.admin = new int[][]{new int[2], new int[2]};
        this.media_channel = new int[][]{new int[2], new int[2]};
        this.mentionChannels = new int[2];
        this.mentionGroups = new int[2];
        this.dialogsWithMentions = new LongSparseArray<>();
        this.dialogsWithUnread = new LongSparseArray<>();
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$j8NRqwafe5Pk7Wx_EoPx31F5K3g
            @Override // java.lang.Runnable
            public final void run() throws Exception {
                this.f$0.lambda$new$0$MessagesStorage();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$MessagesStorage() throws Exception {
        openDatabase(1);
    }

    public SQLiteDatabase getDatabase() {
        return this.database;
    }

    public DispatchQueue getStorageQueue() {
        return this.storageQueue;
    }

    public void bindTaskToGuid(Runnable task, int guid) {
        ArrayList<Runnable> arrayList = this.tasks.get(guid);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.tasks.put(guid, arrayList);
        }
        arrayList.add(task);
    }

    public void cancelTasksForGuid(int guid) throws InterruptedException {
        ArrayList<Runnable> arrayList = this.tasks.get(guid);
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            this.storageQueue.cancelRunnable(arrayList.get(i));
        }
        this.tasks.remove(guid);
    }

    public void completeTaskForGuid(Runnable runnable, int guid) {
        ArrayList<Runnable> arrayList = this.tasks.get(guid);
        if (arrayList == null) {
            return;
        }
        arrayList.remove(runnable);
        if (arrayList.isEmpty()) {
            this.tasks.remove(guid);
        }
    }

    public long getDatabaseSize() {
        File file = this.cacheFile;
        long length = file != null ? 0 + file.length() : 0L;
        File file2 = this.shmCacheFile;
        return file2 != null ? length + file2.length() : length;
    }

    public void openDatabase(int openTries) throws Exception {
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
                this.database.executeFast("CREATE TABLE scheduled_messages_v2(mid INTEGER, uid INTEGER, send_state INTEGER, date INTEGER, data BLOB, ttl INTEGER, replydata BLOB, PRIMARY KEY(mid, uid))").stepThis().dispose();
                this.database.executeFast("CREATE INDEX IF NOT EXISTS send_state_idx_scheduled_messages_v2 ON scheduled_messages_v2(mid, send_state, date);").stepThis().dispose();
                this.database.executeFast("CREATE INDEX IF NOT EXISTS uid_date_idx_scheduled_messages_v2 ON scheduled_messages_v2(uid, date);").stepThis().dispose();
                this.database.executeFast("CREATE TABLE messages_v2(mid INTEGER, uid INTEGER, read_state INTEGER, send_state INTEGER, date INTEGER, data BLOB, out INTEGER, ttl INTEGER, media INTEGER, replydata BLOB, imp INTEGER, mention INTEGER, forwards INTEGER, replies_data BLOB, thread_reply_id INTEGER, is_channel INTEGER, PRIMARY KEY(mid, uid))").stepThis().dispose();
                this.database.executeFast("CREATE INDEX IF NOT EXISTS uid_mid_read_out_idx_messages_v2 ON messages_v2(uid, mid, read_state, out);").stepThis().dispose();
                this.database.executeFast("CREATE INDEX IF NOT EXISTS uid_date_mid_idx_messages_v2 ON messages_v2(uid, date, mid);").stepThis().dispose();
                this.database.executeFast("CREATE INDEX IF NOT EXISTS mid_out_idx_messages_v2 ON messages_v2(mid, out);").stepThis().dispose();
                this.database.executeFast("CREATE INDEX IF NOT EXISTS task_idx_messages_v2 ON messages_v2(uid, out, read_state, ttl, date, send_state);").stepThis().dispose();
                this.database.executeFast("CREATE INDEX IF NOT EXISTS send_state_idx_messages_v2 ON messages_v2(mid, send_state, date);").stepThis().dispose();
                this.database.executeFast("CREATE INDEX IF NOT EXISTS uid_mention_idx_messages_v2 ON messages_v2(uid, mention, read_state);").stepThis().dispose();
                this.database.executeFast("CREATE INDEX IF NOT EXISTS is_channel_idx_messages_v2 ON messages_v2(mid, is_channel);").stepThis().dispose();
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
                this.database.executeFast("CREATE TABLE randoms_v2(random_id INTEGER, mid INTEGER, uid INTEGER, PRIMARY KEY (random_id, mid, uid))").stepThis().dispose();
                this.database.executeFast("CREATE INDEX IF NOT EXISTS mid_idx_randoms_v2 ON randoms_v2(mid, uid);").stepThis().dispose();
                this.database.executeFast("CREATE TABLE enc_tasks_v4(mid INTEGER, uid INTEGER, date INTEGER, media INTEGER, PRIMARY KEY(mid, uid, media))").stepThis().dispose();
                this.database.executeFast("CREATE INDEX IF NOT EXISTS date_idx_enc_tasks_v4 ON enc_tasks_v4(date);").stepThis().dispose();
                this.database.executeFast("CREATE TABLE messages_seq(mid INTEGER PRIMARY KEY, seq_in INTEGER, seq_out INTEGER);").stepThis().dispose();
                this.database.executeFast("CREATE INDEX IF NOT EXISTS seq_idx_messages_seq ON messages_seq(seq_in, seq_out);").stepThis().dispose();
                this.database.executeFast("CREATE TABLE params(id INTEGER PRIMARY KEY, seq INTEGER, pts INTEGER, date INTEGER, qts INTEGER, lsv INTEGER, sg INTEGER, pbytes BLOB)").stepThis().dispose();
                this.database.executeFast("INSERT INTO params VALUES(1, 0, 0, 0, 0, 0, 0, NULL)").stepThis().dispose();
                this.database.executeFast("CREATE TABLE media_v3(mid INTEGER, uid INTEGER, date INTEGER, type INTEGER, data BLOB, PRIMARY KEY(mid, uid))").stepThis().dispose();
                this.database.executeFast("CREATE INDEX IF NOT EXISTS uid_mid_type_date_idx_media_v3 ON media_v3(uid, mid, type, date);").stepThis().dispose();
                this.database.executeFast("CREATE TABLE bot_keyboard(uid INTEGER PRIMARY KEY, mid INTEGER, info BLOB)").stepThis().dispose();
                this.database.executeFast("CREATE INDEX IF NOT EXISTS bot_keyboard_idx_mid_v2 ON bot_keyboard(mid, uid);").stepThis().dispose();
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
                this.database.executeFast("CREATE TABLE webpage_pending_v2(id INTEGER, mid INTEGER, uid INTEGER, PRIMARY KEY (id, mid, uid));").stepThis().dispose();
                this.database.executeFast("CREATE TABLE sent_files_v2(uid TEXT, type INTEGER, data BLOB, parent TEXT, PRIMARY KEY (uid, type))").stepThis().dispose();
                this.database.executeFast("CREATE TABLE search_recent(did INTEGER PRIMARY KEY, date INTEGER);").stepThis().dispose();
                this.database.executeFast("CREATE TABLE media_counts_v2(uid INTEGER, type INTEGER, count INTEGER, old INTEGER, PRIMARY KEY(uid, type))").stepThis().dispose();
                this.database.executeFast("CREATE TABLE keyvalue(id TEXT PRIMARY KEY, value TEXT)").stepThis().dispose();
                this.database.executeFast("CREATE TABLE bot_info_v2(uid INTEGER, dialogId INTEGER, info BLOB, PRIMARY KEY(uid, dialogId))").stepThis().dispose();
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
                this.database.executeFast("CREATE TABLE polls_v2(mid INTEGER, uid INTEGER, id INTEGER, PRIMARY KEY (mid, uid));").stepThis().dispose();
                this.database.executeFast("CREATE INDEX IF NOT EXISTS polls_id_v2 ON polls_v2(id);").stepThis().dispose();
                this.database.executeFast("PRAGMA user_version = 84").stepThis().dispose();
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
                if (iIntValue < 84) {
                    try {
                        updateDbToLastVersion(iIntValue);
                    } catch (Exception e3) {
                        FileLog.e(e3);
                        throw new RuntimeException("malformed");
                    }
                }
            }
        } catch (Exception e4) {
            FileLog.e(e4);
            if (openTries < 3 && e4.getMessage() != null && e4.getMessage().contains("malformed")) {
                if (openTries == 2) {
                    cleanupInternal(true);
                    for (int i = 0; i < 2; i++) {
                        getUserConfig().setDialogsLoadOffset(i, 0, 0, 0L, 0L, 0L, 0L);
                        getUserConfig().setTotalDialogsCount(i, 0);
                    }
                    getUserConfig().saveConfig(false);
                } else {
                    cleanupInternal(false);
                }
                openDatabase(openTries == 1 ? 2 : 3);
            }
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$CE5Mz8WxUMNd5QunRdpo6GbvaUw
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$openDatabase$1$MessagesStorage();
            }
        });
        loadDialogFilters();
        loadUnreadMessages();
        loadPendingTasks();
        try {
            this.openSync.countDown();
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$openDatabase$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$openDatabase$1$MessagesStorage() {
        if (this.databaseMigrationInProgress) {
            this.databaseMigrationInProgress = false;
            NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.onDatabaseMigration, Boolean.FALSE);
        }
    }

    public boolean isDatabaseMigrationInProgress() {
        return this.databaseMigrationInProgress;
    }

    private void updateDbToLastVersion(int currentVersion) throws Exception {
        SQLiteCursor sQLiteCursorQueryFinalized;
        int i;
        int i2;
        NativeByteBuffer nativeByteBuffer;
        SQLiteCursor sQLiteCursorQueryFinalized2;
        SQLiteCursor sQLiteCursorQueryFinalized3;
        SQLiteCursor sQLiteCursorQueryFinalized4;
        SQLiteCursor sQLiteCursorQueryFinalized5;
        SQLiteCursor sQLiteCursorQueryFinalized6;
        SQLiteCursor sQLiteCursorQueryFinalized7;
        final MessagesStorage messagesStorage = this;
        int i3 = currentVersion;
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$Yenie8ICEeMHbyKSsu-guP7Om9o
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateDbToLastVersion$2$MessagesStorage();
            }
        });
        FileLog.d("MessagesStorage start db migration from " + i3 + " to 84");
        int i4 = 4;
        if (i3 < 4) {
            messagesStorage.database.executeFast("CREATE TABLE IF NOT EXISTS user_photos(uid INTEGER, id INTEGER, data BLOB, PRIMARY KEY (uid, id))").stepThis().dispose();
            messagesStorage.database.executeFast("DROP INDEX IF EXISTS read_state_out_idx_messages;").stepThis().dispose();
            messagesStorage.database.executeFast("DROP INDEX IF EXISTS ttl_idx_messages;").stepThis().dispose();
            messagesStorage.database.executeFast("DROP INDEX IF EXISTS date_idx_messages;").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE INDEX IF NOT EXISTS mid_out_idx_messages ON messages(mid, out);").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE INDEX IF NOT EXISTS task_idx_messages ON messages(uid, out, read_state, ttl, date, send_state);").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE INDEX IF NOT EXISTS uid_date_mid_idx_messages ON messages(uid, date, mid);").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE TABLE IF NOT EXISTS user_contacts_v6(uid INTEGER PRIMARY KEY, fname TEXT, sname TEXT)").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE TABLE IF NOT EXISTS user_phones_v6(uid INTEGER, phone TEXT, sphone TEXT, deleted INTEGER, PRIMARY KEY (uid, phone))").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE INDEX IF NOT EXISTS sphone_deleted_idx_user_phones ON user_phones_v6(sphone, deleted);").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE INDEX IF NOT EXISTS mid_idx_randoms ON randoms(mid);").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE TABLE IF NOT EXISTS sent_files_v2(uid TEXT, type INTEGER, data BLOB, PRIMARY KEY (uid, type))").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE TABLE IF NOT EXISTS download_queue(uid INTEGER, type INTEGER, date INTEGER, data BLOB, PRIMARY KEY (uid, type));").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE INDEX IF NOT EXISTS type_date_idx_download_queue ON download_queue(type, date);").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE TABLE IF NOT EXISTS dialog_settings(did INTEGER PRIMARY KEY, flags INTEGER);").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE INDEX IF NOT EXISTS unread_count_idx_dialogs ON dialogs(unread_count);").stepThis().dispose();
            messagesStorage.database.executeFast("UPDATE messages SET send_state = 2 WHERE mid < 0 AND send_state = 1").stepThis().dispose();
            fixNotificationSettings();
            messagesStorage.database.executeFast("PRAGMA user_version = 4").stepThis().dispose();
            i3 = 4;
        }
        int i5 = 6;
        int i6 = 2;
        int i7 = 1;
        int i8 = 0;
        if (i3 == 4) {
            messagesStorage.database.executeFast("CREATE TABLE IF NOT EXISTS enc_tasks_v2(mid INTEGER PRIMARY KEY, date INTEGER)").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE INDEX IF NOT EXISTS date_idx_enc_tasks_v2 ON enc_tasks_v2(date);").stepThis().dispose();
            messagesStorage.database.beginTransaction();
            SQLiteCursor sQLiteCursorQueryFinalized8 = messagesStorage.database.queryFinalized("SELECT date, data FROM enc_tasks WHERE 1", new Object[0]);
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = messagesStorage.database.executeFast("REPLACE INTO enc_tasks_v2 VALUES(?, ?)");
            if (sQLiteCursorQueryFinalized8.next()) {
                int iIntValue = sQLiteCursorQueryFinalized8.intValue(0);
                NativeByteBuffer nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized8.byteBufferValue(1);
                if (nativeByteBufferByteBufferValue != null) {
                    int iLimit = nativeByteBufferByteBufferValue.limit();
                    for (int i9 = 0; i9 < iLimit / 4; i9++) {
                        sQLitePreparedStatementExecuteFast.requery();
                        sQLitePreparedStatementExecuteFast.bindInteger(1, nativeByteBufferByteBufferValue.readInt32(false));
                        sQLitePreparedStatementExecuteFast.bindInteger(2, iIntValue);
                        sQLitePreparedStatementExecuteFast.step();
                    }
                    nativeByteBufferByteBufferValue.reuse();
                }
            }
            sQLitePreparedStatementExecuteFast.dispose();
            sQLiteCursorQueryFinalized8.dispose();
            messagesStorage.database.commitTransaction();
            messagesStorage.database.executeFast("DROP INDEX IF EXISTS date_idx_enc_tasks;").stepThis().dispose();
            messagesStorage.database.executeFast("DROP TABLE IF EXISTS enc_tasks;").stepThis().dispose();
            messagesStorage.database.executeFast("ALTER TABLE messages ADD COLUMN media INTEGER default 0").stepThis().dispose();
            messagesStorage.database.executeFast("PRAGMA user_version = 6").stepThis().dispose();
            i3 = 6;
        }
        if (i3 == 6) {
            messagesStorage.database.executeFast("CREATE TABLE IF NOT EXISTS messages_seq(mid INTEGER PRIMARY KEY, seq_in INTEGER, seq_out INTEGER);").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE INDEX IF NOT EXISTS seq_idx_messages_seq ON messages_seq(seq_in, seq_out);").stepThis().dispose();
            messagesStorage.database.executeFast("ALTER TABLE enc_chats ADD COLUMN layer INTEGER default 0").stepThis().dispose();
            messagesStorage.database.executeFast("ALTER TABLE enc_chats ADD COLUMN seq_in INTEGER default 0").stepThis().dispose();
            messagesStorage.database.executeFast("ALTER TABLE enc_chats ADD COLUMN seq_out INTEGER default 0").stepThis().dispose();
            messagesStorage.database.executeFast("PRAGMA user_version = 7").stepThis().dispose();
            i3 = 7;
        }
        if (i3 == 7 || i3 == 8 || i3 == 9) {
            messagesStorage.database.executeFast("ALTER TABLE enc_chats ADD COLUMN use_count INTEGER default 0").stepThis().dispose();
            messagesStorage.database.executeFast("ALTER TABLE enc_chats ADD COLUMN exchange_id INTEGER default 0").stepThis().dispose();
            messagesStorage.database.executeFast("ALTER TABLE enc_chats ADD COLUMN key_date INTEGER default 0").stepThis().dispose();
            messagesStorage.database.executeFast("ALTER TABLE enc_chats ADD COLUMN fprint INTEGER default 0").stepThis().dispose();
            messagesStorage.database.executeFast("ALTER TABLE enc_chats ADD COLUMN fauthkey BLOB default NULL").stepThis().dispose();
            messagesStorage.database.executeFast("ALTER TABLE enc_chats ADD COLUMN khash BLOB default NULL").stepThis().dispose();
            messagesStorage.database.executeFast("PRAGMA user_version = 10").stepThis().dispose();
            i3 = 10;
        }
        if (i3 == 10) {
            messagesStorage.database.executeFast("CREATE TABLE IF NOT EXISTS web_recent_v3(id TEXT, type INTEGER, image_url TEXT, thumb_url TEXT, local_url TEXT, width INTEGER, height INTEGER, size INTEGER, date INTEGER, PRIMARY KEY (id, type));").stepThis().dispose();
            messagesStorage.database.executeFast("PRAGMA user_version = 11").stepThis().dispose();
            i3 = 11;
        }
        if (i3 == 11 || i3 == 12) {
            messagesStorage.database.executeFast("DROP INDEX IF EXISTS uid_mid_idx_media;").stepThis().dispose();
            messagesStorage.database.executeFast("DROP INDEX IF EXISTS mid_idx_media;").stepThis().dispose();
            messagesStorage.database.executeFast("DROP INDEX IF EXISTS uid_date_mid_idx_media;").stepThis().dispose();
            messagesStorage.database.executeFast("DROP TABLE IF EXISTS media;").stepThis().dispose();
            messagesStorage.database.executeFast("DROP TABLE IF EXISTS media_counts;").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE TABLE IF NOT EXISTS media_v2(mid INTEGER PRIMARY KEY, uid INTEGER, date INTEGER, type INTEGER, data BLOB)").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE TABLE IF NOT EXISTS media_counts_v2(uid INTEGER, type INTEGER, count INTEGER, PRIMARY KEY(uid, type))").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE INDEX IF NOT EXISTS uid_mid_type_date_idx_media ON media_v2(uid, mid, type, date);").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE TABLE IF NOT EXISTS keyvalue(id TEXT PRIMARY KEY, value TEXT)").stepThis().dispose();
            messagesStorage.database.executeFast("PRAGMA user_version = 13").stepThis().dispose();
            i3 = 13;
        }
        if (i3 == 13) {
            messagesStorage.database.executeFast("ALTER TABLE messages ADD COLUMN replydata BLOB default NULL").stepThis().dispose();
            messagesStorage.database.executeFast("PRAGMA user_version = 14").stepThis().dispose();
            i3 = 14;
        }
        if (i3 == 14) {
            messagesStorage.database.executeFast("CREATE TABLE IF NOT EXISTS hashtag_recent_v2(id TEXT PRIMARY KEY, date INTEGER);").stepThis().dispose();
            messagesStorage.database.executeFast("PRAGMA user_version = 15").stepThis().dispose();
            i3 = 15;
        }
        if (i3 == 15) {
            messagesStorage.database.executeFast("CREATE TABLE IF NOT EXISTS webpage_pending(id INTEGER, mid INTEGER, PRIMARY KEY (id, mid));").stepThis().dispose();
            messagesStorage.database.executeFast("PRAGMA user_version = 16").stepThis().dispose();
            i3 = 16;
        }
        if (i3 == 16) {
            messagesStorage.database.executeFast("ALTER TABLE dialogs ADD COLUMN inbox_max INTEGER default 0").stepThis().dispose();
            messagesStorage.database.executeFast("ALTER TABLE dialogs ADD COLUMN outbox_max INTEGER default 0").stepThis().dispose();
            messagesStorage.database.executeFast("PRAGMA user_version = 17").stepThis().dispose();
            i3 = 17;
        }
        if (i3 == 17) {
            messagesStorage.database.executeFast("PRAGMA user_version = 18").stepThis().dispose();
            i3 = 18;
        }
        if (i3 == 18) {
            messagesStorage.database.executeFast("DROP TABLE IF EXISTS stickers;").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE TABLE IF NOT EXISTS stickers_v2(id INTEGER PRIMARY KEY, data BLOB, date INTEGER, hash INTEGER);").stepThis().dispose();
            messagesStorage.database.executeFast("PRAGMA user_version = 19").stepThis().dispose();
            i3 = 19;
        }
        if (i3 == 19) {
            messagesStorage.database.executeFast("CREATE TABLE IF NOT EXISTS bot_keyboard(uid INTEGER PRIMARY KEY, mid INTEGER, info BLOB)").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE INDEX IF NOT EXISTS bot_keyboard_idx_mid ON bot_keyboard(mid);").stepThis().dispose();
            messagesStorage.database.executeFast("PRAGMA user_version = 20").stepThis().dispose();
            i3 = 20;
        }
        if (i3 == 20) {
            messagesStorage.database.executeFast("CREATE TABLE search_recent(did INTEGER PRIMARY KEY, date INTEGER);").stepThis().dispose();
            messagesStorage.database.executeFast("PRAGMA user_version = 21").stepThis().dispose();
            i3 = 21;
        }
        if (i3 == 21) {
            messagesStorage.database.executeFast("CREATE TABLE IF NOT EXISTS chat_settings_v2(uid INTEGER PRIMARY KEY, info BLOB)").stepThis().dispose();
            SQLiteCursor sQLiteCursorQueryFinalized9 = messagesStorage.database.queryFinalized("SELECT uid, participants FROM chat_settings WHERE uid < 0", new Object[0]);
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast2 = messagesStorage.database.executeFast("REPLACE INTO chat_settings_v2 VALUES(?, ?)");
            while (sQLiteCursorQueryFinalized9.next()) {
                long jIntValue = sQLiteCursorQueryFinalized9.intValue(0);
                NativeByteBuffer nativeByteBufferByteBufferValue2 = sQLiteCursorQueryFinalized9.byteBufferValue(1);
                if (nativeByteBufferByteBufferValue2 != null) {
                    TLRPC$ChatParticipants tLRPC$ChatParticipantsTLdeserialize = TLRPC$ChatParticipants.TLdeserialize(nativeByteBufferByteBufferValue2, nativeByteBufferByteBufferValue2.readInt32(false), false);
                    nativeByteBufferByteBufferValue2.reuse();
                    if (tLRPC$ChatParticipantsTLdeserialize != null) {
                        TLRPC$TL_chatFull tLRPC$TL_chatFull = new TLRPC$TL_chatFull();
                        tLRPC$TL_chatFull.id = jIntValue;
                        tLRPC$TL_chatFull.chat_photo = new TLRPC$TL_photoEmpty();
                        tLRPC$TL_chatFull.notify_settings = new TLRPC$TL_peerNotifySettingsEmpty_layer77();
                        tLRPC$TL_chatFull.exported_invite = null;
                        tLRPC$TL_chatFull.participants = tLRPC$ChatParticipantsTLdeserialize;
                        NativeByteBuffer nativeByteBuffer2 = new NativeByteBuffer(tLRPC$TL_chatFull.getObjectSize());
                        tLRPC$TL_chatFull.serializeToStream(nativeByteBuffer2);
                        sQLitePreparedStatementExecuteFast2.requery();
                        sQLitePreparedStatementExecuteFast2.bindLong(1, jIntValue);
                        sQLitePreparedStatementExecuteFast2.bindByteBuffer(2, nativeByteBuffer2);
                        sQLitePreparedStatementExecuteFast2.step();
                        nativeByteBuffer2.reuse();
                    }
                }
            }
            sQLitePreparedStatementExecuteFast2.dispose();
            sQLiteCursorQueryFinalized9.dispose();
            messagesStorage.database.executeFast("DROP TABLE IF EXISTS chat_settings;").stepThis().dispose();
            messagesStorage.database.executeFast("ALTER TABLE dialogs ADD COLUMN last_mid_i INTEGER default 0").stepThis().dispose();
            messagesStorage.database.executeFast("ALTER TABLE dialogs ADD COLUMN unread_count_i INTEGER default 0").stepThis().dispose();
            messagesStorage.database.executeFast("ALTER TABLE dialogs ADD COLUMN pts INTEGER default 0").stepThis().dispose();
            messagesStorage.database.executeFast("ALTER TABLE dialogs ADD COLUMN date_i INTEGER default 0").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE INDEX IF NOT EXISTS last_mid_i_idx_dialogs ON dialogs(last_mid_i);").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE INDEX IF NOT EXISTS unread_count_i_idx_dialogs ON dialogs(unread_count_i);").stepThis().dispose();
            messagesStorage.database.executeFast("ALTER TABLE messages ADD COLUMN imp INTEGER default 0").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE TABLE IF NOT EXISTS messages_holes(uid INTEGER, start INTEGER, end INTEGER, PRIMARY KEY(uid, start));").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE INDEX IF NOT EXISTS uid_end_messages_holes ON messages_holes(uid, end);").stepThis().dispose();
            messagesStorage.database.executeFast("PRAGMA user_version = 22").stepThis().dispose();
            i3 = 22;
        }
        if (i3 == 22) {
            messagesStorage.database.executeFast("CREATE TABLE IF NOT EXISTS media_holes_v2(uid INTEGER, type INTEGER, start INTEGER, end INTEGER, PRIMARY KEY(uid, type, start));").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE INDEX IF NOT EXISTS uid_end_media_holes_v2 ON media_holes_v2(uid, type, end);").stepThis().dispose();
            messagesStorage.database.executeFast("PRAGMA user_version = 23").stepThis().dispose();
            i3 = 23;
        }
        if (i3 == 23 || i3 == 24) {
            messagesStorage.database.executeFast("DELETE FROM media_holes_v2 WHERE uid != 0 AND type >= 0 AND start IN (0, 1)").stepThis().dispose();
            messagesStorage.database.executeFast("PRAGMA user_version = 25").stepThis().dispose();
            i3 = 25;
        }
        if (i3 == 25 || i3 == 26) {
            messagesStorage.database.executeFast("CREATE TABLE IF NOT EXISTS channel_users_v2(did INTEGER, uid INTEGER, date INTEGER, data BLOB, PRIMARY KEY(did, uid))").stepThis().dispose();
            messagesStorage.database.executeFast("PRAGMA user_version = 27").stepThis().dispose();
            i3 = 27;
        }
        if (i3 == 27) {
            messagesStorage.database.executeFast("ALTER TABLE web_recent_v3 ADD COLUMN document BLOB default NULL").stepThis().dispose();
            messagesStorage.database.executeFast("PRAGMA user_version = 28").stepThis().dispose();
            i3 = 28;
        }
        if (i3 == 28 || i3 == 29) {
            messagesStorage.database.executeFast("DELETE FROM sent_files_v2 WHERE 1").stepThis().dispose();
            messagesStorage.database.executeFast("DELETE FROM download_queue WHERE 1").stepThis().dispose();
            messagesStorage.database.executeFast("PRAGMA user_version = 30").stepThis().dispose();
            i3 = 30;
        }
        if (i3 == 30) {
            messagesStorage.database.executeFast("ALTER TABLE chat_settings_v2 ADD COLUMN pinned INTEGER default 0").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE INDEX IF NOT EXISTS chat_settings_pinned_idx ON chat_settings_v2(uid, pinned) WHERE pinned != 0;").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE TABLE IF NOT EXISTS users_data(uid INTEGER PRIMARY KEY, about TEXT)").stepThis().dispose();
            messagesStorage.database.executeFast("PRAGMA user_version = 31").stepThis().dispose();
            i3 = 31;
        }
        if (i3 == 31) {
            messagesStorage.database.executeFast("DROP TABLE IF EXISTS bot_recent;").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE TABLE IF NOT EXISTS chat_hints(did INTEGER, type INTEGER, rating REAL, date INTEGER, PRIMARY KEY(did, type))").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE INDEX IF NOT EXISTS chat_hints_rating_idx ON chat_hints(rating);").stepThis().dispose();
            messagesStorage.database.executeFast("PRAGMA user_version = 32").stepThis().dispose();
            i3 = 32;
        }
        if (i3 == 32) {
            messagesStorage.database.executeFast("DROP INDEX IF EXISTS uid_mid_idx_imp_messages;").stepThis().dispose();
            messagesStorage.database.executeFast("DROP INDEX IF EXISTS uid_date_mid_imp_idx_messages;").stepThis().dispose();
            messagesStorage.database.executeFast("PRAGMA user_version = 33").stepThis().dispose();
            i3 = 33;
        }
        if (i3 == 33) {
            messagesStorage.database.executeFast("CREATE TABLE IF NOT EXISTS pending_tasks(id INTEGER PRIMARY KEY, data BLOB);").stepThis().dispose();
            messagesStorage.database.executeFast("PRAGMA user_version = 34").stepThis().dispose();
            i3 = 34;
        }
        if (i3 == 34) {
            messagesStorage.database.executeFast("CREATE TABLE IF NOT EXISTS stickers_featured(id INTEGER PRIMARY KEY, data BLOB, unread BLOB, date INTEGER, hash INTEGER);").stepThis().dispose();
            messagesStorage.database.executeFast("PRAGMA user_version = 35").stepThis().dispose();
            i3 = 35;
        }
        if (i3 == 35) {
            messagesStorage.database.executeFast("CREATE TABLE IF NOT EXISTS requested_holes(uid INTEGER, seq_out_start INTEGER, seq_out_end INTEGER, PRIMARY KEY (uid, seq_out_start, seq_out_end));").stepThis().dispose();
            messagesStorage.database.executeFast("PRAGMA user_version = 36").stepThis().dispose();
            i3 = 36;
        }
        if (i3 == 36) {
            messagesStorage.database.executeFast("ALTER TABLE enc_chats ADD COLUMN in_seq_no INTEGER default 0").stepThis().dispose();
            messagesStorage.database.executeFast("PRAGMA user_version = 37").stepThis().dispose();
            i3 = 37;
        }
        if (i3 == 37) {
            messagesStorage.database.executeFast("CREATE TABLE IF NOT EXISTS botcache(id TEXT PRIMARY KEY, date INTEGER, data BLOB)").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE INDEX IF NOT EXISTS botcache_date_idx ON botcache(date);").stepThis().dispose();
            messagesStorage.database.executeFast("PRAGMA user_version = 38").stepThis().dispose();
            i3 = 38;
        }
        if (i3 == 38) {
            messagesStorage.database.executeFast("ALTER TABLE dialogs ADD COLUMN pinned INTEGER default 0").stepThis().dispose();
            messagesStorage.database.executeFast("PRAGMA user_version = 39").stepThis().dispose();
            i3 = 39;
        }
        if (i3 == 39) {
            messagesStorage.database.executeFast("ALTER TABLE enc_chats ADD COLUMN admin_id INTEGER default 0").stepThis().dispose();
            messagesStorage.database.executeFast("PRAGMA user_version = 40").stepThis().dispose();
            i3 = 40;
        }
        if (i3 == 40) {
            fixNotificationSettings();
            messagesStorage.database.executeFast("PRAGMA user_version = 41").stepThis().dispose();
            i3 = 41;
        }
        if (i3 == 41) {
            messagesStorage.database.executeFast("ALTER TABLE messages ADD COLUMN mention INTEGER default 0").stepThis().dispose();
            messagesStorage.database.executeFast("ALTER TABLE user_contacts_v6 ADD COLUMN imported INTEGER default 0").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE INDEX IF NOT EXISTS uid_mention_idx_messages ON messages(uid, mention, read_state);").stepThis().dispose();
            messagesStorage.database.executeFast("PRAGMA user_version = 42").stepThis().dispose();
            i3 = 42;
        }
        if (i3 == 42) {
            messagesStorage.database.executeFast("CREATE TABLE IF NOT EXISTS sharing_locations(uid INTEGER PRIMARY KEY, mid INTEGER, date INTEGER, period INTEGER, message BLOB);").stepThis().dispose();
            messagesStorage.database.executeFast("PRAGMA user_version = 43").stepThis().dispose();
            i3 = 43;
        }
        if (i3 == 43) {
            messagesStorage.database.executeFast("PRAGMA user_version = 44").stepThis().dispose();
            i3 = 44;
        }
        if (i3 == 44) {
            messagesStorage.database.executeFast("CREATE TABLE IF NOT EXISTS user_contacts_v7(key TEXT PRIMARY KEY, uid INTEGER, fname TEXT, sname TEXT, imported INTEGER)").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE TABLE IF NOT EXISTS user_phones_v7(key TEXT, phone TEXT, sphone TEXT, deleted INTEGER, PRIMARY KEY (key, phone))").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE INDEX IF NOT EXISTS sphone_deleted_idx_user_phones ON user_phones_v7(sphone, deleted);").stepThis().dispose();
            messagesStorage.database.executeFast("PRAGMA user_version = 45").stepThis().dispose();
            i3 = 45;
        }
        if (i3 == 45) {
            messagesStorage.database.executeFast("ALTER TABLE enc_chats ADD COLUMN mtproto_seq INTEGER default 0").stepThis().dispose();
            messagesStorage.database.executeFast("PRAGMA user_version = 46").stepThis().dispose();
            i3 = 46;
        }
        if (i3 == 46) {
            messagesStorage.database.executeFast("DELETE FROM botcache WHERE 1").stepThis().dispose();
            messagesStorage.database.executeFast("PRAGMA user_version = 47").stepThis().dispose();
            i3 = 47;
        }
        if (i3 == 47) {
            messagesStorage.database.executeFast("ALTER TABLE dialogs ADD COLUMN flags INTEGER default 0").stepThis().dispose();
            messagesStorage.database.executeFast("PRAGMA user_version = 48").stepThis().dispose();
            i3 = 48;
        }
        if (i3 == 48) {
            messagesStorage.database.executeFast("CREATE TABLE IF NOT EXISTS unread_push_messages(uid INTEGER, mid INTEGER, random INTEGER, date INTEGER, data BLOB, fm TEXT, name TEXT, uname TEXT, flags INTEGER, PRIMARY KEY(uid, mid))").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE INDEX IF NOT EXISTS unread_push_messages_idx_date ON unread_push_messages(date);").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE INDEX IF NOT EXISTS unread_push_messages_idx_random ON unread_push_messages(random);").stepThis().dispose();
            messagesStorage.database.executeFast("PRAGMA user_version = 49").stepThis().dispose();
            i3 = 49;
        }
        if (i3 == 49) {
            messagesStorage.database.executeFast("CREATE TABLE IF NOT EXISTS user_settings(uid INTEGER PRIMARY KEY, info BLOB, pinned INTEGER)").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE INDEX IF NOT EXISTS user_settings_pinned_idx ON user_settings(uid, pinned) WHERE pinned != 0;").stepThis().dispose();
            messagesStorage.database.executeFast("PRAGMA user_version = 50").stepThis().dispose();
            i3 = 50;
        }
        if (i3 == 50) {
            messagesStorage.database.executeFast("DELETE FROM sent_files_v2 WHERE 1").stepThis().dispose();
            messagesStorage.database.executeFast("ALTER TABLE sent_files_v2 ADD COLUMN parent TEXT").stepThis().dispose();
            messagesStorage.database.executeFast("DELETE FROM download_queue WHERE 1").stepThis().dispose();
            messagesStorage.database.executeFast("ALTER TABLE download_queue ADD COLUMN parent TEXT").stepThis().dispose();
            messagesStorage.database.executeFast("PRAGMA user_version = 51").stepThis().dispose();
            i3 = 51;
        }
        if (i3 == 51) {
            messagesStorage.database.executeFast("ALTER TABLE media_counts_v2 ADD COLUMN old INTEGER").stepThis().dispose();
            messagesStorage.database.executeFast("PRAGMA user_version = 52").stepThis().dispose();
            i3 = 52;
        }
        if (i3 == 52) {
            messagesStorage.database.executeFast("CREATE TABLE IF NOT EXISTS polls_v2(mid INTEGER, uid INTEGER, id INTEGER, PRIMARY KEY (mid, uid));").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE INDEX IF NOT EXISTS polls_id ON polls_v2(id);").stepThis().dispose();
            messagesStorage.database.executeFast("PRAGMA user_version = 53").stepThis().dispose();
            i3 = 53;
        }
        if (i3 == 53) {
            messagesStorage.database.executeFast("ALTER TABLE chat_settings_v2 ADD COLUMN online INTEGER default 0").stepThis().dispose();
            messagesStorage.database.executeFast("PRAGMA user_version = 54").stepThis().dispose();
            i3 = 54;
        }
        if (i3 == 54) {
            messagesStorage.database.executeFast("DROP TABLE IF EXISTS wallpapers;").stepThis().dispose();
            messagesStorage.database.executeFast("PRAGMA user_version = 55").stepThis().dispose();
            i3 = 55;
        }
        if (i3 == 55) {
            messagesStorage.database.executeFast("CREATE TABLE IF NOT EXISTS wallpapers2(uid INTEGER PRIMARY KEY, data BLOB, num INTEGER)").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE INDEX IF NOT EXISTS wallpapers_num ON wallpapers2(num);").stepThis().dispose();
            messagesStorage.database.executeFast("PRAGMA user_version = 56").stepThis().dispose();
            i3 = 56;
        }
        if (i3 == 56 || i3 == 57) {
            messagesStorage.database.executeFast("CREATE TABLE IF NOT EXISTS emoji_keywords_v2(lang TEXT, keyword TEXT, emoji TEXT, PRIMARY KEY(lang, keyword, emoji));").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE TABLE IF NOT EXISTS emoji_keywords_info_v2(lang TEXT PRIMARY KEY, alias TEXT, version INTEGER);").stepThis().dispose();
            messagesStorage.database.executeFast("PRAGMA user_version = 58").stepThis().dispose();
            i3 = 58;
        }
        if (i3 == 58) {
            messagesStorage.database.executeFast("CREATE INDEX IF NOT EXISTS emoji_keywords_v2_keyword ON emoji_keywords_v2(keyword);").stepThis().dispose();
            messagesStorage.database.executeFast("ALTER TABLE emoji_keywords_info_v2 ADD COLUMN date INTEGER default 0").stepThis().dispose();
            messagesStorage.database.executeFast("PRAGMA user_version = 59").stepThis().dispose();
            i3 = 59;
        }
        if (i3 == 59) {
            messagesStorage.database.executeFast("ALTER TABLE dialogs ADD COLUMN folder_id INTEGER default 0").stepThis().dispose();
            messagesStorage.database.executeFast("ALTER TABLE dialogs ADD COLUMN data BLOB default NULL").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE INDEX IF NOT EXISTS folder_id_idx_dialogs ON dialogs(folder_id);").stepThis().dispose();
            messagesStorage.database.executeFast("PRAGMA user_version = 60").stepThis().dispose();
            i3 = 60;
        }
        if (i3 == 60) {
            messagesStorage.database.executeFast("DROP TABLE IF EXISTS channel_admins;").stepThis().dispose();
            messagesStorage.database.executeFast("DROP TABLE IF EXISTS blocked_users;").stepThis().dispose();
            messagesStorage.database.executeFast("PRAGMA user_version = 61").stepThis().dispose();
            i3 = 61;
        }
        if (i3 == 61) {
            messagesStorage.database.executeFast("DROP INDEX IF EXISTS send_state_idx_messages;").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE INDEX IF NOT EXISTS send_state_idx_messages2 ON messages(mid, send_state, date);").stepThis().dispose();
            messagesStorage.database.executeFast("PRAGMA user_version = 62").stepThis().dispose();
            i3 = 62;
        }
        if (i3 == 62) {
            messagesStorage.database.executeFast("CREATE TABLE IF NOT EXISTS scheduled_messages(mid INTEGER PRIMARY KEY, uid INTEGER, send_state INTEGER, date INTEGER, data BLOB, ttl INTEGER, replydata BLOB)").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE INDEX IF NOT EXISTS send_state_idx_scheduled_messages ON scheduled_messages(mid, send_state, date);").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE INDEX IF NOT EXISTS uid_date_idx_scheduled_messages ON scheduled_messages(uid, date);").stepThis().dispose();
            messagesStorage.database.executeFast("PRAGMA user_version = 63").stepThis().dispose();
            i3 = 63;
        }
        if (i3 == 63) {
            messagesStorage.database.executeFast("DELETE FROM download_queue WHERE 1").stepThis().dispose();
            messagesStorage.database.executeFast("PRAGMA user_version = 64").stepThis().dispose();
            i3 = 64;
        }
        if (i3 == 64) {
            messagesStorage.database.executeFast("CREATE TABLE IF NOT EXISTS dialog_filter(id INTEGER PRIMARY KEY, ord INTEGER, unread_count INTEGER, flags INTEGER, title TEXT)").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE TABLE IF NOT EXISTS dialog_filter_ep(id INTEGER, peer INTEGER, PRIMARY KEY (id, peer))").stepThis().dispose();
            messagesStorage.database.executeFast("PRAGMA user_version = 65").stepThis().dispose();
            i3 = 65;
        }
        if (i3 == 65) {
            messagesStorage.database.executeFast("CREATE INDEX IF NOT EXISTS flags_idx_dialogs ON dialogs(flags);").stepThis().dispose();
            messagesStorage.database.executeFast("PRAGMA user_version = 66").stepThis().dispose();
            i3 = 66;
        }
        if (i3 == 66) {
            messagesStorage.database.executeFast("CREATE TABLE dialog_filter_pin_v2(id INTEGER, peer INTEGER, pin INTEGER, PRIMARY KEY (id, peer))").stepThis().dispose();
            messagesStorage.database.executeFast("PRAGMA user_version = 67").stepThis().dispose();
            i3 = 67;
        }
        if (i3 == 67) {
            messagesStorage.database.executeFast("CREATE TABLE IF NOT EXISTS stickers_dice(emoji TEXT PRIMARY KEY, data BLOB, date INTEGER);").stepThis().dispose();
            messagesStorage.database.executeFast("PRAGMA user_version = 68").stepThis().dispose();
            i3 = 68;
        }
        if (i3 == 68) {
            messagesStorage.executeNoException("ALTER TABLE messages ADD COLUMN forwards INTEGER default 0");
            messagesStorage.database.executeFast("PRAGMA user_version = 69").stepThis().dispose();
            i3 = 69;
        }
        if (i3 == 69) {
            messagesStorage.executeNoException("ALTER TABLE messages ADD COLUMN replies_data BLOB default NULL");
            messagesStorage.executeNoException("ALTER TABLE messages ADD COLUMN thread_reply_id INTEGER default 0");
            messagesStorage.database.executeFast("PRAGMA user_version = 70").stepThis().dispose();
            i3 = 70;
        }
        if (i3 == 70) {
            messagesStorage.database.executeFast("CREATE TABLE IF NOT EXISTS chat_pinned_v2(uid INTEGER, mid INTEGER, data BLOB, PRIMARY KEY (uid, mid));").stepThis().dispose();
            messagesStorage.database.executeFast("PRAGMA user_version = 71").stepThis().dispose();
            i3 = 71;
        }
        if (i3 == 71) {
            messagesStorage.executeNoException("ALTER TABLE sharing_locations ADD COLUMN proximity INTEGER default 0");
            messagesStorage.database.executeFast("PRAGMA user_version = 72").stepThis().dispose();
            i3 = 72;
        }
        if (i3 == 72) {
            messagesStorage.database.executeFast("CREATE TABLE IF NOT EXISTS chat_pinned_count(uid INTEGER PRIMARY KEY, count INTEGER, end INTEGER);").stepThis().dispose();
            messagesStorage.database.executeFast("PRAGMA user_version = 73").stepThis().dispose();
            i3 = 73;
        }
        if (i3 == 73) {
            messagesStorage.executeNoException("ALTER TABLE chat_settings_v2 ADD COLUMN inviter INTEGER default 0");
            messagesStorage.database.executeFast("PRAGMA user_version = 74").stepThis().dispose();
            i3 = 74;
        }
        if (i3 == 74) {
            messagesStorage.database.executeFast("CREATE TABLE IF NOT EXISTS shortcut_widget(id INTEGER, did INTEGER, ord INTEGER, PRIMARY KEY (id, did));").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE INDEX IF NOT EXISTS shortcut_widget_did ON shortcut_widget(did);").stepThis().dispose();
            messagesStorage.database.executeFast("PRAGMA user_version = 75").stepThis().dispose();
            i3 = 75;
        }
        if (i3 == 75) {
            messagesStorage.executeNoException("ALTER TABLE chat_settings_v2 ADD COLUMN links INTEGER default 0");
            messagesStorage.database.executeFast("PRAGMA user_version = 76").stepThis().dispose();
            i3 = 76;
        }
        if (i3 == 76) {
            messagesStorage.executeNoException("ALTER TABLE enc_tasks_v2 ADD COLUMN media INTEGER default -1");
            messagesStorage.database.executeFast("PRAGMA user_version = 77").stepThis().dispose();
            i3 = 77;
        }
        if (i3 == 77) {
            messagesStorage.database.executeFast("DROP TABLE IF EXISTS channel_admins_v2;").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE TABLE IF NOT EXISTS channel_admins_v3(did INTEGER, uid INTEGER, data BLOB, PRIMARY KEY(did, uid))").stepThis().dispose();
            messagesStorage.database.executeFast("PRAGMA user_version = 78").stepThis().dispose();
            i3 = 78;
        }
        if (i3 == 78) {
            messagesStorage.database.executeFast("DROP TABLE IF EXISTS bot_info;").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE TABLE IF NOT EXISTS bot_info_v2(uid INTEGER, dialogId INTEGER, info BLOB, PRIMARY KEY(uid, dialogId))").stepThis().dispose();
            messagesStorage.database.executeFast("PRAGMA user_version = 79").stepThis().dispose();
            i3 = 79;
        }
        int i10 = 3;
        if (i3 == 79) {
            messagesStorage.database.executeFast("CREATE TABLE IF NOT EXISTS enc_tasks_v3(mid INTEGER, date INTEGER, media INTEGER, PRIMARY KEY(mid, media))").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE INDEX IF NOT EXISTS date_idx_enc_tasks_v3 ON enc_tasks_v3(date);").stepThis().dispose();
            messagesStorage.database.beginTransaction();
            SQLiteCursor sQLiteCursorQueryFinalized10 = messagesStorage.database.queryFinalized("SELECT mid, date, media FROM enc_tasks_v2 WHERE 1", new Object[0]);
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast3 = messagesStorage.database.executeFast("REPLACE INTO enc_tasks_v3 VALUES(?, ?, ?)");
            if (sQLiteCursorQueryFinalized10.next()) {
                long jLongValue = sQLiteCursorQueryFinalized10.longValue(0);
                int iIntValue2 = sQLiteCursorQueryFinalized10.intValue(1);
                int iIntValue3 = sQLiteCursorQueryFinalized10.intValue(2);
                sQLitePreparedStatementExecuteFast3.requery();
                sQLitePreparedStatementExecuteFast3.bindLong(1, jLongValue);
                sQLitePreparedStatementExecuteFast3.bindInteger(2, iIntValue2);
                sQLitePreparedStatementExecuteFast3.bindInteger(3, iIntValue3);
                sQLitePreparedStatementExecuteFast3.step();
            }
            sQLitePreparedStatementExecuteFast3.dispose();
            sQLiteCursorQueryFinalized10.dispose();
            messagesStorage.database.commitTransaction();
            messagesStorage.database.executeFast("DROP INDEX IF EXISTS date_idx_enc_tasks_v2;").stepThis().dispose();
            messagesStorage.database.executeFast("DROP TABLE IF EXISTS enc_tasks_v2;").stepThis().dispose();
            messagesStorage.database.executeFast("PRAGMA user_version = 80").stepThis().dispose();
            i3 = 80;
        }
        int i11 = 5;
        if (i3 == 80) {
            messagesStorage.database.executeFast("CREATE TABLE IF NOT EXISTS scheduled_messages_v2(mid INTEGER, uid INTEGER, send_state INTEGER, date INTEGER, data BLOB, ttl INTEGER, replydata BLOB, PRIMARY KEY(mid, uid))").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE INDEX IF NOT EXISTS send_state_idx_scheduled_messages_v2 ON scheduled_messages_v2(mid, send_state, date);").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE INDEX IF NOT EXISTS uid_date_idx_scheduled_messages_v2 ON scheduled_messages_v2(uid, date);").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE INDEX IF NOT EXISTS bot_keyboard_idx_mid_v2 ON bot_keyboard(mid, uid);").stepThis().dispose();
            messagesStorage.database.executeFast("DROP INDEX IF EXISTS bot_keyboard_idx_mid;").stepThis().dispose();
            messagesStorage.database.beginTransaction();
            try {
                sQLiteCursorQueryFinalized7 = messagesStorage.database.queryFinalized("SELECT mid, uid, send_state, date, data, ttl, replydata FROM scheduled_messages_v2 WHERE 1", new Object[0]);
            } catch (Exception e) {
                FileLog.e(e);
                sQLiteCursorQueryFinalized7 = null;
            }
            if (sQLiteCursorQueryFinalized7 != null) {
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast4 = messagesStorage.database.executeFast("REPLACE INTO scheduled_messages_v2 VALUES(?, ?, ?, ?, ?, ?, ?)");
                while (sQLiteCursorQueryFinalized7.next()) {
                    NativeByteBuffer nativeByteBufferByteBufferValue3 = sQLiteCursorQueryFinalized7.byteBufferValue(4);
                    if (nativeByteBufferByteBufferValue3 != null) {
                        int iIntValue4 = sQLiteCursorQueryFinalized7.intValue(i8);
                        long jLongValue2 = sQLiteCursorQueryFinalized7.longValue(1);
                        int iIntValue5 = sQLiteCursorQueryFinalized7.intValue(2);
                        int iIntValue6 = sQLiteCursorQueryFinalized7.intValue(3);
                        int iIntValue7 = sQLiteCursorQueryFinalized7.intValue(i11);
                        NativeByteBuffer nativeByteBufferByteBufferValue4 = sQLiteCursorQueryFinalized7.byteBufferValue(6);
                        sQLitePreparedStatementExecuteFast4.requery();
                        sQLitePreparedStatementExecuteFast4.bindInteger(1, iIntValue4);
                        sQLitePreparedStatementExecuteFast4.bindLong(2, jLongValue2);
                        sQLitePreparedStatementExecuteFast4.bindInteger(3, iIntValue5);
                        sQLitePreparedStatementExecuteFast4.bindByteBuffer(4, nativeByteBufferByteBufferValue3);
                        sQLitePreparedStatementExecuteFast4.bindInteger(5, iIntValue6);
                        sQLitePreparedStatementExecuteFast4.bindInteger(6, iIntValue7);
                        if (nativeByteBufferByteBufferValue4 != null) {
                            sQLitePreparedStatementExecuteFast4.bindByteBuffer(7, nativeByteBufferByteBufferValue4);
                        } else {
                            sQLitePreparedStatementExecuteFast4.bindNull(7);
                        }
                        sQLitePreparedStatementExecuteFast4.step();
                        if (nativeByteBufferByteBufferValue4 != null) {
                            nativeByteBufferByteBufferValue4.reuse();
                        }
                        nativeByteBufferByteBufferValue3.reuse();
                        i8 = 0;
                        i11 = 5;
                    }
                }
                sQLiteCursorQueryFinalized7.dispose();
                sQLitePreparedStatementExecuteFast4.dispose();
            }
            messagesStorage.database.executeFast("DROP INDEX IF EXISTS send_state_idx_scheduled_messages;").stepThis().dispose();
            messagesStorage.database.executeFast("DROP INDEX IF EXISTS uid_date_idx_scheduled_messages;").stepThis().dispose();
            messagesStorage.database.executeFast("DROP TABLE IF EXISTS scheduled_messages;").stepThis().dispose();
            messagesStorage.database.commitTransaction();
            messagesStorage.database.executeFast("PRAGMA user_version = 81").stepThis().dispose();
            i3 = 81;
        }
        if (i3 == 81) {
            messagesStorage.database.executeFast("CREATE TABLE IF NOT EXISTS media_v3(mid INTEGER, uid INTEGER, date INTEGER, type INTEGER, data BLOB, PRIMARY KEY(mid, uid))").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE INDEX IF NOT EXISTS uid_mid_type_date_idx_media_v3 ON media_v3(uid, mid, type, date);").stepThis().dispose();
            messagesStorage.database.beginTransaction();
            try {
                sQLiteCursorQueryFinalized6 = messagesStorage.database.queryFinalized("SELECT mid, uid, date, type, data FROM media_v2 WHERE 1", new Object[0]);
            } catch (Exception e2) {
                FileLog.e(e2);
                sQLiteCursorQueryFinalized6 = null;
            }
            if (sQLiteCursorQueryFinalized6 != null) {
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast5 = messagesStorage.database.executeFast("REPLACE INTO media_v3 VALUES(?, ?, ?, ?, ?)");
                while (sQLiteCursorQueryFinalized6.next()) {
                    NativeByteBuffer nativeByteBufferByteBufferValue5 = sQLiteCursorQueryFinalized6.byteBufferValue(4);
                    if (nativeByteBufferByteBufferValue5 != null) {
                        int iIntValue8 = sQLiteCursorQueryFinalized6.intValue(0);
                        long jLongValue3 = sQLiteCursorQueryFinalized6.longValue(1);
                        if (((int) jLongValue3) == 0) {
                            jLongValue3 = DialogObject.makeEncryptedDialogId((int) (jLongValue3 >> 32));
                        }
                        int iIntValue9 = sQLiteCursorQueryFinalized6.intValue(2);
                        int iIntValue10 = sQLiteCursorQueryFinalized6.intValue(3);
                        sQLitePreparedStatementExecuteFast5.requery();
                        sQLitePreparedStatementExecuteFast5.bindInteger(1, iIntValue8);
                        sQLitePreparedStatementExecuteFast5.bindLong(2, jLongValue3);
                        sQLitePreparedStatementExecuteFast5.bindInteger(3, iIntValue9);
                        sQLitePreparedStatementExecuteFast5.bindInteger(4, iIntValue10);
                        sQLitePreparedStatementExecuteFast5.bindByteBuffer(5, nativeByteBufferByteBufferValue5);
                        sQLitePreparedStatementExecuteFast5.step();
                        nativeByteBufferByteBufferValue5.reuse();
                    }
                }
                sQLiteCursorQueryFinalized6.dispose();
                sQLitePreparedStatementExecuteFast5.dispose();
            }
            messagesStorage.database.executeFast("DROP INDEX IF EXISTS uid_mid_type_date_idx_media;").stepThis().dispose();
            messagesStorage.database.executeFast("DROP TABLE IF EXISTS media_v2;").stepThis().dispose();
            messagesStorage.database.commitTransaction();
            messagesStorage.database.executeFast("PRAGMA user_version = 82").stepThis().dispose();
            i3 = 82;
        }
        if (i3 == 82) {
            messagesStorage.database.executeFast("CREATE TABLE IF NOT EXISTS randoms_v2(random_id INTEGER, mid INTEGER, uid INTEGER, PRIMARY KEY (random_id, mid, uid))").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE INDEX IF NOT EXISTS mid_idx_randoms_v2 ON randoms_v2(mid, uid);").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE TABLE IF NOT EXISTS enc_tasks_v4(mid INTEGER, uid INTEGER, date INTEGER, media INTEGER, PRIMARY KEY(mid, uid, media))").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE INDEX IF NOT EXISTS date_idx_enc_tasks_v4 ON enc_tasks_v4(date);").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE TABLE IF NOT EXISTS polls_v2(mid INTEGER, uid INTEGER, id INTEGER, PRIMARY KEY (mid, uid));").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE INDEX IF NOT EXISTS polls_id_v2 ON polls_v2(id);").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE TABLE IF NOT EXISTS webpage_pending_v2(id INTEGER, mid INTEGER, uid INTEGER, PRIMARY KEY (id, mid, uid));").stepThis().dispose();
            messagesStorage.database.beginTransaction();
            try {
                sQLiteCursorQueryFinalized2 = messagesStorage.database.queryFinalized("SELECT r.random_id, r.mid, m.uid FROM randoms as r INNER JOIN messages as m ON r.mid = m.mid WHERE 1", new Object[0]);
            } catch (Exception e3) {
                FileLog.e(e3);
                sQLiteCursorQueryFinalized2 = null;
            }
            if (sQLiteCursorQueryFinalized2 != null) {
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast6 = messagesStorage.database.executeFast("REPLACE INTO randoms_v2 VALUES(?, ?, ?)");
                while (sQLiteCursorQueryFinalized2.next()) {
                    long jLongValue4 = sQLiteCursorQueryFinalized2.longValue(0);
                    int iIntValue11 = sQLiteCursorQueryFinalized2.intValue(1);
                    long jLongValue5 = sQLiteCursorQueryFinalized2.longValue(2);
                    if (((int) jLongValue5) == 0) {
                        jLongValue5 = DialogObject.makeEncryptedDialogId((int) (jLongValue5 >> 32));
                    }
                    sQLitePreparedStatementExecuteFast6.requery();
                    sQLitePreparedStatementExecuteFast6.bindLong(1, jLongValue4);
                    sQLitePreparedStatementExecuteFast6.bindInteger(2, iIntValue11);
                    sQLitePreparedStatementExecuteFast6.bindLong(3, jLongValue5);
                    sQLitePreparedStatementExecuteFast6.step();
                }
                sQLiteCursorQueryFinalized2.dispose();
                sQLitePreparedStatementExecuteFast6.dispose();
            }
            try {
                sQLiteCursorQueryFinalized3 = messagesStorage.database.queryFinalized("SELECT p.mid, m.uid, p.id FROM polls as p INNER JOIN messages as m ON p.mid = m.mid WHERE 1", new Object[0]);
            } catch (Exception e4) {
                FileLog.e(e4);
                sQLiteCursorQueryFinalized3 = null;
            }
            if (sQLiteCursorQueryFinalized3 != null) {
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast7 = messagesStorage.database.executeFast("REPLACE INTO polls_v2 VALUES(?, ?, ?)");
                while (sQLiteCursorQueryFinalized3.next()) {
                    int iIntValue12 = sQLiteCursorQueryFinalized3.intValue(0);
                    long jLongValue6 = sQLiteCursorQueryFinalized3.longValue(1);
                    long jLongValue7 = sQLiteCursorQueryFinalized3.longValue(2);
                    if (((int) jLongValue6) == 0) {
                        jLongValue6 = DialogObject.makeEncryptedDialogId((int) (jLongValue6 >> 32));
                    }
                    sQLitePreparedStatementExecuteFast7.requery();
                    sQLitePreparedStatementExecuteFast7.bindInteger(1, iIntValue12);
                    sQLitePreparedStatementExecuteFast7.bindLong(2, jLongValue6);
                    sQLitePreparedStatementExecuteFast7.bindLong(3, jLongValue7);
                    sQLitePreparedStatementExecuteFast7.step();
                }
                sQLiteCursorQueryFinalized3.dispose();
                sQLitePreparedStatementExecuteFast7.dispose();
            }
            try {
                sQLiteCursorQueryFinalized4 = messagesStorage.database.queryFinalized("SELECT wp.id, wp.mid, m.uid FROM webpage_pending as wp INNER JOIN messages as m ON wp.mid = m.mid WHERE 1", new Object[0]);
            } catch (Exception e5) {
                FileLog.e(e5);
                sQLiteCursorQueryFinalized4 = null;
            }
            if (sQLiteCursorQueryFinalized4 != null) {
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast8 = messagesStorage.database.executeFast("REPLACE INTO webpage_pending_v2 VALUES(?, ?, ?)");
                while (sQLiteCursorQueryFinalized4.next()) {
                    long jLongValue8 = sQLiteCursorQueryFinalized4.longValue(0);
                    int iIntValue13 = sQLiteCursorQueryFinalized4.intValue(1);
                    long jLongValue9 = sQLiteCursorQueryFinalized4.longValue(2);
                    if (((int) jLongValue9) == 0) {
                        jLongValue9 = DialogObject.makeEncryptedDialogId((int) (jLongValue9 >> 32));
                    }
                    sQLitePreparedStatementExecuteFast8.requery();
                    sQLitePreparedStatementExecuteFast8.bindLong(1, jLongValue8);
                    sQLitePreparedStatementExecuteFast8.bindInteger(2, iIntValue13);
                    sQLitePreparedStatementExecuteFast8.bindLong(3, jLongValue9);
                    sQLitePreparedStatementExecuteFast8.step();
                }
                sQLiteCursorQueryFinalized4.dispose();
                sQLitePreparedStatementExecuteFast8.dispose();
            }
            try {
                sQLiteCursorQueryFinalized5 = messagesStorage.database.queryFinalized("SELECT et.mid, m.uid, et.date, et.media FROM enc_tasks_v3 as et INNER JOIN messages as m ON et.mid = m.mid WHERE 1", new Object[0]);
            } catch (Exception e6) {
                FileLog.e(e6);
                sQLiteCursorQueryFinalized5 = null;
            }
            if (sQLiteCursorQueryFinalized5 != null) {
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast9 = messagesStorage.database.executeFast("REPLACE INTO enc_tasks_v4 VALUES(?, ?, ?, ?)");
                while (sQLiteCursorQueryFinalized5.next()) {
                    int iIntValue14 = sQLiteCursorQueryFinalized5.intValue(0);
                    long jLongValue10 = sQLiteCursorQueryFinalized5.longValue(1);
                    int iIntValue15 = sQLiteCursorQueryFinalized5.intValue(2);
                    int iIntValue16 = sQLiteCursorQueryFinalized5.intValue(3);
                    if (((int) jLongValue10) == 0) {
                        jLongValue10 = DialogObject.makeEncryptedDialogId((int) (jLongValue10 >> 32));
                    }
                    sQLitePreparedStatementExecuteFast9.requery();
                    sQLitePreparedStatementExecuteFast9.bindInteger(1, iIntValue14);
                    sQLitePreparedStatementExecuteFast9.bindLong(2, jLongValue10);
                    sQLitePreparedStatementExecuteFast9.bindInteger(3, iIntValue15);
                    sQLitePreparedStatementExecuteFast9.bindInteger(4, iIntValue16);
                    sQLitePreparedStatementExecuteFast9.step();
                }
                sQLiteCursorQueryFinalized5.dispose();
                sQLitePreparedStatementExecuteFast9.dispose();
            }
            messagesStorage.database.executeFast("DROP INDEX IF EXISTS mid_idx_randoms;").stepThis().dispose();
            messagesStorage.database.executeFast("DROP TABLE IF EXISTS randoms;").stepThis().dispose();
            messagesStorage.database.executeFast("DROP INDEX IF EXISTS date_idx_enc_tasks_v3;").stepThis().dispose();
            messagesStorage.database.executeFast("DROP TABLE IF EXISTS enc_tasks_v3;").stepThis().dispose();
            messagesStorage.database.executeFast("DROP INDEX IF EXISTS polls_id;").stepThis().dispose();
            messagesStorage.database.executeFast("DROP TABLE IF EXISTS polls;").stepThis().dispose();
            messagesStorage.database.executeFast("DROP TABLE IF EXISTS webpage_pending;").stepThis().dispose();
            messagesStorage.database.commitTransaction();
            messagesStorage.database.executeFast("PRAGMA user_version = 83").stepThis().dispose();
            i3 = 83;
        }
        if (i3 == 83) {
            messagesStorage.database.executeFast("CREATE TABLE IF NOT EXISTS messages_v2(mid INTEGER, uid INTEGER, read_state INTEGER, send_state INTEGER, date INTEGER, data BLOB, out INTEGER, ttl INTEGER, media INTEGER, replydata BLOB, imp INTEGER, mention INTEGER, forwards INTEGER, replies_data BLOB, thread_reply_id INTEGER, is_channel INTEGER, PRIMARY KEY(mid, uid))").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE INDEX IF NOT EXISTS uid_mid_read_out_idx_messages_v2 ON messages_v2(uid, mid, read_state, out);").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE INDEX IF NOT EXISTS uid_date_mid_idx_messages_v2 ON messages_v2(uid, date, mid);").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE INDEX IF NOT EXISTS mid_out_idx_messages_v2 ON messages_v2(mid, out);").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE INDEX IF NOT EXISTS task_idx_messages_v2 ON messages_v2(uid, out, read_state, ttl, date, send_state);").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE INDEX IF NOT EXISTS send_state_idx_messages_v2 ON messages_v2(mid, send_state, date);").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE INDEX IF NOT EXISTS uid_mention_idx_messages_v2 ON messages_v2(uid, mention, read_state);").stepThis().dispose();
            messagesStorage.database.executeFast("CREATE INDEX IF NOT EXISTS is_channel_idx_messages_v2 ON messages_v2(mid, is_channel);").stepThis().dispose();
            messagesStorage.database.beginTransaction();
            try {
                sQLiteCursorQueryFinalized = messagesStorage.database.queryFinalized("SELECT mid, uid, read_state, send_state, date, data, out, ttl, media, replydata, imp, mention, forwards, replies_data, thread_reply_id FROM messages WHERE 1", new Object[0]);
            } catch (Exception e7) {
                FileLog.e(e7);
                sQLiteCursorQueryFinalized = null;
            }
            if (sQLiteCursorQueryFinalized != null) {
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast10 = messagesStorage.database.executeFast("REPLACE INTO messages_v2 VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                while (sQLiteCursorQueryFinalized.next()) {
                    NativeByteBuffer nativeByteBufferByteBufferValue6 = sQLiteCursorQueryFinalized.byteBufferValue(5);
                    if (nativeByteBufferByteBufferValue6 != null) {
                        long jIntValue2 = sQLiteCursorQueryFinalized.intValue(0);
                        long jLongValue11 = sQLiteCursorQueryFinalized.longValue(i7);
                        if (((int) jLongValue11) == 0) {
                            jLongValue11 = DialogObject.makeEncryptedDialogId((int) (jLongValue11 >> 32));
                        }
                        int iIntValue17 = sQLiteCursorQueryFinalized.intValue(i6);
                        int iIntValue18 = sQLiteCursorQueryFinalized.intValue(i10);
                        int iIntValue19 = sQLiteCursorQueryFinalized.intValue(i4);
                        int iIntValue20 = sQLiteCursorQueryFinalized.intValue(i5);
                        int iIntValue21 = sQLiteCursorQueryFinalized.intValue(7);
                        int iIntValue22 = sQLiteCursorQueryFinalized.intValue(8);
                        NativeByteBuffer nativeByteBufferByteBufferValue7 = sQLiteCursorQueryFinalized.byteBufferValue(9);
                        int iIntValue23 = sQLiteCursorQueryFinalized.intValue(10);
                        int iIntValue24 = sQLiteCursorQueryFinalized.intValue(11);
                        int iIntValue25 = sQLiteCursorQueryFinalized.intValue(12);
                        NativeByteBuffer nativeByteBufferByteBufferValue8 = sQLiteCursorQueryFinalized.byteBufferValue(13);
                        int iIntValue26 = sQLiteCursorQueryFinalized.intValue(14);
                        SQLiteCursor sQLiteCursor = sQLiteCursorQueryFinalized;
                        int i12 = (int) (jLongValue11 >> 32);
                        if (iIntValue21 < 0) {
                            TLRPC$Message tLRPC$MessageTLdeserialize = TLRPC$Message.TLdeserialize(nativeByteBufferByteBufferValue6, nativeByteBufferByteBufferValue6.readInt32(false), false);
                            if (tLRPC$MessageTLdeserialize != null) {
                                i2 = iIntValue22;
                                tLRPC$MessageTLdeserialize.readAttachPath(nativeByteBufferByteBufferValue6, getUserConfig().clientUserId);
                                if (tLRPC$MessageTLdeserialize.params == null) {
                                    HashMap<String, String> map = new HashMap<>();
                                    tLRPC$MessageTLdeserialize.params = map;
                                    StringBuilder sb = new StringBuilder();
                                    i = i12;
                                    sb.append("");
                                    sb.append(iIntValue21);
                                    map.put("fwd_peer", sb.toString());
                                } else {
                                    i = i12;
                                }
                                nativeByteBufferByteBufferValue6.reuse();
                                NativeByteBuffer nativeByteBuffer3 = new NativeByteBuffer(tLRPC$MessageTLdeserialize.getObjectSize());
                                tLRPC$MessageTLdeserialize.serializeToStream(nativeByteBuffer3);
                                nativeByteBufferByteBufferValue6 = nativeByteBuffer3;
                            } else {
                                i = i12;
                                i2 = iIntValue22;
                            }
                            iIntValue21 = 0;
                        } else {
                            i = i12;
                            i2 = iIntValue22;
                        }
                        sQLitePreparedStatementExecuteFast10.requery();
                        sQLitePreparedStatementExecuteFast10.bindInteger(1, (int) jIntValue2);
                        sQLitePreparedStatementExecuteFast10.bindLong(2, jLongValue11);
                        sQLitePreparedStatementExecuteFast10.bindInteger(3, iIntValue17);
                        sQLitePreparedStatementExecuteFast10.bindInteger(4, iIntValue18);
                        sQLitePreparedStatementExecuteFast10.bindInteger(5, iIntValue19);
                        sQLitePreparedStatementExecuteFast10.bindByteBuffer(6, nativeByteBufferByteBufferValue6);
                        sQLitePreparedStatementExecuteFast10.bindInteger(7, iIntValue20);
                        sQLitePreparedStatementExecuteFast10.bindInteger(8, iIntValue21);
                        sQLitePreparedStatementExecuteFast10.bindInteger(9, i2);
                        if (nativeByteBufferByteBufferValue7 != null) {
                            sQLitePreparedStatementExecuteFast10.bindByteBuffer(10, nativeByteBufferByteBufferValue7);
                        } else {
                            sQLitePreparedStatementExecuteFast10.bindNull(10);
                        }
                        sQLitePreparedStatementExecuteFast10.bindInteger(11, iIntValue23);
                        sQLitePreparedStatementExecuteFast10.bindInteger(12, iIntValue24);
                        sQLitePreparedStatementExecuteFast10.bindInteger(13, iIntValue25);
                        if (nativeByteBufferByteBufferValue8 != null) {
                            nativeByteBuffer = nativeByteBufferByteBufferValue8;
                            sQLitePreparedStatementExecuteFast10.bindByteBuffer(14, nativeByteBuffer);
                        } else {
                            nativeByteBuffer = nativeByteBufferByteBufferValue8;
                            sQLitePreparedStatementExecuteFast10.bindNull(14);
                        }
                        sQLitePreparedStatementExecuteFast10.bindInteger(15, iIntValue26);
                        sQLitePreparedStatementExecuteFast10.bindInteger(16, i > 0 ? 1 : 0);
                        sQLitePreparedStatementExecuteFast10.step();
                        if (nativeByteBufferByteBufferValue7 != null) {
                            nativeByteBufferByteBufferValue7.reuse();
                        }
                        if (nativeByteBuffer != null) {
                            nativeByteBuffer.reuse();
                        }
                        nativeByteBufferByteBufferValue6.reuse();
                        sQLiteCursorQueryFinalized = sQLiteCursor;
                        i4 = 4;
                        i5 = 6;
                        i6 = 2;
                        i7 = 1;
                        i10 = 3;
                    }
                }
                sQLiteCursorQueryFinalized.dispose();
                sQLitePreparedStatementExecuteFast10.dispose();
            }
            messagesStorage = this;
            int i13 = 0;
            SQLiteCursor sQLiteCursorQueryFinalized11 = messagesStorage.database.queryFinalized("SELECT did, last_mid, last_mid_i FROM dialogs WHERE 1", new Object[0]);
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast11 = messagesStorage.database.executeFast("UPDATE dialogs SET last_mid = ?, last_mid_i = ? WHERE did = ?");
            ArrayList arrayList = null;
            ArrayList arrayList2 = null;
            while (sQLiteCursorQueryFinalized11.next()) {
                long jLongValue12 = sQLiteCursorQueryFinalized11.longValue(i13);
                int i14 = (int) jLongValue12;
                int i15 = (int) (jLongValue12 >> 32);
                if (i14 == 0) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(Integer.valueOf(i15));
                } else if (i15 == 2) {
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                    }
                    arrayList2.add(Integer.valueOf(i14));
                }
                sQLitePreparedStatementExecuteFast11.requery();
                sQLitePreparedStatementExecuteFast11.bindInteger(1, sQLiteCursorQueryFinalized11.intValue(1));
                sQLitePreparedStatementExecuteFast11.bindInteger(2, sQLiteCursorQueryFinalized11.intValue(2));
                sQLitePreparedStatementExecuteFast11.bindLong(3, jLongValue12);
                sQLitePreparedStatementExecuteFast11.step();
                i13 = 0;
            }
            sQLitePreparedStatementExecuteFast11.dispose();
            sQLiteCursorQueryFinalized11.dispose();
            SQLiteCursor sQLiteCursorQueryFinalized12 = messagesStorage.database.queryFinalized("SELECT uid, mid FROM unread_push_messages WHERE 1", new Object[0]);
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast12 = messagesStorage.database.executeFast("UPDATE unread_push_messages SET mid = ? WHERE uid = ? AND mid = ?");
            while (sQLiteCursorQueryFinalized12.next()) {
                long jLongValue13 = sQLiteCursorQueryFinalized12.longValue(0);
                int iIntValue27 = sQLiteCursorQueryFinalized12.intValue(1);
                sQLitePreparedStatementExecuteFast12.requery();
                sQLitePreparedStatementExecuteFast12.bindInteger(1, iIntValue27);
                sQLitePreparedStatementExecuteFast12.bindLong(2, jLongValue13);
                sQLitePreparedStatementExecuteFast12.bindInteger(3, iIntValue27);
                sQLitePreparedStatementExecuteFast12.step();
            }
            sQLitePreparedStatementExecuteFast12.dispose();
            sQLiteCursorQueryFinalized12.dispose();
            if (arrayList != null) {
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast13 = messagesStorage.database.executeFast("UPDATE dialogs SET did = ? WHERE did = ?");
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast14 = messagesStorage.database.executeFast("UPDATE dialog_filter_pin_v2 SET peer = ? WHERE peer = ?");
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast15 = messagesStorage.database.executeFast("UPDATE dialog_filter_ep SET peer = ? WHERE peer = ?");
                int size = arrayList.size();
                for (int i16 = 0; i16 < size; i16++) {
                    long jIntValue3 = ((Integer) arrayList.get(i16)).intValue();
                    long jMakeEncryptedDialogId = DialogObject.makeEncryptedDialogId(jIntValue3);
                    long j = jIntValue3 << 32;
                    sQLitePreparedStatementExecuteFast13.requery();
                    sQLitePreparedStatementExecuteFast13.bindLong(1, jMakeEncryptedDialogId);
                    sQLitePreparedStatementExecuteFast13.bindLong(2, j);
                    sQLitePreparedStatementExecuteFast13.step();
                    sQLitePreparedStatementExecuteFast14.requery();
                    sQLitePreparedStatementExecuteFast14.bindLong(1, jMakeEncryptedDialogId);
                    sQLitePreparedStatementExecuteFast14.bindLong(2, j);
                    sQLitePreparedStatementExecuteFast14.step();
                    sQLitePreparedStatementExecuteFast15.requery();
                    sQLitePreparedStatementExecuteFast15.bindLong(1, jMakeEncryptedDialogId);
                    sQLitePreparedStatementExecuteFast15.bindLong(2, j);
                    sQLitePreparedStatementExecuteFast15.step();
                }
                sQLitePreparedStatementExecuteFast13.dispose();
                sQLitePreparedStatementExecuteFast14.dispose();
                sQLitePreparedStatementExecuteFast15.dispose();
            }
            if (arrayList2 != null) {
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast16 = messagesStorage.database.executeFast("UPDATE dialogs SET did = ? WHERE did = ?");
                int size2 = arrayList2.size();
                for (int i17 = 0; i17 < size2; i17++) {
                    int iIntValue28 = ((Integer) arrayList2.get(i17)).intValue();
                    long jMakeFolderDialogId = DialogObject.makeFolderDialogId(iIntValue28);
                    sQLitePreparedStatementExecuteFast16.requery();
                    sQLitePreparedStatementExecuteFast16.bindLong(1, jMakeFolderDialogId);
                    sQLitePreparedStatementExecuteFast16.bindLong(2, 8589934592L | iIntValue28);
                    sQLitePreparedStatementExecuteFast16.step();
                }
                sQLitePreparedStatementExecuteFast16.dispose();
            }
            messagesStorage.database.executeFast("DROP INDEX IF EXISTS uid_mid_read_out_idx_messages;").stepThis().dispose();
            messagesStorage.database.executeFast("DROP INDEX IF EXISTS uid_date_mid_idx_messages;").stepThis().dispose();
            messagesStorage.database.executeFast("DROP INDEX IF EXISTS mid_out_idx_messages;").stepThis().dispose();
            messagesStorage.database.executeFast("DROP INDEX IF EXISTS task_idx_messages;").stepThis().dispose();
            messagesStorage.database.executeFast("DROP INDEX IF EXISTS send_state_idx_messages2;").stepThis().dispose();
            messagesStorage.database.executeFast("DROP INDEX IF EXISTS uid_mention_idx_messages;").stepThis().dispose();
            messagesStorage.database.executeFast("DROP TABLE IF EXISTS messages;").stepThis().dispose();
            messagesStorage.database.commitTransaction();
            messagesStorage.database.executeFast("PRAGMA user_version = 84").stepThis().dispose();
        }
        FileLog.d("MessagesStorage db migration finished");
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$Gmcd8OJaPtJmQvUEdqiOstMjnAU
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateDbToLastVersion$3$MessagesStorage();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateDbToLastVersion$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateDbToLastVersion$2$MessagesStorage() {
        this.databaseMigrationInProgress = true;
        NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.onDatabaseMigration, Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateDbToLastVersion$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateDbToLastVersion$3$MessagesStorage() {
        this.databaseMigrationInProgress = false;
        NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.onDatabaseMigration, Boolean.FALSE);
    }

    private void executeNoException(String query) {
        try {
            this.database.executeFast(query).stepThis().dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    private void cleanupInternal(boolean deleteFiles) throws IOException {
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
        if (deleteFiles) {
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

    public void cleanup(final boolean isLogin) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$wfq469yB1BLhBAjf29CXhNFpIvs
            @Override // java.lang.Runnable
            public final void run() throws Exception {
                this.f$0.lambda$cleanup$5$MessagesStorage(isLogin);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$cleanup$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$cleanup$5$MessagesStorage(boolean z) throws Exception {
        cleanupInternal(true);
        openDatabase(1);
        if (z) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$tLCd9nMRau-c7tfSKc_s9vgsCOY
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$cleanup$4$MessagesStorage();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$cleanup$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$cleanup$4$MessagesStorage() {
        getMessagesController().getDifference();
    }

    public void saveSecretParams(final int lsv, final int sg, final byte[] pbytes) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$d1Nb4HeM5Bm5zxJsBiMgxYl0or8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$saveSecretParams$6$MessagesStorage(lsv, sg, pbytes);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$saveSecretParams$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$saveSecretParams$6$MessagesStorage(int i, int i2, byte[] bArr) {
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
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$NMIsOZqFi5fbkTkw5w8jDl95BN8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$fixNotificationSettings$7$MessagesStorage();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$fixNotificationSettings$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$fixNotificationSettings$7$MessagesStorage() {
        try {
            LongSparseArray longSparseArray = new LongSparseArray();
            Map<String, ?> all = MessagesController.getNotificationsSettings(this.currentAccount).getAll();
            for (Map.Entry<String, ?> entry : all.entrySet()) {
                String key = entry.getKey();
                if (key.startsWith("notify2_")) {
                    Integer num = (Integer) entry.getValue();
                    if (num.intValue() == 2 || num.intValue() == 3) {
                        String strReplace = key.replace("notify2_", "");
                        long jIntValue = 1;
                        if (num.intValue() != 2) {
                            if (((Integer) all.get("notifyuntil_" + strReplace)) != null) {
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

    public long createPendingTask(final NativeByteBuffer data) {
        if (data == null) {
            return 0L;
        }
        final long andAdd = this.lastTaskId.getAndAdd(1L);
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$JszmzYnIPKAKlyWz0byjV2iBBNg
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createPendingTask$8$MessagesStorage(andAdd, data);
            }
        });
        return andAdd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createPendingTask$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createPendingTask$8$MessagesStorage(long j, NativeByteBuffer nativeByteBuffer) {
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

    public void removePendingTask(final long id) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$6JXqcrQo58cFm4vFxoJ_xZlsx3s
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$removePendingTask$9$MessagesStorage(id);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$removePendingTask$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$removePendingTask$9$MessagesStorage(long j) {
        try {
            this.database.executeFast("DELETE FROM pending_tasks WHERE id = " + j).stepThis().dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    private void loadPendingTasks() {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$aPybFnozGE1oBjmSO8kC8kofZnE
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadPendingTasks$29$MessagesStorage();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadPendingTasks$29, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadPendingTasks$29$MessagesStorage() {
        try {
            SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized("SELECT id, data FROM pending_tasks WHERE 1", new Object[0]);
            while (sQLiteCursorQueryFinalized.next()) {
                final long jLongValue = sQLiteCursorQueryFinalized.longValue(0);
                NativeByteBuffer nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized.byteBufferValue(1);
                if (nativeByteBufferByteBufferValue != null) {
                    int int32 = nativeByteBufferByteBufferValue.readInt32(false);
                    if (int32 != 100) {
                        switch (int32) {
                            case 0:
                                final TLRPC$Chat tLRPC$ChatTLdeserialize = TLRPC$Chat.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                                if (tLRPC$ChatTLdeserialize != null) {
                                    Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$QTbJSlEQLt--qT4E_i1oTGTTzUM
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            this.f$0.lambda$loadPendingTasks$10$MessagesStorage(tLRPC$ChatTLdeserialize, jLongValue);
                                        }
                                    });
                                    break;
                                }
                                break;
                            case 1:
                                final long int322 = nativeByteBufferByteBufferValue.readInt32(false);
                                final int int323 = nativeByteBufferByteBufferValue.readInt32(false);
                                Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$TLMqjaBAv7LFr_9YMP0-9Hgdh1w
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        this.f$0.lambda$loadPendingTasks$11$MessagesStorage(int322, int323, jLongValue);
                                    }
                                });
                                break;
                            case 2:
                            case 5:
                            case 8:
                            case 10:
                            case 14:
                                final TLRPC$TL_dialog tLRPC$TL_dialog = new TLRPC$TL_dialog();
                                tLRPC$TL_dialog.id = nativeByteBufferByteBufferValue.readInt64(false);
                                tLRPC$TL_dialog.top_message = nativeByteBufferByteBufferValue.readInt32(false);
                                tLRPC$TL_dialog.read_inbox_max_id = nativeByteBufferByteBufferValue.readInt32(false);
                                tLRPC$TL_dialog.read_outbox_max_id = nativeByteBufferByteBufferValue.readInt32(false);
                                tLRPC$TL_dialog.unread_count = nativeByteBufferByteBufferValue.readInt32(false);
                                tLRPC$TL_dialog.last_message_date = nativeByteBufferByteBufferValue.readInt32(false);
                                tLRPC$TL_dialog.pts = nativeByteBufferByteBufferValue.readInt32(false);
                                tLRPC$TL_dialog.flags = nativeByteBufferByteBufferValue.readInt32(false);
                                if (int32 >= 5) {
                                    tLRPC$TL_dialog.pinned = nativeByteBufferByteBufferValue.readBool(false);
                                    tLRPC$TL_dialog.pinnedNum = nativeByteBufferByteBufferValue.readInt32(false);
                                }
                                if (int32 >= 8) {
                                    tLRPC$TL_dialog.unread_mentions_count = nativeByteBufferByteBufferValue.readInt32(false);
                                }
                                if (int32 >= 10) {
                                    tLRPC$TL_dialog.unread_mark = nativeByteBufferByteBufferValue.readBool(false);
                                }
                                if (int32 >= 14) {
                                    tLRPC$TL_dialog.folder_id = nativeByteBufferByteBufferValue.readInt32(false);
                                }
                                final TLRPC$InputPeer tLRPC$InputPeerTLdeserialize = TLRPC$InputPeer.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$RY3-Zp-X20vbIVaXZn9_6CIP7v4
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        this.f$0.lambda$loadPendingTasks$12$MessagesStorage(tLRPC$TL_dialog, tLRPC$InputPeerTLdeserialize, jLongValue);
                                    }
                                });
                                break;
                            case 3:
                                getSendMessagesHelper().sendGame(TLRPC$InputPeer.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false), (TLRPC$TL_inputMediaGame) TLRPC$InputMedia.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false), nativeByteBufferByteBufferValue.readInt64(false), jLongValue);
                                break;
                            case 4:
                                final long int64 = nativeByteBufferByteBufferValue.readInt64(false);
                                final boolean bool = nativeByteBufferByteBufferValue.readBool(false);
                                final TLRPC$InputPeer tLRPC$InputPeerTLdeserialize2 = TLRPC$InputPeer.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$7MsCLKhnLU9xvgYlOsiFxBx5Gsc
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        this.f$0.lambda$loadPendingTasks$13$MessagesStorage(int64, bool, tLRPC$InputPeerTLdeserialize2, jLongValue);
                                    }
                                });
                                break;
                            case 6:
                                final long int324 = nativeByteBufferByteBufferValue.readInt32(false);
                                final int int325 = nativeByteBufferByteBufferValue.readInt32(false);
                                final TLRPC$InputChannel tLRPC$InputChannelTLdeserialize = TLRPC$InputChannel.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                                Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$57E4uI2votbgx0s6huFscgwElbE
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        this.f$0.lambda$loadPendingTasks$14$MessagesStorage(int324, int325, jLongValue, tLRPC$InputChannelTLdeserialize);
                                    }
                                });
                                break;
                            case 7:
                                final long int326 = nativeByteBufferByteBufferValue.readInt32(false);
                                int int327 = nativeByteBufferByteBufferValue.readInt32(false);
                                TLObject tLObjectTLdeserialize = TLRPC$TL_messages_deleteMessages.TLdeserialize(nativeByteBufferByteBufferValue, int327, false);
                                final TLObject tLObjectTLdeserialize2 = tLObjectTLdeserialize == null ? TLRPC$TL_channels_deleteMessages.TLdeserialize(nativeByteBufferByteBufferValue, int327, false) : tLObjectTLdeserialize;
                                if (tLObjectTLdeserialize2 == null) {
                                    removePendingTask(jLongValue);
                                    break;
                                } else {
                                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$5neZpQcC94Iq8RCc0750m6EwuXM
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            this.f$0.lambda$loadPendingTasks$16$MessagesStorage(int326, jLongValue, tLObjectTLdeserialize2);
                                        }
                                    });
                                    break;
                                }
                            case 9:
                                final long int642 = nativeByteBufferByteBufferValue.readInt64(false);
                                final TLRPC$InputPeer tLRPC$InputPeerTLdeserialize3 = TLRPC$InputPeer.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$lYV5Qp7hYRTzXSBTgcVpN5va-RU
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        this.f$0.lambda$loadPendingTasks$18$MessagesStorage(int642, tLRPC$InputPeerTLdeserialize3, jLongValue);
                                    }
                                });
                                break;
                            case 11:
                                final int int328 = nativeByteBufferByteBufferValue.readInt32(false);
                                final long int329 = nativeByteBufferByteBufferValue.readInt32(false);
                                final int int3210 = nativeByteBufferByteBufferValue.readInt32(false);
                                final TLRPC$InputChannel tLRPC$InputChannelTLdeserialize2 = int329 != 0 ? TLRPC$InputChannel.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false) : null;
                                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$6Gmodh71Sq6jJCkUnScigozF3Xc
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        this.f$0.lambda$loadPendingTasks$19$MessagesStorage(int329, int328, tLRPC$InputChannelTLdeserialize2, int3210, jLongValue);
                                    }
                                });
                                break;
                            case 12:
                            case 19:
                            case 20:
                                removePendingTask(jLongValue);
                                break;
                            case 13:
                                final long int643 = nativeByteBufferByteBufferValue.readInt64(false);
                                final boolean bool2 = nativeByteBufferByteBufferValue.readBool(false);
                                final int int3211 = nativeByteBufferByteBufferValue.readInt32(false);
                                final int int3212 = nativeByteBufferByteBufferValue.readInt32(false);
                                final boolean bool3 = nativeByteBufferByteBufferValue.readBool(false);
                                final TLRPC$InputPeer tLRPC$InputPeerTLdeserialize4 = TLRPC$InputPeer.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$1BtN31JMI1EXLyHo1nzox3qHtAQ
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        this.f$0.lambda$loadPendingTasks$22$MessagesStorage(int643, bool2, int3211, int3212, bool3, tLRPC$InputPeerTLdeserialize4, jLongValue);
                                    }
                                });
                                break;
                            case 15:
                                final TLRPC$InputPeer tLRPC$InputPeerTLdeserialize5 = TLRPC$InputPeer.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                                Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$5rMY5OtTQ7AScgz4rUuMxPuP3DI
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        this.f$0.lambda$loadPendingTasks$23$MessagesStorage(tLRPC$InputPeerTLdeserialize5, jLongValue);
                                    }
                                });
                                break;
                            case 16:
                                final int int3213 = nativeByteBufferByteBufferValue.readInt32(false);
                                int int3214 = nativeByteBufferByteBufferValue.readInt32(false);
                                final ArrayList arrayList = new ArrayList();
                                for (int i = 0; i < int3214; i++) {
                                    arrayList.add(TLRPC$InputDialogPeer.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false));
                                }
                                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$Ho8jvu12Q-TDOq7atgOO3tTiaC0
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        this.f$0.lambda$loadPendingTasks$24$MessagesStorage(int3213, arrayList, jLongValue);
                                    }
                                });
                                break;
                            case 17:
                                final int int3215 = nativeByteBufferByteBufferValue.readInt32(false);
                                int int3216 = nativeByteBufferByteBufferValue.readInt32(false);
                                final ArrayList arrayList2 = new ArrayList();
                                for (int i2 = 0; i2 < int3216; i2++) {
                                    arrayList2.add(TLRPC$TL_inputFolderPeer.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false));
                                }
                                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$HDZwoKmb5o0SyRXsqnoNsxLOCps
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        this.f$0.lambda$loadPendingTasks$25$MessagesStorage(int3215, arrayList2, jLongValue);
                                    }
                                });
                                break;
                            case 18:
                                final long int644 = nativeByteBufferByteBufferValue.readInt64(false);
                                nativeByteBufferByteBufferValue.readInt32(false);
                                final TLRPC$TL_messages_deleteScheduledMessages tLRPC$TL_messages_deleteScheduledMessagesTLdeserialize = TLRPC$TL_messages_deleteScheduledMessages.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                                if (tLRPC$TL_messages_deleteScheduledMessagesTLdeserialize == null) {
                                    removePendingTask(jLongValue);
                                    break;
                                } else {
                                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$fvQu6vCUrinxqJ0SarvqwpCwmyg
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            this.f$0.lambda$loadPendingTasks$26$MessagesStorage(int644, jLongValue, tLRPC$TL_messages_deleteScheduledMessagesTLdeserialize);
                                        }
                                    });
                                    break;
                                }
                            case 21:
                                final Theme.OverrideWallpaperInfo overrideWallpaperInfo = new Theme.OverrideWallpaperInfo();
                                nativeByteBufferByteBufferValue.readInt64(false);
                                overrideWallpaperInfo.isBlurred = nativeByteBufferByteBufferValue.readBool(false);
                                overrideWallpaperInfo.isMotion = nativeByteBufferByteBufferValue.readBool(false);
                                overrideWallpaperInfo.color = nativeByteBufferByteBufferValue.readInt32(false);
                                overrideWallpaperInfo.gradientColor1 = nativeByteBufferByteBufferValue.readInt32(false);
                                overrideWallpaperInfo.rotation = nativeByteBufferByteBufferValue.readInt32(false);
                                overrideWallpaperInfo.intensity = (float) nativeByteBufferByteBufferValue.readDouble(false);
                                final boolean bool4 = nativeByteBufferByteBufferValue.readBool(false);
                                overrideWallpaperInfo.slug = nativeByteBufferByteBufferValue.readString(false);
                                overrideWallpaperInfo.originalFileName = nativeByteBufferByteBufferValue.readString(false);
                                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$x8lKcSavVw5uEKKgkcR5jgrGr1o
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        this.f$0.lambda$loadPendingTasks$21$MessagesStorage(overrideWallpaperInfo, bool4, jLongValue);
                                    }
                                });
                                break;
                            case 22:
                                final TLRPC$InputPeer tLRPC$InputPeerTLdeserialize6 = TLRPC$InputPeer.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$kttr9MYDmLugIDRG2-8sHS3qSPI
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        this.f$0.lambda$loadPendingTasks$27$MessagesStorage(tLRPC$InputPeerTLdeserialize6, jLongValue);
                                    }
                                });
                                break;
                            case 23:
                                final long int645 = nativeByteBufferByteBufferValue.readInt64(false);
                                final int int3217 = nativeByteBufferByteBufferValue.readInt32(false);
                                final int int3218 = nativeByteBufferByteBufferValue.readInt32(false);
                                final TLRPC$InputChannel tLRPC$InputChannelTLdeserialize3 = (!DialogObject.isEncryptedDialog(int645) && DialogObject.isChatDialog(int645) && nativeByteBufferByteBufferValue.hasRemaining()) ? TLRPC$InputChannel.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false) : null;
                                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$cdp-p36RpZ9VIlfMIpFj-ZWQA6s
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        this.f$0.lambda$loadPendingTasks$20$MessagesStorage(int645, int3217, tLRPC$InputChannelTLdeserialize3, int3218, jLongValue);
                                    }
                                });
                                break;
                            case 24:
                                final long int646 = nativeByteBufferByteBufferValue.readInt64(false);
                                int int3219 = nativeByteBufferByteBufferValue.readInt32(false);
                                TLObject tLObjectTLdeserialize3 = TLRPC$TL_messages_deleteMessages.TLdeserialize(nativeByteBufferByteBufferValue, int3219, false);
                                final TLObject tLObjectTLdeserialize4 = tLObjectTLdeserialize3 == null ? TLRPC$TL_channels_deleteMessages.TLdeserialize(nativeByteBufferByteBufferValue, int3219, false) : tLObjectTLdeserialize3;
                                if (tLObjectTLdeserialize4 == null) {
                                    removePendingTask(jLongValue);
                                    break;
                                } else {
                                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$0CAvXRUj5uG-T93oq-IYItj9qRY
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            this.f$0.lambda$loadPendingTasks$17$MessagesStorage(int646, jLongValue, tLObjectTLdeserialize4);
                                        }
                                    });
                                    break;
                                }
                            case 25:
                                final long int647 = nativeByteBufferByteBufferValue.readInt64(false);
                                final int int3220 = nativeByteBufferByteBufferValue.readInt32(false);
                                final TLRPC$InputChannel tLRPC$InputChannelTLdeserialize4 = TLRPC$InputChannel.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                                Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$yl86YNTk-vKWuCU6IxWYATV5dW0
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        this.f$0.lambda$loadPendingTasks$15$MessagesStorage(int647, int3220, jLongValue, tLRPC$InputChannelTLdeserialize4);
                                    }
                                });
                                break;
                        }
                    } else {
                        final int int3221 = nativeByteBufferByteBufferValue.readInt32(false);
                        final boolean bool5 = nativeByteBufferByteBufferValue.readBool(false);
                        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$KHwyGAHlbXR2xi9OQUswA-moTzg
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$loadPendingTasks$28$MessagesStorage(int3221, bool5, jLongValue);
                            }
                        });
                    }
                    nativeByteBufferByteBufferValue.reuse();
                }
            }
            sQLiteCursorQueryFinalized.dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadPendingTasks$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadPendingTasks$10$MessagesStorage(TLRPC$Chat tLRPC$Chat, long j) {
        getMessagesController().loadUnknownChannel(tLRPC$Chat, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadPendingTasks$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadPendingTasks$11$MessagesStorage(long j, int i, long j2) {
        getMessagesController().getChannelDifference(j, i, j2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadPendingTasks$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadPendingTasks$12$MessagesStorage(TLRPC$Dialog tLRPC$Dialog, TLRPC$InputPeer tLRPC$InputPeer, long j) {
        getMessagesController().checkLastDialogMessage(tLRPC$Dialog, tLRPC$InputPeer, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadPendingTasks$13, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadPendingTasks$13$MessagesStorage(long j, boolean z, TLRPC$InputPeer tLRPC$InputPeer, long j2) {
        getMessagesController().pinDialog(j, z, tLRPC$InputPeer, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadPendingTasks$14, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadPendingTasks$14$MessagesStorage(long j, int i, long j2, TLRPC$InputChannel tLRPC$InputChannel) {
        getMessagesController().getChannelDifference(j, i, j2, tLRPC$InputChannel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadPendingTasks$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadPendingTasks$15$MessagesStorage(long j, int i, long j2, TLRPC$InputChannel tLRPC$InputChannel) {
        getMessagesController().getChannelDifference(j, i, j2, tLRPC$InputChannel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadPendingTasks$16, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadPendingTasks$16$MessagesStorage(long j, long j2, TLObject tLObject) {
        getMessagesController().deleteMessages(null, null, null, -j, true, false, false, j2, tLObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadPendingTasks$17, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadPendingTasks$17$MessagesStorage(long j, long j2, TLObject tLObject) {
        getMessagesController().deleteMessages(null, null, null, j, true, false, false, j2, tLObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadPendingTasks$18, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadPendingTasks$18$MessagesStorage(long j, TLRPC$InputPeer tLRPC$InputPeer, long j2) {
        getMessagesController().markDialogAsUnread(j, tLRPC$InputPeer, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadPendingTasks$19, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadPendingTasks$19$MessagesStorage(long j, int i, TLRPC$InputChannel tLRPC$InputChannel, int i2, long j2) {
        getMessagesController().markMessageAsRead2(-j, i, tLRPC$InputChannel, i2, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadPendingTasks$20, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadPendingTasks$20$MessagesStorage(long j, int i, TLRPC$InputChannel tLRPC$InputChannel, int i2, long j2) {
        getMessagesController().markMessageAsRead2(j, i, tLRPC$InputChannel, i2, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadPendingTasks$21, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadPendingTasks$21$MessagesStorage(Theme.OverrideWallpaperInfo overrideWallpaperInfo, boolean z, long j) {
        getMessagesController().saveWallpaperToServer(null, overrideWallpaperInfo, z, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadPendingTasks$22, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadPendingTasks$22$MessagesStorage(long j, boolean z, int i, int i2, boolean z2, TLRPC$InputPeer tLRPC$InputPeer, long j2) {
        getMessagesController().deleteDialog(j, z ? 1 : 0, i, i2, z2, tLRPC$InputPeer, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadPendingTasks$23, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadPendingTasks$23$MessagesStorage(TLRPC$InputPeer tLRPC$InputPeer, long j) {
        getMessagesController().loadUnknownDialog(tLRPC$InputPeer, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadPendingTasks$24, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadPendingTasks$24$MessagesStorage(int i, ArrayList arrayList, long j) {
        getMessagesController().reorderPinnedDialogs(i, arrayList, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadPendingTasks$25, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadPendingTasks$25$MessagesStorage(int i, ArrayList arrayList, long j) {
        getMessagesController().addDialogToFolder(null, i, -1, arrayList, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadPendingTasks$26, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadPendingTasks$26$MessagesStorage(long j, long j2, TLObject tLObject) {
        getMessagesController().deleteMessages(null, null, null, j, true, true, false, j2, tLObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadPendingTasks$27, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadPendingTasks$27$MessagesStorage(TLRPC$InputPeer tLRPC$InputPeer, long j) {
        getMessagesController().reloadMentionsCountForChannel(tLRPC$InputPeer, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadPendingTasks$28, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadPendingTasks$28$MessagesStorage(int i, boolean z, long j) {
        getSecretChatHelper().declineSecretChat(i, z, j);
    }

    public void saveChannelPts(final long channelId, final int pts) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$-7pDq04tBfxmHvPiypwQeAtzBdg
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$saveChannelPts$30$MessagesStorage(pts, channelId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$saveChannelPts$30, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$saveChannelPts$30$MessagesStorage(int i, long j) {
        try {
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("UPDATE dialogs SET pts = ? WHERE did = ?");
            sQLitePreparedStatementExecuteFast.bindInteger(1, i);
            sQLitePreparedStatementExecuteFast.bindLong(2, -j);
            sQLitePreparedStatementExecuteFast.step();
            sQLitePreparedStatementExecuteFast.dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: saveDiffParamsInternal, reason: merged with bridge method [inline-methods] */
    public void lambda$saveDiffParams$31$MessagesStorage(int seq, int pts, int date, int qts) {
        try {
            if (this.lastSavedSeq == seq && this.lastSavedPts == pts && this.lastSavedDate == date && this.lastQtsValue == qts) {
                return;
            }
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("UPDATE params SET seq = ?, pts = ?, date = ?, qts = ? WHERE id = 1");
            sQLitePreparedStatementExecuteFast.bindInteger(1, seq);
            sQLitePreparedStatementExecuteFast.bindInteger(2, pts);
            sQLitePreparedStatementExecuteFast.bindInteger(3, date);
            sQLitePreparedStatementExecuteFast.bindInteger(4, qts);
            sQLitePreparedStatementExecuteFast.step();
            sQLitePreparedStatementExecuteFast.dispose();
            this.lastSavedSeq = seq;
            this.lastSavedPts = pts;
            this.lastSavedDate = date;
            this.lastSavedQts = qts;
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void saveDiffParams(final int seq, final int pts, final int date, final int qts) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$g6GsBEF4FgVLDJKpxdHi3aBWR5w
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$saveDiffParams$31$MessagesStorage(seq, pts, date, qts);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateMutedDialogsFiltersCounters$32, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateMutedDialogsFiltersCounters$32$MessagesStorage() {
        resetAllUnreadCounters(true);
    }

    public void updateMutedDialogsFiltersCounters() {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$1EUR6hQQ0vHp0Qr741KDI56GM3k
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateMutedDialogsFiltersCounters$32$MessagesStorage();
            }
        });
    }

    public void setDialogFlags(final long did, final long flags) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$brtNDmeHuayA2gnpQbhaO1ct_-0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setDialogFlags$33$MessagesStorage(did, flags);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setDialogFlags$33, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setDialogFlags$33$MessagesStorage(long j, long j2) {
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

    public void setDialogNotificationFlags(long did, long flags) {
        if (getMessagesController().isLockedDialog(Long.valueOf(did))) {
            flags |= 1048576;
        }
        setDialogFlags(did, flags);
    }

    public void putPushMessage(final MessageObject message) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$JQZIg8eqP9Hoe7rHzaC01npDMuU
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$putPushMessage$34$MessagesStorage(message);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$putPushMessage$34, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$putPushMessage$34$MessagesStorage(MessageObject messageObject) {
        try {
            NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(messageObject.messageOwner.getObjectSize());
            messageObject.messageOwner.serializeToStream(nativeByteBuffer);
            int i = messageObject.localType == 2 ? 1 : 0;
            if (messageObject.localChannel) {
                i |= 2;
            }
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("REPLACE INTO unread_push_messages VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
            sQLitePreparedStatementExecuteFast.requery();
            sQLitePreparedStatementExecuteFast.bindLong(1, messageObject.getDialogId());
            sQLitePreparedStatementExecuteFast.bindInteger(2, messageObject.getId());
            sQLitePreparedStatementExecuteFast.bindLong(3, messageObject.messageOwner.random_id);
            sQLitePreparedStatementExecuteFast.bindInteger(4, messageObject.messageOwner.date);
            sQLitePreparedStatementExecuteFast.bindByteBuffer(5, nativeByteBuffer);
            CharSequence charSequence = messageObject.messageText;
            if (charSequence == null) {
                sQLitePreparedStatementExecuteFast.bindNull(6);
            } else {
                sQLitePreparedStatementExecuteFast.bindString(6, charSequence.toString());
            }
            String str = messageObject.localName;
            if (str == null) {
                sQLitePreparedStatementExecuteFast.bindNull(7);
            } else {
                sQLitePreparedStatementExecuteFast.bindString(7, str);
            }
            String str2 = messageObject.localUserName;
            if (str2 == null) {
                sQLitePreparedStatementExecuteFast.bindNull(8);
            } else {
                sQLitePreparedStatementExecuteFast.bindString(8, str2);
            }
            sQLitePreparedStatementExecuteFast.bindInteger(9, i);
            sQLitePreparedStatementExecuteFast.step();
            nativeByteBuffer.reuse();
            sQLitePreparedStatementExecuteFast.dispose();
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

    public void readAllDialogs(final int folderId) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$jozbNC_ykpXdXSvrvwqtaLAtx8o
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$readAllDialogs$36$MessagesStorage(folderId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$readAllDialogs$36, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$readAllDialogs$36$MessagesStorage(int i) {
        SQLiteCursor sQLiteCursorQueryFinalized;
        try {
            ArrayList<Long> arrayList = new ArrayList<>();
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
                    if (!DialogObject.isEncryptedDialog(jLongValue)) {
                        if (DialogObject.isChatDialog(jLongValue)) {
                            long j = -jLongValue;
                            if (!arrayList2.contains(Long.valueOf(j))) {
                                arrayList2.add(Long.valueOf(j));
                            }
                        } else if (!arrayList.contains(Long.valueOf(jLongValue))) {
                            arrayList.add(Long.valueOf(jLongValue));
                        }
                    } else {
                        int encryptedChatId = DialogObject.getEncryptedChatId(jLongValue);
                        if (!arrayList3.contains(Integer.valueOf(encryptedChatId))) {
                            arrayList3.add(Integer.valueOf(encryptedChatId));
                        }
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
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$rQOYsjrWgC83XV7g_e5iJ-xg6lA
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$readAllDialogs$35$MessagesStorage(arrayList4, arrayList5, arrayList6, longSparseArray);
                }
            });
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$readAllDialogs$35, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$readAllDialogs$35$MessagesStorage(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, LongSparseArray longSparseArray) {
        getMessagesController().putUsers(arrayList, true);
        getMessagesController().putChats(arrayList2, true);
        getMessagesController().putEncryptedChats(arrayList3, true);
        for (int i = 0; i < longSparseArray.size(); i++) {
            long jKeyAt = longSparseArray.keyAt(i);
            ReadDialog readDialog = (ReadDialog) longSparseArray.valueAt(i);
            MessagesController messagesController = getMessagesController();
            int i2 = readDialog.lastMid;
            messagesController.markDialogAsRead(jKeyAt, i2, i2, readDialog.date, false, 0, readDialog.unreadCount, true, 0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0198  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private ir.eitaa.tgnet.TLRPC$messages_Dialogs loadDialogsByIds(java.lang.String r17, java.util.ArrayList<java.lang.Long> r18, java.util.ArrayList<java.lang.Long> r19, java.util.ArrayList<java.lang.Integer> r20) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 593
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessagesStorage.loadDialogsByIds(java.lang.String, java.util.ArrayList, java.util.ArrayList, java.util.ArrayList):ir.eitaa.tgnet.TLRPC$messages_Dialogs");
    }

    private void loadDialogFilters() {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$32kiydLYHb6qr9d-wR9pa4oBeHA
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadDialogFilters$38$MessagesStorage();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadDialogFilters$38, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadDialogFilters$38$MessagesStorage() {
        TLRPC$messages_Dialogs tLRPC$TL_messages_dialogs;
        SQLiteCursor sQLiteCursorQueryFinalized;
        try {
            ArrayList<Long> arrayList = new ArrayList<>();
            ArrayList<Long> arrayList2 = new ArrayList<>();
            ArrayList<Integer> arrayList3 = new ArrayList<>();
            ArrayList arrayList4 = new ArrayList();
            SparseArray sparseArray = new SparseArray();
            arrayList.add(Long.valueOf(getUserConfig().getClientUserId()));
            int i = 0;
            SQLiteCursor sQLiteCursorQueryFinalized2 = this.database.queryFinalized("SELECT id, ord, unread_count, flags, title FROM dialog_filter WHERE 1", new Object[0]);
            boolean z = false;
            while (sQLiteCursorQueryFinalized2.next()) {
                MessagesController.DialogFilter dialogFilter = new MessagesController.DialogFilter();
                dialogFilter.id = sQLiteCursorQueryFinalized2.intValue(i);
                dialogFilter.order = sQLiteCursorQueryFinalized2.intValue(1);
                dialogFilter.unreadCount = -1;
                dialogFilter.pendingUnreadCount = -1;
                dialogFilter.flags = sQLiteCursorQueryFinalized2.intValue(3);
                dialogFilter.name = sQLiteCursorQueryFinalized2.stringValue(4);
                this.dialogFilters.add(dialogFilter);
                this.dialogFiltersMap.put(dialogFilter.id, dialogFilter);
                sparseArray.put(dialogFilter.id, dialogFilter);
                if (dialogFilter.pendingUnreadCount < 0) {
                    z = true;
                }
                int i2 = 0;
                while (i2 < 2) {
                    if (i2 == 0) {
                        sQLiteCursorQueryFinalized = this.database.queryFinalized("SELECT peer, pin FROM dialog_filter_pin_v2 WHERE id = " + dialogFilter.id, new Object[i]);
                    } else {
                        sQLiteCursorQueryFinalized = this.database.queryFinalized("SELECT peer FROM dialog_filter_ep WHERE id = " + dialogFilter.id, new Object[i]);
                    }
                    while (sQLiteCursorQueryFinalized.next()) {
                        long jLongValue = sQLiteCursorQueryFinalized.longValue(i);
                        if (i2 == 0) {
                            if (!DialogObject.isEncryptedDialog(jLongValue)) {
                                dialogFilter.alwaysShow.add(Long.valueOf(jLongValue));
                            }
                            int iIntValue = sQLiteCursorQueryFinalized.intValue(1);
                            if (iIntValue != Integer.MIN_VALUE) {
                                dialogFilter.pinnedDialogs.put(jLongValue, iIntValue);
                                if (!arrayList4.contains(Long.valueOf(jLongValue))) {
                                    arrayList4.add(Long.valueOf(jLongValue));
                                }
                            }
                        } else if (!DialogObject.isEncryptedDialog(jLongValue)) {
                            dialogFilter.neverShow.add(Long.valueOf(jLongValue));
                        }
                        if (DialogObject.isChatDialog(jLongValue)) {
                            long j = -jLongValue;
                            if (!arrayList2.contains(Long.valueOf(j))) {
                                arrayList2.add(Long.valueOf(j));
                            }
                        } else if (DialogObject.isUserDialog(jLongValue)) {
                            if (!arrayList.contains(Long.valueOf(jLongValue))) {
                                arrayList.add(Long.valueOf(jLongValue));
                            }
                        } else {
                            int encryptedChatId = DialogObject.getEncryptedChatId(jLongValue);
                            if (!arrayList3.contains(Integer.valueOf(encryptedChatId))) {
                                arrayList3.add(Integer.valueOf(encryptedChatId));
                            }
                        }
                        i = 0;
                    }
                    sQLiteCursorQueryFinalized.dispose();
                    i2++;
                    i = 0;
                }
            }
            sQLiteCursorQueryFinalized2.dispose();
            Collections.sort(this.dialogFilters, $$Lambda$MessagesStorage$7ZGCkmcU4zIyf0f6YoiQWNUB3UA.INSTANCE);
            if (z) {
                calcUnreadCounters(true);
            }
            if (!arrayList4.isEmpty()) {
                tLRPC$TL_messages_dialogs = loadDialogsByIds(TextUtils.join(",", arrayList4), arrayList, arrayList2, arrayList3);
            } else {
                tLRPC$TL_messages_dialogs = new TLRPC$TL_messages_dialogs();
            }
            TLRPC$messages_Dialogs tLRPC$messages_Dialogs = tLRPC$TL_messages_dialogs;
            ArrayList<TLRPC$User> arrayList5 = new ArrayList<>();
            ArrayList<TLRPC$Chat> arrayList6 = new ArrayList<>();
            ArrayList<TLRPC$EncryptedChat> arrayList7 = new ArrayList<>();
            if (!arrayList3.isEmpty()) {
                getEncryptedChatsInternal(TextUtils.join(",", arrayList3), arrayList7, arrayList);
            }
            if (!arrayList.isEmpty()) {
                getUsersInternal(TextUtils.join(",", arrayList), arrayList5);
            }
            if (!arrayList2.isEmpty()) {
                getChatsInternal(TextUtils.join(",", arrayList2), arrayList6);
            }
            getMessagesController().processLoadedDialogFilters(new ArrayList<>(this.dialogFilters), tLRPC$messages_Dialogs, null, arrayList5, arrayList6, arrayList7, 0);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    static /* synthetic */ int lambda$loadDialogFilters$37(MessagesController.DialogFilter dialogFilter, MessagesController.DialogFilter dialogFilter2) {
        int i = dialogFilter.order;
        int i2 = dialogFilter2.order;
        if (i > i2) {
            return 1;
        }
        return i < i2 ? -1 : 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:247:0x05a7 A[PHI: r6
      0x05a7: PHI (r6v14 int) = (r6v13 int), (r6v25 int) binds: [B:236:0x0574, B:243:0x0591] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:249:0x05aa A[Catch: Exception -> 0x07e9, TryCatch #0 {Exception -> 0x07e9, blocks: (B:7:0x000a, B:8:0x003d, B:9:0x0040, B:10:0x0077, B:12:0x007e, B:18:0x00a5, B:20:0x00b0, B:21:0x00b9, B:23:0x00c2, B:25:0x00d0, B:26:0x00d8, B:28:0x00de, B:30:0x00e8, B:31:0x00f0, B:33:0x00fb, B:35:0x0106, B:38:0x012f, B:40:0x013d, B:42:0x015f, B:46:0x0174, B:47:0x017b, B:49:0x017f, B:57:0x01a8, B:59:0x01c3, B:60:0x01cc, B:50:0x018a, B:52:0x018e, B:55:0x0193, B:56:0x019e, B:61:0x01e2, B:63:0x01f1, B:65:0x0208, B:67:0x0216, B:68:0x022a, B:70:0x0233, B:91:0x02cc, B:73:0x024b, B:75:0x0260, B:79:0x0273, B:80:0x027a, B:82:0x027e, B:85:0x0283, B:87:0x0298, B:89:0x02b3, B:90:0x02bc, B:86:0x028e, B:94:0x02dd, B:96:0x02e5, B:98:0x02f5, B:100:0x0301, B:103:0x0309, B:105:0x031d, B:110:0x032d, B:113:0x0338, B:114:0x0340, B:116:0x0346, B:118:0x034a, B:120:0x0358, B:122:0x036d, B:124:0x0389, B:125:0x0392, B:127:0x0396, B:129:0x039a, B:132:0x03a8, B:134:0x03c2, B:131:0x039e, B:121:0x0363, B:133:0x03b0, B:135:0x03c8, B:136:0x03d1, B:139:0x03d7, B:142:0x03e9, B:148:0x03f8, B:150:0x03fd, B:152:0x0402, B:154:0x040f, B:157:0x0419, B:159:0x041e, B:161:0x042c, B:163:0x0433, B:165:0x0438, B:167:0x043d, B:169:0x044a, B:170:0x0450, B:172:0x0455, B:174:0x0463, B:175:0x0468, B:177:0x046d, B:179:0x0472, B:181:0x047f, B:182:0x0485, B:184:0x048a, B:186:0x0498, B:187:0x049d, B:189:0x04a2, B:191:0x04a7, B:193:0x04b4, B:194:0x04ba, B:196:0x04bf, B:198:0x04cd, B:199:0x04d2, B:201:0x04d7, B:203:0x04dc, B:205:0x04e9, B:206:0x04ef, B:208:0x04f4, B:210:0x0502, B:211:0x0507, B:213:0x050c, B:215:0x0511, B:217:0x051e, B:218:0x0524, B:220:0x0529, B:222:0x0537, B:223:0x053c, B:225:0x0541, B:227:0x0546, B:229:0x0553, B:230:0x0559, B:232:0x055e, B:234:0x056c, B:235:0x0571, B:237:0x0576, B:239:0x057b, B:241:0x0588, B:242:0x058e, B:244:0x0593, B:246:0x05a1, B:249:0x05aa, B:251:0x05b4, B:259:0x05d3, B:266:0x05ec, B:268:0x05f0, B:276:0x0601, B:278:0x0604, B:292:0x062e, B:280:0x0609, B:282:0x060e, B:284:0x0618, B:286:0x061d, B:288:0x0622, B:269:0x05f3, B:271:0x05f7, B:274:0x05fc, B:275:0x05ff, B:263:0x05e2, B:319:0x068f, B:294:0x063b, B:296:0x064a, B:298:0x0650, B:300:0x0654, B:302:0x0659, B:304:0x065c, B:306:0x0661, B:308:0x0666, B:310:0x0671, B:318:0x068d, B:314:0x067f, B:316:0x0684, B:301:0x0657, B:320:0x069a, B:322:0x06a7, B:330:0x06c4, B:337:0x06d9, B:339:0x06dd, B:347:0x06ee, B:349:0x06f1, B:351:0x06f6, B:355:0x0705, B:357:0x070a, B:359:0x0712, B:365:0x073a, B:361:0x0719, B:363:0x0730, B:340:0x06e0, B:342:0x06e4, B:345:0x06e9, B:346:0x06ec, B:334:0x06d1, B:391:0x07af, B:367:0x074f, B:369:0x0761, B:371:0x0767, B:373:0x076b, B:375:0x0770, B:377:0x0773, B:379:0x0778, B:381:0x0781, B:383:0x0786, B:385:0x078f, B:387:0x079a, B:388:0x079d, B:374:0x076e, B:392:0x07bc, B:394:0x07c5, B:398:0x07d0, B:400:0x07d4, B:401:0x07d7, B:403:0x07db, B:405:0x07df, B:143:0x03ec, B:145:0x03f1, B:146:0x03f3, B:147:0x03f5), top: B:410:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:396:0x07ca  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x02d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void calcUnreadCounters(boolean r26) {
        /*
            Method dump skipped, instructions count: 2030
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessagesStorage.calcUnreadCounters(boolean):void");
    }

    private void saveDialogFilterInternal(MessagesController.DialogFilter filter, boolean atBegin, boolean peers) {
        try {
            if (!this.dialogFilters.contains(filter)) {
                if (atBegin) {
                    this.dialogFilters.add(0, filter);
                } else {
                    this.dialogFilters.add(filter);
                }
                this.dialogFiltersMap.put(filter.id, filter);
            }
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("REPLACE INTO dialog_filter VALUES(?, ?, ?, ?, ?)");
            sQLitePreparedStatementExecuteFast.bindInteger(1, filter.id);
            sQLitePreparedStatementExecuteFast.bindInteger(2, filter.order);
            sQLitePreparedStatementExecuteFast.bindInteger(3, filter.unreadCount);
            sQLitePreparedStatementExecuteFast.bindInteger(4, filter.flags);
            sQLitePreparedStatementExecuteFast.bindString(5, filter.name);
            sQLitePreparedStatementExecuteFast.step();
            sQLitePreparedStatementExecuteFast.dispose();
            if (peers) {
                this.database.executeFast("DELETE FROM dialog_filter_ep WHERE id = " + filter.id).stepThis().dispose();
                this.database.executeFast("DELETE FROM dialog_filter_pin_v2 WHERE id = " + filter.id).stepThis().dispose();
                this.database.beginTransaction();
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast2 = this.database.executeFast("REPLACE INTO dialog_filter_pin_v2 VALUES(?, ?, ?)");
                int size = filter.alwaysShow.size();
                for (int i = 0; i < size; i++) {
                    long jLongValue = filter.alwaysShow.get(i).longValue();
                    sQLitePreparedStatementExecuteFast2.requery();
                    sQLitePreparedStatementExecuteFast2.bindInteger(1, filter.id);
                    sQLitePreparedStatementExecuteFast2.bindLong(2, jLongValue);
                    sQLitePreparedStatementExecuteFast2.bindInteger(3, filter.pinnedDialogs.get(jLongValue, Integer.MIN_VALUE));
                    sQLitePreparedStatementExecuteFast2.step();
                }
                int size2 = filter.pinnedDialogs.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    long jKeyAt = filter.pinnedDialogs.keyAt(i2);
                    sQLitePreparedStatementExecuteFast2.requery();
                    sQLitePreparedStatementExecuteFast2.bindInteger(1, filter.id);
                    sQLitePreparedStatementExecuteFast2.bindLong(2, jKeyAt);
                    sQLitePreparedStatementExecuteFast2.bindInteger(3, filter.pinnedDialogs.valueAt(i2));
                    sQLitePreparedStatementExecuteFast2.step();
                }
                sQLitePreparedStatementExecuteFast2.dispose();
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast3 = this.database.executeFast("REPLACE INTO dialog_filter_ep VALUES(?, ?)");
                int size3 = filter.neverShow.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    sQLitePreparedStatementExecuteFast3.requery();
                    sQLitePreparedStatementExecuteFast3.bindInteger(1, filter.id);
                    sQLitePreparedStatementExecuteFast3.bindLong(2, filter.neverShow.get(i3).longValue());
                    sQLitePreparedStatementExecuteFast3.step();
                }
                sQLitePreparedStatementExecuteFast3.dispose();
                this.database.commitTransaction();
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void checkLoadedRemoteFilters(final TLRPC$Vector vector) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$5jy6UbQZJuTeBtVpwy0rLsLEMlQ
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$checkLoadedRemoteFilters$39$MessagesStorage(vector);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkLoadedRemoteFilters$39, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkLoadedRemoteFilters$39$MessagesStorage(TLRPC$Vector tLRPC$Vector) {
        MessagesStorage messagesStorage;
        TLRPC$messages_Dialogs tLRPC$messages_DialogsLoadDialogsByIds;
        ArrayList<Integer> arrayList;
        int i;
        int i2;
        SparseArray<MessagesController.DialogFilter> sparseArray;
        ArrayList<Long> arrayList2;
        HashMap<Long, TLRPC$InputPeer> map;
        HashMap<Long, TLRPC$InputPeer> map2;
        ArrayList arrayList3;
        HashMap<Integer, HashSet<Long>> map3;
        HashMap<Integer, HashSet<Long>> map4;
        HashSet<Integer> hashSet;
        HashMap<Long, TLRPC$InputPeer> map5;
        HashMap<Integer, HashSet<Long>> map6;
        HashMap<Integer, HashSet<Long>> map7;
        Long lValueOf;
        int i3;
        ArrayList arrayList4;
        boolean z;
        boolean z2;
        boolean z3;
        HashMap<Integer, HashSet<Long>> map8;
        boolean z4;
        HashSet<Integer> hashSet2;
        ArrayList<Long> arrayList5;
        HashMap<Long, TLRPC$InputPeer> map9;
        ArrayList<MessagesController.DialogFilter> arrayList6;
        HashMap<Integer, HashSet<Long>> map10;
        HashMap<Long, TLRPC$InputPeer> map11;
        HashMap<Long, TLRPC$InputPeer> map12;
        HashMap<Long, TLRPC$InputPeer> map13;
        ArrayList<Long> arrayList7;
        Long lValueOf2;
        MessagesStorage messagesStorage2 = this;
        TLRPC$Vector tLRPC$Vector2 = tLRPC$Vector;
        try {
            SparseArray<MessagesController.DialogFilter> sparseArray2 = new SparseArray<>();
            int size = messagesStorage2.dialogFilters.size();
            for (int i4 = 0; i4 < size; i4++) {
                MessagesController.DialogFilter dialogFilter = messagesStorage2.dialogFilters.get(i4);
                sparseArray2.put(dialogFilter.id, dialogFilter);
            }
            ArrayList<Integer> arrayList8 = new ArrayList<>();
            ArrayList<Long> arrayList9 = new ArrayList<>();
            HashMap<Long, TLRPC$InputPeer> map14 = new HashMap<>();
            ArrayList<Long> arrayList10 = new ArrayList<>();
            HashMap<Long, TLRPC$InputPeer> map15 = new HashMap<>();
            ArrayList arrayList11 = new ArrayList();
            HashMap<Long, TLRPC$InputPeer> map16 = new HashMap<>();
            ArrayList<MessagesController.DialogFilter> arrayList12 = new ArrayList<>();
            HashMap<Integer, HashSet<Long>> map17 = new HashMap<>();
            HashMap<Integer, HashSet<Long>> map18 = new HashMap<>();
            HashSet<Integer> hashSet3 = new HashSet<>();
            int size2 = tLRPC$Vector2.objects.size();
            int i5 = 0;
            while (i5 < size2) {
                int i6 = size2;
                TLRPC$TL_dialogFilter tLRPC$TL_dialogFilter = (TLRPC$TL_dialogFilter) tLRPC$Vector2.objects.get(i5);
                arrayList8.add(Integer.valueOf(tLRPC$TL_dialogFilter.id));
                if (tLRPC$TL_dialogFilter.contacts) {
                    i = MessagesController.DIALOG_FILTER_FLAG_CONTACTS | 0;
                    arrayList = arrayList8;
                } else {
                    arrayList = arrayList8;
                    i = 0;
                }
                if (tLRPC$TL_dialogFilter.non_contacts) {
                    i |= MessagesController.DIALOG_FILTER_FLAG_NON_CONTACTS;
                }
                if (tLRPC$TL_dialogFilter.groups) {
                    i |= MessagesController.DIALOG_FILTER_FLAG_GROUPS;
                }
                if (tLRPC$TL_dialogFilter.broadcasts) {
                    i |= MessagesController.DIALOG_FILTER_FLAG_CHANNELS;
                }
                if (tLRPC$TL_dialogFilter.bots) {
                    i |= MessagesController.DIALOG_FILTER_FLAG_BOTS;
                }
                if (tLRPC$TL_dialogFilter.admin) {
                    i |= MessagesController.DIALOG_FILTER_FLAG_ADMIN;
                }
                if (tLRPC$TL_dialogFilter.favourite) {
                    i |= MessagesController.DIALOG_FILTER_FLAG_FAVORITE;
                }
                if (tLRPC$TL_dialogFilter.media_channel) {
                    i |= MessagesController.DIALOG_FILTER_FLAG_MEDIA_CHANNEL;
                }
                if (tLRPC$TL_dialogFilter.exclude_muted) {
                    i |= MessagesController.DIALOG_FILTER_FLAG_EXCLUDE_MUTED;
                }
                if (tLRPC$TL_dialogFilter.exclude_read) {
                    i |= MessagesController.DIALOG_FILTER_FLAG_EXCLUDE_READ;
                }
                if (tLRPC$TL_dialogFilter.exclude_archived) {
                    i |= MessagesController.DIALOG_FILTER_FLAG_EXCLUDE_ARCHIVED;
                }
                MessagesController.DialogFilter dialogFilter2 = messagesStorage2.dialogFiltersMap.get(tLRPC$TL_dialogFilter.id);
                if (dialogFilter2 != null) {
                    sparseArray2.remove(tLRPC$TL_dialogFilter.id);
                    sparseArray = sparseArray2;
                    if (TextUtils.equals(dialogFilter2.name, tLRPC$TL_dialogFilter.title)) {
                        z = false;
                    } else {
                        dialogFilter2.name = tLRPC$TL_dialogFilter.title;
                        z = true;
                    }
                    if (dialogFilter2.flags != i) {
                        dialogFilter2.flags = i;
                        z2 = true;
                        z = true;
                    } else {
                        z2 = false;
                    }
                    boolean z5 = z2;
                    HashSet<Long> hashSet4 = new HashSet<>(dialogFilter2.alwaysShow);
                    hashSet4.addAll(dialogFilter2.neverShow);
                    HashSet<Long> hashSet5 = new HashSet<>();
                    i2 = i5;
                    boolean z6 = z;
                    int i7 = 2;
                    int i8 = 0;
                    while (i8 < i7) {
                        ArrayList<TLRPC$InputPeer> arrayList13 = i8 == 0 ? tLRPC$TL_dialogFilter.include_peers : tLRPC$TL_dialogFilter.exclude_peers;
                        HashSet<Integer> hashSet6 = hashSet3;
                        ArrayList<Long> arrayList14 = i8 == 0 ? dialogFilter2.alwaysShow : dialogFilter2.neverShow;
                        if (i8 == 0) {
                            arrayList6 = arrayList12;
                            int size3 = tLRPC$TL_dialogFilter.pinned_peers.size();
                            map10 = map18;
                            int i9 = 0;
                            while (i9 < size3) {
                                int i10 = size3;
                                TLRPC$InputPeer tLRPC$InputPeer = tLRPC$TL_dialogFilter.pinned_peers.get(i9);
                                ArrayList<Long> arrayList15 = arrayList10;
                                HashMap<Long, TLRPC$InputPeer> map19 = map15;
                                long j = tLRPC$InputPeer.user_id;
                                if (j != 0) {
                                    lValueOf2 = Long.valueOf(j);
                                } else {
                                    long j2 = tLRPC$InputPeer.chat_id;
                                    if (j2 == 0) {
                                        j2 = tLRPC$InputPeer.channel_id;
                                    }
                                    lValueOf2 = Long.valueOf(-j2);
                                }
                                if (!dialogFilter2.alwaysShow.contains(lValueOf2)) {
                                    dialogFilter2.alwaysShow.add(lValueOf2);
                                }
                                hashSet4.remove(lValueOf2);
                                if (!hashSet5.remove(lValueOf2)) {
                                    if (!map16.containsKey(lValueOf2)) {
                                        arrayList11.add(lValueOf2);
                                        map16.put(lValueOf2, tLRPC$InputPeer);
                                    }
                                    z6 = true;
                                }
                                i9++;
                                size3 = i10;
                                arrayList10 = arrayList15;
                                map15 = map19;
                            }
                            arrayList5 = arrayList10;
                            map9 = map15;
                        } else {
                            arrayList5 = arrayList10;
                            map9 = map15;
                            arrayList6 = arrayList12;
                            map10 = map18;
                        }
                        int size4 = arrayList13.size();
                        int i11 = 0;
                        while (i11 < size4) {
                            TLRPC$InputPeer tLRPC$InputPeer2 = arrayList13.get(i11);
                            ArrayList<TLRPC$InputPeer> arrayList16 = arrayList13;
                            int i12 = size4;
                            long j3 = tLRPC$InputPeer2.user_id;
                            if (j3 != 0) {
                                Long lValueOf3 = Long.valueOf(j3);
                                if (!hashSet4.remove(lValueOf3)) {
                                    if (!arrayList14.contains(lValueOf3)) {
                                        arrayList14.add(lValueOf3);
                                    }
                                    if (!map14.containsKey(lValueOf3)) {
                                        arrayList9.add(lValueOf3);
                                        map14.put(lValueOf3, tLRPC$InputPeer2);
                                        z5 = true;
                                    }
                                    z6 = true;
                                }
                                map11 = map16;
                                map12 = map14;
                            } else {
                                long j4 = tLRPC$InputPeer2.chat_id;
                                if (j4 == 0) {
                                    j4 = tLRPC$InputPeer2.channel_id;
                                }
                                Long lValueOf4 = Long.valueOf(j4);
                                map11 = map16;
                                map12 = map14;
                                Long lValueOf5 = Long.valueOf(-lValueOf4.longValue());
                                if (!hashSet4.remove(lValueOf5)) {
                                    if (!arrayList14.contains(lValueOf5)) {
                                        arrayList14.add(lValueOf5);
                                    }
                                    map13 = map9;
                                    if (map13.containsKey(lValueOf4)) {
                                        arrayList7 = arrayList5;
                                    } else {
                                        arrayList7 = arrayList5;
                                        arrayList7.add(lValueOf4);
                                        map13.put(lValueOf4, tLRPC$InputPeer2);
                                        z5 = true;
                                    }
                                    z6 = true;
                                }
                                i11++;
                                arrayList13 = arrayList16;
                                arrayList5 = arrayList7;
                                map9 = map13;
                                map16 = map11;
                                map14 = map12;
                                size4 = i12;
                            }
                            arrayList7 = arrayList5;
                            map13 = map9;
                            i11++;
                            arrayList13 = arrayList16;
                            arrayList5 = arrayList7;
                            map9 = map13;
                            map16 = map11;
                            map14 = map12;
                            size4 = i12;
                        }
                        i8++;
                        map15 = map9;
                        hashSet3 = hashSet6;
                        arrayList12 = arrayList6;
                        map18 = map10;
                        i7 = 2;
                        map14 = map14;
                        arrayList10 = arrayList5;
                        map16 = map16;
                    }
                    ArrayList<MessagesController.DialogFilter> arrayList17 = arrayList12;
                    HashMap<Integer, HashSet<Long>> map20 = map18;
                    HashSet<Integer> hashSet7 = hashSet3;
                    HashMap<Long, TLRPC$InputPeer> map21 = map16;
                    arrayList2 = arrayList10;
                    map = map14;
                    map2 = map15;
                    if (hashSet4.isEmpty()) {
                        z3 = z6;
                    } else {
                        map17.put(Integer.valueOf(dialogFilter2.id), hashSet4);
                        z3 = true;
                        z5 = true;
                    }
                    if (hashSet5.isEmpty()) {
                        map8 = map20;
                        z4 = z3;
                    } else {
                        map8 = map20;
                        map8.put(Integer.valueOf(dialogFilter2.id), hashSet5);
                        z4 = true;
                    }
                    if (z4) {
                        arrayList12 = arrayList17;
                        arrayList12.add(dialogFilter2);
                    } else {
                        arrayList12 = arrayList17;
                    }
                    if (z5) {
                        hashSet2 = hashSet7;
                        hashSet2.add(Integer.valueOf(dialogFilter2.id));
                    } else {
                        hashSet2 = hashSet7;
                    }
                    arrayList3 = arrayList11;
                    map3 = map8;
                    map4 = map17;
                    hashSet = hashSet2;
                    map5 = map21;
                } else {
                    i2 = i5;
                    sparseArray = sparseArray2;
                    HashMap<Long, TLRPC$InputPeer> map22 = map16;
                    arrayList2 = arrayList10;
                    map = map14;
                    map2 = map15;
                    MessagesController.DialogFilter dialogFilter3 = new MessagesController.DialogFilter();
                    dialogFilter3.id = tLRPC$TL_dialogFilter.id;
                    dialogFilter3.flags = i;
                    dialogFilter3.name = tLRPC$TL_dialogFilter.title;
                    dialogFilter3.pendingUnreadCount = -1;
                    int i13 = 0;
                    while (i13 < 2) {
                        if (i13 == 0) {
                            int size5 = tLRPC$TL_dialogFilter.pinned_peers.size();
                            int i14 = 0;
                            while (i14 < size5) {
                                TLRPC$InputPeer tLRPC$InputPeer3 = tLRPC$TL_dialogFilter.pinned_peers.get(i14);
                                ArrayList arrayList18 = arrayList11;
                                long j5 = tLRPC$InputPeer3.user_id;
                                if (j5 != 0) {
                                    lValueOf = Long.valueOf(j5);
                                } else {
                                    long j6 = tLRPC$InputPeer3.chat_id;
                                    if (j6 == 0) {
                                        j6 = tLRPC$InputPeer3.channel_id;
                                    }
                                    lValueOf = Long.valueOf(-j6);
                                }
                                if (!dialogFilter3.alwaysShow.contains(lValueOf)) {
                                    dialogFilter3.alwaysShow.add(lValueOf);
                                }
                                HashMap<Long, TLRPC$InputPeer> map23 = map22;
                                if (map23.containsKey(lValueOf)) {
                                    i3 = size5;
                                    arrayList4 = arrayList18;
                                } else {
                                    i3 = size5;
                                    arrayList4 = arrayList18;
                                    arrayList4.add(lValueOf);
                                    map23.put(lValueOf, tLRPC$InputPeer3);
                                }
                                i14++;
                                map22 = map23;
                                arrayList11 = arrayList4;
                                size5 = i3;
                            }
                        }
                        ArrayList arrayList19 = arrayList11;
                        HashMap<Long, TLRPC$InputPeer> map24 = map22;
                        ArrayList<TLRPC$InputPeer> arrayList20 = i13 == 0 ? tLRPC$TL_dialogFilter.include_peers : tLRPC$TL_dialogFilter.exclude_peers;
                        ArrayList<Long> arrayList21 = i13 == 0 ? dialogFilter3.alwaysShow : dialogFilter3.neverShow;
                        int size6 = arrayList20.size();
                        TLRPC$TL_dialogFilter tLRPC$TL_dialogFilter2 = tLRPC$TL_dialogFilter;
                        int i15 = 0;
                        while (i15 < size6) {
                            ArrayList<TLRPC$InputPeer> arrayList22 = arrayList20;
                            TLRPC$InputPeer tLRPC$InputPeer4 = arrayList20.get(i15);
                            HashSet<Integer> hashSet8 = hashSet3;
                            int i16 = size6;
                            long j7 = tLRPC$InputPeer4.user_id;
                            if (j7 != 0) {
                                Long lValueOf6 = Long.valueOf(j7);
                                if (!arrayList21.contains(lValueOf6)) {
                                    arrayList21.add(lValueOf6);
                                }
                                if (!map.containsKey(lValueOf6)) {
                                    arrayList9.add(lValueOf6);
                                    map.put(lValueOf6, tLRPC$InputPeer4);
                                }
                                map6 = map18;
                                map7 = map17;
                            } else {
                                long j8 = tLRPC$InputPeer4.chat_id;
                                if (j8 == 0) {
                                    j8 = tLRPC$InputPeer4.channel_id;
                                }
                                Long lValueOf7 = Long.valueOf(j8);
                                map6 = map18;
                                map7 = map17;
                                Long lValueOf8 = Long.valueOf(-lValueOf7.longValue());
                                if (!arrayList21.contains(lValueOf8)) {
                                    arrayList21.add(lValueOf8);
                                }
                                if (!map2.containsKey(lValueOf7)) {
                                    arrayList2.add(lValueOf7);
                                    map2.put(lValueOf7, tLRPC$InputPeer4);
                                }
                            }
                            i15++;
                            map17 = map7;
                            size6 = i16;
                            arrayList20 = arrayList22;
                            hashSet3 = hashSet8;
                            map18 = map6;
                        }
                        i13++;
                        map22 = map24;
                        arrayList11 = arrayList19;
                        tLRPC$TL_dialogFilter = tLRPC$TL_dialogFilter2;
                    }
                    arrayList3 = arrayList11;
                    map3 = map18;
                    map4 = map17;
                    hashSet = hashSet3;
                    map5 = map22;
                    arrayList12.add(dialogFilter3);
                }
                i5 = i2 + 1;
                tLRPC$Vector2 = tLRPC$Vector;
                map17 = map4;
                map15 = map2;
                size2 = i6;
                arrayList8 = arrayList;
                hashSet3 = hashSet;
                map18 = map3;
                messagesStorage2 = this;
                map14 = map;
                arrayList10 = arrayList2;
                map16 = map5;
                arrayList11 = arrayList3;
                sparseArray2 = sparseArray;
            }
            SparseArray<MessagesController.DialogFilter> sparseArray3 = sparseArray2;
            ArrayList<Integer> arrayList23 = arrayList8;
            HashMap<Integer, HashSet<Long>> map25 = map18;
            HashMap<Integer, HashSet<Long>> map26 = map17;
            HashSet<Integer> hashSet9 = hashSet3;
            ArrayList arrayList24 = arrayList11;
            HashMap<Long, TLRPC$InputPeer> map27 = map16;
            ArrayList<Long> arrayList25 = arrayList10;
            HashMap<Long, TLRPC$InputPeer> map28 = map14;
            HashMap<Long, TLRPC$InputPeer> map29 = map15;
            if (!arrayList24.isEmpty()) {
                try {
                    messagesStorage = this;
                    tLRPC$messages_DialogsLoadDialogsByIds = messagesStorage.loadDialogsByIds(TextUtils.join(",", arrayList24), arrayList9, arrayList25, new ArrayList<>());
                    int size7 = tLRPC$messages_DialogsLoadDialogsByIds.dialogs.size();
                    for (int i17 = 0; i17 < size7; i17++) {
                        map27.remove(Long.valueOf(tLRPC$messages_DialogsLoadDialogsByIds.dialogs.get(i17).id));
                    }
                } catch (Exception e) {
                    e = e;
                    FileLog.e(e);
                    return;
                }
            } else {
                messagesStorage = this;
                tLRPC$messages_DialogsLoadDialogsByIds = new TLRPC$TL_messages_dialogs();
            }
            TLRPC$messages_Dialogs tLRPC$messages_Dialogs = tLRPC$messages_DialogsLoadDialogsByIds;
            ArrayList<TLRPC$User> arrayList26 = new ArrayList<>();
            if (!arrayList9.isEmpty()) {
                messagesStorage.getUsersInternal(TextUtils.join(",", arrayList9), arrayList26);
                int size8 = arrayList26.size();
                for (int i18 = 0; i18 < size8; i18++) {
                    map28.remove(Long.valueOf(arrayList26.get(i18).id));
                }
            }
            ArrayList<TLRPC$Chat> arrayList27 = new ArrayList<>();
            if (!arrayList25.isEmpty()) {
                messagesStorage.getChatsInternal(TextUtils.join(",", arrayList25), arrayList27);
                int size9 = arrayList27.size();
                for (int i19 = 0; i19 < size9; i19++) {
                    map29.remove(Long.valueOf(arrayList27.get(i19).id));
                }
            }
            if (map28.isEmpty() && map29.isEmpty() && map27.isEmpty()) {
                lambda$processLoadedFilterPeers$41(tLRPC$messages_Dialogs, null, arrayList26, arrayList27, arrayList12, sparseArray3, arrayList23, map25, map26, hashSet9);
            } else {
                getMessagesController().loadFilterPeers(map27, map28, map29, tLRPC$messages_Dialogs, new TLRPC$TL_messages_dialogs(), arrayList26, arrayList27, arrayList12, sparseArray3, arrayList23, map25, map26, hashSet9);
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: processLoadedFilterPeersInternal, reason: merged with bridge method [inline-methods] */
    public void lambda$processLoadedFilterPeers$41$MessagesStorage(TLRPC$messages_Dialogs pinnedDialogs, TLRPC$messages_Dialogs pinnedRemoteDialogs, ArrayList<TLRPC$User> users, ArrayList<TLRPC$Chat> chats, ArrayList<MessagesController.DialogFilter> filtersToSave, SparseArray<MessagesController.DialogFilter> filtersToDelete, ArrayList<Integer> filtersOrder, HashMap<Integer, HashSet<Long>> filterDialogRemovals, HashMap<Integer, HashSet<Long>> filterUserRemovals, HashSet<Integer> filtersUnreadCounterReset) {
        putUsersAndChats(users, chats, true, false);
        int size = filtersToDelete.size();
        int i = 0;
        boolean z = false;
        while (i < size) {
            lambda$deleteDialogFilter$42(filtersToDelete.valueAt(i));
            i++;
            z = true;
        }
        Iterator<Integer> it = filtersUnreadCounterReset.iterator();
        while (it.hasNext()) {
            MessagesController.DialogFilter dialogFilter = this.dialogFiltersMap.get(it.next().intValue());
            if (dialogFilter != null) {
                dialogFilter.pendingUnreadCount = -1;
            }
        }
        for (Map.Entry<Integer, HashSet<Long>> entry : filterUserRemovals.entrySet()) {
            MessagesController.DialogFilter dialogFilter2 = this.dialogFiltersMap.get(entry.getKey().intValue());
            if (dialogFilter2 != null) {
                HashSet<Long> value = entry.getValue();
                dialogFilter2.alwaysShow.removeAll(value);
                dialogFilter2.neverShow.removeAll(value);
                z = true;
            }
        }
        for (Map.Entry<Integer, HashSet<Long>> entry2 : filterDialogRemovals.entrySet()) {
            MessagesController.DialogFilter dialogFilter3 = this.dialogFiltersMap.get(entry2.getKey().intValue());
            if (dialogFilter3 != null) {
                Iterator<Long> it2 = entry2.getValue().iterator();
                while (it2.hasNext()) {
                    dialogFilter3.pinnedDialogs.delete(it2.next().longValue());
                }
                z = true;
            }
        }
        int size2 = filtersToSave.size();
        int i2 = 0;
        while (i2 < size2) {
            saveDialogFilterInternal(filtersToSave.get(i2), false, true);
            i2++;
            z = true;
        }
        int size3 = this.dialogFilters.size();
        boolean z2 = false;
        for (int i3 = 0; i3 < size3; i3++) {
            MessagesController.DialogFilter dialogFilter4 = this.dialogFilters.get(i3);
            int iIndexOf = filtersOrder.indexOf(Integer.valueOf(dialogFilter4.id));
            if (dialogFilter4.order != iIndexOf) {
                dialogFilter4.order = iIndexOf;
                z2 = true;
                z = true;
            }
        }
        if (z2) {
            Collections.sort(this.dialogFilters, $$Lambda$MessagesStorage$M2ftnTXy85Gndpl4jkWrLj4XVE.INSTANCE);
            saveDialogFiltersOrderInternal();
        }
        int i4 = z ? 1 : 2;
        calcUnreadCounters(true);
        getMessagesController().processLoadedDialogFilters(new ArrayList<>(this.dialogFilters), pinnedDialogs, pinnedRemoteDialogs, users, chats, null, i4);
    }

    static /* synthetic */ int lambda$processLoadedFilterPeersInternal$40(MessagesController.DialogFilter dialogFilter, MessagesController.DialogFilter dialogFilter2) {
        int i = dialogFilter.order;
        int i2 = dialogFilter2.order;
        if (i > i2) {
            return 1;
        }
        return i < i2 ? -1 : 0;
    }

    protected void processLoadedFilterPeers(final TLRPC$messages_Dialogs pinnedDialogs, final TLRPC$messages_Dialogs pinnedRemoteDialogs, final ArrayList<TLRPC$User> users, final ArrayList<TLRPC$Chat> chats, final ArrayList<MessagesController.DialogFilter> filtersToSave, final SparseArray<MessagesController.DialogFilter> filtersToDelete, final ArrayList<Integer> filtersOrder, final HashMap<Integer, HashSet<Long>> filterDialogRemovals, final HashMap<Integer, HashSet<Long>> filterUserRemovals, final HashSet<Integer> filtersUnreadCounterReset) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$2xR-wYUVjFOm8w3mnIX51mcnEa4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processLoadedFilterPeers$41$MessagesStorage(pinnedDialogs, pinnedRemoteDialogs, users, chats, filtersToSave, filtersToDelete, filtersOrder, filterDialogRemovals, filterUserRemovals, filtersUnreadCounterReset);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: deleteDialogFilterInternal, reason: merged with bridge method [inline-methods] */
    public void lambda$deleteDialogFilter$42$MessagesStorage(MessagesController.DialogFilter filter) {
        try {
            this.dialogFilters.remove(filter);
            this.dialogFiltersMap.remove(filter.id);
            this.database.executeFast("DELETE FROM dialog_filter WHERE id = " + filter.id).stepThis().dispose();
            this.database.executeFast("DELETE FROM dialog_filter_ep WHERE id = " + filter.id).stepThis().dispose();
            this.database.executeFast("DELETE FROM dialog_filter_pin_v2 WHERE id = " + filter.id).stepThis().dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void deleteDialogFilter(final MessagesController.DialogFilter filter) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$F05qb4d5W68ZYa1pWUk8J7-RaMM
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$deleteDialogFilter$42$MessagesStorage(filter);
            }
        });
    }

    public void saveDialogFilter(final MessagesController.DialogFilter filter, final boolean atBegin, final boolean peers) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$rt60fykZfbH4mSYfK_WVcoHJ1do
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$saveDialogFilter$44$MessagesStorage(filter, atBegin, peers);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$saveDialogFilter$44, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$saveDialogFilter$44$MessagesStorage(MessagesController.DialogFilter dialogFilter, boolean z, boolean z2) {
        saveDialogFilterInternal(dialogFilter, z, z2);
        calcUnreadCounters(false);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$hB6RAowFuGh8KYNY0qhQT_Lcpro
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$saveDialogFilter$43$MessagesStorage();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$saveDialogFilter$43, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$saveDialogFilter$43$MessagesStorage() {
        ArrayList<MessagesController.DialogFilter> arrayList = getMessagesController().dialogFilters;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList.get(i).unreadCount = arrayList.get(i).pendingUnreadCount;
        }
        this.mainUnreadCount = this.pendingMainUnreadCount;
        this.archiveUnreadCount = this.pendingArchiveUnreadCount;
        getNotificationCenter().postNotificationName(NotificationCenter.updateInterfaces, Integer.valueOf(MessagesController.UPDATE_MASK_READ_DIALOG_MESSAGE));
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
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$85OrDnYWzm5RRfuN4WQ2_vhzbr8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.saveDialogFiltersOrderInternal();
            }
        });
    }

    protected static void addReplyMessages(TLRPC$Message message, LongSparseArray<SparseArray<ArrayList<TLRPC$Message>>> replyMessageOwners, LongSparseArray<ArrayList<Integer>> dialogReplyMessagesIds) {
        int i = message.reply_to.reply_to_msg_id;
        long replyToDialogId = MessageObject.getReplyToDialogId(message);
        SparseArray<ArrayList<TLRPC$Message>> sparseArray = replyMessageOwners.get(replyToDialogId);
        ArrayList<Integer> arrayList = dialogReplyMessagesIds.get(replyToDialogId);
        if (sparseArray == null) {
            sparseArray = new SparseArray<>();
            replyMessageOwners.put(replyToDialogId, sparseArray);
        }
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            dialogReplyMessagesIds.put(replyToDialogId, arrayList);
        }
        ArrayList<TLRPC$Message> arrayList2 = sparseArray.get(message.reply_to.reply_to_msg_id);
        if (arrayList2 == null) {
            arrayList2 = new ArrayList<>();
            sparseArray.put(message.reply_to.reply_to_msg_id, arrayList2);
            if (!arrayList.contains(Integer.valueOf(message.reply_to.reply_to_msg_id))) {
                arrayList.add(Integer.valueOf(message.reply_to.reply_to_msg_id));
            }
        }
        arrayList2.add(message);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v8 */
    protected void loadReplyMessages(LongSparseArray<SparseArray<ArrayList<TLRPC$Message>>> longSparseArray, LongSparseArray<ArrayList<Integer>> longSparseArray2, ArrayList<Long> arrayList, ArrayList<Long> arrayList2) throws SQLiteException, NumberFormatException {
        if (longSparseArray.isEmpty()) {
            return;
        }
        int size = longSparseArray.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            long jKeyAt = longSparseArray.keyAt(i2);
            SparseArray<ArrayList<TLRPC$Message>> sparseArrayValueAt = longSparseArray.valueAt(i2);
            ArrayList<Integer> arrayList3 = longSparseArray2.get(jKeyAt);
            if (arrayList3 != null) {
                SQLiteDatabase sQLiteDatabase = this.database;
                Locale locale = Locale.US;
                Object[] objArr = new Object[2];
                objArr[i] = TextUtils.join(",", arrayList3);
                objArr[1] = Long.valueOf(jKeyAt);
                SQLiteCursor sQLiteCursorQueryFinalized = sQLiteDatabase.queryFinalized(String.format(locale, "SELECT data, mid, date, uid FROM messages_v2 WHERE mid IN(%s) AND uid = %d", objArr), new Object[i]);
                ?? r2 = i;
                while (sQLiteCursorQueryFinalized.next()) {
                    NativeByteBuffer nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized.byteBufferValue(r2);
                    if (nativeByteBufferByteBufferValue != 0) {
                        TLRPC$Message tLRPC$MessageTLdeserialize = TLRPC$Message.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(r2), r2);
                        tLRPC$MessageTLdeserialize.readAttachPath(nativeByteBufferByteBufferValue, getUserConfig().clientUserId);
                        nativeByteBufferByteBufferValue.reuse();
                        tLRPC$MessageTLdeserialize.id = sQLiteCursorQueryFinalized.intValue(1);
                        tLRPC$MessageTLdeserialize.date = sQLiteCursorQueryFinalized.intValue(2);
                        tLRPC$MessageTLdeserialize.dialog_id = sQLiteCursorQueryFinalized.longValue(3);
                        addUsersAndChatsFromMessage(tLRPC$MessageTLdeserialize, arrayList, arrayList2);
                        ArrayList<TLRPC$Message> arrayList4 = sparseArrayValueAt.get(tLRPC$MessageTLdeserialize.id);
                        if (arrayList4 != null) {
                            int size2 = arrayList4.size();
                            for (int i3 = 0; i3 < size2; i3++) {
                                arrayList4.get(i3).replyMessage = tLRPC$MessageTLdeserialize;
                                MessageObject.getDialogId(tLRPC$MessageTLdeserialize);
                            }
                        }
                    }
                    r2 = 0;
                }
                sQLiteCursorQueryFinalized.dispose();
            }
            i2++;
            i = 0;
        }
    }

    public void loadUnreadMessages() {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$24v2mxZMu0083MOVHqs_60PB8qw
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadUnreadMessages$46$MessagesStorage();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01f1  */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7, types: [boolean, int] */
    /* renamed from: lambda$loadUnreadMessages$46, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$loadUnreadMessages$46$MessagesStorage() {
        /*
            Method dump skipped, instructions count: 1059
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessagesStorage.lambda$loadUnreadMessages$46$MessagesStorage():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadUnreadMessages$45, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadUnreadMessages$45$MessagesStorage(LongSparseArray longSparseArray, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4, ArrayList arrayList5) {
        getNotificationsController().processLoadedUnreadMessages(longSparseArray, arrayList, arrayList2, arrayList3, arrayList4, arrayList5);
    }

    public void putWallpapers(final ArrayList<TLRPC$WallPaper> wallPapers, final int action) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$NNRw9X0sL97Odpvg1vgrhbHCv5c
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$putWallpapers$47$MessagesStorage(action, wallPapers);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$putWallpapers$47, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$putWallpapers$47$MessagesStorage(int i, ArrayList arrayList) {
        SQLitePreparedStatement sQLitePreparedStatementExecuteFast;
        if (i == 1) {
            try {
                this.database.executeFast("DELETE FROM wallpapers2 WHERE num >= -1").stepThis().dispose();
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
            TLRPC$WallPaper tLRPC$WallPaper = (TLRPC$WallPaper) arrayList.get(i2);
            sQLitePreparedStatementExecuteFast.requery();
            NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(tLRPC$WallPaper.getObjectSize());
            tLRPC$WallPaper.serializeToStream(nativeByteBuffer);
            if (i != 0) {
                sQLitePreparedStatementExecuteFast.bindLong(1, tLRPC$WallPaper.id);
                sQLitePreparedStatementExecuteFast.bindByteBuffer(2, nativeByteBuffer);
                if (i < 0) {
                    sQLitePreparedStatementExecuteFast.bindInteger(3, i);
                } else {
                    sQLitePreparedStatementExecuteFast.bindInteger(3, i == 2 ? -1 : i2);
                }
            } else {
                sQLitePreparedStatementExecuteFast.bindByteBuffer(1, nativeByteBuffer);
                sQLitePreparedStatementExecuteFast.bindLong(2, tLRPC$WallPaper.id);
            }
            sQLitePreparedStatementExecuteFast.step();
            nativeByteBuffer.reuse();
        }
        sQLitePreparedStatementExecuteFast.dispose();
        this.database.commitTransaction();
    }

    public void deleteWallpaper(final long id) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$zDcoRWA1Xyg6rLyyTZMxkppxd0Y
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$deleteWallpaper$48$MessagesStorage(id);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$deleteWallpaper$48, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$deleteWallpaper$48$MessagesStorage(long j) {
        try {
            this.database.executeFast("DELETE FROM wallpapers2 WHERE uid = " + j).stepThis().dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void getWallpapers() {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$7Prv1g57k_znnORlSDJCoF1VBmM
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getWallpapers$50$MessagesStorage();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getWallpapers$50, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getWallpapers$50$MessagesStorage() {
        SQLiteCursor sQLiteCursorQueryFinalized = null;
        try {
            try {
                sQLiteCursorQueryFinalized = this.database.queryFinalized("SELECT data FROM wallpapers2 WHERE 1 ORDER BY num ASC", new Object[0]);
                final ArrayList arrayList = new ArrayList();
                while (sQLiteCursorQueryFinalized.next()) {
                    NativeByteBuffer nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized.byteBufferValue(0);
                    if (nativeByteBufferByteBufferValue != null) {
                        TLRPC$WallPaper tLRPC$WallPaperTLdeserialize = TLRPC$WallPaper.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                        nativeByteBufferByteBufferValue.reuse();
                        if (tLRPC$WallPaperTLdeserialize != null) {
                            arrayList.add(tLRPC$WallPaperTLdeserialize);
                        }
                    }
                }
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$5JfMHsLtCZb7PF4aoOkQ2csEE7w
                    @Override // java.lang.Runnable
                    public final void run() {
                        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.wallpapersDidLoad, arrayList);
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

    public void addRecentLocalFile(final String imageUrl, final String localUrl, final TLRPC$Document document) {
        if (imageUrl == null || imageUrl.length() == 0) {
            return;
        }
        if ((localUrl == null || localUrl.length() == 0) && document == null) {
            return;
        }
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$GAdoP6svdBvAWeIMpmzFvoZap7g
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$addRecentLocalFile$51$MessagesStorage(document, imageUrl, localUrl);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$addRecentLocalFile$51, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$addRecentLocalFile$51$MessagesStorage(TLRPC$Document tLRPC$Document, String str, String str2) {
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

    public void deleteUserChatHistory(final long dialogId, final long fromId) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$8y1pPFQ5TE3_Cpwd3FZiBOwEg3U
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$deleteUserChatHistory$54$MessagesStorage(dialogId, fromId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d8 A[Catch: Exception -> 0x00e1, TRY_LEAVE, TryCatch #2 {Exception -> 0x00e1, blocks: (B:3:0x0004, B:31:0x0094, B:32:0x0097, B:36:0x00c0, B:38:0x00d8), top: B:47:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* renamed from: lambda$deleteUserChatHistory$54, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$deleteUserChatHistory$54$MessagesStorage(final long r18, long r20) {
        /*
            Method dump skipped, instructions count: 230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessagesStorage.lambda$deleteUserChatHistory$54$MessagesStorage(long, long):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$deleteUserChatHistory$52, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$deleteUserChatHistory$52$MessagesStorage(ArrayList arrayList, long j, ArrayList arrayList2) {
        getFileLoader().cancelLoadFiles(arrayList);
        getMessagesController().markDialogMessageAsDeleted(j, arrayList2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$deleteUserChatHistory$53, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$deleteUserChatHistory$53$MessagesStorage(ArrayList arrayList, long j) {
        NotificationCenter notificationCenter = getNotificationCenter();
        int i = NotificationCenter.messagesDeleted;
        Object[] objArr = new Object[3];
        objArr[0] = arrayList;
        objArr[1] = Long.valueOf(DialogObject.isChatDialog(j) ? -j : 0L);
        objArr[2] = Boolean.FALSE;
        notificationCenter.postNotificationName(i, objArr);
    }

    private boolean addFilesToDelete(TLRPC$Message message, ArrayList<File> filesToDelete, ArrayList<Pair<Long, Integer>> ids, ArrayList<String> namesToDelete, boolean forceCache) {
        long j;
        int i;
        int i2 = 0;
        if (message == null) {
            return false;
        }
        TLRPC$Document document = MessageObject.getDocument(message);
        TLRPC$Photo photo = MessageObject.getPhoto(message);
        if (!MessageObject.isVoiceMessage(message)) {
            if (MessageObject.isStickerMessage(message) || MessageObject.isAnimatedStickerMessage(message)) {
                if (document == null) {
                    return false;
                }
                j = document.id;
            } else if (MessageObject.isVideoMessage(message) || MessageObject.isRoundVideoMessage(message) || MessageObject.isGifMessage(message)) {
                if (document == null) {
                    return false;
                }
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
        } else {
            if (document == null) {
                return false;
            }
            j = document.id;
            i = 2;
        }
        if (j != 0) {
            ids.add(new Pair<>(Long.valueOf(j), Integer.valueOf(i)));
        }
        if (photo != null) {
            int size = photo.sizes.size();
            while (i2 < size) {
                TLRPC$PhotoSize tLRPC$PhotoSize = photo.sizes.get(i2);
                String attachFileName = FileLoader.getAttachFileName(tLRPC$PhotoSize);
                if (!TextUtils.isEmpty(attachFileName)) {
                    namesToDelete.add(attachFileName);
                }
                File pathToAttach = FileLoader.getPathToAttach(tLRPC$PhotoSize, forceCache);
                if (pathToAttach.toString().length() > 0) {
                    filesToDelete.add(pathToAttach);
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
            namesToDelete.add(attachFileName2);
        }
        File pathToAttach2 = FileLoader.getPathToAttach(document, forceCache);
        if (pathToAttach2.toString().length() > 0) {
            filesToDelete.add(pathToAttach2);
        }
        int size2 = document.thumbs.size();
        while (i2 < size2) {
            File pathToAttach3 = FileLoader.getPathToAttach(document.thumbs.get(i2));
            if (pathToAttach3.toString().length() > 0) {
                filesToDelete.add(pathToAttach3);
            }
            i2++;
        }
        return true;
    }

    public void deleteDialog(final long did, final int messagesOnly) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$eV_RJIlOjyWqfTGuPbOqQZeGnP0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$deleteDialog$57$MessagesStorage(messagesOnly, did);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0286 A[Catch: Exception -> 0x0471, TryCatch #5 {Exception -> 0x0471, blocks: (B:4:0x000c, B:6:0x002b, B:8:0x0031, B:11:0x0037, B:42:0x00f3, B:44:0x0113, B:71:0x01a7, B:72:0x01aa, B:74:0x0286, B:75:0x0289, B:77:0x0295, B:86:0x0393, B:80:0x02a5, B:82:0x034b, B:84:0x0351, B:85:0x0371, B:17:0x0048, B:33:0x00c5, B:34:0x00c8), top: B:101:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x02a5 A[Catch: Exception -> 0x0471, TryCatch #5 {Exception -> 0x0471, blocks: (B:4:0x000c, B:6:0x002b, B:8:0x0031, B:11:0x0037, B:42:0x00f3, B:44:0x0113, B:71:0x01a7, B:72:0x01aa, B:74:0x0286, B:75:0x0289, B:77:0x0295, B:86:0x0393, B:80:0x02a5, B:82:0x034b, B:84:0x0351, B:85:0x0371, B:17:0x0048, B:33:0x00c5, B:34:0x00c8), top: B:101:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x034b A[Catch: Exception -> 0x0471, TryCatch #5 {Exception -> 0x0471, blocks: (B:4:0x000c, B:6:0x002b, B:8:0x0031, B:11:0x0037, B:42:0x00f3, B:44:0x0113, B:71:0x01a7, B:72:0x01aa, B:74:0x0286, B:75:0x0289, B:77:0x0295, B:86:0x0393, B:80:0x02a5, B:82:0x034b, B:84:0x0351, B:85:0x0371, B:17:0x0048, B:33:0x00c5, B:34:0x00c8), top: B:101:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0371 A[Catch: Exception -> 0x0471, TryCatch #5 {Exception -> 0x0471, blocks: (B:4:0x000c, B:6:0x002b, B:8:0x0031, B:11:0x0037, B:42:0x00f3, B:44:0x0113, B:71:0x01a7, B:72:0x01aa, B:74:0x0286, B:75:0x0289, B:77:0x0295, B:86:0x0393, B:80:0x02a5, B:82:0x034b, B:84:0x0351, B:85:0x0371, B:17:0x0048, B:33:0x00c5, B:34:0x00c8), top: B:101:0x000c }] */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v14, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r13v15 */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* renamed from: lambda$deleteDialog$57, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$deleteDialog$57$MessagesStorage(int r25, long r26) {
        /*
            Method dump skipped, instructions count: 1142
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessagesStorage.lambda$deleteDialog$57$MessagesStorage(int, long):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$deleteDialog$55, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$deleteDialog$55$MessagesStorage(ArrayList arrayList) {
        getFileLoader().cancelLoadFiles(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$deleteDialog$56, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$deleteDialog$56$MessagesStorage() {
        getNotificationCenter().postNotificationName(NotificationCenter.needReloadRecentDialogsSearch, new Object[0]);
    }

    public void onDeleteQueryComplete(final long did) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$Gl8qtOPUjtdSSzsxMSvVZO3Pqtg
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onDeleteQueryComplete$58$MessagesStorage(did);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onDeleteQueryComplete$58, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onDeleteQueryComplete$58$MessagesStorage(long j) {
        try {
            this.database.executeFast("DELETE FROM media_counts_v2 WHERE uid = " + j).stepThis().dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void getDialogPhotos(final long did, final int count, final int maxId, final int classGuid) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$TJZPlu9PrSHv-fcguBSA5IhgOmQ
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getDialogPhotos$60$MessagesStorage(maxId, did, count, classGuid);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getDialogPhotos$60, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getDialogPhotos$60$MessagesStorage(final int i, final long j, final int i2, final int i3) {
        SQLiteCursor sQLiteCursorQueryFinalized;
        try {
            if (i != 0) {
                sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT data FROM user_photos WHERE uid = %d AND id < %d ORDER BY rowid ASC LIMIT %d", Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2)), new Object[0]);
            } else {
                sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT data FROM user_photos WHERE uid = %d ORDER BY rowid ASC LIMIT %d", Long.valueOf(j), Integer.valueOf(i2)), new Object[0]);
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
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$UdvYIS6I9uq85noIpotJyKI6ElQ
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$getDialogPhotos$59$MessagesStorage(tLRPC$TL_photos_photos, arrayList, j, i2, i, i3);
                }
            });
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getDialogPhotos$59, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getDialogPhotos$59$MessagesStorage(TLRPC$photos_Photos tLRPC$photos_Photos, ArrayList arrayList, long j, int i, int i2, int i3) {
        getMessagesController().processLoadedUserPhotos(tLRPC$photos_Photos, arrayList, j, i, i2, true, i3);
    }

    public void clearUserPhotos(final long dialogId) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$OFmwZRG9dUpTpjlSkwaeOvt88pU
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$clearUserPhotos$61$MessagesStorage(dialogId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$clearUserPhotos$61, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$clearUserPhotos$61$MessagesStorage(long j) {
        try {
            this.database.executeFast("DELETE FROM user_photos WHERE uid = " + j).stepThis().dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void clearUserPhoto(final long dialogId, final long pid) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$9EDE8vxybAVAZWObphyvR5Jv85c
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$clearUserPhoto$62$MessagesStorage(dialogId, pid);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$clearUserPhoto$62, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$clearUserPhoto$62$MessagesStorage(long j, long j2) {
        try {
            this.database.executeFast("DELETE FROM user_photos WHERE uid = " + j + " AND id = " + j2).stepThis().dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void resetDialogs(final TLRPC$messages_Dialogs dialogsRes, final int messagesCount, final int seq, final int newPts, final int date, final int qts, final LongSparseArray<TLRPC$Dialog> new_dialogs_dict, final LongSparseArray<MessageObject> new_dialogMessage, final TLRPC$Message lastMessage, final int dialogsCount) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$0Z7-pLXqvEI73uFz7ZNpfvg_NUg
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$resetDialogs$64$MessagesStorage(dialogsRes, dialogsCount, seq, newPts, date, qts, lastMessage, messagesCount, new_dialogs_dict, new_dialogMessage);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02cb A[Catch: Exception -> 0x0312, LOOP:5: B:76:0x02c8->B:78:0x02cb, LOOP_END, TryCatch #0 {Exception -> 0x0312, blocks: (B:3:0x0006, B:4:0x0024, B:6:0x002c, B:7:0x0040, B:8:0x004c, B:10:0x0052, B:12:0x0061, B:14:0x006a, B:15:0x0079, B:16:0x0081, B:18:0x0089, B:19:0x0091, B:21:0x01bc, B:23:0x01ca, B:39:0x0210, B:26:0x01cf, B:30:0x01ea, B:32:0x01f2, B:33:0x01f5, B:35:0x0205, B:36:0x0207, B:38:0x020b, B:40:0x0215, B:43:0x0241, B:45:0x0249, B:47:0x0259, B:78:0x02cb, B:79:0x02ea, B:48:0x025c, B:51:0x0265, B:54:0x026e, B:56:0x0276, B:58:0x0284, B:59:0x0287, B:62:0x0298, B:65:0x02a1, B:67:0x02a9, B:69:0x02b7, B:70:0x02ba), top: B:84:0x0006 }] */
    /* renamed from: lambda$resetDialogs$64, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$resetDialogs$64$MessagesStorage(ir.eitaa.tgnet.TLRPC$messages_Dialogs r31, int r32, int r33, int r34, int r35, int r36, ir.eitaa.tgnet.TLRPC$Message r37, int r38, androidx.collection.LongSparseArray r39, androidx.collection.LongSparseArray r40) {
        /*
            Method dump skipped, instructions count: 791
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessagesStorage.lambda$resetDialogs$64$MessagesStorage(ir.eitaa.tgnet.TLRPC$messages_Dialogs, int, int, int, int, int, ir.eitaa.tgnet.TLRPC$Message, int, androidx.collection.LongSparseArray, androidx.collection.LongSparseArray):void");
    }

    static /* synthetic */ int lambda$resetDialogs$63(LongSparseIntArray longSparseIntArray, Long l, Long l2) {
        int i = longSparseIntArray.get(l.longValue());
        int i2 = longSparseIntArray.get(l2.longValue());
        if (i < i2) {
            return 1;
        }
        return i > i2 ? -1 : 0;
    }

    public void putDialogPhotos(final long did, final TLRPC$photos_Photos photos, final ArrayList<TLRPC$Message> messages) {
        if (photos == null) {
            return;
        }
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$HKKHJUwcfrlU4SGDb48MM9ZXfNw
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$putDialogPhotos$65$MessagesStorage(did, photos, messages);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$putDialogPhotos$65, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$putDialogPhotos$65$MessagesStorage(long j, TLRPC$photos_Photos tLRPC$photos_Photos, ArrayList arrayList) {
        try {
            this.database.executeFast("DELETE FROM user_photos WHERE uid = " + j).stepThis().dispose();
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("REPLACE INTO user_photos VALUES(?, ?, ?)");
            int size = tLRPC$photos_Photos.photos.size();
            for (int i = 0; i < size; i++) {
                TLRPC$Photo tLRPC$Photo = tLRPC$photos_Photos.photos.get(i);
                if (!(tLRPC$Photo instanceof TLRPC$TL_photoEmpty)) {
                    sQLitePreparedStatementExecuteFast.requery();
                    int objectSize = tLRPC$Photo.getObjectSize();
                    if (arrayList != null) {
                        objectSize += ((TLRPC$Message) arrayList.get(i)).getObjectSize();
                    }
                    NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(objectSize);
                    tLRPC$Photo.serializeToStream(nativeByteBuffer);
                    if (arrayList != null) {
                        ((TLRPC$Message) arrayList.get(i)).serializeToStream(nativeByteBuffer);
                    }
                    sQLitePreparedStatementExecuteFast.bindLong(1, j);
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

    public void emptyMessagesMedia(final long dialogId, final ArrayList<Integer> mids) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$TttOUsM-NcpK4DcucqSXzh-IJJY
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$emptyMessagesMedia$68$MessagesStorage(mids, dialogId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* renamed from: lambda$emptyMessagesMedia$68, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$emptyMessagesMedia$68$MessagesStorage(ArrayList arrayList, long j) {
        try {
            ArrayList<File> arrayList2 = new ArrayList<>();
            final ArrayList<String> arrayList3 = new ArrayList<>();
            ArrayList<Pair<Long, Integer>> arrayList4 = new ArrayList<>();
            final ArrayList arrayList5 = new ArrayList();
            int i = 2;
            ?? r12 = 0;
            SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT data, mid, date, uid FROM messages_v2 WHERE mid IN (%s) AND uid = %d", TextUtils.join(",", arrayList), Long.valueOf(j)), new Object[0]);
            while (sQLiteCursorQueryFinalized.next()) {
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
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("REPLACE INTO messages_v2 VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, NULL, ?, ?, ?, ?, ?, ?)");
                int i2 = 0;
                while (i2 < arrayList5.size()) {
                    TLRPC$Message tLRPC$Message = (TLRPC$Message) arrayList5.get(i2);
                    NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(tLRPC$Message.getObjectSize());
                    tLRPC$Message.serializeToStream(nativeByteBuffer);
                    sQLitePreparedStatementExecuteFast.requery();
                    sQLitePreparedStatementExecuteFast.bindInteger(1, tLRPC$Message.id);
                    sQLitePreparedStatementExecuteFast.bindLong(i, tLRPC$Message.dialog_id);
                    sQLitePreparedStatementExecuteFast.bindInteger(3, MessageObject.getUnreadFlags(tLRPC$Message));
                    sQLitePreparedStatementExecuteFast.bindInteger(4, tLRPC$Message.send_state);
                    sQLitePreparedStatementExecuteFast.bindInteger(5, tLRPC$Message.date);
                    sQLitePreparedStatementExecuteFast.bindByteBuffer(6, nativeByteBuffer);
                    sQLitePreparedStatementExecuteFast.bindInteger(7, (MessageObject.isOut(tLRPC$Message) || tLRPC$Message.from_scheduled) ? 1 : 0);
                    sQLitePreparedStatementExecuteFast.bindInteger(8, tLRPC$Message.ttl);
                    if ((tLRPC$Message.flags & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0) {
                        sQLitePreparedStatementExecuteFast.bindInteger(9, tLRPC$Message.views);
                    } else {
                        sQLitePreparedStatementExecuteFast.bindInteger(9, getMessageMediaType(tLRPC$Message));
                    }
                    int i3 = tLRPC$Message.stickerVerified;
                    sQLitePreparedStatementExecuteFast.bindInteger(10, i3 == 0 ? 1 : i3 == i ? 2 : 0);
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
                        int i4 = tLRPC$TL_messageReplyHeader.reply_to_top_id;
                        if (i4 == 0) {
                            i4 = tLRPC$TL_messageReplyHeader.reply_to_msg_id;
                        }
                        sQLitePreparedStatementExecuteFast.bindInteger(14, i4);
                    } else {
                        sQLitePreparedStatementExecuteFast.bindInteger(14, 0);
                    }
                    sQLitePreparedStatementExecuteFast.bindLong(15, MessageObject.getChannelId(tLRPC$Message));
                    sQLitePreparedStatementExecuteFast.step();
                    nativeByteBuffer.reuse();
                    if (nativeByteBuffer2 != null) {
                        nativeByteBuffer2.reuse();
                    }
                    i2++;
                    i = 2;
                }
                sQLitePreparedStatementExecuteFast.dispose();
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$tAPyZ0ljpGcg2JKLfZBmiS2YIGM
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$emptyMessagesMedia$66$MessagesStorage(arrayList5);
                    }
                });
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$76C8pxQJFHQfAkXA-wXOEZqw19o
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$emptyMessagesMedia$67$MessagesStorage(arrayList3);
                }
            });
            getFileLoader().deleteFiles(arrayList2, 0);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$emptyMessagesMedia$66, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$emptyMessagesMedia$66$MessagesStorage(ArrayList arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            getNotificationCenter().postNotificationName(NotificationCenter.updateMessageMedia, arrayList.get(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$emptyMessagesMedia$67, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$emptyMessagesMedia$67$MessagesStorage(ArrayList arrayList) {
        getFileLoader().cancelLoadFiles(arrayList);
    }

    public void updateMessageLiveMedia(final TLRPC$Message oldMessage, final TLRPC$TL_messageMediaLiveStream newMedia) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$z-lOy4gxyVJyIfWs3gQ13gs73Hg
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateMessageLiveMedia$69$MessagesStorage(oldMessage, newMedia);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateMessageLiveMedia$69, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateMessageLiveMedia$69$MessagesStorage(TLRPC$Message tLRPC$Message, TLRPC$TL_messageMediaLiveStream tLRPC$TL_messageMediaLiveStream) {
        NativeByteBuffer nativeByteBufferByteBufferValue;
        try {
            long j = tLRPC$Message.id;
            long j2 = tLRPC$Message.peer_id.channel_id;
            int i = tLRPC$Message.local_id;
            if (i != 0) {
                j = i;
            }
            this.database.beginTransaction();
            long j3 = -j2;
            SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT data FROM messages_v2 WHERE mid = %d And uid = %d", Long.valueOf(j), Long.valueOf(j3)), new Object[0]);
            if (sQLiteCursorQueryFinalized.next() && (nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized.byteBufferValue(0)) != null) {
                TLRPC$Message tLRPC$MessageTLdeserialize = TLRPC$Message.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                tLRPC$MessageTLdeserialize.readAttachPath(nativeByteBufferByteBufferValue, UserConfig.getInstance(this.currentAccount).clientUserId);
                nativeByteBufferByteBufferValue.reuse();
                TLRPC$MessageMedia tLRPC$MessageMedia = tLRPC$MessageTLdeserialize.media;
                if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaLiveStream) {
                    TLRPC$TL_messageMediaLiveStream tLRPC$TL_messageMediaLiveStream2 = (TLRPC$TL_messageMediaLiveStream) tLRPC$MessageMedia;
                    if (tLRPC$TL_messageMediaLiveStream != null) {
                        MessageObject.updateLiveMedia(tLRPC$TL_messageMediaLiveStream2, tLRPC$TL_messageMediaLiveStream);
                    }
                    SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("UPDATE messages_v2 SET data = ? WHERE mid = ? AND uid = ?");
                    NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(tLRPC$MessageTLdeserialize.getObjectSize());
                    tLRPC$MessageTLdeserialize.serializeToStream(nativeByteBuffer);
                    sQLitePreparedStatementExecuteFast.requery();
                    sQLitePreparedStatementExecuteFast.bindByteBuffer(1, nativeByteBuffer);
                    sQLitePreparedStatementExecuteFast.bindLong(2, j);
                    sQLitePreparedStatementExecuteFast.bindLong(3, j3);
                    sQLitePreparedStatementExecuteFast.step();
                    nativeByteBuffer.reuse();
                    sQLitePreparedStatementExecuteFast.dispose();
                }
            }
            sQLiteCursorQueryFinalized.dispose();
            this.database.commitTransaction();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void updateMessagePollResults(final long pollId, final TLRPC$Poll poll, final TLRPC$PollResults results) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$dfB1DtGZkbpCOWJkVjjgOf_wfgA
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateMessagePollResults$70$MessagesStorage(pollId, poll, results);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateMessagePollResults$70, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateMessagePollResults$70$MessagesStorage(long j, TLRPC$Poll tLRPC$Poll, TLRPC$PollResults tLRPC$PollResults) {
        ArrayList arrayList;
        int i;
        LongSparseArray longSparseArray = null;
        try {
            SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT uid, mid FROM polls_v2 WHERE id = %d", Long.valueOf(j)), new Object[0]);
            while (sQLiteCursorQueryFinalized.next()) {
                long jLongValue = sQLiteCursorQueryFinalized.longValue(0);
                if (longSparseArray == null) {
                    longSparseArray = new LongSparseArray();
                }
                ArrayList arrayList2 = (ArrayList) longSparseArray.get(jLongValue);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    longSparseArray.put(jLongValue, arrayList2);
                }
                arrayList2.add(Integer.valueOf(sQLiteCursorQueryFinalized.intValue(1)));
            }
            sQLiteCursorQueryFinalized.dispose();
            if (longSparseArray != null) {
                this.database.beginTransaction();
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("UPDATE messages_v2 SET data = ? WHERE mid = ? AND uid = ?");
                int size = longSparseArray.size();
                for (int i2 = 0; i2 < size; i2++) {
                    long jKeyAt = longSparseArray.keyAt(i2);
                    ArrayList arrayList3 = (ArrayList) longSparseArray.valueAt(i2);
                    int i3 = 0;
                    for (int size2 = arrayList3.size(); i3 < size2; size2 = i) {
                        Integer num = (Integer) arrayList3.get(i3);
                        SQLiteDatabase sQLiteDatabase = this.database;
                        Locale locale = Locale.US;
                        LongSparseArray longSparseArray2 = longSparseArray;
                        int i4 = size;
                        SQLiteCursor sQLiteCursorQueryFinalized2 = sQLiteDatabase.queryFinalized(String.format(locale, "SELECT data FROM messages_v2 WHERE mid = %d AND uid = %d", num, Long.valueOf(jKeyAt)), new Object[0]);
                        if (sQLiteCursorQueryFinalized2.next()) {
                            NativeByteBuffer nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized2.byteBufferValue(0);
                            if (nativeByteBufferByteBufferValue != null) {
                                TLRPC$Message tLRPC$MessageTLdeserialize = TLRPC$Message.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                                arrayList = arrayList3;
                                i = size2;
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
                                    NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(tLRPC$MessageTLdeserialize.getObjectSize());
                                    tLRPC$MessageTLdeserialize.serializeToStream(nativeByteBuffer);
                                    sQLitePreparedStatementExecuteFast.requery();
                                    sQLitePreparedStatementExecuteFast.bindByteBuffer(1, nativeByteBuffer);
                                    sQLitePreparedStatementExecuteFast.bindInteger(2, num.intValue());
                                    sQLitePreparedStatementExecuteFast.bindLong(3, jKeyAt);
                                    sQLitePreparedStatementExecuteFast.step();
                                    nativeByteBuffer.reuse();
                                }
                            } else {
                                arrayList = arrayList3;
                                i = size2;
                            }
                        } else {
                            arrayList = arrayList3;
                            i = size2;
                            this.database.executeFast(String.format(locale, "DELETE FROM polls_v2 WHERE mid = %d AND uid = %d", num, Long.valueOf(jKeyAt))).stepThis().dispose();
                        }
                        sQLiteCursorQueryFinalized2.dispose();
                        i3++;
                        longSparseArray = longSparseArray2;
                        arrayList3 = arrayList;
                        size = i4;
                    }
                }
                sQLitePreparedStatementExecuteFast.dispose();
                this.database.commitTransaction();
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void updateMessageReactions(final long dialogId, final int msgId, final TLRPC$TL_messageReactions reactions) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$-yaKdJO_vouRygBRxPZV3R4Uaf4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateMessageReactions$71$MessagesStorage(msgId, dialogId, reactions);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateMessageReactions$71, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateMessageReactions$71$MessagesStorage(int i, long j, TLRPC$TL_messageReactions tLRPC$TL_messageReactions) {
        NativeByteBuffer nativeByteBufferByteBufferValue;
        try {
            this.database.beginTransaction();
            SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT data FROM messages_v2 WHERE mid = %d AND uid = %d", Integer.valueOf(i), Long.valueOf(j)), new Object[0]);
            if (sQLiteCursorQueryFinalized.next() && (nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized.byteBufferValue(0)) != null) {
                TLRPC$Message tLRPC$MessageTLdeserialize = TLRPC$Message.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                if (tLRPC$MessageTLdeserialize != null) {
                    tLRPC$MessageTLdeserialize.readAttachPath(nativeByteBufferByteBufferValue, getUserConfig().clientUserId);
                    nativeByteBufferByteBufferValue.reuse();
                    MessageObject.updateReactions(tLRPC$MessageTLdeserialize, tLRPC$TL_messageReactions);
                    SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("UPDATE messages_v2 SET data = ? WHERE mid = ? AND uid = ?");
                    NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(tLRPC$MessageTLdeserialize.getObjectSize());
                    tLRPC$MessageTLdeserialize.serializeToStream(nativeByteBuffer);
                    sQLitePreparedStatementExecuteFast.requery();
                    sQLitePreparedStatementExecuteFast.bindByteBuffer(1, nativeByteBuffer);
                    sQLitePreparedStatementExecuteFast.bindInteger(2, i);
                    sQLitePreparedStatementExecuteFast.bindLong(3, j);
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

    public void getNewTask(final LongSparseArray<ArrayList<Integer>> oldTask, final LongSparseArray<ArrayList<Integer>> oldTaskMedia) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$7bj_S04zhKy5NGNAYxVadRmcbAs
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getNewTask$72$MessagesStorage(oldTask, oldTaskMedia);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getNewTask$72, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getNewTask$72$MessagesStorage(LongSparseArray longSparseArray, LongSparseArray longSparseArray2) {
        boolean z;
        LongSparseArray<ArrayList<Integer>> longSparseArray3;
        if (longSparseArray != null) {
            try {
                int size = longSparseArray.size();
                for (int i = 0; i < size; i++) {
                    this.database.executeFast(String.format(Locale.US, "DELETE FROM enc_tasks_v4 WHERE mid IN(%s) AND uid = %d AND media = 0", TextUtils.join(",", (Iterable) longSparseArray.valueAt(i)), Long.valueOf(longSparseArray.keyAt(i)))).stepThis().dispose();
                }
            } catch (Exception e) {
                FileLog.e(e);
                return;
            }
        }
        if (longSparseArray2 != null) {
            int size2 = longSparseArray2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                this.database.executeFast(String.format(Locale.US, "DELETE FROM enc_tasks_v4 WHERE mid IN(%s) AND uid = %d AND media = 1", TextUtils.join(",", (Iterable) longSparseArray2.valueAt(i2)), Long.valueOf(longSparseArray2.keyAt(i2)))).stepThis().dispose();
            }
        }
        SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized("SELECT mid, date, media, uid FROM enc_tasks_v4 WHERE date = (SELECT min(date) FROM enc_tasks_v4)", new Object[0]);
        LongSparseArray<ArrayList<Integer>> longSparseArray4 = null;
        LongSparseArray<ArrayList<Integer>> longSparseArray5 = null;
        int i3 = 0;
        while (sQLiteCursorQueryFinalized.next()) {
            int iIntValue = sQLiteCursorQueryFinalized.intValue(0);
            int iIntValue2 = sQLiteCursorQueryFinalized.intValue(1);
            int iIntValue3 = sQLiteCursorQueryFinalized.intValue(2);
            long jLongValue = sQLiteCursorQueryFinalized.longValue(3);
            if (iIntValue3 == -1) {
                z = iIntValue > 0;
            } else if (iIntValue3 != 0) {
            }
            if (z) {
                if (longSparseArray5 == null) {
                    longSparseArray5 = new LongSparseArray<>();
                }
                longSparseArray3 = longSparseArray5;
            } else {
                if (longSparseArray4 == null) {
                    longSparseArray4 = new LongSparseArray<>();
                }
                longSparseArray3 = longSparseArray5;
                longSparseArray5 = longSparseArray4;
            }
            ArrayList<Integer> arrayList = longSparseArray5.get(jLongValue);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                longSparseArray5.put(jLongValue, arrayList);
            }
            arrayList.add(Integer.valueOf(iIntValue));
            i3 = iIntValue2;
            longSparseArray5 = longSparseArray3;
        }
        sQLiteCursorQueryFinalized.dispose();
        getMessagesController().processLoadedDeleteTask(i3, longSparseArray4, longSparseArray5);
    }

    public void markMentionMessageAsRead(final long dialogId, final int messageId, final long did) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$IwyZW9OOpyu-XC_TOYB5UBLKYpA
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$markMentionMessageAsRead$73$MessagesStorage(messageId, dialogId, did);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$markMentionMessageAsRead$73, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$markMentionMessageAsRead$73$MessagesStorage(int i, long j, long j2) {
        try {
            SQLiteDatabase sQLiteDatabase = this.database;
            Locale locale = Locale.US;
            sQLiteDatabase.executeFast(String.format(locale, "UPDATE messages_v2 SET read_state = read_state | 2 WHERE mid = %d AND uid = %d", Integer.valueOf(i), Long.valueOf(j))).stepThis().dispose();
            SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized("SELECT unread_count_i FROM dialogs WHERE did = " + j2, new Object[0]);
            int iMax = sQLiteCursorQueryFinalized.next() ? Math.max(0, sQLiteCursorQueryFinalized.intValue(0) - 1) : 0;
            sQLiteCursorQueryFinalized.dispose();
            this.database.executeFast(String.format(locale, "UPDATE dialogs SET unread_count_i = %d WHERE did = %d", Integer.valueOf(iMax), Long.valueOf(j2))).stepThis().dispose();
            LongSparseIntArray longSparseIntArray = new LongSparseIntArray(1);
            longSparseIntArray.put(j2, iMax);
            if (iMax == 0) {
                updateFiltersReadCounter(null, longSparseIntArray, true);
            }
            getMessagesController().processDialogsUpdateRead(null, longSparseIntArray);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void markMessageAsMention(final long dialogId, final int mid) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$JV0d8sGDuNqpMSOQSczzxgNi_fE
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$markMessageAsMention$74$MessagesStorage(mid, dialogId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$markMessageAsMention$74, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$markMessageAsMention$74$MessagesStorage(int i, long j) {
        try {
            this.database.executeFast(String.format(Locale.US, "UPDATE messages_v2 SET mention = 1, read_state = read_state & ~2 WHERE mid = %d AND uid = %d", Integer.valueOf(i), Long.valueOf(j))).stepThis().dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void resetMentionsCount(final long did, final int count) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$ROg5RA_b4H-DIgh1S_i8MKrYxOM
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$resetMentionsCount$75$MessagesStorage(did, count);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$resetMentionsCount$75, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$resetMentionsCount$75$MessagesStorage(long j, int i) {
        try {
            SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized("SELECT unread_count_i FROM dialogs WHERE did = " + j, new Object[0]);
            int iIntValue = sQLiteCursorQueryFinalized.next() ? sQLiteCursorQueryFinalized.intValue(0) : 0;
            sQLiteCursorQueryFinalized.dispose();
            if (iIntValue == 0 && i == 0) {
                return;
            }
            if (i == 0) {
                this.database.executeFast(String.format(Locale.US, "UPDATE messages_v2 SET read_state = read_state | 2 WHERE uid = %d AND mention = 1 AND read_state IN(0, 1)", Long.valueOf(j))).stepThis().dispose();
            }
            this.database.executeFast(String.format(Locale.US, "UPDATE dialogs SET unread_count_i = %d WHERE did = %d", Integer.valueOf(i), Long.valueOf(j))).stepThis().dispose();
            LongSparseIntArray longSparseIntArray = new LongSparseIntArray(1);
            longSparseIntArray.put(j, i);
            getMessagesController().processDialogsUpdateRead(null, longSparseIntArray);
            if (i == 0) {
                updateFiltersReadCounter(null, longSparseIntArray, true);
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void createTaskForMid(final long dialogId, final int messageId, final int time, final int readTime, final int ttl, final boolean inner) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$DQR2uS9cjjKydPhupvXh7nKGKYA
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createTaskForMid$77$MessagesStorage(time, readTime, ttl, messageId, inner, dialogId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createTaskForMid$77, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createTaskForMid$77$MessagesStorage(int i, int i2, int i3, int i4, final boolean z, final long j) {
        try {
            int iMax = Math.max(i, i2) + i3;
            SparseArray<ArrayList<Integer>> sparseArray = new SparseArray<>();
            final ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(Integer.valueOf(i4));
            sparseArray.put(iMax, arrayList);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$FwrpOnzL4WxGctNYXhm7YToUux0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$createTaskForMid$76$MessagesStorage(z, j, arrayList);
                }
            });
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("REPLACE INTO enc_tasks_v4 VALUES(?, ?, ?, ?)");
            for (int i5 = 0; i5 < sparseArray.size(); i5++) {
                int iKeyAt = sparseArray.keyAt(i5);
                ArrayList<Integer> arrayList2 = sparseArray.get(iKeyAt);
                for (int i6 = 0; i6 < arrayList2.size(); i6++) {
                    sQLitePreparedStatementExecuteFast.requery();
                    sQLitePreparedStatementExecuteFast.bindInteger(1, arrayList2.get(i6).intValue());
                    sQLitePreparedStatementExecuteFast.bindLong(2, j);
                    sQLitePreparedStatementExecuteFast.bindInteger(3, iKeyAt);
                    sQLitePreparedStatementExecuteFast.bindInteger(4, 1);
                    sQLitePreparedStatementExecuteFast.step();
                }
            }
            sQLitePreparedStatementExecuteFast.dispose();
            this.database.executeFast(String.format(Locale.US, "UPDATE messages_v2 SET ttl = 0 WHERE mid = %d AND uid = %d", Integer.valueOf(i4), Long.valueOf(j))).stepThis().dispose();
            getMessagesController().didAddedNewTask(iMax, j, sparseArray);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createTaskForMid$76, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createTaskForMid$76$MessagesStorage(boolean z, long j, ArrayList arrayList) {
        if (!z) {
            markMessagesContentAsRead(j, arrayList, 0);
        }
        getNotificationCenter().postNotificationName(NotificationCenter.messagesReadContent, Long.valueOf(j), arrayList);
    }

    public void createTaskForSecretChat(final int chatId, final int time, final int readTime, final int isOut, final ArrayList<Long> random_ids) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$zYfIIyhY9aRecij8s94NsZ1UeT4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createTaskForSecretChat$79$MessagesStorage(chatId, random_ids, isOut, time, readTime);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createTaskForSecretChat$79, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createTaskForSecretChat$79$MessagesStorage(int i, ArrayList arrayList, int i2, int i3, int i4) {
        SQLiteCursor sQLiteCursorQueryFinalized;
        try {
            final long jMakeEncryptedDialogId = DialogObject.makeEncryptedDialogId(i);
            SparseArray<ArrayList<Integer>> sparseArray = new SparseArray<>();
            final ArrayList arrayList2 = new ArrayList();
            StringBuilder sb = new StringBuilder();
            if (arrayList == null) {
                sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT mid, ttl FROM messages_v2 WHERE uid = %d AND out = %d AND read_state > 0 AND ttl > 0 AND date <= %d AND send_state = 0 AND media != 1", Long.valueOf(jMakeEncryptedDialogId), Integer.valueOf(i2), Integer.valueOf(i3)), new Object[0]);
            } else {
                sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT m.mid, m.ttl FROM messages_v2 as m INNER JOIN randoms_v2 as r ON m.mid = r.mid AND m.uid = r.uid WHERE r.random_id IN (%s)", TextUtils.join(",", arrayList)), new Object[0]);
            }
            int iMin = ConnectionsManager.DEFAULT_DATACENTER_ID;
            while (sQLiteCursorQueryFinalized.next()) {
                int iIntValue = sQLiteCursorQueryFinalized.intValue(1);
                int iIntValue2 = sQLiteCursorQueryFinalized.intValue(0);
                if (arrayList != null) {
                    arrayList2.add(Integer.valueOf(iIntValue2));
                }
                if (iIntValue > 0) {
                    int iMax = Math.max(i3, i4) + iIntValue;
                    iMin = Math.min(iMin, iMax);
                    ArrayList<Integer> arrayList3 = sparseArray.get(iMax);
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList<>();
                        sparseArray.put(iMax, arrayList3);
                    }
                    if (sb.length() != 0) {
                        sb.append(",");
                    }
                    sb.append(iIntValue2);
                    arrayList3.add(Integer.valueOf(iIntValue2));
                }
            }
            sQLiteCursorQueryFinalized.dispose();
            if (arrayList != null) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$ej7nDH7lvPGAaCw4kqn4JIp6pws
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$createTaskForSecretChat$78$MessagesStorage(jMakeEncryptedDialogId, arrayList2);
                    }
                });
            }
            if (sparseArray.size() != 0) {
                this.database.beginTransaction();
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("REPLACE INTO enc_tasks_v4 VALUES(?, ?, ?, ?)");
                for (int i5 = 0; i5 < sparseArray.size(); i5++) {
                    int iKeyAt = sparseArray.keyAt(i5);
                    ArrayList<Integer> arrayList4 = sparseArray.get(iKeyAt);
                    for (int i6 = 0; i6 < arrayList4.size(); i6++) {
                        sQLitePreparedStatementExecuteFast.requery();
                        sQLitePreparedStatementExecuteFast.bindInteger(1, arrayList4.get(i6).intValue());
                        sQLitePreparedStatementExecuteFast.bindLong(2, jMakeEncryptedDialogId);
                        sQLitePreparedStatementExecuteFast.bindInteger(3, iKeyAt);
                        sQLitePreparedStatementExecuteFast.bindInteger(4, 0);
                        sQLitePreparedStatementExecuteFast.step();
                    }
                }
                sQLitePreparedStatementExecuteFast.dispose();
                this.database.commitTransaction();
                this.database.executeFast(String.format(Locale.US, "UPDATE messages_v2 SET ttl = 0 WHERE mid IN(%s) AND uid = %d", sb.toString(), Long.valueOf(jMakeEncryptedDialogId))).stepThis().dispose();
                getMessagesController().didAddedNewTask(iMin, jMakeEncryptedDialogId, sparseArray);
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createTaskForSecretChat$78, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createTaskForSecretChat$78$MessagesStorage(long j, ArrayList arrayList) {
        markMessagesContentAsRead(j, arrayList, 0);
        getNotificationCenter().postNotificationName(NotificationCenter.messagesReadContent, Long.valueOf(j), arrayList);
    }

    /* JADX WARN: Removed duplicated region for block: B:137:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0561  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0598  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x0651  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0688  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x06bf  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x06f6  */
    /* JADX WARN: Removed duplicated region for block: B:370:0x0785 A[PHI: r3
      0x0785: PHI (r3v32 androidx.collection.LongSparseArray) = (r3v31 androidx.collection.LongSparseArray), (r3v33 androidx.collection.LongSparseArray) binds: [B:375:0x0793, B:369:0x0783] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:493:0x094f  */
    /* JADX WARN: Removed duplicated region for block: B:507:0x0985  */
    /* JADX WARN: Removed duplicated region for block: B:555:0x0a3b  */
    /* JADX WARN: Removed duplicated region for block: B:569:0x0a71  */
    /* JADX WARN: Removed duplicated region for block: B:583:0x0aa7  */
    /* JADX WARN: Removed duplicated region for block: B:597:0x0add  */
    /* JADX WARN: Removed duplicated region for block: B:619:0x0b29  */
    /* JADX WARN: Removed duplicated region for block: B:662:0x0bd7  */
    /* JADX WARN: Removed duplicated region for block: B:686:0x0c18  */
    /* JADX WARN: Removed duplicated region for block: B:719:0x0ca5  */
    /* JADX WARN: Removed duplicated region for block: B:720:0x0cae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void updateFiltersReadCounter(ir.eitaa.messenger.support.LongSparseIntArray r28, ir.eitaa.messenger.support.LongSparseIntArray r29, boolean r30) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 3291
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessagesStorage.updateFiltersReadCounter(ir.eitaa.messenger.support.LongSparseIntArray, ir.eitaa.messenger.support.LongSparseIntArray, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateFiltersReadCounter$80, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateFiltersReadCounter$80$MessagesStorage() {
        ArrayList<MessagesController.DialogFilter> arrayList = getMessagesController().dialogFilters;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList.get(i).unreadCount = arrayList.get(i).pendingUnreadCount;
        }
        this.mainUnreadCount = this.pendingMainUnreadCount;
        this.archiveUnreadCount = this.pendingArchiveUnreadCount;
    }

    private void updateDialogsWithReadMessagesInternal(ArrayList<Integer> messages, LongSparseIntArray inbox, LongSparseIntArray outbox, LongSparseArray<ArrayList<Integer>> mentions) {
        int i;
        try {
            LongSparseIntArray longSparseIntArray = new LongSparseIntArray();
            LongSparseIntArray longSparseIntArray2 = new LongSparseIntArray();
            ArrayList<Long> arrayList = new ArrayList<>();
            int i2 = 2;
            if (!isEmpty(messages)) {
                SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT uid, read_state, out FROM messages_v2 WHERE mid IN(%s) AND is_channel = 0", TextUtils.join(",", messages)), new Object[0]);
                while (sQLiteCursorQueryFinalized.next()) {
                    if (sQLiteCursorQueryFinalized.intValue(2) == 0 && sQLiteCursorQueryFinalized.intValue(1) == 0) {
                        long jLongValue = sQLiteCursorQueryFinalized.longValue(0);
                        int i3 = longSparseIntArray.get(jLongValue);
                        if (i3 == 0) {
                            longSparseIntArray.put(jLongValue, 1);
                        } else {
                            longSparseIntArray.put(jLongValue, i3 + 1);
                        }
                    }
                }
                sQLiteCursorQueryFinalized.dispose();
            } else {
                if (!isEmpty(inbox)) {
                    int i4 = 0;
                    while (i4 < inbox.size()) {
                        long jKeyAt = inbox.keyAt(i4);
                        int i5 = inbox.get(jKeyAt);
                        SQLiteDatabase sQLiteDatabase = this.database;
                        Locale locale = Locale.US;
                        Object[] objArr = new Object[i2];
                        objArr[0] = Long.valueOf(jKeyAt);
                        objArr[1] = Integer.valueOf(i5);
                        SQLiteCursor sQLiteCursorQueryFinalized2 = sQLiteDatabase.queryFinalized(String.format(locale, "SELECT COUNT(mid) FROM messages_v2 WHERE uid = %d AND mid > %d AND read_state IN(0,2) AND out = 0", objArr), new Object[0]);
                        if (sQLiteCursorQueryFinalized2.next()) {
                            longSparseIntArray.put(jKeyAt, sQLiteCursorQueryFinalized2.intValue(0));
                        }
                        sQLiteCursorQueryFinalized2.dispose();
                        SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("UPDATE dialogs SET inbox_max = max((SELECT inbox_max FROM dialogs WHERE did = ?), ?) WHERE did = ?");
                        sQLitePreparedStatementExecuteFast.requery();
                        sQLitePreparedStatementExecuteFast.bindLong(1, jKeyAt);
                        sQLitePreparedStatementExecuteFast.bindInteger(2, i5);
                        sQLitePreparedStatementExecuteFast.bindLong(3, jKeyAt);
                        sQLitePreparedStatementExecuteFast.step();
                        sQLitePreparedStatementExecuteFast.dispose();
                        i4++;
                        i2 = 2;
                    }
                }
                if (!isEmpty(mentions)) {
                    int size = mentions.size();
                    int i6 = 0;
                    while (i6 < size) {
                        ArrayList<Integer> arrayListValueAt = mentions.valueAt(i6);
                        ArrayList arrayList2 = new ArrayList(arrayListValueAt);
                        int i7 = 0;
                        SQLiteCursor sQLiteCursorQueryFinalized3 = this.database.queryFinalized(String.format(Locale.US, "SELECT uid, read_state, out, mention, mid, is_channel FROM messages_v2 WHERE mid IN(%s)", TextUtils.join(",", arrayListValueAt)), new Object[0]);
                        long jLongValue2 = 0;
                        while (sQLiteCursorQueryFinalized3.next()) {
                            long jLongValue3 = sQLiteCursorQueryFinalized3.longValue(i7);
                            arrayList2.remove(Integer.valueOf(sQLiteCursorQueryFinalized3.intValue(4)));
                            if (sQLiteCursorQueryFinalized3.intValue(1) < 2 && sQLiteCursorQueryFinalized3.intValue(2) == 0 && sQLiteCursorQueryFinalized3.intValue(3) == 1) {
                                int i8 = longSparseIntArray2.get(jLongValue3, -1);
                                if (i8 < 0) {
                                    i = size;
                                    SQLiteCursor sQLiteCursorQueryFinalized4 = this.database.queryFinalized("SELECT unread_count_i FROM dialogs WHERE did = " + jLongValue3, new Object[0]);
                                    int iIntValue = sQLiteCursorQueryFinalized4.next() ? sQLiteCursorQueryFinalized4.intValue(0) : 0;
                                    sQLiteCursorQueryFinalized4.dispose();
                                    longSparseIntArray2.put(jLongValue3, Math.max(0, iIntValue - 1));
                                } else {
                                    i = size;
                                    longSparseIntArray2.put(jLongValue3, Math.max(0, i8 - 1));
                                }
                            } else {
                                i = size;
                            }
                            jLongValue2 = sQLiteCursorQueryFinalized3.longValue(5);
                            size = i;
                            i7 = 0;
                        }
                        int i9 = size;
                        sQLiteCursorQueryFinalized3.dispose();
                        if (!arrayList2.isEmpty() && jLongValue2 != 0 && !arrayList.contains(Long.valueOf(jLongValue2))) {
                            arrayList.add(Long.valueOf(jLongValue2));
                        }
                        i6++;
                        size = i9;
                    }
                }
                if (!isEmpty(outbox)) {
                    for (int i10 = 0; i10 < outbox.size(); i10++) {
                        long jKeyAt2 = outbox.keyAt(i10);
                        int i11 = outbox.get(jKeyAt2);
                        SQLitePreparedStatement sQLitePreparedStatementExecuteFast2 = this.database.executeFast("UPDATE dialogs SET outbox_max = max((SELECT outbox_max FROM dialogs WHERE did = ?), ?) WHERE did = ?");
                        sQLitePreparedStatementExecuteFast2.requery();
                        sQLitePreparedStatementExecuteFast2.bindLong(1, jKeyAt2);
                        sQLitePreparedStatementExecuteFast2.bindInteger(2, i11);
                        sQLitePreparedStatementExecuteFast2.bindLong(3, jKeyAt2);
                        sQLitePreparedStatementExecuteFast2.step();
                        sQLitePreparedStatementExecuteFast2.dispose();
                    }
                }
            }
            if (longSparseIntArray.size() > 0 || longSparseIntArray2.size() > 0) {
                this.database.beginTransaction();
                if (longSparseIntArray.size() > 0) {
                    ArrayList<Long> arrayList3 = new ArrayList<>();
                    SQLitePreparedStatement sQLitePreparedStatementExecuteFast3 = this.database.executeFast("UPDATE dialogs SET unread_count = ? WHERE did = ?");
                    int i12 = 0;
                    while (i12 < longSparseIntArray.size()) {
                        long jKeyAt3 = longSparseIntArray.keyAt(i12);
                        int iValueAt = longSparseIntArray.valueAt(i12);
                        SQLiteCursor sQLiteCursorQueryFinalized5 = this.database.queryFinalized("SELECT unread_count FROM dialogs WHERE did = " + jKeyAt3, new Object[0]);
                        int iIntValue2 = sQLiteCursorQueryFinalized5.next() ? sQLiteCursorQueryFinalized5.intValue(0) : 0;
                        sQLiteCursorQueryFinalized5.dispose();
                        if (iIntValue2 == iValueAt) {
                            longSparseIntArray.removeAt(i12);
                            i12--;
                        } else {
                            sQLitePreparedStatementExecuteFast3.requery();
                            sQLitePreparedStatementExecuteFast3.bindInteger(1, iValueAt);
                            sQLitePreparedStatementExecuteFast3.bindLong(2, jKeyAt3);
                            sQLitePreparedStatementExecuteFast3.step();
                            arrayList3.add(Long.valueOf(jKeyAt3));
                        }
                        i12++;
                    }
                    sQLitePreparedStatementExecuteFast3.dispose();
                    updateWidgets(arrayList3);
                }
                if (longSparseIntArray2.size() > 0) {
                    SQLitePreparedStatement sQLitePreparedStatementExecuteFast4 = this.database.executeFast("UPDATE dialogs SET unread_count_i = ? WHERE did = ?");
                    for (int i13 = 0; i13 < longSparseIntArray2.size(); i13++) {
                        sQLitePreparedStatementExecuteFast4.requery();
                        sQLitePreparedStatementExecuteFast4.bindInteger(1, longSparseIntArray2.valueAt(i13));
                        sQLitePreparedStatementExecuteFast4.bindLong(2, longSparseIntArray2.keyAt(i13));
                        sQLitePreparedStatementExecuteFast4.step();
                    }
                    sQLitePreparedStatementExecuteFast4.dispose();
                }
                this.database.commitTransaction();
            }
            updateFiltersReadCounter(longSparseIntArray, longSparseIntArray2, true);
            getMessagesController().processDialogsUpdateRead(longSparseIntArray, longSparseIntArray2);
            if (arrayList.isEmpty()) {
                return;
            }
            getMessagesController().reloadMentionsCountForChannels(arrayList);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    private static boolean isEmpty(SparseArray<?> array) {
        return array == null || array.size() == 0;
    }

    private static boolean isEmpty(LongSparseIntArray array) {
        return array == null || array.size() == 0;
    }

    private static boolean isEmpty(List<?> array) {
        return array == null || array.isEmpty();
    }

    private static boolean isEmpty(SparseIntArray array) {
        return array == null || array.size() == 0;
    }

    private static boolean isEmpty(LongSparseArray<?> array) {
        return array == null || array.size() == 0;
    }

    public void updateDialogsWithReadMessages(final LongSparseIntArray inbox, final LongSparseIntArray outbox, final LongSparseArray<ArrayList<Integer>> mentions, boolean useQueue) {
        if (isEmpty(inbox) && isEmpty(outbox) && isEmpty(mentions)) {
            return;
        }
        if (useQueue) {
            this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$Ush4Bw22sHDb5BJ7nGmit9Hsqck
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$updateDialogsWithReadMessages$81$MessagesStorage(inbox, outbox, mentions);
                }
            });
        } else {
            updateDialogsWithReadMessagesInternal(null, inbox, outbox, mentions);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateDialogsWithReadMessages$81, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateDialogsWithReadMessages$81$MessagesStorage(LongSparseIntArray longSparseIntArray, LongSparseIntArray longSparseIntArray2, LongSparseArray longSparseArray) {
        updateDialogsWithReadMessagesInternal(null, longSparseIntArray, longSparseIntArray2, longSparseArray);
    }

    public void updateChatParticipants(final TLRPC$ChatParticipants participants) {
        if (participants == null) {
            return;
        }
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$ef5Web-AlNUBSnAy4hBBnfJ0F5g
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateChatParticipants$83$MessagesStorage(participants);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateChatParticipants$83, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateChatParticipants$83$MessagesStorage(TLRPC$ChatParticipants tLRPC$ChatParticipants) {
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
                tLRPC$ChatFullTLdeserialize.inviterId = sQLiteCursorQueryFinalized.longValue(3);
            }
            sQLiteCursorQueryFinalized.dispose();
            if (tLRPC$ChatFullTLdeserialize instanceof TLRPC$TL_chatFull) {
                tLRPC$ChatFullTLdeserialize.participants = tLRPC$ChatParticipants;
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$lQAjdQdHULpxEkGkBqqYuVr9BT0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$updateChatParticipants$82$MessagesStorage(tLRPC$ChatFullTLdeserialize);
                    }
                });
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("REPLACE INTO chat_settings_v2 VALUES(?, ?, ?, ?, ?, ?)");
                NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(tLRPC$ChatFullTLdeserialize.getObjectSize());
                tLRPC$ChatFullTLdeserialize.serializeToStream(nativeByteBuffer);
                sQLitePreparedStatementExecuteFast.bindLong(1, tLRPC$ChatFullTLdeserialize.id);
                sQLitePreparedStatementExecuteFast.bindByteBuffer(2, nativeByteBuffer);
                sQLitePreparedStatementExecuteFast.bindInteger(3, tLRPC$ChatFullTLdeserialize.pinned_msg_id);
                sQLitePreparedStatementExecuteFast.bindInteger(4, tLRPC$ChatFullTLdeserialize.online_count);
                sQLitePreparedStatementExecuteFast.bindLong(5, tLRPC$ChatFullTLdeserialize.inviterId);
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
    /* renamed from: lambda$updateChatParticipants$82, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateChatParticipants$82$MessagesStorage(TLRPC$ChatFull tLRPC$ChatFull) {
        NotificationCenter notificationCenter = getNotificationCenter();
        int i = NotificationCenter.chatInfoDidLoad;
        Boolean bool = Boolean.FALSE;
        notificationCenter.postNotificationName(i, tLRPC$ChatFull, 0, bool, bool);
    }

    public void loadChannelAdmins(final long chatId) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$r6SvUYV_7czujkIsgpnp3MrIyOs
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadChannelAdmins$84$MessagesStorage(chatId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadChannelAdmins$84, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadChannelAdmins$84$MessagesStorage(long j) {
        try {
            SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized("SELECT uid, data FROM channel_admins_v3 WHERE did = " + j, new Object[0]);
            LongSparseArray<TLRPC$ChannelParticipant> longSparseArray = new LongSparseArray<>();
            while (sQLiteCursorQueryFinalized.next()) {
                NativeByteBuffer nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized.byteBufferValue(1);
                if (nativeByteBufferByteBufferValue != null) {
                    TLRPC$ChannelParticipant tLRPC$ChannelParticipantTLdeserialize = TLRPC$ChannelParticipant.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                    nativeByteBufferByteBufferValue.reuse();
                    if (tLRPC$ChannelParticipantTLdeserialize != null) {
                        longSparseArray.put(sQLiteCursorQueryFinalized.longValue(0), tLRPC$ChannelParticipantTLdeserialize);
                    }
                }
            }
            sQLiteCursorQueryFinalized.dispose();
            getMessagesController().processLoadedChannelAdmins(longSparseArray, j, true);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void putChannelAdmins(final long chatId, final LongSparseArray<TLRPC$ChannelParticipant> ids) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$3Bi86swg-Ov1bdu1FkWlc1X5r5M
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$putChannelAdmins$85$MessagesStorage(chatId, ids);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$putChannelAdmins$85, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$putChannelAdmins$85$MessagesStorage(long j, LongSparseArray longSparseArray) {
        try {
            this.database.executeFast("DELETE FROM channel_admins_v3 WHERE did = " + j).stepThis().dispose();
            this.database.beginTransaction();
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("REPLACE INTO channel_admins_v3 VALUES(?, ?, ?)");
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            for (int i = 0; i < longSparseArray.size(); i++) {
                sQLitePreparedStatementExecuteFast.requery();
                sQLitePreparedStatementExecuteFast.bindLong(1, j);
                sQLitePreparedStatementExecuteFast.bindLong(2, longSparseArray.keyAt(i));
                TLRPC$ChannelParticipant tLRPC$ChannelParticipant = (TLRPC$ChannelParticipant) longSparseArray.valueAt(i);
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

    public void updateChannelUsers(final long channelId, final ArrayList<TLRPC$ChannelParticipant> participants) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$u967bKRkVFxo0nQSYJDIEzSIg5Q
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateChannelUsers$86$MessagesStorage(channelId, participants);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateChannelUsers$86, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateChannelUsers$86$MessagesStorage(long j, ArrayList arrayList) {
        long j2 = -j;
        try {
            this.database.executeFast("DELETE FROM channel_users_v2 WHERE did = " + j2).stepThis().dispose();
            this.database.beginTransaction();
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("REPLACE INTO channel_users_v2 VALUES(?, ?, ?, ?)");
            int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            for (int i = 0; i < arrayList.size(); i++) {
                TLRPC$ChannelParticipant tLRPC$ChannelParticipant = (TLRPC$ChannelParticipant) arrayList.get(i);
                sQLitePreparedStatementExecuteFast.requery();
                sQLitePreparedStatementExecuteFast.bindLong(1, j2);
                sQLitePreparedStatementExecuteFast.bindLong(2, MessageObject.getPeerId(tLRPC$ChannelParticipant.peer));
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
            loadChatInfo(j, true, null, false, true);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void saveBotCache(final String key, final TLObject result) {
        if (result == null || TextUtils.isEmpty(key)) {
            return;
        }
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$6-l2OBrOViBVAFBLOd62h4NBGQk
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$saveBotCache$87$MessagesStorage(result, key);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$saveBotCache$87, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$saveBotCache$87$MessagesStorage(TLObject tLObject, String str) {
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

    public void getBotCache(final String key, final RequestDelegate requestDelegate) {
        if (key == null || requestDelegate == null) {
            return;
        }
        final int currentTime = getConnectionsManager().getCurrentTime();
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$sAABFHZfuSTfafmcAgSIMMS9eSc
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f$0.lambda$getBotCache$88$MessagesStorage(currentTime, key, requestDelegate);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0056  */
    /* renamed from: lambda$getBotCache$88, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$getBotCache$88$MessagesStorage(int r5, java.lang.String r6, ir.eitaa.tgnet.RequestDelegate r7) throws java.lang.Throwable {
        /*
            r4 = this;
            r0 = 0
            ir.eitaa.SQLite.SQLiteDatabase r1 = r4.database     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L60
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L60
            r2.<init>()     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L60
            java.lang.String r3 = "DELETE FROM botcache WHERE date < "
            r2.append(r3)     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L60
            r2.append(r5)     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L60
            java.lang.String r5 = r2.toString()     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L60
            ir.eitaa.SQLite.SQLitePreparedStatement r5 = r1.executeFast(r5)     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L60
            ir.eitaa.SQLite.SQLitePreparedStatement r5 = r5.stepThis()     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L60
            r5.dispose()     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L60
            ir.eitaa.SQLite.SQLiteDatabase r5 = r4.database     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L60
            java.lang.String r1 = "SELECT data FROM botcache WHERE id = ?"
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L60
            r3 = 0
            r2[r3] = r6     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L60
            ir.eitaa.SQLite.SQLiteCursor r5 = r5.queryFinalized(r1, r2)     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L60
            boolean r6 = r5.next()     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L60
            if (r6 == 0) goto L56
            ir.eitaa.tgnet.NativeByteBuffer r6 = r5.byteBufferValue(r3)     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L5d
            if (r6 == 0) goto L56
            int r1 = r6.readInt32(r3)     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L5d
            int r2 = ir.eitaa.tgnet.TLRPC$TL_messages_botCallbackAnswer.constructor     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L5d
            if (r1 != r2) goto L46
            ir.eitaa.tgnet.TLRPC$TL_messages_botCallbackAnswer r1 = ir.eitaa.tgnet.TLRPC$TL_messages_botCallbackAnswer.TLdeserialize(r6, r1, r3)     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L5d
            goto L4a
        L46:
            ir.eitaa.tgnet.TLRPC$messages_BotResults r1 = ir.eitaa.tgnet.TLRPC$messages_BotResults.TLdeserialize(r6, r1, r3)     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L5d
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
            ir.eitaa.messenger.FileLog.e(r6)     // Catch: java.lang.Exception -> L5b java.lang.Throwable -> L69
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
            ir.eitaa.messenger.FileLog.e(r5)     // Catch: java.lang.Throwable -> L69
        L65:
            r7.run(r1, r0)
            return
        L69:
            r5 = move-exception
        L6a:
            r7.run(r1, r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessagesStorage.lambda$getBotCache$88$MessagesStorage(int, java.lang.String, ir.eitaa.tgnet.RequestDelegate):void");
    }

    public void loadUserInfo(final TLRPC$User user, final boolean force, final int classGuid, int fromMessageId) {
        if (user == null) {
            return;
        }
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$kyR1X_4zJdb870XPP8hdlH00jck
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f$0.lambda$loadUserInfo$89$MessagesStorage(user, force, classGuid);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadUserInfo$89, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadUserInfo$89$MessagesStorage(TLRPC$User tLRPC$User, boolean z, int i) throws Throwable {
        TLRPC$UserFull tLRPC$UserFull;
        int i2;
        boolean z2;
        MessagesController messagesController;
        boolean z3;
        TLRPC$User tLRPC$User2;
        boolean z4;
        int i3;
        TLRPC$UserFull tLRPC$UserFullTLdeserialize;
        SQLiteCursor sQLiteCursorQueryFinalized;
        int i4;
        boolean z5;
        ArrayList<MessageObject> arrayListLoadPinnedMessages;
        NativeByteBuffer nativeByteBufferByteBufferValue;
        HashMap<Integer, MessageObject> map = new HashMap<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        try {
            SQLiteCursor sQLiteCursorQueryFinalized2 = this.database.queryFinalized("SELECT info, pinned FROM user_settings WHERE uid = " + tLRPC$User.id, new Object[0]);
            if (!sQLiteCursorQueryFinalized2.next() || (nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized2.byteBufferValue(0)) == null) {
                tLRPC$UserFullTLdeserialize = null;
            } else {
                tLRPC$UserFullTLdeserialize = TLRPC$UserFull.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                try {
                    tLRPC$UserFullTLdeserialize.pinned_msg_id = sQLiteCursorQueryFinalized2.intValue(1);
                    nativeByteBufferByteBufferValue.reuse();
                } catch (Exception e) {
                    e = e;
                    tLRPC$UserFull = tLRPC$UserFullTLdeserialize;
                    i2 = 0;
                    z2 = false;
                    try {
                        FileLog.e(e);
                        messagesController = getMessagesController();
                        z3 = true;
                        tLRPC$User2 = tLRPC$User;
                        z4 = z;
                        i3 = i;
                        messagesController.processUserInfo(tLRPC$User2, tLRPC$UserFull, z3, z4, i3, arrayList, map, i2, z2);
                    } catch (Throwable th) {
                        th = th;
                        getMessagesController().processUserInfo(tLRPC$User, tLRPC$UserFull, true, z, i, arrayList, map, i2, z2);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    tLRPC$UserFull = tLRPC$UserFullTLdeserialize;
                    i2 = 0;
                    z2 = false;
                    getMessagesController().processUserInfo(tLRPC$User, tLRPC$UserFull, true, z, i, arrayList, map, i2, z2);
                    throw th;
                }
            }
            sQLiteCursorQueryFinalized2.dispose();
            SQLiteCursor sQLiteCursorQueryFinalized3 = getMessagesStorage().getDatabase().queryFinalized(String.format(Locale.US, "SELECT mid FROM chat_pinned_v2 WHERE uid = %d ORDER BY mid DESC", Long.valueOf(tLRPC$User.id)), new Object[0]);
            while (sQLiteCursorQueryFinalized3.next()) {
                int iIntValue = sQLiteCursorQueryFinalized3.intValue(0);
                arrayList.add(Integer.valueOf(iIntValue));
                map.put(Integer.valueOf(iIntValue), null);
            }
            sQLiteCursorQueryFinalized3.dispose();
            sQLiteCursorQueryFinalized = this.database.queryFinalized("SELECT count, end FROM chat_pinned_count WHERE uid = " + tLRPC$User.id, new Object[0]);
            if (sQLiteCursorQueryFinalized.next()) {
                int iIntValue2 = sQLiteCursorQueryFinalized.intValue(0);
                try {
                    i4 = iIntValue2;
                    z5 = sQLiteCursorQueryFinalized.intValue(1) != 0;
                } catch (Exception e2) {
                    e = e2;
                    i2 = iIntValue2;
                    tLRPC$UserFull = tLRPC$UserFullTLdeserialize;
                    z2 = false;
                    FileLog.e(e);
                    messagesController = getMessagesController();
                    z3 = true;
                    tLRPC$User2 = tLRPC$User;
                    z4 = z;
                    i3 = i;
                    messagesController.processUserInfo(tLRPC$User2, tLRPC$UserFull, z3, z4, i3, arrayList, map, i2, z2);
                } catch (Throwable th3) {
                    th = th3;
                    i2 = iIntValue2;
                    tLRPC$UserFull = tLRPC$UserFullTLdeserialize;
                    z2 = false;
                    getMessagesController().processUserInfo(tLRPC$User, tLRPC$UserFull, true, z, i, arrayList, map, i2, z2);
                    throw th;
                }
            } else {
                i4 = 0;
                z5 = false;
            }
        } catch (Exception e3) {
            e = e3;
            tLRPC$UserFull = null;
        } catch (Throwable th4) {
            th = th4;
            tLRPC$UserFull = null;
        }
        try {
            sQLiteCursorQueryFinalized.dispose();
            if (tLRPC$UserFullTLdeserialize != null && tLRPC$UserFullTLdeserialize.pinned_msg_id != 0 && (arrayList.isEmpty() || tLRPC$UserFullTLdeserialize.pinned_msg_id > arrayList.get(0).intValue())) {
                arrayList.clear();
                arrayList.add(Integer.valueOf(tLRPC$UserFullTLdeserialize.pinned_msg_id));
                map.put(Integer.valueOf(tLRPC$UserFullTLdeserialize.pinned_msg_id), null);
            }
            if (!arrayList.isEmpty() && (arrayListLoadPinnedMessages = getMediaDataController().loadPinnedMessages(tLRPC$User.id, 0L, arrayList, false)) != null) {
                int size = arrayListLoadPinnedMessages.size();
                for (int i5 = 0; i5 < size; i5++) {
                    MessageObject messageObject = arrayListLoadPinnedMessages.get(i5);
                    map.put(Integer.valueOf(messageObject.getId()), messageObject);
                }
            }
            messagesController = getMessagesController();
            z3 = true;
            tLRPC$User2 = tLRPC$User;
            tLRPC$UserFull = tLRPC$UserFullTLdeserialize;
            z4 = z;
            i3 = i;
            i2 = i4;
            z2 = z5;
        } catch (Exception e4) {
            e = e4;
            tLRPC$UserFull = tLRPC$UserFullTLdeserialize;
            i2 = i4;
            z2 = z5;
            FileLog.e(e);
            messagesController = getMessagesController();
            z3 = true;
            tLRPC$User2 = tLRPC$User;
            z4 = z;
            i3 = i;
            messagesController.processUserInfo(tLRPC$User2, tLRPC$UserFull, z3, z4, i3, arrayList, map, i2, z2);
        } catch (Throwable th5) {
            th = th5;
            tLRPC$UserFull = tLRPC$UserFullTLdeserialize;
            i2 = i4;
            z2 = z5;
            getMessagesController().processUserInfo(tLRPC$User, tLRPC$UserFull, true, z, i, arrayList, map, i2, z2);
            throw th;
        }
        messagesController.processUserInfo(tLRPC$User2, tLRPC$UserFull, z3, z4, i3, arrayList, map, i2, z2);
    }

    public void updateUserInfo(final TLRPC$UserFull info, final boolean ifExist) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$u--jlgafSK9knbW03dFKVm_JPv4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateUserInfo$90$MessagesStorage(ifExist, info);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateUserInfo$90, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateUserInfo$90$MessagesStorage(boolean z, TLRPC$UserFull tLRPC$UserFull) {
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
        sQLitePreparedStatementExecuteFast.bindLong(1, tLRPC$UserFull.user.id);
        sQLitePreparedStatementExecuteFast.bindByteBuffer(2, nativeByteBuffer);
        sQLitePreparedStatementExecuteFast.bindInteger(3, tLRPC$UserFull.pinned_msg_id);
        sQLitePreparedStatementExecuteFast.step();
        sQLitePreparedStatementExecuteFast.dispose();
        nativeByteBuffer.reuse();
        if ((tLRPC$UserFull.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast2 = this.database.executeFast("UPDATE dialogs SET folder_id = ? WHERE did = ?");
            sQLitePreparedStatementExecuteFast2.bindInteger(1, tLRPC$UserFull.folder_id);
            sQLitePreparedStatementExecuteFast2.bindLong(2, tLRPC$UserFull.user.id);
            sQLitePreparedStatementExecuteFast2.step();
            sQLitePreparedStatementExecuteFast2.dispose();
            this.unknownDialogsIds.remove(tLRPC$UserFull.user.id);
        }
    }

    public void saveChatInviter(final long chatId, final long inviterId) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$tkEQGbH7WVltgBFaQjl2Y8mfv-c
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$saveChatInviter$91$MessagesStorage(inviterId, chatId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$saveChatInviter$91, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$saveChatInviter$91$MessagesStorage(long j, long j2) {
        try {
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("UPDATE chat_settings_v2 SET inviter = ? WHERE uid = ?");
            sQLitePreparedStatementExecuteFast.requery();
            sQLitePreparedStatementExecuteFast.bindLong(1, j);
            sQLitePreparedStatementExecuteFast.bindLong(2, j2);
            sQLitePreparedStatementExecuteFast.step();
            sQLitePreparedStatementExecuteFast.dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void saveChatLinksCount(final long chatId, final int linksCount) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$vEUDnb7XgMuUOT1xJ2Qx9ztYmY4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$saveChatLinksCount$92$MessagesStorage(linksCount, chatId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$saveChatLinksCount$92, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$saveChatLinksCount$92$MessagesStorage(int i, long j) {
        try {
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("UPDATE chat_settings_v2 SET links = ? WHERE uid = ?");
            sQLitePreparedStatementExecuteFast.requery();
            sQLitePreparedStatementExecuteFast.bindInteger(1, i);
            sQLitePreparedStatementExecuteFast.bindLong(2, j);
            sQLitePreparedStatementExecuteFast.step();
            sQLitePreparedStatementExecuteFast.dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void updateChatInfo(final TLRPC$ChatFull info, final boolean ifExist) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$jV1ZV1D_WE2b0_HKh5eGgMKsaxk
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateChatInfo$93$MessagesStorage(info, ifExist);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateChatInfo$93, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateChatInfo$93$MessagesStorage(TLRPC$ChatFull tLRPC$ChatFull, boolean z) {
        int iIntValue;
        int iIntValue2;
        try {
            SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized("SELECT online, inviter, links FROM chat_settings_v2 WHERE uid = " + tLRPC$ChatFull.id, new Object[0]);
            if (sQLiteCursorQueryFinalized.next()) {
                iIntValue = sQLiteCursorQueryFinalized.intValue(0);
                tLRPC$ChatFull.inviterId = sQLiteCursorQueryFinalized.longValue(1);
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
            sQLitePreparedStatementExecuteFast.bindLong(1, tLRPC$ChatFull.id);
            sQLitePreparedStatementExecuteFast.bindByteBuffer(2, nativeByteBuffer);
            sQLitePreparedStatementExecuteFast.bindInteger(3, tLRPC$ChatFull.pinned_msg_id);
            sQLitePreparedStatementExecuteFast.bindInteger(4, tLRPC$ChatFull.online_count);
            sQLitePreparedStatementExecuteFast.bindLong(5, tLRPC$ChatFull.inviterId);
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
            if ((tLRPC$ChatFull.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
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

    public void updateChatOnlineCount(final long channelId, final int onlineCount) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$DQCkYF8QK2dJrdWPPvIGbU7A1Jo
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateChatOnlineCount$94$MessagesStorage(onlineCount, channelId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateChatOnlineCount$94, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateChatOnlineCount$94$MessagesStorage(int i, long j) {
        try {
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("UPDATE chat_settings_v2 SET online = ? WHERE uid = ?");
            sQLitePreparedStatementExecuteFast.requery();
            sQLitePreparedStatementExecuteFast.bindInteger(1, i);
            sQLitePreparedStatementExecuteFast.bindLong(2, j);
            sQLitePreparedStatementExecuteFast.step();
            sQLitePreparedStatementExecuteFast.dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void updatePinnedMessages(final long dialogId, final ArrayList<Integer> ids, final boolean pin, final int totalCount, final int maxId, final boolean end, final HashMap<Integer, MessageObject> messages) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$zwf5au1_TdRw2KPsrVyGq8H2nig
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updatePinnedMessages$97$MessagesStorage(pin, messages, maxId, dialogId, ids, totalCount, end);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updatePinnedMessages$97, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updatePinnedMessages$97$MessagesStorage(boolean z, final HashMap map, final int i, final long j, final ArrayList arrayList, int i2, boolean z2) {
        int i3;
        boolean z3;
        int iMax;
        final int iMax2;
        final boolean z4;
        int iIntValue;
        int iIntValue2;
        final boolean z5;
        int iMax3;
        int i4 = 2;
        int i5 = 1;
        try {
            if (z) {
                this.database.beginTransaction();
                if (map != null) {
                    if (i == 0) {
                        this.database.executeFast("DELETE FROM chat_pinned_v2 WHERE uid = " + j).stepThis().dispose();
                    }
                    iIntValue = 0;
                } else {
                    SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT COUNT(mid) FROM chat_pinned_v2 WHERE uid = %d AND mid IN (%s)", Long.valueOf(j), TextUtils.join(",", arrayList)), new Object[0]);
                    iIntValue = sQLiteCursorQueryFinalized.next() ? sQLiteCursorQueryFinalized.intValue(0) : 0;
                    sQLiteCursorQueryFinalized.dispose();
                }
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("REPLACE INTO chat_pinned_v2 VALUES(?, ?, ?)");
                int size = arrayList.size();
                int i6 = 0;
                while (i6 < size) {
                    Integer num = (Integer) arrayList.get(i6);
                    sQLitePreparedStatementExecuteFast.requery();
                    sQLitePreparedStatementExecuteFast.bindLong(1, j);
                    sQLitePreparedStatementExecuteFast.bindInteger(i4, num.intValue());
                    NativeByteBuffer nativeByteBuffer = null;
                    MessageObject messageObject = map != null ? (MessageObject) map.get(num) : null;
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
                    i6++;
                    i4 = 2;
                }
                sQLitePreparedStatementExecuteFast.dispose();
                this.database.commitTransaction();
                SQLiteDatabase sQLiteDatabase = this.database;
                Locale locale = Locale.US;
                SQLiteCursor sQLiteCursorQueryFinalized2 = sQLiteDatabase.queryFinalized(String.format(locale, "SELECT COUNT(mid) FROM chat_pinned_v2 WHERE uid = %d", Long.valueOf(j)), new Object[0]);
                int iIntValue3 = sQLiteCursorQueryFinalized2.next() ? sQLiteCursorQueryFinalized2.intValue(0) : 0;
                sQLiteCursorQueryFinalized2.dispose();
                if (map != null) {
                    iMax3 = Math.max(i2, iIntValue3);
                    z5 = z2;
                } else {
                    SQLiteCursor sQLiteCursorQueryFinalized3 = this.database.queryFinalized(String.format(locale, "SELECT count, end FROM chat_pinned_count WHERE uid = %d", Long.valueOf(j)), new Object[0]);
                    if (sQLiteCursorQueryFinalized3.next()) {
                        iIntValue2 = sQLiteCursorQueryFinalized3.intValue(0);
                        z5 = sQLiteCursorQueryFinalized3.intValue(1) != 0;
                        sQLiteCursorQueryFinalized3.dispose();
                        iMax3 = Math.max(iIntValue2 + (arrayList.size() - iIntValue), iIntValue3);
                    } else {
                        iIntValue2 = 0;
                    }
                    sQLiteCursorQueryFinalized3.dispose();
                    iMax3 = Math.max(iIntValue2 + (arrayList.size() - iIntValue), iIntValue3);
                }
                final int i7 = iMax3;
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast2 = this.database.executeFast("REPLACE INTO chat_pinned_count VALUES(?, ?, ?)");
                sQLitePreparedStatementExecuteFast2.requery();
                sQLitePreparedStatementExecuteFast2.bindLong(1, j);
                sQLitePreparedStatementExecuteFast2.bindInteger(2, i7);
                if (!z5) {
                    i5 = 0;
                }
                sQLitePreparedStatementExecuteFast2.bindInteger(3, i5);
                sQLitePreparedStatementExecuteFast2.step();
                sQLitePreparedStatementExecuteFast2.dispose();
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$vMrPna5l58rch4RBJ_MJPm7MvLg
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$updatePinnedMessages$95$MessagesStorage(j, arrayList, map, i, i7, z5);
                    }
                });
                return;
            }
            if (arrayList == null) {
                this.database.executeFast("DELETE FROM chat_pinned_v2 WHERE uid = " + j).stepThis().dispose();
                if (DialogObject.isChatDialog(j)) {
                    this.database.executeFast(String.format(Locale.US, "UPDATE chat_settings_v2 SET pinned = 0 WHERE uid = %d", Long.valueOf(-j))).stepThis().dispose();
                } else {
                    this.database.executeFast(String.format(Locale.US, "UPDATE user_settings SET pinned = 0 WHERE uid = %d", Long.valueOf(j))).stepThis().dispose();
                }
                iMax2 = 0;
                z4 = true;
                i3 = 0;
            } else {
                String strJoin = TextUtils.join(",", arrayList);
                if (DialogObject.isChatDialog(j)) {
                    this.database.executeFast(String.format(Locale.US, "UPDATE chat_settings_v2 SET pinned = 0 WHERE uid = %d AND pinned IN (%s)", Long.valueOf(-j), strJoin)).stepThis().dispose();
                } else {
                    this.database.executeFast(String.format(Locale.US, "UPDATE user_settings SET pinned = 0 WHERE uid = %d AND pinned IN (%s)", Long.valueOf(j), strJoin)).stepThis().dispose();
                }
                SQLiteDatabase sQLiteDatabase2 = this.database;
                Locale locale2 = Locale.US;
                sQLiteDatabase2.executeFast(String.format(locale2, "DELETE FROM chat_pinned_v2 WHERE uid = %d AND mid IN(%s)", Long.valueOf(j), strJoin)).stepThis().dispose();
                SQLiteCursor sQLiteCursorQueryFinalized4 = this.database.queryFinalized("SELECT changes()", new Object[0]);
                int iIntValue4 = sQLiteCursorQueryFinalized4.next() ? sQLiteCursorQueryFinalized4.intValue(0) : 0;
                sQLiteCursorQueryFinalized4.dispose();
                SQLiteCursor sQLiteCursorQueryFinalized5 = this.database.queryFinalized(String.format(locale2, "SELECT COUNT(mid) FROM chat_pinned_v2 WHERE uid = %d", Long.valueOf(j)), new Object[0]);
                int iIntValue5 = sQLiteCursorQueryFinalized5.next() ? sQLiteCursorQueryFinalized5.intValue(0) : 0;
                sQLiteCursorQueryFinalized5.dispose();
                i3 = 0;
                SQLiteCursor sQLiteCursorQueryFinalized6 = this.database.queryFinalized(String.format(locale2, "SELECT count, end FROM chat_pinned_count WHERE uid = %d", Long.valueOf(j)), new Object[0]);
                if (sQLiteCursorQueryFinalized6.next()) {
                    iMax = Math.max(0, sQLiteCursorQueryFinalized6.intValue(0) - iIntValue4);
                    z3 = sQLiteCursorQueryFinalized6.intValue(1) != 0;
                } else {
                    z3 = false;
                    iMax = 0;
                }
                sQLiteCursorQueryFinalized6.dispose();
                iMax2 = Math.max(iIntValue5, iMax);
                z4 = z3;
            }
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast3 = this.database.executeFast("REPLACE INTO chat_pinned_count VALUES(?, ?, ?)");
            sQLitePreparedStatementExecuteFast3.requery();
            sQLitePreparedStatementExecuteFast3.bindLong(1, j);
            sQLitePreparedStatementExecuteFast3.bindInteger(2, iMax2);
            if (z4) {
                i3 = 1;
            }
            sQLitePreparedStatementExecuteFast3.bindInteger(3, i3);
            sQLitePreparedStatementExecuteFast3.step();
            sQLitePreparedStatementExecuteFast3.dispose();
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$ANgEqeZR2VZVR-vki6r-AMEPHJE
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$updatePinnedMessages$96$MessagesStorage(j, arrayList, map, i, iMax2, z4);
                }
            });
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updatePinnedMessages$95, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updatePinnedMessages$95$MessagesStorage(long j, ArrayList arrayList, HashMap map, int i, int i2, boolean z) {
        getNotificationCenter().postNotificationName(NotificationCenter.didLoadPinnedMessages, Long.valueOf(j), arrayList, Boolean.TRUE, null, map, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updatePinnedMessages$96, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updatePinnedMessages$96$MessagesStorage(long j, ArrayList arrayList, HashMap map, int i, int i2, boolean z) {
        getNotificationCenter().postNotificationName(NotificationCenter.didLoadPinnedMessages, Long.valueOf(j), arrayList, Boolean.FALSE, null, map, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z));
    }

    public void updateChatInfo(final long chatId, final long userId, final int what, final long invited_id, final int version) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$z1zVKWyPtjL0d5adKbr_N2C0NyM
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateChatInfo$99$MessagesStorage(chatId, what, userId, invited_id, version);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateChatInfo$99, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateChatInfo$99$MessagesStorage(long j, int i, long j2, long j3, int i2) {
        TLRPC$ChatParticipant tLRPC$TL_chatParticipant;
        NativeByteBuffer nativeByteBufferByteBufferValue;
        try {
            SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized("SELECT info, pinned, online, inviter FROM chat_settings_v2 WHERE uid = " + j, new Object[0]);
            final TLRPC$ChatFull tLRPC$ChatFullTLdeserialize = null;
            new ArrayList();
            if (sQLiteCursorQueryFinalized.next() && (nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized.byteBufferValue(0)) != null) {
                tLRPC$ChatFullTLdeserialize = TLRPC$ChatFull.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                nativeByteBufferByteBufferValue.reuse();
                tLRPC$ChatFullTLdeserialize.pinned_msg_id = sQLiteCursorQueryFinalized.intValue(1);
                tLRPC$ChatFullTLdeserialize.online_count = sQLiteCursorQueryFinalized.intValue(2);
                tLRPC$ChatFullTLdeserialize.inviterId = sQLiteCursorQueryFinalized.longValue(3);
            }
            sQLiteCursorQueryFinalized.dispose();
            if (tLRPC$ChatFullTLdeserialize instanceof TLRPC$TL_chatFull) {
                if (i == 1) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= tLRPC$ChatFullTLdeserialize.participants.participants.size()) {
                            break;
                        }
                        if (tLRPC$ChatFullTLdeserialize.participants.participants.get(i3).user_id == j2) {
                            tLRPC$ChatFullTLdeserialize.participants.participants.remove(i3);
                            break;
                        }
                        i3++;
                    }
                } else if (i == 0) {
                    Iterator<TLRPC$ChatParticipant> it = tLRPC$ChatFullTLdeserialize.participants.participants.iterator();
                    while (it.hasNext()) {
                        if (it.next().user_id == j2) {
                            return;
                        }
                    }
                    TLRPC$TL_chatParticipant tLRPC$TL_chatParticipant2 = new TLRPC$TL_chatParticipant();
                    tLRPC$TL_chatParticipant2.user_id = j2;
                    tLRPC$TL_chatParticipant2.inviter_id = j3;
                    tLRPC$TL_chatParticipant2.date = getConnectionsManager().getCurrentTime();
                    tLRPC$ChatFullTLdeserialize.participants.participants.add(tLRPC$TL_chatParticipant2);
                } else if (i == 2) {
                    int i4 = 0;
                    while (true) {
                        if (i4 >= tLRPC$ChatFullTLdeserialize.participants.participants.size()) {
                            break;
                        }
                        TLRPC$ChatParticipant tLRPC$ChatParticipant = tLRPC$ChatFullTLdeserialize.participants.participants.get(i4);
                        if (tLRPC$ChatParticipant.user_id == j2) {
                            if (j3 == 1) {
                                tLRPC$TL_chatParticipant = new TLRPC$TL_chatParticipantAdmin();
                            } else {
                                tLRPC$TL_chatParticipant = new TLRPC$TL_chatParticipant();
                            }
                            tLRPC$TL_chatParticipant.user_id = tLRPC$ChatParticipant.user_id;
                            tLRPC$TL_chatParticipant.date = tLRPC$ChatParticipant.date;
                            tLRPC$TL_chatParticipant.inviter_id = tLRPC$ChatParticipant.inviter_id;
                            tLRPC$ChatFullTLdeserialize.participants.participants.set(i4, tLRPC$TL_chatParticipant);
                        } else {
                            i4++;
                        }
                    }
                }
                tLRPC$ChatFullTLdeserialize.participants.version = i2;
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$_w7LwEMUikLgnUiuD-aGSYghRAg
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$updateChatInfo$98$MessagesStorage(tLRPC$ChatFullTLdeserialize);
                    }
                });
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("REPLACE INTO chat_settings_v2 VALUES(?, ?, ?, ?, ?, ?)");
                NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(tLRPC$ChatFullTLdeserialize.getObjectSize());
                tLRPC$ChatFullTLdeserialize.serializeToStream(nativeByteBuffer);
                sQLitePreparedStatementExecuteFast.bindLong(1, j);
                sQLitePreparedStatementExecuteFast.bindByteBuffer(2, nativeByteBuffer);
                sQLitePreparedStatementExecuteFast.bindInteger(3, tLRPC$ChatFullTLdeserialize.pinned_msg_id);
                sQLitePreparedStatementExecuteFast.bindInteger(4, tLRPC$ChatFullTLdeserialize.online_count);
                sQLitePreparedStatementExecuteFast.bindLong(5, tLRPC$ChatFullTLdeserialize.inviterId);
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
    /* renamed from: lambda$updateChatInfo$98, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateChatInfo$98$MessagesStorage(TLRPC$ChatFull tLRPC$ChatFull) {
        NotificationCenter notificationCenter = getNotificationCenter();
        int i = NotificationCenter.chatInfoDidLoad;
        Boolean bool = Boolean.FALSE;
        notificationCenter.postNotificationName(i, tLRPC$ChatFull, 0, bool, bool);
    }

    public boolean isMigratedChat(final long chatId) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final boolean[] zArr = new boolean[1];
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$TBRpwl2EKmTP76JjAwayehrecIs
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$isMigratedChat$100$MessagesStorage(chatId, zArr, countDownLatch);
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
    /* renamed from: lambda$isMigratedChat$100, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$isMigratedChat$100$MessagesStorage(long j, boolean[] zArr, CountDownLatch countDownLatch) {
        NativeByteBuffer nativeByteBufferByteBufferValue;
        try {
            try {
                SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized("SELECT info FROM chat_settings_v2 WHERE uid = " + j, new Object[0]);
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

    public boolean hasInviteMeMessage(final long chatId) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final boolean[] zArr = new boolean[1];
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$NDMXggVFepob08i2-N-QXuIk7CE
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$hasInviteMeMessage$101$MessagesStorage(chatId, zArr, countDownLatch);
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
    /* renamed from: lambda$hasInviteMeMessage$101, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$hasInviteMeMessage$101$MessagesStorage(long j, boolean[] zArr, CountDownLatch countDownLatch) {
        try {
            try {
                long clientUserId = getUserConfig().getClientUserId();
                SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized("SELECT data FROM messages_v2 WHERE uid = " + (-j) + " AND out = 0 ORDER BY mid DESC LIMIT 100", new Object[0]);
                while (true) {
                    if (!sQLiteCursorQueryFinalized.next()) {
                        break;
                    }
                    NativeByteBuffer nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized.byteBufferValue(0);
                    if (nativeByteBufferByteBufferValue != null) {
                        TLRPC$Message tLRPC$MessageTLdeserialize = TLRPC$Message.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                        nativeByteBufferByteBufferValue.reuse();
                        TLRPC$MessageAction tLRPC$MessageAction = tLRPC$MessageTLdeserialize.action;
                        if ((tLRPC$MessageAction instanceof TLRPC$TL_messageActionChatAddUser) && tLRPC$MessageAction.users.contains(Long.valueOf(clientUserId))) {
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

    /* JADX WARN: Can't wrap try/catch for region: R(9:(23:159|6|(4:8|157|9|10)|150|20|21|153|(5:23|(4:26|(2:28|166)(1:167)|29|24)|165|30|(1:32))(2:36|(8:38|(8:147|41|(1:43)(1:44)|45|(1:47)(1:48)|(1:173)(4:51|(1:53)|54|174)|58|39)|170|59|(4:62|(2:64|177)(2:65|176)|66|60)|175|67|(1:69)))|70|(1:74)|75|(2:78|76)|168|80|(6:82|83|161|84|(1:87)|88)(1:93)|145|94|(3:156|96|(1:102))|106|(4:108|(1:110)(1:111)|112|(3:114|(2:116|117)|169))|118|138|139)|145|94|(0)|106|(0)|118|138|139) */
    /* JADX WARN: Can't wrap try/catch for region: R(9:0|2|(3:163|3|4)|(18:(23:159|6|(4:8|157|9|10)|150|20|21|153|(5:23|(4:26|(2:28|166)(1:167)|29|24)|165|30|(1:32))(2:36|(8:38|(8:147|41|(1:43)(1:44)|45|(1:47)(1:48)|(1:173)(4:51|(1:53)|54|174)|58|39)|170|59|(4:62|(2:64|177)(2:65|176)|66|60)|175|67|(1:69)))|70|(1:74)|75|(2:78|76)|168|80|(6:82|83|161|84|(1:87)|88)(1:93)|145|94|(3:156|96|(1:102))|106|(4:108|(1:110)(1:111)|112|(3:114|(2:116|117)|169))|118|138|139)|153|(0)(0)|70|(2:72|74)|75|(1:76)|168|80|(0)(0)|145|94|(0)|106|(0)|118|138|139)|19|150|20|21|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x02af, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x02b0, code lost:
    
        r14 = r7;
        r12 = r19;
        r13 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x02b6, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x02b7, code lost:
    
        r5 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x02ba, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x02bb, code lost:
    
        r14 = r7;
     */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0265 A[Catch: all -> 0x025c, Exception -> 0x02af, TRY_ENTER, TryCatch #0 {Exception -> 0x02af, blocks: (B:94:0x0228, B:96:0x022d, B:98:0x0231, B:100:0x0237, B:102:0x0245, B:106:0x025f, B:108:0x0265, B:112:0x026f, B:114:0x027a, B:116:0x0280), top: B:145:0x0228 }] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x022d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007e A[Catch: all -> 0x00b8, Exception -> 0x02ba, TRY_ENTER, TryCatch #7 {Exception -> 0x02ba, blocks: (B:20:0x0075, B:23:0x007e, B:24:0x0084, B:26:0x008e, B:28:0x009e, B:29:0x00a1, B:30:0x00a9, B:32:0x00af, B:72:0x0190, B:74:0x0196, B:75:0x01ac, B:76:0x01cc, B:78:0x01d2, B:80:0x01e6, B:82:0x0208, B:36:0x00bc, B:38:0x00c0, B:39:0x00e7, B:59:0x0151, B:60:0x015a, B:62:0x0162, B:64:0x0170, B:66:0x0176, B:67:0x017f, B:69:0x0185, B:57:0x014b), top: B:150:0x0075 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00bc A[Catch: all -> 0x02b6, Exception -> 0x02ba, TRY_ENTER, TRY_LEAVE, TryCatch #7 {Exception -> 0x02ba, blocks: (B:20:0x0075, B:23:0x007e, B:24:0x0084, B:26:0x008e, B:28:0x009e, B:29:0x00a1, B:30:0x00a9, B:32:0x00af, B:72:0x0190, B:74:0x0196, B:75:0x01ac, B:76:0x01cc, B:78:0x01d2, B:80:0x01e6, B:82:0x0208, B:36:0x00bc, B:38:0x00c0, B:39:0x00e7, B:59:0x0151, B:60:0x015a, B:62:0x0162, B:64:0x0170, B:66:0x0176, B:67:0x017f, B:69:0x0185, B:57:0x014b), top: B:150:0x0075 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01d2 A[Catch: all -> 0x00b8, Exception -> 0x02ba, LOOP:1: B:76:0x01cc->B:78:0x01d2, LOOP_END, TRY_ENTER, TRY_LEAVE, TryCatch #7 {Exception -> 0x02ba, blocks: (B:20:0x0075, B:23:0x007e, B:24:0x0084, B:26:0x008e, B:28:0x009e, B:29:0x00a1, B:30:0x00a9, B:32:0x00af, B:72:0x0190, B:74:0x0196, B:75:0x01ac, B:76:0x01cc, B:78:0x01d2, B:80:0x01e6, B:82:0x0208, B:36:0x00bc, B:38:0x00c0, B:39:0x00e7, B:59:0x0151, B:60:0x015a, B:62:0x0162, B:64:0x0170, B:66:0x0176, B:67:0x017f, B:69:0x0185, B:57:0x014b), top: B:150:0x0075 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0208 A[Catch: all -> 0x00b8, Exception -> 0x02ba, TRY_ENTER, TRY_LEAVE, TryCatch #7 {Exception -> 0x02ba, blocks: (B:20:0x0075, B:23:0x007e, B:24:0x0084, B:26:0x008e, B:28:0x009e, B:29:0x00a1, B:30:0x00a9, B:32:0x00af, B:72:0x0190, B:74:0x0196, B:75:0x01ac, B:76:0x01cc, B:78:0x01d2, B:80:0x01e6, B:82:0x0208, B:36:0x00bc, B:38:0x00c0, B:39:0x00e7, B:59:0x0151, B:60:0x015a, B:62:0x0162, B:64:0x0170, B:66:0x0176, B:67:0x017f, B:69:0x0185, B:57:0x014b), top: B:150:0x0075 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0224  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private ir.eitaa.tgnet.TLRPC$ChatFull loadChatInfoInternal(long r22, boolean r24, boolean r25, boolean r26, int r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 751
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessagesStorage.loadChatInfoInternal(long, boolean, boolean, boolean, int):ir.eitaa.tgnet.TLRPC$ChatFull");
    }

    public TLRPC$ChatFull loadChatInfo(long chatId, boolean isChannel, CountDownLatch countDownLatch, boolean force, boolean byChannelUsers) {
        return loadChatInfo(chatId, isChannel, countDownLatch, force, byChannelUsers, 0);
    }

    public TLRPC$ChatFull loadChatInfo(final long chatId, final boolean isChannel, final CountDownLatch countDownLatch, final boolean force, final boolean byChannelUsers, final int fromMessageId) {
        final TLRPC$ChatFull[] tLRPC$ChatFullArr = new TLRPC$ChatFull[1];
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$AoE7Bt8LBbAaqYP71ZMiAU7WVdM
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadChatInfo$102$MessagesStorage(tLRPC$ChatFullArr, chatId, isChannel, force, byChannelUsers, fromMessageId, countDownLatch);
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
    /* renamed from: lambda$loadChatInfo$102, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadChatInfo$102$MessagesStorage(TLRPC$ChatFull[] tLRPC$ChatFullArr, long j, boolean z, boolean z2, boolean z3, int i, CountDownLatch countDownLatch) {
        tLRPC$ChatFullArr[0] = loadChatInfoInternal(j, z, z2, z3, i);
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    public void processPendingRead(final long dialogId, final int maxPositiveId, final int maxNegativeId, final int scheduledCount) {
        final int i = this.lastSavedDate;
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$EMAKz5nKZ7yefd7Rncey7a419W0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processPendingRead$103$MessagesStorage(dialogId, maxPositiveId, scheduledCount, i, maxNegativeId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processPendingRead$103, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processPendingRead$103$MessagesStorage(long j, int i, int i2, int i3, int i4) {
        int iIntValue;
        int i5;
        int iIntValue2;
        int iMax = i4;
        long jLongValue = 0;
        try {
            int iMax2 = 0;
            SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized("SELECT unread_count, inbox_max, last_mid FROM dialogs WHERE did = " + j, new Object[0]);
            if (sQLiteCursorQueryFinalized.next()) {
                iIntValue = sQLiteCursorQueryFinalized.intValue(0);
                i5 = iIntValue;
                iIntValue2 = sQLiteCursorQueryFinalized.intValue(1);
                jLongValue = sQLiteCursorQueryFinalized.longValue(2);
            } else {
                iIntValue = 0;
                i5 = 0;
                iIntValue2 = 0;
            }
            sQLiteCursorQueryFinalized.dispose();
            this.database.beginTransaction();
            if (!DialogObject.isEncryptedDialog(j)) {
                iMax = Math.max(iIntValue2, i);
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("UPDATE messages_v2 SET read_state = read_state | 1 WHERE uid = ? AND mid <= ? AND read_state IN(0,2) AND out = 0");
                sQLitePreparedStatementExecuteFast.requery();
                sQLitePreparedStatementExecuteFast.bindLong(1, j);
                sQLitePreparedStatementExecuteFast.bindInteger(2, iMax);
                sQLitePreparedStatementExecuteFast.step();
                sQLitePreparedStatementExecuteFast.dispose();
                if (iMax < jLongValue) {
                    SQLiteCursor sQLiteCursorQueryFinalized2 = this.database.queryFinalized("SELECT changes()", new Object[0]);
                    int iIntValue3 = sQLiteCursorQueryFinalized2.next() ? sQLiteCursorQueryFinalized2.intValue(0) + i2 : 0;
                    sQLiteCursorQueryFinalized2.dispose();
                    iMax2 = Math.max(0, iIntValue - iIntValue3);
                }
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast2 = this.database.executeFast("DELETE FROM unread_push_messages WHERE uid = ? AND mid <= ?");
                sQLitePreparedStatementExecuteFast2.requery();
                sQLitePreparedStatementExecuteFast2.bindLong(1, j);
                sQLitePreparedStatementExecuteFast2.bindInteger(2, iMax);
                sQLitePreparedStatementExecuteFast2.step();
                sQLitePreparedStatementExecuteFast2.dispose();
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast3 = this.database.executeFast("DELETE FROM unread_push_messages WHERE uid = ? AND date <= ?");
                sQLitePreparedStatementExecuteFast3.requery();
                sQLitePreparedStatementExecuteFast3.bindLong(1, j);
                sQLitePreparedStatementExecuteFast3.bindInteger(2, i3);
                sQLitePreparedStatementExecuteFast3.step();
                sQLitePreparedStatementExecuteFast3.dispose();
            } else {
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast4 = this.database.executeFast("UPDATE messages_v2 SET read_state = read_state | 1 WHERE uid = ? AND mid >= ? AND read_state IN(0,2) AND out = 0");
                sQLitePreparedStatementExecuteFast4.requery();
                sQLitePreparedStatementExecuteFast4.bindLong(1, j);
                sQLitePreparedStatementExecuteFast4.bindInteger(2, iMax);
                sQLitePreparedStatementExecuteFast4.step();
                sQLitePreparedStatementExecuteFast4.dispose();
                if (iMax > jLongValue) {
                    SQLiteCursor sQLiteCursorQueryFinalized3 = this.database.queryFinalized("SELECT changes()", new Object[0]);
                    int iIntValue4 = sQLiteCursorQueryFinalized3.next() ? sQLiteCursorQueryFinalized3.intValue(0) + i2 : 0;
                    sQLiteCursorQueryFinalized3.dispose();
                    iMax2 = Math.max(0, iIntValue - iIntValue4);
                }
            }
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast5 = this.database.executeFast("UPDATE dialogs SET unread_count = ?, inbox_max = ? WHERE did = ?");
            sQLitePreparedStatementExecuteFast5.requery();
            sQLitePreparedStatementExecuteFast5.bindInteger(1, iMax2);
            sQLitePreparedStatementExecuteFast5.bindInteger(2, iMax);
            sQLitePreparedStatementExecuteFast5.bindLong(3, j);
            sQLitePreparedStatementExecuteFast5.step();
            sQLitePreparedStatementExecuteFast5.dispose();
            this.database.commitTransaction();
            if (i5 != 0 && iMax2 == 0) {
                LongSparseIntArray longSparseIntArray = new LongSparseIntArray();
                longSparseIntArray.put(j, iMax2);
                updateFiltersReadCounter(longSparseIntArray, null, true);
            }
            updateWidgets(j);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void putContacts(ArrayList<TLRPC$TL_contact> contacts, final boolean deleteAll) {
        if (!contacts.isEmpty() || deleteAll) {
            final ArrayList arrayList = new ArrayList(contacts);
            this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$UFLdBnuZrh1Beklk6PB4T9heY2k
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$putContacts$104$MessagesStorage(deleteAll, arrayList);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$putContacts$104, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$putContacts$104$MessagesStorage(boolean z, ArrayList arrayList) {
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
            sQLitePreparedStatementExecuteFast.bindLong(1, tLRPC$TL_contact.user_id);
            if (!tLRPC$TL_contact.mutual) {
                i2 = 0;
            }
            sQLitePreparedStatementExecuteFast.bindInteger(2, i2);
            sQLitePreparedStatementExecuteFast.step();
        }
        sQLitePreparedStatementExecuteFast.dispose();
        this.database.commitTransaction();
    }

    public void deleteContacts(final ArrayList<Long> uids) {
        if (uids == null || uids.isEmpty()) {
            return;
        }
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$bfTwaw-S-1T5Fk5BElq_NJhBm5A
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$deleteContacts$105$MessagesStorage(uids);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$deleteContacts$105, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$deleteContacts$105$MessagesStorage(ArrayList arrayList) {
        try {
            String strJoin = TextUtils.join(",", arrayList);
            this.database.executeFast("DELETE FROM contacts WHERE uid IN(" + strJoin + ")").stepThis().dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void applyPhoneBookUpdates(final String adds, final String deletes) {
        if (TextUtils.isEmpty(adds)) {
            return;
        }
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$jqpm98oSRiXWFYp8eOz9iTxrYYA
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$applyPhoneBookUpdates$106$MessagesStorage(adds, deletes);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$applyPhoneBookUpdates$106, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$applyPhoneBookUpdates$106$MessagesStorage(String str, String str2) {
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

    public void putCachedPhoneBook(final HashMap<String, ContactsController.Contact> contactHashMap, final boolean migrate, boolean delete) {
        if (contactHashMap != null) {
            if (!contactHashMap.isEmpty() || migrate || delete) {
                this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$toFcP2PheVID0ydnE0uEcM_T-AU
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$putCachedPhoneBook$107$MessagesStorage(contactHashMap, migrate);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$putCachedPhoneBook$107, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$putCachedPhoneBook$107$MessagesStorage(HashMap map, boolean z) {
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

    public void getCachedPhoneBook(final boolean byError) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$13Z5Hp_8eiSaPRdb-ermz5YfjAw
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getCachedPhoneBook$108$MessagesStorage(byError);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f9 A[Catch: all -> 0x0132, TRY_LEAVE, TryCatch #2 {all -> 0x0132, blocks: (B:51:0x00e9, B:53:0x00f9), top: B:132:0x00e9 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x012e A[PHI: r3 r8 r10 r14
      0x012e: PHI (r3v11 int) = (r3v3 int), (r3v13 int), (r3v14 int), (r3v14 int) binds: [B:72:0x013a, B:66:0x012a, B:59:0x010a, B:60:0x010c] A[DONT_GENERATE, DONT_INLINE]
      0x012e: PHI (r8v19 int) = (r8v1 int), (r8v21 int), (r8v22 int), (r8v22 int) binds: [B:72:0x013a, B:66:0x012a, B:59:0x010a, B:60:0x010c] A[DONT_GENERATE, DONT_INLINE]
      0x012e: PHI (r10v9 ir.eitaa.SQLite.SQLiteCursor) = 
      (r10v4 ir.eitaa.SQLite.SQLiteCursor)
      (r10v10 ir.eitaa.SQLite.SQLiteCursor)
      (r10v10 ir.eitaa.SQLite.SQLiteCursor)
      (r10v10 ir.eitaa.SQLite.SQLiteCursor)
     binds: [B:72:0x013a, B:66:0x012a, B:59:0x010a, B:60:0x010c] A[DONT_GENERATE, DONT_INLINE]
      0x012e: PHI (r14v8 int) = (r14v1 int), (r14v9 int), (r14v11 int), (r14v11 int) binds: [B:72:0x013a, B:66:0x012a, B:59:0x010a, B:60:0x010c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0144 A[Catch: all -> 0x01ee, Exception -> 0x01f0, TRY_ENTER, TryCatch #0 {Exception -> 0x01f0, blocks: (B:76:0x0144, B:79:0x0169, B:81:0x016f, B:83:0x017b, B:85:0x019d, B:86:0x019f, B:88:0x01a3, B:89:0x01a5, B:90:0x01a8, B:93:0x01b0, B:96:0x01bc, B:98:0x01c2, B:100:0x01c8, B:101:0x01cc, B:103:0x01ea, B:77:0x015e), top: B:128:0x0142, outer: #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x015e A[Catch: all -> 0x01ee, Exception -> 0x01f0, TryCatch #0 {Exception -> 0x01f0, blocks: (B:76:0x0144, B:79:0x0169, B:81:0x016f, B:83:0x017b, B:85:0x019d, B:86:0x019f, B:88:0x01a3, B:89:0x01a5, B:90:0x01a8, B:93:0x01b0, B:96:0x01bc, B:98:0x01c2, B:100:0x01c8, B:101:0x01cc, B:103:0x01ea, B:77:0x015e), top: B:128:0x0142, outer: #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x016f A[Catch: all -> 0x01ee, Exception -> 0x01f0, TryCatch #0 {Exception -> 0x01f0, blocks: (B:76:0x0144, B:79:0x0169, B:81:0x016f, B:83:0x017b, B:85:0x019d, B:86:0x019f, B:88:0x01a3, B:89:0x01a5, B:90:0x01a8, B:93:0x01b0, B:96:0x01bc, B:98:0x01c2, B:100:0x01c8, B:101:0x01cc, B:103:0x01ea, B:77:0x015e), top: B:128:0x0142, outer: #8 }] */
    /* renamed from: lambda$getCachedPhoneBook$108, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$getCachedPhoneBook$108$MessagesStorage(boolean r25) {
        /*
            Method dump skipped, instructions count: 554
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessagesStorage.lambda$getCachedPhoneBook$108$MessagesStorage(boolean):void");
    }

    public void getContacts() {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$bmD01UM_mWdAEZsNtTc3mKsYaUs
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getContacts$109$MessagesStorage();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getContacts$109, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getContacts$109$MessagesStorage() {
        ArrayList<TLRPC$TL_contact> arrayList = new ArrayList<>();
        ArrayList<TLRPC$User> arrayList2 = new ArrayList<>();
        try {
            SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized("SELECT * FROM contacts WHERE 1", new Object[0]);
            StringBuilder sb = new StringBuilder();
            while (sQLiteCursorQueryFinalized.next()) {
                long jIntValue = sQLiteCursorQueryFinalized.intValue(0);
                TLRPC$TL_contact tLRPC$TL_contact = new TLRPC$TL_contact();
                tLRPC$TL_contact.user_id = jIntValue;
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

    public void getUnsentMessages(final int count) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$WZeQQakMFYGTCvO1fMwFphKFz08
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getUnsentMessages$110$MessagesStorage(count);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:73:0x022e  */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* renamed from: lambda$getUnsentMessages$110, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$getUnsentMessages$110$MessagesStorage(int r19) {
        /*
            Method dump skipped, instructions count: 657
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessagesStorage.lambda$getUnsentMessages$110$MessagesStorage(int):void");
    }

    public boolean checkMessageByRandomId(final long random_id) throws InterruptedException {
        final boolean[] zArr = new boolean[1];
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$J-dP322X2SacjJ42EBr79CryYp0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$checkMessageByRandomId$111$MessagesStorage(random_id, zArr, countDownLatch);
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
    /* renamed from: lambda$checkMessageByRandomId$111, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkMessageByRandomId$111$MessagesStorage(long j, boolean[] zArr, CountDownLatch countDownLatch) {
        SQLiteCursor sQLiteCursorQueryFinalized = null;
        try {
            try {
                sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT random_id FROM randoms_v2 WHERE random_id = %d", Long.valueOf(j)), new Object[0]);
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

    public boolean checkMessageId(final long dialogId, final int mid) throws InterruptedException {
        final boolean[] zArr = new boolean[1];
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$xOJGs247yT_P_Lw05uX_Ddo68J0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$checkMessageId$112$MessagesStorage(dialogId, mid, zArr, countDownLatch);
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
    /* renamed from: lambda$checkMessageId$112, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkMessageId$112$MessagesStorage(long j, int i, boolean[] zArr, CountDownLatch countDownLatch) {
        SQLiteCursor sQLiteCursorQueryFinalized = null;
        try {
            try {
                sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT mid FROM messages_v2 WHERE uid = %d AND mid = %d", Long.valueOf(j), Integer.valueOf(i)), new Object[0]);
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

    public void getUnreadMention(final long dialog_id, final IntCallback callback) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$nNMZty5s6GuDNdp7ehIov8dCvWI
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getUnreadMention$114$MessagesStorage(dialog_id, callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getUnreadMention$114, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getUnreadMention$114$MessagesStorage(long j, final IntCallback intCallback) {
        try {
            SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT MIN(mid) FROM messages_v2 WHERE uid = %d AND mention = 1 AND read_state IN(0, 1)", Long.valueOf(j)), new Object[0]);
            final int iIntValue = sQLiteCursorQueryFinalized.next() ? sQLiteCursorQueryFinalized.intValue(0) : 0;
            sQLiteCursorQueryFinalized.dispose();
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$MycSHECYXTUQz9dCJCwzvq9LDO8
                @Override // java.lang.Runnable
                public final void run() {
                    intCallback.run(iIntValue);
                }
            });
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void getMessagesCount(final long dialog_id, final IntCallback callback) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$3DhWsFHmTdhAtdvNRZsLtuC_1ng
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getMessagesCount$116$MessagesStorage(dialog_id, callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getMessagesCount$116, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getMessagesCount$116$MessagesStorage(long j, final IntCallback intCallback) {
        try {
            SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT COUNT(mid) FROM messages_v2 WHERE uid = %d", Long.valueOf(j)), new Object[0]);
            final int iIntValue = sQLiteCursorQueryFinalized.next() ? sQLiteCursorQueryFinalized.intValue(0) : 0;
            sQLiteCursorQueryFinalized.dispose();
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$U5qtPDxA_2BC3CnFIG9j7kO03Tc
                @Override // java.lang.Runnable
                public final void run() {
                    intCallback.run(iIntValue);
                }
            });
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(17:98|(1:204)(18:105|(6:107|(10:109|110|111|112|113|905|114|115|(1:117)(1:118)|119)(1:122)|802|123|808|(11:125|126|866|127|128|129|(4:131|132|870|133)(1:137)|824|138|(8:140|141|832|142|(1:144)(1:146)|798|147|148)(1:153)|154)(2:162|(5:164|(1:166)(1:167)|168|(3:170|(1:172)|173)|174)(5:175|(1:177)(1:178)|179|(3:181|(1:183)|184)|185)))(1:191)|192|(4:197|903|198|(1:200)(1:201))(1:196)|863|206|207|851|208|847|(3:210|211|(6:213|868|222|223|865|(31:280|281|(1:283)(1:285)|822|286|287|(1:331)(13:882|290|291|907|292|(2:828|294)(1:298)|299|300|909|301|(1:303)(1:304)|305|(0)(1:(24:309|333|(1:335)(1:336)|(7:875|338|339|877|340|(1:342)(1:343)|344)(1:351)|813|(7:353|(1:355)(1:356)|357|(1:359)(1:360)|361|(2:(1:368)|369)(1:366)|370)(3:373|(6:804|375|(1:377)(1:379)|380|381|(20:796|383|384|392|505|(4:507|(5:510|(5:918|513|(12:515|794|516|517|809|518|519|814|520|521|(31:529|(1:535)|540|(3:542|830|543)|547|890|548|549|894|550|(2:853|552)|556|557|558|(2:560|561)(1:563)|564|565|(4:567|568|(1:570)|571)(1:573)|574|(1:578)|579|580|(2:582|583)|584|585|586|(2:588|589)(2:590|(1:592))|593|884|594|(6:621|622|(1:626)|628|(7:915|630|631|901|632|(1:634)|635)(1:643)|644)(9:600|(2:604|(1:606))|607|(2:609|(1:611)(5:612|(1:614)(1:615)|616|(1:618)(1:619)|620))(0)|622|(1:627)(2:624|626)|628|(0)(0)|644))(34:(2:811|525)(1:526)|527|528|529|(3:531|533|535)|540|(0)|547|890|548|549|894|550|(0)|556|557|558|(0)(0)|564|565|(0)(0)|574|(2:576|578)|579|580|(0)|584|585|586|(0)(0)|593|884|594|(8:596|598|621|622|(0)(0)|628|(0)(0)|644)(0))|784)(1:656)|657|921)(3:919|512|922)|920|892|508)|917|658)(1:666)|820|667|(4:669|(1:684)|678|(1:690))|(3:692|(1:696)|697)|698|792|699|700|(0)(0)|744|(0)(0)|750|(0)|753))(1:389)|390)|391|392|505|(0)(0)|820|667|(0)|(0)|698|792|699|700|(0)(0)|744|(0)(0)|750|(0)|753)(4:310|(1:312)|313|(5:315|(1:317)|318|319|(23:321|(0)(0)|(0)(0)|813|(0)(0)|391|392|505|(0)(0)|820|667|(0)|(0)|698|792|699|700|(0)(0)|744|(0)(0)|750|(0)|753)))))|332|333|(0)(0)|(0)(0)|813|(0)(0)|391|392|505|(0)(0)|820|667|(0)|(0)|698|792|699|700|(0)(0)|744|(0)(0)|750|(0)|753)(20:231|(4:233|(1:235)(1:236)|237|(1:239)(1:240))(2:244|(1:(4:247|(1:249)(1:250)|251|(1:253)(1:254))(1:255))(28:258|(1:260)(1:262)|855|263|264|874|265|(1:267)(1:268)|269|(1:271)(1:272)|273|257|505|(0)(0)|820|667|(0)|(0)|698|792|699|700|(0)(0)|744|(0)(0)|750|(0)|753))|256|257|505|(0)(0)|820|667|(0)|(0)|698|792|699|700|(0)(0)|744|(0)(0)|750|(0)|753)))(8:216|(2:218|(1:220))|221|868|222|223|865|(8:225|280|281|(0)(0)|822|286|287|(25:331|332|333|(0)(0)|(0)(0)|813|(0)(0)|391|392|505|(0)(0)|820|667|(0)|(0)|698|792|699|700|(0)(0)|744|(0)(0)|750|(0)|753)(0))(0))|846|221|868|222|223|865|(0)(0))|205|863|206|207|851|208|847|(0)(0)|846|221|868|222|223|865|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(29:280|281|(1:283)(1:285)|(3:822|286|287)|(1:331)(13:882|290|291|907|292|(2:828|294)(1:298)|299|300|909|301|(1:303)(1:304)|305|(0)(1:(24:309|333|(1:335)(1:336)|(7:875|338|339|877|340|(1:342)(1:343)|344)(1:351)|813|(7:353|(1:355)(1:356)|357|(1:359)(1:360)|361|(2:(1:368)|369)(1:366)|370)(3:373|(6:804|375|(1:377)(1:379)|380|381|(20:796|383|384|392|505|(4:507|(5:510|(5:918|513|(12:515|794|516|517|809|518|519|814|520|521|(31:529|(1:535)|540|(3:542|830|543)|547|890|548|549|894|550|(2:853|552)|556|557|558|(2:560|561)(1:563)|564|565|(4:567|568|(1:570)|571)(1:573)|574|(1:578)|579|580|(2:582|583)|584|585|586|(2:588|589)(2:590|(1:592))|593|884|594|(6:621|622|(1:626)|628|(7:915|630|631|901|632|(1:634)|635)(1:643)|644)(9:600|(2:604|(1:606))|607|(2:609|(1:611)(5:612|(1:614)(1:615)|616|(1:618)(1:619)|620))(0)|622|(1:627)(2:624|626)|628|(0)(0)|644))(34:(2:811|525)(1:526)|527|528|529|(3:531|533|535)|540|(0)|547|890|548|549|894|550|(0)|556|557|558|(0)(0)|564|565|(0)(0)|574|(2:576|578)|579|580|(0)|584|585|586|(0)(0)|593|884|594|(8:596|598|621|622|(0)(0)|628|(0)(0)|644)(0))|784)(1:656)|657|921)(3:919|512|922)|920|892|508)|917|658)(1:666)|820|667|(4:669|(1:684)|678|(1:690))|(3:692|(1:696)|697)|698|792|699|700|(0)(0)|744|(0)(0)|750|(0)|753))(1:389)|390)|391|392|505|(0)(0)|820|667|(0)|(0)|698|792|699|700|(0)(0)|744|(0)(0)|750|(0)|753)(4:310|(1:312)|313|(5:315|(1:317)|318|319|(23:321|(0)(0)|(0)(0)|813|(0)(0)|391|392|505|(0)(0)|820|667|(0)|(0)|698|792|699|700|(0)(0)|744|(0)(0)|750|(0)|753)))))|332|333|(0)(0)|(0)(0)|813|(0)(0)|391|392|505|(0)(0)|820|667|(0)|(0)|698|792|699|700|(0)(0)|744|(0)(0)|750|(0)|753) */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x0504, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x0505, code lost:
    
        r1 = r52;
        r3 = r0;
        r8 = r47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x0636, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x0637, code lost:
    
        r1 = r52;
        r3 = r0;
        r4 = r8;
        r12 = 0;
        r17 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:371:0x0add, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:397:0x0ba0, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:398:0x0ba1, code lost:
    
        r40 = r8;
        r8 = r47;
        r1 = r52;
        r3 = r0;
        r6 = r37;
        r4 = r40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:399:0x0baf, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:400:0x0bb0, code lost:
    
        r8 = r47;
        r1 = r52;
        r3 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:401:0x0bb8, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:402:0x0bb9, code lost:
    
        r8 = r47;
        r1 = r52;
        r3 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:764:0x148d, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:765:0x148e, code lost:
    
        r6 = r15;
        r8 = r47;
        r1 = r51;
        r2 = r52;
        r3 = r0;
        r32 = r5;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:210:0x04fb A[Catch: Exception -> 0x0504, TRY_ENTER, TRY_LEAVE, TryCatch #29 {Exception -> 0x0504, blocks: (B:210:0x04fb, B:218:0x052c, B:220:0x0532), top: B:847:0x04f9 }] */
    /* JADX WARN: Removed duplicated region for block: B:216:0x050b A[Catch: Exception -> 0x0baf, TRY_ENTER, TRY_LEAVE, TryCatch #31 {Exception -> 0x0baf, blocks: (B:208:0x04e9, B:216:0x050b), top: B:851:0x04e9 }] */
    /* JADX WARN: Removed duplicated region for block: B:225:0x055b  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0836  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x0856 A[Catch: Exception -> 0x0636, TRY_ENTER, TRY_LEAVE, TryCatch #38 {Exception -> 0x0636, blocks: (B:233:0x0568, B:235:0x059c, B:237:0x05a2, B:239:0x05a7, B:240:0x05f2, B:247:0x0649, B:249:0x066d, B:251:0x0673, B:253:0x0678, B:254:0x06c1, B:255:0x0702, B:258:0x0751, B:260:0x076d, B:283:0x0856), top: B:865:0x0559 }] */
    /* JADX WARN: Removed duplicated region for block: B:285:0x085b  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x0955  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x0961  */
    /* JADX WARN: Removed duplicated region for block: B:336:0x0963  */
    /* JADX WARN: Removed duplicated region for block: B:351:0x09aa  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x09b0 A[Catch: Exception -> 0x0add, TRY_ENTER, TryCatch #11 {Exception -> 0x0add, blocks: (B:353:0x09b0, B:355:0x09d5, B:357:0x09db, B:359:0x0a01, B:361:0x0a07, B:366:0x0a10, B:369:0x0a70, B:377:0x0b05), top: B:813:0x09ae }] */
    /* JADX WARN: Removed duplicated region for block: B:373:0x0ae4  */
    /* JADX WARN: Removed duplicated region for block: B:507:0x0f7b  */
    /* JADX WARN: Removed duplicated region for block: B:542:0x0ff9  */
    /* JADX WARN: Removed duplicated region for block: B:560:0x1047  */
    /* JADX WARN: Removed duplicated region for block: B:563:0x1057  */
    /* JADX WARN: Removed duplicated region for block: B:567:0x1060  */
    /* JADX WARN: Removed duplicated region for block: B:573:0x1073  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:582:0x108f  */
    /* JADX WARN: Removed duplicated region for block: B:588:0x109c  */
    /* JADX WARN: Removed duplicated region for block: B:590:0x10a0 A[Catch: Exception -> 0x102d, TryCatch #32 {Exception -> 0x102d, blocks: (B:552:0x1022, B:561:0x1048, B:568:0x1063, B:570:0x106d, B:571:0x106f, B:576:0x107b, B:578:0x107f, B:583:0x1090, B:589:0x109d, B:590:0x10a0, B:592:0x10a4), top: B:853:0x1022 }] */
    /* JADX WARN: Removed duplicated region for block: B:621:0x115c  */
    /* JADX WARN: Removed duplicated region for block: B:624:0x1170 A[Catch: Exception -> 0x1249, TryCatch #50 {Exception -> 0x1249, blocks: (B:594:0x10a9, B:596:0x10bb, B:598:0x10bf, B:600:0x10c7, B:602:0x10ce, B:604:0x10d4, B:606:0x10e9, B:607:0x10ec, B:609:0x10f0, B:611:0x10f6, B:622:0x116a, B:624:0x1170, B:626:0x1177, B:628:0x117f, B:642:0x11c5, B:612:0x110d, B:614:0x1121, B:616:0x1134, B:618:0x1144, B:620:0x1158, B:658:0x122e, B:688:0x12c3, B:690:0x12cc, B:679:0x12a4, B:684:0x12b2, B:692:0x12d3, B:694:0x12f3, B:697:0x12fb, B:696:0x12f9), top: B:884:0x10a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:627:0x117e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:643:0x11c9  */
    /* JADX WARN: Removed duplicated region for block: B:666:0x126e  */
    /* JADX WARN: Removed duplicated region for block: B:669:0x1294  */
    /* JADX WARN: Removed duplicated region for block: B:692:0x12d3 A[Catch: Exception -> 0x1249, TryCatch #50 {Exception -> 0x1249, blocks: (B:594:0x10a9, B:596:0x10bb, B:598:0x10bf, B:600:0x10c7, B:602:0x10ce, B:604:0x10d4, B:606:0x10e9, B:607:0x10ec, B:609:0x10f0, B:611:0x10f6, B:622:0x116a, B:624:0x1170, B:626:0x1177, B:628:0x117f, B:642:0x11c5, B:612:0x110d, B:614:0x1121, B:616:0x1134, B:618:0x1144, B:620:0x1158, B:658:0x122e, B:688:0x12c3, B:690:0x12cc, B:679:0x12a4, B:684:0x12b2, B:692:0x12d3, B:694:0x12f3, B:697:0x12fb, B:696:0x12f9), top: B:884:0x10a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:742:0x1419  */
    /* JADX WARN: Removed duplicated region for block: B:746:0x1432 A[Catch: Exception -> 0x1466, TRY_LEAVE, TryCatch #13 {Exception -> 0x1466, blocks: (B:744:0x142c, B:746:0x1432, B:743:0x1429), top: B:816:0x1429 }] */
    /* JADX WARN: Removed duplicated region for block: B:749:0x143e  */
    /* JADX WARN: Removed duplicated region for block: B:752:0x1446 A[Catch: Exception -> 0x1464, TRY_LEAVE, TryCatch #14 {Exception -> 0x1464, blocks: (B:748:0x1438, B:750:0x1440, B:752:0x1446), top: B:818:0x1438 }] */
    /* JADX WARN: Removed duplicated region for block: B:787:0x150b  */
    /* JADX WARN: Removed duplicated region for block: B:789:0x152f  */
    /* JADX WARN: Removed duplicated region for block: B:844:0x130d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:853:0x1022 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:875:0x0966 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:915:0x1185 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v8, types: [ir.eitaa.tgnet.TLRPC$Message, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r14v20 */
    /* JADX WARN: Type inference failed for: r14v21, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r14v26 */
    /* JADX WARN: Type inference failed for: r1v15, types: [ir.eitaa.SQLite.SQLiteCursor] */
    /* JADX WARN: Type inference failed for: r22v2 */
    /* JADX WARN: Type inference failed for: r2v23, types: [ir.eitaa.SQLite.SQLiteCursor] */
    /* JADX WARN: Type inference failed for: r3v22, types: [ir.eitaa.tgnet.AbstractSerializedData, ir.eitaa.tgnet.NativeByteBuffer] */
    /* JADX WARN: Type inference failed for: r7v9, types: [ir.eitaa.tgnet.TLRPC$Message] */
    /* JADX WARN: Type inference failed for: r9v9, types: [ir.eitaa.tgnet.AbstractSerializedData, ir.eitaa.tgnet.NativeByteBuffer] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Runnable getMessagesInternal(final long r47, final long r49, int r51, int r52, final int r53, int r54, final int r55, final int r56, final boolean r57, final int r58, final int r59, final boolean r60) {
        /*
            Method dump skipped, instructions count: 5463
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessagesStorage.getMessagesInternal(long, long, int, int, int, int, int, int, boolean, int, int, boolean):java.lang.Runnable");
    }

    static /* synthetic */ int lambda$getMessagesInternal$117(TLRPC$Message tLRPC$Message, TLRPC$Message tLRPC$Message2) {
        int i;
        int i2;
        int i3 = tLRPC$Message.id;
        if (i3 > 0 && (i2 = tLRPC$Message2.id) > 0) {
            if (i3 > i2) {
                return -1;
            }
            return i3 < i2 ? 1 : 0;
        }
        if (i3 < 0 && (i = tLRPC$Message2.id) < 0) {
            if (i3 < i) {
                return -1;
            }
            return i3 > i ? 1 : 0;
        }
        int i4 = tLRPC$Message.date;
        int i5 = tLRPC$Message2.date;
        if (i4 > i5) {
            return -1;
        }
        return i4 < i5 ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getMessagesInternal$118, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getMessagesInternal$118$MessagesStorage(TLRPC$TL_messages_messages tLRPC$TL_messages_messages, int i, long j, long j2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, boolean z, boolean z2, int i11, int i12, boolean z3, int i13, boolean z4) {
        getMessagesController().processLoadedMessages(tLRPC$TL_messages_messages, i, j, j2, i2, i3, i4, true, i5, i6, i7, i8, i9, i10, z, z2 ? 1 : 0, i11, i12, z3, i13, z4);
    }

    public void getMessages(final long dialogId, final long mergeDialogId, boolean loadInfo, final int count, final int max_id, final int offset_date, final int minDate, final int classGuid, final int load_type, final boolean scheduled, final int replyMessageId, final int loadIndex, final boolean processMessages) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$TEFjM2NDKv8vBupVupxb3cts_MM
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getMessages$119$MessagesStorage(dialogId, mergeDialogId, count, max_id, offset_date, minDate, classGuid, load_type, scheduled, replyMessageId, loadIndex, processMessages);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getMessages$119, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getMessages$119$MessagesStorage(long j, long j2, int i, int i2, int i3, int i4, int i5, int i6, boolean z, int i7, int i8, boolean z2) {
        Utilities.stageQueue.postRunnable(getMessagesInternal(j, j2, i, i2, i3, i4, i5, i6, z, i7, i8, z2));
    }

    public void clearSentMedia() {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$q8pWoC1fQofPbOzuyL_bmNVW-rQ
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$clearSentMedia$120$MessagesStorage();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$clearSentMedia$120, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$clearSentMedia$120$MessagesStorage() {
        try {
            this.database.executeFast("DELETE FROM sent_files_v2 WHERE 1").stepThis().dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public Object[] getSentFile(final String path, final int type) throws InterruptedException {
        if (path == null || path.toLowerCase().endsWith("attheme")) {
            return null;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final Object[] objArr = new Object[2];
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$VUw978ejzHeiOMnJh83nvAEjRsA
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getSentFile$121$MessagesStorage(path, type, objArr, countDownLatch);
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
    /* renamed from: lambda$getSentFile$121, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getSentFile$121$MessagesStorage(String str, int i, Object[] objArr, CountDownLatch countDownLatch) {
        NativeByteBuffer nativeByteBufferByteBufferValue;
        try {
            try {
                String strMD5 = Utilities.MD5(str);
                if (strMD5 != null) {
                    SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT data, parent FROM sent_files_v2 WHERE uid = '%s' AND type = %d", strMD5, Integer.valueOf(i)), new Object[0]);
                    if (sQLiteCursorQueryFinalized.next() && (nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized.byteBufferValue(0)) != null) {
                        TLRPC$MessageMedia tLRPC$MessageMediaTLdeserialize = TLRPC$MessageMedia.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                        nativeByteBufferByteBufferValue.reuse();
                        if (tLRPC$MessageMediaTLdeserialize instanceof TLRPC$TL_messageMediaDocument) {
                            objArr[0] = ((TLRPC$TL_messageMediaDocument) tLRPC$MessageMediaTLdeserialize).document;
                        } else if (tLRPC$MessageMediaTLdeserialize instanceof TLRPC$TL_messageMediaPhoto) {
                            objArr[0] = ((TLRPC$TL_messageMediaPhoto) tLRPC$MessageMediaTLdeserialize).photo;
                        }
                        if (objArr[0] != null) {
                            objArr[1] = sQLiteCursorQueryFinalized.stringValue(1);
                        }
                    }
                    sQLiteCursorQueryFinalized.dispose();
                }
            } catch (Exception e) {
                FileLog.e(e);
            }
        } finally {
            countDownLatch.countDown();
        }
    }

    private void updateWidgets(long did) {
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(Long.valueOf(did));
        updateWidgets(arrayList);
    }

    private void updateWidgets(ArrayList<Long> dids) {
        if (dids.isEmpty()) {
            return;
        }
        AppWidgetManager appWidgetManager = null;
        try {
            TextUtils.join(",", dids);
            SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT DISTINCT id FROM shortcut_widget WHERE did IN(%s,-1)", TextUtils.join(",", dids)), new Object[0]);
            while (sQLiteCursorQueryFinalized.next()) {
                if (appWidgetManager == null) {
                    appWidgetManager = AppWidgetManager.getInstance(ApplicationLoader.applicationContext);
                }
                appWidgetManager.notifyAppWidgetViewDataChanged(sQLiteCursorQueryFinalized.intValue(0), R.id.list_view);
            }
            sQLiteCursorQueryFinalized.dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void putWidgetDialogs(final int widgetId, final ArrayList<Long> dids) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$r-cADPj_JEPiGr9XCWl1jvjM3iU
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$putWidgetDialogs$122$MessagesStorage(widgetId, dids);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$putWidgetDialogs$122, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$putWidgetDialogs$122$MessagesStorage(int i, ArrayList arrayList) {
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

    public void clearWidgetDialogs(final int widgetId) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$HK9bS_NbyfsXRFWFtmbLjM1McEc
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$clearWidgetDialogs$123$MessagesStorage(widgetId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$clearWidgetDialogs$123, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$clearWidgetDialogs$123$MessagesStorage(int i) {
        try {
            this.database.executeFast("DELETE FROM shortcut_widget WHERE id = " + i).stepThis().dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void getWidgetDialogIds(final int widgetId, final int type, final ArrayList<Long> dids, final ArrayList<TLRPC$User> users, final ArrayList<TLRPC$Chat> chats, final boolean edit) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$ZZrAUD7BYuwEu5_n-BvWFbYdQ9I
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getWidgetDialogIds$124$MessagesStorage(widgetId, dids, users, chats, edit, type, countDownLatch);
            }
        });
        try {
            countDownLatch.await();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getWidgetDialogIds$124, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getWidgetDialogIds$124$MessagesStorage(int i, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, boolean z, int i2, CountDownLatch countDownLatch) {
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
                            if (DialogObject.isUserDialog(jLongValue)) {
                                arrayList4.add(Long.valueOf(jLongValue));
                            } else {
                                arrayList5.add(Long.valueOf(-jLongValue));
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
                                    if (DialogObject.isUserDialog(jLongValue2)) {
                                        arrayList4.add(Long.valueOf(jLongValue2));
                                    } else {
                                        arrayList5.add(Long.valueOf(-jLongValue2));
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
                                if (DialogObject.isUserDialog(jLongValue3)) {
                                    arrayList4.add(Long.valueOf(jLongValue3));
                                } else {
                                    arrayList5.add(Long.valueOf(-jLongValue3));
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

    public void getWidgetDialogs(final int widgetId, final int type, final ArrayList<Long> dids, final LongSparseArray<TLRPC$Dialog> dialogs, final LongSparseArray<TLRPC$Message> messages, final ArrayList<TLRPC$User> users, final ArrayList<TLRPC$Chat> chats) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$TIBHY6CsLqDW2AmSRMpj83XVU-Y
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getWidgetDialogs$125$MessagesStorage(widgetId, dids, type, dialogs, messages, chats, users, countDownLatch);
            }
        });
        try {
            countDownLatch.await();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getWidgetDialogs$125, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getWidgetDialogs$125$MessagesStorage(int i, ArrayList arrayList, int i2, LongSparseArray longSparseArray, LongSparseArray longSparseArray2, ArrayList arrayList2, ArrayList arrayList3, CountDownLatch countDownLatch) {
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
                        if (DialogObject.isUserDialog(jLongValue)) {
                            arrayList4.add(Long.valueOf(jLongValue));
                        } else {
                            arrayList5.add(Long.valueOf(-jLongValue));
                        }
                    }
                }
                sQLiteCursorQueryFinalized2.dispose();
                if (arrayList.isEmpty() && i2 == 1) {
                    SQLiteCursor sQLiteCursorQueryFinalized3 = getMessagesStorage().getDatabase().queryFinalized("SELECT did FROM chat_hints WHERE type = 0 ORDER BY rating DESC LIMIT 4", new Object[0]);
                    while (sQLiteCursorQueryFinalized3.next()) {
                        long jLongValue2 = sQLiteCursorQueryFinalized3.longValue(0);
                        arrayList.add(Long.valueOf(jLongValue2));
                        if (DialogObject.isUserDialog(jLongValue2)) {
                            arrayList4.add(Long.valueOf(jLongValue2));
                        } else {
                            arrayList5.add(Long.valueOf(-jLongValue2));
                        }
                    }
                    sQLiteCursorQueryFinalized3.dispose();
                }
                if (arrayList.isEmpty()) {
                    sQLiteCursorQueryFinalized = this.database.queryFinalized("SELECT d.did, d.last_mid, d.unread_count, d.date, m.data, m.read_state, m.mid, m.send_state, m.date FROM dialogs as d LEFT JOIN messages_v2 as m ON d.last_mid = m.mid AND d.did = m.uid WHERE d.folder_id = 0 ORDER BY d.pinned DESC, d.date DESC LIMIT 0,10", new Object[0]);
                    z = true;
                } else {
                    sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT d.did, d.last_mid, d.unread_count, d.date, m.data, m.read_state, m.mid, m.send_state, m.date FROM dialogs as d LEFT JOIN messages_v2 as m ON d.last_mid = m.mid AND d.did = m.uid WHERE d.did IN(%s)", TextUtils.join(",", arrayList)), new Object[0]);
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
                    for (int i3 = 0; i3 < size; i3++) {
                        long jLongValue4 = ((Long) arrayList.get(i3)).longValue();
                        if (longSparseArray.get(((Long) arrayList.get(i3)).longValue()) == null) {
                            TLRPC$TL_dialog tLRPC$TL_dialog2 = new TLRPC$TL_dialog();
                            tLRPC$TL_dialog2.id = jLongValue4;
                            longSparseArray.put(jLongValue4, tLRPC$TL_dialog2);
                            if (DialogObject.isChatDialog(jLongValue4)) {
                                long j2 = -jLongValue4;
                                if (arrayList5.contains(Long.valueOf(j2))) {
                                    arrayList5.add(Long.valueOf(j2));
                                }
                            } else if (arrayList4.contains(Long.valueOf(jLongValue4))) {
                                arrayList4.add(Long.valueOf(jLongValue4));
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

    public void putSentFile(final String path, final TLObject file, final int type, final String parent) {
        if (path == null || file == null || parent == null) {
            return;
        }
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$JCspHu6InM3jHtN2YmWQ0ZPp_Sw
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$putSentFile$126$MessagesStorage(path, file, type, parent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$putSentFile$126, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$putSentFile$126$MessagesStorage(String str, TLObject tLObject, int i, String str2) {
        TLRPC$MessageMedia tLRPC$TL_messageMediaDocument;
        SQLitePreparedStatement sQLitePreparedStatementExecuteFast = null;
        try {
            try {
                String strMD5 = Utilities.MD5(str);
                if (strMD5 != null) {
                    if (tLObject instanceof TLRPC$Photo) {
                        tLRPC$TL_messageMediaDocument = new TLRPC$TL_messageMediaPhoto();
                        tLRPC$TL_messageMediaDocument.photo = (TLRPC$Photo) tLObject;
                        tLRPC$TL_messageMediaDocument.flags |= 1;
                    } else if (tLObject instanceof TLRPC$Document) {
                        tLRPC$TL_messageMediaDocument = new TLRPC$TL_messageMediaDocument();
                        tLRPC$TL_messageMediaDocument.document = (TLRPC$Document) tLObject;
                        tLRPC$TL_messageMediaDocument.flags |= 1;
                    } else {
                        tLRPC$TL_messageMediaDocument = null;
                    }
                    if (tLRPC$TL_messageMediaDocument == null) {
                        return;
                    }
                    sQLitePreparedStatementExecuteFast = this.database.executeFast("REPLACE INTO sent_files_v2 VALUES(?, ?, ?, ?)");
                    sQLitePreparedStatementExecuteFast.requery();
                    NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(tLRPC$TL_messageMediaDocument.getObjectSize());
                    tLRPC$TL_messageMediaDocument.serializeToStream(nativeByteBuffer);
                    sQLitePreparedStatementExecuteFast.bindString(1, strMD5);
                    sQLitePreparedStatementExecuteFast.bindInteger(2, i);
                    sQLitePreparedStatementExecuteFast.bindByteBuffer(3, nativeByteBuffer);
                    sQLitePreparedStatementExecuteFast.bindString(4, str2);
                    sQLitePreparedStatementExecuteFast.step();
                    nativeByteBuffer.reuse();
                }
                if (sQLitePreparedStatementExecuteFast == null) {
                    return;
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

    public void updateEncryptedChatSeq(final TLRPC$EncryptedChat chat, final boolean cleanup) {
        if (chat == null) {
            return;
        }
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$7zHBSnJMWqDcMyVBAkKvPKNr5_w
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateEncryptedChatSeq$127$MessagesStorage(chat, cleanup);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateEncryptedChatSeq$127, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateEncryptedChatSeq$127$MessagesStorage(TLRPC$EncryptedChat tLRPC$EncryptedChat, boolean z) {
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
                    long encryptedChatId = DialogObject.getEncryptedChatId(tLRPC$EncryptedChat.id);
                    this.database.executeFast(String.format(Locale.US, "DELETE FROM messages_v2 WHERE mid IN (SELECT m.mid FROM messages_v2 as m LEFT JOIN messages_seq as s ON m.mid = s.mid WHERE m.uid = %d AND m.date = 0 AND m.mid < 0 AND s.seq_out <= %d) AND uid = %d", Long.valueOf(encryptedChatId), Integer.valueOf(tLRPC$EncryptedChat.in_seq_no), Long.valueOf(encryptedChatId))).stepThis().dispose();
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

    public void updateEncryptedChatTTL(final TLRPC$EncryptedChat chat) {
        if (chat == null) {
            return;
        }
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$Rqt_K6DSEVFhId1BQELu8fvbzt4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateEncryptedChatTTL$128$MessagesStorage(chat);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateEncryptedChatTTL$128, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateEncryptedChatTTL$128$MessagesStorage(TLRPC$EncryptedChat tLRPC$EncryptedChat) {
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

    public void updateEncryptedChatLayer(final TLRPC$EncryptedChat chat) {
        if (chat == null) {
            return;
        }
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$noU-O76cgYgL0ABgFxgVbFCrr5M
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateEncryptedChatLayer$129$MessagesStorage(chat);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateEncryptedChatLayer$129, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateEncryptedChatLayer$129$MessagesStorage(TLRPC$EncryptedChat tLRPC$EncryptedChat) {
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

    public void updateEncryptedChat(final TLRPC$EncryptedChat chat) {
        if (chat == null) {
            return;
        }
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$ohfiVQlJlblphFKGg6WXIP3XJ_8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateEncryptedChat$130$MessagesStorage(chat);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateEncryptedChat$130, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateEncryptedChat$130$MessagesStorage(TLRPC$EncryptedChat tLRPC$EncryptedChat) {
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
                sQLitePreparedStatementExecuteFast.bindLong(15, tLRPC$EncryptedChat.admin_id);
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

    public void isDialogHasTopMessage(final long did, final Runnable onDontExist) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$V4PF5tb3fsc9g1Cs37ratDs9pkE
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$isDialogHasTopMessage$131$MessagesStorage(did, onDontExist);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$isDialogHasTopMessage$131, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$isDialogHasTopMessage$131$MessagesStorage(long j, Runnable runnable) {
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

    public boolean hasAuthMessage(final int date) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final boolean[] zArr = new boolean[1];
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$Rm-Jts79t9hJcEN_EXdXP-GHdSY
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$hasAuthMessage$132$MessagesStorage(date, zArr, countDownLatch);
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
    /* renamed from: lambda$hasAuthMessage$132, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$hasAuthMessage$132$MessagesStorage(int i, boolean[] zArr, CountDownLatch countDownLatch) {
        try {
            try {
                SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT mid FROM messages_v2 WHERE uid = 777000 AND date = %d AND mid < 0 LIMIT 1", Integer.valueOf(i)), new Object[0]);
                zArr[0] = sQLiteCursorQueryFinalized.next();
                sQLiteCursorQueryFinalized.dispose();
            } catch (Exception e) {
                FileLog.e(e);
            }
        } finally {
            countDownLatch.countDown();
        }
    }

    public void getEncryptedChat(final long chatId, final CountDownLatch countDownLatch, final ArrayList<TLObject> result) {
        if (countDownLatch == null || result == null) {
            return;
        }
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$ZIk4XQ4UVlqxgzdJ40NRoNUr3xI
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getEncryptedChat$133$MessagesStorage(chatId, result, countDownLatch);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getEncryptedChat$133, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getEncryptedChat$133$MessagesStorage(long j, ArrayList arrayList, CountDownLatch countDownLatch) {
        try {
            try {
                ArrayList<Long> arrayList2 = new ArrayList<>();
                ArrayList<TLRPC$EncryptedChat> arrayList3 = new ArrayList<>();
                getEncryptedChatsInternal("" + j, arrayList3, arrayList2);
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

    public void putEncryptedChat(final TLRPC$EncryptedChat chat, final TLRPC$User user, final TLRPC$Dialog dialog) {
        if (chat == null) {
            return;
        }
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$dIACKbuo4bKRBnx_-_W9b7Ic1Eo
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$putEncryptedChat$134$MessagesStorage(chat, user, dialog);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$putEncryptedChat$134, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$putEncryptedChat$134$MessagesStorage(TLRPC$EncryptedChat tLRPC$EncryptedChat, TLRPC$User tLRPC$User, TLRPC$Dialog tLRPC$Dialog) {
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
            sQLitePreparedStatementExecuteFast.bindLong(2, tLRPC$User.id);
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
            sQLitePreparedStatementExecuteFast.bindLong(18, tLRPC$EncryptedChat.admin_id);
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
                sQLitePreparedStatementExecuteFast2.bindInteger(4, tLRPC$Dialog.top_message);
                sQLitePreparedStatementExecuteFast2.bindInteger(5, tLRPC$Dialog.read_inbox_max_id);
                sQLitePreparedStatementExecuteFast2.bindInteger(6, tLRPC$Dialog.read_outbox_max_id);
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

    private String formatUserSearchName(TLRPC$User user) {
        StringBuilder sb = new StringBuilder();
        String str = user.first_name;
        if (str != null && str.length() > 0) {
            sb.append(user.first_name);
        }
        String str2 = user.last_name;
        if (str2 != null && str2.length() > 0) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(user.last_name);
        }
        sb.append(";;;");
        String str3 = user.username;
        if (str3 != null && str3.length() > 0) {
            sb.append(user.username);
        }
        return sb.toString().toLowerCase();
    }

    private void putUsersInternal(ArrayList<TLRPC$User> users) throws Exception {
        if (users == null || users.isEmpty()) {
            return;
        }
        SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("REPLACE INTO users VALUES(?, ?, ?, ?)");
        for (int i = 0; i < users.size(); i++) {
            TLRPC$User tLRPC$User = users.get(i);
            if (tLRPC$User.min) {
                SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT data FROM users WHERE uid = %d", Long.valueOf(tLRPC$User.id)), new Object[0]);
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
            sQLitePreparedStatementExecuteFast.bindLong(1, tLRPC$User.id);
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

    public void updateChatDefaultBannedRights(final long chatId, final TLRPC$TL_chatBannedRights rights, final int version) {
        if (rights == null || chatId == 0) {
            return;
        }
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$676zQQhOEgCPd9F7-CVQL44eQeQ
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateChatDefaultBannedRights$135$MessagesStorage(chatId, version, rights);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateChatDefaultBannedRights$135, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateChatDefaultBannedRights$135$MessagesStorage(long j, int i, TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights) {
        NativeByteBuffer nativeByteBufferByteBufferValue;
        TLRPC$Chat tLRPC$ChatTLdeserialize = null;
        try {
            SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT data FROM chats WHERE uid = %d", Long.valueOf(j)), new Object[0]);
            if (sQLiteCursorQueryFinalized.next() && (nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized.byteBufferValue(0)) != null) {
                tLRPC$ChatTLdeserialize = TLRPC$Chat.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                nativeByteBufferByteBufferValue.reuse();
            }
            sQLiteCursorQueryFinalized.dispose();
            if (tLRPC$ChatTLdeserialize != null) {
                if (tLRPC$ChatTLdeserialize.default_banned_rights == null || i >= tLRPC$ChatTLdeserialize.version) {
                    tLRPC$ChatTLdeserialize.default_banned_rights = tLRPC$TL_chatBannedRights;
                    tLRPC$ChatTLdeserialize.flags |= 262144;
                    tLRPC$ChatTLdeserialize.version = i;
                    SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("UPDATE chats SET data = ? WHERE uid = ?");
                    NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(tLRPC$ChatTLdeserialize.getObjectSize());
                    tLRPC$ChatTLdeserialize.serializeToStream(nativeByteBuffer);
                    sQLitePreparedStatementExecuteFast.bindByteBuffer(1, nativeByteBuffer);
                    sQLitePreparedStatementExecuteFast.bindLong(2, tLRPC$ChatTLdeserialize.id);
                    sQLitePreparedStatementExecuteFast.step();
                    nativeByteBuffer.reuse();
                    sQLitePreparedStatementExecuteFast.dispose();
                }
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    private void putChatsInternal(ArrayList<TLRPC$Chat> chats) throws Exception {
        ArrayList<TLRPC$TL_restrictionReason> arrayList;
        if (chats == null || chats.isEmpty()) {
            return;
        }
        SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("REPLACE INTO chats VALUES(?, ?, ?)");
        for (int i = 0; i < chats.size(); i++) {
            TLRPC$Chat tLRPC$Chat = chats.get(i);
            if (tLRPC$Chat.min) {
                SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT data FROM chats WHERE uid = %d", Long.valueOf(tLRPC$Chat.id)), new Object[0]);
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
                                boolean z = tLRPC$Chat.restricted;
                                tLRPC$ChatTLdeserialize.restricted = z;
                                if (!z && (arrayList = tLRPC$ChatTLdeserialize.restriction_reason) != null) {
                                    arrayList.clear();
                                } else if (z && tLRPC$Chat.restriction_reason != null) {
                                    for (int i2 = 0; i2 < tLRPC$Chat.restriction_reason.size(); i2++) {
                                        ArrayList<TLRPC$TL_restrictionReason> arrayList2 = tLRPC$ChatTLdeserialize.restriction_reason;
                                        if (arrayList2 == null) {
                                            ArrayList<TLRPC$TL_restrictionReason> arrayList3 = new ArrayList<>();
                                            tLRPC$ChatTLdeserialize.restriction_reason = arrayList3;
                                            arrayList3.add(tLRPC$Chat.restriction_reason.get(i2));
                                        } else {
                                            if (i2 == 0) {
                                                arrayList2.clear();
                                            }
                                            tLRPC$ChatTLdeserialize.restriction_reason.add(tLRPC$Chat.restriction_reason.get(i2));
                                        }
                                    }
                                }
                                TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights = tLRPC$Chat.default_banned_rights;
                                if (tLRPC$TL_chatBannedRights != null) {
                                    tLRPC$ChatTLdeserialize.default_banned_rights = tLRPC$TL_chatBannedRights;
                                    tLRPC$ChatTLdeserialize.flags |= 262144;
                                }
                                TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights = tLRPC$Chat.admin_rights;
                                if (tLRPC$TL_chatAdminRights != null) {
                                    tLRPC$ChatTLdeserialize.admin_rights = tLRPC$TL_chatAdminRights;
                                    tLRPC$ChatTLdeserialize.flags |= 16384;
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
                                int i3 = tLRPC$Chat.live_stream_msg_id;
                                if (i3 != 0) {
                                    tLRPC$ChatTLdeserialize.live_stream_msg_id = i3;
                                    tLRPC$ChatTLdeserialize.flags |= 536870912;
                                } else {
                                    tLRPC$ChatTLdeserialize.flags &= -536870913;
                                    tLRPC$ChatTLdeserialize.live_stream_msg_id = 0;
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
            tLRPC$Chat.flags |= 131072;
            NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(tLRPC$Chat.getObjectSize());
            tLRPC$Chat.serializeToStream(nativeByteBuffer);
            sQLitePreparedStatementExecuteFast.bindLong(1, tLRPC$Chat.id);
            String str2 = tLRPC$Chat.title;
            if (str2 != null) {
                sQLitePreparedStatementExecuteFast.bindString(2, str2.toLowerCase());
            } else {
                sQLitePreparedStatementExecuteFast.bindString(2, "");
            }
            sQLitePreparedStatementExecuteFast.bindByteBuffer(3, nativeByteBuffer);
            sQLitePreparedStatementExecuteFast.step();
            nativeByteBuffer.reuse();
        }
        sQLitePreparedStatementExecuteFast.dispose();
    }

    public void getUsersInternal(String usersToLoad, ArrayList<TLRPC$User> result) throws Exception {
        if (usersToLoad == null || usersToLoad.length() == 0 || result == null) {
            return;
        }
        SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT data, status FROM users WHERE uid IN(%s)", usersToLoad), new Object[0]);
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
                        result.add(tLRPC$UserTLdeserialize);
                    }
                }
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
        sQLiteCursorQueryFinalized.dispose();
    }

    public void getChatsInternal(String chatsToLoad, ArrayList<TLRPC$Chat> result) throws Exception {
        if (chatsToLoad == null || chatsToLoad.length() == 0 || result == null) {
            return;
        }
        SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT data FROM chats WHERE uid IN(%s)", chatsToLoad), new Object[0]);
        while (sQLiteCursorQueryFinalized.next()) {
            try {
                NativeByteBuffer nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized.byteBufferValue(0);
                if (nativeByteBufferByteBufferValue != null) {
                    TLRPC$Chat tLRPC$ChatTLdeserialize = TLRPC$Chat.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                    nativeByteBufferByteBufferValue.reuse();
                    if (tLRPC$ChatTLdeserialize != null) {
                        result.add(tLRPC$ChatTLdeserialize);
                    }
                }
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
        sQLiteCursorQueryFinalized.dispose();
    }

    public void getEncryptedChatsInternal(String chatsToLoad, ArrayList<TLRPC$EncryptedChat> result, ArrayList<Long> usersToLoad) throws Exception {
        if (chatsToLoad == null || chatsToLoad.length() == 0 || result == null) {
            return;
        }
        SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT data, user, g, authkey, ttl, layer, seq_in, seq_out, use_count, exchange_id, key_date, fprint, fauthkey, khash, in_seq_no, admin_id, mtproto_seq FROM enc_chats WHERE uid IN(%s)", chatsToLoad), new Object[0]);
        while (sQLiteCursorQueryFinalized.next()) {
            try {
                NativeByteBuffer nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized.byteBufferValue(0);
                if (nativeByteBufferByteBufferValue != null) {
                    TLRPC$EncryptedChat tLRPC$EncryptedChatTLdeserialize = TLRPC$EncryptedChat.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                    nativeByteBufferByteBufferValue.reuse();
                    if (tLRPC$EncryptedChatTLdeserialize != null) {
                        long jLongValue = sQLiteCursorQueryFinalized.longValue(1);
                        tLRPC$EncryptedChatTLdeserialize.user_id = jLongValue;
                        if (usersToLoad != null && !usersToLoad.contains(Long.valueOf(jLongValue))) {
                            usersToLoad.add(Long.valueOf(tLRPC$EncryptedChatTLdeserialize.user_id));
                        }
                        tLRPC$EncryptedChatTLdeserialize.a_or_b = sQLiteCursorQueryFinalized.byteArrayValue(2);
                        tLRPC$EncryptedChatTLdeserialize.auth_key = sQLiteCursorQueryFinalized.byteArrayValue(3);
                        tLRPC$EncryptedChatTLdeserialize.ttl = sQLiteCursorQueryFinalized.intValue(4);
                        tLRPC$EncryptedChatTLdeserialize.layer = sQLiteCursorQueryFinalized.intValue(5);
                        tLRPC$EncryptedChatTLdeserialize.seq_in = sQLiteCursorQueryFinalized.intValue(6);
                        tLRPC$EncryptedChatTLdeserialize.seq_out = sQLiteCursorQueryFinalized.intValue(7);
                        int iIntValue = sQLiteCursorQueryFinalized.intValue(8);
                        tLRPC$EncryptedChatTLdeserialize.key_use_count_in = (short) (iIntValue >> 16);
                        tLRPC$EncryptedChatTLdeserialize.key_use_count_out = (short) iIntValue;
                        tLRPC$EncryptedChatTLdeserialize.exchange_id = sQLiteCursorQueryFinalized.longValue(9);
                        tLRPC$EncryptedChatTLdeserialize.key_create_date = sQLiteCursorQueryFinalized.intValue(10);
                        tLRPC$EncryptedChatTLdeserialize.future_key_fingerprint = sQLiteCursorQueryFinalized.longValue(11);
                        tLRPC$EncryptedChatTLdeserialize.future_auth_key = sQLiteCursorQueryFinalized.byteArrayValue(12);
                        tLRPC$EncryptedChatTLdeserialize.key_hash = sQLiteCursorQueryFinalized.byteArrayValue(13);
                        tLRPC$EncryptedChatTLdeserialize.in_seq_no = sQLiteCursorQueryFinalized.intValue(14);
                        long jLongValue2 = sQLiteCursorQueryFinalized.longValue(15);
                        if (jLongValue2 != 0) {
                            tLRPC$EncryptedChatTLdeserialize.admin_id = jLongValue2;
                        }
                        tLRPC$EncryptedChatTLdeserialize.mtproto_seq = sQLiteCursorQueryFinalized.intValue(16);
                        result.add(tLRPC$EncryptedChatTLdeserialize);
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
    public void lambda$putUsersAndChats$136$MessagesStorage(ArrayList<TLRPC$User> users, ArrayList<TLRPC$Chat> chats, boolean withTransaction) {
        if (withTransaction) {
            try {
                this.database.beginTransaction();
            } catch (Exception e) {
                FileLog.e(e);
                return;
            }
        }
        putUsersInternal(users);
        putChatsInternal(chats);
        if (withTransaction) {
            this.database.commitTransaction();
        }
    }

    public void putUsersAndChats(final ArrayList<TLRPC$User> users, final ArrayList<TLRPC$Chat> chats, final boolean withTransaction, boolean useQueue) {
        if (users == null || !users.isEmpty() || chats == null || !chats.isEmpty()) {
            if (useQueue) {
                this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$vF18_KIzE-H27ZrbrUnaNwJsVu0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$putUsersAndChats$136$MessagesStorage(users, chats, withTransaction);
                    }
                });
            } else {
                lambda$putUsersAndChats$136(users, chats, withTransaction);
            }
        }
    }

    public void removeFromDownloadQueue(final long id, final int type, final boolean move) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$DUlrIoo_mHBnTQJpfuD1ZrTxZXc
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$removeFromDownloadQueue$137$MessagesStorage(move, type, id);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$removeFromDownloadQueue$137, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$removeFromDownloadQueue$137$MessagesStorage(boolean z, int i, long j) {
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

    private void deleteFromDownloadQueue(final ArrayList<Pair<Long, Integer>> ids, boolean transaction) {
        if (ids == null || ids.isEmpty()) {
            return;
        }
        if (transaction) {
            try {
                this.database.beginTransaction();
            } catch (Exception e) {
                FileLog.e(e);
                return;
            }
        }
        SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("DELETE FROM download_queue WHERE uid = ? AND type = ?");
        int size = ids.size();
        for (int i = 0; i < size; i++) {
            Pair<Long, Integer> pair = ids.get(i);
            sQLitePreparedStatementExecuteFast.requery();
            sQLitePreparedStatementExecuteFast.bindLong(1, ((Long) pair.first).longValue());
            sQLitePreparedStatementExecuteFast.bindInteger(2, ((Integer) pair.second).intValue());
            sQLitePreparedStatementExecuteFast.step();
        }
        sQLitePreparedStatementExecuteFast.dispose();
        if (transaction) {
            this.database.commitTransaction();
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$rdDyG1S0bnrHGAHEOJoauqDWvMw
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$deleteFromDownloadQueue$138$MessagesStorage(ids);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$deleteFromDownloadQueue$138, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$deleteFromDownloadQueue$138$MessagesStorage(ArrayList arrayList) {
        getDownloadController().cancelDownloading(arrayList);
    }

    public void clearDownloadQueue(final int type) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$WRrlPHtZQDOg4aEU__HAd3G3sEo
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$clearDownloadQueue$139$MessagesStorage(type);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$clearDownloadQueue$139, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$clearDownloadQueue$139$MessagesStorage(int i) {
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

    public void getDownloadQueue(final int type) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$UIC5p0MdRwgdqf3F7KvSN2b6oKA
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getDownloadQueue$141$MessagesStorage(type);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getDownloadQueue$141, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getDownloadQueue$141$MessagesStorage(final int i) {
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
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$YEhUZf_bMAtsKPEbbHN9B-7P49w
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$getDownloadQueue$140$MessagesStorage(i, arrayList);
                }
            });
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getDownloadQueue$140, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getDownloadQueue$140$MessagesStorage(int i, ArrayList arrayList) {
        getDownloadController().processDownloadObjects(i, arrayList);
    }

    private int getMessageMediaType(TLRPC$Message message) {
        if (message instanceof TLRPC$TL_message_secret) {
            if (!(message.media instanceof TLRPC$TL_messageMediaPhoto) && !MessageObject.isGifMessage(message) && !MessageObject.isVoiceMessage(message) && !MessageObject.isVideoMessage(message) && !MessageObject.isRoundVideoMessage(message)) {
                return -1;
            }
            int i = message.ttl;
            return (i <= 0 || i > 60) ? 0 : 1;
        }
        if (message instanceof TLRPC$TL_message) {
            TLRPC$MessageMedia tLRPC$MessageMedia = message.media;
            if (((tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaPhoto) || (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaDocument)) && tLRPC$MessageMedia.ttl_seconds != 0) {
                return 1;
            }
        }
        return ((message.media instanceof TLRPC$TL_messageMediaPhoto) || MessageObject.isVideoMessage(message)) ? 0 : -1;
    }

    public void putWebPages(final LongSparseArray<TLRPC$WebPage> webPages) {
        if (isEmpty(webPages)) {
            return;
        }
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$QSHqEOa6LiBjk6N_chckelDgCAk
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$putWebPages$143$MessagesStorage(webPages);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$putWebPages$143, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$putWebPages$143$MessagesStorage(LongSparseArray longSparseArray) {
        try {
            final ArrayList arrayList = new ArrayList();
            int size = longSparseArray.size();
            int i = 0;
            int i2 = 0;
            while (true) {
                int i3 = 2;
                if (i2 >= size) {
                    break;
                }
                SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized("SELECT mid, uid FROM webpage_pending_v2 WHERE id = " + longSparseArray.keyAt(i2), new Object[i]);
                LongSparseArray longSparseArray2 = new LongSparseArray();
                while (sQLiteCursorQueryFinalized.next()) {
                    long jLongValue = sQLiteCursorQueryFinalized.longValue(1);
                    ArrayList arrayList2 = (ArrayList) longSparseArray2.get(jLongValue);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                        longSparseArray2.put(jLongValue, arrayList2);
                    }
                    arrayList2.add(Integer.valueOf(sQLiteCursorQueryFinalized.intValue(i)));
                }
                sQLiteCursorQueryFinalized.dispose();
                if (!longSparseArray2.isEmpty()) {
                    int size2 = longSparseArray2.size();
                    int i4 = 0;
                    while (i4 < size2) {
                        long jKeyAt = longSparseArray2.keyAt(i4);
                        ArrayList arrayList3 = (ArrayList) longSparseArray2.valueAt(i4);
                        SQLiteDatabase sQLiteDatabase = this.database;
                        Locale locale = Locale.US;
                        Object[] objArr = new Object[i3];
                        objArr[0] = TextUtils.join(",", arrayList3);
                        objArr[1] = Long.valueOf(jKeyAt);
                        SQLiteCursor sQLiteCursorQueryFinalized2 = sQLiteDatabase.queryFinalized(String.format(locale, "SELECT mid, data FROM messages_v2 WHERE mid IN (%s) AND uid = %d", objArr), new Object[0]);
                        while (sQLiteCursorQueryFinalized2.next()) {
                            int iIntValue = sQLiteCursorQueryFinalized2.intValue(0);
                            NativeByteBuffer nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized2.byteBufferValue(1);
                            if (nativeByteBufferByteBufferValue != null) {
                                TLRPC$Message tLRPC$MessageTLdeserialize = TLRPC$Message.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                                tLRPC$MessageTLdeserialize.readAttachPath(nativeByteBufferByteBufferValue, getUserConfig().clientUserId);
                                nativeByteBufferByteBufferValue.reuse();
                                TLRPC$MessageMedia tLRPC$MessageMedia = tLRPC$MessageTLdeserialize.media;
                                if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaWebPage) {
                                    tLRPC$MessageTLdeserialize.id = iIntValue;
                                    tLRPC$MessageMedia.webpage = (TLRPC$WebPage) longSparseArray.valueAt(i2);
                                    arrayList.add(tLRPC$MessageTLdeserialize);
                                }
                            }
                        }
                        sQLiteCursorQueryFinalized2.dispose();
                        i4++;
                        i3 = 2;
                    }
                }
                i2++;
                i = 0;
            }
            if (arrayList.isEmpty()) {
                return;
            }
            this.database.beginTransaction();
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("UPDATE messages_v2 SET data = ? WHERE mid = ? AND uid = ?");
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast2 = this.database.executeFast("UPDATE media_v3 SET data = ? WHERE mid = ? AND uid = ?");
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                TLRPC$Message tLRPC$Message = (TLRPC$Message) arrayList.get(i5);
                NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(tLRPC$Message.getObjectSize());
                tLRPC$Message.serializeToStream(nativeByteBuffer);
                sQLitePreparedStatementExecuteFast.requery();
                sQLitePreparedStatementExecuteFast.bindByteBuffer(1, nativeByteBuffer);
                sQLitePreparedStatementExecuteFast.bindInteger(2, tLRPC$Message.id);
                sQLitePreparedStatementExecuteFast.bindLong(3, MessageObject.getDialogId(tLRPC$Message));
                sQLitePreparedStatementExecuteFast.step();
                sQLitePreparedStatementExecuteFast2.requery();
                sQLitePreparedStatementExecuteFast2.bindByteBuffer(1, nativeByteBuffer);
                sQLitePreparedStatementExecuteFast2.bindInteger(2, tLRPC$Message.id);
                sQLitePreparedStatementExecuteFast2.bindLong(3, MessageObject.getDialogId(tLRPC$Message));
                sQLitePreparedStatementExecuteFast2.step();
                nativeByteBuffer.reuse();
            }
            sQLitePreparedStatementExecuteFast.dispose();
            sQLitePreparedStatementExecuteFast2.dispose();
            this.database.commitTransaction();
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$gLfZTFotQLrkm8cEkeiYtefntUo
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$putWebPages$142$MessagesStorage(arrayList);
                }
            });
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$putWebPages$142, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$putWebPages$142$MessagesStorage(ArrayList arrayList) {
        getNotificationCenter().postNotificationName(NotificationCenter.didReceivedWebpages, arrayList);
    }

    public void overwriteChannel(final long channelId, final TLRPC$TL_updates_channelDifferenceTooLong difference, final int newDialogType) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$lAQQ7h-u7xmXZRzsbEKXLHuAcN4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$overwriteChannel$145$MessagesStorage(channelId, newDialogType, difference);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* renamed from: lambda$overwriteChannel$145, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$overwriteChannel$145$MessagesStorage(long r19, int r21, final ir.eitaa.tgnet.TLRPC$TL_updates_channelDifferenceTooLong r22) {
        /*
            Method dump skipped, instructions count: 411
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessagesStorage.lambda$overwriteChannel$145$MessagesStorage(long, int, ir.eitaa.tgnet.TLRPC$TL_updates_channelDifferenceTooLong):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$overwriteChannel$144, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$overwriteChannel$144$MessagesStorage(long j, TLRPC$TL_updates_channelDifferenceTooLong tLRPC$TL_updates_channelDifferenceTooLong) {
        getNotificationCenter().postNotificationName(NotificationCenter.removeAllMessagesFromDialog, Long.valueOf(j), Boolean.TRUE, tLRPC$TL_updates_channelDifferenceTooLong);
    }

    public void putChannelViews(final LongSparseArray<SparseIntArray> channelViews, final LongSparseArray<SparseIntArray> channelForwards, final LongSparseArray<SparseArray<TLRPC$MessageReplies>> channelReplies, final boolean addReply) {
        if (isEmpty(channelViews) && isEmpty(channelForwards) && isEmpty(channelReplies)) {
            return;
        }
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$bpV1qD4Xi1NEc2btLakiRYmLgI4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$putChannelViews$146$MessagesStorage(channelViews, channelForwards, channelReplies, addReply);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$putChannelViews$146, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$putChannelViews$146$MessagesStorage(LongSparseArray longSparseArray, LongSparseArray longSparseArray2, LongSparseArray longSparseArray3, boolean z) {
        TLRPC$MessageReplies tLRPC$MessageRepliesTLdeserialize;
        int i;
        int i2;
        NativeByteBuffer nativeByteBufferByteBufferValue;
        LongSparseArray longSparseArray4 = longSparseArray3;
        try {
            this.database.beginTransaction();
            int i3 = 2;
            char c = 1;
            if (!isEmpty((LongSparseArray<?>) longSparseArray)) {
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("UPDATE messages_v2 SET media = max((SELECT media FROM messages_v2 WHERE mid = ? AND uid = ?), ?) WHERE mid = ? AND uid = ?");
                for (int i4 = 0; i4 < longSparseArray.size(); i4++) {
                    long jKeyAt = longSparseArray.keyAt(i4);
                    SparseIntArray sparseIntArray = (SparseIntArray) longSparseArray.valueAt(i4);
                    int size = sparseIntArray.size();
                    for (int i5 = 0; i5 < size; i5++) {
                        int iValueAt = sparseIntArray.valueAt(i5);
                        int iKeyAt = sparseIntArray.keyAt(i5);
                        sQLitePreparedStatementExecuteFast.requery();
                        sQLitePreparedStatementExecuteFast.bindInteger(1, iKeyAt);
                        sQLitePreparedStatementExecuteFast.bindLong(2, jKeyAt);
                        sQLitePreparedStatementExecuteFast.bindInteger(3, iValueAt);
                        sQLitePreparedStatementExecuteFast.bindInteger(4, iKeyAt);
                        sQLitePreparedStatementExecuteFast.bindLong(5, jKeyAt);
                        sQLitePreparedStatementExecuteFast.step();
                    }
                }
                sQLitePreparedStatementExecuteFast.dispose();
            }
            if (!isEmpty((LongSparseArray<?>) longSparseArray2)) {
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast2 = this.database.executeFast("UPDATE messages_v2 SET forwards = max((SELECT forwards FROM messages_v2 WHERE mid = ? AND uid = ?), ?) WHERE mid = ? AND uid = ?");
                for (int i6 = 0; i6 < longSparseArray2.size(); i6++) {
                    long jKeyAt2 = longSparseArray2.keyAt(i6);
                    SparseIntArray sparseIntArray2 = (SparseIntArray) longSparseArray2.valueAt(i6);
                    int size2 = sparseIntArray2.size();
                    for (int i7 = 0; i7 < size2; i7++) {
                        int iValueAt2 = sparseIntArray2.valueAt(i7);
                        int iKeyAt2 = sparseIntArray2.keyAt(i7);
                        sQLitePreparedStatementExecuteFast2.requery();
                        sQLitePreparedStatementExecuteFast2.bindInteger(1, iKeyAt2);
                        sQLitePreparedStatementExecuteFast2.bindLong(2, jKeyAt2);
                        sQLitePreparedStatementExecuteFast2.bindInteger(3, iValueAt2);
                        sQLitePreparedStatementExecuteFast2.bindInteger(4, iKeyAt2);
                        sQLitePreparedStatementExecuteFast2.bindLong(5, jKeyAt2);
                        sQLitePreparedStatementExecuteFast2.step();
                    }
                }
                sQLitePreparedStatementExecuteFast2.dispose();
            }
            if (!isEmpty((LongSparseArray<?>) longSparseArray3)) {
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast3 = this.database.executeFast("UPDATE messages_v2 SET replies_data = ? WHERE mid = ? AND uid = ?");
                int i8 = 0;
                while (i8 < longSparseArray3.size()) {
                    long jKeyAt3 = longSparseArray4.keyAt(i8);
                    SparseArray sparseArray = (SparseArray) longSparseArray4.valueAt(i8);
                    int size3 = sparseArray.size();
                    int i9 = 0;
                    while (i9 < size3) {
                        int iKeyAt3 = sparseArray.keyAt(i9);
                        SQLiteDatabase sQLiteDatabase = this.database;
                        Locale locale = Locale.US;
                        Object[] objArr = new Object[i3];
                        objArr[0] = Integer.valueOf(iKeyAt3);
                        objArr[c] = Long.valueOf(jKeyAt3);
                        SQLiteCursor sQLiteCursorQueryFinalized = sQLiteDatabase.queryFinalized(String.format(locale, "SELECT replies_data FROM messages_v2 WHERE mid = %d AND uid = %d", objArr), new Object[0]);
                        boolean next = sQLiteCursorQueryFinalized.next();
                        if (!next || (nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized.byteBufferValue(0)) == null) {
                            tLRPC$MessageRepliesTLdeserialize = null;
                        } else {
                            tLRPC$MessageRepliesTLdeserialize = TLRPC$MessageReplies.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                            nativeByteBufferByteBufferValue.reuse();
                        }
                        sQLiteCursorQueryFinalized.dispose();
                        if (next) {
                            TLRPC$MessageReplies tLRPC$MessageReplies = (TLRPC$MessageReplies) sparseArray.get(sparseArray.keyAt(i9));
                            if (z || tLRPC$MessageRepliesTLdeserialize == null || (i2 = tLRPC$MessageRepliesTLdeserialize.replies_pts) == 0 || tLRPC$MessageReplies.replies_pts > i2 || tLRPC$MessageReplies.read_max_id > tLRPC$MessageRepliesTLdeserialize.read_max_id || tLRPC$MessageReplies.max_id > tLRPC$MessageRepliesTLdeserialize.max_id) {
                                if (z) {
                                    if (tLRPC$MessageRepliesTLdeserialize == null) {
                                        TLRPC$TL_messageReplies tLRPC$TL_messageReplies = new TLRPC$TL_messageReplies();
                                        tLRPC$TL_messageReplies.flags |= 2;
                                        tLRPC$MessageRepliesTLdeserialize = tLRPC$TL_messageReplies;
                                    }
                                    tLRPC$MessageRepliesTLdeserialize.replies += tLRPC$MessageReplies.replies;
                                    int size4 = tLRPC$MessageReplies.recent_repliers.size();
                                    for (int i10 = 0; i10 < size4; i10++) {
                                        long peerId = MessageObject.getPeerId(tLRPC$MessageReplies.recent_repliers.get(i10));
                                        int size5 = tLRPC$MessageRepliesTLdeserialize.recent_repliers.size();
                                        int i11 = 0;
                                        while (i11 < size5) {
                                            if (peerId == MessageObject.getPeerId(tLRPC$MessageRepliesTLdeserialize.recent_repliers.get(i11))) {
                                                tLRPC$MessageRepliesTLdeserialize.recent_repliers.remove(i11);
                                                i11--;
                                                size5--;
                                            }
                                            i11++;
                                        }
                                    }
                                    tLRPC$MessageRepliesTLdeserialize.recent_repliers.addAll(0, tLRPC$MessageReplies.recent_repliers);
                                    while (tLRPC$MessageRepliesTLdeserialize.recent_repliers.size() > 3) {
                                        tLRPC$MessageRepliesTLdeserialize.recent_repliers.remove(0);
                                    }
                                    tLRPC$MessageReplies = tLRPC$MessageRepliesTLdeserialize;
                                }
                                if (tLRPC$MessageRepliesTLdeserialize != null && (i = tLRPC$MessageRepliesTLdeserialize.read_max_id) > tLRPC$MessageReplies.read_max_id) {
                                    tLRPC$MessageReplies.read_max_id = i;
                                }
                                sQLitePreparedStatementExecuteFast3.requery();
                                NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(tLRPC$MessageReplies.getObjectSize());
                                tLRPC$MessageReplies.serializeToStream(nativeByteBuffer);
                                sQLitePreparedStatementExecuteFast3.bindByteBuffer(1, nativeByteBuffer);
                                sQLitePreparedStatementExecuteFast3.bindInteger(2, iKeyAt3);
                                sQLitePreparedStatementExecuteFast3.bindLong(3, jKeyAt3);
                                sQLitePreparedStatementExecuteFast3.step();
                                nativeByteBuffer.reuse();
                            }
                        }
                        i9++;
                        i3 = 2;
                        c = 1;
                    }
                    i8++;
                    longSparseArray4 = longSparseArray3;
                    i3 = 2;
                    c = 1;
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
    public void lambda$updateRepliesMaxReadId$147$MessagesStorage(long chatId, int mid, int readMaxId) {
        NativeByteBuffer nativeByteBufferByteBufferValue;
        long j = -chatId;
        try {
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("UPDATE messages_v2 SET replies_data = ? WHERE mid = ? AND uid = ?");
            TLRPC$MessageReplies tLRPC$MessageRepliesTLdeserialize = null;
            SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT replies_data FROM messages_v2 WHERE mid = %d AND uid = %d", Integer.valueOf(mid), Long.valueOf(j)), new Object[0]);
            if (sQLiteCursorQueryFinalized.next() && (nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized.byteBufferValue(0)) != null) {
                tLRPC$MessageRepliesTLdeserialize = TLRPC$MessageReplies.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                nativeByteBufferByteBufferValue.reuse();
            }
            sQLiteCursorQueryFinalized.dispose();
            if (tLRPC$MessageRepliesTLdeserialize != null) {
                tLRPC$MessageRepliesTLdeserialize.read_max_id = readMaxId;
                sQLitePreparedStatementExecuteFast.requery();
                NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(tLRPC$MessageRepliesTLdeserialize.getObjectSize());
                tLRPC$MessageRepliesTLdeserialize.serializeToStream(nativeByteBuffer);
                sQLitePreparedStatementExecuteFast.bindByteBuffer(1, nativeByteBuffer);
                sQLitePreparedStatementExecuteFast.bindInteger(2, mid);
                sQLitePreparedStatementExecuteFast.bindLong(3, j);
                sQLitePreparedStatementExecuteFast.step();
                nativeByteBuffer.reuse();
            }
            sQLitePreparedStatementExecuteFast.dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void updateRepliesMaxReadId(final long chatId, final int mid, final int readMaxId, boolean useQueue) {
        if (useQueue) {
            this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$j-KFjgk503OZ7Y9OycfCvrX06vg
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$updateRepliesMaxReadId$147$MessagesStorage(chatId, mid, readMaxId);
                }
            });
        } else {
            lambda$updateRepliesMaxReadId$147(chatId, mid, readMaxId);
        }
    }

    public void updateRepliesCount(final long chatId, final int mid, final ArrayList<TLRPC$Peer> repliers, final int maxId, final int count) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$UtobHVCvXU7Dwgj38dqfyKKAMiU
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateRepliesCount$148$MessagesStorage(mid, chatId, count, repliers, maxId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateRepliesCount$148, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateRepliesCount$148$MessagesStorage(int i, long j, int i2, ArrayList arrayList, int i3) {
        NativeByteBuffer nativeByteBufferByteBufferValue;
        try {
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("UPDATE messages_v2 SET replies_data = ? WHERE mid = ? AND uid = ?");
            TLRPC$MessageReplies tLRPC$MessageRepliesTLdeserialize = null;
            long j2 = -j;
            SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format("SELECT replies_data FROM messages_v2 WHERE mid = %d AND uid = %d", Integer.valueOf(i), Long.valueOf(j2)), new Object[0]);
            if (sQLiteCursorQueryFinalized.next() && (nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized.byteBufferValue(0)) != null) {
                tLRPC$MessageRepliesTLdeserialize = TLRPC$MessageReplies.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                nativeByteBufferByteBufferValue.reuse();
            }
            sQLiteCursorQueryFinalized.dispose();
            if (tLRPC$MessageRepliesTLdeserialize != null) {
                int i4 = tLRPC$MessageRepliesTLdeserialize.replies + i2;
                tLRPC$MessageRepliesTLdeserialize.replies = i4;
                if (i4 < 0) {
                    tLRPC$MessageRepliesTLdeserialize.replies = 0;
                }
                if (arrayList != null) {
                    tLRPC$MessageRepliesTLdeserialize.recent_repliers = arrayList;
                    tLRPC$MessageRepliesTLdeserialize.flags |= 2;
                }
                if (i3 != 0) {
                    tLRPC$MessageRepliesTLdeserialize.max_id = i3;
                }
                sQLitePreparedStatementExecuteFast.requery();
                NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(tLRPC$MessageRepliesTLdeserialize.getObjectSize());
                tLRPC$MessageRepliesTLdeserialize.serializeToStream(nativeByteBuffer);
                sQLitePreparedStatementExecuteFast.bindByteBuffer(1, nativeByteBuffer);
                sQLitePreparedStatementExecuteFast.bindInteger(2, i);
                sQLitePreparedStatementExecuteFast.bindLong(3, j2);
                sQLitePreparedStatementExecuteFast.step();
                nativeByteBuffer.reuse();
            }
            sQLitePreparedStatementExecuteFast.dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    private boolean isValidKeyboardToSave(TLRPC$Message message) {
        TLRPC$ReplyMarkup tLRPC$ReplyMarkup = message.reply_markup;
        return (tLRPC$ReplyMarkup == null || (tLRPC$ReplyMarkup instanceof TLRPC$TL_replyInlineMarkup) || (tLRPC$ReplyMarkup.selective && !message.mentioned)) ? false : true;
    }

    public void updateMessageVerifyFlags(final ArrayList<TLRPC$Message> messages) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$eL8p_MWwkIUBLRN-zY_NrryBfUw
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateMessageVerifyFlags$149$MessagesStorage(messages);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateMessageVerifyFlags$149, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateMessageVerifyFlags$149$MessagesStorage(ArrayList arrayList) {
        try {
            this.database.beginTransaction();
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("UPDATE messages_v2 SET imp = ? WHERE mid = ? AND uid = ?");
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                TLRPC$Message tLRPC$Message = (TLRPC$Message) arrayList.get(i);
                sQLitePreparedStatementExecuteFast.requery();
                int i2 = tLRPC$Message.stickerVerified;
                sQLitePreparedStatementExecuteFast.bindInteger(1, i2 == 0 ? 1 : i2 == 2 ? 2 : 0);
                sQLitePreparedStatementExecuteFast.bindInteger(2, tLRPC$Message.id);
                sQLitePreparedStatementExecuteFast.bindLong(3, MessageObject.getDialogId(tLRPC$Message));
                sQLitePreparedStatementExecuteFast.step();
            }
            sQLitePreparedStatementExecuteFast.dispose();
            this.database.commitTransaction();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0549 A[Catch: Exception -> 0x010d, TryCatch #1 {Exception -> 0x010d, blocks: (B:5:0x000d, B:6:0x0012, B:7:0x0026, B:9:0x002c, B:21:0x00a4, B:12:0x0037, B:15:0x0044, B:17:0x007a, B:18:0x0090, B:20:0x009d, B:22:0x00ab, B:24:0x00b3, B:25:0x00b8, B:27:0x00bf, B:29:0x00cd, B:31:0x00dc, B:32:0x00df, B:34:0x0101, B:36:0x0107, B:42:0x0113, B:43:0x0118, B:44:0x017b, B:46:0x0181, B:48:0x0192, B:50:0x0196, B:52:0x01a2, B:54:0x01b3, B:56:0x01c0, B:59:0x01c8, B:61:0x01ce, B:63:0x01d2, B:65:0x01d6, B:67:0x01dc, B:69:0x01e8, B:71:0x020d, B:73:0x0213, B:75:0x0220, B:89:0x0267, B:92:0x026f, B:94:0x028a, B:96:0x0294, B:97:0x029e, B:99:0x02a4, B:100:0x02a7, B:102:0x02b4, B:103:0x02be, B:105:0x02cf, B:106:0x02d9, B:108:0x02e8, B:110:0x02ee, B:112:0x02f8, B:114:0x02fe, B:115:0x0303, B:78:0x0226, B:80:0x0230, B:81:0x023a, B:83:0x0240, B:84:0x0243, B:86:0x0250, B:87:0x025a, B:117:0x031f, B:119:0x0325, B:121:0x033b, B:123:0x0344, B:124:0x0394, B:126:0x039a, B:128:0x03a9, B:131:0x03b5, B:132:0x03ba, B:134:0x03c2, B:135:0x03ca, B:137:0x03cf, B:139:0x03d4, B:140:0x03da, B:142:0x03e1, B:144:0x03fb, B:148:0x0416, B:150:0x041d, B:152:0x0424, B:154:0x042c, B:159:0x0444, B:155:0x0438, B:160:0x0448, B:145:0x0409, B:161:0x044f, B:163:0x045c, B:165:0x0462, B:167:0x0469, B:168:0x04aa, B:170:0x04b0, B:172:0x04ba, B:174:0x04bf, B:176:0x04c4, B:179:0x04d1, B:181:0x04db, B:184:0x04e5, B:186:0x04f0, B:188:0x0506, B:190:0x050c, B:193:0x0523, B:195:0x0535, B:197:0x053b, B:205:0x058f, B:207:0x059b, B:209:0x05a1, B:211:0x05a5, B:214:0x05ab, B:218:0x05b7, B:220:0x05e1, B:225:0x05e9, B:227:0x05fa, B:229:0x060b, B:237:0x061a, B:241:0x0624, B:243:0x0634, B:245:0x0650, B:247:0x0654, B:251:0x065b, B:253:0x0667, B:255:0x067d, B:257:0x069c, B:260:0x06a4, B:261:0x06ac, B:262:0x06ce, B:264:0x06d2, B:267:0x06d8, B:268:0x06e0, B:269:0x0708, B:272:0x0710, B:274:0x071a, B:281:0x0767, B:282:0x076a, B:284:0x076f, B:286:0x0779, B:288:0x077d, B:290:0x078b, B:292:0x0796, B:294:0x079c, B:296:0x07a0, B:298:0x07a4, B:300:0x07b2, B:329:0x0866, B:331:0x086c, B:332:0x0876, B:334:0x08ab, B:336:0x08b0, B:340:0x08d6, B:303:0x07cc, B:305:0x07d2, B:308:0x07da, B:310:0x07e0, B:312:0x07e6, B:316:0x07ef, B:318:0x0803, B:320:0x080f, B:322:0x0824, B:326:0x083c, B:327:0x0850, B:275:0x073d, B:277:0x0741, B:250:0x0659, B:252:0x0661, B:244:0x064a, B:228:0x0602, B:216:0x05af, B:200:0x0549, B:202:0x054d, B:341:0x08ed, B:343:0x0903, B:345:0x0908, B:347:0x0917, B:348:0x091a, B:349:0x0939, B:351:0x093f, B:405:0x0ab7, B:354:0x095d, B:356:0x0987, B:361:0x09c2, B:404:0x0ab0, B:359:0x09b5, B:408:0x0ac3, B:410:0x0acd, B:412:0x0adc, B:414:0x0aef, B:416:0x0b25, B:418:0x0b31, B:420:0x0b37, B:422:0x0b5c, B:423:0x0b65, B:424:0x0b74, B:426:0x0b79, B:427:0x0b7e, B:429:0x0b91, B:430:0x0b9b), top: B:436:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:329:0x0866 A[Catch: Exception -> 0x010d, TryCatch #1 {Exception -> 0x010d, blocks: (B:5:0x000d, B:6:0x0012, B:7:0x0026, B:9:0x002c, B:21:0x00a4, B:12:0x0037, B:15:0x0044, B:17:0x007a, B:18:0x0090, B:20:0x009d, B:22:0x00ab, B:24:0x00b3, B:25:0x00b8, B:27:0x00bf, B:29:0x00cd, B:31:0x00dc, B:32:0x00df, B:34:0x0101, B:36:0x0107, B:42:0x0113, B:43:0x0118, B:44:0x017b, B:46:0x0181, B:48:0x0192, B:50:0x0196, B:52:0x01a2, B:54:0x01b3, B:56:0x01c0, B:59:0x01c8, B:61:0x01ce, B:63:0x01d2, B:65:0x01d6, B:67:0x01dc, B:69:0x01e8, B:71:0x020d, B:73:0x0213, B:75:0x0220, B:89:0x0267, B:92:0x026f, B:94:0x028a, B:96:0x0294, B:97:0x029e, B:99:0x02a4, B:100:0x02a7, B:102:0x02b4, B:103:0x02be, B:105:0x02cf, B:106:0x02d9, B:108:0x02e8, B:110:0x02ee, B:112:0x02f8, B:114:0x02fe, B:115:0x0303, B:78:0x0226, B:80:0x0230, B:81:0x023a, B:83:0x0240, B:84:0x0243, B:86:0x0250, B:87:0x025a, B:117:0x031f, B:119:0x0325, B:121:0x033b, B:123:0x0344, B:124:0x0394, B:126:0x039a, B:128:0x03a9, B:131:0x03b5, B:132:0x03ba, B:134:0x03c2, B:135:0x03ca, B:137:0x03cf, B:139:0x03d4, B:140:0x03da, B:142:0x03e1, B:144:0x03fb, B:148:0x0416, B:150:0x041d, B:152:0x0424, B:154:0x042c, B:159:0x0444, B:155:0x0438, B:160:0x0448, B:145:0x0409, B:161:0x044f, B:163:0x045c, B:165:0x0462, B:167:0x0469, B:168:0x04aa, B:170:0x04b0, B:172:0x04ba, B:174:0x04bf, B:176:0x04c4, B:179:0x04d1, B:181:0x04db, B:184:0x04e5, B:186:0x04f0, B:188:0x0506, B:190:0x050c, B:193:0x0523, B:195:0x0535, B:197:0x053b, B:205:0x058f, B:207:0x059b, B:209:0x05a1, B:211:0x05a5, B:214:0x05ab, B:218:0x05b7, B:220:0x05e1, B:225:0x05e9, B:227:0x05fa, B:229:0x060b, B:237:0x061a, B:241:0x0624, B:243:0x0634, B:245:0x0650, B:247:0x0654, B:251:0x065b, B:253:0x0667, B:255:0x067d, B:257:0x069c, B:260:0x06a4, B:261:0x06ac, B:262:0x06ce, B:264:0x06d2, B:267:0x06d8, B:268:0x06e0, B:269:0x0708, B:272:0x0710, B:274:0x071a, B:281:0x0767, B:282:0x076a, B:284:0x076f, B:286:0x0779, B:288:0x077d, B:290:0x078b, B:292:0x0796, B:294:0x079c, B:296:0x07a0, B:298:0x07a4, B:300:0x07b2, B:329:0x0866, B:331:0x086c, B:332:0x0876, B:334:0x08ab, B:336:0x08b0, B:340:0x08d6, B:303:0x07cc, B:305:0x07d2, B:308:0x07da, B:310:0x07e0, B:312:0x07e6, B:316:0x07ef, B:318:0x0803, B:320:0x080f, B:322:0x0824, B:326:0x083c, B:327:0x0850, B:275:0x073d, B:277:0x0741, B:250:0x0659, B:252:0x0661, B:244:0x064a, B:228:0x0602, B:216:0x05af, B:200:0x0549, B:202:0x054d, B:341:0x08ed, B:343:0x0903, B:345:0x0908, B:347:0x0917, B:348:0x091a, B:349:0x0939, B:351:0x093f, B:405:0x0ab7, B:354:0x095d, B:356:0x0987, B:361:0x09c2, B:404:0x0ab0, B:359:0x09b5, B:408:0x0ac3, B:410:0x0acd, B:412:0x0adc, B:414:0x0aef, B:416:0x0b25, B:418:0x0b31, B:420:0x0b37, B:422:0x0b5c, B:423:0x0b65, B:424:0x0b74, B:426:0x0b79, B:427:0x0b7e, B:429:0x0b91, B:430:0x0b9b), top: B:436:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:337:0x08d0  */
    /* JADX WARN: Removed duplicated region for block: B:338:0x08d2  */
    /* renamed from: putMessagesInternal, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void lambda$putMessages$151$MessagesStorage(java.util.ArrayList<ir.eitaa.tgnet.TLRPC$Message> r42, boolean r43, boolean r44, int r45, boolean r46, boolean r47) {
        /*
            Method dump skipped, instructions count: 2979
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessagesStorage.lambda$putMessages$151(java.util.ArrayList, boolean, boolean, int, boolean, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$putMessagesInternal$150, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$putMessagesInternal$150$MessagesStorage(int i) {
        getDownloadController().newDownloadObjectsAvailable(i);
    }

    public void putMessages(ArrayList<TLRPC$Message> messages, boolean withTransaction, boolean useQueue, boolean doNotUpdateDialogDate, int downloadMask, boolean scheduled) {
        putMessages(messages, withTransaction, useQueue, doNotUpdateDialogDate, downloadMask, false, scheduled);
    }

    public void putMessages(final ArrayList<TLRPC$Message> messages, final boolean withTransaction, boolean useQueue, final boolean doNotUpdateDialogDate, final int downloadMask, final boolean ifNoLastMessage, final boolean scheduled) {
        if (messages.size() == 0) {
            return;
        }
        if (useQueue) {
            this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$m3viBMlYi4dZHXy1VJq7nt2SjOc
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$putMessages$151$MessagesStorage(messages, withTransaction, doNotUpdateDialogDate, downloadMask, ifNoLastMessage, scheduled);
                }
            });
        } else {
            lambda$putMessages$151(messages, withTransaction, doNotUpdateDialogDate, downloadMask, ifNoLastMessage, scheduled);
        }
    }

    public void markMessageAsSendError(final TLRPC$Message message, final boolean scheduled) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$6uzwP1bOlGHnendkqAzYCbyz-L4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$markMessageAsSendError$152$MessagesStorage(message, scheduled);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$markMessageAsSendError$152, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$markMessageAsSendError$152$MessagesStorage(TLRPC$Message tLRPC$Message, boolean z) {
        try {
            long j = tLRPC$Message.id;
            if (z) {
                this.database.executeFast(String.format(Locale.US, "UPDATE scheduled_messages_v2 SET send_state = 2 WHERE mid = %d AND uid = %d", Long.valueOf(j), Long.valueOf(MessageObject.getDialogId(tLRPC$Message)))).stepThis().dispose();
            } else {
                this.database.executeFast(String.format(Locale.US, "UPDATE messages_v2 SET send_state = 2 WHERE mid = %d AND uid = %d", Long.valueOf(j), Long.valueOf(MessageObject.getDialogId(tLRPC$Message)))).stepThis().dispose();
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void setMessageSeq(final int mid, final int seq_in, final int seq_out) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$rl1qpUhfs1gkH2EoKGYBmOaqIDk
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setMessageSeq$153$MessagesStorage(mid, seq_in, seq_out);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setMessageSeq$153, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setMessageSeq$153$MessagesStorage(int i, int i2, int i3) {
        try {
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("REPLACE INTO messages_seq VALUES(?, ?, ?)");
            sQLitePreparedStatementExecuteFast.requery();
            sQLitePreparedStatementExecuteFast.bindInteger(1, i);
            sQLitePreparedStatementExecuteFast.bindInteger(2, i2);
            sQLitePreparedStatementExecuteFast.bindInteger(3, i3);
            sQLitePreparedStatementExecuteFast.step();
            sQLitePreparedStatementExecuteFast.dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01a9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02a1 A[PHI: r3
      0x02a1: PHI (r3v11 ir.eitaa.SQLite.SQLitePreparedStatement) = (r3v7 ir.eitaa.SQLite.SQLitePreparedStatement), (r3v12 ir.eitaa.SQLite.SQLitePreparedStatement) binds: [B:150:0x029f, B:142:0x025b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x031e A[PHI: r5
      0x031e: PHI (r5v17 ir.eitaa.SQLite.SQLitePreparedStatement) = (r5v15 ir.eitaa.SQLite.SQLitePreparedStatement), (r5v18 ir.eitaa.SQLite.SQLitePreparedStatement) binds: [B:178:0x031c, B:170:0x02d8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:231:0x012a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0058 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0122 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0149 A[Catch: Exception -> 0x0156, all -> 0x033b, TRY_LEAVE, TryCatch #10 {all -> 0x033b, blocks: (B:75:0x0143, B:77:0x0149, B:87:0x0160), top: B:209:0x0143 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x018f A[Catch: all -> 0x0197, Exception -> 0x019a, TRY_LEAVE, TryCatch #8 {Exception -> 0x019a, blocks: (B:95:0x0170, B:97:0x018f), top: B:205:0x0170, outer: #27 }] */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10, types: [ir.eitaa.SQLite.SQLitePreparedStatement] */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r10v6, types: [long] */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* renamed from: updateMessageStateAndIdInternal, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long[] lambda$updateMessageStateAndId$155$MessagesStorage(long r20, long r22, java.lang.Integer r24, int r25, int r26, int r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 836
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessagesStorage.lambda$updateMessageStateAndId$155(long, long, java.lang.Integer, int, int, int):long[]");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateMessageStateAndIdInternal$154, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateMessageStateAndIdInternal$154$MessagesStorage(TLRPC$TL_updates tLRPC$TL_updates) {
        getMessagesController().processUpdates(tLRPC$TL_updates, false);
    }

    public long[] updateMessageStateAndId(final long random_id, final long dialogId, final Integer _oldId, final int newId, final int date, boolean useQueue, final int scheduled) {
        if (useQueue) {
            this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$S4GidMAyWH8JjcOvsu3l_qVVyVE
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    this.f$0.lambda$updateMessageStateAndId$155$MessagesStorage(random_id, dialogId, _oldId, newId, date, scheduled);
                }
            });
            return null;
        }
        return lambda$updateMessageStateAndId$155(random_id, dialogId, _oldId, newId, date, scheduled);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateUsersInternal, reason: merged with bridge method [inline-methods] */
    public void lambda$updateUsers$156$MessagesStorage(ArrayList<TLRPC$User> users, boolean onlyStatus, boolean withTransaction) {
        try {
            if (onlyStatus) {
                if (withTransaction) {
                    this.database.beginTransaction();
                }
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("UPDATE users SET status = ? WHERE uid = ?");
                int size = users.size();
                for (int i = 0; i < size; i++) {
                    TLRPC$User tLRPC$User = users.get(i);
                    sQLitePreparedStatementExecuteFast.requery();
                    TLRPC$UserStatus tLRPC$UserStatus = tLRPC$User.status;
                    if (tLRPC$UserStatus != null) {
                        sQLitePreparedStatementExecuteFast.bindInteger(1, tLRPC$UserStatus.expires);
                    } else {
                        sQLitePreparedStatementExecuteFast.bindInteger(1, 0);
                    }
                    sQLitePreparedStatementExecuteFast.bindLong(2, tLRPC$User.id);
                    sQLitePreparedStatementExecuteFast.step();
                }
                sQLitePreparedStatementExecuteFast.dispose();
                if (withTransaction) {
                    this.database.commitTransaction();
                    return;
                }
                return;
            }
            StringBuilder sb = new StringBuilder();
            LongSparseArray longSparseArray = new LongSparseArray();
            int size2 = users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                TLRPC$User tLRPC$User2 = users.get(i2);
                if (sb.length() != 0) {
                    sb.append(",");
                }
                sb.append(tLRPC$User2.id);
                longSparseArray.put(tLRPC$User2.id, tLRPC$User2);
            }
            ArrayList<TLRPC$User> arrayList = new ArrayList<>();
            getUsersInternal(sb.toString(), arrayList);
            int size3 = arrayList.size();
            for (int i3 = 0; i3 < size3; i3++) {
                TLRPC$User tLRPC$User3 = arrayList.get(i3);
                TLRPC$User tLRPC$User4 = (TLRPC$User) longSparseArray.get(tLRPC$User3.id);
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
            if (arrayList.isEmpty()) {
                return;
            }
            if (withTransaction) {
                this.database.beginTransaction();
            }
            putUsersInternal(arrayList);
            if (withTransaction) {
                this.database.commitTransaction();
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void updateUsers(final ArrayList<TLRPC$User> users, final boolean onlyStatus, final boolean withTransaction, boolean useQueue) {
        if (users == null || users.isEmpty()) {
            return;
        }
        if (useQueue) {
            this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$MPYFpLe_dINbIEYQOV1UGHVD7fI
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$updateUsers$156$MessagesStorage(users, onlyStatus, withTransaction);
                }
            });
        } else {
            lambda$updateUsers$156(users, onlyStatus, withTransaction);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: markMessagesAsReadInternal, reason: merged with bridge method [inline-methods] */
    public void lambda$markMessagesAsRead$158$MessagesStorage(LongSparseIntArray inbox, LongSparseIntArray outbox, SparseIntArray encryptedMessages) {
        try {
            if (!isEmpty(inbox)) {
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("DELETE FROM unread_push_messages WHERE uid = ? AND mid <= ?");
                for (int i = 0; i < inbox.size(); i++) {
                    long jKeyAt = inbox.keyAt(i);
                    int i2 = inbox.get(jKeyAt);
                    this.database.executeFast(String.format(Locale.US, "UPDATE messages_v2 SET read_state = read_state | 1 WHERE uid = %d AND mid > 0 AND mid <= %d AND read_state IN(0,2) AND out = 0", Long.valueOf(jKeyAt), Integer.valueOf(i2))).stepThis().dispose();
                    sQLitePreparedStatementExecuteFast.requery();
                    sQLitePreparedStatementExecuteFast.bindLong(1, jKeyAt);
                    sQLitePreparedStatementExecuteFast.bindInteger(2, i2);
                    sQLitePreparedStatementExecuteFast.step();
                }
                sQLitePreparedStatementExecuteFast.dispose();
            }
            if (!isEmpty(outbox)) {
                for (int i3 = 0; i3 < outbox.size(); i3++) {
                    long jKeyAt2 = outbox.keyAt(i3);
                    this.database.executeFast(String.format(Locale.US, "UPDATE messages_v2 SET read_state = read_state | 1 WHERE uid = %d AND mid > 0 AND mid <= %d AND read_state IN(0,2) AND out = 1", Long.valueOf(jKeyAt2), Integer.valueOf(outbox.get(jKeyAt2)))).stepThis().dispose();
                }
            }
            if (encryptedMessages == null || isEmpty(encryptedMessages)) {
                return;
            }
            for (int i4 = 0; i4 < encryptedMessages.size(); i4++) {
                long jMakeEncryptedDialogId = DialogObject.makeEncryptedDialogId(encryptedMessages.keyAt(i4));
                int iValueAt = encryptedMessages.valueAt(i4);
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast2 = this.database.executeFast("UPDATE messages_v2 SET read_state = read_state | 1 WHERE uid = ? AND date <= ? AND read_state IN(0,2) AND out = 1");
                sQLitePreparedStatementExecuteFast2.requery();
                sQLitePreparedStatementExecuteFast2.bindLong(1, jMakeEncryptedDialogId);
                sQLitePreparedStatementExecuteFast2.bindInteger(2, iValueAt);
                sQLitePreparedStatementExecuteFast2.step();
                sQLitePreparedStatementExecuteFast2.dispose();
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    private void markMessagesContentAsReadInternal(long dialogId, ArrayList<Integer> mids, int date) {
        try {
            String strJoin = TextUtils.join(",", mids);
            SQLiteDatabase sQLiteDatabase = this.database;
            Locale locale = Locale.US;
            sQLiteDatabase.executeFast(String.format(locale, "UPDATE messages_v2 SET read_state = read_state | 2 WHERE mid IN (%s) AND uid = %d", strJoin, Long.valueOf(dialogId))).stepThis().dispose();
            if (date != 0) {
                SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(locale, "SELECT mid, ttl FROM messages_v2 WHERE mid IN (%s) AND uid = %d AND ttl > 0", strJoin, Long.valueOf(dialogId)), new Object[0]);
                ArrayList<Integer> arrayList = null;
                while (sQLiteCursorQueryFinalized.next()) {
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    }
                    arrayList.add(Integer.valueOf(sQLiteCursorQueryFinalized.intValue(0)));
                }
                if (arrayList != null) {
                    emptyMessagesMedia(dialogId, arrayList);
                }
                sQLiteCursorQueryFinalized.dispose();
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void markMessagesContentAsRead(final long dialogId, final ArrayList<Integer> mids, final int date) {
        if (isEmpty(mids)) {
            return;
        }
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$IedesBrDE4Vu8XAJzSuXFofbeac
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$markMessagesContentAsRead$157$MessagesStorage(dialogId, mids, date);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$markMessagesContentAsRead$157, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$markMessagesContentAsRead$157$MessagesStorage(long j, ArrayList arrayList, int i) {
        if (j == 0) {
            try {
                LongSparseArray longSparseArray = new LongSparseArray();
                SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT uid, mid FROM messages_v2 WHERE mid IN (%s) AND is_channel = 0", TextUtils.join(",", arrayList)), new Object[0]);
                while (sQLiteCursorQueryFinalized.next()) {
                    long jLongValue = sQLiteCursorQueryFinalized.longValue(0);
                    ArrayList arrayList2 = (ArrayList) longSparseArray.get(jLongValue);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                        longSparseArray.put(jLongValue, arrayList2);
                    }
                    arrayList2.add(Integer.valueOf(sQLiteCursorQueryFinalized.intValue(1)));
                }
                sQLiteCursorQueryFinalized.dispose();
                int size = longSparseArray.size();
                for (int i2 = 0; i2 < size; i2++) {
                    markMessagesContentAsReadInternal(longSparseArray.keyAt(i2), (ArrayList) longSparseArray.valueAt(i2), i);
                }
                return;
            } catch (Exception e) {
                FileLog.e(e);
                return;
            }
        }
        markMessagesContentAsReadInternal(j, arrayList, i);
    }

    public void markMessagesAsRead(final LongSparseIntArray inbox, final LongSparseIntArray outbox, final SparseIntArray encryptedMessages, boolean useQueue) {
        if (useQueue) {
            this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$B2ltroiM-aWCq33Xieox7Gn1T_g
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$markMessagesAsRead$158$MessagesStorage(inbox, outbox, encryptedMessages);
                }
            });
        } else {
            lambda$markMessagesAsRead$158(inbox, outbox, encryptedMessages);
        }
    }

    public void markMessagesAsDeletedByRandoms(final ArrayList<Long> messages) {
        if (messages.isEmpty()) {
            return;
        }
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$mIatn8xU_-LVCHwtc19YbUqwXJQ
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$markMessagesAsDeletedByRandoms$160$MessagesStorage(messages);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$markMessagesAsDeletedByRandoms$160, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$markMessagesAsDeletedByRandoms$160$MessagesStorage(ArrayList arrayList) {
        try {
            SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT mid, uid FROM randoms_v2 WHERE random_id IN(%s)", TextUtils.join(",", arrayList)), new Object[0]);
            LongSparseArray longSparseArray = new LongSparseArray();
            while (sQLiteCursorQueryFinalized.next()) {
                long jLongValue = sQLiteCursorQueryFinalized.longValue(1);
                ArrayList arrayList2 = (ArrayList) longSparseArray.get(jLongValue);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    longSparseArray.put(jLongValue, arrayList2);
                }
                arrayList2.add(Integer.valueOf(sQLiteCursorQueryFinalized.intValue(0)));
            }
            sQLiteCursorQueryFinalized.dispose();
            if (longSparseArray.isEmpty()) {
                return;
            }
            int size = longSparseArray.size();
            for (int i = 0; i < size; i++) {
                long jKeyAt = longSparseArray.keyAt(i);
                final ArrayList<Integer> arrayList3 = (ArrayList) longSparseArray.valueAt(i);
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$fwBChRgEmuJbZFP2a9sSGkIX948
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$markMessagesAsDeletedByRandoms$159$MessagesStorage(arrayList3);
                    }
                });
                updateDialogsWithReadMessagesInternal(arrayList3, null, null, null);
                lambda$markMessagesAsDeleted$164(jKeyAt, arrayList3, true, false);
                lambda$updateDialogsWithDeletedMessages$163(jKeyAt, 0L, arrayList3, null);
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$markMessagesAsDeletedByRandoms$159, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$markMessagesAsDeletedByRandoms$159$MessagesStorage(ArrayList arrayList) {
        getNotificationCenter().postNotificationName(NotificationCenter.messagesDeleted, arrayList, 0L, Boolean.FALSE);
    }

    protected void deletePushMessages(long dialogId, ArrayList<Integer> messages) {
        try {
            this.database.executeFast(String.format(Locale.US, "DELETE FROM unread_push_messages WHERE uid = %d AND mid IN(%s)", Long.valueOf(dialogId), TextUtils.join(",", messages))).stepThis().dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    private void broadcastScheduledMessagesChange(final Long did) {
        try {
            SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT COUNT(mid) FROM scheduled_messages_v2 WHERE uid = %d", did), new Object[0]);
            final int iIntValue = sQLiteCursorQueryFinalized.next() ? sQLiteCursorQueryFinalized.intValue(0) : 0;
            sQLiteCursorQueryFinalized.dispose();
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$V2J9uMvIN797LWfHCQ9Un3_pGlQ
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$broadcastScheduledMessagesChange$161$MessagesStorage(did, iIntValue);
                }
            });
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$broadcastScheduledMessagesChange$161, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$broadcastScheduledMessagesChange$161$MessagesStorage(Long l, int i) {
        getNotificationCenter().postNotificationName(NotificationCenter.scheduledMessagesUpdated, l, Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:123:0x051c  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0581  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x05c5 A[Catch: Exception -> 0x05cf, TryCatch #1 {Exception -> 0x05cf, blocks: (B:3:0x0004, B:6:0x0010, B:15:0x0053, B:17:0x007b, B:14:0x0050, B:19:0x008a, B:21:0x00bc, B:62:0x01da, B:63:0x01dd, B:64:0x01f5, B:66:0x01fb, B:68:0x0227, B:70:0x0233, B:71:0x027a, B:73:0x0285, B:75:0x029c, B:77:0x02a2, B:80:0x02f3, B:82:0x0327, B:84:0x032d, B:86:0x0332, B:88:0x0352, B:89:0x0375, B:91:0x037b, B:93:0x03e1, B:94:0x03fd, B:96:0x0403, B:98:0x040e, B:99:0x0413, B:101:0x041b, B:104:0x0433, B:105:0x0438, B:102:0x0429, B:106:0x0447, B:108:0x044c, B:110:0x045b, B:112:0x046e, B:114:0x04a9, B:116:0x04b5, B:118:0x04ba, B:120:0x04e2, B:121:0x04f6, B:122:0x050d, B:124:0x0527, B:78:0x02cb, B:125:0x055a, B:129:0x0587, B:130:0x0597, B:131:0x05b4, B:133:0x05c5, B:134:0x05c9, B:22:0x00d7, B:7:0x0033, B:9:0x0039, B:11:0x0047), top: B:141:0x0004, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01fb A[Catch: Exception -> 0x05cf, TryCatch #1 {Exception -> 0x05cf, blocks: (B:3:0x0004, B:6:0x0010, B:15:0x0053, B:17:0x007b, B:14:0x0050, B:19:0x008a, B:21:0x00bc, B:62:0x01da, B:63:0x01dd, B:64:0x01f5, B:66:0x01fb, B:68:0x0227, B:70:0x0233, B:71:0x027a, B:73:0x0285, B:75:0x029c, B:77:0x02a2, B:80:0x02f3, B:82:0x0327, B:84:0x032d, B:86:0x0332, B:88:0x0352, B:89:0x0375, B:91:0x037b, B:93:0x03e1, B:94:0x03fd, B:96:0x0403, B:98:0x040e, B:99:0x0413, B:101:0x041b, B:104:0x0433, B:105:0x0438, B:102:0x0429, B:106:0x0447, B:108:0x044c, B:110:0x045b, B:112:0x046e, B:114:0x04a9, B:116:0x04b5, B:118:0x04ba, B:120:0x04e2, B:121:0x04f6, B:122:0x050d, B:124:0x0527, B:78:0x02cb, B:125:0x055a, B:129:0x0587, B:130:0x0597, B:131:0x05b4, B:133:0x05c5, B:134:0x05c9, B:22:0x00d7, B:7:0x0033, B:9:0x0039, B:11:0x0047), top: B:141:0x0004, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0285 A[Catch: Exception -> 0x05cf, TryCatch #1 {Exception -> 0x05cf, blocks: (B:3:0x0004, B:6:0x0010, B:15:0x0053, B:17:0x007b, B:14:0x0050, B:19:0x008a, B:21:0x00bc, B:62:0x01da, B:63:0x01dd, B:64:0x01f5, B:66:0x01fb, B:68:0x0227, B:70:0x0233, B:71:0x027a, B:73:0x0285, B:75:0x029c, B:77:0x02a2, B:80:0x02f3, B:82:0x0327, B:84:0x032d, B:86:0x0332, B:88:0x0352, B:89:0x0375, B:91:0x037b, B:93:0x03e1, B:94:0x03fd, B:96:0x0403, B:98:0x040e, B:99:0x0413, B:101:0x041b, B:104:0x0433, B:105:0x0438, B:102:0x0429, B:106:0x0447, B:108:0x044c, B:110:0x045b, B:112:0x046e, B:114:0x04a9, B:116:0x04b5, B:118:0x04ba, B:120:0x04e2, B:121:0x04f6, B:122:0x050d, B:124:0x0527, B:78:0x02cb, B:125:0x055a, B:129:0x0587, B:130:0x0597, B:131:0x05b4, B:133:0x05c5, B:134:0x05c9, B:22:0x00d7, B:7:0x0033, B:9:0x0039, B:11:0x0047), top: B:141:0x0004, inners: #0 }] */
    /* renamed from: markMessagesAsDeletedInternal, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.ArrayList<java.lang.Long> lambda$markMessagesAsDeleted$164$MessagesStorage(long r30, java.util.ArrayList<java.lang.Integer> r32, boolean r33, boolean r34) {
        /*
            Method dump skipped, instructions count: 1493
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessagesStorage.lambda$markMessagesAsDeleted$164(long, java.util.ArrayList, boolean, boolean):java.util.ArrayList");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$markMessagesAsDeletedInternal$162, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$markMessagesAsDeletedInternal$162$MessagesStorage(ArrayList arrayList) {
        getFileLoader().cancelLoadFiles(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* renamed from: updateDialogsWithDeletedMessagesInternal, reason: merged with bridge method [inline-methods] */
    public void lambda$updateDialogsWithDeletedMessages$163$MessagesStorage(long j, long j2, ArrayList<Integer> arrayList, ArrayList<Long> arrayList2) {
        TLRPC$TL_dialog tLRPC$TL_dialog;
        SQLitePreparedStatement sQLitePreparedStatementExecuteFast;
        long j3 = j2;
        try {
            ArrayList arrayList3 = new ArrayList();
            ?? r12 = 0;
            if (!arrayList.isEmpty()) {
                if (j3 != 0) {
                    arrayList3.add(Long.valueOf(-j3));
                    sQLitePreparedStatementExecuteFast = this.database.executeFast("UPDATE dialogs SET last_mid = (SELECT mid FROM messages_v2 WHERE uid = ? AND date = (SELECT MAX(date) FROM messages_v2 WHERE uid = ?)) WHERE did = ?");
                } else {
                    if (j == 0) {
                        SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT did FROM dialogs WHERE last_mid IN(%s) AND flags = 0", TextUtils.join(",", arrayList)), new Object[0]);
                        while (sQLiteCursorQueryFinalized.next()) {
                            arrayList3.add(Long.valueOf(sQLiteCursorQueryFinalized.longValue(0)));
                        }
                        sQLiteCursorQueryFinalized.dispose();
                    } else {
                        arrayList3.add(Long.valueOf(j));
                    }
                    sQLitePreparedStatementExecuteFast = this.database.executeFast("UPDATE dialogs SET last_mid = (SELECT mid FROM messages_v2 WHERE uid = ? AND date = (SELECT MAX(date) FROM messages_v2 WHERE uid = ? AND date != 0)) WHERE did = ?");
                }
                this.database.beginTransaction();
                for (int i = 0; i < arrayList3.size(); i++) {
                    long jLongValue = ((Long) arrayList3.get(i)).longValue();
                    sQLitePreparedStatementExecuteFast.requery();
                    sQLitePreparedStatementExecuteFast.bindLong(1, jLongValue);
                    sQLitePreparedStatementExecuteFast.bindLong(2, jLongValue);
                    sQLitePreparedStatementExecuteFast.bindLong(3, jLongValue);
                    sQLitePreparedStatementExecuteFast.step();
                }
                sQLitePreparedStatementExecuteFast.dispose();
                this.database.commitTransaction();
            } else {
                arrayList3.add(Long.valueOf(-j3));
            }
            if (arrayList2 != null) {
                for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                    Long l = arrayList2.get(i2);
                    if (!arrayList3.contains(l)) {
                        arrayList3.add(l);
                    }
                }
            }
            String strJoin = TextUtils.join(",", arrayList3);
            TLRPC$TL_messages_dialogs tLRPC$TL_messages_dialogs = new TLRPC$TL_messages_dialogs();
            ArrayList<TLRPC$EncryptedChat> arrayList4 = new ArrayList<>();
            ArrayList<Long> arrayList5 = new ArrayList<>();
            ArrayList arrayList6 = new ArrayList();
            ArrayList arrayList7 = new ArrayList();
            SQLiteCursor sQLiteCursorQueryFinalized2 = this.database.queryFinalized(String.format(Locale.US, "SELECT d.did, d.last_mid, d.unread_count, d.date, m.data, m.read_state, m.mid, m.send_state, m.date, d.pts, d.inbox_max, d.outbox_max, d.pinned, d.unread_count_i, d.flags, d.folder_id, d.data FROM dialogs as d LEFT JOIN messages_v2 as m ON d.last_mid = m.mid AND d.did = m.uid WHERE d.did IN(%s)", strJoin), new Object[0]);
            while (sQLiteCursorQueryFinalized2.next()) {
                long jLongValue2 = sQLiteCursorQueryFinalized2.longValue(r12);
                if (DialogObject.isFolderDialogId(jLongValue2)) {
                    TLRPC$TL_dialogFolder tLRPC$TL_dialogFolder = new TLRPC$TL_dialogFolder();
                    tLRPC$TL_dialog = tLRPC$TL_dialogFolder;
                    if (!sQLiteCursorQueryFinalized2.isNull(16)) {
                        NativeByteBuffer nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized2.byteBufferValue(16);
                        if (nativeByteBufferByteBufferValue != 0) {
                            tLRPC$TL_dialogFolder.folder = TLRPC$TL_folder.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(r12), r12);
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
                tLRPC$TL_dialog.flags = j3 == 0 ? 0 : 1;
                int iIntValue = sQLiteCursorQueryFinalized2.intValue(12);
                tLRPC$TL_dialog.pinnedNum = iIntValue;
                tLRPC$TL_dialog.pinned = iIntValue != 0;
                int iIntValue2 = sQLiteCursorQueryFinalized2.intValue(14);
                tLRPC$TL_dialog.unread_mark = (iIntValue2 & 1) != 0;
                tLRPC$TL_dialog.folder_id = sQLiteCursorQueryFinalized2.intValue(15);
                tLRPC$TL_dialog.isLocked = (iIntValue2 & 1048576) != 0;
                tLRPC$TL_messages_dialogs.dialogs.add(tLRPC$TL_dialog);
                NativeByteBuffer nativeByteBufferByteBufferValue2 = sQLiteCursorQueryFinalized2.byteBufferValue(4);
                if (nativeByteBufferByteBufferValue2 != null) {
                    TLRPC$Message tLRPC$MessageTLdeserialize = TLRPC$Message.TLdeserialize(nativeByteBufferByteBufferValue2, nativeByteBufferByteBufferValue2.readInt32(false), false);
                    tLRPC$MessageTLdeserialize.readAttachPath(nativeByteBufferByteBufferValue2, getUserConfig().clientUserId);
                    nativeByteBufferByteBufferValue2.reuse();
                    MessageObject.setUnreadFlags(tLRPC$MessageTLdeserialize, sQLiteCursorQueryFinalized2.intValue(5));
                    tLRPC$MessageTLdeserialize.id = sQLiteCursorQueryFinalized2.intValue(6);
                    tLRPC$MessageTLdeserialize.send_state = sQLiteCursorQueryFinalized2.intValue(7);
                    int iIntValue3 = sQLiteCursorQueryFinalized2.intValue(8);
                    if (iIntValue3 != 0) {
                        tLRPC$TL_dialog.last_message_date = iIntValue3;
                    }
                    tLRPC$MessageTLdeserialize.dialog_id = tLRPC$TL_dialog.id;
                    tLRPC$TL_messages_dialogs.messages.add(tLRPC$MessageTLdeserialize);
                    addUsersAndChatsFromMessage(tLRPC$MessageTLdeserialize, arrayList5, arrayList6);
                }
                if (DialogObject.isEncryptedDialog(jLongValue2)) {
                    int encryptedChatId = DialogObject.getEncryptedChatId(jLongValue2);
                    if (!arrayList7.contains(Integer.valueOf(encryptedChatId))) {
                        arrayList7.add(Integer.valueOf(encryptedChatId));
                    }
                } else if (DialogObject.isUserDialog(jLongValue2)) {
                    if (!arrayList5.contains(Long.valueOf(jLongValue2))) {
                        arrayList5.add(Long.valueOf(jLongValue2));
                    }
                } else {
                    long j4 = -jLongValue2;
                    if (!arrayList6.contains(Long.valueOf(j4))) {
                        arrayList6.add(Long.valueOf(j4));
                    }
                }
                j3 = j2;
                r12 = 0;
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

    public void updateDialogsWithDeletedMessages(final long dialogId, final long channelId, final ArrayList<Integer> messages, final ArrayList<Long> additionalDialogsToUpdate, boolean useQueue) {
        if (useQueue) {
            this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$qFThggogME1oj7N-VkvZZmnSdxs
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$updateDialogsWithDeletedMessages$163$MessagesStorage(dialogId, channelId, messages, additionalDialogsToUpdate);
                }
            });
        } else {
            lambda$updateDialogsWithDeletedMessages$163(dialogId, channelId, messages, additionalDialogsToUpdate);
        }
    }

    public ArrayList<Long> markMessagesAsDeleted(final long dialogId, final ArrayList<Integer> messages, boolean useQueue, final boolean deleteFiles, final boolean scheduled) {
        if (messages.isEmpty()) {
            return null;
        }
        if (useQueue) {
            this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$7CHCxf3llUEcOklH2fhpK1V6-ko
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$markMessagesAsDeleted$164$MessagesStorage(dialogId, messages, deleteFiles, scheduled);
                }
            });
            return null;
        }
        return lambda$markMessagesAsDeleted$164(dialogId, messages, deleteFiles, scheduled);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0109 A[Catch: Exception -> 0x0286, TryCatch #2 {Exception -> 0x0286, blocks: (B:41:0x00ef, B:42:0x0103, B:44:0x0109, B:46:0x0132, B:48:0x013d, B:49:0x0180, B:51:0x01d8, B:53:0x01de, B:55:0x01e3, B:57:0x01ff, B:58:0x0220, B:59:0x0223), top: B:73:0x00ef }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01d8 A[Catch: Exception -> 0x0286, TryCatch #2 {Exception -> 0x0286, blocks: (B:41:0x00ef, B:42:0x0103, B:44:0x0109, B:46:0x0132, B:48:0x013d, B:49:0x0180, B:51:0x01d8, B:53:0x01de, B:55:0x01e3, B:57:0x01ff, B:58:0x0220, B:59:0x0223), top: B:73:0x00ef }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01e3 A[Catch: Exception -> 0x0286, TryCatch #2 {Exception -> 0x0286, blocks: (B:41:0x00ef, B:42:0x0103, B:44:0x0109, B:46:0x0132, B:48:0x013d, B:49:0x0180, B:51:0x01d8, B:53:0x01de, B:55:0x01e3, B:57:0x01ff, B:58:0x0220, B:59:0x0223), top: B:73:0x00ef }] */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* renamed from: markMessagesAsDeletedInternal, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.ArrayList<java.lang.Long> lambda$markMessagesAsDeleted$166$MessagesStorage(long r20, int r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 659
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessagesStorage.lambda$markMessagesAsDeleted$166(long, int, boolean):java.util.ArrayList");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$markMessagesAsDeletedInternal$165, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$markMessagesAsDeletedInternal$165$MessagesStorage(ArrayList arrayList) {
        getFileLoader().cancelLoadFiles(arrayList);
    }

    public ArrayList<Long> markMessagesAsDeleted(final long channelId, final int mid, boolean useQueue, final boolean deleteFiles) {
        if (useQueue) {
            this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$xt32iPkBK-5kQUtf0Nli1BjThFo
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$markMessagesAsDeleted$166$MessagesStorage(channelId, mid, deleteFiles);
                }
            });
            return null;
        }
        return lambda$markMessagesAsDeleted$166(channelId, mid, deleteFiles);
    }

    private void fixUnsupportedMedia(TLRPC$Message message) {
        if (message == null) {
            return;
        }
        TLRPC$MessageMedia tLRPC$MessageMedia = message.media;
        if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaUnsupported_old) {
            if (tLRPC$MessageMedia.bytes.length == 0) {
                tLRPC$MessageMedia.bytes = Utilities.intToBytes(133);
            }
        } else if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaUnsupported) {
            TLRPC$TL_messageMediaUnsupported_old tLRPC$TL_messageMediaUnsupported_old = new TLRPC$TL_messageMediaUnsupported_old();
            message.media = tLRPC$TL_messageMediaUnsupported_old;
            tLRPC$TL_messageMediaUnsupported_old.bytes = Utilities.intToBytes(133);
            message.flags |= Factory.DEVICE_USE_ANDROID_CAMCORDER;
        }
    }

    private void doneHolesInTable(String table, long did, int max_id) throws Exception {
        if (max_id == 0) {
            this.database.executeFast(String.format(Locale.US, "DELETE FROM " + table + " WHERE uid = %d", Long.valueOf(did))).stepThis().dispose();
        } else {
            this.database.executeFast(String.format(Locale.US, "DELETE FROM " + table + " WHERE uid = %d AND start = 0", Long.valueOf(did))).stepThis().dispose();
        }
        SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("REPLACE INTO " + table + " VALUES(?, ?, ?)");
        sQLitePreparedStatementExecuteFast.requery();
        sQLitePreparedStatementExecuteFast.bindLong(1, did);
        sQLitePreparedStatementExecuteFast.bindInteger(2, 1);
        sQLitePreparedStatementExecuteFast.bindInteger(3, 1);
        sQLitePreparedStatementExecuteFast.step();
        sQLitePreparedStatementExecuteFast.dispose();
    }

    public void doneHolesInMedia(long did, int max_id, int type) throws Exception {
        if (type == -1) {
            if (max_id == 0) {
                this.database.executeFast(String.format(Locale.US, "DELETE FROM media_holes_v2 WHERE uid = %d", Long.valueOf(did))).stepThis().dispose();
            } else {
                this.database.executeFast(String.format(Locale.US, "DELETE FROM media_holes_v2 WHERE uid = %d AND start = 0", Long.valueOf(did))).stepThis().dispose();
            }
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("REPLACE INTO media_holes_v2 VALUES(?, ?, ?, ?)");
            for (int i = 0; i < 6; i++) {
                sQLitePreparedStatementExecuteFast.requery();
                sQLitePreparedStatementExecuteFast.bindLong(1, did);
                sQLitePreparedStatementExecuteFast.bindInteger(2, i);
                sQLitePreparedStatementExecuteFast.bindInteger(3, 1);
                sQLitePreparedStatementExecuteFast.bindInteger(4, 1);
                sQLitePreparedStatementExecuteFast.step();
            }
            sQLitePreparedStatementExecuteFast.dispose();
            return;
        }
        if (max_id == 0) {
            this.database.executeFast(String.format(Locale.US, "DELETE FROM media_holes_v2 WHERE uid = %d AND type = %d", Long.valueOf(did), Integer.valueOf(type))).stepThis().dispose();
        } else {
            this.database.executeFast(String.format(Locale.US, "DELETE FROM media_holes_v2 WHERE uid = %d AND type = %d AND start = 0", Long.valueOf(did), Integer.valueOf(type))).stepThis().dispose();
        }
        SQLitePreparedStatement sQLitePreparedStatementExecuteFast2 = this.database.executeFast("REPLACE INTO media_holes_v2 VALUES(?, ?, ?, ?)");
        sQLitePreparedStatementExecuteFast2.requery();
        sQLitePreparedStatementExecuteFast2.bindLong(1, did);
        sQLitePreparedStatementExecuteFast2.bindInteger(2, type);
        sQLitePreparedStatementExecuteFast2.bindInteger(3, 1);
        sQLitePreparedStatementExecuteFast2.bindInteger(4, 1);
        sQLitePreparedStatementExecuteFast2.step();
        sQLitePreparedStatementExecuteFast2.dispose();
    }

    private static class Hole {
        public int end;
        public int start;
        public int type;

        public Hole(int s, int e) {
            this.start = s;
            this.end = e;
        }

        public Hole(int t, int s, int e) {
            this.type = t;
            this.start = s;
            this.end = e;
        }
    }

    public void closeHolesInMedia(long did, int minId, int maxId, int type) throws SQLiteException {
        SQLiteCursor sQLiteCursorQueryFinalized;
        int i = 4;
        try {
            if (type < 0) {
                sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT type, start, end FROM media_holes_v2 WHERE uid = %d AND type >= 0 AND ((end >= %d AND end <= %d) OR (start >= %d AND start <= %d) OR (start >= %d AND end <= %d) OR (start <= %d AND end >= %d))", Long.valueOf(did), Integer.valueOf(minId), Integer.valueOf(maxId), Integer.valueOf(minId), Integer.valueOf(maxId), Integer.valueOf(minId), Integer.valueOf(maxId), Integer.valueOf(minId), Integer.valueOf(maxId)), new Object[0]);
            } else {
                sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT type, start, end FROM media_holes_v2 WHERE uid = %d AND type = %d AND ((end >= %d AND end <= %d) OR (start >= %d AND start <= %d) OR (start >= %d AND end <= %d) OR (start <= %d AND end >= %d))", Long.valueOf(did), Integer.valueOf(type), Integer.valueOf(minId), Integer.valueOf(maxId), Integer.valueOf(minId), Integer.valueOf(maxId), Integer.valueOf(minId), Integer.valueOf(maxId), Integer.valueOf(minId), Integer.valueOf(maxId)), new Object[0]);
            }
            ArrayList arrayList = null;
            while (sQLiteCursorQueryFinalized.next()) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                int iIntValue = sQLiteCursorQueryFinalized.intValue(0);
                int iIntValue2 = sQLiteCursorQueryFinalized.intValue(1);
                int iIntValue3 = sQLiteCursorQueryFinalized.intValue(2);
                if (iIntValue2 != iIntValue3 || iIntValue2 != 1) {
                    arrayList.add(new Hole(iIntValue, iIntValue2, iIntValue3));
                }
            }
            sQLiteCursorQueryFinalized.dispose();
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    Hole hole = (Hole) arrayList.get(i2);
                    int i3 = hole.end;
                    if (maxId >= i3 - 1 && minId <= hole.start + 1) {
                        SQLiteDatabase sQLiteDatabase = this.database;
                        Locale locale = Locale.US;
                        Object[] objArr = new Object[i];
                        objArr[0] = Long.valueOf(did);
                        objArr[1] = Integer.valueOf(hole.type);
                        objArr[2] = Integer.valueOf(hole.start);
                        objArr[3] = Integer.valueOf(hole.end);
                        sQLiteDatabase.executeFast(String.format(locale, "DELETE FROM media_holes_v2 WHERE uid = %d AND type = %d AND start = %d AND end = %d", objArr)).stepThis().dispose();
                    } else if (maxId < i3 - 1) {
                        int i4 = hole.start;
                        if (minId > i4 + 1) {
                            this.database.executeFast(String.format(Locale.US, "DELETE FROM media_holes_v2 WHERE uid = %d AND type = %d AND start = %d AND end = %d", Long.valueOf(did), Integer.valueOf(hole.type), Integer.valueOf(hole.start), Integer.valueOf(hole.end))).stepThis().dispose();
                            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("REPLACE INTO media_holes_v2 VALUES(?, ?, ?, ?)");
                            sQLitePreparedStatementExecuteFast.requery();
                            sQLitePreparedStatementExecuteFast.bindLong(1, did);
                            sQLitePreparedStatementExecuteFast.bindInteger(2, hole.type);
                            sQLitePreparedStatementExecuteFast.bindInteger(3, hole.start);
                            sQLitePreparedStatementExecuteFast.bindInteger(4, minId);
                            sQLitePreparedStatementExecuteFast.step();
                            sQLitePreparedStatementExecuteFast.requery();
                            sQLitePreparedStatementExecuteFast.bindLong(1, did);
                            sQLitePreparedStatementExecuteFast.bindInteger(2, hole.type);
                            sQLitePreparedStatementExecuteFast.bindInteger(3, maxId);
                            i = 4;
                            sQLitePreparedStatementExecuteFast.bindInteger(4, hole.end);
                            sQLitePreparedStatementExecuteFast.step();
                            sQLitePreparedStatementExecuteFast.dispose();
                        } else if (i4 != maxId) {
                            try {
                                this.database.executeFast(String.format(Locale.US, "UPDATE media_holes_v2 SET start = %d WHERE uid = %d AND type = %d AND start = %d AND end = %d", Integer.valueOf(maxId), Long.valueOf(did), Integer.valueOf(hole.type), Integer.valueOf(hole.start), Integer.valueOf(hole.end))).stepThis().dispose();
                            } catch (Exception e) {
                                FileLog.e(e);
                            }
                        }
                    } else if (i3 != minId) {
                        try {
                            this.database.executeFast(String.format(Locale.US, "UPDATE media_holes_v2 SET end = %d WHERE uid = %d AND type = %d AND start = %d AND end = %d", Integer.valueOf(minId), Long.valueOf(did), Integer.valueOf(hole.type), Integer.valueOf(hole.start), Integer.valueOf(hole.end))).stepThis().dispose();
                        } catch (Exception e2) {
                            FileLog.e(e2);
                        }
                    }
                    i = 4;
                }
            }
        } catch (Exception e3) {
            FileLog.e(e3);
        }
    }

    private void closeHolesInTable(String table, long did, int minId, int maxId) {
        try {
            int i = 1;
            SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT start, end FROM " + table + " WHERE uid = %d AND ((end >= %d AND end <= %d) OR (start >= %d AND start <= %d) OR (start >= %d AND end <= %d) OR (start <= %d AND end >= %d))", Long.valueOf(did), Integer.valueOf(minId), Integer.valueOf(maxId), Integer.valueOf(minId), Integer.valueOf(maxId), Integer.valueOf(minId), Integer.valueOf(maxId), Integer.valueOf(minId), Integer.valueOf(maxId)), new Object[0]);
            ArrayList arrayList = null;
            while (sQLiteCursorQueryFinalized.next()) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                int iIntValue = sQLiteCursorQueryFinalized.intValue(0);
                int iIntValue2 = sQLiteCursorQueryFinalized.intValue(1);
                if (iIntValue != iIntValue2 || iIntValue != 1) {
                    arrayList.add(new Hole(iIntValue, iIntValue2));
                }
            }
            sQLiteCursorQueryFinalized.dispose();
            if (arrayList != null) {
                int i2 = 0;
                while (i2 < arrayList.size()) {
                    Hole hole = (Hole) arrayList.get(i2);
                    int i3 = hole.end;
                    if (maxId >= i3 - 1 && minId <= hole.start + i) {
                        this.database.executeFast(String.format(Locale.US, "DELETE FROM " + table + " WHERE uid = %d AND start = %d AND end = %d", Long.valueOf(did), Integer.valueOf(hole.start), Integer.valueOf(hole.end))).stepThis().dispose();
                    } else if (maxId < i3 - 1) {
                        int i4 = hole.start;
                        if (minId > i4 + 1) {
                            this.database.executeFast(String.format(Locale.US, "DELETE FROM " + table + " WHERE uid = %d AND start = %d AND end = %d", Long.valueOf(did), Integer.valueOf(hole.start), Integer.valueOf(hole.end))).stepThis().dispose();
                            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = this.database.executeFast("REPLACE INTO " + table + " VALUES(?, ?, ?)");
                            sQLitePreparedStatementExecuteFast.requery();
                            sQLitePreparedStatementExecuteFast.bindLong(1, did);
                            sQLitePreparedStatementExecuteFast.bindInteger(2, hole.start);
                            sQLitePreparedStatementExecuteFast.bindInteger(3, minId);
                            sQLitePreparedStatementExecuteFast.step();
                            sQLitePreparedStatementExecuteFast.requery();
                            sQLitePreparedStatementExecuteFast.bindLong(1, did);
                            sQLitePreparedStatementExecuteFast.bindInteger(2, maxId);
                            sQLitePreparedStatementExecuteFast.bindInteger(3, hole.end);
                            sQLitePreparedStatementExecuteFast.step();
                            sQLitePreparedStatementExecuteFast.dispose();
                            i2++;
                            i = 1;
                        } else if (i4 != maxId) {
                            try {
                                this.database.executeFast(String.format(Locale.US, "UPDATE " + table + " SET start = %d WHERE uid = %d AND start = %d AND end = %d", Integer.valueOf(maxId), Long.valueOf(did), Integer.valueOf(hole.start), Integer.valueOf(hole.end))).stepThis().dispose();
                            } catch (Exception e) {
                                FileLog.e(e);
                            }
                        }
                    } else if (i3 != minId) {
                        try {
                            this.database.executeFast(String.format(Locale.US, "UPDATE " + table + " SET end = %d WHERE uid = %d AND start = %d AND end = %d", Integer.valueOf(minId), Long.valueOf(did), Integer.valueOf(hole.start), Integer.valueOf(hole.end))).stepThis().dispose();
                        } catch (Exception e2) {
                            FileLog.e(e2);
                        }
                    }
                    i2++;
                    i = 1;
                }
            }
        } catch (Exception e3) {
            FileLog.e(e3);
        }
    }

    public void replaceMessageIfExists(final TLRPC$Message message, final ArrayList<TLRPC$User> users, final ArrayList<TLRPC$Chat> chats, final boolean broadcast) {
        if (message == null) {
            return;
        }
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$rTzL-kZmPZA_ncrPbUQgCL7McKU
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f$0.lambda$replaceMessageIfExists$168$MessagesStorage(message, broadcast, users, chats);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006a A[Catch: Exception -> 0x01c2, TryCatch #2 {Exception -> 0x01c2, blocks: (B:6:0x0031, B:9:0x0039, B:21:0x004d, B:23:0x006a, B:24:0x006d, B:26:0x00a4, B:31:0x00ac, B:33:0x00be, B:35:0x00cb, B:41:0x00d6, B:45:0x00e4, B:47:0x00f4, B:49:0x010b, B:51:0x0111, B:55:0x0118, B:57:0x011f, B:59:0x0131, B:61:0x0152, B:62:0x0155, B:64:0x0165, B:65:0x0170, B:67:0x0176, B:68:0x018a, B:70:0x0190, B:71:0x01a4, B:54:0x0116, B:56:0x011c, B:48:0x0108, B:34:0x00c4, B:19:0x0049, B:77:0x01c8, B:78:0x01cb), top: B:84:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00be A[Catch: Exception -> 0x01c2, TryCatch #2 {Exception -> 0x01c2, blocks: (B:6:0x0031, B:9:0x0039, B:21:0x004d, B:23:0x006a, B:24:0x006d, B:26:0x00a4, B:31:0x00ac, B:33:0x00be, B:35:0x00cb, B:41:0x00d6, B:45:0x00e4, B:47:0x00f4, B:49:0x010b, B:51:0x0111, B:55:0x0118, B:57:0x011f, B:59:0x0131, B:61:0x0152, B:62:0x0155, B:64:0x0165, B:65:0x0170, B:67:0x0176, B:68:0x018a, B:70:0x0190, B:71:0x01a4, B:54:0x0116, B:56:0x011c, B:48:0x0108, B:34:0x00c4, B:19:0x0049, B:77:0x01c8, B:78:0x01cb), top: B:84:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c4 A[Catch: Exception -> 0x01c2, TryCatch #2 {Exception -> 0x01c2, blocks: (B:6:0x0031, B:9:0x0039, B:21:0x004d, B:23:0x006a, B:24:0x006d, B:26:0x00a4, B:31:0x00ac, B:33:0x00be, B:35:0x00cb, B:41:0x00d6, B:45:0x00e4, B:47:0x00f4, B:49:0x010b, B:51:0x0111, B:55:0x0118, B:57:0x011f, B:59:0x0131, B:61:0x0152, B:62:0x0155, B:64:0x0165, B:65:0x0170, B:67:0x0176, B:68:0x018a, B:70:0x0190, B:71:0x01a4, B:54:0x0116, B:56:0x011c, B:48:0x0108, B:34:0x00c4, B:19:0x0049, B:77:0x01c8, B:78:0x01cb), top: B:84:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f4 A[Catch: Exception -> 0x01c2, TryCatch #2 {Exception -> 0x01c2, blocks: (B:6:0x0031, B:9:0x0039, B:21:0x004d, B:23:0x006a, B:24:0x006d, B:26:0x00a4, B:31:0x00ac, B:33:0x00be, B:35:0x00cb, B:41:0x00d6, B:45:0x00e4, B:47:0x00f4, B:49:0x010b, B:51:0x0111, B:55:0x0118, B:57:0x011f, B:59:0x0131, B:61:0x0152, B:62:0x0155, B:64:0x0165, B:65:0x0170, B:67:0x0176, B:68:0x018a, B:70:0x0190, B:71:0x01a4, B:54:0x0116, B:56:0x011c, B:48:0x0108, B:34:0x00c4, B:19:0x0049, B:77:0x01c8, B:78:0x01cb), top: B:84:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0108 A[Catch: Exception -> 0x01c2, TryCatch #2 {Exception -> 0x01c2, blocks: (B:6:0x0031, B:9:0x0039, B:21:0x004d, B:23:0x006a, B:24:0x006d, B:26:0x00a4, B:31:0x00ac, B:33:0x00be, B:35:0x00cb, B:41:0x00d6, B:45:0x00e4, B:47:0x00f4, B:49:0x010b, B:51:0x0111, B:55:0x0118, B:57:0x011f, B:59:0x0131, B:61:0x0152, B:62:0x0155, B:64:0x0165, B:65:0x0170, B:67:0x0176, B:68:0x018a, B:70:0x0190, B:71:0x01a4, B:54:0x0116, B:56:0x011c, B:48:0x0108, B:34:0x00c4, B:19:0x0049, B:77:0x01c8, B:78:0x01cb), top: B:84:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0111 A[Catch: Exception -> 0x01c2, TryCatch #2 {Exception -> 0x01c2, blocks: (B:6:0x0031, B:9:0x0039, B:21:0x004d, B:23:0x006a, B:24:0x006d, B:26:0x00a4, B:31:0x00ac, B:33:0x00be, B:35:0x00cb, B:41:0x00d6, B:45:0x00e4, B:47:0x00f4, B:49:0x010b, B:51:0x0111, B:55:0x0118, B:57:0x011f, B:59:0x0131, B:61:0x0152, B:62:0x0155, B:64:0x0165, B:65:0x0170, B:67:0x0176, B:68:0x018a, B:70:0x0190, B:71:0x01a4, B:54:0x0116, B:56:0x011c, B:48:0x0108, B:34:0x00c4, B:19:0x0049, B:77:0x01c8, B:78:0x01cb), top: B:84:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x011c A[Catch: Exception -> 0x01c2, TryCatch #2 {Exception -> 0x01c2, blocks: (B:6:0x0031, B:9:0x0039, B:21:0x004d, B:23:0x006a, B:24:0x006d, B:26:0x00a4, B:31:0x00ac, B:33:0x00be, B:35:0x00cb, B:41:0x00d6, B:45:0x00e4, B:47:0x00f4, B:49:0x010b, B:51:0x0111, B:55:0x0118, B:57:0x011f, B:59:0x0131, B:61:0x0152, B:62:0x0155, B:64:0x0165, B:65:0x0170, B:67:0x0176, B:68:0x018a, B:70:0x0190, B:71:0x01a4, B:54:0x0116, B:56:0x011c, B:48:0x0108, B:34:0x00c4, B:19:0x0049, B:77:0x01c8, B:78:0x01cb), top: B:84:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0131 A[Catch: Exception -> 0x01c2, TryCatch #2 {Exception -> 0x01c2, blocks: (B:6:0x0031, B:9:0x0039, B:21:0x004d, B:23:0x006a, B:24:0x006d, B:26:0x00a4, B:31:0x00ac, B:33:0x00be, B:35:0x00cb, B:41:0x00d6, B:45:0x00e4, B:47:0x00f4, B:49:0x010b, B:51:0x0111, B:55:0x0118, B:57:0x011f, B:59:0x0131, B:61:0x0152, B:62:0x0155, B:64:0x0165, B:65:0x0170, B:67:0x0176, B:68:0x018a, B:70:0x0190, B:71:0x01a4, B:54:0x0116, B:56:0x011c, B:48:0x0108, B:34:0x00c4, B:19:0x0049, B:77:0x01c8, B:78:0x01cb), top: B:84:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0152 A[Catch: Exception -> 0x01c2, TryCatch #2 {Exception -> 0x01c2, blocks: (B:6:0x0031, B:9:0x0039, B:21:0x004d, B:23:0x006a, B:24:0x006d, B:26:0x00a4, B:31:0x00ac, B:33:0x00be, B:35:0x00cb, B:41:0x00d6, B:45:0x00e4, B:47:0x00f4, B:49:0x010b, B:51:0x0111, B:55:0x0118, B:57:0x011f, B:59:0x0131, B:61:0x0152, B:62:0x0155, B:64:0x0165, B:65:0x0170, B:67:0x0176, B:68:0x018a, B:70:0x0190, B:71:0x01a4, B:54:0x0116, B:56:0x011c, B:48:0x0108, B:34:0x00c4, B:19:0x0049, B:77:0x01c8, B:78:0x01cb), top: B:84:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0165 A[Catch: Exception -> 0x01c2, TryCatch #2 {Exception -> 0x01c2, blocks: (B:6:0x0031, B:9:0x0039, B:21:0x004d, B:23:0x006a, B:24:0x006d, B:26:0x00a4, B:31:0x00ac, B:33:0x00be, B:35:0x00cb, B:41:0x00d6, B:45:0x00e4, B:47:0x00f4, B:49:0x010b, B:51:0x0111, B:55:0x0118, B:57:0x011f, B:59:0x0131, B:61:0x0152, B:62:0x0155, B:64:0x0165, B:65:0x0170, B:67:0x0176, B:68:0x018a, B:70:0x0190, B:71:0x01a4, B:54:0x0116, B:56:0x011c, B:48:0x0108, B:34:0x00c4, B:19:0x0049, B:77:0x01c8, B:78:0x01cb), top: B:84:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01c8 A[Catch: Exception -> 0x01c2, TryCatch #2 {Exception -> 0x01c2, blocks: (B:6:0x0031, B:9:0x0039, B:21:0x004d, B:23:0x006a, B:24:0x006d, B:26:0x00a4, B:31:0x00ac, B:33:0x00be, B:35:0x00cb, B:41:0x00d6, B:45:0x00e4, B:47:0x00f4, B:49:0x010b, B:51:0x0111, B:55:0x0118, B:57:0x011f, B:59:0x0131, B:61:0x0152, B:62:0x0155, B:64:0x0165, B:65:0x0170, B:67:0x0176, B:68:0x018a, B:70:0x0190, B:71:0x01a4, B:54:0x0116, B:56:0x011c, B:48:0x0108, B:34:0x00c4, B:19:0x0049, B:77:0x01c8, B:78:0x01cb), top: B:84:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:? A[RETURN, SYNTHETIC] */
    /* renamed from: lambda$replaceMessageIfExists$168, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$replaceMessageIfExists$168$MessagesStorage(ir.eitaa.tgnet.TLRPC$Message r16, boolean r17, java.util.ArrayList r18, java.util.ArrayList r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 464
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessagesStorage.lambda$replaceMessageIfExists$168$MessagesStorage(ir.eitaa.tgnet.TLRPC$Message, boolean, java.util.ArrayList, java.util.ArrayList):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$replaceMessageIfExists$167, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$replaceMessageIfExists$167$MessagesStorage(MessageObject messageObject, ArrayList arrayList) {
        getNotificationCenter().postNotificationName(NotificationCenter.replaceMessagesObjects, Long.valueOf(messageObject.getDialogId()), arrayList);
    }

    public void putMessages(final TLRPC$messages_Messages messages, final long dialogId, final int load_type, final int max_id, final boolean createDialog, final boolean scheduled) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$x4lT1hlE8uknJOcStFuw8_zPucc
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$putMessages$170$MessagesStorage(scheduled, dialogId, messages, load_type, max_id, createDialog);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0527 A[Catch: Exception -> 0x06ac, TryCatch #1 {Exception -> 0x06ac, blocks: (B:4:0x0013, B:6:0x0040, B:10:0x007f, B:9:0x004d, B:11:0x0082, B:12:0x009d, B:15:0x00a8, B:17:0x00b1, B:19:0x00b8, B:34:0x0158, B:36:0x0190, B:38:0x019e, B:42:0x01b0, B:44:0x01e4, B:46:0x01eb, B:48:0x0208, B:50:0x0216, B:51:0x021a, B:52:0x0221, B:54:0x0227, B:56:0x022d, B:58:0x0231, B:60:0x0235, B:76:0x025d, B:78:0x027e, B:82:0x0289, B:86:0x0296, B:88:0x02b6, B:89:0x02ba, B:93:0x02c2, B:94:0x02c5, B:96:0x02c9, B:98:0x02d6, B:202:0x05ef, B:105:0x02f3, B:107:0x0313, B:109:0x032a, B:111:0x032f, B:113:0x03c2, B:115:0x03cc, B:117:0x0406, B:122:0x040e, B:124:0x041e, B:126:0x042f, B:134:0x043e, B:138:0x044c, B:140:0x045a, B:142:0x0477, B:144:0x047b, B:148:0x0482, B:150:0x048e, B:152:0x04a1, B:168:0x0527, B:169:0x052a, B:171:0x0531, B:174:0x0537, B:176:0x0542, B:178:0x056f, B:181:0x0577, B:183:0x0582, B:192:0x05d6, B:196:0x05e0, B:184:0x05a3, B:187:0x05a9, B:189:0x05b4, B:153:0x04c4, B:155:0x04c9, B:165:0x051f, B:147:0x0480, B:149:0x0488, B:141:0x0471, B:125:0x0426, B:112:0x0362, B:63:0x023f, B:65:0x0243, B:67:0x0249, B:69:0x024d, B:71:0x0251, B:203:0x0600, B:205:0x0613, B:207:0x0618, B:209:0x0627, B:211:0x062c, B:212:0x0633, B:214:0x065b, B:215:0x0692, B:217:0x0699, B:22:0x00f2, B:33:0x0131, B:32:0x0127), top: B:224:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0531 A[Catch: Exception -> 0x06ac, TryCatch #1 {Exception -> 0x06ac, blocks: (B:4:0x0013, B:6:0x0040, B:10:0x007f, B:9:0x004d, B:11:0x0082, B:12:0x009d, B:15:0x00a8, B:17:0x00b1, B:19:0x00b8, B:34:0x0158, B:36:0x0190, B:38:0x019e, B:42:0x01b0, B:44:0x01e4, B:46:0x01eb, B:48:0x0208, B:50:0x0216, B:51:0x021a, B:52:0x0221, B:54:0x0227, B:56:0x022d, B:58:0x0231, B:60:0x0235, B:76:0x025d, B:78:0x027e, B:82:0x0289, B:86:0x0296, B:88:0x02b6, B:89:0x02ba, B:93:0x02c2, B:94:0x02c5, B:96:0x02c9, B:98:0x02d6, B:202:0x05ef, B:105:0x02f3, B:107:0x0313, B:109:0x032a, B:111:0x032f, B:113:0x03c2, B:115:0x03cc, B:117:0x0406, B:122:0x040e, B:124:0x041e, B:126:0x042f, B:134:0x043e, B:138:0x044c, B:140:0x045a, B:142:0x0477, B:144:0x047b, B:148:0x0482, B:150:0x048e, B:152:0x04a1, B:168:0x0527, B:169:0x052a, B:171:0x0531, B:174:0x0537, B:176:0x0542, B:178:0x056f, B:181:0x0577, B:183:0x0582, B:192:0x05d6, B:196:0x05e0, B:184:0x05a3, B:187:0x05a9, B:189:0x05b4, B:153:0x04c4, B:155:0x04c9, B:165:0x051f, B:147:0x0480, B:149:0x0488, B:141:0x0471, B:125:0x0426, B:112:0x0362, B:63:0x023f, B:65:0x0243, B:67:0x0249, B:69:0x024d, B:71:0x0251, B:203:0x0600, B:205:0x0613, B:207:0x0618, B:209:0x0627, B:211:0x062c, B:212:0x0633, B:214:0x065b, B:215:0x0692, B:217:0x0699, B:22:0x00f2, B:33:0x0131, B:32:0x0127), top: B:224:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:177:0x056e  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0575  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x05a3 A[Catch: Exception -> 0x06ac, TryCatch #1 {Exception -> 0x06ac, blocks: (B:4:0x0013, B:6:0x0040, B:10:0x007f, B:9:0x004d, B:11:0x0082, B:12:0x009d, B:15:0x00a8, B:17:0x00b1, B:19:0x00b8, B:34:0x0158, B:36:0x0190, B:38:0x019e, B:42:0x01b0, B:44:0x01e4, B:46:0x01eb, B:48:0x0208, B:50:0x0216, B:51:0x021a, B:52:0x0221, B:54:0x0227, B:56:0x022d, B:58:0x0231, B:60:0x0235, B:76:0x025d, B:78:0x027e, B:82:0x0289, B:86:0x0296, B:88:0x02b6, B:89:0x02ba, B:93:0x02c2, B:94:0x02c5, B:96:0x02c9, B:98:0x02d6, B:202:0x05ef, B:105:0x02f3, B:107:0x0313, B:109:0x032a, B:111:0x032f, B:113:0x03c2, B:115:0x03cc, B:117:0x0406, B:122:0x040e, B:124:0x041e, B:126:0x042f, B:134:0x043e, B:138:0x044c, B:140:0x045a, B:142:0x0477, B:144:0x047b, B:148:0x0482, B:150:0x048e, B:152:0x04a1, B:168:0x0527, B:169:0x052a, B:171:0x0531, B:174:0x0537, B:176:0x0542, B:178:0x056f, B:181:0x0577, B:183:0x0582, B:192:0x05d6, B:196:0x05e0, B:184:0x05a3, B:187:0x05a9, B:189:0x05b4, B:153:0x04c4, B:155:0x04c9, B:165:0x051f, B:147:0x0480, B:149:0x0488, B:141:0x0471, B:125:0x0426, B:112:0x0362, B:63:0x023f, B:65:0x0243, B:67:0x0249, B:69:0x024d, B:71:0x0251, B:203:0x0600, B:205:0x0613, B:207:0x0618, B:209:0x0627, B:211:0x062c, B:212:0x0633, B:214:0x065b, B:215:0x0692, B:217:0x0699, B:22:0x00f2, B:33:0x0131, B:32:0x0127), top: B:224:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x05d6 A[Catch: Exception -> 0x06ac, TryCatch #1 {Exception -> 0x06ac, blocks: (B:4:0x0013, B:6:0x0040, B:10:0x007f, B:9:0x004d, B:11:0x0082, B:12:0x009d, B:15:0x00a8, B:17:0x00b1, B:19:0x00b8, B:34:0x0158, B:36:0x0190, B:38:0x019e, B:42:0x01b0, B:44:0x01e4, B:46:0x01eb, B:48:0x0208, B:50:0x0216, B:51:0x021a, B:52:0x0221, B:54:0x0227, B:56:0x022d, B:58:0x0231, B:60:0x0235, B:76:0x025d, B:78:0x027e, B:82:0x0289, B:86:0x0296, B:88:0x02b6, B:89:0x02ba, B:93:0x02c2, B:94:0x02c5, B:96:0x02c9, B:98:0x02d6, B:202:0x05ef, B:105:0x02f3, B:107:0x0313, B:109:0x032a, B:111:0x032f, B:113:0x03c2, B:115:0x03cc, B:117:0x0406, B:122:0x040e, B:124:0x041e, B:126:0x042f, B:134:0x043e, B:138:0x044c, B:140:0x045a, B:142:0x0477, B:144:0x047b, B:148:0x0482, B:150:0x048e, B:152:0x04a1, B:168:0x0527, B:169:0x052a, B:171:0x0531, B:174:0x0537, B:176:0x0542, B:178:0x056f, B:181:0x0577, B:183:0x0582, B:192:0x05d6, B:196:0x05e0, B:184:0x05a3, B:187:0x05a9, B:189:0x05b4, B:153:0x04c4, B:155:0x04c9, B:165:0x051f, B:147:0x0480, B:149:0x0488, B:141:0x0471, B:125:0x0426, B:112:0x0362, B:63:0x023f, B:65:0x0243, B:67:0x0249, B:69:0x024d, B:71:0x0251, B:203:0x0600, B:205:0x0613, B:207:0x0618, B:209:0x0627, B:211:0x062c, B:212:0x0633, B:214:0x065b, B:215:0x0692, B:217:0x0699, B:22:0x00f2, B:33:0x0131, B:32:0x0127), top: B:224:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:199:0x05e9  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x023f A[Catch: Exception -> 0x06ac, TryCatch #1 {Exception -> 0x06ac, blocks: (B:4:0x0013, B:6:0x0040, B:10:0x007f, B:9:0x004d, B:11:0x0082, B:12:0x009d, B:15:0x00a8, B:17:0x00b1, B:19:0x00b8, B:34:0x0158, B:36:0x0190, B:38:0x019e, B:42:0x01b0, B:44:0x01e4, B:46:0x01eb, B:48:0x0208, B:50:0x0216, B:51:0x021a, B:52:0x0221, B:54:0x0227, B:56:0x022d, B:58:0x0231, B:60:0x0235, B:76:0x025d, B:78:0x027e, B:82:0x0289, B:86:0x0296, B:88:0x02b6, B:89:0x02ba, B:93:0x02c2, B:94:0x02c5, B:96:0x02c9, B:98:0x02d6, B:202:0x05ef, B:105:0x02f3, B:107:0x0313, B:109:0x032a, B:111:0x032f, B:113:0x03c2, B:115:0x03cc, B:117:0x0406, B:122:0x040e, B:124:0x041e, B:126:0x042f, B:134:0x043e, B:138:0x044c, B:140:0x045a, B:142:0x0477, B:144:0x047b, B:148:0x0482, B:150:0x048e, B:152:0x04a1, B:168:0x0527, B:169:0x052a, B:171:0x0531, B:174:0x0537, B:176:0x0542, B:178:0x056f, B:181:0x0577, B:183:0x0582, B:192:0x05d6, B:196:0x05e0, B:184:0x05a3, B:187:0x05a9, B:189:0x05b4, B:153:0x04c4, B:155:0x04c9, B:165:0x051f, B:147:0x0480, B:149:0x0488, B:141:0x0471, B:125:0x0426, B:112:0x0362, B:63:0x023f, B:65:0x0243, B:67:0x0249, B:69:0x024d, B:71:0x0251, B:203:0x0600, B:205:0x0613, B:207:0x0618, B:209:0x0627, B:211:0x062c, B:212:0x0633, B:214:0x065b, B:215:0x0692, B:217:0x0699, B:22:0x00f2, B:33:0x0131, B:32:0x0127), top: B:224:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0274  */
    /* renamed from: lambda$putMessages$170, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$putMessages$170$MessagesStorage(boolean r39, long r40, ir.eitaa.tgnet.TLRPC$messages_Messages r42, int r43, int r44, boolean r45) {
        /*
            Method dump skipped, instructions count: 1713
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessagesStorage.lambda$putMessages$170$MessagesStorage(boolean, long, ir.eitaa.tgnet.TLRPC$messages_Messages, int, int, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$putMessages$169, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$putMessages$169$MessagesStorage(ArrayList arrayList) {
        getFileLoader().cancelLoadFiles(arrayList);
    }

    public static void addUsersAndChatsFromMessage(TLRPC$Message message, ArrayList<Long> usersToLoad, ArrayList<Long> chatsToLoad) throws NumberFormatException {
        String str;
        TLRPC$Peer tLRPC$Peer;
        long fromChatId = MessageObject.getFromChatId(message);
        if (DialogObject.isUserDialog(fromChatId)) {
            if (!usersToLoad.contains(Long.valueOf(fromChatId))) {
                usersToLoad.add(Long.valueOf(fromChatId));
            }
        } else if (DialogObject.isChatDialog(fromChatId)) {
            long j = -fromChatId;
            if (!chatsToLoad.contains(Long.valueOf(j))) {
                chatsToLoad.add(Long.valueOf(j));
            }
        }
        long j2 = message.via_bot_id;
        if (j2 != 0 && !usersToLoad.contains(Long.valueOf(j2))) {
            usersToLoad.add(Long.valueOf(message.via_bot_id));
        }
        TLRPC$MessageAction tLRPC$MessageAction = message.action;
        if (tLRPC$MessageAction != null) {
            long j3 = tLRPC$MessageAction.user_id;
            if (j3 != 0 && !usersToLoad.contains(Long.valueOf(j3))) {
                usersToLoad.add(Long.valueOf(message.action.user_id));
            }
            long j4 = message.action.channel_id;
            if (j4 != 0 && !chatsToLoad.contains(Long.valueOf(j4))) {
                chatsToLoad.add(Long.valueOf(message.action.channel_id));
            }
            long j5 = message.action.chat_id;
            if (j5 != 0 && !chatsToLoad.contains(Long.valueOf(j5))) {
                chatsToLoad.add(Long.valueOf(message.action.chat_id));
            }
            TLRPC$MessageAction tLRPC$MessageAction2 = message.action;
            if (tLRPC$MessageAction2 instanceof TLRPC$TL_messageActionGeoProximityReached) {
                TLRPC$TL_messageActionGeoProximityReached tLRPC$TL_messageActionGeoProximityReached = (TLRPC$TL_messageActionGeoProximityReached) tLRPC$MessageAction2;
                long peerId = MessageObject.getPeerId(tLRPC$TL_messageActionGeoProximityReached.from_id);
                if (DialogObject.isUserDialog(peerId)) {
                    if (!usersToLoad.contains(Long.valueOf(peerId))) {
                        usersToLoad.add(Long.valueOf(peerId));
                    }
                } else {
                    long j6 = -peerId;
                    if (!chatsToLoad.contains(Long.valueOf(j6))) {
                        chatsToLoad.add(Long.valueOf(j6));
                    }
                }
                long peerId2 = MessageObject.getPeerId(tLRPC$TL_messageActionGeoProximityReached.to_id);
                if (peerId2 > 0) {
                    if (!usersToLoad.contains(Long.valueOf(peerId2))) {
                        usersToLoad.add(Long.valueOf(peerId2));
                    }
                } else {
                    long j7 = -peerId2;
                    if (!chatsToLoad.contains(Long.valueOf(j7))) {
                        chatsToLoad.add(Long.valueOf(j7));
                    }
                }
            }
            if (!message.action.users.isEmpty()) {
                for (int i = 0; i < message.action.users.size(); i++) {
                    Long l = message.action.users.get(i);
                    if (!usersToLoad.contains(l)) {
                        usersToLoad.add(l);
                    }
                }
            }
        }
        if (!message.entities.isEmpty()) {
            for (int i2 = 0; i2 < message.entities.size(); i2++) {
                TLRPC$MessageEntity tLRPC$MessageEntity = message.entities.get(i2);
                if (tLRPC$MessageEntity instanceof TLRPC$TL_messageEntityMentionName) {
                    usersToLoad.add(Long.valueOf(((TLRPC$TL_messageEntityMentionName) tLRPC$MessageEntity).user_id));
                } else if (tLRPC$MessageEntity instanceof TLRPC$TL_inputMessageEntityMentionName) {
                    usersToLoad.add(Long.valueOf(((TLRPC$TL_inputMessageEntityMentionName) tLRPC$MessageEntity).user_id.user_id));
                }
            }
        }
        TLRPC$MessageMedia tLRPC$MessageMedia = message.media;
        if (tLRPC$MessageMedia != null) {
            long j8 = tLRPC$MessageMedia.user_id;
            if (j8 != 0 && !usersToLoad.contains(Long.valueOf(j8))) {
                usersToLoad.add(Long.valueOf(message.media.user_id));
            }
            TLRPC$MessageMedia tLRPC$MessageMedia2 = message.media;
            if (tLRPC$MessageMedia2 instanceof TLRPC$TL_messageMediaPoll) {
                TLRPC$TL_messageMediaPoll tLRPC$TL_messageMediaPoll = (TLRPC$TL_messageMediaPoll) tLRPC$MessageMedia2;
                if (!tLRPC$TL_messageMediaPoll.results.recent_voters.isEmpty()) {
                    usersToLoad.addAll(tLRPC$TL_messageMediaPoll.results.recent_voters);
                }
            }
        }
        TLRPC$MessageReplies tLRPC$MessageReplies = message.replies;
        if (tLRPC$MessageReplies != null) {
            int size = tLRPC$MessageReplies.recent_repliers.size();
            for (int i3 = 0; i3 < size; i3++) {
                long peerId3 = MessageObject.getPeerId(message.replies.recent_repliers.get(i3));
                if (DialogObject.isUserDialog(peerId3)) {
                    if (!usersToLoad.contains(Long.valueOf(peerId3))) {
                        usersToLoad.add(Long.valueOf(peerId3));
                    }
                } else if (DialogObject.isChatDialog(peerId3)) {
                    long j9 = -peerId3;
                    if (!chatsToLoad.contains(Long.valueOf(j9))) {
                        chatsToLoad.add(Long.valueOf(j9));
                    }
                }
            }
        }
        TLRPC$TL_messageReplyHeader tLRPC$TL_messageReplyHeader = message.reply_to;
        if (tLRPC$TL_messageReplyHeader != null && (tLRPC$Peer = tLRPC$TL_messageReplyHeader.reply_to_peer_id) != null) {
            long peerId4 = MessageObject.getPeerId(tLRPC$Peer);
            if (DialogObject.isUserDialog(peerId4)) {
                if (!usersToLoad.contains(Long.valueOf(peerId4))) {
                    usersToLoad.add(Long.valueOf(peerId4));
                }
            } else if (DialogObject.isChatDialog(peerId4)) {
                long j10 = -peerId4;
                if (!chatsToLoad.contains(Long.valueOf(j10))) {
                    chatsToLoad.add(Long.valueOf(j10));
                }
            }
        }
        TLRPC$MessageFwdHeader tLRPC$MessageFwdHeader = message.fwd_from;
        if (tLRPC$MessageFwdHeader != null) {
            TLRPC$Peer tLRPC$Peer2 = tLRPC$MessageFwdHeader.from_id;
            if (tLRPC$Peer2 instanceof TLRPC$TL_peerUser) {
                if (!usersToLoad.contains(Long.valueOf(tLRPC$Peer2.user_id))) {
                    usersToLoad.add(Long.valueOf(message.fwd_from.from_id.user_id));
                }
            } else if (tLRPC$Peer2 instanceof TLRPC$TL_peerChannel) {
                if (!chatsToLoad.contains(Long.valueOf(tLRPC$Peer2.channel_id))) {
                    chatsToLoad.add(Long.valueOf(message.fwd_from.from_id.channel_id));
                }
            } else if ((tLRPC$Peer2 instanceof TLRPC$TL_peerChat) && !chatsToLoad.contains(Long.valueOf(tLRPC$Peer2.chat_id))) {
                chatsToLoad.add(Long.valueOf(message.fwd_from.from_id.chat_id));
            }
            TLRPC$Peer tLRPC$Peer3 = message.fwd_from.saved_from_peer;
            if (tLRPC$Peer3 != null) {
                long j11 = tLRPC$Peer3.user_id;
                if (j11 != 0) {
                    if (!chatsToLoad.contains(Long.valueOf(j11))) {
                        usersToLoad.add(Long.valueOf(message.fwd_from.saved_from_peer.user_id));
                    }
                } else {
                    long j12 = tLRPC$Peer3.channel_id;
                    if (j12 != 0) {
                        if (!chatsToLoad.contains(Long.valueOf(j12))) {
                            chatsToLoad.add(Long.valueOf(message.fwd_from.saved_from_peer.channel_id));
                        }
                    } else {
                        long j13 = tLRPC$Peer3.chat_id;
                        if (j13 != 0 && !chatsToLoad.contains(Long.valueOf(j13))) {
                            chatsToLoad.add(Long.valueOf(message.fwd_from.saved_from_peer.chat_id));
                        }
                    }
                }
            }
        }
        HashMap<String, String> map = message.params;
        if (map == null || (str = map.get("fwd_peer")) == null) {
            return;
        }
        long jLongValue = Utilities.parseLong(str).longValue();
        if (jLongValue < 0) {
            long j14 = -jLongValue;
            if (chatsToLoad.contains(Long.valueOf(j14))) {
                return;
            }
            chatsToLoad.add(Long.valueOf(j14));
        }
    }

    public void getDialogs(final int folderId, final int offset, final int count, boolean loadDraftsPeersAndFolders) {
        LongSparseArray<SparseArray<TLRPC$DraftMessage>> drafts;
        int size;
        long[] jArr = null;
        if (loadDraftsPeersAndFolders && (size = (drafts = getMediaDataController().getDrafts()).size()) > 0) {
            jArr = new long[size];
            for (int i = 0; i < size; i++) {
                if (drafts.valueAt(i).get(0) != null) {
                    jArr[i] = drafts.keyAt(i);
                }
            }
        }
        final long[] jArr2 = jArr;
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$TVBxOVqJvwI5lal1YL5MF3ininM
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getDialogs$172$MessagesStorage(folderId, offset, count, jArr2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x016b A[Catch: Exception -> 0x02d3, TryCatch #4 {Exception -> 0x02d3, blocks: (B:12:0x006d, B:13:0x0092, B:15:0x0098, B:17:0x00a3, B:19:0x00b0, B:21:0x00b6, B:25:0x00db, B:27:0x00ee, B:29:0x010f, B:35:0x011d, B:39:0x013c, B:43:0x0153, B:45:0x016b, B:47:0x0178, B:49:0x0182, B:53:0x0197, B:55:0x01a0, B:57:0x01aa, B:59:0x01b1, B:61:0x01bc, B:63:0x01df, B:64:0x01e1, B:94:0x0259, B:96:0x025f, B:98:0x026f, B:99:0x0277, B:101:0x027f, B:103:0x0289, B:104:0x0291, B:106:0x0297, B:108:0x02a2, B:91:0x0249, B:92:0x024d, B:22:0x00c7, B:26:0x00e7, B:110:0x02b6), top: B:174:0x006d }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01a0 A[Catch: Exception -> 0x02d3, TryCatch #4 {Exception -> 0x02d3, blocks: (B:12:0x006d, B:13:0x0092, B:15:0x0098, B:17:0x00a3, B:19:0x00b0, B:21:0x00b6, B:25:0x00db, B:27:0x00ee, B:29:0x010f, B:35:0x011d, B:39:0x013c, B:43:0x0153, B:45:0x016b, B:47:0x0178, B:49:0x0182, B:53:0x0197, B:55:0x01a0, B:57:0x01aa, B:59:0x01b1, B:61:0x01bc, B:63:0x01df, B:64:0x01e1, B:94:0x0259, B:96:0x025f, B:98:0x026f, B:99:0x0277, B:101:0x027f, B:103:0x0289, B:104:0x0291, B:106:0x0297, B:108:0x02a2, B:91:0x0249, B:92:0x024d, B:22:0x00c7, B:26:0x00e7, B:110:0x02b6), top: B:174:0x006d }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01b1 A[Catch: Exception -> 0x02d3, TryCatch #4 {Exception -> 0x02d3, blocks: (B:12:0x006d, B:13:0x0092, B:15:0x0098, B:17:0x00a3, B:19:0x00b0, B:21:0x00b6, B:25:0x00db, B:27:0x00ee, B:29:0x010f, B:35:0x011d, B:39:0x013c, B:43:0x0153, B:45:0x016b, B:47:0x0178, B:49:0x0182, B:53:0x0197, B:55:0x01a0, B:57:0x01aa, B:59:0x01b1, B:61:0x01bc, B:63:0x01df, B:64:0x01e1, B:94:0x0259, B:96:0x025f, B:98:0x026f, B:99:0x0277, B:101:0x027f, B:103:0x0289, B:104:0x0291, B:106:0x0297, B:108:0x02a2, B:91:0x0249, B:92:0x024d, B:22:0x00c7, B:26:0x00e7, B:110:0x02b6), top: B:174:0x006d }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x025f A[Catch: Exception -> 0x02d3, TryCatch #4 {Exception -> 0x02d3, blocks: (B:12:0x006d, B:13:0x0092, B:15:0x0098, B:17:0x00a3, B:19:0x00b0, B:21:0x00b6, B:25:0x00db, B:27:0x00ee, B:29:0x010f, B:35:0x011d, B:39:0x013c, B:43:0x0153, B:45:0x016b, B:47:0x0178, B:49:0x0182, B:53:0x0197, B:55:0x01a0, B:57:0x01aa, B:59:0x01b1, B:61:0x01bc, B:63:0x01df, B:64:0x01e1, B:94:0x0259, B:96:0x025f, B:98:0x026f, B:99:0x0277, B:101:0x027f, B:103:0x0289, B:104:0x0291, B:106:0x0297, B:108:0x02a2, B:91:0x0249, B:92:0x024d, B:22:0x00c7, B:26:0x00e7, B:110:0x02b6), top: B:174:0x006d }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0277 A[Catch: Exception -> 0x02d3, TryCatch #4 {Exception -> 0x02d3, blocks: (B:12:0x006d, B:13:0x0092, B:15:0x0098, B:17:0x00a3, B:19:0x00b0, B:21:0x00b6, B:25:0x00db, B:27:0x00ee, B:29:0x010f, B:35:0x011d, B:39:0x013c, B:43:0x0153, B:45:0x016b, B:47:0x0178, B:49:0x0182, B:53:0x0197, B:55:0x01a0, B:57:0x01aa, B:59:0x01b1, B:61:0x01bc, B:63:0x01df, B:64:0x01e1, B:94:0x0259, B:96:0x025f, B:98:0x026f, B:99:0x0277, B:101:0x027f, B:103:0x0289, B:104:0x0291, B:106:0x0297, B:108:0x02a2, B:91:0x0249, B:92:0x024d, B:22:0x00c7, B:26:0x00e7, B:110:0x02b6), top: B:174:0x006d }] */
    /* JADX WARN: Type inference failed for: r0v21, types: [ir.eitaa.tgnet.TLRPC$TL_dialog] */
    /* JADX WARN: Type inference failed for: r0v22, types: [ir.eitaa.tgnet.TLRPC$Dialog, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v46, types: [ir.eitaa.tgnet.TLRPC$TL_dialogFolder] */
    /* renamed from: lambda$getDialogs$172, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$getDialogs$172$MessagesStorage(int r26, int r27, int r28, long[] r29) {
        /*
            Method dump skipped, instructions count: 1024
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessagesStorage.lambda$getDialogs$172$MessagesStorage(int, int, int, long[]):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getDialogs$171, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getDialogs$171$MessagesStorage(LongSparseArray longSparseArray) {
        MediaDataController mediaDataController = getMediaDataController();
        mediaDataController.clearDraftsFolderIds();
        if (longSparseArray != null) {
            int size = longSparseArray.size();
            for (int i = 0; i < size; i++) {
                mediaDataController.setDraftFolderId(longSparseArray.keyAt(i), ((Integer) longSparseArray.valueAt(i)).intValue());
            }
        }
    }

    public static void createFirstHoles(long did, SQLitePreparedStatement state5, SQLitePreparedStatement state6, int messageId) throws Exception {
        state5.requery();
        state5.bindLong(1, did);
        state5.bindInteger(2, messageId == 1 ? 1 : 0);
        state5.bindInteger(3, messageId);
        state5.step();
        for (int i = 0; i < 6; i++) {
            state6.requery();
            state6.bindLong(1, did);
            state6.bindInteger(2, i);
            state6.bindInteger(3, messageId == 1 ? 1 : 0);
            state6.bindInteger(4, messageId);
            state6.step();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0121, code lost:
    
        if (r12 < 0) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0369 A[Catch: Exception -> 0x0400, TryCatch #0 {Exception -> 0x0400, blocks: (B:3:0x0006, B:4:0x0017, B:6:0x001f, B:7:0x0031, B:9:0x0039, B:10:0x006f, B:12:0x0079, B:14:0x0090, B:116:0x03b0, B:37:0x0133, B:39:0x013d, B:41:0x014a, B:43:0x0158, B:45:0x019c, B:50:0x01a4, B:52:0x01b4, B:54:0x01b8, B:62:0x01cc, B:66:0x01d6, B:68:0x01e6, B:70:0x0202, B:72:0x0206, B:76:0x020d, B:78:0x0219, B:80:0x022e, B:82:0x0254, B:83:0x0257, B:85:0x025e, B:88:0x0264, B:89:0x026c, B:90:0x0295, B:93:0x029f, B:95:0x02a9, B:97:0x02ca, B:101:0x030d, B:103:0x0369, B:105:0x0389, B:107:0x038e, B:108:0x0391, B:110:0x0395, B:114:0x03a8, B:104:0x0383, B:98:0x02eb, B:75:0x020b, B:77:0x0213, B:69:0x01fc, B:19:0x00bf, B:21:0x00e1, B:23:0x00e5, B:26:0x00ef, B:29:0x00f6, B:31:0x0118, B:33:0x011e, B:117:0x03bf, B:119:0x03da, B:121:0x03e9, B:122:0x03ec), top: B:127:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0383 A[Catch: Exception -> 0x0400, TryCatch #0 {Exception -> 0x0400, blocks: (B:3:0x0006, B:4:0x0017, B:6:0x001f, B:7:0x0031, B:9:0x0039, B:10:0x006f, B:12:0x0079, B:14:0x0090, B:116:0x03b0, B:37:0x0133, B:39:0x013d, B:41:0x014a, B:43:0x0158, B:45:0x019c, B:50:0x01a4, B:52:0x01b4, B:54:0x01b8, B:62:0x01cc, B:66:0x01d6, B:68:0x01e6, B:70:0x0202, B:72:0x0206, B:76:0x020d, B:78:0x0219, B:80:0x022e, B:82:0x0254, B:83:0x0257, B:85:0x025e, B:88:0x0264, B:89:0x026c, B:90:0x0295, B:93:0x029f, B:95:0x02a9, B:97:0x02ca, B:101:0x030d, B:103:0x0369, B:105:0x0389, B:107:0x038e, B:108:0x0391, B:110:0x0395, B:114:0x03a8, B:104:0x0383, B:98:0x02eb, B:75:0x020b, B:77:0x0213, B:69:0x01fc, B:19:0x00bf, B:21:0x00e1, B:23:0x00e5, B:26:0x00ef, B:29:0x00f6, B:31:0x0118, B:33:0x011e, B:117:0x03bf, B:119:0x03da, B:121:0x03e9, B:122:0x03ec), top: B:127:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x038e A[Catch: Exception -> 0x0400, TryCatch #0 {Exception -> 0x0400, blocks: (B:3:0x0006, B:4:0x0017, B:6:0x001f, B:7:0x0031, B:9:0x0039, B:10:0x006f, B:12:0x0079, B:14:0x0090, B:116:0x03b0, B:37:0x0133, B:39:0x013d, B:41:0x014a, B:43:0x0158, B:45:0x019c, B:50:0x01a4, B:52:0x01b4, B:54:0x01b8, B:62:0x01cc, B:66:0x01d6, B:68:0x01e6, B:70:0x0202, B:72:0x0206, B:76:0x020d, B:78:0x0219, B:80:0x022e, B:82:0x0254, B:83:0x0257, B:85:0x025e, B:88:0x0264, B:89:0x026c, B:90:0x0295, B:93:0x029f, B:95:0x02a9, B:97:0x02ca, B:101:0x030d, B:103:0x0369, B:105:0x0389, B:107:0x038e, B:108:0x0391, B:110:0x0395, B:114:0x03a8, B:104:0x0383, B:98:0x02eb, B:75:0x020b, B:77:0x0213, B:69:0x01fc, B:19:0x00bf, B:21:0x00e1, B:23:0x00e5, B:26:0x00ef, B:29:0x00f6, B:31:0x0118, B:33:0x011e, B:117:0x03bf, B:119:0x03da, B:121:0x03e9, B:122:0x03ec), top: B:127:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0395 A[Catch: Exception -> 0x0400, TryCatch #0 {Exception -> 0x0400, blocks: (B:3:0x0006, B:4:0x0017, B:6:0x001f, B:7:0x0031, B:9:0x0039, B:10:0x006f, B:12:0x0079, B:14:0x0090, B:116:0x03b0, B:37:0x0133, B:39:0x013d, B:41:0x014a, B:43:0x0158, B:45:0x019c, B:50:0x01a4, B:52:0x01b4, B:54:0x01b8, B:62:0x01cc, B:66:0x01d6, B:68:0x01e6, B:70:0x0202, B:72:0x0206, B:76:0x020d, B:78:0x0219, B:80:0x022e, B:82:0x0254, B:83:0x0257, B:85:0x025e, B:88:0x0264, B:89:0x026c, B:90:0x0295, B:93:0x029f, B:95:0x02a9, B:97:0x02ca, B:101:0x030d, B:103:0x0369, B:105:0x0389, B:107:0x038e, B:108:0x0391, B:110:0x0395, B:114:0x03a8, B:104:0x0383, B:98:0x02eb, B:75:0x020b, B:77:0x0213, B:69:0x01fc, B:19:0x00bf, B:21:0x00e1, B:23:0x00e5, B:26:0x00ef, B:29:0x00f6, B:31:0x0118, B:33:0x011e, B:117:0x03bf, B:119:0x03da, B:121:0x03e9, B:122:0x03ec), top: B:127:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x013d A[Catch: Exception -> 0x0400, TryCatch #0 {Exception -> 0x0400, blocks: (B:3:0x0006, B:4:0x0017, B:6:0x001f, B:7:0x0031, B:9:0x0039, B:10:0x006f, B:12:0x0079, B:14:0x0090, B:116:0x03b0, B:37:0x0133, B:39:0x013d, B:41:0x014a, B:43:0x0158, B:45:0x019c, B:50:0x01a4, B:52:0x01b4, B:54:0x01b8, B:62:0x01cc, B:66:0x01d6, B:68:0x01e6, B:70:0x0202, B:72:0x0206, B:76:0x020d, B:78:0x0219, B:80:0x022e, B:82:0x0254, B:83:0x0257, B:85:0x025e, B:88:0x0264, B:89:0x026c, B:90:0x0295, B:93:0x029f, B:95:0x02a9, B:97:0x02ca, B:101:0x030d, B:103:0x0369, B:105:0x0389, B:107:0x038e, B:108:0x0391, B:110:0x0395, B:114:0x03a8, B:104:0x0383, B:98:0x02eb, B:75:0x020b, B:77:0x0213, B:69:0x01fc, B:19:0x00bf, B:21:0x00e1, B:23:0x00e5, B:26:0x00ef, B:29:0x00f6, B:31:0x0118, B:33:0x011e, B:117:0x03bf, B:119:0x03da, B:121:0x03e9, B:122:0x03ec), top: B:127:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void putDialogsInternal(ir.eitaa.tgnet.TLRPC$messages_Dialogs r24, int r25) {
        /*
            Method dump skipped, instructions count: 1029
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessagesStorage.putDialogsInternal(ir.eitaa.tgnet.TLRPC$messages_Dialogs, int):void");
    }

    public void updateDialogLockStateInternal(final TLRPC$Dialog dialog, boolean lockState) {
        dialog.isLocked = lockState;
        if (lockState) {
            dialog.flags |= 1048576;
            getNotificationsController().setDialogNotificationsSettings(dialog.id, 3);
        } else {
            dialog.flags = (dialog.pts == 0 || DialogObject.isUserDialog(dialog.id)) ? 0 : 1;
            getNotificationsController().setDialogNotificationsSettings(dialog.id, 4);
        }
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$amjgPt1E1R7b4e1p90gc1q6CuWM
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateDialogLockStateInternal$173$MessagesStorage(dialog);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateDialogLockStateInternal$173, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateDialogLockStateInternal$173$MessagesStorage(TLRPC$Dialog tLRPC$Dialog) {
        try {
            SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized("SELECT flags FROM dialog_settings WHERE did = " + tLRPC$Dialog.id, new Object[0]);
            int iIntValue = sQLiteCursorQueryFinalized.next() ? sQLiteCursorQueryFinalized.intValue(0) : 0;
            sQLiteCursorQueryFinalized.dispose();
            if (tLRPC$Dialog.flags == iIntValue) {
                return;
            }
            this.database.executeFast(String.format(Locale.US, "REPLACE INTO dialog_settings VALUES(%d, %d)", Long.valueOf(tLRPC$Dialog.id), Integer.valueOf(tLRPC$Dialog.flags))).stepThis().dispose();
            resetAllUnreadCounters(false);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void getDialogFolderId(final long dialogId, final IntCallback callback) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$Q6tDqci4J-q2EVNgXY9yI3UAqsg
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getDialogFolderId$175$MessagesStorage(dialogId, callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getDialogFolderId$175, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getDialogFolderId$175$MessagesStorage(long j, final IntCallback intCallback) {
        try {
            if (this.unknownDialogsIds.get(j) == null) {
                SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized("SELECT folder_id FROM dialogs WHERE did = ?", Long.valueOf(j));
                iIntValue = sQLiteCursorQueryFinalized.next() ? sQLiteCursorQueryFinalized.intValue(0) : -1;
                sQLiteCursorQueryFinalized.dispose();
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$CbRHf_tYoTk-1LtEb9BZVMKffzw
                @Override // java.lang.Runnable
                public final void run() {
                    intCallback.run(iIntValue);
                }
            });
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void setDialogsFolderId(final ArrayList<TLRPC$TL_folderPeer> peers, final ArrayList<TLRPC$TL_inputFolderPeer> inputPeers, final long dialogId, final int folderId) {
        if (peers == null && inputPeers == null && dialogId == 0) {
            return;
        }
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$obNe2jXw4vkR0Wa1lrU6QdvDDP0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setDialogsFolderId$176$MessagesStorage(peers, inputPeers, folderId, dialogId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setDialogsFolderId$176, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setDialogsFolderId$176$MessagesStorage(ArrayList arrayList, ArrayList arrayList2, int i, long j) {
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
            lambda$checkIfFolderEmpty$178(1);
            resetAllUnreadCounters(false);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: checkIfFolderEmptyInternal, reason: merged with bridge method [inline-methods] */
    public void lambda$checkIfFolderEmpty$178$MessagesStorage(final int folderId) {
        try {
            boolean z = true;
            SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized("SELECT did FROM dialogs WHERE folder_id = ?", Integer.valueOf(folderId));
            while (sQLiteCursorQueryFinalized.next()) {
                long jLongValue = sQLiteCursorQueryFinalized.longValue(0);
                if (!DialogObject.isUserDialog(jLongValue) && !DialogObject.isEncryptedDialog(jLongValue)) {
                    TLRPC$Chat chat = getChat(-jLongValue);
                    if (ChatObject.isNotInChat(chat) || chat.migrated_to != null) {
                    }
                }
                z = false;
            }
            sQLiteCursorQueryFinalized.dispose();
            if (z) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$A8GtOJeJkDXVIwFEF-goLbxaaC4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$checkIfFolderEmptyInternal$177$MessagesStorage(folderId);
                    }
                });
                this.database.executeFast("DELETE FROM dialogs WHERE did = " + DialogObject.makeFolderDialogId(folderId)).stepThis().dispose();
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkIfFolderEmptyInternal$177, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkIfFolderEmptyInternal$177$MessagesStorage(int i) {
        getMessagesController().onFolderEmpty(i);
    }

    public void checkIfFolderEmpty(final int folderId) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$DeYQA9oGF4YZzEH20hO4l49PqII
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$checkIfFolderEmpty$178$MessagesStorage(folderId);
            }
        });
    }

    public void unpinAllDialogsExceptNew(final ArrayList<Long> dids, final int folderId) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$7t3WPgNAZU4frtOch5M03XDaZNI
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$unpinAllDialogsExceptNew$179$MessagesStorage(dids, folderId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$unpinAllDialogsExceptNew$179, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$unpinAllDialogsExceptNew$179$MessagesStorage(ArrayList arrayList, int i) {
        try {
            ArrayList arrayList2 = new ArrayList();
            SQLiteCursor sQLiteCursorQueryFinalized = this.database.queryFinalized(String.format(Locale.US, "SELECT did, folder_id FROM dialogs WHERE pinned > 0 AND did NOT IN (%s)", TextUtils.join(",", arrayList)), new Object[0]);
            while (sQLiteCursorQueryFinalized.next()) {
                long jLongValue = sQLiteCursorQueryFinalized.longValue(0);
                if (sQLiteCursorQueryFinalized.intValue(1) == i && !DialogObject.isEncryptedDialog(jLongValue) && !DialogObject.isFolderDialogId(jLongValue)) {
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

    public void setDialogUnread(final long did, final boolean unread) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$N4AxSrXT7Kn9VwelMfkLHNhZtAc
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setDialogUnread$180$MessagesStorage(did, unread);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Finally extract failed */
    /* renamed from: lambda$setDialogUnread$180, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setDialogUnread$180$MessagesStorage(long j, boolean z) {
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

    private void resetAllUnreadCounters(boolean muted) {
        int size = this.dialogFilters.size();
        for (int i = 0; i < size; i++) {
            MessagesController.DialogFilter dialogFilter = this.dialogFilters.get(i);
            if (muted) {
                if ((dialogFilter.flags & MessagesController.DIALOG_FILTER_FLAG_EXCLUDE_MUTED) != 0) {
                    dialogFilter.pendingUnreadCount = -1;
                }
            } else {
                dialogFilter.pendingUnreadCount = -1;
            }
        }
        calcUnreadCounters(false);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$3RT6ItH-Nlw94CLZ4Dlm5D5216s
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$resetAllUnreadCounters$181$MessagesStorage();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$resetAllUnreadCounters$181, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$resetAllUnreadCounters$181$MessagesStorage() {
        ArrayList<MessagesController.DialogFilter> arrayList = getMessagesController().dialogFilters;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList.get(i).unreadCount = arrayList.get(i).pendingUnreadCount;
        }
        this.mainUnreadCount = this.pendingMainUnreadCount;
        this.archiveUnreadCount = this.pendingArchiveUnreadCount;
        getNotificationCenter().postNotificationName(NotificationCenter.updateInterfaces, Integer.valueOf(MessagesController.UPDATE_MASK_READ_DIALOG_MESSAGE));
    }

    public void setDialogPinned(final long did, final int pinned) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$NSI9TWj8NV0XRMfyJGYjAGKb9d0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setDialogPinned$182$MessagesStorage(pinned, did);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setDialogPinned$182, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setDialogPinned$182$MessagesStorage(int i, long j) {
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

    public void setDialogsPinned(final ArrayList<Long> dids, final ArrayList<Integer> pinned) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$-lgaQVoyOeh2is-CKA8kR9Atp0w
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setDialogsPinned$183$MessagesStorage(dids, pinned);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setDialogsPinned$183, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setDialogsPinned$183$MessagesStorage(ArrayList arrayList, ArrayList arrayList2) {
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

    public void putDialogs(final TLRPC$messages_Dialogs dialogs, final int check) {
        if (dialogs.dialogs.isEmpty()) {
            return;
        }
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$mzRsKRR0y2qm9UnbmImRfOmUGPI
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$putDialogs$184$MessagesStorage(dialogs, check);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$putDialogs$184, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$putDialogs$184$MessagesStorage(TLRPC$messages_Dialogs tLRPC$messages_Dialogs, int i) {
        putDialogsInternal(tLRPC$messages_Dialogs, i);
        try {
            loadUnreadMessages();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void getDialogMaxMessageId(final long dialog_id, final IntCallback callback) {
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$ZSQJdtnH0ckqN39hYMaNv2vMQ2s
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getDialogMaxMessageId$186$MessagesStorage(dialog_id, callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getDialogMaxMessageId$186, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getDialogMaxMessageId$186$MessagesStorage(long j, final IntCallback intCallback) {
        final int[] iArr = new int[1];
        SQLiteCursor sQLiteCursorQueryFinalized = null;
        try {
            try {
                sQLiteCursorQueryFinalized = this.database.queryFinalized("SELECT MAX(mid) FROM messages_v2 WHERE uid = " + j, new Object[0]);
                if (sQLiteCursorQueryFinalized.next()) {
                    iArr[0] = sQLiteCursorQueryFinalized.intValue(0);
                }
            } catch (Exception e) {
                FileLog.e(e);
                if (sQLiteCursorQueryFinalized != null) {
                }
            }
            sQLiteCursorQueryFinalized.dispose();
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$IYPGnajR9hmLTHWT5i4zu_uNG44
                @Override // java.lang.Runnable
                public final void run() {
                    intCallback.run(iArr[0]);
                }
            });
        } catch (Throwable th) {
            if (sQLiteCursorQueryFinalized != null) {
                sQLiteCursorQueryFinalized.dispose();
            }
            throw th;
        }
    }

    public int getDialogReadMax(final boolean outbox, final long dialog_id) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final Integer[] numArr = {0};
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$9wmU20aHMoPF9GKBfbZfbgJAdYs
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getDialogReadMax$187$MessagesStorage(outbox, dialog_id, numArr, countDownLatch);
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
    /* renamed from: lambda$getDialogReadMax$187, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getDialogReadMax$187$MessagesStorage(boolean z, long j, Integer[] numArr, CountDownLatch countDownLatch) {
        SQLiteCursor sQLiteCursorQueryFinalized;
        SQLiteCursor sQLiteCursor = null;
        try {
            try {
                if (z) {
                    sQLiteCursorQueryFinalized = this.database.queryFinalized("SELECT outbox_max FROM dialogs WHERE did = " + j, new Object[0]);
                } else {
                    sQLiteCursorQueryFinalized = this.database.queryFinalized("SELECT inbox_max FROM dialogs WHERE did = " + j, new Object[0]);
                }
                sQLiteCursor = sQLiteCursorQueryFinalized;
                if (sQLiteCursor.next()) {
                    numArr[0] = Integer.valueOf(sQLiteCursor.intValue(0));
                }
            } catch (Exception e) {
                FileLog.e(e);
                if (sQLiteCursor != null) {
                }
            }
            sQLiteCursor.dispose();
            countDownLatch.countDown();
        } catch (Throwable th) {
            if (sQLiteCursor != null) {
                sQLiteCursor.dispose();
            }
            throw th;
        }
    }

    public int getChannelPtsSync(final long channelId) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final Integer[] numArr = {0};
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$YTFkZYupc5_pQTR9jmULlGfP1tY
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getChannelPtsSync$188$MessagesStorage(channelId, numArr, countDownLatch);
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
    /* renamed from: lambda$getChannelPtsSync$188, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getChannelPtsSync$188$MessagesStorage(long j, Integer[] numArr, CountDownLatch countDownLatch) {
        SQLiteCursor sQLiteCursorQueryFinalized = null;
        try {
            try {
                sQLiteCursorQueryFinalized = this.database.queryFinalized("SELECT pts FROM dialogs WHERE did = " + (-j), new Object[0]);
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

    public TLRPC$User getUserSync(final long userId) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final TLRPC$User[] tLRPC$UserArr = new TLRPC$User[1];
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$mbJKl1WQZmwsEsI8gqE8dCagwak
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getUserSync$189$MessagesStorage(tLRPC$UserArr, userId, countDownLatch);
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
    /* renamed from: lambda$getUserSync$189, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getUserSync$189$MessagesStorage(TLRPC$User[] tLRPC$UserArr, long j, CountDownLatch countDownLatch) {
        tLRPC$UserArr[0] = getUser(j);
        countDownLatch.countDown();
    }

    public TLRPC$Chat getChatSync(final long chatId) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final TLRPC$Chat[] tLRPC$ChatArr = new TLRPC$Chat[1];
        this.storageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$MessagesStorage$yhm7viQJKgWy0nosbQlWIl419Ng
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getChatSync$190$MessagesStorage(tLRPC$ChatArr, chatId, countDownLatch);
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
    /* renamed from: lambda$getChatSync$190, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getChatSync$190$MessagesStorage(TLRPC$Chat[] tLRPC$ChatArr, long j, CountDownLatch countDownLatch) {
        tLRPC$ChatArr[0] = getChat(j);
        countDownLatch.countDown();
    }

    public TLRPC$User getUser(long userId) {
        try {
            ArrayList<TLRPC$User> arrayList = new ArrayList<>();
            getUsersInternal("" + userId, arrayList);
            if (arrayList.isEmpty()) {
                return null;
            }
            return arrayList.get(0);
        } catch (Exception e) {
            FileLog.e(e);
            return null;
        }
    }

    public ArrayList<TLRPC$User> getUsers(ArrayList<Long> uids) {
        ArrayList<TLRPC$User> arrayList = new ArrayList<>();
        try {
            getUsersInternal(TextUtils.join(",", uids), arrayList);
        } catch (Exception e) {
            arrayList.clear();
            FileLog.e(e);
        }
        return arrayList;
    }

    public TLRPC$Chat getChat(long chatId) {
        try {
            ArrayList<TLRPC$Chat> arrayList = new ArrayList<>();
            getChatsInternal("" + chatId, arrayList);
            if (arrayList.isEmpty()) {
                return null;
            }
            return arrayList.get(0);
        } catch (Exception e) {
            FileLog.e(e);
            return null;
        }
    }

    public TLRPC$EncryptedChat getEncryptedChat(long chatId) {
        try {
            ArrayList<TLRPC$EncryptedChat> arrayList = new ArrayList<>();
            getEncryptedChatsInternal("" + chatId, arrayList, null);
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
    /* JADX WARN: Removed duplicated region for block: B:213:0x04ad  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x05df A[Catch: Exception -> 0x07d7, LOOP:10: B:197:0x0464->B:236:0x05df, LOOP_END, TryCatch #0 {Exception -> 0x07d7, blocks: (B:3:0x0014, B:6:0x0023, B:8:0x0040, B:15:0x004e, B:17:0x0055, B:18:0x0057, B:20:0x006d, B:22:0x0094, B:24:0x009a, B:26:0x00b6, B:35:0x00c7, B:37:0x00d1, B:41:0x00dd, B:43:0x00e8, B:47:0x00f5, B:49:0x0103, B:51:0x010d, B:53:0x0113, B:57:0x011f, B:59:0x013f, B:62:0x014d, B:63:0x016b, B:65:0x0171, B:68:0x0185, B:70:0x018c, B:74:0x0198, B:75:0x01b0, B:77:0x01b3, B:79:0x01bb, B:82:0x01d4, B:84:0x01da, B:88:0x01f2, B:90:0x01f8, B:95:0x0204, B:94:0x0200, B:98:0x020e, B:100:0x0214, B:105:0x021d, B:107:0x0222, B:109:0x0229, B:111:0x0242, B:113:0x024e, B:114:0x0255, B:126:0x02c4, B:127:0x02c6, B:118:0x026a, B:120:0x0271, B:122:0x0288, B:124:0x0294, B:125:0x029b, B:129:0x02e1, B:131:0x0301, B:133:0x0307, B:134:0x0327, B:136:0x032d, B:141:0x0346, B:142:0x0354, B:144:0x0357, B:146:0x035f, B:149:0x0378, B:151:0x037e, B:157:0x0399, B:158:0x03a0, B:160:0x03a6, B:165:0x03af, B:167:0x03b4, B:169:0x03bb, B:171:0x03cd, B:173:0x03d3, B:175:0x03d9, B:177:0x03e3, B:178:0x03f7, B:181:0x0407, B:183:0x0411, B:185:0x0417, B:186:0x0435, B:188:0x043b, B:192:0x0451, B:194:0x045a, B:199:0x0468, B:201:0x0470, B:204:0x0487, B:206:0x048d, B:210:0x04a5, B:215:0x04b0, B:217:0x04b7, B:219:0x04c5, B:221:0x04cc, B:225:0x04de, B:227:0x0569, B:228:0x056b, B:230:0x0577, B:233:0x0581, B:235:0x05d5, B:234:0x05ac, B:236:0x05df, B:239:0x05f5, B:241:0x0605, B:242:0x060b, B:244:0x0611, B:246:0x061b, B:248:0x061f, B:249:0x0622, B:250:0x0625, B:251:0x062b, B:253:0x0631, B:256:0x0651, B:257:0x065e, B:259:0x0664, B:262:0x0670, B:265:0x0684, B:267:0x068b, B:271:0x0698, B:272:0x06a8, B:274:0x06ab, B:276:0x06b3, B:279:0x06cc, B:281:0x06d2, B:285:0x06ea, B:287:0x06f0, B:296:0x070b, B:298:0x0711, B:303:0x071c, B:305:0x0721, B:307:0x0728, B:309:0x0737, B:310:0x073e, B:312:0x0755, B:327:0x07c7, B:325:0x07b7, B:315:0x075c, B:317:0x0763, B:319:0x0773, B:320:0x0779, B:322:0x07ad, B:294:0x0705, B:328:0x07d3, B:55:0x0119, B:21:0x0085), top: B:333:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:296:0x070b A[Catch: Exception -> 0x07d7, TryCatch #0 {Exception -> 0x07d7, blocks: (B:3:0x0014, B:6:0x0023, B:8:0x0040, B:15:0x004e, B:17:0x0055, B:18:0x0057, B:20:0x006d, B:22:0x0094, B:24:0x009a, B:26:0x00b6, B:35:0x00c7, B:37:0x00d1, B:41:0x00dd, B:43:0x00e8, B:47:0x00f5, B:49:0x0103, B:51:0x010d, B:53:0x0113, B:57:0x011f, B:59:0x013f, B:62:0x014d, B:63:0x016b, B:65:0x0171, B:68:0x0185, B:70:0x018c, B:74:0x0198, B:75:0x01b0, B:77:0x01b3, B:79:0x01bb, B:82:0x01d4, B:84:0x01da, B:88:0x01f2, B:90:0x01f8, B:95:0x0204, B:94:0x0200, B:98:0x020e, B:100:0x0214, B:105:0x021d, B:107:0x0222, B:109:0x0229, B:111:0x0242, B:113:0x024e, B:114:0x0255, B:126:0x02c4, B:127:0x02c6, B:118:0x026a, B:120:0x0271, B:122:0x0288, B:124:0x0294, B:125:0x029b, B:129:0x02e1, B:131:0x0301, B:133:0x0307, B:134:0x0327, B:136:0x032d, B:141:0x0346, B:142:0x0354, B:144:0x0357, B:146:0x035f, B:149:0x0378, B:151:0x037e, B:157:0x0399, B:158:0x03a0, B:160:0x03a6, B:165:0x03af, B:167:0x03b4, B:169:0x03bb, B:171:0x03cd, B:173:0x03d3, B:175:0x03d9, B:177:0x03e3, B:178:0x03f7, B:181:0x0407, B:183:0x0411, B:185:0x0417, B:186:0x0435, B:188:0x043b, B:192:0x0451, B:194:0x045a, B:199:0x0468, B:201:0x0470, B:204:0x0487, B:206:0x048d, B:210:0x04a5, B:215:0x04b0, B:217:0x04b7, B:219:0x04c5, B:221:0x04cc, B:225:0x04de, B:227:0x0569, B:228:0x056b, B:230:0x0577, B:233:0x0581, B:235:0x05d5, B:234:0x05ac, B:236:0x05df, B:239:0x05f5, B:241:0x0605, B:242:0x060b, B:244:0x0611, B:246:0x061b, B:248:0x061f, B:249:0x0622, B:250:0x0625, B:251:0x062b, B:253:0x0631, B:256:0x0651, B:257:0x065e, B:259:0x0664, B:262:0x0670, B:265:0x0684, B:267:0x068b, B:271:0x0698, B:272:0x06a8, B:274:0x06ab, B:276:0x06b3, B:279:0x06cc, B:281:0x06d2, B:285:0x06ea, B:287:0x06f0, B:296:0x070b, B:298:0x0711, B:303:0x071c, B:305:0x0721, B:307:0x0728, B:309:0x0737, B:310:0x073e, B:312:0x0755, B:327:0x07c7, B:325:0x07b7, B:315:0x075c, B:317:0x0763, B:319:0x0773, B:320:0x0779, B:322:0x07ad, B:294:0x0705, B:328:0x07d3, B:55:0x0119, B:21:0x0085), top: B:333:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:313:0x0759  */
    /* JADX WARN: Removed duplicated region for block: B:383:0x04b0 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r14v36 */
    /* JADX WARN: Type inference failed for: r14v37 */
    /* JADX WARN: Type inference failed for: r14v39 */
    /* JADX WARN: Type inference failed for: r14v40 */
    /* JADX WARN: Type inference failed for: r14v41 */
    /* JADX WARN: Type inference failed for: r14v43 */
    /* JADX WARN: Type inference failed for: r15v12 */
    /* JADX WARN: Type inference failed for: r15v15 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r31v0, types: [java.util.ArrayList, java.util.ArrayList<java.lang.Object>] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void localSearchFull(int r28, java.lang.String r29, boolean r30, java.util.ArrayList<java.lang.Object> r31, java.util.ArrayList<java.lang.CharSequence> r32, java.util.ArrayList<ir.eitaa.tgnet.TLRPC$User> r33, int r34) {
        /*
            Method dump skipped, instructions count: 2012
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessagesStorage.localSearchFull(int, java.lang.String, boolean, java.util.ArrayList, java.util.ArrayList, java.util.ArrayList, int):void");
    }

    static /* synthetic */ int lambda$localSearchFull$191(DialogsSearchAdapter.DialogSearchResult dialogSearchResult, DialogsSearchAdapter.DialogSearchResult dialogSearchResult2) {
        int i = dialogSearchResult.date;
        int i2 = dialogSearchResult2.date;
        if (i < i2) {
            return 1;
        }
        return i > i2 ? -1 : 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0250 A[Catch: Exception -> 0x0654, LOOP:2: B:74:0x01a1->B:101:0x0250, LOOP_END, TryCatch #0 {Exception -> 0x0654, blocks: (B:3:0x0012, B:6:0x0021, B:8:0x003e, B:15:0x004c, B:17:0x0053, B:18:0x0055, B:20:0x006b, B:22:0x0092, B:24:0x0098, B:26:0x00b6, B:35:0x00c7, B:37:0x00d1, B:41:0x00df, B:43:0x00ec, B:48:0x00fb, B:50:0x0109, B:52:0x0115, B:54:0x011e, B:58:0x012a, B:60:0x014a, B:63:0x0158, B:64:0x0174, B:66:0x017a, B:69:0x018e, B:71:0x0195, B:75:0x01a3, B:77:0x01ad, B:80:0x01c4, B:82:0x01ca, B:86:0x01e2, B:92:0x01f0, B:94:0x01f7, B:96:0x0211, B:98:0x0219, B:100:0x024b, B:99:0x0224, B:101:0x0250, B:104:0x0267, B:106:0x0273, B:108:0x0279, B:109:0x0295, B:111:0x029b, B:116:0x02b2, B:118:0x02ba, B:121:0x02d1, B:123:0x02d7, B:126:0x02ed, B:127:0x02f0, B:129:0x02f7, B:131:0x0304, B:133:0x0308, B:135:0x030e, B:137:0x0314, B:138:0x032c, B:139:0x032f, B:141:0x0335, B:142:0x0351, B:144:0x0357, B:148:0x036d, B:150:0x0376, B:154:0x0382, B:156:0x038a, B:159:0x03a1, B:161:0x03a7, B:165:0x03bf, B:170:0x03ca, B:172:0x03d1, B:174:0x03df, B:176:0x03e6, B:180:0x03f8, B:182:0x0483, B:183:0x0485, B:185:0x0491, B:188:0x049b, B:190:0x04eb, B:189:0x04c4, B:191:0x04f5, B:194:0x0503, B:196:0x050b, B:197:0x0511, B:199:0x0517, B:201:0x0521, B:203:0x0525, B:204:0x0528, B:205:0x052b, B:206:0x0531, B:208:0x0537, B:211:0x0557, B:212:0x0564, B:214:0x056a, B:217:0x0576, B:220:0x058a, B:222:0x0591, B:226:0x059d, B:228:0x05a5, B:231:0x05bc, B:233:0x05c2, B:237:0x05da, B:242:0x05e5, B:244:0x05ec, B:246:0x05fc, B:248:0x0604, B:250:0x0639, B:249:0x0611, B:252:0x0640, B:255:0x0650, B:56:0x0124, B:21:0x0083), top: B:260:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x04f5 A[Catch: Exception -> 0x0654, LOOP:6: B:153:0x0380->B:191:0x04f5, LOOP_END, TryCatch #0 {Exception -> 0x0654, blocks: (B:3:0x0012, B:6:0x0021, B:8:0x003e, B:15:0x004c, B:17:0x0053, B:18:0x0055, B:20:0x006b, B:22:0x0092, B:24:0x0098, B:26:0x00b6, B:35:0x00c7, B:37:0x00d1, B:41:0x00df, B:43:0x00ec, B:48:0x00fb, B:50:0x0109, B:52:0x0115, B:54:0x011e, B:58:0x012a, B:60:0x014a, B:63:0x0158, B:64:0x0174, B:66:0x017a, B:69:0x018e, B:71:0x0195, B:75:0x01a3, B:77:0x01ad, B:80:0x01c4, B:82:0x01ca, B:86:0x01e2, B:92:0x01f0, B:94:0x01f7, B:96:0x0211, B:98:0x0219, B:100:0x024b, B:99:0x0224, B:101:0x0250, B:104:0x0267, B:106:0x0273, B:108:0x0279, B:109:0x0295, B:111:0x029b, B:116:0x02b2, B:118:0x02ba, B:121:0x02d1, B:123:0x02d7, B:126:0x02ed, B:127:0x02f0, B:129:0x02f7, B:131:0x0304, B:133:0x0308, B:135:0x030e, B:137:0x0314, B:138:0x032c, B:139:0x032f, B:141:0x0335, B:142:0x0351, B:144:0x0357, B:148:0x036d, B:150:0x0376, B:154:0x0382, B:156:0x038a, B:159:0x03a1, B:161:0x03a7, B:165:0x03bf, B:170:0x03ca, B:172:0x03d1, B:174:0x03df, B:176:0x03e6, B:180:0x03f8, B:182:0x0483, B:183:0x0485, B:185:0x0491, B:188:0x049b, B:190:0x04eb, B:189:0x04c4, B:191:0x04f5, B:194:0x0503, B:196:0x050b, B:197:0x0511, B:199:0x0517, B:201:0x0521, B:203:0x0525, B:204:0x0528, B:205:0x052b, B:206:0x0531, B:208:0x0537, B:211:0x0557, B:212:0x0564, B:214:0x056a, B:217:0x0576, B:220:0x058a, B:222:0x0591, B:226:0x059d, B:228:0x05a5, B:231:0x05bc, B:233:0x05c2, B:237:0x05da, B:242:0x05e5, B:244:0x05ec, B:246:0x05fc, B:248:0x0604, B:250:0x0639, B:249:0x0611, B:252:0x0640, B:255:0x0650, B:56:0x0124, B:21:0x0083), top: B:260:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:240:0x05e2  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0640 A[Catch: Exception -> 0x0654, LOOP:10: B:225:0x059b->B:252:0x0640, LOOP_END, TryCatch #0 {Exception -> 0x0654, blocks: (B:3:0x0012, B:6:0x0021, B:8:0x003e, B:15:0x004c, B:17:0x0053, B:18:0x0055, B:20:0x006b, B:22:0x0092, B:24:0x0098, B:26:0x00b6, B:35:0x00c7, B:37:0x00d1, B:41:0x00df, B:43:0x00ec, B:48:0x00fb, B:50:0x0109, B:52:0x0115, B:54:0x011e, B:58:0x012a, B:60:0x014a, B:63:0x0158, B:64:0x0174, B:66:0x017a, B:69:0x018e, B:71:0x0195, B:75:0x01a3, B:77:0x01ad, B:80:0x01c4, B:82:0x01ca, B:86:0x01e2, B:92:0x01f0, B:94:0x01f7, B:96:0x0211, B:98:0x0219, B:100:0x024b, B:99:0x0224, B:101:0x0250, B:104:0x0267, B:106:0x0273, B:108:0x0279, B:109:0x0295, B:111:0x029b, B:116:0x02b2, B:118:0x02ba, B:121:0x02d1, B:123:0x02d7, B:126:0x02ed, B:127:0x02f0, B:129:0x02f7, B:131:0x0304, B:133:0x0308, B:135:0x030e, B:137:0x0314, B:138:0x032c, B:139:0x032f, B:141:0x0335, B:142:0x0351, B:144:0x0357, B:148:0x036d, B:150:0x0376, B:154:0x0382, B:156:0x038a, B:159:0x03a1, B:161:0x03a7, B:165:0x03bf, B:170:0x03ca, B:172:0x03d1, B:174:0x03df, B:176:0x03e6, B:180:0x03f8, B:182:0x0483, B:183:0x0485, B:185:0x0491, B:188:0x049b, B:190:0x04eb, B:189:0x04c4, B:191:0x04f5, B:194:0x0503, B:196:0x050b, B:197:0x0511, B:199:0x0517, B:201:0x0521, B:203:0x0525, B:204:0x0528, B:205:0x052b, B:206:0x0531, B:208:0x0537, B:211:0x0557, B:212:0x0564, B:214:0x056a, B:217:0x0576, B:220:0x058a, B:222:0x0591, B:226:0x059d, B:228:0x05a5, B:231:0x05bc, B:233:0x05c2, B:237:0x05da, B:242:0x05e5, B:244:0x05ec, B:246:0x05fc, B:248:0x0604, B:250:0x0639, B:249:0x0611, B:252:0x0640, B:255:0x0650, B:56:0x0124, B:21:0x0083), top: B:260:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:274:0x01f0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:297:0x03ca A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:311:0x05e5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01ed  */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r25v0, types: [java.util.ArrayList, java.util.ArrayList<java.lang.Object>] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void localSearch(int r23, java.lang.String r24, java.util.ArrayList<java.lang.Object> r25, java.util.ArrayList<java.lang.CharSequence> r26, java.util.ArrayList<ir.eitaa.tgnet.TLRPC$User> r27, int r28) {
        /*
            Method dump skipped, instructions count: 1625
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessagesStorage.localSearch(int, java.lang.String, java.util.ArrayList, java.util.ArrayList, java.util.ArrayList, int):void");
    }

    static /* synthetic */ int lambda$localSearch$192(DialogsSearchAdapter.DialogSearchResult dialogSearchResult, DialogsSearchAdapter.DialogSearchResult dialogSearchResult2) {
        int i = dialogSearchResult.date;
        int i2 = dialogSearchResult2.date;
        if (i < i2) {
            return 1;
        }
        return i > i2 ? -1 : 0;
    }

    private boolean isAllowedToShowChatInSearch(Long id, boolean isForward) {
        return !getMessagesController().isLockedDialog(id) || (isForward && SharedConfig.showLockedChatsWhenForward);
    }

    public String getFilterName(int flag) {
        if (flag == 131) {
            return LocaleController.getString("UserFilter", R.string.UserFilter);
        }
        if (flag == 132) {
            return LocaleController.getString("GroupFilter", R.string.GroupFilter);
        }
        if (flag == 136) {
            return LocaleController.getString("ChannelFilter", R.string.ChannelFilter);
        }
        if (flag == 239) {
            return LocaleController.getString("UnreadFilter", R.string.UnreadFilter);
        }
        if (flag == 640) {
            return LocaleController.getString("AdminFilter", R.string.AdminFilter);
        }
        if (flag != 1152) {
            return flag != 2176 ? "" : LocaleController.getString("SocialMediaFilter", R.string.SocialMediaFilter);
        }
        return LocaleController.getString("FavoriteFilter", R.string.FavoriteFilter);
    }
}
