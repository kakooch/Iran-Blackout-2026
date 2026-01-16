package ir.aaap.messengercore.network;

import io.github.inflationx.calligraphy3.BuildConfig;
import ir.aaap.messengercore.JsonHelper;
import ir.aaap.messengercore.exceptions.NotificationException;
import ir.aaap.messengercore.model.ClickMessageUrlInput;
import ir.aaap.messengercore.model.ClickMessageUrlOutput;
import ir.aaap.messengercore.model.GetDcsOutput;
import ir.aaap.messengercore.model.GetFileInput;
import ir.aaap.messengercore.model.GetFileResult;
import ir.aaap.messengercore.model.GetLinkFromAppUrlInput;
import ir.aaap.messengercore.model.GetLinkFromAppUrlOutput;
import ir.aaap.messengercore.model.GroupCallModels;
import ir.aaap.messengercore.model.LiveModels;
import ir.aaap.messengercore.model.PollModels;
import ir.aaap.messengercore.model.SendChatActivityInput;
import ir.aaap.messengercore.model.SendChatActivityOutput;
import ir.aaap.messengercore.model.SettingModels;
import ir.aaap.messengercore.model.VoiceCallModels;
import ir.aaap.messengercore.model.api.AbortTwoStepSetupInput;
import ir.aaap.messengercore.model.api.AbortTwoStepSetupOutput;
import ir.aaap.messengercore.model.api.ActionOnChatAdsInput;
import ir.aaap.messengercore.model.api.ActionOnChatAdsOutput;
import ir.aaap.messengercore.model.api.ActionOnStickersInput;
import ir.aaap.messengercore.model.api.ActionOnStickersOutput;
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
import ir.aaap.messengercore.model.api.AddToMyGifSetInput;
import ir.aaap.messengercore.model.api.AddToMyGifSetOutput;
import ir.aaap.messengercore.model.api.BanChannelMemberInput;
import ir.aaap.messengercore.model.api.BanChannelMemberOutput;
import ir.aaap.messengercore.model.api.BanGroupMemberInput;
import ir.aaap.messengercore.model.api.BanGroupMemberOutput;
import ir.aaap.messengercore.model.api.BotModels;
import ir.aaap.messengercore.model.api.ChangeFolderOutput;
import ir.aaap.messengercore.model.api.ChangeOwnerModels;
import ir.aaap.messengercore.model.api.ChangePasswordInput;
import ir.aaap.messengercore.model.api.ChannelPreviewByJoinLinkInput;
import ir.aaap.messengercore.model.api.ChannelPreviewByJoinLinkOutput;
import ir.aaap.messengercore.model.api.CheckChannelsWithUsernameInput;
import ir.aaap.messengercore.model.api.CheckChannelsWithUsernameOutput;
import ir.aaap.messengercore.model.api.CheckTwoStepPasscodeOutput;
import ir.aaap.messengercore.model.api.CheckUsernameInput;
import ir.aaap.messengercore.model.api.CheckUsernameOutput;
import ir.aaap.messengercore.model.api.DeleteAvatarInput;
import ir.aaap.messengercore.model.api.DeleteChatHistoryInput;
import ir.aaap.messengercore.model.api.DeleteChatOutput;
import ir.aaap.messengercore.model.api.DeleteContactInput;
import ir.aaap.messengercore.model.api.DeleteContactOutput;
import ir.aaap.messengercore.model.api.DeleteFolderInput;
import ir.aaap.messengercore.model.api.DeleteMessagesInput;
import ir.aaap.messengercore.model.api.DeleteMessagesOutput;
import ir.aaap.messengercore.model.api.DeleteServiceChatInput;
import ir.aaap.messengercore.model.api.DeleteUserChatInput;
import ir.aaap.messengercore.model.api.DisableTwoStepByForgetPasswordInput;
import ir.aaap.messengercore.model.api.DisableTwoStepByForgetPasswordOutput;
import ir.aaap.messengercore.model.api.EditChannelInput;
import ir.aaap.messengercore.model.api.EditGroupInfoInput;
import ir.aaap.messengercore.model.api.EditMessageInput;
import ir.aaap.messengercore.model.api.EditMessagesOutput;
import ir.aaap.messengercore.model.api.ForwardMessageInput;
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
import ir.aaap.messengercore.model.api.GetChannelSeenCountInput;
import ir.aaap.messengercore.model.api.GetChannelSeenCountOutput;
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
import ir.aaap.messengercore.model.api.GetMapViewInput;
import ir.aaap.messengercore.model.api.GetMapViewOutput;
import ir.aaap.messengercore.model.api.GetMessageShareUrlInput;
import ir.aaap.messengercore.model.api.GetMessageShareUrlOutput;
import ir.aaap.messengercore.model.api.GetMessagesByIdInput;
import ir.aaap.messengercore.model.api.GetMessagesByIdOutput;
import ir.aaap.messengercore.model.api.GetMessagesInput;
import ir.aaap.messengercore.model.api.GetMessagesIntervalOutput;
import ir.aaap.messengercore.model.api.GetMessagesOutput;
import ir.aaap.messengercore.model.api.GetMessagesUpdatesInput;
import ir.aaap.messengercore.model.api.GetMessagesUpdatesOutput;
import ir.aaap.messengercore.model.api.GetMyGifSetInput;
import ir.aaap.messengercore.model.api.GetMyGifSetOutput;
import ir.aaap.messengercore.model.api.GetMySessionsInput;
import ir.aaap.messengercore.model.api.GetMySessionsOutput;
import ir.aaap.messengercore.model.api.GetMyStickerSetsInput;
import ir.aaap.messengercore.model.api.GetObjectByUsernameInput;
import ir.aaap.messengercore.model.api.GetObjectByUsernameOutput;
import ir.aaap.messengercore.model.api.GetProfileLinkItemsInput;
import ir.aaap.messengercore.model.api.GetProfileLinkItemsOutputs;
import ir.aaap.messengercore.model.api.GetServiceInfoInput;
import ir.aaap.messengercore.model.api.GetServiceInfoOutput;
import ir.aaap.messengercore.model.api.GetStickerSetByIdInput;
import ir.aaap.messengercore.model.api.GetStickerSetByIdOutput;
import ir.aaap.messengercore.model.api.GetStickersByEmojiInput;
import ir.aaap.messengercore.model.api.GetStickersByEmojiOutput;
import ir.aaap.messengercore.model.api.GetStickersBySetIDsInput;
import ir.aaap.messengercore.model.api.GetStickersBySetIDsOutput;
import ir.aaap.messengercore.model.api.GetStickersInput;
import ir.aaap.messengercore.model.api.GetStickersOutput;
import ir.aaap.messengercore.model.api.GetSuggestedFoldersInput;
import ir.aaap.messengercore.model.api.GetSuggestedFoldersOutput;
import ir.aaap.messengercore.model.api.GetTimeInput;
import ir.aaap.messengercore.model.api.GetTimeOutput;
import ir.aaap.messengercore.model.api.GetTopChatUsersInput;
import ir.aaap.messengercore.model.api.GetTopChatUsersOutput;
import ir.aaap.messengercore.model.api.GetTwoPasscodeStatusInput;
import ir.aaap.messengercore.model.api.GetUpdateInput;
import ir.aaap.messengercore.model.api.GetUpdateOutput;
import ir.aaap.messengercore.model.api.GetUserInfoInput;
import ir.aaap.messengercore.model.api.GetUserInfoOutput;
import ir.aaap.messengercore.model.api.GetWalletTransactionMessageInput;
import ir.aaap.messengercore.model.api.GetWalletTransactionMessageOutput;
import ir.aaap.messengercore.model.api.GroupPreviewByJoinLinkInput;
import ir.aaap.messengercore.model.api.GroupPreviewByJoinLinkOutput;
import ir.aaap.messengercore.model.api.ImportAddressBookInput;
import ir.aaap.messengercore.model.api.ImportAddressBookOutput;
import ir.aaap.messengercore.model.api.JoinChannelActionInput;
import ir.aaap.messengercore.model.api.JoinChannelActionOutput;
import ir.aaap.messengercore.model.api.JoinChannelByLinkInput;
import ir.aaap.messengercore.model.api.JoinChannelByLinkOutput;
import ir.aaap.messengercore.model.api.JoinGroupInput;
import ir.aaap.messengercore.model.api.JoinGroupOutput;
import ir.aaap.messengercore.model.api.LeaveGroupInput;
import ir.aaap.messengercore.model.api.LeaveGroupOutput;
import ir.aaap.messengercore.model.api.LiveLocationInput;
import ir.aaap.messengercore.model.api.LiveLocationOutput;
import ir.aaap.messengercore.model.api.LoginDisableTwoStepInput;
import ir.aaap.messengercore.model.api.LoginDisableTwoStepOutput;
import ir.aaap.messengercore.model.api.LoginTwoStepForgetPasswordInput;
import ir.aaap.messengercore.model.api.LoginTwoStepForgetPasswordOutput;
import ir.aaap.messengercore.model.api.LogoutInput;
import ir.aaap.messengercore.model.api.LogoutOutput;
import ir.aaap.messengercore.model.api.PasswordInput;
import ir.aaap.messengercore.model.api.RegisterDeviceInput;
import ir.aaap.messengercore.model.api.RegisterDeviceOutput;
import ir.aaap.messengercore.model.api.RemoveChannelInput;
import ir.aaap.messengercore.model.api.RemoveFromMyGifSetInput;
import ir.aaap.messengercore.model.api.RemoveFromMyGifSetOutput;
import ir.aaap.messengercore.model.api.RemoveFromTopChatUsersInput;
import ir.aaap.messengercore.model.api.RemoveFromTopChatUsersOutput;
import ir.aaap.messengercore.model.api.RemoveGroupInput;
import ir.aaap.messengercore.model.api.RemoveGroupOrChannelOutput;
import ir.aaap.messengercore.model.api.ReorderFolderInput;
import ir.aaap.messengercore.model.api.ReorderStickerSetsInput;
import ir.aaap.messengercore.model.api.ReorderStickerSetsOutput;
import ir.aaap.messengercore.model.api.ReportObjectInput;
import ir.aaap.messengercore.model.api.ReportObjectOutput;
import ir.aaap.messengercore.model.api.RequestChangePhoneNumberInput;
import ir.aaap.messengercore.model.api.RequestChangePhoneNumberOutput;
import ir.aaap.messengercore.model.api.RequestDeleteAccountInput;
import ir.aaap.messengercore.model.api.RequestDeleteAccountOutput;
import ir.aaap.messengercore.model.api.RequestForgetPasswordInput;
import ir.aaap.messengercore.model.api.RequestForgetPasswordOutput;
import ir.aaap.messengercore.model.api.RequestRecoveryEmailInput;
import ir.aaap.messengercore.model.api.RequestSendFileInput;
import ir.aaap.messengercore.model.api.RequestSendFileOutput;
import ir.aaap.messengercore.model.api.ResendCodeRecoveryEmailOutput;
import ir.aaap.messengercore.model.api.ResetContactsInput;
import ir.aaap.messengercore.model.api.ResetContactsOutput;
import ir.aaap.messengercore.model.api.SearchChatMessagesInput;
import ir.aaap.messengercore.model.api.SearchChatMessagesOutput;
import ir.aaap.messengercore.model.api.SearchGlobalMessagesInput;
import ir.aaap.messengercore.model.api.SearchGlobalMessagesOutput;
import ir.aaap.messengercore.model.api.SearchGlobalObjectsInput;
import ir.aaap.messengercore.model.api.SearchGlobalObjectsOutput;
import ir.aaap.messengercore.model.api.SeenChannelMessagesInput;
import ir.aaap.messengercore.model.api.SeenChannelMessagesOutput;
import ir.aaap.messengercore.model.api.SeenChatsInput;
import ir.aaap.messengercore.model.api.SeenChatsOutput;
import ir.aaap.messengercore.model.api.SendCodeInput;
import ir.aaap.messengercore.model.api.SendCodeOutput;
import ir.aaap.messengercore.model.api.SendFileInput;
import ir.aaap.messengercore.model.api.SendFileOutput;
import ir.aaap.messengercore.model.api.SendMessageInput;
import ir.aaap.messengercore.model.api.SendMessageOutput;
import ir.aaap.messengercore.model.api.SendProductMessageInput;
import ir.aaap.messengercore.model.api.SendRubinoPostInput;
import ir.aaap.messengercore.model.api.SendRubinoStoryInput;
import ir.aaap.messengercore.model.api.SendWalletTransactionMessageInput;
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
import ir.aaap.messengercore.model.api.SetChatUseTimeInput;
import ir.aaap.messengercore.model.api.SetChatUseTimeOutput;
import ir.aaap.messengercore.model.api.SetCurrentLiveLocationInput;
import ir.aaap.messengercore.model.api.SetCurrentLiveLocationOutput;
import ir.aaap.messengercore.model.api.SetGroupAdminInput;
import ir.aaap.messengercore.model.api.SetGroupAdminOutput;
import ir.aaap.messengercore.model.api.SetGroupDefaultAccessInput;
import ir.aaap.messengercore.model.api.SetGroupDefaultAccessOutput;
import ir.aaap.messengercore.model.api.SetGroupLinkInput;
import ir.aaap.messengercore.model.api.SetGroupLinkOutput;
import ir.aaap.messengercore.model.api.SetPinChatInFolderInput;
import ir.aaap.messengercore.model.api.SetPinMessageInput;
import ir.aaap.messengercore.model.api.SetPinMessageOutput;
import ir.aaap.messengercore.model.api.SetPublicKeyInput;
import ir.aaap.messengercore.model.api.SetPublicKeyOutput;
import ir.aaap.messengercore.model.api.SetupTwoStepVerificationInput;
import ir.aaap.messengercore.model.api.SignInInput;
import ir.aaap.messengercore.model.api.SignInOutput;
import ir.aaap.messengercore.model.api.TerminateOtherSessionInput;
import ir.aaap.messengercore.model.api.TerminateOtherSessionOutput;
import ir.aaap.messengercore.model.api.TerminateSessionInput;
import ir.aaap.messengercore.model.api.TerminateSessionOutput;
import ir.aaap.messengercore.model.api.TurnOffTwoStepInput;
import ir.aaap.messengercore.model.api.TurnOffTwoStepOutput;
import ir.aaap.messengercore.model.api.TwoPasscodeStatusOutput;
import ir.aaap.messengercore.model.api.UpdateChannelUsernameInput;
import ir.aaap.messengercore.model.api.UpdateChannelUsernameOutput;
import ir.aaap.messengercore.model.api.UpdateProfileInput;
import ir.aaap.messengercore.model.api.UpdateProfileOutput;
import ir.aaap.messengercore.model.api.UpdateUserUsernameOutput;
import ir.aaap.messengercore.model.api.UpdateUsernameInput;
import ir.aaap.messengercore.model.api.UploadAvatarInput;
import ir.aaap.messengercore.model.api.UploadOrDeleteAvatarOutput;
import ir.aaap.messengercore.model.api.VerifyChangePhoneNumberInput;
import ir.aaap.messengercore.model.api.VerifyChangePhoneNumberOutput;
import ir.aaap.messengercore.model.api.VerifyRecoveryEmailInput;
import ir.aaap.messengercore.model.api.VerifyRecoveryEmailOutput;
import ir.aaap.messengercore.network.Network;
import ir.aaap.messengercore.network.NetworkHelper;
import ir.aaap.messengercore.utilites.CoreLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class NetworkHelperImpl implements NetworkHelper {
    private CoreLog coreLog;
    private final JsonHelper jsonHelper;
    private final Network network;
    private String messengerUrl = BuildConfig.FLAVOR;
    private NetworkHelper.VersionEncryptionHelper versionHelper = this.versionHelper;
    private NetworkHelper.VersionEncryptionHelper versionHelper = this.versionHelper;

    public NetworkHelperImpl(Network network, JsonHelper jsonHelper, CoreLog coreLog) {
        this.network = network;
        this.coreLog = coreLog;
        this.jsonHelper = jsonHelper;
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public void init(String str) {
        this.messengerUrl = str;
        this.network.init(str);
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public void setVersionEncryptionHelper(NetworkHelper.VersionEncryptionHelper versionEncryptionHelper) {
        this.versionHelper = versionEncryptionHelper;
        this.network.setVersionHelper(versionEncryptionHelper);
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public String getDefaultMessengerUrl() {
        return this.network.getDefaultMessengerUrl();
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public String getDefaultDcMessUrl() {
        return this.network.getDefaultDcMessUrl();
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public String getDefaultSocketUrl() {
        return this.network.getDefaultSocketUrl();
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public void setNetworkErrorListener(Network.NetworkErrorListener networkErrorListener) {
        Network network = this.network;
        if (network != null) {
            network.setNetworkErrorListener(networkErrorListener);
        }
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int sendChatActivity(String str, SendChatActivityInput sendChatActivityInput, RetryObject retryObject, NetworkHelper.ResponseListener<SendChatActivityOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "sendChatActivity", toJson(sendChatActivityInput), retryObject, getListenerV5(responseListener, SendChatActivityOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getUpdate(String str, GetUpdateInput getUpdateInput, RetryObject retryObject, NetworkHelper.ResponseListener<GetUpdateOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getUpdate", toJson(getUpdateInput), retryObject, getListenerV5(responseListener, GetUpdateOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int setPublicKey(String str, SetPublicKeyInput setPublicKeyInput, RetryObject retryObject, NetworkHelper.ResponseListener<SetPublicKeyOutput> responseListener) throws Exception {
        return this.network.sendV5(str, "setPublicKey", toJson(setPublicKeyInput), retryObject, getListenerV5(responseListener, SetPublicKeyOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int sendLive(String str, LiveModels.SendLiveInput sendLiveInput, RetryObject retryObject, NetworkHelper.ResponseListener<LiveModels.SendLiveOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "sendLive", toJson(sendLiveInput), retryObject, getListenerV5(responseListener, LiveModels.SendLiveOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int stopLive(String str, LiveModels.StopLiveInput stopLiveInput, RetryObject retryObject, NetworkHelper.ResponseListener<LiveModels.StopLiveOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "stopLive", toJson(stopLiveInput), retryObject, getListenerV5(responseListener, LiveModels.StopLiveOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getLivePlayUrl(String str, LiveModels.GetLivePlayUrlInput getLivePlayUrlInput, RetryObject retryObject, NetworkHelper.ResponseListener<LiveModels.GetLivePlayUrlOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getLivePlayUrl", toJson(getLivePlayUrlInput), retryObject, getListenerV5(responseListener, LiveModels.GetLivePlayUrlOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getLiveStatus(String str, LiveModels.GetLiveStatusInput getLiveStatusInput, RetryObject retryObject, NetworkHelper.ResponseListener<LiveModels.GetLiveStatusOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getLiveStatus", toJson(getLiveStatusInput), retryObject, getListenerV5(responseListener, LiveModels.GetLiveStatusOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int addLiveComment(String str, LiveModels.AddLiveCommentInput addLiveCommentInput, RetryObject retryObject, NetworkHelper.ResponseListener<LiveModels.AddLiveCommentOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "addLiveComment", toJson(addLiveCommentInput), retryObject, getListenerV5(responseListener, LiveModels.AddLiveCommentOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getLiveComments(String str, LiveModels.GetLiveCommentsInput getLiveCommentsInput, RetryObject retryObject, NetworkHelper.ResponseListener<LiveModels.GetLiveCommentsOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getLiveComments", toJson(getLiveCommentsInput), retryObject, getListenerV5(responseListener, LiveModels.GetLiveCommentsOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int setLiveSetting(String str, LiveModels.SetLiveSettingInput setLiveSettingInput, RetryObject retryObject, NetworkHelper.ResponseListener<LiveModels.SetLiveSettingOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "setLiveSetting", toJson(setLiveSettingInput), retryObject, getListenerV5(responseListener, LiveModels.SetLiveSettingOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getLiveViewers(String str, LiveModels.GetLiveViewersInput getLiveViewersInput, RetryObject retryObject, NetworkHelper.ResponseListener<LiveModels.GetLiveViewersOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getLiveViewers", toJson(getLiveViewersInput), retryObject, getListenerV5(responseListener, LiveModels.GetLiveViewersOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int setSetting(String str, SettingModels.SetSettingInput setSettingInput, RetryObject retryObject, NetworkHelper.ResponseListener<SettingModels.SetSettingOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "setSetting", toJson(setSettingInput), retryObject, getListenerV5(responseListener, SettingModels.SetSettingOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getPrivacySetting(String str, SettingModels.SettingInput settingInput, RetryObject retryObject, NetworkHelper.ResponseListener<SettingModels.GetPrivacySettingOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getPrivacySetting", toJson(settingInput), retryObject, getListenerV5(responseListener, SettingModels.GetPrivacySettingOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getUserSetting(String str, SettingModels.SettingInput settingInput, RetryObject retryObject, NetworkHelper.ResponseListener<SettingModels.GetUserSettingOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getUserSetting", toJson(settingInput), retryObject, getListenerV5(responseListener, SettingModels.GetUserSettingOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getDeviceSetting(String str, SettingModels.SettingInput settingInput, RetryObject retryObject, NetworkHelper.ResponseListener<SettingModels.GetDeviceSettingOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getDeviceSetting", toJson(settingInput), retryObject, getListenerV5(responseListener, SettingModels.GetDeviceSettingOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getWallpapers(String str, SettingModels.SettingInput settingInput, RetryObject retryObject, NetworkHelper.ResponseListener<SettingModels.WallpapersOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getWallpapers", toJson(settingInput), retryObject, getListenerV5(responseListener, SettingModels.WallpapersOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getThemes(String str, SettingModels.SettingInput settingInput, RetryObject retryObject, NetworkHelper.ResponseListener<SettingModels.GetThemesOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getThemes", toJson(settingInput), retryObject, getListenerV5(responseListener, SettingModels.GetThemesOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int addWallpaperSetThemeBackground(String str, SettingModels.AddWallpaperSetThemeBackgroundInput addWallpaperSetThemeBackgroundInput, RetryObject retryObject, NetworkHelper.ResponseListener<SettingModels.AddWallpaperSetThemeBackgroundOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "addWallpaperSetThemeBackground", toJson(addWallpaperSetThemeBackgroundInput), retryObject, getListenerV5(responseListener, SettingModels.AddWallpaperSetThemeBackgroundOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int resetWallpapers(String str, SettingModels.SettingInput settingInput, RetryObject retryObject, NetworkHelper.ResponseListener<SettingModels.WallpapersOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "resetWallpapers", toJson(settingInput), retryObject, getListenerV5(responseListener, SettingModels.WallpapersOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getStickerSetting(String str, SettingModels.SettingInput settingInput, RetryObject retryObject, NetworkHelper.ResponseListener<SettingModels.GetStickersSettingOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getStickerSetting", toJson(settingInput), retryObject, getListenerV5(responseListener, SettingModels.GetStickersSettingOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getAvailableReactions(String str, SettingModels.GetAvailableReactionsInput getAvailableReactionsInput, RetryObject retryObject, NetworkHelper.ResponseListener<SettingModels.GetAvailableReactionsOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getAvailableReactions", toJson(getAvailableReactionsInput), retryObject, getListenerV5(responseListener, SettingModels.GetAvailableReactionsOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getMessageReactions(String str, SettingModels.GetMessageReactionsInput getMessageReactionsInput, RetryObject retryObject, NetworkHelper.ResponseListener<SettingModels.GetMessageReactionsOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getMessageReactions", toJson(getMessageReactionsInput), retryObject, getListenerV5(responseListener, SettingModels.GetMessageReactionsOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int actionOnMessageReaction(String str, SettingModels.ActionOnMessageReactionInput actionOnMessageReactionInput, RetryObject retryObject, NetworkHelper.ResponseListener<SettingModels.ActionOnMessageReactionOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "actionOnMessageReaction", toJson(actionOnMessageReactionInput), retryObject, getListenerV5(responseListener, SettingModels.ActionOnMessageReactionOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getChatReaction(String str, SettingModels.GetChatReactionInput getChatReactionInput, RetryObject retryObject, NetworkHelper.ResponseListener<SettingModels.GetChatReactionOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getChatReaction", toJson(getChatReactionInput), retryObject, getListenerV5(responseListener, SettingModels.GetChatReactionOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int searchGlobalObjects(String str, SearchGlobalObjectsInput searchGlobalObjectsInput, RetryObject retryObject, NetworkHelper.ResponseListener<SearchGlobalObjectsOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "searchGlobalObjects", toJson(searchGlobalObjectsInput), retryObject, getListenerV5(responseListener, SearchGlobalObjectsOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int searchGlobalMessages(String str, SearchGlobalMessagesInput searchGlobalMessagesInput, RetryObject retryObject, NetworkHelper.ResponseListener<SearchGlobalMessagesOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "searchGlobalMessages", toJson(searchGlobalMessagesInput), retryObject, getListenerV5(responseListener, SearchGlobalMessagesOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int searchChatMessages(String str, SearchChatMessagesInput searchChatMessagesInput, RetryObject retryObject, NetworkHelper.ResponseListener<SearchChatMessagesOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "searchChatMessages", toJson(searchChatMessagesInput), retryObject, getListenerV5(responseListener, SearchChatMessagesOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int searchStickers(String str, GetStickersInput getStickersInput, RetryObject retryObject, NetworkHelper.ResponseListener<GetStickersOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "searchStickers", toJson(getStickersInput), retryObject, getListenerV5(responseListener, GetStickersOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int createPoll(String str, PollModels.CreatePollInput createPollInput, RetryObject retryObject, NetworkHelper.ResponseListener<SendMessageOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "createPoll", toJson(createPollInput), retryObject, getListenerV5(responseListener, SendMessageOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getPollStatus(String str, PollModels.GetPollStatusInput getPollStatusInput, RetryObject retryObject, NetworkHelper.ResponseListener<PollModels.PollOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getPollStatus", toJson(getPollStatusInput), retryObject, getListenerV5(responseListener, PollModels.PollOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int setPollAction(String str, PollModels.SetPollActionInput setPollActionInput, RetryObject retryObject, NetworkHelper.ResponseListener<PollModels.PollOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "setPollAction", toJson(setPollActionInput), retryObject, getListenerV5(responseListener, PollModels.PollOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int votePoll(String str, PollModels.VotePollInput votePollInput, RetryObject retryObject, NetworkHelper.ResponseListener<PollModels.PollOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "votePoll", toJson(votePollInput), retryObject, getListenerV5(responseListener, PollModels.PollOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getPollOptionVoters(String str, PollModels.GetPollOptionVotersInput getPollOptionVotersInput, RetryObject retryObject, NetworkHelper.ResponseListener<PollModels.GetPollOptionVotersOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getPollOptionVoters", toJson(getPollOptionVotersInput), retryObject, getListenerV5(responseListener, PollModels.GetPollOptionVotersOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getGroupVoiceChat(String str, GroupCallModels.GetGroupVoiceChatInput getGroupVoiceChatInput, RetryObject retryObject, NetworkHelper.ResponseListener<GroupCallModels.GetGroupVoiceChatOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getGroupVoiceChat", toJson(getGroupVoiceChatInput), retryObject, getListenerV5(responseListener, GroupCallModels.GetGroupVoiceChatOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int createGroupVoiceChat(String str, GroupCallModels.CreateGroupVoiceChatInput createGroupVoiceChatInput, RetryObject retryObject, NetworkHelper.ResponseListener<GroupCallModels.CreateGroupVoiceChatOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "createGroupVoiceChat", toJson(createGroupVoiceChatInput), retryObject, getListenerV5(responseListener, GroupCallModels.CreateGroupVoiceChatOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int joinGroupVoiceChat(String str, GroupCallModels.JoinGroupVoiceChatInput joinGroupVoiceChatInput, RetryObject retryObject, NetworkHelper.ResponseListener<GroupCallModels.JoinGroupVoiceChatOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "joinGroupVoiceChat", toJson(joinGroupVoiceChatInput), retryObject, getListenerV5(responseListener, GroupCallModels.JoinGroupVoiceChatOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getGroupVoiceChatParticipants(String str, GroupCallModels.GetGroupVoiceChatParticipantsInput getGroupVoiceChatParticipantsInput, RetryObject retryObject, NetworkHelper.ResponseListener<GroupCallModels.GetGroupVoiceChatParticipantsOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getGroupVoiceChatParticipants", toJson(getGroupVoiceChatParticipantsInput), retryObject, getListenerV5(responseListener, GroupCallModels.GetGroupVoiceChatParticipantsOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int setGroupVoiceChatState(String str, GroupCallModels.SetGroupVoiceChatStateInput setGroupVoiceChatStateInput, RetryObject retryObject, NetworkHelper.ResponseListener<GroupCallModels.SetGroupVoiceChatStateOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "setGroupVoiceChatState", toJson(setGroupVoiceChatStateInput), retryObject, getListenerV5(responseListener, GroupCallModels.SetGroupVoiceChatStateOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int leaveGroupVoiceChat(String str, GroupCallModels.LeaveGroupVoiceChatInput leaveGroupVoiceChatInput, RetryObject retryObject, NetworkHelper.ResponseListener<GroupCallModels.LeaveGroupVoiceChatOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "leaveGroupVoiceChat", toJson(leaveGroupVoiceChatInput), retryObject, getListenerV5(responseListener, GroupCallModels.LeaveGroupVoiceChatOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int discardGroupVoiceChat(String str, GroupCallModels.DiscardGroupVoiceChatInput discardGroupVoiceChatInput, RetryObject retryObject, NetworkHelper.ResponseListener<GroupCallModels.DiscardGroupVoiceChatOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "discardGroupVoiceChat", toJson(discardGroupVoiceChatInput), retryObject, getListenerV5(responseListener, GroupCallModels.DiscardGroupVoiceChatOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int setGroupVoiceChatSetting(String str, GroupCallModels.SetGroupVoiceChatSettingInput setGroupVoiceChatSettingInput, RetryObject retryObject, NetworkHelper.ResponseListener<GroupCallModels.SetGroupVoiceChatSettingOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "setGroupVoiceChatSetting", toJson(setGroupVoiceChatSettingInput), retryObject, getListenerV5(responseListener, GroupCallModels.SetGroupVoiceChatSettingOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int sendGroupVoiceChatActivity(String str, GroupCallModels.SendGroupVoiceChatActivityInput sendGroupVoiceChatActivityInput, RetryObject retryObject, NetworkHelper.ResponseListener<GroupCallModels.SendGroupVoiceChatActivityOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "sendGroupVoiceChatActivity", toJson(sendGroupVoiceChatActivityInput), retryObject, getListenerV5(responseListener, GroupCallModels.SendGroupVoiceChatActivityOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getGroupVoiceChatUpdates(String str, GroupCallModels.GetGroupVoiceChatUpdatesInput getGroupVoiceChatUpdatesInput, RetryObject retryObject, NetworkHelper.ResponseListener<GroupCallModels.GetGroupVoiceChatUpdatesOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getGroupVoiceChatUpdates", toJson(getGroupVoiceChatUpdatesInput), retryObject, getListenerV5(responseListener, GroupCallModels.GetGroupVoiceChatUpdatesOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getGroupVoiceChatParticipantsByObjectGuids(String str, GroupCallModels.GetGroupVoiceChatParticipantsByObjectGuidsInput getGroupVoiceChatParticipantsByObjectGuidsInput, RetryObject retryObject, NetworkHelper.ResponseListener<GroupCallModels.GetGroupVoiceChatParticipantsByObjectGuidsOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getGroupVoiceChatParticipantsByObjectGuids", toJson(getGroupVoiceChatParticipantsByObjectGuidsInput), retryObject, getListenerV5(responseListener, GroupCallModels.GetGroupVoiceChatParticipantsByObjectGuidsOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getDisplayAsInGroupVoiceChat(String str, GroupCallModels.GetDisplayAsInGroupVoiceChatInput getDisplayAsInGroupVoiceChatInput, RetryObject retryObject, NetworkHelper.ResponseListener<GroupCallModels.GetDisplayAsInGroupVoiceChatOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getDisplayAsInGroupVoiceChat", toJson(getDisplayAsInGroupVoiceChatInput), retryObject, getListenerV5(responseListener, GroupCallModels.GetDisplayAsInGroupVoiceChatOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int setAskSpamAction(String str, SetAskSpamActionInput setAskSpamActionInput, RetryObject retryObject, NetworkHelper.ResponseListener<SetAskSpamActionOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "setAskSpamAction", toJson(setAskSpamActionInput), retryObject, getListenerV5(responseListener, SetAskSpamActionOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int requestCall(String str, VoiceCallModels.RequestCallInput requestCallInput, RetryObject retryObject, NetworkHelper.ResponseListener<VoiceCallModels.RequestCallOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "requestCall", toJson(requestCallInput), retryObject, getListenerV5(responseListener, VoiceCallModels.RequestCallOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int receivedCall(String str, VoiceCallModels.ReceivedCallInput receivedCallInput, RetryObject retryObject, NetworkHelper.ResponseListener<VoiceCallModels.ReceivedCallOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "receivedCall", toJson(receivedCallInput), retryObject, getListenerV5(responseListener, VoiceCallModels.ReceivedCallOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int acceptCall(String str, VoiceCallModels.AcceptCallInput acceptCallInput, RetryObject retryObject, NetworkHelper.ResponseListener<VoiceCallModels.AcceptCallOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "acceptCall", toJson(acceptCallInput), retryObject, getListenerV5(responseListener, VoiceCallModels.AcceptCallOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int discardCall(String str, VoiceCallModels.DiscardCallInput discardCallInput, RetryObject retryObject, NetworkHelper.ResponseListener<VoiceCallModels.DiscardCallOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "discardCall", toJson(discardCallInput), retryObject, getListenerV5(responseListener, VoiceCallModels.DiscardCallOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int rateCall(String str, VoiceCallModels.RateCallInput rateCallInput, RetryObject retryObject, NetworkHelper.ResponseListener<VoiceCallModels.RateCallOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "rateCall", toJson(rateCallInput), retryObject, getListenerV5(responseListener, VoiceCallModels.RateCallOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int sendSignalingData(String str, VoiceCallModels.SendSignalDataInput sendSignalDataInput, RetryObject retryObject, NetworkHelper.ResponseListener<VoiceCallModels.SendSignalDataOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "sendSignalingData", toJson(sendSignalDataInput), retryObject, getListenerV5(responseListener, VoiceCallModels.SendSignalDataOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getCalls(String str, VoiceCallModels.GetCallsInput getCallsInput, RetryObject retryObject, NetworkHelper.ResponseListener<VoiceCallModels.GetCallsOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getCalls", toJson(getCallsInput), retryObject, getListenerV5(responseListener, VoiceCallModels.GetCallsOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getSignalingData(String str, VoiceCallModels.GetSignalingDataInput getSignalingDataInput, RetryObject retryObject, NetworkHelper.ResponseListener<VoiceCallModels.GetSignalingDataOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getSignalingData", toJson(getSignalingDataInput), retryObject, getListenerV5(responseListener, VoiceCallModels.GetSignalingDataOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int callStarted(String str, VoiceCallModels.CallStartedInput callStartedInput, RetryObject retryObject, NetworkHelper.ResponseListener<VoiceCallModels.CallStartedOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "callStarted", toJson(callStartedInput), retryObject, getListenerV5(responseListener, VoiceCallModels.CallStartedOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int reorderFolder(String str, ReorderFolderInput reorderFolderInput, RetryObject retryObject, NetworkHelper.ResponseListener<ChangeFolderOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "reorderFolder", toJson(reorderFolderInput), retryObject, getListenerV5(responseListener, ChangeFolderOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int deleteFolder(String str, DeleteFolderInput deleteFolderInput, RetryObject retryObject, NetworkHelper.ResponseListener<ChangeFolderOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "deleteFolder", toJson(deleteFolderInput), retryObject, getListenerV5(responseListener, ChangeFolderOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int editFolder(String str, AddOrEditFolderInput addOrEditFolderInput, RetryObject retryObject, NetworkHelper.ResponseListener<ChangeFolderOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "editFolder", toJson(addOrEditFolderInput), retryObject, getListenerV5(responseListener, ChangeFolderOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int addFolder(String str, AddOrEditFolderInput addOrEditFolderInput, RetryObject retryObject, NetworkHelper.ResponseListener<ChangeFolderOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "addFolder", toJson(addOrEditFolderInput), retryObject, getListenerV5(responseListener, ChangeFolderOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getSuggestedFolders(String str, GetSuggestedFoldersInput getSuggestedFoldersInput, RetryObject retryObject, NetworkHelper.ResponseListener<GetSuggestedFoldersOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getSuggestedFolders", toJson(getSuggestedFoldersInput), retryObject, getListenerV5(responseListener, GetSuggestedFoldersOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int setPinChatInFolder(String str, SetPinChatInFolderInput setPinChatInFolderInput, RetryObject retryObject, NetworkHelper.ResponseListener<ChangeFolderOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "setPinChatInFolder", toJson(setPinChatInFolderInput), retryObject, getListenerV5(responseListener, ChangeFolderOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getFolders(String str, GetFoldersInput getFoldersInput, RetryObject retryObject, NetworkHelper.ResponseListener<GetFoldersOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getFolders", toJson(getFoldersInput), retryObject, getListenerV5(responseListener, GetFoldersOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int uploadAvatar(String str, UploadAvatarInput uploadAvatarInput, RetryObject retryObject, NetworkHelper.ResponseListener<UploadOrDeleteAvatarOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "uploadAvatar", toJson(uploadAvatarInput), retryObject, getListenerV5(responseListener, UploadOrDeleteAvatarOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int deleteAvatar(String str, DeleteAvatarInput deleteAvatarInput, RetryObject retryObject, NetworkHelper.ResponseListener<UploadOrDeleteAvatarOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "deleteAvatar", toJson(deleteAvatarInput), retryObject, getListenerV5(responseListener, UploadOrDeleteAvatarOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public void seenChats(String str, SeenChatsInput seenChatsInput, RetryObject retryObject, NetworkHelper.ResponseListener<SeenChatsOutput> responseListener) throws Exception {
        this.network.sendV5OrV6(str, "seenChats", toJson(seenChatsInput), retryObject, getListenerV5(responseListener, SeenChatsOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int editMessage(String str, EditMessageInput editMessageInput, RetryObject retryObject, NetworkHelper.ResponseListener<EditMessagesOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "editMessage", toJson(editMessageInput), retryObject, getListenerV5(responseListener, EditMessagesOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int deleteMessages(String str, DeleteMessagesInput deleteMessagesInput, RetryObject retryObject, NetworkHelper.ResponseListener<DeleteMessagesOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "deleteMessages", toJson(deleteMessagesInput), retryObject, getListenerV5(responseListener, DeleteMessagesOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int setPinMessage(String str, SetPinMessageInput setPinMessageInput, RetryObject retryObject, NetworkHelper.ResponseListener<SetPinMessageOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "setPinMessage", toJson(setPinMessageInput), retryObject, getListenerV5(responseListener, SetPinMessageOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getMessagesByID(String str, GetMessagesByIdInput getMessagesByIdInput, RetryObject retryObject, NetworkHelper.ResponseListener<GetMessagesByIdOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getMessagesByID", toJson(getMessagesByIdInput), retryObject, getListenerV5(responseListener, GetMessagesByIdOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int forwardMessages(String str, ForwardMessageInput forwardMessageInput, RetryObject retryObject, NetworkHelper.ResponseListener<SendMessageOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "forwardMessages", toJson(forwardMessageInput), retryObject, getListenerV5(responseListener, SendMessageOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int sendMessage(String str, SendMessageInput sendMessageInput, RetryObject retryObject, NetworkHelper.ResponseListener<SendMessageOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "sendMessage", toJson(sendMessageInput), retryObject, getListenerV5(responseListener, SendMessageOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int sendRubinoPost(String str, SendRubinoPostInput sendRubinoPostInput, RetryObject retryObject, NetworkHelper.ResponseListener<SendMessageOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "sendRubinoPost", toJson(sendRubinoPostInput), retryObject, getListenerV5(responseListener, SendMessageOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int sendRubinoStory(String str, SendRubinoStoryInput sendRubinoStoryInput, RetryObject retryObject, NetworkHelper.ResponseListener<SendMessageOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "sendRubinoStory", toJson(sendRubinoStoryInput), retryObject, getListenerV5(responseListener, SendMessageOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int checkRubinoUsername(String str, CheckUsernameInput checkUsernameInput, RetryObject retryObject, NetworkHelper.ResponseListener<CheckUsernameOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "checkRubinoUsername", toJson(checkUsernameInput), retryObject, getListenerV5(responseListener, CheckUsernameOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int sendProductMessage(String str, SendProductMessageInput sendProductMessageInput, RetryObject retryObject, NetworkHelper.ResponseListener<SendMessageOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "sendProductMessage", toJson(sendProductMessageInput), retryObject, getListenerV5(responseListener, SendMessageOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public void getMessages(String str, GetMessagesInput getMessagesInput, RetryObject retryObject, NetworkHelper.ResponseListener<GetMessagesOutput> responseListener) throws Exception {
        this.network.sendV5OrV6(str, "getMessages", toJson(getMessagesInput), retryObject, getListenerV5(responseListener, GetMessagesOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getStickerSetByID(String str, GetStickerSetByIdInput getStickerSetByIdInput, RetryObject retryObject, NetworkHelper.ResponseListener<GetStickerSetByIdOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getStickerSetByID", toJson(getStickerSetByIdInput), retryObject, getListenerV5(responseListener, GetStickerSetByIdOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getStickersBySetIDs(String str, GetStickersBySetIDsInput getStickersBySetIDsInput, RetryObject retryObject, NetworkHelper.ResponseListener<GetStickersBySetIDsOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getStickersBySetIDs", toJson(getStickersBySetIDsInput), retryObject, getListenerV5(responseListener, GetStickersBySetIDsOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int actionOnStickerSet(String str, ActionOnStickersInput actionOnStickersInput, RetryObject retryObject, NetworkHelper.ResponseListener<ActionOnStickersOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "actionOnStickerSet", toJson(actionOnStickersInput), retryObject, getListenerV5(responseListener, ActionOnStickersOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getMyStickerSets(String str, GetMyStickerSetsInput getMyStickerSetsInput, RetryObject retryObject, NetworkHelper.ResponseListener<GetStickersOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getMyStickerSets", toJson(getMyStickerSetsInput), retryObject, getListenerV5(responseListener, GetStickersOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getTrendStickerSets(String str, GetStickersInput getStickersInput, RetryObject retryObject, NetworkHelper.ResponseListener<GetStickersOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getTrendStickerSets", toJson(getStickersInput), retryObject, getListenerV5(responseListener, GetStickersOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getMyArchivedStickerSets(String str, GetStickersInput getStickersInput, RetryObject retryObject, NetworkHelper.ResponseListener<GetStickersOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getMyArchivedStickerSets", toJson(getStickersInput), retryObject, getListenerV5(responseListener, GetStickersOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getStickersByEmoji(String str, GetStickersByEmojiInput getStickersByEmojiInput, RetryObject retryObject, NetworkHelper.ResponseListener<GetStickersByEmojiOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getStickersByEmoji", toJson(getStickersByEmojiInput), retryObject, getListenerV5(responseListener, GetStickersByEmojiOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int reorderStickerSets(String str, ReorderStickerSetsInput reorderStickerSetsInput, RetryObject retryObject, NetworkHelper.ResponseListener<ReorderStickerSetsOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "reorderStickerSets", toJson(reorderStickerSetsInput), retryObject, getListenerV5(responseListener, ReorderStickerSetsOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int addToMyGifSet(String str, AddToMyGifSetInput addToMyGifSetInput, RetryObject retryObject, NetworkHelper.ResponseListener<AddToMyGifSetOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "addToMyGifSet", toJson(addToMyGifSetInput), retryObject, getListenerV5(responseListener, AddToMyGifSetOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int removeFromMyGifSet(String str, RemoveFromMyGifSetInput removeFromMyGifSetInput, RetryObject retryObject, NetworkHelper.ResponseListener<RemoveFromMyGifSetOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "removeFromMyGifSet", toJson(removeFromMyGifSetInput), retryObject, getListenerV5(responseListener, RemoveFromMyGifSetOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getMyGifSet(String str, GetMyGifSetInput getMyGifSetInput, RetryObject retryObject, NetworkHelper.ResponseListener<GetMyGifSetOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getMyGifSet", toJson(getMyGifSetInput), retryObject, getListenerV5(responseListener, GetMyGifSetOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int setChannelBotAdmin(String str, SetChannelBotAdminInput setChannelBotAdminInput, RetryObject retryObject, NetworkHelper.ResponseListener<SetChannelBotAdminOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "setChannelBotAdmin", toJson(setChannelBotAdminInput), retryObject, getListenerV5(responseListener, SetChannelBotAdminOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int addChannel(String str, AddChannelInput addChannelInput, RetryObject retryObject, NetworkHelper.ResponseListener<AddOrEditChannelOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "addChannel", toJson(addChannelInput), retryObject, getListenerV5(responseListener, AddOrEditChannelOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int addGroup(String str, AddGroupInput addGroupInput, RetryObject retryObject, NetworkHelper.ResponseListener<AddOrEditGroupOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "addGroup", toJson(addGroupInput), retryObject, getListenerV5(responseListener, AddOrEditGroupOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getObjectByUsername(String str, GetObjectByUsernameInput getObjectByUsernameInput, RetryObject retryObject, NetworkHelper.ResponseListener<GetObjectByUsernameOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getObjectInfoByUsername", toJson(getObjectByUsernameInput), retryObject, getListenerV5(responseListener, GetObjectByUsernameOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getProfileLinkItems(String str, GetProfileLinkItemsInput getProfileLinkItemsInput, RetryObject retryObject, NetworkHelper.ResponseListener<GetProfileLinkItemsOutputs> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getProfileLinkItems", toJson(getProfileLinkItemsInput), retryObject, getListenerV5(responseListener, GetProfileLinkItemsOutputs.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int groupPreviewByJoinLink(String str, GroupPreviewByJoinLinkInput groupPreviewByJoinLinkInput, RetryObject retryObject, NetworkHelper.ResponseListener<GroupPreviewByJoinLinkOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "groupPreviewByJoinLink", toJson(groupPreviewByJoinLinkInput), retryObject, getListenerV5(responseListener, GroupPreviewByJoinLinkOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int checkChannelsWithUsername(String str, CheckChannelsWithUsernameInput checkChannelsWithUsernameInput, RetryObject retryObject, NetworkHelper.ResponseListener<CheckChannelsWithUsernameOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "checkChannelsWithUsername", toJson(checkChannelsWithUsernameInput), retryObject, getListenerV5(responseListener, CheckChannelsWithUsernameOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getAllStatistics(String str, GetAllStatisticsInput getAllStatisticsInput, RetryObject retryObject, NetworkHelper.ResponseListener<GetAllStatisticsOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getAllStatistics", toJson(getAllStatisticsInput), retryObject, getListenerV5(responseListener, GetAllStatisticsOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int channelPreviewByJoinLink(String str, ChannelPreviewByJoinLinkInput channelPreviewByJoinLinkInput, RetryObject retryObject, NetworkHelper.ResponseListener<ChannelPreviewByJoinLinkOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "channelPreviewByJoinLink", toJson(channelPreviewByJoinLinkInput), retryObject, getListenerV5(responseListener, ChannelPreviewByJoinLinkOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int updateProfile(String str, UpdateProfileInput updateProfileInput, RetryObject retryObject, NetworkHelper.ResponseListener<UpdateProfileOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "updateProfile", toJson(updateProfileInput), retryObject, getListenerV5(responseListener, UpdateProfileOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int checkUserUsername(String str, CheckUsernameInput checkUsernameInput, RetryObject retryObject, NetworkHelper.ResponseListener<CheckUsernameOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "checkUserUsername", toJson(checkUsernameInput), retryObject, getListenerV5(responseListener, CheckUsernameOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int checkChannelUsername(String str, CheckUsernameInput checkUsernameInput, RetryObject retryObject, NetworkHelper.ResponseListener<CheckUsernameOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "checkChannelUsername", toJson(checkUsernameInput), retryObject, getListenerV5(responseListener, CheckUsernameOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int updateUserUsername(String str, UpdateUsernameInput updateUsernameInput, RetryObject retryObject, NetworkHelper.ResponseListener<UpdateUserUsernameOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "updateUsername", toJson(updateUsernameInput), retryObject, getListenerV5(responseListener, UpdateUserUsernameOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int updateChannelUsername(String str, UpdateChannelUsernameInput updateChannelUsernameInput, RetryObject retryObject, NetworkHelper.ResponseListener<UpdateChannelUsernameOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "updateChannelUsername", toJson(updateChannelUsernameInput), retryObject, getListenerV5(responseListener, UpdateChannelUsernameOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int editChannelInfo(String str, EditChannelInput editChannelInput, RetryObject retryObject, NetworkHelper.ResponseListener<AddOrEditChannelOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "editChannelInfo", toJson(editChannelInput), retryObject, getListenerV5(responseListener, AddOrEditChannelOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int editGroupInfo(String str, EditGroupInfoInput editGroupInfoInput, RetryObject retryObject, NetworkHelper.ResponseListener<AddOrEditGroupOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "editGroupInfo", toJson(editGroupInfoInput), retryObject, getListenerV5(responseListener, AddOrEditGroupOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getGroupMentionList(String str, GetGroupMentionListInput getGroupMentionListInput, RetryObject retryObject, NetworkHelper.ResponseListener<GetGroupMembersOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getGroupMentionList", toJson(getGroupMentionListInput), retryObject, getListenerV5(responseListener, GetGroupMembersOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getGroupAdminMembers(String str, GetGroupMembersInput getGroupMembersInput, RetryObject retryObject, NetworkHelper.ResponseListener<GetGroupMembersOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getGroupAdminMembers", toJson(getGroupMembersInput), retryObject, getListenerV5(responseListener, GetGroupMembersOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getChannelAdminMembers(String str, GetChannelMembersInput getChannelMembersInput, RetryObject retryObject, NetworkHelper.ResponseListener<GetChannelMembersOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getChannelAdminMembers", toJson(getChannelMembersInput), retryObject, getListenerV5(responseListener, GetChannelMembersOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getBannedGroupMembers(String str, GetGroupMembersInput getGroupMembersInput, RetryObject retryObject, NetworkHelper.ResponseListener<GetGroupMembersOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getBannedGroupMembers", toJson(getGroupMembersInput), retryObject, getListenerV5(responseListener, GetGroupMembersOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getBannedChannelMembers(String str, GetChannelMembersInput getChannelMembersInput, RetryObject retryObject, NetworkHelper.ResponseListener<GetChannelMembersOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getBannedChannelMembers", toJson(getChannelMembersInput), retryObject, getListenerV5(responseListener, GetChannelMembersOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int setGroupAdmin(String str, SetGroupAdminInput setGroupAdminInput, RetryObject retryObject, NetworkHelper.ResponseListener<SetGroupAdminOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "setGroupAdmin", toJson(setGroupAdminInput), retryObject, getListenerV5(responseListener, SetGroupAdminOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int setChannelAdmin(String str, SetChannelAdminInput setChannelAdminInput, RetryObject retryObject, NetworkHelper.ResponseListener<SetChannelAdminOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "setChannelAdmin", toJson(setChannelAdminInput), retryObject, getListenerV5(responseListener, SetChannelAdminOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getGroupAdminAccessList(String str, GetGroupAdminAccessListInput getGroupAdminAccessListInput, RetryObject retryObject, NetworkHelper.ResponseListener<GetGroupAdminAccessListOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getGroupAdminAccessList", toJson(getGroupAdminAccessListInput), retryObject, getListenerV5(responseListener, GetGroupAdminAccessListOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getChannelAdminAccessList(String str, GetChannelAdminAccessInput getChannelAdminAccessInput, RetryObject retryObject, NetworkHelper.ResponseListener<GetChannelAdminAccessListOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getChannelAdminAccessList", toJson(getChannelAdminAccessInput), retryObject, getListenerV5(responseListener, GetChannelAdminAccessListOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int setGroupDefaultAccess(String str, SetGroupDefaultAccessInput setGroupDefaultAccessInput, RetryObject retryObject, NetworkHelper.ResponseListener<SetGroupDefaultAccessOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "setGroupDefaultAccess", toJson(setGroupDefaultAccessInput), retryObject, getListenerV5(responseListener, SetGroupDefaultAccessOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getGroupDefaultAccess(String str, GetGroupDefaultAccessInput getGroupDefaultAccessInput, RetryObject retryObject, NetworkHelper.ResponseListener<GetGroupDefaultAccessOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getGroupDefaultAccess", toJson(getGroupDefaultAccessInput), retryObject, getListenerV5(responseListener, GetGroupDefaultAccessOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int banGroupMember(String str, BanGroupMemberInput banGroupMemberInput, RetryObject retryObject, NetworkHelper.ResponseListener<BanGroupMemberOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "banGroupMember", toJson(banGroupMemberInput), retryObject, getListenerV5(responseListener, BanGroupMemberOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int banChannelMember(String str, BanChannelMemberInput banChannelMemberInput, RetryObject retryObject, NetworkHelper.ResponseListener<BanChannelMemberOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "banChannelMember", toJson(banChannelMemberInput), retryObject, getListenerV5(responseListener, BanChannelMemberOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int addGroupMembers(String str, AddGroupMembersInput addGroupMembersInput, RetryObject retryObject, NetworkHelper.ResponseListener<AddGroupMembersOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "addGroupMembers", toJson(addGroupMembersInput), retryObject, getListenerV5(responseListener, AddGroupMembersOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int addChannelMembers(String str, AddChannelMembersInput addChannelMembersInput, RetryObject retryObject, NetworkHelper.ResponseListener<AddChannelMembersOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "addChannelMembers", toJson(addChannelMembersInput), retryObject, getListenerV5(responseListener, AddChannelMembersOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int setGroupLink(String str, SetGroupLinkInput setGroupLinkInput, RetryObject retryObject, NetworkHelper.ResponseListener<SetGroupLinkOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "setGroupLink", toJson(setGroupLinkInput), retryObject, getListenerV5(responseListener, SetGroupLinkOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int setChannelLink(String str, SetChannelLinkInput setChannelLinkInput, RetryObject retryObject, NetworkHelper.ResponseListener<SetChannelLinkOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "setChannelLink", toJson(setChannelLinkInput), retryObject, getListenerV5(responseListener, SetChannelLinkOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getGroupLink(String str, GetGroupLinkInput getGroupLinkInput, RetryObject retryObject, NetworkHelper.ResponseListener<GetGroupLinkOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getGroupLink", toJson(getGroupLinkInput), retryObject, getListenerV5(responseListener, GetGroupLinkOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getChannelLink(String str, GetChannelLinkInput getChannelLinkInput, RetryObject retryObject, NetworkHelper.ResponseListener<GetChannelLinkOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getChannelLink", toJson(getChannelLinkInput), retryObject, getListenerV5(responseListener, GetChannelLinkOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getCommonGroups(String str, GetCommonGroupsInput getCommonGroupsInput, RetryObject retryObject, NetworkHelper.ResponseListener<GetCommonGroupsOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getCommonGroups", toJson(getCommonGroupsInput), retryObject, getListenerV5(responseListener, GetCommonGroupsOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int reportObject(String str, ReportObjectInput reportObjectInput, RetryObject retryObject, NetworkHelper.ResponseListener<ReportObjectOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "reportObject", toJson(reportObjectInput), retryObject, getListenerV5(responseListener, ReportObjectOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int requestChangeObjectOwner(String str, ChangeOwnerModels.RequestChangeOwnerInput requestChangeOwnerInput, RetryObject retryObject, NetworkHelper.ResponseListener<ChangeOwnerModels.RequestChangeOwnerOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "requestChangeObjectOwner", toJson(requestChangeOwnerInput), retryObject, getListenerV5(responseListener, ChangeOwnerModels.RequestChangeOwnerOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int cancelChangeObjectOwner(String str, ChangeOwnerModels.CancelChangeOwnerInput cancelChangeOwnerInput, RetryObject retryObject, NetworkHelper.ResponseListener<ChangeOwnerModels.CancelChangeOwnerOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "cancelChangeObjectOwner", toJson(cancelChangeOwnerInput), retryObject, getListenerV5(responseListener, ChangeOwnerModels.CancelChangeOwnerOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getPendingObjectOwner(String str, ChangeOwnerModels.GetPendingObjectOwnerInput getPendingObjectOwnerInput, RetryObject retryObject, NetworkHelper.ResponseListener<ChangeOwnerModels.GetPendingObjectOwnerOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getPendingObjectOwner", toJson(getPendingObjectOwnerInput), retryObject, getListenerV5(responseListener, ChangeOwnerModels.GetPendingObjectOwnerOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int replyRequestObjectOwner(String str, ChangeOwnerModels.ReplyRequestObjectOwnerInput replyRequestObjectOwnerInput, RetryObject retryObject, NetworkHelper.ResponseListener<ChangeOwnerModels.ReplyRequestObjectOwnerOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "replyRequestObjectOwner", toJson(replyRequestObjectOwnerInput), retryObject, getListenerV5(responseListener, ChangeOwnerModels.ReplyRequestObjectOwnerOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int removeGroup(String str, RemoveGroupInput removeGroupInput, RetryObject retryObject, NetworkHelper.ResponseListener<RemoveGroupOrChannelOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "removeGroup", toJson(removeGroupInput), retryObject, getListenerV5(responseListener, RemoveGroupOrChannelOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int removeChannel(String str, RemoveChannelInput removeChannelInput, RetryObject retryObject, NetworkHelper.ResponseListener<RemoveGroupOrChannelOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "removeChannel", toJson(removeChannelInput), retryObject, getListenerV5(responseListener, RemoveGroupOrChannelOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public void getGroupOnlineCount(String str, GetGroupOnlineCountInput getGroupOnlineCountInput, RetryObject retryObject, NetworkHelper.ResponseListener<GetGroupOnlineCountOutput> responseListener) throws Exception {
        this.network.sendV5OrV6(str, "getGroupOnlineCount", toJson(getGroupOnlineCountInput), retryObject, getListenerV5(responseListener, GetGroupOnlineCountOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getGroupInfo(String str, GetGroupInfoInput getGroupInfoInput, RetryObject retryObject, NetworkHelper.ResponseListener<GetGroupInfoOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getGroupInfo", toJson(getGroupInfoInput), retryObject, getListenerV5(responseListener, GetGroupInfoOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getChannelInfo(String str, GetChannelInfoInput getChannelInfoInput, RetryObject retryObject, NetworkHelper.ResponseListener<GetChannelInfoOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getChannelInfo", toJson(getChannelInfoInput), retryObject, getListenerV5(responseListener, GetChannelInfoOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getUserInfo(String str, GetUserInfoInput getUserInfoInput, RetryObject retryObject, NetworkHelper.ResponseListener<GetUserInfoOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getUserInfo", toJson(getUserInfoInput), retryObject, getListenerV5(responseListener, GetUserInfoOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getGroupMessageReadParticipants(String str, GetGroupMessageReadParticipantsInput getGroupMessageReadParticipantsInput, RetryObject retryObject, NetworkHelper.ResponseListener<GetGroupMessageReadParticipantsOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getGroupMessageReadParticipants", toJson(getGroupMessageReadParticipantsInput), retryObject, getListenerV5(responseListener, GetGroupMessageReadParticipantsOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getServiceInfo(String str, GetServiceInfoInput getServiceInfoInput, RetryObject retryObject, NetworkHelper.ResponseListener<GetServiceInfoOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getServiceInfo", toJson(getServiceInfoInput), retryObject, getListenerV5(responseListener, GetServiceInfoOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int deleteServiceChat(String str, DeleteServiceChatInput deleteServiceChatInput, RetryObject retryObject, NetworkHelper.ResponseListener<DeleteChatOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "deleteServiceChat", toJson(deleteServiceChatInput), retryObject, getListenerV5(responseListener, DeleteChatOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int deleteUserChat(String str, DeleteUserChatInput deleteUserChatInput, RetryObject retryObject, NetworkHelper.ResponseListener<DeleteChatOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "deleteUserChat", toJson(deleteUserChatInput), retryObject, getListenerV5(responseListener, DeleteChatOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getCurrentLiveLocation(String str, LiveLocationInput liveLocationInput, RetryObject retryObject, NetworkHelper.ResponseListener<LiveLocationOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getCurrentLiveLocation", toJson(liveLocationInput), retryObject, getListenerV5(responseListener, LiveLocationOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int setCurrentLiveLocation(String str, SetCurrentLiveLocationInput setCurrentLiveLocationInput, RetryObject retryObject, NetworkHelper.ResponseListener<SetCurrentLiveLocationOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "setCurrentLiveLocation", toJson(setCurrentLiveLocationInput), retryObject, getListenerV5(responseListener, SetCurrentLiveLocationOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int stopLiveLocation(String str, LiveLocationInput liveLocationInput, RetryObject retryObject, NetworkHelper.ResponseListener<LiveLocationOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "stopLiveLocation", toJson(liveLocationInput), retryObject, getListenerV5(responseListener, LiveLocationOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getBotInfo(String str, GetBotInfoInput getBotInfoInput, RetryObject retryObject, NetworkHelper.ResponseListener<GetBotInfoOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getBotInfo", toJson(getBotInfoInput), retryObject, getListenerV5(responseListener, GetBotInfoOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int deleteBotChat(String str, BotModels.DeleteBotChatInput deleteBotChatInput, RetryObject retryObject, NetworkHelper.ResponseListener<DeleteChatOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "deleteBotChat", toJson(deleteBotChatInput), retryObject, getListenerV5(responseListener, DeleteChatOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int stopBot(String str, BotModels.StopBotInput stopBotInput, RetryObject retryObject, NetworkHelper.ResponseListener<BotModels.StopBotOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "stopBot", toJson(stopBotInput), retryObject, getListenerV5(responseListener, BotModels.StopBotOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getSelection(String str, String str2, BotModels.GetBotSelectionInput getBotSelectionInput, RetryObject retryObject, NetworkHelper.ResponseListener<BotModels.GetBotSelectionOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, str2, "getSelection", toJson(getBotSelectionInput), retryObject, getListenerV5(responseListener, BotModels.GetBotSelectionOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int searchSelection(String str, String str2, BotModels.SearchBotSelectionInput searchBotSelectionInput, RetryObject retryObject, NetworkHelper.ResponseListener<BotModels.SearchBotSelectionOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, str2, "searchSelection", toJson(searchBotSelectionInput), retryObject, getListenerV5(responseListener, BotModels.SearchBotSelectionOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int sendMessageAPICall(String str, String str2, BotModels.SendMessageApiCallInput sendMessageApiCallInput, RetryObject retryObject, NetworkHelper.ResponseListener<BotModels.SendMessageApiCallOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, str2, "sendMessageAPICall", toJson(sendMessageApiCallInput), retryObject, getListenerV5(responseListener, BotModels.SendMessageApiCallOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getMapView(String str, GetMapViewInput getMapViewInput, RetryObject retryObject, NetworkHelper.ResponseListener<GetMapViewOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getMapView", toJson(getMapViewInput), retryObject, getListenerV5(responseListener, GetMapViewOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int sendCode(String str, SendCodeInput sendCodeInput, RetryObject retryObject, NetworkHelper.ResponseListener<SendCodeOutput> responseListener) throws Exception {
        return this.network.sendTempSessionV6(str, "sendCode", toJson(sendCodeInput), retryObject, getListenerV5(responseListener, SendCodeOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int loginTwoStepForgetPassword(String str, LoginTwoStepForgetPasswordInput loginTwoStepForgetPasswordInput, RetryObject retryObject, NetworkHelper.ResponseListener<LoginTwoStepForgetPasswordOutput> responseListener) throws Exception {
        return this.network.sendTempSessionV6(str, "loginTwoStepForgetPassword", toJson(loginTwoStepForgetPasswordInput), retryObject, getListenerV5(responseListener, LoginTwoStepForgetPasswordOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int loginDisableTwoStep(String str, LoginDisableTwoStepInput loginDisableTwoStepInput, RetryObject retryObject, NetworkHelper.ResponseListener<LoginDisableTwoStepOutput> responseListener) throws Exception {
        return this.network.sendTempSessionV6(str, "loginDisableTwoStep", toJson(loginDisableTwoStepInput), retryObject, getListenerV5(responseListener, LoginDisableTwoStepOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getTwoPasscodeStatus(String str, GetTwoPasscodeStatusInput getTwoPasscodeStatusInput, RetryObject retryObject, NetworkHelper.ResponseListener<TwoPasscodeStatusOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getTwoPasscodeStatus", toJson(getTwoPasscodeStatusInput), retryObject, getListenerV5(responseListener, TwoPasscodeStatusOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int abortTwoStepSetup(String str, AbortTwoStepSetupInput abortTwoStepSetupInput, RetryObject retryObject, NetworkHelper.ResponseListener<AbortTwoStepSetupOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "abortTwoStepSetup", toJson(abortTwoStepSetupInput), retryObject, getListenerV5(responseListener, AbortTwoStepSetupOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int setupTwoStepVerification(String str, SetupTwoStepVerificationInput setupTwoStepVerificationInput, RetryObject retryObject, NetworkHelper.ResponseListener<TwoPasscodeStatusOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "setupTwoStepVerification", toJson(setupTwoStepVerificationInput), retryObject, getListenerV5(responseListener, TwoPasscodeStatusOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int checkTwoStepPasscode(String str, PasswordInput passwordInput, RetryObject retryObject, NetworkHelper.ResponseListener<CheckTwoStepPasscodeOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "checkTwoStepPasscode", toJson(passwordInput), retryObject, getListenerV5(responseListener, CheckTwoStepPasscodeOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getTopChatUsers(String str, GetTopChatUsersInput getTopChatUsersInput, RetryObject retryObject, NetworkHelper.ResponseListener<GetTopChatUsersOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getTopChatUsers", toJson(getTopChatUsersInput), retryObject, getListenerV5(responseListener, GetTopChatUsersOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int removeFromTopChatUsers(String str, RemoveFromTopChatUsersInput removeFromTopChatUsersInput, RetryObject retryObject, NetworkHelper.ResponseListener<RemoveFromTopChatUsersOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "removeFromTopChatUsers", toJson(removeFromTopChatUsersInput), retryObject, getListenerV5(responseListener, RemoveFromTopChatUsersOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int changePassword(String str, ChangePasswordInput changePasswordInput, RetryObject retryObject, NetworkHelper.ResponseListener<TwoPasscodeStatusOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "changePassword", toJson(changePasswordInput), retryObject, getListenerV5(responseListener, TwoPasscodeStatusOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int requestRecoveryEmail(String str, RequestRecoveryEmailInput requestRecoveryEmailInput, RetryObject retryObject, NetworkHelper.ResponseListener<TwoPasscodeStatusOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "requestRecoveryEmail", toJson(requestRecoveryEmailInput), retryObject, getListenerV5(responseListener, TwoPasscodeStatusOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int resendCodeRecoveryEmail(String str, PasswordInput passwordInput, RetryObject retryObject, NetworkHelper.ResponseListener<ResendCodeRecoveryEmailOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "resendCodeRecoveryEmail", toJson(passwordInput), retryObject, getListenerV5(responseListener, ResendCodeRecoveryEmailOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int verifyRecoveryEmail(String str, VerifyRecoveryEmailInput verifyRecoveryEmailInput, RetryObject retryObject, NetworkHelper.ResponseListener<VerifyRecoveryEmailOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "verifyRecoveryEmail", toJson(verifyRecoveryEmailInput), retryObject, getListenerV5(responseListener, VerifyRecoveryEmailOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int abortSetRecoveryEmail(String str, PasswordInput passwordInput, RetryObject retryObject, NetworkHelper.ResponseListener<TwoPasscodeStatusOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "abortSetRecoveryEmail", toJson(passwordInput), retryObject, getListenerV5(responseListener, TwoPasscodeStatusOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int turnOffTwoStep(String str, TurnOffTwoStepInput turnOffTwoStepInput, RetryObject retryObject, NetworkHelper.ResponseListener<TurnOffTwoStepOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "turnOffTwoStep", toJson(turnOffTwoStepInput), retryObject, getListenerV5(responseListener, TurnOffTwoStepOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int requestForgetPassword(String str, RequestForgetPasswordInput requestForgetPasswordInput, RetryObject retryObject, NetworkHelper.ResponseListener<RequestForgetPasswordOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "requestForgetPassword", toJson(requestForgetPasswordInput), retryObject, getListenerV5(responseListener, RequestForgetPasswordOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int disableTwoStepByForgetPassword(String str, DisableTwoStepByForgetPasswordInput disableTwoStepByForgetPasswordInput, RetryObject retryObject, NetworkHelper.ResponseListener<DisableTwoStepByForgetPasswordOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "disableTwoStepByForgetPassword", toJson(disableTwoStepByForgetPasswordInput), retryObject, getListenerV5(responseListener, DisableTwoStepByForgetPasswordOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int requestChangePhoneNumber(String str, RequestChangePhoneNumberInput requestChangePhoneNumberInput, RetryObject retryObject, NetworkHelper.ResponseListener<RequestChangePhoneNumberOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "requestChangePhoneNumber", toJson(requestChangePhoneNumberInput), retryObject, getListenerV5(responseListener, RequestChangePhoneNumberOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int verifyChangePhoneNumber(String str, VerifyChangePhoneNumberInput verifyChangePhoneNumberInput, RetryObject retryObject, NetworkHelper.ResponseListener<VerifyChangePhoneNumberOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "verifyChangePhoneNumber", toJson(verifyChangePhoneNumberInput), retryObject, getListenerV5(responseListener, VerifyChangePhoneNumberOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int signIn(String str, SignInInput signInInput, RetryObject retryObject, NetworkHelper.ResponseListener<SignInOutput> responseListener) throws Exception {
        return this.network.sendTempSessionV6(str, "signIn", toJson(signInInput), retryObject, getListenerV5(responseListener, SignInOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int logout(String str, LogoutInput logoutInput, RetryObject retryObject, NetworkHelper.ResponseListener<LogoutOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "logout", toJson(logoutInput), retryObject, getListenerV5(responseListener, LogoutOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getMySessions(String str, GetMySessionsInput getMySessionsInput, RetryObject retryObject, NetworkHelper.ResponseListener<GetMySessionsOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getMySessions", toJson(getMySessionsInput), retryObject, getListenerV5(responseListener, GetMySessionsOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int terminateSession(String str, TerminateSessionInput terminateSessionInput, RetryObject retryObject, NetworkHelper.ResponseListener<TerminateSessionOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "terminateSession", toJson(terminateSessionInput), retryObject, getListenerV5(responseListener, TerminateSessionOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int terminateOtherSessions(String str, TerminateOtherSessionInput terminateOtherSessionInput, RetryObject retryObject, NetworkHelper.ResponseListener<TerminateOtherSessionOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "terminateOtherSessions", toJson(terminateOtherSessionInput), retryObject, getListenerV5(responseListener, TerminateOtherSessionOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int registerDevice(String str, RegisterDeviceInput registerDeviceInput, RetryObject retryObject, NetworkHelper.ResponseListener<RegisterDeviceOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "registerDevice", toJson(registerDeviceInput), retryObject, getListenerV5(responseListener, RegisterDeviceOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public void getAbsObjects(String str, GetAbsObjectsInput getAbsObjectsInput, RetryObject retryObject, NetworkHelper.ResponseListener<GetAbsObjectsOutput> responseListener) throws Exception {
        this.network.sendV5OrV6(str, "getAbsObjects", toJson(getAbsObjectsInput), retryObject, getListenerV5(responseListener, GetAbsObjectsOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getChatAds(String str, GetChatAdsInput getChatAdsInput, RetryObject retryObject, NetworkHelper.ResponseListener<GetChatAdsOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getChatAds", toJson(getChatAdsInput), retryObject, getListenerV5(responseListener, GetChatAdsOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int actionOnChatAds(String str, ActionOnChatAdsInput actionOnChatAdsInput, RetryObject retryObject, NetworkHelper.ResponseListener<ActionOnChatAdsOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "actionOnChatAds", toJson(actionOnChatAdsInput), retryObject, getListenerV5(responseListener, ActionOnChatAdsOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getChats(String str, GetChatsInput getChatsInput, RetryObject retryObject, NetworkHelper.ResponseListener<GetChatsOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getChats", toJson(getChatsInput), retryObject, getListenerV5(responseListener, GetChatsOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int setChatUseTime(String str, SetChatUseTimeInput setChatUseTimeInput, RetryObject retryObject, NetworkHelper.ResponseListener<SetChatUseTimeOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "setChatUseTime", toJson(setChatUseTimeInput), retryObject, getListenerV5(responseListener, SetChatUseTimeOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getChatsByID(String str, GetChatsByIDInput getChatsByIDInput, RetryObject retryObject, NetworkHelper.ResponseListener<GetChatByIDOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getChatsByID", toJson(getChatsByIDInput), retryObject, getListenerV5(responseListener, GetChatByIDOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int deleteChatHistory(String str, DeleteChatHistoryInput deleteChatHistoryInput, RetryObject retryObject, NetworkHelper.ResponseListener<DeleteChatOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "deleteChatHistory", toJson(deleteChatHistoryInput), retryObject, getListenerV5(responseListener, DeleteChatOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public void getMessagesInterval(String str, GetMessagesInput getMessagesInput, RetryObject retryObject, NetworkHelper.ResponseListener<GetMessagesIntervalOutput> responseListener) throws Exception {
        this.network.sendV5OrV6(str, "getMessagesInterval", toJson(getMessagesInput), retryObject, getListenerV5(responseListener, GetMessagesIntervalOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public void getMessageShareUrl(String str, GetMessageShareUrlInput getMessageShareUrlInput, RetryObject retryObject, NetworkHelper.ResponseListener<GetMessageShareUrlOutput> responseListener) throws Exception {
        this.network.sendV5OrV6(str, "getMessageShareUrl", toJson(getMessageShareUrlInput), retryObject, getListenerV5(responseListener, GetMessageShareUrlOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getContacts(String str, GetContactInput getContactInput, RetryObject retryObject, NetworkHelper.ResponseListener<GetContactOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getContacts", toJson(getContactInput), retryObject, getListenerV5(responseListener, GetContactOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getContactsUpdates(String str, GetContactUpdateInput getContactUpdateInput, RetryObject retryObject, NetworkHelper.ResponseListener<GetContactUpdateOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getContactsUpdates", toJson(getContactUpdateInput), retryObject, getListenerV5(responseListener, GetContactUpdateOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int deleteContact(String str, DeleteContactInput deleteContactInput, RetryObject retryObject, NetworkHelper.ResponseListener<DeleteContactOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "deleteContact", toJson(deleteContactInput), retryObject, getListenerV5(responseListener, DeleteContactOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int resetContacts(String str, ResetContactsInput resetContactsInput, RetryObject retryObject, NetworkHelper.ResponseListener<ResetContactsOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "resetContacts", toJson(resetContactsInput), retryObject, getListenerV5(responseListener, ResetContactsOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int importAddressBook(String str, ImportAddressBookInput importAddressBookInput, RetryObject retryObject, NetworkHelper.ResponseListener<ImportAddressBookOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "importAddressBook", toJson(importAddressBookInput), retryObject, getListenerV5(responseListener, ImportAddressBookOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int addAddressBook(String str, AddAddressBookInput addAddressBookInput, RetryObject retryObject, NetworkHelper.ResponseListener<AddAddressBookOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "addAddressBook", toJson(addAddressBookInput), retryObject, getListenerV5(responseListener, AddAddressBookOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getGroupAllMembers(String str, GetGroupMembersInput getGroupMembersInput, RetryObject retryObject, NetworkHelper.ResponseListener<GetGroupMembersOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getGroupAllMembers", toJson(getGroupMembersInput), retryObject, getListenerV5(responseListener, GetGroupMembersOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getChannelAllMembers(String str, GetChannelMembersInput getChannelMembersInput, RetryObject retryObject, NetworkHelper.ResponseListener<GetChannelMembersOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getChannelAllMembers", toJson(getChannelMembersInput), retryObject, getListenerV5(responseListener, GetChannelMembersOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getAvatars(String str, GetAvatarsInput getAvatarsInput, RetryObject retryObject, NetworkHelper.ResponseListener<GetAvatarsOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getAvatars", toJson(getAvatarsInput), retryObject, getListenerV5(responseListener, GetAvatarsOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int setActionChat(String str, SetChatActionInput setChatActionInput, RetryObject retryObject, NetworkHelper.ResponseListener<SetChatActionOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "setActionChat", toJson(setChatActionInput), retryObject, getListenerV5(responseListener, SetChatActionOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int joinGroup(String str, JoinGroupInput joinGroupInput, RetryObject retryObject, NetworkHelper.ResponseListener<JoinGroupOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "joinGroup", toJson(joinGroupInput), retryObject, getListenerV5(responseListener, JoinGroupOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int leaveGroup(String str, LeaveGroupInput leaveGroupInput, RetryObject retryObject, NetworkHelper.ResponseListener<LeaveGroupOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "leaveGroup", toJson(leaveGroupInput), retryObject, getListenerV5(responseListener, LeaveGroupOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int deleteNoAccessGroupChat(String str, LeaveGroupInput leaveGroupInput, RetryObject retryObject, NetworkHelper.ResponseListener<LeaveGroupOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "deleteNoAccessGroupChat", toJson(leaveGroupInput), retryObject, getListenerV5(responseListener, LeaveGroupOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int joinChannelAction(String str, JoinChannelActionInput joinChannelActionInput, RetryObject retryObject, NetworkHelper.ResponseListener<JoinChannelActionOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "joinChannelAction", toJson(joinChannelActionInput), retryObject, getListenerV5(responseListener, JoinChannelActionOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int joinChannelByLink(String str, JoinChannelByLinkInput joinChannelByLinkInput, RetryObject retryObject, NetworkHelper.ResponseListener<JoinChannelByLinkOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "joinChannelByLink", toJson(joinChannelByLinkInput), retryObject, getListenerV5(responseListener, JoinChannelByLinkOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getChannelSeenCount(String str, GetChannelSeenCountInput getChannelSeenCountInput, RetryObject retryObject, NetworkHelper.ResponseListener<GetChannelSeenCountOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getChannelSeenCount", toJson(getChannelSeenCountInput), retryObject, getListenerV5(responseListener, GetChannelSeenCountOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int seenChannelMessages(String str, SeenChannelMessagesInput seenChannelMessagesInput, RetryObject retryObject, NetworkHelper.ResponseListener<SeenChannelMessagesOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "seenChannelMessages", toJson(seenChannelMessagesInput), retryObject, getListenerV5(responseListener, SeenChannelMessagesOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int setBlockUser(String str, SetBlockUserInput setBlockUserInput, RetryObject retryObject, NetworkHelper.ResponseListener<SetBlockUserOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "setBlockUser", toJson(setBlockUserInput), retryObject, getListenerV5(responseListener, SetBlockUserOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getBlockedUsers(String str, GetBlockedUsersInput getBlockedUsersInput, RetryObject retryObject, NetworkHelper.ResponseListener<GetBlockedUsersOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getBlockedUsers", toJson(getBlockedUsersInput), retryObject, getListenerV5(responseListener, GetBlockedUsersOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getContactsLastOnline(String str, GetContactsLastOnlineInput getContactsLastOnlineInput, RetryObject retryObject, NetworkHelper.ResponseListener<GetContactsLastOnlineOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getContactsLastOnline", toJson(getContactsLastOnlineInput), retryObject, getListenerV5(responseListener, GetContactsLastOnlineOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getChatsUpdates(String str, GetChatsUpdatesInput getChatsUpdatesInput, RetryObject retryObject, NetworkHelper.ResponseListener<GetChatsUpdatesOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getChatsUpdates", toJson(getChatsUpdatesInput), retryObject, getListenerV5(responseListener, GetChatsUpdatesOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getMessagesUpdates(String str, GetMessagesUpdatesInput getMessagesUpdatesInput, RetryObject retryObject, NetworkHelper.ResponseListener<GetMessagesUpdatesOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getMessagesUpdates", toJson(getMessagesUpdatesInput), retryObject, getListenerV5(responseListener, GetMessagesUpdatesOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int requestSendFile(String str, RequestSendFileInput requestSendFileInput, RetryObject retryObject, NetworkHelper.ResponseListener<RequestSendFileOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "requestSendFile", toJson(requestSendFileInput), retryObject, getListenerV5(responseListener, RequestSendFileOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getLinkFromAppUrl(String str, GetLinkFromAppUrlInput getLinkFromAppUrlInput, RetryObject retryObject, NetworkHelper.ResponseListener<GetLinkFromAppUrlOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getLinkFromAppUrl", toJson(getLinkFromAppUrlInput), retryObject, getListenerV5(responseListener, GetLinkFromAppUrlOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int clickMessageUrl(String str, ClickMessageUrlInput clickMessageUrlInput, RetryObject retryObject, NetworkHelper.ResponseListener<ClickMessageUrlOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "clickMessageUrl", toJson(clickMessageUrlInput), retryObject, getListenerV5(responseListener, ClickMessageUrlOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int requestDeleteAccount(String str, RequestDeleteAccountInput requestDeleteAccountInput, RetryObject retryObject, NetworkHelper.ResponseListener<RequestDeleteAccountOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "requestDeleteAccount", toJson(requestDeleteAccountInput), retryObject, getListenerV5(responseListener, RequestDeleteAccountOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getWalletTransferMessage(String str, GetWalletTransactionMessageInput getWalletTransactionMessageInput, RetryObject retryObject, NetworkHelper.ResponseListener<GetWalletTransactionMessageOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "getWalletTransferMessage", toJson(getWalletTransactionMessageInput), retryObject, getListenerV5(responseListener, GetWalletTransactionMessageOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int sendWalletTransferMessage(String str, SendWalletTransactionMessageInput sendWalletTransactionMessageInput, RetryObject retryObject, NetworkHelper.ResponseListener<SendMessageOutput> responseListener) throws Exception {
        return this.network.sendV5OrV6(str, "sendWalletTransferMessage", toJson(sendWalletTransactionMessageInput), retryObject, getListenerV5(responseListener, SendMessageOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getDCs(String str, String str2, RetryObject retryObject, NetworkHelper.ResponseListener<GetDcsOutput> responseListener) throws Exception {
        return this.network.sendV4(str, str2, "getDCs", null, retryObject, getListenerV4(responseListener, GetDcsOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public void getTime(String str, GetTimeInput getTimeInput, RetryObject retryObject, NetworkHelper.ResponseListener<GetTimeOutput> responseListener) throws Exception {
        this.network.sendV5OrV6(str, "getTime", toJson(getTimeInput), retryObject, getListenerV5(responseListener, GetTimeOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int sendFile(String str, String str2, SendFileInput sendFileInput, RetryObject retryObject, NetworkHelper.ResponseListener<SendFileOutput> responseListener) throws Exception {
        if (str == null || sendFileInput == null) {
            if (this.coreLog.isDebug()) {
                throw new RuntimeException();
            }
            return -1;
        }
        return this.network.sendBytes(str, str2, sendFileInput.bytes, sendFileInput.getHeaderMap(), retryObject, getListenerV4(responseListener, SendFileOutput.class));
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getFile(String str, String str2, GetFileInput getFileInput, RetryObject retryObject, final NetworkHelper.ResponseListener<GetFileResult> responseListener) throws Exception {
        if (str == null || getFileInput == null) {
            if (this.coreLog.isDebug()) {
                throw new RuntimeException();
            }
            return -1;
        }
        return this.network.getBytes(str, str2, getFileInput.getHeaderMap(), retryObject, new Network.BodyResponseListener(this) { // from class: ir.aaap.messengercore.network.NetworkHelperImpl.1
            @Override // ir.aaap.messengercore.network.Network.BodyResponseListener
            public void onResponse(int i, byte[] bArr) {
                if (responseListener != null) {
                    GetFileResult getFileResult = new GetFileResult();
                    getFileResult.totalLength = i;
                    getFileResult.bytes = bArr;
                    responseListener.onResponse(getFileResult);
                }
            }

            @Override // ir.aaap.messengercore.network.Network.BodyResponseListener
            public void onError(Exception exc) {
                NetworkHelper.ResponseListener responseListener2 = responseListener;
                if (responseListener2 != null) {
                    responseListener2.onError(exc);
                }
            }
        });
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getFileCdn(String str, String str2, String str3, GetFileInput getFileInput, RetryObject retryObject, final NetworkHelper.ResponseListener<GetFileResult> responseListener) throws Exception {
        if (str2 == null || getFileInput == null) {
            if (this.coreLog.isDebug()) {
                throw new RuntimeException();
            }
            return -1;
        }
        return this.network.getBytesCdn(str, str2, str3, getFileInput.getHeaderMap(), retryObject, new Network.BodyResponseListener(this) { // from class: ir.aaap.messengercore.network.NetworkHelperImpl.2
            @Override // ir.aaap.messengercore.network.Network.BodyResponseListener
            public void onResponse(int i, byte[] bArr) {
                if (responseListener != null) {
                    GetFileResult getFileResult = new GetFileResult();
                    getFileResult.totalLength = i;
                    getFileResult.bytes = bArr;
                    responseListener.onResponse(getFileResult);
                }
            }

            @Override // ir.aaap.messengercore.network.Network.BodyResponseListener
            public void onError(Exception exc) {
                NetworkHelper.ResponseListener responseListener2 = responseListener;
                if (responseListener2 != null) {
                    responseListener2.onError(exc);
                }
            }
        });
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public int getExternalFile(String str, String str2, RetryObject retryObject, final NetworkHelper.ResponseListener<GetFileResult> responseListener) throws Exception {
        if (str == null) {
            if (this.coreLog.isDebug()) {
                throw new RuntimeException();
            }
            return -1;
        }
        return this.network.getBytes(str, str2, retryObject, new Network.BodyResponseListener(this) { // from class: ir.aaap.messengercore.network.NetworkHelperImpl.3
            @Override // ir.aaap.messengercore.network.Network.BodyResponseListener
            public void onResponse(int i, byte[] bArr) {
                if (responseListener != null) {
                    GetFileResult getFileResult = new GetFileResult();
                    getFileResult.totalLength = i;
                    getFileResult.bytes = bArr;
                    responseListener.onResponse(getFileResult);
                }
            }

            @Override // ir.aaap.messengercore.network.Network.BodyResponseListener
            public void onError(Exception exc) {
                NetworkHelper.ResponseListener responseListener2 = responseListener;
                if (responseListener2 != null) {
                    responseListener2.onError(exc);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> T parseData(String str, Class<T> cls) throws Exception {
        return (T) this.jsonHelper.fromJson(str, cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> T parseDataV5(String str, Class<T> cls) throws Exception {
        JSONObject jSONObject = new JSONObject(str);
        return (T) this.jsonHelper.fromJson(jSONObject.has("data") ? jSONObject.getString("data") : BuildConfig.FLAVOR, cls);
    }

    private JSONObject toJson(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return new JSONObject(this.jsonHelper.toJson(obj));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private <T> Network.ResponseListener getListenerV4(final NetworkHelper.ResponseListener<T> responseListener, final Class<T> cls) {
        return new Network.ResponseListener() { // from class: ir.aaap.messengercore.network.NetworkHelperImpl.4
            @Override // ir.aaap.messengercore.network.Network.ResponseListener
            public void onResponse(String str) {
                NetworkHelper.ResponseListener responseListener2 = responseListener;
                if (responseListener2 == null || str == null) {
                    return;
                }
                try {
                    responseListener2.onResponse(NetworkHelperImpl.this.parseData(str, cls));
                } catch (Exception e) {
                    responseListener.onError(e);
                }
            }

            @Override // ir.aaap.messengercore.network.Network.ResponseListener
            public void onError(Exception exc) {
                NetworkHelper.ResponseListener responseListener2 = responseListener;
                if (responseListener2 != null) {
                    responseListener2.onError(exc);
                }
            }
        };
    }

    private <T> Network.ResponseListener getListenerV5(final NetworkHelper.ResponseListener<T> responseListener, final Class<T> cls) {
        return new Network.ResponseListener() { // from class: ir.aaap.messengercore.network.NetworkHelperImpl.5
            @Override // ir.aaap.messengercore.network.Network.ResponseListener
            public void onResponse(String str) {
                NetworkHelper.ResponseListener responseListener2 = responseListener;
                if (responseListener2 == null || str == null) {
                    return;
                }
                try {
                    responseListener2.onResponse(NetworkHelperImpl.this.parseDataV5(str, cls));
                } catch (Exception e) {
                    if (e instanceof NotificationException) {
                        NetworkHelperImpl.this.coreLog.handleException(e);
                    } else {
                        responseListener.onError(e);
                    }
                }
            }

            @Override // ir.aaap.messengercore.network.Network.ResponseListener
            public void onError(Exception exc) {
                NetworkHelper.ResponseListener responseListener2 = responseListener;
                if (responseListener2 != null) {
                    responseListener2.onError(exc);
                }
            }
        };
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public void setMessengerUrl(String str) {
        this.messengerUrl = str;
        this.network.setMessengerUrl(str);
    }

    @Override // ir.aaap.messengercore.network.NetworkHelper
    public void cancelCall(int i) {
        this.network.cancelCall(i);
    }
}
