package org.rbmain.messenger;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.util.SparseArray;
import android.util.SparseIntArray;
import androidx.collection.LongSparseArray;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import org.rbmain.SQLite.SQLiteCursor;
import org.rbmain.messenger.SecretChatHelper;
import org.rbmain.messenger.SendMessagesHelper;
import org.rbmain.messenger.support.LongSparseIntArray;
import org.rbmain.tgnet.AbstractSerializedData;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.NativeByteBuffer;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$DecryptedMessage;
import org.rbmain.tgnet.TLRPC$DecryptedMessageAction;
import org.rbmain.tgnet.TLRPC$DecryptedMessageMedia;
import org.rbmain.tgnet.TLRPC$Dialog;
import org.rbmain.tgnet.TLRPC$Document;
import org.rbmain.tgnet.TLRPC$EncryptedChat;
import org.rbmain.tgnet.TLRPC$EncryptedFile;
import org.rbmain.tgnet.TLRPC$InputEncryptedFile;
import org.rbmain.tgnet.TLRPC$Message;
import org.rbmain.tgnet.TLRPC$MessageAction;
import org.rbmain.tgnet.TLRPC$MessageMedia;
import org.rbmain.tgnet.TLRPC$Photo;
import org.rbmain.tgnet.TLRPC$PhotoSize;
import org.rbmain.tgnet.TLRPC$TL_decryptedMessageActionAbortKey;
import org.rbmain.tgnet.TLRPC$TL_decryptedMessageActionAcceptKey;
import org.rbmain.tgnet.TLRPC$TL_decryptedMessageActionCommitKey;
import org.rbmain.tgnet.TLRPC$TL_decryptedMessageActionDeleteMessages;
import org.rbmain.tgnet.TLRPC$TL_decryptedMessageActionFlushHistory;
import org.rbmain.tgnet.TLRPC$TL_decryptedMessageActionNoop;
import org.rbmain.tgnet.TLRPC$TL_decryptedMessageActionNotifyLayer;
import org.rbmain.tgnet.TLRPC$TL_decryptedMessageActionReadMessages;
import org.rbmain.tgnet.TLRPC$TL_decryptedMessageActionRequestKey;
import org.rbmain.tgnet.TLRPC$TL_decryptedMessageActionResend;
import org.rbmain.tgnet.TLRPC$TL_decryptedMessageActionScreenshotMessages;
import org.rbmain.tgnet.TLRPC$TL_decryptedMessageActionSetMessageTTL;
import org.rbmain.tgnet.TLRPC$TL_decryptedMessageLayer;
import org.rbmain.tgnet.TLRPC$TL_decryptedMessageService;
import org.rbmain.tgnet.TLRPC$TL_dialog;
import org.rbmain.tgnet.TLRPC$TL_documentEncrypted;
import org.rbmain.tgnet.TLRPC$TL_encryptedChat;
import org.rbmain.tgnet.TLRPC$TL_encryptedChatDiscarded;
import org.rbmain.tgnet.TLRPC$TL_encryptedChatRequested;
import org.rbmain.tgnet.TLRPC$TL_encryptedChatWaiting;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_fileEncryptedLocation;
import org.rbmain.tgnet.TLRPC$TL_inputEncryptedChat;
import org.rbmain.tgnet.TLRPC$TL_messageEncryptedAction;
import org.rbmain.tgnet.TLRPC$TL_messageMediaDocument;
import org.rbmain.tgnet.TLRPC$TL_messageMediaPhoto;
import org.rbmain.tgnet.TLRPC$TL_messageService;
import org.rbmain.tgnet.TLRPC$TL_messages_acceptEncryption;
import org.rbmain.tgnet.TLRPC$TL_messages_dhConfig;
import org.rbmain.tgnet.TLRPC$TL_messages_discardEncryption;
import org.rbmain.tgnet.TLRPC$TL_messages_getDhConfig;
import org.rbmain.tgnet.TLRPC$TL_messages_requestEncryption;
import org.rbmain.tgnet.TLRPC$TL_messages_sendEncrypted;
import org.rbmain.tgnet.TLRPC$TL_messages_sendEncryptedFile;
import org.rbmain.tgnet.TLRPC$TL_messages_sendEncryptedMultiMedia;
import org.rbmain.tgnet.TLRPC$TL_messages_sendEncryptedService;
import org.rbmain.tgnet.TLRPC$TL_peerUser;
import org.rbmain.tgnet.TLRPC$TL_photoSizeEmpty;
import org.rbmain.tgnet.TLRPC$TL_updateEncryption;
import org.rbmain.tgnet.TLRPC$Update;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.tgnet.TLRPC$messages_DhConfig;
import org.rbmain.tgnet.TLRPC$messages_SentEncryptedMessage;
import org.rbmain.ui.ActionBar.AlertDialog;

/* loaded from: classes4.dex */
public class SecretChatHelper extends BaseController {
    public static final int CURRENT_SECRET_CHAT_LAYER = 101;
    private static volatile SecretChatHelper[] Instance = new SecretChatHelper[3];
    private SparseArray<TLRPC$EncryptedChat> acceptingChats;
    public ArrayList<TLRPC$Update> delayedEncryptedChatUpdates;
    private ArrayList<Long> pendingEncMessagesToDelete;
    private SparseArray<ArrayList<TLRPC$Update>> pendingSecretMessages;
    private SparseArray<SparseIntArray> requestedHoles;
    private SparseArray<ArrayList<TL_decryptedMessageHolder>> secretHolesQueue;
    private ArrayList<Integer> sendingNotifyLayer;
    private boolean startingSecretChat;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$declineSecretChat$20(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    public static class TL_decryptedMessageHolder extends TLObject {
        public static int constructor = 1431655929;
        public int date;
        public int decryptedWithVersion;
        public TLRPC$EncryptedFile file;
        public TLRPC$TL_decryptedMessageLayer layer;
        public boolean new_key_used;

        @Override // org.rbmain.tgnet.TLObject
        public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
            abstractSerializedData.readInt64(z);
            this.date = abstractSerializedData.readInt32(z);
            this.layer = TLRPC$TL_decryptedMessageLayer.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            if (abstractSerializedData.readBool(z)) {
                this.file = TLRPC$EncryptedFile.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            }
            this.new_key_used = abstractSerializedData.readBool(z);
        }

        @Override // org.rbmain.tgnet.TLObject
        public void serializeToStream(AbstractSerializedData abstractSerializedData) {
            abstractSerializedData.writeInt32(constructor);
            abstractSerializedData.writeInt64(0L);
            abstractSerializedData.writeInt32(this.date);
            this.layer.serializeToStream(abstractSerializedData);
            abstractSerializedData.writeBool(this.file != null);
            TLRPC$EncryptedFile tLRPC$EncryptedFile = this.file;
            if (tLRPC$EncryptedFile != null) {
                tLRPC$EncryptedFile.serializeToStream(abstractSerializedData);
            }
            abstractSerializedData.writeBool(this.new_key_used);
        }
    }

    public static SecretChatHelper getInstance(int i) {
        SecretChatHelper secretChatHelper = Instance[i];
        if (secretChatHelper == null) {
            synchronized (SecretChatHelper.class) {
                secretChatHelper = Instance[i];
                if (secretChatHelper == null) {
                    SecretChatHelper[] secretChatHelperArr = Instance;
                    SecretChatHelper secretChatHelper2 = new SecretChatHelper(i);
                    secretChatHelperArr[i] = secretChatHelper2;
                    secretChatHelper = secretChatHelper2;
                }
            }
        }
        return secretChatHelper;
    }

