package ir.aaap.messengercore.network;

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
import java.security.PrivateKey;

/* loaded from: classes3.dex */
public interface NetworkHelper {

    public interface ResponseListener<T> {
        void onError(Exception exc);

        void onResponse(T t);
    }

    public interface VersionEncryptionHelper {
        PrivateKey getPrivateKey();

        boolean isVersion6();

        void switchToV6();
    }

    int abortSetRecoveryEmail(String str, PasswordInput passwordInput, RetryObject retryObject, ResponseListener<TwoPasscodeStatusOutput> responseListener) throws Exception;

    int abortTwoStepSetup(String str, AbortTwoStepSetupInput abortTwoStepSetupInput, RetryObject retryObject, ResponseListener<AbortTwoStepSetupOutput> responseListener) throws Exception;

    int acceptCall(String str, VoiceCallModels.AcceptCallInput acceptCallInput, RetryObject retryObject, ResponseListener<VoiceCallModels.AcceptCallOutput> responseListener) throws Exception;

    int actionOnChatAds(String str, ActionOnChatAdsInput actionOnChatAdsInput, RetryObject retryObject, ResponseListener<ActionOnChatAdsOutput> responseListener) throws Exception;

    int actionOnMessageReaction(String str, SettingModels.ActionOnMessageReactionInput actionOnMessageReactionInput, RetryObject retryObject, ResponseListener<SettingModels.ActionOnMessageReactionOutput> responseListener) throws Exception;

    int actionOnStickerSet(String str, ActionOnStickersInput actionOnStickersInput, RetryObject retryObject, ResponseListener<ActionOnStickersOutput> responseListener) throws Exception;

    int addAddressBook(String str, AddAddressBookInput addAddressBookInput, RetryObject retryObject, ResponseListener<AddAddressBookOutput> responseListener) throws Exception;

    int addChannel(String str, AddChannelInput addChannelInput, RetryObject retryObject, ResponseListener<AddOrEditChannelOutput> responseListener) throws Exception;

    int addChannelMembers(String str, AddChannelMembersInput addChannelMembersInput, RetryObject retryObject, ResponseListener<AddChannelMembersOutput> responseListener) throws Exception;

    int addFolder(String str, AddOrEditFolderInput addOrEditFolderInput, RetryObject retryObject, ResponseListener<ChangeFolderOutput> responseListener) throws Exception;

    int addGroup(String str, AddGroupInput addGroupInput, RetryObject retryObject, ResponseListener<AddOrEditGroupOutput> responseListener) throws Exception;

    int addGroupMembers(String str, AddGroupMembersInput addGroupMembersInput, RetryObject retryObject, ResponseListener<AddGroupMembersOutput> responseListener) throws Exception;

    int addLiveComment(String str, LiveModels.AddLiveCommentInput addLiveCommentInput, RetryObject retryObject, ResponseListener<LiveModels.AddLiveCommentOutput> responseListener) throws Exception;

    int addToMyGifSet(String str, AddToMyGifSetInput addToMyGifSetInput, RetryObject retryObject, ResponseListener<AddToMyGifSetOutput> responseListener) throws Exception;

    int addWallpaperSetThemeBackground(String str, SettingModels.AddWallpaperSetThemeBackgroundInput addWallpaperSetThemeBackgroundInput, RetryObject retryObject, ResponseListener<SettingModels.AddWallpaperSetThemeBackgroundOutput> responseListener) throws Exception;

    int banChannelMember(String str, BanChannelMemberInput banChannelMemberInput, RetryObject retryObject, ResponseListener<BanChannelMemberOutput> responseListener) throws Exception;

    int banGroupMember(String str, BanGroupMemberInput banGroupMemberInput, RetryObject retryObject, ResponseListener<BanGroupMemberOutput> responseListener) throws Exception;

    int callStarted(String str, VoiceCallModels.CallStartedInput callStartedInput, RetryObject retryObject, ResponseListener<VoiceCallModels.CallStartedOutput> responseListener) throws Exception;

    void cancelCall(int i);

    int cancelChangeObjectOwner(String str, ChangeOwnerModels.CancelChangeOwnerInput cancelChangeOwnerInput, RetryObject retryObject, ResponseListener<ChangeOwnerModels.CancelChangeOwnerOutput> responseListener) throws Exception;

    int changePassword(String str, ChangePasswordInput changePasswordInput, RetryObject retryObject, ResponseListener<TwoPasscodeStatusOutput> responseListener) throws Exception;

    int channelPreviewByJoinLink(String str, ChannelPreviewByJoinLinkInput channelPreviewByJoinLinkInput, RetryObject retryObject, ResponseListener<ChannelPreviewByJoinLinkOutput> responseListener) throws Exception;

    int checkChannelUsername(String str, CheckUsernameInput checkUsernameInput, RetryObject retryObject, ResponseListener<CheckUsernameOutput> responseListener) throws Exception;

    int checkChannelsWithUsername(String str, CheckChannelsWithUsernameInput checkChannelsWithUsernameInput, RetryObject retryObject, ResponseListener<CheckChannelsWithUsernameOutput> responseListener) throws Exception;

    int checkRubinoUsername(String str, CheckUsernameInput checkUsernameInput, RetryObject retryObject, ResponseListener<CheckUsernameOutput> responseListener) throws Exception;

    int checkTwoStepPasscode(String str, PasswordInput passwordInput, RetryObject retryObject, ResponseListener<CheckTwoStepPasscodeOutput> responseListener) throws Exception;

