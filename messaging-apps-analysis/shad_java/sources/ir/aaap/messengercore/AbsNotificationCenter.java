package ir.aaap.messengercore;

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
import ir.aaap.messengercore.model.VoiceCallModels;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public interface AbsNotificationCenter {
    void absForMessagesDidLoad(String str, Set<String> set);

    void absForReactionsDidLoad(String str, Set<String> set);

    void appNotificationsSettingsUpdated();

    void appearanceSettingsUpdated();

    void availableReactionsDidLoad();

    void chatAdsDidLoad();

    void chatOnlineCountDidLoad(String str, int i);

    void chatsNeedReload(ChatNeedReloadResult chatNeedReloadResult);

    void contactsNeedsReload(ContactsNeedsReloadResult contactsNeedsReloadResult);

    void dataSettingsUpdated();

    void dialogFiltersUpdated();

    void dialogsLoadingChanged(boolean z);

    void dialogsUnreadCounterChanged();

    void didLoadPinnedMessages(String str, ArrayList<Long> arrayList);

    void didReceiveNewMessages(String str, ChatType chatType, ArrayList<Message> arrayList);

    void didUpdateChatMessagesReactions(String str, Map<Long, ArrayList<MessageReactionObject>> map);

    void didUpdateMessagesViews(String str, Map<Long, Integer> map, long j);

    void didUpdatePollResults(String str, ChatType chatType, long j, PollObject pollObject);

    void lastOnlineUpdated();

    void liveStatusChanged(String str, LiveModels.LiveStatus liveStatus);

    void loadingMessagesFailed(LoadMessagesResult loadMessagesResult);

    void loadingMessagesFailedInterval(LoadMessagesIntervalResult loadMessagesIntervalResult);

    void messageUpdatedOldState(String str, ChatType chatType);

    void messagesDeleted(String str, ChatType chatType, ArrayList<Long> arrayList);

    void messagesDidLoad(LoadMessagesResult loadMessagesResult);

    void messagesDidLoadInterval(LoadMessagesIntervalResult loadMessagesIntervalResult);

    void messagesUpdated(String str, ChatType chatType, ArrayList<MessageUpdateResult> arrayList);

    void myStickersDidLoad();

    void myStickersFailed();

    void myUserInfoDidLoad(String str, ChatType chatType);

    void myUserInfoLoadFailed();

    void notificationsSettingsUpdated(String str);

    void objectInfoDidLoad(String str, ChatType chatType);

    void objectInfoLoadFailed(String str, ChatType chatType);

    void onCallSignalDataReceived(String str, String str2);

    void onInvalidAuth();

    void onLinkClicked(Link link);

    void onNewNotif(boolean z, boolean z2, ArrayList<NotificationModels.ShowNotificationObject> arrayList, ArrayList<NotificationModels.ShowNotificationObject> arrayList2, ArrayList<NotificationModels.ShowNotificationObject> arrayList3);

    void onProcessCallUpdate(ArrayList<VoiceCallModels.CallUpdateObject> arrayList);

    void onUpdateShowActivities(ArrayList<ShowActivityObject> arrayList);

    void onUpdateShowActivitiesWithNewMessages(Map<ObjectGuidType, ArrayList<Message>> map);

    void privacySettingsUpdated();

    void processGroupCallUpdate(GroupCallModels.GroupVoiceChatUpdate groupVoiceChatUpdate);

    void processGroupVoiceChatParticipantUpdate(ArrayList<GroupCallModels.GroupVoiceChatParticipantUpdate> arrayList, boolean z);

    void processLoadedUnreadNotifications(ArrayList<NotificationModels.ShowNotificationObject> arrayList);

    void replyMessagesDidLoad(String str, ChatType chatType, ArrayList<Message> arrayList);

    void settingsUpdated();

    void stickerSetDidLoad(String str);

    void themesDidLoad();

    void versionChanged();
}
