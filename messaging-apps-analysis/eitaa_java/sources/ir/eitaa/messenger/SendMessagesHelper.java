package ir.eitaa.messenger;

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
import android.text.TextUtils;
import android.util.SparseArray;
import android.webkit.MimeTypeMap;
import android.widget.Toast;
import androidx.collection.LongSparseArray;
import androidx.core.view.inputmethod.InputContentInfoCompat;
import ir.eitaa.messenger.MediaController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.MessagesStorage;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.NativeByteBuffer;
import ir.eitaa.tgnet.QuickAckDelegate;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.SerializedData;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$BotInlineMessage;
import ir.eitaa.tgnet.TLRPC$BotInlineResult;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$DecryptedMessage;
import ir.eitaa.tgnet.TLRPC$DecryptedMessageAction;
import ir.eitaa.tgnet.TLRPC$DecryptedMessageMedia;
import ir.eitaa.tgnet.TLRPC$Document;
import ir.eitaa.tgnet.TLRPC$EncryptedChat;
import ir.eitaa.tgnet.TLRPC$FileLocation;
import ir.eitaa.tgnet.TLRPC$InputCheckPasswordSRP;
import ir.eitaa.tgnet.TLRPC$InputDocument;
import ir.eitaa.tgnet.TLRPC$InputEncryptedFile;
import ir.eitaa.tgnet.TLRPC$InputFile;
import ir.eitaa.tgnet.TLRPC$InputMedia;
import ir.eitaa.tgnet.TLRPC$InputPeer;
import ir.eitaa.tgnet.TLRPC$InputStickerSet;
import ir.eitaa.tgnet.TLRPC$KeyboardButton;
import ir.eitaa.tgnet.TLRPC$Message;
import ir.eitaa.tgnet.TLRPC$MessageAction;
import ir.eitaa.tgnet.TLRPC$MessageEntity;
import ir.eitaa.tgnet.TLRPC$MessageMedia;
import ir.eitaa.tgnet.TLRPC$MessageReplies;
import ir.eitaa.tgnet.TLRPC$Peer;
import ir.eitaa.tgnet.TLRPC$PhotoSize;
import ir.eitaa.tgnet.TLRPC$ReplyMarkup;
import ir.eitaa.tgnet.TLRPC$TL_GetPayHash;
import ir.eitaa.tgnet.TLRPC$TL_UserPayHash;
import ir.eitaa.tgnet.TLRPC$TL_account_password;
import ir.eitaa.tgnet.TLRPC$TL_botInlineMessageMediaAuto;
import ir.eitaa.tgnet.TLRPC$TL_botInlineMessageMediaContact;
import ir.eitaa.tgnet.TLRPC$TL_botInlineMessageMediaGeo;
import ir.eitaa.tgnet.TLRPC$TL_botInlineMessageMediaInvoice;
import ir.eitaa.tgnet.TLRPC$TL_botInlineMessageMediaVenue;
import ir.eitaa.tgnet.TLRPC$TL_botInlineMessageText;
import ir.eitaa.tgnet.TLRPC$TL_decryptedMessage;
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
import ir.eitaa.tgnet.TLRPC$TL_decryptedMessageActionTyping;
import ir.eitaa.tgnet.TLRPC$TL_decryptedMessageMediaDocument;
import ir.eitaa.tgnet.TLRPC$TL_decryptedMessageMediaPhoto;
import ir.eitaa.tgnet.TLRPC$TL_decryptedMessageMediaVideo;
import ir.eitaa.tgnet.TLRPC$TL_document;
import ir.eitaa.tgnet.TLRPC$TL_documentAttributeSticker_layer55;
import ir.eitaa.tgnet.TLRPC$TL_document_layer82;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_fileLocationUnavailable;
import ir.eitaa.tgnet.TLRPC$TL_fileLocation_layer82;
import ir.eitaa.tgnet.TLRPC$TL_game;
import ir.eitaa.tgnet.TLRPC$TL_geoPoint;
import ir.eitaa.tgnet.TLRPC$TL_inputDocument;
import ir.eitaa.tgnet.TLRPC$TL_inputEncryptedFile;
import ir.eitaa.tgnet.TLRPC$TL_inputMediaDocument;
import ir.eitaa.tgnet.TLRPC$TL_inputMediaGame;
import ir.eitaa.tgnet.TLRPC$TL_inputMediaPhoto;
import ir.eitaa.tgnet.TLRPC$TL_inputMediaUploadedDocument;
import ir.eitaa.tgnet.TLRPC$TL_inputMediaUploadedPhoto;
import ir.eitaa.tgnet.TLRPC$TL_inputPeerChannel;
import ir.eitaa.tgnet.TLRPC$TL_inputPeerChat;
import ir.eitaa.tgnet.TLRPC$TL_inputPeerSelf;
import ir.eitaa.tgnet.TLRPC$TL_inputPeerUser;
import ir.eitaa.tgnet.TLRPC$TL_inputSingleMedia;
import ir.eitaa.tgnet.TLRPC$TL_inputStickerSetItem;
import ir.eitaa.tgnet.TLRPC$TL_inputStickerSetShortName;
import ir.eitaa.tgnet.TLRPC$TL_inputUserSelf;
import ir.eitaa.tgnet.TLRPC$TL_keyboardButtonBuy;
import ir.eitaa.tgnet.TLRPC$TL_keyboardButtonGame;
import ir.eitaa.tgnet.TLRPC$TL_keyboardButtonUrlAuth;
import ir.eitaa.tgnet.TLRPC$TL_messageActionScreenshotTaken;
import ir.eitaa.tgnet.TLRPC$TL_messageEncryptedAction;
import ir.eitaa.tgnet.TLRPC$TL_messageEntityUrl;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaDocument;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaEmpty;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaGeo;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaGeoLive;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaInvoice;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaLiveStream;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaPoll;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaVenue;
import ir.eitaa.tgnet.TLRPC$TL_messageReplies;
import ir.eitaa.tgnet.TLRPC$TL_messageReplyHeader;
import ir.eitaa.tgnet.TLRPC$TL_messageService;
import ir.eitaa.tgnet.TLRPC$TL_messages_editMessage;
import ir.eitaa.tgnet.TLRPC$TL_messages_forwardMessages;
import ir.eitaa.tgnet.TLRPC$TL_messages_getBotCallbackAnswer;
import ir.eitaa.tgnet.TLRPC$TL_messages_getStickerSet;
import ir.eitaa.tgnet.TLRPC$TL_messages_historyImport;
import ir.eitaa.tgnet.TLRPC$TL_messages_initHistoryImport;
import ir.eitaa.tgnet.TLRPC$TL_messages_messages;
import ir.eitaa.tgnet.TLRPC$TL_messages_requestUrlAuth;
import ir.eitaa.tgnet.TLRPC$TL_messages_sendEncryptedMultiMedia;
import ir.eitaa.tgnet.TLRPC$TL_messages_sendMedia;
import ir.eitaa.tgnet.TLRPC$TL_messages_sendMessage;
import ir.eitaa.tgnet.TLRPC$TL_messages_sendMultiMedia;
import ir.eitaa.tgnet.TLRPC$TL_messages_sendReaction;
import ir.eitaa.tgnet.TLRPC$TL_messages_sendScreenshotNotification;
import ir.eitaa.tgnet.TLRPC$TL_messages_sendVote;
import ir.eitaa.tgnet.TLRPC$TL_messages_startHistoryImport;
import ir.eitaa.tgnet.TLRPC$TL_messages_stickerSet;
import ir.eitaa.tgnet.TLRPC$TL_messages_uploadImportedMedia;
import ir.eitaa.tgnet.TLRPC$TL_messages_uploadMedia;
import ir.eitaa.tgnet.TLRPC$TL_peerUser;
import ir.eitaa.tgnet.TLRPC$TL_photo;
import ir.eitaa.tgnet.TLRPC$TL_photoCachedSize;
import ir.eitaa.tgnet.TLRPC$TL_photoPathSize;
import ir.eitaa.tgnet.TLRPC$TL_photoSize;
import ir.eitaa.tgnet.TLRPC$TL_photoSizeEmpty;
import ir.eitaa.tgnet.TLRPC$TL_photoSizeProgressive;
import ir.eitaa.tgnet.TLRPC$TL_photoSize_layer127;
import ir.eitaa.tgnet.TLRPC$TL_photoStrippedSize;
import ir.eitaa.tgnet.TLRPC$TL_pollAnswer;
import ir.eitaa.tgnet.TLRPC$TL_restrictionReason;
import ir.eitaa.tgnet.TLRPC$TL_stickers_createStickerSet;
import ir.eitaa.tgnet.TLRPC$TL_updateEditChannelMessage;
import ir.eitaa.tgnet.TLRPC$TL_updateEditMessage;
import ir.eitaa.tgnet.TLRPC$TL_updateMessageID;
import ir.eitaa.tgnet.TLRPC$TL_updateNewChannelMessage;
import ir.eitaa.tgnet.TLRPC$TL_updateNewMessage;
import ir.eitaa.tgnet.TLRPC$TL_updateNewScheduledMessage;
import ir.eitaa.tgnet.TLRPC$TL_updateShortSentMessage;
import ir.eitaa.tgnet.TLRPC$TL_urlAuthResultAccepted;
import ir.eitaa.tgnet.TLRPC$TL_urlAuthResultDefault;
import ir.eitaa.tgnet.TLRPC$TL_urlAuthResultRequest;
import ir.eitaa.tgnet.TLRPC$TL_user;
import ir.eitaa.tgnet.TLRPC$TL_webPagePending;
import ir.eitaa.tgnet.TLRPC$Update;
import ir.eitaa.tgnet.TLRPC$Updates;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.tgnet.TLRPC$WebDocument;
import ir.eitaa.tgnet.TLRPC$WebPage;
import ir.eitaa.tgnet.TLRPC$messages_Messages;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.Cells.ChatMessageCell;
import ir.eitaa.ui.ChatActivity;
import ir.eitaa.ui.Components.AlertsCreator;
import ir.eitaa.ui.Components.AnimatedFileDrawable;
import ir.eitaa.ui.Components.Point;
import ir.eitaa.ui.PaymentActivity;
import ir.eitaa.ui.TwoStepVerificationActivity;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
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
import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
public class SendMessagesHelper extends BaseController implements NotificationCenter.NotificationCenterDelegate {
    private static volatile SendMessagesHelper[] Instance;
    private static DispatchQueue mediaSendQueue = new DispatchQueue("mediaSendQueue");
    private static ThreadPoolExecutor mediaSendThreadPool;
    private HashMap<String, ArrayList<DelayedMessage>> delayedMessages;
    private SparseArray<TLRPC$Message> editingMessages;
    private HashMap<String, ImportingHistory> importingHistoryFiles;
    private LongSparseArray<ImportingHistory> importingHistoryMap;
    private HashMap<String, ImportingStickers> importingStickersFiles;
    private HashMap<String, ImportingStickers> importingStickersMap;
    private LocationProvider locationProvider;
    private SparseArray<TLRPC$Message> sendingMessages;
    private LongSparseArray<Integer> sendingMessagesIdDialogs;
    private SparseArray<MessageObject> unsentMessages;
    private SparseArray<TLRPC$Message> uploadMessages;
    private LongSparseArray<Integer> uploadingMessagesIdDialogs;
    private LongSparseArray<Long> voteSendTime;
    private HashMap<String, Boolean> waitingForCallback;
    private HashMap<String, MessageObject> waitingForLocation;
    private HashMap<String, byte[]> waitingForVote;

    public static class SendingMediaInfo {
        public boolean canDeleteAfter;
        public String caption;
        public ArrayList<TLRPC$MessageEntity> entities;
        public boolean forceImage;
        public TLRPC$BotInlineResult inlineResult;
        public boolean isVideo;
        public ArrayList<TLRPC$InputDocument> masks;
        public String paintPath;
        public HashMap<String, String> params;
        public String path;
        public MediaController.SearchImage searchImage;
        public String thumbPath;
        public int ttl;
        public Uri uri;
        public VideoEditedInfo videoEditedInfo;
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
        public void initImport(TLRPC$InputFile inputFile) {
            TLRPC$TL_messages_initHistoryImport tLRPC$TL_messages_initHistoryImport = new TLRPC$TL_messages_initHistoryImport();
            tLRPC$TL_messages_initHistoryImport.file = inputFile;
            tLRPC$TL_messages_initHistoryImport.media_count = this.mediaPaths.size();
            tLRPC$TL_messages_initHistoryImport.peer = this.peer;
            SendMessagesHelper.this.getConnectionsManager().sendRequest(tLRPC$TL_messages_initHistoryImport, new AnonymousClass1(tLRPC$TL_messages_initHistoryImport), 2);
        }

        /* renamed from: ir.eitaa.messenger.SendMessagesHelper$ImportingHistory$1, reason: invalid class name */
        class AnonymousClass1 implements RequestDelegate {
            final /* synthetic */ TLRPC$TL_messages_initHistoryImport val$req;

            AnonymousClass1(final TLRPC$TL_messages_initHistoryImport val$req) {
                this.val$req = val$req;
            }