    int checkUserUsername(String str, CheckUsernameInput checkUsernameInput, RetryObject retryObject, ResponseListener<CheckUsernameOutput> responseListener) throws Exception;

    int clickMessageUrl(String str, ClickMessageUrlInput clickMessageUrlInput, RetryObject retryObject, ResponseListener<ClickMessageUrlOutput> responseListener) throws Exception;

    int createGroupVoiceChat(String str, GroupCallModels.CreateGroupVoiceChatInput createGroupVoiceChatInput, RetryObject retryObject, ResponseListener<GroupCallModels.CreateGroupVoiceChatOutput> responseListener) throws Exception;

    int createPoll(String str, PollModels.CreatePollInput createPollInput, RetryObject retryObject, ResponseListener<SendMessageOutput> responseListener) throws Exception;

    int deleteAvatar(String str, DeleteAvatarInput deleteAvatarInput, RetryObject retryObject, ResponseListener<UploadOrDeleteAvatarOutput> responseListener) throws Exception;

    int deleteBotChat(String str, BotModels.DeleteBotChatInput deleteBotChatInput, RetryObject retryObject, ResponseListener<DeleteChatOutput> responseListener) throws Exception;

    int deleteChatHistory(String str, DeleteChatHistoryInput deleteChatHistoryInput, RetryObject retryObject, ResponseListener<DeleteChatOutput> responseListener) throws Exception;

    int deleteContact(String str, DeleteContactInput deleteContactInput, RetryObject retryObject, ResponseListener<DeleteContactOutput> responseListener) throws Exception;

    int deleteFolder(String str, DeleteFolderInput deleteFolderInput, RetryObject retryObject, ResponseListener<ChangeFolderOutput> responseListener) throws Exception;

    int deleteMessages(String str, DeleteMessagesInput deleteMessagesInput, RetryObject retryObject, ResponseListener<DeleteMessagesOutput> responseListener) throws Exception;

    int deleteNoAccessGroupChat(String str, LeaveGroupInput leaveGroupInput, RetryObject retryObject, ResponseListener<LeaveGroupOutput> responseListener) throws Exception;

    int deleteServiceChat(String str, DeleteServiceChatInput deleteServiceChatInput, RetryObject retryObject, ResponseListener<DeleteChatOutput> responseListener) throws Exception;

    int deleteUserChat(String str, DeleteUserChatInput deleteUserChatInput, RetryObject retryObject, ResponseListener<DeleteChatOutput> responseListener) throws Exception;

    int disableTwoStepByForgetPassword(String str, DisableTwoStepByForgetPasswordInput disableTwoStepByForgetPasswordInput, RetryObject retryObject, ResponseListener<DisableTwoStepByForgetPasswordOutput> responseListener) throws Exception;

    int discardCall(String str, VoiceCallModels.DiscardCallInput discardCallInput, RetryObject retryObject, ResponseListener<VoiceCallModels.DiscardCallOutput> responseListener) throws Exception;

    int discardGroupVoiceChat(String str, GroupCallModels.DiscardGroupVoiceChatInput discardGroupVoiceChatInput, RetryObject retryObject, ResponseListener<GroupCallModels.DiscardGroupVoiceChatOutput> responseListener) throws Exception;

    int editChannelInfo(String str, EditChannelInput editChannelInput, RetryObject retryObject, ResponseListener<AddOrEditChannelOutput> responseListener) throws Exception;

    int editFolder(String str, AddOrEditFolderInput addOrEditFolderInput, RetryObject retryObject, ResponseListener<ChangeFolderOutput> responseListener) throws Exception;

    int editGroupInfo(String str, EditGroupInfoInput editGroupInfoInput, RetryObject retryObject, ResponseListener<AddOrEditGroupOutput> responseListener) throws Exception;

    int editMessage(String str, EditMessageInput editMessageInput, RetryObject retryObject, ResponseListener<EditMessagesOutput> responseListener) throws Exception;

    int forwardMessages(String str, ForwardMessageInput forwardMessageInput, RetryObject retryObject, ResponseListener<SendMessageOutput> responseListener) throws Exception;

    void getAbsObjects(String str, GetAbsObjectsInput getAbsObjectsInput, RetryObject retryObject, ResponseListener<GetAbsObjectsOutput> responseListener) throws Exception;

    int getAllStatistics(String str, GetAllStatisticsInput getAllStatisticsInput, RetryObject retryObject, ResponseListener<GetAllStatisticsOutput> responseListener) throws Exception;

    int getAvailableReactions(String str, SettingModels.GetAvailableReactionsInput getAvailableReactionsInput, RetryObject retryObject, ResponseListener<SettingModels.GetAvailableReactionsOutput> responseListener) throws Exception;

    int getAvatars(String str, GetAvatarsInput getAvatarsInput, RetryObject retryObject, ResponseListener<GetAvatarsOutput> responseListener) throws Exception;

    int getBannedChannelMembers(String str, GetChannelMembersInput getChannelMembersInput, RetryObject retryObject, ResponseListener<GetChannelMembersOutput> responseListener) throws Exception;

    int getBannedGroupMembers(String str, GetGroupMembersInput getGroupMembersInput, RetryObject retryObject, ResponseListener<GetGroupMembersOutput> responseListener) throws Exception;

    int getBlockedUsers(String str, GetBlockedUsersInput getBlockedUsersInput, RetryObject retryObject, ResponseListener<GetBlockedUsersOutput> responseListener) throws Exception;

