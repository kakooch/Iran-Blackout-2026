package org.rbmain.messenger;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.media.MediaCodecInfo;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.Spannable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.webkit.MimeTypeMap;
import android.widget.Toast;
import androidMessenger.proxy.IdStorage;
import androidMessenger.proxy.MessageProxy;
import androidMessenger.utilites.MessageConverter;
import androidx.collection.LongSparseArray;
import androidx.core.view.inputmethod.InputContentInfoCompat;
import ir.aaap.messengercore.db.DBHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import org.rbmain.messenger.MediaController;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.MessagesStorage;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.NativeByteBuffer;
import org.rbmain.tgnet.QuickAckDelegate;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.SerializedData;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$BotInlineMessage;
import org.rbmain.tgnet.TLRPC$BotInlineResult;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$DecryptedMessage;
import org.rbmain.tgnet.TLRPC$DecryptedMessageAction;
import org.rbmain.tgnet.TLRPC$DecryptedMessageMedia;
import org.rbmain.tgnet.TLRPC$Document;
import org.rbmain.tgnet.TLRPC$EncryptedChat;
import org.rbmain.tgnet.TLRPC$FileLocation;
import org.rbmain.tgnet.TLRPC$InputCheckPasswordSRP;
import org.rbmain.tgnet.TLRPC$InputDocument;
import org.rbmain.tgnet.TLRPC$InputEncryptedFile;
import org.rbmain.tgnet.TLRPC$InputFile;
import org.rbmain.tgnet.TLRPC$InputMedia;
import org.rbmain.tgnet.TLRPC$InputPeer;
import org.rbmain.tgnet.TLRPC$InputStickerSet;
import org.rbmain.tgnet.TLRPC$KeyboardButton;
import org.rbmain.tgnet.TLRPC$Message;
import org.rbmain.tgnet.TLRPC$MessageAction;
import org.rbmain.tgnet.TLRPC$MessageEntity;
import org.rbmain.tgnet.TLRPC$MessageMedia;
import org.rbmain.tgnet.TLRPC$Peer;
import org.rbmain.tgnet.TLRPC$Photo;
import org.rbmain.tgnet.TLRPC$PhotoSize;
import org.rbmain.tgnet.TLRPC$ReplyMarkup;
import org.rbmain.tgnet.TLRPC$TL_account_password;
import org.rbmain.tgnet.TLRPC$TL_botInlineMessageMediaAuto;
import org.rbmain.tgnet.TLRPC$TL_botInlineMessageMediaContact;
import org.rbmain.tgnet.TLRPC$TL_botInlineMessageMediaGeo;
import org.rbmain.tgnet.TLRPC$TL_botInlineMessageMediaInvoice;
import org.rbmain.tgnet.TLRPC$TL_botInlineMessageMediaVenue;
import org.rbmain.tgnet.TLRPC$TL_botInlineMessageText;
import org.rbmain.tgnet.TLRPC$TL_dataJSON;
import org.rbmain.tgnet.TLRPC$TL_decryptedMessage;
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
import org.rbmain.tgnet.TLRPC$TL_decryptedMessageActionTyping;
import org.rbmain.tgnet.TLRPC$TL_decryptedMessageMediaDocument;
import org.rbmain.tgnet.TLRPC$TL_decryptedMessageMediaPhoto;
import org.rbmain.tgnet.TLRPC$TL_decryptedMessageMediaVideo;
import org.rbmain.tgnet.TLRPC$TL_document;
import org.rbmain.tgnet.TLRPC$TL_documentAttributeSticker_layer55;
import org.rbmain.tgnet.TLRPC$TL_document_layer82;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_fileLocationUnavailable;
import org.rbmain.tgnet.TLRPC$TL_fileLocation_layer82;
import org.rbmain.tgnet.TLRPC$TL_game;
import org.rbmain.tgnet.TLRPC$TL_geoPoint;
import org.rbmain.tgnet.TLRPC$TL_inputCheckPasswordEmpty;
import org.rbmain.tgnet.TLRPC$TL_inputEncryptedFile;
import org.rbmain.tgnet.TLRPC$TL_inputMediaDocument;
import org.rbmain.tgnet.TLRPC$TL_inputMediaGame;
import org.rbmain.tgnet.TLRPC$TL_inputMediaPhoto;
import org.rbmain.tgnet.TLRPC$TL_inputMediaUploadedDocument;
import org.rbmain.tgnet.TLRPC$TL_inputMediaUploadedPhoto;
import org.rbmain.tgnet.TLRPC$TL_inputPeerChannel;
import org.rbmain.tgnet.TLRPC$TL_inputPeerChat;
import org.rbmain.tgnet.TLRPC$TL_inputPeerUser;
import org.rbmain.tgnet.TLRPC$TL_inputSingleMedia;
import org.rbmain.tgnet.TLRPC$TL_inputStickerSetShortName;
import org.rbmain.tgnet.TLRPC$TL_keyboardButtonBuy;
import org.rbmain.tgnet.TLRPC$TL_keyboardButtonGame;
import org.rbmain.tgnet.TLRPC$TL_keyboardButtonUrlAuth;
import org.rbmain.tgnet.TLRPC$TL_messageActionScreenshotTaken;
import org.rbmain.tgnet.TLRPC$TL_messageEncryptedAction;
import org.rbmain.tgnet.TLRPC$TL_messageEntityBold;
import org.rbmain.tgnet.TLRPC$TL_messageEntityCode;
import org.rbmain.tgnet.TLRPC$TL_messageEntityItalic;
import org.rbmain.tgnet.TLRPC$TL_messageEntityPre;
import org.rbmain.tgnet.TLRPC$TL_messageEntityTextUrl;
import org.rbmain.tgnet.TLRPC$TL_messageEntityUrl;
import org.rbmain.tgnet.TLRPC$TL_messageMediaEmpty;
import org.rbmain.tgnet.TLRPC$TL_messageMediaGame;
import org.rbmain.tgnet.TLRPC$TL_messageMediaGeo;
import org.rbmain.tgnet.TLRPC$TL_messageMediaGeoLive;
import org.rbmain.tgnet.TLRPC$TL_messageMediaInvoice;
import org.rbmain.tgnet.TLRPC$TL_messageMediaPoll;
import org.rbmain.tgnet.TLRPC$TL_messageMediaRubinoPost;
import org.rbmain.tgnet.TLRPC$TL_messageMediaRubinoProduct;
import org.rbmain.tgnet.TLRPC$TL_messageMediaRubinoStory;
import org.rbmain.tgnet.TLRPC$TL_messageMediaVenue;
import org.rbmain.tgnet.TLRPC$TL_messageMediaWallet;
import org.rbmain.tgnet.TLRPC$TL_messageMediaWebPage;
import org.rbmain.tgnet.TLRPC$TL_messageReplies;
import org.rbmain.tgnet.TLRPC$TL_messageReplyHeader;
import org.rbmain.tgnet.TLRPC$TL_messageService;
import org.rbmain.tgnet.TLRPC$TL_messages_editMessage;
import org.rbmain.tgnet.TLRPC$TL_messages_forwardMessages;
import org.rbmain.tgnet.TLRPC$TL_messages_getBotCallbackAnswer;
import org.rbmain.tgnet.TLRPC$TL_messages_getStickerSet;
import org.rbmain.tgnet.TLRPC$TL_messages_historyImport;
import org.rbmain.tgnet.TLRPC$TL_messages_initHistoryImport;
import org.rbmain.tgnet.TLRPC$TL_messages_messages;
import org.rbmain.tgnet.TLRPC$TL_messages_requestUrlAuth;
import org.rbmain.tgnet.TLRPC$TL_messages_sendEncryptedMultiMedia;
import org.rbmain.tgnet.TLRPC$TL_messages_sendMedia;
import org.rbmain.tgnet.TLRPC$TL_messages_sendMultiMedia;
import org.rbmain.tgnet.TLRPC$TL_messages_sendReaction;
import org.rbmain.tgnet.TLRPC$TL_messages_sendScreenshotNotification;
import org.rbmain.tgnet.TLRPC$TL_messages_sendVote;
import org.rbmain.tgnet.TLRPC$TL_messages_startHistoryImport;
import org.rbmain.tgnet.TLRPC$TL_messages_stickerSet;
import org.rbmain.tgnet.TLRPC$TL_messages_uploadImportedMedia;
import org.rbmain.tgnet.TLRPC$TL_messages_uploadMedia;
import org.rbmain.tgnet.TLRPC$TL_payments_getPaymentForm;
import org.rbmain.tgnet.TLRPC$TL_payments_getPaymentReceipt;
import org.rbmain.tgnet.TLRPC$TL_peerUser;
import org.rbmain.tgnet.TLRPC$TL_photo;
import org.rbmain.tgnet.TLRPC$TL_photoCachedSize;
import org.rbmain.tgnet.TLRPC$TL_photoPathSize;
import org.rbmain.tgnet.TLRPC$TL_photoSize;
import org.rbmain.tgnet.TLRPC$TL_photoSizeEmpty;
import org.rbmain.tgnet.TLRPC$TL_photoSizeProgressive;
import org.rbmain.tgnet.TLRPC$TL_photoStrippedSize;
import org.rbmain.tgnet.TLRPC$TL_pollAnswer;
import org.rbmain.tgnet.TLRPC$TL_reactionCustomEmoji;
import org.rbmain.tgnet.TLRPC$TL_reactionEmoji;
import org.rbmain.tgnet.TLRPC$TL_restrictionReason;
import org.rbmain.tgnet.TLRPC$TL_updateEditChannelMessage;
import org.rbmain.tgnet.TLRPC$TL_updateEditMessage;
import org.rbmain.tgnet.TLRPC$TL_updateMessageID;
import org.rbmain.tgnet.TLRPC$TL_updateNewChannelMessage;
import org.rbmain.tgnet.TLRPC$TL_updateNewMessage;
import org.rbmain.tgnet.TLRPC$TL_updateNewScheduledMessage;
import org.rbmain.tgnet.TLRPC$TL_updateShortSentMessage;
import org.rbmain.tgnet.TLRPC$TL_urlAuthResultAccepted;
import org.rbmain.tgnet.TLRPC$TL_urlAuthResultDefault;
import org.rbmain.tgnet.TLRPC$TL_urlAuthResultRequest;
import org.rbmain.tgnet.TLRPC$TL_user;
import org.rbmain.tgnet.TLRPC$TL_userContact_old2;
import org.rbmain.tgnet.TLRPC$TL_webPagePending;
import org.rbmain.tgnet.TLRPC$Update;
import org.rbmain.tgnet.TLRPC$Updates;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.tgnet.TLRPC$WebDocument;
import org.rbmain.tgnet.TLRPC$WebPage;
import org.rbmain.tgnet.TLRPC$messages_Messages;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Cells.ChatMessageCell;
import org.rbmain.ui.ChatActivity;
import org.rbmain.ui.Components.AlertsCreator;
import org.rbmain.ui.Components.AnimatedEmojiSpan;
import org.rbmain.ui.Components.AnimatedFileDrawable;
import org.rbmain.ui.Components.Point;
import org.rbmain.ui.Components.Reactions.ReactionsLayoutInBubble;
import org.rbmain.ui.Components.Reactions.ReactionsUtils;
import org.rbmain.ui.TwoStepVerificationActivity;
import org.rbmain.ui.TwoStepVerificationSetupActivity;

/* loaded from: classes4.dex */
public class SendMessagesHelper extends BaseController implements NotificationCenter.NotificationCenterDelegate {
    private static volatile SendMessagesHelper[] Instance;
    private static DispatchQueue mediaSendQueue = new DispatchQueue("mediaSendQueue");
    private static ThreadPoolExecutor mediaSendThreadPool;
    private HashMap<String, ArrayList<DelayedMessage>> delayedMessages;
    private LongSparseArray<TLRPC$Message> editingMessages;
    private HashMap<String, ImportingHistory> importingHistoryFiles;
    private LongSparseArray<ImportingHistory> importingHistoryMap;
    private LocationProvider locationProvider;
    private LongSparseArray<TLRPC$Message> sendingMessages;
    private LongSparseArray<Integer> sendingMessagesIdDialogs;
    public ArrayList<Long> sentMessages;
    private LongSparseArray<MessageObject> unsentMessages;
    private LongSparseArray<TLRPC$Message> uploadMessages;
    private LongSparseArray<Integer> uploadingMessagesIdDialogs;
    private LongSparseArray<Long> voteSendTime;
    private HashMap<String, Boolean> waitingForCallback;
    private HashMap<String, MessageObject> waitingForLocation;
    private HashMap<String, byte[]> waitingForVote;

    public static class SendingMediaInfo {
        public boolean canDeleteAfter;
        public String caption;
        public int duration;
        public ArrayList<TLRPC$MessageEntity> entities;
        public boolean hasMediaSpoilers;
        public int height;
        public TLRPC$BotInlineResult inlineResult;
        public boolean isVideo;
        public ArrayList<TLRPC$InputDocument> masks;
        public String orginalPath;
        public String paintPath;
        public HashMap<String, String> params;
        public String path;
        public int rnd;
        public MediaController.SearchImage searchImage;
        public String thumbPath;
        public int ttl;
        public boolean updateStickersOrder;
        public Uri uri;
        public VideoEditedInfo videoEditedInfo;
        public int width;
    }

    public void sendReaction(MessageObject messageObject, CharSequence charSequence, ChatActivity chatActivity) {
    }

    public static boolean checkUpdateStickersOrder(CharSequence charSequence) {
        if (charSequence instanceof Spannable) {
            for (AnimatedEmojiSpan animatedEmojiSpan : (AnimatedEmojiSpan[]) ((Spannable) charSequence).getSpans(0, charSequence.length(), AnimatedEmojiSpan.class)) {
                if (animatedEmojiSpan.fromEmojiKeyboard) {
                    return true;
                }
            }
        }
        return false;
    }

    public class ImportingHistory {
        public long dialogId;
        public double estimatedUploadSpeed;
        public String historyPath;
        public long importId;
        private long lastUploadSize;
        private long lastUploadTime;
        public TLRPC$InputPeer peer;
        public long totalSize;
        public int uploadProgress;
        public long uploadedSize;
        public ArrayList<Uri> mediaPaths = new ArrayList<>();
        public HashSet<String> uploadSet = new HashSet<>();
        public HashMap<String, Float> uploadProgresses = new HashMap<>();
        public HashMap<String, Long> uploadSize = new HashMap<>();
        public ArrayList<String> uploadMedia = new ArrayList<>();
        public int timeUntilFinish = ConnectionsManager.DEFAULT_DATACENTER_ID;

        public ImportingHistory() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void initImport(TLRPC$InputFile tLRPC$InputFile) {
            TLRPC$TL_messages_initHistoryImport tLRPC$TL_messages_initHistoryImport = new TLRPC$TL_messages_initHistoryImport();
            tLRPC$TL_messages_initHistoryImport.file = tLRPC$InputFile;
            tLRPC$TL_messages_initHistoryImport.media_count = this.mediaPaths.size();
            tLRPC$TL_messages_initHistoryImport.peer = this.peer;
            SendMessagesHelper.this.getConnectionsManager().sendRequest(tLRPC$TL_messages_initHistoryImport, new AnonymousClass1(tLRPC$TL_messages_initHistoryImport), 2);
        }

        /* renamed from: org.rbmain.messenger.SendMessagesHelper$ImportingHistory$1, reason: invalid class name */
        class AnonymousClass1 implements RequestDelegate {
            final /* synthetic */ TLRPC$TL_messages_initHistoryImport val$req;

            AnonymousClass1(TLRPC$TL_messages_initHistoryImport tLRPC$TL_messages_initHistoryImport) {
                this.val$req = tLRPC$TL_messages_initHistoryImport;
            }

            @Override // org.rbmain.tgnet.RequestDelegate
            public void run(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
                final TLRPC$TL_messages_initHistoryImport tLRPC$TL_messages_initHistoryImport = this.val$req;
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.SendMessagesHelper$ImportingHistory$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$run$0(tLObject, tLRPC$TL_messages_initHistoryImport, tLRPC$TL_error);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$run$0(TLObject tLObject, TLRPC$TL_messages_initHistoryImport tLRPC$TL_messages_initHistoryImport, TLRPC$TL_error tLRPC$TL_error) {
                if (!(tLObject instanceof TLRPC$TL_messages_historyImport)) {
                    SendMessagesHelper.this.importingHistoryMap.remove(ImportingHistory.this.dialogId);
                    SendMessagesHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.historyImportProgressChanged, Long.valueOf(ImportingHistory.this.dialogId), tLRPC$TL_messages_initHistoryImport, tLRPC$TL_error);
                    return;
                }
                ImportingHistory importingHistory = ImportingHistory.this;
                importingHistory.importId = ((TLRPC$TL_messages_historyImport) tLObject).id;
                importingHistory.uploadSet.remove(importingHistory.historyPath);
                SendMessagesHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.historyImportProgressChanged, Long.valueOf(ImportingHistory.this.dialogId));
                if (ImportingHistory.this.uploadSet.isEmpty()) {
                    ImportingHistory.this.startImport();
                }
                ImportingHistory.this.lastUploadTime = SystemClock.elapsedRealtime();
                int size = ImportingHistory.this.uploadMedia.size();
                for (int i = 0; i < size; i++) {
                    SendMessagesHelper.this.getFileLoader().uploadFile(ImportingHistory.this.uploadMedia.get(i), false, true, ConnectionsManager.FileTypeFile, null);
                }
            }
        }

        public long getUploadedCount() {
            return this.uploadedSize;
        }

