package androidMessenger.proxy;

import android.text.TextUtils;
import androidMessenger.ServiceLocator;
import androidMessenger.proxy.DialogsProxy;
import androidMessenger.utilites.ChatConverter;
import androidMessenger.utilites.MessageConverter;
import androidMessenger.utilites.MyLog;
import androidMessenger.utilites.ObjectInfoConverter;
import ir.aaap.messengercore.CoreMainClass;
import ir.aaap.messengercore.CoreUtilities;
import ir.aaap.messengercore.GetAvatarsListener;
import ir.aaap.messengercore.GetChannelAdminAccessListListener;
import ir.aaap.messengercore.GetGroupAdminAccessListListener;
import ir.aaap.messengercore.GetGroupDefaultAccessListListener;
import ir.aaap.messengercore.GetMemberListener;
import ir.aaap.messengercore.LoadListener;
import ir.aaap.messengercore.exceptions.InputException;
import ir.aaap.messengercore.exceptions.UsernameNotExistException;
import ir.aaap.messengercore.model.AvatarObject;
import ir.aaap.messengercore.model.ChannelInfo;
import ir.aaap.messengercore.model.ChannelInfoFromServer;
import ir.aaap.messengercore.model.Chat;
import ir.aaap.messengercore.model.ChatAbsObject;
import ir.aaap.messengercore.model.ChatInviteObject;
import ir.aaap.messengercore.model.ChatNeedReloadResult;
import ir.aaap.messengercore.model.ChatParamUpdateTimeObject;
import ir.aaap.messengercore.model.ChatType;
import ir.aaap.messengercore.model.CheckChannelsWithUsernameResult;
import ir.aaap.messengercore.model.DialogFilterSuggested;
import ir.aaap.messengercore.model.FolderObject;
import ir.aaap.messengercore.model.InChatMember;
import ir.aaap.messengercore.model.LiveModels;
import ir.aaap.messengercore.model.LocationObject;
import ir.aaap.messengercore.model.Message;
import ir.aaap.messengercore.model.ObjectGuidType;
import ir.aaap.messengercore.model.ObjectInfo;
import ir.aaap.messengercore.model.PinMessageResult;
import ir.aaap.messengercore.model.SendChatActivityInput;
import ir.aaap.messengercore.model.ShowActivityObject;
import ir.aaap.messengercore.model.UserInfo;
import ir.aaap.messengercore.model.api.ActionOnChatAdsInput;
import ir.aaap.messengercore.model.api.ChangeOwnerModels;
import ir.aaap.messengercore.model.api.ChatAdsObject;
import ir.aaap.messengercore.model.api.GetAllStatisticsOutput;
import ir.aaap.messengercore.model.api.GetBlockedUsersOutput;
import ir.aaap.messengercore.model.api.GetProfileLinkItemsOutputs;
import ir.aaap.messengercore.model.api.InSearchObject;
import ir.aaap.messengercore.model.api.ReportObjectInput;
import ir.aaap.messengercore.model.api.SearchGlobalMessagesOutput;
import ir.aaap.messengercore.model.api.SearchGlobalObjectsOutput;
import ir.aaap.messengercore.model.api.SetPinMessageOutput;
import ir.aaap.messengercore.model.api.UpdateChannelUsernameOutput;
import ir.aaap.messengercore.model.api.UpdateUserUsernameOutput;
import ir.medu.shad.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import org.rbmain.messenger.AccountInstance;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.BaseController;
import org.rbmain.messenger.DispatchQueue;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.SendMessagesHelper;
import org.rbmain.messenger.UserConfig;
import org.rbmain.messenger.Utilities;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$ChannelParticipantsFilter;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$ChatFull;
import org.rbmain.tgnet.TLRPC$Dialog;
import org.rbmain.tgnet.TLRPC$ExportedChatInvite;
import org.rbmain.tgnet.TLRPC$InputFile;
import org.rbmain.tgnet.TLRPC$InputPeer;
import org.rbmain.tgnet.TLRPC$InputUser;
import org.rbmain.tgnet.TLRPC$RecentListResult;
import org.rbmain.tgnet.TLRPC$TL_account_checkUsername;
import org.rbmain.tgnet.TLRPC$TL_account_reportPeer;
import org.rbmain.tgnet.TLRPC$TL_account_updateProfile;
import org.rbmain.tgnet.TLRPC$TL_account_updateUsername;
import org.rbmain.tgnet.TLRPC$TL_auth_logOut;
import org.rbmain.tgnet.TLRPC$TL_boolTrue;
import org.rbmain.tgnet.TLRPC$TL_channel;
import org.rbmain.tgnet.TLRPC$TL_channelParticipantsAdmins;
import org.rbmain.tgnet.TLRPC$TL_channelParticipantsBanned;
import org.rbmain.tgnet.TLRPC$TL_channelParticipantsKicked;
import org.rbmain.tgnet.TLRPC$TL_channelParticipantsMentions;
import org.rbmain.tgnet.TLRPC$TL_channelParticipantsNotAdmins;
import org.rbmain.tgnet.TLRPC$TL_channelParticipantsRecent;
import org.rbmain.tgnet.TLRPC$TL_channelParticipantsSearch;
import org.rbmain.tgnet.TLRPC$TL_channels_channelParticipants;
import org.rbmain.tgnet.TLRPC$TL_channels_checkUsername;
import org.rbmain.tgnet.TLRPC$TL_channels_deleteChannel;
import org.rbmain.tgnet.TLRPC$TL_channels_deleteHistory;
import org.rbmain.tgnet.TLRPC$TL_channels_editAdmin;
import org.rbmain.tgnet.TLRPC$TL_channels_editBanned;
import org.rbmain.tgnet.TLRPC$TL_channels_editCreator;
import org.rbmain.tgnet.TLRPC$TL_channels_getParticipants;
import org.rbmain.tgnet.TLRPC$TL_channels_inviteToChannel;
import org.rbmain.tgnet.TLRPC$TL_channels_joinChannel;
import org.rbmain.tgnet.TLRPC$TL_channels_leaveChannel;
import org.rbmain.tgnet.TLRPC$TL_channels_toggleSlowMode;
import org.rbmain.tgnet.TLRPC$TL_channels_updateUsername;
import org.rbmain.tgnet.TLRPC$TL_chat;
import org.rbmain.tgnet.TLRPC$TL_chatBannedRights;
import org.rbmain.tgnet.TLRPC$TL_chatInviteExported;
import org.rbmain.tgnet.TLRPC$TL_contacts_block;
import org.rbmain.tgnet.TLRPC$TL_contacts_blocked;
import org.rbmain.tgnet.TLRPC$TL_contacts_found;
import org.rbmain.tgnet.TLRPC$TL_contacts_getBlocked;
import org.rbmain.tgnet.TLRPC$TL_contacts_getTopPeers;
import org.rbmain.tgnet.TLRPC$TL_contacts_resetTopPeerRating;
import org.rbmain.tgnet.TLRPC$TL_contacts_resolveUsername;
import org.rbmain.tgnet.TLRPC$TL_contacts_resolvedPeer;
import org.rbmain.tgnet.TLRPC$TL_contacts_search;
import org.rbmain.tgnet.TLRPC$TL_contacts_topPeers;
import org.rbmain.tgnet.TLRPC$TL_contacts_unblock;
import org.rbmain.tgnet.TLRPC$TL_dialogAd;
import org.rbmain.tgnet.TLRPC$TL_dialogFilter;
import org.rbmain.tgnet.TLRPC$TL_dialogFilterSuggested;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_inputChannelEmpty;
import org.rbmain.tgnet.TLRPC$TL_inputPeerChannel;
import org.rbmain.tgnet.TLRPC$TL_inputPeerChat;
import org.rbmain.tgnet.TLRPC$TL_inputPeerUser;
import org.rbmain.tgnet.TLRPC$TL_inputUserSelf;
import org.rbmain.tgnet.TLRPC$TL_messages_addChatUser;
import org.rbmain.tgnet.TLRPC$TL_messages_affectedHistory;
import org.rbmain.tgnet.TLRPC$TL_messages_chats;
import org.rbmain.tgnet.TLRPC$TL_messages_checkChatInvite;
import org.rbmain.tgnet.TLRPC$TL_messages_createChat;
import org.rbmain.tgnet.TLRPC$TL_messages_deleteChat;
import org.rbmain.tgnet.TLRPC$TL_messages_deleteChatUser;
import org.rbmain.tgnet.TLRPC$TL_messages_deleteHistory;
import org.rbmain.tgnet.TLRPC$TL_messages_editChatDefaultBannedRights;
import org.rbmain.tgnet.TLRPC$TL_messages_exportChatInvite;
import org.rbmain.tgnet.TLRPC$TL_messages_exportedChatInvites;
import org.rbmain.tgnet.TLRPC$TL_messages_getCommonChats;
import org.rbmain.tgnet.TLRPC$TL_messages_getExportedChatInvites;
import org.rbmain.tgnet.TLRPC$TL_messages_getSuggestedDialogFilters;
import org.rbmain.tgnet.TLRPC$TL_messages_importChatInvite;
import org.rbmain.tgnet.TLRPC$TL_messages_report;
import org.rbmain.tgnet.TLRPC$TL_messages_searchGlobal;
import org.rbmain.tgnet.TLRPC$TL_messages_setChatAvailableReactions;
import org.rbmain.tgnet.TLRPC$TL_messages_setTyping;
import org.rbmain.tgnet.TLRPC$TL_messages_unpinAllMessages;
import org.rbmain.tgnet.TLRPC$TL_messages_updateDialogFilter;
import org.rbmain.tgnet.TLRPC$TL_messages_updateDialogFiltersOrder;
import org.rbmain.tgnet.TLRPC$TL_peerBlocked;
import org.rbmain.tgnet.TLRPC$TL_peerUser;
import org.rbmain.tgnet.TLRPC$TL_stats_getBroadcastStats;
import org.rbmain.tgnet.TLRPC$TL_topPeer;
import org.rbmain.tgnet.TLRPC$TL_topPeerCategoryCorrespondents;
import org.rbmain.tgnet.TLRPC$TL_topPeerCategoryPeers;
import org.rbmain.tgnet.TLRPC$TL_updateAddedUsers;
import org.rbmain.tgnet.TLRPC$TL_updateChatDefaultBannedRights;
import org.rbmain.tgnet.TLRPC$TL_updates;
import org.rbmain.tgnet.TLRPC$TL_user;
import org.rbmain.tgnet.TLRPC$Update;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.tgnet.TLRPC$Vector;
import org.rbmain.tgnet.TLRPC$messages_Messages;
import org.rbmain.ui.Adapters.DialogsSearchAdapter;

/* loaded from: classes.dex */
public class DialogsProxy extends BaseController {
    private static volatile DialogsProxy[] Instance = new DialogsProxy[3];
    private Runnable updateRunnable;

    public interface LongCallback {
        void run(long j);
    }

