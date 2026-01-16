package ir.aaap.messengercore.db;

import ir.aaap.messengercore.MessageUtils;
import ir.aaap.messengercore.model.BotInfo;
import ir.aaap.messengercore.model.ChannelInfo;
import ir.aaap.messengercore.model.Chat;
import ir.aaap.messengercore.model.ChatAbsObject;
import ir.aaap.messengercore.model.ChatExtra;
import ir.aaap.messengercore.model.ChatFromServer;
import ir.aaap.messengercore.model.ChatParamUpdateTimeObject;
import ir.aaap.messengercore.model.ChatType;
import ir.aaap.messengercore.model.FileInlineObject;
import ir.aaap.messengercore.model.FolderObject;
import ir.aaap.messengercore.model.GroupInfo;
import ir.aaap.messengercore.model.LiveLocationObject;
import ir.aaap.messengercore.model.LiveModels;
import ir.aaap.messengercore.model.Message;
import ir.aaap.messengercore.model.MessageHoleObject;
import ir.aaap.messengercore.model.MessageReactionObject;
import ir.aaap.messengercore.model.MessageUpdateResult;
import ir.aaap.messengercore.model.NotificationModels;
import ir.aaap.messengercore.model.PhoneBookObject;
import ir.aaap.messengercore.model.PollObject;
import ir.aaap.messengercore.model.RubinoPostData;
import ir.aaap.messengercore.model.RubinoStoryData;
import ir.aaap.messengercore.model.ServiceInfo;
import ir.aaap.messengercore.model.StickerObject;
import ir.aaap.messengercore.model.UserInfo;
import ir.aaap.messengercore.model.UserInfoFromServer;
import ir.aaap.messengercore.model.api.GetStickerSetByIdOutput;
import ir.aaap.messengercore.model.api.InSearchObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public interface DBHelper {
    public static final int GET_CHATS_LIMIT = 2500;
    public static final int GET_CHAT_HINT_OR_RECENT_LIMIT = 30;
    public static final int GET_CONTACTS_LIMIT = 2500;
    public static final int GET_FOLDERS_LIMIT = 20;
    public static final int GET_GIF_LIMIT = 600;
    public static final int GET_LOCAL_MESSAGES_LIMIT = 600;
    public static final int GET_MY_STICKER_SET_LIMIT = 600;
    public static final int GET_NOTIFICATION_LIMIT = 200;
    public static final int GET_STICKER_LIMIT = 900;

    void addAbsObject(ChatAbsObject chatAbsObject, long j);

    void addAllAbsObject(Collection<ChatAbsObject> collection, long j);

    void addAllChatExtras(Collection<ChatExtra> collection);

    void addAllChats(Collection<Chat> collection);

    void addAllContactsAndUserInfo(ArrayList<UserInfo> arrayList, long j);

    void addAllFavoriteSticker(ArrayList<StickerObject> arrayList, long j);

    void addAllFolders(ArrayList<FolderObject> arrayList);

    void addAllHoles(String str, Collection<MessageHoleObject> collection);

    void addAllMessages(String str, Collection<Message> collection, long j);

    void addAllMessagesAndFillHoles(String str, ArrayList<Message> arrayList, long j, long j2, MessageUtils.FilterTypeEnum filterTypeEnum, long j3, long j4);

    void addAllMyStickerSet(ArrayList<GetStickerSetByIdOutput> arrayList);

    void addAllNotification(ArrayList<NotificationModels.ShowNotificationObject> arrayList);

    void addAllPhoneBook(Collection<PhoneBookObject> collection);

    void addAllRecentGif(ArrayList<FileInlineObject> arrayList, long j);

    void addAllRecentSticker(ArrayList<StickerObject> arrayList, long j);

    void addAllUserInfo(ArrayList<UserInfo> arrayList, long j);

    void addBotInfo(BotInfo botInfo, long j);

    void addChannelInfo(ChannelInfo channelInfo, long j);

    void addContact(UserInfo userInfo, long j);

    void addFolder(FolderObject folderObject);

    void addGroupInfo(GroupInfo groupInfo, long j);

    void addMessage(String str, Message message);

    void addMyStickerSet(GetStickerSetByIdOutput getStickerSetByIdOutput);

    void addOrUpdateChatExtra(ChatExtra chatExtra);

    void addOrUpdateRecentChat(InSearchObject inSearchObject, long j);

    void addRecentGif(FileInlineObject fileInlineObject, long j);

    void addSentFile(String str, FileInlineObject fileInlineObject, long j);

    void addServiceInfo(ServiceInfo serviceInfo, long j);

    void addUserInfo(UserInfo userInfo, long j);

    void clearDatabase(boolean z);

    void clearLocalMessageFileInline(long j);

    void createAbsTable();

    void createBotTable();

    void createChannelInfoTable();

    void createChatExtraTable();

    void createChatHintTable();

    void createChatTable();

    void createContactTable();

    void createFoldersTable();

    void createGroupInfoTable();

    void createHoleTable();

    void createMessageTable();

    void createMyStickerSetTable();

    void createPhoneBookTable();

    void createRecentChatTable();

    void createRecentGifTable();

    void createRecentStickerTable();

    void createSentFileTable();

    void createServiceTable();

    void createUserTable();

    void fillHole(String str, long j, long j2, MessageUtils.FilterTypeEnum filterTypeEnum, long j3);

    ChatAbsObject getAbsObject(String str);

    ArrayList<ChatAbsObject> getAllAbsObject(ArrayList<String> arrayList);

    ArrayList<ChatExtra> getAllChatExtra(ArrayList<String> arrayList);

    ArrayList<String> getAllChatHintGuid();

    ArrayList<Chat> getAllChats();

    ArrayList<String> getAllChatsGuidOrderByTime(int i);

    ArrayList<Chat> getAllChatsOrderByTime();

    ArrayList<String> getAllContacts();

    ArrayList<FolderObject> getAllFolders();

    ArrayList<Message> getAllLocalMessages(Set<Integer> set);

    ArrayList<GetStickerSetByIdOutput> getAllMyStickerSets();

    ArrayList<NotificationModels.ShowNotificationObject> getAllNotificationById(ArrayList<String> arrayList);

    ArrayList<NotificationModels.ShowNotificationObject> getAllNotifications();

    Map<String, PhoneBookObject> getAllPhoneBook();

    Map<String, PhoneBookObject> getAllPhoneBook(ArrayList<String> arrayList);

    ArrayList<InSearchObject> getAllRecentChat();

    ArrayList<FileInlineObject> getAllRecentGif();

    ArrayList<UserInfo> getAllUserInfoObject(ArrayList<String> arrayList);

    BotInfo getBotInfo(String str);

    BotInfo getBotInfoByUsername(String str);

    ChannelInfo getChannelInfo(String str);

    ChannelInfo getChannelInfoByUsername(String str);

    Chat getChatById(String str);

    ChatExtra getChatExtra(String str);

    ArrayList<StickerObject> getFavoriteStickers();

    GroupInfo getGroupInfo(String str);

    Message getLastLocalMessage(String str, MessageUtils.FilterTypeEnum filterTypeEnum);

    GetMessagesResultInner getLocalMessages(String str, MessageUtils.FilterTypeEnum filterTypeEnum, long j, long j2, boolean z, int i);

    Message getMessageById(String str, long j);

    GetMessagesResultInner getMessagesInterval(String str, MessageUtils.FilterTypeEnum filterTypeEnum, long j, long j2, long j3, int i, int i2);

    GetMessagesResultInner getMessagesToBottomOrTop(String str, MessageUtils.FilterTypeEnum filterTypeEnum, boolean z, long j, long j2, long j3, int i);

    ArrayList<Message> getMessagesWithFileInline(String str);

    ArrayList<String> getNotificationByChat(String str);

    NotificationModels.ShowNotificationObject getNotificationById(String str);

    ArrayList<String> getNotificationIDToMessageIdOrTime(String str, ChatType chatType, long j, long j2);

    ArrayList<String> getNotificationToMessageId(String str, long j);

    ArrayList<String> getRecentContacts();

    ArrayList<StickerObject> getRecentStickers();

    FileInlineObject getSentFile(String str);

    ServiceInfo getServiceInfo(String str);

    UserInfo getUserInfo(String str);

    UserInfo getUserInfoByUsername(String str);

    boolean increaseRateChatHint(String str, ChatType chatType, long j);

    boolean isMessageIdInDb(String str, MessageUtils.FilterTypeEnum filterTypeEnum, long j);

    void removeAllAbs();

    void removeAllChatExtra();

    void removeAllChatHint();

    void removeAllChats();

    void removeAllContacts();

    void removeAllFavoriteSticker();

    void removeAllFolders();

    void removeAllFolders(ArrayList<String> arrayList);

    void removeAllGif();

    void removeAllMessagesAndHoles(String str);

    void removeAllMessagesAndHoles(ArrayList<String> arrayList);

    void removeAllMyStickerSet();

    void removeAllNotLocalMessagesAndHoles(String str);

    void removeAllNotifications(ArrayList<String> arrayList);

    void removeAllPhoneBooks();

    void removeAllRecentChat();

    void removeAllRecentOrFavoriteStickers();

    void removeAllRecentSticker();

    void removeChatExtra(String str);

    void removeChatExtra(ArrayList<String> arrayList);

    void removeChats(ArrayList<String> arrayList);

    void removeContact(String str);

    void removeContacts(ArrayList<String> arrayList);

    void removeFavoriteSticker(String str);

    void removeGif(String str);

    void removeHole(String str, MessageHoleObject messageHoleObject);

    void removeLocalMessageByRnd(String str, long j);

    void removeMyStickerSet(String str);

    void removeRecentChat(String str);

    ArrayList<UserInfo> searchUsers(String str, ArrayList<String> arrayList);

    void setAllNotificationsRead();

    void setMessageDeleted(String str, long j, long j2);

    void setNotificationReadByGuid(String str);

    void updateChatLastMessageText(String str, String str2);

    void updateChatParameter(Map<String, ChatFromServer> map, Map<String, Set<ChatParamUpdateTimeObject.Params>> map2, Map<String, Long> map3);

    void updateContactLastOnline(ArrayList<UserInfoFromServer> arrayList);

    void updateFolderOrder(String str, int i);

    void updateLiveLocation(String str, long j, LiveLocationObject liveLocationObject);

    void updateMessageLiveStatus(String str, LiveModels.LiveStatus liveStatus);

    void updateMessageLocalParameters(Message message);

    void updateMessageOnLocallyEditedChanged(Message message, boolean z, boolean z2);

    void updateMessageParameter(Map<String, ArrayList<MessageUpdateResult>> map);

    void updateMessagePoll(String str, long j, PollObject pollObject);

    void updateMessageReplyTo(Message message);

    void updateMessageRubinoPost(String str, long j, RubinoPostData rubinoPostData);

    void updateMessageRubinoStory(String str, long j, RubinoStoryData rubinoStoryData);

    void updateMessageSendState(Message message);

    void updateMessagesReactions(Map<Long, ArrayList<MessageReactionObject>> map);

    void updateMessagesSeenCount(Map<Long, Integer> map);
}
