package ir.eitaa.messenger;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.util.SparseArray;
import android.util.SparseIntArray;
import ir.eitaa.SQLite.SQLiteCursor;
import ir.eitaa.messenger.SendMessagesHelper;
import ir.eitaa.messenger.support.LongSparseIntArray;
import ir.eitaa.tgnet.AbstractSerializedData;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.NativeByteBuffer;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$DecryptedMessage;
import ir.eitaa.tgnet.TLRPC$DecryptedMessageAction;
import ir.eitaa.tgnet.TLRPC$DecryptedMessageMedia;
import ir.eitaa.tgnet.TLRPC$Dialog;
import ir.eitaa.tgnet.TLRPC$Document;
import ir.eitaa.tgnet.TLRPC$EncryptedChat;
import ir.eitaa.tgnet.TLRPC$EncryptedFile;
import ir.eitaa.tgnet.TLRPC$InputEncryptedFile;
import ir.eitaa.tgnet.TLRPC$Message;
import ir.eitaa.tgnet.TLRPC$MessageAction;
import ir.eitaa.tgnet.TLRPC$MessageMedia;
import ir.eitaa.tgnet.TLRPC$Photo;
import ir.eitaa.tgnet.TLRPC$PhotoSize;
import ir.eitaa.tgnet.TLRPC$TL_decryptedMessageActionAbortKey;
import ir.eitaa.tgnet.TLRPC$TL_decryptedMessageActionAcceptKey;
import ir.eitaa.tgnet.TLRPC$TL_decryptedMessageActionCommitKey;
import ir.eitaa.tgnet.TLRPC$TL_decryptedMessageActionDeleteMessages;
import ir.eitaa.tgnet.TLRPC$TL_decryptedMessageActionFlushHistory;
import ir.eitaa.tgnet.TLRPC$TL_decryptedMessageActionNoop;
import ir.eitaa.tgnet.TLRPC$TL_decryptedMessageActionNotifyLayer;
import ir.eitaa.tgnet.TLRPC$TL_decryptedMessageActionReadMessages;
import ir.eitaa.tgnet.TLRPC$TL_decryptedMessageActionRequestKey;
import ir.eitaa.tgnet.TLRPC$TL_decryptedMessageActionResend;
import ir.eitaa.tgnet.TLRPC$TL_decryptedMessageActionScreenshotMessages;
import ir.eitaa.tgnet.TLRPC$TL_decryptedMessageActionSetMessageTTL;
import ir.eitaa.tgnet.TLRPC$TL_decryptedMessageLayer;
import ir.eitaa.tgnet.TLRPC$TL_decryptedMessageService;
import ir.eitaa.tgnet.TLRPC$TL_dialog;
import ir.eitaa.tgnet.TLRPC$TL_documentEncrypted;
import ir.eitaa.tgnet.TLRPC$TL_encryptedChat;
import ir.eitaa.tgnet.TLRPC$TL_encryptedChatDiscarded;
import ir.eitaa.tgnet.TLRPC$TL_encryptedChatRequested;
import ir.eitaa.tgnet.TLRPC$TL_encryptedChatWaiting;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_fileEncryptedLocation;
import ir.eitaa.tgnet.TLRPC$TL_inputEncryptedChat;
import ir.eitaa.tgnet.TLRPC$TL_messageEncryptedAction;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaDocument;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaPhoto;
import ir.eitaa.tgnet.TLRPC$TL_messageService;
import ir.eitaa.tgnet.TLRPC$TL_messages_acceptEncryption;
import ir.eitaa.tgnet.TLRPC$TL_messages_dhConfig;
import ir.eitaa.tgnet.TLRPC$TL_messages_discardEncryption;
import ir.eitaa.tgnet.TLRPC$TL_messages_getDhConfig;
import ir.eitaa.tgnet.TLRPC$TL_messages_requestEncryption;
import ir.eitaa.tgnet.TLRPC$TL_messages_sendEncrypted;
import ir.eitaa.tgnet.TLRPC$TL_messages_sendEncryptedFile;
import ir.eitaa.tgnet.TLRPC$TL_messages_sendEncryptedMultiMedia;
import ir.eitaa.tgnet.TLRPC$TL_messages_sendEncryptedService;
import ir.eitaa.tgnet.TLRPC$TL_peerUser;
import ir.eitaa.tgnet.TLRPC$TL_photoSizeEmpty;
import ir.eitaa.tgnet.TLRPC$TL_updateEncryption;
import ir.eitaa.tgnet.TLRPC$Update;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.tgnet.TLRPC$messages_DhConfig;
import ir.eitaa.tgnet.TLRPC$messages_SentEncryptedMessage;
import ir.eitaa.ui.ActionBar.AlertDialog;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
public class SecretChatHelper extends BaseController {
    public static int CURRENT_SECRET_CHAT_LAYER = 101;
    private static volatile SecretChatHelper[] Instance = new SecretChatHelper[3];
    private SparseArray<TLRPC$EncryptedChat> acceptingChats;
    public ArrayList<TLRPC$Update> delayedEncryptedChatUpdates;
    private ArrayList<Long> pendingEncMessagesToDelete;
    private SparseArray<ArrayList<TLRPC$Update>> pendingSecretMessages;
    private SparseArray<SparseIntArray> requestedHoles;
    private SparseArray<ArrayList<TL_decryptedMessageHolder>> secretHolesQueue;
    private ArrayList<Integer> sendingNotifyLayer;
    private boolean startingSecretChat;

    public static class TL_decryptedMessageHolder extends TLObject {
        public static int constructor = 1431655929;
        public int date;
        public int decryptedWithVersion;
        public TLRPC$EncryptedFile file;
        public TLRPC$TL_decryptedMessageLayer layer;
        public boolean new_key_used;

        @Override // ir.eitaa.tgnet.TLObject
        public void readParams(AbstractSerializedData stream, boolean exception) {
            stream.readInt64(exception);
            this.date = stream.readInt32(exception);
            this.layer = TLRPC$TL_decryptedMessageLayer.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (stream.readBool(exception)) {
                this.file = TLRPC$EncryptedFile.TLdeserialize(stream, stream.readInt32(exception), exception);
            }
            this.new_key_used = stream.readBool(exception);
        }

        @Override // ir.eitaa.tgnet.TLObject
        public void serializeToStream(AbstractSerializedData stream) {
            stream.writeInt32(constructor);
            stream.writeInt64(0L);
            stream.writeInt32(this.date);
            this.layer.serializeToStream(stream);
            stream.writeBool(this.file != null);
            TLRPC$EncryptedFile tLRPC$EncryptedFile = this.file;
            if (tLRPC$EncryptedFile != null) {
                tLRPC$EncryptedFile.serializeToStream(stream);
            }
            stream.writeBool(this.new_key_used);
        }
    }

    public static SecretChatHelper getInstance(int num) {
        SecretChatHelper secretChatHelper = Instance[num];
        if (secretChatHelper == null) {
            synchronized (SecretChatHelper.class) {
                secretChatHelper = Instance[num];
                if (secretChatHelper == null) {
                    SecretChatHelper[] secretChatHelperArr = Instance;
                    SecretChatHelper secretChatHelper2 = new SecretChatHelper(num);
                    secretChatHelperArr[num] = secretChatHelper2;
                    secretChatHelper = secretChatHelper2;
                }
            }
        }
        return secretChatHelper;
    }

    public SecretChatHelper(int instance) {
        super(instance);
        this.sendingNotifyLayer = new ArrayList<>();
        this.secretHolesQueue = new SparseArray<>();
        this.pendingSecretMessages = new SparseArray<>();
        this.requestedHoles = new SparseArray<>();
        this.acceptingChats = new SparseArray<>();
        this.delayedEncryptedChatUpdates = new ArrayList<>();
        this.pendingEncMessagesToDelete = new ArrayList<>();
        this.startingSecretChat = false;
    }

    public void cleanup() {
        this.sendingNotifyLayer.clear();
        this.acceptingChats.clear();
        this.secretHolesQueue.clear();
        this.pendingSecretMessages.clear();
        this.requestedHoles.clear();
        this.delayedEncryptedChatUpdates.clear();
        this.pendingEncMessagesToDelete.clear();
        this.startingSecretChat = false;
    }

