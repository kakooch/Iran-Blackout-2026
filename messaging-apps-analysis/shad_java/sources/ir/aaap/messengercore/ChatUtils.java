package ir.aaap.messengercore;

import android.text.TextUtils;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.aaap.messengercore.CoreUtilities;
import ir.aaap.messengercore.db.DBHelper;
import ir.aaap.messengercore.exceptions.InputException;
import ir.aaap.messengercore.exceptions.UsernameException;
import ir.aaap.messengercore.model.AvatarFileInline;
import ir.aaap.messengercore.model.BotInfo;
import ir.aaap.messengercore.model.ChannelInfo;
import ir.aaap.messengercore.model.ChannelInfoFromServer;
import ir.aaap.messengercore.model.Chat;
import ir.aaap.messengercore.model.ChatAbsObject;
import ir.aaap.messengercore.model.ChatExtra;
import ir.aaap.messengercore.model.ChatFromServer;
import ir.aaap.messengercore.model.ChatInviteObject;
import ir.aaap.messengercore.model.ChatMessage;
import ir.aaap.messengercore.model.ChatNeedReloadResult;
import ir.aaap.messengercore.model.ChatParamUpdateTimeObject;
import ir.aaap.messengercore.model.ChatReactionSetting;
import ir.aaap.messengercore.model.ChatType;
import ir.aaap.messengercore.model.ChatUpdateObject;
import ir.aaap.messengercore.model.CheckChannelsWithUsernameResult;
import ir.aaap.messengercore.model.ContactsNeedsReloadResult;
import ir.aaap.messengercore.model.DialogFilterSuggested;
import ir.aaap.messengercore.model.FileInlineObject;
import ir.aaap.messengercore.model.FolderObject;
import ir.aaap.messengercore.model.GetGroupMessageReadParticipantsResult;
import ir.aaap.messengercore.model.GroupInfo;
import ir.aaap.messengercore.model.GroupInfoFromServer;
import ir.aaap.messengercore.model.InChatMember;
import ir.aaap.messengercore.model.InChatMemberFromServer;
import ir.aaap.messengercore.model.Link;
import ir.aaap.messengercore.model.LocationObject;
import ir.aaap.messengercore.model.Message;
import ir.aaap.messengercore.model.ObjectGuidType;
import ir.aaap.messengercore.model.ObjectInfo;
import ir.aaap.messengercore.model.PhoneBookObject;
import ir.aaap.messengercore.model.SendChatActivityInput;
import ir.aaap.messengercore.model.SendChatActivityOutput;
import ir.aaap.messengercore.model.ServiceInfo;
import ir.aaap.messengercore.model.ServiceInfoFromServer;
import ir.aaap.messengercore.model.ShowActivityObject;
import ir.aaap.messengercore.model.SortedContactResult;
import ir.aaap.messengercore.model.UserInfo;
import ir.aaap.messengercore.model.UserInfoFromServer;
import ir.aaap.messengercore.model.api.ActionOnChatAdsInput;
import ir.aaap.messengercore.model.api.ActionOnChatAdsOutput;
import ir.aaap.messengercore.model.api.AddAddressBookInput;
import ir.aaap.messengercore.model.api.AddAddressBookOutput;
import ir.aaap.messengercore.model.api.AddChannelInput;
import ir.aaap.messengercore.model.api.AddChannelMembersInput;
import ir.aaap.messengercore.model.api.AddChannelMembersOutput;
import ir.aaap.messengercore.model.api.AddGroupInput;
import ir.aaap.messengercore.model.api.AddGroupMembersInput;
import ir.aaap.messengercore.model.api.AddGroupMembersOutput;
import ir.aaap.messengercore.model.api.AddOrEditChannelOutput;
import ir.aaap.messengercore.model.api.AddOrEditFolderInput;
import ir.aaap.messengercore.model.api.AddOrEditGroupOutput;
import ir.aaap.messengercore.model.api.BanChannelMemberInput;
import ir.aaap.messengercore.model.api.BanChannelMemberOutput;
import ir.aaap.messengercore.model.api.BanGroupMemberInput;
import ir.aaap.messengercore.model.api.BanGroupMemberOutput;
import ir.aaap.messengercore.model.api.BotInfoFromServer;
import ir.aaap.messengercore.model.api.BotModels;
import ir.aaap.messengercore.model.api.ChangeFolderOutput;
import ir.aaap.messengercore.model.api.ChangeOwnerModels;
import ir.aaap.messengercore.model.api.ChannelPreviewByJoinLinkInput;
import ir.aaap.messengercore.model.api.ChannelPreviewByJoinLinkOutput;
import ir.aaap.messengercore.model.api.ChatAdsObject;
import ir.aaap.messengercore.model.api.CheckChannelsWithUsernameInput;
import ir.aaap.messengercore.model.api.CheckChannelsWithUsernameOutput;
import ir.aaap.messengercore.model.api.CheckUsernameInput;
import ir.aaap.messengercore.model.api.CheckUsernameOutput;
import ir.aaap.messengercore.model.api.DeleteAvatarInput;
import ir.aaap.messengercore.model.api.DeleteChatHistoryInput;
import ir.aaap.messengercore.model.api.DeleteChatOutput;
import ir.aaap.messengercore.model.api.DeleteContactInput;
import ir.aaap.messengercore.model.api.DeleteContactOutput;
import ir.aaap.messengercore.model.api.DeleteFolderInput;
import ir.aaap.messengercore.model.api.DeleteServiceChatInput;
import ir.aaap.messengercore.model.api.DeleteUserChatInput;
import ir.aaap.messengercore.model.api.EditChannelInput;
import ir.aaap.messengercore.model.api.EditGroupInfoInput;
import ir.aaap.messengercore.model.api.GetAbsObjectsInput;
import ir.aaap.messengercore.model.api.GetAbsObjectsOutput;
import ir.aaap.messengercore.model.api.GetAllStatisticsInput;
import ir.aaap.messengercore.model.api.GetAllStatisticsOutput;
import ir.aaap.messengercore.model.api.GetAvatarsInput;
import ir.aaap.messengercore.model.api.GetAvatarsOutput;
import ir.aaap.messengercore.model.api.GetBlockedUsersInput;
import ir.aaap.messengercore.model.api.GetBlockedUsersOutput;
import ir.aaap.messengercore.model.api.GetBotInfoInput;
import ir.aaap.messengercore.model.api.GetBotInfoOutput;
import ir.aaap.messengercore.model.api.GetChannelAdminAccessInput;
import ir.aaap.messengercore.model.api.GetChannelAdminAccessListOutput;
import ir.aaap.messengercore.model.api.GetChannelInfoInput;
import ir.aaap.messengercore.model.api.GetChannelInfoOutput;
import ir.aaap.messengercore.model.api.GetChannelLinkInput;
import ir.aaap.messengercore.model.api.GetChannelLinkOutput;
import ir.aaap.messengercore.model.api.GetChannelMembersInput;
import ir.aaap.messengercore.model.api.GetChannelMembersOutput;
import ir.aaap.messengercore.model.api.GetChatAdsInput;
import ir.aaap.messengercore.model.api.GetChatAdsOutput;
import ir.aaap.messengercore.model.api.GetChatByIDOutput;
import ir.aaap.messengercore.model.api.GetChatsByIDInput;
import ir.aaap.messengercore.model.api.GetChatsInput;
import ir.aaap.messengercore.model.api.GetChatsOutput;
import ir.aaap.messengercore.model.api.GetChatsUpdatesInput;
import ir.aaap.messengercore.model.api.GetChatsUpdatesOutput;
import ir.aaap.messengercore.model.api.GetCommonGroupsInput;
import ir.aaap.messengercore.model.api.GetCommonGroupsOutput;
import ir.aaap.messengercore.model.api.GetContactInput;
import ir.aaap.messengercore.model.api.GetContactOutput;
import ir.aaap.messengercore.model.api.GetContactUpdateInput;
import ir.aaap.messengercore.model.api.GetContactUpdateOutput;
import ir.aaap.messengercore.model.api.GetContactsLastOnlineInput;
import ir.aaap.messengercore.model.api.GetContactsLastOnlineOutput;
import ir.aaap.messengercore.model.api.GetFoldersInput;
import ir.aaap.messengercore.model.api.GetFoldersOutput;
import ir.aaap.messengercore.model.api.GetGroupAdminAccessListInput;
import ir.aaap.messengercore.model.api.GetGroupAdminAccessListOutput;
import ir.aaap.messengercore.model.api.GetGroupDefaultAccessInput;
import ir.aaap.messengercore.model.api.GetGroupDefaultAccessOutput;
import ir.aaap.messengercore.model.api.GetGroupInfoInput;
import ir.aaap.messengercore.model.api.GetGroupInfoOutput;
import ir.aaap.messengercore.model.api.GetGroupLinkInput;
import ir.aaap.messengercore.model.api.GetGroupLinkOutput;
import ir.aaap.messengercore.model.api.GetGroupMembersInput;
import ir.aaap.messengercore.model.api.GetGroupMembersOutput;
import ir.aaap.messengercore.model.api.GetGroupMentionListInput;
import ir.aaap.messengercore.model.api.GetGroupMessageReadParticipantsInput;
import ir.aaap.messengercore.model.api.GetGroupMessageReadParticipantsOutput;
import ir.aaap.messengercore.model.api.GetGroupOnlineCountInput;
import ir.aaap.messengercore.model.api.GetGroupOnlineCountOutput;
import ir.aaap.messengercore.model.api.GetObjectByUsernameInput;
import ir.aaap.messengercore.model.api.GetObjectByUsernameOutput;
import ir.aaap.messengercore.model.api.GetProfileLinkItemsInput;
import ir.aaap.messengercore.model.api.GetProfileLinkItemsOutputs;
import ir.aaap.messengercore.model.api.GetServiceInfoInput;
import ir.aaap.messengercore.model.api.GetServiceInfoOutput;
import ir.aaap.messengercore.model.api.GetSuggestedFoldersInput;
import ir.aaap.messengercore.model.api.GetSuggestedFoldersOutput;
import ir.aaap.messengercore.model.api.GetTopChatUsersInput;
import ir.aaap.messengercore.model.api.GetTopChatUsersOutput;
import ir.aaap.messengercore.model.api.GetUserInfoInput;
import ir.aaap.messengercore.model.api.GetUserInfoOutput;
import ir.aaap.messengercore.model.api.GroupPreviewByJoinLinkInput;
import ir.aaap.messengercore.model.api.GroupPreviewByJoinLinkOutput;
import ir.aaap.messengercore.model.api.ImportAddressBookInput;
import ir.aaap.messengercore.model.api.ImportAddressBookOutput;
import ir.aaap.messengercore.model.api.InSearchObject;
import ir.aaap.messengercore.model.api.JoinChannelActionInput;
import ir.aaap.messengercore.model.api.JoinChannelActionOutput;
import ir.aaap.messengercore.model.api.JoinChannelByLinkInput;
import ir.aaap.messengercore.model.api.JoinChannelByLinkOutput;
import ir.aaap.messengercore.model.api.JoinGroupInput;
import ir.aaap.messengercore.model.api.JoinGroupOutput;
import ir.aaap.messengercore.model.api.LeaveGroupInput;
import ir.aaap.messengercore.model.api.LeaveGroupOutput;
import ir.aaap.messengercore.model.api.RemoveChannelInput;
import ir.aaap.messengercore.model.api.RemoveFromTopChatUsersInput;
import ir.aaap.messengercore.model.api.RemoveFromTopChatUsersOutput;
import ir.aaap.messengercore.model.api.RemoveGroupInput;
import ir.aaap.messengercore.model.api.RemoveGroupOrChannelOutput;
import ir.aaap.messengercore.model.api.ReorderFolderInput;
import ir.aaap.messengercore.model.api.ResetContactsInput;
import ir.aaap.messengercore.model.api.ResetContactsOutput;
import ir.aaap.messengercore.model.api.SearchGlobalObjectsInput;
import ir.aaap.messengercore.model.api.SearchGlobalObjectsOutput;
import ir.aaap.messengercore.model.api.SeenChatsInput;
import ir.aaap.messengercore.model.api.SeenChatsOutput;
import ir.aaap.messengercore.model.api.SetAskSpamActionInput;
import ir.aaap.messengercore.model.api.SetAskSpamActionOutput;
import ir.aaap.messengercore.model.api.SetBlockUserInput;
import ir.aaap.messengercore.model.api.SetBlockUserOutput;
import ir.aaap.messengercore.model.api.SetChannelAdminInput;
import ir.aaap.messengercore.model.api.SetChannelAdminOutput;
import ir.aaap.messengercore.model.api.SetChannelBotAdminInput;
import ir.aaap.messengercore.model.api.SetChannelBotAdminOutput;
import ir.aaap.messengercore.model.api.SetChannelLinkInput;
import ir.aaap.messengercore.model.api.SetChannelLinkOutput;
import ir.aaap.messengercore.model.api.SetChatActionInput;
import ir.aaap.messengercore.model.api.SetChatActionOutput;
import ir.aaap.messengercore.model.api.SetGroupAdminInput;
import ir.aaap.messengercore.model.api.SetGroupAdminOutput;
import ir.aaap.messengercore.model.api.SetGroupDefaultAccessInput;
import ir.aaap.messengercore.model.api.SetGroupDefaultAccessOutput;
import ir.aaap.messengercore.model.api.SetGroupLinkInput;
import ir.aaap.messengercore.model.api.SetGroupLinkOutput;
import ir.aaap.messengercore.model.api.SetPinChatInFolderInput;
import ir.aaap.messengercore.model.api.UpdateChannelUsernameInput;
import ir.aaap.messengercore.model.api.UpdateChannelUsernameOutput;
import ir.aaap.messengercore.model.api.UpdateProfileInput;
import ir.aaap.messengercore.model.api.UpdateProfileOutput;
import ir.aaap.messengercore.model.api.UpdateUserUsernameOutput;
import ir.aaap.messengercore.model.api.UpdateUsernameInput;
import ir.aaap.messengercore.model.api.UploadAvatarInput;
import ir.aaap.messengercore.model.api.UploadOrDeleteAvatarOutput;
import ir.aaap.messengercore.network.ApiServerException;
import ir.aaap.messengercore.network.NetworkHelper;
import ir.aaap.messengercore.network.RetryObject;
import ir.aaap.messengercore.usecase.GetMyUserGuidUsecase;
import ir.aaap.messengercore.usecase.LinkUsecase;
import ir.aaap.messengercore.usecase.UpdateBotInfoUsecase;
import ir.aaap.messengercore.usecase.UpdateChatAndMessageUsecase;
import ir.aaap.messengercore.usecase.UpdateChatUsecase;
import ir.aaap.messengercore.usecase.UpdateGroupVoiceChatUsecase;
import ir.aaap.messengercore.utilites.CoreLog;
import ir.aaap.messengercore.utilites.Objects;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class ChatUtils {
    private boolean chatListHasContinue;
    private boolean contactIsStarted;
    private CoreLog coreLog;
    private boolean getChatListInitHasError;
    private boolean getChatLoadMoreHasError;
    private Runnable getChatUpdateRunnable;
    private GetMyUserGuidUsecase getMyUserGuidUsecase;
    private boolean isChatAdsLoading;
    private boolean isChatInitInProgress;
    public boolean isChatInited;
    private boolean isChatListLoadedFromDb;
    private boolean isChatLoadMoreInProgress;
    private boolean isChatUpdateInProgress;
    private boolean isContactInited;
    private boolean isContactLoadedFromDb;
    private boolean isContactUpdateInProgress;
    private boolean isLoadingFoldersInProgress;
    private boolean isLoadingSuggestedFolders;
    private boolean isMyInfoLoading;
    private boolean isStartChatList;
    private int lastGetChatAdsRequestId;
    private int lastGetChatListRequestId;
    private int lastSearchObjectReqID;
    private long lastUpdatedRecentChatOnline;
    HashMap<String, String> sectionsToReplace;
    private SortedContactResult sortedContactResult;
    private Set<String> requestingGetChatIds = new HashSet();
    public Map<String, Chat> chatMap = new HashMap();
    private Map<String, Integer> chatToggleMuteRequestingIdMap = new HashMap();
    private Map<String, Integer> joinOrLeaveRequestingIdMap = new HashMap();
    private Map<String, Integer> chatTogglePinRequestingIdMap = new HashMap();
    private Map<String, ChatAbsObject> absMap = new HashMap();
    private Map<String, ObjectInfo> objectInfoByIdMap = new HashMap();
    private Map<String, ObjectInfo> objectInfoByUsernameMap = new HashMap();
    private Map<String, InSearchObject> inSearchObjectMap = new HashMap();
    public Set<String> contactSet = new HashSet();
    private Map<String, InChatMember> inChatMemberMap = new HashMap();
    private Set<String> infoStartedSet = new HashSet();
    private Set<String> infoLoadingSet = new HashSet();
    private Set<String> infoByUsernameLoadingSet = new HashSet();
    private Set<String> avatarsLoadingSet = new HashSet();
    private Map<String, Runnable> infoRunnableMap = new HashMap();
    private Map<String, Runnable> onlineCountRunnableMap = new HashMap();
    private Map<String, Runnable> seenChatRunnableMap = new HashMap();
    private Map<String, Integer> infoRequestIdMap = new HashMap();
    private Map<String, Long> infoUpdatedTimeMap = new HashMap();
    private HashMap<String, FolderObject> dialogFiltersMap = new HashMap<>();
    private ConcurrentHashMap<String, Integer> foldersUnreadCountMap = new ConcurrentHashMap<>();
    private ArrayList<FolderObject> dialogFilters = new ArrayList<>();
    private HashMap<String, DialogFilterSuggested> suggestedFiltersMap = new HashMap<>();
    private ArrayList<DialogFilterSuggested> suggestedFilters = new ArrayList<>();
    private ArrayList<Chat> chatList = new ArrayList<>();
    private String chatsNextStartId = BuildConfig.FLAVOR;
    private final Object chatsLock = new Object();
    private final Object infoLock = new Object();
    private final Object searchLock = new Object();
    private final Object infoByUsernameLock = new Object();
    private final Object memberLock = new Object();
    private final Object absLock = new Object();
    private final Object contactLock = new Object();
    private final Object foldersLock = new Object();
    private final Object foldersCountUnreadLock = new Object();
    private final Object suggestedFoldersLock = new Object();
    private Set<String> viewedChatAds = new HashSet();
    private Set<String> dontShowAds = new HashSet();
    private final Object onlineCountLock = new Object();
    private HashMap<String, Integer> groupOnlineCountsMap = new HashMap<>();
    Comparator<Chat> chatComparator = new Comparator<Chat>() { // from class: ir.aaap.messengercore.ChatUtils.108
        @Override // java.util.Comparator
        public int compare(Chat chat, Chat chat2) {
            boolean z = chat.is_pinned;
            if (z != chat2.is_pinned) {
                return z ? -1 : 1;
            }
            if (chat.timeString == null || chat2.timeString == null) {
                ChatUtils.this.coreLog.e("error", "o1 is null");
            }
            return chat2.timeString.compareTo(chat.timeString);
        }
    };

    interface GetChatsListener {
        void onError(Exception exc);

        void onResponse(GetChatsResult getChatsResult);
    }

    public static class GetChatsResult {
        public ArrayList<ChatAbsObject> absObjects;
        public ArrayList<Chat> chats;
        public ArrayList<ChatExtra> extras;
        boolean fromDb;
        long timeStamp;
    }

    public void processShowActivities(ArrayList<ShowActivityObject> arrayList, AbsNotificationCenter absNotificationCenter) {
        if (arrayList == null || arrayList.isEmpty() || absNotificationCenter == null) {
            return;
        }
        absNotificationCenter.onUpdateShowActivities(arrayList);
    }

    public void removeRecentChat(String str, DBHelper dBHelper) {
        if (str == null || str.isEmpty()) {
            return;
        }
        dBHelper.removeRecentChat(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int updateProfile(java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, ir.aaap.messengercore.network.NetworkHelper r17, final ir.aaap.messengercore.db.DBHelper r18, final ir.aaap.messengercore.KeyValueStorageHelper r19, final ir.aaap.messengercore.AbsNotificationCenter r20, final ir.aaap.messengercore.LoadListener<java.lang.Integer> r21) {
        /*
            r12 = this;
            r7 = r12
            r8 = r21
            ir.aaap.messengercore.model.api.UpdateProfileInput r0 = new ir.aaap.messengercore.model.api.UpdateProfileInput
            r0.<init>()
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            r5 = r19
            ir.aaap.messengercore.model.UserInfo r2 = r12.getMyUserInfo(r5)
            r3 = 0
            if (r2 == 0) goto L1f
            java.lang.String r4 = r2.user_guid
            r6 = r18
            ir.aaap.messengercore.model.ChatAbsObject r4 = r12.getChatAbsInstant(r4, r6)
            goto L22
        L1f:
            r6 = r18
            r4 = r3
        L22:
            if (r4 == 0) goto L2e
            java.lang.String r9 = r4.first_name
            r10 = r13
            boolean r9 = ir.aaap.messengercore.utilites.Objects.equals(r9, r13)
            if (r9 != 0) goto L3e
            goto L2f
        L2e:
            r10 = r13
        L2f:
            java.lang.String r9 = "first_name"
            r1.add(r9)
            boolean r9 = android.text.TextUtils.isEmpty(r13)
            if (r9 != 0) goto L3b
            goto L3c
        L3b:
            r10 = r3
        L3c:
            r0.first_name = r10
        L3e:
            if (r4 == 0) goto L4a
            java.lang.String r4 = r4.last_name
            r9 = r14
            boolean r4 = ir.aaap.messengercore.utilites.Objects.equals(r4, r14)
            if (r4 != 0) goto L5a
            goto L4b
        L4a:
            r9 = r14
        L4b:
            java.lang.String r4 = "last_name"
            r1.add(r4)
            boolean r4 = android.text.TextUtils.isEmpty(r14)
            if (r4 != 0) goto L57
            goto L58
        L57:
            r9 = r3
        L58:
            r0.last_name = r9
        L5a:
            if (r2 == 0) goto L66
            java.lang.String r2 = r2.bio
            r4 = r15
            boolean r2 = ir.aaap.messengercore.utilites.Objects.equals(r2, r15)
            if (r2 != 0) goto L75
            goto L67
        L66:
            r4 = r15
        L67:
            java.lang.String r2 = "bio"
            r1.add(r2)
            boolean r2 = android.text.TextUtils.isEmpty(r15)
            if (r2 != 0) goto L73
            r3 = r4
        L73:
            r0.bio = r3
        L75:
            boolean r2 = r1.isEmpty()
            r9 = -1
            if (r2 == 0) goto L85
            ir.aaap.messengercore.exceptions.InputException r0 = new ir.aaap.messengercore.exceptions.InputException
            r0.<init>()
            r8.onError(r0)
            return r9
        L85:
            r0.updated_parameters = r1
            ir.aaap.messengercore.network.RetryObject r10 = ir.aaap.messengercore.network.RetryObject.getDefaultRetry()     // Catch: java.lang.Exception -> La3
            ir.aaap.messengercore.ChatUtils$1 r11 = new ir.aaap.messengercore.ChatUtils$1     // Catch: java.lang.Exception -> La3
            r1 = r11
            r2 = r12
            r3 = r18
            r4 = r20
            r5 = r19
            r6 = r21
            r1.<init>()     // Catch: java.lang.Exception -> La3
            r1 = r16
            r2 = r17
            int r0 = r2.updateProfile(r1, r0, r10, r11)     // Catch: java.lang.Exception -> La3
            return r0
        La3:
            r0 = move-exception
            r8.onError(r0)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.aaap.messengercore.ChatUtils.updateProfile(java.lang.String, java.lang.String, java.lang.String, java.lang.String, ir.aaap.messengercore.network.NetworkHelper, ir.aaap.messengercore.db.DBHelper, ir.aaap.messengercore.KeyValueStorageHelper, ir.aaap.messengercore.AbsNotificationCenter, ir.aaap.messengercore.LoadListener):int");
    }

    public int updateUserLocation(LocationObject locationObject, String str, NetworkHelper networkHelper, final DBHelper dBHelper, final AbsNotificationCenter absNotificationCenter, final KeyValueStorageHelper keyValueStorageHelper, final LoadListener<Integer> loadListener) {
        if (locationObject == null || System.currentTimeMillis() - keyValueStorageHelper.getLastUpdatedLocation() < 200000000) {
            return -1;
        }
        HashSet hashSet = new HashSet();
        hashSet.add("location");
        UpdateProfileInput updateProfileInput = new UpdateProfileInput();
        updateProfileInput.location = locationObject;
        updateProfileInput.updated_parameters = hashSet;
        try {
            return networkHelper.updateProfile(str, updateProfileInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<UpdateProfileOutput>() { // from class: ir.aaap.messengercore.ChatUtils.2
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(UpdateProfileOutput updateProfileOutput) {
                    if (updateProfileOutput != null) {
                        ChatUtils.this.processUserInfoDidLoad(updateProfileOutput.user, null, 0L, true, true, true, updateProfileOutput.timestamp, dBHelper, true, absNotificationCenter);
                        ChatUtils.this.processChatsUpdate(updateProfileOutput.chat_update, (UpdateChatUsecase) null, absNotificationCenter, dBHelper);
                    }
                    keyValueStorageHelper.setLastUpdatedLocation(System.currentTimeMillis());
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(1);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            return -1;
        }
    }

    public void saveHiddenWarningId(String str, String str2, KeyValueStorageHelper keyValueStorageHelper) {
        keyValueStorageHelper.saveHiddenWarningId(str, str2);
    }

    public String getHiddenWarningId(String str, KeyValueStorageHelper keyValueStorageHelper) {
        return keyValueStorageHelper.getHiddenWarningId(str);
    }

    public ChatUtils(CoreLog coreLog, GetMyUserGuidUsecase getMyUserGuidUsecase) {
        this.coreLog = coreLog;
        this.getMyUserGuidUsecase = getMyUserGuidUsecase;
        HashMap<String, String> map = new HashMap<>();
        this.sectionsToReplace = map;
        map.put("À", "A");
        this.sectionsToReplace.put("Á", "A");
        this.sectionsToReplace.put("Ä", "A");
        this.sectionsToReplace.put("Ù", "U");
        this.sectionsToReplace.put("Ú", "U");
        this.sectionsToReplace.put("Ü", "U");
        this.sectionsToReplace.put("Ì", "I");
        this.sectionsToReplace.put("Í", "I");
        this.sectionsToReplace.put("Ï", "I");
        this.sectionsToReplace.put("È", "E");
        this.sectionsToReplace.put("É", "E");
        this.sectionsToReplace.put("Ê", "E");
        this.sectionsToReplace.put("Ë", "E");
        this.sectionsToReplace.put("Ò", "O");
        this.sectionsToReplace.put("Ó", "O");
        this.sectionsToReplace.put("Ö", "O");
        this.sectionsToReplace.put("Ç", "C");
        this.sectionsToReplace.put("Ñ", "N");
        this.sectionsToReplace.put("Ÿ", "Y");
        this.sectionsToReplace.put("Ý", "Y");
        this.sectionsToReplace.put("Ţ", "Y");
    }

    public void addRecentChat(String str, DBHelper dBHelper) {
        InSearchObject inSearchObject = this.inSearchObjectMap.get(str);
        if (inSearchObject != null) {
            dBHelper.addOrUpdateRecentChat(inSearchObject, System.currentTimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addToSearchMap(ArrayList<InSearchObject> arrayList) {
        synchronized (this.searchLock) {
            Iterator<InSearchObject> it = arrayList.iterator();
            while (it.hasNext()) {
                InSearchObject next = it.next();
                this.inSearchObjectMap.put(next.object_guid, next);
            }
        }
    }

    public void removeAllRecentChat(DBHelper dBHelper) {
        dBHelper.removeAllRecentChat();
    }

    public void getAllRecentChatGuid(boolean z, String str, NetworkHelper networkHelper, DBHelper dBHelper, AbsNotificationCenter absNotificationCenter, LoadListener<ArrayList<InSearchObject>> loadListener) {
        ArrayList<InSearchObject> allRecentChat = dBHelper.getAllRecentChat();
        ArrayList<InSearchObject> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        if (allRecentChat != null && allRecentChat.size() > 0) {
            Iterator<InSearchObject> it = allRecentChat.iterator();
            while (it.hasNext()) {
                InSearchObject next = it.next();
                if (next.type == ChatType.User) {
                    arrayList2.add(next.object_guid);
                    ChatAbsObject absObject = dBHelper.getAbsObject(next.object_guid);
                    UserInfo userInfo = dBHelper.getUserInfo(next.object_guid);
                    if (absObject != null && userInfo != null) {
                        arrayList.add(InSearchObject.createFromUserInfoAndAbs(userInfo, absObject));
                    } else {
                        arrayList.add(next);
                    }
                } else {
                    arrayList.add(next);
                }
            }
            addToSearchMap(arrayList);
            if (z && arrayList2.size() > 0 && System.currentTimeMillis() - this.lastUpdatedRecentChatOnline > CoreMainClassImpl.RECENT_CHATS_UPDATE_LAST_ONLINE_DURATION) {
                updateLastOnline(arrayList2, str, networkHelper, dBHelper, absNotificationCenter);
            }
        }
        if (loadListener != null) {
            loadListener.onDidLoad(arrayList);
        }
    }

    private void updateLastOnline(ArrayList<String> arrayList, String str, NetworkHelper networkHelper, DBHelper dBHelper, final AbsNotificationCenter absNotificationCenter) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        new GetLastOnlineHelper(str, networkHelper, dBHelper, new LoadListener<Integer>() { // from class: ir.aaap.messengercore.ChatUtils.4
            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(Integer num) {
                ChatUtils.this.lastUpdatedRecentChatOnline = System.currentTimeMillis();
                AbsNotificationCenter absNotificationCenter2 = absNotificationCenter;
                if (absNotificationCenter2 != null) {
                    absNotificationCenter2.lastOnlineUpdated();
                }
            }
        }).getLastOnline(arrayList);
    }

    public void getAllChatHints(boolean z, String str, NetworkHelper networkHelper, DBHelper dBHelper, KeyValueStorageHelper keyValueStorageHelper, AbsNotificationCenter absNotificationCenter, LoadListener<ArrayList<ChatAbsObject>> loadListener) {
        boolean z2 = System.currentTimeMillis() - keyValueStorageHelper.getChatHintsTime() > ((long) CoreMainClassImpl.CHAT_HINTS_UPDATE_DURATION);
        ArrayList<ChatAbsObject> allChatHints = keyValueStorageHelper.getAllChatHints();
        if (allChatHints != null && !allChatHints.isEmpty() && loadListener != null) {
            ArrayList<ChatAbsObject> arrayList = new ArrayList<>();
            Iterator<ChatAbsObject> it = allChatHints.iterator();
            while (it.hasNext()) {
                ChatAbsObject next = it.next();
                ChatAbsObject absObjectFromDB = getAbsObjectFromDB(dBHelper, next.object_guid);
                if (absObjectFromDB != null && absObjectFromDB.timeStamp >= next.timeStamp) {
                    arrayList.add(absObjectFromDB);
                    addToAbsMap(absObjectFromDB, absObjectFromDB.timeStamp);
                } else {
                    arrayList.add(next);
                }
            }
            loadListener.onDidLoad(arrayList);
        }
        if (z || z2) {
            getAllChatHintsFromServer(str, networkHelper, dBHelper, keyValueStorageHelper, absNotificationCenter, loadListener);
        }
    }

    private void getAllChatHintsFromServer(String str, NetworkHelper networkHelper, final DBHelper dBHelper, final KeyValueStorageHelper keyValueStorageHelper, AbsNotificationCenter absNotificationCenter, final LoadListener<ArrayList<ChatAbsObject>> loadListener) {
        try {
            networkHelper.getTopChatUsers(str, new GetTopChatUsersInput(), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetTopChatUsersOutput>() { // from class: ir.aaap.messengercore.ChatUtils.5
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(GetTopChatUsersOutput getTopChatUsersOutput) {
                    ArrayList<ChatAbsObject> arrayList;
                    if (getTopChatUsersOutput != null && (arrayList = getTopChatUsersOutput.abs_users) != null) {
                        ChatUtils.this.addToAbsMap(arrayList, getTopChatUsersOutput.timestamp);
                        dBHelper.addAllAbsObject(getTopChatUsersOutput.abs_users, getTopChatUsersOutput.timestamp);
                        loadListener.onDidLoad(getTopChatUsersOutput.abs_users);
                        keyValueStorageHelper.setAllChatHints(getTopChatUsersOutput.abs_users, System.currentTimeMillis());
                        return;
                    }
                    loadListener.onDidLoad(new ArrayList());
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    loadListener.onError(exc);
                }
            });
        } catch (Exception e) {
            loadListener.onError(e);
        }
    }

    public void removeChatHint(final String str, String str2, NetworkHelper networkHelper, final KeyValueStorageHelper keyValueStorageHelper, final LoadListener<Integer> loadListener) {
        if (!CoreUtilities.isNotEmpty(str)) {
            if (loadListener != null) {
                loadListener.onError(new InputException());
                return;
            }
            return;
        }
        try {
            networkHelper.removeFromTopChatUsers(str2, new RemoveFromTopChatUsersInput(str), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<RemoveFromTopChatUsersOutput>(this) { // from class: ir.aaap.messengercore.ChatUtils.6
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(RemoveFromTopChatUsersOutput removeFromTopChatUsersOutput) {
                    ArrayList<ChatAbsObject> allChatHints;
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(1);
                    }
                    KeyValueStorageHelper keyValueStorageHelper2 = keyValueStorageHelper;
                    if (keyValueStorageHelper2 == null || (allChatHints = keyValueStorageHelper2.getAllChatHints()) == null || allChatHints.size() <= 0) {
                        return;
                    }
                    Iterator<ChatAbsObject> it = allChatHints.iterator();
                    while (it.hasNext()) {
                        ChatAbsObject next = it.next();
                        if (next.object_guid.equals(str)) {
                            allChatHints.remove(next);
                            KeyValueStorageHelper keyValueStorageHelper3 = keyValueStorageHelper;
                            keyValueStorageHelper3.setAllChatHints(allChatHints, keyValueStorageHelper3.getChatHintsTime());
                            return;
                        }
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
        }
    }

    public void loadChatsByGuidIfNeeded(final Set<String> set, String str, NetworkHelper networkHelper, DBHelper dBHelper, AbsNotificationCenter absNotificationCenter, final LoadListener<Set<String>> loadListener) {
        HashSet hashSet = new HashSet();
        for (String str2 : set) {
            if (this.chatMap.get(str2) == null || this.absMap.get(str2) == null) {
                hashSet.add(str2);
            }
        }
        if (hashSet.size() > 0) {
            getChatsByGuidsFromServer(hashSet, str, networkHelper, dBHelper, absNotificationCenter, new LoadListener<Integer>(this) { // from class: ir.aaap.messengercore.ChatUtils.7
                @Override // ir.aaap.messengercore.LoadListener
                public void onDidLoad(Integer num) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(set);
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
        } else if (loadListener != null) {
            loadListener.onDidLoad(set);
        }
    }

    public int sendChatActivity(String str, SendChatActivityInput.ActivityEnum activityEnum, String str2, NetworkHelper networkHelper, final LoadListener<Integer> loadListener) {
        if (activityEnum == null) {
            return 0;
        }
        SendChatActivityInput sendChatActivityInput = new SendChatActivityInput();
        sendChatActivityInput.activity = activityEnum;
        sendChatActivityInput.object_guid = str;
        try {
            return networkHelper.sendChatActivity(str2, sendChatActivityInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<SendChatActivityOutput>(this) { // from class: ir.aaap.messengercore.ChatUtils.8
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(SendChatActivityOutput sendChatActivityOutput) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(1);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            return 0;
        }
    }

    private void getChatsByGuidsFromServer(Set<String> set, String str, NetworkHelper networkHelper, DBHelper dBHelper, AbsNotificationCenter absNotificationCenter, final LoadListener<Integer> loadListener) {
        ArrayList arrayList = new ArrayList();
        for (String str2 : set) {
            if (!this.requestingGetChatIds.contains(str2)) {
                arrayList.add(str2);
            }
        }
        if (arrayList.size() == 0) {
            return;
        }
        this.requestingGetChatIds.addAll(arrayList);
        new GetChatsByIdHelper(str, networkHelper, dBHelper, absNotificationCenter, new LoadListener<Integer>() { // from class: ir.aaap.messengercore.ChatUtils.9
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(Integer num) {
                ChatUtils.this.requestingGetChatIds.clear();
                LoadListener loadListener2 = loadListener;
                if (loadListener2 != null) {
                    loadListener2.onDidLoad(1);
                }
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                ChatUtils.this.requestingGetChatIds.clear();
                LoadListener loadListener2 = loadListener;
                if (loadListener2 != null) {
                    loadListener2.onError(exc);
                }
            }
        }).getChatsById(arrayList);
    }

    public void initFolders(String str, NetworkHelper networkHelper, DBHelper dBHelper, KeyValueStorageHelper keyValueStorageHelper, AbsNotificationCenter absNotificationCenter) {
        boolean z;
        if (CoreUtilities.isNotEmpty(keyValueStorageHelper.getFoldersState())) {
            ArrayList<FolderObject> allFolders = dBHelper.getAllFolders();
            if (allFolders != null && allFolders.size() > 0) {
                onFolderListChanged(allFolders, true, absNotificationCenter, dBHelper);
            }
            z = false;
        } else {
            z = true;
        }
        getFoldersFromServerIfNeeded(z, str, networkHelper, dBHelper, keyValueStorageHelper, absNotificationCenter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFolderListChanged(ArrayList<FolderObject> arrayList, boolean z, AbsNotificationCenter absNotificationCenter, DBHelper dBHelper) {
        synchronized (this.foldersLock) {
            this.dialogFiltersMap.clear();
            Iterator<FolderObject> it = arrayList.iterator();
            while (it.hasNext()) {
                FolderObject next = it.next();
                next.createFlags();
                next.makeSetFromArrays();
                this.dialogFiltersMap.put(next.folder_id, next);
            }
        }
        createAndSortFolderList(z, absNotificationCenter);
        updateFoldersUnreadCount(absNotificationCenter, dBHelper);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSuggestedFolderListChanged(ArrayList<DialogFilterSuggested> arrayList) {
        synchronized (this.suggestedFoldersLock) {
            this.suggestedFiltersMap.clear();
            Iterator<DialogFilterSuggested> it = arrayList.iterator();
            while (it.hasNext()) {
                DialogFilterSuggested next = it.next();
                next.folder.createFlags();
                this.suggestedFiltersMap.put(next.suggestion_folder_id, next);
            }
            this.suggestedFilters = arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFolderUpdatedOrAdded(boolean z, FolderObject folderObject, DBHelper dBHelper, AbsNotificationCenter absNotificationCenter) {
        FolderObject folderObject2;
        folderObject.createFlags();
        folderObject.makeSetFromArrays();
        dBHelper.addFolder(folderObject);
        this.dialogFiltersMap.put(folderObject.folder_id, folderObject);
        if (z) {
            synchronized (this.foldersLock) {
                if (folderObject.order == 1 && this.dialogFiltersMap.size() > 1) {
                    for (String str : this.dialogFiltersMap.keySet()) {
                        if (!str.equals(folderObject.folder_id) && (folderObject2 = this.dialogFiltersMap.get(str)) != null) {
                            int i = folderObject2.order + 1;
                            folderObject2.order = i;
                            dBHelper.updateFolderOrder(folderObject2.folder_id, i);
                        }
                    }
                }
            }
            createAndSortFolderList(true, absNotificationCenter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFolderDeleted(String str, DBHelper dBHelper, AbsNotificationCenter absNotificationCenter) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        dBHelper.removeAllFolders(arrayList);
        this.dialogFiltersMap.remove(str);
        createAndSortFolderList(true, absNotificationCenter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFolderReordered(ArrayList<String> arrayList, DBHelper dBHelper, AbsNotificationCenter absNotificationCenter) {
        for (int i = 0; i < arrayList.size(); i++) {
            FolderObject folderObject = this.dialogFiltersMap.get(arrayList.get(i));
            if (folderObject != null) {
                folderObject.order = i;
                dBHelper.updateFolderOrder(folderObject.folder_id, i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processChangeFolderState(ChangeFolderOutput changeFolderOutput, String str, NetworkHelper networkHelper, DBHelper dBHelper, KeyValueStorageHelper keyValueStorageHelper, AbsNotificationCenter absNotificationCenter) {
        String foldersState = keyValueStorageHelper.getFoldersState();
        String str2 = changeFolderOutput.old_state;
        if (str2 != null && str2.equals(foldersState)) {
            keyValueStorageHelper.setFoldersStateAndUpdateTime(changeFolderOutput.new_state, System.currentTimeMillis());
        } else {
            getFoldersFromServerIfNeeded(true, str, networkHelper, dBHelper, keyValueStorageHelper, absNotificationCenter);
        }
    }

    public int getFolderCountUnread(String str) {
        Integer num = this.foldersUnreadCountMap.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getAllCountUnread(DBHelper dBHelper) {
        int iMin;
        Integer num = this.foldersUnreadCountMap.get(BuildConfig.FLAVOR);
        if (num != null) {
            return num.intValue();
        }
        ArrayList<Chat> allChats = dBHelper.getAllChats();
        ArrayList<String> arrayList = new ArrayList<>();
        if (allChats == null) {
            allChats = new ArrayList<>();
        }
        Iterator<Chat> it = allChats.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().object_guid);
        }
        ArrayList<ChatExtra> allChatExtra = dBHelper.getAllChatExtra(arrayList);
        HashMap map = new HashMap();
        if (allChatExtra != null) {
            Iterator<ChatExtra> it2 = allChatExtra.iterator();
            while (it2.hasNext()) {
                ChatExtra next = it2.next();
                map.put(next.object_guid, next);
            }
        }
        int i = 0;
        Iterator<Chat> it3 = allChats.iterator();
        while (it3.hasNext()) {
            Chat next2 = it3.next();
            ChatExtra chatExtra = (ChatExtra) map.get(next2.object_guid);
            next2.chatExtra = chatExtra;
            if (chatExtra == null || chatExtra.local_last_seen_my_mid <= next2.last_seen_my_mid) {
                iMin = next2.count_unseen;
            } else {
                iMin = Math.min(next2.count_unseen, chatExtra.local_count_unseen);
            }
            if (!next2.is_mute && iMin > 0) {
                i += iMin;
            }
        }
        synchronized (this.foldersCountUnreadLock) {
            this.foldersUnreadCountMap.put(BuildConfig.FLAVOR, Integer.valueOf(i));
        }
        return i;
    }

    private void updateFoldersUnreadCount(AbsNotificationCenter absNotificationCenter, DBHelper dBHelper) {
        int iMin;
        if (this.isChatInited) {
            HashMap map = new HashMap();
            Iterator<Chat> it = this.chatList.iterator();
            int i = 0;
            while (it.hasNext()) {
                Chat next = it.next();
                ChatExtra chatExtra = next.chatExtra;
                if (chatExtra == null || chatExtra.local_last_seen_my_mid <= next.last_seen_my_mid) {
                    iMin = next.count_unseen;
                } else {
                    iMin = Math.min(next.count_unseen, chatExtra.local_count_unseen);
                }
                if (!next.is_mute && iMin > 0) {
                    i += iMin;
                    Iterator<FolderObject> it2 = this.dialogFilters.iterator();
                    while (it2.hasNext()) {
                        FolderObject next2 = it2.next();
                        if (isFolderIncludesChat(next2, next, getChatAbsInstant(next.object_guid, dBHelper))) {
                            Integer num = (Integer) map.get(next2.folder_id);
                            if (num == null) {
                                num = 0;
                            }
                            map.put(next2.folder_id, Integer.valueOf(num.intValue() + iMin));
                        }
                    }
                }
            }
            map.put(BuildConfig.FLAVOR, Integer.valueOf(i));
            synchronized (this.foldersCountUnreadLock) {
                this.foldersUnreadCountMap.clear();
                this.foldersUnreadCountMap.putAll(map);
            }
            absNotificationCenter.dialogsUnreadCounterChanged();
        }
    }

    private boolean isFolderIncludesChat(FolderObject folderObject, Chat chat, ChatAbsObject chatAbsObject) {
        GetMyUserGuidUsecase getMyUserGuidUsecase;
        if (chatAbsObject == null || chat == null || folderObject == null) {
            return false;
        }
        String str = chat.object_guid;
        ChatType chatType = chatAbsObject.type;
        ObjectGuidType objectGuidType = new ObjectGuidType(str, chatType);
        if (folderObject.include_objects.contains(objectGuidType)) {
            return true;
        }
        if (folderObject.exclude_objects.contains(objectGuidType)) {
            return false;
        }
        int i = folderObject.flags;
        if (((FolderObject.DIALOG_FILTER_FLAG_EXCLUDE_MUTED & i) == 0 || !chat.is_mute) && ((FolderObject.DIALOG_FILTER_FLAG_EXCLUDE_READ & i) == 0 || chat.count_unseen != 0)) {
            return chatType == ChatType.User ? (isContact(str) || ((getMyUserGuidUsecase = this.getMyUserGuidUsecase) != null && str.equals(getMyUserGuidUsecase.getMyGuid()))) ? (folderObject.flags & FolderObject.DIALOG_FILTER_FLAG_CONTACTS) != 0 : (folderObject.flags & FolderObject.DIALOG_FILTER_FLAG_NON_CONTACTS) != 0 : chatType == ChatType.Bot ? (FolderObject.DIALOG_FILTER_FLAG_BOTS & i) != 0 : chatType == ChatType.Channel ? (FolderObject.DIALOG_FILTER_FLAG_CHANNELS & i) != 0 : chatType == ChatType.Group ? (FolderObject.DIALOG_FILTER_FLAG_GROUPS & i) != 0 : chatType == ChatType.Service && (FolderObject.DIALOG_FILTER_FLAG_EXCLUDE_READ & i) != 0;
        }
        return false;
    }

    public void getFoldersFromServerIfNeeded(boolean z, final String str, final NetworkHelper networkHelper, final DBHelper dBHelper, final KeyValueStorageHelper keyValueStorageHelper, final AbsNotificationCenter absNotificationCenter) {
        if (this.isLoadingFoldersInProgress) {
            return;
        }
        if (z || System.currentTimeMillis() - keyValueStorageHelper.getLastSyncFoldersTime(0L) >= CoreMainClassImpl.getFolderUpdatePeriodMillis) {
            if (z) {
                keyValueStorageHelper.setLastSyncFoldersTime(0L);
            }
            this.isLoadingFoldersInProgress = true;
            GetFoldersInput getFoldersInput = new GetFoldersInput();
            String foldersState = keyValueStorageHelper.getFoldersState();
            getFoldersInput.last_state = foldersState;
            if (foldersState.isEmpty()) {
                getFoldersInput.last_state = null;
            }
            try {
                networkHelper.getFolders(str, getFoldersInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetFoldersOutput>() { // from class: ir.aaap.messengercore.ChatUtils.10
                    @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                    public void onResponse(GetFoldersOutput getFoldersOutput) {
                        ChatUtils.this.isLoadingFoldersInProgress = false;
                        keyValueStorageHelper.setLastSyncFoldersTime(System.currentTimeMillis());
                        if (getFoldersOutput == null || !getFoldersOutput.is_changed) {
                            return;
                        }
                        String str2 = getFoldersOutput.new_state;
                        if (str2 != null) {
                            keyValueStorageHelper.setFoldersStateAndUpdateTime(str2, System.currentTimeMillis());
                        }
                        if (getFoldersOutput.folders == null) {
                            getFoldersOutput.folders = new ArrayList<>();
                        }
                        Iterator<FolderObject> it = getFoldersOutput.folders.iterator();
                        while (it.hasNext()) {
                            FolderObject next = it.next();
                            if (next.include_chat_types == null) {
                                next.include_chat_types = new ArrayList<>();
                            }
                            if (next.exclude_chat_types == null) {
                                next.exclude_chat_types = new ArrayList<>();
                            }
                            if (next.include_objects == null) {
                                next.include_objects = new ArrayList<>();
                            }
                            if (next.exclude_objects == null) {
                                next.exclude_objects = new ArrayList<>();
                            }
                            if (next.pinned_objects == null) {
                                next.pinned_objects = new ArrayList<>();
                            }
                        }
                        ChatUtils.this.checkLoadedRemoteFilters(getFoldersOutput.folders, str, networkHelper, dBHelper, keyValueStorageHelper, absNotificationCenter);
                        dBHelper.removeAllFolders();
                        dBHelper.addAllFolders(getFoldersOutput.folders);
                        ChatUtils.this.onFolderListChanged(getFoldersOutput.folders, true, absNotificationCenter, dBHelper);
                    }

                    @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                    public void onError(Exception exc) {
                        ChatUtils.this.isLoadingFoldersInProgress = false;
                    }
                });
            } catch (Exception e) {
                this.isLoadingFoldersInProgress = false;
                this.coreLog.handleException(e);
            }
        }
    }

    public void checkLoadedRemoteFilters(ArrayList<FolderObject> arrayList, String str, NetworkHelper networkHelper, DBHelper dBHelper, KeyValueStorageHelper keyValueStorageHelper, AbsNotificationCenter absNotificationCenter) {
        HashMap map;
        ArrayList arrayList2;
        HashSet hashSet;
        HashMap map2;
        HashMap map3;
        HashMap map4;
        HashMap map5;
        ArrayList arrayList3;
        HashSet hashSet2;
        boolean z;
        boolean z2;
        boolean z3;
        HashMap map6;
        boolean z4;
        HashSet hashSet3;
        FolderObject folderObject;
        ArrayList arrayList4;
        HashMap map7;
        HashSet hashSet4;
        HashMap map8;
        try {
            HashMap map9 = new HashMap();
            int size = this.dialogFilters.size();
            for (int i = 0; i < size; i++) {
                FolderObject folderObject2 = this.dialogFilters.get(i);
                map9.put(folderObject2.folder_id, folderObject2);
            }
            HashMap map10 = new HashMap();
            ArrayList<String> arrayList5 = new ArrayList<>();
            HashMap map11 = new HashMap();
            ArrayList arrayList6 = new ArrayList();
            HashMap map12 = new HashMap();
            ArrayList arrayList7 = new ArrayList();
            HashMap map13 = new HashMap();
            ArrayList arrayList8 = new ArrayList();
            HashMap map14 = new HashMap();
            HashMap map15 = new HashMap();
            HashSet hashSet5 = new HashSet();
            int size2 = arrayList.size();
            int i2 = 0;
            while (i2 < size2) {
                FolderObject folderObject3 = arrayList.get(i2);
                int i3 = size2;
                int i4 = i2;
                map10.put(folderObject3.folder_id, Integer.valueOf(folderObject3.order));
                int i5 = folderObject3.include_chat_types.contains(FolderObject.EnumIncludeChatType.Contacts) ? FolderObject.DIALOG_FILTER_FLAG_CONTACTS | 0 : 0;
                HashMap map16 = map10;
                if (folderObject3.include_chat_types.contains(FolderObject.EnumIncludeChatType.NonConatcts)) {
                    i5 |= FolderObject.DIALOG_FILTER_FLAG_NON_CONTACTS;
                }
                if (folderObject3.include_chat_types.contains(FolderObject.EnumIncludeChatType.Groups)) {
                    i5 |= FolderObject.DIALOG_FILTER_FLAG_GROUPS;
                }
                if (folderObject3.include_chat_types.contains(FolderObject.EnumIncludeChatType.Channels)) {
                    i5 |= FolderObject.DIALOG_FILTER_FLAG_CHANNELS;
                }
                if (folderObject3.include_chat_types.contains(FolderObject.EnumIncludeChatType.Bots)) {
                    i5 |= FolderObject.DIALOG_FILTER_FLAG_BOTS;
                }
                if (folderObject3.exclude_chat_types.contains(FolderObject.EnumExcludeChatType.Mute)) {
                    i5 |= FolderObject.DIALOG_FILTER_FLAG_EXCLUDE_MUTED;
                }
                if (folderObject3.exclude_chat_types.contains(FolderObject.EnumExcludeChatType.Read)) {
                    i5 |= FolderObject.DIALOG_FILTER_FLAG_EXCLUDE_READ;
                }
                FolderObject folderObject4 = this.dialogFiltersMap.get(folderObject3.folder_id);
                if (folderObject4 != null) {
                    map9.remove(folderObject3.folder_id);
                    map = map9;
                    if (TextUtils.equals(folderObject4.name, folderObject3.name)) {
                        z = false;
                    } else {
                        folderObject4.name = folderObject3.name;
                        z = true;
                    }
                    if (folderObject4.flags != i5) {
                        folderObject4.flags = i5;
                        folderObject4.include_chat_types = folderObject3.include_chat_types;
                        folderObject4.exclude_chat_types = folderObject3.exclude_chat_types;
                        z = true;
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    boolean z5 = z;
                    HashSet hashSet6 = new HashSet(folderObject4.include_objects);
                    hashSet6.addAll(folderObject4.exclude_objects);
                    HashSet hashSet7 = new HashSet();
                    boolean z6 = z2;
                    int size3 = folderObject4.pinned_objects.size();
                    ArrayList arrayList9 = arrayList6;
                    int i6 = 0;
                    while (i6 < size3) {
                        int i7 = size3;
                        ObjectGuidType objectGuidType = folderObject4.pinned_objects.get(i6);
                        hashSet7.add(objectGuidType);
                        hashSet6.remove(objectGuidType);
                        i6++;
                        size3 = i7;
                    }
                    int i8 = 0;
                    while (i8 < 2) {
                        ArrayList<ObjectGuidType> arrayList10 = i8 == 0 ? folderObject3.include_objects : folderObject3.exclude_objects;
                        HashMap map17 = map12;
                        ArrayList<ObjectGuidType> arrayList11 = i8 == 0 ? folderObject4.include_objects : folderObject4.exclude_objects;
                        if (i8 == 0) {
                            hashSet4 = hashSet5;
                            folderObject4.pinned_objects.clear();
                            int size4 = folderObject3.pinned_objects.size();
                            arrayList4 = arrayList8;
                            int i9 = 0;
                            while (i9 < size4) {
                                int i10 = size4;
                                ObjectGuidType objectGuidType2 = folderObject3.pinned_objects.get(i9);
                                FolderObject folderObject5 = folderObject3;
                                folderObject4.pinned_objects.size();
                                folderObject4.pinned_objects.add(objectGuidType2);
                                if (hashSet7.remove(objectGuidType2)) {
                                    map8 = map15;
                                } else {
                                    if (map13.containsKey(objectGuidType2.object_guid)) {
                                        map8 = map15;
                                    } else {
                                        map8 = map15;
                                        if (!this.chatMap.containsKey(objectGuidType2.object_guid)) {
                                            arrayList7.add(objectGuidType2.object_guid);
                                            map13.put(objectGuidType2.object_guid, objectGuidType2);
                                        }
                                    }
                                    z5 = true;
                                }
                                i9++;
                                size4 = i10;
                                folderObject3 = folderObject5;
                                map15 = map8;
                            }
                            folderObject = folderObject3;
                            map7 = map15;
                        } else {
                            folderObject = folderObject3;
                            arrayList4 = arrayList8;
                            map7 = map15;
                            hashSet4 = hashSet5;
                        }
                        int size5 = arrayList10.size();
                        int i11 = 0;
                        while (i11 < size5) {
                            ObjectGuidType objectGuidType3 = arrayList10.get(i11);
                            if (!hashSet6.remove(objectGuidType3)) {
                                if (!arrayList11.contains(objectGuidType3)) {
                                    arrayList11.add(objectGuidType3);
                                }
                                z5 = true;
                            }
                            ObjectGuidType objectGuidType4 = arrayList10.get(i11);
                            int i12 = size5;
                            if (objectGuidType4.type == ChatType.User) {
                                String str2 = objectGuidType4.object_guid;
                                if (!hashSet6.remove(objectGuidType4)) {
                                    if (!arrayList11.contains(objectGuidType4)) {
                                        arrayList11.add(objectGuidType4);
                                    }
                                    if (!map11.containsKey(str2)) {
                                        arrayList5.add(str2);
                                        map11.put(str2, objectGuidType4);
                                        z6 = true;
                                    }
                                    if (!map13.containsKey(objectGuidType4.object_guid) && !this.chatMap.containsKey(objectGuidType4.object_guid)) {
                                        arrayList7.add(objectGuidType4.object_guid);
                                        map13.put(objectGuidType4.object_guid, objectGuidType4);
                                    }
                                    z5 = true;
                                }
                            } else if (!hashSet6.remove(objectGuidType4)) {
                                if (!arrayList11.contains(objectGuidType4)) {
                                    arrayList11.add(objectGuidType4);
                                }
                                if (!map13.containsKey(objectGuidType4.object_guid) && !this.chatMap.containsKey(objectGuidType4.object_guid)) {
                                    arrayList7.add(objectGuidType4.object_guid);
                                    map13.put(objectGuidType4.object_guid, objectGuidType4);
                                }
                                z5 = true;
                            }
                            i11++;
                            size5 = i12;
                        }
                        i8++;
                        map12 = map17;
                        hashSet5 = hashSet4;
                        arrayList8 = arrayList4;
                        folderObject3 = folderObject;
                        map15 = map7;
                    }
                    FolderObject folderObject6 = folderObject3;
                    HashMap map18 = map12;
                    ArrayList arrayList12 = arrayList8;
                    HashMap map19 = map15;
                    HashSet hashSet8 = hashSet5;
                    if (hashSet6.isEmpty()) {
                        z3 = z6;
                    } else {
                        map14.put(folderObject4.folder_id, hashSet6);
                        z3 = true;
                        z5 = true;
                    }
                    if (hashSet7.isEmpty()) {
                        map6 = map19;
                        z4 = z5;
                    } else {
                        map6 = map19;
                        map6.put(folderObject4.folder_id, hashSet7);
                        z4 = true;
                    }
                    if (z4) {
                        folderObject4.include_objects = folderObject6.include_objects;
                        folderObject4.exclude_objects = folderObject6.exclude_objects;
                        arrayList2 = arrayList12;
                        arrayList2.add(folderObject4);
                    } else {
                        arrayList2 = arrayList12;
                    }
                    if (z3) {
                        String str3 = folderObject4.folder_id;
                        hashSet3 = hashSet8;
                        hashSet3.add(str3);
                    } else {
                        hashSet3 = hashSet8;
                    }
                    hashSet = hashSet3;
                    map2 = map6;
                    arrayList6 = arrayList9;
                    map3 = map18;
                } else {
                    map = map9;
                    FolderObject folderObject7 = folderObject3;
                    ArrayList arrayList13 = arrayList6;
                    HashMap map20 = map12;
                    arrayList2 = arrayList8;
                    HashMap map21 = map15;
                    HashSet hashSet9 = hashSet5;
                    FolderObject folderObject8 = new FolderObject();
                    folderObject8.folder_id = folderObject7.folder_id;
                    folderObject8.flags = i5;
                    folderObject8.name = folderObject7.name;
                    folderObject8.suggestion_folder_id = folderObject7.suggestion_folder_id;
                    folderObject8.include_chat_types = folderObject7.include_chat_types;
                    folderObject8.exclude_chat_types = folderObject7.exclude_chat_types;
                    folderObject8.pinned_objects = folderObject7.pinned_objects;
                    folderObject8.order = folderObject7.order;
                    folderObject8.makeSetFromArrays();
                    int i13 = 0;
                    while (i13 < 2) {
                        if (i13 == 0) {
                            int size6 = folderObject7.pinned_objects.size();
                            int i14 = 0;
                            while (i14 < size6) {
                                ObjectGuidType objectGuidType5 = folderObject7.pinned_objects.get(i14);
                                folderObject8.pinned_objects.add(objectGuidType5);
                                if (map13.containsKey(objectGuidType5.object_guid)) {
                                    hashSet2 = hashSet9;
                                } else {
                                    hashSet2 = hashSet9;
                                    if (!this.chatMap.containsKey(objectGuidType5.object_guid)) {
                                        arrayList7.add(objectGuidType5.object_guid);
                                        map13.put(objectGuidType5.object_guid, objectGuidType5);
                                    }
                                }
                                i14++;
                                hashSet9 = hashSet2;
                            }
                        }
                        HashSet hashSet10 = hashSet9;
                        ArrayList<ObjectGuidType> arrayList14 = i13 == 0 ? folderObject7.include_objects : folderObject7.exclude_objects;
                        ArrayList<ObjectGuidType> arrayList15 = i13 == 0 ? folderObject8.include_objects : folderObject8.exclude_objects;
                        int size7 = arrayList14.size();
                        int i15 = 0;
                        while (i15 < size7) {
                            ObjectGuidType objectGuidType6 = arrayList14.get(i15);
                            if (!arrayList15.contains(objectGuidType6)) {
                                arrayList15.add(objectGuidType6);
                            }
                            ObjectGuidType objectGuidType7 = arrayList14.get(i15);
                            FolderObject folderObject9 = folderObject7;
                            ArrayList<ObjectGuidType> arrayList16 = arrayList14;
                            if (objectGuidType7.type == ChatType.User) {
                                String str4 = objectGuidType7.object_guid;
                                if (!arrayList15.contains(objectGuidType7)) {
                                    arrayList15.add(objectGuidType7);
                                }
                                if (!map11.containsKey(str4)) {
                                    arrayList5.add(str4);
                                    map11.put(str4, objectGuidType7);
                                }
                                if (!map13.containsKey(objectGuidType7.object_guid) && !this.chatMap.containsKey(objectGuidType7.object_guid)) {
                                    arrayList7.add(objectGuidType7.object_guid);
                                    map13.put(objectGuidType7.object_guid, objectGuidType7);
                                }
                                map5 = map21;
                                arrayList3 = arrayList13;
                                map4 = map20;
                            } else {
                                String str5 = objectGuidType7.object_guid;
                                if (!arrayList15.contains(objectGuidType7)) {
                                    arrayList15.add(objectGuidType7);
                                }
                                map4 = map20;
                                if (map4.containsKey(str5)) {
                                    map5 = map21;
                                    arrayList3 = arrayList13;
                                } else {
                                    map5 = map21;
                                    arrayList3 = arrayList13;
                                    arrayList3.add(str5);
                                    map4.put(str5, objectGuidType7);
                                }
                            }
                            i15++;
                            map20 = map4;
                            arrayList13 = arrayList3;
                            arrayList14 = arrayList16;
                            folderObject7 = folderObject9;
                            map21 = map5;
                        }
                        i13++;
                        hashSet9 = hashSet10;
                        map21 = map21;
                    }
                    hashSet = hashSet9;
                    map2 = map21;
                    arrayList6 = arrayList13;
                    map3 = map20;
                    arrayList2.add(folderObject8);
                }
                i2 = i4 + 1;
                map12 = map3;
                arrayList8 = arrayList2;
                size2 = i3;
                map10 = map16;
                map9 = map;
                hashSet5 = hashSet;
                map15 = map2;
            }
            if (!arrayList5.isEmpty()) {
                ArrayList<UserInfo> allUserInfoObject = dBHelper.getAllUserInfoObject(arrayList5);
                int size8 = allUserInfoObject.size();
                for (int i16 = 0; i16 < size8; i16++) {
                    map11.remove(allUserInfoObject.get(i16).user_guid);
                }
            }
            getChatsByGuidsFromServer(map13.keySet(), str, networkHelper, dBHelper, absNotificationCenter, null);
        } catch (Exception e) {
            CoreLog coreLog = this.coreLog;
            if (coreLog != null) {
                coreLog.handleException(e);
            }
        }
    }

    public void getSuggestedFolders(String str, NetworkHelper networkHelper, final LoadListener<ArrayList<DialogFilterSuggested>> loadListener) {
        if (this.isLoadingSuggestedFolders) {
            return;
        }
        GetSuggestedFoldersInput getSuggestedFoldersInput = new GetSuggestedFoldersInput();
        this.isLoadingSuggestedFolders = true;
        try {
            networkHelper.getSuggestedFolders(str, getSuggestedFoldersInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetSuggestedFoldersOutput>() { // from class: ir.aaap.messengercore.ChatUtils.11
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(GetSuggestedFoldersOutput getSuggestedFoldersOutput) {
                    ChatUtils.this.isLoadingFoldersInProgress = false;
                    if (getSuggestedFoldersOutput == null || loadListener == null) {
                        return;
                    }
                    ChatUtils.this.onSuggestedFolderListChanged(getSuggestedFoldersOutput.suggested_folders);
                    loadListener.onDidLoad(getSuggestedFoldersOutput.suggested_folders);
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    ChatUtils.this.isLoadingSuggestedFolders = false;
                    loadListener.onError(exc);
                }
            });
        } catch (Exception e) {
            this.isLoadingFoldersInProgress = false;
            this.coreLog.handleException(e);
            loadListener.onError(e);
        }
    }

    public void createAndSortFolderList(boolean z, AbsNotificationCenter absNotificationCenter) {
        synchronized (this.foldersLock) {
            this.dialogFilters.clear();
            Iterator<String> it = this.dialogFiltersMap.keySet().iterator();
            while (it.hasNext()) {
                this.dialogFilters.add(this.dialogFiltersMap.get(it.next()));
            }
            Collections.sort(this.dialogFilters, new Comparator() { // from class: ir.aaap.messengercore.ChatUtils$$ExternalSyntheticLambda4
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return ChatUtils.lambda$createAndSortFolderList$0((FolderObject) obj, (FolderObject) obj2);
                }
            });
        }
        if (z) {
            absNotificationCenter.dialogFiltersUpdated();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$createAndSortFolderList$0(FolderObject folderObject, FolderObject folderObject2) {
        int i = folderObject.order;
        int i2 = folderObject2.order;
        if (i > i2) {
            return 1;
        }
        return i < i2 ? -1 : 0;
    }

    public ArrayList<FolderObject> getFoldersInstant() {
        ArrayList<FolderObject> arrayList = this.dialogFilters;
        return arrayList != null ? arrayList : new ArrayList<>();
    }

    public ArrayList<DialogFilterSuggested> getSuggestedFolderListInstant() {
        ArrayList<DialogFilterSuggested> arrayList = this.suggestedFilters;
        return arrayList != null ? arrayList : new ArrayList<>();
    }

    public void initChatList(final String str, final NetworkHelper networkHelper, final DBHelper dBHelper, final KeyValueStorageHelper keyValueStorageHelper, final AbsNotificationCenter absNotificationCenter, final TimerHelper timerHelper, boolean z, final UpdateChatUsecase updateChatUsecase, final LoadListener<Integer> loadListener) {
        if (this.isChatInitInProgress || this.isChatLoadMoreInProgress) {
            networkHelper.cancelCall(this.lastGetChatListRequestId);
            this.isChatLoadMoreInProgress = false;
        }
        this.isChatInitInProgress = true;
        GetChatsListener getChatsListener = new GetChatsListener() { // from class: ir.aaap.messengercore.ChatUtils.12
            @Override // ir.aaap.messengercore.ChatUtils.GetChatsListener
            public void onResponse(GetChatsResult getChatsResult) {
                ArrayList<ChatExtra> arrayList;
                ChatUtils.this.isChatInitInProgress = false;
                ChatUtils chatUtils = ChatUtils.this;
                chatUtils.isChatInited = true;
                chatUtils.getChatListInitHasError = false;
                if (getChatsResult != null) {
                    ChatUtils.this.clearChatMap();
                    ArrayList<Chat> arrayList2 = getChatsResult.chats;
                    if (arrayList2 != null) {
                        ChatUtils.this.addToChatMap(arrayList2, false, absNotificationCenter, dBHelper);
                        ChatUtils.this.addToAbsMap(getChatsResult.absObjects, getChatsResult.timeStamp);
                        if (getChatsResult.fromDb && (arrayList = getChatsResult.extras) != null) {
                            Iterator<ChatExtra> it = arrayList.iterator();
                            while (it.hasNext()) {
                                ChatExtra next = it.next();
                                Chat chat = ChatUtils.this.chatMap.get(next.object_guid);
                                if (chat != null) {
                                    chat.chatExtra = next;
                                    chat.fillAttributes();
                                }
                            }
                        }
                    }
                    ChatUtils.this.createAndSortChatList(absNotificationCenter, new ChatNeedReloadResult(ChatNeedReloadResult.TypeEnum.AllListUpdated), dBHelper);
                }
                LoadListener loadListener2 = loadListener;
                if (loadListener2 != null) {
                    loadListener2.onDidLoad(1);
                }
                ChatUtils.this.cancelChatTimer(timerHelper);
                if (ChatUtils.this.isStartChatList) {
                    ChatUtils.this.startChatTimer(str, networkHelper, dBHelper, keyValueStorageHelper, absNotificationCenter, timerHelper, updateChatUsecase, loadListener);
                }
                ChatUtils.this.getChatAdsIfNeeded(str, networkHelper, keyValueStorageHelper, absNotificationCenter);
            }

            @Override // ir.aaap.messengercore.ChatUtils.GetChatsListener
            public void onError(Exception exc) {
                ChatUtils.this.isChatInitInProgress = false;
                ChatUtils chatUtils = ChatUtils.this;
                if (!chatUtils.isChatInited) {
                    chatUtils.getChatListInitHasError = true;
                }
                absNotificationCenter.chatsNeedReload(new ChatNeedReloadResult(ChatNeedReloadResult.TypeEnum.hasError));
                LoadListener loadListener2 = loadListener;
                if (loadListener2 != null) {
                    loadListener2.onError(exc);
                }
                if (ChatUtils.this.isStartChatList) {
                    ChatUtils.this.startChatTimer(str, networkHelper, dBHelper, keyValueStorageHelper, absNotificationCenter, timerHelper, updateChatUsecase, loadListener);
                }
            }
        };
        String chatsState = keyValueStorageHelper.getChatsState();
        this.chatListHasContinue = keyValueStorageHelper.getChatsHasContinue();
        this.chatsNextStartId = keyValueStorageHelper.getChatsNextStartId();
        if (z || chatsState == null || chatsState.isEmpty()) {
            getChatsAndAbsFromServer(str, networkHelper, dBHelper, keyValueStorageHelper, absNotificationCenter, null, getChatsListener);
        } else {
            getChatsAndAbsFromDB(dBHelper, getChatsListener);
        }
    }

    public void initChatMapFromDbIfNeeded(final DBHelper dBHelper, final AbsNotificationCenter absNotificationCenter) {
        if (this.isChatInited || this.isChatListLoadedFromDb) {
            return;
        }
        getChatsAndAbsFromDB(dBHelper, new GetChatsListener() { // from class: ir.aaap.messengercore.ChatUtils.13
            @Override // ir.aaap.messengercore.ChatUtils.GetChatsListener
            public void onError(Exception exc) {
            }

            @Override // ir.aaap.messengercore.ChatUtils.GetChatsListener
            public void onResponse(GetChatsResult getChatsResult) {
                ArrayList<Chat> arrayList;
                ArrayList<ChatExtra> arrayList2;
                if (ChatUtils.this.isChatInited || getChatsResult == null || !getChatsResult.fromDb || (arrayList = getChatsResult.chats) == null || arrayList.size() <= 0) {
                    return;
                }
                ChatUtils.this.isChatListLoadedFromDb = true;
                ChatUtils.this.clearChatMap();
                ChatUtils.this.addToChatMap(getChatsResult.chats, false, absNotificationCenter, dBHelper);
                ChatUtils.this.addToAbsMap(getChatsResult.absObjects, getChatsResult.timeStamp);
                if (getChatsResult.fromDb && (arrayList2 = getChatsResult.extras) != null) {
                    Iterator<ChatExtra> it = arrayList2.iterator();
                    while (it.hasNext()) {
                        ChatExtra next = it.next();
                        Chat chat = ChatUtils.this.chatMap.get(next.object_guid);
                        if (chat != null) {
                            chat.chatExtra = next;
                            chat.fillAttributes();
                        }
                    }
                }
                ChatUtils.this.createAndSortChatList(absNotificationCenter, new ChatNeedReloadResult(ChatNeedReloadResult.TypeEnum.AllListUpdated), dBHelper);
            }
        });
    }

    public void loadMoreChat(String str, NetworkHelper networkHelper, final DBHelper dBHelper, KeyValueStorageHelper keyValueStorageHelper, final AbsNotificationCenter absNotificationCenter) {
        if (this.isChatInited && !this.isChatInitInProgress && !this.isChatLoadMoreInProgress && getChatListHasContinue()) {
            getChatsAndAbsFromServer(str, networkHelper, dBHelper, keyValueStorageHelper, absNotificationCenter, this.chatsNextStartId, new GetChatsListener() { // from class: ir.aaap.messengercore.ChatUtils.14
                @Override // ir.aaap.messengercore.ChatUtils.GetChatsListener
                public void onResponse(GetChatsResult getChatsResult) {
                    ChatUtils.this.isChatLoadMoreInProgress = false;
                    ChatUtils.this.getChatLoadMoreHasError = false;
                    ChatUtils.this.addToChatMap(getChatsResult.chats, false, absNotificationCenter, dBHelper);
                    ChatUtils.this.addToAbsMap(getChatsResult.absObjects, getChatsResult.timeStamp);
                    ChatUtils.this.createAndSortChatList(absNotificationCenter, new ChatNeedReloadResult(ChatNeedReloadResult.TypeEnum.AllListUpdated), dBHelper);
                }

                @Override // ir.aaap.messengercore.ChatUtils.GetChatsListener
                public void onError(Exception exc) {
                    ChatUtils.this.isChatLoadMoreInProgress = false;
                    ChatUtils.this.getChatLoadMoreHasError = true;
                    absNotificationCenter.chatsNeedReload(new ChatNeedReloadResult(ChatNeedReloadResult.TypeEnum.hasError));
                }
            });
        }
    }

    public void startChatList(String str, NetworkHelper networkHelper, DBHelper dBHelper, KeyValueStorageHelper keyValueStorageHelper, AbsNotificationCenter absNotificationCenter, TimerHelper timerHelper, boolean z, UpdateChatUsecase updateChatUsecase) {
        if (this.isStartChatList) {
            return;
        }
        this.isStartChatList = true;
        if (this.isChatInited && !z) {
            startChatTimer(str, networkHelper, dBHelper, keyValueStorageHelper, absNotificationCenter, timerHelper, updateChatUsecase, null);
        } else {
            initChatList(str, networkHelper, dBHelper, keyValueStorageHelper, absNotificationCenter, timerHelper, false, updateChatUsecase, null);
        }
    }

    public void stopChatList(TimerHelper timerHelper, NetworkHelper networkHelper) {
        this.isStartChatList = false;
        this.isChatUpdateInProgress = false;
        this.isChatLoadMoreInProgress = false;
        this.isChatAdsLoading = false;
        networkHelper.cancelCall(this.lastGetChatListRequestId);
        networkHelper.cancelCall(this.lastGetChatAdsRequestId);
        cancelChatTimer(timerHelper);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startChatTimer(String str, NetworkHelper networkHelper, DBHelper dBHelper, KeyValueStorageHelper keyValueStorageHelper, AbsNotificationCenter absNotificationCenter, TimerHelper timerHelper, UpdateChatUsecase updateChatUsecase, LoadListener<Integer> loadListener) {
        long j;
        long chatsLastUpdateTime = keyValueStorageHelper.getChatsLastUpdateTime(0L);
        if (chatsLastUpdateTime > System.currentTimeMillis() || !this.isChatInited) {
            chatsLastUpdateTime = 0;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - chatsLastUpdateTime;
        int i = CoreMainClassImpl.getChatUpdatePeriodMillis;
        if (jCurrentTimeMillis < i) {
            j = i - (jCurrentTimeMillis > 0 ? jCurrentTimeMillis : 0L);
        } else {
            j = 100;
        }
        startChatTimer(j, str, networkHelper, dBHelper, keyValueStorageHelper, absNotificationCenter, timerHelper, updateChatUsecase, loadListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startChatTimer(long j, final String str, final NetworkHelper networkHelper, final DBHelper dBHelper, final KeyValueStorageHelper keyValueStorageHelper, final AbsNotificationCenter absNotificationCenter, final TimerHelper timerHelper, final UpdateChatUsecase updateChatUsecase, final LoadListener loadListener) {
        if (this.getChatUpdateRunnable == null) {
            this.getChatUpdateRunnable = new Runnable() { // from class: ir.aaap.messengercore.ChatUtils$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$startChatTimer$1(str, networkHelper, dBHelper, keyValueStorageHelper, absNotificationCenter, timerHelper, updateChatUsecase, loadListener);
                }
            };
        }
        if (timerHelper != null) {
            timerHelper.postRunnableDelayed(this.getChatUpdateRunnable, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelChatTimer(TimerHelper timerHelper) {
        Runnable runnable;
        if (timerHelper == null || (runnable = this.getChatUpdateRunnable) == null) {
            return;
        }
        timerHelper.cancelRunnable(runnable);
    }

    public void onBotInfoLevelChanged(String str, NetworkHelper networkHelper, DBHelper dBHelper, AbsNotificationCenter absNotificationCenter, TimerHelper timerHelper, String str2, ChatType chatType, UpdateBotInfoUsecase updateBotInfoUsecase) {
        if (chatType == ChatType.Bot && this.infoStartedSet.contains(str2)) {
            startInfoTimer(str, networkHelper, dBHelper, absNotificationCenter, timerHelper, str2, chatType, updateBotInfoUsecase);
        }
    }

    public void startObjectInfoUpdate(String str, NetworkHelper networkHelper, DBHelper dBHelper, AbsNotificationCenter absNotificationCenter, TimerHelper timerHelper, String str2, ChatType chatType, UpdateBotInfoUsecase updateBotInfoUsecase) {
        if (this.infoStartedSet.contains(str2)) {
            return;
        }
        this.infoStartedSet.add(str2);
        startInfoTimer(str, networkHelper, dBHelper, absNotificationCenter, timerHelper, str2, chatType, updateBotInfoUsecase);
        if (chatType == ChatType.Group) {
            startGetGroupOnlineCountTimer(str2, str, networkHelper, absNotificationCenter, timerHelper);
        }
    }

    private void startInfoTimer(String str, NetworkHelper networkHelper, DBHelper dBHelper, AbsNotificationCenter absNotificationCenter, TimerHelper timerHelper, String str2, ChatType chatType, UpdateBotInfoUsecase updateBotInfoUsecase) {
        int i = CoreMainClassImpl.getInfoUpdatePeriodMillis;
        long j = 100;
        if (this.infoUpdatedTimeMap.containsKey(str2)) {
            long jLongValue = this.infoUpdatedTimeMap.get(str2).longValue();
            if (jLongValue > System.currentTimeMillis()) {
                jLongValue = 0;
            }
            long jCurrentTimeMillis = System.currentTimeMillis() - jLongValue;
            long botInfoUpdateDuration = (chatType != ChatType.Bot || updateBotInfoUsecase == null) ? CoreMainClassImpl.getInfoUpdatePeriodMillis : updateBotInfoUsecase.getBotInfoUpdateDuration();
            if (jCurrentTimeMillis < botInfoUpdateDuration) {
                j = botInfoUpdateDuration - (jCurrentTimeMillis > 0 ? jCurrentTimeMillis : 0L);
            }
        }
        startInfoTimer(j, str, networkHelper, dBHelper, absNotificationCenter, timerHelper, str2, chatType, updateBotInfoUsecase);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startInfoTimer(long j, final String str, final NetworkHelper networkHelper, final DBHelper dBHelper, final AbsNotificationCenter absNotificationCenter, final TimerHelper timerHelper, final String str2, final ChatType chatType, final UpdateBotInfoUsecase updateBotInfoUsecase) {
        HashSet<Chat.ChatAccessEnum> hashSet;
        Chat chatInstant = getChatInstant(str2);
        if (chatInstant != null && (hashSet = chatInstant.access) != null && !hashSet.contains(Chat.ChatAccessEnum.ViewInfo)) {
            this.infoRunnableMap.remove(str2);
            Runnable runnable = this.infoRunnableMap.get(str2);
            if (runnable != null) {
                timerHelper.cancelRunnable(runnable);
                return;
            }
            return;
        }
        Runnable runnable2 = this.infoRunnableMap.get(str2);
        if (runnable2 == null) {
            Runnable runnable3 = new Runnable() { // from class: ir.aaap.messengercore.ChatUtils$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$startInfoTimer$2(str, networkHelper, dBHelper, absNotificationCenter, timerHelper, str2, chatType, updateBotInfoUsecase);
                }
            };
            this.infoRunnableMap.put(str2, runnable3);
            runnable2 = runnable3;
        }
        if (timerHelper != null) {
            timerHelper.postRunnableDelayed(runnable2, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startInfoTimer$2(String str, NetworkHelper networkHelper, DBHelper dBHelper, AbsNotificationCenter absNotificationCenter, TimerHelper timerHelper, String str2, ChatType chatType, UpdateBotInfoUsecase updateBotInfoUsecase) {
        getObjectInfoFromServer(str, networkHelper, dBHelper, absNotificationCenter, null, timerHelper, str2, chatType, updateBotInfoUsecase);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startGetGroupOnlineCountTimer(final String str, final String str2, final NetworkHelper networkHelper, final AbsNotificationCenter absNotificationCenter, final TimerHelper timerHelper) {
        HashSet<Chat.ChatAccessEnum> hashSet;
        Chat chatInstant = getChatInstant(str);
        if (chatInstant != null && (hashSet = chatInstant.access) != null && !hashSet.contains(Chat.ChatAccessEnum.ViewInfo)) {
            this.onlineCountRunnableMap.remove(str);
            Runnable runnable = this.onlineCountRunnableMap.get(str);
            if (runnable != null) {
                timerHelper.cancelRunnable(runnable);
                return;
            }
            return;
        }
        Runnable runnable2 = this.onlineCountRunnableMap.get(str);
        int i = CoreMainClassImpl.groupOnlineCountUpdatePeriodMillis;
        if (runnable2 == null) {
            runnable2 = new Runnable() { // from class: ir.aaap.messengercore.ChatUtils$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$startGetGroupOnlineCountTimer$3(str, str2, networkHelper, absNotificationCenter, timerHelper);
                }
            };
            this.onlineCountRunnableMap.put(str, runnable2);
            i = 100;
        }
        if (timerHelper != null) {
            timerHelper.postRunnableDelayed(runnable2, i);
        }
    }

    public void stopObjectInfoUpdate(NetworkHelper networkHelper, TimerHelper timerHelper, String str) {
        if (this.infoLoadingSet.contains(str)) {
            Integer num = this.infoRequestIdMap.get(str);
            if (num != null) {
                networkHelper.cancelCall(num.intValue());
            }
            this.infoLoadingSet.remove(str);
        }
        cancelInfoTimer(timerHelper, str);
    }

    private void cancelInfoTimer(TimerHelper timerHelper, String str) {
        if (this.infoStartedSet.contains(str)) {
            Runnable runnable = this.infoRunnableMap.get(str);
            if (timerHelper != null && runnable != null) {
                timerHelper.cancelRunnable(runnable);
            }
            this.infoStartedSet.remove(str);
        }
        if (this.onlineCountRunnableMap.containsKey(str)) {
            Runnable runnable2 = this.onlineCountRunnableMap.get(str);
            if (timerHelper != null && runnable2 != null) {
                timerHelper.cancelRunnable(runnable2);
            }
            this.onlineCountRunnableMap.remove(str);
        }
    }

    private void addToChatMap(Chat chat, boolean z, AbsNotificationCenter absNotificationCenter, DBHelper dBHelper) {
        ArrayList<Chat> arrayList = new ArrayList<>();
        arrayList.add(chat);
        addToChatMap(arrayList, z, absNotificationCenter, dBHelper);
    }

    public void addToChatMap(ArrayList<Chat> arrayList, boolean z, AbsNotificationCenter absNotificationCenter, DBHelper dBHelper) {
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        synchronized (this.chatsLock) {
            Iterator<Chat> it = arrayList.iterator();
            while (it.hasNext()) {
                Chat next = it.next();
                next.chatExtra = dBHelper.getChatExtra(next.object_guid);
                next.fillAttributes();
                this.chatMap.put(next.object_guid, next);
            }
        }
        if (z) {
            createAndSortChatList(absNotificationCenter, new ChatNeedReloadResult(ChatNeedReloadResult.TypeEnum.AllListUpdated), dBHelper);
        }
    }

    private void addToInfoMap(ObjectInfo objectInfo) {
        ArrayList<ObjectInfo> arrayList = new ArrayList<>();
        arrayList.add(objectInfo);
        addToInfoMap(arrayList);
    }

    private void addToInfoByUsernameMap(String str, ObjectInfo objectInfo) {
        synchronized (this.infoByUsernameLock) {
            this.objectInfoByUsernameMap.put(str.toLowerCase(Locale.ROOT), objectInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeFromInfoByUsernameMap(String str) {
        synchronized (this.infoByUsernameLock) {
            this.objectInfoByUsernameMap.remove(str.toLowerCase(Locale.ROOT));
        }
    }

    private void addToInfoMap(ArrayList<ObjectInfo> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        synchronized (this.infoLock) {
            Iterator<ObjectInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                ObjectInfo next = it.next();
                this.objectInfoByIdMap.put(next.objectGuid, next);
                String userName = next.getUserName();
                if (CoreUtilities.isNotEmpty(userName)) {
                    addToInfoByUsernameMap(userName, next);
                }
            }
        }
    }

    private void addToMemberMap(ArrayList<InChatMember> arrayList) {
        synchronized (this.memberLock) {
            Iterator<InChatMember> it = arrayList.iterator();
            while (it.hasNext()) {
                InChatMember next = it.next();
                this.inChatMemberMap.put(next.member_guid, next);
            }
        }
    }

    public void addToAbsMap(ChatAbsObject chatAbsObject, long j) {
        if (chatAbsObject == null) {
            return;
        }
        ArrayList<ChatAbsObject> arrayList = new ArrayList<>();
        arrayList.add(chatAbsObject);
        addToAbsMap(arrayList, j);
    }

    public void addToAbsIfNotExist(ArrayList<ChatAbsObject> arrayList, long j, DBHelper dBHelper) {
        if (arrayList == null) {
            return;
        }
        ArrayList<ChatAbsObject> arrayList2 = new ArrayList<>();
        Iterator<ChatAbsObject> it = arrayList.iterator();
        while (it.hasNext()) {
            ChatAbsObject next = it.next();
            if (getChatAbsInstant(next.object_guid, dBHelper) == null) {
                ChatAbsObject absObject = dBHelper.getAbsObject(next.object_guid);
                if (absObject == null) {
                    this.coreLog.e("ChatUtils", "addToAbsIfNotExist  db null");
                    arrayList2.add(next);
                } else {
                    this.coreLog.e("ChatUtils", "addToAbsIfNotExist  map null");
                    addToAbsMap(absObject, absObject.timeStamp);
                }
            } else {
                this.coreLog.e("ChatUtils", "addToAbsIfNotExist  map not null");
            }
        }
        if (arrayList2.size() > 0) {
            addToAbsMap(arrayList2, j);
            dBHelper.addAllAbsObject(arrayList2, j);
        }
    }

    public void addToAbsMap(ArrayList<ChatAbsObject> arrayList, long j) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        synchronized (this.absLock) {
            Iterator<ChatAbsObject> it = arrayList.iterator();
            while (it.hasNext()) {
                ChatAbsObject next = it.next();
                next.setTimeStampIfNotSet(j);
                this.absMap.put(next.object_guid, next);
            }
        }
    }

    private void removeFromContactMap(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        removeFromContactMap(arrayList);
    }

    private void removeFromContactMap(ArrayList<String> arrayList) {
        synchronized (this.contactLock) {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                this.contactSet.remove(it.next());
            }
        }
    }

    private void addToContactMap(UserInfo userInfo) {
        synchronized (this.contactLock) {
            this.contactSet.add(userInfo.user_guid);
        }
    }

    public void addToContactMap(ArrayList<UserInfo> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        synchronized (this.contactLock) {
            Iterator<UserInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                this.contactSet.add(it.next().user_guid);
            }
        }
    }

    private void removeFromChatMap(ArrayList<String> arrayList, boolean z, AbsNotificationCenter absNotificationCenter, DBHelper dBHelper) {
        synchronized (this.chatsLock) {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                this.chatMap.remove(it.next());
            }
        }
        if (z) {
            ChatNeedReloadResult chatNeedReloadResult = new ChatNeedReloadResult(ChatNeedReloadResult.TypeEnum.SomeChatsUpdated);
            chatNeedReloadResult.deleteChats = arrayList;
            createAndSortChatList(absNotificationCenter, chatNeedReloadResult, dBHelper);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearChatMap() {
        synchronized (this.chatsLock) {
            this.chatMap.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearContactMap() {
        synchronized (this.contactLock) {
            this.contactSet.clear();
            this.isContactLoadedFromDb = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createAndSortChatList(AbsNotificationCenter absNotificationCenter, ChatNeedReloadResult chatNeedReloadResult, DBHelper dBHelper) {
        Chat.ChatStatusEnum chatStatusEnum;
        synchronized (this.chatsLock) {
            ArrayList<Chat> arrayList = new ArrayList<>();
            for (Chat chat : this.chatMap.values()) {
                if (chat != null && (chatStatusEnum = chat.status) != null && chatStatusEnum != Chat.ChatStatusEnum.NotExist) {
                    arrayList.add(chat);
                }
            }
            Collections.sort(arrayList, this.chatComparator);
            this.chatList = arrayList;
        }
        updateFoldersUnreadCount(absNotificationCenter, dBHelper);
        if (absNotificationCenter != null) {
            absNotificationCenter.chatsNeedReload(chatNeedReloadResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createAndSortContactListAndNotify(AbsNotificationCenter absNotificationCenter, ContactsNeedsReloadResult contactsNeedsReloadResult) {
        synchronized (this.contactLock) {
            this.sortedContactResult = sortContact(new ArrayList<>(this.contactSet));
        }
        if (absNotificationCenter != null) {
            absNotificationCenter.contactsNeedsReload(contactsNeedsReloadResult);
        }
    }

    public ArrayList<Chat> getChatList() {
        if (this.isChatInited || this.isChatListLoadedFromDb) {
            return this.chatList;
        }
        return new ArrayList<>();
    }

    public boolean isChatListInited() {
        return this.isChatInited;
    }

    public void blockActionUser(String str, boolean z, String str2, NetworkHelper networkHelper, final AbsNotificationCenter absNotificationCenter, final DBHelper dBHelper, final UpdateChatUsecase updateChatUsecase, final LoadListener<Integer> loadListener) {
        if (str == null || str.isEmpty()) {
            return;
        }
        SetBlockUserInput setBlockUserInput = new SetBlockUserInput();
        setBlockUserInput.action = z ? SetBlockUserInput.BlockActionEnum.Block : SetBlockUserInput.BlockActionEnum.Unblock;
        setBlockUserInput.user_guid = str;
        try {
            networkHelper.setBlockUser(str2, setBlockUserInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<SetBlockUserOutput>() { // from class: ir.aaap.messengercore.ChatUtils.15
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(SetBlockUserOutput setBlockUserOutput) {
                    ChatUpdateObject chatUpdateObject = setBlockUserOutput.chat_update;
                    if (chatUpdateObject != null) {
                        ChatUtils.this.processChatsUpdate(chatUpdateObject, updateChatUsecase, absNotificationCenter, dBHelper);
                    }
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(1);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
        }
    }

    public void getBlockedUsers(String str, String str2, NetworkHelper networkHelper, final DBHelper dBHelper, final LoadListener<GetBlockedUsersOutput> loadListener) {
        GetBlockedUsersInput getBlockedUsersInput = new GetBlockedUsersInput();
        if (CoreUtilities.isNotEmpty(str)) {
            getBlockedUsersInput.start_id = str;
        }
        try {
            networkHelper.getBlockedUsers(str2, getBlockedUsersInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetBlockedUsersOutput>() { // from class: ir.aaap.messengercore.ChatUtils.16
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(GetBlockedUsersOutput getBlockedUsersOutput) {
                    if (getBlockedUsersOutput != null) {
                        ArrayList<ChatAbsObject> arrayList = getBlockedUsersOutput.abs_users;
                        if (arrayList != null && arrayList.size() > 0) {
                            ChatUtils.this.addChatAbsObjects(getBlockedUsersOutput.abs_users, getBlockedUsersOutput.timestamp, dBHelper);
                        }
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(getBlockedUsersOutput);
                            return;
                        }
                        return;
                    }
                    LoadListener loadListener3 = loadListener;
                    if (loadListener3 != null) {
                        loadListener3.onError(new ApiServerException());
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
        }
    }

    public int getOnlineCountInstant(String str) {
        Integer num = this.groupOnlineCountsMap.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public Chat getChatInstant(String str) {
        if (this.isChatInited) {
            return this.chatMap.get(str);
        }
        return null;
    }

    public Chat forceGetChatInstant(String str, DBHelper dBHelper) {
        Map<String, Chat> map = this.chatMap;
        Chat chat = map != null ? map.get(str) : null;
        return chat == null ? dBHelper.getChatById(str) : chat;
    }

    public SortedContactResult getSortedContactListInstant() {
        return this.sortedContactResult;
    }

    public ChatAbsObject getChatAbsInstant(String str, DBHelper dBHelper) {
        if (str == null) {
            return null;
        }
        ChatAbsObject chatAbsObject = this.absMap.get(str);
        return (chatAbsObject != null || dBHelper == null) ? chatAbsObject : getAbsObjectFromDB(dBHelper, str);
    }

    public ObjectInfo getObjectInfoInstant(String str) {
        return this.objectInfoByIdMap.get(str);
    }

    public boolean getChatListHasContinue() {
        return this.chatListHasContinue;
    }

    public void getChatsAndAbsFromDB(DBHelper dBHelper, GetChatsListener getChatsListener) {
        ArrayList<Chat> allChatsOrderByTime = dBHelper.getAllChatsOrderByTime();
        if (getChatsListener != null) {
            GetChatsResult getChatsResult = new GetChatsResult();
            getChatsResult.chats = allChatsOrderByTime;
            getChatsResult.fromDb = true;
            ArrayList<String> arrayList = new ArrayList<>();
            Iterator<Chat> it = allChatsOrderByTime.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().object_guid);
            }
            getChatsResult.extras = dBHelper.getAllChatExtra(arrayList);
            getChatsResult.absObjects = getAbsObjectsFromDB(dBHelper, arrayList);
            getChatsListener.onResponse(getChatsResult);
        }
    }

    private ArrayList<ChatAbsObject> getAbsObjectsFromDB(DBHelper dBHelper, ArrayList<String> arrayList) {
        return dBHelper.getAllAbsObject(arrayList);
    }

    private ChatAbsObject getAbsObjectFromDB(DBHelper dBHelper, String str) {
        return dBHelper.getAbsObject(str);
    }

    public int searchGlobalObjects(String str, String str2, ArrayList<SearchGlobalObjectsInput.FilterType> arrayList, String str3, NetworkHelper networkHelper, final DBHelper dBHelper, final LoadListener<SearchGlobalObjectsOutput> loadListener) {
        SearchGlobalObjectsInput searchGlobalObjectsInput = new SearchGlobalObjectsInput();
        searchGlobalObjectsInput.search_text = str;
        searchGlobalObjectsInput.start_id = str2;
        if (arrayList == null || arrayList.isEmpty()) {
            arrayList = null;
        }
        searchGlobalObjectsInput.filter_types = arrayList;
        int i = this.lastSearchObjectReqID;
        if (i != 0) {
            networkHelper.cancelCall(i);
        }
        this.lastSearchObjectReqID = 0;
        try {
            this.lastSearchObjectReqID = networkHelper.searchGlobalObjects(str3, searchGlobalObjectsInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<SearchGlobalObjectsOutput>() { // from class: ir.aaap.messengercore.ChatUtils.17
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(SearchGlobalObjectsOutput searchGlobalObjectsOutput) {
                    if (searchGlobalObjectsOutput != null && searchGlobalObjectsOutput.objects != null) {
                        ArrayList<ChatAbsObject> arrayList2 = new ArrayList<>();
                        Iterator<InSearchObject> it = searchGlobalObjectsOutput.objects.iterator();
                        while (it.hasNext()) {
                            arrayList2.add(ChatAbsObject.createFromInSearchObject(it.next()));
                        }
                        if (arrayList2.size() > 0) {
                            ChatUtils.this.addToAbsMap(arrayList2, searchGlobalObjectsOutput.timestamp);
                            dBHelper.addAllAbsObject(arrayList2, searchGlobalObjectsOutput.timestamp);
                        }
                        ChatUtils.this.addToSearchMap(searchGlobalObjectsOutput.objects);
                    }
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(searchGlobalObjectsOutput);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.coreLog.handleException(e);
        }
        return this.lastSearchObjectReqID;
    }

    public void forceLastRunnableSeenChat(String str, TimerHelper timerHelper) {
        Runnable runnable = this.seenChatRunnableMap.get(str);
        if (runnable != null) {
            timerHelper.cancelRunnable(runnable);
            runnable.run();
        }
    }

    public void seenChat(final String str, final long j, boolean z, final String str2, final NetworkHelper networkHelper, final DBHelper dBHelper, final AbsNotificationCenter absNotificationCenter, TimerHelper timerHelper, final UpdateChatUsecase updateChatUsecase) {
        Chat chatById = this.chatMap.get(str);
        if (chatById == null) {
            chatById = dBHelper.getChatById(str);
        }
        if (chatById == null || chatById.lastSeenMyMid < j) {
            if (chatById != null) {
                changeChatLocalLastSeen(chatById, j, dBHelper);
            }
            Runnable runnable = this.seenChatRunnableMap.get(str);
            if (runnable != null) {
                timerHelper.cancelRunnable(runnable);
            }
            Runnable runnable2 = new Runnable() { // from class: ir.aaap.messengercore.ChatUtils$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$seenChat$4(str, j, str2, networkHelper, dBHelper, absNotificationCenter, updateChatUsecase);
                }
            };
            this.seenChatRunnableMap.put(str, runnable2);
            if (z) {
                timerHelper.postRunnableDelayed(runnable2, 0L);
            } else {
                timerHelper.postRunnableDelayed(runnable2, 5000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$seenChat$4(String str, long j, String str2, NetworkHelper networkHelper, DBHelper dBHelper, AbsNotificationCenter absNotificationCenter, UpdateChatUsecase updateChatUsecase) {
        SeenChatsInput seenChatsInput = new SeenChatsInput();
        HashMap map = new HashMap();
        seenChatsInput.seen_list = map;
        map.put(str, Long.valueOf(j));
        callSeenChat(seenChatsInput, str2, networkHelper, dBHelper, absNotificationCenter, updateChatUsecase);
        this.seenChatRunnableMap.remove(str);
    }

    public void changeChatLocalCountUnseen(String str, int i, DBHelper dBHelper, AbsNotificationCenter absNotificationCenter) {
        Chat chatInstant = getChatInstant(str);
        if (chatInstant != null) {
            if (chatInstant.chatExtra == null) {
                chatInstant.chatExtra = new ChatExtra(str);
            }
            chatInstant.chatExtra.local_count_unseen = i;
            chatInstant.fillAttributes();
            changeChatExtra(chatInstant.object_guid, chatInstant.chatExtra, dBHelper);
            updateFoldersUnreadCount(absNotificationCenter, dBHelper);
        }
    }

    private void changeChatLocalLastSeen(Chat chat, long j, DBHelper dBHelper) {
        if (chat.chatExtra == null) {
            chat.chatExtra = new ChatExtra(chat.object_guid);
        }
        chat.chatExtra.local_last_seen_my_mid = j;
        chat.fillAttributes();
        changeChatExtra(chat.object_guid, chat.chatExtra, dBHelper);
    }

    private void callSeenChat(SeenChatsInput seenChatsInput, String str, NetworkHelper networkHelper, final DBHelper dBHelper, final AbsNotificationCenter absNotificationCenter, final UpdateChatUsecase updateChatUsecase) {
        Map<String, Long> map;
        if (seenChatsInput == null || (map = seenChatsInput.seen_list) == null || map.size() == 0) {
            return;
        }
        try {
            networkHelper.seenChats(str, seenChatsInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<SeenChatsOutput>() { // from class: ir.aaap.messengercore.ChatUtils.18
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(SeenChatsOutput seenChatsOutput) {
                    ArrayList<ChatUpdateObject> arrayList;
                    if (seenChatsOutput == null || (arrayList = seenChatsOutput.chat_updates) == null) {
                        return;
                    }
                    ChatUtils.this.processChatsUpdate(arrayList, updateChatUsecase, absNotificationCenter, dBHelper);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteChatFromMapAndDb(ArrayList<String> arrayList, boolean z, AbsNotificationCenter absNotificationCenter, DBHelper dBHelper) {
        removeFromChatMap(arrayList, z, absNotificationCenter, dBHelper);
        dBHelper.removeChats(arrayList);
    }

    /* renamed from: getChatUpdates, reason: merged with bridge method [inline-methods] */
    public void lambda$startChatTimer$1(final String str, final NetworkHelper networkHelper, final DBHelper dBHelper, final KeyValueStorageHelper keyValueStorageHelper, final AbsNotificationCenter absNotificationCenter, final TimerHelper timerHelper, final UpdateChatUsecase updateChatUsecase, final LoadListener loadListener) {
        String chatsState;
        if (!this.isChatInited) {
            initChatList(str, networkHelper, dBHelper, keyValueStorageHelper, absNotificationCenter, timerHelper, false, updateChatUsecase, loadListener);
            return;
        }
        if (this.isChatUpdateInProgress) {
            return;
        }
        long chatsLastUpdateTime = keyValueStorageHelper.getChatsLastUpdateTime(0L);
        if (System.currentTimeMillis() - (chatsLastUpdateTime <= System.currentTimeMillis() ? chatsLastUpdateTime : 0L) < CoreMainClassImpl.getChatUpdatePeriodMillis || (chatsState = keyValueStorageHelper.getChatsState()) == null || chatsState.isEmpty()) {
            return;
        }
        GetChatsUpdatesInput getChatsUpdatesInput = new GetChatsUpdatesInput(chatsState);
        this.isChatUpdateInProgress = true;
        absNotificationCenter.dialogsLoadingChanged(true);
        try {
            this.lastGetChatListRequestId = networkHelper.getChatsUpdates(str, getChatsUpdatesInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetChatsUpdatesOutput>() { // from class: ir.aaap.messengercore.ChatUtils.19
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(GetChatsUpdatesOutput getChatsUpdatesOutput) {
                    UpdateChatUsecase updateChatUsecase2;
                    ChatUtils.this.isChatUpdateInProgress = false;
                    absNotificationCenter.dialogsLoadingChanged(ChatUtils.this.isChatUpdateInProgress);
                    if (getChatsUpdatesOutput != null) {
                        ArrayList<ChatFromServer> arrayList = getChatsUpdatesOutput.chats;
                        if (arrayList != null && arrayList.size() > 0) {
                            ArrayList<Chat> arrayList2 = new ArrayList<>();
                            ArrayList<ChatAbsObject> arrayList3 = new ArrayList<>();
                            Iterator<ChatFromServer> it = getChatsUpdatesOutput.chats.iterator();
                            while (it.hasNext()) {
                                ChatFromServer next = it.next();
                                arrayList2.add(Chat.createFromServerObject(next, getChatsUpdatesOutput.timestamp));
                                arrayList3.add(next.abs_object);
                            }
                            dBHelper.addAllChats(arrayList2);
                            ChatUtils.this.addToChatMap(arrayList2, false, absNotificationCenter, dBHelper);
                            dBHelper.addAllAbsObject(arrayList3, getChatsUpdatesOutput.timestamp);
                            ChatUtils.this.addToAbsMap(arrayList3, getChatsUpdatesOutput.timestamp);
                        }
                        ArrayList<String> arrayList4 = getChatsUpdatesOutput.deleted_chats;
                        if (arrayList4 != null && arrayList4.size() > 0 && (updateChatUsecase2 = updateChatUsecase) != null) {
                            updateChatUsecase2.deleteChats(getChatsUpdatesOutput.deleted_chats, false);
                        }
                        ChatUtils.this.createAndSortChatList(absNotificationCenter, new ChatNeedReloadResult(ChatNeedReloadResult.TypeEnum.AllListUpdated), dBHelper);
                        String str2 = getChatsUpdatesOutput.new_state;
                        if (str2 != null) {
                            keyValueStorageHelper.setChatsStateAndUpdateTime(str2, System.currentTimeMillis());
                        }
                        if (getChatsUpdatesOutput.status != GetChatsUpdatesOutput.GetChatsUpdatesStatus.OldState) {
                            if (ChatUtils.this.isStartChatList) {
                                ChatUtils.this.startChatTimer(CoreMainClassImpl.getChatUpdatePeriodMillis, str, networkHelper, dBHelper, keyValueStorageHelper, absNotificationCenter, timerHelper, updateChatUsecase, loadListener);
                            }
                        } else {
                            ChatUtils.this.initChatList(str, networkHelper, dBHelper, keyValueStorageHelper, absNotificationCenter, timerHelper, true, updateChatUsecase, null);
                        }
                    }
                    ChatUtils.this.getChatAdsIfNeeded(str, networkHelper, keyValueStorageHelper, absNotificationCenter);
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    ChatUtils.this.isChatUpdateInProgress = false;
                    absNotificationCenter.dialogsLoadingChanged(ChatUtils.this.isChatUpdateInProgress);
                    if (ChatUtils.this.isStartChatList) {
                        ChatUtils.this.startChatTimer(CoreMainClassImpl.getChatUpdatePeriodMillis, str, networkHelper, dBHelper, keyValueStorageHelper, absNotificationCenter, timerHelper, updateChatUsecase, loadListener);
                    }
                }
            });
        } catch (Exception e) {
            this.isChatUpdateInProgress = false;
            absNotificationCenter.dialogsLoadingChanged(false);
            this.coreLog.handleException(e);
        }
    }

    public ArrayList<ChatAdsObject> getChatAdsInstant(KeyValueStorageHelper keyValueStorageHelper) {
        ArrayList<ChatAdsObject> arrayList = new ArrayList<>();
        ArrayList<ChatAdsObject> chatAdsArray = keyValueStorageHelper.getChatAdsArray();
        if (chatAdsArray != null && chatAdsArray.size() != 0) {
            Iterator<ChatAdsObject> it = chatAdsArray.iterator();
            while (it.hasNext()) {
                ChatAdsObject next = it.next();
                if (!this.dontShowAds.contains(next.chat_ads_id)) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getChatAdsIfNeeded(String str, NetworkHelper networkHelper, final KeyValueStorageHelper keyValueStorageHelper, final AbsNotificationCenter absNotificationCenter) {
        if (this.isChatAdsLoading) {
            return;
        }
        if (System.currentTimeMillis() - keyValueStorageHelper.getLastGetChatAdsTime() < CoreMainClassImpl.getChatAdsPeriodMillis) {
            absNotificationCenter.chatAdsDidLoad();
            return;
        }
        this.isChatAdsLoading = true;
        String chatAdsState = keyValueStorageHelper.getChatAdsState();
        if (chatAdsState != null && chatAdsState.isEmpty()) {
            chatAdsState = null;
        }
        try {
            this.lastGetChatAdsRequestId = networkHelper.getChatAds(str, new GetChatAdsInput(chatAdsState), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetChatAdsOutput>() { // from class: ir.aaap.messengercore.ChatUtils.20
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(GetChatAdsOutput getChatAdsOutput) {
                    ChatUtils.this.isChatAdsLoading = false;
                    if (getChatAdsOutput.apply_ads) {
                        if (getChatAdsOutput.chat_ads == null) {
                            getChatAdsOutput.chat_ads = new ArrayList<>();
                        }
                        keyValueStorageHelper.setChatAds(getChatAdsOutput.chat_ads, getChatAdsOutput.new_state, System.currentTimeMillis());
                    } else {
                        keyValueStorageHelper.setChatAdsStateAndTime(getChatAdsOutput.new_state, System.currentTimeMillis());
                    }
                    absNotificationCenter.chatAdsDidLoad();
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    ChatUtils.this.isChatAdsLoading = false;
                }
            });
        } catch (Exception e) {
            this.isChatAdsLoading = false;
            this.coreLog.handleException(e);
        }
    }

    public void actionOnChatAds(final String str, final ActionOnChatAdsInput.Action action, String str2, NetworkHelper networkHelper, KeyValueStorageHelper keyValueStorageHelper, final AbsNotificationCenter absNotificationCenter) {
        if (action == ActionOnChatAdsInput.Action.View && this.viewedChatAds.contains(str)) {
            return;
        }
        ActionOnChatAdsInput actionOnChatAdsInput = new ActionOnChatAdsInput();
        actionOnChatAdsInput.action = action;
        actionOnChatAdsInput.chat_ads_id = str;
        try {
            networkHelper.actionOnChatAds(str2, actionOnChatAdsInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<ActionOnChatAdsOutput>() { // from class: ir.aaap.messengercore.ChatUtils.21
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(ActionOnChatAdsOutput actionOnChatAdsOutput) {
                    ChatUtils.this.viewedChatAds.add(str);
                    ActionOnChatAdsInput.Action action2 = action;
                    if (action2 == ActionOnChatAdsInput.Action.Report || action2 == ActionOnChatAdsInput.Action.DontShow) {
                        ChatUtils.this.dontShowAds.add(str);
                        absNotificationCenter.chatAdsDidLoad();
                    }
                }
            });
        } catch (Exception e) {
            this.coreLog.handleException(e);
        }
    }

    public void getChatsAndAbsFromServer(String str, NetworkHelper networkHelper, final DBHelper dBHelper, final KeyValueStorageHelper keyValueStorageHelper, final AbsNotificationCenter absNotificationCenter, final String str2, final GetChatsListener getChatsListener) {
        GetChatsInput getChatsInput = new GetChatsInput(str2);
        boolean z = true;
        try {
            this.isChatLoadMoreInProgress = true;
            if (str2 != null) {
                z = false;
            }
            absNotificationCenter.dialogsLoadingChanged(z);
            this.lastGetChatListRequestId = networkHelper.getChats(str, getChatsInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetChatsOutput>() { // from class: ir.aaap.messengercore.ChatUtils.22
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(GetChatsOutput getChatsOutput) {
                    String str3;
                    ChatUtils.this.isChatLoadMoreInProgress = false;
                    absNotificationCenter.dialogsLoadingChanged(ChatUtils.this.isChatLoadMoreInProgress);
                    GetChatsResult getChatsResult = new GetChatsResult();
                    getChatsResult.fromDb = false;
                    getChatsResult.timeStamp = getChatsOutput.timestamp;
                    getChatsResult.chats = new ArrayList<>();
                    getChatsResult.absObjects = new ArrayList<>();
                    if (str2 == null) {
                        dBHelper.removeAllChats();
                        keyValueStorageHelper.setChatsStateAndUpdateTime(null, 0L);
                    }
                    if (getChatsOutput.chats != null) {
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        Iterator<ChatFromServer> it = getChatsOutput.chats.iterator();
                        while (it.hasNext()) {
                            ChatFromServer next = it.next();
                            arrayList.add(Chat.createFromServerObject(next, getChatsOutput.timestamp));
                            arrayList2.add(next.abs_object);
                        }
                        getChatsResult.chats.addAll(arrayList);
                        getChatsResult.absObjects.addAll(arrayList2);
                        dBHelper.addAllChats(arrayList);
                        dBHelper.addAllAbsObject(arrayList2, getChatsOutput.timestamp);
                    }
                    if (str2 == null && (str3 = getChatsOutput.state) != null) {
                        keyValueStorageHelper.setChatsStateAndUpdateTime(str3, System.currentTimeMillis());
                    }
                    String str4 = getChatsOutput.next_start_id;
                    if (str4 != null) {
                        keyValueStorageHelper.setChatsNextStartId(str4);
                        ChatUtils.this.chatsNextStartId = getChatsOutput.next_start_id;
                    }
                    keyValueStorageHelper.setChatsHasContinue(getChatsOutput.has_continue);
                    ChatUtils.this.chatListHasContinue = getChatsOutput.has_continue;
                    GetChatsListener getChatsListener2 = getChatsListener;
                    if (getChatsListener2 != null) {
                        getChatsListener2.onResponse(getChatsResult);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    ChatUtils.this.isChatLoadMoreInProgress = false;
                    absNotificationCenter.dialogsLoadingChanged(ChatUtils.this.isChatLoadMoreInProgress);
                    GetChatsListener getChatsListener2 = getChatsListener;
                    if (getChatsListener2 != null) {
                        getChatsListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            this.isChatLoadMoreInProgress = false;
            absNotificationCenter.dialogsLoadingChanged(false);
            if (getChatsListener != null) {
                getChatsListener.onError(e);
            }
            this.coreLog.handleException(e);
        }
    }

    public void loadAbsObjectsIfNeeded(String str, NetworkHelper networkHelper, DBHelper dBHelper, Set<String> set, boolean z, LoadListener<Set<String>> loadListener) {
        if (set == null) {
            if (loadListener != null) {
                loadListener.onDidLoad(new HashSet());
                return;
            }
            return;
        }
        if (set.size() == 0) {
            if (loadListener != null) {
                loadListener.onDidLoad(set);
                return;
            }
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        if (z) {
            arrayList.addAll(set);
        } else {
            for (String str2 : set) {
                ChatAbsObject absObject = dBHelper.getAbsObject(str2);
                if (absObject == null) {
                    arrayList.add(str2);
                } else {
                    addToAbsMap(absObject, absObject.timeStamp);
                }
            }
        }
        if (arrayList.size() > 0) {
            getAbsObjectsFromServer(str, networkHelper, dBHelper, arrayList, loadListener);
        } else if (loadListener != null) {
            loadListener.onDidLoad(set);
        }
    }

    public void getAbsObjectsFromServer(String str, NetworkHelper networkHelper, DBHelper dBHelper, ArrayList<String> arrayList, LoadListener<Set<String>> loadListener) {
        new LoadChatAbsHelper(str, networkHelper, dBHelper, loadListener).getAbsObjectsFromServer(arrayList, new HashSet());
    }

    public void startContactList() {
        this.contactIsStarted = true;
    }

    public void stopContactList() {
        this.contactIsStarted = false;
    }

    public void getContactLastOnlineFromServer(String str, NetworkHelper networkHelper, DBHelper dBHelper, AbsNotificationCenter absNotificationCenter, TimerHelper timerHelper, final LoadListener<Integer> loadListener) {
        ArrayList<String> recentContacts = dBHelper.getRecentContacts();
        if (recentContacts.size() == 0) {
            return;
        }
        new GetContactsLastOnlineHelper(str, networkHelper, dBHelper, absNotificationCenter, timerHelper, new LoadListener<Integer>(this) { // from class: ir.aaap.messengercore.ChatUtils.23
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(Integer num) {
                LoadListener loadListener2 = loadListener;
                if (loadListener2 != null) {
                    loadListener2.onDidLoad(num);
                }
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                LoadListener loadListener2 = loadListener;
                if (loadListener2 != null) {
                    loadListener2.onError(exc);
                }
            }
        }).getContactsLastOnline(new ArrayList(recentContacts));
    }

    public void getAvatars(String str, NetworkHelper networkHelper, final String str2, final GetAvatarsListener getAvatarsListener) {
        HashSet<Chat.ChatAccessEnum> hashSet;
        if (getAvatarsListener == null || str2 == null) {
            return;
        }
        Chat chatInstant = getChatInstant(str2);
        if (chatInstant != null && (hashSet = chatInstant.access) != null && !hashSet.contains(Chat.ChatAccessEnum.ViewInfo)) {
            getAvatarsListener.onAvatarsDidLoad(new ArrayList<>());
            return;
        }
        if (this.avatarsLoadingSet.contains(str2)) {
            return;
        }
        this.avatarsLoadingSet.add(str2);
        try {
            networkHelper.getAvatars(str, new GetAvatarsInput(str2), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetAvatarsOutput>() { // from class: ir.aaap.messengercore.ChatUtils.24
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(GetAvatarsOutput getAvatarsOutput) {
                    GetAvatarsListener getAvatarsListener2;
                    ChatUtils.this.avatarsLoadingSet.remove(str2);
                    if (getAvatarsOutput == null || (getAvatarsListener2 = getAvatarsListener) == null) {
                        return;
                    }
                    getAvatarsListener2.onAvatarsDidLoad(getAvatarsOutput.avatars);
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    ChatUtils.this.avatarsLoadingSet.remove(str2);
                    GetAvatarsListener getAvatarsListener2 = getAvatarsListener;
                    if (getAvatarsListener2 != null) {
                        getAvatarsListener2.onAvatarsLoadingFailed();
                    }
                }
            });
        } catch (Exception e) {
            this.avatarsLoadingSet.remove(str2);
            getAvatarsListener.onAvatarsLoadingFailed();
            this.coreLog.handleException(e);
        }
    }

    public void uploadAvatar(String str, String str2, String str3, String str4, NetworkHelper networkHelper, DBHelper dBHelper, final UpdateChatAndMessageUsecase updateChatAndMessageUsecase, final LoadListener<AvatarFileInline> loadListener) {
        if (CoreUtilities.isNotEmpty(str2) && CoreUtilities.isNotEmpty(str3)) {
            UploadAvatarInput uploadAvatarInput = new UploadAvatarInput();
            uploadAvatarInput.object_guid = str2;
            uploadAvatarInput.main_file_id = str3;
            uploadAvatarInput.thumbnail_file_id = str4;
            try {
                networkHelper.uploadAvatar(str, uploadAvatarInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<UploadOrDeleteAvatarOutput>(this) { // from class: ir.aaap.messengercore.ChatUtils.25
                    @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                    public void onResponse(UploadOrDeleteAvatarOutput uploadOrDeleteAvatarOutput) {
                        if (uploadOrDeleteAvatarOutput != null) {
                            updateChatAndMessageUsecase.processMessageAndChatUpdate(uploadOrDeleteAvatarOutput.message_update, uploadOrDeleteAvatarOutput.chat_update, false, true);
                            UserInfoFromServer userInfoFromServer = uploadOrDeleteAvatarOutput.user;
                            AvatarFileInline avatarFileInline = userInfoFromServer != null ? userInfoFromServer.avatar_thumbnail : null;
                            GroupInfoFromServer groupInfoFromServer = uploadOrDeleteAvatarOutput.group;
                            if (groupInfoFromServer != null) {
                                avatarFileInline = groupInfoFromServer.avatar_thumbnail;
                            }
                            ChannelInfoFromServer channelInfoFromServer = uploadOrDeleteAvatarOutput.channel;
                            if (channelInfoFromServer != null) {
                                avatarFileInline = channelInfoFromServer.avatar_thumbnail;
                            }
                            LoadListener loadListener2 = loadListener;
                            if (loadListener2 != null) {
                                loadListener2.onDidLoad(avatarFileInline);
                                return;
                            }
                            return;
                        }
                        LoadListener loadListener3 = loadListener;
                        if (loadListener3 != null) {
                            loadListener3.onError(new ApiServerException());
                        }
                    }

                    @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                    public void onError(Exception exc) {
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onError(exc);
                        }
                    }
                });
            } catch (Exception e) {
                if (loadListener != null) {
                    loadListener.onError(e);
                }
                this.coreLog.handleException(e);
            }
        }
    }

    public void deleteAvatar(String str, String str2, String str3, NetworkHelper networkHelper, DBHelper dBHelper, final UpdateChatAndMessageUsecase updateChatAndMessageUsecase, final LoadListener<AvatarFileInline> loadListener) {
        if (CoreUtilities.isNotEmpty(str2) && CoreUtilities.isNotEmpty(str3)) {
            DeleteAvatarInput deleteAvatarInput = new DeleteAvatarInput();
            deleteAvatarInput.object_guid = str2;
            deleteAvatarInput.avatar_id = str3;
            try {
                networkHelper.deleteAvatar(str, deleteAvatarInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<UploadOrDeleteAvatarOutput>(this) { // from class: ir.aaap.messengercore.ChatUtils.26
                    @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                    public void onResponse(UploadOrDeleteAvatarOutput uploadOrDeleteAvatarOutput) {
                        ChatFromServer chatFromServer;
                        if (uploadOrDeleteAvatarOutput != null) {
                            updateChatAndMessageUsecase.processMessageAndChatUpdate(uploadOrDeleteAvatarOutput.message_update, uploadOrDeleteAvatarOutput.chat_update, false, true);
                            LoadListener loadListener2 = loadListener;
                            if (loadListener2 != null) {
                                ChatUpdateObject chatUpdateObject = uploadOrDeleteAvatarOutput.chat_update;
                                if (chatUpdateObject != null && (chatFromServer = chatUpdateObject.chat) != null) {
                                    loadListener2.onDidLoad(chatFromServer.abs_object.avatar_thumbnail);
                                    return;
                                } else {
                                    loadListener2.onDidLoad(null);
                                    return;
                                }
                            }
                            return;
                        }
                        LoadListener loadListener3 = loadListener;
                        if (loadListener3 != null) {
                            loadListener3.onDidLoad(null);
                        }
                    }

                    @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                    public void onError(Exception exc) {
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onError(exc);
                        }
                    }
                });
            } catch (Exception e) {
                if (loadListener != null) {
                    loadListener.onError(e);
                }
                this.coreLog.handleException(e);
            }
        }
    }

    public int getGroupAllMembersFromServer(String str, NetworkHelper networkHelper, final DBHelper dBHelper, String str2, String str3, String str4, final GetMemberListener getMemberListener) {
        HashSet<Chat.ChatAccessEnum> hashSet;
        Chat chatInstant = getChatInstant(str2);
        if (chatInstant != null && (hashSet = chatInstant.access) != null && !hashSet.contains(Chat.ChatAccessEnum.ViewMembers)) {
            if (getMemberListener != null) {
                getMemberListener.onMembersDidLoad(new ArrayList<>(), false, null);
            }
            return 0;
        }
        GetGroupMembersInput getGroupMembersInput = new GetGroupMembersInput();
        getGroupMembersInput.group_guid = str2;
        getGroupMembersInput.start_id = str3;
        if (!CoreUtilities.isNotEmpty(str4)) {
            str4 = null;
        }
        getGroupMembersInput.search_text = str4;
        try {
            return networkHelper.getGroupAllMembers(str, getGroupMembersInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetGroupMembersOutput>() { // from class: ir.aaap.messengercore.ChatUtils.27
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(GetGroupMembersOutput getGroupMembersOutput) {
                    ArrayList<InChatMember> arrayListProcessMembers = ChatUtils.this.processMembers(getGroupMembersOutput.in_chat_members, getGroupMembersOutput.timestamp, dBHelper);
                    GetMemberListener getMemberListener2 = getMemberListener;
                    if (getMemberListener2 != null) {
                        getMemberListener2.onMembersDidLoad(arrayListProcessMembers, getGroupMembersOutput.has_continue, getGroupMembersOutput.next_start_id);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    GetMemberListener getMemberListener2 = getMemberListener;
                    if (getMemberListener2 != null) {
                        getMemberListener2.onMembersLoadingFailed();
                    }
                }
            });
        } catch (Exception e) {
            if (getMemberListener != null) {
                getMemberListener.onMembersLoadingFailed();
            }
            this.coreLog.handleException(e);
            return 0;
        }
    }

    public int getGroupNotAdminMembersFromServer(String str, NetworkHelper networkHelper, final DBHelper dBHelper, String str2, String str3, String str4, final GetMemberListener getMemberListener) {
        GetGroupMembersInput getGroupMembersInput = new GetGroupMembersInput();
        getGroupMembersInput.group_guid = str2;
        getGroupMembersInput.start_id = str3;
        if (!CoreUtilities.isNotEmpty(str4)) {
            str4 = null;
        }
        getGroupMembersInput.search_text = str4;
        try {
            return networkHelper.getGroupAllMembers(str, getGroupMembersInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetGroupMembersOutput>() { // from class: ir.aaap.messengercore.ChatUtils.28
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(GetGroupMembersOutput getGroupMembersOutput) {
                    ArrayList arrayListProcessMembers = ChatUtils.this.processMembers(getGroupMembersOutput.in_chat_members, getGroupMembersOutput.timestamp, dBHelper);
                    ArrayList<InChatMember> arrayList = new ArrayList<>();
                    Iterator it = arrayListProcessMembers.iterator();
                    while (it.hasNext()) {
                        InChatMember inChatMember = (InChatMember) it.next();
                        InChatMemberFromServer.JoinTypeEnum joinTypeEnum = inChatMember.join_type;
                        if (joinTypeEnum != InChatMemberFromServer.JoinTypeEnum.Admin && joinTypeEnum != InChatMemberFromServer.JoinTypeEnum.Creator) {
                            arrayList.add(inChatMember);
                        }
                    }
                    GetMemberListener getMemberListener2 = getMemberListener;
                    if (getMemberListener2 != null) {
                        getMemberListener2.onMembersDidLoad(arrayList, getGroupMembersOutput.has_continue, getGroupMembersOutput.next_start_id);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    GetMemberListener getMemberListener2 = getMemberListener;
                    if (getMemberListener2 != null) {
                        getMemberListener2.onMembersLoadingFailed();
                    }
                }
            });
        } catch (Exception e) {
            if (getMemberListener != null) {
                getMemberListener.onMembersLoadingFailed();
            }
            this.coreLog.handleException(e);
            return 0;
        }
    }

    public int getChannelAllMembersFromServer(String str, NetworkHelper networkHelper, final DBHelper dBHelper, String str2, String str3, String str4, final GetMemberListener getMemberListener) {
        GetChannelMembersInput getChannelMembersInput = new GetChannelMembersInput();
        getChannelMembersInput.channel_guid = str2;
        getChannelMembersInput.start_id = str3;
        if (!CoreUtilities.isNotEmpty(str4)) {
            str4 = null;
        }
        getChannelMembersInput.search_text = str4;
        try {
            return networkHelper.getChannelAllMembers(str, getChannelMembersInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetChannelMembersOutput>() { // from class: ir.aaap.messengercore.ChatUtils.29
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(GetChannelMembersOutput getChannelMembersOutput) {
                    ArrayList<InChatMember> arrayListProcessMembers = ChatUtils.this.processMembers(getChannelMembersOutput.in_chat_members, getChannelMembersOutput.timestamp, dBHelper);
                    GetMemberListener getMemberListener2 = getMemberListener;
                    if (getMemberListener2 != null) {
                        getMemberListener2.onMembersDidLoad(arrayListProcessMembers, getChannelMembersOutput.has_continue, getChannelMembersOutput.next_start_id);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    GetMemberListener getMemberListener2 = getMemberListener;
                    if (getMemberListener2 != null) {
                        getMemberListener2.onMembersLoadingFailed();
                    }
                }
            });
        } catch (Exception e) {
            if (getMemberListener != null) {
                getMemberListener.onMembersLoadingFailed();
            }
            this.coreLog.handleException(e);
            return 0;
        }
    }

    public int getChannelNotAdminMembersFromServer(String str, NetworkHelper networkHelper, final DBHelper dBHelper, String str2, String str3, String str4, final GetMemberListener getMemberListener) {
        GetChannelMembersInput getChannelMembersInput = new GetChannelMembersInput();
        getChannelMembersInput.channel_guid = str2;
        getChannelMembersInput.start_id = str3;
        getChannelMembersInput.search_text = str4;
        try {
            return networkHelper.getChannelAllMembers(str, getChannelMembersInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetChannelMembersOutput>() { // from class: ir.aaap.messengercore.ChatUtils.30
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(GetChannelMembersOutput getChannelMembersOutput) {
                    ArrayList arrayListProcessMembers = ChatUtils.this.processMembers(getChannelMembersOutput.in_chat_members, getChannelMembersOutput.timestamp, dBHelper);
                    ArrayList<InChatMember> arrayList = new ArrayList<>();
                    Iterator it = arrayListProcessMembers.iterator();
                    while (it.hasNext()) {
                        InChatMember inChatMember = (InChatMember) it.next();
                        InChatMemberFromServer.JoinTypeEnum joinTypeEnum = inChatMember.join_type;
                        if (joinTypeEnum != InChatMemberFromServer.JoinTypeEnum.Admin && joinTypeEnum != InChatMemberFromServer.JoinTypeEnum.Creator) {
                            arrayList.add(inChatMember);
                        }
                    }
                    GetMemberListener getMemberListener2 = getMemberListener;
                    if (getMemberListener2 != null) {
                        getMemberListener2.onMembersDidLoad(arrayList, getChannelMembersOutput.has_continue, getChannelMembersOutput.next_start_id);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    GetMemberListener getMemberListener2 = getMemberListener;
                    if (getMemberListener2 != null) {
                        getMemberListener2.onMembersLoadingFailed();
                    }
                }
            });
        } catch (Exception e) {
            if (getMemberListener != null) {
                getMemberListener.onMembersLoadingFailed();
            }
            this.coreLog.handleException(e);
            return 0;
        }
    }

    public int getGroupBannedMembersFromServer(String str, NetworkHelper networkHelper, final DBHelper dBHelper, String str2, String str3, String str4, final GetMemberListener getMemberListener) {
        GetGroupMembersInput getGroupMembersInput = new GetGroupMembersInput();
        getGroupMembersInput.group_guid = str2;
        getGroupMembersInput.start_id = str3;
        getGroupMembersInput.search_text = str4;
        try {
            return networkHelper.getBannedGroupMembers(str, getGroupMembersInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetGroupMembersOutput>() { // from class: ir.aaap.messengercore.ChatUtils.31
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(GetGroupMembersOutput getGroupMembersOutput) {
                    ArrayList<InChatMember> arrayListProcessMembers = ChatUtils.this.processMembers(getGroupMembersOutput.in_chat_members, getGroupMembersOutput.timestamp, dBHelper);
                    GetMemberListener getMemberListener2 = getMemberListener;
                    if (getMemberListener2 != null) {
                        getMemberListener2.onMembersDidLoad(arrayListProcessMembers, getGroupMembersOutput.has_continue, getGroupMembersOutput.next_start_id);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    GetMemberListener getMemberListener2 = getMemberListener;
                    if (getMemberListener2 != null) {
                        getMemberListener2.onMembersLoadingFailed();
                    }
                }
            });
        } catch (Exception e) {
            if (getMemberListener != null) {
                getMemberListener.onMembersLoadingFailed();
            }
            this.coreLog.handleException(e);
            return 0;
        }
    }

    public int getChannelBannedMembersFromServer(String str, NetworkHelper networkHelper, final DBHelper dBHelper, String str2, String str3, String str4, final GetMemberListener getMemberListener) {
        GetChannelMembersInput getChannelMembersInput = new GetChannelMembersInput();
        getChannelMembersInput.channel_guid = str2;
        getChannelMembersInput.start_id = str3;
        getChannelMembersInput.search_text = str4;
        try {
            return networkHelper.getBannedChannelMembers(str, getChannelMembersInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetChannelMembersOutput>() { // from class: ir.aaap.messengercore.ChatUtils.32
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(GetChannelMembersOutput getChannelMembersOutput) {
                    ArrayList<InChatMember> arrayListProcessMembers = ChatUtils.this.processMembers(getChannelMembersOutput.in_chat_members, getChannelMembersOutput.timestamp, dBHelper);
                    GetMemberListener getMemberListener2 = getMemberListener;
                    if (getMemberListener2 != null) {
                        getMemberListener2.onMembersDidLoad(arrayListProcessMembers, getChannelMembersOutput.has_continue, getChannelMembersOutput.next_start_id);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    GetMemberListener getMemberListener2 = getMemberListener;
                    if (getMemberListener2 != null) {
                        getMemberListener2.onMembersLoadingFailed();
                    }
                }
            });
        } catch (Exception e) {
            if (getMemberListener != null) {
                getMemberListener.onMembersLoadingFailed();
            }
            this.coreLog.handleException(e);
            return 0;
        }
    }

    public int getGroupMentionListFromServer(String str, String str2, String str3, String str4, NetworkHelper networkHelper, final DBHelper dBHelper, final GetMemberListener getMemberListener) {
        GetGroupMentionListInput getGroupMentionListInput = new GetGroupMentionListInput();
        getGroupMentionListInput.group_guid = str;
        getGroupMentionListInput.start_id = str2;
        if (str3 == null || str3.isEmpty()) {
            str3 = null;
        }
        getGroupMentionListInput.search_mention = str3;
        try {
            return networkHelper.getGroupMentionList(str4, getGroupMentionListInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetGroupMembersOutput>() { // from class: ir.aaap.messengercore.ChatUtils.33
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(GetGroupMembersOutput getGroupMembersOutput) {
                    ArrayList<InChatMember> arrayListProcessMembers = ChatUtils.this.processMembers(getGroupMembersOutput.in_chat_members, getGroupMembersOutput.timestamp, dBHelper);
                    GetMemberListener getMemberListener2 = getMemberListener;
                    if (getMemberListener2 != null) {
                        getMemberListener2.onMembersDidLoad(arrayListProcessMembers, getGroupMembersOutput.has_continue, getGroupMembersOutput.next_start_id);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    GetMemberListener getMemberListener2 = getMemberListener;
                    if (getMemberListener2 != null) {
                        getMemberListener2.onMembersLoadingFailed();
                    }
                }
            });
        } catch (Exception e) {
            if (getMemberListener != null) {
                getMemberListener.onMembersLoadingFailed();
            }
            this.coreLog.handleException(e);
            return 0;
        }
    }

    public int getGroupAdminsFromServer(String str, String str2, String str3, String str4, NetworkHelper networkHelper, final DBHelper dBHelper, final GetMemberListener getMemberListener) {
        GetGroupMembersInput getGroupMembersInput = new GetGroupMembersInput();
        getGroupMembersInput.group_guid = str;
        getGroupMembersInput.start_id = str2;
        getGroupMembersInput.search_text = str3;
        try {
            return networkHelper.getGroupAdminMembers(str4, getGroupMembersInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetGroupMembersOutput>() { // from class: ir.aaap.messengercore.ChatUtils.34
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(GetGroupMembersOutput getGroupMembersOutput) {
                    ArrayList<InChatMember> arrayListProcessMembers = ChatUtils.this.processMembers(getGroupMembersOutput.in_chat_members, getGroupMembersOutput.timestamp, dBHelper);
                    GetMemberListener getMemberListener2 = getMemberListener;
                    if (getMemberListener2 != null) {
                        getMemberListener2.onMembersDidLoad(arrayListProcessMembers, getGroupMembersOutput.has_continue, getGroupMembersOutput.next_start_id);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    GetMemberListener getMemberListener2 = getMemberListener;
                    if (getMemberListener2 != null) {
                        getMemberListener2.onMembersLoadingFailed();
                    }
                }
            });
        } catch (Exception e) {
            if (getMemberListener != null) {
                getMemberListener.onMembersLoadingFailed();
            }
            this.coreLog.handleException(e);
            return 0;
        }
    }

    public int getChannelAdminsFromServer(String str, String str2, String str3, String str4, NetworkHelper networkHelper, final DBHelper dBHelper, final GetMemberListener getMemberListener) {
        GetChannelMembersInput getChannelMembersInput = new GetChannelMembersInput();
        getChannelMembersInput.channel_guid = str;
        getChannelMembersInput.start_id = str2;
        getChannelMembersInput.search_text = str3;
        try {
            return networkHelper.getChannelAdminMembers(str4, getChannelMembersInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetChannelMembersOutput>() { // from class: ir.aaap.messengercore.ChatUtils.35
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(GetChannelMembersOutput getChannelMembersOutput) {
                    ArrayList<InChatMember> arrayListProcessMembers = ChatUtils.this.processMembers(getChannelMembersOutput.in_chat_members, getChannelMembersOutput.timestamp, dBHelper);
                    GetMemberListener getMemberListener2 = getMemberListener;
                    if (getMemberListener2 != null) {
                        getMemberListener2.onMembersDidLoad(arrayListProcessMembers, getChannelMembersOutput.has_continue, getChannelMembersOutput.next_start_id);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    GetMemberListener getMemberListener2 = getMemberListener;
                    if (getMemberListener2 != null) {
                        getMemberListener2.onMembersLoadingFailed();
                    }
                }
            });
        } catch (Exception e) {
            if (getMemberListener != null) {
                getMemberListener.onMembersLoadingFailed();
            }
            this.coreLog.handleException(e);
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public InChatMember processMember(InChatMemberFromServer inChatMemberFromServer, long j, DBHelper dBHelper) {
        ArrayList<InChatMemberFromServer> arrayList = new ArrayList<>();
        arrayList.add(inChatMemberFromServer);
        ArrayList<InChatMember> arrayListProcessMembers = processMembers(arrayList, j, dBHelper);
        if (arrayListProcessMembers == null || arrayListProcessMembers.size() <= 0) {
            return null;
        }
        return arrayListProcessMembers.get(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<InChatMember> processMembers(ArrayList<InChatMemberFromServer> arrayList, long j, DBHelper dBHelper) {
        UserInfo userInfo;
        ArrayList<InChatMember> arrayList2 = new ArrayList<>();
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList<ChatAbsObject> arrayList3 = new ArrayList<>();
            Iterator<InChatMemberFromServer> it = arrayList.iterator();
            while (it.hasNext()) {
                InChatMemberFromServer next = it.next();
                arrayList3.add(ChatAbsObject.createFromInChatMember(next, j));
                InChatMember inChatMemberCreateFromServerObject = InChatMember.createFromServerObject(next, j);
                ObjectInfo objectInfoInstant = getObjectInfoInstant(inChatMemberCreateFromServerObject.member_guid);
                if (objectInfoInstant != null && (userInfo = objectInfoInstant.userInfo) != null) {
                    objectInfoInstant.userInfo = UserInfo.updateFromMemberObject(userInfo, next, j);
                    addToInfoMap(objectInfoInstant);
                    dBHelper.addUserInfo(objectInfoInstant.userInfo, objectInfoInstant.insertedToDbTime);
                }
                arrayList2.add(inChatMemberCreateFromServerObject);
            }
            addToMemberMap(arrayList2);
            addToAbsMap(arrayList3, j);
            dBHelper.addAllAbsObject(arrayList3, j);
        }
        return arrayList2;
    }

    public void getGroupAdminAccessList(final String str, final String str2, String str3, NetworkHelper networkHelper, DBHelper dBHelper, final GetGroupAdminAccessListListener getGroupAdminAccessListListener) {
        try {
            networkHelper.getGroupAdminAccessList(str3, new GetGroupAdminAccessListInput(str, str2), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetGroupAdminAccessListOutput>(this) { // from class: ir.aaap.messengercore.ChatUtils.36
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(GetGroupAdminAccessListOutput getGroupAdminAccessListOutput) {
                    Set<Chat.EnumSetGroupAdminAccess> set = getGroupAdminAccessListOutput.access_list;
                    if (set != null) {
                        GetGroupAdminAccessListListener getGroupAdminAccessListListener2 = getGroupAdminAccessListListener;
                        if (getGroupAdminAccessListListener2 != null) {
                            getGroupAdminAccessListListener2.onAccessDidLoad(str, str2, set);
                            return;
                        }
                        return;
                    }
                    GetGroupAdminAccessListListener getGroupAdminAccessListListener3 = getGroupAdminAccessListListener;
                    if (getGroupAdminAccessListListener3 != null) {
                        getGroupAdminAccessListListener3.onAccessLoadingFailed();
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    GetGroupAdminAccessListListener getGroupAdminAccessListListener2 = getGroupAdminAccessListListener;
                    if (getGroupAdminAccessListListener2 != null) {
                        getGroupAdminAccessListListener2.onAccessLoadingFailed();
                    }
                }
            });
        } catch (Exception e) {
            if (getGroupAdminAccessListListener != null) {
                getGroupAdminAccessListListener.onAccessLoadingFailed();
            }
            this.coreLog.handleException(e);
        }
    }

    public void getChannelAdminAccessList(final String str, final String str2, String str3, NetworkHelper networkHelper, final GetChannelAdminAccessListListener getChannelAdminAccessListListener) {
        try {
            networkHelper.getChannelAdminAccessList(str3, new GetChannelAdminAccessInput(str, str2), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetChannelAdminAccessListOutput>(this) { // from class: ir.aaap.messengercore.ChatUtils.37
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(GetChannelAdminAccessListOutput getChannelAdminAccessListOutput) {
                    Set<Chat.EnumSetChannelAdminAccess> set = getChannelAdminAccessListOutput.access_list;
                    if (set != null) {
                        GetChannelAdminAccessListListener getChannelAdminAccessListListener2 = getChannelAdminAccessListListener;
                        if (getChannelAdminAccessListListener2 != null) {
                            getChannelAdminAccessListListener2.onAccessDidLoad(str, str2, set);
                            return;
                        }
                        return;
                    }
                    GetChannelAdminAccessListListener getChannelAdminAccessListListener3 = getChannelAdminAccessListListener;
                    if (getChannelAdminAccessListListener3 != null) {
                        getChannelAdminAccessListListener3.onAccessLoadingFailed();
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    GetChannelAdminAccessListListener getChannelAdminAccessListListener2 = getChannelAdminAccessListListener;
                    if (getChannelAdminAccessListListener2 != null) {
                        getChannelAdminAccessListListener2.onAccessLoadingFailed();
                    }
                }
            });
        } catch (Exception e) {
            if (getChannelAdminAccessListListener != null) {
                getChannelAdminAccessListListener.onAccessLoadingFailed();
            }
            this.coreLog.handleException(e);
        }
    }

    public void getGroupDefaultAccess(final String str, String str2, NetworkHelper networkHelper, final GetGroupDefaultAccessListListener getGroupDefaultAccessListListener) {
        try {
            networkHelper.getGroupDefaultAccess(str2, new GetGroupDefaultAccessInput(str), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetGroupDefaultAccessOutput>(this) { // from class: ir.aaap.messengercore.ChatUtils.38
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(GetGroupDefaultAccessOutput getGroupDefaultAccessOutput) {
                    Set<Chat.EnumSetGroupMemberAccess> set = getGroupDefaultAccessOutput.access_list;
                    if (set != null) {
                        GetGroupDefaultAccessListListener getGroupDefaultAccessListListener2 = getGroupDefaultAccessListListener;
                        if (getGroupDefaultAccessListListener2 != null) {
                            getGroupDefaultAccessListListener2.onAccessDidLoad(str, set);
                            return;
                        }
                        return;
                    }
                    GetGroupDefaultAccessListListener getGroupDefaultAccessListListener3 = getGroupDefaultAccessListListener;
                    if (getGroupDefaultAccessListListener3 != null) {
                        getGroupDefaultAccessListListener3.onAccessLoadingFailed();
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    GetGroupDefaultAccessListListener getGroupDefaultAccessListListener2 = getGroupDefaultAccessListListener;
                    if (getGroupDefaultAccessListListener2 != null) {
                        getGroupDefaultAccessListListener2.onAccessLoadingFailed();
                    }
                }
            });
        } catch (Exception e) {
            if (getGroupDefaultAccessListListener != null) {
                getGroupDefaultAccessListListener.onAccessLoadingFailed();
            }
            this.coreLog.handleException(e);
        }
    }

    public void setGroupDefaultAccess(String str, ArrayList<Chat.EnumSetGroupMemberAccess> arrayList, String str2, NetworkHelper networkHelper) {
        if (arrayList == null) {
            return;
        }
        SetGroupDefaultAccessInput setGroupDefaultAccessInput = new SetGroupDefaultAccessInput();
        setGroupDefaultAccessInput.group_guid = str;
        setGroupDefaultAccessInput.access_list = arrayList;
        try {
            networkHelper.setGroupDefaultAccess(str2, setGroupDefaultAccessInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<SetGroupDefaultAccessOutput>(this) { // from class: ir.aaap.messengercore.ChatUtils.39
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(SetGroupDefaultAccessOutput setGroupDefaultAccessOutput) {
                }
            });
        } catch (Exception e) {
            this.coreLog.handleException(e);
        }
    }

    public void setGroupAdmin(String str, String str2, ArrayList<Chat.EnumSetGroupAdminAccess> arrayList, String str3, String str4, NetworkHelper networkHelper, DBHelper dBHelper, UpdateGroupVoiceChatUsecase updateGroupVoiceChatUsecase, LoadListener<InChatMember> loadListener) {
        setUnsetGroupAdmin(str, str2, true, arrayList, str3, str4, networkHelper, dBHelper, updateGroupVoiceChatUsecase, loadListener);
    }

    public void unsetGroupAdmin(String str, String str2, String str3, NetworkHelper networkHelper, DBHelper dBHelper, UpdateGroupVoiceChatUsecase updateGroupVoiceChatUsecase, LoadListener<InChatMember> loadListener) {
        setUnsetGroupAdmin(str, str2, false, null, null, str3, networkHelper, dBHelper, updateGroupVoiceChatUsecase, loadListener);
    }

    public void setChannelAdmin(String str, String str2, ChatType chatType, ArrayList<Chat.EnumSetChannelAdminAccess> arrayList, String str3, NetworkHelper networkHelper, DBHelper dBHelper, UpdateGroupVoiceChatUsecase updateGroupVoiceChatUsecase, LoadListener<InChatMember> loadListener) {
        if (chatType == ChatType.Bot) {
            setUnsetChannelBotAdmin(str, str2, true, arrayList, str3, networkHelper, dBHelper, updateGroupVoiceChatUsecase, loadListener);
        } else {
            setUnsetChannelAdmin(str, str2, true, arrayList, str3, networkHelper, dBHelper, updateGroupVoiceChatUsecase, loadListener);
        }
    }

    public void unsetChannelAdmin(String str, String str2, ChatType chatType, String str3, NetworkHelper networkHelper, DBHelper dBHelper, UpdateGroupVoiceChatUsecase updateGroupVoiceChatUsecase, LoadListener<InChatMember> loadListener) {
        if (chatType == ChatType.Bot) {
            setUnsetChannelBotAdmin(str, str2, false, null, str3, networkHelper, dBHelper, updateGroupVoiceChatUsecase, loadListener);
        } else {
            setUnsetChannelAdmin(str, str2, false, null, str3, networkHelper, dBHelper, updateGroupVoiceChatUsecase, loadListener);
        }
    }

    public void setUnsetChannelBotAdmin(String str, String str2, boolean z, ArrayList<Chat.EnumSetChannelAdminAccess> arrayList, String str3, NetworkHelper networkHelper, final DBHelper dBHelper, UpdateGroupVoiceChatUsecase updateGroupVoiceChatUsecase, final LoadListener<InChatMember> loadListener) {
        SetChannelBotAdminInput setChannelBotAdminInput = new SetChannelBotAdminInput();
        setChannelBotAdminInput.channel_guid = str;
        setChannelBotAdminInput.bot_guid = str2;
        setChannelBotAdminInput.access_list = arrayList;
        setChannelBotAdminInput.action = z ? SetGroupAdminInput.AdminActionEnum.SetAdmin : SetGroupAdminInput.AdminActionEnum.UnsetAdmin;
        try {
            networkHelper.setChannelBotAdmin(str3, setChannelBotAdminInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<SetChannelBotAdminOutput>() { // from class: ir.aaap.messengercore.ChatUtils.40
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(SetChannelBotAdminOutput setChannelBotAdminOutput) {
                    if (setChannelBotAdminOutput != null) {
                        InChatMember inChatMemberProcessMember = ChatUtils.this.processMember(setChannelBotAdminOutput.in_chat_member, setChannelBotAdminOutput.timestamp, dBHelper);
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(inChatMemberProcessMember);
                        }
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.coreLog.handleException(e);
        }
    }

    public void setUnsetChannelAdmin(String str, String str2, boolean z, ArrayList<Chat.EnumSetChannelAdminAccess> arrayList, String str3, NetworkHelper networkHelper, final DBHelper dBHelper, final UpdateGroupVoiceChatUsecase updateGroupVoiceChatUsecase, final LoadListener<InChatMember> loadListener) {
        SetChannelAdminInput setChannelAdminInput = new SetChannelAdminInput();
        setChannelAdminInput.channel_guid = str;
        setChannelAdminInput.member_guid = str2;
        setChannelAdminInput.access_list = arrayList;
        setChannelAdminInput.action = z ? SetGroupAdminInput.AdminActionEnum.SetAdmin : SetGroupAdminInput.AdminActionEnum.UnsetAdmin;
        try {
            networkHelper.setChannelAdmin(str3, setChannelAdminInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<SetChannelAdminOutput>() { // from class: ir.aaap.messengercore.ChatUtils.41
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(SetChannelAdminOutput setChannelAdminOutput) {
                    if (setChannelAdminOutput != null) {
                        InChatMember inChatMemberProcessMember = ChatUtils.this.processMember(setChannelAdminOutput.in_chat_member, setChannelAdminOutput.timestamp, dBHelper);
                        UpdateGroupVoiceChatUsecase updateGroupVoiceChatUsecase2 = updateGroupVoiceChatUsecase;
                        if (updateGroupVoiceChatUsecase2 != null) {
                            updateGroupVoiceChatUsecase2.processGroupVoiceChatParticipants(setChannelAdminOutput.group_voice_chat_participate_update);
                        }
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(inChatMemberProcessMember);
                        }
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.coreLog.handleException(e);
        }
    }

    private void setUnsetGroupAdmin(String str, String str2, boolean z, ArrayList<Chat.EnumSetGroupAdminAccess> arrayList, String str3, String str4, NetworkHelper networkHelper, final DBHelper dBHelper, final UpdateGroupVoiceChatUsecase updateGroupVoiceChatUsecase, final LoadListener<InChatMember> loadListener) {
        SetGroupAdminInput setGroupAdminInput = new SetGroupAdminInput();
        setGroupAdminInput.group_guid = str;
        setGroupAdminInput.member_guid = str2;
        setGroupAdminInput.access_list = arrayList;
        if (CoreUtilities.isNotEmpty(str3)) {
            setGroupAdminInput.custom_title = str3;
        }
        setGroupAdminInput.action = z ? SetGroupAdminInput.AdminActionEnum.SetAdmin : SetGroupAdminInput.AdminActionEnum.UnsetAdmin;
        try {
            networkHelper.setGroupAdmin(str4, setGroupAdminInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<SetGroupAdminOutput>() { // from class: ir.aaap.messengercore.ChatUtils.42
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(SetGroupAdminOutput setGroupAdminOutput) {
                    if (setGroupAdminOutput != null) {
                        InChatMember inChatMemberProcessMember = ChatUtils.this.processMember(setGroupAdminOutput.in_chat_member, setGroupAdminOutput.timestamp, dBHelper);
                        UpdateGroupVoiceChatUsecase updateGroupVoiceChatUsecase2 = updateGroupVoiceChatUsecase;
                        if (updateGroupVoiceChatUsecase2 != null) {
                            updateGroupVoiceChatUsecase2.processGroupVoiceChatParticipants(setGroupAdminOutput.group_voice_chat_participate_update);
                        }
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(inChatMemberProcessMember);
                        }
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.coreLog.handleException(e);
        }
    }

    public void requestChangeObjectOwner(String str, String str2, String str3, NetworkHelper networkHelper, final LoadListener<ChangeOwnerModels.RequestChangeOwnerOutput> loadListener) {
        ChangeOwnerModels.RequestChangeOwnerInput requestChangeOwnerInput = new ChangeOwnerModels.RequestChangeOwnerInput();
        requestChangeOwnerInput.object_guid = str;
        requestChangeOwnerInput.new_owner_user_guid = str2;
        try {
            networkHelper.requestChangeObjectOwner(str3, requestChangeOwnerInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<ChangeOwnerModels.RequestChangeOwnerOutput>(this) { // from class: ir.aaap.messengercore.ChatUtils.43
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(ChangeOwnerModels.RequestChangeOwnerOutput requestChangeOwnerOutput) {
                    if (requestChangeOwnerOutput != null) {
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(requestChangeOwnerOutput);
                            return;
                        }
                        return;
                    }
                    LoadListener loadListener3 = loadListener;
                    if (loadListener3 != null) {
                        loadListener3.onError(new ApiServerException());
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.coreLog.handleException(e);
        }
    }

    public void getPendingObjectOwner(String str, String str2, NetworkHelper networkHelper, final LoadListener<ChangeOwnerModels.GetPendingObjectOwnerOutput> loadListener) {
        try {
            networkHelper.getPendingObjectOwner(str2, new ChangeOwnerModels.GetPendingObjectOwnerInput(str), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<ChangeOwnerModels.GetPendingObjectOwnerOutput>(this) { // from class: ir.aaap.messengercore.ChatUtils.44
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(ChangeOwnerModels.GetPendingObjectOwnerOutput getPendingObjectOwnerOutput) {
                    if (getPendingObjectOwnerOutput != null) {
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(getPendingObjectOwnerOutput);
                            return;
                        }
                        return;
                    }
                    LoadListener loadListener3 = loadListener;
                    if (loadListener3 != null) {
                        loadListener3.onError(new ApiServerException());
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.coreLog.handleException(e);
        }
    }

    public void acceptRequestObjectOwner(String str, String str2, NetworkHelper networkHelper, DBHelper dBHelper, AbsNotificationCenter absNotificationCenter, LoadListener<Integer> loadListener) {
        replyRequestObjectOwner(str, ChangeOwnerModels.ActionEnum.Accept, str2, networkHelper, dBHelper, absNotificationCenter, loadListener);
    }

    public void rejectRequestObjectOwner(String str, String str2, NetworkHelper networkHelper, DBHelper dBHelper, AbsNotificationCenter absNotificationCenter, LoadListener<Integer> loadListener) {
        replyRequestObjectOwner(str, ChangeOwnerModels.ActionEnum.Reject, str2, networkHelper, dBHelper, absNotificationCenter, loadListener);
    }

    private void replyRequestObjectOwner(String str, ChangeOwnerModels.ActionEnum actionEnum, String str2, NetworkHelper networkHelper, final DBHelper dBHelper, final AbsNotificationCenter absNotificationCenter, final LoadListener<Integer> loadListener) {
        ChangeOwnerModels.ReplyRequestObjectOwnerInput replyRequestObjectOwnerInput = new ChangeOwnerModels.ReplyRequestObjectOwnerInput();
        replyRequestObjectOwnerInput.object_guid = str;
        replyRequestObjectOwnerInput.action = actionEnum;
        try {
            networkHelper.replyRequestObjectOwner(str2, replyRequestObjectOwnerInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<ChangeOwnerModels.ReplyRequestObjectOwnerOutput>() { // from class: ir.aaap.messengercore.ChatUtils.45
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(ChangeOwnerModels.ReplyRequestObjectOwnerOutput replyRequestObjectOwnerOutput) {
                    if (replyRequestObjectOwnerOutput != null) {
                        ChatUtils.this.processChatsUpdate(replyRequestObjectOwnerOutput.chat_update, (UpdateChatUsecase) null, absNotificationCenter, dBHelper);
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(1);
                            return;
                        }
                        return;
                    }
                    LoadListener loadListener3 = loadListener;
                    if (loadListener3 != null) {
                        loadListener3.onError(new ApiServerException());
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.coreLog.handleException(e);
        }
    }

    public void cancelChangeObjectOwner(String str, String str2, NetworkHelper networkHelper, final LoadListener<Integer> loadListener) {
        try {
            networkHelper.cancelChangeObjectOwner(str2, new ChangeOwnerModels.CancelChangeOwnerInput(str), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<ChangeOwnerModels.CancelChangeOwnerOutput>(this) { // from class: ir.aaap.messengercore.ChatUtils.46
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(ChangeOwnerModels.CancelChangeOwnerOutput cancelChangeOwnerOutput) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(1);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.coreLog.handleException(e);
        }
    }

    public int getCommonGroups(String str, String str2, NetworkHelper networkHelper, final DBHelper dBHelper, final LoadListener<ArrayList<ChatAbsObject>> loadListener) {
        try {
            return networkHelper.getCommonGroups(str2, new GetCommonGroupsInput(str), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetCommonGroupsOutput>() { // from class: ir.aaap.messengercore.ChatUtils.47
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(GetCommonGroupsOutput getCommonGroupsOutput) {
                    if (getCommonGroupsOutput != null) {
                        ArrayList<ChatAbsObject> arrayList = getCommonGroupsOutput.abs_groups;
                        if (arrayList != null) {
                            ChatUtils.this.addToAbsMap(arrayList, getCommonGroupsOutput.timestamp);
                        }
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(getCommonGroupsOutput.abs_groups);
                        }
                        ArrayList<ChatAbsObject> arrayList2 = getCommonGroupsOutput.abs_groups;
                        if (arrayList2 != null) {
                            dBHelper.addAllAbsObject(arrayList2, getCommonGroupsOutput.timestamp);
                            return;
                        }
                        return;
                    }
                    LoadListener loadListener3 = loadListener;
                    if (loadListener3 != null) {
                        loadListener3.onError(new ApiServerException());
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            this.coreLog.handleException(e);
            if (loadListener == null) {
                return 0;
            }
            loadListener.onError(e);
            return 0;
        }
    }

    public void setGroupLink(String str, String str2, NetworkHelper networkHelper, final LoadListener<String> loadListener) {
        try {
            networkHelper.setGroupLink(str2, new SetGroupLinkInput(str), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<SetGroupLinkOutput>(this) { // from class: ir.aaap.messengercore.ChatUtils.48
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(SetGroupLinkOutput setGroupLinkOutput) {
                    if (setGroupLinkOutput != null) {
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(setGroupLinkOutput.join_link);
                            return;
                        }
                        return;
                    }
                    LoadListener loadListener3 = loadListener;
                    if (loadListener3 != null) {
                        loadListener3.onError(new ApiServerException());
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.coreLog.handleException(e);
        }
    }

    public void setChannelLink(String str, String str2, NetworkHelper networkHelper, final LoadListener<String> loadListener) {
        try {
            networkHelper.setChannelLink(str2, new SetChannelLinkInput(str), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<SetChannelLinkOutput>(this) { // from class: ir.aaap.messengercore.ChatUtils.49
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(SetChannelLinkOutput setChannelLinkOutput) {
                    if (setChannelLinkOutput != null) {
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(setChannelLinkOutput.join_link);
                            return;
                        }
                        return;
                    }
                    LoadListener loadListener3 = loadListener;
                    if (loadListener3 != null) {
                        loadListener3.onError(new ApiServerException());
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.coreLog.handleException(e);
        }
    }

    public void getGroupLink(String str, String str2, NetworkHelper networkHelper, final LoadListener<String> loadListener) {
        try {
            networkHelper.getGroupLink(str2, new GetGroupLinkInput(str), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetGroupLinkOutput>(this) { // from class: ir.aaap.messengercore.ChatUtils.50
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(GetGroupLinkOutput getGroupLinkOutput) {
                    if (getGroupLinkOutput != null) {
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(getGroupLinkOutput.join_link);
                            return;
                        }
                        return;
                    }
                    LoadListener loadListener3 = loadListener;
                    if (loadListener3 != null) {
                        loadListener3.onError(new ApiServerException());
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.coreLog.handleException(e);
        }
    }

    public int groupPreviewByJoinLink(String str, String str2, NetworkHelper networkHelper, final DBHelper dBHelper, final AbsNotificationCenter absNotificationCenter, final LoadListener<ChatInviteObject> loadListener) {
        try {
            return networkHelper.groupPreviewByJoinLink(str2, new GroupPreviewByJoinLinkInput(str), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GroupPreviewByJoinLinkOutput>() { // from class: ir.aaap.messengercore.ChatUtils.51
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(GroupPreviewByJoinLinkOutput groupPreviewByJoinLinkOutput) {
                    if (groupPreviewByJoinLinkOutput != null) {
                        ChatInviteObject chatInviteObject = new ChatInviteObject();
                        boolean z = groupPreviewByJoinLinkOutput.is_valid;
                        chatInviteObject.is_valid = z;
                        chatInviteObject.has_joined = groupPreviewByJoinLinkOutput.has_joined;
                        if (z) {
                            GroupInfoFromServer groupInfoFromServer = groupPreviewByJoinLinkOutput.group;
                            if (groupInfoFromServer != null) {
                                chatInviteObject.objectGuid = groupInfoFromServer.group_guid;
                                ChatUtils.this.processGroupInfoDidLoad(groupInfoFromServer, null, groupPreviewByJoinLinkOutput.timestamp, dBHelper, absNotificationCenter);
                            }
                            ArrayList<InChatMemberFromServer> arrayList = groupPreviewByJoinLinkOutput.top_participants;
                            if (arrayList != null && arrayList.size() > 0) {
                                chatInviteObject.top_participants = ChatUtils.this.processMembers(groupPreviewByJoinLinkOutput.top_participants, groupPreviewByJoinLinkOutput.timestamp, dBHelper);
                            }
                        }
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(chatInviteObject);
                            return;
                        }
                        return;
                    }
                    LoadListener loadListener3 = loadListener;
                    if (loadListener3 != null) {
                        loadListener3.onError(new ApiServerException());
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.coreLog.handleException(e);
            return 0;
        }
    }

    public int channelPreviewByJoinLink(String str, String str2, NetworkHelper networkHelper, final DBHelper dBHelper, final AbsNotificationCenter absNotificationCenter, final LoadListener<ChatInviteObject> loadListener) {
        try {
            return networkHelper.channelPreviewByJoinLink(str2, new ChannelPreviewByJoinLinkInput(str), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<ChannelPreviewByJoinLinkOutput>() { // from class: ir.aaap.messengercore.ChatUtils.52
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(ChannelPreviewByJoinLinkOutput channelPreviewByJoinLinkOutput) {
                    ChannelInfoFromServer channelInfoFromServer;
                    if (channelPreviewByJoinLinkOutput != null) {
                        ChatInviteObject chatInviteObject = new ChatInviteObject();
                        boolean z = channelPreviewByJoinLinkOutput.is_valid;
                        chatInviteObject.is_valid = z;
                        chatInviteObject.has_joined = channelPreviewByJoinLinkOutput.has_joined;
                        if (z && (channelInfoFromServer = channelPreviewByJoinLinkOutput.channel) != null) {
                            chatInviteObject.objectGuid = channelInfoFromServer.channel_guid;
                            ChatUtils.this.processChannelInfoDidLoad(channelInfoFromServer, null, channelPreviewByJoinLinkOutput.timestamp, dBHelper, absNotificationCenter);
                        }
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(chatInviteObject);
                            return;
                        }
                        return;
                    }
                    LoadListener loadListener3 = loadListener;
                    if (loadListener3 != null) {
                        loadListener3.onError(new ApiServerException());
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.coreLog.handleException(e);
            return 0;
        }
    }

    public int checkChannelUsername(String str, String str2, NetworkHelper networkHelper, final LoadListener<CoreUtilities.UsernameCheckType> loadListener) {
        CoreUtilities.UsernameCheckType usernameCheckTypeCheckUserNameWithLengthCheck = CoreUtilities.checkUserNameWithLengthCheck(str);
        if (usernameCheckTypeCheckUserNameWithLengthCheck != CoreUtilities.UsernameCheckType.Ok) {
            if (loadListener != null) {
                loadListener.onError(new UsernameException(usernameCheckTypeCheckUserNameWithLengthCheck));
            }
            return 0;
        }
        try {
            return networkHelper.checkChannelUsername(str2, new CheckUsernameInput(str), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<CheckUsernameOutput>(this) { // from class: ir.aaap.messengercore.ChatUtils.53
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(CheckUsernameOutput checkUsernameOutput) {
                    if (checkUsernameOutput != null) {
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(checkUsernameOutput.exist ? CoreUtilities.UsernameCheckType.Exist : CoreUtilities.UsernameCheckType.Ok);
                            return;
                        }
                        return;
                    }
                    LoadListener loadListener3 = loadListener;
                    if (loadListener3 != null) {
                        loadListener3.onError(new ApiServerException());
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.coreLog.handleException(e);
            return 0;
        }
    }

    public int checkUserUsername(String str, String str2, NetworkHelper networkHelper, final LoadListener<CoreUtilities.UsernameCheckType> loadListener) {
        CoreUtilities.UsernameCheckType usernameCheckTypeCheckUserNameWithLengthCheck = CoreUtilities.checkUserNameWithLengthCheck(str);
        if (usernameCheckTypeCheckUserNameWithLengthCheck != CoreUtilities.UsernameCheckType.Ok) {
            if (loadListener != null) {
                loadListener.onError(new UsernameException(usernameCheckTypeCheckUserNameWithLengthCheck));
            }
            return 0;
        }
        try {
            return networkHelper.checkUserUsername(str2, new CheckUsernameInput(str), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<CheckUsernameOutput>(this) { // from class: ir.aaap.messengercore.ChatUtils.54
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(CheckUsernameOutput checkUsernameOutput) {
                    if (checkUsernameOutput != null) {
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(checkUsernameOutput.exist ? CoreUtilities.UsernameCheckType.Exist : CoreUtilities.UsernameCheckType.Ok);
                            return;
                        }
                        return;
                    }
                    LoadListener loadListener3 = loadListener;
                    if (loadListener3 != null) {
                        loadListener3.onError(new ApiServerException());
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.coreLog.handleException(e);
            return 0;
        }
    }

    public int checkRubinoUsername(String str, String str2, NetworkHelper networkHelper, final LoadListener<CoreUtilities.UsernameCheckType> loadListener) {
        CoreUtilities.UsernameCheckType usernameCheckTypeCheckUserNameWithLengthCheck = CoreUtilities.checkUserNameWithLengthCheck(str);
        if (usernameCheckTypeCheckUserNameWithLengthCheck != CoreUtilities.UsernameCheckType.Ok) {
            if (loadListener != null) {
                loadListener.onError(new UsernameException(usernameCheckTypeCheckUserNameWithLengthCheck));
            }
            return 0;
        }
        try {
            return networkHelper.checkRubinoUsername(str2, new CheckUsernameInput(str), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<CheckUsernameOutput>(this) { // from class: ir.aaap.messengercore.ChatUtils.55
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(CheckUsernameOutput checkUsernameOutput) {
                    if (checkUsernameOutput != null) {
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(checkUsernameOutput.exist ? CoreUtilities.UsernameCheckType.Exist : CoreUtilities.UsernameCheckType.Ok);
                            return;
                        }
                        return;
                    }
                    LoadListener loadListener3 = loadListener;
                    if (loadListener3 != null) {
                        loadListener3.onError(new ApiServerException());
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.coreLog.handleException(e);
            return 0;
        }
    }

    public void updateChannelUsername(String str, String str2, String str3, NetworkHelper networkHelper, final DBHelper dBHelper, final AbsNotificationCenter absNotificationCenter, final LoadListener<UpdateChannelUsernameOutput.StatusEnum> loadListener) {
        UpdateChannelUsernameInput updateChannelUsernameInput = new UpdateChannelUsernameInput(str, str2);
        ObjectInfo objectInfoInstant = getObjectInfoInstant(str);
        final String userName = (objectInfoInstant == null || objectInfoInstant.getUserName() == null) ? null : objectInfoInstant.getUserName();
        try {
            networkHelper.updateChannelUsername(str3, updateChannelUsernameInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<UpdateChannelUsernameOutput>() { // from class: ir.aaap.messengercore.ChatUtils.56
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(UpdateChannelUsernameOutput updateChannelUsernameOutput) {
                    if (updateChannelUsernameOutput != null) {
                        if (updateChannelUsernameOutput.status == UpdateChannelUsernameOutput.StatusEnum.OK) {
                            String str4 = userName;
                            if (str4 != null) {
                                ChatUtils.this.removeFromInfoByUsernameMap(str4);
                            }
                            ChatUtils.this.processChannelInfoDidLoad(updateChannelUsernameOutput.channel, null, updateChannelUsernameOutput.timestamp, dBHelper, absNotificationCenter);
                        }
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(updateChannelUsernameOutput.status);
                            return;
                        }
                        return;
                    }
                    LoadListener loadListener3 = loadListener;
                    if (loadListener3 != null) {
                        loadListener3.onError(new ApiServerException());
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.coreLog.handleException(e);
        }
    }

    public int updateUserUsername(String str, String str2, String str3, NetworkHelper networkHelper, final DBHelper dBHelper, final KeyValueStorageHelper keyValueStorageHelper, final AbsNotificationCenter absNotificationCenter, final LoadListener<UpdateUserUsernameOutput.StatusEnum> loadListener) {
        if (!CoreUtilities.isNotEmpty(str2)) {
            if (loadListener != null) {
                loadListener.onError(new InputException(InputException.ErrorEnum.IsInvalidInput));
            }
            return 0;
        }
        UpdateUsernameInput updateUsernameInput = new UpdateUsernameInput(str2);
        ObjectInfo objectInfoInstant = getObjectInfoInstant(str);
        final String userName = (objectInfoInstant == null || objectInfoInstant.getUserName() == null) ? null : objectInfoInstant.getUserName();
        try {
            return networkHelper.updateUserUsername(str3, updateUsernameInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<UpdateUserUsernameOutput>() { // from class: ir.aaap.messengercore.ChatUtils.57
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(UpdateUserUsernameOutput updateUserUsernameOutput) {
                    String str4;
                    if (updateUserUsernameOutput != null) {
                        if (updateUserUsernameOutput.status == UpdateUserUsernameOutput.StatusEnum.OK) {
                            String str5 = userName;
                            if (str5 != null) {
                                ChatUtils.this.removeFromInfoByUsernameMap(str5);
                            }
                            ChatUtils.this.processUserInfoDidLoad(updateUserUsernameOutput.user, null, 0L, true, true, true, updateUserUsernameOutput.timestamp, dBHelper, true, absNotificationCenter);
                            UserInfoFromServer userInfoFromServer = updateUserUsernameOutput.user;
                            if (userInfoFromServer != null && (str4 = userInfoFromServer.user_guid) != null && str4.equals(ChatUtils.this.getMyUserGuidUsecase.getMyGuid())) {
                                keyValueStorageHelper.setMyUserObject(updateUserUsernameOutput.user, System.currentTimeMillis());
                            }
                        }
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(updateUserUsernameOutput.status);
                            return;
                        }
                        return;
                    }
                    LoadListener loadListener3 = loadListener;
                    if (loadListener3 != null) {
                        loadListener3.onError(new ApiServerException());
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.coreLog.handleException(e);
            return 0;
        }
    }

    public int checkChannelsWithUsername(String str, NetworkHelper networkHelper, final DBHelper dBHelper, final AbsNotificationCenter absNotificationCenter, final LoadListener<CheckChannelsWithUsernameResult> loadListener) {
        try {
            return networkHelper.checkChannelsWithUsername(str, new CheckChannelsWithUsernameInput(), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<CheckChannelsWithUsernameOutput>() { // from class: ir.aaap.messengercore.ChatUtils.58
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(CheckChannelsWithUsernameOutput checkChannelsWithUsernameOutput) {
                    if (checkChannelsWithUsernameOutput != null) {
                        CheckChannelsWithUsernameResult checkChannelsWithUsernameResult = new CheckChannelsWithUsernameResult();
                        checkChannelsWithUsernameResult.allowSetUsername = checkChannelsWithUsernameOutput.allow_set_username;
                        ArrayList<ChannelInfoFromServer> arrayList = checkChannelsWithUsernameOutput.channels;
                        if (arrayList != null && arrayList.size() > 0) {
                            checkChannelsWithUsernameResult.channelIds = new ArrayList<>();
                            Iterator<ChannelInfoFromServer> it = checkChannelsWithUsernameOutput.channels.iterator();
                            while (it.hasNext()) {
                                ChannelInfoFromServer next = it.next();
                                ChatUtils.this.processChannelInfoDidLoad(next, null, checkChannelsWithUsernameOutput.timestamp, dBHelper, absNotificationCenter);
                                checkChannelsWithUsernameResult.channelIds.add(next.channel_guid);
                            }
                        }
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(checkChannelsWithUsernameResult);
                            return;
                        }
                        return;
                    }
                    LoadListener loadListener3 = loadListener;
                    if (loadListener3 != null) {
                        loadListener3.onError(new ApiServerException());
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.coreLog.handleException(e);
            return 0;
        }
    }

    public void getAllChannelStatistics(String str, String str2, NetworkHelper networkHelper, final LoadListener<GetAllStatisticsOutput> loadListener) {
        try {
            networkHelper.getAllStatistics(str2, new GetAllStatisticsInput(str), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetAllStatisticsOutput>(this) { // from class: ir.aaap.messengercore.ChatUtils.59
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(GetAllStatisticsOutput getAllStatisticsOutput) {
                    if (getAllStatisticsOutput != null) {
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(getAllStatisticsOutput);
                            return;
                        }
                        return;
                    }
                    LoadListener loadListener3 = loadListener;
                    if (loadListener3 != null) {
                        loadListener3.onError(new ApiServerException());
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.coreLog.handleException(e);
        }
    }

    public void setAskSpamActionReportAndLeave(String str, String str2, NetworkHelper networkHelper, DBHelper dBHelper, AbsNotificationCenter absNotificationCenter, UpdateChatUsecase updateChatUsecase) {
        setAskSpamAction(str, SetAskSpamActionInput.Action.ReportAndLeave, str2, networkHelper, dBHelper, absNotificationCenter, updateChatUsecase);
    }

    public void setAskSpamActionBlockUser(String str, String str2, NetworkHelper networkHelper, DBHelper dBHelper, AbsNotificationCenter absNotificationCenter, UpdateChatUsecase updateChatUsecase) {
        setAskSpamAction(str, SetAskSpamActionInput.Action.BlockUser, str2, networkHelper, dBHelper, absNotificationCenter, updateChatUsecase);
    }

    public void setAskSpamActionCancel(String str, String str2, NetworkHelper networkHelper, DBHelper dBHelper, AbsNotificationCenter absNotificationCenter, UpdateChatUsecase updateChatUsecase) {
        setAskSpamAction(str, SetAskSpamActionInput.Action.Cancel, str2, networkHelper, dBHelper, absNotificationCenter, updateChatUsecase);
    }

    public void setAskSpamActionAddToContact(String str, String str2, NetworkHelper networkHelper, DBHelper dBHelper, AbsNotificationCenter absNotificationCenter, UpdateChatUsecase updateChatUsecase) {
        setAskSpamAction(str, SetAskSpamActionInput.Action.AddToContact, str2, networkHelper, dBHelper, absNotificationCenter, updateChatUsecase);
    }

    private void setAskSpamAction(String str, SetAskSpamActionInput.Action action, String str2, NetworkHelper networkHelper, final DBHelper dBHelper, final AbsNotificationCenter absNotificationCenter, final UpdateChatUsecase updateChatUsecase) {
        try {
            networkHelper.setAskSpamAction(str2, new SetAskSpamActionInput(str, action), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<SetAskSpamActionOutput>() { // from class: ir.aaap.messengercore.ChatUtils.60
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(SetAskSpamActionOutput setAskSpamActionOutput) {
                    if (setAskSpamActionOutput != null) {
                        ChatUtils.this.processChatsUpdate(setAskSpamActionOutput.chat_update, updateChatUsecase, absNotificationCenter, dBHelper);
                    }
                }
            });
        } catch (Exception e) {
            this.coreLog.handleException(e);
        }
    }

    public void getChannelLink(String str, String str2, NetworkHelper networkHelper, final LoadListener<String> loadListener) {
        try {
            networkHelper.getChannelLink(str2, new GetChannelLinkInput(str), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetChannelLinkOutput>(this) { // from class: ir.aaap.messengercore.ChatUtils.61
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(GetChannelLinkOutput getChannelLinkOutput) {
                    if (getChannelLinkOutput != null) {
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(getChannelLinkOutput.join_link);
                            return;
                        }
                        return;
                    }
                    LoadListener loadListener3 = loadListener;
                    if (loadListener3 != null) {
                        loadListener3.onError(new ApiServerException());
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.coreLog.handleException(e);
        }
    }

    public void banGroupMember(String str, String str2, boolean z, String str3, NetworkHelper networkHelper, final DBHelper dBHelper, final AbsNotificationCenter absNotificationCenter, final UpdateChatAndMessageUsecase updateChatAndMessageUsecase, final UpdateGroupVoiceChatUsecase updateGroupVoiceChatUsecase, final LoadListener<Integer> loadListener) {
        BanGroupMemberInput banGroupMemberInput = new BanGroupMemberInput();
        banGroupMemberInput.action = z ? BanGroupMemberInput.ActionEnum.Set : BanGroupMemberInput.ActionEnum.Unset;
        banGroupMemberInput.group_guid = str;
        banGroupMemberInput.member_guid = str2;
        try {
            networkHelper.banGroupMember(str3, banGroupMemberInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<BanGroupMemberOutput>() { // from class: ir.aaap.messengercore.ChatUtils.62
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(BanGroupMemberOutput banGroupMemberOutput) {
                    if (banGroupMemberOutput != null) {
                        UpdateChatAndMessageUsecase updateChatAndMessageUsecase2 = updateChatAndMessageUsecase;
                        if (updateChatAndMessageUsecase2 != null) {
                            updateChatAndMessageUsecase2.processMessageAndChatUpdate(banGroupMemberOutput.message_update, banGroupMemberOutput.chat_update, false, true);
                        }
                        GroupInfoFromServer groupInfoFromServer = banGroupMemberOutput.group;
                        if (groupInfoFromServer != null) {
                            ChatUtils.this.processGroupInfoDidLoad(groupInfoFromServer, null, banGroupMemberOutput.timestamp, dBHelper, absNotificationCenter);
                        }
                        UpdateGroupVoiceChatUsecase updateGroupVoiceChatUsecase2 = updateGroupVoiceChatUsecase;
                        if (updateGroupVoiceChatUsecase2 != null) {
                            updateGroupVoiceChatUsecase2.processGroupVoiceChatParticipants(banGroupMemberOutput.group_voice_chat_update, banGroupMemberOutput.group_voice_chat_participate_update);
                        }
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(1);
                            return;
                        }
                        return;
                    }
                    LoadListener loadListener3 = loadListener;
                    if (loadListener3 != null) {
                        loadListener3.onError(new ApiServerException());
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            this.coreLog.handleException(e);
            if (loadListener != null) {
                loadListener.onError(e);
            }
        }
    }

    public void banChannelMember(String str, String str2, boolean z, String str3, NetworkHelper networkHelper, final DBHelper dBHelper, final AbsNotificationCenter absNotificationCenter, final UpdateGroupVoiceChatUsecase updateGroupVoiceChatUsecase, final LoadListener<Integer> loadListener) {
        BanChannelMemberInput banChannelMemberInput = new BanChannelMemberInput();
        banChannelMemberInput.action = z ? BanGroupMemberInput.ActionEnum.Set : BanGroupMemberInput.ActionEnum.Unset;
        banChannelMemberInput.channel_guid = str;
        banChannelMemberInput.member_guid = str2;
        try {
            networkHelper.banChannelMember(str3, banChannelMemberInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<BanChannelMemberOutput>() { // from class: ir.aaap.messengercore.ChatUtils.63
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(BanChannelMemberOutput banChannelMemberOutput) {
                    if (banChannelMemberOutput != null) {
                        ChannelInfoFromServer channelInfoFromServer = banChannelMemberOutput.channel;
                        if (channelInfoFromServer != null) {
                            ChatUtils.this.processChannelInfoDidLoad(channelInfoFromServer, null, banChannelMemberOutput.timestamp, dBHelper, absNotificationCenter);
                        }
                        UpdateGroupVoiceChatUsecase updateGroupVoiceChatUsecase2 = updateGroupVoiceChatUsecase;
                        if (updateGroupVoiceChatUsecase2 != null) {
                            updateGroupVoiceChatUsecase2.processGroupVoiceChatParticipants(banChannelMemberOutput.group_voice_chat_update, banChannelMemberOutput.group_voice_chat_participate_update);
                        }
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(1);
                            return;
                        }
                        return;
                    }
                    LoadListener loadListener3 = loadListener;
                    if (loadListener3 != null) {
                        loadListener3.onError(new ApiServerException());
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            this.coreLog.handleException(e);
            if (loadListener != null) {
                loadListener.onError(e);
            }
        }
    }

    public void addGroupMembers(String str, ArrayList<String> arrayList, String str2, NetworkHelper networkHelper, final DBHelper dBHelper, final AbsNotificationCenter absNotificationCenter, final UpdateChatAndMessageUsecase updateChatAndMessageUsecase, final LoadListener<ArrayList<InChatMember>> loadListener) {
        try {
            networkHelper.addGroupMembers(str2, new AddGroupMembersInput(str, arrayList), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<AddGroupMembersOutput>() { // from class: ir.aaap.messengercore.ChatUtils.64
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(AddGroupMembersOutput addGroupMembersOutput) {
                    if (addGroupMembersOutput != null) {
                        UpdateChatAndMessageUsecase updateChatAndMessageUsecase2 = updateChatAndMessageUsecase;
                        if (updateChatAndMessageUsecase2 != null) {
                            updateChatAndMessageUsecase2.processMessageAndChatUpdate(addGroupMembersOutput.message_update, addGroupMembersOutput.chat_update, false, true);
                        }
                        GroupInfoFromServer groupInfoFromServer = addGroupMembersOutput.group;
                        if (groupInfoFromServer != null) {
                            ChatUtils.this.processGroupInfoDidLoad(groupInfoFromServer, null, addGroupMembersOutput.timestamp, dBHelper, absNotificationCenter);
                        }
                        ArrayList arrayList2 = new ArrayList();
                        ArrayList<InChatMemberFromServer> arrayList3 = addGroupMembersOutput.added_in_chat_members;
                        if (arrayList3 != null) {
                            arrayList2 = ChatUtils.this.processMembers(arrayList3, addGroupMembersOutput.timestamp, dBHelper);
                        }
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(arrayList2);
                            return;
                        }
                        return;
                    }
                    LoadListener loadListener3 = loadListener;
                    if (loadListener3 != null) {
                        loadListener3.onError(new ApiServerException());
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            this.coreLog.handleException(e);
            if (loadListener != null) {
                loadListener.onError(e);
            }
        }
    }

    public void addChannelMembers(String str, ArrayList<String> arrayList, String str2, NetworkHelper networkHelper, final DBHelper dBHelper, final AbsNotificationCenter absNotificationCenter, final LoadListener<ArrayList<InChatMember>> loadListener) {
        try {
            networkHelper.addChannelMembers(str2, new AddChannelMembersInput(str, arrayList), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<AddChannelMembersOutput>() { // from class: ir.aaap.messengercore.ChatUtils.65
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(AddChannelMembersOutput addChannelMembersOutput) {
                    if (addChannelMembersOutput != null) {
                        ChannelInfoFromServer channelInfoFromServer = addChannelMembersOutput.channel;
                        if (channelInfoFromServer != null) {
                            ChatUtils.this.processChannelInfoDidLoad(channelInfoFromServer, null, addChannelMembersOutput.timestamp, dBHelper, absNotificationCenter);
                        }
                        ArrayList arrayList2 = new ArrayList();
                        ArrayList<InChatMemberFromServer> arrayList3 = addChannelMembersOutput.added_in_chat_members;
                        if (arrayList3 != null) {
                            arrayList2 = ChatUtils.this.processMembers(arrayList3, addChannelMembersOutput.timestamp, dBHelper);
                        }
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(arrayList2);
                            return;
                        }
                        return;
                    }
                    LoadListener loadListener3 = loadListener;
                    if (loadListener3 != null) {
                        loadListener3.onError(new ApiServerException());
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            this.coreLog.handleException(e);
            if (loadListener != null) {
                loadListener.onError(e);
            }
        }
    }

    /* renamed from: getGroupOnlineCount, reason: merged with bridge method [inline-methods] */
    public void lambda$startGetGroupOnlineCountTimer$3(final String str, final String str2, final NetworkHelper networkHelper, final AbsNotificationCenter absNotificationCenter, final TimerHelper timerHelper) {
        GetGroupOnlineCountInput getGroupOnlineCountInput = new GetGroupOnlineCountInput();
        getGroupOnlineCountInput.group_guid = str;
        try {
            networkHelper.getGroupOnlineCount(str2, getGroupOnlineCountInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetGroupOnlineCountOutput>() { // from class: ir.aaap.messengercore.ChatUtils.66
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(GetGroupOnlineCountOutput getGroupOnlineCountOutput) {
                    if (getGroupOnlineCountOutput != null) {
                        ChatUtils.this.addToOnlineCountsMap(str, getGroupOnlineCountOutput.online_count);
                        absNotificationCenter.chatOnlineCountDidLoad(str, getGroupOnlineCountOutput.online_count);
                    }
                    if (timerHelper == null || !ChatUtils.this.infoStartedSet.contains(str)) {
                        return;
                    }
                    ChatUtils.this.startGetGroupOnlineCountTimer(str, str2, networkHelper, absNotificationCenter, timerHelper);
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    if (timerHelper == null || !ChatUtils.this.infoStartedSet.contains(str)) {
                        return;
                    }
                    ChatUtils.this.startGetGroupOnlineCountTimer(str, str2, networkHelper, absNotificationCenter, timerHelper);
                }
            });
        } catch (Exception e) {
            this.coreLog.handleException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addToOnlineCountsMap(String str, int i) {
        synchronized (this.onlineCountLock) {
            this.groupOnlineCountsMap.put(str, Integer.valueOf(i));
        }
    }

    private int getObjectInfoByUsernameFromServer(final String str, String str2, NetworkHelper networkHelper, final DBHelper dBHelper, final AbsNotificationCenter absNotificationCenter, final LoadListener<String> loadListener) {
        if (this.infoByUsernameLoadingSet.contains(str)) {
            return 0;
        }
        this.infoByUsernameLoadingSet.add(str);
        try {
            return networkHelper.getObjectByUsername(str2, new GetObjectByUsernameInput(str), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetObjectByUsernameOutput>() { // from class: ir.aaap.messengercore.ChatUtils.67
                /* JADX WARN: Removed duplicated region for block: B:23:0x004c  */
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public void onResponse(ir.aaap.messengercore.model.api.GetObjectByUsernameOutput r19) {
                    /*
                        r18 = this;
                        r0 = r18
                        r1 = r19
                        ir.aaap.messengercore.ChatUtils r2 = ir.aaap.messengercore.ChatUtils.this
                        java.util.Set r2 = ir.aaap.messengercore.ChatUtils.access$3900(r2)
                        java.lang.String r3 = r2
                        r2.remove(r3)
                        if (r1 == 0) goto Lb8
                        boolean r2 = r1.exist
                        if (r2 != 0) goto L23
                        ir.aaap.messengercore.LoadListener r1 = r3
                        if (r1 == 0) goto Lc4
                        ir.aaap.messengercore.exceptions.UsernameNotExistException r2 = new ir.aaap.messengercore.exceptions.UsernameNotExistException
                        r2.<init>()
                        r1.onError(r2)
                        goto Lc4
                    L23:
                        ir.aaap.messengercore.model.api.GetObjectByUsernameOutput$Type r2 = r1.type
                        ir.aaap.messengercore.model.api.GetObjectByUsernameOutput$Type r3 = ir.aaap.messengercore.model.api.GetObjectByUsernameOutput.Type.User
                        r4 = 0
                        if (r2 != r3) goto L5c
                        ir.aaap.messengercore.model.UserInfoFromServer r6 = r1.user
                        if (r6 == 0) goto L32
                        java.lang.String r2 = r6.user_guid
                    L30:
                        r4 = r2
                        goto L39
                    L32:
                        ir.aaap.messengercore.model.ChatFromServer r2 = r1.chat
                        if (r2 == 0) goto L39
                        java.lang.String r2 = r2.object_guid
                        goto L30
                    L39:
                        ir.aaap.messengercore.ChatUtils r5 = ir.aaap.messengercore.ChatUtils.this
                        ir.aaap.messengercore.model.ChatFromServer r7 = r1.chat
                        long r8 = r1.count_common_groups
                        boolean r10 = r1.can_receive_call
                        boolean r11 = r1.can_video_call
                        if (r7 == 0) goto L4c
                        boolean r2 = r7.is_in_contact
                        if (r2 == 0) goto L4c
                        r2 = 1
                        r12 = 1
                        goto L4e
                    L4c:
                        r2 = 0
                        r12 = 0
                    L4e:
                        long r13 = r1.timestamp
                        ir.aaap.messengercore.db.DBHelper r15 = r4
                        r16 = 1
                        ir.aaap.messengercore.AbsNotificationCenter r1 = r5
                        r17 = r1
                        r5.processUserInfoDidLoad(r6, r7, r8, r10, r11, r12, r13, r15, r16, r17)
                        goto L9d
                    L5c:
                        ir.aaap.messengercore.model.api.GetObjectByUsernameOutput$Type r3 = ir.aaap.messengercore.model.api.GetObjectByUsernameOutput.Type.Channel
                        if (r2 != r3) goto L7d
                        ir.aaap.messengercore.model.ChannelInfoFromServer r6 = r1.channel
                        if (r6 == 0) goto L68
                        java.lang.String r2 = r6.channel_guid
                    L66:
                        r4 = r2
                        goto L6f
                    L68:
                        ir.aaap.messengercore.model.ChatFromServer r2 = r1.chat
                        if (r2 == 0) goto L6f
                        java.lang.String r2 = r2.object_guid
                        goto L66
                    L6f:
                        ir.aaap.messengercore.ChatUtils r5 = ir.aaap.messengercore.ChatUtils.this
                        ir.aaap.messengercore.model.ChatFromServer r7 = r1.chat
                        long r8 = r1.timestamp
                        ir.aaap.messengercore.db.DBHelper r10 = r4
                        ir.aaap.messengercore.AbsNotificationCenter r11 = r5
                        ir.aaap.messengercore.ChatUtils.access$3400(r5, r6, r7, r8, r10, r11)
                        goto L9d
                    L7d:
                        ir.aaap.messengercore.model.api.GetObjectByUsernameOutput$Type r3 = ir.aaap.messengercore.model.api.GetObjectByUsernameOutput.Type.Bot
                        if (r2 != r3) goto L9d
                        ir.aaap.messengercore.model.api.BotInfoFromServer r6 = r1.bot
                        if (r6 == 0) goto L89
                        java.lang.String r2 = r6.bot_guid
                    L87:
                        r4 = r2
                        goto L90
                    L89:
                        ir.aaap.messengercore.model.ChatFromServer r2 = r1.chat
                        if (r2 == 0) goto L90
                        java.lang.String r2 = r2.object_guid
                        goto L87
                    L90:
                        ir.aaap.messengercore.ChatUtils r5 = ir.aaap.messengercore.ChatUtils.this
                        ir.aaap.messengercore.model.ChatFromServer r7 = r1.chat
                        long r8 = r1.timestamp
                        ir.aaap.messengercore.db.DBHelper r10 = r4
                        ir.aaap.messengercore.AbsNotificationCenter r11 = r5
                        ir.aaap.messengercore.ChatUtils.access$4000(r5, r6, r7, r8, r10, r11)
                    L9d:
                        if (r4 == 0) goto Lb0
                        ir.aaap.messengercore.ChatUtils r1 = ir.aaap.messengercore.ChatUtils.this
                        java.util.Map r1 = ir.aaap.messengercore.ChatUtils.access$4100(r1)
                        long r2 = java.lang.System.currentTimeMillis()
                        java.lang.Long r2 = java.lang.Long.valueOf(r2)
                        r1.put(r4, r2)
                    Lb0:
                        ir.aaap.messengercore.LoadListener r1 = r3
                        if (r1 == 0) goto Lc4
                        r1.onDidLoad(r4)
                        goto Lc4
                    Lb8:
                        ir.aaap.messengercore.LoadListener r1 = r3
                        if (r1 == 0) goto Lc4
                        ir.aaap.messengercore.network.ApiServerException r2 = new ir.aaap.messengercore.network.ApiServerException
                        r2.<init>()
                        r1.onError(r2)
                    Lc4:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.aaap.messengercore.ChatUtils.AnonymousClass67.onResponse(ir.aaap.messengercore.model.api.GetObjectByUsernameOutput):void");
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    ChatUtils.this.infoByUsernameLoadingSet.remove(str);
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(new ApiServerException());
                    }
                }
            });
        } catch (Exception e) {
            this.infoByUsernameLoadingSet.remove(str);
            if (loadListener != null) {
                loadListener.onError(new ApiServerException());
            }
            this.coreLog.handleException(e);
            return 0;
        }
    }

    private int getObjectInfoFromServer(final String str, final NetworkHelper networkHelper, final DBHelper dBHelper, final AbsNotificationCenter absNotificationCenter, final LoadListener<String> loadListener, final TimerHelper timerHelper, final String str2, ChatType chatType, final UpdateBotInfoUsecase updateBotInfoUsecase) {
        String str3;
        ChatUtils chatUtils;
        String str4;
        ChatUtils chatUtils2 = this;
        if (chatUtils2.infoLoadingSet.contains(str2)) {
            return -1;
        }
        ChatAbsObject absObjectFromDB = chatUtils2.getAbsObjectFromDB(dBHelper, str2);
        final ChatType chatType2 = absObjectFromDB != null ? absObjectFromDB.type : chatType;
        chatUtils2.infoLoadingSet.add(str2);
        int userInfo = 0;
        if (chatType2 == ChatType.Service) {
            try {
                userInfo = networkHelper.getServiceInfo(str, new GetServiceInfoInput(str2), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetServiceInfoOutput>() { // from class: ir.aaap.messengercore.ChatUtils.68
                    @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                    public void onResponse(GetServiceInfoOutput getServiceInfoOutput) {
                        ChatUtils.this.infoLoadingSet.remove(str2);
                        if (getServiceInfoOutput != null) {
                            ChatUtils.this.infoUpdatedTimeMap.put(str2, Long.valueOf(System.currentTimeMillis()));
                            ChatUtils.this.processServiceInfoDidLoad(getServiceInfoOutput.service, getServiceInfoOutput.chat, getServiceInfoOutput.timestamp, dBHelper, absNotificationCenter);
                        }
                        if (timerHelper != null && ChatUtils.this.infoStartedSet.contains(str2)) {
                            ChatUtils.this.startInfoTimer(CoreMainClassImpl.getInfoUpdatePeriodMillis, str, networkHelper, dBHelper, absNotificationCenter, timerHelper, str2, chatType2, updateBotInfoUsecase);
                        }
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(str2);
                        }
                    }

                    @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                    public void onError(Exception exc) {
                        ChatUtils.this.infoLoadingSet.remove(str2);
                        absNotificationCenter.objectInfoLoadFailed(str2, chatType2);
                        if (timerHelper != null && ChatUtils.this.infoStartedSet.contains(str2)) {
                            ChatUtils.this.startInfoTimer(CoreMainClassImpl.getInfoUpdatePeriodMillis, str, networkHelper, dBHelper, absNotificationCenter, timerHelper, str2, chatType2, updateBotInfoUsecase);
                        }
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onError(exc);
                        }
                    }
                });
                chatUtils2 = this;
                str3 = str2;
            } catch (Exception e) {
                chatUtils2 = this;
                str3 = str2;
                chatUtils2.infoLoadingSet.remove(str3);
                chatUtils2.coreLog.handleException(e);
                if (loadListener != null) {
                    loadListener.onError(e);
                }
            }
            chatUtils = chatUtils2;
            str4 = str3;
        } else {
            str3 = str2;
            if (chatType2 == ChatType.Bot) {
                try {
                    userInfo = networkHelper.getBotInfo(str, new GetBotInfoInput(str3), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetBotInfoOutput>() { // from class: ir.aaap.messengercore.ChatUtils.69
                        @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                        public void onResponse(GetBotInfoOutput getBotInfoOutput) {
                            ChatUtils.this.infoLoadingSet.remove(str2);
                            if (getBotInfoOutput != null) {
                                ChatUtils.this.infoUpdatedTimeMap.put(str2, Long.valueOf(System.currentTimeMillis()));
                                ChatUtils.this.processBotInfoDidLoad(getBotInfoOutput.bot, getBotInfoOutput.chat, getBotInfoOutput.timestamp, dBHelper, absNotificationCenter);
                            }
                            if (timerHelper != null && ChatUtils.this.infoStartedSet.contains(str2)) {
                                ChatUtils.this.startInfoTimer(CoreMainClassImpl.getInfoUpdatePeriodMillis, str, networkHelper, dBHelper, absNotificationCenter, timerHelper, str2, chatType2, updateBotInfoUsecase);
                            }
                            LoadListener loadListener2 = loadListener;
                            if (loadListener2 != null) {
                                loadListener2.onDidLoad(str2);
                            }
                            UpdateBotInfoUsecase updateBotInfoUsecase2 = updateBotInfoUsecase;
                            if (updateBotInfoUsecase2 != null) {
                                updateBotInfoUsecase2.decreaseBotInfoDurationLevel(str2, chatType2);
                            }
                        }

                        @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                        public void onError(Exception exc) {
                            ChatUtils.this.infoLoadingSet.remove(str2);
                            absNotificationCenter.objectInfoLoadFailed(str2, chatType2);
                            if (timerHelper != null && ChatUtils.this.infoStartedSet.contains(str2)) {
                                ChatUtils.this.startInfoTimer(CoreMainClassImpl.getInfoUpdatePeriodMillis, str, networkHelper, dBHelper, absNotificationCenter, timerHelper, str2, chatType2, updateBotInfoUsecase);
                            }
                            LoadListener loadListener2 = loadListener;
                            if (loadListener2 != null) {
                                loadListener2.onError(exc);
                            }
                        }
                    });
                    chatUtils2 = this;
                    str3 = str2;
                } catch (Exception e2) {
                    chatUtils2 = this;
                    str3 = str2;
                    chatUtils2.infoLoadingSet.remove(str3);
                    chatUtils2.coreLog.handleException(e2);
                    if (loadListener != null) {
                        loadListener.onError(e2);
                    }
                }
                chatUtils = chatUtils2;
                str4 = str3;
            } else if (chatType2 == ChatType.Group) {
                try {
                    userInfo = networkHelper.getGroupInfo(str, new GetGroupInfoInput(str3), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetGroupInfoOutput>() { // from class: ir.aaap.messengercore.ChatUtils.70
                        @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                        public void onResponse(GetGroupInfoOutput getGroupInfoOutput) {
                            ChatUtils.this.infoLoadingSet.remove(str2);
                            if (getGroupInfoOutput != null) {
                                ChatUtils.this.infoUpdatedTimeMap.put(str2, Long.valueOf(System.currentTimeMillis()));
                                ChatUtils.this.processGroupInfoDidLoad(getGroupInfoOutput.group, getGroupInfoOutput.chat, getGroupInfoOutput.timestamp, dBHelper, absNotificationCenter);
                            }
                            if (timerHelper != null && ChatUtils.this.infoStartedSet.contains(str2)) {
                                ChatUtils.this.startInfoTimer(CoreMainClassImpl.getInfoUpdatePeriodMillis, str, networkHelper, dBHelper, absNotificationCenter, timerHelper, str2, chatType2, updateBotInfoUsecase);
                            }
                            LoadListener loadListener2 = loadListener;
                            if (loadListener2 != null) {
                                loadListener2.onDidLoad(str2);
                            }
                        }

                        @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                        public void onError(Exception exc) {
                            ChatUtils.this.infoLoadingSet.remove(str2);
                            absNotificationCenter.objectInfoLoadFailed(str2, chatType2);
                            if (timerHelper != null && ChatUtils.this.infoStartedSet.contains(str2)) {
                                ChatUtils.this.startInfoTimer(CoreMainClassImpl.getInfoUpdatePeriodMillis, str, networkHelper, dBHelper, absNotificationCenter, timerHelper, str2, chatType2, updateBotInfoUsecase);
                            }
                            LoadListener loadListener2 = loadListener;
                            if (loadListener2 != null) {
                                loadListener2.onError(exc);
                            }
                        }
                    });
                    chatUtils2 = this;
                    str3 = str2;
                } catch (Exception e3) {
                    chatUtils2 = this;
                    str3 = str2;
                    chatUtils2.infoLoadingSet.remove(str3);
                    chatUtils2.coreLog.handleException(e3);
                    if (loadListener != null) {
                        loadListener.onError(e3);
                    }
                }
                chatUtils = chatUtils2;
                str4 = str3;
            } else {
                if (chatType2 == ChatType.Channel) {
                    try {
                        userInfo = networkHelper.getChannelInfo(str, new GetChannelInfoInput(str3), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetChannelInfoOutput>() { // from class: ir.aaap.messengercore.ChatUtils.71
                            @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                            public void onResponse(GetChannelInfoOutput getChannelInfoOutput) {
                                ChatUtils.this.infoLoadingSet.remove(str2);
                                if (getChannelInfoOutput != null) {
                                    ChatUtils.this.infoUpdatedTimeMap.put(str2, Long.valueOf(System.currentTimeMillis()));
                                    ChatUtils.this.processChannelInfoDidLoad(getChannelInfoOutput.channel, getChannelInfoOutput.chat, getChannelInfoOutput.timestamp, dBHelper, absNotificationCenter);
                                }
                                if (timerHelper != null && ChatUtils.this.infoStartedSet.contains(str2)) {
                                    ChatUtils.this.startInfoTimer(CoreMainClassImpl.getInfoUpdatePeriodMillis, str, networkHelper, dBHelper, absNotificationCenter, timerHelper, str2, chatType2, updateBotInfoUsecase);
                                }
                                LoadListener loadListener2 = loadListener;
                                if (loadListener2 != null) {
                                    loadListener2.onDidLoad(str2);
                                }
                            }

                            @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                            public void onError(Exception exc) {
                                ChatUtils.this.infoLoadingSet.remove(str2);
                                absNotificationCenter.objectInfoLoadFailed(str2, chatType2);
                                if (timerHelper != null && ChatUtils.this.infoStartedSet.contains(str2)) {
                                    ChatUtils.this.startInfoTimer(CoreMainClassImpl.getInfoUpdatePeriodMillis, str, networkHelper, dBHelper, absNotificationCenter, timerHelper, str2, chatType2, updateBotInfoUsecase);
                                }
                                LoadListener loadListener2 = loadListener;
                                if (loadListener2 != null) {
                                    loadListener2.onError(exc);
                                }
                            }
                        });
                        chatUtils2 = this;
                        str3 = str2;
                    } catch (Exception e4) {
                        chatUtils2 = this;
                        str3 = str2;
                        chatUtils2.infoLoadingSet.remove(str3);
                        chatUtils2.coreLog.handleException(e4);
                        if (loadListener != null) {
                            loadListener.onError(e4);
                        }
                    }
                } else if (chatType2 == ChatType.User) {
                    GetUserInfoInput getUserInfoInput = new GetUserInfoInput();
                    getUserInfoInput.user_guid = str3;
                    try {
                        userInfo = networkHelper.getUserInfo(str, getUserInfoInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetUserInfoOutput>() { // from class: ir.aaap.messengercore.ChatUtils.72
                            @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                            public void onResponse(GetUserInfoOutput getUserInfoOutput) {
                                ChatUtils.this.infoLoadingSet.remove(str2);
                                if (getUserInfoOutput != null) {
                                    ChatUtils.this.infoUpdatedTimeMap.put(str2, Long.valueOf(System.currentTimeMillis()));
                                    ChatUtils.this.processUserInfoDidLoad(getUserInfoOutput.user, getUserInfoOutput.chat, getUserInfoOutput.count_common_groups, getUserInfoOutput.can_receive_call, getUserInfoOutput.can_video_call, getUserInfoOutput.is_in_contact, getUserInfoOutput.timestamp, dBHelper, true, absNotificationCenter);
                                }
                                if (timerHelper != null && ChatUtils.this.infoStartedSet.contains(str2)) {
                                    ChatUtils.this.startInfoTimer(CoreMainClassImpl.getInfoUpdatePeriodMillis, str, networkHelper, dBHelper, absNotificationCenter, timerHelper, str2, chatType2, updateBotInfoUsecase);
                                }
                                LoadListener loadListener2 = loadListener;
                                if (loadListener2 != null) {
                                    loadListener2.onDidLoad(str2);
                                }
                            }

                            @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                            public void onError(Exception exc) {
                                ChatUtils.this.infoLoadingSet.remove(str2);
                                absNotificationCenter.objectInfoLoadFailed(str2, chatType2);
                                if (timerHelper != null && ChatUtils.this.infoStartedSet.contains(str2)) {
                                    ChatUtils.this.startInfoTimer(CoreMainClassImpl.getInfoUpdatePeriodMillis, str, networkHelper, dBHelper, absNotificationCenter, timerHelper, str2, chatType2, updateBotInfoUsecase);
                                }
                                LoadListener loadListener2 = loadListener;
                                if (loadListener2 != null) {
                                    loadListener2.onError(exc);
                                }
                            }
                        });
                        chatUtils = this;
                        str4 = str2;
                    } catch (Exception e5) {
                        chatUtils = this;
                        str4 = str2;
                        chatUtils.infoLoadingSet.remove(str4);
                        chatUtils.coreLog.handleException(e5);
                        if (loadListener != null) {
                            loadListener.onError(e5);
                        }
                    }
                }
                chatUtils = chatUtils2;
                str4 = str3;
            }
        }
        chatUtils.infoRequestIdMap.put(str4, Integer.valueOf(userInfo));
        return userInfo;
    }

    public void cancelRefreshObjectInfo(String str) {
        if (CoreUtilities.isNotEmpty(str)) {
            this.infoLoadingSet.remove(str);
        }
    }

    private ObjectInfo getObjectInfoFromDb(String str, ChatType chatType, DBHelper dBHelper) {
        ServiceInfo serviceInfo;
        if (chatType == ChatType.Group) {
            GroupInfo groupInfo = dBHelper.getGroupInfo(str);
            if (groupInfo != null) {
                return ObjectInfo.createFromGroupInfo(groupInfo);
            }
            return null;
        }
        if (chatType == ChatType.Channel) {
            ChannelInfo channelInfo = dBHelper.getChannelInfo(str);
            if (channelInfo != null) {
                return ObjectInfo.createFromChannelInfo(channelInfo);
            }
            return null;
        }
        if (chatType == ChatType.User) {
            UserInfo userInfo = dBHelper.getUserInfo(str);
            if (userInfo != null) {
                return ObjectInfo.createFromUserInfo(userInfo);
            }
            return null;
        }
        if (chatType == ChatType.Bot) {
            BotInfo botInfo = dBHelper.getBotInfo(str);
            if (botInfo != null) {
                return ObjectInfo.createFromBotInfo(botInfo);
            }
            return null;
        }
        if (chatType != ChatType.Service || (serviceInfo = dBHelper.getServiceInfo(str)) == null) {
            return null;
        }
        return ObjectInfo.createFromServiceInfo(serviceInfo);
    }

    private ObjectInfo getObjectInfoByUsernameFromDb(String str, DBHelper dBHelper) {
        ChannelInfo channelInfoByUsername = dBHelper.getChannelInfoByUsername(str);
        if (channelInfoByUsername != null) {
            return ObjectInfo.createFromChannelInfo(channelInfoByUsername);
        }
        UserInfo userInfoByUsername = dBHelper.getUserInfoByUsername(str);
        if (userInfoByUsername != null) {
            return ObjectInfo.createFromUserInfo(userInfoByUsername);
        }
        BotInfo botInfoByUsername = dBHelper.getBotInfoByUsername(str);
        if (botInfoByUsername != null) {
            return ObjectInfo.createFromBotInfo(botInfoByUsername);
        }
        return null;
    }

    private boolean isInfoUpdated(ObjectInfo objectInfo) {
        return objectInfo != null && System.currentTimeMillis() - objectInfo.insertedToDbTime < CoreMainClassImpl.OBJECT_INFO_VALID_CACHE_DURATION;
    }

    public int getObjectInfoByUsername(String str, boolean z, String str2, NetworkHelper networkHelper, DBHelper dBHelper, AbsNotificationCenter absNotificationCenter, LoadListener<String> loadListener) {
        boolean z2;
        ChatAbsObject absObjectFromDB;
        boolean z3;
        if (str == null || str.isEmpty()) {
            if (loadListener != null) {
                loadListener.onError(new InputException());
            }
            return 0;
        }
        CoreUtilities.UsernameCheckType usernameCheckTypeCheckUserName = CoreUtilities.checkUserName(str);
        if (usernameCheckTypeCheckUserName != CoreUtilities.UsernameCheckType.Ok) {
            if (loadListener != null) {
                loadListener.onError(new UsernameException(usernameCheckTypeCheckUserName));
            }
            return 0;
        }
        String lowerCase = str.toLowerCase(Locale.ROOT);
        ObjectInfo objectInfoByUsernameFromDb = this.objectInfoByUsernameMap.get(lowerCase);
        boolean z4 = true;
        if (objectInfoByUsernameFromDb != null) {
            if (isInfoUpdated(objectInfoByUsernameFromDb)) {
                z2 = true;
                z3 = false;
            } else {
                z2 = true;
                z3 = true;
            }
        } else {
            objectInfoByUsernameFromDb = getObjectInfoByUsernameFromDb(lowerCase, dBHelper);
            if (objectInfoByUsernameFromDb == null || (absObjectFromDB = getAbsObjectFromDB(dBHelper, objectInfoByUsernameFromDb.objectGuid)) == null) {
                z2 = false;
                z3 = true;
            } else {
                z3 = !isInfoUpdated(objectInfoByUsernameFromDb);
                addToInfoMap(objectInfoByUsernameFromDb);
                addToAbsMap(absObjectFromDB, absObjectFromDB.timeStamp);
                z2 = true;
            }
        }
        if (z2 && getChatInstant(objectInfoByUsernameFromDb.objectGuid) == null) {
            z2 = false;
        } else {
            z4 = z3;
        }
        if (z2) {
            if (loadListener != null) {
                loadListener.onDidLoad(objectInfoByUsernameFromDb.objectGuid);
            }
            absNotificationCenter.objectInfoDidLoad(objectInfoByUsernameFromDb.objectGuid, objectInfoByUsernameFromDb.objectType);
        }
        if (z4 || z) {
            return getObjectInfoByUsernameFromServer(lowerCase, str2, networkHelper, dBHelper, absNotificationCenter, z2 ? null : loadListener);
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int refreshObjectInfoIfNeeded(java.lang.String r14, ir.aaap.messengercore.network.NetworkHelper r15, ir.aaap.messengercore.db.DBHelper r16, ir.aaap.messengercore.AbsNotificationCenter r17, ir.aaap.messengercore.LoadListener<java.lang.String> r18, java.lang.String r19, ir.aaap.messengercore.model.ChatType r20, boolean r21, ir.aaap.messengercore.usecase.UpdateBotInfoUsecase r22, boolean r23) {
        /*
            r13 = this;
            r10 = r13
            r3 = r16
            r4 = r17
            r7 = r19
            r8 = r20
            java.util.Map<java.lang.String, ir.aaap.messengercore.model.ObjectInfo> r0 = r10.objectInfoByIdMap
            java.lang.Object r0 = r0.get(r7)
            ir.aaap.messengercore.model.ObjectInfo r0 = (ir.aaap.messengercore.model.ObjectInfo) r0
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L1e
            boolean r0 = r13.isInfoUpdated(r0)
            r1 = 1
            if (r0 == 0) goto L39
            r2 = 0
            goto L39
        L1e:
            ir.aaap.messengercore.model.ObjectInfo r0 = r13.getObjectInfoFromDb(r7, r8, r3)
            if (r0 == 0) goto L39
            ir.aaap.messengercore.model.ChatAbsObject r5 = r13.getAbsObjectFromDB(r3, r7)
            if (r5 == 0) goto L39
            boolean r1 = r13.isInfoUpdated(r0)
            r1 = r1 ^ r2
            r13.addToInfoMap(r0)
            long r11 = r5.timeStamp
            r13.addToAbsMap(r5, r11)
            r2 = r1
            r1 = 1
        L39:
            if (r1 == 0) goto L4d
            if (r4 == 0) goto L40
            r4.objectInfoDidLoad(r7, r8)
        L40:
            if (r18 == 0) goto L4d
            if (r23 == 0) goto L46
            r0 = 0
            goto L48
        L46:
            r0 = r18
        L48:
            r18.onDidLoad(r19)
            r5 = r0
            goto L4f
        L4d:
            r5 = r18
        L4f:
            if (r2 != 0) goto L56
            if (r21 == 0) goto L54
            goto L56
        L54:
            r0 = -1
            return r0
        L56:
            r6 = 0
            r0 = r13
            r1 = r14
            r2 = r15
            r3 = r16
            r4 = r17
            r7 = r19
            r8 = r20
            r9 = r22
            int r0 = r0.getObjectInfoFromServer(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.aaap.messengercore.ChatUtils.refreshObjectInfoIfNeeded(java.lang.String, ir.aaap.messengercore.network.NetworkHelper, ir.aaap.messengercore.db.DBHelper, ir.aaap.messengercore.AbsNotificationCenter, ir.aaap.messengercore.LoadListener, java.lang.String, ir.aaap.messengercore.model.ChatType, boolean, ir.aaap.messengercore.usecase.UpdateBotInfoUsecase, boolean):int");
    }

    public UserInfo getMyUserInfo(KeyValueStorageHelper keyValueStorageHelper) {
        UserInfoFromServer userObject = keyValueStorageHelper.getUserObject();
        UserInfo userInfoCreateFromServerObject = UserInfo.createFromServerObject(userObject, 0L, 0L, false, false);
        userInfoCreateFromServerObject.insertedToDbTime = keyValueStorageHelper.getLastMyUserUpdateTime();
        addToInfoMap(ObjectInfo.createFromUserInfo(userInfoCreateFromServerObject));
        addToContactMap(userInfoCreateFromServerObject);
        addToAbsMap(ChatAbsObject.createFromUserInfo(userObject, 0L), 0L);
        return userInfoCreateFromServerObject;
    }

    public void loadMyUserInfoFromServer(String str, NetworkHelper networkHelper, final DBHelper dBHelper, final AbsNotificationCenter absNotificationCenter, final KeyValueStorageHelper keyValueStorageHelper) {
        if (this.isMyInfoLoading) {
            return;
        }
        this.isMyInfoLoading = true;
        UserInfoFromServer userObject = keyValueStorageHelper.getUserObject();
        if (userObject != null) {
            processUserInfoDidLoad(userObject, null, 0L, true, true, true, userObject.timestamp, dBHelper, false, null);
        }
        try {
            networkHelper.getUserInfo(str, new GetUserInfoInput(), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetUserInfoOutput>() { // from class: ir.aaap.messengercore.ChatUtils.73
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(GetUserInfoOutput getUserInfoOutput) {
                    ChatUtils.this.isMyInfoLoading = false;
                    if (getUserInfoOutput != null) {
                        UserInfoFromServer userInfoFromServer = getUserInfoOutput.user;
                        if (userInfoFromServer != null) {
                            ChatUtils.this.processUserInfoDidLoad(userInfoFromServer, getUserInfoOutput.chat, getUserInfoOutput.count_common_groups, getUserInfoOutput.can_receive_call, getUserInfoOutput.can_video_call, getUserInfoOutput.is_in_contact, getUserInfoOutput.timestamp, dBHelper, false, null);
                            String str2 = getUserInfoOutput.user.user_guid;
                            keyValueStorageHelper.setUserGuid(str2);
                            keyValueStorageHelper.setMyUserObject(getUserInfoOutput.user, System.currentTimeMillis());
                            absNotificationCenter.myUserInfoDidLoad(str2, ChatType.User);
                        }
                        ChatFromServer chatFromServer = getUserInfoOutput.chat;
                        if (chatFromServer != null) {
                            ChatUtils.this.addNewChatAndAbsToMapAndDb(chatFromServer, getUserInfoOutput.timestamp, true, dBHelper, absNotificationCenter);
                        }
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    ChatUtils.this.isMyInfoLoading = false;
                    absNotificationCenter.myUserInfoLoadFailed();
                }
            });
        } catch (Exception e) {
            this.isMyInfoLoading = false;
            this.coreLog.handleException(e);
        }
    }

    public int getProfileLinkItems(String str, String str2, NetworkHelper networkHelper, final LoadListener<GetProfileLinkItemsOutputs> loadListener) {
        try {
            return networkHelper.getProfileLinkItems(str2, new GetProfileLinkItemsInput(str), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetProfileLinkItemsOutputs>(this) { // from class: ir.aaap.messengercore.ChatUtils.74
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(GetProfileLinkItemsOutputs getProfileLinkItemsOutputs) {
                    if (getProfileLinkItemsOutputs != null) {
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(getProfileLinkItemsOutputs);
                            return;
                        }
                        return;
                    }
                    LoadListener loadListener3 = loadListener;
                    if (loadListener3 != null) {
                        loadListener3.onError(new ApiServerException());
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.coreLog.handleException(e);
            return 0;
        }
    }

    public void processUserInfoDidLoad(UserInfoFromServer userInfoFromServer, ChatFromServer chatFromServer, long j, boolean z, boolean z2, boolean z3, long j2, DBHelper dBHelper, boolean z4, AbsNotificationCenter absNotificationCenter) {
        String str;
        if (chatFromServer != null) {
            addNewChatAndAbsToMapAndDb(chatFromServer, j2, true, dBHelper, absNotificationCenter);
        }
        if (userInfoFromServer != null) {
            UserInfo userInfoCreateFromServerObject = UserInfo.createFromServerObject(userInfoFromServer, j2, j, z, z2);
            long jCurrentTimeMillis = System.currentTimeMillis();
            userInfoCreateFromServerObject.insertedToDbTime = jCurrentTimeMillis;
            userInfoCreateFromServerObject.timeStamp = j2;
            addToInfoMap(ObjectInfo.createFromUserInfo(userInfoCreateFromServerObject));
            if (z3) {
                dBHelper.addContact(userInfoCreateFromServerObject, jCurrentTimeMillis);
                addToContactMap(userInfoCreateFromServerObject);
            } else {
                dBHelper.removeContact(userInfoCreateFromServerObject.user_guid);
                removeFromContactMap(userInfoCreateFromServerObject.user_guid);
            }
            dBHelper.addUserInfo(userInfoCreateFromServerObject, jCurrentTimeMillis);
            ChatAbsObject chatAbsObjectCreateFromUserInfo = ChatAbsObject.createFromUserInfo(userInfoFromServer, j2);
            addToAbsMap(chatAbsObjectCreateFromUserInfo, j2);
            dBHelper.addAbsObject(chatAbsObjectCreateFromUserInfo, j2);
            if (!z4 || absNotificationCenter == null || (str = userInfoFromServer.user_guid) == null) {
                return;
            }
            absNotificationCenter.objectInfoDidLoad(str, ChatType.User);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processChannelInfoDidLoad(ChannelInfoFromServer channelInfoFromServer, ChatFromServer chatFromServer, long j, DBHelper dBHelper, AbsNotificationCenter absNotificationCenter) {
        if (chatFromServer != null) {
            addNewChatAndAbsToMapAndDb(chatFromServer, j, true, dBHelper, absNotificationCenter);
        }
        if (channelInfoFromServer != null) {
            ChannelInfo channelInfoCreateFromServerObject = ChannelInfo.createFromServerObject(channelInfoFromServer);
            long jCurrentTimeMillis = System.currentTimeMillis();
            channelInfoCreateFromServerObject.insertedToDbTime = jCurrentTimeMillis;
            addToInfoMap(ObjectInfo.createFromChannelInfo(channelInfoCreateFromServerObject));
            ChatAbsObject chatAbsObjectCreateFromChannelInfo = ChatAbsObject.createFromChannelInfo(channelInfoFromServer, j);
            addToAbsMap(chatAbsObjectCreateFromChannelInfo, j);
            dBHelper.addAbsObject(chatAbsObjectCreateFromChannelInfo, j);
            dBHelper.addChannelInfo(channelInfoCreateFromServerObject, jCurrentTimeMillis);
            absNotificationCenter.objectInfoDidLoad(channelInfoFromServer.channel_guid, ChatType.Channel);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processServiceInfoDidLoad(ServiceInfoFromServer serviceInfoFromServer, ChatFromServer chatFromServer, long j, DBHelper dBHelper, AbsNotificationCenter absNotificationCenter) {
        String str;
        if (chatFromServer != null) {
            addNewChatAndAbsToMapAndDb(chatFromServer, j, true, dBHelper, absNotificationCenter);
        }
        if (serviceInfoFromServer != null) {
            ServiceInfo serviceInfoCreateFromServerObject = ServiceInfo.createFromServerObject(serviceInfoFromServer);
            long jCurrentTimeMillis = System.currentTimeMillis();
            serviceInfoCreateFromServerObject.insertedToDbTime = jCurrentTimeMillis;
            addToInfoMap(ObjectInfo.createFromServiceInfo(serviceInfoCreateFromServerObject));
            ChatAbsObject chatAbsObjectCreateFromServiceInfo = ChatAbsObject.createFromServiceInfo(serviceInfoFromServer, j);
            addToAbsMap(chatAbsObjectCreateFromServiceInfo, j);
            dBHelper.addAbsObject(chatAbsObjectCreateFromServiceInfo, j);
            dBHelper.addServiceInfo(serviceInfoCreateFromServerObject, jCurrentTimeMillis);
            if (absNotificationCenter == null || (str = serviceInfoFromServer.service_guid) == null) {
                return;
            }
            absNotificationCenter.objectInfoDidLoad(str, ChatType.Service);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processBotInfoDidLoad(BotInfoFromServer botInfoFromServer, ChatFromServer chatFromServer, long j, DBHelper dBHelper, AbsNotificationCenter absNotificationCenter) {
        String str;
        if (chatFromServer != null) {
            addNewChatAndAbsToMapAndDb(chatFromServer, j, true, dBHelper, absNotificationCenter);
        }
        if (botInfoFromServer != null) {
            BotInfo botInfoCreateFromServerObject = BotInfo.createFromServerObject(botInfoFromServer);
            long jCurrentTimeMillis = System.currentTimeMillis();
            botInfoCreateFromServerObject.insertedToDbTime = jCurrentTimeMillis;
            addToInfoMap(ObjectInfo.createFromBotInfo(botInfoCreateFromServerObject));
            ChatAbsObject chatAbsObjectCreateFromBotInfo = ChatAbsObject.createFromBotInfo(botInfoFromServer, j);
            addToAbsMap(chatAbsObjectCreateFromBotInfo, j);
            dBHelper.addAbsObject(chatAbsObjectCreateFromBotInfo, j);
            dBHelper.addBotInfo(botInfoCreateFromServerObject, jCurrentTimeMillis);
            if (absNotificationCenter == null || (str = botInfoFromServer.bot_guid) == null) {
                return;
            }
            absNotificationCenter.objectInfoDidLoad(str, ChatType.Bot);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processGroupInfoDidLoad(GroupInfoFromServer groupInfoFromServer, ChatFromServer chatFromServer, long j, DBHelper dBHelper, AbsNotificationCenter absNotificationCenter) {
        String str;
        if (chatFromServer != null) {
            addNewChatAndAbsToMapAndDb(chatFromServer, j, true, dBHelper, absNotificationCenter);
        }
        if (groupInfoFromServer != null) {
            GroupInfo groupInfoCreateFromServerObject = GroupInfo.createFromServerObject(groupInfoFromServer);
            long jCurrentTimeMillis = System.currentTimeMillis();
            groupInfoCreateFromServerObject.insertedToDbTime = jCurrentTimeMillis;
            addToInfoMap(ObjectInfo.createFromGroupInfo(groupInfoCreateFromServerObject));
            ChatAbsObject chatAbsObjectCreateFromGroupInfo = ChatAbsObject.createFromGroupInfo(groupInfoFromServer, j);
            addToAbsMap(chatAbsObjectCreateFromGroupInfo, j);
            dBHelper.addAbsObject(chatAbsObjectCreateFromGroupInfo, j);
            dBHelper.addGroupInfo(groupInfoCreateFromServerObject, jCurrentTimeMillis);
            if (absNotificationCenter == null || (str = groupInfoFromServer.group_guid) == null) {
                return;
            }
            absNotificationCenter.objectInfoDidLoad(str, ChatType.Group);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addNewChatAndAbsToMapAndDb(ArrayList<ChatFromServer> arrayList, long j, boolean z, DBHelper dBHelper, AbsNotificationCenter absNotificationCenter) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<ChatFromServer> it = arrayList.iterator();
        while (it.hasNext()) {
            ChatFromServer next = it.next();
            Chat chatCreateFromServerObject = Chat.createFromServerObject(next, j);
            addToChatMap(chatCreateFromServerObject, z, absNotificationCenter, dBHelper);
            addToAbsMap(next.abs_object, j);
            dBHelper.addAbsObject(next.abs_object, j);
            arrayList2.add(chatCreateFromServerObject);
        }
        dBHelper.addAllChats(arrayList2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addNewChatAndAbsToMapAndDb(ChatFromServer chatFromServer, long j, boolean z, DBHelper dBHelper, AbsNotificationCenter absNotificationCenter) {
        ArrayList<ChatFromServer> arrayList = new ArrayList<>();
        arrayList.add(chatFromServer);
        addNewChatAndAbsToMapAndDb(arrayList, j, z, dBHelper, absNotificationCenter);
    }

    public void changeChatExtra(String str, ChatExtra chatExtra, DBHelper dBHelper) {
        Chat chatInstant = getChatInstant(str);
        if (chatInstant == null) {
            return;
        }
        chatInstant.chatExtra = chatExtra;
        chatInstant.fillAttributes();
        ChatExtra chatExtra2 = chatInstant.chatExtra;
        if (chatExtra2 != null) {
            dBHelper.addOrUpdateChatExtra(chatExtra2);
        } else {
            dBHelper.removeChatExtra(str);
        }
    }

    public void updateChatLastLocal(String str, Message message, DBHelper dBHelper, AbsNotificationCenter absNotificationCenter) {
        Chat chat;
        if (message == null || (chat = this.chatMap.get(str)) == null) {
            return;
        }
        ChatExtra chatExtra = chat.chatExtra;
        if (chatExtra == null) {
            chat.chatExtra = new ChatExtra(str);
        } else {
            ChatMessage chatMessage = chatExtra.local_last_message;
            if (chatMessage != null && Math.abs(chatMessage.message_id) > Math.abs(message.message_id)) {
                return;
            }
        }
        chat.chatExtra.local_last_message = ChatMessage.createFromLocalMessage(message);
        ChatExtra chatExtra2 = chat.chatExtra;
        chatExtra2.local_last_message_send_state = message.sendState;
        chatExtra2.local_last_message_prev_message_id = message.localParametersObject.prevMessageId;
        chatExtra2.local_time = message.time;
        chat.fillAttributes();
        dBHelper.addOrUpdateChatExtra(chat.chatExtra);
        createAndSortChatList(absNotificationCenter, new ChatNeedReloadResult(ChatNeedReloadResult.TypeEnum.AllListUpdated), dBHelper);
    }

    public void editChatLastMessage(String str, Message message, DBHelper dBHelper, AbsNotificationCenter absNotificationCenter) {
        Chat chat = this.chatMap.get(str);
        if (chat != null && chat.last_message_id == message.message_id) {
            chat.last_message.text = message.text;
            if (chat.chatExtra == null) {
                chat.chatExtra = new ChatExtra(str);
            }
            chat.fillAttributes();
            dBHelper.addOrUpdateChatExtra(chat.chatExtra);
            dBHelper.updateChatLastMessageText(str, message.text);
            createAndSortChatList(absNotificationCenter, new ChatNeedReloadResult(ChatNeedReloadResult.TypeEnum.AllListUpdated), dBHelper);
        }
    }

    public void removeChatLastLocal(String str, DBHelper dBHelper, AbsNotificationCenter absNotificationCenter, boolean z) {
        ChatExtra chatExtra;
        Chat chat = this.chatMap.get(str);
        if (chat == null || (chatExtra = chat.chatExtra) == null) {
            return;
        }
        chatExtra.local_last_message = null;
        chatExtra.local_last_message_prev_message_id = 0L;
        chatExtra.local_time = 0L;
        chat.fillAttributes();
        dBHelper.addOrUpdateChatExtra(chat.chatExtra);
        if (z) {
            createAndSortChatList(absNotificationCenter, new ChatNeedReloadResult(ChatNeedReloadResult.TypeEnum.AllListUpdated), dBHelper);
        }
    }

    public void toggleMuteChat(final String str, final boolean z, String str2, NetworkHelper networkHelper, final DBHelper dBHelper, final AbsNotificationCenter absNotificationCenter) {
        final Chat chat = this.chatMap.get(str);
        if (chat == null || chat.is_mute == z) {
            return;
        }
        chat.is_mute = z;
        absNotificationCenter.notificationsSettingsUpdated(str);
        Integer num = this.chatToggleMuteRequestingIdMap.get(str);
        if (num != null) {
            networkHelper.cancelCall(num.intValue());
            this.chatToggleMuteRequestingIdMap.remove(str);
        }
        SetChatActionInput setChatActionInput = new SetChatActionInput();
        setChatActionInput.action = z ? SetChatActionInput.ChatAction.Mute : SetChatActionInput.ChatAction.Unmute;
        setChatActionInput.object_guid = str;
        try {
            this.chatToggleMuteRequestingIdMap.put(str, Integer.valueOf(networkHelper.setActionChat(str2, setChatActionInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<SetChatActionOutput>() { // from class: ir.aaap.messengercore.ChatUtils.75
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(SetChatActionOutput setChatActionOutput) {
                    ChatUtils.this.chatToggleMuteRequestingIdMap.remove(str);
                    ChatUtils.this.processChatsUpdate(setChatActionOutput.chat_update, (UpdateChatUsecase) null, absNotificationCenter, dBHelper);
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    ChatUtils.this.chatToggleMuteRequestingIdMap.remove(str);
                    chat.is_mute = !z;
                    absNotificationCenter.notificationsSettingsUpdated(str);
                }
            })));
        } catch (Exception e) {
            this.coreLog.handleException(e);
            chat.is_mute = !z;
            absNotificationCenter.notificationsSettingsUpdated(str);
        }
    }

    public void joinGroup(final String str, String str2, final UpdateChatAndMessageUsecase updateChatAndMessageUsecase, final LoadListener<String> loadListener, String str3, NetworkHelper networkHelper, final DBHelper dBHelper, final AbsNotificationCenter absNotificationCenter) {
        if (CoreUtilities.isNotEmpty(str2)) {
            Integer num = this.joinOrLeaveRequestingIdMap.get(str);
            if (num != null) {
                networkHelper.cancelCall(num.intValue());
                this.joinOrLeaveRequestingIdMap.remove(str);
            }
            try {
                this.joinOrLeaveRequestingIdMap.put(str, Integer.valueOf(networkHelper.joinGroup(str3, new JoinGroupInput(str2), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<JoinGroupOutput>() { // from class: ir.aaap.messengercore.ChatUtils.76
                    @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                    public void onResponse(JoinGroupOutput joinGroupOutput) {
                        ChatUtils.this.joinOrLeaveRequestingIdMap.remove(str);
                        if (joinGroupOutput.is_valid) {
                            GroupInfoFromServer groupInfoFromServer = joinGroupOutput.group;
                            if (groupInfoFromServer != null) {
                                ChatUtils.this.processGroupInfoDidLoad(groupInfoFromServer, null, joinGroupOutput.timestamp, dBHelper, absNotificationCenter);
                            }
                            UpdateChatAndMessageUsecase updateChatAndMessageUsecase2 = updateChatAndMessageUsecase;
                            if (updateChatAndMessageUsecase2 != null) {
                                updateChatAndMessageUsecase2.processMessageAndChatUpdate(joinGroupOutput.message_update, joinGroupOutput.chat_update, false, true);
                            }
                            LoadListener loadListener2 = loadListener;
                            if (loadListener2 != null) {
                                loadListener2.onDidLoad(str);
                                return;
                            }
                            return;
                        }
                        LoadListener loadListener3 = loadListener;
                        if (loadListener3 != null) {
                            loadListener3.onError(new InputException(InputException.ErrorEnum.IsInvalidInput));
                        }
                    }

                    @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                    public void onError(Exception exc) {
                        ChatUtils.this.joinOrLeaveRequestingIdMap.remove(str);
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onError(exc);
                        }
                    }
                })));
            } catch (Exception e) {
                this.coreLog.handleException(e);
                if (loadListener != null) {
                    loadListener.onError(e);
                }
            }
        }
    }

    public int addGroup(String str, ArrayList<String> arrayList, String str2, String str3, String str4, NetworkHelper networkHelper, final DBHelper dBHelper, final AbsNotificationCenter absNotificationCenter, final UpdateChatAndMessageUsecase updateChatAndMessageUsecase, final LoadListener<String> loadListener) {
        int iAddGroup = 0;
        if (str == null || str.isEmpty()) {
            return 0;
        }
        AddGroupInput addGroupInput = new AddGroupInput();
        addGroupInput.title = str;
        addGroupInput.member_guids = arrayList;
        if (str2 != null && str3 != null) {
            addGroupInput.main_file_id = str2;
            addGroupInput.thumbnail_file_id = str3;
        }
        try {
            iAddGroup = networkHelper.addGroup(str4, addGroupInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<AddOrEditGroupOutput>() { // from class: ir.aaap.messengercore.ChatUtils.77
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(AddOrEditGroupOutput addOrEditGroupOutput) {
                    GroupInfoFromServer groupInfoFromServer = addOrEditGroupOutput.group;
                    String str5 = groupInfoFromServer != null ? groupInfoFromServer.group_guid : BuildConfig.FLAVOR;
                    UpdateChatAndMessageUsecase updateChatAndMessageUsecase2 = updateChatAndMessageUsecase;
                    if (updateChatAndMessageUsecase2 != null) {
                        updateChatAndMessageUsecase2.processMessageAndChatUpdate(addOrEditGroupOutput.message_update, addOrEditGroupOutput.chat_update, false, true);
                    }
                    GroupInfoFromServer groupInfoFromServer2 = addOrEditGroupOutput.group;
                    if (groupInfoFromServer2 != null) {
                        ChatUtils.this.processGroupInfoDidLoad(groupInfoFromServer2, null, addOrEditGroupOutput.timestamp, dBHelper, absNotificationCenter);
                    }
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(str5);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            this.coreLog.handleException(e);
            if (loadListener != null) {
                loadListener.onError(e);
            }
        }
        return iAddGroup;
    }

    public int deleteGroup(final String str, String str2, NetworkHelper networkHelper, final DBHelper dBHelper, final AbsNotificationCenter absNotificationCenter, final UpdateChatUsecase updateChatUsecase, final LoadListener<String> loadListener) {
        int iRemoveGroup = 0;
        if (str == null || str.isEmpty()) {
            return 0;
        }
        try {
            iRemoveGroup = networkHelper.removeGroup(str2, new RemoveGroupInput(str), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<RemoveGroupOrChannelOutput>() { // from class: ir.aaap.messengercore.ChatUtils.78
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(RemoveGroupOrChannelOutput removeGroupOrChannelOutput) {
                    ChatUtils.this.processChatsUpdate(removeGroupOrChannelOutput.chat_update, updateChatUsecase, absNotificationCenter, dBHelper);
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(str);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            this.coreLog.handleException(e);
            if (loadListener != null) {
                loadListener.onError(e);
            }
        }
        return iRemoveGroup;
    }

    public int clearChatHistory(final String str, ChatType chatType, long j, String str2, NetworkHelper networkHelper, final DBHelper dBHelper, final AbsNotificationCenter absNotificationCenter, final UpdateChatUsecase updateChatUsecase, final LoadListener<String> loadListener) {
        int iDeleteChatHistory = 0;
        if (chatType != ChatType.Group && chatType != ChatType.User && chatType != ChatType.Service) {
            return 0;
        }
        if (str == null || str.isEmpty()) {
            return 0;
        }
        DeleteChatHistoryInput deleteChatHistoryInput = new DeleteChatHistoryInput();
        deleteChatHistoryInput.object_guid = str;
        deleteChatHistoryInput.last_message_id = j;
        try {
            iDeleteChatHistory = networkHelper.deleteChatHistory(str2, deleteChatHistoryInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<DeleteChatOutput>() { // from class: ir.aaap.messengercore.ChatUtils.79
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(DeleteChatOutput deleteChatOutput) {
                    UpdateChatUsecase updateChatUsecase2 = updateChatUsecase;
                    if (updateChatUsecase2 != null) {
                        updateChatUsecase2.onChatClearHistory(new ArrayList<>(Arrays.asList(str)));
                    }
                    if (deleteChatOutput != null) {
                        ChatUtils.this.processChatsUpdate(deleteChatOutput.chat_update, updateChatUsecase, absNotificationCenter, dBHelper);
                    }
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(str);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            this.coreLog.handleException(e);
            if (loadListener != null) {
                loadListener.onError(e);
            }
        }
        return iDeleteChatHistory;
    }

    public int deleteChat(final String str, ChatType chatType, long j, String str2, NetworkHelper networkHelper, final DBHelper dBHelper, final AbsNotificationCenter absNotificationCenter, KeyValueStorageHelper keyValueStorageHelper, final UpdateChatUsecase updateChatUsecase, final LoadListener<String> loadListener) {
        LoadListener<DeleteChatOutput> loadListener2 = new LoadListener<DeleteChatOutput>() { // from class: ir.aaap.messengercore.ChatUtils.80
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(DeleteChatOutput deleteChatOutput) {
                ChatUpdateObject chatUpdateObject;
                if (deleteChatOutput != null && (chatUpdateObject = deleteChatOutput.chat_update) != null) {
                    ChatUtils.this.processChatsUpdate(chatUpdateObject, updateChatUsecase, absNotificationCenter, dBHelper);
                }
                LoadListener loadListener3 = loadListener;
                if (loadListener3 != null) {
                    loadListener3.onDidLoad(str);
                }
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                LoadListener loadListener3 = loadListener;
                if (loadListener3 != null) {
                    loadListener3.onError(exc);
                }
            }
        };
        if (chatType == ChatType.User) {
            return deleteUserChat(str, j, str2, networkHelper, loadListener2);
        }
        if (chatType == ChatType.Bot) {
            return deleteBotChat(str, j, str2, networkHelper, loadListener2);
        }
        if (chatType == ChatType.Service) {
            return deleteServiceChat(str, j, str2, networkHelper, loadListener2);
        }
        return 0;
    }

    private int deleteBotChat(String str, long j, String str2, NetworkHelper networkHelper, final LoadListener<DeleteChatOutput> loadListener) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        BotModels.DeleteBotChatInput deleteBotChatInput = new BotModels.DeleteBotChatInput();
        deleteBotChatInput.bot_guid = str;
        deleteBotChatInput.last_deleted_message_id = j;
        try {
            return networkHelper.deleteBotChat(str2, deleteBotChatInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<DeleteChatOutput>(this) { // from class: ir.aaap.messengercore.ChatUtils.81
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(DeleteChatOutput deleteChatOutput) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(deleteChatOutput);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            this.coreLog.handleException(e);
            if (loadListener == null) {
                return 0;
            }
            loadListener.onError(e);
            return 0;
        }
    }

    private int deleteServiceChat(String str, long j, String str2, NetworkHelper networkHelper, final LoadListener<DeleteChatOutput> loadListener) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        DeleteServiceChatInput deleteServiceChatInput = new DeleteServiceChatInput();
        deleteServiceChatInput.service_guid = str;
        deleteServiceChatInput.last_deleted_message_id = j;
        try {
            return networkHelper.deleteServiceChat(str2, deleteServiceChatInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<DeleteChatOutput>(this) { // from class: ir.aaap.messengercore.ChatUtils.82
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(DeleteChatOutput deleteChatOutput) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(deleteChatOutput);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            this.coreLog.handleException(e);
            if (loadListener == null) {
                return 0;
            }
            loadListener.onError(e);
            return 0;
        }
    }

    private int deleteUserChat(String str, long j, String str2, NetworkHelper networkHelper, final LoadListener<DeleteChatOutput> loadListener) {
        if (str == null || str.isEmpty()) {
            if (loadListener != null) {
                loadListener.onError(new InputException());
            }
            return 0;
        }
        DeleteUserChatInput deleteUserChatInput = new DeleteUserChatInput();
        deleteUserChatInput.user_guid = str;
        deleteUserChatInput.last_deleted_message_id = j;
        try {
            return networkHelper.deleteUserChat(str2, deleteUserChatInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<DeleteChatOutput>(this) { // from class: ir.aaap.messengercore.ChatUtils.83
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(DeleteChatOutput deleteChatOutput) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(deleteChatOutput);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            this.coreLog.handleException(e);
            if (loadListener == null) {
                return 0;
            }
            loadListener.onError(e);
            return 0;
        }
    }

    public int getGroupMessageReadParticipants(String str, long j, final String str2, final NetworkHelper networkHelper, final DBHelper dBHelper, final LoadListener<GetGroupMessageReadParticipantsResult> loadListener) {
        if (str == null || str.isEmpty()) {
            if (loadListener != null) {
                loadListener.onError(new InputException());
            }
            return 0;
        }
        try {
            return networkHelper.getGroupMessageReadParticipants(str2, new GetGroupMessageReadParticipantsInput(str, j), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetGroupMessageReadParticipantsOutput>() { // from class: ir.aaap.messengercore.ChatUtils.84
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(GetGroupMessageReadParticipantsOutput getGroupMessageReadParticipantsOutput) {
                    final GetGroupMessageReadParticipantsResult getGroupMessageReadParticipantsResult = new GetGroupMessageReadParticipantsResult();
                    GetGroupMessageReadParticipantsOutput.StatusEnum statusEnum = getGroupMessageReadParticipantsOutput.status;
                    getGroupMessageReadParticipantsResult.status = statusEnum;
                    Map<String, Long> map = getGroupMessageReadParticipantsOutput.read_participants;
                    getGroupMessageReadParticipantsResult.read_participants = map;
                    if (statusEnum == GetGroupMessageReadParticipantsOutput.StatusEnum.OK && map != null && map.size() > 0) {
                        ChatUtils.this.loadAbsObjectsIfNeeded(str2, networkHelper, dBHelper, getGroupMessageReadParticipantsOutput.read_participants.keySet(), false, new LoadListener<Set<String>>() { // from class: ir.aaap.messengercore.ChatUtils.84.1
                            @Override // ir.aaap.messengercore.LoadListener
                            public void onDidLoad(Set<String> set) {
                                AnonymousClass84 anonymousClass84 = AnonymousClass84.this;
                                if (loadListener != null) {
                                    ChatUtils.this.makeGroupMessageReadParticipantsResultFromAbs(getGroupMessageReadParticipantsResult, dBHelper);
                                    loadListener.onDidLoad(getGroupMessageReadParticipantsResult);
                                }
                            }

                            @Override // ir.aaap.messengercore.LoadListener
                            public void onError(Exception exc) {
                                AnonymousClass84 anonymousClass84 = AnonymousClass84.this;
                                if (loadListener != null) {
                                    ChatUtils.this.makeGroupMessageReadParticipantsResultFromAbs(getGroupMessageReadParticipantsResult, dBHelper);
                                    loadListener.onDidLoad(getGroupMessageReadParticipantsResult);
                                }
                            }
                        });
                        return;
                    }
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(getGroupMessageReadParticipantsResult);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            this.coreLog.handleException(e);
            if (loadListener == null) {
                return 0;
            }
            loadListener.onError(e);
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void makeGroupMessageReadParticipantsResultFromAbs(GetGroupMessageReadParticipantsResult getGroupMessageReadParticipantsResult, DBHelper dBHelper) {
        Map<String, Long> map = getGroupMessageReadParticipantsResult.read_participants;
        if (map == null || map.size() == 0) {
            return;
        }
        if (getGroupMessageReadParticipantsResult.chatAbsObjectMap == null) {
            getGroupMessageReadParticipantsResult.chatAbsObjectMap = new HashMap();
        }
        for (String str : getGroupMessageReadParticipantsResult.read_participants.keySet()) {
            ChatAbsObject chatAbsInstant = getChatAbsInstant(str, dBHelper);
            if (chatAbsInstant != null) {
                getGroupMessageReadParticipantsResult.chatAbsObjectMap.put(str, chatAbsInstant);
            }
        }
    }

    public int deleteChannel(final String str, String str2, NetworkHelper networkHelper, final DBHelper dBHelper, final AbsNotificationCenter absNotificationCenter, final UpdateChatUsecase updateChatUsecase, final LoadListener<String> loadListener) {
        int iRemoveChannel = 0;
        if (str == null || str.isEmpty()) {
            return 0;
        }
        try {
            iRemoveChannel = networkHelper.removeChannel(str2, new RemoveChannelInput(str), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<RemoveGroupOrChannelOutput>() { // from class: ir.aaap.messengercore.ChatUtils.85
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(RemoveGroupOrChannelOutput removeGroupOrChannelOutput) {
                    ChatUtils.this.processChatsUpdate(removeGroupOrChannelOutput.chat_update, updateChatUsecase, absNotificationCenter, dBHelper);
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(str);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            this.coreLog.handleException(e);
            if (loadListener != null) {
                loadListener.onError(e);
            }
        }
        return iRemoveChannel;
    }

    public int editGroup(String str, int i, String str2, NetworkHelper networkHelper, final DBHelper dBHelper, final AbsNotificationCenter absNotificationCenter, final UpdateChatAndMessageUsecase updateChatAndMessageUsecase, final LoadListener<String> loadListener) {
        int iEditGroupInfo = 0;
        if (str == null || str.isEmpty()) {
            if (loadListener != null) {
                loadListener.onError(new InputException(InputException.ErrorEnum.IsInvalidInput));
            }
            return 0;
        }
        EditGroupInfoInput editGroupInfoInput = new EditGroupInfoInput();
        editGroupInfoInput.group_guid = str;
        editGroupInfoInput.slow_mode = i;
        ArrayList<String> arrayList = new ArrayList<>();
        editGroupInfoInput.updated_parameters = arrayList;
        arrayList.add("slow_mode");
        try {
            iEditGroupInfo = networkHelper.editGroupInfo(str2, editGroupInfoInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<AddOrEditGroupOutput>() { // from class: ir.aaap.messengercore.ChatUtils.86
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(AddOrEditGroupOutput addOrEditGroupOutput) {
                    GroupInfoFromServer groupInfoFromServer = addOrEditGroupOutput.group;
                    String str3 = groupInfoFromServer != null ? groupInfoFromServer.group_guid : BuildConfig.FLAVOR;
                    UpdateChatAndMessageUsecase updateChatAndMessageUsecase2 = updateChatAndMessageUsecase;
                    if (updateChatAndMessageUsecase2 != null) {
                        updateChatAndMessageUsecase2.processMessageAndChatUpdate(addOrEditGroupOutput.message_update, addOrEditGroupOutput.chat_update, false, true);
                    }
                    GroupInfoFromServer groupInfoFromServer2 = addOrEditGroupOutput.group;
                    if (groupInfoFromServer2 != null) {
                        ChatUtils.this.processGroupInfoDidLoad(groupInfoFromServer2, null, addOrEditGroupOutput.timestamp, dBHelper, absNotificationCenter);
                    }
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(str3);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            this.coreLog.handleException(e);
            if (loadListener != null) {
                loadListener.onError(e);
            }
        }
        return iEditGroupInfo;
    }

    public int editGroup(String str, ChatReactionSetting chatReactionSetting, String str2, NetworkHelper networkHelper, final DBHelper dBHelper, final AbsNotificationCenter absNotificationCenter, final UpdateChatAndMessageUsecase updateChatAndMessageUsecase, final LoadListener<String> loadListener) {
        int iEditGroupInfo = 0;
        if (str == null || str.isEmpty() || chatReactionSetting == null) {
            if (loadListener != null) {
                loadListener.onError(new InputException(InputException.ErrorEnum.IsInvalidInput));
            }
            return 0;
        }
        ObjectInfo objectInfoInstant = getObjectInfoInstant(str);
        if (objectInfoInstant == null) {
            if (loadListener != null) {
                loadListener.onError(new InputException(InputException.ErrorEnum.IsInvalidInput));
            }
            return 0;
        }
        GroupInfo groupInfo = objectInfoInstant.groupInfo;
        if (groupInfo == null) {
            if (loadListener != null) {
                loadListener.onError(new InputException(InputException.ErrorEnum.IsInvalidInput));
            }
            return 0;
        }
        if (Objects.equals(chatReactionSetting, groupInfo.chat_reaction_setting)) {
            if (loadListener != null) {
                loadListener.onDidLoad(str);
            }
            return 0;
        }
        EditGroupInfoInput editGroupInfoInput = new EditGroupInfoInput();
        editGroupInfoInput.group_guid = str;
        editGroupInfoInput.chat_reaction_setting = chatReactionSetting;
        ArrayList<String> arrayList = new ArrayList<>();
        editGroupInfoInput.updated_parameters = arrayList;
        arrayList.add("chat_reaction_setting");
        try {
            iEditGroupInfo = networkHelper.editGroupInfo(str2, editGroupInfoInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<AddOrEditGroupOutput>() { // from class: ir.aaap.messengercore.ChatUtils.87
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(AddOrEditGroupOutput addOrEditGroupOutput) {
                    GroupInfoFromServer groupInfoFromServer = addOrEditGroupOutput.group;
                    String str3 = groupInfoFromServer != null ? groupInfoFromServer.group_guid : BuildConfig.FLAVOR;
                    UpdateChatAndMessageUsecase updateChatAndMessageUsecase2 = updateChatAndMessageUsecase;
                    if (updateChatAndMessageUsecase2 != null) {
                        updateChatAndMessageUsecase2.processMessageAndChatUpdate(addOrEditGroupOutput.message_update, addOrEditGroupOutput.chat_update, false, true);
                    }
                    GroupInfoFromServer groupInfoFromServer2 = addOrEditGroupOutput.group;
                    if (groupInfoFromServer2 != null) {
                        ChatUtils.this.processGroupInfoDidLoad(groupInfoFromServer2, null, addOrEditGroupOutput.timestamp, dBHelper, absNotificationCenter);
                    }
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(str3);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            this.coreLog.handleException(e);
            if (loadListener != null) {
                loadListener.onError(e);
            }
        }
        return iEditGroupInfo;
    }

    public int editGroup(String str, String str2, String str3, boolean z, boolean z2, String str4, NetworkHelper networkHelper, final DBHelper dBHelper, final AbsNotificationCenter absNotificationCenter, final UpdateChatAndMessageUsecase updateChatAndMessageUsecase, final LoadListener<String> loadListener) {
        if (str == null || str.isEmpty()) {
            if (loadListener != null) {
                loadListener.onError(new InputException(InputException.ErrorEnum.IsInvalidInput));
            }
            return 0;
        }
        ObjectInfo objectInfoInstant = getObjectInfoInstant(str);
        if (objectInfoInstant == null) {
            if (loadListener != null) {
                loadListener.onError(new InputException(InputException.ErrorEnum.IsInvalidInput));
            }
            return 0;
        }
        ChatAbsObject chatAbsInstant = getChatAbsInstant(str, dBHelper);
        if (chatAbsInstant == null) {
            if (loadListener != null) {
                loadListener.onError(new InputException(InputException.ErrorEnum.IsInvalidInput));
            }
            return 0;
        }
        GroupInfo groupInfo = objectInfoInstant.groupInfo;
        if (groupInfo == null) {
            if (loadListener != null) {
                loadListener.onError(new InputException(InputException.ErrorEnum.IsInvalidInput));
            }
            return 0;
        }
        String str5 = (str2 == null || !str2.isEmpty()) ? str2 : null;
        String str6 = (str3 == null || !str3.isEmpty()) ? str3 : null;
        EditGroupInfoInput editGroupInfoInput = new EditGroupInfoInput();
        editGroupInfoInput.group_guid = str;
        if (editGroupInfoInput.updated_parameters == null) {
            editGroupInfoInput.updated_parameters = new ArrayList<>();
        }
        if (!Objects.equals(str5, chatAbsInstant.title)) {
            editGroupInfoInput.title = str5;
            editGroupInfoInput.updated_parameters.add("title");
        }
        if (!Objects.equals(str6, groupInfo.description)) {
            editGroupInfoInput.description = str6;
            editGroupInfoInput.updated_parameters.add("description");
        }
        if (!Objects.equals(Boolean.valueOf(z), Boolean.valueOf(groupInfo.event_messages))) {
            editGroupInfoInput.event_messages = z;
            editGroupInfoInput.updated_parameters.add("event_messages");
        }
        GroupInfoFromServer.ChatHistoryForNewMembers chatHistoryForNewMembers = z2 ? GroupInfoFromServer.ChatHistoryForNewMembers.Hidden : GroupInfoFromServer.ChatHistoryForNewMembers.Visible;
        if (!Objects.equals(chatHistoryForNewMembers, groupInfo.chat_history_for_new_members)) {
            editGroupInfoInput.chat_history_for_new_members = chatHistoryForNewMembers;
            editGroupInfoInput.updated_parameters.add("chat_history_for_new_members");
        }
        if (editGroupInfoInput.updated_parameters.size() == 0) {
            if (loadListener != null) {
                loadListener.onDidLoad(str);
            }
            return 0;
        }
        try {
            return networkHelper.editGroupInfo(str4, editGroupInfoInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<AddOrEditGroupOutput>() { // from class: ir.aaap.messengercore.ChatUtils.88
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(AddOrEditGroupOutput addOrEditGroupOutput) {
                    GroupInfoFromServer groupInfoFromServer = addOrEditGroupOutput.group;
                    String str7 = groupInfoFromServer != null ? groupInfoFromServer.group_guid : BuildConfig.FLAVOR;
                    UpdateChatAndMessageUsecase updateChatAndMessageUsecase2 = updateChatAndMessageUsecase;
                    if (updateChatAndMessageUsecase2 != null) {
                        updateChatAndMessageUsecase2.processMessageAndChatUpdate(addOrEditGroupOutput.message_update, addOrEditGroupOutput.chat_update, false, true);
                    }
                    GroupInfoFromServer groupInfoFromServer2 = addOrEditGroupOutput.group;
                    if (groupInfoFromServer2 != null) {
                        ChatUtils.this.processGroupInfoDidLoad(groupInfoFromServer2, null, addOrEditGroupOutput.timestamp, dBHelper, absNotificationCenter);
                    }
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(str7);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            this.coreLog.handleException(e);
            if (loadListener == null) {
                return 0;
            }
            loadListener.onError(e);
            return 0;
        }
    }

    public int editChannel(String str, String str2, String str3, boolean z, boolean z2, String str4, NetworkHelper networkHelper, final DBHelper dBHelper, final AbsNotificationCenter absNotificationCenter, final UpdateChatAndMessageUsecase updateChatAndMessageUsecase, final LoadListener<String> loadListener) {
        if (str == null || str.isEmpty()) {
            if (loadListener != null) {
                loadListener.onError(new InputException(InputException.ErrorEnum.IsInvalidInput));
            }
            return 0;
        }
        ObjectInfo objectInfoInstant = getObjectInfoInstant(str);
        if (objectInfoInstant == null) {
            if (loadListener != null) {
                loadListener.onError(new InputException(InputException.ErrorEnum.IsInvalidInput));
            }
            return 0;
        }
        ChatAbsObject chatAbsInstant = getChatAbsInstant(str, dBHelper);
        if (chatAbsInstant == null) {
            if (loadListener != null) {
                loadListener.onError(new InputException(InputException.ErrorEnum.IsInvalidInput));
            }
            return 0;
        }
        ChannelInfo channelInfo = objectInfoInstant.channelInfo;
        if (channelInfo == null) {
            if (loadListener != null) {
                loadListener.onError(new InputException(InputException.ErrorEnum.IsInvalidInput));
            }
            return 0;
        }
        String str5 = (str2 == null || !str2.isEmpty()) ? str2 : null;
        String str6 = (str3 == null || !str3.isEmpty()) ? str3 : null;
        EditChannelInput editChannelInput = new EditChannelInput();
        editChannelInput.channel_guid = str;
        if (editChannelInput.updated_parameters == null) {
            editChannelInput.updated_parameters = new ArrayList<>();
        }
        if (!Objects.equals(str5, chatAbsInstant.title)) {
            editChannelInput.title = str5;
            editChannelInput.updated_parameters.add("title");
        }
        if (!Objects.equals(str6, channelInfo.description)) {
            editChannelInput.description = str6;
            editChannelInput.updated_parameters.add("description");
        }
        if (!Objects.equals(Boolean.valueOf(z), Boolean.valueOf(channelInfo.sign_messages))) {
            editChannelInput.sign_messages = z;
            editChannelInput.updated_parameters.add("sign_messages");
        }
        ChannelInfoFromServer.ChannelTypeEnum channelTypeEnum = z2 ? ChannelInfoFromServer.ChannelTypeEnum.Public : ChannelInfoFromServer.ChannelTypeEnum.Private;
        if (channelTypeEnum != channelInfo.channel_type) {
            editChannelInput.channel_type = channelTypeEnum;
            editChannelInput.updated_parameters.add("channel_type");
        }
        if (editChannelInput.updated_parameters.size() == 0) {
            if (loadListener != null) {
                loadListener.onDidLoad(str);
            }
            return 0;
        }
        try {
            return networkHelper.editChannelInfo(str4, editChannelInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<AddOrEditChannelOutput>() { // from class: ir.aaap.messengercore.ChatUtils.89
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(AddOrEditChannelOutput addOrEditChannelOutput) {
                    ChannelInfoFromServer channelInfoFromServer = addOrEditChannelOutput.channel;
                    String str7 = channelInfoFromServer != null ? channelInfoFromServer.channel_guid : BuildConfig.FLAVOR;
                    UpdateChatAndMessageUsecase updateChatAndMessageUsecase2 = updateChatAndMessageUsecase;
                    if (updateChatAndMessageUsecase2 != null) {
                        updateChatAndMessageUsecase2.processMessageAndChatUpdate(addOrEditChannelOutput.message_update, addOrEditChannelOutput.chat_update, false, true);
                    }
                    ChannelInfoFromServer channelInfoFromServer2 = addOrEditChannelOutput.channel;
                    if (channelInfoFromServer2 != null) {
                        ChatUtils.this.processChannelInfoDidLoad(channelInfoFromServer2, null, addOrEditChannelOutput.timestamp, dBHelper, absNotificationCenter);
                    }
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(str7);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            this.coreLog.handleException(e);
            if (loadListener == null) {
                return 0;
            }
            loadListener.onError(e);
            return 0;
        }
    }

    public int editChannel(String str, ChatReactionSetting chatReactionSetting, String str2, NetworkHelper networkHelper, final DBHelper dBHelper, final AbsNotificationCenter absNotificationCenter, final UpdateChatAndMessageUsecase updateChatAndMessageUsecase, final LoadListener<String> loadListener) {
        int iEditChannelInfo = 0;
        if (str == null || str.isEmpty() || chatReactionSetting == null) {
            if (loadListener != null) {
                loadListener.onError(new InputException(InputException.ErrorEnum.IsInvalidInput));
            }
            return 0;
        }
        ObjectInfo objectInfoInstant = getObjectInfoInstant(str);
        if (objectInfoInstant == null) {
            if (loadListener != null) {
                loadListener.onError(new InputException(InputException.ErrorEnum.IsInvalidInput));
            }
            return 0;
        }
        ChannelInfo channelInfo = objectInfoInstant.channelInfo;
        if (channelInfo == null) {
            if (loadListener != null) {
                loadListener.onError(new InputException(InputException.ErrorEnum.IsInvalidInput));
            }
            return 0;
        }
        EditChannelInput editChannelInput = new EditChannelInput();
        editChannelInput.channel_guid = str;
        if (Objects.equals(chatReactionSetting, channelInfo.chat_reaction_setting)) {
            if (loadListener != null) {
                loadListener.onDidLoad(str);
            }
            return 0;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        editChannelInput.updated_parameters = arrayList;
        editChannelInput.chat_reaction_setting = chatReactionSetting;
        arrayList.add("chat_reaction_setting");
        try {
            iEditChannelInfo = networkHelper.editChannelInfo(str2, editChannelInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<AddOrEditChannelOutput>() { // from class: ir.aaap.messengercore.ChatUtils.90
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(AddOrEditChannelOutput addOrEditChannelOutput) {
                    ChannelInfoFromServer channelInfoFromServer = addOrEditChannelOutput.channel;
                    String str3 = channelInfoFromServer != null ? channelInfoFromServer.channel_guid : BuildConfig.FLAVOR;
                    UpdateChatAndMessageUsecase updateChatAndMessageUsecase2 = updateChatAndMessageUsecase;
                    if (updateChatAndMessageUsecase2 != null) {
                        updateChatAndMessageUsecase2.processMessageAndChatUpdate(addOrEditChannelOutput.message_update, addOrEditChannelOutput.chat_update, false, true);
                    }
                    ChannelInfoFromServer channelInfoFromServer2 = addOrEditChannelOutput.channel;
                    if (channelInfoFromServer2 != null) {
                        ChatUtils.this.processChannelInfoDidLoad(channelInfoFromServer2, null, addOrEditChannelOutput.timestamp, dBHelper, absNotificationCenter);
                    }
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(str3);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            this.coreLog.handleException(e);
            if (loadListener != null) {
                loadListener.onError(e);
            }
        }
        return iEditChannelInfo;
    }

    public int addChannel(String str, ArrayList<String> arrayList, String str2, boolean z, String str3, String str4, String str5, NetworkHelper networkHelper, final DBHelper dBHelper, final AbsNotificationCenter absNotificationCenter, final UpdateChatAndMessageUsecase updateChatAndMessageUsecase, final LoadListener<String> loadListener) {
        int iAddChannel = 0;
        if (str == null || str.isEmpty()) {
            return 0;
        }
        AddChannelInput addChannelInput = new AddChannelInput();
        addChannelInput.title = str;
        addChannelInput.member_guids = arrayList;
        if (CoreUtilities.isNotEmpty(str2) && CoreUtilities.isNotEmpty(str2.trim()) && !str2.replace("\n", BuildConfig.FLAVOR).isEmpty()) {
            addChannelInput.description = str2.trim();
        }
        addChannelInput.channel_type = z ? ChannelInfoFromServer.ChannelTypeEnum.Public : ChannelInfoFromServer.ChannelTypeEnum.Private;
        if (str3 != null && str4 != null) {
            addChannelInput.main_file_id = str3;
            addChannelInput.thumbnail_file_id = str4;
        }
        try {
            iAddChannel = networkHelper.addChannel(str5, addChannelInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<AddOrEditChannelOutput>() { // from class: ir.aaap.messengercore.ChatUtils.91
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(AddOrEditChannelOutput addOrEditChannelOutput) {
                    ChannelInfoFromServer channelInfoFromServer = addOrEditChannelOutput.channel;
                    String str6 = channelInfoFromServer != null ? channelInfoFromServer.channel_guid : BuildConfig.FLAVOR;
                    if (channelInfoFromServer != null) {
                        ChatUtils.this.processChannelInfoDidLoad(channelInfoFromServer, null, addOrEditChannelOutput.timestamp, dBHelper, absNotificationCenter);
                    }
                    UpdateChatAndMessageUsecase updateChatAndMessageUsecase2 = updateChatAndMessageUsecase;
                    if (updateChatAndMessageUsecase2 != null) {
                        updateChatAndMessageUsecase2.processMessageAndChatUpdate(addOrEditChannelOutput.message_update, addOrEditChannelOutput.chat_update, false, true);
                    }
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(str6);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            this.coreLog.handleException(e);
            if (loadListener != null) {
                loadListener.onError(e);
            }
        }
        return iAddChannel;
    }

    public void joinChannel(String str, UpdateChatUsecase updateChatUsecase, LoadListener<String> loadListener, String str2, NetworkHelper networkHelper, DBHelper dBHelper, AbsNotificationCenter absNotificationCenter) {
        joinOrLeaveChannel(str, true, updateChatUsecase, loadListener, str2, networkHelper, dBHelper, absNotificationCenter);
    }

    public void leaveChannel(String str, UpdateChatUsecase updateChatUsecase, LoadListener<String> loadListener, String str2, NetworkHelper networkHelper, DBHelper dBHelper, AbsNotificationCenter absNotificationCenter) {
        joinOrLeaveChannel(str, false, updateChatUsecase, loadListener, str2, networkHelper, dBHelper, absNotificationCenter);
    }

    private void joinOrLeaveChannel(final String str, boolean z, final UpdateChatUsecase updateChatUsecase, final LoadListener<String> loadListener, String str2, NetworkHelper networkHelper, final DBHelper dBHelper, final AbsNotificationCenter absNotificationCenter) {
        Integer num = this.joinOrLeaveRequestingIdMap.get(str);
        if (num != null) {
            networkHelper.cancelCall(num.intValue());
            this.joinOrLeaveRequestingIdMap.remove(str);
        }
        JoinChannelActionInput joinChannelActionInput = new JoinChannelActionInput();
        joinChannelActionInput.channel_guid = str;
        joinChannelActionInput.action = z ? JoinChannelActionInput.Action.Join : JoinChannelActionInput.Action.Leave;
        try {
            this.joinOrLeaveRequestingIdMap.put(str, Integer.valueOf(networkHelper.joinChannelAction(str2, joinChannelActionInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<JoinChannelActionOutput>() { // from class: ir.aaap.messengercore.ChatUtils.92
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(JoinChannelActionOutput joinChannelActionOutput) {
                    ChatUtils.this.joinOrLeaveRequestingIdMap.remove(str);
                    ChatUtils.this.processChatsUpdate(joinChannelActionOutput.chat_update, updateChatUsecase, absNotificationCenter, dBHelper);
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(str);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    ChatUtils.this.joinOrLeaveRequestingIdMap.remove(str);
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            })));
        } catch (Exception e) {
            this.coreLog.handleException(e);
            if (loadListener != null) {
                loadListener.onError(e);
            }
        }
    }

    public void joinChannelByLink(String str, final UpdateChatUsecase updateChatUsecase, final LoadListener<String> loadListener, String str2, NetworkHelper networkHelper, final DBHelper dBHelper, final AbsNotificationCenter absNotificationCenter) {
        if (str == null || str.isEmpty()) {
            if (loadListener != null) {
                loadListener.onError(new InputException());
                return;
            }
            return;
        }
        try {
            networkHelper.joinChannelByLink(str2, new JoinChannelByLinkInput(str), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<JoinChannelByLinkOutput>() { // from class: ir.aaap.messengercore.ChatUtils.93
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(JoinChannelByLinkOutput joinChannelByLinkOutput) {
                    if (joinChannelByLinkOutput.is_valid) {
                        ChatUtils.this.processChatsUpdate(joinChannelByLinkOutput.chat_update, updateChatUsecase, absNotificationCenter, dBHelper);
                        ChannelInfoFromServer channelInfoFromServer = joinChannelByLinkOutput.channel;
                        if (channelInfoFromServer != null) {
                            ChatUtils.this.processChannelInfoDidLoad(channelInfoFromServer, null, joinChannelByLinkOutput.timestamp, dBHelper, absNotificationCenter);
                            LoadListener loadListener2 = loadListener;
                            if (loadListener2 != null) {
                                loadListener2.onDidLoad(joinChannelByLinkOutput.channel.channel_guid);
                                return;
                            }
                            return;
                        }
                        LoadListener loadListener3 = loadListener;
                        if (loadListener3 != null) {
                            loadListener3.onError(new ApiServerException());
                            return;
                        }
                        return;
                    }
                    LoadListener loadListener4 = loadListener;
                    if (loadListener4 != null) {
                        loadListener4.onError(new ApiServerException());
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            this.coreLog.handleException(e);
            if (loadListener != null) {
                loadListener.onError(e);
            }
        }
    }

    public void leaveGroup(final String str, final UpdateChatUsecase updateChatUsecase, final LoadListener<String> loadListener, String str2, NetworkHelper networkHelper, final DBHelper dBHelper, final AbsNotificationCenter absNotificationCenter) {
        Integer num = this.joinOrLeaveRequestingIdMap.get(str);
        if (num != null) {
            networkHelper.cancelCall(num.intValue());
            this.joinOrLeaveRequestingIdMap.remove(str);
        }
        NetworkHelper.ResponseListener<LeaveGroupOutput> responseListener = new NetworkHelper.ResponseListener<LeaveGroupOutput>() { // from class: ir.aaap.messengercore.ChatUtils.94
            @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
            public void onResponse(LeaveGroupOutput leaveGroupOutput) {
                ChatUtils.this.joinOrLeaveRequestingIdMap.remove(str);
                ChatUpdateObject chatUpdateObject = leaveGroupOutput.chat_update;
                if (chatUpdateObject != null) {
                    ChatUtils.this.processChatsUpdate(chatUpdateObject, updateChatUsecase, absNotificationCenter, dBHelper);
                }
                LoadListener loadListener2 = loadListener;
                if (loadListener2 != null) {
                    loadListener2.onDidLoad(str);
                }
            }

            @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
            public void onError(Exception exc) {
                ChatUtils.this.joinOrLeaveRequestingIdMap.remove(str);
                LoadListener loadListener2 = loadListener;
                if (loadListener2 != null) {
                    loadListener2.onError(exc);
                }
            }
        };
        LeaveGroupInput leaveGroupInput = new LeaveGroupInput(str);
        Chat chat = this.chatMap.get(str);
        if (chat != null && chat.status == Chat.ChatStatusEnum.NoAccess) {
            try {
                this.joinOrLeaveRequestingIdMap.put(str, Integer.valueOf(networkHelper.deleteNoAccessGroupChat(str2, leaveGroupInput, RetryObject.getDefaultRetry(), responseListener)));
                return;
            } catch (Exception e) {
                this.coreLog.handleException(e);
                if (loadListener != null) {
                    loadListener.onError(e);
                    return;
                }
                return;
            }
        }
        try {
            this.joinOrLeaveRequestingIdMap.put(str, Integer.valueOf(networkHelper.leaveGroup(str2, leaveGroupInput, RetryObject.getDefaultRetry(), responseListener)));
        } catch (Exception e2) {
            this.coreLog.handleException(e2);
            if (loadListener != null) {
                loadListener.onError(e2);
            }
        }
    }

    public void togglePinChat(final String str, final boolean z, String str2, NetworkHelper networkHelper, final DBHelper dBHelper, final AbsNotificationCenter absNotificationCenter) {
        final Chat chat = this.chatMap.get(str);
        if (chat == null || chat.is_pinned == z) {
            return;
        }
        chat.is_pinned = z;
        createAndSortChatList(absNotificationCenter, new ChatNeedReloadResult(ChatNeedReloadResult.TypeEnum.AllListUpdated), dBHelper);
        Integer num = this.chatTogglePinRequestingIdMap.get(str);
        if (num != null) {
            networkHelper.cancelCall(num.intValue());
            this.chatTogglePinRequestingIdMap.remove(str);
        }
        SetChatActionInput setChatActionInput = new SetChatActionInput();
        setChatActionInput.action = z ? SetChatActionInput.ChatAction.Pin : SetChatActionInput.ChatAction.Unpin;
        setChatActionInput.object_guid = str;
        try {
            this.chatTogglePinRequestingIdMap.put(str, Integer.valueOf(networkHelper.setActionChat(str2, setChatActionInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<SetChatActionOutput>() { // from class: ir.aaap.messengercore.ChatUtils.95
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(SetChatActionOutput setChatActionOutput) {
                    ChatUtils.this.chatTogglePinRequestingIdMap.remove(str);
                    ChatUtils.this.processChatsUpdate(setChatActionOutput.chat_update, (UpdateChatUsecase) null, absNotificationCenter, dBHelper);
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    ChatUtils.this.chatTogglePinRequestingIdMap.remove(str);
                    chat.is_pinned = !z;
                    ChatUtils.this.createAndSortChatList(absNotificationCenter, new ChatNeedReloadResult(ChatNeedReloadResult.TypeEnum.AllListUpdated), dBHelper);
                }
            })));
        } catch (Exception e) {
            this.chatTogglePinRequestingIdMap.remove(str);
            this.coreLog.handleException(e);
            chat.is_pinned = !z;
            createAndSortChatList(absNotificationCenter, new ChatNeedReloadResult(ChatNeedReloadResult.TypeEnum.AllListUpdated), dBHelper);
        }
    }

    public void togglePinChatInFolder(String str, final String str2, final boolean z, final String str3, final NetworkHelper networkHelper, final DBHelper dBHelper, final AbsNotificationCenter absNotificationCenter, final KeyValueStorageHelper keyValueStorageHelper) {
        final FolderObject folderObject = this.dialogFiltersMap.get(str);
        if (folderObject == null) {
            return;
        }
        if (z && folderObject.pinnedDialogsSet.contains(str2)) {
            return;
        }
        if (z || folderObject.pinnedDialogsSet.contains(str2)) {
            if (!z || folderObject.pinnedDialogsSet.size() < CoreMainClassImpl.MAX_PIN_IN_FOLDER_COUNT) {
                Integer num = this.chatTogglePinRequestingIdMap.get(str2);
                if (num != null) {
                    networkHelper.cancelCall(num.intValue());
                    this.chatTogglePinRequestingIdMap.remove(str2);
                }
                SetPinChatInFolderInput setPinChatInFolderInput = new SetPinChatInFolderInput();
                setPinChatInFolderInput.folder_id = folderObject.folder_id;
                setPinChatInFolderInput.object_guid = str2;
                setPinChatInFolderInput.action = z ? SetPinChatInFolderInput.Action.Pin : SetPinChatInFolderInput.Action.Unpin;
                try {
                    this.chatTogglePinRequestingIdMap.put(str2, Integer.valueOf(networkHelper.setPinChatInFolder(str3, setPinChatInFolderInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<ChangeFolderOutput>() { // from class: ir.aaap.messengercore.ChatUtils.96
                        @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                        public void onResponse(ChangeFolderOutput changeFolderOutput) {
                            ChatUtils.this.chatTogglePinRequestingIdMap.remove(str2);
                            ChatAbsObject chatAbsObject = (ChatAbsObject) ChatUtils.this.absMap.get(str2);
                            ObjectGuidType objectGuidType = new ObjectGuidType(str2, chatAbsObject != null ? chatAbsObject.type : null);
                            if (z && !folderObject.include_objects.contains(objectGuidType)) {
                                folderObject.include_objects.add(objectGuidType);
                            }
                            if (z) {
                                folderObject.pinned_objects.add(objectGuidType);
                            } else {
                                folderObject.pinned_objects.remove(objectGuidType);
                            }
                            ChatUtils.this.onFolderUpdatedOrAdded(false, folderObject, dBHelper, absNotificationCenter);
                            ChatUtils.this.processChangeFolderState(changeFolderOutput, str3, networkHelper, dBHelper, keyValueStorageHelper, absNotificationCenter);
                        }

                        @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                        public void onError(Exception exc) {
                            ChatUtils.this.chatTogglePinRequestingIdMap.remove(str2);
                        }
                    })));
                } catch (Exception e) {
                    this.coreLog.handleException(e);
                    this.chatTogglePinRequestingIdMap.remove(str2);
                }
            }
        }
    }

    public void reorderFolders(final ArrayList<String> arrayList, final String str, final NetworkHelper networkHelper, final DBHelper dBHelper, final AbsNotificationCenter absNotificationCenter, final KeyValueStorageHelper keyValueStorageHelper) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        try {
            ReorderFolderInput reorderFolderInput = new ReorderFolderInput();
            reorderFolderInput.folder_ids = arrayList;
            networkHelper.reorderFolder(str, reorderFolderInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<ChangeFolderOutput>() { // from class: ir.aaap.messengercore.ChatUtils.97
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(ChangeFolderOutput changeFolderOutput) {
                    if (changeFolderOutput != null) {
                        ChatUtils.this.onFolderReordered(arrayList, dBHelper, absNotificationCenter);
                        ChatUtils.this.processChangeFolderState(changeFolderOutput, str, networkHelper, dBHelper, keyValueStorageHelper, absNotificationCenter);
                    }
                }
            });
        } catch (Exception e) {
            this.coreLog.handleException(e);
        }
    }

    public void addContact(String str, String str2, String str3, String str4, NetworkHelper networkHelper, final DBHelper dBHelper, final AbsNotificationCenter absNotificationCenter, final LoadListener<String> loadListener, final UpdateChatUsecase updateChatUsecase, final LinkUsecase linkUsecase) {
        if (str == null || str2 == null || str3 == null || ((str.isEmpty() && str2.isEmpty()) || str3.isEmpty())) {
            if (loadListener != null) {
                loadListener.onError(new InputException());
                return;
            }
            return;
        }
        if (!CoreUtilities.isValidPhoneNumber(str3)) {
            if (loadListener != null) {
                loadListener.onError(new InputException());
                return;
            }
            return;
        }
        try {
            AddAddressBookInput addAddressBookInput = new AddAddressBookInput();
            addAddressBookInput.first_name = str;
            addAddressBookInput.last_name = str2;
            addAddressBookInput.phone = str3;
            networkHelper.addAddressBook(str4, addAddressBookInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<AddAddressBookOutput>() { // from class: ir.aaap.messengercore.ChatUtils.98
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(AddAddressBookOutput addAddressBookOutput) {
                    LinkUsecase linkUsecase2;
                    if (addAddressBookOutput != null) {
                        if (addAddressBookOutput.user_exist) {
                            ChatUtils.this.processChatsUpdate(addAddressBookOutput.chat_update, updateChatUsecase, absNotificationCenter, dBHelper);
                            ChatUtils.this.processUserInfoDidLoad(addAddressBookOutput.user, null, 0L, true, true, true, addAddressBookOutput.timestamp, dBHelper, true, absNotificationCenter);
                        } else {
                            Link link = addAddressBookOutput.invite_link;
                            if (link != null && (linkUsecase2 = linkUsecase) != null) {
                                linkUsecase2.onLinkClick(link);
                            }
                        }
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(addAddressBookOutput.user_exist ? addAddressBookOutput.user.user_guid : null);
                            return;
                        }
                        return;
                    }
                    LoadListener loadListener3 = loadListener;
                    if (loadListener3 != null) {
                        loadListener3.onError(new ApiServerException());
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.coreLog.handleException(e);
        }
    }

    public void deleteContact(String str, String str2, NetworkHelper networkHelper, final DBHelper dBHelper, final AbsNotificationCenter absNotificationCenter, final LoadListener<Integer> loadListener, final UpdateChatUsecase updateChatUsecase) {
        if (str == null || str.isEmpty()) {
            return;
        }
        try {
            DeleteContactInput deleteContactInput = new DeleteContactInput();
            deleteContactInput.user_guid = str;
            networkHelper.deleteContact(str2, deleteContactInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<DeleteContactOutput>() { // from class: ir.aaap.messengercore.ChatUtils.99
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(DeleteContactOutput deleteContactOutput) {
                    if (deleteContactOutput != null) {
                        ChatUtils.this.processChatsUpdate(deleteContactOutput.chat_update, updateChatUsecase, absNotificationCenter, dBHelper);
                        ChatUtils.this.processUserInfoDidLoad(deleteContactOutput.user, null, 0L, true, true, true, deleteContactOutput.timestamp, dBHelper, true, absNotificationCenter);
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(1);
                            return;
                        }
                        return;
                    }
                    LoadListener loadListener3 = loadListener;
                    if (loadListener3 != null) {
                        loadListener3.onError(new ApiServerException());
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.coreLog.handleException(e);
        }
    }

    public void resetContact(String str, NetworkHelper networkHelper, final DBHelper dBHelper, final KeyValueStorageHelper keyValueStorageHelper, final LoadListener<Integer> loadListener) {
        try {
            networkHelper.resetContacts(str, new ResetContactsInput(), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<ResetContactsOutput>() { // from class: ir.aaap.messengercore.ChatUtils.100
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(ResetContactsOutput resetContactsOutput) {
                    dBHelper.removeAllContacts();
                    dBHelper.removeAllPhoneBooks();
                    ChatUtils.this.clearContactMap();
                    keyValueStorageHelper.setContactState(null);
                    keyValueStorageHelper.setContactNextStartId(null);
                    keyValueStorageHelper.setContactHasContinue(true);
                    keyValueStorageHelper.setPhoneBookImportedOnce(false);
                    keyValueStorageHelper.setLastPhoneBookImportingVersion(null);
                    keyValueStorageHelper.setLastUpdatedContactTime(0L);
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(1);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.coreLog.handleException(e);
        }
    }

    public int deleteFolder(final String str, final String str2, final NetworkHelper networkHelper, final DBHelper dBHelper, final AbsNotificationCenter absNotificationCenter, final KeyValueStorageHelper keyValueStorageHelper, final LoadListener<String> loadListener) {
        if (str == null || !this.dialogFiltersMap.containsKey(str)) {
            return 0;
        }
        try {
            DeleteFolderInput deleteFolderInput = new DeleteFolderInput();
            deleteFolderInput.folder_id = str;
            return networkHelper.deleteFolder(str2, deleteFolderInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<ChangeFolderOutput>() { // from class: ir.aaap.messengercore.ChatUtils.101
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(ChangeFolderOutput changeFolderOutput) {
                    if (changeFolderOutput != null) {
                        ChatUtils.this.onFolderDeleted(str, dBHelper, absNotificationCenter);
                        ChatUtils.this.processChangeFolderState(changeFolderOutput, str2, networkHelper, dBHelper, keyValueStorageHelper, absNotificationCenter);
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(str);
                            return;
                        }
                        return;
                    }
                    LoadListener loadListener3 = loadListener;
                    if (loadListener3 != null) {
                        loadListener3.onError(new ApiServerException());
                    }
                }
            });
        } catch (Exception e) {
            this.coreLog.handleException(e);
            return 0;
        }
    }

    public int addOrEditFolder(String str, int i, String str2, ArrayList<ObjectGuidType> arrayList, ArrayList<ObjectGuidType> arrayList2, String str3, final String str4, final NetworkHelper networkHelper, final DBHelper dBHelper, final AbsNotificationCenter absNotificationCenter, final KeyValueStorageHelper keyValueStorageHelper, final LoadListener<FolderObject> loadListener) {
        if (!(CoreUtilities.isNotEmpty(str) && CoreUtilities.isNotEmpty(str3)) && getFoldersInstant().size() >= CoreMainClassImpl.MAX_FOLDER_COUNT) {
            if (loadListener != null) {
                loadListener.onError(null);
            }
            return 0;
        }
        try {
            AddOrEditFolderInput addOrEditFolderInputCreateAddOrEditFolderInput = createAddOrEditFolderInput(str, i, str2, arrayList, arrayList2, str3);
            if (CoreUtilities.isNotEmpty(addOrEditFolderInputCreateAddOrEditFolderInput.folder_id)) {
                return networkHelper.editFolder(str4, addOrEditFolderInputCreateAddOrEditFolderInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<ChangeFolderOutput>() { // from class: ir.aaap.messengercore.ChatUtils.102
                    @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                    public void onResponse(ChangeFolderOutput changeFolderOutput) {
                        if (changeFolderOutput != null) {
                            FolderObject folderObject = changeFolderOutput.folder;
                            if (folderObject != null) {
                                ChatUtils.this.onFolderUpdatedOrAdded(true, folderObject, dBHelper, absNotificationCenter);
                            }
                            ChatUtils.this.processChangeFolderState(changeFolderOutput, str4, networkHelper, dBHelper, keyValueStorageHelper, absNotificationCenter);
                            LoadListener loadListener2 = loadListener;
                            if (loadListener2 != null) {
                                loadListener2.onDidLoad(changeFolderOutput.folder);
                                return;
                            }
                            return;
                        }
                        LoadListener loadListener3 = loadListener;
                        if (loadListener3 != null) {
                            loadListener3.onError(new ApiServerException());
                        }
                    }

                    @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                    public void onError(Exception exc) {
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onError(exc);
                        }
                    }
                });
            }
            return networkHelper.addFolder(str4, addOrEditFolderInputCreateAddOrEditFolderInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<ChangeFolderOutput>() { // from class: ir.aaap.messengercore.ChatUtils.103
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(ChangeFolderOutput changeFolderOutput) {
                    if (changeFolderOutput != null) {
                        FolderObject folderObject = changeFolderOutput.folder;
                        if (folderObject != null) {
                            ChatUtils.this.onFolderUpdatedOrAdded(true, folderObject, dBHelper, absNotificationCenter);
                        }
                        ChatUtils.this.processChangeFolderState(changeFolderOutput, str4, networkHelper, dBHelper, keyValueStorageHelper, absNotificationCenter);
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(changeFolderOutput.folder);
                            return;
                        }
                        return;
                    }
                    LoadListener loadListener3 = loadListener;
                    if (loadListener3 != null) {
                        loadListener3.onError(new ApiServerException());
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            this.coreLog.handleException(e);
            return 0;
        }
    }

    private AddOrEditFolderInput createAddOrEditFolderInput(String str, int i, String str2, ArrayList<ObjectGuidType> arrayList, ArrayList<ObjectGuidType> arrayList2, String str3) {
        AddOrEditFolderInput addOrEditFolderInput = new AddOrEditFolderInput();
        if ((FolderObject.DIALOG_FILTER_FLAG_CONTACTS & i) != 0) {
            addOrEditFolderInput.include_chat_types.add(FolderObject.EnumIncludeChatType.Contacts);
        }
        if ((FolderObject.DIALOG_FILTER_FLAG_NON_CONTACTS & i) != 0) {
            addOrEditFolderInput.include_chat_types.add(FolderObject.EnumIncludeChatType.NonConatcts);
        }
        if ((FolderObject.DIALOG_FILTER_FLAG_GROUPS & i) != 0) {
            addOrEditFolderInput.include_chat_types.add(FolderObject.EnumIncludeChatType.Groups);
        }
        if ((FolderObject.DIALOG_FILTER_FLAG_CHANNELS & i) != 0) {
            addOrEditFolderInput.include_chat_types.add(FolderObject.EnumIncludeChatType.Channels);
        }
        if ((FolderObject.DIALOG_FILTER_FLAG_BOTS & i) != 0) {
            addOrEditFolderInput.include_chat_types.add(FolderObject.EnumIncludeChatType.Bots);
        }
        if ((FolderObject.DIALOG_FILTER_FLAG_EXCLUDE_MUTED & i) != 0) {
            addOrEditFolderInput.exclude_chat_types.add(FolderObject.EnumExcludeChatType.Mute);
        }
        if ((i & FolderObject.DIALOG_FILTER_FLAG_EXCLUDE_READ) != 0) {
            addOrEditFolderInput.exclude_chat_types.add(FolderObject.EnumExcludeChatType.Read);
        }
        int i2 = FolderObject.DIALOG_FILTER_FLAG_EXCLUDE_ARCHIVED;
        addOrEditFolderInput.exclude_object_guids = new ArrayList<>();
        Iterator<ObjectGuidType> it = arrayList2.iterator();
        while (it.hasNext()) {
            addOrEditFolderInput.exclude_object_guids.add(it.next().object_guid);
        }
        addOrEditFolderInput.include_object_guids = new ArrayList<>();
        Iterator<ObjectGuidType> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            addOrEditFolderInput.include_object_guids.add(it2.next().object_guid);
        }
        addOrEditFolderInput.name = str2;
        addOrEditFolderInput.suggestion_folder_id = str3;
        addOrEditFolderInput.folder_id = str;
        if (CoreUtilities.isNotEmpty(str)) {
            ArrayList<String> arrayList3 = new ArrayList<>();
            addOrEditFolderInput.updated_parameters = arrayList3;
            arrayList3.add("name");
            addOrEditFolderInput.updated_parameters.add("include_chat_types");
            addOrEditFolderInput.updated_parameters.add("exclude_chat_types");
            addOrEditFolderInput.updated_parameters.add("include_object_guids");
            addOrEditFolderInput.updated_parameters.add("exclude_object_guids");
        } else {
            addOrEditFolderInput.is_add_to_top = Boolean.valueOf(CoreUtilities.isNotEmpty(addOrEditFolderInput.suggestion_folder_id));
        }
        return addOrEditFolderInput;
    }

    public void importPhoneBookAndSendToServer(boolean z, String str, NetworkHelper networkHelper, DBHelper dBHelper, AbsNotificationCenter absNotificationCenter, final KeyValueStorageHelper keyValueStorageHelper, UpdateChatUsecase updateChatUsecase, PhoneBookHelper phoneBookHelper, TimerHelper timerHelper, final LoadListener<Integer> loadListener) {
        final String version;
        boolean phoneBookImportedOnce = true;
        if (z) {
            version = phoneBookHelper.getVersion();
            String lastPhoneBookImportingVersion = keyValueStorageHelper.getLastPhoneBookImportingVersion();
            if (CoreUtilities.isNotEmpty(version) && version.equals(lastPhoneBookImportingVersion)) {
                phoneBookImportedOnce = false;
            }
        } else {
            phoneBookImportedOnce = true ^ keyValueStorageHelper.getPhoneBookImportedOnce();
            version = null;
        }
        if (!phoneBookImportedOnce) {
            if (loadListener != null) {
                loadListener.onDidLoad(1);
                return;
            }
            return;
        }
        ArrayList<PhoneBookObject> phoneBooks = phoneBookHelper.getPhoneBooks();
        if (phoneBooks == null || phoneBooks.size() == 0) {
            if (loadListener != null) {
                loadListener.onDidLoad(1);
                return;
            }
            return;
        }
        Map<String, PhoneBookObject> allPhoneBook = dBHelper.getAllPhoneBook();
        ArrayList arrayList = new ArrayList();
        if (allPhoneBook != null && allPhoneBook.size() > 0) {
            Iterator<PhoneBookObject> it = phoneBooks.iterator();
            while (it.hasNext()) {
                PhoneBookObject next = it.next();
                if (!next.equals(allPhoneBook.get(next.phone))) {
                    arrayList.add(next);
                }
            }
        } else {
            arrayList.addAll(phoneBooks);
        }
        if (arrayList.size() != 0) {
            new ImportPhoneBookHelper(str, networkHelper, dBHelper, absNotificationCenter, updateChatUsecase, keyValueStorageHelper, timerHelper, new LoadListener<Set<PhoneBookObject>>(this) { // from class: ir.aaap.messengercore.ChatUtils.104
                @Override // ir.aaap.messengercore.LoadListener
                public void onDidLoad(Set<PhoneBookObject> set) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(1);
                    }
                    keyValueStorageHelper.setPhoneBookImportedOnce(true);
                    keyValueStorageHelper.setLastPhoneBookImportingVersion(version);
                }

                @Override // ir.aaap.messengercore.LoadListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(1);
                    }
                }
            }).importPhoneBookLimited(arrayList, new HashSet());
        } else if (loadListener != null) {
            loadListener.onDidLoad(1);
        }
    }

    public ArrayList<InSearchObject> searchLocalInContacts(String str, DBHelper dBHelper, AbsNotificationCenter absNotificationCenter) {
        ArrayList<String> arrayList;
        UserInfo userInfo;
        ChatAbsObject chatAbsInstant;
        ArrayList<InSearchObject> arrayList2 = new ArrayList<>();
        if (str == null) {
            return arrayList2;
        }
        String lowerCase = str.trim().toLowerCase();
        if (lowerCase.startsWith("@")) {
            lowerCase = lowerCase.substring(1);
        }
        if (lowerCase.isEmpty()) {
            return arrayList2;
        }
        this.coreLog.e("DialogsProxy", "isContactInited " + this.isContactInited);
        if (!this.isContactInited && !this.isContactLoadedFromDb) {
            loadContactsFromDbAndNotify(dBHelper, absNotificationCenter);
        }
        SortedContactResult sortedContactResult = this.sortedContactResult;
        if (sortedContactResult != null && (arrayList = sortedContactResult.sortedByLasOnlineContacts) != null) {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                ObjectInfo objectInfoInstant = getObjectInfoInstant(next);
                if (objectInfoInstant.objectType == ChatType.User && (userInfo = objectInfoInstant.userInfo) != null && (chatAbsInstant = getChatAbsInstant(next, dBHelper)) != null) {
                    if (checkSearchCondition(userInfo.username, lowerCase)) {
                        InSearchObject inSearchObjectCreateFromUserInfoAndAbs = InSearchObject.createFromUserInfoAndAbs(userInfo, chatAbsInstant);
                        inSearchObjectCreateFromUserInfoAndAbs.searchMatchName = "@" + userInfo.username;
                        arrayList2.add(inSearchObjectCreateFromUserInfoAndAbs);
                    } else if (checkSearchCondition(userInfo.phone, lowerCase)) {
                        InSearchObject inSearchObjectCreateFromUserInfoAndAbs2 = InSearchObject.createFromUserInfoAndAbs(userInfo, chatAbsInstant);
                        inSearchObjectCreateFromUserInfoAndAbs2.searchMatchName = userInfo.phone;
                        arrayList2.add(inSearchObjectCreateFromUserInfoAndAbs2);
                    } else if (chatAbsInstant.first_name != null || chatAbsInstant.last_name != null) {
                        StringBuilder sb = new StringBuilder();
                        String str2 = chatAbsInstant.first_name;
                        String str3 = BuildConfig.FLAVOR;
                        if (str2 == null) {
                            str2 = BuildConfig.FLAVOR;
                        }
                        sb.append(str2);
                        sb.append(" ");
                        String str4 = chatAbsInstant.last_name;
                        if (str4 != null) {
                            str3 = str4;
                        }
                        sb.append(str3);
                        String string = sb.toString();
                        if (checkSearchCondition(string, lowerCase)) {
                            InSearchObject inSearchObjectCreateFromUserInfoAndAbs3 = InSearchObject.createFromUserInfoAndAbs(userInfo, chatAbsInstant);
                            inSearchObjectCreateFromUserInfoAndAbs3.searchMatchName = string;
                            arrayList2.add(inSearchObjectCreateFromUserInfoAndAbs3);
                        }
                    }
                }
            }
        }
        return arrayList2;
    }

    public ArrayList<InSearchObject> searchLocalInChats(String str, String str2, DBHelper dBHelper, AbsNotificationCenter absNotificationCenter) {
        ChannelInfo channelInfo;
        ArrayList<InSearchObject> arrayList = new ArrayList<>();
        if (!this.isChatInited || str == null || this.chatList == null) {
            return arrayList;
        }
        String lowerCase = str.trim().toLowerCase();
        if (lowerCase.startsWith("@")) {
            lowerCase = lowerCase.substring(1);
        }
        if (lowerCase.isEmpty()) {
            return arrayList;
        }
        Iterator<Chat> it = this.chatList.iterator();
        while (it.hasNext()) {
            Chat next = it.next();
            if (arrayList.size() >= 30) {
                break;
            }
            ChatAbsObject chatAbsInstant = getChatAbsInstant(next.object_guid, dBHelper);
            if (chatAbsInstant == null) {
                chatAbsInstant = getAbsObjectFromDB(dBHelper, next.object_guid);
                if (chatAbsInstant != null) {
                    addToAbsMap(chatAbsInstant, chatAbsInstant.timeStamp);
                }
                if (chatAbsInstant == null) {
                }
            }
            ObjectInfo objectInfoInstant = getObjectInfoInstant(next.object_guid);
            if (objectInfoInstant == null && (objectInfoInstant = getObjectInfoFromDb(chatAbsInstant.object_guid, chatAbsInstant.type, dBHelper)) != null) {
                addToInfoMap(objectInfoInstant);
            }
            if (checkSearchCondition(chatAbsInstant.title, lowerCase)) {
                InSearchObject inSearchObjectCreateFromObjectInfoAndAbs = InSearchObject.createFromObjectInfoAndAbs(this.objectInfoByIdMap.get(chatAbsInstant.object_guid), chatAbsInstant);
                inSearchObjectCreateFromObjectInfoAndAbs.searchMatchName = chatAbsInstant.title;
                arrayList.add(inSearchObjectCreateFromObjectInfoAndAbs);
            } else {
                if (chatAbsInstant.first_name != null || chatAbsInstant.last_name != null) {
                    StringBuilder sb = new StringBuilder();
                    String str3 = chatAbsInstant.first_name;
                    String str4 = BuildConfig.FLAVOR;
                    if (str3 == null) {
                        str3 = BuildConfig.FLAVOR;
                    }
                    sb.append(str3);
                    sb.append(" ");
                    String str5 = chatAbsInstant.last_name;
                    if (str5 != null) {
                        str4 = str5;
                    }
                    sb.append(str4);
                    String string = sb.toString();
                    if (checkSearchCondition(string, lowerCase)) {
                        InSearchObject inSearchObjectCreateFromObjectInfoAndAbs2 = InSearchObject.createFromObjectInfoAndAbs(this.objectInfoByIdMap.get(chatAbsInstant.object_guid), chatAbsInstant);
                        inSearchObjectCreateFromObjectInfoAndAbs2.searchMatchName = string;
                        arrayList.add(inSearchObjectCreateFromObjectInfoAndAbs2);
                    }
                }
                if (objectInfoInstant != null && (channelInfo = objectInfoInstant.channelInfo) != null && chatAbsInstant.type == ChatType.Channel) {
                    String str6 = channelInfo.username;
                    if (checkSearchCondition(str6, lowerCase)) {
                        InSearchObject inSearchObjectCreateFromObjectInfoAndAbs3 = InSearchObject.createFromObjectInfoAndAbs(this.objectInfoByIdMap.get(chatAbsInstant.object_guid), chatAbsInstant);
                        inSearchObjectCreateFromObjectInfoAndAbs3.searchMatchName = str6;
                        arrayList.add(inSearchObjectCreateFromObjectInfoAndAbs3);
                    }
                }
            }
        }
        if (str2.startsWith(lowerCase) || "saved messages".startsWith(lowerCase)) {
            String myGuid = this.getMyUserGuidUsecase.getMyGuid();
            ObjectInfo objectInfoFromDb = getObjectInfoFromDb(myGuid, ChatType.User, dBHelper);
            ChatAbsObject absObjectFromDB = getAbsObjectFromDB(dBHelper, myGuid);
            if (objectInfoFromDb != null && absObjectFromDB != null) {
                arrayList.add(InSearchObject.createFromObjectInfoAndAbs(objectInfoFromDb, absObjectFromDB));
            }
        }
        addToSearchMap(arrayList);
        return arrayList;
    }

    public boolean checkSearchCondition(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        String lowerCase = str.trim().toLowerCase();
        if (lowerCase.startsWith(str2)) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        sb.append(str2);
        return lowerCase.contains(sb.toString());
    }

    public void initContactMap(String str, NetworkHelper networkHelper, DBHelper dBHelper, AbsNotificationCenter absNotificationCenter, KeyValueStorageHelper keyValueStorageHelper, TimerHelper timerHelper, final LoadListener<Integer> loadListener) {
        if (this.isContactInited) {
            if (loadListener != null) {
                loadListener.onDidLoad(1);
                return;
            }
            return;
        }
        loadContactsFromDbAndNotify(dBHelper, absNotificationCenter);
        if (!keyValueStorageHelper.getContactHasContinue()) {
            this.isContactInited = true;
            if (loadListener != null) {
                loadListener.onDidLoad(1);
                return;
            }
            return;
        }
        String contactNextStartId = keyValueStorageHelper.getContactNextStartId();
        if (contactNextStartId != null && contactNextStartId.isEmpty()) {
            contactNextStartId = null;
        }
        getContactsFromServer(contactNextStartId, str, networkHelper, dBHelper, absNotificationCenter, keyValueStorageHelper, timerHelper, new LoadListener<Integer>() { // from class: ir.aaap.messengercore.ChatUtils.105
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(Integer num) {
                ChatUtils.this.isContactInited = true;
                LoadListener loadListener2 = loadListener;
                if (loadListener2 != null) {
                    loadListener2.onDidLoad(1);
                }
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                LoadListener loadListener2 = loadListener;
                if (loadListener2 != null) {
                    loadListener2.onDidLoad(1);
                }
            }
        });
    }

    public boolean isContact(String str) {
        return this.contactSet.contains(str);
    }

    private void loadContactsFromDbAndNotify(DBHelper dBHelper, AbsNotificationCenter absNotificationCenter) {
        ArrayList<String> allContacts = dBHelper.getAllContacts();
        clearContactMap();
        if (allContacts != null && allContacts.size() > 0) {
            ArrayList<UserInfo> allUserInfoObject = dBHelper.getAllUserInfoObject(allContacts);
            ArrayList<ChatAbsObject> allAbsObject = dBHelper.getAllAbsObject(allContacts);
            addToContactMap(allUserInfoObject);
            addToAbsMap(allAbsObject, 0L);
            addToInfoMap(ObjectInfo.createFromUserInfoArray(allUserInfoObject));
            createAndSortContactListAndNotify(absNotificationCenter, new ContactsNeedsReloadResult(ContactsNeedsReloadResult.TypeEnum.allContactListUpdated));
        }
        this.isContactLoadedFromDb = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getContactsFromServer(final String str, final String str2, final NetworkHelper networkHelper, final DBHelper dBHelper, final AbsNotificationCenter absNotificationCenter, final KeyValueStorageHelper keyValueStorageHelper, final TimerHelper timerHelper, final LoadListener<Integer> loadListener) {
        try {
            networkHelper.getContacts(str2, new GetContactInput(str), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetContactOutput>() { // from class: ir.aaap.messengercore.ChatUtils.106
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(final GetContactOutput getContactOutput) {
                    if (getContactOutput != null) {
                        if (str == null) {
                            dBHelper.removeAllContacts();
                            ChatUtils.this.clearContactMap();
                            keyValueStorageHelper.setContactState(null);
                        }
                        ChatUtils.this.processContactUpdate(getContactOutput.users, null, getContactOutput.timestamp, dBHelper, absNotificationCenter);
                        if (str == null) {
                            keyValueStorageHelper.setContactState(getContactOutput.state);
                        }
                        String str3 = getContactOutput.next_start_id;
                        if (str3 != null) {
                            keyValueStorageHelper.setContactNextStartId(str3);
                        }
                        keyValueStorageHelper.setContactHasContinue(getContactOutput.has_continue);
                        if (getContactOutput.has_continue) {
                            timerHelper.postRunnableDelayed(new Runnable() { // from class: ir.aaap.messengercore.ChatUtils.106.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AnonymousClass106 anonymousClass106 = AnonymousClass106.this;
                                    ChatUtils.this.getContactsFromServer(getContactOutput.next_start_id, str2, networkHelper, dBHelper, absNotificationCenter, keyValueStorageHelper, timerHelper, loadListener);
                                }
                            }, 1000L);
                            return;
                        }
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(1);
                        }
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            this.coreLog.handleException(e);
            if (loadListener != null) {
                loadListener.onError(e);
            }
        }
    }

    public void getContactUpdates(boolean z, long j, final String str, final NetworkHelper networkHelper, final DBHelper dBHelper, final AbsNotificationCenter absNotificationCenter, final KeyValueStorageHelper keyValueStorageHelper, final TimerHelper timerHelper) {
        if (!this.isContactUpdateInProgress && this.isContactInited) {
            String contactState = keyValueStorageHelper.getContactState();
            if (CoreUtilities.isNotEmpty(contactState)) {
                if (z) {
                    keyValueStorageHelper.setLastUpdatedContactTime(0L);
                }
                long lastUpdatedContactTime = keyValueStorageHelper.getLastUpdatedContactTime();
                if (z || System.currentTimeMillis() - lastUpdatedContactTime > j) {
                    GetContactUpdateInput getContactUpdateInput = new GetContactUpdateInput();
                    getContactUpdateInput.state = contactState;
                    this.isContactUpdateInProgress = true;
                    try {
                        networkHelper.getContactsUpdates(str, getContactUpdateInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetContactUpdateOutput>() { // from class: ir.aaap.messengercore.ChatUtils.107
                            @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                            public void onResponse(GetContactUpdateOutput getContactUpdateOutput) {
                                ChatUtils.this.isContactUpdateInProgress = false;
                                if (getContactUpdateOutput != null) {
                                    if (getContactUpdateOutput.status == GetContactUpdateOutput.Status.OK) {
                                        ChatUtils.this.processContactUpdate(getContactUpdateOutput.users, getContactUpdateOutput.deleted_users, getContactUpdateOutput.timestamp, dBHelper, absNotificationCenter);
                                        keyValueStorageHelper.setLastUpdatedContactTime(System.currentTimeMillis());
                                        String str2 = getContactUpdateOutput.new_state;
                                        if (str2 != null) {
                                            keyValueStorageHelper.setContactState(str2);
                                        }
                                    }
                                    if (getContactUpdateOutput.status == GetContactUpdateOutput.Status.OldState) {
                                        ChatUtils.this.isContactInited = false;
                                        keyValueStorageHelper.setContactHasContinue(true);
                                        keyValueStorageHelper.setContactNextStartId(null);
                                        keyValueStorageHelper.setContactState(null);
                                        ChatUtils.this.getContactsFromServer(null, str, networkHelper, dBHelper, absNotificationCenter, keyValueStorageHelper, timerHelper, null);
                                    }
                                }
                            }

                            @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                            public void onError(Exception exc) {
                                ChatUtils.this.isContactUpdateInProgress = false;
                            }
                        });
                    } catch (Exception e) {
                        this.isContactUpdateInProgress = false;
                        this.coreLog.handleException(e);
                    }
                }
            }
        }
    }

    public void processContactUpdate(ArrayList<UserInfoFromServer> arrayList, ArrayList<UserInfoFromServer> arrayList2, long j, DBHelper dBHelper, AbsNotificationCenter absNotificationCenter) {
        boolean z;
        ArrayList<UserInfo> arrayList3 = new ArrayList<>();
        ArrayList<ChatAbsObject> arrayList4 = new ArrayList<>();
        ArrayList<ObjectInfo> arrayList5 = new ArrayList<>();
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        if (arrayList == null || arrayList.size() <= 0) {
            z = false;
        } else {
            Iterator<UserInfoFromServer> it = arrayList.iterator();
            while (it.hasNext()) {
                UserInfoFromServer next = it.next();
                UserInfo userInfoCreateFromServerObject = UserInfo.createFromServerObject(next, j, 0L, false, false);
                userInfoCreateFromServerObject.insertedToDbTime = jCurrentTimeMillis;
                arrayList3.add(userInfoCreateFromServerObject);
                arrayList4.add(ChatAbsObject.createFromUserInfo(next, j));
                arrayList5.add(ObjectInfo.createFromUserInfo(userInfoCreateFromServerObject));
            }
            addToInfoMap(arrayList5);
            addToContactMap(arrayList3);
            addToAbsMap(arrayList4, j);
            dBHelper.addAllAbsObject(arrayList4, j);
            dBHelper.addAllContactsAndUserInfo(arrayList3, jCurrentTimeMillis);
            z = true;
        }
        ArrayList<ChatAbsObject> arrayList6 = new ArrayList<>();
        ArrayList<ObjectInfo> arrayList7 = new ArrayList<>();
        ArrayList<UserInfo> arrayList8 = new ArrayList<>();
        ArrayList<String> arrayList9 = new ArrayList<>();
        if (arrayList2 == null || arrayList2.size() <= 0) {
            z2 = z;
        } else {
            Iterator<UserInfoFromServer> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                UserInfoFromServer next2 = it2.next();
                ArrayList<String> arrayList10 = arrayList9;
                UserInfo userInfoCreateFromServerObject2 = UserInfo.createFromServerObject(next2, j, 0L, false, false);
                userInfoCreateFromServerObject2.insertedToDbTime = jCurrentTimeMillis;
                arrayList8.add(userInfoCreateFromServerObject2);
                arrayList6.add(ChatAbsObject.createFromUserInfo(next2, j));
                arrayList7.add(ObjectInfo.createFromUserInfo(userInfoCreateFromServerObject2));
                arrayList10.add(next2.user_guid);
                arrayList9 = arrayList10;
            }
            addToInfoMap(arrayList7);
            addToAbsMap(arrayList6, j);
            removeFromContactMap(arrayList9);
            dBHelper.addAllAbsObject(arrayList6, j);
            dBHelper.addAllUserInfo(arrayList8, jCurrentTimeMillis);
        }
        if (z2) {
            createAndSortContactListAndNotify(absNotificationCenter, new ContactsNeedsReloadResult(ContactsNeedsReloadResult.TypeEnum.allContactListUpdated));
        }
    }

    public void processChatsUpdate(ChatUpdateObject chatUpdateObject, UpdateChatUsecase updateChatUsecase, AbsNotificationCenter absNotificationCenter, DBHelper dBHelper) {
        if (chatUpdateObject == null) {
            return;
        }
        ArrayList<ChatUpdateObject> arrayList = new ArrayList<>();
        arrayList.add(chatUpdateObject);
        processChatsUpdate(arrayList, updateChatUsecase, absNotificationCenter, dBHelper);
    }

    public void processChatsUpdate(ArrayList<ChatUpdateObject> arrayList, UpdateChatUsecase updateChatUsecase, AbsNotificationCenter absNotificationCenter, DBHelper dBHelper) {
        DBHelper dBHelper2;
        ChatUpdateObject chatUpdateObject;
        ArrayList<String> arrayList2;
        ArrayList<String> arrayList3;
        HashMap map;
        if (arrayList == null || arrayList.size() == 0 || !this.isChatInited) {
            return;
        }
        HashSet hashSet = new HashSet(0);
        HashMap map2 = new HashMap(0);
        HashMap map3 = new HashMap();
        HashMap map4 = new HashMap();
        ArrayList<String> arrayList4 = new ArrayList<>(0);
        ArrayList<String> arrayList5 = new ArrayList<>();
        Iterator<ChatUpdateObject> it = arrayList.iterator();
        while (it.hasNext()) {
            ChatUpdateObject next = it.next();
            Chat chat = this.chatMap.get(next.object_guid);
            ChatAbsObject chatAbsObject = this.absMap.get(next.object_guid);
            if (next.action != ChatUpdateObject.ChatUpdateAction.Edit) {
                chatUpdateObject = next;
                arrayList2 = arrayList5;
                HashMap map5 = map2;
                arrayList3 = arrayList4;
                map = map5;
            } else if (chat != null) {
                HashMap map6 = map2;
                chatUpdateObject = next;
                arrayList2 = arrayList5;
                arrayList3 = arrayList4;
                Set<ChatParamUpdateTimeObject.Params> setProcessChatUpdateEdit = processChatUpdateEdit(chat, chatAbsObject != null ? chatAbsObject.type : null, next, next.timestamp, absNotificationCenter, updateChatUsecase);
                if (setProcessChatUpdateEdit.size() > 0) {
                    map = map6;
                    map.put(chatUpdateObject.object_guid, setProcessChatUpdateEdit);
                    map3.put(chatUpdateObject.object_guid, chatUpdateObject.chat);
                    map4.put(chatUpdateObject.object_guid, Long.valueOf(chatUpdateObject.timestamp));
                } else {
                    map = map6;
                }
            } else {
                chatUpdateObject = next;
                arrayList2 = arrayList5;
                HashMap map7 = map2;
                arrayList3 = arrayList4;
                map = map7;
                if (!this.requestingGetChatIds.contains(chatUpdateObject.object_guid)) {
                    hashSet.add(chatUpdateObject.object_guid);
                }
            }
            if (chatUpdateObject.action == ChatUpdateObject.ChatUpdateAction.Delete) {
                arrayList2.add(chatUpdateObject.object_guid);
            }
            if (chatUpdateObject.action == ChatUpdateObject.ChatUpdateAction.New) {
                addNewChatAndAbsToMapAndDb(chatUpdateObject.chat, chatUpdateObject.timestamp, false, dBHelper, absNotificationCenter);
                arrayList3.add(chatUpdateObject.object_guid);
            }
            arrayList5 = arrayList2;
            ArrayList<String> arrayList6 = arrayList3;
            map2 = map;
            arrayList4 = arrayList6;
        }
        ArrayList<String> arrayList7 = arrayList5;
        HashMap map8 = map2;
        ArrayList<String> arrayList8 = arrayList4;
        if (hashSet.size() > 0 && updateChatUsecase != null) {
            updateChatUsecase.chatsToLoad(hashSet);
        }
        if (arrayList7.size() > 0 && updateChatUsecase != null) {
            updateChatUsecase.deleteChats(arrayList7, false);
        }
        if (map8.size() > 0) {
            dBHelper2 = dBHelper;
            dBHelper2.updateChatParameter(map3, map8, map4);
        } else {
            dBHelper2 = dBHelper;
        }
        if (arrayList8.size() > 0 || arrayList7.size() > 0 || map8.size() > 0) {
            ChatNeedReloadResult chatNeedReloadResult = new ChatNeedReloadResult(ChatNeedReloadResult.TypeEnum.SomeChatsUpdated);
            chatNeedReloadResult.deleteChats = arrayList7;
            chatNeedReloadResult.newChats = arrayList8;
            chatNeedReloadResult.updatedChats = map8;
            createAndSortChatList(absNotificationCenter, chatNeedReloadResult, dBHelper2);
        }
    }

    public void addChatAbsObjects(ArrayList<ChatAbsObject> arrayList, long j, DBHelper dBHelper) {
        addToAbsMap(arrayList, j);
        dBHelper.addAllAbsObject(arrayList, j);
    }

    public boolean loadForGuid(String str, DBHelper dBHelper, KeyValueStorageHelper keyValueStorageHelper) {
        Chat chatInstant = getChatInstant(str);
        if (getChatAbsInstant(str, dBHelper) != null) {
            return true;
        }
        String chatsState = keyValueStorageHelper.getChatsState();
        if (chatsState != null && !chatsState.isEmpty()) {
            Chat chatById = dBHelper.getChatById(str);
            ChatAbsObject absObjectFromDB = getAbsObjectFromDB(dBHelper, str);
            if (absObjectFromDB != null) {
                addToAbsMap(absObjectFromDB, absObjectFromDB.timeStamp);
                if (chatInstant != null || chatById == null) {
                    return true;
                }
                addToChatMap(chatById, false, (AbsNotificationCenter) null, dBHelper);
                return true;
            }
        }
        return false;
    }

    Set<ChatParamUpdateTimeObject.Params> processChatUpdateEdit(Chat chat, ChatType chatType, ChatUpdateObject chatUpdateObject, long j, AbsNotificationCenter absNotificationCenter, UpdateChatUsecase updateChatUsecase) {
        ChatParamUpdateTimeObject.Params[] paramsArr;
        int i;
        HashSet hashSet = new HashSet();
        if (j < chat.getUpdateTimestamp()) {
            return hashSet;
        }
        ChatParamUpdateTimeObject.Params[] paramsArr2 = chatUpdateObject.updated_parameters;
        int length = paramsArr2.length;
        int i2 = 0;
        boolean z = false;
        boolean z2 = false;
        while (i2 < length) {
            ChatParamUpdateTimeObject.Params params = paramsArr2[i2];
            if (params == ChatParamUpdateTimeObject.Params.access) {
                if (j > chat.getUpdateTimestamp(params)) {
                    chat.access = chatUpdateObject.chat.access;
                    chat.setParamUpdateTime(params, j);
                    hashSet.add(params);
                    paramsArr = paramsArr2;
                    i = length;
                    z = true;
                }
                paramsArr = paramsArr2;
                i = length;
            } else {
                if (params == ChatParamUpdateTimeObject.Params.count_unseen) {
                    if (j > chat.getUpdateTimestamp(params)) {
                        chat.count_unseen = chatUpdateObject.chat.count_unseen;
                        chat.setParamUpdateTime(params, j);
                        chat.fillAttributes();
                        hashSet.add(params);
                    }
                } else if (params == ChatParamUpdateTimeObject.Params.is_mute) {
                    if (j > chat.getUpdateTimestamp(params)) {
                        chat.is_mute = chatUpdateObject.chat.is_mute;
                        chat.setParamUpdateTime(params, j);
                        hashSet.add(params);
                        paramsArr = paramsArr2;
                        i = length;
                        z = true;
                    }
                } else if (params == ChatParamUpdateTimeObject.Params.is_pinned) {
                    if (j > chat.getUpdateTimestamp(params)) {
                        chat.is_pinned = chatUpdateObject.chat.is_pinned;
                        chat.setParamUpdateTime(params, j);
                        hashSet.add(params);
                    }
                } else if (params == ChatParamUpdateTimeObject.Params.time_string) {
                    if (j > chat.getUpdateTimestamp(params)) {
                        chat.time_string = chatUpdateObject.chat.time_string;
                        chat.setParamUpdateTime(params, j);
                        chat.fillAttributes();
                        hashSet.add(params);
                    }
                } else if (params != ChatParamUpdateTimeObject.Params.last_message) {
                    if (params == ChatParamUpdateTimeObject.Params.last_seen_my_mid) {
                        if (j > chat.getUpdateTimestamp(params)) {
                            long j2 = chat.last_seen_my_mid;
                            long j3 = chatUpdateObject.chat.last_seen_my_mid;
                            if (j2 <= j3) {
                                chat.last_seen_my_mid = j3;
                                chat.setParamUpdateTime(params, j);
                                chat.fillAttributes();
                                hashSet.add(params);
                                updateChatUsecase.seenChat(chatUpdateObject.object_guid, chatType, chat.last_seen_my_mid);
                            }
                        }
                    } else if (params != ChatParamUpdateTimeObject.Params.last_seen_peer_mid) {
                        paramsArr = paramsArr2;
                        i = length;
                        if (params == ChatParamUpdateTimeObject.Params.status) {
                            if (j > chat.getUpdateTimestamp(params)) {
                                Chat.ChatStatusEnum chatStatusEnum = chat.status;
                                Chat.ChatStatusEnum chatStatusEnum2 = chatUpdateObject.chat.status;
                                if (chatStatusEnum != chatStatusEnum2) {
                                    z = true;
                                }
                                chat.status = chatStatusEnum2;
                                chat.setParamUpdateTime(params, j);
                                hashSet.add(params);
                            }
                        } else if (params == ChatParamUpdateTimeObject.Params.abs_object) {
                            ChatAbsObject chatAbsObject = this.absMap.get(chat.object_guid);
                            if (j > (chatAbsObject != null ? chatAbsObject.timeStamp : 0L)) {
                                addToAbsMap(chatUpdateObject.chat.abs_object, j);
                                hashSet.add(params);
                                z2 = true;
                            }
                        } else if (params != ChatParamUpdateTimeObject.Params.time) {
                            ChatParamUpdateTimeObject.Params params2 = ChatParamUpdateTimeObject.Params.pinned_message_ids;
                            if (params == params2) {
                                if (j > chat.getUpdateTimestamp(params)) {
                                    chat.pinned_message_ids = chatUpdateObject.chat.pinned_message_ids;
                                    chat.setParamUpdateTime(params, j);
                                    hashSet.add(params);
                                }
                            } else if (params == params2) {
                                if (j > chat.getUpdateTimestamp(params)) {
                                    chat.pinned_message_ids = chatUpdateObject.chat.pinned_message_ids;
                                    chat.setParamUpdateTime(params, j);
                                    hashSet.add(params);
                                }
                            } else if (params == ChatParamUpdateTimeObject.Params.is_blocked) {
                                if (j > chat.getUpdateTimestamp(params)) {
                                    chat.is_blocked = chatUpdateObject.chat.is_blocked;
                                    chat.setParamUpdateTime(params, j);
                                    hashSet.add(params);
                                }
                            } else if (params == ChatParamUpdateTimeObject.Params.last_message_id) {
                                if (j > chat.getUpdateTimestamp(params)) {
                                    chat.last_message_id = chatUpdateObject.chat.last_message_id;
                                    chat.setParamUpdateTime(params, j);
                                    chat.fillAttributes();
                                    hashSet.add(params);
                                }
                            } else if (params == ChatParamUpdateTimeObject.Params.last_deleted_mid) {
                                if (j > chat.getUpdateTimestamp(params)) {
                                    chat.last_deleted_mid = chatUpdateObject.chat.last_deleted_mid;
                                    chat.setParamUpdateTime(params, j);
                                    hashSet.add(params);
                                }
                            } else if (params == ChatParamUpdateTimeObject.Params.chat_keypad) {
                                if (j > chat.getUpdateTimestamp(params)) {
                                    chat.chat_keypad = chatUpdateObject.chat.chat_keypad;
                                    chat.setParamUpdateTime(params, j);
                                    hashSet.add(params);
                                    z = true;
                                }
                            } else if (params == ChatParamUpdateTimeObject.Params.slow_mode_duration) {
                                if (j > chat.getUpdateTimestamp(params)) {
                                    chat.slow_mode_duration = chatUpdateObject.chat.slow_mode_duration;
                                    chat.setParamUpdateTime(params, j);
                                    hashSet.add(params);
                                    z = true;
                                }
                            } else if (params == ChatParamUpdateTimeObject.Params.group_my_last_send_time) {
                                if (j > chat.getUpdateTimestamp(params)) {
                                    chat.group_my_last_send_time = chatUpdateObject.chat.group_my_last_send_time;
                                    chat.setParamUpdateTime(params, j);
                                    hashSet.add(params);
                                    z = true;
                                }
                            } else if (params == ChatParamUpdateTimeObject.Params.group_voice_chat_id) {
                                if (j > chat.getUpdateTimestamp(params)) {
                                    chat.group_voice_chat_id = chatUpdateObject.chat.group_voice_chat_id;
                                    chat.setParamUpdateTime(params, j);
                                    hashSet.add(params);
                                    z = true;
                                }
                            } else if (params == ChatParamUpdateTimeObject.Params.show_ask_spam && j > chat.getUpdateTimestamp(params)) {
                                chat.show_ask_spam = chatUpdateObject.chat.show_ask_spam;
                                chat.setParamUpdateTime(params, j);
                                hashSet.add(params);
                                z = true;
                            }
                        } else if (j > chat.getUpdateTimestamp(params)) {
                            chat.time = chatUpdateObject.chat.time;
                            chat.setParamUpdateTime(params, j);
                            chat.fillAttributes();
                            hashSet.add(params);
                        }
                    } else if (j > chat.getUpdateTimestamp(params)) {
                        long j4 = chat.last_seen_peer_mid;
                        paramsArr = paramsArr2;
                        i = length;
                        long j5 = chatUpdateObject.chat.last_seen_peer_mid;
                        if (j4 < j5) {
                            chat.last_seen_peer_mid = j5;
                            chat.setParamUpdateTime(params, j);
                            hashSet.add(params);
                        }
                    }
                    paramsArr = paramsArr2;
                    i = length;
                } else if (j > chat.getUpdateTimestamp(params)) {
                    chat.last_message = chatUpdateObject.chat.last_message;
                    chat.setParamUpdateTime(params, j);
                    chat.fillAttributes();
                    hashSet.add(params);
                }
                paramsArr = paramsArr2;
                i = length;
            }
            i2++;
            paramsArr2 = paramsArr;
            length = i;
        }
        if (z || z2) {
            ChatAbsObject chatAbsObject2 = this.absMap.get(chatUpdateObject.object_guid);
            absNotificationCenter.objectInfoDidLoad(chatUpdateObject.object_guid, chatAbsObject2 != null ? chatAbsObject2.type : null);
        }
        return hashSet;
    }

    public FileInlineObject getSentFile(String str, DBHelper dBHelper) {
        return dBHelper.getSentFile(str);
    }

    public void saveSentFile(String str, FileInlineObject fileInlineObject, DBHelper dBHelper) {
        dBHelper.addSentFile(str, fileInlineObject, 0L);
    }

    public SortedContactResult sortContact(ArrayList<String> arrayList) {
        final HashMap map = new HashMap(this.objectInfoByIdMap);
        SortedContactResult sortedContactResult = new SortedContactResult();
        sortedContactResult.sortedByLasOnlineContacts = new ArrayList<>(arrayList);
        final long jCurrentTimeMillis = (System.currentTimeMillis() - 7776000000L) / 1000;
        Collections.sort(sortedContactResult.sortedByLasOnlineContacts, new Comparator<String>(this) { // from class: ir.aaap.messengercore.ChatUtils.109
            @Override // java.util.Comparator
            public int compare(String str, String str2) {
                UserInfo userInfo;
                ObjectInfo objectInfo = (ObjectInfo) map.get(str);
                ObjectInfo objectInfo2 = (ObjectInfo) map.get(str2);
                if (objectInfo == null || objectInfo.userInfo == null || objectInfo2 == null || (userInfo = objectInfo2.userInfo) == null) {
                    return 0;
                }
                return (UserInfo.getLastOnlineForSort(userInfo, jCurrentTimeMillis) > UserInfo.getLastOnlineForSort(objectInfo.userInfo, jCurrentTimeMillis) ? 1 : (UserInfo.getLastOnlineForSort(userInfo, jCurrentTimeMillis) == UserInfo.getLastOnlineForSort(objectInfo.userInfo, jCurrentTimeMillis) ? 0 : -1));
            }
        });
        return sortedContactResult;
    }

    public class LoadChatAbsHelper {
        String auth;
        DBHelper dbHelper;
        LoadListener<Set<String>> loadListener;
        NetworkHelper networkHelper;

        public LoadChatAbsHelper(String str, NetworkHelper networkHelper, DBHelper dBHelper, LoadListener<Set<String>> loadListener) {
            this.loadListener = loadListener;
            this.auth = str;
            this.networkHelper = networkHelper;
            this.dbHelper = dBHelper;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void getAbsObjectsFromServer(ArrayList<String> arrayList, Set<String> set) {
            getAbsObjectsFromServerLimited(arrayList, set, Math.max(1, ((int) ((arrayList.size() * 1.0f) / (CoreMainClassImpl.GET_ABS_LIMIT * 1.0f))) * 2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void getAbsObjectsFromServerLimited(final ArrayList<String> arrayList, final Set<String> set, final int i) {
            ArrayList arrayList2;
            if (i < 0) {
                this.loadListener.onError(new Exception("recursive loop"));
                return;
            }
            if (arrayList.size() > 0) {
                if (arrayList.size() >= CoreMainClassImpl.GET_ABS_LIMIT) {
                    arrayList2 = new ArrayList(arrayList.subList(0, CoreMainClassImpl.GET_ABS_LIMIT));
                } else {
                    arrayList2 = new ArrayList(arrayList);
                }
                final ArrayList arrayList3 = arrayList2;
                try {
                    this.networkHelper.getAbsObjects(this.auth, new GetAbsObjectsInput((ArrayList<String>) arrayList3), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetAbsObjectsOutput>() { // from class: ir.aaap.messengercore.ChatUtils.LoadChatAbsHelper.1
                        @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                        public void onResponse(GetAbsObjectsOutput getAbsObjectsOutput) {
                            ArrayList<ChatAbsObject> arrayList4 = getAbsObjectsOutput.abs_objects;
                            if (arrayList4 != null) {
                                ChatUtils.this.addToAbsMap(arrayList4, getAbsObjectsOutput.timestamp);
                                LoadChatAbsHelper.this.dbHelper.addAllAbsObject(getAbsObjectsOutput.abs_objects, getAbsObjectsOutput.timestamp);
                            }
                            arrayList.removeAll(arrayList3);
                            set.addAll(arrayList3);
                            LoadChatAbsHelper.this.getAbsObjectsFromServerLimited(arrayList, set, i - 1);
                        }

                        @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                        public void onError(Exception exc) {
                            LoadListener<Set<String>> loadListener = LoadChatAbsHelper.this.loadListener;
                            if (loadListener != null) {
                                loadListener.onError(exc);
                            }
                        }
                    });
                    return;
                } catch (Exception e) {
                    ChatUtils.this.coreLog.handleException(e);
                    return;
                }
            }
            LoadListener<Set<String>> loadListener = this.loadListener;
            if (loadListener != null) {
                loadListener.onDidLoad(set);
            }
        }
    }

    public class ImportPhoneBookHelper {
        String auth;
        DBHelper dbHelper;
        UpdateChatUsecase deleteChatUsecase;
        KeyValueStorageHelper keyValueStorageHelper;
        LoadListener<Set<PhoneBookObject>> loadListener;
        NetworkHelper networkHelper;
        AbsNotificationCenter notificationCenter;
        TimerHelper timerHelper;

        public ImportPhoneBookHelper(String str, NetworkHelper networkHelper, DBHelper dBHelper, AbsNotificationCenter absNotificationCenter, UpdateChatUsecase updateChatUsecase, KeyValueStorageHelper keyValueStorageHelper, TimerHelper timerHelper, LoadListener<Set<PhoneBookObject>> loadListener) {
            this.loadListener = loadListener;
            this.auth = str;
            this.networkHelper = networkHelper;
            this.dbHelper = dBHelper;
            this.notificationCenter = absNotificationCenter;
            this.deleteChatUsecase = updateChatUsecase;
            this.keyValueStorageHelper = keyValueStorageHelper;
            this.timerHelper = timerHelper;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void importPhoneBookLimited(ArrayList<PhoneBookObject> arrayList, Set<PhoneBookObject> set) {
            importPhoneBookLimited(arrayList, set, Math.max(1, ((int) ((arrayList.size() * 1.0f) / (CoreMainClassImpl.IMPORT_ADDRESS_BOOK_LIMIT * 1.0f))) * 2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void importPhoneBookLimited(final ArrayList<PhoneBookObject> arrayList, final Set<PhoneBookObject> set, final int i) {
            ArrayList arrayList2;
            if (i < 0) {
                this.loadListener.onError(new Exception("recursive loop"));
                return;
            }
            if (arrayList.size() > 0) {
                if (arrayList.size() >= CoreMainClassImpl.IMPORT_ADDRESS_BOOK_LIMIT) {
                    arrayList2 = new ArrayList(arrayList.subList(0, CoreMainClassImpl.IMPORT_ADDRESS_BOOK_LIMIT));
                } else {
                    arrayList2 = new ArrayList(arrayList);
                }
                final ArrayList arrayList3 = arrayList2;
                try {
                    ImportAddressBookInput importAddressBookInput = new ImportAddressBookInput();
                    final ArrayList arrayList4 = new ArrayList(arrayList3);
                    importAddressBookInput.address_book_items = arrayList4;
                    this.networkHelper.importAddressBook(this.auth, importAddressBookInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<ImportAddressBookOutput>() { // from class: ir.aaap.messengercore.ChatUtils.ImportPhoneBookHelper.1
                        @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                        public void onResponse(ImportAddressBookOutput importAddressBookOutput) {
                            ArrayList<ChatUpdateObject> arrayList5 = importAddressBookOutput.chat_updates;
                            if (arrayList5 != null) {
                                ImportPhoneBookHelper importPhoneBookHelper = ImportPhoneBookHelper.this;
                                ChatUtils.this.processChatsUpdate(arrayList5, importPhoneBookHelper.deleteChatUsecase, importPhoneBookHelper.notificationCenter, importPhoneBookHelper.dbHelper);
                            }
                            ImportPhoneBookHelper.this.dbHelper.addAllPhoneBook(arrayList3);
                            arrayList.removeAll(arrayList4);
                            set.addAll(arrayList4);
                            ImportPhoneBookHelper.this.importPhoneBookLimited(arrayList, set, i - 1);
                            ImportPhoneBookHelper importPhoneBookHelper2 = ImportPhoneBookHelper.this;
                            ChatUtils.this.getContactUpdates(false, 60000L, importPhoneBookHelper2.auth, importPhoneBookHelper2.networkHelper, importPhoneBookHelper2.dbHelper, importPhoneBookHelper2.notificationCenter, importPhoneBookHelper2.keyValueStorageHelper, importPhoneBookHelper2.timerHelper);
                        }

                        @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                        public void onError(Exception exc) {
                            LoadListener<Set<PhoneBookObject>> loadListener = ImportPhoneBookHelper.this.loadListener;
                            if (loadListener != null) {
                                loadListener.onError(exc);
                            }
                        }
                    });
                    return;
                } catch (Exception e) {
                    ChatUtils.this.coreLog.handleException(e);
                    return;
                }
            }
            LoadListener<Set<PhoneBookObject>> loadListener = this.loadListener;
            if (loadListener != null) {
                loadListener.onDidLoad(set);
            }
        }
    }

    public class GetContactsLastOnlineHelper {
        String auth;
        DBHelper dbHelper;
        LoadListener<Integer> loadListener;
        NetworkHelper networkHelper;
        AbsNotificationCenter notificationCenter;
        TimerHelper timerHelper;
        ArrayList<String> toSend;

        public GetContactsLastOnlineHelper(String str, NetworkHelper networkHelper, DBHelper dBHelper, AbsNotificationCenter absNotificationCenter, TimerHelper timerHelper, LoadListener<Integer> loadListener) {
            this.loadListener = loadListener;
            this.auth = str;
            this.networkHelper = networkHelper;
            this.dbHelper = dBHelper;
            this.notificationCenter = absNotificationCenter;
            this.timerHelper = timerHelper;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void getContactsLastOnline(ArrayList<String> arrayList) {
            this.toSend = new ArrayList<>(arrayList);
            getContactsLastOnlineLimited(0, Math.max(1, ((int) ((arrayList.size() * 1.0f) / (CoreMainClassImpl.GET_CONTACT_LAST_ONLINE_LIMIT * 1.0f))) * 2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void getContactsLastOnlineLimited(final int i, final int i2) {
            ArrayList<String> arrayList;
            if (i2 < 0) {
                this.loadListener.onError(new Exception("recursive loop"));
                return;
            }
            if (i < this.toSend.size()) {
                if (this.toSend.size() >= CoreMainClassImpl.GET_CONTACT_LAST_ONLINE_LIMIT + i) {
                    arrayList = new ArrayList<>(this.toSend.subList(i, CoreMainClassImpl.GET_CONTACT_LAST_ONLINE_LIMIT + i));
                } else {
                    ArrayList<String> arrayList2 = this.toSend;
                    arrayList = new ArrayList<>(arrayList2.subList(i, arrayList2.size()));
                }
                try {
                    GetContactsLastOnlineInput getContactsLastOnlineInput = new GetContactsLastOnlineInput();
                    getContactsLastOnlineInput.user_guids = arrayList;
                    this.networkHelper.getContactsLastOnline(this.auth, getContactsLastOnlineInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetContactsLastOnlineOutput>() { // from class: ir.aaap.messengercore.ChatUtils.GetContactsLastOnlineHelper.1
                        @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                        public void onResponse(GetContactsLastOnlineOutput getContactsLastOnlineOutput) {
                            UserInfo userInfo;
                            ArrayList<UserInfoFromServer> arrayList3 = getContactsLastOnlineOutput.users;
                            if (arrayList3 != null) {
                                Iterator<UserInfoFromServer> it = arrayList3.iterator();
                                while (it.hasNext()) {
                                    UserInfoFromServer next = it.next();
                                    ObjectInfo objectInfo = (ObjectInfo) ChatUtils.this.objectInfoByIdMap.get(next.user_guid);
                                    if (objectInfo != null && (userInfo = objectInfo.userInfo) != null) {
                                        userInfo.online_time = next.online_time;
                                    }
                                }
                                GetContactsLastOnlineHelper.this.dbHelper.updateContactLastOnline(getContactsLastOnlineOutput.users);
                                ContactsNeedsReloadResult contactsNeedsReloadResult = new ContactsNeedsReloadResult(ContactsNeedsReloadResult.TypeEnum.lastOnlineSortedChanged);
                                GetContactsLastOnlineHelper getContactsLastOnlineHelper = GetContactsLastOnlineHelper.this;
                                ChatUtils.this.createAndSortContactListAndNotify(getContactsLastOnlineHelper.notificationCenter, contactsNeedsReloadResult);
                            }
                            if (ChatUtils.this.contactIsStarted) {
                                GetContactsLastOnlineHelper.this.timerHelper.postRunnableDelayed(new Runnable() { // from class: ir.aaap.messengercore.ChatUtils.GetContactsLastOnlineHelper.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (ChatUtils.this.contactIsStarted) {
                                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                            GetContactsLastOnlineHelper.this.getContactsLastOnlineLimited(i + CoreMainClassImpl.GET_CONTACT_LAST_ONLINE_LIMIT, i2 - 1);
                                        }
                                    }
                                }, 1000L);
                            }
                        }

                        @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                        public void onError(Exception exc) {
                            LoadListener<Integer> loadListener = GetContactsLastOnlineHelper.this.loadListener;
                            if (loadListener != null) {
                                loadListener.onError(exc);
                            }
                            if (ChatUtils.this.contactIsStarted) {
                                GetContactsLastOnlineHelper.this.timerHelper.postRunnableDelayed(new Runnable() { // from class: ir.aaap.messengercore.ChatUtils.GetContactsLastOnlineHelper.1.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (ChatUtils.this.contactIsStarted) {
                                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                            GetContactsLastOnlineHelper.this.getContactsLastOnlineLimited(i, i2);
                                        }
                                    }
                                }, 2000L);
                            }
                        }
                    });
                    return;
                } catch (Exception e) {
                    ChatUtils.this.coreLog.handleException(e);
                    return;
                }
            }
            LoadListener<Integer> loadListener = this.loadListener;
            if (loadListener != null) {
                loadListener.onDidLoad(1);
            }
        }
    }

    public class GetLastOnlineHelper {
        String auth;
        DBHelper dbHelper;
        LoadListener<Integer> loadListener;
        NetworkHelper networkHelper;
        ArrayList<String> toSend;

        public GetLastOnlineHelper(String str, NetworkHelper networkHelper, DBHelper dBHelper, LoadListener<Integer> loadListener) {
            this.loadListener = loadListener;
            this.auth = str;
            this.networkHelper = networkHelper;
            this.dbHelper = dBHelper;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void getLastOnline(ArrayList<String> arrayList) {
            this.toSend = new ArrayList<>(arrayList);
            getLastOnlineLimited(0, Math.max(1, ((int) ((arrayList.size() * 1.0f) / (CoreMainClassImpl.GET_CONTACT_LAST_ONLINE_LIMIT * 1.0f))) * 2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void getLastOnlineLimited(final int i, final int i2) {
            ArrayList<String> arrayList;
            if (i2 < 0) {
                this.loadListener.onError(new Exception("recursive loop"));
                return;
            }
            if (i < this.toSend.size()) {
                if (this.toSend.size() >= CoreMainClassImpl.GET_CONTACT_LAST_ONLINE_LIMIT + i) {
                    arrayList = new ArrayList<>(this.toSend.subList(i, CoreMainClassImpl.GET_CONTACT_LAST_ONLINE_LIMIT + i));
                } else {
                    ArrayList<String> arrayList2 = this.toSend;
                    arrayList = new ArrayList<>(arrayList2.subList(i, arrayList2.size()));
                }
                try {
                    GetContactsLastOnlineInput getContactsLastOnlineInput = new GetContactsLastOnlineInput();
                    getContactsLastOnlineInput.user_guids = arrayList;
                    this.networkHelper.getContactsLastOnline(this.auth, getContactsLastOnlineInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetContactsLastOnlineOutput>() { // from class: ir.aaap.messengercore.ChatUtils.GetLastOnlineHelper.1
                        @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                        public void onResponse(GetContactsLastOnlineOutput getContactsLastOnlineOutput) {
                            UserInfo userInfo;
                            ArrayList<UserInfoFromServer> arrayList3 = getContactsLastOnlineOutput.users;
                            if (arrayList3 != null) {
                                Iterator<UserInfoFromServer> it = arrayList3.iterator();
                                while (it.hasNext()) {
                                    UserInfoFromServer next = it.next();
                                    ObjectInfo objectInfo = (ObjectInfo) ChatUtils.this.objectInfoByIdMap.get(next.user_guid);
                                    if (objectInfo != null && (userInfo = objectInfo.userInfo) != null) {
                                        userInfo.online_time = next.online_time;
                                    }
                                }
                                GetLastOnlineHelper.this.dbHelper.updateContactLastOnline(getContactsLastOnlineOutput.users);
                            }
                            GetLastOnlineHelper.this.getLastOnlineLimited(i + CoreMainClassImpl.GET_CONTACT_LAST_ONLINE_LIMIT, i2 - 1);
                        }

                        @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                        public void onError(Exception exc) {
                            LoadListener<Integer> loadListener = GetLastOnlineHelper.this.loadListener;
                            if (loadListener != null) {
                                loadListener.onError(exc);
                            }
                        }
                    });
                    return;
                } catch (Exception e) {
                    ChatUtils.this.coreLog.handleException(e);
                    return;
                }
            }
            LoadListener<Integer> loadListener = this.loadListener;
            if (loadListener != null) {
                loadListener.onDidLoad(1);
            }
        }
    }

    public class GetChatsByIdHelper {
        String auth;
        DBHelper dbHelper;
        LoadListener<Integer> loadListener;
        NetworkHelper networkHelper;
        AbsNotificationCenter notificationCenter;
        ArrayList<String> toSend;

        public GetChatsByIdHelper(String str, NetworkHelper networkHelper, DBHelper dBHelper, AbsNotificationCenter absNotificationCenter, LoadListener<Integer> loadListener) {
            this.loadListener = loadListener;
            this.auth = str;
            this.networkHelper = networkHelper;
            this.dbHelper = dBHelper;
            this.notificationCenter = absNotificationCenter;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void getChatsById(ArrayList<String> arrayList) {
            this.toSend = new ArrayList<>(arrayList);
            getChatsByIdLimited(0, Math.max(1, ((int) ((arrayList.size() * 1.0f) / 50.0f)) * 2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void getChatsByIdLimited(final int i, final int i2) {
            ArrayList<String> arrayList;
            if (i2 < 0) {
                this.loadListener.onError(new Exception("recursive loop"));
                return;
            }
            if (i < this.toSend.size()) {
                int i3 = i + 50;
                if (this.toSend.size() >= i3) {
                    arrayList = new ArrayList<>(this.toSend.subList(i, i3));
                } else {
                    ArrayList<String> arrayList2 = this.toSend;
                    arrayList = new ArrayList<>(arrayList2.subList(i, arrayList2.size()));
                }
                GetChatsByIDInput getChatsByIDInput = new GetChatsByIDInput();
                getChatsByIDInput.object_guids = arrayList;
                try {
                    this.networkHelper.getChatsByID(this.auth, getChatsByIDInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetChatByIDOutput>() { // from class: ir.aaap.messengercore.ChatUtils.GetChatsByIdHelper.1
                        @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                        public void onResponse(GetChatByIDOutput getChatByIDOutput) {
                            GetChatsByIdHelper getChatsByIdHelper = GetChatsByIdHelper.this;
                            ChatUtils.this.addNewChatAndAbsToMapAndDb(getChatByIDOutput.chats, getChatByIDOutput.timestamp, true, getChatsByIdHelper.dbHelper, getChatsByIdHelper.notificationCenter);
                            GetChatsByIdHelper.this.getChatsByIdLimited(i + 50, i2 - 1);
                        }

                        @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                        public void onError(Exception exc) {
                            LoadListener<Integer> loadListener = GetChatsByIdHelper.this.loadListener;
                            if (loadListener != null) {
                                loadListener.onError(exc);
                            }
                        }
                    });
                    return;
                } catch (Exception e) {
                    ChatUtils.this.coreLog.handleException(e);
                    LoadListener<Integer> loadListener = this.loadListener;
                    if (loadListener != null) {
                        loadListener.onError(e);
                        return;
                    }
                    return;
                }
            }
            LoadListener<Integer> loadListener2 = this.loadListener;
            if (loadListener2 != null) {
                loadListener2.onDidLoad(1);
            }
        }
    }
}