    public SecretChatHelper(int i) {
        super(i);
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
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.SecretChatHelper$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processPendingEncMessages$0(arrayList);
            }
        });
        getMessagesStorage().markMessagesAsDeletedByRandoms(new ArrayList<>(this.pendingEncMessagesToDelete));
        this.pendingEncMessagesToDelete.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processPendingEncMessages$0(ArrayList arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            MessageObject messageObject = getMessagesController().dialogMessagesByRandomIds.get(((Long) arrayList.get(i)).longValue());
            if (messageObject != null) {
                messageObject.deleted = true;
            }
        }
    }

    private TLRPC$TL_messageService createServiceSecretMessage(TLRPC$EncryptedChat tLRPC$EncryptedChat, TLRPC$DecryptedMessageAction tLRPC$DecryptedMessageAction) {
        TLRPC$TL_messageService tLRPC$TL_messageService = new TLRPC$TL_messageService();
        TLRPC$TL_messageEncryptedAction tLRPC$TL_messageEncryptedAction = new TLRPC$TL_messageEncryptedAction();
        tLRPC$TL_messageService.action = tLRPC$TL_messageEncryptedAction;
        tLRPC$TL_messageEncryptedAction.encryptedAction = tLRPC$DecryptedMessageAction;
        long newMessageId = getUserConfig().getNewMessageId();
        tLRPC$TL_messageService.id = newMessageId;
        tLRPC$TL_messageService.local_id = newMessageId;
        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
        tLRPC$TL_messageService.from_id = tLRPC$TL_peerUser;
        tLRPC$TL_peerUser.user_id = getUserConfig().getClientUserId();
        tLRPC$TL_messageService.unread = true;
        tLRPC$TL_messageService.out = true;
        tLRPC$TL_messageService.flags = 256;
        tLRPC$TL_messageService.dialog_id = tLRPC$EncryptedChat.id << 32;
        tLRPC$TL_messageService.peer_id = new TLRPC$TL_peerUser();
        tLRPC$TL_messageService.send_state = 1;
        if (tLRPC$EncryptedChat.participant_id == getUserConfig().getClientUserId()) {
            tLRPC$TL_messageService.peer_id.user_id = tLRPC$EncryptedChat.admin_id;
        } else {
            tLRPC$TL_messageService.peer_id.user_id = tLRPC$EncryptedChat.participant_id;
        }
        if ((tLRPC$DecryptedMessageAction instanceof TLRPC$TL_decryptedMessageActionScreenshotMessages) || (tLRPC$DecryptedMessageAction instanceof TLRPC$TL_decryptedMessageActionSetMessageTTL)) {
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

    public void sendMessagesReadMessage(TLRPC$EncryptedChat tLRPC$EncryptedChat, ArrayList<Long> arrayList, TLRPC$Message tLRPC$Message) {
        if (tLRPC$EncryptedChat instanceof TLRPC$TL_encryptedChat) {
            TLRPC$TL_decryptedMessageService tLRPC$TL_decryptedMessageService = new TLRPC$TL_decryptedMessageService();
            if (tLRPC$Message != null) {
                tLRPC$TL_decryptedMessageService.action = tLRPC$Message.action.encryptedAction;
            } else {
                TLRPC$TL_decryptedMessageActionReadMessages tLRPC$TL_decryptedMessageActionReadMessages = new TLRPC$TL_decryptedMessageActionReadMessages();
                tLRPC$TL_decryptedMessageService.action = tLRPC$TL_decryptedMessageActionReadMessages;
                tLRPC$TL_decryptedMessageActionReadMessages.random_ids = arrayList;
                tLRPC$Message = createServiceSecretMessage(tLRPC$EncryptedChat, tLRPC$TL_decryptedMessageActionReadMessages);
            }
            TLRPC$Message tLRPC$Message2 = tLRPC$Message;
            tLRPC$TL_decryptedMessageService.random_id = tLRPC$Message2.random_id;
            performSendEncryptedRequest(tLRPC$TL_decryptedMessageService, tLRPC$Message2, tLRPC$EncryptedChat, null, null, null);
        }
    }

    protected void processUpdateEncryption(TLRPC$TL_updateEncryption tLRPC$TL_updateEncryption, ConcurrentHashMap<Integer, TLRPC$User> concurrentHashMap) {
        byte[] bArr;
        final TLRPC$EncryptedChat tLRPC$EncryptedChat = tLRPC$TL_updateEncryption.chat;
        final long j = tLRPC$EncryptedChat.id << 32;
        final TLRPC$EncryptedChat encryptedChatDB = getMessagesController().getEncryptedChatDB(tLRPC$EncryptedChat.id, false);
        if ((tLRPC$EncryptedChat instanceof TLRPC$TL_encryptedChatRequested) && encryptedChatDB == null) {
            int i = tLRPC$EncryptedChat.participant_id;
            if (i == getUserConfig().getClientUserId()) {
                i = tLRPC$EncryptedChat.admin_id;
            }
            TLRPC$User user = getMessagesController().getUser(Integer.valueOf(i));
            if (user == null) {
                user = concurrentHashMap.get(Integer.valueOf(i));
            }
            tLRPC$EncryptedChat.user_id = i;
            final TLRPC$TL_dialog tLRPC$TL_dialog = new TLRPC$TL_dialog();
            tLRPC$TL_dialog.id = j;
            tLRPC$TL_dialog.folder_id = tLRPC$EncryptedChat.folder_id;
            tLRPC$TL_dialog.unread_count = 0;
            tLRPC$TL_dialog.top_message = 0L;
            tLRPC$TL_dialog.last_message_date = tLRPC$TL_updateEncryption.date;
            getMessagesController().putEncryptedChat(tLRPC$EncryptedChat, false);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.SecretChatHelper$$ExternalSyntheticLambda13
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processUpdateEncryption$1(tLRPC$TL_dialog, j);
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
                this.delayedEncryptedChatUpdates.add(tLRPC$TL_updateEncryption);
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
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.SecretChatHelper$$ExternalSyntheticLambda18
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processUpdateEncryption$2(encryptedChatDB, tLRPC$EncryptedChat);
                }
            });
        }
        if ((tLRPC$EncryptedChat instanceof TLRPC$TL_encryptedChatDiscarded) && tLRPC$EncryptedChat.history_deleted) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.SecretChatHelper$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processUpdateEncryption$3(j);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processUpdateEncryption$1(TLRPC$Dialog tLRPC$Dialog, long j) {
        if (tLRPC$Dialog.folder_id == 1) {
            SharedPreferences.Editor editorEdit = MessagesController.getNotificationsSettings(this.currentAccount).edit();
            editorEdit.putBoolean("dialog_bar_archived" + j, true);
            editorEdit.apply();
        }
        getMessagesController().dialogs_dict.put(tLRPC$Dialog.id, tLRPC$Dialog);
        getMessagesController().allDialogs.add(tLRPC$Dialog);
        getMessagesController().sortDialogs(null);
        getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processUpdateEncryption$2(TLRPC$EncryptedChat tLRPC$EncryptedChat, TLRPC$EncryptedChat tLRPC$EncryptedChat2) {
        if (tLRPC$EncryptedChat != null) {
            getMessagesController().putEncryptedChat(tLRPC$EncryptedChat2, false);
        }
        getMessagesStorage().updateEncryptedChat(tLRPC$EncryptedChat2);
        getNotificationCenter().postNotificationName(NotificationCenter.encryptedChatUpdated, tLRPC$EncryptedChat2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processUpdateEncryption$3(long j) {
        getMessagesController().deleteDialog(j, 0);
    }

    public void sendMessagesDeleteMessage(TLRPC$EncryptedChat tLRPC$EncryptedChat, ArrayList<Long> arrayList, TLRPC$Message tLRPC$Message) {
        if (tLRPC$EncryptedChat instanceof TLRPC$TL_encryptedChat) {
            TLRPC$TL_decryptedMessageService tLRPC$TL_decryptedMessageService = new TLRPC$TL_decryptedMessageService();
            if (tLRPC$Message != null) {
                tLRPC$TL_decryptedMessageService.action = tLRPC$Message.action.encryptedAction;
            } else {
                TLRPC$TL_decryptedMessageActionDeleteMessages tLRPC$TL_decryptedMessageActionDeleteMessages = new TLRPC$TL_decryptedMessageActionDeleteMessages();
                tLRPC$TL_decryptedMessageService.action = tLRPC$TL_decryptedMessageActionDeleteMessages;
                tLRPC$TL_decryptedMessageActionDeleteMessages.random_ids = arrayList;
                tLRPC$Message = createServiceSecretMessage(tLRPC$EncryptedChat, tLRPC$TL_decryptedMessageActionDeleteMessages);
            }
            TLRPC$Message tLRPC$Message2 = tLRPC$Message;
            tLRPC$TL_decryptedMessageService.random_id = tLRPC$Message2.random_id;
            performSendEncryptedRequest(tLRPC$TL_decryptedMessageService, tLRPC$Message2, tLRPC$EncryptedChat, null, null, null);
        }
    }

    public void sendClearHistoryMessage(TLRPC$EncryptedChat tLRPC$EncryptedChat, TLRPC$Message tLRPC$Message) {
        if (tLRPC$EncryptedChat instanceof TLRPC$TL_encryptedChat) {
            TLRPC$TL_decryptedMessageService tLRPC$TL_decryptedMessageService = new TLRPC$TL_decryptedMessageService();
            if (tLRPC$Message != null) {
                tLRPC$TL_decryptedMessageService.action = tLRPC$Message.action.encryptedAction;
            } else {
                TLRPC$TL_decryptedMessageActionFlushHistory tLRPC$TL_decryptedMessageActionFlushHistory = new TLRPC$TL_decryptedMessageActionFlushHistory();
                tLRPC$TL_decryptedMessageService.action = tLRPC$TL_decryptedMessageActionFlushHistory;
                tLRPC$Message = createServiceSecretMessage(tLRPC$EncryptedChat, tLRPC$TL_decryptedMessageActionFlushHistory);
            }
            TLRPC$Message tLRPC$Message2 = tLRPC$Message;
            tLRPC$TL_decryptedMessageService.random_id = tLRPC$Message2.random_id;
            performSendEncryptedRequest(tLRPC$TL_decryptedMessageService, tLRPC$Message2, tLRPC$EncryptedChat, null, null, null);
        }
    }

    public void sendNotifyLayerMessage(TLRPC$EncryptedChat tLRPC$EncryptedChat, TLRPC$Message tLRPC$Message) {
        if ((tLRPC$EncryptedChat instanceof TLRPC$TL_encryptedChat) && !this.sendingNotifyLayer.contains(Integer.valueOf(tLRPC$EncryptedChat.id))) {
            this.sendingNotifyLayer.add(Integer.valueOf(tLRPC$EncryptedChat.id));
            TLRPC$TL_decryptedMessageService tLRPC$TL_decryptedMessageService = new TLRPC$TL_decryptedMessageService();
            if (tLRPC$Message != null) {
                tLRPC$TL_decryptedMessageService.action = tLRPC$Message.action.encryptedAction;
            } else {
                TLRPC$TL_decryptedMessageActionNotifyLayer tLRPC$TL_decryptedMessageActionNotifyLayer = new TLRPC$TL_decryptedMessageActionNotifyLayer();
                tLRPC$TL_decryptedMessageService.action = tLRPC$TL_decryptedMessageActionNotifyLayer;
                tLRPC$TL_decryptedMessageActionNotifyLayer.layer = 101;
                tLRPC$Message = createServiceSecretMessage(tLRPC$EncryptedChat, tLRPC$TL_decryptedMessageActionNotifyLayer);
            }
            TLRPC$Message tLRPC$Message2 = tLRPC$Message;
            tLRPC$TL_decryptedMessageService.random_id = tLRPC$Message2.random_id;
            performSendEncryptedRequest(tLRPC$TL_decryptedMessageService, tLRPC$Message2, tLRPC$EncryptedChat, null, null, null);
        }
    }

    public void sendRequestKeyMessage(TLRPC$EncryptedChat tLRPC$EncryptedChat, TLRPC$Message tLRPC$Message) {
        if (tLRPC$EncryptedChat instanceof TLRPC$TL_encryptedChat) {
            TLRPC$TL_decryptedMessageService tLRPC$TL_decryptedMessageService = new TLRPC$TL_decryptedMessageService();
            if (tLRPC$Message != null) {
                tLRPC$TL_decryptedMessageService.action = tLRPC$Message.action.encryptedAction;
            } else {
                TLRPC$TL_decryptedMessageActionRequestKey tLRPC$TL_decryptedMessageActionRequestKey = new TLRPC$TL_decryptedMessageActionRequestKey();
                tLRPC$TL_decryptedMessageService.action = tLRPC$TL_decryptedMessageActionRequestKey;
                tLRPC$TL_decryptedMessageActionRequestKey.exchange_id = tLRPC$EncryptedChat.exchange_id;
                tLRPC$TL_decryptedMessageActionRequestKey.g_a = tLRPC$EncryptedChat.g_a;
                tLRPC$Message = createServiceSecretMessage(tLRPC$EncryptedChat, tLRPC$TL_decryptedMessageActionRequestKey);
            }
            TLRPC$Message tLRPC$Message2 = tLRPC$Message;
            tLRPC$TL_decryptedMessageService.random_id = tLRPC$Message2.random_id;
            performSendEncryptedRequest(tLRPC$TL_decryptedMessageService, tLRPC$Message2, tLRPC$EncryptedChat, null, null, null);
        }
    }

    public void sendAcceptKeyMessage(TLRPC$EncryptedChat tLRPC$EncryptedChat, TLRPC$Message tLRPC$Message) {
        if (tLRPC$EncryptedChat instanceof TLRPC$TL_encryptedChat) {
            TLRPC$TL_decryptedMessageService tLRPC$TL_decryptedMessageService = new TLRPC$TL_decryptedMessageService();
            if (tLRPC$Message != null) {
                tLRPC$TL_decryptedMessageService.action = tLRPC$Message.action.encryptedAction;
            } else {
                TLRPC$TL_decryptedMessageActionAcceptKey tLRPC$TL_decryptedMessageActionAcceptKey = new TLRPC$TL_decryptedMessageActionAcceptKey();
                tLRPC$TL_decryptedMessageService.action = tLRPC$TL_decryptedMessageActionAcceptKey;
                tLRPC$TL_decryptedMessageActionAcceptKey.exchange_id = tLRPC$EncryptedChat.exchange_id;
                tLRPC$TL_decryptedMessageActionAcceptKey.key_fingerprint = tLRPC$EncryptedChat.future_key_fingerprint;
                tLRPC$TL_decryptedMessageActionAcceptKey.g_b = tLRPC$EncryptedChat.g_a_or_b;
                tLRPC$Message = createServiceSecretMessage(tLRPC$EncryptedChat, tLRPC$TL_decryptedMessageActionAcceptKey);
            }
            TLRPC$Message tLRPC$Message2 = tLRPC$Message;
            tLRPC$TL_decryptedMessageService.random_id = tLRPC$Message2.random_id;
            performSendEncryptedRequest(tLRPC$TL_decryptedMessageService, tLRPC$Message2, tLRPC$EncryptedChat, null, null, null);
        }
    }

    public void sendCommitKeyMessage(TLRPC$EncryptedChat tLRPC$EncryptedChat, TLRPC$Message tLRPC$Message) {
        if (tLRPC$EncryptedChat instanceof TLRPC$TL_encryptedChat) {
            TLRPC$TL_decryptedMessageService tLRPC$TL_decryptedMessageService = new TLRPC$TL_decryptedMessageService();
            if (tLRPC$Message != null) {
                tLRPC$TL_decryptedMessageService.action = tLRPC$Message.action.encryptedAction;
            } else {
                TLRPC$TL_decryptedMessageActionCommitKey tLRPC$TL_decryptedMessageActionCommitKey = new TLRPC$TL_decryptedMessageActionCommitKey();
                tLRPC$TL_decryptedMessageService.action = tLRPC$TL_decryptedMessageActionCommitKey;
                tLRPC$TL_decryptedMessageActionCommitKey.exchange_id = tLRPC$EncryptedChat.exchange_id;
                tLRPC$TL_decryptedMessageActionCommitKey.key_fingerprint = tLRPC$EncryptedChat.future_key_fingerprint;
                tLRPC$Message = createServiceSecretMessage(tLRPC$EncryptedChat, tLRPC$TL_decryptedMessageActionCommitKey);
            }
            TLRPC$Message tLRPC$Message2 = tLRPC$Message;
            tLRPC$TL_decryptedMessageService.random_id = tLRPC$Message2.random_id;
            performSendEncryptedRequest(tLRPC$TL_decryptedMessageService, tLRPC$Message2, tLRPC$EncryptedChat, null, null, null);
        }
    }

    public void sendAbortKeyMessage(TLRPC$EncryptedChat tLRPC$EncryptedChat, TLRPC$Message tLRPC$Message, long j) {
        if (tLRPC$EncryptedChat instanceof TLRPC$TL_encryptedChat) {
            TLRPC$TL_decryptedMessageService tLRPC$TL_decryptedMessageService = new TLRPC$TL_decryptedMessageService();
            if (tLRPC$Message != null) {
                tLRPC$TL_decryptedMessageService.action = tLRPC$Message.action.encryptedAction;
            } else {
                TLRPC$TL_decryptedMessageActionAbortKey tLRPC$TL_decryptedMessageActionAbortKey = new TLRPC$TL_decryptedMessageActionAbortKey();
                tLRPC$TL_decryptedMessageService.action = tLRPC$TL_decryptedMessageActionAbortKey;
                tLRPC$TL_decryptedMessageActionAbortKey.exchange_id = j;
                tLRPC$Message = createServiceSecretMessage(tLRPC$EncryptedChat, tLRPC$TL_decryptedMessageActionAbortKey);
            }
            TLRPC$Message tLRPC$Message2 = tLRPC$Message;
            tLRPC$TL_decryptedMessageService.random_id = tLRPC$Message2.random_id;
            performSendEncryptedRequest(tLRPC$TL_decryptedMessageService, tLRPC$Message2, tLRPC$EncryptedChat, null, null, null);
        }
    }

    public void sendNoopMessage(TLRPC$EncryptedChat tLRPC$EncryptedChat, TLRPC$Message tLRPC$Message) {
        if (tLRPC$EncryptedChat instanceof TLRPC$TL_encryptedChat) {
            TLRPC$TL_decryptedMessageService tLRPC$TL_decryptedMessageService = new TLRPC$TL_decryptedMessageService();
            if (tLRPC$Message != null) {
                tLRPC$TL_decryptedMessageService.action = tLRPC$Message.action.encryptedAction;
            } else {
                TLRPC$TL_decryptedMessageActionNoop tLRPC$TL_decryptedMessageActionNoop = new TLRPC$TL_decryptedMessageActionNoop();
                tLRPC$TL_decryptedMessageService.action = tLRPC$TL_decryptedMessageActionNoop;
                tLRPC$Message = createServiceSecretMessage(tLRPC$EncryptedChat, tLRPC$TL_decryptedMessageActionNoop);
            }
            TLRPC$Message tLRPC$Message2 = tLRPC$Message;
            tLRPC$TL_decryptedMessageService.random_id = tLRPC$Message2.random_id;
            performSendEncryptedRequest(tLRPC$TL_decryptedMessageService, tLRPC$Message2, tLRPC$EncryptedChat, null, null, null);
        }
    }

    public void sendResendMessage(TLRPC$EncryptedChat tLRPC$EncryptedChat, int i, int i2, TLRPC$Message tLRPC$Message) {
        if (tLRPC$EncryptedChat instanceof TLRPC$TL_encryptedChat) {
            SparseIntArray sparseIntArray = this.requestedHoles.get(tLRPC$EncryptedChat.id);
            if (sparseIntArray == null || sparseIntArray.indexOfKey(i) < 0) {
                if (sparseIntArray == null) {
                    sparseIntArray = new SparseIntArray();
                    this.requestedHoles.put(tLRPC$EncryptedChat.id, sparseIntArray);
                }
                sparseIntArray.put(i, i2);
                TLRPC$TL_decryptedMessageService tLRPC$TL_decryptedMessageService = new TLRPC$TL_decryptedMessageService();
                if (tLRPC$Message != null) {
                    tLRPC$TL_decryptedMessageService.action = tLRPC$Message.action.encryptedAction;
                } else {
                    TLRPC$TL_decryptedMessageActionResend tLRPC$TL_decryptedMessageActionResend = new TLRPC$TL_decryptedMessageActionResend();
                    tLRPC$TL_decryptedMessageService.action = tLRPC$TL_decryptedMessageActionResend;
                    tLRPC$TL_decryptedMessageActionResend.start_seq_no = i;
                    tLRPC$TL_decryptedMessageActionResend.end_seq_no = i2;
                    tLRPC$Message = createServiceSecretMessage(tLRPC$EncryptedChat, tLRPC$TL_decryptedMessageActionResend);
                }
                TLRPC$Message tLRPC$Message2 = tLRPC$Message;
                tLRPC$TL_decryptedMessageService.random_id = tLRPC$Message2.random_id;
                performSendEncryptedRequest(tLRPC$TL_decryptedMessageService, tLRPC$Message2, tLRPC$EncryptedChat, null, null, null);
            }
        }
    }

    public void sendTTLMessage(TLRPC$EncryptedChat tLRPC$EncryptedChat, TLRPC$Message tLRPC$Message) {
        if (tLRPC$EncryptedChat instanceof TLRPC$TL_encryptedChat) {
            TLRPC$TL_decryptedMessageService tLRPC$TL_decryptedMessageService = new TLRPC$TL_decryptedMessageService();
            if (tLRPC$Message != null) {
                tLRPC$TL_decryptedMessageService.action = tLRPC$Message.action.encryptedAction;
            } else {
                TLRPC$TL_decryptedMessageActionSetMessageTTL tLRPC$TL_decryptedMessageActionSetMessageTTL = new TLRPC$TL_decryptedMessageActionSetMessageTTL();
                tLRPC$TL_decryptedMessageService.action = tLRPC$TL_decryptedMessageActionSetMessageTTL;
                tLRPC$TL_decryptedMessageActionSetMessageTTL.ttl_seconds = tLRPC$EncryptedChat.ttl;
                tLRPC$Message = createServiceSecretMessage(tLRPC$EncryptedChat, tLRPC$TL_decryptedMessageActionSetMessageTTL);
                MessageObject messageObject = new MessageObject(this.currentAccount, tLRPC$Message, false, false);
                messageObject.messageOwner.send_state = 1;
                messageObject.wasJustSent = true;
                ArrayList<MessageObject> arrayList = new ArrayList<>();
                arrayList.add(messageObject);
                getMessagesController().updateInterfaceWithMessages(tLRPC$Message.dialog_id, arrayList, false);
                getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[0]);
            }
            TLRPC$Message tLRPC$Message2 = tLRPC$Message;
            tLRPC$TL_decryptedMessageService.random_id = tLRPC$Message2.random_id;
            performSendEncryptedRequest(tLRPC$TL_decryptedMessageService, tLRPC$Message2, tLRPC$EncryptedChat, null, null, null);
        }
    }

    public void sendScreenshotMessage(TLRPC$EncryptedChat tLRPC$EncryptedChat, ArrayList<Long> arrayList, TLRPC$Message tLRPC$Message) {
        if (tLRPC$EncryptedChat instanceof TLRPC$TL_encryptedChat) {
            TLRPC$TL_decryptedMessageService tLRPC$TL_decryptedMessageService = new TLRPC$TL_decryptedMessageService();
            if (tLRPC$Message != null) {
                tLRPC$TL_decryptedMessageService.action = tLRPC$Message.action.encryptedAction;
            } else {
                TLRPC$TL_decryptedMessageActionScreenshotMessages tLRPC$TL_decryptedMessageActionScreenshotMessages = new TLRPC$TL_decryptedMessageActionScreenshotMessages();
                tLRPC$TL_decryptedMessageService.action = tLRPC$TL_decryptedMessageActionScreenshotMessages;
                tLRPC$TL_decryptedMessageActionScreenshotMessages.random_ids = arrayList;
                tLRPC$Message = createServiceSecretMessage(tLRPC$EncryptedChat, tLRPC$TL_decryptedMessageActionScreenshotMessages);
                MessageObject messageObject = new MessageObject(this.currentAccount, tLRPC$Message, false, false);
                messageObject.messageOwner.send_state = 1;
                messageObject.wasJustSent = true;
                ArrayList<MessageObject> arrayList2 = new ArrayList<>();
                arrayList2.add(messageObject);
                getMessagesController().updateInterfaceWithMessages(tLRPC$Message.dialog_id, arrayList2, false);
                getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[0]);
            }
            TLRPC$Message tLRPC$Message2 = tLRPC$Message;
            tLRPC$TL_decryptedMessageService.random_id = tLRPC$Message2.random_id;
            performSendEncryptedRequest(tLRPC$TL_decryptedMessageService, tLRPC$Message2, tLRPC$EncryptedChat, null, null, null);
        }
    }

    private void updateMediaPaths(MessageObject messageObject, TLRPC$EncryptedFile tLRPC$EncryptedFile, TLRPC$DecryptedMessage tLRPC$DecryptedMessage, String str) {
        TLRPC$Document tLRPC$Document;
        TLRPC$Photo tLRPC$Photo;
        TLRPC$Message tLRPC$Message = messageObject.messageOwner;
        if (tLRPC$EncryptedFile != null) {
            TLRPC$MessageMedia tLRPC$MessageMedia = tLRPC$Message.media;
            if ((tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaPhoto) && (tLRPC$Photo = tLRPC$MessageMedia.photo) != null) {
                ArrayList<TLRPC$PhotoSize> arrayList = tLRPC$Photo.sizes;
                TLRPC$PhotoSize tLRPC$PhotoSize = arrayList.get(arrayList.size() - 1);
                String str2 = tLRPC$PhotoSize.location.volume_id + "_" + tLRPC$PhotoSize.location.local_id;
                TLRPC$TL_fileEncryptedLocation tLRPC$TL_fileEncryptedLocation = new TLRPC$TL_fileEncryptedLocation();
                tLRPC$PhotoSize.location = tLRPC$TL_fileEncryptedLocation;
                TLRPC$DecryptedMessageMedia tLRPC$DecryptedMessageMedia = tLRPC$DecryptedMessage.media;
                tLRPC$TL_fileEncryptedLocation.key = tLRPC$DecryptedMessageMedia.key;
                tLRPC$TL_fileEncryptedLocation.iv = tLRPC$DecryptedMessageMedia.iv;
                tLRPC$TL_fileEncryptedLocation.dc_id = tLRPC$EncryptedFile.dc_id;
                tLRPC$TL_fileEncryptedLocation.volume_id = tLRPC$EncryptedFile.id;
                tLRPC$TL_fileEncryptedLocation.secret = tLRPC$EncryptedFile.access_hash;
                tLRPC$TL_fileEncryptedLocation.local_id = tLRPC$EncryptedFile.key_fingerprint;
                String str3 = tLRPC$PhotoSize.location.volume_id + "_" + tLRPC$PhotoSize.location.local_id;
                new File(FileLoader.getDirectory(4), str2 + ".jpg").renameTo(FileLoader.getPathToAttach(tLRPC$PhotoSize));
                ImageLoader.getInstance().replaceImageInCache(str2, str3, ImageLocation.getForPhoto(tLRPC$PhotoSize, tLRPC$Message.media.photo), true);
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
            tLRPC$Document2.id = tLRPC$EncryptedFile.id;
            tLRPC$Document2.access_hash = tLRPC$EncryptedFile.access_hash;
            tLRPC$Document2.date = tLRPC$Document.date;
            tLRPC$Document2.attributes = tLRPC$Document.attributes;
            tLRPC$Document2.mime_type = tLRPC$Document.mime_type;
            tLRPC$Document2.size = tLRPC$EncryptedFile.size;
            TLRPC$DecryptedMessageMedia tLRPC$DecryptedMessageMedia2 = tLRPC$DecryptedMessage.media;
            tLRPC$Document2.key = tLRPC$DecryptedMessageMedia2.key;
            tLRPC$Document2.iv = tLRPC$DecryptedMessageMedia2.iv;
            ArrayList<TLRPC$PhotoSize> arrayList3 = tLRPC$Document.thumbs;
            tLRPC$Document2.thumbs = arrayList3;
            tLRPC$Document2.dc_id = tLRPC$EncryptedFile.dc_id;
            if (arrayList3.isEmpty()) {
                TLRPC$TL_photoSizeEmpty tLRPC$TL_photoSizeEmpty = new TLRPC$TL_photoSizeEmpty();
                tLRPC$TL_photoSizeEmpty.type = "s";
                tLRPC$Message.media.document.thumbs.add(tLRPC$TL_photoSizeEmpty);
            }
            String str4 = tLRPC$Message.attachPath;
            if (str4 != null && str4.startsWith(FileLoader.getDirectory(4).getAbsolutePath()) && new File(tLRPC$Message.attachPath).renameTo(FileLoader.getPathToAttach(tLRPC$Message.media.document))) {
                messageObject.mediaExists = messageObject.attachPathExists;
                messageObject.attachPathExists = false;
                tLRPC$Message.attachPath = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
            }
            ArrayList<TLRPC$Message> arrayList4 = new ArrayList<>();
            arrayList4.add(tLRPC$Message);
            getMessagesStorage().putMessages(arrayList4, false, true, false, 0, false);
        }
    }

    public static boolean isSecretVisibleMessage(TLRPC$Message tLRPC$Message) {
        TLRPC$MessageAction tLRPC$MessageAction = tLRPC$Message.action;
        if (tLRPC$MessageAction instanceof TLRPC$TL_messageEncryptedAction) {
            TLRPC$DecryptedMessageAction tLRPC$DecryptedMessageAction = tLRPC$MessageAction.encryptedAction;
            if ((tLRPC$DecryptedMessageAction instanceof TLRPC$TL_decryptedMessageActionScreenshotMessages) || (tLRPC$DecryptedMessageAction instanceof TLRPC$TL_decryptedMessageActionSetMessageTTL)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSecretInvisibleMessage(TLRPC$Message tLRPC$Message) {
        TLRPC$MessageAction tLRPC$MessageAction = tLRPC$Message.action;
        if (tLRPC$MessageAction instanceof TLRPC$TL_messageEncryptedAction) {
            TLRPC$DecryptedMessageAction tLRPC$DecryptedMessageAction = tLRPC$MessageAction.encryptedAction;
            if (!(tLRPC$DecryptedMessageAction instanceof TLRPC$TL_decryptedMessageActionScreenshotMessages) && !(tLRPC$DecryptedMessageAction instanceof TLRPC$TL_decryptedMessageActionSetMessageTTL)) {
                return true;
            }
        }
        return false;
    }

    protected void performSendEncryptedRequest(TLRPC$TL_messages_sendEncryptedMultiMedia tLRPC$TL_messages_sendEncryptedMultiMedia, SendMessagesHelper.DelayedMessage delayedMessage) {
        for (int i = 0; i < tLRPC$TL_messages_sendEncryptedMultiMedia.files.size(); i++) {
            performSendEncryptedRequest(tLRPC$TL_messages_sendEncryptedMultiMedia.messages.get(i), delayedMessage.messages.get(i), delayedMessage.encryptedChat, tLRPC$TL_messages_sendEncryptedMultiMedia.files.get(i), delayedMessage.originalPaths.get(i), delayedMessage.messageObjects.get(i));
        }
    }

    protected void performSendEncryptedRequest(final TLRPC$DecryptedMessage tLRPC$DecryptedMessage, final TLRPC$Message tLRPC$Message, final TLRPC$EncryptedChat tLRPC$EncryptedChat, final TLRPC$InputEncryptedFile tLRPC$InputEncryptedFile, final String str, final MessageObject messageObject) {
        if (tLRPC$DecryptedMessage == null || tLRPC$EncryptedChat.auth_key == null || (tLRPC$EncryptedChat instanceof TLRPC$TL_encryptedChatRequested) || (tLRPC$EncryptedChat instanceof TLRPC$TL_encryptedChatWaiting)) {
            return;
        }
        getSendMessagesHelper().putToSendingMessages(tLRPC$Message, false);
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.SecretChatHelper$$ExternalSyntheticLambda17
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$performSendEncryptedRequest$8(tLRPC$EncryptedChat, tLRPC$DecryptedMessage, tLRPC$Message, tLRPC$InputEncryptedFile, messageObject, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$performSendEncryptedRequest$8(final TLRPC$EncryptedChat tLRPC$EncryptedChat, final TLRPC$DecryptedMessage tLRPC$DecryptedMessage, final TLRPC$Message tLRPC$Message, TLRPC$InputEncryptedFile tLRPC$InputEncryptedFile, final MessageObject messageObject, final String str) {
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
            int i = AndroidUtilities.getPeerLayerVersion(tLRPC$EncryptedChat.layer) >= 73 ? 2 : 1;
            if (tLRPC$EncryptedChat.seq_in == 0 && tLRPC$EncryptedChat.seq_out == 0) {
                if (tLRPC$EncryptedChat.admin_id == getUserConfig().getClientUserId()) {
                    tLRPC$EncryptedChat.seq_out = 1;
                    tLRPC$EncryptedChat.seq_in = -2;
                } else {
                    tLRPC$EncryptedChat.seq_in = -1;
                }
            }
            int i2 = tLRPC$Message.seq_in;
            if (i2 == 0 && tLRPC$Message.seq_out == 0) {
                int i3 = tLRPC$EncryptedChat.seq_in;
                if (i3 <= 0) {
                    i3 += 2;
                }
                tLRPC$TL_decryptedMessageLayer.in_seq_no = i3;
                int i4 = tLRPC$EncryptedChat.seq_out;
                tLRPC$TL_decryptedMessageLayer.out_seq_no = i4;
                tLRPC$EncryptedChat.seq_out = i4 + 2;
                if (AndroidUtilities.getPeerLayerVersion(tLRPC$EncryptedChat.layer) >= 20) {
                    if (tLRPC$EncryptedChat.key_create_date == 0) {
                        tLRPC$EncryptedChat.key_create_date = getConnectionsManager().getCurrentTime();
                    }
                    short s = (short) (tLRPC$EncryptedChat.key_use_count_out + 1);
                    tLRPC$EncryptedChat.key_use_count_out = s;
                    if ((s >= 100 || tLRPC$EncryptedChat.key_create_date < getConnectionsManager().getCurrentTime() - 604800) && tLRPC$EncryptedChat.exchange_id == 0 && tLRPC$EncryptedChat.future_key_fingerprint == 0) {
                        requestNewSecretChatKey(tLRPC$EncryptedChat);
                    }
                }
                getMessagesStorage().updateEncryptedChatSeq(tLRPC$EncryptedChat, false);
                tLRPC$Message.seq_in = tLRPC$TL_decryptedMessageLayer.in_seq_no;
                tLRPC$Message.seq_out = tLRPC$TL_decryptedMessageLayer.out_seq_no;
                getMessagesStorage().setMessageSeq(tLRPC$Message.id, tLRPC$Message.seq_in, tLRPC$Message.seq_out);
            } else {
                tLRPC$TL_decryptedMessageLayer.in_seq_no = i2;
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
            int iNextInt = length % 16 != 0 ? 16 - (length % 16) : 0;
            if (i == 2) {
                iNextInt += (Utilities.random.nextInt(3) + 2) * 16;
            }
            NativeByteBuffer nativeByteBuffer2 = new NativeByteBuffer(length + iNextInt);
            nativeByteBuffer.position(0);
            nativeByteBuffer2.writeBytes(nativeByteBuffer);
            if (iNextInt != 0) {
                byte[] bArr2 = new byte[iNextInt];
                Utilities.random.nextBytes(bArr2);
                nativeByteBuffer2.writeBytes(bArr2);
            }
            byte[] bArr3 = new byte[16];
            if (i != 2 || tLRPC$EncryptedChat.admin_id == getUserConfig().getClientUserId()) {
                z = false;
            }
            if (i == 2) {
                byte[] bArr4 = tLRPC$EncryptedChat.auth_key;
                int i5 = z ? 8 : 0;
                ByteBuffer byteBuffer = nativeByteBuffer2.buffer;
                System.arraycopy(Utilities.computeSHA256(bArr4, i5 + 88, 32, byteBuffer, 0, byteBuffer.limit()), 8, bArr3, 0, 16);
            } else {
                byte[] bArrComputeSHA1 = Utilities.computeSHA1(nativeByteBuffer.buffer);
                System.arraycopy(bArrComputeSHA1, bArrComputeSHA1.length - 16, bArr3, 0, 16);
            }
            nativeByteBuffer.reuse();
            MessageKeyData messageKeyDataGenerateMessageKeyData = MessageKeyData.generateMessageKeyData(tLRPC$EncryptedChat.auth_key, bArr3, z, i);
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
            getConnectionsManager().sendRequest(tLRPC$TL_messages_sendEncryptedFile, new RequestDelegate() { // from class: org.rbmain.messenger.SecretChatHelper$$ExternalSyntheticLambda28
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$performSendEncryptedRequest$7(tLRPC$DecryptedMessage, tLRPC$EncryptedChat, tLRPC$Message, messageObject, str, tLObject, tLRPC$TL_error);
                }
            }, 64);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$performSendEncryptedRequest$7(org.rbmain.tgnet.TLRPC$DecryptedMessage r9, org.rbmain.tgnet.TLRPC$EncryptedChat r10, final org.rbmain.tgnet.TLRPC$Message r11, org.rbmain.messenger.MessageObject r12, java.lang.String r13, org.rbmain.tgnet.TLObject r14, org.rbmain.tgnet.TLRPC$TL_error r15) {
        /*
            r8 = this;
            r0 = 0
            if (r15 != 0) goto L76
            org.rbmain.tgnet.TLRPC$DecryptedMessageAction r1 = r9.action
            boolean r1 = r1 instanceof org.rbmain.tgnet.TLRPC$TL_decryptedMessageActionNotifyLayer
            if (r1 == 0) goto L76
            org.rbmain.messenger.MessagesController r1 = r8.getMessagesController()
            int r2 = r10.id
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            org.rbmain.tgnet.TLRPC$EncryptedChat r1 = r1.getEncryptedChat(r2)
            if (r1 != 0) goto L1a
            r1 = r10
        L1a:
            byte[] r2 = r1.key_hash
            if (r2 != 0) goto L26
            byte[] r2 = r1.auth_key
            byte[] r2 = org.rbmain.messenger.AndroidUtilities.calcAuthKeyHash(r2)
            r1.key_hash = r2
        L26:
            int r2 = r1.layer
            int r2 = org.rbmain.messenger.AndroidUtilities.getPeerLayerVersion(r2)
            r3 = 46
            if (r2 < r3) goto L5a
            byte[] r2 = r1.key_hash
            int r2 = r2.length
            r3 = 16
            if (r2 != r3) goto L5a
            byte[] r2 = r10.auth_key     // Catch: java.lang.Throwable -> L56
            int r4 = r2.length     // Catch: java.lang.Throwable -> L56
            byte[] r2 = org.rbmain.messenger.Utilities.computeSHA256(r2, r0, r4)     // Catch: java.lang.Throwable -> L56
            r4 = 36
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L56
            byte[] r10 = r10.key_hash     // Catch: java.lang.Throwable -> L56
            java.lang.System.arraycopy(r10, r0, r4, r0, r3)     // Catch: java.lang.Throwable -> L56
            r10 = 20
            java.lang.System.arraycopy(r2, r0, r4, r3, r10)     // Catch: java.lang.Throwable -> L56
            r1.key_hash = r4     // Catch: java.lang.Throwable -> L56
            org.rbmain.messenger.MessagesStorage r10 = r8.getMessagesStorage()     // Catch: java.lang.Throwable -> L56
            r10.updateEncryptedChat(r1)     // Catch: java.lang.Throwable -> L56
            goto L5a
        L56:
            r10 = move-exception
            org.rbmain.messenger.FileLog.e(r10)
        L5a:
            java.util.ArrayList<java.lang.Integer> r10 = r8.sendingNotifyLayer
            int r2 = r1.id
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r10.remove(r2)
            int r10 = r1.layer
            r2 = 101(0x65, float:1.42E-43)
            int r10 = org.rbmain.messenger.AndroidUtilities.setMyLayerVersion(r10, r2)
            r1.layer = r10
            org.rbmain.messenger.MessagesStorage r10 = r8.getMessagesStorage()
            r10.updateEncryptedChatLayer(r1)
        L76:
            if (r11 == 0) goto Lbe
            if (r15 != 0) goto Laf
            java.lang.String r7 = r11.attachPath
            r5 = r14
            org.rbmain.tgnet.TLRPC$messages_SentEncryptedMessage r5 = (org.rbmain.tgnet.TLRPC$messages_SentEncryptedMessage) r5
            boolean r10 = isSecretVisibleMessage(r11)
            if (r10 == 0) goto L89
            int r10 = r5.date
            r11.date = r10
        L89:
            if (r12 == 0) goto L9a
            org.rbmain.tgnet.TLRPC$EncryptedFile r10 = r5.file
            boolean r14 = r10 instanceof org.rbmain.tgnet.TLRPC$TL_encryptedFile
            if (r14 == 0) goto L9a
            r8.updateMediaPaths(r12, r10, r9, r13)
            int r0 = r12.getMediaExistanceFlags()
            r6 = r0
            goto L9b
        L9a:
            r6 = 0
        L9b:
            org.rbmain.messenger.MessagesStorage r9 = r8.getMessagesStorage()
            org.rbmain.messenger.DispatchQueue r9 = r9.getStorageQueue()
            org.rbmain.messenger.SecretChatHelper$$ExternalSyntheticLambda21 r10 = new org.rbmain.messenger.SecretChatHelper$$ExternalSyntheticLambda21
            r2 = r10
            r3 = r8
            r4 = r11
            r2.<init>()
            r9.postRunnable(r10)
            goto Lbe
        Laf:
            org.rbmain.messenger.MessagesStorage r9 = r8.getMessagesStorage()
            r9.markMessageAsSendError(r11, r0)
            org.rbmain.messenger.SecretChatHelper$$ExternalSyntheticLambda19 r9 = new org.rbmain.messenger.SecretChatHelper$$ExternalSyntheticLambda19
            r9.<init>()
            org.rbmain.messenger.AndroidUtilities.runOnUIThread(r9)
        Lbe:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.SecretChatHelper.lambda$performSendEncryptedRequest$7(org.rbmain.tgnet.TLRPC$DecryptedMessage, org.rbmain.tgnet.TLRPC$EncryptedChat, org.rbmain.tgnet.TLRPC$Message, org.rbmain.messenger.MessageObject, java.lang.String, org.rbmain.tgnet.TLObject, org.rbmain.tgnet.TLRPC$TL_error):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$performSendEncryptedRequest$5(final TLRPC$Message tLRPC$Message, TLRPC$messages_SentEncryptedMessage tLRPC$messages_SentEncryptedMessage, final int i, final String str) {
        if (isSecretInvisibleMessage(tLRPC$Message)) {
            tLRPC$messages_SentEncryptedMessage.date = 0;
        }
        getMessagesStorage().updateMessageStateAndId(tLRPC$Message.random_id, Long.valueOf(tLRPC$Message.id), tLRPC$Message.id, tLRPC$messages_SentEncryptedMessage.date, false, 0, 0);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.SecretChatHelper$$ExternalSyntheticLambda20
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$performSendEncryptedRequest$4(tLRPC$Message, i, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$performSendEncryptedRequest$4(TLRPC$Message tLRPC$Message, int i, String str) {
        tLRPC$Message.send_state = 0;
        getNotificationCenter().postNotificationName(NotificationCenter.messageReceivedByServer, Long.valueOf(tLRPC$Message.id), Long.valueOf(tLRPC$Message.id), tLRPC$Message, Long.valueOf(tLRPC$Message.dialog_id), 0L, Integer.valueOf(i), Boolean.FALSE);
        getSendMessagesHelper().processSentMessage(tLRPC$Message.id);
        if (MessageObject.isVideoMessage(tLRPC$Message) || MessageObject.isNewGifMessage(tLRPC$Message) || MessageObject.isRoundVideoMessage(tLRPC$Message)) {
            getSendMessagesHelper().stopVideoService(str);
        }
        getSendMessagesHelper().removeFromSendingMessages(tLRPC$Message.id, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$performSendEncryptedRequest$6(TLRPC$Message tLRPC$Message) {
        tLRPC$Message.send_state = 2;
        getNotificationCenter().postNotificationName(NotificationCenter.messageSendError, Long.valueOf(tLRPC$Message.id));
        getSendMessagesHelper().processSentMessage(tLRPC$Message.id);
        if (MessageObject.isVideoMessage(tLRPC$Message) || MessageObject.isNewGifMessage(tLRPC$Message) || MessageObject.isRoundVideoMessage(tLRPC$Message)) {
            getSendMessagesHelper().stopVideoService(tLRPC$Message.attachPath);
        }
        getSendMessagesHelper().removeFromSendingMessages(tLRPC$Message.id, false);
    }

    private void applyPeerLayer(final TLRPC$EncryptedChat tLRPC$EncryptedChat, int i) {
        int peerLayerVersion = AndroidUtilities.getPeerLayerVersion(tLRPC$EncryptedChat.layer);
        if (i <= peerLayerVersion) {
            return;
        }
        if (tLRPC$EncryptedChat.key_hash.length == 16 && peerLayerVersion >= 46) {
            try {
                byte[] bArr = tLRPC$EncryptedChat.auth_key;
                byte[] bArrComputeSHA256 = Utilities.computeSHA256(bArr, 0, bArr.length);
                byte[] bArr2 = new byte[36];
                System.arraycopy(tLRPC$EncryptedChat.key_hash, 0, bArr2, 0, 16);
                System.arraycopy(bArrComputeSHA256, 0, bArr2, 16, 20);
                tLRPC$EncryptedChat.key_hash = bArr2;
                getMessagesStorage().updateEncryptedChat(tLRPC$EncryptedChat);
            } catch (Throwable th) {
                FileLog.e(th);
            }
        }
        tLRPC$EncryptedChat.layer = AndroidUtilities.setPeerLayerVersion(tLRPC$EncryptedChat.layer, i);
        getMessagesStorage().updateEncryptedChatLayer(tLRPC$EncryptedChat);
        if (peerLayerVersion < 101) {
            sendNotifyLayerMessage(tLRPC$EncryptedChat, null);
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.SecretChatHelper$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$applyPeerLayer$9(tLRPC$EncryptedChat);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$applyPeerLayer$9(TLRPC$EncryptedChat tLRPC$EncryptedChat) {
        getNotificationCenter().postNotificationName(NotificationCenter.encryptedChatUpdated, tLRPC$EncryptedChat);
    }

    /* JADX WARN: Removed duplicated region for block: B:315:0x07ee  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x07fe  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x0872  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.rbmain.tgnet.TLRPC$Message processDecryptedObject(org.rbmain.tgnet.TLRPC$EncryptedChat r18, org.rbmain.tgnet.TLRPC$EncryptedFile r19, int r20, org.rbmain.tgnet.TLObject r21, boolean r22) {
        /*
            Method dump skipped, instructions count: 2408
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.SecretChatHelper.processDecryptedObject(org.rbmain.tgnet.TLRPC$EncryptedChat, org.rbmain.tgnet.TLRPC$EncryptedFile, int, org.rbmain.tgnet.TLObject, boolean):org.rbmain.tgnet.TLRPC$Message");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processDecryptedObject$12(final long j) {
        TLRPC$Dialog tLRPC$Dialog = getMessagesController().dialogs_dict.get(j);
        if (tLRPC$Dialog != null) {
            tLRPC$Dialog.unread_count = 0;
            getMessagesController().dialogMessage.remove(tLRPC$Dialog.id);
        }
        getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: org.rbmain.messenger.SecretChatHelper$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processDecryptedObject$11(j);
            }
        });
        getMessagesStorage().deleteDialog(j, 1);
        getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[0]);
        getNotificationCenter().postNotificationName(NotificationCenter.removeAllMessagesFromDialog, Long.valueOf(j), Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processDecryptedObject$11(final long j) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.SecretChatHelper$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processDecryptedObject$10(j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processDecryptedObject$10(long j) {
        getNotificationsController().processReadMessages((LongSparseIntArray) null, j, 0, ConnectionsManager.DEFAULT_DATACENTER_ID, false);
        LongSparseArray<Integer> longSparseArray = new LongSparseArray<>(1);
        longSparseArray.put(j, 0);
        getNotificationsController().processDialogsUpdateRead(longSparseArray);
    }

    private TLRPC$Message createDeleteMessage(long j, int i, int i2, long j2, TLRPC$EncryptedChat tLRPC$EncryptedChat) {
        TLRPC$TL_messageService tLRPC$TL_messageService = new TLRPC$TL_messageService();
        TLRPC$TL_messageEncryptedAction tLRPC$TL_messageEncryptedAction = new TLRPC$TL_messageEncryptedAction();
        tLRPC$TL_messageService.action = tLRPC$TL_messageEncryptedAction;
        tLRPC$TL_messageEncryptedAction.encryptedAction = new TLRPC$TL_decryptedMessageActionDeleteMessages();
        tLRPC$TL_messageService.action.encryptedAction.random_ids.add(Long.valueOf(j2));
        tLRPC$TL_messageService.id = j;
        tLRPC$TL_messageService.local_id = j;
        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
        tLRPC$TL_messageService.from_id = tLRPC$TL_peerUser;
        tLRPC$TL_peerUser.user_id = getUserConfig().getClientUserId();
        tLRPC$TL_messageService.unread = true;
        tLRPC$TL_messageService.out = true;
        tLRPC$TL_messageService.flags = 256;
        tLRPC$TL_messageService.dialog_id = tLRPC$EncryptedChat.id << 32;
        tLRPC$TL_messageService.send_state = 1;
        tLRPC$TL_messageService.seq_in = i2;
        tLRPC$TL_messageService.seq_out = i;
        tLRPC$TL_messageService.peer_id = new TLRPC$TL_peerUser();
        if (tLRPC$EncryptedChat.participant_id == getUserConfig().getClientUserId()) {
            tLRPC$TL_messageService.peer_id.user_id = tLRPC$EncryptedChat.admin_id;
        } else {
            tLRPC$TL_messageService.peer_id.user_id = tLRPC$EncryptedChat.participant_id;
        }
        tLRPC$TL_messageService.date = 0;
        tLRPC$TL_messageService.random_id = j2;
        return tLRPC$TL_messageService;
    }

    private void resendMessages(final int i, final int i2, final TLRPC$EncryptedChat tLRPC$EncryptedChat) {
        if (tLRPC$EncryptedChat == null || i2 - i < 0) {
            return;
        }
        getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: org.rbmain.messenger.SecretChatHelper$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$resendMessages$15(i, tLRPC$EncryptedChat, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$resendMessages$15(int i, TLRPC$EncryptedChat tLRPC$EncryptedChat, int i2) {
        ArrayList<TLRPC$Message> arrayList;
        long j;
        SparseArray sparseArray;
        TLRPC$Message tLRPC$MessageCreateDeleteMessage;
        try {
            int i3 = (tLRPC$EncryptedChat.admin_id == getUserConfig().getClientUserId() && i % 2 == 0) ? i + 1 : i;
            int i4 = 5;
            int i5 = 1;
            int i6 = 2;
            SQLiteCursor sQLiteCursorQueryFinalized = getMessagesStorage().getDatabase().queryFinalized(String.format(Locale.US, "SELECT uid FROM requested_holes WHERE uid = %d AND ((seq_out_start >= %d AND %d <= seq_out_end) OR (seq_out_start >= %d AND %d <= seq_out_end))", Integer.valueOf(tLRPC$EncryptedChat.id), Integer.valueOf(i3), Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(i2)), new Object[0]);
            boolean next = sQLiteCursorQueryFinalized.next();
            sQLiteCursorQueryFinalized.dispose();
            if (next) {
                return;
            }
            long j2 = tLRPC$EncryptedChat.id << 32;
            SparseArray sparseArray2 = new SparseArray();
            ArrayList<TLRPC$Message> arrayList2 = new ArrayList<>();
            for (int i7 = i3; i7 <= i2; i7 += 2) {
                sparseArray2.put(i7, null);
            }
            SQLiteCursor sQLiteCursorQueryFinalized2 = getMessagesStorage().getDatabase().queryFinalized(String.format(Locale.US, "SELECT m.data, r.random_id, s.seq_in, s.seq_out, m.ttl, s.mid FROM messages_seq as s LEFT JOIN randoms as r ON r.mid = s.mid LEFT JOIN messages as m ON m.mid = s.mid WHERE m.uid = %d AND m.out = 1 AND s.seq_out >= %d AND s.seq_out <= %d ORDER BY seq_out ASC", Long.valueOf(j2), Integer.valueOf(i3), Integer.valueOf(i2)), new Object[0]);
            while (sQLiteCursorQueryFinalized2.next()) {
                long jLongValue = sQLiteCursorQueryFinalized2.longValue(i5);
                if (jLongValue == 0) {
                    jLongValue = Utilities.random.nextLong();
                }
                long j3 = jLongValue;
                int iIntValue = sQLiteCursorQueryFinalized2.intValue(i6);
                int iIntValue2 = sQLiteCursorQueryFinalized2.intValue(3);
                ArrayList<TLRPC$Message> arrayList3 = arrayList2;
                long jIntValue = sQLiteCursorQueryFinalized2.intValue(i4);
                NativeByteBuffer nativeByteBufferByteBufferValue = sQLiteCursorQueryFinalized2.byteBufferValue(0);
                if (nativeByteBufferByteBufferValue != null) {
                    tLRPC$MessageCreateDeleteMessage = TLRPC$Message.TLdeserialize(nativeByteBufferByteBufferValue, nativeByteBufferByteBufferValue.readInt32(false), false);
                    tLRPC$MessageCreateDeleteMessage.readAttachPath(nativeByteBufferByteBufferValue, getUserConfig().clientUserId);
                    nativeByteBufferByteBufferValue.reuse();
                    tLRPC$MessageCreateDeleteMessage.random_id = j3;
                    tLRPC$MessageCreateDeleteMessage.dialog_id = j2;
                    tLRPC$MessageCreateDeleteMessage.seq_in = iIntValue;
                    tLRPC$MessageCreateDeleteMessage.seq_out = iIntValue2;
                    tLRPC$MessageCreateDeleteMessage.ttl = sQLiteCursorQueryFinalized2.intValue(4);
                    sparseArray = sparseArray2;
                    arrayList = arrayList3;
                    j = j2;
                } else {
                    arrayList = arrayList3;
                    j = j2;
                    sparseArray = sparseArray2;
                    tLRPC$MessageCreateDeleteMessage = createDeleteMessage(jIntValue, iIntValue2, iIntValue, j3, tLRPC$EncryptedChat);
                }
                arrayList.add(tLRPC$MessageCreateDeleteMessage);
                sparseArray.remove(iIntValue2);
                arrayList2 = arrayList;
                sparseArray2 = sparseArray;
                j2 = j;
                i4 = 5;
                i5 = 1;
                i6 = 2;
            }
            final ArrayList<TLRPC$Message> arrayList4 = arrayList2;
            SparseArray sparseArray3 = sparseArray2;
            sQLiteCursorQueryFinalized2.dispose();
            if (sparseArray3.size() != 0) {
                for (int i8 = 0; i8 < sparseArray3.size(); i8++) {
                    int iKeyAt = sparseArray3.keyAt(i8);
                    arrayList4.add(createDeleteMessage(getUserConfig().getNewMessageId(), iKeyAt, iKeyAt + 1, Utilities.random.nextLong(), tLRPC$EncryptedChat));
                }
                getUserConfig().saveConfig(false);
            }
            Collections.sort(arrayList4, new Comparator() { // from class: org.rbmain.messenger.SecretChatHelper$$ExternalSyntheticLambda25
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return SecretChatHelper.lambda$resendMessages$13((TLRPC$Message) obj, (TLRPC$Message) obj2);
                }
            });
            ArrayList<TLRPC$EncryptedChat> arrayList5 = new ArrayList<>();
            arrayList5.add(tLRPC$EncryptedChat);
            try {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.SecretChatHelper$$ExternalSyntheticLambda12
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$resendMessages$14(arrayList4);
                    }
                });
                getSendMessagesHelper().processUnsentMessages(arrayList4, null, new ArrayList<>(), new ArrayList<>(), arrayList5);
                getMessagesStorage().getDatabase().executeFast(String.format(Locale.US, "REPLACE INTO requested_holes VALUES(%d, %d, %d)", Integer.valueOf(tLRPC$EncryptedChat.id), Integer.valueOf(i3), Integer.valueOf(i2))).stepThis().dispose();
            } catch (Exception e) {
                e = e;
                FileLog.e(e);
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$resendMessages$13(TLRPC$Message tLRPC$Message, TLRPC$Message tLRPC$Message2) {
        return AndroidUtilities.compare(tLRPC$Message.seq_out, tLRPC$Message2.seq_out);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$resendMessages$14(ArrayList arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            MessageObject messageObject = new MessageObject(this.currentAccount, (TLRPC$Message) arrayList.get(i), false, true);
            messageObject.resendAsIs = true;
            getSendMessagesHelper().retrySendMessage(messageObject, true);
        }
    }

    public void checkSecretHoles(TLRPC$EncryptedChat tLRPC$EncryptedChat, ArrayList<TLRPC$Message> arrayList) {
        TL_decryptedMessageHolder tL_decryptedMessageHolder;
        TLRPC$TL_decryptedMessageLayer tLRPC$TL_decryptedMessageLayer;
        int i;
        int i2;
        ArrayList<TL_decryptedMessageHolder> arrayList2 = this.secretHolesQueue.get(tLRPC$EncryptedChat.id);
        if (arrayList2 == null) {
            return;
        }
        Collections.sort(arrayList2, new Comparator() { // from class: org.rbmain.messenger.SecretChatHelper$$ExternalSyntheticLambda24
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return SecretChatHelper.lambda$checkSecretHoles$16((SecretChatHelper.TL_decryptedMessageHolder) obj, (SecretChatHelper.TL_decryptedMessageHolder) obj2);
            }
        });
        boolean z = false;
        while (arrayList2.size() > 0 && ((i = (tLRPC$TL_decryptedMessageLayer = (tL_decryptedMessageHolder = arrayList2.get(0)).layer).out_seq_no) == (i2 = tLRPC$EncryptedChat.seq_in) || i2 == i - 2)) {
            applyPeerLayer(tLRPC$EncryptedChat, tLRPC$TL_decryptedMessageLayer.layer);
            TLRPC$TL_decryptedMessageLayer tLRPC$TL_decryptedMessageLayer2 = tL_decryptedMessageHolder.layer;
            tLRPC$EncryptedChat.seq_in = tLRPC$TL_decryptedMessageLayer2.out_seq_no;
            tLRPC$EncryptedChat.in_seq_no = tLRPC$TL_decryptedMessageLayer2.in_seq_no;
            arrayList2.remove(0);
            if (tL_decryptedMessageHolder.decryptedWithVersion == 2) {
                tLRPC$EncryptedChat.mtproto_seq = Math.min(tLRPC$EncryptedChat.mtproto_seq, tLRPC$EncryptedChat.seq_in);
            }
            TLRPC$Message tLRPC$MessageProcessDecryptedObject = processDecryptedObject(tLRPC$EncryptedChat, tL_decryptedMessageHolder.file, tL_decryptedMessageHolder.date, tL_decryptedMessageHolder.layer.message, tL_decryptedMessageHolder.new_key_used);
            if (tLRPC$MessageProcessDecryptedObject != null) {
                arrayList.add(tLRPC$MessageProcessDecryptedObject);
            }
            z = true;
        }
        if (arrayList2.isEmpty()) {
            this.secretHolesQueue.remove(tLRPC$EncryptedChat.id);
        }
        if (z) {
            getMessagesStorage().updateEncryptedChatSeq(tLRPC$EncryptedChat, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$checkSecretHoles$16(TL_decryptedMessageHolder tL_decryptedMessageHolder, TL_decryptedMessageHolder tL_decryptedMessageHolder2) {
        int i = tL_decryptedMessageHolder.layer.out_seq_no;
        int i2 = tL_decryptedMessageHolder2.layer.out_seq_no;
        if (i > i2) {
            return 1;
        }
        return i < i2 ? -1 : 0;
    }

    private boolean decryptWithMtProtoVersion(NativeByteBuffer nativeByteBuffer, byte[] bArr, byte[] bArr2, int i, boolean z, boolean z2) throws IOException {
        boolean z3 = i == 1 ? false : z;
        MessageKeyData messageKeyDataGenerateMessageKeyData = MessageKeyData.generateMessageKeyData(bArr, bArr2, z3, i);
        Utilities.aesIgeEncryption(nativeByteBuffer.buffer, messageKeyDataGenerateMessageKeyData.aesKey, messageKeyDataGenerateMessageKeyData.aesIv, false, false, 24, nativeByteBuffer.limit() - 24);
        int int32 = nativeByteBuffer.readInt32(false);
        if (i == 2) {
            int i2 = z3 ? 8 : 0;
            ByteBuffer byteBuffer = nativeByteBuffer.buffer;
            if (!Utilities.arraysEquals(bArr2, 0, Utilities.computeSHA256(bArr, i2 + 88, 32, byteBuffer, 24, byteBuffer.limit()), 8)) {
                if (z2) {
                    Utilities.aesIgeEncryption(nativeByteBuffer.buffer, messageKeyDataGenerateMessageKeyData.aesKey, messageKeyDataGenerateMessageKeyData.aesIv, true, false, 24, nativeByteBuffer.limit() - 24);
                    nativeByteBuffer.position(24);
                }
                return false;
            }
        } else {
            int iLimit = int32 + 28;
            if (iLimit < nativeByteBuffer.buffer.limit() - 15 || iLimit > nativeByteBuffer.buffer.limit()) {
                iLimit = nativeByteBuffer.buffer.limit();
            }
            if (!Utilities.arraysEquals(bArr2, 0, Utilities.computeSHA1(nativeByteBuffer.buffer, 24, iLimit), r3.length - 16)) {
                if (z2) {
                    Utilities.aesIgeEncryption(nativeByteBuffer.buffer, messageKeyDataGenerateMessageKeyData.aesKey, messageKeyDataGenerateMessageKeyData.aesIv, true, false, 24, nativeByteBuffer.limit() - 24);
                    nativeByteBuffer.position(24);
                }
                return false;
            }
        }
        if (int32 <= 0 || int32 > nativeByteBuffer.limit() - 28) {
            return false;
        }
        int iLimit2 = (nativeByteBuffer.limit() - 28) - int32;
        return (i != 2 || (iLimit2 >= 12 && iLimit2 <= 1024)) && (i != 1 || iLimit2 <= 15);
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x0262 A[Catch: Exception -> 0x027c, TryCatch #0 {Exception -> 0x027c, blocks: (B:7:0x001a, B:9:0x001e, B:11:0x002a, B:12:0x0036, B:14:0x0041, B:16:0x005c, B:24:0x0073, B:29:0x0083, B:34:0x009c, B:38:0x00a5, B:42:0x00c0, B:47:0x00d4, B:51:0x00e7, B:53:0x00fa, B:55:0x0104, B:56:0x010b, B:58:0x010f, B:60:0x0115, B:62:0x0119, B:64:0x0125, B:65:0x012c, B:66:0x012f, B:68:0x0136, B:70:0x013a, B:72:0x0140, B:74:0x0144, B:75:0x0180, B:80:0x018a, B:84:0x0191, B:86:0x0194, B:88:0x0198, B:89:0x019d, B:91:0x01b2, B:92:0x01be, B:94:0x01c5, B:96:0x01ff, B:99:0x0218, B:100:0x0220, B:106:0x0246, B:108:0x025a, B:109:0x025d, B:101:0x0238, B:103:0x023c, B:112:0x0262, B:114:0x0269, B:17:0x0060, B:21:0x006c), top: B:119:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0083 A[Catch: Exception -> 0x027c, TryCatch #0 {Exception -> 0x027c, blocks: (B:7:0x001a, B:9:0x001e, B:11:0x002a, B:12:0x0036, B:14:0x0041, B:16:0x005c, B:24:0x0073, B:29:0x0083, B:34:0x009c, B:38:0x00a5, B:42:0x00c0, B:47:0x00d4, B:51:0x00e7, B:53:0x00fa, B:55:0x0104, B:56:0x010b, B:58:0x010f, B:60:0x0115, B:62:0x0119, B:64:0x0125, B:65:0x012c, B:66:0x012f, B:68:0x0136, B:70:0x013a, B:72:0x0140, B:74:0x0144, B:75:0x0180, B:80:0x018a, B:84:0x0191, B:86:0x0194, B:88:0x0198, B:89:0x019d, B:91:0x01b2, B:92:0x01be, B:94:0x01c5, B:96:0x01ff, B:99:0x0218, B:100:0x0220, B:106:0x0246, B:108:0x025a, B:109:0x025d, B:101:0x0238, B:103:0x023c, B:112:0x0262, B:114:0x0269, B:17:0x0060, B:21:0x006c), top: B:119:0x001a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected java.util.ArrayList<org.rbmain.tgnet.TLRPC$Message> decryptMessage(org.rbmain.tgnet.TLRPC$EncryptedMessage r22) {
        /*
            Method dump skipped, instructions count: 641
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.SecretChatHelper.decryptMessage(org.rbmain.tgnet.TLRPC$EncryptedMessage):java.util.ArrayList");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$decryptMessage$17(TLRPC$TL_encryptedChatDiscarded tLRPC$TL_encryptedChatDiscarded) {
        getMessagesController().putEncryptedChat(tLRPC$TL_encryptedChatDiscarded, false);
        getMessagesStorage().updateEncryptedChat(tLRPC$TL_encryptedChatDiscarded);
        getNotificationCenter().postNotificationName(NotificationCenter.encryptedChatUpdated, tLRPC$TL_encryptedChatDiscarded);
    }

    public void requestNewSecretChatKey(TLRPC$EncryptedChat tLRPC$EncryptedChat) {
        if (AndroidUtilities.getPeerLayerVersion(tLRPC$EncryptedChat.layer) < 20) {
            return;
        }
        byte[] bArr = new byte[256];
        Utilities.random.nextBytes(bArr);
        byte[] byteArray = BigInteger.valueOf(getMessagesStorage().getSecretG()).modPow(new BigInteger(1, bArr), new BigInteger(1, getMessagesStorage().getSecretPBytes())).toByteArray();
        if (byteArray.length > 256) {
            byte[] bArr2 = new byte[256];
            System.arraycopy(byteArray, 1, bArr2, 0, 256);
            byteArray = bArr2;
        }
        tLRPC$EncryptedChat.exchange_id = getSendMessagesHelper().getNextRandomId();
        tLRPC$EncryptedChat.a_or_b = bArr;
        tLRPC$EncryptedChat.g_a = byteArray;
        getMessagesStorage().updateEncryptedChat(tLRPC$EncryptedChat);
        sendRequestKeyMessage(tLRPC$EncryptedChat, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void processAcceptedSecretChat(final org.rbmain.tgnet.TLRPC$EncryptedChat r10) throws java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.SecretChatHelper.processAcceptedSecretChat(org.rbmain.tgnet.TLRPC$EncryptedChat):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processAcceptedSecretChat$18(TLRPC$EncryptedChat tLRPC$EncryptedChat) {
        getNotificationCenter().postNotificationName(NotificationCenter.encryptedChatUpdated, tLRPC$EncryptedChat);
        sendNotifyLayerMessage(tLRPC$EncryptedChat, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processAcceptedSecretChat$19(TLRPC$TL_encryptedChatDiscarded tLRPC$TL_encryptedChatDiscarded) {
        getMessagesController().putEncryptedChat(tLRPC$TL_encryptedChatDiscarded, false);
        getNotificationCenter().postNotificationName(NotificationCenter.encryptedChatUpdated, tLRPC$TL_encryptedChatDiscarded);
    }

    public void declineSecretChat(int i, boolean z) {
        TLRPC$TL_messages_discardEncryption tLRPC$TL_messages_discardEncryption = new TLRPC$TL_messages_discardEncryption();
        tLRPC$TL_messages_discardEncryption.chat_id = i;
        tLRPC$TL_messages_discardEncryption.delete_history = z;
        getConnectionsManager().sendRequest(tLRPC$TL_messages_discardEncryption, new RequestDelegate() { // from class: org.rbmain.messenger.SecretChatHelper$$ExternalSyntheticLambda31
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                SecretChatHelper.lambda$declineSecretChat$20(tLObject, tLRPC$TL_error);
            }
        });
    }

    public void acceptSecretChat(final TLRPC$EncryptedChat tLRPC$EncryptedChat) {
        if (this.acceptingChats.get(tLRPC$EncryptedChat.id) != null) {
            return;
        }
        this.acceptingChats.put(tLRPC$EncryptedChat.id, tLRPC$EncryptedChat);
        TLRPC$TL_messages_getDhConfig tLRPC$TL_messages_getDhConfig = new TLRPC$TL_messages_getDhConfig();
        tLRPC$TL_messages_getDhConfig.random_length = 256;
        tLRPC$TL_messages_getDhConfig.version = getMessagesStorage().getLastSecretVersion();
        getConnectionsManager().sendRequest(tLRPC$TL_messages_getDhConfig, new RequestDelegate() { // from class: org.rbmain.messenger.SecretChatHelper$$ExternalSyntheticLambda30
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$acceptSecretChat$23(tLRPC$EncryptedChat, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$acceptSecretChat$23(final TLRPC$EncryptedChat tLRPC$EncryptedChat, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
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
            byte[] bArr2 = new byte[256];
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
                byte[] bArr3 = new byte[256];
                System.arraycopy(byteArray, 1, bArr3, 0, 256);
                byteArray = bArr3;
            }
            byte[] byteArray2 = bigInteger2.modPow(new BigInteger(1, bArr2), bigInteger).toByteArray();
            if (byteArray2.length > 256) {
                bArr = new byte[256];
                System.arraycopy(byteArray2, byteArray2.length - 256, bArr, 0, 256);
            } else {
                if (byteArray2.length < 256) {
                    bArr = new byte[256];
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
                getConnectionsManager().sendRequest(tLRPC$TL_messages_acceptEncryption, new RequestDelegate() { // from class: org.rbmain.messenger.SecretChatHelper$$ExternalSyntheticLambda29
                    @Override // org.rbmain.tgnet.RequestDelegate
                    public final void run(TLObject tLObject2, TLRPC$TL_error tLRPC$TL_error2) {
                        this.f$0.lambda$acceptSecretChat$22(tLRPC$EncryptedChat, tLObject2, tLRPC$TL_error2);
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
            getConnectionsManager().sendRequest(tLRPC$TL_messages_acceptEncryption2, new RequestDelegate() { // from class: org.rbmain.messenger.SecretChatHelper$$ExternalSyntheticLambda29
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject2, TLRPC$TL_error tLRPC$TL_error2) {
                    this.f$0.lambda$acceptSecretChat$22(tLRPC$EncryptedChat, tLObject2, tLRPC$TL_error2);
                }
            }, 64);
            return;
        }
        this.acceptingChats.remove(tLRPC$EncryptedChat.id);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$acceptSecretChat$22(TLRPC$EncryptedChat tLRPC$EncryptedChat, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
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
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.SecretChatHelper$$ExternalSyntheticLambda15
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$acceptSecretChat$21(tLRPC$EncryptedChat2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$acceptSecretChat$21(TLRPC$EncryptedChat tLRPC$EncryptedChat) {
        getNotificationCenter().postNotificationName(NotificationCenter.encryptedChatUpdated, tLRPC$EncryptedChat);
        sendNotifyLayerMessage(tLRPC$EncryptedChat, null);
    }

    public void startSecretChat(final Context context, final TLRPC$User tLRPC$User) {
        if (tLRPC$User == null || context == null) {
            return;
        }
        this.startingSecretChat = true;
        final AlertDialog alertDialog = new AlertDialog(context, 3);
        TLRPC$TL_messages_getDhConfig tLRPC$TL_messages_getDhConfig = new TLRPC$TL_messages_getDhConfig();
        tLRPC$TL_messages_getDhConfig.random_length = 256;
        tLRPC$TL_messages_getDhConfig.version = getMessagesStorage().getLastSecretVersion();
        final int iSendRequest = getConnectionsManager().sendRequest(tLRPC$TL_messages_getDhConfig, new RequestDelegate() { // from class: org.rbmain.messenger.SecretChatHelper$$ExternalSyntheticLambda26
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$startSecretChat$30(context, alertDialog, tLRPC$User, tLObject, tLRPC$TL_error);
            }
        }, 2);
        alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: org.rbmain.messenger.SecretChatHelper$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                this.f$0.lambda$startSecretChat$31(iSendRequest, dialogInterface);
            }
        });
        try {
            alertDialog.show();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startSecretChat$30(final Context context, final AlertDialog alertDialog, final TLRPC$User tLRPC$User, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            TLRPC$messages_DhConfig tLRPC$messages_DhConfig = (TLRPC$messages_DhConfig) tLObject;
            if (tLObject instanceof TLRPC$TL_messages_dhConfig) {
                if (!Utilities.isGoodPrime(tLRPC$messages_DhConfig.p, tLRPC$messages_DhConfig.g)) {
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.SecretChatHelper$$ExternalSyntheticLambda1
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
            final byte[] bArr = new byte[256];
            for (int i = 0; i < 256; i++) {
                bArr[i] = (byte) (((byte) (Utilities.random.nextDouble() * 256.0d)) ^ tLRPC$messages_DhConfig.random[i]);
            }
            byte[] byteArray = BigInteger.valueOf(getMessagesStorage().getSecretG()).modPow(new BigInteger(1, bArr), new BigInteger(1, getMessagesStorage().getSecretPBytes())).toByteArray();
            if (byteArray.length > 256) {
                byte[] bArr2 = new byte[256];
                System.arraycopy(byteArray, 1, bArr2, 0, 256);
                byteArray = bArr2;
            }
            TLRPC$TL_messages_requestEncryption tLRPC$TL_messages_requestEncryption = new TLRPC$TL_messages_requestEncryption();
            tLRPC$TL_messages_requestEncryption.g_a = byteArray;
            tLRPC$TL_messages_requestEncryption.user_id = getMessagesController().getInputUser(tLRPC$User);
            tLRPC$TL_messages_requestEncryption.random_id = Utilities.random.nextInt();
            getConnectionsManager().sendRequest(tLRPC$TL_messages_requestEncryption, new RequestDelegate() { // from class: org.rbmain.messenger.SecretChatHelper$$ExternalSyntheticLambda27
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject2, TLRPC$TL_error tLRPC$TL_error2) {
                    this.f$0.lambda$startSecretChat$28(context, alertDialog, bArr, tLRPC$User, tLObject2, tLRPC$TL_error2);
                }
            }, 2);
            return;
        }
        this.delayedEncryptedChatUpdates.clear();
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.SecretChatHelper$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$startSecretChat$29(context, alertDialog);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$startSecretChat$24(Context context, AlertDialog alertDialog) {
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
    public /* synthetic */ void lambda$startSecretChat$28(final Context context, final AlertDialog alertDialog, final byte[] bArr, final TLRPC$User tLRPC$User, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.SecretChatHelper$$ExternalSyntheticLambda10
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$startSecretChat$26(context, alertDialog, tLObject, bArr, tLRPC$User);
                }
            });
        } else {
            this.delayedEncryptedChatUpdates.clear();
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.SecretChatHelper$$ExternalSyntheticLambda9
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$startSecretChat$27(context, alertDialog);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startSecretChat$26(Context context, AlertDialog alertDialog, TLObject tLObject, byte[] bArr, TLRPC$User tLRPC$User) {
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
        tLRPC$TL_dialog.id = DialogObject.makeSecretDialogId(tLRPC$EncryptedChat.id);
        tLRPC$TL_dialog.unread_count = 0;
        tLRPC$TL_dialog.top_message = 0L;
        tLRPC$TL_dialog.last_message_date = getConnectionsManager().getCurrentTime();
        getMessagesController().dialogs_dict.put(tLRPC$TL_dialog.id, tLRPC$TL_dialog);
        getMessagesController().allDialogs.add(tLRPC$TL_dialog);
        getMessagesController().sortDialogs(null);
        getMessagesStorage().putEncryptedChat(tLRPC$EncryptedChat, tLRPC$User, tLRPC$TL_dialog);
        getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[0]);
        getNotificationCenter().postNotificationName(NotificationCenter.encryptedChatCreated, tLRPC$EncryptedChat);
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.SecretChatHelper$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() throws InterruptedException {
                this.f$0.lambda$startSecretChat$25();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startSecretChat$25() throws InterruptedException {
        if (this.delayedEncryptedChatUpdates.isEmpty()) {
            return;
        }
        getMessagesController().processUpdateArray(this.delayedEncryptedChatUpdates, null, null, false, 0);
        this.delayedEncryptedChatUpdates.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startSecretChat$27(Context context, AlertDialog alertDialog) {
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
        builder.setTitle(LocaleController.getString("AppName", ir.medu.shad.R.string.AppName));
        builder.setMessage(LocaleController.getString("CreateEncryptedChatError", ir.medu.shad.R.string.CreateEncryptedChatError));
        builder.setPositiveButton(LocaleController.getString("OK", ir.medu.shad.R.string.OK), null);
        builder.show().setCanceledOnTouchOutside(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startSecretChat$29(Context context, AlertDialog alertDialog) {
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
    public /* synthetic */ void lambda$startSecretChat$31(int i, DialogInterface dialogInterface) {
        getConnectionsManager().cancelRequest(i, true);
    }
}