    int getBotInfo(String str, GetBotInfoInput getBotInfoInput, RetryObject retryObject, ResponseListener<GetBotInfoOutput> responseListener) throws Exception;

    int getCalls(String str, VoiceCallModels.GetCallsInput getCallsInput, RetryObject retryObject, ResponseListener<VoiceCallModels.GetCallsOutput> responseListener) throws Exception;

    int getChannelAdminAccessList(String str, GetChannelAdminAccessInput getChannelAdminAccessInput, RetryObject retryObject, ResponseListener<GetChannelAdminAccessListOutput> responseListener) throws Exception;

    int getChannelAdminMembers(String str, GetChannelMembersInput getChannelMembersInput, RetryObject retryObject, ResponseListener<GetChannelMembersOutput> responseListener) throws Exception;

    int getChannelAllMembers(String str, GetChannelMembersInput getChannelMembersInput, RetryObject retryObject, ResponseListener<GetChannelMembersOutput> responseListener) throws Exception;

    int getChannelInfo(String str, GetChannelInfoInput getChannelInfoInput, RetryObject retryObject, ResponseListener<GetChannelInfoOutput> responseListener) throws Exception;

    int getChannelLink(String str, GetChannelLinkInput getChannelLinkInput, RetryObject retryObject, ResponseListener<GetChannelLinkOutput> responseListener) throws Exception;

    int getChannelSeenCount(String str, GetChannelSeenCountInput getChannelSeenCountInput, RetryObject retryObject, ResponseListener<GetChannelSeenCountOutput> responseListener) throws Exception;

    int getChatAds(String str, GetChatAdsInput getChatAdsInput, RetryObject retryObject, ResponseListener<GetChatAdsOutput> responseListener) throws Exception;

    int getChatReaction(String str, SettingModels.GetChatReactionInput getChatReactionInput, RetryObject retryObject, ResponseListener<SettingModels.GetChatReactionOutput> responseListener) throws Exception;

    int getChats(String str, GetChatsInput getChatsInput, RetryObject retryObject, ResponseListener<GetChatsOutput> responseListener) throws Exception;

    int getChatsByID(String str, GetChatsByIDInput getChatsByIDInput, RetryObject retryObject, ResponseListener<GetChatByIDOutput> responseListener) throws Exception;

    int getChatsUpdates(String str, GetChatsUpdatesInput getChatsUpdatesInput, RetryObject retryObject, ResponseListener<GetChatsUpdatesOutput> responseListener) throws Exception;

    int getCommonGroups(String str, GetCommonGroupsInput getCommonGroupsInput, RetryObject retryObject, ResponseListener<GetCommonGroupsOutput> responseListener) throws Exception;

    int getContacts(String str, GetContactInput getContactInput, RetryObject retryObject, ResponseListener<GetContactOutput> responseListener) throws Exception;

    int getContactsLastOnline(String str, GetContactsLastOnlineInput getContactsLastOnlineInput, RetryObject retryObject, ResponseListener<GetContactsLastOnlineOutput> responseListener) throws Exception;

    int getContactsUpdates(String str, GetContactUpdateInput getContactUpdateInput, RetryObject retryObject, ResponseListener<GetContactUpdateOutput> responseListener) throws Exception;

    int getCurrentLiveLocation(String str, LiveLocationInput liveLocationInput, RetryObject retryObject, ResponseListener<LiveLocationOutput> responseListener) throws Exception;

    int getDCs(String str, String str2, RetryObject retryObject, ResponseListener<GetDcsOutput> responseListener) throws Exception;

    String getDefaultDcMessUrl();

    String getDefaultMessengerUrl();

    String getDefaultSocketUrl();

    int getDeviceSetting(String str, SettingModels.SettingInput settingInput, RetryObject retryObject, ResponseListener<SettingModels.GetDeviceSettingOutput> responseListener) throws Exception;

    int getDisplayAsInGroupVoiceChat(String str, GroupCallModels.GetDisplayAsInGroupVoiceChatInput getDisplayAsInGroupVoiceChatInput, RetryObject retryObject, ResponseListener<GroupCallModels.GetDisplayAsInGroupVoiceChatOutput> responseListener) throws Exception;

    int getExternalFile(String str, String str2, RetryObject retryObject, ResponseListener<GetFileResult> responseListener) throws Exception;

    int getFile(String str, String str2, GetFileInput getFileInput, RetryObject retryObject, ResponseListener<GetFileResult> responseListener) throws Exception;

    int getFileCdn(String str, String str2, String str3, GetFileInput getFileInput, RetryObject retryObject, ResponseListener<GetFileResult> responseListener) throws Exception;

    int getFolders(String str, GetFoldersInput getFoldersInput, RetryObject retryObject, ResponseListener<GetFoldersOutput> responseListener) throws Exception;

    int getGroupAdminAccessList(String str, GetGroupAdminAccessListInput getGroupAdminAccessListInput, RetryObject retryObject, ResponseListener<GetGroupAdminAccessListOutput> responseListener) throws Exception;

    int getGroupAdminMembers(String str, GetGroupMembersInput getGroupMembersInput, RetryObject retryObject, ResponseListener<GetGroupMembersOutput> responseListener) throws Exception;

    int getGroupAllMembers(String str, GetGroupMembersInput getGroupMembersInput, RetryObject retryObject, ResponseListener<GetGroupMembersOutput> responseListener) throws Exception;

    int getGroupDefaultAccess(String str, GetGroupDefaultAccessInput getGroupDefaultAccessInput, RetryObject retryObject, ResponseListener<GetGroupDefaultAccessOutput> responseListener) throws Exception;

