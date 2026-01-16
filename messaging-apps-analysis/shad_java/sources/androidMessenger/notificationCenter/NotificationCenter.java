package androidMessenger.notificationCenter;

import androidMessenger.proxy.IdStorage;
import androidMessenger.utilites.ChatConverter;
import androidMessenger.utilites.MyLog;
import ir.aaap.messengercore.AbsNotificationCenter;
import ir.aaap.messengercore.MessageUtils;
import ir.aaap.messengercore.model.ChatNeedReloadResult;
import ir.aaap.messengercore.model.ChatType;
import ir.aaap.messengercore.model.ContactsNeedsReloadResult;
import ir.aaap.messengercore.model.GroupCallModels;
import ir.aaap.messengercore.model.Link;
import ir.aaap.messengercore.model.LiveModels;
import ir.aaap.messengercore.model.LoadMessagesIntervalResult;
import ir.aaap.messengercore.model.LoadMessagesResult;
import ir.aaap.messengercore.model.Message;
import ir.aaap.messengercore.model.MessageReactionObject;
import ir.aaap.messengercore.model.MessageUpdateResult;
import ir.aaap.messengercore.model.NotificationModels;
import ir.aaap.messengercore.model.ObjectGuidType;
import ir.aaap.messengercore.model.PollObject;
import ir.aaap.messengercore.model.ShowActivityObject;
import ir.aaap.messengercore.model.SortedContactResult;
import ir.aaap.messengercore.model.VoiceCallModels;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import org.rbmain.messenger.AccountInstance;
import org.rbmain.messenger.AndroidUtilities;

/* loaded from: classes.dex */
public class NotificationCenter implements AbsNotificationCenter {
    private static volatile NotificationCenter[] Instance = new NotificationCenter[3];
    private int currentAccount;

    @Override // ir.aaap.messengercore.AbsNotificationCenter
    public void myUserInfoLoadFailed() {
    }

    @Override // ir.aaap.messengercore.AbsNotificationCenter
    public void privacySettingsUpdated() {
    }

    @Override // ir.aaap.messengercore.AbsNotificationCenter
    public void stickerSetDidLoad(String str) {
    }

    public static NotificationCenter getInstance(int i) {
        NotificationCenter notificationCenter = Instance[i];
        if (notificationCenter == null) {
            synchronized (NotificationCenter.class) {
                notificationCenter = Instance[i];
                if (notificationCenter == null) {
                    NotificationCenter[] notificationCenterArr = Instance;
                    NotificationCenter notificationCenter2 = new NotificationCenter(i);
                    notificationCenterArr[i] = notificationCenter2;
                    notificationCenter = notificationCenter2;
                }
            }
        }
        return notificationCenter;
    }

    public NotificationCenter(int i) {
        this.currentAccount = i;
    }

    @Override // ir.aaap.messengercore.AbsNotificationCenter
    public void messagesDidLoad(LoadMessagesResult loadMessagesResult) {
        MyLog.e("NotificationCenter", "messagesDidLoad " + loadMessagesResult.toString());
        if (loadMessagesResult.filterType == null) {
            AccountInstance.getInstance(this.currentAccount).getMessageProxy().proxyMessages(loadMessagesResult);
        } else {
            AccountInstance.getInstance(this.currentAccount).getMediaProxy().proxyMedias(loadMessagesResult);
        }
    }

    @Override // ir.aaap.messengercore.AbsNotificationCenter
    public void replyMessagesDidLoad(String str, ChatType chatType, ArrayList<Message> arrayList) {
        StringBuilder sb = new StringBuilder();
        sb.append("replyMessagesDidLoad ");
        sb.append(arrayList != null ? arrayList.toString() : "null");
        MyLog.e("NotificationCenter", sb.toString());
        AccountInstance.getInstance(this.currentAccount).getMessageProxy().proxyReplyMessages(str, chatType, arrayList);
    }

    @Override // ir.aaap.messengercore.AbsNotificationCenter
    public void absForMessagesDidLoad(String str, Set<String> set) {
        StringBuilder sb = new StringBuilder();
        sb.append("absForMessagesDidLoad ");
        sb.append(set != null ? set.toString() : "null");
        MyLog.e("NotificationCenter", sb.toString());
        AccountInstance.getInstance(this.currentAccount).getDialogsProxy().proxyAbsObjects(str, set);
    }