            @Override // ir.eitaa.tgnet.RequestDelegate
            public void run(final TLObject response, final TLRPC$TL_error error) {
                final TLRPC$TL_messages_initHistoryImport tLRPC$TL_messages_initHistoryImport = this.val$req;
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$ImportingHistory$1$NA-d0uo8asl8TF0kFSl4FjLTgmQ
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$run$0$SendMessagesHelper$ImportingHistory$1(response, tLRPC$TL_messages_initHistoryImport, error);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: lambda$run$0, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void lambda$run$0$SendMessagesHelper$ImportingHistory$1(TLObject tLObject, TLRPC$TL_messages_initHistoryImport tLRPC$TL_messages_initHistoryImport, TLRPC$TL_error tLRPC$TL_error) {
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
                    SendMessagesHelper.this.getFileLoader().uploadFile(ImportingHistory.this.uploadMedia.get(i), false, true, ConnectionsManager.FileTypeFile);
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
        public void onFileFailedToUpload(String path) {
            if (path.equals(this.historyPath)) {
                SendMessagesHelper.this.importingHistoryMap.remove(this.dialogId);
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.code = 400;
                tLRPC$TL_error.text = "IMPORT_UPLOAD_FAILED";
                SendMessagesHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.historyImportProgressChanged, Long.valueOf(this.dialogId), new TLRPC$TL_messages_initHistoryImport(), tLRPC$TL_error);
                return;
            }
            this.uploadSet.remove(path);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addUploadProgress(String path, long sz, float progress) {
            this.uploadProgresses.put(path, Float.valueOf(progress));
            this.uploadSize.put(path, Long.valueOf(sz));
            this.uploadedSize = 0L;
            Iterator<Map.Entry<String, Long>> it = this.uploadSize.entrySet().iterator();
            while (it.hasNext()) {
                this.uploadedSize += it.next().getValue().longValue();
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (!path.equals(this.historyPath)) {
                long j = this.uploadedSize;
                long j2 = this.lastUploadSize;
                if (j != j2) {
                    long j3 = this.lastUploadTime;
                    if (jElapsedRealtime != j3) {
                        double d = jElapsedRealtime - j3;
                        Double.isNaN(d);
                        double d2 = j - j2;
                        Double.isNaN(d2);
                        double d3 = d2 / (d / 1000.0d);
                        double d4 = this.estimatedUploadSpeed;
                        if (d4 == 0.0d) {
                            this.estimatedUploadSpeed = d3;
                        } else {
                            this.estimatedUploadSpeed = (d3 * 0.01d) + (0.99d * d4);
                        }
                        double d5 = (this.totalSize - j) * 1000;
                        double d6 = this.estimatedUploadSpeed;
                        Double.isNaN(d5);
                        this.timeUntilFinish = (int) (d5 / d6);
                        this.lastUploadSize = j;
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
        public void onMediaImport(String path, long size, TLRPC$InputFile inputFile) {
            addUploadProgress(path, size, 1.0f);
            TLRPC$TL_messages_uploadImportedMedia tLRPC$TL_messages_uploadImportedMedia = new TLRPC$TL_messages_uploadImportedMedia();
            tLRPC$TL_messages_uploadImportedMedia.peer = this.peer;
            tLRPC$TL_messages_uploadImportedMedia.import_id = this.importId;
            tLRPC$TL_messages_uploadImportedMedia.file_name = new File(path).getName();
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
                tLRPC$TL_inputMediaUploadedPhoto.file = inputFile;
                tLRPC$TL_messages_uploadImportedMedia.media = tLRPC$TL_inputMediaUploadedPhoto;
            } else {
                TLRPC$TL_inputMediaUploadedDocument tLRPC$TL_inputMediaUploadedDocument = new TLRPC$TL_inputMediaUploadedDocument();
                tLRPC$TL_inputMediaUploadedDocument.file = inputFile;
                tLRPC$TL_inputMediaUploadedDocument.mime_type = mimeTypeFromExtension;
                tLRPC$TL_messages_uploadImportedMedia.media = tLRPC$TL_inputMediaUploadedDocument;
            }
            SendMessagesHelper.this.getConnectionsManager().sendRequest(tLRPC$TL_messages_uploadImportedMedia, new AnonymousClass2(path), 2);
        }

        /* renamed from: ir.eitaa.messenger.SendMessagesHelper$ImportingHistory$2, reason: invalid class name */
        class AnonymousClass2 implements RequestDelegate {
            final /* synthetic */ String val$path;

            AnonymousClass2(final String val$path) {
                this.val$path = val$path;
            }

            @Override // ir.eitaa.tgnet.RequestDelegate
            public void run(TLObject response, TLRPC$TL_error error) {
                final String str = this.val$path;
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$ImportingHistory$2$ZZjl6c0uFgb3IekKWf14_NKbKYc
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$run$0$SendMessagesHelper$ImportingHistory$2(str);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: lambda$run$0, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void lambda$run$0$SendMessagesHelper$ImportingHistory$2(String str) {
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

        /* renamed from: ir.eitaa.messenger.SendMessagesHelper$ImportingHistory$3, reason: invalid class name */
        class AnonymousClass3 implements RequestDelegate {
            final /* synthetic */ TLRPC$TL_messages_startHistoryImport val$req;

            AnonymousClass3(final TLRPC$TL_messages_startHistoryImport val$req) {
                this.val$req = val$req;
            }

            @Override // ir.eitaa.tgnet.RequestDelegate
            public void run(TLObject response, final TLRPC$TL_error error) {
                final TLRPC$TL_messages_startHistoryImport tLRPC$TL_messages_startHistoryImport = this.val$req;
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$ImportingHistory$3$PkX4eRbLh-8s_Kl7xz7FSRO7YVk
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$run$0$SendMessagesHelper$ImportingHistory$3(error, tLRPC$TL_messages_startHistoryImport);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: lambda$run$0, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void lambda$run$0$SendMessagesHelper$ImportingHistory$3(TLRPC$TL_error tLRPC$TL_error, TLRPC$TL_messages_startHistoryImport tLRPC$TL_messages_startHistoryImport) {
                SendMessagesHelper.this.importingHistoryMap.remove(ImportingHistory.this.dialogId);
                if (tLRPC$TL_error == null) {
                    SendMessagesHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.historyImportProgressChanged, Long.valueOf(ImportingHistory.this.dialogId));
                } else {
                    SendMessagesHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.historyImportProgressChanged, Long.valueOf(ImportingHistory.this.dialogId), tLRPC$TL_messages_startHistoryImport, tLRPC$TL_error);
                }
            }
        }

        public void setImportProgress(int value) {
            if (value == 100) {
                SendMessagesHelper.this.importingHistoryMap.remove(this.dialogId);
            }
            SendMessagesHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.historyImportProgressChanged, Long.valueOf(this.dialogId));
        }
    }

    public static class ImportingSticker {
        public boolean animated;
        public String emoji;
        public TLRPC$TL_inputStickerSetItem item;
        public String mimeType;
        public String path;
        public boolean validated;

        public void uploadMedia(int account, TLRPC$InputFile inputFile, Runnable onFinish) {
            TLRPC$TL_messages_uploadMedia tLRPC$TL_messages_uploadMedia = new TLRPC$TL_messages_uploadMedia();
            tLRPC$TL_messages_uploadMedia.peer = new TLRPC$TL_inputPeerSelf();
            TLRPC$TL_inputMediaUploadedDocument tLRPC$TL_inputMediaUploadedDocument = new TLRPC$TL_inputMediaUploadedDocument();
            tLRPC$TL_messages_uploadMedia.media = tLRPC$TL_inputMediaUploadedDocument;
            tLRPC$TL_inputMediaUploadedDocument.file = inputFile;
            tLRPC$TL_inputMediaUploadedDocument.mime_type = this.mimeType;
            ConnectionsManager.getInstance(account).sendRequest(tLRPC$TL_messages_uploadMedia, new AnonymousClass1(onFinish), 2);
        }

        /* renamed from: ir.eitaa.messenger.SendMessagesHelper$ImportingSticker$1, reason: invalid class name */
        class AnonymousClass1 implements RequestDelegate {
            final /* synthetic */ Runnable val$onFinish;

            AnonymousClass1(final Runnable val$onFinish) {
                this.val$onFinish = val$onFinish;
            }

            @Override // ir.eitaa.tgnet.RequestDelegate
            public void run(final TLObject response, TLRPC$TL_error error) {
                final Runnable runnable = this.val$onFinish;
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$ImportingSticker$1$nL-6ywGOHYl59ilp0FQdrsQ1uOs
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$run$0$SendMessagesHelper$ImportingSticker$1(response, runnable);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: lambda$run$0, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void lambda$run$0$SendMessagesHelper$ImportingSticker$1(TLObject tLObject, Runnable runnable) {
                if (tLObject instanceof TLRPC$TL_messageMediaDocument) {
                    ImportingSticker.this.item = new TLRPC$TL_inputStickerSetItem();
                    ImportingSticker.this.item.document = new TLRPC$TL_inputDocument();
                    ImportingSticker importingSticker = ImportingSticker.this;
                    TLRPC$TL_inputStickerSetItem tLRPC$TL_inputStickerSetItem = importingSticker.item;
                    TLRPC$InputDocument tLRPC$InputDocument = tLRPC$TL_inputStickerSetItem.document;
                    TLRPC$Document tLRPC$Document = ((TLRPC$TL_messageMediaDocument) tLObject).document;
                    tLRPC$InputDocument.id = tLRPC$Document.id;
                    tLRPC$InputDocument.access_hash = tLRPC$Document.access_hash;
                    tLRPC$InputDocument.file_reference = tLRPC$Document.file_reference;
                    String str = importingSticker.emoji;
                    if (str == null) {
                        str = "";
                    }
                    tLRPC$TL_inputStickerSetItem.emoji = str;
                    importingSticker.mimeType = tLRPC$Document.mime_type;
                } else {
                    ImportingSticker importingSticker2 = ImportingSticker.this;
                    if (importingSticker2.animated) {
                        importingSticker2.mimeType = "application/x-bad-tgsticker";
                    }
                }
                runnable.run();
            }
        }
    }

    public class ImportingStickers {
        public double estimatedUploadSpeed;
        private long lastUploadSize;
        private long lastUploadTime;
        public String shortName;
        public String software;
        public String title;
        public long totalSize;
        public int uploadProgress;
        public long uploadedSize;
        public HashMap<String, ImportingSticker> uploadSet = new HashMap<>();
        public HashMap<String, Float> uploadProgresses = new HashMap<>();
        public HashMap<String, Long> uploadSize = new HashMap<>();
        public ArrayList<ImportingSticker> uploadMedia = new ArrayList<>();
        public int timeUntilFinish = ConnectionsManager.DEFAULT_DATACENTER_ID;

        public ImportingStickers() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void initImport() {
            SendMessagesHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.stickersImportProgressChanged, this.shortName);
            this.lastUploadTime = SystemClock.elapsedRealtime();
            int size = this.uploadMedia.size();
            for (int i = 0; i < size; i++) {
                SendMessagesHelper.this.getFileLoader().uploadFile(this.uploadMedia.get(i).path, false, true, ConnectionsManager.FileTypeFile);
            }
        }

        public long getUploadedCount() {
            return this.uploadedSize;
        }

        public long getTotalCount() {
            return this.totalSize;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onFileFailedToUpload(String path) {
            ImportingSticker importingStickerRemove = this.uploadSet.remove(path);
            if (importingStickerRemove != null) {
                this.uploadMedia.remove(importingStickerRemove);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addUploadProgress(String path, long sz, float progress) {
            this.uploadProgresses.put(path, Float.valueOf(progress));
            this.uploadSize.put(path, Long.valueOf(sz));
            this.uploadedSize = 0L;
            Iterator<Map.Entry<String, Long>> it = this.uploadSize.entrySet().iterator();
            while (it.hasNext()) {
                this.uploadedSize += it.next().getValue().longValue();
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j = this.uploadedSize;
            long j2 = this.lastUploadSize;
            if (j != j2) {
                long j3 = this.lastUploadTime;
                if (jElapsedRealtime != j3) {
                    double d = jElapsedRealtime - j3;
                    Double.isNaN(d);
                    double d2 = j - j2;
                    Double.isNaN(d2);
                    double d3 = d2 / (d / 1000.0d);
                    double d4 = this.estimatedUploadSpeed;
                    if (d4 == 0.0d) {
                        this.estimatedUploadSpeed = d3;
                    } else {
                        this.estimatedUploadSpeed = (d3 * 0.01d) + (0.99d * d4);
                    }
                    double d5 = (this.totalSize - j) * 1000;
                    double d6 = this.estimatedUploadSpeed;
                    Double.isNaN(d5);
                    this.timeUntilFinish = (int) (d5 / d6);
                    this.lastUploadSize = j;
                    this.lastUploadTime = jElapsedRealtime;
                }
            }
            int uploadedCount = (int) ((getUploadedCount() / getTotalCount()) * 100.0f);
            if (this.uploadProgress != uploadedCount) {
                this.uploadProgress = uploadedCount;
                SendMessagesHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.stickersImportProgressChanged, this.shortName);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onMediaImport(final String path, long size, TLRPC$InputFile inputFile) {
            addUploadProgress(path, size, 1.0f);
            ImportingSticker importingSticker = this.uploadSet.get(path);
            if (importingSticker == null) {
                return;
            }
            importingSticker.uploadMedia(SendMessagesHelper.this.currentAccount, inputFile, new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$ImportingStickers$2FoVcUExOeHYwap6ULIQmuhmVwg
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onMediaImport$0$SendMessagesHelper$ImportingStickers(path);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onMediaImport$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onMediaImport$0$SendMessagesHelper$ImportingStickers(String str) {
            this.uploadSet.remove(str);
            SendMessagesHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.stickersImportProgressChanged, this.shortName);
            if (this.uploadSet.isEmpty()) {
                startImport();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void startImport() {
            TLRPC$TL_stickers_createStickerSet tLRPC$TL_stickers_createStickerSet = new TLRPC$TL_stickers_createStickerSet();
            tLRPC$TL_stickers_createStickerSet.user_id = new TLRPC$TL_inputUserSelf();
            tLRPC$TL_stickers_createStickerSet.title = this.title;
            tLRPC$TL_stickers_createStickerSet.short_name = this.shortName;
            tLRPC$TL_stickers_createStickerSet.animated = this.uploadMedia.get(0).animated;
            String str = this.software;
            if (str != null) {
                tLRPC$TL_stickers_createStickerSet.software = str;
                tLRPC$TL_stickers_createStickerSet.flags |= 8;
            }
            int size = this.uploadMedia.size();
            for (int i = 0; i < size; i++) {
                TLRPC$TL_inputStickerSetItem tLRPC$TL_inputStickerSetItem = this.uploadMedia.get(i).item;
                if (tLRPC$TL_inputStickerSetItem != null) {
                    tLRPC$TL_stickers_createStickerSet.stickers.add(tLRPC$TL_inputStickerSetItem);
                }
            }
            SendMessagesHelper.this.getConnectionsManager().sendRequest(tLRPC$TL_stickers_createStickerSet, new AnonymousClass1(tLRPC$TL_stickers_createStickerSet));
        }

        /* renamed from: ir.eitaa.messenger.SendMessagesHelper$ImportingStickers$1, reason: invalid class name */
        class AnonymousClass1 implements RequestDelegate {
            final /* synthetic */ TLRPC$TL_stickers_createStickerSet val$req;

            AnonymousClass1(final TLRPC$TL_stickers_createStickerSet val$req) {
                this.val$req = val$req;
            }

            @Override // ir.eitaa.tgnet.RequestDelegate
            public void run(final TLObject response, final TLRPC$TL_error error) {
                final TLRPC$TL_stickers_createStickerSet tLRPC$TL_stickers_createStickerSet = this.val$req;
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$ImportingStickers$1$Icnv87X3VNQz5iuR0OMZRJvhRfY
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$run$0$SendMessagesHelper$ImportingStickers$1(error, tLRPC$TL_stickers_createStickerSet, response);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: lambda$run$0, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void lambda$run$0$SendMessagesHelper$ImportingStickers$1(TLRPC$TL_error tLRPC$TL_error, TLRPC$TL_stickers_createStickerSet tLRPC$TL_stickers_createStickerSet, TLObject tLObject) {
                SendMessagesHelper.this.importingStickersMap.remove(ImportingStickers.this.shortName);
                if (tLRPC$TL_error == null) {
                    SendMessagesHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.stickersImportProgressChanged, ImportingStickers.this.shortName);
                } else {
                    SendMessagesHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.stickersImportProgressChanged, ImportingStickers.this.shortName, tLRPC$TL_stickers_createStickerSet, tLRPC$TL_error);
                }
                if (tLObject instanceof TLRPC$TL_messages_stickerSet) {
                    NotificationCenter notificationCenter = SendMessagesHelper.this.getNotificationCenter();
                    int i = NotificationCenter.stickersImportComplete;
                    if (notificationCenter.hasObservers(i)) {
                        SendMessagesHelper.this.getNotificationCenter().postNotificationName(i, tLObject);
                    } else {
                        SendMessagesHelper.this.getMediaDataController().toggleStickerSet(null, tLObject, 2, null, false, false);
                    }
                }
            }
        }

        public void setImportProgress(int value) {
            if (value == 100) {
                SendMessagesHelper.this.importingStickersMap.remove(this.shortName);
            }
            SendMessagesHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.stickersImportProgressChanged, this.shortName);
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
            public void onProviderDisabled(String provider) {
            }

            @Override // android.location.LocationListener
            public void onProviderEnabled(String provider) {
            }

            @Override // android.location.LocationListener
            public void onStatusChanged(String provider, int status, Bundle extras) {
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
            Runnable runnable2 = new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$LocationProvider$NeIzsBIxueLqsEs0AUNa7urjJIA
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$start$0$SendMessagesHelper$LocationProvider();
                }
            };
            this.locationQueryCancelRunnable = runnable2;
            AndroidUtilities.runOnUIThread(runnable2, 5000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$start$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$start$0$SendMessagesHelper$LocationProvider() {
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
        public int finalGroupMessage;
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

        public DelayedMessage(long peer) {
            this.peer = peer;
        }

        public void initForGroup(long id) {
            this.type = 4;
            this.groupId = id;
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

        public void addDelayedRequest(final TLObject req, final MessageObject msgObj, final String originalPath, Object parentObject, DelayedMessage delayedMessage, boolean scheduled) {
            DelayedMessageSendAfterRequest delayedMessageSendAfterRequest = SendMessagesHelper.this.new DelayedMessageSendAfterRequest();
            delayedMessageSendAfterRequest.request = req;
            delayedMessageSendAfterRequest.msgObj = msgObj;
            delayedMessageSendAfterRequest.originalPath = originalPath;
            delayedMessageSendAfterRequest.delayedMessage = delayedMessage;
            delayedMessageSendAfterRequest.parentObject = parentObject;
            delayedMessageSendAfterRequest.scheduled = scheduled;
            if (this.requests == null) {
                this.requests = new ArrayList<>();
            }
            this.requests.add(delayedMessageSendAfterRequest);
        }

        public void addDelayedRequest(final TLObject req, final ArrayList<MessageObject> msgObjs, final ArrayList<String> originalPaths, ArrayList<Object> parentObjects, DelayedMessage delayedMessage, boolean scheduled) {
            DelayedMessageSendAfterRequest delayedMessageSendAfterRequest = SendMessagesHelper.this.new DelayedMessageSendAfterRequest();
            delayedMessageSendAfterRequest.request = req;
            delayedMessageSendAfterRequest.msgObjs = msgObjs;
            delayedMessageSendAfterRequest.originalPaths = originalPaths;
            delayedMessageSendAfterRequest.delayedMessage = delayedMessage;
            delayedMessageSendAfterRequest.parentObjects = parentObjects;
            delayedMessageSendAfterRequest.scheduled = scheduled;
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
                    SendMessagesHelper.this.getMessagesStorage().markMessageAsSendError(messageObject.messageOwner, messageObject.scheduled);
                    messageObject.messageOwner.send_state = 2;
                    SendMessagesHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.messageSendError, Integer.valueOf(messageObject.getId()));
                    SendMessagesHelper.this.processSentMessage(messageObject.getId());
                    SendMessagesHelper.this.removeFromUploadingMessages(messageObject.getId(), this.scheduled);
                }
                SendMessagesHelper.this.delayedMessages.remove("group_" + this.groupId);
            } else {
                MessagesStorage messagesStorage = SendMessagesHelper.this.getMessagesStorage();
                MessageObject messageObject2 = this.obj;
                messagesStorage.markMessageAsSendError(messageObject2.messageOwner, messageObject2.scheduled);
                this.obj.messageOwner.send_state = 2;
                SendMessagesHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.messageSendError, Integer.valueOf(this.obj.getId()));
                SendMessagesHelper.this.processSentMessage(this.obj.getId());
                SendMessagesHelper.this.removeFromUploadingMessages(this.obj.getId(), this.scheduled);
            }
            sendDelayedRequests();
        }
    }

    public static SendMessagesHelper getInstance(int num) {
        SendMessagesHelper sendMessagesHelper = Instance[num];
        if (sendMessagesHelper == null) {
            synchronized (SendMessagesHelper.class) {
                sendMessagesHelper = Instance[num];
                if (sendMessagesHelper == null) {
                    SendMessagesHelper[] sendMessagesHelperArr = Instance;
                    SendMessagesHelper sendMessagesHelper2 = new SendMessagesHelper(num);
                    sendMessagesHelperArr[num] = sendMessagesHelper2;
                    sendMessagesHelper = sendMessagesHelper2;
                }
            }
        }
        return sendMessagesHelper;
    }

    public SendMessagesHelper(int instance) {
        super(instance);
        this.delayedMessages = new HashMap<>();
        this.unsentMessages = new SparseArray<>();
        this.sendingMessages = new SparseArray<>();
        this.editingMessages = new SparseArray<>();
        this.uploadMessages = new SparseArray<>();
        this.sendingMessagesIdDialogs = new LongSparseArray<>();
        this.uploadingMessagesIdDialogs = new LongSparseArray<>();
        this.waitingForLocation = new HashMap<>();
        this.waitingForCallback = new HashMap<>();
        this.waitingForVote = new HashMap<>();
        this.voteSendTime = new LongSparseArray<>();
        this.importingHistoryFiles = new HashMap<>();
        this.importingHistoryMap = new LongSparseArray<>();
        this.importingStickersFiles = new HashMap<>();
        this.importingStickersMap = new HashMap<>();
        this.locationProvider = new LocationProvider(new LocationProvider.LocationProviderDelegate() { // from class: ir.eitaa.messenger.SendMessagesHelper.1
            @Override // ir.eitaa.messenger.SendMessagesHelper.LocationProvider.LocationProviderDelegate
            public void onLocationAcquired(Location location) {
                SendMessagesHelper.this.sendLocation(location);
                SendMessagesHelper.this.waitingForLocation.clear();
            }

            @Override // ir.eitaa.messenger.SendMessagesHelper.LocationProvider.LocationProviderDelegate
            public void onUnableLocationAcquire() {
                SendMessagesHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.wasUnableToFindCurrentLocation, new HashMap(SendMessagesHelper.this.waitingForLocation));
                SendMessagesHelper.this.waitingForLocation.clear();
            }
        });
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$ZBfr6kf-uduT2aVX0_fM861K-LM
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$0$SendMessagesHelper();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$SendMessagesHelper() {
        getNotificationCenter().addObserver(this, NotificationCenter.fileUploaded);
        getNotificationCenter().addObserver(this, NotificationCenter.fileUploadProgressChanged);
        getNotificationCenter().addObserver(this, NotificationCenter.fileUploadFailed);
        getNotificationCenter().addObserver(this, NotificationCenter.filePreparingStarted);
        getNotificationCenter().addObserver(this, NotificationCenter.fileNewChunkAvailable);
        getNotificationCenter().addObserver(this, NotificationCenter.filePreparingFailed);
        getNotificationCenter().addObserver(this, NotificationCenter.httpFileDidFailedLoad);
        getNotificationCenter().addObserver(this, NotificationCenter.httpFileDidLoad);
        getNotificationCenter().addObserver(this, NotificationCenter.fileLoaded);
        getNotificationCenter().addObserver(this, NotificationCenter.fileLoadFailed);
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
        this.importingStickersFiles.clear();
        this.importingStickersMap.clear();
        this.locationProvider.stop();
    }

    @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, final Object... args) {
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
        int i;
        String str3;
        int i2;
        TLRPC$PhotoSize tLRPC$PhotoSize;
        TLRPC$PhotoSize tLRPC$PhotoSize2;
        int i3 = 0;
        boolean z = true;
        if (id == NotificationCenter.fileUploadProgressChanged) {
            String str4 = (String) args[0];
            ImportingHistory importingHistory = this.importingHistoryFiles.get(str4);
            if (importingHistory != null) {
                importingHistory.addUploadProgress(str4, ((Long) args[1]).longValue(), r2.longValue() / ((Long) args[2]).longValue());
            }
            ImportingStickers importingStickers = this.importingStickersFiles.get(str4);
            if (importingStickers != null) {
                importingStickers.addUploadProgress(str4, ((Long) args[1]).longValue(), r2.longValue() / ((Long) args[2]).longValue());
                return;
            }
            return;
        }
        if (id == NotificationCenter.fileUploaded) {
            String str5 = (String) args[0];
            TLRPC$InputFile tLRPC$InputFile2 = (TLRPC$InputFile) args[1];
            TLRPC$InputEncryptedFile tLRPC$InputEncryptedFile3 = (TLRPC$InputEncryptedFile) args[2];
            ImportingHistory importingHistory2 = this.importingHistoryFiles.get(str5);
            if (importingHistory2 != null) {
                if (str5.equals(importingHistory2.historyPath)) {
                    importingHistory2.initImport(tLRPC$InputFile2);
                } else {
                    importingHistory2.onMediaImport(str5, ((Long) args[5]).longValue(), tLRPC$InputFile2);
                }
            }
            ImportingStickers importingStickers2 = this.importingStickersFiles.get(str5);
            if (importingStickers2 != null) {
                importingStickers2.onMediaImport(str5, ((Long) args[5]).longValue(), tLRPC$InputFile2);
            }
            ArrayList<DelayedMessage> arrayList4 = this.delayedMessages.get(str5);
            if (arrayList4 != null) {
                while (i3 < arrayList4.size()) {
                    DelayedMessage delayedMessage = arrayList4.get(i3);
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
                                    tLRPC$TL_decryptedMessage.media.size = (int) ((Long) args[5]).longValue();
                                }
                                TLRPC$DecryptedMessageMedia tLRPC$DecryptedMessageMedia2 = tLRPC$TL_decryptedMessage.media;
                                tLRPC$DecryptedMessageMedia2.key = (byte[]) args[3];
                                tLRPC$DecryptedMessageMedia2.iv = (byte[]) args[4];
                                if (delayedMessage.type == 4) {
                                    uploadMultiMedia(delayedMessage, null, tLRPC$InputEncryptedFile, str2);
                                } else {
                                    SecretChatHelper secretChatHelper = getSecretChatHelper();
                                    MessageObject messageObject3 = delayedMessage.obj;
                                    secretChatHelper.performSendEncryptedRequest(tLRPC$TL_decryptedMessage, messageObject3.messageOwner, delayedMessage.encryptedChat, tLRPC$InputEncryptedFile, delayedMessage.originalPath, messageObject3);
                                }
                            }
                            arrayList2.remove(i3);
                            i3--;
                        }
                    } else {
                        int i4 = delayedMessage.type;
                        if (i4 == 0) {
                            tLRPC$InputMedia.file = tLRPC$InputFile2;
                            arrayList3 = arrayList4;
                            tLRPC$InputEncryptedFile2 = tLRPC$InputEncryptedFile3;
                            i = i3;
                            tLRPC$InputFile = tLRPC$InputFile2;
                            str3 = str5;
                            performSendMessageRequest(delayedMessage.sendRequest, delayedMessage.obj, delayedMessage.originalPath, delayedMessage, true, null, delayedMessage.parentObject, null, delayedMessage.scheduled);
                        } else {
                            arrayList3 = arrayList4;
                            tLRPC$InputEncryptedFile2 = tLRPC$InputEncryptedFile3;
                            i = i3;
                            tLRPC$InputFile = tLRPC$InputFile2;
                            str3 = str5;
                            if (i4 == z) {
                                if (tLRPC$InputMedia.file == null) {
                                    tLRPC$InputMedia.file = tLRPC$InputFile;
                                    if (tLRPC$InputMedia.thumb == null && (tLRPC$PhotoSize2 = delayedMessage.photoSize) != null && tLRPC$PhotoSize2.location != null) {
                                        performSendDelayedMessage(delayedMessage);
                                    } else {
                                        performSendMessageRequest(delayedMessage.sendRequest, delayedMessage.obj, delayedMessage.originalPath, null, delayedMessage.parentObject, null, delayedMessage.scheduled);
                                    }
                                } else {
                                    tLRPC$InputMedia.thumb = tLRPC$InputFile;
                                    tLRPC$InputMedia.flags |= 4;
                                    performSendMessageRequest(delayedMessage.sendRequest, delayedMessage.obj, delayedMessage.originalPath, null, delayedMessage.parentObject, null, delayedMessage.scheduled);
                                }
                            } else if (i4 == 2) {
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
                            } else if (i4 == 3) {
                                tLRPC$InputMedia.file = tLRPC$InputFile;
                                performSendMessageRequest(delayedMessage.sendRequest, delayedMessage.obj, delayedMessage.originalPath, null, delayedMessage.parentObject, null, delayedMessage.scheduled);
                            } else {
                                if (i4 != 4) {
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
                                        TLRPC$PhotoSize tLRPC$PhotoSize3 = (TLRPC$PhotoSize) delayedMessage.extraHashMap.get(str2 + "_t");
                                        delayedMessage.photoSize = tLRPC$PhotoSize3;
                                        if (tLRPC$InputMedia.thumb == null && tLRPC$PhotoSize3 != null && tLRPC$PhotoSize3.location != null) {
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
                                i2 = i;
                                arrayList2.remove(i2);
                                i3 = i2 - 1;
                                tLRPC$InputEncryptedFile = tLRPC$InputEncryptedFile2;
                            }
                        }
                        arrayList2 = arrayList3;
                        i2 = i;
                        str2 = str3;
                        arrayList2.remove(i2);
                        i3 = i2 - 1;
                        tLRPC$InputEncryptedFile = tLRPC$InputEncryptedFile2;
                    }
                    i3++;
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
        if (id == NotificationCenter.fileUploadFailed) {
            String str7 = (String) args[0];
            boolean zBooleanValue = ((Boolean) args[1]).booleanValue();
            ImportingHistory importingHistory3 = this.importingHistoryFiles.get(str7);
            if (importingHistory3 != null) {
                importingHistory3.onFileFailedToUpload(str7);
            }
            ImportingStickers importingStickers3 = this.importingStickersFiles.get(str7);
            if (importingStickers3 != null) {
                importingStickers3.onFileFailedToUpload(str7);
            }
            ArrayList<DelayedMessage> arrayList5 = this.delayedMessages.get(str7);
            if (arrayList5 != null) {
                while (i3 < arrayList5.size()) {
                    DelayedMessage delayedMessage2 = arrayList5.get(i3);
                    if ((zBooleanValue && delayedMessage2.sendEncryptedRequest != null) || (!zBooleanValue && delayedMessage2.sendRequest != null)) {
                        delayedMessage2.markAsError();
                        arrayList5.remove(i3);
                        i3--;
                    }
                    i3++;
                }
                if (arrayList5.isEmpty()) {
                    this.delayedMessages.remove(str7);
                    return;
                }
                return;
            }
            return;
        }
        if (id == NotificationCenter.filePreparingStarted) {
            MessageObject messageObject4 = (MessageObject) args[0];
            if (messageObject4.getId() == 0) {
                return;
            }
            ArrayList<DelayedMessage> arrayList6 = this.delayedMessages.get(messageObject4.messageOwner.attachPath);
            if (arrayList6 != null) {
                while (true) {
                    if (i3 >= arrayList6.size()) {
                        break;
                    }
                    DelayedMessage delayedMessage3 = arrayList6.get(i3);
                    if (delayedMessage3.type == 4) {
                        int iIndexOf3 = delayedMessage3.messageObjects.indexOf(messageObject4);
                        delayedMessage3.photoSize = (TLRPC$PhotoSize) delayedMessage3.extraHashMap.get(messageObject4.messageOwner.attachPath + "_t");
                        delayedMessage3.performMediaUpload = true;
                        performSendDelayedMessage(delayedMessage3, iIndexOf3);
                        arrayList6.remove(i3);
                        break;
                    }
                    if (delayedMessage3.obj == messageObject4) {
                        delayedMessage3.videoEditedInfo = null;
                        performSendDelayedMessage(delayedMessage3);
                        arrayList6.remove(i3);
                        break;
                    }
                    i3++;
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
        if (id == NotificationCenter.fileNewChunkAvailable) {
            MessageObject messageObject6 = (MessageObject) args[0];
            if (messageObject6.getId() == 0) {
                return;
            }
            String str8 = (String) args[1];
            long jLongValue = ((Long) args[2]).longValue();
            long jLongValue2 = ((Long) args[3]).longValue();
            getFileLoader().checkUploadNewDataAvailable(str8, DialogObject.isEncryptedDialog(messageObject6.getDialogId()), jLongValue, jLongValue2);
            if (jLongValue2 != 0) {
                stopVideoService(messageObject6.messageOwner.attachPath);
                ArrayList<DelayedMessage> arrayList7 = this.delayedMessages.get(messageObject6.messageOwner.attachPath);
                if (arrayList7 != null) {
                    for (int i5 = 0; i5 < arrayList7.size(); i5++) {
                        DelayedMessage delayedMessage4 = arrayList7.get(i5);
                        if (delayedMessage4.type == 4) {
                            int i6 = 0;
                            while (true) {
                                if (i6 >= delayedMessage4.messageObjects.size()) {
                                    break;
                                }
                                MessageObject messageObject7 = delayedMessage4.messageObjects.get(i6);
                                if (messageObject7 == messageObject6) {
                                    delayedMessage4.obj.shouldRemoveVideoEditedInfo = true;
                                    messageObject7.messageOwner.params.remove("ve");
                                    messageObject7.messageOwner.media.document.size = (int) jLongValue2;
                                    ArrayList<TLRPC$Message> arrayList8 = new ArrayList<>();
                                    arrayList8.add(messageObject7.messageOwner);
                                    getMessagesStorage().putMessages(arrayList8, false, true, false, 0, messageObject7.scheduled);
                                    break;
                                }
                                i6++;
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
        if (id == NotificationCenter.filePreparingFailed) {
            MessageObject messageObject9 = (MessageObject) args[0];
            if (messageObject9.getId() == 0) {
                return;
            }
            String str9 = (String) args[1];
            stopVideoService(messageObject9.messageOwner.attachPath);
            ArrayList<DelayedMessage> arrayList10 = this.delayedMessages.get(str9);
            if (arrayList10 != null) {
                int i7 = 0;
                while (i7 < arrayList10.size()) {
                    DelayedMessage delayedMessage5 = arrayList10.get(i7);
                    if (delayedMessage5.type == 4) {
                        for (int i8 = 0; i8 < delayedMessage5.messages.size(); i8++) {
                            if (delayedMessage5.messageObjects.get(i8) == messageObject9) {
                                delayedMessage5.markAsError();
                                arrayList10.remove(i7);
                                i7--;
                                break;
                            }
                        }
                    } else if (delayedMessage5.obj == messageObject9) {
                        delayedMessage5.markAsError();
                        arrayList10.remove(i7);
                        i7--;
                        break;
                        break;
                    }
                    i7++;
                }
                if (arrayList10.isEmpty()) {
                    this.delayedMessages.remove(str9);
                    return;
                }
                return;
            }
            return;
        }
        if (id == NotificationCenter.httpFileDidLoad) {
            final String str10 = (String) args[0];
            ArrayList<DelayedMessage> arrayList11 = this.delayedMessages.get(str10);
            if (arrayList11 != null) {
                int i9 = 0;
                while (i9 < arrayList11.size()) {
                    final DelayedMessage delayedMessage6 = arrayList11.get(i9);
                    int i10 = delayedMessage6.type;
                    if (i10 == 0) {
                        messageObject = delayedMessage6.obj;
                        c = 0;
                    } else {
                        if (i10 == 2) {
                            messageObject2 = delayedMessage6.obj;
                        } else if (i10 == 4) {
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
                        Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$KirVim1lthODeubIiKLCumbzy9g
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$didReceivedNotification$2$SendMessagesHelper(file, messageObject, delayedMessage6, str10);
                            }
                        });
                    } else {
                        if (c == 1) {
                            final File file2 = new File(FileLoader.getDirectory(4), Utilities.MD5(str10) + ".gif");
                            Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$veNitfSlDBeBViRWtNO6jMe55lM
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f$0.lambda$didReceivedNotification$4$SendMessagesHelper(delayedMessage6, file2, messageObject);
                                }
                            });
                        }
                        i9++;
                        messageObject5 = null;
                    }
                    i9++;
                    messageObject5 = null;
                }
                this.delayedMessages.remove(str10);
                return;
            }
            return;
        }
        if (id == NotificationCenter.fileLoaded) {
            String str11 = (String) args[0];
            ArrayList<DelayedMessage> arrayList12 = this.delayedMessages.get(str11);
            if (arrayList12 != null) {
                while (i3 < arrayList12.size()) {
                    performSendDelayedMessage(arrayList12.get(i3));
                    i3++;
                }
                this.delayedMessages.remove(str11);
                return;
            }
            return;
        }
        if ((id == NotificationCenter.httpFileDidFailedLoad || id == NotificationCenter.fileLoadFailed) && (arrayList = this.delayedMessages.get((str = (String) args[0]))) != null) {
            while (i3 < arrayList.size()) {
                arrayList.get(i3).markAsError();
                i3++;
            }
            this.delayedMessages.remove(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$didReceivedNotification$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$didReceivedNotification$2$SendMessagesHelper(final File file, final MessageObject messageObject, final DelayedMessage delayedMessage, final String str) {
        final TLRPC$TL_photo tLRPC$TL_photoGeneratePhotoSizes = generatePhotoSizes(file.toString(), null);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$4_vPu6ZDy5AKRF1hvSgnej566Jo
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$didReceivedNotification$1$SendMessagesHelper(tLRPC$TL_photoGeneratePhotoSizes, messageObject, file, delayedMessage, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$didReceivedNotification$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$didReceivedNotification$1$SendMessagesHelper(TLRPC$TL_photo tLRPC$TL_photo, MessageObject messageObject, File file, DelayedMessage delayedMessage, String str) {
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
    /* renamed from: lambda$didReceivedNotification$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$didReceivedNotification$4$SendMessagesHelper(final DelayedMessage delayedMessage, final File file, final MessageObject messageObject) {
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
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$YzbUGKnwGXXErHnZt8r1mVijXLI
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$didReceivedNotification$3$SendMessagesHelper(delayedMessage, file, document, messageObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$didReceivedNotification$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$didReceivedNotification$3$SendMessagesHelper(DelayedMessage delayedMessage, File file, TLRPC$Document tLRPC$Document, MessageObject messageObject) {
        delayedMessage.httpLocation = null;
        delayedMessage.obj.messageOwner.attachPath = file.toString();
        if (!tLRPC$Document.thumbs.isEmpty()) {
            TLRPC$PhotoSize tLRPC$PhotoSize = tLRPC$Document.thumbs.get(0);
            if (!(tLRPC$PhotoSize instanceof TLRPC$TL_photoStrippedSize)) {
                delayedMessage.photoSize = tLRPC$PhotoSize;
                delayedMessage.locationParent = tLRPC$Document;
            }
        }
        ArrayList<TLRPC$Message> arrayList = new ArrayList<>();
        arrayList.add(messageObject.messageOwner);
        getMessagesStorage().putMessages(arrayList, false, true, false, 0, messageObject.scheduled);
        delayedMessage.performMediaUpload = true;
        performSendDelayedMessage(delayedMessage);
        getNotificationCenter().postNotificationName(NotificationCenter.updateMessageMedia, delayedMessage.obj.messageOwner);
    }

    private void revertEditingMessageObject(MessageObject object) {
        object.cancelEditing = true;
        TLRPC$Message tLRPC$Message = object.messageOwner;
        tLRPC$Message.media = object.previousMedia;
        tLRPC$Message.message = object.previousMessage;
        ArrayList<TLRPC$MessageEntity> arrayList = object.previousMessageEntities;
        tLRPC$Message.entities = arrayList;
        tLRPC$Message.attachPath = object.previousAttachPath;
        tLRPC$Message.send_state = 0;
        if (arrayList != null) {
            tLRPC$Message.flags |= 128;
        } else {
            tLRPC$Message.flags &= -129;
        }
        object.previousMedia = null;
        object.previousMessage = null;
        object.previousMessageEntities = null;
        object.previousAttachPath = null;
        object.videoEditedInfo = null;
        object.type = -1;
        object.setType();
        object.caption = null;
        if (object.type != 0) {
            object.generateCaption();
        } else {
            object.resetLayout();
            object.checkLayout();
        }
        ArrayList<TLRPC$Message> arrayList2 = new ArrayList<>();
        arrayList2.add(object.messageOwner);
        getMessagesStorage().putMessages(arrayList2, false, true, false, 0, object.scheduled);
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(object);
        getNotificationCenter().postNotificationName(NotificationCenter.replaceMessagesObjects, Long.valueOf(object.getDialogId()), arrayList3);
    }

    public void cancelSendingMessage(MessageObject object) {
        ArrayList<MessageObject> arrayList = new ArrayList<>();
        arrayList.add(object);
        cancelSendingMessage(arrayList);
    }

    public void cancelSendingMessage(ArrayList<MessageObject> objects) {
        ArrayList<Integer> arrayList;
        Iterator<Map.Entry<String, ArrayList<DelayedMessage>>> it;
        DelayedMessage delayedMessage;
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList<Integer> arrayList4 = new ArrayList<>();
        long j = 0;
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        while (i < objects.size()) {
            MessageObject messageObject = objects.get(i);
            if (messageObject.scheduled) {
                z2 = true;
            }
            long dialogId = messageObject.getDialogId();
            arrayList4.add(Integer.valueOf(messageObject.getId()));
            if (removeFromSendingMessages(messageObject.getId(), messageObject.scheduled) != null) {
                arrayList = arrayList4;
                getConnectionsManager().cancelRequest(r13.reqId, true);
            } else {
                arrayList = arrayList4;
            }
            Iterator<Map.Entry<String, ArrayList<DelayedMessage>>> it2 = this.delayedMessages.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry<String, ArrayList<DelayedMessage>> next = it2.next();
                ArrayList<DelayedMessage> value = next.getValue();
                int i2 = 0;
                while (true) {
                    if (i2 >= value.size()) {
                        it = it2;
                        break;
                    }
                    DelayedMessage delayedMessage2 = value.get(i2);
                    it = it2;
                    if (delayedMessage2.type == 4) {
                        int i3 = -1;
                        MessageObject messageObject2 = null;
                        int i4 = 0;
                        while (true) {
                            if (i4 >= delayedMessage2.messageObjects.size()) {
                                break;
                            }
                            messageObject2 = delayedMessage2.messageObjects.get(i4);
                            if (messageObject2.getId() == messageObject.getId()) {
                                removeFromUploadingMessages(messageObject.getId(), messageObject.scheduled);
                                i3 = i4;
                                break;
                            }
                            i4++;
                        }
                        if (i3 >= 0) {
                            delayedMessage2.messageObjects.remove(i3);
                            delayedMessage2.messages.remove(i3);
                            delayedMessage2.originalPaths.remove(i3);
                            if (!delayedMessage2.parentObjects.isEmpty()) {
                                delayedMessage2.parentObjects.remove(i3);
                            }
                            TLObject tLObject = delayedMessage2.sendRequest;
                            if (tLObject != null) {
                                ((TLRPC$TL_messages_sendMultiMedia) tLObject).multi_media.remove(i3);
                            } else {
                                TLRPC$TL_messages_sendEncryptedMultiMedia tLRPC$TL_messages_sendEncryptedMultiMedia = (TLRPC$TL_messages_sendEncryptedMultiMedia) delayedMessage2.sendEncryptedRequest;
                                tLRPC$TL_messages_sendEncryptedMultiMedia.messages.remove(i3);
                                tLRPC$TL_messages_sendEncryptedMultiMedia.files.remove(i3);
                            }
                            MediaController.getInstance().cancelVideoConvert(messageObject);
                            String str = (String) delayedMessage2.extraHashMap.get(messageObject2);
                            if (str != null) {
                                arrayList2.add(str);
                            }
                            if (delayedMessage2.messageObjects.isEmpty()) {
                                delayedMessage2.sendDelayedRequests();
                            } else {
                                if (delayedMessage2.finalGroupMessage == messageObject.getId()) {
                                    ArrayList<MessageObject> arrayList5 = delayedMessage2.messageObjects;
                                    MessageObject messageObject3 = arrayList5.get(arrayList5.size() - 1);
                                    delayedMessage2.finalGroupMessage = messageObject3.getId();
                                    messageObject3.messageOwner.params.put("final", "1");
                                    TLRPC$TL_messages_messages tLRPC$TL_messages_messages = new TLRPC$TL_messages_messages();
                                    tLRPC$TL_messages_messages.messages.add(messageObject3.messageOwner);
                                    delayedMessage = delayedMessage2;
                                    getMessagesStorage().putMessages((TLRPC$messages_Messages) tLRPC$TL_messages_messages, delayedMessage2.peer, -2, 0, false, z2);
                                } else {
                                    delayedMessage = delayedMessage2;
                                }
                                if (!arrayList3.contains(delayedMessage)) {
                                    arrayList3.add(delayedMessage);
                                }
                            }
                        }
                    } else if (delayedMessage2.obj.getId() == messageObject.getId()) {
                        removeFromUploadingMessages(messageObject.getId(), messageObject.scheduled);
                        value.remove(i2);
                        delayedMessage2.sendDelayedRequests();
                        MediaController.getInstance().cancelVideoConvert(delayedMessage2.obj);
                        if (value.size() == 0) {
                            arrayList2.add(next.getKey());
                            if (delayedMessage2.sendEncryptedRequest != null) {
                                z = true;
                            }
                        }
                    } else {
                        i2++;
                        it2 = it;
                    }
                }
                it2 = it;
            }
            i++;
            j = dialogId;
            arrayList4 = arrayList;
        }
        ArrayList<Integer> arrayList6 = arrayList4;
        for (int i5 = 0; i5 < arrayList2.size(); i5++) {
            String str2 = (String) arrayList2.get(i5);
            if (str2.startsWith("http")) {
                ImageLoader.getInstance().cancelLoadHttpFile(str2);
            } else {
                getFileLoader().cancelFileUpload(str2, z);
            }
            stopVideoService(str2);
            this.delayedMessages.remove(str2);
        }
        int size = arrayList3.size();
        for (int i6 = 0; i6 < size; i6++) {
            sendReadyToSendGroup((DelayedMessage) arrayList3.get(i6), false, true);
        }
        if (objects.size() == 1 && objects.get(0).isEditing() && objects.get(0).previousMedia != null) {
            revertEditingMessageObject(objects.get(0));
        } else {
            getMessagesController().deleteMessages(arrayList6, null, null, j, false, z2);
        }
    }

    public boolean retrySendMessage(MessageObject messageObject, boolean unsent) {
        if (messageObject.getId() >= 0) {
            if (messageObject.isEditing()) {
                editMessage(messageObject, null, null, null, null, null, true, messageObject);
            }
            return false;
        }
        TLRPC$MessageAction tLRPC$MessageAction = messageObject.messageOwner.action;
        if (tLRPC$MessageAction instanceof TLRPC$TL_messageEncryptedAction) {
            TLRPC$EncryptedChat encryptedChat = getMessagesController().getEncryptedChat(Integer.valueOf(DialogObject.getEncryptedChatId(messageObject.getDialogId())));
            if (encryptedChat == null) {
                getMessagesStorage().markMessageAsSendError(messageObject.messageOwner, messageObject.scheduled);
                messageObject.messageOwner.send_state = 2;
                getNotificationCenter().postNotificationName(NotificationCenter.messageSendError, Integer.valueOf(messageObject.getId()));
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
            sendScreenshotMessage(getMessagesController().getUser(Long.valueOf(messageObject.getDialogId())), messageObject.getReplyMsgId(), messageObject.messageOwner);
        }
        if (unsent) {
            this.unsentMessages.put(messageObject.getId(), messageObject);
        }
        sendMessage(messageObject);
        return true;
    }

    protected void processSentMessage(int id) {
        int size = this.unsentMessages.size();
        this.unsentMessages.remove(id);
        if (size == 0 || this.unsentMessages.size() != 0) {
            return;
        }
        checkUnsentMessages();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void processForwardFromMyName(ir.eitaa.messenger.MessageObject r18, long r19) {
        /*
            Method dump skipped, instructions count: 400
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.SendMessagesHelper.processForwardFromMyName(ir.eitaa.messenger.MessageObject, long):void");
    }

    public void sendScreenshotMessage(TLRPC$User user, int messageId, TLRPC$Message resendMessage) {
        TLRPC$Message tLRPC$TL_messageService = resendMessage;
        if (user == null || messageId == 0 || user.id == getUserConfig().getClientUserId()) {
            return;
        }
        TLRPC$TL_messages_sendScreenshotNotification tLRPC$TL_messages_sendScreenshotNotification = new TLRPC$TL_messages_sendScreenshotNotification();
        TLRPC$TL_inputPeerUser tLRPC$TL_inputPeerUser = new TLRPC$TL_inputPeerUser();
        tLRPC$TL_messages_sendScreenshotNotification.peer = tLRPC$TL_inputPeerUser;
        tLRPC$TL_inputPeerUser.access_hash = user.access_hash;
        tLRPC$TL_inputPeerUser.user_id = user.id;
        if (tLRPC$TL_messageService != null) {
            tLRPC$TL_messages_sendScreenshotNotification.reply_to_msg_id = messageId;
            tLRPC$TL_messages_sendScreenshotNotification.random_id = tLRPC$TL_messageService.random_id;
        } else {
            tLRPC$TL_messageService = new TLRPC$TL_messageService();
            tLRPC$TL_messageService.random_id = getNextRandomId();
            tLRPC$TL_messageService.dialog_id = user.id;
            tLRPC$TL_messageService.unread = true;
            tLRPC$TL_messageService.out = true;
            int newMessageId = getUserConfig().getNewMessageId();
            tLRPC$TL_messageService.id = newMessageId;
            tLRPC$TL_messageService.local_id = newMessageId;
            TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
            tLRPC$TL_messageService.from_id = tLRPC$TL_peerUser;
            tLRPC$TL_peerUser.user_id = getUserConfig().getClientUserId();
            int i = tLRPC$TL_messageService.flags | Factory.DEVICE_HAS_CRAPPY_OPENSLES;
            tLRPC$TL_messageService.flags = i;
            tLRPC$TL_messageService.flags = i | 8;
            TLRPC$TL_messageReplyHeader tLRPC$TL_messageReplyHeader = new TLRPC$TL_messageReplyHeader();
            tLRPC$TL_messageService.reply_to = tLRPC$TL_messageReplyHeader;
            tLRPC$TL_messageReplyHeader.reply_to_msg_id = messageId;
            TLRPC$TL_peerUser tLRPC$TL_peerUser2 = new TLRPC$TL_peerUser();
            tLRPC$TL_messageService.peer_id = tLRPC$TL_peerUser2;
            tLRPC$TL_peerUser2.user_id = user.id;
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

    public void sendSticker(TLRPC$Document document, String query, final long peer, final MessageObject replyToMsg, final MessageObject replyToTopMsg, final Object parentObject, final MessageObject.SendAnimationData sendAnimationData, final boolean notify, final int scheduleDate) throws IOException {
        final TLRPC$Document tLRPC$Document;
        HashMap<String, String> map;
        if (document == null) {
            return;
        }
        if (DialogObject.isEncryptedDialog(peer)) {
            if (getMessagesController().getEncryptedChat(Integer.valueOf(DialogObject.getEncryptedChatId(peer))) == null) {
                return;
            }
            TLRPC$TL_document_layer82 tLRPC$TL_document_layer82 = new TLRPC$TL_document_layer82();
            tLRPC$TL_document_layer82.id = document.id;
            tLRPC$TL_document_layer82.access_hash = document.access_hash;
            tLRPC$TL_document_layer82.date = document.date;
            tLRPC$TL_document_layer82.mime_type = document.mime_type;
            byte[] bArr = document.file_reference;
            tLRPC$TL_document_layer82.file_reference = bArr;
            if (bArr == null) {
                tLRPC$TL_document_layer82.file_reference = new byte[0];
            }
            tLRPC$TL_document_layer82.size = document.size;
            tLRPC$TL_document_layer82.dc_id = document.dc_id;
            tLRPC$TL_document_layer82.attributes = new ArrayList<>(document.attributes);
            if (tLRPC$TL_document_layer82.mime_type == null) {
                tLRPC$TL_document_layer82.mime_type = "";
            }
            TLRPC$PhotoSize closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(document.thumbs, 90);
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
            tLRPC$Document = tLRPC$TL_document_layer82;
        } else {
            tLRPC$Document = document;
        }
        if (MessageObject.isGifDocument(tLRPC$Document)) {
            mediaSendQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$XJhj5d6mvGcdnfNkLnkfwohCQ0c
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$sendSticker$6$SendMessagesHelper(tLRPC$Document, peer, replyToMsg, replyToTopMsg, notify, scheduleDate, parentObject, sendAnimationData);
                }
            });
            return;
        }
        if (TextUtils.isEmpty(query)) {
            map = null;
        } else {
            map = new HashMap<>();
            map.put("query", query);
        }
        sendMessage((TLRPC$TL_document) tLRPC$Document, null, null, peer, replyToMsg, replyToTopMsg, null, null, null, map, notify, scheduleDate, 0, parentObject, sendAnimationData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$sendSticker$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$sendSticker$6$SendMessagesHelper(final TLRPC$Document tLRPC$Document, final long j, final MessageObject messageObject, final MessageObject messageObject2, final boolean z, final int i, final Object obj, final MessageObject.SendAnimationData sendAnimationData) {
        String str;
        final Bitmap[] bitmapArr = new Bitmap[1];
        final String[] strArr = new String[1];
        String key = ImageLocation.getForDocument(tLRPC$Document).getKey(null, null, false);
        if ("video/mp4".equals(tLRPC$Document.mime_type)) {
            str = ".mp4";
        } else {
            str = "video/x-matroska".equals(tLRPC$Document.mime_type) ? ".mkv" : "";
        }
        File file = new File(FileLoader.getDirectory(3), key + str);
        if (!file.exists()) {
            file = new File(FileLoader.getDirectory(2), key + str);
        }
        ensureMediaThumbExists(false, tLRPC$Document, file.getAbsolutePath(), null, 0L);
        strArr[0] = getKeyForPhotoSize(FileLoader.getClosestPhotoSizeWithSize(tLRPC$Document.thumbs, 320), bitmapArr, true, true);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$-QkGa6fTbfgPtriJIFOBj6jY0Cw
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$sendSticker$5$SendMessagesHelper(bitmapArr, strArr, tLRPC$Document, j, messageObject, messageObject2, z, i, obj, sendAnimationData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$sendSticker$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$sendSticker$5$SendMessagesHelper(Bitmap[] bitmapArr, String[] strArr, TLRPC$Document tLRPC$Document, long j, MessageObject messageObject, MessageObject messageObject2, boolean z, int i, Object obj, MessageObject.SendAnimationData sendAnimationData) {
        if (bitmapArr[0] != null && strArr[0] != null) {
            ImageLoader.getInstance().putImageToCache(new BitmapDrawable(bitmapArr[0]), strArr[0]);
        }
        sendMessage((TLRPC$TL_document) tLRPC$Document, null, null, j, messageObject, messageObject2, null, null, null, null, z, i, 0, obj, sendAnimationData);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0553  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x055d  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0576  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x05ba  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x05c0  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x05d0  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x05e7  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x060e  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0610  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0632  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0660  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0681  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0683  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x0698  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x069a  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x06a2  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x06de  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x0728  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x073f  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x0742  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x0751  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x0753  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x0777  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x0798  */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v19, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v24 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int sendMessage(java.util.ArrayList<ir.eitaa.messenger.MessageObject> r54, final long r55, boolean r57, boolean r58, boolean r59, final int r60) {
        /*
            Method dump skipped, instructions count: 2353
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.SendMessagesHelper.sendMessage(java.util.ArrayList, long, boolean, boolean, boolean, int):int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01c2  */
    /* renamed from: lambda$sendMessage$14, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$sendMessage$14$SendMessagesHelper(final long r27, final int r29, boolean r30, boolean r31, androidx.collection.LongSparseArray r32, java.util.ArrayList r33, java.util.ArrayList r34, final ir.eitaa.messenger.MessageObject r35, final ir.eitaa.tgnet.TLRPC$Peer r36, final ir.eitaa.tgnet.TLRPC$TL_messages_forwardMessages r37, ir.eitaa.tgnet.TLObject r38, final ir.eitaa.tgnet.TLRPC$TL_error r39) {
        /*
            Method dump skipped, instructions count: 557
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.SendMessagesHelper.lambda$sendMessage$14$SendMessagesHelper(long, int, boolean, boolean, androidx.collection.LongSparseArray, java.util.ArrayList, java.util.ArrayList, ir.eitaa.messenger.MessageObject, ir.eitaa.tgnet.TLRPC$Peer, ir.eitaa.tgnet.TLRPC$TL_messages_forwardMessages, ir.eitaa.tgnet.TLObject, ir.eitaa.tgnet.TLRPC$TL_error):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$sendMessage$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$sendMessage$9$SendMessagesHelper(final int i, final TLRPC$Message tLRPC$Message, final ArrayList arrayList, final MessageObject messageObject, final int i2) {
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        arrayList2.add(Integer.valueOf(i));
        getMessagesController().deleteMessages(arrayList2, null, null, tLRPC$Message.dialog_id, false, true);
        getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$2VWfutobItB6AYnxcpHPbvSm6jQ
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$sendMessage$8$SendMessagesHelper(arrayList, messageObject, tLRPC$Message, i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$sendMessage$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$sendMessage$8$SendMessagesHelper(ArrayList arrayList, final MessageObject messageObject, final TLRPC$Message tLRPC$Message, final int i, final int i2) {
        getMessagesStorage().putMessages((ArrayList<TLRPC$Message>) arrayList, true, false, false, 0, false);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$TvSvvxS93cHpQlj0r-bqSEIiLrc
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$sendMessage$7$SendMessagesHelper(messageObject, tLRPC$Message, i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$sendMessage$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$sendMessage$7$SendMessagesHelper(MessageObject messageObject, TLRPC$Message tLRPC$Message, int i, int i2) {
        ArrayList<MessageObject> arrayList = new ArrayList<>();
        arrayList.add(new MessageObject(messageObject.currentAccount, messageObject.messageOwner, true, true));
        getMessagesController().updateInterfaceWithMessages(tLRPC$Message.dialog_id, arrayList, false);
        getMediaDataController().increasePeerRaiting(tLRPC$Message.dialog_id);
        processSentMessage(i);
        removeFromSendingMessages(i, i2 != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$sendMessage$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$sendMessage$11$SendMessagesHelper(final TLRPC$Message tLRPC$Message, TLRPC$Peer tLRPC$Peer, final int i, final int i2, ArrayList arrayList, final long j, final TLRPC$Message tLRPC$Message2, final int i3) {
        getMessagesStorage().updateMessageStateAndId(tLRPC$Message.random_id, MessageObject.getPeerId(tLRPC$Peer), Integer.valueOf(i), tLRPC$Message.id, 0, false, i2 != 0 ? 1 : 0);
        getMessagesStorage().putMessages((ArrayList<TLRPC$Message>) arrayList, true, false, false, 0, i2 != 0);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$ATpNf0Dvs9UlVIAnDvKlZ6jw1pM
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$sendMessage$10$SendMessagesHelper(tLRPC$Message, j, i, tLRPC$Message2, i3, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$sendMessage$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$sendMessage$10$SendMessagesHelper(TLRPC$Message tLRPC$Message, long j, int i, TLRPC$Message tLRPC$Message2, int i2, int i3) {
        tLRPC$Message.send_state = 0;
        getMediaDataController().increasePeerRaiting(j);
        NotificationCenter notificationCenter = getNotificationCenter();
        int i4 = NotificationCenter.messageReceivedByServer;
        Object[] objArr = new Object[7];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(tLRPC$Message2.id);
        objArr[2] = tLRPC$Message2;
        objArr[3] = Long.valueOf(j);
        objArr[4] = 0L;
        objArr[5] = Integer.valueOf(i2);
        objArr[6] = Boolean.valueOf(i3 != 0);
        notificationCenter.postNotificationName(i4, objArr);
        processSentMessage(i);
        removeFromSendingMessages(i, i3 != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$sendMessage$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$sendMessage$12$SendMessagesHelper(TLRPC$TL_error tLRPC$TL_error, TLRPC$TL_messages_forwardMessages tLRPC$TL_messages_forwardMessages) {
        AlertsCreator.processError(this.currentAccount, tLRPC$TL_error, null, tLRPC$TL_messages_forwardMessages, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$sendMessage$13, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$sendMessage$13$SendMessagesHelper(TLRPC$Message tLRPC$Message, int i) {
        tLRPC$Message.send_state = 2;
        getNotificationCenter().postNotificationName(NotificationCenter.messageSendError, Integer.valueOf(tLRPC$Message.id));
        processSentMessage(tLRPC$Message.id);
        removeFromSendingMessages(tLRPC$Message.id, i != 0);
    }

    private void writePreviousMessageData(TLRPC$Message message, SerializedData data) {
        TLRPC$MessageMedia tLRPC$MessageMedia = message.media;
        if (tLRPC$MessageMedia == null) {
            new TLRPC$TL_messageMediaEmpty().serializeToStream(data);
        } else {
            tLRPC$MessageMedia.serializeToStream(data);
        }
        String str = message.message;
        if (str == null) {
            str = "";
        }
        data.writeString(str);
        String str2 = message.attachPath;
        data.writeString(str2 != null ? str2 : "");
        int size = message.entities.size();
        data.writeInt32(size);
        for (int i = 0; i < size; i++) {
            message.entities.get(i).serializeToStream(data);
        }
    }

    public void editMessage(MessageObject messageObject, TLRPC$TL_photo photo, VideoEditedInfo videoEditedInfo, TLRPC$TL_document document, String path, HashMap<String, String> params, boolean retry, Object parentObject) {
        editMessage(messageObject, photo, videoEditedInfo, document, path, params, retry, parentObject, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0481 A[Catch: Exception -> 0x059a, TryCatch #0 {Exception -> 0x059a, blocks: (B:9:0x0020, B:11:0x002b, B:13:0x003d, B:20:0x004e, B:23:0x0058, B:26:0x005d, B:28:0x0061, B:40:0x0087, B:43:0x008d, B:45:0x0093, B:47:0x009a, B:74:0x015a, B:76:0x015e, B:77:0x0162, B:85:0x017c, B:90:0x0185, B:92:0x0189, B:94:0x0199, B:96:0x019d, B:113:0x01f6, B:115:0x021c, B:117:0x0224, B:120:0x0229, B:121:0x0230, B:122:0x0233, B:125:0x025e, B:127:0x0264, B:216:0x046a, B:218:0x0481, B:220:0x0489, B:221:0x0491, B:223:0x0495, B:224:0x04a3, B:226:0x04a7, B:230:0x04ba, B:232:0x04c0, B:239:0x04ed, B:234:0x04c9, B:236:0x04dd, B:238:0x04e3, B:241:0x04f3, B:244:0x04f8, B:248:0x0513, B:249:0x0518, B:253:0x052e, B:254:0x0533, B:257:0x054b, B:261:0x0564, B:262:0x0568, B:266:0x0582, B:267:0x0586, B:141:0x0285, B:143:0x028c, B:145:0x0294, B:147:0x02a5, B:148:0x02be, B:150:0x02cc, B:157:0x02f8, B:159:0x030c, B:161:0x0312, B:163:0x0318, B:164:0x031b, B:153:0x02d7, B:155:0x02f1, B:168:0x0336, B:170:0x033f, B:172:0x0347, B:174:0x0358, B:175:0x0369, B:176:0x0372, B:179:0x0384, B:183:0x038d, B:185:0x0394, B:187:0x039c, B:194:0x03cb, B:196:0x03e5, B:198:0x03f2, B:199:0x03f6, B:190:0x03a9, B:192:0x03c5, B:202:0x0400, B:209:0x0439, B:211:0x044d, B:213:0x045a, B:214:0x045e, B:205:0x0418, B:207:0x0432, B:97:0x01a6, B:99:0x01ac, B:100:0x01b3, B:102:0x01b7, B:111:0x01f0, B:103:0x01c0, B:105:0x01d3, B:107:0x01d9, B:108:0x01e2, B:110:0x01ea, B:82:0x0171, B:84:0x0179, B:29:0x0069, B:31:0x006d, B:37:0x007d, B:48:0x00a7, B:50:0x00b9, B:51:0x00be, B:53:0x00e5, B:55:0x00f6, B:57:0x00fc, B:59:0x0102, B:73:0x014e, B:60:0x0105, B:63:0x0123, B:70:0x0140, B:71:0x014a), top: B:272:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0489 A[Catch: Exception -> 0x059a, TryCatch #0 {Exception -> 0x059a, blocks: (B:9:0x0020, B:11:0x002b, B:13:0x003d, B:20:0x004e, B:23:0x0058, B:26:0x005d, B:28:0x0061, B:40:0x0087, B:43:0x008d, B:45:0x0093, B:47:0x009a, B:74:0x015a, B:76:0x015e, B:77:0x0162, B:85:0x017c, B:90:0x0185, B:92:0x0189, B:94:0x0199, B:96:0x019d, B:113:0x01f6, B:115:0x021c, B:117:0x0224, B:120:0x0229, B:121:0x0230, B:122:0x0233, B:125:0x025e, B:127:0x0264, B:216:0x046a, B:218:0x0481, B:220:0x0489, B:221:0x0491, B:223:0x0495, B:224:0x04a3, B:226:0x04a7, B:230:0x04ba, B:232:0x04c0, B:239:0x04ed, B:234:0x04c9, B:236:0x04dd, B:238:0x04e3, B:241:0x04f3, B:244:0x04f8, B:248:0x0513, B:249:0x0518, B:253:0x052e, B:254:0x0533, B:257:0x054b, B:261:0x0564, B:262:0x0568, B:266:0x0582, B:267:0x0586, B:141:0x0285, B:143:0x028c, B:145:0x0294, B:147:0x02a5, B:148:0x02be, B:150:0x02cc, B:157:0x02f8, B:159:0x030c, B:161:0x0312, B:163:0x0318, B:164:0x031b, B:153:0x02d7, B:155:0x02f1, B:168:0x0336, B:170:0x033f, B:172:0x0347, B:174:0x0358, B:175:0x0369, B:176:0x0372, B:179:0x0384, B:183:0x038d, B:185:0x0394, B:187:0x039c, B:194:0x03cb, B:196:0x03e5, B:198:0x03f2, B:199:0x03f6, B:190:0x03a9, B:192:0x03c5, B:202:0x0400, B:209:0x0439, B:211:0x044d, B:213:0x045a, B:214:0x045e, B:205:0x0418, B:207:0x0432, B:97:0x01a6, B:99:0x01ac, B:100:0x01b3, B:102:0x01b7, B:111:0x01f0, B:103:0x01c0, B:105:0x01d3, B:107:0x01d9, B:108:0x01e2, B:110:0x01ea, B:82:0x0171, B:84:0x0179, B:29:0x0069, B:31:0x006d, B:37:0x007d, B:48:0x00a7, B:50:0x00b9, B:51:0x00be, B:53:0x00e5, B:55:0x00f6, B:57:0x00fc, B:59:0x0102, B:73:0x014e, B:60:0x0105, B:63:0x0123, B:70:0x0140, B:71:0x014a), top: B:272:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0495 A[Catch: Exception -> 0x059a, TryCatch #0 {Exception -> 0x059a, blocks: (B:9:0x0020, B:11:0x002b, B:13:0x003d, B:20:0x004e, B:23:0x0058, B:26:0x005d, B:28:0x0061, B:40:0x0087, B:43:0x008d, B:45:0x0093, B:47:0x009a, B:74:0x015a, B:76:0x015e, B:77:0x0162, B:85:0x017c, B:90:0x0185, B:92:0x0189, B:94:0x0199, B:96:0x019d, B:113:0x01f6, B:115:0x021c, B:117:0x0224, B:120:0x0229, B:121:0x0230, B:122:0x0233, B:125:0x025e, B:127:0x0264, B:216:0x046a, B:218:0x0481, B:220:0x0489, B:221:0x0491, B:223:0x0495, B:224:0x04a3, B:226:0x04a7, B:230:0x04ba, B:232:0x04c0, B:239:0x04ed, B:234:0x04c9, B:236:0x04dd, B:238:0x04e3, B:241:0x04f3, B:244:0x04f8, B:248:0x0513, B:249:0x0518, B:253:0x052e, B:254:0x0533, B:257:0x054b, B:261:0x0564, B:262:0x0568, B:266:0x0582, B:267:0x0586, B:141:0x0285, B:143:0x028c, B:145:0x0294, B:147:0x02a5, B:148:0x02be, B:150:0x02cc, B:157:0x02f8, B:159:0x030c, B:161:0x0312, B:163:0x0318, B:164:0x031b, B:153:0x02d7, B:155:0x02f1, B:168:0x0336, B:170:0x033f, B:172:0x0347, B:174:0x0358, B:175:0x0369, B:176:0x0372, B:179:0x0384, B:183:0x038d, B:185:0x0394, B:187:0x039c, B:194:0x03cb, B:196:0x03e5, B:198:0x03f2, B:199:0x03f6, B:190:0x03a9, B:192:0x03c5, B:202:0x0400, B:209:0x0439, B:211:0x044d, B:213:0x045a, B:214:0x045e, B:205:0x0418, B:207:0x0432, B:97:0x01a6, B:99:0x01ac, B:100:0x01b3, B:102:0x01b7, B:111:0x01f0, B:103:0x01c0, B:105:0x01d3, B:107:0x01d9, B:108:0x01e2, B:110:0x01ea, B:82:0x0171, B:84:0x0179, B:29:0x0069, B:31:0x006d, B:37:0x007d, B:48:0x00a7, B:50:0x00b9, B:51:0x00be, B:53:0x00e5, B:55:0x00f6, B:57:0x00fc, B:59:0x0102, B:73:0x014e, B:60:0x0105, B:63:0x0123, B:70:0x0140, B:71:0x014a), top: B:272:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:226:0x04a7 A[Catch: Exception -> 0x059a, TryCatch #0 {Exception -> 0x059a, blocks: (B:9:0x0020, B:11:0x002b, B:13:0x003d, B:20:0x004e, B:23:0x0058, B:26:0x005d, B:28:0x0061, B:40:0x0087, B:43:0x008d, B:45:0x0093, B:47:0x009a, B:74:0x015a, B:76:0x015e, B:77:0x0162, B:85:0x017c, B:90:0x0185, B:92:0x0189, B:94:0x0199, B:96:0x019d, B:113:0x01f6, B:115:0x021c, B:117:0x0224, B:120:0x0229, B:121:0x0230, B:122:0x0233, B:125:0x025e, B:127:0x0264, B:216:0x046a, B:218:0x0481, B:220:0x0489, B:221:0x0491, B:223:0x0495, B:224:0x04a3, B:226:0x04a7, B:230:0x04ba, B:232:0x04c0, B:239:0x04ed, B:234:0x04c9, B:236:0x04dd, B:238:0x04e3, B:241:0x04f3, B:244:0x04f8, B:248:0x0513, B:249:0x0518, B:253:0x052e, B:254:0x0533, B:257:0x054b, B:261:0x0564, B:262:0x0568, B:266:0x0582, B:267:0x0586, B:141:0x0285, B:143:0x028c, B:145:0x0294, B:147:0x02a5, B:148:0x02be, B:150:0x02cc, B:157:0x02f8, B:159:0x030c, B:161:0x0312, B:163:0x0318, B:164:0x031b, B:153:0x02d7, B:155:0x02f1, B:168:0x0336, B:170:0x033f, B:172:0x0347, B:174:0x0358, B:175:0x0369, B:176:0x0372, B:179:0x0384, B:183:0x038d, B:185:0x0394, B:187:0x039c, B:194:0x03cb, B:196:0x03e5, B:198:0x03f2, B:199:0x03f6, B:190:0x03a9, B:192:0x03c5, B:202:0x0400, B:209:0x0439, B:211:0x044d, B:213:0x045a, B:214:0x045e, B:205:0x0418, B:207:0x0432, B:97:0x01a6, B:99:0x01ac, B:100:0x01b3, B:102:0x01b7, B:111:0x01f0, B:103:0x01c0, B:105:0x01d3, B:107:0x01d9, B:108:0x01e2, B:110:0x01ea, B:82:0x0171, B:84:0x0179, B:29:0x0069, B:31:0x006d, B:37:0x007d, B:48:0x00a7, B:50:0x00b9, B:51:0x00be, B:53:0x00e5, B:55:0x00f6, B:57:0x00fc, B:59:0x0102, B:73:0x014e, B:60:0x0105, B:63:0x0123, B:70:0x0140, B:71:0x014a), top: B:272:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:241:0x04f3 A[Catch: Exception -> 0x059a, TryCatch #0 {Exception -> 0x059a, blocks: (B:9:0x0020, B:11:0x002b, B:13:0x003d, B:20:0x004e, B:23:0x0058, B:26:0x005d, B:28:0x0061, B:40:0x0087, B:43:0x008d, B:45:0x0093, B:47:0x009a, B:74:0x015a, B:76:0x015e, B:77:0x0162, B:85:0x017c, B:90:0x0185, B:92:0x0189, B:94:0x0199, B:96:0x019d, B:113:0x01f6, B:115:0x021c, B:117:0x0224, B:120:0x0229, B:121:0x0230, B:122:0x0233, B:125:0x025e, B:127:0x0264, B:216:0x046a, B:218:0x0481, B:220:0x0489, B:221:0x0491, B:223:0x0495, B:224:0x04a3, B:226:0x04a7, B:230:0x04ba, B:232:0x04c0, B:239:0x04ed, B:234:0x04c9, B:236:0x04dd, B:238:0x04e3, B:241:0x04f3, B:244:0x04f8, B:248:0x0513, B:249:0x0518, B:253:0x052e, B:254:0x0533, B:257:0x054b, B:261:0x0564, B:262:0x0568, B:266:0x0582, B:267:0x0586, B:141:0x0285, B:143:0x028c, B:145:0x0294, B:147:0x02a5, B:148:0x02be, B:150:0x02cc, B:157:0x02f8, B:159:0x030c, B:161:0x0312, B:163:0x0318, B:164:0x031b, B:153:0x02d7, B:155:0x02f1, B:168:0x0336, B:170:0x033f, B:172:0x0347, B:174:0x0358, B:175:0x0369, B:176:0x0372, B:179:0x0384, B:183:0x038d, B:185:0x0394, B:187:0x039c, B:194:0x03cb, B:196:0x03e5, B:198:0x03f2, B:199:0x03f6, B:190:0x03a9, B:192:0x03c5, B:202:0x0400, B:209:0x0439, B:211:0x044d, B:213:0x045a, B:214:0x045e, B:205:0x0418, B:207:0x0432, B:97:0x01a6, B:99:0x01ac, B:100:0x01b3, B:102:0x01b7, B:111:0x01f0, B:103:0x01c0, B:105:0x01d3, B:107:0x01d9, B:108:0x01e2, B:110:0x01ea, B:82:0x0171, B:84:0x0179, B:29:0x0069, B:31:0x006d, B:37:0x007d, B:48:0x00a7, B:50:0x00b9, B:51:0x00be, B:53:0x00e5, B:55:0x00f6, B:57:0x00fc, B:59:0x0102, B:73:0x014e, B:60:0x0105, B:63:0x0123, B:70:0x0140, B:71:0x014a), top: B:272:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:244:0x04f8 A[Catch: Exception -> 0x059a, TryCatch #0 {Exception -> 0x059a, blocks: (B:9:0x0020, B:11:0x002b, B:13:0x003d, B:20:0x004e, B:23:0x0058, B:26:0x005d, B:28:0x0061, B:40:0x0087, B:43:0x008d, B:45:0x0093, B:47:0x009a, B:74:0x015a, B:76:0x015e, B:77:0x0162, B:85:0x017c, B:90:0x0185, B:92:0x0189, B:94:0x0199, B:96:0x019d, B:113:0x01f6, B:115:0x021c, B:117:0x0224, B:120:0x0229, B:121:0x0230, B:122:0x0233, B:125:0x025e, B:127:0x0264, B:216:0x046a, B:218:0x0481, B:220:0x0489, B:221:0x0491, B:223:0x0495, B:224:0x04a3, B:226:0x04a7, B:230:0x04ba, B:232:0x04c0, B:239:0x04ed, B:234:0x04c9, B:236:0x04dd, B:238:0x04e3, B:241:0x04f3, B:244:0x04f8, B:248:0x0513, B:249:0x0518, B:253:0x052e, B:254:0x0533, B:257:0x054b, B:261:0x0564, B:262:0x0568, B:266:0x0582, B:267:0x0586, B:141:0x0285, B:143:0x028c, B:145:0x0294, B:147:0x02a5, B:148:0x02be, B:150:0x02cc, B:157:0x02f8, B:159:0x030c, B:161:0x0312, B:163:0x0318, B:164:0x031b, B:153:0x02d7, B:155:0x02f1, B:168:0x0336, B:170:0x033f, B:172:0x0347, B:174:0x0358, B:175:0x0369, B:176:0x0372, B:179:0x0384, B:183:0x038d, B:185:0x0394, B:187:0x039c, B:194:0x03cb, B:196:0x03e5, B:198:0x03f2, B:199:0x03f6, B:190:0x03a9, B:192:0x03c5, B:202:0x0400, B:209:0x0439, B:211:0x044d, B:213:0x045a, B:214:0x045e, B:205:0x0418, B:207:0x0432, B:97:0x01a6, B:99:0x01ac, B:100:0x01b3, B:102:0x01b7, B:111:0x01f0, B:103:0x01c0, B:105:0x01d3, B:107:0x01d9, B:108:0x01e2, B:110:0x01ea, B:82:0x0171, B:84:0x0179, B:29:0x0069, B:31:0x006d, B:37:0x007d, B:48:0x00a7, B:50:0x00b9, B:51:0x00be, B:53:0x00e5, B:55:0x00f6, B:57:0x00fc, B:59:0x0102, B:73:0x014e, B:60:0x0105, B:63:0x0123, B:70:0x0140, B:71:0x014a), top: B:272:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:245:0x050e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void editMessage(ir.eitaa.messenger.MessageObject r25, ir.eitaa.tgnet.TLRPC$TL_photo r26, ir.eitaa.messenger.VideoEditedInfo r27, ir.eitaa.tgnet.TLRPC$TL_document r28, java.lang.String r29, java.util.HashMap<java.lang.String, java.lang.String> r30, boolean r31, java.lang.Object r32, boolean r33) {
        /*
            Method dump skipped, instructions count: 1442
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.SendMessagesHelper.editMessage(ir.eitaa.messenger.MessageObject, ir.eitaa.tgnet.TLRPC$TL_photo, ir.eitaa.messenger.VideoEditedInfo, ir.eitaa.tgnet.TLRPC$TL_document, java.lang.String, java.util.HashMap, boolean, java.lang.Object, boolean):void");
    }

    public int editMessage(MessageObject messageObject, String message, boolean searchLinks, final BaseFragment fragment, ArrayList<TLRPC$MessageEntity> entities, int scheduleDate, boolean isMxb) {
        if (fragment == null || fragment.getParentActivity() == null) {
            return 0;
        }
        final TLRPC$TL_messages_editMessage tLRPC$TL_messages_editMessage = new TLRPC$TL_messages_editMessage();
        tLRPC$TL_messages_editMessage.peer = getMessagesController().getInputPeer(messageObject.getDialogId());
        if (isMxb) {
            tLRPC$TL_messages_editMessage.flags |= 16;
        }
        if (message != null) {
            tLRPC$TL_messages_editMessage.message = message;
            tLRPC$TL_messages_editMessage.flags |= Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS;
            tLRPC$TL_messages_editMessage.no_webpage = !searchLinks;
        }
        tLRPC$TL_messages_editMessage.id = messageObject.getId();
        if (entities != null) {
            tLRPC$TL_messages_editMessage.entities = entities;
            tLRPC$TL_messages_editMessage.flags |= 8;
        }
        if (scheduleDate != 0) {
            tLRPC$TL_messages_editMessage.schedule_date = scheduleDate;
            tLRPC$TL_messages_editMessage.flags |= 32768;
        }
        return getConnectionsManager().sendRequest(tLRPC$TL_messages_editMessage, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$3kkA1pWIko-WlQOwQYMncjtFQZ4
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$editMessage$16$SendMessagesHelper(fragment, tLRPC$TL_messages_editMessage, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$editMessage$16, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$editMessage$16$SendMessagesHelper(final BaseFragment baseFragment, final TLRPC$TL_messages_editMessage tLRPC$TL_messages_editMessage, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            getMessagesController().processUpdates((TLRPC$Updates) tLObject, false);
        } else {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$MMfqoo55HC0bARo4gYwDA5X_tQE
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$editMessage$15$SendMessagesHelper(tLRPC$TL_error, baseFragment, tLRPC$TL_messages_editMessage);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$editMessage$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$editMessage$15$SendMessagesHelper(TLRPC$TL_error tLRPC$TL_error, BaseFragment baseFragment, TLRPC$TL_messages_editMessage tLRPC$TL_messages_editMessage) {
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

    public void sendCurrentLocation(final MessageObject messageObject, final TLRPC$KeyboardButton button) {
        if (messageObject == null || button == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(messageObject.getDialogId());
        sb.append("_");
        sb.append(messageObject.getId());
        sb.append("_");
        sb.append(Utilities.bytesToHex(button.data));
        sb.append("_");
        sb.append(button instanceof TLRPC$TL_keyboardButtonGame ? "1" : "0");
        this.waitingForLocation.put(sb.toString(), messageObject);
        this.locationProvider.start();
    }

    public boolean isSendingCurrentLocation(MessageObject messageObject, TLRPC$KeyboardButton button) {
        if (messageObject == null || button == null) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(messageObject.getDialogId());
        sb.append("_");
        sb.append(messageObject.getId());
        sb.append("_");
        sb.append(Utilities.bytesToHex(button.data));
        sb.append("_");
        sb.append(button instanceof TLRPC$TL_keyboardButtonGame ? "1" : "0");
        return this.waitingForLocation.containsKey(sb.toString());
    }

    public void sendNotificationCallback(final long dialogId, final int msgId, final byte[] data) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$V0g7FFa-NWxm2-t8aqKbUJdeszE
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$sendNotificationCallback$19$SendMessagesHelper(dialogId, msgId, data);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$sendNotificationCallback$19, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$sendNotificationCallback$19$SendMessagesHelper(long j, int i, byte[] bArr) {
        TLRPC$Chat chatSync;
        TLRPC$User userSync;
        final String str = j + "_" + i + "_" + Utilities.bytesToHex(bArr) + "_0";
        this.waitingForCallback.put(str, Boolean.TRUE);
        if (DialogObject.isUserDialog(j)) {
            if (getMessagesController().getUser(Long.valueOf(j)) == null && (userSync = getMessagesStorage().getUserSync(j)) != null) {
                getMessagesController().putUser(userSync, true);
            }
        } else {
            long j2 = -j;
            if (getMessagesController().getChat(Long.valueOf(j2)) == null && (chatSync = getMessagesStorage().getChatSync(j2)) != null) {
                getMessagesController().putChat(chatSync, true);
            }
        }
        TLRPC$TL_messages_getBotCallbackAnswer tLRPC$TL_messages_getBotCallbackAnswer = new TLRPC$TL_messages_getBotCallbackAnswer();
        tLRPC$TL_messages_getBotCallbackAnswer.peer = getMessagesController().getInputPeer(j);
        tLRPC$TL_messages_getBotCallbackAnswer.msg_id = i;
        tLRPC$TL_messages_getBotCallbackAnswer.game = false;
        if (bArr != null) {
            tLRPC$TL_messages_getBotCallbackAnswer.flags |= 1;
            tLRPC$TL_messages_getBotCallbackAnswer.data = bArr;
        }
        getConnectionsManager().sendRequest(tLRPC$TL_messages_getBotCallbackAnswer, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$u393t_29r-dEsnT4qc3rvYXd0Oo
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$sendNotificationCallback$18$SendMessagesHelper(str, tLObject, tLRPC$TL_error);
            }
        }, 2);
        getMessagesController().markDialogAsRead(j, i, i, 0, false, 0, 0, true, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$sendNotificationCallback$17, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$sendNotificationCallback$17$SendMessagesHelper(String str) {
        this.waitingForCallback.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$sendNotificationCallback$18, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$sendNotificationCallback$18$SendMessagesHelper(final String str, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$zQHxkFz4WiLJSzxU6WKPQmMdrOQ
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$sendNotificationCallback$17$SendMessagesHelper(str);
            }
        });
    }

    public byte[] isSendingVote(MessageObject messageObject) {
        if (messageObject == null) {
            return null;
        }
        return this.waitingForVote.get("poll_" + messageObject.getPollId());
    }

    public int sendVote(final MessageObject messageObject, final ArrayList<TLRPC$TL_pollAnswer> answers, final Runnable finishRunnable) {
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
        tLRPC$TL_messages_sendVote.peer = getMessagesController().getInputPeer(messageObject.getDialogId());
        if (answers != null) {
            bArr = new byte[answers.size()];
            for (int i = 0; i < answers.size(); i++) {
                TLRPC$TL_pollAnswer tLRPC$TL_pollAnswer = answers.get(i);
                tLRPC$TL_messages_sendVote.options.add(tLRPC$TL_pollAnswer.option);
                bArr[i] = tLRPC$TL_pollAnswer.option[0];
            }
        } else {
            bArr = new byte[0];
        }
        this.waitingForVote.put(str, bArr);
        return getConnectionsManager().sendRequest(tLRPC$TL_messages_sendVote, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$PXyYa8z23UiVPL-TX22MVFZvASs
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$sendVote$21$SendMessagesHelper(messageObject, str, finishRunnable, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$sendVote$21, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$sendVote$21$SendMessagesHelper(MessageObject messageObject, final String str, final Runnable runnable, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            this.voteSendTime.put(messageObject.getPollId(), 0L);
            getMessagesController().processUpdates((TLRPC$Updates) tLObject, false);
            this.voteSendTime.put(messageObject.getPollId(), Long.valueOf(SystemClock.elapsedRealtime()));
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$YkLkmMolL5nH4x7gS2Q_YupBnac
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$sendVote$20$SendMessagesHelper(str, runnable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$sendVote$20, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$sendVote$20$SendMessagesHelper(String str, Runnable runnable) {
        this.waitingForVote.remove(str);
        if (runnable != null) {
            runnable.run();
        }
    }

    protected long getVoteSendTime(long pollId) {
        return this.voteSendTime.get(pollId, 0L).longValue();
    }

    public void sendReaction(MessageObject messageObject, CharSequence reaction, ChatActivity parentFragment) {
        if (messageObject == null || parentFragment == null) {
            return;
        }
        TLRPC$TL_messages_sendReaction tLRPC$TL_messages_sendReaction = new TLRPC$TL_messages_sendReaction();
        tLRPC$TL_messages_sendReaction.peer = getMessagesController().getInputPeer(messageObject.getDialogId());
        tLRPC$TL_messages_sendReaction.msg_id = messageObject.getId();
        if (reaction != null) {
            tLRPC$TL_messages_sendReaction.reaction = reaction.toString();
            tLRPC$TL_messages_sendReaction.flags |= 1;
        }
        getConnectionsManager().sendRequest(tLRPC$TL_messages_sendReaction, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$WM4qNoreuDIbDLOS6aKXS6Ty9Wg
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$sendReaction$22$SendMessagesHelper(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$sendReaction$22, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$sendReaction$22$SendMessagesHelper(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            getMessagesController().processUpdates((TLRPC$Updates) tLObject, false);
        }
    }

    public void requestUrlAuth(final String url, final ChatActivity parentFragment, final boolean ask) {
        final TLRPC$TL_messages_requestUrlAuth tLRPC$TL_messages_requestUrlAuth = new TLRPC$TL_messages_requestUrlAuth();
        tLRPC$TL_messages_requestUrlAuth.url = url;
        tLRPC$TL_messages_requestUrlAuth.flags |= 4;
        getConnectionsManager().sendRequest(tLRPC$TL_messages_requestUrlAuth, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$61elUs05TOoA34zJ2ZCW-aPJxhI
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                SendMessagesHelper.lambda$requestUrlAuth$23(parentFragment, tLRPC$TL_messages_requestUrlAuth, url, ask, tLObject, tLRPC$TL_error);
            }
        }, 2);
    }

    static /* synthetic */ void lambda$requestUrlAuth$23(ChatActivity chatActivity, TLRPC$TL_messages_requestUrlAuth tLRPC$TL_messages_requestUrlAuth, String str, boolean z, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
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

    public void sendCallback(final boolean cache, final MessageObject messageObject, final TLRPC$KeyboardButton button, final ChatActivity parentFragment) throws JSONException {
        lambda$sendCallback$24(cache, messageObject, button, null, null, parentFragment);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0088  */
    /* renamed from: sendCallback, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void lambda$sendCallback$24$SendMessagesHelper(final boolean r19, final ir.eitaa.messenger.MessageObject r20, final ir.eitaa.tgnet.TLRPC$KeyboardButton r21, final ir.eitaa.tgnet.TLRPC$InputCheckPasswordSRP r22, final ir.eitaa.ui.TwoStepVerificationActivity r23, final ir.eitaa.ui.ChatActivity r24) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 440
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.SendMessagesHelper.lambda$sendCallback$24(boolean, ir.eitaa.messenger.MessageObject, ir.eitaa.tgnet.TLRPC$KeyboardButton, ir.eitaa.tgnet.TLRPC$InputCheckPasswordSRP, ir.eitaa.ui.TwoStepVerificationActivity, ir.eitaa.ui.ChatActivity):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$sendCallback$30, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$sendCallback$30$SendMessagesHelper(final String str, final boolean z, final MessageObject messageObject, final TLRPC$KeyboardButton tLRPC$KeyboardButton, final ChatActivity chatActivity, final TwoStepVerificationActivity twoStepVerificationActivity, final TLObject[] tLObjectArr, final TLRPC$InputCheckPasswordSRP tLRPC$InputCheckPasswordSRP, final boolean z2, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$ucXZ1Yn9IK5-EPrxw1bK1yWHy4M
            @Override // java.lang.Runnable
            public final void run() throws JSONException {
                this.f$0.lambda$sendCallback$29$SendMessagesHelper(str, z, tLObject, messageObject, tLRPC$KeyboardButton, chatActivity, twoStepVerificationActivity, tLObjectArr, tLRPC$TL_error, tLRPC$InputCheckPasswordSRP, z2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x017a  */
    /* renamed from: lambda$sendCallback$29, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$sendCallback$29$SendMessagesHelper(java.lang.String r28, boolean r29, ir.eitaa.tgnet.TLObject r30, final ir.eitaa.messenger.MessageObject r31, final ir.eitaa.tgnet.TLRPC$KeyboardButton r32, final ir.eitaa.ui.ChatActivity r33, final ir.eitaa.ui.TwoStepVerificationActivity r34, ir.eitaa.tgnet.TLObject[] r35, ir.eitaa.tgnet.TLRPC$TL_error r36, ir.eitaa.tgnet.TLRPC$InputCheckPasswordSRP r37, final boolean r38) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 1197
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.SendMessagesHelper.lambda$sendCallback$29$SendMessagesHelper(java.lang.String, boolean, ir.eitaa.tgnet.TLObject, ir.eitaa.messenger.MessageObject, ir.eitaa.tgnet.TLRPC$KeyboardButton, ir.eitaa.ui.ChatActivity, ir.eitaa.ui.TwoStepVerificationActivity, ir.eitaa.tgnet.TLObject[], ir.eitaa.tgnet.TLRPC$TL_error, ir.eitaa.tgnet.TLRPC$InputCheckPasswordSRP, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$sendCallback$25, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$sendCallback$25$SendMessagesHelper(final boolean z, final MessageObject messageObject, final TLRPC$KeyboardButton tLRPC$KeyboardButton, final ChatActivity chatActivity, DialogInterface dialogInterface, int i) {
        final TwoStepVerificationActivity twoStepVerificationActivity = new TwoStepVerificationActivity();
        twoStepVerificationActivity.setDelegate(new TwoStepVerificationActivity.TwoStepVerificationActivityDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$CD6GUDXEc7As4wEsKhn6jslGajI
            @Override // ir.eitaa.ui.TwoStepVerificationActivity.TwoStepVerificationActivityDelegate
            public final void didEnterPassword(TLRPC$InputCheckPasswordSRP tLRPC$InputCheckPasswordSRP) throws JSONException {
                this.f$0.lambda$sendCallback$24$SendMessagesHelper(z, messageObject, tLRPC$KeyboardButton, twoStepVerificationActivity, chatActivity, tLRPC$InputCheckPasswordSRP);
            }
        });
        chatActivity.presentFragment(twoStepVerificationActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$sendCallback$28, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$sendCallback$28$SendMessagesHelper(final TwoStepVerificationActivity twoStepVerificationActivity, final boolean z, final MessageObject messageObject, final TLRPC$KeyboardButton tLRPC$KeyboardButton, final ChatActivity chatActivity, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$qPQNkj2YuulSpv6CglY-EMdhc1o
            @Override // java.lang.Runnable
            public final void run() throws JSONException {
                this.f$0.lambda$sendCallback$27$SendMessagesHelper(tLRPC$TL_error, tLObject, twoStepVerificationActivity, z, messageObject, tLRPC$KeyboardButton, chatActivity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$sendCallback$27, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$sendCallback$27$SendMessagesHelper(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, TwoStepVerificationActivity twoStepVerificationActivity, boolean z, MessageObject messageObject, TLRPC$KeyboardButton tLRPC$KeyboardButton, ChatActivity chatActivity) throws JSONException {
        if (tLRPC$TL_error == null) {
            TLRPC$TL_account_password tLRPC$TL_account_password = (TLRPC$TL_account_password) tLObject;
            twoStepVerificationActivity.setCurrentPasswordInfo(null, tLRPC$TL_account_password);
            TwoStepVerificationActivity.initPasswordNewAlgo(tLRPC$TL_account_password);
            lambda$sendCallback$24(z, messageObject, tLRPC$KeyboardButton, twoStepVerificationActivity.getNewSrpPassword(), twoStepVerificationActivity, chatActivity);
        }
    }

    public boolean isSendingCallback(MessageObject messageObject, TLRPC$KeyboardButton button) {
        int i = 0;
        if (messageObject == null || button == null) {
            return false;
        }
        if (button instanceof TLRPC$TL_keyboardButtonUrlAuth) {
            i = 3;
        } else if (button instanceof TLRPC$TL_keyboardButtonGame) {
            i = 1;
        } else if (button instanceof TLRPC$TL_keyboardButtonBuy) {
            i = 2;
        }
        return this.waitingForCallback.containsKey(messageObject.getDialogId() + "_" + messageObject.getId() + "_" + Utilities.bytesToHex(button.data) + "_" + i);
    }

    public void sendGame(TLRPC$InputPeer peer, TLRPC$TL_inputMediaGame game, long random_id, final long taskId) {
        NativeByteBuffer nativeByteBuffer;
        if (peer == null || game == null) {
            return;
        }
        TLRPC$TL_messages_sendMedia tLRPC$TL_messages_sendMedia = new TLRPC$TL_messages_sendMedia();
        tLRPC$TL_messages_sendMedia.peer = peer;
        if (peer instanceof TLRPC$TL_inputPeerChannel) {
            tLRPC$TL_messages_sendMedia.silent = MessagesController.getNotificationsSettings(this.currentAccount).getBoolean("silent_" + (-peer.channel_id), false);
        } else if (peer instanceof TLRPC$TL_inputPeerChat) {
            tLRPC$TL_messages_sendMedia.silent = MessagesController.getNotificationsSettings(this.currentAccount).getBoolean("silent_" + (-peer.chat_id), false);
        } else {
            tLRPC$TL_messages_sendMedia.silent = MessagesController.getNotificationsSettings(this.currentAccount).getBoolean("silent_" + peer.user_id, false);
        }
        tLRPC$TL_messages_sendMedia.random_id = random_id != 0 ? random_id : getNextRandomId();
        tLRPC$TL_messages_sendMedia.message = "";
        tLRPC$TL_messages_sendMedia.media = game;
        if (taskId == 0) {
            NativeByteBuffer nativeByteBuffer2 = null;
            try {
                nativeByteBuffer = new NativeByteBuffer(peer.getObjectSize() + game.getObjectSize() + 4 + 8);
            } catch (Exception e) {
                e = e;
            }
            try {
                nativeByteBuffer.writeInt32(3);
                nativeByteBuffer.writeInt64(random_id);
                peer.serializeToStream(nativeByteBuffer);
                game.serializeToStream(nativeByteBuffer);
            } catch (Exception e2) {
                e = e2;
                nativeByteBuffer2 = nativeByteBuffer;
                FileLog.e(e);
                nativeByteBuffer = nativeByteBuffer2;
                taskId = getMessagesStorage().createPendingTask(nativeByteBuffer);
                getConnectionsManager().sendRequest(tLRPC$TL_messages_sendMedia, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$x9A6S8df15TTxye0aJvnjdbtus0
                    @Override // ir.eitaa.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$sendGame$31$SendMessagesHelper(taskId, tLObject, tLRPC$TL_error);
                    }
                });
            }
            taskId = getMessagesStorage().createPendingTask(nativeByteBuffer);
        }
        getConnectionsManager().sendRequest(tLRPC$TL_messages_sendMedia, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$x9A6S8df15TTxye0aJvnjdbtus0
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$sendGame$31$SendMessagesHelper(taskId, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$sendGame$31, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$sendGame$31$SendMessagesHelper(long j, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            getMessagesController().processUpdates((TLRPC$Updates) tLObject, false);
        }
        if (j != 0) {
            getMessagesStorage().removePendingTask(j);
        }
    }

    public void sendPayInfo(final MessageObject messageObject, final TLRPC$KeyboardButton button, final BaseFragment parentFragment) {
        if (messageObject == null || button == null || parentFragment == null) {
            return;
        }
        final String str = messageObject.getDialogId() + "_" + messageObject.getId() + "_" + Utilities.bytesToHex(button.data) + "_2";
        this.waitingForCallback.put(str, Boolean.TRUE);
        TLRPC$TL_GetPayHash tLRPC$TL_GetPayHash = new TLRPC$TL_GetPayHash();
        TLRPC$Message tLRPC$Message = messageObject.messageOwner;
        tLRPC$TL_GetPayHash.peer = tLRPC$Message.peer_id;
        tLRPC$TL_GetPayHash.msg_id = tLRPC$Message.id;
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_GetPayHash, new RequestDelegate() { // from class: ir.eitaa.messenger.SendMessagesHelper.2
            @Override // ir.eitaa.tgnet.RequestDelegate
            public void run(final TLObject response, TLRPC$TL_error error) {
                SendMessagesHelper.this.waitingForCallback.remove(str);
                if (error == null) {
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.SendMessagesHelper.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Bundle bundle = new Bundle();
                            bundle.putString("link", button.url);
                            bundle.putString("hash", ((TLRPC$TL_UserPayHash) response).hash);
                            parentFragment.presentFragment(new PaymentActivity(bundle));
                        }
                    });
                }
            }
        });
    }

    public void sendMessage(MessageObject retryMessageObject) {
        long dialogId = retryMessageObject.getDialogId();
        TLRPC$Message tLRPC$Message = retryMessageObject.messageOwner;
        sendMessage(null, null, null, null, null, null, null, null, null, null, null, dialogId, tLRPC$Message.attachPath, null, null, null, true, retryMessageObject, null, tLRPC$Message.reply_markup, tLRPC$Message.params, !tLRPC$Message.silent, retryMessageObject.scheduled ? tLRPC$Message.date : 0, 0, null, null);
    }

    public void sendMessage(TLRPC$User user, long peer, MessageObject replyToMsg, MessageObject replyToTopMsg, TLRPC$ReplyMarkup replyMarkup, HashMap<String, String> params, boolean notify, int scheduleDate) {
        sendMessage(null, null, null, null, null, user, null, null, null, null, null, peer, null, replyToMsg, replyToTopMsg, null, true, null, null, replyMarkup, params, notify, scheduleDate, 0, null, null);
    }

    public void sendMessage(TLRPC$TL_messageMediaInvoice invoice, long peer, MessageObject replyToMsg, MessageObject replyToTopMsg, TLRPC$ReplyMarkup replyMarkup, HashMap<String, String> params, boolean notify, int scheduleDate) {
        sendMessage(null, null, null, null, null, null, null, null, null, null, invoice, peer, null, replyToMsg, replyToTopMsg, null, true, null, null, replyMarkup, params, notify, scheduleDate, 0, null, null);
    }

    public void sendMessage(TLRPC$TL_document document, VideoEditedInfo videoEditedInfo, String path, long peer, MessageObject replyToMsg, MessageObject replyToTopMsg, String caption, ArrayList<TLRPC$MessageEntity> entities, TLRPC$ReplyMarkup replyMarkup, HashMap<String, String> params, boolean notify, int scheduleDate, int ttl, Object parentObject, MessageObject.SendAnimationData sendAnimationData) {
        sendMessage(null, caption, null, null, videoEditedInfo, null, document, null, null, null, null, peer, path, replyToMsg, replyToTopMsg, null, true, null, entities, replyMarkup, params, notify, scheduleDate, ttl, parentObject, sendAnimationData);
    }

    public void sendMessage(String message, long peer, MessageObject replyToMsg, MessageObject replyToTopMsg, TLRPC$WebPage webPage, boolean searchLinks, ArrayList<TLRPC$MessageEntity> entities, TLRPC$ReplyMarkup replyMarkup, HashMap<String, String> params, boolean notify, int scheduleDate, MessageObject.SendAnimationData sendAnimationData) {
        sendMessage(message, null, null, null, null, null, null, null, null, null, null, peer, null, replyToMsg, replyToTopMsg, webPage, searchLinks, null, entities, replyMarkup, params, notify, scheduleDate, 0, null, sendAnimationData);
    }

    public void sendMessage(TLRPC$MessageMedia location, long peer, MessageObject replyToMsg, MessageObject replyToTopMsg, TLRPC$ReplyMarkup replyMarkup, HashMap<String, String> params, boolean notify, int scheduleDate) {
        sendMessage(null, null, location, null, null, null, null, null, null, null, null, peer, null, replyToMsg, replyToTopMsg, null, true, null, null, replyMarkup, params, notify, scheduleDate, 0, null, null);
    }

    public void sendMessage(TLRPC$TL_messageMediaPoll poll, long peer, MessageObject replyToMsg, MessageObject replyToTopMsg, TLRPC$ReplyMarkup replyMarkup, HashMap<String, String> params, boolean notify, int scheduleDate) {
        sendMessage(null, null, null, null, null, null, null, null, null, poll, null, peer, null, replyToMsg, replyToTopMsg, null, true, null, null, replyMarkup, params, notify, scheduleDate, 0, null, null);
    }

    public void sendMessage(TLRPC$TL_messageMediaLiveStream liveStream, String caption, byte[] liveThumbBitmap, long peer, MessageObject replyToMsg, TLRPC$ReplyMarkup replyMarkup, HashMap<String, String> params) {
        sendMessage(null, caption, null, null, null, null, null, null, liveStream, liveThumbBitmap, null, null, peer, null, replyToMsg, null, null, false, null, null, replyMarkup, params, true, 0, 0, null, null);
    }

    public void sendMessage(TLRPC$TL_game game, long peer, TLRPC$ReplyMarkup replyMarkup, HashMap<String, String> params, boolean notify, int scheduleDate) {
        sendMessage(null, null, null, null, null, null, null, game, null, null, null, peer, null, null, null, null, true, null, null, replyMarkup, params, notify, scheduleDate, 0, null, null);
    }

    public void sendMessage(TLRPC$TL_photo photo, String path, long peer, MessageObject replyToMsg, MessageObject replyToTopMsg, String caption, ArrayList<TLRPC$MessageEntity> entities, TLRPC$ReplyMarkup replyMarkup, HashMap<String, String> params, boolean notify, int scheduleDate, int ttl, Object parentObject) {
        sendMessage(null, caption, null, photo, null, null, null, null, null, null, null, peer, path, replyToMsg, replyToTopMsg, null, true, null, entities, replyMarkup, params, notify, scheduleDate, ttl, parentObject, null);
    }

    private void sendMessage(String message, String caption, TLRPC$MessageMedia location, TLRPC$TL_photo photo, VideoEditedInfo videoEditedInfo, TLRPC$User user, TLRPC$TL_document document, TLRPC$TL_game game, TLRPC$TL_messageMediaLiveStream liveStream, TLRPC$TL_messageMediaPoll poll, TLRPC$TL_messageMediaInvoice invoice, long peer, String path, MessageObject replyToMsg, MessageObject replyToTopMsg, TLRPC$WebPage webPage, boolean searchLinks, MessageObject retryMessageObject, ArrayList<TLRPC$MessageEntity> entities, TLRPC$ReplyMarkup replyMarkup, HashMap<String, String> params, boolean notify, int scheduleDate, int ttl, Object parentObject, MessageObject.SendAnimationData sendAnimationData) {
        sendMessage(message, caption, location, photo, videoEditedInfo, user, document, game, liveStream, null, poll, invoice, peer, path, replyToMsg, replyToTopMsg, webPage, searchLinks, retryMessageObject, entities, replyMarkup, params, notify, scheduleDate, ttl, parentObject, sendAnimationData);
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    /* JADX WARN: Failed to analyze thrown exceptions
    java.util.ConcurrentModificationException
    	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1095)
    	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1049)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:118)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:179)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:132)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:179)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:132)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:179)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:132)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:179)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:132)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:179)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:132)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
     */
    private void sendMessage(java.lang.String r52, java.lang.String r53, ir.eitaa.tgnet.TLRPC$MessageMedia r54, ir.eitaa.tgnet.TLRPC$TL_photo r55, ir.eitaa.messenger.VideoEditedInfo r56, ir.eitaa.tgnet.TLRPC$User r57, ir.eitaa.tgnet.TLRPC$TL_document r58, ir.eitaa.tgnet.TLRPC$TL_game r59, ir.eitaa.tgnet.TLRPC$TL_messageMediaLiveStream r60, byte[] r61, ir.eitaa.tgnet.TLRPC$TL_messageMediaPoll r62, ir.eitaa.tgnet.TLRPC$TL_messageMediaInvoice r63, long r64, java.lang.String r66, ir.eitaa.messenger.MessageObject r67, ir.eitaa.messenger.MessageObject r68, ir.eitaa.tgnet.TLRPC$WebPage r69, boolean r70, ir.eitaa.messenger.MessageObject r71, java.util.ArrayList<ir.eitaa.tgnet.TLRPC$MessageEntity> r72, ir.eitaa.tgnet.TLRPC$ReplyMarkup r73, java.util.HashMap<java.lang.String, java.lang.String> r74, boolean r75, int r76, int r77, java.lang.Object r78, ir.eitaa.messenger.MessageObject.SendAnimationData r79) {
        /*
            Method dump skipped, instructions count: 7398
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.SendMessagesHelper.sendMessage(java.lang.String, java.lang.String, ir.eitaa.tgnet.TLRPC$MessageMedia, ir.eitaa.tgnet.TLRPC$TL_photo, ir.eitaa.messenger.VideoEditedInfo, ir.eitaa.tgnet.TLRPC$User, ir.eitaa.tgnet.TLRPC$TL_document, ir.eitaa.tgnet.TLRPC$TL_game, ir.eitaa.tgnet.TLRPC$TL_messageMediaLiveStream, byte[], ir.eitaa.tgnet.TLRPC$TL_messageMediaPoll, ir.eitaa.tgnet.TLRPC$TL_messageMediaInvoice, long, java.lang.String, ir.eitaa.messenger.MessageObject, ir.eitaa.messenger.MessageObject, ir.eitaa.tgnet.TLRPC$WebPage, boolean, ir.eitaa.messenger.MessageObject, java.util.ArrayList, ir.eitaa.tgnet.TLRPC$ReplyMarkup, java.util.HashMap, boolean, int, int, java.lang.Object, ir.eitaa.messenger.MessageObject$SendAnimationData):void");
    }

    private void performSendDelayedMessage(final DelayedMessage message) {
        performSendDelayedMessage(message, -1);
    }

    private TLRPC$PhotoSize getThumbForSecretChat(ArrayList<TLRPC$PhotoSize> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                TLRPC$PhotoSize tLRPC$PhotoSize = arrayList.get(i);
                if (tLRPC$PhotoSize != null && !(tLRPC$PhotoSize instanceof TLRPC$TL_photoStrippedSize) && !(tLRPC$PhotoSize instanceof TLRPC$TL_photoPathSize) && !(tLRPC$PhotoSize instanceof TLRPC$TL_photoSizeEmpty) && tLRPC$PhotoSize.location != null) {
                    TLRPC$TL_photoSize_layer127 tLRPC$TL_photoSize_layer127 = new TLRPC$TL_photoSize_layer127();
                    tLRPC$TL_photoSize_layer127.type = tLRPC$PhotoSize.type;
                    tLRPC$TL_photoSize_layer127.w = tLRPC$PhotoSize.w;
                    tLRPC$TL_photoSize_layer127.h = tLRPC$PhotoSize.h;
                    tLRPC$TL_photoSize_layer127.size = tLRPC$PhotoSize.size;
                    byte[] bArr = tLRPC$PhotoSize.bytes;
                    tLRPC$TL_photoSize_layer127.bytes = bArr;
                    if (bArr == null) {
                        tLRPC$TL_photoSize_layer127.bytes = new byte[0];
                    }
                    TLRPC$TL_fileLocation_layer82 tLRPC$TL_fileLocation_layer82 = new TLRPC$TL_fileLocation_layer82();
                    tLRPC$TL_photoSize_layer127.location = tLRPC$TL_fileLocation_layer82;
                    TLRPC$FileLocation tLRPC$FileLocation = tLRPC$PhotoSize.location;
                    tLRPC$TL_fileLocation_layer82.dc_id = tLRPC$FileLocation.dc_id;
                    tLRPC$TL_fileLocation_layer82.volume_id = tLRPC$FileLocation.volume_id;
                    tLRPC$TL_fileLocation_layer82.local_id = tLRPC$FileLocation.local_id;
                    tLRPC$TL_fileLocation_layer82.secret = tLRPC$FileLocation.secret;
                    return tLRPC$TL_photoSize_layer127;
                }
            }
        }
        return null;
    }

    private void performSendDelayedMessage(final DelayedMessage message, int index) {
        boolean z;
        TLRPC$InputEncryptedFile tLRPC$InputEncryptedFile;
        boolean z2;
        MessageObject messageObject;
        TLRPC$InputMedia tLRPC$InputMedia;
        TLRPC$PhotoSize tLRPC$PhotoSize;
        TLRPC$InputMedia tLRPC$InputMedia2;
        TLRPC$InputMedia tLRPC$InputMedia3;
        int i = message.type;
        if (i == 0) {
            String str = message.httpLocation;
            if (str != null) {
                putToDelayedMessages(str, message);
                ImageLoader.getInstance().loadHttpFile(message.httpLocation, "file", this.currentAccount);
                return;
            }
            if (message.sendRequest != null) {
                String string = FileLoader.getPathToAttach(message.photoSize).toString();
                putToDelayedMessages(string, message);
                getFileLoader().uploadFile(string, false, true, ConnectionsManager.FileTypePhoto);
                putToUploadingMessages(message.obj);
                return;
            }
            String string2 = FileLoader.getPathToAttach(message.photoSize).toString();
            if (message.sendEncryptedRequest != null && message.photoSize.location.dc_id != 0) {
                File file = new File(string2);
                if (!file.exists()) {
                    string2 = FileLoader.getPathToAttach(message.photoSize, true).toString();
                    file = new File(string2);
                }
                if (!file.exists()) {
                    putToDelayedMessages(FileLoader.getAttachFileName(message.photoSize), message);
                    getFileLoader().loadFile(ImageLocation.getForObject(message.photoSize, message.locationParent), message.parentObject, "jpg", 2, 0);
                    return;
                }
            }
            putToDelayedMessages(string2, message);
            getFileLoader().uploadFile(string2, true, true, ConnectionsManager.FileTypePhoto);
            putToUploadingMessages(message.obj);
            return;
        }
        if (i == 1) {
            VideoEditedInfo videoEditedInfo = message.videoEditedInfo;
            if (videoEditedInfo != null && videoEditedInfo.needConvert()) {
                MessageObject messageObject2 = message.obj;
                String str2 = messageObject2.messageOwner.attachPath;
                TLRPC$Document document = messageObject2.getDocument();
                if (str2 == null) {
                    str2 = FileLoader.getDirectory(4) + "/" + document.id + ".mp4";
                }
                putToDelayedMessages(str2, message);
                MediaController.getInstance().scheduleVideoConvert(message.obj);
                putToUploadingMessages(message.obj);
                return;
            }
            VideoEditedInfo videoEditedInfo2 = message.videoEditedInfo;
            if (videoEditedInfo2 != null) {
                TLRPC$InputFile tLRPC$InputFile = videoEditedInfo2.file;
                if (tLRPC$InputFile != null) {
                    TLObject tLObject = message.sendRequest;
                    if (tLObject instanceof TLRPC$TL_messages_sendMedia) {
                        tLRPC$InputMedia3 = ((TLRPC$TL_messages_sendMedia) tLObject).media;
                    } else {
                        tLRPC$InputMedia3 = ((TLRPC$TL_messages_editMessage) tLObject).media;
                    }
                    tLRPC$InputMedia3.file = tLRPC$InputFile;
                    videoEditedInfo2.file = null;
                } else if (videoEditedInfo2.encryptedFile != null) {
                    TLRPC$TL_decryptedMessage tLRPC$TL_decryptedMessage = (TLRPC$TL_decryptedMessage) message.sendEncryptedRequest;
                    TLRPC$DecryptedMessageMedia tLRPC$DecryptedMessageMedia = tLRPC$TL_decryptedMessage.media;
                    tLRPC$DecryptedMessageMedia.size = (int) videoEditedInfo2.estimatedSize;
                    tLRPC$DecryptedMessageMedia.key = videoEditedInfo2.key;
                    tLRPC$DecryptedMessageMedia.iv = videoEditedInfo2.iv;
                    SecretChatHelper secretChatHelper = getSecretChatHelper();
                    MessageObject messageObject3 = message.obj;
                    secretChatHelper.performSendEncryptedRequest(tLRPC$TL_decryptedMessage, messageObject3.messageOwner, message.encryptedChat, message.videoEditedInfo.encryptedFile, message.originalPath, messageObject3);
                    message.videoEditedInfo.encryptedFile = null;
                    return;
                }
            }
            TLObject tLObject2 = message.sendRequest;
            if (tLObject2 != null) {
                if (tLObject2 instanceof TLRPC$TL_messages_sendMedia) {
                    tLRPC$InputMedia2 = ((TLRPC$TL_messages_sendMedia) tLObject2).media;
                } else {
                    tLRPC$InputMedia2 = ((TLRPC$TL_messages_editMessage) tLObject2).media;
                }
                if (tLRPC$InputMedia2.file == null) {
                    MessageObject messageObject4 = message.obj;
                    String str3 = messageObject4.messageOwner.attachPath;
                    TLRPC$Document document2 = messageObject4.getDocument();
                    if (str3 == null) {
                        str3 = FileLoader.getDirectory(4) + "/" + document2.id + ".mp4";
                    }
                    String str4 = str3;
                    putToDelayedMessages(str4, message);
                    VideoEditedInfo videoEditedInfo3 = message.obj.videoEditedInfo;
                    if (videoEditedInfo3 != null && videoEditedInfo3.needConvert()) {
                        getFileLoader().uploadFile(str4, false, false, document2.size, ConnectionsManager.FileTypeVideo, false);
                    } else {
                        getFileLoader().uploadFile(str4, false, false, ConnectionsManager.FileTypeVideo);
                    }
                    putToUploadingMessages(message.obj);
                    return;
                }
                String str5 = FileLoader.getDirectory(4) + "/" + message.photoSize.location.volume_id + "_" + message.photoSize.location.local_id + ".jpg";
                putToDelayedMessages(str5, message);
                getFileLoader().uploadFile(str5, false, true, ConnectionsManager.FileTypePhoto);
                putToUploadingMessages(message.obj);
                return;
            }
            MessageObject messageObject5 = message.obj;
            String str6 = messageObject5.messageOwner.attachPath;
            TLRPC$Document document3 = messageObject5.getDocument();
            if (str6 == null) {
                str6 = FileLoader.getDirectory(4) + "/" + document3.id + ".mp4";
            }
            if (message.sendEncryptedRequest != null && document3.dc_id != 0 && !new File(str6).exists()) {
                putToDelayedMessages(FileLoader.getAttachFileName(document3), message);
                getFileLoader().loadFile(document3, message.parentObject, 2, 0);
                return;
            }
            putToDelayedMessages(str6, message);
            VideoEditedInfo videoEditedInfo4 = message.obj.videoEditedInfo;
            if (videoEditedInfo4 != null && videoEditedInfo4.needConvert()) {
                getFileLoader().uploadFile(str6, true, false, document3.size, ConnectionsManager.FileTypeVideo, false);
            } else {
                getFileLoader().uploadFile(str6, true, false, ConnectionsManager.FileTypeVideo);
            }
            putToUploadingMessages(message.obj);
            return;
        }
        if (i == 2) {
            String str7 = message.httpLocation;
            if (str7 != null) {
                putToDelayedMessages(str7, message);
                ImageLoader.getInstance().loadHttpFile(message.httpLocation, "gif", this.currentAccount);
                return;
            }
            TLObject tLObject3 = message.sendRequest;
            if (tLObject3 != null) {
                if (tLObject3 instanceof TLRPC$TL_messages_sendMedia) {
                    tLRPC$InputMedia = ((TLRPC$TL_messages_sendMedia) tLObject3).media;
                } else {
                    tLRPC$InputMedia = ((TLRPC$TL_messages_editMessage) tLObject3).media;
                }
                if (tLRPC$InputMedia.file == null) {
                    String str8 = message.obj.messageOwner.attachPath;
                    putToDelayedMessages(str8, message);
                    getFileLoader().uploadFile(str8, message.sendRequest == null, false, ConnectionsManager.FileTypeFile);
                    putToUploadingMessages(message.obj);
                    return;
                }
                if (tLRPC$InputMedia.thumb != null || (tLRPC$PhotoSize = message.photoSize) == null || (tLRPC$PhotoSize instanceof TLRPC$TL_photoStrippedSize)) {
                    return;
                }
                String str9 = FileLoader.getDirectory(4) + "/" + message.photoSize.location.volume_id + "_" + message.photoSize.location.local_id + ".jpg";
                putToDelayedMessages(str9, message);
                getFileLoader().uploadFile(str9, false, true, ConnectionsManager.FileTypePhoto);
                putToUploadingMessages(message.obj);
                return;
            }
            MessageObject messageObject6 = message.obj;
            String str10 = messageObject6.messageOwner.attachPath;
            TLRPC$Document document4 = messageObject6.getDocument();
            if (message.sendEncryptedRequest != null && document4.dc_id != 0 && !new File(str10).exists()) {
                putToDelayedMessages(FileLoader.getAttachFileName(document4), message);
                getFileLoader().loadFile(document4, message.parentObject, 2, 0);
                return;
            } else {
                putToDelayedMessages(str10, message);
                getFileLoader().uploadFile(str10, true, false, ConnectionsManager.FileTypeFile);
                putToUploadingMessages(message.obj);
                return;
            }
        }
        if (i == 3) {
            String str11 = message.obj.messageOwner.attachPath;
            putToDelayedMessages(str11, message);
            getFileLoader().uploadFile(str11, message.sendRequest == null, true, ConnectionsManager.FileTypeAudio);
            putToUploadingMessages(message.obj);
            return;
        }
        if (i != 4) {
            if (i == 5) {
                final String str12 = "stickerset_" + message.obj.getId();
                TLRPC$TL_messages_getStickerSet tLRPC$TL_messages_getStickerSet = new TLRPC$TL_messages_getStickerSet();
                tLRPC$TL_messages_getStickerSet.stickerset = (TLRPC$InputStickerSet) message.parentObject;
                getConnectionsManager().sendRequest(tLRPC$TL_messages_getStickerSet, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$duPVCNmlhSeBBLGglya_JH28_sc
                    @Override // ir.eitaa.tgnet.RequestDelegate
                    public final void run(TLObject tLObject4, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$performSendDelayedMessage$33$SendMessagesHelper(message, str12, tLObject4, tLRPC$TL_error);
                    }
                });
                putToDelayedMessages(str12, message);
                return;
            }
            return;
        }
        boolean z3 = index < 0;
        if (message.performMediaUpload) {
            int size = index < 0 ? message.messageObjects.size() - 1 : index;
            MessageObject messageObject7 = message.messageObjects.get(size);
            if (messageObject7.getDocument() != null) {
                if (message.videoEditedInfo != null) {
                    String str13 = messageObject7.messageOwner.attachPath;
                    TLRPC$Document document5 = messageObject7.getDocument();
                    if (str13 == null) {
                        str13 = FileLoader.getDirectory(4) + "/" + document5.id + ".mp4";
                    }
                    putToDelayedMessages(str13, message);
                    message.extraHashMap.put(messageObject7, str13);
                    message.extraHashMap.put(str13 + "_i", messageObject7);
                    TLRPC$PhotoSize tLRPC$PhotoSize2 = message.photoSize;
                    if (tLRPC$PhotoSize2 != null && tLRPC$PhotoSize2.location != null) {
                        message.extraHashMap.put(str13 + "_t", message.photoSize);
                    }
                    MediaController.getInstance().scheduleVideoConvert(messageObject7);
                    message.obj = messageObject7;
                    putToUploadingMessages(messageObject7);
                } else {
                    TLRPC$Document document6 = messageObject7.getDocument();
                    String string3 = messageObject7.messageOwner.attachPath;
                    if (string3 == null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(FileLoader.getDirectory(4));
                        sb.append("/");
                        messageObject = messageObject7;
                        sb.append(document6.id);
                        sb.append(".mp4");
                        string3 = sb.toString();
                    } else {
                        messageObject = messageObject7;
                    }
                    TLObject tLObject4 = message.sendRequest;
                    if (tLObject4 != null) {
                        TLRPC$InputMedia tLRPC$InputMedia4 = ((TLRPC$TL_messages_sendMultiMedia) tLObject4).multi_media.get(size).media;
                        if (tLRPC$InputMedia4.file == null) {
                            putToDelayedMessages(string3, message);
                            MessageObject messageObject8 = messageObject;
                            message.extraHashMap.put(messageObject8, string3);
                            message.extraHashMap.put(string3, tLRPC$InputMedia4);
                            message.extraHashMap.put(string3 + "_i", messageObject8);
                            TLRPC$PhotoSize tLRPC$PhotoSize3 = message.photoSize;
                            if (tLRPC$PhotoSize3 != null && tLRPC$PhotoSize3.location != null) {
                                message.extraHashMap.put(string3 + "_t", message.photoSize);
                            }
                            VideoEditedInfo videoEditedInfo5 = messageObject8.videoEditedInfo;
                            if (videoEditedInfo5 != null && videoEditedInfo5.needConvert()) {
                                getFileLoader().uploadFile(string3, false, false, document6.size, ConnectionsManager.FileTypeVideo, false);
                            } else {
                                getFileLoader().uploadFile(string3, false, false, ConnectionsManager.FileTypeVideo);
                            }
                            putToUploadingMessages(messageObject8);
                        } else {
                            MessageObject messageObject9 = messageObject;
                            if (message.photoSize != null) {
                                String str14 = FileLoader.getDirectory(4) + "/" + message.photoSize.location.volume_id + "_" + message.photoSize.location.local_id + ".jpg";
                                putToDelayedMessages(str14, message);
                                message.extraHashMap.put(str14 + "_o", string3);
                                message.extraHashMap.put(messageObject9, str14);
                                message.extraHashMap.put(str14, tLRPC$InputMedia4);
                                getFileLoader().uploadFile(str14, false, true, ConnectionsManager.FileTypePhoto);
                                putToUploadingMessages(messageObject9);
                            }
                        }
                    } else {
                        MessageObject messageObject10 = messageObject;
                        TLRPC$TL_messages_sendEncryptedMultiMedia tLRPC$TL_messages_sendEncryptedMultiMedia = (TLRPC$TL_messages_sendEncryptedMultiMedia) message.sendEncryptedRequest;
                        putToDelayedMessages(string3, message);
                        message.extraHashMap.put(messageObject10, string3);
                        message.extraHashMap.put(string3, tLRPC$TL_messages_sendEncryptedMultiMedia.files.get(size));
                        message.extraHashMap.put(string3 + "_i", messageObject10);
                        TLRPC$PhotoSize tLRPC$PhotoSize4 = message.photoSize;
                        if (tLRPC$PhotoSize4 != null && tLRPC$PhotoSize4.location != null) {
                            message.extraHashMap.put(string3 + "_t", message.photoSize);
                        }
                        VideoEditedInfo videoEditedInfo6 = messageObject10.videoEditedInfo;
                        if (videoEditedInfo6 != null && videoEditedInfo6.needConvert()) {
                            getFileLoader().uploadFile(string3, true, false, document6.size, ConnectionsManager.FileTypeVideo, false);
                        } else {
                            getFileLoader().uploadFile(string3, true, false, ConnectionsManager.FileTypeVideo);
                        }
                        putToUploadingMessages(messageObject10);
                    }
                }
                message.videoEditedInfo = null;
                message.photoSize = null;
            } else {
                String str15 = message.httpLocation;
                if (str15 != null) {
                    putToDelayedMessages(str15, message);
                    message.extraHashMap.put(messageObject7, message.httpLocation);
                    message.extraHashMap.put(message.httpLocation, messageObject7);
                    ImageLoader.getInstance().loadHttpFile(message.httpLocation, "file", this.currentAccount);
                    message.httpLocation = null;
                } else {
                    TLObject tLObject5 = message.sendRequest;
                    if (tLObject5 != null) {
                        tLRPC$InputEncryptedFile = ((TLRPC$TL_messages_sendMultiMedia) tLObject5).multi_media.get(size).media;
                    } else {
                        tLRPC$InputEncryptedFile = ((TLRPC$TL_messages_sendEncryptedMultiMedia) message.sendEncryptedRequest).files.get(size);
                    }
                    String string4 = FileLoader.getPathToAttach(message.photoSize).toString();
                    putToDelayedMessages(string4, message);
                    message.extraHashMap.put(string4, tLRPC$InputEncryptedFile);
                    message.extraHashMap.put(messageObject7, string4);
                    z = true;
                    getFileLoader().uploadFile(string4, message.sendEncryptedRequest != null, true, ConnectionsManager.FileTypePhoto);
                    putToUploadingMessages(messageObject7);
                    message.photoSize = null;
                    z2 = false;
                    message.performMediaUpload = z2;
                }
            }
            z2 = false;
            z = true;
            message.performMediaUpload = z2;
        } else {
            z = true;
            if (!message.messageObjects.isEmpty()) {
                ArrayList<MessageObject> arrayList = message.messageObjects;
                putToSendingMessages(arrayList.get(arrayList.size() - 1).messageOwner, message.finalGroupMessage != 0);
            }
        }
        sendReadyToSendGroup(message, z3, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$performSendDelayedMessage$33, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$performSendDelayedMessage$33$SendMessagesHelper(final DelayedMessage delayedMessage, final String str, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$kSZcKwJ5KYeYDpPq0oqZyOmdUO4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$performSendDelayedMessage$32$SendMessagesHelper(tLObject, delayedMessage, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$performSendDelayedMessage$32, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$performSendDelayedMessage$32$SendMessagesHelper(TLObject tLObject, DelayedMessage delayedMessage, String str) {
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

    private void uploadMultiMedia(final DelayedMessage message, final TLRPC$InputMedia inputMedia, final TLRPC$InputEncryptedFile inputEncryptedFile, String key) {
        if (inputMedia == null) {
            if (inputEncryptedFile != null) {
                TLRPC$TL_messages_sendEncryptedMultiMedia tLRPC$TL_messages_sendEncryptedMultiMedia = (TLRPC$TL_messages_sendEncryptedMultiMedia) message.sendEncryptedRequest;
                int i = 0;
                while (true) {
                    if (i >= tLRPC$TL_messages_sendEncryptedMultiMedia.files.size()) {
                        break;
                    }
                    if (tLRPC$TL_messages_sendEncryptedMultiMedia.files.get(i) == inputEncryptedFile) {
                        putToSendingMessages(message.messages.get(i), message.scheduled);
                        getNotificationCenter().postNotificationName(NotificationCenter.fileUploadProgressChanged, key, -1L, -1L, Boolean.FALSE);
                        break;
                    }
                    i++;
                }
                sendReadyToSendGroup(message, false, true);
                return;
            }
            return;
        }
        TLRPC$TL_messages_sendMultiMedia tLRPC$TL_messages_sendMultiMedia = (TLRPC$TL_messages_sendMultiMedia) message.sendRequest;
        int i2 = 0;
        while (true) {
            if (i2 >= tLRPC$TL_messages_sendMultiMedia.multi_media.size()) {
                break;
            }
            if (tLRPC$TL_messages_sendMultiMedia.multi_media.get(i2).media == inputMedia) {
                putToSendingMessages(message.messages.get(i2), message.scheduled);
                getNotificationCenter().postNotificationName(NotificationCenter.fileUploadProgressChanged, key, -1L, -1L, Boolean.FALSE);
                break;
            }
            i2++;
        }
        TLRPC$TL_messages_uploadMedia tLRPC$TL_messages_uploadMedia = new TLRPC$TL_messages_uploadMedia();
        tLRPC$TL_messages_uploadMedia.media = inputMedia;
        tLRPC$TL_messages_uploadMedia.peer = ((TLRPC$TL_messages_sendMultiMedia) message.sendRequest).peer;
        getConnectionsManager().sendRequest(tLRPC$TL_messages_uploadMedia, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$wOyOU_kIlPsw4ZA0HH74Qk_ff2s
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$uploadMultiMedia$35$SendMessagesHelper(inputMedia, message, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$uploadMultiMedia$35, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$uploadMultiMedia$35$SendMessagesHelper(final TLRPC$InputMedia tLRPC$InputMedia, final DelayedMessage delayedMessage, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$G447EQIQwRZ8Lpo-OERK52FeAts
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$uploadMultiMedia$34$SendMessagesHelper(tLObject, tLRPC$InputMedia, delayedMessage);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005c  */
    /* renamed from: lambda$uploadMultiMedia$34, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$uploadMultiMedia$34$SendMessagesHelper(ir.eitaa.tgnet.TLObject r6, ir.eitaa.tgnet.TLRPC$InputMedia r7, ir.eitaa.messenger.SendMessagesHelper.DelayedMessage r8) {
        /*
            r5 = this;
            if (r6 == 0) goto L5c
            ir.eitaa.tgnet.TLRPC$MessageMedia r6 = (ir.eitaa.tgnet.TLRPC$MessageMedia) r6
            boolean r0 = r7 instanceof ir.eitaa.tgnet.TLRPC$TL_inputMediaUploadedPhoto
            if (r0 == 0) goto L30
            boolean r0 = r6 instanceof ir.eitaa.tgnet.TLRPC$TL_messageMediaPhoto
            if (r0 == 0) goto L30
            ir.eitaa.tgnet.TLRPC$TL_inputMediaPhoto r0 = new ir.eitaa.tgnet.TLRPC$TL_inputMediaPhoto
            r0.<init>()
            ir.eitaa.tgnet.TLRPC$TL_inputPhoto r1 = new ir.eitaa.tgnet.TLRPC$TL_inputPhoto
            r1.<init>()
            r0.id = r1
            ir.eitaa.tgnet.TLRPC$Photo r6 = r6.photo
            long r2 = r6.id
            r1.id = r2
            long r2 = r6.access_hash
            r1.access_hash = r2
            byte[] r6 = r6.file_reference
            r1.file_reference = r6
            boolean r6 = ir.eitaa.messenger.BuildVars.DEBUG_VERSION
            if (r6 == 0) goto L5d
            java.lang.String r6 = "set uploaded photo"
            ir.eitaa.messenger.FileLog.d(r6)
            goto L5d
        L30:
            boolean r0 = r7 instanceof ir.eitaa.tgnet.TLRPC$TL_inputMediaUploadedDocument
            if (r0 == 0) goto L5c
            boolean r0 = r6 instanceof ir.eitaa.tgnet.TLRPC$TL_messageMediaDocument
            if (r0 == 0) goto L5c
            ir.eitaa.tgnet.TLRPC$TL_inputMediaDocument r0 = new ir.eitaa.tgnet.TLRPC$TL_inputMediaDocument
            r0.<init>()
            ir.eitaa.tgnet.TLRPC$TL_inputDocument r1 = new ir.eitaa.tgnet.TLRPC$TL_inputDocument
            r1.<init>()
            r0.id = r1
            ir.eitaa.tgnet.TLRPC$Document r6 = r6.document
            long r2 = r6.id
            r1.id = r2
            long r2 = r6.access_hash
            r1.access_hash = r2
            byte[] r6 = r6.file_reference
            r1.file_reference = r6
            boolean r6 = ir.eitaa.messenger.BuildVars.DEBUG_VERSION
            if (r6 == 0) goto L5d
            java.lang.String r6 = "set uploaded document"
            ir.eitaa.messenger.FileLog.d(r6)
            goto L5d
        L5c:
            r0 = 0
        L5d:
            if (r0 == 0) goto L97
            int r6 = r7.ttl_seconds
            r1 = 1
            if (r6 == 0) goto L6b
            r0.ttl_seconds = r6
            int r6 = r0.flags
            r6 = r6 | r1
            r0.flags = r6
        L6b:
            ir.eitaa.tgnet.TLObject r6 = r8.sendRequest
            ir.eitaa.tgnet.TLRPC$TL_messages_sendMultiMedia r6 = (ir.eitaa.tgnet.TLRPC$TL_messages_sendMultiMedia) r6
            r2 = 0
            r3 = 0
        L71:
            java.util.ArrayList<ir.eitaa.tgnet.TLRPC$TL_inputSingleMedia> r4 = r6.multi_media
            int r4 = r4.size()
            if (r3 >= r4) goto L93
            java.util.ArrayList<ir.eitaa.tgnet.TLRPC$TL_inputSingleMedia> r4 = r6.multi_media
            java.lang.Object r4 = r4.get(r3)
            ir.eitaa.tgnet.TLRPC$TL_inputSingleMedia r4 = (ir.eitaa.tgnet.TLRPC$TL_inputSingleMedia) r4
            ir.eitaa.tgnet.TLRPC$InputMedia r4 = r4.media
            if (r4 != r7) goto L90
            java.util.ArrayList<ir.eitaa.tgnet.TLRPC$TL_inputSingleMedia> r6 = r6.multi_media
            java.lang.Object r6 = r6.get(r3)
            ir.eitaa.tgnet.TLRPC$TL_inputSingleMedia r6 = (ir.eitaa.tgnet.TLRPC$TL_inputSingleMedia) r6
            r6.media = r0
            goto L93
        L90:
            int r3 = r3 + 1
            goto L71
        L93:
            r5.sendReadyToSendGroup(r8, r2, r1)
            goto L9a
        L97:
            r8.markAsError()
        L9a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.SendMessagesHelper.lambda$uploadMultiMedia$34$SendMessagesHelper(ir.eitaa.tgnet.TLObject, ir.eitaa.tgnet.TLRPC$InputMedia, ir.eitaa.messenger.SendMessagesHelper$DelayedMessage):void");
    }

    private void sendReadyToSendGroup(DelayedMessage message, boolean add, boolean check) {
        DelayedMessage delayedMessageFindMaxDelayedMessageForMessageId;
        if (message.messageObjects.isEmpty()) {
            message.markAsError();
            return;
        }
        String str = "group_" + message.groupId;
        if (message.finalGroupMessage != message.messageObjects.get(r2.size() - 1).getId()) {
            if (add) {
                if (BuildVars.DEBUG_VERSION) {
                    FileLog.d("final message not added, add");
                }
                putToDelayedMessages(str, message);
                return;
            } else {
                if (BuildVars.DEBUG_VERSION) {
                    FileLog.d("final message not added");
                    return;
                }
                return;
            }
        }
        int i = 0;
        if (add) {
            this.delayedMessages.remove(str);
            getMessagesStorage().putMessages(message.messages, false, true, false, 0, message.scheduled);
            getMessagesController().updateInterfaceWithMessages(message.peer, message.messageObjects, message.scheduled);
            if (!message.scheduled) {
                getNotificationCenter().postNotificationName(NotificationCenter.dialogsNeedReload, new Object[0]);
            }
            if (BuildVars.DEBUG_VERSION) {
                FileLog.d("add message");
            }
        }
        TLObject tLObject = message.sendRequest;
        if (tLObject instanceof TLRPC$TL_messages_sendMultiMedia) {
            TLRPC$TL_messages_sendMultiMedia tLRPC$TL_messages_sendMultiMedia = (TLRPC$TL_messages_sendMultiMedia) tLObject;
            while (i < tLRPC$TL_messages_sendMultiMedia.multi_media.size()) {
                TLRPC$InputMedia tLRPC$InputMedia = tLRPC$TL_messages_sendMultiMedia.multi_media.get(i).media;
                if ((tLRPC$InputMedia instanceof TLRPC$TL_inputMediaUploadedPhoto) || (tLRPC$InputMedia instanceof TLRPC$TL_inputMediaUploadedDocument)) {
                    if (BuildVars.DEBUG_VERSION) {
                        FileLog.d("multi media not ready");
                        return;
                    }
                    return;
                }
                i++;
            }
            if (check && (delayedMessageFindMaxDelayedMessageForMessageId = findMaxDelayedMessageForMessageId(message.finalGroupMessage, message.peer)) != null) {
                delayedMessageFindMaxDelayedMessageForMessageId.addDelayedRequest(message.sendRequest, message.messageObjects, message.originalPaths, message.parentObjects, message, message.scheduled);
                ArrayList<DelayedMessageSendAfterRequest> arrayList = message.requests;
                if (arrayList != null) {
                    delayedMessageFindMaxDelayedMessageForMessageId.requests.addAll(arrayList);
                }
                if (BuildVars.DEBUG_VERSION) {
                    FileLog.d("has maxDelayedMessage, delay");
                    return;
                }
                return;
            }
        } else {
            TLRPC$TL_messages_sendEncryptedMultiMedia tLRPC$TL_messages_sendEncryptedMultiMedia = (TLRPC$TL_messages_sendEncryptedMultiMedia) message.sendEncryptedRequest;
            while (i < tLRPC$TL_messages_sendEncryptedMultiMedia.files.size()) {
                if (tLRPC$TL_messages_sendEncryptedMultiMedia.files.get(i) instanceof TLRPC$TL_inputEncryptedFile) {
                    return;
                } else {
                    i++;
                }
            }
        }
        TLObject tLObject2 = message.sendRequest;
        if (tLObject2 instanceof TLRPC$TL_messages_sendMultiMedia) {
            performSendMessageRequestMulti((TLRPC$TL_messages_sendMultiMedia) tLObject2, message.messageObjects, message.originalPaths, message.parentObjects, message, message.scheduled);
        } else {
            getSecretChatHelper().performSendEncryptedRequest((TLRPC$TL_messages_sendEncryptedMultiMedia) message.sendEncryptedRequest, message);
        }
        message.sendDelayedRequests();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$stopVideoService$36, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$stopVideoService$36$SendMessagesHelper(String str) {
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.stopEncodingService, str, Integer.valueOf(this.currentAccount));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$stopVideoService$37, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$stopVideoService$37$SendMessagesHelper(final String str) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$6e8ZJ5ofEEjdjV1upN4MP2ugOQc
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$stopVideoService$36$SendMessagesHelper(str);
            }
        });
    }

    public void stopVideoService(final String path) {
        getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$YJsqa9tenKYNa07ChXwiPbpTFtA
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$stopVideoService$37$SendMessagesHelper(path);
            }
        });
    }

    protected void putToSendingMessages(final TLRPC$Message message, final boolean scheduled) {
        if (Thread.currentThread() != ApplicationLoader.applicationHandler.getLooper().getThread()) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$ukHNox6ragn8doaWPLmEGYNTCN0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$putToSendingMessages$38$SendMessagesHelper(message, scheduled);
                }
            });
        } else {
            putToSendingMessages(message, scheduled, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$putToSendingMessages$38, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$putToSendingMessages$38$SendMessagesHelper(TLRPC$Message tLRPC$Message, boolean z) {
        putToSendingMessages(tLRPC$Message, z, true);
    }

    protected void putToSendingMessages(TLRPC$Message message, boolean scheduled, boolean notify) {
        if (message == null) {
            return;
        }
        int i = message.id;
        if (i > 0) {
            this.editingMessages.put(i, message);
            return;
        }
        boolean z = this.sendingMessages.indexOfKey(i) >= 0;
        removeFromUploadingMessages(message.id, scheduled);
        this.sendingMessages.put(message.id, message);
        if (scheduled || z) {
            return;
        }
        long dialogId = MessageObject.getDialogId(message);
        LongSparseArray<Integer> longSparseArray = this.sendingMessagesIdDialogs;
        longSparseArray.put(dialogId, Integer.valueOf(longSparseArray.get(dialogId, 0).intValue() + 1));
        if (notify) {
            getNotificationCenter().postNotificationName(NotificationCenter.sendingMessagesChanged, new Object[0]);
        }
    }

    protected TLRPC$Message removeFromSendingMessages(int mid, boolean scheduled) {
        long dialogId;
        Integer num;
        if (mid > 0) {
            TLRPC$Message tLRPC$Message = this.editingMessages.get(mid);
            if (tLRPC$Message == null) {
                return tLRPC$Message;
            }
            this.editingMessages.remove(mid);
            return tLRPC$Message;
        }
        TLRPC$Message tLRPC$Message2 = this.sendingMessages.get(mid);
        if (tLRPC$Message2 != null) {
            this.sendingMessages.remove(mid);
            if (!scheduled && (num = this.sendingMessagesIdDialogs.get((dialogId = MessageObject.getDialogId(tLRPC$Message2)))) != null) {
                int iIntValue = num.intValue() - 1;
                if (iIntValue <= 0) {
                    this.sendingMessagesIdDialogs.remove(dialogId);
                } else {
                    this.sendingMessagesIdDialogs.put(dialogId, Integer.valueOf(iIntValue));
                }
                getNotificationCenter().postNotificationName(NotificationCenter.sendingMessagesChanged, new Object[0]);
            }
        }
        return tLRPC$Message2;
    }

    public int getSendingMessageId(long did) {
        for (int i = 0; i < this.sendingMessages.size(); i++) {
            TLRPC$Message tLRPC$MessageValueAt = this.sendingMessages.valueAt(i);
            if (tLRPC$MessageValueAt.dialog_id == did) {
                return tLRPC$MessageValueAt.id;
            }
        }
        for (int i2 = 0; i2 < this.uploadMessages.size(); i2++) {
            TLRPC$Message tLRPC$MessageValueAt2 = this.uploadMessages.valueAt(i2);
            if (tLRPC$MessageValueAt2.dialog_id == did) {
                return tLRPC$MessageValueAt2.id;
            }
        }
        return 0;
    }

    protected void putToUploadingMessages(MessageObject obj) {
        if (obj == null || obj.getId() > 0 || obj.scheduled) {
            return;
        }
        TLRPC$Message tLRPC$Message = obj.messageOwner;
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

    protected void removeFromUploadingMessages(int mid, boolean scheduled) {
        TLRPC$Message tLRPC$Message;
        if (mid > 0 || scheduled || (tLRPC$Message = this.uploadMessages.get(mid)) == null) {
            return;
        }
        this.uploadMessages.remove(mid);
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

    public boolean isSendingMessage(int mid) {
        return this.sendingMessages.indexOfKey(mid) >= 0 || this.editingMessages.indexOfKey(mid) >= 0;
    }

    public boolean isSendingMessageIdDialog(long did) {
        return this.sendingMessagesIdDialogs.get(did, 0).intValue() > 0;
    }

    public boolean isUploadingMessageIdDialog(long did) {
        return this.uploadingMessagesIdDialogs.get(did, 0).intValue() > 0;
    }

    protected void performSendMessageRequestMulti(final TLRPC$TL_messages_sendMultiMedia req, final ArrayList<MessageObject> msgObjs, final ArrayList<String> originalPaths, final ArrayList<Object> parentObjects, final DelayedMessage delayedMessage, final boolean scheduled) {
        int size = msgObjs.size();
        for (int i = 0; i < size; i++) {
            putToSendingMessages(msgObjs.get(i).messageOwner, scheduled);
        }
        getConnectionsManager().sendRequest(req, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$PH32pfqQc5rGouPOIOp44mVSSk4
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$performSendMessageRequestMulti$46$SendMessagesHelper(parentObjects, req, msgObjs, originalPaths, delayedMessage, scheduled, tLObject, tLRPC$TL_error);
            }
        }, (QuickAckDelegate) null, 68);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$performSendMessageRequestMulti$46, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$performSendMessageRequestMulti$46$SendMessagesHelper(ArrayList arrayList, final TLRPC$TL_messages_sendMultiMedia tLRPC$TL_messages_sendMultiMedia, final ArrayList arrayList2, final ArrayList arrayList3, final DelayedMessage delayedMessage, final boolean z, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error != null && FileRefController.isFileRefError(tLRPC$TL_error.text)) {
            if (arrayList != null) {
                ArrayList arrayList4 = new ArrayList(arrayList);
                getFileRefController().requestReference(arrayList4, tLRPC$TL_messages_sendMultiMedia, arrayList2, arrayList3, arrayList4, delayedMessage, Boolean.valueOf(z));
                return;
            } else if (delayedMessage != null && !delayedMessage.retriedToSend) {
                delayedMessage.retriedToSend = true;
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$Xz_ABUzUSI4h6u4dSLZ-DCX66Ug
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$performSendMessageRequestMulti$39$SendMessagesHelper(tLRPC$TL_messages_sendMultiMedia, delayedMessage, arrayList2, z);
                    }
                });
                return;
            }
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$cUvO7gORB0vKt-4Cy46SngliOLk
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$performSendMessageRequestMulti$45$SendMessagesHelper(tLRPC$TL_error, tLObject, arrayList2, arrayList3, z, tLRPC$TL_messages_sendMultiMedia);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$performSendMessageRequestMulti$39, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$performSendMessageRequestMulti$39$SendMessagesHelper(TLRPC$TL_messages_sendMultiMedia tLRPC$TL_messages_sendMultiMedia, DelayedMessage delayedMessage, ArrayList arrayList, boolean z) {
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
            getMessagesStorage().markMessageAsSendError(tLRPC$Message, z);
            tLRPC$Message.send_state = 2;
            getNotificationCenter().postNotificationName(NotificationCenter.messageSendError, Integer.valueOf(tLRPC$Message.id));
            processSentMessage(tLRPC$Message.id);
            removeFromSendingMessages(tLRPC$Message.id, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$performSendMessageRequestMulti$45, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$performSendMessageRequestMulti$45$SendMessagesHelper(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, ArrayList arrayList, ArrayList arrayList2, final boolean z, TLRPC$TL_messages_sendMultiMedia tLRPC$TL_messages_sendMultiMedia) {
        boolean z2;
        final TLRPC$Updates tLRPC$Updates;
        boolean z3;
        TLRPC$Message tLRPC$Message;
        TLRPC$Updates tLRPC$Updates2;
        int i;
        TLRPC$TL_messageReplyHeader tLRPC$TL_messageReplyHeader;
        if (tLRPC$TL_error == null) {
            SparseArray sparseArray = new SparseArray();
            LongSparseArray longSparseArray = new LongSparseArray();
            TLRPC$Updates tLRPC$Updates3 = (TLRPC$Updates) tLObject;
            ArrayList<TLRPC$Update> arrayList3 = tLRPC$Updates3.updates;
            LongSparseArray<SparseArray<TLRPC$MessageReplies>> longSparseArray2 = null;
            int i2 = 0;
            while (i2 < arrayList3.size()) {
                TLRPC$Update tLRPC$Update = arrayList3.get(i2);
                if (tLRPC$Update instanceof TLRPC$TL_updateMessageID) {
                    TLRPC$TL_updateMessageID tLRPC$TL_updateMessageID = (TLRPC$TL_updateMessageID) tLRPC$Update;
                    longSparseArray.put(tLRPC$TL_updateMessageID.random_id, Integer.valueOf(tLRPC$TL_updateMessageID.id));
                    arrayList3.remove(i2);
                } else if (tLRPC$Update instanceof TLRPC$TL_updateNewMessage) {
                    final TLRPC$TL_updateNewMessage tLRPC$TL_updateNewMessage = (TLRPC$TL_updateNewMessage) tLRPC$Update;
                    TLRPC$Message tLRPC$Message2 = tLRPC$TL_updateNewMessage.message;
                    sparseArray.put(tLRPC$Message2.id, tLRPC$Message2);
                    Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$bYQ9p8qZ1gY8FFy4vifwFMvVlBU
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$performSendMessageRequestMulti$40$SendMessagesHelper(tLRPC$TL_updateNewMessage);
                        }
                    });
                    arrayList3.remove(i2);
                } else if (tLRPC$Update instanceof TLRPC$TL_updateNewChannelMessage) {
                    final TLRPC$TL_updateNewChannelMessage tLRPC$TL_updateNewChannelMessage = (TLRPC$TL_updateNewChannelMessage) tLRPC$Update;
                    TLRPC$Chat chat = getMessagesController().getChat(Long.valueOf(MessagesController.getUpdateChannelId(tLRPC$TL_updateNewChannelMessage)));
                    if ((chat == null || chat.megagroup) && (tLRPC$TL_messageReplyHeader = tLRPC$TL_updateNewChannelMessage.message.reply_to) != null && (tLRPC$TL_messageReplyHeader.reply_to_top_id != 0 || tLRPC$TL_messageReplyHeader.reply_to_msg_id != 0)) {
                        if (longSparseArray2 == null) {
                            longSparseArray2 = new LongSparseArray<>();
                        }
                        long dialogId = MessageObject.getDialogId(tLRPC$TL_updateNewChannelMessage.message);
                        SparseArray<TLRPC$MessageReplies> sparseArray2 = longSparseArray2.get(dialogId);
                        if (sparseArray2 == null) {
                            sparseArray2 = new SparseArray<>();
                            longSparseArray2.put(dialogId, sparseArray2);
                        }
                        TLRPC$TL_messageReplyHeader tLRPC$TL_messageReplyHeader2 = tLRPC$TL_updateNewChannelMessage.message.reply_to;
                        int i3 = tLRPC$TL_messageReplyHeader2.reply_to_top_id;
                        if (i3 == 0) {
                            i3 = tLRPC$TL_messageReplyHeader2.reply_to_msg_id;
                        }
                        TLRPC$MessageReplies tLRPC$TL_messageReplies = sparseArray2.get(i3);
                        if (tLRPC$TL_messageReplies == null) {
                            tLRPC$TL_messageReplies = new TLRPC$TL_messageReplies();
                            sparseArray2.put(i3, tLRPC$TL_messageReplies);
                        }
                        TLRPC$Peer tLRPC$Peer = tLRPC$TL_updateNewChannelMessage.message.from_id;
                        if (tLRPC$Peer != null) {
                            tLRPC$TL_messageReplies.recent_repliers.add(0, tLRPC$Peer);
                        }
                        tLRPC$TL_messageReplies.replies++;
                    }
                    TLRPC$Message tLRPC$Message3 = tLRPC$TL_updateNewChannelMessage.message;
                    sparseArray.put(tLRPC$Message3.id, tLRPC$Message3);
                    Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$nQ3l8vclccP8LptRquSqptTwFwM
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$performSendMessageRequestMulti$41$SendMessagesHelper(tLRPC$TL_updateNewChannelMessage);
                        }
                    });
                    arrayList3.remove(i2);
                } else if (tLRPC$Update instanceof TLRPC$TL_updateNewScheduledMessage) {
                    TLRPC$Message tLRPC$Message4 = ((TLRPC$TL_updateNewScheduledMessage) tLRPC$Update).message;
                    sparseArray.put(tLRPC$Message4.id, tLRPC$Message4);
                    arrayList3.remove(i2);
                } else {
                    i2++;
                }
                i2--;
                i2++;
            }
            if (longSparseArray2 != null) {
                getMessagesStorage().putChannelViews(null, null, longSparseArray2, true);
                getNotificationCenter().postNotificationName(NotificationCenter.didUpdateMessagesViews, null, null, longSparseArray2, Boolean.TRUE);
            }
            int i4 = 0;
            while (i4 < arrayList.size()) {
                MessageObject messageObject = (MessageObject) arrayList.get(i4);
                String str = (String) arrayList2.get(i4);
                final TLRPC$Message tLRPC$Message5 = messageObject.messageOwner;
                final int i5 = tLRPC$Message5.id;
                final ArrayList arrayList4 = new ArrayList();
                Integer num = (Integer) longSparseArray.get(tLRPC$Message5.random_id);
                if (num == null || (tLRPC$Message = (TLRPC$Message) sparseArray.get(num.intValue())) == null) {
                    tLRPC$Updates = tLRPC$Updates3;
                    z3 = true;
                    break;
                }
                MessageObject.getDialogId(tLRPC$Message);
                arrayList4.add(tLRPC$Message);
                if ((tLRPC$Message.flags & ConnectionsManager.FileTypeVideo) != 0) {
                    TLRPC$Message tLRPC$Message6 = messageObject.messageOwner;
                    tLRPC$Message6.ttl_period = tLRPC$Message.ttl_period;
                    tLRPC$Message6.flags = 33554432 | tLRPC$Message6.flags;
                }
                updateMediaPaths(messageObject, tLRPC$Message, tLRPC$Message.id, str, false);
                final int mediaExistanceFlags = messageObject.getMediaExistanceFlags();
                tLRPC$Message5.id = tLRPC$Message.id;
                final long j = tLRPC$Message.grouped_id;
                if (z) {
                    tLRPC$Updates2 = tLRPC$Updates3;
                    i = i4;
                } else {
                    tLRPC$Updates2 = tLRPC$Updates3;
                    i = i4;
                    Integer numValueOf = (Integer) getMessagesController().dialogs_read_outbox_max.get(Long.valueOf(tLRPC$Message.dialog_id));
                    if (numValueOf == null) {
                        numValueOf = Integer.valueOf(getMessagesStorage().getDialogReadMax(tLRPC$Message.out, tLRPC$Message.dialog_id));
                        getMessagesController().dialogs_read_outbox_max.put(Long.valueOf(tLRPC$Message.dialog_id), numValueOf);
                    }
                    tLRPC$Message.unread = numValueOf.intValue() < tLRPC$Message.id;
                }
                getStatsController().incrementSentItemsCount(ApplicationLoader.getCurrentNetworkType(), 1, 1);
                tLRPC$Message5.send_state = 0;
                getNotificationCenter().postNotificationName(NotificationCenter.messageReceivedByServer, Integer.valueOf(i5), Integer.valueOf(tLRPC$Message5.id), tLRPC$Message5, Long.valueOf(tLRPC$Message5.dialog_id), Long.valueOf(j), Integer.valueOf(mediaExistanceFlags), Boolean.valueOf(z));
                getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$1lptHDABlnbNIOnb5Nnvkn4L-KA
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$performSendMessageRequestMulti$43$SendMessagesHelper(tLRPC$Message5, i5, z, arrayList4, j, mediaExistanceFlags);
                    }
                });
                i4 = i + 1;
                sparseArray = sparseArray;
                tLRPC$Updates3 = tLRPC$Updates2;
                longSparseArray = longSparseArray;
            }
            tLRPC$Updates = tLRPC$Updates3;
            z3 = false;
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$JeaHmdptLPH5Bnmwf4RzacSUXcA
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$performSendMessageRequestMulti$44$SendMessagesHelper(tLRPC$Updates);
                }
            });
            z2 = z3;
        } else {
            AlertsCreator.processError(this.currentAccount, tLRPC$TL_error, null, tLRPC$TL_messages_sendMultiMedia, new Object[0]);
            z2 = true;
        }
        if (z2) {
            for (int i6 = 0; i6 < arrayList.size(); i6++) {
                TLRPC$Message tLRPC$Message7 = ((MessageObject) arrayList.get(i6)).messageOwner;
                getMessagesStorage().markMessageAsSendError(tLRPC$Message7, z);
                tLRPC$Message7.send_state = 2;
                getNotificationCenter().postNotificationName(NotificationCenter.messageSendError, Integer.valueOf(tLRPC$Message7.id));
                processSentMessage(tLRPC$Message7.id);
                removeFromSendingMessages(tLRPC$Message7.id, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$performSendMessageRequestMulti$40, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$performSendMessageRequestMulti$40$SendMessagesHelper(TLRPC$TL_updateNewMessage tLRPC$TL_updateNewMessage) {
        getMessagesController().processNewDifferenceParams(-1, tLRPC$TL_updateNewMessage.pts, -1, tLRPC$TL_updateNewMessage.pts_count);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$performSendMessageRequestMulti$41, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$performSendMessageRequestMulti$41$SendMessagesHelper(TLRPC$TL_updateNewChannelMessage tLRPC$TL_updateNewChannelMessage) {
        getMessagesController().processNewChannelDifferenceParams(tLRPC$TL_updateNewChannelMessage.pts, tLRPC$TL_updateNewChannelMessage.pts_count, tLRPC$TL_updateNewChannelMessage.message.peer_id.channel_id);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$performSendMessageRequestMulti$43, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$performSendMessageRequestMulti$43$SendMessagesHelper(final TLRPC$Message tLRPC$Message, final int i, final boolean z, ArrayList arrayList, final long j, final int i2) {
        getMessagesStorage().updateMessageStateAndId(tLRPC$Message.random_id, MessageObject.getPeerId(tLRPC$Message.peer_id), Integer.valueOf(i), tLRPC$Message.id, 0, false, z ? 1 : 0);
        getMessagesStorage().putMessages((ArrayList<TLRPC$Message>) arrayList, true, false, false, 0, z);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$mB15fsc6fQhjO6TJv_Wg_vC6Grw
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$performSendMessageRequestMulti$42$SendMessagesHelper(tLRPC$Message, i, j, i2, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$performSendMessageRequestMulti$42, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$performSendMessageRequestMulti$42$SendMessagesHelper(TLRPC$Message tLRPC$Message, int i, long j, int i2, boolean z) {
        getMediaDataController().increasePeerRaiting(tLRPC$Message.dialog_id);
        getNotificationCenter().postNotificationName(NotificationCenter.messageReceivedByServer, Integer.valueOf(i), Integer.valueOf(tLRPC$Message.id), tLRPC$Message, Long.valueOf(tLRPC$Message.dialog_id), Long.valueOf(j), Integer.valueOf(i2), Boolean.valueOf(z));
        processSentMessage(i);
        removeFromSendingMessages(i, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$performSendMessageRequestMulti$44, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$performSendMessageRequestMulti$44$SendMessagesHelper(TLRPC$Updates tLRPC$Updates) {
        getMessagesController().processUpdates(tLRPC$Updates, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performSendMessageRequest(final TLObject req, final MessageObject msgObj, final String originalPath, DelayedMessage delayedMessage, Object parentObject, HashMap<String, String> params, boolean scheduled) {
        performSendMessageRequest(req, msgObj, originalPath, null, false, delayedMessage, parentObject, params, scheduled);
    }

    /*  JADX ERROR: NullPointerException in pass: LoopRegionVisitor
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.use(jadx.core.dex.instructions.args.RegisterArg)" because "ssaVar" is null
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:493)
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:496)
        */
    private ir.eitaa.messenger.SendMessagesHelper.DelayedMessage findMaxDelayedMessageForMessageId(int r12, long r13) {
        /*
            r11 = this;
            java.util.HashMap<java.lang.String, java.util.ArrayList<ir.eitaa.messenger.SendMessagesHelper$DelayedMessage>> r0 = r11.delayedMessages
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
            r1 = 0
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
        Ld:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L6e
            java.lang.Object r3 = r0.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r3 = r3.getValue()
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            int r4 = r3.size()
            r5 = 0
            r6 = 0
        L25:
            if (r6 >= r4) goto Ld
            java.lang.Object r7 = r3.get(r6)
            ir.eitaa.messenger.SendMessagesHelper$DelayedMessage r7 = (ir.eitaa.messenger.SendMessagesHelper.DelayedMessage) r7
            int r8 = r7.type
            r9 = 4
            if (r8 == r9) goto L34
            if (r8 != 0) goto L6b
        L34:
            long r8 = r7.peer
            int r10 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
            if (r10 != 0) goto L6b
            ir.eitaa.messenger.MessageObject r8 = r7.obj
            if (r8 == 0) goto L43
            int r8 = r8.getId()
            goto L61
        L43:
            java.util.ArrayList<ir.eitaa.messenger.MessageObject> r8 = r7.messageObjects
            if (r8 == 0) goto L60
            boolean r8 = r8.isEmpty()
            if (r8 != 0) goto L60
            java.util.ArrayList<ir.eitaa.messenger.MessageObject> r8 = r7.messageObjects
            int r9 = r8.size()
            int r9 = r9 + (-1)
            java.lang.Object r8 = r8.get(r9)
            ir.eitaa.messenger.MessageObject r8 = (ir.eitaa.messenger.MessageObject) r8
            int r8 = r8.getId()
            goto L61
        L60:
            r8 = 0
        L61:
            if (r8 == 0) goto L6b
            if (r8 <= r12) goto L6b
            if (r1 != 0) goto L6b
            if (r2 >= r8) goto L6b
            r1 = r7
            r2 = r8
        L6b:
            int r6 = r6 + 1
            goto L25
        L6e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.SendMessagesHelper.findMaxDelayedMessageForMessageId(int, long):ir.eitaa.messenger.SendMessagesHelper$DelayedMessage");
    }

    protected void performSendMessageRequest(final TLObject req, final MessageObject msgObj, final String originalPath, final DelayedMessage parentMessage, final boolean check, final DelayedMessage delayedMessage, final Object parentObject, HashMap<String, String> params, final boolean scheduled) {
        DelayedMessage delayedMessageFindMaxDelayedMessageForMessageId;
        ArrayList<DelayedMessageSendAfterRequest> arrayList;
        if (!(req instanceof TLRPC$TL_messages_editMessage) && check && (delayedMessageFindMaxDelayedMessageForMessageId = findMaxDelayedMessageForMessageId(msgObj.getId(), msgObj.getDialogId())) != null) {
            delayedMessageFindMaxDelayedMessageForMessageId.addDelayedRequest(req, msgObj, originalPath, parentObject, delayedMessage, parentMessage != null ? parentMessage.scheduled : false);
            if (parentMessage == null || (arrayList = parentMessage.requests) == null) {
                return;
            }
            delayedMessageFindMaxDelayedMessageForMessageId.requests.addAll(arrayList);
            return;
        }
        final TLRPC$Message tLRPC$Message = msgObj.messageOwner;
        putToSendingMessages(tLRPC$Message, scheduled);
        tLRPC$Message.reqId = getConnectionsManager().sendRequest(req, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$_UOvZ2gyqjwcFRG3gCEtmgFeRpE
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$performSendMessageRequest$60$SendMessagesHelper(req, parentObject, msgObj, originalPath, parentMessage, check, delayedMessage, scheduled, tLRPC$Message, tLObject, tLRPC$TL_error);
            }
        }, new QuickAckDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$5Kik-I2NhYhBZ4BEsRreMOK4Qv4
            @Override // ir.eitaa.tgnet.QuickAckDelegate
            public final void run() {
                this.f$0.lambda$performSendMessageRequest$62$SendMessagesHelper(tLRPC$Message);
            }
        }, (req instanceof TLRPC$TL_messages_sendMessage ? 128 : 0) | 68);
        if (parentMessage != null) {
            parentMessage.sendDelayedRequests();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$performSendMessageRequest$60, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$performSendMessageRequest$60$SendMessagesHelper(final TLObject tLObject, Object obj, final MessageObject messageObject, final String str, DelayedMessage delayedMessage, boolean z, final DelayedMessage delayedMessage2, final boolean z2, final TLRPC$Message tLRPC$Message, final TLObject tLObject2, final TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error != null && (((tLObject instanceof TLRPC$TL_messages_sendMedia) || (tLObject instanceof TLRPC$TL_messages_editMessage)) && FileRefController.isFileRefError(tLRPC$TL_error.text))) {
            if (obj != null) {
                getFileRefController().requestReference(obj, tLObject, messageObject, str, delayedMessage, Boolean.valueOf(z), delayedMessage2, Boolean.valueOf(z2));
                return;
            } else if (delayedMessage2 != null) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$Yd-aKXbQHHsnNmeJzHO8NM4Gi7Y
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$performSendMessageRequest$47$SendMessagesHelper(tLRPC$Message, z2, tLObject, delayedMessage2);
                    }
                });
                return;
            }
        }
        if (tLObject instanceof TLRPC$TL_messages_editMessage) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$Jwh55yf1TcJ0JBPoSVYa0FUTwrE
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$performSendMessageRequest$50$SendMessagesHelper(tLRPC$TL_error, tLRPC$Message, tLObject2, messageObject, str, z2, tLObject);
                }
            });
        } else {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$_gg-_5dyRP8ojUaOmQfYGmN0jvo
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$performSendMessageRequest$59$SendMessagesHelper(z2, tLRPC$TL_error, tLRPC$Message, tLObject2, messageObject, str, tLObject);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$performSendMessageRequest$47, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$performSendMessageRequest$47$SendMessagesHelper(TLRPC$Message tLRPC$Message, boolean z, TLObject tLObject, DelayedMessage delayedMessage) {
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
    /* renamed from: lambda$performSendMessageRequest$50, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$performSendMessageRequest$50$SendMessagesHelper(TLRPC$TL_error tLRPC$TL_error, final TLRPC$Message tLRPC$Message, TLObject tLObject, MessageObject messageObject, String str, final boolean z, TLObject tLObject2) {
        int i = 0;
        TLRPC$Message tLRPC$Message2 = null;
        if (tLRPC$TL_error == null) {
            String str2 = tLRPC$Message.attachPath;
            final TLRPC$Updates tLRPC$Updates = (TLRPC$Updates) tLObject;
            ArrayList<TLRPC$Update> arrayList = tLRPC$Updates.updates;
            while (true) {
                if (i >= arrayList.size()) {
                    break;
                }
                TLRPC$Update tLRPC$Update = arrayList.get(i);
                if (tLRPC$Update instanceof TLRPC$TL_updateEditMessage) {
                    tLRPC$Message2 = ((TLRPC$TL_updateEditMessage) tLRPC$Update).message;
                    break;
                } else if (tLRPC$Update instanceof TLRPC$TL_updateEditChannelMessage) {
                    tLRPC$Message2 = ((TLRPC$TL_updateEditChannelMessage) tLRPC$Update).message;
                    break;
                } else {
                    if (tLRPC$Update instanceof TLRPC$TL_updateNewScheduledMessage) {
                        tLRPC$Message2 = ((TLRPC$TL_updateNewScheduledMessage) tLRPC$Update).message;
                        break;
                    }
                    i++;
                }
            }
            TLRPC$Message tLRPC$Message3 = tLRPC$Message2;
            if (tLRPC$Message3 != null) {
                ImageLoader.saveMessageThumbs(tLRPC$Message3);
                updateMediaPaths(messageObject, tLRPC$Message3, tLRPC$Message3.id, str, false);
            }
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$SLSxh19rsk7kqGwLJYq_AwOoDmQ
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$performSendMessageRequest$49$SendMessagesHelper(tLRPC$Updates, tLRPC$Message, z);
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
    /* renamed from: lambda$performSendMessageRequest$49, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$performSendMessageRequest$49$SendMessagesHelper(TLRPC$Updates tLRPC$Updates, final TLRPC$Message tLRPC$Message, final boolean z) {
        getMessagesController().processUpdates(tLRPC$Updates, false);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$3nMeJKCZEnnbJ90jrSwE40xBBaI
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$performSendMessageRequest$48$SendMessagesHelper(tLRPC$Message, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$performSendMessageRequest$48, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$performSendMessageRequest$48$SendMessagesHelper(TLRPC$Message tLRPC$Message, boolean z) {
        processSentMessage(tLRPC$Message.id);
        removeFromSendingMessages(tLRPC$Message.id, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0116, code lost:
    
        r12 = r3;
        r2 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:111:0x029f  */
    /* renamed from: lambda$performSendMessageRequest$59, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$performSendMessageRequest$59$SendMessagesHelper(final boolean r28, ir.eitaa.tgnet.TLRPC$TL_error r29, final ir.eitaa.tgnet.TLRPC$Message r30, ir.eitaa.tgnet.TLObject r31, final ir.eitaa.messenger.MessageObject r32, java.lang.String r33, ir.eitaa.tgnet.TLObject r34) {
        /*
            Method dump skipped, instructions count: 923
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.SendMessagesHelper.lambda$performSendMessageRequest$59$SendMessagesHelper(boolean, ir.eitaa.tgnet.TLRPC$TL_error, ir.eitaa.tgnet.TLRPC$Message, ir.eitaa.tgnet.TLObject, ir.eitaa.messenger.MessageObject, java.lang.String, ir.eitaa.tgnet.TLObject):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$performSendMessageRequest$51, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$performSendMessageRequest$51$SendMessagesHelper(TLRPC$TL_updateShortSentMessage tLRPC$TL_updateShortSentMessage) {
        getMessagesController().processNewDifferenceParams(-1, tLRPC$TL_updateShortSentMessage.pts, tLRPC$TL_updateShortSentMessage.date, tLRPC$TL_updateShortSentMessage.pts_count);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$performSendMessageRequest$52, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$performSendMessageRequest$52$SendMessagesHelper(TLRPC$TL_updateNewMessage tLRPC$TL_updateNewMessage) {
        getMessagesController().processNewDifferenceParams(-1, tLRPC$TL_updateNewMessage.pts, -1, tLRPC$TL_updateNewMessage.pts_count);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$performSendMessageRequest$53, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$performSendMessageRequest$53$SendMessagesHelper(TLRPC$TL_updateNewChannelMessage tLRPC$TL_updateNewChannelMessage) {
        getMessagesController().processNewChannelDifferenceParams(tLRPC$TL_updateNewChannelMessage.pts, tLRPC$TL_updateNewChannelMessage.pts_count, tLRPC$TL_updateNewChannelMessage.message.peer_id.channel_id);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$performSendMessageRequest$54, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$performSendMessageRequest$54$SendMessagesHelper(TLRPC$Updates tLRPC$Updates) {
        getMessagesController().processUpdates(tLRPC$Updates, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$performSendMessageRequest$56, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$performSendMessageRequest$56$SendMessagesHelper(ArrayList arrayList, final MessageObject messageObject, final TLRPC$Message tLRPC$Message, final int i, final boolean z, String str) {
        getMessagesStorage().putMessages((ArrayList<TLRPC$Message>) arrayList, true, false, false, 0, false);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$xzUMIAeVn-lD--fjiINnSrVff_0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$performSendMessageRequest$55$SendMessagesHelper(messageObject, tLRPC$Message, i, z);
            }
        });
        if (MessageObject.isVideoMessage(tLRPC$Message) || MessageObject.isRoundVideoMessage(tLRPC$Message) || MessageObject.isNewGifMessage(tLRPC$Message)) {
            stopVideoService(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$performSendMessageRequest$55, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$performSendMessageRequest$55$SendMessagesHelper(MessageObject messageObject, TLRPC$Message tLRPC$Message, int i, boolean z) {
        ArrayList<MessageObject> arrayList = new ArrayList<>();
        arrayList.add(new MessageObject(messageObject.currentAccount, messageObject.messageOwner, true, true));
        getMessagesController().updateInterfaceWithMessages(tLRPC$Message.dialog_id, arrayList, false);
        getMediaDataController().increasePeerRaiting(tLRPC$Message.dialog_id);
        processSentMessage(i);
        removeFromSendingMessages(i, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$performSendMessageRequest$58, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$performSendMessageRequest$58$SendMessagesHelper(final TLRPC$Message tLRPC$Message, final int i, final boolean z, ArrayList arrayList, final int i2, String str) {
        getMessagesStorage().updateMessageStateAndId(tLRPC$Message.random_id, MessageObject.getPeerId(tLRPC$Message.peer_id), Integer.valueOf(i), tLRPC$Message.id, 0, false, z ? 1 : 0);
        getMessagesStorage().putMessages((ArrayList<TLRPC$Message>) arrayList, true, false, false, 0, z);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$tgpThsutVIMvQV6O_zk1n9n9Xh8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$performSendMessageRequest$57$SendMessagesHelper(tLRPC$Message, i, i2, z);
            }
        });
        if (MessageObject.isVideoMessage(tLRPC$Message) || MessageObject.isRoundVideoMessage(tLRPC$Message) || MessageObject.isNewGifMessage(tLRPC$Message)) {
            stopVideoService(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$performSendMessageRequest$57, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$performSendMessageRequest$57$SendMessagesHelper(TLRPC$Message tLRPC$Message, int i, int i2, boolean z) {
        getMediaDataController().increasePeerRaiting(tLRPC$Message.dialog_id);
        getNotificationCenter().postNotificationName(NotificationCenter.messageReceivedByServer, Integer.valueOf(i), Integer.valueOf(tLRPC$Message.id), tLRPC$Message, Long.valueOf(tLRPC$Message.dialog_id), 0L, Integer.valueOf(i2), Boolean.valueOf(z));
        processSentMessage(i);
        removeFromSendingMessages(i, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$performSendMessageRequest$62, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$performSendMessageRequest$62$SendMessagesHelper(final TLRPC$Message tLRPC$Message) {
        final int i = tLRPC$Message.id;
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$G0P2oxtGmGtvX5YZR61J6KR3gKE
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$performSendMessageRequest$61$SendMessagesHelper(tLRPC$Message, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$performSendMessageRequest$61, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$performSendMessageRequest$61$SendMessagesHelper(TLRPC$Message tLRPC$Message, int i) {
        tLRPC$Message.send_state = 0;
        getNotificationCenter().postNotificationName(NotificationCenter.messageReceivedByAck, Integer.valueOf(i));
    }

    /* JADX WARN: Removed duplicated region for block: B:141:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void updateMediaPaths(ir.eitaa.messenger.MessageObject r19, ir.eitaa.tgnet.TLRPC$Message r20, int r21, java.lang.String r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 1703
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.SendMessagesHelper.updateMediaPaths(ir.eitaa.messenger.MessageObject, ir.eitaa.tgnet.TLRPC$Message, int, java.lang.String, boolean):void");
    }

    private void putToDelayedMessages(String location, DelayedMessage message) {
        ArrayList<DelayedMessage> arrayList = this.delayedMessages.get(location);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.delayedMessages.put(location, arrayList);
        }
        arrayList.add(message);
    }

    protected ArrayList<DelayedMessage> getDelayedMessages(String location) {
        return this.delayedMessages.get(location);
    }

    protected long getNextRandomId() {
        long jNextLong = 0;
        while (jNextLong == 0) {
            jNextLong = Utilities.random.nextLong();
        }
        return jNextLong;
    }

    public void checkUnsentMessages() {
        getMessagesStorage().getUnsentMessages(1000);
    }

    protected void processUnsentMessages(final ArrayList<TLRPC$Message> messages, final ArrayList<TLRPC$Message> scheduledMessages, final ArrayList<TLRPC$User> users, final ArrayList<TLRPC$Chat> chats, final ArrayList<TLRPC$EncryptedChat> encryptedChats) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$xym4305cgA418qyxvd2OGB-3SFY
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processUnsentMessages$63$SendMessagesHelper(users, chats, encryptedChats, messages, scheduledMessages);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processUnsentMessages$63, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processUnsentMessages$63$SendMessagesHelper(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4, ArrayList arrayList5) {
        HashMap<String, String> map;
        getMessagesController().putUsers(arrayList, true);
        getMessagesController().putChats(arrayList2, true);
        getMessagesController().putEncryptedChats(arrayList3, true);
        int size = arrayList4.size();
        for (int i = 0; i < size; i++) {
            MessageObject messageObject = new MessageObject(this.currentAccount, (TLRPC$Message) arrayList4.get(i), false, true);
            long groupId = messageObject.getGroupId();
            if (groupId != 0 && (map = messageObject.messageOwner.params) != null && !map.containsKey("final") && (i == size - 1 || ((TLRPC$Message) arrayList4.get(i + 1)).grouped_id != groupId)) {
                messageObject.messageOwner.params.put("final", "1");
            }
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

    public ImportingStickers getImportingStickers(String shortName) {
        return this.importingStickersMap.get(shortName);
    }

    public ImportingHistory getImportingHistory(long dialogId) {
        return this.importingHistoryMap.get(dialogId);
    }

    public boolean isImportingStickers() {
        return this.importingStickersMap.size() != 0;
    }

    public boolean isImportingHistory() {
        return this.importingHistoryMap.size() != 0;
    }

    public void prepareImportHistory(final long dialogId, final Uri uri, final ArrayList<Uri> mediaUris, final MessagesStorage.LongCallback onStartImport) {
        if (this.importingHistoryMap.get(dialogId) != null) {
            onStartImport.run(0L);
            return;
        }
        if (DialogObject.isChatDialog(dialogId)) {
            long j = -dialogId;
            TLRPC$Chat chat = getMessagesController().getChat(Long.valueOf(j));
            if (chat != null && !chat.megagroup) {
                getMessagesController().convertToMegaGroup(null, j, null, new MessagesStorage.LongCallback() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$UxPEDrVOpc0FwVIABM2wkl-CTas
                    @Override // ir.eitaa.messenger.MessagesStorage.LongCallback
                    public final void run(long j2) {
                        this.f$0.lambda$prepareImportHistory$64$SendMessagesHelper(uri, mediaUris, onStartImport, j2);
                    }
                });
                return;
            }
        }
        new Thread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$USHpf80lfkYyqx7gbYhhdbdvtLE
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$prepareImportHistory$69$SendMessagesHelper(mediaUris, dialogId, uri, onStartImport);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$prepareImportHistory$64, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$prepareImportHistory$64$SendMessagesHelper(Uri uri, ArrayList arrayList, MessagesStorage.LongCallback longCallback, long j) {
        if (j != 0) {
            prepareImportHistory(-j, uri, arrayList, longCallback);
        } else {
            longCallback.run(0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0091  */
    /* renamed from: lambda$prepareImportHistory$69, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$prepareImportHistory$69$SendMessagesHelper(java.util.ArrayList r17, final long r18, android.net.Uri r20, final ir.eitaa.messenger.MessagesStorage.LongCallback r21) {
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
            ir.eitaa.messenger.SendMessagesHelper$ImportingHistory r5 = new ir.eitaa.messenger.SendMessagesHelper$ImportingHistory
            r7 = r16
            r5.<init>()
            r5.mediaPaths = r0
            r5.dialogId = r3
            ir.eitaa.messenger.MessagesController r1 = r16.getMessagesController()
            ir.eitaa.tgnet.TLRPC$InputPeer r1 = r1.getInputPeer(r3)
            r5.peer = r1
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r1 = 0
            int r8 = r0.size()
        L2d:
            int r9 = r8 + 1
            if (r1 >= r9) goto Laa
            if (r1 != 0) goto L36
            r9 = r20
            goto L3e
        L36:
            int r9 = r1 + (-1)
            java.lang.Object r9 = r0.get(r9)
            android.net.Uri r9 = (android.net.Uri) r9
        L3e:
            if (r9 == 0) goto L9c
            boolean r10 = ir.eitaa.messenger.AndroidUtilities.isInternalUri(r9)
            if (r10 == 0) goto L47
            goto L9c
        L47:
            java.lang.String r10 = "txt"
            java.lang.String r9 = ir.eitaa.messenger.MediaController.copyFileToCache(r9, r10)
            if (r9 != 0) goto L50
            goto La7
        L50:
            java.io.File r10 = new java.io.File
            r10.<init>(r9)
            boolean r11 = r10.exists()
            if (r11 == 0) goto L91
            long r11 = r10.length()
            r13 = 0
            int r15 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r15 != 0) goto L66
            goto L91
        L66:
            long r13 = r5.totalSize
            long r13 = r13 + r11
            r5.totalSize = r13
            if (r1 != 0) goto L83
            r13 = 33554432(0x2000000, double:1.6578092E-316)
            int r15 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r15 <= 0) goto L80
            r10.delete()
            ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$DeJFtIwP_CIh1rIwJ46DUrOj9gk r0 = new ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$DeJFtIwP_CIh1rIwJ46DUrOj9gk
            r0.<init>()
            ir.eitaa.messenger.AndroidUtilities.runOnUIThread(r0)
            return
        L80:
            r5.historyPath = r9
            goto L88
        L83:
            java.util.ArrayList<java.lang.String> r10 = r5.uploadMedia
            r10.add(r9)
        L88:
            java.util.HashSet<java.lang.String> r10 = r5.uploadSet
            r10.add(r9)
            r2.put(r9, r5)
            goto La7
        L91:
            if (r1 != 0) goto La7
            ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$wdEKD-_2i51nfd3WUIvI5_YSTS4 r0 = new ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$wdEKD-_2i51nfd3WUIvI5_YSTS4
            r0.<init>()
            ir.eitaa.messenger.AndroidUtilities.runOnUIThread(r0)
            return
        L9c:
            if (r1 != 0) goto La7
            ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$cq6v220AGplnao9vuAKvICcn_KU r0 = new ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$cq6v220AGplnao9vuAKvICcn_KU
            r0.<init>()
            ir.eitaa.messenger.AndroidUtilities.runOnUIThread(r0)
            return
        La7:
            int r1 = r1 + 1
            goto L2d
        Laa:
            ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$ZtntPsdooWEWNco4BSyNmfjDYbY r8 = new ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$ZtntPsdooWEWNco4BSyNmfjDYbY
            r0 = r8
            r1 = r16
            r3 = r18
            r6 = r21
            r0.<init>()
            ir.eitaa.messenger.AndroidUtilities.runOnUIThread(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.SendMessagesHelper.lambda$prepareImportHistory$69$SendMessagesHelper(java.util.ArrayList, long, android.net.Uri, ir.eitaa.messenger.MessagesStorage$LongCallback):void");
    }

    static /* synthetic */ void lambda$prepareImportHistory$67(MessagesStorage.LongCallback longCallback) {
        Toast.makeText(ApplicationLoader.applicationContext, LocaleController.getString("ImportFileTooLarge", R.string.ImportFileTooLarge), 0).show();
        longCallback.run(0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$prepareImportHistory$68, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$prepareImportHistory$68$SendMessagesHelper(HashMap map, long j, ImportingHistory importingHistory, MessagesStorage.LongCallback longCallback) {
        this.importingHistoryFiles.putAll(map);
        this.importingHistoryMap.put(j, importingHistory);
        getFileLoader().uploadFile(importingHistory.historyPath, false, true, 0, ConnectionsManager.FileTypeFile, true);
        getNotificationCenter().postNotificationName(NotificationCenter.historyImportProgressChanged, Long.valueOf(j));
        longCallback.run(j);
        try {
            ApplicationLoader.applicationContext.startService(new Intent(ApplicationLoader.applicationContext, (Class<?>) ImportingService.class));
        } catch (Throwable th) {
            FileLog.e(th);
        }
    }

    public void prepareImportStickers(final String title, final String shortName, final String sofrware, final ArrayList<ImportingSticker> paths, final MessagesStorage.StringCallback onStartImport) {
        if (this.importingStickersMap.get(shortName) != null) {
            onStartImport.run(null);
        } else {
            new Thread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$yWZRNxX_JDIOlRwrC28fTZrMq3Q
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$prepareImportStickers$72$SendMessagesHelper(title, shortName, sofrware, paths, onStartImport);
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004c  */
    /* renamed from: lambda$prepareImportStickers$72, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$prepareImportStickers$72$SendMessagesHelper(java.lang.String r9, final java.lang.String r10, java.lang.String r11, java.util.ArrayList r12, final ir.eitaa.messenger.MessagesStorage.StringCallback r13) {
        /*
            r8 = this;
            ir.eitaa.messenger.SendMessagesHelper$ImportingStickers r2 = new ir.eitaa.messenger.SendMessagesHelper$ImportingStickers
            r2.<init>()
            r2.title = r9
            r2.shortName = r10
            r2.software = r11
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            int r9 = r12.size()
            r11 = 0
        L15:
            if (r11 >= r9) goto L5a
            java.lang.Object r0 = r12.get(r11)
            ir.eitaa.messenger.SendMessagesHelper$ImportingSticker r0 = (ir.eitaa.messenger.SendMessagesHelper.ImportingSticker) r0
            java.io.File r1 = new java.io.File
            java.lang.String r4 = r0.path
            r1.<init>(r4)
            boolean r4 = r1.exists()
            if (r4 == 0) goto L4c
            long r4 = r1.length()
            r6 = 0
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 != 0) goto L35
            goto L4c
        L35:
            long r6 = r2.totalSize
            long r6 = r6 + r4
            r2.totalSize = r6
            java.util.ArrayList<ir.eitaa.messenger.SendMessagesHelper$ImportingSticker> r1 = r2.uploadMedia
            r1.add(r0)
            java.util.HashMap<java.lang.String, ir.eitaa.messenger.SendMessagesHelper$ImportingSticker> r1 = r2.uploadSet
            java.lang.String r4 = r0.path
            r1.put(r4, r0)
            java.lang.String r0 = r0.path
            r3.put(r0, r2)
            goto L57
        L4c:
            if (r11 != 0) goto L57
            ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$UIjX9MvnyQlDSeZyho357p-zfJ4 r9 = new ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$UIjX9MvnyQlDSeZyho357p-zfJ4
            r9.<init>()
            ir.eitaa.messenger.AndroidUtilities.runOnUIThread(r9)
            return
        L57:
            int r11 = r11 + 1
            goto L15
        L5a:
            ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$LKS6vzb_7QTb-ZNJ1qj8HmnoETU r9 = new ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$LKS6vzb_7QTb-ZNJ1qj8HmnoETU
            r0 = r9
            r1 = r8
            r4 = r10
            r5 = r13
            r0.<init>()
            ir.eitaa.messenger.AndroidUtilities.runOnUIThread(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.SendMessagesHelper.lambda$prepareImportStickers$72$SendMessagesHelper(java.lang.String, java.lang.String, java.lang.String, java.util.ArrayList, ir.eitaa.messenger.MessagesStorage$StringCallback):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$prepareImportStickers$71, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$prepareImportStickers$71$SendMessagesHelper(ImportingStickers importingStickers, HashMap map, String str, MessagesStorage.StringCallback stringCallback) {
        if (importingStickers.uploadMedia.get(0).item != null) {
            importingStickers.startImport();
        } else {
            this.importingStickersFiles.putAll(map);
            this.importingStickersMap.put(str, importingStickers);
            importingStickers.initImport();
            getNotificationCenter().postNotificationName(NotificationCenter.historyImportProgressChanged, str);
            stringCallback.run(str);
        }
        try {
            ApplicationLoader.applicationContext.startService(new Intent(ApplicationLoader.applicationContext, (Class<?>) ImportingService.class));
        } catch (Throwable th) {
            FileLog.e(th);
        }
    }

    public TLRPC$TL_photo generatePhotoSizes(String path, Uri imageUri) {
        return generatePhotoSizes(null, path, imageUri);
    }

    public TLRPC$TL_photo generatePhotoSizes(TLRPC$TL_photo photo, String path, Uri imageUri) {
        Bitmap bitmapLoadBitmap = ImageLoader.loadBitmap(path, imageUri, AndroidUtilities.getPhotoSize(), AndroidUtilities.getPhotoSize(), true);
        if (bitmapLoadBitmap == null) {
            bitmapLoadBitmap = ImageLoader.loadBitmap(path, imageUri, 800.0f, 800.0f, true);
        }
        ArrayList<TLRPC$PhotoSize> arrayList = new ArrayList<>();
        TLRPC$PhotoSize tLRPC$PhotoSizeScaleAndSaveImage = ImageLoader.scaleAndSaveImage(bitmapLoadBitmap, 90.0f, 90.0f, 55, true);
        if (tLRPC$PhotoSizeScaleAndSaveImage != null) {
            arrayList.add(tLRPC$PhotoSizeScaleAndSaveImage);
        }
        TLRPC$PhotoSize tLRPC$PhotoSizeScaleAndSaveImage2 = ImageLoader.scaleAndSaveImage(bitmapLoadBitmap, 320.0f, 320.0f, 55, true);
        if (tLRPC$PhotoSizeScaleAndSaveImage2 != null) {
            arrayList.add(tLRPC$PhotoSizeScaleAndSaveImage2);
        }
        TLRPC$PhotoSize tLRPC$PhotoSizeScaleAndSaveImage3 = ImageLoader.scaleAndSaveImage(bitmapLoadBitmap, AndroidUtilities.getPhotoSize(), AndroidUtilities.getPhotoSize(), true, 80, false, R.styleable.AppCompatTheme_textAppearanceSearchResultSubtitle, R.styleable.AppCompatTheme_textAppearanceSearchResultSubtitle);
        if (tLRPC$PhotoSizeScaleAndSaveImage3 != null) {
            arrayList.add(tLRPC$PhotoSizeScaleAndSaveImage3);
        }
        if (bitmapLoadBitmap != null) {
            bitmapLoadBitmap.recycle();
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        getUserConfig().saveConfig(false);
        if (photo == null) {
            photo = new TLRPC$TL_photo();
        }
        photo.date = getConnectionsManager().getCurrentTime();
        photo.sizes = arrayList;
        photo.file_reference = new byte[0];
        return photo;
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0200 A[PHI: r1
      0x0200: PHI (r1v3 java.lang.String) = (r1v0 java.lang.String), (r1v61 java.lang.String) binds: [B:133:0x01c2, B:140:0x01ff] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0205 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0310 A[PHI: r5
      0x0310: PHI (r5v20 java.lang.String) = 
      (r5v13 java.lang.String)
      (r5v14 java.lang.String)
      (r5v15 java.lang.String)
      (r5v16 java.lang.String)
      (r5v17 java.lang.String)
      (r5v18 java.lang.String)
      (r5v21 java.lang.String)
     binds: [B:204:0x0354, B:200:0x0349, B:196:0x033c, B:192:0x0331, B:188:0x0326, B:184:0x031b, B:181:0x030e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:239:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x03e5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0456  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x045b  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0465  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x046b  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0473  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x047e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:275:0x0487  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x048e  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x04e7  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x04ee A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:309:0x052e  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x0152 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:334:0x0164 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:341:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x012c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean prepareSendingDocumentInternal(final ir.eitaa.messenger.AccountInstance r39, java.lang.String r40, java.lang.String r41, android.net.Uri r42, java.lang.String r43, final long r44, final ir.eitaa.messenger.MessageObject r46, final ir.eitaa.messenger.MessageObject r47, java.lang.CharSequence r48, final java.util.ArrayList<ir.eitaa.tgnet.TLRPC$MessageEntity> r49, final ir.eitaa.messenger.MessageObject r50, long[] r51, boolean r52, boolean r53, final boolean r54, final int r55, java.lang.Integer[] r56) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1404
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.SendMessagesHelper.prepareSendingDocumentInternal(ir.eitaa.messenger.AccountInstance, java.lang.String, java.lang.String, android.net.Uri, java.lang.String, long, ir.eitaa.messenger.MessageObject, ir.eitaa.messenger.MessageObject, java.lang.CharSequence, java.util.ArrayList, ir.eitaa.messenger.MessageObject, long[], boolean, boolean, boolean, int, java.lang.Integer[]):boolean");
    }

    static /* synthetic */ void lambda$prepareSendingDocumentInternal$73(MessageObject messageObject, AccountInstance accountInstance, TLRPC$TL_document tLRPC$TL_document, String str, HashMap map, String str2, long j, MessageObject messageObject2, MessageObject messageObject3, String str3, ArrayList arrayList, boolean z, int i) {
        if (messageObject != null) {
            accountInstance.getSendMessagesHelper().editMessage(messageObject, null, null, tLRPC$TL_document, str, map, false, str2);
        } else {
            accountInstance.getSendMessagesHelper().sendMessage(tLRPC$TL_document, null, str, j, messageObject2, messageObject3, str3, arrayList, null, map, z, i, 0, str2, null);
        }
    }

    public static void prepareSendingDocument(AccountInstance accountInstance, String path, String originalPath, Uri uri, String caption, String mine, long dialogId, MessageObject replyToMsg, MessageObject replyToTopMsg, InputContentInfoCompat inputContent, MessageObject editingMessageObject, boolean notify, int scheduleDate) {
        if ((path == null || originalPath == null) && uri == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = null;
        if (uri != null) {
            arrayList3 = new ArrayList();
            arrayList3.add(uri);
        }
        if (path != null) {
            arrayList.add(path);
            arrayList2.add(originalPath);
        }
        prepareSendingDocuments(accountInstance, arrayList, arrayList2, arrayList3, caption, mine, dialogId, replyToMsg, replyToTopMsg, inputContent, editingMessageObject, notify, scheduleDate);
    }

    public static void prepareSendingAudioDocuments(final AccountInstance accountInstance, final ArrayList<MessageObject> messageObjects, final String caption, final long dialogId, final MessageObject replyToMsg, final MessageObject replyToTopMsg, final MessageObject editingMessageObject, final boolean notify, final int scheduleDate) {
        new Thread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$QaxzQgnhLCvitVzv9AYMNR8eQXY
            @Override // java.lang.Runnable
            public final void run() throws InterruptedException {
                SendMessagesHelper.lambda$prepareSendingAudioDocuments$75(messageObjects, dialogId, accountInstance, caption, editingMessageObject, replyToMsg, replyToTopMsg, notify, scheduleDate);
            }
        }).start();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ void lambda$prepareSendingAudioDocuments$75(java.util.ArrayList r22, final long r23, final ir.eitaa.messenger.AccountInstance r25, java.lang.String r26, final ir.eitaa.messenger.MessageObject r27, final ir.eitaa.messenger.MessageObject r28, final ir.eitaa.messenger.MessageObject r29, final boolean r30, final int r31) throws java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.SendMessagesHelper.lambda$prepareSendingAudioDocuments$75(java.util.ArrayList, long, ir.eitaa.messenger.AccountInstance, java.lang.String, ir.eitaa.messenger.MessageObject, ir.eitaa.messenger.MessageObject, ir.eitaa.messenger.MessageObject, boolean, int):void");
    }

    static /* synthetic */ void lambda$prepareSendingAudioDocuments$74(MessageObject messageObject, AccountInstance accountInstance, TLRPC$TL_document tLRPC$TL_document, MessageObject messageObject2, HashMap map, String str, long j, MessageObject messageObject3, MessageObject messageObject4, String str2, boolean z, int i) {
        if (messageObject != null) {
            accountInstance.getSendMessagesHelper().editMessage(messageObject, null, null, tLRPC$TL_document, messageObject2.messageOwner.attachPath, map, false, str);
        } else {
            accountInstance.getSendMessagesHelper().sendMessage(tLRPC$TL_document, null, messageObject2.messageOwner.attachPath, j, messageObject3, messageObject4, str2, null, null, map, z, i, 0, str, null);
        }
    }

    private static void finishGroup(final AccountInstance accountInstance, final long groupId, final int scheduleDate) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$0wG4Fr4VXu48hTK8Ej0E9-DRjqo
            @Override // java.lang.Runnable
            public final void run() {
                SendMessagesHelper.lambda$finishGroup$76(accountInstance, groupId, scheduleDate);
            }
        });
    }

    static /* synthetic */ void lambda$finishGroup$76(AccountInstance accountInstance, long j, int i) {
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
        accountInstance.getMessagesStorage().putMessages((TLRPC$messages_Messages) tLRPC$TL_messages_messages, delayedMessage.peer, -2, 0, false, i != 0);
        sendMessagesHelper.sendReadyToSendGroup(delayedMessage, true, true);
    }

    public static void prepareSendingDocuments(final AccountInstance accountInstance, final ArrayList<String> paths, final ArrayList<String> originalPaths, final ArrayList<Uri> uris, final String caption, final String mime, final long dialogId, final MessageObject replyToMsg, final MessageObject replyToTopMsg, final InputContentInfoCompat inputContent, final MessageObject editingMessageObject, final boolean notify, final int scheduleDate) {
        if (paths == null && originalPaths == null && uris == null) {
            return;
        }
        if (paths == null || originalPaths == null || paths.size() == originalPaths.size()) {
            new Thread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$UpqyNQ2RkpN8X4RWSHpxcXPptHE
                @Override // java.lang.Runnable
                public final void run() {
                    SendMessagesHelper.lambda$prepareSendingDocuments$78(dialogId, paths, caption, accountInstance, scheduleDate, originalPaths, mime, replyToMsg, replyToTopMsg, editingMessageObject, inputContent, notify, uris);
                }
            }).start();
        }
    }

    static /* synthetic */ void lambda$prepareSendingDocuments$78(long j, ArrayList arrayList, String str, AccountInstance accountInstance, int i, ArrayList arrayList2, String str2, MessageObject messageObject, MessageObject messageObject2, MessageObject messageObject3, InputContentInfoCompat inputContentInfoCompat, boolean z, ArrayList arrayList3) {
        Integer[] numArr;
        long[] jArr;
        ArrayList arrayList4;
        boolean z2;
        AccountInstance accountInstance2 = accountInstance;
        int i2 = i;
        int i3 = 1;
        long[] jArr2 = new long[1];
        Integer[] numArr2 = new Integer[1];
        boolean zIsEncryptedDialog = DialogObject.isEncryptedDialog(j);
        int i4 = 10;
        if (arrayList != null) {
            int size = arrayList.size();
            int i5 = 0;
            int i6 = 0;
            z2 = false;
            while (i6 < size) {
                String str3 = i6 == 0 ? str : null;
                if (!zIsEncryptedDialog && size > i3 && i5 % 10 == 0) {
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
                if (!prepareSendingDocumentInternal(accountInstance, (String) arrayList.get(i6), (String) arrayList2.get(i6), null, str2, j, messageObject, messageObject2, str3, null, messageObject3, jArr3, i7 == i4 || i6 == size + (-1), inputContentInfoCompat == null, z, i, numArr3)) {
                    z2 = true;
                }
                i5 = (j2 != jArr3[0] || jArr3[0] == -1) ? 1 : i7;
                i6 = i8 + 1;
                accountInstance2 = accountInstance;
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
                if (!zIsEncryptedDialog && size2 > 1 && i10 % 10 == 0) {
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
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$Dl4Kp3f1GudjKl-81Qcl_S9I05c
                @Override // java.lang.Runnable
                public final void run() {
                    SendMessagesHelper.lambda$prepareSendingDocuments$77();
                }
            });
        }
    }

    static /* synthetic */ void lambda$prepareSendingDocuments$77() {
        try {
            NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.showBulletin, 1, LocaleController.getString("UnsupportedAttachment", R.string.UnsupportedAttachment));
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public static void prepareSendingPhoto(AccountInstance accountInstance, String imageFilePath, Uri imageUri, long dialogId, MessageObject replyToMsg, MessageObject replyToTopMsg, CharSequence caption, ArrayList<TLRPC$MessageEntity> entities, ArrayList<TLRPC$InputDocument> stickers, InputContentInfoCompat inputContent, int ttl, MessageObject editingMessageObject, boolean notify, int scheduleDate) {
        prepareSendingPhoto(accountInstance, imageFilePath, null, imageUri, dialogId, replyToMsg, replyToTopMsg, caption, entities, stickers, inputContent, ttl, editingMessageObject, null, notify, scheduleDate, false);
    }

    public static void prepareSendingPhoto(AccountInstance accountInstance, String imageFilePath, String thumbFilePath, Uri imageUri, long dialogId, MessageObject replyToMsg, MessageObject replyToTopMsg, CharSequence caption, ArrayList<TLRPC$MessageEntity> entities, ArrayList<TLRPC$InputDocument> stickers, InputContentInfoCompat inputContent, int ttl, MessageObject editingMessageObject, VideoEditedInfo videoEditedInfo, boolean notify, int scheduleDate, boolean forceDocument) {
        SendingMediaInfo sendingMediaInfo = new SendingMediaInfo();
        sendingMediaInfo.path = imageFilePath;
        sendingMediaInfo.thumbPath = thumbFilePath;
        sendingMediaInfo.uri = imageUri;
        if (caption != null) {
            sendingMediaInfo.caption = caption.toString();
        }
        sendingMediaInfo.entities = entities;
        sendingMediaInfo.ttl = ttl;
        if (stickers != null) {
            sendingMediaInfo.masks = new ArrayList<>(stickers);
        }
        sendingMediaInfo.videoEditedInfo = videoEditedInfo;
        ArrayList arrayList = new ArrayList();
        arrayList.add(sendingMediaInfo);
        prepareSendingMedia(accountInstance, arrayList, dialogId, replyToMsg, replyToTopMsg, inputContent, forceDocument, false, editingMessageObject, notify, scheduleDate);
    }

    public static void prepareSendingBotContextResult(final AccountInstance accountInstance, final TLRPC$BotInlineResult result, final HashMap<String, String> params, final long dialogId, final MessageObject replyToMsg, final MessageObject replyToTopMsg, final boolean notify, final int scheduleDate) {
        if (result == null) {
            return;
        }
        TLRPC$BotInlineMessage tLRPC$BotInlineMessage = result.send_message;
        if (tLRPC$BotInlineMessage instanceof TLRPC$TL_botInlineMessageMediaAuto) {
            new Thread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$YSeHXfj6xlZsXEAk9OW7YG8xbaM
                @Override // java.lang.Runnable
                public final void run() {
                    SendMessagesHelper.lambda$prepareSendingBotContextResult$80(dialogId, result, accountInstance, params, replyToMsg, replyToTopMsg, notify, scheduleDate);
                }
            }).run();
            return;
        }
        if (tLRPC$BotInlineMessage instanceof TLRPC$TL_botInlineMessageText) {
            TLRPC$TL_webPagePending tLRPC$TL_webPagePending = null;
            if (DialogObject.isEncryptedDialog(dialogId)) {
                int i = 0;
                while (true) {
                    if (i >= result.send_message.entities.size()) {
                        break;
                    }
                    TLRPC$MessageEntity tLRPC$MessageEntity = result.send_message.entities.get(i);
                    if (tLRPC$MessageEntity instanceof TLRPC$TL_messageEntityUrl) {
                        tLRPC$TL_webPagePending = new TLRPC$TL_webPagePending();
                        String str = result.send_message.message;
                        int i2 = tLRPC$MessageEntity.offset;
                        tLRPC$TL_webPagePending.url = str.substring(i2, tLRPC$MessageEntity.length + i2);
                        break;
                    }
                    i++;
                }
            }
            TLRPC$TL_webPagePending tLRPC$TL_webPagePending2 = tLRPC$TL_webPagePending;
            SendMessagesHelper sendMessagesHelper = accountInstance.getSendMessagesHelper();
            TLRPC$BotInlineMessage tLRPC$BotInlineMessage2 = result.send_message;
            sendMessagesHelper.sendMessage(tLRPC$BotInlineMessage2.message, dialogId, replyToMsg, replyToTopMsg, tLRPC$TL_webPagePending2, !tLRPC$BotInlineMessage2.no_webpage, tLRPC$BotInlineMessage2.entities, tLRPC$BotInlineMessage2.reply_markup, params, notify, scheduleDate, null);
            return;
        }
        if (tLRPC$BotInlineMessage instanceof TLRPC$TL_botInlineMessageMediaVenue) {
            TLRPC$TL_messageMediaVenue tLRPC$TL_messageMediaVenue = new TLRPC$TL_messageMediaVenue();
            TLRPC$BotInlineMessage tLRPC$BotInlineMessage3 = result.send_message;
            tLRPC$TL_messageMediaVenue.geo = tLRPC$BotInlineMessage3.geo;
            tLRPC$TL_messageMediaVenue.address = tLRPC$BotInlineMessage3.address;
            tLRPC$TL_messageMediaVenue.title = tLRPC$BotInlineMessage3.title;
            tLRPC$TL_messageMediaVenue.provider = tLRPC$BotInlineMessage3.provider;
            tLRPC$TL_messageMediaVenue.venue_id = tLRPC$BotInlineMessage3.venue_id;
            String str2 = tLRPC$BotInlineMessage3.venue_type;
            tLRPC$TL_messageMediaVenue.venue_id = str2;
            tLRPC$TL_messageMediaVenue.venue_type = str2;
            if (str2 == null) {
                tLRPC$TL_messageMediaVenue.venue_type = "";
            }
            accountInstance.getSendMessagesHelper().sendMessage(tLRPC$TL_messageMediaVenue, dialogId, replyToMsg, replyToTopMsg, result.send_message.reply_markup, params, notify, scheduleDate);
            return;
        }
        if (tLRPC$BotInlineMessage instanceof TLRPC$TL_botInlineMessageMediaGeo) {
            if (tLRPC$BotInlineMessage.period != 0 || tLRPC$BotInlineMessage.proximity_notification_radius != 0) {
                TLRPC$TL_messageMediaGeoLive tLRPC$TL_messageMediaGeoLive = new TLRPC$TL_messageMediaGeoLive();
                TLRPC$BotInlineMessage tLRPC$BotInlineMessage4 = result.send_message;
                int i3 = tLRPC$BotInlineMessage4.period;
                if (i3 == 0) {
                    i3 = 900;
                }
                tLRPC$TL_messageMediaGeoLive.period = i3;
                tLRPC$TL_messageMediaGeoLive.geo = tLRPC$BotInlineMessage4.geo;
                tLRPC$TL_messageMediaGeoLive.heading = tLRPC$BotInlineMessage4.heading;
                tLRPC$TL_messageMediaGeoLive.proximity_notification_radius = tLRPC$BotInlineMessage4.proximity_notification_radius;
                accountInstance.getSendMessagesHelper().sendMessage(tLRPC$TL_messageMediaGeoLive, dialogId, replyToMsg, replyToTopMsg, result.send_message.reply_markup, params, notify, scheduleDate);
                return;
            }
            TLRPC$TL_messageMediaGeo tLRPC$TL_messageMediaGeo = new TLRPC$TL_messageMediaGeo();
            TLRPC$BotInlineMessage tLRPC$BotInlineMessage5 = result.send_message;
            tLRPC$TL_messageMediaGeo.geo = tLRPC$BotInlineMessage5.geo;
            tLRPC$TL_messageMediaGeo.heading = tLRPC$BotInlineMessage5.heading;
            accountInstance.getSendMessagesHelper().sendMessage(tLRPC$TL_messageMediaGeo, dialogId, replyToMsg, replyToTopMsg, result.send_message.reply_markup, params, notify, scheduleDate);
            return;
        }
        if (tLRPC$BotInlineMessage instanceof TLRPC$TL_botInlineMessageMediaContact) {
            TLRPC$TL_user tLRPC$TL_user = new TLRPC$TL_user();
            TLRPC$BotInlineMessage tLRPC$BotInlineMessage6 = result.send_message;
            tLRPC$TL_user.phone = tLRPC$BotInlineMessage6.phone_number;
            tLRPC$TL_user.first_name = tLRPC$BotInlineMessage6.first_name;
            tLRPC$TL_user.last_name = tLRPC$BotInlineMessage6.last_name;
            TLRPC$TL_restrictionReason tLRPC$TL_restrictionReason = new TLRPC$TL_restrictionReason();
            tLRPC$TL_restrictionReason.text = result.send_message.vcard;
            tLRPC$TL_restrictionReason.platform = "";
            tLRPC$TL_restrictionReason.reason = "";
            tLRPC$TL_user.restriction_reason.add(tLRPC$TL_restrictionReason);
            accountInstance.getSendMessagesHelper().sendMessage(tLRPC$TL_user, dialogId, replyToMsg, replyToTopMsg, result.send_message.reply_markup, params, notify, scheduleDate);
            return;
        }
        if (!(tLRPC$BotInlineMessage instanceof TLRPC$TL_botInlineMessageMediaInvoice) || DialogObject.isEncryptedDialog(dialogId)) {
            return;
        }
        TLRPC$TL_botInlineMessageMediaInvoice tLRPC$TL_botInlineMessageMediaInvoice = (TLRPC$TL_botInlineMessageMediaInvoice) result.send_message;
        TLRPC$TL_messageMediaInvoice tLRPC$TL_messageMediaInvoice = new TLRPC$TL_messageMediaInvoice();
        tLRPC$TL_messageMediaInvoice.shipping_address_requested = tLRPC$TL_botInlineMessageMediaInvoice.shipping_address_requested;
        tLRPC$TL_messageMediaInvoice.test = tLRPC$TL_botInlineMessageMediaInvoice.test;
        tLRPC$TL_messageMediaInvoice.title = tLRPC$TL_botInlineMessageMediaInvoice.title;
        tLRPC$TL_messageMediaInvoice.description = tLRPC$TL_botInlineMessageMediaInvoice.description;
        TLRPC$WebDocument tLRPC$WebDocument = tLRPC$TL_botInlineMessageMediaInvoice.photo;
        if (tLRPC$WebDocument != null) {
            tLRPC$TL_messageMediaInvoice.photo = tLRPC$WebDocument;
            tLRPC$TL_messageMediaInvoice.flags |= 1;
        }
        tLRPC$TL_messageMediaInvoice.currency = tLRPC$TL_botInlineMessageMediaInvoice.currency;
        tLRPC$TL_messageMediaInvoice.total_amount = tLRPC$TL_botInlineMessageMediaInvoice.total_amount;
        tLRPC$TL_messageMediaInvoice.start_param = "";
        accountInstance.getSendMessagesHelper().sendMessage(tLRPC$TL_messageMediaInvoice, dialogId, replyToMsg, replyToTopMsg, result.send_message.reply_markup, params, notify, scheduleDate);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ void lambda$prepareSendingBotContextResult$80(final long r21, final ir.eitaa.tgnet.TLRPC$BotInlineResult r23, final ir.eitaa.messenger.AccountInstance r24, final java.util.HashMap r25, final ir.eitaa.messenger.MessageObject r26, final ir.eitaa.messenger.MessageObject r27, final boolean r28, final int r29) {
        /*
            Method dump skipped, instructions count: 1344
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.SendMessagesHelper.lambda$prepareSendingBotContextResult$80(long, ir.eitaa.tgnet.TLRPC$BotInlineResult, ir.eitaa.messenger.AccountInstance, java.util.HashMap, ir.eitaa.messenger.MessageObject, ir.eitaa.messenger.MessageObject, boolean, int):void");
    }

    static /* synthetic */ void lambda$prepareSendingBotContextResult$79(TLRPC$TL_document tLRPC$TL_document, Bitmap[] bitmapArr, String[] strArr, AccountInstance accountInstance, String str, long j, MessageObject messageObject, MessageObject messageObject2, TLRPC$BotInlineResult tLRPC$BotInlineResult, HashMap map, boolean z, int i, TLRPC$TL_photo tLRPC$TL_photo, TLRPC$TL_game tLRPC$TL_game) {
        if (tLRPC$TL_document != null) {
            if (bitmapArr[0] != null && strArr[0] != null) {
                ImageLoader.getInstance().putImageToCache(new BitmapDrawable(bitmapArr[0]), strArr[0]);
            }
            SendMessagesHelper sendMessagesHelper = accountInstance.getSendMessagesHelper();
            TLRPC$BotInlineMessage tLRPC$BotInlineMessage = tLRPC$BotInlineResult.send_message;
            sendMessagesHelper.sendMessage(tLRPC$TL_document, null, str, j, messageObject, messageObject2, tLRPC$BotInlineMessage.message, tLRPC$BotInlineMessage.entities, tLRPC$BotInlineMessage.reply_markup, map, z, i, 0, tLRPC$BotInlineResult, null);
            return;
        }
        if (tLRPC$TL_photo == null) {
            if (tLRPC$TL_game != null) {
                accountInstance.getSendMessagesHelper().sendMessage(tLRPC$TL_game, j, tLRPC$BotInlineResult.send_message.reply_markup, (HashMap<String, String>) map, z, i);
            }
        } else {
            SendMessagesHelper sendMessagesHelper2 = accountInstance.getSendMessagesHelper();
            TLRPC$WebDocument tLRPC$WebDocument = tLRPC$BotInlineResult.content;
            String str2 = tLRPC$WebDocument != null ? tLRPC$WebDocument.url : null;
            TLRPC$BotInlineMessage tLRPC$BotInlineMessage2 = tLRPC$BotInlineResult.send_message;
            sendMessagesHelper2.sendMessage(tLRPC$TL_photo, str2, j, messageObject, messageObject2, tLRPC$BotInlineMessage2.message, tLRPC$BotInlineMessage2.entities, tLRPC$BotInlineMessage2.reply_markup, map, z, i, 0, tLRPC$BotInlineResult);
        }
    }

    private static String getTrimmedString(String src) {
        String strTrim = src.trim();
        if (strTrim.length() == 0) {
            return strTrim;
        }
        while (src.startsWith("\n")) {
            src = src.substring(1);
        }
        while (src.endsWith("\n")) {
            src = src.substring(0, src.length() - 1);
        }
        return src;
    }

    public static void prepareSendingText(final AccountInstance accountInstance, final String text, final long dialogId, final boolean notify, final int scheduleDate) {
        accountInstance.getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$eyOWFMdCooKUcrwPXy_rgXQd-hg
            @Override // java.lang.Runnable
            public final void run() {
                Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$S2FxWAMz8T9af-5L5EJNlVSSPCQ
                    @Override // java.lang.Runnable
                    public final void run() {
                        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$YWylZnZBQjYJpH7o8b7uC_HCIT0
                            @Override // java.lang.Runnable
                            public final void run() {
                                SendMessagesHelper.lambda$prepareSendingText$81(str, accountInstance, j, z, i);
                            }
                        });
                    }
                });
            }
        });
    }

    static /* synthetic */ void lambda$prepareSendingText$81(String str, AccountInstance accountInstance, long j, boolean z, int i) {
        String trimmedString = getTrimmedString(str);
        if (trimmedString.length() != 0) {
            int iCeil = (int) Math.ceil(trimmedString.length() / 4096.0f);
            int i2 = 0;
            while (i2 < iCeil) {
                int i3 = i2 * Factory.DEVICE_HAS_CRAPPY_AAUDIO;
                i2++;
                accountInstance.getSendMessagesHelper().sendMessage(trimmedString.substring(i3, Math.min(i2 * Factory.DEVICE_HAS_CRAPPY_AAUDIO, trimmedString.length())), j, null, null, null, true, null, null, null, z, i, null);
            }
        }
    }

    public static void ensureMediaThumbExists(boolean isEncrypted, TLObject object, String path, Uri uri, long startTime) {
        TLRPC$PhotoSize tLRPC$PhotoSizeScaleAndSaveImage;
        TLRPC$PhotoSize tLRPC$PhotoSizeScaleAndSaveImage2;
        if (object instanceof TLRPC$TL_photo) {
            TLRPC$TL_photo tLRPC$TL_photo = (TLRPC$TL_photo) object;
            TLRPC$PhotoSize closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(tLRPC$TL_photo.sizes, 90);
            boolean zExists = ((closestPhotoSizeWithSize instanceof TLRPC$TL_photoStrippedSize) || (closestPhotoSizeWithSize instanceof TLRPC$TL_photoPathSize)) ? true : FileLoader.getPathToAttach(closestPhotoSizeWithSize, true).exists();
            TLRPC$PhotoSize closestPhotoSizeWithSize2 = FileLoader.getClosestPhotoSizeWithSize(tLRPC$TL_photo.sizes, AndroidUtilities.getPhotoSize());
            boolean zExists2 = FileLoader.getPathToAttach(closestPhotoSizeWithSize2, false).exists();
            if (zExists && zExists2) {
                return;
            }
            Bitmap bitmapLoadBitmap = ImageLoader.loadBitmap(path, uri, AndroidUtilities.getPhotoSize(), AndroidUtilities.getPhotoSize(), true);
            if (bitmapLoadBitmap == null) {
                bitmapLoadBitmap = ImageLoader.loadBitmap(path, uri, 800.0f, 800.0f, true);
            }
            Bitmap bitmap = bitmapLoadBitmap;
            if (!zExists2 && (tLRPC$PhotoSizeScaleAndSaveImage2 = ImageLoader.scaleAndSaveImage(closestPhotoSizeWithSize2, bitmap, Bitmap.CompressFormat.JPEG, true, AndroidUtilities.getPhotoSize(), AndroidUtilities.getPhotoSize(), 80, false, R.styleable.AppCompatTheme_textAppearanceSearchResultSubtitle, R.styleable.AppCompatTheme_textAppearanceSearchResultSubtitle, false)) != closestPhotoSizeWithSize2) {
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
        if (object instanceof TLRPC$TL_document) {
            TLRPC$TL_document tLRPC$TL_document = (TLRPC$TL_document) object;
            if ((MessageObject.isVideoDocument(tLRPC$TL_document) || MessageObject.isNewGifDocument(tLRPC$TL_document)) && MessageObject.isDocumentHasThumb(tLRPC$TL_document)) {
                TLRPC$PhotoSize closestPhotoSizeWithSize3 = FileLoader.getClosestPhotoSizeWithSize(tLRPC$TL_document.thumbs, 320);
                if ((closestPhotoSizeWithSize3 instanceof TLRPC$TL_photoStrippedSize) || (closestPhotoSizeWithSize3 instanceof TLRPC$TL_photoPathSize) || FileLoader.getPathToAttach(closestPhotoSizeWithSize3, true).exists()) {
                    return;
                }
                Bitmap bitmapCreateVideoThumbnailAtTime = createVideoThumbnailAtTime(path, startTime);
                Bitmap bitmapCreateVideoThumbnail = bitmapCreateVideoThumbnailAtTime == null ? createVideoThumbnail(path, 1) : bitmapCreateVideoThumbnailAtTime;
                int i = isEncrypted ? 90 : 320;
                float f = i;
                tLRPC$TL_document.thumbs.set(0, ImageLoader.scaleAndSaveImage(closestPhotoSizeWithSize3, bitmapCreateVideoThumbnail, f, f, i > 90 ? 80 : 55, false, true));
            }
        }
    }

    public static String getKeyForPhotoSize(TLRPC$PhotoSize photoSize, Bitmap[] bitmap, boolean blur, boolean forceCache) {
        if (photoSize == null || photoSize.location == null) {
            return null;
        }
        Point messageSize = ChatMessageCell.getMessageSize(photoSize.w, photoSize.h);
        if (bitmap != null) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                File pathToAttach = FileLoader.getPathToAttach(photoSize, forceCache);
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
                    bitmap[0] = BitmapFactory.decodeStream(fileInputStream2, null, options);
                    fileInputStream2.close();
                }
            } catch (Throwable unused) {
            }
        }
        return String.format(Locale.US, blur ? "%d_%d@%d_%d_b" : "%d_%d@%d_%d", Long.valueOf(photoSize.location.volume_id), Integer.valueOf(photoSize.location.local_id), Integer.valueOf((int) (messageSize.x / AndroidUtilities.density)), Integer.valueOf((int) (messageSize.y / AndroidUtilities.density)));
    }

    public static boolean shouldSendWebPAsSticker(String path, Uri uri) throws IOException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        if (path != null) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(path, "r");
                MappedByteBuffer map = randomAccessFile.getChannel().map(FileChannel.MapMode.READ_ONLY, 0L, path.length());
                Utilities.loadWebpImage(null, map, map.limit(), options, true);
                randomAccessFile.close();
            } catch (Exception e) {
                FileLog.e(e);
            }
        } else {
            try {
                InputStream inputStreamOpenInputStream = ApplicationLoader.applicationContext.getContentResolver().openInputStream(uri);
                try {
                    BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
                    if (inputStreamOpenInputStream != null) {
                        inputStreamOpenInputStream.close();
                    }
                } catch (Throwable th) {
                    if (inputStreamOpenInputStream != null) {
                        try {
                            inputStreamOpenInputStream.close();
                        } catch (Throwable unused) {
                        }
                    }
                    throw th;
                }
            } catch (Exception unused2) {
            }
        }
        return options.outWidth < 800 && options.outHeight < 800;
    }

    public static void prepareSendingMedia(final AccountInstance accountInstance, final ArrayList<SendingMediaInfo> media, final long dialogId, final MessageObject replyToMsg, final MessageObject replyToTopMsg, final InputContentInfoCompat inputContent, final boolean forceDocument, boolean groupMedia, final MessageObject editingMessageObject, final boolean notify, final int scheduleDate) {
        final boolean z;
        if (media.isEmpty()) {
            return;
        }
        int size = media.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                z = groupMedia;
                break;
            } else {
                if (media.get(i).ttl > 0) {
                    z = false;
                    break;
                }
                i++;
            }
        }
        mediaSendQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$uoi5iXRCYLgra6R0p_eKb8Ch_Ak
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                SendMessagesHelper.lambda$prepareSendingMedia$89(media, dialogId, forceDocument, z, accountInstance, editingMessageObject, replyToMsg, replyToTopMsg, notify, scheduleDate, inputContent);
            }
        });
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:358|(1:363)(1:362)|364|(4:366|(2:369|367)|648|370)(1:371)|(1:373)|(1:375)|(6:615|377|378|(0)|(3:391|(2:393|(0)(1:396))(1:397)|398)(1:399)|400)(1:383)|611|384|(1:386)|(0)(0)|400) */
    /* JADX WARN: Code restructure failed: missing block: B:388:0x08d0, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02c8 A[Catch: Exception -> 0x02b9, TryCatch #11 {Exception -> 0x02b9, blocks: (B:125:0x02b1, B:132:0x02be, B:134:0x02c8, B:135:0x02d3), top: B:633:0x02b1 }] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02d3 A[Catch: Exception -> 0x02b9, TRY_LEAVE, TryCatch #11 {Exception -> 0x02b9, blocks: (B:125:0x02b1, B:132:0x02be, B:134:0x02c8, B:135:0x02d3), top: B:633:0x02b1 }] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0358  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x042c  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0649  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x06ae  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x06b2  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x06bc  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x06c2  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x070f  */
    /* JADX WARN: Removed duplicated region for block: B:391:0x08d6  */
    /* JADX WARN: Removed duplicated region for block: B:399:0x0904  */
    /* JADX WARN: Removed duplicated region for block: B:465:0x0b07  */
    /* JADX WARN: Removed duplicated region for block: B:468:0x0b15  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:525:0x0c0e  */
    /* JADX WARN: Removed duplicated region for block: B:527:0x0c19  */
    /* JADX WARN: Removed duplicated region for block: B:531:0x0c26  */
    /* JADX WARN: Removed duplicated region for block: B:537:0x0c38  */
    /* JADX WARN: Removed duplicated region for block: B:539:0x0c44  */
    /* JADX WARN: Removed duplicated region for block: B:546:0x0c81  */
    /* JADX WARN: Removed duplicated region for block: B:548:0x0c86  */
    /* JADX WARN: Removed duplicated region for block: B:550:0x0c8d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:559:0x0cc3  */
    /* JADX WARN: Removed duplicated region for block: B:568:0x0d00 A[LOOP:4: B:566:0x0cf8->B:568:0x0d00, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:603:0x0e50  */
    /* JADX WARN: Removed duplicated region for block: B:613:0x0629 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:619:0x0611 A[EXC_TOP_SPLITTER, PHI: r7 r11
      0x0611: PHI (r7v38 java.io.FileOutputStream) = 
      (r7v37 java.io.FileOutputStream)
      (r7v40 java.io.FileOutputStream)
      (r7v40 java.io.FileOutputStream)
      (r7v40 java.io.FileOutputStream)
     binds: [B:251:0x062e, B:232:0x060c, B:609:0x0611, B:233:0x060e] A[DONT_GENERATE, DONT_INLINE]
      0x0611: PHI (r11v38 java.lang.String) = (r11v37 java.lang.String), (r11v42 java.lang.String), (r11v42 java.lang.String), (r11v42 java.lang.String) binds: [B:251:0x062e, B:232:0x060c, B:609:0x0611, B:233:0x060e] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:627:0x02e0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:649:0x0c35 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0151  */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v29, types: [android.net.Uri, java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v30 */
    /* JADX WARN: Type inference failed for: r11v25 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9, types: [boolean, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ void lambda$prepareSendingMedia$89(java.util.ArrayList r65, final long r66, boolean r68, boolean r69, final ir.eitaa.messenger.AccountInstance r70, final ir.eitaa.messenger.MessageObject r71, final ir.eitaa.messenger.MessageObject r72, final ir.eitaa.messenger.MessageObject r73, final boolean r74, final int r75, androidx.core.view.inputmethod.InputContentInfoCompat r76) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 3782
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.SendMessagesHelper.lambda$prepareSendingMedia$89(java.util.ArrayList, long, boolean, boolean, ir.eitaa.messenger.AccountInstance, ir.eitaa.messenger.MessageObject, ir.eitaa.messenger.MessageObject, ir.eitaa.messenger.MessageObject, boolean, int, androidx.core.view.inputmethod.InputContentInfoCompat):void");
    }

    static /* synthetic */ void lambda$prepareSendingMedia$84(MediaSendPrepareWorker mediaSendPrepareWorker, AccountInstance accountInstance, SendingMediaInfo sendingMediaInfo, boolean z) {
        mediaSendPrepareWorker.photo = accountInstance.getSendMessagesHelper().generatePhotoSizes(sendingMediaInfo.path, sendingMediaInfo.uri);
        if (z && sendingMediaInfo.canDeleteAfter) {
            new File(sendingMediaInfo.path).delete();
        }
        mediaSendPrepareWorker.sync.countDown();
    }

    static /* synthetic */ void lambda$prepareSendingMedia$85(MessageObject messageObject, AccountInstance accountInstance, TLRPC$TL_document tLRPC$TL_document, String str, HashMap map, String str2, long j, MessageObject messageObject2, MessageObject messageObject3, SendingMediaInfo sendingMediaInfo, boolean z, int i) {
        if (messageObject != null) {
            accountInstance.getSendMessagesHelper().editMessage(messageObject, null, null, tLRPC$TL_document, str, map, false, str2);
        } else {
            accountInstance.getSendMessagesHelper().sendMessage(tLRPC$TL_document, null, str, j, messageObject2, messageObject3, sendingMediaInfo.caption, sendingMediaInfo.entities, null, map, z, i, 0, str2, null);
        }
    }

    static /* synthetic */ void lambda$prepareSendingMedia$86(MessageObject messageObject, AccountInstance accountInstance, TLRPC$TL_photo tLRPC$TL_photo, boolean z, SendingMediaInfo sendingMediaInfo, HashMap map, String str, long j, MessageObject messageObject2, MessageObject messageObject3, boolean z2, int i) {
        if (messageObject != null) {
            accountInstance.getSendMessagesHelper().editMessage(messageObject, tLRPC$TL_photo, null, null, z ? sendingMediaInfo.searchImage.imageUrl : null, map, false, str);
        } else {
            accountInstance.getSendMessagesHelper().sendMessage(tLRPC$TL_photo, z ? sendingMediaInfo.searchImage.imageUrl : null, j, messageObject2, messageObject3, sendingMediaInfo.caption, sendingMediaInfo.entities, null, map, z2, i, sendingMediaInfo.ttl, str);
        }
    }

    static /* synthetic */ void lambda$prepareSendingMedia$87(Bitmap bitmap, String str, MessageObject messageObject, AccountInstance accountInstance, VideoEditedInfo videoEditedInfo, TLRPC$TL_document tLRPC$TL_document, String str2, HashMap map, String str3, long j, MessageObject messageObject2, MessageObject messageObject3, SendingMediaInfo sendingMediaInfo, boolean z, int i) {
        if (bitmap != null && str != null) {
            ImageLoader.getInstance().putImageToCache(new BitmapDrawable(bitmap), str);
        }
        if (messageObject != null) {
            accountInstance.getSendMessagesHelper().editMessage(messageObject, null, videoEditedInfo, tLRPC$TL_document, str2, map, false, str3);
        } else {
            accountInstance.getSendMessagesHelper().sendMessage(tLRPC$TL_document, videoEditedInfo, str2, j, messageObject2, messageObject3, sendingMediaInfo.caption, sendingMediaInfo.entities, null, map, z, i, sendingMediaInfo.ttl, str3, null);
        }
    }

    static /* synthetic */ void lambda$prepareSendingMedia$88(Bitmap[] bitmapArr, String[] strArr, MessageObject messageObject, AccountInstance accountInstance, TLRPC$TL_photo tLRPC$TL_photo, HashMap map, String str, long j, MessageObject messageObject2, MessageObject messageObject3, SendingMediaInfo sendingMediaInfo, boolean z, int i) {
        if (bitmapArr[0] != null && strArr[0] != null) {
            ImageLoader.getInstance().putImageToCache(new BitmapDrawable(bitmapArr[0]), strArr[0]);
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
    private static void fillVideoAttribute(java.lang.String r5, ir.eitaa.tgnet.TLRPC$TL_documentAttributeVideo r6, ir.eitaa.messenger.VideoEditedInfo r7) throws java.lang.Throwable {
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
            java.lang.Integer r1 = ir.eitaa.messenger.Utilities.parseInt(r1)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L75
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
            ir.eitaa.messenger.FileLog.e(r1)
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
            ir.eitaa.messenger.FileLog.e(r7)     // Catch: java.lang.Throwable -> L78
            if (r1 == 0) goto L88
            r1.release()     // Catch: java.lang.Exception -> L84
            goto L88
        L84:
            r7 = move-exception
            ir.eitaa.messenger.FileLog.e(r7)
        L88:
            r7 = 0
        L89:
            if (r7 != 0) goto Lbe
            android.content.Context r7 = ir.eitaa.messenger.ApplicationLoader.applicationContext     // Catch: java.lang.Exception -> Lba
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
            ir.eitaa.messenger.FileLog.e(r5)
        Lbe:
            return
        Lbf:
            if (r1 == 0) goto Lc9
            r1.release()     // Catch: java.lang.Exception -> Lc5
            goto Lc9
        Lc5:
            r6 = move-exception
            ir.eitaa.messenger.FileLog.e(r6)
        Lc9:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.SendMessagesHelper.fillVideoAttribute(java.lang.String, ir.eitaa.tgnet.TLRPC$TL_documentAttributeVideo, ir.eitaa.messenger.VideoEditedInfo):void");
    }

    public static Bitmap createVideoThumbnail(String filePath, int kind) {
        float f = kind == 2 ? 1920.0f : kind == 3 ? 96.0f : 512.0f;
        Bitmap bitmapCreateVideoThumbnailAtTime = createVideoThumbnailAtTime(filePath, 0L);
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

    public static Bitmap createVideoThumbnailAtTime(String filePath, long time) {
        return createVideoThumbnailAtTime(filePath, time, null, false);
    }

    public static Bitmap createVideoThumbnailAtTime(String filePath, long time, int[] orientation, boolean precise) {
        Bitmap frameAtTime;
        if (precise) {
            AnimatedFileDrawable animatedFileDrawable = new AnimatedFileDrawable(new File(filePath), true, 0L, null, null, null, 0L, 0, true);
            frameAtTime = animatedFileDrawable.getFrameAtTime(time, precise);
            if (orientation != null) {
                orientation[0] = animatedFileDrawable.getOrientation();
            }
            animatedFileDrawable.recycle();
            if (frameAtTime == null) {
                return createVideoThumbnailAtTime(filePath, time, orientation, false);
            }
        } else {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            frameAtTime = null;
            try {
                try {
                    mediaMetadataRetriever.setDataSource(filePath);
                    Bitmap frameAtTime2 = mediaMetadataRetriever.getFrameAtTime(time, 1);
                    if (frameAtTime2 == null) {
                        try {
                            frameAtTime2 = mediaMetadataRetriever.getFrameAtTime(time, 3);
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

    private static VideoEditedInfo createCompressionSettings(String videoPath) {
        MediaCodecInfo mediaCodecInfoSelectCodec;
        boolean z;
        int[] iArr = new int[11];
        AnimatedFileDrawable.getVideoInfo(videoPath, iArr);
        if (iArr[0] == 0) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("video hasn't avc1 atom");
            }
            return null;
        }
        int videoBitrate = MediaController.getVideoBitrate(videoPath);
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
        videoEditedInfo.originalPath = videoPath;
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
        int i4 = fMax <= 1280.0f ? fMax > 854.0f ? 3 : fMax > 640.0f ? 2 : 1 : 4;
        int iRound = Math.round(DownloadController.getInstance(UserConfig.selectedAccount).getMaxVideoBitrate() / (100.0f / i4));
        if (iRound > i4) {
            iRound = i4;
        }
        if (iRound != i4 - 1 || Math.max(videoEditedInfo.originalWidth, videoEditedInfo.originalHeight) > 1280) {
            float f2 = iRound != 1 ? iRound != 2 ? iRound != 3 ? 1280.0f : 848.0f : 640.0f : 432.0f;
            int i5 = videoEditedInfo.originalWidth;
            int i6 = videoEditedInfo.originalHeight;
            float f3 = f2 / (i5 > i6 ? i5 : i6);
            videoEditedInfo.resultWidth = Math.round((i5 * f3) / 2.0f) * 2;
            videoEditedInfo.resultHeight = Math.round((videoEditedInfo.originalHeight * f3) / 2.0f) * 2;
            z = true;
        } else {
            z = false;
        }
        int iMakeVideoBitrate = MediaController.makeVideoBitrate(videoEditedInfo.originalHeight, videoEditedInfo.originalWidth, videoBitrate, videoEditedInfo.resultHeight, videoEditedInfo.resultWidth);
        if (!z) {
            videoEditedInfo.resultWidth = videoEditedInfo.originalWidth;
            videoEditedInfo.resultHeight = videoEditedInfo.originalHeight;
            videoEditedInfo.bitrate = iMakeVideoBitrate;
            videoEditedInfo.estimatedSize = (int) (j2 + (((f / 1000.0f) * iMakeVideoBitrate) / 8.0f));
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

    public static void prepareSendingVideo(final AccountInstance accountInstance, final String videoPath, final VideoEditedInfo info, final long dialogId, final MessageObject replyToMsg, final MessageObject replyToTopMsg, final CharSequence caption, final ArrayList<TLRPC$MessageEntity> entities, final int ttl, final MessageObject editingMessageObject, final boolean notify, final int scheduleDate, final boolean forceDocument) {
        if (videoPath == null || videoPath.length() == 0) {
            return;
        }
        new Thread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$SendMessagesHelper$1HL4nswM81duGbQFLv4K3HZSHnA
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                SendMessagesHelper.lambda$prepareSendingVideo$91(info, videoPath, dialogId, ttl, accountInstance, caption, editingMessageObject, replyToMsg, replyToTopMsg, entities, notify, scheduleDate, forceDocument);
            }
        }).start();
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x026d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ void lambda$prepareSendingVideo$91(ir.eitaa.messenger.VideoEditedInfo r26, java.lang.String r27, final long r28, final int r30, final ir.eitaa.messenger.AccountInstance r31, java.lang.CharSequence r32, final ir.eitaa.messenger.MessageObject r33, final ir.eitaa.messenger.MessageObject r34, final ir.eitaa.messenger.MessageObject r35, final java.util.ArrayList r36, final boolean r37, final int r38, boolean r39) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 887
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.SendMessagesHelper.lambda$prepareSendingVideo$91(ir.eitaa.messenger.VideoEditedInfo, java.lang.String, long, int, ir.eitaa.messenger.AccountInstance, java.lang.CharSequence, ir.eitaa.messenger.MessageObject, ir.eitaa.messenger.MessageObject, ir.eitaa.messenger.MessageObject, java.util.ArrayList, boolean, int, boolean):void");
    }

    static /* synthetic */ void lambda$prepareSendingVideo$90(Bitmap bitmap, String str, MessageObject messageObject, AccountInstance accountInstance, VideoEditedInfo videoEditedInfo, TLRPC$TL_document tLRPC$TL_document, String str2, HashMap map, String str3, long j, MessageObject messageObject2, MessageObject messageObject3, String str4, ArrayList arrayList, boolean z, int i, int i2) {
        if (bitmap != null && str != null) {
            ImageLoader.getInstance().putImageToCache(new BitmapDrawable(bitmap), str);
        }
        if (messageObject != null) {
            accountInstance.getSendMessagesHelper().editMessage(messageObject, null, videoEditedInfo, tLRPC$TL_document, str2, map, false, str3);
        } else {
            accountInstance.getSendMessagesHelper().sendMessage(tLRPC$TL_document, videoEditedInfo, str2, j, messageObject2, messageObject3, str4, arrayList, null, map, z, i, i2, str3, null);
        }
    }
}