    int getGroupInfo(String str, GetGroupInfoInput getGroupInfoInput, RetryObject retryObject, ResponseListener<GetGroupInfoOutput> responseListener) throws Exception;

    int getGroupLink(String str, GetGroupLinkInput getGroupLinkInput, RetryObject retryObject, ResponseListener<GetGroupLinkOutput> responseListener) throws Exception;

    int getGroupMentionList(String str, GetGroupMentionListInput getGroupMentionListInput, RetryObject retryObject, ResponseListener<GetGroupMembersOutput> responseListener) throws Exception;

    int getGroupMessageReadParticipants(String str, GetGroupMessageReadParticipantsInput getGroupMessageReadParticipantsInput, RetryObject retryObject, ResponseListener<GetGroupMessageReadParticipantsOutput> responseListener) throws Exception;

    void getGroupOnlineCount(String str, GetGroupOnlineCountInput getGroupOnlineCountInput, RetryObject retryObject, ResponseListener<GetGroupOnlineCountOutput> responseListener) throws Exception;

    int getGroupVoiceChat(String str, GroupCallModels.GetGroupVoiceChatInput getGroupVoiceChatInput, RetryObject retryObject, ResponseListener<GroupCallModels.GetGroupVoiceChatOutput> responseListener) throws Exception;

    int getGroupVoiceChatParticipants(String str, GroupCallModels.GetGroupVoiceChatParticipantsInput getGroupVoiceChatParticipantsInput, RetryObject retryObject, ResponseListener<GroupCallModels.GetGroupVoiceChatParticipantsOutput> responseListener) throws Exception;

    int getGroupVoiceChatParticipantsByObjectGuids(String str, GroupCallModels.GetGroupVoiceChatParticipantsByObjectGuidsInput getGroupVoiceChatParticipantsByObjectGuidsInput, RetryObject retryObject, ResponseListener<GroupCallModels.GetGroupVoiceChatParticipantsByObjectGuidsOutput> responseListener) throws Exception;

    int getGroupVoiceChatUpdates(String str, GroupCallModels.GetGroupVoiceChatUpdatesInput getGroupVoiceChatUpdatesInput, RetryObject retryObject, ResponseListener<GroupCallModels.GetGroupVoiceChatUpdatesOutput> responseListener) throws Exception;

    int getLinkFromAppUrl(String str, GetLinkFromAppUrlInput getLinkFromAppUrlInput, RetryObject retryObject, ResponseListener<GetLinkFromAppUrlOutput> responseListener) throws Exception;

    int getLiveComments(String str, LiveModels.GetLiveCommentsInput getLiveCommentsInput, RetryObject retryObject, ResponseListener<LiveModels.GetLiveCommentsOutput> responseListener) throws Exception;

    int getLivePlayUrl(String str, LiveModels.GetLivePlayUrlInput getLivePlayUrlInput, RetryObject retryObject, ResponseListener<LiveModels.GetLivePlayUrlOutput> responseListener) throws Exception;

    int getLiveStatus(String str, LiveModels.GetLiveStatusInput getLiveStatusInput, RetryObject retryObject, ResponseListener<LiveModels.GetLiveStatusOutput> responseListener) throws Exception;

    int getLiveViewers(String str, LiveModels.GetLiveViewersInput getLiveViewersInput, RetryObject retryObject, ResponseListener<LiveModels.GetLiveViewersOutput> responseListener) throws Exception;

    int getMapView(String str, GetMapViewInput getMapViewInput, RetryObject retryObject, ResponseListener<GetMapViewOutput> responseListener) throws Exception;

    int getMessageReactions(String str, SettingModels.GetMessageReactionsInput getMessageReactionsInput, RetryObject retryObject, ResponseListener<SettingModels.GetMessageReactionsOutput> responseListener) throws Exception;

    void getMessageShareUrl(String str, GetMessageShareUrlInput getMessageShareUrlInput, RetryObject retryObject, ResponseListener<GetMessageShareUrlOutput> responseListener) throws Exception;

    void getMessages(String str, GetMessagesInput getMessagesInput, RetryObject retryObject, ResponseListener<GetMessagesOutput> responseListener) throws Exception;

    int getMessagesByID(String str, GetMessagesByIdInput getMessagesByIdInput, RetryObject retryObject, ResponseListener<GetMessagesByIdOutput> responseListener) throws Exception;

    void getMessagesInterval(String str, GetMessagesInput getMessagesInput, RetryObject retryObject, ResponseListener<GetMessagesIntervalOutput> responseListener) throws Exception;

    int getMessagesUpdates(String str, GetMessagesUpdatesInput getMessagesUpdatesInput, RetryObject retryObject, ResponseListener<GetMessagesUpdatesOutput> responseListener) throws Exception;

    int getMyArchivedStickerSets(String str, GetStickersInput getStickersInput, RetryObject retryObject, ResponseListener<GetStickersOutput> responseListener) throws Exception;

    int getMyGifSet(String str, GetMyGifSetInput getMyGifSetInput, RetryObject retryObject, ResponseListener<GetMyGifSetOutput> responseListener) throws Exception;

    int getMySessions(String str, GetMySessionsInput getMySessionsInput, RetryObject retryObject, ResponseListener<GetMySessionsOutput> responseListener) throws Exception;

    int getMyStickerSets(String str, GetMyStickerSetsInput getMyStickerSetsInput, RetryObject retryObject, ResponseListener<GetStickersOutput> responseListener) throws Exception;