    @Override // ir.aaap.messengercore.AbsNotificationCenter
    public void lastOnlineUpdated() {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.notificationCenter.NotificationCenter$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$lastOnlineUpdated$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$lastOnlineUpdated$0() {
        org.rbmain.messenger.NotificationCenter.getInstance(this.currentAccount).postNotificationName(org.rbmain.messenger.NotificationCenter.lastOnlineUpdated, new Object[0]);
        org.rbmain.messenger.NotificationCenter.getInstance(this.currentAccount).postNotificationName(org.rbmain.messenger.NotificationCenter.updateInterfaces, 4);
    }

    @Override // ir.aaap.messengercore.AbsNotificationCenter
    public void messagesDidLoadInterval(LoadMessagesIntervalResult loadMessagesIntervalResult) {
        MyLog.e("NotificationCenter", "messagesDidLoadInterval " + loadMessagesIntervalResult.toString());
        if (loadMessagesIntervalResult.filterType == null) {
            AccountInstance.getInstance(this.currentAccount).getMessageProxy().proxyMessages(loadMessagesIntervalResult);
        } else {
            MessageUtils.FilterTypeEnum filterTypeEnum = MessageUtils.FilterTypeEnum.Media;
        }
    }

    @Override // ir.aaap.messengercore.AbsNotificationCenter
    public void myStickersDidLoad() {
        AccountInstance.getInstance(this.currentAccount).getMessageProxy().proxyMyStickers();
    }

    @Override // ir.aaap.messengercore.AbsNotificationCenter
    public void myStickersFailed() {
        AccountInstance.getInstance(this.currentAccount).getMessageProxy().proxyMyStickersFailed();
    }

    @Override // ir.aaap.messengercore.AbsNotificationCenter
    public void loadingMessagesFailed(LoadMessagesResult loadMessagesResult) {
        AccountInstance.getInstance(this.currentAccount).getMessageProxy().proxyFailedMessages(loadMessagesResult);
    }

    @Override // ir.aaap.messengercore.AbsNotificationCenter
    public void loadingMessagesFailedInterval(LoadMessagesIntervalResult loadMessagesIntervalResult) {
        AccountInstance.getInstance(this.currentAccount).getMessageProxy().proxyFailedMessages(loadMessagesIntervalResult);
    }

    @Override // ir.aaap.messengercore.AbsNotificationCenter
    public void chatsNeedReload(ChatNeedReloadResult chatNeedReloadResult) {
        if (chatNeedReloadResult.typeEnum != ChatNeedReloadResult.TypeEnum.hasError) {
            AccountInstance.getInstance(this.currentAccount).getDialogsProxy().proxyChatResults(chatNeedReloadResult);
        }
    }

    @Override // ir.aaap.messengercore.AbsNotificationCenter
    public void dialogsLoadingChanged(boolean z) {
        AccountInstance.getInstance(this.currentAccount).getDialogsProxy().proxyDialogLoading(z);
    }

    @Override // ir.aaap.messengercore.AbsNotificationCenter
    public void objectInfoDidLoad(String str, ChatType chatType) {
        AccountInstance.getInstance(this.currentAccount).getDialogsProxy().proxyObjectInfo(str, chatType);
    }

    @Override // ir.aaap.messengercore.AbsNotificationCenter
    public void myUserInfoDidLoad(String str, ChatType chatType) {
        AccountInstance.getInstance(this.currentAccount).getDialogsProxy().loadCurrentUser();
    }

    @Override // ir.aaap.messengercore.AbsNotificationCenter
    public void objectInfoLoadFailed(String str, ChatType chatType) {
        AccountInstance.getInstance(this.currentAccount).getDialogsProxy().proxyObjectInfo(str, chatType);
    }

    @Override // ir.aaap.messengercore.AbsNotificationCenter
    public void notificationsSettingsUpdated(String str) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.notificationCenter.NotificationCenter$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$notificationsSettingsUpdated$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notificationsSettingsUpdated$1() {
        org.rbmain.messenger.NotificationCenter.getInstance(this.currentAccount).postNotificationName(org.rbmain.messenger.NotificationCenter.notificationsSettingsUpdated, new Object[0]);
    }

    @Override // ir.aaap.messengercore.AbsNotificationCenter
    public void didReceiveNewMessages(String str, ChatType chatType, ArrayList<Message> arrayList) {
        if (str != null) {
            AccountInstance.getInstance(this.currentAccount).getMessageProxy().proxyNewMessages(ChatConverter.getDialogId(str, chatType), chatType, arrayList);
        } else {
            MyLog.handleExceptionThrowOnDebug(new Exception("chatGuid is null"));
        }
    }

    @Override // ir.aaap.messengercore.AbsNotificationCenter
    public void messagesDeleted(String str, ChatType chatType, ArrayList<Long> arrayList) {
        if (str != null) {
            AccountInstance.getInstance(this.currentAccount).getMessageProxy().proxyDeletedMessages(ChatConverter.getDialogId(str, chatType), chatType, arrayList);
        } else {
            MyLog.handleExceptionThrowOnDebug(new Exception("chatGuid is null"));
        }
    }

    @Override // ir.aaap.messengercore.AbsNotificationCenter
    public void messagesUpdated(String str, ChatType chatType, ArrayList<MessageUpdateResult> arrayList) {
        if (str != null) {
            AccountInstance.getInstance(this.currentAccount).getMessageProxy().proxyMessagesUpdate(ChatConverter.getDialogId(str, chatType), chatType, arrayList);
        } else {
            MyLog.handleExceptionThrowOnDebug(new Exception("chatGuid is null"));
        }
    }

    @Override // ir.aaap.messengercore.AbsNotificationCenter
    public void messageUpdatedOldState(String str, ChatType chatType) {
        final long dialogId = ChatConverter.getDialogId(str, chatType);
        if (dialogId != 0) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.notificationCenter.NotificationCenter$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$messageUpdatedOldState$2(dialogId);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$messageUpdatedOldState$2(long j) {
        org.rbmain.messenger.NotificationCenter.getInstance(this.currentAccount).postNotificationName(org.rbmain.messenger.NotificationCenter.onOldStateMessageUpdate, Long.valueOf(j));
    }

    @Override // ir.aaap.messengercore.AbsNotificationCenter
    public void chatOnlineCountDidLoad(final String str, final int i) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.notificationCenter.NotificationCenter$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$chatOnlineCountDidLoad$3(str, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$chatOnlineCountDidLoad$3(String str, int i) {
        org.rbmain.messenger.NotificationCenter.getInstance(this.currentAccount).postNotificationName(org.rbmain.messenger.NotificationCenter.chatOnlineCountDidLoad, Integer.valueOf((int) (-IdStorage.getInstance().generateNegativeDialogId(str))), Integer.valueOf(i));
    }

    @Override // ir.aaap.messengercore.AbsNotificationCenter
    public void dialogFiltersUpdated() {
        AccountInstance.getInstance(this.currentAccount).getDialogsProxy().proxyFolderResult(AccountInstance.getInstance(this.currentAccount).getCoreMainClass().getFolderListInstant());
    }

    @Override // ir.aaap.messengercore.AbsNotificationCenter
    public void dialogsUnreadCounterChanged() {
        AccountInstance.getInstance(this.currentAccount).getDialogsProxy().updateDialogsUnreadCounter();
    }

    @Override // ir.aaap.messengercore.AbsNotificationCenter
    public void didLoadPinnedMessages(String str, ArrayList<Long> arrayList) {
        Collections.reverse(arrayList);
        AccountInstance.getInstance(this.currentAccount).getDialogsProxy().processLoadedPinnedMessages(str, arrayList);
    }

    @Override // ir.aaap.messengercore.AbsNotificationCenter
    public void didUpdateMessagesViews(String str, Map<Long, Integer> map, long j) {
        AccountInstance.getInstance(this.currentAccount).getMessageProxy().processUpdatedMessagesViews(str, map, j);
    }

    @Override // ir.aaap.messengercore.AbsNotificationCenter
    public void onProcessCallUpdate(ArrayList<VoiceCallModels.CallUpdateObject> arrayList) {
        AccountInstance.getInstance(this.currentAccount).getCallProxy().processCallUpdate(arrayList);
    }

    @Override // ir.aaap.messengercore.AbsNotificationCenter
    public void contactsNeedsReload(ContactsNeedsReloadResult contactsNeedsReloadResult) {
        SortedContactResult sortedContactListInstant = AccountInstance.getInstance(this.currentAccount).getCoreMainClass().getSortedContactListInstant();
        if (sortedContactListInstant != null) {
            AccountInstance.getInstance(this.currentAccount).getContactsProxy().proxyContactsResult(sortedContactListInstant.sortedByLasOnlineContacts);
        }
    }

    @Override // ir.aaap.messengercore.AbsNotificationCenter
    public void onCallSignalDataReceived(String str, String str2) {
        AccountInstance.getInstance(this.currentAccount).getCallProxy().onSignalDataReceived(str, str2);
    }

    @Override // ir.aaap.messengercore.AbsNotificationCenter
    public void didUpdatePollResults(String str, ChatType chatType, long j, PollObject pollObject) {
        AccountInstance.getInstance(this.currentAccount).getMessageProxy().proxyPollStatus(str, chatType, j, pollObject);
    }

    @Override // ir.aaap.messengercore.AbsNotificationCenter
    public void settingsUpdated() {
        AccountInstance.getInstance(this.currentAccount).getContactsProxy().proxySettings();
    }

    @Override // ir.aaap.messengercore.AbsNotificationCenter
    public void themesDidLoad() {
        AccountInstance.getInstance(this.currentAccount).getContactsProxy().proxyThemes();
    }

    @Override // ir.aaap.messengercore.AbsNotificationCenter
    public void liveStatusChanged(String str, LiveModels.LiveStatus liveStatus) {
        AccountInstance.getInstance(this.currentAccount).getMessageProxy().proxyLiveStatus(str, liveStatus);
    }

    @Override // ir.aaap.messengercore.AbsNotificationCenter
    public void onUpdateShowActivities(ArrayList<ShowActivityObject> arrayList) {
        AccountInstance.getInstance(this.currentAccount).getDialogsProxy().proxyShowActivities(arrayList);
    }

    @Override // ir.aaap.messengercore.AbsNotificationCenter
    public void onUpdateShowActivitiesWithNewMessages(Map<ObjectGuidType, ArrayList<Message>> map) {
        AccountInstance.getInstance(this.currentAccount).getDialogsProxy().proxyShowActivitiesWithNewMessages(map);
    }

    @Override // ir.aaap.messengercore.AbsNotificationCenter
    public void onInvalidAuth() {
        AccountInstance.getInstance(this.currentAccount).getDialogsProxy().proxyInvalidAuth();
    }

    @Override // ir.aaap.messengercore.AbsNotificationCenter
    public void chatAdsDidLoad() {
        MyLog.e("NotificationCenter", "chatAdsDidLoad");
        AccountInstance.getInstance(this.currentAccount).getDialogsProxy().proxyAdsResult();
    }

    @Override // ir.aaap.messengercore.AbsNotificationCenter
    public void onNewNotif(boolean z, boolean z2, ArrayList<NotificationModels.ShowNotificationObject> arrayList, ArrayList<NotificationModels.ShowNotificationObject> arrayList2, ArrayList<NotificationModels.ShowNotificationObject> arrayList3) {
        AccountInstance.getInstance(this.currentAccount).getMessageProxy().proxyNewNotification(z, z2, arrayList, arrayList2, arrayList3);
    }

    @Override // ir.aaap.messengercore.AbsNotificationCenter
    public void processLoadedUnreadNotifications(ArrayList<NotificationModels.ShowNotificationObject> arrayList) {
        AccountInstance.getInstance(this.currentAccount).getMessageProxy().proxyLoadedNotifications(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onLinkClicked$4(Link link) {
        AccountInstance.getInstance(this.currentAccount).getMessengerLinkHandler().onLinkClick(link);
    }

    @Override // ir.aaap.messengercore.AbsNotificationCenter
    public void onLinkClicked(final Link link) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.notificationCenter.NotificationCenter$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onLinkClicked$4(link);
            }
        });
    }

    @Override // ir.aaap.messengercore.AbsNotificationCenter
    public void dataSettingsUpdated() {
        AccountInstance.getInstance(this.currentAccount).getContactsProxy().proxyDataSettings();
    }

    @Override // ir.aaap.messengercore.AbsNotificationCenter
    public void appNotificationsSettingsUpdated() {
        AccountInstance.getInstance(this.currentAccount).getContactsProxy().proxyNotificationSettings();
    }

    @Override // ir.aaap.messengercore.AbsNotificationCenter
    public void appearanceSettingsUpdated() throws IOException {
        AccountInstance.getInstance(this.currentAccount).getContactsProxy().proxyAppearanceSettings();
    }

    @Override // ir.aaap.messengercore.AbsNotificationCenter
    public void versionChanged() {
        AccountInstance.getInstance(this.currentAccount).getDialogsProxy().proxyVersionChanged();
    }

    @Override // ir.aaap.messengercore.AbsNotificationCenter
    public void availableReactionsDidLoad() {
        AccountInstance.getInstance(this.currentAccount).getContactsProxy().proxyLoadedAvailableReactions();
    }

    @Override // ir.aaap.messengercore.AbsNotificationCenter
    public void didUpdateChatMessagesReactions(String str, Map<Long, ArrayList<MessageReactionObject>> map) {
        AccountInstance.getInstance(this.currentAccount).getMessageProxy().processUpdatedChatReactions(str, map);
    }

    @Override // ir.aaap.messengercore.AbsNotificationCenter
    public void absForReactionsDidLoad(String str, Set<String> set) {
        AccountInstance.getInstance(this.currentAccount).getDialogsProxy().proxyAbsObjects(str, set);
    }

    @Override // ir.aaap.messengercore.AbsNotificationCenter
    public void processGroupCallUpdate(GroupCallModels.GroupVoiceChatUpdate groupVoiceChatUpdate) {
        AccountInstance.getInstance(this.currentAccount).getCallProxy().processGroupCallUpdate(groupVoiceChatUpdate);
    }

    @Override // ir.aaap.messengercore.AbsNotificationCenter
    public void processGroupVoiceChatParticipantUpdate(ArrayList<GroupCallModels.GroupVoiceChatParticipantUpdate> arrayList, boolean z) {
        AccountInstance.getInstance(this.currentAccount).getCallProxy().proxyGroupParticipantUpdate(arrayList, z);
    }
}