    public void removeNotifications(final long j) {
        final String dialogId = IdStorage.getInstance().getDialogId(j);
        if (TextUtils.isEmpty(dialogId)) {
            return;
        }
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda41
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$removeNotifications$0(dialogId, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removeNotifications$0(String str, long j) {
        getCoreMainClass().removeNotificationsForChat(str, getChatType(j));
    }

    public boolean isChatForbidden(TLRPC$Chat tLRPC$Chat) {
        Chat.ChatStatusEnum chatStatusEnum;
        if (tLRPC$Chat == null || tLRPC$Chat.id == 0) {
            return true;
        }
        Chat chatForceGetChatInstant = getCoreMainClass().forceGetChatInstant(IdStorage.getInstance().getDialogId(-tLRPC$Chat.id));
        return chatForceGetChatInstant != null && ((chatStatusEnum = chatForceGetChatInstant.status) == Chat.ChatStatusEnum.ObjRemoved || chatStatusEnum == Chat.ChatStatusEnum.NoAccess);
    }

    public boolean isNotInChat(TLRPC$Chat tLRPC$Chat) {
        Chat chatForceGetChatInstant;
        return tLRPC$Chat == null || tLRPC$Chat.id == 0 || (chatForceGetChatInstant = getCoreMainClass().forceGetChatInstant(IdStorage.getInstance().getDialogId((long) (-tLRPC$Chat.id)))) == null || chatForceGetChatInstant.status != Chat.ChatStatusEnum.Active;
    }

    public void unpinAllMessages(final TLObject tLObject, final RequestDelegate requestDelegate) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda76
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$unpinAllMessages$1(tLObject, requestDelegate);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$unpinAllMessages$1(TLObject tLObject, final RequestDelegate requestDelegate) {
        int i;
        int i2;
        TLRPC$InputPeer tLRPC$InputPeer = ((TLRPC$TL_messages_unpinAllMessages) tLObject).peer;
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
        getAccountInstance().getCoreMainClass().unpinAllMessages(IdStorage.getInstance().getDialogId(i2), new LoadListener<PinMessageResult>(this) { // from class: androidMessenger.proxy.DialogsProxy.1
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

    public DialogsProxy(int i) {
        super(i);
        this.updateRunnable = new Runnable() { // from class: androidMessenger.proxy.DialogsProxy.62
            @Override // java.lang.Runnable
            public void run() {
                MyLog.e("updateRunnable", "updateRunnable " + ((BaseController) DialogsProxy.this).currentAccount);
                if (ApplicationLoader.applicationActivity != null && !ApplicationLoader.applicationActivity.isInBackGround) {
                    MessagesController.getInstance(((BaseController) DialogsProxy.this).currentAccount).updateTimerProc();
                }
                Utilities.stageQueue.postRunnable(this, 1000L);
            }
        };
        this.currentAccount = i;
    }

    public static DialogsProxy getInstance(int i) {
        DialogsProxy dialogsProxy = Instance[i];
        if (dialogsProxy == null) {
            synchronized (MessageProxy.class) {
                dialogsProxy = Instance[i];
                if (dialogsProxy == null) {
                    DialogsProxy[] dialogsProxyArr = Instance;
                    DialogsProxy dialogsProxy2 = new DialogsProxy(i);
                    dialogsProxyArr[i] = dialogsProxy2;
                    dialogsProxy = dialogsProxy2;
                }
            }
        }
        return dialogsProxy;
    }

    public void proxyDialogLoading(final boolean z) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy.2
            @Override // java.lang.Runnable
            public void run() {
                DialogsProxy.this.getNotificationCenter().postNotificationName(NotificationCenter.dialogsLoadingChange, Boolean.valueOf(z));
            }
        });
    }

    /* renamed from: startChatList, reason: merged with bridge method [inline-methods] */
    public void lambda$loadDialogs$3() {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$startChatList$2();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startChatList$2() {
        getAccountInstance().getCoreMainClass().startChatList();
    }

    public void loadDialogs(int i, int i2, int i3, boolean z) {
        if (i2 == 0) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadDialogs$3();
                }
            });
        } else {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadDialogs$4();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadDialogs$4() {
        getAccountInstance().getCoreMainClass().loadMoreChat();
    }

    public void stopChatList() {
        getAccountInstance().getCoreMainClass().stopChatList();
    }

    public void proxyChatResults(final ChatNeedReloadResult chatNeedReloadResult) {
        MyLog.e("Dialogs", "Loaded");
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda39
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$proxyChatResults$10(chatNeedReloadResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$proxyChatResults$10(ChatNeedReloadResult chatNeedReloadResult) {
        String key;
        ChatAbsObject absInstant;
        Chat chatInstant;
        ChatNeedReloadResult.TypeEnum typeEnum = chatNeedReloadResult.typeEnum;
        if (typeEnum == ChatNeedReloadResult.TypeEnum.AllListUpdated) {
            getAccountInstance().getMessagesController().processLoadedDialogs(ChatConverter.convertAllChats(getAccountInstance().getCoreMainClass(), getAccountInstance().getCoreMainClass().getChatListInstant()), null, 0, 0L, 100, 0, false, false, false);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$proxyChatResults$5();
                }
            });
            return;
        }
        if (typeEnum == ChatNeedReloadResult.TypeEnum.SomeChatsUpdated) {
            Map<String, Set<ChatParamUpdateTimeObject.Params>> map = chatNeedReloadResult.updatedChats;
            if (map != null && !map.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                boolean z = false;
                for (Map.Entry<String, Set<ChatParamUpdateTimeObject.Params>> entry : chatNeedReloadResult.updatedChats.entrySet()) {
                    Chat chatInstant2 = getAccountInstance().getCoreMainClass().getChatInstant(entry.getKey());
                    if (chatInstant2 != null) {
                        int i = entry.getValue().contains(ChatParamUpdateTimeObject.Params.is_mute) ? MessagesController.UPDATE_MASK_CHAT_MUTE : 0;
                        if (entry.getValue().contains(ChatParamUpdateTimeObject.Params.pinned_message_ids) && (chatInstant = getCoreMainClass().getChatInstant(entry.getKey())) != null) {
                            ArrayList<Long> arrayList2 = chatInstant.pinned_message_ids;
                            if (arrayList2 != null && arrayList2.size() > 0) {
                                getCoreMainClass().loadPinMessageForChat(entry.getKey());
                            } else {
                                processLoadedPinnedMessages(entry.getKey(), 0L);
                            }
                        }
                        if (entry.getValue().contains(ChatParamUpdateTimeObject.Params.show_ask_spam)) {
                            z = true;
                        }
                        if (entry.getValue().contains(ChatParamUpdateTimeObject.Params.chat_keypad) && (absInstant = getCoreMainClass().getAbsInstant((key = entry.getKey()))) != null) {
                            getMessagesProxy().getBotKeyboard(ChatConverter.getDialogId(key, absInstant.type));
                        }
                        TLRPC$Dialog tLRPC$DialogConvertChat = ChatConverter.convertChat(getAccountInstance().getCoreMainClass(), chatInstant2, null, null, null);
                        if (tLRPC$DialogConvertChat != null) {
                            getAccountInstance().getMessagesController().processDialogUpdate(tLRPC$DialogConvertChat, i);
                            arrayList.add(getCoreMainClass().getChatInstant(entry.getKey()));
                        }
                    }
                }
                getMessagesController().processDialogsUpdate(ChatConverter.convertAllChats(getAccountInstance().getCoreMainClass(), arrayList), null, false);
                if (z) {
                    Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda13
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$proxyChatResults$7();
                        }
                    });
                    return;
                }
                return;
            }
            ArrayList<String> arrayList3 = chatNeedReloadResult.deleteChats;
            if (arrayList3 != null && !arrayList3.isEmpty()) {
                Iterator<String> it = chatNeedReloadResult.deleteChats.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (getCoreMainClass().getChatInstant(next) != null) {
                        long dialogId = ChatConverter.getDialogId(next, getCoreMainClass().getAbsInstant(next).type);
                        if (dialogId != 0) {
                            getMessagesController().deleteDialog(dialogId, 0);
                        }
                    }
                }
                return;
            }
            ArrayList<String> arrayList4 = chatNeedReloadResult.newChats;
            if (arrayList4 == null || arrayList4.isEmpty()) {
                return;
            }
            ArrayList arrayList5 = new ArrayList();
            Iterator<String> it2 = chatNeedReloadResult.newChats.iterator();
            while (it2.hasNext()) {
                arrayList5.add(getCoreMainClass().getChatInstant(it2.next()));
            }
            getMessagesController().processDialogsUpdate(ChatConverter.convertAllChats(getAccountInstance().getCoreMainClass(), arrayList5), null, false);
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda10
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$proxyChatResults$9();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$proxyChatResults$5() {
        getMediaDataController().loadLocalDraftsIfNeeded();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$proxyChatResults$6(int i) {
        getNotificationCenter().postNotificationName(NotificationCenter.updateInterfaces, Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$proxyChatResults$7() {
        final int i = MessagesController.UPDATE_MASK_CHAT_SHOW_SPAM;
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda16
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$proxyChatResults$6(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$proxyChatResults$8(int i) {
        getNotificationCenter().postNotificationName(NotificationCenter.updateInterfaces, Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$proxyChatResults$9() {
        final int i = 8192;
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda15
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$proxyChatResults$8(i);
            }
        });
    }

    public void loadFullChat(final TLRPC$Chat tLRPC$Chat, int i, final boolean z) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda100
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadFullChat$11(tLRPC$Chat, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadFullChat$11(TLRPC$Chat tLRPC$Chat, boolean z) {
        getAccountInstance().getCoreMainClass().refreshObjectInfo(IdStorage.getInstance().getDialogId(-tLRPC$Chat.id), !tLRPC$Chat.megagroup ? ChatType.Channel : ChatType.Group, z, null, false);
    }

    public void loadFullUser(final TLRPC$User tLRPC$User, int i, final boolean z) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda102
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadFullUser$12(tLRPC$User, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadFullUser$12(TLRPC$User tLRPC$User, boolean z) {
        getAccountInstance().getCoreMainClass().refreshObjectInfo(IdStorage.getInstance().getDialogId(tLRPC$User.id), tLRPC$User.bot ? ChatType.Bot : tLRPC$User.support ? ChatType.Service : ChatType.User, z, null, false);
    }

    public void proxyObjectInfo(final String str, final ChatType chatType) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda45
            @Override // java.lang.Runnable
            public final void run() throws InterruptedException {
                this.f$0.lambda$proxyObjectInfo$14(str, chatType);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$proxyObjectInfo$14(String str, ChatType chatType) throws InterruptedException {
        long jGenerateDialogId;
        Chat chat;
        TLRPC$User tLRPC$UserConvertBot;
        if (str != null) {
            ChatType chatType2 = ChatType.User;
            if (chatType == chatType2 || chatType == ChatType.Bot || chatType == ChatType.Service) {
                jGenerateDialogId = IdStorage.getInstance().generateDialogId(str);
            } else {
                jGenerateDialogId = IdStorage.getInstance().generateNegativeDialogId(str);
            }
            ObjectInfo objectInfoInstant = getAccountInstance().getCoreMainClass().getObjectInfoInstant(str);
            if (objectInfoInstant != null) {
                ChatAbsObject absInstant = getAccountInstance().getCoreMainClass().getAbsInstant(str);
                Chat chatInstant = getAccountInstance().getCoreMainClass().getChatInstant(str);
                if (chatType == ChatType.Channel || chatType == ChatType.Group) {
                    chat = chatInstant;
                    final TLRPC$Chat tLRPC$ChatConvertChannelGroup = ChatConverter.convertChannelGroup(getAccountInstance().getCoreMainClass(), absInstant, chat);
                    getMessagesController().processFullChat(ObjectInfoConverter.convert(getAccountInstance().getCoreMainClass(), tLRPC$ChatConvertChannelGroup, objectInfoInstant, chatType), null, -1, jGenerateDialogId);
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda99
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$proxyObjectInfo$13(tLRPC$ChatConvertChannelGroup);
                        }
                    });
                } else if (chatType == chatType2 || chatType == ChatType.Bot || chatType == ChatType.Service) {
                    int i = (int) jGenerateDialogId;
                    if (chatType == chatType2) {
                        tLRPC$UserConvertBot = ChatConverter.convertUser(getAccountInstance().getCoreMainClass(), i, absInstant, (UserInfo) null, chatInstant);
                        chat = chatInstant;
                    } else if (chatType == ChatType.Service) {
                        chat = chatInstant;
                        tLRPC$UserConvertBot = ChatConverter.convertService(getCoreMainClass(), jGenerateDialogId, absInstant, null, chatInstant);
                    } else {
                        chat = chatInstant;
                        tLRPC$UserConvertBot = ChatConverter.convertBot(getAccountInstance().getCoreMainClass(), i, absInstant, null, chat);
                    }
                    if (tLRPC$UserConvertBot != null) {
                        getMessagesController().processFullUser(ObjectInfoConverter.convert(AccountInstance.getInstance(this.currentAccount).getCoreMainClass(), tLRPC$UserConvertBot, objectInfoInstant, chatType, chat), null, -1, jGenerateDialogId);
                    }
                } else {
                    chat = chatInstant;
                }
                if (chat != null) {
                    ArrayList<Long> arrayList = chat.pinned_message_ids;
                    if (arrayList != null && arrayList.size() > 0) {
                        getCoreMainClass().loadPinMessageForChat(str);
                    } else {
                        processLoadedPinnedMessages(str, 0L);
                    }
                    TLRPC$Dialog tLRPC$DialogConvertChat = ChatConverter.convertChat(getAccountInstance().getCoreMainClass(), chat, null, null, null);
                    if (tLRPC$DialogConvertChat != null) {
                        getMessagesController().processDialogUpdate(tLRPC$DialogConvertChat, 0);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$proxyObjectInfo$13(TLRPC$Chat tLRPC$Chat) {
        getNotificationCenter().postNotificationName(NotificationCenter.updateInterfaces, Integer.valueOf(MessagesController.UPDATE_MASK_ALL));
        if (tLRPC$Chat != null) {
            getNotificationCenter().postNotificationName(NotificationCenter.channelRightsUpdated, tLRPC$Chat);
        }
    }

    public void loadChatInfo(final int i, final boolean z, CountDownLatch countDownLatch, final boolean z2, final boolean z3, long j) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda21
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadChatInfo$15(i, z, z2, z3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadChatInfo$15(final int i, final boolean z, final boolean z2, final boolean z3) {
        final String dialogId = IdStorage.getInstance().getDialogId(-i);
        if (getAccountInstance().getCoreMainClass().getChatInstant(dialogId) == null) {
            return;
        }
        TLRPC$ChatFull chatFullById = getChatFullById(dialogId, z ? ChatType.Channel : ChatType.Group);
        if (chatFullById == null) {
            getCoreMainClass().refreshObjectInfo(dialogId, z ? ChatType.Channel : ChatType.Group, z2, new LoadListener<String>() { // from class: androidMessenger.proxy.DialogsProxy.3
                @Override // ir.aaap.messengercore.LoadListener
                public void onError(Exception exc) {
                }

                @Override // ir.aaap.messengercore.LoadListener
                public void onDidLoad(String str) {
                    TLRPC$ChatFull chatFullById2 = DialogsProxy.this.getChatFullById(dialogId, z ? ChatType.Channel : ChatType.Group);
                    if (chatFullById2 == null) {
                        return;
                    }
                    DialogsProxy.this.getMessagesController().processChatInfo(i, chatFullById2, new ArrayList<>(), true, z2, z3, null, null, 0, true);
                }
            }, false);
        } else {
            getMessagesController().processChatInfo(i, chatFullById, new ArrayList<>(), true, z2, z3, null, null, 0, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TLRPC$ChatFull getChatFullById(String str, ChatType chatType) {
        TLRPC$Chat tLRPC$ChatConvertChannelGroup = ChatConverter.convertChannelGroup(getAccountInstance().getCoreMainClass(), getAccountInstance().getCoreMainClass().getAbsInstant(str), getAccountInstance().getCoreMainClass().getChatInstant(str));
        ObjectInfo objectInfoInstant = getAccountInstance().getCoreMainClass().getObjectInfoInstant(str);
        if (objectInfoInstant != null) {
            return ObjectInfoConverter.convert(getAccountInstance().getCoreMainClass(), tLRPC$ChatConvertChannelGroup, objectInfoInstant, chatType).full_chat;
        }
        return null;
    }

    public TLRPC$ChatFull getChatFullById(String str) {
        ChatAbsObject absInstant = getAccountInstance().getCoreMainClass().getAbsInstant(str);
        TLRPC$Chat tLRPC$ChatConvertChannelGroup = ChatConverter.convertChannelGroup(getAccountInstance().getCoreMainClass(), absInstant, getAccountInstance().getCoreMainClass().getChatInstant(str));
        ObjectInfo objectInfoInstant = getAccountInstance().getCoreMainClass().getObjectInfoInstant(str);
        if (objectInfoInstant == null || absInstant == null) {
            return null;
        }
        return ObjectInfoConverter.convert(getAccountInstance().getCoreMainClass(), tLRPC$ChatConvertChannelGroup, objectInfoInstant, absInstant.type).full_chat;
    }

    public TLRPC$User getCurrentUser(boolean z) {
        String str;
        String myGuid = getAccountInstance().getCoreMainClass().getMyGuid();
        long jGenerateDialogId = IdStorage.getInstance().generateDialogId(myGuid);
        if (myGuid == null) {
            return null;
        }
        TLRPC$TL_user tLRPC$TL_user = new TLRPC$TL_user();
        tLRPC$TL_user.id = (int) jGenerateDialogId;
        UserInfo myUserInfo = getAccountInstance().getCoreMainClass().getMyUserInfo();
        if (myUserInfo != null && (str = myUserInfo.user_guid) != null && !str.isEmpty()) {
            TLRPC$User tLRPC$UserConvertUser = ChatConverter.convertUser(getAccountInstance().getCoreMainClass(), jGenerateDialogId, getAccountInstance().getCoreMainClass().getAbsInstant(myGuid), myUserInfo, (Chat) null);
            return tLRPC$UserConvertUser == null ? tLRPC$TL_user : tLRPC$UserConvertUser;
        }
        if (z) {
            getAccountInstance().getCoreMainClass().loadMyUserInfo();
        }
        return tLRPC$TL_user;
    }

    public void proxyFolderResult(final ArrayList<FolderObject> arrayList) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda49
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$proxyFolderResult$16(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$proxyFolderResult$16(ArrayList arrayList) {
        getMessagesController().processLoadedDialogFilters(ChatConverter.covertAllFolders(this.currentAccount, arrayList), null, null, null, null, null, 1);
    }

    public void updateDialogsUnreadCounter() {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateDialogsUnreadCounter$18();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateDialogsUnreadCounter$18() {
        Iterator<FolderObject> it = getAccountInstance().getCoreMainClass().getFolderListInstant().iterator();
        while (it.hasNext()) {
            FolderObject next = it.next();
            int iGenerateFolderId = IdStorage.getInstance().generateFolderId(next.folder_id);
            MessagesController.DialogFilter dialogFilter = getMessagesController().dialogFiltersById.get(iGenerateFolderId);
            if (iGenerateFolderId == 0 || dialogFilter == null) {
                proxyFolderResult(getAccountInstance().getCoreMainClass().getFolderListInstant());
                return;
            }
            dialogFilter.unreadCount = getAccountInstance().getCoreMainClass().getFolderUnreadCount(next.folder_id);
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateDialogsUnreadCounter$17();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateDialogsUnreadCounter$17() {
        NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.dialogFiltersUpdated, new Object[0]);
    }

    public void addOrEditFolders(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_messages_updateDialogFilter) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda72
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$addOrEditFolders$19(tLObject, requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addOrEditFolders$19(TLObject tLObject, final RequestDelegate requestDelegate) {
        TLRPC$TL_dialogFilter tLRPC$TL_dialogFilter = ((TLRPC$TL_messages_updateDialogFilter) tLObject).filter;
        getAccountInstance().getCoreMainClass().addOrEditFolder(tLRPC$TL_dialogFilter.id != 0 ? IdStorage.getInstance().getFolderId(tLRPC$TL_dialogFilter.id) : null, tLRPC$TL_dialogFilter.flags, tLRPC$TL_dialogFilter.title, ChatConverter.getObjectGuidsFrom(this.currentAccount, tLRPC$TL_dialogFilter.include_peers), ChatConverter.getObjectGuidsFrom(this.currentAccount, tLRPC$TL_dialogFilter.exclude_peers), tLRPC$TL_dialogFilter.suggested_folder_id, new LoadListener<FolderObject>(this) { // from class: androidMessenger.proxy.DialogsProxy.4
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(FolderObject folderObject) {
                requestDelegate.run(null, null);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                requestDelegate.run(null, null);
            }
        });
    }

    public void getFolders(final boolean z) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda104
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getFolders$20(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getFolders$20(boolean z) {
        if (z) {
            getAccountInstance().getCoreMainClass().forceGetFolders();
        } else {
            getAccountInstance().getCoreMainClass().initFolders();
        }
    }

    public void loadSuggestedFolders(TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_messages_getSuggestedDialogFilters) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda58
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadSuggestedFolders$21(requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadSuggestedFolders$21(final RequestDelegate requestDelegate) {
        getAccountInstance().getCoreMainClass().loadSuggestedFilters(new LoadListener<ArrayList<DialogFilterSuggested>>(this) { // from class: androidMessenger.proxy.DialogsProxy.5
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(ArrayList<DialogFilterSuggested> arrayList) {
                requestDelegate.run(new TLRPC$Vector(), null);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Failed To Load Suggested Folders";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        });
    }

    public void processSuggestedFolders(ArrayList<MessagesController.DialogFilter> arrayList) {
        ArrayList<TLRPC$TL_dialogFilterSuggested> arrayListConvertAllSuggestedFilters = ChatConverter.convertAllSuggestedFilters(getAccountInstance().getCoreMainClass().getSuggestedFolderListInstant());
        if (!arrayListConvertAllSuggestedFilters.isEmpty()) {
            Iterator<MessagesController.DialogFilter> it = arrayList.iterator();
            while (it.hasNext()) {
                MessagesController.DialogFilter next = it.next();
                if (next.isSuggested) {
                    Iterator<TLRPC$TL_dialogFilterSuggested> it2 = arrayListConvertAllSuggestedFilters.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            TLRPC$TL_dialogFilterSuggested next2 = it2.next();
                            if (next2.suggested_folder_id.equals(next.suggestedFolderId)) {
                                arrayListConvertAllSuggestedFilters.remove(next2);
                                break;
                            }
                        }
                    }
                }
            }
        }
        if (arrayListConvertAllSuggestedFilters.isEmpty()) {
            return;
        }
        getAccountInstance().getMessagesController().processLoadedDialogFiltersSuggested(arrayListConvertAllSuggestedFilters);
    }

    public void deleteDialogFilter(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_messages_updateDialogFilter) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda82
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$deleteDialogFilter$22(tLObject, requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteDialogFilter$22(TLObject tLObject, final RequestDelegate requestDelegate) {
        getAccountInstance().getCoreMainClass().deleteFolder(IdStorage.getInstance().getFolderId(((TLRPC$TL_messages_updateDialogFilter) tLObject).id), new LoadListener<String>(this) { // from class: androidMessenger.proxy.DialogsProxy.6
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(String str) {
                requestDelegate.run(null, null);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Failed To Remove Folder";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        });
    }

    public void initMessenger() {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$initMessenger$23();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initMessenger$23() {
        getCoreMainClass().initMessenger();
        SendMessagesHelper.getInstance(this.currentAccount).checkUnsentMessages();
    }

    public void saveDialogFiltersOrder(final TLObject tLObject, RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_messages_updateDialogFiltersOrder) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda64
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$saveDialogFiltersOrder$24(tLObject);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveDialogFiltersOrder$24(TLObject tLObject) {
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<Integer> it = ((TLRPC$TL_messages_updateDialogFiltersOrder) tLObject).order.iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            if (next != null) {
                arrayList.add(IdStorage.getInstance().getFolderId(next.intValue()));
            }
        }
        getAccountInstance().getCoreMainClass().reorderFolders(arrayList);
    }

    public void pinDialogInFilter(final long j, final MessagesController.DialogFilter dialogFilter, final boolean z) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda34
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$pinDialogInFilter$25(j, dialogFilter, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$pinDialogInFilter$25(long j, MessagesController.DialogFilter dialogFilter, boolean z) {
        String dialogId = IdStorage.getInstance().getDialogId(j);
        getAccountInstance().getCoreMainClass().togglePinChatInFolder(IdStorage.getInstance().getFolderId(dialogFilter.id), dialogId, z);
    }

    public int createChat(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (!(tLObject instanceof TLRPC$TL_messages_createChat)) {
            return 0;
        }
        final int andIncReqId = IdStorage.getInstance().getAndIncReqId();
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda88
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createChat$26(tLObject, requestDelegate, andIncReqId);
            }
        });
        return andIncReqId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createChat$26(TLObject tLObject, final RequestDelegate requestDelegate, int i) {
        TLRPC$TL_messages_createChat tLRPC$TL_messages_createChat = (TLRPC$TL_messages_createChat) tLObject;
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<TLRPC$InputUser> it = tLRPC$TL_messages_createChat.users.iterator();
        while (it.hasNext()) {
            arrayList.add(IdStorage.getInstance().getDialogId(it.next().user_id));
        }
        TLRPC$InputFile tLRPC$InputFile = tLRPC$TL_messages_createChat.photo;
        String strValueOf = tLRPC$InputFile != null ? String.valueOf(tLRPC$InputFile.id) : null;
        TLRPC$InputFile tLRPC$InputFile2 = tLRPC$TL_messages_createChat.smallPhoto;
        IdStorage.getInstance().binReqIds(i, getAccountInstance().getCoreMainClass().addGroup(tLRPC$TL_messages_createChat.title, arrayList, strValueOf, tLRPC$InputFile2 != null ? String.valueOf(tLRPC$InputFile2.id) : null, new LoadListener<String>(this) { // from class: androidMessenger.proxy.DialogsProxy.7
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(String str) {
                TLRPC$TL_updates tLRPC$TL_updates = new TLRPC$TL_updates();
                tLRPC$TL_updates.chats = new ArrayList<>();
                TLRPC$TL_chat tLRPC$TL_chat = new TLRPC$TL_chat();
                tLRPC$TL_chat.id = (int) (IdStorage.getInstance().generateNegativeDialogId(str) * (-1));
                tLRPC$TL_updates.chats.add(tLRPC$TL_chat);
                requestDelegate.run(tLRPC$TL_updates, null);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Failed To Create Group";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        }));
    }

    public int createChannel(final String str, final String str2, final long j, final long j2, final boolean z, final ArrayList<TLRPC$InputUser> arrayList, final RequestDelegate requestDelegate) {
        final int andIncReqId = IdStorage.getInstance().getAndIncReqId();
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda51
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createChannel$27(arrayList, j, j2, str, str2, z, requestDelegate, andIncReqId);
            }
        });
        return andIncReqId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createChannel$27(ArrayList arrayList, long j, long j2, String str, String str2, boolean z, final RequestDelegate requestDelegate, int i) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(IdStorage.getInstance().getDialogId(((TLRPC$InputUser) it.next()).user_id));
        }
        IdStorage.getInstance().binReqIds(i, getAccountInstance().getCoreMainClass().addChannel(str, arrayList2, str2, z, j != 0 ? String.valueOf(j) : null, j2 != 0 ? String.valueOf(j2) : null, new LoadListener<String>(this) { // from class: androidMessenger.proxy.DialogsProxy.8
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(String str3) {
                TLRPC$TL_updates tLRPC$TL_updates = new TLRPC$TL_updates();
                tLRPC$TL_updates.chats = new ArrayList<>();
                TLRPC$TL_chat tLRPC$TL_chat = new TLRPC$TL_chat();
                tLRPC$TL_chat.id = (int) (IdStorage.getInstance().generateNegativeDialogId(str3) * (-1));
                tLRPC$TL_updates.chats.add(tLRPC$TL_chat);
                requestDelegate.run(tLRPC$TL_updates, null);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Failed To Create Channel";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        }));
    }

    public TLRPC$Chat getChat(int i) {
        ChatType chatType;
        long j = -i;
        String dialogId = IdStorage.getInstance().getDialogId(j);
        if (getCoreMainClass().loadForGuid(dialogId)) {
            ChatAbsObject absInstant = getAccountInstance().getCoreMainClass().getAbsInstant(dialogId);
            Chat chatForceGetChatInstant = getAccountInstance().getCoreMainClass().forceGetChatInstant(dialogId);
            if (absInstant != null && ((chatType = absInstant.type) == ChatType.Channel || chatType == ChatType.Group)) {
                return ChatConverter.convertChannelGroup(getCoreMainClass(), j, absInstant, chatForceGetChatInstant);
            }
        }
        return null;
    }

    public TLRPC$User getUser(int i) {
        ChatType chatType;
        long j = i;
        String dialogId = IdStorage.getInstance().getDialogId(j);
        if (getCoreMainClass().loadForGuid(dialogId)) {
            ChatAbsObject absInstant = getAccountInstance().getCoreMainClass().getAbsInstant(dialogId);
            Chat chatForceGetChatInstant = getAccountInstance().getCoreMainClass().forceGetChatInstant(dialogId);
            if (absInstant != null && ((chatType = absInstant.type) == ChatType.User || chatType == ChatType.Service || chatType == ChatType.Bot)) {
                return ChatConverter.convertUser(getCoreMainClass(), j, absInstant, (UserInfo) null, chatForceGetChatInstant);
            }
        }
        return null;
    }

    public int getChatMembers(final String str, final String str2, final String str3, final RequestDelegate requestDelegate) {
        final int andIncReqId = IdStorage.getInstance().getAndIncReqId();
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda61
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getChatMembers$28(requestDelegate, str, str2, str3, andIncReqId);
            }
        });
        return andIncReqId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getChatMembers$28(final RequestDelegate requestDelegate, String str, String str2, String str3, int i) {
        int groupAllMembers;
        GetMemberListener getMemberListener = new GetMemberListener() { // from class: androidMessenger.proxy.DialogsProxy.9
            @Override // ir.aaap.messengercore.GetMemberListener
            public void onMembersDidLoad(ArrayList<InChatMember> arrayList, boolean z, String str4) {
                requestDelegate.run(ObjectInfoConverter.convertMembers(DialogsProxy.this.getAccountInstance().getCoreMainClass(), arrayList), null);
            }

            @Override // ir.aaap.messengercore.GetMemberListener
            public void onMembersLoadingFailed() {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Failed To Get Group Members";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        };
        if (getCoreMainClass().isChannel(str)) {
            groupAllMembers = getCoreMainClass().getChannelAllMembers(str, str2, str3, getMemberListener);
        } else {
            groupAllMembers = getCoreMainClass().getGroupAllMembers(str, str2, str3, getMemberListener);
        }
        IdStorage.getInstance().binReqIds(i, groupAllMembers);
    }

    public int getMembersByType(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (!(tLObject instanceof TLRPC$TL_channels_getParticipants)) {
            return 0;
        }
        final int andIncReqId = IdStorage.getInstance().getAndIncReqId();
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda89
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getMembersByType$29(tLObject, requestDelegate, andIncReqId);
            }
        });
        return andIncReqId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getMembersByType$29(TLObject tLObject, final RequestDelegate requestDelegate, int i) {
        TLRPC$TL_channels_getParticipants tLRPC$TL_channels_getParticipants = (TLRPC$TL_channels_getParticipants) tLObject;
        String dialogId = IdStorage.getInstance().getDialogId(-tLRPC$TL_channels_getParticipants.channel.channel_id);
        String str = tLRPC$TL_channels_getParticipants.nextStartId;
        GetMemberListener getMemberListener = new GetMemberListener() { // from class: androidMessenger.proxy.DialogsProxy.10
            @Override // ir.aaap.messengercore.GetMemberListener
            public void onMembersDidLoad(ArrayList<InChatMember> arrayList, boolean z, String str2) {
                TLRPC$TL_channels_channelParticipants tLRPC$TL_channels_channelParticipantsConvertMembers = ObjectInfoConverter.convertMembers(DialogsProxy.this.getAccountInstance().getCoreMainClass(), arrayList);
                tLRPC$TL_channels_channelParticipantsConvertMembers.nextStartId = str2;
                tLRPC$TL_channels_channelParticipantsConvertMembers.hasContinue = z;
                requestDelegate.run(tLRPC$TL_channels_channelParticipantsConvertMembers, null);
            }

            @Override // ir.aaap.messengercore.GetMemberListener
            public void onMembersLoadingFailed() {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Failed To Get Members";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        };
        TLRPC$ChannelParticipantsFilter tLRPC$ChannelParticipantsFilter = tLRPC$TL_channels_getParticipants.filter;
        String str2 = !TextUtils.isEmpty(tLRPC$ChannelParticipantsFilter.q) ? tLRPC$ChannelParticipantsFilter.q : null;
        int groupMentionList = 0;
        if (tLRPC$ChannelParticipantsFilter instanceof TLRPC$TL_channelParticipantsNotAdmins) {
            if (getCoreMainClass().isChannel(dialogId)) {
                groupMentionList = getCoreMainClass().getChannelNotAdminMembers(dialogId, str, str2, getMemberListener);
            } else {
                groupMentionList = getCoreMainClass().getGroupNotAdminMembers(dialogId, str, str2, getMemberListener);
            }
        } else if (tLRPC$ChannelParticipantsFilter instanceof TLRPC$TL_channelParticipantsRecent) {
            if (getCoreMainClass().isChannel(dialogId)) {
                groupMentionList = getCoreMainClass().getChannelAllMembers(dialogId, str, str2, getMemberListener);
            } else {
                groupMentionList = getCoreMainClass().getGroupAllMembers(dialogId, str, str2, getMemberListener);
            }
        } else if (tLRPC$ChannelParticipantsFilter instanceof TLRPC$TL_channelParticipantsKicked) {
            if (getCoreMainClass().isChannel(dialogId)) {
                groupMentionList = getCoreMainClass().getChannelBannedMembers(dialogId, str, str2, getMemberListener);
            } else {
                groupMentionList = getCoreMainClass().getGroupBannedMembers(dialogId, str, str2, getMemberListener);
            }
        } else if (tLRPC$ChannelParticipantsFilter instanceof TLRPC$TL_channelParticipantsAdmins) {
            if (getCoreMainClass().isChannel(dialogId)) {
                groupMentionList = getCoreMainClass().getChannelAdmins(dialogId, str, str2, getMemberListener);
            } else {
                groupMentionList = getCoreMainClass().getGroupAdmins(dialogId, str, str2, getMemberListener);
            }
        } else if (tLRPC$ChannelParticipantsFilter instanceof TLRPC$TL_channelParticipantsSearch) {
            if (getCoreMainClass().isChannel(dialogId)) {
                groupMentionList = getCoreMainClass().getChannelAllMembers(dialogId, str, str2, getMemberListener);
            } else {
                groupMentionList = getCoreMainClass().getGroupAllMembers(dialogId, str, str2, getMemberListener);
            }
        } else if ((tLRPC$ChannelParticipantsFilter instanceof TLRPC$TL_channelParticipantsMentions) && !getCoreMainClass().isChannel(dialogId)) {
            groupMentionList = getCoreMainClass().getGroupMentionList(dialogId, str, str2, getMemberListener);
        }
        if (groupMentionList != 0) {
            IdStorage.getInstance().binReqIds(i, groupMentionList);
        }
    }

    public void loadCurrentUserFromCore() {
        if (getUserConfig().getCurrentUser() == null) {
            TLRPC$User currentUser = getCurrentUser(false);
            UserConfig.getInstance(this.currentAccount).setCurrentUser(currentUser);
            getMessagesController().putUser(currentUser, true);
        }
    }

    public void loadCurrentUser() {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadCurrentUser$31();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadCurrentUser$31() {
        TLRPC$User currentUser = getCurrentUser(false);
        UserConfig.getInstance(this.currentAccount).setCurrentUser(currentUser);
        getMessagesController().putUser(currentUser, true);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadCurrentUser$30();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadCurrentUser$30() {
        getNotificationCenter().postNotificationName(NotificationCenter.updateInterfaces, Integer.valueOf(MessagesController.UPDATE_MASK_ALL));
        getNotificationCenter().postNotificationName(NotificationCenter.mainUserInfoChanged, new Object[0]);
    }

    public void loadDialogPhotos(final int i, int i2, final long j, boolean z, final int i3) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda18
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadDialogPhotos$32(i, j, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadDialogPhotos$32(final int i, final long j, final int i2) {
        getAccountInstance().getCoreMainClass().getAvatars(IdStorage.getInstance().getDialogId(i), new GetAvatarsListener() { // from class: androidMessenger.proxy.DialogsProxy.11
            @Override // ir.aaap.messengercore.GetAvatarsListener
            public void onAvatarsDidLoad(ArrayList<AvatarObject> arrayList) {
                if (arrayList == null || arrayList.size() <= 0) {
                    return;
                }
                DialogsProxy.this.getMessagesController().processLoadedUserPhotos(MessageConverter.convertAvatars(arrayList), null, i, arrayList.size(), j, false, i2);
            }

            @Override // ir.aaap.messengercore.GetAvatarsListener
            public void onAvatarsLoadingFailed() {
                MyLog.e("Avatars", "Failed To Load Avatars");
            }
        });
    }

    public boolean canDeleteAvatar(TLRPC$Chat tLRPC$Chat) {
        if (tLRPC$Chat == null) {
            return false;
        }
        return getCoreMainClass().canDeleteAvatar(IdStorage.getInstance().getDialogId(-tLRPC$Chat.id));
    }

    public void changeChat(final int i, final String str, final String str2, final boolean z, final boolean z2, final boolean z3, final boolean z4, final RequestDelegate requestDelegate) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda20
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$changeChat$33(i, z4, str, str2, z2, requestDelegate, z3, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$changeChat$33(int i, boolean z, String str, String str2, boolean z2, RequestDelegate requestDelegate, boolean z3, boolean z4) {
        String dialogId = IdStorage.getInstance().getDialogId(-i);
        if (z) {
            ObjectInfo objectInfoInstant = getCoreMainClass().getObjectInfoInstant(dialogId);
            if (objectInfoInstant == null || objectInfoInstant.channelInfo == null) {
                return;
            }
            getCoreMainClass().editChannelInfo(dialogId, str, str2, z2, objectInfoInstant.channelInfo.channel_type == ChannelInfoFromServer.ChannelTypeEnum.Public, new AnonymousClass12(requestDelegate));
            return;
        }
        getCoreMainClass().editGroupInfo(dialogId, str, str2, z3, z4, new AnonymousClass13(i, requestDelegate));
    }

    /* renamed from: androidMessenger.proxy.DialogsProxy$12, reason: invalid class name */
    class AnonymousClass12 implements LoadListener<String> {
        final /* synthetic */ RequestDelegate val$onComplete;

        AnonymousClass12(RequestDelegate requestDelegate) {
            this.val$onComplete = requestDelegate;
        }

        @Override // ir.aaap.messengercore.LoadListener
        public void onDidLoad(final String str) {
            if (str == null || str.isEmpty()) {
                return;
            }
            DispatchQueue dispatchQueue = Utilities.stageQueue;
            final RequestDelegate requestDelegate = this.val$onComplete;
            dispatchQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$12$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onDidLoad$0(str, requestDelegate);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onDidLoad$0(String str, RequestDelegate requestDelegate) {
            Chat chatInstant = DialogsProxy.this.getCoreMainClass().getChatInstant(str);
            ObjectInfo objectInfoInstant = DialogsProxy.this.getCoreMainClass().getObjectInfoInstant(str);
            ChatAbsObject absInstant = DialogsProxy.this.getCoreMainClass().getAbsInstant(str);
            if (chatInstant == null || objectInfoInstant == null || absInstant == null) {
                return;
            }
            requestDelegate.run(null, null);
        }

        @Override // ir.aaap.messengercore.LoadListener
        public void onError(Exception exc) {
            TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
            tLRPC$TL_error.text = "Failed To Change Channel";
            this.val$onComplete.run(null, tLRPC$TL_error);
        }
    }

    /* renamed from: androidMessenger.proxy.DialogsProxy$13, reason: invalid class name */
    class AnonymousClass13 implements LoadListener<String> {
        final /* synthetic */ int val$chatId;
        final /* synthetic */ RequestDelegate val$onComplete;

        AnonymousClass13(int i, RequestDelegate requestDelegate) {
            this.val$chatId = i;
            this.val$onComplete = requestDelegate;
        }

        @Override // ir.aaap.messengercore.LoadListener
        public void onDidLoad(final String str) {
            if (str == null || str.isEmpty()) {
                return;
            }
            DispatchQueue dispatchQueue = Utilities.stageQueue;
            final int i = this.val$chatId;
            final RequestDelegate requestDelegate = this.val$onComplete;
            dispatchQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$13$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() throws InterruptedException {
                    this.f$0.lambda$onDidLoad$0(str, i, requestDelegate);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onDidLoad$0(String str, int i, RequestDelegate requestDelegate) throws InterruptedException {
            Chat chatInstant = DialogsProxy.this.getCoreMainClass().getChatInstant(str);
            ObjectInfo objectInfoInstant = DialogsProxy.this.getCoreMainClass().getObjectInfoInstant(str);
            ChatAbsObject absInstant = DialogsProxy.this.getCoreMainClass().getAbsInstant(str);
            if (chatInstant == null || objectInfoInstant == null || absInstant == null) {
                return;
            }
            DialogsProxy.this.getMessagesController().processFullChat(ObjectInfoConverter.convert(DialogsProxy.this.getCoreMainClass(), ChatConverter.convertChannelGroup(DialogsProxy.this.getAccountInstance().getCoreMainClass(), absInstant, chatInstant), objectInfoInstant, absInstant.type), null, -1, -i);
            requestDelegate.run(null, null);
        }

        @Override // ir.aaap.messengercore.LoadListener
        public void onError(Exception exc) {
            TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
            tLRPC$TL_error.text = "Failed To Change Group";
            this.val$onComplete.run(null, tLRPC$TL_error);
        }
    }

    public void removeMemberFromChat(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if ((tLObject instanceof TLRPC$TL_messages_deleteChatUser) || (tLObject instanceof TLRPC$TL_messages_deleteChat) || (tLObject instanceof TLRPC$TL_channels_deleteChannel) || (tLObject instanceof TLRPC$TL_channels_leaveChannel) || (tLObject instanceof TLRPC$TL_channels_editBanned)) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda62
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$removeMemberFromChat$34(requestDelegate, tLObject);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removeMemberFromChat$34(final RequestDelegate requestDelegate, TLObject tLObject) {
        LoadListener<String> loadListener = new LoadListener<String>(this) { // from class: androidMessenger.proxy.DialogsProxy.14
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(String str) {
                requestDelegate.run(new TLRPC$TL_updates(), null);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Couldn't Do The Action";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        };
        if (tLObject instanceof TLRPC$TL_channels_leaveChannel) {
            getAccountInstance().getCoreMainClass().leaveChannel(IdStorage.getInstance().getDialogId(((TLRPC$TL_channels_leaveChannel) tLObject).channel.channel_id * (-1)), loadListener);
            return;
        }
        if (tLObject instanceof TLRPC$TL_messages_deleteChatUser) {
            TLRPC$InputUser tLRPC$InputUser = ((TLRPC$TL_messages_deleteChatUser) tLObject).user_id;
            String dialogId = IdStorage.getInstance().getDialogId(tLRPC$InputUser.user_id);
            String dialogId2 = IdStorage.getInstance().getDialogId(r9.chat_id * (-1));
            if ((dialogId != null && dialogId.equals(getCoreMainClass().getMyGuid())) || (tLRPC$InputUser instanceof TLRPC$TL_inputUserSelf)) {
                getAccountInstance().getCoreMainClass().leaveGroup(dialogId2, loadListener);
                return;
            } else {
                getAccountInstance().getCoreMainClass().banGroupMember(dialogId2, dialogId, true, new LoadListener<Integer>(this) { // from class: androidMessenger.proxy.DialogsProxy.15
                    @Override // ir.aaap.messengercore.LoadListener
                    public void onDidLoad(Integer num) {
                        requestDelegate.run(new TLRPC$TL_updates(), null);
                    }

                    @Override // ir.aaap.messengercore.LoadListener
                    public void onError(Exception exc) {
                        TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                        tLRPC$TL_error.text = "Couldn't Ban Member";
                        requestDelegate.run(null, tLRPC$TL_error);
                    }
                });
                return;
            }
        }
        if (tLObject instanceof TLRPC$TL_channels_editBanned) {
            if (((TLRPC$TL_channels_editBanned) tLObject).participant instanceof TLRPC$TL_inputPeerUser) {
                getAccountInstance().getCoreMainClass().banChannelMember(IdStorage.getInstance().getDialogId(r9.channel.channel_id * (-1)), IdStorage.getInstance().getDialogId(r0.user_id), true, new LoadListener<Integer>(this) { // from class: androidMessenger.proxy.DialogsProxy.16
                    @Override // ir.aaap.messengercore.LoadListener
                    public void onDidLoad(Integer num) {
                        requestDelegate.run(new TLRPC$TL_updates(), null);
                    }

                    @Override // ir.aaap.messengercore.LoadListener
                    public void onError(Exception exc) {
                        TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                        tLRPC$TL_error.text = "Couldn't Ban Member";
                        requestDelegate.run(null, tLRPC$TL_error);
                    }
                });
                return;
            }
            return;
        }
        if (tLObject instanceof TLRPC$TL_channels_deleteChannel) {
            getAccountInstance().getCoreMainClass().deleteChannel(IdStorage.getInstance().getDialogId(((TLRPC$TL_channels_deleteChannel) tLObject).channel.channel_id * (-1)), loadListener);
        }
    }

    public void removeMemberFromBanList(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_channels_editBanned) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda67
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$removeMemberFromBanList$35(tLObject, requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removeMemberFromBanList$35(TLObject tLObject, final RequestDelegate requestDelegate) {
        TLRPC$TL_channels_editBanned tLRPC$TL_channels_editBanned = (TLRPC$TL_channels_editBanned) tLObject;
        String dialogId = IdStorage.getInstance().getDialogId(tLRPC$TL_channels_editBanned.participant.user_id);
        final String dialogId2 = IdStorage.getInstance().getDialogId(tLRPC$TL_channels_editBanned.channel.channel_id * (-1));
        if (getCoreMainClass().isChannel(dialogId2)) {
            getAccountInstance().getCoreMainClass().banChannelMember(dialogId2, dialogId, false, new LoadListener<Integer>(this) { // from class: androidMessenger.proxy.DialogsProxy.17
                @Override // ir.aaap.messengercore.LoadListener
                public void onDidLoad(Integer num) {
                    TLRPC$TL_updates tLRPC$TL_updates = new TLRPC$TL_updates();
                    tLRPC$TL_updates.chats = new ArrayList<>();
                    TLRPC$TL_chat tLRPC$TL_chat = new TLRPC$TL_chat();
                    tLRPC$TL_chat.id = (int) (IdStorage.getInstance().generateNegativeDialogId(dialogId2) * (-1));
                    tLRPC$TL_updates.chats.add(tLRPC$TL_chat);
                    requestDelegate.run(tLRPC$TL_updates, null);
                }

                @Override // ir.aaap.messengercore.LoadListener
                public void onError(Exception exc) {
                    TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                    tLRPC$TL_error.text = "Couldn't Ban Member";
                    requestDelegate.run(null, tLRPC$TL_error);
                }
            });
        } else {
            getAccountInstance().getCoreMainClass().banGroupMember(dialogId2, dialogId, false, new LoadListener<Integer>(this) { // from class: androidMessenger.proxy.DialogsProxy.18
                @Override // ir.aaap.messengercore.LoadListener
                public void onDidLoad(Integer num) {
                    TLRPC$TL_updates tLRPC$TL_updates = new TLRPC$TL_updates();
                    tLRPC$TL_updates.chats = new ArrayList<>();
                    TLRPC$TL_chat tLRPC$TL_chat = new TLRPC$TL_chat();
                    tLRPC$TL_chat.id = (int) (IdStorage.getInstance().generateNegativeDialogId(dialogId2) * (-1));
                    tLRPC$TL_updates.chats.add(tLRPC$TL_chat);
                    requestDelegate.run(tLRPC$TL_updates, null);
                }

                @Override // ir.aaap.messengercore.LoadListener
                public void onError(Exception exc) {
                    TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                    tLRPC$TL_error.text = "Couldn't Ban Member";
                    requestDelegate.run(null, tLRPC$TL_error);
                }
            });
        }
    }

    public void addMembersToChat(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if ((tLObject instanceof TLRPC$TL_channels_inviteToChannel) || (tLObject instanceof TLRPC$TL_messages_addChatUser) || (tLObject instanceof TLRPC$TL_channels_joinChannel)) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda70
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$addMembersToChat$36(tLObject, requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addMembersToChat$36(TLObject tLObject, final RequestDelegate requestDelegate) {
        String dialogId;
        boolean z = tLObject instanceof TLRPC$TL_channels_inviteToChannel;
        if (z || (tLObject instanceof TLRPC$TL_messages_addChatUser)) {
            ArrayList<String> arrayList = new ArrayList<>();
            if (z) {
                dialogId = IdStorage.getInstance().getDialogId(-r7.channel.channel_id);
                Iterator<TLRPC$InputUser> it = ((TLRPC$TL_channels_inviteToChannel) tLObject).users.iterator();
                while (it.hasNext()) {
                    arrayList.add(IdStorage.getInstance().getDialogId(it.next().user_id));
                }
            } else {
                TLRPC$TL_messages_addChatUser tLRPC$TL_messages_addChatUser = (TLRPC$TL_messages_addChatUser) tLObject;
                dialogId = IdStorage.getInstance().getDialogId(-tLRPC$TL_messages_addChatUser.chat_id);
                if (tLRPC$TL_messages_addChatUser.user_id != null) {
                    arrayList.add(IdStorage.getInstance().getDialogId(tLRPC$TL_messages_addChatUser.user_id.user_id));
                } else if (!tLRPC$TL_messages_addChatUser.user_ids.isEmpty()) {
                    Iterator<TLRPC$InputUser> it2 = tLRPC$TL_messages_addChatUser.user_ids.iterator();
                    while (it2.hasNext()) {
                        arrayList.add(IdStorage.getInstance().getDialogId(it2.next().user_id));
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            LoadListener<ArrayList<InChatMember>> loadListener = new LoadListener<ArrayList<InChatMember>>() { // from class: androidMessenger.proxy.DialogsProxy.19
                @Override // ir.aaap.messengercore.LoadListener
                public void onDidLoad(ArrayList<InChatMember> arrayList2) {
                    TLRPC$TL_updates tLRPC$TL_updates = new TLRPC$TL_updates();
                    TLRPC$TL_updateAddedUsers tLRPC$TL_updateAddedUsers = new TLRPC$TL_updateAddedUsers();
                    Iterator<InChatMember> it3 = arrayList2.iterator();
                    while (it3.hasNext()) {
                        TLRPC$User tLRPC$UserConvertMemberToUser = ObjectInfoConverter.convertMemberToUser(DialogsProxy.this.getCoreMainClass(), it3.next());
                        if (tLRPC$UserConvertMemberToUser != null) {
                            tLRPC$TL_updateAddedUsers.users.add(tLRPC$UserConvertMemberToUser);
                        }
                    }
                    tLRPC$TL_updates.updates.add(tLRPC$TL_updateAddedUsers);
                    requestDelegate.run(tLRPC$TL_updates, null);
                }

                @Override // ir.aaap.messengercore.LoadListener
                public void onError(Exception exc) {
                    TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                    tLRPC$TL_error.text = "Couldn't Add Member";
                    requestDelegate.run(null, tLRPC$TL_error);
                }
            };
            if (getCoreMainClass().isChannel(dialogId)) {
                getCoreMainClass().addChannelMembers(dialogId, arrayList, loadListener);
                return;
            } else {
                getCoreMainClass().addGroupMembers(dialogId, arrayList, loadListener);
                return;
            }
        }
        getCoreMainClass().joinChannel(IdStorage.getInstance().getDialogId(-((TLRPC$TL_channels_joinChannel) tLObject).channel.channel_id), new LoadListener<String>(this) { // from class: androidMessenger.proxy.DialogsProxy.20
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(String str) {
                requestDelegate.run(new TLRPC$TL_updates(), null);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Couldn't Join Channel";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        });
    }

    public void getGroupLinks(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if ((tLObject instanceof TLRPC$TL_messages_getExportedChatInvites) || (tLObject instanceof TLRPC$TL_messages_exportChatInvite)) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda85
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$getGroupLinks$37(tLObject, requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getGroupLinks$37(final TLObject tLObject, final RequestDelegate requestDelegate) {
        int i;
        if (tLObject instanceof TLRPC$TL_messages_exportChatInvite) {
            i = ((TLRPC$TL_messages_exportChatInvite) tLObject).peer.channel_id;
        } else {
            i = ((TLRPC$TL_messages_getExportedChatInvites) tLObject).peer.channel_id;
        }
        String dialogId = IdStorage.getInstance().getDialogId(-i);
        LoadListener<String> loadListener = new LoadListener<String>(this) { // from class: androidMessenger.proxy.DialogsProxy.21
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(String str) {
                if (str != null && str.length() > 0) {
                    TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported = new TLRPC$TL_chatInviteExported();
                    tLRPC$TL_chatInviteExported.link = str;
                    tLRPC$TL_chatInviteExported.permanent = true;
                    if (tLObject instanceof TLRPC$TL_messages_exportChatInvite) {
                        requestDelegate.run(tLRPC$TL_chatInviteExported, null);
                        return;
                    }
                    TLRPC$TL_messages_exportedChatInvites tLRPC$TL_messages_exportedChatInvites = new TLRPC$TL_messages_exportedChatInvites();
                    tLRPC$TL_messages_exportedChatInvites.count = 1;
                    ArrayList<TLRPC$ExportedChatInvite> arrayList = new ArrayList<>();
                    tLRPC$TL_messages_exportedChatInvites.invites = arrayList;
                    arrayList.add(tLRPC$TL_chatInviteExported);
                    requestDelegate.run(tLRPC$TL_messages_exportedChatInvites, null);
                    return;
                }
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Couldn't Get Chat Link";
                requestDelegate.run(null, tLRPC$TL_error);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Couldn't Get Chat Link";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        };
        if (getCoreMainClass().isChannel(dialogId)) {
            getCoreMainClass().getChannelLink(dialogId, loadListener);
        } else {
            getCoreMainClass().getGroupLink(dialogId, loadListener);
        }
    }

    public void setGroupOrChannelLinks(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_messages_exportChatInvite) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda71
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setGroupOrChannelLinks$38(tLObject, requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setGroupOrChannelLinks$38(TLObject tLObject, final RequestDelegate requestDelegate) {
        boolean z = ((TLRPC$TL_messages_exportChatInvite) tLObject).newRequest;
        String dialogId = IdStorage.getInstance().getDialogId(-r5.peer.channel_id);
        LoadListener<String> loadListener = new LoadListener<String>(this) { // from class: androidMessenger.proxy.DialogsProxy.22
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(String str) {
                if (str != null && str.length() > 0) {
                    TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported = new TLRPC$TL_chatInviteExported();
                    tLRPC$TL_chatInviteExported.link = str;
                    tLRPC$TL_chatInviteExported.permanent = true;
                    requestDelegate.run(tLRPC$TL_chatInviteExported, null);
                    return;
                }
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Couldn't Get Chat Link";
                tLRPC$TL_error.code = 100;
                requestDelegate.run(null, tLRPC$TL_error);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Couldn't Get Chat Link";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        };
        if (TextUtils.isEmpty(dialogId)) {
            TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
            tLRPC$TL_error.text = "Empty Guid";
            requestDelegate.run(null, tLRPC$TL_error);
        } else {
            if (getCoreMainClass().isChannel(dialogId)) {
                if (z) {
                    getCoreMainClass().setChannelLink(dialogId, loadListener);
                    return;
                } else {
                    getCoreMainClass().getChannelLink(dialogId, loadListener);
                    return;
                }
            }
            if (z) {
                getCoreMainClass().setGroupLink(dialogId, loadListener);
            } else {
                getCoreMainClass().getGroupLink(dialogId, loadListener);
            }
        }
    }

    public void setChatAdmin(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_channels_editAdmin) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda68
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setChatAdmin$39(tLObject, requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setChatAdmin$39(TLObject tLObject, final RequestDelegate requestDelegate) {
        TLRPC$TL_channels_editAdmin tLRPC$TL_channels_editAdmin = (TLRPC$TL_channels_editAdmin) tLObject;
        String dialogId = IdStorage.getInstance().getDialogId(-tLRPC$TL_channels_editAdmin.channel.channel_id);
        long j = tLRPC$TL_channels_editAdmin.user_id.user_id;
        String dialogId2 = IdStorage.getInstance().getDialogId(j);
        ChatType chatType = getDialogsProxy().getChatType(j);
        LoadListener<InChatMember> loadListener = new LoadListener<InChatMember>(this) { // from class: androidMessenger.proxy.DialogsProxy.23
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(InChatMember inChatMember) {
                requestDelegate.run(new TLRPC$TL_updates(), null);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Couldn't Add Admin";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        };
        if (getCoreMainClass().isChannel(dialogId)) {
            if (tLRPC$TL_channels_editAdmin.unset) {
                getCoreMainClass().unSetChannelAdmin(dialogId, dialogId2, chatType, loadListener);
                return;
            } else {
                getCoreMainClass().setChannelAdmin(dialogId, dialogId2, chatType, ChatConverter.getChannelAdminAccesses(tLRPC$TL_channels_editAdmin.admin_rights), loadListener);
                return;
            }
        }
        if (tLRPC$TL_channels_editAdmin.unset) {
            getCoreMainClass().unSetGroupAdmin(dialogId, dialogId2, loadListener);
            return;
        }
        String str = tLRPC$TL_channels_editAdmin.rank;
        if (str == null || str.length() <= 0) {
            str = null;
        }
        getCoreMainClass().setGroupAdmin(dialogId, dialogId2, ChatConverter.getGroupAdminAccesses(tLRPC$TL_channels_editAdmin.admin_rights), str, loadListener);
    }

    public void processLoadedPinnedMessages(final String str, final long j) {
        ChatAbsObject absInstant;
        final Message messageInstant;
        if (j != 0 && (messageInstant = getCoreMainClass().getMessageInstant(str, j)) != null) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda43
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processLoadedPinnedMessages$41(str, j, messageInstant);
                }
            });
            return;
        }
        if (j != 0 || (absInstant = getCoreMainClass().getAbsInstant(str)) == null) {
            return;
        }
        final long dialogId = ChatConverter.getDialogId(str, absInstant.type);
        final ArrayList arrayList = new ArrayList();
        final HashMap map = new HashMap();
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda31
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processLoadedPinnedMessages$42(dialogId, arrayList, map);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processLoadedPinnedMessages$41(String str, long j, Message message) {
        ChatAbsObject absInstant = getCoreMainClass().getAbsInstant(str);
        if (absInstant == null) {
            return;
        }
        final long dialogId = ChatConverter.getDialogId(str, absInstant.type);
        final ArrayList arrayList = new ArrayList();
        final HashMap map = new HashMap();
        arrayList.add(Long.valueOf(j));
        map.put(Long.valueOf(j), new MessageObject(this.currentAccount, MessageConverter.convertToTlMessage(getCoreMainClass(), dialogId, absInstant.type == ChatType.Channel, message, null), false, false));
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda32
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processLoadedPinnedMessages$40(dialogId, arrayList, map);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processLoadedPinnedMessages$40(long j, ArrayList arrayList, HashMap map) {
        getNotificationCenter().postNotificationName(NotificationCenter.pinnedInfoDidLoad, Long.valueOf(j), arrayList, map, 1, Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processLoadedPinnedMessages$42(long j, ArrayList arrayList, HashMap map) {
        getNotificationCenter().postNotificationName(NotificationCenter.pinnedInfoDidLoad, Long.valueOf(j), arrayList, map, 0, Boolean.TRUE);
    }

    public void processLoadedPinnedMessages(final String str, final ArrayList<Long> arrayList) {
        final ChatAbsObject absInstant = getCoreMainClass().getAbsInstant(str);
        if (absInstant == null) {
            return;
        }
        final long dialogId = ChatConverter.getDialogId(str, absInstant.type);
        final ArrayList arrayList2 = new ArrayList();
        final HashMap map = new HashMap();
        if (arrayList != null && arrayList.size() > 0) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda52
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processLoadedPinnedMessages$44(arrayList, str, arrayList2, dialogId, absInstant, map);
                }
            });
        } else {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda30
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processLoadedPinnedMessages$45(dialogId, arrayList2, map);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processLoadedPinnedMessages$44(ArrayList arrayList, String str, final ArrayList arrayList2, final long j, ChatAbsObject chatAbsObject, final HashMap map) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Long l = (Long) it.next();
            Message messageInstant = getCoreMainClass().getMessageInstant(str, l.longValue());
            if (messageInstant != null) {
                arrayList2.add(l);
                map.put(l, new MessageObject(this.currentAccount, MessageConverter.convertToTlMessage(getCoreMainClass(), j, chatAbsObject.type == ChatType.Channel, messageInstant, null), false, false));
            }
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda33
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processLoadedPinnedMessages$43(j, arrayList2, map);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processLoadedPinnedMessages$43(long j, ArrayList arrayList, HashMap map) {
        getNotificationCenter().postNotificationName(NotificationCenter.pinnedInfoDidLoad, Long.valueOf(j), arrayList, new HashMap(map), Integer.valueOf(arrayList.size()), Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processLoadedPinnedMessages$45(long j, ArrayList arrayList, HashMap map) {
        getNotificationCenter().postNotificationName(NotificationCenter.pinnedInfoDidLoad, Long.valueOf(j), arrayList, map, 0, Boolean.TRUE);
    }

    public void deleteGroup(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_messages_deleteChat) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda69
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$deleteGroup$46(tLObject, requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteGroup$46(TLObject tLObject, final RequestDelegate requestDelegate) {
        getCoreMainClass().deleteGroup(IdStorage.getInstance().getDialogId(-((TLRPC$TL_messages_deleteChat) tLObject).chat_id), new LoadListener<String>(this) { // from class: androidMessenger.proxy.DialogsProxy.24
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(String str) {
                requestDelegate.run(new TLRPC$TL_updates(), null);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Couldn't Delete The Group";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        });
    }

    public void setChannelSlowMode(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_channels_toggleSlowMode) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda81
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setChannelSlowMode$47(tLObject, requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setChannelSlowMode$47(TLObject tLObject, final RequestDelegate requestDelegate) {
        getCoreMainClass().editGroupSlowMode(IdStorage.getInstance().getDialogId(-r5.channel.channel_id), ((TLRPC$TL_channels_toggleSlowMode) tLObject).seconds, new LoadListener<String>(this) { // from class: androidMessenger.proxy.DialogsProxy.25
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(String str) {
                requestDelegate.run(new TLRPC$TL_updates(), null);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Couldn't Change Slow Mode";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        });
    }

    public void loadAdminRights(final int i, final int i2, final RequestDelegate requestDelegate) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda17
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadAdminRights$48(i2, i, requestDelegate);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadAdminRights$48(int i, int i2, final RequestDelegate requestDelegate) {
        String dialogId = IdStorage.getInstance().getDialogId(i);
        String dialogId2 = IdStorage.getInstance().getDialogId(-i2);
        if (getCoreMainClass().isChannel(dialogId2)) {
            getCoreMainClass().getChannelAdminAccessList(dialogId2, dialogId, new GetChannelAdminAccessListListener(this) { // from class: androidMessenger.proxy.DialogsProxy.26
                @Override // ir.aaap.messengercore.GetChannelAdminAccessListListener
                public void onAccessDidLoad(String str, String str2, Set<Chat.EnumSetChannelAdminAccess> set) {
                    requestDelegate.run(ChatConverter.setChannelAdminRights(set), null);
                }

                @Override // ir.aaap.messengercore.GetChannelAdminAccessListListener
                public void onAccessLoadingFailed() {
                    TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                    tLRPC$TL_error.text = "Couldn't Load Admin Access List";
                    requestDelegate.run(null, tLRPC$TL_error);
                }
            });
        } else {
            getCoreMainClass().getGroupAdminAccessList(dialogId2, dialogId, new GetGroupAdminAccessListListener(this) { // from class: androidMessenger.proxy.DialogsProxy.27
                @Override // ir.aaap.messengercore.GetGroupAdminAccessListListener
                public void onAccessDidLoad(String str, String str2, Set<Chat.EnumSetGroupAdminAccess> set) {
                    requestDelegate.run(ChatConverter.setAdminRights(set), null);
                }

                @Override // ir.aaap.messengercore.GetGroupAdminAccessListListener
                public void onAccessLoadingFailed() {
                    TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                    tLRPC$TL_error.text = "Couldn't Load Admin Access List";
                    requestDelegate.run(null, tLRPC$TL_error);
                }
            });
        }
    }

    public void getDefaultBannedRights(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if ((tLObject instanceof TLRPC$TL_channels_getParticipants) && (((TLRPC$TL_channels_getParticipants) tLObject).filter instanceof TLRPC$TL_channelParticipantsBanned)) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda84
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$getDefaultBannedRights$49(tLObject, requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getDefaultBannedRights$49(TLObject tLObject, final RequestDelegate requestDelegate) {
        String dialogId = IdStorage.getInstance().getDialogId(-((TLRPC$TL_channels_getParticipants) tLObject).channel.channel_id);
        if (getCoreMainClass().isChannel(dialogId)) {
            return;
        }
        getCoreMainClass().getGroupDefaultAccessList(dialogId, new GetGroupDefaultAccessListListener(this) { // from class: androidMessenger.proxy.DialogsProxy.28
            @Override // ir.aaap.messengercore.GetGroupDefaultAccessListListener
            public void onAccessDidLoad(String str, Set<Chat.EnumSetGroupMemberAccess> set) {
                TLRPC$TL_chatBannedRights defaultAccessList = ChatConverter.setDefaultAccessList(set);
                TLRPC$TL_updateChatDefaultBannedRights tLRPC$TL_updateChatDefaultBannedRights = new TLRPC$TL_updateChatDefaultBannedRights();
                tLRPC$TL_updateChatDefaultBannedRights.default_banned_rights = defaultAccessList;
                requestDelegate.run(tLRPC$TL_updateChatDefaultBannedRights, null);
            }

            @Override // ir.aaap.messengercore.GetGroupDefaultAccessListListener
            public void onAccessLoadingFailed() {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Failed To Get Group Default Access List";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        });
    }

    public void setDefaultBannedRights(final TLObject tLObject, RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_messages_editChatDefaultBannedRights) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda65
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setDefaultBannedRights$50(tLObject);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setDefaultBannedRights$50(TLObject tLObject) {
        TLRPC$TL_messages_editChatDefaultBannedRights tLRPC$TL_messages_editChatDefaultBannedRights = (TLRPC$TL_messages_editChatDefaultBannedRights) tLObject;
        String dialogId = IdStorage.getInstance().getDialogId(-tLRPC$TL_messages_editChatDefaultBannedRights.peer.channel_id);
        if (getCoreMainClass().isChannel(dialogId)) {
            return;
        }
        getCoreMainClass().setGroupDefaultAccessList(dialogId, ChatConverter.getDefaultAccessList(tLRPC$TL_messages_editChatDefaultBannedRights.banned_rights));
    }

    public int getObjectInfoByUserName(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (!(tLObject instanceof TLRPC$TL_contacts_resolveUsername)) {
            return 0;
        }
        final int andIncReqId = IdStorage.getInstance().getAndIncReqId();
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda96
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getObjectInfoByUserName$51(tLObject, requestDelegate, andIncReqId);
            }
        });
        return andIncReqId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getObjectInfoByUserName$51(TLObject tLObject, final RequestDelegate requestDelegate, int i) {
        IdStorage.getInstance().binReqIds(i, getCoreMainClass().getObjectInfoByUsername(((TLRPC$TL_contacts_resolveUsername) tLObject).username, true, new LoadListener<String>() { // from class: androidMessenger.proxy.DialogsProxy.29
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(String str) {
                TLRPC$TL_contacts_resolvedPeer tLRPC$TL_contacts_resolvedPeer;
                TLRPC$User tLRPC$UserConvertService;
                if (str != null && !str.isEmpty()) {
                    ObjectInfo objectInfoInstant = DialogsProxy.this.getAccountInstance().getCoreMainClass().getObjectInfoInstant(str);
                    if (objectInfoInstant != null) {
                        tLRPC$TL_contacts_resolvedPeer = new TLRPC$TL_contacts_resolvedPeer();
                        ChatAbsObject absInstant = DialogsProxy.this.getAccountInstance().getCoreMainClass().getAbsInstant(str);
                        Chat chatInstant = DialogsProxy.this.getAccountInstance().getCoreMainClass().getChatInstant(str);
                        ChatType chatType = absInstant.type;
                        ChatType chatType2 = ChatType.User;
                        if (chatType == chatType2 || chatType == ChatType.Bot || chatType == ChatType.Service) {
                            long jGenerateDialogId = IdStorage.getInstance().generateDialogId(str);
                            ChatType chatType3 = absInstant.type;
                            if (chatType3 == chatType2) {
                                tLRPC$UserConvertService = ChatConverter.convertUser(DialogsProxy.this.getCoreMainClass(), jGenerateDialogId, absInstant, objectInfoInstant.userInfo, chatInstant);
                            } else {
                                tLRPC$UserConvertService = chatType3 == ChatType.Service ? ChatConverter.convertService(DialogsProxy.this.getCoreMainClass(), jGenerateDialogId, absInstant, objectInfoInstant.serviceInfo, chatInstant) : ChatConverter.convertBot(DialogsProxy.this.getCoreMainClass(), jGenerateDialogId, absInstant, objectInfoInstant.botInfo, chatInstant);
                            }
                            tLRPC$TL_contacts_resolvedPeer.users.add(tLRPC$UserConvertService);
                        } else {
                            tLRPC$TL_contacts_resolvedPeer.chats.add(ChatConverter.convertChannelGroup(DialogsProxy.this.getCoreMainClass(), absInstant, chatInstant));
                        }
                    } else {
                        tLRPC$TL_contacts_resolvedPeer = null;
                    }
                    requestDelegate.run(tLRPC$TL_contacts_resolvedPeer, null);
                    return;
                }
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "No Result Found";
                tLRPC$TL_error.code = -1;
                requestDelegate.run(null, tLRPC$TL_error);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                if (exc instanceof UsernameNotExistException) {
                    tLRPC$TL_error.text = "No Result Found";
                    tLRPC$TL_error.code = -1;
                } else {
                    tLRPC$TL_error.text = "Failed To Load Username";
                    tLRPC$TL_error.code = 0;
                }
                requestDelegate.run(null, tLRPC$TL_error);
            }
        }));
    }

    public int searchGlobalObjects(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (!(tLObject instanceof TLRPC$TL_contacts_search)) {
            return 0;
        }
        final int andIncReqId = IdStorage.getInstance().getAndIncReqId();
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda86
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$searchGlobalObjects$52(tLObject, requestDelegate, andIncReqId);
            }
        });
        return andIncReqId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$searchGlobalObjects$52(TLObject tLObject, RequestDelegate requestDelegate, int i) {
        TLRPC$TL_contacts_search tLRPC$TL_contacts_search = (TLRPC$TL_contacts_search) tLObject;
        IdStorage.getInstance().binReqIds(i, getCoreMainClass().searchGlobalObjects(tLRPC$TL_contacts_search.q, null, tLRPC$TL_contacts_search.filterTypes, new AnonymousClass30(requestDelegate)));
    }

    /* renamed from: androidMessenger.proxy.DialogsProxy$30, reason: invalid class name */
    class AnonymousClass30 implements LoadListener<SearchGlobalObjectsOutput> {
        final /* synthetic */ RequestDelegate val$onComplete;

        AnonymousClass30(RequestDelegate requestDelegate) {
            this.val$onComplete = requestDelegate;
        }

        @Override // ir.aaap.messengercore.LoadListener
        public void onDidLoad(SearchGlobalObjectsOutput searchGlobalObjectsOutput) {
            final TLRPC$TL_contacts_found tLRPC$TL_contacts_foundConvertAllInSearchObjects = ChatConverter.convertAllInSearchObjects(DialogsProxy.this.getCoreMainClass(), searchGlobalObjectsOutput.objects);
            final RequestDelegate requestDelegate = this.val$onComplete;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$30$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    requestDelegate.run(tLRPC$TL_contacts_foundConvertAllInSearchObjects, null);
                }
            });
        }

        @Override // ir.aaap.messengercore.LoadListener
        public void onError(Exception exc) {
            TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
            tLRPC$TL_error.text = "No Result Found";
            this.val$onComplete.run(null, tLRPC$TL_error);
        }
    }

    public void localSearch(String str, ArrayList<Object> arrayList, ArrayList<CharSequence> arrayList2, ArrayList<Object> arrayList3) {
        MyLog.e("DialogsProxy", str);
        String lowerCase = LocaleController.getString("SavedMessages", R.string.SavedMessages).toLowerCase();
        ChatConverter.convertAllInSearchObject(getCoreMainClass(), getCoreMainClass().searchLocalInContacts(str), getCoreMainClass().searchLocalInChats(str, lowerCase), arrayList, arrayList2, arrayList3);
    }

    public int searchGlobalMessages(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (!(tLObject instanceof TLRPC$TL_messages_searchGlobal)) {
            return 0;
        }
        final int andIncReqId = IdStorage.getInstance().getAndIncReqId();
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda95
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$searchGlobalMessages$53(tLObject, requestDelegate, andIncReqId);
            }
        });
        return andIncReqId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$searchGlobalMessages$53(final TLObject tLObject, final RequestDelegate requestDelegate, int i) {
        int iSearchGlobalMessagesText;
        TLRPC$TL_messages_searchGlobal tLRPC$TL_messages_searchGlobal = (TLRPC$TL_messages_searchGlobal) tLObject;
        String str = tLRPC$TL_messages_searchGlobal.q;
        LoadListener<SearchGlobalMessagesOutput> loadListener = new LoadListener<SearchGlobalMessagesOutput>() { // from class: androidMessenger.proxy.DialogsProxy.31
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(SearchGlobalMessagesOutput searchGlobalMessagesOutput) {
                if (!searchGlobalMessagesOutput.has_continue || !searchGlobalMessagesOutput.messages.isEmpty()) {
                    TLRPC$messages_Messages tLRPC$messages_MessagesConvertAllInSearchMessages = MessageConverter.convertAllInSearchMessages(DialogsProxy.this.getCoreMainClass(), searchGlobalMessagesOutput);
                    tLRPC$messages_MessagesConvertAllInSearchMessages.hasContinue = searchGlobalMessagesOutput.has_continue;
                    tLRPC$messages_MessagesConvertAllInSearchMessages.nextStartId = searchGlobalMessagesOutput.next_start_id;
                    requestDelegate.run(tLRPC$messages_MessagesConvertAllInSearchMessages, null);
                    return;
                }
                TLObject tLObject2 = tLObject;
                ((TLRPC$TL_messages_searchGlobal) tLObject2).nextStartId = searchGlobalMessagesOutput.next_start_id;
                DialogsProxy.this.searchGlobalMessages(tLObject2, requestDelegate);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "No Result Found";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        };
        if (str != null && str.startsWith("#") && str.length() >= 2) {
            iSearchGlobalMessagesText = getCoreMainClass().searchGlobalMessagesHashtag(str, tLRPC$TL_messages_searchGlobal.nextStartId, loadListener);
        } else {
            iSearchGlobalMessagesText = getCoreMainClass().searchGlobalMessagesText(str, tLRPC$TL_messages_searchGlobal.nextStartId, loadListener);
        }
        IdStorage.getInstance().binReqIds(i, iSearchGlobalMessagesText);
    }

    public void proxyAbsObjects(String str, final Set<String> set) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda55
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$proxyAbsObjects$55(set);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$proxyAbsObjects$55(Set set) {
        TLRPC$User tLRPC$UserConvertBot;
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            ChatAbsObject absInstant = getCoreMainClass().getAbsInstant(str);
            if (absInstant != null) {
                ChatType chatType = absInstant.type;
                Chat chatInstant = getAccountInstance().getCoreMainClass().getChatInstant(str);
                long dialogId = ChatConverter.getDialogId(str, chatType);
                if (chatType == ChatType.Channel || chatType == ChatType.Group) {
                    arrayList2.add(ChatConverter.convertChannelGroup(getAccountInstance().getCoreMainClass(), absInstant, chatInstant));
                } else {
                    ChatType chatType2 = ChatType.User;
                    if (chatType == chatType2 || chatType == ChatType.Bot || chatType == ChatType.Service) {
                        int i = (int) dialogId;
                        if (chatType == chatType2) {
                            tLRPC$UserConvertBot = ChatConverter.convertUser(getAccountInstance().getCoreMainClass(), i, absInstant, (UserInfo) null, chatInstant);
                        } else if (chatType == ChatType.Service) {
                            tLRPC$UserConvertBot = ChatConverter.convertService(getCoreMainClass(), dialogId, absInstant, null, chatInstant);
                        } else {
                            tLRPC$UserConvertBot = ChatConverter.convertBot(getAccountInstance().getCoreMainClass(), i, absInstant, null, chatInstant);
                        }
                        arrayList.add(tLRPC$UserConvertBot);
                    }
                }
            }
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda53
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$proxyAbsObjects$54(arrayList, arrayList2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$proxyAbsObjects$54(ArrayList arrayList, ArrayList arrayList2) {
        if (!arrayList.isEmpty()) {
            getMessagesController().putUsers(arrayList, false);
        }
        if (!arrayList2.isEmpty()) {
            getMessagesController().putChats(arrayList2, false);
        }
        getNotificationCenter().postNotificationName(NotificationCenter.updateInterfaces, 8);
    }

    public int checkChannelUsername(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (!(tLObject instanceof TLRPC$TL_channels_checkUsername)) {
            return 0;
        }
        final int andIncReqId = IdStorage.getInstance().getAndIncReqId();
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda92
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$checkChannelUsername$56(tLObject, requestDelegate, andIncReqId);
            }
        });
        return andIncReqId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkChannelUsername$56(TLObject tLObject, final RequestDelegate requestDelegate, int i) {
        int iCheckChannelUsername;
        TLRPC$TL_channels_checkUsername tLRPC$TL_channels_checkUsername = (TLRPC$TL_channels_checkUsername) tLObject;
        if ((tLRPC$TL_channels_checkUsername.channel instanceof TLRPC$TL_inputChannelEmpty) && tLRPC$TL_channels_checkUsername.username.equals("1")) {
            iCheckChannelUsername = getCoreMainClass().checkChannelsWithUsername(new LoadListener<CheckChannelsWithUsernameResult>() { // from class: androidMessenger.proxy.DialogsProxy.32
                @Override // ir.aaap.messengercore.LoadListener
                public void onDidLoad(CheckChannelsWithUsernameResult checkChannelsWithUsernameResult) {
                    if (checkChannelsWithUsernameResult.allowSetUsername) {
                        requestDelegate.run(null, null);
                        return;
                    }
                    TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                    tLRPC$TL_error.text = "CHANNELS_ADMIN_PUBLIC_TOO_MUCH";
                    TLRPC$TL_messages_chats tLRPC$TL_messages_chats = new TLRPC$TL_messages_chats();
                    Iterator<String> it = checkChannelsWithUsernameResult.channelIds.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        tLRPC$TL_messages_chats.chats.add(ChatConverter.convertChannelGroup(DialogsProxy.this.getCoreMainClass(), DialogsProxy.this.getCoreMainClass().getAbsInstant(next), DialogsProxy.this.getCoreMainClass().getChatInstant(next)));
                    }
                    tLRPC$TL_messages_chats.count = checkChannelsWithUsernameResult.channelIds.size();
                    requestDelegate.run(tLRPC$TL_messages_chats, tLRPC$TL_error);
                }

                @Override // ir.aaap.messengercore.LoadListener
                public void onError(Exception exc) {
                    TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                    tLRPC$TL_error.text = "Failed To Check Channels With Usernames";
                    requestDelegate.run(null, tLRPC$TL_error);
                }
            });
        } else {
            iCheckChannelUsername = getCoreMainClass().checkChannelUsername(tLRPC$TL_channels_checkUsername.username, new LoadListener<CoreUtilities.UsernameCheckType>(this) { // from class: androidMessenger.proxy.DialogsProxy.33
                @Override // ir.aaap.messengercore.LoadListener
                public void onDidLoad(CoreUtilities.UsernameCheckType usernameCheckType) {
                    if (usernameCheckType == CoreUtilities.UsernameCheckType.Ok) {
                        requestDelegate.run(new TLRPC$TL_boolTrue(), null);
                        return;
                    }
                    TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                    tLRPC$TL_error.text = usernameCheckType.name();
                    requestDelegate.run(null, tLRPC$TL_error);
                }

                @Override // ir.aaap.messengercore.LoadListener
                public void onError(Exception exc) {
                    TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                    tLRPC$TL_error.text = "Failed To Check";
                    requestDelegate.run(null, tLRPC$TL_error);
                }
            });
        }
        IdStorage.getInstance().binReqIds(i, iCheckChannelUsername);
    }

    public int checkAccountUsername(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (!(tLObject instanceof TLRPC$TL_account_checkUsername)) {
            return 0;
        }
        final int andIncReqId = IdStorage.getInstance().getAndIncReqId();
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda97
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$checkAccountUsername$57(tLObject, requestDelegate, andIncReqId);
            }
        });
        return andIncReqId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkAccountUsername$57(TLObject tLObject, final RequestDelegate requestDelegate, int i) {
        IdStorage.getInstance().binReqIds(i, getCoreMainClass().checkUserUsername(((TLRPC$TL_account_checkUsername) tLObject).username, new LoadListener<CoreUtilities.UsernameCheckType>(this) { // from class: androidMessenger.proxy.DialogsProxy.34
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(CoreUtilities.UsernameCheckType usernameCheckType) {
                if (usernameCheckType == CoreUtilities.UsernameCheckType.Ok) {
                    requestDelegate.run(new TLRPC$TL_boolTrue(), null);
                    return;
                }
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = usernameCheckType.name();
                requestDelegate.run(null, tLRPC$TL_error);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Failed To Check";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        }));
    }

    public int updateAccountUserName(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (!(tLObject instanceof TLRPC$TL_account_updateUsername)) {
            return 0;
        }
        final int andIncReqId = IdStorage.getInstance().getAndIncReqId();
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda87
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateAccountUserName$58(tLObject, requestDelegate, andIncReqId);
            }
        });
        return andIncReqId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateAccountUserName$58(final TLObject tLObject, final RequestDelegate requestDelegate, int i) {
        final TLRPC$User currentUser = getUserConfig().getCurrentUser();
        IdStorage.getInstance().binReqIds(i, getCoreMainClass().updateUserUsername(getCoreMainClass().getMyGuid(), ((TLRPC$TL_account_updateUsername) tLObject).username, new LoadListener<UpdateUserUsernameOutput.StatusEnum>() { // from class: androidMessenger.proxy.DialogsProxy.35
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(UpdateUserUsernameOutput.StatusEnum statusEnum) {
                if (statusEnum == UpdateUserUsernameOutput.StatusEnum.OK) {
                    String str = ((TLRPC$TL_account_updateUsername) tLObject).username;
                    currentUser.username = str;
                    DialogsProxy.this.getRubinoController().onMyDefaultRubinoUsernameUpdated(str);
                    requestDelegate.run(currentUser, null);
                    return;
                }
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = statusEnum.name();
                requestDelegate.run(null, tLRPC$TL_error);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                if (exc instanceof InputException) {
                    tLRPC$TL_error.text = "InvalidInput";
                } else {
                    tLRPC$TL_error.text = "Failed To Edit UserName";
                }
                requestDelegate.run(null, tLRPC$TL_error);
            }
        }));
    }

    public int updateUserProfileName(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (!(tLObject instanceof TLRPC$TL_account_updateProfile)) {
            return 0;
        }
        final int andIncReqId = IdStorage.getInstance().getAndIncReqId();
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda93
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateUserProfileName$59(tLObject, requestDelegate, andIncReqId);
            }
        });
        return andIncReqId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateUserProfileName$59(TLObject tLObject, final RequestDelegate requestDelegate, int i) {
        TLRPC$TL_account_updateProfile tLRPC$TL_account_updateProfile = (TLRPC$TL_account_updateProfile) tLObject;
        IdStorage.getInstance().binReqIds(i, getCoreMainClass().updateProfileName(tLRPC$TL_account_updateProfile.first_name, tLRPC$TL_account_updateProfile.last_name, new LoadListener<Integer>() { // from class: androidMessenger.proxy.DialogsProxy.36
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(Integer num) {
                int i2 = DialogsProxy.this.getUserConfig().clientUserId;
                TLRPC$TL_user tLRPC$TL_user = new TLRPC$TL_user();
                tLRPC$TL_user.id = i2;
                requestDelegate.run(tLRPC$TL_user, null);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Failed To Update Profile";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        }));
    }

    public int updateUserProfileBio(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (!(tLObject instanceof TLRPC$TL_account_updateProfile)) {
            return 0;
        }
        final int andIncReqId = IdStorage.getInstance().getAndIncReqId();
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda91
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateUserProfileBio$60(tLObject, requestDelegate, andIncReqId);
            }
        });
        return andIncReqId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateUserProfileBio$60(TLObject tLObject, final RequestDelegate requestDelegate, int i) {
        IdStorage.getInstance().binReqIds(i, getCoreMainClass().updateProfileBio(((TLRPC$TL_account_updateProfile) tLObject).about, new LoadListener<Integer>() { // from class: androidMessenger.proxy.DialogsProxy.37
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(Integer num) {
                int i2 = DialogsProxy.this.getUserConfig().clientUserId;
                TLRPC$TL_user tLRPC$TL_user = new TLRPC$TL_user();
                tLRPC$TL_user.id = i2;
                requestDelegate.run(tLRPC$TL_user, null);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Failed To Update Profile";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        }));
    }

    public void updateUserLocation(LocationObject locationObject) {
        if (locationObject == null) {
            return;
        }
        getCoreMainClass().updateUserLocation(locationObject, null);
    }

    public void updateChannelUserName(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_channels_updateUsername) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda78
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$updateChannelUserName$61(tLObject, requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateChannelUserName$61(TLObject tLObject, final RequestDelegate requestDelegate) {
        getCoreMainClass().updateChannelUsername(IdStorage.getInstance().getDialogId(-r5.channel.channel_id), ((TLRPC$TL_channels_updateUsername) tLObject).username, new LoadListener<UpdateChannelUsernameOutput.StatusEnum>(this) { // from class: androidMessenger.proxy.DialogsProxy.38
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(UpdateChannelUsernameOutput.StatusEnum statusEnum) {
                if (statusEnum == UpdateChannelUsernameOutput.StatusEnum.OK) {
                    requestDelegate.run(new TLRPC$TL_boolTrue(), null);
                    return;
                }
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = statusEnum.name();
                requestDelegate.run(null, tLRPC$TL_error);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Failed To Edit UserName";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        });
    }

    public void updatePrivatePublicChannel(final long j, final boolean z, final RequestDelegate requestDelegate) {
        if (j != 0) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda38
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$updatePrivatePublicChannel$62(j, z, requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updatePrivatePublicChannel$62(long j, boolean z, final RequestDelegate requestDelegate) {
        String dialogId = IdStorage.getInstance().getDialogId(j);
        ChatAbsObject absInstant = getCoreMainClass().getAbsInstant(dialogId);
        ChannelInfo channelInfo = getCoreMainClass().getObjectInfoInstant(dialogId).channelInfo;
        getCoreMainClass().editChannelInfo(dialogId, absInstant.title, channelInfo.description, channelInfo.sign_messages, !z, new LoadListener<String>(this) { // from class: androidMessenger.proxy.DialogsProxy.39
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(String str) {
                requestDelegate.run(null, null);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Failed To Edit Channel Type";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        });
    }

    public void blockOrUnblockUserOrChat(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if ((tLObject instanceof TLRPC$TL_contacts_block) || (tLObject instanceof TLRPC$TL_contacts_unblock)) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda77
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$blockOrUnblockUserOrChat$64(tLObject, requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$blockOrUnblockUserOrChat$64(TLObject tLObject, final RequestDelegate requestDelegate) {
        boolean z = tLObject instanceof TLRPC$TL_contacts_block;
        String dialogId = (z ? ((TLRPC$TL_contacts_block) tLObject).id : ((TLRPC$TL_contacts_unblock) tLObject).id) instanceof TLRPC$TL_inputPeerUser ? IdStorage.getInstance().getDialogId(r6.user_id) : null;
        if (!getCoreMainClass().isBot(dialogId)) {
            getCoreMainClass().setBlockUser(dialogId, z, new LoadListener<Integer>(this) { // from class: androidMessenger.proxy.DialogsProxy.40
                @Override // ir.aaap.messengercore.LoadListener
                public void onDidLoad(Integer num) {
                    requestDelegate.run(null, null);
                }

                @Override // ir.aaap.messengercore.LoadListener
                public void onError(Exception exc) {
                    TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                    tLRPC$TL_error.text = "Couldn't Block User";
                    requestDelegate.run(null, tLRPC$TL_error);
                }
            });
        } else if (z) {
            getCoreMainClass().stopBot(dialogId);
        } else {
            requestDelegate.run(null, null);
        }
    }

    public void getPendingObjectOwner(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_channels_editCreator) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda74
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$getPendingObjectOwner$65(tLObject, requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getPendingObjectOwner$65(TLObject tLObject, final RequestDelegate requestDelegate) {
        TLRPC$TL_channels_editCreator tLRPC$TL_channels_editCreator = (TLRPC$TL_channels_editCreator) tLObject;
        String dialogId = IdStorage.getInstance().getDialogId(tLRPC$TL_channels_editCreator.channel.channel_id * (-1));
        final String dialogId2 = IdStorage.getInstance().getDialogId(tLRPC$TL_channels_editCreator.user_id.user_id);
        getCoreMainClass().getPendingObjectOwner(dialogId, new LoadListener<ChangeOwnerModels.GetPendingObjectOwnerOutput>(this) { // from class: androidMessenger.proxy.DialogsProxy.41
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(ChangeOwnerModels.GetPendingObjectOwnerOutput getPendingObjectOwnerOutput) {
                String str;
                if (getPendingObjectOwnerOutput.exist_pending_owner && (str = getPendingObjectOwnerOutput.pending_owner_user_guid) != null) {
                    if (!str.equals(dialogId2)) {
                        TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                        tLRPC$TL_error.text = "exist_pending_owner";
                        requestDelegate.run(null, tLRPC$TL_error);
                        return;
                    }
                    requestDelegate.run(null, null);
                    return;
                }
                requestDelegate.run(null, null);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Couldn't get pending change owner";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        });
    }

    public void requestChangeObjectOwner(final long j, final long j2, final RequestDelegate requestDelegate) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda29
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$requestChangeObjectOwner$66(j, j2, requestDelegate);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestChangeObjectOwner$66(long j, long j2, final RequestDelegate requestDelegate) {
        getCoreMainClass().requestChangeObjectOwner(IdStorage.getInstance().getDialogId(j * (-1)), IdStorage.getInstance().getDialogId(j2), new LoadListener<ChangeOwnerModels.RequestChangeOwnerOutput>(this) { // from class: androidMessenger.proxy.DialogsProxy.42
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(ChangeOwnerModels.RequestChangeOwnerOutput requestChangeOwnerOutput) {
                if (requestChangeOwnerOutput.status == ChangeOwnerModels.StatusEnum.OK) {
                    requestDelegate.run(null, null);
                    return;
                }
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "exist_pending_owner";
                requestDelegate.run(null, tLRPC$TL_error);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Couldn't change owner";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        });
    }

    public void cancelChangeObjectOwner(final long j, final RequestDelegate requestDelegate) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda37
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$cancelChangeObjectOwner$67(j, requestDelegate);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$cancelChangeObjectOwner$67(long j, final RequestDelegate requestDelegate) {
        getCoreMainClass().cancelChangeObjectOwner(IdStorage.getInstance().getDialogId(j), new LoadListener<Integer>(this) { // from class: androidMessenger.proxy.DialogsProxy.43
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(Integer num) {
                requestDelegate.run(null, null);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Couldn't cancel change owner";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        });
    }

    public void rejectRequestObjectOwner(final long j, final RequestDelegate requestDelegate) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda36
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$rejectRequestObjectOwner$68(j, requestDelegate);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$rejectRequestObjectOwner$68(long j, final RequestDelegate requestDelegate) {
        getCoreMainClass().rejectRequestObjectOwner(IdStorage.getInstance().getDialogId(j), new LoadListener<Integer>(this) { // from class: androidMessenger.proxy.DialogsProxy.44
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(Integer num) {
                requestDelegate.run(null, null);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Couldn't reject change owner";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        });
    }

    public void acceptRequestObjectOwner(final long j, final RequestDelegate requestDelegate) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda35
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$acceptRequestObjectOwner$69(j, requestDelegate);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$acceptRequestObjectOwner$69(long j, final RequestDelegate requestDelegate) {
        getCoreMainClass().acceptRequestObjectOwner(IdStorage.getInstance().getDialogId(j), new LoadListener<Integer>(this) { // from class: androidMessenger.proxy.DialogsProxy.45
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(Integer num) {
                requestDelegate.run(null, null);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Couldn't accept change owner";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        });
    }

    public int getCommonGroups(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (!(tLObject instanceof TLRPC$TL_messages_getCommonChats)) {
            return 0;
        }
        final int andIncReqId = IdStorage.getInstance().getAndIncReqId();
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda98
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getCommonGroups$70(tLObject, requestDelegate, andIncReqId);
            }
        });
        return andIncReqId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getCommonGroups$70(TLObject tLObject, RequestDelegate requestDelegate, int i) {
        IdStorage.getInstance().binReqIds(i, getCoreMainClass().getCommonGroups(IdStorage.getInstance().getDialogId(((TLRPC$TL_messages_getCommonChats) tLObject).user_id.user_id), new AnonymousClass46(this, requestDelegate)));
    }

    /* renamed from: androidMessenger.proxy.DialogsProxy$46, reason: invalid class name */
    class AnonymousClass46 implements LoadListener<ArrayList<ChatAbsObject>> {
        final /* synthetic */ RequestDelegate val$onComplete;

        AnonymousClass46(DialogsProxy dialogsProxy, RequestDelegate requestDelegate) {
            this.val$onComplete = requestDelegate;
        }

        @Override // ir.aaap.messengercore.LoadListener
        public void onDidLoad(final ArrayList<ChatAbsObject> arrayList) {
            DispatchQueue dispatchQueue = Utilities.stageQueue;
            final RequestDelegate requestDelegate = this.val$onComplete;
            dispatchQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$46$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    DialogsProxy.AnonymousClass46.lambda$onDidLoad$0(arrayList, requestDelegate);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onDidLoad$0(ArrayList arrayList, RequestDelegate requestDelegate) {
            TLRPC$TL_messages_chats tLRPC$TL_messages_chats = new TLRPC$TL_messages_chats();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ChatAbsObject chatAbsObject = (ChatAbsObject) it.next();
                long jGenerateNegativeDialogId = (int) IdStorage.getInstance().generateNegativeDialogId(chatAbsObject.object_guid);
                TLRPC$TL_channel tLRPC$TL_channel = new TLRPC$TL_channel();
                tLRPC$TL_channel.id = (int) (-jGenerateNegativeDialogId);
                ChatConverter.setAbsInfoForChannelGroup(tLRPC$TL_channel, chatAbsObject);
                tLRPC$TL_messages_chats.chats.add(tLRPC$TL_channel);
            }
            tLRPC$TL_messages_chats.count = arrayList.size();
            requestDelegate.run(tLRPC$TL_messages_chats, null);
        }

        @Override // ir.aaap.messengercore.LoadListener
        public void onError(Exception exc) {
            TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
            tLRPC$TL_error.text = "Failed To Get Common Groups";
            this.val$onComplete.run(null, tLRPC$TL_error);
        }
    }

    public int checkChatInvite(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (!(tLObject instanceof TLRPC$TL_messages_checkChatInvite)) {
            return 0;
        }
        final int andIncReqId = IdStorage.getInstance().getAndIncReqId();
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda94
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$checkChatInvite$71(tLObject, requestDelegate, andIncReqId);
            }
        });
        return andIncReqId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkChatInvite$71(TLObject tLObject, final RequestDelegate requestDelegate, int i) {
        int iGroupPreviewByJoinLink;
        TLRPC$TL_messages_checkChatInvite tLRPC$TL_messages_checkChatInvite = (TLRPC$TL_messages_checkChatInvite) tLObject;
        String str = tLRPC$TL_messages_checkChatInvite.hash;
        boolean z = tLRPC$TL_messages_checkChatInvite.isChannel;
        LoadListener<ChatInviteObject> loadListener = new LoadListener<ChatInviteObject>() { // from class: androidMessenger.proxy.DialogsProxy.47
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(ChatInviteObject chatInviteObject) {
                if (chatInviteObject.is_valid) {
                    requestDelegate.run(ChatConverter.convertChatPreview(DialogsProxy.this.getCoreMainClass(), chatInviteObject, DialogsProxy.this.getCoreMainClass().getObjectInfoInstant(chatInviteObject.objectGuid), DialogsProxy.this.getCoreMainClass().getAbsInstant(chatInviteObject.objectGuid)), null);
                    return;
                }
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "INVITE_HASH_EXPIRED";
                requestDelegate.run(null, tLRPC$TL_error);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Failed To Load Chat Invite By Link";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        };
        if (z) {
            iGroupPreviewByJoinLink = getCoreMainClass().channelPreviewByJoinLink(str, loadListener);
        } else {
            iGroupPreviewByJoinLink = getCoreMainClass().groupPreviewByJoinLink(str, loadListener);
        }
        IdStorage.getInstance().binReqIds(i, iGroupPreviewByJoinLink);
    }

    public void joinChatByLink(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_messages_importChatInvite) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda75
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$joinChatByLink$72(tLObject, requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$joinChatByLink$72(TLObject tLObject, final RequestDelegate requestDelegate) {
        TLRPC$TL_messages_importChatInvite tLRPC$TL_messages_importChatInvite = (TLRPC$TL_messages_importChatInvite) tLObject;
        String dialogId = IdStorage.getInstance().getDialogId(-tLRPC$TL_messages_importChatInvite.chatId);
        LoadListener<String> loadListener = new LoadListener<String>() { // from class: androidMessenger.proxy.DialogsProxy.48
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(String str) {
                TLRPC$TL_updates tLRPC$TL_updates = new TLRPC$TL_updates();
                if (str != null) {
                    ChatAbsObject absInstant = DialogsProxy.this.getCoreMainClass().getAbsInstant(str);
                    Chat chatInstant = DialogsProxy.this.getCoreMainClass().getChatInstant(str);
                    if (chatInstant != null && absInstant != null) {
                        tLRPC$TL_updates.chats.add(ChatConverter.convertChannelGroup(DialogsProxy.this.getCoreMainClass(), absInstant, chatInstant));
                    }
                }
                requestDelegate.run(tLRPC$TL_updates, null);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Failed To Join";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        };
        if (tLRPC$TL_messages_importChatInvite.isChannel) {
            getCoreMainClass().joinChannelByLink(tLRPC$TL_messages_importChatInvite.hash, loadListener);
        } else {
            getCoreMainClass().joinGroup(dialogId, tLRPC$TL_messages_importChatInvite.hash, loadListener);
        }
    }

    public int sendChatAction(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (!(tLObject instanceof TLRPC$TL_messages_setTyping)) {
            return 0;
        }
        final int andIncReqId = IdStorage.getInstance().getAndIncReqId();
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda90
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$sendChatAction$73(tLObject, requestDelegate, andIncReqId);
            }
        });
        return andIncReqId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendChatAction$73(TLObject tLObject, final RequestDelegate requestDelegate, int i) {
        long j;
        int i2;
        SendChatActivityInput.ActivityEnum activityEnumConvertActionToCoreActivity;
        TLRPC$TL_messages_setTyping tLRPC$TL_messages_setTyping = (TLRPC$TL_messages_setTyping) tLObject;
        TLRPC$InputPeer tLRPC$InputPeer = tLRPC$TL_messages_setTyping.peer;
        if (tLRPC$InputPeer instanceof TLRPC$TL_inputPeerUser) {
            i2 = tLRPC$InputPeer.user_id;
        } else if (tLRPC$InputPeer instanceof TLRPC$TL_inputPeerChannel) {
            i2 = -tLRPC$InputPeer.channel_id;
        } else {
            j = 0;
            String dialogId = IdStorage.getInstance().getDialogId(j);
            activityEnumConvertActionToCoreActivity = MessageConverter.convertActionToCoreActivity(tLRPC$TL_messages_setTyping.action);
            if (activityEnumConvertActionToCoreActivity != null || dialogId == null || dialogId.isEmpty()) {
                return;
            }
            IdStorage.getInstance().binReqIds(i, getCoreMainClass().sendChatAction(dialogId, activityEnumConvertActionToCoreActivity, new LoadListener<Integer>(this) { // from class: androidMessenger.proxy.DialogsProxy.49
                @Override // ir.aaap.messengercore.LoadListener
                public void onDidLoad(Integer num) {
                    requestDelegate.run(null, null);
                }

                @Override // ir.aaap.messengercore.LoadListener
                public void onError(Exception exc) {
                    TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                    tLRPC$TL_error.text = "Failed To Send Chat Activity";
                    requestDelegate.run(null, tLRPC$TL_error);
                }
            }));
            return;
        }
        j = i2;
        String dialogId2 = IdStorage.getInstance().getDialogId(j);
        activityEnumConvertActionToCoreActivity = MessageConverter.convertActionToCoreActivity(tLRPC$TL_messages_setTyping.action);
        if (activityEnumConvertActionToCoreActivity != null) {
        }
    }

    public void getAllHintDialogs(TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_contacts_getTopPeers) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda60
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$getAllHintDialogs$74(requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getAllHintDialogs$74(final RequestDelegate requestDelegate) {
        getCoreMainClass().getAllChatHints(false, new LoadListener<ArrayList<ChatAbsObject>>() { // from class: androidMessenger.proxy.DialogsProxy.50
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(ArrayList<ChatAbsObject> arrayList) {
                TLRPC$User tLRPC$UserConvertService;
                TLRPC$TL_contacts_topPeers tLRPC$TL_contacts_topPeers = new TLRPC$TL_contacts_topPeers();
                TLRPC$TL_topPeerCategoryPeers tLRPC$TL_topPeerCategoryPeers = new TLRPC$TL_topPeerCategoryPeers();
                tLRPC$TL_topPeerCategoryPeers.category = new TLRPC$TL_topPeerCategoryCorrespondents();
                Iterator<ChatAbsObject> it = arrayList.iterator();
                while (it.hasNext()) {
                    ChatAbsObject next = it.next();
                    if (next != null) {
                        String str = next.object_guid;
                        Chat chatInstant = DialogsProxy.this.getCoreMainClass().getChatInstant(str);
                        ChatType chatType = next.type;
                        ChatType chatType2 = ChatType.User;
                        if (chatType == chatType2 || chatType == ChatType.Bot || chatType == ChatType.Service) {
                            if (chatType == chatType2) {
                                tLRPC$UserConvertService = ChatConverter.convertUser(DialogsProxy.this.getCoreMainClass(), IdStorage.getInstance().generateDialogId(str), next, (UserInfo) null, chatInstant);
                            } else {
                                tLRPC$UserConvertService = chatType == ChatType.Service ? ChatConverter.convertService(DialogsProxy.this.getCoreMainClass(), IdStorage.getInstance().generateDialogId(str), next, null, chatInstant) : ChatConverter.convertBot(DialogsProxy.this.getCoreMainClass(), IdStorage.getInstance().generateDialogId(str), next, null, chatInstant);
                            }
                            tLRPC$TL_contacts_topPeers.users.add(tLRPC$UserConvertService);
                            TLRPC$TL_topPeer tLRPC$TL_topPeer = new TLRPC$TL_topPeer();
                            TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                            tLRPC$TL_topPeer.peer = tLRPC$TL_peerUser;
                            tLRPC$TL_peerUser.user_id = tLRPC$UserConvertService.id;
                            tLRPC$TL_topPeerCategoryPeers.peers.add(tLRPC$TL_topPeer);
                        } else if (chatType == ChatType.Group || chatType == ChatType.Channel) {
                            tLRPC$TL_contacts_topPeers.chats.add(ChatConverter.convertChannelGroup(DialogsProxy.this.getCoreMainClass(), next, chatInstant));
                        }
                    }
                }
                tLRPC$TL_contacts_topPeers.categories.add(tLRPC$TL_topPeerCategoryPeers);
                requestDelegate.run(tLRPC$TL_contacts_topPeers, null);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                requestDelegate.run(null, new TLRPC$TL_error());
            }
        });
    }

    public void addRecentChat(final long j) {
        if (j == 0) {
            return;
        }
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda23
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$addRecentChat$75(j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addRecentChat$75(long j) {
        getCoreMainClass().addRecentChat(IdStorage.getInstance().getDialogId(j));
    }

    public void getRecentSearch(final RequestDelegate requestDelegate) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda57
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getRecentSearch$76(requestDelegate);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getRecentSearch$76(final RequestDelegate requestDelegate) {
        final ArrayList arrayList = new ArrayList();
        getCoreMainClass().getAllRecentChatGuid(true, new LoadListener<ArrayList<InSearchObject>>() { // from class: androidMessenger.proxy.DialogsProxy.51
            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(ArrayList<InSearchObject> arrayList2) {
                Iterator<InSearchObject> it = arrayList2.iterator();
                while (it.hasNext()) {
                    InSearchObject next = it.next();
                    ChatType chatType = next.type;
                    if (chatType == ChatType.User || chatType == ChatType.Bot || chatType == ChatType.Service) {
                        CoreMainClass coreMainClass = DialogsProxy.this.getCoreMainClass();
                        long jGenerateDialogId = IdStorage.getInstance().generateDialogId(next.object_guid);
                        ChatType chatType2 = next.type;
                        TLRPC$User tLRPC$UserConvertUser = ChatConverter.convertUser(coreMainClass, jGenerateDialogId, next, chatType2 == ChatType.Bot, chatType2 == ChatType.Service);
                        DialogsSearchAdapter.RecentSearchObject recentSearchObject = new DialogsSearchAdapter.RecentSearchObject();
                        recentSearchObject.did = tLRPC$UserConvertUser.id;
                        recentSearchObject.object = tLRPC$UserConvertUser;
                        arrayList.add(recentSearchObject);
                    } else if (chatType == ChatType.Group || chatType == ChatType.Channel) {
                        DialogsSearchAdapter.RecentSearchObject recentSearchObject2 = new DialogsSearchAdapter.RecentSearchObject();
                        TLRPC$Chat tLRPC$ChatConvertChannelGroup = ChatConverter.convertChannelGroup(DialogsProxy.this.getCoreMainClass(), next);
                        recentSearchObject2.did = -tLRPC$ChatConvertChannelGroup.id;
                        recentSearchObject2.object = tLRPC$ChatConvertChannelGroup;
                        arrayList.add(recentSearchObject2);
                    }
                }
                TLRPC$RecentListResult tLRPC$RecentListResult = new TLRPC$RecentListResult();
                tLRPC$RecentListResult.recentSearchObjects = arrayList;
                requestDelegate.run(tLRPC$RecentListResult, null);
            }
        });
    }

    public void clearRecentSearch() {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$clearRecentSearch$77();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$clearRecentSearch$77() {
        getCoreMainClass().removeAllRecentChat();
    }

    public void removeRecentChat(final long j) {
        if (j == 0) {
            return;
        }
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda25
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$removeRecentChat$78(j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removeRecentChat$78(long j) {
        getCoreMainClass().removeRecentChat(IdStorage.getInstance().getDialogId(j));
    }

    public void deleteChatOrHistory(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if ((tLObject instanceof TLRPC$TL_messages_deleteHistory) || (tLObject instanceof TLRPC$TL_channels_deleteHistory)) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda83
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$deleteChatOrHistory$81(tLObject, requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteChatOrHistory$81(TLObject tLObject, final RequestDelegate requestDelegate) {
        String dialogId;
        ChatType chatType;
        long j;
        boolean z;
        if (tLObject instanceof TLRPC$TL_messages_deleteHistory) {
            TLRPC$TL_messages_deleteHistory tLRPC$TL_messages_deleteHistory = (TLRPC$TL_messages_deleteHistory) tLObject;
            TLRPC$InputPeer tLRPC$InputPeer = tLRPC$TL_messages_deleteHistory.peer;
            dialogId = null;
            if (tLRPC$InputPeer instanceof TLRPC$TL_inputPeerUser) {
                dialogId = IdStorage.getInstance().getDialogId(tLRPC$InputPeer.user_id);
                chatType = getCoreMainClass().isBot(dialogId) ? ChatType.Bot : getCoreMainClass().isService(dialogId) ? ChatType.Service : ChatType.User;
            } else if (tLRPC$InputPeer instanceof TLRPC$TL_inputPeerChannel) {
                dialogId = IdStorage.getInstance().getDialogId(-tLRPC$InputPeer.channel_id);
                chatType = getCoreMainClass().isChannel(dialogId) ? ChatType.Channel : ChatType.Group;
            } else {
                chatType = null;
            }
            j = tLRPC$TL_messages_deleteHistory.max_id;
        } else {
            TLRPC$TL_channels_deleteHistory tLRPC$TL_channels_deleteHistory = (TLRPC$TL_channels_deleteHistory) tLObject;
            dialogId = IdStorage.getInstance().getDialogId(-tLRPC$TL_channels_deleteHistory.channel.channel_id);
            chatType = getCoreMainClass().isChannel(dialogId) ? ChatType.Channel : ChatType.Group;
            j = tLRPC$TL_channels_deleteHistory.max_id;
        }
        ChatType chatType2 = chatType;
        String str = dialogId;
        Chat chatInstant = getCoreMainClass().getChatInstant(str);
        long j2 = chatInstant != null ? chatInstant.last_message_id : j;
        if (chatType2 == null || str == null) {
            return;
        }
        LoadListener<String> loadListener = new LoadListener<String>(this) { // from class: androidMessenger.proxy.DialogsProxy.53
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(String str2) {
                requestDelegate.run(new TLRPC$TL_messages_affectedHistory(), null);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Failed To Clear Chat History";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        };
        if ((tLObject instanceof TLRPC$TL_channels_deleteHistory) || (z = ((TLRPC$TL_messages_deleteHistory) tLObject).just_clear)) {
            getCoreMainClass().clearChatHistory(str, chatType2, j2, loadListener);
        } else {
            if (z) {
                return;
            }
            getCoreMainClass().deleteChat(str, chatType2, j2, loadListener);
        }
    }

    public void performLogOut(TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_auth_logOut) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda56
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$performLogOut$82(requestDelegate);
                }
            });
        }
    }

    /* renamed from: androidMessenger.proxy.DialogsProxy$54, reason: invalid class name */
    class AnonymousClass54 implements LoadListener<Integer> {
        final /* synthetic */ RequestDelegate val$onComplete;

        AnonymousClass54(DialogsProxy dialogsProxy, RequestDelegate requestDelegate) {
            this.val$onComplete = requestDelegate;
        }

        @Override // ir.aaap.messengercore.LoadListener
        public void onDidLoad(Integer num) {
            final RequestDelegate requestDelegate = this.val$onComplete;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$54$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    requestDelegate.run(null, null);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onError$1(RequestDelegate requestDelegate) {
            requestDelegate.run(null, new TLRPC$TL_error());
        }

        @Override // ir.aaap.messengercore.LoadListener
        public void onError(Exception exc) {
            final RequestDelegate requestDelegate = this.val$onComplete;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$54$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    DialogsProxy.AnonymousClass54.lambda$onError$1(requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$performLogOut$82(RequestDelegate requestDelegate) {
        getCoreMainClass().logout(new AnonymousClass54(this, requestDelegate));
    }

    /* renamed from: androidMessenger.proxy.DialogsProxy$55, reason: invalid class name */
    class AnonymousClass55 implements LoadListener<Integer> {
        final /* synthetic */ RequestDelegate val$onComplete;

        AnonymousClass55(DialogsProxy dialogsProxy, RequestDelegate requestDelegate) {
            this.val$onComplete = requestDelegate;
        }

        @Override // ir.aaap.messengercore.LoadListener
        public void onDidLoad(Integer num) {
            final RequestDelegate requestDelegate = this.val$onComplete;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$55$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    requestDelegate.run(null, null);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onError$1(RequestDelegate requestDelegate) {
            requestDelegate.run(null, new TLRPC$TL_error());
        }

        @Override // ir.aaap.messengercore.LoadListener
        public void onError(Exception exc) {
            final RequestDelegate requestDelegate = this.val$onComplete;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$55$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    DialogsProxy.AnonymousClass55.lambda$onError$1(requestDelegate);
                }
            });
        }
    }

    public void requestDeleteAccount(final RequestDelegate requestDelegate) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda59
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$requestDeleteAccount$83(requestDelegate);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestDeleteAccount$83(RequestDelegate requestDelegate) {
        getCoreMainClass().requestDeleteAccount(new AnonymousClass55(this, requestDelegate));
    }

    public void getAllChannelStatistics(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_stats_getBroadcastStats) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda80
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$getAllChannelStatistics$84(tLObject, requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getAllChannelStatistics$84(TLObject tLObject, final RequestDelegate requestDelegate) {
        getCoreMainClass().getAllChannelStatistics(IdStorage.getInstance().getDialogId(((TLRPC$TL_stats_getBroadcastStats) tLObject).channel.channel_id * (-1)), new LoadListener<GetAllStatisticsOutput>(this) { // from class: androidMessenger.proxy.DialogsProxy.56
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(GetAllStatisticsOutput getAllStatisticsOutput) {
                requestDelegate.run(ChatConverter.convertStatsOutputToTlStats(getAllStatisticsOutput), null);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                requestDelegate.run(null, new TLRPC$TL_error());
            }
        });
    }

    public void proxyShowActivities(final ArrayList<ShowActivityObject> arrayList) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda50
            @Override // java.lang.Runnable
            public final void run() throws InterruptedException {
                this.f$0.lambda$proxyShowActivities$85(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$proxyShowActivities$85(ArrayList arrayList) throws InterruptedException {
        ArrayList<TLRPC$Update> arrayList2 = new ArrayList<>();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(MessageConverter.convertShowActivity((ShowActivityObject) it.next()));
        }
        getMessagesController().processUpdateArray(arrayList2, null, null, false, 0);
    }

    public void proxyShowActivitiesWithNewMessages(final Map<ObjectGuidType, ArrayList<Message>> map) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda54
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$proxyShowActivitiesWithNewMessages$87(map);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008c A[LOOP:1: B:20:0x0086->B:22:0x008c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c1 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$proxyShowActivitiesWithNewMessages$87(java.util.Map r15) {
        /*
            r14 = this;
            java.util.Set r15 = r15.entrySet()
            java.util.Iterator r15 = r15.iterator()
        L8:
            boolean r0 = r15.hasNext()
            if (r0 == 0) goto Lcb
            java.lang.Object r0 = r15.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            r1 = 0
            java.lang.Object r3 = r0.getKey()
            ir.aaap.messengercore.model.ObjectGuidType r3 = (ir.aaap.messengercore.model.ObjectGuidType) r3
            ir.aaap.messengercore.model.ChatType r3 = r3.type
            ir.aaap.messengercore.model.ChatType r4 = ir.aaap.messengercore.model.ChatType.User
            r5 = 0
            if (r3 == r4) goto L66
            java.lang.Object r3 = r0.getKey()
            ir.aaap.messengercore.model.ObjectGuidType r3 = (ir.aaap.messengercore.model.ObjectGuidType) r3
            ir.aaap.messengercore.model.ChatType r3 = r3.type
            ir.aaap.messengercore.model.ChatType r4 = ir.aaap.messengercore.model.ChatType.Bot
            if (r3 == r4) goto L66
            java.lang.Object r3 = r0.getKey()
            ir.aaap.messengercore.model.ObjectGuidType r3 = (ir.aaap.messengercore.model.ObjectGuidType) r3
            ir.aaap.messengercore.model.ChatType r3 = r3.type
            ir.aaap.messengercore.model.ChatType r4 = ir.aaap.messengercore.model.ChatType.Service
            if (r3 != r4) goto L3c
            goto L66
        L3c:
            java.lang.Object r3 = r0.getKey()
            ir.aaap.messengercore.model.ObjectGuidType r3 = (ir.aaap.messengercore.model.ObjectGuidType) r3
            ir.aaap.messengercore.model.ChatType r3 = r3.type
            ir.aaap.messengercore.model.ChatType r4 = ir.aaap.messengercore.model.ChatType.Group
            if (r3 == r4) goto L54
            java.lang.Object r3 = r0.getKey()
            ir.aaap.messengercore.model.ObjectGuidType r3 = (ir.aaap.messengercore.model.ObjectGuidType) r3
            ir.aaap.messengercore.model.ChatType r3 = r3.type
            ir.aaap.messengercore.model.ChatType r4 = ir.aaap.messengercore.model.ChatType.Channel
            if (r3 != r4) goto L76
        L54:
            androidMessenger.proxy.IdStorage r1 = androidMessenger.proxy.IdStorage.getInstance()
            java.lang.Object r2 = r0.getKey()
            ir.aaap.messengercore.model.ObjectGuidType r2 = (ir.aaap.messengercore.model.ObjectGuidType) r2
            java.lang.String r2 = r2.object_guid
            long r1 = r1.generateNegativeDialogId(r2)
            r3 = 1
            goto L77
        L66:
            androidMessenger.proxy.IdStorage r1 = androidMessenger.proxy.IdStorage.getInstance()
            java.lang.Object r2 = r0.getKey()
            ir.aaap.messengercore.model.ObjectGuidType r2 = (ir.aaap.messengercore.model.ObjectGuidType) r2
            java.lang.String r2 = r2.object_guid
            long r1 = r1.generateDialogId(r2)
        L76:
            r3 = 0
        L77:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.lang.Object r0 = r0.getValue()
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            java.util.Iterator r0 = r0.iterator()
        L86:
            boolean r6 = r0.hasNext()
            if (r6 == 0) goto Lb0
            java.lang.Object r6 = r0.next()
            r7 = r6
            ir.aaap.messengercore.model.Message r7 = (ir.aaap.messengercore.model.Message) r7
            org.rbmain.tgnet.TLRPC$TL_message r13 = new org.rbmain.tgnet.TLRPC$TL_message
            r13.<init>()
            r11 = 0
            ir.aaap.messengercore.CoreMainClass r12 = r14.getCoreMainClass()
            r6 = r13
            r8 = r1
            r10 = r3
            androidMessenger.utilites.MessageConverter.setMessageFromId(r6, r7, r8, r10, r11, r12)
            r13.dialog_id = r1
            org.rbmain.messenger.MessageObject r6 = new org.rbmain.messenger.MessageObject
            int r7 = r14.currentAccount
            r6.<init>(r7, r13, r5, r5)
            r4.add(r6)
            goto L86
        Lb0:
            org.rbmain.messenger.MessagesController r0 = r14.getMessagesController()
            boolean r0 = r0.updatePrintingUsersWithNewMessages(r1, r4)
            if (r0 == 0) goto Lc1
            org.rbmain.messenger.MessagesController r1 = r14.getMessagesController()
            r1.updatePrintingStrings()
        Lc1:
            androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda103 r1 = new androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda103
            r1.<init>()
            org.rbmain.messenger.AndroidUtilities.runOnUIThread(r1)
            goto L8
        Lcb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidMessenger.proxy.DialogsProxy.lambda$proxyShowActivitiesWithNewMessages$87(java.util.Map):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$proxyShowActivitiesWithNewMessages$86(boolean z) {
        if (z) {
            getNotificationCenter().postNotificationName(NotificationCenter.updateInterfaces, 64);
        }
    }

    public int getLivePlayUrl(final String str, final String str2, final LoadListener<LiveModels.GetLivePlayUrlResult> loadListener) {
        final int andIncReqId = IdStorage.getInstance().getAndIncReqId();
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda47
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getLivePlayUrl$88(str, str2, loadListener, andIncReqId);
            }
        });
        return andIncReqId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getLivePlayUrl$88(String str, String str2, LoadListener loadListener, int i) {
        IdStorage.getInstance().binReqIds(i, getCoreMainClass().getLivePlayUrl(str, str2, loadListener));
    }

    public void blockCommentsInLive(final String str, final ChatAbsObject chatAbsObject, final ChatType chatType) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda40
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$blockCommentsInLive$89(chatType, chatAbsObject, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$blockCommentsInLive$89(ChatType chatType, ChatAbsObject chatAbsObject, String str) {
        if (chatType == ChatType.User) {
            getCoreMainClass().setBlockUser(chatAbsObject.object_guid, true, null);
        } else if (chatType == ChatType.Group) {
            getCoreMainClass().banGroupMember(str, chatAbsObject.object_guid, true, null);
        } else if (chatType == ChatType.Channel) {
            getCoreMainClass().banChannelMember(str, chatAbsObject.object_guid, true, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$proxyInvalidAuth$90() {
        getMessagesController().performLogout(0);
    }

    public void proxyInvalidAuth() {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$proxyInvalidAuth$90();
            }
        });
    }

    public boolean canRemoveObject(int i) {
        String dialogId = i != 0 ? IdStorage.getInstance().getDialogId(-i) : null;
        return dialogId != null && getCoreMainClass().canRemoveObject(dialogId);
    }

    public boolean canSetAccess(TLRPC$Chat tLRPC$Chat) {
        String dialogId = (tLRPC$Chat != null ? tLRPC$Chat.id : 0) != 0 ? IdStorage.getInstance().getDialogId(-r5) : null;
        return dialogId != null && getCoreMainClass().canSetAccess(dialogId);
    }

    public boolean canSeeMembers(int i) {
        String dialogId = i != 0 ? IdStorage.getInstance().getDialogId(-i) : null;
        return dialogId != null && getCoreMainClass().canViewMembers(dialogId);
    }

    public void proxyAdsResult() {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$proxyAdsResult$93();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$proxyAdsResult$93() {
        ArrayList<ChatAdsObject> chatAdsInstant = getCoreMainClass().getChatAdsInstant();
        if (chatAdsInstant == null || chatAdsInstant.isEmpty()) {
            return;
        }
        ArrayList<TLRPC$Dialog> arrayList = new ArrayList<>();
        Iterator<ChatAdsObject> it = chatAdsInstant.iterator();
        while (it.hasNext()) {
            ChatAdsObject next = it.next();
            if (!next.force_show && getMessagesController().getAllDialogs().isEmpty()) {
                return;
            }
            TLRPC$TL_dialogAd tLRPC$TL_dialogAd = new TLRPC$TL_dialogAd();
            tLRPC$TL_dialogAd.id = IdStorage.getInstance().generateNegativeDialogId(next.chat_ads_id);
            tLRPC$TL_dialogAd.adsObject = next;
            arrayList.add(tLRPC$TL_dialogAd);
        }
        getMessagesController().processAdsDialogs(arrayList);
    }

    public void onAdsAction(final long j, final int i) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda28
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onAdsAction$94(j, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAdsAction$94(long j, int i) {
        ActionOnChatAdsInput.Action action;
        String dialogId = IdStorage.getInstance().getDialogId(j);
        if (i == 0) {
            action = ActionOnChatAdsInput.Action.DontShow;
        } else if (i == 1) {
            action = ActionOnChatAdsInput.Action.Report;
        } else if (i == 2) {
            action = ActionOnChatAdsInput.Action.View;
        } else {
            action = i != 3 ? null : ActionOnChatAdsInput.Action.Click;
        }
        if (action != null) {
            getCoreMainClass().actionOnChatAds(dialogId, action);
        }
    }

    public void onAdsClicked(final TLRPC$Dialog tLRPC$Dialog) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda101
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onAdsClicked$95(tLRPC$Dialog);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAdsClicked$95(TLRPC$Dialog tLRPC$Dialog) {
        onAdsAction(tLRPC$Dialog.id, 3);
    }

    public String getHiddenWarningId(long j) {
        return getCoreMainClass().getHiddenWarningId(IdStorage.getInstance().getDialogId(j));
    }

    public void setHiddenWarningId(long j, String str) {
        getCoreMainClass().saveHiddenWarningId(IdStorage.getInstance().getDialogId(j), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getUpdates$97() {
        getCoreMainClass().getUpdate();
    }

    public void getUpdates() {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getUpdates$97();
            }
        });
    }

    public void getBlockedUsers(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_contacts_getBlocked) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda73
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$getBlockedUsers$98(tLObject, requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getBlockedUsers$98(TLObject tLObject, final RequestDelegate requestDelegate) {
        getCoreMainClass().getBlockedUsers(((TLRPC$TL_contacts_getBlocked) tLObject).nextStartId, new LoadListener<GetBlockedUsersOutput>() { // from class: androidMessenger.proxy.DialogsProxy.57
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(GetBlockedUsersOutput getBlockedUsersOutput) {
                TLRPC$TL_contacts_blocked tLRPC$TL_contacts_blocked = new TLRPC$TL_contacts_blocked();
                tLRPC$TL_contacts_blocked.hasContinue = getBlockedUsersOutput.has_continue;
                tLRPC$TL_contacts_blocked.nextStartId = getBlockedUsersOutput.next_start_id;
                Iterator<ChatAbsObject> it = getBlockedUsersOutput.abs_users.iterator();
                while (it.hasNext()) {
                    ChatAbsObject next = it.next();
                    if (next != null) {
                        long dialogId = ChatConverter.getDialogId(next.object_guid, next.type);
                        ChatType chatType = next.type;
                        if (chatType != ChatType.Group && chatType != ChatType.Channel) {
                            tLRPC$TL_contacts_blocked.users.add(ChatConverter.convertUser(DialogsProxy.this.getCoreMainClass(), dialogId, next, (UserInfo) null, (Chat) null));
                        } else {
                            TLRPC$TL_channel tLRPC$TL_channel = new TLRPC$TL_channel();
                            tLRPC$TL_channel.id = (int) (-dialogId);
                            ChatConverter.setAbsInfoForChannelGroup(tLRPC$TL_channel, next);
                            tLRPC$TL_contacts_blocked.chats.add(tLRPC$TL_channel);
                        }
                        tLRPC$TL_contacts_blocked.count++;
                        TLRPC$TL_peerBlocked tLRPC$TL_peerBlocked = new TLRPC$TL_peerBlocked();
                        tLRPC$TL_peerBlocked.peer_id = ChatConverter.getPeer(dialogId, next.object_guid, next.type);
                        tLRPC$TL_contacts_blocked.blocked.add(tLRPC$TL_peerBlocked);
                    }
                }
                requestDelegate.run(tLRPC$TL_contacts_blocked, null);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Failed To Load Blocked Users";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        });
    }

    public void callSetSpamActionBlockUser(final long j) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda27
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$callSetSpamActionBlockUser$99(j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$callSetSpamActionBlockUser$99(long j) {
        String dialogId = IdStorage.getInstance().getDialogId(j);
        if (dialogId == null) {
            return;
        }
        getCoreMainClass().setAskSpamActionBlockUser(dialogId);
    }

    public void callSetSpamActionReportAndLeave(final long j) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda24
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$callSetSpamActionReportAndLeave$100(j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$callSetSpamActionReportAndLeave$100(long j) {
        String dialogId = IdStorage.getInstance().getDialogId(j);
        if (dialogId == null) {
            return;
        }
        getCoreMainClass().setAskSpamActionReportAndLeave(dialogId);
    }

    public void callSetSpamActionCancel(final long j) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda22
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$callSetSpamActionCancel$101(j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$callSetSpamActionCancel$101(long j) {
        String dialogId = IdStorage.getInstance().getDialogId(j);
        if (dialogId == null) {
            return;
        }
        getCoreMainClass().setAskSpamActionCancel(dialogId);
    }

    public void callSetSpamActionAddToContact(final long j) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda26
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$callSetSpamActionAddToContact$102(j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$callSetSpamActionAddToContact$102(long j) {
        String dialogId = IdStorage.getInstance().getDialogId(j);
        if (dialogId == null) {
            return;
        }
        getCoreMainClass().setAskSpamActionAddToContact(dialogId);
    }

    public void getProfileLinkItems(final String str, final LoadListener<GetProfileLinkItemsOutputs> loadListener) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda44
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getProfileLinkItems$103(str, loadListener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getProfileLinkItems$103(String str, LoadListener loadListener) {
        if (str == null) {
            return;
        }
        getCoreMainClass().getProfileLinkItems(str, loadListener);
    }

    public HashSet<Chat.ChatAccessEnum> getAccessSet(int i) {
        Chat chatInstant = getCoreMainClass().getChatInstant(IdStorage.getInstance().getDialogId(-i));
        if (chatInstant != null) {
            return chatInstant.access;
        }
        return null;
    }

    public boolean canSetLink(long j) {
        return getCoreMainClass().canSetLink(IdStorage.getInstance().getDialogId(j));
    }

    public boolean canSetType(long j) {
        return getCoreMainClass().canSetType(IdStorage.getInstance().getDialogId(j));
    }

    public void setLiveSetting(final boolean z, final String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda48
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setLiveSetting$104(str, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setLiveSetting$104(String str, boolean z) {
        getCoreMainClass().setLiveSetting(str, z);
    }

    public void callReport(final String str, final long j, final String str2, final String str3, final int i) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda19
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$callReport$105(i, str2, str3, str, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$callReport$105(int i, String str, String str2, String str3, long j) {
        ReportObjectInput.ReportTypeEnum type = ReportObjectInput.ReportTypeEnum.getType(i);
        if (str != null) {
            getCoreMainClass().reportLive(str, type, str2, null);
        } else if (str3 != null) {
            if (j != 0) {
                getCoreMainClass().reportMessage(str3, String.valueOf(j), type, str2, null);
            } else {
                getCoreMainClass().reportObject(str3, type, str2, null);
            }
        }
    }

    public void callReport(final TLObject tLObject, RequestDelegate requestDelegate) {
        if ((tLObject instanceof TLRPC$TL_messages_report) || (tLObject instanceof TLRPC$TL_account_reportPeer)) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda63
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$callReport$106(tLObject);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0073 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$callReport$106(org.rbmain.tgnet.TLObject r9) {
        /*
            Method dump skipped, instructions count: 280
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidMessenger.proxy.DialogsProxy.lambda$callReport$106(org.rbmain.tgnet.TLObject):void");
    }

    public boolean canDeleteGlobalMyMessage(long j) {
        if (j == 0) {
            return false;
        }
        String dialogId = IdStorage.getInstance().getDialogId(j);
        if (TextUtils.isEmpty(dialogId)) {
            return false;
        }
        return getCoreMainClass().canDeleteGlobalMyMessage(dialogId);
    }

    public boolean canRevokeMessageForAll(long j, MessageObject messageObject) {
        if (j == 0 || messageObject == null) {
            return false;
        }
        String dialogId = IdStorage.getInstance().getDialogId(j);
        if (TextUtils.isEmpty(dialogId)) {
            return false;
        }
        return (messageObject.isOut() && getCoreMainClass().canDeleteGlobalMyMessage(dialogId)) || (!messageObject.isOut() && getCoreMainClass().canDeleteGlobalAllMessages(dialogId));
    }

    public ChatType getChatType(long j) {
        ChatAbsObject absInstant = getCoreMainClass().getAbsInstant(IdStorage.getInstance().getDialogId(j));
        if (absInstant == null) {
            return null;
        }
        return absInstant.type;
    }

    public void proxyVersionChanged() {
        ServiceLocator.getInstance(this.currentAccount).clearApiCache();
    }

    public boolean isPrivateChannel(TLRPC$Chat tLRPC$Chat) {
        if (tLRPC$Chat == null) {
            return false;
        }
        return getCoreMainClass().isChannelPrivate(IdStorage.getInstance().getDialogId(-tLRPC$Chat.id));
    }

    public void removeChatHint(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_contacts_resetTopPeerRating) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda66
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$removeChatHint$107(tLObject, requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removeChatHint$107(TLObject tLObject, final RequestDelegate requestDelegate) {
        TLRPC$InputPeer tLRPC$InputPeer = ((TLRPC$TL_contacts_resetTopPeerRating) tLObject).peer;
        if (tLRPC$InputPeer == null || !(tLRPC$InputPeer instanceof TLRPC$TL_inputPeerUser)) {
            return;
        }
        getCoreMainClass().removeChatHint(IdStorage.getInstance().getDialogId(tLRPC$InputPeer.user_id), new LoadListener<Integer>(this) { // from class: androidMessenger.proxy.DialogsProxy.58
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

    public boolean canSendMessage(int i) {
        if (i == 0) {
            return false;
        }
        return getCoreMainClass().canSendMessage(IdStorage.getInstance().getDialogId(i));
    }

    public boolean canSendMessage(long j) {
        if (j == 0) {
            return false;
        }
        return getCoreMainClass().canSendMessage(IdStorage.getInstance().getDialogId(j));
    }

    public void loadObjectInfo(final String str, final ChatType chatType, final boolean z, final RequestDelegate requestDelegate) {
        if (!TextUtils.isEmpty(str) && chatType != null) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda46
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadObjectInfo$108(str, chatType, z, requestDelegate);
                }
            });
        } else if (requestDelegate != null) {
            requestDelegate.run(null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadObjectInfo$108(String str, final ChatType chatType, boolean z, final RequestDelegate requestDelegate) {
        getCoreMainClass().refreshObjectInfo(str, chatType, z, new LoadListener<String>() { // from class: androidMessenger.proxy.DialogsProxy.59
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(String str2) {
                DialogsProxy.this.proxyObjectInfo(str2, chatType);
                RequestDelegate requestDelegate2 = requestDelegate;
                if (requestDelegate2 != null) {
                    requestDelegate2.run(null, null);
                }
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Failed To Load Object Info";
                RequestDelegate requestDelegate2 = requestDelegate;
                if (requestDelegate2 != null) {
                    requestDelegate2.run(null, tLRPC$TL_error);
                }
            }
        }, false);
    }

    public void getDialogMaxMessageId(long j, LongCallback longCallback) {
        Chat chatInstant;
        String dialogId = IdStorage.getInstance().getDialogId(j);
        if (TextUtils.isEmpty(dialogId) || (chatInstant = getCoreMainClass().getChatInstant(dialogId)) == null) {
            return;
        }
        longCallback.run(chatInstant.last_message_id);
    }

    public void editChatReactionSetting(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (!(tLObject instanceof TLRPC$TL_messages_setChatAvailableReactions)) {
            requestDelegate.run(null, new TLRPC$TL_error());
        } else {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda79
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$editChatReactionSetting$109(tLObject, requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$editChatReactionSetting$109(org.rbmain.tgnet.TLObject r4, final org.rbmain.tgnet.RequestDelegate r5) {
        /*
            r3 = this;
            org.rbmain.tgnet.TLRPC$TL_messages_setChatAvailableReactions r4 = (org.rbmain.tgnet.TLRPC$TL_messages_setChatAvailableReactions) r4
            org.rbmain.tgnet.TLRPC$InputPeer r0 = r4.peer
            boolean r1 = r0 instanceof org.rbmain.tgnet.TLRPC$TL_inputPeerUser
            if (r1 == 0) goto Lc
            int r0 = r0.user_id
        La:
            long r0 = (long) r0
            goto L1d
        Lc:
            boolean r1 = r0 instanceof org.rbmain.tgnet.TLRPC$TL_inputPeerChannel
            if (r1 == 0) goto L14
            int r0 = r0.channel_id
        L12:
            int r0 = -r0
            goto La
        L14:
            boolean r1 = r0 instanceof org.rbmain.tgnet.TLRPC$TL_inputPeerChat
            if (r1 == 0) goto L1b
            int r0 = r0.chat_id
            goto L12
        L1b:
            r0 = 0
        L1d:
            androidMessenger.proxy.IdStorage r2 = androidMessenger.proxy.IdStorage.getInstance()
            java.lang.String r0 = r2.getDialogId(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L35
            r4 = 0
            org.rbmain.tgnet.TLRPC$TL_error r0 = new org.rbmain.tgnet.TLRPC$TL_error
            r0.<init>()
            r5.run(r4, r0)
            return
        L35:
            org.rbmain.tgnet.TLRPC$ChatReactions r4 = r4.available_reactions
            ir.aaap.messengercore.model.ChatReactionSetting r4 = androidMessenger.utilites.ContactConverter.convertReactionSetting(r4)
            ir.aaap.messengercore.CoreMainClass r1 = r3.getCoreMainClass()
            boolean r1 = r1.isChannel(r0)
            androidMessenger.proxy.DialogsProxy$60 r2 = new androidMessenger.proxy.DialogsProxy$60
            r2.<init>(r3)
            if (r1 == 0) goto L52
            ir.aaap.messengercore.CoreMainClass r5 = r3.getCoreMainClass()
            r5.editChannelInfo(r0, r4, r2)
            goto L59
        L52:
            ir.aaap.messengercore.CoreMainClass r5 = r3.getCoreMainClass()
            r5.editGroupAvailableReactions(r0, r4, r2)
        L59:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidMessenger.proxy.DialogsProxy.lambda$editChatReactionSetting$109(org.rbmain.tgnet.TLObject, org.rbmain.tgnet.RequestDelegate):void");
    }

    public void startUpdateRunnable() {
        MyLog.e("updateRunnable", "startUpdateRunnable " + this.currentAccount);
        Utilities.stageQueue.postRunnable(this.updateRunnable);
    }

    public void stopUpdateRunnable() {
        MyLog.e("updateRunnable", "stopUpdateRunnable " + this.currentAccount);
        Utilities.stageQueue.cancelRunnable(this.updateRunnable);
    }

    public void loadGroupVoiceChatParticipantAbs(final long j) {
        final String dialogId = IdStorage.getInstance().getDialogId(j);
        if (TextUtils.isEmpty(dialogId)) {
            return;
        }
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.DialogsProxy$$ExternalSyntheticLambda42
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadGroupVoiceChatParticipantAbs$110(dialogId, j);
            }
        });
    }

    /* renamed from: androidMessenger.proxy.DialogsProxy$61, reason: invalid class name */
    class AnonymousClass61 implements LoadListener<ChatAbsObject> {
        final /* synthetic */ long val$did;

        @Override // ir.aaap.messengercore.LoadListener
        public void onError(Exception exc) {
        }

        AnonymousClass61(long j) {
            this.val$did = j;
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0064  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x006e  */
        @Override // ir.aaap.messengercore.LoadListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onDidLoad(ir.aaap.messengercore.model.ChatAbsObject r11) {
            /*
                r10 = this;
                if (r11 != 0) goto L3
                return
            L3:
                ir.aaap.messengercore.model.ChatType r0 = r11.type
                ir.aaap.messengercore.model.ChatType r1 = ir.aaap.messengercore.model.ChatType.User
                r2 = 0
                if (r0 != r1) goto L21
                androidMessenger.proxy.DialogsProxy r0 = androidMessenger.proxy.DialogsProxy.this
                org.rbmain.messenger.AccountInstance r0 = androidMessenger.proxy.DialogsProxy.access$300(r0)
                ir.aaap.messengercore.CoreMainClass r3 = r0.getCoreMainClass()
                long r4 = r10.val$did
                r7 = 0
                r8 = 0
                r6 = r11
                org.rbmain.tgnet.TLRPC$User r11 = androidMessenger.utilites.ChatConverter.convertUser(r3, r4, r6, r7, r8)
            L1d:
                r9 = r2
                r2 = r11
                r11 = r9
                goto L61
            L21:
                ir.aaap.messengercore.model.ChatType r1 = ir.aaap.messengercore.model.ChatType.Bot
                if (r0 != r1) goto L39
                androidMessenger.proxy.DialogsProxy r0 = androidMessenger.proxy.DialogsProxy.this
                org.rbmain.messenger.AccountInstance r0 = androidMessenger.proxy.DialogsProxy.access$400(r0)
                ir.aaap.messengercore.CoreMainClass r3 = r0.getCoreMainClass()
                long r4 = r10.val$did
                r7 = 0
                r8 = 0
                r6 = r11
                org.rbmain.tgnet.TLRPC$User r11 = androidMessenger.utilites.ChatConverter.convertBot(r3, r4, r6, r7, r8)
                goto L1d
            L39:
                ir.aaap.messengercore.model.ChatType r1 = ir.aaap.messengercore.model.ChatType.Service
                if (r0 != r1) goto L4d
                androidMessenger.proxy.DialogsProxy r0 = androidMessenger.proxy.DialogsProxy.this
                ir.aaap.messengercore.CoreMainClass r3 = androidMessenger.proxy.DialogsProxy.access$500(r0)
                long r4 = r10.val$did
                r7 = 0
                r8 = 0
                r6 = r11
                org.rbmain.tgnet.TLRPC$User r11 = androidMessenger.utilites.ChatConverter.convertService(r3, r4, r6, r7, r8)
                goto L1d
            L4d:
                ir.aaap.messengercore.model.ChatType r1 = ir.aaap.messengercore.model.ChatType.Channel
                if (r0 == r1) goto L57
                ir.aaap.messengercore.model.ChatType r1 = ir.aaap.messengercore.model.ChatType.Group
                if (r0 != r1) goto L56
                goto L57
            L56:
                return
            L57:
                androidMessenger.proxy.DialogsProxy r0 = androidMessenger.proxy.DialogsProxy.this
                ir.aaap.messengercore.CoreMainClass r0 = androidMessenger.proxy.DialogsProxy.access$600(r0)
                org.rbmain.tgnet.TLRPC$Chat r11 = androidMessenger.utilites.ChatConverter.convertChannelGroup(r0, r11, r2)
            L61:
                r0 = 0
                if (r2 == 0) goto L6e
                androidMessenger.proxy.DialogsProxy r11 = androidMessenger.proxy.DialogsProxy.this
                org.rbmain.messenger.MessagesController r11 = androidMessenger.proxy.DialogsProxy.access$700(r11)
                r11.putUser(r2, r0)
                goto L79
            L6e:
                if (r11 == 0) goto L79
                androidMessenger.proxy.DialogsProxy r1 = androidMessenger.proxy.DialogsProxy.this
                org.rbmain.messenger.MessagesController r1 = androidMessenger.proxy.DialogsProxy.access$800(r1)
                r1.putChat(r11, r0)
            L79:
                androidMessenger.proxy.DialogsProxy$61$$ExternalSyntheticLambda0 r11 = new androidMessenger.proxy.DialogsProxy$61$$ExternalSyntheticLambda0
                r11.<init>()
                org.rbmain.messenger.AndroidUtilities.runOnUIThread(r11)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidMessenger.proxy.DialogsProxy.AnonymousClass61.onDidLoad(ir.aaap.messengercore.model.ChatAbsObject):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onDidLoad$0() {
            DialogsProxy.this.getNotificationCenter().postNotificationName(NotificationCenter.updateInterfaces, 16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadGroupVoiceChatParticipantAbs$110(String str, long j) {
        getCoreMainClass().getChatAbs(str, new AnonymousClass61(j));
    }
}