    int getObjectByUsername(String str, GetObjectByUsernameInput getObjectByUsernameInput, RetryObject retryObject, ResponseListener<GetObjectByUsernameOutput> responseListener) throws Exception;

    int getPendingObjectOwner(String str, ChangeOwnerModels.GetPendingObjectOwnerInput getPendingObjectOwnerInput, RetryObject retryObject, ResponseListener<ChangeOwnerModels.GetPendingObjectOwnerOutput> responseListener) throws Exception;

    int getPollOptionVoters(String str, PollModels.GetPollOptionVotersInput getPollOptionVotersInput, RetryObject retryObject, ResponseListener<PollModels.GetPollOptionVotersOutput> responseListener) throws Exception;

    int getPollStatus(String str, PollModels.GetPollStatusInput getPollStatusInput, RetryObject retryObject, ResponseListener<PollModels.PollOutput> responseListener) throws Exception;

    int getPrivacySetting(String str, SettingModels.SettingInput settingInput, RetryObject retryObject, ResponseListener<SettingModels.GetPrivacySettingOutput> responseListener) throws Exception;

    int getProfileLinkItems(String str, GetProfileLinkItemsInput getProfileLinkItemsInput, RetryObject retryObject, ResponseListener<GetProfileLinkItemsOutputs> responseListener) throws Exception;

    int getSelection(String str, String str2, BotModels.GetBotSelectionInput getBotSelectionInput, RetryObject retryObject, ResponseListener<BotModels.GetBotSelectionOutput> responseListener) throws Exception;

    int getServiceInfo(String str, GetServiceInfoInput getServiceInfoInput, RetryObject retryObject, ResponseListener<GetServiceInfoOutput> responseListener) throws Exception;

    int getSignalingData(String str, VoiceCallModels.GetSignalingDataInput getSignalingDataInput, RetryObject retryObject, ResponseListener<VoiceCallModels.GetSignalingDataOutput> responseListener) throws Exception;

    int getStickerSetByID(String str, GetStickerSetByIdInput getStickerSetByIdInput, RetryObject retryObject, ResponseListener<GetStickerSetByIdOutput> responseListener) throws Exception;

    int getStickerSetting(String str, SettingModels.SettingInput settingInput, RetryObject retryObject, ResponseListener<SettingModels.GetStickersSettingOutput> responseListener) throws Exception;

    int getStickersByEmoji(String str, GetStickersByEmojiInput getStickersByEmojiInput, RetryObject retryObject, ResponseListener<GetStickersByEmojiOutput> responseListener) throws Exception;

    int getStickersBySetIDs(String str, GetStickersBySetIDsInput getStickersBySetIDsInput, RetryObject retryObject, ResponseListener<GetStickersBySetIDsOutput> responseListener) throws Exception;

    int getSuggestedFolders(String str, GetSuggestedFoldersInput getSuggestedFoldersInput, RetryObject retryObject, ResponseListener<GetSuggestedFoldersOutput> responseListener) throws Exception;

    int getThemes(String str, SettingModels.SettingInput settingInput, RetryObject retryObject, ResponseListener<SettingModels.GetThemesOutput> responseListener) throws Exception;

    void getTime(String str, GetTimeInput getTimeInput, RetryObject retryObject, ResponseListener<GetTimeOutput> responseListener) throws Exception;

    int getTopChatUsers(String str, GetTopChatUsersInput getTopChatUsersInput, RetryObject retryObject, ResponseListener<GetTopChatUsersOutput> responseListener) throws Exception;

    int getTrendStickerSets(String str, GetStickersInput getStickersInput, RetryObject retryObject, ResponseListener<GetStickersOutput> responseListener) throws Exception;

    int getTwoPasscodeStatus(String str, GetTwoPasscodeStatusInput getTwoPasscodeStatusInput, RetryObject retryObject, ResponseListener<TwoPasscodeStatusOutput> responseListener) throws Exception;

    int getUpdate(String str, GetUpdateInput getUpdateInput, RetryObject retryObject, ResponseListener<GetUpdateOutput> responseListener) throws Exception;

    int getUserInfo(String str, GetUserInfoInput getUserInfoInput, RetryObject retryObject, ResponseListener<GetUserInfoOutput> responseListener) throws Exception;

    int getUserSetting(String str, SettingModels.SettingInput settingInput, RetryObject retryObject, ResponseListener<SettingModels.GetUserSettingOutput> responseListener) throws Exception;

    int getWalletTransferMessage(String str, GetWalletTransactionMessageInput getWalletTransactionMessageInput, RetryObject retryObject, ResponseListener<GetWalletTransactionMessageOutput> responseListener) throws Exception;

    int getWallpapers(String str, SettingModels.SettingInput settingInput, RetryObject retryObject, ResponseListener<SettingModels.WallpapersOutput> responseListener) throws Exception;

    int groupPreviewByJoinLink(String str, GroupPreviewByJoinLinkInput groupPreviewByJoinLinkInput, RetryObject retryObject, ResponseListener<GroupPreviewByJoinLinkOutput> responseListener) throws Exception;

    int importAddressBook(String str, ImportAddressBookInput importAddressBookInput, RetryObject retryObject, ResponseListener<ImportAddressBookOutput> responseListener) throws Exception;

    void init(String str);

    int joinChannelAction(String str, JoinChannelActionInput joinChannelActionInput, RetryObject retryObject, ResponseListener<JoinChannelActionOutput> responseListener) throws Exception;