    protected void processPendingEncMessages() {
        if (this.pendingEncMessagesToDelete.isEmpty()) {
            return;
        }
        final ArrayList arrayList = new ArrayList(this.pendingEncMessagesToDelete);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SecretChatHelper$c3k3kJWh7KyBzC4ypDrZnJObtiI
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processPendingEncMessages$0$SecretChatHelper(arrayList);
            }
        });
        getMessagesStorage().markMessagesAsDeletedByRandoms(new ArrayList<>(this.pendingEncMessagesToDelete));
        this.pendingEncMessagesToDelete.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processPendingEncMessages$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processPendingEncMessages$0$SecretChatHelper(ArrayList arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            MessageObject messageObject = getMessagesController().dialogMessagesByRandomIds.get(((Long) arrayList.get(i)).longValue());
            if (messageObject != null) {
                messageObject.deleted = true;
            }
        }
    }

    private TLRPC$TL_messageService createServiceSecretMessage(TLRPC$EncryptedChat encryptedChat, TLRPC$DecryptedMessageAction decryptedMessage) {
        TLRPC$TL_messageService tLRPC$TL_messageService = new TLRPC$TL_messageService();
        TLRPC$TL_messageEncryptedAction tLRPC$TL_messageEncryptedAction = new TLRPC$TL_messageEncryptedAction();
        tLRPC$TL_messageService.action = tLRPC$TL_messageEncryptedAction;
        tLRPC$TL_messageEncryptedAction.encryptedAction = decryptedMessage;
        int newMessageId = getUserConfig().getNewMessageId();
        tLRPC$TL_messageService.id = newMessageId;
        tLRPC$TL_messageService.local_id = newMessageId;
        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
        tLRPC$TL_messageService.from_id = tLRPC$TL_peerUser;
        tLRPC$TL_peerUser.user_id = getUserConfig().getClientUserId();
        tLRPC$TL_messageService.unread = true;
        tLRPC$TL_messageService.out = true;
        tLRPC$TL_messageService.flags = Factory.DEVICE_HAS_CRAPPY_OPENSLES;
        tLRPC$TL_messageService.dialog_id = DialogObject.makeEncryptedDialogId(encryptedChat.id);
        tLRPC$TL_messageService.peer_id = new TLRPC$TL_peerUser();
        tLRPC$TL_messageService.send_state = 1;
        if (encryptedChat.participant_id == getUserConfig().getClientUserId()) {
            tLRPC$TL_messageService.peer_id.user_id = encryptedChat.admin_id;
        } else {
            tLRPC$TL_messageService.peer_id.user_id = encryptedChat.participant_id;
        }
        if ((decryptedMessage instanceof TLRPC$TL_decryptedMessageActionScreenshotMessages) || (decryptedMessage instanceof TLRPC$TL_decryptedMessageActionSetMessageTTL)) {
            tLRPC$TL_messageService.date = getConnectionsManager().getCurrentTime();
        } else {
            tLRPC$TL_messageService.date = 0;
        }
        tLRPC$TL_messageService.random_id = getSendMessagesHelper().getNextRandomId();
        getUserConfig().saveConfig(false);
        ArrayList<TLRPC$Message> arrayList = new ArrayList<>();
        arrayList.add(tLRPC$TL_messageService);
        getMessagesStorage().putMessages(arrayList, false, true, true, 0, false);
        return tLRPC$TL_messageService;
    }

    public void sendMessagesReadMessage(TLRPC$EncryptedChat encryptedChat, ArrayList<Long> random_ids, TLRPC$Message resendMessage) {
        if (encryptedChat instanceof TLRPC$TL_encryptedChat) {
            TLRPC$TL_decryptedMessageService tLRPC$TL_decryptedMessageService = new TLRPC$TL_decryptedMessageService();
            if (resendMessage != null) {
                tLRPC$TL_decryptedMessageService.action = resendMessage.action.encryptedAction;
            } else {
                TLRPC$TL_decryptedMessageActionReadMessages tLRPC$TL_decryptedMessageActionReadMessages = new TLRPC$TL_decryptedMessageActionReadMessages();
                tLRPC$TL_decryptedMessageService.action = tLRPC$TL_decryptedMessageActionReadMessages;
                tLRPC$TL_decryptedMessageActionReadMessages.random_ids = random_ids;
                resendMessage = createServiceSecretMessage(encryptedChat, tLRPC$TL_decryptedMessageActionReadMessages);
            }
            TLRPC$Message tLRPC$Message = resendMessage;
            tLRPC$TL_decryptedMessageService.random_id = tLRPC$Message.random_id;
            performSendEncryptedRequest(tLRPC$TL_decryptedMessageService, tLRPC$Message, encryptedChat, null, null, null);
        }
    }

    protected void processUpdateEncryption(TLRPC$TL_updateEncryption update, ConcurrentHashMap<Long, TLRPC$User> usersDict) {
        byte[] bArr;
        final TLRPC$EncryptedChat tLRPC$EncryptedChat = update.chat;
        final long jMakeEncryptedDialogId = DialogObject.makeEncryptedDialogId(tLRPC$EncryptedChat.id);
        final TLRPC$EncryptedChat encryptedChatDB = getMessagesController().getEncryptedChatDB(tLRPC$EncryptedChat.id, false);
        if ((tLRPC$EncryptedChat instanceof TLRPC$TL_encryptedChatRequested) && encryptedChatDB == null) {
            long j = tLRPC$EncryptedChat.participant_id;
            if (j == getUserConfig().getClientUserId()) {
                j = tLRPC$EncryptedChat.admin_id;
            }
            TLRPC$User user = getMessagesController().getUser(Long.valueOf(j));
            if (user == null) {
                user = (TLRPC$User) usersDict.get(Long.valueOf(j));
            }
            tLRPC$EncryptedChat.user_id = j;
            final TLRPC$TL_dialog tLRPC$TL_dialog = new TLRPC$TL_dialog();
            tLRPC$TL_dialog.id = jMakeEncryptedDialogId;
            tLRPC$TL_dialog.folder_id = tLRPC$EncryptedChat.folder_id;
            tLRPC$TL_dialog.unread_count = 0;
            tLRPC$TL_dialog.top_message = 0;
            tLRPC$TL_dialog.last_message_date = update.date;
            getMessagesController().putEncryptedChat(tLRPC$EncryptedChat, false);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SecretChatHelper$E1cmjsIhjEtGEipNq8NDTjPASyM
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processUpdateEncryption$1$SecretChatHelper(tLRPC$TL_dialog, jMakeEncryptedDialogId);
                }
            });
            getMessagesStorage().putEncryptedChat(tLRPC$EncryptedChat, user, tLRPC$TL_dialog);
            acceptSecretChat(tLRPC$EncryptedChat);
        } else if (tLRPC$EncryptedChat instanceof TLRPC$TL_encryptedChat) {
            if ((encryptedChatDB instanceof TLRPC$TL_encryptedChatWaiting) && ((bArr = encryptedChatDB.auth_key) == null || bArr.length == 1)) {
                tLRPC$EncryptedChat.a_or_b = encryptedChatDB.a_or_b;
                tLRPC$EncryptedChat.user_id = encryptedChatDB.user_id;
                processAcceptedSecretChat(tLRPC$EncryptedChat);
            } else if (encryptedChatDB == null && this.startingSecretChat) {
                this.delayedEncryptedChatUpdates.add(update);
            }
        } else {
            if (encryptedChatDB != null) {
                tLRPC$EncryptedChat.user_id = encryptedChatDB.user_id;
                tLRPC$EncryptedChat.auth_key = encryptedChatDB.auth_key;
                tLRPC$EncryptedChat.key_create_date = encryptedChatDB.key_create_date;
                tLRPC$EncryptedChat.key_use_count_in = encryptedChatDB.key_use_count_in;
                tLRPC$EncryptedChat.key_use_count_out = encryptedChatDB.key_use_count_out;
                tLRPC$EncryptedChat.ttl = encryptedChatDB.ttl;
                tLRPC$EncryptedChat.seq_in = encryptedChatDB.seq_in;
                tLRPC$EncryptedChat.seq_out = encryptedChatDB.seq_out;
                tLRPC$EncryptedChat.admin_id = encryptedChatDB.admin_id;
                tLRPC$EncryptedChat.mtproto_seq = encryptedChatDB.mtproto_seq;
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SecretChatHelper$M4GZtWAOAmX4duN0krGrbPuq8as
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processUpdateEncryption$2$SecretChatHelper(encryptedChatDB, tLRPC$EncryptedChat);
                }
            });
        }
        if ((tLRPC$EncryptedChat instanceof TLRPC$TL_encryptedChatDiscarded) && tLRPC$EncryptedChat.history_deleted) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SecretChatHelper$5pXotgSnF5GLr-A3NveqZ_2qNho
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processUpdateEncryption$3$SecretChatHelper(jMakeEncryptedDialogId);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processUpdateEncryption$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processUpdateEncryption$1$SecretChatHelper(TLRPC$Dialog tLRPC$Dialog, long j) {
        if (tLRPC$Dialog.folder_id == 1) {
            SharedPreferences.Editor editorEdit = MessagesController.getNotificationsSettings(this.currentAccount).edit();
            editorEdit.putBoolean("dialog_bar_archived" + j, true);
            editorEdit.commit();
        }
        getMessagesController().dialogs_dict.put(tLRPC$Dialog.id, tLRPC$Dialog);
        getMessagesController().allDialogs.add(tLRPC$Dialog);
        getMessagesController().sortDialogs(null);
        getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processUpdateEncryption$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processUpdateEncryption$2$SecretChatHelper(TLRPC$EncryptedChat tLRPC$EncryptedChat, TLRPC$EncryptedChat tLRPC$EncryptedChat2) {
        if (tLRPC$EncryptedChat != null) {
            getMessagesController().putEncryptedChat(tLRPC$EncryptedChat2, false);
        }
        getMessagesStorage().updateEncryptedChat(tLRPC$EncryptedChat2);
        getNotificationCenter().postNotificationName(NotificationCenter.encryptedChatUpdated, tLRPC$EncryptedChat2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processUpdateEncryption$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processUpdateEncryption$3$SecretChatHelper(long j) {
        getMessagesController().deleteDialog(j, 0);
    }

    public void sendMessagesDeleteMessage(TLRPC$EncryptedChat encryptedChat, ArrayList<Long> random_ids, TLRPC$Message resendMessage) {
        if (encryptedChat instanceof TLRPC$TL_encryptedChat) {
            TLRPC$TL_decryptedMessageService tLRPC$TL_decryptedMessageService = new TLRPC$TL_decryptedMessageService();
            if (resendMessage != null) {
                tLRPC$TL_decryptedMessageService.action = resendMessage.action.encryptedAction;
            } else {
                TLRPC$TL_decryptedMessageActionDeleteMessages tLRPC$TL_decryptedMessageActionDeleteMessages = new TLRPC$TL_decryptedMessageActionDeleteMessages();
                tLRPC$TL_decryptedMessageService.action = tLRPC$TL_decryptedMessageActionDeleteMessages;
                tLRPC$TL_decryptedMessageActionDeleteMessages.random_ids = random_ids;
                resendMessage = createServiceSecretMessage(encryptedChat, tLRPC$TL_decryptedMessageActionDeleteMessages);
            }
            TLRPC$Message tLRPC$Message = resendMessage;
            tLRPC$TL_decryptedMessageService.random_id = tLRPC$Message.random_id;
            performSendEncryptedRequest(tLRPC$TL_decryptedMessageService, tLRPC$Message, encryptedChat, null, null, null);
        }
    }

    public void sendClearHistoryMessage(TLRPC$EncryptedChat encryptedChat, TLRPC$Message resendMessage) {
        if (encryptedChat instanceof TLRPC$TL_encryptedChat) {
            TLRPC$TL_decryptedMessageService tLRPC$TL_decryptedMessageService = new TLRPC$TL_decryptedMessageService();
            if (resendMessage != null) {
                tLRPC$TL_decryptedMessageService.action = resendMessage.action.encryptedAction;
            } else {
                TLRPC$TL_decryptedMessageActionFlushHistory tLRPC$TL_decryptedMessageActionFlushHistory = new TLRPC$TL_decryptedMessageActionFlushHistory();
                tLRPC$TL_decryptedMessageService.action = tLRPC$TL_decryptedMessageActionFlushHistory;
                resendMessage = createServiceSecretMessage(encryptedChat, tLRPC$TL_decryptedMessageActionFlushHistory);
            }
            TLRPC$Message tLRPC$Message = resendMessage;
            tLRPC$TL_decryptedMessageService.random_id = tLRPC$Message.random_id;
            performSendEncryptedRequest(tLRPC$TL_decryptedMessageService, tLRPC$Message, encryptedChat, null, null, null);
        }
    }

    public void sendNotifyLayerMessage(TLRPC$EncryptedChat encryptedChat, TLRPC$Message resendMessage) {
        if ((encryptedChat instanceof TLRPC$TL_encryptedChat) && !this.sendingNotifyLayer.contains(Integer.valueOf(encryptedChat.id))) {
            this.sendingNotifyLayer.add(Integer.valueOf(encryptedChat.id));
            TLRPC$TL_decryptedMessageService tLRPC$TL_decryptedMessageService = new TLRPC$TL_decryptedMessageService();
            if (resendMessage != null) {
                tLRPC$TL_decryptedMessageService.action = resendMessage.action.encryptedAction;
            } else {
                TLRPC$TL_decryptedMessageActionNotifyLayer tLRPC$TL_decryptedMessageActionNotifyLayer = new TLRPC$TL_decryptedMessageActionNotifyLayer();
                tLRPC$TL_decryptedMessageService.action = tLRPC$TL_decryptedMessageActionNotifyLayer;
                tLRPC$TL_decryptedMessageActionNotifyLayer.layer = CURRENT_SECRET_CHAT_LAYER;
                resendMessage = createServiceSecretMessage(encryptedChat, tLRPC$TL_decryptedMessageActionNotifyLayer);
            }
            TLRPC$Message tLRPC$Message = resendMessage;
            tLRPC$TL_decryptedMessageService.random_id = tLRPC$Message.random_id;
            performSendEncryptedRequest(tLRPC$TL_decryptedMessageService, tLRPC$Message, encryptedChat, null, null, null);
        }
    }

    public void sendRequestKeyMessage(TLRPC$EncryptedChat encryptedChat, TLRPC$Message resendMessage) {
        if (encryptedChat instanceof TLRPC$TL_encryptedChat) {
            TLRPC$TL_decryptedMessageService tLRPC$TL_decryptedMessageService = new TLRPC$TL_decryptedMessageService();
            if (resendMessage != null) {
                tLRPC$TL_decryptedMessageService.action = resendMessage.action.encryptedAction;
            } else {
                TLRPC$TL_decryptedMessageActionRequestKey tLRPC$TL_decryptedMessageActionRequestKey = new TLRPC$TL_decryptedMessageActionRequestKey();
                tLRPC$TL_decryptedMessageService.action = tLRPC$TL_decryptedMessageActionRequestKey;
                tLRPC$TL_decryptedMessageActionRequestKey.exchange_id = encryptedChat.exchange_id;
                tLRPC$TL_decryptedMessageActionRequestKey.g_a = encryptedChat.g_a;
                resendMessage = createServiceSecretMessage(encryptedChat, tLRPC$TL_decryptedMessageActionRequestKey);
            }
            TLRPC$Message tLRPC$Message = resendMessage;
            tLRPC$TL_decryptedMessageService.random_id = tLRPC$Message.random_id;
            performSendEncryptedRequest(tLRPC$TL_decryptedMessageService, tLRPC$Message, encryptedChat, null, null, null);
        }
    }

    public void sendAcceptKeyMessage(TLRPC$EncryptedChat encryptedChat, TLRPC$Message resendMessage) {
        if (encryptedChat instanceof TLRPC$TL_encryptedChat) {
            TLRPC$TL_decryptedMessageService tLRPC$TL_decryptedMessageService = new TLRPC$TL_decryptedMessageService();
            if (resendMessage != null) {
                tLRPC$TL_decryptedMessageService.action = resendMessage.action.encryptedAction;
            } else {
                TLRPC$TL_decryptedMessageActionAcceptKey tLRPC$TL_decryptedMessageActionAcceptKey = new TLRPC$TL_decryptedMessageActionAcceptKey();
                tLRPC$TL_decryptedMessageService.action = tLRPC$TL_decryptedMessageActionAcceptKey;
                tLRPC$TL_decryptedMessageActionAcceptKey.exchange_id = encryptedChat.exchange_id;
                tLRPC$TL_decryptedMessageActionAcceptKey.key_fingerprint = encryptedChat.future_key_fingerprint;
                tLRPC$TL_decryptedMessageActionAcceptKey.g_b = encryptedChat.g_a_or_b;
                resendMessage = createServiceSecretMessage(encryptedChat, tLRPC$TL_decryptedMessageActionAcceptKey);
            }
            TLRPC$Message tLRPC$Message = resendMessage;
            tLRPC$TL_decryptedMessageService.random_id = tLRPC$Message.random_id;
            performSendEncryptedRequest(tLRPC$TL_decryptedMessageService, tLRPC$Message, encryptedChat, null, null, null);
        }
    }

    public void sendCommitKeyMessage(TLRPC$EncryptedChat encryptedChat, TLRPC$Message resendMessage) {
        if (encryptedChat instanceof TLRPC$TL_encryptedChat) {
            TLRPC$TL_decryptedMessageService tLRPC$TL_decryptedMessageService = new TLRPC$TL_decryptedMessageService();
            if (resendMessage != null) {
                tLRPC$TL_decryptedMessageService.action = resendMessage.action.encryptedAction;
            } else {
                TLRPC$TL_decryptedMessageActionCommitKey tLRPC$TL_decryptedMessageActionCommitKey = new TLRPC$TL_decryptedMessageActionCommitKey();
                tLRPC$TL_decryptedMessageService.action = tLRPC$TL_decryptedMessageActionCommitKey;
                tLRPC$TL_decryptedMessageActionCommitKey.exchange_id = encryptedChat.exchange_id;
                tLRPC$TL_decryptedMessageActionCommitKey.key_fingerprint = encryptedChat.future_key_fingerprint;
                resendMessage = createServiceSecretMessage(encryptedChat, tLRPC$TL_decryptedMessageActionCommitKey);
            }
            TLRPC$Message tLRPC$Message = resendMessage;
            tLRPC$TL_decryptedMessageService.random_id = tLRPC$Message.random_id;
            performSendEncryptedRequest(tLRPC$TL_decryptedMessageService, tLRPC$Message, encryptedChat, null, null, null);
        }
    }

    public void sendAbortKeyMessage(TLRPC$EncryptedChat encryptedChat, TLRPC$Message resendMessage, long excange_id) {
        if (encryptedChat instanceof TLRPC$TL_encryptedChat) {
            TLRPC$TL_decryptedMessageService tLRPC$TL_decryptedMessageService = new TLRPC$TL_decryptedMessageService();
            if (resendMessage != null) {
                tLRPC$TL_decryptedMessageService.action = resendMessage.action.encryptedAction;
            } else {
                TLRPC$TL_decryptedMessageActionAbortKey tLRPC$TL_decryptedMessageActionAbortKey = new TLRPC$TL_decryptedMessageActionAbortKey();
                tLRPC$TL_decryptedMessageService.action = tLRPC$TL_decryptedMessageActionAbortKey;
                tLRPC$TL_decryptedMessageActionAbortKey.exchange_id = excange_id;
                resendMessage = createServiceSecretMessage(encryptedChat, tLRPC$TL_decryptedMessageActionAbortKey);
            }
            TLRPC$Message tLRPC$Message = resendMessage;
            tLRPC$TL_decryptedMessageService.random_id = tLRPC$Message.random_id;
            performSendEncryptedRequest(tLRPC$TL_decryptedMessageService, tLRPC$Message, encryptedChat, null, null, null);
        }
    }

    public void sendNoopMessage(TLRPC$EncryptedChat encryptedChat, TLRPC$Message resendMessage) {
        if (encryptedChat instanceof TLRPC$TL_encryptedChat) {
            TLRPC$TL_decryptedMessageService tLRPC$TL_decryptedMessageService = new TLRPC$TL_decryptedMessageService();
            if (resendMessage != null) {
                tLRPC$TL_decryptedMessageService.action = resendMessage.action.encryptedAction;
            } else {
                TLRPC$TL_decryptedMessageActionNoop tLRPC$TL_decryptedMessageActionNoop = new TLRPC$TL_decryptedMessageActionNoop();
                tLRPC$TL_decryptedMessageService.action = tLRPC$TL_decryptedMessageActionNoop;
                resendMessage = createServiceSecretMessage(encryptedChat, tLRPC$TL_decryptedMessageActionNoop);
            }
            TLRPC$Message tLRPC$Message = resendMessage;
            tLRPC$TL_decryptedMessageService.random_id = tLRPC$Message.random_id;
            performSendEncryptedRequest(tLRPC$TL_decryptedMessageService, tLRPC$Message, encryptedChat, null, null, null);
        }
    }

    public void sendResendMessage(TLRPC$EncryptedChat encryptedChat, int start, int end, TLRPC$Message resendMessage) {
        if (encryptedChat instanceof TLRPC$TL_encryptedChat) {
            SparseIntArray sparseIntArray = this.requestedHoles.get(encryptedChat.id);
            if (sparseIntArray == null || sparseIntArray.indexOfKey(start) < 0) {
                if (sparseIntArray == null) {
                    sparseIntArray = new SparseIntArray();
                    this.requestedHoles.put(encryptedChat.id, sparseIntArray);
                }
                sparseIntArray.put(start, end);
                TLRPC$TL_decryptedMessageService tLRPC$TL_decryptedMessageService = new TLRPC$TL_decryptedMessageService();
                if (resendMessage != null) {
                    tLRPC$TL_decryptedMessageService.action = resendMessage.action.encryptedAction;
                } else {
                    TLRPC$TL_decryptedMessageActionResend tLRPC$TL_decryptedMessageActionResend = new TLRPC$TL_decryptedMessageActionResend();
                    tLRPC$TL_decryptedMessageService.action = tLRPC$TL_decryptedMessageActionResend;
                    tLRPC$TL_decryptedMessageActionResend.start_seq_no = start;
                    tLRPC$TL_decryptedMessageActionResend.end_seq_no = end;
                    resendMessage = createServiceSecretMessage(encryptedChat, tLRPC$TL_decryptedMessageActionResend);
                }
                TLRPC$Message tLRPC$Message = resendMessage;
                tLRPC$TL_decryptedMessageService.random_id = tLRPC$Message.random_id;
                performSendEncryptedRequest(tLRPC$TL_decryptedMessageService, tLRPC$Message, encryptedChat, null, null, null);
            }
        }
    }

    public void sendTTLMessage(TLRPC$EncryptedChat encryptedChat, TLRPC$Message resendMessage) {
        if (encryptedChat instanceof TLRPC$TL_encryptedChat) {
            TLRPC$TL_decryptedMessageService tLRPC$TL_decryptedMessageService = new TLRPC$TL_decryptedMessageService();
            if (resendMessage != null) {
                tLRPC$TL_decryptedMessageService.action = resendMessage.action.encryptedAction;
            } else {
                TLRPC$TL_decryptedMessageActionSetMessageTTL tLRPC$TL_decryptedMessageActionSetMessageTTL = new TLRPC$TL_decryptedMessageActionSetMessageTTL();
                tLRPC$TL_decryptedMessageService.action = tLRPC$TL_decryptedMessageActionSetMessageTTL;
                tLRPC$TL_decryptedMessageActionSetMessageTTL.ttl_seconds = encryptedChat.ttl;
                resendMessage = createServiceSecretMessage(encryptedChat, tLRPC$TL_decryptedMessageActionSetMessageTTL);
                MessageObject messageObject = new MessageObject(this.currentAccount, resendMessage, false, false);
                messageObject.messageOwner.send_state = 1;
                messageObject.wasJustSent = true;
                ArrayList<MessageObject> arrayList = new ArrayList<>();
                arrayList.add(messageObject);
                getMessagesController().updateInterfaceWithMessages(resendMessage.dialog_id, arrayList, false);
                getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[0]);
            }
            TLRPC$Message tLRPC$Message = resendMessage;
            tLRPC$TL_decryptedMessageService.random_id = tLRPC$Message.random_id;
            performSendEncryptedRequest(tLRPC$TL_decryptedMessageService, tLRPC$Message, encryptedChat, null, null, null);
        }
    }

    public void sendScreenshotMessage(TLRPC$EncryptedChat encryptedChat, ArrayList<Long> random_ids, TLRPC$Message resendMessage) {
        if (encryptedChat instanceof TLRPC$TL_encryptedChat) {
            TLRPC$TL_decryptedMessageService tLRPC$TL_decryptedMessageService = new TLRPC$TL_decryptedMessageService();
            if (resendMessage != null) {
                tLRPC$TL_decryptedMessageService.action = resendMessage.action.encryptedAction;
            } else {
                TLRPC$TL_decryptedMessageActionScreenshotMessages tLRPC$TL_decryptedMessageActionScreenshotMessages = new TLRPC$TL_decryptedMessageActionScreenshotMessages();
                tLRPC$TL_decryptedMessageService.action = tLRPC$TL_decryptedMessageActionScreenshotMessages;
                tLRPC$TL_decryptedMessageActionScreenshotMessages.random_ids = random_ids;
                resendMessage = createServiceSecretMessage(encryptedChat, tLRPC$TL_decryptedMessageActionScreenshotMessages);
                MessageObject messageObject = new MessageObject(this.currentAccount, resendMessage, false, false);
                messageObject.messageOwner.send_state = 1;
                messageObject.wasJustSent = true;
                ArrayList<MessageObject> arrayList = new ArrayList<>();
                arrayList.add(messageObject);
                getMessagesController().updateInterfaceWithMessages(resendMessage.dialog_id, arrayList, false);
                getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[0]);
            }
            TLRPC$Message tLRPC$Message = resendMessage;
            tLRPC$TL_decryptedMessageService.random_id = tLRPC$Message.random_id;
            performSendEncryptedRequest(tLRPC$TL_decryptedMessageService, tLRPC$Message, encryptedChat, null, null, null);
        }
    }

    private void updateMediaPaths(MessageObject newMsgObj, TLRPC$EncryptedFile file, TLRPC$DecryptedMessage decryptedMessage, String originalPath) {
        TLRPC$Document tLRPC$Document;
        TLRPC$Photo tLRPC$Photo;
        TLRPC$Message tLRPC$Message = newMsgObj.messageOwner;
        if (file != null) {
            TLRPC$MessageMedia tLRPC$MessageMedia = tLRPC$Message.media;
            if ((tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaPhoto) && (tLRPC$Photo = tLRPC$MessageMedia.photo) != null) {
                ArrayList<TLRPC$PhotoSize> arrayList = tLRPC$Photo.sizes;
                TLRPC$PhotoSize tLRPC$PhotoSize = arrayList.get(arrayList.size() - 1);
                String str = tLRPC$PhotoSize.location.volume_id + "_" + tLRPC$PhotoSize.location.local_id;
                TLRPC$TL_fileEncryptedLocation tLRPC$TL_fileEncryptedLocation = new TLRPC$TL_fileEncryptedLocation();
                tLRPC$PhotoSize.location = tLRPC$TL_fileEncryptedLocation;
                TLRPC$DecryptedMessageMedia tLRPC$DecryptedMessageMedia = decryptedMessage.media;
                tLRPC$TL_fileEncryptedLocation.key = tLRPC$DecryptedMessageMedia.key;
                tLRPC$TL_fileEncryptedLocation.iv = tLRPC$DecryptedMessageMedia.iv;
                tLRPC$TL_fileEncryptedLocation.dc_id = file.dc_id;
                tLRPC$TL_fileEncryptedLocation.volume_id = file.id;
                tLRPC$TL_fileEncryptedLocation.secret = file.access_hash;
                tLRPC$TL_fileEncryptedLocation.local_id = file.key_fingerprint;
                String str2 = tLRPC$PhotoSize.location.volume_id + "_" + tLRPC$PhotoSize.location.local_id;
                new File(FileLoader.getDirectory(4), str + ".jpg").renameTo(FileLoader.getPathToAttach(tLRPC$PhotoSize));
                ImageLoader.getInstance().replaceImageInCache(str, str2, ImageLocation.getForPhoto(tLRPC$PhotoSize, tLRPC$Message.media.photo), true);
                ArrayList<TLRPC$Message> arrayList2 = new ArrayList<>();
                arrayList2.add(tLRPC$Message);
                getMessagesStorage().putMessages(arrayList2, false, true, false, 0, false);
                return;
            }
            if (!(tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaDocument) || (tLRPC$Document = tLRPC$MessageMedia.document) == null) {
                return;
            }
            tLRPC$MessageMedia.document = new TLRPC$TL_documentEncrypted();
            TLRPC$Document tLRPC$Document2 = tLRPC$Message.media.document;
            tLRPC$Document2.id = file.id;
            tLRPC$Document2.access_hash = file.access_hash;
            tLRPC$Document2.date = tLRPC$Document.date;
            tLRPC$Document2.attributes = tLRPC$Document.attributes;
            tLRPC$Document2.mime_type = tLRPC$Document.mime_type;
            tLRPC$Document2.size = file.size;
            TLRPC$DecryptedMessageMedia tLRPC$DecryptedMessageMedia2 = decryptedMessage.media;
            tLRPC$Document2.key = tLRPC$DecryptedMessageMedia2.key;
            tLRPC$Document2.iv = tLRPC$DecryptedMessageMedia2.iv;
            ArrayList<TLRPC$PhotoSize> arrayList3 = tLRPC$Document.thumbs;
            tLRPC$Document2.thumbs = arrayList3;
            tLRPC$Document2.dc_id = file.dc_id;
            if (arrayList3.isEmpty()) {
                TLRPC$TL_photoSizeEmpty tLRPC$TL_photoSizeEmpty = new TLRPC$TL_photoSizeEmpty();
                tLRPC$TL_photoSizeEmpty.type = "s";
                tLRPC$Message.media.document.thumbs.add(tLRPC$TL_photoSizeEmpty);
            }
            String str3 = tLRPC$Message.attachPath;
            if (str3 != null && str3.startsWith(FileLoader.getDirectory(4).getAbsolutePath()) && new File(tLRPC$Message.attachPath).renameTo(FileLoader.getPathToAttach(tLRPC$Message.media.document))) {
                newMsgObj.mediaExists = newMsgObj.attachPathExists;
                newMsgObj.attachPathExists = false;
                tLRPC$Message.attachPath = "";
            }
            ArrayList<TLRPC$Message> arrayList4 = new ArrayList<>();
            arrayList4.add(tLRPC$Message);
            getMessagesStorage().putMessages(arrayList4, false, true, false, 0, false);
        }
    }

    public static boolean isSecretVisibleMessage(TLRPC$Message message) {
        TLRPC$MessageAction tLRPC$MessageAction = message.action;
        if (tLRPC$MessageAction instanceof TLRPC$TL_messageEncryptedAction) {
            TLRPC$DecryptedMessageAction tLRPC$DecryptedMessageAction = tLRPC$MessageAction.encryptedAction;
            if ((tLRPC$DecryptedMessageAction instanceof TLRPC$TL_decryptedMessageActionScreenshotMessages) || (tLRPC$DecryptedMessageAction instanceof TLRPC$TL_decryptedMessageActionSetMessageTTL)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSecretInvisibleMessage(TLRPC$Message message) {
        TLRPC$MessageAction tLRPC$MessageAction = message.action;
        if (tLRPC$MessageAction instanceof TLRPC$TL_messageEncryptedAction) {
            TLRPC$DecryptedMessageAction tLRPC$DecryptedMessageAction = tLRPC$MessageAction.encryptedAction;
            if (!(tLRPC$DecryptedMessageAction instanceof TLRPC$TL_decryptedMessageActionScreenshotMessages) && !(tLRPC$DecryptedMessageAction instanceof TLRPC$TL_decryptedMessageActionSetMessageTTL)) {
                return true;
            }
        }
        return false;
    }

    protected void performSendEncryptedRequest(TLRPC$TL_messages_sendEncryptedMultiMedia req, SendMessagesHelper.DelayedMessage message) {
        for (int i = 0; i < req.files.size(); i++) {
            performSendEncryptedRequest(req.messages.get(i), message.messages.get(i), message.encryptedChat, req.files.get(i), message.originalPaths.get(i), message.messageObjects.get(i));
        }
    }

    protected void performSendEncryptedRequest(final TLRPC$DecryptedMessage req, final TLRPC$Message newMsgObj, final TLRPC$EncryptedChat chat, final TLRPC$InputEncryptedFile encryptedFile, final String originalPath, final MessageObject newMsg) {
        if (req == null || chat.auth_key == null || (chat instanceof TLRPC$TL_encryptedChatRequested) || (chat instanceof TLRPC$TL_encryptedChatWaiting)) {
            return;
        }
        getSendMessagesHelper().putToSendingMessages(newMsgObj, false);
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SecretChatHelper$x7E8zcGVcazo06YIwUh-HaMG__0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$performSendEncryptedRequest$8$SecretChatHelper(chat, req, newMsgObj, encryptedFile, newMsg, originalPath);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$performSendEncryptedRequest$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$performSendEncryptedRequest$8$SecretChatHelper(final TLRPC$EncryptedChat tLRPC$EncryptedChat, final TLRPC$DecryptedMessage tLRPC$DecryptedMessage, final TLRPC$Message tLRPC$Message, TLRPC$InputEncryptedFile tLRPC$InputEncryptedFile, final MessageObject messageObject, final String str) {
        TLRPC$TL_messages_sendEncryptedFile tLRPC$TL_messages_sendEncryptedFile;
        TLRPC$TL_messages_sendEncryptedFile tLRPC$TL_messages_sendEncryptedFile2;
        try {
            TLRPC$TL_decryptedMessageLayer tLRPC$TL_decryptedMessageLayer = new TLRPC$TL_decryptedMessageLayer();
            tLRPC$TL_decryptedMessageLayer.layer = Math.min(Math.max(46, AndroidUtilities.getMyLayerVersion(tLRPC$EncryptedChat.layer)), Math.max(46, AndroidUtilities.getPeerLayerVersion(tLRPC$EncryptedChat.layer)));
            tLRPC$TL_decryptedMessageLayer.message = tLRPC$DecryptedMessage;
            byte[] bArr = new byte[15];
            tLRPC$TL_decryptedMessageLayer.random_bytes = bArr;
            Utilities.random.nextBytes(bArr);
            boolean z = true;
            if (tLRPC$EncryptedChat.seq_in == 0 && tLRPC$EncryptedChat.seq_out == 0) {
                if (tLRPC$EncryptedChat.admin_id == getUserConfig().getClientUserId()) {
                    tLRPC$EncryptedChat.seq_out = 1;
                    tLRPC$EncryptedChat.seq_in = -2;
                } else {
                    tLRPC$EncryptedChat.seq_in = -1;
                }
            }
            int i = tLRPC$Message.seq_in;
            if (i == 0 && tLRPC$Message.seq_out == 0) {
                int i2 = tLRPC$EncryptedChat.seq_in;
                if (i2 <= 0) {
                    i2 += 2;
                }
                tLRPC$TL_decryptedMessageLayer.in_seq_no = i2;
                int i3 = tLRPC$EncryptedChat.seq_out;
                tLRPC$TL_decryptedMessageLayer.out_seq_no = i3;
                tLRPC$EncryptedChat.seq_out = i3 + 2;
                if (tLRPC$EncryptedChat.key_create_date == 0) {
                    tLRPC$EncryptedChat.key_create_date = getConnectionsManager().getCurrentTime();
                }
                short s = (short) (tLRPC$EncryptedChat.key_use_count_out + 1);
                tLRPC$EncryptedChat.key_use_count_out = s;
                if ((s >= 100 || tLRPC$EncryptedChat.key_create_date < getConnectionsManager().getCurrentTime() - 604800) && tLRPC$EncryptedChat.exchange_id == 0 && tLRPC$EncryptedChat.future_key_fingerprint == 0) {
                    requestNewSecretChatKey(tLRPC$EncryptedChat);
                }
                getMessagesStorage().updateEncryptedChatSeq(tLRPC$EncryptedChat, false);
                tLRPC$Message.seq_in = tLRPC$TL_decryptedMessageLayer.in_seq_no;
                tLRPC$Message.seq_out = tLRPC$TL_decryptedMessageLayer.out_seq_no;
                getMessagesStorage().setMessageSeq(tLRPC$Message.id, tLRPC$Message.seq_in, tLRPC$Message.seq_out);
            } else {
                tLRPC$TL_decryptedMessageLayer.in_seq_no = i;
                tLRPC$TL_decryptedMessageLayer.out_seq_no = tLRPC$Message.seq_out;
            }
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d(tLRPC$DecryptedMessage + " send message with in_seq = " + tLRPC$TL_decryptedMessageLayer.in_seq_no + " out_seq = " + tLRPC$TL_decryptedMessageLayer.out_seq_no);
            }
            int objectSize = tLRPC$TL_decryptedMessageLayer.getObjectSize();
            NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(objectSize + 4);
            nativeByteBuffer.writeInt32(objectSize);
            tLRPC$TL_decryptedMessageLayer.serializeToStream(nativeByteBuffer);
            int length = nativeByteBuffer.length();
            int iNextInt = (length % 16 != 0 ? 16 - (length % 16) : 0) + ((Utilities.random.nextInt(3) + 2) * 16);
            NativeByteBuffer nativeByteBuffer2 = new NativeByteBuffer(length + iNextInt);
            nativeByteBuffer.position(0);
            nativeByteBuffer2.writeBytes(nativeByteBuffer);
            if (iNextInt != 0) {
                byte[] bArr2 = new byte[iNextInt];
                Utilities.random.nextBytes(bArr2);
                nativeByteBuffer2.writeBytes(bArr2);
            }
            byte[] bArr3 = new byte[16];
            if (tLRPC$EncryptedChat.admin_id == getUserConfig().getClientUserId()) {
                z = false;
            }
            byte[] bArr4 = tLRPC$EncryptedChat.auth_key;
            int i4 = z ? 8 : 0;
            ByteBuffer byteBuffer = nativeByteBuffer2.buffer;
            System.arraycopy(Utilities.computeSHA256(bArr4, i4 + 88, 32, byteBuffer, 0, byteBuffer.limit()), 8, bArr3, 0, 16);
            nativeByteBuffer.reuse();
            MessageKeyData messageKeyDataGenerateMessageKeyData = MessageKeyData.generateMessageKeyData(tLRPC$EncryptedChat.auth_key, bArr3, z, 2);
            Utilities.aesIgeEncryption(nativeByteBuffer2.buffer, messageKeyDataGenerateMessageKeyData.aesKey, messageKeyDataGenerateMessageKeyData.aesIv, true, false, 0, nativeByteBuffer2.limit());
            NativeByteBuffer nativeByteBuffer3 = new NativeByteBuffer(24 + nativeByteBuffer2.length());
            nativeByteBuffer2.position(0);
            nativeByteBuffer3.writeInt64(tLRPC$EncryptedChat.key_fingerprint);
            nativeByteBuffer3.writeBytes(bArr3);
            nativeByteBuffer3.writeBytes(nativeByteBuffer2);
            nativeByteBuffer2.reuse();
            nativeByteBuffer3.position(0);
            if (tLRPC$InputEncryptedFile == null) {
                if (tLRPC$DecryptedMessage instanceof TLRPC$TL_decryptedMessageService) {
                    TLRPC$TL_messages_sendEncryptedService tLRPC$TL_messages_sendEncryptedService = new TLRPC$TL_messages_sendEncryptedService();
                    tLRPC$TL_messages_sendEncryptedService.data = nativeByteBuffer3;
                    tLRPC$TL_messages_sendEncryptedService.random_id = tLRPC$DecryptedMessage.random_id;
                    TLRPC$TL_inputEncryptedChat tLRPC$TL_inputEncryptedChat = new TLRPC$TL_inputEncryptedChat();
                    tLRPC$TL_messages_sendEncryptedService.peer = tLRPC$TL_inputEncryptedChat;
                    tLRPC$TL_inputEncryptedChat.chat_id = tLRPC$EncryptedChat.id;
                    tLRPC$TL_inputEncryptedChat.access_hash = tLRPC$EncryptedChat.access_hash;
                    tLRPC$TL_messages_sendEncryptedFile2 = tLRPC$TL_messages_sendEncryptedService;
                } else {
                    TLRPC$TL_messages_sendEncrypted tLRPC$TL_messages_sendEncrypted = new TLRPC$TL_messages_sendEncrypted();
                    tLRPC$TL_messages_sendEncrypted.silent = tLRPC$Message.silent;
                    tLRPC$TL_messages_sendEncrypted.data = nativeByteBuffer3;
                    tLRPC$TL_messages_sendEncrypted.random_id = tLRPC$DecryptedMessage.random_id;
                    TLRPC$TL_inputEncryptedChat tLRPC$TL_inputEncryptedChat2 = new TLRPC$TL_inputEncryptedChat();
                    tLRPC$TL_messages_sendEncrypted.peer = tLRPC$TL_inputEncryptedChat2;
                    tLRPC$TL_inputEncryptedChat2.chat_id = tLRPC$EncryptedChat.id;
                    tLRPC$TL_inputEncryptedChat2.access_hash = tLRPC$EncryptedChat.access_hash;
                    tLRPC$TL_messages_sendEncryptedFile2 = tLRPC$TL_messages_sendEncrypted;
                }
                tLRPC$TL_messages_sendEncryptedFile = tLRPC$TL_messages_sendEncryptedFile2;
            } else {
                TLRPC$TL_messages_sendEncryptedFile tLRPC$TL_messages_sendEncryptedFile3 = new TLRPC$TL_messages_sendEncryptedFile();
                tLRPC$TL_messages_sendEncryptedFile3.silent = tLRPC$Message.silent;
                tLRPC$TL_messages_sendEncryptedFile3.data = nativeByteBuffer3;
                tLRPC$TL_messages_sendEncryptedFile3.random_id = tLRPC$DecryptedMessage.random_id;
                TLRPC$TL_inputEncryptedChat tLRPC$TL_inputEncryptedChat3 = new TLRPC$TL_inputEncryptedChat();
                tLRPC$TL_messages_sendEncryptedFile3.peer = tLRPC$TL_inputEncryptedChat3;
                tLRPC$TL_inputEncryptedChat3.chat_id = tLRPC$EncryptedChat.id;
                tLRPC$TL_inputEncryptedChat3.access_hash = tLRPC$EncryptedChat.access_hash;
                tLRPC$TL_messages_sendEncryptedFile3.file = tLRPC$InputEncryptedFile;
                tLRPC$TL_messages_sendEncryptedFile = tLRPC$TL_messages_sendEncryptedFile3;
            }
            getConnectionsManager().sendRequest(tLRPC$TL_messages_sendEncryptedFile, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$SecretChatHelper$DOJCstQJUJyurZXAv4-qekyTPEQ
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$performSendEncryptedRequest$7$SecretChatHelper(tLRPC$DecryptedMessage, tLRPC$EncryptedChat, tLRPC$Message, messageObject, str, tLObject, tLRPC$TL_error);
                }
            }, 64);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008e  */
    /* renamed from: lambda$performSendEncryptedRequest$7, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$performSendEncryptedRequest$7$SecretChatHelper(ir.eitaa.tgnet.TLRPC$DecryptedMessage r9, ir.eitaa.tgnet.TLRPC$EncryptedChat r10, final ir.eitaa.tgnet.TLRPC$Message r11, ir.eitaa.messenger.MessageObject r12, java.lang.String r13, ir.eitaa.tgnet.TLObject r14, ir.eitaa.tgnet.TLRPC$TL_error r15) {
        /*
            r8 = this;
            r0 = 0
            if (r15 != 0) goto L6c
            ir.eitaa.tgnet.TLRPC$DecryptedMessageAction r1 = r9.action
            boolean r1 = r1 instanceof ir.eitaa.tgnet.TLRPC$TL_decryptedMessageActionNotifyLayer
            if (r1 == 0) goto L6c
            ir.eitaa.messenger.MessagesController r1 = r8.getMessagesController()
            int r2 = r10.id
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            ir.eitaa.tgnet.TLRPC$EncryptedChat r1 = r1.getEncryptedChat(r2)
            if (r1 != 0) goto L1a
            r1 = r10
        L1a:
            byte[] r2 = r1.key_hash
            if (r2 != 0) goto L26
            byte[] r2 = r1.auth_key
            byte[] r2 = ir.eitaa.messenger.AndroidUtilities.calcAuthKeyHash(r2)
            r1.key_hash = r2
        L26:
            byte[] r2 = r1.key_hash
            int r2 = r2.length
            r3 = 16
            if (r2 != r3) goto L50
            byte[] r2 = r10.auth_key     // Catch: java.lang.Throwable -> L4c
            int r4 = r2.length     // Catch: java.lang.Throwable -> L4c
            byte[] r2 = ir.eitaa.messenger.Utilities.computeSHA256(r2, r0, r4)     // Catch: java.lang.Throwable -> L4c
            r4 = 36
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L4c
            byte[] r10 = r10.key_hash     // Catch: java.lang.Throwable -> L4c
            java.lang.System.arraycopy(r10, r0, r4, r0, r3)     // Catch: java.lang.Throwable -> L4c
            r10 = 20
            java.lang.System.arraycopy(r2, r0, r4, r3, r10)     // Catch: java.lang.Throwable -> L4c
            r1.key_hash = r4     // Catch: java.lang.Throwable -> L4c
            ir.eitaa.messenger.MessagesStorage r10 = r8.getMessagesStorage()     // Catch: java.lang.Throwable -> L4c
            r10.updateEncryptedChat(r1)     // Catch: java.lang.Throwable -> L4c
            goto L50
        L4c:
            r10 = move-exception
            ir.eitaa.messenger.FileLog.e(r10)
        L50:
            java.util.ArrayList<java.lang.Integer> r10 = r8.sendingNotifyLayer
            int r2 = r1.id
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r10.remove(r2)
            int r10 = r1.layer
            int r2 = ir.eitaa.messenger.SecretChatHelper.CURRENT_SECRET_CHAT_LAYER
            int r10 = ir.eitaa.messenger.AndroidUtilities.setMyLayerVersion(r10, r2)
            r1.layer = r10
            ir.eitaa.messenger.MessagesStorage r10 = r8.getMessagesStorage()
            r10.updateEncryptedChatLayer(r1)
        L6c:
            if (r15 != 0) goto La3
            java.lang.String r7 = r11.attachPath
            r5 = r14
            ir.eitaa.tgnet.TLRPC$messages_SentEncryptedMessage r5 = (ir.eitaa.tgnet.TLRPC$messages_SentEncryptedMessage) r5
            boolean r10 = isSecretVisibleMessage(r11)
            if (r10 == 0) goto L7d
            int r10 = r5.date
            r11.date = r10
        L7d:
            if (r12 == 0) goto L8e
            ir.eitaa.tgnet.TLRPC$EncryptedFile r10 = r5.file
            boolean r14 = r10 instanceof ir.eitaa.tgnet.TLRPC$TL_encryptedFile
            if (r14 == 0) goto L8e
            r8.updateMediaPaths(r12, r10, r9, r13)
            int r0 = r12.getMediaExistanceFlags()
            r6 = r0
            goto L8f
        L8e:
            r6 = 0
        L8f:
            ir.eitaa.messenger.MessagesStorage r9 = r8.getMessagesStorage()
            ir.eitaa.messenger.DispatchQueue r9 = r9.getStorageQueue()
            ir.eitaa.messenger.-$$Lambda$SecretChatHelper$X7tDs7oQZI3Z7xWwTFznVMa2yf4 r10 = new ir.eitaa.messenger.-$$Lambda$SecretChatHelper$X7tDs7oQZI3Z7xWwTFznVMa2yf4
            r2 = r10
            r3 = r8
            r4 = r11
            r2.<init>()
            r9.postRunnable(r10)
            goto Lb2
        La3:
            ir.eitaa.messenger.MessagesStorage r9 = r8.getMessagesStorage()
            r9.markMessageAsSendError(r11, r0)
            ir.eitaa.messenger.-$$Lambda$SecretChatHelper$1yO_aCU4JLIpHjqAjX388X-ea28 r9 = new ir.eitaa.messenger.-$$Lambda$SecretChatHelper$1yO_aCU4JLIpHjqAjX388X-ea28
            r9.<init>()
            ir.eitaa.messenger.AndroidUtilities.runOnUIThread(r9)
        Lb2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.SecretChatHelper.lambda$performSendEncryptedRequest$7$SecretChatHelper(ir.eitaa.tgnet.TLRPC$DecryptedMessage, ir.eitaa.tgnet.TLRPC$EncryptedChat, ir.eitaa.tgnet.TLRPC$Message, ir.eitaa.messenger.MessageObject, java.lang.String, ir.eitaa.tgnet.TLObject, ir.eitaa.tgnet.TLRPC$TL_error):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$performSendEncryptedRequest$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$performSendEncryptedRequest$5$SecretChatHelper(final TLRPC$Message tLRPC$Message, TLRPC$messages_SentEncryptedMessage tLRPC$messages_SentEncryptedMessage, final int i, final String str) {
        if (isSecretInvisibleMessage(tLRPC$Message)) {
            tLRPC$messages_SentEncryptedMessage.date = 0;
        }
        getMessagesStorage().updateMessageStateAndId(tLRPC$Message.random_id, 0L, Integer.valueOf(tLRPC$Message.id), tLRPC$Message.id, tLRPC$messages_SentEncryptedMessage.date, false, 0);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SecretChatHelper$RaxRntv67RoQ07VCrNaRsWG1kCI
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$performSendEncryptedRequest$4$SecretChatHelper(tLRPC$Message, i, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$performSendEncryptedRequest$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$performSendEncryptedRequest$4$SecretChatHelper(TLRPC$Message tLRPC$Message, int i, String str) {
        tLRPC$Message.send_state = 0;
        getNotificationCenter().postNotificationName(NotificationCenter.messageReceivedByServer, Integer.valueOf(tLRPC$Message.id), Integer.valueOf(tLRPC$Message.id), tLRPC$Message, Long.valueOf(tLRPC$Message.dialog_id), 0L, Integer.valueOf(i), Boolean.FALSE);
        getSendMessagesHelper().processSentMessage(tLRPC$Message.id);
        if (MessageObject.isVideoMessage(tLRPC$Message) || MessageObject.isNewGifMessage(tLRPC$Message) || MessageObject.isRoundVideoMessage(tLRPC$Message)) {
            getSendMessagesHelper().stopVideoService(str);
        }
        getSendMessagesHelper().removeFromSendingMessages(tLRPC$Message.id, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$performSendEncryptedRequest$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$performSendEncryptedRequest$6$SecretChatHelper(TLRPC$Message tLRPC$Message) {
        tLRPC$Message.send_state = 2;
        getNotificationCenter().postNotificationName(NotificationCenter.messageSendError, Integer.valueOf(tLRPC$Message.id));
        getSendMessagesHelper().processSentMessage(tLRPC$Message.id);
        if (MessageObject.isVideoMessage(tLRPC$Message) || MessageObject.isNewGifMessage(tLRPC$Message) || MessageObject.isRoundVideoMessage(tLRPC$Message)) {
            getSendMessagesHelper().stopVideoService(tLRPC$Message.attachPath);
        }
        getSendMessagesHelper().removeFromSendingMessages(tLRPC$Message.id, false);
    }

    private void applyPeerLayer(final TLRPC$EncryptedChat chat, int newPeerLayer) {
        int peerLayerVersion = AndroidUtilities.getPeerLayerVersion(chat.layer);
        if (newPeerLayer <= peerLayerVersion) {
            return;
        }
        if (chat.key_hash.length == 16) {
            try {
                byte[] bArr = chat.auth_key;
                byte[] bArrComputeSHA256 = Utilities.computeSHA256(bArr, 0, bArr.length);
                byte[] bArr2 = new byte[36];
                System.arraycopy(chat.key_hash, 0, bArr2, 0, 16);
                System.arraycopy(bArrComputeSHA256, 0, bArr2, 16, 20);
                chat.key_hash = bArr2;
                getMessagesStorage().updateEncryptedChat(chat);
            } catch (Throwable th) {
                FileLog.e(th);
            }
        }
        chat.layer = AndroidUtilities.setPeerLayerVersion(chat.layer, newPeerLayer);
        getMessagesStorage().updateEncryptedChatLayer(chat);
        if (peerLayerVersion < CURRENT_SECRET_CHAT_LAYER) {
            sendNotifyLayerMessage(chat, null);
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SecretChatHelper$icKF-X9j_YlO2eYZ82GuuKpoIlM
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$applyPeerLayer$9$SecretChatHelper(chat);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$applyPeerLayer$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$applyPeerLayer$9$SecretChatHelper(TLRPC$EncryptedChat tLRPC$EncryptedChat) {
        getNotificationCenter().postNotificationName(NotificationCenter.encryptedChatUpdated, tLRPC$EncryptedChat);
    }

    /* JADX WARN: Removed duplicated region for block: B:309:0x07db  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x07eb  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x085a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ir.eitaa.tgnet.TLRPC$Message processDecryptedObject(ir.eitaa.tgnet.TLRPC$EncryptedChat r18, ir.eitaa.tgnet.TLRPC$EncryptedFile r19, int r20, ir.eitaa.tgnet.TLObject r21, boolean r22) {
        /*
            Method dump skipped, instructions count: 2379
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.SecretChatHelper.processDecryptedObject(ir.eitaa.tgnet.TLRPC$EncryptedChat, ir.eitaa.tgnet.TLRPC$EncryptedFile, int, ir.eitaa.tgnet.TLObject, boolean):ir.eitaa.tgnet.TLRPC$Message");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processDecryptedObject$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processDecryptedObject$12$SecretChatHelper(final long j) {
        TLRPC$Dialog tLRPC$Dialog = getMessagesController().dialogs_dict.get(j);
        if (tLRPC$Dialog != null) {
            tLRPC$Dialog.unread_count = 0;
            getMessagesController().dialogMessage.remove(tLRPC$Dialog.id);
        }
        getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SecretChatHelper$nNVoNDVOa6BmspcOfWsAuQTIaiw
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processDecryptedObject$11$SecretChatHelper(j);
            }
        });
        getMessagesStorage().deleteDialog(j, 1);
        getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[0]);
        getNotificationCenter().postNotificationName(NotificationCenter.removeAllMessagesFromDialog, Long.valueOf(j), Boolean.FALSE, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processDecryptedObject$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processDecryptedObject$11$SecretChatHelper(final long j) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SecretChatHelper$nTK2XABq78GSHFux6KzZw4F6aKE
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processDecryptedObject$10$SecretChatHelper(j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processDecryptedObject$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processDecryptedObject$10$SecretChatHelper(long j) {
        getNotificationsController().processReadMessages(null, j, 0, ConnectionsManager.DEFAULT_DATACENTER_ID, false);
        LongSparseIntArray longSparseIntArray = new LongSparseIntArray(1);
        longSparseIntArray.put(j, 0);
        getNotificationsController().processDialogsUpdateRead(longSparseIntArray);
    }

    private TLRPC$Message createDeleteMessage(int mid, int seq_out, int seq_in, long random_id, TLRPC$EncryptedChat encryptedChat) {
        TLRPC$TL_messageService tLRPC$TL_messageService = new TLRPC$TL_messageService();
        TLRPC$TL_messageEncryptedAction tLRPC$TL_messageEncryptedAction = new TLRPC$TL_messageEncryptedAction();
        tLRPC$TL_messageService.action = tLRPC$TL_messageEncryptedAction;
        tLRPC$TL_messageEncryptedAction.encryptedAction = new TLRPC$TL_decryptedMessageActionDeleteMessages();
        tLRPC$TL_messageService.action.encryptedAction.random_ids.add(Long.valueOf(random_id));
        tLRPC$TL_messageService.id = mid;
        tLRPC$TL_messageService.local_id = mid;
        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
        tLRPC$TL_messageService.from_id = tLRPC$TL_peerUser;
        tLRPC$TL_peerUser.user_id = getUserConfig().getClientUserId();
        tLRPC$TL_messageService.unread = true;
        tLRPC$TL_messageService.out = true;
        tLRPC$TL_messageService.flags = Factory.DEVICE_HAS_CRAPPY_OPENSLES;
        tLRPC$TL_messageService.dialog_id = DialogObject.makeEncryptedDialogId(encryptedChat.id);
        tLRPC$TL_messageService.send_state = 1;
        tLRPC$TL_messageService.seq_in = seq_in;
        tLRPC$TL_messageService.seq_out = seq_out;
        tLRPC$TL_messageService.peer_id = new TLRPC$TL_peerUser();
        if (encryptedChat.participant_id == getUserConfig().getClientUserId()) {
            tLRPC$TL_messageService.peer_id.user_id = encryptedChat.admin_id;
        } else {
            tLRPC$TL_messageService.peer_id.user_id = encryptedChat.participant_id;
        }
        tLRPC$TL_messageService.date = 0;
        tLRPC$TL_messageService.random_id = random_id;
        return tLRPC$TL_messageService;
    }

    private void resendMessages(final int startSeq, final int endSeq, final TLRPC$EncryptedChat encryptedChat) {
        if (encryptedChat == null || endSeq - startSeq < 0) {
            return;
        }
        getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SecretChatHelper$cl_d1hsAPzeabORI0oLE5m7Xtc0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$resendMessages$15$SecretChatHelper(startSeq, encryptedChat, endSeq);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$resendMessages$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$resendMessages$15$SecretChatHelper(int i, TLRPC$EncryptedChat tLRPC$EncryptedChat, int i2) {
        int i3;
        long j;
        ArrayList<TLRPC$Message> arrayList;
        TLRPC$Message tLRPC$MessageCreateDeleteMessage;
        try {
            int i4 = (tLRPC$EncryptedChat.admin_id == getUserConfig().getClientUserId() && i % 2 == 0) ? i + 1 : i;
            int i5 = 5;
            int i6 = 1;
            int i7 = 2;
            int i8 = 3;
            SQLiteCursor sQLiteCursorQueryFinalized = getMessagesStorage().getDatabase().queryFinalized(String.format(Locale.US, "SELECT uid FROM requested_holes WHERE uid = %d AND ((seq_out_start >= %d AND %d <= seq_out_end) OR (seq_out_start >= %d AND %d <= seq_out_end))", Integer.valueOf(tLRPC$EncryptedChat.id), Integer.valueOf(i4), Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i2)), new Object[0]);
            boolean next = sQLiteCursorQueryFinalized.next();
            sQLiteCursorQueryFinalized.dispose();
            if (next) {
                return;
            }
            long jMakeEncryptedDialogId = DialogObject.makeEncryptedDialogId(tLRPC$EncryptedChat.id);
            SparseArray sparseArray = new SparseArray();
            ArrayList<TLRPC$Message> arrayList2 = new ArrayList<>();
            for (int i9 = i4; i9 <= i2; i9 += 2) {
                sparseArray.put(i9, null);
            }
            SQLiteCursor sQLiteCursorQueryFinalized2 = getMessagesStorage().getDatabase().queryFinalized(String.format(Locale.US, "SELECT m.data, r.random_id, s.seq_in, s.seq_out, m.ttl, s.mid FROM messages_seq as s LEFT JOIN randoms_v2 as r ON r.mid = s.mid LEFT JOIN messages_v2 as m ON m.mid = s.mid WHERE m.uid = %d AND m.out = 1 AND s.seq_out >= %d AND s.seq_out <= %d ORDER BY seq_out ASC", Long.valueOf(jMakeEncryptedDialogId), Integer.valueOf(i4), Integer.valueOf(i2)), new Object[0]);
            while (sQLiteCursorQueryFinalized2.next()) {
                long jLongValue = sQLiteCursorQueryFinalized2.longValue(i6);
                if (jLongValue == 0) {
                    jLongValue = Utilities.random.nextLong();
                }
                long j2 = jLongValue;
                int iIntValue = sQLiteCursorQueryFinalized2.intValue(i7);
                int iIntValue2 = sQLiteCursorQueryFinalized2.intValue(i8);
                int iIntValue3 = sQLiteCursorQueryFinalized2.intValue(i5);
                NativeByteBuffer nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized2.byteBufferValue(0);
                if (nativeByteBufferByteBufferValue != null) {
                    tLRPC$MessageCreateDeleteMessage = TLRPC$Message.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                    i3 = i4;
                    tLRPC$MessageCreateDeleteMessage.readAttachPath(nativeByteBufferByteBufferValue, getUserConfig().clientUserId);
                    nativeByteBufferByteBufferValue.reuse();
                    tLRPC$MessageCreateDeleteMessage.random_id = j2;
                    tLRPC$MessageCreateDeleteMessage.dialog_id = jMakeEncryptedDialogId;
                    tLRPC$MessageCreateDeleteMessage.seq_in = iIntValue;
                    tLRPC$MessageCreateDeleteMessage.seq_out = iIntValue2;
                    tLRPC$MessageCreateDeleteMessage.ttl = sQLiteCursorQueryFinalized2.intValue(4);
                    j = jMakeEncryptedDialogId;
                    arrayList = arrayList2;
                } else {
                    i3 = i4;
                    j = jMakeEncryptedDialogId;
                    arrayList = arrayList2;
                    tLRPC$MessageCreateDeleteMessage = createDeleteMessage(iIntValue3, iIntValue2, iIntValue, j2, tLRPC$EncryptedChat);
                }
                arrayList.add(tLRPC$MessageCreateDeleteMessage);
                sparseArray.remove(iIntValue2);
                arrayList2 = arrayList;
                i4 = i3;
                jMakeEncryptedDialogId = j;
                i5 = 5;
                i6 = 1;
                i7 = 2;
                i8 = 3;
            }
            final ArrayList<TLRPC$Message> arrayList3 = arrayList2;
            int i10 = i4;
            sQLiteCursorQueryFinalized2.dispose();
            if (sparseArray.size() != 0) {
                for (int i11 = 0; i11 < sparseArray.size(); i11++) {
                    int iKeyAt = sparseArray.keyAt(i11);
                    arrayList3.add(createDeleteMessage(getUserConfig().getNewMessageId(), iKeyAt, iKeyAt + 1, Utilities.random.nextLong(), tLRPC$EncryptedChat));
                }
                getUserConfig().saveConfig(false);
            }
            Collections.sort(arrayList3, $$Lambda$SecretChatHelper$9gT_gCJvRFnbGsrFdoylxn7Yqo.INSTANCE);
            ArrayList<TLRPC$EncryptedChat> arrayList4 = new ArrayList<>();
            arrayList4.add(tLRPC$EncryptedChat);
            try {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SecretChatHelper$T-yhlBeiOhE2XO9pkORc6H_haK4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$resendMessages$14$SecretChatHelper(arrayList3);
                    }
                });
                getSendMessagesHelper().processUnsentMessages(arrayList3, null, new ArrayList<>(), new ArrayList<>(), arrayList4);
                getMessagesStorage().getDatabase().executeFast(String.format(Locale.US, "REPLACE INTO requested_holes VALUES(%d, %d, %d)", Integer.valueOf(tLRPC$EncryptedChat.id), Integer.valueOf(i10), Integer.valueOf(i2))).stepThis().dispose();
            } catch (Exception e) {
                e = e;
                FileLog.e(e);
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$resendMessages$14, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$resendMessages$14$SecretChatHelper(ArrayList arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            MessageObject messageObject = new MessageObject(this.currentAccount, (TLRPC$Message) arrayList.get(i), false, true);
            messageObject.resendAsIs = true;
            getSendMessagesHelper().retrySendMessage(messageObject, true);
        }
    }

    public void checkSecretHoles(TLRPC$EncryptedChat chat, ArrayList<TLRPC$Message> messages) {
        TL_decryptedMessageHolder tL_decryptedMessageHolder;
        TLRPC$TL_decryptedMessageLayer tLRPC$TL_decryptedMessageLayer;
        int i;
        int i2;
        ArrayList<TL_decryptedMessageHolder> arrayList = this.secretHolesQueue.get(chat.id);
        if (arrayList == null) {
            return;
        }
        Collections.sort(arrayList, $$Lambda$SecretChatHelper$m5L9fzA0guPsior5BN92nsF7P_o.INSTANCE);
        boolean z = false;
        while (arrayList.size() > 0 && ((i = (tLRPC$TL_decryptedMessageLayer = (tL_decryptedMessageHolder = arrayList.get(0)).layer).out_seq_no) == (i2 = chat.seq_in) || i2 == i - 2)) {
            applyPeerLayer(chat, tLRPC$TL_decryptedMessageLayer.layer);
            TLRPC$TL_decryptedMessageLayer tLRPC$TL_decryptedMessageLayer2 = tL_decryptedMessageHolder.layer;
            chat.seq_in = tLRPC$TL_decryptedMessageLayer2.out_seq_no;
            chat.in_seq_no = tLRPC$TL_decryptedMessageLayer2.in_seq_no;
            arrayList.remove(0);
            if (tL_decryptedMessageHolder.decryptedWithVersion == 2) {
                chat.mtproto_seq = Math.min(chat.mtproto_seq, chat.seq_in);
            }
            TLRPC$Message tLRPC$MessageProcessDecryptedObject = processDecryptedObject(chat, tL_decryptedMessageHolder.file, tL_decryptedMessageHolder.date, tL_decryptedMessageHolder.layer.message, tL_decryptedMessageHolder.new_key_used);
            if (tLRPC$MessageProcessDecryptedObject != null) {
                messages.add(tLRPC$MessageProcessDecryptedObject);
            }
            z = true;
        }
        if (arrayList.isEmpty()) {
            this.secretHolesQueue.remove(chat.id);
        }
        if (z) {
            getMessagesStorage().updateEncryptedChatSeq(chat, true);
        }
    }

    static /* synthetic */ int lambda$checkSecretHoles$16(TL_decryptedMessageHolder tL_decryptedMessageHolder, TL_decryptedMessageHolder tL_decryptedMessageHolder2) {
        int i = tL_decryptedMessageHolder.layer.out_seq_no;
        int i2 = tL_decryptedMessageHolder2.layer.out_seq_no;
        if (i > i2) {
            return 1;
        }
        return i < i2 ? -1 : 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00eb A[PHI: r3
      0x00eb: PHI (r3v5 boolean) = (r3v4 boolean), (r3v8 boolean) binds: [B:39:0x00e9, B:37:0x00e6] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean decryptWithMtProtoVersion(ir.eitaa.tgnet.NativeByteBuffer r26, byte[] r27, byte[] r28, int r29, boolean r30, boolean r31) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.SecretChatHelper.decryptWithMtProtoVersion(ir.eitaa.tgnet.NativeByteBuffer, byte[], byte[], int, boolean, boolean):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0238 A[Catch: Exception -> 0x0252, TryCatch #0 {Exception -> 0x0252, blocks: (B:7:0x001a, B:9:0x001e, B:11:0x002a, B:12:0x0036, B:14:0x0041, B:16:0x005c, B:25:0x0075, B:29:0x008e, B:33:0x0097, B:36:0x00ac, B:42:0x00c6, B:44:0x00d7, B:45:0x00de, B:47:0x00e2, B:49:0x00e8, B:51:0x00ec, B:53:0x00fa, B:54:0x0101, B:55:0x0104, B:57:0x010b, B:59:0x010f, B:61:0x0115, B:63:0x0119, B:64:0x0155, B:69:0x015f, B:73:0x0166, B:75:0x0169, B:77:0x016d, B:78:0x0172, B:80:0x0187, B:81:0x0193, B:83:0x019a, B:85:0x01d4, B:88:0x01ed, B:89:0x01f5, B:96:0x021d, B:98:0x0230, B:99:0x0233, B:90:0x020e, B:92:0x0212, B:102:0x0238, B:104:0x023f, B:17:0x0060, B:21:0x006c), top: B:109:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0075 A[Catch: Exception -> 0x0252, TryCatch #0 {Exception -> 0x0252, blocks: (B:7:0x001a, B:9:0x001e, B:11:0x002a, B:12:0x0036, B:14:0x0041, B:16:0x005c, B:25:0x0075, B:29:0x008e, B:33:0x0097, B:36:0x00ac, B:42:0x00c6, B:44:0x00d7, B:45:0x00de, B:47:0x00e2, B:49:0x00e8, B:51:0x00ec, B:53:0x00fa, B:54:0x0101, B:55:0x0104, B:57:0x010b, B:59:0x010f, B:61:0x0115, B:63:0x0119, B:64:0x0155, B:69:0x015f, B:73:0x0166, B:75:0x0169, B:77:0x016d, B:78:0x0172, B:80:0x0187, B:81:0x0193, B:83:0x019a, B:85:0x01d4, B:88:0x01ed, B:89:0x01f5, B:96:0x021d, B:98:0x0230, B:99:0x0233, B:90:0x020e, B:92:0x0212, B:102:0x0238, B:104:0x023f, B:17:0x0060, B:21:0x006c), top: B:109:0x001a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected java.util.ArrayList<ir.eitaa.tgnet.TLRPC$Message> decryptMessage(ir.eitaa.tgnet.TLRPC$EncryptedMessage r20) {
        /*
            Method dump skipped, instructions count: 599
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.SecretChatHelper.decryptMessage(ir.eitaa.tgnet.TLRPC$EncryptedMessage):java.util.ArrayList");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$decryptMessage$17, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$decryptMessage$17$SecretChatHelper(TLRPC$TL_encryptedChatDiscarded tLRPC$TL_encryptedChatDiscarded) {
        getMessagesController().putEncryptedChat(tLRPC$TL_encryptedChatDiscarded, false);
        getMessagesStorage().updateEncryptedChat(tLRPC$TL_encryptedChatDiscarded);
        getNotificationCenter().postNotificationName(NotificationCenter.encryptedChatUpdated, tLRPC$TL_encryptedChatDiscarded);
    }

    public void requestNewSecretChatKey(TLRPC$EncryptedChat encryptedChat) {
        byte[] bArr = new byte[Factory.DEVICE_HAS_CRAPPY_OPENSLES];
        Utilities.random.nextBytes(bArr);
        byte[] byteArray = BigInteger.valueOf(getMessagesStorage().getSecretG()).modPow(new BigInteger(1, bArr), new BigInteger(1, getMessagesStorage().getSecretPBytes())).toByteArray();
        if (byteArray.length > 256) {
            byte[] bArr2 = new byte[Factory.DEVICE_HAS_CRAPPY_OPENSLES];
            System.arraycopy(byteArray, 1, bArr2, 0, Factory.DEVICE_HAS_CRAPPY_OPENSLES);
            byteArray = bArr2;
        }
        encryptedChat.exchange_id = getSendMessagesHelper().getNextRandomId();
        encryptedChat.a_or_b = bArr;
        encryptedChat.g_a = byteArray;
        getMessagesStorage().updateEncryptedChat(encryptedChat);
        sendRequestKeyMessage(encryptedChat, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void processAcceptedSecretChat(final ir.eitaa.tgnet.TLRPC$EncryptedChat r10) throws java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.SecretChatHelper.processAcceptedSecretChat(ir.eitaa.tgnet.TLRPC$EncryptedChat):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processAcceptedSecretChat$18, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processAcceptedSecretChat$18$SecretChatHelper(TLRPC$EncryptedChat tLRPC$EncryptedChat) {
        getNotificationCenter().postNotificationName(NotificationCenter.encryptedChatUpdated, tLRPC$EncryptedChat);
        sendNotifyLayerMessage(tLRPC$EncryptedChat, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processAcceptedSecretChat$19, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processAcceptedSecretChat$19$SecretChatHelper(TLRPC$TL_encryptedChatDiscarded tLRPC$TL_encryptedChatDiscarded) {
        getMessagesController().putEncryptedChat(tLRPC$TL_encryptedChatDiscarded, false);
        getNotificationCenter().postNotificationName(NotificationCenter.encryptedChatUpdated, tLRPC$TL_encryptedChatDiscarded);
    }

    public void declineSecretChat(int chat_id, boolean revoke) {
        declineSecretChat(chat_id, revoke, 0L);
    }

    public void declineSecretChat(int chat_id, boolean revoke, final long taskId) {
        NativeByteBuffer nativeByteBuffer;
        Exception e;
        if (taskId == 0) {
            try {
                nativeByteBuffer = new NativeByteBuffer(12);
            } catch (Exception e2) {
                nativeByteBuffer = null;
                e = e2;
            }
            try {
                nativeByteBuffer.writeInt32(100);
                nativeByteBuffer.writeInt32(chat_id);
                nativeByteBuffer.writeBool(revoke);
            } catch (Exception e3) {
                e = e3;
                FileLog.e(e);
                taskId = getMessagesStorage().createPendingTask(nativeByteBuffer);
                TLRPC$TL_messages_discardEncryption tLRPC$TL_messages_discardEncryption = new TLRPC$TL_messages_discardEncryption();
                tLRPC$TL_messages_discardEncryption.chat_id = chat_id;
                tLRPC$TL_messages_discardEncryption.delete_history = revoke;
                getConnectionsManager().sendRequest(tLRPC$TL_messages_discardEncryption, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$SecretChatHelper$Ak6MILuxZ9yiaqqgUoXmjnvMvMg
                    @Override // ir.eitaa.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$declineSecretChat$20$SecretChatHelper(taskId, tLObject, tLRPC$TL_error);
                    }
                });
            }
            taskId = getMessagesStorage().createPendingTask(nativeByteBuffer);
        }
        TLRPC$TL_messages_discardEncryption tLRPC$TL_messages_discardEncryption2 = new TLRPC$TL_messages_discardEncryption();
        tLRPC$TL_messages_discardEncryption2.chat_id = chat_id;
        tLRPC$TL_messages_discardEncryption2.delete_history = revoke;
        getConnectionsManager().sendRequest(tLRPC$TL_messages_discardEncryption2, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$SecretChatHelper$Ak6MILuxZ9yiaqqgUoXmjnvMvMg
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$declineSecretChat$20$SecretChatHelper(taskId, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$declineSecretChat$20, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$declineSecretChat$20$SecretChatHelper(long j, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (j != 0) {
            getMessagesStorage().removePendingTask(j);
        }
    }

    public void acceptSecretChat(final TLRPC$EncryptedChat encryptedChat) {
        if (this.acceptingChats.get(encryptedChat.id) != null) {
            return;
        }
        this.acceptingChats.put(encryptedChat.id, encryptedChat);
        TLRPC$TL_messages_getDhConfig tLRPC$TL_messages_getDhConfig = new TLRPC$TL_messages_getDhConfig();
        tLRPC$TL_messages_getDhConfig.random_length = Factory.DEVICE_HAS_CRAPPY_OPENSLES;
        tLRPC$TL_messages_getDhConfig.version = getMessagesStorage().getLastSecretVersion();
        getConnectionsManager().sendRequest(tLRPC$TL_messages_getDhConfig, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$SecretChatHelper$WNciToga2C9zNzSWWdY_oc4ZSy8
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$acceptSecretChat$23$SecretChatHelper(encryptedChat, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$acceptSecretChat$23, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$acceptSecretChat$23$SecretChatHelper(final TLRPC$EncryptedChat tLRPC$EncryptedChat, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        byte[] bArr;
        if (tLRPC$TL_error == null) {
            TLRPC$messages_DhConfig tLRPC$messages_DhConfig = (TLRPC$messages_DhConfig) tLObject;
            if (tLObject instanceof TLRPC$TL_messages_dhConfig) {
                if (!Utilities.isGoodPrime(tLRPC$messages_DhConfig.p, tLRPC$messages_DhConfig.g)) {
                    this.acceptingChats.remove(tLRPC$EncryptedChat.id);
                    declineSecretChat(tLRPC$EncryptedChat.id, false);
                    return;
                } else {
                    getMessagesStorage().setSecretPBytes(tLRPC$messages_DhConfig.p);
                    getMessagesStorage().setSecretG(tLRPC$messages_DhConfig.g);
                    getMessagesStorage().setLastSecretVersion(tLRPC$messages_DhConfig.version);
                    getMessagesStorage().saveSecretParams(getMessagesStorage().getLastSecretVersion(), getMessagesStorage().getSecretG(), getMessagesStorage().getSecretPBytes());
                }
            }
            byte[] bArr2 = new byte[Factory.DEVICE_HAS_CRAPPY_OPENSLES];
            for (int i = 0; i < 256; i++) {
                bArr2[i] = (byte) (((byte) (Utilities.random.nextDouble() * 256.0d)) ^ tLRPC$messages_DhConfig.random[i]);
            }
            tLRPC$EncryptedChat.a_or_b = bArr2;
            tLRPC$EncryptedChat.seq_in = -1;
            tLRPC$EncryptedChat.seq_out = 0;
            BigInteger bigInteger = new BigInteger(1, getMessagesStorage().getSecretPBytes());
            BigInteger bigIntegerModPow = BigInteger.valueOf(getMessagesStorage().getSecretG()).modPow(new BigInteger(1, bArr2), bigInteger);
            BigInteger bigInteger2 = new BigInteger(1, tLRPC$EncryptedChat.g_a);
            if (!Utilities.isGoodGaAndGb(bigInteger2, bigInteger)) {
                this.acceptingChats.remove(tLRPC$EncryptedChat.id);
                declineSecretChat(tLRPC$EncryptedChat.id, false);
                return;
            }
            byte[] byteArray = bigIntegerModPow.toByteArray();
            if (byteArray.length > 256) {
                byte[] bArr3 = new byte[Factory.DEVICE_HAS_CRAPPY_OPENSLES];
                System.arraycopy(byteArray, 1, bArr3, 0, Factory.DEVICE_HAS_CRAPPY_OPENSLES);
                byteArray = bArr3;
            }
            byte[] byteArray2 = bigInteger2.modPow(new BigInteger(1, bArr2), bigInteger).toByteArray();
            if (byteArray2.length > 256) {
                bArr = new byte[Factory.DEVICE_HAS_CRAPPY_OPENSLES];
                System.arraycopy(byteArray2, byteArray2.length - Factory.DEVICE_HAS_CRAPPY_OPENSLES, bArr, 0, Factory.DEVICE_HAS_CRAPPY_OPENSLES);
            } else {
                if (byteArray2.length < 256) {
                    bArr = new byte[Factory.DEVICE_HAS_CRAPPY_OPENSLES];
                    System.arraycopy(byteArray2, 0, bArr, 256 - byteArray2.length, byteArray2.length);
                    for (int i2 = 0; i2 < 256 - byteArray2.length; i2++) {
                        bArr[i2] = 0;
                    }
                }
                byte[] bArrComputeSHA1 = Utilities.computeSHA1(byteArray2);
                byte[] bArr4 = new byte[8];
                System.arraycopy(bArrComputeSHA1, bArrComputeSHA1.length - 8, bArr4, 0, 8);
                tLRPC$EncryptedChat.auth_key = byteArray2;
                tLRPC$EncryptedChat.key_create_date = getConnectionsManager().getCurrentTime();
                TLRPC$TL_messages_acceptEncryption tLRPC$TL_messages_acceptEncryption = new TLRPC$TL_messages_acceptEncryption();
                tLRPC$TL_messages_acceptEncryption.g_b = byteArray;
                TLRPC$TL_inputEncryptedChat tLRPC$TL_inputEncryptedChat = new TLRPC$TL_inputEncryptedChat();
                tLRPC$TL_messages_acceptEncryption.peer = tLRPC$TL_inputEncryptedChat;
                tLRPC$TL_inputEncryptedChat.chat_id = tLRPC$EncryptedChat.id;
                tLRPC$TL_inputEncryptedChat.access_hash = tLRPC$EncryptedChat.access_hash;
                tLRPC$TL_messages_acceptEncryption.key_fingerprint = Utilities.bytesToLong(bArr4);
                getConnectionsManager().sendRequest(tLRPC$TL_messages_acceptEncryption, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$SecretChatHelper$xwJP29zEGHIlC0l5RcpAnpZOV80
                    @Override // ir.eitaa.tgnet.RequestDelegate
                    public final void run(TLObject tLObject2, TLRPC$TL_error tLRPC$TL_error2) {
                        this.f$0.lambda$acceptSecretChat$22$SecretChatHelper(tLRPC$EncryptedChat, tLObject2, tLRPC$TL_error2);
                    }
                }, 64);
                return;
            }
            byteArray2 = bArr;
            byte[] bArrComputeSHA12 = Utilities.computeSHA1(byteArray2);
            byte[] bArr42 = new byte[8];
            System.arraycopy(bArrComputeSHA12, bArrComputeSHA12.length - 8, bArr42, 0, 8);
            tLRPC$EncryptedChat.auth_key = byteArray2;
            tLRPC$EncryptedChat.key_create_date = getConnectionsManager().getCurrentTime();
            TLRPC$TL_messages_acceptEncryption tLRPC$TL_messages_acceptEncryption2 = new TLRPC$TL_messages_acceptEncryption();
            tLRPC$TL_messages_acceptEncryption2.g_b = byteArray;
            TLRPC$TL_inputEncryptedChat tLRPC$TL_inputEncryptedChat2 = new TLRPC$TL_inputEncryptedChat();
            tLRPC$TL_messages_acceptEncryption2.peer = tLRPC$TL_inputEncryptedChat2;
            tLRPC$TL_inputEncryptedChat2.chat_id = tLRPC$EncryptedChat.id;
            tLRPC$TL_inputEncryptedChat2.access_hash = tLRPC$EncryptedChat.access_hash;
            tLRPC$TL_messages_acceptEncryption2.key_fingerprint = Utilities.bytesToLong(bArr42);
            getConnectionsManager().sendRequest(tLRPC$TL_messages_acceptEncryption2, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$SecretChatHelper$xwJP29zEGHIlC0l5RcpAnpZOV80
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject2, TLRPC$TL_error tLRPC$TL_error2) {
                    this.f$0.lambda$acceptSecretChat$22$SecretChatHelper(tLRPC$EncryptedChat, tLObject2, tLRPC$TL_error2);
                }
            }, 64);
            return;
        }
        this.acceptingChats.remove(tLRPC$EncryptedChat.id);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$acceptSecretChat$22, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$acceptSecretChat$22$SecretChatHelper(TLRPC$EncryptedChat tLRPC$EncryptedChat, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        this.acceptingChats.remove(tLRPC$EncryptedChat.id);
        if (tLRPC$TL_error == null) {
            final TLRPC$EncryptedChat tLRPC$EncryptedChat2 = (TLRPC$EncryptedChat) tLObject;
            tLRPC$EncryptedChat2.auth_key = tLRPC$EncryptedChat.auth_key;
            tLRPC$EncryptedChat2.user_id = tLRPC$EncryptedChat.user_id;
            tLRPC$EncryptedChat2.seq_in = tLRPC$EncryptedChat.seq_in;
            tLRPC$EncryptedChat2.seq_out = tLRPC$EncryptedChat.seq_out;
            tLRPC$EncryptedChat2.key_create_date = tLRPC$EncryptedChat.key_create_date;
            tLRPC$EncryptedChat2.key_use_count_in = tLRPC$EncryptedChat.key_use_count_in;
            tLRPC$EncryptedChat2.key_use_count_out = tLRPC$EncryptedChat.key_use_count_out;
            getMessagesStorage().updateEncryptedChat(tLRPC$EncryptedChat2);
            getMessagesController().putEncryptedChat(tLRPC$EncryptedChat2, false);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SecretChatHelper$MhQL21eTjWXemxRf6QhrmV3ZTJQ
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$acceptSecretChat$21$SecretChatHelper(tLRPC$EncryptedChat2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$acceptSecretChat$21, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$acceptSecretChat$21$SecretChatHelper(TLRPC$EncryptedChat tLRPC$EncryptedChat) {
        getNotificationCenter().postNotificationName(NotificationCenter.encryptedChatUpdated, tLRPC$EncryptedChat);
        sendNotifyLayerMessage(tLRPC$EncryptedChat, null);
    }

    public void startSecretChat(final Context context, final TLRPC$User user) {
        if (user == null || context == null) {
            return;
        }
        this.startingSecretChat = true;
        final AlertDialog alertDialog = new AlertDialog(context, 3);
        TLRPC$TL_messages_getDhConfig tLRPC$TL_messages_getDhConfig = new TLRPC$TL_messages_getDhConfig();
        tLRPC$TL_messages_getDhConfig.random_length = Factory.DEVICE_HAS_CRAPPY_OPENSLES;
        tLRPC$TL_messages_getDhConfig.version = getMessagesStorage().getLastSecretVersion();
        final int iSendRequest = getConnectionsManager().sendRequest(tLRPC$TL_messages_getDhConfig, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$SecretChatHelper$vA8BSP66wDNrhcLHunvZBeayLo8
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$startSecretChat$30$SecretChatHelper(context, alertDialog, user, tLObject, tLRPC$TL_error);
            }
        }, 2);
        alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: ir.eitaa.messenger.-$$Lambda$SecretChatHelper$03tC_EUaf51ifWmMMnNH1gyxmXw
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                this.f$0.lambda$startSecretChat$31$SecretChatHelper(iSendRequest, dialogInterface);
            }
        });
        try {
            alertDialog.show();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startSecretChat$30, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$startSecretChat$30$SecretChatHelper(final Context context, final AlertDialog alertDialog, final TLRPC$User tLRPC$User, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            TLRPC$messages_DhConfig tLRPC$messages_DhConfig = (TLRPC$messages_DhConfig) tLObject;
            if (tLObject instanceof TLRPC$TL_messages_dhConfig) {
                if (!Utilities.isGoodPrime(tLRPC$messages_DhConfig.p, tLRPC$messages_DhConfig.g)) {
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SecretChatHelper$OBZgiUoZF_TnAfSikqiqqS8zS9k
                        @Override // java.lang.Runnable
                        public final void run() {
                            SecretChatHelper.lambda$startSecretChat$24(context, alertDialog);
                        }
                    });
                    return;
                }
                getMessagesStorage().setSecretPBytes(tLRPC$messages_DhConfig.p);
                getMessagesStorage().setSecretG(tLRPC$messages_DhConfig.g);
                getMessagesStorage().setLastSecretVersion(tLRPC$messages_DhConfig.version);
                getMessagesStorage().saveSecretParams(getMessagesStorage().getLastSecretVersion(), getMessagesStorage().getSecretG(), getMessagesStorage().getSecretPBytes());
            }
            final byte[] bArr = new byte[Factory.DEVICE_HAS_CRAPPY_OPENSLES];
            for (int i = 0; i < 256; i++) {
                bArr[i] = (byte) (((byte) (Utilities.random.nextDouble() * 256.0d)) ^ tLRPC$messages_DhConfig.random[i]);
            }
            byte[] byteArray = BigInteger.valueOf(getMessagesStorage().getSecretG()).modPow(new BigInteger(1, bArr), new BigInteger(1, getMessagesStorage().getSecretPBytes())).toByteArray();
            if (byteArray.length > 256) {
                byte[] bArr2 = new byte[Factory.DEVICE_HAS_CRAPPY_OPENSLES];
                System.arraycopy(byteArray, 1, bArr2, 0, Factory.DEVICE_HAS_CRAPPY_OPENSLES);
                byteArray = bArr2;
            }
            TLRPC$TL_messages_requestEncryption tLRPC$TL_messages_requestEncryption = new TLRPC$TL_messages_requestEncryption();
            tLRPC$TL_messages_requestEncryption.g_a = byteArray;
            tLRPC$TL_messages_requestEncryption.user_id = getMessagesController().getInputUser(tLRPC$User);
            tLRPC$TL_messages_requestEncryption.random_id = Utilities.random.nextInt();
            getConnectionsManager().sendRequest(tLRPC$TL_messages_requestEncryption, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$SecretChatHelper$bQSukWhlGSIysd4aVKGx2j1rSI8
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject2, TLRPC$TL_error tLRPC$TL_error2) {
                    this.f$0.lambda$startSecretChat$28$SecretChatHelper(context, alertDialog, bArr, tLRPC$User, tLObject2, tLRPC$TL_error2);
                }
            }, 2);
            return;
        }
        this.delayedEncryptedChatUpdates.clear();
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SecretChatHelper$lT-53WIwgbXcBW-IL4qh_2pfgcM
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$startSecretChat$29$SecretChatHelper(context, alertDialog);
            }
        });
    }

    static /* synthetic */ void lambda$startSecretChat$24(Context context, AlertDialog alertDialog) {
        try {
            if (((Activity) context).isFinishing()) {
                return;
            }
            alertDialog.dismiss();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startSecretChat$28, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$startSecretChat$28$SecretChatHelper(final Context context, final AlertDialog alertDialog, final byte[] bArr, final TLRPC$User tLRPC$User, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SecretChatHelper$aC65x0tFoj7UWPFPrGl7h47o55c
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$startSecretChat$26$SecretChatHelper(context, alertDialog, tLObject, bArr, tLRPC$User);
                }
            });
        } else {
            this.delayedEncryptedChatUpdates.clear();
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SecretChatHelper$mMQ8rLpbYGuJ8eiFLJgIgRRLXs4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$startSecretChat$27$SecretChatHelper(context, alertDialog);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startSecretChat$26, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$startSecretChat$26$SecretChatHelper(Context context, AlertDialog alertDialog, TLObject tLObject, byte[] bArr, TLRPC$User tLRPC$User) {
        this.startingSecretChat = false;
        if (!((Activity) context).isFinishing()) {
            try {
                alertDialog.dismiss();
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
        TLRPC$EncryptedChat tLRPC$EncryptedChat = (TLRPC$EncryptedChat) tLObject;
        tLRPC$EncryptedChat.user_id = tLRPC$EncryptedChat.participant_id;
        tLRPC$EncryptedChat.seq_in = -2;
        tLRPC$EncryptedChat.seq_out = 1;
        tLRPC$EncryptedChat.a_or_b = bArr;
        getMessagesController().putEncryptedChat(tLRPC$EncryptedChat, false);
        TLRPC$TL_dialog tLRPC$TL_dialog = new TLRPC$TL_dialog();
        tLRPC$TL_dialog.id = DialogObject.makeEncryptedDialogId(tLRPC$EncryptedChat.id);
        tLRPC$TL_dialog.unread_count = 0;
        tLRPC$TL_dialog.top_message = 0;
        tLRPC$TL_dialog.last_message_date = getConnectionsManager().getCurrentTime();
        getMessagesController().dialogs_dict.put(tLRPC$TL_dialog.id, tLRPC$TL_dialog);
        getMessagesController().allDialogs.add(tLRPC$TL_dialog);
        getMessagesController().sortDialogs(null);
        getMessagesStorage().putEncryptedChat(tLRPC$EncryptedChat, tLRPC$User, tLRPC$TL_dialog);
        getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[0]);
        getNotificationCenter().postNotificationName(NotificationCenter.encryptedChatCreated, tLRPC$EncryptedChat);
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SecretChatHelper$G_AG2up_OzFvPJBl14ax0FL07bA
            @Override // java.lang.Runnable
            public final void run() throws InterruptedException {
                this.f$0.lambda$startSecretChat$25$SecretChatHelper();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startSecretChat$25, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$startSecretChat$25$SecretChatHelper() throws InterruptedException {
        if (this.delayedEncryptedChatUpdates.isEmpty()) {
            return;
        }
        getMessagesController().processUpdateArray(this.delayedEncryptedChatUpdates, null, null, false, 0);
        this.delayedEncryptedChatUpdates.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startSecretChat$27, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$startSecretChat$27$SecretChatHelper(Context context, AlertDialog alertDialog) {
        if (((Activity) context).isFinishing()) {
            return;
        }
        this.startingSecretChat = false;
        try {
            alertDialog.dismiss();
        } catch (Exception e) {
            FileLog.e(e);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
        builder.setMessage(LocaleController.getString("CreateEncryptedChatError", R.string.CreateEncryptedChatError));
        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
        builder.show().setCanceledOnTouchOutside(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startSecretChat$29, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$startSecretChat$29$SecretChatHelper(Context context, AlertDialog alertDialog) {
        this.startingSecretChat = false;
        if (((Activity) context).isFinishing()) {
            return;
        }
        try {
            alertDialog.dismiss();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startSecretChat$31, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$startSecretChat$31$SecretChatHelper(int i, DialogInterface dialogInterface) {
        getConnectionsManager().cancelRequest(i, true);
    }
}
