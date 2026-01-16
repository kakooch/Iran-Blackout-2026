package androidMessenger.proxy;

import android.content.Intent;
import android.text.TextUtils;
import android.util.SparseArray;
import androidMessenger.model.CustomParameters;
import androidMessenger.model.ExtraInfo;
import androidMessenger.model.MessangerOutput;
import androidMessenger.model.PushNotificationObject;
import androidMessenger.utilites.ChatConverter;
import androidMessenger.utilites.MessageConverter;
import androidMessenger.utilites.MessengerLinkHandler;
import androidMessenger.utilites.MyLog;
import androidx.collection.LongSparseArray;
import com.google.android.exoplayer2t.util.Log;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.gson.Gson;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import ir.aaap.messengercore.CoreMainClass;
import ir.aaap.messengercore.LoadListener;
import ir.aaap.messengercore.model.AuxDataObject;
import ir.aaap.messengercore.model.Chat;
import ir.aaap.messengercore.model.ChatAbsObject;
import ir.aaap.messengercore.model.ChatType;
import ir.aaap.messengercore.model.FileInlineObject;
import ir.aaap.messengercore.model.ForwardMessageResult;
import ir.aaap.messengercore.model.GetGroupMessageReadParticipantsResult;
import ir.aaap.messengercore.model.LiveLocationInfo;
import ir.aaap.messengercore.model.LiveLocationObject;
import ir.aaap.messengercore.model.LiveModels;
import ir.aaap.messengercore.model.LoadMessagesIntervalResult;
import ir.aaap.messengercore.model.LoadMessagesResult;
import ir.aaap.messengercore.model.LocationObject;
import ir.aaap.messengercore.model.Message;
import ir.aaap.messengercore.model.MessageReactionObject;
import ir.aaap.messengercore.model.MessageUpdateResult;
import ir.aaap.messengercore.model.NotificationModels;
import ir.aaap.messengercore.model.PinMessageResult;
import ir.aaap.messengercore.model.PollModels;
import ir.aaap.messengercore.model.PollObject;
import ir.aaap.messengercore.model.SearchChatMessagesResult;
import ir.aaap.messengercore.model.StickerObject;
import ir.aaap.messengercore.model.StickerSetObject;
import ir.aaap.messengercore.model.UserInfo;
import ir.aaap.messengercore.model.VoiceCallModels;
import ir.aaap.messengercore.model.api.ActionOnStickersOutput;
import ir.aaap.messengercore.model.api.BotModels;
import ir.aaap.messengercore.model.api.DeleteMessagesInput;
import ir.aaap.messengercore.model.api.GetGroupMessageReadParticipantsOutput;
import ir.aaap.messengercore.model.api.GetMessageShareUrlOutput;
import ir.aaap.messengercore.model.api.GetStickersByEmojiOutput;
import ir.aaap.messengercore.model.api.GetStickersOutput;
import ir.aaap.messengercore.model.api.SetPinMessageOutput;
import ir.aaap.messengercore.network.ApiServerException;
import ir.appp.rghapp.Utils;
import ir.medu.shad.R;
import ir.resaneh1.iptv.fragment.rubino.RubinoController;
import ir.resaneh1.iptv.helper.StoryController;
import ir.resaneh1.iptv.model.GetProfilesStoryListOutput;
import ir.resaneh1.iptv.model.Link;
import ir.resaneh1.iptv.model.Rubino;
import ir.resaneh1.iptv.model.RubinoPostData;
import ir.resaneh1.iptv.model.RubinoPostObject;
import ir.resaneh1.iptv.model.RubinoProfileObject;
import ir.resaneh1.iptv.model.RubinoStoryData;
import ir.resaneh1.iptv.model.StoryObject;
import ir.resaneh1.iptv.model.StoryProfileStoryId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.BaseController;
import org.rbmain.messenger.ChatObject;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.LocationController;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.NotificationBadge;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.NotificationsController;
import org.rbmain.messenger.UserConfig;
import org.rbmain.messenger.Utilities;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$Document;
import org.rbmain.tgnet.TLRPC$GeoPoint;
import org.rbmain.tgnet.TLRPC$InputGeoPoint;
import org.rbmain.tgnet.TLRPC$InputPeer;
import org.rbmain.tgnet.TLRPC$InputStickerSet;
import org.rbmain.tgnet.TLRPC$Message;
import org.rbmain.tgnet.TLRPC$MessageMedia;
import org.rbmain.tgnet.TLRPC$Poll;
import org.rbmain.tgnet.TLRPC$PollResults;
import org.rbmain.tgnet.TLRPC$TL_GetLiveCommentResult;
import org.rbmain.tgnet.TLRPC$TL_LiveComment;
import org.rbmain.tgnet.TLRPC$TL_channels_exportMessageLink;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_exportedMessageLink;
import org.rbmain.tgnet.TLRPC$TL_inputMediaGeoLive;
import org.rbmain.tgnet.TLRPC$TL_inputMediaPoll;
import org.rbmain.tgnet.TLRPC$TL_inputMessagesFilterPhoneCalls;
import org.rbmain.tgnet.TLRPC$TL_inputPeerChannel;
import org.rbmain.tgnet.TLRPC$TL_inputPeerChat;
import org.rbmain.tgnet.TLRPC$TL_inputPeerUser;
import org.rbmain.tgnet.TLRPC$TL_messageMediaGeoLive;
import org.rbmain.tgnet.TLRPC$TL_messageMediaPoll;
import org.rbmain.tgnet.TLRPC$TL_messageMediaRubinoPost;
import org.rbmain.tgnet.TLRPC$TL_messageMediaRubinoStory;
import org.rbmain.tgnet.TLRPC$TL_messageReactions;
import org.rbmain.tgnet.TLRPC$TL_messageUserVote;
import org.rbmain.tgnet.TLRPC$TL_messages_editMessage;
import org.rbmain.tgnet.TLRPC$TL_messages_favedStickers;
import org.rbmain.tgnet.TLRPC$TL_messages_getArchivedStickers;
import org.rbmain.tgnet.TLRPC$TL_messages_getBotCallbackAnswer;
import org.rbmain.tgnet.TLRPC$TL_messages_getFavedStickers;
import org.rbmain.tgnet.TLRPC$TL_messages_getFeaturedStickers;
import org.rbmain.tgnet.TLRPC$TL_messages_getMessageReactionsList;
import org.rbmain.tgnet.TLRPC$TL_messages_getMessageReadParticipants;
import org.rbmain.tgnet.TLRPC$TL_messages_getPollVotes;
import org.rbmain.tgnet.TLRPC$TL_messages_getRecentStickers;
import org.rbmain.tgnet.TLRPC$TL_messages_getSavedGifs;
import org.rbmain.tgnet.TLRPC$TL_messages_getStickerSet;
import org.rbmain.tgnet.TLRPC$TL_messages_getStickers;
import org.rbmain.tgnet.TLRPC$TL_messages_installStickerSet;
import org.rbmain.tgnet.TLRPC$TL_messages_messages;
import org.rbmain.tgnet.TLRPC$TL_messages_recentStickers;
import org.rbmain.tgnet.TLRPC$TL_messages_reorderStickerSets;
import org.rbmain.tgnet.TLRPC$TL_messages_saveGif;
import org.rbmain.tgnet.TLRPC$TL_messages_savedGifs;
import org.rbmain.tgnet.TLRPC$TL_messages_search;
import org.rbmain.tgnet.TLRPC$TL_messages_searchStickerSets;
import org.rbmain.tgnet.TLRPC$TL_messages_sendReaction;
import org.rbmain.tgnet.TLRPC$TL_messages_sendVote;
import org.rbmain.tgnet.TLRPC$TL_messages_stickerSet;
import org.rbmain.tgnet.TLRPC$TL_messages_stickers;
import org.rbmain.tgnet.TLRPC$TL_messages_uninstallStickerSet;
import org.rbmain.tgnet.TLRPC$TL_messages_updatePinnedMessage;
import org.rbmain.tgnet.TLRPC$TL_messages_votesList;
import org.rbmain.tgnet.TLRPC$TL_readParticipantDate;
import org.rbmain.tgnet.TLRPC$TL_updateEditChannelMessage;
import org.rbmain.tgnet.TLRPC$TL_updateEditMessage;
import org.rbmain.tgnet.TLRPC$TL_updateMessagePoll;
import org.rbmain.tgnet.TLRPC$TL_updateMessageReactions;
import org.rbmain.tgnet.TLRPC$TL_updates;
import org.rbmain.tgnet.TLRPC$Update;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.tgnet.TLRPC$Vector;
import org.rbmain.tgnet.TLRPC$messages_Messages;
import org.rbmain.ui.Components.AlertsCreator;
import org.rbmain.ui.LaunchActivity;

/* loaded from: classes.dex */
public class MessageProxy extends BaseController {
    static Set<String> showedClientMessagesIds = new HashSet();
    public int counter;

    public MessageProxy(int i) {
        super(i);
        this.counter = 0;
        this.currentAccount = i;
    }

    public void loadMessages(long j, long j2, boolean z, int i, long j3, int i2, boolean z2, long j4, int i3, int i4, long j5, boolean z3, int i5, long j6, long j7, int i6) {
        loadMessages(j, j2, z, i, j3, i2, z2, j4, i3, i4, j5, z3, i5, j6, i6, j6 != 0 ? j7 : 0L, 0, 0, false, 0);
    }