    int joinChannelByLink(String str, JoinChannelByLinkInput joinChannelByLinkInput, RetryObject retryObject, ResponseListener<JoinChannelByLinkOutput> responseListener) throws Exception;

    int joinGroup(String str, JoinGroupInput joinGroupInput, RetryObject retryObject, ResponseListener<JoinGroupOutput> responseListener) throws Exception;

    int joinGroupVoiceChat(String str, GroupCallModels.JoinGroupVoiceChatInput joinGroupVoiceChatInput, RetryObject retryObject, ResponseListener<GroupCallModels.JoinGroupVoiceChatOutput> responseListener) throws Exception;

    int leaveGroup(String str, LeaveGroupInput leaveGroupInput, RetryObject retryObject, ResponseListener<LeaveGroupOutput> responseListener) throws Exception;

    int leaveGroupVoiceChat(String str, GroupCallModels.LeaveGroupVoiceChatInput leaveGroupVoiceChatInput, RetryObject retryObject, ResponseListener<GroupCallModels.LeaveGroupVoiceChatOutput> responseListener) throws Exception;

    int loginDisableTwoStep(String str, LoginDisableTwoStepInput loginDisableTwoStepInput, RetryObject retryObject, ResponseListener<LoginDisableTwoStepOutput> responseListener) throws Exception;

    int loginTwoStepForgetPassword(String str, LoginTwoStepForgetPasswordInput loginTwoStepForgetPasswordInput, RetryObject retryObject, ResponseListener<LoginTwoStepForgetPasswordOutput> responseListener) throws Exception;

    int logout(String str, LogoutInput logoutInput, RetryObject retryObject, ResponseListener<LogoutOutput> responseListener) throws Exception;

    int rateCall(String str, VoiceCallModels.RateCallInput rateCallInput, RetryObject retryObject, ResponseListener<VoiceCallModels.RateCallOutput> responseListener) throws Exception;

    int receivedCall(String str, VoiceCallModels.ReceivedCallInput receivedCallInput, RetryObject retryObject, ResponseListener<VoiceCallModels.ReceivedCallOutput> responseListener) throws Exception;

    int registerDevice(String str, RegisterDeviceInput registerDeviceInput, RetryObject retryObject, ResponseListener<RegisterDeviceOutput> responseListener) throws Exception;

    int removeChannel(String str, RemoveChannelInput removeChannelInput, RetryObject retryObject, ResponseListener<RemoveGroupOrChannelOutput> responseListener) throws Exception;

    int removeFromMyGifSet(String str, RemoveFromMyGifSetInput removeFromMyGifSetInput, RetryObject retryObject, ResponseListener<RemoveFromMyGifSetOutput> responseListener) throws Exception;

    int removeFromTopChatUsers(String str, RemoveFromTopChatUsersInput removeFromTopChatUsersInput, RetryObject retryObject, ResponseListener<RemoveFromTopChatUsersOutput> responseListener) throws Exception;

    int removeGroup(String str, RemoveGroupInput removeGroupInput, RetryObject retryObject, ResponseListener<RemoveGroupOrChannelOutput> responseListener) throws Exception;

    int reorderFolder(String str, ReorderFolderInput reorderFolderInput, RetryObject retryObject, ResponseListener<ChangeFolderOutput> responseListener) throws Exception;

    int reorderStickerSets(String str, ReorderStickerSetsInput reorderStickerSetsInput, RetryObject retryObject, ResponseListener<ReorderStickerSetsOutput> responseListener) throws Exception;

    int replyRequestObjectOwner(String str, ChangeOwnerModels.ReplyRequestObjectOwnerInput replyRequestObjectOwnerInput, RetryObject retryObject, ResponseListener<ChangeOwnerModels.ReplyRequestObjectOwnerOutput> responseListener) throws Exception;

    int reportObject(String str, ReportObjectInput reportObjectInput, RetryObject retryObject, ResponseListener<ReportObjectOutput> responseListener) throws Exception;

    int requestCall(String str, VoiceCallModels.RequestCallInput requestCallInput, RetryObject retryObject, ResponseListener<VoiceCallModels.RequestCallOutput> responseListener) throws Exception;

    int requestChangeObjectOwner(String str, ChangeOwnerModels.RequestChangeOwnerInput requestChangeOwnerInput, RetryObject retryObject, ResponseListener<ChangeOwnerModels.RequestChangeOwnerOutput> responseListener) throws Exception;

    int requestChangePhoneNumber(String str, RequestChangePhoneNumberInput requestChangePhoneNumberInput, RetryObject retryObject, ResponseListener<RequestChangePhoneNumberOutput> responseListener) throws Exception;

    int requestDeleteAccount(String str, RequestDeleteAccountInput requestDeleteAccountInput, RetryObject retryObject, ResponseListener<RequestDeleteAccountOutput> responseListener) throws Exception;

    int requestForgetPassword(String str, RequestForgetPasswordInput requestForgetPasswordInput, RetryObject retryObject, ResponseListener<RequestForgetPasswordOutput> responseListener) throws Exception;

    int requestRecoveryEmail(String str, RequestRecoveryEmailInput requestRecoveryEmailInput, RetryObject retryObject, ResponseListener<TwoPasscodeStatusOutput> responseListener) throws Exception;

    int requestSendFile(String str, RequestSendFileInput requestSendFileInput, RetryObject retryObject, ResponseListener<RequestSendFileOutput> responseListener) throws Exception;

    int resendCodeRecoveryEmail(String str, PasswordInput passwordInput, RetryObject retryObject, ResponseListener<ResendCodeRecoveryEmailOutput> responseListener) throws Exception;