        public long getTotalCount() {
            return this.totalSize;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onFileFailedToUpload(String str) {
            if (str.equals(this.historyPath)) {
                SendMessagesHelper.this.importingHistoryMap.remove(this.dialogId);
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.code = 400;
                tLRPC$TL_error.text = "IMPORT_UPLOAD_FAILED";
                SendMessagesHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.historyImportProgressChanged, Long.valueOf(this.dialogId), new TLRPC$TL_messages_initHistoryImport(), tLRPC$TL_error);
                return;
            }
            this.uploadSet.remove(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addUploadProgress(String str, long j, float f) {
            this.uploadProgresses.put(str, Float.valueOf(f));
            this.uploadSize.put(str, Long.valueOf(j));
            this.uploadedSize = 0L;
            Iterator<Map.Entry<String, Long>> it = this.uploadSize.entrySet().iterator();
            while (it.hasNext()) {
                this.uploadedSize += it.next().getValue().longValue();
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (!str.equals(this.historyPath)) {
                long j2 = this.uploadedSize;
                long j3 = this.lastUploadSize;
                if (j2 != j3) {
                    long j4 = this.lastUploadTime;
                    if (jElapsedRealtime != j4) {
                        double d = jElapsedRealtime - j4;
                        Double.isNaN(d);
                        double d2 = j2 - j3;
                        Double.isNaN(d2);
                        double d3 = d2 / (d / 1000.0d);
                        double d4 = this.estimatedUploadSpeed;
                        if (d4 == 0.0d) {
                            this.estimatedUploadSpeed = d3;
                        } else {
                            this.estimatedUploadSpeed = (d3 * 0.01d) + (0.99d * d4);
                        }
                        double d5 = (this.totalSize - j2) * 1000;
                        double d6 = this.estimatedUploadSpeed;
                        Double.isNaN(d5);
                        this.timeUntilFinish = (int) (d5 / d6);
                        this.lastUploadSize = j2;
                        this.lastUploadTime = jElapsedRealtime;
                    }
                }
            }
            int uploadedCount = (int) ((getUploadedCount() / getTotalCount()) * 100.0f);
            if (this.uploadProgress != uploadedCount) {
                this.uploadProgress = uploadedCount;
                SendMessagesHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.historyImportProgressChanged, Long.valueOf(this.dialogId));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onMediaImport(String str, long j, TLRPC$InputFile tLRPC$InputFile) {
            addUploadProgress(str, j, 1.0f);
            TLRPC$TL_messages_uploadImportedMedia tLRPC$TL_messages_uploadImportedMedia = new TLRPC$TL_messages_uploadImportedMedia();
            tLRPC$TL_messages_uploadImportedMedia.peer = this.peer;
            tLRPC$TL_messages_uploadImportedMedia.import_id = this.importId;
            tLRPC$TL_messages_uploadImportedMedia.file_name = new File(str).getName();
            MimeTypeMap singleton = MimeTypeMap.getSingleton();
            int iLastIndexOf = tLRPC$TL_messages_uploadImportedMedia.file_name.lastIndexOf(46);
            String lowerCase = iLastIndexOf != -1 ? tLRPC$TL_messages_uploadImportedMedia.file_name.substring(iLastIndexOf + 1).toLowerCase() : "txt";
            String mimeTypeFromExtension = singleton.getMimeTypeFromExtension(lowerCase);
            if (mimeTypeFromExtension == null) {
                if ("opus".equals(lowerCase)) {
                    mimeTypeFromExtension = "audio/opus";
                } else {
                    mimeTypeFromExtension = "webp".equals(lowerCase) ? "image/webp" : "text/plain";
                }
            }
            if (mimeTypeFromExtension.equals("image/jpg") || mimeTypeFromExtension.equals("image/jpeg")) {
                TLRPC$TL_inputMediaUploadedPhoto tLRPC$TL_inputMediaUploadedPhoto = new TLRPC$TL_inputMediaUploadedPhoto();
                tLRPC$TL_inputMediaUploadedPhoto.file = tLRPC$InputFile;
                tLRPC$TL_messages_uploadImportedMedia.media = tLRPC$TL_inputMediaUploadedPhoto;
            } else {
                TLRPC$TL_inputMediaUploadedDocument tLRPC$TL_inputMediaUploadedDocument = new TLRPC$TL_inputMediaUploadedDocument();
                tLRPC$TL_inputMediaUploadedDocument.file = tLRPC$InputFile;
                tLRPC$TL_inputMediaUploadedDocument.mime_type = mimeTypeFromExtension;
                tLRPC$TL_messages_uploadImportedMedia.media = tLRPC$TL_inputMediaUploadedDocument;
            }
            SendMessagesHelper.this.getConnectionsManager().sendRequest(tLRPC$TL_messages_uploadImportedMedia, new AnonymousClass2(str), 2);
        }

        /* renamed from: org.rbmain.messenger.SendMessagesHelper$ImportingHistory$2, reason: invalid class name */
        class AnonymousClass2 implements RequestDelegate {
            final /* synthetic */ String val$path;

            AnonymousClass2(String str) {
                this.val$path = str;
            }

            @Override // org.rbmain.tgnet.RequestDelegate
            public void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                final String str = this.val$path;
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.SendMessagesHelper$ImportingHistory$2$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$run$0(str);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$run$0(String str) {
                ImportingHistory.this.uploadSet.remove(str);
                SendMessagesHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.historyImportProgressChanged, Long.valueOf(ImportingHistory.this.dialogId));
                if (ImportingHistory.this.uploadSet.isEmpty()) {
                    ImportingHistory.this.startImport();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void startImport() {
            TLRPC$TL_messages_startHistoryImport tLRPC$TL_messages_startHistoryImport = new TLRPC$TL_messages_startHistoryImport();
            tLRPC$TL_messages_startHistoryImport.peer = this.peer;
            tLRPC$TL_messages_startHistoryImport.import_id = this.importId;
            SendMessagesHelper.this.getConnectionsManager().sendRequest(tLRPC$TL_messages_startHistoryImport, new AnonymousClass3(tLRPC$TL_messages_startHistoryImport));
        }

        /* renamed from: org.rbmain.messenger.SendMessagesHelper$ImportingHistory$3, reason: invalid class name */
        class AnonymousClass3 implements RequestDelegate {
            final /* synthetic */ TLRPC$TL_messages_startHistoryImport val$req;

            AnonymousClass3(TLRPC$TL_messages_startHistoryImport tLRPC$TL_messages_startHistoryImport) {
                this.val$req = tLRPC$TL_messages_startHistoryImport;
            }

            @Override // org.rbmain.tgnet.RequestDelegate
            public void run(TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
                final TLRPC$TL_messages_startHistoryImport tLRPC$TL_messages_startHistoryImport = this.val$req;
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.SendMessagesHelper$ImportingHistory$3$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$run$0(tLRPC$TL_error, tLRPC$TL_messages_startHistoryImport);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$run$0(TLRPC$TL_error tLRPC$TL_error, TLRPC$TL_messages_startHistoryImport tLRPC$TL_messages_startHistoryImport) {
                SendMessagesHelper.this.importingHistoryMap.remove(ImportingHistory.this.dialogId);
                if (tLRPC$TL_error == null) {
                    SendMessagesHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.historyImportProgressChanged, Long.valueOf(ImportingHistory.this.dialogId));
                } else {
                    SendMessagesHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.historyImportProgressChanged, Long.valueOf(ImportingHistory.this.dialogId), tLRPC$TL_messages_startHistoryImport, tLRPC$TL_error);
                }
            }
        }

        public void setImportProgress(int i) {
            if (i == 100) {
                SendMessagesHelper.this.importingHistoryMap.remove(this.dialogId);
            }
            SendMessagesHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.historyImportProgressChanged, Long.valueOf(this.dialogId));
        }
    }

    static {
        int iAvailableProcessors = Build.VERSION.SDK_INT >= 17 ? Runtime.getRuntime().availableProcessors() : 2;
        mediaSendThreadPool = new ThreadPoolExecutor(iAvailableProcessors, iAvailableProcessors, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        Instance = new SendMessagesHelper[3];
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class MediaSendPrepareWorker {
        public volatile String parentObject;
        public volatile TLRPC$TL_photo photo;
        public CountDownLatch sync;

        private MediaSendPrepareWorker() {
        }
    }

    public static class LocationProvider {
        private LocationProviderDelegate delegate;
        private GpsLocationListener gpsLocationListener;
        private Location lastKnownLocation;
        private LocationManager locationManager;
        private Runnable locationQueryCancelRunnable;
        private GpsLocationListener networkLocationListener;

        public interface LocationProviderDelegate {
            void onLocationAcquired(Location location);

            void onUnableLocationAcquire();
        }

        private class GpsLocationListener implements LocationListener {
            @Override // android.location.LocationListener
            public void onProviderDisabled(String str) {
            }

            @Override // android.location.LocationListener
            public void onProviderEnabled(String str) {
            }

            @Override // android.location.LocationListener
            public void onStatusChanged(String str, int i, Bundle bundle) {
            }

            private GpsLocationListener() {
            }

            @Override // android.location.LocationListener
            public void onLocationChanged(Location location) {
                if (location == null || LocationProvider.this.locationQueryCancelRunnable == null) {
                    return;
                }
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("found location " + location);
                }
                LocationProvider.this.lastKnownLocation = location;
                if (location.getAccuracy() < 100.0f) {
                    if (LocationProvider.this.delegate != null) {
                        LocationProvider.this.delegate.onLocationAcquired(location);
                    }
                    if (LocationProvider.this.locationQueryCancelRunnable != null) {
                        AndroidUtilities.cancelRunOnUIThread(LocationProvider.this.locationQueryCancelRunnable);
                    }
                    LocationProvider.this.cleanup();
                }
            }
        }

        public LocationProvider() {
            this.gpsLocationListener = new GpsLocationListener();
            this.networkLocationListener = new GpsLocationListener();
        }

        public LocationProvider(LocationProviderDelegate locationProviderDelegate) {
            this.gpsLocationListener = new GpsLocationListener();
            this.networkLocationListener = new GpsLocationListener();
            this.delegate = locationProviderDelegate;
        }

        public void setDelegate(LocationProviderDelegate locationProviderDelegate) {
            this.delegate = locationProviderDelegate;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cleanup() {
            this.locationManager.removeUpdates(this.gpsLocationListener);
            this.locationManager.removeUpdates(this.networkLocationListener);
            this.lastKnownLocation = null;
            this.locationQueryCancelRunnable = null;
        }

        public void start() {
            if (this.locationManager == null) {
                this.locationManager = (LocationManager) ApplicationLoader.applicationContext.getSystemService("location");
            }
            try {
                this.locationManager.requestLocationUpdates("gps", 1L, 0.0f, this.gpsLocationListener);
            } catch (Exception e) {
                FileLog.e(e);
            }
            try {
                this.locationManager.requestLocationUpdates("network", 1L, 0.0f, this.networkLocationListener);
            } catch (Exception e2) {
                FileLog.e(e2);
            }
            try {
                Location lastKnownLocation = this.locationManager.getLastKnownLocation("gps");
                this.lastKnownLocation = lastKnownLocation;
                if (lastKnownLocation == null) {
                    this.lastKnownLocation = this.locationManager.getLastKnownLocation("network");
                }
            } catch (Exception e3) {
                FileLog.e(e3);
            }
            Runnable runnable = this.locationQueryCancelRunnable;
            if (runnable != null) {
                AndroidUtilities.cancelRunOnUIThread(runnable);
            }
            Runnable runnable2 = new Runnable() { // from class: org.rbmain.messenger.SendMessagesHelper$LocationProvider$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$start$0();
                }
            };
            this.locationQueryCancelRunnable = runnable2;
            AndroidUtilities.runOnUIThread(runnable2, 5000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$start$0() {
            LocationProviderDelegate locationProviderDelegate = this.delegate;
            if (locationProviderDelegate != null) {
                Location location = this.lastKnownLocation;
                if (location != null) {
                    locationProviderDelegate.onLocationAcquired(location);
                } else {
                    locationProviderDelegate.onUnableLocationAcquire();
                }
            }
            cleanup();
        }

        public void stop() {
            if (this.locationManager == null) {
                return;
            }
            Runnable runnable = this.locationQueryCancelRunnable;
            if (runnable != null) {
                AndroidUtilities.cancelRunOnUIThread(runnable);
            }
            cleanup();
        }
    }

    protected class DelayedMessageSendAfterRequest {
        public DelayedMessage delayedMessage;
        public MessageObject msgObj;
        public ArrayList<MessageObject> msgObjs;
        public String originalPath;
        public ArrayList<String> originalPaths;
        public Object parentObject;
        public ArrayList<Object> parentObjects;
        public TLObject request;
        public boolean scheduled;

        protected DelayedMessageSendAfterRequest() {
        }
    }

    protected class DelayedMessage {
        public TLRPC$EncryptedChat encryptedChat;
        public HashMap<Object, Object> extraHashMap;
        public String fileName;
        public long finalGroupMessage;
        public long groupId;
        public String httpLocation;
        public ArrayList<String> httpLocations;
        public ArrayList<TLRPC$InputMedia> inputMedias;
        public TLRPC$InputMedia inputUploadMedia;
        public TLObject locationParent;
        public ArrayList<TLRPC$PhotoSize> locations;
        public ArrayList<MessageObject> messageObjects;
        public ArrayList<TLRPC$Message> messages;
        public MessageObject obj;
        public String originalPath;
        public ArrayList<String> originalPaths;
        public Object parentObject;
        public ArrayList<Object> parentObjects;
        public long peer;
        public boolean performMediaUpload;
        public TLRPC$PhotoSize photoSize;
        ArrayList<DelayedMessageSendAfterRequest> requests;
        public boolean retriedToSend;
        public boolean scheduled;
        public TLObject sendEncryptedRequest;
        public TLObject sendRequest;
        public int topMessageId;
        public int type;
        public VideoEditedInfo videoEditedInfo;
        public ArrayList<VideoEditedInfo> videoEditedInfos;

        public DelayedMessage(long j) {
            this.peer = j;
        }

        public void initForGroup(long j) {
            this.type = 4;
            this.groupId = j;
            this.messageObjects = new ArrayList<>();
            this.messages = new ArrayList<>();
            this.inputMedias = new ArrayList<>();
            this.originalPaths = new ArrayList<>();
            this.parentObjects = new ArrayList<>();
            this.extraHashMap = new HashMap<>();
            this.locations = new ArrayList<>();
            this.httpLocations = new ArrayList<>();
            this.videoEditedInfos = new ArrayList<>();
        }

        public void addDelayedRequest(TLObject tLObject, MessageObject messageObject, String str, Object obj, DelayedMessage delayedMessage, boolean z) {
            DelayedMessageSendAfterRequest delayedMessageSendAfterRequest = SendMessagesHelper.this.new DelayedMessageSendAfterRequest();
            delayedMessageSendAfterRequest.request = tLObject;
            delayedMessageSendAfterRequest.msgObj = messageObject;
            delayedMessageSendAfterRequest.originalPath = str;
            delayedMessageSendAfterRequest.delayedMessage = delayedMessage;
            delayedMessageSendAfterRequest.parentObject = obj;
            delayedMessageSendAfterRequest.scheduled = z;
            if (this.requests == null) {
                this.requests = new ArrayList<>();
            }
            this.requests.add(delayedMessageSendAfterRequest);
        }

        public void addDelayedRequest(TLObject tLObject, ArrayList<MessageObject> arrayList, ArrayList<String> arrayList2, ArrayList<Object> arrayList3, DelayedMessage delayedMessage, boolean z) {
            DelayedMessageSendAfterRequest delayedMessageSendAfterRequest = SendMessagesHelper.this.new DelayedMessageSendAfterRequest();
            delayedMessageSendAfterRequest.request = tLObject;
            delayedMessageSendAfterRequest.msgObjs = arrayList;
            delayedMessageSendAfterRequest.originalPaths = arrayList2;
            delayedMessageSendAfterRequest.delayedMessage = delayedMessage;
            delayedMessageSendAfterRequest.parentObjects = arrayList3;
            delayedMessageSendAfterRequest.scheduled = z;
            if (this.requests == null) {
                this.requests = new ArrayList<>();
            }
            this.requests.add(delayedMessageSendAfterRequest);
        }

        public void sendDelayedRequests() {
            ArrayList<DelayedMessageSendAfterRequest> arrayList = this.requests;
            if (arrayList != null) {
                int i = this.type;
                if (i == 4 || i == 0) {
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        DelayedMessageSendAfterRequest delayedMessageSendAfterRequest = this.requests.get(i2);
                        TLObject tLObject = delayedMessageSendAfterRequest.request;
                        if (tLObject instanceof TLRPC$TL_messages_sendEncryptedMultiMedia) {
                            SendMessagesHelper.this.getSecretChatHelper().performSendEncryptedRequest((TLRPC$TL_messages_sendEncryptedMultiMedia) delayedMessageSendAfterRequest.request, this);
                        } else if (!(tLObject instanceof TLRPC$TL_messages_sendMultiMedia)) {
                            SendMessagesHelper.this.performSendMessageRequest(tLObject, delayedMessageSendAfterRequest.msgObj, delayedMessageSendAfterRequest.originalPath, delayedMessageSendAfterRequest.delayedMessage, delayedMessageSendAfterRequest.parentObject, null, delayedMessageSendAfterRequest.scheduled);
                        } else {
                            SendMessagesHelper.this.performSendMessageRequestMulti((TLRPC$TL_messages_sendMultiMedia) tLObject, delayedMessageSendAfterRequest.msgObjs, delayedMessageSendAfterRequest.originalPaths, delayedMessageSendAfterRequest.parentObjects, delayedMessageSendAfterRequest.delayedMessage, delayedMessageSendAfterRequest.scheduled);
                        }
                    }
                    this.requests = null;
                }
            }
        }

        public void markAsError() {
            if (this.type == 4) {
                for (int i = 0; i < this.messageObjects.size(); i++) {
                    MessageObject messageObject = this.messageObjects.get(i);
                    SendMessagesHelper.this.getMessagesProxy().markMessageAsSendError(messageObject.messageOwner, messageObject.scheduled);
                    messageObject.messageOwner.send_state = 2;
                    SendMessagesHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.messageSendError, Long.valueOf(messageObject.getId()));
                    SendMessagesHelper.this.processSentMessage(messageObject.getId());
                    SendMessagesHelper.this.removeFromUploadingMessages(messageObject.getId(), this.scheduled);
                }
                SendMessagesHelper.this.delayedMessages.remove("group_" + this.groupId);
            } else {
                MessageProxy messagesProxy = SendMessagesHelper.this.getMessagesProxy();
                MessageObject messageObject2 = this.obj;
                messagesProxy.markMessageAsSendError(messageObject2.messageOwner, messageObject2.scheduled);
                this.obj.messageOwner.send_state = 2;
                SendMessagesHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.messageSendError, Long.valueOf(this.obj.getId()));
                SendMessagesHelper.this.processSentMessage(this.obj.getId());
                SendMessagesHelper.this.removeFromUploadingMessages(this.obj.getId(), this.scheduled);
            }
            sendDelayedRequests();
        }
    }

    public static SendMessagesHelper getInstance(int i) {
        SendMessagesHelper sendMessagesHelper = Instance[i];
        if (sendMessagesHelper == null) {
            synchronized (SendMessagesHelper.class) {
                sendMessagesHelper = Instance[i];
                if (sendMessagesHelper == null) {
                    SendMessagesHelper[] sendMessagesHelperArr = Instance;
                    SendMessagesHelper sendMessagesHelper2 = new SendMessagesHelper(i);
                    sendMessagesHelperArr[i] = sendMessagesHelper2;
                    sendMessagesHelper = sendMessagesHelper2;
                }
            }
        }
        return sendMessagesHelper;
    }

    public SendMessagesHelper(int i) {
        super(i);
        this.delayedMessages = new HashMap<>();
        this.sentMessages = new ArrayList<>();
        this.unsentMessages = new LongSparseArray<>();
        this.sendingMessages = new LongSparseArray<>();
        this.editingMessages = new LongSparseArray<>();
        this.uploadMessages = new LongSparseArray<>();
        this.sendingMessagesIdDialogs = new LongSparseArray<>();
        this.uploadingMessagesIdDialogs = new LongSparseArray<>();
        this.waitingForLocation = new HashMap<>();
        this.waitingForCallback = new HashMap<>();
        this.waitingForVote = new HashMap<>();
        this.voteSendTime = new LongSparseArray<>();
        this.importingHistoryFiles = new HashMap<>();
        this.importingHistoryMap = new LongSparseArray<>();
        this.locationProvider = new LocationProvider(new LocationProvider.LocationProviderDelegate() { // from class: org.rbmain.messenger.SendMessagesHelper.1
            @Override // org.rbmain.messenger.SendMessagesHelper.LocationProvider.LocationProviderDelegate
            public void onLocationAcquired(Location location) {
                SendMessagesHelper.this.sendLocation(location);
                SendMessagesHelper.this.waitingForLocation.clear();
            }

            @Override // org.rbmain.messenger.SendMessagesHelper.LocationProvider.LocationProviderDelegate
            public void onUnableLocationAcquire() {
                SendMessagesHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.wasUnableToFindCurrentLocation, new HashMap(SendMessagesHelper.this.waitingForLocation));
                SendMessagesHelper.this.waitingForLocation.clear();
            }
        });
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda20
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        getNotificationCenter().addObserver(this, NotificationCenter.FileDidUpload);
        getNotificationCenter().addObserver(this, NotificationCenter.FileUploadProgressChanged);
        getNotificationCenter().addObserver(this, NotificationCenter.FileDidFailUpload);
        getNotificationCenter().addObserver(this, NotificationCenter.filePreparingStarted);
        getNotificationCenter().addObserver(this, NotificationCenter.fileNewChunkAvailable);
        getNotificationCenter().addObserver(this, NotificationCenter.filePreparingFailed);
        getNotificationCenter().addObserver(this, NotificationCenter.httpFileDidFailedLoad);
        getNotificationCenter().addObserver(this, NotificationCenter.httpFileDidLoad);
        getNotificationCenter().addObserver(this, NotificationCenter.fileDidLoad);
        getNotificationCenter().addObserver(this, NotificationCenter.fileDidFailToLoad);
    }

    public void cleanup() {
        this.delayedMessages.clear();
        this.unsentMessages.clear();
        this.sendingMessages.clear();
        this.editingMessages.clear();
        this.sendingMessagesIdDialogs.clear();
        this.uploadMessages.clear();
        this.uploadingMessagesIdDialogs.clear();
        this.waitingForLocation.clear();
        this.waitingForCallback.clear();
        this.waitingForVote.clear();
        this.importingHistoryFiles.clear();
        this.importingHistoryMap.clear();
        this.locationProvider.stop();
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        String str;
        ArrayList<DelayedMessage> arrayList;
        char c;
        final MessageObject messageObject;
        MessageObject messageObject2;
        TLRPC$InputMedia tLRPC$InputMedia;
        ArrayList<DelayedMessage> arrayList2;
        TLRPC$InputFile tLRPC$InputFile;
        String str2;
        TLRPC$InputEncryptedFile tLRPC$InputEncryptedFile;
        TLObject tLObject;
        TLRPC$TL_decryptedMessage tLRPC$TL_decryptedMessage;
        ArrayList<DelayedMessage> arrayList3;
        TLRPC$InputEncryptedFile tLRPC$InputEncryptedFile2;
        int i3;
        String str3;
        int i4;
        TLRPC$PhotoSize tLRPC$PhotoSize;
        int i5 = 0;
        boolean z = true;
        if (i == NotificationCenter.FileUploadProgressChanged) {
            String str4 = (String) objArr[0];
            ImportingHistory importingHistory = this.importingHistoryFiles.get(str4);
            if (importingHistory != null) {
                importingHistory.addUploadProgress(str4, ((Long) objArr[1]).longValue(), r2.longValue() / ((Long) objArr[2]).longValue());
                return;
            }
            return;
        }
        if (i == NotificationCenter.FileDidUpload) {
            String str5 = (String) objArr[0];
            TLRPC$InputFile tLRPC$InputFile2 = (TLRPC$InputFile) objArr[1];
            TLRPC$InputEncryptedFile tLRPC$InputEncryptedFile3 = (TLRPC$InputEncryptedFile) objArr[2];
            ImportingHistory importingHistory2 = this.importingHistoryFiles.get(str5);
            if (importingHistory2 != null) {
                if (str5.equals(importingHistory2.historyPath)) {
                    importingHistory2.initImport(tLRPC$InputFile2);
                } else {
                    importingHistory2.onMediaImport(str5, ((Long) objArr[5]).longValue(), tLRPC$InputFile2);
                }
            }
            ArrayList<DelayedMessage> arrayList4 = this.delayedMessages.get(str5);
            if (arrayList4 != null) {
                while (i5 < arrayList4.size()) {
                    DelayedMessage delayedMessage = arrayList4.get(i5);
                    TLObject tLObject2 = delayedMessage.sendRequest;
                    if (tLObject2 instanceof TLRPC$TL_messages_sendMedia) {
                        tLRPC$InputMedia = ((TLRPC$TL_messages_sendMedia) tLObject2).media;
                    } else if (tLObject2 instanceof TLRPC$TL_messages_editMessage) {
                        tLRPC$InputMedia = ((TLRPC$TL_messages_editMessage) tLObject2).media;
                    } else {
                        tLRPC$InputMedia = tLObject2 instanceof TLRPC$TL_messages_sendMultiMedia ? (TLRPC$InputMedia) delayedMessage.extraHashMap.get(str5) : null;
                    }
                    if (tLRPC$InputFile2 == null || tLRPC$InputMedia == null) {
                        arrayList2 = arrayList4;
                        TLRPC$InputEncryptedFile tLRPC$InputEncryptedFile4 = tLRPC$InputEncryptedFile3;
                        tLRPC$InputFile = tLRPC$InputFile2;
                        str2 = str5;
                        tLRPC$InputEncryptedFile = tLRPC$InputEncryptedFile4;
                        if (tLRPC$InputEncryptedFile != null && (tLObject = delayedMessage.sendEncryptedRequest) != null) {
                            if (delayedMessage.type == 4) {
                                TLRPC$TL_messages_sendEncryptedMultiMedia tLRPC$TL_messages_sendEncryptedMultiMedia = (TLRPC$TL_messages_sendEncryptedMultiMedia) tLObject;
                                TLRPC$InputEncryptedFile tLRPC$InputEncryptedFile5 = (TLRPC$InputEncryptedFile) delayedMessage.extraHashMap.get(str2);
                                int iIndexOf = tLRPC$TL_messages_sendEncryptedMultiMedia.files.indexOf(tLRPC$InputEncryptedFile5);
                                if (iIndexOf >= 0) {
                                    tLRPC$TL_messages_sendEncryptedMultiMedia.files.set(iIndexOf, tLRPC$InputEncryptedFile);
                                    if (tLRPC$InputEncryptedFile5.id == 1) {
                                        delayedMessage.photoSize = (TLRPC$PhotoSize) delayedMessage.extraHashMap.get(str2 + "_t");
                                        stopVideoService(delayedMessage.messageObjects.get(iIndexOf).messageOwner.attachPath);
                                    }
                                    tLRPC$TL_decryptedMessage = tLRPC$TL_messages_sendEncryptedMultiMedia.messages.get(iIndexOf);
                                } else {
                                    tLRPC$TL_decryptedMessage = null;
                                }
                            } else {
                                tLRPC$TL_decryptedMessage = (TLRPC$TL_decryptedMessage) tLObject;
                            }
                            if (tLRPC$TL_decryptedMessage != null) {
                                TLRPC$DecryptedMessageMedia tLRPC$DecryptedMessageMedia = tLRPC$TL_decryptedMessage.media;
                                if ((tLRPC$DecryptedMessageMedia instanceof TLRPC$TL_decryptedMessageMediaVideo) || (tLRPC$DecryptedMessageMedia instanceof TLRPC$TL_decryptedMessageMediaPhoto) || (tLRPC$DecryptedMessageMedia instanceof TLRPC$TL_decryptedMessageMediaDocument)) {
                                    tLRPC$TL_decryptedMessage.media.size = (int) ((Long) objArr[5]).longValue();
                                }
                                TLRPC$DecryptedMessageMedia tLRPC$DecryptedMessageMedia2 = tLRPC$TL_decryptedMessage.media;
                                tLRPC$DecryptedMessageMedia2.key = (byte[]) objArr[3];
                                tLRPC$DecryptedMessageMedia2.iv = (byte[]) objArr[4];
                                if (delayedMessage.type == 4) {
                                    uploadMultiMedia(delayedMessage, null, tLRPC$InputEncryptedFile, str2);
                                } else {
                                    SecretChatHelper secretChatHelper = getSecretChatHelper();
                                    MessageObject messageObject3 = delayedMessage.obj;
                                    secretChatHelper.performSendEncryptedRequest(tLRPC$TL_decryptedMessage, messageObject3.messageOwner, delayedMessage.encryptedChat, tLRPC$InputEncryptedFile, delayedMessage.originalPath, messageObject3);
                                }
                            }
                            arrayList2.remove(i5);
                            i5--;
                        }
                    } else {
                        int i6 = delayedMessage.type;
                        if (i6 == 0) {
                            tLRPC$InputMedia.file = tLRPC$InputFile2;
                            arrayList3 = arrayList4;
                            tLRPC$InputEncryptedFile2 = tLRPC$InputEncryptedFile3;
                            i3 = i5;
                            tLRPC$InputFile = tLRPC$InputFile2;
                            str3 = str5;
                            performSendMessageRequest(delayedMessage.sendRequest, delayedMessage.obj, delayedMessage.originalPath, delayedMessage, true, null, delayedMessage.parentObject, null, delayedMessage.scheduled);
                        } else {
                            arrayList3 = arrayList4;
                            tLRPC$InputEncryptedFile2 = tLRPC$InputEncryptedFile3;
                            i3 = i5;
                            tLRPC$InputFile = tLRPC$InputFile2;
                            str3 = str5;
                            if (i6 == z) {
                                if (tLRPC$InputMedia.file == null) {
                                    tLRPC$InputMedia.file = tLRPC$InputFile;
                                    performSendMessageRequest(delayedMessage.sendRequest, delayedMessage.obj, delayedMessage.originalPath, null, delayedMessage.parentObject, null, delayedMessage.scheduled);
                                } else {
                                    tLRPC$InputMedia.thumb = tLRPC$InputFile;
                                    tLRPC$InputMedia.flags |= 4;
                                    performSendMessageRequest(delayedMessage.sendRequest, delayedMessage.obj, delayedMessage.originalPath, null, delayedMessage.parentObject, null, delayedMessage.scheduled);
                                }
                            } else if (i6 == 2) {
                                if (tLRPC$InputMedia.file == null) {
                                    tLRPC$InputMedia.file = tLRPC$InputFile;
                                    if (tLRPC$InputMedia.thumb == null && (tLRPC$PhotoSize = delayedMessage.photoSize) != null && tLRPC$PhotoSize.location != null) {
                                        performSendDelayedMessage(delayedMessage);
                                    } else {
                                        performSendMessageRequest(delayedMessage.sendRequest, delayedMessage.obj, delayedMessage.originalPath, null, delayedMessage.parentObject, null, delayedMessage.scheduled);
                                    }
                                } else {
                                    tLRPC$InputMedia.thumb = tLRPC$InputFile;
                                    tLRPC$InputMedia.flags |= 4;
                                    performSendMessageRequest(delayedMessage.sendRequest, delayedMessage.obj, delayedMessage.originalPath, null, delayedMessage.parentObject, null, delayedMessage.scheduled);
                                }
                            } else if (i6 == 3) {
                                tLRPC$InputMedia.file = tLRPC$InputFile;
                                performSendMessageRequest(delayedMessage.sendRequest, delayedMessage.obj, delayedMessage.originalPath, null, delayedMessage.parentObject, null, delayedMessage.scheduled);
                            } else {
                                if (i6 != 4) {
                                    str2 = str3;
                                } else if (tLRPC$InputMedia instanceof TLRPC$TL_inputMediaUploadedDocument) {
                                    if (tLRPC$InputMedia.file == null) {
                                        tLRPC$InputMedia.file = tLRPC$InputFile;
                                        HashMap<Object, Object> map = delayedMessage.extraHashMap;
                                        StringBuilder sb = new StringBuilder();
                                        str2 = str3;
                                        sb.append(str2);
                                        sb.append("_i");
                                        int iIndexOf2 = delayedMessage.messageObjects.indexOf((MessageObject) map.get(sb.toString()));
                                        if (iIndexOf2 >= 0) {
                                            stopVideoService(delayedMessage.messageObjects.get(iIndexOf2).messageOwner.attachPath);
                                        }
                                        TLRPC$PhotoSize tLRPC$PhotoSize2 = (TLRPC$PhotoSize) delayedMessage.extraHashMap.get(str2 + "_t");
                                        delayedMessage.photoSize = tLRPC$PhotoSize2;
                                        if (tLRPC$InputMedia.thumb == null && tLRPC$PhotoSize2 != null && tLRPC$PhotoSize2.location != null) {
                                            delayedMessage.performMediaUpload = z;
                                            performSendDelayedMessage(delayedMessage, iIndexOf2);
                                        } else {
                                            uploadMultiMedia(delayedMessage, tLRPC$InputMedia, null, str2);
                                        }
                                    } else {
                                        str2 = str3;
                                        tLRPC$InputMedia.thumb = tLRPC$InputFile;
                                        tLRPC$InputMedia.flags |= 4;
                                        uploadMultiMedia(delayedMessage, tLRPC$InputMedia, null, (String) delayedMessage.extraHashMap.get(str2 + "_o"));
                                    }
                                } else {
                                    str2 = str3;
                                    tLRPC$InputMedia.file = tLRPC$InputFile;
                                    uploadMultiMedia(delayedMessage, tLRPC$InputMedia, null, str2);
                                }
                                arrayList2 = arrayList3;
                                i4 = i3;
                                arrayList2.remove(i4);
                                i5 = i4 - 1;
                                tLRPC$InputEncryptedFile = tLRPC$InputEncryptedFile2;
                            }
                        }
                        arrayList2 = arrayList3;
                        i4 = i3;
                        str2 = str3;
                        arrayList2.remove(i4);
                        i5 = i4 - 1;
                        tLRPC$InputEncryptedFile = tLRPC$InputEncryptedFile2;
                    }
                    i5++;
                    arrayList4 = arrayList2;
                    str5 = str2;
                    tLRPC$InputFile2 = tLRPC$InputFile;
                    z = true;
                    tLRPC$InputEncryptedFile3 = tLRPC$InputEncryptedFile;
                }
                String str6 = str5;
                if (arrayList4.isEmpty()) {
                    this.delayedMessages.remove(str6);
                    return;
                }
                return;
            }
            return;
        }
        if (i == NotificationCenter.FileDidFailUpload) {
            String str7 = (String) objArr[0];
            boolean zBooleanValue = ((Boolean) objArr[1]).booleanValue();
            ImportingHistory importingHistory3 = this.importingHistoryFiles.get(str7);
            if (importingHistory3 != null) {
                importingHistory3.onFileFailedToUpload(str7);
            }
            ArrayList<DelayedMessage> arrayList5 = this.delayedMessages.get(str7);
            if (arrayList5 != null) {
                while (i5 < arrayList5.size()) {
                    DelayedMessage delayedMessage2 = arrayList5.get(i5);
                    if ((zBooleanValue && delayedMessage2.sendEncryptedRequest != null) || (!zBooleanValue && delayedMessage2.sendRequest != null)) {
                        delayedMessage2.markAsError();
                        arrayList5.remove(i5);
                        i5--;
                    }
                    i5++;
                }
                if (arrayList5.isEmpty()) {
                    this.delayedMessages.remove(str7);
                    return;
                }
                return;
            }
            return;
        }
        if (i == NotificationCenter.filePreparingStarted) {
            MessageObject messageObject4 = (MessageObject) objArr[0];
            if (messageObject4.getId() == 0) {
                return;
            }
            ArrayList<DelayedMessage> arrayList6 = this.delayedMessages.get(messageObject4.messageOwner.attachPath);
            if (arrayList6 != null) {
                while (true) {
                    if (i5 >= arrayList6.size()) {
                        break;
                    }
                    DelayedMessage delayedMessage3 = arrayList6.get(i5);
                    if (delayedMessage3.type == 4) {
                        int iIndexOf3 = delayedMessage3.messageObjects.indexOf(messageObject4);
                        delayedMessage3.photoSize = (TLRPC$PhotoSize) delayedMessage3.extraHashMap.get(messageObject4.messageOwner.attachPath + "_t");
                        delayedMessage3.performMediaUpload = true;
                        performSendDelayedMessage(delayedMessage3, iIndexOf3);
                        arrayList6.remove(i5);
                        break;
                    }
                    if (delayedMessage3.obj == messageObject4) {
                        delayedMessage3.videoEditedInfo = null;
                        performSendDelayedMessage(delayedMessage3);
                        arrayList6.remove(i5);
                        break;
                    }
                    i5++;
                }
                if (arrayList6.isEmpty()) {
                    this.delayedMessages.remove(messageObject4.messageOwner.attachPath);
                    return;
                }
                return;
            }
            return;
        }
        MessageObject messageObject5 = null;
        if (i == NotificationCenter.fileNewChunkAvailable) {
            MessageObject messageObject6 = (MessageObject) objArr[0];
            if (messageObject6.getId() == 0) {
                return;
            }
            String str8 = (String) objArr[1];
            long jLongValue = ((Long) objArr[2]).longValue();
            long jLongValue2 = ((Long) objArr[3]).longValue();
            getFileLoader().checkUploadNewDataAvailable(str8, ((int) messageObject6.getDialogId()) == 0, jLongValue, jLongValue2);
            if (jLongValue2 != 0) {
                stopVideoService(messageObject6.messageOwner.attachPath);
                ArrayList<DelayedMessage> arrayList7 = this.delayedMessages.get(messageObject6.messageOwner.attachPath);
                if (arrayList7 != null) {
                    for (int i7 = 0; i7 < arrayList7.size(); i7++) {
                        DelayedMessage delayedMessage4 = arrayList7.get(i7);
                        if (delayedMessage4.type == 4) {
                            int i8 = 0;
                            while (true) {
                                if (i8 >= delayedMessage4.messageObjects.size()) {
                                    break;
                                }
                                MessageObject messageObject7 = delayedMessage4.messageObjects.get(i8);
                                if (messageObject7 == messageObject6) {
                                    delayedMessage4.obj.shouldRemoveVideoEditedInfo = true;
                                    messageObject7.messageOwner.params.remove("ve");
                                    messageObject7.messageOwner.media.document.size = (int) jLongValue2;
                                    ArrayList<TLRPC$Message> arrayList8 = new ArrayList<>();
                                    arrayList8.add(messageObject7.messageOwner);
                                    getMessagesStorage().putMessages(arrayList8, false, true, false, 0, messageObject7.scheduled);
                                    break;
                                }
                                i8++;
                            }
                        } else {
                            MessageObject messageObject8 = delayedMessage4.obj;
                            if (messageObject8 == messageObject6) {
                                messageObject8.shouldRemoveVideoEditedInfo = true;
                                messageObject8.messageOwner.params.remove("ve");
                                delayedMessage4.obj.messageOwner.media.document.size = (int) jLongValue2;
                                ArrayList<TLRPC$Message> arrayList9 = new ArrayList<>();
                                arrayList9.add(delayedMessage4.obj.messageOwner);
                                getMessagesStorage().putMessages(arrayList9, false, true, false, 0, delayedMessage4.obj.scheduled);
                                return;
                            }
                        }
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (i == NotificationCenter.filePreparingFailed) {
            MessageObject messageObject9 = (MessageObject) objArr[0];
            if (messageObject9.getId() == 0) {
                return;
            }
            String str9 = (String) objArr[1];
            stopVideoService(messageObject9.messageOwner.attachPath);
            ArrayList<DelayedMessage> arrayList10 = this.delayedMessages.get(str9);
            if (arrayList10 != null) {
                int i9 = 0;
                while (i9 < arrayList10.size()) {
                    DelayedMessage delayedMessage5 = arrayList10.get(i9);
                    if (delayedMessage5.type == 4) {
                        for (int i10 = 0; i10 < delayedMessage5.messages.size(); i10++) {
                            if (delayedMessage5.messageObjects.get(i10) == messageObject9) {
                                delayedMessage5.markAsError();
                                arrayList10.remove(i9);
                                i9--;
                                break;
                            }
                        }
                    } else if (delayedMessage5.obj == messageObject9) {
                        delayedMessage5.markAsError();
                        arrayList10.remove(i9);
                        i9--;
                        break;
                        break;
                    }
                    i9++;
                }
                if (arrayList10.isEmpty()) {
                    this.delayedMessages.remove(str9);
                    return;
                }
                return;
            }
            return;
        }
        if (i == NotificationCenter.httpFileDidLoad) {
            final String str10 = (String) objArr[0];
            ArrayList<DelayedMessage> arrayList11 = this.delayedMessages.get(str10);
            if (arrayList11 != null) {
                int i11 = 0;
                while (i11 < arrayList11.size()) {
                    final DelayedMessage delayedMessage6 = arrayList11.get(i11);
                    int i12 = delayedMessage6.type;
                    if (i12 == 0) {
                        messageObject = delayedMessage6.obj;
                        c = 0;
                    } else {
                        if (i12 == 2) {
                            messageObject2 = delayedMessage6.obj;
                        } else if (i12 == 4) {
                            messageObject2 = (MessageObject) delayedMessage6.extraHashMap.get(str10);
                            if (messageObject2.getDocument() == null) {
                                messageObject = messageObject2;
                                c = 0;
                            }
                        } else {
                            c = 65535;
                            messageObject = messageObject5;
                        }
                        messageObject = messageObject2;
                        c = 1;
                    }
                    if (c == 0) {
                        final File file = new File(FileLoader.getDirectory(4), Utilities.MD5(str10) + "." + ImageLoader.getHttpUrlExtension(str10, "file"));
                        Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda24
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$didReceivedNotification$2(file, messageObject, delayedMessage6, str10);
                            }
                        });
                    } else {
                        if (c == 1) {
                            final File file2 = new File(FileLoader.getDirectory(4), Utilities.MD5(str10) + ".gif");
                            Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda37
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f$0.lambda$didReceivedNotification$4(delayedMessage6, file2, messageObject);
                                }
                            });
                        }
                        i11++;
                        messageObject5 = null;
                    }
                    i11++;
                    messageObject5 = null;
                }
                this.delayedMessages.remove(str10);
                return;
            }
            return;
        }
        if (i == NotificationCenter.fileDidLoad) {
            String str11 = (String) objArr[0];
            ArrayList<DelayedMessage> arrayList12 = this.delayedMessages.get(str11);
            if (arrayList12 != null) {
                while (i5 < arrayList12.size()) {
                    performSendDelayedMessage(arrayList12.get(i5));
                    i5++;
                }
                this.delayedMessages.remove(str11);
                return;
            }
            return;
        }
        if ((i == NotificationCenter.httpFileDidFailedLoad || i == NotificationCenter.fileDidFailToLoad) && (arrayList = this.delayedMessages.get((str = (String) objArr[0]))) != null) {
            while (i5 < arrayList.size()) {
                arrayList.get(i5).markAsError();
                i5++;
            }
            this.delayedMessages.remove(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$didReceivedNotification$2(final File file, final MessageObject messageObject, final DelayedMessage delayedMessage, final String str) {
        final TLRPC$TL_photo tLRPC$TL_photoGeneratePhotoSizes = generatePhotoSizes(file.toString(), null);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda58
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$didReceivedNotification$1(tLRPC$TL_photoGeneratePhotoSizes, messageObject, file, delayedMessage, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$didReceivedNotification$1(TLRPC$TL_photo tLRPC$TL_photo, MessageObject messageObject, File file, DelayedMessage delayedMessage, String str) {
        if (tLRPC$TL_photo != null) {
            TLRPC$Message tLRPC$Message = messageObject.messageOwner;
            tLRPC$Message.media.photo = tLRPC$TL_photo;
            tLRPC$Message.attachPath = file.toString();
            ArrayList<TLRPC$Message> arrayList = new ArrayList<>();
            arrayList.add(messageObject.messageOwner);
            getMessagesStorage().putMessages(arrayList, false, true, false, 0, messageObject.scheduled);
            getNotificationCenter().postNotificationName(NotificationCenter.updateMessageMedia, messageObject.messageOwner);
            ArrayList<TLRPC$PhotoSize> arrayList2 = tLRPC$TL_photo.sizes;
            delayedMessage.photoSize = arrayList2.get(arrayList2.size() - 1);
            delayedMessage.locationParent = tLRPC$TL_photo;
            delayedMessage.httpLocation = null;
            if (delayedMessage.type == 4) {
                delayedMessage.performMediaUpload = true;
                performSendDelayedMessage(delayedMessage, delayedMessage.messageObjects.indexOf(messageObject));
                return;
            } else {
                performSendDelayedMessage(delayedMessage);
                return;
            }
        }
        if (BuildVars.LOGS_ENABLED) {
            FileLog.e("can't load image " + str + " to file " + file.toString());
        }
        delayedMessage.markAsError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$didReceivedNotification$4(final DelayedMessage delayedMessage, final File file, final MessageObject messageObject) {
        final TLRPC$Document document = delayedMessage.obj.getDocument();
        if (document.thumbs.isEmpty() || (document.thumbs.get(0).location instanceof TLRPC$TL_fileLocationUnavailable)) {
            try {
                Bitmap bitmapLoadBitmap = ImageLoader.loadBitmap(file.getAbsolutePath(), null, 90.0f, 90.0f, true);
                if (bitmapLoadBitmap != null) {
                    document.thumbs.clear();
                    document.thumbs.add(ImageLoader.scaleAndSaveImage(bitmapLoadBitmap, 90.0f, 90.0f, 55, delayedMessage.sendEncryptedRequest != null));
                    bitmapLoadBitmap.recycle();
                }
            } catch (Exception e) {
                document.thumbs.clear();
                FileLog.e(e);
            }
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda38
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$didReceivedNotification$3(delayedMessage, file, document, messageObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$didReceivedNotification$3(DelayedMessage delayedMessage, File file, TLRPC$Document tLRPC$Document, MessageObject messageObject) {
        delayedMessage.httpLocation = null;
        delayedMessage.obj.messageOwner.attachPath = file.toString();
        if (!tLRPC$Document.thumbs.isEmpty()) {
            delayedMessage.photoSize = tLRPC$Document.thumbs.get(0);
            delayedMessage.locationParent = tLRPC$Document;
        }
        ArrayList<TLRPC$Message> arrayList = new ArrayList<>();
        arrayList.add(messageObject.messageOwner);
        getMessagesStorage().putMessages(arrayList, false, true, false, 0, messageObject.scheduled);
        delayedMessage.performMediaUpload = true;
        performSendDelayedMessage(delayedMessage);
        getNotificationCenter().postNotificationName(NotificationCenter.updateMessageMedia, delayedMessage.obj.messageOwner);
    }

    private void revertEditingMessageObject(MessageObject messageObject) {
        messageObject.cancelEditing = true;
        TLRPC$Message tLRPC$Message = messageObject.messageOwner;
        tLRPC$Message.media = messageObject.previousMedia;
        tLRPC$Message.message = messageObject.previousMessage;
        ArrayList<TLRPC$MessageEntity> arrayList = messageObject.previousMessageEntities;
        tLRPC$Message.entities = arrayList;
        tLRPC$Message.attachPath = messageObject.previousAttachPath;
        tLRPC$Message.send_state = 0;
        if (arrayList != null) {
            tLRPC$Message.flags |= 128;
        } else {
            tLRPC$Message.flags &= -129;
        }
        int i = tLRPC$Message.flags;
        if ((32768 & i) != 0) {
            tLRPC$Message.flags = i & (-32769);
        }
        messageObject.previousMedia = null;
        messageObject.previousMessage = null;
        messageObject.previousMessageEntities = null;
        messageObject.previousAttachPath = null;
        messageObject.videoEditedInfo = null;
        messageObject.type = -1;
        messageObject.setType();
        messageObject.caption = null;
        if (messageObject.type != 0) {
            messageObject.generateCaption();
        } else {
            messageObject.generateLayout(null);
        }
        new ArrayList().add(messageObject.messageOwner);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(messageObject);
        getNotificationCenter().postNotificationName(NotificationCenter.replaceMessagesObjects, Long.valueOf(messageObject.getDialogId()), arrayList2);
    }

    public void cancelSendingMessage(MessageObject messageObject) {
        ArrayList<MessageObject> arrayList = new ArrayList<>();
        arrayList.add(messageObject);
        cancelSendingMessage(arrayList);
    }

    public void cancelSendingMessage(ArrayList<MessageObject> arrayList) {
        boolean z;
        long j;
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList<Long> arrayList4 = new ArrayList<>();
        long dialogId = 0;
        int i = 0;
        boolean z2 = false;
        int i2 = 0;
        boolean z3 = false;
        while (i < arrayList.size()) {
            MessageObject messageObject = arrayList.get(i);
            if (messageObject.scheduled) {
                dialogId = messageObject.getDialogId();
                z3 = true;
            }
            arrayList4.add(Long.valueOf(messageObject.getId()));
            int i3 = messageObject.messageOwner.peer_id.channel_id;
            if (removeFromSendingMessages(messageObject.getId(), messageObject.scheduled) != null) {
                MessageProxy messagesProxy = getMessagesProxy();
                int i4 = messageObject.messageOwner.reqId;
                long id = messageObject.getId();
                long dialogId2 = messageObject.getDialogId();
                TLRPC$Message tLRPC$Message = messageObject.messageOwner;
                messagesProxy.removeLocalMessageFromDb(i4, id, dialogId2, tLRPC$Message.send_state, tLRPC$Message);
            }
            Iterator<Map.Entry<String, ArrayList<DelayedMessage>>> it = this.delayedMessages.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, ArrayList<DelayedMessage>> next = it.next();
                ArrayList<DelayedMessage> value = next.getValue();
                Iterator<Map.Entry<String, ArrayList<DelayedMessage>>> it2 = it;
                int i5 = 0;
                while (true) {
                    if (i5 >= value.size()) {
                        z = z2;
                        j = dialogId;
                        break;
                    }
                    DelayedMessage delayedMessage = value.get(i5);
                    z = z2;
                    j = dialogId;
                    if (delayedMessage.type == 4) {
                        int i6 = -1;
                        MessageObject messageObject2 = null;
                        int i7 = 0;
                        while (true) {
                            if (i7 >= delayedMessage.messageObjects.size()) {
                                break;
                            }
                            messageObject2 = delayedMessage.messageObjects.get(i7);
                            if (messageObject2.getId() == messageObject.getId()) {
                                removeFromUploadingMessages(messageObject.getId(), messageObject.scheduled);
                                i6 = i7;
                                break;
                            }
                            i7++;
                        }
                        if (i6 >= 0) {
                            delayedMessage.messageObjects.remove(i6);
                            delayedMessage.messages.remove(i6);
                            delayedMessage.originalPaths.remove(i6);
                            if (!delayedMessage.parentObjects.isEmpty()) {
                                delayedMessage.parentObjects.remove(i6);
                            }
                            TLObject tLObject = delayedMessage.sendRequest;
                            if (tLObject != null) {
                                ((TLRPC$TL_messages_sendMultiMedia) tLObject).multi_media.remove(i6);
                            } else {
                                TLRPC$TL_messages_sendEncryptedMultiMedia tLRPC$TL_messages_sendEncryptedMultiMedia = (TLRPC$TL_messages_sendEncryptedMultiMedia) delayedMessage.sendEncryptedRequest;
                                tLRPC$TL_messages_sendEncryptedMultiMedia.messages.remove(i6);
                                tLRPC$TL_messages_sendEncryptedMultiMedia.files.remove(i6);
                            }
                            MediaController.getInstance().cancelVideoConvert(messageObject);
                            String str = (String) delayedMessage.extraHashMap.get(messageObject2);
                            if (str != null) {
                                arrayList2.add(str);
                            }
                            if (delayedMessage.messageObjects.isEmpty()) {
                                delayedMessage.sendDelayedRequests();
                            } else {
                                if (delayedMessage.finalGroupMessage == messageObject.getId()) {
                                    ArrayList<MessageObject> arrayList5 = delayedMessage.messageObjects;
                                    MessageObject messageObject3 = arrayList5.get(arrayList5.size() - 1);
                                    delayedMessage.finalGroupMessage = messageObject3.getId();
                                    messageObject3.messageOwner.params.put("final", "1");
                                    TLRPC$TL_messages_messages tLRPC$TL_messages_messages = new TLRPC$TL_messages_messages();
                                    tLRPC$TL_messages_messages.messages.add(messageObject3.messageOwner);
                                    getMessagesStorage().putMessages((TLRPC$messages_Messages) tLRPC$TL_messages_messages, delayedMessage.peer, -2, 0L, false, z3);
                                }
                                if (!arrayList3.contains(delayedMessage)) {
                                    arrayList3.add(delayedMessage);
                                }
                            }
                        }
                    } else if (delayedMessage.obj.getId() == messageObject.getId()) {
                        MessageProxy messagesProxy2 = getMessagesProxy();
                        int i8 = messageObject.messageOwner.reqId;
                        long id2 = messageObject.getId();
                        long dialogId3 = messageObject.getDialogId();
                        TLRPC$Message tLRPC$Message2 = messageObject.messageOwner;
                        messagesProxy2.removeLocalMessageFromDb(i8, id2, dialogId3, tLRPC$Message2.send_state, tLRPC$Message2);
                        removeFromUploadingMessages(messageObject.getId(), messageObject.scheduled);
                        value.remove(i5);
                        delayedMessage.sendDelayedRequests();
                        MediaController.getInstance().cancelVideoConvert(delayedMessage.obj);
                        if (value.size() == 0) {
                            arrayList2.add(next.getKey());
                            if (delayedMessage.sendEncryptedRequest != null) {
                                z2 = true;
                            }
                        }
                    } else {
                        i5++;
                        z2 = z;
                        dialogId = j;
                    }
                }
                z2 = z;
                it = it2;
                dialogId = j;
            }
            i++;
            i2 = i3;
        }
        for (int i9 = 0; i9 < arrayList2.size(); i9++) {
            String str2 = (String) arrayList2.get(i9);
            if (str2.startsWith("http")) {
                ImageLoader.getInstance().cancelLoadHttpFile(str2);
            } else {
                getFileLoader().cancelUploadFile(str2, z2);
            }
            stopVideoService(str2);
            this.delayedMessages.remove(str2);
        }
        int size = arrayList3.size();
        for (int i10 = 0; i10 < size; i10++) {
            sendReadyToSendGroup((DelayedMessage) arrayList3.get(i10), false, true);
        }
        if (arrayList.size() == 1 && arrayList.get(0).isEditing() && arrayList.get(0).previousMedia != null) {
            revertEditingMessageObject(arrayList.get(0));
        } else {
            getMessagesController().deleteMessages(arrayList4, null, null, dialogId, i2, false, z3);
        }
    }

    public boolean retrySendMessage(MessageObject messageObject, boolean z) {
        if (messageObject.getId() >= 0) {
            if (messageObject.isEditing()) {
                editMessage(messageObject, null, null, null, null, null, true, messageObject);
            }
            return false;
        }
        TLRPC$MessageAction tLRPC$MessageAction = messageObject.messageOwner.action;
        if (tLRPC$MessageAction instanceof TLRPC$TL_messageEncryptedAction) {
            TLRPC$EncryptedChat encryptedChat = getMessagesController().getEncryptedChat(Integer.valueOf((int) (messageObject.getDialogId() >> 32)));
            if (encryptedChat == null) {
                getMessagesProxy().markMessageAsSendError(messageObject.messageOwner, messageObject.scheduled);
                messageObject.messageOwner.send_state = 2;
                getNotificationCenter().postNotificationName(NotificationCenter.messageSendError, Long.valueOf(messageObject.getId()));
                processSentMessage(messageObject.getId());
                return false;
            }
            TLRPC$Message tLRPC$Message = messageObject.messageOwner;
            if (tLRPC$Message.random_id == 0) {
                tLRPC$Message.random_id = getNextRandomId();
            }
            TLRPC$DecryptedMessageAction tLRPC$DecryptedMessageAction = messageObject.messageOwner.action.encryptedAction;
            if (tLRPC$DecryptedMessageAction instanceof TLRPC$TL_decryptedMessageActionSetMessageTTL) {
                getSecretChatHelper().sendTTLMessage(encryptedChat, messageObject.messageOwner);
            } else if (tLRPC$DecryptedMessageAction instanceof TLRPC$TL_decryptedMessageActionDeleteMessages) {
                getSecretChatHelper().sendMessagesDeleteMessage(encryptedChat, null, messageObject.messageOwner);
            } else if (tLRPC$DecryptedMessageAction instanceof TLRPC$TL_decryptedMessageActionFlushHistory) {
                getSecretChatHelper().sendClearHistoryMessage(encryptedChat, messageObject.messageOwner);
            } else if (tLRPC$DecryptedMessageAction instanceof TLRPC$TL_decryptedMessageActionNotifyLayer) {
                getSecretChatHelper().sendNotifyLayerMessage(encryptedChat, messageObject.messageOwner);
            } else if (tLRPC$DecryptedMessageAction instanceof TLRPC$TL_decryptedMessageActionReadMessages) {
                getSecretChatHelper().sendMessagesReadMessage(encryptedChat, null, messageObject.messageOwner);
            } else if (tLRPC$DecryptedMessageAction instanceof TLRPC$TL_decryptedMessageActionScreenshotMessages) {
                getSecretChatHelper().sendScreenshotMessage(encryptedChat, null, messageObject.messageOwner);
            } else if (!(tLRPC$DecryptedMessageAction instanceof TLRPC$TL_decryptedMessageActionTyping)) {
                if (tLRPC$DecryptedMessageAction instanceof TLRPC$TL_decryptedMessageActionResend) {
                    getSecretChatHelper().sendResendMessage(encryptedChat, 0, 0, messageObject.messageOwner);
                } else if (tLRPC$DecryptedMessageAction instanceof TLRPC$TL_decryptedMessageActionCommitKey) {
                    getSecretChatHelper().sendCommitKeyMessage(encryptedChat, messageObject.messageOwner);
                } else if (tLRPC$DecryptedMessageAction instanceof TLRPC$TL_decryptedMessageActionAbortKey) {
                    getSecretChatHelper().sendAbortKeyMessage(encryptedChat, messageObject.messageOwner, 0L);
                } else if (tLRPC$DecryptedMessageAction instanceof TLRPC$TL_decryptedMessageActionRequestKey) {
                    getSecretChatHelper().sendRequestKeyMessage(encryptedChat, messageObject.messageOwner);
                } else if (tLRPC$DecryptedMessageAction instanceof TLRPC$TL_decryptedMessageActionAcceptKey) {
                    getSecretChatHelper().sendAcceptKeyMessage(encryptedChat, messageObject.messageOwner);
                } else if (tLRPC$DecryptedMessageAction instanceof TLRPC$TL_decryptedMessageActionNoop) {
                    getSecretChatHelper().sendNoopMessage(encryptedChat, messageObject.messageOwner);
                }
            }
            return true;
        }
        if (tLRPC$MessageAction instanceof TLRPC$TL_messageActionScreenshotTaken) {
            sendScreenshotMessage(getMessagesController().getUser(Integer.valueOf((int) messageObject.getDialogId())), messageObject.getReplyMsgId(), messageObject.messageOwner);
        }
        if (z) {
            this.unsentMessages.put(messageObject.getId(), messageObject);
        }
        sendMessage(messageObject);
        return true;
    }

    protected void processSentMessage(long j) {
        int size = this.unsentMessages.size();
        this.unsentMessages.remove(j);
        if (size == 0 || this.unsentMessages.size() != 0) {
            return;
        }
        checkUnsentMessages();
    }

    public void processForwardFromMyName(MessageObject messageObject, long j) {
        ArrayList<TLRPC$MessageEntity> arrayList;
        HashMap<String, String> map;
        if (messageObject == null) {
            return;
        }
        TLRPC$Message tLRPC$Message = messageObject.messageOwner;
        TLRPC$MessageMedia tLRPC$MessageMedia = tLRPC$Message.media;
        if (tLRPC$MessageMedia != null && !(tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaEmpty) && !(tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaWebPage) && !(tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaGame) && !(tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaInvoice)) {
            int i = (int) j;
            if (i == 0 && tLRPC$Message.peer_id != null && ((tLRPC$MessageMedia.photo instanceof TLRPC$TL_photo) || (tLRPC$MessageMedia.document instanceof TLRPC$TL_document))) {
                HashMap<String, String> map2 = new HashMap<>();
                map2.put("parentObject", "sent_" + messageObject.messageOwner.peer_id.channel_id + "_" + messageObject.getId());
                map = map2;
            } else {
                map = null;
            }
            TLRPC$Message tLRPC$Message2 = messageObject.messageOwner;
            TLRPC$MessageMedia tLRPC$MessageMedia2 = tLRPC$Message2.media;
            TLRPC$Photo tLRPC$Photo = tLRPC$MessageMedia2.photo;
            if (tLRPC$Photo instanceof TLRPC$TL_photo) {
                sendMessage((TLRPC$TL_photo) tLRPC$Photo, null, j, messageObject.replyMessageObject, null, tLRPC$Message2.message, tLRPC$Message2.entities, null, map, true, 0, tLRPC$MessageMedia2.ttl_seconds, messageObject);
                return;
            }
            TLRPC$Document tLRPC$Document = tLRPC$MessageMedia2.document;
            if (tLRPC$Document instanceof TLRPC$TL_document) {
                sendMessage((TLRPC$TL_document) tLRPC$Document, null, tLRPC$Message2.attachPath, j, messageObject.replyMessageObject, null, tLRPC$Message2.message, tLRPC$Message2.entities, null, map, true, 0, tLRPC$MessageMedia2.ttl_seconds, messageObject);
                return;
            }
            if ((tLRPC$MessageMedia2 instanceof TLRPC$TL_messageMediaVenue) || (tLRPC$MessageMedia2 instanceof TLRPC$TL_messageMediaGeo)) {
                sendMessage(tLRPC$MessageMedia2, j, messageObject.replyMessageObject, (MessageObject) null, (TLRPC$ReplyMarkup) null, (HashMap<String, String>) null, true, 0);
                return;
            }
            if (tLRPC$MessageMedia2.phone_number == null) {
                if (i != 0) {
                    ArrayList<MessageObject> arrayList2 = new ArrayList<>();
                    arrayList2.add(messageObject);
                    sendMessage(arrayList2, j, true, 0);
                    return;
                }
                return;
            }
            TLRPC$TL_userContact_old2 tLRPC$TL_userContact_old2 = new TLRPC$TL_userContact_old2();
            TLRPC$MessageMedia tLRPC$MessageMedia3 = messageObject.messageOwner.media;
            tLRPC$TL_userContact_old2.phone = tLRPC$MessageMedia3.phone_number;
            tLRPC$TL_userContact_old2.first_name = tLRPC$MessageMedia3.first_name;
            tLRPC$TL_userContact_old2.last_name = tLRPC$MessageMedia3.last_name;
            tLRPC$TL_userContact_old2.id = tLRPC$MessageMedia3.user_id;
            sendMessage((TLRPC$User) tLRPC$TL_userContact_old2, j, messageObject.replyMessageObject, (MessageObject) null, (TLRPC$ReplyMarkup) null, (HashMap<String, String>) null, true, 0);
            return;
        }
        if (tLRPC$Message.message == null) {
            if (((int) j) != 0) {
                ArrayList<MessageObject> arrayList3 = new ArrayList<>();
                arrayList3.add(messageObject);
                sendMessage(arrayList3, j, true, 0);
                return;
            }
            return;
        }
        TLRPC$WebPage tLRPC$WebPage = tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaWebPage ? tLRPC$MessageMedia.webpage : null;
        ArrayList<TLRPC$MessageEntity> arrayList4 = tLRPC$Message.entities;
        if (arrayList4 == null || arrayList4.isEmpty()) {
            arrayList = null;
        } else {
            ArrayList<TLRPC$MessageEntity> arrayList5 = new ArrayList<>();
            for (int i2 = 0; i2 < messageObject.messageOwner.entities.size(); i2++) {
                TLRPC$MessageEntity tLRPC$MessageEntity = messageObject.messageOwner.entities.get(i2);
                if ((tLRPC$MessageEntity instanceof TLRPC$TL_messageEntityBold) || (tLRPC$MessageEntity instanceof TLRPC$TL_messageEntityItalic) || (tLRPC$MessageEntity instanceof TLRPC$TL_messageEntityPre) || (tLRPC$MessageEntity instanceof TLRPC$TL_messageEntityCode) || (tLRPC$MessageEntity instanceof TLRPC$TL_messageEntityTextUrl)) {
                    arrayList5.add(tLRPC$MessageEntity);
                }
            }
            arrayList = arrayList5;
        }
        sendMessage(messageObject.messageOwner.message, j, messageObject.replyMessageObject, (MessageObject) null, tLRPC$WebPage, true, arrayList, (TLRPC$ReplyMarkup) null, (HashMap<String, String>) null, true, 0);
    }

    public void sendScreenshotMessage(TLRPC$User tLRPC$User, long j, TLRPC$Message tLRPC$Message) {
        TLRPC$Message tLRPC$TL_messageService = tLRPC$Message;
        if (tLRPC$User == null || j == 0 || tLRPC$User.id == getUserConfig().getClientUserId()) {
            return;
        }
        TLRPC$TL_messages_sendScreenshotNotification tLRPC$TL_messages_sendScreenshotNotification = new TLRPC$TL_messages_sendScreenshotNotification();
        TLRPC$TL_inputPeerUser tLRPC$TL_inputPeerUser = new TLRPC$TL_inputPeerUser();
        tLRPC$TL_messages_sendScreenshotNotification.peer = tLRPC$TL_inputPeerUser;
        tLRPC$TL_inputPeerUser.access_hash = tLRPC$User.access_hash;
        tLRPC$TL_inputPeerUser.user_id = tLRPC$User.id;
        if (tLRPC$TL_messageService != null) {
            tLRPC$TL_messages_sendScreenshotNotification.reply_to_msg_id = j;
            tLRPC$TL_messages_sendScreenshotNotification.random_id = tLRPC$TL_messageService.random_id;
        } else {
            tLRPC$TL_messageService = new TLRPC$TL_messageService();
            tLRPC$TL_messageService.random_id = getNextRandomId();
            tLRPC$TL_messageService.dialog_id = tLRPC$User.id;
            tLRPC$TL_messageService.unread = true;
            tLRPC$TL_messageService.out = true;
            long newMessageId = getUserConfig().getNewMessageId();
            tLRPC$TL_messageService.id = newMessageId;
            tLRPC$TL_messageService.local_id = newMessageId;
            TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
            tLRPC$TL_messageService.from_id = tLRPC$TL_peerUser;
            tLRPC$TL_peerUser.user_id = getUserConfig().getClientUserId();
            int i = tLRPC$TL_messageService.flags | 256;
            tLRPC$TL_messageService.flags = i;
            tLRPC$TL_messageService.flags = i | 8;
            TLRPC$TL_messageReplyHeader tLRPC$TL_messageReplyHeader = new TLRPC$TL_messageReplyHeader();
            tLRPC$TL_messageService.reply_to = tLRPC$TL_messageReplyHeader;
            tLRPC$TL_messageReplyHeader.reply_to_msg_id = j;
            TLRPC$TL_peerUser tLRPC$TL_peerUser2 = new TLRPC$TL_peerUser();
            tLRPC$TL_messageService.peer_id = tLRPC$TL_peerUser2;
            tLRPC$TL_peerUser2.user_id = tLRPC$User.id;
            tLRPC$TL_messageService.date = getConnectionsManager().getCurrentTime();
            tLRPC$TL_messageService.action = new TLRPC$TL_messageActionScreenshotTaken();
            getUserConfig().saveConfig(false);
        }
        tLRPC$TL_messages_sendScreenshotNotification.random_id = tLRPC$TL_messageService.random_id;
        MessageObject messageObject = new MessageObject(this.currentAccount, tLRPC$TL_messageService, false, true);
        messageObject.messageOwner.send_state = 1;
        messageObject.wasJustSent = true;
        ArrayList<MessageObject> arrayList = new ArrayList<>();
        arrayList.add(messageObject);
        getMessagesController().updateInterfaceWithMessages(tLRPC$TL_messageService.dialog_id, arrayList, false);
        getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[0]);
        ArrayList<TLRPC$Message> arrayList2 = new ArrayList<>();
        arrayList2.add(tLRPC$TL_messageService);
        getMessagesStorage().putMessages(arrayList2, false, true, false, 0, false);
        performSendMessageRequest(tLRPC$TL_messages_sendScreenshotNotification, messageObject, null, null, null, null, false);
    }

    public void sendSticker(TLRPC$Document tLRPC$Document, String str, final long j, final MessageObject messageObject, final MessageObject messageObject2, final Object obj, MessageObject.SendAnimationData sendAnimationData, final boolean z, final int i, boolean z2) throws IOException {
        final TLRPC$Document tLRPC$Document2;
        HashMap<String, String> map;
        if (tLRPC$Document == null) {
            return;
        }
        if (((int) j) == 0) {
            if (getMessagesController().getEncryptedChat(Integer.valueOf((int) (j >> 32))) == null) {
                return;
            }
            TLRPC$TL_document_layer82 tLRPC$TL_document_layer82 = new TLRPC$TL_document_layer82();
            tLRPC$TL_document_layer82.id = tLRPC$Document.id;
            tLRPC$TL_document_layer82.access_hash = tLRPC$Document.access_hash;
            tLRPC$TL_document_layer82.date = tLRPC$Document.date;
            tLRPC$TL_document_layer82.mime_type = tLRPC$Document.mime_type;
            byte[] bArr = tLRPC$Document.file_reference;
            tLRPC$TL_document_layer82.file_reference = bArr;
            if (bArr == null) {
                tLRPC$TL_document_layer82.file_reference = new byte[0];
            }
            tLRPC$TL_document_layer82.size = tLRPC$Document.size;
            tLRPC$TL_document_layer82.dc_id = tLRPC$Document.dc_id;
            tLRPC$TL_document_layer82.attributes = new ArrayList<>(tLRPC$Document.attributes);
            if (tLRPC$TL_document_layer82.mime_type == null) {
                tLRPC$TL_document_layer82.mime_type = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
            }
            TLRPC$PhotoSize closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(tLRPC$Document.thumbs, 90);
            if ((closestPhotoSizeWithSize instanceof TLRPC$TL_photoSize) || (closestPhotoSizeWithSize instanceof TLRPC$TL_photoSizeProgressive)) {
                File pathToAttach = FileLoader.getPathToAttach(closestPhotoSizeWithSize, true);
                if (pathToAttach.exists()) {
                    try {
                        pathToAttach.length();
                        byte[] bArr2 = new byte[(int) pathToAttach.length()];
                        new RandomAccessFile(pathToAttach, "r").readFully(bArr2);
                        TLRPC$TL_photoCachedSize tLRPC$TL_photoCachedSize = new TLRPC$TL_photoCachedSize();
                        TLRPC$TL_fileLocation_layer82 tLRPC$TL_fileLocation_layer82 = new TLRPC$TL_fileLocation_layer82();
                        TLRPC$FileLocation tLRPC$FileLocation = closestPhotoSizeWithSize.location;
                        tLRPC$TL_fileLocation_layer82.dc_id = tLRPC$FileLocation.dc_id;
                        tLRPC$TL_fileLocation_layer82.volume_id = tLRPC$FileLocation.volume_id;
                        tLRPC$TL_fileLocation_layer82.local_id = tLRPC$FileLocation.local_id;
                        tLRPC$TL_fileLocation_layer82.secret = tLRPC$FileLocation.secret;
                        tLRPC$TL_photoCachedSize.location = tLRPC$TL_fileLocation_layer82;
                        tLRPC$TL_photoCachedSize.size = closestPhotoSizeWithSize.size;
                        tLRPC$TL_photoCachedSize.w = closestPhotoSizeWithSize.w;
                        tLRPC$TL_photoCachedSize.h = closestPhotoSizeWithSize.h;
                        tLRPC$TL_photoCachedSize.type = closestPhotoSizeWithSize.type;
                        tLRPC$TL_photoCachedSize.bytes = bArr2;
                        tLRPC$TL_document_layer82.thumbs.add(tLRPC$TL_photoCachedSize);
                        tLRPC$TL_document_layer82.flags |= 1;
                    } catch (Exception e) {
                        FileLog.e(e);
                    }
                }
            }
            if (tLRPC$TL_document_layer82.thumbs.isEmpty()) {
                TLRPC$TL_photoSizeEmpty tLRPC$TL_photoSizeEmpty = new TLRPC$TL_photoSizeEmpty();
                tLRPC$TL_photoSizeEmpty.type = "s";
                tLRPC$TL_document_layer82.thumbs.add(tLRPC$TL_photoSizeEmpty);
            }
            tLRPC$Document2 = tLRPC$TL_document_layer82;
        } else {
            tLRPC$Document2 = tLRPC$Document;
        }
        if (MessageObject.isGifDocument(tLRPC$Document2)) {
            mediaSendQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda41
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$sendSticker$6(tLRPC$Document2, j, messageObject, messageObject2, z, i, obj);
                }
            });
            return;
        }
        if (TextUtils.isEmpty(str)) {
            map = null;
        } else {
            map = new HashMap<>();
            map.put("query", str);
        }
        sendMessage((TLRPC$TL_document) tLRPC$Document2, null, null, j, messageObject, messageObject2, null, null, null, map, z, i, 0, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendSticker$6(final TLRPC$Document tLRPC$Document, final long j, final MessageObject messageObject, final MessageObject messageObject2, final boolean z, final int i, final Object obj) {
        String str;
        final Bitmap[] bitmapArr = new Bitmap[1];
        final String[] strArr = new String[1];
        String key = ImageLocation.getForDocument(tLRPC$Document).getKey(null, null, false);
        if ("video/mp4".equals(tLRPC$Document.mime_type)) {
            str = ".mp4";
        } else {
            str = "video/x-matroska".equals(tLRPC$Document.mime_type) ? ".mkv" : io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
        }
        File file = new File(FileLoader.getDirectory(3), key + str);
        if (!file.exists()) {
            file = new File(FileLoader.getDirectory(2), key + str);
        }
        ensureMediaThumbExists(false, tLRPC$Document, file.getAbsolutePath(), null, 0L);
        strArr[0] = getKeyForPhotoSize(FileLoader.getClosestPhotoSizeWithSize(tLRPC$Document.thumbs, 320), bitmapArr, true, true);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda68
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$sendSticker$5(bitmapArr, strArr, tLRPC$Document, j, messageObject, messageObject2, z, i, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendSticker$5(Bitmap[] bitmapArr, String[] strArr, TLRPC$Document tLRPC$Document, long j, MessageObject messageObject, MessageObject messageObject2, boolean z, int i, Object obj) {
        if (bitmapArr[0] != null && strArr[0] != null) {
            ImageLoader.getInstance().putImageToCache(new BitmapDrawable(bitmapArr[0]), strArr[0], false);
        }
        sendMessage((TLRPC$TL_document) tLRPC$Document, null, null, j, messageObject, messageObject2, null, null, null, null, z, i, 0, obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:141:0x035d  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0397  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x03a3  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x03ad  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x03ec  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x049f  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x04aa  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x04b4  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x04ce  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x04fa A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:217:0x050e  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0514  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0517  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x052c  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0553  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0555  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0575  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x05bd  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x05cc  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x05d7  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x05e8  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x05ea  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x05ff  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0601  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0609  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0642  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x064e  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x06ab  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x06c4  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x06c6  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x06e8  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x070a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int sendMessage(java.util.ArrayList<org.rbmain.messenger.MessageObject> r48, final long r49, boolean r51, final int r52) {
        /*
            Method dump skipped, instructions count: 2220
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.SendMessagesHelper.sendMessage(java.util.ArrayList, long, boolean, int):int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$sendMessage$14(final long r26, final int r28, boolean r29, boolean r30, androidx.collection.LongSparseArray r31, java.util.ArrayList r32, java.util.ArrayList r33, final org.rbmain.messenger.MessageObject r34, final org.rbmain.tgnet.TLRPC$Peer r35, final org.rbmain.tgnet.TLRPC$TL_messages_forwardMessages r36, org.rbmain.tgnet.TLObject r37, final org.rbmain.tgnet.TLRPC$TL_error r38) {
        /*
            Method dump skipped, instructions count: 568
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.SendMessagesHelper.lambda$sendMessage$14(long, int, boolean, boolean, androidx.collection.LongSparseArray, java.util.ArrayList, java.util.ArrayList, org.rbmain.messenger.MessageObject, org.rbmain.tgnet.TLRPC$Peer, org.rbmain.tgnet.TLRPC$TL_messages_forwardMessages, org.rbmain.tgnet.TLObject, org.rbmain.tgnet.TLRPC$TL_error):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendMessage$9(final long j, final TLRPC$Message tLRPC$Message, final ArrayList arrayList, final MessageObject messageObject, final int i) {
        ArrayList<Long> arrayList2 = new ArrayList<>();
        arrayList2.add(Long.valueOf(j));
        getMessagesController().deleteMessages(arrayList2, null, null, tLRPC$Message.dialog_id, tLRPC$Message.peer_id.channel_id, false, true);
        getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda32
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$sendMessage$8(arrayList, messageObject, tLRPC$Message, j, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendMessage$8(ArrayList arrayList, final MessageObject messageObject, final TLRPC$Message tLRPC$Message, final long j, final int i) {
        getMessagesStorage().putMessages((ArrayList<TLRPC$Message>) arrayList, true, false, false, 0, false);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda35
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$sendMessage$7(messageObject, tLRPC$Message, j, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendMessage$7(MessageObject messageObject, TLRPC$Message tLRPC$Message, long j, int i) {
        ArrayList<MessageObject> arrayList = new ArrayList<>();
        arrayList.add(new MessageObject(messageObject.currentAccount, messageObject.messageOwner, true, true));
        getMessagesController().updateInterfaceWithMessages(tLRPC$Message.dialog_id, arrayList, false);
        getMediaDataController().increasePeerRaiting(tLRPC$Message.dialog_id);
        processSentMessage(j);
        removeFromSendingMessages(j, i != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendMessage$11(final TLRPC$Message tLRPC$Message, final long j, TLRPC$Peer tLRPC$Peer, final int i, ArrayList arrayList, final long j2, final TLRPC$Message tLRPC$Message2, final int i2) {
        getMessagesStorage().updateMessageStateAndId(tLRPC$Message.random_id, Long.valueOf(j), tLRPC$Message.id, 0, false, tLRPC$Peer.channel_id, i != 0 ? 1 : 0);
        getMessagesStorage().putMessages((ArrayList<TLRPC$Message>) arrayList, true, false, false, 0, i != 0);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda44
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$sendMessage$10(tLRPC$Message, j2, j, tLRPC$Message2, i2, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendMessage$10(TLRPC$Message tLRPC$Message, long j, long j2, TLRPC$Message tLRPC$Message2, int i, int i2) {
        tLRPC$Message.send_state = 0;
        getMediaDataController().increasePeerRaiting(j);
        NotificationCenter notificationCenter = getNotificationCenter();
        int i3 = NotificationCenter.messageReceivedByServer;
        Object[] objArr = new Object[7];
        objArr[0] = Long.valueOf(j2);
        objArr[1] = Long.valueOf(tLRPC$Message2.id);
        objArr[2] = tLRPC$Message2;
        objArr[3] = Long.valueOf(j);
        objArr[4] = 0L;
        objArr[5] = Integer.valueOf(i);
        objArr[6] = Boolean.valueOf(i2 != 0);
        notificationCenter.postNotificationName(i3, objArr);
        processSentMessage(j2);
        removeFromSendingMessages(j2, i2 != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendMessage$12(TLRPC$TL_error tLRPC$TL_error, TLRPC$TL_messages_forwardMessages tLRPC$TL_messages_forwardMessages) {
        AlertsCreator.processError(this.currentAccount, tLRPC$TL_error, null, tLRPC$TL_messages_forwardMessages, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendMessage$13(TLRPC$Message tLRPC$Message, int i) {
        tLRPC$Message.send_state = 2;
        getNotificationCenter().postNotificationName(NotificationCenter.messageSendError, Long.valueOf(tLRPC$Message.id));
        processSentMessage(tLRPC$Message.id);
        removeFromSendingMessages(tLRPC$Message.id, i != 0);
    }

    private void writePreviousMessageData(TLRPC$Message tLRPC$Message, SerializedData serializedData) {
        TLRPC$MessageMedia tLRPC$MessageMedia = tLRPC$Message.media;
        if (tLRPC$MessageMedia == null) {
            new TLRPC$TL_messageMediaEmpty().serializeToStream(serializedData);
        } else {
            tLRPC$MessageMedia.serializeToStream(serializedData);
        }
        String str = tLRPC$Message.message;
        String str2 = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
        if (str == null) {
            str = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
        }
        serializedData.writeString(str);
        String str3 = tLRPC$Message.attachPath;
        if (str3 != null) {
            str2 = str3;
        }
        serializedData.writeString(str2);
        int size = tLRPC$Message.entities.size();
        serializedData.writeInt32(size);
        for (int i = 0; i < size; i++) {
            tLRPC$Message.entities.get(i).serializeToStream(serializedData);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:224:0x04ad A[Catch: Exception -> 0x059d, TryCatch #0 {Exception -> 0x059d, blocks: (B:222:0x0494, B:224:0x04ad, B:225:0x04b5, B:227:0x04b9, B:228:0x04c7, B:230:0x04cb, B:234:0x04de, B:236:0x04e4, B:243:0x0511, B:238:0x04ed, B:240:0x0501, B:242:0x0507, B:245:0x0517, B:248:0x051c, B:252:0x0531, B:253:0x0536, B:257:0x0549, B:258:0x054e, B:261:0x0560, B:265:0x0573, B:266:0x0577, B:270:0x058b, B:271:0x058f, B:164:0x030b, B:166:0x031f, B:168:0x0325, B:170:0x032d, B:171:0x0330, B:175:0x034b, B:177:0x0352, B:179:0x035a, B:181:0x036b, B:182:0x0380, B:183:0x0389, B:186:0x039b, B:188:0x039f, B:190:0x03a6, B:191:0x03ab, B:193:0x03bb, B:196:0x03c4, B:198:0x03de, B:201:0x03e8, B:203:0x0404, B:204:0x0411, B:207:0x041c, B:209:0x0439, B:212:0x0442, B:214:0x045c, B:217:0x0466, B:219:0x047c, B:220:0x0489), top: B:282:0x027f }] */
    /* JADX WARN: Removed duplicated region for block: B:227:0x04b9 A[Catch: Exception -> 0x059d, TryCatch #0 {Exception -> 0x059d, blocks: (B:222:0x0494, B:224:0x04ad, B:225:0x04b5, B:227:0x04b9, B:228:0x04c7, B:230:0x04cb, B:234:0x04de, B:236:0x04e4, B:243:0x0511, B:238:0x04ed, B:240:0x0501, B:242:0x0507, B:245:0x0517, B:248:0x051c, B:252:0x0531, B:253:0x0536, B:257:0x0549, B:258:0x054e, B:261:0x0560, B:265:0x0573, B:266:0x0577, B:270:0x058b, B:271:0x058f, B:164:0x030b, B:166:0x031f, B:168:0x0325, B:170:0x032d, B:171:0x0330, B:175:0x034b, B:177:0x0352, B:179:0x035a, B:181:0x036b, B:182:0x0380, B:183:0x0389, B:186:0x039b, B:188:0x039f, B:190:0x03a6, B:191:0x03ab, B:193:0x03bb, B:196:0x03c4, B:198:0x03de, B:201:0x03e8, B:203:0x0404, B:204:0x0411, B:207:0x041c, B:209:0x0439, B:212:0x0442, B:214:0x045c, B:217:0x0466, B:219:0x047c, B:220:0x0489), top: B:282:0x027f }] */
    /* JADX WARN: Removed duplicated region for block: B:230:0x04cb A[Catch: Exception -> 0x059d, TryCatch #0 {Exception -> 0x059d, blocks: (B:222:0x0494, B:224:0x04ad, B:225:0x04b5, B:227:0x04b9, B:228:0x04c7, B:230:0x04cb, B:234:0x04de, B:236:0x04e4, B:243:0x0511, B:238:0x04ed, B:240:0x0501, B:242:0x0507, B:245:0x0517, B:248:0x051c, B:252:0x0531, B:253:0x0536, B:257:0x0549, B:258:0x054e, B:261:0x0560, B:265:0x0573, B:266:0x0577, B:270:0x058b, B:271:0x058f, B:164:0x030b, B:166:0x031f, B:168:0x0325, B:170:0x032d, B:171:0x0330, B:175:0x034b, B:177:0x0352, B:179:0x035a, B:181:0x036b, B:182:0x0380, B:183:0x0389, B:186:0x039b, B:188:0x039f, B:190:0x03a6, B:191:0x03ab, B:193:0x03bb, B:196:0x03c4, B:198:0x03de, B:201:0x03e8, B:203:0x0404, B:204:0x0411, B:207:0x041c, B:209:0x0439, B:212:0x0442, B:214:0x045c, B:217:0x0466, B:219:0x047c, B:220:0x0489), top: B:282:0x027f }] */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0517 A[Catch: Exception -> 0x059d, TryCatch #0 {Exception -> 0x059d, blocks: (B:222:0x0494, B:224:0x04ad, B:225:0x04b5, B:227:0x04b9, B:228:0x04c7, B:230:0x04cb, B:234:0x04de, B:236:0x04e4, B:243:0x0511, B:238:0x04ed, B:240:0x0501, B:242:0x0507, B:245:0x0517, B:248:0x051c, B:252:0x0531, B:253:0x0536, B:257:0x0549, B:258:0x054e, B:261:0x0560, B:265:0x0573, B:266:0x0577, B:270:0x058b, B:271:0x058f, B:164:0x030b, B:166:0x031f, B:168:0x0325, B:170:0x032d, B:171:0x0330, B:175:0x034b, B:177:0x0352, B:179:0x035a, B:181:0x036b, B:182:0x0380, B:183:0x0389, B:186:0x039b, B:188:0x039f, B:190:0x03a6, B:191:0x03ab, B:193:0x03bb, B:196:0x03c4, B:198:0x03de, B:201:0x03e8, B:203:0x0404, B:204:0x0411, B:207:0x041c, B:209:0x0439, B:212:0x0442, B:214:0x045c, B:217:0x0466, B:219:0x047c, B:220:0x0489), top: B:282:0x027f }] */
    /* JADX WARN: Removed duplicated region for block: B:248:0x051c A[Catch: Exception -> 0x059d, TryCatch #0 {Exception -> 0x059d, blocks: (B:222:0x0494, B:224:0x04ad, B:225:0x04b5, B:227:0x04b9, B:228:0x04c7, B:230:0x04cb, B:234:0x04de, B:236:0x04e4, B:243:0x0511, B:238:0x04ed, B:240:0x0501, B:242:0x0507, B:245:0x0517, B:248:0x051c, B:252:0x0531, B:253:0x0536, B:257:0x0549, B:258:0x054e, B:261:0x0560, B:265:0x0573, B:266:0x0577, B:270:0x058b, B:271:0x058f, B:164:0x030b, B:166:0x031f, B:168:0x0325, B:170:0x032d, B:171:0x0330, B:175:0x034b, B:177:0x0352, B:179:0x035a, B:181:0x036b, B:182:0x0380, B:183:0x0389, B:186:0x039b, B:188:0x039f, B:190:0x03a6, B:191:0x03ab, B:193:0x03bb, B:196:0x03c4, B:198:0x03de, B:201:0x03e8, B:203:0x0404, B:204:0x0411, B:207:0x041c, B:209:0x0439, B:212:0x0442, B:214:0x045c, B:217:0x0466, B:219:0x047c, B:220:0x0489), top: B:282:0x027f }] */
    /* JADX WARN: Removed duplicated region for block: B:249:0x052c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void editMessage(org.rbmain.messenger.MessageObject r22, org.rbmain.tgnet.TLRPC$TL_photo r23, org.rbmain.messenger.VideoEditedInfo r24, org.rbmain.tgnet.TLRPC$TL_document r25, java.lang.String r26, java.util.HashMap<java.lang.String, java.lang.String> r27, boolean r28, java.lang.Object r29) {
        /*
            Method dump skipped, instructions count: 1455
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.SendMessagesHelper.editMessage(org.rbmain.messenger.MessageObject, org.rbmain.tgnet.TLRPC$TL_photo, org.rbmain.messenger.VideoEditedInfo, org.rbmain.tgnet.TLRPC$TL_document, java.lang.String, java.util.HashMap, boolean, java.lang.Object):void");
    }

    public int editMessage(MessageObject messageObject, String str, boolean z, final BaseFragment baseFragment, ArrayList<TLRPC$MessageEntity> arrayList, int i) {
        if (baseFragment == null || baseFragment.getParentActivity() == null) {
            return 0;
        }
        final TLRPC$TL_messages_editMessage tLRPC$TL_messages_editMessage = new TLRPC$TL_messages_editMessage();
        tLRPC$TL_messages_editMessage.peer = getMessagesController().getInputPeer((int) messageObject.getDialogId());
        if (str != null) {
            tLRPC$TL_messages_editMessage.message = str;
            tLRPC$TL_messages_editMessage.flags |= 2048;
            tLRPC$TL_messages_editMessage.no_webpage = !z;
        }
        tLRPC$TL_messages_editMessage.id = messageObject.getId();
        if (arrayList != null) {
            tLRPC$TL_messages_editMessage.entities = arrayList;
            tLRPC$TL_messages_editMessage.flags |= 8;
        }
        if (i != 0) {
            tLRPC$TL_messages_editMessage.schedule_date = i;
            tLRPC$TL_messages_editMessage.flags |= 32768;
        }
        return getConnectionsManager().sendRequest(tLRPC$TL_messages_editMessage, new RequestDelegate() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda84
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$editMessage$16(baseFragment, tLRPC$TL_messages_editMessage, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$editMessage$16(final BaseFragment baseFragment, final TLRPC$TL_messages_editMessage tLRPC$TL_messages_editMessage, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            getMessagesController().processUpdates((TLRPC$Updates) tLObject, false);
        } else {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda56
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$editMessage$15(tLRPC$TL_error, baseFragment, tLRPC$TL_messages_editMessage);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$editMessage$15(TLRPC$TL_error tLRPC$TL_error, BaseFragment baseFragment, TLRPC$TL_messages_editMessage tLRPC$TL_messages_editMessage) {
        AlertsCreator.processError(this.currentAccount, tLRPC$TL_error, baseFragment, tLRPC$TL_messages_editMessage, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendLocation(Location location) {
        TLRPC$TL_messageMediaGeo tLRPC$TL_messageMediaGeo = new TLRPC$TL_messageMediaGeo();
        TLRPC$TL_geoPoint tLRPC$TL_geoPoint = new TLRPC$TL_geoPoint();
        tLRPC$TL_messageMediaGeo.geo = tLRPC$TL_geoPoint;
        tLRPC$TL_geoPoint.lat = AndroidUtilities.fixLocationCoord(location.getLatitude());
        tLRPC$TL_messageMediaGeo.geo._long = AndroidUtilities.fixLocationCoord(location.getLongitude());
        Iterator<Map.Entry<String, MessageObject>> it = this.waitingForLocation.entrySet().iterator();
        while (it.hasNext()) {
            MessageObject value = it.next().getValue();
            sendMessage((TLRPC$MessageMedia) tLRPC$TL_messageMediaGeo, value.getDialogId(), value, (MessageObject) null, (TLRPC$ReplyMarkup) null, (HashMap<String, String>) null, true, 0);
        }
    }

    public void sendCurrentLocation(MessageObject messageObject, TLRPC$KeyboardButton tLRPC$KeyboardButton) {
        if (messageObject == null || tLRPC$KeyboardButton == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(messageObject.getDialogId());
        sb.append("_");
        sb.append(messageObject.getId());
        sb.append("_");
        sb.append(Utilities.bytesToHex(tLRPC$KeyboardButton.data));
        sb.append("_");
        sb.append(tLRPC$KeyboardButton instanceof TLRPC$TL_keyboardButtonGame ? "1" : "0");
        this.waitingForLocation.put(sb.toString(), messageObject);
        this.locationProvider.start();
    }

    public boolean isSendingCurrentLocation(MessageObject messageObject, TLRPC$KeyboardButton tLRPC$KeyboardButton) {
        if (messageObject == null || tLRPC$KeyboardButton == null) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(messageObject.getDialogId());
        sb.append("_");
        sb.append(messageObject.getId());
        sb.append("_");
        sb.append(Utilities.bytesToHex(tLRPC$KeyboardButton.data));
        sb.append("_");
        sb.append(tLRPC$KeyboardButton instanceof TLRPC$TL_keyboardButtonGame ? "1" : "0");
        return this.waitingForLocation.containsKey(sb.toString());
    }

    public void sendNotificationCallback(final long j, final long j2, final byte[] bArr) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda22
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$sendNotificationCallback$19(j, j2, bArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendNotificationCallback$19(long j, long j2, byte[] bArr) {
        TLRPC$Chat chatSync;
        TLRPC$User userSync;
        int i = (int) j;
        final String str = j + "_" + j2 + "_" + Utilities.bytesToHex(bArr) + "_0";
        this.waitingForCallback.put(str, Boolean.TRUE);
        if (i > 0) {
            if (getMessagesController().getUser(Integer.valueOf(i)) == null && (userSync = getMessagesStorage().getUserSync(i)) != null) {
                getMessagesController().putUser(userSync, true);
            }
        } else {
            int i2 = -i;
            if (getMessagesController().getChat(Integer.valueOf(i2)) == null && (chatSync = getMessagesStorage().getChatSync(i2)) != null) {
                getMessagesController().putChat(chatSync, true);
            }
        }
        TLRPC$TL_messages_getBotCallbackAnswer tLRPC$TL_messages_getBotCallbackAnswer = new TLRPC$TL_messages_getBotCallbackAnswer();
        tLRPC$TL_messages_getBotCallbackAnswer.peer = getMessagesController().getInputPeer(i);
        tLRPC$TL_messages_getBotCallbackAnswer.msg_id = j2;
        tLRPC$TL_messages_getBotCallbackAnswer.game = false;
        if (bArr != null) {
            tLRPC$TL_messages_getBotCallbackAnswer.flags |= 1;
            tLRPC$TL_messages_getBotCallbackAnswer.data = bArr;
        }
        getConnectionsManager().sendRequest(tLRPC$TL_messages_getBotCallbackAnswer, new RequestDelegate() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda77
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$sendNotificationCallback$18(str, tLObject, tLRPC$TL_error);
            }
        }, 2);
        getMessagesController().markDialogAsRead(j, j2, j2, 0, false, 0L, 0, true, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendNotificationCallback$17(String str) {
        this.waitingForCallback.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendNotificationCallback$18(final String str, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda25
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$sendNotificationCallback$17(str);
            }
        });
    }

    public byte[] isSendingVote(MessageObject messageObject) {
        if (messageObject == null) {
            return null;
        }
        return this.waitingForVote.get("poll_" + messageObject.getPollId());
    }

    public int sendVote(final MessageObject messageObject, ArrayList<TLRPC$TL_pollAnswer> arrayList, final Runnable runnable) {
        byte[] bArr;
        if (messageObject == null) {
            return 0;
        }
        final String str = "poll_" + messageObject.getPollId();
        if (this.waitingForCallback.containsKey(str)) {
            return 0;
        }
        TLRPC$TL_messages_sendVote tLRPC$TL_messages_sendVote = new TLRPC$TL_messages_sendVote();
        tLRPC$TL_messages_sendVote.msg_id = messageObject.getId();
        tLRPC$TL_messages_sendVote.poll_id = messageObject.getPollId();
        tLRPC$TL_messages_sendVote.peer = getMessagesController().getInputPeer((int) messageObject.getDialogId());
        if (arrayList != null) {
            bArr = new byte[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                TLRPC$TL_pollAnswer tLRPC$TL_pollAnswer = arrayList.get(i);
                tLRPC$TL_messages_sendVote.options.add(tLRPC$TL_pollAnswer.option);
                bArr[i] = tLRPC$TL_pollAnswer.option[0];
            }
        } else {
            bArr = new byte[0];
        }
        this.waitingForVote.put(str, bArr);
        return getMessagesProxy().sendVote(tLRPC$TL_messages_sendVote, new RequestDelegate() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda80
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$sendVote$21(messageObject, str, runnable, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendVote$21(MessageObject messageObject, final String str, final Runnable runnable, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            this.voteSendTime.put(messageObject.getPollId(), 0L);
            getMessagesController().processUpdates((TLRPC$Updates) tLObject, false);
            this.voteSendTime.put(messageObject.getPollId(), Long.valueOf(SystemClock.elapsedRealtime()));
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda28
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$sendVote$20(str, runnable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendVote$20(String str, Runnable runnable) {
        this.waitingForVote.remove(str);
        if (runnable != null) {
            runnable.run();
        }
    }

    protected long getVoteSendTime(long j) {
        return this.voteSendTime.get(j, 0L).longValue();
    }

    public void sendReaction(MessageObject messageObject, ArrayList<ReactionsLayoutInBubble.VisibleReaction> arrayList, ReactionsLayoutInBubble.VisibleReaction visibleReaction, boolean z, boolean z2, ChatActivity chatActivity, final Runnable runnable) {
        if (messageObject == null || chatActivity == null) {
            return;
        }
        TLRPC$TL_messages_sendReaction tLRPC$TL_messages_sendReaction = new TLRPC$TL_messages_sendReaction();
        TLRPC$Message tLRPC$Message = messageObject.messageOwner;
        if (tLRPC$Message.isThreadMessage && tLRPC$Message.fwd_from != null) {
            tLRPC$TL_messages_sendReaction.peer = getMessagesController().getInputPeer(messageObject.getFromChatId());
            tLRPC$TL_messages_sendReaction.msg_id = messageObject.messageOwner.fwd_from.saved_from_msg_id;
        } else {
            tLRPC$TL_messages_sendReaction.peer = getMessagesController().getInputPeer((int) messageObject.getDialogId());
            tLRPC$TL_messages_sendReaction.msg_id = messageObject.getId();
        }
        tLRPC$TL_messages_sendReaction.add_to_recent = z2;
        if (z2 && visibleReaction != null) {
            MediaDataController.getInstance(this.currentAccount).recentReactions.add(0, ReactionsUtils.toTLReaction(visibleReaction));
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            for (int i = 0; i < arrayList.size(); i++) {
                ReactionsLayoutInBubble.VisibleReaction visibleReaction2 = arrayList.get(i);
                if (visibleReaction2.documentId != 0) {
                    TLRPC$TL_reactionCustomEmoji tLRPC$TL_reactionCustomEmoji = new TLRPC$TL_reactionCustomEmoji();
                    tLRPC$TL_reactionCustomEmoji.document_id = visibleReaction2.documentId;
                    tLRPC$TL_messages_sendReaction.reaction.add(tLRPC$TL_reactionCustomEmoji);
                    tLRPC$TL_messages_sendReaction.flags |= 1;
                } else if (visibleReaction2.emojicon != null) {
                    TLRPC$TL_reactionEmoji tLRPC$TL_reactionEmoji = new TLRPC$TL_reactionEmoji();
                    tLRPC$TL_reactionEmoji.emoticon = visibleReaction2.emojicon;
                    tLRPC$TL_messages_sendReaction.reaction.add(tLRPC$TL_reactionEmoji);
                    tLRPC$TL_messages_sendReaction.flags |= 1;
                }
            }
        }
        if (z) {
            tLRPC$TL_messages_sendReaction.flags |= 2;
            tLRPC$TL_messages_sendReaction.big = true;
        }
        tLRPC$TL_messages_sendReaction.reactionId = visibleReaction != null ? visibleReaction.reactionId : null;
        getMessagesProxy().sendReaction(tLRPC$TL_messages_sendReaction, new RequestDelegate() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda76
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) throws InterruptedException {
                this.f$0.lambda$sendReaction$22(runnable, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendReaction$22(Runnable runnable, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) throws InterruptedException {
        if (tLObject != null) {
            ArrayList<TLRPC$Update> arrayList = new ArrayList<>();
            arrayList.add((TLRPC$Update) tLObject);
            getMessagesController().processUpdateArray(arrayList, null, null, false, 0);
            if (runnable != null) {
                AndroidUtilities.runOnUIThread(runnable);
            }
        }
    }

    public void requestUrlAuth(final String str, final ChatActivity chatActivity, final boolean z) {
        final TLRPC$TL_messages_requestUrlAuth tLRPC$TL_messages_requestUrlAuth = new TLRPC$TL_messages_requestUrlAuth();
        tLRPC$TL_messages_requestUrlAuth.url = str;
        tLRPC$TL_messages_requestUrlAuth.flags |= 4;
        getConnectionsManager().sendRequest(tLRPC$TL_messages_requestUrlAuth, new RequestDelegate() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda86
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                SendMessagesHelper.lambda$requestUrlAuth$23(chatActivity, tLRPC$TL_messages_requestUrlAuth, str, z, tLObject, tLRPC$TL_error);
            }
        }, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$requestUrlAuth$23(ChatActivity chatActivity, TLRPC$TL_messages_requestUrlAuth tLRPC$TL_messages_requestUrlAuth, String str, boolean z, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            if (tLObject instanceof TLRPC$TL_urlAuthResultRequest) {
                chatActivity.showRequestUrlAlert((TLRPC$TL_urlAuthResultRequest) tLObject, tLRPC$TL_messages_requestUrlAuth, str, z);
                return;
            } else if (tLObject instanceof TLRPC$TL_urlAuthResultAccepted) {
                AlertsCreator.showOpenUrlAlert(chatActivity, ((TLRPC$TL_urlAuthResultAccepted) tLObject).url, false, false);
                return;
            } else {
                if (tLObject instanceof TLRPC$TL_urlAuthResultDefault) {
                    AlertsCreator.showOpenUrlAlert(chatActivity, str, false, z);
                    return;
                }
                return;
            }
        }
        AlertsCreator.showOpenUrlAlert(chatActivity, str, false, z);
    }

    public void sendCallback(boolean z, MessageObject messageObject, TLRPC$KeyboardButton tLRPC$KeyboardButton, ChatActivity chatActivity) throws JSONException {
        lambda$sendCallback$24(z, messageObject, tLRPC$KeyboardButton, null, null, chatActivity);
    }

    /* renamed from: sendCallback, reason: merged with bridge method [inline-methods] */
    public void lambda$sendCallback$24(final boolean z, final MessageObject messageObject, final TLRPC$KeyboardButton tLRPC$KeyboardButton, final TLRPC$InputCheckPasswordSRP tLRPC$InputCheckPasswordSRP, final TwoStepVerificationActivity twoStepVerificationActivity, final ChatActivity chatActivity) throws JSONException {
        int i;
        if (messageObject == null || tLRPC$KeyboardButton == null || chatActivity == null) {
            return;
        }
        boolean z2 = tLRPC$KeyboardButton instanceof TLRPC$TL_keyboardButtonUrlAuth;
        if (z2) {
            i = 3;
        } else if (tLRPC$KeyboardButton instanceof TLRPC$TL_keyboardButtonGame) {
            i = 1;
        } else {
            i = tLRPC$KeyboardButton instanceof TLRPC$TL_keyboardButtonBuy ? 2 : 0;
        }
        final boolean z3 = false;
        final String str = messageObject.getDialogId() + "_" + messageObject.getId() + "_" + Utilities.bytesToHex(tLRPC$KeyboardButton.data) + "_" + i;
        this.waitingForCallback.put(str, Boolean.TRUE);
        final TLObject[] tLObjectArr = new TLObject[1];
        RequestDelegate requestDelegate = new RequestDelegate() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda78
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$sendCallback$30(str, z3, messageObject, tLRPC$KeyboardButton, chatActivity, twoStepVerificationActivity, tLObjectArr, tLRPC$InputCheckPasswordSRP, z, tLObject, tLRPC$TL_error);
            }
        };
        if (z2) {
            TLRPC$TL_messages_requestUrlAuth tLRPC$TL_messages_requestUrlAuth = new TLRPC$TL_messages_requestUrlAuth();
            tLRPC$TL_messages_requestUrlAuth.peer = getMessagesController().getInputPeer((int) messageObject.getDialogId());
            tLRPC$TL_messages_requestUrlAuth.msg_id = messageObject.getId();
            tLRPC$TL_messages_requestUrlAuth.button_id = tLRPC$KeyboardButton.button_id;
            tLRPC$TL_messages_requestUrlAuth.flags |= 2;
            tLObjectArr[0] = tLRPC$TL_messages_requestUrlAuth;
            getConnectionsManager().sendRequest(tLRPC$TL_messages_requestUrlAuth, requestDelegate, 2);
            return;
        }
        if (tLRPC$KeyboardButton instanceof TLRPC$TL_keyboardButtonBuy) {
            if ((messageObject.messageOwner.media.flags & 4) == 0) {
                TLRPC$TL_payments_getPaymentForm tLRPC$TL_payments_getPaymentForm = new TLRPC$TL_payments_getPaymentForm();
                tLRPC$TL_payments_getPaymentForm.msg_id = messageObject.getId();
                tLRPC$TL_payments_getPaymentForm.peer = getMessagesController().getInputPeer(messageObject.messageOwner.peer_id);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("bg_color", Theme.getColor(Theme.key_windowBackgroundWhite));
                    jSONObject.put("text_color", Theme.getColor(Theme.key_windowBackgroundWhiteBlackText));
                    jSONObject.put("hint_color", Theme.getColor(Theme.key_windowBackgroundWhiteHintText));
                    jSONObject.put("link_color", Theme.getColor(Theme.key_windowBackgroundWhiteLinkText));
                    jSONObject.put("button_color", Theme.getColor(Theme.key_featuredStickers_addButton));
                    jSONObject.put("button_text_color", Theme.getColor(Theme.key_featuredStickers_buttonText));
                    TLRPC$TL_dataJSON tLRPC$TL_dataJSON = new TLRPC$TL_dataJSON();
                    tLRPC$TL_payments_getPaymentForm.theme_params = tLRPC$TL_dataJSON;
                    tLRPC$TL_dataJSON.data = jSONObject.toString();
                    tLRPC$TL_payments_getPaymentForm.flags |= 1;
                } catch (Exception e) {
                    FileLog.e(e);
                }
                getConnectionsManager().sendRequest(tLRPC$TL_payments_getPaymentForm, requestDelegate, 2);
                return;
            }
            TLRPC$TL_payments_getPaymentReceipt tLRPC$TL_payments_getPaymentReceipt = new TLRPC$TL_payments_getPaymentReceipt();
            tLRPC$TL_payments_getPaymentReceipt.msg_id = messageObject.messageOwner.media.receipt_msg_id;
            tLRPC$TL_payments_getPaymentReceipt.peer = getMessagesController().getInputPeer(messageObject.messageOwner.peer_id);
            getConnectionsManager().sendRequest(tLRPC$TL_payments_getPaymentReceipt, requestDelegate, 2);
            return;
        }
        TLRPC$TL_messages_getBotCallbackAnswer tLRPC$TL_messages_getBotCallbackAnswer = new TLRPC$TL_messages_getBotCallbackAnswer();
        tLRPC$TL_messages_getBotCallbackAnswer.peer = getMessagesController().getInputPeer((int) messageObject.getDialogId());
        tLRPC$TL_messages_getBotCallbackAnswer.msg_id = messageObject.getId();
        tLRPC$TL_messages_getBotCallbackAnswer.game = tLRPC$KeyboardButton instanceof TLRPC$TL_keyboardButtonGame;
        if (tLRPC$KeyboardButton.requires_password) {
            TLRPC$InputCheckPasswordSRP tLRPC$TL_inputCheckPasswordEmpty = tLRPC$InputCheckPasswordSRP != null ? tLRPC$InputCheckPasswordSRP : new TLRPC$TL_inputCheckPasswordEmpty();
            tLRPC$TL_messages_getBotCallbackAnswer.password = tLRPC$TL_inputCheckPasswordEmpty;
            tLRPC$TL_messages_getBotCallbackAnswer.password = tLRPC$TL_inputCheckPasswordEmpty;
            tLRPC$TL_messages_getBotCallbackAnswer.flags |= 4;
        }
        byte[] bArr = tLRPC$KeyboardButton.data;
        if (bArr != null) {
            tLRPC$TL_messages_getBotCallbackAnswer.flags |= 1;
            tLRPC$TL_messages_getBotCallbackAnswer.data = bArr;
        }
        TLRPC$Message tLRPC$Message = messageObject.messageOwner;
        tLRPC$TL_messages_getBotCallbackAnswer.media = tLRPC$Message.media;
        tLRPC$TL_messages_getBotCallbackAnswer.bot_button_text = tLRPC$Message.bot_button_text;
        getMessagesProxy().sendMessageApiCall(tLRPC$TL_messages_getBotCallbackAnswer, requestDelegate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendCallback$30(final String str, final boolean z, final MessageObject messageObject, final TLRPC$KeyboardButton tLRPC$KeyboardButton, final ChatActivity chatActivity, final TwoStepVerificationActivity twoStepVerificationActivity, final TLObject[] tLObjectArr, final TLRPC$InputCheckPasswordSRP tLRPC$InputCheckPasswordSRP, final boolean z2, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda29
            @Override // java.lang.Runnable
            public final void run() throws JSONException {
                this.f$0.lambda$sendCallback$29(str, z, tLObject, messageObject, tLRPC$KeyboardButton, chatActivity, twoStepVerificationActivity, tLObjectArr, tLRPC$TL_error, tLRPC$InputCheckPasswordSRP, z2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0173  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$sendCallback$29(java.lang.String r28, boolean r29, org.rbmain.tgnet.TLObject r30, final org.rbmain.messenger.MessageObject r31, final org.rbmain.tgnet.TLRPC$KeyboardButton r32, final org.rbmain.ui.ChatActivity r33, final org.rbmain.ui.TwoStepVerificationActivity r34, org.rbmain.tgnet.TLObject[] r35, org.rbmain.tgnet.TLRPC$TL_error r36, org.rbmain.tgnet.TLRPC$InputCheckPasswordSRP r37, final boolean r38) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 1191
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.SendMessagesHelper.lambda$sendCallback$29(java.lang.String, boolean, org.rbmain.tgnet.TLObject, org.rbmain.messenger.MessageObject, org.rbmain.tgnet.TLRPC$KeyboardButton, org.rbmain.ui.ChatActivity, org.rbmain.ui.TwoStepVerificationActivity, org.rbmain.tgnet.TLObject[], org.rbmain.tgnet.TLRPC$TL_error, org.rbmain.tgnet.TLRPC$InputCheckPasswordSRP, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendCallback$25(final boolean z, final MessageObject messageObject, final TLRPC$KeyboardButton tLRPC$KeyboardButton, final ChatActivity chatActivity, DialogInterface dialogInterface, int i) {
        final TwoStepVerificationActivity twoStepVerificationActivity = new TwoStepVerificationActivity();
        twoStepVerificationActivity.setDelegate(new TwoStepVerificationActivity.TwoStepVerificationActivityDelegate() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda87
            @Override // org.rbmain.ui.TwoStepVerificationActivity.TwoStepVerificationActivityDelegate
            public final void didEnterPassword(TLRPC$InputCheckPasswordSRP tLRPC$InputCheckPasswordSRP) throws JSONException {
                this.f$0.lambda$sendCallback$24(z, messageObject, tLRPC$KeyboardButton, twoStepVerificationActivity, chatActivity, tLRPC$InputCheckPasswordSRP);
            }
        });
        chatActivity.presentFragment(twoStepVerificationActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$sendCallback$26(ChatActivity chatActivity, DialogInterface dialogInterface, int i) {
        chatActivity.presentFragment(new TwoStepVerificationSetupActivity(6, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendCallback$28(final TwoStepVerificationActivity twoStepVerificationActivity, final boolean z, final MessageObject messageObject, final TLRPC$KeyboardButton tLRPC$KeyboardButton, final ChatActivity chatActivity, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda53
            @Override // java.lang.Runnable
            public final void run() throws JSONException {
                this.f$0.lambda$sendCallback$27(tLRPC$TL_error, tLObject, twoStepVerificationActivity, z, messageObject, tLRPC$KeyboardButton, chatActivity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendCallback$27(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, TwoStepVerificationActivity twoStepVerificationActivity, boolean z, MessageObject messageObject, TLRPC$KeyboardButton tLRPC$KeyboardButton, ChatActivity chatActivity) throws JSONException {
        if (tLRPC$TL_error == null) {
            TLRPC$TL_account_password tLRPC$TL_account_password = (TLRPC$TL_account_password) tLObject;
            twoStepVerificationActivity.setCurrentPasswordInfo(null, tLRPC$TL_account_password);
            TwoStepVerificationActivity.initPasswordNewAlgo(tLRPC$TL_account_password);
            lambda$sendCallback$24(z, messageObject, tLRPC$KeyboardButton, twoStepVerificationActivity.getNewSrpPassword(), twoStepVerificationActivity, chatActivity);
        }
    }

    public boolean isSendingCallback(MessageObject messageObject, TLRPC$KeyboardButton tLRPC$KeyboardButton) {
        int i = 0;
        if (messageObject == null || tLRPC$KeyboardButton == null) {
            return false;
        }
        if (tLRPC$KeyboardButton instanceof TLRPC$TL_keyboardButtonUrlAuth) {
            i = 3;
        } else if (tLRPC$KeyboardButton instanceof TLRPC$TL_keyboardButtonGame) {
            i = 1;
        } else if (tLRPC$KeyboardButton instanceof TLRPC$TL_keyboardButtonBuy) {
            i = 2;
        }
        return this.waitingForCallback.containsKey(messageObject.getDialogId() + "_" + messageObject.getId() + "_" + Utilities.bytesToHex(tLRPC$KeyboardButton.data) + "_" + i);
    }

    public void sendGame(TLRPC$InputPeer tLRPC$InputPeer, TLRPC$TL_inputMediaGame tLRPC$TL_inputMediaGame, long j, final long j2) {
        NativeByteBuffer nativeByteBuffer;
        if (tLRPC$InputPeer == null || tLRPC$TL_inputMediaGame == null) {
            return;
        }
        TLRPC$TL_messages_sendMedia tLRPC$TL_messages_sendMedia = new TLRPC$TL_messages_sendMedia();
        tLRPC$TL_messages_sendMedia.peer = tLRPC$InputPeer;
        if (tLRPC$InputPeer instanceof TLRPC$TL_inputPeerChannel) {
            tLRPC$TL_messages_sendMedia.silent = MessagesController.getNotificationsSettings(this.currentAccount).getBoolean(NotificationsSettingsFacade.PROPERTY_SILENT + (-tLRPC$InputPeer.channel_id), false);
        } else if (tLRPC$InputPeer instanceof TLRPC$TL_inputPeerChat) {
            tLRPC$TL_messages_sendMedia.silent = MessagesController.getNotificationsSettings(this.currentAccount).getBoolean(NotificationsSettingsFacade.PROPERTY_SILENT + (-tLRPC$InputPeer.chat_id), false);
        } else {
            tLRPC$TL_messages_sendMedia.silent = MessagesController.getNotificationsSettings(this.currentAccount).getBoolean(NotificationsSettingsFacade.PROPERTY_SILENT + tLRPC$InputPeer.user_id, false);
        }
        tLRPC$TL_messages_sendMedia.random_id = j != 0 ? j : getNextRandomId();
        tLRPC$TL_messages_sendMedia.message = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
        tLRPC$TL_messages_sendMedia.media = tLRPC$TL_inputMediaGame;
        if (j2 == 0) {
            NativeByteBuffer nativeByteBuffer2 = null;
            try {
                nativeByteBuffer = new NativeByteBuffer(tLRPC$InputPeer.getObjectSize() + tLRPC$TL_inputMediaGame.getObjectSize() + 4 + 8);
            } catch (Exception e) {
                e = e;
            }
            try {
                nativeByteBuffer.writeInt32(3);
                nativeByteBuffer.writeInt64(j);
                tLRPC$InputPeer.serializeToStream(nativeByteBuffer);
                tLRPC$TL_inputMediaGame.serializeToStream(nativeByteBuffer);
            } catch (Exception e2) {
                e = e2;
                nativeByteBuffer2 = nativeByteBuffer;
                FileLog.e(e);
                nativeByteBuffer = nativeByteBuffer2;
                j2 = getMessagesStorage().createPendingTask(nativeByteBuffer);
                getConnectionsManager().sendRequest(tLRPC$TL_messages_sendMedia, new RequestDelegate() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda74
                    @Override // org.rbmain.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$sendGame$31(j2, tLObject, tLRPC$TL_error);
                    }
                });
            }
            j2 = getMessagesStorage().createPendingTask(nativeByteBuffer);
        }
        getConnectionsManager().sendRequest(tLRPC$TL_messages_sendMedia, new RequestDelegate() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda74
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$sendGame$31(j2, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendGame$31(long j, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            getMessagesController().processUpdates((TLRPC$Updates) tLObject, false);
        }
        if (j != 0) {
            getMessagesStorage().removePendingTask(j);
        }
    }

    public void sendMessage(MessageObject messageObject) {
        long dialogId = messageObject.getDialogId();
        TLRPC$Message tLRPC$Message = messageObject.messageOwner;
        sendMessage(null, null, null, null, null, null, null, null, null, null, dialogId, tLRPC$Message.attachPath, null, null, null, true, messageObject, null, tLRPC$Message.reply_markup, tLRPC$Message.params, !tLRPC$Message.silent, messageObject.scheduled ? tLRPC$Message.date : 0, 0, null, 0, null, null, null, null, null);
    }

    public void sendMessage(TLRPC$User tLRPC$User, long j, MessageObject messageObject, MessageObject messageObject2, TLRPC$ReplyMarkup tLRPC$ReplyMarkup, HashMap<String, String> map, boolean z, int i) {
        sendMessage(null, null, null, null, null, tLRPC$User, null, null, null, null, j, null, messageObject, messageObject2, null, true, null, null, tLRPC$ReplyMarkup, map, z, i, 0, null, 0, null, null, null, null, null);
    }

    public void sendMessage(TLRPC$TL_messageMediaInvoice tLRPC$TL_messageMediaInvoice, long j, MessageObject messageObject, MessageObject messageObject2, TLRPC$ReplyMarkup tLRPC$ReplyMarkup, HashMap<String, String> map, boolean z, int i) {
        sendMessage(null, null, null, null, null, null, null, null, null, tLRPC$TL_messageMediaInvoice, j, null, messageObject, messageObject2, null, true, null, null, tLRPC$ReplyMarkup, map, z, i, 0, null, 0, null, null, null, null, null);
    }

    public void sendMessage(TLRPC$TL_document tLRPC$TL_document, VideoEditedInfo videoEditedInfo, String str, long j, MessageObject messageObject, MessageObject messageObject2, String str2, ArrayList<TLRPC$MessageEntity> arrayList, TLRPC$ReplyMarkup tLRPC$ReplyMarkup, HashMap<String, String> map, boolean z, int i, int i2, Object obj) {
        sendMessage(null, str2, null, null, videoEditedInfo, null, tLRPC$TL_document, null, null, null, j, str, messageObject, messageObject2, null, true, null, arrayList, tLRPC$ReplyMarkup, map, z, i, i2, obj, 0, null, null, null, null, null);
    }

    public void sendMessage(String str, long j, MessageObject messageObject, MessageObject messageObject2, TLRPC$WebPage tLRPC$WebPage, boolean z, ArrayList<TLRPC$MessageEntity> arrayList, TLRPC$ReplyMarkup tLRPC$ReplyMarkup, HashMap<String, String> map, boolean z2, int i) {
        sendMessage(str, null, null, null, null, null, null, null, null, null, j, null, messageObject, messageObject2, tLRPC$WebPage, z, null, arrayList, tLRPC$ReplyMarkup, map, z2, i, 0, null, 0, null, null, null, null, null);
    }

    public void sendMessage(String str, long j, MessageObject messageObject, MessageObject messageObject2, TLRPC$WebPage tLRPC$WebPage, boolean z, ArrayList<TLRPC$MessageEntity> arrayList, TLRPC$ReplyMarkup tLRPC$ReplyMarkup, HashMap<String, String> map, boolean z2, int i, String str2) {
        sendMessage(str, null, null, null, null, null, null, null, null, null, j, null, messageObject, messageObject2, tLRPC$WebPage, z, null, arrayList, tLRPC$ReplyMarkup, map, z2, i, 0, null, 0, null, null, str2, null, null);
    }

    public void sendMessage(String str, int i, long j, MessageObject messageObject, MessageObject messageObject2, TLRPC$WebPage tLRPC$WebPage, boolean z, ArrayList<TLRPC$MessageEntity> arrayList, TLRPC$ReplyMarkup tLRPC$ReplyMarkup, HashMap<String, String> map, boolean z2, int i2) {
        sendMessage(str, null, null, null, null, null, null, null, null, null, j, null, messageObject, messageObject2, tLRPC$WebPage, z, null, arrayList, tLRPC$ReplyMarkup, map, z2, i2, 0, null, i, null, null, null, null, null);
    }

    public void sendMessage(TLRPC$TL_messageMediaRubinoPost tLRPC$TL_messageMediaRubinoPost, long j, MessageObject messageObject, MessageObject messageObject2, TLRPC$WebPage tLRPC$WebPage, boolean z, ArrayList<TLRPC$MessageEntity> arrayList, TLRPC$ReplyMarkup tLRPC$ReplyMarkup, HashMap<String, String> map, boolean z2, int i) {
        sendMessage(null, null, null, null, null, null, null, null, null, null, j, null, messageObject, messageObject2, tLRPC$WebPage, z, null, arrayList, tLRPC$ReplyMarkup, map, z2, i, 0, null, 0, tLRPC$TL_messageMediaRubinoPost, null, null, null, null);
    }

    public void sendMessage(TLRPC$TL_messageMediaRubinoStory tLRPC$TL_messageMediaRubinoStory, long j, MessageObject messageObject, MessageObject messageObject2, TLRPC$WebPage tLRPC$WebPage, boolean z, ArrayList<TLRPC$MessageEntity> arrayList, TLRPC$ReplyMarkup tLRPC$ReplyMarkup, HashMap<String, String> map, boolean z2, int i) {
        sendMessage(null, null, null, null, null, null, null, null, null, null, j, null, messageObject, messageObject2, tLRPC$WebPage, z, null, arrayList, tLRPC$ReplyMarkup, map, z2, i, 0, null, 0, null, tLRPC$TL_messageMediaRubinoStory, null, null, null);
    }

    public void sendMessage(TLRPC$TL_messageMediaRubinoProduct tLRPC$TL_messageMediaRubinoProduct, long j, MessageObject messageObject, MessageObject messageObject2, TLRPC$WebPage tLRPC$WebPage, boolean z, ArrayList<TLRPC$MessageEntity> arrayList, TLRPC$ReplyMarkup tLRPC$ReplyMarkup, HashMap<String, String> map, boolean z2, int i) {
        sendMessage(null, null, null, null, null, null, null, null, null, null, j, null, messageObject, messageObject2, tLRPC$WebPage, z, null, arrayList, tLRPC$ReplyMarkup, map, z2, i, 0, null, 0, null, null, null, tLRPC$TL_messageMediaRubinoProduct, null);
    }

    public void sendMessage(TLRPC$TL_messageMediaWallet tLRPC$TL_messageMediaWallet, long j, MessageObject messageObject, MessageObject messageObject2, TLRPC$WebPage tLRPC$WebPage, boolean z, ArrayList<TLRPC$MessageEntity> arrayList, TLRPC$ReplyMarkup tLRPC$ReplyMarkup, HashMap<String, String> map, boolean z2, int i) {
        sendMessage(null, null, null, null, null, null, null, null, null, null, j, null, messageObject, messageObject2, tLRPC$WebPage, z, null, arrayList, tLRPC$ReplyMarkup, map, z2, i, 0, null, 0, null, null, null, null, tLRPC$TL_messageMediaWallet);
    }

    public void sendMessage(TLRPC$MessageMedia tLRPC$MessageMedia, long j, MessageObject messageObject, MessageObject messageObject2, TLRPC$ReplyMarkup tLRPC$ReplyMarkup, HashMap<String, String> map, boolean z, int i) {
        sendMessage(null, null, tLRPC$MessageMedia, null, null, null, null, null, null, null, j, null, messageObject, messageObject2, null, true, null, null, tLRPC$ReplyMarkup, map, z, i, 0, null, 0, null, null, null, null, null);
    }

    public void sendMessage(TLRPC$TL_messageMediaPoll tLRPC$TL_messageMediaPoll, long j, MessageObject messageObject, MessageObject messageObject2, TLRPC$ReplyMarkup tLRPC$ReplyMarkup, HashMap<String, String> map, boolean z, int i) {
        sendMessage(null, null, null, null, null, null, null, null, tLRPC$TL_messageMediaPoll, null, j, null, messageObject, messageObject2, null, true, null, null, tLRPC$ReplyMarkup, map, z, i, 0, null, 0, null, null, null, null, null);
    }

    public void sendMessage(TLRPC$TL_game tLRPC$TL_game, long j, TLRPC$ReplyMarkup tLRPC$ReplyMarkup, HashMap<String, String> map, boolean z, int i) {
        sendMessage(null, null, null, null, null, null, null, tLRPC$TL_game, null, null, j, null, null, null, null, true, null, null, tLRPC$ReplyMarkup, map, z, i, 0, null, 0, null, null, null, null, null);
    }

    public void sendMessage(TLRPC$TL_photo tLRPC$TL_photo, String str, long j, MessageObject messageObject, MessageObject messageObject2, String str2, ArrayList<TLRPC$MessageEntity> arrayList, TLRPC$ReplyMarkup tLRPC$ReplyMarkup, HashMap<String, String> map, boolean z, int i, int i2, Object obj) {
        sendMessage(null, str2, null, tLRPC$TL_photo, null, null, null, null, null, null, j, str, messageObject, messageObject2, null, true, null, arrayList, tLRPC$ReplyMarkup, map, z, i, i2, obj, 0, null, null, null, null, null);
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    private void sendMessage(java.lang.String r44, java.lang.String r45, org.rbmain.tgnet.TLRPC$MessageMedia r46, org.rbmain.tgnet.TLRPC$TL_photo r47, org.rbmain.messenger.VideoEditedInfo r48, org.rbmain.tgnet.TLRPC$User r49, org.rbmain.tgnet.TLRPC$TL_document r50, org.rbmain.tgnet.TLRPC$TL_game r51, org.rbmain.tgnet.TLRPC$TL_messageMediaPoll r52, org.rbmain.tgnet.TLRPC$TL_messageMediaInvoice r53, long r54, java.lang.String r56, org.rbmain.messenger.MessageObject r57, org.rbmain.messenger.MessageObject r58, org.rbmain.tgnet.TLRPC$WebPage r59, boolean r60, org.rbmain.messenger.MessageObject r61, java.util.ArrayList<org.rbmain.tgnet.TLRPC$MessageEntity> r62, org.rbmain.tgnet.TLRPC$ReplyMarkup r63, java.util.HashMap<java.lang.String, java.lang.String> r64, boolean r65, int r66, int r67, java.lang.Object r68, int r69, org.rbmain.tgnet.TLRPC$TL_messageMediaRubinoPost r70, org.rbmain.tgnet.TLRPC$TL_messageMediaRubinoStory r71, java.lang.String r72, org.rbmain.tgnet.TLRPC$TL_messageMediaRubinoProduct r73, org.rbmain.tgnet.TLRPC$TL_messageMediaWallet r74) {
        /*
            Method dump skipped, instructions count: 6951
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.SendMessagesHelper.sendMessage(java.lang.String, java.lang.String, org.rbmain.tgnet.TLRPC$MessageMedia, org.rbmain.tgnet.TLRPC$TL_photo, org.rbmain.messenger.VideoEditedInfo, org.rbmain.tgnet.TLRPC$User, org.rbmain.tgnet.TLRPC$TL_document, org.rbmain.tgnet.TLRPC$TL_game, org.rbmain.tgnet.TLRPC$TL_messageMediaPoll, org.rbmain.tgnet.TLRPC$TL_messageMediaInvoice, long, java.lang.String, org.rbmain.messenger.MessageObject, org.rbmain.messenger.MessageObject, org.rbmain.tgnet.TLRPC$WebPage, boolean, org.rbmain.messenger.MessageObject, java.util.ArrayList, org.rbmain.tgnet.TLRPC$ReplyMarkup, java.util.HashMap, boolean, int, int, java.lang.Object, int, org.rbmain.tgnet.TLRPC$TL_messageMediaRubinoPost, org.rbmain.tgnet.TLRPC$TL_messageMediaRubinoStory, java.lang.String, org.rbmain.tgnet.TLRPC$TL_messageMediaRubinoProduct, org.rbmain.tgnet.TLRPC$TL_messageMediaWallet):void");
    }

    private void performSendDelayedMessage(DelayedMessage delayedMessage) {
        performSendDelayedMessage(delayedMessage, -1);
    }

    private TLRPC$PhotoSize getThumbForSecretChat(ArrayList<TLRPC$PhotoSize> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                TLRPC$PhotoSize tLRPC$PhotoSize = arrayList.get(i);
                if (tLRPC$PhotoSize != null && !(tLRPC$PhotoSize instanceof TLRPC$TL_photoStrippedSize) && !(tLRPC$PhotoSize instanceof TLRPC$TL_photoPathSize) && !(tLRPC$PhotoSize instanceof TLRPC$TL_photoSizeEmpty) && tLRPC$PhotoSize.location != null) {
                    TLRPC$TL_photoSize tLRPC$TL_photoSize = new TLRPC$TL_photoSize();
                    tLRPC$TL_photoSize.type = tLRPC$PhotoSize.type;
                    tLRPC$TL_photoSize.w = tLRPC$PhotoSize.w;
                    tLRPC$TL_photoSize.h = tLRPC$PhotoSize.h;
                    tLRPC$TL_photoSize.size = tLRPC$PhotoSize.size;
                    byte[] bArr = tLRPC$PhotoSize.bytes;
                    tLRPC$TL_photoSize.bytes = bArr;
                    if (bArr == null) {
                        tLRPC$TL_photoSize.bytes = new byte[0];
                    }
                    TLRPC$TL_fileLocation_layer82 tLRPC$TL_fileLocation_layer82 = new TLRPC$TL_fileLocation_layer82();
                    tLRPC$TL_photoSize.location = tLRPC$TL_fileLocation_layer82;
                    TLRPC$FileLocation tLRPC$FileLocation = tLRPC$PhotoSize.location;
                    tLRPC$TL_fileLocation_layer82.dc_id = tLRPC$FileLocation.dc_id;
                    tLRPC$TL_fileLocation_layer82.volume_id = tLRPC$FileLocation.volume_id;
                    tLRPC$TL_fileLocation_layer82.local_id = tLRPC$FileLocation.local_id;
                    tLRPC$TL_fileLocation_layer82.secret = tLRPC$FileLocation.secret;
                    return tLRPC$TL_photoSize;
                }
            }
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r3v33, types: [org.rbmain.messenger.VideoEditedInfo, org.rbmain.tgnet.TLRPC$PhotoSize] */
    /* JADX WARN: Type inference failed for: r3v38 */
    private void performSendDelayedMessage(final DelayedMessage delayedMessage, int i) {
        TLRPC$InputEncryptedFile tLRPC$InputEncryptedFile;
        String str;
        ?? r3;
        TLRPC$InputMedia tLRPC$InputMedia;
        TLRPC$InputMedia tLRPC$InputMedia2;
        TLRPC$InputMedia tLRPC$InputMedia3;
        int i2 = delayedMessage.type;
        if (i2 == 0) {
            String str2 = delayedMessage.httpLocation;
            if (str2 != null) {
                putToDelayedMessages(str2, delayedMessage);
                ImageLoader.getInstance().loadHttpFile(delayedMessage.httpLocation, "file", this.currentAccount);
                return;
            }
            if (delayedMessage.sendRequest != null) {
                String string = FileLoader.getPathToAttach(delayedMessage.photoSize).toString();
                putToDelayedMessages(string, delayedMessage);
                getFileLoader().uploadFile(string, false, true, ConnectionsManager.FileTypePhoto, delayedMessage.fileName);
                putToUploadingMessages(delayedMessage.obj);
                return;
            }
            String string2 = FileLoader.getPathToAttach(delayedMessage.photoSize).toString();
            if (delayedMessage.sendEncryptedRequest != null && delayedMessage.photoSize.location.dc_id != 0) {
                File file = new File(string2);
                if (!file.exists()) {
                    string2 = FileLoader.getPathToAttach(delayedMessage.photoSize, true).toString();
                    file = new File(string2);
                }
                if (!file.exists()) {
                    putToDelayedMessages(FileLoader.getAttachFileName(delayedMessage.photoSize), delayedMessage);
                    getFileLoader().loadFile(ImageLocation.getForObject(delayedMessage.photoSize, delayedMessage.locationParent), delayedMessage.parentObject, "jpg", 2, 0);
                    return;
                }
            }
            String str3 = string2;
            putToDelayedMessages(str3, delayedMessage);
            getFileLoader().uploadFile(str3, true, true, ConnectionsManager.FileTypePhoto, delayedMessage.fileName);
            putToUploadingMessages(delayedMessage.obj);
            return;
        }
        if (i2 == 1) {
            VideoEditedInfo videoEditedInfo = delayedMessage.videoEditedInfo;
            if (videoEditedInfo != null && videoEditedInfo.needConvert()) {
                MessageObject messageObject = delayedMessage.obj;
                String str4 = messageObject.messageOwner.attachPath;
                TLRPC$Document document = messageObject.getDocument();
                if (str4 == null) {
                    str4 = FileLoader.getDirectory(4) + "/" + document.id + ".mp4";
                }
                putToDelayedMessages(str4, delayedMessage);
                MediaController.getInstance().scheduleVideoConvert(delayedMessage.obj);
                putToUploadingMessages(delayedMessage.obj);
                return;
            }
            VideoEditedInfo videoEditedInfo2 = delayedMessage.videoEditedInfo;
            if (videoEditedInfo2 != null) {
                TLRPC$InputFile tLRPC$InputFile = videoEditedInfo2.file;
                if (tLRPC$InputFile != null) {
                    TLObject tLObject = delayedMessage.sendRequest;
                    if (tLObject instanceof TLRPC$TL_messages_sendMedia) {
                        tLRPC$InputMedia3 = ((TLRPC$TL_messages_sendMedia) tLObject).media;
                    } else {
                        tLRPC$InputMedia3 = ((TLRPC$TL_messages_editMessage) tLObject).media;
                    }
                    tLRPC$InputMedia3.file = tLRPC$InputFile;
                    videoEditedInfo2.file = null;
                } else if (videoEditedInfo2.encryptedFile != null) {
                    TLRPC$TL_decryptedMessage tLRPC$TL_decryptedMessage = (TLRPC$TL_decryptedMessage) delayedMessage.sendEncryptedRequest;
                    TLRPC$DecryptedMessageMedia tLRPC$DecryptedMessageMedia = tLRPC$TL_decryptedMessage.media;
                    tLRPC$DecryptedMessageMedia.size = (int) videoEditedInfo2.estimatedSize;
                    tLRPC$DecryptedMessageMedia.key = videoEditedInfo2.key;
                    tLRPC$DecryptedMessageMedia.iv = videoEditedInfo2.iv;
                    SecretChatHelper secretChatHelper = getSecretChatHelper();
                    MessageObject messageObject2 = delayedMessage.obj;
                    secretChatHelper.performSendEncryptedRequest(tLRPC$TL_decryptedMessage, messageObject2.messageOwner, delayedMessage.encryptedChat, delayedMessage.videoEditedInfo.encryptedFile, delayedMessage.originalPath, messageObject2);
                    delayedMessage.videoEditedInfo.encryptedFile = null;
                    return;
                }
            }
            TLObject tLObject2 = delayedMessage.sendRequest;
            if (tLObject2 != null) {
                if (tLObject2 instanceof TLRPC$TL_messages_sendMedia) {
                    tLRPC$InputMedia2 = ((TLRPC$TL_messages_sendMedia) tLObject2).media;
                } else {
                    tLRPC$InputMedia2 = ((TLRPC$TL_messages_editMessage) tLObject2).media;
                }
                if (tLRPC$InputMedia2.file == null) {
                    MessageObject messageObject3 = delayedMessage.obj;
                    String str5 = messageObject3.messageOwner.attachPath;
                    TLRPC$Document document2 = messageObject3.getDocument();
                    if (str5 == null) {
                        str5 = FileLoader.getDirectory(4) + "/" + document2.id + ".mp4";
                    }
                    String str6 = str5;
                    putToDelayedMessages(str6, delayedMessage);
                    VideoEditedInfo videoEditedInfo3 = delayedMessage.obj.videoEditedInfo;
                    if (videoEditedInfo3 != null && videoEditedInfo3.needConvert()) {
                        getFileLoader().uploadFile(str6, false, false, document2.size, ConnectionsManager.FileTypeVideo, false, delayedMessage.fileName);
                    } else {
                        getFileLoader().uploadFile(str6, false, false, ConnectionsManager.FileTypeVideo, null);
                    }
                    putToUploadingMessages(delayedMessage.obj);
                    return;
                }
                String str7 = FileLoader.getDirectory(4) + "/" + delayedMessage.photoSize.location.volume_id + "_" + delayedMessage.photoSize.location.local_id + ".jpg";
                putToDelayedMessages(str7, delayedMessage);
                getFileLoader().uploadFile(str7, false, true, ConnectionsManager.FileTypePhoto, delayedMessage.fileName);
                putToUploadingMessages(delayedMessage.obj);
                return;
            }
            MessageObject messageObject4 = delayedMessage.obj;
            String str8 = messageObject4.messageOwner.attachPath;
            TLRPC$Document document3 = messageObject4.getDocument();
            if (str8 == null) {
                str8 = FileLoader.getDirectory(4) + "/" + document3.id + ".mp4";
            }
            String str9 = str8;
            if (delayedMessage.sendEncryptedRequest != null && document3.dc_id != 0 && !new File(str9).exists()) {
                putToDelayedMessages(FileLoader.getAttachFileName(document3), delayedMessage);
                getFileLoader().loadFile(document3, delayedMessage.parentObject, 2, 0);
                return;
            }
            putToDelayedMessages(str9, delayedMessage);
            VideoEditedInfo videoEditedInfo4 = delayedMessage.obj.videoEditedInfo;
            if (videoEditedInfo4 != null && videoEditedInfo4.needConvert()) {
                getFileLoader().uploadFile(str9, true, false, document3.size, ConnectionsManager.FileTypeVideo, false, null);
            } else {
                getFileLoader().uploadFile(str9, true, false, ConnectionsManager.FileTypeVideo, null);
            }
            putToUploadingMessages(delayedMessage.obj);
            return;
        }
        if (i2 == 2) {
            String str10 = delayedMessage.httpLocation;
            if (str10 != null) {
                putToDelayedMessages(str10, delayedMessage);
                ImageLoader.getInstance().loadHttpFile(delayedMessage.httpLocation, "gif", this.currentAccount);
                return;
            }
            TLObject tLObject3 = delayedMessage.sendRequest;
            if (tLObject3 != null) {
                if (tLObject3 instanceof TLRPC$TL_messages_sendMedia) {
                    tLRPC$InputMedia = ((TLRPC$TL_messages_sendMedia) tLObject3).media;
                } else {
                    tLRPC$InputMedia = ((TLRPC$TL_messages_editMessage) tLObject3).media;
                }
                if (tLRPC$InputMedia.file == null) {
                    String str11 = delayedMessage.obj.messageOwner.attachPath;
                    putToDelayedMessages(str11, delayedMessage);
                    getFileLoader().uploadFile(str11, delayedMessage.sendRequest == null, false, ConnectionsManager.FileTypeFile, MessageConverter.getMusicFileName(delayedMessage.obj.messageOwner));
                    putToUploadingMessages(delayedMessage.obj);
                    return;
                }
                if (tLRPC$InputMedia.thumb != null || delayedMessage.photoSize == null) {
                    return;
                }
                String str12 = FileLoader.getDirectory(4) + "/" + delayedMessage.photoSize.location.volume_id + "_" + delayedMessage.photoSize.location.local_id + ".jpg";
                putToDelayedMessages(str12, delayedMessage);
                getFileLoader().uploadFile(str12, false, true, ConnectionsManager.FileTypePhoto, delayedMessage.fileName);
                putToUploadingMessages(delayedMessage.obj);
                return;
            }
            MessageObject messageObject5 = delayedMessage.obj;
            String str13 = messageObject5.messageOwner.attachPath;
            TLRPC$Document document4 = messageObject5.getDocument();
            if (delayedMessage.sendEncryptedRequest != null && document4.dc_id != 0 && !new File(str13).exists()) {
                putToDelayedMessages(FileLoader.getAttachFileName(document4), delayedMessage);
                getFileLoader().loadFile(document4, delayedMessage.parentObject, 2, 0);
                return;
            } else {
                putToDelayedMessages(str13, delayedMessage);
                getFileLoader().uploadFile(str13, true, false, ConnectionsManager.FileTypeFile, null);
                putToUploadingMessages(delayedMessage.obj);
                return;
            }
        }
        if (i2 == 3) {
            String str14 = delayedMessage.obj.messageOwner.attachPath;
            putToDelayedMessages(str14, delayedMessage);
            getFileLoader().uploadFile(str14, delayedMessage.sendRequest == null, true, ConnectionsManager.FileTypeAudio, null);
            putToUploadingMessages(delayedMessage.obj);
            return;
        }
        if (i2 != 4) {
            if (i2 == 5) {
                final String str15 = "stickerset_" + delayedMessage.obj.getId();
                TLRPC$TL_messages_getStickerSet tLRPC$TL_messages_getStickerSet = new TLRPC$TL_messages_getStickerSet();
                tLRPC$TL_messages_getStickerSet.stickerset = (TLRPC$InputStickerSet) delayedMessage.parentObject;
                getConnectionsManager().sendRequest(tLRPC$TL_messages_getStickerSet, new RequestDelegate() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda81
                    @Override // org.rbmain.tgnet.RequestDelegate
                    public final void run(TLObject tLObject4, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$performSendDelayedMessage$33(delayedMessage, str15, tLObject4, tLRPC$TL_error);
                    }
                });
                putToDelayedMessages(str15, delayedMessage);
                return;
            }
            return;
        }
        boolean z = i < 0;
        if (delayedMessage.performMediaUpload) {
            int size = i < 0 ? delayedMessage.messageObjects.size() - 1 : i;
            MessageObject messageObject6 = delayedMessage.messageObjects.get(size);
            if (messageObject6.getDocument() != null) {
                if (delayedMessage.videoEditedInfo != null) {
                    String str16 = messageObject6.messageOwner.attachPath;
                    TLRPC$Document document5 = messageObject6.getDocument();
                    if (str16 == null) {
                        str16 = FileLoader.getDirectory(4) + "/" + document5.id + ".mp4";
                    }
                    putToDelayedMessages(str16, delayedMessage);
                    delayedMessage.extraHashMap.put(messageObject6, str16);
                    delayedMessage.extraHashMap.put(str16 + "_i", messageObject6);
                    TLRPC$PhotoSize tLRPC$PhotoSize = delayedMessage.photoSize;
                    if (tLRPC$PhotoSize != null && tLRPC$PhotoSize.location != null) {
                        delayedMessage.extraHashMap.put(str16 + "_t", delayedMessage.photoSize);
                    }
                    MediaController.getInstance().scheduleVideoConvert(messageObject6);
                    delayedMessage.obj = messageObject6;
                    putToUploadingMessages(messageObject6);
                    r3 = 0;
                } else {
                    TLRPC$Document document6 = messageObject6.getDocument();
                    String string3 = messageObject6.messageOwner.attachPath;
                    if (string3 == null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(FileLoader.getDirectory(4));
                        sb.append("/");
                        str = "/";
                        sb.append(document6.id);
                        sb.append(".mp4");
                        string3 = sb.toString();
                    } else {
                        str = "/";
                    }
                    TLObject tLObject4 = delayedMessage.sendRequest;
                    if (tLObject4 != null) {
                        TLRPC$InputMedia tLRPC$InputMedia4 = ((TLRPC$TL_messages_sendMultiMedia) tLObject4).multi_media.get(size).media;
                        if (tLRPC$InputMedia4.file == null) {
                            putToDelayedMessages(string3, delayedMessage);
                            delayedMessage.extraHashMap.put(messageObject6, string3);
                            delayedMessage.extraHashMap.put(string3, tLRPC$InputMedia4);
                            delayedMessage.extraHashMap.put(string3 + "_i", messageObject6);
                            TLRPC$PhotoSize tLRPC$PhotoSize2 = delayedMessage.photoSize;
                            if (tLRPC$PhotoSize2 != null && tLRPC$PhotoSize2.location != null) {
                                delayedMessage.extraHashMap.put(string3 + "_t", delayedMessage.photoSize);
                            }
                            VideoEditedInfo videoEditedInfo5 = messageObject6.videoEditedInfo;
                            if (videoEditedInfo5 != null && videoEditedInfo5.needConvert()) {
                                getFileLoader().uploadFile(string3, false, false, document6.size, ConnectionsManager.FileTypeVideo, false, null);
                            } else {
                                getFileLoader().uploadFile(string3, false, false, ConnectionsManager.FileTypeVideo, null);
                            }
                            putToUploadingMessages(messageObject6);
                        } else if (delayedMessage.photoSize != null) {
                            String str17 = FileLoader.getDirectory(4) + str + delayedMessage.photoSize.location.volume_id + "_" + delayedMessage.photoSize.location.local_id + ".jpg";
                            putToDelayedMessages(str17, delayedMessage);
                            delayedMessage.extraHashMap.put(str17 + "_o", string3);
                            delayedMessage.extraHashMap.put(messageObject6, str17);
                            delayedMessage.extraHashMap.put(str17, tLRPC$InputMedia4);
                            getFileLoader().uploadFile(str17, false, true, ConnectionsManager.FileTypePhoto, delayedMessage.fileName);
                            putToUploadingMessages(messageObject6);
                        }
                    } else {
                        TLRPC$TL_messages_sendEncryptedMultiMedia tLRPC$TL_messages_sendEncryptedMultiMedia = (TLRPC$TL_messages_sendEncryptedMultiMedia) delayedMessage.sendEncryptedRequest;
                        putToDelayedMessages(string3, delayedMessage);
                        delayedMessage.extraHashMap.put(messageObject6, string3);
                        delayedMessage.extraHashMap.put(string3, tLRPC$TL_messages_sendEncryptedMultiMedia.files.get(size));
                        delayedMessage.extraHashMap.put(string3 + "_i", messageObject6);
                        TLRPC$PhotoSize tLRPC$PhotoSize3 = delayedMessage.photoSize;
                        if (tLRPC$PhotoSize3 != null && tLRPC$PhotoSize3.location != null) {
                            delayedMessage.extraHashMap.put(string3 + "_t", delayedMessage.photoSize);
                        }
                        VideoEditedInfo videoEditedInfo6 = messageObject6.videoEditedInfo;
                        if (videoEditedInfo6 != null && videoEditedInfo6.needConvert()) {
                            getFileLoader().uploadFile(string3, true, false, document6.size, ConnectionsManager.FileTypeVideo, false, null);
                        } else {
                            getFileLoader().uploadFile(string3, true, false, ConnectionsManager.FileTypeVideo, null);
                        }
                        putToUploadingMessages(messageObject6);
                    }
                    r3 = 0;
                }
                delayedMessage.videoEditedInfo = r3;
                delayedMessage.photoSize = r3;
            } else {
                String str18 = delayedMessage.httpLocation;
                if (str18 != null) {
                    putToDelayedMessages(str18, delayedMessage);
                    delayedMessage.extraHashMap.put(messageObject6, delayedMessage.httpLocation);
                    delayedMessage.extraHashMap.put(delayedMessage.httpLocation, messageObject6);
                    ImageLoader.getInstance().loadHttpFile(delayedMessage.httpLocation, "file", this.currentAccount);
                    delayedMessage.httpLocation = null;
                } else {
                    TLObject tLObject5 = delayedMessage.sendRequest;
                    if (tLObject5 != null) {
                        tLRPC$InputEncryptedFile = ((TLRPC$TL_messages_sendMultiMedia) tLObject5).multi_media.get(size).media;
                    } else {
                        tLRPC$InputEncryptedFile = ((TLRPC$TL_messages_sendEncryptedMultiMedia) delayedMessage.sendEncryptedRequest).files.get(size);
                    }
                    String string4 = FileLoader.getPathToAttach(delayedMessage.photoSize).toString();
                    putToDelayedMessages(string4, delayedMessage);
                    delayedMessage.extraHashMap.put(string4, tLRPC$InputEncryptedFile);
                    delayedMessage.extraHashMap.put(messageObject6, string4);
                    getFileLoader().uploadFile(string4, delayedMessage.sendEncryptedRequest != null, true, ConnectionsManager.FileTypePhoto, delayedMessage.fileName);
                    putToUploadingMessages(messageObject6);
                    delayedMessage.photoSize = null;
                }
            }
            delayedMessage.performMediaUpload = false;
        } else if (!delayedMessage.messageObjects.isEmpty()) {
            ArrayList<MessageObject> arrayList = delayedMessage.messageObjects;
            putToSendingMessages(arrayList.get(arrayList.size() - 1).messageOwner, delayedMessage.finalGroupMessage != 0);
        }
        sendReadyToSendGroup(delayedMessage, z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$performSendDelayedMessage$33(final DelayedMessage delayedMessage, final String str, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda39
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$performSendDelayedMessage$32(tLObject, delayedMessage, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$performSendDelayedMessage$32(TLObject tLObject, DelayedMessage delayedMessage, String str) {
        boolean z;
        if (tLObject != null) {
            TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet = (TLRPC$TL_messages_stickerSet) tLObject;
            getMediaDataController().storeTempStickerSet(tLRPC$TL_messages_stickerSet);
            TLRPC$TL_documentAttributeSticker_layer55 tLRPC$TL_documentAttributeSticker_layer55 = (TLRPC$TL_documentAttributeSticker_layer55) delayedMessage.locationParent;
            TLRPC$TL_inputStickerSetShortName tLRPC$TL_inputStickerSetShortName = new TLRPC$TL_inputStickerSetShortName();
            tLRPC$TL_documentAttributeSticker_layer55.stickerset = tLRPC$TL_inputStickerSetShortName;
            tLRPC$TL_inputStickerSetShortName.short_name = tLRPC$TL_messages_stickerSet.set.short_name;
            z = true;
        } else {
            z = false;
        }
        ArrayList<DelayedMessage> arrayListRemove = this.delayedMessages.remove(str);
        if (arrayListRemove == null || arrayListRemove.isEmpty()) {
            return;
        }
        if (z) {
            getMessagesStorage().replaceMessageIfExists(arrayListRemove.get(0).obj.messageOwner, null, null, false);
        }
        SecretChatHelper secretChatHelper = getSecretChatHelper();
        TLRPC$DecryptedMessage tLRPC$DecryptedMessage = (TLRPC$DecryptedMessage) delayedMessage.sendEncryptedRequest;
        MessageObject messageObject = delayedMessage.obj;
        secretChatHelper.performSendEncryptedRequest(tLRPC$DecryptedMessage, messageObject.messageOwner, delayedMessage.encryptedChat, null, null, messageObject);
    }

    private void uploadMultiMedia(final DelayedMessage delayedMessage, final TLRPC$InputMedia tLRPC$InputMedia, TLRPC$InputEncryptedFile tLRPC$InputEncryptedFile, String str) {
        if (tLRPC$InputMedia == null) {
            if (tLRPC$InputEncryptedFile != null) {
                TLRPC$TL_messages_sendEncryptedMultiMedia tLRPC$TL_messages_sendEncryptedMultiMedia = (TLRPC$TL_messages_sendEncryptedMultiMedia) delayedMessage.sendEncryptedRequest;
                int i = 0;
                while (true) {
                    if (i >= tLRPC$TL_messages_sendEncryptedMultiMedia.files.size()) {
                        break;
                    }
                    if (tLRPC$TL_messages_sendEncryptedMultiMedia.files.get(i) == tLRPC$InputEncryptedFile) {
                        putToSendingMessages(delayedMessage.messages.get(i), delayedMessage.scheduled);
                        getNotificationCenter().postNotificationName(NotificationCenter.FileUploadProgressChanged, str, -1L, -1L, Boolean.FALSE);
                        break;
                    }
                    i++;
                }
                sendReadyToSendGroup(delayedMessage, false, true);
                return;
            }
            return;
        }
        TLRPC$TL_messages_sendMultiMedia tLRPC$TL_messages_sendMultiMedia = (TLRPC$TL_messages_sendMultiMedia) delayedMessage.sendRequest;
        int i2 = 0;
        while (true) {
            if (i2 >= tLRPC$TL_messages_sendMultiMedia.multi_media.size()) {
                break;
            }
            if (tLRPC$TL_messages_sendMultiMedia.multi_media.get(i2).media == tLRPC$InputMedia) {
                putToSendingMessages(delayedMessage.messages.get(i2), delayedMessage.scheduled);
                getNotificationCenter().postNotificationName(NotificationCenter.FileUploadProgressChanged, str, -1L, -1L, Boolean.FALSE);
                break;
            }
            i2++;
        }
        TLRPC$TL_messages_uploadMedia tLRPC$TL_messages_uploadMedia = new TLRPC$TL_messages_uploadMedia();
        tLRPC$TL_messages_uploadMedia.media = tLRPC$InputMedia;
        tLRPC$TL_messages_uploadMedia.peer = ((TLRPC$TL_messages_sendMultiMedia) delayedMessage.sendRequest).peer;
        getConnectionsManager().sendRequest(tLRPC$TL_messages_uploadMedia, new RequestDelegate() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda83
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$uploadMultiMedia$35(tLRPC$InputMedia, delayedMessage, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$uploadMultiMedia$35(final TLRPC$InputMedia tLRPC$InputMedia, final DelayedMessage delayedMessage, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda40
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$uploadMultiMedia$34(tLObject, tLRPC$InputMedia, delayedMessage);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$uploadMultiMedia$34(org.rbmain.tgnet.TLObject r6, org.rbmain.tgnet.TLRPC$InputMedia r7, org.rbmain.messenger.SendMessagesHelper.DelayedMessage r8) {
        /*
            r5 = this;
            if (r6 == 0) goto L4a
            org.rbmain.tgnet.TLRPC$MessageMedia r6 = (org.rbmain.tgnet.TLRPC$MessageMedia) r6
            boolean r0 = r7 instanceof org.rbmain.tgnet.TLRPC$TL_inputMediaUploadedPhoto
            if (r0 == 0) goto L27
            boolean r0 = r6 instanceof org.rbmain.tgnet.TLRPC$TL_messageMediaPhoto
            if (r0 == 0) goto L27
            org.rbmain.tgnet.TLRPC$TL_inputMediaPhoto r0 = new org.rbmain.tgnet.TLRPC$TL_inputMediaPhoto
            r0.<init>()
            org.rbmain.tgnet.TLRPC$TL_inputPhoto r1 = new org.rbmain.tgnet.TLRPC$TL_inputPhoto
            r1.<init>()
            r0.id = r1
            org.rbmain.tgnet.TLRPC$Photo r6 = r6.photo
            long r2 = r6.id
            r1.id = r2
            long r2 = r6.access_hash
            r1.access_hash = r2
            byte[] r6 = r6.file_reference
            r1.file_reference = r6
            goto L4b
        L27:
            boolean r0 = r7 instanceof org.rbmain.tgnet.TLRPC$TL_inputMediaUploadedDocument
            if (r0 == 0) goto L4a
            boolean r0 = r6 instanceof org.rbmain.tgnet.TLRPC$TL_messageMediaDocument
            if (r0 == 0) goto L4a
            org.rbmain.tgnet.TLRPC$TL_inputMediaDocument r0 = new org.rbmain.tgnet.TLRPC$TL_inputMediaDocument
            r0.<init>()
            org.rbmain.tgnet.TLRPC$TL_inputDocument r1 = new org.rbmain.tgnet.TLRPC$TL_inputDocument
            r1.<init>()
            r0.id = r1
            org.rbmain.tgnet.TLRPC$Document r6 = r6.document
            long r2 = r6.id
            r1.id = r2
            long r2 = r6.access_hash
            r1.access_hash = r2
            byte[] r6 = r6.file_reference
            r1.file_reference = r6
            goto L4b
        L4a:
            r0 = 0
        L4b:
            if (r0 == 0) goto L85
            int r6 = r7.ttl_seconds
            r1 = 1
            if (r6 == 0) goto L59
            r0.ttl_seconds = r6
            int r6 = r0.flags
            r6 = r6 | r1
            r0.flags = r6
        L59:
            org.rbmain.tgnet.TLObject r6 = r8.sendRequest
            org.rbmain.tgnet.TLRPC$TL_messages_sendMultiMedia r6 = (org.rbmain.tgnet.TLRPC$TL_messages_sendMultiMedia) r6
            r2 = 0
            r3 = 0
        L5f:
            java.util.ArrayList<org.rbmain.tgnet.TLRPC$TL_inputSingleMedia> r4 = r6.multi_media
            int r4 = r4.size()
            if (r3 >= r4) goto L81
            java.util.ArrayList<org.rbmain.tgnet.TLRPC$TL_inputSingleMedia> r4 = r6.multi_media
            java.lang.Object r4 = r4.get(r3)
            org.rbmain.tgnet.TLRPC$TL_inputSingleMedia r4 = (org.rbmain.tgnet.TLRPC$TL_inputSingleMedia) r4
            org.rbmain.tgnet.TLRPC$InputMedia r4 = r4.media
            if (r4 != r7) goto L7e
            java.util.ArrayList<org.rbmain.tgnet.TLRPC$TL_inputSingleMedia> r6 = r6.multi_media
            java.lang.Object r6 = r6.get(r3)
            org.rbmain.tgnet.TLRPC$TL_inputSingleMedia r6 = (org.rbmain.tgnet.TLRPC$TL_inputSingleMedia) r6
            r6.media = r0
            goto L81
        L7e:
            int r3 = r3 + 1
            goto L5f
        L81:
            r5.sendReadyToSendGroup(r8, r2, r1)
            goto L88
        L85:
            r8.markAsError()
        L88:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.SendMessagesHelper.lambda$uploadMultiMedia$34(org.rbmain.tgnet.TLObject, org.rbmain.tgnet.TLRPC$InputMedia, org.rbmain.messenger.SendMessagesHelper$DelayedMessage):void");
    }

    private void sendReadyToSendGroup(DelayedMessage delayedMessage, boolean z, boolean z2) {
        DelayedMessage delayedMessageFindMaxDelayedMessageForMessageId;
        if (delayedMessage.messageObjects.isEmpty()) {
            delayedMessage.markAsError();
            return;
        }
        String str = "group_" + delayedMessage.groupId;
        if (delayedMessage.finalGroupMessage != delayedMessage.messageObjects.get(r3.size() - 1).getId()) {
            if (z) {
                putToDelayedMessages(str, delayedMessage);
                return;
            }
            return;
        }
        int i = 0;
        if (z) {
            this.delayedMessages.remove(str);
            getMessagesStorage().putMessages(delayedMessage.messages, false, true, false, 0, delayedMessage.scheduled);
            getMessagesController().updateInterfaceWithMessages(delayedMessage.peer, delayedMessage.messageObjects, delayedMessage.scheduled);
            if (!delayedMessage.scheduled) {
                getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[0]);
            }
        }
        TLObject tLObject = delayedMessage.sendRequest;
        if (tLObject instanceof TLRPC$TL_messages_sendMultiMedia) {
            TLRPC$TL_messages_sendMultiMedia tLRPC$TL_messages_sendMultiMedia = (TLRPC$TL_messages_sendMultiMedia) tLObject;
            while (i < tLRPC$TL_messages_sendMultiMedia.multi_media.size()) {
                TLRPC$InputMedia tLRPC$InputMedia = tLRPC$TL_messages_sendMultiMedia.multi_media.get(i).media;
                if ((tLRPC$InputMedia instanceof TLRPC$TL_inputMediaUploadedPhoto) || (tLRPC$InputMedia instanceof TLRPC$TL_inputMediaUploadedDocument)) {
                    return;
                } else {
                    i++;
                }
            }
            if (z2 && (delayedMessageFindMaxDelayedMessageForMessageId = findMaxDelayedMessageForMessageId(delayedMessage.finalGroupMessage, delayedMessage.peer)) != null) {
                delayedMessageFindMaxDelayedMessageForMessageId.addDelayedRequest(delayedMessage.sendRequest, delayedMessage.messageObjects, delayedMessage.originalPaths, delayedMessage.parentObjects, delayedMessage, delayedMessage.scheduled);
                ArrayList<DelayedMessageSendAfterRequest> arrayList = delayedMessage.requests;
                if (arrayList != null) {
                    delayedMessageFindMaxDelayedMessageForMessageId.requests.addAll(arrayList);
                    return;
                }
                return;
            }
        } else {
            TLRPC$TL_messages_sendEncryptedMultiMedia tLRPC$TL_messages_sendEncryptedMultiMedia = (TLRPC$TL_messages_sendEncryptedMultiMedia) delayedMessage.sendEncryptedRequest;
            while (i < tLRPC$TL_messages_sendEncryptedMultiMedia.files.size()) {
                if (tLRPC$TL_messages_sendEncryptedMultiMedia.files.get(i) instanceof TLRPC$TL_inputEncryptedFile) {
                    return;
                } else {
                    i++;
                }
            }
        }
        TLObject tLObject2 = delayedMessage.sendRequest;
        if (tLObject2 instanceof TLRPC$TL_messages_sendMultiMedia) {
            performSendMessageRequestMulti((TLRPC$TL_messages_sendMultiMedia) tLObject2, delayedMessage.messageObjects, delayedMessage.originalPaths, delayedMessage.parentObjects, delayedMessage, delayedMessage.scheduled);
        } else {
            getSecretChatHelper().performSendEncryptedRequest((TLRPC$TL_messages_sendEncryptedMultiMedia) delayedMessage.sendEncryptedRequest, delayedMessage);
        }
        delayedMessage.sendDelayedRequests();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$stopVideoService$36(String str) {
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.stopEncodingService, str, Integer.valueOf(this.currentAccount));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$stopVideoService$37(final String str) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda27
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$stopVideoService$36(str);
            }
        });
    }

    public void stopVideoService(final String str) {
        getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda26
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$stopVideoService$37(str);
            }
        });
    }

    protected void putToSendingMessages(final TLRPC$Message tLRPC$Message, final boolean z) {
        if (Thread.currentThread() != ApplicationLoader.applicationHandler.getLooper().getThread()) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda49
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$putToSendingMessages$38(tLRPC$Message, z);
                }
            });
        } else {
            putToSendingMessages(tLRPC$Message, z, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$putToSendingMessages$38(TLRPC$Message tLRPC$Message, boolean z) {
        putToSendingMessages(tLRPC$Message, z, true);
    }

    protected void putToSendingMessages(TLRPC$Message tLRPC$Message, boolean z, boolean z2) {
        if (tLRPC$Message == null) {
            return;
        }
        long j = tLRPC$Message.id;
        if (j > 0) {
            this.editingMessages.put(j, tLRPC$Message);
            return;
        }
        boolean z3 = this.sendingMessages.indexOfKey(j) >= 0;
        removeFromUploadingMessages(tLRPC$Message.id, z);
        this.sendingMessages.put(tLRPC$Message.id, tLRPC$Message);
        if (z || z3) {
            return;
        }
        long dialogId = MessageObject.getDialogId(tLRPC$Message);
        LongSparseArray<Integer> longSparseArray = this.sendingMessagesIdDialogs;
        longSparseArray.put(dialogId, Integer.valueOf(longSparseArray.get(dialogId, 0).intValue() + 1));
        if (z2) {
            getNotificationCenter().postNotificationName(NotificationCenter.sendingMessagesChanged, new Object[0]);
        }
    }

    protected TLRPC$Message removeFromSendingMessages(long j, boolean z) {
        long dialogId;
        Integer num;
        if (j > 0) {
            TLRPC$Message tLRPC$Message = this.editingMessages.get(j);
            if (tLRPC$Message == null) {
                return tLRPC$Message;
            }
            this.editingMessages.remove(j);
            return tLRPC$Message;
        }
        TLRPC$Message tLRPC$Message2 = this.sendingMessages.get(j);
        if (tLRPC$Message2 != null) {
            this.sendingMessages.remove(j);
            if (!z && (num = this.sendingMessagesIdDialogs.get((dialogId = MessageObject.getDialogId(tLRPC$Message2)))) != null) {
                int iIntValue = num.intValue() - 1;
                if (iIntValue <= 0) {
                    this.sendingMessagesIdDialogs.remove(dialogId);
                } else {
                    this.sendingMessagesIdDialogs.put(dialogId, Integer.valueOf(iIntValue));
                }
                getNotificationCenter().postNotificationName(NotificationCenter.sendingMessagesChanged, new Object[0]);
            }
        } else {
            removeFromUploadingMessages(j, z);
        }
        return tLRPC$Message2;
    }

    public long getSendingMessageId(long j) {
        for (int i = 0; i < this.sendingMessages.size(); i++) {
            TLRPC$Message tLRPC$MessageValueAt = this.sendingMessages.valueAt(i);
            if (tLRPC$MessageValueAt.dialog_id == j) {
                return tLRPC$MessageValueAt.id;
            }
        }
        for (int i2 = 0; i2 < this.uploadMessages.size(); i2++) {
            TLRPC$Message tLRPC$MessageValueAt2 = this.uploadMessages.valueAt(i2);
            if (tLRPC$MessageValueAt2.dialog_id == j) {
                return tLRPC$MessageValueAt2.id;
            }
        }
        return 0L;
    }

    protected void putToUploadingMessages(MessageObject messageObject) {
        if (messageObject == null || messageObject.getId() > 0 || messageObject.scheduled) {
            return;
        }
        TLRPC$Message tLRPC$Message = messageObject.messageOwner;
        boolean z = this.uploadMessages.indexOfKey(tLRPC$Message.id) >= 0;
        this.uploadMessages.put(tLRPC$Message.id, tLRPC$Message);
        if (z) {
            return;
        }
        long dialogId = MessageObject.getDialogId(tLRPC$Message);
        LongSparseArray<Integer> longSparseArray = this.uploadingMessagesIdDialogs;
        longSparseArray.put(dialogId, Integer.valueOf(longSparseArray.get(dialogId, 0).intValue() + 1));
        getNotificationCenter().postNotificationName(NotificationCenter.sendingMessagesChanged, new Object[0]);
    }

    protected void removeFromUploadingMessages(long j, boolean z) {
        TLRPC$Message tLRPC$Message;
        if (j > 0 || z || (tLRPC$Message = this.uploadMessages.get(j)) == null) {
            return;
        }
        this.uploadMessages.remove(j);
        long dialogId = MessageObject.getDialogId(tLRPC$Message);
        Integer num = this.uploadingMessagesIdDialogs.get(dialogId);
        if (num != null) {
            int iIntValue = num.intValue() - 1;
            if (iIntValue <= 0) {
                this.uploadingMessagesIdDialogs.remove(dialogId);
            } else {
                this.uploadingMessagesIdDialogs.put(dialogId, Integer.valueOf(iIntValue));
            }
            getNotificationCenter().postNotificationName(NotificationCenter.sendingMessagesChanged, new Object[0]);
        }
    }

    public boolean isSendingMessage(long j) {
        return this.sendingMessages.indexOfKey(j) >= 0 || this.editingMessages.indexOfKey(j) >= 0;
    }

    public boolean isSendingMessageIdDialog(long j) {
        return this.sendingMessagesIdDialogs.get(j, 0).intValue() > 0;
    }

    public boolean isUploadingMessageIdDialog(long j) {
        return this.uploadingMessagesIdDialogs.get(j, 0).intValue() > 0;
    }

    protected void performSendMessageRequestMulti(final TLRPC$TL_messages_sendMultiMedia tLRPC$TL_messages_sendMultiMedia, final ArrayList<MessageObject> arrayList, final ArrayList<String> arrayList2, final ArrayList<Object> arrayList3, final DelayedMessage delayedMessage, final boolean z) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            putToSendingMessages(arrayList.get(i).messageOwner, z);
        }
        getConnectionsManager().sendRequest(tLRPC$TL_messages_sendMultiMedia, new RequestDelegate() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda79
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$performSendMessageRequestMulti$46(arrayList3, tLRPC$TL_messages_sendMultiMedia, arrayList, arrayList2, delayedMessage, z, tLObject, tLRPC$TL_error);
            }
        }, (QuickAckDelegate) null, 68);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$performSendMessageRequestMulti$46(ArrayList arrayList, final TLRPC$TL_messages_sendMultiMedia tLRPC$TL_messages_sendMultiMedia, final ArrayList arrayList2, final ArrayList arrayList3, final DelayedMessage delayedMessage, final boolean z, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error != null && FileRefController.isFileRefError(tLRPC$TL_error.text)) {
            if (arrayList != null) {
                ArrayList arrayList4 = new ArrayList(arrayList);
                getFileRefController().requestReference(arrayList4, tLRPC$TL_messages_sendMultiMedia, arrayList2, arrayList3, arrayList4, delayedMessage, Boolean.valueOf(z));
                return;
            } else if (delayedMessage != null && !delayedMessage.retriedToSend) {
                delayedMessage.retriedToSend = true;
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda57
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$performSendMessageRequestMulti$39(tLRPC$TL_messages_sendMultiMedia, delayedMessage, arrayList2, z);
                    }
                });
                return;
            }
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda52
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$performSendMessageRequestMulti$45(tLRPC$TL_error, tLObject, arrayList2, arrayList3, z, tLRPC$TL_messages_sendMultiMedia);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$performSendMessageRequestMulti$39(TLRPC$TL_messages_sendMultiMedia tLRPC$TL_messages_sendMultiMedia, DelayedMessage delayedMessage, ArrayList arrayList, boolean z) {
        int size = tLRPC$TL_messages_sendMultiMedia.multi_media.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            if (delayedMessage.parentObjects.get(i) != null) {
                removeFromSendingMessages(((MessageObject) arrayList.get(i)).getId(), z);
                TLRPC$TL_inputSingleMedia tLRPC$TL_inputSingleMedia = tLRPC$TL_messages_sendMultiMedia.multi_media.get(i);
                TLRPC$InputMedia tLRPC$InputMedia = tLRPC$TL_inputSingleMedia.media;
                if ((tLRPC$InputMedia instanceof TLRPC$TL_inputMediaPhoto) || (tLRPC$InputMedia instanceof TLRPC$TL_inputMediaDocument)) {
                    tLRPC$TL_inputSingleMedia.media = delayedMessage.inputMedias.get(i);
                }
                delayedMessage.videoEditedInfo = delayedMessage.videoEditedInfos.get(i);
                delayedMessage.httpLocation = delayedMessage.httpLocations.get(i);
                TLRPC$PhotoSize tLRPC$PhotoSize = delayedMessage.locations.get(i);
                delayedMessage.photoSize = tLRPC$PhotoSize;
                delayedMessage.performMediaUpload = true;
                if (tLRPC$TL_inputSingleMedia.media.file == null || tLRPC$PhotoSize != null) {
                    z2 = true;
                }
                performSendDelayedMessage(delayedMessage, i);
            }
            i++;
        }
        if (z2) {
            return;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TLRPC$Message tLRPC$Message = ((MessageObject) arrayList.get(i2)).messageOwner;
            getMessagesProxy().markMessageAsSendError(tLRPC$Message, z);
            tLRPC$Message.send_state = 2;
            getNotificationCenter().postNotificationName(NotificationCenter.messageSendError, Long.valueOf(tLRPC$Message.id));
            processSentMessage(tLRPC$Message.id);
            removeFromSendingMessages(tLRPC$Message.id, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$performSendMessageRequestMulti$45(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, ArrayList arrayList, ArrayList arrayList2, final boolean z, TLRPC$TL_messages_sendMultiMedia tLRPC$TL_messages_sendMultiMedia) {
        boolean z2;
        final TLRPC$Updates tLRPC$Updates;
        boolean z3;
        TLRPC$Message tLRPC$Message;
        TLRPC$TL_messageReplyHeader tLRPC$TL_messageReplyHeader;
        ArrayList arrayList3 = arrayList;
        boolean z4 = z;
        if (tLRPC$TL_error == null) {
            LongSparseArray longSparseArray = new LongSparseArray();
            LongSparseArray longSparseArray2 = new LongSparseArray();
            TLRPC$Updates tLRPC$Updates2 = (TLRPC$Updates) tLObject;
            ArrayList<TLRPC$Update> arrayList4 = tLRPC$Updates2.updates;
            SparseArray<LongSparseArray<TLRPC$TL_messageReplies>> sparseArray = null;
            int i = 0;
            while (i < arrayList4.size()) {
                TLRPC$Update tLRPC$Update = arrayList4.get(i);
                if (tLRPC$Update instanceof TLRPC$TL_updateMessageID) {
                    TLRPC$TL_updateMessageID tLRPC$TL_updateMessageID = (TLRPC$TL_updateMessageID) tLRPC$Update;
                    longSparseArray2.put(tLRPC$TL_updateMessageID.random_id, Long.valueOf(tLRPC$TL_updateMessageID.id));
                    arrayList4.remove(i);
                } else if (tLRPC$Update instanceof TLRPC$TL_updateNewMessage) {
                    final TLRPC$TL_updateNewMessage tLRPC$TL_updateNewMessage = (TLRPC$TL_updateNewMessage) tLRPC$Update;
                    TLRPC$Message tLRPC$Message2 = tLRPC$TL_updateNewMessage.message;
                    longSparseArray.put(tLRPC$Message2.id, tLRPC$Message2);
                    Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda62
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$performSendMessageRequestMulti$40(tLRPC$TL_updateNewMessage);
                        }
                    });
                    arrayList4.remove(i);
                } else if (tLRPC$Update instanceof TLRPC$TL_updateNewChannelMessage) {
                    final TLRPC$TL_updateNewChannelMessage tLRPC$TL_updateNewChannelMessage = (TLRPC$TL_updateNewChannelMessage) tLRPC$Update;
                    TLRPC$Chat chat = getMessagesController().getChat(Integer.valueOf(MessagesController.getUpdateChannelId(tLRPC$TL_updateNewChannelMessage)));
                    if ((chat == null || chat.megagroup) && (tLRPC$TL_messageReplyHeader = tLRPC$TL_updateNewChannelMessage.message.reply_to) != null && (tLRPC$TL_messageReplyHeader.reply_to_top_id != 0 || tLRPC$TL_messageReplyHeader.reply_to_msg_id != 0)) {
                        if (sparseArray == null) {
                            sparseArray = new SparseArray<>();
                        }
                        int dialogId = (int) MessageObject.getDialogId(tLRPC$TL_updateNewChannelMessage.message);
                        LongSparseArray<TLRPC$TL_messageReplies> longSparseArray3 = sparseArray.get(dialogId);
                        if (longSparseArray3 == null) {
                            longSparseArray3 = new LongSparseArray<>();
                            sparseArray.put(dialogId, longSparseArray3);
                        }
                        TLRPC$TL_messageReplyHeader tLRPC$TL_messageReplyHeader2 = tLRPC$TL_updateNewChannelMessage.message.reply_to;
                        long j = tLRPC$TL_messageReplyHeader2.reply_to_top_id;
                        if (j == 0) {
                            j = tLRPC$TL_messageReplyHeader2.reply_to_msg_id;
                        }
                        TLRPC$TL_messageReplies tLRPC$TL_messageReplies = longSparseArray3.get(j);
                        if (tLRPC$TL_messageReplies == null) {
                            tLRPC$TL_messageReplies = new TLRPC$TL_messageReplies();
                            longSparseArray3.put(j, tLRPC$TL_messageReplies);
                        }
                        TLRPC$Peer tLRPC$Peer = tLRPC$TL_updateNewChannelMessage.message.from_id;
                        if (tLRPC$Peer != null) {
                            tLRPC$TL_messageReplies.recent_repliers.add(0, tLRPC$Peer);
                        }
                        tLRPC$TL_messageReplies.replies++;
                    }
                    TLRPC$Message tLRPC$Message3 = tLRPC$TL_updateNewChannelMessage.message;
                    longSparseArray.put(tLRPC$Message3.id, tLRPC$Message3);
                    Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda59
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$performSendMessageRequestMulti$41(tLRPC$TL_updateNewChannelMessage);
                        }
                    });
                    arrayList4.remove(i);
                } else if (tLRPC$Update instanceof TLRPC$TL_updateNewScheduledMessage) {
                    TLRPC$Message tLRPC$Message4 = ((TLRPC$TL_updateNewScheduledMessage) tLRPC$Update).message;
                    longSparseArray.put(tLRPC$Message4.id, tLRPC$Message4);
                    arrayList4.remove(i);
                } else {
                    i++;
                }
                i--;
                i++;
            }
            if (sparseArray != null) {
                getMessagesStorage().putChannelViews(null, null, sparseArray, true, true);
                getNotificationCenter().postNotificationName(NotificationCenter.didUpdateMessagesViews, null, null, sparseArray, Boolean.TRUE);
            }
            int i2 = 0;
            while (i2 < arrayList.size()) {
                MessageObject messageObject = (MessageObject) arrayList3.get(i2);
                String str = (String) arrayList2.get(i2);
                final TLRPC$Message tLRPC$Message5 = messageObject.messageOwner;
                final long j2 = tLRPC$Message5.id;
                final ArrayList arrayList5 = new ArrayList();
                Long l = (Long) longSparseArray2.get(tLRPC$Message5.random_id);
                if (l == null || (tLRPC$Message = (TLRPC$Message) longSparseArray.get(l.longValue())) == null) {
                    tLRPC$Updates = tLRPC$Updates2;
                    z3 = true;
                    break;
                }
                MessageObject.getDialogId(tLRPC$Message);
                arrayList5.add(tLRPC$Message);
                if ((tLRPC$Message.flags & ConnectionsManager.FileTypeVideo) != 0) {
                    TLRPC$Message tLRPC$Message6 = messageObject.messageOwner;
                    tLRPC$Message6.ttl_period = tLRPC$Message.ttl_period;
                    tLRPC$Message6.flags |= ConnectionsManager.FileTypeVideo;
                }
                int i3 = i2;
                updateMediaPaths(messageObject, tLRPC$Message, tLRPC$Message.id, str, false);
                final int mediaExistanceFlags = messageObject.getMediaExistanceFlags();
                tLRPC$Message5.id = tLRPC$Message.id;
                final long j3 = tLRPC$Message.grouped_id;
                if (!z4) {
                    Long lValueOf = getMessagesController().dialogs_read_outbox_max.get(Long.valueOf(tLRPC$Message.dialog_id));
                    if (lValueOf == null) {
                        lValueOf = Long.valueOf(getMessagesStorage().getDialogReadMax(tLRPC$Message.out, tLRPC$Message.dialog_id));
                        getMessagesController().dialogs_read_outbox_max.put(Long.valueOf(tLRPC$Message.dialog_id), lValueOf);
                    }
                    tLRPC$Message.unread = lValueOf.longValue() < tLRPC$Message.id;
                }
                getStatsController().incrementSentItemsCount(ApplicationLoader.getCurrentNetworkType(), 1, 1);
                tLRPC$Message5.send_state = 0;
                getNotificationCenter().postNotificationName(NotificationCenter.messageReceivedByServer, Long.valueOf(j2), Long.valueOf(tLRPC$Message5.id), tLRPC$Message5, Long.valueOf(tLRPC$Message5.dialog_id), Long.valueOf(j3), Integer.valueOf(mediaExistanceFlags), Boolean.valueOf(z));
                getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda48
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$performSendMessageRequestMulti$43(tLRPC$Message5, j2, z, arrayList5, j3, mediaExistanceFlags);
                    }
                });
                i2 = i3 + 1;
                arrayList3 = arrayList;
                tLRPC$Updates2 = tLRPC$Updates2;
                longSparseArray2 = longSparseArray2;
                longSparseArray = longSparseArray;
                z4 = z;
            }
            tLRPC$Updates = tLRPC$Updates2;
            z3 = false;
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda65
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$performSendMessageRequestMulti$44(tLRPC$Updates);
                }
            });
            z2 = z3;
        } else {
            AlertsCreator.processError(this.currentAccount, tLRPC$TL_error, null, tLRPC$TL_messages_sendMultiMedia, new Object[0]);
            z2 = true;
        }
        if (z2) {
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                TLRPC$Message tLRPC$Message7 = ((MessageObject) arrayList.get(i4)).messageOwner;
                getMessagesProxy().markMessageAsSendError(tLRPC$Message7, z);
                tLRPC$Message7.send_state = 2;
                getNotificationCenter().postNotificationName(NotificationCenter.messageSendError, Long.valueOf(tLRPC$Message7.id));
                processSentMessage(tLRPC$Message7.id);
                removeFromSendingMessages(tLRPC$Message7.id, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$performSendMessageRequestMulti$40(TLRPC$TL_updateNewMessage tLRPC$TL_updateNewMessage) {
        getMessagesController().processNewDifferenceParams(-1, tLRPC$TL_updateNewMessage.pts, -1, tLRPC$TL_updateNewMessage.pts_count);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$performSendMessageRequestMulti$41(TLRPC$TL_updateNewChannelMessage tLRPC$TL_updateNewChannelMessage) {
        getMessagesController().processNewChannelDifferenceParams(tLRPC$TL_updateNewChannelMessage.pts, tLRPC$TL_updateNewChannelMessage.pts_count, tLRPC$TL_updateNewChannelMessage.message.peer_id.channel_id);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$performSendMessageRequestMulti$43(final TLRPC$Message tLRPC$Message, final long j, final boolean z, ArrayList arrayList, final long j2, final int i) {
        getMessagesStorage().updateMessageStateAndId(tLRPC$Message.random_id, Long.valueOf(j), tLRPC$Message.id, 0, false, tLRPC$Message.peer_id.channel_id, z ? 1 : 0);
        getMessagesStorage().putMessages((ArrayList<TLRPC$Message>) arrayList, true, false, false, 0, z);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda43
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$performSendMessageRequestMulti$42(tLRPC$Message, j, j2, i, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$performSendMessageRequestMulti$42(TLRPC$Message tLRPC$Message, long j, long j2, int i, boolean z) {
        getMediaDataController().increasePeerRaiting(tLRPC$Message.dialog_id);
        getNotificationCenter().postNotificationName(NotificationCenter.messageReceivedByServer, Long.valueOf(j), Long.valueOf(tLRPC$Message.id), tLRPC$Message, Long.valueOf(tLRPC$Message.dialog_id), Long.valueOf(j2), Integer.valueOf(i), Boolean.valueOf(z));
        processSentMessage(j);
        removeFromSendingMessages(j, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$performSendMessageRequestMulti$44(TLRPC$Updates tLRPC$Updates) {
        getMessagesController().processUpdates(tLRPC$Updates, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performSendMessageRequest(TLObject tLObject, MessageObject messageObject, String str, DelayedMessage delayedMessage, Object obj, HashMap<String, String> map, boolean z) {
        performSendMessageRequest(tLObject, messageObject, str, null, false, delayedMessage, obj, map, z);
    }

    /*  JADX ERROR: NullPointerException in pass: LoopRegionVisitor
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.use(jadx.core.dex.instructions.args.RegisterArg)" because "ssaVar" is null
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:493)
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:496)
        */
    private org.rbmain.messenger.SendMessagesHelper.DelayedMessage findMaxDelayedMessageForMessageId(long r15, long r17) {
        /*
            r14 = this;
            r0 = r14
            java.util.HashMap<java.lang.String, java.util.ArrayList<org.rbmain.messenger.SendMessagesHelper$DelayedMessage>> r1 = r0.delayedMessages
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
            r2 = 0
            r3 = -9223372036854775808
        Le:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L76
            java.lang.Object r5 = r1.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            java.lang.Object r5 = r5.getValue()
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            int r6 = r5.size()
            r7 = 0
        L25:
            if (r7 >= r6) goto Le
            java.lang.Object r8 = r5.get(r7)
            org.rbmain.messenger.SendMessagesHelper$DelayedMessage r8 = (org.rbmain.messenger.SendMessagesHelper.DelayedMessage) r8
            int r9 = r8.type
            r10 = 4
            if (r9 == r10) goto L34
            if (r9 != 0) goto L73
        L34:
            long r9 = r8.peer
            int r11 = (r9 > r17 ? 1 : (r9 == r17 ? 0 : -1))
            if (r11 != 0) goto L73
            org.rbmain.messenger.MessageObject r9 = r8.obj
            r10 = 0
            if (r9 == 0) goto L45
            long r12 = r9.getId()
            goto L63
        L45:
            java.util.ArrayList<org.rbmain.messenger.MessageObject> r9 = r8.messageObjects
            if (r9 == 0) goto L62
            boolean r9 = r9.isEmpty()
            if (r9 != 0) goto L62
            java.util.ArrayList<org.rbmain.messenger.MessageObject> r9 = r8.messageObjects
            int r12 = r9.size()
            int r12 = r12 + (-1)
            java.lang.Object r9 = r9.get(r12)
            org.rbmain.messenger.MessageObject r9 = (org.rbmain.messenger.MessageObject) r9
            long r12 = r9.getId()
            goto L63
        L62:
            r12 = r10
        L63:
            int r9 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r9 == 0) goto L73
            int r9 = (r12 > r15 ? 1 : (r12 == r15 ? 0 : -1))
            if (r9 <= 0) goto L73
            if (r2 != 0) goto L73
            int r9 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r9 >= 0) goto L73
            r2 = r8
            r3 = r12
        L73:
            int r7 = r7 + 1
            goto L25
        L76:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.SendMessagesHelper.findMaxDelayedMessageForMessageId(long, long):org.rbmain.messenger.SendMessagesHelper$DelayedMessage");
    }

    protected void performSendMessageRequest(final TLObject tLObject, final MessageObject messageObject, final String str, final DelayedMessage delayedMessage, final boolean z, final DelayedMessage delayedMessage2, final Object obj, HashMap<String, String> map, final boolean z2) {
        DelayedMessage delayedMessageFindMaxDelayedMessageForMessageId;
        ArrayList<DelayedMessageSendAfterRequest> arrayList;
        if (!(tLObject instanceof TLRPC$TL_messages_editMessage) && z && (delayedMessageFindMaxDelayedMessageForMessageId = findMaxDelayedMessageForMessageId(messageObject.getId(), messageObject.getDialogId())) != null) {
            delayedMessageFindMaxDelayedMessageForMessageId.addDelayedRequest(tLObject, messageObject, str, obj, delayedMessage2, delayedMessage != null ? delayedMessage.scheduled : false);
            if (delayedMessage == null || (arrayList = delayedMessage.requests) == null) {
                return;
            }
            delayedMessageFindMaxDelayedMessageForMessageId.requests.addAll(arrayList);
            return;
        }
        final TLRPC$Message tLRPC$Message = messageObject.messageOwner;
        putToSendingMessages(tLRPC$Message, z2);
        getAccountInstance().getMessageProxy().sendMessage(tLObject, tLRPC$Message, new RequestDelegate() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda82
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject2, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$performSendMessageRequest$61(tLObject, obj, messageObject, str, delayedMessage, z, delayedMessage2, z2, tLRPC$Message, tLObject2, tLRPC$TL_error);
            }
        });
        if (delayedMessage != null) {
            delayedMessage.sendDelayedRequests();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$performSendMessageRequest$61(final TLObject tLObject, Object obj, final MessageObject messageObject, final String str, DelayedMessage delayedMessage, boolean z, final DelayedMessage delayedMessage2, final boolean z2, final TLRPC$Message tLRPC$Message, final TLObject tLObject2, final TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error != null && (((tLObject instanceof TLRPC$TL_messages_sendMedia) || (tLObject instanceof TLRPC$TL_messages_editMessage)) && FileRefController.isFileRefError(tLRPC$TL_error.text))) {
            if (obj != null) {
                getFileRefController().requestReference(obj, tLObject, messageObject, str, delayedMessage, Boolean.valueOf(z), delayedMessage2, Boolean.valueOf(z2));
                return;
            } else if (delayedMessage2 != null) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda51
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$performSendMessageRequest$47(tLRPC$Message, z2, tLObject, delayedMessage2);
                    }
                });
                return;
            }
        }
        if (tLObject instanceof TLRPC$TL_messages_editMessage) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda54
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$performSendMessageRequest$50(tLRPC$TL_error, tLRPC$Message, tLObject2, messageObject, str, z2, tLObject);
                }
            });
        } else {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda67
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$performSendMessageRequest$60(z2, tLRPC$TL_error, tLRPC$Message, tLObject2, messageObject, str, tLObject);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$performSendMessageRequest$47(TLRPC$Message tLRPC$Message, boolean z, TLObject tLObject, DelayedMessage delayedMessage) {
        removeFromSendingMessages(tLRPC$Message.id, z);
        if (tLObject instanceof TLRPC$TL_messages_sendMedia) {
            TLRPC$TL_messages_sendMedia tLRPC$TL_messages_sendMedia = (TLRPC$TL_messages_sendMedia) tLObject;
            TLRPC$InputMedia tLRPC$InputMedia = tLRPC$TL_messages_sendMedia.media;
            if ((tLRPC$InputMedia instanceof TLRPC$TL_inputMediaPhoto) || (tLRPC$InputMedia instanceof TLRPC$TL_inputMediaDocument)) {
                tLRPC$TL_messages_sendMedia.media = delayedMessage.inputUploadMedia;
            }
        } else if (tLObject instanceof TLRPC$TL_messages_editMessage) {
            TLRPC$TL_messages_editMessage tLRPC$TL_messages_editMessage = (TLRPC$TL_messages_editMessage) tLObject;
            TLRPC$InputMedia tLRPC$InputMedia2 = tLRPC$TL_messages_editMessage.media;
            if ((tLRPC$InputMedia2 instanceof TLRPC$TL_inputMediaPhoto) || (tLRPC$InputMedia2 instanceof TLRPC$TL_inputMediaDocument)) {
                tLRPC$TL_messages_editMessage.media = delayedMessage.inputUploadMedia;
            }
        }
        delayedMessage.performMediaUpload = true;
        performSendDelayedMessage(delayedMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$performSendMessageRequest$50(TLRPC$TL_error tLRPC$TL_error, final TLRPC$Message tLRPC$Message, TLObject tLObject, MessageObject messageObject, String str, final boolean z, TLObject tLObject2) {
        TLRPC$Message tLRPC$Message2;
        TLRPC$Message tLRPC$Message3 = null;
        if (tLRPC$TL_error == null) {
            String str2 = tLRPC$Message.attachPath;
            final TLRPC$Updates tLRPC$Updates = (TLRPC$Updates) tLObject;
            ArrayList<TLRPC$Update> arrayList = tLRPC$Updates.updates;
            for (int i = 0; i < arrayList.size(); i++) {
                TLRPC$Update tLRPC$Update = arrayList.get(i);
                if (tLRPC$Update instanceof TLRPC$TL_updateEditMessage) {
                    tLRPC$Message2 = ((TLRPC$TL_updateEditMessage) tLRPC$Update).message;
                } else if (tLRPC$Update instanceof TLRPC$TL_updateEditChannelMessage) {
                    tLRPC$Message2 = ((TLRPC$TL_updateEditChannelMessage) tLRPC$Update).message;
                } else if (tLRPC$Update instanceof TLRPC$TL_updateNewScheduledMessage) {
                    tLRPC$Message2 = ((TLRPC$TL_updateNewScheduledMessage) tLRPC$Update).message;
                }
                tLRPC$Message3 = tLRPC$Message2;
            }
            if (tLRPC$Message3 != null) {
                ImageLoader.saveMessageThumbs(tLRPC$Message3);
                updateMediaPaths(messageObject, tLRPC$Message3, tLRPC$Message3.id, str, false);
            }
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda66
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$performSendMessageRequest$49(tLRPC$Updates, tLRPC$Message, z);
                }
            });
            if (MessageObject.isVideoMessage(tLRPC$Message) || MessageObject.isRoundVideoMessage(tLRPC$Message) || MessageObject.isNewGifMessage(tLRPC$Message)) {
                stopVideoService(str2);
                return;
            }
            return;
        }
        AlertsCreator.processError(this.currentAccount, tLRPC$TL_error, null, tLObject2, new Object[0]);
        if (MessageObject.isVideoMessage(tLRPC$Message) || MessageObject.isRoundVideoMessage(tLRPC$Message) || MessageObject.isNewGifMessage(tLRPC$Message)) {
            stopVideoService(tLRPC$Message.attachPath);
        }
        removeFromSendingMessages(tLRPC$Message.id, z);
        revertEditingMessageObject(messageObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$performSendMessageRequest$49(TLRPC$Updates tLRPC$Updates, final TLRPC$Message tLRPC$Message, final boolean z) {
        getMessagesController().processUpdates(tLRPC$Updates, false);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda50
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$performSendMessageRequest$48(tLRPC$Message, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$performSendMessageRequest$48(TLRPC$Message tLRPC$Message, boolean z) {
        processSentMessage(tLRPC$Message.id);
        removeFromSendingMessages(tLRPC$Message.id, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$performSendMessageRequest$60(final boolean z, TLRPC$TL_error tLRPC$TL_error, final TLRPC$Message tLRPC$Message, TLObject tLObject, final MessageObject messageObject, String str, TLObject tLObject2) {
        boolean z2;
        ArrayList arrayList;
        final long j;
        boolean z3;
        int mediaExistanceFlags;
        final TLRPC$Message tLRPC$Message2;
        SparseArray<LongSparseArray<TLRPC$TL_messageReplies>> sparseArray;
        TLRPC$Message tLRPC$Message3;
        boolean z4;
        TLRPC$Message tLRPC$Message4;
        TLRPC$TL_messageReplyHeader tLRPC$TL_messageReplyHeader;
        ArrayList arrayList2;
        if (tLRPC$TL_error == null) {
            long j2 = tLRPC$Message.id;
            ArrayList arrayList3 = new ArrayList();
            final String str2 = tLRPC$Message.attachPath;
            boolean z5 = tLRPC$Message.date == 2147483646;
            if (tLObject instanceof TLRPC$TL_updateShortSentMessage) {
                final TLRPC$TL_updateShortSentMessage tLRPC$TL_updateShortSentMessage = (TLRPC$TL_updateShortSentMessage) tLObject;
                updateMediaPaths(messageObject, null, tLRPC$TL_updateShortSentMessage.id, null, false);
                mediaExistanceFlags = messageObject.getMediaExistanceFlags();
                long j3 = tLRPC$TL_updateShortSentMessage.id;
                tLRPC$Message.id = j3;
                tLRPC$Message.local_id = j3;
                tLRPC$Message.date = tLRPC$TL_updateShortSentMessage.date;
                tLRPC$Message.entities = tLRPC$TL_updateShortSentMessage.entities;
                tLRPC$Message.out = tLRPC$TL_updateShortSentMessage.out;
                if ((tLRPC$TL_updateShortSentMessage.flags & ConnectionsManager.FileTypeVideo) != 0) {
                    tLRPC$Message.ttl_period = tLRPC$TL_updateShortSentMessage.ttl_period;
                    tLRPC$Message.flags |= ConnectionsManager.FileTypeVideo;
                }
                TLRPC$MessageMedia tLRPC$MessageMedia = tLRPC$TL_updateShortSentMessage.media;
                if (tLRPC$MessageMedia != null) {
                    tLRPC$Message.media = tLRPC$MessageMedia;
                    tLRPC$Message.flags |= 512;
                    ImageLoader.saveMessageThumbs(tLRPC$Message);
                }
                TLRPC$MessageMedia tLRPC$MessageMedia2 = tLRPC$TL_updateShortSentMessage.media;
                if (((tLRPC$MessageMedia2 instanceof TLRPC$TL_messageMediaGame) || (tLRPC$MessageMedia2 instanceof TLRPC$TL_messageMediaInvoice)) && !TextUtils.isEmpty(tLRPC$TL_updateShortSentMessage.message)) {
                    tLRPC$Message.message = tLRPC$TL_updateShortSentMessage.message;
                }
                if (!tLRPC$Message.entities.isEmpty()) {
                    tLRPC$Message.flags |= 128;
                }
                Long lValueOf = getMessagesController().dialogs_read_outbox_max.get(Long.valueOf(tLRPC$Message.dialog_id));
                if (lValueOf == null) {
                    lValueOf = Long.valueOf(getMessagesStorage().getDialogReadMax(tLRPC$Message.out, tLRPC$Message.dialog_id));
                    getMessagesController().dialogs_read_outbox_max.put(Long.valueOf(tLRPC$Message.dialog_id), lValueOf);
                }
                tLRPC$Message.unread = lValueOf.longValue() < tLRPC$Message.id;
                Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda63
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$performSendMessageRequest$51(tLRPC$TL_updateShortSentMessage);
                    }
                });
                arrayList3.add(tLRPC$Message);
                arrayList = arrayList3;
                j = j2;
                tLRPC$Message2 = null;
                z2 = false;
                z3 = false;
            } else if (tLObject instanceof TLRPC$Updates) {
                final TLRPC$Updates tLRPC$Updates = (TLRPC$Updates) tLObject;
                ArrayList<TLRPC$Update> arrayList4 = tLRPC$Updates.updates;
                int i = 0;
                while (true) {
                    if (i >= arrayList4.size()) {
                        arrayList = arrayList3;
                        sparseArray = null;
                        tLRPC$Message3 = null;
                        break;
                    }
                    TLRPC$Update tLRPC$Update = arrayList4.get(i);
                    if (tLRPC$Update instanceof TLRPC$TL_updateNewMessage) {
                        final TLRPC$TL_updateNewMessage tLRPC$TL_updateNewMessage = (TLRPC$TL_updateNewMessage) tLRPC$Update;
                        tLRPC$Message4 = tLRPC$TL_updateNewMessage.message;
                        arrayList3.add(tLRPC$Message4);
                        Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda61
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$performSendMessageRequest$52(tLRPC$TL_updateNewMessage);
                            }
                        });
                        arrayList4.remove(i);
                        arrayList = arrayList3;
                        sparseArray = null;
                        break;
                    }
                    if (tLRPC$Update instanceof TLRPC$TL_updateNewChannelMessage) {
                        final TLRPC$TL_updateNewChannelMessage tLRPC$TL_updateNewChannelMessage = (TLRPC$TL_updateNewChannelMessage) tLRPC$Update;
                        TLRPC$Chat chat = getMessagesController().getChat(Integer.valueOf(MessagesController.getUpdateChannelId(tLRPC$TL_updateNewChannelMessage)));
                        if ((chat != null && !chat.megagroup) || (tLRPC$TL_messageReplyHeader = tLRPC$TL_updateNewChannelMessage.message.reply_to) == null || (tLRPC$TL_messageReplyHeader.reply_to_top_id == 0 && tLRPC$TL_messageReplyHeader.reply_to_msg_id == 0)) {
                            arrayList2 = arrayList3;
                            sparseArray = null;
                        } else {
                            sparseArray = new SparseArray<>();
                            int dialogId = (int) MessageObject.getDialogId(tLRPC$TL_updateNewChannelMessage.message);
                            LongSparseArray<TLRPC$TL_messageReplies> longSparseArray = sparseArray.get(dialogId);
                            if (longSparseArray == null) {
                                longSparseArray = new LongSparseArray<>();
                                sparseArray.put(dialogId, longSparseArray);
                            }
                            TLRPC$TL_messageReplyHeader tLRPC$TL_messageReplyHeader2 = tLRPC$TL_updateNewChannelMessage.message.reply_to;
                            arrayList2 = arrayList3;
                            long j4 = tLRPC$TL_messageReplyHeader2.reply_to_top_id;
                            if (j4 == 0) {
                                j4 = tLRPC$TL_messageReplyHeader2.reply_to_msg_id;
                            }
                            TLRPC$TL_messageReplies tLRPC$TL_messageReplies = longSparseArray.get(j4);
                            if (tLRPC$TL_messageReplies == null) {
                                tLRPC$TL_messageReplies = new TLRPC$TL_messageReplies();
                                longSparseArray.put(j4, tLRPC$TL_messageReplies);
                            }
                            TLRPC$Peer tLRPC$Peer = tLRPC$TL_updateNewChannelMessage.message.from_id;
                            if (tLRPC$Peer != null) {
                                tLRPC$TL_messageReplies.recent_repliers.add(0, tLRPC$Peer);
                            }
                            tLRPC$TL_messageReplies.replies++;
                        }
                        tLRPC$Message4 = tLRPC$TL_updateNewChannelMessage.message;
                        arrayList = arrayList2;
                        arrayList.add(tLRPC$Message4);
                        Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda60
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$performSendMessageRequest$53(tLRPC$TL_updateNewChannelMessage);
                            }
                        });
                        arrayList4.remove(i);
                    } else {
                        arrayList = arrayList3;
                        if (tLRPC$Update instanceof TLRPC$TL_updateNewScheduledMessage) {
                            TLRPC$Message tLRPC$Message5 = ((TLRPC$TL_updateNewScheduledMessage) tLRPC$Update).message;
                            arrayList.add(tLRPC$Message5);
                            arrayList4.remove(i);
                            tLRPC$Message3 = tLRPC$Message5;
                            sparseArray = null;
                            break;
                        }
                        i++;
                        arrayList3 = arrayList;
                    }
                }
                tLRPC$Message3 = tLRPC$Message4;
                if (sparseArray != null) {
                    getMessagesStorage().putChannelViews(null, null, sparseArray, true, true);
                    getNotificationCenter().postNotificationName(NotificationCenter.didUpdateMessagesViews, null, null, sparseArray, Boolean.TRUE);
                }
                if (tLRPC$Message3 != null) {
                    this.sentMessages.add(Long.valueOf(j2));
                    MessageObject.getDialogId(tLRPC$Message3);
                    z3 = (!z5 || tLRPC$Message3.date == 2147483646) ? z : false;
                    ImageLoader.saveMessageThumbs(tLRPC$Message3);
                    if (!z3) {
                        Long lValueOf2 = getMessagesController().dialogs_read_outbox_max.get(Long.valueOf(tLRPC$Message3.dialog_id));
                        if (lValueOf2 == null) {
                            lValueOf2 = Long.valueOf(getMessagesStorage().getDialogReadMax(tLRPC$Message3.out, tLRPC$Message3.dialog_id));
                            getMessagesController().dialogs_read_outbox_max.put(Long.valueOf(tLRPC$Message3.dialog_id), lValueOf2);
                        }
                        tLRPC$Message3.unread = lValueOf2.longValue() < tLRPC$Message3.id;
                    }
                    TLRPC$Message tLRPC$Message6 = messageObject.messageOwner;
                    tLRPC$Message6.post_author = tLRPC$Message3.post_author;
                    if ((tLRPC$Message3.flags & ConnectionsManager.FileTypeVideo) != 0) {
                        tLRPC$Message6.ttl_period = tLRPC$Message3.ttl_period;
                        tLRPC$Message6.flags |= ConnectionsManager.FileTypeVideo;
                    }
                    updateMediaPaths(messageObject, tLRPC$Message3, tLRPC$Message3.id, str, false);
                    mediaExistanceFlags = messageObject.getMediaExistanceFlags();
                    tLRPC$Message.id = tLRPC$Message3.id;
                    z4 = false;
                } else {
                    z3 = z;
                    mediaExistanceFlags = 0;
                    z4 = true;
                    tLRPC$Message3 = null;
                }
                Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda64
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$performSendMessageRequest$54(tLRPC$Updates);
                    }
                });
                z2 = z4;
                tLRPC$Message2 = tLRPC$Message3;
                j = j2;
            } else {
                arrayList = arrayList3;
                if (tLObject instanceof TLRPC$Message) {
                    tLRPC$Message.send_state = 0;
                    this.sentMessages.add(Long.valueOf(j2));
                    j = j2;
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda21
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$performSendMessageRequest$55(j);
                        }
                    });
                    mediaExistanceFlags = messageObject.getMediaExistanceFlags();
                    tLRPC$Message2 = (TLRPC$Message) tLObject;
                    z3 = z;
                } else {
                    j = j2;
                    z3 = z;
                    mediaExistanceFlags = 0;
                    tLRPC$Message2 = null;
                }
                z2 = false;
            }
            if (tLRPC$Message2 != null) {
                tLRPC$Message2.attachPath = tLRPC$Message.attachPath;
                tLRPC$Message2.fileName = tLRPC$Message.fileName;
            }
            if (MessageObject.isLiveLocationMessage(tLRPC$Message2) && tLRPC$Message2.via_bot_id == 0 && TextUtils.isEmpty(tLRPC$Message2.via_bot_name)) {
                getLocationController().addSharingLocation(tLRPC$Message2);
            }
            if (!z2) {
                getStatsController().incrementSentItemsCount(ApplicationLoader.getCurrentNetworkType(), 1, 1);
                tLRPC$Message.send_state = 0;
                if (z && !z3) {
                    ArrayList<Long> arrayList5 = new ArrayList<>();
                    arrayList5.add(Long.valueOf(j));
                    getMessagesController().deleteMessages(arrayList5, null, null, tLRPC$Message.dialog_id, tLRPC$Message.peer_id.channel_id, false, true);
                    final ArrayList arrayList6 = arrayList;
                    getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda33
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$performSendMessageRequest$57(arrayList6, messageObject, tLRPC$Message, j, z, str2);
                        }
                    });
                } else {
                    getNotificationCenter().postNotificationName(NotificationCenter.messageReceivedByServer, Long.valueOf(j), Long.valueOf(tLRPC$Message2.id), tLRPC$Message2, Long.valueOf(tLRPC$Message2.dialog_id), 0L, Integer.valueOf(mediaExistanceFlags), Boolean.valueOf(z));
                    final long j5 = j;
                    getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda47
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$performSendMessageRequest$59(tLRPC$Message2, j5, z, str2);
                        }
                    });
                }
            }
        } else {
            AlertsCreator.processError(this.currentAccount, tLRPC$TL_error, null, tLObject2, new Object[0]);
            z2 = true;
        }
        if (z2) {
            getMessagesProxy().markMessageAsSendError(tLRPC$Message, z);
            tLRPC$Message.send_state = 2;
            getNotificationCenter().postNotificationName(NotificationCenter.messageSendError, Long.valueOf(tLRPC$Message.id));
            processSentMessage(tLRPC$Message.id);
            if (MessageObject.isVideoMessage(tLRPC$Message) || MessageObject.isRoundVideoMessage(tLRPC$Message) || MessageObject.isNewGifMessage(tLRPC$Message)) {
                stopVideoService(tLRPC$Message.attachPath);
            }
            removeFromSendingMessages(tLRPC$Message.id, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$performSendMessageRequest$51(TLRPC$TL_updateShortSentMessage tLRPC$TL_updateShortSentMessage) {
        getMessagesController().processNewDifferenceParams(-1, tLRPC$TL_updateShortSentMessage.pts, tLRPC$TL_updateShortSentMessage.date, tLRPC$TL_updateShortSentMessage.pts_count);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$performSendMessageRequest$52(TLRPC$TL_updateNewMessage tLRPC$TL_updateNewMessage) {
        getMessagesController().processNewDifferenceParams(-1, tLRPC$TL_updateNewMessage.pts, -1, tLRPC$TL_updateNewMessage.pts_count);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$performSendMessageRequest$53(TLRPC$TL_updateNewChannelMessage tLRPC$TL_updateNewChannelMessage) {
        getMessagesController().processNewChannelDifferenceParams(tLRPC$TL_updateNewChannelMessage.pts, tLRPC$TL_updateNewChannelMessage.pts_count, tLRPC$TL_updateNewChannelMessage.message.peer_id.channel_id);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$performSendMessageRequest$54(TLRPC$Updates tLRPC$Updates) {
        getMessagesController().processUpdates(tLRPC$Updates, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$performSendMessageRequest$55(long j) {
        getNotificationCenter().postNotificationName(NotificationCenter.messageReceivedByAck, Long.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$performSendMessageRequest$57(ArrayList arrayList, final MessageObject messageObject, final TLRPC$Message tLRPC$Message, final long j, final boolean z, String str) {
        getMessagesStorage().putMessages((ArrayList<TLRPC$Message>) arrayList, true, false, false, 0, false);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda36
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$performSendMessageRequest$56(messageObject, tLRPC$Message, j, z);
            }
        });
        if (MessageObject.isVideoMessage(tLRPC$Message) || MessageObject.isRoundVideoMessage(tLRPC$Message) || MessageObject.isNewGifMessage(tLRPC$Message)) {
            stopVideoService(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$performSendMessageRequest$56(MessageObject messageObject, TLRPC$Message tLRPC$Message, long j, boolean z) {
        ArrayList<MessageObject> arrayList = new ArrayList<>();
        arrayList.add(new MessageObject(messageObject.currentAccount, messageObject.messageOwner, true, true));
        getMessagesController().updateInterfaceWithMessages(tLRPC$Message.dialog_id, arrayList, false);
        getMediaDataController().increasePeerRaiting(tLRPC$Message.dialog_id);
        processSentMessage(j);
        removeFromSendingMessages(j, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$performSendMessageRequest$59(final TLRPC$Message tLRPC$Message, final long j, final boolean z, String str) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda46
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$performSendMessageRequest$58(tLRPC$Message, j, z);
            }
        });
        if (MessageObject.isVideoMessage(tLRPC$Message) || MessageObject.isRoundVideoMessage(tLRPC$Message) || MessageObject.isNewGifMessage(tLRPC$Message)) {
            stopVideoService(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$performSendMessageRequest$58(TLRPC$Message tLRPC$Message, long j, boolean z) {
        getMediaDataController().increasePeerRaiting(tLRPC$Message.dialog_id);
        processSentMessage(j);
        removeFromSendingMessages(j, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:140:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x0306 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void updateMediaPaths(org.rbmain.messenger.MessageObject r17, org.rbmain.tgnet.TLRPC$Message r18, long r19, java.lang.String r21, boolean r22) {
        /*
            Method dump skipped, instructions count: 1669
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.SendMessagesHelper.updateMediaPaths(org.rbmain.messenger.MessageObject, org.rbmain.tgnet.TLRPC$Message, long, java.lang.String, boolean):void");
    }

    private void putToDelayedMessages(String str, DelayedMessage delayedMessage) {
        ArrayList<DelayedMessage> arrayList = this.delayedMessages.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.delayedMessages.put(str, arrayList);
        } else {
            getMessagesProxy().addDelayedMessageToLocalDb(delayedMessage.obj.messageOwner, false);
        }
        arrayList.add(delayedMessage);
    }

    protected ArrayList<DelayedMessage> getDelayedMessages(String str) {
        return this.delayedMessages.get(str);
    }

    protected long getNextRandomId() {
        return AndroidUtilities.getNextRnd();
    }

    public void checkUnsentMessages() {
        if (getCoreMainClass().isChatListInited()) {
            getMessagesProxy().getUnsentMessages();
        }
    }

    public void processUnsentMessages(final ArrayList<TLRPC$Message> arrayList, final ArrayList<TLRPC$Message> arrayList2, final ArrayList<TLRPC$User> arrayList3, final ArrayList<TLRPC$Chat> arrayList4, final ArrayList<TLRPC$EncryptedChat> arrayList5) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda31
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processUnsentMessages$62(arrayList3, arrayList4, arrayList5, arrayList, arrayList2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processUnsentMessages$62(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4, ArrayList arrayList5) {
        getMessagesController().putUsers(arrayList, true);
        getMessagesController().putChats(arrayList2, true);
        getMessagesController().putEncryptedChats(arrayList3, true);
        for (int i = 0; i < arrayList4.size(); i++) {
            MessageObject messageObject = new MessageObject(this.currentAccount, (TLRPC$Message) arrayList4.get(i), false, true);
            messageObject.resendAsIs = true;
            retrySendMessage(messageObject, true);
        }
        if (arrayList5 != null) {
            for (int i2 = 0; i2 < arrayList5.size(); i2++) {
                MessageObject messageObject2 = new MessageObject(this.currentAccount, (TLRPC$Message) arrayList5.get(i2), false, true);
                messageObject2.scheduled = true;
                retrySendMessage(messageObject2, true);
            }
        }
    }

    public ImportingHistory getImportingHistory(long j) {
        return this.importingHistoryMap.get(j);
    }

    public boolean isImportingHistory() {
        return this.importingHistoryMap.size() != 0;
    }

    public void prepareImportHistory(final long j, final Uri uri, final ArrayList<Uri> arrayList, final MessagesStorage.IntCallback intCallback) {
        if (this.importingHistoryMap.get(j) != null) {
            intCallback.run(0);
            return;
        }
        int i = (int) j;
        if (i < 0) {
            int i2 = -i;
            TLRPC$Chat chat = getMessagesController().getChat(Integer.valueOf(i2));
            if (chat != null && !chat.megagroup) {
                getMessagesController().convertToMegaGroup(null, i2, null, new MessagesStorage.IntCallback() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda73
                    @Override // org.rbmain.messenger.MessagesStorage.IntCallback
                    public final void run(int i3) {
                        this.f$0.lambda$prepareImportHistory$63(uri, arrayList, intCallback, i3);
                    }
                });
                return;
            }
        }
        new Thread(new Runnable() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda30
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$prepareImportHistory$68(arrayList, j, uri, intCallback);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$prepareImportHistory$63(Uri uri, ArrayList arrayList, MessagesStorage.IntCallback intCallback, int i) {
        if (i != 0) {
            prepareImportHistory(-i, uri, arrayList, intCallback);
        } else {
            intCallback.run(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$prepareImportHistory$68(java.util.ArrayList r17, final long r18, android.net.Uri r20, final org.rbmain.messenger.MessagesStorage.IntCallback r21) {
        /*
            r16 = this;
            r3 = r18
            r6 = r21
            if (r17 == 0) goto L9
            r0 = r17
            goto Le
        L9:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        Le:
            org.rbmain.messenger.SendMessagesHelper$ImportingHistory r5 = new org.rbmain.messenger.SendMessagesHelper$ImportingHistory
            r7 = r16
            r5.<init>()
            r5.mediaPaths = r0
            r5.dialogId = r3
            org.rbmain.messenger.MessagesController r1 = r16.getMessagesController()
            int r2 = (int) r3
            org.rbmain.tgnet.TLRPC$InputPeer r1 = r1.getInputPeer(r2)
            r5.peer = r1
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r1 = 0
            int r8 = r0.size()
        L2e:
            int r9 = r8 + 1
            if (r1 >= r9) goto Lac
            if (r1 != 0) goto L37
            r9 = r20
            goto L3f
        L37:
            int r9 = r1 + (-1)
            java.lang.Object r9 = r0.get(r9)
            android.net.Uri r9 = (android.net.Uri) r9
        L3f:
            if (r9 == 0) goto L9e
            boolean r10 = org.rbmain.messenger.AndroidUtilities.isInternalUri(r9)
            if (r10 == 0) goto L48
            goto L9e
        L48:
            java.lang.String r10 = "txt"
            java.lang.String r9 = org.rbmain.messenger.MediaController.copyFileToCache(r9, r10)
            if (r9 != 0) goto L52
            goto La9
        L52:
            java.io.File r10 = new java.io.File
            r10.<init>(r9)
            boolean r11 = r10.exists()
            if (r11 == 0) goto L93
            long r11 = r10.length()
            r13 = 0
            int r15 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r15 != 0) goto L68
            goto L93
        L68:
            long r13 = r5.totalSize
            long r13 = r13 + r11
            r5.totalSize = r13
            if (r1 != 0) goto L85
            r13 = 33554432(0x2000000, double:1.6578092E-316)
            int r15 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r15 <= 0) goto L82
            r10.delete()
            org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda17 r0 = new org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda17
            r0.<init>()
            org.rbmain.messenger.AndroidUtilities.runOnUIThread(r0)
            return
        L82:
            r5.historyPath = r9
            goto L8a
        L85:
            java.util.ArrayList<java.lang.String> r10 = r5.uploadMedia
            r10.add(r9)
        L8a:
            java.util.HashSet<java.lang.String> r10 = r5.uploadSet
            r10.add(r9)
            r2.put(r9, r5)
            goto La9
        L93:
            if (r1 != 0) goto La9
            org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda16 r0 = new org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda16
            r0.<init>()
            org.rbmain.messenger.AndroidUtilities.runOnUIThread(r0)
            return
        L9e:
            if (r1 != 0) goto La9
            org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda18 r0 = new org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda18
            r0.<init>()
            org.rbmain.messenger.AndroidUtilities.runOnUIThread(r0)
            return
        La9:
            int r1 = r1 + 1
            goto L2e
        Lac:
            org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda34 r8 = new org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda34
            r0 = r8
            r1 = r16
            r3 = r18
            r6 = r21
            r0.<init>()
            org.rbmain.messenger.AndroidUtilities.runOnUIThread(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.SendMessagesHelper.lambda$prepareImportHistory$68(java.util.ArrayList, long, android.net.Uri, org.rbmain.messenger.MessagesStorage$IntCallback):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$prepareImportHistory$66(MessagesStorage.IntCallback intCallback) {
        Toast.makeText(ApplicationLoader.applicationContext, LocaleController.getString("ImportFileTooLarge", ir.medu.shad.R.string.ImportFileTooLarge), 0).show();
        intCallback.run(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$prepareImportHistory$67(HashMap map, long j, ImportingHistory importingHistory, MessagesStorage.IntCallback intCallback) {
        this.importingHistoryFiles.putAll(map);
        this.importingHistoryMap.put(j, importingHistory);
        getFileLoader().uploadFile(importingHistory.historyPath, false, true, 0, ConnectionsManager.FileTypeFile, true, null);
        getNotificationCenter().postNotificationName(NotificationCenter.historyImportProgressChanged, Long.valueOf(j));
        intCallback.run((int) j);
        try {
            ApplicationLoader.applicationContext.startService(new Intent(ApplicationLoader.applicationContext, (Class<?>) ImportingService.class));
        } catch (Throwable th) {
            FileLog.e(th);
        }
    }

    public TLRPC$TL_photo generatePhotoSizes(String str, Uri uri) {
        return generatePhotoSizes(null, str, uri);
    }

    public TLRPC$TL_photo generatePhotoSizes(TLRPC$TL_photo tLRPC$TL_photo, String str, Uri uri) {
        Bitmap bitmapLoadBitmap = ImageLoader.loadBitmap(str, uri, AndroidUtilities.getPhotoSize(), AndroidUtilities.getPhotoSize(), true);
        if (bitmapLoadBitmap == null) {
            bitmapLoadBitmap = ImageLoader.loadBitmap(str, uri, 800.0f, 800.0f, true);
        }
        ArrayList<TLRPC$PhotoSize> arrayList = new ArrayList<>();
        TLRPC$PhotoSize tLRPC$PhotoSizeScaleAndSaveImage = ImageLoader.scaleAndSaveImage(bitmapLoadBitmap, 90.0f, 90.0f, 55, true);
        if (tLRPC$PhotoSizeScaleAndSaveImage != null) {
            arrayList.add(tLRPC$PhotoSizeScaleAndSaveImage);
        }
        TLRPC$PhotoSize tLRPC$PhotoSizeScaleAndSaveImage2 = ImageLoader.scaleAndSaveImage(bitmapLoadBitmap, AndroidUtilities.getPhotoSize(), AndroidUtilities.getPhotoSize(), true, 80, false, 101, 101);
        if (tLRPC$PhotoSizeScaleAndSaveImage2 != null) {
            arrayList.add(tLRPC$PhotoSizeScaleAndSaveImage2);
        }
        if (bitmapLoadBitmap != null) {
            bitmapLoadBitmap.recycle();
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        getUserConfig().saveConfig(false);
        if (tLRPC$TL_photo == null) {
            tLRPC$TL_photo = new TLRPC$TL_photo();
        }
        tLRPC$TL_photo.date = getConnectionsManager().getCurrentTime();
        tLRPC$TL_photo.sizes = arrayList;
        tLRPC$TL_photo.file_reference = new byte[0];
        return tLRPC$TL_photo;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:323|81|(6:83|84|(1:86)|312|91|95)(1:89)|90|312|91|95) */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0132, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0133, code lost:
    
        org.rbmain.messenger.FileLog.e(r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0203 A[PHI: r1
      0x0203: PHI (r1v3 java.lang.String) = (r1v0 java.lang.String), (r1v26 java.lang.String) binds: [B:141:0x01c5, B:148:0x0202] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0206 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x02fc A[PHI: r11
      0x02fc: PHI (r11v17 java.lang.String) = 
      (r11v10 java.lang.String)
      (r11v11 java.lang.String)
      (r11v12 java.lang.String)
      (r11v13 java.lang.String)
      (r11v14 java.lang.String)
      (r11v15 java.lang.String)
      (r11v18 java.lang.String)
     binds: [B:211:0x0342, B:207:0x0337, B:203:0x032a, B:199:0x031d, B:195:0x0312, B:191:0x0307, B:188:0x02fa] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0409  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x040e  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0414  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x041d  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0426 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:267:0x042f  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0436  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x0491  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x0498 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:302:0x04da  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x0153 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x012b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean prepareSendingDocumentInternal(final org.rbmain.messenger.AccountInstance r34, java.lang.String r35, java.lang.String r36, android.net.Uri r37, java.lang.String r38, final long r39, final org.rbmain.messenger.MessageObject r41, final org.rbmain.messenger.MessageObject r42, java.lang.CharSequence r43, final java.util.ArrayList<org.rbmain.tgnet.TLRPC$MessageEntity> r44, final org.rbmain.messenger.MessageObject r45, long[] r46, boolean r47, boolean r48, final boolean r49, final int r50, java.lang.Integer[] r51) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.SendMessagesHelper.prepareSendingDocumentInternal(org.rbmain.messenger.AccountInstance, java.lang.String, java.lang.String, android.net.Uri, java.lang.String, long, org.rbmain.messenger.MessageObject, org.rbmain.messenger.MessageObject, java.lang.CharSequence, java.util.ArrayList, org.rbmain.messenger.MessageObject, long[], boolean, boolean, boolean, int, java.lang.Integer[]):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$prepareSendingDocumentInternal$69(MessageObject messageObject, AccountInstance accountInstance, TLRPC$TL_document tLRPC$TL_document, String str, HashMap map, String str2, long j, MessageObject messageObject2, MessageObject messageObject3, String str3, ArrayList arrayList, boolean z, int i) {
        if (messageObject != null) {
            accountInstance.getSendMessagesHelper().editMessage(messageObject, null, null, tLRPC$TL_document, str, map, false, str2);
        } else {
            accountInstance.getSendMessagesHelper().sendMessage(tLRPC$TL_document, null, str, j, messageObject2, messageObject3, str3, arrayList, null, map, z, i, 0, str2);
        }
    }

    public static void prepareSendingDocument(AccountInstance accountInstance, String str, String str2, Uri uri, String str3, String str4, long j, MessageObject messageObject, MessageObject messageObject2, InputContentInfoCompat inputContentInfoCompat, MessageObject messageObject3, boolean z, int i) {
        if ((str == null || str2 == null) && uri == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = null;
        if (uri != null) {
            arrayList3 = new ArrayList();
            arrayList3.add(uri);
        }
        if (str != null) {
            arrayList.add(str);
            arrayList2.add(str2);
        }
        prepareSendingDocuments(accountInstance, arrayList, arrayList2, arrayList3, str3, str4, j, messageObject, messageObject2, inputContentInfoCompat, messageObject3, z, i);
    }

    public static void prepareSendingAudioDocuments(final AccountInstance accountInstance, final ArrayList<MessageObject> arrayList, final String str, final long j, final MessageObject messageObject, final MessageObject messageObject2, final MessageObject messageObject3, final boolean z, final int i) {
        new Thread(new Runnable() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() throws InterruptedException {
                SendMessagesHelper.lambda$prepareSendingAudioDocuments$71(arrayList, j, accountInstance, str, messageObject3, messageObject, messageObject2, z, i);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void lambda$prepareSendingAudioDocuments$71(java.util.ArrayList r26, final long r27, final org.rbmain.messenger.AccountInstance r29, java.lang.String r30, final org.rbmain.messenger.MessageObject r31, final org.rbmain.messenger.MessageObject r32, final org.rbmain.messenger.MessageObject r33, final boolean r34, final int r35) throws java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 314
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.SendMessagesHelper.lambda$prepareSendingAudioDocuments$71(java.util.ArrayList, long, org.rbmain.messenger.AccountInstance, java.lang.String, org.rbmain.messenger.MessageObject, org.rbmain.messenger.MessageObject, org.rbmain.messenger.MessageObject, boolean, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$prepareSendingAudioDocuments$70(MessageObject messageObject, AccountInstance accountInstance, TLRPC$TL_document tLRPC$TL_document, MessageObject messageObject2, HashMap map, String str, long j, MessageObject messageObject3, MessageObject messageObject4, String str2, boolean z, int i) {
        if (messageObject != null) {
            accountInstance.getSendMessagesHelper().editMessage(messageObject, null, null, tLRPC$TL_document, messageObject2.messageOwner.attachPath, map, false, str);
        } else {
            accountInstance.getSendMessagesHelper().sendMessage(tLRPC$TL_document, null, messageObject2.messageOwner.attachPath, j, messageObject3, messageObject4, str2, null, null, map, z, i, 0, str);
        }
    }

    private static void finishGroup(final AccountInstance accountInstance, final long j, final int i) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                SendMessagesHelper.lambda$finishGroup$72(accountInstance, j, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$finishGroup$72(AccountInstance accountInstance, long j, int i) {
        SendMessagesHelper sendMessagesHelper = accountInstance.getSendMessagesHelper();
        ArrayList<DelayedMessage> arrayList = sendMessagesHelper.delayedMessages.get("group_" + j);
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        DelayedMessage delayedMessage = arrayList.get(0);
        ArrayList<MessageObject> arrayList2 = delayedMessage.messageObjects;
        MessageObject messageObject = arrayList2.get(arrayList2.size() - 1);
        delayedMessage.finalGroupMessage = messageObject.getId();
        messageObject.messageOwner.params.put("final", "1");
        TLRPC$TL_messages_messages tLRPC$TL_messages_messages = new TLRPC$TL_messages_messages();
        tLRPC$TL_messages_messages.messages.add(messageObject.messageOwner);
        accountInstance.getMessagesStorage().putMessages((TLRPC$messages_Messages) tLRPC$TL_messages_messages, delayedMessage.peer, -2, 0L, false, i != 0);
        sendMessagesHelper.sendReadyToSendGroup(delayedMessage, true, true);
    }

    public static void prepareSendingDocuments(final AccountInstance accountInstance, final ArrayList<String> arrayList, final ArrayList<String> arrayList2, final ArrayList<Uri> arrayList3, final String str, final String str2, final long j, final MessageObject messageObject, final MessageObject messageObject2, final InputContentInfoCompat inputContentInfoCompat, final MessageObject messageObject3, final boolean z, final int i) {
        if (arrayList == null && arrayList2 == null && arrayList3 == null) {
            return;
        }
        if (arrayList == null || arrayList2 == null || arrayList.size() == arrayList2.size()) {
            new Thread(new Runnable() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    SendMessagesHelper.lambda$prepareSendingDocuments$74(j, accountInstance, arrayList, str, i, arrayList2, str2, messageObject, messageObject2, messageObject3, inputContentInfoCompat, z, arrayList3);
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$prepareSendingDocuments$74(long j, AccountInstance accountInstance, ArrayList arrayList, String str, int i, ArrayList arrayList2, String str2, MessageObject messageObject, MessageObject messageObject2, MessageObject messageObject3, InputContentInfoCompat inputContentInfoCompat, boolean z, ArrayList arrayList3) {
        Integer[] numArr;
        long[] jArr;
        ArrayList arrayList4;
        boolean z2;
        AccountInstance accountInstance2 = accountInstance;
        ArrayList arrayList5 = arrayList;
        int i2 = i;
        int i3 = 1;
        long[] jArr2 = new long[1];
        Integer[] numArr2 = new Integer[1];
        boolean z3 = ((int) j) == 0;
        if (z3) {
            TLRPC$EncryptedChat encryptedChat = accountInstance.getMessagesController().getEncryptedChat(Integer.valueOf((int) (j >> 32)));
            if (encryptedChat != null) {
                AndroidUtilities.getPeerLayerVersion(encryptedChat.layer);
            }
        }
        int i4 = 10;
        if (arrayList5 != null) {
            int size = arrayList.size();
            int i5 = 0;
            int i6 = 0;
            z2 = false;
            while (i6 < size) {
                String str3 = i6 == 0 ? str : null;
                if (!z3 && size > i3 && i5 % 10 == 0) {
                    if (jArr2[0] != 0) {
                        finishGroup(accountInstance2, jArr2[0], i2);
                    }
                    jArr2[0] = Utilities.random.nextLong();
                    i5 = 0;
                }
                int i7 = i5 + 1;
                long j2 = jArr2[0];
                int i8 = i6;
                int i9 = size;
                Integer[] numArr3 = numArr2;
                long[] jArr3 = jArr2;
                if (!prepareSendingDocumentInternal(accountInstance, (String) arrayList5.get(i6), (String) arrayList2.get(i6), null, str2, j, messageObject, messageObject2, str3, null, messageObject3, jArr3, i7 == i4 || i6 == size + (-1), inputContentInfoCompat == null, z, i, numArr3)) {
                    z2 = true;
                }
                i5 = (j2 != jArr3[0] || jArr3[0] == -1) ? 1 : i7;
                i6 = i8 + 1;
                accountInstance2 = accountInstance;
                arrayList5 = arrayList;
                i2 = i;
                size = i9;
                numArr2 = numArr3;
                jArr2 = jArr3;
                i4 = 10;
                i3 = 1;
            }
            numArr = numArr2;
            jArr = jArr2;
            arrayList4 = arrayList3;
        } else {
            numArr = numArr2;
            jArr = jArr2;
            arrayList4 = arrayList3;
            z2 = false;
        }
        if (arrayList4 != null) {
            jArr[0] = 0;
            int size2 = arrayList3.size();
            int i10 = 0;
            int i11 = 0;
            while (i11 < arrayList3.size()) {
                String str4 = (i11 == 0 && (arrayList == null || arrayList.size() == 0)) ? str : null;
                if (!z3 && size2 > 1 && i10 % 10 == 0) {
                    if (jArr[0] != 0) {
                        finishGroup(accountInstance, jArr[0], i);
                    }
                    jArr[0] = Utilities.random.nextLong();
                    i10 = 0;
                }
                int i12 = i10 + 1;
                long j3 = jArr[0];
                int i13 = i11;
                int i14 = size2;
                if (!prepareSendingDocumentInternal(accountInstance, null, null, (Uri) arrayList4.get(i11), str2, j, messageObject, messageObject2, str4, null, messageObject3, jArr, i12 == 10 || i11 == size2 + (-1), inputContentInfoCompat == null, z, i, numArr)) {
                    z2 = true;
                }
                i10 = (j3 != jArr[0] || jArr[0] == -1) ? 1 : i12;
                i11 = i13 + 1;
                arrayList4 = arrayList3;
                size2 = i14;
            }
        }
        if (inputContentInfoCompat != null) {
            inputContentInfoCompat.releasePermission();
        }
        if (z2) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda72
                @Override // java.lang.Runnable
                public final void run() {
                    SendMessagesHelper.lambda$prepareSendingDocuments$73();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$prepareSendingDocuments$73() {
        try {
            NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.showBulletin, 1, LocaleController.getString("UnsupportedAttachment", ir.medu.shad.R.string.UnsupportedAttachment));
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public static void prepareSendingPhoto(AccountInstance accountInstance, String str, Uri uri, long j, MessageObject messageObject, MessageObject messageObject2, CharSequence charSequence, ArrayList<TLRPC$MessageEntity> arrayList, ArrayList<TLRPC$InputDocument> arrayList2, InputContentInfoCompat inputContentInfoCompat, int i, MessageObject messageObject3, boolean z, int i2) {
        prepareSendingPhoto(accountInstance, str, null, uri, j, messageObject, messageObject2, charSequence, arrayList, arrayList2, inputContentInfoCompat, i, messageObject3, null, z, i2);
    }

    public static void prepareSendingPhoto(AccountInstance accountInstance, String str, String str2, Uri uri, long j, MessageObject messageObject, MessageObject messageObject2, CharSequence charSequence, ArrayList<TLRPC$MessageEntity> arrayList, ArrayList<TLRPC$InputDocument> arrayList2, InputContentInfoCompat inputContentInfoCompat, int i, MessageObject messageObject3, VideoEditedInfo videoEditedInfo, boolean z, int i2) {
        SendingMediaInfo sendingMediaInfo = new SendingMediaInfo();
        sendingMediaInfo.path = str;
        sendingMediaInfo.thumbPath = str2;
        sendingMediaInfo.uri = uri;
        if (charSequence != null) {
            sendingMediaInfo.caption = charSequence.toString();
        }
        sendingMediaInfo.entities = arrayList;
        sendingMediaInfo.ttl = i;
        if (arrayList2 != null) {
            sendingMediaInfo.masks = new ArrayList<>(arrayList2);
        }
        sendingMediaInfo.videoEditedInfo = videoEditedInfo;
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(sendingMediaInfo);
        prepareSendingMedia(accountInstance, arrayList3, j, messageObject, messageObject2, inputContentInfoCompat, false, false, messageObject3, z, i2);
    }

    public static void prepareSendingBotContextResult(final AccountInstance accountInstance, final TLRPC$BotInlineResult tLRPC$BotInlineResult, final HashMap<String, String> map, final long j, final MessageObject messageObject, final MessageObject messageObject2, final boolean z, final int i) {
        if (tLRPC$BotInlineResult == null) {
            return;
        }
        TLRPC$BotInlineMessage tLRPC$BotInlineMessage = tLRPC$BotInlineResult.send_message;
        if (tLRPC$BotInlineMessage instanceof TLRPC$TL_botInlineMessageMediaAuto) {
            new Thread(new Runnable() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    SendMessagesHelper.lambda$prepareSendingBotContextResult$76(j, tLRPC$BotInlineResult, accountInstance, map, messageObject, messageObject2, z, i);
                }
            }).run();
            return;
        }
        if (tLRPC$BotInlineMessage instanceof TLRPC$TL_botInlineMessageText) {
            TLRPC$TL_webPagePending tLRPC$TL_webPagePending = null;
            if (((int) j) == 0) {
                int i2 = 0;
                while (true) {
                    if (i2 >= tLRPC$BotInlineResult.send_message.entities.size()) {
                        break;
                    }
                    TLRPC$MessageEntity tLRPC$MessageEntity = tLRPC$BotInlineResult.send_message.entities.get(i2);
                    if (tLRPC$MessageEntity instanceof TLRPC$TL_messageEntityUrl) {
                        tLRPC$TL_webPagePending = new TLRPC$TL_webPagePending();
                        String str = tLRPC$BotInlineResult.send_message.message;
                        int i3 = tLRPC$MessageEntity.offset;
                        tLRPC$TL_webPagePending.url = str.substring(i3, tLRPC$MessageEntity.length + i3);
                        break;
                    }
                    i2++;
                }
            }
            TLRPC$TL_webPagePending tLRPC$TL_webPagePending2 = tLRPC$TL_webPagePending;
            SendMessagesHelper sendMessagesHelper = accountInstance.getSendMessagesHelper();
            TLRPC$BotInlineMessage tLRPC$BotInlineMessage2 = tLRPC$BotInlineResult.send_message;
            sendMessagesHelper.sendMessage(tLRPC$BotInlineMessage2.message, j, messageObject, messageObject2, tLRPC$TL_webPagePending2, !tLRPC$BotInlineMessage2.no_webpage, tLRPC$BotInlineMessage2.entities, tLRPC$BotInlineMessage2.reply_markup, map, z, i);
            return;
        }
        if (tLRPC$BotInlineMessage instanceof TLRPC$TL_botInlineMessageMediaVenue) {
            TLRPC$TL_messageMediaVenue tLRPC$TL_messageMediaVenue = new TLRPC$TL_messageMediaVenue();
            TLRPC$BotInlineMessage tLRPC$BotInlineMessage3 = tLRPC$BotInlineResult.send_message;
            tLRPC$TL_messageMediaVenue.geo = tLRPC$BotInlineMessage3.geo;
            tLRPC$TL_messageMediaVenue.address = tLRPC$BotInlineMessage3.address;
            tLRPC$TL_messageMediaVenue.title = tLRPC$BotInlineMessage3.title;
            tLRPC$TL_messageMediaVenue.provider = tLRPC$BotInlineMessage3.provider;
            tLRPC$TL_messageMediaVenue.venue_id = tLRPC$BotInlineMessage3.venue_id;
            String str2 = tLRPC$BotInlineMessage3.venue_type;
            tLRPC$TL_messageMediaVenue.venue_id = str2;
            tLRPC$TL_messageMediaVenue.venue_type = str2;
            if (str2 == null) {
                tLRPC$TL_messageMediaVenue.venue_type = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
            }
            accountInstance.getSendMessagesHelper().sendMessage(tLRPC$TL_messageMediaVenue, j, messageObject, messageObject2, tLRPC$BotInlineResult.send_message.reply_markup, map, z, i);
            return;
        }
        if (tLRPC$BotInlineMessage instanceof TLRPC$TL_botInlineMessageMediaGeo) {
            if (tLRPC$BotInlineMessage.period != 0 || tLRPC$BotInlineMessage.proximity_notification_radius != 0) {
                TLRPC$TL_messageMediaGeoLive tLRPC$TL_messageMediaGeoLive = new TLRPC$TL_messageMediaGeoLive();
                TLRPC$BotInlineMessage tLRPC$BotInlineMessage4 = tLRPC$BotInlineResult.send_message;
                int i4 = tLRPC$BotInlineMessage4.period;
                if (i4 == 0) {
                    i4 = DBHelper.GET_STICKER_LIMIT;
                }
                tLRPC$TL_messageMediaGeoLive.period = i4;
                tLRPC$TL_messageMediaGeoLive.geo = tLRPC$BotInlineMessage4.geo;
                tLRPC$TL_messageMediaGeoLive.heading = tLRPC$BotInlineMessage4.heading;
                tLRPC$TL_messageMediaGeoLive.proximity_notification_radius = tLRPC$BotInlineMessage4.proximity_notification_radius;
                accountInstance.getSendMessagesHelper().sendMessage(tLRPC$TL_messageMediaGeoLive, j, messageObject, messageObject2, tLRPC$BotInlineResult.send_message.reply_markup, map, z, i);
                return;
            }
            TLRPC$TL_messageMediaGeo tLRPC$TL_messageMediaGeo = new TLRPC$TL_messageMediaGeo();
            TLRPC$BotInlineMessage tLRPC$BotInlineMessage5 = tLRPC$BotInlineResult.send_message;
            tLRPC$TL_messageMediaGeo.geo = tLRPC$BotInlineMessage5.geo;
            tLRPC$TL_messageMediaGeo.heading = tLRPC$BotInlineMessage5.heading;
            accountInstance.getSendMessagesHelper().sendMessage(tLRPC$TL_messageMediaGeo, j, messageObject, messageObject2, tLRPC$BotInlineResult.send_message.reply_markup, map, z, i);
            return;
        }
        if (tLRPC$BotInlineMessage instanceof TLRPC$TL_botInlineMessageMediaContact) {
            TLRPC$TL_user tLRPC$TL_user = new TLRPC$TL_user();
            TLRPC$BotInlineMessage tLRPC$BotInlineMessage6 = tLRPC$BotInlineResult.send_message;
            tLRPC$TL_user.phone = tLRPC$BotInlineMessage6.phone_number;
            tLRPC$TL_user.first_name = tLRPC$BotInlineMessage6.first_name;
            tLRPC$TL_user.last_name = tLRPC$BotInlineMessage6.last_name;
            TLRPC$TL_restrictionReason tLRPC$TL_restrictionReason = new TLRPC$TL_restrictionReason();
            tLRPC$TL_restrictionReason.text = tLRPC$BotInlineResult.send_message.vcard;
            tLRPC$TL_restrictionReason.platform = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
            tLRPC$TL_restrictionReason.reason = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
            tLRPC$TL_user.restriction_reason.add(tLRPC$TL_restrictionReason);
            accountInstance.getSendMessagesHelper().sendMessage(tLRPC$TL_user, j, messageObject, messageObject2, tLRPC$BotInlineResult.send_message.reply_markup, map, z, i);
            return;
        }
        if (!(tLRPC$BotInlineMessage instanceof TLRPC$TL_botInlineMessageMediaInvoice) || DialogObject.isSecretDialogId(j)) {
            return;
        }
        TLRPC$TL_botInlineMessageMediaInvoice tLRPC$TL_botInlineMessageMediaInvoice = (TLRPC$TL_botInlineMessageMediaInvoice) tLRPC$BotInlineResult.send_message;
        TLRPC$TL_messageMediaInvoice tLRPC$TL_messageMediaInvoice = new TLRPC$TL_messageMediaInvoice();
        tLRPC$TL_messageMediaInvoice.shipping_address_requested = tLRPC$TL_botInlineMessageMediaInvoice.shipping_address_requested;
        tLRPC$TL_messageMediaInvoice.test = tLRPC$TL_botInlineMessageMediaInvoice.test;
        tLRPC$TL_messageMediaInvoice.title = tLRPC$TL_botInlineMessageMediaInvoice.title;
        tLRPC$TL_messageMediaInvoice.description = tLRPC$TL_botInlineMessageMediaInvoice.description;
        TLRPC$WebDocument tLRPC$WebDocument = tLRPC$TL_botInlineMessageMediaInvoice.photo;
        if (tLRPC$WebDocument != null) {
            tLRPC$TL_messageMediaInvoice.webPhoto = tLRPC$WebDocument;
            tLRPC$TL_messageMediaInvoice.flags |= 1;
        }
        tLRPC$TL_messageMediaInvoice.currency = tLRPC$TL_botInlineMessageMediaInvoice.currency;
        tLRPC$TL_messageMediaInvoice.total_amount = tLRPC$TL_botInlineMessageMediaInvoice.total_amount;
        tLRPC$TL_messageMediaInvoice.start_param = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
        accountInstance.getSendMessagesHelper().sendMessage(tLRPC$TL_messageMediaInvoice, j, messageObject, messageObject2, tLRPC$BotInlineResult.send_message.reply_markup, map, z, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0445  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x044b  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0457  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x04a3  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01bb  */
    /* JADX WARN: Type inference failed for: r0v98, types: [org.rbmain.tgnet.TLRPC$TL_game] */
    /* JADX WARN: Type inference failed for: r16v8, types: [org.rbmain.tgnet.TLRPC$TL_game] */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v35, types: [org.rbmain.tgnet.TLObject, org.rbmain.tgnet.TLRPC$Document, org.rbmain.tgnet.TLRPC$TL_document] */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v37 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void lambda$prepareSendingBotContextResult$76(final long r21, final org.rbmain.tgnet.TLRPC$BotInlineResult r23, final org.rbmain.messenger.AccountInstance r24, final java.util.HashMap r25, final org.rbmain.messenger.MessageObject r26, final org.rbmain.messenger.MessageObject r27, final boolean r28, final int r29) {
        /*
            Method dump skipped, instructions count: 1350
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.SendMessagesHelper.lambda$prepareSendingBotContextResult$76(long, org.rbmain.tgnet.TLRPC$BotInlineResult, org.rbmain.messenger.AccountInstance, java.util.HashMap, org.rbmain.messenger.MessageObject, org.rbmain.messenger.MessageObject, boolean, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$prepareSendingBotContextResult$75(TLRPC$TL_document tLRPC$TL_document, Bitmap[] bitmapArr, String[] strArr, AccountInstance accountInstance, String str, long j, MessageObject messageObject, MessageObject messageObject2, TLRPC$BotInlineResult tLRPC$BotInlineResult, HashMap map, boolean z, int i, TLRPC$TL_photo tLRPC$TL_photo, TLRPC$TL_game tLRPC$TL_game) {
        if (tLRPC$TL_document != null) {
            if (bitmapArr[0] != null && strArr[0] != null) {
                ImageLoader.getInstance().putImageToCache(new BitmapDrawable(bitmapArr[0]), strArr[0], false);
            }
            SendMessagesHelper sendMessagesHelper = accountInstance.getSendMessagesHelper();
            TLRPC$BotInlineMessage tLRPC$BotInlineMessage = tLRPC$BotInlineResult.send_message;
            sendMessagesHelper.sendMessage(tLRPC$TL_document, null, str, j, messageObject, messageObject2, tLRPC$BotInlineMessage.message, tLRPC$BotInlineMessage.entities, tLRPC$BotInlineMessage.reply_markup, map, z, i, 0, tLRPC$BotInlineResult);
            return;
        }
        if (tLRPC$TL_photo == null) {
            if (tLRPC$TL_game != null) {
                accountInstance.getSendMessagesHelper().sendMessage(tLRPC$TL_game, j, tLRPC$BotInlineResult.send_message.reply_markup, map, z, i);
            }
        } else {
            SendMessagesHelper sendMessagesHelper2 = accountInstance.getSendMessagesHelper();
            TLRPC$WebDocument tLRPC$WebDocument = tLRPC$BotInlineResult.content;
            String str2 = tLRPC$WebDocument != null ? tLRPC$WebDocument.url : null;
            TLRPC$BotInlineMessage tLRPC$BotInlineMessage2 = tLRPC$BotInlineResult.send_message;
            sendMessagesHelper2.sendMessage(tLRPC$TL_photo, str2, j, messageObject, messageObject2, tLRPC$BotInlineMessage2.message, tLRPC$BotInlineMessage2.entities, tLRPC$BotInlineMessage2.reply_markup, map, z, i, 0, tLRPC$BotInlineResult);
        }
    }

    private static String getTrimmedString(String str) {
        String strTrim = str.trim();
        if (strTrim.length() == 0) {
            return strTrim;
        }
        while (str.startsWith("\n")) {
            str = str.substring(1);
        }
        while (str.endsWith("\n")) {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$prepareSendingText$78(final String str, final AccountInstance accountInstance, final long j, final boolean z, final int i) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                SendMessagesHelper.lambda$prepareSendingText$77(str, accountInstance, j, z, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$prepareSendingText$79(final String str, final AccountInstance accountInstance, final long j, final boolean z, final int i) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                SendMessagesHelper.lambda$prepareSendingText$78(str, accountInstance, j, z, i);
            }
        });
    }

    public static void prepareSendingText(final AccountInstance accountInstance, final String str, final long j, final boolean z, final int i) {
        accountInstance.getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                SendMessagesHelper.lambda$prepareSendingText$79(str, accountInstance, j, z, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$prepareSendingText$77(String str, AccountInstance accountInstance, long j, boolean z, int i) {
        String trimmedString = getTrimmedString(str);
        if (trimmedString.length() != 0) {
            int iCeil = (int) Math.ceil(trimmedString.length() / 4096.0f);
            int i2 = 0;
            while (i2 < iCeil) {
                int i3 = i2 * 4096;
                i2++;
                accountInstance.getSendMessagesHelper().sendMessage(trimmedString.substring(i3, Math.min(i2 * 4096, trimmedString.length())), j, (MessageObject) null, (MessageObject) null, (TLRPC$WebPage) null, true, (ArrayList<TLRPC$MessageEntity>) null, (TLRPC$ReplyMarkup) null, (HashMap<String, String>) null, z, i);
            }
        }
    }

    public static void ensureMediaThumbExists(boolean z, TLObject tLObject, String str, Uri uri, long j) {
        TLRPC$PhotoSize tLRPC$PhotoSizeScaleAndSaveImage;
        TLRPC$PhotoSize tLRPC$PhotoSizeScaleAndSaveImage2;
        if (tLObject instanceof TLRPC$TL_photo) {
            TLRPC$TL_photo tLRPC$TL_photo = (TLRPC$TL_photo) tLObject;
            TLRPC$PhotoSize closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(tLRPC$TL_photo.sizes, 90);
            boolean zExists = ((closestPhotoSizeWithSize instanceof TLRPC$TL_photoStrippedSize) || (closestPhotoSizeWithSize instanceof TLRPC$TL_photoPathSize)) ? true : FileLoader.getPathToAttach(closestPhotoSizeWithSize, true).exists();
            TLRPC$PhotoSize closestPhotoSizeWithSize2 = FileLoader.getClosestPhotoSizeWithSize(tLRPC$TL_photo.sizes, AndroidUtilities.getPhotoSize());
            boolean zExists2 = FileLoader.getPathToAttach(closestPhotoSizeWithSize2, false).exists();
            if (zExists && zExists2) {
                return;
            }
            Bitmap bitmapLoadBitmap = ImageLoader.loadBitmap(str, uri, AndroidUtilities.getPhotoSize(), AndroidUtilities.getPhotoSize(), true);
            if (bitmapLoadBitmap == null) {
                bitmapLoadBitmap = ImageLoader.loadBitmap(str, uri, 800.0f, 800.0f, true);
            }
            Bitmap bitmap = bitmapLoadBitmap;
            if (!zExists2 && (tLRPC$PhotoSizeScaleAndSaveImage2 = ImageLoader.scaleAndSaveImage(closestPhotoSizeWithSize2, bitmap, Bitmap.CompressFormat.JPEG, true, AndroidUtilities.getPhotoSize(), AndroidUtilities.getPhotoSize(), 80, false, 101, 101, false)) != closestPhotoSizeWithSize2) {
                tLRPC$TL_photo.sizes.add(0, tLRPC$PhotoSizeScaleAndSaveImage2);
            }
            if (!zExists && (tLRPC$PhotoSizeScaleAndSaveImage = ImageLoader.scaleAndSaveImage(closestPhotoSizeWithSize, bitmap, 90.0f, 90.0f, 55, true, false)) != closestPhotoSizeWithSize) {
                tLRPC$TL_photo.sizes.add(0, tLRPC$PhotoSizeScaleAndSaveImage);
            }
            if (bitmap != null) {
                bitmap.recycle();
                return;
            }
            return;
        }
        if (tLObject instanceof TLRPC$TL_document) {
            TLRPC$TL_document tLRPC$TL_document = (TLRPC$TL_document) tLObject;
            if ((MessageObject.isVideoDocument(tLRPC$TL_document) || MessageObject.isNewGifDocument(tLRPC$TL_document)) && MessageObject.isDocumentHasThumb(tLRPC$TL_document)) {
                TLRPC$PhotoSize closestPhotoSizeWithSize3 = FileLoader.getClosestPhotoSizeWithSize(tLRPC$TL_document.thumbs, 320);
                if ((closestPhotoSizeWithSize3 instanceof TLRPC$TL_photoStrippedSize) || (closestPhotoSizeWithSize3 instanceof TLRPC$TL_photoPathSize) || FileLoader.getPathToAttach(closestPhotoSizeWithSize3, true).exists()) {
                    return;
                }
                Bitmap bitmapCreateVideoThumbnailAtTime = createVideoThumbnailAtTime(str, j);
                Bitmap bitmapCreateVideoThumbnail = bitmapCreateVideoThumbnailAtTime == null ? createVideoThumbnail(str, 1) : bitmapCreateVideoThumbnailAtTime;
                int i = z ? 90 : 320;
                float f = i;
                tLRPC$TL_document.thumbs.set(0, ImageLoader.scaleAndSaveImage(closestPhotoSizeWithSize3, bitmapCreateVideoThumbnail, f, f, i > 90 ? 80 : 55, false, true));
            }
        }
    }

    public static String getKeyForPhotoSize(TLRPC$PhotoSize tLRPC$PhotoSize, Bitmap[] bitmapArr, boolean z, boolean z2) {
        if (tLRPC$PhotoSize == null || tLRPC$PhotoSize.location == null) {
            return null;
        }
        Point messageSize = ChatMessageCell.getMessageSize(tLRPC$PhotoSize.w, tLRPC$PhotoSize.h);
        if (bitmapArr != null) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                File pathToAttach = FileLoader.getPathToAttach(tLRPC$PhotoSize, z2);
                FileInputStream fileInputStream = new FileInputStream(pathToAttach);
                BitmapFactory.decodeStream(fileInputStream, null, options);
                fileInputStream.close();
                float fMax = Math.max(options.outWidth / messageSize.x, options.outHeight / messageSize.y);
                if (fMax < 1.0f) {
                    fMax = 1.0f;
                }
                options.inJustDecodeBounds = false;
                options.inSampleSize = (int) fMax;
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                if (Build.VERSION.SDK_INT >= 21) {
                    FileInputStream fileInputStream2 = new FileInputStream(pathToAttach);
                    bitmapArr[0] = BitmapFactory.decodeStream(fileInputStream2, null, options);
                    fileInputStream2.close();
                }
            } catch (Throwable unused) {
            }
        }
        return String.format(Locale.US, z ? "%d_%d@%d_%d_b" : "%d_%d@%d_%d", Long.valueOf(tLRPC$PhotoSize.location.volume_id), Integer.valueOf(tLRPC$PhotoSize.location.local_id), Integer.valueOf((int) (messageSize.x / AndroidUtilities.density)), Integer.valueOf((int) (messageSize.y / AndroidUtilities.density)));
    }

    public static void prepareSendingMedia(final AccountInstance accountInstance, final ArrayList<SendingMediaInfo> arrayList, final long j, final MessageObject messageObject, final MessageObject messageObject2, final InputContentInfoCompat inputContentInfoCompat, final boolean z, boolean z2, final MessageObject messageObject3, final boolean z3, final int i) {
        final boolean z4;
        if (arrayList.isEmpty()) {
            return;
        }
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                z4 = z2;
                break;
            } else {
                if (arrayList.get(i2).ttl > 0) {
                    z4 = false;
                    break;
                }
                i2++;
            }
        }
        mediaSendQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                SendMessagesHelper.lambda$prepareSendingMedia$85(arrayList, j, accountInstance, z, z4, messageObject3, messageObject, messageObject2, z3, i, inputContentInfoCompat);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(14:355|(1:360)(1:359)|361|(4:363|(2:366|364)|649|367)(1:368)|(1:370)|371|(1:373)|(1:375)|(4:641|377|378|(0)(3:381|(3:396|(2:398|(0)(1:401))(1:402)|403)(1:404)|405))(1:384)|627|385|(3:387|631|388)(0)|(0)(0)|405) */
    /* JADX WARN: Code restructure failed: missing block: B:392:0x08de, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02e8 A[Catch: Exception -> 0x02d9, TryCatch #12 {Exception -> 0x02d9, blocks: (B:126:0x02d1, B:133:0x02de, B:135:0x02e8, B:136:0x02f3), top: B:637:0x02d1 }] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02f3 A[Catch: Exception -> 0x02d9, TRY_LEAVE, TryCatch #12 {Exception -> 0x02d9, blocks: (B:126:0x02d1, B:133:0x02de, B:135:0x02e8, B:136:0x02f3), top: B:637:0x02d1 }] */
    /* JADX WARN: Removed duplicated region for block: B:154:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x04c5 A[PHI: r0
      0x04c5: PHI (r0v148 org.rbmain.tgnet.TLRPC$TL_photo) = (r0v147 org.rbmain.tgnet.TLRPC$TL_photo), (r0v150 org.rbmain.tgnet.TLRPC$TL_photo) binds: [B:179:0x044d, B:183:0x048c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0666  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x06bd  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x06c1  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x06cb  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x06d1  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x072a  */
    /* JADX WARN: Removed duplicated region for block: B:381:0x08c2  */
    /* JADX WARN: Removed duplicated region for block: B:396:0x08e5  */
    /* JADX WARN: Removed duplicated region for block: B:404:0x091d  */
    /* JADX WARN: Removed duplicated region for block: B:474:0x0b4b  */
    /* JADX WARN: Removed duplicated region for block: B:525:0x0c3c  */
    /* JADX WARN: Removed duplicated region for block: B:527:0x0c49  */
    /* JADX WARN: Removed duplicated region for block: B:531:0x0c56  */
    /* JADX WARN: Removed duplicated region for block: B:537:0x0c69  */
    /* JADX WARN: Removed duplicated region for block: B:539:0x0c75  */
    /* JADX WARN: Removed duplicated region for block: B:546:0x0cb2  */
    /* JADX WARN: Removed duplicated region for block: B:549:0x0cb9  */
    /* JADX WARN: Removed duplicated region for block: B:551:0x0cc0  */
    /* JADX WARN: Removed duplicated region for block: B:553:0x0cc7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:562:0x0cfd  */
    /* JADX WARN: Removed duplicated region for block: B:571:0x0d3c A[LOOP:3: B:569:0x0d34->B:571:0x0d3c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:615:0x0646 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:623:0x062e A[EXC_TOP_SPLITTER, PHI: r6 r12
      0x062e: PHI (r6v42 java.io.FileOutputStream) = 
      (r6v41 java.io.FileOutputStream)
      (r6v46 java.io.FileOutputStream)
      (r6v46 java.io.FileOutputStream)
      (r6v46 java.io.FileOutputStream)
     binds: [B:251:0x064b, B:232:0x0629, B:611:0x062e, B:233:0x062b] A[DONT_GENERATE, DONT_INLINE]
      0x062e: PHI (r12v17 java.lang.String) = (r12v16 java.lang.String), (r12v19 java.lang.String), (r12v19 java.lang.String), (r12v19 java.lang.String) binds: [B:251:0x064b, B:232:0x0629, B:611:0x062e, B:233:0x062b] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:625:0x0300 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:650:0x0c66 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x016d  */
    /* JADX WARN: Type inference failed for: r23v10 */
    /* JADX WARN: Type inference failed for: r23v6 */
    /* JADX WARN: Type inference failed for: r23v7 */
    /* JADX WARN: Type inference failed for: r23v9 */
    /* JADX WARN: Type inference failed for: r3v42 */
    /* JADX WARN: Type inference failed for: r3v43, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v52 */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v25, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v34 */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void lambda$prepareSendingMedia$85(java.util.ArrayList r67, final long r68, final org.rbmain.messenger.AccountInstance r70, boolean r71, boolean r72, final org.rbmain.messenger.MessageObject r73, final org.rbmain.messenger.MessageObject r74, final org.rbmain.messenger.MessageObject r75, final boolean r76, final int r77, androidx.core.view.inputmethod.InputContentInfoCompat r78) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 3846
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.SendMessagesHelper.lambda$prepareSendingMedia$85(java.util.ArrayList, long, org.rbmain.messenger.AccountInstance, boolean, boolean, org.rbmain.messenger.MessageObject, org.rbmain.messenger.MessageObject, org.rbmain.messenger.MessageObject, boolean, int, androidx.core.view.inputmethod.InputContentInfoCompat):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$prepareSendingMedia$80(MediaSendPrepareWorker mediaSendPrepareWorker, AccountInstance accountInstance, SendingMediaInfo sendingMediaInfo, boolean z) {
        mediaSendPrepareWorker.photo = accountInstance.getSendMessagesHelper().generatePhotoSizes(sendingMediaInfo.path, sendingMediaInfo.uri);
        if (z && sendingMediaInfo.canDeleteAfter) {
            new File(sendingMediaInfo.path).delete();
        }
        mediaSendPrepareWorker.sync.countDown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$prepareSendingMedia$81(MessageObject messageObject, AccountInstance accountInstance, TLRPC$TL_document tLRPC$TL_document, String str, HashMap map, String str2, long j, MessageObject messageObject2, MessageObject messageObject3, SendingMediaInfo sendingMediaInfo, boolean z, int i) {
        if (messageObject != null) {
            accountInstance.getSendMessagesHelper().editMessage(messageObject, null, null, tLRPC$TL_document, str, map, false, str2);
        } else {
            accountInstance.getSendMessagesHelper().sendMessage(tLRPC$TL_document, null, str, j, messageObject2, messageObject3, sendingMediaInfo.caption, sendingMediaInfo.entities, null, map, z, i, 0, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$prepareSendingMedia$82(MessageObject messageObject, AccountInstance accountInstance, TLRPC$TL_photo tLRPC$TL_photo, boolean z, SendingMediaInfo sendingMediaInfo, HashMap map, String str, long j, MessageObject messageObject2, MessageObject messageObject3, boolean z2, int i) {
        if (messageObject != null) {
            accountInstance.getSendMessagesHelper().editMessage(messageObject, tLRPC$TL_photo, null, null, z ? sendingMediaInfo.searchImage.imageUrl : null, map, false, str);
        } else {
            accountInstance.getSendMessagesHelper().sendMessage(tLRPC$TL_photo, z ? sendingMediaInfo.searchImage.imageUrl : null, j, messageObject2, messageObject3, sendingMediaInfo.caption, sendingMediaInfo.entities, null, map, z2, i, sendingMediaInfo.ttl, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$prepareSendingMedia$83(Bitmap bitmap, String str, MessageObject messageObject, AccountInstance accountInstance, VideoEditedInfo videoEditedInfo, TLRPC$TL_document tLRPC$TL_document, String str2, HashMap map, String str3, long j, MessageObject messageObject2, MessageObject messageObject3, SendingMediaInfo sendingMediaInfo, boolean z, int i) {
        if (bitmap != null && str != null) {
            ImageLoader.getInstance().putImageToCache(new BitmapDrawable(bitmap), str, false);
        }
        if (messageObject != null) {
            accountInstance.getSendMessagesHelper().editMessage(messageObject, null, videoEditedInfo, tLRPC$TL_document, str2, map, false, str3);
        } else {
            accountInstance.getSendMessagesHelper().sendMessage(tLRPC$TL_document, videoEditedInfo, str2, j, messageObject2, messageObject3, sendingMediaInfo.caption, sendingMediaInfo.entities, null, map, z, i, sendingMediaInfo.ttl, str3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$prepareSendingMedia$84(Bitmap[] bitmapArr, String[] strArr, MessageObject messageObject, AccountInstance accountInstance, TLRPC$TL_photo tLRPC$TL_photo, HashMap map, String str, long j, MessageObject messageObject2, MessageObject messageObject3, SendingMediaInfo sendingMediaInfo, boolean z, int i) {
        if (bitmapArr[0] != null && strArr[0] != null) {
            ImageLoader.getInstance().putImageToCache(new BitmapDrawable(bitmapArr[0]), strArr[0], false);
        }
        if (messageObject != null) {
            accountInstance.getSendMessagesHelper().editMessage(messageObject, tLRPC$TL_photo, null, null, null, map, false, str);
        } else {
            accountInstance.getSendMessagesHelper().sendMessage(tLRPC$TL_photo, null, j, messageObject2, messageObject3, sendingMediaInfo.caption, sendingMediaInfo.entities, null, map, z, i, sendingMediaInfo.ttl, str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x008b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void fillVideoAttribute(java.lang.String r5, org.rbmain.tgnet.TLRPC$TL_documentAttributeVideo r6, org.rbmain.messenger.VideoEditedInfo r7) throws java.lang.Throwable {
        /*
            r0 = 1148846080(0x447a0000, float:1000.0)
            r1 = 0
            android.media.MediaMetadataRetriever r2 = new android.media.MediaMetadataRetriever     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            r2.<init>()     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            r2.setDataSource(r5)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
            r1 = 18
            java.lang.String r1 = r2.extractMetadata(r1)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
            if (r1 == 0) goto L19
            int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
            r6.w = r1     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
        L19:
            r1 = 19
            java.lang.String r1 = r2.extractMetadata(r1)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
            if (r1 == 0) goto L27
            int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
            r6.h = r1     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
        L27:
            r1 = 9
            java.lang.String r1 = r2.extractMetadata(r1)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
            if (r1 == 0) goto L3d
            long r3 = java.lang.Long.parseLong(r1)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
            float r1 = (float) r3     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
            float r1 = r1 / r0
            double r3 = (double) r1     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
            double r3 = java.lang.Math.ceil(r3)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
            int r1 = (int) r3     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
            r6.duration = r1     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
        L3d:
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
            r3 = 17
            if (r1 < r3) goto L68
            r1 = 24
            java.lang.String r1 = r2.extractMetadata(r1)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
            if (r1 == 0) goto L68
            java.lang.Integer r1 = org.rbmain.messenger.Utilities.parseInt(r1)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
            int r1 = r1.intValue()     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
            if (r7 == 0) goto L58
            r7.rotationValue = r1     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
            goto L68
        L58:
            r7 = 90
            if (r1 == r7) goto L60
            r7 = 270(0x10e, float:3.78E-43)
            if (r1 != r7) goto L68
        L60:
            int r7 = r6.w     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
            int r1 = r6.h     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
            r6.w = r1     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
            r6.h = r7     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
        L68:
            r7 = 1
            r2.release()     // Catch: java.lang.Exception -> L6d
            goto L89
        L6d:
            r1 = move-exception
            org.rbmain.messenger.FileLog.e(r1)
            goto L89
        L72:
            r5 = move-exception
            r1 = r2
            goto Lbf
        L75:
            r7 = move-exception
            r1 = r2
            goto L7b
        L78:
            r5 = move-exception
            goto Lbf
        L7a:
            r7 = move-exception
        L7b:
            org.rbmain.messenger.FileLog.e(r7)     // Catch: java.lang.Throwable -> L78
            if (r1 == 0) goto L88
            r1.release()     // Catch: java.lang.Exception -> L84
            goto L88
        L84:
            r7 = move-exception
            org.rbmain.messenger.FileLog.e(r7)
        L88:
            r7 = 0
        L89:
            if (r7 != 0) goto Lbe
            android.content.Context r7 = org.rbmain.messenger.ApplicationLoader.applicationContext     // Catch: java.lang.Exception -> Lba
            java.io.File r1 = new java.io.File     // Catch: java.lang.Exception -> Lba
            r1.<init>(r5)     // Catch: java.lang.Exception -> Lba
            android.net.Uri r5 = android.net.Uri.fromFile(r1)     // Catch: java.lang.Exception -> Lba
            android.media.MediaPlayer r5 = android.media.MediaPlayer.create(r7, r5)     // Catch: java.lang.Exception -> Lba
            if (r5 == 0) goto Lbe
            int r7 = r5.getDuration()     // Catch: java.lang.Exception -> Lba
            float r7 = (float) r7     // Catch: java.lang.Exception -> Lba
            float r7 = r7 / r0
            double r0 = (double) r7     // Catch: java.lang.Exception -> Lba
            double r0 = java.lang.Math.ceil(r0)     // Catch: java.lang.Exception -> Lba
            int r7 = (int) r0     // Catch: java.lang.Exception -> Lba
            r6.duration = r7     // Catch: java.lang.Exception -> Lba
            int r7 = r5.getVideoWidth()     // Catch: java.lang.Exception -> Lba
            r6.w = r7     // Catch: java.lang.Exception -> Lba
            int r7 = r5.getVideoHeight()     // Catch: java.lang.Exception -> Lba
            r6.h = r7     // Catch: java.lang.Exception -> Lba
            r5.release()     // Catch: java.lang.Exception -> Lba
            goto Lbe
        Lba:
            r5 = move-exception
            org.rbmain.messenger.FileLog.e(r5)
        Lbe:
            return
        Lbf:
            if (r1 == 0) goto Lc9
            r1.release()     // Catch: java.lang.Exception -> Lc5
            goto Lc9
        Lc5:
            r6 = move-exception
            org.rbmain.messenger.FileLog.e(r6)
        Lc9:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.SendMessagesHelper.fillVideoAttribute(java.lang.String, org.rbmain.tgnet.TLRPC$TL_documentAttributeVideo, org.rbmain.messenger.VideoEditedInfo):void");
    }

    public static Bitmap createVideoThumbnail(String str, int i) {
        float f = i == 2 ? 1920.0f : i == 3 ? 96.0f : 512.0f;
        Bitmap bitmapCreateVideoThumbnailAtTime = createVideoThumbnailAtTime(str, 0L);
        if (bitmapCreateVideoThumbnailAtTime == null) {
            return bitmapCreateVideoThumbnailAtTime;
        }
        int width = bitmapCreateVideoThumbnailAtTime.getWidth();
        int height = bitmapCreateVideoThumbnailAtTime.getHeight();
        float f2 = width;
        if (f2 <= f && height <= f) {
            return bitmapCreateVideoThumbnailAtTime;
        }
        float fMax = Math.max(width, height) / f;
        return Bitmap.createScaledBitmap(bitmapCreateVideoThumbnailAtTime, (int) (f2 / fMax), (int) (height / fMax), true);
    }

    public static Bitmap createVideoThumbnailAtTime(String str, long j) {
        return createVideoThumbnailAtTime(str, j, null, false);
    }

    public static Bitmap createVideoThumbnailAtTime(String str, long j, int[] iArr, boolean z) {
        Bitmap frameAtTime;
        if (z) {
            AnimatedFileDrawable animatedFileDrawable = new AnimatedFileDrawable(new File(str), true, 0L, 0, null, null, null, 0L, 0, true, null);
            frameAtTime = animatedFileDrawable.getFrameAtTime(j, z);
            if (iArr != null) {
                iArr[0] = animatedFileDrawable.getOrientation();
            }
            animatedFileDrawable.recycle();
            if (frameAtTime == null) {
                return createVideoThumbnailAtTime(str, j, iArr, false);
            }
        } else {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            frameAtTime = null;
            try {
                try {
                    mediaMetadataRetriever.setDataSource(str);
                    Bitmap frameAtTime2 = mediaMetadataRetriever.getFrameAtTime(j, 1);
                    if (frameAtTime2 == null) {
                        try {
                            frameAtTime2 = mediaMetadataRetriever.getFrameAtTime(j, 3);
                        } catch (Exception unused) {
                        }
                    }
                    frameAtTime = frameAtTime2;
                } finally {
                    try {
                        mediaMetadataRetriever.release();
                    } catch (RuntimeException unused2) {
                    }
                }
            } catch (Exception unused3) {
            }
        }
        return frameAtTime;
    }

    private static VideoEditedInfo createCompressionSettings(String str) throws IOException, IllegalArgumentException {
        MediaCodecInfo mediaCodecInfoSelectCodec;
        int iMakeVideoBitrate;
        int[] iArr = new int[11];
        AnimatedFileDrawable.getVideoInfo(str, iArr);
        if (iArr[0] == 0) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("video hasn't avc1 atom");
            }
            return null;
        }
        int videoBitrate = MediaController.getVideoBitrate(str);
        if (videoBitrate == -1) {
            videoBitrate = iArr[3];
        }
        float f = iArr[4];
        long j = iArr[6];
        long j2 = iArr[5];
        int i = iArr[7];
        if (Build.VERSION.SDK_INT < 18) {
            try {
                mediaCodecInfoSelectCodec = MediaController.selectCodec(MediaController.VIDEO_MIME_TYPE);
            } catch (Exception unused) {
            }
            if (mediaCodecInfoSelectCodec == null) {
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("no codec info for video/avc");
                }
                return null;
            }
            String name = mediaCodecInfoSelectCodec.getName();
            if (!name.equals("OMX.google.h264.encoder") && !name.equals("OMX.ST.VFM.H264Enc") && !name.equals("OMX.Exynos.avc.enc") && !name.equals("OMX.MARVELL.VIDEO.HW.CODA7542ENCODER") && !name.equals("OMX.MARVELL.VIDEO.H264ENCODER") && !name.equals("OMX.k3.video.encoder.avc") && !name.equals("OMX.TI.DUCATI1.VIDEO.H264E")) {
                if (MediaController.selectColorFormat(mediaCodecInfoSelectCodec, MediaController.VIDEO_MIME_TYPE) == 0) {
                    if (BuildVars.LOGS_ENABLED) {
                        FileLog.d("no color format for video/avc");
                    }
                    return null;
                }
            }
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("unsupported encoder = " + name);
            }
            return null;
        }
        VideoEditedInfo videoEditedInfo = new VideoEditedInfo();
        videoEditedInfo.startTime = -1L;
        videoEditedInfo.endTime = -1L;
        videoEditedInfo.bitrate = videoBitrate;
        videoEditedInfo.originalPath = str;
        videoEditedInfo.framerate = i;
        videoEditedInfo.estimatedDuration = (long) Math.ceil(f);
        int i2 = iArr[1];
        videoEditedInfo.originalWidth = i2;
        videoEditedInfo.resultWidth = i2;
        int i3 = iArr[2];
        videoEditedInfo.originalHeight = i3;
        videoEditedInfo.resultHeight = i3;
        videoEditedInfo.rotationValue = iArr[8];
        videoEditedInfo.originalDuration = (long) (f * 1000.0f);
        float fMax = Math.max(i2, i3);
        float f2 = 640.0f;
        int i4 = fMax > 1280.0f ? 4 : fMax > 854.0f ? 3 : fMax > 640.0f ? 2 : 1;
        int iRound = Math.round(DownloadController.getInstance(UserConfig.selectedAccount).getMaxVideoBitrate() / (100.0f / i4)) - 1;
        if (iRound >= i4) {
            iRound = i4 - 1;
        }
        int i5 = i4 - 1;
        if (iRound != i5) {
            if (iRound == 1) {
                f2 = 432.0f;
            } else if (iRound != 2) {
                f2 = iRound != 3 ? 1280.0f : 848.0f;
            }
            int i6 = videoEditedInfo.originalWidth;
            int i7 = videoEditedInfo.originalHeight;
            float f3 = f2 / (i6 > i7 ? i6 : i7);
            videoEditedInfo.resultWidth = Math.round((i6 * f3) / 2.0f) * 2;
            int iRound2 = Math.round((videoEditedInfo.originalHeight * f3) / 2.0f) * 2;
            videoEditedInfo.resultHeight = iRound2;
            iMakeVideoBitrate = MediaController.makeVideoBitrate(videoEditedInfo.originalHeight, videoEditedInfo.originalWidth, videoBitrate, iRound2, videoEditedInfo.resultWidth);
        } else {
            iMakeVideoBitrate = videoBitrate;
        }
        if (iRound == i5) {
            videoEditedInfo.resultWidth = videoEditedInfo.originalWidth;
            videoEditedInfo.resultHeight = videoEditedInfo.originalHeight;
            videoEditedInfo.bitrate = videoBitrate;
            videoEditedInfo.estimatedSize = (int) new File(str).length();
        } else {
            videoEditedInfo.bitrate = iMakeVideoBitrate;
            long j3 = (int) (j2 + j);
            videoEditedInfo.estimatedSize = j3;
            videoEditedInfo.estimatedSize = j3 + ((j3 / 32768) * 16);
        }
        if (videoEditedInfo.estimatedSize == 0) {
            videoEditedInfo.estimatedSize = 1L;
        }
        return videoEditedInfo;
    }

    public static void prepareSendingVideo(final AccountInstance accountInstance, final String str, final VideoEditedInfo videoEditedInfo, final long j, final MessageObject messageObject, final MessageObject messageObject2, final CharSequence charSequence, final ArrayList<TLRPC$MessageEntity> arrayList, final int i, final MessageObject messageObject3, final boolean z, final int i2) {
        if (str == null || str.length() == 0) {
            return;
        }
        new Thread(new Runnable() { // from class: org.rbmain.messenger.SendMessagesHelper$$ExternalSyntheticLambda69
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                SendMessagesHelper.lambda$prepareSendingVideo$87(videoEditedInfo, str, j, i, accountInstance, charSequence, messageObject3, messageObject, messageObject2, arrayList, z, i2);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:55:0x011a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void lambda$prepareSendingVideo$87(org.rbmain.messenger.VideoEditedInfo r30, java.lang.String r31, final long r32, final int r34, final org.rbmain.messenger.AccountInstance r35, java.lang.CharSequence r36, final org.rbmain.messenger.MessageObject r37, final org.rbmain.messenger.MessageObject r38, final org.rbmain.messenger.MessageObject r39, final java.util.ArrayList r40, final boolean r41, final int r42) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 911
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.SendMessagesHelper.lambda$prepareSendingVideo$87(org.rbmain.messenger.VideoEditedInfo, java.lang.String, long, int, org.rbmain.messenger.AccountInstance, java.lang.CharSequence, org.rbmain.messenger.MessageObject, org.rbmain.messenger.MessageObject, org.rbmain.messenger.MessageObject, java.util.ArrayList, boolean, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$prepareSendingVideo$86(Bitmap bitmap, String str, MessageObject messageObject, AccountInstance accountInstance, VideoEditedInfo videoEditedInfo, TLRPC$TL_document tLRPC$TL_document, String str2, HashMap map, String str3, long j, MessageObject messageObject2, MessageObject messageObject3, String str4, ArrayList arrayList, boolean z, int i, int i2) {
        if (bitmap != null && str != null) {
            ImageLoader.getInstance().putImageToCache(new BitmapDrawable(bitmap), str, false);
        }
        if (messageObject != null) {
            accountInstance.getSendMessagesHelper().editMessage(messageObject, null, videoEditedInfo, tLRPC$TL_document, str2, map, false, str3);
        } else {
            accountInstance.getSendMessagesHelper().sendMessage(tLRPC$TL_document, videoEditedInfo, str2, j, messageObject2, messageObject3, str4, arrayList, null, map, z, i, i2, str3);
        }
    }

    public void processUploadedMedia(ArrayList<DelayedMessage> arrayList, TLRPC$InputFile tLRPC$InputFile) {
        String str = tLRPC$InputFile.access_hash_rec;
        if (str == null || str.isEmpty()) {
            return;
        }
        Iterator<DelayedMessage> it = arrayList.iterator();
        while (it.hasNext()) {
            DelayedMessage next = it.next();
            TLRPC$MessageMedia tLRPC$MessageMedia = next.obj.messageOwner.media;
            TLRPC$Photo tLRPC$Photo = tLRPC$MessageMedia.photo;
            if (tLRPC$Photo != null) {
                tLRPC$Photo.access_hash = IdStorage.getInstance().generateAccessHash(tLRPC$InputFile.access_hash_rec);
                TLRPC$Photo tLRPC$Photo2 = tLRPC$MessageMedia.photo;
                tLRPC$Photo2.id = tLRPC$InputFile.id;
                tLRPC$Photo2.dc_id = IdStorage.getInstance().generateDcId(tLRPC$InputFile.dc_id);
            } else {
                TLRPC$Document tLRPC$Document = tLRPC$MessageMedia.document;
                if (tLRPC$Document != null) {
                    tLRPC$Document.access_hash = IdStorage.getInstance().generateAccessHash(tLRPC$InputFile.access_hash_rec);
                    TLRPC$Document tLRPC$Document2 = tLRPC$MessageMedia.document;
                    tLRPC$Document2.id = tLRPC$InputFile.id;
                    tLRPC$Document2.dc_id = IdStorage.getInstance().generateDcId(tLRPC$InputFile.dc_id);
                }
            }
            getMessagesProxy().addDelayedMessageToLocalDb(next.obj.messageOwner, false);
        }
    }
}