    public void loadMessages(long j, long j2, boolean z, int i, long j3, int i2, boolean z2, long j4, int i3, int i4, long j5, boolean z3, int i5, long j6, int i6, long j7, int i7, int i8, boolean z4, int i9) {
        loadMessagesInternal(j, j2, z, i, j3, i2, z2, j4, i3, i4, j5, z3, i5, j6, i6, j7, i7, i8, z4, i9, true, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x016c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void loadMessagesInternal(long r44, long r46, boolean r48, int r49, long r50, int r52, boolean r53, long r54, int r56, int r57, long r58, boolean r60, int r61, long r62, int r64, long r65, int r67, int r68, boolean r69, int r70, boolean r71, boolean r72) {
        /*
            Method dump skipped, instructions count: 468
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidMessenger.proxy.MessageProxy.loadMessagesInternal(long, long, boolean, int, long, int, boolean, long, int, int, long, boolean, int, long, int, long, int, int, boolean, int, boolean, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadMessagesInternal$0(boolean z, String str, ChatType chatType, long j, int i, ExtraInfo extraInfo, long j2, long j3, long j4) {
        if (z) {
            int i2 = i / 2;
            getAccountInstance().getCoreMainClass().loadMessagesInterval(str, chatType, null, j, i2, i2, extraInfo, true, true);
        } else {
            boolean z2 = j2 != 0;
            if (j == 0) {
                FileLog.e("MaxId is 0");
            }
            getAccountInstance().getCoreMainClass().loadMessages(str, chatType, null, z2, j2, j, j3, j4, i, extraInfo, true, true);
        }
    }

    public void proxyMessages(final LoadMessagesResult loadMessagesResult) {
        Object obj = loadMessagesResult.extraInfo;
        if (obj instanceof ExtraInfo) {
            final ExtraInfo extraInfo = (ExtraInfo) obj;
            if (extraInfo.load_type == 1) {
                Collections.reverse(loadMessagesResult.messages);
            }
            final CustomParameters customParameters = new CustomParameters();
            customParameters.hasContinue = loadMessagesResult.hasContinue;
            long j = loadMessagesResult.newMaxId;
            if (j != 0) {
                customParameters.newMaxId = j;
                customParameters.newMaxDate = loadMessagesResult.newMaxDate;
            }
            long j2 = loadMessagesResult.newMinId;
            if (j2 != 0) {
                customParameters.newMinId = j2;
                customParameters.newMinDate = loadMessagesResult.newMinDate;
            }
            int i = (int) extraInfo.dialogId;
            final boolean zIsChannel = i < 0 ? ChatObject.isChannel(getMessagesController().getChat(Integer.valueOf(i * (-1)))) : false;
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda27
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$proxyMessages$1(extraInfo, zIsChannel, loadMessagesResult, customParameters);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$proxyMessages$1(ExtraInfo extraInfo, boolean z, LoadMessagesResult loadMessagesResult, CustomParameters customParameters) {
        TLRPC$messages_Messages tLRPC$messages_MessagesConvertAllMessages = MessageConverter.convertAllMessages(getAccountInstance().getCoreMainClass(), extraInfo.dialogId, z, loadMessagesResult.messages, extraInfo);
        if (extraInfo.load_type != 5) {
            getMessagesController().processLoadedMessages(tLRPC$messages_MessagesConvertAllMessages, tLRPC$messages_MessagesConvertAllMessages.messages.size(), extraInfo.dialogId, extraInfo.mergeDialogId, extraInfo.count, extraInfo.max_id, extraInfo.offset_date, loadMessagesResult.isFromDb, extraInfo.classGuid, extraInfo.first_unread, extraInfo.last_message_id, extraInfo.unread_count, extraInfo.last_date, extraInfo.load_type, extraInfo.isChannel, false, extraInfo.mode, extraInfo.threadMessageId, extraInfo.loadIndex, extraInfo.queryFromServer, extraInfo.mentionsCount, extraInfo.processMessages, customParameters);
        } else {
            getMessagesController().processNewMessages(tLRPC$messages_MessagesConvertAllMessages, extraInfo.dialogId);
        }
    }

    public void proxyMessages(final LoadMessagesIntervalResult loadMessagesIntervalResult) {
        Object obj = loadMessagesIntervalResult.extraInfo;
        if (obj instanceof ExtraInfo) {
            final ExtraInfo extraInfo = (ExtraInfo) obj;
            Collections.reverse(loadMessagesIntervalResult.messages);
            final CustomParameters customParameters = new CustomParameters();
            boolean z = loadMessagesIntervalResult.new_has_continue;
            customParameters.newHasContinue = z;
            boolean z2 = loadMessagesIntervalResult.old_has_continue;
            customParameters.oldHasContinue = z2;
            customParameters.isInterval = true;
            long j = loadMessagesIntervalResult.old_max_id;
            if (j != 0 && z2) {
                customParameters.newMaxId = j;
                customParameters.newMaxDate = loadMessagesIntervalResult.oldMaxDate;
            }
            long j2 = loadMessagesIntervalResult.new_min_id;
            if (j2 != 0 && z) {
                customParameters.newMinId = j2;
                customParameters.newMinDate = loadMessagesIntervalResult.newMinDate;
            }
            int i = (int) extraInfo.dialogId;
            final boolean zIsChannel = i < 0 ? ChatObject.isChannel(getMessagesController().getChat(Integer.valueOf(i * (-1)))) : false;
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda26
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$proxyMessages$2(extraInfo, zIsChannel, loadMessagesIntervalResult, customParameters);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$proxyMessages$2(ExtraInfo extraInfo, boolean z, LoadMessagesIntervalResult loadMessagesIntervalResult, CustomParameters customParameters) {
        if (MyLog.isDebugAble) {
            try {
                TLRPC$messages_Messages tLRPC$messages_MessagesConvertAllMessages = MessageConverter.convertAllMessages(getAccountInstance().getCoreMainClass(), extraInfo.dialogId, z, loadMessagesIntervalResult.messages, extraInfo);
                MessagesController messagesController = getMessagesController();
                int size = tLRPC$messages_MessagesConvertAllMessages.messages.size();
                long j = extraInfo.dialogId;
                long j2 = extraInfo.mergeDialogId;
                int i = extraInfo.count;
                long j3 = extraInfo.max_id;
                int i2 = extraInfo.offset_date;
                boolean z2 = loadMessagesIntervalResult.isFromDb;
                messagesController.processLoadedMessages(tLRPC$messages_MessagesConvertAllMessages, size, j, j2, i, j3, i2, z2, extraInfo.classGuid, extraInfo.first_unread, extraInfo.last_message_id, extraInfo.unread_count, extraInfo.last_date, extraInfo.load_type, extraInfo.isChannel, false, extraInfo.mode, extraInfo.threadMessageId, extraInfo.loadIndex, !z2, extraInfo.mentionsCount, extraInfo.processMessages, customParameters);
                return;
            } catch (Exception e) {
                MyLog.handleExceptionThrowOnDebug(e);
                return;
            }
        }
        TLRPC$messages_Messages tLRPC$messages_MessagesConvertAllMessages2 = MessageConverter.convertAllMessages(getAccountInstance().getCoreMainClass(), extraInfo.dialogId, z, loadMessagesIntervalResult.messages, extraInfo);
        MessagesController messagesController2 = getMessagesController();
        int size2 = tLRPC$messages_MessagesConvertAllMessages2.messages.size();
        long j4 = extraInfo.dialogId;
        long j5 = extraInfo.mergeDialogId;
        int i3 = extraInfo.count;
        long j6 = extraInfo.max_id;
        int i4 = extraInfo.offset_date;
        boolean z3 = loadMessagesIntervalResult.isFromDb;
        messagesController2.processLoadedMessages(tLRPC$messages_MessagesConvertAllMessages2, size2, j4, j5, i3, j6, i4, z3, extraInfo.classGuid, extraInfo.first_unread, extraInfo.last_message_id, extraInfo.unread_count, extraInfo.last_date, extraInfo.load_type, extraInfo.isChannel, false, extraInfo.mode, extraInfo.threadMessageId, extraInfo.loadIndex, !z3, extraInfo.mentionsCount, extraInfo.processMessages, customParameters);
    }

    public void proxyNewMessages(final long j, final ChatType chatType, final ArrayList<Message> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$proxyNewMessages$3(j, chatType, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$proxyNewMessages$3(long j, ChatType chatType, ArrayList arrayList) {
        getMessagesController().processNewMessages(MessageConverter.convertAllMessages(getAccountInstance().getCoreMainClass(), j, chatType == ChatType.Channel, arrayList, null), j);
    }

    public void proxyReplyMessages(final String str, final ChatType chatType, final ArrayList<Message> arrayList) {
        if (arrayList == null || TextUtils.isEmpty(str) || chatType == null) {
            return;
        }
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda34
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$proxyReplyMessages$5(str, chatType, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$proxyReplyMessages$5(String str, ChatType chatType, ArrayList arrayList) {
        final long dialogId = ChatConverter.getDialogId(str, chatType);
        final ArrayList<MessageObject> arrayListConvertAllToMessageObject = MessageConverter.convertAllToMessageObject(this.currentAccount, getAccountInstance().getCoreMainClass(), dialogId, chatType == ChatType.Channel, arrayList, null);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda19
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$proxyReplyMessages$4(dialogId, arrayListConvertAllToMessageObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$proxyReplyMessages$4(long j, ArrayList arrayList) {
        getNotificationCenter().postNotificationName(NotificationCenter.replyMessagesDidLoad, Long.valueOf(j), arrayList);
    }

    public void proxyDeletedMessages(final long j, final ChatType chatType, final ArrayList<Long> arrayList) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda42
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$proxyDeletedMessages$6(arrayList, chatType, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$proxyDeletedMessages$6(ArrayList arrayList, ChatType chatType, long j) {
        NotificationCenter notificationCenter = getNotificationCenter();
        int i = NotificationCenter.messagesDeleted;
        Object[] objArr = new Object[3];
        objArr[0] = arrayList;
        objArr[1] = Integer.valueOf((int) ((chatType == ChatType.User || chatType == ChatType.Bot || chatType == ChatType.Service) ? 0L : -j));
        objArr[2] = Boolean.FALSE;
        notificationCenter.postNotificationName(i, objArr);
    }

    public void proxyMessagesUpdate(final long j, final ChatType chatType, final ArrayList<MessageUpdateResult> arrayList) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda41
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$proxyMessagesUpdate$8(arrayList, j, chatType);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$proxyMessagesUpdate$8(ArrayList arrayList, final long j, ChatType chatType) {
        final ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new MessageObject(this.currentAccount, MessageConverter.convertToTlMessage(getAccountInstance().getCoreMainClass(), j, chatType == ChatType.Channel, ((MessageUpdateResult) it.next()).message, null), false, true));
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda20
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$proxyMessagesUpdate$7(j, arrayList2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$proxyMessagesUpdate$7(long j, ArrayList arrayList) {
        getNotificationCenter().postNotificationName(NotificationCenter.replaceMessagesObjects, Long.valueOf(j), arrayList);
    }

    public void sendMessage(final TLObject tLObject, final TLRPC$Message tLRPC$Message, final RequestDelegate requestDelegate) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda68
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$sendMessage$9(tLObject, tLRPC$Message, requestDelegate);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0176  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$sendMessage$9(org.rbmain.tgnet.TLObject r19, final org.rbmain.tgnet.TLRPC$Message r20, final org.rbmain.tgnet.RequestDelegate r21) {
        /*
            Method dump skipped, instructions count: 380
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidMessenger.proxy.MessageProxy.lambda$sendMessage$9(org.rbmain.tgnet.TLObject, org.rbmain.tgnet.TLRPC$Message, org.rbmain.tgnet.RequestDelegate):void");
    }

    public void forwardMessages(final ArrayList<TLRPC$Message> arrayList, final ArrayList<Long> arrayList2, final ArrayList<Long> arrayList3, final long j, final long j2, final RequestDelegate requestDelegate) {
        if (arrayList3 == null || arrayList2 == null || arrayList3.isEmpty() || arrayList2.isEmpty()) {
            return;
        }
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$forwardMessages$10(j2, j, arrayList, arrayList2, requestDelegate, arrayList3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$forwardMessages$10(final long j, long j2, final ArrayList arrayList, ArrayList arrayList2, final RequestDelegate requestDelegate, final ArrayList arrayList3) {
        final String dialogId = IdStorage.getInstance().getDialogId(j);
        ChatType chatType = getDialogsProxy().getChatType(j);
        String dialogId2 = IdStorage.getInstance().getDialogId(j2);
        final ArrayList arrayList4 = new ArrayList();
        Iterator it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            TLRPC$Message tLRPC$Message = (TLRPC$Message) it.next();
            arrayList4.add(MessageConverter.convertToCoreMessage(getAccountInstance().getCoreMainClass(), tLRPC$Message));
            i = (int) (i + tLRPC$Message.id);
        }
        getAccountInstance().getCoreMainClass().callForwardMessage(dialogId2, dialogId, chatType, arrayList2, i, new LoadListener<ForwardMessageResult>() { // from class: androidMessenger.proxy.MessageProxy.3
            /* JADX WARN: Removed duplicated region for block: B:34:0x0132  */
            @Override // ir.aaap.messengercore.LoadListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void onDidLoad(ir.aaap.messengercore.model.ForwardMessageResult r18) {
                /*
                    Method dump skipped, instructions count: 386
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: androidMessenger.proxy.MessageProxy.AnonymousClass3.onDidLoad(ir.aaap.messengercore.model.ForwardMessageResult):void");
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                Iterator it2 = arrayList4.iterator();
                while (it2.hasNext()) {
                    Message message = (Message) it2.next();
                    message.sendState = 2;
                    MessageProxy.this.getAccountInstance().getCoreMainClass().saveMessageSendState(dialogId, message);
                }
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Couldn't Forward Messages: " + exc.getMessage();
                requestDelegate.run(null, tLRPC$TL_error);
            }
        });
    }

    public void pinMessage(final TLObject tLObject, final RequestDelegate requestDelegate) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda58
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$pinMessage$11(tLObject, requestDelegate);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$pinMessage$11(TLObject tLObject, final RequestDelegate requestDelegate) {
        int i;
        int i2;
        TLRPC$TL_messages_updatePinnedMessage tLRPC$TL_messages_updatePinnedMessage = (TLRPC$TL_messages_updatePinnedMessage) tLObject;
        TLRPC$InputPeer tLRPC$InputPeer = tLRPC$TL_messages_updatePinnedMessage.peer;
        if (tLRPC$InputPeer instanceof TLRPC$TL_inputPeerUser) {
            i2 = tLRPC$InputPeer.user_id;
        } else {
            if (tLRPC$InputPeer instanceof TLRPC$TL_inputPeerChat) {
                i = tLRPC$InputPeer.chat_id;
            } else {
                i = tLRPC$InputPeer.channel_id;
            }
            i2 = -i;
        }
        getAccountInstance().getCoreMainClass().togglePinMessage(IdStorage.getInstance().getDialogId(i2), tLRPC$TL_messages_updatePinnedMessage.id, !tLRPC$TL_messages_updatePinnedMessage.unpin, new LoadListener<PinMessageResult>(this) { // from class: androidMessenger.proxy.MessageProxy.4
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(PinMessageResult pinMessageResult) {
                if (pinMessageResult != null && pinMessageResult.status == SetPinMessageOutput.Status.OK) {
                    requestDelegate.run(null, null);
                    return;
                }
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                StringBuilder sb = new StringBuilder();
                sb.append("Couldn't Pin Messages: ");
                sb.append(pinMessageResult == null ? "result is null" : pinMessageResult.status);
                tLRPC$TL_error.text = sb.toString();
                requestDelegate.run(null, tLRPC$TL_error);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Couldn't Pin Messages: " + exc.getMessage();
                requestDelegate.run(null, tLRPC$TL_error);
            }
        });
    }

    public void seenChat(final long j, final long j2, final boolean z) {
        if (j2 == Long.MIN_VALUE || j2 == Long.MAX_VALUE) {
            return;
        }
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$seenChat$12(j, j2, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$seenChat$12(long j, long j2, boolean z) {
        getAccountInstance().getCoreMainClass().seenChat(IdStorage.getInstance().getDialogId(j), getDialogsProxy().getChatType(j), j2, z);
    }

    public void addDelayedMessageToLocalDb(final TLRPC$Message tLRPC$Message, final boolean z) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda73
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$addDelayedMessageToLocalDb$13(tLRPC$Message, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addDelayedMessageToLocalDb$13(TLRPC$Message tLRPC$Message, boolean z) {
        Chat chatInstant;
        String dialogId = IdStorage.getInstance().getDialogId(tLRPC$Message.dialog_id);
        if (z && (chatInstant = getCoreMainClass().getChatInstant(dialogId)) != null) {
            tLRPC$Message.prevMessageId = chatInstant.last_message_id;
        }
        Message messageConvertToCoreMessage = MessageConverter.convertToCoreMessage(getAccountInstance().getCoreMainClass(), tLRPC$Message);
        FirebaseCrashlytics.getInstance().setCustomKey("send message addDelayedMessageToLocalDb", tLRPC$Message.id + BuildConfig.FLAVOR);
        if (!z) {
            getAccountInstance().getCoreMainClass().updateLocalMessage(dialogId, messageConvertToCoreMessage);
        } else if (tLRPC$Message.id < 0) {
            getAccountInstance().getCoreMainClass().prepareSendMessage(dialogId, messageConvertToCoreMessage);
        } else {
            getAccountInstance().getCoreMainClass().prepareEditMessage(dialogId, messageConvertToCoreMessage);
        }
    }

    public void addDelayedMessageToLocalDb(ArrayList<TLRPC$Message> arrayList, boolean z) {
        Iterator<TLRPC$Message> it = arrayList.iterator();
        while (it.hasNext()) {
            addDelayedMessageToLocalDb(it.next(), z);
        }
    }

    public void saveSendStateMessage(final TLRPC$Message tLRPC$Message) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda72
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$saveSendStateMessage$14(tLRPC$Message);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveSendStateMessage$14(TLRPC$Message tLRPC$Message) {
        String str;
        String dialogId = IdStorage.getInstance().getDialogId(tLRPC$Message.dialog_id);
        Message messageConvertToCoreMessage = MessageConverter.convertToCoreMessage(getAccountInstance().getCoreMainClass(), tLRPC$Message);
        FirebaseCrashlytics firebaseCrashlytics = FirebaseCrashlytics.getInstance();
        if (messageConvertToCoreMessage != null) {
            str = messageConvertToCoreMessage.message_id + BuildConfig.FLAVOR;
        } else {
            str = "null";
        }
        firebaseCrashlytics.setCustomKey("send message saveSendStateMessage ", str);
        getAccountInstance().getCoreMainClass().saveMessageSendState(dialogId, messageConvertToCoreMessage);
    }

    public void markMessageAsSendError(final TLRPC$Message tLRPC$Message, boolean z) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda70
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$markMessageAsSendError$15(tLRPC$Message);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$markMessageAsSendError$15(TLRPC$Message tLRPC$Message) {
        String str;
        String dialogId = IdStorage.getInstance().getDialogId(tLRPC$Message.dialog_id);
        Message messageConvertToCoreMessage = MessageConverter.convertToCoreMessage(getAccountInstance().getCoreMainClass(), tLRPC$Message);
        FirebaseCrashlytics firebaseCrashlytics = FirebaseCrashlytics.getInstance();
        if (messageConvertToCoreMessage != null) {
            str = messageConvertToCoreMessage.message_id + BuildConfig.FLAVOR;
        } else {
            str = "null";
        }
        firebaseCrashlytics.setCustomKey("send message markMessageAsSendError ", str);
        messageConvertToCoreMessage.sendState = 2;
        getAccountInstance().getCoreMainClass().saveMessageSendState(dialogId, messageConvertToCoreMessage);
    }

    public void removeLocalMessageFromDb(final int i, final long j, final long j2, final int i2, final TLRPC$Message tLRPC$Message) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$removeLocalMessageFromDb$16(j2, i2, j, tLRPC$Message, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removeLocalMessageFromDb$16(long j, int i, long j2, TLRPC$Message tLRPC$Message, int i2) {
        String dialogId = IdStorage.getInstance().getDialogId(j);
        if (i == 0) {
            getAccountInstance().getCoreMainClass().localMessageSent(dialogId, j2);
        } else if (i == 3) {
            getAccountInstance().getCoreMainClass().cancelEditMessage(dialogId, MessageConverter.convertToCoreMessage(getAccountInstance().getCoreMainClass(), tLRPC$Message), i2);
        } else {
            getAccountInstance().getCoreMainClass().cancelSendingMessage(dialogId, j2, i2);
        }
    }

    public void getUnsentMessages() {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getUnsentMessages$17();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getUnsentMessages$17() {
        CoreMainClass coreMainClass = getAccountInstance().getCoreMainClass();
        ArrayList<Message> allUnsentMessages = coreMainClass.getAllUnsentMessages(new HashSet(Arrays.asList(1, 3)));
        ArrayList<TLRPC$User> arrayList = new ArrayList<>();
        ArrayList<TLRPC$Message> arrayListConvertAllMessages = MessageConverter.convertAllMessages(coreMainClass, allUnsentMessages, arrayList);
        Log.d(NotificationBadge.AdwHomeBadger.COUNT, allUnsentMessages.size() + ": count ");
        getAccountInstance().getSendMessagesHelper().processUnsentMessages(arrayListConvertAllMessages, null, arrayList, null, null);
    }

    public void deleteMessages(final ArrayList<Long> arrayList, final ArrayList<Long> arrayList2, boolean z, final long j, final boolean z2, boolean z3) {
        if (j == 0) {
            return;
        }
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda22
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$deleteMessages$18(j, arrayList, arrayList2, z2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteMessages$18(long j, ArrayList arrayList, ArrayList arrayList2, boolean z) {
        ChatAbsObject absInstant;
        String dialogId = IdStorage.getInstance().getDialogId(j);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Long l = (Long) it.next();
            if (l.longValue() < 0) {
                getAccountInstance().getCoreMainClass().cancelSendingMessage(dialogId, l.longValue(), 0);
            }
        }
        if (arrayList2 == null || arrayList2.isEmpty() || (absInstant = getCoreMainClass().getAbsInstant(dialogId)) == null) {
            return;
        }
        ChatType chatType = absInstant.type;
        if (chatType == ChatType.Channel || chatType == ChatType.Bot) {
            z = true;
        }
        getAccountInstance().getCoreMainClass().deleteMessages(dialogId, arrayList2, z ? DeleteMessagesInput.DeleteMessagesType.Global : DeleteMessagesInput.DeleteMessagesType.Local, new LoadListener<Integer>(this) { // from class: androidMessenger.proxy.MessageProxy.5
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(Integer num) {
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
            }
        });
    }

    public void setUnreadCount(final long j, final int i) {
        if (j == 0) {
            return;
        }
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setUnreadCount$19(j, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setUnreadCount$19(long j, int i) {
        getAccountInstance().getCoreMainClass().changeChatLocalCountUnseen(IdStorage.getInstance().getDialogId(j), i);
    }

    public void proxyMyStickers() {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$proxyMyStickers$20();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$proxyMyStickers$20() {
        ArrayList<StickerSetObject> myStickerSetInstant = getAccountInstance().getCoreMainClass().getMyStickerSetInstant();
        ArrayList<TLRPC$TL_messages_stickerSet> arrayList = new ArrayList<>();
        if (myStickerSetInstant == null || myStickerSetInstant.isEmpty()) {
            getMediaDataController().processLoadedStickers(0, arrayList, false, 0, 0);
            return;
        }
        Iterator<StickerSetObject> it = myStickerSetInstant.iterator();
        while (it.hasNext()) {
            StickerSetObject next = it.next();
            if (next != null) {
                arrayList.add(MessageConverter.convertStickerSetAndSticker(next, getAccountInstance().getCoreMainClass().getStickersBySetIdInstant(next.sticker_set_id)));
            }
        }
        getMediaDataController().processLoadedStickers(0, arrayList, false, 0, 0);
    }

    public void proxyMyStickersFailed() {
        getMediaDataController().processLoadedStickers(0, null, false, (int) (System.currentTimeMillis() / 1000), 0);
    }

    public void loadStickers(int i) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadStickers$21();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadStickers$21() {
        MyLog.e("MyTaggg", "AAAAAAAAAAAA");
        getCoreMainClass().initAndLoadMyStickersIfNeeded(false);
    }

    public void getRecentStickers(final TLObject tLObject, final RequestDelegate requestDelegate) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda62
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getRecentStickers$22(tLObject, requestDelegate);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getRecentStickers$22(TLObject tLObject, RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_messages_getRecentStickers) {
            ArrayList<StickerObject> recentStickersInstant = getCoreMainClass().getRecentStickersInstant();
            TLRPC$TL_messages_recentStickers tLRPC$TL_messages_recentStickers = new TLRPC$TL_messages_recentStickers();
            if (recentStickersInstant != null) {
                tLRPC$TL_messages_recentStickers.stickers = MessageConverter.convertAllStickersToDocuments(recentStickersInstant);
            }
            requestDelegate.run(tLRPC$TL_messages_recentStickers, null);
            return;
        }
        if (tLObject instanceof TLRPC$TL_messages_getFavedStickers) {
            ArrayList<StickerObject> favoriteStickersInstant = getCoreMainClass().getFavoriteStickersInstant();
            TLRPC$TL_messages_favedStickers tLRPC$TL_messages_favedStickers = new TLRPC$TL_messages_favedStickers();
            if (favoriteStickersInstant != null) {
                tLRPC$TL_messages_favedStickers.stickers = MessageConverter.convertAllStickersToDocuments(favoriteStickersInstant);
            }
            requestDelegate.run(tLRPC$TL_messages_favedStickers, null);
        }
    }

    public void loadRecentGifs(TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_messages_getSavedGifs) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda45
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadRecentGifs$23(requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadRecentGifs$23(final RequestDelegate requestDelegate) {
        getCoreMainClass().getAllRecentGif(new LoadListener<ArrayList<FileInlineObject>>(this) { // from class: androidMessenger.proxy.MessageProxy.6
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(ArrayList<FileInlineObject> arrayList) {
                TLRPC$TL_messages_savedGifs tLRPC$TL_messages_savedGifs = new TLRPC$TL_messages_savedGifs();
                tLRPC$TL_messages_savedGifs.gifs = MessageConverter.convertAllRecentGifsToDocument(arrayList);
                requestDelegate.run(tLRPC$TL_messages_savedGifs, null);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                requestDelegate.run(null, new TLRPC$TL_error());
            }
        });
    }

    public void getStickerSetById(final TLObject tLObject, final RequestDelegate requestDelegate) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda50
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getStickerSetById$24(tLObject, requestDelegate);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getStickerSetById$24(TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_messages_getStickerSet) {
            final String stickerSetId = IdStorage.getInstance().getStickerSetId(((TLRPC$TL_messages_getStickerSet) tLObject).stickerset.id);
            getCoreMainClass().getStickersSetById(stickerSetId, new LoadListener<Integer>() { // from class: androidMessenger.proxy.MessageProxy.7
                @Override // ir.aaap.messengercore.LoadListener
                public void onDidLoad(Integer num) {
                    requestDelegate.run(MessageConverter.convertStickerSetAndSticker(MessageProxy.this.getCoreMainClass().getStickerSetByIdInstant(stickerSetId), MessageProxy.this.getCoreMainClass().getStickersBySetIdInstant(stickerSetId)), null);
                }

                @Override // ir.aaap.messengercore.LoadListener
                public void onError(Exception exc) {
                    requestDelegate.run(null, new TLRPC$TL_error());
                }
            });
        }
    }

    public void loadArchivedStickers(final TLObject tLObject, final RequestDelegate requestDelegate) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda54
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadArchivedStickers$25(tLObject, requestDelegate);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadArchivedStickers$25(TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_messages_getArchivedStickers) {
            getCoreMainClass().getMyArchivedStickerSets(((TLRPC$TL_messages_getArchivedStickers) tLObject).startId, BuildConfig.FLAVOR, new LoadListener<GetStickersOutput>(this) { // from class: androidMessenger.proxy.MessageProxy.8
                @Override // ir.aaap.messengercore.LoadListener
                public void onError(Exception exc) {
                }

                @Override // ir.aaap.messengercore.LoadListener
                public void onDidLoad(GetStickersOutput getStickersOutput) {
                    requestDelegate.run(MessageConverter.convertArchivedStickerSet(getStickersOutput), null);
                }
            });
        }
    }

    public void loadTrendStickers(final TLObject tLObject, final RequestDelegate requestDelegate) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda51
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadTrendStickers$26(tLObject, requestDelegate);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadTrendStickers$26(TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_messages_getFeaturedStickers) {
            TLRPC$TL_messages_getFeaturedStickers tLRPC$TL_messages_getFeaturedStickers = (TLRPC$TL_messages_getFeaturedStickers) tLObject;
            getCoreMainClass().getTrendStickerSet(tLRPC$TL_messages_getFeaturedStickers.forceLoadFromServer, tLRPC$TL_messages_getFeaturedStickers.startId, new LoadListener<GetStickersOutput>(this) { // from class: androidMessenger.proxy.MessageProxy.9
                @Override // ir.aaap.messengercore.LoadListener
                public void onDidLoad(GetStickersOutput getStickersOutput) {
                    requestDelegate.run(MessageConverter.convertTrendStickerSet(getStickersOutput), null);
                }

                @Override // ir.aaap.messengercore.LoadListener
                public void onError(Exception exc) {
                    requestDelegate.run(null, new TLRPC$TL_error());
                }
            });
        }
    }

    public void searchServerStickers(final TLObject tLObject, final RequestDelegate requestDelegate) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda65
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$searchServerStickers$27(tLObject, requestDelegate);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$searchServerStickers$27(TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_messages_getStickers) {
            TLRPC$TL_messages_getStickers tLRPC$TL_messages_getStickers = (TLRPC$TL_messages_getStickers) tLObject;
            getCoreMainClass().getStickersByEmoji(tLRPC$TL_messages_getStickers.startId, tLRPC$TL_messages_getStickers.emoticon, new LoadListener<GetStickersByEmojiOutput>(this) { // from class: androidMessenger.proxy.MessageProxy.10
                @Override // ir.aaap.messengercore.LoadListener
                public void onDidLoad(GetStickersByEmojiOutput getStickersByEmojiOutput) {
                    TLRPC$TL_messages_stickers tLRPC$TL_messages_stickers = new TLRPC$TL_messages_stickers();
                    tLRPC$TL_messages_stickers.stickers = MessageConverter.convertAllStickersToDocuments(getStickersByEmojiOutput.stickers);
                    requestDelegate.run(tLRPC$TL_messages_stickers, null);
                }

                @Override // ir.aaap.messengercore.LoadListener
                public void onError(Exception exc) {
                    requestDelegate.run(null, new TLRPC$TL_error());
                }
            });
        }
    }

    public void toggleStickerSet(final TLObject tLObject, final RequestDelegate requestDelegate) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda55
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$toggleStickerSet$28(tLObject, requestDelegate);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$toggleStickerSet$28(TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_messages_installStickerSet) {
            TLRPC$TL_messages_installStickerSet tLRPC$TL_messages_installStickerSet = (TLRPC$TL_messages_installStickerSet) tLObject;
            TLRPC$InputStickerSet tLRPC$InputStickerSet = tLRPC$TL_messages_installStickerSet.stickerset;
            boolean z = tLRPC$TL_messages_installStickerSet.archived;
            String stickerSetId = IdStorage.getInstance().getStickerSetId(tLRPC$InputStickerSet.id);
            if (z) {
                getCoreMainClass().archiveStickerSet(stickerSetId, new LoadListener<ActionOnStickersOutput.StickerStateEnum>(this) { // from class: androidMessenger.proxy.MessageProxy.11
                    @Override // ir.aaap.messengercore.LoadListener
                    public void onDidLoad(ActionOnStickersOutput.StickerStateEnum stickerStateEnum) {
                        requestDelegate.run(null, null);
                    }

                    @Override // ir.aaap.messengercore.LoadListener
                    public void onError(Exception exc) {
                        requestDelegate.run(null, new TLRPC$TL_error());
                    }
                });
                return;
            } else {
                getCoreMainClass().addStickerSet(stickerSetId, new LoadListener<ActionOnStickersOutput.StickerStateEnum>(this) { // from class: androidMessenger.proxy.MessageProxy.12
                    @Override // ir.aaap.messengercore.LoadListener
                    public void onDidLoad(ActionOnStickersOutput.StickerStateEnum stickerStateEnum) {
                        requestDelegate.run(null, null);
                    }

                    @Override // ir.aaap.messengercore.LoadListener
                    public void onError(Exception exc) {
                        requestDelegate.run(null, new TLRPC$TL_error());
                    }
                });
                return;
            }
        }
        if (tLObject instanceof TLRPC$TL_messages_uninstallStickerSet) {
            getCoreMainClass().removeStickerSet(IdStorage.getInstance().getStickerSetId(((TLRPC$TL_messages_uninstallStickerSet) tLObject).stickerset.id), new LoadListener<ActionOnStickersOutput.StickerStateEnum>(this) { // from class: androidMessenger.proxy.MessageProxy.13
                @Override // ir.aaap.messengercore.LoadListener
                public void onDidLoad(ActionOnStickersOutput.StickerStateEnum stickerStateEnum) {
                    requestDelegate.run(null, null);
                }

                @Override // ir.aaap.messengercore.LoadListener
                public void onError(Exception exc) {
                    requestDelegate.run(null, new TLRPC$TL_error());
                }
            });
        }
    }

    public void reorderStickers(final TLObject tLObject, final RequestDelegate requestDelegate) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda59
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$reorderStickers$29(tLObject, requestDelegate);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reorderStickers$29(TLObject tLObject, RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_messages_reorderStickerSets) {
            TLRPC$TL_messages_reorderStickerSets tLRPC$TL_messages_reorderStickerSets = (TLRPC$TL_messages_reorderStickerSets) tLObject;
            if (tLRPC$TL_messages_reorderStickerSets.order != null) {
                ArrayList<String> arrayList = new ArrayList<>();
                for (int i = 0; i < tLRPC$TL_messages_reorderStickerSets.order.size(); i++) {
                    arrayList.add(IdStorage.getInstance().getStickerSetId(tLRPC$TL_messages_reorderStickerSets.order.get(i).longValue()));
                }
                if (arrayList.size() > 0) {
                    getCoreMainClass().reorderStickerSets(arrayList);
                    requestDelegate.run(null, null);
                }
            }
        }
    }

    public int searchStickerSet(final TLObject tLObject, final RequestDelegate requestDelegate) {
        final int andIncReqId = IdStorage.getInstance().getAndIncReqId();
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda67
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$searchStickerSet$30(tLObject, requestDelegate, andIncReqId);
            }
        });
        return andIncReqId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$searchStickerSet$30(TLObject tLObject, final RequestDelegate requestDelegate, int i) {
        if (tLObject instanceof TLRPC$TL_messages_searchStickerSets) {
            TLRPC$TL_messages_searchStickerSets tLRPC$TL_messages_searchStickerSets = (TLRPC$TL_messages_searchStickerSets) tLObject;
            IdStorage.getInstance().binReqIds(i, getCoreMainClass().searchStickerSets(tLRPC$TL_messages_searchStickerSets.startId, tLRPC$TL_messages_searchStickerSets.q, new LoadListener<GetStickersOutput>(this) { // from class: androidMessenger.proxy.MessageProxy.14
                @Override // ir.aaap.messengercore.LoadListener
                public void onDidLoad(GetStickersOutput getStickersOutput) {
                    requestDelegate.run(MessageConverter.convertFoundStickerSet(getStickersOutput), null);
                }

                @Override // ir.aaap.messengercore.LoadListener
                public void onError(Exception exc) {
                    requestDelegate.run(null, new TLRPC$TL_error());
                }
            }));
        }
    }

    public void processLoadedRecentDocuments(final int i, ArrayList<TLRPC$Document> arrayList, final boolean z, final int i2, final boolean z2) {
        ArrayList arrayList2;
        if (arrayList != null) {
            arrayList2 = new ArrayList(arrayList);
        } else {
            arrayList2 = new ArrayList();
        }
        final ArrayList arrayList3 = arrayList2;
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda75
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processLoadedRecentDocuments$31(z, arrayList3, i2, i, z2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processLoadedRecentDocuments$31(boolean z, ArrayList arrayList, int i, int i2, boolean z2) {
        if (z) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                getCoreMainClass().addRecentGif(MessageConverter.convertDocumentToGifFileInline((TLRPC$Document) it.next()), i);
            }
            return;
        }
        ArrayList<StickerObject> arrayListConvertAllDocumentsToStickers = MessageConverter.convertAllDocumentsToStickers(arrayList);
        if (i2 == 2) {
            getCoreMainClass().addFavoriteSticker(arrayListConvertAllDocumentsToStickers, i, z2);
        } else if (i2 == 0) {
            getCoreMainClass().addRecentSticker(arrayListConvertAllDocumentsToStickers, i, z2);
        }
    }

    public void removeRecentOrFavoriteSticker(final TLRPC$Document tLRPC$Document, final int i) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda69
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$removeRecentOrFavoriteSticker$32(tLRPC$Document, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removeRecentOrFavoriteSticker$32(TLRPC$Document tLRPC$Document, int i) {
        if (tLRPC$Document == null) {
            return;
        }
        StickerObject stickerObjectConvertDocumentToSticker = MessageConverter.convertDocumentToSticker(tLRPC$Document);
        if (stickerObjectConvertDocumentToSticker.sticker_id != null && i == 2) {
            getCoreMainClass().removeFavoriteSticker(stickerObjectConvertDocumentToSticker.sticker_id);
        }
    }

    public int searchInChatMessages(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (!(tLObject instanceof TLRPC$TL_messages_search)) {
            return -1;
        }
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda57
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$searchInChatMessages$33(tLObject, requestDelegate);
            }
        });
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$searchInChatMessages$33(TLObject tLObject, final RequestDelegate requestDelegate) {
        int i;
        TLRPC$TL_messages_search tLRPC$TL_messages_search = (TLRPC$TL_messages_search) tLObject;
        TLRPC$InputPeer tLRPC$InputPeer = tLRPC$TL_messages_search.peer;
        if (tLRPC$InputPeer instanceof TLRPC$TL_inputPeerUser) {
            i = tLRPC$InputPeer.user_id;
        } else {
            i = -tLRPC$InputPeer.channel_id;
        }
        final long j = i;
        final String dialogId = IdStorage.getInstance().getDialogId(j);
        String str = tLRPC$TL_messages_search.q;
        LoadListener<SearchChatMessagesResult> loadListener = new LoadListener<SearchChatMessagesResult>() { // from class: androidMessenger.proxy.MessageProxy.15
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(SearchChatMessagesResult searchChatMessagesResult) {
                ArrayList<Long> arrayList;
                Map<Long, Message> map;
                TLRPC$TL_messages_messages tLRPC$TL_messages_messages = new TLRPC$TL_messages_messages();
                ArrayList<TLRPC$Message> arrayList2 = new ArrayList<>();
                if (searchChatMessagesResult != null && (arrayList = searchChatMessagesResult.messageIds) != null && !arrayList.isEmpty() && (map = searchChatMessagesResult.messages) != null && map.size() > 0) {
                    tLRPC$TL_messages_messages.count = searchChatMessagesResult.messageIds.size();
                    Iterator<Long> it = searchChatMessagesResult.messageIds.iterator();
                    while (it.hasNext()) {
                        Long next = it.next();
                        if (next != null && searchChatMessagesResult.messages.get(next) != null) {
                            arrayList2.add(MessageConverter.convertToTlMessage(MessageProxy.this.getCoreMainClass(), j, MessageProxy.this.getCoreMainClass().isChannel(dialogId), searchChatMessagesResult.messages.get(next), null));
                        }
                    }
                }
                tLRPC$TL_messages_messages.messages = arrayList2;
                requestDelegate.run(tLRPC$TL_messages_messages, null);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Failed To Search Messages";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        };
        if (str.startsWith("#")) {
            String strSubstring = str.substring(1);
            if (!strSubstring.isEmpty()) {
                getCoreMainClass().searchChatMessagesHashtag(dialogId, strSubstring, loadListener);
                return;
            } else {
                loadListener.onDidLoad(null);
                return;
            }
        }
        getCoreMainClass().searchChatMessagesText(dialogId, str, loadListener);
    }

    public void seenChannelCount(int i, final long j, final long j2) {
        if (j2 == 0 || j == 0 || i == 0) {
            return;
        }
        final String dialogId = IdStorage.getInstance().getDialogId(-i);
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda32
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$seenChannelCount$34(dialogId, j, j2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$seenChannelCount$34(String str, long j, long j2) {
        getCoreMainClass().seenChannelMessages(str, j, j2);
    }

    public void processUpdatedMessagesViews(String str, Map<Long, Integer> map, long j) {
        if (map == null || map.isEmpty()) {
            return;
        }
        final SparseArray sparseArray = new SparseArray();
        LongSparseArray longSparseArray = new LongSparseArray();
        long jGenerateNegativeDialogId = IdStorage.getInstance().generateNegativeDialogId(str);
        for (Long l : map.keySet()) {
            if (l != null) {
                longSparseArray.put(j != 0 ? j : l.longValue(), map.get(l));
            }
        }
        sparseArray.put((int) jGenerateNegativeDialogId, longSparseArray);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda23
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processUpdatedMessagesViews$35(sparseArray);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processUpdatedMessagesViews$35(SparseArray sparseArray) {
        getNotificationCenter().postNotificationName(NotificationCenter.didUpdateMessagesViews, sparseArray, null, null, Boolean.FALSE);
    }

    public void saveGif(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (!(tLObject instanceof TLRPC$TL_messages_saveGif) || ((TLRPC$TL_messages_saveGif) tLObject).message == null) {
            return;
        }
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda64
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$saveGif$36(tLObject, requestDelegate);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveGif$36(TLObject tLObject, final RequestDelegate requestDelegate) {
        TLRPC$TL_messages_saveGif tLRPC$TL_messages_saveGif = (TLRPC$TL_messages_saveGif) tLObject;
        String dialogId = IdStorage.getInstance().getDialogId(tLRPC$TL_messages_saveGif.message.dialog_id);
        TLRPC$Message tLRPC$Message = tLRPC$TL_messages_saveGif.message;
        getCoreMainClass().addToMyGifSet(dialogId, tLRPC$Message.id, MessageConverter.convertDocumentToGifFileInline(tLRPC$Message.media.document), new LoadListener<Integer>(this) { // from class: androidMessenger.proxy.MessageProxy.16
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(Integer num) {
                requestDelegate.run(null, null);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Failed To Save Gif";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        });
    }

    public void removeRecentGif(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_messages_saveGif) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda52
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$removeRecentGif$37(tLObject, requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removeRecentGif$37(TLObject tLObject, final RequestDelegate requestDelegate) {
        getCoreMainClass().removeFromMyGifSet(((TLRPC$TL_messages_saveGif) tLObject).id.id, new LoadListener<Integer>(this) { // from class: androidMessenger.proxy.MessageProxy.17
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(Integer num) {
                requestDelegate.run(null, null);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                requestDelegate.run(null, new TLRPC$TL_error());
            }
        });
    }

    public void getBotKeyboard(final long j) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getBotKeyboard$38(j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getBotKeyboard$38(long j) {
        TLRPC$Message messageForKeyboard = MessageConverter.getMessageForKeyboard(j, getCoreMainClass().getChatInstant(IdStorage.getInstance().getDialogId(j)));
        if (messageForKeyboard != null) {
            getMediaDataController().putBotKeyboard(j, messageForKeyboard);
        }
    }

    public void getBotSelectionItems(final long j, final String str, final String str2, final LoadListener<BotModels.GetBotSelectionOutput> loadListener) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda17
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getBotSelectionItems$39(j, str, str2, loadListener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getBotSelectionItems$39(long j, String str, String str2, LoadListener loadListener) {
        getCoreMainClass().getBotSelectionItems(IdStorage.getInstance().getDialogId(j), str, str2, loadListener);
    }

    public void searchBotSelectionItems(final long j, final String str, final String str2, final int i, final LoadListener<BotModels.SearchBotSelectionOutput> loadListener) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda16
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$searchBotSelectionItems$40(j, str, str2, i, loadListener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$searchBotSelectionItems$40(long j, String str, String str2, int i, LoadListener loadListener) {
        getCoreMainClass().searchBotSelectionItems(IdStorage.getInstance().getDialogId(j), str, str2, i, loadListener);
    }

    public void sendMessageApiCall(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_messages_getBotCallbackAnswer) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda49
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$sendMessageApiCall$41(tLObject, requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendMessageApiCall$41(TLObject tLObject, final RequestDelegate requestDelegate) {
        int i;
        TLRPC$TL_messages_getBotCallbackAnswer tLRPC$TL_messages_getBotCallbackAnswer = (TLRPC$TL_messages_getBotCallbackAnswer) tLObject;
        String str = new String(tLRPC$TL_messages_getBotCallbackAnswer.data);
        String strSubstring = str.substring(0, str.lastIndexOf(95));
        String str2 = tLRPC$TL_messages_getBotCallbackAnswer.bot_button_text;
        TLRPC$InputPeer tLRPC$InputPeer = tLRPC$TL_messages_getBotCallbackAnswer.peer;
        if (tLRPC$InputPeer instanceof TLRPC$TL_inputPeerUser) {
            i = tLRPC$InputPeer.user_id;
        } else {
            i = -tLRPC$InputPeer.channel_id;
        }
        String dialogId = IdStorage.getInstance().getDialogId(i);
        AuxDataObject auxDataObject = new AuxDataObject();
        auxDataObject.button_id = strSubstring;
        TLRPC$MessageMedia tLRPC$MessageMedia = tLRPC$TL_messages_getBotCallbackAnswer.media;
        LocationObject locationObject = null;
        if (tLRPC$MessageMedia != null && tLRPC$MessageMedia.geo != null) {
            locationObject = new LocationObject();
            TLRPC$GeoPoint tLRPC$GeoPoint = tLRPC$MessageMedia.geo;
            locationObject.longitude = tLRPC$GeoPoint._long;
            locationObject.latitude = tLRPC$GeoPoint.lat;
        }
        getCoreMainClass().sendMessageAPICall(dialogId, tLRPC$TL_messages_getBotCallbackAnswer.msg_id, str2, null, locationObject, auxDataObject, new LoadListener<Integer>(this) { // from class: androidMessenger.proxy.MessageProxy.18
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(Integer num) {
                requestDelegate.run(null, null);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Couldn't Send Messages: " + exc.getMessage();
                requestDelegate.run(null, tLRPC$TL_error);
            }
        });
    }

    public int sendVote(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (!(tLObject instanceof TLRPC$TL_messages_sendVote)) {
            return 0;
        }
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda47
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$sendVote$42(tLObject, requestDelegate);
            }
        });
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$sendVote$42(org.rbmain.tgnet.TLObject r12, final org.rbmain.tgnet.RequestDelegate r13) {
        /*
            r11 = this;
            org.rbmain.tgnet.TLRPC$TL_messages_sendVote r12 = (org.rbmain.tgnet.TLRPC$TL_messages_sendVote) r12
            org.rbmain.tgnet.TLRPC$InputPeer r0 = r12.peer
            boolean r1 = r0 instanceof org.rbmain.tgnet.TLRPC$TL_inputPeerUser
            if (r1 == 0) goto Lc
            int r0 = r0.user_id
        La:
            long r0 = (long) r0
            goto L1d
        Lc:
            boolean r1 = r0 instanceof org.rbmain.tgnet.TLRPC$TL_inputPeerChat
            if (r1 == 0) goto L14
            int r0 = r0.chat_id
        L12:
            int r0 = -r0
            goto La
        L14:
            boolean r1 = r0 instanceof org.rbmain.tgnet.TLRPC$TL_inputPeerChannel
            if (r1 == 0) goto L1b
            int r0 = r0.channel_id
            goto L12
        L1b:
            r0 = 0
        L1d:
            androidMessenger.proxy.IdStorage r2 = androidMessenger.proxy.IdStorage.getInstance()
            java.lang.String r4 = r2.getDialogId(r0)
            ir.aaap.messengercore.CoreMainClass r0 = r11.getCoreMainClass()
            ir.aaap.messengercore.model.ChatAbsObject r0 = r0.getAbsInstant(r4)
            if (r0 != 0) goto L30
            return
        L30:
            long r6 = r12.msg_id
            long r1 = r12.poll_id
            java.util.ArrayList<byte[]> r3 = r12.options
            if (r3 == 0) goto L78
            boolean r5 = r3.isEmpty()
            if (r5 != 0) goto L78
            java.util.ArrayList<byte[]> r12 = r12.options
            int r12 = r12.size()
            java.lang.Integer[] r9 = new java.lang.Integer[r12]
            r12 = 0
            r5 = 0
        L48:
            int r8 = r3.size()
            if (r5 >= r8) goto L61
            java.lang.Object r8 = r3.get(r5)
            byte[] r8 = (byte[]) r8
            r8 = r8[r12]
            int r8 = r8 + (-48)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r9[r5] = r8
            int r5 = r5 + 1
            goto L48
        L61:
            ir.aaap.messengercore.CoreMainClass r3 = r11.getCoreMainClass()
            ir.aaap.messengercore.model.ChatType r5 = r0.type
            androidMessenger.proxy.IdStorage r12 = androidMessenger.proxy.IdStorage.getInstance()
            java.lang.String r8 = r12.getPollId(r1)
            androidMessenger.proxy.MessageProxy$19 r10 = new androidMessenger.proxy.MessageProxy$19
            r10.<init>(r11)
            r3.votePoll(r4, r5, r6, r8, r9, r10)
            goto L8e
        L78:
            ir.aaap.messengercore.CoreMainClass r3 = r11.getCoreMainClass()
            ir.aaap.messengercore.model.ChatType r5 = r0.type
            androidMessenger.proxy.IdStorage r12 = androidMessenger.proxy.IdStorage.getInstance()
            java.lang.String r8 = r12.getPollId(r1)
            androidMessenger.proxy.MessageProxy$20 r9 = new androidMessenger.proxy.MessageProxy$20
            r9.<init>(r11)
            r3.retractPoll(r4, r5, r6, r8, r9)
        L8e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidMessenger.proxy.MessageProxy.lambda$sendVote$42(org.rbmain.tgnet.TLObject, org.rbmain.tgnet.RequestDelegate):void");
    }

    public void getPollStatus(final long j, final long j2, final long j3) {
        if (j == 0 || j2 == 0) {
            return;
        }
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getPollStatus$43(j2, j, j3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getPollStatus$43(long j, long j2, long j3) {
        String dialogId = IdStorage.getInstance().getDialogId(j);
        ChatAbsObject absInstant = getCoreMainClass().getAbsInstant(dialogId);
        if (absInstant == null) {
            return;
        }
        getCoreMainClass().getPollStatus(dialogId, absInstant.type, j2, IdStorage.getInstance().getPollId(j3));
    }

    public void proxyPollStatus(String str, ChatType chatType, long j, final PollObject pollObject) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda29
            @Override // java.lang.Runnable
            public final void run() throws InterruptedException {
                this.f$0.lambda$proxyPollStatus$44(pollObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$proxyPollStatus$44(PollObject pollObject) throws InterruptedException {
        ArrayList<TLRPC$Update> arrayList = new ArrayList<>();
        TLRPC$TL_updateMessagePoll tLRPC$TL_updateMessagePoll = new TLRPC$TL_updateMessagePoll();
        TLRPC$TL_messageMediaPoll tLRPC$TL_messageMediaPoll = (TLRPC$TL_messageMediaPoll) MessageConverter.convertToTLPoll(null, pollObject);
        TLRPC$Poll tLRPC$Poll = tLRPC$TL_messageMediaPoll.poll;
        tLRPC$TL_updateMessagePoll.poll = tLRPC$Poll;
        TLRPC$PollResults tLRPC$PollResults = tLRPC$TL_messageMediaPoll.results;
        tLRPC$TL_updateMessagePoll.results = tLRPC$PollResults;
        tLRPC$TL_updateMessagePoll.poll_id = tLRPC$Poll.id;
        tLRPC$PollResults.flags = 30;
        arrayList.add(tLRPC$TL_updateMessagePoll);
        getMessagesController().processUpdateArray(arrayList, null, null, false, 0);
    }

    public int stopPoll(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (!(tLObject instanceof TLRPC$TL_messages_editMessage) || !(((TLRPC$TL_messages_editMessage) tLObject).media instanceof TLRPC$TL_inputMediaPoll)) {
            return 0;
        }
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda56
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$stopPoll$45(tLObject, requestDelegate);
            }
        });
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$stopPoll$45(org.rbmain.tgnet.TLObject r11, final org.rbmain.tgnet.RequestDelegate r12) {
        /*
            r10 = this;
            org.rbmain.tgnet.TLRPC$TL_messages_editMessage r11 = (org.rbmain.tgnet.TLRPC$TL_messages_editMessage) r11
            org.rbmain.tgnet.TLRPC$InputPeer r0 = r11.peer
            boolean r1 = r0 instanceof org.rbmain.tgnet.TLRPC$TL_inputPeerUser
            if (r1 == 0) goto Lc
            int r0 = r0.user_id
        La:
            long r0 = (long) r0
            goto L1d
        Lc:
            boolean r1 = r0 instanceof org.rbmain.tgnet.TLRPC$TL_inputPeerChat
            if (r1 == 0) goto L14
            int r0 = r0.chat_id
        L12:
            int r0 = -r0
            goto La
        L14:
            boolean r1 = r0 instanceof org.rbmain.tgnet.TLRPC$TL_inputPeerChannel
            if (r1 == 0) goto L1b
            int r0 = r0.channel_id
            goto L12
        L1b:
            r0 = 0
        L1d:
            androidMessenger.proxy.IdStorage r2 = androidMessenger.proxy.IdStorage.getInstance()
            java.lang.String r4 = r2.getDialogId(r0)
            ir.aaap.messengercore.CoreMainClass r0 = r10.getCoreMainClass()
            ir.aaap.messengercore.model.ChatAbsObject r0 = r0.getAbsInstant(r4)
            if (r0 != 0) goto L30
            return
        L30:
            long r6 = r11.id
            org.rbmain.tgnet.TLRPC$InputMedia r11 = r11.media
            org.rbmain.tgnet.TLRPC$TL_inputMediaPoll r11 = (org.rbmain.tgnet.TLRPC$TL_inputMediaPoll) r11
            org.rbmain.tgnet.TLRPC$Poll r11 = r11.poll
            long r1 = r11.id
            ir.aaap.messengercore.CoreMainClass r3 = r10.getCoreMainClass()
            ir.aaap.messengercore.model.ChatType r5 = r0.type
            androidMessenger.proxy.IdStorage r11 = androidMessenger.proxy.IdStorage.getInstance()
            java.lang.String r8 = r11.getPollId(r1)
            androidMessenger.proxy.MessageProxy$21 r9 = new androidMessenger.proxy.MessageProxy$21
            r9.<init>(r10)
            r3.stopPoll(r4, r5, r6, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidMessenger.proxy.MessageProxy.lambda$stopPoll$45(org.rbmain.tgnet.TLObject, org.rbmain.tgnet.RequestDelegate):void");
    }

    public int getPollResults(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (!(tLObject instanceof TLRPC$TL_messages_getPollVotes)) {
            return 0;
        }
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda53
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getPollResults$46(tLObject, requestDelegate);
            }
        });
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getPollResults$46(TLObject tLObject, final RequestDelegate requestDelegate) {
        TLRPC$TL_messages_getPollVotes tLRPC$TL_messages_getPollVotes = (TLRPC$TL_messages_getPollVotes) tLObject;
        getCoreMainClass().getPollOptionVoters(IdStorage.getInstance().getPollId(tLRPC$TL_messages_getPollVotes.poll_id), String.valueOf(tLRPC$TL_messages_getPollVotes.option[0] - 48), tLRPC$TL_messages_getPollVotes.offset, new LoadListener<PollModels.GetPollOptionVotersOutput>() { // from class: androidMessenger.proxy.MessageProxy.22
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(PollModels.GetPollOptionVotersOutput getPollOptionVotersOutput) {
                TLRPC$TL_messages_votesList tLRPC$TL_messages_votesList = new TLRPC$TL_messages_votesList();
                tLRPC$TL_messages_votesList.next_offset = getPollOptionVotersOutput.next_start_id;
                Iterator<ChatAbsObject> it = getPollOptionVotersOutput.voters_abs_objects.iterator();
                while (it.hasNext()) {
                    ChatAbsObject next = it.next();
                    TLRPC$User tLRPC$UserConvertUser = ChatConverter.convertUser(MessageProxy.this.getCoreMainClass(), IdStorage.getInstance().generateDialogId(next.object_guid), next, (UserInfo) null, (Chat) null);
                    TLRPC$TL_messageUserVote tLRPC$TL_messageUserVote = new TLRPC$TL_messageUserVote();
                    tLRPC$TL_messageUserVote.user_id = tLRPC$UserConvertUser.id;
                    tLRPC$TL_messages_votesList.users.add(tLRPC$UserConvertUser);
                    tLRPC$TL_messages_votesList.votes.add(tLRPC$TL_messageUserVote);
                }
                tLRPC$TL_messages_votesList.hasContinue = getPollOptionVotersOutput.has_continue;
                requestDelegate.run(tLRPC$TL_messages_votesList, null);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Couldn't Get Vote List" + exc.getMessage();
                requestDelegate.run(null, tLRPC$TL_error);
            }
        });
    }

    public void proxyFailedMessages(LoadMessagesResult loadMessagesResult) {
        Object obj = loadMessagesResult.extraInfo;
        if (obj instanceof ExtraInfo) {
            final ExtraInfo extraInfo = (ExtraInfo) obj;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda24
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$proxyFailedMessages$47(extraInfo);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$proxyFailedMessages$47(ExtraInfo extraInfo) {
        getNotificationCenter().postNotificationName(NotificationCenter.messagesDidFailed, Integer.valueOf(extraInfo.classGuid), extraInfo);
    }

    public void proxyFailedMessages(LoadMessagesIntervalResult loadMessagesIntervalResult) {
        Object obj = loadMessagesIntervalResult.extraInfo;
        if (obj instanceof ExtraInfo) {
            final ExtraInfo extraInfo = (ExtraInfo) obj;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda25
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$proxyFailedMessages$48(extraInfo);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$proxyFailedMessages$48(ExtraInfo extraInfo) {
        getNotificationCenter().postNotificationName(NotificationCenter.messagesDidFailed, Integer.valueOf(extraInfo.classGuid), extraInfo);
    }

    public int setCurrentLiveLocation(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (!(tLObject instanceof TLRPC$TL_messages_editMessage) || !(((TLRPC$TL_messages_editMessage) tLObject).media instanceof TLRPC$TL_inputMediaGeoLive)) {
            return -1;
        }
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda46
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setCurrentLiveLocation$49(tLObject, requestDelegate);
            }
        });
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setCurrentLiveLocation$49(TLObject tLObject, final RequestDelegate requestDelegate) {
        TLRPC$TL_messages_editMessage tLRPC$TL_messages_editMessage = (TLRPC$TL_messages_editMessage) tLObject;
        TLRPC$InputGeoPoint tLRPC$InputGeoPoint = tLRPC$TL_messages_editMessage.media.geo_point;
        TLRPC$InputPeer tLRPC$InputPeer = tLRPC$TL_messages_editMessage.peer;
        if (tLRPC$InputPeer instanceof TLRPC$TL_inputPeerUser) {
            int i = tLRPC$InputPeer.user_id;
        } else if (tLRPC$InputPeer instanceof TLRPC$TL_inputPeerChat) {
            int i2 = tLRPC$InputPeer.chat_id;
        } else if (tLRPC$InputPeer instanceof TLRPC$TL_inputPeerChannel) {
            int i3 = tLRPC$InputPeer.channel_id;
        }
        long j = tLRPC$TL_messages_editMessage.id;
        getCoreMainClass().setCurrentLiveLocation(tLRPC$InputGeoPoint.lat, tLRPC$InputGeoPoint._long, new LoadListener<Integer>(this) { // from class: androidMessenger.proxy.MessageProxy.23
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(Integer num) {
                requestDelegate.run(new TLRPC$TL_updates(), null);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Couldn't Set Current Live Location: " + exc.getMessage();
                requestDelegate.run(null, tLRPC$TL_error);
            }
        });
    }

    public int stopLiveLocation(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (!(tLObject instanceof TLRPC$TL_messages_editMessage) || !(((TLRPC$TL_messages_editMessage) tLObject).media instanceof TLRPC$TL_inputMediaGeoLive)) {
            return -1;
        }
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda63
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$stopLiveLocation$50(tLObject, requestDelegate);
            }
        });
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$stopLiveLocation$50(TLObject tLObject, final RequestDelegate requestDelegate) {
        long j;
        int i;
        int i2;
        TLRPC$TL_messages_editMessage tLRPC$TL_messages_editMessage = (TLRPC$TL_messages_editMessage) tLObject;
        TLRPC$InputPeer tLRPC$InputPeer = tLRPC$TL_messages_editMessage.peer;
        if (tLRPC$InputPeer instanceof TLRPC$TL_inputPeerUser) {
            i2 = tLRPC$InputPeer.user_id;
        } else {
            if (tLRPC$InputPeer instanceof TLRPC$TL_inputPeerChat) {
                i = tLRPC$InputPeer.chat_id;
            } else if (tLRPC$InputPeer instanceof TLRPC$TL_inputPeerChannel) {
                i = tLRPC$InputPeer.channel_id;
            } else {
                j = 0;
                String dialogId = IdStorage.getInstance().getDialogId(j);
                long j2 = tLRPC$TL_messages_editMessage.id;
                final TLRPC$Message tLRPC$Message = tLRPC$TL_messages_editMessage.messageOwner;
                getCoreMainClass().stopLiveLocation(dialogId, j2, ((TLRPC$TL_messageMediaGeoLive) tLRPC$Message.media).live_loc_track_id, new LoadListener<LiveLocationObject>(this) { // from class: androidMessenger.proxy.MessageProxy.24
                    @Override // ir.aaap.messengercore.LoadListener
                    public void onDidLoad(LiveLocationObject liveLocationObject) {
                        tLRPC$Message.media = MessageConverter.convertToTLLiveLocation(liveLocationObject);
                        tLRPC$Message.edit_date = (int) liveLocationObject.last_update_time;
                        TLRPC$TL_updates tLRPC$TL_updates = new TLRPC$TL_updates();
                        ArrayList<TLRPC$Update> arrayList = new ArrayList<>();
                        if (tLRPC$Message.dialog_id < 0) {
                            TLRPC$TL_updateEditChannelMessage tLRPC$TL_updateEditChannelMessage = new TLRPC$TL_updateEditChannelMessage();
                            tLRPC$TL_updateEditChannelMessage.message = tLRPC$Message;
                            arrayList.add(tLRPC$TL_updateEditChannelMessage);
                        } else {
                            TLRPC$TL_updateEditMessage tLRPC$TL_updateEditMessage = new TLRPC$TL_updateEditMessage();
                            tLRPC$TL_updateEditMessage.message = tLRPC$Message;
                            arrayList.add(tLRPC$TL_updateEditMessage);
                        }
                        tLRPC$TL_updates.updates = arrayList;
                        requestDelegate.run(tLRPC$TL_updates, null);
                    }

                    @Override // ir.aaap.messengercore.LoadListener
                    public void onError(Exception exc) {
                        TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                        tLRPC$TL_error.text = "Couldn't Set Current Live Location: " + exc.getMessage();
                        requestDelegate.run(null, tLRPC$TL_error);
                    }
                });
            }
            i2 = -i;
        }
        j = i2;
        String dialogId2 = IdStorage.getInstance().getDialogId(j);
        long j22 = tLRPC$TL_messages_editMessage.id;
        final TLRPC$Message tLRPC$Message2 = tLRPC$TL_messages_editMessage.messageOwner;
        getCoreMainClass().stopLiveLocation(dialogId2, j22, ((TLRPC$TL_messageMediaGeoLive) tLRPC$Message2.media).live_loc_track_id, new LoadListener<LiveLocationObject>(this) { // from class: androidMessenger.proxy.MessageProxy.24
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(LiveLocationObject liveLocationObject) {
                tLRPC$Message2.media = MessageConverter.convertToTLLiveLocation(liveLocationObject);
                tLRPC$Message2.edit_date = (int) liveLocationObject.last_update_time;
                TLRPC$TL_updates tLRPC$TL_updates = new TLRPC$TL_updates();
                ArrayList<TLRPC$Update> arrayList = new ArrayList<>();
                if (tLRPC$Message2.dialog_id < 0) {
                    TLRPC$TL_updateEditChannelMessage tLRPC$TL_updateEditChannelMessage = new TLRPC$TL_updateEditChannelMessage();
                    tLRPC$TL_updateEditChannelMessage.message = tLRPC$Message2;
                    arrayList.add(tLRPC$TL_updateEditChannelMessage);
                } else {
                    TLRPC$TL_updateEditMessage tLRPC$TL_updateEditMessage = new TLRPC$TL_updateEditMessage();
                    tLRPC$TL_updateEditMessage.message = tLRPC$Message2;
                    arrayList.add(tLRPC$TL_updateEditMessage);
                }
                tLRPC$TL_updates.updates = arrayList;
                requestDelegate.run(tLRPC$TL_updates, null);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Couldn't Set Current Live Location: " + exc.getMessage();
                requestDelegate.run(null, tLRPC$TL_error);
            }
        });
    }

    public void requestLiveLocationUpdate(TLRPC$Message tLRPC$Message, long j) {
        if (tLRPC$Message.date + tLRPC$Message.media.period > ((int) (getCoreMainClass().getTimeMillis() / 1000)) && System.currentTimeMillis() - tLRPC$Message.lastTimeLocationUpdated >= j) {
            tLRPC$Message.lastTimeLocationUpdated = System.currentTimeMillis();
            getLiveLocationStatus(tLRPC$Message);
        }
    }

    public void getLiveLocationStatus(final TLRPC$Message tLRPC$Message) {
        if (tLRPC$Message.media instanceof TLRPC$TL_messageMediaGeoLive) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda71
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$getLiveLocationStatus$51(tLRPC$Message);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getLiveLocationStatus$51(final TLRPC$Message tLRPC$Message) {
        if (getCoreMainClass().equalsCurrentDeviceHash(((TLRPC$TL_messageMediaGeoLive) tLRPC$Message.media).device_hash)) {
            return;
        }
        getCoreMainClass().getCurrentLiveLocation(IdStorage.getInstance().getDialogId(tLRPC$Message.dialog_id), tLRPC$Message.id, ((TLRPC$TL_messageMediaGeoLive) tLRPC$Message.media).live_loc_track_id, new LoadListener<LiveLocationObject>() { // from class: androidMessenger.proxy.MessageProxy.25
            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(LiveLocationObject liveLocationObject) throws InterruptedException {
                tLRPC$Message.media = MessageConverter.convertToTLLiveLocation(liveLocationObject);
                tLRPC$Message.edit_date = (int) liveLocationObject.last_update_time;
                ArrayList<TLRPC$Update> arrayList = new ArrayList<>();
                if (tLRPC$Message.dialog_id < 0) {
                    TLRPC$TL_updateEditChannelMessage tLRPC$TL_updateEditChannelMessage = new TLRPC$TL_updateEditChannelMessage();
                    tLRPC$TL_updateEditChannelMessage.message = tLRPC$Message;
                    arrayList.add(tLRPC$TL_updateEditChannelMessage);
                } else {
                    TLRPC$TL_updateEditMessage tLRPC$TL_updateEditMessage = new TLRPC$TL_updateEditMessage();
                    tLRPC$TL_updateEditMessage.message = tLRPC$Message;
                    arrayList.add(tLRPC$TL_updateEditMessage);
                }
                MessageProxy.this.getMessagesController().processUpdateArray(arrayList, null, null, false, 0);
            }
        });
    }

    public void saveSharingLocation(final LocationController.SharingLocationInfo sharingLocationInfo, final int i) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda44
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$saveSharingLocation$52(sharingLocationInfo, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveSharingLocation$52(LocationController.SharingLocationInfo sharingLocationInfo, int i) {
        LiveLocationInfo liveLocationInfoConvertLiveLocationInfo = MessageConverter.convertLiveLocationInfo(getCoreMainClass(), sharingLocationInfo);
        if (i == 0) {
            getCoreMainClass().addLiveLocationInfo(liveLocationInfoConvertLiveLocationInfo);
        } else if (i == 1) {
            getCoreMainClass().removeLiveLocationInfo(liveLocationInfoConvertLiveLocationInfo);
        } else if (i == 2) {
            getCoreMainClass().removeAllLiveLocationInfo();
        }
    }

    public void startLive(final long j, final String str, final String str2, final boolean z, final LoadListener<LiveModels.SendLiveResult> loadListener) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda18
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$startLive$53(j, str2, str, z, loadListener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startLive$53(long j, String str, String str2, boolean z, LoadListener loadListener) {
        getCoreMainClass().sendLive(IdStorage.getInstance().getDialogId(j), str, str2, z, loadListener);
    }

    public void stopLive(final String str) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda31
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$stopLive$54(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$stopLive$54(String str) {
        getCoreMainClass().stopLive(str);
    }

    public void addLiveComment(final String str, final String str2, final String str3, final LoadListener<TLRPC$TL_LiveComment> loadListener) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda37
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$addLiveComment$55(str, str2, str3, loadListener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addLiveComment$55(String str, String str2, String str3, final LoadListener loadListener) {
        getCoreMainClass().addLiveComment(str, str2, str3, new LoadListener<LiveModels.AddLiveCommentOutput>() { // from class: androidMessenger.proxy.MessageProxy.26
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(LiveModels.AddLiveCommentOutput addLiveCommentOutput) {
                TLRPC$TL_LiveComment tLRPC$TL_LiveCommentConvertLiveCommentToTlObject = (addLiveCommentOutput == null || addLiveCommentOutput.live_comment == null) ? null : ChatConverter.convertLiveCommentToTlObject(MessageProxy.this.getCoreMainClass(), addLiveCommentOutput.live_comment);
                LoadListener loadListener2 = loadListener;
                if (loadListener2 != null) {
                    loadListener2.onDidLoad(tLRPC$TL_LiveCommentConvertLiveCommentToTlObject);
                }
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                LoadListener loadListener2 = loadListener;
                if (loadListener2 != null) {
                    loadListener2.onError(exc);
                }
            }
        });
    }

    public void getLiveComments(final String str, final String str2, final String str3, final LoadListener<TLRPC$TL_GetLiveCommentResult> loadListener) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda36
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getLiveComments$56(str, str2, str3, loadListener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getLiveComments$56(String str, String str2, String str3, final LoadListener loadListener) {
        getCoreMainClass().getLiveComments(str, str2, str3, new LoadListener<LiveModels.GetLiveCommentsOutput>() { // from class: androidMessenger.proxy.MessageProxy.27
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(LiveModels.GetLiveCommentsOutput getLiveCommentsOutput) {
                TLRPC$TL_GetLiveCommentResult tLRPC$TL_GetLiveCommentResultCovertAllLiveComments = ChatConverter.covertAllLiveComments(MessageProxy.this.getCoreMainClass(), getLiveCommentsOutput);
                LoadListener loadListener2 = loadListener;
                if (loadListener2 != null) {
                    loadListener2.onDidLoad(tLRPC$TL_GetLiveCommentResultCovertAllLiveComments);
                }
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                LoadListener loadListener2 = loadListener;
                if (loadListener2 != null) {
                    loadListener2.onError(exc);
                }
            }
        });
    }

    public void requestLiveUpdate(final String str, final String str2, final boolean z) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda38
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$requestLiveUpdate$57(str, str2, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestLiveUpdate$57(String str, String str2, boolean z) {
        getCoreMainClass().getLiveStatus(str, str2, z ? LiveModels.GetLiveStatusType.MessageStat : LiveModels.GetLiveStatusType.LiveViewer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$proxyLiveStatus$58(String str, LiveModels.LiveStatus liveStatus) {
        getNotificationCenter().postNotificationName(NotificationCenter.liveStatusChanged, str, liveStatus);
    }

    public void proxyLiveStatus(final String str, final LiveModels.LiveStatus liveStatus) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda35
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$proxyLiveStatus$58(str, liveStatus);
            }
        });
    }

    public void proxyNewNotification(final boolean z, boolean z2, final ArrayList<NotificationModels.ShowNotificationObject> arrayList, final ArrayList<NotificationModels.ShowNotificationObject> arrayList2, final ArrayList<NotificationModels.ShowNotificationObject> arrayList3) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda43
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$proxyNewNotification$59(arrayList, z, arrayList2, arrayList3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$proxyNewNotification$59(ArrayList arrayList, boolean z, ArrayList arrayList2, ArrayList arrayList3) {
        ArrayList arrayList4 = new ArrayList();
        if (arrayList != null && arrayList.size() > 0) {
            arrayList4.addAll(arrayList);
        }
        if (arrayList4.size() > 0) {
            ArrayList<MessageObject> arrayList5 = new ArrayList<>();
            Iterator it = arrayList4.iterator();
            while (it.hasNext()) {
                NotificationModels.ShowNotificationObject showNotificationObject = (NotificationModels.ShowNotificationObject) it.next();
                if (showNotificationObject.type == NotificationModels.ShowNotificationTypeEnum.Other) {
                    if (showNotificationObject.other_data != null && showNotificationObject.notification_id != null) {
                        getNotificationsController().createNotificationWithLink(z, showNotificationObject.title, showNotificationObject.text, getMessengerLinkHandler().convertToMessengerAppLink(showNotificationObject.other_data.notif_link), showNotificationObject.notification_id.hashCode(), NotificationsController.groupNameGeneral);
                    }
                } else {
                    MessageObject messageObjectConvertNotificationMessage = MessageConverter.convertNotificationMessage(this.currentAccount, showNotificationObject);
                    if (messageObjectConvertNotificationMessage != null) {
                        arrayList5.add(messageObjectConvertNotificationMessage);
                    }
                }
            }
            if (arrayList5.size() > 0) {
                getNotificationsController().processNewMessages(arrayList5, true, true, null);
            }
        }
        if (arrayList2 != null && arrayList2.size() > 0) {
            LongSparseArray<ArrayList<MessageObject>> longSparseArray = new LongSparseArray<>();
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                MessageObject messageObjectConvertNotificationMessage2 = MessageConverter.convertNotificationMessage(this.currentAccount, (NotificationModels.ShowNotificationObject) it2.next());
                if (messageObjectConvertNotificationMessage2 != null) {
                    ArrayList<MessageObject> arrayList6 = longSparseArray.get(messageObjectConvertNotificationMessage2.getDialogId());
                    if (arrayList6 == null) {
                        arrayList6 = new ArrayList<>();
                        longSparseArray.put(messageObjectConvertNotificationMessage2.getDialogId(), arrayList6);
                    }
                    arrayList6.add(messageObjectConvertNotificationMessage2);
                }
            }
            getNotificationsController().processEditedMessages(longSparseArray);
        }
        if (arrayList3 == null || arrayList3.size() <= 0) {
            return;
        }
        LongSparseArray<ArrayList<Long>> longSparseArray2 = new LongSparseArray<>(0);
        Iterator it3 = arrayList3.iterator();
        while (it3.hasNext()) {
            NotificationModels.ShowNotificationObject showNotificationObject2 = (NotificationModels.ShowNotificationObject) it3.next();
            MessageObject messageObjectConvertNotificationMessage3 = MessageConverter.convertNotificationMessage(this.currentAccount, showNotificationObject2);
            if (messageObjectConvertNotificationMessage3 != null) {
                long j = -messageObjectConvertNotificationMessage3.messageOwner.peer_id.channel_id;
                ArrayList<Long> arrayList7 = longSparseArray2.get(j);
                if (arrayList7 == null) {
                    arrayList7 = new ArrayList<>();
                    longSparseArray2.put(j, arrayList7);
                }
                NotificationModels.ShowNotificationTypeEnum showNotificationTypeEnum = showNotificationObject2.type;
                if (showNotificationTypeEnum == NotificationModels.ShowNotificationTypeEnum.Message || showNotificationTypeEnum == NotificationModels.ShowNotificationTypeEnum.NotMessage) {
                    arrayList7.add(Long.valueOf(messageObjectConvertNotificationMessage3.messageOwner.id));
                }
            }
        }
        if (longSparseArray2.size() > 0) {
            getNotificationsController().removeDeletedMessagesFromNotifications(longSparseArray2, false);
        }
    }

    public void getMessageUrl(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_channels_exportMessageLink) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda48
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$getMessageUrl$60(tLObject, requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getMessageUrl$60(TLObject tLObject, final RequestDelegate requestDelegate) {
        getCoreMainClass().getMessageShareUrl(IdStorage.getInstance().getDialogId(-r5.channel.channel_id), ((TLRPC$TL_channels_exportMessageLink) tLObject).id, new LoadListener<GetMessageShareUrlOutput>(this) { // from class: androidMessenger.proxy.MessageProxy.28
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(GetMessageShareUrlOutput getMessageShareUrlOutput) {
                TLRPC$TL_error tLRPC$TL_error;
                TLRPC$TL_exportedMessageLink tLRPC$TL_exportedMessageLink = null;
                if (getMessageShareUrlOutput.has_share_url) {
                    TLRPC$TL_exportedMessageLink tLRPC$TL_exportedMessageLink2 = new TLRPC$TL_exportedMessageLink();
                    tLRPC$TL_exportedMessageLink2.link = getMessageShareUrlOutput.share_url;
                    tLRPC$TL_error = null;
                    tLRPC$TL_exportedMessageLink = tLRPC$TL_exportedMessageLink2;
                } else {
                    tLRPC$TL_error = new TLRPC$TL_error();
                    tLRPC$TL_error.text = "Doesn't have share url";
                }
                requestDelegate.run(tLRPC$TL_exportedMessageLink, tLRPC$TL_error);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Failed To Get url";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        });
    }

    public boolean handleIntent(LaunchActivity launchActivity, Intent intent) {
        MyLog.e("arg", "arg=" + intent.getStringExtra("arg") + "   ");
        if (intent.hasExtra("link")) {
            String stringExtra = intent.getStringExtra("link");
            if (stringExtra == null) {
                return false;
            }
            Link link = (Link) ApplicationLoader.getGson().fromJson(stringExtra, Link.class);
            Log.d("TTTT", "Link: " + link);
            if (link == null) {
                return false;
            }
            MessengerLinkHandler.getInstance(this.currentAccount).onLinkClick(launchActivity.getLastFragment(), link);
            return false;
        }
        if (!intent.hasExtra("arg")) {
            return false;
        }
        MyLog.e("arg", "arg=" + intent.getStringExtra("arg") + "   ");
        PushNotificationObject pushNotificationObject = (PushNotificationObject) ApplicationLoader.getGson().fromJson(intent.getStringExtra("arg"), PushNotificationObject.class);
        if (pushNotificationObject == null || pushNotificationObject.link == null) {
            return true;
        }
        MessengerLinkHandler.getInstance(this.currentAccount).onLinkClick(launchActivity.getLastFragment(), pushNotificationObject.link);
        return true;
    }

    public void proxyLoadedNotifications(final ArrayList<NotificationModels.ShowNotificationObject> arrayList) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda39
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$proxyLoadedNotifications$62(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$proxyLoadedNotifications$62(ArrayList arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        final ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            NotificationModels.ShowNotificationObject showNotificationObject = (NotificationModels.ShowNotificationObject) it.next();
            if (showNotificationObject.type == NotificationModels.ShowNotificationTypeEnum.Other) {
                if (showNotificationObject.other_data != null && showNotificationObject.notification_id != null) {
                    getNotificationsController().createNotificationWithLink(false, showNotificationObject.title, showNotificationObject.text, getMessengerLinkHandler().convertToMessengerAppLink(showNotificationObject.other_data.notif_link), showNotificationObject.notification_id.hashCode(), NotificationsController.groupNameGeneral);
                }
            } else {
                MessageObject messageObjectConvertNotificationMessage = MessageConverter.convertNotificationMessage(this.currentAccount, showNotificationObject);
                if (messageObjectConvertNotificationMessage != null) {
                    arrayList2.add(messageObjectConvertNotificationMessage);
                }
            }
        }
        if (arrayList2.size() > 0) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda40
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$proxyLoadedNotifications$61(arrayList2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$proxyLoadedNotifications$61(ArrayList arrayList) {
        getNotificationsController().processLoadedUnreadMessages(new LongSparseArray<>(), null, arrayList, null, null, null);
    }

    public void loadAllNotification() {
        ApplicationLoader.checkAndinitHandler();
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadAllNotification$63();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadAllNotification$63() {
        int i = this.counter;
        if (i < 1) {
            this.counter = i + 1;
            getCoreMainClass().loadAllNotificationsFromDb();
        }
    }

    public int getCalls(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (!(tLObject instanceof TLRPC$TL_messages_search) || !(((TLRPC$TL_messages_search) tLObject).filter instanceof TLRPC$TL_inputMessagesFilterPhoneCalls)) {
            return 0;
        }
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda60
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getCalls$64(tLObject, requestDelegate);
            }
        });
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getCalls$64(TLObject tLObject, final RequestDelegate requestDelegate) {
        getCoreMainClass().getCalls(true, ((TLRPC$TL_messages_search) tLObject).nextStartId, VoiceCallModels.FilterTypeEnum.All, new LoadListener<VoiceCallModels.GetCallsOutput>() { // from class: androidMessenger.proxy.MessageProxy.29
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(VoiceCallModels.GetCallsOutput getCallsOutput) {
                TLRPC$TL_messages_messages tLRPC$TL_messages_messages = new TLRPC$TL_messages_messages();
                tLRPC$TL_messages_messages.hasContinue = getCallsOutput.has_continue;
                tLRPC$TL_messages_messages.messages = MessageConverter.convertAllCallMessages(MessageProxy.this.getCoreMainClass(), getCallsOutput.calls, tLRPC$TL_messages_messages.users);
                tLRPC$TL_messages_messages.users.add(UserConfig.getInstance(((BaseController) MessageProxy.this).currentAccount).getCurrentUser());
                tLRPC$TL_messages_messages.nextStartId = getCallsOutput.new_max_id;
                requestDelegate.run(tLRPC$TL_messages_messages, null);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Failed to get calls";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        });
    }

    public void proxyClientShowMessageFromCore(Object obj) {
        MessangerOutput.ClientShowMessage clientShowMessage;
        try {
            clientShowMessage = (MessangerOutput.ClientShowMessage) new Gson().fromJson(((JSONObject) obj).toString(), MessangerOutput.ClientShowMessage.class);
        } catch (Exception unused) {
            clientShowMessage = null;
        }
        if (clientShowMessage != null) {
            handleClientShowMessage(clientShowMessage);
        }
    }

    public void handleClientShowMessage(final MessangerOutput.ClientShowMessage clientShowMessage) {
        if (clientShowMessage == null) {
            return;
        }
        String str = clientShowMessage.unique_id;
        if (str != null && !str.isEmpty()) {
            if (showedClientMessagesIds.contains(clientShowMessage.unique_id)) {
                return;
            } else {
                showedClientMessagesIds.add(clientShowMessage.unique_id);
            }
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda28
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$handleClientShowMessage$65(clientShowMessage);
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleClientShowMessage$65(MessangerOutput.ClientShowMessage clientShowMessage) {
        getMessengerLinkHandler().lambda$showDialogWithLink$30(clientShowMessage.link);
    }

    public void proxyNetworkError(ApiServerException apiServerException, Object obj) {
        Link.AlertData alertData;
        ApiServerException.EnumStatus enumStatus = apiServerException.status;
        ApiServerException.EnumStatusDet enumStatusDet = apiServerException.status_det;
        if (enumStatus == null || enumStatusDet == null) {
            return;
        }
        Runnable runnable = null;
        if (obj != null) {
            try {
                alertData = (Link.AlertData) new Gson().fromJson(((JSONObject) obj).toString(), Link.AlertData.class);
            } catch (Exception unused) {
            }
        } else {
            alertData = null;
        }
        if (alertData != null && (enumStatus == ApiServerException.EnumStatus.ERROR_MESSAGE_IGN || enumStatus == ApiServerException.EnumStatus.ERROR_MESSAGE_TRY)) {
            final Link link = new Link();
            link.type = Link.LinkTypeEnum.alert;
            link.alert_data = alertData;
            runnable = new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda30
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$proxyNetworkError$66(link);
                }
            };
        } else if (enumStatus == ApiServerException.EnumStatus.ERROR_GENERIC && enumStatusDet == ApiServerException.EnumStatusDet.TOO_REQUESTS) {
            runnable = new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda76
                @Override // java.lang.Runnable
                public final void run() {
                    MessageProxy.lambda$proxyNetworkError$67();
                }
            };
        }
        if (runnable != null) {
            AndroidUtilities.runOnUIThread(runnable, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$proxyNetworkError$66(Link link) {
        getMessengerLinkHandler().lambda$showDialogWithLink$30(link);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$proxyNetworkError$67() {
        AlertsCreator.showSimpleToast(null, LocaleController.getString("ErrorTooRequest", R.string.ErrorTooRequest));
    }

    public Observable<Integer> loadStoryFromServer(final ArrayList<MessageObject> arrayList) {
        final HashMap map = new HashMap();
        final ArrayList arrayList2 = new ArrayList();
        final ArrayList arrayList3 = new ArrayList();
        final int[] iArr = {0};
        final HashMap map2 = new HashMap();
        final HashSet hashSet = new HashSet();
        return Observable.just(1).observeOn(Schedulers.computation()).flatMap(new Function() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$loadStoryFromServer$68(arrayList, hashSet, map2, arrayList2, map, (Integer) obj);
            }
        }).flatMap(new Function() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$loadStoryFromServer$69(map, arrayList3, iArr, arrayList2, hashSet, (GetProfilesStoryListOutput) obj);
            }
        }).observeOn(AndroidSchedulers.mainThread());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Observable lambda$loadStoryFromServer$68(ArrayList arrayList, Set set, Map map, ArrayList arrayList2, HashMap map2, Integer num) throws Exception {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            MessageObject messageObject = (MessageObject) arrayList.get(size);
            if (messageObject.type == 125 && messageObject.isRubinoStory()) {
                RubinoStoryData rubinoStoryData = ((TLRPC$TL_messageMediaRubinoStory) messageObject.messageOwner.media).rubinoStoryData;
                if (set.size() < 25) {
                    StoryProfileStoryId storyProfileStoryId = (StoryProfileStoryId) map.get(rubinoStoryData.story_profile_id);
                    if (storyProfileStoryId == null) {
                        storyProfileStoryId = new StoryProfileStoryId(rubinoStoryData.story_profile_id);
                        map.put(rubinoStoryData.story_profile_id, storyProfileStoryId);
                    }
                    storyProfileStoryId.story_ids.add(rubinoStoryData.story_id);
                    set.add(rubinoStoryData.story_id);
                    arrayList2.add(messageObject);
                    ArrayList arrayList3 = (ArrayList) map2.get(rubinoStoryData.story_id);
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList();
                        map2.put(rubinoStoryData.story_id, arrayList3);
                    }
                    arrayList3.add(messageObject);
                }
            }
        }
        if (map.size() > 0) {
            return loadRubinoStoryFromServer(map);
        }
        return Observable.just(new GetProfilesStoryListOutput());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Observable lambda$loadStoryFromServer$69(HashMap map, ArrayList arrayList, int[] iArr, ArrayList arrayList2, Set set, GetProfilesStoryListOutput getProfilesStoryListOutput) throws Exception {
        HashSet hashSet = new HashSet();
        ArrayList<StoryObject> arrayList3 = getProfilesStoryListOutput.stories;
        ArrayList<RubinoProfileObject> arrayList4 = getProfilesStoryListOutput.profiles;
        if (arrayList3 != null && arrayList4 != null) {
            HashMap map2 = new HashMap();
            Iterator<RubinoProfileObject> it = arrayList4.iterator();
            while (it.hasNext()) {
                RubinoProfileObject next = it.next();
                map2.put(next.id, next);
            }
            int size = arrayList3.size();
            for (int i = 0; i < size; i++) {
                StoryObject storyObject = arrayList3.get(i);
                hashSet.add(storyObject.id);
                ArrayList arrayList5 = (ArrayList) map.get(storyObject.id);
                if (arrayList5 != null) {
                    Iterator it2 = arrayList5.iterator();
                    while (it2.hasNext()) {
                        MessageObject messageObject = (MessageObject) it2.next();
                        RubinoStoryData rubinoStoryData = ((TLRPC$TL_messageMediaRubinoStory) messageObject.messageOwner.media).rubinoStoryData;
                        if (storyObject.id.equals(rubinoStoryData.story_id)) {
                            rubinoStoryData.storyObject = storyObject;
                            rubinoStoryData.profileObject = (RubinoProfileObject) map2.get(rubinoStoryData.story_profile_id);
                            messageObject.forceUpdate = true;
                            arrayList.add(messageObject);
                            iArr[0] = iArr[0] + 1;
                        }
                    }
                }
            }
        }
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            MessageObject messageObject2 = (MessageObject) it3.next();
            RubinoStoryData rubinoStoryData2 = ((TLRPC$TL_messageMediaRubinoStory) messageObject2.messageOwner.media).rubinoStoryData;
            if (set.contains(rubinoStoryData2.story_id) && !hashSet.contains(rubinoStoryData2.story_id)) {
                messageObject2.forceUpdate = true;
                rubinoStoryData2.is_error = true;
                rubinoStoryData2.storyObject = null;
                rubinoStoryData2.profileObject = null;
                arrayList.add(messageObject2);
                iArr[0] = iArr[0] + 1;
            }
        }
        try {
            if (arrayList.size() > 0) {
                Iterator it4 = arrayList.iterator();
                while (it4.hasNext()) {
                    MessageObject messageObject3 = (MessageObject) it4.next();
                    String dialogId = IdStorage.getInstance().getDialogId(messageObject3.getDialogId());
                    if (!TextUtils.isEmpty(dialogId)) {
                        getCoreMainClass().updateMessageRubinoStory(dialogId, messageObject3.getId(), (ir.aaap.messengercore.model.RubinoStoryData) Utils.convertObjectToMap(((TLRPC$TL_messageMediaRubinoStory) messageObject3.messageOwner.media).rubinoStoryData, ir.aaap.messengercore.model.RubinoStoryData.class));
                    }
                }
            }
        } catch (Exception e) {
            ir.resaneh1.iptv.logger.MyLog.handleException(e);
        }
        return Observable.just(Integer.valueOf(iArr[0]));
    }

    private Observable<GetProfilesStoryListOutput> loadRubinoStoryFromServer(Map<String, StoryProfileStoryId> map) {
        if (map == null || map.isEmpty()) {
            return Observable.just(new GetProfilesStoryListOutput());
        }
        return StoryController.getInstance(this.currentAccount).getProfilesStoryListObservableForMessenger(map.values());
    }

    public Observable<Integer> loadRubinoPostFromServer(final ArrayList<MessageObject> arrayList) {
        final HashMap map = new HashMap();
        final ArrayList arrayList2 = new ArrayList();
        final ArrayList arrayList3 = new ArrayList();
        final int[] iArr = {0};
        final HashMap map2 = new HashMap();
        final HashSet hashSet = new HashSet();
        return Observable.just(1).observeOn(Schedulers.computation()).flatMap(new Function() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$loadRubinoPostFromServer$70(arrayList, arrayList3, iArr, hashSet, map2, arrayList2, map, (Integer) obj);
            }
        }).flatMap(new Function() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$loadRubinoPostFromServer$71(map, arrayList3, iArr, arrayList2, hashSet, (ArrayList) obj);
            }
        }).observeOn(AndroidSchedulers.mainThread());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Observable lambda$loadRubinoPostFromServer$70(ArrayList arrayList, ArrayList arrayList2, int[] iArr, Set set, Map map, ArrayList arrayList3, HashMap map2, Integer num) throws Exception {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            MessageObject messageObject = (MessageObject) arrayList.get(size);
            if (messageObject.type == 124 && messageObject.isRubinoPost()) {
                RubinoPostData rubinoPostData = ((TLRPC$TL_messageMediaRubinoPost) messageObject.messageOwner.media).rubinoPostData;
                RubinoPostObject fromPostMapIfExist = RubinoController.getInstance(this.currentAccount).getFromPostMapIfExist(rubinoPostData.post_id);
                if (fromPostMapIfExist != null) {
                    rubinoPostData.rubinoPostObject = fromPostMapIfExist;
                    rubinoPostData.rubinoPost = fromPostMapIfExist.post;
                    messageObject.forceUpdate = true;
                    arrayList2.add(messageObject);
                    iArr[0] = iArr[0] + 1;
                } else if (set.size() < 25) {
                    Rubino.RubinoProfilePostId rubinoProfilePostId = (Rubino.RubinoProfilePostId) map.get(rubinoPostData.post_profile_id);
                    if (rubinoProfilePostId == null) {
                        rubinoProfilePostId = new Rubino.RubinoProfilePostId(rubinoPostData.post_profile_id);
                        map.put(rubinoPostData.post_profile_id, rubinoProfilePostId);
                    }
                    rubinoProfilePostId.post_ids.add(rubinoPostData.post_id);
                    set.add(rubinoPostData.post_id);
                    arrayList3.add(messageObject);
                    ArrayList arrayList4 = (ArrayList) map2.get(rubinoPostData.post_id);
                    if (arrayList4 == null) {
                        arrayList4 = new ArrayList();
                        map2.put(rubinoPostData.post_id, arrayList4);
                    }
                    arrayList4.add(messageObject);
                }
            }
        }
        if (map.size() > 0) {
            return loadRubinoPostsFromServer(map);
        }
        return Observable.just(new ArrayList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Observable lambda$loadRubinoPostFromServer$71(HashMap map, ArrayList arrayList, int[] iArr, ArrayList arrayList2, Set set, ArrayList arrayList3) throws Exception {
        HashSet hashSet = new HashSet();
        if (arrayList3 != null) {
            int size = arrayList3.size();
            for (int i = 0; i < size; i++) {
                RubinoPostObject rubinoPostObject = (RubinoPostObject) arrayList3.get(i);
                hashSet.add(rubinoPostObject.post.id);
                ArrayList arrayList4 = (ArrayList) map.get(rubinoPostObject.post.id);
                if (arrayList4 != null) {
                    Iterator it = arrayList4.iterator();
                    while (it.hasNext()) {
                        MessageObject messageObject = (MessageObject) it.next();
                        RubinoPostData rubinoPostData = ((TLRPC$TL_messageMediaRubinoPost) messageObject.messageOwner.media).rubinoPostData;
                        if (rubinoPostObject.post.id.equals(rubinoPostData.post_id)) {
                            rubinoPostData.rubinoPost = rubinoPostObject.post;
                            rubinoPostData.rubinoPostObject = rubinoPostObject;
                            messageObject.forceUpdate = true;
                            arrayList.add(messageObject);
                            iArr[0] = iArr[0] + 1;
                        }
                    }
                }
            }
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            MessageObject messageObject2 = (MessageObject) it2.next();
            RubinoPostData rubinoPostData2 = ((TLRPC$TL_messageMediaRubinoPost) messageObject2.messageOwner.media).rubinoPostData;
            if (set.contains(rubinoPostData2.post_id) && !hashSet.contains(rubinoPostData2.post_id)) {
                messageObject2.forceUpdate = true;
                rubinoPostData2.is_error = true;
                rubinoPostData2.rubinoPost = null;
                rubinoPostData2.rubinoPostObject = null;
                arrayList.add(messageObject2);
                iArr[0] = iArr[0] + 1;
            }
        }
        try {
            if (arrayList.size() > 0) {
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    MessageObject messageObject3 = (MessageObject) it3.next();
                    String dialogId = IdStorage.getInstance().getDialogId(messageObject3.getDialogId());
                    if (!TextUtils.isEmpty(dialogId)) {
                        getCoreMainClass().updateMessageRubinoPost(dialogId, messageObject3.getId(), (ir.aaap.messengercore.model.RubinoPostData) Utils.convertObjectToMap(((TLRPC$TL_messageMediaRubinoPost) messageObject3.messageOwner.media).rubinoPostData, ir.aaap.messengercore.model.RubinoPostData.class));
                    }
                }
            }
        } catch (Exception e) {
            ir.resaneh1.iptv.logger.MyLog.handleException(e);
        }
        return Observable.just(Integer.valueOf(iArr[0]));
    }

    private Observable<ArrayList<RubinoPostObject>> loadRubinoPostsFromServer(Map<String, Rubino.RubinoProfilePostId> map) {
        if (map == null || map.isEmpty()) {
            return Observable.just(new ArrayList());
        }
        return RubinoController.getInstance(this.currentAccount).getProfilesPostListObservable(map.values()).flatMap(new Function<Rubino.PostObjectList, Observable<ArrayList<RubinoPostObject>>>(this) { // from class: androidMessenger.proxy.MessageProxy.30
            @Override // io.reactivex.functions.Function
            public Observable<ArrayList<RubinoPostObject>> apply(Rubino.PostObjectList postObjectList) throws Exception {
                return Observable.just(postObjectList.posts);
            }
        });
    }

    public void loadChannelSeenCountAndChatReactions(final long j, final ArrayList<MessageObject> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        final LongSparseArray longSparseArray = new LongSparseArray();
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda21
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadChannelSeenCountAndChatReactions$72(j, arrayList, longSparseArray);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadChannelSeenCountAndChatReactions$72(long j, ArrayList arrayList, LongSparseArray longSparseArray) {
        ChatAbsObject absInstant;
        String dialogId = IdStorage.getInstance().getDialogId(j);
        if (TextUtils.isEmpty(dialogId) || (absInstant = getCoreMainClass().getAbsInstant(dialogId)) == null) {
            return;
        }
        long id = Long.MAX_VALUE;
        long id2 = Long.MIN_VALUE;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            MessageObject messageObject = (MessageObject) arrayList.get(size);
            longSparseArray.append(messageObject.getId(), messageObject);
            if (messageObject.getId() > 0 && messageObject.getId() < id) {
                id = messageObject.getId();
            }
            if (messageObject.getId() > id2) {
                id2 = messageObject.getId();
            }
        }
        if (id2 <= 0 || id2 < id) {
            return;
        }
        if (absInstant.type == ChatType.Channel) {
            getCoreMainClass().getChannelMessagesSeenCount(absInstant.object_guid, id, id2);
        }
        if (getCoreMainClass().canShowReactions(dialogId, absInstant.type)) {
            getCoreMainClass().getChatReaction(absInstant.object_guid, id, id2);
        }
    }

    public int getMessageSeen(TLObject tLObject, final RequestDelegate requestDelegate) {
        long j;
        int i;
        int i2;
        final String dialogId;
        if (!(tLObject instanceof TLRPC$TL_messages_getMessageReadParticipants)) {
            requestDelegate.run(null, new TLRPC$TL_error());
            return 0;
        }
        TLRPC$TL_messages_getMessageReadParticipants tLRPC$TL_messages_getMessageReadParticipants = (TLRPC$TL_messages_getMessageReadParticipants) tLObject;
        final long j2 = tLRPC$TL_messages_getMessageReadParticipants.msg_id;
        TLRPC$InputPeer tLRPC$InputPeer = tLRPC$TL_messages_getMessageReadParticipants.peer;
        if (tLRPC$InputPeer instanceof TLRPC$TL_inputPeerUser) {
            i2 = tLRPC$InputPeer.user_id;
        } else {
            if (tLRPC$InputPeer instanceof TLRPC$TL_inputPeerChat) {
                i = tLRPC$InputPeer.chat_id;
            } else if (tLRPC$InputPeer instanceof TLRPC$TL_inputPeerChannel) {
                i = tLRPC$InputPeer.channel_id;
            } else {
                j = 0;
                dialogId = IdStorage.getInstance().getDialogId(j);
                if (!TextUtils.isEmpty(dialogId) || j2 <= 0) {
                    requestDelegate.run(null, new TLRPC$TL_error());
                    return 0;
                }
                final int andIncReqId = IdStorage.getInstance().getAndIncReqId();
                Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda33
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$getMessageSeen$74(dialogId, j2, requestDelegate, andIncReqId);
                    }
                });
                return andIncReqId;
            }
            i2 = -i;
        }
        j = i2;
        dialogId = IdStorage.getInstance().getDialogId(j);
        if (!TextUtils.isEmpty(dialogId)) {
        }
        requestDelegate.run(null, new TLRPC$TL_error());
        return 0;
    }

    /* renamed from: androidMessenger.proxy.MessageProxy$32, reason: invalid class name */
    class AnonymousClass32 implements LoadListener<GetGroupMessageReadParticipantsResult> {
        final /* synthetic */ RequestDelegate val$onComplete;

        AnonymousClass32(RequestDelegate requestDelegate) {
            this.val$onComplete = requestDelegate;
        }

        @Override // ir.aaap.messengercore.LoadListener
        public void onDidLoad(GetGroupMessageReadParticipantsResult getGroupMessageReadParticipantsResult) {
            if (getGroupMessageReadParticipantsResult != null && getGroupMessageReadParticipantsResult.status == GetGroupMessageReadParticipantsOutput.StatusEnum.OK) {
                if (getGroupMessageReadParticipantsResult.read_participants == null || getGroupMessageReadParticipantsResult.chatAbsObjectMap == null) {
                    this.val$onComplete.run(null, new TLRPC$TL_error());
                    return;
                }
                TLRPC$Vector tLRPC$Vector = new TLRPC$Vector();
                final ArrayList arrayList = new ArrayList();
                for (String str : getGroupMessageReadParticipantsResult.read_participants.keySet()) {
                    Long l = getGroupMessageReadParticipantsResult.read_participants.get(str);
                    ChatAbsObject chatAbsObject = getGroupMessageReadParticipantsResult.chatAbsObjectMap.get(str);
                    if (chatAbsObject != null && chatAbsObject.type == ChatType.User && l != null) {
                        arrayList.add(ChatConverter.convertUser(MessageProxy.this.getCoreMainClass(), IdStorage.getInstance().generateDialogId(str), chatAbsObject, (UserInfo) null, (Chat) null));
                        TLRPC$TL_readParticipantDate tLRPC$TL_readParticipantDate = new TLRPC$TL_readParticipantDate();
                        tLRPC$TL_readParticipantDate.date = MessageProxy$32$$ExternalSyntheticBackport0.m(l.longValue());
                        tLRPC$TL_readParticipantDate.user_id = (int) IdStorage.getInstance().generateDialogId(str);
                        tLRPC$Vector.objects.add(tLRPC$TL_readParticipantDate);
                    }
                }
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$32$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onDidLoad$0(arrayList);
                    }
                });
                this.val$onComplete.run(tLRPC$Vector, null);
                return;
            }
            this.val$onComplete.run(null, new TLRPC$TL_error());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onDidLoad$0(ArrayList arrayList) {
            MessageProxy.this.getMessagesController().putUsers(arrayList, false);
        }

        @Override // ir.aaap.messengercore.LoadListener
        public void onError(Exception exc) {
            this.val$onComplete.run(null, new TLRPC$TL_error());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getMessageSeen$74(String str, long j, RequestDelegate requestDelegate, int i) {
        IdStorage.getInstance().binReqIds(i, getCoreMainClass().getGroupMessageReadParticipants(str, j, new AnonymousClass32(requestDelegate)));
    }

    public void sendReaction(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (!(tLObject instanceof TLRPC$TL_messages_sendReaction)) {
            requestDelegate.run(null, new TLRPC$TL_error());
        } else {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda61
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$sendReaction$75(tLObject, requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendReaction$75(TLObject tLObject, final RequestDelegate requestDelegate) {
        int i;
        long j;
        final TLRPC$TL_messages_sendReaction tLRPC$TL_messages_sendReaction = (TLRPC$TL_messages_sendReaction) tLObject;
        TLRPC$InputPeer tLRPC$InputPeer = tLRPC$TL_messages_sendReaction.peer;
        int i2 = tLRPC$InputPeer.channel_id;
        if (i2 == 0 && (i2 = tLRPC$InputPeer.chat_id) == 0) {
            i = tLRPC$InputPeer.user_id;
            if (i == 0) {
                j = 0;
            }
            final long j2 = j;
            String dialogId = IdStorage.getInstance().getDialogId(j2);
            getCoreMainClass().actionOnMessageReaction(dialogId, tLRPC$TL_messages_sendReaction.msg_id, tLRPC$TL_messages_sendReaction.reactionId, !TextUtils.isEmpty(r9), new LoadListener<ArrayList<MessageReactionObject>>() { // from class: androidMessenger.proxy.MessageProxy.33
                @Override // ir.aaap.messengercore.LoadListener
                public void onDidLoad(ArrayList<MessageReactionObject> arrayList) {
                    TLRPC$TL_updateMessageReactions tLRPC$TL_updateMessageReactions = new TLRPC$TL_updateMessageReactions();
                    tLRPC$TL_updateMessageReactions.peer = MessageProxy.this.getMessagesController().getPeer((int) j2);
                    tLRPC$TL_updateMessageReactions.msg_id = tLRPC$TL_messages_sendReaction.msg_id;
                    tLRPC$TL_updateMessageReactions.reactions = MessageConverter.convertToTlMessageReactions(MessageProxy.this.getCoreMainClass(), j2, arrayList);
                    requestDelegate.run(tLRPC$TL_updateMessageReactions, null);
                }

                @Override // ir.aaap.messengercore.LoadListener
                public void onError(Exception exc) {
                    requestDelegate.run(null, new TLRPC$TL_error());
                }
            });
        }
        i = -i2;
        j = i;
        final long j22 = j;
        String dialogId2 = IdStorage.getInstance().getDialogId(j22);
        getCoreMainClass().actionOnMessageReaction(dialogId2, tLRPC$TL_messages_sendReaction.msg_id, tLRPC$TL_messages_sendReaction.reactionId, !TextUtils.isEmpty(r9), new LoadListener<ArrayList<MessageReactionObject>>() { // from class: androidMessenger.proxy.MessageProxy.33
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(ArrayList<MessageReactionObject> arrayList) {
                TLRPC$TL_updateMessageReactions tLRPC$TL_updateMessageReactions = new TLRPC$TL_updateMessageReactions();
                tLRPC$TL_updateMessageReactions.peer = MessageProxy.this.getMessagesController().getPeer((int) j22);
                tLRPC$TL_updateMessageReactions.msg_id = tLRPC$TL_messages_sendReaction.msg_id;
                tLRPC$TL_updateMessageReactions.reactions = MessageConverter.convertToTlMessageReactions(MessageProxy.this.getCoreMainClass(), j22, arrayList);
                requestDelegate.run(tLRPC$TL_updateMessageReactions, null);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                requestDelegate.run(null, new TLRPC$TL_error());
            }
        });
    }

    public void processUpdatedChatReactions(String str, Map<Long, ArrayList<MessageReactionObject>> map) {
        ChatAbsObject absInstant;
        if (TextUtils.isEmpty(str) || map == null || map.isEmpty() || (absInstant = getCoreMainClass().getAbsInstant(str)) == null) {
            return;
        }
        final long dialogId = ChatConverter.getDialogId(str, absInstant.type);
        for (final Long l : map.keySet()) {
            final TLRPC$TL_messageReactions tLRPC$TL_messageReactionsConvertToTlMessageReactions = MessageConverter.convertToTlMessageReactions(getCoreMainClass(), dialogId, map.get(l));
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda15
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processUpdatedChatReactions$76(dialogId, l, tLRPC$TL_messageReactionsConvertToTlMessageReactions);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processUpdatedChatReactions$76(long j, Long l, TLRPC$TL_messageReactions tLRPC$TL_messageReactions) {
        getNotificationCenter().postNotificationName(NotificationCenter.didUpdateReactions, Long.valueOf(j), l, tLRPC$TL_messageReactions);
    }

    public void loadReactions(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_messages_getMessageReactionsList) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.MessageProxy$$ExternalSyntheticLambda66
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadReactions$77(tLObject, requestDelegate);
                }
            });
        } else if (requestDelegate != null) {
            requestDelegate.run(null, new TLRPC$TL_error());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$loadReactions$77(org.rbmain.tgnet.TLObject r8, final org.rbmain.tgnet.RequestDelegate r9) {
        /*
            r7 = this;
            org.rbmain.tgnet.TLRPC$TL_messages_getMessageReactionsList r8 = (org.rbmain.tgnet.TLRPC$TL_messages_getMessageReactionsList) r8
            long r3 = r8.id
            org.rbmain.tgnet.TLRPC$InputPeer r8 = r8.peer
            boolean r0 = r8 instanceof org.rbmain.tgnet.TLRPC$TL_inputPeerUser
            r1 = 0
            if (r0 == 0) goto L10
            int r8 = r8.user_id
        Le:
            long r5 = (long) r8
            goto L20
        L10:
            boolean r0 = r8 instanceof org.rbmain.tgnet.TLRPC$TL_inputPeerChat
            if (r0 == 0) goto L18
            int r8 = r8.chat_id
        L16:
            int r8 = -r8
            goto Le
        L18:
            boolean r0 = r8 instanceof org.rbmain.tgnet.TLRPC$TL_inputPeerChannel
            if (r0 == 0) goto L1f
            int r8 = r8.channel_id
            goto L16
        L1f:
            r5 = r1
        L20:
            androidMessenger.proxy.IdStorage r8 = androidMessenger.proxy.IdStorage.getInstance()
            java.lang.String r8 = r8.getDialogId(r5)
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            r5 = 0
            if (r0 != 0) goto L62
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 > 0) goto L34
            goto L62
        L34:
            ir.aaap.messengercore.CoreMainClass r0 = r7.getCoreMainClass()
            ir.aaap.messengercore.model.ChatAbsObject r0 = r0.getAbsInstant(r8)
            if (r0 == 0) goto L57
            ir.aaap.messengercore.model.ChatType r1 = r0.type
            ir.aaap.messengercore.model.ChatType r2 = ir.aaap.messengercore.model.ChatType.Channel
            if (r1 != r2) goto L45
            goto L57
        L45:
            ir.aaap.messengercore.CoreMainClass r1 = r7.getCoreMainClass()
            ir.aaap.messengercore.model.ChatType r2 = r0.type
            r5 = 0
            androidMessenger.proxy.MessageProxy$34 r6 = new androidMessenger.proxy.MessageProxy$34
            r6.<init>()
            r0 = r1
            r1 = r8
            r0.getMessageReactions(r1, r2, r3, r5, r6)
            return
        L57:
            if (r9 == 0) goto L61
            org.rbmain.tgnet.TLRPC$TL_error r8 = new org.rbmain.tgnet.TLRPC$TL_error
            r8.<init>()
            r9.run(r5, r8)
        L61:
            return
        L62:
            if (r9 == 0) goto L6c
            org.rbmain.tgnet.TLRPC$TL_error r8 = new org.rbmain.tgnet.TLRPC$TL_error
            r8.<init>()
            r9.run(r5, r8)
        L6c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidMessenger.proxy.MessageProxy.lambda$loadReactions$77(org.rbmain.tgnet.TLObject, org.rbmain.tgnet.RequestDelegate):void");
    }
}