    int resetContacts(String str, ResetContactsInput resetContactsInput, RetryObject retryObject, ResponseListener<ResetContactsOutput> responseListener) throws Exception;

    int resetWallpapers(String str, SettingModels.SettingInput settingInput, RetryObject retryObject, ResponseListener<SettingModels.WallpapersOutput> responseListener) throws Exception;

    int searchChatMessages(String str, SearchChatMessagesInput searchChatMessagesInput, RetryObject retryObject, ResponseListener<SearchChatMessagesOutput> responseListener) throws Exception;

    int searchGlobalMessages(String str, SearchGlobalMessagesInput searchGlobalMessagesInput, RetryObject retryObject, ResponseListener<SearchGlobalMessagesOutput> responseListener) throws Exception;

    int searchGlobalObjects(String str, SearchGlobalObjectsInput searchGlobalObjectsInput, RetryObject retryObject, ResponseListener<SearchGlobalObjectsOutput> responseListener) throws Exception;

    int searchSelection(String str, String str2, BotModels.SearchBotSelectionInput searchBotSelectionInput, RetryObject retryObject, ResponseListener<BotModels.SearchBotSelectionOutput> responseListener) throws Exception;

    int searchStickers(String str, GetStickersInput getStickersInput, RetryObject retryObject, ResponseListener<GetStickersOutput> responseListener) throws Exception;

    int seenChannelMessages(String str, SeenChannelMessagesInput seenChannelMessagesInput, RetryObject retryObject, ResponseListener<SeenChannelMessagesOutput> responseListener) throws Exception;

    void seenChats(String str, SeenChatsInput seenChatsInput, RetryObject retryObject, ResponseListener<SeenChatsOutput> responseListener) throws Exception;

    int sendChatActivity(String str, SendChatActivityInput sendChatActivityInput, RetryObject retryObject, ResponseListener<SendChatActivityOutput> responseListener) throws Exception;

    int sendCode(String str, SendCodeInput sendCodeInput, RetryObject retryObject, ResponseListener<SendCodeOutput> responseListener) throws Exception;

    int sendFile(String str, String str2, SendFileInput sendFileInput, RetryObject retryObject, ResponseListener<SendFileOutput> responseListener) throws Exception;

    int sendGroupVoiceChatActivity(String str, GroupCallModels.SendGroupVoiceChatActivityInput sendGroupVoiceChatActivityInput, RetryObject retryObject, ResponseListener<GroupCallModels.SendGroupVoiceChatActivityOutput> responseListener) throws Exception;

    int sendLive(String str, LiveModels.SendLiveInput sendLiveInput, RetryObject retryObject, ResponseListener<LiveModels.SendLiveOutput> responseListener) throws Exception;

    int sendMessage(String str, SendMessageInput sendMessageInput, RetryObject retryObject, ResponseListener<SendMessageOutput> responseListener) throws Exception;

    int sendMessageAPICall(String str, String str2, BotModels.SendMessageApiCallInput sendMessageApiCallInput, RetryObject retryObject, ResponseListener<BotModels.SendMessageApiCallOutput> responseListener) throws Exception;

    int sendProductMessage(String str, SendProductMessageInput sendProductMessageInput, RetryObject retryObject, ResponseListener<SendMessageOutput> responseListener) throws Exception;

    int sendRubinoPost(String str, SendRubinoPostInput sendRubinoPostInput, RetryObject retryObject, ResponseListener<SendMessageOutput> responseListener) throws Exception;

    int sendRubinoStory(String str, SendRubinoStoryInput sendRubinoStoryInput, RetryObject retryObject, ResponseListener<SendMessageOutput> responseListener) throws Exception;

    int sendSignalingData(String str, VoiceCallModels.SendSignalDataInput sendSignalDataInput, RetryObject retryObject, ResponseListener<VoiceCallModels.SendSignalDataOutput> responseListener) throws Exception;

    int sendWalletTransferMessage(String str, SendWalletTransactionMessageInput sendWalletTransactionMessageInput, RetryObject retryObject, ResponseListener<SendMessageOutput> responseListener) throws Exception;

    int setActionChat(String str, SetChatActionInput setChatActionInput, RetryObject retryObject, ResponseListener<SetChatActionOutput> responseListener) throws Exception;

    int setAskSpamAction(String str, SetAskSpamActionInput setAskSpamActionInput, RetryObject retryObject, ResponseListener<SetAskSpamActionOutput> responseListener) throws Exception;

    int setBlockUser(String str, SetBlockUserInput setBlockUserInput, RetryObject retryObject, ResponseListener<SetBlockUserOutput> responseListener) throws Exception;

    int setChannelAdmin(String str, SetChannelAdminInput setChannelAdminInput, RetryObject retryObject, ResponseListener<SetChannelAdminOutput> responseListener) throws Exception;

    int setChannelBotAdmin(String str, SetChannelBotAdminInput setChannelBotAdminInput, RetryObject retryObject, ResponseListener<SetChannelBotAdminOutput> responseListener) throws Exception;

    int setChannelLink(String str, SetChannelLinkInput setChannelLinkInput, RetryObject retryObject, ResponseListener<SetChannelLinkOutput> responseListener) throws Exception;

    int setChatUseTime(String str, SetChatUseTimeInput setChatUseTimeInput, RetryObject retryObject, ResponseListener<SetChatUseTimeOutput> responseListener) throws Exception;

    int setCurrentLiveLocation(String str, SetCurrentLiveLocationInput setCurrentLiveLocationInput, RetryObject retryObject, ResponseListener<SetCurrentLiveLocationOutput> responseListener) throws Exception;

    int setGroupAdmin(String str, SetGroupAdminInput setGroupAdminInput, RetryObject retryObject, ResponseListener<SetGroupAdminOutput> responseListener) throws Exception;

    int setGroupDefaultAccess(String str, SetGroupDefaultAccessInput setGroupDefaultAccessInput, RetryObject retryObject, ResponseListener<SetGroupDefaultAccessOutput> responseListener) throws Exception;

    int setGroupLink(String str, SetGroupLinkInput setGroupLinkInput, RetryObject retryObject, ResponseListener<SetGroupLinkOutput> responseListener) throws Exception;

    int setGroupVoiceChatSetting(String str, GroupCallModels.SetGroupVoiceChatSettingInput setGroupVoiceChatSettingInput, RetryObject retryObject, ResponseListener<GroupCallModels.SetGroupVoiceChatSettingOutput> responseListener) throws Exception;

    int setGroupVoiceChatState(String str, GroupCallModels.SetGroupVoiceChatStateInput setGroupVoiceChatStateInput, RetryObject retryObject, ResponseListener<GroupCallModels.SetGroupVoiceChatStateOutput> responseListener) throws Exception;

    int setLiveSetting(String str, LiveModels.SetLiveSettingInput setLiveSettingInput, RetryObject retryObject, ResponseListener<LiveModels.SetLiveSettingOutput> responseListener) throws Exception;

    void setMessengerUrl(String str);

    void setNetworkErrorListener(Network.NetworkErrorListener networkErrorListener);

    int setPinChatInFolder(String str, SetPinChatInFolderInput setPinChatInFolderInput, RetryObject retryObject, ResponseListener<ChangeFolderOutput> responseListener) throws Exception;

    int setPinMessage(String str, SetPinMessageInput setPinMessageInput, RetryObject retryObject, ResponseListener<SetPinMessageOutput> responseListener) throws Exception;

    int setPollAction(String str, PollModels.SetPollActionInput setPollActionInput, RetryObject retryObject, ResponseListener<PollModels.PollOutput> responseListener) throws Exception;

    int setPublicKey(String str, SetPublicKeyInput setPublicKeyInput, RetryObject retryObject, ResponseListener<SetPublicKeyOutput> responseListener) throws Exception;

    int setSetting(String str, SettingModels.SetSettingInput setSettingInput, RetryObject retryObject, ResponseListener<SettingModels.SetSettingOutput> responseListener) throws Exception;

    void setVersionEncryptionHelper(VersionEncryptionHelper versionEncryptionHelper);

    int setupTwoStepVerification(String str, SetupTwoStepVerificationInput setupTwoStepVerificationInput, RetryObject retryObject, ResponseListener<TwoPasscodeStatusOutput> responseListener) throws Exception;

    int signIn(String str, SignInInput signInInput, RetryObject retryObject, ResponseListener<SignInOutput> responseListener) throws Exception;

    int stopBot(String str, BotModels.StopBotInput stopBotInput, RetryObject retryObject, ResponseListener<BotModels.StopBotOutput> responseListener) throws Exception;

    int stopLive(String str, LiveModels.StopLiveInput stopLiveInput, RetryObject retryObject, ResponseListener<LiveModels.StopLiveOutput> responseListener) throws Exception;

    int stopLiveLocation(String str, LiveLocationInput liveLocationInput, RetryObject retryObject, ResponseListener<LiveLocationOutput> responseListener) throws Exception;

    int terminateOtherSessions(String str, TerminateOtherSessionInput terminateOtherSessionInput, RetryObject retryObject, ResponseListener<TerminateOtherSessionOutput> responseListener) throws Exception;

    int terminateSession(String str, TerminateSessionInput terminateSessionInput, RetryObject retryObject, ResponseListener<TerminateSessionOutput> responseListener) throws Exception;

    int turnOffTwoStep(String str, TurnOffTwoStepInput turnOffTwoStepInput, RetryObject retryObject, ResponseListener<TurnOffTwoStepOutput> responseListener) throws Exception;

    int updateChannelUsername(String str, UpdateChannelUsernameInput updateChannelUsernameInput, RetryObject retryObject, ResponseListener<UpdateChannelUsernameOutput> responseListener) throws Exception;

    int updateProfile(String str, UpdateProfileInput updateProfileInput, RetryObject retryObject, ResponseListener<UpdateProfileOutput> responseListener) throws Exception;

    int updateUserUsername(String str, UpdateUsernameInput updateUsernameInput, RetryObject retryObject, ResponseListener<UpdateUserUsernameOutput> responseListener) throws Exception;

    int uploadAvatar(String str, UploadAvatarInput uploadAvatarInput, RetryObject retryObject, ResponseListener<UploadOrDeleteAvatarOutput> responseListener) throws Exception;

    int verifyChangePhoneNumber(String str, VerifyChangePhoneNumberInput verifyChangePhoneNumberInput, RetryObject retryObject, ResponseListener<VerifyChangePhoneNumberOutput> responseListener) throws Exception;

    int verifyRecoveryEmail(String str, VerifyRecoveryEmailInput verifyRecoveryEmailInput, RetryObject retryObject, ResponseListener<VerifyRecoveryEmailOutput> responseListener) throws Exception;

    int votePoll(String str, PollModels.VotePollInput votePollInput, RetryObject retryObject, ResponseListener<PollModels.PollOutput> responseListener) throws Exception;
}
