package ai.bale.proto;

import ai.bale.proto.AbacusOuterClass$RequestLoadReactions;
import ai.bale.proto.AbacusOuterClass$RequestMessageRemoveReaction;
import ai.bale.proto.AbacusOuterClass$RequestMessageSetReaction;
import ai.bale.proto.AbacusOuterClass$ResponseLoadReactions;
import ai.bale.proto.AbacusOuterClass$ResponseReactionsResponse;
import ai.bale.proto.AdvertisementOuterClass$RequestChangeStatusDialogAdOrder;
import ai.bale.proto.AdvertisementOuterClass$RequestGetAdProvider;
import ai.bale.proto.AdvertisementOuterClass$RequestGetChannelAds;
import ai.bale.proto.AdvertisementOuterClass$RequestGetChannelEarnMoneyInfo;
import ai.bale.proto.AdvertisementOuterClass$RequestGetChannelEarnMoneyStatus;
import ai.bale.proto.AdvertisementOuterClass$RequestGetDialogAdOrderDetails;
import ai.bale.proto.AdvertisementOuterClass$RequestGetDialogAdOrderPaymentToken;
import ai.bale.proto.AdvertisementOuterClass$RequestGetUserStatus;
import ai.bale.proto.AdvertisementOuterClass$RequestRegisterForEarnMoney;
import ai.bale.proto.AdvertisementOuterClass$RequestSubmitDialogAdOrder;
import ai.bale.proto.AdvertisementOuterClass$RequestUpdateClick;
import ai.bale.proto.AdvertisementOuterClass$RequestUpdateGroupStatus;
import ai.bale.proto.AdvertisementOuterClass$RequestUpdateView;
import ai.bale.proto.AdvertisementOuterClass$ResponseGetAdProvider;
import ai.bale.proto.AdvertisementOuterClass$ResponseGetChannelAds;
import ai.bale.proto.AdvertisementOuterClass$ResponseGetChannelEarnMoneyInfo;
import ai.bale.proto.AdvertisementOuterClass$ResponseGetChannelEarnMoneyStatus;
import ai.bale.proto.AdvertisementOuterClass$ResponseGetDialogAdOrderDetails;
import ai.bale.proto.AdvertisementOuterClass$ResponseGetDialogAdOrderPaymentToken;
import ai.bale.proto.AdvertisementOuterClass$ResponseGetUserStatus;
import ai.bale.proto.AdvertisementOuterClass$ResponseUpdateClick;
import ai.bale.proto.AdvertisementOuterClass$ResponseUpdateView;
import ai.bale.proto.AuthOuterClass$RequestChangePhone;
import ai.bale.proto.AuthOuterClass$RequestDeleteAccount;
import ai.bale.proto.AuthOuterClass$RequestGetAuthSessions;
import ai.bale.proto.AuthOuterClass$RequestGetBaleTicket;
import ai.bale.proto.AuthOuterClass$RequestGetJWTToken;
import ai.bale.proto.AuthOuterClass$RequestSendChangePhoneVerificationCode;
import ai.bale.proto.AuthOuterClass$RequestSendDeleteAccountVerificationCode;
import ai.bale.proto.AuthOuterClass$RequestSignOut;
import ai.bale.proto.AuthOuterClass$RequestSignUp;
import ai.bale.proto.AuthOuterClass$RequestStartPhoneAuth;
import ai.bale.proto.AuthOuterClass$RequestTerminateAllSessions;
import ai.bale.proto.AuthOuterClass$RequestTerminateSession;
import ai.bale.proto.AuthOuterClass$RequestValidateCode;
import ai.bale.proto.AuthOuterClass$ResponseAuth;
import ai.bale.proto.AuthOuterClass$ResponseGetAuthSessions;
import ai.bale.proto.AuthOuterClass$ResponseGetJWTToken;
import ai.bale.proto.AuthOuterClass$ResponseGetTicket;
import ai.bale.proto.AuthOuterClass$ResponseSendChangePhoneVerificationCode;
import ai.bale.proto.AuthOuterClass$ResponseSendDeleteAccountVerificationCode;
import ai.bale.proto.AuthOuterClass$ResponseStartPhoneAuth;
import ai.bale.proto.BankOuterClass$RequestBuyFastCharge;
import ai.bale.proto.BankOuterClass$RequestGetCardTransferToken;
import ai.bale.proto.BankOuterClass$RequestGetOTPToken;
import ai.bale.proto.BankOuterClass$RequestGetOTPTokenV2;
import ai.bale.proto.BankOuterClass$RequestGetPSProxyPaymentToken;
import ai.bale.proto.BankOuterClass$RequestGetPSProxyToken;
import ai.bale.proto.BankOuterClass$RequestGetPayMoneyRequestToken;
import ai.bale.proto.BankOuterClass$RequestGetPaymentToken;
import ai.bale.proto.BankOuterClass$RequestGetPayvandCard;
import ai.bale.proto.BankOuterClass$RequestGetPayvandCardList;
import ai.bale.proto.BankOuterClass$RequestGetRecentCharges;
import ai.bale.proto.BankOuterClass$RequestGetRemainToken;
import ai.bale.proto.BankOuterClass$RequestGetSadadPSPPaymentToken;
import ai.bale.proto.BankOuterClass$RequestGrantBankiAccess;
import ai.bale.proto.BankOuterClass$ResponseBuyFastCharge;
import ai.bale.proto.BankOuterClass$ResponseGetCardTransferToken;
import ai.bale.proto.BankOuterClass$ResponseGetOTPToken;
import ai.bale.proto.BankOuterClass$ResponseGetOTPTokenV2;
import ai.bale.proto.BankOuterClass$ResponseGetPSProxyPaymentToken;
import ai.bale.proto.BankOuterClass$ResponseGetPSProxyToken;
import ai.bale.proto.BankOuterClass$ResponseGetPayMoneyRequestToken;
import ai.bale.proto.BankOuterClass$ResponseGetPaymentToken;
import ai.bale.proto.BankOuterClass$ResponseGetPayvandCard;
import ai.bale.proto.BankOuterClass$ResponseGetPayvandCardList;
import ai.bale.proto.BankOuterClass$ResponseGetRecentCharges;
import ai.bale.proto.BankOuterClass$ResponseGetRemainToken;
import ai.bale.proto.BankOuterClass$ResponseGetSadadPSPPaymentToken;
import ai.bale.proto.BillOuterClass$RequestCreateSavedBill;
import ai.bale.proto.BillOuterClass$RequestDeleteSavedBills;
import ai.bale.proto.BillOuterClass$RequestGetBillHistory;
import ai.bale.proto.BillOuterClass$RequestGetSavedBills;
import ai.bale.proto.BillOuterClass$RequestInquiryBill;
import ai.bale.proto.BillOuterClass$RequestPayBill;
import ai.bale.proto.BillOuterClass$RequestRenameSavedBill;
import ai.bale.proto.BillOuterClass$ResponseCreateSavedBill;
import ai.bale.proto.BillOuterClass$ResponseGetBillHistory;
import ai.bale.proto.BillOuterClass$ResponseGetSavedBills;
import ai.bale.proto.BillOuterClass$ResponseInquiryBill;
import ai.bale.proto.BillOuterClass$ResponsePayBill;
import ai.bale.proto.Charnet$RequestBuyCharge;
import ai.bale.proto.Charnet$RequestBuyInternetBundle;
import ai.bale.proto.Charnet$RequestDeleteInternetBundleOrder;
import ai.bale.proto.Charnet$RequestGetInternetBundleList;
import ai.bale.proto.Charnet$RequestGetInternetBundlePaymentToken;
import ai.bale.proto.Charnet$RequestGetRecentInternetBundleOrders;
import ai.bale.proto.Charnet$ResponseBuyCharge;
import ai.bale.proto.Charnet$ResponseBuyInternetBundle;
import ai.bale.proto.Charnet$ResponseGetInternetBundleList;
import ai.bale.proto.Charnet$ResponseGetInternetBundlePaymentToken;
import ai.bale.proto.Charnet$ResponseGetRecentInternetBundleOrders;
import ai.bale.proto.ClubOuterClass$RequestBuyVoucher;
import ai.bale.proto.ClubOuterClass$RequestBuyWheelChance;
import ai.bale.proto.ClubOuterClass$RequestChangePointToMoney;
import ai.bale.proto.ClubOuterClass$RequestGetAcquiredVouchers;
import ai.bale.proto.ClubOuterClass$RequestGetVouchers;
import ai.bale.proto.ClubOuterClass$RequestGetWheel;
import ai.bale.proto.ClubOuterClass$RequestSpinWheel;
import ai.bale.proto.ClubOuterClass$ResponseBuyVoucher;
import ai.bale.proto.ClubOuterClass$ResponseBuyWheelChance;
import ai.bale.proto.ClubOuterClass$ResponseChangePointToMoney;
import ai.bale.proto.ClubOuterClass$ResponseGetAcquiredVouchers;
import ai.bale.proto.ClubOuterClass$ResponseGetVouchers;
import ai.bale.proto.ClubOuterClass$ResponseGetWheel;
import ai.bale.proto.ClubOuterClass$ResponseSpinWheel;
import ai.bale.proto.ConfigsOuterClass$RequestEditParameter;
import ai.bale.proto.ConfigsOuterClass$RequestGetParameters;
import ai.bale.proto.ConfigsOuterClass$ResponseGetParameters;
import ai.bale.proto.Crowdfunding$RequestGetParticipants;
import ai.bale.proto.Crowdfunding$RequestGetTotalPaidAmount;
import ai.bale.proto.Crowdfunding$ResponseGetParticipants;
import ai.bale.proto.Crowdfunding$ResponseGetTotalPaidAmount;
import ai.bale.proto.EnrichmentOuterClass$RequestGetLinkPreview;
import ai.bale.proto.EnrichmentOuterClass$ResponseGetLinkPreview;
import ai.bale.proto.Feedback$RequestSendFeedBack;
import ai.bale.proto.FilesOuterClass$RequestGetNasimFilePublicUrl;
import ai.bale.proto.FilesOuterClass$RequestGetNasimFileUploadResume;
import ai.bale.proto.FilesOuterClass$RequestGetNasimFileUploadUrl;
import ai.bale.proto.FilesOuterClass$RequestGetNasimFileUrl;
import ai.bale.proto.FilesOuterClass$RequestGetNasimFileUrls;
import ai.bale.proto.FilesOuterClass$ResponseGetNasimFilePublicUrl;
import ai.bale.proto.FilesOuterClass$ResponseGetNasimFileUploadResume;
import ai.bale.proto.FilesOuterClass$ResponseGetNasimFileUploadUrl;
import ai.bale.proto.FilesOuterClass$ResponseGetNasimFileUrl;
import ai.bale.proto.FilesOuterClass$ResponseGetNasimFileUrls;
import ai.bale.proto.Giftpacket$RequestGetGiftPacketPaymentToken;
import ai.bale.proto.Giftpacket$RequestOpenGiftPacket;
import ai.bale.proto.Giftpacket$RequestSendGiftPacketWithWallet;
import ai.bale.proto.Giftpacket$ResponseGetGiftPacketPaymentToken;
import ai.bale.proto.Giftpacket$ResponseOpenGiftPacket;
import ai.bale.proto.GroupsOuterClass$RequestCreateGroup;
import ai.bale.proto.GroupsOuterClass$RequestEditChannelNick;
import ai.bale.proto.GroupsOuterClass$RequestEditGroupAbout;
import ai.bale.proto.GroupsOuterClass$RequestEditGroupAvatar;
import ai.bale.proto.GroupsOuterClass$RequestEditGroupDefaultCardNumber;
import ai.bale.proto.GroupsOuterClass$RequestEditGroupTitle;
import ai.bale.proto.GroupsOuterClass$RequestFetchGroupAdmins;
import ai.bale.proto.GroupsOuterClass$RequestGetCanSeeMessages;
import ai.bale.proto.GroupsOuterClass$RequestGetGroupDefaultCardNumber;
import ai.bale.proto.GroupsOuterClass$RequestGetGroupInviteUrl;
import ai.bale.proto.GroupsOuterClass$RequestGetGroupMembersCount;
import ai.bale.proto.GroupsOuterClass$RequestGetMemberPermissions;
import ai.bale.proto.GroupsOuterClass$RequestGetMyGroups;
import ai.bale.proto.GroupsOuterClass$RequestInviteUser;
import ai.bale.proto.GroupsOuterClass$RequestJoinGroup;
import ai.bale.proto.GroupsOuterClass$RequestJoinPublicGroup;
import ai.bale.proto.GroupsOuterClass$RequestKickUser;
import ai.bale.proto.GroupsOuterClass$RequestLeaveGroup;
import ai.bale.proto.GroupsOuterClass$RequestLoadFullGroups;
import ai.bale.proto.GroupsOuterClass$RequestLoadGroupAvatars;
import ai.bale.proto.GroupsOuterClass$RequestLoadGroups;
import ai.bale.proto.GroupsOuterClass$RequestLoadMembers;
import ai.bale.proto.GroupsOuterClass$RequestMakeUserAdmin;
import ai.bale.proto.GroupsOuterClass$RequestPinMessage;
import ai.bale.proto.GroupsOuterClass$RequestRemoveGroupAvatar;
import ai.bale.proto.GroupsOuterClass$RequestRemovePin;
import ai.bale.proto.GroupsOuterClass$RequestRemoveUserAdmin;
import ai.bale.proto.GroupsOuterClass$RequestRevokeInviteUrl;
import ai.bale.proto.GroupsOuterClass$RequestSetCanSeeMessages;
import ai.bale.proto.GroupsOuterClass$RequestSetGroupDefaultPermissions;
import ai.bale.proto.GroupsOuterClass$RequestSetMemberPermissions;
import ai.bale.proto.GroupsOuterClass$RequestSetRestriction;
import ai.bale.proto.GroupsOuterClass$RequestTransferOwnership;
import ai.bale.proto.GroupsOuterClass$ResponseCanSeeMessages;
import ai.bale.proto.GroupsOuterClass$ResponseCreateGroup;
import ai.bale.proto.GroupsOuterClass$ResponseEditGroupAvatar;
import ai.bale.proto.GroupsOuterClass$ResponseFetchGroupAdmins;
import ai.bale.proto.GroupsOuterClass$ResponseGetGroupDefaultCardNumber;
import ai.bale.proto.GroupsOuterClass$ResponseGetGroupMembersCount;
import ai.bale.proto.GroupsOuterClass$ResponseGetMemberPermissions;
import ai.bale.proto.GroupsOuterClass$ResponseGetMyGroups;
import ai.bale.proto.GroupsOuterClass$ResponseInviteUrl;
import ai.bale.proto.GroupsOuterClass$ResponseJoinGroup;
import ai.bale.proto.GroupsOuterClass$ResponseJoinPublicGroup;
import ai.bale.proto.GroupsOuterClass$ResponseLoadFullGroups;
import ai.bale.proto.GroupsOuterClass$ResponseLoadGroupAvatars;
import ai.bale.proto.GroupsOuterClass$ResponseLoadGroups;
import ai.bale.proto.GroupsOuterClass$ResponseLoadMembers;
import ai.bale.proto.ImagesOuterClass$RequestAddGif;
import ai.bale.proto.ImagesOuterClass$RequestAddStickerCollection;
import ai.bale.proto.ImagesOuterClass$RequestLoadOwnStickers;
import ai.bale.proto.ImagesOuterClass$RequestLoadStickerCollection;
import ai.bale.proto.ImagesOuterClass$RequestRemoveGif;
import ai.bale.proto.ImagesOuterClass$RequestRemoveStickerCollection;
import ai.bale.proto.ImagesOuterClass$ResponseLoadOwnStickers;
import ai.bale.proto.ImagesOuterClass$ResponseLoadStickerCollection;
import ai.bale.proto.ImagesOuterClass$ResponseStickersReponse;
import ai.bale.proto.KetfOuterClass$RequestGetBotWhiteList;
import ai.bale.proto.KetfOuterClass$RequestGetUserContext;
import ai.bale.proto.KetfOuterClass$RequestSendInlineCallBackData;
import ai.bale.proto.KetfOuterClass$ResponseGetBotWhiteList;
import ai.bale.proto.KetfOuterClass$ResponseGetUserContext;
import ai.bale.proto.KifpoolOuterClass$RequestCashOutKifpool;
import ai.bale.proto.KifpoolOuterClass$RequestCharge;
import ai.bale.proto.KifpoolOuterClass$RequestCheckChargePermission;
import ai.bale.proto.KifpoolOuterClass$RequestCreateKifpool;
import ai.bale.proto.KifpoolOuterClass$RequestCryptoTransfer;
import ai.bale.proto.KifpoolOuterClass$RequestGetChargePaymentToken;
import ai.bale.proto.KifpoolOuterClass$RequestGetCryptoChargePaymentToken;
import ai.bale.proto.KifpoolOuterClass$RequestGetCryptoWallets;
import ai.bale.proto.KifpoolOuterClass$RequestGetKifpoolOwner;
import ai.bale.proto.KifpoolOuterClass$RequestGetMyKifpools;
import ai.bale.proto.KifpoolOuterClass$RequestGetPointBalance;
import ai.bale.proto.KifpoolOuterClass$RequestGetPointDetails;
import ai.bale.proto.KifpoolOuterClass$RequestGetPointSummery;
import ai.bale.proto.KifpoolOuterClass$RequestInvoiceKifpool;
import ai.bale.proto.KifpoolOuterClass$RequestPurchaseMessage;
import ai.bale.proto.KifpoolOuterClass$RequestPurchaseMessageWithCharge;
import ai.bale.proto.KifpoolOuterClass$RequestTransactionPoint;
import ai.bale.proto.KifpoolOuterClass$RequestTransferMoney;
import ai.bale.proto.KifpoolOuterClass$RequestUpgradeKifpool;
import ai.bale.proto.KifpoolOuterClass$RequestVerifyCashOutKifpool;
import ai.bale.proto.KifpoolOuterClass$RequestVerifyPurchaseMessage;
import ai.bale.proto.KifpoolOuterClass$ResponseCashOutKifpool;
import ai.bale.proto.KifpoolOuterClass$ResponseCharge;
import ai.bale.proto.KifpoolOuterClass$ResponseCheckChargePermission;
import ai.bale.proto.KifpoolOuterClass$ResponseCreateKifpool;
import ai.bale.proto.KifpoolOuterClass$ResponseCryptoTransfer;
import ai.bale.proto.KifpoolOuterClass$ResponseGetChargePaymentToken;
import ai.bale.proto.KifpoolOuterClass$ResponseGetCryptoWallets;
import ai.bale.proto.KifpoolOuterClass$ResponseGetKifpoolOwner;
import ai.bale.proto.KifpoolOuterClass$ResponseGetMyKifpools;
import ai.bale.proto.KifpoolOuterClass$ResponseGetPointBalance;
import ai.bale.proto.KifpoolOuterClass$ResponseGetPointDetails;
import ai.bale.proto.KifpoolOuterClass$ResponseGetPointSummery;
import ai.bale.proto.KifpoolOuterClass$ResponseInvoiceKifpool;
import ai.bale.proto.KifpoolOuterClass$ResponsePurchaseMessage;
import ai.bale.proto.KifpoolOuterClass$ResponsePurchaseMessageWithCharge;
import ai.bale.proto.KifpoolOuterClass$ResponseTransactionPoint;
import ai.bale.proto.KifpoolOuterClass$ResponseTransferMoney;
import ai.bale.proto.KifpoolOuterClass$ResponseUpgradeKifpool;
import ai.bale.proto.KifpoolOuterClass$ResponseVerifyCashOutKifpool;
import ai.bale.proto.KifpoolOuterClass$ResponseVerifyPurchaseMessage;
import ai.bale.proto.MeetOuterClass$RequestAcceptCall;
import ai.bale.proto.MeetOuterClass$RequestDiscardCall;
import ai.bale.proto.MeetOuterClass$RequestStartCall;
import ai.bale.proto.MeetOuterClass$ResponseCall;
import ai.bale.proto.MelonOuterClass$RequestGetLoanInfo;
import ai.bale.proto.MelonOuterClass$RequestGetLoansList;
import ai.bale.proto.MelonOuterClass$RequestLoadLastStates;
import ai.bale.proto.MelonOuterClass$RequestLoadLoanHistory;
import ai.bale.proto.MelonOuterClass$RequestRemoveLoan;
import ai.bale.proto.MelonOuterClass$ResponseGetLoanInfo;
import ai.bale.proto.MelonOuterClass$ResponseGetLoansList;
import ai.bale.proto.MelonOuterClass$ResponseLoadLastStates;
import ai.bale.proto.MelonOuterClass$ResponseLoadLoanHistory;
import ai.bale.proto.MessagingOuterClass$RequestClearChat;
import ai.bale.proto.MessagingOuterClass$RequestDeleteChat;
import ai.bale.proto.MessagingOuterClass$RequestDeleteMessage;
import ai.bale.proto.MessagingOuterClass$RequestGetMessagesRepliesInfo;
import ai.bale.proto.MessagingOuterClass$RequestLoadArchived;
import ai.bale.proto.MessagingOuterClass$RequestLoadDialogs;
import ai.bale.proto.MessagingOuterClass$RequestLoadGroupedDialogs;
import ai.bale.proto.MessagingOuterClass$RequestLoadHistory;
import ai.bale.proto.MessagingOuterClass$RequestLoadPeerDialogs;
import ai.bale.proto.MessagingOuterClass$RequestMessageRead;
import ai.bale.proto.MessagingOuterClass$RequestMessageReceived;
import ai.bale.proto.MessagingOuterClass$RequestSendMessage;
import ai.bale.proto.MessagingOuterClass$RequestSendMultiMediaMessage;
import ai.bale.proto.MessagingOuterClass$RequestUpdateMessage;
import ai.bale.proto.MessagingOuterClass$ResponseDialogsOrder;
import ai.bale.proto.MessagingOuterClass$ResponseGetMessagesRepliesInfo;
import ai.bale.proto.MessagingOuterClass$ResponseLoadArchived;
import ai.bale.proto.MessagingOuterClass$ResponseLoadDialogs;
import ai.bale.proto.MessagingOuterClass$ResponseLoadGroupedDialogs;
import ai.bale.proto.MessagingOuterClass$ResponseLoadHistory;
import ai.bale.proto.MessagingOuterClass$ResponseLoadPeerDialogs;
import ai.bale.proto.Microbanki$RequestGetBamServiceToken;
import ai.bale.proto.Microbanki$RequestGetMoneyRequestDetails;
import ai.bale.proto.Microbanki$RequestGetMoneyRequestPaymentList;
import ai.bale.proto.Microbanki$ResponseGetBamServiceToken;
import ai.bale.proto.Microbanki$ResponseGetMoneyRequestDetails;
import ai.bale.proto.Microbanki$ResponseGetMoneyRequestPaymentList;
import ai.bale.proto.Misc$ResponseBool;
import ai.bale.proto.Misc$ResponseSeq;
import ai.bale.proto.Misc$ResponseSeqDate;
import ai.bale.proto.Misc$ResponseVoid;
import ai.bale.proto.MyBankOuterClass$RequestGetMyBank;
import ai.bale.proto.MyBankOuterClass$ResponseGetMyBank;
import ai.bale.proto.PfmOuterClass$RequestAddDetailToTransaction;
import ai.bale.proto.PfmOuterClass$RequestAddTransactionTags;
import ai.bale.proto.PfmOuterClass$RequestAddUserTags;
import ai.bale.proto.PfmOuterClass$RequestFilterTaggedTransactions;
import ai.bale.proto.PfmOuterClass$RequestGetSubTransactions;
import ai.bale.proto.PfmOuterClass$RequestGetTransactionTags;
import ai.bale.proto.PfmOuterClass$RequestGetUserAccounts;
import ai.bale.proto.PfmOuterClass$RequestGetUserTags;
import ai.bale.proto.PfmOuterClass$RequestLoadTransactions;
import ai.bale.proto.PfmOuterClass$RequestLoadTransactionsByIDs;
import ai.bale.proto.PfmOuterClass$RequestRemoveTransaction;
import ai.bale.proto.PfmOuterClass$RequestRemoveTransactionTags;
import ai.bale.proto.PfmOuterClass$RequestRemoveUserTags;
import ai.bale.proto.PfmOuterClass$RequestReviveTransaction;
import ai.bale.proto.PfmOuterClass$RequestSplitTransaction;
import ai.bale.proto.PfmOuterClass$ResponseFilterTaggedTransactions;
import ai.bale.proto.PfmOuterClass$ResponseGetSubTransactions;
import ai.bale.proto.PfmOuterClass$ResponseGetTransactionTags;
import ai.bale.proto.PfmOuterClass$ResponseGetUserAccounts;
import ai.bale.proto.PfmOuterClass$ResponseGetUserTags;
import ai.bale.proto.PfmOuterClass$ResponseLoadTransactions;
import ai.bale.proto.PfmOuterClass$ResponseLoadTransactionsByIDs;
import ai.bale.proto.PfmOuterClass$ResponseSplitTransaction;
import ai.bale.proto.PresenceOuterClass$RequestGetGroupMembersPresence;
import ai.bale.proto.PresenceOuterClass$RequestGetUsersPresence;
import ai.bale.proto.PresenceOuterClass$RequestSetOnline;
import ai.bale.proto.PresenceOuterClass$RequestStopTyping;
import ai.bale.proto.PresenceOuterClass$RequestSubscribeFromGroupOnline;
import ai.bale.proto.PresenceOuterClass$RequestSubscribeFromOnline;
import ai.bale.proto.PresenceOuterClass$RequestSubscribeToGroupOnline;
import ai.bale.proto.PresenceOuterClass$RequestSubscribeToOnline;
import ai.bale.proto.PresenceOuterClass$RequestTyping;
import ai.bale.proto.PresenceOuterClass$ResponseGetGroupMembersPresence;
import ai.bale.proto.PresenceOuterClass$ResponseGetUsersPresence;
import ai.bale.proto.Protobuf$RequestProto;
import ai.bale.proto.Protobuf$ResponseProto;
import ai.bale.proto.PushOuterClass$RequestRegisterGooglePush;
import ai.bale.proto.PushOuterClass$RequestUnregisterAllPushCredentials;
import ai.bale.proto.PushOuterClass$RequestUnregisterGooglePush;
import ai.bale.proto.ReactionsOuterClass$RequestBindMoneyRequestDetails;
import ai.bale.proto.ReactionsOuterClass$RequestBindMoneyRequestDetailsList;
import ai.bale.proto.ReactionsOuterClass$RequestGetReactions;
import ai.bale.proto.ReactionsOuterClass$RequestUnbindAllMoneyRequestDetails;
import ai.bale.proto.ReactionsOuterClass$ResponseGetReactions;
import ai.bale.proto.ReferralOuterClass$RequestGetReferralCode;
import ai.bale.proto.ReferralOuterClass$RequestGetReferredCount;
import ai.bale.proto.ReferralOuterClass$RequestGetReferringUser;
import ai.bale.proto.ReferralOuterClass$RequestRefer;
import ai.bale.proto.ReferralOuterClass$ResponseGetReferralCode;
import ai.bale.proto.ReferralOuterClass$ResponseGetReferredCount;
import ai.bale.proto.ReferralOuterClass$ResponseGetReferringUser;
import ai.bale.proto.ReferralOuterClass$ResponseRefer;
import ai.bale.proto.Saba$RequestDeleteOrder;
import ai.bale.proto.Saba$RequestGetChargeAmounts;
import ai.bale.proto.Saba$RequestGetChargeTopupPaymentToken;
import ai.bale.proto.Saba$RequestGetChargeVoucherPaymentToken;
import ai.bale.proto.Saba$RequestGetRecentOrders;
import ai.bale.proto.Saba$RequestGetWebViewTrackingNumber;
import ai.bale.proto.Saba$RequestSetRecentOrder;
import ai.bale.proto.Saba$ResponseGetChargeAmounts;
import ai.bale.proto.Saba$ResponseGetPspPaymentToken;
import ai.bale.proto.Saba$ResponseGetRecentOrders;
import ai.bale.proto.Saba$ResponseGetWebViewTrackingNumber;
import ai.bale.proto.SapOuterClass$RequestAddDestinationCards;
import ai.bale.proto.SapOuterClass$RequestAddNewCards;
import ai.bale.proto.SapOuterClass$RequestDeliverOtp;
import ai.bale.proto.SapOuterClass$RequestEditCardExpirationDate;
import ai.bale.proto.SapOuterClass$RequestEnrollNewCard;
import ai.bale.proto.SapOuterClass$RequestGetCardInfo;
import ai.bale.proto.SapOuterClass$RequestGetCards;
import ai.bale.proto.SapOuterClass$RequestGetDefaultCard;
import ai.bale.proto.SapOuterClass$RequestGetDestinationCardInfo;
import ai.bale.proto.SapOuterClass$RequestGetDestinationCards;
import ai.bale.proto.SapOuterClass$RequestReactivateApp;
import ai.bale.proto.SapOuterClass$RequestRemoveCard;
import ai.bale.proto.SapOuterClass$RequestRemoveDefaultCard;
import ai.bale.proto.SapOuterClass$RequestRemoveDestinationCards;
import ai.bale.proto.SapOuterClass$RequestSetDefaultCard;
import ai.bale.proto.SapOuterClass$RequestTransferMoneyByCard;
import ai.bale.proto.SapOuterClass$ResponseAddDestinationCards;
import ai.bale.proto.SapOuterClass$ResponseAddNewCards;
import ai.bale.proto.SapOuterClass$ResponseEnrollNewCard;
import ai.bale.proto.SapOuterClass$ResponseGetCardInfo;
import ai.bale.proto.SapOuterClass$ResponseGetCards;
import ai.bale.proto.SapOuterClass$ResponseGetDefaultCard;
import ai.bale.proto.SapOuterClass$ResponseGetDestinationCardInfo;
import ai.bale.proto.SapOuterClass$ResponseGetDestinationCards;
import ai.bale.proto.SapOuterClass$ResponseReactivateApp;
import ai.bale.proto.SearchOuterClass$RequestSearchMedia;
import ai.bale.proto.SearchOuterClass$RequestSearchMessages;
import ai.bale.proto.SearchOuterClass$RequestSearchMessagesMore;
import ai.bale.proto.SearchOuterClass$RequestSearchPeer;
import ai.bale.proto.SearchOuterClass$ResponseSearchMedia;
import ai.bale.proto.SearchOuterClass$ResponseSearchMessages;
import ai.bale.proto.SearchOuterClass$ResponseSearchPeer;
import ai.bale.proto.SefteOuterClass$RequestAddRecipient;
import ai.bale.proto.SefteOuterClass$RequestAuthorizeUser;
import ai.bale.proto.SefteOuterClass$RequestCheckStatusOfPayment;
import ai.bale.proto.SefteOuterClass$RequestGetCitiesOfState;
import ai.bale.proto.SefteOuterClass$RequestGetRecipients;
import ai.bale.proto.SefteOuterClass$RequestGetStates;
import ai.bale.proto.SefteOuterClass$RequestGetUserSeftes;
import ai.bale.proto.SefteOuterClass$RequestInitP12;
import ai.bale.proto.SefteOuterClass$RequestInitSefte;
import ai.bale.proto.SefteOuterClass$RequestPaySefte;
import ai.bale.proto.SefteOuterClass$RequestSignSefte;
import ai.bale.proto.SefteOuterClass$RequestUserHasCred;
import ai.bale.proto.SefteOuterClass$ResponseAuthorizeUser;
import ai.bale.proto.SefteOuterClass$ResponseGetCitiesOfState;
import ai.bale.proto.SefteOuterClass$ResponseGetRecipients;
import ai.bale.proto.SefteOuterClass$ResponseGetStates;
import ai.bale.proto.SefteOuterClass$ResponseGetUserSeftes;
import ai.bale.proto.SefteOuterClass$ResponseInitP12;
import ai.bale.proto.SefteOuterClass$ResponseInitSefte;
import ai.bale.proto.SefteOuterClass$ResponsePaySefte;
import ai.bale.proto.SefteOuterClass$ResponseSignSefte;
import ai.bale.proto.SefteOuterClass$ResponseUserHasCred;
import ai.bale.proto.SentenceOuterClass$RequestGetMySentence;
import ai.bale.proto.SentenceOuterClass$RequestSendMyGiftPacket;
import ai.bale.proto.SentenceOuterClass$RequestValidateMySentence;
import ai.bale.proto.SentenceOuterClass$ResponseGetMySentence;
import ai.bale.proto.SentenceOuterClass$ResponseValidateMySentence;
import ai.bale.proto.Sequence$RequestGetGroupDifference;
import ai.bale.proto.Sequence$RequestGetGroupState;
import ai.bale.proto.Sequence$RequestGetReferencedEntitites;
import ai.bale.proto.Sequence$RequestGetState;
import ai.bale.proto.Sequence$ResponseGetGroupDifference;
import ai.bale.proto.Sequence$ResponseGetGroupState;
import ai.bale.proto.Sequence$ResponseGetReferencedEntitites;
import ai.bale.proto.Seraj$RequestSendSerajEvent;
import ai.bale.proto.UpdateBoxStruct$CombinedUpdate;
import ai.bale.proto.UpdateBoxStruct$FatSeqUpdate;
import ai.bale.proto.UpdateBoxStruct$NewFatSeqUpdate;
import ai.bale.proto.UpdateBoxStruct$NewSeqUpdate;
import ai.bale.proto.UpdateBoxStruct$SeqUpdate;
import ai.bale.proto.UpdateBoxStruct$SeqUpdateTooLong;
import ai.bale.proto.UpdateBoxStruct$WeakFatUpdate;
import ai.bale.proto.UpdateBoxStruct$WeakUpdate;
import ai.bale.proto.UsersOuterClass$RequestAddCard;
import ai.bale.proto.UsersOuterClass$RequestAddContact;
import ai.bale.proto.UsersOuterClass$RequestBlockUser;
import ai.bale.proto.UsersOuterClass$RequestChangeDefaultCardNumber;
import ai.bale.proto.UsersOuterClass$RequestCheckNickName;
import ai.bale.proto.UsersOuterClass$RequestEditAbout;
import ai.bale.proto.UsersOuterClass$RequestEditAvatar;
import ai.bale.proto.UsersOuterClass$RequestEditBirthDate;
import ai.bale.proto.UsersOuterClass$RequestEditMyPreferredLanguages;
import ai.bale.proto.UsersOuterClass$RequestEditMyTimeZone;
import ai.bale.proto.UsersOuterClass$RequestEditName;
import ai.bale.proto.UsersOuterClass$RequestEditNickName;
import ai.bale.proto.UsersOuterClass$RequestEditSex;
import ai.bale.proto.UsersOuterClass$RequestEditUserLocalName;
import ai.bale.proto.UsersOuterClass$RequestGetContacts;
import ai.bale.proto.UsersOuterClass$RequestGetUsersDefaultCardNumber;
import ai.bale.proto.UsersOuterClass$RequestImportContacts;
import ai.bale.proto.UsersOuterClass$RequestLoadAvatars;
import ai.bale.proto.UsersOuterClass$RequestLoadBlockedUsers;
import ai.bale.proto.UsersOuterClass$RequestLoadFullUsers;
import ai.bale.proto.UsersOuterClass$RequestLoadUsers;
import ai.bale.proto.UsersOuterClass$RequestNotifyAboutDeviceInfo;
import ai.bale.proto.UsersOuterClass$RequestRemoveAvatar;
import ai.bale.proto.UsersOuterClass$RequestRemoveContact;
import ai.bale.proto.UsersOuterClass$RequestRemoveDefaultCardNumber;
import ai.bale.proto.UsersOuterClass$RequestResetContacts;
import ai.bale.proto.UsersOuterClass$RequestSearchContacts;
import ai.bale.proto.UsersOuterClass$RequestUnblockUser;
import ai.bale.proto.UsersOuterClass$ResponseEditAvatar;
import ai.bale.proto.UsersOuterClass$ResponseGetContacts;
import ai.bale.proto.UsersOuterClass$ResponseGetUsersDefaultCardNumber;
import ai.bale.proto.UsersOuterClass$ResponseImportContacts;
import ai.bale.proto.UsersOuterClass$ResponseLoadAvatars;
import ai.bale.proto.UsersOuterClass$ResponseLoadBlockedUsers;
import ai.bale.proto.UsersOuterClass$ResponseLoadFullUsers;
import ai.bale.proto.UsersOuterClass$ResponseLoadUsers;
import ai.bale.proto.UsersOuterClass$ResponseSearchContacts;
import ai.bale.proto.VitrineOuterClass$RequestGetUserBank;
import ai.bale.proto.VitrineOuterClass$RequestGetUserVitrine;
import ai.bale.proto.VitrineOuterClass$ResponseGetUserBank;
import ai.bale.proto.VitrineOuterClass$ResponseGetUserVitrine;
import ai.bale.proto.WalletOuterClass$RequestActivateWallet;
import ai.bale.proto.WalletOuterClass$RequestCashOutFromWallet;
import ai.bale.proto.WalletOuterClass$RequestGetMoneyRequestPaymentTokenByCard;
import ai.bale.proto.WalletOuterClass$RequestGetMyWallets;
import ai.bale.proto.WalletOuterClass$RequestGetPaymentTokenByCard;
import ai.bale.proto.WalletOuterClass$RequestGetWalletChargeToken;
import ai.bale.proto.WalletOuterClass$RequestGetWalletContracts;
import ai.bale.proto.WalletOuterClass$RequestGetWalletInvoice;
import ai.bale.proto.WalletOuterClass$RequestPayByWallet;
import ai.bale.proto.WalletOuterClass$RequestPayMoneyRequestByWallet;
import ai.bale.proto.WalletOuterClass$RequestVerifyCashOut;
import ai.bale.proto.WalletOuterClass$RequestVerifyPeer;
import ai.bale.proto.WalletOuterClass$RequestVerifyQRCode;
import ai.bale.proto.WalletOuterClass$ResponseGetMoneyRequestPaymentTokenByCard;
import ai.bale.proto.WalletOuterClass$ResponseGetMyWallets;
import ai.bale.proto.WalletOuterClass$ResponseGetPaymentTokenByCard;
import ai.bale.proto.WalletOuterClass$ResponseGetWalletChargeToken;
import ai.bale.proto.WalletOuterClass$ResponseGetWalletContracts;
import ai.bale.proto.WalletOuterClass$ResponseGetWalletInvoice;
import ai.bale.proto.WalletOuterClass$ResponseVerifyCashOut;
import ai.bale.proto.WalletOuterClass$ResponseVerifyPeer;
import ai.bale.proto.WalletOuterClass$ResponseVerifyQRCode;
import ai.bale.proto.WarriorOuterClass$RequestAcceptReferralInvite;
import ai.bale.proto.WarriorOuterClass$RequestGetPacket;
import ai.bale.proto.WarriorOuterClass$RequestGetPacketsStatus;
import ai.bale.proto.WarriorOuterClass$RequestGetReferralContacts;
import ai.bale.proto.WarriorOuterClass$RequestGetScoreBoard;
import ai.bale.proto.WarriorOuterClass$RequestGetUserRefers;
import ai.bale.proto.WarriorOuterClass$RequestGetUserScore;
import ai.bale.proto.WarriorOuterClass$RequestSendReferral;
import ai.bale.proto.WarriorOuterClass$ResponseGetPacketsStatus;
import ai.bale.proto.WarriorOuterClass$ResponseGetReferralContacts;
import ai.bale.proto.WarriorOuterClass$ResponseGetScoreBoard;
import ai.bale.proto.WarriorOuterClass$ResponseGetUserRefers;
import ai.bale.proto.WarriorOuterClass$ResponseGetUserScore;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class SetRpcStruct$ComposedRpc extends GeneratedMessageLite implements U64 {
    public static final int ACCEPT_CALL_FIELD_NUMBER = 63579;
    public static final int ACCEPT_REFERRAL_INVITE_FIELD_NUMBER = 63605;
    public static final int ACTIVATE_WALLET_FIELD_NUMBER = 62760;
    public static final int ADD_CARD_FIELD_NUMBER = 136;
    public static final int ADD_CONTACT_FIELD_NUMBER = 114;
    public static final int ADD_DESTINATION_CARDS_FIELD_NUMBER = 63588;
    public static final int ADD_DETAIL_TO_TRANSACTION_FIELD_NUMBER = 63641;
    public static final int ADD_GIF_FIELD_NUMBER = 2857;
    public static final int ADD_NEW_CARDS_FIELD_NUMBER = 63555;
    public static final int ADD_RECIPIENT_FIELD_NUMBER = 63628;
    public static final int ADD_STICKER_COLLECTION_FIELD_NUMBER = 244;
    public static final int ADD_TRANSACTION_TAGS_FIELD_NUMBER = 63449;
    public static final int ADD_USER_TAGS_FIELD_NUMBER = 63518;
    public static final int AUTHORIZE_USER_FIELD_NUMBER = 63606;
    public static final int BIND_MONEY_REQUEST_DETAILS_FIELD_NUMBER = 62403;
    public static final int BIND_MONEY_REQUEST_DETAILS_LIST_FIELD_NUMBER = 62410;
    public static final int BLOCK_USER_FIELD_NUMBER = 2636;
    public static final int BUY_CHARGE_FIELD_NUMBER = 63537;
    public static final int BUY_FAST_CHARGE_FIELD_NUMBER = 62464;
    public static final int BUY_INTERNET_BUNDLE_FIELD_NUMBER = 63539;
    public static final int BUY_VOUCHER_FIELD_NUMBER = 63474;
    public static final int BUY_WHEEL_CHANCE_FIELD_NUMBER = 63466;
    public static final int CASHOUT_KIFPOOL_FIELD_NUMBER = 63407;
    public static final int CASH_OUT_FROM_WALLET_FIELD_NUMBER = 62764;
    public static final int CHANGE_DEFAULT_CARD_NUMBER_FIELD_NUMBER = 62129;
    public static final int CHANGE_PHONE_FIELD_NUMBER = 63453;
    public static final int CHANGE_POINT_TO_MONEY_FIELD_NUMBER = 63464;
    public static final int CHANGE_STATUS_DIALOG_AD_ORDER_FIELD_NUMBER = 63570;
    public static final int CHARGE_FIELD_NUMBER = 63415;
    public static final int CHECK_CHARGE_PERMISSION_FIELD_NUMBER = 63413;
    public static final int CHECK_NICK_NAME_FIELD_NUMBER = 206;
    public static final int CHECK_STATUS_OF_PAYMENT_FIELD_NUMBER = 63619;
    public static final int CLEAR_CHAT_FIELD_NUMBER = 99;
    public static final int COMBINED_UPDATE_FIELD_NUMBER = 2625;
    public static final int CREATE_GROUP_FIELD_NUMBER = 230;
    public static final int CREATE_KIFPOOL_FIELD_NUMBER = 63404;
    public static final int CREATE_SAVED_BILL_FIELD_NUMBER = 63549;
    public static final int CRYPTO_TRANSFER_FIELD_NUMBER = 63632;
    private static final SetRpcStruct$ComposedRpc DEFAULT_INSTANCE;
    public static final int DELETE_ACCOUNT_FIELD_NUMBER = 43606;
    public static final int DELETE_CHAT_FIELD_NUMBER = 100;
    public static final int DELETE_INTERNET_BUNDLE_ORDER_FIELD_NUMBER = 63536;
    public static final int DELETE_MESSAGE_FIELD_NUMBER = 98;
    public static final int DELETE_ORDER_FIELD_NUMBER = 63509;
    public static final int DELETE_SAVED_BILLS_FIELD_NUMBER = 63554;
    public static final int DELIVER_OTP_FIELD_NUMBER = 63493;
    public static final int DISCARD_CALL_FIELD_NUMBER = 63580;
    public static final int EDIT_ABOUT_FIELD_NUMBER = 212;
    public static final int EDIT_AVATAR_FIELD_NUMBER = 31;
    public static final int EDIT_BIRTH_DATE_FIELD_NUMBER = 63652;
    public static final int EDIT_CARD_EXPIRATION_DATE_FIELD_NUMBER = 63566;
    public static final int EDIT_CHANNEL_NICK_FIELD_NUMBER = 3396;
    public static final int EDIT_GROUP_ABOUT_FIELD_NUMBER = 213;
    public static final int EDIT_GROUP_AVATAR_FIELD_NUMBER = 86;
    public static final int EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER = 120;
    public static final int EDIT_GROUP_TITLE_FIELD_NUMBER = 85;
    public static final int EDIT_MY_PREFERRED_LANGUAGES_FIELD_NUMBER = 145;
    public static final int EDIT_MY_TIME_ZONE_FIELD_NUMBER = 144;
    public static final int EDIT_NAME_FIELD_NUMBER = 53;
    public static final int EDIT_NICK_NAME_FIELD_NUMBER = 205;
    public static final int EDIT_PARAMETER_FIELD_NUMBER = 128;
    public static final int EDIT_SEX_FIELD_NUMBER = 63651;
    public static final int EDIT_USER_LOCAL_NAME_FIELD_NUMBER = 96;
    public static final int ENROLL_NEW_CARD_FIELD_NUMBER = 63487;
    public static final int FAT_SEQ_UPDATE_FIELD_NUMBER = 73;
    public static final int FETCH_GROUP_ADMINS_FIELD_NUMBER = 729;
    public static final int FILTER_TAGGED_TRANSACTIONS_FIELD_NUMBER = 63630;
    public static final int GET_ACQUIRED_VOUCHERS_FIELD_NUMBER = 63637;
    public static final int GET_AD_PROVIDER_FIELD_NUMBER = 63525;
    public static final int GET_AUTH_SESSIONS_FIELD_NUMBER = 80;
    public static final int GET_BALE_TICKET_FIELD_NUMBER = 63260;
    public static final int GET_BAM_SERVICE_TOKEN_FIELD_NUMBER = 62406;
    public static final int GET_BILL_HISTORY_FIELD_NUMBER = 63547;
    public static final int GET_BOT_WHITE_LIST_FIELD_NUMBER = 249;
    public static final int GET_CAN_SEE_MESSAGES_FIELD_NUMBER = 726;
    public static final int GET_CARDS_FIELD_NUMBER = 63558;
    public static final int GET_CARD_INFO_FIELD_NUMBER = 63489;
    public static final int GET_CARD_TRANSFER_TOKEN_FIELD_NUMBER = 62125;
    public static final int GET_CHANNEL_ADS_FIELD_NUMBER = 63264;
    public static final int GET_CHANNEL_EARN_MONEY_INFO_FIELD_NUMBER = 63447;
    public static final int GET_CHANNEL_EARN_MONEY_STATUS_FIELD_NUMBER = 63436;
    public static final int GET_CHARGE_AMOUNTS_FIELD_NUMBER = 63510;
    public static final int GET_CHARGE_PAYMENT_TOKEN_FIELD_NUMBER = 63417;
    public static final int GET_CHARGE_TOPUP_PAYMENT_TOKEN_FIELD_NUMBER = 63484;
    public static final int GET_CHARGE_VOUCHER_PAYMENT_TOKEN_FIELD_NUMBER = 63485;
    public static final int GET_CITIES_OF_STATE_FIELD_NUMBER = 63617;
    public static final int GET_CONTACTS_FIELD_NUMBER = 87;
    public static final int GET_CRYPTO_CHARGE_PAYMENT_TOKEN_FIELD_NUMBER = 63629;
    public static final int GET_CRYPTO_WALLETS_FIELD_NUMBER = 63634;
    public static final int GET_DEFAULT_CARD_FIELD_NUMBER = 63563;
    public static final int GET_DESTINATION_CARDS_FIELD_NUMBER = 63586;
    public static final int GET_DESTINATION_CARD_INFO_FIELD_NUMBER = 63491;
    public static final int GET_DIALOG_AD_ORDER_DETAILS_FIELD_NUMBER = 63568;
    public static final int GET_DIALOG_AD_ORDER_PAYMENT_TOKEN_FIELD_NUMBER = 63571;
    public static final int GET_GIFT_PACKET_PAYMENT_TOKEN_FIELD_NUMBER = 63232;
    public static final int GET_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER = 129;
    public static final int GET_GROUP_DIFFERENCE_FIELD_NUMBER = 187;
    public static final int GET_GROUP_INVITE_URL_FIELD_NUMBER = 177;
    public static final int GET_GROUP_MEMBERS_COUNT_FIELD_NUMBER = 63499;
    public static final int GET_GROUP_MEMBERS_PRESENCE_FIELD_NUMBER = 63642;
    public static final int GET_GROUP_STATE_FIELD_NUMBER = 153;
    public static final int GET_INTERNET_BUNDLE_LIST_FIELD_NUMBER = 63532;
    public static final int GET_INTERNET_BUNDLE_PAYMENT_TOKEN_FIELD_NUMBER = 63530;
    public static final int GET_JWT_TOKEN_FIELD_NUMBER = 600;
    public static final int GET_KIFPOOL_OWNER_FIELD_NUMBER = 63420;
    public static final int GET_LINK_PREVIEW_FIELD_NUMBER = 63497;
    public static final int GET_LOANS_LIST_FIELD_NUMBER = 63584;
    public static final int GET_LOAN_INFO_FIELD_NUMBER = 63582;
    public static final int GET_MEMBER_PERMISSIONS_FIELD_NUMBER = 63456;
    public static final int GET_MESSAGES_REPLIES_INFO_FIELD_NUMBER = 63663;
    public static final int GET_MONEY_REQUEST_DETAILS_FIELD_NUMBER = 62393;
    public static final int GET_MONEY_REQUEST_PAYMENT_LIST_FIELD_NUMBER = 62401;
    public static final int GET_MONEY_REQUEST_PAYMENT_TOKEN_BY_CARD_FIELD_NUMBER = 62769;
    public static final int GET_MY_BANK_FIELD_NUMBER = 63243;
    public static final int GET_MY_GROUPS_FIELD_NUMBER = 43746;
    public static final int GET_MY_KIFPOOLS_FIELD_NUMBER = 63400;
    public static final int GET_MY_SENTENCE_FIELD_NUMBER = 63573;
    public static final int GET_MY_WALLETS_FIELD_NUMBER = 62730;
    public static final int GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER = 3072;
    public static final int GET_NASIM_FILE_UPLOAD_RESUME_FIELD_NUMBER = 3071;
    public static final int GET_NASIM_FILE_UPLOAD_URL_FIELD_NUMBER = 143;
    public static final int GET_NASIM_FILE_URLS_FIELD_NUMBER = 2591;
    public static final int GET_NASIM_FILE_URL_FIELD_NUMBER = 2815;
    public static final int GET_OTPTOKEN_FIELD_NUMBER = 62761;
    public static final int GET_OTP_TOKEN_V2_FIELD_NUMBER = 63258;
    public static final int GET_PACKETS_STATUS_FIELD_NUMBER = 63597;
    public static final int GET_PACKET_FIELD_NUMBER = 63604;
    public static final int GET_PARAMETERS_FIELD_NUMBER = 134;
    public static final int GET_PARTICIPANTS_FIELD_NUMBER = 63512;
    public static final int GET_PAYMENT_TOKEN_BY_CARD_FIELD_NUMBER = 62747;
    public static final int GET_PAYMENT_TOKEN_FIELD_NUMBER = 62408;
    public static final int GET_PAYVAND_CARD_FIELD_NUMBER = 62132;
    public static final int GET_PAYVAND_CARD_LIST_FIELD_NUMBER = 62130;
    public static final int GET_PAY_MONEY_REQUEST_TOKEN_FIELD_NUMBER = 62127;
    public static final int GET_POINT_BALANCE_FIELD_NUMBER = 63434;
    public static final int GET_POINT_DETAILS_FIELD_NUMBER = 63458;
    public static final int GET_POINT_SUMMERY_FIELD_NUMBER = 63451;
    public static final int GET_PSPROXY_PAYMENT_TOKEN_FIELD_NUMBER = 53258;
    public static final int GET_PSPROXY_TOKEN_FIELD_NUMBER = 53256;
    public static final int GET_REACTIONS_FIELD_NUMBER = 63254;
    public static final int GET_RECENT_CHARGES_FIELD_NUMBER = 62412;
    public static final int GET_RECENT_INTERNET_BUNDLE_ORDERS_FIELD_NUMBER = 63534;
    public static final int GET_RECENT_ORDERS_FIELD_NUMBER = 63507;
    public static final int GET_RECIPIENTS_FIELD_NUMBER = 63626;
    public static final int GET_REFERENCED_ENTITITES_FIELD_NUMBER = 2628;
    public static final int GET_REFERRAL_CODE_FIELD_NUMBER = 63500;
    public static final int GET_REFERRAL_CONTACTS_FIELD_NUMBER = 63601;
    public static final int GET_REFERRED_COUNT_FIELD_NUMBER = 63477;
    public static final int GET_REFERRING_USER_FIELD_NUMBER = 63460;
    public static final int GET_REMAIN_TOKEN_FIELD_NUMBER = 58106;
    public static final int GET_SADAD_PSPPAYMENT_TOKEN_FIELD_NUMBER = 62180;
    public static final int GET_SAVED_BILLS_FIELD_NUMBER = 63551;
    public static final int GET_SCORE_BOARD_FIELD_NUMBER = 63593;
    public static final int GET_STATES_FIELD_NUMBER = 63615;
    public static final int GET_STATE_FIELD_NUMBER = 9;
    public static final int GET_SUB_TRANSACTIONS_FIELD_NUMBER = 63653;
    public static final int GET_TOTAL_PAID_AMOUNT_FIELD_NUMBER = 63527;
    public static final int GET_TRANSACTION_TAGS_FIELD_NUMBER = 63516;
    public static final int GET_USERS_DEFAULT_CARD_NUMBER_FIELD_NUMBER = 63541;
    public static final int GET_USERS_PRESENCE_FIELD_NUMBER = 63644;
    public static final int GET_USER_ACCOUNTS_FIELD_NUMBER = 63443;
    public static final int GET_USER_BANK_FIELD_NUMBER = 63522;
    public static final int GET_USER_CONTEXT_FIELD_NUMBER = 137;
    public static final int GET_USER_REFERS_FIELD_NUMBER = 63599;
    public static final int GET_USER_SCORE_FIELD_NUMBER = 63595;
    public static final int GET_USER_SEFTES_FIELD_NUMBER = 63620;
    public static final int GET_USER_STATUS_FIELD_NUMBER = 63441;
    public static final int GET_USER_TAGS_FIELD_NUMBER = 63520;
    public static final int GET_USER_VITRINE_FIELD_NUMBER = 63256;
    public static final int GET_VOUCHERS_FIELD_NUMBER = 63472;
    public static final int GET_WALLET_CHARGE_TOKEN_FIELD_NUMBER = 62733;
    public static final int GET_WALLET_CONTRACTS_FIELD_NUMBER = 62758;
    public static final int GET_WALLET_INVOICE_FIELD_NUMBER = 62752;
    public static final int GET_WEBVIEW_TRACKING_NUMBER_FIELD_NUMBER = 63481;
    public static final int GET_WHEEL_FIELD_NUMBER = 63468;
    public static final int GRANT_BANKI_ACCESS_FIELD_NUMBER = 62397;
    public static final int IMPORT_CONTACTS_FIELD_NUMBER = 7;
    public static final int INIT_P12_FIELD_NUMBER = 63608;
    public static final int INIT_SEFTE_FIELD_NUMBER = 63610;
    public static final int INQUIRY_BILL_FIELD_NUMBER = 63543;
    public static final int INVITE_USER_FIELD_NUMBER = 69;
    public static final int INVOICE_KIFPOOL_FIELD_NUMBER = 63409;
    public static final int JOIN_GROUP_FIELD_NUMBER = 180;
    public static final int JOIN_PUBLIC_GROUP_FIELD_NUMBER = 2881;
    public static final int KICK_USER_FIELD_NUMBER = 71;
    public static final int LEAVE_GROUP_FIELD_NUMBER = 70;
    public static final int LOAD_ARCHIVED_FIELD_NUMBER = 2651;
    public static final int LOAD_AVATARS_FIELD_NUMBER = 2656;
    public static final int LOAD_BLOCKED_USERS_FIELD_NUMBER = 2638;
    public static final int LOAD_DIALOGS_FIELD_NUMBER = 104;
    public static final int LOAD_FULL_GROUPS_FIELD_NUMBER = 2782;
    public static final int LOAD_FULL_USERS_FIELD_NUMBER = 2649;
    public static final int LOAD_GROUPED_DIALOGS_FIELD_NUMBER = 225;
    public static final int LOAD_GROUPS_FIELD_NUMBER = 63245;
    public static final int LOAD_GROUP_AVATARS_FIELD_NUMBER = 43748;
    public static final int LOAD_HISTORY_FIELD_NUMBER = 118;
    public static final int LOAD_LAST_STATES_FIELD_NUMBER = 63659;
    public static final int LOAD_LOAN_HISTORY_FIELD_NUMBER = 63656;
    public static final int LOAD_MEMBERS_FIELD_NUMBER = 2786;
    public static final int LOAD_OWN_STICKERS_FIELD_NUMBER = 238;
    public static final int LOAD_PEER_DIALOGS_FIELD_NUMBER = 63249;
    public static final int LOAD_REACTIONS_FIELD_NUMBER = 63239;
    public static final int LOAD_STICKER_COLLECTION_FIELD_NUMBER = 246;
    public static final int LOAD_TRANSACTIONS_BY_IDS_FIELD_NUMBER = 63649;
    public static final int LOAD_TRANSACTIONS_FIELD_NUMBER = 63445;
    public static final int LOAD_USERS_FIELD_NUMBER = 63247;
    public static final int MAKE_USER_ADMIN_FIELD_NUMBER = 2784;
    public static final int MESSAGE_READ_FIELD_NUMBER = 57;
    public static final int MESSAGE_RECEIVED_FIELD_NUMBER = 55;
    public static final int MESSAGE_REMOVE_REACTION_FIELD_NUMBER = 220;
    public static final int MESSAGE_SET_REACTION_FIELD_NUMBER = 210;
    public static final int NEW_FAT_SEQ_UPDATE_FIELD_NUMBER = 1168;
    public static final int NEW_SEQ_UPDATE_FIELD_NUMBER = 45;
    public static final int NOTIFY_ABOUT_DEVICE_INFO_FIELD_NUMBER = 229;
    public static final int OPEN_GIFT_PACKET_FIELD_NUMBER = 63236;
    private static volatile KW4 PARSER = null;
    public static final int PAY_BILL_FIELD_NUMBER = 63545;
    public static final int PAY_BY_WALLET_FIELD_NUMBER = 62746;
    public static final int PAY_MONEY_REQUEST_BY_WALLET_FIELD_NUMBER = 62751;
    public static final int PAY_SEFTE_FIELD_NUMBER = 63614;
    public static final int PIN_MESSAGE_FIELD_NUMBER = 470;
    public static final int PROTO_FIELD_NUMBER = 63639;
    public static final int PURCHASE_MESSAGE_FIELD_NUMBER = 63418;
    public static final int PURCHASE_MESSAGE_WITH_CHARGE_FIELD_NUMBER = 63428;
    public static final int REACTIVATE_APP_FIELD_NUMBER = 63591;
    public static final int REFER_FIELD_NUMBER = 63502;
    public static final int REGISTER_FOR_EARN_MONEY_FIELD_NUMBER = 63438;
    public static final int REGISTER_GOOGLE_PUSH_FIELD_NUMBER = 51;
    public static final int REMOVE_AVATAR_FIELD_NUMBER = 91;
    public static final int REMOVE_CARD_FIELD_NUMBER = 63557;
    public static final int REMOVE_CONTACT_FIELD_NUMBER = 89;
    public static final int REMOVE_DEFAULT_CARD_FIELD_NUMBER = 63565;
    public static final int REMOVE_DEFAULT_CARD_NUMBER_FIELD_NUMBER = 62177;
    public static final int REMOVE_DESTINATION_CARDS_FIELD_NUMBER = 63590;
    public static final int REMOVE_GIF_FIELD_NUMBER = 2859;
    public static final int REMOVE_GROUP_AVATAR_FIELD_NUMBER = 101;
    public static final int REMOVE_LOAN_FIELD_NUMBER = 63658;
    public static final int REMOVE_PIN_FIELD_NUMBER = 471;
    public static final int REMOVE_STICKER_COLLECTION_FIELD_NUMBER = 245;
    public static final int REMOVE_TRANSACTION_FIELD_NUMBER = 63646;
    public static final int REMOVE_TRANSACTION_TAGS_FIELD_NUMBER = 63450;
    public static final int REMOVE_USER_ADMIN_FIELD_NUMBER = 44576;
    public static final int REMOVE_USER_TAGS_FIELD_NUMBER = 63519;
    public static final int RENAME_SAVED_BILL_FIELD_NUMBER = 63553;
    public static final int RESET_CONTACTS_FIELD_NUMBER = 63661;
    public static final int RESPONSE_ADD_DESTINATION_CARDS_FIELD_NUMBER = 63589;
    public static final int RESPONSE_ADD_NEW_CARDS_FIELD_NUMBER = 63556;
    public static final int RESPONSE_AUTHORIZE_USER_FIELD_NUMBER = 63607;
    public static final int RESPONSE_AUTH_FIELD_NUMBER = 5;
    public static final int RESPONSE_BOOL_FIELD_NUMBER = 209;
    public static final int RESPONSE_BUY_CHARGE_FIELD_NUMBER = 63538;
    public static final int RESPONSE_BUY_FAST_CHARGE_FIELD_NUMBER = 62465;
    public static final int RESPONSE_BUY_INTERNET_BUNDLE_FIELD_NUMBER = 63540;
    public static final int RESPONSE_BUY_VOUCHER_FIELD_NUMBER = 63475;
    public static final int RESPONSE_BUY_WHEEL_CHANCE_FIELD_NUMBER = 63467;
    public static final int RESPONSE_CALL_FIELD_NUMBER = 63581;
    public static final int RESPONSE_CAN_SEE_MESSAGES_FIELD_NUMBER = 725;
    public static final int RESPONSE_CASHOUT_KIFPOOL_FIELD_NUMBER = 63408;
    public static final int RESPONSE_CHANGE_POINT_TO_MONEY_FIELD_NUMBER = 63465;
    public static final int RESPONSE_CHARGE_FIELD_NUMBER = 63416;
    public static final int RESPONSE_CHECK_CHARGE_PERMISSION_FIELD_NUMBER = 63414;
    public static final int RESPONSE_CREATE_GROUP_FIELD_NUMBER = 216;
    public static final int RESPONSE_CREATE_KIFPOOL_FIELD_NUMBER = 63405;
    public static final int RESPONSE_CREATE_SAVED_BILL_FIELD_NUMBER = 63550;
    public static final int RESPONSE_CRYPTO_TRANSFER_FIELD_NUMBER = 63633;
    public static final int RESPONSE_DIALOGS_ORDER_FIELD_NUMBER = 235;
    public static final int RESPONSE_EDIT_AVATAR_FIELD_NUMBER = 103;
    public static final int RESPONSE_EDIT_GROUP_AVATAR_FIELD_NUMBER = 115;
    public static final int RESPONSE_ENROLL_NEW_CARD_FIELD_NUMBER = 63488;
    public static final int RESPONSE_FETCH_GROUP_ADMINS_FIELD_NUMBER = 730;
    public static final int RESPONSE_FILTER_TAGGED_TRANSACTIONS_FIELD_NUMBER = 63631;
    public static final int RESPONSE_GET_ACQUIRED_VOUCHERS_FIELD_NUMBER = 63638;
    public static final int RESPONSE_GET_AD_PROVIDER_FIELD_NUMBER = 63526;
    public static final int RESPONSE_GET_AUTH_SESSIONS_FIELD_NUMBER = 81;
    public static final int RESPONSE_GET_BAM_SERVICE_TOKEN_FIELD_NUMBER = 62407;
    public static final int RESPONSE_GET_BILL_HISTORY_FIELD_NUMBER = 63548;
    public static final int RESPONSE_GET_BOT_WHITE_LIST_FIELD_NUMBER = 3856;
    public static final int RESPONSE_GET_CARDS_FIELD_NUMBER = 63559;
    public static final int RESPONSE_GET_CARD_INFO_FIELD_NUMBER = 63490;
    public static final int RESPONSE_GET_CARD_TRANSFER_TOKEN_FIELD_NUMBER = 62126;
    public static final int RESPONSE_GET_CHANNEL_ADS_FIELD_NUMBER = 63265;
    public static final int RESPONSE_GET_CHANNEL_EARN_MONEY_INFO_FIELD_NUMBER = 63448;
    public static final int RESPONSE_GET_CHANNEL_EARN_MONEY_STATUS_FIELD_NUMBER = 63437;
    public static final int RESPONSE_GET_CHARGE_AMOUNTS_FIELD_NUMBER = 63511;
    public static final int RESPONSE_GET_CHARGE_PAYMENT_TOKEN_FIELD_NUMBER = 63406;
    public static final int RESPONSE_GET_CITIES_OF_STATE_FIELD_NUMBER = 63618;
    public static final int RESPONSE_GET_CONTACTS_FIELD_NUMBER = 88;
    public static final int RESPONSE_GET_CRYPTO_WALLETS_FIELD_NUMBER = 63635;
    public static final int RESPONSE_GET_DEFAULT_CARD_FIELD_NUMBER = 63564;
    public static final int RESPONSE_GET_DESTINATION_CARDS_FIELD_NUMBER = 63587;
    public static final int RESPONSE_GET_DESTINATION_CARD_INFO_FIELD_NUMBER = 63492;
    public static final int RESPONSE_GET_DIALOG_AD_ORDER_DETAILS_FIELD_NUMBER = 63569;
    public static final int RESPONSE_GET_DIALOG_AD_ORDER_PAYMENT_TOKEN_FIELD_NUMBER = 63572;
    public static final int RESPONSE_GET_GIFT_PACKET_PAYMENT_TOKEN_FIELD_NUMBER = 63231;
    public static final int RESPONSE_GET_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER = 130;
    public static final int RESPONSE_GET_GROUP_DIFFERENCE_FIELD_NUMBER = 204;
    public static final int RESPONSE_GET_GROUP_MEMBERS_COUNT_FIELD_NUMBER = 63504;
    public static final int RESPONSE_GET_GROUP_MEMBERS_PRESENCE_FIELD_NUMBER = 63643;
    public static final int RESPONSE_GET_GROUP_STATE_FIELD_NUMBER = 23;
    public static final int RESPONSE_GET_INTERNET_BUNDLE_LIST_FIELD_NUMBER = 63533;
    public static final int RESPONSE_GET_INTERNET_BUNDLE_PAYMENT_TOKEN_FIELD_NUMBER = 63531;
    public static final int RESPONSE_GET_JWT_TOKEN_FIELD_NUMBER = 601;
    public static final int RESPONSE_GET_KIFPOOL_OWNER_FIELD_NUMBER = 63421;
    public static final int RESPONSE_GET_LINK_PREVIEW_FIELD_NUMBER = 63498;
    public static final int RESPONSE_GET_LOANS_LIST_FIELD_NUMBER = 63585;
    public static final int RESPONSE_GET_LOAN_INFO_FIELD_NUMBER = 63583;
    public static final int RESPONSE_GET_MEMBER_PERMISSIONS_FIELD_NUMBER = 63457;
    public static final int RESPONSE_GET_MESSAGES_REPLIES_INFO_FIELD_NUMBER = 63664;
    public static final int RESPONSE_GET_MONEY_REQUEST_DETAILS_FIELD_NUMBER = 62400;
    public static final int RESPONSE_GET_MONEY_REQUEST_PAYMENT_LIST_FIELD_NUMBER = 62402;
    public static final int RESPONSE_GET_MONEY_REQUEST_PAYMENT_TOKEN_BY_CARD_FIELD_NUMBER = 62770;
    public static final int RESPONSE_GET_MY_BANK_FIELD_NUMBER = 63244;
    public static final int RESPONSE_GET_MY_GROUPS_FIELD_NUMBER = 43747;
    public static final int RESPONSE_GET_MY_KIFPOOLS_FIELD_NUMBER = 63401;
    public static final int RESPONSE_GET_MY_SENTENCE_FIELD_NUMBER = 63574;
    public static final int RESPONSE_GET_MY_WALLETS_FIELD_NUMBER = 62731;
    public static final int RESPONSE_GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER = 3056;
    public static final int RESPONSE_GET_NASIM_FILE_UPLOAD_RESUME_FIELD_NUMBER = 3055;
    public static final int RESPONSE_GET_NASIM_FILE_UPLOAD_URL_FIELD_NUMBER = 157;
    public static final int RESPONSE_GET_NASIM_FILE_URLS_FIELD_NUMBER = 2607;
    public static final int RESPONSE_GET_NASIM_FILE_URL_FIELD_NUMBER = 2799;
    public static final int RESPONSE_GET_OTPTOKEN_FIELD_NUMBER = 62768;
    public static final int RESPONSE_GET_OTP_TOKEN_V2_FIELD_NUMBER = 63259;
    public static final int RESPONSE_GET_PACKETS_STATUS_FIELD_NUMBER = 63598;
    public static final int RESPONSE_GET_PARAMETERS_FIELD_NUMBER = 135;
    public static final int RESPONSE_GET_PARTICIPANTS_FIELD_NUMBER = 63513;
    public static final int RESPONSE_GET_PAYMENT_TOKEN_BY_CARD_FIELD_NUMBER = 62748;
    public static final int RESPONSE_GET_PAYMENT_TOKEN_FIELD_NUMBER = 62409;
    public static final int RESPONSE_GET_PAYVAND_CARD_FIELD_NUMBER = 62133;
    public static final int RESPONSE_GET_PAYVAND_CARD_LIST_FIELD_NUMBER = 62131;
    public static final int RESPONSE_GET_PAY_MONEY_REQUEST_TOKEN_FIELD_NUMBER = 62128;
    public static final int RESPONSE_GET_POINT_BALANCE_FIELD_NUMBER = 63435;
    public static final int RESPONSE_GET_POINT_DETAILS_FIELD_NUMBER = 63459;
    public static final int RESPONSE_GET_POINT_SUMMERY_FIELD_NUMBER = 63452;
    public static final int RESPONSE_GET_PSPROXY_PAYMENT_TOKEN_FIELD_NUMBER = 53259;
    public static final int RESPONSE_GET_PSPROXY_TOKEN_FIELD_NUMBER = 53257;
    public static final int RESPONSE_GET_PSP_PAYMENTTOKEN_FIELD_NUMBER = 63486;
    public static final int RESPONSE_GET_REACTIONS_FIELD_NUMBER = 63255;
    public static final int RESPONSE_GET_RECENT_CHARGES_FIELD_NUMBER = 62414;
    public static final int RESPONSE_GET_RECENT_INTERNET_BUNDLE_ORDERS_FIELD_NUMBER = 63535;
    public static final int RESPONSE_GET_RECENT_ORDERS_FIELD_NUMBER = 63508;
    public static final int RESPONSE_GET_RECIPIENTS_FIELD_NUMBER = 63627;
    public static final int RESPONSE_GET_REFERENCED_ENTITITES_FIELD_NUMBER = 2629;
    public static final int RESPONSE_GET_REFERRAL_CODE_FIELD_NUMBER = 63501;
    public static final int RESPONSE_GET_REFERRAL_CONTACTS_FIELD_NUMBER = 63602;
    public static final int RESPONSE_GET_REFERRED_COUNT_FIELD_NUMBER = 63478;
    public static final int RESPONSE_GET_REFERRING_USER_FIELD_NUMBER = 63461;
    public static final int RESPONSE_GET_REMAIN_TOKEN_FIELD_NUMBER = 62138;
    public static final int RESPONSE_GET_SADAD_PSPPAYMENT_TOKEN_FIELD_NUMBER = 62181;
    public static final int RESPONSE_GET_SAVED_BILLS_FIELD_NUMBER = 63552;
    public static final int RESPONSE_GET_SCORE_BOARD_FIELD_NUMBER = 63594;
    public static final int RESPONSE_GET_STATES_FIELD_NUMBER = 63616;
    public static final int RESPONSE_GET_SUB_TRANSACTIONS_FIELD_NUMBER = 63654;
    public static final int RESPONSE_GET_TICKET_FIELD_NUMBER = 63261;
    public static final int RESPONSE_GET_TOTAL_PAID_AMOUNT_FIELD_NUMBER = 63528;
    public static final int RESPONSE_GET_TRANSACTION_TAGS_FIELD_NUMBER = 63517;
    public static final int RESPONSE_GET_USERS_DEFAULT_CARD_NUMBER_FIELD_NUMBER = 63542;
    public static final int RESPONSE_GET_USERS_PRESENCE_FIELD_NUMBER = 63645;
    public static final int RESPONSE_GET_USER_ACCOUNTS_FIELD_NUMBER = 63444;
    public static final int RESPONSE_GET_USER_BANK_FIELD_NUMBER = 63524;
    public static final int RESPONSE_GET_USER_CONTEXT_FIELD_NUMBER = 146;
    public static final int RESPONSE_GET_USER_REFERS_FIELD_NUMBER = 63600;
    public static final int RESPONSE_GET_USER_SCORE_FIELD_NUMBER = 63596;
    public static final int RESPONSE_GET_USER_SEFTES_FIELD_NUMBER = 63621;
    public static final int RESPONSE_GET_USER_STATUS_FIELD_NUMBER = 63442;
    public static final int RESPONSE_GET_USER_TAGS_FIELD_NUMBER = 63521;
    public static final int RESPONSE_GET_USER_VITRINE_FIELD_NUMBER = 63257;
    public static final int RESPONSE_GET_VOUCHERS_FIELD_NUMBER = 63473;
    public static final int RESPONSE_GET_WALLET_CHARGE_TOKEN_FIELD_NUMBER = 62734;
    public static final int RESPONSE_GET_WALLET_CONTRACTS_FIELD_NUMBER = 62759;
    public static final int RESPONSE_GET_WALLET_INVOICE_FIELD_NUMBER = 62729;
    public static final int RESPONSE_GET_WEBVIEW_TRACKING_NUMBER_FIELD_NUMBER = 63482;
    public static final int RESPONSE_GET_WHEEL_FIELD_NUMBER = 63469;
    public static final int RESPONSE_IMPORT_CONTACTS_FIELD_NUMBER = 8;
    public static final int RESPONSE_INIT_P12_FIELD_NUMBER = 63609;
    public static final int RESPONSE_INIT_SEFTE_FIELD_NUMBER = 63611;
    public static final int RESPONSE_INQUIRY_BILL_FIELD_NUMBER = 63544;
    public static final int RESPONSE_INVITE_URL_FIELD_NUMBER = 178;
    public static final int RESPONSE_INVOICE_KIFPOOL_FIELD_NUMBER = 63410;
    public static final int RESPONSE_JOIN_GROUP_FIELD_NUMBER = 181;
    public static final int RESPONSE_JOIN_PUBLIC_GROUP_FIELD_NUMBER = 2897;
    public static final int RESPONSE_LOAD_ARCHIVED_FIELD_NUMBER = 2652;
    public static final int RESPONSE_LOAD_AVATARS_FIELD_NUMBER = 2812;
    public static final int RESPONSE_LOAD_BLOCKED_USERS_FIELD_NUMBER = 2639;
    public static final int RESPONSE_LOAD_DIALOGS_FIELD_NUMBER = 105;
    public static final int RESPONSE_LOAD_FULL_GROUPS_FIELD_NUMBER = 2783;
    public static final int RESPONSE_LOAD_FULL_USERS_FIELD_NUMBER = 2650;
    public static final int RESPONSE_LOAD_GROUPED_DIALOGS_FIELD_NUMBER = 226;
    public static final int RESPONSE_LOAD_GROUPS_FIELD_NUMBER = 63246;
    public static final int RESPONSE_LOAD_GROUP_AVATARS_FIELD_NUMBER = 43749;
    public static final int RESPONSE_LOAD_HISTORY_FIELD_NUMBER = 119;
    public static final int RESPONSE_LOAD_LAST_STATES_FIELD_NUMBER = 63660;
    public static final int RESPONSE_LOAD_LOAN_HISTORY_FIELD_NUMBER = 63657;
    public static final int RESPONSE_LOAD_MEMBERS_FIELD_NUMBER = 2787;
    public static final int RESPONSE_LOAD_OWN_STICKERS_FIELD_NUMBER = 239;
    public static final int RESPONSE_LOAD_PEER_DIALOGS_FIELD_NUMBER = 63250;
    public static final int RESPONSE_LOAD_REACTIONS_FIELD_NUMBER = 63240;
    public static final int RESPONSE_LOAD_STICKER_COLLECTION_FIELD_NUMBER = 247;
    public static final int RESPONSE_LOAD_TRANSACTIONS_BY_IDS_FIELD_NUMBER = 63650;
    public static final int RESPONSE_LOAD_TRANSACTIONS_FIELD_NUMBER = 63446;
    public static final int RESPONSE_LOAD_USERS_FIELD_NUMBER = 63248;
    public static final int RESPONSE_OPEN_GIFT_PACKET_FIELD_NUMBER = 63237;
    public static final int RESPONSE_PAY_BILL_FIELD_NUMBER = 63546;
    public static final int RESPONSE_PAY_SEFTE_FIELD_NUMBER = 63636;
    public static final int RESPONSE_PROTO_FIELD_NUMBER = 63640;
    public static final int RESPONSE_PURCHASE_MESSAGE_FIELD_NUMBER = 63419;
    public static final int RESPONSE_PURCHASE_MESSAGE_WITH_CHARGE_FIELD_NUMBER = 63429;
    public static final int RESPONSE_REACTIONS_RESPONSE_FIELD_NUMBER = 219;
    public static final int RESPONSE_REACTIVATE_APP_FIELD_NUMBER = 63592;
    public static final int RESPONSE_REFER_FIELD_NUMBER = 63503;
    public static final int RESPONSE_SEARCH_CONTACTS_FIELD_NUMBER = 113;
    public static final int RESPONSE_SEARCH_MEDIA_FIELD_NUMBER = 63263;
    public static final int RESPONSE_SEARCH_MESSAGES_FIELD_NUMBER = 218;
    public static final int RESPONSE_SEARCH_PEER_FIELD_NUMBER = 234;
    public static final int RESPONSE_SEND_CHANGE_PHONE_VERIFICATION_CODE_FIELD_NUMBER = 63505;
    public static final int RESPONSE_SEND_DELETE_ACCOUNT_VERIFICATION_CODE_FIELD_NUMBER = 3089;
    public static final int RESPONSE_SEQ_DATE_FIELD_NUMBER = 102;
    public static final int RESPONSE_SEQ_FIELD_NUMBER = 72;
    public static final int RESPONSE_SIGN_SEFTE_FIELD_NUMBER = 63613;
    public static final int RESPONSE_SPIN_WHEEL_FIELD_NUMBER = 63471;
    public static final int RESPONSE_SPLIT_TRANSACTION_FIELD_NUMBER = 63648;
    public static final int RESPONSE_START_PHONE_AUTH_FIELD_NUMBER = 193;
    public static final int RESPONSE_STICKERS_REPONSE_FIELD_NUMBER = 240;
    public static final int RESPONSE_TRANSACTION_POINT_FIELD_NUMBER = 63463;
    public static final int RESPONSE_TRANSFER_MONEY_FIELD_NUMBER = 63412;
    public static final int RESPONSE_UPDATE_CLICK_FIELD_NUMBER = 63623;
    public static final int RESPONSE_UPDATE_VIEW_FIELD_NUMBER = 63561;
    public static final int RESPONSE_UPGRADE_KIFPOOL_FIELD_NUMBER = 63403;
    public static final int RESPONSE_USER_HAS_CRED_FIELD_NUMBER = 63625;
    public static final int RESPONSE_VALIDATE_MY_SENTENCE_FIELD_NUMBER = 63576;
    public static final int RESPONSE_VERIFY_CASH_OUT_FIELD_NUMBER = 62763;
    public static final int RESPONSE_VERIFY_CASH_OUT_KIFPOOL_FIELD_NUMBER = 63433;
    public static final int RESPONSE_VERIFY_PEER_FIELD_NUMBER = 62757;
    public static final int RESPONSE_VERIFY_PURCHASE_MESSAGE_FIELD_NUMBER = 63431;
    public static final int RESPONSE_VERIFY_QRCODE_FIELD_NUMBER = 62750;
    public static final int RESPONSE_VOID_FIELD_NUMBER = 50;
    public static final int REVIVE_TRANSACTION_FIELD_NUMBER = 63655;
    public static final int REVOKE_INVITE_URL_FIELD_NUMBER = 179;
    public static final int SEARCH_CONTACTS_FIELD_NUMBER = 112;
    public static final int SEARCH_MEDIA_FIELD_NUMBER = 63262;
    public static final int SEARCH_MESSAGES_FIELD_NUMBER = 217;
    public static final int SEARCH_MESSAGES_MORE_FIELD_NUMBER = 222;
    public static final int SEARCH_PEER_FIELD_NUMBER = 233;
    public static final int SEND_CHANGE_PHONE_VERIFICATION_CODE_FIELD_NUMBER = 63454;
    public static final int SEND_DELETE_ACCOUNT_VERIFICATION_CODE_FIELD_NUMBER = 43609;
    public static final int SEND_FEED_BACK_FIELD_NUMBER = 63529;
    public static final int SEND_GIFT_PACKET_WITH_WALLET_FIELD_NUMBER = 63233;
    public static final int SEND_INLINE_CALLBACK_DATA_FIELD_NUMBER = 3937;
    public static final int SEND_MESSAGE_FIELD_NUMBER = 92;
    public static final int SEND_MULTI_MEDIA_MESSAGE_FIELD_NUMBER = 63662;
    public static final int SEND_MY_GIFT_PACKET_FIELD_NUMBER = 63577;
    public static final int SEND_REFERRAL_FIELD_NUMBER = 63603;
    public static final int SEND_SERAJ_EVENT_FIELD_NUMBER = 63238;
    public static final int SEQ_UPDATE_FIELD_NUMBER = 13;
    public static final int SEQ_UPDATE_TOO_LONG_FIELD_NUMBER = 25;
    public static final int SET_CAN_SEE_MESSAGES_FIELD_NUMBER = 724;
    public static final int SET_DEFAULT_CARD_FIELD_NUMBER = 63562;
    public static final int SET_GROUP_DEFAULT_PERMISSIONS_FIELD_NUMBER = 63476;
    public static final int SET_MEMBER_PERMISSIONS_FIELD_NUMBER = 63455;
    public static final int SET_ONLINE_FIELD_NUMBER = 29;
    public static final int SET_RECENT_ORDER_FIELD_NUMBER = 63506;
    public static final int SET_RESTRICTION_FIELD_NUMBER = 728;
    public static final int SIGN_OUT_FIELD_NUMBER = 84;
    public static final int SIGN_SEFTE_FIELD_NUMBER = 63612;
    public static final int SIGN_UP_FIELD_NUMBER = 190;
    public static final int SPIN_WHEEL_FIELD_NUMBER = 63470;
    public static final int SPLIT_TRANSACTION_FIELD_NUMBER = 63647;
    public static final int START_CALL_FIELD_NUMBER = 63578;
    public static final int START_PHONE_AUTH_FIELD_NUMBER = 191;
    public static final int STOP_TYPING_FIELD_NUMBER = 30;
    public static final int SUBMIT_DIALOG_AD_ORDER_FIELD_NUMBER = 63567;
    public static final int SUBSCRIBE_FROM_GROUP_ONLINE_FIELD_NUMBER = 75;
    public static final int SUBSCRIBE_FROM_ONLINE_FIELD_NUMBER = 33;
    public static final int SUBSCRIBE_TO_GROUP_ONLINE_FIELD_NUMBER = 74;
    public static final int SUBSCRIBE_TO_ONLINE_FIELD_NUMBER = 32;
    public static final int TERMINATE_ALL_SESSIONS_FIELD_NUMBER = 83;
    public static final int TERMINATE_SESSION_FIELD_NUMBER = 82;
    public static final int TRANSACTION_POINT_FIELD_NUMBER = 63462;
    public static final int TRANSFER_MONEY_BY_CARD_FIELD_NUMBER = 63495;
    public static final int TRANSFER_MONEY_FIELD_NUMBER = 63411;
    public static final int TRANSFER_OWNERSHIP_FIELD_NUMBER = 2789;
    public static final int TYPING_FIELD_NUMBER = 27;
    public static final int UNBIND_ALL_MONEY_REQUEST_DETAILS_FIELD_NUMBER = 62411;
    public static final int UNBLOCK_USER_FIELD_NUMBER = 2637;
    public static final int UNREGISTER_ALL_PUSH_CREDENTIALS_FIELD_NUMBER = 63251;
    public static final int UNREGISTER_GOOGLE_PUSH_FIELD_NUMBER = 2631;
    public static final int UPDATE_CLICK_FIELD_NUMBER = 63622;
    public static final int UPDATE_GROUP_STATUS_FIELD_NUMBER = 63439;
    public static final int UPDATE_MESSAGE_FIELD_NUMBER = 2658;
    public static final int UPDATE_VIEW_FIELD_NUMBER = 63560;
    public static final int UPGRADE_KIFPOOL_FIELD_NUMBER = 63402;
    public static final int USER_HAS_CRED_FIELD_NUMBER = 63624;
    public static final int VALIDATE_CODE_FIELD_NUMBER = 189;
    public static final int VALIDATE_MY_SENTENCE_FIELD_NUMBER = 63575;
    public static final int VERIFY_CASH_OUT_FIELD_NUMBER = 62762;
    public static final int VERIFY_CASH_OUT_KIFPOOL_FIELD_NUMBER = 63432;
    public static final int VERIFY_PEER_FIELD_NUMBER = 62756;
    public static final int VERIFY_PURCHASE_MESSAGE_FIELD_NUMBER = 63430;
    public static final int VERIFY_QRCODE_FIELD_NUMBER = 62749;
    public static final int WEAK_FAT_UPDATE_FIELD_NUMBER = 2673;
    public static final int WEAK_UPDATE_FIELD_NUMBER = 26;
    private int traitCase_ = 0;
    private Object trait_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SetRpcStruct$ComposedRpc.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        RESPONSE_AUTH(5),
        IMPORT_CONTACTS(7),
        RESPONSE_IMPORT_CONTACTS(8),
        GET_STATE(9),
        SEQ_UPDATE(13),
        RESPONSE_GET_GROUP_STATE(23),
        SEQ_UPDATE_TOO_LONG(25),
        WEAK_UPDATE(26),
        TYPING(27),
        SET_ONLINE(29),
        STOP_TYPING(30),
        EDIT_AVATAR(31),
        SUBSCRIBE_TO_ONLINE(32),
        SUBSCRIBE_FROM_ONLINE(33),
        NEW_SEQ_UPDATE(45),
        RESPONSE_VOID(50),
        REGISTER_GOOGLE_PUSH(51),
        EDIT_NAME(53),
        MESSAGE_RECEIVED(55),
        MESSAGE_READ(57),
        INVITE_USER(69),
        LEAVE_GROUP(70),
        KICK_USER(71),
        RESPONSE_SEQ(72),
        FAT_SEQ_UPDATE(73),
        SUBSCRIBE_TO_GROUP_ONLINE(74),
        SUBSCRIBE_FROM_GROUP_ONLINE(75),
        GET_AUTH_SESSIONS(80),
        RESPONSE_GET_AUTH_SESSIONS(81),
        TERMINATE_SESSION(82),
        TERMINATE_ALL_SESSIONS(83),
        SIGN_OUT(84),
        EDIT_GROUP_TITLE(85),
        EDIT_GROUP_AVATAR(86),
        GET_CONTACTS(87),
        RESPONSE_GET_CONTACTS(88),
        REMOVE_CONTACT(89),
        REMOVE_AVATAR(91),
        SEND_MESSAGE(92),
        EDIT_USER_LOCAL_NAME(96),
        DELETE_MESSAGE(98),
        CLEAR_CHAT(99),
        DELETE_CHAT(100),
        REMOVE_GROUP_AVATAR(101),
        RESPONSE_SEQ_DATE(102),
        RESPONSE_EDIT_AVATAR(103),
        LOAD_DIALOGS(104),
        RESPONSE_LOAD_DIALOGS(105),
        SEARCH_CONTACTS(SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER),
        RESPONSE_SEARCH_CONTACTS(113),
        ADD_CONTACT(114),
        RESPONSE_EDIT_GROUP_AVATAR(115),
        LOAD_HISTORY(SetRpcStruct$ComposedRpc.LOAD_HISTORY_FIELD_NUMBER),
        RESPONSE_LOAD_HISTORY(119),
        EDIT_GROUP_DEFAULT_CARD_NUMBER(SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER),
        EDIT_PARAMETER(128),
        GET_GROUP_DEFAULT_CARD_NUMBER(129),
        RESPONSE_GET_GROUP_DEFAULT_CARD_NUMBER(130),
        GET_PARAMETERS(134),
        RESPONSE_GET_PARAMETERS(135),
        ADD_CARD(136),
        GET_NASIM_FILE_UPLOAD_URL(SetRpcStruct$ComposedRpc.GET_NASIM_FILE_UPLOAD_URL_FIELD_NUMBER),
        EDIT_MY_TIME_ZONE(SetRpcStruct$ComposedRpc.EDIT_MY_TIME_ZONE_FIELD_NUMBER),
        EDIT_MY_PREFERRED_LANGUAGES(SetRpcStruct$ComposedRpc.EDIT_MY_PREFERRED_LANGUAGES_FIELD_NUMBER),
        GET_GROUP_STATE(SetRpcStruct$ComposedRpc.GET_GROUP_STATE_FIELD_NUMBER),
        RESPONSE_GET_NASIM_FILE_UPLOAD_URL(SetRpcStruct$ComposedRpc.RESPONSE_GET_NASIM_FILE_UPLOAD_URL_FIELD_NUMBER),
        GET_GROUP_INVITE_URL(SetRpcStruct$ComposedRpc.GET_GROUP_INVITE_URL_FIELD_NUMBER),
        RESPONSE_INVITE_URL(SetRpcStruct$ComposedRpc.RESPONSE_INVITE_URL_FIELD_NUMBER),
        REVOKE_INVITE_URL(SetRpcStruct$ComposedRpc.REVOKE_INVITE_URL_FIELD_NUMBER),
        JOIN_GROUP(SetRpcStruct$ComposedRpc.JOIN_GROUP_FIELD_NUMBER),
        RESPONSE_JOIN_GROUP(SetRpcStruct$ComposedRpc.RESPONSE_JOIN_GROUP_FIELD_NUMBER),
        GET_GROUP_DIFFERENCE(SetRpcStruct$ComposedRpc.GET_GROUP_DIFFERENCE_FIELD_NUMBER),
        VALIDATE_CODE(SetRpcStruct$ComposedRpc.VALIDATE_CODE_FIELD_NUMBER),
        SIGN_UP(SetRpcStruct$ComposedRpc.SIGN_UP_FIELD_NUMBER),
        START_PHONE_AUTH(SetRpcStruct$ComposedRpc.START_PHONE_AUTH_FIELD_NUMBER),
        RESPONSE_START_PHONE_AUTH(SetRpcStruct$ComposedRpc.RESPONSE_START_PHONE_AUTH_FIELD_NUMBER),
        NOTIFY_ABOUT_DEVICE_INFO(SetRpcStruct$ComposedRpc.NOTIFY_ABOUT_DEVICE_INFO_FIELD_NUMBER),
        GET_JWT_TOKEN(SetRpcStruct$ComposedRpc.GET_JWT_TOKEN_FIELD_NUMBER),
        RESPONSE_GET_JWT_TOKEN(SetRpcStruct$ComposedRpc.RESPONSE_GET_JWT_TOKEN_FIELD_NUMBER),
        RESPONSE_GET_GROUP_DIFFERENCE(SetRpcStruct$ComposedRpc.RESPONSE_GET_GROUP_DIFFERENCE_FIELD_NUMBER),
        EDIT_NICK_NAME(SetRpcStruct$ComposedRpc.EDIT_NICK_NAME_FIELD_NUMBER),
        CHECK_NICK_NAME(SetRpcStruct$ComposedRpc.CHECK_NICK_NAME_FIELD_NUMBER),
        RESPONSE_BOOL(209),
        MESSAGE_SET_REACTION(210),
        EDIT_ABOUT(212),
        EDIT_GROUP_ABOUT(213),
        RESPONSE_CREATE_GROUP(216),
        SEARCH_MESSAGES(217),
        RESPONSE_SEARCH_MESSAGES(218),
        RESPONSE_REACTIONS_RESPONSE(219),
        MESSAGE_REMOVE_REACTION(SetRpcStruct$ComposedRpc.MESSAGE_REMOVE_REACTION_FIELD_NUMBER),
        SEARCH_MESSAGES_MORE(222),
        LOAD_GROUPED_DIALOGS(225),
        RESPONSE_LOAD_GROUPED_DIALOGS(226),
        CREATE_GROUP(SetRpcStruct$ComposedRpc.CREATE_GROUP_FIELD_NUMBER),
        SEARCH_PEER(SetRpcStruct$ComposedRpc.SEARCH_PEER_FIELD_NUMBER),
        RESPONSE_SEARCH_PEER(SetRpcStruct$ComposedRpc.RESPONSE_SEARCH_PEER_FIELD_NUMBER),
        RESPONSE_DIALOGS_ORDER(SetRpcStruct$ComposedRpc.RESPONSE_DIALOGS_ORDER_FIELD_NUMBER),
        LOAD_OWN_STICKERS(SetRpcStruct$ComposedRpc.LOAD_OWN_STICKERS_FIELD_NUMBER),
        RESPONSE_LOAD_OWN_STICKERS(SetRpcStruct$ComposedRpc.RESPONSE_LOAD_OWN_STICKERS_FIELD_NUMBER),
        RESPONSE_STICKERS_REPONSE(SetRpcStruct$ComposedRpc.RESPONSE_STICKERS_REPONSE_FIELD_NUMBER),
        ADD_STICKER_COLLECTION(SetRpcStruct$ComposedRpc.ADD_STICKER_COLLECTION_FIELD_NUMBER),
        REMOVE_STICKER_COLLECTION(245),
        LOAD_STICKER_COLLECTION(SetRpcStruct$ComposedRpc.LOAD_STICKER_COLLECTION_FIELD_NUMBER),
        RESPONSE_LOAD_STICKER_COLLECTION(SetRpcStruct$ComposedRpc.RESPONSE_LOAD_STICKER_COLLECTION_FIELD_NUMBER),
        PIN_MESSAGE(SetRpcStruct$ComposedRpc.PIN_MESSAGE_FIELD_NUMBER),
        REMOVE_PIN(SetRpcStruct$ComposedRpc.REMOVE_PIN_FIELD_NUMBER),
        SET_CAN_SEE_MESSAGES(SetRpcStruct$ComposedRpc.SET_CAN_SEE_MESSAGES_FIELD_NUMBER),
        RESPONSE_CAN_SEE_MESSAGES(SetRpcStruct$ComposedRpc.RESPONSE_CAN_SEE_MESSAGES_FIELD_NUMBER),
        GET_CAN_SEE_MESSAGES(SetRpcStruct$ComposedRpc.GET_CAN_SEE_MESSAGES_FIELD_NUMBER),
        SET_RESTRICTION(SetRpcStruct$ComposedRpc.SET_RESTRICTION_FIELD_NUMBER),
        FETCH_GROUP_ADMINS(SetRpcStruct$ComposedRpc.FETCH_GROUP_ADMINS_FIELD_NUMBER),
        RESPONSE_FETCH_GROUP_ADMINS(SetRpcStruct$ComposedRpc.RESPONSE_FETCH_GROUP_ADMINS_FIELD_NUMBER),
        NEW_FAT_SEQ_UPDATE(SetRpcStruct$ComposedRpc.NEW_FAT_SEQ_UPDATE_FIELD_NUMBER),
        GET_NASIM_FILE_URLS(SetRpcStruct$ComposedRpc.GET_NASIM_FILE_URLS_FIELD_NUMBER),
        RESPONSE_GET_NASIM_FILE_URLS(SetRpcStruct$ComposedRpc.RESPONSE_GET_NASIM_FILE_URLS_FIELD_NUMBER),
        COMBINED_UPDATE(2625),
        GET_REFERENCED_ENTITITES(2628),
        RESPONSE_GET_REFERENCED_ENTITITES(2629),
        UNREGISTER_GOOGLE_PUSH(SetRpcStruct$ComposedRpc.UNREGISTER_GOOGLE_PUSH_FIELD_NUMBER),
        BLOCK_USER(SetRpcStruct$ComposedRpc.BLOCK_USER_FIELD_NUMBER),
        UNBLOCK_USER(SetRpcStruct$ComposedRpc.UNBLOCK_USER_FIELD_NUMBER),
        LOAD_BLOCKED_USERS(SetRpcStruct$ComposedRpc.LOAD_BLOCKED_USERS_FIELD_NUMBER),
        RESPONSE_LOAD_BLOCKED_USERS(SetRpcStruct$ComposedRpc.RESPONSE_LOAD_BLOCKED_USERS_FIELD_NUMBER),
        LOAD_FULL_USERS(SetRpcStruct$ComposedRpc.LOAD_FULL_USERS_FIELD_NUMBER),
        RESPONSE_LOAD_FULL_USERS(SetRpcStruct$ComposedRpc.RESPONSE_LOAD_FULL_USERS_FIELD_NUMBER),
        LOAD_ARCHIVED(SetRpcStruct$ComposedRpc.LOAD_ARCHIVED_FIELD_NUMBER),
        RESPONSE_LOAD_ARCHIVED(SetRpcStruct$ComposedRpc.RESPONSE_LOAD_ARCHIVED_FIELD_NUMBER),
        LOAD_AVATARS(SetRpcStruct$ComposedRpc.LOAD_AVATARS_FIELD_NUMBER),
        UPDATE_MESSAGE(SetRpcStruct$ComposedRpc.UPDATE_MESSAGE_FIELD_NUMBER),
        WEAK_FAT_UPDATE(SetRpcStruct$ComposedRpc.WEAK_FAT_UPDATE_FIELD_NUMBER),
        LOAD_FULL_GROUPS(SetRpcStruct$ComposedRpc.LOAD_FULL_GROUPS_FIELD_NUMBER),
        RESPONSE_LOAD_FULL_GROUPS(SetRpcStruct$ComposedRpc.RESPONSE_LOAD_FULL_GROUPS_FIELD_NUMBER),
        MAKE_USER_ADMIN(SetRpcStruct$ComposedRpc.MAKE_USER_ADMIN_FIELD_NUMBER),
        LOAD_MEMBERS(SetRpcStruct$ComposedRpc.LOAD_MEMBERS_FIELD_NUMBER),
        RESPONSE_LOAD_MEMBERS(SetRpcStruct$ComposedRpc.RESPONSE_LOAD_MEMBERS_FIELD_NUMBER),
        TRANSFER_OWNERSHIP(SetRpcStruct$ComposedRpc.TRANSFER_OWNERSHIP_FIELD_NUMBER),
        RESPONSE_GET_NASIM_FILE_URL(SetRpcStruct$ComposedRpc.RESPONSE_GET_NASIM_FILE_URL_FIELD_NUMBER),
        RESPONSE_LOAD_AVATARS(SetRpcStruct$ComposedRpc.RESPONSE_LOAD_AVATARS_FIELD_NUMBER),
        GET_NASIM_FILE_URL(SetRpcStruct$ComposedRpc.GET_NASIM_FILE_URL_FIELD_NUMBER),
        ADD_GIF(SetRpcStruct$ComposedRpc.ADD_GIF_FIELD_NUMBER),
        REMOVE_GIF(SetRpcStruct$ComposedRpc.REMOVE_GIF_FIELD_NUMBER),
        JOIN_PUBLIC_GROUP(SetRpcStruct$ComposedRpc.JOIN_PUBLIC_GROUP_FIELD_NUMBER),
        RESPONSE_JOIN_PUBLIC_GROUP(SetRpcStruct$ComposedRpc.RESPONSE_JOIN_PUBLIC_GROUP_FIELD_NUMBER),
        RESPONSE_GET_NASIM_FILE_UPLOAD_RESUME(SetRpcStruct$ComposedRpc.RESPONSE_GET_NASIM_FILE_UPLOAD_RESUME_FIELD_NUMBER),
        RESPONSE_GET_NASIM_FILE_PUBLIC_URL(SetRpcStruct$ComposedRpc.RESPONSE_GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER),
        GET_NASIM_FILE_UPLOAD_RESUME(SetRpcStruct$ComposedRpc.GET_NASIM_FILE_UPLOAD_RESUME_FIELD_NUMBER),
        GET_NASIM_FILE_PUBLIC_URL(SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER),
        RESPONSE_SEND_DELETE_ACCOUNT_VERIFICATION_CODE(SetRpcStruct$ComposedRpc.RESPONSE_SEND_DELETE_ACCOUNT_VERIFICATION_CODE_FIELD_NUMBER),
        EDIT_CHANNEL_NICK(SetRpcStruct$ComposedRpc.EDIT_CHANNEL_NICK_FIELD_NUMBER),
        SEND_INLINE_CALLBACK_DATA(SetRpcStruct$ComposedRpc.SEND_INLINE_CALLBACK_DATA_FIELD_NUMBER),
        GET_BOT_WHITE_LIST(249),
        RESPONSE_GET_BOT_WHITE_LIST(SetRpcStruct$ComposedRpc.RESPONSE_GET_BOT_WHITE_LIST_FIELD_NUMBER),
        GET_USER_CONTEXT(137),
        RESPONSE_GET_USER_CONTEXT(SetRpcStruct$ComposedRpc.RESPONSE_GET_USER_CONTEXT_FIELD_NUMBER),
        DELETE_ACCOUNT(SetRpcStruct$ComposedRpc.DELETE_ACCOUNT_FIELD_NUMBER),
        SEND_DELETE_ACCOUNT_VERIFICATION_CODE(SetRpcStruct$ComposedRpc.SEND_DELETE_ACCOUNT_VERIFICATION_CODE_FIELD_NUMBER),
        GET_MY_GROUPS(SetRpcStruct$ComposedRpc.GET_MY_GROUPS_FIELD_NUMBER),
        RESPONSE_GET_MY_GROUPS(SetRpcStruct$ComposedRpc.RESPONSE_GET_MY_GROUPS_FIELD_NUMBER),
        LOAD_GROUP_AVATARS(SetRpcStruct$ComposedRpc.LOAD_GROUP_AVATARS_FIELD_NUMBER),
        RESPONSE_LOAD_GROUP_AVATARS(SetRpcStruct$ComposedRpc.RESPONSE_LOAD_GROUP_AVATARS_FIELD_NUMBER),
        REMOVE_USER_ADMIN(SetRpcStruct$ComposedRpc.REMOVE_USER_ADMIN_FIELD_NUMBER),
        GET_PSPROXY_TOKEN(SetRpcStruct$ComposedRpc.GET_PSPROXY_TOKEN_FIELD_NUMBER),
        RESPONSE_GET_PSPROXY_TOKEN(SetRpcStruct$ComposedRpc.RESPONSE_GET_PSPROXY_TOKEN_FIELD_NUMBER),
        GET_PSPROXY_PAYMENT_TOKEN(SetRpcStruct$ComposedRpc.GET_PSPROXY_PAYMENT_TOKEN_FIELD_NUMBER),
        RESPONSE_GET_PSPROXY_PAYMENT_TOKEN(SetRpcStruct$ComposedRpc.RESPONSE_GET_PSPROXY_PAYMENT_TOKEN_FIELD_NUMBER),
        GET_REMAIN_TOKEN(SetRpcStruct$ComposedRpc.GET_REMAIN_TOKEN_FIELD_NUMBER),
        GET_CARD_TRANSFER_TOKEN(SetRpcStruct$ComposedRpc.GET_CARD_TRANSFER_TOKEN_FIELD_NUMBER),
        RESPONSE_GET_CARD_TRANSFER_TOKEN(SetRpcStruct$ComposedRpc.RESPONSE_GET_CARD_TRANSFER_TOKEN_FIELD_NUMBER),
        GET_PAY_MONEY_REQUEST_TOKEN(SetRpcStruct$ComposedRpc.GET_PAY_MONEY_REQUEST_TOKEN_FIELD_NUMBER),
        RESPONSE_GET_PAY_MONEY_REQUEST_TOKEN(SetRpcStruct$ComposedRpc.RESPONSE_GET_PAY_MONEY_REQUEST_TOKEN_FIELD_NUMBER),
        CHANGE_DEFAULT_CARD_NUMBER(SetRpcStruct$ComposedRpc.CHANGE_DEFAULT_CARD_NUMBER_FIELD_NUMBER),
        GET_PAYVAND_CARD_LIST(SetRpcStruct$ComposedRpc.GET_PAYVAND_CARD_LIST_FIELD_NUMBER),
        RESPONSE_GET_PAYVAND_CARD_LIST(SetRpcStruct$ComposedRpc.RESPONSE_GET_PAYVAND_CARD_LIST_FIELD_NUMBER),
        GET_PAYVAND_CARD(SetRpcStruct$ComposedRpc.GET_PAYVAND_CARD_FIELD_NUMBER),
        RESPONSE_GET_PAYVAND_CARD(SetRpcStruct$ComposedRpc.RESPONSE_GET_PAYVAND_CARD_FIELD_NUMBER),
        RESPONSE_GET_REMAIN_TOKEN(SetRpcStruct$ComposedRpc.RESPONSE_GET_REMAIN_TOKEN_FIELD_NUMBER),
        REMOVE_DEFAULT_CARD_NUMBER(SetRpcStruct$ComposedRpc.REMOVE_DEFAULT_CARD_NUMBER_FIELD_NUMBER),
        GET_SADAD_PSPPAYMENT_TOKEN(SetRpcStruct$ComposedRpc.GET_SADAD_PSPPAYMENT_TOKEN_FIELD_NUMBER),
        RESPONSE_GET_SADAD_PSPPAYMENT_TOKEN(SetRpcStruct$ComposedRpc.RESPONSE_GET_SADAD_PSPPAYMENT_TOKEN_FIELD_NUMBER),
        GET_PAYMENT_TOKEN(SetRpcStruct$ComposedRpc.GET_PAYMENT_TOKEN_FIELD_NUMBER),
        RESPONSE_GET_PAYMENT_TOKEN(SetRpcStruct$ComposedRpc.RESPONSE_GET_PAYMENT_TOKEN_FIELD_NUMBER),
        GET_MONEY_REQUEST_DETAILS(SetRpcStruct$ComposedRpc.GET_MONEY_REQUEST_DETAILS_FIELD_NUMBER),
        GRANT_BANKI_ACCESS(SetRpcStruct$ComposedRpc.GRANT_BANKI_ACCESS_FIELD_NUMBER),
        RESPONSE_GET_MONEY_REQUEST_DETAILS(SetRpcStruct$ComposedRpc.RESPONSE_GET_MONEY_REQUEST_DETAILS_FIELD_NUMBER),
        GET_MONEY_REQUEST_PAYMENT_LIST(SetRpcStruct$ComposedRpc.GET_MONEY_REQUEST_PAYMENT_LIST_FIELD_NUMBER),
        RESPONSE_GET_MONEY_REQUEST_PAYMENT_LIST(SetRpcStruct$ComposedRpc.RESPONSE_GET_MONEY_REQUEST_PAYMENT_LIST_FIELD_NUMBER),
        BIND_MONEY_REQUEST_DETAILS(SetRpcStruct$ComposedRpc.BIND_MONEY_REQUEST_DETAILS_FIELD_NUMBER),
        GET_BAM_SERVICE_TOKEN(SetRpcStruct$ComposedRpc.GET_BAM_SERVICE_TOKEN_FIELD_NUMBER),
        RESPONSE_GET_BAM_SERVICE_TOKEN(SetRpcStruct$ComposedRpc.RESPONSE_GET_BAM_SERVICE_TOKEN_FIELD_NUMBER),
        BIND_MONEY_REQUEST_DETAILS_LIST(SetRpcStruct$ComposedRpc.BIND_MONEY_REQUEST_DETAILS_LIST_FIELD_NUMBER),
        UNBIND_ALL_MONEY_REQUEST_DETAILS(SetRpcStruct$ComposedRpc.UNBIND_ALL_MONEY_REQUEST_DETAILS_FIELD_NUMBER),
        GET_RECENT_CHARGES(SetRpcStruct$ComposedRpc.GET_RECENT_CHARGES_FIELD_NUMBER),
        RESPONSE_GET_RECENT_CHARGES(SetRpcStruct$ComposedRpc.RESPONSE_GET_RECENT_CHARGES_FIELD_NUMBER),
        BUY_FAST_CHARGE(SetRpcStruct$ComposedRpc.BUY_FAST_CHARGE_FIELD_NUMBER),
        RESPONSE_BUY_FAST_CHARGE(SetRpcStruct$ComposedRpc.RESPONSE_BUY_FAST_CHARGE_FIELD_NUMBER),
        RESPONSE_GET_WALLET_INVOICE(SetRpcStruct$ComposedRpc.RESPONSE_GET_WALLET_INVOICE_FIELD_NUMBER),
        GET_MY_WALLETS(SetRpcStruct$ComposedRpc.GET_MY_WALLETS_FIELD_NUMBER),
        RESPONSE_GET_MY_WALLETS(SetRpcStruct$ComposedRpc.RESPONSE_GET_MY_WALLETS_FIELD_NUMBER),
        GET_WALLET_CHARGE_TOKEN(SetRpcStruct$ComposedRpc.GET_WALLET_CHARGE_TOKEN_FIELD_NUMBER),
        RESPONSE_GET_WALLET_CHARGE_TOKEN(SetRpcStruct$ComposedRpc.RESPONSE_GET_WALLET_CHARGE_TOKEN_FIELD_NUMBER),
        PAY_BY_WALLET(SetRpcStruct$ComposedRpc.PAY_BY_WALLET_FIELD_NUMBER),
        GET_PAYMENT_TOKEN_BY_CARD(SetRpcStruct$ComposedRpc.GET_PAYMENT_TOKEN_BY_CARD_FIELD_NUMBER),
        RESPONSE_GET_PAYMENT_TOKEN_BY_CARD(SetRpcStruct$ComposedRpc.RESPONSE_GET_PAYMENT_TOKEN_BY_CARD_FIELD_NUMBER),
        VERIFY_QRCODE(SetRpcStruct$ComposedRpc.VERIFY_QRCODE_FIELD_NUMBER),
        RESPONSE_VERIFY_QRCODE(SetRpcStruct$ComposedRpc.RESPONSE_VERIFY_QRCODE_FIELD_NUMBER),
        PAY_MONEY_REQUEST_BY_WALLET(SetRpcStruct$ComposedRpc.PAY_MONEY_REQUEST_BY_WALLET_FIELD_NUMBER),
        GET_WALLET_INVOICE(SetRpcStruct$ComposedRpc.GET_WALLET_INVOICE_FIELD_NUMBER),
        VERIFY_PEER(SetRpcStruct$ComposedRpc.VERIFY_PEER_FIELD_NUMBER),
        RESPONSE_VERIFY_PEER(SetRpcStruct$ComposedRpc.RESPONSE_VERIFY_PEER_FIELD_NUMBER),
        GET_WALLET_CONTRACTS(SetRpcStruct$ComposedRpc.GET_WALLET_CONTRACTS_FIELD_NUMBER),
        RESPONSE_GET_WALLET_CONTRACTS(SetRpcStruct$ComposedRpc.RESPONSE_GET_WALLET_CONTRACTS_FIELD_NUMBER),
        ACTIVATE_WALLET(SetRpcStruct$ComposedRpc.ACTIVATE_WALLET_FIELD_NUMBER),
        VERIFY_CASH_OUT(SetRpcStruct$ComposedRpc.VERIFY_CASH_OUT_FIELD_NUMBER),
        RESPONSE_VERIFY_CASH_OUT(SetRpcStruct$ComposedRpc.RESPONSE_VERIFY_CASH_OUT_FIELD_NUMBER),
        CASH_OUT_FROM_WALLET(SetRpcStruct$ComposedRpc.CASH_OUT_FROM_WALLET_FIELD_NUMBER),
        GET_MONEY_REQUEST_PAYMENT_TOKEN_BY_CARD(SetRpcStruct$ComposedRpc.GET_MONEY_REQUEST_PAYMENT_TOKEN_BY_CARD_FIELD_NUMBER),
        RESPONSE_GET_MONEY_REQUEST_PAYMENT_TOKEN_BY_CARD(SetRpcStruct$ComposedRpc.RESPONSE_GET_MONEY_REQUEST_PAYMENT_TOKEN_BY_CARD_FIELD_NUMBER),
        SEND_GIFT_PACKET_WITH_WALLET(SetRpcStruct$ComposedRpc.SEND_GIFT_PACKET_WITH_WALLET_FIELD_NUMBER),
        GET_GIFT_PACKET_PAYMENT_TOKEN(SetRpcStruct$ComposedRpc.GET_GIFT_PACKET_PAYMENT_TOKEN_FIELD_NUMBER),
        RESPONSE_GET_GIFT_PACKET_PAYMENT_TOKEN(SetRpcStruct$ComposedRpc.RESPONSE_GET_GIFT_PACKET_PAYMENT_TOKEN_FIELD_NUMBER),
        OPEN_GIFT_PACKET(SetRpcStruct$ComposedRpc.OPEN_GIFT_PACKET_FIELD_NUMBER),
        RESPONSE_OPEN_GIFT_PACKET(SetRpcStruct$ComposedRpc.RESPONSE_OPEN_GIFT_PACKET_FIELD_NUMBER),
        GET_OTPTOKEN(SetRpcStruct$ComposedRpc.GET_OTPTOKEN_FIELD_NUMBER),
        RESPONSE_GET_OTPTOKEN(SetRpcStruct$ComposedRpc.RESPONSE_GET_OTPTOKEN_FIELD_NUMBER),
        SEND_SERAJ_EVENT(SetRpcStruct$ComposedRpc.SEND_SERAJ_EVENT_FIELD_NUMBER),
        LOAD_REACTIONS(SetRpcStruct$ComposedRpc.LOAD_REACTIONS_FIELD_NUMBER),
        RESPONSE_LOAD_REACTIONS(SetRpcStruct$ComposedRpc.RESPONSE_LOAD_REACTIONS_FIELD_NUMBER),
        GET_MY_BANK(SetRpcStruct$ComposedRpc.GET_MY_BANK_FIELD_NUMBER),
        RESPONSE_GET_MY_BANK(SetRpcStruct$ComposedRpc.RESPONSE_GET_MY_BANK_FIELD_NUMBER),
        LOAD_GROUPS(SetRpcStruct$ComposedRpc.LOAD_GROUPS_FIELD_NUMBER),
        RESPONSE_LOAD_GROUPS(SetRpcStruct$ComposedRpc.RESPONSE_LOAD_GROUPS_FIELD_NUMBER),
        LOAD_USERS(SetRpcStruct$ComposedRpc.LOAD_USERS_FIELD_NUMBER),
        RESPONSE_LOAD_USERS(SetRpcStruct$ComposedRpc.RESPONSE_LOAD_USERS_FIELD_NUMBER),
        LOAD_PEER_DIALOGS(SetRpcStruct$ComposedRpc.LOAD_PEER_DIALOGS_FIELD_NUMBER),
        RESPONSE_LOAD_PEER_DIALOGS(SetRpcStruct$ComposedRpc.RESPONSE_LOAD_PEER_DIALOGS_FIELD_NUMBER),
        UNREGISTER_ALL_PUSH_CREDENTIALS(SetRpcStruct$ComposedRpc.UNREGISTER_ALL_PUSH_CREDENTIALS_FIELD_NUMBER),
        GET_REACTIONS(SetRpcStruct$ComposedRpc.GET_REACTIONS_FIELD_NUMBER),
        RESPONSE_GET_REACTIONS(SetRpcStruct$ComposedRpc.RESPONSE_GET_REACTIONS_FIELD_NUMBER),
        GET_USER_VITRINE(SetRpcStruct$ComposedRpc.GET_USER_VITRINE_FIELD_NUMBER),
        RESPONSE_GET_USER_VITRINE(SetRpcStruct$ComposedRpc.RESPONSE_GET_USER_VITRINE_FIELD_NUMBER),
        GET_OTP_TOKEN_V2(SetRpcStruct$ComposedRpc.GET_OTP_TOKEN_V2_FIELD_NUMBER),
        RESPONSE_GET_OTP_TOKEN_V2(SetRpcStruct$ComposedRpc.RESPONSE_GET_OTP_TOKEN_V2_FIELD_NUMBER),
        GET_BALE_TICKET(SetRpcStruct$ComposedRpc.GET_BALE_TICKET_FIELD_NUMBER),
        RESPONSE_GET_TICKET(SetRpcStruct$ComposedRpc.RESPONSE_GET_TICKET_FIELD_NUMBER),
        SEARCH_MEDIA(SetRpcStruct$ComposedRpc.SEARCH_MEDIA_FIELD_NUMBER),
        RESPONSE_SEARCH_MEDIA(SetRpcStruct$ComposedRpc.RESPONSE_SEARCH_MEDIA_FIELD_NUMBER),
        GET_CHANNEL_ADS(SetRpcStruct$ComposedRpc.GET_CHANNEL_ADS_FIELD_NUMBER),
        RESPONSE_GET_CHANNEL_ADS(SetRpcStruct$ComposedRpc.RESPONSE_GET_CHANNEL_ADS_FIELD_NUMBER),
        GET_MY_KIFPOOLS(SetRpcStruct$ComposedRpc.GET_MY_KIFPOOLS_FIELD_NUMBER),
        RESPONSE_GET_MY_KIFPOOLS(SetRpcStruct$ComposedRpc.RESPONSE_GET_MY_KIFPOOLS_FIELD_NUMBER),
        UPGRADE_KIFPOOL(SetRpcStruct$ComposedRpc.UPGRADE_KIFPOOL_FIELD_NUMBER),
        RESPONSE_UPGRADE_KIFPOOL(SetRpcStruct$ComposedRpc.RESPONSE_UPGRADE_KIFPOOL_FIELD_NUMBER),
        CREATE_KIFPOOL(SetRpcStruct$ComposedRpc.CREATE_KIFPOOL_FIELD_NUMBER),
        RESPONSE_CREATE_KIFPOOL(SetRpcStruct$ComposedRpc.RESPONSE_CREATE_KIFPOOL_FIELD_NUMBER),
        GET_CHARGE_PAYMENT_TOKEN(SetRpcStruct$ComposedRpc.GET_CHARGE_PAYMENT_TOKEN_FIELD_NUMBER),
        RESPONSE_GET_CHARGE_PAYMENT_TOKEN(SetRpcStruct$ComposedRpc.RESPONSE_GET_CHARGE_PAYMENT_TOKEN_FIELD_NUMBER),
        CASHOUT_KIFPOOL(SetRpcStruct$ComposedRpc.CASHOUT_KIFPOOL_FIELD_NUMBER),
        RESPONSE_CASHOUT_KIFPOOL(SetRpcStruct$ComposedRpc.RESPONSE_CASHOUT_KIFPOOL_FIELD_NUMBER),
        INVOICE_KIFPOOL(SetRpcStruct$ComposedRpc.INVOICE_KIFPOOL_FIELD_NUMBER),
        RESPONSE_INVOICE_KIFPOOL(SetRpcStruct$ComposedRpc.RESPONSE_INVOICE_KIFPOOL_FIELD_NUMBER),
        TRANSFER_MONEY(SetRpcStruct$ComposedRpc.TRANSFER_MONEY_FIELD_NUMBER),
        RESPONSE_TRANSFER_MONEY(SetRpcStruct$ComposedRpc.RESPONSE_TRANSFER_MONEY_FIELD_NUMBER),
        CHECK_CHARGE_PERMISSION(SetRpcStruct$ComposedRpc.CHECK_CHARGE_PERMISSION_FIELD_NUMBER),
        RESPONSE_CHECK_CHARGE_PERMISSION(SetRpcStruct$ComposedRpc.RESPONSE_CHECK_CHARGE_PERMISSION_FIELD_NUMBER),
        CHARGE(SetRpcStruct$ComposedRpc.CHARGE_FIELD_NUMBER),
        RESPONSE_CHARGE(SetRpcStruct$ComposedRpc.RESPONSE_CHARGE_FIELD_NUMBER),
        PURCHASE_MESSAGE(SetRpcStruct$ComposedRpc.PURCHASE_MESSAGE_FIELD_NUMBER),
        RESPONSE_PURCHASE_MESSAGE(SetRpcStruct$ComposedRpc.RESPONSE_PURCHASE_MESSAGE_FIELD_NUMBER),
        GET_KIFPOOL_OWNER(SetRpcStruct$ComposedRpc.GET_KIFPOOL_OWNER_FIELD_NUMBER),
        RESPONSE_GET_KIFPOOL_OWNER(SetRpcStruct$ComposedRpc.RESPONSE_GET_KIFPOOL_OWNER_FIELD_NUMBER),
        PURCHASE_MESSAGE_WITH_CHARGE(SetRpcStruct$ComposedRpc.PURCHASE_MESSAGE_WITH_CHARGE_FIELD_NUMBER),
        RESPONSE_PURCHASE_MESSAGE_WITH_CHARGE(SetRpcStruct$ComposedRpc.RESPONSE_PURCHASE_MESSAGE_WITH_CHARGE_FIELD_NUMBER),
        VERIFY_PURCHASE_MESSAGE(SetRpcStruct$ComposedRpc.VERIFY_PURCHASE_MESSAGE_FIELD_NUMBER),
        RESPONSE_VERIFY_PURCHASE_MESSAGE(SetRpcStruct$ComposedRpc.RESPONSE_VERIFY_PURCHASE_MESSAGE_FIELD_NUMBER),
        VERIFY_CASH_OUT_KIFPOOL(SetRpcStruct$ComposedRpc.VERIFY_CASH_OUT_KIFPOOL_FIELD_NUMBER),
        RESPONSE_VERIFY_CASH_OUT_KIFPOOL(SetRpcStruct$ComposedRpc.RESPONSE_VERIFY_CASH_OUT_KIFPOOL_FIELD_NUMBER),
        GET_POINT_BALANCE(SetRpcStruct$ComposedRpc.GET_POINT_BALANCE_FIELD_NUMBER),
        RESPONSE_GET_POINT_BALANCE(SetRpcStruct$ComposedRpc.RESPONSE_GET_POINT_BALANCE_FIELD_NUMBER),
        GET_POINT_SUMMERY(SetRpcStruct$ComposedRpc.GET_POINT_SUMMERY_FIELD_NUMBER),
        RESPONSE_GET_POINT_SUMMERY(SetRpcStruct$ComposedRpc.RESPONSE_GET_POINT_SUMMERY_FIELD_NUMBER),
        CHANGE_PHONE(SetRpcStruct$ComposedRpc.CHANGE_PHONE_FIELD_NUMBER),
        SEND_CHANGE_PHONE_VERIFICATION_CODE(SetRpcStruct$ComposedRpc.SEND_CHANGE_PHONE_VERIFICATION_CODE_FIELD_NUMBER),
        GET_REFERRAL_CODE(SetRpcStruct$ComposedRpc.GET_REFERRAL_CODE_FIELD_NUMBER),
        RESPONSE_GET_REFERRAL_CODE(SetRpcStruct$ComposedRpc.RESPONSE_GET_REFERRAL_CODE_FIELD_NUMBER),
        REFER(SetRpcStruct$ComposedRpc.REFER_FIELD_NUMBER),
        RESPONSE_REFER(SetRpcStruct$ComposedRpc.RESPONSE_REFER_FIELD_NUMBER),
        SET_MEMBER_PERMISSIONS(SetRpcStruct$ComposedRpc.SET_MEMBER_PERMISSIONS_FIELD_NUMBER),
        GET_MEMBER_PERMISSIONS(SetRpcStruct$ComposedRpc.GET_MEMBER_PERMISSIONS_FIELD_NUMBER),
        RESPONSE_GET_MEMBER_PERMISSIONS(SetRpcStruct$ComposedRpc.RESPONSE_GET_MEMBER_PERMISSIONS_FIELD_NUMBER),
        GET_POINT_DETAILS(SetRpcStruct$ComposedRpc.GET_POINT_DETAILS_FIELD_NUMBER),
        RESPONSE_GET_POINT_DETAILS(SetRpcStruct$ComposedRpc.RESPONSE_GET_POINT_DETAILS_FIELD_NUMBER),
        GET_REFERRING_USER(SetRpcStruct$ComposedRpc.GET_REFERRING_USER_FIELD_NUMBER),
        RESPONSE_GET_REFERRING_USER(SetRpcStruct$ComposedRpc.RESPONSE_GET_REFERRING_USER_FIELD_NUMBER),
        TRANSACTION_POINT(SetRpcStruct$ComposedRpc.TRANSACTION_POINT_FIELD_NUMBER),
        RESPONSE_TRANSACTION_POINT(SetRpcStruct$ComposedRpc.RESPONSE_TRANSACTION_POINT_FIELD_NUMBER),
        CHANGE_POINT_TO_MONEY(SetRpcStruct$ComposedRpc.CHANGE_POINT_TO_MONEY_FIELD_NUMBER),
        RESPONSE_CHANGE_POINT_TO_MONEY(SetRpcStruct$ComposedRpc.RESPONSE_CHANGE_POINT_TO_MONEY_FIELD_NUMBER),
        BUY_WHEEL_CHANCE(SetRpcStruct$ComposedRpc.BUY_WHEEL_CHANCE_FIELD_NUMBER),
        RESPONSE_BUY_WHEEL_CHANCE(SetRpcStruct$ComposedRpc.RESPONSE_BUY_WHEEL_CHANCE_FIELD_NUMBER),
        GET_WHEEL(SetRpcStruct$ComposedRpc.GET_WHEEL_FIELD_NUMBER),
        RESPONSE_GET_WHEEL(SetRpcStruct$ComposedRpc.RESPONSE_GET_WHEEL_FIELD_NUMBER),
        SPIN_WHEEL(SetRpcStruct$ComposedRpc.SPIN_WHEEL_FIELD_NUMBER),
        RESPONSE_SPIN_WHEEL(SetRpcStruct$ComposedRpc.RESPONSE_SPIN_WHEEL_FIELD_NUMBER),
        GET_VOUCHERS(SetRpcStruct$ComposedRpc.GET_VOUCHERS_FIELD_NUMBER),
        RESPONSE_GET_VOUCHERS(SetRpcStruct$ComposedRpc.RESPONSE_GET_VOUCHERS_FIELD_NUMBER),
        BUY_VOUCHER(SetRpcStruct$ComposedRpc.BUY_VOUCHER_FIELD_NUMBER),
        RESPONSE_BUY_VOUCHER(SetRpcStruct$ComposedRpc.RESPONSE_BUY_VOUCHER_FIELD_NUMBER),
        SET_GROUP_DEFAULT_PERMISSIONS(SetRpcStruct$ComposedRpc.SET_GROUP_DEFAULT_PERMISSIONS_FIELD_NUMBER),
        GET_REFERRED_COUNT(SetRpcStruct$ComposedRpc.GET_REFERRED_COUNT_FIELD_NUMBER),
        RESPONSE_GET_REFERRED_COUNT(SetRpcStruct$ComposedRpc.RESPONSE_GET_REFERRED_COUNT_FIELD_NUMBER),
        GET_WEBVIEW_TRACKING_NUMBER(SetRpcStruct$ComposedRpc.GET_WEBVIEW_TRACKING_NUMBER_FIELD_NUMBER),
        RESPONSE_GET_WEBVIEW_TRACKING_NUMBER(SetRpcStruct$ComposedRpc.RESPONSE_GET_WEBVIEW_TRACKING_NUMBER_FIELD_NUMBER),
        GET_CHARGE_TOPUP_PAYMENT_TOKEN(SetRpcStruct$ComposedRpc.GET_CHARGE_TOPUP_PAYMENT_TOKEN_FIELD_NUMBER),
        GET_CHARGE_VOUCHER_PAYMENT_TOKEN(SetRpcStruct$ComposedRpc.GET_CHARGE_VOUCHER_PAYMENT_TOKEN_FIELD_NUMBER),
        RESPONSE_GET_PSP_PAYMENTTOKEN(SetRpcStruct$ComposedRpc.RESPONSE_GET_PSP_PAYMENTTOKEN_FIELD_NUMBER),
        ENROLL_NEW_CARD(SetRpcStruct$ComposedRpc.ENROLL_NEW_CARD_FIELD_NUMBER),
        RESPONSE_ENROLL_NEW_CARD(SetRpcStruct$ComposedRpc.RESPONSE_ENROLL_NEW_CARD_FIELD_NUMBER),
        GET_CARD_INFO(SetRpcStruct$ComposedRpc.GET_CARD_INFO_FIELD_NUMBER),
        RESPONSE_GET_CARD_INFO(SetRpcStruct$ComposedRpc.RESPONSE_GET_CARD_INFO_FIELD_NUMBER),
        GET_DESTINATION_CARD_INFO(SetRpcStruct$ComposedRpc.GET_DESTINATION_CARD_INFO_FIELD_NUMBER),
        RESPONSE_GET_DESTINATION_CARD_INFO(SetRpcStruct$ComposedRpc.RESPONSE_GET_DESTINATION_CARD_INFO_FIELD_NUMBER),
        DELIVER_OTP(SetRpcStruct$ComposedRpc.DELIVER_OTP_FIELD_NUMBER),
        TRANSFER_MONEY_BY_CARD(SetRpcStruct$ComposedRpc.TRANSFER_MONEY_BY_CARD_FIELD_NUMBER),
        GET_LINK_PREVIEW(SetRpcStruct$ComposedRpc.GET_LINK_PREVIEW_FIELD_NUMBER),
        RESPONSE_GET_LINK_PREVIEW(SetRpcStruct$ComposedRpc.RESPONSE_GET_LINK_PREVIEW_FIELD_NUMBER),
        GET_GROUP_MEMBERS_COUNT(SetRpcStruct$ComposedRpc.GET_GROUP_MEMBERS_COUNT_FIELD_NUMBER),
        RESPONSE_GET_GROUP_MEMBERS_COUNT(SetRpcStruct$ComposedRpc.RESPONSE_GET_GROUP_MEMBERS_COUNT_FIELD_NUMBER),
        RESPONSE_SEND_CHANGE_PHONE_VERIFICATION_CODE(SetRpcStruct$ComposedRpc.RESPONSE_SEND_CHANGE_PHONE_VERIFICATION_CODE_FIELD_NUMBER),
        SET_RECENT_ORDER(SetRpcStruct$ComposedRpc.SET_RECENT_ORDER_FIELD_NUMBER),
        GET_RECENT_ORDERS(SetRpcStruct$ComposedRpc.GET_RECENT_ORDERS_FIELD_NUMBER),
        RESPONSE_GET_RECENT_ORDERS(SetRpcStruct$ComposedRpc.RESPONSE_GET_RECENT_ORDERS_FIELD_NUMBER),
        DELETE_ORDER(SetRpcStruct$ComposedRpc.DELETE_ORDER_FIELD_NUMBER),
        GET_CHARGE_AMOUNTS(SetRpcStruct$ComposedRpc.GET_CHARGE_AMOUNTS_FIELD_NUMBER),
        RESPONSE_GET_CHARGE_AMOUNTS(SetRpcStruct$ComposedRpc.RESPONSE_GET_CHARGE_AMOUNTS_FIELD_NUMBER),
        GET_PARTICIPANTS(SetRpcStruct$ComposedRpc.GET_PARTICIPANTS_FIELD_NUMBER),
        RESPONSE_GET_PARTICIPANTS(SetRpcStruct$ComposedRpc.RESPONSE_GET_PARTICIPANTS_FIELD_NUMBER),
        GET_CHANNEL_EARN_MONEY_INFO(SetRpcStruct$ComposedRpc.GET_CHANNEL_EARN_MONEY_INFO_FIELD_NUMBER),
        RESPONSE_GET_CHANNEL_EARN_MONEY_INFO(SetRpcStruct$ComposedRpc.RESPONSE_GET_CHANNEL_EARN_MONEY_INFO_FIELD_NUMBER),
        GET_CHANNEL_EARN_MONEY_STATUS(SetRpcStruct$ComposedRpc.GET_CHANNEL_EARN_MONEY_STATUS_FIELD_NUMBER),
        RESPONSE_GET_CHANNEL_EARN_MONEY_STATUS(SetRpcStruct$ComposedRpc.RESPONSE_GET_CHANNEL_EARN_MONEY_STATUS_FIELD_NUMBER),
        GET_USER_STATUS(SetRpcStruct$ComposedRpc.GET_USER_STATUS_FIELD_NUMBER),
        RESPONSE_GET_USER_STATUS(SetRpcStruct$ComposedRpc.RESPONSE_GET_USER_STATUS_FIELD_NUMBER),
        REGISTER_FOR_EARN_MONEY(SetRpcStruct$ComposedRpc.REGISTER_FOR_EARN_MONEY_FIELD_NUMBER),
        UPDATE_GROUP_STATUS(SetRpcStruct$ComposedRpc.UPDATE_GROUP_STATUS_FIELD_NUMBER),
        GET_USER_ACCOUNTS(SetRpcStruct$ComposedRpc.GET_USER_ACCOUNTS_FIELD_NUMBER),
        RESPONSE_GET_USER_ACCOUNTS(SetRpcStruct$ComposedRpc.RESPONSE_GET_USER_ACCOUNTS_FIELD_NUMBER),
        LOAD_TRANSACTIONS(SetRpcStruct$ComposedRpc.LOAD_TRANSACTIONS_FIELD_NUMBER),
        RESPONSE_LOAD_TRANSACTIONS(SetRpcStruct$ComposedRpc.RESPONSE_LOAD_TRANSACTIONS_FIELD_NUMBER),
        ADD_TRANSACTION_TAGS(SetRpcStruct$ComposedRpc.ADD_TRANSACTION_TAGS_FIELD_NUMBER),
        REMOVE_TRANSACTION_TAGS(SetRpcStruct$ComposedRpc.REMOVE_TRANSACTION_TAGS_FIELD_NUMBER),
        GET_TRANSACTION_TAGS(SetRpcStruct$ComposedRpc.GET_TRANSACTION_TAGS_FIELD_NUMBER),
        RESPONSE_GET_TRANSACTION_TAGS(SetRpcStruct$ComposedRpc.RESPONSE_GET_TRANSACTION_TAGS_FIELD_NUMBER),
        ADD_USER_TAGS(SetRpcStruct$ComposedRpc.ADD_USER_TAGS_FIELD_NUMBER),
        REMOVE_USER_TAGS(SetRpcStruct$ComposedRpc.REMOVE_USER_TAGS_FIELD_NUMBER),
        GET_USER_TAGS(SetRpcStruct$ComposedRpc.GET_USER_TAGS_FIELD_NUMBER),
        RESPONSE_GET_USER_TAGS(SetRpcStruct$ComposedRpc.RESPONSE_GET_USER_TAGS_FIELD_NUMBER),
        GET_USER_BANK(SetRpcStruct$ComposedRpc.GET_USER_BANK_FIELD_NUMBER),
        RESPONSE_GET_USER_BANK(SetRpcStruct$ComposedRpc.RESPONSE_GET_USER_BANK_FIELD_NUMBER),
        GET_AD_PROVIDER(SetRpcStruct$ComposedRpc.GET_AD_PROVIDER_FIELD_NUMBER),
        RESPONSE_GET_AD_PROVIDER(SetRpcStruct$ComposedRpc.RESPONSE_GET_AD_PROVIDER_FIELD_NUMBER),
        GET_TOTAL_PAID_AMOUNT(SetRpcStruct$ComposedRpc.GET_TOTAL_PAID_AMOUNT_FIELD_NUMBER),
        RESPONSE_GET_TOTAL_PAID_AMOUNT(SetRpcStruct$ComposedRpc.RESPONSE_GET_TOTAL_PAID_AMOUNT_FIELD_NUMBER),
        SEND_FEED_BACK(SetRpcStruct$ComposedRpc.SEND_FEED_BACK_FIELD_NUMBER),
        GET_INTERNET_BUNDLE_PAYMENT_TOKEN(SetRpcStruct$ComposedRpc.GET_INTERNET_BUNDLE_PAYMENT_TOKEN_FIELD_NUMBER),
        RESPONSE_GET_INTERNET_BUNDLE_PAYMENT_TOKEN(SetRpcStruct$ComposedRpc.RESPONSE_GET_INTERNET_BUNDLE_PAYMENT_TOKEN_FIELD_NUMBER),
        GET_INTERNET_BUNDLE_LIST(SetRpcStruct$ComposedRpc.GET_INTERNET_BUNDLE_LIST_FIELD_NUMBER),
        RESPONSE_GET_INTERNET_BUNDLE_LIST(SetRpcStruct$ComposedRpc.RESPONSE_GET_INTERNET_BUNDLE_LIST_FIELD_NUMBER),
        GET_RECENT_INTERNET_BUNDLE_ORDERS(SetRpcStruct$ComposedRpc.GET_RECENT_INTERNET_BUNDLE_ORDERS_FIELD_NUMBER),
        RESPONSE_GET_RECENT_INTERNET_BUNDLE_ORDERS(SetRpcStruct$ComposedRpc.RESPONSE_GET_RECENT_INTERNET_BUNDLE_ORDERS_FIELD_NUMBER),
        DELETE_INTERNET_BUNDLE_ORDER(SetRpcStruct$ComposedRpc.DELETE_INTERNET_BUNDLE_ORDER_FIELD_NUMBER),
        BUY_CHARGE(SetRpcStruct$ComposedRpc.BUY_CHARGE_FIELD_NUMBER),
        RESPONSE_BUY_CHARGE(SetRpcStruct$ComposedRpc.RESPONSE_BUY_CHARGE_FIELD_NUMBER),
        BUY_INTERNET_BUNDLE(SetRpcStruct$ComposedRpc.BUY_INTERNET_BUNDLE_FIELD_NUMBER),
        RESPONSE_BUY_INTERNET_BUNDLE(SetRpcStruct$ComposedRpc.RESPONSE_BUY_INTERNET_BUNDLE_FIELD_NUMBER),
        GET_USERS_DEFAULT_CARD_NUMBER(SetRpcStruct$ComposedRpc.GET_USERS_DEFAULT_CARD_NUMBER_FIELD_NUMBER),
        RESPONSE_GET_USERS_DEFAULT_CARD_NUMBER(SetRpcStruct$ComposedRpc.RESPONSE_GET_USERS_DEFAULT_CARD_NUMBER_FIELD_NUMBER),
        INQUIRY_BILL(SetRpcStruct$ComposedRpc.INQUIRY_BILL_FIELD_NUMBER),
        RESPONSE_INQUIRY_BILL(SetRpcStruct$ComposedRpc.RESPONSE_INQUIRY_BILL_FIELD_NUMBER),
        PAY_BILL(SetRpcStruct$ComposedRpc.PAY_BILL_FIELD_NUMBER),
        RESPONSE_PAY_BILL(SetRpcStruct$ComposedRpc.RESPONSE_PAY_BILL_FIELD_NUMBER),
        GET_BILL_HISTORY(SetRpcStruct$ComposedRpc.GET_BILL_HISTORY_FIELD_NUMBER),
        RESPONSE_GET_BILL_HISTORY(SetRpcStruct$ComposedRpc.RESPONSE_GET_BILL_HISTORY_FIELD_NUMBER),
        CREATE_SAVED_BILL(SetRpcStruct$ComposedRpc.CREATE_SAVED_BILL_FIELD_NUMBER),
        RESPONSE_CREATE_SAVED_BILL(SetRpcStruct$ComposedRpc.RESPONSE_CREATE_SAVED_BILL_FIELD_NUMBER),
        GET_SAVED_BILLS(SetRpcStruct$ComposedRpc.GET_SAVED_BILLS_FIELD_NUMBER),
        RESPONSE_GET_SAVED_BILLS(SetRpcStruct$ComposedRpc.RESPONSE_GET_SAVED_BILLS_FIELD_NUMBER),
        RENAME_SAVED_BILL(SetRpcStruct$ComposedRpc.RENAME_SAVED_BILL_FIELD_NUMBER),
        DELETE_SAVED_BILLS(SetRpcStruct$ComposedRpc.DELETE_SAVED_BILLS_FIELD_NUMBER),
        ADD_NEW_CARDS(SetRpcStruct$ComposedRpc.ADD_NEW_CARDS_FIELD_NUMBER),
        RESPONSE_ADD_NEW_CARDS(SetRpcStruct$ComposedRpc.RESPONSE_ADD_NEW_CARDS_FIELD_NUMBER),
        REMOVE_CARD(SetRpcStruct$ComposedRpc.REMOVE_CARD_FIELD_NUMBER),
        GET_CARDS(SetRpcStruct$ComposedRpc.GET_CARDS_FIELD_NUMBER),
        RESPONSE_GET_CARDS(SetRpcStruct$ComposedRpc.RESPONSE_GET_CARDS_FIELD_NUMBER),
        UPDATE_VIEW(SetRpcStruct$ComposedRpc.UPDATE_VIEW_FIELD_NUMBER),
        RESPONSE_UPDATE_VIEW(SetRpcStruct$ComposedRpc.RESPONSE_UPDATE_VIEW_FIELD_NUMBER),
        SET_DEFAULT_CARD(SetRpcStruct$ComposedRpc.SET_DEFAULT_CARD_FIELD_NUMBER),
        GET_DEFAULT_CARD(SetRpcStruct$ComposedRpc.GET_DEFAULT_CARD_FIELD_NUMBER),
        RESPONSE_GET_DEFAULT_CARD(SetRpcStruct$ComposedRpc.RESPONSE_GET_DEFAULT_CARD_FIELD_NUMBER),
        REMOVE_DEFAULT_CARD(SetRpcStruct$ComposedRpc.REMOVE_DEFAULT_CARD_FIELD_NUMBER),
        EDIT_CARD_EXPIRATION_DATE(SetRpcStruct$ComposedRpc.EDIT_CARD_EXPIRATION_DATE_FIELD_NUMBER),
        SUBMIT_DIALOG_AD_ORDER(SetRpcStruct$ComposedRpc.SUBMIT_DIALOG_AD_ORDER_FIELD_NUMBER),
        GET_DIALOG_AD_ORDER_DETAILS(SetRpcStruct$ComposedRpc.GET_DIALOG_AD_ORDER_DETAILS_FIELD_NUMBER),
        RESPONSE_GET_DIALOG_AD_ORDER_DETAILS(SetRpcStruct$ComposedRpc.RESPONSE_GET_DIALOG_AD_ORDER_DETAILS_FIELD_NUMBER),
        CHANGE_STATUS_DIALOG_AD_ORDER(SetRpcStruct$ComposedRpc.CHANGE_STATUS_DIALOG_AD_ORDER_FIELD_NUMBER),
        GET_DIALOG_AD_ORDER_PAYMENT_TOKEN(SetRpcStruct$ComposedRpc.GET_DIALOG_AD_ORDER_PAYMENT_TOKEN_FIELD_NUMBER),
        RESPONSE_GET_DIALOG_AD_ORDER_PAYMENT_TOKEN(SetRpcStruct$ComposedRpc.RESPONSE_GET_DIALOG_AD_ORDER_PAYMENT_TOKEN_FIELD_NUMBER),
        GET_MY_SENTENCE(SetRpcStruct$ComposedRpc.GET_MY_SENTENCE_FIELD_NUMBER),
        RESPONSE_GET_MY_SENTENCE(SetRpcStruct$ComposedRpc.RESPONSE_GET_MY_SENTENCE_FIELD_NUMBER),
        VALIDATE_MY_SENTENCE(SetRpcStruct$ComposedRpc.VALIDATE_MY_SENTENCE_FIELD_NUMBER),
        RESPONSE_VALIDATE_MY_SENTENCE(SetRpcStruct$ComposedRpc.RESPONSE_VALIDATE_MY_SENTENCE_FIELD_NUMBER),
        SEND_MY_GIFT_PACKET(SetRpcStruct$ComposedRpc.SEND_MY_GIFT_PACKET_FIELD_NUMBER),
        START_CALL(SetRpcStruct$ComposedRpc.START_CALL_FIELD_NUMBER),
        ACCEPT_CALL(SetRpcStruct$ComposedRpc.ACCEPT_CALL_FIELD_NUMBER),
        DISCARD_CALL(SetRpcStruct$ComposedRpc.DISCARD_CALL_FIELD_NUMBER),
        RESPONSE_CALL(SetRpcStruct$ComposedRpc.RESPONSE_CALL_FIELD_NUMBER),
        GET_LOAN_INFO(SetRpcStruct$ComposedRpc.GET_LOAN_INFO_FIELD_NUMBER),
        RESPONSE_GET_LOAN_INFO(SetRpcStruct$ComposedRpc.RESPONSE_GET_LOAN_INFO_FIELD_NUMBER),
        GET_LOANS_LIST(SetRpcStruct$ComposedRpc.GET_LOANS_LIST_FIELD_NUMBER),
        RESPONSE_GET_LOANS_LIST(SetRpcStruct$ComposedRpc.RESPONSE_GET_LOANS_LIST_FIELD_NUMBER),
        GET_DESTINATION_CARDS(SetRpcStruct$ComposedRpc.GET_DESTINATION_CARDS_FIELD_NUMBER),
        RESPONSE_GET_DESTINATION_CARDS(SetRpcStruct$ComposedRpc.RESPONSE_GET_DESTINATION_CARDS_FIELD_NUMBER),
        ADD_DESTINATION_CARDS(SetRpcStruct$ComposedRpc.ADD_DESTINATION_CARDS_FIELD_NUMBER),
        RESPONSE_ADD_DESTINATION_CARDS(SetRpcStruct$ComposedRpc.RESPONSE_ADD_DESTINATION_CARDS_FIELD_NUMBER),
        REMOVE_DESTINATION_CARDS(SetRpcStruct$ComposedRpc.REMOVE_DESTINATION_CARDS_FIELD_NUMBER),
        REACTIVATE_APP(SetRpcStruct$ComposedRpc.REACTIVATE_APP_FIELD_NUMBER),
        RESPONSE_REACTIVATE_APP(SetRpcStruct$ComposedRpc.RESPONSE_REACTIVATE_APP_FIELD_NUMBER),
        GET_SCORE_BOARD(SetRpcStruct$ComposedRpc.GET_SCORE_BOARD_FIELD_NUMBER),
        RESPONSE_GET_SCORE_BOARD(SetRpcStruct$ComposedRpc.RESPONSE_GET_SCORE_BOARD_FIELD_NUMBER),
        GET_USER_SCORE(SetRpcStruct$ComposedRpc.GET_USER_SCORE_FIELD_NUMBER),
        RESPONSE_GET_USER_SCORE(SetRpcStruct$ComposedRpc.RESPONSE_GET_USER_SCORE_FIELD_NUMBER),
        GET_PACKETS_STATUS(SetRpcStruct$ComposedRpc.GET_PACKETS_STATUS_FIELD_NUMBER),
        RESPONSE_GET_PACKETS_STATUS(SetRpcStruct$ComposedRpc.RESPONSE_GET_PACKETS_STATUS_FIELD_NUMBER),
        GET_USER_REFERS(SetRpcStruct$ComposedRpc.GET_USER_REFERS_FIELD_NUMBER),
        RESPONSE_GET_USER_REFERS(SetRpcStruct$ComposedRpc.RESPONSE_GET_USER_REFERS_FIELD_NUMBER),
        GET_REFERRAL_CONTACTS(SetRpcStruct$ComposedRpc.GET_REFERRAL_CONTACTS_FIELD_NUMBER),
        RESPONSE_GET_REFERRAL_CONTACTS(SetRpcStruct$ComposedRpc.RESPONSE_GET_REFERRAL_CONTACTS_FIELD_NUMBER),
        SEND_REFERRAL(SetRpcStruct$ComposedRpc.SEND_REFERRAL_FIELD_NUMBER),
        GET_PACKET(SetRpcStruct$ComposedRpc.GET_PACKET_FIELD_NUMBER),
        ACCEPT_REFERRAL_INVITE(SetRpcStruct$ComposedRpc.ACCEPT_REFERRAL_INVITE_FIELD_NUMBER),
        AUTHORIZE_USER(SetRpcStruct$ComposedRpc.AUTHORIZE_USER_FIELD_NUMBER),
        RESPONSE_AUTHORIZE_USER(SetRpcStruct$ComposedRpc.RESPONSE_AUTHORIZE_USER_FIELD_NUMBER),
        INIT_P12(SetRpcStruct$ComposedRpc.INIT_P12_FIELD_NUMBER),
        RESPONSE_INIT_P12(SetRpcStruct$ComposedRpc.RESPONSE_INIT_P12_FIELD_NUMBER),
        INIT_SEFTE(SetRpcStruct$ComposedRpc.INIT_SEFTE_FIELD_NUMBER),
        RESPONSE_INIT_SEFTE(SetRpcStruct$ComposedRpc.RESPONSE_INIT_SEFTE_FIELD_NUMBER),
        SIGN_SEFTE(SetRpcStruct$ComposedRpc.SIGN_SEFTE_FIELD_NUMBER),
        RESPONSE_SIGN_SEFTE(SetRpcStruct$ComposedRpc.RESPONSE_SIGN_SEFTE_FIELD_NUMBER),
        PAY_SEFTE(SetRpcStruct$ComposedRpc.PAY_SEFTE_FIELD_NUMBER),
        GET_STATES(SetRpcStruct$ComposedRpc.GET_STATES_FIELD_NUMBER),
        RESPONSE_GET_STATES(SetRpcStruct$ComposedRpc.RESPONSE_GET_STATES_FIELD_NUMBER),
        GET_CITIES_OF_STATE(SetRpcStruct$ComposedRpc.GET_CITIES_OF_STATE_FIELD_NUMBER),
        RESPONSE_GET_CITIES_OF_STATE(SetRpcStruct$ComposedRpc.RESPONSE_GET_CITIES_OF_STATE_FIELD_NUMBER),
        CHECK_STATUS_OF_PAYMENT(SetRpcStruct$ComposedRpc.CHECK_STATUS_OF_PAYMENT_FIELD_NUMBER),
        GET_USER_SEFTES(SetRpcStruct$ComposedRpc.GET_USER_SEFTES_FIELD_NUMBER),
        RESPONSE_GET_USER_SEFTES(SetRpcStruct$ComposedRpc.RESPONSE_GET_USER_SEFTES_FIELD_NUMBER),
        UPDATE_CLICK(SetRpcStruct$ComposedRpc.UPDATE_CLICK_FIELD_NUMBER),
        RESPONSE_UPDATE_CLICK(SetRpcStruct$ComposedRpc.RESPONSE_UPDATE_CLICK_FIELD_NUMBER),
        USER_HAS_CRED(SetRpcStruct$ComposedRpc.USER_HAS_CRED_FIELD_NUMBER),
        RESPONSE_USER_HAS_CRED(SetRpcStruct$ComposedRpc.RESPONSE_USER_HAS_CRED_FIELD_NUMBER),
        GET_RECIPIENTS(SetRpcStruct$ComposedRpc.GET_RECIPIENTS_FIELD_NUMBER),
        RESPONSE_GET_RECIPIENTS(SetRpcStruct$ComposedRpc.RESPONSE_GET_RECIPIENTS_FIELD_NUMBER),
        ADD_RECIPIENT(SetRpcStruct$ComposedRpc.ADD_RECIPIENT_FIELD_NUMBER),
        GET_CRYPTO_CHARGE_PAYMENT_TOKEN(SetRpcStruct$ComposedRpc.GET_CRYPTO_CHARGE_PAYMENT_TOKEN_FIELD_NUMBER),
        FILTER_TAGGED_TRANSACTIONS(SetRpcStruct$ComposedRpc.FILTER_TAGGED_TRANSACTIONS_FIELD_NUMBER),
        RESPONSE_FILTER_TAGGED_TRANSACTIONS(SetRpcStruct$ComposedRpc.RESPONSE_FILTER_TAGGED_TRANSACTIONS_FIELD_NUMBER),
        CRYPTO_TRANSFER(SetRpcStruct$ComposedRpc.CRYPTO_TRANSFER_FIELD_NUMBER),
        RESPONSE_CRYPTO_TRANSFER(SetRpcStruct$ComposedRpc.RESPONSE_CRYPTO_TRANSFER_FIELD_NUMBER),
        GET_CRYPTO_WALLETS(SetRpcStruct$ComposedRpc.GET_CRYPTO_WALLETS_FIELD_NUMBER),
        RESPONSE_GET_CRYPTO_WALLETS(SetRpcStruct$ComposedRpc.RESPONSE_GET_CRYPTO_WALLETS_FIELD_NUMBER),
        RESPONSE_PAY_SEFTE(SetRpcStruct$ComposedRpc.RESPONSE_PAY_SEFTE_FIELD_NUMBER),
        GET_ACQUIRED_VOUCHERS(SetRpcStruct$ComposedRpc.GET_ACQUIRED_VOUCHERS_FIELD_NUMBER),
        RESPONSE_GET_ACQUIRED_VOUCHERS(SetRpcStruct$ComposedRpc.RESPONSE_GET_ACQUIRED_VOUCHERS_FIELD_NUMBER),
        PROTO(SetRpcStruct$ComposedRpc.PROTO_FIELD_NUMBER),
        RESPONSE_PROTO(SetRpcStruct$ComposedRpc.RESPONSE_PROTO_FIELD_NUMBER),
        ADD_DETAIL_TO_TRANSACTION(SetRpcStruct$ComposedRpc.ADD_DETAIL_TO_TRANSACTION_FIELD_NUMBER),
        GET_GROUP_MEMBERS_PRESENCE(SetRpcStruct$ComposedRpc.GET_GROUP_MEMBERS_PRESENCE_FIELD_NUMBER),
        RESPONSE_GET_GROUP_MEMBERS_PRESENCE(SetRpcStruct$ComposedRpc.RESPONSE_GET_GROUP_MEMBERS_PRESENCE_FIELD_NUMBER),
        GET_USERS_PRESENCE(SetRpcStruct$ComposedRpc.GET_USERS_PRESENCE_FIELD_NUMBER),
        RESPONSE_GET_USERS_PRESENCE(SetRpcStruct$ComposedRpc.RESPONSE_GET_USERS_PRESENCE_FIELD_NUMBER),
        REMOVE_TRANSACTION(SetRpcStruct$ComposedRpc.REMOVE_TRANSACTION_FIELD_NUMBER),
        SPLIT_TRANSACTION(SetRpcStruct$ComposedRpc.SPLIT_TRANSACTION_FIELD_NUMBER),
        RESPONSE_SPLIT_TRANSACTION(SetRpcStruct$ComposedRpc.RESPONSE_SPLIT_TRANSACTION_FIELD_NUMBER),
        LOAD_TRANSACTIONS_BY_IDS(SetRpcStruct$ComposedRpc.LOAD_TRANSACTIONS_BY_IDS_FIELD_NUMBER),
        RESPONSE_LOAD_TRANSACTIONS_BY_IDS(SetRpcStruct$ComposedRpc.RESPONSE_LOAD_TRANSACTIONS_BY_IDS_FIELD_NUMBER),
        EDIT_SEX(SetRpcStruct$ComposedRpc.EDIT_SEX_FIELD_NUMBER),
        EDIT_BIRTH_DATE(SetRpcStruct$ComposedRpc.EDIT_BIRTH_DATE_FIELD_NUMBER),
        GET_SUB_TRANSACTIONS(SetRpcStruct$ComposedRpc.GET_SUB_TRANSACTIONS_FIELD_NUMBER),
        RESPONSE_GET_SUB_TRANSACTIONS(SetRpcStruct$ComposedRpc.RESPONSE_GET_SUB_TRANSACTIONS_FIELD_NUMBER),
        REVIVE_TRANSACTION(SetRpcStruct$ComposedRpc.REVIVE_TRANSACTION_FIELD_NUMBER),
        LOAD_LOAN_HISTORY(SetRpcStruct$ComposedRpc.LOAD_LOAN_HISTORY_FIELD_NUMBER),
        RESPONSE_LOAD_LOAN_HISTORY(SetRpcStruct$ComposedRpc.RESPONSE_LOAD_LOAN_HISTORY_FIELD_NUMBER),
        REMOVE_LOAN(SetRpcStruct$ComposedRpc.REMOVE_LOAN_FIELD_NUMBER),
        LOAD_LAST_STATES(SetRpcStruct$ComposedRpc.LOAD_LAST_STATES_FIELD_NUMBER),
        RESPONSE_LOAD_LAST_STATES(SetRpcStruct$ComposedRpc.RESPONSE_LOAD_LAST_STATES_FIELD_NUMBER),
        RESET_CONTACTS(SetRpcStruct$ComposedRpc.RESET_CONTACTS_FIELD_NUMBER),
        SEND_MULTI_MEDIA_MESSAGE(SetRpcStruct$ComposedRpc.SEND_MULTI_MEDIA_MESSAGE_FIELD_NUMBER),
        GET_MESSAGES_REPLIES_INFO(SetRpcStruct$ComposedRpc.GET_MESSAGES_REPLIES_INFO_FIELD_NUMBER),
        RESPONSE_GET_MESSAGES_REPLIES_INFO(SetRpcStruct$ComposedRpc.RESPONSE_GET_MESSAGES_REPLIES_INFO_FIELD_NUMBER),
        TRAIT_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return TRAIT_NOT_SET;
            }
            if (i != 5) {
                if (i == 7) {
                    return IMPORT_CONTACTS;
                }
                if (i == 8) {
                    return RESPONSE_IMPORT_CONTACTS;
                }
                if (i == 9) {
                    return GET_STATE;
                }
                if (i == 50) {
                    return RESPONSE_VOID;
                }
                if (i == 51) {
                    return REGISTER_GOOGLE_PUSH;
                }
                if (i == 91) {
                    return REMOVE_AVATAR;
                }
                if (i == 92) {
                    return SEND_MESSAGE;
                }
                switch (i) {
                    case 5:
                        break;
                    case 13:
                        return SEQ_UPDATE;
                    case 23:
                        return RESPONSE_GET_GROUP_STATE;
                    case 45:
                        return NEW_SEQ_UPDATE;
                    case 53:
                        return EDIT_NAME;
                    case 55:
                        return MESSAGE_RECEIVED;
                    case 57:
                        return MESSAGE_READ;
                    case 80:
                        return GET_AUTH_SESSIONS;
                    case 81:
                        return RESPONSE_GET_AUTH_SESSIONS;
                    case SetRpcStruct$ComposedRpc.TERMINATE_SESSION_FIELD_NUMBER /* 82 */:
                        return TERMINATE_SESSION;
                    case SetRpcStruct$ComposedRpc.TERMINATE_ALL_SESSIONS_FIELD_NUMBER /* 83 */:
                        return TERMINATE_ALL_SESSIONS;
                    case SetRpcStruct$ComposedRpc.SIGN_OUT_FIELD_NUMBER /* 84 */:
                        return SIGN_OUT;
                    case 85:
                        return EDIT_GROUP_TITLE;
                    case 86:
                        return EDIT_GROUP_AVATAR;
                    case SetRpcStruct$ComposedRpc.GET_CONTACTS_FIELD_NUMBER /* 87 */:
                        return GET_CONTACTS;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_CONTACTS_FIELD_NUMBER /* 88 */:
                        return RESPONSE_GET_CONTACTS;
                    case 89:
                        return REMOVE_CONTACT;
                    case 96:
                        return EDIT_USER_LOCAL_NAME;
                    case 128:
                        return EDIT_PARAMETER;
                    case 129:
                        return GET_GROUP_DEFAULT_CARD_NUMBER;
                    case 130:
                        return RESPONSE_GET_GROUP_DEFAULT_CARD_NUMBER;
                    case 134:
                        return GET_PARAMETERS;
                    case 135:
                        return RESPONSE_GET_PARAMETERS;
                    case 136:
                        return ADD_CARD;
                    case 137:
                        return GET_USER_CONTEXT;
                    case SetRpcStruct$ComposedRpc.GET_NASIM_FILE_UPLOAD_URL_FIELD_NUMBER /* 143 */:
                        return GET_NASIM_FILE_UPLOAD_URL;
                    case SetRpcStruct$ComposedRpc.EDIT_MY_TIME_ZONE_FIELD_NUMBER /* 144 */:
                        return EDIT_MY_TIME_ZONE;
                    case SetRpcStruct$ComposedRpc.EDIT_MY_PREFERRED_LANGUAGES_FIELD_NUMBER /* 145 */:
                        return EDIT_MY_PREFERRED_LANGUAGES;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_USER_CONTEXT_FIELD_NUMBER /* 146 */:
                        return RESPONSE_GET_USER_CONTEXT;
                    case SetRpcStruct$ComposedRpc.GET_GROUP_STATE_FIELD_NUMBER /* 153 */:
                        return GET_GROUP_STATE;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_NASIM_FILE_UPLOAD_URL_FIELD_NUMBER /* 157 */:
                        return RESPONSE_GET_NASIM_FILE_UPLOAD_URL;
                    case SetRpcStruct$ComposedRpc.GET_GROUP_INVITE_URL_FIELD_NUMBER /* 177 */:
                        return GET_GROUP_INVITE_URL;
                    case SetRpcStruct$ComposedRpc.RESPONSE_INVITE_URL_FIELD_NUMBER /* 178 */:
                        return RESPONSE_INVITE_URL;
                    case SetRpcStruct$ComposedRpc.REVOKE_INVITE_URL_FIELD_NUMBER /* 179 */:
                        return REVOKE_INVITE_URL;
                    case SetRpcStruct$ComposedRpc.JOIN_GROUP_FIELD_NUMBER /* 180 */:
                        return JOIN_GROUP;
                    case SetRpcStruct$ComposedRpc.RESPONSE_JOIN_GROUP_FIELD_NUMBER /* 181 */:
                        return RESPONSE_JOIN_GROUP;
                    case SetRpcStruct$ComposedRpc.GET_GROUP_DIFFERENCE_FIELD_NUMBER /* 187 */:
                        return GET_GROUP_DIFFERENCE;
                    case SetRpcStruct$ComposedRpc.VALIDATE_CODE_FIELD_NUMBER /* 189 */:
                        return VALIDATE_CODE;
                    case SetRpcStruct$ComposedRpc.SIGN_UP_FIELD_NUMBER /* 190 */:
                        return SIGN_UP;
                    case SetRpcStruct$ComposedRpc.START_PHONE_AUTH_FIELD_NUMBER /* 191 */:
                        return START_PHONE_AUTH;
                    case SetRpcStruct$ComposedRpc.RESPONSE_START_PHONE_AUTH_FIELD_NUMBER /* 193 */:
                        return RESPONSE_START_PHONE_AUTH;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_GROUP_DIFFERENCE_FIELD_NUMBER /* 204 */:
                        return RESPONSE_GET_GROUP_DIFFERENCE;
                    case SetRpcStruct$ComposedRpc.EDIT_NICK_NAME_FIELD_NUMBER /* 205 */:
                        return EDIT_NICK_NAME;
                    case SetRpcStruct$ComposedRpc.CHECK_NICK_NAME_FIELD_NUMBER /* 206 */:
                        return CHECK_NICK_NAME;
                    case 209:
                        return RESPONSE_BOOL;
                    case 210:
                        return MESSAGE_SET_REACTION;
                    case 212:
                        return EDIT_ABOUT;
                    case 213:
                        return EDIT_GROUP_ABOUT;
                    case 216:
                        return RESPONSE_CREATE_GROUP;
                    case 217:
                        return SEARCH_MESSAGES;
                    case 218:
                        return RESPONSE_SEARCH_MESSAGES;
                    case 219:
                        return RESPONSE_REACTIONS_RESPONSE;
                    case SetRpcStruct$ComposedRpc.MESSAGE_REMOVE_REACTION_FIELD_NUMBER /* 220 */:
                        return MESSAGE_REMOVE_REACTION;
                    case 222:
                        return SEARCH_MESSAGES_MORE;
                    case 225:
                        return LOAD_GROUPED_DIALOGS;
                    case 226:
                        return RESPONSE_LOAD_GROUPED_DIALOGS;
                    case SetRpcStruct$ComposedRpc.NOTIFY_ABOUT_DEVICE_INFO_FIELD_NUMBER /* 229 */:
                        return NOTIFY_ABOUT_DEVICE_INFO;
                    case SetRpcStruct$ComposedRpc.CREATE_GROUP_FIELD_NUMBER /* 230 */:
                        return CREATE_GROUP;
                    case SetRpcStruct$ComposedRpc.SEARCH_PEER_FIELD_NUMBER /* 233 */:
                        return SEARCH_PEER;
                    case SetRpcStruct$ComposedRpc.RESPONSE_SEARCH_PEER_FIELD_NUMBER /* 234 */:
                        return RESPONSE_SEARCH_PEER;
                    case SetRpcStruct$ComposedRpc.RESPONSE_DIALOGS_ORDER_FIELD_NUMBER /* 235 */:
                        return RESPONSE_DIALOGS_ORDER;
                    case SetRpcStruct$ComposedRpc.LOAD_OWN_STICKERS_FIELD_NUMBER /* 238 */:
                        return LOAD_OWN_STICKERS;
                    case SetRpcStruct$ComposedRpc.RESPONSE_LOAD_OWN_STICKERS_FIELD_NUMBER /* 239 */:
                        return RESPONSE_LOAD_OWN_STICKERS;
                    case SetRpcStruct$ComposedRpc.RESPONSE_STICKERS_REPONSE_FIELD_NUMBER /* 240 */:
                        return RESPONSE_STICKERS_REPONSE;
                    case SetRpcStruct$ComposedRpc.ADD_STICKER_COLLECTION_FIELD_NUMBER /* 244 */:
                        return ADD_STICKER_COLLECTION;
                    case 245:
                        return REMOVE_STICKER_COLLECTION;
                    case SetRpcStruct$ComposedRpc.LOAD_STICKER_COLLECTION_FIELD_NUMBER /* 246 */:
                        return LOAD_STICKER_COLLECTION;
                    case SetRpcStruct$ComposedRpc.RESPONSE_LOAD_STICKER_COLLECTION_FIELD_NUMBER /* 247 */:
                        return RESPONSE_LOAD_STICKER_COLLECTION;
                    case 249:
                        return GET_BOT_WHITE_LIST;
                    case SetRpcStruct$ComposedRpc.PIN_MESSAGE_FIELD_NUMBER /* 470 */:
                        return PIN_MESSAGE;
                    case SetRpcStruct$ComposedRpc.REMOVE_PIN_FIELD_NUMBER /* 471 */:
                        return REMOVE_PIN;
                    case SetRpcStruct$ComposedRpc.GET_JWT_TOKEN_FIELD_NUMBER /* 600 */:
                        return GET_JWT_TOKEN;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_JWT_TOKEN_FIELD_NUMBER /* 601 */:
                        return RESPONSE_GET_JWT_TOKEN;
                    case SetRpcStruct$ComposedRpc.SET_CAN_SEE_MESSAGES_FIELD_NUMBER /* 724 */:
                        return SET_CAN_SEE_MESSAGES;
                    case SetRpcStruct$ComposedRpc.RESPONSE_CAN_SEE_MESSAGES_FIELD_NUMBER /* 725 */:
                        return RESPONSE_CAN_SEE_MESSAGES;
                    case SetRpcStruct$ComposedRpc.GET_CAN_SEE_MESSAGES_FIELD_NUMBER /* 726 */:
                        return GET_CAN_SEE_MESSAGES;
                    case SetRpcStruct$ComposedRpc.SET_RESTRICTION_FIELD_NUMBER /* 728 */:
                        return SET_RESTRICTION;
                    case SetRpcStruct$ComposedRpc.FETCH_GROUP_ADMINS_FIELD_NUMBER /* 729 */:
                        return FETCH_GROUP_ADMINS;
                    case SetRpcStruct$ComposedRpc.RESPONSE_FETCH_GROUP_ADMINS_FIELD_NUMBER /* 730 */:
                        return RESPONSE_FETCH_GROUP_ADMINS;
                    case SetRpcStruct$ComposedRpc.NEW_FAT_SEQ_UPDATE_FIELD_NUMBER /* 1168 */:
                        return NEW_FAT_SEQ_UPDATE;
                    case SetRpcStruct$ComposedRpc.GET_NASIM_FILE_URLS_FIELD_NUMBER /* 2591 */:
                        return GET_NASIM_FILE_URLS;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_NASIM_FILE_URLS_FIELD_NUMBER /* 2607 */:
                        return RESPONSE_GET_NASIM_FILE_URLS;
                    case 2625:
                        return COMBINED_UPDATE;
                    case 2628:
                        return GET_REFERENCED_ENTITITES;
                    case 2629:
                        return RESPONSE_GET_REFERENCED_ENTITITES;
                    case SetRpcStruct$ComposedRpc.UNREGISTER_GOOGLE_PUSH_FIELD_NUMBER /* 2631 */:
                        return UNREGISTER_GOOGLE_PUSH;
                    case SetRpcStruct$ComposedRpc.BLOCK_USER_FIELD_NUMBER /* 2636 */:
                        return BLOCK_USER;
                    case SetRpcStruct$ComposedRpc.UNBLOCK_USER_FIELD_NUMBER /* 2637 */:
                        return UNBLOCK_USER;
                    case SetRpcStruct$ComposedRpc.LOAD_BLOCKED_USERS_FIELD_NUMBER /* 2638 */:
                        return LOAD_BLOCKED_USERS;
                    case SetRpcStruct$ComposedRpc.RESPONSE_LOAD_BLOCKED_USERS_FIELD_NUMBER /* 2639 */:
                        return RESPONSE_LOAD_BLOCKED_USERS;
                    case SetRpcStruct$ComposedRpc.LOAD_FULL_USERS_FIELD_NUMBER /* 2649 */:
                        return LOAD_FULL_USERS;
                    case SetRpcStruct$ComposedRpc.RESPONSE_LOAD_FULL_USERS_FIELD_NUMBER /* 2650 */:
                        return RESPONSE_LOAD_FULL_USERS;
                    case SetRpcStruct$ComposedRpc.LOAD_ARCHIVED_FIELD_NUMBER /* 2651 */:
                        return LOAD_ARCHIVED;
                    case SetRpcStruct$ComposedRpc.RESPONSE_LOAD_ARCHIVED_FIELD_NUMBER /* 2652 */:
                        return RESPONSE_LOAD_ARCHIVED;
                    case SetRpcStruct$ComposedRpc.LOAD_AVATARS_FIELD_NUMBER /* 2656 */:
                        return LOAD_AVATARS;
                    case SetRpcStruct$ComposedRpc.UPDATE_MESSAGE_FIELD_NUMBER /* 2658 */:
                        return UPDATE_MESSAGE;
                    case SetRpcStruct$ComposedRpc.WEAK_FAT_UPDATE_FIELD_NUMBER /* 2673 */:
                        return WEAK_FAT_UPDATE;
                    case SetRpcStruct$ComposedRpc.LOAD_FULL_GROUPS_FIELD_NUMBER /* 2782 */:
                        return LOAD_FULL_GROUPS;
                    case SetRpcStruct$ComposedRpc.RESPONSE_LOAD_FULL_GROUPS_FIELD_NUMBER /* 2783 */:
                        return RESPONSE_LOAD_FULL_GROUPS;
                    case SetRpcStruct$ComposedRpc.MAKE_USER_ADMIN_FIELD_NUMBER /* 2784 */:
                        return MAKE_USER_ADMIN;
                    case SetRpcStruct$ComposedRpc.LOAD_MEMBERS_FIELD_NUMBER /* 2786 */:
                        return LOAD_MEMBERS;
                    case SetRpcStruct$ComposedRpc.RESPONSE_LOAD_MEMBERS_FIELD_NUMBER /* 2787 */:
                        return RESPONSE_LOAD_MEMBERS;
                    case SetRpcStruct$ComposedRpc.TRANSFER_OWNERSHIP_FIELD_NUMBER /* 2789 */:
                        return TRANSFER_OWNERSHIP;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_NASIM_FILE_URL_FIELD_NUMBER /* 2799 */:
                        return RESPONSE_GET_NASIM_FILE_URL;
                    case SetRpcStruct$ComposedRpc.RESPONSE_LOAD_AVATARS_FIELD_NUMBER /* 2812 */:
                        return RESPONSE_LOAD_AVATARS;
                    case SetRpcStruct$ComposedRpc.GET_NASIM_FILE_URL_FIELD_NUMBER /* 2815 */:
                        return GET_NASIM_FILE_URL;
                    case SetRpcStruct$ComposedRpc.ADD_GIF_FIELD_NUMBER /* 2857 */:
                        return ADD_GIF;
                    case SetRpcStruct$ComposedRpc.REMOVE_GIF_FIELD_NUMBER /* 2859 */:
                        return REMOVE_GIF;
                    case SetRpcStruct$ComposedRpc.JOIN_PUBLIC_GROUP_FIELD_NUMBER /* 2881 */:
                        return JOIN_PUBLIC_GROUP;
                    case SetRpcStruct$ComposedRpc.RESPONSE_JOIN_PUBLIC_GROUP_FIELD_NUMBER /* 2897 */:
                        return RESPONSE_JOIN_PUBLIC_GROUP;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_NASIM_FILE_UPLOAD_RESUME_FIELD_NUMBER /* 3055 */:
                        return RESPONSE_GET_NASIM_FILE_UPLOAD_RESUME;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER /* 3056 */:
                        return RESPONSE_GET_NASIM_FILE_PUBLIC_URL;
                    case SetRpcStruct$ComposedRpc.GET_NASIM_FILE_UPLOAD_RESUME_FIELD_NUMBER /* 3071 */:
                        return GET_NASIM_FILE_UPLOAD_RESUME;
                    case SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER /* 3072 */:
                        return GET_NASIM_FILE_PUBLIC_URL;
                    case SetRpcStruct$ComposedRpc.RESPONSE_SEND_DELETE_ACCOUNT_VERIFICATION_CODE_FIELD_NUMBER /* 3089 */:
                        return RESPONSE_SEND_DELETE_ACCOUNT_VERIFICATION_CODE;
                    case SetRpcStruct$ComposedRpc.EDIT_CHANNEL_NICK_FIELD_NUMBER /* 3396 */:
                        return EDIT_CHANNEL_NICK;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_BOT_WHITE_LIST_FIELD_NUMBER /* 3856 */:
                        return RESPONSE_GET_BOT_WHITE_LIST;
                    case SetRpcStruct$ComposedRpc.SEND_INLINE_CALLBACK_DATA_FIELD_NUMBER /* 3937 */:
                        return SEND_INLINE_CALLBACK_DATA;
                    case SetRpcStruct$ComposedRpc.DELETE_ACCOUNT_FIELD_NUMBER /* 43606 */:
                        return DELETE_ACCOUNT;
                    case SetRpcStruct$ComposedRpc.SEND_DELETE_ACCOUNT_VERIFICATION_CODE_FIELD_NUMBER /* 43609 */:
                        return SEND_DELETE_ACCOUNT_VERIFICATION_CODE;
                    case SetRpcStruct$ComposedRpc.GET_MY_GROUPS_FIELD_NUMBER /* 43746 */:
                        return GET_MY_GROUPS;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_MY_GROUPS_FIELD_NUMBER /* 43747 */:
                        return RESPONSE_GET_MY_GROUPS;
                    case SetRpcStruct$ComposedRpc.LOAD_GROUP_AVATARS_FIELD_NUMBER /* 43748 */:
                        return LOAD_GROUP_AVATARS;
                    case SetRpcStruct$ComposedRpc.RESPONSE_LOAD_GROUP_AVATARS_FIELD_NUMBER /* 43749 */:
                        return RESPONSE_LOAD_GROUP_AVATARS;
                    case SetRpcStruct$ComposedRpc.REMOVE_USER_ADMIN_FIELD_NUMBER /* 44576 */:
                        return REMOVE_USER_ADMIN;
                    case SetRpcStruct$ComposedRpc.GET_PSPROXY_TOKEN_FIELD_NUMBER /* 53256 */:
                        return GET_PSPROXY_TOKEN;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_PSPROXY_TOKEN_FIELD_NUMBER /* 53257 */:
                        return RESPONSE_GET_PSPROXY_TOKEN;
                    case SetRpcStruct$ComposedRpc.GET_PSPROXY_PAYMENT_TOKEN_FIELD_NUMBER /* 53258 */:
                        return GET_PSPROXY_PAYMENT_TOKEN;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_PSPROXY_PAYMENT_TOKEN_FIELD_NUMBER /* 53259 */:
                        return RESPONSE_GET_PSPROXY_PAYMENT_TOKEN;
                    case SetRpcStruct$ComposedRpc.GET_REMAIN_TOKEN_FIELD_NUMBER /* 58106 */:
                        return GET_REMAIN_TOKEN;
                    case SetRpcStruct$ComposedRpc.GET_CARD_TRANSFER_TOKEN_FIELD_NUMBER /* 62125 */:
                        return GET_CARD_TRANSFER_TOKEN;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_CARD_TRANSFER_TOKEN_FIELD_NUMBER /* 62126 */:
                        return RESPONSE_GET_CARD_TRANSFER_TOKEN;
                    case SetRpcStruct$ComposedRpc.GET_PAY_MONEY_REQUEST_TOKEN_FIELD_NUMBER /* 62127 */:
                        return GET_PAY_MONEY_REQUEST_TOKEN;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_PAY_MONEY_REQUEST_TOKEN_FIELD_NUMBER /* 62128 */:
                        return RESPONSE_GET_PAY_MONEY_REQUEST_TOKEN;
                    case SetRpcStruct$ComposedRpc.CHANGE_DEFAULT_CARD_NUMBER_FIELD_NUMBER /* 62129 */:
                        return CHANGE_DEFAULT_CARD_NUMBER;
                    case SetRpcStruct$ComposedRpc.GET_PAYVAND_CARD_LIST_FIELD_NUMBER /* 62130 */:
                        return GET_PAYVAND_CARD_LIST;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_PAYVAND_CARD_LIST_FIELD_NUMBER /* 62131 */:
                        return RESPONSE_GET_PAYVAND_CARD_LIST;
                    case SetRpcStruct$ComposedRpc.GET_PAYVAND_CARD_FIELD_NUMBER /* 62132 */:
                        return GET_PAYVAND_CARD;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_PAYVAND_CARD_FIELD_NUMBER /* 62133 */:
                        return RESPONSE_GET_PAYVAND_CARD;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_REMAIN_TOKEN_FIELD_NUMBER /* 62138 */:
                        return RESPONSE_GET_REMAIN_TOKEN;
                    case SetRpcStruct$ComposedRpc.REMOVE_DEFAULT_CARD_NUMBER_FIELD_NUMBER /* 62177 */:
                        return REMOVE_DEFAULT_CARD_NUMBER;
                    case SetRpcStruct$ComposedRpc.GET_SADAD_PSPPAYMENT_TOKEN_FIELD_NUMBER /* 62180 */:
                        return GET_SADAD_PSPPAYMENT_TOKEN;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_SADAD_PSPPAYMENT_TOKEN_FIELD_NUMBER /* 62181 */:
                        return RESPONSE_GET_SADAD_PSPPAYMENT_TOKEN;
                    case SetRpcStruct$ComposedRpc.GET_MONEY_REQUEST_DETAILS_FIELD_NUMBER /* 62393 */:
                        return GET_MONEY_REQUEST_DETAILS;
                    case SetRpcStruct$ComposedRpc.GRANT_BANKI_ACCESS_FIELD_NUMBER /* 62397 */:
                        return GRANT_BANKI_ACCESS;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_MONEY_REQUEST_DETAILS_FIELD_NUMBER /* 62400 */:
                        return RESPONSE_GET_MONEY_REQUEST_DETAILS;
                    case SetRpcStruct$ComposedRpc.GET_MONEY_REQUEST_PAYMENT_LIST_FIELD_NUMBER /* 62401 */:
                        return GET_MONEY_REQUEST_PAYMENT_LIST;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_MONEY_REQUEST_PAYMENT_LIST_FIELD_NUMBER /* 62402 */:
                        return RESPONSE_GET_MONEY_REQUEST_PAYMENT_LIST;
                    case SetRpcStruct$ComposedRpc.BIND_MONEY_REQUEST_DETAILS_FIELD_NUMBER /* 62403 */:
                        return BIND_MONEY_REQUEST_DETAILS;
                    case SetRpcStruct$ComposedRpc.GET_BAM_SERVICE_TOKEN_FIELD_NUMBER /* 62406 */:
                        return GET_BAM_SERVICE_TOKEN;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_BAM_SERVICE_TOKEN_FIELD_NUMBER /* 62407 */:
                        return RESPONSE_GET_BAM_SERVICE_TOKEN;
                    case SetRpcStruct$ComposedRpc.GET_PAYMENT_TOKEN_FIELD_NUMBER /* 62408 */:
                        return GET_PAYMENT_TOKEN;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_PAYMENT_TOKEN_FIELD_NUMBER /* 62409 */:
                        return RESPONSE_GET_PAYMENT_TOKEN;
                    case SetRpcStruct$ComposedRpc.BIND_MONEY_REQUEST_DETAILS_LIST_FIELD_NUMBER /* 62410 */:
                        return BIND_MONEY_REQUEST_DETAILS_LIST;
                    case SetRpcStruct$ComposedRpc.UNBIND_ALL_MONEY_REQUEST_DETAILS_FIELD_NUMBER /* 62411 */:
                        return UNBIND_ALL_MONEY_REQUEST_DETAILS;
                    case SetRpcStruct$ComposedRpc.GET_RECENT_CHARGES_FIELD_NUMBER /* 62412 */:
                        return GET_RECENT_CHARGES;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_RECENT_CHARGES_FIELD_NUMBER /* 62414 */:
                        return RESPONSE_GET_RECENT_CHARGES;
                    case SetRpcStruct$ComposedRpc.BUY_FAST_CHARGE_FIELD_NUMBER /* 62464 */:
                        return BUY_FAST_CHARGE;
                    case SetRpcStruct$ComposedRpc.RESPONSE_BUY_FAST_CHARGE_FIELD_NUMBER /* 62465 */:
                        return RESPONSE_BUY_FAST_CHARGE;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_WALLET_INVOICE_FIELD_NUMBER /* 62729 */:
                        return RESPONSE_GET_WALLET_INVOICE;
                    case SetRpcStruct$ComposedRpc.GET_MY_WALLETS_FIELD_NUMBER /* 62730 */:
                        return GET_MY_WALLETS;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_MY_WALLETS_FIELD_NUMBER /* 62731 */:
                        return RESPONSE_GET_MY_WALLETS;
                    case SetRpcStruct$ComposedRpc.GET_WALLET_CHARGE_TOKEN_FIELD_NUMBER /* 62733 */:
                        return GET_WALLET_CHARGE_TOKEN;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_WALLET_CHARGE_TOKEN_FIELD_NUMBER /* 62734 */:
                        return RESPONSE_GET_WALLET_CHARGE_TOKEN;
                    case SetRpcStruct$ComposedRpc.PAY_BY_WALLET_FIELD_NUMBER /* 62746 */:
                        return PAY_BY_WALLET;
                    case SetRpcStruct$ComposedRpc.GET_PAYMENT_TOKEN_BY_CARD_FIELD_NUMBER /* 62747 */:
                        return GET_PAYMENT_TOKEN_BY_CARD;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_PAYMENT_TOKEN_BY_CARD_FIELD_NUMBER /* 62748 */:
                        return RESPONSE_GET_PAYMENT_TOKEN_BY_CARD;
                    case SetRpcStruct$ComposedRpc.VERIFY_QRCODE_FIELD_NUMBER /* 62749 */:
                        return VERIFY_QRCODE;
                    case SetRpcStruct$ComposedRpc.RESPONSE_VERIFY_QRCODE_FIELD_NUMBER /* 62750 */:
                        return RESPONSE_VERIFY_QRCODE;
                    case SetRpcStruct$ComposedRpc.PAY_MONEY_REQUEST_BY_WALLET_FIELD_NUMBER /* 62751 */:
                        return PAY_MONEY_REQUEST_BY_WALLET;
                    case SetRpcStruct$ComposedRpc.GET_WALLET_INVOICE_FIELD_NUMBER /* 62752 */:
                        return GET_WALLET_INVOICE;
                    case SetRpcStruct$ComposedRpc.VERIFY_PEER_FIELD_NUMBER /* 62756 */:
                        return VERIFY_PEER;
                    case SetRpcStruct$ComposedRpc.RESPONSE_VERIFY_PEER_FIELD_NUMBER /* 62757 */:
                        return RESPONSE_VERIFY_PEER;
                    case SetRpcStruct$ComposedRpc.GET_WALLET_CONTRACTS_FIELD_NUMBER /* 62758 */:
                        return GET_WALLET_CONTRACTS;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_WALLET_CONTRACTS_FIELD_NUMBER /* 62759 */:
                        return RESPONSE_GET_WALLET_CONTRACTS;
                    case SetRpcStruct$ComposedRpc.ACTIVATE_WALLET_FIELD_NUMBER /* 62760 */:
                        return ACTIVATE_WALLET;
                    case SetRpcStruct$ComposedRpc.GET_OTPTOKEN_FIELD_NUMBER /* 62761 */:
                        return GET_OTPTOKEN;
                    case SetRpcStruct$ComposedRpc.VERIFY_CASH_OUT_FIELD_NUMBER /* 62762 */:
                        return VERIFY_CASH_OUT;
                    case SetRpcStruct$ComposedRpc.RESPONSE_VERIFY_CASH_OUT_FIELD_NUMBER /* 62763 */:
                        return RESPONSE_VERIFY_CASH_OUT;
                    case SetRpcStruct$ComposedRpc.CASH_OUT_FROM_WALLET_FIELD_NUMBER /* 62764 */:
                        return CASH_OUT_FROM_WALLET;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_OTPTOKEN_FIELD_NUMBER /* 62768 */:
                        return RESPONSE_GET_OTPTOKEN;
                    case SetRpcStruct$ComposedRpc.GET_MONEY_REQUEST_PAYMENT_TOKEN_BY_CARD_FIELD_NUMBER /* 62769 */:
                        return GET_MONEY_REQUEST_PAYMENT_TOKEN_BY_CARD;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_MONEY_REQUEST_PAYMENT_TOKEN_BY_CARD_FIELD_NUMBER /* 62770 */:
                        return RESPONSE_GET_MONEY_REQUEST_PAYMENT_TOKEN_BY_CARD;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_GIFT_PACKET_PAYMENT_TOKEN_FIELD_NUMBER /* 63231 */:
                        return RESPONSE_GET_GIFT_PACKET_PAYMENT_TOKEN;
                    case SetRpcStruct$ComposedRpc.GET_GIFT_PACKET_PAYMENT_TOKEN_FIELD_NUMBER /* 63232 */:
                        return GET_GIFT_PACKET_PAYMENT_TOKEN;
                    case SetRpcStruct$ComposedRpc.SEND_GIFT_PACKET_WITH_WALLET_FIELD_NUMBER /* 63233 */:
                        return SEND_GIFT_PACKET_WITH_WALLET;
                    case SetRpcStruct$ComposedRpc.OPEN_GIFT_PACKET_FIELD_NUMBER /* 63236 */:
                        return OPEN_GIFT_PACKET;
                    case SetRpcStruct$ComposedRpc.RESPONSE_OPEN_GIFT_PACKET_FIELD_NUMBER /* 63237 */:
                        return RESPONSE_OPEN_GIFT_PACKET;
                    case SetRpcStruct$ComposedRpc.SEND_SERAJ_EVENT_FIELD_NUMBER /* 63238 */:
                        return SEND_SERAJ_EVENT;
                    case SetRpcStruct$ComposedRpc.LOAD_REACTIONS_FIELD_NUMBER /* 63239 */:
                        return LOAD_REACTIONS;
                    case SetRpcStruct$ComposedRpc.RESPONSE_LOAD_REACTIONS_FIELD_NUMBER /* 63240 */:
                        return RESPONSE_LOAD_REACTIONS;
                    case SetRpcStruct$ComposedRpc.GET_MY_BANK_FIELD_NUMBER /* 63243 */:
                        return GET_MY_BANK;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_MY_BANK_FIELD_NUMBER /* 63244 */:
                        return RESPONSE_GET_MY_BANK;
                    case SetRpcStruct$ComposedRpc.LOAD_GROUPS_FIELD_NUMBER /* 63245 */:
                        return LOAD_GROUPS;
                    case SetRpcStruct$ComposedRpc.RESPONSE_LOAD_GROUPS_FIELD_NUMBER /* 63246 */:
                        return RESPONSE_LOAD_GROUPS;
                    case SetRpcStruct$ComposedRpc.LOAD_USERS_FIELD_NUMBER /* 63247 */:
                        return LOAD_USERS;
                    case SetRpcStruct$ComposedRpc.RESPONSE_LOAD_USERS_FIELD_NUMBER /* 63248 */:
                        return RESPONSE_LOAD_USERS;
                    case SetRpcStruct$ComposedRpc.LOAD_PEER_DIALOGS_FIELD_NUMBER /* 63249 */:
                        return LOAD_PEER_DIALOGS;
                    case SetRpcStruct$ComposedRpc.RESPONSE_LOAD_PEER_DIALOGS_FIELD_NUMBER /* 63250 */:
                        return RESPONSE_LOAD_PEER_DIALOGS;
                    case SetRpcStruct$ComposedRpc.UNREGISTER_ALL_PUSH_CREDENTIALS_FIELD_NUMBER /* 63251 */:
                        return UNREGISTER_ALL_PUSH_CREDENTIALS;
                    case SetRpcStruct$ComposedRpc.GET_REACTIONS_FIELD_NUMBER /* 63254 */:
                        return GET_REACTIONS;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_REACTIONS_FIELD_NUMBER /* 63255 */:
                        return RESPONSE_GET_REACTIONS;
                    case SetRpcStruct$ComposedRpc.GET_USER_VITRINE_FIELD_NUMBER /* 63256 */:
                        return GET_USER_VITRINE;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_USER_VITRINE_FIELD_NUMBER /* 63257 */:
                        return RESPONSE_GET_USER_VITRINE;
                    case SetRpcStruct$ComposedRpc.GET_OTP_TOKEN_V2_FIELD_NUMBER /* 63258 */:
                        return GET_OTP_TOKEN_V2;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_OTP_TOKEN_V2_FIELD_NUMBER /* 63259 */:
                        return RESPONSE_GET_OTP_TOKEN_V2;
                    case SetRpcStruct$ComposedRpc.GET_BALE_TICKET_FIELD_NUMBER /* 63260 */:
                        return GET_BALE_TICKET;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_TICKET_FIELD_NUMBER /* 63261 */:
                        return RESPONSE_GET_TICKET;
                    case SetRpcStruct$ComposedRpc.SEARCH_MEDIA_FIELD_NUMBER /* 63262 */:
                        return SEARCH_MEDIA;
                    case SetRpcStruct$ComposedRpc.RESPONSE_SEARCH_MEDIA_FIELD_NUMBER /* 63263 */:
                        return RESPONSE_SEARCH_MEDIA;
                    case SetRpcStruct$ComposedRpc.GET_CHANNEL_ADS_FIELD_NUMBER /* 63264 */:
                        return GET_CHANNEL_ADS;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_CHANNEL_ADS_FIELD_NUMBER /* 63265 */:
                        return RESPONSE_GET_CHANNEL_ADS;
                    case SetRpcStruct$ComposedRpc.GET_MY_KIFPOOLS_FIELD_NUMBER /* 63400 */:
                        return GET_MY_KIFPOOLS;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_MY_KIFPOOLS_FIELD_NUMBER /* 63401 */:
                        return RESPONSE_GET_MY_KIFPOOLS;
                    case SetRpcStruct$ComposedRpc.UPGRADE_KIFPOOL_FIELD_NUMBER /* 63402 */:
                        return UPGRADE_KIFPOOL;
                    case SetRpcStruct$ComposedRpc.RESPONSE_UPGRADE_KIFPOOL_FIELD_NUMBER /* 63403 */:
                        return RESPONSE_UPGRADE_KIFPOOL;
                    case SetRpcStruct$ComposedRpc.CREATE_KIFPOOL_FIELD_NUMBER /* 63404 */:
                        return CREATE_KIFPOOL;
                    case SetRpcStruct$ComposedRpc.RESPONSE_CREATE_KIFPOOL_FIELD_NUMBER /* 63405 */:
                        return RESPONSE_CREATE_KIFPOOL;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_CHARGE_PAYMENT_TOKEN_FIELD_NUMBER /* 63406 */:
                        return RESPONSE_GET_CHARGE_PAYMENT_TOKEN;
                    case SetRpcStruct$ComposedRpc.CASHOUT_KIFPOOL_FIELD_NUMBER /* 63407 */:
                        return CASHOUT_KIFPOOL;
                    case SetRpcStruct$ComposedRpc.RESPONSE_CASHOUT_KIFPOOL_FIELD_NUMBER /* 63408 */:
                        return RESPONSE_CASHOUT_KIFPOOL;
                    case SetRpcStruct$ComposedRpc.INVOICE_KIFPOOL_FIELD_NUMBER /* 63409 */:
                        return INVOICE_KIFPOOL;
                    case SetRpcStruct$ComposedRpc.RESPONSE_INVOICE_KIFPOOL_FIELD_NUMBER /* 63410 */:
                        return RESPONSE_INVOICE_KIFPOOL;
                    case SetRpcStruct$ComposedRpc.TRANSFER_MONEY_FIELD_NUMBER /* 63411 */:
                        return TRANSFER_MONEY;
                    case SetRpcStruct$ComposedRpc.RESPONSE_TRANSFER_MONEY_FIELD_NUMBER /* 63412 */:
                        return RESPONSE_TRANSFER_MONEY;
                    case SetRpcStruct$ComposedRpc.CHECK_CHARGE_PERMISSION_FIELD_NUMBER /* 63413 */:
                        return CHECK_CHARGE_PERMISSION;
                    case SetRpcStruct$ComposedRpc.RESPONSE_CHECK_CHARGE_PERMISSION_FIELD_NUMBER /* 63414 */:
                        return RESPONSE_CHECK_CHARGE_PERMISSION;
                    case SetRpcStruct$ComposedRpc.CHARGE_FIELD_NUMBER /* 63415 */:
                        return CHARGE;
                    case SetRpcStruct$ComposedRpc.RESPONSE_CHARGE_FIELD_NUMBER /* 63416 */:
                        return RESPONSE_CHARGE;
                    case SetRpcStruct$ComposedRpc.GET_CHARGE_PAYMENT_TOKEN_FIELD_NUMBER /* 63417 */:
                        return GET_CHARGE_PAYMENT_TOKEN;
                    case SetRpcStruct$ComposedRpc.PURCHASE_MESSAGE_FIELD_NUMBER /* 63418 */:
                        return PURCHASE_MESSAGE;
                    case SetRpcStruct$ComposedRpc.RESPONSE_PURCHASE_MESSAGE_FIELD_NUMBER /* 63419 */:
                        return RESPONSE_PURCHASE_MESSAGE;
                    case SetRpcStruct$ComposedRpc.GET_KIFPOOL_OWNER_FIELD_NUMBER /* 63420 */:
                        return GET_KIFPOOL_OWNER;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_KIFPOOL_OWNER_FIELD_NUMBER /* 63421 */:
                        return RESPONSE_GET_KIFPOOL_OWNER;
                    case SetRpcStruct$ComposedRpc.PURCHASE_MESSAGE_WITH_CHARGE_FIELD_NUMBER /* 63428 */:
                        return PURCHASE_MESSAGE_WITH_CHARGE;
                    case SetRpcStruct$ComposedRpc.RESPONSE_PURCHASE_MESSAGE_WITH_CHARGE_FIELD_NUMBER /* 63429 */:
                        return RESPONSE_PURCHASE_MESSAGE_WITH_CHARGE;
                    case SetRpcStruct$ComposedRpc.VERIFY_PURCHASE_MESSAGE_FIELD_NUMBER /* 63430 */:
                        return VERIFY_PURCHASE_MESSAGE;
                    case SetRpcStruct$ComposedRpc.RESPONSE_VERIFY_PURCHASE_MESSAGE_FIELD_NUMBER /* 63431 */:
                        return RESPONSE_VERIFY_PURCHASE_MESSAGE;
                    case SetRpcStruct$ComposedRpc.VERIFY_CASH_OUT_KIFPOOL_FIELD_NUMBER /* 63432 */:
                        return VERIFY_CASH_OUT_KIFPOOL;
                    case SetRpcStruct$ComposedRpc.RESPONSE_VERIFY_CASH_OUT_KIFPOOL_FIELD_NUMBER /* 63433 */:
                        return RESPONSE_VERIFY_CASH_OUT_KIFPOOL;
                    case SetRpcStruct$ComposedRpc.GET_POINT_BALANCE_FIELD_NUMBER /* 63434 */:
                        return GET_POINT_BALANCE;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_POINT_BALANCE_FIELD_NUMBER /* 63435 */:
                        return RESPONSE_GET_POINT_BALANCE;
                    case SetRpcStruct$ComposedRpc.GET_CHANNEL_EARN_MONEY_STATUS_FIELD_NUMBER /* 63436 */:
                        return GET_CHANNEL_EARN_MONEY_STATUS;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_CHANNEL_EARN_MONEY_STATUS_FIELD_NUMBER /* 63437 */:
                        return RESPONSE_GET_CHANNEL_EARN_MONEY_STATUS;
                    case SetRpcStruct$ComposedRpc.REGISTER_FOR_EARN_MONEY_FIELD_NUMBER /* 63438 */:
                        return REGISTER_FOR_EARN_MONEY;
                    case SetRpcStruct$ComposedRpc.UPDATE_GROUP_STATUS_FIELD_NUMBER /* 63439 */:
                        return UPDATE_GROUP_STATUS;
                    case SetRpcStruct$ComposedRpc.GET_USER_STATUS_FIELD_NUMBER /* 63441 */:
                        return GET_USER_STATUS;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_USER_STATUS_FIELD_NUMBER /* 63442 */:
                        return RESPONSE_GET_USER_STATUS;
                    case SetRpcStruct$ComposedRpc.GET_USER_ACCOUNTS_FIELD_NUMBER /* 63443 */:
                        return GET_USER_ACCOUNTS;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_USER_ACCOUNTS_FIELD_NUMBER /* 63444 */:
                        return RESPONSE_GET_USER_ACCOUNTS;
                    case SetRpcStruct$ComposedRpc.LOAD_TRANSACTIONS_FIELD_NUMBER /* 63445 */:
                        return LOAD_TRANSACTIONS;
                    case SetRpcStruct$ComposedRpc.RESPONSE_LOAD_TRANSACTIONS_FIELD_NUMBER /* 63446 */:
                        return RESPONSE_LOAD_TRANSACTIONS;
                    case SetRpcStruct$ComposedRpc.GET_CHANNEL_EARN_MONEY_INFO_FIELD_NUMBER /* 63447 */:
                        return GET_CHANNEL_EARN_MONEY_INFO;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_CHANNEL_EARN_MONEY_INFO_FIELD_NUMBER /* 63448 */:
                        return RESPONSE_GET_CHANNEL_EARN_MONEY_INFO;
                    case SetRpcStruct$ComposedRpc.ADD_TRANSACTION_TAGS_FIELD_NUMBER /* 63449 */:
                        return ADD_TRANSACTION_TAGS;
                    case SetRpcStruct$ComposedRpc.REMOVE_TRANSACTION_TAGS_FIELD_NUMBER /* 63450 */:
                        return REMOVE_TRANSACTION_TAGS;
                    case SetRpcStruct$ComposedRpc.GET_POINT_SUMMERY_FIELD_NUMBER /* 63451 */:
                        return GET_POINT_SUMMERY;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_POINT_SUMMERY_FIELD_NUMBER /* 63452 */:
                        return RESPONSE_GET_POINT_SUMMERY;
                    case SetRpcStruct$ComposedRpc.CHANGE_PHONE_FIELD_NUMBER /* 63453 */:
                        return CHANGE_PHONE;
                    case SetRpcStruct$ComposedRpc.SEND_CHANGE_PHONE_VERIFICATION_CODE_FIELD_NUMBER /* 63454 */:
                        return SEND_CHANGE_PHONE_VERIFICATION_CODE;
                    case SetRpcStruct$ComposedRpc.SET_MEMBER_PERMISSIONS_FIELD_NUMBER /* 63455 */:
                        return SET_MEMBER_PERMISSIONS;
                    case SetRpcStruct$ComposedRpc.GET_MEMBER_PERMISSIONS_FIELD_NUMBER /* 63456 */:
                        return GET_MEMBER_PERMISSIONS;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_MEMBER_PERMISSIONS_FIELD_NUMBER /* 63457 */:
                        return RESPONSE_GET_MEMBER_PERMISSIONS;
                    case SetRpcStruct$ComposedRpc.GET_POINT_DETAILS_FIELD_NUMBER /* 63458 */:
                        return GET_POINT_DETAILS;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_POINT_DETAILS_FIELD_NUMBER /* 63459 */:
                        return RESPONSE_GET_POINT_DETAILS;
                    case SetRpcStruct$ComposedRpc.GET_REFERRING_USER_FIELD_NUMBER /* 63460 */:
                        return GET_REFERRING_USER;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_REFERRING_USER_FIELD_NUMBER /* 63461 */:
                        return RESPONSE_GET_REFERRING_USER;
                    case SetRpcStruct$ComposedRpc.TRANSACTION_POINT_FIELD_NUMBER /* 63462 */:
                        return TRANSACTION_POINT;
                    case SetRpcStruct$ComposedRpc.RESPONSE_TRANSACTION_POINT_FIELD_NUMBER /* 63463 */:
                        return RESPONSE_TRANSACTION_POINT;
                    case SetRpcStruct$ComposedRpc.CHANGE_POINT_TO_MONEY_FIELD_NUMBER /* 63464 */:
                        return CHANGE_POINT_TO_MONEY;
                    case SetRpcStruct$ComposedRpc.RESPONSE_CHANGE_POINT_TO_MONEY_FIELD_NUMBER /* 63465 */:
                        return RESPONSE_CHANGE_POINT_TO_MONEY;
                    case SetRpcStruct$ComposedRpc.BUY_WHEEL_CHANCE_FIELD_NUMBER /* 63466 */:
                        return BUY_WHEEL_CHANCE;
                    case SetRpcStruct$ComposedRpc.RESPONSE_BUY_WHEEL_CHANCE_FIELD_NUMBER /* 63467 */:
                        return RESPONSE_BUY_WHEEL_CHANCE;
                    case SetRpcStruct$ComposedRpc.GET_WHEEL_FIELD_NUMBER /* 63468 */:
                        return GET_WHEEL;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_WHEEL_FIELD_NUMBER /* 63469 */:
                        return RESPONSE_GET_WHEEL;
                    case SetRpcStruct$ComposedRpc.SPIN_WHEEL_FIELD_NUMBER /* 63470 */:
                        return SPIN_WHEEL;
                    case SetRpcStruct$ComposedRpc.RESPONSE_SPIN_WHEEL_FIELD_NUMBER /* 63471 */:
                        return RESPONSE_SPIN_WHEEL;
                    case SetRpcStruct$ComposedRpc.GET_VOUCHERS_FIELD_NUMBER /* 63472 */:
                        return GET_VOUCHERS;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_VOUCHERS_FIELD_NUMBER /* 63473 */:
                        return RESPONSE_GET_VOUCHERS;
                    case SetRpcStruct$ComposedRpc.BUY_VOUCHER_FIELD_NUMBER /* 63474 */:
                        return BUY_VOUCHER;
                    case SetRpcStruct$ComposedRpc.RESPONSE_BUY_VOUCHER_FIELD_NUMBER /* 63475 */:
                        return RESPONSE_BUY_VOUCHER;
                    case SetRpcStruct$ComposedRpc.SET_GROUP_DEFAULT_PERMISSIONS_FIELD_NUMBER /* 63476 */:
                        return SET_GROUP_DEFAULT_PERMISSIONS;
                    case SetRpcStruct$ComposedRpc.GET_REFERRED_COUNT_FIELD_NUMBER /* 63477 */:
                        return GET_REFERRED_COUNT;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_REFERRED_COUNT_FIELD_NUMBER /* 63478 */:
                        return RESPONSE_GET_REFERRED_COUNT;
                    case SetRpcStruct$ComposedRpc.GET_WEBVIEW_TRACKING_NUMBER_FIELD_NUMBER /* 63481 */:
                        return GET_WEBVIEW_TRACKING_NUMBER;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_WEBVIEW_TRACKING_NUMBER_FIELD_NUMBER /* 63482 */:
                        return RESPONSE_GET_WEBVIEW_TRACKING_NUMBER;
                    case SetRpcStruct$ComposedRpc.GET_CHARGE_TOPUP_PAYMENT_TOKEN_FIELD_NUMBER /* 63484 */:
                        return GET_CHARGE_TOPUP_PAYMENT_TOKEN;
                    case SetRpcStruct$ComposedRpc.GET_CHARGE_VOUCHER_PAYMENT_TOKEN_FIELD_NUMBER /* 63485 */:
                        return GET_CHARGE_VOUCHER_PAYMENT_TOKEN;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_PSP_PAYMENTTOKEN_FIELD_NUMBER /* 63486 */:
                        return RESPONSE_GET_PSP_PAYMENTTOKEN;
                    case SetRpcStruct$ComposedRpc.ENROLL_NEW_CARD_FIELD_NUMBER /* 63487 */:
                        return ENROLL_NEW_CARD;
                    case SetRpcStruct$ComposedRpc.RESPONSE_ENROLL_NEW_CARD_FIELD_NUMBER /* 63488 */:
                        return RESPONSE_ENROLL_NEW_CARD;
                    case SetRpcStruct$ComposedRpc.GET_CARD_INFO_FIELD_NUMBER /* 63489 */:
                        return GET_CARD_INFO;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_CARD_INFO_FIELD_NUMBER /* 63490 */:
                        return RESPONSE_GET_CARD_INFO;
                    case SetRpcStruct$ComposedRpc.GET_DESTINATION_CARD_INFO_FIELD_NUMBER /* 63491 */:
                        return GET_DESTINATION_CARD_INFO;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_DESTINATION_CARD_INFO_FIELD_NUMBER /* 63492 */:
                        return RESPONSE_GET_DESTINATION_CARD_INFO;
                    case SetRpcStruct$ComposedRpc.DELIVER_OTP_FIELD_NUMBER /* 63493 */:
                        return DELIVER_OTP;
                    case SetRpcStruct$ComposedRpc.TRANSFER_MONEY_BY_CARD_FIELD_NUMBER /* 63495 */:
                        return TRANSFER_MONEY_BY_CARD;
                    case SetRpcStruct$ComposedRpc.GET_LINK_PREVIEW_FIELD_NUMBER /* 63497 */:
                        return GET_LINK_PREVIEW;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_LINK_PREVIEW_FIELD_NUMBER /* 63498 */:
                        return RESPONSE_GET_LINK_PREVIEW;
                    case SetRpcStruct$ComposedRpc.GET_GROUP_MEMBERS_COUNT_FIELD_NUMBER /* 63499 */:
                        return GET_GROUP_MEMBERS_COUNT;
                    case SetRpcStruct$ComposedRpc.GET_REFERRAL_CODE_FIELD_NUMBER /* 63500 */:
                        return GET_REFERRAL_CODE;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_REFERRAL_CODE_FIELD_NUMBER /* 63501 */:
                        return RESPONSE_GET_REFERRAL_CODE;
                    case SetRpcStruct$ComposedRpc.REFER_FIELD_NUMBER /* 63502 */:
                        return REFER;
                    case SetRpcStruct$ComposedRpc.RESPONSE_REFER_FIELD_NUMBER /* 63503 */:
                        return RESPONSE_REFER;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_GROUP_MEMBERS_COUNT_FIELD_NUMBER /* 63504 */:
                        return RESPONSE_GET_GROUP_MEMBERS_COUNT;
                    case SetRpcStruct$ComposedRpc.RESPONSE_SEND_CHANGE_PHONE_VERIFICATION_CODE_FIELD_NUMBER /* 63505 */:
                        return RESPONSE_SEND_CHANGE_PHONE_VERIFICATION_CODE;
                    case SetRpcStruct$ComposedRpc.SET_RECENT_ORDER_FIELD_NUMBER /* 63506 */:
                        return SET_RECENT_ORDER;
                    case SetRpcStruct$ComposedRpc.GET_RECENT_ORDERS_FIELD_NUMBER /* 63507 */:
                        return GET_RECENT_ORDERS;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_RECENT_ORDERS_FIELD_NUMBER /* 63508 */:
                        return RESPONSE_GET_RECENT_ORDERS;
                    case SetRpcStruct$ComposedRpc.DELETE_ORDER_FIELD_NUMBER /* 63509 */:
                        return DELETE_ORDER;
                    case SetRpcStruct$ComposedRpc.GET_CHARGE_AMOUNTS_FIELD_NUMBER /* 63510 */:
                        return GET_CHARGE_AMOUNTS;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_CHARGE_AMOUNTS_FIELD_NUMBER /* 63511 */:
                        return RESPONSE_GET_CHARGE_AMOUNTS;
                    case SetRpcStruct$ComposedRpc.GET_PARTICIPANTS_FIELD_NUMBER /* 63512 */:
                        return GET_PARTICIPANTS;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_PARTICIPANTS_FIELD_NUMBER /* 63513 */:
                        return RESPONSE_GET_PARTICIPANTS;
                    case SetRpcStruct$ComposedRpc.GET_TRANSACTION_TAGS_FIELD_NUMBER /* 63516 */:
                        return GET_TRANSACTION_TAGS;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_TRANSACTION_TAGS_FIELD_NUMBER /* 63517 */:
                        return RESPONSE_GET_TRANSACTION_TAGS;
                    case SetRpcStruct$ComposedRpc.ADD_USER_TAGS_FIELD_NUMBER /* 63518 */:
                        return ADD_USER_TAGS;
                    case SetRpcStruct$ComposedRpc.REMOVE_USER_TAGS_FIELD_NUMBER /* 63519 */:
                        return REMOVE_USER_TAGS;
                    case SetRpcStruct$ComposedRpc.GET_USER_TAGS_FIELD_NUMBER /* 63520 */:
                        return GET_USER_TAGS;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_USER_TAGS_FIELD_NUMBER /* 63521 */:
                        return RESPONSE_GET_USER_TAGS;
                    case SetRpcStruct$ComposedRpc.GET_USER_BANK_FIELD_NUMBER /* 63522 */:
                        return GET_USER_BANK;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_USER_BANK_FIELD_NUMBER /* 63524 */:
                        return RESPONSE_GET_USER_BANK;
                    case SetRpcStruct$ComposedRpc.GET_AD_PROVIDER_FIELD_NUMBER /* 63525 */:
                        return GET_AD_PROVIDER;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_AD_PROVIDER_FIELD_NUMBER /* 63526 */:
                        return RESPONSE_GET_AD_PROVIDER;
                    case SetRpcStruct$ComposedRpc.GET_TOTAL_PAID_AMOUNT_FIELD_NUMBER /* 63527 */:
                        return GET_TOTAL_PAID_AMOUNT;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_TOTAL_PAID_AMOUNT_FIELD_NUMBER /* 63528 */:
                        return RESPONSE_GET_TOTAL_PAID_AMOUNT;
                    case SetRpcStruct$ComposedRpc.SEND_FEED_BACK_FIELD_NUMBER /* 63529 */:
                        return SEND_FEED_BACK;
                    case SetRpcStruct$ComposedRpc.GET_INTERNET_BUNDLE_PAYMENT_TOKEN_FIELD_NUMBER /* 63530 */:
                        return GET_INTERNET_BUNDLE_PAYMENT_TOKEN;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_INTERNET_BUNDLE_PAYMENT_TOKEN_FIELD_NUMBER /* 63531 */:
                        return RESPONSE_GET_INTERNET_BUNDLE_PAYMENT_TOKEN;
                    case SetRpcStruct$ComposedRpc.GET_INTERNET_BUNDLE_LIST_FIELD_NUMBER /* 63532 */:
                        return GET_INTERNET_BUNDLE_LIST;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_INTERNET_BUNDLE_LIST_FIELD_NUMBER /* 63533 */:
                        return RESPONSE_GET_INTERNET_BUNDLE_LIST;
                    case SetRpcStruct$ComposedRpc.GET_RECENT_INTERNET_BUNDLE_ORDERS_FIELD_NUMBER /* 63534 */:
                        return GET_RECENT_INTERNET_BUNDLE_ORDERS;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_RECENT_INTERNET_BUNDLE_ORDERS_FIELD_NUMBER /* 63535 */:
                        return RESPONSE_GET_RECENT_INTERNET_BUNDLE_ORDERS;
                    case SetRpcStruct$ComposedRpc.DELETE_INTERNET_BUNDLE_ORDER_FIELD_NUMBER /* 63536 */:
                        return DELETE_INTERNET_BUNDLE_ORDER;
                    case SetRpcStruct$ComposedRpc.BUY_CHARGE_FIELD_NUMBER /* 63537 */:
                        return BUY_CHARGE;
                    case SetRpcStruct$ComposedRpc.RESPONSE_BUY_CHARGE_FIELD_NUMBER /* 63538 */:
                        return RESPONSE_BUY_CHARGE;
                    case SetRpcStruct$ComposedRpc.BUY_INTERNET_BUNDLE_FIELD_NUMBER /* 63539 */:
                        return BUY_INTERNET_BUNDLE;
                    case SetRpcStruct$ComposedRpc.RESPONSE_BUY_INTERNET_BUNDLE_FIELD_NUMBER /* 63540 */:
                        return RESPONSE_BUY_INTERNET_BUNDLE;
                    case SetRpcStruct$ComposedRpc.GET_USERS_DEFAULT_CARD_NUMBER_FIELD_NUMBER /* 63541 */:
                        return GET_USERS_DEFAULT_CARD_NUMBER;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_USERS_DEFAULT_CARD_NUMBER_FIELD_NUMBER /* 63542 */:
                        return RESPONSE_GET_USERS_DEFAULT_CARD_NUMBER;
                    case SetRpcStruct$ComposedRpc.INQUIRY_BILL_FIELD_NUMBER /* 63543 */:
                        return INQUIRY_BILL;
                    case SetRpcStruct$ComposedRpc.RESPONSE_INQUIRY_BILL_FIELD_NUMBER /* 63544 */:
                        return RESPONSE_INQUIRY_BILL;
                    case SetRpcStruct$ComposedRpc.PAY_BILL_FIELD_NUMBER /* 63545 */:
                        return PAY_BILL;
                    case SetRpcStruct$ComposedRpc.RESPONSE_PAY_BILL_FIELD_NUMBER /* 63546 */:
                        return RESPONSE_PAY_BILL;
                    case SetRpcStruct$ComposedRpc.GET_BILL_HISTORY_FIELD_NUMBER /* 63547 */:
                        return GET_BILL_HISTORY;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_BILL_HISTORY_FIELD_NUMBER /* 63548 */:
                        return RESPONSE_GET_BILL_HISTORY;
                    case SetRpcStruct$ComposedRpc.CREATE_SAVED_BILL_FIELD_NUMBER /* 63549 */:
                        return CREATE_SAVED_BILL;
                    case SetRpcStruct$ComposedRpc.RESPONSE_CREATE_SAVED_BILL_FIELD_NUMBER /* 63550 */:
                        return RESPONSE_CREATE_SAVED_BILL;
                    case SetRpcStruct$ComposedRpc.GET_SAVED_BILLS_FIELD_NUMBER /* 63551 */:
                        return GET_SAVED_BILLS;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_SAVED_BILLS_FIELD_NUMBER /* 63552 */:
                        return RESPONSE_GET_SAVED_BILLS;
                    case SetRpcStruct$ComposedRpc.RENAME_SAVED_BILL_FIELD_NUMBER /* 63553 */:
                        return RENAME_SAVED_BILL;
                    case SetRpcStruct$ComposedRpc.DELETE_SAVED_BILLS_FIELD_NUMBER /* 63554 */:
                        return DELETE_SAVED_BILLS;
                    case SetRpcStruct$ComposedRpc.ADD_NEW_CARDS_FIELD_NUMBER /* 63555 */:
                        return ADD_NEW_CARDS;
                    case SetRpcStruct$ComposedRpc.RESPONSE_ADD_NEW_CARDS_FIELD_NUMBER /* 63556 */:
                        return RESPONSE_ADD_NEW_CARDS;
                    case SetRpcStruct$ComposedRpc.REMOVE_CARD_FIELD_NUMBER /* 63557 */:
                        return REMOVE_CARD;
                    case SetRpcStruct$ComposedRpc.GET_CARDS_FIELD_NUMBER /* 63558 */:
                        return GET_CARDS;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_CARDS_FIELD_NUMBER /* 63559 */:
                        return RESPONSE_GET_CARDS;
                    case SetRpcStruct$ComposedRpc.UPDATE_VIEW_FIELD_NUMBER /* 63560 */:
                        return UPDATE_VIEW;
                    case SetRpcStruct$ComposedRpc.RESPONSE_UPDATE_VIEW_FIELD_NUMBER /* 63561 */:
                        return RESPONSE_UPDATE_VIEW;
                    case SetRpcStruct$ComposedRpc.SET_DEFAULT_CARD_FIELD_NUMBER /* 63562 */:
                        return SET_DEFAULT_CARD;
                    case SetRpcStruct$ComposedRpc.GET_DEFAULT_CARD_FIELD_NUMBER /* 63563 */:
                        return GET_DEFAULT_CARD;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_DEFAULT_CARD_FIELD_NUMBER /* 63564 */:
                        return RESPONSE_GET_DEFAULT_CARD;
                    case SetRpcStruct$ComposedRpc.REMOVE_DEFAULT_CARD_FIELD_NUMBER /* 63565 */:
                        return REMOVE_DEFAULT_CARD;
                    case SetRpcStruct$ComposedRpc.EDIT_CARD_EXPIRATION_DATE_FIELD_NUMBER /* 63566 */:
                        return EDIT_CARD_EXPIRATION_DATE;
                    case SetRpcStruct$ComposedRpc.SUBMIT_DIALOG_AD_ORDER_FIELD_NUMBER /* 63567 */:
                        return SUBMIT_DIALOG_AD_ORDER;
                    case SetRpcStruct$ComposedRpc.GET_DIALOG_AD_ORDER_DETAILS_FIELD_NUMBER /* 63568 */:
                        return GET_DIALOG_AD_ORDER_DETAILS;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_DIALOG_AD_ORDER_DETAILS_FIELD_NUMBER /* 63569 */:
                        return RESPONSE_GET_DIALOG_AD_ORDER_DETAILS;
                    case SetRpcStruct$ComposedRpc.CHANGE_STATUS_DIALOG_AD_ORDER_FIELD_NUMBER /* 63570 */:
                        return CHANGE_STATUS_DIALOG_AD_ORDER;
                    case SetRpcStruct$ComposedRpc.GET_DIALOG_AD_ORDER_PAYMENT_TOKEN_FIELD_NUMBER /* 63571 */:
                        return GET_DIALOG_AD_ORDER_PAYMENT_TOKEN;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_DIALOG_AD_ORDER_PAYMENT_TOKEN_FIELD_NUMBER /* 63572 */:
                        return RESPONSE_GET_DIALOG_AD_ORDER_PAYMENT_TOKEN;
                    case SetRpcStruct$ComposedRpc.GET_MY_SENTENCE_FIELD_NUMBER /* 63573 */:
                        return GET_MY_SENTENCE;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_MY_SENTENCE_FIELD_NUMBER /* 63574 */:
                        return RESPONSE_GET_MY_SENTENCE;
                    case SetRpcStruct$ComposedRpc.VALIDATE_MY_SENTENCE_FIELD_NUMBER /* 63575 */:
                        return VALIDATE_MY_SENTENCE;
                    case SetRpcStruct$ComposedRpc.RESPONSE_VALIDATE_MY_SENTENCE_FIELD_NUMBER /* 63576 */:
                        return RESPONSE_VALIDATE_MY_SENTENCE;
                    case SetRpcStruct$ComposedRpc.SEND_MY_GIFT_PACKET_FIELD_NUMBER /* 63577 */:
                        return SEND_MY_GIFT_PACKET;
                    case SetRpcStruct$ComposedRpc.START_CALL_FIELD_NUMBER /* 63578 */:
                        return START_CALL;
                    case SetRpcStruct$ComposedRpc.ACCEPT_CALL_FIELD_NUMBER /* 63579 */:
                        return ACCEPT_CALL;
                    case SetRpcStruct$ComposedRpc.DISCARD_CALL_FIELD_NUMBER /* 63580 */:
                        return DISCARD_CALL;
                    case SetRpcStruct$ComposedRpc.RESPONSE_CALL_FIELD_NUMBER /* 63581 */:
                        return RESPONSE_CALL;
                    case SetRpcStruct$ComposedRpc.GET_LOAN_INFO_FIELD_NUMBER /* 63582 */:
                        return GET_LOAN_INFO;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_LOAN_INFO_FIELD_NUMBER /* 63583 */:
                        return RESPONSE_GET_LOAN_INFO;
                    case SetRpcStruct$ComposedRpc.GET_LOANS_LIST_FIELD_NUMBER /* 63584 */:
                        return GET_LOANS_LIST;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_LOANS_LIST_FIELD_NUMBER /* 63585 */:
                        return RESPONSE_GET_LOANS_LIST;
                    case SetRpcStruct$ComposedRpc.GET_DESTINATION_CARDS_FIELD_NUMBER /* 63586 */:
                        return GET_DESTINATION_CARDS;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_DESTINATION_CARDS_FIELD_NUMBER /* 63587 */:
                        return RESPONSE_GET_DESTINATION_CARDS;
                    case SetRpcStruct$ComposedRpc.ADD_DESTINATION_CARDS_FIELD_NUMBER /* 63588 */:
                        return ADD_DESTINATION_CARDS;
                    case SetRpcStruct$ComposedRpc.RESPONSE_ADD_DESTINATION_CARDS_FIELD_NUMBER /* 63589 */:
                        return RESPONSE_ADD_DESTINATION_CARDS;
                    case SetRpcStruct$ComposedRpc.REMOVE_DESTINATION_CARDS_FIELD_NUMBER /* 63590 */:
                        return REMOVE_DESTINATION_CARDS;
                    case SetRpcStruct$ComposedRpc.REACTIVATE_APP_FIELD_NUMBER /* 63591 */:
                        return REACTIVATE_APP;
                    case SetRpcStruct$ComposedRpc.RESPONSE_REACTIVATE_APP_FIELD_NUMBER /* 63592 */:
                        return RESPONSE_REACTIVATE_APP;
                    case SetRpcStruct$ComposedRpc.GET_SCORE_BOARD_FIELD_NUMBER /* 63593 */:
                        return GET_SCORE_BOARD;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_SCORE_BOARD_FIELD_NUMBER /* 63594 */:
                        return RESPONSE_GET_SCORE_BOARD;
                    case SetRpcStruct$ComposedRpc.GET_USER_SCORE_FIELD_NUMBER /* 63595 */:
                        return GET_USER_SCORE;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_USER_SCORE_FIELD_NUMBER /* 63596 */:
                        return RESPONSE_GET_USER_SCORE;
                    case SetRpcStruct$ComposedRpc.GET_PACKETS_STATUS_FIELD_NUMBER /* 63597 */:
                        return GET_PACKETS_STATUS;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_PACKETS_STATUS_FIELD_NUMBER /* 63598 */:
                        return RESPONSE_GET_PACKETS_STATUS;
                    case SetRpcStruct$ComposedRpc.GET_USER_REFERS_FIELD_NUMBER /* 63599 */:
                        return GET_USER_REFERS;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_USER_REFERS_FIELD_NUMBER /* 63600 */:
                        return RESPONSE_GET_USER_REFERS;
                    case SetRpcStruct$ComposedRpc.GET_REFERRAL_CONTACTS_FIELD_NUMBER /* 63601 */:
                        return GET_REFERRAL_CONTACTS;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_REFERRAL_CONTACTS_FIELD_NUMBER /* 63602 */:
                        return RESPONSE_GET_REFERRAL_CONTACTS;
                    case SetRpcStruct$ComposedRpc.SEND_REFERRAL_FIELD_NUMBER /* 63603 */:
                        return SEND_REFERRAL;
                    case SetRpcStruct$ComposedRpc.GET_PACKET_FIELD_NUMBER /* 63604 */:
                        return GET_PACKET;
                    case SetRpcStruct$ComposedRpc.ACCEPT_REFERRAL_INVITE_FIELD_NUMBER /* 63605 */:
                        return ACCEPT_REFERRAL_INVITE;
                    case SetRpcStruct$ComposedRpc.AUTHORIZE_USER_FIELD_NUMBER /* 63606 */:
                        return AUTHORIZE_USER;
                    case SetRpcStruct$ComposedRpc.RESPONSE_AUTHORIZE_USER_FIELD_NUMBER /* 63607 */:
                        return RESPONSE_AUTHORIZE_USER;
                    case SetRpcStruct$ComposedRpc.INIT_P12_FIELD_NUMBER /* 63608 */:
                        return INIT_P12;
                    case SetRpcStruct$ComposedRpc.RESPONSE_INIT_P12_FIELD_NUMBER /* 63609 */:
                        return RESPONSE_INIT_P12;
                    case SetRpcStruct$ComposedRpc.INIT_SEFTE_FIELD_NUMBER /* 63610 */:
                        return INIT_SEFTE;
                    case SetRpcStruct$ComposedRpc.RESPONSE_INIT_SEFTE_FIELD_NUMBER /* 63611 */:
                        return RESPONSE_INIT_SEFTE;
                    case SetRpcStruct$ComposedRpc.SIGN_SEFTE_FIELD_NUMBER /* 63612 */:
                        return SIGN_SEFTE;
                    case SetRpcStruct$ComposedRpc.RESPONSE_SIGN_SEFTE_FIELD_NUMBER /* 63613 */:
                        return RESPONSE_SIGN_SEFTE;
                    case SetRpcStruct$ComposedRpc.PAY_SEFTE_FIELD_NUMBER /* 63614 */:
                        return PAY_SEFTE;
                    case SetRpcStruct$ComposedRpc.GET_STATES_FIELD_NUMBER /* 63615 */:
                        return GET_STATES;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_STATES_FIELD_NUMBER /* 63616 */:
                        return RESPONSE_GET_STATES;
                    case SetRpcStruct$ComposedRpc.GET_CITIES_OF_STATE_FIELD_NUMBER /* 63617 */:
                        return GET_CITIES_OF_STATE;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_CITIES_OF_STATE_FIELD_NUMBER /* 63618 */:
                        return RESPONSE_GET_CITIES_OF_STATE;
                    case SetRpcStruct$ComposedRpc.CHECK_STATUS_OF_PAYMENT_FIELD_NUMBER /* 63619 */:
                        return CHECK_STATUS_OF_PAYMENT;
                    case SetRpcStruct$ComposedRpc.GET_USER_SEFTES_FIELD_NUMBER /* 63620 */:
                        return GET_USER_SEFTES;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_USER_SEFTES_FIELD_NUMBER /* 63621 */:
                        return RESPONSE_GET_USER_SEFTES;
                    case SetRpcStruct$ComposedRpc.UPDATE_CLICK_FIELD_NUMBER /* 63622 */:
                        return UPDATE_CLICK;
                    case SetRpcStruct$ComposedRpc.RESPONSE_UPDATE_CLICK_FIELD_NUMBER /* 63623 */:
                        return RESPONSE_UPDATE_CLICK;
                    case SetRpcStruct$ComposedRpc.USER_HAS_CRED_FIELD_NUMBER /* 63624 */:
                        return USER_HAS_CRED;
                    case SetRpcStruct$ComposedRpc.RESPONSE_USER_HAS_CRED_FIELD_NUMBER /* 63625 */:
                        return RESPONSE_USER_HAS_CRED;
                    case SetRpcStruct$ComposedRpc.GET_RECIPIENTS_FIELD_NUMBER /* 63626 */:
                        return GET_RECIPIENTS;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_RECIPIENTS_FIELD_NUMBER /* 63627 */:
                        return RESPONSE_GET_RECIPIENTS;
                    case SetRpcStruct$ComposedRpc.ADD_RECIPIENT_FIELD_NUMBER /* 63628 */:
                        return ADD_RECIPIENT;
                    case SetRpcStruct$ComposedRpc.GET_CRYPTO_CHARGE_PAYMENT_TOKEN_FIELD_NUMBER /* 63629 */:
                        return GET_CRYPTO_CHARGE_PAYMENT_TOKEN;
                    case SetRpcStruct$ComposedRpc.FILTER_TAGGED_TRANSACTIONS_FIELD_NUMBER /* 63630 */:
                        return FILTER_TAGGED_TRANSACTIONS;
                    case SetRpcStruct$ComposedRpc.RESPONSE_FILTER_TAGGED_TRANSACTIONS_FIELD_NUMBER /* 63631 */:
                        return RESPONSE_FILTER_TAGGED_TRANSACTIONS;
                    case SetRpcStruct$ComposedRpc.CRYPTO_TRANSFER_FIELD_NUMBER /* 63632 */:
                        return CRYPTO_TRANSFER;
                    case SetRpcStruct$ComposedRpc.RESPONSE_CRYPTO_TRANSFER_FIELD_NUMBER /* 63633 */:
                        return RESPONSE_CRYPTO_TRANSFER;
                    case SetRpcStruct$ComposedRpc.GET_CRYPTO_WALLETS_FIELD_NUMBER /* 63634 */:
                        return GET_CRYPTO_WALLETS;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_CRYPTO_WALLETS_FIELD_NUMBER /* 63635 */:
                        return RESPONSE_GET_CRYPTO_WALLETS;
                    case SetRpcStruct$ComposedRpc.RESPONSE_PAY_SEFTE_FIELD_NUMBER /* 63636 */:
                        return RESPONSE_PAY_SEFTE;
                    case SetRpcStruct$ComposedRpc.GET_ACQUIRED_VOUCHERS_FIELD_NUMBER /* 63637 */:
                        return GET_ACQUIRED_VOUCHERS;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_ACQUIRED_VOUCHERS_FIELD_NUMBER /* 63638 */:
                        return RESPONSE_GET_ACQUIRED_VOUCHERS;
                    case SetRpcStruct$ComposedRpc.PROTO_FIELD_NUMBER /* 63639 */:
                        return PROTO;
                    case SetRpcStruct$ComposedRpc.RESPONSE_PROTO_FIELD_NUMBER /* 63640 */:
                        return RESPONSE_PROTO;
                    case SetRpcStruct$ComposedRpc.ADD_DETAIL_TO_TRANSACTION_FIELD_NUMBER /* 63641 */:
                        return ADD_DETAIL_TO_TRANSACTION;
                    case SetRpcStruct$ComposedRpc.GET_GROUP_MEMBERS_PRESENCE_FIELD_NUMBER /* 63642 */:
                        return GET_GROUP_MEMBERS_PRESENCE;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_GROUP_MEMBERS_PRESENCE_FIELD_NUMBER /* 63643 */:
                        return RESPONSE_GET_GROUP_MEMBERS_PRESENCE;
                    case SetRpcStruct$ComposedRpc.GET_USERS_PRESENCE_FIELD_NUMBER /* 63644 */:
                        return GET_USERS_PRESENCE;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_USERS_PRESENCE_FIELD_NUMBER /* 63645 */:
                        return RESPONSE_GET_USERS_PRESENCE;
                    case SetRpcStruct$ComposedRpc.REMOVE_TRANSACTION_FIELD_NUMBER /* 63646 */:
                        return REMOVE_TRANSACTION;
                    case SetRpcStruct$ComposedRpc.SPLIT_TRANSACTION_FIELD_NUMBER /* 63647 */:
                        return SPLIT_TRANSACTION;
                    case SetRpcStruct$ComposedRpc.RESPONSE_SPLIT_TRANSACTION_FIELD_NUMBER /* 63648 */:
                        return RESPONSE_SPLIT_TRANSACTION;
                    case SetRpcStruct$ComposedRpc.LOAD_TRANSACTIONS_BY_IDS_FIELD_NUMBER /* 63649 */:
                        return LOAD_TRANSACTIONS_BY_IDS;
                    case SetRpcStruct$ComposedRpc.RESPONSE_LOAD_TRANSACTIONS_BY_IDS_FIELD_NUMBER /* 63650 */:
                        return RESPONSE_LOAD_TRANSACTIONS_BY_IDS;
                    case SetRpcStruct$ComposedRpc.EDIT_SEX_FIELD_NUMBER /* 63651 */:
                        return EDIT_SEX;
                    case SetRpcStruct$ComposedRpc.EDIT_BIRTH_DATE_FIELD_NUMBER /* 63652 */:
                        return EDIT_BIRTH_DATE;
                    case SetRpcStruct$ComposedRpc.GET_SUB_TRANSACTIONS_FIELD_NUMBER /* 63653 */:
                        return GET_SUB_TRANSACTIONS;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_SUB_TRANSACTIONS_FIELD_NUMBER /* 63654 */:
                        return RESPONSE_GET_SUB_TRANSACTIONS;
                    case SetRpcStruct$ComposedRpc.REVIVE_TRANSACTION_FIELD_NUMBER /* 63655 */:
                        return REVIVE_TRANSACTION;
                    case SetRpcStruct$ComposedRpc.LOAD_LOAN_HISTORY_FIELD_NUMBER /* 63656 */:
                        return LOAD_LOAN_HISTORY;
                    case SetRpcStruct$ComposedRpc.RESPONSE_LOAD_LOAN_HISTORY_FIELD_NUMBER /* 63657 */:
                        return RESPONSE_LOAD_LOAN_HISTORY;
                    case SetRpcStruct$ComposedRpc.REMOVE_LOAN_FIELD_NUMBER /* 63658 */:
                        return REMOVE_LOAN;
                    case SetRpcStruct$ComposedRpc.LOAD_LAST_STATES_FIELD_NUMBER /* 63659 */:
                        return LOAD_LAST_STATES;
                    case SetRpcStruct$ComposedRpc.RESPONSE_LOAD_LAST_STATES_FIELD_NUMBER /* 63660 */:
                        return RESPONSE_LOAD_LAST_STATES;
                    case SetRpcStruct$ComposedRpc.RESET_CONTACTS_FIELD_NUMBER /* 63661 */:
                        return RESET_CONTACTS;
                    case SetRpcStruct$ComposedRpc.SEND_MULTI_MEDIA_MESSAGE_FIELD_NUMBER /* 63662 */:
                        return SEND_MULTI_MEDIA_MESSAGE;
                    case SetRpcStruct$ComposedRpc.GET_MESSAGES_REPLIES_INFO_FIELD_NUMBER /* 63663 */:
                        return GET_MESSAGES_REPLIES_INFO;
                    case SetRpcStruct$ComposedRpc.RESPONSE_GET_MESSAGES_REPLIES_INFO_FIELD_NUMBER /* 63664 */:
                        return RESPONSE_GET_MESSAGES_REPLIES_INFO;
                    default:
                        switch (i) {
                            case 25:
                                return SEQ_UPDATE_TOO_LONG;
                            case 26:
                                return WEAK_UPDATE;
                            case 27:
                                return TYPING;
                            default:
                                switch (i) {
                                    case 29:
                                        return SET_ONLINE;
                                    case 30:
                                        return STOP_TYPING;
                                    case 31:
                                        return EDIT_AVATAR;
                                    case 32:
                                        return SUBSCRIBE_TO_ONLINE;
                                    case 33:
                                        return SUBSCRIBE_FROM_ONLINE;
                                    default:
                                        switch (i) {
                                            case 69:
                                                return INVITE_USER;
                                            case SetRpcStruct$ComposedRpc.LEAVE_GROUP_FIELD_NUMBER /* 70 */:
                                                return LEAVE_GROUP;
                                            case 71:
                                                return KICK_USER;
                                            case 72:
                                                return RESPONSE_SEQ;
                                            case 73:
                                                return FAT_SEQ_UPDATE;
                                            case 74:
                                                return SUBSCRIBE_TO_GROUP_ONLINE;
                                            case SetRpcStruct$ComposedRpc.SUBSCRIBE_FROM_GROUP_ONLINE_FIELD_NUMBER /* 75 */:
                                                return SUBSCRIBE_FROM_GROUP_ONLINE;
                                            default:
                                                switch (i) {
                                                    case 98:
                                                        return DELETE_MESSAGE;
                                                    case 99:
                                                        return CLEAR_CHAT;
                                                    case 100:
                                                        return DELETE_CHAT;
                                                    case 101:
                                                        return REMOVE_GROUP_AVATAR;
                                                    case 102:
                                                        return RESPONSE_SEQ_DATE;
                                                    case 103:
                                                        return RESPONSE_EDIT_AVATAR;
                                                    case 104:
                                                        return LOAD_DIALOGS;
                                                    case 105:
                                                        return RESPONSE_LOAD_DIALOGS;
                                                    default:
                                                        switch (i) {
                                                            case SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER /* 112 */:
                                                                return SEARCH_CONTACTS;
                                                            case 113:
                                                                return RESPONSE_SEARCH_CONTACTS;
                                                            case 114:
                                                                return ADD_CONTACT;
                                                            case 115:
                                                                return RESPONSE_EDIT_GROUP_AVATAR;
                                                            default:
                                                                switch (i) {
                                                                    case SetRpcStruct$ComposedRpc.LOAD_HISTORY_FIELD_NUMBER /* 118 */:
                                                                        return LOAD_HISTORY;
                                                                    case 119:
                                                                        return RESPONSE_LOAD_HISTORY;
                                                                    case SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER /* 120 */:
                                                                        return EDIT_GROUP_DEFAULT_CARD_NUMBER;
                                                                    default:
                                                                        return null;
                                                                }
                                                        }
                                                }
                                        }
                                }
                        }
                }
            }
            return RESPONSE_AUTH;
        }
    }

    static {
        SetRpcStruct$ComposedRpc setRpcStruct$ComposedRpc = new SetRpcStruct$ComposedRpc();
        DEFAULT_INSTANCE = setRpcStruct$ComposedRpc;
        GeneratedMessageLite.registerDefaultInstance(SetRpcStruct$ComposedRpc.class, setRpcStruct$ComposedRpc);
    }

    private SetRpcStruct$ComposedRpc() {
    }

    private void clearAcceptCall() {
        if (this.traitCase_ == 63579) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearAcceptReferralInvite() {
        if (this.traitCase_ == 63605) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearActivateWallet() {
        if (this.traitCase_ == 62760) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearAddCard() {
        if (this.traitCase_ == 136) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearAddContact() {
        if (this.traitCase_ == 114) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearAddDestinationCards() {
        if (this.traitCase_ == 63588) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearAddDetailToTransaction() {
        if (this.traitCase_ == 63641) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearAddGif() {
        if (this.traitCase_ == 2857) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearAddNewCards() {
        if (this.traitCase_ == 63555) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearAddRecipient() {
        if (this.traitCase_ == 63628) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearAddStickerCollection() {
        if (this.traitCase_ == 244) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearAddTransactionTags() {
        if (this.traitCase_ == 63449) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearAddUserTags() {
        if (this.traitCase_ == 63518) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearAuthorizeUser() {
        if (this.traitCase_ == 63606) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearBindMoneyRequestDetails() {
        if (this.traitCase_ == 62403) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearBindMoneyRequestDetailsList() {
        if (this.traitCase_ == 62410) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearBlockUser() {
        if (this.traitCase_ == 2636) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearBuyCharge() {
        if (this.traitCase_ == 63537) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearBuyFastCharge() {
        if (this.traitCase_ == 62464) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearBuyInternetBundle() {
        if (this.traitCase_ == 63539) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearBuyVoucher() {
        if (this.traitCase_ == 63474) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearBuyWheelChance() {
        if (this.traitCase_ == 63466) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearCashOutFromWallet() {
        if (this.traitCase_ == 62764) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearCashoutKifpool() {
        if (this.traitCase_ == 63407) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearChangeDefaultCardNumber() {
        if (this.traitCase_ == 62129) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearChangePhone() {
        if (this.traitCase_ == 63453) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearChangePointToMoney() {
        if (this.traitCase_ == 63464) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearChangeStatusDialogAdOrder() {
        if (this.traitCase_ == 63570) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearCharge() {
        if (this.traitCase_ == 63415) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearCheckChargePermission() {
        if (this.traitCase_ == 63413) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearCheckNickName() {
        if (this.traitCase_ == 206) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearCheckStatusOfPayment() {
        if (this.traitCase_ == 63619) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearClearChat() {
        if (this.traitCase_ == 99) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearCombinedUpdate() {
        if (this.traitCase_ == 2625) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearCreateGroup() {
        if (this.traitCase_ == 230) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearCreateKifpool() {
        if (this.traitCase_ == 63404) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearCreateSavedBill() {
        if (this.traitCase_ == 63549) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearCryptoTransfer() {
        if (this.traitCase_ == 63632) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearDeleteAccount() {
        if (this.traitCase_ == 43606) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearDeleteChat() {
        if (this.traitCase_ == 100) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearDeleteInternetBundleOrder() {
        if (this.traitCase_ == 63536) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearDeleteMessage() {
        if (this.traitCase_ == 98) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearDeleteOrder() {
        if (this.traitCase_ == 63509) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearDeleteSavedBills() {
        if (this.traitCase_ == 63554) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearDeliverOtp() {
        if (this.traitCase_ == 63493) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearDiscardCall() {
        if (this.traitCase_ == 63580) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearEditAbout() {
        if (this.traitCase_ == 212) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearEditAvatar() {
        if (this.traitCase_ == 31) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearEditBirthDate() {
        if (this.traitCase_ == 63652) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearEditCardExpirationDate() {
        if (this.traitCase_ == 63566) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearEditChannelNick() {
        if (this.traitCase_ == 3396) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearEditGroupAbout() {
        if (this.traitCase_ == 213) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearEditGroupAvatar() {
        if (this.traitCase_ == 86) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearEditGroupDefaultCardNumber() {
        if (this.traitCase_ == 120) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearEditGroupTitle() {
        if (this.traitCase_ == 85) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearEditMyPreferredLanguages() {
        if (this.traitCase_ == 145) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearEditMyTimeZone() {
        if (this.traitCase_ == 144) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearEditName() {
        if (this.traitCase_ == 53) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearEditNickName() {
        if (this.traitCase_ == 205) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearEditParameter() {
        if (this.traitCase_ == 128) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearEditSex() {
        if (this.traitCase_ == 63651) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearEditUserLocalName() {
        if (this.traitCase_ == 96) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearEnrollNewCard() {
        if (this.traitCase_ == 63487) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearFatSeqUpdate() {
        if (this.traitCase_ == 73) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearFetchGroupAdmins() {
        if (this.traitCase_ == 729) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearFilterTaggedTransactions() {
        if (this.traitCase_ == 63630) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetAcquiredVouchers() {
        if (this.traitCase_ == 63637) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetAdProvider() {
        if (this.traitCase_ == 63525) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetAuthSessions() {
        if (this.traitCase_ == 80) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetBaleTicket() {
        if (this.traitCase_ == 63260) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetBamServiceToken() {
        if (this.traitCase_ == 62406) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetBillHistory() {
        if (this.traitCase_ == 63547) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetBotWhiteList() {
        if (this.traitCase_ == 249) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetCanSeeMessages() {
        if (this.traitCase_ == 726) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetCardInfo() {
        if (this.traitCase_ == 63489) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetCardTransferToken() {
        if (this.traitCase_ == 62125) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetCards() {
        if (this.traitCase_ == 63558) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetChannelAds() {
        if (this.traitCase_ == 63264) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetChannelEarnMoneyInfo() {
        if (this.traitCase_ == 63447) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetChannelEarnMoneyStatus() {
        if (this.traitCase_ == 63436) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetChargeAmounts() {
        if (this.traitCase_ == 63510) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetChargePaymentToken() {
        if (this.traitCase_ == 63417) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetChargeTopupPaymentToken() {
        if (this.traitCase_ == 63484) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetChargeVoucherPaymentToken() {
        if (this.traitCase_ == 63485) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetCitiesOfState() {
        if (this.traitCase_ == 63617) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetContacts() {
        if (this.traitCase_ == 87) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetCryptoChargePaymentToken() {
        if (this.traitCase_ == 63629) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetCryptoWallets() {
        if (this.traitCase_ == 63634) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetDefaultCard() {
        if (this.traitCase_ == 63563) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetDestinationCardInfo() {
        if (this.traitCase_ == 63491) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetDestinationCards() {
        if (this.traitCase_ == 63586) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetDialogAdOrderDetails() {
        if (this.traitCase_ == 63568) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetDialogAdOrderPaymentToken() {
        if (this.traitCase_ == 63571) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetGiftPacketPaymentToken() {
        if (this.traitCase_ == 63232) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetGroupDefaultCardNumber() {
        if (this.traitCase_ == 129) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetGroupDifference() {
        if (this.traitCase_ == 187) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetGroupInviteUrl() {
        if (this.traitCase_ == 177) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetGroupMembersCount() {
        if (this.traitCase_ == 63499) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetGroupMembersPresence() {
        if (this.traitCase_ == 63642) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetGroupState() {
        if (this.traitCase_ == 153) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetInternetBundleList() {
        if (this.traitCase_ == 63532) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetInternetBundlePaymentToken() {
        if (this.traitCase_ == 63530) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetJwtToken() {
        if (this.traitCase_ == 600) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetKifpoolOwner() {
        if (this.traitCase_ == 63420) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetLinkPreview() {
        if (this.traitCase_ == 63497) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetLoanInfo() {
        if (this.traitCase_ == 63582) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetLoansList() {
        if (this.traitCase_ == 63584) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetMemberPermissions() {
        if (this.traitCase_ == 63456) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetMessagesRepliesInfo() {
        if (this.traitCase_ == 63663) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetMoneyRequestDetails() {
        if (this.traitCase_ == 62393) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetMoneyRequestPaymentList() {
        if (this.traitCase_ == 62401) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetMoneyRequestPaymentTokenByCard() {
        if (this.traitCase_ == 62769) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetMyBank() {
        if (this.traitCase_ == 63243) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetMyGroups() {
        if (this.traitCase_ == 43746) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetMyKifpools() {
        if (this.traitCase_ == 63400) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetMySentence() {
        if (this.traitCase_ == 63573) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetMyWallets() {
        if (this.traitCase_ == 62730) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetNasimFilePublicUrl() {
        if (this.traitCase_ == 3072) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetNasimFileUploadResume() {
        if (this.traitCase_ == 3071) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetNasimFileUploadUrl() {
        if (this.traitCase_ == 143) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetNasimFileUrl() {
        if (this.traitCase_ == 2815) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetNasimFileUrls() {
        if (this.traitCase_ == 2591) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetOtpTokenV2() {
        if (this.traitCase_ == 63258) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetOtptoken() {
        if (this.traitCase_ == 62761) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetPacket() {
        if (this.traitCase_ == 63604) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetPacketsStatus() {
        if (this.traitCase_ == 63597) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetParameters() {
        if (this.traitCase_ == 134) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetParticipants() {
        if (this.traitCase_ == 63512) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetPayMoneyRequestToken() {
        if (this.traitCase_ == 62127) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetPaymentToken() {
        if (this.traitCase_ == 62408) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetPaymentTokenByCard() {
        if (this.traitCase_ == 62747) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetPayvandCard() {
        if (this.traitCase_ == 62132) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetPayvandCardList() {
        if (this.traitCase_ == 62130) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetPointBalance() {
        if (this.traitCase_ == 63434) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetPointDetails() {
        if (this.traitCase_ == 63458) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetPointSummery() {
        if (this.traitCase_ == 63451) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetPsproxyPaymentToken() {
        if (this.traitCase_ == 53258) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetPsproxyToken() {
        if (this.traitCase_ == 53256) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetReactions() {
        if (this.traitCase_ == 63254) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetRecentCharges() {
        if (this.traitCase_ == 62412) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetRecentInternetBundleOrders() {
        if (this.traitCase_ == 63534) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetRecentOrders() {
        if (this.traitCase_ == 63507) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetRecipients() {
        if (this.traitCase_ == 63626) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetReferencedEntitites() {
        if (this.traitCase_ == 2628) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetReferralCode() {
        if (this.traitCase_ == 63500) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetReferralContacts() {
        if (this.traitCase_ == 63601) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetReferredCount() {
        if (this.traitCase_ == 63477) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetReferringUser() {
        if (this.traitCase_ == 63460) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetRemainToken() {
        if (this.traitCase_ == 58106) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetSadadPsppaymentToken() {
        if (this.traitCase_ == 62180) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetSavedBills() {
        if (this.traitCase_ == 63551) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetScoreBoard() {
        if (this.traitCase_ == 63593) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetState() {
        if (this.traitCase_ == 9) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetStates() {
        if (this.traitCase_ == 63615) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetSubTransactions() {
        if (this.traitCase_ == 63653) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetTotalPaidAmount() {
        if (this.traitCase_ == 63527) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetTransactionTags() {
        if (this.traitCase_ == 63516) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetUserAccounts() {
        if (this.traitCase_ == 63443) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetUserBank() {
        if (this.traitCase_ == 63522) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetUserContext() {
        if (this.traitCase_ == 137) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetUserRefers() {
        if (this.traitCase_ == 63599) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetUserScore() {
        if (this.traitCase_ == 63595) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetUserSeftes() {
        if (this.traitCase_ == 63620) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetUserStatus() {
        if (this.traitCase_ == 63441) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetUserTags() {
        if (this.traitCase_ == 63520) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetUserVitrine() {
        if (this.traitCase_ == 63256) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetUsersDefaultCardNumber() {
        if (this.traitCase_ == 63541) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetUsersPresence() {
        if (this.traitCase_ == 63644) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetVouchers() {
        if (this.traitCase_ == 63472) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetWalletChargeToken() {
        if (this.traitCase_ == 62733) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetWalletContracts() {
        if (this.traitCase_ == 62758) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetWalletInvoice() {
        if (this.traitCase_ == 62752) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetWebviewTrackingNumber() {
        if (this.traitCase_ == 63481) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGetWheel() {
        if (this.traitCase_ == 63468) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGrantBankiAccess() {
        if (this.traitCase_ == 62397) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearImportContacts() {
        if (this.traitCase_ == 7) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearInitP12() {
        if (this.traitCase_ == 63608) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearInitSefte() {
        if (this.traitCase_ == 63610) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearInquiryBill() {
        if (this.traitCase_ == 63543) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearInviteUser() {
        if (this.traitCase_ == 69) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearInvoiceKifpool() {
        if (this.traitCase_ == 63409) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearJoinGroup() {
        if (this.traitCase_ == 180) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearJoinPublicGroup() {
        if (this.traitCase_ == 2881) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearKickUser() {
        if (this.traitCase_ == 71) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearLeaveGroup() {
        if (this.traitCase_ == 70) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearLoadArchived() {
        if (this.traitCase_ == 2651) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearLoadAvatars() {
        if (this.traitCase_ == 2656) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearLoadBlockedUsers() {
        if (this.traitCase_ == 2638) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearLoadDialogs() {
        if (this.traitCase_ == 104) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearLoadFullGroups() {
        if (this.traitCase_ == 2782) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearLoadFullUsers() {
        if (this.traitCase_ == 2649) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearLoadGroupAvatars() {
        if (this.traitCase_ == 43748) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearLoadGroupedDialogs() {
        if (this.traitCase_ == 225) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearLoadGroups() {
        if (this.traitCase_ == 63245) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearLoadHistory() {
        if (this.traitCase_ == 118) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearLoadLastStates() {
        if (this.traitCase_ == 63659) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearLoadLoanHistory() {
        if (this.traitCase_ == 63656) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearLoadMembers() {
        if (this.traitCase_ == 2786) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearLoadOwnStickers() {
        if (this.traitCase_ == 238) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearLoadPeerDialogs() {
        if (this.traitCase_ == 63249) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearLoadReactions() {
        if (this.traitCase_ == 63239) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearLoadStickerCollection() {
        if (this.traitCase_ == 246) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearLoadTransactions() {
        if (this.traitCase_ == 63445) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearLoadTransactionsByIds() {
        if (this.traitCase_ == 63649) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearLoadUsers() {
        if (this.traitCase_ == 63247) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearMakeUserAdmin() {
        if (this.traitCase_ == 2784) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearMessageRead() {
        if (this.traitCase_ == 57) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearMessageReceived() {
        if (this.traitCase_ == 55) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearMessageRemoveReaction() {
        if (this.traitCase_ == 220) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearMessageSetReaction() {
        if (this.traitCase_ == 210) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearNewFatSeqUpdate() {
        if (this.traitCase_ == 1168) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearNewSeqUpdate() {
        if (this.traitCase_ == 45) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearNotifyAboutDeviceInfo() {
        if (this.traitCase_ == 229) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearOpenGiftPacket() {
        if (this.traitCase_ == 63236) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearPayBill() {
        if (this.traitCase_ == 63545) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearPayByWallet() {
        if (this.traitCase_ == 62746) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearPayMoneyRequestByWallet() {
        if (this.traitCase_ == 62751) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearPaySefte() {
        if (this.traitCase_ == 63614) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearPinMessage() {
        if (this.traitCase_ == 470) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearProto() {
        if (this.traitCase_ == 63639) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearPurchaseMessage() {
        if (this.traitCase_ == 63418) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearPurchaseMessageWithCharge() {
        if (this.traitCase_ == 63428) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearReactivateApp() {
        if (this.traitCase_ == 63591) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearRefer() {
        if (this.traitCase_ == 63502) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearRegisterForEarnMoney() {
        if (this.traitCase_ == 63438) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearRegisterGooglePush() {
        if (this.traitCase_ == 51) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearRemoveAvatar() {
        if (this.traitCase_ == 91) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearRemoveCard() {
        if (this.traitCase_ == 63557) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearRemoveContact() {
        if (this.traitCase_ == 89) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearRemoveDefaultCard() {
        if (this.traitCase_ == 63565) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearRemoveDefaultCardNumber() {
        if (this.traitCase_ == 62177) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearRemoveDestinationCards() {
        if (this.traitCase_ == 63590) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearRemoveGif() {
        if (this.traitCase_ == 2859) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearRemoveGroupAvatar() {
        if (this.traitCase_ == 101) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearRemoveLoan() {
        if (this.traitCase_ == 63658) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearRemovePin() {
        if (this.traitCase_ == 471) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearRemoveStickerCollection() {
        if (this.traitCase_ == 245) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearRemoveTransaction() {
        if (this.traitCase_ == 63646) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearRemoveTransactionTags() {
        if (this.traitCase_ == 63450) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearRemoveUserAdmin() {
        if (this.traitCase_ == 44576) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearRemoveUserTags() {
        if (this.traitCase_ == 63519) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearRenameSavedBill() {
        if (this.traitCase_ == 63553) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResetContacts() {
        if (this.traitCase_ == 63661) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseAddDestinationCards() {
        if (this.traitCase_ == 63589) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseAddNewCards() {
        if (this.traitCase_ == 63556) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseAuth() {
        if (this.traitCase_ == 5) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseAuthorizeUser() {
        if (this.traitCase_ == 63607) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseBool() {
        if (this.traitCase_ == 209) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseBuyCharge() {
        if (this.traitCase_ == 63538) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseBuyFastCharge() {
        if (this.traitCase_ == 62465) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseBuyInternetBundle() {
        if (this.traitCase_ == 63540) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseBuyVoucher() {
        if (this.traitCase_ == 63475) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseBuyWheelChance() {
        if (this.traitCase_ == 63467) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseCall() {
        if (this.traitCase_ == 63581) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseCanSeeMessages() {
        if (this.traitCase_ == 725) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseCashoutKifpool() {
        if (this.traitCase_ == 63408) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseChangePointToMoney() {
        if (this.traitCase_ == 63465) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseCharge() {
        if (this.traitCase_ == 63416) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseCheckChargePermission() {
        if (this.traitCase_ == 63414) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseCreateGroup() {
        if (this.traitCase_ == 216) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseCreateKifpool() {
        if (this.traitCase_ == 63405) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseCreateSavedBill() {
        if (this.traitCase_ == 63550) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseCryptoTransfer() {
        if (this.traitCase_ == 63633) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseDialogsOrder() {
        if (this.traitCase_ == 235) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseEditAvatar() {
        if (this.traitCase_ == 103) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseEditGroupAvatar() {
        if (this.traitCase_ == 115) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseEnrollNewCard() {
        if (this.traitCase_ == 63488) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseFetchGroupAdmins() {
        if (this.traitCase_ == 730) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseFilterTaggedTransactions() {
        if (this.traitCase_ == 63631) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetAcquiredVouchers() {
        if (this.traitCase_ == 63638) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetAdProvider() {
        if (this.traitCase_ == 63526) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetAuthSessions() {
        if (this.traitCase_ == 81) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetBamServiceToken() {
        if (this.traitCase_ == 62407) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetBillHistory() {
        if (this.traitCase_ == 63548) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetBotWhiteList() {
        if (this.traitCase_ == 3856) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetCardInfo() {
        if (this.traitCase_ == 63490) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetCardTransferToken() {
        if (this.traitCase_ == 62126) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetCards() {
        if (this.traitCase_ == 63559) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetChannelAds() {
        if (this.traitCase_ == 63265) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetChannelEarnMoneyInfo() {
        if (this.traitCase_ == 63448) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetChannelEarnMoneyStatus() {
        if (this.traitCase_ == 63437) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetChargeAmounts() {
        if (this.traitCase_ == 63511) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetChargePaymentToken() {
        if (this.traitCase_ == 63406) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetCitiesOfState() {
        if (this.traitCase_ == 63618) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetContacts() {
        if (this.traitCase_ == 88) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetCryptoWallets() {
        if (this.traitCase_ == 63635) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetDefaultCard() {
        if (this.traitCase_ == 63564) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetDestinationCardInfo() {
        if (this.traitCase_ == 63492) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetDestinationCards() {
        if (this.traitCase_ == 63587) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetDialogAdOrderDetails() {
        if (this.traitCase_ == 63569) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetDialogAdOrderPaymentToken() {
        if (this.traitCase_ == 63572) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetGiftPacketPaymentToken() {
        if (this.traitCase_ == 63231) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetGroupDefaultCardNumber() {
        if (this.traitCase_ == 130) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetGroupDifference() {
        if (this.traitCase_ == 204) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetGroupMembersCount() {
        if (this.traitCase_ == 63504) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetGroupMembersPresence() {
        if (this.traitCase_ == 63643) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetGroupState() {
        if (this.traitCase_ == 23) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetInternetBundleList() {
        if (this.traitCase_ == 63533) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetInternetBundlePaymentToken() {
        if (this.traitCase_ == 63531) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetJwtToken() {
        if (this.traitCase_ == 601) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetKifpoolOwner() {
        if (this.traitCase_ == 63421) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetLinkPreview() {
        if (this.traitCase_ == 63498) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetLoanInfo() {
        if (this.traitCase_ == 63583) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetLoansList() {
        if (this.traitCase_ == 63585) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetMemberPermissions() {
        if (this.traitCase_ == 63457) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetMessagesRepliesInfo() {
        if (this.traitCase_ == 63664) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetMoneyRequestDetails() {
        if (this.traitCase_ == 62400) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetMoneyRequestPaymentList() {
        if (this.traitCase_ == 62402) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetMoneyRequestPaymentTokenByCard() {
        if (this.traitCase_ == 62770) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetMyBank() {
        if (this.traitCase_ == 63244) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetMyGroups() {
        if (this.traitCase_ == 43747) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetMyKifpools() {
        if (this.traitCase_ == 63401) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetMySentence() {
        if (this.traitCase_ == 63574) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetMyWallets() {
        if (this.traitCase_ == 62731) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetNasimFilePublicUrl() {
        if (this.traitCase_ == 3056) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetNasimFileUploadResume() {
        if (this.traitCase_ == 3055) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetNasimFileUploadUrl() {
        if (this.traitCase_ == 157) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetNasimFileUrl() {
        if (this.traitCase_ == 2799) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetNasimFileUrls() {
        if (this.traitCase_ == 2607) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetOtpTokenV2() {
        if (this.traitCase_ == 63259) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetOtptoken() {
        if (this.traitCase_ == 62768) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetPacketsStatus() {
        if (this.traitCase_ == 63598) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetParameters() {
        if (this.traitCase_ == 135) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetParticipants() {
        if (this.traitCase_ == 63513) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetPayMoneyRequestToken() {
        if (this.traitCase_ == 62128) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetPaymentToken() {
        if (this.traitCase_ == 62409) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetPaymentTokenByCard() {
        if (this.traitCase_ == 62748) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetPayvandCard() {
        if (this.traitCase_ == 62133) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetPayvandCardList() {
        if (this.traitCase_ == 62131) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetPointBalance() {
        if (this.traitCase_ == 63435) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetPointDetails() {
        if (this.traitCase_ == 63459) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetPointSummery() {
        if (this.traitCase_ == 63452) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetPspPaymentToken() {
        if (this.traitCase_ == 63486) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetPsproxyPaymentToken() {
        if (this.traitCase_ == 53259) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetPsproxyToken() {
        if (this.traitCase_ == 53257) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetReactions() {
        if (this.traitCase_ == 63255) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetRecentCharges() {
        if (this.traitCase_ == 62414) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetRecentInternetBundleOrders() {
        if (this.traitCase_ == 63535) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetRecentOrders() {
        if (this.traitCase_ == 63508) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetRecipients() {
        if (this.traitCase_ == 63627) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetReferencedEntitites() {
        if (this.traitCase_ == 2629) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetReferralCode() {
        if (this.traitCase_ == 63501) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetReferralContacts() {
        if (this.traitCase_ == 63602) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetReferredCount() {
        if (this.traitCase_ == 63478) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetReferringUser() {
        if (this.traitCase_ == 63461) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetRemainToken() {
        if (this.traitCase_ == 62138) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetSadadPsppaymentToken() {
        if (this.traitCase_ == 62181) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetSavedBills() {
        if (this.traitCase_ == 63552) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetScoreBoard() {
        if (this.traitCase_ == 63594) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetStates() {
        if (this.traitCase_ == 63616) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetSubTransactions() {
        if (this.traitCase_ == 63654) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetTicket() {
        if (this.traitCase_ == 63261) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetTotalPaidAmount() {
        if (this.traitCase_ == 63528) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetTransactionTags() {
        if (this.traitCase_ == 63517) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetUserAccounts() {
        if (this.traitCase_ == 63444) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetUserBank() {
        if (this.traitCase_ == 63524) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetUserContext() {
        if (this.traitCase_ == 146) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetUserRefers() {
        if (this.traitCase_ == 63600) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetUserScore() {
        if (this.traitCase_ == 63596) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetUserSeftes() {
        if (this.traitCase_ == 63621) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetUserStatus() {
        if (this.traitCase_ == 63442) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetUserTags() {
        if (this.traitCase_ == 63521) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetUserVitrine() {
        if (this.traitCase_ == 63257) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetUsersDefaultCardNumber() {
        if (this.traitCase_ == 63542) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetUsersPresence() {
        if (this.traitCase_ == 63645) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetVouchers() {
        if (this.traitCase_ == 63473) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetWalletChargeToken() {
        if (this.traitCase_ == 62734) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetWalletContracts() {
        if (this.traitCase_ == 62759) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetWalletInvoice() {
        if (this.traitCase_ == 62729) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetWebviewTrackingNumber() {
        if (this.traitCase_ == 63482) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseGetWheel() {
        if (this.traitCase_ == 63469) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseImportContacts() {
        if (this.traitCase_ == 8) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseInitP12() {
        if (this.traitCase_ == 63609) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseInitSefte() {
        if (this.traitCase_ == 63611) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseInquiryBill() {
        if (this.traitCase_ == 63544) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseInviteUrl() {
        if (this.traitCase_ == 178) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseInvoiceKifpool() {
        if (this.traitCase_ == 63410) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseJoinGroup() {
        if (this.traitCase_ == 181) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseJoinPublicGroup() {
        if (this.traitCase_ == 2897) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseLoadArchived() {
        if (this.traitCase_ == 2652) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseLoadAvatars() {
        if (this.traitCase_ == 2812) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseLoadBlockedUsers() {
        if (this.traitCase_ == 2639) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseLoadDialogs() {
        if (this.traitCase_ == 105) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseLoadFullGroups() {
        if (this.traitCase_ == 2783) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseLoadFullUsers() {
        if (this.traitCase_ == 2650) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseLoadGroupAvatars() {
        if (this.traitCase_ == 43749) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseLoadGroupedDialogs() {
        if (this.traitCase_ == 226) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseLoadGroups() {
        if (this.traitCase_ == 63246) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseLoadHistory() {
        if (this.traitCase_ == 119) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseLoadLastStates() {
        if (this.traitCase_ == 63660) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseLoadLoanHistory() {
        if (this.traitCase_ == 63657) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseLoadMembers() {
        if (this.traitCase_ == 2787) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseLoadOwnStickers() {
        if (this.traitCase_ == 239) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseLoadPeerDialogs() {
        if (this.traitCase_ == 63250) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseLoadReactions() {
        if (this.traitCase_ == 63240) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseLoadStickerCollection() {
        if (this.traitCase_ == 247) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseLoadTransactions() {
        if (this.traitCase_ == 63446) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseLoadTransactionsByIds() {
        if (this.traitCase_ == 63650) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseLoadUsers() {
        if (this.traitCase_ == 63248) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseOpenGiftPacket() {
        if (this.traitCase_ == 63237) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponsePayBill() {
        if (this.traitCase_ == 63546) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponsePaySefte() {
        if (this.traitCase_ == 63636) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseProto() {
        if (this.traitCase_ == 63640) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponsePurchaseMessage() {
        if (this.traitCase_ == 63419) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponsePurchaseMessageWithCharge() {
        if (this.traitCase_ == 63429) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseReactionsResponse() {
        if (this.traitCase_ == 219) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseReactivateApp() {
        if (this.traitCase_ == 63592) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseRefer() {
        if (this.traitCase_ == 63503) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseSearchContacts() {
        if (this.traitCase_ == 113) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseSearchMedia() {
        if (this.traitCase_ == 63263) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseSearchMessages() {
        if (this.traitCase_ == 218) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseSearchPeer() {
        if (this.traitCase_ == 234) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseSendChangePhoneVerificationCode() {
        if (this.traitCase_ == 63505) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseSendDeleteAccountVerificationCode() {
        if (this.traitCase_ == 3089) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseSeq() {
        if (this.traitCase_ == 72) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseSeqDate() {
        if (this.traitCase_ == 102) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseSignSefte() {
        if (this.traitCase_ == 63613) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseSpinWheel() {
        if (this.traitCase_ == 63471) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseSplitTransaction() {
        if (this.traitCase_ == 63648) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseStartPhoneAuth() {
        if (this.traitCase_ == 193) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseStickersReponse() {
        if (this.traitCase_ == 240) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseTransactionPoint() {
        if (this.traitCase_ == 63463) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseTransferMoney() {
        if (this.traitCase_ == 63412) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseUpdateClick() {
        if (this.traitCase_ == 63623) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseUpdateView() {
        if (this.traitCase_ == 63561) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseUpgradeKifpool() {
        if (this.traitCase_ == 63403) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseUserHasCred() {
        if (this.traitCase_ == 63625) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseValidateMySentence() {
        if (this.traitCase_ == 63576) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseVerifyCashOut() {
        if (this.traitCase_ == 62763) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseVerifyCashOutKifpool() {
        if (this.traitCase_ == 63433) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseVerifyPeer() {
        if (this.traitCase_ == 62757) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseVerifyPurchaseMessage() {
        if (this.traitCase_ == 63431) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseVerifyQrcode() {
        if (this.traitCase_ == 62750) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearResponseVoid() {
        if (this.traitCase_ == 50) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearReviveTransaction() {
        if (this.traitCase_ == 63655) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearRevokeInviteUrl() {
        if (this.traitCase_ == 179) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearSearchContacts() {
        if (this.traitCase_ == 112) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearSearchMedia() {
        if (this.traitCase_ == 63262) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearSearchMessages() {
        if (this.traitCase_ == 217) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearSearchMessagesMore() {
        if (this.traitCase_ == 222) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearSearchPeer() {
        if (this.traitCase_ == 233) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearSendChangePhoneVerificationCode() {
        if (this.traitCase_ == 63454) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearSendDeleteAccountVerificationCode() {
        if (this.traitCase_ == 43609) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearSendFeedBack() {
        if (this.traitCase_ == 63529) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearSendGiftPacketWithWallet() {
        if (this.traitCase_ == 63233) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearSendInlineCallbackData() {
        if (this.traitCase_ == 3937) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearSendMessage() {
        if (this.traitCase_ == 92) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearSendMultiMediaMessage() {
        if (this.traitCase_ == 63662) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearSendMyGiftPacket() {
        if (this.traitCase_ == 63577) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearSendReferral() {
        if (this.traitCase_ == 63603) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearSendSerajEvent() {
        if (this.traitCase_ == 63238) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearSeqUpdate() {
        if (this.traitCase_ == 13) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearSeqUpdateTooLong() {
        if (this.traitCase_ == 25) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearSetCanSeeMessages() {
        if (this.traitCase_ == 724) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearSetDefaultCard() {
        if (this.traitCase_ == 63562) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearSetGroupDefaultPermissions() {
        if (this.traitCase_ == 63476) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearSetMemberPermissions() {
        if (this.traitCase_ == 63455) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearSetOnline() {
        if (this.traitCase_ == 29) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearSetRecentOrder() {
        if (this.traitCase_ == 63506) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearSetRestriction() {
        if (this.traitCase_ == 728) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearSignOut() {
        if (this.traitCase_ == 84) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearSignSefte() {
        if (this.traitCase_ == 63612) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearSignUp() {
        if (this.traitCase_ == 190) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearSpinWheel() {
        if (this.traitCase_ == 63470) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearSplitTransaction() {
        if (this.traitCase_ == 63647) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearStartCall() {
        if (this.traitCase_ == 63578) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearStartPhoneAuth() {
        if (this.traitCase_ == 191) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearStopTyping() {
        if (this.traitCase_ == 30) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearSubmitDialogAdOrder() {
        if (this.traitCase_ == 63567) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearSubscribeFromGroupOnline() {
        if (this.traitCase_ == 75) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearSubscribeFromOnline() {
        if (this.traitCase_ == 33) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearSubscribeToGroupOnline() {
        if (this.traitCase_ == 74) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearSubscribeToOnline() {
        if (this.traitCase_ == 32) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearTerminateAllSessions() {
        if (this.traitCase_ == 83) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearTerminateSession() {
        if (this.traitCase_ == 82) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearTrait() {
        this.traitCase_ = 0;
        this.trait_ = null;
    }

    private void clearTransactionPoint() {
        if (this.traitCase_ == 63462) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearTransferMoney() {
        if (this.traitCase_ == 63411) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearTransferMoneyByCard() {
        if (this.traitCase_ == 63495) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearTransferOwnership() {
        if (this.traitCase_ == 2789) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearTyping() {
        if (this.traitCase_ == 27) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearUnbindAllMoneyRequestDetails() {
        if (this.traitCase_ == 62411) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearUnblockUser() {
        if (this.traitCase_ == 2637) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearUnregisterAllPushCredentials() {
        if (this.traitCase_ == 63251) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearUnregisterGooglePush() {
        if (this.traitCase_ == 2631) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearUpdateClick() {
        if (this.traitCase_ == 63622) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearUpdateGroupStatus() {
        if (this.traitCase_ == 63439) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearUpdateMessage() {
        if (this.traitCase_ == 2658) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearUpdateView() {
        if (this.traitCase_ == 63560) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearUpgradeKifpool() {
        if (this.traitCase_ == 63402) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearUserHasCred() {
        if (this.traitCase_ == 63624) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearValidateCode() {
        if (this.traitCase_ == 189) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearValidateMySentence() {
        if (this.traitCase_ == 63575) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearVerifyCashOut() {
        if (this.traitCase_ == 62762) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearVerifyCashOutKifpool() {
        if (this.traitCase_ == 63432) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearVerifyPeer() {
        if (this.traitCase_ == 62756) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearVerifyPurchaseMessage() {
        if (this.traitCase_ == 63430) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearVerifyQrcode() {
        if (this.traitCase_ == 62749) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearWeakFatUpdate() {
        if (this.traitCase_ == 2673) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearWeakUpdate() {
        if (this.traitCase_ == 26) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    public static SetRpcStruct$ComposedRpc getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAcceptCall(MeetOuterClass$RequestAcceptCall meetOuterClass$RequestAcceptCall) {
        meetOuterClass$RequestAcceptCall.getClass();
        if (this.traitCase_ != 63579 || this.trait_ == MeetOuterClass$RequestAcceptCall.getDefaultInstance()) {
            this.trait_ = meetOuterClass$RequestAcceptCall;
        } else {
            this.trait_ = ((MeetOuterClass$RequestAcceptCall.a) MeetOuterClass$RequestAcceptCall.newBuilder((MeetOuterClass$RequestAcceptCall) this.trait_).v(meetOuterClass$RequestAcceptCall)).j();
        }
        this.traitCase_ = ACCEPT_CALL_FIELD_NUMBER;
    }

    private void mergeAcceptReferralInvite(WarriorOuterClass$RequestAcceptReferralInvite warriorOuterClass$RequestAcceptReferralInvite) {
        warriorOuterClass$RequestAcceptReferralInvite.getClass();
        if (this.traitCase_ != 63605 || this.trait_ == WarriorOuterClass$RequestAcceptReferralInvite.getDefaultInstance()) {
            this.trait_ = warriorOuterClass$RequestAcceptReferralInvite;
        } else {
            this.trait_ = ((WarriorOuterClass$RequestAcceptReferralInvite.a) WarriorOuterClass$RequestAcceptReferralInvite.newBuilder((WarriorOuterClass$RequestAcceptReferralInvite) this.trait_).v(warriorOuterClass$RequestAcceptReferralInvite)).j();
        }
        this.traitCase_ = ACCEPT_REFERRAL_INVITE_FIELD_NUMBER;
    }

    private void mergeActivateWallet(WalletOuterClass$RequestActivateWallet walletOuterClass$RequestActivateWallet) {
        walletOuterClass$RequestActivateWallet.getClass();
        if (this.traitCase_ != 62760 || this.trait_ == WalletOuterClass$RequestActivateWallet.getDefaultInstance()) {
            this.trait_ = walletOuterClass$RequestActivateWallet;
        } else {
            this.trait_ = ((WalletOuterClass$RequestActivateWallet.a) WalletOuterClass$RequestActivateWallet.newBuilder((WalletOuterClass$RequestActivateWallet) this.trait_).v(walletOuterClass$RequestActivateWallet)).j();
        }
        this.traitCase_ = ACTIVATE_WALLET_FIELD_NUMBER;
    }

    private void mergeAddCard(UsersOuterClass$RequestAddCard usersOuterClass$RequestAddCard) {
        usersOuterClass$RequestAddCard.getClass();
        if (this.traitCase_ != 136 || this.trait_ == UsersOuterClass$RequestAddCard.getDefaultInstance()) {
            this.trait_ = usersOuterClass$RequestAddCard;
        } else {
            this.trait_ = ((UsersOuterClass$RequestAddCard.a) UsersOuterClass$RequestAddCard.newBuilder((UsersOuterClass$RequestAddCard) this.trait_).v(usersOuterClass$RequestAddCard)).j();
        }
        this.traitCase_ = 136;
    }

    private void mergeAddContact(UsersOuterClass$RequestAddContact usersOuterClass$RequestAddContact) {
        usersOuterClass$RequestAddContact.getClass();
        if (this.traitCase_ != 114 || this.trait_ == UsersOuterClass$RequestAddContact.getDefaultInstance()) {
            this.trait_ = usersOuterClass$RequestAddContact;
        } else {
            this.trait_ = ((UsersOuterClass$RequestAddContact.a) UsersOuterClass$RequestAddContact.newBuilder((UsersOuterClass$RequestAddContact) this.trait_).v(usersOuterClass$RequestAddContact)).j();
        }
        this.traitCase_ = 114;
    }

    private void mergeAddDestinationCards(SapOuterClass$RequestAddDestinationCards sapOuterClass$RequestAddDestinationCards) {
        sapOuterClass$RequestAddDestinationCards.getClass();
        if (this.traitCase_ != 63588 || this.trait_ == SapOuterClass$RequestAddDestinationCards.getDefaultInstance()) {
            this.trait_ = sapOuterClass$RequestAddDestinationCards;
        } else {
            this.trait_ = ((SapOuterClass$RequestAddDestinationCards.a) SapOuterClass$RequestAddDestinationCards.newBuilder((SapOuterClass$RequestAddDestinationCards) this.trait_).v(sapOuterClass$RequestAddDestinationCards)).j();
        }
        this.traitCase_ = ADD_DESTINATION_CARDS_FIELD_NUMBER;
    }

    private void mergeAddDetailToTransaction(PfmOuterClass$RequestAddDetailToTransaction pfmOuterClass$RequestAddDetailToTransaction) {
        pfmOuterClass$RequestAddDetailToTransaction.getClass();
        if (this.traitCase_ != 63641 || this.trait_ == PfmOuterClass$RequestAddDetailToTransaction.getDefaultInstance()) {
            this.trait_ = pfmOuterClass$RequestAddDetailToTransaction;
        } else {
            this.trait_ = ((PfmOuterClass$RequestAddDetailToTransaction.a) PfmOuterClass$RequestAddDetailToTransaction.newBuilder((PfmOuterClass$RequestAddDetailToTransaction) this.trait_).v(pfmOuterClass$RequestAddDetailToTransaction)).j();
        }
        this.traitCase_ = ADD_DETAIL_TO_TRANSACTION_FIELD_NUMBER;
    }

    private void mergeAddGif(ImagesOuterClass$RequestAddGif imagesOuterClass$RequestAddGif) {
        imagesOuterClass$RequestAddGif.getClass();
        if (this.traitCase_ != 2857 || this.trait_ == ImagesOuterClass$RequestAddGif.getDefaultInstance()) {
            this.trait_ = imagesOuterClass$RequestAddGif;
        } else {
            this.trait_ = ((ImagesOuterClass$RequestAddGif.a) ImagesOuterClass$RequestAddGif.newBuilder((ImagesOuterClass$RequestAddGif) this.trait_).v(imagesOuterClass$RequestAddGif)).j();
        }
        this.traitCase_ = ADD_GIF_FIELD_NUMBER;
    }

    private void mergeAddNewCards(SapOuterClass$RequestAddNewCards sapOuterClass$RequestAddNewCards) {
        sapOuterClass$RequestAddNewCards.getClass();
        if (this.traitCase_ != 63555 || this.trait_ == SapOuterClass$RequestAddNewCards.getDefaultInstance()) {
            this.trait_ = sapOuterClass$RequestAddNewCards;
        } else {
            this.trait_ = ((SapOuterClass$RequestAddNewCards.a) SapOuterClass$RequestAddNewCards.newBuilder((SapOuterClass$RequestAddNewCards) this.trait_).v(sapOuterClass$RequestAddNewCards)).j();
        }
        this.traitCase_ = ADD_NEW_CARDS_FIELD_NUMBER;
    }

    private void mergeAddRecipient(SefteOuterClass$RequestAddRecipient sefteOuterClass$RequestAddRecipient) {
        sefteOuterClass$RequestAddRecipient.getClass();
        if (this.traitCase_ != 63628 || this.trait_ == SefteOuterClass$RequestAddRecipient.getDefaultInstance()) {
            this.trait_ = sefteOuterClass$RequestAddRecipient;
        } else {
            this.trait_ = ((SefteOuterClass$RequestAddRecipient.a) SefteOuterClass$RequestAddRecipient.newBuilder((SefteOuterClass$RequestAddRecipient) this.trait_).v(sefteOuterClass$RequestAddRecipient)).j();
        }
        this.traitCase_ = ADD_RECIPIENT_FIELD_NUMBER;
    }

    private void mergeAddStickerCollection(ImagesOuterClass$RequestAddStickerCollection imagesOuterClass$RequestAddStickerCollection) {
        imagesOuterClass$RequestAddStickerCollection.getClass();
        if (this.traitCase_ != 244 || this.trait_ == ImagesOuterClass$RequestAddStickerCollection.getDefaultInstance()) {
            this.trait_ = imagesOuterClass$RequestAddStickerCollection;
        } else {
            this.trait_ = ((ImagesOuterClass$RequestAddStickerCollection.a) ImagesOuterClass$RequestAddStickerCollection.newBuilder((ImagesOuterClass$RequestAddStickerCollection) this.trait_).v(imagesOuterClass$RequestAddStickerCollection)).j();
        }
        this.traitCase_ = ADD_STICKER_COLLECTION_FIELD_NUMBER;
    }

    private void mergeAddTransactionTags(PfmOuterClass$RequestAddTransactionTags pfmOuterClass$RequestAddTransactionTags) {
        pfmOuterClass$RequestAddTransactionTags.getClass();
        if (this.traitCase_ != 63449 || this.trait_ == PfmOuterClass$RequestAddTransactionTags.getDefaultInstance()) {
            this.trait_ = pfmOuterClass$RequestAddTransactionTags;
        } else {
            this.trait_ = ((PfmOuterClass$RequestAddTransactionTags.a) PfmOuterClass$RequestAddTransactionTags.newBuilder((PfmOuterClass$RequestAddTransactionTags) this.trait_).v(pfmOuterClass$RequestAddTransactionTags)).j();
        }
        this.traitCase_ = ADD_TRANSACTION_TAGS_FIELD_NUMBER;
    }

    private void mergeAddUserTags(PfmOuterClass$RequestAddUserTags pfmOuterClass$RequestAddUserTags) {
        pfmOuterClass$RequestAddUserTags.getClass();
        if (this.traitCase_ != 63518 || this.trait_ == PfmOuterClass$RequestAddUserTags.getDefaultInstance()) {
            this.trait_ = pfmOuterClass$RequestAddUserTags;
        } else {
            this.trait_ = ((PfmOuterClass$RequestAddUserTags.a) PfmOuterClass$RequestAddUserTags.newBuilder((PfmOuterClass$RequestAddUserTags) this.trait_).v(pfmOuterClass$RequestAddUserTags)).j();
        }
        this.traitCase_ = ADD_USER_TAGS_FIELD_NUMBER;
    }

    private void mergeAuthorizeUser(SefteOuterClass$RequestAuthorizeUser sefteOuterClass$RequestAuthorizeUser) {
        sefteOuterClass$RequestAuthorizeUser.getClass();
        if (this.traitCase_ != 63606 || this.trait_ == SefteOuterClass$RequestAuthorizeUser.getDefaultInstance()) {
            this.trait_ = sefteOuterClass$RequestAuthorizeUser;
        } else {
            this.trait_ = ((SefteOuterClass$RequestAuthorizeUser.a) SefteOuterClass$RequestAuthorizeUser.newBuilder((SefteOuterClass$RequestAuthorizeUser) this.trait_).v(sefteOuterClass$RequestAuthorizeUser)).j();
        }
        this.traitCase_ = AUTHORIZE_USER_FIELD_NUMBER;
    }

    private void mergeBindMoneyRequestDetails(ReactionsOuterClass$RequestBindMoneyRequestDetails reactionsOuterClass$RequestBindMoneyRequestDetails) {
        reactionsOuterClass$RequestBindMoneyRequestDetails.getClass();
        if (this.traitCase_ != 62403 || this.trait_ == ReactionsOuterClass$RequestBindMoneyRequestDetails.getDefaultInstance()) {
            this.trait_ = reactionsOuterClass$RequestBindMoneyRequestDetails;
        } else {
            this.trait_ = ((ReactionsOuterClass$RequestBindMoneyRequestDetails.a) ReactionsOuterClass$RequestBindMoneyRequestDetails.newBuilder((ReactionsOuterClass$RequestBindMoneyRequestDetails) this.trait_).v(reactionsOuterClass$RequestBindMoneyRequestDetails)).j();
        }
        this.traitCase_ = BIND_MONEY_REQUEST_DETAILS_FIELD_NUMBER;
    }

    private void mergeBindMoneyRequestDetailsList(ReactionsOuterClass$RequestBindMoneyRequestDetailsList reactionsOuterClass$RequestBindMoneyRequestDetailsList) {
        reactionsOuterClass$RequestBindMoneyRequestDetailsList.getClass();
        if (this.traitCase_ != 62410 || this.trait_ == ReactionsOuterClass$RequestBindMoneyRequestDetailsList.getDefaultInstance()) {
            this.trait_ = reactionsOuterClass$RequestBindMoneyRequestDetailsList;
        } else {
            this.trait_ = ((ReactionsOuterClass$RequestBindMoneyRequestDetailsList.a) ReactionsOuterClass$RequestBindMoneyRequestDetailsList.newBuilder((ReactionsOuterClass$RequestBindMoneyRequestDetailsList) this.trait_).v(reactionsOuterClass$RequestBindMoneyRequestDetailsList)).j();
        }
        this.traitCase_ = BIND_MONEY_REQUEST_DETAILS_LIST_FIELD_NUMBER;
    }

    private void mergeBlockUser(UsersOuterClass$RequestBlockUser usersOuterClass$RequestBlockUser) {
        usersOuterClass$RequestBlockUser.getClass();
        if (this.traitCase_ != 2636 || this.trait_ == UsersOuterClass$RequestBlockUser.getDefaultInstance()) {
            this.trait_ = usersOuterClass$RequestBlockUser;
        } else {
            this.trait_ = ((UsersOuterClass$RequestBlockUser.a) UsersOuterClass$RequestBlockUser.newBuilder((UsersOuterClass$RequestBlockUser) this.trait_).v(usersOuterClass$RequestBlockUser)).j();
        }
        this.traitCase_ = BLOCK_USER_FIELD_NUMBER;
    }

    private void mergeBuyCharge(Charnet$RequestBuyCharge charnet$RequestBuyCharge) {
        charnet$RequestBuyCharge.getClass();
        if (this.traitCase_ != 63537 || this.trait_ == Charnet$RequestBuyCharge.getDefaultInstance()) {
            this.trait_ = charnet$RequestBuyCharge;
        } else {
            this.trait_ = ((Charnet$RequestBuyCharge.a) Charnet$RequestBuyCharge.newBuilder((Charnet$RequestBuyCharge) this.trait_).v(charnet$RequestBuyCharge)).j();
        }
        this.traitCase_ = BUY_CHARGE_FIELD_NUMBER;
    }

    private void mergeBuyFastCharge(BankOuterClass$RequestBuyFastCharge bankOuterClass$RequestBuyFastCharge) {
        bankOuterClass$RequestBuyFastCharge.getClass();
        if (this.traitCase_ != 62464 || this.trait_ == BankOuterClass$RequestBuyFastCharge.getDefaultInstance()) {
            this.trait_ = bankOuterClass$RequestBuyFastCharge;
        } else {
            this.trait_ = ((BankOuterClass$RequestBuyFastCharge.a) BankOuterClass$RequestBuyFastCharge.newBuilder((BankOuterClass$RequestBuyFastCharge) this.trait_).v(bankOuterClass$RequestBuyFastCharge)).j();
        }
        this.traitCase_ = BUY_FAST_CHARGE_FIELD_NUMBER;
    }

    private void mergeBuyInternetBundle(Charnet$RequestBuyInternetBundle charnet$RequestBuyInternetBundle) {
        charnet$RequestBuyInternetBundle.getClass();
        if (this.traitCase_ != 63539 || this.trait_ == Charnet$RequestBuyInternetBundle.getDefaultInstance()) {
            this.trait_ = charnet$RequestBuyInternetBundle;
        } else {
            this.trait_ = ((Charnet$RequestBuyInternetBundle.a) Charnet$RequestBuyInternetBundle.newBuilder((Charnet$RequestBuyInternetBundle) this.trait_).v(charnet$RequestBuyInternetBundle)).j();
        }
        this.traitCase_ = BUY_INTERNET_BUNDLE_FIELD_NUMBER;
    }

    private void mergeBuyVoucher(ClubOuterClass$RequestBuyVoucher clubOuterClass$RequestBuyVoucher) {
        clubOuterClass$RequestBuyVoucher.getClass();
        if (this.traitCase_ != 63474 || this.trait_ == ClubOuterClass$RequestBuyVoucher.getDefaultInstance()) {
            this.trait_ = clubOuterClass$RequestBuyVoucher;
        } else {
            this.trait_ = ((ClubOuterClass$RequestBuyVoucher.a) ClubOuterClass$RequestBuyVoucher.newBuilder((ClubOuterClass$RequestBuyVoucher) this.trait_).v(clubOuterClass$RequestBuyVoucher)).j();
        }
        this.traitCase_ = BUY_VOUCHER_FIELD_NUMBER;
    }

    private void mergeBuyWheelChance(ClubOuterClass$RequestBuyWheelChance clubOuterClass$RequestBuyWheelChance) {
        clubOuterClass$RequestBuyWheelChance.getClass();
        if (this.traitCase_ != 63466 || this.trait_ == ClubOuterClass$RequestBuyWheelChance.getDefaultInstance()) {
            this.trait_ = clubOuterClass$RequestBuyWheelChance;
        } else {
            this.trait_ = ((ClubOuterClass$RequestBuyWheelChance.a) ClubOuterClass$RequestBuyWheelChance.newBuilder((ClubOuterClass$RequestBuyWheelChance) this.trait_).v(clubOuterClass$RequestBuyWheelChance)).j();
        }
        this.traitCase_ = BUY_WHEEL_CHANCE_FIELD_NUMBER;
    }

    private void mergeCashOutFromWallet(WalletOuterClass$RequestCashOutFromWallet walletOuterClass$RequestCashOutFromWallet) {
        walletOuterClass$RequestCashOutFromWallet.getClass();
        if (this.traitCase_ != 62764 || this.trait_ == WalletOuterClass$RequestCashOutFromWallet.getDefaultInstance()) {
            this.trait_ = walletOuterClass$RequestCashOutFromWallet;
        } else {
            this.trait_ = ((WalletOuterClass$RequestCashOutFromWallet.a) WalletOuterClass$RequestCashOutFromWallet.newBuilder((WalletOuterClass$RequestCashOutFromWallet) this.trait_).v(walletOuterClass$RequestCashOutFromWallet)).j();
        }
        this.traitCase_ = CASH_OUT_FROM_WALLET_FIELD_NUMBER;
    }

    private void mergeCashoutKifpool(KifpoolOuterClass$RequestCashOutKifpool kifpoolOuterClass$RequestCashOutKifpool) {
        kifpoolOuterClass$RequestCashOutKifpool.getClass();
        if (this.traitCase_ != 63407 || this.trait_ == KifpoolOuterClass$RequestCashOutKifpool.getDefaultInstance()) {
            this.trait_ = kifpoolOuterClass$RequestCashOutKifpool;
        } else {
            this.trait_ = ((KifpoolOuterClass$RequestCashOutKifpool.a) KifpoolOuterClass$RequestCashOutKifpool.newBuilder((KifpoolOuterClass$RequestCashOutKifpool) this.trait_).v(kifpoolOuterClass$RequestCashOutKifpool)).j();
        }
        this.traitCase_ = CASHOUT_KIFPOOL_FIELD_NUMBER;
    }

    private void mergeChangeDefaultCardNumber(UsersOuterClass$RequestChangeDefaultCardNumber usersOuterClass$RequestChangeDefaultCardNumber) {
        usersOuterClass$RequestChangeDefaultCardNumber.getClass();
        if (this.traitCase_ != 62129 || this.trait_ == UsersOuterClass$RequestChangeDefaultCardNumber.getDefaultInstance()) {
            this.trait_ = usersOuterClass$RequestChangeDefaultCardNumber;
        } else {
            this.trait_ = ((UsersOuterClass$RequestChangeDefaultCardNumber.a) UsersOuterClass$RequestChangeDefaultCardNumber.newBuilder((UsersOuterClass$RequestChangeDefaultCardNumber) this.trait_).v(usersOuterClass$RequestChangeDefaultCardNumber)).j();
        }
        this.traitCase_ = CHANGE_DEFAULT_CARD_NUMBER_FIELD_NUMBER;
    }

    private void mergeChangePhone(AuthOuterClass$RequestChangePhone authOuterClass$RequestChangePhone) {
        authOuterClass$RequestChangePhone.getClass();
        if (this.traitCase_ != 63453 || this.trait_ == AuthOuterClass$RequestChangePhone.getDefaultInstance()) {
            this.trait_ = authOuterClass$RequestChangePhone;
        } else {
            this.trait_ = ((AuthOuterClass$RequestChangePhone.a) AuthOuterClass$RequestChangePhone.newBuilder((AuthOuterClass$RequestChangePhone) this.trait_).v(authOuterClass$RequestChangePhone)).j();
        }
        this.traitCase_ = CHANGE_PHONE_FIELD_NUMBER;
    }

    private void mergeChangePointToMoney(ClubOuterClass$RequestChangePointToMoney clubOuterClass$RequestChangePointToMoney) {
        clubOuterClass$RequestChangePointToMoney.getClass();
        if (this.traitCase_ != 63464 || this.trait_ == ClubOuterClass$RequestChangePointToMoney.getDefaultInstance()) {
            this.trait_ = clubOuterClass$RequestChangePointToMoney;
        } else {
            this.trait_ = ((ClubOuterClass$RequestChangePointToMoney.a) ClubOuterClass$RequestChangePointToMoney.newBuilder((ClubOuterClass$RequestChangePointToMoney) this.trait_).v(clubOuterClass$RequestChangePointToMoney)).j();
        }
        this.traitCase_ = CHANGE_POINT_TO_MONEY_FIELD_NUMBER;
    }

    private void mergeChangeStatusDialogAdOrder(AdvertisementOuterClass$RequestChangeStatusDialogAdOrder advertisementOuterClass$RequestChangeStatusDialogAdOrder) {
        advertisementOuterClass$RequestChangeStatusDialogAdOrder.getClass();
        if (this.traitCase_ != 63570 || this.trait_ == AdvertisementOuterClass$RequestChangeStatusDialogAdOrder.getDefaultInstance()) {
            this.trait_ = advertisementOuterClass$RequestChangeStatusDialogAdOrder;
        } else {
            this.trait_ = ((AdvertisementOuterClass$RequestChangeStatusDialogAdOrder.a) AdvertisementOuterClass$RequestChangeStatusDialogAdOrder.newBuilder((AdvertisementOuterClass$RequestChangeStatusDialogAdOrder) this.trait_).v(advertisementOuterClass$RequestChangeStatusDialogAdOrder)).j();
        }
        this.traitCase_ = CHANGE_STATUS_DIALOG_AD_ORDER_FIELD_NUMBER;
    }

    private void mergeCharge(KifpoolOuterClass$RequestCharge kifpoolOuterClass$RequestCharge) {
        kifpoolOuterClass$RequestCharge.getClass();
        if (this.traitCase_ != 63415 || this.trait_ == KifpoolOuterClass$RequestCharge.getDefaultInstance()) {
            this.trait_ = kifpoolOuterClass$RequestCharge;
        } else {
            this.trait_ = ((KifpoolOuterClass$RequestCharge.a) KifpoolOuterClass$RequestCharge.newBuilder((KifpoolOuterClass$RequestCharge) this.trait_).v(kifpoolOuterClass$RequestCharge)).j();
        }
        this.traitCase_ = CHARGE_FIELD_NUMBER;
    }

    private void mergeCheckChargePermission(KifpoolOuterClass$RequestCheckChargePermission kifpoolOuterClass$RequestCheckChargePermission) {
        kifpoolOuterClass$RequestCheckChargePermission.getClass();
        if (this.traitCase_ != 63413 || this.trait_ == KifpoolOuterClass$RequestCheckChargePermission.getDefaultInstance()) {
            this.trait_ = kifpoolOuterClass$RequestCheckChargePermission;
        } else {
            this.trait_ = ((KifpoolOuterClass$RequestCheckChargePermission.a) KifpoolOuterClass$RequestCheckChargePermission.newBuilder((KifpoolOuterClass$RequestCheckChargePermission) this.trait_).v(kifpoolOuterClass$RequestCheckChargePermission)).j();
        }
        this.traitCase_ = CHECK_CHARGE_PERMISSION_FIELD_NUMBER;
    }

    private void mergeCheckNickName(UsersOuterClass$RequestCheckNickName usersOuterClass$RequestCheckNickName) {
        usersOuterClass$RequestCheckNickName.getClass();
        if (this.traitCase_ != 206 || this.trait_ == UsersOuterClass$RequestCheckNickName.getDefaultInstance()) {
            this.trait_ = usersOuterClass$RequestCheckNickName;
        } else {
            this.trait_ = ((UsersOuterClass$RequestCheckNickName.a) UsersOuterClass$RequestCheckNickName.newBuilder((UsersOuterClass$RequestCheckNickName) this.trait_).v(usersOuterClass$RequestCheckNickName)).j();
        }
        this.traitCase_ = CHECK_NICK_NAME_FIELD_NUMBER;
    }

    private void mergeCheckStatusOfPayment(SefteOuterClass$RequestCheckStatusOfPayment sefteOuterClass$RequestCheckStatusOfPayment) {
        sefteOuterClass$RequestCheckStatusOfPayment.getClass();
        if (this.traitCase_ != 63619 || this.trait_ == SefteOuterClass$RequestCheckStatusOfPayment.getDefaultInstance()) {
            this.trait_ = sefteOuterClass$RequestCheckStatusOfPayment;
        } else {
            this.trait_ = ((SefteOuterClass$RequestCheckStatusOfPayment.a) SefteOuterClass$RequestCheckStatusOfPayment.newBuilder((SefteOuterClass$RequestCheckStatusOfPayment) this.trait_).v(sefteOuterClass$RequestCheckStatusOfPayment)).j();
        }
        this.traitCase_ = CHECK_STATUS_OF_PAYMENT_FIELD_NUMBER;
    }

    private void mergeClearChat(MessagingOuterClass$RequestClearChat messagingOuterClass$RequestClearChat) {
        messagingOuterClass$RequestClearChat.getClass();
        if (this.traitCase_ != 99 || this.trait_ == MessagingOuterClass$RequestClearChat.getDefaultInstance()) {
            this.trait_ = messagingOuterClass$RequestClearChat;
        } else {
            this.trait_ = ((MessagingOuterClass$RequestClearChat.a) MessagingOuterClass$RequestClearChat.newBuilder((MessagingOuterClass$RequestClearChat) this.trait_).v(messagingOuterClass$RequestClearChat)).j();
        }
        this.traitCase_ = 99;
    }

    private void mergeCombinedUpdate(UpdateBoxStruct$CombinedUpdate updateBoxStruct$CombinedUpdate) {
        updateBoxStruct$CombinedUpdate.getClass();
        if (this.traitCase_ != 2625 || this.trait_ == UpdateBoxStruct$CombinedUpdate.getDefaultInstance()) {
            this.trait_ = updateBoxStruct$CombinedUpdate;
        } else {
            this.trait_ = ((UpdateBoxStruct$CombinedUpdate.a) UpdateBoxStruct$CombinedUpdate.newBuilder((UpdateBoxStruct$CombinedUpdate) this.trait_).v(updateBoxStruct$CombinedUpdate)).j();
        }
        this.traitCase_ = 2625;
    }

    private void mergeCreateGroup(GroupsOuterClass$RequestCreateGroup groupsOuterClass$RequestCreateGroup) {
        groupsOuterClass$RequestCreateGroup.getClass();
        if (this.traitCase_ != 230 || this.trait_ == GroupsOuterClass$RequestCreateGroup.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$RequestCreateGroup;
        } else {
            this.trait_ = ((GroupsOuterClass$RequestCreateGroup.b) GroupsOuterClass$RequestCreateGroup.newBuilder((GroupsOuterClass$RequestCreateGroup) this.trait_).v(groupsOuterClass$RequestCreateGroup)).j();
        }
        this.traitCase_ = CREATE_GROUP_FIELD_NUMBER;
    }

    private void mergeCreateKifpool(KifpoolOuterClass$RequestCreateKifpool kifpoolOuterClass$RequestCreateKifpool) {
        kifpoolOuterClass$RequestCreateKifpool.getClass();
        if (this.traitCase_ != 63404 || this.trait_ == KifpoolOuterClass$RequestCreateKifpool.getDefaultInstance()) {
            this.trait_ = kifpoolOuterClass$RequestCreateKifpool;
        } else {
            this.trait_ = ((KifpoolOuterClass$RequestCreateKifpool.a) KifpoolOuterClass$RequestCreateKifpool.newBuilder((KifpoolOuterClass$RequestCreateKifpool) this.trait_).v(kifpoolOuterClass$RequestCreateKifpool)).j();
        }
        this.traitCase_ = CREATE_KIFPOOL_FIELD_NUMBER;
    }

    private void mergeCreateSavedBill(BillOuterClass$RequestCreateSavedBill billOuterClass$RequestCreateSavedBill) {
        billOuterClass$RequestCreateSavedBill.getClass();
        if (this.traitCase_ != 63549 || this.trait_ == BillOuterClass$RequestCreateSavedBill.getDefaultInstance()) {
            this.trait_ = billOuterClass$RequestCreateSavedBill;
        } else {
            this.trait_ = ((BillOuterClass$RequestCreateSavedBill.a) BillOuterClass$RequestCreateSavedBill.newBuilder((BillOuterClass$RequestCreateSavedBill) this.trait_).v(billOuterClass$RequestCreateSavedBill)).j();
        }
        this.traitCase_ = CREATE_SAVED_BILL_FIELD_NUMBER;
    }

    private void mergeCryptoTransfer(KifpoolOuterClass$RequestCryptoTransfer kifpoolOuterClass$RequestCryptoTransfer) {
        kifpoolOuterClass$RequestCryptoTransfer.getClass();
        if (this.traitCase_ != 63632 || this.trait_ == KifpoolOuterClass$RequestCryptoTransfer.getDefaultInstance()) {
            this.trait_ = kifpoolOuterClass$RequestCryptoTransfer;
        } else {
            this.trait_ = ((KifpoolOuterClass$RequestCryptoTransfer.a) KifpoolOuterClass$RequestCryptoTransfer.newBuilder((KifpoolOuterClass$RequestCryptoTransfer) this.trait_).v(kifpoolOuterClass$RequestCryptoTransfer)).j();
        }
        this.traitCase_ = CRYPTO_TRANSFER_FIELD_NUMBER;
    }

    private void mergeDeleteAccount(AuthOuterClass$RequestDeleteAccount authOuterClass$RequestDeleteAccount) {
        authOuterClass$RequestDeleteAccount.getClass();
        if (this.traitCase_ != 43606 || this.trait_ == AuthOuterClass$RequestDeleteAccount.getDefaultInstance()) {
            this.trait_ = authOuterClass$RequestDeleteAccount;
        } else {
            this.trait_ = ((AuthOuterClass$RequestDeleteAccount.a) AuthOuterClass$RequestDeleteAccount.newBuilder((AuthOuterClass$RequestDeleteAccount) this.trait_).v(authOuterClass$RequestDeleteAccount)).j();
        }
        this.traitCase_ = DELETE_ACCOUNT_FIELD_NUMBER;
    }

    private void mergeDeleteChat(MessagingOuterClass$RequestDeleteChat messagingOuterClass$RequestDeleteChat) {
        messagingOuterClass$RequestDeleteChat.getClass();
        if (this.traitCase_ != 100 || this.trait_ == MessagingOuterClass$RequestDeleteChat.getDefaultInstance()) {
            this.trait_ = messagingOuterClass$RequestDeleteChat;
        } else {
            this.trait_ = ((MessagingOuterClass$RequestDeleteChat.a) MessagingOuterClass$RequestDeleteChat.newBuilder((MessagingOuterClass$RequestDeleteChat) this.trait_).v(messagingOuterClass$RequestDeleteChat)).j();
        }
        this.traitCase_ = 100;
    }

    private void mergeDeleteInternetBundleOrder(Charnet$RequestDeleteInternetBundleOrder charnet$RequestDeleteInternetBundleOrder) {
        charnet$RequestDeleteInternetBundleOrder.getClass();
        if (this.traitCase_ != 63536 || this.trait_ == Charnet$RequestDeleteInternetBundleOrder.getDefaultInstance()) {
            this.trait_ = charnet$RequestDeleteInternetBundleOrder;
        } else {
            this.trait_ = ((Charnet$RequestDeleteInternetBundleOrder.a) Charnet$RequestDeleteInternetBundleOrder.newBuilder((Charnet$RequestDeleteInternetBundleOrder) this.trait_).v(charnet$RequestDeleteInternetBundleOrder)).j();
        }
        this.traitCase_ = DELETE_INTERNET_BUNDLE_ORDER_FIELD_NUMBER;
    }

    private void mergeDeleteMessage(MessagingOuterClass$RequestDeleteMessage messagingOuterClass$RequestDeleteMessage) {
        messagingOuterClass$RequestDeleteMessage.getClass();
        if (this.traitCase_ != 98 || this.trait_ == MessagingOuterClass$RequestDeleteMessage.getDefaultInstance()) {
            this.trait_ = messagingOuterClass$RequestDeleteMessage;
        } else {
            this.trait_ = ((MessagingOuterClass$RequestDeleteMessage.a) MessagingOuterClass$RequestDeleteMessage.newBuilder((MessagingOuterClass$RequestDeleteMessage) this.trait_).v(messagingOuterClass$RequestDeleteMessage)).j();
        }
        this.traitCase_ = 98;
    }

    private void mergeDeleteOrder(Saba$RequestDeleteOrder saba$RequestDeleteOrder) {
        saba$RequestDeleteOrder.getClass();
        if (this.traitCase_ != 63509 || this.trait_ == Saba$RequestDeleteOrder.getDefaultInstance()) {
            this.trait_ = saba$RequestDeleteOrder;
        } else {
            this.trait_ = ((Saba$RequestDeleteOrder.a) Saba$RequestDeleteOrder.newBuilder((Saba$RequestDeleteOrder) this.trait_).v(saba$RequestDeleteOrder)).j();
        }
        this.traitCase_ = DELETE_ORDER_FIELD_NUMBER;
    }

    private void mergeDeleteSavedBills(BillOuterClass$RequestDeleteSavedBills billOuterClass$RequestDeleteSavedBills) {
        billOuterClass$RequestDeleteSavedBills.getClass();
        if (this.traitCase_ != 63554 || this.trait_ == BillOuterClass$RequestDeleteSavedBills.getDefaultInstance()) {
            this.trait_ = billOuterClass$RequestDeleteSavedBills;
        } else {
            this.trait_ = ((BillOuterClass$RequestDeleteSavedBills.a) BillOuterClass$RequestDeleteSavedBills.newBuilder((BillOuterClass$RequestDeleteSavedBills) this.trait_).v(billOuterClass$RequestDeleteSavedBills)).j();
        }
        this.traitCase_ = DELETE_SAVED_BILLS_FIELD_NUMBER;
    }

    private void mergeDeliverOtp(SapOuterClass$RequestDeliverOtp sapOuterClass$RequestDeliverOtp) {
        sapOuterClass$RequestDeliverOtp.getClass();
        if (this.traitCase_ != 63493 || this.trait_ == SapOuterClass$RequestDeliverOtp.getDefaultInstance()) {
            this.trait_ = sapOuterClass$RequestDeliverOtp;
        } else {
            this.trait_ = ((SapOuterClass$RequestDeliverOtp.a) SapOuterClass$RequestDeliverOtp.newBuilder((SapOuterClass$RequestDeliverOtp) this.trait_).v(sapOuterClass$RequestDeliverOtp)).j();
        }
        this.traitCase_ = DELIVER_OTP_FIELD_NUMBER;
    }

    private void mergeDiscardCall(MeetOuterClass$RequestDiscardCall meetOuterClass$RequestDiscardCall) {
        meetOuterClass$RequestDiscardCall.getClass();
        if (this.traitCase_ != 63580 || this.trait_ == MeetOuterClass$RequestDiscardCall.getDefaultInstance()) {
            this.trait_ = meetOuterClass$RequestDiscardCall;
        } else {
            this.trait_ = ((MeetOuterClass$RequestDiscardCall.a) MeetOuterClass$RequestDiscardCall.newBuilder((MeetOuterClass$RequestDiscardCall) this.trait_).v(meetOuterClass$RequestDiscardCall)).j();
        }
        this.traitCase_ = DISCARD_CALL_FIELD_NUMBER;
    }

    private void mergeEditAbout(UsersOuterClass$RequestEditAbout usersOuterClass$RequestEditAbout) {
        usersOuterClass$RequestEditAbout.getClass();
        if (this.traitCase_ != 212 || this.trait_ == UsersOuterClass$RequestEditAbout.getDefaultInstance()) {
            this.trait_ = usersOuterClass$RequestEditAbout;
        } else {
            this.trait_ = ((UsersOuterClass$RequestEditAbout.a) UsersOuterClass$RequestEditAbout.newBuilder((UsersOuterClass$RequestEditAbout) this.trait_).v(usersOuterClass$RequestEditAbout)).j();
        }
        this.traitCase_ = 212;
    }

    private void mergeEditAvatar(UsersOuterClass$RequestEditAvatar usersOuterClass$RequestEditAvatar) {
        usersOuterClass$RequestEditAvatar.getClass();
        if (this.traitCase_ != 31 || this.trait_ == UsersOuterClass$RequestEditAvatar.getDefaultInstance()) {
            this.trait_ = usersOuterClass$RequestEditAvatar;
        } else {
            this.trait_ = ((UsersOuterClass$RequestEditAvatar.a) UsersOuterClass$RequestEditAvatar.newBuilder((UsersOuterClass$RequestEditAvatar) this.trait_).v(usersOuterClass$RequestEditAvatar)).j();
        }
        this.traitCase_ = 31;
    }

    private void mergeEditBirthDate(UsersOuterClass$RequestEditBirthDate usersOuterClass$RequestEditBirthDate) {
        usersOuterClass$RequestEditBirthDate.getClass();
        if (this.traitCase_ != 63652 || this.trait_ == UsersOuterClass$RequestEditBirthDate.getDefaultInstance()) {
            this.trait_ = usersOuterClass$RequestEditBirthDate;
        } else {
            this.trait_ = ((UsersOuterClass$RequestEditBirthDate.a) UsersOuterClass$RequestEditBirthDate.newBuilder((UsersOuterClass$RequestEditBirthDate) this.trait_).v(usersOuterClass$RequestEditBirthDate)).j();
        }
        this.traitCase_ = EDIT_BIRTH_DATE_FIELD_NUMBER;
    }

    private void mergeEditCardExpirationDate(SapOuterClass$RequestEditCardExpirationDate sapOuterClass$RequestEditCardExpirationDate) {
        sapOuterClass$RequestEditCardExpirationDate.getClass();
        if (this.traitCase_ != 63566 || this.trait_ == SapOuterClass$RequestEditCardExpirationDate.getDefaultInstance()) {
            this.trait_ = sapOuterClass$RequestEditCardExpirationDate;
        } else {
            this.trait_ = ((SapOuterClass$RequestEditCardExpirationDate.a) SapOuterClass$RequestEditCardExpirationDate.newBuilder((SapOuterClass$RequestEditCardExpirationDate) this.trait_).v(sapOuterClass$RequestEditCardExpirationDate)).j();
        }
        this.traitCase_ = EDIT_CARD_EXPIRATION_DATE_FIELD_NUMBER;
    }

    private void mergeEditChannelNick(GroupsOuterClass$RequestEditChannelNick groupsOuterClass$RequestEditChannelNick) {
        groupsOuterClass$RequestEditChannelNick.getClass();
        if (this.traitCase_ != 3396 || this.trait_ == GroupsOuterClass$RequestEditChannelNick.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$RequestEditChannelNick;
        } else {
            this.trait_ = ((GroupsOuterClass$RequestEditChannelNick.a) GroupsOuterClass$RequestEditChannelNick.newBuilder((GroupsOuterClass$RequestEditChannelNick) this.trait_).v(groupsOuterClass$RequestEditChannelNick)).j();
        }
        this.traitCase_ = EDIT_CHANNEL_NICK_FIELD_NUMBER;
    }

    private void mergeEditGroupAbout(GroupsOuterClass$RequestEditGroupAbout groupsOuterClass$RequestEditGroupAbout) {
        groupsOuterClass$RequestEditGroupAbout.getClass();
        if (this.traitCase_ != 213 || this.trait_ == GroupsOuterClass$RequestEditGroupAbout.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$RequestEditGroupAbout;
        } else {
            this.trait_ = ((GroupsOuterClass$RequestEditGroupAbout.b) GroupsOuterClass$RequestEditGroupAbout.newBuilder((GroupsOuterClass$RequestEditGroupAbout) this.trait_).v(groupsOuterClass$RequestEditGroupAbout)).j();
        }
        this.traitCase_ = 213;
    }

    private void mergeEditGroupAvatar(GroupsOuterClass$RequestEditGroupAvatar groupsOuterClass$RequestEditGroupAvatar) {
        groupsOuterClass$RequestEditGroupAvatar.getClass();
        if (this.traitCase_ != 86 || this.trait_ == GroupsOuterClass$RequestEditGroupAvatar.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$RequestEditGroupAvatar;
        } else {
            this.trait_ = ((GroupsOuterClass$RequestEditGroupAvatar.b) GroupsOuterClass$RequestEditGroupAvatar.newBuilder((GroupsOuterClass$RequestEditGroupAvatar) this.trait_).v(groupsOuterClass$RequestEditGroupAvatar)).j();
        }
        this.traitCase_ = 86;
    }

    private void mergeEditGroupDefaultCardNumber(GroupsOuterClass$RequestEditGroupDefaultCardNumber groupsOuterClass$RequestEditGroupDefaultCardNumber) {
        groupsOuterClass$RequestEditGroupDefaultCardNumber.getClass();
        if (this.traitCase_ != 120 || this.trait_ == GroupsOuterClass$RequestEditGroupDefaultCardNumber.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$RequestEditGroupDefaultCardNumber;
        } else {
            this.trait_ = ((GroupsOuterClass$RequestEditGroupDefaultCardNumber.a) GroupsOuterClass$RequestEditGroupDefaultCardNumber.newBuilder((GroupsOuterClass$RequestEditGroupDefaultCardNumber) this.trait_).v(groupsOuterClass$RequestEditGroupDefaultCardNumber)).j();
        }
        this.traitCase_ = EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER;
    }

    private void mergeEditGroupTitle(GroupsOuterClass$RequestEditGroupTitle groupsOuterClass$RequestEditGroupTitle) {
        groupsOuterClass$RequestEditGroupTitle.getClass();
        if (this.traitCase_ != 85 || this.trait_ == GroupsOuterClass$RequestEditGroupTitle.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$RequestEditGroupTitle;
        } else {
            this.trait_ = ((GroupsOuterClass$RequestEditGroupTitle.b) GroupsOuterClass$RequestEditGroupTitle.newBuilder((GroupsOuterClass$RequestEditGroupTitle) this.trait_).v(groupsOuterClass$RequestEditGroupTitle)).j();
        }
        this.traitCase_ = 85;
    }

    private void mergeEditMyPreferredLanguages(UsersOuterClass$RequestEditMyPreferredLanguages usersOuterClass$RequestEditMyPreferredLanguages) {
        usersOuterClass$RequestEditMyPreferredLanguages.getClass();
        if (this.traitCase_ != 145 || this.trait_ == UsersOuterClass$RequestEditMyPreferredLanguages.getDefaultInstance()) {
            this.trait_ = usersOuterClass$RequestEditMyPreferredLanguages;
        } else {
            this.trait_ = ((UsersOuterClass$RequestEditMyPreferredLanguages.a) UsersOuterClass$RequestEditMyPreferredLanguages.newBuilder((UsersOuterClass$RequestEditMyPreferredLanguages) this.trait_).v(usersOuterClass$RequestEditMyPreferredLanguages)).j();
        }
        this.traitCase_ = EDIT_MY_PREFERRED_LANGUAGES_FIELD_NUMBER;
    }

    private void mergeEditMyTimeZone(UsersOuterClass$RequestEditMyTimeZone usersOuterClass$RequestEditMyTimeZone) {
        usersOuterClass$RequestEditMyTimeZone.getClass();
        if (this.traitCase_ != 144 || this.trait_ == UsersOuterClass$RequestEditMyTimeZone.getDefaultInstance()) {
            this.trait_ = usersOuterClass$RequestEditMyTimeZone;
        } else {
            this.trait_ = ((UsersOuterClass$RequestEditMyTimeZone.a) UsersOuterClass$RequestEditMyTimeZone.newBuilder((UsersOuterClass$RequestEditMyTimeZone) this.trait_).v(usersOuterClass$RequestEditMyTimeZone)).j();
        }
        this.traitCase_ = EDIT_MY_TIME_ZONE_FIELD_NUMBER;
    }

    private void mergeEditName(UsersOuterClass$RequestEditName usersOuterClass$RequestEditName) {
        usersOuterClass$RequestEditName.getClass();
        if (this.traitCase_ != 53 || this.trait_ == UsersOuterClass$RequestEditName.getDefaultInstance()) {
            this.trait_ = usersOuterClass$RequestEditName;
        } else {
            this.trait_ = ((UsersOuterClass$RequestEditName.a) UsersOuterClass$RequestEditName.newBuilder((UsersOuterClass$RequestEditName) this.trait_).v(usersOuterClass$RequestEditName)).j();
        }
        this.traitCase_ = 53;
    }

    private void mergeEditNickName(UsersOuterClass$RequestEditNickName usersOuterClass$RequestEditNickName) {
        usersOuterClass$RequestEditNickName.getClass();
        if (this.traitCase_ != 205 || this.trait_ == UsersOuterClass$RequestEditNickName.getDefaultInstance()) {
            this.trait_ = usersOuterClass$RequestEditNickName;
        } else {
            this.trait_ = ((UsersOuterClass$RequestEditNickName.a) UsersOuterClass$RequestEditNickName.newBuilder((UsersOuterClass$RequestEditNickName) this.trait_).v(usersOuterClass$RequestEditNickName)).j();
        }
        this.traitCase_ = EDIT_NICK_NAME_FIELD_NUMBER;
    }

    private void mergeEditParameter(ConfigsOuterClass$RequestEditParameter configsOuterClass$RequestEditParameter) {
        configsOuterClass$RequestEditParameter.getClass();
        if (this.traitCase_ != 128 || this.trait_ == ConfigsOuterClass$RequestEditParameter.getDefaultInstance()) {
            this.trait_ = configsOuterClass$RequestEditParameter;
        } else {
            this.trait_ = ((ConfigsOuterClass$RequestEditParameter.a) ConfigsOuterClass$RequestEditParameter.newBuilder((ConfigsOuterClass$RequestEditParameter) this.trait_).v(configsOuterClass$RequestEditParameter)).j();
        }
        this.traitCase_ = 128;
    }

    private void mergeEditSex(UsersOuterClass$RequestEditSex usersOuterClass$RequestEditSex) {
        usersOuterClass$RequestEditSex.getClass();
        if (this.traitCase_ != 63651 || this.trait_ == UsersOuterClass$RequestEditSex.getDefaultInstance()) {
            this.trait_ = usersOuterClass$RequestEditSex;
        } else {
            this.trait_ = ((UsersOuterClass$RequestEditSex.a) UsersOuterClass$RequestEditSex.newBuilder((UsersOuterClass$RequestEditSex) this.trait_).v(usersOuterClass$RequestEditSex)).j();
        }
        this.traitCase_ = EDIT_SEX_FIELD_NUMBER;
    }

    private void mergeEditUserLocalName(UsersOuterClass$RequestEditUserLocalName usersOuterClass$RequestEditUserLocalName) {
        usersOuterClass$RequestEditUserLocalName.getClass();
        if (this.traitCase_ != 96 || this.trait_ == UsersOuterClass$RequestEditUserLocalName.getDefaultInstance()) {
            this.trait_ = usersOuterClass$RequestEditUserLocalName;
        } else {
            this.trait_ = ((UsersOuterClass$RequestEditUserLocalName.a) UsersOuterClass$RequestEditUserLocalName.newBuilder((UsersOuterClass$RequestEditUserLocalName) this.trait_).v(usersOuterClass$RequestEditUserLocalName)).j();
        }
        this.traitCase_ = 96;
    }

    private void mergeEnrollNewCard(SapOuterClass$RequestEnrollNewCard sapOuterClass$RequestEnrollNewCard) {
        sapOuterClass$RequestEnrollNewCard.getClass();
        if (this.traitCase_ != 63487 || this.trait_ == SapOuterClass$RequestEnrollNewCard.getDefaultInstance()) {
            this.trait_ = sapOuterClass$RequestEnrollNewCard;
        } else {
            this.trait_ = ((SapOuterClass$RequestEnrollNewCard.a) SapOuterClass$RequestEnrollNewCard.newBuilder((SapOuterClass$RequestEnrollNewCard) this.trait_).v(sapOuterClass$RequestEnrollNewCard)).j();
        }
        this.traitCase_ = ENROLL_NEW_CARD_FIELD_NUMBER;
    }

    private void mergeFatSeqUpdate(UpdateBoxStruct$FatSeqUpdate updateBoxStruct$FatSeqUpdate) {
        updateBoxStruct$FatSeqUpdate.getClass();
        if (this.traitCase_ != 73 || this.trait_ == UpdateBoxStruct$FatSeqUpdate.getDefaultInstance()) {
            this.trait_ = updateBoxStruct$FatSeqUpdate;
        } else {
            this.trait_ = ((UpdateBoxStruct$FatSeqUpdate.a) UpdateBoxStruct$FatSeqUpdate.newBuilder((UpdateBoxStruct$FatSeqUpdate) this.trait_).v(updateBoxStruct$FatSeqUpdate)).j();
        }
        this.traitCase_ = 73;
    }

    private void mergeFetchGroupAdmins(GroupsOuterClass$RequestFetchGroupAdmins groupsOuterClass$RequestFetchGroupAdmins) {
        groupsOuterClass$RequestFetchGroupAdmins.getClass();
        if (this.traitCase_ != 729 || this.trait_ == GroupsOuterClass$RequestFetchGroupAdmins.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$RequestFetchGroupAdmins;
        } else {
            this.trait_ = ((GroupsOuterClass$RequestFetchGroupAdmins.a) GroupsOuterClass$RequestFetchGroupAdmins.newBuilder((GroupsOuterClass$RequestFetchGroupAdmins) this.trait_).v(groupsOuterClass$RequestFetchGroupAdmins)).j();
        }
        this.traitCase_ = FETCH_GROUP_ADMINS_FIELD_NUMBER;
    }

    private void mergeFilterTaggedTransactions(PfmOuterClass$RequestFilterTaggedTransactions pfmOuterClass$RequestFilterTaggedTransactions) {
        pfmOuterClass$RequestFilterTaggedTransactions.getClass();
        if (this.traitCase_ != 63630 || this.trait_ == PfmOuterClass$RequestFilterTaggedTransactions.getDefaultInstance()) {
            this.trait_ = pfmOuterClass$RequestFilterTaggedTransactions;
        } else {
            this.trait_ = ((PfmOuterClass$RequestFilterTaggedTransactions.a) PfmOuterClass$RequestFilterTaggedTransactions.newBuilder((PfmOuterClass$RequestFilterTaggedTransactions) this.trait_).v(pfmOuterClass$RequestFilterTaggedTransactions)).j();
        }
        this.traitCase_ = FILTER_TAGGED_TRANSACTIONS_FIELD_NUMBER;
    }

    private void mergeGetAcquiredVouchers(ClubOuterClass$RequestGetAcquiredVouchers clubOuterClass$RequestGetAcquiredVouchers) {
        clubOuterClass$RequestGetAcquiredVouchers.getClass();
        if (this.traitCase_ != 63637 || this.trait_ == ClubOuterClass$RequestGetAcquiredVouchers.getDefaultInstance()) {
            this.trait_ = clubOuterClass$RequestGetAcquiredVouchers;
        } else {
            this.trait_ = ((ClubOuterClass$RequestGetAcquiredVouchers.a) ClubOuterClass$RequestGetAcquiredVouchers.newBuilder((ClubOuterClass$RequestGetAcquiredVouchers) this.trait_).v(clubOuterClass$RequestGetAcquiredVouchers)).j();
        }
        this.traitCase_ = GET_ACQUIRED_VOUCHERS_FIELD_NUMBER;
    }

    private void mergeGetAdProvider(AdvertisementOuterClass$RequestGetAdProvider advertisementOuterClass$RequestGetAdProvider) {
        advertisementOuterClass$RequestGetAdProvider.getClass();
        if (this.traitCase_ != 63525 || this.trait_ == AdvertisementOuterClass$RequestGetAdProvider.getDefaultInstance()) {
            this.trait_ = advertisementOuterClass$RequestGetAdProvider;
        } else {
            this.trait_ = ((AdvertisementOuterClass$RequestGetAdProvider.a) AdvertisementOuterClass$RequestGetAdProvider.newBuilder((AdvertisementOuterClass$RequestGetAdProvider) this.trait_).v(advertisementOuterClass$RequestGetAdProvider)).j();
        }
        this.traitCase_ = GET_AD_PROVIDER_FIELD_NUMBER;
    }

    private void mergeGetAuthSessions(AuthOuterClass$RequestGetAuthSessions authOuterClass$RequestGetAuthSessions) {
        authOuterClass$RequestGetAuthSessions.getClass();
        if (this.traitCase_ != 80 || this.trait_ == AuthOuterClass$RequestGetAuthSessions.getDefaultInstance()) {
            this.trait_ = authOuterClass$RequestGetAuthSessions;
        } else {
            this.trait_ = ((AuthOuterClass$RequestGetAuthSessions.a) AuthOuterClass$RequestGetAuthSessions.newBuilder((AuthOuterClass$RequestGetAuthSessions) this.trait_).v(authOuterClass$RequestGetAuthSessions)).j();
        }
        this.traitCase_ = 80;
    }

    private void mergeGetBaleTicket(AuthOuterClass$RequestGetBaleTicket authOuterClass$RequestGetBaleTicket) {
        authOuterClass$RequestGetBaleTicket.getClass();
        if (this.traitCase_ != 63260 || this.trait_ == AuthOuterClass$RequestGetBaleTicket.getDefaultInstance()) {
            this.trait_ = authOuterClass$RequestGetBaleTicket;
        } else {
            this.trait_ = ((AuthOuterClass$RequestGetBaleTicket.a) AuthOuterClass$RequestGetBaleTicket.newBuilder((AuthOuterClass$RequestGetBaleTicket) this.trait_).v(authOuterClass$RequestGetBaleTicket)).j();
        }
        this.traitCase_ = GET_BALE_TICKET_FIELD_NUMBER;
    }

    private void mergeGetBamServiceToken(Microbanki$RequestGetBamServiceToken microbanki$RequestGetBamServiceToken) {
        microbanki$RequestGetBamServiceToken.getClass();
        if (this.traitCase_ != 62406 || this.trait_ == Microbanki$RequestGetBamServiceToken.getDefaultInstance()) {
            this.trait_ = microbanki$RequestGetBamServiceToken;
        } else {
            this.trait_ = ((Microbanki$RequestGetBamServiceToken.a) Microbanki$RequestGetBamServiceToken.newBuilder((Microbanki$RequestGetBamServiceToken) this.trait_).v(microbanki$RequestGetBamServiceToken)).j();
        }
        this.traitCase_ = GET_BAM_SERVICE_TOKEN_FIELD_NUMBER;
    }

    private void mergeGetBillHistory(BillOuterClass$RequestGetBillHistory billOuterClass$RequestGetBillHistory) {
        billOuterClass$RequestGetBillHistory.getClass();
        if (this.traitCase_ != 63547 || this.trait_ == BillOuterClass$RequestGetBillHistory.getDefaultInstance()) {
            this.trait_ = billOuterClass$RequestGetBillHistory;
        } else {
            this.trait_ = ((BillOuterClass$RequestGetBillHistory.a) BillOuterClass$RequestGetBillHistory.newBuilder((BillOuterClass$RequestGetBillHistory) this.trait_).v(billOuterClass$RequestGetBillHistory)).j();
        }
        this.traitCase_ = GET_BILL_HISTORY_FIELD_NUMBER;
    }

    private void mergeGetBotWhiteList(KetfOuterClass$RequestGetBotWhiteList ketfOuterClass$RequestGetBotWhiteList) {
        ketfOuterClass$RequestGetBotWhiteList.getClass();
        if (this.traitCase_ != 249 || this.trait_ == KetfOuterClass$RequestGetBotWhiteList.getDefaultInstance()) {
            this.trait_ = ketfOuterClass$RequestGetBotWhiteList;
        } else {
            this.trait_ = ((KetfOuterClass$RequestGetBotWhiteList.a) KetfOuterClass$RequestGetBotWhiteList.newBuilder((KetfOuterClass$RequestGetBotWhiteList) this.trait_).v(ketfOuterClass$RequestGetBotWhiteList)).j();
        }
        this.traitCase_ = 249;
    }

    private void mergeGetCanSeeMessages(GroupsOuterClass$RequestGetCanSeeMessages groupsOuterClass$RequestGetCanSeeMessages) {
        groupsOuterClass$RequestGetCanSeeMessages.getClass();
        if (this.traitCase_ != 726 || this.trait_ == GroupsOuterClass$RequestGetCanSeeMessages.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$RequestGetCanSeeMessages;
        } else {
            this.trait_ = ((GroupsOuterClass$RequestGetCanSeeMessages.a) GroupsOuterClass$RequestGetCanSeeMessages.newBuilder((GroupsOuterClass$RequestGetCanSeeMessages) this.trait_).v(groupsOuterClass$RequestGetCanSeeMessages)).j();
        }
        this.traitCase_ = GET_CAN_SEE_MESSAGES_FIELD_NUMBER;
    }

    private void mergeGetCardInfo(SapOuterClass$RequestGetCardInfo sapOuterClass$RequestGetCardInfo) {
        sapOuterClass$RequestGetCardInfo.getClass();
        if (this.traitCase_ != 63489 || this.trait_ == SapOuterClass$RequestGetCardInfo.getDefaultInstance()) {
            this.trait_ = sapOuterClass$RequestGetCardInfo;
        } else {
            this.trait_ = ((SapOuterClass$RequestGetCardInfo.a) SapOuterClass$RequestGetCardInfo.newBuilder((SapOuterClass$RequestGetCardInfo) this.trait_).v(sapOuterClass$RequestGetCardInfo)).j();
        }
        this.traitCase_ = GET_CARD_INFO_FIELD_NUMBER;
    }

    private void mergeGetCardTransferToken(BankOuterClass$RequestGetCardTransferToken bankOuterClass$RequestGetCardTransferToken) {
        bankOuterClass$RequestGetCardTransferToken.getClass();
        if (this.traitCase_ != 62125 || this.trait_ == BankOuterClass$RequestGetCardTransferToken.getDefaultInstance()) {
            this.trait_ = bankOuterClass$RequestGetCardTransferToken;
        } else {
            this.trait_ = ((BankOuterClass$RequestGetCardTransferToken.a) BankOuterClass$RequestGetCardTransferToken.newBuilder((BankOuterClass$RequestGetCardTransferToken) this.trait_).v(bankOuterClass$RequestGetCardTransferToken)).j();
        }
        this.traitCase_ = GET_CARD_TRANSFER_TOKEN_FIELD_NUMBER;
    }

    private void mergeGetCards(SapOuterClass$RequestGetCards sapOuterClass$RequestGetCards) {
        sapOuterClass$RequestGetCards.getClass();
        if (this.traitCase_ != 63558 || this.trait_ == SapOuterClass$RequestGetCards.getDefaultInstance()) {
            this.trait_ = sapOuterClass$RequestGetCards;
        } else {
            this.trait_ = ((SapOuterClass$RequestGetCards.a) SapOuterClass$RequestGetCards.newBuilder((SapOuterClass$RequestGetCards) this.trait_).v(sapOuterClass$RequestGetCards)).j();
        }
        this.traitCase_ = GET_CARDS_FIELD_NUMBER;
    }

    private void mergeGetChannelAds(AdvertisementOuterClass$RequestGetChannelAds advertisementOuterClass$RequestGetChannelAds) {
        advertisementOuterClass$RequestGetChannelAds.getClass();
        if (this.traitCase_ != 63264 || this.trait_ == AdvertisementOuterClass$RequestGetChannelAds.getDefaultInstance()) {
            this.trait_ = advertisementOuterClass$RequestGetChannelAds;
        } else {
            this.trait_ = ((AdvertisementOuterClass$RequestGetChannelAds.a) AdvertisementOuterClass$RequestGetChannelAds.newBuilder((AdvertisementOuterClass$RequestGetChannelAds) this.trait_).v(advertisementOuterClass$RequestGetChannelAds)).j();
        }
        this.traitCase_ = GET_CHANNEL_ADS_FIELD_NUMBER;
    }

    private void mergeGetChannelEarnMoneyInfo(AdvertisementOuterClass$RequestGetChannelEarnMoneyInfo advertisementOuterClass$RequestGetChannelEarnMoneyInfo) {
        advertisementOuterClass$RequestGetChannelEarnMoneyInfo.getClass();
        if (this.traitCase_ != 63447 || this.trait_ == AdvertisementOuterClass$RequestGetChannelEarnMoneyInfo.getDefaultInstance()) {
            this.trait_ = advertisementOuterClass$RequestGetChannelEarnMoneyInfo;
        } else {
            this.trait_ = ((AdvertisementOuterClass$RequestGetChannelEarnMoneyInfo.a) AdvertisementOuterClass$RequestGetChannelEarnMoneyInfo.newBuilder((AdvertisementOuterClass$RequestGetChannelEarnMoneyInfo) this.trait_).v(advertisementOuterClass$RequestGetChannelEarnMoneyInfo)).j();
        }
        this.traitCase_ = GET_CHANNEL_EARN_MONEY_INFO_FIELD_NUMBER;
    }

    private void mergeGetChannelEarnMoneyStatus(AdvertisementOuterClass$RequestGetChannelEarnMoneyStatus advertisementOuterClass$RequestGetChannelEarnMoneyStatus) {
        advertisementOuterClass$RequestGetChannelEarnMoneyStatus.getClass();
        if (this.traitCase_ != 63436 || this.trait_ == AdvertisementOuterClass$RequestGetChannelEarnMoneyStatus.getDefaultInstance()) {
            this.trait_ = advertisementOuterClass$RequestGetChannelEarnMoneyStatus;
        } else {
            this.trait_ = ((AdvertisementOuterClass$RequestGetChannelEarnMoneyStatus.a) AdvertisementOuterClass$RequestGetChannelEarnMoneyStatus.newBuilder((AdvertisementOuterClass$RequestGetChannelEarnMoneyStatus) this.trait_).v(advertisementOuterClass$RequestGetChannelEarnMoneyStatus)).j();
        }
        this.traitCase_ = GET_CHANNEL_EARN_MONEY_STATUS_FIELD_NUMBER;
    }

    private void mergeGetChargeAmounts(Saba$RequestGetChargeAmounts saba$RequestGetChargeAmounts) {
        saba$RequestGetChargeAmounts.getClass();
        if (this.traitCase_ != 63510 || this.trait_ == Saba$RequestGetChargeAmounts.getDefaultInstance()) {
            this.trait_ = saba$RequestGetChargeAmounts;
        } else {
            this.trait_ = ((Saba$RequestGetChargeAmounts.a) Saba$RequestGetChargeAmounts.newBuilder((Saba$RequestGetChargeAmounts) this.trait_).v(saba$RequestGetChargeAmounts)).j();
        }
        this.traitCase_ = GET_CHARGE_AMOUNTS_FIELD_NUMBER;
    }

    private void mergeGetChargePaymentToken(KifpoolOuterClass$RequestGetChargePaymentToken kifpoolOuterClass$RequestGetChargePaymentToken) {
        kifpoolOuterClass$RequestGetChargePaymentToken.getClass();
        if (this.traitCase_ != 63417 || this.trait_ == KifpoolOuterClass$RequestGetChargePaymentToken.getDefaultInstance()) {
            this.trait_ = kifpoolOuterClass$RequestGetChargePaymentToken;
        } else {
            this.trait_ = ((KifpoolOuterClass$RequestGetChargePaymentToken.a) KifpoolOuterClass$RequestGetChargePaymentToken.newBuilder((KifpoolOuterClass$RequestGetChargePaymentToken) this.trait_).v(kifpoolOuterClass$RequestGetChargePaymentToken)).j();
        }
        this.traitCase_ = GET_CHARGE_PAYMENT_TOKEN_FIELD_NUMBER;
    }

    private void mergeGetChargeTopupPaymentToken(Saba$RequestGetChargeTopupPaymentToken saba$RequestGetChargeTopupPaymentToken) {
        saba$RequestGetChargeTopupPaymentToken.getClass();
        if (this.traitCase_ != 63484 || this.trait_ == Saba$RequestGetChargeTopupPaymentToken.getDefaultInstance()) {
            this.trait_ = saba$RequestGetChargeTopupPaymentToken;
        } else {
            this.trait_ = ((Saba$RequestGetChargeTopupPaymentToken.a) Saba$RequestGetChargeTopupPaymentToken.newBuilder((Saba$RequestGetChargeTopupPaymentToken) this.trait_).v(saba$RequestGetChargeTopupPaymentToken)).j();
        }
        this.traitCase_ = GET_CHARGE_TOPUP_PAYMENT_TOKEN_FIELD_NUMBER;
    }

    private void mergeGetChargeVoucherPaymentToken(Saba$RequestGetChargeVoucherPaymentToken saba$RequestGetChargeVoucherPaymentToken) {
        saba$RequestGetChargeVoucherPaymentToken.getClass();
        if (this.traitCase_ != 63485 || this.trait_ == Saba$RequestGetChargeVoucherPaymentToken.getDefaultInstance()) {
            this.trait_ = saba$RequestGetChargeVoucherPaymentToken;
        } else {
            this.trait_ = ((Saba$RequestGetChargeVoucherPaymentToken.a) Saba$RequestGetChargeVoucherPaymentToken.newBuilder((Saba$RequestGetChargeVoucherPaymentToken) this.trait_).v(saba$RequestGetChargeVoucherPaymentToken)).j();
        }
        this.traitCase_ = GET_CHARGE_VOUCHER_PAYMENT_TOKEN_FIELD_NUMBER;
    }

    private void mergeGetCitiesOfState(SefteOuterClass$RequestGetCitiesOfState sefteOuterClass$RequestGetCitiesOfState) {
        sefteOuterClass$RequestGetCitiesOfState.getClass();
        if (this.traitCase_ != 63617 || this.trait_ == SefteOuterClass$RequestGetCitiesOfState.getDefaultInstance()) {
            this.trait_ = sefteOuterClass$RequestGetCitiesOfState;
        } else {
            this.trait_ = ((SefteOuterClass$RequestGetCitiesOfState.a) SefteOuterClass$RequestGetCitiesOfState.newBuilder((SefteOuterClass$RequestGetCitiesOfState) this.trait_).v(sefteOuterClass$RequestGetCitiesOfState)).j();
        }
        this.traitCase_ = GET_CITIES_OF_STATE_FIELD_NUMBER;
    }

    private void mergeGetContacts(UsersOuterClass$RequestGetContacts usersOuterClass$RequestGetContacts) {
        usersOuterClass$RequestGetContacts.getClass();
        if (this.traitCase_ != 87 || this.trait_ == UsersOuterClass$RequestGetContacts.getDefaultInstance()) {
            this.trait_ = usersOuterClass$RequestGetContacts;
        } else {
            this.trait_ = ((UsersOuterClass$RequestGetContacts.b) UsersOuterClass$RequestGetContacts.newBuilder((UsersOuterClass$RequestGetContacts) this.trait_).v(usersOuterClass$RequestGetContacts)).j();
        }
        this.traitCase_ = 87;
    }

    private void mergeGetCryptoChargePaymentToken(KifpoolOuterClass$RequestGetCryptoChargePaymentToken kifpoolOuterClass$RequestGetCryptoChargePaymentToken) {
        kifpoolOuterClass$RequestGetCryptoChargePaymentToken.getClass();
        if (this.traitCase_ != 63629 || this.trait_ == KifpoolOuterClass$RequestGetCryptoChargePaymentToken.getDefaultInstance()) {
            this.trait_ = kifpoolOuterClass$RequestGetCryptoChargePaymentToken;
        } else {
            this.trait_ = ((KifpoolOuterClass$RequestGetCryptoChargePaymentToken.a) KifpoolOuterClass$RequestGetCryptoChargePaymentToken.newBuilder((KifpoolOuterClass$RequestGetCryptoChargePaymentToken) this.trait_).v(kifpoolOuterClass$RequestGetCryptoChargePaymentToken)).j();
        }
        this.traitCase_ = GET_CRYPTO_CHARGE_PAYMENT_TOKEN_FIELD_NUMBER;
    }

    private void mergeGetCryptoWallets(KifpoolOuterClass$RequestGetCryptoWallets kifpoolOuterClass$RequestGetCryptoWallets) {
        kifpoolOuterClass$RequestGetCryptoWallets.getClass();
        if (this.traitCase_ != 63634 || this.trait_ == KifpoolOuterClass$RequestGetCryptoWallets.getDefaultInstance()) {
            this.trait_ = kifpoolOuterClass$RequestGetCryptoWallets;
        } else {
            this.trait_ = ((KifpoolOuterClass$RequestGetCryptoWallets.a) KifpoolOuterClass$RequestGetCryptoWallets.newBuilder((KifpoolOuterClass$RequestGetCryptoWallets) this.trait_).v(kifpoolOuterClass$RequestGetCryptoWallets)).j();
        }
        this.traitCase_ = GET_CRYPTO_WALLETS_FIELD_NUMBER;
    }

    private void mergeGetDefaultCard(SapOuterClass$RequestGetDefaultCard sapOuterClass$RequestGetDefaultCard) {
        sapOuterClass$RequestGetDefaultCard.getClass();
        if (this.traitCase_ != 63563 || this.trait_ == SapOuterClass$RequestGetDefaultCard.getDefaultInstance()) {
            this.trait_ = sapOuterClass$RequestGetDefaultCard;
        } else {
            this.trait_ = ((SapOuterClass$RequestGetDefaultCard.a) SapOuterClass$RequestGetDefaultCard.newBuilder((SapOuterClass$RequestGetDefaultCard) this.trait_).v(sapOuterClass$RequestGetDefaultCard)).j();
        }
        this.traitCase_ = GET_DEFAULT_CARD_FIELD_NUMBER;
    }

    private void mergeGetDestinationCardInfo(SapOuterClass$RequestGetDestinationCardInfo sapOuterClass$RequestGetDestinationCardInfo) {
        sapOuterClass$RequestGetDestinationCardInfo.getClass();
        if (this.traitCase_ != 63491 || this.trait_ == SapOuterClass$RequestGetDestinationCardInfo.getDefaultInstance()) {
            this.trait_ = sapOuterClass$RequestGetDestinationCardInfo;
        } else {
            this.trait_ = ((SapOuterClass$RequestGetDestinationCardInfo.a) SapOuterClass$RequestGetDestinationCardInfo.newBuilder((SapOuterClass$RequestGetDestinationCardInfo) this.trait_).v(sapOuterClass$RequestGetDestinationCardInfo)).j();
        }
        this.traitCase_ = GET_DESTINATION_CARD_INFO_FIELD_NUMBER;
    }

    private void mergeGetDestinationCards(SapOuterClass$RequestGetDestinationCards sapOuterClass$RequestGetDestinationCards) {
        sapOuterClass$RequestGetDestinationCards.getClass();
        if (this.traitCase_ != 63586 || this.trait_ == SapOuterClass$RequestGetDestinationCards.getDefaultInstance()) {
            this.trait_ = sapOuterClass$RequestGetDestinationCards;
        } else {
            this.trait_ = ((SapOuterClass$RequestGetDestinationCards.a) SapOuterClass$RequestGetDestinationCards.newBuilder((SapOuterClass$RequestGetDestinationCards) this.trait_).v(sapOuterClass$RequestGetDestinationCards)).j();
        }
        this.traitCase_ = GET_DESTINATION_CARDS_FIELD_NUMBER;
    }

    private void mergeGetDialogAdOrderDetails(AdvertisementOuterClass$RequestGetDialogAdOrderDetails advertisementOuterClass$RequestGetDialogAdOrderDetails) {
        advertisementOuterClass$RequestGetDialogAdOrderDetails.getClass();
        if (this.traitCase_ != 63568 || this.trait_ == AdvertisementOuterClass$RequestGetDialogAdOrderDetails.getDefaultInstance()) {
            this.trait_ = advertisementOuterClass$RequestGetDialogAdOrderDetails;
        } else {
            this.trait_ = ((AdvertisementOuterClass$RequestGetDialogAdOrderDetails.a) AdvertisementOuterClass$RequestGetDialogAdOrderDetails.newBuilder((AdvertisementOuterClass$RequestGetDialogAdOrderDetails) this.trait_).v(advertisementOuterClass$RequestGetDialogAdOrderDetails)).j();
        }
        this.traitCase_ = GET_DIALOG_AD_ORDER_DETAILS_FIELD_NUMBER;
    }

    private void mergeGetDialogAdOrderPaymentToken(AdvertisementOuterClass$RequestGetDialogAdOrderPaymentToken advertisementOuterClass$RequestGetDialogAdOrderPaymentToken) {
        advertisementOuterClass$RequestGetDialogAdOrderPaymentToken.getClass();
        if (this.traitCase_ != 63571 || this.trait_ == AdvertisementOuterClass$RequestGetDialogAdOrderPaymentToken.getDefaultInstance()) {
            this.trait_ = advertisementOuterClass$RequestGetDialogAdOrderPaymentToken;
        } else {
            this.trait_ = ((AdvertisementOuterClass$RequestGetDialogAdOrderPaymentToken.a) AdvertisementOuterClass$RequestGetDialogAdOrderPaymentToken.newBuilder((AdvertisementOuterClass$RequestGetDialogAdOrderPaymentToken) this.trait_).v(advertisementOuterClass$RequestGetDialogAdOrderPaymentToken)).j();
        }
        this.traitCase_ = GET_DIALOG_AD_ORDER_PAYMENT_TOKEN_FIELD_NUMBER;
    }

    private void mergeGetGiftPacketPaymentToken(Giftpacket$RequestGetGiftPacketPaymentToken giftpacket$RequestGetGiftPacketPaymentToken) {
        giftpacket$RequestGetGiftPacketPaymentToken.getClass();
        if (this.traitCase_ != 63232 || this.trait_ == Giftpacket$RequestGetGiftPacketPaymentToken.getDefaultInstance()) {
            this.trait_ = giftpacket$RequestGetGiftPacketPaymentToken;
        } else {
            this.trait_ = ((Giftpacket$RequestGetGiftPacketPaymentToken.a) Giftpacket$RequestGetGiftPacketPaymentToken.newBuilder((Giftpacket$RequestGetGiftPacketPaymentToken) this.trait_).v(giftpacket$RequestGetGiftPacketPaymentToken)).j();
        }
        this.traitCase_ = GET_GIFT_PACKET_PAYMENT_TOKEN_FIELD_NUMBER;
    }

    private void mergeGetGroupDefaultCardNumber(GroupsOuterClass$RequestGetGroupDefaultCardNumber groupsOuterClass$RequestGetGroupDefaultCardNumber) {
        groupsOuterClass$RequestGetGroupDefaultCardNumber.getClass();
        if (this.traitCase_ != 129 || this.trait_ == GroupsOuterClass$RequestGetGroupDefaultCardNumber.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$RequestGetGroupDefaultCardNumber;
        } else {
            this.trait_ = ((GroupsOuterClass$RequestGetGroupDefaultCardNumber.a) GroupsOuterClass$RequestGetGroupDefaultCardNumber.newBuilder((GroupsOuterClass$RequestGetGroupDefaultCardNumber) this.trait_).v(groupsOuterClass$RequestGetGroupDefaultCardNumber)).j();
        }
        this.traitCase_ = 129;
    }

    private void mergeGetGroupDifference(Sequence$RequestGetGroupDifference sequence$RequestGetGroupDifference) {
        sequence$RequestGetGroupDifference.getClass();
        if (this.traitCase_ != 187 || this.trait_ == Sequence$RequestGetGroupDifference.getDefaultInstance()) {
            this.trait_ = sequence$RequestGetGroupDifference;
        } else {
            this.trait_ = ((Sequence$RequestGetGroupDifference.b) Sequence$RequestGetGroupDifference.newBuilder((Sequence$RequestGetGroupDifference) this.trait_).v(sequence$RequestGetGroupDifference)).j();
        }
        this.traitCase_ = GET_GROUP_DIFFERENCE_FIELD_NUMBER;
    }

    private void mergeGetGroupInviteUrl(GroupsOuterClass$RequestGetGroupInviteUrl groupsOuterClass$RequestGetGroupInviteUrl) {
        groupsOuterClass$RequestGetGroupInviteUrl.getClass();
        if (this.traitCase_ != 177 || this.trait_ == GroupsOuterClass$RequestGetGroupInviteUrl.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$RequestGetGroupInviteUrl;
        } else {
            this.trait_ = ((GroupsOuterClass$RequestGetGroupInviteUrl.a) GroupsOuterClass$RequestGetGroupInviteUrl.newBuilder((GroupsOuterClass$RequestGetGroupInviteUrl) this.trait_).v(groupsOuterClass$RequestGetGroupInviteUrl)).j();
        }
        this.traitCase_ = GET_GROUP_INVITE_URL_FIELD_NUMBER;
    }

    private void mergeGetGroupMembersCount(GroupsOuterClass$RequestGetGroupMembersCount groupsOuterClass$RequestGetGroupMembersCount) {
        groupsOuterClass$RequestGetGroupMembersCount.getClass();
        if (this.traitCase_ != 63499 || this.trait_ == GroupsOuterClass$RequestGetGroupMembersCount.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$RequestGetGroupMembersCount;
        } else {
            this.trait_ = ((GroupsOuterClass$RequestGetGroupMembersCount.a) GroupsOuterClass$RequestGetGroupMembersCount.newBuilder((GroupsOuterClass$RequestGetGroupMembersCount) this.trait_).v(groupsOuterClass$RequestGetGroupMembersCount)).j();
        }
        this.traitCase_ = GET_GROUP_MEMBERS_COUNT_FIELD_NUMBER;
    }

    private void mergeGetGroupMembersPresence(PresenceOuterClass$RequestGetGroupMembersPresence presenceOuterClass$RequestGetGroupMembersPresence) {
        presenceOuterClass$RequestGetGroupMembersPresence.getClass();
        if (this.traitCase_ != 63642 || this.trait_ == PresenceOuterClass$RequestGetGroupMembersPresence.getDefaultInstance()) {
            this.trait_ = presenceOuterClass$RequestGetGroupMembersPresence;
        } else {
            this.trait_ = ((PresenceOuterClass$RequestGetGroupMembersPresence.a) PresenceOuterClass$RequestGetGroupMembersPresence.newBuilder((PresenceOuterClass$RequestGetGroupMembersPresence) this.trait_).v(presenceOuterClass$RequestGetGroupMembersPresence)).j();
        }
        this.traitCase_ = GET_GROUP_MEMBERS_PRESENCE_FIELD_NUMBER;
    }

    private void mergeGetGroupState(Sequence$RequestGetGroupState sequence$RequestGetGroupState) {
        sequence$RequestGetGroupState.getClass();
        if (this.traitCase_ != 153 || this.trait_ == Sequence$RequestGetGroupState.getDefaultInstance()) {
            this.trait_ = sequence$RequestGetGroupState;
        } else {
            this.trait_ = ((Sequence$RequestGetGroupState.b) Sequence$RequestGetGroupState.newBuilder((Sequence$RequestGetGroupState) this.trait_).v(sequence$RequestGetGroupState)).j();
        }
        this.traitCase_ = GET_GROUP_STATE_FIELD_NUMBER;
    }

    private void mergeGetInternetBundleList(Charnet$RequestGetInternetBundleList charnet$RequestGetInternetBundleList) {
        charnet$RequestGetInternetBundleList.getClass();
        if (this.traitCase_ != 63532 || this.trait_ == Charnet$RequestGetInternetBundleList.getDefaultInstance()) {
            this.trait_ = charnet$RequestGetInternetBundleList;
        } else {
            this.trait_ = ((Charnet$RequestGetInternetBundleList.a) Charnet$RequestGetInternetBundleList.newBuilder((Charnet$RequestGetInternetBundleList) this.trait_).v(charnet$RequestGetInternetBundleList)).j();
        }
        this.traitCase_ = GET_INTERNET_BUNDLE_LIST_FIELD_NUMBER;
    }

    private void mergeGetInternetBundlePaymentToken(Charnet$RequestGetInternetBundlePaymentToken charnet$RequestGetInternetBundlePaymentToken) {
        charnet$RequestGetInternetBundlePaymentToken.getClass();
        if (this.traitCase_ != 63530 || this.trait_ == Charnet$RequestGetInternetBundlePaymentToken.getDefaultInstance()) {
            this.trait_ = charnet$RequestGetInternetBundlePaymentToken;
        } else {
            this.trait_ = ((Charnet$RequestGetInternetBundlePaymentToken.a) Charnet$RequestGetInternetBundlePaymentToken.newBuilder((Charnet$RequestGetInternetBundlePaymentToken) this.trait_).v(charnet$RequestGetInternetBundlePaymentToken)).j();
        }
        this.traitCase_ = GET_INTERNET_BUNDLE_PAYMENT_TOKEN_FIELD_NUMBER;
    }

    private void mergeGetJwtToken(AuthOuterClass$RequestGetJWTToken authOuterClass$RequestGetJWTToken) {
        authOuterClass$RequestGetJWTToken.getClass();
        if (this.traitCase_ != 600 || this.trait_ == AuthOuterClass$RequestGetJWTToken.getDefaultInstance()) {
            this.trait_ = authOuterClass$RequestGetJWTToken;
        } else {
            this.trait_ = ((AuthOuterClass$RequestGetJWTToken.a) AuthOuterClass$RequestGetJWTToken.newBuilder((AuthOuterClass$RequestGetJWTToken) this.trait_).v(authOuterClass$RequestGetJWTToken)).j();
        }
        this.traitCase_ = GET_JWT_TOKEN_FIELD_NUMBER;
    }

    private void mergeGetKifpoolOwner(KifpoolOuterClass$RequestGetKifpoolOwner kifpoolOuterClass$RequestGetKifpoolOwner) {
        kifpoolOuterClass$RequestGetKifpoolOwner.getClass();
        if (this.traitCase_ != 63420 || this.trait_ == KifpoolOuterClass$RequestGetKifpoolOwner.getDefaultInstance()) {
            this.trait_ = kifpoolOuterClass$RequestGetKifpoolOwner;
        } else {
            this.trait_ = ((KifpoolOuterClass$RequestGetKifpoolOwner.a) KifpoolOuterClass$RequestGetKifpoolOwner.newBuilder((KifpoolOuterClass$RequestGetKifpoolOwner) this.trait_).v(kifpoolOuterClass$RequestGetKifpoolOwner)).j();
        }
        this.traitCase_ = GET_KIFPOOL_OWNER_FIELD_NUMBER;
    }

    private void mergeGetLinkPreview(EnrichmentOuterClass$RequestGetLinkPreview enrichmentOuterClass$RequestGetLinkPreview) {
        enrichmentOuterClass$RequestGetLinkPreview.getClass();
        if (this.traitCase_ != 63497 || this.trait_ == EnrichmentOuterClass$RequestGetLinkPreview.getDefaultInstance()) {
            this.trait_ = enrichmentOuterClass$RequestGetLinkPreview;
        } else {
            this.trait_ = ((EnrichmentOuterClass$RequestGetLinkPreview.a) EnrichmentOuterClass$RequestGetLinkPreview.newBuilder((EnrichmentOuterClass$RequestGetLinkPreview) this.trait_).v(enrichmentOuterClass$RequestGetLinkPreview)).j();
        }
        this.traitCase_ = GET_LINK_PREVIEW_FIELD_NUMBER;
    }

    private void mergeGetLoanInfo(MelonOuterClass$RequestGetLoanInfo melonOuterClass$RequestGetLoanInfo) {
        melonOuterClass$RequestGetLoanInfo.getClass();
        if (this.traitCase_ != 63582 || this.trait_ == MelonOuterClass$RequestGetLoanInfo.getDefaultInstance()) {
            this.trait_ = melonOuterClass$RequestGetLoanInfo;
        } else {
            this.trait_ = ((MelonOuterClass$RequestGetLoanInfo.a) MelonOuterClass$RequestGetLoanInfo.newBuilder((MelonOuterClass$RequestGetLoanInfo) this.trait_).v(melonOuterClass$RequestGetLoanInfo)).j();
        }
        this.traitCase_ = GET_LOAN_INFO_FIELD_NUMBER;
    }

    private void mergeGetLoansList(MelonOuterClass$RequestGetLoansList melonOuterClass$RequestGetLoansList) {
        melonOuterClass$RequestGetLoansList.getClass();
        if (this.traitCase_ != 63584 || this.trait_ == MelonOuterClass$RequestGetLoansList.getDefaultInstance()) {
            this.trait_ = melonOuterClass$RequestGetLoansList;
        } else {
            this.trait_ = ((MelonOuterClass$RequestGetLoansList.a) MelonOuterClass$RequestGetLoansList.newBuilder((MelonOuterClass$RequestGetLoansList) this.trait_).v(melonOuterClass$RequestGetLoansList)).j();
        }
        this.traitCase_ = GET_LOANS_LIST_FIELD_NUMBER;
    }

    private void mergeGetMemberPermissions(GroupsOuterClass$RequestGetMemberPermissions groupsOuterClass$RequestGetMemberPermissions) {
        groupsOuterClass$RequestGetMemberPermissions.getClass();
        if (this.traitCase_ != 63456 || this.trait_ == GroupsOuterClass$RequestGetMemberPermissions.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$RequestGetMemberPermissions;
        } else {
            this.trait_ = ((GroupsOuterClass$RequestGetMemberPermissions.a) GroupsOuterClass$RequestGetMemberPermissions.newBuilder((GroupsOuterClass$RequestGetMemberPermissions) this.trait_).v(groupsOuterClass$RequestGetMemberPermissions)).j();
        }
        this.traitCase_ = GET_MEMBER_PERMISSIONS_FIELD_NUMBER;
    }

    private void mergeGetMessagesRepliesInfo(MessagingOuterClass$RequestGetMessagesRepliesInfo messagingOuterClass$RequestGetMessagesRepliesInfo) {
        messagingOuterClass$RequestGetMessagesRepliesInfo.getClass();
        if (this.traitCase_ != 63663 || this.trait_ == MessagingOuterClass$RequestGetMessagesRepliesInfo.getDefaultInstance()) {
            this.trait_ = messagingOuterClass$RequestGetMessagesRepliesInfo;
        } else {
            this.trait_ = ((MessagingOuterClass$RequestGetMessagesRepliesInfo.a) MessagingOuterClass$RequestGetMessagesRepliesInfo.newBuilder((MessagingOuterClass$RequestGetMessagesRepliesInfo) this.trait_).v(messagingOuterClass$RequestGetMessagesRepliesInfo)).j();
        }
        this.traitCase_ = GET_MESSAGES_REPLIES_INFO_FIELD_NUMBER;
    }

    private void mergeGetMoneyRequestDetails(Microbanki$RequestGetMoneyRequestDetails microbanki$RequestGetMoneyRequestDetails) {
        microbanki$RequestGetMoneyRequestDetails.getClass();
        if (this.traitCase_ != 62393 || this.trait_ == Microbanki$RequestGetMoneyRequestDetails.getDefaultInstance()) {
            this.trait_ = microbanki$RequestGetMoneyRequestDetails;
        } else {
            this.trait_ = ((Microbanki$RequestGetMoneyRequestDetails.a) Microbanki$RequestGetMoneyRequestDetails.newBuilder((Microbanki$RequestGetMoneyRequestDetails) this.trait_).v(microbanki$RequestGetMoneyRequestDetails)).j();
        }
        this.traitCase_ = GET_MONEY_REQUEST_DETAILS_FIELD_NUMBER;
    }

    private void mergeGetMoneyRequestPaymentList(Microbanki$RequestGetMoneyRequestPaymentList microbanki$RequestGetMoneyRequestPaymentList) {
        microbanki$RequestGetMoneyRequestPaymentList.getClass();
        if (this.traitCase_ != 62401 || this.trait_ == Microbanki$RequestGetMoneyRequestPaymentList.getDefaultInstance()) {
            this.trait_ = microbanki$RequestGetMoneyRequestPaymentList;
        } else {
            this.trait_ = ((Microbanki$RequestGetMoneyRequestPaymentList.a) Microbanki$RequestGetMoneyRequestPaymentList.newBuilder((Microbanki$RequestGetMoneyRequestPaymentList) this.trait_).v(microbanki$RequestGetMoneyRequestPaymentList)).j();
        }
        this.traitCase_ = GET_MONEY_REQUEST_PAYMENT_LIST_FIELD_NUMBER;
    }

    private void mergeGetMoneyRequestPaymentTokenByCard(WalletOuterClass$RequestGetMoneyRequestPaymentTokenByCard walletOuterClass$RequestGetMoneyRequestPaymentTokenByCard) {
        walletOuterClass$RequestGetMoneyRequestPaymentTokenByCard.getClass();
        if (this.traitCase_ != 62769 || this.trait_ == WalletOuterClass$RequestGetMoneyRequestPaymentTokenByCard.getDefaultInstance()) {
            this.trait_ = walletOuterClass$RequestGetMoneyRequestPaymentTokenByCard;
        } else {
            this.trait_ = ((WalletOuterClass$RequestGetMoneyRequestPaymentTokenByCard.a) WalletOuterClass$RequestGetMoneyRequestPaymentTokenByCard.newBuilder((WalletOuterClass$RequestGetMoneyRequestPaymentTokenByCard) this.trait_).v(walletOuterClass$RequestGetMoneyRequestPaymentTokenByCard)).j();
        }
        this.traitCase_ = GET_MONEY_REQUEST_PAYMENT_TOKEN_BY_CARD_FIELD_NUMBER;
    }

    private void mergeGetMyBank(MyBankOuterClass$RequestGetMyBank myBankOuterClass$RequestGetMyBank) {
        myBankOuterClass$RequestGetMyBank.getClass();
        if (this.traitCase_ != 63243 || this.trait_ == MyBankOuterClass$RequestGetMyBank.getDefaultInstance()) {
            this.trait_ = myBankOuterClass$RequestGetMyBank;
        } else {
            this.trait_ = ((MyBankOuterClass$RequestGetMyBank.a) MyBankOuterClass$RequestGetMyBank.newBuilder((MyBankOuterClass$RequestGetMyBank) this.trait_).v(myBankOuterClass$RequestGetMyBank)).j();
        }
        this.traitCase_ = GET_MY_BANK_FIELD_NUMBER;
    }

    private void mergeGetMyGroups(GroupsOuterClass$RequestGetMyGroups groupsOuterClass$RequestGetMyGroups) {
        groupsOuterClass$RequestGetMyGroups.getClass();
        if (this.traitCase_ != 43746 || this.trait_ == GroupsOuterClass$RequestGetMyGroups.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$RequestGetMyGroups;
        } else {
            this.trait_ = ((GroupsOuterClass$RequestGetMyGroups.a) GroupsOuterClass$RequestGetMyGroups.newBuilder((GroupsOuterClass$RequestGetMyGroups) this.trait_).v(groupsOuterClass$RequestGetMyGroups)).j();
        }
        this.traitCase_ = GET_MY_GROUPS_FIELD_NUMBER;
    }

    private void mergeGetMyKifpools(KifpoolOuterClass$RequestGetMyKifpools kifpoolOuterClass$RequestGetMyKifpools) {
        kifpoolOuterClass$RequestGetMyKifpools.getClass();
        if (this.traitCase_ != 63400 || this.trait_ == KifpoolOuterClass$RequestGetMyKifpools.getDefaultInstance()) {
            this.trait_ = kifpoolOuterClass$RequestGetMyKifpools;
        } else {
            this.trait_ = ((KifpoolOuterClass$RequestGetMyKifpools.a) KifpoolOuterClass$RequestGetMyKifpools.newBuilder((KifpoolOuterClass$RequestGetMyKifpools) this.trait_).v(kifpoolOuterClass$RequestGetMyKifpools)).j();
        }
        this.traitCase_ = GET_MY_KIFPOOLS_FIELD_NUMBER;
    }

    private void mergeGetMySentence(SentenceOuterClass$RequestGetMySentence sentenceOuterClass$RequestGetMySentence) {
        sentenceOuterClass$RequestGetMySentence.getClass();
        if (this.traitCase_ != 63573 || this.trait_ == SentenceOuterClass$RequestGetMySentence.getDefaultInstance()) {
            this.trait_ = sentenceOuterClass$RequestGetMySentence;
        } else {
            this.trait_ = ((SentenceOuterClass$RequestGetMySentence.a) SentenceOuterClass$RequestGetMySentence.newBuilder((SentenceOuterClass$RequestGetMySentence) this.trait_).v(sentenceOuterClass$RequestGetMySentence)).j();
        }
        this.traitCase_ = GET_MY_SENTENCE_FIELD_NUMBER;
    }

    private void mergeGetMyWallets(WalletOuterClass$RequestGetMyWallets walletOuterClass$RequestGetMyWallets) {
        walletOuterClass$RequestGetMyWallets.getClass();
        if (this.traitCase_ != 62730 || this.trait_ == WalletOuterClass$RequestGetMyWallets.getDefaultInstance()) {
            this.trait_ = walletOuterClass$RequestGetMyWallets;
        } else {
            this.trait_ = ((WalletOuterClass$RequestGetMyWallets.a) WalletOuterClass$RequestGetMyWallets.newBuilder((WalletOuterClass$RequestGetMyWallets) this.trait_).v(walletOuterClass$RequestGetMyWallets)).j();
        }
        this.traitCase_ = GET_MY_WALLETS_FIELD_NUMBER;
    }

    private void mergeGetNasimFilePublicUrl(FilesOuterClass$RequestGetNasimFilePublicUrl filesOuterClass$RequestGetNasimFilePublicUrl) {
        filesOuterClass$RequestGetNasimFilePublicUrl.getClass();
        if (this.traitCase_ != 3072 || this.trait_ == FilesOuterClass$RequestGetNasimFilePublicUrl.getDefaultInstance()) {
            this.trait_ = filesOuterClass$RequestGetNasimFilePublicUrl;
        } else {
            this.trait_ = ((FilesOuterClass$RequestGetNasimFilePublicUrl.a) FilesOuterClass$RequestGetNasimFilePublicUrl.newBuilder((FilesOuterClass$RequestGetNasimFilePublicUrl) this.trait_).v(filesOuterClass$RequestGetNasimFilePublicUrl)).j();
        }
        this.traitCase_ = GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER;
    }

    private void mergeGetNasimFileUploadResume(FilesOuterClass$RequestGetNasimFileUploadResume filesOuterClass$RequestGetNasimFileUploadResume) {
        filesOuterClass$RequestGetNasimFileUploadResume.getClass();
        if (this.traitCase_ != 3071 || this.trait_ == FilesOuterClass$RequestGetNasimFileUploadResume.getDefaultInstance()) {
            this.trait_ = filesOuterClass$RequestGetNasimFileUploadResume;
        } else {
            this.trait_ = ((FilesOuterClass$RequestGetNasimFileUploadResume.a) FilesOuterClass$RequestGetNasimFileUploadResume.newBuilder((FilesOuterClass$RequestGetNasimFileUploadResume) this.trait_).v(filesOuterClass$RequestGetNasimFileUploadResume)).j();
        }
        this.traitCase_ = GET_NASIM_FILE_UPLOAD_RESUME_FIELD_NUMBER;
    }

    private void mergeGetNasimFileUploadUrl(FilesOuterClass$RequestGetNasimFileUploadUrl filesOuterClass$RequestGetNasimFileUploadUrl) {
        filesOuterClass$RequestGetNasimFileUploadUrl.getClass();
        if (this.traitCase_ != 143 || this.trait_ == FilesOuterClass$RequestGetNasimFileUploadUrl.getDefaultInstance()) {
            this.trait_ = filesOuterClass$RequestGetNasimFileUploadUrl;
        } else {
            this.trait_ = ((FilesOuterClass$RequestGetNasimFileUploadUrl.a) FilesOuterClass$RequestGetNasimFileUploadUrl.newBuilder((FilesOuterClass$RequestGetNasimFileUploadUrl) this.trait_).v(filesOuterClass$RequestGetNasimFileUploadUrl)).j();
        }
        this.traitCase_ = GET_NASIM_FILE_UPLOAD_URL_FIELD_NUMBER;
    }

    private void mergeGetNasimFileUrl(FilesOuterClass$RequestGetNasimFileUrl filesOuterClass$RequestGetNasimFileUrl) {
        filesOuterClass$RequestGetNasimFileUrl.getClass();
        if (this.traitCase_ != 2815 || this.trait_ == FilesOuterClass$RequestGetNasimFileUrl.getDefaultInstance()) {
            this.trait_ = filesOuterClass$RequestGetNasimFileUrl;
        } else {
            this.trait_ = ((FilesOuterClass$RequestGetNasimFileUrl.a) FilesOuterClass$RequestGetNasimFileUrl.newBuilder((FilesOuterClass$RequestGetNasimFileUrl) this.trait_).v(filesOuterClass$RequestGetNasimFileUrl)).j();
        }
        this.traitCase_ = GET_NASIM_FILE_URL_FIELD_NUMBER;
    }

    private void mergeGetNasimFileUrls(FilesOuterClass$RequestGetNasimFileUrls filesOuterClass$RequestGetNasimFileUrls) {
        filesOuterClass$RequestGetNasimFileUrls.getClass();
        if (this.traitCase_ != 2591 || this.trait_ == FilesOuterClass$RequestGetNasimFileUrls.getDefaultInstance()) {
            this.trait_ = filesOuterClass$RequestGetNasimFileUrls;
        } else {
            this.trait_ = ((FilesOuterClass$RequestGetNasimFileUrls.a) FilesOuterClass$RequestGetNasimFileUrls.newBuilder((FilesOuterClass$RequestGetNasimFileUrls) this.trait_).v(filesOuterClass$RequestGetNasimFileUrls)).j();
        }
        this.traitCase_ = GET_NASIM_FILE_URLS_FIELD_NUMBER;
    }

    private void mergeGetOtpTokenV2(BankOuterClass$RequestGetOTPTokenV2 bankOuterClass$RequestGetOTPTokenV2) {
        bankOuterClass$RequestGetOTPTokenV2.getClass();
        if (this.traitCase_ != 63258 || this.trait_ == BankOuterClass$RequestGetOTPTokenV2.getDefaultInstance()) {
            this.trait_ = bankOuterClass$RequestGetOTPTokenV2;
        } else {
            this.trait_ = ((BankOuterClass$RequestGetOTPTokenV2.a) BankOuterClass$RequestGetOTPTokenV2.newBuilder((BankOuterClass$RequestGetOTPTokenV2) this.trait_).v(bankOuterClass$RequestGetOTPTokenV2)).j();
        }
        this.traitCase_ = GET_OTP_TOKEN_V2_FIELD_NUMBER;
    }

    private void mergeGetOtptoken(BankOuterClass$RequestGetOTPToken bankOuterClass$RequestGetOTPToken) {
        bankOuterClass$RequestGetOTPToken.getClass();
        if (this.traitCase_ != 62761 || this.trait_ == BankOuterClass$RequestGetOTPToken.getDefaultInstance()) {
            this.trait_ = bankOuterClass$RequestGetOTPToken;
        } else {
            this.trait_ = ((BankOuterClass$RequestGetOTPToken.a) BankOuterClass$RequestGetOTPToken.newBuilder((BankOuterClass$RequestGetOTPToken) this.trait_).v(bankOuterClass$RequestGetOTPToken)).j();
        }
        this.traitCase_ = GET_OTPTOKEN_FIELD_NUMBER;
    }

    private void mergeGetPacket(WarriorOuterClass$RequestGetPacket warriorOuterClass$RequestGetPacket) {
        warriorOuterClass$RequestGetPacket.getClass();
        if (this.traitCase_ != 63604 || this.trait_ == WarriorOuterClass$RequestGetPacket.getDefaultInstance()) {
            this.trait_ = warriorOuterClass$RequestGetPacket;
        } else {
            this.trait_ = ((WarriorOuterClass$RequestGetPacket.a) WarriorOuterClass$RequestGetPacket.newBuilder((WarriorOuterClass$RequestGetPacket) this.trait_).v(warriorOuterClass$RequestGetPacket)).j();
        }
        this.traitCase_ = GET_PACKET_FIELD_NUMBER;
    }

    private void mergeGetPacketsStatus(WarriorOuterClass$RequestGetPacketsStatus warriorOuterClass$RequestGetPacketsStatus) {
        warriorOuterClass$RequestGetPacketsStatus.getClass();
        if (this.traitCase_ != 63597 || this.trait_ == WarriorOuterClass$RequestGetPacketsStatus.getDefaultInstance()) {
            this.trait_ = warriorOuterClass$RequestGetPacketsStatus;
        } else {
            this.trait_ = ((WarriorOuterClass$RequestGetPacketsStatus.a) WarriorOuterClass$RequestGetPacketsStatus.newBuilder((WarriorOuterClass$RequestGetPacketsStatus) this.trait_).v(warriorOuterClass$RequestGetPacketsStatus)).j();
        }
        this.traitCase_ = GET_PACKETS_STATUS_FIELD_NUMBER;
    }

    private void mergeGetParameters(ConfigsOuterClass$RequestGetParameters configsOuterClass$RequestGetParameters) {
        configsOuterClass$RequestGetParameters.getClass();
        if (this.traitCase_ != 134 || this.trait_ == ConfigsOuterClass$RequestGetParameters.getDefaultInstance()) {
            this.trait_ = configsOuterClass$RequestGetParameters;
        } else {
            this.trait_ = ((ConfigsOuterClass$RequestGetParameters.a) ConfigsOuterClass$RequestGetParameters.newBuilder((ConfigsOuterClass$RequestGetParameters) this.trait_).v(configsOuterClass$RequestGetParameters)).j();
        }
        this.traitCase_ = 134;
    }

    private void mergeGetParticipants(Crowdfunding$RequestGetParticipants crowdfunding$RequestGetParticipants) {
        crowdfunding$RequestGetParticipants.getClass();
        if (this.traitCase_ != 63512 || this.trait_ == Crowdfunding$RequestGetParticipants.getDefaultInstance()) {
            this.trait_ = crowdfunding$RequestGetParticipants;
        } else {
            this.trait_ = ((Crowdfunding$RequestGetParticipants.a) Crowdfunding$RequestGetParticipants.newBuilder((Crowdfunding$RequestGetParticipants) this.trait_).v(crowdfunding$RequestGetParticipants)).j();
        }
        this.traitCase_ = GET_PARTICIPANTS_FIELD_NUMBER;
    }

    private void mergeGetPayMoneyRequestToken(BankOuterClass$RequestGetPayMoneyRequestToken bankOuterClass$RequestGetPayMoneyRequestToken) {
        bankOuterClass$RequestGetPayMoneyRequestToken.getClass();
        if (this.traitCase_ != 62127 || this.trait_ == BankOuterClass$RequestGetPayMoneyRequestToken.getDefaultInstance()) {
            this.trait_ = bankOuterClass$RequestGetPayMoneyRequestToken;
        } else {
            this.trait_ = ((BankOuterClass$RequestGetPayMoneyRequestToken.a) BankOuterClass$RequestGetPayMoneyRequestToken.newBuilder((BankOuterClass$RequestGetPayMoneyRequestToken) this.trait_).v(bankOuterClass$RequestGetPayMoneyRequestToken)).j();
        }
        this.traitCase_ = GET_PAY_MONEY_REQUEST_TOKEN_FIELD_NUMBER;
    }

    private void mergeGetPaymentToken(BankOuterClass$RequestGetPaymentToken bankOuterClass$RequestGetPaymentToken) {
        bankOuterClass$RequestGetPaymentToken.getClass();
        if (this.traitCase_ != 62408 || this.trait_ == BankOuterClass$RequestGetPaymentToken.getDefaultInstance()) {
            this.trait_ = bankOuterClass$RequestGetPaymentToken;
        } else {
            this.trait_ = ((BankOuterClass$RequestGetPaymentToken.a) BankOuterClass$RequestGetPaymentToken.newBuilder((BankOuterClass$RequestGetPaymentToken) this.trait_).v(bankOuterClass$RequestGetPaymentToken)).j();
        }
        this.traitCase_ = GET_PAYMENT_TOKEN_FIELD_NUMBER;
    }

    private void mergeGetPaymentTokenByCard(WalletOuterClass$RequestGetPaymentTokenByCard walletOuterClass$RequestGetPaymentTokenByCard) {
        walletOuterClass$RequestGetPaymentTokenByCard.getClass();
        if (this.traitCase_ != 62747 || this.trait_ == WalletOuterClass$RequestGetPaymentTokenByCard.getDefaultInstance()) {
            this.trait_ = walletOuterClass$RequestGetPaymentTokenByCard;
        } else {
            this.trait_ = ((WalletOuterClass$RequestGetPaymentTokenByCard.a) WalletOuterClass$RequestGetPaymentTokenByCard.newBuilder((WalletOuterClass$RequestGetPaymentTokenByCard) this.trait_).v(walletOuterClass$RequestGetPaymentTokenByCard)).j();
        }
        this.traitCase_ = GET_PAYMENT_TOKEN_BY_CARD_FIELD_NUMBER;
    }

    private void mergeGetPayvandCard(BankOuterClass$RequestGetPayvandCard bankOuterClass$RequestGetPayvandCard) {
        bankOuterClass$RequestGetPayvandCard.getClass();
        if (this.traitCase_ != 62132 || this.trait_ == BankOuterClass$RequestGetPayvandCard.getDefaultInstance()) {
            this.trait_ = bankOuterClass$RequestGetPayvandCard;
        } else {
            this.trait_ = ((BankOuterClass$RequestGetPayvandCard.a) BankOuterClass$RequestGetPayvandCard.newBuilder((BankOuterClass$RequestGetPayvandCard) this.trait_).v(bankOuterClass$RequestGetPayvandCard)).j();
        }
        this.traitCase_ = GET_PAYVAND_CARD_FIELD_NUMBER;
    }

    private void mergeGetPayvandCardList(BankOuterClass$RequestGetPayvandCardList bankOuterClass$RequestGetPayvandCardList) {
        bankOuterClass$RequestGetPayvandCardList.getClass();
        if (this.traitCase_ != 62130 || this.trait_ == BankOuterClass$RequestGetPayvandCardList.getDefaultInstance()) {
            this.trait_ = bankOuterClass$RequestGetPayvandCardList;
        } else {
            this.trait_ = ((BankOuterClass$RequestGetPayvandCardList.a) BankOuterClass$RequestGetPayvandCardList.newBuilder((BankOuterClass$RequestGetPayvandCardList) this.trait_).v(bankOuterClass$RequestGetPayvandCardList)).j();
        }
        this.traitCase_ = GET_PAYVAND_CARD_LIST_FIELD_NUMBER;
    }

    private void mergeGetPointBalance(KifpoolOuterClass$RequestGetPointBalance kifpoolOuterClass$RequestGetPointBalance) {
        kifpoolOuterClass$RequestGetPointBalance.getClass();
        if (this.traitCase_ != 63434 || this.trait_ == KifpoolOuterClass$RequestGetPointBalance.getDefaultInstance()) {
            this.trait_ = kifpoolOuterClass$RequestGetPointBalance;
        } else {
            this.trait_ = ((KifpoolOuterClass$RequestGetPointBalance.a) KifpoolOuterClass$RequestGetPointBalance.newBuilder((KifpoolOuterClass$RequestGetPointBalance) this.trait_).v(kifpoolOuterClass$RequestGetPointBalance)).j();
        }
        this.traitCase_ = GET_POINT_BALANCE_FIELD_NUMBER;
    }

    private void mergeGetPointDetails(KifpoolOuterClass$RequestGetPointDetails kifpoolOuterClass$RequestGetPointDetails) {
        kifpoolOuterClass$RequestGetPointDetails.getClass();
        if (this.traitCase_ != 63458 || this.trait_ == KifpoolOuterClass$RequestGetPointDetails.getDefaultInstance()) {
            this.trait_ = kifpoolOuterClass$RequestGetPointDetails;
        } else {
            this.trait_ = ((KifpoolOuterClass$RequestGetPointDetails.a) KifpoolOuterClass$RequestGetPointDetails.newBuilder((KifpoolOuterClass$RequestGetPointDetails) this.trait_).v(kifpoolOuterClass$RequestGetPointDetails)).j();
        }
        this.traitCase_ = GET_POINT_DETAILS_FIELD_NUMBER;
    }

    private void mergeGetPointSummery(KifpoolOuterClass$RequestGetPointSummery kifpoolOuterClass$RequestGetPointSummery) {
        kifpoolOuterClass$RequestGetPointSummery.getClass();
        if (this.traitCase_ != 63451 || this.trait_ == KifpoolOuterClass$RequestGetPointSummery.getDefaultInstance()) {
            this.trait_ = kifpoolOuterClass$RequestGetPointSummery;
        } else {
            this.trait_ = ((KifpoolOuterClass$RequestGetPointSummery.a) KifpoolOuterClass$RequestGetPointSummery.newBuilder((KifpoolOuterClass$RequestGetPointSummery) this.trait_).v(kifpoolOuterClass$RequestGetPointSummery)).j();
        }
        this.traitCase_ = GET_POINT_SUMMERY_FIELD_NUMBER;
    }

    private void mergeGetPsproxyPaymentToken(BankOuterClass$RequestGetPSProxyPaymentToken bankOuterClass$RequestGetPSProxyPaymentToken) {
        bankOuterClass$RequestGetPSProxyPaymentToken.getClass();
        if (this.traitCase_ != 53258 || this.trait_ == BankOuterClass$RequestGetPSProxyPaymentToken.getDefaultInstance()) {
            this.trait_ = bankOuterClass$RequestGetPSProxyPaymentToken;
        } else {
            this.trait_ = ((BankOuterClass$RequestGetPSProxyPaymentToken.a) BankOuterClass$RequestGetPSProxyPaymentToken.newBuilder((BankOuterClass$RequestGetPSProxyPaymentToken) this.trait_).v(bankOuterClass$RequestGetPSProxyPaymentToken)).j();
        }
        this.traitCase_ = GET_PSPROXY_PAYMENT_TOKEN_FIELD_NUMBER;
    }

    private void mergeGetPsproxyToken(BankOuterClass$RequestGetPSProxyToken bankOuterClass$RequestGetPSProxyToken) {
        bankOuterClass$RequestGetPSProxyToken.getClass();
        if (this.traitCase_ != 53256 || this.trait_ == BankOuterClass$RequestGetPSProxyToken.getDefaultInstance()) {
            this.trait_ = bankOuterClass$RequestGetPSProxyToken;
        } else {
            this.trait_ = ((BankOuterClass$RequestGetPSProxyToken.a) BankOuterClass$RequestGetPSProxyToken.newBuilder((BankOuterClass$RequestGetPSProxyToken) this.trait_).v(bankOuterClass$RequestGetPSProxyToken)).j();
        }
        this.traitCase_ = GET_PSPROXY_TOKEN_FIELD_NUMBER;
    }

    private void mergeGetReactions(ReactionsOuterClass$RequestGetReactions reactionsOuterClass$RequestGetReactions) {
        reactionsOuterClass$RequestGetReactions.getClass();
        if (this.traitCase_ != 63254 || this.trait_ == ReactionsOuterClass$RequestGetReactions.getDefaultInstance()) {
            this.trait_ = reactionsOuterClass$RequestGetReactions;
        } else {
            this.trait_ = ((ReactionsOuterClass$RequestGetReactions.a) ReactionsOuterClass$RequestGetReactions.newBuilder((ReactionsOuterClass$RequestGetReactions) this.trait_).v(reactionsOuterClass$RequestGetReactions)).j();
        }
        this.traitCase_ = GET_REACTIONS_FIELD_NUMBER;
    }

    private void mergeGetRecentCharges(BankOuterClass$RequestGetRecentCharges bankOuterClass$RequestGetRecentCharges) {
        bankOuterClass$RequestGetRecentCharges.getClass();
        if (this.traitCase_ != 62412 || this.trait_ == BankOuterClass$RequestGetRecentCharges.getDefaultInstance()) {
            this.trait_ = bankOuterClass$RequestGetRecentCharges;
        } else {
            this.trait_ = ((BankOuterClass$RequestGetRecentCharges.a) BankOuterClass$RequestGetRecentCharges.newBuilder((BankOuterClass$RequestGetRecentCharges) this.trait_).v(bankOuterClass$RequestGetRecentCharges)).j();
        }
        this.traitCase_ = GET_RECENT_CHARGES_FIELD_NUMBER;
    }

    private void mergeGetRecentInternetBundleOrders(Charnet$RequestGetRecentInternetBundleOrders charnet$RequestGetRecentInternetBundleOrders) {
        charnet$RequestGetRecentInternetBundleOrders.getClass();
        if (this.traitCase_ != 63534 || this.trait_ == Charnet$RequestGetRecentInternetBundleOrders.getDefaultInstance()) {
            this.trait_ = charnet$RequestGetRecentInternetBundleOrders;
        } else {
            this.trait_ = ((Charnet$RequestGetRecentInternetBundleOrders.a) Charnet$RequestGetRecentInternetBundleOrders.newBuilder((Charnet$RequestGetRecentInternetBundleOrders) this.trait_).v(charnet$RequestGetRecentInternetBundleOrders)).j();
        }
        this.traitCase_ = GET_RECENT_INTERNET_BUNDLE_ORDERS_FIELD_NUMBER;
    }

    private void mergeGetRecentOrders(Saba$RequestGetRecentOrders saba$RequestGetRecentOrders) {
        saba$RequestGetRecentOrders.getClass();
        if (this.traitCase_ != 63507 || this.trait_ == Saba$RequestGetRecentOrders.getDefaultInstance()) {
            this.trait_ = saba$RequestGetRecentOrders;
        } else {
            this.trait_ = ((Saba$RequestGetRecentOrders.b) Saba$RequestGetRecentOrders.newBuilder((Saba$RequestGetRecentOrders) this.trait_).v(saba$RequestGetRecentOrders)).j();
        }
        this.traitCase_ = GET_RECENT_ORDERS_FIELD_NUMBER;
    }

    private void mergeGetRecipients(SefteOuterClass$RequestGetRecipients sefteOuterClass$RequestGetRecipients) {
        sefteOuterClass$RequestGetRecipients.getClass();
        if (this.traitCase_ != 63626 || this.trait_ == SefteOuterClass$RequestGetRecipients.getDefaultInstance()) {
            this.trait_ = sefteOuterClass$RequestGetRecipients;
        } else {
            this.trait_ = ((SefteOuterClass$RequestGetRecipients.a) SefteOuterClass$RequestGetRecipients.newBuilder((SefteOuterClass$RequestGetRecipients) this.trait_).v(sefteOuterClass$RequestGetRecipients)).j();
        }
        this.traitCase_ = GET_RECIPIENTS_FIELD_NUMBER;
    }

    private void mergeGetReferencedEntitites(Sequence$RequestGetReferencedEntitites sequence$RequestGetReferencedEntitites) {
        sequence$RequestGetReferencedEntitites.getClass();
        if (this.traitCase_ != 2628 || this.trait_ == Sequence$RequestGetReferencedEntitites.getDefaultInstance()) {
            this.trait_ = sequence$RequestGetReferencedEntitites;
        } else {
            this.trait_ = ((Sequence$RequestGetReferencedEntitites.a) Sequence$RequestGetReferencedEntitites.newBuilder((Sequence$RequestGetReferencedEntitites) this.trait_).v(sequence$RequestGetReferencedEntitites)).j();
        }
        this.traitCase_ = 2628;
    }

    private void mergeGetReferralCode(ReferralOuterClass$RequestGetReferralCode referralOuterClass$RequestGetReferralCode) {
        referralOuterClass$RequestGetReferralCode.getClass();
        if (this.traitCase_ != 63500 || this.trait_ == ReferralOuterClass$RequestGetReferralCode.getDefaultInstance()) {
            this.trait_ = referralOuterClass$RequestGetReferralCode;
        } else {
            this.trait_ = ((ReferralOuterClass$RequestGetReferralCode.a) ReferralOuterClass$RequestGetReferralCode.newBuilder((ReferralOuterClass$RequestGetReferralCode) this.trait_).v(referralOuterClass$RequestGetReferralCode)).j();
        }
        this.traitCase_ = GET_REFERRAL_CODE_FIELD_NUMBER;
    }

    private void mergeGetReferralContacts(WarriorOuterClass$RequestGetReferralContacts warriorOuterClass$RequestGetReferralContacts) {
        warriorOuterClass$RequestGetReferralContacts.getClass();
        if (this.traitCase_ != 63601 || this.trait_ == WarriorOuterClass$RequestGetReferralContacts.getDefaultInstance()) {
            this.trait_ = warriorOuterClass$RequestGetReferralContacts;
        } else {
            this.trait_ = ((WarriorOuterClass$RequestGetReferralContacts.a) WarriorOuterClass$RequestGetReferralContacts.newBuilder((WarriorOuterClass$RequestGetReferralContacts) this.trait_).v(warriorOuterClass$RequestGetReferralContacts)).j();
        }
        this.traitCase_ = GET_REFERRAL_CONTACTS_FIELD_NUMBER;
    }

    private void mergeGetReferredCount(ReferralOuterClass$RequestGetReferredCount referralOuterClass$RequestGetReferredCount) {
        referralOuterClass$RequestGetReferredCount.getClass();
        if (this.traitCase_ != 63477 || this.trait_ == ReferralOuterClass$RequestGetReferredCount.getDefaultInstance()) {
            this.trait_ = referralOuterClass$RequestGetReferredCount;
        } else {
            this.trait_ = ((ReferralOuterClass$RequestGetReferredCount.a) ReferralOuterClass$RequestGetReferredCount.newBuilder((ReferralOuterClass$RequestGetReferredCount) this.trait_).v(referralOuterClass$RequestGetReferredCount)).j();
        }
        this.traitCase_ = GET_REFERRED_COUNT_FIELD_NUMBER;
    }

    private void mergeGetReferringUser(ReferralOuterClass$RequestGetReferringUser referralOuterClass$RequestGetReferringUser) {
        referralOuterClass$RequestGetReferringUser.getClass();
        if (this.traitCase_ != 63460 || this.trait_ == ReferralOuterClass$RequestGetReferringUser.getDefaultInstance()) {
            this.trait_ = referralOuterClass$RequestGetReferringUser;
        } else {
            this.trait_ = ((ReferralOuterClass$RequestGetReferringUser.a) ReferralOuterClass$RequestGetReferringUser.newBuilder((ReferralOuterClass$RequestGetReferringUser) this.trait_).v(referralOuterClass$RequestGetReferringUser)).j();
        }
        this.traitCase_ = GET_REFERRING_USER_FIELD_NUMBER;
    }

    private void mergeGetRemainToken(BankOuterClass$RequestGetRemainToken bankOuterClass$RequestGetRemainToken) {
        bankOuterClass$RequestGetRemainToken.getClass();
        if (this.traitCase_ != 58106 || this.trait_ == BankOuterClass$RequestGetRemainToken.getDefaultInstance()) {
            this.trait_ = bankOuterClass$RequestGetRemainToken;
        } else {
            this.trait_ = ((BankOuterClass$RequestGetRemainToken.a) BankOuterClass$RequestGetRemainToken.newBuilder((BankOuterClass$RequestGetRemainToken) this.trait_).v(bankOuterClass$RequestGetRemainToken)).j();
        }
        this.traitCase_ = GET_REMAIN_TOKEN_FIELD_NUMBER;
    }

    private void mergeGetSadadPsppaymentToken(BankOuterClass$RequestGetSadadPSPPaymentToken bankOuterClass$RequestGetSadadPSPPaymentToken) {
        bankOuterClass$RequestGetSadadPSPPaymentToken.getClass();
        if (this.traitCase_ != 62180 || this.trait_ == BankOuterClass$RequestGetSadadPSPPaymentToken.getDefaultInstance()) {
            this.trait_ = bankOuterClass$RequestGetSadadPSPPaymentToken;
        } else {
            this.trait_ = ((BankOuterClass$RequestGetSadadPSPPaymentToken.a) BankOuterClass$RequestGetSadadPSPPaymentToken.newBuilder((BankOuterClass$RequestGetSadadPSPPaymentToken) this.trait_).v(bankOuterClass$RequestGetSadadPSPPaymentToken)).j();
        }
        this.traitCase_ = GET_SADAD_PSPPAYMENT_TOKEN_FIELD_NUMBER;
    }

    private void mergeGetSavedBills(BillOuterClass$RequestGetSavedBills billOuterClass$RequestGetSavedBills) {
        billOuterClass$RequestGetSavedBills.getClass();
        if (this.traitCase_ != 63551 || this.trait_ == BillOuterClass$RequestGetSavedBills.getDefaultInstance()) {
            this.trait_ = billOuterClass$RequestGetSavedBills;
        } else {
            this.trait_ = ((BillOuterClass$RequestGetSavedBills.a) BillOuterClass$RequestGetSavedBills.newBuilder((BillOuterClass$RequestGetSavedBills) this.trait_).v(billOuterClass$RequestGetSavedBills)).j();
        }
        this.traitCase_ = GET_SAVED_BILLS_FIELD_NUMBER;
    }

    private void mergeGetScoreBoard(WarriorOuterClass$RequestGetScoreBoard warriorOuterClass$RequestGetScoreBoard) {
        warriorOuterClass$RequestGetScoreBoard.getClass();
        if (this.traitCase_ != 63593 || this.trait_ == WarriorOuterClass$RequestGetScoreBoard.getDefaultInstance()) {
            this.trait_ = warriorOuterClass$RequestGetScoreBoard;
        } else {
            this.trait_ = ((WarriorOuterClass$RequestGetScoreBoard.a) WarriorOuterClass$RequestGetScoreBoard.newBuilder((WarriorOuterClass$RequestGetScoreBoard) this.trait_).v(warriorOuterClass$RequestGetScoreBoard)).j();
        }
        this.traitCase_ = GET_SCORE_BOARD_FIELD_NUMBER;
    }

    private void mergeGetState(Sequence$RequestGetState sequence$RequestGetState) {
        sequence$RequestGetState.getClass();
        if (this.traitCase_ != 9 || this.trait_ == Sequence$RequestGetState.getDefaultInstance()) {
            this.trait_ = sequence$RequestGetState;
        } else {
            this.trait_ = ((Sequence$RequestGetState.b) Sequence$RequestGetState.newBuilder((Sequence$RequestGetState) this.trait_).v(sequence$RequestGetState)).j();
        }
        this.traitCase_ = 9;
    }

    private void mergeGetStates(SefteOuterClass$RequestGetStates sefteOuterClass$RequestGetStates) {
        sefteOuterClass$RequestGetStates.getClass();
        if (this.traitCase_ != 63615 || this.trait_ == SefteOuterClass$RequestGetStates.getDefaultInstance()) {
            this.trait_ = sefteOuterClass$RequestGetStates;
        } else {
            this.trait_ = ((SefteOuterClass$RequestGetStates.a) SefteOuterClass$RequestGetStates.newBuilder((SefteOuterClass$RequestGetStates) this.trait_).v(sefteOuterClass$RequestGetStates)).j();
        }
        this.traitCase_ = GET_STATES_FIELD_NUMBER;
    }

    private void mergeGetSubTransactions(PfmOuterClass$RequestGetSubTransactions pfmOuterClass$RequestGetSubTransactions) {
        pfmOuterClass$RequestGetSubTransactions.getClass();
        if (this.traitCase_ != 63653 || this.trait_ == PfmOuterClass$RequestGetSubTransactions.getDefaultInstance()) {
            this.trait_ = pfmOuterClass$RequestGetSubTransactions;
        } else {
            this.trait_ = ((PfmOuterClass$RequestGetSubTransactions.a) PfmOuterClass$RequestGetSubTransactions.newBuilder((PfmOuterClass$RequestGetSubTransactions) this.trait_).v(pfmOuterClass$RequestGetSubTransactions)).j();
        }
        this.traitCase_ = GET_SUB_TRANSACTIONS_FIELD_NUMBER;
    }

    private void mergeGetTotalPaidAmount(Crowdfunding$RequestGetTotalPaidAmount crowdfunding$RequestGetTotalPaidAmount) {
        crowdfunding$RequestGetTotalPaidAmount.getClass();
        if (this.traitCase_ != 63527 || this.trait_ == Crowdfunding$RequestGetTotalPaidAmount.getDefaultInstance()) {
            this.trait_ = crowdfunding$RequestGetTotalPaidAmount;
        } else {
            this.trait_ = ((Crowdfunding$RequestGetTotalPaidAmount.a) Crowdfunding$RequestGetTotalPaidAmount.newBuilder((Crowdfunding$RequestGetTotalPaidAmount) this.trait_).v(crowdfunding$RequestGetTotalPaidAmount)).j();
        }
        this.traitCase_ = GET_TOTAL_PAID_AMOUNT_FIELD_NUMBER;
    }

    private void mergeGetTransactionTags(PfmOuterClass$RequestGetTransactionTags pfmOuterClass$RequestGetTransactionTags) {
        pfmOuterClass$RequestGetTransactionTags.getClass();
        if (this.traitCase_ != 63516 || this.trait_ == PfmOuterClass$RequestGetTransactionTags.getDefaultInstance()) {
            this.trait_ = pfmOuterClass$RequestGetTransactionTags;
        } else {
            this.trait_ = ((PfmOuterClass$RequestGetTransactionTags.a) PfmOuterClass$RequestGetTransactionTags.newBuilder((PfmOuterClass$RequestGetTransactionTags) this.trait_).v(pfmOuterClass$RequestGetTransactionTags)).j();
        }
        this.traitCase_ = GET_TRANSACTION_TAGS_FIELD_NUMBER;
    }

    private void mergeGetUserAccounts(PfmOuterClass$RequestGetUserAccounts pfmOuterClass$RequestGetUserAccounts) {
        pfmOuterClass$RequestGetUserAccounts.getClass();
        if (this.traitCase_ != 63443 || this.trait_ == PfmOuterClass$RequestGetUserAccounts.getDefaultInstance()) {
            this.trait_ = pfmOuterClass$RequestGetUserAccounts;
        } else {
            this.trait_ = ((PfmOuterClass$RequestGetUserAccounts.a) PfmOuterClass$RequestGetUserAccounts.newBuilder((PfmOuterClass$RequestGetUserAccounts) this.trait_).v(pfmOuterClass$RequestGetUserAccounts)).j();
        }
        this.traitCase_ = GET_USER_ACCOUNTS_FIELD_NUMBER;
    }

    private void mergeGetUserBank(VitrineOuterClass$RequestGetUserBank vitrineOuterClass$RequestGetUserBank) {
        vitrineOuterClass$RequestGetUserBank.getClass();
        if (this.traitCase_ != 63522 || this.trait_ == VitrineOuterClass$RequestGetUserBank.getDefaultInstance()) {
            this.trait_ = vitrineOuterClass$RequestGetUserBank;
        } else {
            this.trait_ = ((VitrineOuterClass$RequestGetUserBank.a) VitrineOuterClass$RequestGetUserBank.newBuilder((VitrineOuterClass$RequestGetUserBank) this.trait_).v(vitrineOuterClass$RequestGetUserBank)).j();
        }
        this.traitCase_ = GET_USER_BANK_FIELD_NUMBER;
    }

    private void mergeGetUserContext(KetfOuterClass$RequestGetUserContext ketfOuterClass$RequestGetUserContext) {
        ketfOuterClass$RequestGetUserContext.getClass();
        if (this.traitCase_ != 137 || this.trait_ == KetfOuterClass$RequestGetUserContext.getDefaultInstance()) {
            this.trait_ = ketfOuterClass$RequestGetUserContext;
        } else {
            this.trait_ = ((KetfOuterClass$RequestGetUserContext.a) KetfOuterClass$RequestGetUserContext.newBuilder((KetfOuterClass$RequestGetUserContext) this.trait_).v(ketfOuterClass$RequestGetUserContext)).j();
        }
        this.traitCase_ = 137;
    }

    private void mergeGetUserRefers(WarriorOuterClass$RequestGetUserRefers warriorOuterClass$RequestGetUserRefers) {
        warriorOuterClass$RequestGetUserRefers.getClass();
        if (this.traitCase_ != 63599 || this.trait_ == WarriorOuterClass$RequestGetUserRefers.getDefaultInstance()) {
            this.trait_ = warriorOuterClass$RequestGetUserRefers;
        } else {
            this.trait_ = ((WarriorOuterClass$RequestGetUserRefers.a) WarriorOuterClass$RequestGetUserRefers.newBuilder((WarriorOuterClass$RequestGetUserRefers) this.trait_).v(warriorOuterClass$RequestGetUserRefers)).j();
        }
        this.traitCase_ = GET_USER_REFERS_FIELD_NUMBER;
    }

    private void mergeGetUserScore(WarriorOuterClass$RequestGetUserScore warriorOuterClass$RequestGetUserScore) {
        warriorOuterClass$RequestGetUserScore.getClass();
        if (this.traitCase_ != 63595 || this.trait_ == WarriorOuterClass$RequestGetUserScore.getDefaultInstance()) {
            this.trait_ = warriorOuterClass$RequestGetUserScore;
        } else {
            this.trait_ = ((WarriorOuterClass$RequestGetUserScore.a) WarriorOuterClass$RequestGetUserScore.newBuilder((WarriorOuterClass$RequestGetUserScore) this.trait_).v(warriorOuterClass$RequestGetUserScore)).j();
        }
        this.traitCase_ = GET_USER_SCORE_FIELD_NUMBER;
    }

    private void mergeGetUserSeftes(SefteOuterClass$RequestGetUserSeftes sefteOuterClass$RequestGetUserSeftes) {
        sefteOuterClass$RequestGetUserSeftes.getClass();
        if (this.traitCase_ != 63620 || this.trait_ == SefteOuterClass$RequestGetUserSeftes.getDefaultInstance()) {
            this.trait_ = sefteOuterClass$RequestGetUserSeftes;
        } else {
            this.trait_ = ((SefteOuterClass$RequestGetUserSeftes.a) SefteOuterClass$RequestGetUserSeftes.newBuilder((SefteOuterClass$RequestGetUserSeftes) this.trait_).v(sefteOuterClass$RequestGetUserSeftes)).j();
        }
        this.traitCase_ = GET_USER_SEFTES_FIELD_NUMBER;
    }

    private void mergeGetUserStatus(AdvertisementOuterClass$RequestGetUserStatus advertisementOuterClass$RequestGetUserStatus) {
        advertisementOuterClass$RequestGetUserStatus.getClass();
        if (this.traitCase_ != 63441 || this.trait_ == AdvertisementOuterClass$RequestGetUserStatus.getDefaultInstance()) {
            this.trait_ = advertisementOuterClass$RequestGetUserStatus;
        } else {
            this.trait_ = ((AdvertisementOuterClass$RequestGetUserStatus.a) AdvertisementOuterClass$RequestGetUserStatus.newBuilder((AdvertisementOuterClass$RequestGetUserStatus) this.trait_).v(advertisementOuterClass$RequestGetUserStatus)).j();
        }
        this.traitCase_ = GET_USER_STATUS_FIELD_NUMBER;
    }

    private void mergeGetUserTags(PfmOuterClass$RequestGetUserTags pfmOuterClass$RequestGetUserTags) {
        pfmOuterClass$RequestGetUserTags.getClass();
        if (this.traitCase_ != 63520 || this.trait_ == PfmOuterClass$RequestGetUserTags.getDefaultInstance()) {
            this.trait_ = pfmOuterClass$RequestGetUserTags;
        } else {
            this.trait_ = ((PfmOuterClass$RequestGetUserTags.a) PfmOuterClass$RequestGetUserTags.newBuilder((PfmOuterClass$RequestGetUserTags) this.trait_).v(pfmOuterClass$RequestGetUserTags)).j();
        }
        this.traitCase_ = GET_USER_TAGS_FIELD_NUMBER;
    }

    private void mergeGetUserVitrine(VitrineOuterClass$RequestGetUserVitrine vitrineOuterClass$RequestGetUserVitrine) {
        vitrineOuterClass$RequestGetUserVitrine.getClass();
        if (this.traitCase_ != 63256 || this.trait_ == VitrineOuterClass$RequestGetUserVitrine.getDefaultInstance()) {
            this.trait_ = vitrineOuterClass$RequestGetUserVitrine;
        } else {
            this.trait_ = ((VitrineOuterClass$RequestGetUserVitrine.a) VitrineOuterClass$RequestGetUserVitrine.newBuilder((VitrineOuterClass$RequestGetUserVitrine) this.trait_).v(vitrineOuterClass$RequestGetUserVitrine)).j();
        }
        this.traitCase_ = GET_USER_VITRINE_FIELD_NUMBER;
    }

    private void mergeGetUsersDefaultCardNumber(UsersOuterClass$RequestGetUsersDefaultCardNumber usersOuterClass$RequestGetUsersDefaultCardNumber) {
        usersOuterClass$RequestGetUsersDefaultCardNumber.getClass();
        if (this.traitCase_ != 63541 || this.trait_ == UsersOuterClass$RequestGetUsersDefaultCardNumber.getDefaultInstance()) {
            this.trait_ = usersOuterClass$RequestGetUsersDefaultCardNumber;
        } else {
            this.trait_ = ((UsersOuterClass$RequestGetUsersDefaultCardNumber.a) UsersOuterClass$RequestGetUsersDefaultCardNumber.newBuilder((UsersOuterClass$RequestGetUsersDefaultCardNumber) this.trait_).v(usersOuterClass$RequestGetUsersDefaultCardNumber)).j();
        }
        this.traitCase_ = GET_USERS_DEFAULT_CARD_NUMBER_FIELD_NUMBER;
    }

    private void mergeGetUsersPresence(PresenceOuterClass$RequestGetUsersPresence presenceOuterClass$RequestGetUsersPresence) {
        presenceOuterClass$RequestGetUsersPresence.getClass();
        if (this.traitCase_ != 63644 || this.trait_ == PresenceOuterClass$RequestGetUsersPresence.getDefaultInstance()) {
            this.trait_ = presenceOuterClass$RequestGetUsersPresence;
        } else {
            this.trait_ = ((PresenceOuterClass$RequestGetUsersPresence.a) PresenceOuterClass$RequestGetUsersPresence.newBuilder((PresenceOuterClass$RequestGetUsersPresence) this.trait_).v(presenceOuterClass$RequestGetUsersPresence)).j();
        }
        this.traitCase_ = GET_USERS_PRESENCE_FIELD_NUMBER;
    }

    private void mergeGetVouchers(ClubOuterClass$RequestGetVouchers clubOuterClass$RequestGetVouchers) {
        clubOuterClass$RequestGetVouchers.getClass();
        if (this.traitCase_ != 63472 || this.trait_ == ClubOuterClass$RequestGetVouchers.getDefaultInstance()) {
            this.trait_ = clubOuterClass$RequestGetVouchers;
        } else {
            this.trait_ = ((ClubOuterClass$RequestGetVouchers.a) ClubOuterClass$RequestGetVouchers.newBuilder((ClubOuterClass$RequestGetVouchers) this.trait_).v(clubOuterClass$RequestGetVouchers)).j();
        }
        this.traitCase_ = GET_VOUCHERS_FIELD_NUMBER;
    }

    private void mergeGetWalletChargeToken(WalletOuterClass$RequestGetWalletChargeToken walletOuterClass$RequestGetWalletChargeToken) {
        walletOuterClass$RequestGetWalletChargeToken.getClass();
        if (this.traitCase_ != 62733 || this.trait_ == WalletOuterClass$RequestGetWalletChargeToken.getDefaultInstance()) {
            this.trait_ = walletOuterClass$RequestGetWalletChargeToken;
        } else {
            this.trait_ = ((WalletOuterClass$RequestGetWalletChargeToken.a) WalletOuterClass$RequestGetWalletChargeToken.newBuilder((WalletOuterClass$RequestGetWalletChargeToken) this.trait_).v(walletOuterClass$RequestGetWalletChargeToken)).j();
        }
        this.traitCase_ = GET_WALLET_CHARGE_TOKEN_FIELD_NUMBER;
    }

    private void mergeGetWalletContracts(WalletOuterClass$RequestGetWalletContracts walletOuterClass$RequestGetWalletContracts) {
        walletOuterClass$RequestGetWalletContracts.getClass();
        if (this.traitCase_ != 62758 || this.trait_ == WalletOuterClass$RequestGetWalletContracts.getDefaultInstance()) {
            this.trait_ = walletOuterClass$RequestGetWalletContracts;
        } else {
            this.trait_ = ((WalletOuterClass$RequestGetWalletContracts.a) WalletOuterClass$RequestGetWalletContracts.newBuilder((WalletOuterClass$RequestGetWalletContracts) this.trait_).v(walletOuterClass$RequestGetWalletContracts)).j();
        }
        this.traitCase_ = GET_WALLET_CONTRACTS_FIELD_NUMBER;
    }

    private void mergeGetWalletInvoice(WalletOuterClass$RequestGetWalletInvoice walletOuterClass$RequestGetWalletInvoice) {
        walletOuterClass$RequestGetWalletInvoice.getClass();
        if (this.traitCase_ != 62752 || this.trait_ == WalletOuterClass$RequestGetWalletInvoice.getDefaultInstance()) {
            this.trait_ = walletOuterClass$RequestGetWalletInvoice;
        } else {
            this.trait_ = ((WalletOuterClass$RequestGetWalletInvoice.a) WalletOuterClass$RequestGetWalletInvoice.newBuilder((WalletOuterClass$RequestGetWalletInvoice) this.trait_).v(walletOuterClass$RequestGetWalletInvoice)).j();
        }
        this.traitCase_ = GET_WALLET_INVOICE_FIELD_NUMBER;
    }

    private void mergeGetWebviewTrackingNumber(Saba$RequestGetWebViewTrackingNumber saba$RequestGetWebViewTrackingNumber) {
        saba$RequestGetWebViewTrackingNumber.getClass();
        if (this.traitCase_ != 63481 || this.trait_ == Saba$RequestGetWebViewTrackingNumber.getDefaultInstance()) {
            this.trait_ = saba$RequestGetWebViewTrackingNumber;
        } else {
            this.trait_ = ((Saba$RequestGetWebViewTrackingNumber.a) Saba$RequestGetWebViewTrackingNumber.newBuilder((Saba$RequestGetWebViewTrackingNumber) this.trait_).v(saba$RequestGetWebViewTrackingNumber)).j();
        }
        this.traitCase_ = GET_WEBVIEW_TRACKING_NUMBER_FIELD_NUMBER;
    }

    private void mergeGetWheel(ClubOuterClass$RequestGetWheel clubOuterClass$RequestGetWheel) {
        clubOuterClass$RequestGetWheel.getClass();
        if (this.traitCase_ != 63468 || this.trait_ == ClubOuterClass$RequestGetWheel.getDefaultInstance()) {
            this.trait_ = clubOuterClass$RequestGetWheel;
        } else {
            this.trait_ = ((ClubOuterClass$RequestGetWheel.a) ClubOuterClass$RequestGetWheel.newBuilder((ClubOuterClass$RequestGetWheel) this.trait_).v(clubOuterClass$RequestGetWheel)).j();
        }
        this.traitCase_ = GET_WHEEL_FIELD_NUMBER;
    }

    private void mergeGrantBankiAccess(BankOuterClass$RequestGrantBankiAccess bankOuterClass$RequestGrantBankiAccess) {
        bankOuterClass$RequestGrantBankiAccess.getClass();
        if (this.traitCase_ != 62397 || this.trait_ == BankOuterClass$RequestGrantBankiAccess.getDefaultInstance()) {
            this.trait_ = bankOuterClass$RequestGrantBankiAccess;
        } else {
            this.trait_ = ((BankOuterClass$RequestGrantBankiAccess.a) BankOuterClass$RequestGrantBankiAccess.newBuilder((BankOuterClass$RequestGrantBankiAccess) this.trait_).v(bankOuterClass$RequestGrantBankiAccess)).j();
        }
        this.traitCase_ = GRANT_BANKI_ACCESS_FIELD_NUMBER;
    }

    private void mergeImportContacts(UsersOuterClass$RequestImportContacts usersOuterClass$RequestImportContacts) {
        usersOuterClass$RequestImportContacts.getClass();
        if (this.traitCase_ != 7 || this.trait_ == UsersOuterClass$RequestImportContacts.getDefaultInstance()) {
            this.trait_ = usersOuterClass$RequestImportContacts;
        } else {
            this.trait_ = ((UsersOuterClass$RequestImportContacts.b) UsersOuterClass$RequestImportContacts.newBuilder((UsersOuterClass$RequestImportContacts) this.trait_).v(usersOuterClass$RequestImportContacts)).j();
        }
        this.traitCase_ = 7;
    }

    private void mergeInitP12(SefteOuterClass$RequestInitP12 sefteOuterClass$RequestInitP12) {
        sefteOuterClass$RequestInitP12.getClass();
        if (this.traitCase_ != 63608 || this.trait_ == SefteOuterClass$RequestInitP12.getDefaultInstance()) {
            this.trait_ = sefteOuterClass$RequestInitP12;
        } else {
            this.trait_ = ((SefteOuterClass$RequestInitP12.a) SefteOuterClass$RequestInitP12.newBuilder((SefteOuterClass$RequestInitP12) this.trait_).v(sefteOuterClass$RequestInitP12)).j();
        }
        this.traitCase_ = INIT_P12_FIELD_NUMBER;
    }

    private void mergeInitSefte(SefteOuterClass$RequestInitSefte sefteOuterClass$RequestInitSefte) {
        sefteOuterClass$RequestInitSefte.getClass();
        if (this.traitCase_ != 63610 || this.trait_ == SefteOuterClass$RequestInitSefte.getDefaultInstance()) {
            this.trait_ = sefteOuterClass$RequestInitSefte;
        } else {
            this.trait_ = ((SefteOuterClass$RequestInitSefte.a) SefteOuterClass$RequestInitSefte.newBuilder((SefteOuterClass$RequestInitSefte) this.trait_).v(sefteOuterClass$RequestInitSefte)).j();
        }
        this.traitCase_ = INIT_SEFTE_FIELD_NUMBER;
    }

    private void mergeInquiryBill(BillOuterClass$RequestInquiryBill billOuterClass$RequestInquiryBill) {
        billOuterClass$RequestInquiryBill.getClass();
        if (this.traitCase_ != 63543 || this.trait_ == BillOuterClass$RequestInquiryBill.getDefaultInstance()) {
            this.trait_ = billOuterClass$RequestInquiryBill;
        } else {
            this.trait_ = ((BillOuterClass$RequestInquiryBill.a) BillOuterClass$RequestInquiryBill.newBuilder((BillOuterClass$RequestInquiryBill) this.trait_).v(billOuterClass$RequestInquiryBill)).j();
        }
        this.traitCase_ = INQUIRY_BILL_FIELD_NUMBER;
    }

    private void mergeInviteUser(GroupsOuterClass$RequestInviteUser groupsOuterClass$RequestInviteUser) {
        groupsOuterClass$RequestInviteUser.getClass();
        if (this.traitCase_ != 69 || this.trait_ == GroupsOuterClass$RequestInviteUser.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$RequestInviteUser;
        } else {
            this.trait_ = ((GroupsOuterClass$RequestInviteUser.b) GroupsOuterClass$RequestInviteUser.newBuilder((GroupsOuterClass$RequestInviteUser) this.trait_).v(groupsOuterClass$RequestInviteUser)).j();
        }
        this.traitCase_ = 69;
    }

    private void mergeInvoiceKifpool(KifpoolOuterClass$RequestInvoiceKifpool kifpoolOuterClass$RequestInvoiceKifpool) {
        kifpoolOuterClass$RequestInvoiceKifpool.getClass();
        if (this.traitCase_ != 63409 || this.trait_ == KifpoolOuterClass$RequestInvoiceKifpool.getDefaultInstance()) {
            this.trait_ = kifpoolOuterClass$RequestInvoiceKifpool;
        } else {
            this.trait_ = ((KifpoolOuterClass$RequestInvoiceKifpool.a) KifpoolOuterClass$RequestInvoiceKifpool.newBuilder((KifpoolOuterClass$RequestInvoiceKifpool) this.trait_).v(kifpoolOuterClass$RequestInvoiceKifpool)).j();
        }
        this.traitCase_ = INVOICE_KIFPOOL_FIELD_NUMBER;
    }

    private void mergeJoinGroup(GroupsOuterClass$RequestJoinGroup groupsOuterClass$RequestJoinGroup) {
        groupsOuterClass$RequestJoinGroup.getClass();
        if (this.traitCase_ != 180 || this.trait_ == GroupsOuterClass$RequestJoinGroup.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$RequestJoinGroup;
        } else {
            this.trait_ = ((GroupsOuterClass$RequestJoinGroup.b) GroupsOuterClass$RequestJoinGroup.newBuilder((GroupsOuterClass$RequestJoinGroup) this.trait_).v(groupsOuterClass$RequestJoinGroup)).j();
        }
        this.traitCase_ = JOIN_GROUP_FIELD_NUMBER;
    }

    private void mergeJoinPublicGroup(GroupsOuterClass$RequestJoinPublicGroup groupsOuterClass$RequestJoinPublicGroup) {
        groupsOuterClass$RequestJoinPublicGroup.getClass();
        if (this.traitCase_ != 2881 || this.trait_ == GroupsOuterClass$RequestJoinPublicGroup.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$RequestJoinPublicGroup;
        } else {
            this.trait_ = ((GroupsOuterClass$RequestJoinPublicGroup.b) GroupsOuterClass$RequestJoinPublicGroup.newBuilder((GroupsOuterClass$RequestJoinPublicGroup) this.trait_).v(groupsOuterClass$RequestJoinPublicGroup)).j();
        }
        this.traitCase_ = JOIN_PUBLIC_GROUP_FIELD_NUMBER;
    }

    private void mergeKickUser(GroupsOuterClass$RequestKickUser groupsOuterClass$RequestKickUser) {
        groupsOuterClass$RequestKickUser.getClass();
        if (this.traitCase_ != 71 || this.trait_ == GroupsOuterClass$RequestKickUser.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$RequestKickUser;
        } else {
            this.trait_ = ((GroupsOuterClass$RequestKickUser.b) GroupsOuterClass$RequestKickUser.newBuilder((GroupsOuterClass$RequestKickUser) this.trait_).v(groupsOuterClass$RequestKickUser)).j();
        }
        this.traitCase_ = 71;
    }

    private void mergeLeaveGroup(GroupsOuterClass$RequestLeaveGroup groupsOuterClass$RequestLeaveGroup) {
        groupsOuterClass$RequestLeaveGroup.getClass();
        if (this.traitCase_ != 70 || this.trait_ == GroupsOuterClass$RequestLeaveGroup.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$RequestLeaveGroup;
        } else {
            this.trait_ = ((GroupsOuterClass$RequestLeaveGroup.b) GroupsOuterClass$RequestLeaveGroup.newBuilder((GroupsOuterClass$RequestLeaveGroup) this.trait_).v(groupsOuterClass$RequestLeaveGroup)).j();
        }
        this.traitCase_ = 70;
    }

    private void mergeLoadArchived(MessagingOuterClass$RequestLoadArchived messagingOuterClass$RequestLoadArchived) {
        messagingOuterClass$RequestLoadArchived.getClass();
        if (this.traitCase_ != 2651 || this.trait_ == MessagingOuterClass$RequestLoadArchived.getDefaultInstance()) {
            this.trait_ = messagingOuterClass$RequestLoadArchived;
        } else {
            this.trait_ = ((MessagingOuterClass$RequestLoadArchived.b) MessagingOuterClass$RequestLoadArchived.newBuilder((MessagingOuterClass$RequestLoadArchived) this.trait_).v(messagingOuterClass$RequestLoadArchived)).j();
        }
        this.traitCase_ = LOAD_ARCHIVED_FIELD_NUMBER;
    }

    private void mergeLoadAvatars(UsersOuterClass$RequestLoadAvatars usersOuterClass$RequestLoadAvatars) {
        usersOuterClass$RequestLoadAvatars.getClass();
        if (this.traitCase_ != 2656 || this.trait_ == UsersOuterClass$RequestLoadAvatars.getDefaultInstance()) {
            this.trait_ = usersOuterClass$RequestLoadAvatars;
        } else {
            this.trait_ = ((UsersOuterClass$RequestLoadAvatars.a) UsersOuterClass$RequestLoadAvatars.newBuilder((UsersOuterClass$RequestLoadAvatars) this.trait_).v(usersOuterClass$RequestLoadAvatars)).j();
        }
        this.traitCase_ = LOAD_AVATARS_FIELD_NUMBER;
    }

    private void mergeLoadBlockedUsers(UsersOuterClass$RequestLoadBlockedUsers usersOuterClass$RequestLoadBlockedUsers) {
        usersOuterClass$RequestLoadBlockedUsers.getClass();
        if (this.traitCase_ != 2638 || this.trait_ == UsersOuterClass$RequestLoadBlockedUsers.getDefaultInstance()) {
            this.trait_ = usersOuterClass$RequestLoadBlockedUsers;
        } else {
            this.trait_ = ((UsersOuterClass$RequestLoadBlockedUsers.a) UsersOuterClass$RequestLoadBlockedUsers.newBuilder((UsersOuterClass$RequestLoadBlockedUsers) this.trait_).v(usersOuterClass$RequestLoadBlockedUsers)).j();
        }
        this.traitCase_ = LOAD_BLOCKED_USERS_FIELD_NUMBER;
    }

    private void mergeLoadDialogs(MessagingOuterClass$RequestLoadDialogs messagingOuterClass$RequestLoadDialogs) {
        messagingOuterClass$RequestLoadDialogs.getClass();
        if (this.traitCase_ != 104 || this.trait_ == MessagingOuterClass$RequestLoadDialogs.getDefaultInstance()) {
            this.trait_ = messagingOuterClass$RequestLoadDialogs;
        } else {
            this.trait_ = ((MessagingOuterClass$RequestLoadDialogs.b) MessagingOuterClass$RequestLoadDialogs.newBuilder((MessagingOuterClass$RequestLoadDialogs) this.trait_).v(messagingOuterClass$RequestLoadDialogs)).j();
        }
        this.traitCase_ = 104;
    }

    private void mergeLoadFullGroups(GroupsOuterClass$RequestLoadFullGroups groupsOuterClass$RequestLoadFullGroups) {
        groupsOuterClass$RequestLoadFullGroups.getClass();
        if (this.traitCase_ != 2782 || this.trait_ == GroupsOuterClass$RequestLoadFullGroups.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$RequestLoadFullGroups;
        } else {
            this.trait_ = ((GroupsOuterClass$RequestLoadFullGroups.a) GroupsOuterClass$RequestLoadFullGroups.newBuilder((GroupsOuterClass$RequestLoadFullGroups) this.trait_).v(groupsOuterClass$RequestLoadFullGroups)).j();
        }
        this.traitCase_ = LOAD_FULL_GROUPS_FIELD_NUMBER;
    }

    private void mergeLoadFullUsers(UsersOuterClass$RequestLoadFullUsers usersOuterClass$RequestLoadFullUsers) {
        usersOuterClass$RequestLoadFullUsers.getClass();
        if (this.traitCase_ != 2649 || this.trait_ == UsersOuterClass$RequestLoadFullUsers.getDefaultInstance()) {
            this.trait_ = usersOuterClass$RequestLoadFullUsers;
        } else {
            this.trait_ = ((UsersOuterClass$RequestLoadFullUsers.a) UsersOuterClass$RequestLoadFullUsers.newBuilder((UsersOuterClass$RequestLoadFullUsers) this.trait_).v(usersOuterClass$RequestLoadFullUsers)).j();
        }
        this.traitCase_ = LOAD_FULL_USERS_FIELD_NUMBER;
    }

    private void mergeLoadGroupAvatars(GroupsOuterClass$RequestLoadGroupAvatars groupsOuterClass$RequestLoadGroupAvatars) {
        groupsOuterClass$RequestLoadGroupAvatars.getClass();
        if (this.traitCase_ != 43748 || this.trait_ == GroupsOuterClass$RequestLoadGroupAvatars.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$RequestLoadGroupAvatars;
        } else {
            this.trait_ = ((GroupsOuterClass$RequestLoadGroupAvatars.a) GroupsOuterClass$RequestLoadGroupAvatars.newBuilder((GroupsOuterClass$RequestLoadGroupAvatars) this.trait_).v(groupsOuterClass$RequestLoadGroupAvatars)).j();
        }
        this.traitCase_ = LOAD_GROUP_AVATARS_FIELD_NUMBER;
    }

    private void mergeLoadGroupedDialogs(MessagingOuterClass$RequestLoadGroupedDialogs messagingOuterClass$RequestLoadGroupedDialogs) {
        messagingOuterClass$RequestLoadGroupedDialogs.getClass();
        if (this.traitCase_ != 225 || this.trait_ == MessagingOuterClass$RequestLoadGroupedDialogs.getDefaultInstance()) {
            this.trait_ = messagingOuterClass$RequestLoadGroupedDialogs;
        } else {
            this.trait_ = ((MessagingOuterClass$RequestLoadGroupedDialogs.b) MessagingOuterClass$RequestLoadGroupedDialogs.newBuilder((MessagingOuterClass$RequestLoadGroupedDialogs) this.trait_).v(messagingOuterClass$RequestLoadGroupedDialogs)).j();
        }
        this.traitCase_ = 225;
    }

    private void mergeLoadGroups(GroupsOuterClass$RequestLoadGroups groupsOuterClass$RequestLoadGroups) {
        groupsOuterClass$RequestLoadGroups.getClass();
        if (this.traitCase_ != 63245 || this.trait_ == GroupsOuterClass$RequestLoadGroups.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$RequestLoadGroups;
        } else {
            this.trait_ = ((GroupsOuterClass$RequestLoadGroups.a) GroupsOuterClass$RequestLoadGroups.newBuilder((GroupsOuterClass$RequestLoadGroups) this.trait_).v(groupsOuterClass$RequestLoadGroups)).j();
        }
        this.traitCase_ = LOAD_GROUPS_FIELD_NUMBER;
    }

    private void mergeLoadHistory(MessagingOuterClass$RequestLoadHistory messagingOuterClass$RequestLoadHistory) {
        messagingOuterClass$RequestLoadHistory.getClass();
        if (this.traitCase_ != 118 || this.trait_ == MessagingOuterClass$RequestLoadHistory.getDefaultInstance()) {
            this.trait_ = messagingOuterClass$RequestLoadHistory;
        } else {
            this.trait_ = ((MessagingOuterClass$RequestLoadHistory.b) MessagingOuterClass$RequestLoadHistory.newBuilder((MessagingOuterClass$RequestLoadHistory) this.trait_).v(messagingOuterClass$RequestLoadHistory)).j();
        }
        this.traitCase_ = LOAD_HISTORY_FIELD_NUMBER;
    }

    private void mergeLoadLastStates(MelonOuterClass$RequestLoadLastStates melonOuterClass$RequestLoadLastStates) {
        melonOuterClass$RequestLoadLastStates.getClass();
        if (this.traitCase_ != 63659 || this.trait_ == MelonOuterClass$RequestLoadLastStates.getDefaultInstance()) {
            this.trait_ = melonOuterClass$RequestLoadLastStates;
        } else {
            this.trait_ = ((MelonOuterClass$RequestLoadLastStates.a) MelonOuterClass$RequestLoadLastStates.newBuilder((MelonOuterClass$RequestLoadLastStates) this.trait_).v(melonOuterClass$RequestLoadLastStates)).j();
        }
        this.traitCase_ = LOAD_LAST_STATES_FIELD_NUMBER;
    }

    private void mergeLoadLoanHistory(MelonOuterClass$RequestLoadLoanHistory melonOuterClass$RequestLoadLoanHistory) {
        melonOuterClass$RequestLoadLoanHistory.getClass();
        if (this.traitCase_ != 63656 || this.trait_ == MelonOuterClass$RequestLoadLoanHistory.getDefaultInstance()) {
            this.trait_ = melonOuterClass$RequestLoadLoanHistory;
        } else {
            this.trait_ = ((MelonOuterClass$RequestLoadLoanHistory.a) MelonOuterClass$RequestLoadLoanHistory.newBuilder((MelonOuterClass$RequestLoadLoanHistory) this.trait_).v(melonOuterClass$RequestLoadLoanHistory)).j();
        }
        this.traitCase_ = LOAD_LOAN_HISTORY_FIELD_NUMBER;
    }

    private void mergeLoadMembers(GroupsOuterClass$RequestLoadMembers groupsOuterClass$RequestLoadMembers) {
        groupsOuterClass$RequestLoadMembers.getClass();
        if (this.traitCase_ != 2786 || this.trait_ == GroupsOuterClass$RequestLoadMembers.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$RequestLoadMembers;
        } else {
            this.trait_ = ((GroupsOuterClass$RequestLoadMembers.a) GroupsOuterClass$RequestLoadMembers.newBuilder((GroupsOuterClass$RequestLoadMembers) this.trait_).v(groupsOuterClass$RequestLoadMembers)).j();
        }
        this.traitCase_ = LOAD_MEMBERS_FIELD_NUMBER;
    }

    private void mergeLoadOwnStickers(ImagesOuterClass$RequestLoadOwnStickers imagesOuterClass$RequestLoadOwnStickers) {
        imagesOuterClass$RequestLoadOwnStickers.getClass();
        if (this.traitCase_ != 238 || this.trait_ == ImagesOuterClass$RequestLoadOwnStickers.getDefaultInstance()) {
            this.trait_ = imagesOuterClass$RequestLoadOwnStickers;
        } else {
            this.trait_ = ((ImagesOuterClass$RequestLoadOwnStickers.a) ImagesOuterClass$RequestLoadOwnStickers.newBuilder((ImagesOuterClass$RequestLoadOwnStickers) this.trait_).v(imagesOuterClass$RequestLoadOwnStickers)).j();
        }
        this.traitCase_ = LOAD_OWN_STICKERS_FIELD_NUMBER;
    }

    private void mergeLoadPeerDialogs(MessagingOuterClass$RequestLoadPeerDialogs messagingOuterClass$RequestLoadPeerDialogs) {
        messagingOuterClass$RequestLoadPeerDialogs.getClass();
        if (this.traitCase_ != 63249 || this.trait_ == MessagingOuterClass$RequestLoadPeerDialogs.getDefaultInstance()) {
            this.trait_ = messagingOuterClass$RequestLoadPeerDialogs;
        } else {
            this.trait_ = ((MessagingOuterClass$RequestLoadPeerDialogs.a) MessagingOuterClass$RequestLoadPeerDialogs.newBuilder((MessagingOuterClass$RequestLoadPeerDialogs) this.trait_).v(messagingOuterClass$RequestLoadPeerDialogs)).j();
        }
        this.traitCase_ = LOAD_PEER_DIALOGS_FIELD_NUMBER;
    }

    private void mergeLoadReactions(AbacusOuterClass$RequestLoadReactions abacusOuterClass$RequestLoadReactions) {
        abacusOuterClass$RequestLoadReactions.getClass();
        if (this.traitCase_ != 63239 || this.trait_ == AbacusOuterClass$RequestLoadReactions.getDefaultInstance()) {
            this.trait_ = abacusOuterClass$RequestLoadReactions;
        } else {
            this.trait_ = ((AbacusOuterClass$RequestLoadReactions.a) AbacusOuterClass$RequestLoadReactions.newBuilder((AbacusOuterClass$RequestLoadReactions) this.trait_).v(abacusOuterClass$RequestLoadReactions)).j();
        }
        this.traitCase_ = LOAD_REACTIONS_FIELD_NUMBER;
    }

    private void mergeLoadStickerCollection(ImagesOuterClass$RequestLoadStickerCollection imagesOuterClass$RequestLoadStickerCollection) {
        imagesOuterClass$RequestLoadStickerCollection.getClass();
        if (this.traitCase_ != 246 || this.trait_ == ImagesOuterClass$RequestLoadStickerCollection.getDefaultInstance()) {
            this.trait_ = imagesOuterClass$RequestLoadStickerCollection;
        } else {
            this.trait_ = ((ImagesOuterClass$RequestLoadStickerCollection.a) ImagesOuterClass$RequestLoadStickerCollection.newBuilder((ImagesOuterClass$RequestLoadStickerCollection) this.trait_).v(imagesOuterClass$RequestLoadStickerCollection)).j();
        }
        this.traitCase_ = LOAD_STICKER_COLLECTION_FIELD_NUMBER;
    }

    private void mergeLoadTransactions(PfmOuterClass$RequestLoadTransactions pfmOuterClass$RequestLoadTransactions) {
        pfmOuterClass$RequestLoadTransactions.getClass();
        if (this.traitCase_ != 63445 || this.trait_ == PfmOuterClass$RequestLoadTransactions.getDefaultInstance()) {
            this.trait_ = pfmOuterClass$RequestLoadTransactions;
        } else {
            this.trait_ = ((PfmOuterClass$RequestLoadTransactions.a) PfmOuterClass$RequestLoadTransactions.newBuilder((PfmOuterClass$RequestLoadTransactions) this.trait_).v(pfmOuterClass$RequestLoadTransactions)).j();
        }
        this.traitCase_ = LOAD_TRANSACTIONS_FIELD_NUMBER;
    }

    private void mergeLoadTransactionsByIds(PfmOuterClass$RequestLoadTransactionsByIDs pfmOuterClass$RequestLoadTransactionsByIDs) {
        pfmOuterClass$RequestLoadTransactionsByIDs.getClass();
        if (this.traitCase_ != 63649 || this.trait_ == PfmOuterClass$RequestLoadTransactionsByIDs.getDefaultInstance()) {
            this.trait_ = pfmOuterClass$RequestLoadTransactionsByIDs;
        } else {
            this.trait_ = ((PfmOuterClass$RequestLoadTransactionsByIDs.a) PfmOuterClass$RequestLoadTransactionsByIDs.newBuilder((PfmOuterClass$RequestLoadTransactionsByIDs) this.trait_).v(pfmOuterClass$RequestLoadTransactionsByIDs)).j();
        }
        this.traitCase_ = LOAD_TRANSACTIONS_BY_IDS_FIELD_NUMBER;
    }

    private void mergeLoadUsers(UsersOuterClass$RequestLoadUsers usersOuterClass$RequestLoadUsers) {
        usersOuterClass$RequestLoadUsers.getClass();
        if (this.traitCase_ != 63247 || this.trait_ == UsersOuterClass$RequestLoadUsers.getDefaultInstance()) {
            this.trait_ = usersOuterClass$RequestLoadUsers;
        } else {
            this.trait_ = ((UsersOuterClass$RequestLoadUsers.a) UsersOuterClass$RequestLoadUsers.newBuilder((UsersOuterClass$RequestLoadUsers) this.trait_).v(usersOuterClass$RequestLoadUsers)).j();
        }
        this.traitCase_ = LOAD_USERS_FIELD_NUMBER;
    }

    private void mergeMakeUserAdmin(GroupsOuterClass$RequestMakeUserAdmin groupsOuterClass$RequestMakeUserAdmin) {
        groupsOuterClass$RequestMakeUserAdmin.getClass();
        if (this.traitCase_ != 2784 || this.trait_ == GroupsOuterClass$RequestMakeUserAdmin.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$RequestMakeUserAdmin;
        } else {
            this.trait_ = ((GroupsOuterClass$RequestMakeUserAdmin.a) GroupsOuterClass$RequestMakeUserAdmin.newBuilder((GroupsOuterClass$RequestMakeUserAdmin) this.trait_).v(groupsOuterClass$RequestMakeUserAdmin)).j();
        }
        this.traitCase_ = MAKE_USER_ADMIN_FIELD_NUMBER;
    }

    private void mergeMessageRead(MessagingOuterClass$RequestMessageRead messagingOuterClass$RequestMessageRead) {
        messagingOuterClass$RequestMessageRead.getClass();
        if (this.traitCase_ != 57 || this.trait_ == MessagingOuterClass$RequestMessageRead.getDefaultInstance()) {
            this.trait_ = messagingOuterClass$RequestMessageRead;
        } else {
            this.trait_ = ((MessagingOuterClass$RequestMessageRead.a) MessagingOuterClass$RequestMessageRead.newBuilder((MessagingOuterClass$RequestMessageRead) this.trait_).v(messagingOuterClass$RequestMessageRead)).j();
        }
        this.traitCase_ = 57;
    }

    private void mergeMessageReceived(MessagingOuterClass$RequestMessageReceived messagingOuterClass$RequestMessageReceived) {
        messagingOuterClass$RequestMessageReceived.getClass();
        if (this.traitCase_ != 55 || this.trait_ == MessagingOuterClass$RequestMessageReceived.getDefaultInstance()) {
            this.trait_ = messagingOuterClass$RequestMessageReceived;
        } else {
            this.trait_ = ((MessagingOuterClass$RequestMessageReceived.a) MessagingOuterClass$RequestMessageReceived.newBuilder((MessagingOuterClass$RequestMessageReceived) this.trait_).v(messagingOuterClass$RequestMessageReceived)).j();
        }
        this.traitCase_ = 55;
    }

    private void mergeMessageRemoveReaction(AbacusOuterClass$RequestMessageRemoveReaction abacusOuterClass$RequestMessageRemoveReaction) {
        abacusOuterClass$RequestMessageRemoveReaction.getClass();
        if (this.traitCase_ != 220 || this.trait_ == AbacusOuterClass$RequestMessageRemoveReaction.getDefaultInstance()) {
            this.trait_ = abacusOuterClass$RequestMessageRemoveReaction;
        } else {
            this.trait_ = ((AbacusOuterClass$RequestMessageRemoveReaction.a) AbacusOuterClass$RequestMessageRemoveReaction.newBuilder((AbacusOuterClass$RequestMessageRemoveReaction) this.trait_).v(abacusOuterClass$RequestMessageRemoveReaction)).j();
        }
        this.traitCase_ = MESSAGE_REMOVE_REACTION_FIELD_NUMBER;
    }

    private void mergeMessageSetReaction(AbacusOuterClass$RequestMessageSetReaction abacusOuterClass$RequestMessageSetReaction) {
        abacusOuterClass$RequestMessageSetReaction.getClass();
        if (this.traitCase_ != 210 || this.trait_ == AbacusOuterClass$RequestMessageSetReaction.getDefaultInstance()) {
            this.trait_ = abacusOuterClass$RequestMessageSetReaction;
        } else {
            this.trait_ = ((AbacusOuterClass$RequestMessageSetReaction.a) AbacusOuterClass$RequestMessageSetReaction.newBuilder((AbacusOuterClass$RequestMessageSetReaction) this.trait_).v(abacusOuterClass$RequestMessageSetReaction)).j();
        }
        this.traitCase_ = 210;
    }

    private void mergeNewFatSeqUpdate(UpdateBoxStruct$NewFatSeqUpdate updateBoxStruct$NewFatSeqUpdate) {
        updateBoxStruct$NewFatSeqUpdate.getClass();
        if (this.traitCase_ != 1168 || this.trait_ == UpdateBoxStruct$NewFatSeqUpdate.getDefaultInstance()) {
            this.trait_ = updateBoxStruct$NewFatSeqUpdate;
        } else {
            this.trait_ = ((UpdateBoxStruct$NewFatSeqUpdate.a) UpdateBoxStruct$NewFatSeqUpdate.newBuilder((UpdateBoxStruct$NewFatSeqUpdate) this.trait_).v(updateBoxStruct$NewFatSeqUpdate)).j();
        }
        this.traitCase_ = NEW_FAT_SEQ_UPDATE_FIELD_NUMBER;
    }

    private void mergeNewSeqUpdate(UpdateBoxStruct$NewSeqUpdate updateBoxStruct$NewSeqUpdate) {
        updateBoxStruct$NewSeqUpdate.getClass();
        if (this.traitCase_ != 45 || this.trait_ == UpdateBoxStruct$NewSeqUpdate.getDefaultInstance()) {
            this.trait_ = updateBoxStruct$NewSeqUpdate;
        } else {
            this.trait_ = ((UpdateBoxStruct$NewSeqUpdate.a) UpdateBoxStruct$NewSeqUpdate.newBuilder((UpdateBoxStruct$NewSeqUpdate) this.trait_).v(updateBoxStruct$NewSeqUpdate)).j();
        }
        this.traitCase_ = 45;
    }

    private void mergeNotifyAboutDeviceInfo(UsersOuterClass$RequestNotifyAboutDeviceInfo usersOuterClass$RequestNotifyAboutDeviceInfo) {
        usersOuterClass$RequestNotifyAboutDeviceInfo.getClass();
        if (this.traitCase_ != 229 || this.trait_ == UsersOuterClass$RequestNotifyAboutDeviceInfo.getDefaultInstance()) {
            this.trait_ = usersOuterClass$RequestNotifyAboutDeviceInfo;
        } else {
            this.trait_ = ((UsersOuterClass$RequestNotifyAboutDeviceInfo.a) UsersOuterClass$RequestNotifyAboutDeviceInfo.newBuilder((UsersOuterClass$RequestNotifyAboutDeviceInfo) this.trait_).v(usersOuterClass$RequestNotifyAboutDeviceInfo)).j();
        }
        this.traitCase_ = NOTIFY_ABOUT_DEVICE_INFO_FIELD_NUMBER;
    }

    private void mergeOpenGiftPacket(Giftpacket$RequestOpenGiftPacket giftpacket$RequestOpenGiftPacket) {
        giftpacket$RequestOpenGiftPacket.getClass();
        if (this.traitCase_ != 63236 || this.trait_ == Giftpacket$RequestOpenGiftPacket.getDefaultInstance()) {
            this.trait_ = giftpacket$RequestOpenGiftPacket;
        } else {
            this.trait_ = ((Giftpacket$RequestOpenGiftPacket.a) Giftpacket$RequestOpenGiftPacket.newBuilder((Giftpacket$RequestOpenGiftPacket) this.trait_).v(giftpacket$RequestOpenGiftPacket)).j();
        }
        this.traitCase_ = OPEN_GIFT_PACKET_FIELD_NUMBER;
    }

    private void mergePayBill(BillOuterClass$RequestPayBill billOuterClass$RequestPayBill) {
        billOuterClass$RequestPayBill.getClass();
        if (this.traitCase_ != 63545 || this.trait_ == BillOuterClass$RequestPayBill.getDefaultInstance()) {
            this.trait_ = billOuterClass$RequestPayBill;
        } else {
            this.trait_ = ((BillOuterClass$RequestPayBill.a) BillOuterClass$RequestPayBill.newBuilder((BillOuterClass$RequestPayBill) this.trait_).v(billOuterClass$RequestPayBill)).j();
        }
        this.traitCase_ = PAY_BILL_FIELD_NUMBER;
    }

    private void mergePayByWallet(WalletOuterClass$RequestPayByWallet walletOuterClass$RequestPayByWallet) {
        walletOuterClass$RequestPayByWallet.getClass();
        if (this.traitCase_ != 62746 || this.trait_ == WalletOuterClass$RequestPayByWallet.getDefaultInstance()) {
            this.trait_ = walletOuterClass$RequestPayByWallet;
        } else {
            this.trait_ = ((WalletOuterClass$RequestPayByWallet.a) WalletOuterClass$RequestPayByWallet.newBuilder((WalletOuterClass$RequestPayByWallet) this.trait_).v(walletOuterClass$RequestPayByWallet)).j();
        }
        this.traitCase_ = PAY_BY_WALLET_FIELD_NUMBER;
    }

    private void mergePayMoneyRequestByWallet(WalletOuterClass$RequestPayMoneyRequestByWallet walletOuterClass$RequestPayMoneyRequestByWallet) {
        walletOuterClass$RequestPayMoneyRequestByWallet.getClass();
        if (this.traitCase_ != 62751 || this.trait_ == WalletOuterClass$RequestPayMoneyRequestByWallet.getDefaultInstance()) {
            this.trait_ = walletOuterClass$RequestPayMoneyRequestByWallet;
        } else {
            this.trait_ = ((WalletOuterClass$RequestPayMoneyRequestByWallet.a) WalletOuterClass$RequestPayMoneyRequestByWallet.newBuilder((WalletOuterClass$RequestPayMoneyRequestByWallet) this.trait_).v(walletOuterClass$RequestPayMoneyRequestByWallet)).j();
        }
        this.traitCase_ = PAY_MONEY_REQUEST_BY_WALLET_FIELD_NUMBER;
    }

    private void mergePaySefte(SefteOuterClass$RequestPaySefte sefteOuterClass$RequestPaySefte) {
        sefteOuterClass$RequestPaySefte.getClass();
        if (this.traitCase_ != 63614 || this.trait_ == SefteOuterClass$RequestPaySefte.getDefaultInstance()) {
            this.trait_ = sefteOuterClass$RequestPaySefte;
        } else {
            this.trait_ = ((SefteOuterClass$RequestPaySefte.a) SefteOuterClass$RequestPaySefte.newBuilder((SefteOuterClass$RequestPaySefte) this.trait_).v(sefteOuterClass$RequestPaySefte)).j();
        }
        this.traitCase_ = PAY_SEFTE_FIELD_NUMBER;
    }

    private void mergePinMessage(GroupsOuterClass$RequestPinMessage groupsOuterClass$RequestPinMessage) {
        groupsOuterClass$RequestPinMessage.getClass();
        if (this.traitCase_ != 470 || this.trait_ == GroupsOuterClass$RequestPinMessage.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$RequestPinMessage;
        } else {
            this.trait_ = ((GroupsOuterClass$RequestPinMessage.a) GroupsOuterClass$RequestPinMessage.newBuilder((GroupsOuterClass$RequestPinMessage) this.trait_).v(groupsOuterClass$RequestPinMessage)).j();
        }
        this.traitCase_ = PIN_MESSAGE_FIELD_NUMBER;
    }

    private void mergeProto(Protobuf$RequestProto protobuf$RequestProto) {
        protobuf$RequestProto.getClass();
        if (this.traitCase_ != 63639 || this.trait_ == Protobuf$RequestProto.getDefaultInstance()) {
            this.trait_ = protobuf$RequestProto;
        } else {
            this.trait_ = ((Protobuf$RequestProto.a) Protobuf$RequestProto.newBuilder((Protobuf$RequestProto) this.trait_).v(protobuf$RequestProto)).j();
        }
        this.traitCase_ = PROTO_FIELD_NUMBER;
    }

    private void mergePurchaseMessage(KifpoolOuterClass$RequestPurchaseMessage kifpoolOuterClass$RequestPurchaseMessage) {
        kifpoolOuterClass$RequestPurchaseMessage.getClass();
        if (this.traitCase_ != 63418 || this.trait_ == KifpoolOuterClass$RequestPurchaseMessage.getDefaultInstance()) {
            this.trait_ = kifpoolOuterClass$RequestPurchaseMessage;
        } else {
            this.trait_ = ((KifpoolOuterClass$RequestPurchaseMessage.a) KifpoolOuterClass$RequestPurchaseMessage.newBuilder((KifpoolOuterClass$RequestPurchaseMessage) this.trait_).v(kifpoolOuterClass$RequestPurchaseMessage)).j();
        }
        this.traitCase_ = PURCHASE_MESSAGE_FIELD_NUMBER;
    }

    private void mergePurchaseMessageWithCharge(KifpoolOuterClass$RequestPurchaseMessageWithCharge kifpoolOuterClass$RequestPurchaseMessageWithCharge) {
        kifpoolOuterClass$RequestPurchaseMessageWithCharge.getClass();
        if (this.traitCase_ != 63428 || this.trait_ == KifpoolOuterClass$RequestPurchaseMessageWithCharge.getDefaultInstance()) {
            this.trait_ = kifpoolOuterClass$RequestPurchaseMessageWithCharge;
        } else {
            this.trait_ = ((KifpoolOuterClass$RequestPurchaseMessageWithCharge.a) KifpoolOuterClass$RequestPurchaseMessageWithCharge.newBuilder((KifpoolOuterClass$RequestPurchaseMessageWithCharge) this.trait_).v(kifpoolOuterClass$RequestPurchaseMessageWithCharge)).j();
        }
        this.traitCase_ = PURCHASE_MESSAGE_WITH_CHARGE_FIELD_NUMBER;
    }

    private void mergeReactivateApp(SapOuterClass$RequestReactivateApp sapOuterClass$RequestReactivateApp) {
        sapOuterClass$RequestReactivateApp.getClass();
        if (this.traitCase_ != 63591 || this.trait_ == SapOuterClass$RequestReactivateApp.getDefaultInstance()) {
            this.trait_ = sapOuterClass$RequestReactivateApp;
        } else {
            this.trait_ = ((SapOuterClass$RequestReactivateApp.a) SapOuterClass$RequestReactivateApp.newBuilder((SapOuterClass$RequestReactivateApp) this.trait_).v(sapOuterClass$RequestReactivateApp)).j();
        }
        this.traitCase_ = REACTIVATE_APP_FIELD_NUMBER;
    }

    private void mergeRefer(ReferralOuterClass$RequestRefer referralOuterClass$RequestRefer) {
        referralOuterClass$RequestRefer.getClass();
        if (this.traitCase_ != 63502 || this.trait_ == ReferralOuterClass$RequestRefer.getDefaultInstance()) {
            this.trait_ = referralOuterClass$RequestRefer;
        } else {
            this.trait_ = ((ReferralOuterClass$RequestRefer.a) ReferralOuterClass$RequestRefer.newBuilder((ReferralOuterClass$RequestRefer) this.trait_).v(referralOuterClass$RequestRefer)).j();
        }
        this.traitCase_ = REFER_FIELD_NUMBER;
    }

    private void mergeRegisterForEarnMoney(AdvertisementOuterClass$RequestRegisterForEarnMoney advertisementOuterClass$RequestRegisterForEarnMoney) {
        advertisementOuterClass$RequestRegisterForEarnMoney.getClass();
        if (this.traitCase_ != 63438 || this.trait_ == AdvertisementOuterClass$RequestRegisterForEarnMoney.getDefaultInstance()) {
            this.trait_ = advertisementOuterClass$RequestRegisterForEarnMoney;
        } else {
            this.trait_ = ((AdvertisementOuterClass$RequestRegisterForEarnMoney.a) AdvertisementOuterClass$RequestRegisterForEarnMoney.newBuilder((AdvertisementOuterClass$RequestRegisterForEarnMoney) this.trait_).v(advertisementOuterClass$RequestRegisterForEarnMoney)).j();
        }
        this.traitCase_ = REGISTER_FOR_EARN_MONEY_FIELD_NUMBER;
    }

    private void mergeRegisterGooglePush(PushOuterClass$RequestRegisterGooglePush pushOuterClass$RequestRegisterGooglePush) {
        pushOuterClass$RequestRegisterGooglePush.getClass();
        if (this.traitCase_ != 51 || this.trait_ == PushOuterClass$RequestRegisterGooglePush.getDefaultInstance()) {
            this.trait_ = pushOuterClass$RequestRegisterGooglePush;
        } else {
            this.trait_ = ((PushOuterClass$RequestRegisterGooglePush.a) PushOuterClass$RequestRegisterGooglePush.newBuilder((PushOuterClass$RequestRegisterGooglePush) this.trait_).v(pushOuterClass$RequestRegisterGooglePush)).j();
        }
        this.traitCase_ = 51;
    }

    private void mergeRemoveAvatar(UsersOuterClass$RequestRemoveAvatar usersOuterClass$RequestRemoveAvatar) {
        usersOuterClass$RequestRemoveAvatar.getClass();
        if (this.traitCase_ != 91 || this.trait_ == UsersOuterClass$RequestRemoveAvatar.getDefaultInstance()) {
            this.trait_ = usersOuterClass$RequestRemoveAvatar;
        } else {
            this.trait_ = ((UsersOuterClass$RequestRemoveAvatar.a) UsersOuterClass$RequestRemoveAvatar.newBuilder((UsersOuterClass$RequestRemoveAvatar) this.trait_).v(usersOuterClass$RequestRemoveAvatar)).j();
        }
        this.traitCase_ = 91;
    }

    private void mergeRemoveCard(SapOuterClass$RequestRemoveCard sapOuterClass$RequestRemoveCard) {
        sapOuterClass$RequestRemoveCard.getClass();
        if (this.traitCase_ != 63557 || this.trait_ == SapOuterClass$RequestRemoveCard.getDefaultInstance()) {
            this.trait_ = sapOuterClass$RequestRemoveCard;
        } else {
            this.trait_ = ((SapOuterClass$RequestRemoveCard.a) SapOuterClass$RequestRemoveCard.newBuilder((SapOuterClass$RequestRemoveCard) this.trait_).v(sapOuterClass$RequestRemoveCard)).j();
        }
        this.traitCase_ = REMOVE_CARD_FIELD_NUMBER;
    }

    private void mergeRemoveContact(UsersOuterClass$RequestRemoveContact usersOuterClass$RequestRemoveContact) {
        usersOuterClass$RequestRemoveContact.getClass();
        if (this.traitCase_ != 89 || this.trait_ == UsersOuterClass$RequestRemoveContact.getDefaultInstance()) {
            this.trait_ = usersOuterClass$RequestRemoveContact;
        } else {
            this.trait_ = ((UsersOuterClass$RequestRemoveContact.a) UsersOuterClass$RequestRemoveContact.newBuilder((UsersOuterClass$RequestRemoveContact) this.trait_).v(usersOuterClass$RequestRemoveContact)).j();
        }
        this.traitCase_ = 89;
    }

    private void mergeRemoveDefaultCard(SapOuterClass$RequestRemoveDefaultCard sapOuterClass$RequestRemoveDefaultCard) {
        sapOuterClass$RequestRemoveDefaultCard.getClass();
        if (this.traitCase_ != 63565 || this.trait_ == SapOuterClass$RequestRemoveDefaultCard.getDefaultInstance()) {
            this.trait_ = sapOuterClass$RequestRemoveDefaultCard;
        } else {
            this.trait_ = ((SapOuterClass$RequestRemoveDefaultCard.a) SapOuterClass$RequestRemoveDefaultCard.newBuilder((SapOuterClass$RequestRemoveDefaultCard) this.trait_).v(sapOuterClass$RequestRemoveDefaultCard)).j();
        }
        this.traitCase_ = REMOVE_DEFAULT_CARD_FIELD_NUMBER;
    }

    private void mergeRemoveDefaultCardNumber(UsersOuterClass$RequestRemoveDefaultCardNumber usersOuterClass$RequestRemoveDefaultCardNumber) {
        usersOuterClass$RequestRemoveDefaultCardNumber.getClass();
        if (this.traitCase_ != 62177 || this.trait_ == UsersOuterClass$RequestRemoveDefaultCardNumber.getDefaultInstance()) {
            this.trait_ = usersOuterClass$RequestRemoveDefaultCardNumber;
        } else {
            this.trait_ = ((UsersOuterClass$RequestRemoveDefaultCardNumber.a) UsersOuterClass$RequestRemoveDefaultCardNumber.newBuilder((UsersOuterClass$RequestRemoveDefaultCardNumber) this.trait_).v(usersOuterClass$RequestRemoveDefaultCardNumber)).j();
        }
        this.traitCase_ = REMOVE_DEFAULT_CARD_NUMBER_FIELD_NUMBER;
    }

    private void mergeRemoveDestinationCards(SapOuterClass$RequestRemoveDestinationCards sapOuterClass$RequestRemoveDestinationCards) {
        sapOuterClass$RequestRemoveDestinationCards.getClass();
        if (this.traitCase_ != 63590 || this.trait_ == SapOuterClass$RequestRemoveDestinationCards.getDefaultInstance()) {
            this.trait_ = sapOuterClass$RequestRemoveDestinationCards;
        } else {
            this.trait_ = ((SapOuterClass$RequestRemoveDestinationCards.a) SapOuterClass$RequestRemoveDestinationCards.newBuilder((SapOuterClass$RequestRemoveDestinationCards) this.trait_).v(sapOuterClass$RequestRemoveDestinationCards)).j();
        }
        this.traitCase_ = REMOVE_DESTINATION_CARDS_FIELD_NUMBER;
    }

    private void mergeRemoveGif(ImagesOuterClass$RequestRemoveGif imagesOuterClass$RequestRemoveGif) {
        imagesOuterClass$RequestRemoveGif.getClass();
        if (this.traitCase_ != 2859 || this.trait_ == ImagesOuterClass$RequestRemoveGif.getDefaultInstance()) {
            this.trait_ = imagesOuterClass$RequestRemoveGif;
        } else {
            this.trait_ = ((ImagesOuterClass$RequestRemoveGif.a) ImagesOuterClass$RequestRemoveGif.newBuilder((ImagesOuterClass$RequestRemoveGif) this.trait_).v(imagesOuterClass$RequestRemoveGif)).j();
        }
        this.traitCase_ = REMOVE_GIF_FIELD_NUMBER;
    }

    private void mergeRemoveGroupAvatar(GroupsOuterClass$RequestRemoveGroupAvatar groupsOuterClass$RequestRemoveGroupAvatar) {
        groupsOuterClass$RequestRemoveGroupAvatar.getClass();
        if (this.traitCase_ != 101 || this.trait_ == GroupsOuterClass$RequestRemoveGroupAvatar.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$RequestRemoveGroupAvatar;
        } else {
            this.trait_ = ((GroupsOuterClass$RequestRemoveGroupAvatar.b) GroupsOuterClass$RequestRemoveGroupAvatar.newBuilder((GroupsOuterClass$RequestRemoveGroupAvatar) this.trait_).v(groupsOuterClass$RequestRemoveGroupAvatar)).j();
        }
        this.traitCase_ = 101;
    }

    private void mergeRemoveLoan(MelonOuterClass$RequestRemoveLoan melonOuterClass$RequestRemoveLoan) {
        melonOuterClass$RequestRemoveLoan.getClass();
        if (this.traitCase_ != 63658 || this.trait_ == MelonOuterClass$RequestRemoveLoan.getDefaultInstance()) {
            this.trait_ = melonOuterClass$RequestRemoveLoan;
        } else {
            this.trait_ = ((MelonOuterClass$RequestRemoveLoan.a) MelonOuterClass$RequestRemoveLoan.newBuilder((MelonOuterClass$RequestRemoveLoan) this.trait_).v(melonOuterClass$RequestRemoveLoan)).j();
        }
        this.traitCase_ = REMOVE_LOAN_FIELD_NUMBER;
    }

    private void mergeRemovePin(GroupsOuterClass$RequestRemovePin groupsOuterClass$RequestRemovePin) {
        groupsOuterClass$RequestRemovePin.getClass();
        if (this.traitCase_ != 471 || this.trait_ == GroupsOuterClass$RequestRemovePin.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$RequestRemovePin;
        } else {
            this.trait_ = ((GroupsOuterClass$RequestRemovePin.a) GroupsOuterClass$RequestRemovePin.newBuilder((GroupsOuterClass$RequestRemovePin) this.trait_).v(groupsOuterClass$RequestRemovePin)).j();
        }
        this.traitCase_ = REMOVE_PIN_FIELD_NUMBER;
    }

    private void mergeRemoveStickerCollection(ImagesOuterClass$RequestRemoveStickerCollection imagesOuterClass$RequestRemoveStickerCollection) {
        imagesOuterClass$RequestRemoveStickerCollection.getClass();
        if (this.traitCase_ != 245 || this.trait_ == ImagesOuterClass$RequestRemoveStickerCollection.getDefaultInstance()) {
            this.trait_ = imagesOuterClass$RequestRemoveStickerCollection;
        } else {
            this.trait_ = ((ImagesOuterClass$RequestRemoveStickerCollection.a) ImagesOuterClass$RequestRemoveStickerCollection.newBuilder((ImagesOuterClass$RequestRemoveStickerCollection) this.trait_).v(imagesOuterClass$RequestRemoveStickerCollection)).j();
        }
        this.traitCase_ = 245;
    }

    private void mergeRemoveTransaction(PfmOuterClass$RequestRemoveTransaction pfmOuterClass$RequestRemoveTransaction) {
        pfmOuterClass$RequestRemoveTransaction.getClass();
        if (this.traitCase_ != 63646 || this.trait_ == PfmOuterClass$RequestRemoveTransaction.getDefaultInstance()) {
            this.trait_ = pfmOuterClass$RequestRemoveTransaction;
        } else {
            this.trait_ = ((PfmOuterClass$RequestRemoveTransaction.a) PfmOuterClass$RequestRemoveTransaction.newBuilder((PfmOuterClass$RequestRemoveTransaction) this.trait_).v(pfmOuterClass$RequestRemoveTransaction)).j();
        }
        this.traitCase_ = REMOVE_TRANSACTION_FIELD_NUMBER;
    }

    private void mergeRemoveTransactionTags(PfmOuterClass$RequestRemoveTransactionTags pfmOuterClass$RequestRemoveTransactionTags) {
        pfmOuterClass$RequestRemoveTransactionTags.getClass();
        if (this.traitCase_ != 63450 || this.trait_ == PfmOuterClass$RequestRemoveTransactionTags.getDefaultInstance()) {
            this.trait_ = pfmOuterClass$RequestRemoveTransactionTags;
        } else {
            this.trait_ = ((PfmOuterClass$RequestRemoveTransactionTags.a) PfmOuterClass$RequestRemoveTransactionTags.newBuilder((PfmOuterClass$RequestRemoveTransactionTags) this.trait_).v(pfmOuterClass$RequestRemoveTransactionTags)).j();
        }
        this.traitCase_ = REMOVE_TRANSACTION_TAGS_FIELD_NUMBER;
    }

    private void mergeRemoveUserAdmin(GroupsOuterClass$RequestRemoveUserAdmin groupsOuterClass$RequestRemoveUserAdmin) {
        groupsOuterClass$RequestRemoveUserAdmin.getClass();
        if (this.traitCase_ != 44576 || this.trait_ == GroupsOuterClass$RequestRemoveUserAdmin.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$RequestRemoveUserAdmin;
        } else {
            this.trait_ = ((GroupsOuterClass$RequestRemoveUserAdmin.a) GroupsOuterClass$RequestRemoveUserAdmin.newBuilder((GroupsOuterClass$RequestRemoveUserAdmin) this.trait_).v(groupsOuterClass$RequestRemoveUserAdmin)).j();
        }
        this.traitCase_ = REMOVE_USER_ADMIN_FIELD_NUMBER;
    }

    private void mergeRemoveUserTags(PfmOuterClass$RequestRemoveUserTags pfmOuterClass$RequestRemoveUserTags) {
        pfmOuterClass$RequestRemoveUserTags.getClass();
        if (this.traitCase_ != 63519 || this.trait_ == PfmOuterClass$RequestRemoveUserTags.getDefaultInstance()) {
            this.trait_ = pfmOuterClass$RequestRemoveUserTags;
        } else {
            this.trait_ = ((PfmOuterClass$RequestRemoveUserTags.a) PfmOuterClass$RequestRemoveUserTags.newBuilder((PfmOuterClass$RequestRemoveUserTags) this.trait_).v(pfmOuterClass$RequestRemoveUserTags)).j();
        }
        this.traitCase_ = REMOVE_USER_TAGS_FIELD_NUMBER;
    }

    private void mergeRenameSavedBill(BillOuterClass$RequestRenameSavedBill billOuterClass$RequestRenameSavedBill) {
        billOuterClass$RequestRenameSavedBill.getClass();
        if (this.traitCase_ != 63553 || this.trait_ == BillOuterClass$RequestRenameSavedBill.getDefaultInstance()) {
            this.trait_ = billOuterClass$RequestRenameSavedBill;
        } else {
            this.trait_ = ((BillOuterClass$RequestRenameSavedBill.a) BillOuterClass$RequestRenameSavedBill.newBuilder((BillOuterClass$RequestRenameSavedBill) this.trait_).v(billOuterClass$RequestRenameSavedBill)).j();
        }
        this.traitCase_ = RENAME_SAVED_BILL_FIELD_NUMBER;
    }

    private void mergeResetContacts(UsersOuterClass$RequestResetContacts usersOuterClass$RequestResetContacts) {
        usersOuterClass$RequestResetContacts.getClass();
        if (this.traitCase_ != 63661 || this.trait_ == UsersOuterClass$RequestResetContacts.getDefaultInstance()) {
            this.trait_ = usersOuterClass$RequestResetContacts;
        } else {
            this.trait_ = ((UsersOuterClass$RequestResetContacts.a) UsersOuterClass$RequestResetContacts.newBuilder((UsersOuterClass$RequestResetContacts) this.trait_).v(usersOuterClass$RequestResetContacts)).j();
        }
        this.traitCase_ = RESET_CONTACTS_FIELD_NUMBER;
    }

    private void mergeResponseAddDestinationCards(SapOuterClass$ResponseAddDestinationCards sapOuterClass$ResponseAddDestinationCards) {
        sapOuterClass$ResponseAddDestinationCards.getClass();
        if (this.traitCase_ != 63589 || this.trait_ == SapOuterClass$ResponseAddDestinationCards.getDefaultInstance()) {
            this.trait_ = sapOuterClass$ResponseAddDestinationCards;
        } else {
            this.trait_ = ((SapOuterClass$ResponseAddDestinationCards.a) SapOuterClass$ResponseAddDestinationCards.newBuilder((SapOuterClass$ResponseAddDestinationCards) this.trait_).v(sapOuterClass$ResponseAddDestinationCards)).j();
        }
        this.traitCase_ = RESPONSE_ADD_DESTINATION_CARDS_FIELD_NUMBER;
    }

    private void mergeResponseAddNewCards(SapOuterClass$ResponseAddNewCards sapOuterClass$ResponseAddNewCards) {
        sapOuterClass$ResponseAddNewCards.getClass();
        if (this.traitCase_ != 63556 || this.trait_ == SapOuterClass$ResponseAddNewCards.getDefaultInstance()) {
            this.trait_ = sapOuterClass$ResponseAddNewCards;
        } else {
            this.trait_ = ((SapOuterClass$ResponseAddNewCards.a) SapOuterClass$ResponseAddNewCards.newBuilder((SapOuterClass$ResponseAddNewCards) this.trait_).v(sapOuterClass$ResponseAddNewCards)).j();
        }
        this.traitCase_ = RESPONSE_ADD_NEW_CARDS_FIELD_NUMBER;
    }

    private void mergeResponseAuth(AuthOuterClass$ResponseAuth authOuterClass$ResponseAuth) {
        authOuterClass$ResponseAuth.getClass();
        if (this.traitCase_ != 5 || this.trait_ == AuthOuterClass$ResponseAuth.getDefaultInstance()) {
            this.trait_ = authOuterClass$ResponseAuth;
        } else {
            this.trait_ = ((AuthOuterClass$ResponseAuth.a) AuthOuterClass$ResponseAuth.newBuilder((AuthOuterClass$ResponseAuth) this.trait_).v(authOuterClass$ResponseAuth)).j();
        }
        this.traitCase_ = 5;
    }

    private void mergeResponseAuthorizeUser(SefteOuterClass$ResponseAuthorizeUser sefteOuterClass$ResponseAuthorizeUser) {
        sefteOuterClass$ResponseAuthorizeUser.getClass();
        if (this.traitCase_ != 63607 || this.trait_ == SefteOuterClass$ResponseAuthorizeUser.getDefaultInstance()) {
            this.trait_ = sefteOuterClass$ResponseAuthorizeUser;
        } else {
            this.trait_ = ((SefteOuterClass$ResponseAuthorizeUser.a) SefteOuterClass$ResponseAuthorizeUser.newBuilder((SefteOuterClass$ResponseAuthorizeUser) this.trait_).v(sefteOuterClass$ResponseAuthorizeUser)).j();
        }
        this.traitCase_ = RESPONSE_AUTHORIZE_USER_FIELD_NUMBER;
    }

    private void mergeResponseBool(Misc$ResponseBool misc$ResponseBool) {
        misc$ResponseBool.getClass();
        if (this.traitCase_ != 209 || this.trait_ == Misc$ResponseBool.getDefaultInstance()) {
            this.trait_ = misc$ResponseBool;
        } else {
            this.trait_ = ((Misc$ResponseBool.a) Misc$ResponseBool.newBuilder((Misc$ResponseBool) this.trait_).v(misc$ResponseBool)).j();
        }
        this.traitCase_ = 209;
    }

    private void mergeResponseBuyCharge(Charnet$ResponseBuyCharge charnet$ResponseBuyCharge) {
        charnet$ResponseBuyCharge.getClass();
        if (this.traitCase_ != 63538 || this.trait_ == Charnet$ResponseBuyCharge.getDefaultInstance()) {
            this.trait_ = charnet$ResponseBuyCharge;
        } else {
            this.trait_ = ((Charnet$ResponseBuyCharge.a) Charnet$ResponseBuyCharge.newBuilder((Charnet$ResponseBuyCharge) this.trait_).v(charnet$ResponseBuyCharge)).j();
        }
        this.traitCase_ = RESPONSE_BUY_CHARGE_FIELD_NUMBER;
    }

    private void mergeResponseBuyFastCharge(BankOuterClass$ResponseBuyFastCharge bankOuterClass$ResponseBuyFastCharge) {
        bankOuterClass$ResponseBuyFastCharge.getClass();
        if (this.traitCase_ != 62465 || this.trait_ == BankOuterClass$ResponseBuyFastCharge.getDefaultInstance()) {
            this.trait_ = bankOuterClass$ResponseBuyFastCharge;
        } else {
            this.trait_ = ((BankOuterClass$ResponseBuyFastCharge.a) BankOuterClass$ResponseBuyFastCharge.newBuilder((BankOuterClass$ResponseBuyFastCharge) this.trait_).v(bankOuterClass$ResponseBuyFastCharge)).j();
        }
        this.traitCase_ = RESPONSE_BUY_FAST_CHARGE_FIELD_NUMBER;
    }

    private void mergeResponseBuyInternetBundle(Charnet$ResponseBuyInternetBundle charnet$ResponseBuyInternetBundle) {
        charnet$ResponseBuyInternetBundle.getClass();
        if (this.traitCase_ != 63540 || this.trait_ == Charnet$ResponseBuyInternetBundle.getDefaultInstance()) {
            this.trait_ = charnet$ResponseBuyInternetBundle;
        } else {
            this.trait_ = ((Charnet$ResponseBuyInternetBundle.a) Charnet$ResponseBuyInternetBundle.newBuilder((Charnet$ResponseBuyInternetBundle) this.trait_).v(charnet$ResponseBuyInternetBundle)).j();
        }
        this.traitCase_ = RESPONSE_BUY_INTERNET_BUNDLE_FIELD_NUMBER;
    }

    private void mergeResponseBuyVoucher(ClubOuterClass$ResponseBuyVoucher clubOuterClass$ResponseBuyVoucher) {
        clubOuterClass$ResponseBuyVoucher.getClass();
        if (this.traitCase_ != 63475 || this.trait_ == ClubOuterClass$ResponseBuyVoucher.getDefaultInstance()) {
            this.trait_ = clubOuterClass$ResponseBuyVoucher;
        } else {
            this.trait_ = ((ClubOuterClass$ResponseBuyVoucher.a) ClubOuterClass$ResponseBuyVoucher.newBuilder((ClubOuterClass$ResponseBuyVoucher) this.trait_).v(clubOuterClass$ResponseBuyVoucher)).j();
        }
        this.traitCase_ = RESPONSE_BUY_VOUCHER_FIELD_NUMBER;
    }

    private void mergeResponseBuyWheelChance(ClubOuterClass$ResponseBuyWheelChance clubOuterClass$ResponseBuyWheelChance) {
        clubOuterClass$ResponseBuyWheelChance.getClass();
        if (this.traitCase_ != 63467 || this.trait_ == ClubOuterClass$ResponseBuyWheelChance.getDefaultInstance()) {
            this.trait_ = clubOuterClass$ResponseBuyWheelChance;
        } else {
            this.trait_ = ((ClubOuterClass$ResponseBuyWheelChance.a) ClubOuterClass$ResponseBuyWheelChance.newBuilder((ClubOuterClass$ResponseBuyWheelChance) this.trait_).v(clubOuterClass$ResponseBuyWheelChance)).j();
        }
        this.traitCase_ = RESPONSE_BUY_WHEEL_CHANCE_FIELD_NUMBER;
    }

    private void mergeResponseCall(MeetOuterClass$ResponseCall meetOuterClass$ResponseCall) {
        meetOuterClass$ResponseCall.getClass();
        if (this.traitCase_ != 63581 || this.trait_ == MeetOuterClass$ResponseCall.getDefaultInstance()) {
            this.trait_ = meetOuterClass$ResponseCall;
        } else {
            this.trait_ = ((MeetOuterClass$ResponseCall.a) MeetOuterClass$ResponseCall.newBuilder((MeetOuterClass$ResponseCall) this.trait_).v(meetOuterClass$ResponseCall)).j();
        }
        this.traitCase_ = RESPONSE_CALL_FIELD_NUMBER;
    }

    private void mergeResponseCanSeeMessages(GroupsOuterClass$ResponseCanSeeMessages groupsOuterClass$ResponseCanSeeMessages) {
        groupsOuterClass$ResponseCanSeeMessages.getClass();
        if (this.traitCase_ != 725 || this.trait_ == GroupsOuterClass$ResponseCanSeeMessages.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$ResponseCanSeeMessages;
        } else {
            this.trait_ = ((GroupsOuterClass$ResponseCanSeeMessages.a) GroupsOuterClass$ResponseCanSeeMessages.newBuilder((GroupsOuterClass$ResponseCanSeeMessages) this.trait_).v(groupsOuterClass$ResponseCanSeeMessages)).j();
        }
        this.traitCase_ = RESPONSE_CAN_SEE_MESSAGES_FIELD_NUMBER;
    }

    private void mergeResponseCashoutKifpool(KifpoolOuterClass$ResponseCashOutKifpool kifpoolOuterClass$ResponseCashOutKifpool) {
        kifpoolOuterClass$ResponseCashOutKifpool.getClass();
        if (this.traitCase_ != 63408 || this.trait_ == KifpoolOuterClass$ResponseCashOutKifpool.getDefaultInstance()) {
            this.trait_ = kifpoolOuterClass$ResponseCashOutKifpool;
        } else {
            this.trait_ = ((KifpoolOuterClass$ResponseCashOutKifpool.a) KifpoolOuterClass$ResponseCashOutKifpool.newBuilder((KifpoolOuterClass$ResponseCashOutKifpool) this.trait_).v(kifpoolOuterClass$ResponseCashOutKifpool)).j();
        }
        this.traitCase_ = RESPONSE_CASHOUT_KIFPOOL_FIELD_NUMBER;
    }

    private void mergeResponseChangePointToMoney(ClubOuterClass$ResponseChangePointToMoney clubOuterClass$ResponseChangePointToMoney) {
        clubOuterClass$ResponseChangePointToMoney.getClass();
        if (this.traitCase_ != 63465 || this.trait_ == ClubOuterClass$ResponseChangePointToMoney.getDefaultInstance()) {
            this.trait_ = clubOuterClass$ResponseChangePointToMoney;
        } else {
            this.trait_ = ((ClubOuterClass$ResponseChangePointToMoney.a) ClubOuterClass$ResponseChangePointToMoney.newBuilder((ClubOuterClass$ResponseChangePointToMoney) this.trait_).v(clubOuterClass$ResponseChangePointToMoney)).j();
        }
        this.traitCase_ = RESPONSE_CHANGE_POINT_TO_MONEY_FIELD_NUMBER;
    }

    private void mergeResponseCharge(KifpoolOuterClass$ResponseCharge kifpoolOuterClass$ResponseCharge) {
        kifpoolOuterClass$ResponseCharge.getClass();
        if (this.traitCase_ != 63416 || this.trait_ == KifpoolOuterClass$ResponseCharge.getDefaultInstance()) {
            this.trait_ = kifpoolOuterClass$ResponseCharge;
        } else {
            this.trait_ = ((KifpoolOuterClass$ResponseCharge.a) KifpoolOuterClass$ResponseCharge.newBuilder((KifpoolOuterClass$ResponseCharge) this.trait_).v(kifpoolOuterClass$ResponseCharge)).j();
        }
        this.traitCase_ = RESPONSE_CHARGE_FIELD_NUMBER;
    }

    private void mergeResponseCheckChargePermission(KifpoolOuterClass$ResponseCheckChargePermission kifpoolOuterClass$ResponseCheckChargePermission) {
        kifpoolOuterClass$ResponseCheckChargePermission.getClass();
        if (this.traitCase_ != 63414 || this.trait_ == KifpoolOuterClass$ResponseCheckChargePermission.getDefaultInstance()) {
            this.trait_ = kifpoolOuterClass$ResponseCheckChargePermission;
        } else {
            this.trait_ = ((KifpoolOuterClass$ResponseCheckChargePermission.a) KifpoolOuterClass$ResponseCheckChargePermission.newBuilder((KifpoolOuterClass$ResponseCheckChargePermission) this.trait_).v(kifpoolOuterClass$ResponseCheckChargePermission)).j();
        }
        this.traitCase_ = RESPONSE_CHECK_CHARGE_PERMISSION_FIELD_NUMBER;
    }

    private void mergeResponseCreateGroup(GroupsOuterClass$ResponseCreateGroup groupsOuterClass$ResponseCreateGroup) {
        groupsOuterClass$ResponseCreateGroup.getClass();
        if (this.traitCase_ != 216 || this.trait_ == GroupsOuterClass$ResponseCreateGroup.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$ResponseCreateGroup;
        } else {
            this.trait_ = ((GroupsOuterClass$ResponseCreateGroup.a) GroupsOuterClass$ResponseCreateGroup.newBuilder((GroupsOuterClass$ResponseCreateGroup) this.trait_).v(groupsOuterClass$ResponseCreateGroup)).j();
        }
        this.traitCase_ = 216;
    }

    private void mergeResponseCreateKifpool(KifpoolOuterClass$ResponseCreateKifpool kifpoolOuterClass$ResponseCreateKifpool) {
        kifpoolOuterClass$ResponseCreateKifpool.getClass();
        if (this.traitCase_ != 63405 || this.trait_ == KifpoolOuterClass$ResponseCreateKifpool.getDefaultInstance()) {
            this.trait_ = kifpoolOuterClass$ResponseCreateKifpool;
        } else {
            this.trait_ = ((KifpoolOuterClass$ResponseCreateKifpool.a) KifpoolOuterClass$ResponseCreateKifpool.newBuilder((KifpoolOuterClass$ResponseCreateKifpool) this.trait_).v(kifpoolOuterClass$ResponseCreateKifpool)).j();
        }
        this.traitCase_ = RESPONSE_CREATE_KIFPOOL_FIELD_NUMBER;
    }

    private void mergeResponseCreateSavedBill(BillOuterClass$ResponseCreateSavedBill billOuterClass$ResponseCreateSavedBill) {
        billOuterClass$ResponseCreateSavedBill.getClass();
        if (this.traitCase_ != 63550 || this.trait_ == BillOuterClass$ResponseCreateSavedBill.getDefaultInstance()) {
            this.trait_ = billOuterClass$ResponseCreateSavedBill;
        } else {
            this.trait_ = ((BillOuterClass$ResponseCreateSavedBill.a) BillOuterClass$ResponseCreateSavedBill.newBuilder((BillOuterClass$ResponseCreateSavedBill) this.trait_).v(billOuterClass$ResponseCreateSavedBill)).j();
        }
        this.traitCase_ = RESPONSE_CREATE_SAVED_BILL_FIELD_NUMBER;
    }

    private void mergeResponseCryptoTransfer(KifpoolOuterClass$ResponseCryptoTransfer kifpoolOuterClass$ResponseCryptoTransfer) {
        kifpoolOuterClass$ResponseCryptoTransfer.getClass();
        if (this.traitCase_ != 63633 || this.trait_ == KifpoolOuterClass$ResponseCryptoTransfer.getDefaultInstance()) {
            this.trait_ = kifpoolOuterClass$ResponseCryptoTransfer;
        } else {
            this.trait_ = ((KifpoolOuterClass$ResponseCryptoTransfer.a) KifpoolOuterClass$ResponseCryptoTransfer.newBuilder((KifpoolOuterClass$ResponseCryptoTransfer) this.trait_).v(kifpoolOuterClass$ResponseCryptoTransfer)).j();
        }
        this.traitCase_ = RESPONSE_CRYPTO_TRANSFER_FIELD_NUMBER;
    }

    private void mergeResponseDialogsOrder(MessagingOuterClass$ResponseDialogsOrder messagingOuterClass$ResponseDialogsOrder) {
        messagingOuterClass$ResponseDialogsOrder.getClass();
        if (this.traitCase_ != 235 || this.trait_ == MessagingOuterClass$ResponseDialogsOrder.getDefaultInstance()) {
            this.trait_ = messagingOuterClass$ResponseDialogsOrder;
        } else {
            this.trait_ = ((MessagingOuterClass$ResponseDialogsOrder.a) MessagingOuterClass$ResponseDialogsOrder.newBuilder((MessagingOuterClass$ResponseDialogsOrder) this.trait_).v(messagingOuterClass$ResponseDialogsOrder)).j();
        }
        this.traitCase_ = RESPONSE_DIALOGS_ORDER_FIELD_NUMBER;
    }

    private void mergeResponseEditAvatar(UsersOuterClass$ResponseEditAvatar usersOuterClass$ResponseEditAvatar) {
        usersOuterClass$ResponseEditAvatar.getClass();
        if (this.traitCase_ != 103 || this.trait_ == UsersOuterClass$ResponseEditAvatar.getDefaultInstance()) {
            this.trait_ = usersOuterClass$ResponseEditAvatar;
        } else {
            this.trait_ = ((UsersOuterClass$ResponseEditAvatar.a) UsersOuterClass$ResponseEditAvatar.newBuilder((UsersOuterClass$ResponseEditAvatar) this.trait_).v(usersOuterClass$ResponseEditAvatar)).j();
        }
        this.traitCase_ = 103;
    }

    private void mergeResponseEditGroupAvatar(GroupsOuterClass$ResponseEditGroupAvatar groupsOuterClass$ResponseEditGroupAvatar) {
        groupsOuterClass$ResponseEditGroupAvatar.getClass();
        if (this.traitCase_ != 115 || this.trait_ == GroupsOuterClass$ResponseEditGroupAvatar.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$ResponseEditGroupAvatar;
        } else {
            this.trait_ = ((GroupsOuterClass$ResponseEditGroupAvatar.a) GroupsOuterClass$ResponseEditGroupAvatar.newBuilder((GroupsOuterClass$ResponseEditGroupAvatar) this.trait_).v(groupsOuterClass$ResponseEditGroupAvatar)).j();
        }
        this.traitCase_ = 115;
    }

    private void mergeResponseEnrollNewCard(SapOuterClass$ResponseEnrollNewCard sapOuterClass$ResponseEnrollNewCard) {
        sapOuterClass$ResponseEnrollNewCard.getClass();
        if (this.traitCase_ != 63488 || this.trait_ == SapOuterClass$ResponseEnrollNewCard.getDefaultInstance()) {
            this.trait_ = sapOuterClass$ResponseEnrollNewCard;
        } else {
            this.trait_ = ((SapOuterClass$ResponseEnrollNewCard.a) SapOuterClass$ResponseEnrollNewCard.newBuilder((SapOuterClass$ResponseEnrollNewCard) this.trait_).v(sapOuterClass$ResponseEnrollNewCard)).j();
        }
        this.traitCase_ = RESPONSE_ENROLL_NEW_CARD_FIELD_NUMBER;
    }

    private void mergeResponseFetchGroupAdmins(GroupsOuterClass$ResponseFetchGroupAdmins groupsOuterClass$ResponseFetchGroupAdmins) {
        groupsOuterClass$ResponseFetchGroupAdmins.getClass();
        if (this.traitCase_ != 730 || this.trait_ == GroupsOuterClass$ResponseFetchGroupAdmins.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$ResponseFetchGroupAdmins;
        } else {
            this.trait_ = ((GroupsOuterClass$ResponseFetchGroupAdmins.a) GroupsOuterClass$ResponseFetchGroupAdmins.newBuilder((GroupsOuterClass$ResponseFetchGroupAdmins) this.trait_).v(groupsOuterClass$ResponseFetchGroupAdmins)).j();
        }
        this.traitCase_ = RESPONSE_FETCH_GROUP_ADMINS_FIELD_NUMBER;
    }

    private void mergeResponseFilterTaggedTransactions(PfmOuterClass$ResponseFilterTaggedTransactions pfmOuterClass$ResponseFilterTaggedTransactions) {
        pfmOuterClass$ResponseFilterTaggedTransactions.getClass();
        if (this.traitCase_ != 63631 || this.trait_ == PfmOuterClass$ResponseFilterTaggedTransactions.getDefaultInstance()) {
            this.trait_ = pfmOuterClass$ResponseFilterTaggedTransactions;
        } else {
            this.trait_ = ((PfmOuterClass$ResponseFilterTaggedTransactions.a) PfmOuterClass$ResponseFilterTaggedTransactions.newBuilder((PfmOuterClass$ResponseFilterTaggedTransactions) this.trait_).v(pfmOuterClass$ResponseFilterTaggedTransactions)).j();
        }
        this.traitCase_ = RESPONSE_FILTER_TAGGED_TRANSACTIONS_FIELD_NUMBER;
    }

    private void mergeResponseGetAcquiredVouchers(ClubOuterClass$ResponseGetAcquiredVouchers clubOuterClass$ResponseGetAcquiredVouchers) {
        clubOuterClass$ResponseGetAcquiredVouchers.getClass();
        if (this.traitCase_ != 63638 || this.trait_ == ClubOuterClass$ResponseGetAcquiredVouchers.getDefaultInstance()) {
            this.trait_ = clubOuterClass$ResponseGetAcquiredVouchers;
        } else {
            this.trait_ = ((ClubOuterClass$ResponseGetAcquiredVouchers.a) ClubOuterClass$ResponseGetAcquiredVouchers.newBuilder((ClubOuterClass$ResponseGetAcquiredVouchers) this.trait_).v(clubOuterClass$ResponseGetAcquiredVouchers)).j();
        }
        this.traitCase_ = RESPONSE_GET_ACQUIRED_VOUCHERS_FIELD_NUMBER;
    }

    private void mergeResponseGetAdProvider(AdvertisementOuterClass$ResponseGetAdProvider advertisementOuterClass$ResponseGetAdProvider) {
        advertisementOuterClass$ResponseGetAdProvider.getClass();
        if (this.traitCase_ != 63526 || this.trait_ == AdvertisementOuterClass$ResponseGetAdProvider.getDefaultInstance()) {
            this.trait_ = advertisementOuterClass$ResponseGetAdProvider;
        } else {
            this.trait_ = ((AdvertisementOuterClass$ResponseGetAdProvider.a) AdvertisementOuterClass$ResponseGetAdProvider.newBuilder((AdvertisementOuterClass$ResponseGetAdProvider) this.trait_).v(advertisementOuterClass$ResponseGetAdProvider)).j();
        }
        this.traitCase_ = RESPONSE_GET_AD_PROVIDER_FIELD_NUMBER;
    }

    private void mergeResponseGetAuthSessions(AuthOuterClass$ResponseGetAuthSessions authOuterClass$ResponseGetAuthSessions) {
        authOuterClass$ResponseGetAuthSessions.getClass();
        if (this.traitCase_ != 81 || this.trait_ == AuthOuterClass$ResponseGetAuthSessions.getDefaultInstance()) {
            this.trait_ = authOuterClass$ResponseGetAuthSessions;
        } else {
            this.trait_ = ((AuthOuterClass$ResponseGetAuthSessions.a) AuthOuterClass$ResponseGetAuthSessions.newBuilder((AuthOuterClass$ResponseGetAuthSessions) this.trait_).v(authOuterClass$ResponseGetAuthSessions)).j();
        }
        this.traitCase_ = 81;
    }

    private void mergeResponseGetBamServiceToken(Microbanki$ResponseGetBamServiceToken microbanki$ResponseGetBamServiceToken) {
        microbanki$ResponseGetBamServiceToken.getClass();
        if (this.traitCase_ != 62407 || this.trait_ == Microbanki$ResponseGetBamServiceToken.getDefaultInstance()) {
            this.trait_ = microbanki$ResponseGetBamServiceToken;
        } else {
            this.trait_ = ((Microbanki$ResponseGetBamServiceToken.a) Microbanki$ResponseGetBamServiceToken.newBuilder((Microbanki$ResponseGetBamServiceToken) this.trait_).v(microbanki$ResponseGetBamServiceToken)).j();
        }
        this.traitCase_ = RESPONSE_GET_BAM_SERVICE_TOKEN_FIELD_NUMBER;
    }

    private void mergeResponseGetBillHistory(BillOuterClass$ResponseGetBillHistory billOuterClass$ResponseGetBillHistory) {
        billOuterClass$ResponseGetBillHistory.getClass();
        if (this.traitCase_ != 63548 || this.trait_ == BillOuterClass$ResponseGetBillHistory.getDefaultInstance()) {
            this.trait_ = billOuterClass$ResponseGetBillHistory;
        } else {
            this.trait_ = ((BillOuterClass$ResponseGetBillHistory.a) BillOuterClass$ResponseGetBillHistory.newBuilder((BillOuterClass$ResponseGetBillHistory) this.trait_).v(billOuterClass$ResponseGetBillHistory)).j();
        }
        this.traitCase_ = RESPONSE_GET_BILL_HISTORY_FIELD_NUMBER;
    }

    private void mergeResponseGetBotWhiteList(KetfOuterClass$ResponseGetBotWhiteList ketfOuterClass$ResponseGetBotWhiteList) {
        ketfOuterClass$ResponseGetBotWhiteList.getClass();
        if (this.traitCase_ != 3856 || this.trait_ == KetfOuterClass$ResponseGetBotWhiteList.getDefaultInstance()) {
            this.trait_ = ketfOuterClass$ResponseGetBotWhiteList;
        } else {
            this.trait_ = ((KetfOuterClass$ResponseGetBotWhiteList.a) KetfOuterClass$ResponseGetBotWhiteList.newBuilder((KetfOuterClass$ResponseGetBotWhiteList) this.trait_).v(ketfOuterClass$ResponseGetBotWhiteList)).j();
        }
        this.traitCase_ = RESPONSE_GET_BOT_WHITE_LIST_FIELD_NUMBER;
    }

    private void mergeResponseGetCardInfo(SapOuterClass$ResponseGetCardInfo sapOuterClass$ResponseGetCardInfo) {
        sapOuterClass$ResponseGetCardInfo.getClass();
        if (this.traitCase_ != 63490 || this.trait_ == SapOuterClass$ResponseGetCardInfo.getDefaultInstance()) {
            this.trait_ = sapOuterClass$ResponseGetCardInfo;
        } else {
            this.trait_ = ((SapOuterClass$ResponseGetCardInfo.a) SapOuterClass$ResponseGetCardInfo.newBuilder((SapOuterClass$ResponseGetCardInfo) this.trait_).v(sapOuterClass$ResponseGetCardInfo)).j();
        }
        this.traitCase_ = RESPONSE_GET_CARD_INFO_FIELD_NUMBER;
    }

    private void mergeResponseGetCardTransferToken(BankOuterClass$ResponseGetCardTransferToken bankOuterClass$ResponseGetCardTransferToken) {
        bankOuterClass$ResponseGetCardTransferToken.getClass();
        if (this.traitCase_ != 62126 || this.trait_ == BankOuterClass$ResponseGetCardTransferToken.getDefaultInstance()) {
            this.trait_ = bankOuterClass$ResponseGetCardTransferToken;
        } else {
            this.trait_ = ((BankOuterClass$ResponseGetCardTransferToken.a) BankOuterClass$ResponseGetCardTransferToken.newBuilder((BankOuterClass$ResponseGetCardTransferToken) this.trait_).v(bankOuterClass$ResponseGetCardTransferToken)).j();
        }
        this.traitCase_ = RESPONSE_GET_CARD_TRANSFER_TOKEN_FIELD_NUMBER;
    }

    private void mergeResponseGetCards(SapOuterClass$ResponseGetCards sapOuterClass$ResponseGetCards) {
        sapOuterClass$ResponseGetCards.getClass();
        if (this.traitCase_ != 63559 || this.trait_ == SapOuterClass$ResponseGetCards.getDefaultInstance()) {
            this.trait_ = sapOuterClass$ResponseGetCards;
        } else {
            this.trait_ = ((SapOuterClass$ResponseGetCards.a) SapOuterClass$ResponseGetCards.newBuilder((SapOuterClass$ResponseGetCards) this.trait_).v(sapOuterClass$ResponseGetCards)).j();
        }
        this.traitCase_ = RESPONSE_GET_CARDS_FIELD_NUMBER;
    }

    private void mergeResponseGetChannelAds(AdvertisementOuterClass$ResponseGetChannelAds advertisementOuterClass$ResponseGetChannelAds) {
        advertisementOuterClass$ResponseGetChannelAds.getClass();
        if (this.traitCase_ != 63265 || this.trait_ == AdvertisementOuterClass$ResponseGetChannelAds.getDefaultInstance()) {
            this.trait_ = advertisementOuterClass$ResponseGetChannelAds;
        } else {
            this.trait_ = ((AdvertisementOuterClass$ResponseGetChannelAds.a) AdvertisementOuterClass$ResponseGetChannelAds.newBuilder((AdvertisementOuterClass$ResponseGetChannelAds) this.trait_).v(advertisementOuterClass$ResponseGetChannelAds)).j();
        }
        this.traitCase_ = RESPONSE_GET_CHANNEL_ADS_FIELD_NUMBER;
    }

    private void mergeResponseGetChannelEarnMoneyInfo(AdvertisementOuterClass$ResponseGetChannelEarnMoneyInfo advertisementOuterClass$ResponseGetChannelEarnMoneyInfo) {
        advertisementOuterClass$ResponseGetChannelEarnMoneyInfo.getClass();
        if (this.traitCase_ != 63448 || this.trait_ == AdvertisementOuterClass$ResponseGetChannelEarnMoneyInfo.getDefaultInstance()) {
            this.trait_ = advertisementOuterClass$ResponseGetChannelEarnMoneyInfo;
        } else {
            this.trait_ = ((AdvertisementOuterClass$ResponseGetChannelEarnMoneyInfo.a) AdvertisementOuterClass$ResponseGetChannelEarnMoneyInfo.newBuilder((AdvertisementOuterClass$ResponseGetChannelEarnMoneyInfo) this.trait_).v(advertisementOuterClass$ResponseGetChannelEarnMoneyInfo)).j();
        }
        this.traitCase_ = RESPONSE_GET_CHANNEL_EARN_MONEY_INFO_FIELD_NUMBER;
    }

    private void mergeResponseGetChannelEarnMoneyStatus(AdvertisementOuterClass$ResponseGetChannelEarnMoneyStatus advertisementOuterClass$ResponseGetChannelEarnMoneyStatus) {
        advertisementOuterClass$ResponseGetChannelEarnMoneyStatus.getClass();
        if (this.traitCase_ != 63437 || this.trait_ == AdvertisementOuterClass$ResponseGetChannelEarnMoneyStatus.getDefaultInstance()) {
            this.trait_ = advertisementOuterClass$ResponseGetChannelEarnMoneyStatus;
        } else {
            this.trait_ = ((AdvertisementOuterClass$ResponseGetChannelEarnMoneyStatus.a) AdvertisementOuterClass$ResponseGetChannelEarnMoneyStatus.newBuilder((AdvertisementOuterClass$ResponseGetChannelEarnMoneyStatus) this.trait_).v(advertisementOuterClass$ResponseGetChannelEarnMoneyStatus)).j();
        }
        this.traitCase_ = RESPONSE_GET_CHANNEL_EARN_MONEY_STATUS_FIELD_NUMBER;
    }

    private void mergeResponseGetChargeAmounts(Saba$ResponseGetChargeAmounts saba$ResponseGetChargeAmounts) {
        saba$ResponseGetChargeAmounts.getClass();
        if (this.traitCase_ != 63511 || this.trait_ == Saba$ResponseGetChargeAmounts.getDefaultInstance()) {
            this.trait_ = saba$ResponseGetChargeAmounts;
        } else {
            this.trait_ = ((Saba$ResponseGetChargeAmounts.a) Saba$ResponseGetChargeAmounts.newBuilder((Saba$ResponseGetChargeAmounts) this.trait_).v(saba$ResponseGetChargeAmounts)).j();
        }
        this.traitCase_ = RESPONSE_GET_CHARGE_AMOUNTS_FIELD_NUMBER;
    }

    private void mergeResponseGetChargePaymentToken(KifpoolOuterClass$ResponseGetChargePaymentToken kifpoolOuterClass$ResponseGetChargePaymentToken) {
        kifpoolOuterClass$ResponseGetChargePaymentToken.getClass();
        if (this.traitCase_ != 63406 || this.trait_ == KifpoolOuterClass$ResponseGetChargePaymentToken.getDefaultInstance()) {
            this.trait_ = kifpoolOuterClass$ResponseGetChargePaymentToken;
        } else {
            this.trait_ = ((KifpoolOuterClass$ResponseGetChargePaymentToken.a) KifpoolOuterClass$ResponseGetChargePaymentToken.newBuilder((KifpoolOuterClass$ResponseGetChargePaymentToken) this.trait_).v(kifpoolOuterClass$ResponseGetChargePaymentToken)).j();
        }
        this.traitCase_ = RESPONSE_GET_CHARGE_PAYMENT_TOKEN_FIELD_NUMBER;
    }

    private void mergeResponseGetCitiesOfState(SefteOuterClass$ResponseGetCitiesOfState sefteOuterClass$ResponseGetCitiesOfState) {
        sefteOuterClass$ResponseGetCitiesOfState.getClass();
        if (this.traitCase_ != 63618 || this.trait_ == SefteOuterClass$ResponseGetCitiesOfState.getDefaultInstance()) {
            this.trait_ = sefteOuterClass$ResponseGetCitiesOfState;
        } else {
            this.trait_ = ((SefteOuterClass$ResponseGetCitiesOfState.a) SefteOuterClass$ResponseGetCitiesOfState.newBuilder((SefteOuterClass$ResponseGetCitiesOfState) this.trait_).v(sefteOuterClass$ResponseGetCitiesOfState)).j();
        }
        this.traitCase_ = RESPONSE_GET_CITIES_OF_STATE_FIELD_NUMBER;
    }

    private void mergeResponseGetContacts(UsersOuterClass$ResponseGetContacts usersOuterClass$ResponseGetContacts) {
        usersOuterClass$ResponseGetContacts.getClass();
        if (this.traitCase_ != 88 || this.trait_ == UsersOuterClass$ResponseGetContacts.getDefaultInstance()) {
            this.trait_ = usersOuterClass$ResponseGetContacts;
        } else {
            this.trait_ = ((UsersOuterClass$ResponseGetContacts.a) UsersOuterClass$ResponseGetContacts.newBuilder((UsersOuterClass$ResponseGetContacts) this.trait_).v(usersOuterClass$ResponseGetContacts)).j();
        }
        this.traitCase_ = 88;
    }

    private void mergeResponseGetCryptoWallets(KifpoolOuterClass$ResponseGetCryptoWallets kifpoolOuterClass$ResponseGetCryptoWallets) {
        kifpoolOuterClass$ResponseGetCryptoWallets.getClass();
        if (this.traitCase_ != 63635 || this.trait_ == KifpoolOuterClass$ResponseGetCryptoWallets.getDefaultInstance()) {
            this.trait_ = kifpoolOuterClass$ResponseGetCryptoWallets;
        } else {
            this.trait_ = ((KifpoolOuterClass$ResponseGetCryptoWallets.a) KifpoolOuterClass$ResponseGetCryptoWallets.newBuilder((KifpoolOuterClass$ResponseGetCryptoWallets) this.trait_).v(kifpoolOuterClass$ResponseGetCryptoWallets)).j();
        }
        this.traitCase_ = RESPONSE_GET_CRYPTO_WALLETS_FIELD_NUMBER;
    }

    private void mergeResponseGetDefaultCard(SapOuterClass$ResponseGetDefaultCard sapOuterClass$ResponseGetDefaultCard) {
        sapOuterClass$ResponseGetDefaultCard.getClass();
        if (this.traitCase_ != 63564 || this.trait_ == SapOuterClass$ResponseGetDefaultCard.getDefaultInstance()) {
            this.trait_ = sapOuterClass$ResponseGetDefaultCard;
        } else {
            this.trait_ = ((SapOuterClass$ResponseGetDefaultCard.a) SapOuterClass$ResponseGetDefaultCard.newBuilder((SapOuterClass$ResponseGetDefaultCard) this.trait_).v(sapOuterClass$ResponseGetDefaultCard)).j();
        }
        this.traitCase_ = RESPONSE_GET_DEFAULT_CARD_FIELD_NUMBER;
    }

    private void mergeResponseGetDestinationCardInfo(SapOuterClass$ResponseGetDestinationCardInfo sapOuterClass$ResponseGetDestinationCardInfo) {
        sapOuterClass$ResponseGetDestinationCardInfo.getClass();
        if (this.traitCase_ != 63492 || this.trait_ == SapOuterClass$ResponseGetDestinationCardInfo.getDefaultInstance()) {
            this.trait_ = sapOuterClass$ResponseGetDestinationCardInfo;
        } else {
            this.trait_ = ((SapOuterClass$ResponseGetDestinationCardInfo.a) SapOuterClass$ResponseGetDestinationCardInfo.newBuilder((SapOuterClass$ResponseGetDestinationCardInfo) this.trait_).v(sapOuterClass$ResponseGetDestinationCardInfo)).j();
        }
        this.traitCase_ = RESPONSE_GET_DESTINATION_CARD_INFO_FIELD_NUMBER;
    }

    private void mergeResponseGetDestinationCards(SapOuterClass$ResponseGetDestinationCards sapOuterClass$ResponseGetDestinationCards) {
        sapOuterClass$ResponseGetDestinationCards.getClass();
        if (this.traitCase_ != 63587 || this.trait_ == SapOuterClass$ResponseGetDestinationCards.getDefaultInstance()) {
            this.trait_ = sapOuterClass$ResponseGetDestinationCards;
        } else {
            this.trait_ = ((SapOuterClass$ResponseGetDestinationCards.a) SapOuterClass$ResponseGetDestinationCards.newBuilder((SapOuterClass$ResponseGetDestinationCards) this.trait_).v(sapOuterClass$ResponseGetDestinationCards)).j();
        }
        this.traitCase_ = RESPONSE_GET_DESTINATION_CARDS_FIELD_NUMBER;
    }

    private void mergeResponseGetDialogAdOrderDetails(AdvertisementOuterClass$ResponseGetDialogAdOrderDetails advertisementOuterClass$ResponseGetDialogAdOrderDetails) {
        advertisementOuterClass$ResponseGetDialogAdOrderDetails.getClass();
        if (this.traitCase_ != 63569 || this.trait_ == AdvertisementOuterClass$ResponseGetDialogAdOrderDetails.getDefaultInstance()) {
            this.trait_ = advertisementOuterClass$ResponseGetDialogAdOrderDetails;
        } else {
            this.trait_ = ((AdvertisementOuterClass$ResponseGetDialogAdOrderDetails.a) AdvertisementOuterClass$ResponseGetDialogAdOrderDetails.newBuilder((AdvertisementOuterClass$ResponseGetDialogAdOrderDetails) this.trait_).v(advertisementOuterClass$ResponseGetDialogAdOrderDetails)).j();
        }
        this.traitCase_ = RESPONSE_GET_DIALOG_AD_ORDER_DETAILS_FIELD_NUMBER;
    }

    private void mergeResponseGetDialogAdOrderPaymentToken(AdvertisementOuterClass$ResponseGetDialogAdOrderPaymentToken advertisementOuterClass$ResponseGetDialogAdOrderPaymentToken) {
        advertisementOuterClass$ResponseGetDialogAdOrderPaymentToken.getClass();
        if (this.traitCase_ != 63572 || this.trait_ == AdvertisementOuterClass$ResponseGetDialogAdOrderPaymentToken.getDefaultInstance()) {
            this.trait_ = advertisementOuterClass$ResponseGetDialogAdOrderPaymentToken;
        } else {
            this.trait_ = ((AdvertisementOuterClass$ResponseGetDialogAdOrderPaymentToken.a) AdvertisementOuterClass$ResponseGetDialogAdOrderPaymentToken.newBuilder((AdvertisementOuterClass$ResponseGetDialogAdOrderPaymentToken) this.trait_).v(advertisementOuterClass$ResponseGetDialogAdOrderPaymentToken)).j();
        }
        this.traitCase_ = RESPONSE_GET_DIALOG_AD_ORDER_PAYMENT_TOKEN_FIELD_NUMBER;
    }

    private void mergeResponseGetGiftPacketPaymentToken(Giftpacket$ResponseGetGiftPacketPaymentToken giftpacket$ResponseGetGiftPacketPaymentToken) {
        giftpacket$ResponseGetGiftPacketPaymentToken.getClass();
        if (this.traitCase_ != 63231 || this.trait_ == Giftpacket$ResponseGetGiftPacketPaymentToken.getDefaultInstance()) {
            this.trait_ = giftpacket$ResponseGetGiftPacketPaymentToken;
        } else {
            this.trait_ = ((Giftpacket$ResponseGetGiftPacketPaymentToken.a) Giftpacket$ResponseGetGiftPacketPaymentToken.newBuilder((Giftpacket$ResponseGetGiftPacketPaymentToken) this.trait_).v(giftpacket$ResponseGetGiftPacketPaymentToken)).j();
        }
        this.traitCase_ = RESPONSE_GET_GIFT_PACKET_PAYMENT_TOKEN_FIELD_NUMBER;
    }

    private void mergeResponseGetGroupDefaultCardNumber(GroupsOuterClass$ResponseGetGroupDefaultCardNumber groupsOuterClass$ResponseGetGroupDefaultCardNumber) {
        groupsOuterClass$ResponseGetGroupDefaultCardNumber.getClass();
        if (this.traitCase_ != 130 || this.trait_ == GroupsOuterClass$ResponseGetGroupDefaultCardNumber.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$ResponseGetGroupDefaultCardNumber;
        } else {
            this.trait_ = ((GroupsOuterClass$ResponseGetGroupDefaultCardNumber.a) GroupsOuterClass$ResponseGetGroupDefaultCardNumber.newBuilder((GroupsOuterClass$ResponseGetGroupDefaultCardNumber) this.trait_).v(groupsOuterClass$ResponseGetGroupDefaultCardNumber)).j();
        }
        this.traitCase_ = 130;
    }

    private void mergeResponseGetGroupDifference(Sequence$ResponseGetGroupDifference sequence$ResponseGetGroupDifference) {
        sequence$ResponseGetGroupDifference.getClass();
        if (this.traitCase_ != 204 || this.trait_ == Sequence$ResponseGetGroupDifference.getDefaultInstance()) {
            this.trait_ = sequence$ResponseGetGroupDifference;
        } else {
            this.trait_ = ((Sequence$ResponseGetGroupDifference.a) Sequence$ResponseGetGroupDifference.newBuilder((Sequence$ResponseGetGroupDifference) this.trait_).v(sequence$ResponseGetGroupDifference)).j();
        }
        this.traitCase_ = RESPONSE_GET_GROUP_DIFFERENCE_FIELD_NUMBER;
    }

    private void mergeResponseGetGroupMembersCount(GroupsOuterClass$ResponseGetGroupMembersCount groupsOuterClass$ResponseGetGroupMembersCount) {
        groupsOuterClass$ResponseGetGroupMembersCount.getClass();
        if (this.traitCase_ != 63504 || this.trait_ == GroupsOuterClass$ResponseGetGroupMembersCount.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$ResponseGetGroupMembersCount;
        } else {
            this.trait_ = ((GroupsOuterClass$ResponseGetGroupMembersCount.a) GroupsOuterClass$ResponseGetGroupMembersCount.newBuilder((GroupsOuterClass$ResponseGetGroupMembersCount) this.trait_).v(groupsOuterClass$ResponseGetGroupMembersCount)).j();
        }
        this.traitCase_ = RESPONSE_GET_GROUP_MEMBERS_COUNT_FIELD_NUMBER;
    }

    private void mergeResponseGetGroupMembersPresence(PresenceOuterClass$ResponseGetGroupMembersPresence presenceOuterClass$ResponseGetGroupMembersPresence) {
        presenceOuterClass$ResponseGetGroupMembersPresence.getClass();
        if (this.traitCase_ != 63643 || this.trait_ == PresenceOuterClass$ResponseGetGroupMembersPresence.getDefaultInstance()) {
            this.trait_ = presenceOuterClass$ResponseGetGroupMembersPresence;
        } else {
            this.trait_ = ((PresenceOuterClass$ResponseGetGroupMembersPresence.a) PresenceOuterClass$ResponseGetGroupMembersPresence.newBuilder((PresenceOuterClass$ResponseGetGroupMembersPresence) this.trait_).v(presenceOuterClass$ResponseGetGroupMembersPresence)).j();
        }
        this.traitCase_ = RESPONSE_GET_GROUP_MEMBERS_PRESENCE_FIELD_NUMBER;
    }

    private void mergeResponseGetGroupState(Sequence$ResponseGetGroupState sequence$ResponseGetGroupState) {
        sequence$ResponseGetGroupState.getClass();
        if (this.traitCase_ != 23 || this.trait_ == Sequence$ResponseGetGroupState.getDefaultInstance()) {
            this.trait_ = sequence$ResponseGetGroupState;
        } else {
            this.trait_ = ((Sequence$ResponseGetGroupState.a) Sequence$ResponseGetGroupState.newBuilder((Sequence$ResponseGetGroupState) this.trait_).v(sequence$ResponseGetGroupState)).j();
        }
        this.traitCase_ = 23;
    }

    private void mergeResponseGetInternetBundleList(Charnet$ResponseGetInternetBundleList charnet$ResponseGetInternetBundleList) {
        charnet$ResponseGetInternetBundleList.getClass();
        if (this.traitCase_ != 63533 || this.trait_ == Charnet$ResponseGetInternetBundleList.getDefaultInstance()) {
            this.trait_ = charnet$ResponseGetInternetBundleList;
        } else {
            this.trait_ = ((Charnet$ResponseGetInternetBundleList.a) Charnet$ResponseGetInternetBundleList.newBuilder((Charnet$ResponseGetInternetBundleList) this.trait_).v(charnet$ResponseGetInternetBundleList)).j();
        }
        this.traitCase_ = RESPONSE_GET_INTERNET_BUNDLE_LIST_FIELD_NUMBER;
    }

    private void mergeResponseGetInternetBundlePaymentToken(Charnet$ResponseGetInternetBundlePaymentToken charnet$ResponseGetInternetBundlePaymentToken) {
        charnet$ResponseGetInternetBundlePaymentToken.getClass();
        if (this.traitCase_ != 63531 || this.trait_ == Charnet$ResponseGetInternetBundlePaymentToken.getDefaultInstance()) {
            this.trait_ = charnet$ResponseGetInternetBundlePaymentToken;
        } else {
            this.trait_ = ((Charnet$ResponseGetInternetBundlePaymentToken.a) Charnet$ResponseGetInternetBundlePaymentToken.newBuilder((Charnet$ResponseGetInternetBundlePaymentToken) this.trait_).v(charnet$ResponseGetInternetBundlePaymentToken)).j();
        }
        this.traitCase_ = RESPONSE_GET_INTERNET_BUNDLE_PAYMENT_TOKEN_FIELD_NUMBER;
    }

    private void mergeResponseGetJwtToken(AuthOuterClass$ResponseGetJWTToken authOuterClass$ResponseGetJWTToken) {
        authOuterClass$ResponseGetJWTToken.getClass();
        if (this.traitCase_ != 601 || this.trait_ == AuthOuterClass$ResponseGetJWTToken.getDefaultInstance()) {
            this.trait_ = authOuterClass$ResponseGetJWTToken;
        } else {
            this.trait_ = ((AuthOuterClass$ResponseGetJWTToken.a) AuthOuterClass$ResponseGetJWTToken.newBuilder((AuthOuterClass$ResponseGetJWTToken) this.trait_).v(authOuterClass$ResponseGetJWTToken)).j();
        }
        this.traitCase_ = RESPONSE_GET_JWT_TOKEN_FIELD_NUMBER;
    }

    private void mergeResponseGetKifpoolOwner(KifpoolOuterClass$ResponseGetKifpoolOwner kifpoolOuterClass$ResponseGetKifpoolOwner) {
        kifpoolOuterClass$ResponseGetKifpoolOwner.getClass();
        if (this.traitCase_ != 63421 || this.trait_ == KifpoolOuterClass$ResponseGetKifpoolOwner.getDefaultInstance()) {
            this.trait_ = kifpoolOuterClass$ResponseGetKifpoolOwner;
        } else {
            this.trait_ = ((KifpoolOuterClass$ResponseGetKifpoolOwner.a) KifpoolOuterClass$ResponseGetKifpoolOwner.newBuilder((KifpoolOuterClass$ResponseGetKifpoolOwner) this.trait_).v(kifpoolOuterClass$ResponseGetKifpoolOwner)).j();
        }
        this.traitCase_ = RESPONSE_GET_KIFPOOL_OWNER_FIELD_NUMBER;
    }

    private void mergeResponseGetLinkPreview(EnrichmentOuterClass$ResponseGetLinkPreview enrichmentOuterClass$ResponseGetLinkPreview) {
        enrichmentOuterClass$ResponseGetLinkPreview.getClass();
        if (this.traitCase_ != 63498 || this.trait_ == EnrichmentOuterClass$ResponseGetLinkPreview.getDefaultInstance()) {
            this.trait_ = enrichmentOuterClass$ResponseGetLinkPreview;
        } else {
            this.trait_ = ((EnrichmentOuterClass$ResponseGetLinkPreview.a) EnrichmentOuterClass$ResponseGetLinkPreview.newBuilder((EnrichmentOuterClass$ResponseGetLinkPreview) this.trait_).v(enrichmentOuterClass$ResponseGetLinkPreview)).j();
        }
        this.traitCase_ = RESPONSE_GET_LINK_PREVIEW_FIELD_NUMBER;
    }

    private void mergeResponseGetLoanInfo(MelonOuterClass$ResponseGetLoanInfo melonOuterClass$ResponseGetLoanInfo) {
        melonOuterClass$ResponseGetLoanInfo.getClass();
        if (this.traitCase_ != 63583 || this.trait_ == MelonOuterClass$ResponseGetLoanInfo.getDefaultInstance()) {
            this.trait_ = melonOuterClass$ResponseGetLoanInfo;
        } else {
            this.trait_ = ((MelonOuterClass$ResponseGetLoanInfo.a) MelonOuterClass$ResponseGetLoanInfo.newBuilder((MelonOuterClass$ResponseGetLoanInfo) this.trait_).v(melonOuterClass$ResponseGetLoanInfo)).j();
        }
        this.traitCase_ = RESPONSE_GET_LOAN_INFO_FIELD_NUMBER;
    }

    private void mergeResponseGetLoansList(MelonOuterClass$ResponseGetLoansList melonOuterClass$ResponseGetLoansList) {
        melonOuterClass$ResponseGetLoansList.getClass();
        if (this.traitCase_ != 63585 || this.trait_ == MelonOuterClass$ResponseGetLoansList.getDefaultInstance()) {
            this.trait_ = melonOuterClass$ResponseGetLoansList;
        } else {
            this.trait_ = ((MelonOuterClass$ResponseGetLoansList.a) MelonOuterClass$ResponseGetLoansList.newBuilder((MelonOuterClass$ResponseGetLoansList) this.trait_).v(melonOuterClass$ResponseGetLoansList)).j();
        }
        this.traitCase_ = RESPONSE_GET_LOANS_LIST_FIELD_NUMBER;
    }

    private void mergeResponseGetMemberPermissions(GroupsOuterClass$ResponseGetMemberPermissions groupsOuterClass$ResponseGetMemberPermissions) {
        groupsOuterClass$ResponseGetMemberPermissions.getClass();
        if (this.traitCase_ != 63457 || this.trait_ == GroupsOuterClass$ResponseGetMemberPermissions.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$ResponseGetMemberPermissions;
        } else {
            this.trait_ = ((GroupsOuterClass$ResponseGetMemberPermissions.a) GroupsOuterClass$ResponseGetMemberPermissions.newBuilder((GroupsOuterClass$ResponseGetMemberPermissions) this.trait_).v(groupsOuterClass$ResponseGetMemberPermissions)).j();
        }
        this.traitCase_ = RESPONSE_GET_MEMBER_PERMISSIONS_FIELD_NUMBER;
    }

    private void mergeResponseGetMessagesRepliesInfo(MessagingOuterClass$ResponseGetMessagesRepliesInfo messagingOuterClass$ResponseGetMessagesRepliesInfo) {
        messagingOuterClass$ResponseGetMessagesRepliesInfo.getClass();
        if (this.traitCase_ != 63664 || this.trait_ == MessagingOuterClass$ResponseGetMessagesRepliesInfo.getDefaultInstance()) {
            this.trait_ = messagingOuterClass$ResponseGetMessagesRepliesInfo;
        } else {
            this.trait_ = ((MessagingOuterClass$ResponseGetMessagesRepliesInfo.a) MessagingOuterClass$ResponseGetMessagesRepliesInfo.newBuilder((MessagingOuterClass$ResponseGetMessagesRepliesInfo) this.trait_).v(messagingOuterClass$ResponseGetMessagesRepliesInfo)).j();
        }
        this.traitCase_ = RESPONSE_GET_MESSAGES_REPLIES_INFO_FIELD_NUMBER;
    }

    private void mergeResponseGetMoneyRequestDetails(Microbanki$ResponseGetMoneyRequestDetails microbanki$ResponseGetMoneyRequestDetails) {
        microbanki$ResponseGetMoneyRequestDetails.getClass();
        if (this.traitCase_ != 62400 || this.trait_ == Microbanki$ResponseGetMoneyRequestDetails.getDefaultInstance()) {
            this.trait_ = microbanki$ResponseGetMoneyRequestDetails;
        } else {
            this.trait_ = ((Microbanki$ResponseGetMoneyRequestDetails.a) Microbanki$ResponseGetMoneyRequestDetails.newBuilder((Microbanki$ResponseGetMoneyRequestDetails) this.trait_).v(microbanki$ResponseGetMoneyRequestDetails)).j();
        }
        this.traitCase_ = RESPONSE_GET_MONEY_REQUEST_DETAILS_FIELD_NUMBER;
    }

    private void mergeResponseGetMoneyRequestPaymentList(Microbanki$ResponseGetMoneyRequestPaymentList microbanki$ResponseGetMoneyRequestPaymentList) {
        microbanki$ResponseGetMoneyRequestPaymentList.getClass();
        if (this.traitCase_ != 62402 || this.trait_ == Microbanki$ResponseGetMoneyRequestPaymentList.getDefaultInstance()) {
            this.trait_ = microbanki$ResponseGetMoneyRequestPaymentList;
        } else {
            this.trait_ = ((Microbanki$ResponseGetMoneyRequestPaymentList.a) Microbanki$ResponseGetMoneyRequestPaymentList.newBuilder((Microbanki$ResponseGetMoneyRequestPaymentList) this.trait_).v(microbanki$ResponseGetMoneyRequestPaymentList)).j();
        }
        this.traitCase_ = RESPONSE_GET_MONEY_REQUEST_PAYMENT_LIST_FIELD_NUMBER;
    }

    private void mergeResponseGetMoneyRequestPaymentTokenByCard(WalletOuterClass$ResponseGetMoneyRequestPaymentTokenByCard walletOuterClass$ResponseGetMoneyRequestPaymentTokenByCard) {
        walletOuterClass$ResponseGetMoneyRequestPaymentTokenByCard.getClass();
        if (this.traitCase_ != 62770 || this.trait_ == WalletOuterClass$ResponseGetMoneyRequestPaymentTokenByCard.getDefaultInstance()) {
            this.trait_ = walletOuterClass$ResponseGetMoneyRequestPaymentTokenByCard;
        } else {
            this.trait_ = ((WalletOuterClass$ResponseGetMoneyRequestPaymentTokenByCard.a) WalletOuterClass$ResponseGetMoneyRequestPaymentTokenByCard.newBuilder((WalletOuterClass$ResponseGetMoneyRequestPaymentTokenByCard) this.trait_).v(walletOuterClass$ResponseGetMoneyRequestPaymentTokenByCard)).j();
        }
        this.traitCase_ = RESPONSE_GET_MONEY_REQUEST_PAYMENT_TOKEN_BY_CARD_FIELD_NUMBER;
    }

    private void mergeResponseGetMyBank(MyBankOuterClass$ResponseGetMyBank myBankOuterClass$ResponseGetMyBank) {
        myBankOuterClass$ResponseGetMyBank.getClass();
        if (this.traitCase_ != 63244 || this.trait_ == MyBankOuterClass$ResponseGetMyBank.getDefaultInstance()) {
            this.trait_ = myBankOuterClass$ResponseGetMyBank;
        } else {
            this.trait_ = ((MyBankOuterClass$ResponseGetMyBank.a) MyBankOuterClass$ResponseGetMyBank.newBuilder((MyBankOuterClass$ResponseGetMyBank) this.trait_).v(myBankOuterClass$ResponseGetMyBank)).j();
        }
        this.traitCase_ = RESPONSE_GET_MY_BANK_FIELD_NUMBER;
    }

    private void mergeResponseGetMyGroups(GroupsOuterClass$ResponseGetMyGroups groupsOuterClass$ResponseGetMyGroups) {
        groupsOuterClass$ResponseGetMyGroups.getClass();
        if (this.traitCase_ != 43747 || this.trait_ == GroupsOuterClass$ResponseGetMyGroups.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$ResponseGetMyGroups;
        } else {
            this.trait_ = ((GroupsOuterClass$ResponseGetMyGroups.a) GroupsOuterClass$ResponseGetMyGroups.newBuilder((GroupsOuterClass$ResponseGetMyGroups) this.trait_).v(groupsOuterClass$ResponseGetMyGroups)).j();
        }
        this.traitCase_ = RESPONSE_GET_MY_GROUPS_FIELD_NUMBER;
    }

    private void mergeResponseGetMyKifpools(KifpoolOuterClass$ResponseGetMyKifpools kifpoolOuterClass$ResponseGetMyKifpools) {
        kifpoolOuterClass$ResponseGetMyKifpools.getClass();
        if (this.traitCase_ != 63401 || this.trait_ == KifpoolOuterClass$ResponseGetMyKifpools.getDefaultInstance()) {
            this.trait_ = kifpoolOuterClass$ResponseGetMyKifpools;
        } else {
            this.trait_ = ((KifpoolOuterClass$ResponseGetMyKifpools.a) KifpoolOuterClass$ResponseGetMyKifpools.newBuilder((KifpoolOuterClass$ResponseGetMyKifpools) this.trait_).v(kifpoolOuterClass$ResponseGetMyKifpools)).j();
        }
        this.traitCase_ = RESPONSE_GET_MY_KIFPOOLS_FIELD_NUMBER;
    }

    private void mergeResponseGetMySentence(SentenceOuterClass$ResponseGetMySentence sentenceOuterClass$ResponseGetMySentence) {
        sentenceOuterClass$ResponseGetMySentence.getClass();
        if (this.traitCase_ != 63574 || this.trait_ == SentenceOuterClass$ResponseGetMySentence.getDefaultInstance()) {
            this.trait_ = sentenceOuterClass$ResponseGetMySentence;
        } else {
            this.trait_ = ((SentenceOuterClass$ResponseGetMySentence.a) SentenceOuterClass$ResponseGetMySentence.newBuilder((SentenceOuterClass$ResponseGetMySentence) this.trait_).v(sentenceOuterClass$ResponseGetMySentence)).j();
        }
        this.traitCase_ = RESPONSE_GET_MY_SENTENCE_FIELD_NUMBER;
    }

    private void mergeResponseGetMyWallets(WalletOuterClass$ResponseGetMyWallets walletOuterClass$ResponseGetMyWallets) {
        walletOuterClass$ResponseGetMyWallets.getClass();
        if (this.traitCase_ != 62731 || this.trait_ == WalletOuterClass$ResponseGetMyWallets.getDefaultInstance()) {
            this.trait_ = walletOuterClass$ResponseGetMyWallets;
        } else {
            this.trait_ = ((WalletOuterClass$ResponseGetMyWallets.a) WalletOuterClass$ResponseGetMyWallets.newBuilder((WalletOuterClass$ResponseGetMyWallets) this.trait_).v(walletOuterClass$ResponseGetMyWallets)).j();
        }
        this.traitCase_ = RESPONSE_GET_MY_WALLETS_FIELD_NUMBER;
    }

    private void mergeResponseGetNasimFilePublicUrl(FilesOuterClass$ResponseGetNasimFilePublicUrl filesOuterClass$ResponseGetNasimFilePublicUrl) {
        filesOuterClass$ResponseGetNasimFilePublicUrl.getClass();
        if (this.traitCase_ != 3056 || this.trait_ == FilesOuterClass$ResponseGetNasimFilePublicUrl.getDefaultInstance()) {
            this.trait_ = filesOuterClass$ResponseGetNasimFilePublicUrl;
        } else {
            this.trait_ = ((FilesOuterClass$ResponseGetNasimFilePublicUrl.a) FilesOuterClass$ResponseGetNasimFilePublicUrl.newBuilder((FilesOuterClass$ResponseGetNasimFilePublicUrl) this.trait_).v(filesOuterClass$ResponseGetNasimFilePublicUrl)).j();
        }
        this.traitCase_ = RESPONSE_GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER;
    }

    private void mergeResponseGetNasimFileUploadResume(FilesOuterClass$ResponseGetNasimFileUploadResume filesOuterClass$ResponseGetNasimFileUploadResume) {
        filesOuterClass$ResponseGetNasimFileUploadResume.getClass();
        if (this.traitCase_ != 3055 || this.trait_ == FilesOuterClass$ResponseGetNasimFileUploadResume.getDefaultInstance()) {
            this.trait_ = filesOuterClass$ResponseGetNasimFileUploadResume;
        } else {
            this.trait_ = ((FilesOuterClass$ResponseGetNasimFileUploadResume.a) FilesOuterClass$ResponseGetNasimFileUploadResume.newBuilder((FilesOuterClass$ResponseGetNasimFileUploadResume) this.trait_).v(filesOuterClass$ResponseGetNasimFileUploadResume)).j();
        }
        this.traitCase_ = RESPONSE_GET_NASIM_FILE_UPLOAD_RESUME_FIELD_NUMBER;
    }

    private void mergeResponseGetNasimFileUploadUrl(FilesOuterClass$ResponseGetNasimFileUploadUrl filesOuterClass$ResponseGetNasimFileUploadUrl) {
        filesOuterClass$ResponseGetNasimFileUploadUrl.getClass();
        if (this.traitCase_ != 157 || this.trait_ == FilesOuterClass$ResponseGetNasimFileUploadUrl.getDefaultInstance()) {
            this.trait_ = filesOuterClass$ResponseGetNasimFileUploadUrl;
        } else {
            this.trait_ = ((FilesOuterClass$ResponseGetNasimFileUploadUrl.a) FilesOuterClass$ResponseGetNasimFileUploadUrl.newBuilder((FilesOuterClass$ResponseGetNasimFileUploadUrl) this.trait_).v(filesOuterClass$ResponseGetNasimFileUploadUrl)).j();
        }
        this.traitCase_ = RESPONSE_GET_NASIM_FILE_UPLOAD_URL_FIELD_NUMBER;
    }

    private void mergeResponseGetNasimFileUrl(FilesOuterClass$ResponseGetNasimFileUrl filesOuterClass$ResponseGetNasimFileUrl) {
        filesOuterClass$ResponseGetNasimFileUrl.getClass();
        if (this.traitCase_ != 2799 || this.trait_ == FilesOuterClass$ResponseGetNasimFileUrl.getDefaultInstance()) {
            this.trait_ = filesOuterClass$ResponseGetNasimFileUrl;
        } else {
            this.trait_ = ((FilesOuterClass$ResponseGetNasimFileUrl.a) FilesOuterClass$ResponseGetNasimFileUrl.newBuilder((FilesOuterClass$ResponseGetNasimFileUrl) this.trait_).v(filesOuterClass$ResponseGetNasimFileUrl)).j();
        }
        this.traitCase_ = RESPONSE_GET_NASIM_FILE_URL_FIELD_NUMBER;
    }

    private void mergeResponseGetNasimFileUrls(FilesOuterClass$ResponseGetNasimFileUrls filesOuterClass$ResponseGetNasimFileUrls) {
        filesOuterClass$ResponseGetNasimFileUrls.getClass();
        if (this.traitCase_ != 2607 || this.trait_ == FilesOuterClass$ResponseGetNasimFileUrls.getDefaultInstance()) {
            this.trait_ = filesOuterClass$ResponseGetNasimFileUrls;
        } else {
            this.trait_ = ((FilesOuterClass$ResponseGetNasimFileUrls.a) FilesOuterClass$ResponseGetNasimFileUrls.newBuilder((FilesOuterClass$ResponseGetNasimFileUrls) this.trait_).v(filesOuterClass$ResponseGetNasimFileUrls)).j();
        }
        this.traitCase_ = RESPONSE_GET_NASIM_FILE_URLS_FIELD_NUMBER;
    }

    private void mergeResponseGetOtpTokenV2(BankOuterClass$ResponseGetOTPTokenV2 bankOuterClass$ResponseGetOTPTokenV2) {
        bankOuterClass$ResponseGetOTPTokenV2.getClass();
        if (this.traitCase_ != 63259 || this.trait_ == BankOuterClass$ResponseGetOTPTokenV2.getDefaultInstance()) {
            this.trait_ = bankOuterClass$ResponseGetOTPTokenV2;
        } else {
            this.trait_ = ((BankOuterClass$ResponseGetOTPTokenV2.a) BankOuterClass$ResponseGetOTPTokenV2.newBuilder((BankOuterClass$ResponseGetOTPTokenV2) this.trait_).v(bankOuterClass$ResponseGetOTPTokenV2)).j();
        }
        this.traitCase_ = RESPONSE_GET_OTP_TOKEN_V2_FIELD_NUMBER;
    }

    private void mergeResponseGetOtptoken(BankOuterClass$ResponseGetOTPToken bankOuterClass$ResponseGetOTPToken) {
        bankOuterClass$ResponseGetOTPToken.getClass();
        if (this.traitCase_ != 62768 || this.trait_ == BankOuterClass$ResponseGetOTPToken.getDefaultInstance()) {
            this.trait_ = bankOuterClass$ResponseGetOTPToken;
        } else {
            this.trait_ = ((BankOuterClass$ResponseGetOTPToken.a) BankOuterClass$ResponseGetOTPToken.newBuilder((BankOuterClass$ResponseGetOTPToken) this.trait_).v(bankOuterClass$ResponseGetOTPToken)).j();
        }
        this.traitCase_ = RESPONSE_GET_OTPTOKEN_FIELD_NUMBER;
    }

    private void mergeResponseGetPacketsStatus(WarriorOuterClass$ResponseGetPacketsStatus warriorOuterClass$ResponseGetPacketsStatus) {
        warriorOuterClass$ResponseGetPacketsStatus.getClass();
        if (this.traitCase_ != 63598 || this.trait_ == WarriorOuterClass$ResponseGetPacketsStatus.getDefaultInstance()) {
            this.trait_ = warriorOuterClass$ResponseGetPacketsStatus;
        } else {
            this.trait_ = ((WarriorOuterClass$ResponseGetPacketsStatus.a) WarriorOuterClass$ResponseGetPacketsStatus.newBuilder((WarriorOuterClass$ResponseGetPacketsStatus) this.trait_).v(warriorOuterClass$ResponseGetPacketsStatus)).j();
        }
        this.traitCase_ = RESPONSE_GET_PACKETS_STATUS_FIELD_NUMBER;
    }

    private void mergeResponseGetParameters(ConfigsOuterClass$ResponseGetParameters configsOuterClass$ResponseGetParameters) {
        configsOuterClass$ResponseGetParameters.getClass();
        if (this.traitCase_ != 135 || this.trait_ == ConfigsOuterClass$ResponseGetParameters.getDefaultInstance()) {
            this.trait_ = configsOuterClass$ResponseGetParameters;
        } else {
            this.trait_ = ((ConfigsOuterClass$ResponseGetParameters.a) ConfigsOuterClass$ResponseGetParameters.newBuilder((ConfigsOuterClass$ResponseGetParameters) this.trait_).v(configsOuterClass$ResponseGetParameters)).j();
        }
        this.traitCase_ = 135;
    }

    private void mergeResponseGetParticipants(Crowdfunding$ResponseGetParticipants crowdfunding$ResponseGetParticipants) {
        crowdfunding$ResponseGetParticipants.getClass();
        if (this.traitCase_ != 63513 || this.trait_ == Crowdfunding$ResponseGetParticipants.getDefaultInstance()) {
            this.trait_ = crowdfunding$ResponseGetParticipants;
        } else {
            this.trait_ = ((Crowdfunding$ResponseGetParticipants.a) Crowdfunding$ResponseGetParticipants.newBuilder((Crowdfunding$ResponseGetParticipants) this.trait_).v(crowdfunding$ResponseGetParticipants)).j();
        }
        this.traitCase_ = RESPONSE_GET_PARTICIPANTS_FIELD_NUMBER;
    }

    private void mergeResponseGetPayMoneyRequestToken(BankOuterClass$ResponseGetPayMoneyRequestToken bankOuterClass$ResponseGetPayMoneyRequestToken) {
        bankOuterClass$ResponseGetPayMoneyRequestToken.getClass();
        if (this.traitCase_ != 62128 || this.trait_ == BankOuterClass$ResponseGetPayMoneyRequestToken.getDefaultInstance()) {
            this.trait_ = bankOuterClass$ResponseGetPayMoneyRequestToken;
        } else {
            this.trait_ = ((BankOuterClass$ResponseGetPayMoneyRequestToken.a) BankOuterClass$ResponseGetPayMoneyRequestToken.newBuilder((BankOuterClass$ResponseGetPayMoneyRequestToken) this.trait_).v(bankOuterClass$ResponseGetPayMoneyRequestToken)).j();
        }
        this.traitCase_ = RESPONSE_GET_PAY_MONEY_REQUEST_TOKEN_FIELD_NUMBER;
    }

    private void mergeResponseGetPaymentToken(BankOuterClass$ResponseGetPaymentToken bankOuterClass$ResponseGetPaymentToken) {
        bankOuterClass$ResponseGetPaymentToken.getClass();
        if (this.traitCase_ != 62409 || this.trait_ == BankOuterClass$ResponseGetPaymentToken.getDefaultInstance()) {
            this.trait_ = bankOuterClass$ResponseGetPaymentToken;
        } else {
            this.trait_ = ((BankOuterClass$ResponseGetPaymentToken.a) BankOuterClass$ResponseGetPaymentToken.newBuilder((BankOuterClass$ResponseGetPaymentToken) this.trait_).v(bankOuterClass$ResponseGetPaymentToken)).j();
        }
        this.traitCase_ = RESPONSE_GET_PAYMENT_TOKEN_FIELD_NUMBER;
    }

    private void mergeResponseGetPaymentTokenByCard(WalletOuterClass$ResponseGetPaymentTokenByCard walletOuterClass$ResponseGetPaymentTokenByCard) {
        walletOuterClass$ResponseGetPaymentTokenByCard.getClass();
        if (this.traitCase_ != 62748 || this.trait_ == WalletOuterClass$ResponseGetPaymentTokenByCard.getDefaultInstance()) {
            this.trait_ = walletOuterClass$ResponseGetPaymentTokenByCard;
        } else {
            this.trait_ = ((WalletOuterClass$ResponseGetPaymentTokenByCard.a) WalletOuterClass$ResponseGetPaymentTokenByCard.newBuilder((WalletOuterClass$ResponseGetPaymentTokenByCard) this.trait_).v(walletOuterClass$ResponseGetPaymentTokenByCard)).j();
        }
        this.traitCase_ = RESPONSE_GET_PAYMENT_TOKEN_BY_CARD_FIELD_NUMBER;
    }

    private void mergeResponseGetPayvandCard(BankOuterClass$ResponseGetPayvandCard bankOuterClass$ResponseGetPayvandCard) {
        bankOuterClass$ResponseGetPayvandCard.getClass();
        if (this.traitCase_ != 62133 || this.trait_ == BankOuterClass$ResponseGetPayvandCard.getDefaultInstance()) {
            this.trait_ = bankOuterClass$ResponseGetPayvandCard;
        } else {
            this.trait_ = ((BankOuterClass$ResponseGetPayvandCard.a) BankOuterClass$ResponseGetPayvandCard.newBuilder((BankOuterClass$ResponseGetPayvandCard) this.trait_).v(bankOuterClass$ResponseGetPayvandCard)).j();
        }
        this.traitCase_ = RESPONSE_GET_PAYVAND_CARD_FIELD_NUMBER;
    }

    private void mergeResponseGetPayvandCardList(BankOuterClass$ResponseGetPayvandCardList bankOuterClass$ResponseGetPayvandCardList) {
        bankOuterClass$ResponseGetPayvandCardList.getClass();
        if (this.traitCase_ != 62131 || this.trait_ == BankOuterClass$ResponseGetPayvandCardList.getDefaultInstance()) {
            this.trait_ = bankOuterClass$ResponseGetPayvandCardList;
        } else {
            this.trait_ = ((BankOuterClass$ResponseGetPayvandCardList.a) BankOuterClass$ResponseGetPayvandCardList.newBuilder((BankOuterClass$ResponseGetPayvandCardList) this.trait_).v(bankOuterClass$ResponseGetPayvandCardList)).j();
        }
        this.traitCase_ = RESPONSE_GET_PAYVAND_CARD_LIST_FIELD_NUMBER;
    }

    private void mergeResponseGetPointBalance(KifpoolOuterClass$ResponseGetPointBalance kifpoolOuterClass$ResponseGetPointBalance) {
        kifpoolOuterClass$ResponseGetPointBalance.getClass();
        if (this.traitCase_ != 63435 || this.trait_ == KifpoolOuterClass$ResponseGetPointBalance.getDefaultInstance()) {
            this.trait_ = kifpoolOuterClass$ResponseGetPointBalance;
        } else {
            this.trait_ = ((KifpoolOuterClass$ResponseGetPointBalance.a) KifpoolOuterClass$ResponseGetPointBalance.newBuilder((KifpoolOuterClass$ResponseGetPointBalance) this.trait_).v(kifpoolOuterClass$ResponseGetPointBalance)).j();
        }
        this.traitCase_ = RESPONSE_GET_POINT_BALANCE_FIELD_NUMBER;
    }

    private void mergeResponseGetPointDetails(KifpoolOuterClass$ResponseGetPointDetails kifpoolOuterClass$ResponseGetPointDetails) {
        kifpoolOuterClass$ResponseGetPointDetails.getClass();
        if (this.traitCase_ != 63459 || this.trait_ == KifpoolOuterClass$ResponseGetPointDetails.getDefaultInstance()) {
            this.trait_ = kifpoolOuterClass$ResponseGetPointDetails;
        } else {
            this.trait_ = ((KifpoolOuterClass$ResponseGetPointDetails.a) KifpoolOuterClass$ResponseGetPointDetails.newBuilder((KifpoolOuterClass$ResponseGetPointDetails) this.trait_).v(kifpoolOuterClass$ResponseGetPointDetails)).j();
        }
        this.traitCase_ = RESPONSE_GET_POINT_DETAILS_FIELD_NUMBER;
    }

    private void mergeResponseGetPointSummery(KifpoolOuterClass$ResponseGetPointSummery kifpoolOuterClass$ResponseGetPointSummery) {
        kifpoolOuterClass$ResponseGetPointSummery.getClass();
        if (this.traitCase_ != 63452 || this.trait_ == KifpoolOuterClass$ResponseGetPointSummery.getDefaultInstance()) {
            this.trait_ = kifpoolOuterClass$ResponseGetPointSummery;
        } else {
            this.trait_ = ((KifpoolOuterClass$ResponseGetPointSummery.a) KifpoolOuterClass$ResponseGetPointSummery.newBuilder((KifpoolOuterClass$ResponseGetPointSummery) this.trait_).v(kifpoolOuterClass$ResponseGetPointSummery)).j();
        }
        this.traitCase_ = RESPONSE_GET_POINT_SUMMERY_FIELD_NUMBER;
    }

    private void mergeResponseGetPspPaymentToken(Saba$ResponseGetPspPaymentToken saba$ResponseGetPspPaymentToken) {
        saba$ResponseGetPspPaymentToken.getClass();
        if (this.traitCase_ != 63486 || this.trait_ == Saba$ResponseGetPspPaymentToken.getDefaultInstance()) {
            this.trait_ = saba$ResponseGetPspPaymentToken;
        } else {
            this.trait_ = ((Saba$ResponseGetPspPaymentToken.a) Saba$ResponseGetPspPaymentToken.newBuilder((Saba$ResponseGetPspPaymentToken) this.trait_).v(saba$ResponseGetPspPaymentToken)).j();
        }
        this.traitCase_ = RESPONSE_GET_PSP_PAYMENTTOKEN_FIELD_NUMBER;
    }

    private void mergeResponseGetPsproxyPaymentToken(BankOuterClass$ResponseGetPSProxyPaymentToken bankOuterClass$ResponseGetPSProxyPaymentToken) {
        bankOuterClass$ResponseGetPSProxyPaymentToken.getClass();
        if (this.traitCase_ != 53259 || this.trait_ == BankOuterClass$ResponseGetPSProxyPaymentToken.getDefaultInstance()) {
            this.trait_ = bankOuterClass$ResponseGetPSProxyPaymentToken;
        } else {
            this.trait_ = ((BankOuterClass$ResponseGetPSProxyPaymentToken.a) BankOuterClass$ResponseGetPSProxyPaymentToken.newBuilder((BankOuterClass$ResponseGetPSProxyPaymentToken) this.trait_).v(bankOuterClass$ResponseGetPSProxyPaymentToken)).j();
        }
        this.traitCase_ = RESPONSE_GET_PSPROXY_PAYMENT_TOKEN_FIELD_NUMBER;
    }

    private void mergeResponseGetPsproxyToken(BankOuterClass$ResponseGetPSProxyToken bankOuterClass$ResponseGetPSProxyToken) {
        bankOuterClass$ResponseGetPSProxyToken.getClass();
        if (this.traitCase_ != 53257 || this.trait_ == BankOuterClass$ResponseGetPSProxyToken.getDefaultInstance()) {
            this.trait_ = bankOuterClass$ResponseGetPSProxyToken;
        } else {
            this.trait_ = ((BankOuterClass$ResponseGetPSProxyToken.a) BankOuterClass$ResponseGetPSProxyToken.newBuilder((BankOuterClass$ResponseGetPSProxyToken) this.trait_).v(bankOuterClass$ResponseGetPSProxyToken)).j();
        }
        this.traitCase_ = RESPONSE_GET_PSPROXY_TOKEN_FIELD_NUMBER;
    }

    private void mergeResponseGetReactions(ReactionsOuterClass$ResponseGetReactions reactionsOuterClass$ResponseGetReactions) {
        reactionsOuterClass$ResponseGetReactions.getClass();
        if (this.traitCase_ != 63255 || this.trait_ == ReactionsOuterClass$ResponseGetReactions.getDefaultInstance()) {
            this.trait_ = reactionsOuterClass$ResponseGetReactions;
        } else {
            this.trait_ = ((ReactionsOuterClass$ResponseGetReactions.a) ReactionsOuterClass$ResponseGetReactions.newBuilder((ReactionsOuterClass$ResponseGetReactions) this.trait_).v(reactionsOuterClass$ResponseGetReactions)).j();
        }
        this.traitCase_ = RESPONSE_GET_REACTIONS_FIELD_NUMBER;
    }

    private void mergeResponseGetRecentCharges(BankOuterClass$ResponseGetRecentCharges bankOuterClass$ResponseGetRecentCharges) {
        bankOuterClass$ResponseGetRecentCharges.getClass();
        if (this.traitCase_ != 62414 || this.trait_ == BankOuterClass$ResponseGetRecentCharges.getDefaultInstance()) {
            this.trait_ = bankOuterClass$ResponseGetRecentCharges;
        } else {
            this.trait_ = ((BankOuterClass$ResponseGetRecentCharges.a) BankOuterClass$ResponseGetRecentCharges.newBuilder((BankOuterClass$ResponseGetRecentCharges) this.trait_).v(bankOuterClass$ResponseGetRecentCharges)).j();
        }
        this.traitCase_ = RESPONSE_GET_RECENT_CHARGES_FIELD_NUMBER;
    }

    private void mergeResponseGetRecentInternetBundleOrders(Charnet$ResponseGetRecentInternetBundleOrders charnet$ResponseGetRecentInternetBundleOrders) {
        charnet$ResponseGetRecentInternetBundleOrders.getClass();
        if (this.traitCase_ != 63535 || this.trait_ == Charnet$ResponseGetRecentInternetBundleOrders.getDefaultInstance()) {
            this.trait_ = charnet$ResponseGetRecentInternetBundleOrders;
        } else {
            this.trait_ = ((Charnet$ResponseGetRecentInternetBundleOrders.a) Charnet$ResponseGetRecentInternetBundleOrders.newBuilder((Charnet$ResponseGetRecentInternetBundleOrders) this.trait_).v(charnet$ResponseGetRecentInternetBundleOrders)).j();
        }
        this.traitCase_ = RESPONSE_GET_RECENT_INTERNET_BUNDLE_ORDERS_FIELD_NUMBER;
    }

    private void mergeResponseGetRecentOrders(Saba$ResponseGetRecentOrders saba$ResponseGetRecentOrders) {
        saba$ResponseGetRecentOrders.getClass();
        if (this.traitCase_ != 63508 || this.trait_ == Saba$ResponseGetRecentOrders.getDefaultInstance()) {
            this.trait_ = saba$ResponseGetRecentOrders;
        } else {
            this.trait_ = ((Saba$ResponseGetRecentOrders.a) Saba$ResponseGetRecentOrders.newBuilder((Saba$ResponseGetRecentOrders) this.trait_).v(saba$ResponseGetRecentOrders)).j();
        }
        this.traitCase_ = RESPONSE_GET_RECENT_ORDERS_FIELD_NUMBER;
    }

    private void mergeResponseGetRecipients(SefteOuterClass$ResponseGetRecipients sefteOuterClass$ResponseGetRecipients) {
        sefteOuterClass$ResponseGetRecipients.getClass();
        if (this.traitCase_ != 63627 || this.trait_ == SefteOuterClass$ResponseGetRecipients.getDefaultInstance()) {
            this.trait_ = sefteOuterClass$ResponseGetRecipients;
        } else {
            this.trait_ = ((SefteOuterClass$ResponseGetRecipients.a) SefteOuterClass$ResponseGetRecipients.newBuilder((SefteOuterClass$ResponseGetRecipients) this.trait_).v(sefteOuterClass$ResponseGetRecipients)).j();
        }
        this.traitCase_ = RESPONSE_GET_RECIPIENTS_FIELD_NUMBER;
    }

    private void mergeResponseGetReferencedEntitites(Sequence$ResponseGetReferencedEntitites sequence$ResponseGetReferencedEntitites) {
        sequence$ResponseGetReferencedEntitites.getClass();
        if (this.traitCase_ != 2629 || this.trait_ == Sequence$ResponseGetReferencedEntitites.getDefaultInstance()) {
            this.trait_ = sequence$ResponseGetReferencedEntitites;
        } else {
            this.trait_ = ((Sequence$ResponseGetReferencedEntitites.a) Sequence$ResponseGetReferencedEntitites.newBuilder((Sequence$ResponseGetReferencedEntitites) this.trait_).v(sequence$ResponseGetReferencedEntitites)).j();
        }
        this.traitCase_ = 2629;
    }

    private void mergeResponseGetReferralCode(ReferralOuterClass$ResponseGetReferralCode referralOuterClass$ResponseGetReferralCode) {
        referralOuterClass$ResponseGetReferralCode.getClass();
        if (this.traitCase_ != 63501 || this.trait_ == ReferralOuterClass$ResponseGetReferralCode.getDefaultInstance()) {
            this.trait_ = referralOuterClass$ResponseGetReferralCode;
        } else {
            this.trait_ = ((ReferralOuterClass$ResponseGetReferralCode.a) ReferralOuterClass$ResponseGetReferralCode.newBuilder((ReferralOuterClass$ResponseGetReferralCode) this.trait_).v(referralOuterClass$ResponseGetReferralCode)).j();
        }
        this.traitCase_ = RESPONSE_GET_REFERRAL_CODE_FIELD_NUMBER;
    }

    private void mergeResponseGetReferralContacts(WarriorOuterClass$ResponseGetReferralContacts warriorOuterClass$ResponseGetReferralContacts) {
        warriorOuterClass$ResponseGetReferralContacts.getClass();
        if (this.traitCase_ != 63602 || this.trait_ == WarriorOuterClass$ResponseGetReferralContacts.getDefaultInstance()) {
            this.trait_ = warriorOuterClass$ResponseGetReferralContacts;
        } else {
            this.trait_ = ((WarriorOuterClass$ResponseGetReferralContacts.a) WarriorOuterClass$ResponseGetReferralContacts.newBuilder((WarriorOuterClass$ResponseGetReferralContacts) this.trait_).v(warriorOuterClass$ResponseGetReferralContacts)).j();
        }
        this.traitCase_ = RESPONSE_GET_REFERRAL_CONTACTS_FIELD_NUMBER;
    }

    private void mergeResponseGetReferredCount(ReferralOuterClass$ResponseGetReferredCount referralOuterClass$ResponseGetReferredCount) {
        referralOuterClass$ResponseGetReferredCount.getClass();
        if (this.traitCase_ != 63478 || this.trait_ == ReferralOuterClass$ResponseGetReferredCount.getDefaultInstance()) {
            this.trait_ = referralOuterClass$ResponseGetReferredCount;
        } else {
            this.trait_ = ((ReferralOuterClass$ResponseGetReferredCount.a) ReferralOuterClass$ResponseGetReferredCount.newBuilder((ReferralOuterClass$ResponseGetReferredCount) this.trait_).v(referralOuterClass$ResponseGetReferredCount)).j();
        }
        this.traitCase_ = RESPONSE_GET_REFERRED_COUNT_FIELD_NUMBER;
    }

    private void mergeResponseGetReferringUser(ReferralOuterClass$ResponseGetReferringUser referralOuterClass$ResponseGetReferringUser) {
        referralOuterClass$ResponseGetReferringUser.getClass();
        if (this.traitCase_ != 63461 || this.trait_ == ReferralOuterClass$ResponseGetReferringUser.getDefaultInstance()) {
            this.trait_ = referralOuterClass$ResponseGetReferringUser;
        } else {
            this.trait_ = ((ReferralOuterClass$ResponseGetReferringUser.a) ReferralOuterClass$ResponseGetReferringUser.newBuilder((ReferralOuterClass$ResponseGetReferringUser) this.trait_).v(referralOuterClass$ResponseGetReferringUser)).j();
        }
        this.traitCase_ = RESPONSE_GET_REFERRING_USER_FIELD_NUMBER;
    }

    private void mergeResponseGetRemainToken(BankOuterClass$ResponseGetRemainToken bankOuterClass$ResponseGetRemainToken) {
        bankOuterClass$ResponseGetRemainToken.getClass();
        if (this.traitCase_ != 62138 || this.trait_ == BankOuterClass$ResponseGetRemainToken.getDefaultInstance()) {
            this.trait_ = bankOuterClass$ResponseGetRemainToken;
        } else {
            this.trait_ = ((BankOuterClass$ResponseGetRemainToken.a) BankOuterClass$ResponseGetRemainToken.newBuilder((BankOuterClass$ResponseGetRemainToken) this.trait_).v(bankOuterClass$ResponseGetRemainToken)).j();
        }
        this.traitCase_ = RESPONSE_GET_REMAIN_TOKEN_FIELD_NUMBER;
    }

    private void mergeResponseGetSadadPsppaymentToken(BankOuterClass$ResponseGetSadadPSPPaymentToken bankOuterClass$ResponseGetSadadPSPPaymentToken) {
        bankOuterClass$ResponseGetSadadPSPPaymentToken.getClass();
        if (this.traitCase_ != 62181 || this.trait_ == BankOuterClass$ResponseGetSadadPSPPaymentToken.getDefaultInstance()) {
            this.trait_ = bankOuterClass$ResponseGetSadadPSPPaymentToken;
        } else {
            this.trait_ = ((BankOuterClass$ResponseGetSadadPSPPaymentToken.a) BankOuterClass$ResponseGetSadadPSPPaymentToken.newBuilder((BankOuterClass$ResponseGetSadadPSPPaymentToken) this.trait_).v(bankOuterClass$ResponseGetSadadPSPPaymentToken)).j();
        }
        this.traitCase_ = RESPONSE_GET_SADAD_PSPPAYMENT_TOKEN_FIELD_NUMBER;
    }

    private void mergeResponseGetSavedBills(BillOuterClass$ResponseGetSavedBills billOuterClass$ResponseGetSavedBills) {
        billOuterClass$ResponseGetSavedBills.getClass();
        if (this.traitCase_ != 63552 || this.trait_ == BillOuterClass$ResponseGetSavedBills.getDefaultInstance()) {
            this.trait_ = billOuterClass$ResponseGetSavedBills;
        } else {
            this.trait_ = ((BillOuterClass$ResponseGetSavedBills.a) BillOuterClass$ResponseGetSavedBills.newBuilder((BillOuterClass$ResponseGetSavedBills) this.trait_).v(billOuterClass$ResponseGetSavedBills)).j();
        }
        this.traitCase_ = RESPONSE_GET_SAVED_BILLS_FIELD_NUMBER;
    }

    private void mergeResponseGetScoreBoard(WarriorOuterClass$ResponseGetScoreBoard warriorOuterClass$ResponseGetScoreBoard) {
        warriorOuterClass$ResponseGetScoreBoard.getClass();
        if (this.traitCase_ != 63594 || this.trait_ == WarriorOuterClass$ResponseGetScoreBoard.getDefaultInstance()) {
            this.trait_ = warriorOuterClass$ResponseGetScoreBoard;
        } else {
            this.trait_ = ((WarriorOuterClass$ResponseGetScoreBoard.a) WarriorOuterClass$ResponseGetScoreBoard.newBuilder((WarriorOuterClass$ResponseGetScoreBoard) this.trait_).v(warriorOuterClass$ResponseGetScoreBoard)).j();
        }
        this.traitCase_ = RESPONSE_GET_SCORE_BOARD_FIELD_NUMBER;
    }

    private void mergeResponseGetStates(SefteOuterClass$ResponseGetStates sefteOuterClass$ResponseGetStates) {
        sefteOuterClass$ResponseGetStates.getClass();
        if (this.traitCase_ != 63616 || this.trait_ == SefteOuterClass$ResponseGetStates.getDefaultInstance()) {
            this.trait_ = sefteOuterClass$ResponseGetStates;
        } else {
            this.trait_ = ((SefteOuterClass$ResponseGetStates.a) SefteOuterClass$ResponseGetStates.newBuilder((SefteOuterClass$ResponseGetStates) this.trait_).v(sefteOuterClass$ResponseGetStates)).j();
        }
        this.traitCase_ = RESPONSE_GET_STATES_FIELD_NUMBER;
    }

    private void mergeResponseGetSubTransactions(PfmOuterClass$ResponseGetSubTransactions pfmOuterClass$ResponseGetSubTransactions) {
        pfmOuterClass$ResponseGetSubTransactions.getClass();
        if (this.traitCase_ != 63654 || this.trait_ == PfmOuterClass$ResponseGetSubTransactions.getDefaultInstance()) {
            this.trait_ = pfmOuterClass$ResponseGetSubTransactions;
        } else {
            this.trait_ = ((PfmOuterClass$ResponseGetSubTransactions.a) PfmOuterClass$ResponseGetSubTransactions.newBuilder((PfmOuterClass$ResponseGetSubTransactions) this.trait_).v(pfmOuterClass$ResponseGetSubTransactions)).j();
        }
        this.traitCase_ = RESPONSE_GET_SUB_TRANSACTIONS_FIELD_NUMBER;
    }

    private void mergeResponseGetTicket(AuthOuterClass$ResponseGetTicket authOuterClass$ResponseGetTicket) {
        authOuterClass$ResponseGetTicket.getClass();
        if (this.traitCase_ != 63261 || this.trait_ == AuthOuterClass$ResponseGetTicket.getDefaultInstance()) {
            this.trait_ = authOuterClass$ResponseGetTicket;
        } else {
            this.trait_ = ((AuthOuterClass$ResponseGetTicket.a) AuthOuterClass$ResponseGetTicket.newBuilder((AuthOuterClass$ResponseGetTicket) this.trait_).v(authOuterClass$ResponseGetTicket)).j();
        }
        this.traitCase_ = RESPONSE_GET_TICKET_FIELD_NUMBER;
    }

    private void mergeResponseGetTotalPaidAmount(Crowdfunding$ResponseGetTotalPaidAmount crowdfunding$ResponseGetTotalPaidAmount) {
        crowdfunding$ResponseGetTotalPaidAmount.getClass();
        if (this.traitCase_ != 63528 || this.trait_ == Crowdfunding$ResponseGetTotalPaidAmount.getDefaultInstance()) {
            this.trait_ = crowdfunding$ResponseGetTotalPaidAmount;
        } else {
            this.trait_ = ((Crowdfunding$ResponseGetTotalPaidAmount.a) Crowdfunding$ResponseGetTotalPaidAmount.newBuilder((Crowdfunding$ResponseGetTotalPaidAmount) this.trait_).v(crowdfunding$ResponseGetTotalPaidAmount)).j();
        }
        this.traitCase_ = RESPONSE_GET_TOTAL_PAID_AMOUNT_FIELD_NUMBER;
    }

    private void mergeResponseGetTransactionTags(PfmOuterClass$ResponseGetTransactionTags pfmOuterClass$ResponseGetTransactionTags) {
        pfmOuterClass$ResponseGetTransactionTags.getClass();
        if (this.traitCase_ != 63517 || this.trait_ == PfmOuterClass$ResponseGetTransactionTags.getDefaultInstance()) {
            this.trait_ = pfmOuterClass$ResponseGetTransactionTags;
        } else {
            this.trait_ = ((PfmOuterClass$ResponseGetTransactionTags.a) PfmOuterClass$ResponseGetTransactionTags.newBuilder((PfmOuterClass$ResponseGetTransactionTags) this.trait_).v(pfmOuterClass$ResponseGetTransactionTags)).j();
        }
        this.traitCase_ = RESPONSE_GET_TRANSACTION_TAGS_FIELD_NUMBER;
    }

    private void mergeResponseGetUserAccounts(PfmOuterClass$ResponseGetUserAccounts pfmOuterClass$ResponseGetUserAccounts) {
        pfmOuterClass$ResponseGetUserAccounts.getClass();
        if (this.traitCase_ != 63444 || this.trait_ == PfmOuterClass$ResponseGetUserAccounts.getDefaultInstance()) {
            this.trait_ = pfmOuterClass$ResponseGetUserAccounts;
        } else {
            this.trait_ = ((PfmOuterClass$ResponseGetUserAccounts.a) PfmOuterClass$ResponseGetUserAccounts.newBuilder((PfmOuterClass$ResponseGetUserAccounts) this.trait_).v(pfmOuterClass$ResponseGetUserAccounts)).j();
        }
        this.traitCase_ = RESPONSE_GET_USER_ACCOUNTS_FIELD_NUMBER;
    }

    private void mergeResponseGetUserBank(VitrineOuterClass$ResponseGetUserBank vitrineOuterClass$ResponseGetUserBank) {
        vitrineOuterClass$ResponseGetUserBank.getClass();
        if (this.traitCase_ != 63524 || this.trait_ == VitrineOuterClass$ResponseGetUserBank.getDefaultInstance()) {
            this.trait_ = vitrineOuterClass$ResponseGetUserBank;
        } else {
            this.trait_ = ((VitrineOuterClass$ResponseGetUserBank.a) VitrineOuterClass$ResponseGetUserBank.newBuilder((VitrineOuterClass$ResponseGetUserBank) this.trait_).v(vitrineOuterClass$ResponseGetUserBank)).j();
        }
        this.traitCase_ = RESPONSE_GET_USER_BANK_FIELD_NUMBER;
    }

    private void mergeResponseGetUserContext(KetfOuterClass$ResponseGetUserContext ketfOuterClass$ResponseGetUserContext) {
        ketfOuterClass$ResponseGetUserContext.getClass();
        if (this.traitCase_ != 146 || this.trait_ == KetfOuterClass$ResponseGetUserContext.getDefaultInstance()) {
            this.trait_ = ketfOuterClass$ResponseGetUserContext;
        } else {
            this.trait_ = ((KetfOuterClass$ResponseGetUserContext.a) KetfOuterClass$ResponseGetUserContext.newBuilder((KetfOuterClass$ResponseGetUserContext) this.trait_).v(ketfOuterClass$ResponseGetUserContext)).j();
        }
        this.traitCase_ = RESPONSE_GET_USER_CONTEXT_FIELD_NUMBER;
    }

    private void mergeResponseGetUserRefers(WarriorOuterClass$ResponseGetUserRefers warriorOuterClass$ResponseGetUserRefers) {
        warriorOuterClass$ResponseGetUserRefers.getClass();
        if (this.traitCase_ != 63600 || this.trait_ == WarriorOuterClass$ResponseGetUserRefers.getDefaultInstance()) {
            this.trait_ = warriorOuterClass$ResponseGetUserRefers;
        } else {
            this.trait_ = ((WarriorOuterClass$ResponseGetUserRefers.a) WarriorOuterClass$ResponseGetUserRefers.newBuilder((WarriorOuterClass$ResponseGetUserRefers) this.trait_).v(warriorOuterClass$ResponseGetUserRefers)).j();
        }
        this.traitCase_ = RESPONSE_GET_USER_REFERS_FIELD_NUMBER;
    }

    private void mergeResponseGetUserScore(WarriorOuterClass$ResponseGetUserScore warriorOuterClass$ResponseGetUserScore) {
        warriorOuterClass$ResponseGetUserScore.getClass();
        if (this.traitCase_ != 63596 || this.trait_ == WarriorOuterClass$ResponseGetUserScore.getDefaultInstance()) {
            this.trait_ = warriorOuterClass$ResponseGetUserScore;
        } else {
            this.trait_ = ((WarriorOuterClass$ResponseGetUserScore.a) WarriorOuterClass$ResponseGetUserScore.newBuilder((WarriorOuterClass$ResponseGetUserScore) this.trait_).v(warriorOuterClass$ResponseGetUserScore)).j();
        }
        this.traitCase_ = RESPONSE_GET_USER_SCORE_FIELD_NUMBER;
    }

    private void mergeResponseGetUserSeftes(SefteOuterClass$ResponseGetUserSeftes sefteOuterClass$ResponseGetUserSeftes) {
        sefteOuterClass$ResponseGetUserSeftes.getClass();
        if (this.traitCase_ != 63621 || this.trait_ == SefteOuterClass$ResponseGetUserSeftes.getDefaultInstance()) {
            this.trait_ = sefteOuterClass$ResponseGetUserSeftes;
        } else {
            this.trait_ = ((SefteOuterClass$ResponseGetUserSeftes.a) SefteOuterClass$ResponseGetUserSeftes.newBuilder((SefteOuterClass$ResponseGetUserSeftes) this.trait_).v(sefteOuterClass$ResponseGetUserSeftes)).j();
        }
        this.traitCase_ = RESPONSE_GET_USER_SEFTES_FIELD_NUMBER;
    }

    private void mergeResponseGetUserStatus(AdvertisementOuterClass$ResponseGetUserStatus advertisementOuterClass$ResponseGetUserStatus) {
        advertisementOuterClass$ResponseGetUserStatus.getClass();
        if (this.traitCase_ != 63442 || this.trait_ == AdvertisementOuterClass$ResponseGetUserStatus.getDefaultInstance()) {
            this.trait_ = advertisementOuterClass$ResponseGetUserStatus;
        } else {
            this.trait_ = ((AdvertisementOuterClass$ResponseGetUserStatus.a) AdvertisementOuterClass$ResponseGetUserStatus.newBuilder((AdvertisementOuterClass$ResponseGetUserStatus) this.trait_).v(advertisementOuterClass$ResponseGetUserStatus)).j();
        }
        this.traitCase_ = RESPONSE_GET_USER_STATUS_FIELD_NUMBER;
    }

    private void mergeResponseGetUserTags(PfmOuterClass$ResponseGetUserTags pfmOuterClass$ResponseGetUserTags) {
        pfmOuterClass$ResponseGetUserTags.getClass();
        if (this.traitCase_ != 63521 || this.trait_ == PfmOuterClass$ResponseGetUserTags.getDefaultInstance()) {
            this.trait_ = pfmOuterClass$ResponseGetUserTags;
        } else {
            this.trait_ = ((PfmOuterClass$ResponseGetUserTags.a) PfmOuterClass$ResponseGetUserTags.newBuilder((PfmOuterClass$ResponseGetUserTags) this.trait_).v(pfmOuterClass$ResponseGetUserTags)).j();
        }
        this.traitCase_ = RESPONSE_GET_USER_TAGS_FIELD_NUMBER;
    }

    private void mergeResponseGetUserVitrine(VitrineOuterClass$ResponseGetUserVitrine vitrineOuterClass$ResponseGetUserVitrine) {
        vitrineOuterClass$ResponseGetUserVitrine.getClass();
        if (this.traitCase_ != 63257 || this.trait_ == VitrineOuterClass$ResponseGetUserVitrine.getDefaultInstance()) {
            this.trait_ = vitrineOuterClass$ResponseGetUserVitrine;
        } else {
            this.trait_ = ((VitrineOuterClass$ResponseGetUserVitrine.a) VitrineOuterClass$ResponseGetUserVitrine.newBuilder((VitrineOuterClass$ResponseGetUserVitrine) this.trait_).v(vitrineOuterClass$ResponseGetUserVitrine)).j();
        }
        this.traitCase_ = RESPONSE_GET_USER_VITRINE_FIELD_NUMBER;
    }

    private void mergeResponseGetUsersDefaultCardNumber(UsersOuterClass$ResponseGetUsersDefaultCardNumber usersOuterClass$ResponseGetUsersDefaultCardNumber) {
        usersOuterClass$ResponseGetUsersDefaultCardNumber.getClass();
        if (this.traitCase_ != 63542 || this.trait_ == UsersOuterClass$ResponseGetUsersDefaultCardNumber.getDefaultInstance()) {
            this.trait_ = usersOuterClass$ResponseGetUsersDefaultCardNumber;
        } else {
            this.trait_ = ((UsersOuterClass$ResponseGetUsersDefaultCardNumber.a) UsersOuterClass$ResponseGetUsersDefaultCardNumber.newBuilder((UsersOuterClass$ResponseGetUsersDefaultCardNumber) this.trait_).v(usersOuterClass$ResponseGetUsersDefaultCardNumber)).j();
        }
        this.traitCase_ = RESPONSE_GET_USERS_DEFAULT_CARD_NUMBER_FIELD_NUMBER;
    }

    private void mergeResponseGetUsersPresence(PresenceOuterClass$ResponseGetUsersPresence presenceOuterClass$ResponseGetUsersPresence) {
        presenceOuterClass$ResponseGetUsersPresence.getClass();
        if (this.traitCase_ != 63645 || this.trait_ == PresenceOuterClass$ResponseGetUsersPresence.getDefaultInstance()) {
            this.trait_ = presenceOuterClass$ResponseGetUsersPresence;
        } else {
            this.trait_ = ((PresenceOuterClass$ResponseGetUsersPresence.a) PresenceOuterClass$ResponseGetUsersPresence.newBuilder((PresenceOuterClass$ResponseGetUsersPresence) this.trait_).v(presenceOuterClass$ResponseGetUsersPresence)).j();
        }
        this.traitCase_ = RESPONSE_GET_USERS_PRESENCE_FIELD_NUMBER;
    }

    private void mergeResponseGetVouchers(ClubOuterClass$ResponseGetVouchers clubOuterClass$ResponseGetVouchers) {
        clubOuterClass$ResponseGetVouchers.getClass();
        if (this.traitCase_ != 63473 || this.trait_ == ClubOuterClass$ResponseGetVouchers.getDefaultInstance()) {
            this.trait_ = clubOuterClass$ResponseGetVouchers;
        } else {
            this.trait_ = ((ClubOuterClass$ResponseGetVouchers.a) ClubOuterClass$ResponseGetVouchers.newBuilder((ClubOuterClass$ResponseGetVouchers) this.trait_).v(clubOuterClass$ResponseGetVouchers)).j();
        }
        this.traitCase_ = RESPONSE_GET_VOUCHERS_FIELD_NUMBER;
    }

    private void mergeResponseGetWalletChargeToken(WalletOuterClass$ResponseGetWalletChargeToken walletOuterClass$ResponseGetWalletChargeToken) {
        walletOuterClass$ResponseGetWalletChargeToken.getClass();
        if (this.traitCase_ != 62734 || this.trait_ == WalletOuterClass$ResponseGetWalletChargeToken.getDefaultInstance()) {
            this.trait_ = walletOuterClass$ResponseGetWalletChargeToken;
        } else {
            this.trait_ = ((WalletOuterClass$ResponseGetWalletChargeToken.a) WalletOuterClass$ResponseGetWalletChargeToken.newBuilder((WalletOuterClass$ResponseGetWalletChargeToken) this.trait_).v(walletOuterClass$ResponseGetWalletChargeToken)).j();
        }
        this.traitCase_ = RESPONSE_GET_WALLET_CHARGE_TOKEN_FIELD_NUMBER;
    }

    private void mergeResponseGetWalletContracts(WalletOuterClass$ResponseGetWalletContracts walletOuterClass$ResponseGetWalletContracts) {
        walletOuterClass$ResponseGetWalletContracts.getClass();
        if (this.traitCase_ != 62759 || this.trait_ == WalletOuterClass$ResponseGetWalletContracts.getDefaultInstance()) {
            this.trait_ = walletOuterClass$ResponseGetWalletContracts;
        } else {
            this.trait_ = ((WalletOuterClass$ResponseGetWalletContracts.a) WalletOuterClass$ResponseGetWalletContracts.newBuilder((WalletOuterClass$ResponseGetWalletContracts) this.trait_).v(walletOuterClass$ResponseGetWalletContracts)).j();
        }
        this.traitCase_ = RESPONSE_GET_WALLET_CONTRACTS_FIELD_NUMBER;
    }

    private void mergeResponseGetWalletInvoice(WalletOuterClass$ResponseGetWalletInvoice walletOuterClass$ResponseGetWalletInvoice) {
        walletOuterClass$ResponseGetWalletInvoice.getClass();
        if (this.traitCase_ != 62729 || this.trait_ == WalletOuterClass$ResponseGetWalletInvoice.getDefaultInstance()) {
            this.trait_ = walletOuterClass$ResponseGetWalletInvoice;
        } else {
            this.trait_ = ((WalletOuterClass$ResponseGetWalletInvoice.a) WalletOuterClass$ResponseGetWalletInvoice.newBuilder((WalletOuterClass$ResponseGetWalletInvoice) this.trait_).v(walletOuterClass$ResponseGetWalletInvoice)).j();
        }
        this.traitCase_ = RESPONSE_GET_WALLET_INVOICE_FIELD_NUMBER;
    }

    private void mergeResponseGetWebviewTrackingNumber(Saba$ResponseGetWebViewTrackingNumber saba$ResponseGetWebViewTrackingNumber) {
        saba$ResponseGetWebViewTrackingNumber.getClass();
        if (this.traitCase_ != 63482 || this.trait_ == Saba$ResponseGetWebViewTrackingNumber.getDefaultInstance()) {
            this.trait_ = saba$ResponseGetWebViewTrackingNumber;
        } else {
            this.trait_ = ((Saba$ResponseGetWebViewTrackingNumber.a) Saba$ResponseGetWebViewTrackingNumber.newBuilder((Saba$ResponseGetWebViewTrackingNumber) this.trait_).v(saba$ResponseGetWebViewTrackingNumber)).j();
        }
        this.traitCase_ = RESPONSE_GET_WEBVIEW_TRACKING_NUMBER_FIELD_NUMBER;
    }

    private void mergeResponseGetWheel(ClubOuterClass$ResponseGetWheel clubOuterClass$ResponseGetWheel) {
        clubOuterClass$ResponseGetWheel.getClass();
        if (this.traitCase_ != 63469 || this.trait_ == ClubOuterClass$ResponseGetWheel.getDefaultInstance()) {
            this.trait_ = clubOuterClass$ResponseGetWheel;
        } else {
            this.trait_ = ((ClubOuterClass$ResponseGetWheel.a) ClubOuterClass$ResponseGetWheel.newBuilder((ClubOuterClass$ResponseGetWheel) this.trait_).v(clubOuterClass$ResponseGetWheel)).j();
        }
        this.traitCase_ = RESPONSE_GET_WHEEL_FIELD_NUMBER;
    }

    private void mergeResponseImportContacts(UsersOuterClass$ResponseImportContacts usersOuterClass$ResponseImportContacts) {
        usersOuterClass$ResponseImportContacts.getClass();
        if (this.traitCase_ != 8 || this.trait_ == UsersOuterClass$ResponseImportContacts.getDefaultInstance()) {
            this.trait_ = usersOuterClass$ResponseImportContacts;
        } else {
            this.trait_ = ((UsersOuterClass$ResponseImportContacts.a) UsersOuterClass$ResponseImportContacts.newBuilder((UsersOuterClass$ResponseImportContacts) this.trait_).v(usersOuterClass$ResponseImportContacts)).j();
        }
        this.traitCase_ = 8;
    }

    private void mergeResponseInitP12(SefteOuterClass$ResponseInitP12 sefteOuterClass$ResponseInitP12) {
        sefteOuterClass$ResponseInitP12.getClass();
        if (this.traitCase_ != 63609 || this.trait_ == SefteOuterClass$ResponseInitP12.getDefaultInstance()) {
            this.trait_ = sefteOuterClass$ResponseInitP12;
        } else {
            this.trait_ = ((SefteOuterClass$ResponseInitP12.a) SefteOuterClass$ResponseInitP12.newBuilder((SefteOuterClass$ResponseInitP12) this.trait_).v(sefteOuterClass$ResponseInitP12)).j();
        }
        this.traitCase_ = RESPONSE_INIT_P12_FIELD_NUMBER;
    }

    private void mergeResponseInitSefte(SefteOuterClass$ResponseInitSefte sefteOuterClass$ResponseInitSefte) {
        sefteOuterClass$ResponseInitSefte.getClass();
        if (this.traitCase_ != 63611 || this.trait_ == SefteOuterClass$ResponseInitSefte.getDefaultInstance()) {
            this.trait_ = sefteOuterClass$ResponseInitSefte;
        } else {
            this.trait_ = ((SefteOuterClass$ResponseInitSefte.a) SefteOuterClass$ResponseInitSefte.newBuilder((SefteOuterClass$ResponseInitSefte) this.trait_).v(sefteOuterClass$ResponseInitSefte)).j();
        }
        this.traitCase_ = RESPONSE_INIT_SEFTE_FIELD_NUMBER;
    }

    private void mergeResponseInquiryBill(BillOuterClass$ResponseInquiryBill billOuterClass$ResponseInquiryBill) {
        billOuterClass$ResponseInquiryBill.getClass();
        if (this.traitCase_ != 63544 || this.trait_ == BillOuterClass$ResponseInquiryBill.getDefaultInstance()) {
            this.trait_ = billOuterClass$ResponseInquiryBill;
        } else {
            this.trait_ = ((BillOuterClass$ResponseInquiryBill.a) BillOuterClass$ResponseInquiryBill.newBuilder((BillOuterClass$ResponseInquiryBill) this.trait_).v(billOuterClass$ResponseInquiryBill)).j();
        }
        this.traitCase_ = RESPONSE_INQUIRY_BILL_FIELD_NUMBER;
    }

    private void mergeResponseInviteUrl(GroupsOuterClass$ResponseInviteUrl groupsOuterClass$ResponseInviteUrl) {
        groupsOuterClass$ResponseInviteUrl.getClass();
        if (this.traitCase_ != 178 || this.trait_ == GroupsOuterClass$ResponseInviteUrl.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$ResponseInviteUrl;
        } else {
            this.trait_ = ((GroupsOuterClass$ResponseInviteUrl.a) GroupsOuterClass$ResponseInviteUrl.newBuilder((GroupsOuterClass$ResponseInviteUrl) this.trait_).v(groupsOuterClass$ResponseInviteUrl)).j();
        }
        this.traitCase_ = RESPONSE_INVITE_URL_FIELD_NUMBER;
    }

    private void mergeResponseInvoiceKifpool(KifpoolOuterClass$ResponseInvoiceKifpool kifpoolOuterClass$ResponseInvoiceKifpool) {
        kifpoolOuterClass$ResponseInvoiceKifpool.getClass();
        if (this.traitCase_ != 63410 || this.trait_ == KifpoolOuterClass$ResponseInvoiceKifpool.getDefaultInstance()) {
            this.trait_ = kifpoolOuterClass$ResponseInvoiceKifpool;
        } else {
            this.trait_ = ((KifpoolOuterClass$ResponseInvoiceKifpool.a) KifpoolOuterClass$ResponseInvoiceKifpool.newBuilder((KifpoolOuterClass$ResponseInvoiceKifpool) this.trait_).v(kifpoolOuterClass$ResponseInvoiceKifpool)).j();
        }
        this.traitCase_ = RESPONSE_INVOICE_KIFPOOL_FIELD_NUMBER;
    }

    private void mergeResponseJoinGroup(GroupsOuterClass$ResponseJoinGroup groupsOuterClass$ResponseJoinGroup) {
        groupsOuterClass$ResponseJoinGroup.getClass();
        if (this.traitCase_ != 181 || this.trait_ == GroupsOuterClass$ResponseJoinGroup.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$ResponseJoinGroup;
        } else {
            this.trait_ = ((GroupsOuterClass$ResponseJoinGroup.a) GroupsOuterClass$ResponseJoinGroup.newBuilder((GroupsOuterClass$ResponseJoinGroup) this.trait_).v(groupsOuterClass$ResponseJoinGroup)).j();
        }
        this.traitCase_ = RESPONSE_JOIN_GROUP_FIELD_NUMBER;
    }

    private void mergeResponseJoinPublicGroup(GroupsOuterClass$ResponseJoinPublicGroup groupsOuterClass$ResponseJoinPublicGroup) {
        groupsOuterClass$ResponseJoinPublicGroup.getClass();
        if (this.traitCase_ != 2897 || this.trait_ == GroupsOuterClass$ResponseJoinPublicGroup.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$ResponseJoinPublicGroup;
        } else {
            this.trait_ = ((GroupsOuterClass$ResponseJoinPublicGroup.a) GroupsOuterClass$ResponseJoinPublicGroup.newBuilder((GroupsOuterClass$ResponseJoinPublicGroup) this.trait_).v(groupsOuterClass$ResponseJoinPublicGroup)).j();
        }
        this.traitCase_ = RESPONSE_JOIN_PUBLIC_GROUP_FIELD_NUMBER;
    }

    private void mergeResponseLoadArchived(MessagingOuterClass$ResponseLoadArchived messagingOuterClass$ResponseLoadArchived) {
        messagingOuterClass$ResponseLoadArchived.getClass();
        if (this.traitCase_ != 2652 || this.trait_ == MessagingOuterClass$ResponseLoadArchived.getDefaultInstance()) {
            this.trait_ = messagingOuterClass$ResponseLoadArchived;
        } else {
            this.trait_ = ((MessagingOuterClass$ResponseLoadArchived.a) MessagingOuterClass$ResponseLoadArchived.newBuilder((MessagingOuterClass$ResponseLoadArchived) this.trait_).v(messagingOuterClass$ResponseLoadArchived)).j();
        }
        this.traitCase_ = RESPONSE_LOAD_ARCHIVED_FIELD_NUMBER;
    }

    private void mergeResponseLoadAvatars(UsersOuterClass$ResponseLoadAvatars usersOuterClass$ResponseLoadAvatars) {
        usersOuterClass$ResponseLoadAvatars.getClass();
        if (this.traitCase_ != 2812 || this.trait_ == UsersOuterClass$ResponseLoadAvatars.getDefaultInstance()) {
            this.trait_ = usersOuterClass$ResponseLoadAvatars;
        } else {
            this.trait_ = ((UsersOuterClass$ResponseLoadAvatars.a) UsersOuterClass$ResponseLoadAvatars.newBuilder((UsersOuterClass$ResponseLoadAvatars) this.trait_).v(usersOuterClass$ResponseLoadAvatars)).j();
        }
        this.traitCase_ = RESPONSE_LOAD_AVATARS_FIELD_NUMBER;
    }

    private void mergeResponseLoadBlockedUsers(UsersOuterClass$ResponseLoadBlockedUsers usersOuterClass$ResponseLoadBlockedUsers) {
        usersOuterClass$ResponseLoadBlockedUsers.getClass();
        if (this.traitCase_ != 2639 || this.trait_ == UsersOuterClass$ResponseLoadBlockedUsers.getDefaultInstance()) {
            this.trait_ = usersOuterClass$ResponseLoadBlockedUsers;
        } else {
            this.trait_ = ((UsersOuterClass$ResponseLoadBlockedUsers.a) UsersOuterClass$ResponseLoadBlockedUsers.newBuilder((UsersOuterClass$ResponseLoadBlockedUsers) this.trait_).v(usersOuterClass$ResponseLoadBlockedUsers)).j();
        }
        this.traitCase_ = RESPONSE_LOAD_BLOCKED_USERS_FIELD_NUMBER;
    }

    private void mergeResponseLoadDialogs(MessagingOuterClass$ResponseLoadDialogs messagingOuterClass$ResponseLoadDialogs) {
        messagingOuterClass$ResponseLoadDialogs.getClass();
        if (this.traitCase_ != 105 || this.trait_ == MessagingOuterClass$ResponseLoadDialogs.getDefaultInstance()) {
            this.trait_ = messagingOuterClass$ResponseLoadDialogs;
        } else {
            this.trait_ = ((MessagingOuterClass$ResponseLoadDialogs.a) MessagingOuterClass$ResponseLoadDialogs.newBuilder((MessagingOuterClass$ResponseLoadDialogs) this.trait_).v(messagingOuterClass$ResponseLoadDialogs)).j();
        }
        this.traitCase_ = 105;
    }

    private void mergeResponseLoadFullGroups(GroupsOuterClass$ResponseLoadFullGroups groupsOuterClass$ResponseLoadFullGroups) {
        groupsOuterClass$ResponseLoadFullGroups.getClass();
        if (this.traitCase_ != 2783 || this.trait_ == GroupsOuterClass$ResponseLoadFullGroups.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$ResponseLoadFullGroups;
        } else {
            this.trait_ = ((GroupsOuterClass$ResponseLoadFullGroups.a) GroupsOuterClass$ResponseLoadFullGroups.newBuilder((GroupsOuterClass$ResponseLoadFullGroups) this.trait_).v(groupsOuterClass$ResponseLoadFullGroups)).j();
        }
        this.traitCase_ = RESPONSE_LOAD_FULL_GROUPS_FIELD_NUMBER;
    }

    private void mergeResponseLoadFullUsers(UsersOuterClass$ResponseLoadFullUsers usersOuterClass$ResponseLoadFullUsers) {
        usersOuterClass$ResponseLoadFullUsers.getClass();
        if (this.traitCase_ != 2650 || this.trait_ == UsersOuterClass$ResponseLoadFullUsers.getDefaultInstance()) {
            this.trait_ = usersOuterClass$ResponseLoadFullUsers;
        } else {
            this.trait_ = ((UsersOuterClass$ResponseLoadFullUsers.a) UsersOuterClass$ResponseLoadFullUsers.newBuilder((UsersOuterClass$ResponseLoadFullUsers) this.trait_).v(usersOuterClass$ResponseLoadFullUsers)).j();
        }
        this.traitCase_ = RESPONSE_LOAD_FULL_USERS_FIELD_NUMBER;
    }

    private void mergeResponseLoadGroupAvatars(GroupsOuterClass$ResponseLoadGroupAvatars groupsOuterClass$ResponseLoadGroupAvatars) {
        groupsOuterClass$ResponseLoadGroupAvatars.getClass();
        if (this.traitCase_ != 43749 || this.trait_ == GroupsOuterClass$ResponseLoadGroupAvatars.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$ResponseLoadGroupAvatars;
        } else {
            this.trait_ = ((GroupsOuterClass$ResponseLoadGroupAvatars.a) GroupsOuterClass$ResponseLoadGroupAvatars.newBuilder((GroupsOuterClass$ResponseLoadGroupAvatars) this.trait_).v(groupsOuterClass$ResponseLoadGroupAvatars)).j();
        }
        this.traitCase_ = RESPONSE_LOAD_GROUP_AVATARS_FIELD_NUMBER;
    }

    private void mergeResponseLoadGroupedDialogs(MessagingOuterClass$ResponseLoadGroupedDialogs messagingOuterClass$ResponseLoadGroupedDialogs) {
        messagingOuterClass$ResponseLoadGroupedDialogs.getClass();
        if (this.traitCase_ != 226 || this.trait_ == MessagingOuterClass$ResponseLoadGroupedDialogs.getDefaultInstance()) {
            this.trait_ = messagingOuterClass$ResponseLoadGroupedDialogs;
        } else {
            this.trait_ = ((MessagingOuterClass$ResponseLoadGroupedDialogs.a) MessagingOuterClass$ResponseLoadGroupedDialogs.newBuilder((MessagingOuterClass$ResponseLoadGroupedDialogs) this.trait_).v(messagingOuterClass$ResponseLoadGroupedDialogs)).j();
        }
        this.traitCase_ = 226;
    }

    private void mergeResponseLoadGroups(GroupsOuterClass$ResponseLoadGroups groupsOuterClass$ResponseLoadGroups) {
        groupsOuterClass$ResponseLoadGroups.getClass();
        if (this.traitCase_ != 63246 || this.trait_ == GroupsOuterClass$ResponseLoadGroups.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$ResponseLoadGroups;
        } else {
            this.trait_ = ((GroupsOuterClass$ResponseLoadGroups.a) GroupsOuterClass$ResponseLoadGroups.newBuilder((GroupsOuterClass$ResponseLoadGroups) this.trait_).v(groupsOuterClass$ResponseLoadGroups)).j();
        }
        this.traitCase_ = RESPONSE_LOAD_GROUPS_FIELD_NUMBER;
    }

    private void mergeResponseLoadHistory(MessagingOuterClass$ResponseLoadHistory messagingOuterClass$ResponseLoadHistory) {
        messagingOuterClass$ResponseLoadHistory.getClass();
        if (this.traitCase_ != 119 || this.trait_ == MessagingOuterClass$ResponseLoadHistory.getDefaultInstance()) {
            this.trait_ = messagingOuterClass$ResponseLoadHistory;
        } else {
            this.trait_ = ((MessagingOuterClass$ResponseLoadHistory.a) MessagingOuterClass$ResponseLoadHistory.newBuilder((MessagingOuterClass$ResponseLoadHistory) this.trait_).v(messagingOuterClass$ResponseLoadHistory)).j();
        }
        this.traitCase_ = 119;
    }

    private void mergeResponseLoadLastStates(MelonOuterClass$ResponseLoadLastStates melonOuterClass$ResponseLoadLastStates) {
        melonOuterClass$ResponseLoadLastStates.getClass();
        if (this.traitCase_ != 63660 || this.trait_ == MelonOuterClass$ResponseLoadLastStates.getDefaultInstance()) {
            this.trait_ = melonOuterClass$ResponseLoadLastStates;
        } else {
            this.trait_ = ((MelonOuterClass$ResponseLoadLastStates.a) MelonOuterClass$ResponseLoadLastStates.newBuilder((MelonOuterClass$ResponseLoadLastStates) this.trait_).v(melonOuterClass$ResponseLoadLastStates)).j();
        }
        this.traitCase_ = RESPONSE_LOAD_LAST_STATES_FIELD_NUMBER;
    }

    private void mergeResponseLoadLoanHistory(MelonOuterClass$ResponseLoadLoanHistory melonOuterClass$ResponseLoadLoanHistory) {
        melonOuterClass$ResponseLoadLoanHistory.getClass();
        if (this.traitCase_ != 63657 || this.trait_ == MelonOuterClass$ResponseLoadLoanHistory.getDefaultInstance()) {
            this.trait_ = melonOuterClass$ResponseLoadLoanHistory;
        } else {
            this.trait_ = ((MelonOuterClass$ResponseLoadLoanHistory.a) MelonOuterClass$ResponseLoadLoanHistory.newBuilder((MelonOuterClass$ResponseLoadLoanHistory) this.trait_).v(melonOuterClass$ResponseLoadLoanHistory)).j();
        }
        this.traitCase_ = RESPONSE_LOAD_LOAN_HISTORY_FIELD_NUMBER;
    }

    private void mergeResponseLoadMembers(GroupsOuterClass$ResponseLoadMembers groupsOuterClass$ResponseLoadMembers) {
        groupsOuterClass$ResponseLoadMembers.getClass();
        if (this.traitCase_ != 2787 || this.trait_ == GroupsOuterClass$ResponseLoadMembers.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$ResponseLoadMembers;
        } else {
            this.trait_ = ((GroupsOuterClass$ResponseLoadMembers.a) GroupsOuterClass$ResponseLoadMembers.newBuilder((GroupsOuterClass$ResponseLoadMembers) this.trait_).v(groupsOuterClass$ResponseLoadMembers)).j();
        }
        this.traitCase_ = RESPONSE_LOAD_MEMBERS_FIELD_NUMBER;
    }

    private void mergeResponseLoadOwnStickers(ImagesOuterClass$ResponseLoadOwnStickers imagesOuterClass$ResponseLoadOwnStickers) {
        imagesOuterClass$ResponseLoadOwnStickers.getClass();
        if (this.traitCase_ != 239 || this.trait_ == ImagesOuterClass$ResponseLoadOwnStickers.getDefaultInstance()) {
            this.trait_ = imagesOuterClass$ResponseLoadOwnStickers;
        } else {
            this.trait_ = ((ImagesOuterClass$ResponseLoadOwnStickers.a) ImagesOuterClass$ResponseLoadOwnStickers.newBuilder((ImagesOuterClass$ResponseLoadOwnStickers) this.trait_).v(imagesOuterClass$ResponseLoadOwnStickers)).j();
        }
        this.traitCase_ = RESPONSE_LOAD_OWN_STICKERS_FIELD_NUMBER;
    }

    private void mergeResponseLoadPeerDialogs(MessagingOuterClass$ResponseLoadPeerDialogs messagingOuterClass$ResponseLoadPeerDialogs) {
        messagingOuterClass$ResponseLoadPeerDialogs.getClass();
        if (this.traitCase_ != 63250 || this.trait_ == MessagingOuterClass$ResponseLoadPeerDialogs.getDefaultInstance()) {
            this.trait_ = messagingOuterClass$ResponseLoadPeerDialogs;
        } else {
            this.trait_ = ((MessagingOuterClass$ResponseLoadPeerDialogs.a) MessagingOuterClass$ResponseLoadPeerDialogs.newBuilder((MessagingOuterClass$ResponseLoadPeerDialogs) this.trait_).v(messagingOuterClass$ResponseLoadPeerDialogs)).j();
        }
        this.traitCase_ = RESPONSE_LOAD_PEER_DIALOGS_FIELD_NUMBER;
    }

    private void mergeResponseLoadReactions(AbacusOuterClass$ResponseLoadReactions abacusOuterClass$ResponseLoadReactions) {
        abacusOuterClass$ResponseLoadReactions.getClass();
        if (this.traitCase_ != 63240 || this.trait_ == AbacusOuterClass$ResponseLoadReactions.getDefaultInstance()) {
            this.trait_ = abacusOuterClass$ResponseLoadReactions;
        } else {
            this.trait_ = ((AbacusOuterClass$ResponseLoadReactions.a) AbacusOuterClass$ResponseLoadReactions.newBuilder((AbacusOuterClass$ResponseLoadReactions) this.trait_).v(abacusOuterClass$ResponseLoadReactions)).j();
        }
        this.traitCase_ = RESPONSE_LOAD_REACTIONS_FIELD_NUMBER;
    }

    private void mergeResponseLoadStickerCollection(ImagesOuterClass$ResponseLoadStickerCollection imagesOuterClass$ResponseLoadStickerCollection) {
        imagesOuterClass$ResponseLoadStickerCollection.getClass();
        if (this.traitCase_ != 247 || this.trait_ == ImagesOuterClass$ResponseLoadStickerCollection.getDefaultInstance()) {
            this.trait_ = imagesOuterClass$ResponseLoadStickerCollection;
        } else {
            this.trait_ = ((ImagesOuterClass$ResponseLoadStickerCollection.a) ImagesOuterClass$ResponseLoadStickerCollection.newBuilder((ImagesOuterClass$ResponseLoadStickerCollection) this.trait_).v(imagesOuterClass$ResponseLoadStickerCollection)).j();
        }
        this.traitCase_ = RESPONSE_LOAD_STICKER_COLLECTION_FIELD_NUMBER;
    }

    private void mergeResponseLoadTransactions(PfmOuterClass$ResponseLoadTransactions pfmOuterClass$ResponseLoadTransactions) {
        pfmOuterClass$ResponseLoadTransactions.getClass();
        if (this.traitCase_ != 63446 || this.trait_ == PfmOuterClass$ResponseLoadTransactions.getDefaultInstance()) {
            this.trait_ = pfmOuterClass$ResponseLoadTransactions;
        } else {
            this.trait_ = ((PfmOuterClass$ResponseLoadTransactions.a) PfmOuterClass$ResponseLoadTransactions.newBuilder((PfmOuterClass$ResponseLoadTransactions) this.trait_).v(pfmOuterClass$ResponseLoadTransactions)).j();
        }
        this.traitCase_ = RESPONSE_LOAD_TRANSACTIONS_FIELD_NUMBER;
    }

    private void mergeResponseLoadTransactionsByIds(PfmOuterClass$ResponseLoadTransactionsByIDs pfmOuterClass$ResponseLoadTransactionsByIDs) {
        pfmOuterClass$ResponseLoadTransactionsByIDs.getClass();
        if (this.traitCase_ != 63650 || this.trait_ == PfmOuterClass$ResponseLoadTransactionsByIDs.getDefaultInstance()) {
            this.trait_ = pfmOuterClass$ResponseLoadTransactionsByIDs;
        } else {
            this.trait_ = ((PfmOuterClass$ResponseLoadTransactionsByIDs.a) PfmOuterClass$ResponseLoadTransactionsByIDs.newBuilder((PfmOuterClass$ResponseLoadTransactionsByIDs) this.trait_).v(pfmOuterClass$ResponseLoadTransactionsByIDs)).j();
        }
        this.traitCase_ = RESPONSE_LOAD_TRANSACTIONS_BY_IDS_FIELD_NUMBER;
    }

    private void mergeResponseLoadUsers(UsersOuterClass$ResponseLoadUsers usersOuterClass$ResponseLoadUsers) {
        usersOuterClass$ResponseLoadUsers.getClass();
        if (this.traitCase_ != 63248 || this.trait_ == UsersOuterClass$ResponseLoadUsers.getDefaultInstance()) {
            this.trait_ = usersOuterClass$ResponseLoadUsers;
        } else {
            this.trait_ = ((UsersOuterClass$ResponseLoadUsers.a) UsersOuterClass$ResponseLoadUsers.newBuilder((UsersOuterClass$ResponseLoadUsers) this.trait_).v(usersOuterClass$ResponseLoadUsers)).j();
        }
        this.traitCase_ = RESPONSE_LOAD_USERS_FIELD_NUMBER;
    }

    private void mergeResponseOpenGiftPacket(Giftpacket$ResponseOpenGiftPacket giftpacket$ResponseOpenGiftPacket) {
        giftpacket$ResponseOpenGiftPacket.getClass();
        if (this.traitCase_ != 63237 || this.trait_ == Giftpacket$ResponseOpenGiftPacket.getDefaultInstance()) {
            this.trait_ = giftpacket$ResponseOpenGiftPacket;
        } else {
            this.trait_ = ((Giftpacket$ResponseOpenGiftPacket.a) Giftpacket$ResponseOpenGiftPacket.newBuilder((Giftpacket$ResponseOpenGiftPacket) this.trait_).v(giftpacket$ResponseOpenGiftPacket)).j();
        }
        this.traitCase_ = RESPONSE_OPEN_GIFT_PACKET_FIELD_NUMBER;
    }

    private void mergeResponsePayBill(BillOuterClass$ResponsePayBill billOuterClass$ResponsePayBill) {
        billOuterClass$ResponsePayBill.getClass();
        if (this.traitCase_ != 63546 || this.trait_ == BillOuterClass$ResponsePayBill.getDefaultInstance()) {
            this.trait_ = billOuterClass$ResponsePayBill;
        } else {
            this.trait_ = ((BillOuterClass$ResponsePayBill.a) BillOuterClass$ResponsePayBill.newBuilder((BillOuterClass$ResponsePayBill) this.trait_).v(billOuterClass$ResponsePayBill)).j();
        }
        this.traitCase_ = RESPONSE_PAY_BILL_FIELD_NUMBER;
    }

    private void mergeResponsePaySefte(SefteOuterClass$ResponsePaySefte sefteOuterClass$ResponsePaySefte) {
        sefteOuterClass$ResponsePaySefte.getClass();
        if (this.traitCase_ != 63636 || this.trait_ == SefteOuterClass$ResponsePaySefte.getDefaultInstance()) {
            this.trait_ = sefteOuterClass$ResponsePaySefte;
        } else {
            this.trait_ = ((SefteOuterClass$ResponsePaySefte.a) SefteOuterClass$ResponsePaySefte.newBuilder((SefteOuterClass$ResponsePaySefte) this.trait_).v(sefteOuterClass$ResponsePaySefte)).j();
        }
        this.traitCase_ = RESPONSE_PAY_SEFTE_FIELD_NUMBER;
    }

    private void mergeResponseProto(Protobuf$ResponseProto protobuf$ResponseProto) {
        protobuf$ResponseProto.getClass();
        if (this.traitCase_ != 63640 || this.trait_ == Protobuf$ResponseProto.getDefaultInstance()) {
            this.trait_ = protobuf$ResponseProto;
        } else {
            this.trait_ = ((Protobuf$ResponseProto.a) Protobuf$ResponseProto.newBuilder((Protobuf$ResponseProto) this.trait_).v(protobuf$ResponseProto)).j();
        }
        this.traitCase_ = RESPONSE_PROTO_FIELD_NUMBER;
    }

    private void mergeResponsePurchaseMessage(KifpoolOuterClass$ResponsePurchaseMessage kifpoolOuterClass$ResponsePurchaseMessage) {
        kifpoolOuterClass$ResponsePurchaseMessage.getClass();
        if (this.traitCase_ != 63419 || this.trait_ == KifpoolOuterClass$ResponsePurchaseMessage.getDefaultInstance()) {
            this.trait_ = kifpoolOuterClass$ResponsePurchaseMessage;
        } else {
            this.trait_ = ((KifpoolOuterClass$ResponsePurchaseMessage.a) KifpoolOuterClass$ResponsePurchaseMessage.newBuilder((KifpoolOuterClass$ResponsePurchaseMessage) this.trait_).v(kifpoolOuterClass$ResponsePurchaseMessage)).j();
        }
        this.traitCase_ = RESPONSE_PURCHASE_MESSAGE_FIELD_NUMBER;
    }

    private void mergeResponsePurchaseMessageWithCharge(KifpoolOuterClass$ResponsePurchaseMessageWithCharge kifpoolOuterClass$ResponsePurchaseMessageWithCharge) {
        kifpoolOuterClass$ResponsePurchaseMessageWithCharge.getClass();
        if (this.traitCase_ != 63429 || this.trait_ == KifpoolOuterClass$ResponsePurchaseMessageWithCharge.getDefaultInstance()) {
            this.trait_ = kifpoolOuterClass$ResponsePurchaseMessageWithCharge;
        } else {
            this.trait_ = ((KifpoolOuterClass$ResponsePurchaseMessageWithCharge.a) KifpoolOuterClass$ResponsePurchaseMessageWithCharge.newBuilder((KifpoolOuterClass$ResponsePurchaseMessageWithCharge) this.trait_).v(kifpoolOuterClass$ResponsePurchaseMessageWithCharge)).j();
        }
        this.traitCase_ = RESPONSE_PURCHASE_MESSAGE_WITH_CHARGE_FIELD_NUMBER;
    }

    private void mergeResponseReactionsResponse(AbacusOuterClass$ResponseReactionsResponse abacusOuterClass$ResponseReactionsResponse) {
        abacusOuterClass$ResponseReactionsResponse.getClass();
        if (this.traitCase_ != 219 || this.trait_ == AbacusOuterClass$ResponseReactionsResponse.getDefaultInstance()) {
            this.trait_ = abacusOuterClass$ResponseReactionsResponse;
        } else {
            this.trait_ = ((AbacusOuterClass$ResponseReactionsResponse.a) AbacusOuterClass$ResponseReactionsResponse.newBuilder((AbacusOuterClass$ResponseReactionsResponse) this.trait_).v(abacusOuterClass$ResponseReactionsResponse)).j();
        }
        this.traitCase_ = 219;
    }

    private void mergeResponseReactivateApp(SapOuterClass$ResponseReactivateApp sapOuterClass$ResponseReactivateApp) {
        sapOuterClass$ResponseReactivateApp.getClass();
        if (this.traitCase_ != 63592 || this.trait_ == SapOuterClass$ResponseReactivateApp.getDefaultInstance()) {
            this.trait_ = sapOuterClass$ResponseReactivateApp;
        } else {
            this.trait_ = ((SapOuterClass$ResponseReactivateApp.a) SapOuterClass$ResponseReactivateApp.newBuilder((SapOuterClass$ResponseReactivateApp) this.trait_).v(sapOuterClass$ResponseReactivateApp)).j();
        }
        this.traitCase_ = RESPONSE_REACTIVATE_APP_FIELD_NUMBER;
    }

    private void mergeResponseRefer(ReferralOuterClass$ResponseRefer referralOuterClass$ResponseRefer) {
        referralOuterClass$ResponseRefer.getClass();
        if (this.traitCase_ != 63503 || this.trait_ == ReferralOuterClass$ResponseRefer.getDefaultInstance()) {
            this.trait_ = referralOuterClass$ResponseRefer;
        } else {
            this.trait_ = ((ReferralOuterClass$ResponseRefer.a) ReferralOuterClass$ResponseRefer.newBuilder((ReferralOuterClass$ResponseRefer) this.trait_).v(referralOuterClass$ResponseRefer)).j();
        }
        this.traitCase_ = RESPONSE_REFER_FIELD_NUMBER;
    }

    private void mergeResponseSearchContacts(UsersOuterClass$ResponseSearchContacts usersOuterClass$ResponseSearchContacts) {
        usersOuterClass$ResponseSearchContacts.getClass();
        if (this.traitCase_ != 113 || this.trait_ == UsersOuterClass$ResponseSearchContacts.getDefaultInstance()) {
            this.trait_ = usersOuterClass$ResponseSearchContacts;
        } else {
            this.trait_ = ((UsersOuterClass$ResponseSearchContacts.a) UsersOuterClass$ResponseSearchContacts.newBuilder((UsersOuterClass$ResponseSearchContacts) this.trait_).v(usersOuterClass$ResponseSearchContacts)).j();
        }
        this.traitCase_ = 113;
    }

    private void mergeResponseSearchMedia(SearchOuterClass$ResponseSearchMedia searchOuterClass$ResponseSearchMedia) {
        searchOuterClass$ResponseSearchMedia.getClass();
        if (this.traitCase_ != 63263 || this.trait_ == SearchOuterClass$ResponseSearchMedia.getDefaultInstance()) {
            this.trait_ = searchOuterClass$ResponseSearchMedia;
        } else {
            this.trait_ = ((SearchOuterClass$ResponseSearchMedia.a) SearchOuterClass$ResponseSearchMedia.newBuilder((SearchOuterClass$ResponseSearchMedia) this.trait_).v(searchOuterClass$ResponseSearchMedia)).j();
        }
        this.traitCase_ = RESPONSE_SEARCH_MEDIA_FIELD_NUMBER;
    }

    private void mergeResponseSearchMessages(SearchOuterClass$ResponseSearchMessages searchOuterClass$ResponseSearchMessages) {
        searchOuterClass$ResponseSearchMessages.getClass();
        if (this.traitCase_ != 218 || this.trait_ == SearchOuterClass$ResponseSearchMessages.getDefaultInstance()) {
            this.trait_ = searchOuterClass$ResponseSearchMessages;
        } else {
            this.trait_ = ((SearchOuterClass$ResponseSearchMessages.a) SearchOuterClass$ResponseSearchMessages.newBuilder((SearchOuterClass$ResponseSearchMessages) this.trait_).v(searchOuterClass$ResponseSearchMessages)).j();
        }
        this.traitCase_ = 218;
    }

    private void mergeResponseSearchPeer(SearchOuterClass$ResponseSearchPeer searchOuterClass$ResponseSearchPeer) {
        searchOuterClass$ResponseSearchPeer.getClass();
        if (this.traitCase_ != 234 || this.trait_ == SearchOuterClass$ResponseSearchPeer.getDefaultInstance()) {
            this.trait_ = searchOuterClass$ResponseSearchPeer;
        } else {
            this.trait_ = ((SearchOuterClass$ResponseSearchPeer.a) SearchOuterClass$ResponseSearchPeer.newBuilder((SearchOuterClass$ResponseSearchPeer) this.trait_).v(searchOuterClass$ResponseSearchPeer)).j();
        }
        this.traitCase_ = RESPONSE_SEARCH_PEER_FIELD_NUMBER;
    }

    private void mergeResponseSendChangePhoneVerificationCode(AuthOuterClass$ResponseSendChangePhoneVerificationCode authOuterClass$ResponseSendChangePhoneVerificationCode) {
        authOuterClass$ResponseSendChangePhoneVerificationCode.getClass();
        if (this.traitCase_ != 63505 || this.trait_ == AuthOuterClass$ResponseSendChangePhoneVerificationCode.getDefaultInstance()) {
            this.trait_ = authOuterClass$ResponseSendChangePhoneVerificationCode;
        } else {
            this.trait_ = ((AuthOuterClass$ResponseSendChangePhoneVerificationCode.a) AuthOuterClass$ResponseSendChangePhoneVerificationCode.newBuilder((AuthOuterClass$ResponseSendChangePhoneVerificationCode) this.trait_).v(authOuterClass$ResponseSendChangePhoneVerificationCode)).j();
        }
        this.traitCase_ = RESPONSE_SEND_CHANGE_PHONE_VERIFICATION_CODE_FIELD_NUMBER;
    }

    private void mergeResponseSendDeleteAccountVerificationCode(AuthOuterClass$ResponseSendDeleteAccountVerificationCode authOuterClass$ResponseSendDeleteAccountVerificationCode) {
        authOuterClass$ResponseSendDeleteAccountVerificationCode.getClass();
        if (this.traitCase_ != 3089 || this.trait_ == AuthOuterClass$ResponseSendDeleteAccountVerificationCode.getDefaultInstance()) {
            this.trait_ = authOuterClass$ResponseSendDeleteAccountVerificationCode;
        } else {
            this.trait_ = ((AuthOuterClass$ResponseSendDeleteAccountVerificationCode.a) AuthOuterClass$ResponseSendDeleteAccountVerificationCode.newBuilder((AuthOuterClass$ResponseSendDeleteAccountVerificationCode) this.trait_).v(authOuterClass$ResponseSendDeleteAccountVerificationCode)).j();
        }
        this.traitCase_ = RESPONSE_SEND_DELETE_ACCOUNT_VERIFICATION_CODE_FIELD_NUMBER;
    }

    private void mergeResponseSeq(Misc$ResponseSeq misc$ResponseSeq) {
        misc$ResponseSeq.getClass();
        if (this.traitCase_ != 72 || this.trait_ == Misc$ResponseSeq.getDefaultInstance()) {
            this.trait_ = misc$ResponseSeq;
        } else {
            this.trait_ = ((Misc$ResponseSeq.a) Misc$ResponseSeq.newBuilder((Misc$ResponseSeq) this.trait_).v(misc$ResponseSeq)).j();
        }
        this.traitCase_ = 72;
    }

    private void mergeResponseSeqDate(Misc$ResponseSeqDate misc$ResponseSeqDate) {
        misc$ResponseSeqDate.getClass();
        if (this.traitCase_ != 102 || this.trait_ == Misc$ResponseSeqDate.getDefaultInstance()) {
            this.trait_ = misc$ResponseSeqDate;
        } else {
            this.trait_ = ((Misc$ResponseSeqDate.a) Misc$ResponseSeqDate.newBuilder((Misc$ResponseSeqDate) this.trait_).v(misc$ResponseSeqDate)).j();
        }
        this.traitCase_ = 102;
    }

    private void mergeResponseSignSefte(SefteOuterClass$ResponseSignSefte sefteOuterClass$ResponseSignSefte) {
        sefteOuterClass$ResponseSignSefte.getClass();
        if (this.traitCase_ != 63613 || this.trait_ == SefteOuterClass$ResponseSignSefte.getDefaultInstance()) {
            this.trait_ = sefteOuterClass$ResponseSignSefte;
        } else {
            this.trait_ = ((SefteOuterClass$ResponseSignSefte.a) SefteOuterClass$ResponseSignSefte.newBuilder((SefteOuterClass$ResponseSignSefte) this.trait_).v(sefteOuterClass$ResponseSignSefte)).j();
        }
        this.traitCase_ = RESPONSE_SIGN_SEFTE_FIELD_NUMBER;
    }

    private void mergeResponseSpinWheel(ClubOuterClass$ResponseSpinWheel clubOuterClass$ResponseSpinWheel) {
        clubOuterClass$ResponseSpinWheel.getClass();
        if (this.traitCase_ != 63471 || this.trait_ == ClubOuterClass$ResponseSpinWheel.getDefaultInstance()) {
            this.trait_ = clubOuterClass$ResponseSpinWheel;
        } else {
            this.trait_ = ((ClubOuterClass$ResponseSpinWheel.a) ClubOuterClass$ResponseSpinWheel.newBuilder((ClubOuterClass$ResponseSpinWheel) this.trait_).v(clubOuterClass$ResponseSpinWheel)).j();
        }
        this.traitCase_ = RESPONSE_SPIN_WHEEL_FIELD_NUMBER;
    }

    private void mergeResponseSplitTransaction(PfmOuterClass$ResponseSplitTransaction pfmOuterClass$ResponseSplitTransaction) {
        pfmOuterClass$ResponseSplitTransaction.getClass();
        if (this.traitCase_ != 63648 || this.trait_ == PfmOuterClass$ResponseSplitTransaction.getDefaultInstance()) {
            this.trait_ = pfmOuterClass$ResponseSplitTransaction;
        } else {
            this.trait_ = ((PfmOuterClass$ResponseSplitTransaction.a) PfmOuterClass$ResponseSplitTransaction.newBuilder((PfmOuterClass$ResponseSplitTransaction) this.trait_).v(pfmOuterClass$ResponseSplitTransaction)).j();
        }
        this.traitCase_ = RESPONSE_SPLIT_TRANSACTION_FIELD_NUMBER;
    }

    private void mergeResponseStartPhoneAuth(AuthOuterClass$ResponseStartPhoneAuth authOuterClass$ResponseStartPhoneAuth) {
        authOuterClass$ResponseStartPhoneAuth.getClass();
        if (this.traitCase_ != 193 || this.trait_ == AuthOuterClass$ResponseStartPhoneAuth.getDefaultInstance()) {
            this.trait_ = authOuterClass$ResponseStartPhoneAuth;
        } else {
            this.trait_ = ((AuthOuterClass$ResponseStartPhoneAuth.b) AuthOuterClass$ResponseStartPhoneAuth.newBuilder((AuthOuterClass$ResponseStartPhoneAuth) this.trait_).v(authOuterClass$ResponseStartPhoneAuth)).j();
        }
        this.traitCase_ = RESPONSE_START_PHONE_AUTH_FIELD_NUMBER;
    }

    private void mergeResponseStickersReponse(ImagesOuterClass$ResponseStickersReponse imagesOuterClass$ResponseStickersReponse) {
        imagesOuterClass$ResponseStickersReponse.getClass();
        if (this.traitCase_ != 240 || this.trait_ == ImagesOuterClass$ResponseStickersReponse.getDefaultInstance()) {
            this.trait_ = imagesOuterClass$ResponseStickersReponse;
        } else {
            this.trait_ = ((ImagesOuterClass$ResponseStickersReponse.a) ImagesOuterClass$ResponseStickersReponse.newBuilder((ImagesOuterClass$ResponseStickersReponse) this.trait_).v(imagesOuterClass$ResponseStickersReponse)).j();
        }
        this.traitCase_ = RESPONSE_STICKERS_REPONSE_FIELD_NUMBER;
    }

    private void mergeResponseTransactionPoint(KifpoolOuterClass$ResponseTransactionPoint kifpoolOuterClass$ResponseTransactionPoint) {
        kifpoolOuterClass$ResponseTransactionPoint.getClass();
        if (this.traitCase_ != 63463 || this.trait_ == KifpoolOuterClass$ResponseTransactionPoint.getDefaultInstance()) {
            this.trait_ = kifpoolOuterClass$ResponseTransactionPoint;
        } else {
            this.trait_ = ((KifpoolOuterClass$ResponseTransactionPoint.a) KifpoolOuterClass$ResponseTransactionPoint.newBuilder((KifpoolOuterClass$ResponseTransactionPoint) this.trait_).v(kifpoolOuterClass$ResponseTransactionPoint)).j();
        }
        this.traitCase_ = RESPONSE_TRANSACTION_POINT_FIELD_NUMBER;
    }

    private void mergeResponseTransferMoney(KifpoolOuterClass$ResponseTransferMoney kifpoolOuterClass$ResponseTransferMoney) {
        kifpoolOuterClass$ResponseTransferMoney.getClass();
        if (this.traitCase_ != 63412 || this.trait_ == KifpoolOuterClass$ResponseTransferMoney.getDefaultInstance()) {
            this.trait_ = kifpoolOuterClass$ResponseTransferMoney;
        } else {
            this.trait_ = ((KifpoolOuterClass$ResponseTransferMoney.a) KifpoolOuterClass$ResponseTransferMoney.newBuilder((KifpoolOuterClass$ResponseTransferMoney) this.trait_).v(kifpoolOuterClass$ResponseTransferMoney)).j();
        }
        this.traitCase_ = RESPONSE_TRANSFER_MONEY_FIELD_NUMBER;
    }

    private void mergeResponseUpdateClick(AdvertisementOuterClass$ResponseUpdateClick advertisementOuterClass$ResponseUpdateClick) {
        advertisementOuterClass$ResponseUpdateClick.getClass();
        if (this.traitCase_ != 63623 || this.trait_ == AdvertisementOuterClass$ResponseUpdateClick.getDefaultInstance()) {
            this.trait_ = advertisementOuterClass$ResponseUpdateClick;
        } else {
            this.trait_ = ((AdvertisementOuterClass$ResponseUpdateClick.a) AdvertisementOuterClass$ResponseUpdateClick.newBuilder((AdvertisementOuterClass$ResponseUpdateClick) this.trait_).v(advertisementOuterClass$ResponseUpdateClick)).j();
        }
        this.traitCase_ = RESPONSE_UPDATE_CLICK_FIELD_NUMBER;
    }

    private void mergeResponseUpdateView(AdvertisementOuterClass$ResponseUpdateView advertisementOuterClass$ResponseUpdateView) {
        advertisementOuterClass$ResponseUpdateView.getClass();
        if (this.traitCase_ != 63561 || this.trait_ == AdvertisementOuterClass$ResponseUpdateView.getDefaultInstance()) {
            this.trait_ = advertisementOuterClass$ResponseUpdateView;
        } else {
            this.trait_ = ((AdvertisementOuterClass$ResponseUpdateView.a) AdvertisementOuterClass$ResponseUpdateView.newBuilder((AdvertisementOuterClass$ResponseUpdateView) this.trait_).v(advertisementOuterClass$ResponseUpdateView)).j();
        }
        this.traitCase_ = RESPONSE_UPDATE_VIEW_FIELD_NUMBER;
    }

    private void mergeResponseUpgradeKifpool(KifpoolOuterClass$ResponseUpgradeKifpool kifpoolOuterClass$ResponseUpgradeKifpool) {
        kifpoolOuterClass$ResponseUpgradeKifpool.getClass();
        if (this.traitCase_ != 63403 || this.trait_ == KifpoolOuterClass$ResponseUpgradeKifpool.getDefaultInstance()) {
            this.trait_ = kifpoolOuterClass$ResponseUpgradeKifpool;
        } else {
            this.trait_ = ((KifpoolOuterClass$ResponseUpgradeKifpool.a) KifpoolOuterClass$ResponseUpgradeKifpool.newBuilder((KifpoolOuterClass$ResponseUpgradeKifpool) this.trait_).v(kifpoolOuterClass$ResponseUpgradeKifpool)).j();
        }
        this.traitCase_ = RESPONSE_UPGRADE_KIFPOOL_FIELD_NUMBER;
    }

    private void mergeResponseUserHasCred(SefteOuterClass$ResponseUserHasCred sefteOuterClass$ResponseUserHasCred) {
        sefteOuterClass$ResponseUserHasCred.getClass();
        if (this.traitCase_ != 63625 || this.trait_ == SefteOuterClass$ResponseUserHasCred.getDefaultInstance()) {
            this.trait_ = sefteOuterClass$ResponseUserHasCred;
        } else {
            this.trait_ = ((SefteOuterClass$ResponseUserHasCred.a) SefteOuterClass$ResponseUserHasCred.newBuilder((SefteOuterClass$ResponseUserHasCred) this.trait_).v(sefteOuterClass$ResponseUserHasCred)).j();
        }
        this.traitCase_ = RESPONSE_USER_HAS_CRED_FIELD_NUMBER;
    }

    private void mergeResponseValidateMySentence(SentenceOuterClass$ResponseValidateMySentence sentenceOuterClass$ResponseValidateMySentence) {
        sentenceOuterClass$ResponseValidateMySentence.getClass();
        if (this.traitCase_ != 63576 || this.trait_ == SentenceOuterClass$ResponseValidateMySentence.getDefaultInstance()) {
            this.trait_ = sentenceOuterClass$ResponseValidateMySentence;
        } else {
            this.trait_ = ((SentenceOuterClass$ResponseValidateMySentence.a) SentenceOuterClass$ResponseValidateMySentence.newBuilder((SentenceOuterClass$ResponseValidateMySentence) this.trait_).v(sentenceOuterClass$ResponseValidateMySentence)).j();
        }
        this.traitCase_ = RESPONSE_VALIDATE_MY_SENTENCE_FIELD_NUMBER;
    }

    private void mergeResponseVerifyCashOut(WalletOuterClass$ResponseVerifyCashOut walletOuterClass$ResponseVerifyCashOut) {
        walletOuterClass$ResponseVerifyCashOut.getClass();
        if (this.traitCase_ != 62763 || this.trait_ == WalletOuterClass$ResponseVerifyCashOut.getDefaultInstance()) {
            this.trait_ = walletOuterClass$ResponseVerifyCashOut;
        } else {
            this.trait_ = ((WalletOuterClass$ResponseVerifyCashOut.a) WalletOuterClass$ResponseVerifyCashOut.newBuilder((WalletOuterClass$ResponseVerifyCashOut) this.trait_).v(walletOuterClass$ResponseVerifyCashOut)).j();
        }
        this.traitCase_ = RESPONSE_VERIFY_CASH_OUT_FIELD_NUMBER;
    }

    private void mergeResponseVerifyCashOutKifpool(KifpoolOuterClass$ResponseVerifyCashOutKifpool kifpoolOuterClass$ResponseVerifyCashOutKifpool) {
        kifpoolOuterClass$ResponseVerifyCashOutKifpool.getClass();
        if (this.traitCase_ != 63433 || this.trait_ == KifpoolOuterClass$ResponseVerifyCashOutKifpool.getDefaultInstance()) {
            this.trait_ = kifpoolOuterClass$ResponseVerifyCashOutKifpool;
        } else {
            this.trait_ = ((KifpoolOuterClass$ResponseVerifyCashOutKifpool.a) KifpoolOuterClass$ResponseVerifyCashOutKifpool.newBuilder((KifpoolOuterClass$ResponseVerifyCashOutKifpool) this.trait_).v(kifpoolOuterClass$ResponseVerifyCashOutKifpool)).j();
        }
        this.traitCase_ = RESPONSE_VERIFY_CASH_OUT_KIFPOOL_FIELD_NUMBER;
    }

    private void mergeResponseVerifyPeer(WalletOuterClass$ResponseVerifyPeer walletOuterClass$ResponseVerifyPeer) {
        walletOuterClass$ResponseVerifyPeer.getClass();
        if (this.traitCase_ != 62757 || this.trait_ == WalletOuterClass$ResponseVerifyPeer.getDefaultInstance()) {
            this.trait_ = walletOuterClass$ResponseVerifyPeer;
        } else {
            this.trait_ = ((WalletOuterClass$ResponseVerifyPeer.a) WalletOuterClass$ResponseVerifyPeer.newBuilder((WalletOuterClass$ResponseVerifyPeer) this.trait_).v(walletOuterClass$ResponseVerifyPeer)).j();
        }
        this.traitCase_ = RESPONSE_VERIFY_PEER_FIELD_NUMBER;
    }

    private void mergeResponseVerifyPurchaseMessage(KifpoolOuterClass$ResponseVerifyPurchaseMessage kifpoolOuterClass$ResponseVerifyPurchaseMessage) {
        kifpoolOuterClass$ResponseVerifyPurchaseMessage.getClass();
        if (this.traitCase_ != 63431 || this.trait_ == KifpoolOuterClass$ResponseVerifyPurchaseMessage.getDefaultInstance()) {
            this.trait_ = kifpoolOuterClass$ResponseVerifyPurchaseMessage;
        } else {
            this.trait_ = ((KifpoolOuterClass$ResponseVerifyPurchaseMessage.a) KifpoolOuterClass$ResponseVerifyPurchaseMessage.newBuilder((KifpoolOuterClass$ResponseVerifyPurchaseMessage) this.trait_).v(kifpoolOuterClass$ResponseVerifyPurchaseMessage)).j();
        }
        this.traitCase_ = RESPONSE_VERIFY_PURCHASE_MESSAGE_FIELD_NUMBER;
    }

    private void mergeResponseVerifyQrcode(WalletOuterClass$ResponseVerifyQRCode walletOuterClass$ResponseVerifyQRCode) {
        walletOuterClass$ResponseVerifyQRCode.getClass();
        if (this.traitCase_ != 62750 || this.trait_ == WalletOuterClass$ResponseVerifyQRCode.getDefaultInstance()) {
            this.trait_ = walletOuterClass$ResponseVerifyQRCode;
        } else {
            this.trait_ = ((WalletOuterClass$ResponseVerifyQRCode.a) WalletOuterClass$ResponseVerifyQRCode.newBuilder((WalletOuterClass$ResponseVerifyQRCode) this.trait_).v(walletOuterClass$ResponseVerifyQRCode)).j();
        }
        this.traitCase_ = RESPONSE_VERIFY_QRCODE_FIELD_NUMBER;
    }

    private void mergeResponseVoid(Misc$ResponseVoid misc$ResponseVoid) {
        misc$ResponseVoid.getClass();
        if (this.traitCase_ != 50 || this.trait_ == Misc$ResponseVoid.getDefaultInstance()) {
            this.trait_ = misc$ResponseVoid;
        } else {
            this.trait_ = ((Misc$ResponseVoid.a) Misc$ResponseVoid.newBuilder((Misc$ResponseVoid) this.trait_).v(misc$ResponseVoid)).j();
        }
        this.traitCase_ = 50;
    }

    private void mergeReviveTransaction(PfmOuterClass$RequestReviveTransaction pfmOuterClass$RequestReviveTransaction) {
        pfmOuterClass$RequestReviveTransaction.getClass();
        if (this.traitCase_ != 63655 || this.trait_ == PfmOuterClass$RequestReviveTransaction.getDefaultInstance()) {
            this.trait_ = pfmOuterClass$RequestReviveTransaction;
        } else {
            this.trait_ = ((PfmOuterClass$RequestReviveTransaction.a) PfmOuterClass$RequestReviveTransaction.newBuilder((PfmOuterClass$RequestReviveTransaction) this.trait_).v(pfmOuterClass$RequestReviveTransaction)).j();
        }
        this.traitCase_ = REVIVE_TRANSACTION_FIELD_NUMBER;
    }

    private void mergeRevokeInviteUrl(GroupsOuterClass$RequestRevokeInviteUrl groupsOuterClass$RequestRevokeInviteUrl) {
        groupsOuterClass$RequestRevokeInviteUrl.getClass();
        if (this.traitCase_ != 179 || this.trait_ == GroupsOuterClass$RequestRevokeInviteUrl.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$RequestRevokeInviteUrl;
        } else {
            this.trait_ = ((GroupsOuterClass$RequestRevokeInviteUrl.a) GroupsOuterClass$RequestRevokeInviteUrl.newBuilder((GroupsOuterClass$RequestRevokeInviteUrl) this.trait_).v(groupsOuterClass$RequestRevokeInviteUrl)).j();
        }
        this.traitCase_ = REVOKE_INVITE_URL_FIELD_NUMBER;
    }

    private void mergeSearchContacts(UsersOuterClass$RequestSearchContacts usersOuterClass$RequestSearchContacts) {
        usersOuterClass$RequestSearchContacts.getClass();
        if (this.traitCase_ != 112 || this.trait_ == UsersOuterClass$RequestSearchContacts.getDefaultInstance()) {
            this.trait_ = usersOuterClass$RequestSearchContacts;
        } else {
            this.trait_ = ((UsersOuterClass$RequestSearchContacts.b) UsersOuterClass$RequestSearchContacts.newBuilder((UsersOuterClass$RequestSearchContacts) this.trait_).v(usersOuterClass$RequestSearchContacts)).j();
        }
        this.traitCase_ = SEARCH_CONTACTS_FIELD_NUMBER;
    }

    private void mergeSearchMedia(SearchOuterClass$RequestSearchMedia searchOuterClass$RequestSearchMedia) {
        searchOuterClass$RequestSearchMedia.getClass();
        if (this.traitCase_ != 63262 || this.trait_ == SearchOuterClass$RequestSearchMedia.getDefaultInstance()) {
            this.trait_ = searchOuterClass$RequestSearchMedia;
        } else {
            this.trait_ = ((SearchOuterClass$RequestSearchMedia.b) SearchOuterClass$RequestSearchMedia.newBuilder((SearchOuterClass$RequestSearchMedia) this.trait_).v(searchOuterClass$RequestSearchMedia)).j();
        }
        this.traitCase_ = SEARCH_MEDIA_FIELD_NUMBER;
    }

    private void mergeSearchMessages(SearchOuterClass$RequestSearchMessages searchOuterClass$RequestSearchMessages) {
        searchOuterClass$RequestSearchMessages.getClass();
        if (this.traitCase_ != 217 || this.trait_ == SearchOuterClass$RequestSearchMessages.getDefaultInstance()) {
            this.trait_ = searchOuterClass$RequestSearchMessages;
        } else {
            this.trait_ = ((SearchOuterClass$RequestSearchMessages.b) SearchOuterClass$RequestSearchMessages.newBuilder((SearchOuterClass$RequestSearchMessages) this.trait_).v(searchOuterClass$RequestSearchMessages)).j();
        }
        this.traitCase_ = 217;
    }

    private void mergeSearchMessagesMore(SearchOuterClass$RequestSearchMessagesMore searchOuterClass$RequestSearchMessagesMore) {
        searchOuterClass$RequestSearchMessagesMore.getClass();
        if (this.traitCase_ != 222 || this.trait_ == SearchOuterClass$RequestSearchMessagesMore.getDefaultInstance()) {
            this.trait_ = searchOuterClass$RequestSearchMessagesMore;
        } else {
            this.trait_ = ((SearchOuterClass$RequestSearchMessagesMore.b) SearchOuterClass$RequestSearchMessagesMore.newBuilder((SearchOuterClass$RequestSearchMessagesMore) this.trait_).v(searchOuterClass$RequestSearchMessagesMore)).j();
        }
        this.traitCase_ = 222;
    }

    private void mergeSearchPeer(SearchOuterClass$RequestSearchPeer searchOuterClass$RequestSearchPeer) {
        searchOuterClass$RequestSearchPeer.getClass();
        if (this.traitCase_ != 233 || this.trait_ == SearchOuterClass$RequestSearchPeer.getDefaultInstance()) {
            this.trait_ = searchOuterClass$RequestSearchPeer;
        } else {
            this.trait_ = ((SearchOuterClass$RequestSearchPeer.b) SearchOuterClass$RequestSearchPeer.newBuilder((SearchOuterClass$RequestSearchPeer) this.trait_).v(searchOuterClass$RequestSearchPeer)).j();
        }
        this.traitCase_ = SEARCH_PEER_FIELD_NUMBER;
    }

    private void mergeSendChangePhoneVerificationCode(AuthOuterClass$RequestSendChangePhoneVerificationCode authOuterClass$RequestSendChangePhoneVerificationCode) {
        authOuterClass$RequestSendChangePhoneVerificationCode.getClass();
        if (this.traitCase_ != 63454 || this.trait_ == AuthOuterClass$RequestSendChangePhoneVerificationCode.getDefaultInstance()) {
            this.trait_ = authOuterClass$RequestSendChangePhoneVerificationCode;
        } else {
            this.trait_ = ((AuthOuterClass$RequestSendChangePhoneVerificationCode.a) AuthOuterClass$RequestSendChangePhoneVerificationCode.newBuilder((AuthOuterClass$RequestSendChangePhoneVerificationCode) this.trait_).v(authOuterClass$RequestSendChangePhoneVerificationCode)).j();
        }
        this.traitCase_ = SEND_CHANGE_PHONE_VERIFICATION_CODE_FIELD_NUMBER;
    }

    private void mergeSendDeleteAccountVerificationCode(AuthOuterClass$RequestSendDeleteAccountVerificationCode authOuterClass$RequestSendDeleteAccountVerificationCode) {
        authOuterClass$RequestSendDeleteAccountVerificationCode.getClass();
        if (this.traitCase_ != 43609 || this.trait_ == AuthOuterClass$RequestSendDeleteAccountVerificationCode.getDefaultInstance()) {
            this.trait_ = authOuterClass$RequestSendDeleteAccountVerificationCode;
        } else {
            this.trait_ = ((AuthOuterClass$RequestSendDeleteAccountVerificationCode.a) AuthOuterClass$RequestSendDeleteAccountVerificationCode.newBuilder((AuthOuterClass$RequestSendDeleteAccountVerificationCode) this.trait_).v(authOuterClass$RequestSendDeleteAccountVerificationCode)).j();
        }
        this.traitCase_ = SEND_DELETE_ACCOUNT_VERIFICATION_CODE_FIELD_NUMBER;
    }

    private void mergeSendFeedBack(Feedback$RequestSendFeedBack feedback$RequestSendFeedBack) {
        feedback$RequestSendFeedBack.getClass();
        if (this.traitCase_ != 63529 || this.trait_ == Feedback$RequestSendFeedBack.getDefaultInstance()) {
            this.trait_ = feedback$RequestSendFeedBack;
        } else {
            this.trait_ = ((Feedback$RequestSendFeedBack.a) Feedback$RequestSendFeedBack.newBuilder((Feedback$RequestSendFeedBack) this.trait_).v(feedback$RequestSendFeedBack)).j();
        }
        this.traitCase_ = SEND_FEED_BACK_FIELD_NUMBER;
    }

    private void mergeSendGiftPacketWithWallet(Giftpacket$RequestSendGiftPacketWithWallet giftpacket$RequestSendGiftPacketWithWallet) {
        giftpacket$RequestSendGiftPacketWithWallet.getClass();
        if (this.traitCase_ != 63233 || this.trait_ == Giftpacket$RequestSendGiftPacketWithWallet.getDefaultInstance()) {
            this.trait_ = giftpacket$RequestSendGiftPacketWithWallet;
        } else {
            this.trait_ = ((Giftpacket$RequestSendGiftPacketWithWallet.a) Giftpacket$RequestSendGiftPacketWithWallet.newBuilder((Giftpacket$RequestSendGiftPacketWithWallet) this.trait_).v(giftpacket$RequestSendGiftPacketWithWallet)).j();
        }
        this.traitCase_ = SEND_GIFT_PACKET_WITH_WALLET_FIELD_NUMBER;
    }

    private void mergeSendInlineCallbackData(KetfOuterClass$RequestSendInlineCallBackData ketfOuterClass$RequestSendInlineCallBackData) {
        ketfOuterClass$RequestSendInlineCallBackData.getClass();
        if (this.traitCase_ != 3937 || this.trait_ == KetfOuterClass$RequestSendInlineCallBackData.getDefaultInstance()) {
            this.trait_ = ketfOuterClass$RequestSendInlineCallBackData;
        } else {
            this.trait_ = ((KetfOuterClass$RequestSendInlineCallBackData.a) KetfOuterClass$RequestSendInlineCallBackData.newBuilder((KetfOuterClass$RequestSendInlineCallBackData) this.trait_).v(ketfOuterClass$RequestSendInlineCallBackData)).j();
        }
        this.traitCase_ = SEND_INLINE_CALLBACK_DATA_FIELD_NUMBER;
    }

    private void mergeSendMessage(MessagingOuterClass$RequestSendMessage messagingOuterClass$RequestSendMessage) {
        messagingOuterClass$RequestSendMessage.getClass();
        if (this.traitCase_ != 92 || this.trait_ == MessagingOuterClass$RequestSendMessage.getDefaultInstance()) {
            this.trait_ = messagingOuterClass$RequestSendMessage;
        } else {
            this.trait_ = ((MessagingOuterClass$RequestSendMessage.a) MessagingOuterClass$RequestSendMessage.newBuilder((MessagingOuterClass$RequestSendMessage) this.trait_).v(messagingOuterClass$RequestSendMessage)).j();
        }
        this.traitCase_ = 92;
    }

    private void mergeSendMultiMediaMessage(MessagingOuterClass$RequestSendMultiMediaMessage messagingOuterClass$RequestSendMultiMediaMessage) {
        messagingOuterClass$RequestSendMultiMediaMessage.getClass();
        if (this.traitCase_ != 63662 || this.trait_ == MessagingOuterClass$RequestSendMultiMediaMessage.getDefaultInstance()) {
            this.trait_ = messagingOuterClass$RequestSendMultiMediaMessage;
        } else {
            this.trait_ = ((MessagingOuterClass$RequestSendMultiMediaMessage.a) MessagingOuterClass$RequestSendMultiMediaMessage.newBuilder((MessagingOuterClass$RequestSendMultiMediaMessage) this.trait_).v(messagingOuterClass$RequestSendMultiMediaMessage)).j();
        }
        this.traitCase_ = SEND_MULTI_MEDIA_MESSAGE_FIELD_NUMBER;
    }

    private void mergeSendMyGiftPacket(SentenceOuterClass$RequestSendMyGiftPacket sentenceOuterClass$RequestSendMyGiftPacket) {
        sentenceOuterClass$RequestSendMyGiftPacket.getClass();
        if (this.traitCase_ != 63577 || this.trait_ == SentenceOuterClass$RequestSendMyGiftPacket.getDefaultInstance()) {
            this.trait_ = sentenceOuterClass$RequestSendMyGiftPacket;
        } else {
            this.trait_ = ((SentenceOuterClass$RequestSendMyGiftPacket.a) SentenceOuterClass$RequestSendMyGiftPacket.newBuilder((SentenceOuterClass$RequestSendMyGiftPacket) this.trait_).v(sentenceOuterClass$RequestSendMyGiftPacket)).j();
        }
        this.traitCase_ = SEND_MY_GIFT_PACKET_FIELD_NUMBER;
    }

    private void mergeSendReferral(WarriorOuterClass$RequestSendReferral warriorOuterClass$RequestSendReferral) {
        warriorOuterClass$RequestSendReferral.getClass();
        if (this.traitCase_ != 63603 || this.trait_ == WarriorOuterClass$RequestSendReferral.getDefaultInstance()) {
            this.trait_ = warriorOuterClass$RequestSendReferral;
        } else {
            this.trait_ = ((WarriorOuterClass$RequestSendReferral.a) WarriorOuterClass$RequestSendReferral.newBuilder((WarriorOuterClass$RequestSendReferral) this.trait_).v(warriorOuterClass$RequestSendReferral)).j();
        }
        this.traitCase_ = SEND_REFERRAL_FIELD_NUMBER;
    }

    private void mergeSendSerajEvent(Seraj$RequestSendSerajEvent seraj$RequestSendSerajEvent) {
        seraj$RequestSendSerajEvent.getClass();
        if (this.traitCase_ != 63238 || this.trait_ == Seraj$RequestSendSerajEvent.getDefaultInstance()) {
            this.trait_ = seraj$RequestSendSerajEvent;
        } else {
            this.trait_ = ((Seraj$RequestSendSerajEvent.a) Seraj$RequestSendSerajEvent.newBuilder((Seraj$RequestSendSerajEvent) this.trait_).v(seraj$RequestSendSerajEvent)).j();
        }
        this.traitCase_ = SEND_SERAJ_EVENT_FIELD_NUMBER;
    }

    private void mergeSeqUpdate(UpdateBoxStruct$SeqUpdate updateBoxStruct$SeqUpdate) {
        updateBoxStruct$SeqUpdate.getClass();
        if (this.traitCase_ != 13 || this.trait_ == UpdateBoxStruct$SeqUpdate.getDefaultInstance()) {
            this.trait_ = updateBoxStruct$SeqUpdate;
        } else {
            this.trait_ = ((UpdateBoxStruct$SeqUpdate.a) UpdateBoxStruct$SeqUpdate.newBuilder((UpdateBoxStruct$SeqUpdate) this.trait_).v(updateBoxStruct$SeqUpdate)).j();
        }
        this.traitCase_ = 13;
    }

    private void mergeSeqUpdateTooLong(UpdateBoxStruct$SeqUpdateTooLong updateBoxStruct$SeqUpdateTooLong) {
        updateBoxStruct$SeqUpdateTooLong.getClass();
        if (this.traitCase_ != 25 || this.trait_ == UpdateBoxStruct$SeqUpdateTooLong.getDefaultInstance()) {
            this.trait_ = updateBoxStruct$SeqUpdateTooLong;
        } else {
            this.trait_ = ((UpdateBoxStruct$SeqUpdateTooLong.a) UpdateBoxStruct$SeqUpdateTooLong.newBuilder((UpdateBoxStruct$SeqUpdateTooLong) this.trait_).v(updateBoxStruct$SeqUpdateTooLong)).j();
        }
        this.traitCase_ = 25;
    }

    private void mergeSetCanSeeMessages(GroupsOuterClass$RequestSetCanSeeMessages groupsOuterClass$RequestSetCanSeeMessages) {
        groupsOuterClass$RequestSetCanSeeMessages.getClass();
        if (this.traitCase_ != 724 || this.trait_ == GroupsOuterClass$RequestSetCanSeeMessages.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$RequestSetCanSeeMessages;
        } else {
            this.trait_ = ((GroupsOuterClass$RequestSetCanSeeMessages.a) GroupsOuterClass$RequestSetCanSeeMessages.newBuilder((GroupsOuterClass$RequestSetCanSeeMessages) this.trait_).v(groupsOuterClass$RequestSetCanSeeMessages)).j();
        }
        this.traitCase_ = SET_CAN_SEE_MESSAGES_FIELD_NUMBER;
    }

    private void mergeSetDefaultCard(SapOuterClass$RequestSetDefaultCard sapOuterClass$RequestSetDefaultCard) {
        sapOuterClass$RequestSetDefaultCard.getClass();
        if (this.traitCase_ != 63562 || this.trait_ == SapOuterClass$RequestSetDefaultCard.getDefaultInstance()) {
            this.trait_ = sapOuterClass$RequestSetDefaultCard;
        } else {
            this.trait_ = ((SapOuterClass$RequestSetDefaultCard.a) SapOuterClass$RequestSetDefaultCard.newBuilder((SapOuterClass$RequestSetDefaultCard) this.trait_).v(sapOuterClass$RequestSetDefaultCard)).j();
        }
        this.traitCase_ = SET_DEFAULT_CARD_FIELD_NUMBER;
    }

    private void mergeSetGroupDefaultPermissions(GroupsOuterClass$RequestSetGroupDefaultPermissions groupsOuterClass$RequestSetGroupDefaultPermissions) {
        groupsOuterClass$RequestSetGroupDefaultPermissions.getClass();
        if (this.traitCase_ != 63476 || this.trait_ == GroupsOuterClass$RequestSetGroupDefaultPermissions.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$RequestSetGroupDefaultPermissions;
        } else {
            this.trait_ = ((GroupsOuterClass$RequestSetGroupDefaultPermissions.a) GroupsOuterClass$RequestSetGroupDefaultPermissions.newBuilder((GroupsOuterClass$RequestSetGroupDefaultPermissions) this.trait_).v(groupsOuterClass$RequestSetGroupDefaultPermissions)).j();
        }
        this.traitCase_ = SET_GROUP_DEFAULT_PERMISSIONS_FIELD_NUMBER;
    }

    private void mergeSetMemberPermissions(GroupsOuterClass$RequestSetMemberPermissions groupsOuterClass$RequestSetMemberPermissions) {
        groupsOuterClass$RequestSetMemberPermissions.getClass();
        if (this.traitCase_ != 63455 || this.trait_ == GroupsOuterClass$RequestSetMemberPermissions.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$RequestSetMemberPermissions;
        } else {
            this.trait_ = ((GroupsOuterClass$RequestSetMemberPermissions.a) GroupsOuterClass$RequestSetMemberPermissions.newBuilder((GroupsOuterClass$RequestSetMemberPermissions) this.trait_).v(groupsOuterClass$RequestSetMemberPermissions)).j();
        }
        this.traitCase_ = SET_MEMBER_PERMISSIONS_FIELD_NUMBER;
    }

    private void mergeSetOnline(PresenceOuterClass$RequestSetOnline presenceOuterClass$RequestSetOnline) {
        presenceOuterClass$RequestSetOnline.getClass();
        if (this.traitCase_ != 29 || this.trait_ == PresenceOuterClass$RequestSetOnline.getDefaultInstance()) {
            this.trait_ = presenceOuterClass$RequestSetOnline;
        } else {
            this.trait_ = ((PresenceOuterClass$RequestSetOnline.a) PresenceOuterClass$RequestSetOnline.newBuilder((PresenceOuterClass$RequestSetOnline) this.trait_).v(presenceOuterClass$RequestSetOnline)).j();
        }
        this.traitCase_ = 29;
    }

    private void mergeSetRecentOrder(Saba$RequestSetRecentOrder saba$RequestSetRecentOrder) {
        saba$RequestSetRecentOrder.getClass();
        if (this.traitCase_ != 63506 || this.trait_ == Saba$RequestSetRecentOrder.getDefaultInstance()) {
            this.trait_ = saba$RequestSetRecentOrder;
        } else {
            this.trait_ = ((Saba$RequestSetRecentOrder.a) Saba$RequestSetRecentOrder.newBuilder((Saba$RequestSetRecentOrder) this.trait_).v(saba$RequestSetRecentOrder)).j();
        }
        this.traitCase_ = SET_RECENT_ORDER_FIELD_NUMBER;
    }

    private void mergeSetRestriction(GroupsOuterClass$RequestSetRestriction groupsOuterClass$RequestSetRestriction) {
        groupsOuterClass$RequestSetRestriction.getClass();
        if (this.traitCase_ != 728 || this.trait_ == GroupsOuterClass$RequestSetRestriction.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$RequestSetRestriction;
        } else {
            this.trait_ = ((GroupsOuterClass$RequestSetRestriction.a) GroupsOuterClass$RequestSetRestriction.newBuilder((GroupsOuterClass$RequestSetRestriction) this.trait_).v(groupsOuterClass$RequestSetRestriction)).j();
        }
        this.traitCase_ = SET_RESTRICTION_FIELD_NUMBER;
    }

    private void mergeSignOut(AuthOuterClass$RequestSignOut authOuterClass$RequestSignOut) {
        authOuterClass$RequestSignOut.getClass();
        if (this.traitCase_ != 84 || this.trait_ == AuthOuterClass$RequestSignOut.getDefaultInstance()) {
            this.trait_ = authOuterClass$RequestSignOut;
        } else {
            this.trait_ = ((AuthOuterClass$RequestSignOut.a) AuthOuterClass$RequestSignOut.newBuilder((AuthOuterClass$RequestSignOut) this.trait_).v(authOuterClass$RequestSignOut)).j();
        }
        this.traitCase_ = 84;
    }

    private void mergeSignSefte(SefteOuterClass$RequestSignSefte sefteOuterClass$RequestSignSefte) {
        sefteOuterClass$RequestSignSefte.getClass();
        if (this.traitCase_ != 63612 || this.trait_ == SefteOuterClass$RequestSignSefte.getDefaultInstance()) {
            this.trait_ = sefteOuterClass$RequestSignSefte;
        } else {
            this.trait_ = ((SefteOuterClass$RequestSignSefte.a) SefteOuterClass$RequestSignSefte.newBuilder((SefteOuterClass$RequestSignSefte) this.trait_).v(sefteOuterClass$RequestSignSefte)).j();
        }
        this.traitCase_ = SIGN_SEFTE_FIELD_NUMBER;
    }

    private void mergeSignUp(AuthOuterClass$RequestSignUp authOuterClass$RequestSignUp) {
        authOuterClass$RequestSignUp.getClass();
        if (this.traitCase_ != 190 || this.trait_ == AuthOuterClass$RequestSignUp.getDefaultInstance()) {
            this.trait_ = authOuterClass$RequestSignUp;
        } else {
            this.trait_ = ((AuthOuterClass$RequestSignUp.a) AuthOuterClass$RequestSignUp.newBuilder((AuthOuterClass$RequestSignUp) this.trait_).v(authOuterClass$RequestSignUp)).j();
        }
        this.traitCase_ = SIGN_UP_FIELD_NUMBER;
    }

    private void mergeSpinWheel(ClubOuterClass$RequestSpinWheel clubOuterClass$RequestSpinWheel) {
        clubOuterClass$RequestSpinWheel.getClass();
        if (this.traitCase_ != 63470 || this.trait_ == ClubOuterClass$RequestSpinWheel.getDefaultInstance()) {
            this.trait_ = clubOuterClass$RequestSpinWheel;
        } else {
            this.trait_ = ((ClubOuterClass$RequestSpinWheel.a) ClubOuterClass$RequestSpinWheel.newBuilder((ClubOuterClass$RequestSpinWheel) this.trait_).v(clubOuterClass$RequestSpinWheel)).j();
        }
        this.traitCase_ = SPIN_WHEEL_FIELD_NUMBER;
    }

    private void mergeSplitTransaction(PfmOuterClass$RequestSplitTransaction pfmOuterClass$RequestSplitTransaction) {
        pfmOuterClass$RequestSplitTransaction.getClass();
        if (this.traitCase_ != 63647 || this.trait_ == PfmOuterClass$RequestSplitTransaction.getDefaultInstance()) {
            this.trait_ = pfmOuterClass$RequestSplitTransaction;
        } else {
            this.trait_ = ((PfmOuterClass$RequestSplitTransaction.a) PfmOuterClass$RequestSplitTransaction.newBuilder((PfmOuterClass$RequestSplitTransaction) this.trait_).v(pfmOuterClass$RequestSplitTransaction)).j();
        }
        this.traitCase_ = SPLIT_TRANSACTION_FIELD_NUMBER;
    }

    private void mergeStartCall(MeetOuterClass$RequestStartCall meetOuterClass$RequestStartCall) {
        meetOuterClass$RequestStartCall.getClass();
        if (this.traitCase_ != 63578 || this.trait_ == MeetOuterClass$RequestStartCall.getDefaultInstance()) {
            this.trait_ = meetOuterClass$RequestStartCall;
        } else {
            this.trait_ = ((MeetOuterClass$RequestStartCall.a) MeetOuterClass$RequestStartCall.newBuilder((MeetOuterClass$RequestStartCall) this.trait_).v(meetOuterClass$RequestStartCall)).j();
        }
        this.traitCase_ = START_CALL_FIELD_NUMBER;
    }

    private void mergeStartPhoneAuth(AuthOuterClass$RequestStartPhoneAuth authOuterClass$RequestStartPhoneAuth) {
        authOuterClass$RequestStartPhoneAuth.getClass();
        if (this.traitCase_ != 191 || this.trait_ == AuthOuterClass$RequestStartPhoneAuth.getDefaultInstance()) {
            this.trait_ = authOuterClass$RequestStartPhoneAuth;
        } else {
            this.trait_ = ((AuthOuterClass$RequestStartPhoneAuth.b) AuthOuterClass$RequestStartPhoneAuth.newBuilder((AuthOuterClass$RequestStartPhoneAuth) this.trait_).v(authOuterClass$RequestStartPhoneAuth)).j();
        }
        this.traitCase_ = START_PHONE_AUTH_FIELD_NUMBER;
    }

    private void mergeStopTyping(PresenceOuterClass$RequestStopTyping presenceOuterClass$RequestStopTyping) {
        presenceOuterClass$RequestStopTyping.getClass();
        if (this.traitCase_ != 30 || this.trait_ == PresenceOuterClass$RequestStopTyping.getDefaultInstance()) {
            this.trait_ = presenceOuterClass$RequestStopTyping;
        } else {
            this.trait_ = ((PresenceOuterClass$RequestStopTyping.a) PresenceOuterClass$RequestStopTyping.newBuilder((PresenceOuterClass$RequestStopTyping) this.trait_).v(presenceOuterClass$RequestStopTyping)).j();
        }
        this.traitCase_ = 30;
    }

    private void mergeSubmitDialogAdOrder(AdvertisementOuterClass$RequestSubmitDialogAdOrder advertisementOuterClass$RequestSubmitDialogAdOrder) {
        advertisementOuterClass$RequestSubmitDialogAdOrder.getClass();
        if (this.traitCase_ != 63567 || this.trait_ == AdvertisementOuterClass$RequestSubmitDialogAdOrder.getDefaultInstance()) {
            this.trait_ = advertisementOuterClass$RequestSubmitDialogAdOrder;
        } else {
            this.trait_ = ((AdvertisementOuterClass$RequestSubmitDialogAdOrder.a) AdvertisementOuterClass$RequestSubmitDialogAdOrder.newBuilder((AdvertisementOuterClass$RequestSubmitDialogAdOrder) this.trait_).v(advertisementOuterClass$RequestSubmitDialogAdOrder)).j();
        }
        this.traitCase_ = SUBMIT_DIALOG_AD_ORDER_FIELD_NUMBER;
    }

    private void mergeSubscribeFromGroupOnline(PresenceOuterClass$RequestSubscribeFromGroupOnline presenceOuterClass$RequestSubscribeFromGroupOnline) {
        presenceOuterClass$RequestSubscribeFromGroupOnline.getClass();
        if (this.traitCase_ != 75 || this.trait_ == PresenceOuterClass$RequestSubscribeFromGroupOnline.getDefaultInstance()) {
            this.trait_ = presenceOuterClass$RequestSubscribeFromGroupOnline;
        } else {
            this.trait_ = ((PresenceOuterClass$RequestSubscribeFromGroupOnline.a) PresenceOuterClass$RequestSubscribeFromGroupOnline.newBuilder((PresenceOuterClass$RequestSubscribeFromGroupOnline) this.trait_).v(presenceOuterClass$RequestSubscribeFromGroupOnline)).j();
        }
        this.traitCase_ = 75;
    }

    private void mergeSubscribeFromOnline(PresenceOuterClass$RequestSubscribeFromOnline presenceOuterClass$RequestSubscribeFromOnline) {
        presenceOuterClass$RequestSubscribeFromOnline.getClass();
        if (this.traitCase_ != 33 || this.trait_ == PresenceOuterClass$RequestSubscribeFromOnline.getDefaultInstance()) {
            this.trait_ = presenceOuterClass$RequestSubscribeFromOnline;
        } else {
            this.trait_ = ((PresenceOuterClass$RequestSubscribeFromOnline.a) PresenceOuterClass$RequestSubscribeFromOnline.newBuilder((PresenceOuterClass$RequestSubscribeFromOnline) this.trait_).v(presenceOuterClass$RequestSubscribeFromOnline)).j();
        }
        this.traitCase_ = 33;
    }

    private void mergeSubscribeToGroupOnline(PresenceOuterClass$RequestSubscribeToGroupOnline presenceOuterClass$RequestSubscribeToGroupOnline) {
        presenceOuterClass$RequestSubscribeToGroupOnline.getClass();
        if (this.traitCase_ != 74 || this.trait_ == PresenceOuterClass$RequestSubscribeToGroupOnline.getDefaultInstance()) {
            this.trait_ = presenceOuterClass$RequestSubscribeToGroupOnline;
        } else {
            this.trait_ = ((PresenceOuterClass$RequestSubscribeToGroupOnline.a) PresenceOuterClass$RequestSubscribeToGroupOnline.newBuilder((PresenceOuterClass$RequestSubscribeToGroupOnline) this.trait_).v(presenceOuterClass$RequestSubscribeToGroupOnline)).j();
        }
        this.traitCase_ = 74;
    }

    private void mergeSubscribeToOnline(PresenceOuterClass$RequestSubscribeToOnline presenceOuterClass$RequestSubscribeToOnline) {
        presenceOuterClass$RequestSubscribeToOnline.getClass();
        if (this.traitCase_ != 32 || this.trait_ == PresenceOuterClass$RequestSubscribeToOnline.getDefaultInstance()) {
            this.trait_ = presenceOuterClass$RequestSubscribeToOnline;
        } else {
            this.trait_ = ((PresenceOuterClass$RequestSubscribeToOnline.a) PresenceOuterClass$RequestSubscribeToOnline.newBuilder((PresenceOuterClass$RequestSubscribeToOnline) this.trait_).v(presenceOuterClass$RequestSubscribeToOnline)).j();
        }
        this.traitCase_ = 32;
    }

    private void mergeTerminateAllSessions(AuthOuterClass$RequestTerminateAllSessions authOuterClass$RequestTerminateAllSessions) {
        authOuterClass$RequestTerminateAllSessions.getClass();
        if (this.traitCase_ != 83 || this.trait_ == AuthOuterClass$RequestTerminateAllSessions.getDefaultInstance()) {
            this.trait_ = authOuterClass$RequestTerminateAllSessions;
        } else {
            this.trait_ = ((AuthOuterClass$RequestTerminateAllSessions.a) AuthOuterClass$RequestTerminateAllSessions.newBuilder((AuthOuterClass$RequestTerminateAllSessions) this.trait_).v(authOuterClass$RequestTerminateAllSessions)).j();
        }
        this.traitCase_ = 83;
    }

    private void mergeTerminateSession(AuthOuterClass$RequestTerminateSession authOuterClass$RequestTerminateSession) {
        authOuterClass$RequestTerminateSession.getClass();
        if (this.traitCase_ != 82 || this.trait_ == AuthOuterClass$RequestTerminateSession.getDefaultInstance()) {
            this.trait_ = authOuterClass$RequestTerminateSession;
        } else {
            this.trait_ = ((AuthOuterClass$RequestTerminateSession.a) AuthOuterClass$RequestTerminateSession.newBuilder((AuthOuterClass$RequestTerminateSession) this.trait_).v(authOuterClass$RequestTerminateSession)).j();
        }
        this.traitCase_ = 82;
    }

    private void mergeTransactionPoint(KifpoolOuterClass$RequestTransactionPoint kifpoolOuterClass$RequestTransactionPoint) {
        kifpoolOuterClass$RequestTransactionPoint.getClass();
        if (this.traitCase_ != 63462 || this.trait_ == KifpoolOuterClass$RequestTransactionPoint.getDefaultInstance()) {
            this.trait_ = kifpoolOuterClass$RequestTransactionPoint;
        } else {
            this.trait_ = ((KifpoolOuterClass$RequestTransactionPoint.a) KifpoolOuterClass$RequestTransactionPoint.newBuilder((KifpoolOuterClass$RequestTransactionPoint) this.trait_).v(kifpoolOuterClass$RequestTransactionPoint)).j();
        }
        this.traitCase_ = TRANSACTION_POINT_FIELD_NUMBER;
    }

    private void mergeTransferMoney(KifpoolOuterClass$RequestTransferMoney kifpoolOuterClass$RequestTransferMoney) {
        kifpoolOuterClass$RequestTransferMoney.getClass();
        if (this.traitCase_ != 63411 || this.trait_ == KifpoolOuterClass$RequestTransferMoney.getDefaultInstance()) {
            this.trait_ = kifpoolOuterClass$RequestTransferMoney;
        } else {
            this.trait_ = ((KifpoolOuterClass$RequestTransferMoney.a) KifpoolOuterClass$RequestTransferMoney.newBuilder((KifpoolOuterClass$RequestTransferMoney) this.trait_).v(kifpoolOuterClass$RequestTransferMoney)).j();
        }
        this.traitCase_ = TRANSFER_MONEY_FIELD_NUMBER;
    }

    private void mergeTransferMoneyByCard(SapOuterClass$RequestTransferMoneyByCard sapOuterClass$RequestTransferMoneyByCard) {
        sapOuterClass$RequestTransferMoneyByCard.getClass();
        if (this.traitCase_ != 63495 || this.trait_ == SapOuterClass$RequestTransferMoneyByCard.getDefaultInstance()) {
            this.trait_ = sapOuterClass$RequestTransferMoneyByCard;
        } else {
            this.trait_ = ((SapOuterClass$RequestTransferMoneyByCard.a) SapOuterClass$RequestTransferMoneyByCard.newBuilder((SapOuterClass$RequestTransferMoneyByCard) this.trait_).v(sapOuterClass$RequestTransferMoneyByCard)).j();
        }
        this.traitCase_ = TRANSFER_MONEY_BY_CARD_FIELD_NUMBER;
    }

    private void mergeTransferOwnership(GroupsOuterClass$RequestTransferOwnership groupsOuterClass$RequestTransferOwnership) {
        groupsOuterClass$RequestTransferOwnership.getClass();
        if (this.traitCase_ != 2789 || this.trait_ == GroupsOuterClass$RequestTransferOwnership.getDefaultInstance()) {
            this.trait_ = groupsOuterClass$RequestTransferOwnership;
        } else {
            this.trait_ = ((GroupsOuterClass$RequestTransferOwnership.a) GroupsOuterClass$RequestTransferOwnership.newBuilder((GroupsOuterClass$RequestTransferOwnership) this.trait_).v(groupsOuterClass$RequestTransferOwnership)).j();
        }
        this.traitCase_ = TRANSFER_OWNERSHIP_FIELD_NUMBER;
    }

    private void mergeTyping(PresenceOuterClass$RequestTyping presenceOuterClass$RequestTyping) {
        presenceOuterClass$RequestTyping.getClass();
        if (this.traitCase_ != 27 || this.trait_ == PresenceOuterClass$RequestTyping.getDefaultInstance()) {
            this.trait_ = presenceOuterClass$RequestTyping;
        } else {
            this.trait_ = ((PresenceOuterClass$RequestTyping.a) PresenceOuterClass$RequestTyping.newBuilder((PresenceOuterClass$RequestTyping) this.trait_).v(presenceOuterClass$RequestTyping)).j();
        }
        this.traitCase_ = 27;
    }

    private void mergeUnbindAllMoneyRequestDetails(ReactionsOuterClass$RequestUnbindAllMoneyRequestDetails reactionsOuterClass$RequestUnbindAllMoneyRequestDetails) {
        reactionsOuterClass$RequestUnbindAllMoneyRequestDetails.getClass();
        if (this.traitCase_ != 62411 || this.trait_ == ReactionsOuterClass$RequestUnbindAllMoneyRequestDetails.getDefaultInstance()) {
            this.trait_ = reactionsOuterClass$RequestUnbindAllMoneyRequestDetails;
        } else {
            this.trait_ = ((ReactionsOuterClass$RequestUnbindAllMoneyRequestDetails.a) ReactionsOuterClass$RequestUnbindAllMoneyRequestDetails.newBuilder((ReactionsOuterClass$RequestUnbindAllMoneyRequestDetails) this.trait_).v(reactionsOuterClass$RequestUnbindAllMoneyRequestDetails)).j();
        }
        this.traitCase_ = UNBIND_ALL_MONEY_REQUEST_DETAILS_FIELD_NUMBER;
    }

    private void mergeUnblockUser(UsersOuterClass$RequestUnblockUser usersOuterClass$RequestUnblockUser) {
        usersOuterClass$RequestUnblockUser.getClass();
        if (this.traitCase_ != 2637 || this.trait_ == UsersOuterClass$RequestUnblockUser.getDefaultInstance()) {
            this.trait_ = usersOuterClass$RequestUnblockUser;
        } else {
            this.trait_ = ((UsersOuterClass$RequestUnblockUser.a) UsersOuterClass$RequestUnblockUser.newBuilder((UsersOuterClass$RequestUnblockUser) this.trait_).v(usersOuterClass$RequestUnblockUser)).j();
        }
        this.traitCase_ = UNBLOCK_USER_FIELD_NUMBER;
    }

    private void mergeUnregisterAllPushCredentials(PushOuterClass$RequestUnregisterAllPushCredentials pushOuterClass$RequestUnregisterAllPushCredentials) {
        pushOuterClass$RequestUnregisterAllPushCredentials.getClass();
        if (this.traitCase_ != 63251 || this.trait_ == PushOuterClass$RequestUnregisterAllPushCredentials.getDefaultInstance()) {
            this.trait_ = pushOuterClass$RequestUnregisterAllPushCredentials;
        } else {
            this.trait_ = ((PushOuterClass$RequestUnregisterAllPushCredentials.a) PushOuterClass$RequestUnregisterAllPushCredentials.newBuilder((PushOuterClass$RequestUnregisterAllPushCredentials) this.trait_).v(pushOuterClass$RequestUnregisterAllPushCredentials)).j();
        }
        this.traitCase_ = UNREGISTER_ALL_PUSH_CREDENTIALS_FIELD_NUMBER;
    }

    private void mergeUnregisterGooglePush(PushOuterClass$RequestUnregisterGooglePush pushOuterClass$RequestUnregisterGooglePush) {
        pushOuterClass$RequestUnregisterGooglePush.getClass();
        if (this.traitCase_ != 2631 || this.trait_ == PushOuterClass$RequestUnregisterGooglePush.getDefaultInstance()) {
            this.trait_ = pushOuterClass$RequestUnregisterGooglePush;
        } else {
            this.trait_ = ((PushOuterClass$RequestUnregisterGooglePush.a) PushOuterClass$RequestUnregisterGooglePush.newBuilder((PushOuterClass$RequestUnregisterGooglePush) this.trait_).v(pushOuterClass$RequestUnregisterGooglePush)).j();
        }
        this.traitCase_ = UNREGISTER_GOOGLE_PUSH_FIELD_NUMBER;
    }

    private void mergeUpdateClick(AdvertisementOuterClass$RequestUpdateClick advertisementOuterClass$RequestUpdateClick) {
        advertisementOuterClass$RequestUpdateClick.getClass();
        if (this.traitCase_ != 63622 || this.trait_ == AdvertisementOuterClass$RequestUpdateClick.getDefaultInstance()) {
            this.trait_ = advertisementOuterClass$RequestUpdateClick;
        } else {
            this.trait_ = ((AdvertisementOuterClass$RequestUpdateClick.a) AdvertisementOuterClass$RequestUpdateClick.newBuilder((AdvertisementOuterClass$RequestUpdateClick) this.trait_).v(advertisementOuterClass$RequestUpdateClick)).j();
        }
        this.traitCase_ = UPDATE_CLICK_FIELD_NUMBER;
    }

    private void mergeUpdateGroupStatus(AdvertisementOuterClass$RequestUpdateGroupStatus advertisementOuterClass$RequestUpdateGroupStatus) {
        advertisementOuterClass$RequestUpdateGroupStatus.getClass();
        if (this.traitCase_ != 63439 || this.trait_ == AdvertisementOuterClass$RequestUpdateGroupStatus.getDefaultInstance()) {
            this.trait_ = advertisementOuterClass$RequestUpdateGroupStatus;
        } else {
            this.trait_ = ((AdvertisementOuterClass$RequestUpdateGroupStatus.a) AdvertisementOuterClass$RequestUpdateGroupStatus.newBuilder((AdvertisementOuterClass$RequestUpdateGroupStatus) this.trait_).v(advertisementOuterClass$RequestUpdateGroupStatus)).j();
        }
        this.traitCase_ = UPDATE_GROUP_STATUS_FIELD_NUMBER;
    }

    private void mergeUpdateMessage(MessagingOuterClass$RequestUpdateMessage messagingOuterClass$RequestUpdateMessage) {
        messagingOuterClass$RequestUpdateMessage.getClass();
        if (this.traitCase_ != 2658 || this.trait_ == MessagingOuterClass$RequestUpdateMessage.getDefaultInstance()) {
            this.trait_ = messagingOuterClass$RequestUpdateMessage;
        } else {
            this.trait_ = ((MessagingOuterClass$RequestUpdateMessage.a) MessagingOuterClass$RequestUpdateMessage.newBuilder((MessagingOuterClass$RequestUpdateMessage) this.trait_).v(messagingOuterClass$RequestUpdateMessage)).j();
        }
        this.traitCase_ = UPDATE_MESSAGE_FIELD_NUMBER;
    }

    private void mergeUpdateView(AdvertisementOuterClass$RequestUpdateView advertisementOuterClass$RequestUpdateView) {
        advertisementOuterClass$RequestUpdateView.getClass();
        if (this.traitCase_ != 63560 || this.trait_ == AdvertisementOuterClass$RequestUpdateView.getDefaultInstance()) {
            this.trait_ = advertisementOuterClass$RequestUpdateView;
        } else {
            this.trait_ = ((AdvertisementOuterClass$RequestUpdateView.a) AdvertisementOuterClass$RequestUpdateView.newBuilder((AdvertisementOuterClass$RequestUpdateView) this.trait_).v(advertisementOuterClass$RequestUpdateView)).j();
        }
        this.traitCase_ = UPDATE_VIEW_FIELD_NUMBER;
    }

    private void mergeUpgradeKifpool(KifpoolOuterClass$RequestUpgradeKifpool kifpoolOuterClass$RequestUpgradeKifpool) {
        kifpoolOuterClass$RequestUpgradeKifpool.getClass();
        if (this.traitCase_ != 63402 || this.trait_ == KifpoolOuterClass$RequestUpgradeKifpool.getDefaultInstance()) {
            this.trait_ = kifpoolOuterClass$RequestUpgradeKifpool;
        } else {
            this.trait_ = ((KifpoolOuterClass$RequestUpgradeKifpool.a) KifpoolOuterClass$RequestUpgradeKifpool.newBuilder((KifpoolOuterClass$RequestUpgradeKifpool) this.trait_).v(kifpoolOuterClass$RequestUpgradeKifpool)).j();
        }
        this.traitCase_ = UPGRADE_KIFPOOL_FIELD_NUMBER;
    }

    private void mergeUserHasCred(SefteOuterClass$RequestUserHasCred sefteOuterClass$RequestUserHasCred) {
        sefteOuterClass$RequestUserHasCred.getClass();
        if (this.traitCase_ != 63624 || this.trait_ == SefteOuterClass$RequestUserHasCred.getDefaultInstance()) {
            this.trait_ = sefteOuterClass$RequestUserHasCred;
        } else {
            this.trait_ = ((SefteOuterClass$RequestUserHasCred.a) SefteOuterClass$RequestUserHasCred.newBuilder((SefteOuterClass$RequestUserHasCred) this.trait_).v(sefteOuterClass$RequestUserHasCred)).j();
        }
        this.traitCase_ = USER_HAS_CRED_FIELD_NUMBER;
    }

    private void mergeValidateCode(AuthOuterClass$RequestValidateCode authOuterClass$RequestValidateCode) {
        authOuterClass$RequestValidateCode.getClass();
        if (this.traitCase_ != 189 || this.trait_ == AuthOuterClass$RequestValidateCode.getDefaultInstance()) {
            this.trait_ = authOuterClass$RequestValidateCode;
        } else {
            this.trait_ = ((AuthOuterClass$RequestValidateCode.a) AuthOuterClass$RequestValidateCode.newBuilder((AuthOuterClass$RequestValidateCode) this.trait_).v(authOuterClass$RequestValidateCode)).j();
        }
        this.traitCase_ = VALIDATE_CODE_FIELD_NUMBER;
    }

    private void mergeValidateMySentence(SentenceOuterClass$RequestValidateMySentence sentenceOuterClass$RequestValidateMySentence) {
        sentenceOuterClass$RequestValidateMySentence.getClass();
        if (this.traitCase_ != 63575 || this.trait_ == SentenceOuterClass$RequestValidateMySentence.getDefaultInstance()) {
            this.trait_ = sentenceOuterClass$RequestValidateMySentence;
        } else {
            this.trait_ = ((SentenceOuterClass$RequestValidateMySentence.a) SentenceOuterClass$RequestValidateMySentence.newBuilder((SentenceOuterClass$RequestValidateMySentence) this.trait_).v(sentenceOuterClass$RequestValidateMySentence)).j();
        }
        this.traitCase_ = VALIDATE_MY_SENTENCE_FIELD_NUMBER;
    }

    private void mergeVerifyCashOut(WalletOuterClass$RequestVerifyCashOut walletOuterClass$RequestVerifyCashOut) {
        walletOuterClass$RequestVerifyCashOut.getClass();
        if (this.traitCase_ != 62762 || this.trait_ == WalletOuterClass$RequestVerifyCashOut.getDefaultInstance()) {
            this.trait_ = walletOuterClass$RequestVerifyCashOut;
        } else {
            this.trait_ = ((WalletOuterClass$RequestVerifyCashOut.a) WalletOuterClass$RequestVerifyCashOut.newBuilder((WalletOuterClass$RequestVerifyCashOut) this.trait_).v(walletOuterClass$RequestVerifyCashOut)).j();
        }
        this.traitCase_ = VERIFY_CASH_OUT_FIELD_NUMBER;
    }

    private void mergeVerifyCashOutKifpool(KifpoolOuterClass$RequestVerifyCashOutKifpool kifpoolOuterClass$RequestVerifyCashOutKifpool) {
        kifpoolOuterClass$RequestVerifyCashOutKifpool.getClass();
        if (this.traitCase_ != 63432 || this.trait_ == KifpoolOuterClass$RequestVerifyCashOutKifpool.getDefaultInstance()) {
            this.trait_ = kifpoolOuterClass$RequestVerifyCashOutKifpool;
        } else {
            this.trait_ = ((KifpoolOuterClass$RequestVerifyCashOutKifpool.a) KifpoolOuterClass$RequestVerifyCashOutKifpool.newBuilder((KifpoolOuterClass$RequestVerifyCashOutKifpool) this.trait_).v(kifpoolOuterClass$RequestVerifyCashOutKifpool)).j();
        }
        this.traitCase_ = VERIFY_CASH_OUT_KIFPOOL_FIELD_NUMBER;
    }

    private void mergeVerifyPeer(WalletOuterClass$RequestVerifyPeer walletOuterClass$RequestVerifyPeer) {
        walletOuterClass$RequestVerifyPeer.getClass();
        if (this.traitCase_ != 62756 || this.trait_ == WalletOuterClass$RequestVerifyPeer.getDefaultInstance()) {
            this.trait_ = walletOuterClass$RequestVerifyPeer;
        } else {
            this.trait_ = ((WalletOuterClass$RequestVerifyPeer.a) WalletOuterClass$RequestVerifyPeer.newBuilder((WalletOuterClass$RequestVerifyPeer) this.trait_).v(walletOuterClass$RequestVerifyPeer)).j();
        }
        this.traitCase_ = VERIFY_PEER_FIELD_NUMBER;
    }

    private void mergeVerifyPurchaseMessage(KifpoolOuterClass$RequestVerifyPurchaseMessage kifpoolOuterClass$RequestVerifyPurchaseMessage) {
        kifpoolOuterClass$RequestVerifyPurchaseMessage.getClass();
        if (this.traitCase_ != 63430 || this.trait_ == KifpoolOuterClass$RequestVerifyPurchaseMessage.getDefaultInstance()) {
            this.trait_ = kifpoolOuterClass$RequestVerifyPurchaseMessage;
        } else {
            this.trait_ = ((KifpoolOuterClass$RequestVerifyPurchaseMessage.a) KifpoolOuterClass$RequestVerifyPurchaseMessage.newBuilder((KifpoolOuterClass$RequestVerifyPurchaseMessage) this.trait_).v(kifpoolOuterClass$RequestVerifyPurchaseMessage)).j();
        }
        this.traitCase_ = VERIFY_PURCHASE_MESSAGE_FIELD_NUMBER;
    }

    private void mergeVerifyQrcode(WalletOuterClass$RequestVerifyQRCode walletOuterClass$RequestVerifyQRCode) {
        walletOuterClass$RequestVerifyQRCode.getClass();
        if (this.traitCase_ != 62749 || this.trait_ == WalletOuterClass$RequestVerifyQRCode.getDefaultInstance()) {
            this.trait_ = walletOuterClass$RequestVerifyQRCode;
        } else {
            this.trait_ = ((WalletOuterClass$RequestVerifyQRCode.a) WalletOuterClass$RequestVerifyQRCode.newBuilder((WalletOuterClass$RequestVerifyQRCode) this.trait_).v(walletOuterClass$RequestVerifyQRCode)).j();
        }
        this.traitCase_ = VERIFY_QRCODE_FIELD_NUMBER;
    }

    private void mergeWeakFatUpdate(UpdateBoxStruct$WeakFatUpdate updateBoxStruct$WeakFatUpdate) {
        updateBoxStruct$WeakFatUpdate.getClass();
        if (this.traitCase_ != 2673 || this.trait_ == UpdateBoxStruct$WeakFatUpdate.getDefaultInstance()) {
            this.trait_ = updateBoxStruct$WeakFatUpdate;
        } else {
            this.trait_ = ((UpdateBoxStruct$WeakFatUpdate.a) UpdateBoxStruct$WeakFatUpdate.newBuilder((UpdateBoxStruct$WeakFatUpdate) this.trait_).v(updateBoxStruct$WeakFatUpdate)).j();
        }
        this.traitCase_ = WEAK_FAT_UPDATE_FIELD_NUMBER;
    }

    private void mergeWeakUpdate(UpdateBoxStruct$WeakUpdate updateBoxStruct$WeakUpdate) {
        updateBoxStruct$WeakUpdate.getClass();
        if (this.traitCase_ != 26 || this.trait_ == UpdateBoxStruct$WeakUpdate.getDefaultInstance()) {
            this.trait_ = updateBoxStruct$WeakUpdate;
        } else {
            this.trait_ = ((UpdateBoxStruct$WeakUpdate.a) UpdateBoxStruct$WeakUpdate.newBuilder((UpdateBoxStruct$WeakUpdate) this.trait_).v(updateBoxStruct$WeakUpdate)).j();
        }
        this.traitCase_ = 26;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SetRpcStruct$ComposedRpc parseDelimitedFrom(InputStream inputStream) {
        return (SetRpcStruct$ComposedRpc) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SetRpcStruct$ComposedRpc parseFrom(ByteBuffer byteBuffer) {
        return (SetRpcStruct$ComposedRpc) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAcceptCall(MeetOuterClass$RequestAcceptCall meetOuterClass$RequestAcceptCall) {
        meetOuterClass$RequestAcceptCall.getClass();
        this.trait_ = meetOuterClass$RequestAcceptCall;
        this.traitCase_ = ACCEPT_CALL_FIELD_NUMBER;
    }

    private void setAcceptReferralInvite(WarriorOuterClass$RequestAcceptReferralInvite warriorOuterClass$RequestAcceptReferralInvite) {
        warriorOuterClass$RequestAcceptReferralInvite.getClass();
        this.trait_ = warriorOuterClass$RequestAcceptReferralInvite;
        this.traitCase_ = ACCEPT_REFERRAL_INVITE_FIELD_NUMBER;
    }

    private void setActivateWallet(WalletOuterClass$RequestActivateWallet walletOuterClass$RequestActivateWallet) {
        walletOuterClass$RequestActivateWallet.getClass();
        this.trait_ = walletOuterClass$RequestActivateWallet;
        this.traitCase_ = ACTIVATE_WALLET_FIELD_NUMBER;
    }

    private void setAddCard(UsersOuterClass$RequestAddCard usersOuterClass$RequestAddCard) {
        usersOuterClass$RequestAddCard.getClass();
        this.trait_ = usersOuterClass$RequestAddCard;
        this.traitCase_ = 136;
    }

    private void setAddContact(UsersOuterClass$RequestAddContact usersOuterClass$RequestAddContact) {
        usersOuterClass$RequestAddContact.getClass();
        this.trait_ = usersOuterClass$RequestAddContact;
        this.traitCase_ = 114;
    }

    private void setAddDestinationCards(SapOuterClass$RequestAddDestinationCards sapOuterClass$RequestAddDestinationCards) {
        sapOuterClass$RequestAddDestinationCards.getClass();
        this.trait_ = sapOuterClass$RequestAddDestinationCards;
        this.traitCase_ = ADD_DESTINATION_CARDS_FIELD_NUMBER;
    }

    private void setAddDetailToTransaction(PfmOuterClass$RequestAddDetailToTransaction pfmOuterClass$RequestAddDetailToTransaction) {
        pfmOuterClass$RequestAddDetailToTransaction.getClass();
        this.trait_ = pfmOuterClass$RequestAddDetailToTransaction;
        this.traitCase_ = ADD_DETAIL_TO_TRANSACTION_FIELD_NUMBER;
    }

    private void setAddGif(ImagesOuterClass$RequestAddGif imagesOuterClass$RequestAddGif) {
        imagesOuterClass$RequestAddGif.getClass();
        this.trait_ = imagesOuterClass$RequestAddGif;
        this.traitCase_ = ADD_GIF_FIELD_NUMBER;
    }

    private void setAddNewCards(SapOuterClass$RequestAddNewCards sapOuterClass$RequestAddNewCards) {
        sapOuterClass$RequestAddNewCards.getClass();
        this.trait_ = sapOuterClass$RequestAddNewCards;
        this.traitCase_ = ADD_NEW_CARDS_FIELD_NUMBER;
    }

    private void setAddRecipient(SefteOuterClass$RequestAddRecipient sefteOuterClass$RequestAddRecipient) {
        sefteOuterClass$RequestAddRecipient.getClass();
        this.trait_ = sefteOuterClass$RequestAddRecipient;
        this.traitCase_ = ADD_RECIPIENT_FIELD_NUMBER;
    }

    private void setAddStickerCollection(ImagesOuterClass$RequestAddStickerCollection imagesOuterClass$RequestAddStickerCollection) {
        imagesOuterClass$RequestAddStickerCollection.getClass();
        this.trait_ = imagesOuterClass$RequestAddStickerCollection;
        this.traitCase_ = ADD_STICKER_COLLECTION_FIELD_NUMBER;
    }

    private void setAddTransactionTags(PfmOuterClass$RequestAddTransactionTags pfmOuterClass$RequestAddTransactionTags) {
        pfmOuterClass$RequestAddTransactionTags.getClass();
        this.trait_ = pfmOuterClass$RequestAddTransactionTags;
        this.traitCase_ = ADD_TRANSACTION_TAGS_FIELD_NUMBER;
    }

    private void setAddUserTags(PfmOuterClass$RequestAddUserTags pfmOuterClass$RequestAddUserTags) {
        pfmOuterClass$RequestAddUserTags.getClass();
        this.trait_ = pfmOuterClass$RequestAddUserTags;
        this.traitCase_ = ADD_USER_TAGS_FIELD_NUMBER;
    }

    private void setAuthorizeUser(SefteOuterClass$RequestAuthorizeUser sefteOuterClass$RequestAuthorizeUser) {
        sefteOuterClass$RequestAuthorizeUser.getClass();
        this.trait_ = sefteOuterClass$RequestAuthorizeUser;
        this.traitCase_ = AUTHORIZE_USER_FIELD_NUMBER;
    }

    private void setBindMoneyRequestDetails(ReactionsOuterClass$RequestBindMoneyRequestDetails reactionsOuterClass$RequestBindMoneyRequestDetails) {
        reactionsOuterClass$RequestBindMoneyRequestDetails.getClass();
        this.trait_ = reactionsOuterClass$RequestBindMoneyRequestDetails;
        this.traitCase_ = BIND_MONEY_REQUEST_DETAILS_FIELD_NUMBER;
    }

    private void setBindMoneyRequestDetailsList(ReactionsOuterClass$RequestBindMoneyRequestDetailsList reactionsOuterClass$RequestBindMoneyRequestDetailsList) {
        reactionsOuterClass$RequestBindMoneyRequestDetailsList.getClass();
        this.trait_ = reactionsOuterClass$RequestBindMoneyRequestDetailsList;
        this.traitCase_ = BIND_MONEY_REQUEST_DETAILS_LIST_FIELD_NUMBER;
    }

    private void setBlockUser(UsersOuterClass$RequestBlockUser usersOuterClass$RequestBlockUser) {
        usersOuterClass$RequestBlockUser.getClass();
        this.trait_ = usersOuterClass$RequestBlockUser;
        this.traitCase_ = BLOCK_USER_FIELD_NUMBER;
    }

    private void setBuyCharge(Charnet$RequestBuyCharge charnet$RequestBuyCharge) {
        charnet$RequestBuyCharge.getClass();
        this.trait_ = charnet$RequestBuyCharge;
        this.traitCase_ = BUY_CHARGE_FIELD_NUMBER;
    }

    private void setBuyFastCharge(BankOuterClass$RequestBuyFastCharge bankOuterClass$RequestBuyFastCharge) {
        bankOuterClass$RequestBuyFastCharge.getClass();
        this.trait_ = bankOuterClass$RequestBuyFastCharge;
        this.traitCase_ = BUY_FAST_CHARGE_FIELD_NUMBER;
    }

    private void setBuyInternetBundle(Charnet$RequestBuyInternetBundle charnet$RequestBuyInternetBundle) {
        charnet$RequestBuyInternetBundle.getClass();
        this.trait_ = charnet$RequestBuyInternetBundle;
        this.traitCase_ = BUY_INTERNET_BUNDLE_FIELD_NUMBER;
    }

    private void setBuyVoucher(ClubOuterClass$RequestBuyVoucher clubOuterClass$RequestBuyVoucher) {
        clubOuterClass$RequestBuyVoucher.getClass();
        this.trait_ = clubOuterClass$RequestBuyVoucher;
        this.traitCase_ = BUY_VOUCHER_FIELD_NUMBER;
    }

    private void setBuyWheelChance(ClubOuterClass$RequestBuyWheelChance clubOuterClass$RequestBuyWheelChance) {
        clubOuterClass$RequestBuyWheelChance.getClass();
        this.trait_ = clubOuterClass$RequestBuyWheelChance;
        this.traitCase_ = BUY_WHEEL_CHANCE_FIELD_NUMBER;
    }

    private void setCashOutFromWallet(WalletOuterClass$RequestCashOutFromWallet walletOuterClass$RequestCashOutFromWallet) {
        walletOuterClass$RequestCashOutFromWallet.getClass();
        this.trait_ = walletOuterClass$RequestCashOutFromWallet;
        this.traitCase_ = CASH_OUT_FROM_WALLET_FIELD_NUMBER;
    }

    private void setCashoutKifpool(KifpoolOuterClass$RequestCashOutKifpool kifpoolOuterClass$RequestCashOutKifpool) {
        kifpoolOuterClass$RequestCashOutKifpool.getClass();
        this.trait_ = kifpoolOuterClass$RequestCashOutKifpool;
        this.traitCase_ = CASHOUT_KIFPOOL_FIELD_NUMBER;
    }

    private void setChangeDefaultCardNumber(UsersOuterClass$RequestChangeDefaultCardNumber usersOuterClass$RequestChangeDefaultCardNumber) {
        usersOuterClass$RequestChangeDefaultCardNumber.getClass();
        this.trait_ = usersOuterClass$RequestChangeDefaultCardNumber;
        this.traitCase_ = CHANGE_DEFAULT_CARD_NUMBER_FIELD_NUMBER;
    }

    private void setChangePhone(AuthOuterClass$RequestChangePhone authOuterClass$RequestChangePhone) {
        authOuterClass$RequestChangePhone.getClass();
        this.trait_ = authOuterClass$RequestChangePhone;
        this.traitCase_ = CHANGE_PHONE_FIELD_NUMBER;
    }

    private void setChangePointToMoney(ClubOuterClass$RequestChangePointToMoney clubOuterClass$RequestChangePointToMoney) {
        clubOuterClass$RequestChangePointToMoney.getClass();
        this.trait_ = clubOuterClass$RequestChangePointToMoney;
        this.traitCase_ = CHANGE_POINT_TO_MONEY_FIELD_NUMBER;
    }

    private void setChangeStatusDialogAdOrder(AdvertisementOuterClass$RequestChangeStatusDialogAdOrder advertisementOuterClass$RequestChangeStatusDialogAdOrder) {
        advertisementOuterClass$RequestChangeStatusDialogAdOrder.getClass();
        this.trait_ = advertisementOuterClass$RequestChangeStatusDialogAdOrder;
        this.traitCase_ = CHANGE_STATUS_DIALOG_AD_ORDER_FIELD_NUMBER;
    }

    private void setCharge(KifpoolOuterClass$RequestCharge kifpoolOuterClass$RequestCharge) {
        kifpoolOuterClass$RequestCharge.getClass();
        this.trait_ = kifpoolOuterClass$RequestCharge;
        this.traitCase_ = CHARGE_FIELD_NUMBER;
    }

    private void setCheckChargePermission(KifpoolOuterClass$RequestCheckChargePermission kifpoolOuterClass$RequestCheckChargePermission) {
        kifpoolOuterClass$RequestCheckChargePermission.getClass();
        this.trait_ = kifpoolOuterClass$RequestCheckChargePermission;
        this.traitCase_ = CHECK_CHARGE_PERMISSION_FIELD_NUMBER;
    }

    private void setCheckNickName(UsersOuterClass$RequestCheckNickName usersOuterClass$RequestCheckNickName) {
        usersOuterClass$RequestCheckNickName.getClass();
        this.trait_ = usersOuterClass$RequestCheckNickName;
        this.traitCase_ = CHECK_NICK_NAME_FIELD_NUMBER;
    }

    private void setCheckStatusOfPayment(SefteOuterClass$RequestCheckStatusOfPayment sefteOuterClass$RequestCheckStatusOfPayment) {
        sefteOuterClass$RequestCheckStatusOfPayment.getClass();
        this.trait_ = sefteOuterClass$RequestCheckStatusOfPayment;
        this.traitCase_ = CHECK_STATUS_OF_PAYMENT_FIELD_NUMBER;
    }

    private void setClearChat(MessagingOuterClass$RequestClearChat messagingOuterClass$RequestClearChat) {
        messagingOuterClass$RequestClearChat.getClass();
        this.trait_ = messagingOuterClass$RequestClearChat;
        this.traitCase_ = 99;
    }

    private void setCombinedUpdate(UpdateBoxStruct$CombinedUpdate updateBoxStruct$CombinedUpdate) {
        updateBoxStruct$CombinedUpdate.getClass();
        this.trait_ = updateBoxStruct$CombinedUpdate;
        this.traitCase_ = 2625;
    }

    private void setCreateGroup(GroupsOuterClass$RequestCreateGroup groupsOuterClass$RequestCreateGroup) {
        groupsOuterClass$RequestCreateGroup.getClass();
        this.trait_ = groupsOuterClass$RequestCreateGroup;
        this.traitCase_ = CREATE_GROUP_FIELD_NUMBER;
    }

    private void setCreateKifpool(KifpoolOuterClass$RequestCreateKifpool kifpoolOuterClass$RequestCreateKifpool) {
        kifpoolOuterClass$RequestCreateKifpool.getClass();
        this.trait_ = kifpoolOuterClass$RequestCreateKifpool;
        this.traitCase_ = CREATE_KIFPOOL_FIELD_NUMBER;
    }

    private void setCreateSavedBill(BillOuterClass$RequestCreateSavedBill billOuterClass$RequestCreateSavedBill) {
        billOuterClass$RequestCreateSavedBill.getClass();
        this.trait_ = billOuterClass$RequestCreateSavedBill;
        this.traitCase_ = CREATE_SAVED_BILL_FIELD_NUMBER;
    }

    private void setCryptoTransfer(KifpoolOuterClass$RequestCryptoTransfer kifpoolOuterClass$RequestCryptoTransfer) {
        kifpoolOuterClass$RequestCryptoTransfer.getClass();
        this.trait_ = kifpoolOuterClass$RequestCryptoTransfer;
        this.traitCase_ = CRYPTO_TRANSFER_FIELD_NUMBER;
    }

    private void setDeleteAccount(AuthOuterClass$RequestDeleteAccount authOuterClass$RequestDeleteAccount) {
        authOuterClass$RequestDeleteAccount.getClass();
        this.trait_ = authOuterClass$RequestDeleteAccount;
        this.traitCase_ = DELETE_ACCOUNT_FIELD_NUMBER;
    }

    private void setDeleteChat(MessagingOuterClass$RequestDeleteChat messagingOuterClass$RequestDeleteChat) {
        messagingOuterClass$RequestDeleteChat.getClass();
        this.trait_ = messagingOuterClass$RequestDeleteChat;
        this.traitCase_ = 100;
    }

    private void setDeleteInternetBundleOrder(Charnet$RequestDeleteInternetBundleOrder charnet$RequestDeleteInternetBundleOrder) {
        charnet$RequestDeleteInternetBundleOrder.getClass();
        this.trait_ = charnet$RequestDeleteInternetBundleOrder;
        this.traitCase_ = DELETE_INTERNET_BUNDLE_ORDER_FIELD_NUMBER;
    }

    private void setDeleteMessage(MessagingOuterClass$RequestDeleteMessage messagingOuterClass$RequestDeleteMessage) {
        messagingOuterClass$RequestDeleteMessage.getClass();
        this.trait_ = messagingOuterClass$RequestDeleteMessage;
        this.traitCase_ = 98;
    }

    private void setDeleteOrder(Saba$RequestDeleteOrder saba$RequestDeleteOrder) {
        saba$RequestDeleteOrder.getClass();
        this.trait_ = saba$RequestDeleteOrder;
        this.traitCase_ = DELETE_ORDER_FIELD_NUMBER;
    }

    private void setDeleteSavedBills(BillOuterClass$RequestDeleteSavedBills billOuterClass$RequestDeleteSavedBills) {
        billOuterClass$RequestDeleteSavedBills.getClass();
        this.trait_ = billOuterClass$RequestDeleteSavedBills;
        this.traitCase_ = DELETE_SAVED_BILLS_FIELD_NUMBER;
    }

    private void setDeliverOtp(SapOuterClass$RequestDeliverOtp sapOuterClass$RequestDeliverOtp) {
        sapOuterClass$RequestDeliverOtp.getClass();
        this.trait_ = sapOuterClass$RequestDeliverOtp;
        this.traitCase_ = DELIVER_OTP_FIELD_NUMBER;
    }

    private void setDiscardCall(MeetOuterClass$RequestDiscardCall meetOuterClass$RequestDiscardCall) {
        meetOuterClass$RequestDiscardCall.getClass();
        this.trait_ = meetOuterClass$RequestDiscardCall;
        this.traitCase_ = DISCARD_CALL_FIELD_NUMBER;
    }

    private void setEditAbout(UsersOuterClass$RequestEditAbout usersOuterClass$RequestEditAbout) {
        usersOuterClass$RequestEditAbout.getClass();
        this.trait_ = usersOuterClass$RequestEditAbout;
        this.traitCase_ = 212;
    }

    private void setEditAvatar(UsersOuterClass$RequestEditAvatar usersOuterClass$RequestEditAvatar) {
        usersOuterClass$RequestEditAvatar.getClass();
        this.trait_ = usersOuterClass$RequestEditAvatar;
        this.traitCase_ = 31;
    }

    private void setEditBirthDate(UsersOuterClass$RequestEditBirthDate usersOuterClass$RequestEditBirthDate) {
        usersOuterClass$RequestEditBirthDate.getClass();
        this.trait_ = usersOuterClass$RequestEditBirthDate;
        this.traitCase_ = EDIT_BIRTH_DATE_FIELD_NUMBER;
    }

    private void setEditCardExpirationDate(SapOuterClass$RequestEditCardExpirationDate sapOuterClass$RequestEditCardExpirationDate) {
        sapOuterClass$RequestEditCardExpirationDate.getClass();
        this.trait_ = sapOuterClass$RequestEditCardExpirationDate;
        this.traitCase_ = EDIT_CARD_EXPIRATION_DATE_FIELD_NUMBER;
    }

    private void setEditChannelNick(GroupsOuterClass$RequestEditChannelNick groupsOuterClass$RequestEditChannelNick) {
        groupsOuterClass$RequestEditChannelNick.getClass();
        this.trait_ = groupsOuterClass$RequestEditChannelNick;
        this.traitCase_ = EDIT_CHANNEL_NICK_FIELD_NUMBER;
    }

    private void setEditGroupAbout(GroupsOuterClass$RequestEditGroupAbout groupsOuterClass$RequestEditGroupAbout) {
        groupsOuterClass$RequestEditGroupAbout.getClass();
        this.trait_ = groupsOuterClass$RequestEditGroupAbout;
        this.traitCase_ = 213;
    }

    private void setEditGroupAvatar(GroupsOuterClass$RequestEditGroupAvatar groupsOuterClass$RequestEditGroupAvatar) {
        groupsOuterClass$RequestEditGroupAvatar.getClass();
        this.trait_ = groupsOuterClass$RequestEditGroupAvatar;
        this.traitCase_ = 86;
    }

    private void setEditGroupDefaultCardNumber(GroupsOuterClass$RequestEditGroupDefaultCardNumber groupsOuterClass$RequestEditGroupDefaultCardNumber) {
        groupsOuterClass$RequestEditGroupDefaultCardNumber.getClass();
        this.trait_ = groupsOuterClass$RequestEditGroupDefaultCardNumber;
        this.traitCase_ = EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER;
    }

    private void setEditGroupTitle(GroupsOuterClass$RequestEditGroupTitle groupsOuterClass$RequestEditGroupTitle) {
        groupsOuterClass$RequestEditGroupTitle.getClass();
        this.trait_ = groupsOuterClass$RequestEditGroupTitle;
        this.traitCase_ = 85;
    }

    private void setEditMyPreferredLanguages(UsersOuterClass$RequestEditMyPreferredLanguages usersOuterClass$RequestEditMyPreferredLanguages) {
        usersOuterClass$RequestEditMyPreferredLanguages.getClass();
        this.trait_ = usersOuterClass$RequestEditMyPreferredLanguages;
        this.traitCase_ = EDIT_MY_PREFERRED_LANGUAGES_FIELD_NUMBER;
    }

    private void setEditMyTimeZone(UsersOuterClass$RequestEditMyTimeZone usersOuterClass$RequestEditMyTimeZone) {
        usersOuterClass$RequestEditMyTimeZone.getClass();
        this.trait_ = usersOuterClass$RequestEditMyTimeZone;
        this.traitCase_ = EDIT_MY_TIME_ZONE_FIELD_NUMBER;
    }

    private void setEditName(UsersOuterClass$RequestEditName usersOuterClass$RequestEditName) {
        usersOuterClass$RequestEditName.getClass();
        this.trait_ = usersOuterClass$RequestEditName;
        this.traitCase_ = 53;
    }

    private void setEditNickName(UsersOuterClass$RequestEditNickName usersOuterClass$RequestEditNickName) {
        usersOuterClass$RequestEditNickName.getClass();
        this.trait_ = usersOuterClass$RequestEditNickName;
        this.traitCase_ = EDIT_NICK_NAME_FIELD_NUMBER;
    }

    private void setEditParameter(ConfigsOuterClass$RequestEditParameter configsOuterClass$RequestEditParameter) {
        configsOuterClass$RequestEditParameter.getClass();
        this.trait_ = configsOuterClass$RequestEditParameter;
        this.traitCase_ = 128;
    }

    private void setEditSex(UsersOuterClass$RequestEditSex usersOuterClass$RequestEditSex) {
        usersOuterClass$RequestEditSex.getClass();
        this.trait_ = usersOuterClass$RequestEditSex;
        this.traitCase_ = EDIT_SEX_FIELD_NUMBER;
    }

    private void setEditUserLocalName(UsersOuterClass$RequestEditUserLocalName usersOuterClass$RequestEditUserLocalName) {
        usersOuterClass$RequestEditUserLocalName.getClass();
        this.trait_ = usersOuterClass$RequestEditUserLocalName;
        this.traitCase_ = 96;
    }

    private void setEnrollNewCard(SapOuterClass$RequestEnrollNewCard sapOuterClass$RequestEnrollNewCard) {
        sapOuterClass$RequestEnrollNewCard.getClass();
        this.trait_ = sapOuterClass$RequestEnrollNewCard;
        this.traitCase_ = ENROLL_NEW_CARD_FIELD_NUMBER;
    }

    private void setFatSeqUpdate(UpdateBoxStruct$FatSeqUpdate updateBoxStruct$FatSeqUpdate) {
        updateBoxStruct$FatSeqUpdate.getClass();
        this.trait_ = updateBoxStruct$FatSeqUpdate;
        this.traitCase_ = 73;
    }

    private void setFetchGroupAdmins(GroupsOuterClass$RequestFetchGroupAdmins groupsOuterClass$RequestFetchGroupAdmins) {
        groupsOuterClass$RequestFetchGroupAdmins.getClass();
        this.trait_ = groupsOuterClass$RequestFetchGroupAdmins;
        this.traitCase_ = FETCH_GROUP_ADMINS_FIELD_NUMBER;
    }

    private void setFilterTaggedTransactions(PfmOuterClass$RequestFilterTaggedTransactions pfmOuterClass$RequestFilterTaggedTransactions) {
        pfmOuterClass$RequestFilterTaggedTransactions.getClass();
        this.trait_ = pfmOuterClass$RequestFilterTaggedTransactions;
        this.traitCase_ = FILTER_TAGGED_TRANSACTIONS_FIELD_NUMBER;
    }

    private void setGetAcquiredVouchers(ClubOuterClass$RequestGetAcquiredVouchers clubOuterClass$RequestGetAcquiredVouchers) {
        clubOuterClass$RequestGetAcquiredVouchers.getClass();
        this.trait_ = clubOuterClass$RequestGetAcquiredVouchers;
        this.traitCase_ = GET_ACQUIRED_VOUCHERS_FIELD_NUMBER;
    }

    private void setGetAdProvider(AdvertisementOuterClass$RequestGetAdProvider advertisementOuterClass$RequestGetAdProvider) {
        advertisementOuterClass$RequestGetAdProvider.getClass();
        this.trait_ = advertisementOuterClass$RequestGetAdProvider;
        this.traitCase_ = GET_AD_PROVIDER_FIELD_NUMBER;
    }

    private void setGetAuthSessions(AuthOuterClass$RequestGetAuthSessions authOuterClass$RequestGetAuthSessions) {
        authOuterClass$RequestGetAuthSessions.getClass();
        this.trait_ = authOuterClass$RequestGetAuthSessions;
        this.traitCase_ = 80;
    }

    private void setGetBaleTicket(AuthOuterClass$RequestGetBaleTicket authOuterClass$RequestGetBaleTicket) {
        authOuterClass$RequestGetBaleTicket.getClass();
        this.trait_ = authOuterClass$RequestGetBaleTicket;
        this.traitCase_ = GET_BALE_TICKET_FIELD_NUMBER;
    }

    private void setGetBamServiceToken(Microbanki$RequestGetBamServiceToken microbanki$RequestGetBamServiceToken) {
        microbanki$RequestGetBamServiceToken.getClass();
        this.trait_ = microbanki$RequestGetBamServiceToken;
        this.traitCase_ = GET_BAM_SERVICE_TOKEN_FIELD_NUMBER;
    }

    private void setGetBillHistory(BillOuterClass$RequestGetBillHistory billOuterClass$RequestGetBillHistory) {
        billOuterClass$RequestGetBillHistory.getClass();
        this.trait_ = billOuterClass$RequestGetBillHistory;
        this.traitCase_ = GET_BILL_HISTORY_FIELD_NUMBER;
    }

    private void setGetBotWhiteList(KetfOuterClass$RequestGetBotWhiteList ketfOuterClass$RequestGetBotWhiteList) {
        ketfOuterClass$RequestGetBotWhiteList.getClass();
        this.trait_ = ketfOuterClass$RequestGetBotWhiteList;
        this.traitCase_ = 249;
    }

    private void setGetCanSeeMessages(GroupsOuterClass$RequestGetCanSeeMessages groupsOuterClass$RequestGetCanSeeMessages) {
        groupsOuterClass$RequestGetCanSeeMessages.getClass();
        this.trait_ = groupsOuterClass$RequestGetCanSeeMessages;
        this.traitCase_ = GET_CAN_SEE_MESSAGES_FIELD_NUMBER;
    }

    private void setGetCardInfo(SapOuterClass$RequestGetCardInfo sapOuterClass$RequestGetCardInfo) {
        sapOuterClass$RequestGetCardInfo.getClass();
        this.trait_ = sapOuterClass$RequestGetCardInfo;
        this.traitCase_ = GET_CARD_INFO_FIELD_NUMBER;
    }

    private void setGetCardTransferToken(BankOuterClass$RequestGetCardTransferToken bankOuterClass$RequestGetCardTransferToken) {
        bankOuterClass$RequestGetCardTransferToken.getClass();
        this.trait_ = bankOuterClass$RequestGetCardTransferToken;
        this.traitCase_ = GET_CARD_TRANSFER_TOKEN_FIELD_NUMBER;
    }

    private void setGetCards(SapOuterClass$RequestGetCards sapOuterClass$RequestGetCards) {
        sapOuterClass$RequestGetCards.getClass();
        this.trait_ = sapOuterClass$RequestGetCards;
        this.traitCase_ = GET_CARDS_FIELD_NUMBER;
    }

    private void setGetChannelAds(AdvertisementOuterClass$RequestGetChannelAds advertisementOuterClass$RequestGetChannelAds) {
        advertisementOuterClass$RequestGetChannelAds.getClass();
        this.trait_ = advertisementOuterClass$RequestGetChannelAds;
        this.traitCase_ = GET_CHANNEL_ADS_FIELD_NUMBER;
    }

    private void setGetChannelEarnMoneyInfo(AdvertisementOuterClass$RequestGetChannelEarnMoneyInfo advertisementOuterClass$RequestGetChannelEarnMoneyInfo) {
        advertisementOuterClass$RequestGetChannelEarnMoneyInfo.getClass();
        this.trait_ = advertisementOuterClass$RequestGetChannelEarnMoneyInfo;
        this.traitCase_ = GET_CHANNEL_EARN_MONEY_INFO_FIELD_NUMBER;
    }

    private void setGetChannelEarnMoneyStatus(AdvertisementOuterClass$RequestGetChannelEarnMoneyStatus advertisementOuterClass$RequestGetChannelEarnMoneyStatus) {
        advertisementOuterClass$RequestGetChannelEarnMoneyStatus.getClass();
        this.trait_ = advertisementOuterClass$RequestGetChannelEarnMoneyStatus;
        this.traitCase_ = GET_CHANNEL_EARN_MONEY_STATUS_FIELD_NUMBER;
    }

    private void setGetChargeAmounts(Saba$RequestGetChargeAmounts saba$RequestGetChargeAmounts) {
        saba$RequestGetChargeAmounts.getClass();
        this.trait_ = saba$RequestGetChargeAmounts;
        this.traitCase_ = GET_CHARGE_AMOUNTS_FIELD_NUMBER;
    }

    private void setGetChargePaymentToken(KifpoolOuterClass$RequestGetChargePaymentToken kifpoolOuterClass$RequestGetChargePaymentToken) {
        kifpoolOuterClass$RequestGetChargePaymentToken.getClass();
        this.trait_ = kifpoolOuterClass$RequestGetChargePaymentToken;
        this.traitCase_ = GET_CHARGE_PAYMENT_TOKEN_FIELD_NUMBER;
    }

    private void setGetChargeTopupPaymentToken(Saba$RequestGetChargeTopupPaymentToken saba$RequestGetChargeTopupPaymentToken) {
        saba$RequestGetChargeTopupPaymentToken.getClass();
        this.trait_ = saba$RequestGetChargeTopupPaymentToken;
        this.traitCase_ = GET_CHARGE_TOPUP_PAYMENT_TOKEN_FIELD_NUMBER;
    }

    private void setGetChargeVoucherPaymentToken(Saba$RequestGetChargeVoucherPaymentToken saba$RequestGetChargeVoucherPaymentToken) {
        saba$RequestGetChargeVoucherPaymentToken.getClass();
        this.trait_ = saba$RequestGetChargeVoucherPaymentToken;
        this.traitCase_ = GET_CHARGE_VOUCHER_PAYMENT_TOKEN_FIELD_NUMBER;
    }

    private void setGetCitiesOfState(SefteOuterClass$RequestGetCitiesOfState sefteOuterClass$RequestGetCitiesOfState) {
        sefteOuterClass$RequestGetCitiesOfState.getClass();
        this.trait_ = sefteOuterClass$RequestGetCitiesOfState;
        this.traitCase_ = GET_CITIES_OF_STATE_FIELD_NUMBER;
    }

    private void setGetContacts(UsersOuterClass$RequestGetContacts usersOuterClass$RequestGetContacts) {
        usersOuterClass$RequestGetContacts.getClass();
        this.trait_ = usersOuterClass$RequestGetContacts;
        this.traitCase_ = 87;
    }

    private void setGetCryptoChargePaymentToken(KifpoolOuterClass$RequestGetCryptoChargePaymentToken kifpoolOuterClass$RequestGetCryptoChargePaymentToken) {
        kifpoolOuterClass$RequestGetCryptoChargePaymentToken.getClass();
        this.trait_ = kifpoolOuterClass$RequestGetCryptoChargePaymentToken;
        this.traitCase_ = GET_CRYPTO_CHARGE_PAYMENT_TOKEN_FIELD_NUMBER;
    }

    private void setGetCryptoWallets(KifpoolOuterClass$RequestGetCryptoWallets kifpoolOuterClass$RequestGetCryptoWallets) {
        kifpoolOuterClass$RequestGetCryptoWallets.getClass();
        this.trait_ = kifpoolOuterClass$RequestGetCryptoWallets;
        this.traitCase_ = GET_CRYPTO_WALLETS_FIELD_NUMBER;
    }

    private void setGetDefaultCard(SapOuterClass$RequestGetDefaultCard sapOuterClass$RequestGetDefaultCard) {
        sapOuterClass$RequestGetDefaultCard.getClass();
        this.trait_ = sapOuterClass$RequestGetDefaultCard;
        this.traitCase_ = GET_DEFAULT_CARD_FIELD_NUMBER;
    }

    private void setGetDestinationCardInfo(SapOuterClass$RequestGetDestinationCardInfo sapOuterClass$RequestGetDestinationCardInfo) {
        sapOuterClass$RequestGetDestinationCardInfo.getClass();
        this.trait_ = sapOuterClass$RequestGetDestinationCardInfo;
        this.traitCase_ = GET_DESTINATION_CARD_INFO_FIELD_NUMBER;
    }

    private void setGetDestinationCards(SapOuterClass$RequestGetDestinationCards sapOuterClass$RequestGetDestinationCards) {
        sapOuterClass$RequestGetDestinationCards.getClass();
        this.trait_ = sapOuterClass$RequestGetDestinationCards;
        this.traitCase_ = GET_DESTINATION_CARDS_FIELD_NUMBER;
    }

    private void setGetDialogAdOrderDetails(AdvertisementOuterClass$RequestGetDialogAdOrderDetails advertisementOuterClass$RequestGetDialogAdOrderDetails) {
        advertisementOuterClass$RequestGetDialogAdOrderDetails.getClass();
        this.trait_ = advertisementOuterClass$RequestGetDialogAdOrderDetails;
        this.traitCase_ = GET_DIALOG_AD_ORDER_DETAILS_FIELD_NUMBER;
    }

    private void setGetDialogAdOrderPaymentToken(AdvertisementOuterClass$RequestGetDialogAdOrderPaymentToken advertisementOuterClass$RequestGetDialogAdOrderPaymentToken) {
        advertisementOuterClass$RequestGetDialogAdOrderPaymentToken.getClass();
        this.trait_ = advertisementOuterClass$RequestGetDialogAdOrderPaymentToken;
        this.traitCase_ = GET_DIALOG_AD_ORDER_PAYMENT_TOKEN_FIELD_NUMBER;
    }

    private void setGetGiftPacketPaymentToken(Giftpacket$RequestGetGiftPacketPaymentToken giftpacket$RequestGetGiftPacketPaymentToken) {
        giftpacket$RequestGetGiftPacketPaymentToken.getClass();
        this.trait_ = giftpacket$RequestGetGiftPacketPaymentToken;
        this.traitCase_ = GET_GIFT_PACKET_PAYMENT_TOKEN_FIELD_NUMBER;
    }

    private void setGetGroupDefaultCardNumber(GroupsOuterClass$RequestGetGroupDefaultCardNumber groupsOuterClass$RequestGetGroupDefaultCardNumber) {
        groupsOuterClass$RequestGetGroupDefaultCardNumber.getClass();
        this.trait_ = groupsOuterClass$RequestGetGroupDefaultCardNumber;
        this.traitCase_ = 129;
    }

    private void setGetGroupDifference(Sequence$RequestGetGroupDifference sequence$RequestGetGroupDifference) {
        sequence$RequestGetGroupDifference.getClass();
        this.trait_ = sequence$RequestGetGroupDifference;
        this.traitCase_ = GET_GROUP_DIFFERENCE_FIELD_NUMBER;
    }

    private void setGetGroupInviteUrl(GroupsOuterClass$RequestGetGroupInviteUrl groupsOuterClass$RequestGetGroupInviteUrl) {
        groupsOuterClass$RequestGetGroupInviteUrl.getClass();
        this.trait_ = groupsOuterClass$RequestGetGroupInviteUrl;
        this.traitCase_ = GET_GROUP_INVITE_URL_FIELD_NUMBER;
    }

    private void setGetGroupMembersCount(GroupsOuterClass$RequestGetGroupMembersCount groupsOuterClass$RequestGetGroupMembersCount) {
        groupsOuterClass$RequestGetGroupMembersCount.getClass();
        this.trait_ = groupsOuterClass$RequestGetGroupMembersCount;
        this.traitCase_ = GET_GROUP_MEMBERS_COUNT_FIELD_NUMBER;
    }

    private void setGetGroupMembersPresence(PresenceOuterClass$RequestGetGroupMembersPresence presenceOuterClass$RequestGetGroupMembersPresence) {
        presenceOuterClass$RequestGetGroupMembersPresence.getClass();
        this.trait_ = presenceOuterClass$RequestGetGroupMembersPresence;
        this.traitCase_ = GET_GROUP_MEMBERS_PRESENCE_FIELD_NUMBER;
    }

    private void setGetGroupState(Sequence$RequestGetGroupState sequence$RequestGetGroupState) {
        sequence$RequestGetGroupState.getClass();
        this.trait_ = sequence$RequestGetGroupState;
        this.traitCase_ = GET_GROUP_STATE_FIELD_NUMBER;
    }

    private void setGetInternetBundleList(Charnet$RequestGetInternetBundleList charnet$RequestGetInternetBundleList) {
        charnet$RequestGetInternetBundleList.getClass();
        this.trait_ = charnet$RequestGetInternetBundleList;
        this.traitCase_ = GET_INTERNET_BUNDLE_LIST_FIELD_NUMBER;
    }

    private void setGetInternetBundlePaymentToken(Charnet$RequestGetInternetBundlePaymentToken charnet$RequestGetInternetBundlePaymentToken) {
        charnet$RequestGetInternetBundlePaymentToken.getClass();
        this.trait_ = charnet$RequestGetInternetBundlePaymentToken;
        this.traitCase_ = GET_INTERNET_BUNDLE_PAYMENT_TOKEN_FIELD_NUMBER;
    }

    private void setGetJwtToken(AuthOuterClass$RequestGetJWTToken authOuterClass$RequestGetJWTToken) {
        authOuterClass$RequestGetJWTToken.getClass();
        this.trait_ = authOuterClass$RequestGetJWTToken;
        this.traitCase_ = GET_JWT_TOKEN_FIELD_NUMBER;
    }

    private void setGetKifpoolOwner(KifpoolOuterClass$RequestGetKifpoolOwner kifpoolOuterClass$RequestGetKifpoolOwner) {
        kifpoolOuterClass$RequestGetKifpoolOwner.getClass();
        this.trait_ = kifpoolOuterClass$RequestGetKifpoolOwner;
        this.traitCase_ = GET_KIFPOOL_OWNER_FIELD_NUMBER;
    }

    private void setGetLinkPreview(EnrichmentOuterClass$RequestGetLinkPreview enrichmentOuterClass$RequestGetLinkPreview) {
        enrichmentOuterClass$RequestGetLinkPreview.getClass();
        this.trait_ = enrichmentOuterClass$RequestGetLinkPreview;
        this.traitCase_ = GET_LINK_PREVIEW_FIELD_NUMBER;
    }

    private void setGetLoanInfo(MelonOuterClass$RequestGetLoanInfo melonOuterClass$RequestGetLoanInfo) {
        melonOuterClass$RequestGetLoanInfo.getClass();
        this.trait_ = melonOuterClass$RequestGetLoanInfo;
        this.traitCase_ = GET_LOAN_INFO_FIELD_NUMBER;
    }

    private void setGetLoansList(MelonOuterClass$RequestGetLoansList melonOuterClass$RequestGetLoansList) {
        melonOuterClass$RequestGetLoansList.getClass();
        this.trait_ = melonOuterClass$RequestGetLoansList;
        this.traitCase_ = GET_LOANS_LIST_FIELD_NUMBER;
    }

    private void setGetMemberPermissions(GroupsOuterClass$RequestGetMemberPermissions groupsOuterClass$RequestGetMemberPermissions) {
        groupsOuterClass$RequestGetMemberPermissions.getClass();
        this.trait_ = groupsOuterClass$RequestGetMemberPermissions;
        this.traitCase_ = GET_MEMBER_PERMISSIONS_FIELD_NUMBER;
    }

    private void setGetMessagesRepliesInfo(MessagingOuterClass$RequestGetMessagesRepliesInfo messagingOuterClass$RequestGetMessagesRepliesInfo) {
        messagingOuterClass$RequestGetMessagesRepliesInfo.getClass();
        this.trait_ = messagingOuterClass$RequestGetMessagesRepliesInfo;
        this.traitCase_ = GET_MESSAGES_REPLIES_INFO_FIELD_NUMBER;
    }

    private void setGetMoneyRequestDetails(Microbanki$RequestGetMoneyRequestDetails microbanki$RequestGetMoneyRequestDetails) {
        microbanki$RequestGetMoneyRequestDetails.getClass();
        this.trait_ = microbanki$RequestGetMoneyRequestDetails;
        this.traitCase_ = GET_MONEY_REQUEST_DETAILS_FIELD_NUMBER;
    }

    private void setGetMoneyRequestPaymentList(Microbanki$RequestGetMoneyRequestPaymentList microbanki$RequestGetMoneyRequestPaymentList) {
        microbanki$RequestGetMoneyRequestPaymentList.getClass();
        this.trait_ = microbanki$RequestGetMoneyRequestPaymentList;
        this.traitCase_ = GET_MONEY_REQUEST_PAYMENT_LIST_FIELD_NUMBER;
    }

    private void setGetMoneyRequestPaymentTokenByCard(WalletOuterClass$RequestGetMoneyRequestPaymentTokenByCard walletOuterClass$RequestGetMoneyRequestPaymentTokenByCard) {
        walletOuterClass$RequestGetMoneyRequestPaymentTokenByCard.getClass();
        this.trait_ = walletOuterClass$RequestGetMoneyRequestPaymentTokenByCard;
        this.traitCase_ = GET_MONEY_REQUEST_PAYMENT_TOKEN_BY_CARD_FIELD_NUMBER;
    }

    private void setGetMyBank(MyBankOuterClass$RequestGetMyBank myBankOuterClass$RequestGetMyBank) {
        myBankOuterClass$RequestGetMyBank.getClass();
        this.trait_ = myBankOuterClass$RequestGetMyBank;
        this.traitCase_ = GET_MY_BANK_FIELD_NUMBER;
    }

    private void setGetMyGroups(GroupsOuterClass$RequestGetMyGroups groupsOuterClass$RequestGetMyGroups) {
        groupsOuterClass$RequestGetMyGroups.getClass();
        this.trait_ = groupsOuterClass$RequestGetMyGroups;
        this.traitCase_ = GET_MY_GROUPS_FIELD_NUMBER;
    }

    private void setGetMyKifpools(KifpoolOuterClass$RequestGetMyKifpools kifpoolOuterClass$RequestGetMyKifpools) {
        kifpoolOuterClass$RequestGetMyKifpools.getClass();
        this.trait_ = kifpoolOuterClass$RequestGetMyKifpools;
        this.traitCase_ = GET_MY_KIFPOOLS_FIELD_NUMBER;
    }

    private void setGetMySentence(SentenceOuterClass$RequestGetMySentence sentenceOuterClass$RequestGetMySentence) {
        sentenceOuterClass$RequestGetMySentence.getClass();
        this.trait_ = sentenceOuterClass$RequestGetMySentence;
        this.traitCase_ = GET_MY_SENTENCE_FIELD_NUMBER;
    }

    private void setGetMyWallets(WalletOuterClass$RequestGetMyWallets walletOuterClass$RequestGetMyWallets) {
        walletOuterClass$RequestGetMyWallets.getClass();
        this.trait_ = walletOuterClass$RequestGetMyWallets;
        this.traitCase_ = GET_MY_WALLETS_FIELD_NUMBER;
    }

    private void setGetNasimFilePublicUrl(FilesOuterClass$RequestGetNasimFilePublicUrl filesOuterClass$RequestGetNasimFilePublicUrl) {
        filesOuterClass$RequestGetNasimFilePublicUrl.getClass();
        this.trait_ = filesOuterClass$RequestGetNasimFilePublicUrl;
        this.traitCase_ = GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER;
    }

    private void setGetNasimFileUploadResume(FilesOuterClass$RequestGetNasimFileUploadResume filesOuterClass$RequestGetNasimFileUploadResume) {
        filesOuterClass$RequestGetNasimFileUploadResume.getClass();
        this.trait_ = filesOuterClass$RequestGetNasimFileUploadResume;
        this.traitCase_ = GET_NASIM_FILE_UPLOAD_RESUME_FIELD_NUMBER;
    }

    private void setGetNasimFileUploadUrl(FilesOuterClass$RequestGetNasimFileUploadUrl filesOuterClass$RequestGetNasimFileUploadUrl) {
        filesOuterClass$RequestGetNasimFileUploadUrl.getClass();
        this.trait_ = filesOuterClass$RequestGetNasimFileUploadUrl;
        this.traitCase_ = GET_NASIM_FILE_UPLOAD_URL_FIELD_NUMBER;
    }

    private void setGetNasimFileUrl(FilesOuterClass$RequestGetNasimFileUrl filesOuterClass$RequestGetNasimFileUrl) {
        filesOuterClass$RequestGetNasimFileUrl.getClass();
        this.trait_ = filesOuterClass$RequestGetNasimFileUrl;
        this.traitCase_ = GET_NASIM_FILE_URL_FIELD_NUMBER;
    }

    private void setGetNasimFileUrls(FilesOuterClass$RequestGetNasimFileUrls filesOuterClass$RequestGetNasimFileUrls) {
        filesOuterClass$RequestGetNasimFileUrls.getClass();
        this.trait_ = filesOuterClass$RequestGetNasimFileUrls;
        this.traitCase_ = GET_NASIM_FILE_URLS_FIELD_NUMBER;
    }

    private void setGetOtpTokenV2(BankOuterClass$RequestGetOTPTokenV2 bankOuterClass$RequestGetOTPTokenV2) {
        bankOuterClass$RequestGetOTPTokenV2.getClass();
        this.trait_ = bankOuterClass$RequestGetOTPTokenV2;
        this.traitCase_ = GET_OTP_TOKEN_V2_FIELD_NUMBER;
    }

    private void setGetOtptoken(BankOuterClass$RequestGetOTPToken bankOuterClass$RequestGetOTPToken) {
        bankOuterClass$RequestGetOTPToken.getClass();
        this.trait_ = bankOuterClass$RequestGetOTPToken;
        this.traitCase_ = GET_OTPTOKEN_FIELD_NUMBER;
    }

    private void setGetPacket(WarriorOuterClass$RequestGetPacket warriorOuterClass$RequestGetPacket) {
        warriorOuterClass$RequestGetPacket.getClass();
        this.trait_ = warriorOuterClass$RequestGetPacket;
        this.traitCase_ = GET_PACKET_FIELD_NUMBER;
    }

    private void setGetPacketsStatus(WarriorOuterClass$RequestGetPacketsStatus warriorOuterClass$RequestGetPacketsStatus) {
        warriorOuterClass$RequestGetPacketsStatus.getClass();
        this.trait_ = warriorOuterClass$RequestGetPacketsStatus;
        this.traitCase_ = GET_PACKETS_STATUS_FIELD_NUMBER;
    }

    private void setGetParameters(ConfigsOuterClass$RequestGetParameters configsOuterClass$RequestGetParameters) {
        configsOuterClass$RequestGetParameters.getClass();
        this.trait_ = configsOuterClass$RequestGetParameters;
        this.traitCase_ = 134;
    }

    private void setGetParticipants(Crowdfunding$RequestGetParticipants crowdfunding$RequestGetParticipants) {
        crowdfunding$RequestGetParticipants.getClass();
        this.trait_ = crowdfunding$RequestGetParticipants;
        this.traitCase_ = GET_PARTICIPANTS_FIELD_NUMBER;
    }

    private void setGetPayMoneyRequestToken(BankOuterClass$RequestGetPayMoneyRequestToken bankOuterClass$RequestGetPayMoneyRequestToken) {
        bankOuterClass$RequestGetPayMoneyRequestToken.getClass();
        this.trait_ = bankOuterClass$RequestGetPayMoneyRequestToken;
        this.traitCase_ = GET_PAY_MONEY_REQUEST_TOKEN_FIELD_NUMBER;
    }

    private void setGetPaymentToken(BankOuterClass$RequestGetPaymentToken bankOuterClass$RequestGetPaymentToken) {
        bankOuterClass$RequestGetPaymentToken.getClass();
        this.trait_ = bankOuterClass$RequestGetPaymentToken;
        this.traitCase_ = GET_PAYMENT_TOKEN_FIELD_NUMBER;
    }

    private void setGetPaymentTokenByCard(WalletOuterClass$RequestGetPaymentTokenByCard walletOuterClass$RequestGetPaymentTokenByCard) {
        walletOuterClass$RequestGetPaymentTokenByCard.getClass();
        this.trait_ = walletOuterClass$RequestGetPaymentTokenByCard;
        this.traitCase_ = GET_PAYMENT_TOKEN_BY_CARD_FIELD_NUMBER;
    }

    private void setGetPayvandCard(BankOuterClass$RequestGetPayvandCard bankOuterClass$RequestGetPayvandCard) {
        bankOuterClass$RequestGetPayvandCard.getClass();
        this.trait_ = bankOuterClass$RequestGetPayvandCard;
        this.traitCase_ = GET_PAYVAND_CARD_FIELD_NUMBER;
    }

    private void setGetPayvandCardList(BankOuterClass$RequestGetPayvandCardList bankOuterClass$RequestGetPayvandCardList) {
        bankOuterClass$RequestGetPayvandCardList.getClass();
        this.trait_ = bankOuterClass$RequestGetPayvandCardList;
        this.traitCase_ = GET_PAYVAND_CARD_LIST_FIELD_NUMBER;
    }

    private void setGetPointBalance(KifpoolOuterClass$RequestGetPointBalance kifpoolOuterClass$RequestGetPointBalance) {
        kifpoolOuterClass$RequestGetPointBalance.getClass();
        this.trait_ = kifpoolOuterClass$RequestGetPointBalance;
        this.traitCase_ = GET_POINT_BALANCE_FIELD_NUMBER;
    }

    private void setGetPointDetails(KifpoolOuterClass$RequestGetPointDetails kifpoolOuterClass$RequestGetPointDetails) {
        kifpoolOuterClass$RequestGetPointDetails.getClass();
        this.trait_ = kifpoolOuterClass$RequestGetPointDetails;
        this.traitCase_ = GET_POINT_DETAILS_FIELD_NUMBER;
    }

    private void setGetPointSummery(KifpoolOuterClass$RequestGetPointSummery kifpoolOuterClass$RequestGetPointSummery) {
        kifpoolOuterClass$RequestGetPointSummery.getClass();
        this.trait_ = kifpoolOuterClass$RequestGetPointSummery;
        this.traitCase_ = GET_POINT_SUMMERY_FIELD_NUMBER;
    }

    private void setGetPsproxyPaymentToken(BankOuterClass$RequestGetPSProxyPaymentToken bankOuterClass$RequestGetPSProxyPaymentToken) {
        bankOuterClass$RequestGetPSProxyPaymentToken.getClass();
        this.trait_ = bankOuterClass$RequestGetPSProxyPaymentToken;
        this.traitCase_ = GET_PSPROXY_PAYMENT_TOKEN_FIELD_NUMBER;
    }

    private void setGetPsproxyToken(BankOuterClass$RequestGetPSProxyToken bankOuterClass$RequestGetPSProxyToken) {
        bankOuterClass$RequestGetPSProxyToken.getClass();
        this.trait_ = bankOuterClass$RequestGetPSProxyToken;
        this.traitCase_ = GET_PSPROXY_TOKEN_FIELD_NUMBER;
    }

    private void setGetReactions(ReactionsOuterClass$RequestGetReactions reactionsOuterClass$RequestGetReactions) {
        reactionsOuterClass$RequestGetReactions.getClass();
        this.trait_ = reactionsOuterClass$RequestGetReactions;
        this.traitCase_ = GET_REACTIONS_FIELD_NUMBER;
    }

    private void setGetRecentCharges(BankOuterClass$RequestGetRecentCharges bankOuterClass$RequestGetRecentCharges) {
        bankOuterClass$RequestGetRecentCharges.getClass();
        this.trait_ = bankOuterClass$RequestGetRecentCharges;
        this.traitCase_ = GET_RECENT_CHARGES_FIELD_NUMBER;
    }

    private void setGetRecentInternetBundleOrders(Charnet$RequestGetRecentInternetBundleOrders charnet$RequestGetRecentInternetBundleOrders) {
        charnet$RequestGetRecentInternetBundleOrders.getClass();
        this.trait_ = charnet$RequestGetRecentInternetBundleOrders;
        this.traitCase_ = GET_RECENT_INTERNET_BUNDLE_ORDERS_FIELD_NUMBER;
    }

    private void setGetRecentOrders(Saba$RequestGetRecentOrders saba$RequestGetRecentOrders) {
        saba$RequestGetRecentOrders.getClass();
        this.trait_ = saba$RequestGetRecentOrders;
        this.traitCase_ = GET_RECENT_ORDERS_FIELD_NUMBER;
    }

    private void setGetRecipients(SefteOuterClass$RequestGetRecipients sefteOuterClass$RequestGetRecipients) {
        sefteOuterClass$RequestGetRecipients.getClass();
        this.trait_ = sefteOuterClass$RequestGetRecipients;
        this.traitCase_ = GET_RECIPIENTS_FIELD_NUMBER;
    }

    private void setGetReferencedEntitites(Sequence$RequestGetReferencedEntitites sequence$RequestGetReferencedEntitites) {
        sequence$RequestGetReferencedEntitites.getClass();
        this.trait_ = sequence$RequestGetReferencedEntitites;
        this.traitCase_ = 2628;
    }

    private void setGetReferralCode(ReferralOuterClass$RequestGetReferralCode referralOuterClass$RequestGetReferralCode) {
        referralOuterClass$RequestGetReferralCode.getClass();
        this.trait_ = referralOuterClass$RequestGetReferralCode;
        this.traitCase_ = GET_REFERRAL_CODE_FIELD_NUMBER;
    }

    private void setGetReferralContacts(WarriorOuterClass$RequestGetReferralContacts warriorOuterClass$RequestGetReferralContacts) {
        warriorOuterClass$RequestGetReferralContacts.getClass();
        this.trait_ = warriorOuterClass$RequestGetReferralContacts;
        this.traitCase_ = GET_REFERRAL_CONTACTS_FIELD_NUMBER;
    }

    private void setGetReferredCount(ReferralOuterClass$RequestGetReferredCount referralOuterClass$RequestGetReferredCount) {
        referralOuterClass$RequestGetReferredCount.getClass();
        this.trait_ = referralOuterClass$RequestGetReferredCount;
        this.traitCase_ = GET_REFERRED_COUNT_FIELD_NUMBER;
    }

    private void setGetReferringUser(ReferralOuterClass$RequestGetReferringUser referralOuterClass$RequestGetReferringUser) {
        referralOuterClass$RequestGetReferringUser.getClass();
        this.trait_ = referralOuterClass$RequestGetReferringUser;
        this.traitCase_ = GET_REFERRING_USER_FIELD_NUMBER;
    }

    private void setGetRemainToken(BankOuterClass$RequestGetRemainToken bankOuterClass$RequestGetRemainToken) {
        bankOuterClass$RequestGetRemainToken.getClass();
        this.trait_ = bankOuterClass$RequestGetRemainToken;
        this.traitCase_ = GET_REMAIN_TOKEN_FIELD_NUMBER;
    }

    private void setGetSadadPsppaymentToken(BankOuterClass$RequestGetSadadPSPPaymentToken bankOuterClass$RequestGetSadadPSPPaymentToken) {
        bankOuterClass$RequestGetSadadPSPPaymentToken.getClass();
        this.trait_ = bankOuterClass$RequestGetSadadPSPPaymentToken;
        this.traitCase_ = GET_SADAD_PSPPAYMENT_TOKEN_FIELD_NUMBER;
    }

    private void setGetSavedBills(BillOuterClass$RequestGetSavedBills billOuterClass$RequestGetSavedBills) {
        billOuterClass$RequestGetSavedBills.getClass();
        this.trait_ = billOuterClass$RequestGetSavedBills;
        this.traitCase_ = GET_SAVED_BILLS_FIELD_NUMBER;
    }

    private void setGetScoreBoard(WarriorOuterClass$RequestGetScoreBoard warriorOuterClass$RequestGetScoreBoard) {
        warriorOuterClass$RequestGetScoreBoard.getClass();
        this.trait_ = warriorOuterClass$RequestGetScoreBoard;
        this.traitCase_ = GET_SCORE_BOARD_FIELD_NUMBER;
    }

    private void setGetState(Sequence$RequestGetState sequence$RequestGetState) {
        sequence$RequestGetState.getClass();
        this.trait_ = sequence$RequestGetState;
        this.traitCase_ = 9;
    }

    private void setGetStates(SefteOuterClass$RequestGetStates sefteOuterClass$RequestGetStates) {
        sefteOuterClass$RequestGetStates.getClass();
        this.trait_ = sefteOuterClass$RequestGetStates;
        this.traitCase_ = GET_STATES_FIELD_NUMBER;
    }

    private void setGetSubTransactions(PfmOuterClass$RequestGetSubTransactions pfmOuterClass$RequestGetSubTransactions) {
        pfmOuterClass$RequestGetSubTransactions.getClass();
        this.trait_ = pfmOuterClass$RequestGetSubTransactions;
        this.traitCase_ = GET_SUB_TRANSACTIONS_FIELD_NUMBER;
    }

    private void setGetTotalPaidAmount(Crowdfunding$RequestGetTotalPaidAmount crowdfunding$RequestGetTotalPaidAmount) {
        crowdfunding$RequestGetTotalPaidAmount.getClass();
        this.trait_ = crowdfunding$RequestGetTotalPaidAmount;
        this.traitCase_ = GET_TOTAL_PAID_AMOUNT_FIELD_NUMBER;
    }

    private void setGetTransactionTags(PfmOuterClass$RequestGetTransactionTags pfmOuterClass$RequestGetTransactionTags) {
        pfmOuterClass$RequestGetTransactionTags.getClass();
        this.trait_ = pfmOuterClass$RequestGetTransactionTags;
        this.traitCase_ = GET_TRANSACTION_TAGS_FIELD_NUMBER;
    }

    private void setGetUserAccounts(PfmOuterClass$RequestGetUserAccounts pfmOuterClass$RequestGetUserAccounts) {
        pfmOuterClass$RequestGetUserAccounts.getClass();
        this.trait_ = pfmOuterClass$RequestGetUserAccounts;
        this.traitCase_ = GET_USER_ACCOUNTS_FIELD_NUMBER;
    }

    private void setGetUserBank(VitrineOuterClass$RequestGetUserBank vitrineOuterClass$RequestGetUserBank) {
        vitrineOuterClass$RequestGetUserBank.getClass();
        this.trait_ = vitrineOuterClass$RequestGetUserBank;
        this.traitCase_ = GET_USER_BANK_FIELD_NUMBER;
    }

    private void setGetUserContext(KetfOuterClass$RequestGetUserContext ketfOuterClass$RequestGetUserContext) {
        ketfOuterClass$RequestGetUserContext.getClass();
        this.trait_ = ketfOuterClass$RequestGetUserContext;
        this.traitCase_ = 137;
    }

    private void setGetUserRefers(WarriorOuterClass$RequestGetUserRefers warriorOuterClass$RequestGetUserRefers) {
        warriorOuterClass$RequestGetUserRefers.getClass();
        this.trait_ = warriorOuterClass$RequestGetUserRefers;
        this.traitCase_ = GET_USER_REFERS_FIELD_NUMBER;
    }

    private void setGetUserScore(WarriorOuterClass$RequestGetUserScore warriorOuterClass$RequestGetUserScore) {
        warriorOuterClass$RequestGetUserScore.getClass();
        this.trait_ = warriorOuterClass$RequestGetUserScore;
        this.traitCase_ = GET_USER_SCORE_FIELD_NUMBER;
    }

    private void setGetUserSeftes(SefteOuterClass$RequestGetUserSeftes sefteOuterClass$RequestGetUserSeftes) {
        sefteOuterClass$RequestGetUserSeftes.getClass();
        this.trait_ = sefteOuterClass$RequestGetUserSeftes;
        this.traitCase_ = GET_USER_SEFTES_FIELD_NUMBER;
    }

    private void setGetUserStatus(AdvertisementOuterClass$RequestGetUserStatus advertisementOuterClass$RequestGetUserStatus) {
        advertisementOuterClass$RequestGetUserStatus.getClass();
        this.trait_ = advertisementOuterClass$RequestGetUserStatus;
        this.traitCase_ = GET_USER_STATUS_FIELD_NUMBER;
    }

    private void setGetUserTags(PfmOuterClass$RequestGetUserTags pfmOuterClass$RequestGetUserTags) {
        pfmOuterClass$RequestGetUserTags.getClass();
        this.trait_ = pfmOuterClass$RequestGetUserTags;
        this.traitCase_ = GET_USER_TAGS_FIELD_NUMBER;
    }

    private void setGetUserVitrine(VitrineOuterClass$RequestGetUserVitrine vitrineOuterClass$RequestGetUserVitrine) {
        vitrineOuterClass$RequestGetUserVitrine.getClass();
        this.trait_ = vitrineOuterClass$RequestGetUserVitrine;
        this.traitCase_ = GET_USER_VITRINE_FIELD_NUMBER;
    }

    private void setGetUsersDefaultCardNumber(UsersOuterClass$RequestGetUsersDefaultCardNumber usersOuterClass$RequestGetUsersDefaultCardNumber) {
        usersOuterClass$RequestGetUsersDefaultCardNumber.getClass();
        this.trait_ = usersOuterClass$RequestGetUsersDefaultCardNumber;
        this.traitCase_ = GET_USERS_DEFAULT_CARD_NUMBER_FIELD_NUMBER;
    }

    private void setGetUsersPresence(PresenceOuterClass$RequestGetUsersPresence presenceOuterClass$RequestGetUsersPresence) {
        presenceOuterClass$RequestGetUsersPresence.getClass();
        this.trait_ = presenceOuterClass$RequestGetUsersPresence;
        this.traitCase_ = GET_USERS_PRESENCE_FIELD_NUMBER;
    }

    private void setGetVouchers(ClubOuterClass$RequestGetVouchers clubOuterClass$RequestGetVouchers) {
        clubOuterClass$RequestGetVouchers.getClass();
        this.trait_ = clubOuterClass$RequestGetVouchers;
        this.traitCase_ = GET_VOUCHERS_FIELD_NUMBER;
    }

    private void setGetWalletChargeToken(WalletOuterClass$RequestGetWalletChargeToken walletOuterClass$RequestGetWalletChargeToken) {
        walletOuterClass$RequestGetWalletChargeToken.getClass();
        this.trait_ = walletOuterClass$RequestGetWalletChargeToken;
        this.traitCase_ = GET_WALLET_CHARGE_TOKEN_FIELD_NUMBER;
    }

    private void setGetWalletContracts(WalletOuterClass$RequestGetWalletContracts walletOuterClass$RequestGetWalletContracts) {
        walletOuterClass$RequestGetWalletContracts.getClass();
        this.trait_ = walletOuterClass$RequestGetWalletContracts;
        this.traitCase_ = GET_WALLET_CONTRACTS_FIELD_NUMBER;
    }

    private void setGetWalletInvoice(WalletOuterClass$RequestGetWalletInvoice walletOuterClass$RequestGetWalletInvoice) {
        walletOuterClass$RequestGetWalletInvoice.getClass();
        this.trait_ = walletOuterClass$RequestGetWalletInvoice;
        this.traitCase_ = GET_WALLET_INVOICE_FIELD_NUMBER;
    }

    private void setGetWebviewTrackingNumber(Saba$RequestGetWebViewTrackingNumber saba$RequestGetWebViewTrackingNumber) {
        saba$RequestGetWebViewTrackingNumber.getClass();
        this.trait_ = saba$RequestGetWebViewTrackingNumber;
        this.traitCase_ = GET_WEBVIEW_TRACKING_NUMBER_FIELD_NUMBER;
    }

    private void setGetWheel(ClubOuterClass$RequestGetWheel clubOuterClass$RequestGetWheel) {
        clubOuterClass$RequestGetWheel.getClass();
        this.trait_ = clubOuterClass$RequestGetWheel;
        this.traitCase_ = GET_WHEEL_FIELD_NUMBER;
    }

    private void setGrantBankiAccess(BankOuterClass$RequestGrantBankiAccess bankOuterClass$RequestGrantBankiAccess) {
        bankOuterClass$RequestGrantBankiAccess.getClass();
        this.trait_ = bankOuterClass$RequestGrantBankiAccess;
        this.traitCase_ = GRANT_BANKI_ACCESS_FIELD_NUMBER;
    }

    private void setImportContacts(UsersOuterClass$RequestImportContacts usersOuterClass$RequestImportContacts) {
        usersOuterClass$RequestImportContacts.getClass();
        this.trait_ = usersOuterClass$RequestImportContacts;
        this.traitCase_ = 7;
    }

    private void setInitP12(SefteOuterClass$RequestInitP12 sefteOuterClass$RequestInitP12) {
        sefteOuterClass$RequestInitP12.getClass();
        this.trait_ = sefteOuterClass$RequestInitP12;
        this.traitCase_ = INIT_P12_FIELD_NUMBER;
    }

    private void setInitSefte(SefteOuterClass$RequestInitSefte sefteOuterClass$RequestInitSefte) {
        sefteOuterClass$RequestInitSefte.getClass();
        this.trait_ = sefteOuterClass$RequestInitSefte;
        this.traitCase_ = INIT_SEFTE_FIELD_NUMBER;
    }

    private void setInquiryBill(BillOuterClass$RequestInquiryBill billOuterClass$RequestInquiryBill) {
        billOuterClass$RequestInquiryBill.getClass();
        this.trait_ = billOuterClass$RequestInquiryBill;
        this.traitCase_ = INQUIRY_BILL_FIELD_NUMBER;
    }

    private void setInviteUser(GroupsOuterClass$RequestInviteUser groupsOuterClass$RequestInviteUser) {
        groupsOuterClass$RequestInviteUser.getClass();
        this.trait_ = groupsOuterClass$RequestInviteUser;
        this.traitCase_ = 69;
    }

    private void setInvoiceKifpool(KifpoolOuterClass$RequestInvoiceKifpool kifpoolOuterClass$RequestInvoiceKifpool) {
        kifpoolOuterClass$RequestInvoiceKifpool.getClass();
        this.trait_ = kifpoolOuterClass$RequestInvoiceKifpool;
        this.traitCase_ = INVOICE_KIFPOOL_FIELD_NUMBER;
    }

    private void setJoinGroup(GroupsOuterClass$RequestJoinGroup groupsOuterClass$RequestJoinGroup) {
        groupsOuterClass$RequestJoinGroup.getClass();
        this.trait_ = groupsOuterClass$RequestJoinGroup;
        this.traitCase_ = JOIN_GROUP_FIELD_NUMBER;
    }

    private void setJoinPublicGroup(GroupsOuterClass$RequestJoinPublicGroup groupsOuterClass$RequestJoinPublicGroup) {
        groupsOuterClass$RequestJoinPublicGroup.getClass();
        this.trait_ = groupsOuterClass$RequestJoinPublicGroup;
        this.traitCase_ = JOIN_PUBLIC_GROUP_FIELD_NUMBER;
    }

    private void setKickUser(GroupsOuterClass$RequestKickUser groupsOuterClass$RequestKickUser) {
        groupsOuterClass$RequestKickUser.getClass();
        this.trait_ = groupsOuterClass$RequestKickUser;
        this.traitCase_ = 71;
    }

    private void setLeaveGroup(GroupsOuterClass$RequestLeaveGroup groupsOuterClass$RequestLeaveGroup) {
        groupsOuterClass$RequestLeaveGroup.getClass();
        this.trait_ = groupsOuterClass$RequestLeaveGroup;
        this.traitCase_ = 70;
    }

    private void setLoadArchived(MessagingOuterClass$RequestLoadArchived messagingOuterClass$RequestLoadArchived) {
        messagingOuterClass$RequestLoadArchived.getClass();
        this.trait_ = messagingOuterClass$RequestLoadArchived;
        this.traitCase_ = LOAD_ARCHIVED_FIELD_NUMBER;
    }

    private void setLoadAvatars(UsersOuterClass$RequestLoadAvatars usersOuterClass$RequestLoadAvatars) {
        usersOuterClass$RequestLoadAvatars.getClass();
        this.trait_ = usersOuterClass$RequestLoadAvatars;
        this.traitCase_ = LOAD_AVATARS_FIELD_NUMBER;
    }

    private void setLoadBlockedUsers(UsersOuterClass$RequestLoadBlockedUsers usersOuterClass$RequestLoadBlockedUsers) {
        usersOuterClass$RequestLoadBlockedUsers.getClass();
        this.trait_ = usersOuterClass$RequestLoadBlockedUsers;
        this.traitCase_ = LOAD_BLOCKED_USERS_FIELD_NUMBER;
    }

    private void setLoadDialogs(MessagingOuterClass$RequestLoadDialogs messagingOuterClass$RequestLoadDialogs) {
        messagingOuterClass$RequestLoadDialogs.getClass();
        this.trait_ = messagingOuterClass$RequestLoadDialogs;
        this.traitCase_ = 104;
    }

    private void setLoadFullGroups(GroupsOuterClass$RequestLoadFullGroups groupsOuterClass$RequestLoadFullGroups) {
        groupsOuterClass$RequestLoadFullGroups.getClass();
        this.trait_ = groupsOuterClass$RequestLoadFullGroups;
        this.traitCase_ = LOAD_FULL_GROUPS_FIELD_NUMBER;
    }

    private void setLoadFullUsers(UsersOuterClass$RequestLoadFullUsers usersOuterClass$RequestLoadFullUsers) {
        usersOuterClass$RequestLoadFullUsers.getClass();
        this.trait_ = usersOuterClass$RequestLoadFullUsers;
        this.traitCase_ = LOAD_FULL_USERS_FIELD_NUMBER;
    }

    private void setLoadGroupAvatars(GroupsOuterClass$RequestLoadGroupAvatars groupsOuterClass$RequestLoadGroupAvatars) {
        groupsOuterClass$RequestLoadGroupAvatars.getClass();
        this.trait_ = groupsOuterClass$RequestLoadGroupAvatars;
        this.traitCase_ = LOAD_GROUP_AVATARS_FIELD_NUMBER;
    }

    private void setLoadGroupedDialogs(MessagingOuterClass$RequestLoadGroupedDialogs messagingOuterClass$RequestLoadGroupedDialogs) {
        messagingOuterClass$RequestLoadGroupedDialogs.getClass();
        this.trait_ = messagingOuterClass$RequestLoadGroupedDialogs;
        this.traitCase_ = 225;
    }

    private void setLoadGroups(GroupsOuterClass$RequestLoadGroups groupsOuterClass$RequestLoadGroups) {
        groupsOuterClass$RequestLoadGroups.getClass();
        this.trait_ = groupsOuterClass$RequestLoadGroups;
        this.traitCase_ = LOAD_GROUPS_FIELD_NUMBER;
    }

    private void setLoadHistory(MessagingOuterClass$RequestLoadHistory messagingOuterClass$RequestLoadHistory) {
        messagingOuterClass$RequestLoadHistory.getClass();
        this.trait_ = messagingOuterClass$RequestLoadHistory;
        this.traitCase_ = LOAD_HISTORY_FIELD_NUMBER;
    }

    private void setLoadLastStates(MelonOuterClass$RequestLoadLastStates melonOuterClass$RequestLoadLastStates) {
        melonOuterClass$RequestLoadLastStates.getClass();
        this.trait_ = melonOuterClass$RequestLoadLastStates;
        this.traitCase_ = LOAD_LAST_STATES_FIELD_NUMBER;
    }

    private void setLoadLoanHistory(MelonOuterClass$RequestLoadLoanHistory melonOuterClass$RequestLoadLoanHistory) {
        melonOuterClass$RequestLoadLoanHistory.getClass();
        this.trait_ = melonOuterClass$RequestLoadLoanHistory;
        this.traitCase_ = LOAD_LOAN_HISTORY_FIELD_NUMBER;
    }

    private void setLoadMembers(GroupsOuterClass$RequestLoadMembers groupsOuterClass$RequestLoadMembers) {
        groupsOuterClass$RequestLoadMembers.getClass();
        this.trait_ = groupsOuterClass$RequestLoadMembers;
        this.traitCase_ = LOAD_MEMBERS_FIELD_NUMBER;
    }

    private void setLoadOwnStickers(ImagesOuterClass$RequestLoadOwnStickers imagesOuterClass$RequestLoadOwnStickers) {
        imagesOuterClass$RequestLoadOwnStickers.getClass();
        this.trait_ = imagesOuterClass$RequestLoadOwnStickers;
        this.traitCase_ = LOAD_OWN_STICKERS_FIELD_NUMBER;
    }

    private void setLoadPeerDialogs(MessagingOuterClass$RequestLoadPeerDialogs messagingOuterClass$RequestLoadPeerDialogs) {
        messagingOuterClass$RequestLoadPeerDialogs.getClass();
        this.trait_ = messagingOuterClass$RequestLoadPeerDialogs;
        this.traitCase_ = LOAD_PEER_DIALOGS_FIELD_NUMBER;
    }

    private void setLoadReactions(AbacusOuterClass$RequestLoadReactions abacusOuterClass$RequestLoadReactions) {
        abacusOuterClass$RequestLoadReactions.getClass();
        this.trait_ = abacusOuterClass$RequestLoadReactions;
        this.traitCase_ = LOAD_REACTIONS_FIELD_NUMBER;
    }

    private void setLoadStickerCollection(ImagesOuterClass$RequestLoadStickerCollection imagesOuterClass$RequestLoadStickerCollection) {
        imagesOuterClass$RequestLoadStickerCollection.getClass();
        this.trait_ = imagesOuterClass$RequestLoadStickerCollection;
        this.traitCase_ = LOAD_STICKER_COLLECTION_FIELD_NUMBER;
    }

    private void setLoadTransactions(PfmOuterClass$RequestLoadTransactions pfmOuterClass$RequestLoadTransactions) {
        pfmOuterClass$RequestLoadTransactions.getClass();
        this.trait_ = pfmOuterClass$RequestLoadTransactions;
        this.traitCase_ = LOAD_TRANSACTIONS_FIELD_NUMBER;
    }

    private void setLoadTransactionsByIds(PfmOuterClass$RequestLoadTransactionsByIDs pfmOuterClass$RequestLoadTransactionsByIDs) {
        pfmOuterClass$RequestLoadTransactionsByIDs.getClass();
        this.trait_ = pfmOuterClass$RequestLoadTransactionsByIDs;
        this.traitCase_ = LOAD_TRANSACTIONS_BY_IDS_FIELD_NUMBER;
    }

    private void setLoadUsers(UsersOuterClass$RequestLoadUsers usersOuterClass$RequestLoadUsers) {
        usersOuterClass$RequestLoadUsers.getClass();
        this.trait_ = usersOuterClass$RequestLoadUsers;
        this.traitCase_ = LOAD_USERS_FIELD_NUMBER;
    }

    private void setMakeUserAdmin(GroupsOuterClass$RequestMakeUserAdmin groupsOuterClass$RequestMakeUserAdmin) {
        groupsOuterClass$RequestMakeUserAdmin.getClass();
        this.trait_ = groupsOuterClass$RequestMakeUserAdmin;
        this.traitCase_ = MAKE_USER_ADMIN_FIELD_NUMBER;
    }

    private void setMessageRead(MessagingOuterClass$RequestMessageRead messagingOuterClass$RequestMessageRead) {
        messagingOuterClass$RequestMessageRead.getClass();
        this.trait_ = messagingOuterClass$RequestMessageRead;
        this.traitCase_ = 57;
    }

    private void setMessageReceived(MessagingOuterClass$RequestMessageReceived messagingOuterClass$RequestMessageReceived) {
        messagingOuterClass$RequestMessageReceived.getClass();
        this.trait_ = messagingOuterClass$RequestMessageReceived;
        this.traitCase_ = 55;
    }

    private void setMessageRemoveReaction(AbacusOuterClass$RequestMessageRemoveReaction abacusOuterClass$RequestMessageRemoveReaction) {
        abacusOuterClass$RequestMessageRemoveReaction.getClass();
        this.trait_ = abacusOuterClass$RequestMessageRemoveReaction;
        this.traitCase_ = MESSAGE_REMOVE_REACTION_FIELD_NUMBER;
    }

    private void setMessageSetReaction(AbacusOuterClass$RequestMessageSetReaction abacusOuterClass$RequestMessageSetReaction) {
        abacusOuterClass$RequestMessageSetReaction.getClass();
        this.trait_ = abacusOuterClass$RequestMessageSetReaction;
        this.traitCase_ = 210;
    }

    private void setNewFatSeqUpdate(UpdateBoxStruct$NewFatSeqUpdate updateBoxStruct$NewFatSeqUpdate) {
        updateBoxStruct$NewFatSeqUpdate.getClass();
        this.trait_ = updateBoxStruct$NewFatSeqUpdate;
        this.traitCase_ = NEW_FAT_SEQ_UPDATE_FIELD_NUMBER;
    }

    private void setNewSeqUpdate(UpdateBoxStruct$NewSeqUpdate updateBoxStruct$NewSeqUpdate) {
        updateBoxStruct$NewSeqUpdate.getClass();
        this.trait_ = updateBoxStruct$NewSeqUpdate;
        this.traitCase_ = 45;
    }

    private void setNotifyAboutDeviceInfo(UsersOuterClass$RequestNotifyAboutDeviceInfo usersOuterClass$RequestNotifyAboutDeviceInfo) {
        usersOuterClass$RequestNotifyAboutDeviceInfo.getClass();
        this.trait_ = usersOuterClass$RequestNotifyAboutDeviceInfo;
        this.traitCase_ = NOTIFY_ABOUT_DEVICE_INFO_FIELD_NUMBER;
    }

    private void setOpenGiftPacket(Giftpacket$RequestOpenGiftPacket giftpacket$RequestOpenGiftPacket) {
        giftpacket$RequestOpenGiftPacket.getClass();
        this.trait_ = giftpacket$RequestOpenGiftPacket;
        this.traitCase_ = OPEN_GIFT_PACKET_FIELD_NUMBER;
    }

    private void setPayBill(BillOuterClass$RequestPayBill billOuterClass$RequestPayBill) {
        billOuterClass$RequestPayBill.getClass();
        this.trait_ = billOuterClass$RequestPayBill;
        this.traitCase_ = PAY_BILL_FIELD_NUMBER;
    }

    private void setPayByWallet(WalletOuterClass$RequestPayByWallet walletOuterClass$RequestPayByWallet) {
        walletOuterClass$RequestPayByWallet.getClass();
        this.trait_ = walletOuterClass$RequestPayByWallet;
        this.traitCase_ = PAY_BY_WALLET_FIELD_NUMBER;
    }

    private void setPayMoneyRequestByWallet(WalletOuterClass$RequestPayMoneyRequestByWallet walletOuterClass$RequestPayMoneyRequestByWallet) {
        walletOuterClass$RequestPayMoneyRequestByWallet.getClass();
        this.trait_ = walletOuterClass$RequestPayMoneyRequestByWallet;
        this.traitCase_ = PAY_MONEY_REQUEST_BY_WALLET_FIELD_NUMBER;
    }

    private void setPaySefte(SefteOuterClass$RequestPaySefte sefteOuterClass$RequestPaySefte) {
        sefteOuterClass$RequestPaySefte.getClass();
        this.trait_ = sefteOuterClass$RequestPaySefte;
        this.traitCase_ = PAY_SEFTE_FIELD_NUMBER;
    }

    private void setPinMessage(GroupsOuterClass$RequestPinMessage groupsOuterClass$RequestPinMessage) {
        groupsOuterClass$RequestPinMessage.getClass();
        this.trait_ = groupsOuterClass$RequestPinMessage;
        this.traitCase_ = PIN_MESSAGE_FIELD_NUMBER;
    }

    private void setProto(Protobuf$RequestProto protobuf$RequestProto) {
        protobuf$RequestProto.getClass();
        this.trait_ = protobuf$RequestProto;
        this.traitCase_ = PROTO_FIELD_NUMBER;
    }

    private void setPurchaseMessage(KifpoolOuterClass$RequestPurchaseMessage kifpoolOuterClass$RequestPurchaseMessage) {
        kifpoolOuterClass$RequestPurchaseMessage.getClass();
        this.trait_ = kifpoolOuterClass$RequestPurchaseMessage;
        this.traitCase_ = PURCHASE_MESSAGE_FIELD_NUMBER;
    }

    private void setPurchaseMessageWithCharge(KifpoolOuterClass$RequestPurchaseMessageWithCharge kifpoolOuterClass$RequestPurchaseMessageWithCharge) {
        kifpoolOuterClass$RequestPurchaseMessageWithCharge.getClass();
        this.trait_ = kifpoolOuterClass$RequestPurchaseMessageWithCharge;
        this.traitCase_ = PURCHASE_MESSAGE_WITH_CHARGE_FIELD_NUMBER;
    }

    private void setReactivateApp(SapOuterClass$RequestReactivateApp sapOuterClass$RequestReactivateApp) {
        sapOuterClass$RequestReactivateApp.getClass();
        this.trait_ = sapOuterClass$RequestReactivateApp;
        this.traitCase_ = REACTIVATE_APP_FIELD_NUMBER;
    }

    private void setRefer(ReferralOuterClass$RequestRefer referralOuterClass$RequestRefer) {
        referralOuterClass$RequestRefer.getClass();
        this.trait_ = referralOuterClass$RequestRefer;
        this.traitCase_ = REFER_FIELD_NUMBER;
    }

    private void setRegisterForEarnMoney(AdvertisementOuterClass$RequestRegisterForEarnMoney advertisementOuterClass$RequestRegisterForEarnMoney) {
        advertisementOuterClass$RequestRegisterForEarnMoney.getClass();
        this.trait_ = advertisementOuterClass$RequestRegisterForEarnMoney;
        this.traitCase_ = REGISTER_FOR_EARN_MONEY_FIELD_NUMBER;
    }

    private void setRegisterGooglePush(PushOuterClass$RequestRegisterGooglePush pushOuterClass$RequestRegisterGooglePush) {
        pushOuterClass$RequestRegisterGooglePush.getClass();
        this.trait_ = pushOuterClass$RequestRegisterGooglePush;
        this.traitCase_ = 51;
    }

    private void setRemoveAvatar(UsersOuterClass$RequestRemoveAvatar usersOuterClass$RequestRemoveAvatar) {
        usersOuterClass$RequestRemoveAvatar.getClass();
        this.trait_ = usersOuterClass$RequestRemoveAvatar;
        this.traitCase_ = 91;
    }

    private void setRemoveCard(SapOuterClass$RequestRemoveCard sapOuterClass$RequestRemoveCard) {
        sapOuterClass$RequestRemoveCard.getClass();
        this.trait_ = sapOuterClass$RequestRemoveCard;
        this.traitCase_ = REMOVE_CARD_FIELD_NUMBER;
    }

    private void setRemoveContact(UsersOuterClass$RequestRemoveContact usersOuterClass$RequestRemoveContact) {
        usersOuterClass$RequestRemoveContact.getClass();
        this.trait_ = usersOuterClass$RequestRemoveContact;
        this.traitCase_ = 89;
    }

    private void setRemoveDefaultCard(SapOuterClass$RequestRemoveDefaultCard sapOuterClass$RequestRemoveDefaultCard) {
        sapOuterClass$RequestRemoveDefaultCard.getClass();
        this.trait_ = sapOuterClass$RequestRemoveDefaultCard;
        this.traitCase_ = REMOVE_DEFAULT_CARD_FIELD_NUMBER;
    }

    private void setRemoveDefaultCardNumber(UsersOuterClass$RequestRemoveDefaultCardNumber usersOuterClass$RequestRemoveDefaultCardNumber) {
        usersOuterClass$RequestRemoveDefaultCardNumber.getClass();
        this.trait_ = usersOuterClass$RequestRemoveDefaultCardNumber;
        this.traitCase_ = REMOVE_DEFAULT_CARD_NUMBER_FIELD_NUMBER;
    }

    private void setRemoveDestinationCards(SapOuterClass$RequestRemoveDestinationCards sapOuterClass$RequestRemoveDestinationCards) {
        sapOuterClass$RequestRemoveDestinationCards.getClass();
        this.trait_ = sapOuterClass$RequestRemoveDestinationCards;
        this.traitCase_ = REMOVE_DESTINATION_CARDS_FIELD_NUMBER;
    }

    private void setRemoveGif(ImagesOuterClass$RequestRemoveGif imagesOuterClass$RequestRemoveGif) {
        imagesOuterClass$RequestRemoveGif.getClass();
        this.trait_ = imagesOuterClass$RequestRemoveGif;
        this.traitCase_ = REMOVE_GIF_FIELD_NUMBER;
    }

    private void setRemoveGroupAvatar(GroupsOuterClass$RequestRemoveGroupAvatar groupsOuterClass$RequestRemoveGroupAvatar) {
        groupsOuterClass$RequestRemoveGroupAvatar.getClass();
        this.trait_ = groupsOuterClass$RequestRemoveGroupAvatar;
        this.traitCase_ = 101;
    }

    private void setRemoveLoan(MelonOuterClass$RequestRemoveLoan melonOuterClass$RequestRemoveLoan) {
        melonOuterClass$RequestRemoveLoan.getClass();
        this.trait_ = melonOuterClass$RequestRemoveLoan;
        this.traitCase_ = REMOVE_LOAN_FIELD_NUMBER;
    }

    private void setRemovePin(GroupsOuterClass$RequestRemovePin groupsOuterClass$RequestRemovePin) {
        groupsOuterClass$RequestRemovePin.getClass();
        this.trait_ = groupsOuterClass$RequestRemovePin;
        this.traitCase_ = REMOVE_PIN_FIELD_NUMBER;
    }

    private void setRemoveStickerCollection(ImagesOuterClass$RequestRemoveStickerCollection imagesOuterClass$RequestRemoveStickerCollection) {
        imagesOuterClass$RequestRemoveStickerCollection.getClass();
        this.trait_ = imagesOuterClass$RequestRemoveStickerCollection;
        this.traitCase_ = 245;
    }

    private void setRemoveTransaction(PfmOuterClass$RequestRemoveTransaction pfmOuterClass$RequestRemoveTransaction) {
        pfmOuterClass$RequestRemoveTransaction.getClass();
        this.trait_ = pfmOuterClass$RequestRemoveTransaction;
        this.traitCase_ = REMOVE_TRANSACTION_FIELD_NUMBER;
    }

    private void setRemoveTransactionTags(PfmOuterClass$RequestRemoveTransactionTags pfmOuterClass$RequestRemoveTransactionTags) {
        pfmOuterClass$RequestRemoveTransactionTags.getClass();
        this.trait_ = pfmOuterClass$RequestRemoveTransactionTags;
        this.traitCase_ = REMOVE_TRANSACTION_TAGS_FIELD_NUMBER;
    }

    private void setRemoveUserAdmin(GroupsOuterClass$RequestRemoveUserAdmin groupsOuterClass$RequestRemoveUserAdmin) {
        groupsOuterClass$RequestRemoveUserAdmin.getClass();
        this.trait_ = groupsOuterClass$RequestRemoveUserAdmin;
        this.traitCase_ = REMOVE_USER_ADMIN_FIELD_NUMBER;
    }

    private void setRemoveUserTags(PfmOuterClass$RequestRemoveUserTags pfmOuterClass$RequestRemoveUserTags) {
        pfmOuterClass$RequestRemoveUserTags.getClass();
        this.trait_ = pfmOuterClass$RequestRemoveUserTags;
        this.traitCase_ = REMOVE_USER_TAGS_FIELD_NUMBER;
    }

    private void setRenameSavedBill(BillOuterClass$RequestRenameSavedBill billOuterClass$RequestRenameSavedBill) {
        billOuterClass$RequestRenameSavedBill.getClass();
        this.trait_ = billOuterClass$RequestRenameSavedBill;
        this.traitCase_ = RENAME_SAVED_BILL_FIELD_NUMBER;
    }

    private void setResetContacts(UsersOuterClass$RequestResetContacts usersOuterClass$RequestResetContacts) {
        usersOuterClass$RequestResetContacts.getClass();
        this.trait_ = usersOuterClass$RequestResetContacts;
        this.traitCase_ = RESET_CONTACTS_FIELD_NUMBER;
    }

    private void setResponseAddDestinationCards(SapOuterClass$ResponseAddDestinationCards sapOuterClass$ResponseAddDestinationCards) {
        sapOuterClass$ResponseAddDestinationCards.getClass();
        this.trait_ = sapOuterClass$ResponseAddDestinationCards;
        this.traitCase_ = RESPONSE_ADD_DESTINATION_CARDS_FIELD_NUMBER;
    }

    private void setResponseAddNewCards(SapOuterClass$ResponseAddNewCards sapOuterClass$ResponseAddNewCards) {
        sapOuterClass$ResponseAddNewCards.getClass();
        this.trait_ = sapOuterClass$ResponseAddNewCards;
        this.traitCase_ = RESPONSE_ADD_NEW_CARDS_FIELD_NUMBER;
    }

    private void setResponseAuth(AuthOuterClass$ResponseAuth authOuterClass$ResponseAuth) {
        authOuterClass$ResponseAuth.getClass();
        this.trait_ = authOuterClass$ResponseAuth;
        this.traitCase_ = 5;
    }

    private void setResponseAuthorizeUser(SefteOuterClass$ResponseAuthorizeUser sefteOuterClass$ResponseAuthorizeUser) {
        sefteOuterClass$ResponseAuthorizeUser.getClass();
        this.trait_ = sefteOuterClass$ResponseAuthorizeUser;
        this.traitCase_ = RESPONSE_AUTHORIZE_USER_FIELD_NUMBER;
    }

    private void setResponseBool(Misc$ResponseBool misc$ResponseBool) {
        misc$ResponseBool.getClass();
        this.trait_ = misc$ResponseBool;
        this.traitCase_ = 209;
    }

    private void setResponseBuyCharge(Charnet$ResponseBuyCharge charnet$ResponseBuyCharge) {
        charnet$ResponseBuyCharge.getClass();
        this.trait_ = charnet$ResponseBuyCharge;
        this.traitCase_ = RESPONSE_BUY_CHARGE_FIELD_NUMBER;
    }

    private void setResponseBuyFastCharge(BankOuterClass$ResponseBuyFastCharge bankOuterClass$ResponseBuyFastCharge) {
        bankOuterClass$ResponseBuyFastCharge.getClass();
        this.trait_ = bankOuterClass$ResponseBuyFastCharge;
        this.traitCase_ = RESPONSE_BUY_FAST_CHARGE_FIELD_NUMBER;
    }

    private void setResponseBuyInternetBundle(Charnet$ResponseBuyInternetBundle charnet$ResponseBuyInternetBundle) {
        charnet$ResponseBuyInternetBundle.getClass();
        this.trait_ = charnet$ResponseBuyInternetBundle;
        this.traitCase_ = RESPONSE_BUY_INTERNET_BUNDLE_FIELD_NUMBER;
    }

    private void setResponseBuyVoucher(ClubOuterClass$ResponseBuyVoucher clubOuterClass$ResponseBuyVoucher) {
        clubOuterClass$ResponseBuyVoucher.getClass();
        this.trait_ = clubOuterClass$ResponseBuyVoucher;
        this.traitCase_ = RESPONSE_BUY_VOUCHER_FIELD_NUMBER;
    }

    private void setResponseBuyWheelChance(ClubOuterClass$ResponseBuyWheelChance clubOuterClass$ResponseBuyWheelChance) {
        clubOuterClass$ResponseBuyWheelChance.getClass();
        this.trait_ = clubOuterClass$ResponseBuyWheelChance;
        this.traitCase_ = RESPONSE_BUY_WHEEL_CHANCE_FIELD_NUMBER;
    }

    private void setResponseCall(MeetOuterClass$ResponseCall meetOuterClass$ResponseCall) {
        meetOuterClass$ResponseCall.getClass();
        this.trait_ = meetOuterClass$ResponseCall;
        this.traitCase_ = RESPONSE_CALL_FIELD_NUMBER;
    }

    private void setResponseCanSeeMessages(GroupsOuterClass$ResponseCanSeeMessages groupsOuterClass$ResponseCanSeeMessages) {
        groupsOuterClass$ResponseCanSeeMessages.getClass();
        this.trait_ = groupsOuterClass$ResponseCanSeeMessages;
        this.traitCase_ = RESPONSE_CAN_SEE_MESSAGES_FIELD_NUMBER;
    }

    private void setResponseCashoutKifpool(KifpoolOuterClass$ResponseCashOutKifpool kifpoolOuterClass$ResponseCashOutKifpool) {
        kifpoolOuterClass$ResponseCashOutKifpool.getClass();
        this.trait_ = kifpoolOuterClass$ResponseCashOutKifpool;
        this.traitCase_ = RESPONSE_CASHOUT_KIFPOOL_FIELD_NUMBER;
    }

    private void setResponseChangePointToMoney(ClubOuterClass$ResponseChangePointToMoney clubOuterClass$ResponseChangePointToMoney) {
        clubOuterClass$ResponseChangePointToMoney.getClass();
        this.trait_ = clubOuterClass$ResponseChangePointToMoney;
        this.traitCase_ = RESPONSE_CHANGE_POINT_TO_MONEY_FIELD_NUMBER;
    }

    private void setResponseCharge(KifpoolOuterClass$ResponseCharge kifpoolOuterClass$ResponseCharge) {
        kifpoolOuterClass$ResponseCharge.getClass();
        this.trait_ = kifpoolOuterClass$ResponseCharge;
        this.traitCase_ = RESPONSE_CHARGE_FIELD_NUMBER;
    }

    private void setResponseCheckChargePermission(KifpoolOuterClass$ResponseCheckChargePermission kifpoolOuterClass$ResponseCheckChargePermission) {
        kifpoolOuterClass$ResponseCheckChargePermission.getClass();
        this.trait_ = kifpoolOuterClass$ResponseCheckChargePermission;
        this.traitCase_ = RESPONSE_CHECK_CHARGE_PERMISSION_FIELD_NUMBER;
    }

    private void setResponseCreateGroup(GroupsOuterClass$ResponseCreateGroup groupsOuterClass$ResponseCreateGroup) {
        groupsOuterClass$ResponseCreateGroup.getClass();
        this.trait_ = groupsOuterClass$ResponseCreateGroup;
        this.traitCase_ = 216;
    }

    private void setResponseCreateKifpool(KifpoolOuterClass$ResponseCreateKifpool kifpoolOuterClass$ResponseCreateKifpool) {
        kifpoolOuterClass$ResponseCreateKifpool.getClass();
        this.trait_ = kifpoolOuterClass$ResponseCreateKifpool;
        this.traitCase_ = RESPONSE_CREATE_KIFPOOL_FIELD_NUMBER;
    }

    private void setResponseCreateSavedBill(BillOuterClass$ResponseCreateSavedBill billOuterClass$ResponseCreateSavedBill) {
        billOuterClass$ResponseCreateSavedBill.getClass();
        this.trait_ = billOuterClass$ResponseCreateSavedBill;
        this.traitCase_ = RESPONSE_CREATE_SAVED_BILL_FIELD_NUMBER;
    }

    private void setResponseCryptoTransfer(KifpoolOuterClass$ResponseCryptoTransfer kifpoolOuterClass$ResponseCryptoTransfer) {
        kifpoolOuterClass$ResponseCryptoTransfer.getClass();
        this.trait_ = kifpoolOuterClass$ResponseCryptoTransfer;
        this.traitCase_ = RESPONSE_CRYPTO_TRANSFER_FIELD_NUMBER;
    }

    private void setResponseDialogsOrder(MessagingOuterClass$ResponseDialogsOrder messagingOuterClass$ResponseDialogsOrder) {
        messagingOuterClass$ResponseDialogsOrder.getClass();
        this.trait_ = messagingOuterClass$ResponseDialogsOrder;
        this.traitCase_ = RESPONSE_DIALOGS_ORDER_FIELD_NUMBER;
    }

    private void setResponseEditAvatar(UsersOuterClass$ResponseEditAvatar usersOuterClass$ResponseEditAvatar) {
        usersOuterClass$ResponseEditAvatar.getClass();
        this.trait_ = usersOuterClass$ResponseEditAvatar;
        this.traitCase_ = 103;
    }

    private void setResponseEditGroupAvatar(GroupsOuterClass$ResponseEditGroupAvatar groupsOuterClass$ResponseEditGroupAvatar) {
        groupsOuterClass$ResponseEditGroupAvatar.getClass();
        this.trait_ = groupsOuterClass$ResponseEditGroupAvatar;
        this.traitCase_ = 115;
    }

    private void setResponseEnrollNewCard(SapOuterClass$ResponseEnrollNewCard sapOuterClass$ResponseEnrollNewCard) {
        sapOuterClass$ResponseEnrollNewCard.getClass();
        this.trait_ = sapOuterClass$ResponseEnrollNewCard;
        this.traitCase_ = RESPONSE_ENROLL_NEW_CARD_FIELD_NUMBER;
    }

    private void setResponseFetchGroupAdmins(GroupsOuterClass$ResponseFetchGroupAdmins groupsOuterClass$ResponseFetchGroupAdmins) {
        groupsOuterClass$ResponseFetchGroupAdmins.getClass();
        this.trait_ = groupsOuterClass$ResponseFetchGroupAdmins;
        this.traitCase_ = RESPONSE_FETCH_GROUP_ADMINS_FIELD_NUMBER;
    }

    private void setResponseFilterTaggedTransactions(PfmOuterClass$ResponseFilterTaggedTransactions pfmOuterClass$ResponseFilterTaggedTransactions) {
        pfmOuterClass$ResponseFilterTaggedTransactions.getClass();
        this.trait_ = pfmOuterClass$ResponseFilterTaggedTransactions;
        this.traitCase_ = RESPONSE_FILTER_TAGGED_TRANSACTIONS_FIELD_NUMBER;
    }

    private void setResponseGetAcquiredVouchers(ClubOuterClass$ResponseGetAcquiredVouchers clubOuterClass$ResponseGetAcquiredVouchers) {
        clubOuterClass$ResponseGetAcquiredVouchers.getClass();
        this.trait_ = clubOuterClass$ResponseGetAcquiredVouchers;
        this.traitCase_ = RESPONSE_GET_ACQUIRED_VOUCHERS_FIELD_NUMBER;
    }

    private void setResponseGetAdProvider(AdvertisementOuterClass$ResponseGetAdProvider advertisementOuterClass$ResponseGetAdProvider) {
        advertisementOuterClass$ResponseGetAdProvider.getClass();
        this.trait_ = advertisementOuterClass$ResponseGetAdProvider;
        this.traitCase_ = RESPONSE_GET_AD_PROVIDER_FIELD_NUMBER;
    }

    private void setResponseGetAuthSessions(AuthOuterClass$ResponseGetAuthSessions authOuterClass$ResponseGetAuthSessions) {
        authOuterClass$ResponseGetAuthSessions.getClass();
        this.trait_ = authOuterClass$ResponseGetAuthSessions;
        this.traitCase_ = 81;
    }

    private void setResponseGetBamServiceToken(Microbanki$ResponseGetBamServiceToken microbanki$ResponseGetBamServiceToken) {
        microbanki$ResponseGetBamServiceToken.getClass();
        this.trait_ = microbanki$ResponseGetBamServiceToken;
        this.traitCase_ = RESPONSE_GET_BAM_SERVICE_TOKEN_FIELD_NUMBER;
    }

    private void setResponseGetBillHistory(BillOuterClass$ResponseGetBillHistory billOuterClass$ResponseGetBillHistory) {
        billOuterClass$ResponseGetBillHistory.getClass();
        this.trait_ = billOuterClass$ResponseGetBillHistory;
        this.traitCase_ = RESPONSE_GET_BILL_HISTORY_FIELD_NUMBER;
    }

    private void setResponseGetBotWhiteList(KetfOuterClass$ResponseGetBotWhiteList ketfOuterClass$ResponseGetBotWhiteList) {
        ketfOuterClass$ResponseGetBotWhiteList.getClass();
        this.trait_ = ketfOuterClass$ResponseGetBotWhiteList;
        this.traitCase_ = RESPONSE_GET_BOT_WHITE_LIST_FIELD_NUMBER;
    }

    private void setResponseGetCardInfo(SapOuterClass$ResponseGetCardInfo sapOuterClass$ResponseGetCardInfo) {
        sapOuterClass$ResponseGetCardInfo.getClass();
        this.trait_ = sapOuterClass$ResponseGetCardInfo;
        this.traitCase_ = RESPONSE_GET_CARD_INFO_FIELD_NUMBER;
    }

    private void setResponseGetCardTransferToken(BankOuterClass$ResponseGetCardTransferToken bankOuterClass$ResponseGetCardTransferToken) {
        bankOuterClass$ResponseGetCardTransferToken.getClass();
        this.trait_ = bankOuterClass$ResponseGetCardTransferToken;
        this.traitCase_ = RESPONSE_GET_CARD_TRANSFER_TOKEN_FIELD_NUMBER;
    }

    private void setResponseGetCards(SapOuterClass$ResponseGetCards sapOuterClass$ResponseGetCards) {
        sapOuterClass$ResponseGetCards.getClass();
        this.trait_ = sapOuterClass$ResponseGetCards;
        this.traitCase_ = RESPONSE_GET_CARDS_FIELD_NUMBER;
    }

    private void setResponseGetChannelAds(AdvertisementOuterClass$ResponseGetChannelAds advertisementOuterClass$ResponseGetChannelAds) {
        advertisementOuterClass$ResponseGetChannelAds.getClass();
        this.trait_ = advertisementOuterClass$ResponseGetChannelAds;
        this.traitCase_ = RESPONSE_GET_CHANNEL_ADS_FIELD_NUMBER;
    }

    private void setResponseGetChannelEarnMoneyInfo(AdvertisementOuterClass$ResponseGetChannelEarnMoneyInfo advertisementOuterClass$ResponseGetChannelEarnMoneyInfo) {
        advertisementOuterClass$ResponseGetChannelEarnMoneyInfo.getClass();
        this.trait_ = advertisementOuterClass$ResponseGetChannelEarnMoneyInfo;
        this.traitCase_ = RESPONSE_GET_CHANNEL_EARN_MONEY_INFO_FIELD_NUMBER;
    }

    private void setResponseGetChannelEarnMoneyStatus(AdvertisementOuterClass$ResponseGetChannelEarnMoneyStatus advertisementOuterClass$ResponseGetChannelEarnMoneyStatus) {
        advertisementOuterClass$ResponseGetChannelEarnMoneyStatus.getClass();
        this.trait_ = advertisementOuterClass$ResponseGetChannelEarnMoneyStatus;
        this.traitCase_ = RESPONSE_GET_CHANNEL_EARN_MONEY_STATUS_FIELD_NUMBER;
    }

    private void setResponseGetChargeAmounts(Saba$ResponseGetChargeAmounts saba$ResponseGetChargeAmounts) {
        saba$ResponseGetChargeAmounts.getClass();
        this.trait_ = saba$ResponseGetChargeAmounts;
        this.traitCase_ = RESPONSE_GET_CHARGE_AMOUNTS_FIELD_NUMBER;
    }

    private void setResponseGetChargePaymentToken(KifpoolOuterClass$ResponseGetChargePaymentToken kifpoolOuterClass$ResponseGetChargePaymentToken) {
        kifpoolOuterClass$ResponseGetChargePaymentToken.getClass();
        this.trait_ = kifpoolOuterClass$ResponseGetChargePaymentToken;
        this.traitCase_ = RESPONSE_GET_CHARGE_PAYMENT_TOKEN_FIELD_NUMBER;
    }

    private void setResponseGetCitiesOfState(SefteOuterClass$ResponseGetCitiesOfState sefteOuterClass$ResponseGetCitiesOfState) {
        sefteOuterClass$ResponseGetCitiesOfState.getClass();
        this.trait_ = sefteOuterClass$ResponseGetCitiesOfState;
        this.traitCase_ = RESPONSE_GET_CITIES_OF_STATE_FIELD_NUMBER;
    }

    private void setResponseGetContacts(UsersOuterClass$ResponseGetContacts usersOuterClass$ResponseGetContacts) {
        usersOuterClass$ResponseGetContacts.getClass();
        this.trait_ = usersOuterClass$ResponseGetContacts;
        this.traitCase_ = 88;
    }

    private void setResponseGetCryptoWallets(KifpoolOuterClass$ResponseGetCryptoWallets kifpoolOuterClass$ResponseGetCryptoWallets) {
        kifpoolOuterClass$ResponseGetCryptoWallets.getClass();
        this.trait_ = kifpoolOuterClass$ResponseGetCryptoWallets;
        this.traitCase_ = RESPONSE_GET_CRYPTO_WALLETS_FIELD_NUMBER;
    }

    private void setResponseGetDefaultCard(SapOuterClass$ResponseGetDefaultCard sapOuterClass$ResponseGetDefaultCard) {
        sapOuterClass$ResponseGetDefaultCard.getClass();
        this.trait_ = sapOuterClass$ResponseGetDefaultCard;
        this.traitCase_ = RESPONSE_GET_DEFAULT_CARD_FIELD_NUMBER;
    }

    private void setResponseGetDestinationCardInfo(SapOuterClass$ResponseGetDestinationCardInfo sapOuterClass$ResponseGetDestinationCardInfo) {
        sapOuterClass$ResponseGetDestinationCardInfo.getClass();
        this.trait_ = sapOuterClass$ResponseGetDestinationCardInfo;
        this.traitCase_ = RESPONSE_GET_DESTINATION_CARD_INFO_FIELD_NUMBER;
    }

    private void setResponseGetDestinationCards(SapOuterClass$ResponseGetDestinationCards sapOuterClass$ResponseGetDestinationCards) {
        sapOuterClass$ResponseGetDestinationCards.getClass();
        this.trait_ = sapOuterClass$ResponseGetDestinationCards;
        this.traitCase_ = RESPONSE_GET_DESTINATION_CARDS_FIELD_NUMBER;
    }

    private void setResponseGetDialogAdOrderDetails(AdvertisementOuterClass$ResponseGetDialogAdOrderDetails advertisementOuterClass$ResponseGetDialogAdOrderDetails) {
        advertisementOuterClass$ResponseGetDialogAdOrderDetails.getClass();
        this.trait_ = advertisementOuterClass$ResponseGetDialogAdOrderDetails;
        this.traitCase_ = RESPONSE_GET_DIALOG_AD_ORDER_DETAILS_FIELD_NUMBER;
    }

    private void setResponseGetDialogAdOrderPaymentToken(AdvertisementOuterClass$ResponseGetDialogAdOrderPaymentToken advertisementOuterClass$ResponseGetDialogAdOrderPaymentToken) {
        advertisementOuterClass$ResponseGetDialogAdOrderPaymentToken.getClass();
        this.trait_ = advertisementOuterClass$ResponseGetDialogAdOrderPaymentToken;
        this.traitCase_ = RESPONSE_GET_DIALOG_AD_ORDER_PAYMENT_TOKEN_FIELD_NUMBER;
    }

    private void setResponseGetGiftPacketPaymentToken(Giftpacket$ResponseGetGiftPacketPaymentToken giftpacket$ResponseGetGiftPacketPaymentToken) {
        giftpacket$ResponseGetGiftPacketPaymentToken.getClass();
        this.trait_ = giftpacket$ResponseGetGiftPacketPaymentToken;
        this.traitCase_ = RESPONSE_GET_GIFT_PACKET_PAYMENT_TOKEN_FIELD_NUMBER;
    }

    private void setResponseGetGroupDefaultCardNumber(GroupsOuterClass$ResponseGetGroupDefaultCardNumber groupsOuterClass$ResponseGetGroupDefaultCardNumber) {
        groupsOuterClass$ResponseGetGroupDefaultCardNumber.getClass();
        this.trait_ = groupsOuterClass$ResponseGetGroupDefaultCardNumber;
        this.traitCase_ = 130;
    }

    private void setResponseGetGroupDifference(Sequence$ResponseGetGroupDifference sequence$ResponseGetGroupDifference) {
        sequence$ResponseGetGroupDifference.getClass();
        this.trait_ = sequence$ResponseGetGroupDifference;
        this.traitCase_ = RESPONSE_GET_GROUP_DIFFERENCE_FIELD_NUMBER;
    }

    private void setResponseGetGroupMembersCount(GroupsOuterClass$ResponseGetGroupMembersCount groupsOuterClass$ResponseGetGroupMembersCount) {
        groupsOuterClass$ResponseGetGroupMembersCount.getClass();
        this.trait_ = groupsOuterClass$ResponseGetGroupMembersCount;
        this.traitCase_ = RESPONSE_GET_GROUP_MEMBERS_COUNT_FIELD_NUMBER;
    }

    private void setResponseGetGroupMembersPresence(PresenceOuterClass$ResponseGetGroupMembersPresence presenceOuterClass$ResponseGetGroupMembersPresence) {
        presenceOuterClass$ResponseGetGroupMembersPresence.getClass();
        this.trait_ = presenceOuterClass$ResponseGetGroupMembersPresence;
        this.traitCase_ = RESPONSE_GET_GROUP_MEMBERS_PRESENCE_FIELD_NUMBER;
    }

    private void setResponseGetGroupState(Sequence$ResponseGetGroupState sequence$ResponseGetGroupState) {
        sequence$ResponseGetGroupState.getClass();
        this.trait_ = sequence$ResponseGetGroupState;
        this.traitCase_ = 23;
    }

    private void setResponseGetInternetBundleList(Charnet$ResponseGetInternetBundleList charnet$ResponseGetInternetBundleList) {
        charnet$ResponseGetInternetBundleList.getClass();
        this.trait_ = charnet$ResponseGetInternetBundleList;
        this.traitCase_ = RESPONSE_GET_INTERNET_BUNDLE_LIST_FIELD_NUMBER;
    }

    private void setResponseGetInternetBundlePaymentToken(Charnet$ResponseGetInternetBundlePaymentToken charnet$ResponseGetInternetBundlePaymentToken) {
        charnet$ResponseGetInternetBundlePaymentToken.getClass();
        this.trait_ = charnet$ResponseGetInternetBundlePaymentToken;
        this.traitCase_ = RESPONSE_GET_INTERNET_BUNDLE_PAYMENT_TOKEN_FIELD_NUMBER;
    }

    private void setResponseGetJwtToken(AuthOuterClass$ResponseGetJWTToken authOuterClass$ResponseGetJWTToken) {
        authOuterClass$ResponseGetJWTToken.getClass();
        this.trait_ = authOuterClass$ResponseGetJWTToken;
        this.traitCase_ = RESPONSE_GET_JWT_TOKEN_FIELD_NUMBER;
    }

    private void setResponseGetKifpoolOwner(KifpoolOuterClass$ResponseGetKifpoolOwner kifpoolOuterClass$ResponseGetKifpoolOwner) {
        kifpoolOuterClass$ResponseGetKifpoolOwner.getClass();
        this.trait_ = kifpoolOuterClass$ResponseGetKifpoolOwner;
        this.traitCase_ = RESPONSE_GET_KIFPOOL_OWNER_FIELD_NUMBER;
    }

    private void setResponseGetLinkPreview(EnrichmentOuterClass$ResponseGetLinkPreview enrichmentOuterClass$ResponseGetLinkPreview) {
        enrichmentOuterClass$ResponseGetLinkPreview.getClass();
        this.trait_ = enrichmentOuterClass$ResponseGetLinkPreview;
        this.traitCase_ = RESPONSE_GET_LINK_PREVIEW_FIELD_NUMBER;
    }

    private void setResponseGetLoanInfo(MelonOuterClass$ResponseGetLoanInfo melonOuterClass$ResponseGetLoanInfo) {
        melonOuterClass$ResponseGetLoanInfo.getClass();
        this.trait_ = melonOuterClass$ResponseGetLoanInfo;
        this.traitCase_ = RESPONSE_GET_LOAN_INFO_FIELD_NUMBER;
    }

    private void setResponseGetLoansList(MelonOuterClass$ResponseGetLoansList melonOuterClass$ResponseGetLoansList) {
        melonOuterClass$ResponseGetLoansList.getClass();
        this.trait_ = melonOuterClass$ResponseGetLoansList;
        this.traitCase_ = RESPONSE_GET_LOANS_LIST_FIELD_NUMBER;
    }

    private void setResponseGetMemberPermissions(GroupsOuterClass$ResponseGetMemberPermissions groupsOuterClass$ResponseGetMemberPermissions) {
        groupsOuterClass$ResponseGetMemberPermissions.getClass();
        this.trait_ = groupsOuterClass$ResponseGetMemberPermissions;
        this.traitCase_ = RESPONSE_GET_MEMBER_PERMISSIONS_FIELD_NUMBER;
    }

    private void setResponseGetMessagesRepliesInfo(MessagingOuterClass$ResponseGetMessagesRepliesInfo messagingOuterClass$ResponseGetMessagesRepliesInfo) {
        messagingOuterClass$ResponseGetMessagesRepliesInfo.getClass();
        this.trait_ = messagingOuterClass$ResponseGetMessagesRepliesInfo;
        this.traitCase_ = RESPONSE_GET_MESSAGES_REPLIES_INFO_FIELD_NUMBER;
    }

    private void setResponseGetMoneyRequestDetails(Microbanki$ResponseGetMoneyRequestDetails microbanki$ResponseGetMoneyRequestDetails) {
        microbanki$ResponseGetMoneyRequestDetails.getClass();
        this.trait_ = microbanki$ResponseGetMoneyRequestDetails;
        this.traitCase_ = RESPONSE_GET_MONEY_REQUEST_DETAILS_FIELD_NUMBER;
    }

    private void setResponseGetMoneyRequestPaymentList(Microbanki$ResponseGetMoneyRequestPaymentList microbanki$ResponseGetMoneyRequestPaymentList) {
        microbanki$ResponseGetMoneyRequestPaymentList.getClass();
        this.trait_ = microbanki$ResponseGetMoneyRequestPaymentList;
        this.traitCase_ = RESPONSE_GET_MONEY_REQUEST_PAYMENT_LIST_FIELD_NUMBER;
    }

    private void setResponseGetMoneyRequestPaymentTokenByCard(WalletOuterClass$ResponseGetMoneyRequestPaymentTokenByCard walletOuterClass$ResponseGetMoneyRequestPaymentTokenByCard) {
        walletOuterClass$ResponseGetMoneyRequestPaymentTokenByCard.getClass();
        this.trait_ = walletOuterClass$ResponseGetMoneyRequestPaymentTokenByCard;
        this.traitCase_ = RESPONSE_GET_MONEY_REQUEST_PAYMENT_TOKEN_BY_CARD_FIELD_NUMBER;
    }

    private void setResponseGetMyBank(MyBankOuterClass$ResponseGetMyBank myBankOuterClass$ResponseGetMyBank) {
        myBankOuterClass$ResponseGetMyBank.getClass();
        this.trait_ = myBankOuterClass$ResponseGetMyBank;
        this.traitCase_ = RESPONSE_GET_MY_BANK_FIELD_NUMBER;
    }

    private void setResponseGetMyGroups(GroupsOuterClass$ResponseGetMyGroups groupsOuterClass$ResponseGetMyGroups) {
        groupsOuterClass$ResponseGetMyGroups.getClass();
        this.trait_ = groupsOuterClass$ResponseGetMyGroups;
        this.traitCase_ = RESPONSE_GET_MY_GROUPS_FIELD_NUMBER;
    }

    private void setResponseGetMyKifpools(KifpoolOuterClass$ResponseGetMyKifpools kifpoolOuterClass$ResponseGetMyKifpools) {
        kifpoolOuterClass$ResponseGetMyKifpools.getClass();
        this.trait_ = kifpoolOuterClass$ResponseGetMyKifpools;
        this.traitCase_ = RESPONSE_GET_MY_KIFPOOLS_FIELD_NUMBER;
    }

    private void setResponseGetMySentence(SentenceOuterClass$ResponseGetMySentence sentenceOuterClass$ResponseGetMySentence) {
        sentenceOuterClass$ResponseGetMySentence.getClass();
        this.trait_ = sentenceOuterClass$ResponseGetMySentence;
        this.traitCase_ = RESPONSE_GET_MY_SENTENCE_FIELD_NUMBER;
    }

    private void setResponseGetMyWallets(WalletOuterClass$ResponseGetMyWallets walletOuterClass$ResponseGetMyWallets) {
        walletOuterClass$ResponseGetMyWallets.getClass();
        this.trait_ = walletOuterClass$ResponseGetMyWallets;
        this.traitCase_ = RESPONSE_GET_MY_WALLETS_FIELD_NUMBER;
    }

    private void setResponseGetNasimFilePublicUrl(FilesOuterClass$ResponseGetNasimFilePublicUrl filesOuterClass$ResponseGetNasimFilePublicUrl) {
        filesOuterClass$ResponseGetNasimFilePublicUrl.getClass();
        this.trait_ = filesOuterClass$ResponseGetNasimFilePublicUrl;
        this.traitCase_ = RESPONSE_GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER;
    }

    private void setResponseGetNasimFileUploadResume(FilesOuterClass$ResponseGetNasimFileUploadResume filesOuterClass$ResponseGetNasimFileUploadResume) {
        filesOuterClass$ResponseGetNasimFileUploadResume.getClass();
        this.trait_ = filesOuterClass$ResponseGetNasimFileUploadResume;
        this.traitCase_ = RESPONSE_GET_NASIM_FILE_UPLOAD_RESUME_FIELD_NUMBER;
    }

    private void setResponseGetNasimFileUploadUrl(FilesOuterClass$ResponseGetNasimFileUploadUrl filesOuterClass$ResponseGetNasimFileUploadUrl) {
        filesOuterClass$ResponseGetNasimFileUploadUrl.getClass();
        this.trait_ = filesOuterClass$ResponseGetNasimFileUploadUrl;
        this.traitCase_ = RESPONSE_GET_NASIM_FILE_UPLOAD_URL_FIELD_NUMBER;
    }

    private void setResponseGetNasimFileUrl(FilesOuterClass$ResponseGetNasimFileUrl filesOuterClass$ResponseGetNasimFileUrl) {
        filesOuterClass$ResponseGetNasimFileUrl.getClass();
        this.trait_ = filesOuterClass$ResponseGetNasimFileUrl;
        this.traitCase_ = RESPONSE_GET_NASIM_FILE_URL_FIELD_NUMBER;
    }

    private void setResponseGetNasimFileUrls(FilesOuterClass$ResponseGetNasimFileUrls filesOuterClass$ResponseGetNasimFileUrls) {
        filesOuterClass$ResponseGetNasimFileUrls.getClass();
        this.trait_ = filesOuterClass$ResponseGetNasimFileUrls;
        this.traitCase_ = RESPONSE_GET_NASIM_FILE_URLS_FIELD_NUMBER;
    }

    private void setResponseGetOtpTokenV2(BankOuterClass$ResponseGetOTPTokenV2 bankOuterClass$ResponseGetOTPTokenV2) {
        bankOuterClass$ResponseGetOTPTokenV2.getClass();
        this.trait_ = bankOuterClass$ResponseGetOTPTokenV2;
        this.traitCase_ = RESPONSE_GET_OTP_TOKEN_V2_FIELD_NUMBER;
    }

    private void setResponseGetOtptoken(BankOuterClass$ResponseGetOTPToken bankOuterClass$ResponseGetOTPToken) {
        bankOuterClass$ResponseGetOTPToken.getClass();
        this.trait_ = bankOuterClass$ResponseGetOTPToken;
        this.traitCase_ = RESPONSE_GET_OTPTOKEN_FIELD_NUMBER;
    }

    private void setResponseGetPacketsStatus(WarriorOuterClass$ResponseGetPacketsStatus warriorOuterClass$ResponseGetPacketsStatus) {
        warriorOuterClass$ResponseGetPacketsStatus.getClass();
        this.trait_ = warriorOuterClass$ResponseGetPacketsStatus;
        this.traitCase_ = RESPONSE_GET_PACKETS_STATUS_FIELD_NUMBER;
    }

    private void setResponseGetParameters(ConfigsOuterClass$ResponseGetParameters configsOuterClass$ResponseGetParameters) {
        configsOuterClass$ResponseGetParameters.getClass();
        this.trait_ = configsOuterClass$ResponseGetParameters;
        this.traitCase_ = 135;
    }

    private void setResponseGetParticipants(Crowdfunding$ResponseGetParticipants crowdfunding$ResponseGetParticipants) {
        crowdfunding$ResponseGetParticipants.getClass();
        this.trait_ = crowdfunding$ResponseGetParticipants;
        this.traitCase_ = RESPONSE_GET_PARTICIPANTS_FIELD_NUMBER;
    }

    private void setResponseGetPayMoneyRequestToken(BankOuterClass$ResponseGetPayMoneyRequestToken bankOuterClass$ResponseGetPayMoneyRequestToken) {
        bankOuterClass$ResponseGetPayMoneyRequestToken.getClass();
        this.trait_ = bankOuterClass$ResponseGetPayMoneyRequestToken;
        this.traitCase_ = RESPONSE_GET_PAY_MONEY_REQUEST_TOKEN_FIELD_NUMBER;
    }

    private void setResponseGetPaymentToken(BankOuterClass$ResponseGetPaymentToken bankOuterClass$ResponseGetPaymentToken) {
        bankOuterClass$ResponseGetPaymentToken.getClass();
        this.trait_ = bankOuterClass$ResponseGetPaymentToken;
        this.traitCase_ = RESPONSE_GET_PAYMENT_TOKEN_FIELD_NUMBER;
    }

    private void setResponseGetPaymentTokenByCard(WalletOuterClass$ResponseGetPaymentTokenByCard walletOuterClass$ResponseGetPaymentTokenByCard) {
        walletOuterClass$ResponseGetPaymentTokenByCard.getClass();
        this.trait_ = walletOuterClass$ResponseGetPaymentTokenByCard;
        this.traitCase_ = RESPONSE_GET_PAYMENT_TOKEN_BY_CARD_FIELD_NUMBER;
    }

    private void setResponseGetPayvandCard(BankOuterClass$ResponseGetPayvandCard bankOuterClass$ResponseGetPayvandCard) {
        bankOuterClass$ResponseGetPayvandCard.getClass();
        this.trait_ = bankOuterClass$ResponseGetPayvandCard;
        this.traitCase_ = RESPONSE_GET_PAYVAND_CARD_FIELD_NUMBER;
    }

    private void setResponseGetPayvandCardList(BankOuterClass$ResponseGetPayvandCardList bankOuterClass$ResponseGetPayvandCardList) {
        bankOuterClass$ResponseGetPayvandCardList.getClass();
        this.trait_ = bankOuterClass$ResponseGetPayvandCardList;
        this.traitCase_ = RESPONSE_GET_PAYVAND_CARD_LIST_FIELD_NUMBER;
    }

    private void setResponseGetPointBalance(KifpoolOuterClass$ResponseGetPointBalance kifpoolOuterClass$ResponseGetPointBalance) {
        kifpoolOuterClass$ResponseGetPointBalance.getClass();
        this.trait_ = kifpoolOuterClass$ResponseGetPointBalance;
        this.traitCase_ = RESPONSE_GET_POINT_BALANCE_FIELD_NUMBER;
    }

    private void setResponseGetPointDetails(KifpoolOuterClass$ResponseGetPointDetails kifpoolOuterClass$ResponseGetPointDetails) {
        kifpoolOuterClass$ResponseGetPointDetails.getClass();
        this.trait_ = kifpoolOuterClass$ResponseGetPointDetails;
        this.traitCase_ = RESPONSE_GET_POINT_DETAILS_FIELD_NUMBER;
    }

    private void setResponseGetPointSummery(KifpoolOuterClass$ResponseGetPointSummery kifpoolOuterClass$ResponseGetPointSummery) {
        kifpoolOuterClass$ResponseGetPointSummery.getClass();
        this.trait_ = kifpoolOuterClass$ResponseGetPointSummery;
        this.traitCase_ = RESPONSE_GET_POINT_SUMMERY_FIELD_NUMBER;
    }

    private void setResponseGetPspPaymentToken(Saba$ResponseGetPspPaymentToken saba$ResponseGetPspPaymentToken) {
        saba$ResponseGetPspPaymentToken.getClass();
        this.trait_ = saba$ResponseGetPspPaymentToken;
        this.traitCase_ = RESPONSE_GET_PSP_PAYMENTTOKEN_FIELD_NUMBER;
    }

    private void setResponseGetPsproxyPaymentToken(BankOuterClass$ResponseGetPSProxyPaymentToken bankOuterClass$ResponseGetPSProxyPaymentToken) {
        bankOuterClass$ResponseGetPSProxyPaymentToken.getClass();
        this.trait_ = bankOuterClass$ResponseGetPSProxyPaymentToken;
        this.traitCase_ = RESPONSE_GET_PSPROXY_PAYMENT_TOKEN_FIELD_NUMBER;
    }

    private void setResponseGetPsproxyToken(BankOuterClass$ResponseGetPSProxyToken bankOuterClass$ResponseGetPSProxyToken) {
        bankOuterClass$ResponseGetPSProxyToken.getClass();
        this.trait_ = bankOuterClass$ResponseGetPSProxyToken;
        this.traitCase_ = RESPONSE_GET_PSPROXY_TOKEN_FIELD_NUMBER;
    }

    private void setResponseGetReactions(ReactionsOuterClass$ResponseGetReactions reactionsOuterClass$ResponseGetReactions) {
        reactionsOuterClass$ResponseGetReactions.getClass();
        this.trait_ = reactionsOuterClass$ResponseGetReactions;
        this.traitCase_ = RESPONSE_GET_REACTIONS_FIELD_NUMBER;
    }

    private void setResponseGetRecentCharges(BankOuterClass$ResponseGetRecentCharges bankOuterClass$ResponseGetRecentCharges) {
        bankOuterClass$ResponseGetRecentCharges.getClass();
        this.trait_ = bankOuterClass$ResponseGetRecentCharges;
        this.traitCase_ = RESPONSE_GET_RECENT_CHARGES_FIELD_NUMBER;
    }

    private void setResponseGetRecentInternetBundleOrders(Charnet$ResponseGetRecentInternetBundleOrders charnet$ResponseGetRecentInternetBundleOrders) {
        charnet$ResponseGetRecentInternetBundleOrders.getClass();
        this.trait_ = charnet$ResponseGetRecentInternetBundleOrders;
        this.traitCase_ = RESPONSE_GET_RECENT_INTERNET_BUNDLE_ORDERS_FIELD_NUMBER;
    }

    private void setResponseGetRecentOrders(Saba$ResponseGetRecentOrders saba$ResponseGetRecentOrders) {
        saba$ResponseGetRecentOrders.getClass();
        this.trait_ = saba$ResponseGetRecentOrders;
        this.traitCase_ = RESPONSE_GET_RECENT_ORDERS_FIELD_NUMBER;
    }

    private void setResponseGetRecipients(SefteOuterClass$ResponseGetRecipients sefteOuterClass$ResponseGetRecipients) {
        sefteOuterClass$ResponseGetRecipients.getClass();
        this.trait_ = sefteOuterClass$ResponseGetRecipients;
        this.traitCase_ = RESPONSE_GET_RECIPIENTS_FIELD_NUMBER;
    }

    private void setResponseGetReferencedEntitites(Sequence$ResponseGetReferencedEntitites sequence$ResponseGetReferencedEntitites) {
        sequence$ResponseGetReferencedEntitites.getClass();
        this.trait_ = sequence$ResponseGetReferencedEntitites;
        this.traitCase_ = 2629;
    }

    private void setResponseGetReferralCode(ReferralOuterClass$ResponseGetReferralCode referralOuterClass$ResponseGetReferralCode) {
        referralOuterClass$ResponseGetReferralCode.getClass();
        this.trait_ = referralOuterClass$ResponseGetReferralCode;
        this.traitCase_ = RESPONSE_GET_REFERRAL_CODE_FIELD_NUMBER;
    }

    private void setResponseGetReferralContacts(WarriorOuterClass$ResponseGetReferralContacts warriorOuterClass$ResponseGetReferralContacts) {
        warriorOuterClass$ResponseGetReferralContacts.getClass();
        this.trait_ = warriorOuterClass$ResponseGetReferralContacts;
        this.traitCase_ = RESPONSE_GET_REFERRAL_CONTACTS_FIELD_NUMBER;
    }

    private void setResponseGetReferredCount(ReferralOuterClass$ResponseGetReferredCount referralOuterClass$ResponseGetReferredCount) {
        referralOuterClass$ResponseGetReferredCount.getClass();
        this.trait_ = referralOuterClass$ResponseGetReferredCount;
        this.traitCase_ = RESPONSE_GET_REFERRED_COUNT_FIELD_NUMBER;
    }

    private void setResponseGetReferringUser(ReferralOuterClass$ResponseGetReferringUser referralOuterClass$ResponseGetReferringUser) {
        referralOuterClass$ResponseGetReferringUser.getClass();
        this.trait_ = referralOuterClass$ResponseGetReferringUser;
        this.traitCase_ = RESPONSE_GET_REFERRING_USER_FIELD_NUMBER;
    }

    private void setResponseGetRemainToken(BankOuterClass$ResponseGetRemainToken bankOuterClass$ResponseGetRemainToken) {
        bankOuterClass$ResponseGetRemainToken.getClass();
        this.trait_ = bankOuterClass$ResponseGetRemainToken;
        this.traitCase_ = RESPONSE_GET_REMAIN_TOKEN_FIELD_NUMBER;
    }

    private void setResponseGetSadadPsppaymentToken(BankOuterClass$ResponseGetSadadPSPPaymentToken bankOuterClass$ResponseGetSadadPSPPaymentToken) {
        bankOuterClass$ResponseGetSadadPSPPaymentToken.getClass();
        this.trait_ = bankOuterClass$ResponseGetSadadPSPPaymentToken;
        this.traitCase_ = RESPONSE_GET_SADAD_PSPPAYMENT_TOKEN_FIELD_NUMBER;
    }

    private void setResponseGetSavedBills(BillOuterClass$ResponseGetSavedBills billOuterClass$ResponseGetSavedBills) {
        billOuterClass$ResponseGetSavedBills.getClass();
        this.trait_ = billOuterClass$ResponseGetSavedBills;
        this.traitCase_ = RESPONSE_GET_SAVED_BILLS_FIELD_NUMBER;
    }

    private void setResponseGetScoreBoard(WarriorOuterClass$ResponseGetScoreBoard warriorOuterClass$ResponseGetScoreBoard) {
        warriorOuterClass$ResponseGetScoreBoard.getClass();
        this.trait_ = warriorOuterClass$ResponseGetScoreBoard;
        this.traitCase_ = RESPONSE_GET_SCORE_BOARD_FIELD_NUMBER;
    }

    private void setResponseGetStates(SefteOuterClass$ResponseGetStates sefteOuterClass$ResponseGetStates) {
        sefteOuterClass$ResponseGetStates.getClass();
        this.trait_ = sefteOuterClass$ResponseGetStates;
        this.traitCase_ = RESPONSE_GET_STATES_FIELD_NUMBER;
    }

    private void setResponseGetSubTransactions(PfmOuterClass$ResponseGetSubTransactions pfmOuterClass$ResponseGetSubTransactions) {
        pfmOuterClass$ResponseGetSubTransactions.getClass();
        this.trait_ = pfmOuterClass$ResponseGetSubTransactions;
        this.traitCase_ = RESPONSE_GET_SUB_TRANSACTIONS_FIELD_NUMBER;
    }

    private void setResponseGetTicket(AuthOuterClass$ResponseGetTicket authOuterClass$ResponseGetTicket) {
        authOuterClass$ResponseGetTicket.getClass();
        this.trait_ = authOuterClass$ResponseGetTicket;
        this.traitCase_ = RESPONSE_GET_TICKET_FIELD_NUMBER;
    }

    private void setResponseGetTotalPaidAmount(Crowdfunding$ResponseGetTotalPaidAmount crowdfunding$ResponseGetTotalPaidAmount) {
        crowdfunding$ResponseGetTotalPaidAmount.getClass();
        this.trait_ = crowdfunding$ResponseGetTotalPaidAmount;
        this.traitCase_ = RESPONSE_GET_TOTAL_PAID_AMOUNT_FIELD_NUMBER;
    }

    private void setResponseGetTransactionTags(PfmOuterClass$ResponseGetTransactionTags pfmOuterClass$ResponseGetTransactionTags) {
        pfmOuterClass$ResponseGetTransactionTags.getClass();
        this.trait_ = pfmOuterClass$ResponseGetTransactionTags;
        this.traitCase_ = RESPONSE_GET_TRANSACTION_TAGS_FIELD_NUMBER;
    }

    private void setResponseGetUserAccounts(PfmOuterClass$ResponseGetUserAccounts pfmOuterClass$ResponseGetUserAccounts) {
        pfmOuterClass$ResponseGetUserAccounts.getClass();
        this.trait_ = pfmOuterClass$ResponseGetUserAccounts;
        this.traitCase_ = RESPONSE_GET_USER_ACCOUNTS_FIELD_NUMBER;
    }

    private void setResponseGetUserBank(VitrineOuterClass$ResponseGetUserBank vitrineOuterClass$ResponseGetUserBank) {
        vitrineOuterClass$ResponseGetUserBank.getClass();
        this.trait_ = vitrineOuterClass$ResponseGetUserBank;
        this.traitCase_ = RESPONSE_GET_USER_BANK_FIELD_NUMBER;
    }

    private void setResponseGetUserContext(KetfOuterClass$ResponseGetUserContext ketfOuterClass$ResponseGetUserContext) {
        ketfOuterClass$ResponseGetUserContext.getClass();
        this.trait_ = ketfOuterClass$ResponseGetUserContext;
        this.traitCase_ = RESPONSE_GET_USER_CONTEXT_FIELD_NUMBER;
    }

    private void setResponseGetUserRefers(WarriorOuterClass$ResponseGetUserRefers warriorOuterClass$ResponseGetUserRefers) {
        warriorOuterClass$ResponseGetUserRefers.getClass();
        this.trait_ = warriorOuterClass$ResponseGetUserRefers;
        this.traitCase_ = RESPONSE_GET_USER_REFERS_FIELD_NUMBER;
    }

    private void setResponseGetUserScore(WarriorOuterClass$ResponseGetUserScore warriorOuterClass$ResponseGetUserScore) {
        warriorOuterClass$ResponseGetUserScore.getClass();
        this.trait_ = warriorOuterClass$ResponseGetUserScore;
        this.traitCase_ = RESPONSE_GET_USER_SCORE_FIELD_NUMBER;
    }

    private void setResponseGetUserSeftes(SefteOuterClass$ResponseGetUserSeftes sefteOuterClass$ResponseGetUserSeftes) {
        sefteOuterClass$ResponseGetUserSeftes.getClass();
        this.trait_ = sefteOuterClass$ResponseGetUserSeftes;
        this.traitCase_ = RESPONSE_GET_USER_SEFTES_FIELD_NUMBER;
    }

    private void setResponseGetUserStatus(AdvertisementOuterClass$ResponseGetUserStatus advertisementOuterClass$ResponseGetUserStatus) {
        advertisementOuterClass$ResponseGetUserStatus.getClass();
        this.trait_ = advertisementOuterClass$ResponseGetUserStatus;
        this.traitCase_ = RESPONSE_GET_USER_STATUS_FIELD_NUMBER;
    }

    private void setResponseGetUserTags(PfmOuterClass$ResponseGetUserTags pfmOuterClass$ResponseGetUserTags) {
        pfmOuterClass$ResponseGetUserTags.getClass();
        this.trait_ = pfmOuterClass$ResponseGetUserTags;
        this.traitCase_ = RESPONSE_GET_USER_TAGS_FIELD_NUMBER;
    }

    private void setResponseGetUserVitrine(VitrineOuterClass$ResponseGetUserVitrine vitrineOuterClass$ResponseGetUserVitrine) {
        vitrineOuterClass$ResponseGetUserVitrine.getClass();
        this.trait_ = vitrineOuterClass$ResponseGetUserVitrine;
        this.traitCase_ = RESPONSE_GET_USER_VITRINE_FIELD_NUMBER;
    }

    private void setResponseGetUsersDefaultCardNumber(UsersOuterClass$ResponseGetUsersDefaultCardNumber usersOuterClass$ResponseGetUsersDefaultCardNumber) {
        usersOuterClass$ResponseGetUsersDefaultCardNumber.getClass();
        this.trait_ = usersOuterClass$ResponseGetUsersDefaultCardNumber;
        this.traitCase_ = RESPONSE_GET_USERS_DEFAULT_CARD_NUMBER_FIELD_NUMBER;
    }

    private void setResponseGetUsersPresence(PresenceOuterClass$ResponseGetUsersPresence presenceOuterClass$ResponseGetUsersPresence) {
        presenceOuterClass$ResponseGetUsersPresence.getClass();
        this.trait_ = presenceOuterClass$ResponseGetUsersPresence;
        this.traitCase_ = RESPONSE_GET_USERS_PRESENCE_FIELD_NUMBER;
    }

    private void setResponseGetVouchers(ClubOuterClass$ResponseGetVouchers clubOuterClass$ResponseGetVouchers) {
        clubOuterClass$ResponseGetVouchers.getClass();
        this.trait_ = clubOuterClass$ResponseGetVouchers;
        this.traitCase_ = RESPONSE_GET_VOUCHERS_FIELD_NUMBER;
    }

    private void setResponseGetWalletChargeToken(WalletOuterClass$ResponseGetWalletChargeToken walletOuterClass$ResponseGetWalletChargeToken) {
        walletOuterClass$ResponseGetWalletChargeToken.getClass();
        this.trait_ = walletOuterClass$ResponseGetWalletChargeToken;
        this.traitCase_ = RESPONSE_GET_WALLET_CHARGE_TOKEN_FIELD_NUMBER;
    }

    private void setResponseGetWalletContracts(WalletOuterClass$ResponseGetWalletContracts walletOuterClass$ResponseGetWalletContracts) {
        walletOuterClass$ResponseGetWalletContracts.getClass();
        this.trait_ = walletOuterClass$ResponseGetWalletContracts;
        this.traitCase_ = RESPONSE_GET_WALLET_CONTRACTS_FIELD_NUMBER;
    }

    private void setResponseGetWalletInvoice(WalletOuterClass$ResponseGetWalletInvoice walletOuterClass$ResponseGetWalletInvoice) {
        walletOuterClass$ResponseGetWalletInvoice.getClass();
        this.trait_ = walletOuterClass$ResponseGetWalletInvoice;
        this.traitCase_ = RESPONSE_GET_WALLET_INVOICE_FIELD_NUMBER;
    }

    private void setResponseGetWebviewTrackingNumber(Saba$ResponseGetWebViewTrackingNumber saba$ResponseGetWebViewTrackingNumber) {
        saba$ResponseGetWebViewTrackingNumber.getClass();
        this.trait_ = saba$ResponseGetWebViewTrackingNumber;
        this.traitCase_ = RESPONSE_GET_WEBVIEW_TRACKING_NUMBER_FIELD_NUMBER;
    }

    private void setResponseGetWheel(ClubOuterClass$ResponseGetWheel clubOuterClass$ResponseGetWheel) {
        clubOuterClass$ResponseGetWheel.getClass();
        this.trait_ = clubOuterClass$ResponseGetWheel;
        this.traitCase_ = RESPONSE_GET_WHEEL_FIELD_NUMBER;
    }

    private void setResponseImportContacts(UsersOuterClass$ResponseImportContacts usersOuterClass$ResponseImportContacts) {
        usersOuterClass$ResponseImportContacts.getClass();
        this.trait_ = usersOuterClass$ResponseImportContacts;
        this.traitCase_ = 8;
    }

    private void setResponseInitP12(SefteOuterClass$ResponseInitP12 sefteOuterClass$ResponseInitP12) {
        sefteOuterClass$ResponseInitP12.getClass();
        this.trait_ = sefteOuterClass$ResponseInitP12;
        this.traitCase_ = RESPONSE_INIT_P12_FIELD_NUMBER;
    }

    private void setResponseInitSefte(SefteOuterClass$ResponseInitSefte sefteOuterClass$ResponseInitSefte) {
        sefteOuterClass$ResponseInitSefte.getClass();
        this.trait_ = sefteOuterClass$ResponseInitSefte;
        this.traitCase_ = RESPONSE_INIT_SEFTE_FIELD_NUMBER;
    }

    private void setResponseInquiryBill(BillOuterClass$ResponseInquiryBill billOuterClass$ResponseInquiryBill) {
        billOuterClass$ResponseInquiryBill.getClass();
        this.trait_ = billOuterClass$ResponseInquiryBill;
        this.traitCase_ = RESPONSE_INQUIRY_BILL_FIELD_NUMBER;
    }

    private void setResponseInviteUrl(GroupsOuterClass$ResponseInviteUrl groupsOuterClass$ResponseInviteUrl) {
        groupsOuterClass$ResponseInviteUrl.getClass();
        this.trait_ = groupsOuterClass$ResponseInviteUrl;
        this.traitCase_ = RESPONSE_INVITE_URL_FIELD_NUMBER;
    }

    private void setResponseInvoiceKifpool(KifpoolOuterClass$ResponseInvoiceKifpool kifpoolOuterClass$ResponseInvoiceKifpool) {
        kifpoolOuterClass$ResponseInvoiceKifpool.getClass();
        this.trait_ = kifpoolOuterClass$ResponseInvoiceKifpool;
        this.traitCase_ = RESPONSE_INVOICE_KIFPOOL_FIELD_NUMBER;
    }

    private void setResponseJoinGroup(GroupsOuterClass$ResponseJoinGroup groupsOuterClass$ResponseJoinGroup) {
        groupsOuterClass$ResponseJoinGroup.getClass();
        this.trait_ = groupsOuterClass$ResponseJoinGroup;
        this.traitCase_ = RESPONSE_JOIN_GROUP_FIELD_NUMBER;
    }

    private void setResponseJoinPublicGroup(GroupsOuterClass$ResponseJoinPublicGroup groupsOuterClass$ResponseJoinPublicGroup) {
        groupsOuterClass$ResponseJoinPublicGroup.getClass();
        this.trait_ = groupsOuterClass$ResponseJoinPublicGroup;
        this.traitCase_ = RESPONSE_JOIN_PUBLIC_GROUP_FIELD_NUMBER;
    }

    private void setResponseLoadArchived(MessagingOuterClass$ResponseLoadArchived messagingOuterClass$ResponseLoadArchived) {
        messagingOuterClass$ResponseLoadArchived.getClass();
        this.trait_ = messagingOuterClass$ResponseLoadArchived;
        this.traitCase_ = RESPONSE_LOAD_ARCHIVED_FIELD_NUMBER;
    }

    private void setResponseLoadAvatars(UsersOuterClass$ResponseLoadAvatars usersOuterClass$ResponseLoadAvatars) {
        usersOuterClass$ResponseLoadAvatars.getClass();
        this.trait_ = usersOuterClass$ResponseLoadAvatars;
        this.traitCase_ = RESPONSE_LOAD_AVATARS_FIELD_NUMBER;
    }

    private void setResponseLoadBlockedUsers(UsersOuterClass$ResponseLoadBlockedUsers usersOuterClass$ResponseLoadBlockedUsers) {
        usersOuterClass$ResponseLoadBlockedUsers.getClass();
        this.trait_ = usersOuterClass$ResponseLoadBlockedUsers;
        this.traitCase_ = RESPONSE_LOAD_BLOCKED_USERS_FIELD_NUMBER;
    }

    private void setResponseLoadDialogs(MessagingOuterClass$ResponseLoadDialogs messagingOuterClass$ResponseLoadDialogs) {
        messagingOuterClass$ResponseLoadDialogs.getClass();
        this.trait_ = messagingOuterClass$ResponseLoadDialogs;
        this.traitCase_ = 105;
    }

    private void setResponseLoadFullGroups(GroupsOuterClass$ResponseLoadFullGroups groupsOuterClass$ResponseLoadFullGroups) {
        groupsOuterClass$ResponseLoadFullGroups.getClass();
        this.trait_ = groupsOuterClass$ResponseLoadFullGroups;
        this.traitCase_ = RESPONSE_LOAD_FULL_GROUPS_FIELD_NUMBER;
    }

    private void setResponseLoadFullUsers(UsersOuterClass$ResponseLoadFullUsers usersOuterClass$ResponseLoadFullUsers) {
        usersOuterClass$ResponseLoadFullUsers.getClass();
        this.trait_ = usersOuterClass$ResponseLoadFullUsers;
        this.traitCase_ = RESPONSE_LOAD_FULL_USERS_FIELD_NUMBER;
    }

    private void setResponseLoadGroupAvatars(GroupsOuterClass$ResponseLoadGroupAvatars groupsOuterClass$ResponseLoadGroupAvatars) {
        groupsOuterClass$ResponseLoadGroupAvatars.getClass();
        this.trait_ = groupsOuterClass$ResponseLoadGroupAvatars;
        this.traitCase_ = RESPONSE_LOAD_GROUP_AVATARS_FIELD_NUMBER;
    }

    private void setResponseLoadGroupedDialogs(MessagingOuterClass$ResponseLoadGroupedDialogs messagingOuterClass$ResponseLoadGroupedDialogs) {
        messagingOuterClass$ResponseLoadGroupedDialogs.getClass();
        this.trait_ = messagingOuterClass$ResponseLoadGroupedDialogs;
        this.traitCase_ = 226;
    }

    private void setResponseLoadGroups(GroupsOuterClass$ResponseLoadGroups groupsOuterClass$ResponseLoadGroups) {
        groupsOuterClass$ResponseLoadGroups.getClass();
        this.trait_ = groupsOuterClass$ResponseLoadGroups;
        this.traitCase_ = RESPONSE_LOAD_GROUPS_FIELD_NUMBER;
    }

    private void setResponseLoadHistory(MessagingOuterClass$ResponseLoadHistory messagingOuterClass$ResponseLoadHistory) {
        messagingOuterClass$ResponseLoadHistory.getClass();
        this.trait_ = messagingOuterClass$ResponseLoadHistory;
        this.traitCase_ = 119;
    }

    private void setResponseLoadLastStates(MelonOuterClass$ResponseLoadLastStates melonOuterClass$ResponseLoadLastStates) {
        melonOuterClass$ResponseLoadLastStates.getClass();
        this.trait_ = melonOuterClass$ResponseLoadLastStates;
        this.traitCase_ = RESPONSE_LOAD_LAST_STATES_FIELD_NUMBER;
    }

    private void setResponseLoadLoanHistory(MelonOuterClass$ResponseLoadLoanHistory melonOuterClass$ResponseLoadLoanHistory) {
        melonOuterClass$ResponseLoadLoanHistory.getClass();
        this.trait_ = melonOuterClass$ResponseLoadLoanHistory;
        this.traitCase_ = RESPONSE_LOAD_LOAN_HISTORY_FIELD_NUMBER;
    }

    private void setResponseLoadMembers(GroupsOuterClass$ResponseLoadMembers groupsOuterClass$ResponseLoadMembers) {
        groupsOuterClass$ResponseLoadMembers.getClass();
        this.trait_ = groupsOuterClass$ResponseLoadMembers;
        this.traitCase_ = RESPONSE_LOAD_MEMBERS_FIELD_NUMBER;
    }

    private void setResponseLoadOwnStickers(ImagesOuterClass$ResponseLoadOwnStickers imagesOuterClass$ResponseLoadOwnStickers) {
        imagesOuterClass$ResponseLoadOwnStickers.getClass();
        this.trait_ = imagesOuterClass$ResponseLoadOwnStickers;
        this.traitCase_ = RESPONSE_LOAD_OWN_STICKERS_FIELD_NUMBER;
    }

    private void setResponseLoadPeerDialogs(MessagingOuterClass$ResponseLoadPeerDialogs messagingOuterClass$ResponseLoadPeerDialogs) {
        messagingOuterClass$ResponseLoadPeerDialogs.getClass();
        this.trait_ = messagingOuterClass$ResponseLoadPeerDialogs;
        this.traitCase_ = RESPONSE_LOAD_PEER_DIALOGS_FIELD_NUMBER;
    }

    private void setResponseLoadReactions(AbacusOuterClass$ResponseLoadReactions abacusOuterClass$ResponseLoadReactions) {
        abacusOuterClass$ResponseLoadReactions.getClass();
        this.trait_ = abacusOuterClass$ResponseLoadReactions;
        this.traitCase_ = RESPONSE_LOAD_REACTIONS_FIELD_NUMBER;
    }

    private void setResponseLoadStickerCollection(ImagesOuterClass$ResponseLoadStickerCollection imagesOuterClass$ResponseLoadStickerCollection) {
        imagesOuterClass$ResponseLoadStickerCollection.getClass();
        this.trait_ = imagesOuterClass$ResponseLoadStickerCollection;
        this.traitCase_ = RESPONSE_LOAD_STICKER_COLLECTION_FIELD_NUMBER;
    }

    private void setResponseLoadTransactions(PfmOuterClass$ResponseLoadTransactions pfmOuterClass$ResponseLoadTransactions) {
        pfmOuterClass$ResponseLoadTransactions.getClass();
        this.trait_ = pfmOuterClass$ResponseLoadTransactions;
        this.traitCase_ = RESPONSE_LOAD_TRANSACTIONS_FIELD_NUMBER;
    }

    private void setResponseLoadTransactionsByIds(PfmOuterClass$ResponseLoadTransactionsByIDs pfmOuterClass$ResponseLoadTransactionsByIDs) {
        pfmOuterClass$ResponseLoadTransactionsByIDs.getClass();
        this.trait_ = pfmOuterClass$ResponseLoadTransactionsByIDs;
        this.traitCase_ = RESPONSE_LOAD_TRANSACTIONS_BY_IDS_FIELD_NUMBER;
    }

    private void setResponseLoadUsers(UsersOuterClass$ResponseLoadUsers usersOuterClass$ResponseLoadUsers) {
        usersOuterClass$ResponseLoadUsers.getClass();
        this.trait_ = usersOuterClass$ResponseLoadUsers;
        this.traitCase_ = RESPONSE_LOAD_USERS_FIELD_NUMBER;
    }

    private void setResponseOpenGiftPacket(Giftpacket$ResponseOpenGiftPacket giftpacket$ResponseOpenGiftPacket) {
        giftpacket$ResponseOpenGiftPacket.getClass();
        this.trait_ = giftpacket$ResponseOpenGiftPacket;
        this.traitCase_ = RESPONSE_OPEN_GIFT_PACKET_FIELD_NUMBER;
    }

    private void setResponsePayBill(BillOuterClass$ResponsePayBill billOuterClass$ResponsePayBill) {
        billOuterClass$ResponsePayBill.getClass();
        this.trait_ = billOuterClass$ResponsePayBill;
        this.traitCase_ = RESPONSE_PAY_BILL_FIELD_NUMBER;
    }

    private void setResponsePaySefte(SefteOuterClass$ResponsePaySefte sefteOuterClass$ResponsePaySefte) {
        sefteOuterClass$ResponsePaySefte.getClass();
        this.trait_ = sefteOuterClass$ResponsePaySefte;
        this.traitCase_ = RESPONSE_PAY_SEFTE_FIELD_NUMBER;
    }

    private void setResponseProto(Protobuf$ResponseProto protobuf$ResponseProto) {
        protobuf$ResponseProto.getClass();
        this.trait_ = protobuf$ResponseProto;
        this.traitCase_ = RESPONSE_PROTO_FIELD_NUMBER;
    }

    private void setResponsePurchaseMessage(KifpoolOuterClass$ResponsePurchaseMessage kifpoolOuterClass$ResponsePurchaseMessage) {
        kifpoolOuterClass$ResponsePurchaseMessage.getClass();
        this.trait_ = kifpoolOuterClass$ResponsePurchaseMessage;
        this.traitCase_ = RESPONSE_PURCHASE_MESSAGE_FIELD_NUMBER;
    }

    private void setResponsePurchaseMessageWithCharge(KifpoolOuterClass$ResponsePurchaseMessageWithCharge kifpoolOuterClass$ResponsePurchaseMessageWithCharge) {
        kifpoolOuterClass$ResponsePurchaseMessageWithCharge.getClass();
        this.trait_ = kifpoolOuterClass$ResponsePurchaseMessageWithCharge;
        this.traitCase_ = RESPONSE_PURCHASE_MESSAGE_WITH_CHARGE_FIELD_NUMBER;
    }

    private void setResponseReactionsResponse(AbacusOuterClass$ResponseReactionsResponse abacusOuterClass$ResponseReactionsResponse) {
        abacusOuterClass$ResponseReactionsResponse.getClass();
        this.trait_ = abacusOuterClass$ResponseReactionsResponse;
        this.traitCase_ = 219;
    }

    private void setResponseReactivateApp(SapOuterClass$ResponseReactivateApp sapOuterClass$ResponseReactivateApp) {
        sapOuterClass$ResponseReactivateApp.getClass();
        this.trait_ = sapOuterClass$ResponseReactivateApp;
        this.traitCase_ = RESPONSE_REACTIVATE_APP_FIELD_NUMBER;
    }

    private void setResponseRefer(ReferralOuterClass$ResponseRefer referralOuterClass$ResponseRefer) {
        referralOuterClass$ResponseRefer.getClass();
        this.trait_ = referralOuterClass$ResponseRefer;
        this.traitCase_ = RESPONSE_REFER_FIELD_NUMBER;
    }

    private void setResponseSearchContacts(UsersOuterClass$ResponseSearchContacts usersOuterClass$ResponseSearchContacts) {
        usersOuterClass$ResponseSearchContacts.getClass();
        this.trait_ = usersOuterClass$ResponseSearchContacts;
        this.traitCase_ = 113;
    }

    private void setResponseSearchMedia(SearchOuterClass$ResponseSearchMedia searchOuterClass$ResponseSearchMedia) {
        searchOuterClass$ResponseSearchMedia.getClass();
        this.trait_ = searchOuterClass$ResponseSearchMedia;
        this.traitCase_ = RESPONSE_SEARCH_MEDIA_FIELD_NUMBER;
    }

    private void setResponseSearchMessages(SearchOuterClass$ResponseSearchMessages searchOuterClass$ResponseSearchMessages) {
        searchOuterClass$ResponseSearchMessages.getClass();
        this.trait_ = searchOuterClass$ResponseSearchMessages;
        this.traitCase_ = 218;
    }

    private void setResponseSearchPeer(SearchOuterClass$ResponseSearchPeer searchOuterClass$ResponseSearchPeer) {
        searchOuterClass$ResponseSearchPeer.getClass();
        this.trait_ = searchOuterClass$ResponseSearchPeer;
        this.traitCase_ = RESPONSE_SEARCH_PEER_FIELD_NUMBER;
    }

    private void setResponseSendChangePhoneVerificationCode(AuthOuterClass$ResponseSendChangePhoneVerificationCode authOuterClass$ResponseSendChangePhoneVerificationCode) {
        authOuterClass$ResponseSendChangePhoneVerificationCode.getClass();
        this.trait_ = authOuterClass$ResponseSendChangePhoneVerificationCode;
        this.traitCase_ = RESPONSE_SEND_CHANGE_PHONE_VERIFICATION_CODE_FIELD_NUMBER;
    }

    private void setResponseSendDeleteAccountVerificationCode(AuthOuterClass$ResponseSendDeleteAccountVerificationCode authOuterClass$ResponseSendDeleteAccountVerificationCode) {
        authOuterClass$ResponseSendDeleteAccountVerificationCode.getClass();
        this.trait_ = authOuterClass$ResponseSendDeleteAccountVerificationCode;
        this.traitCase_ = RESPONSE_SEND_DELETE_ACCOUNT_VERIFICATION_CODE_FIELD_NUMBER;
    }

    private void setResponseSeq(Misc$ResponseSeq misc$ResponseSeq) {
        misc$ResponseSeq.getClass();
        this.trait_ = misc$ResponseSeq;
        this.traitCase_ = 72;
    }

    private void setResponseSeqDate(Misc$ResponseSeqDate misc$ResponseSeqDate) {
        misc$ResponseSeqDate.getClass();
        this.trait_ = misc$ResponseSeqDate;
        this.traitCase_ = 102;
    }

    private void setResponseSignSefte(SefteOuterClass$ResponseSignSefte sefteOuterClass$ResponseSignSefte) {
        sefteOuterClass$ResponseSignSefte.getClass();
        this.trait_ = sefteOuterClass$ResponseSignSefte;
        this.traitCase_ = RESPONSE_SIGN_SEFTE_FIELD_NUMBER;
    }

    private void setResponseSpinWheel(ClubOuterClass$ResponseSpinWheel clubOuterClass$ResponseSpinWheel) {
        clubOuterClass$ResponseSpinWheel.getClass();
        this.trait_ = clubOuterClass$ResponseSpinWheel;
        this.traitCase_ = RESPONSE_SPIN_WHEEL_FIELD_NUMBER;
    }

    private void setResponseSplitTransaction(PfmOuterClass$ResponseSplitTransaction pfmOuterClass$ResponseSplitTransaction) {
        pfmOuterClass$ResponseSplitTransaction.getClass();
        this.trait_ = pfmOuterClass$ResponseSplitTransaction;
        this.traitCase_ = RESPONSE_SPLIT_TRANSACTION_FIELD_NUMBER;
    }

    private void setResponseStartPhoneAuth(AuthOuterClass$ResponseStartPhoneAuth authOuterClass$ResponseStartPhoneAuth) {
        authOuterClass$ResponseStartPhoneAuth.getClass();
        this.trait_ = authOuterClass$ResponseStartPhoneAuth;
        this.traitCase_ = RESPONSE_START_PHONE_AUTH_FIELD_NUMBER;
    }

    private void setResponseStickersReponse(ImagesOuterClass$ResponseStickersReponse imagesOuterClass$ResponseStickersReponse) {
        imagesOuterClass$ResponseStickersReponse.getClass();
        this.trait_ = imagesOuterClass$ResponseStickersReponse;
        this.traitCase_ = RESPONSE_STICKERS_REPONSE_FIELD_NUMBER;
    }

    private void setResponseTransactionPoint(KifpoolOuterClass$ResponseTransactionPoint kifpoolOuterClass$ResponseTransactionPoint) {
        kifpoolOuterClass$ResponseTransactionPoint.getClass();
        this.trait_ = kifpoolOuterClass$ResponseTransactionPoint;
        this.traitCase_ = RESPONSE_TRANSACTION_POINT_FIELD_NUMBER;
    }

    private void setResponseTransferMoney(KifpoolOuterClass$ResponseTransferMoney kifpoolOuterClass$ResponseTransferMoney) {
        kifpoolOuterClass$ResponseTransferMoney.getClass();
        this.trait_ = kifpoolOuterClass$ResponseTransferMoney;
        this.traitCase_ = RESPONSE_TRANSFER_MONEY_FIELD_NUMBER;
    }

    private void setResponseUpdateClick(AdvertisementOuterClass$ResponseUpdateClick advertisementOuterClass$ResponseUpdateClick) {
        advertisementOuterClass$ResponseUpdateClick.getClass();
        this.trait_ = advertisementOuterClass$ResponseUpdateClick;
        this.traitCase_ = RESPONSE_UPDATE_CLICK_FIELD_NUMBER;
    }

    private void setResponseUpdateView(AdvertisementOuterClass$ResponseUpdateView advertisementOuterClass$ResponseUpdateView) {
        advertisementOuterClass$ResponseUpdateView.getClass();
        this.trait_ = advertisementOuterClass$ResponseUpdateView;
        this.traitCase_ = RESPONSE_UPDATE_VIEW_FIELD_NUMBER;
    }

    private void setResponseUpgradeKifpool(KifpoolOuterClass$ResponseUpgradeKifpool kifpoolOuterClass$ResponseUpgradeKifpool) {
        kifpoolOuterClass$ResponseUpgradeKifpool.getClass();
        this.trait_ = kifpoolOuterClass$ResponseUpgradeKifpool;
        this.traitCase_ = RESPONSE_UPGRADE_KIFPOOL_FIELD_NUMBER;
    }

    private void setResponseUserHasCred(SefteOuterClass$ResponseUserHasCred sefteOuterClass$ResponseUserHasCred) {
        sefteOuterClass$ResponseUserHasCred.getClass();
        this.trait_ = sefteOuterClass$ResponseUserHasCred;
        this.traitCase_ = RESPONSE_USER_HAS_CRED_FIELD_NUMBER;
    }

    private void setResponseValidateMySentence(SentenceOuterClass$ResponseValidateMySentence sentenceOuterClass$ResponseValidateMySentence) {
        sentenceOuterClass$ResponseValidateMySentence.getClass();
        this.trait_ = sentenceOuterClass$ResponseValidateMySentence;
        this.traitCase_ = RESPONSE_VALIDATE_MY_SENTENCE_FIELD_NUMBER;
    }

    private void setResponseVerifyCashOut(WalletOuterClass$ResponseVerifyCashOut walletOuterClass$ResponseVerifyCashOut) {
        walletOuterClass$ResponseVerifyCashOut.getClass();
        this.trait_ = walletOuterClass$ResponseVerifyCashOut;
        this.traitCase_ = RESPONSE_VERIFY_CASH_OUT_FIELD_NUMBER;
    }

    private void setResponseVerifyCashOutKifpool(KifpoolOuterClass$ResponseVerifyCashOutKifpool kifpoolOuterClass$ResponseVerifyCashOutKifpool) {
        kifpoolOuterClass$ResponseVerifyCashOutKifpool.getClass();
        this.trait_ = kifpoolOuterClass$ResponseVerifyCashOutKifpool;
        this.traitCase_ = RESPONSE_VERIFY_CASH_OUT_KIFPOOL_FIELD_NUMBER;
    }

    private void setResponseVerifyPeer(WalletOuterClass$ResponseVerifyPeer walletOuterClass$ResponseVerifyPeer) {
        walletOuterClass$ResponseVerifyPeer.getClass();
        this.trait_ = walletOuterClass$ResponseVerifyPeer;
        this.traitCase_ = RESPONSE_VERIFY_PEER_FIELD_NUMBER;
    }

    private void setResponseVerifyPurchaseMessage(KifpoolOuterClass$ResponseVerifyPurchaseMessage kifpoolOuterClass$ResponseVerifyPurchaseMessage) {
        kifpoolOuterClass$ResponseVerifyPurchaseMessage.getClass();
        this.trait_ = kifpoolOuterClass$ResponseVerifyPurchaseMessage;
        this.traitCase_ = RESPONSE_VERIFY_PURCHASE_MESSAGE_FIELD_NUMBER;
    }

    private void setResponseVerifyQrcode(WalletOuterClass$ResponseVerifyQRCode walletOuterClass$ResponseVerifyQRCode) {
        walletOuterClass$ResponseVerifyQRCode.getClass();
        this.trait_ = walletOuterClass$ResponseVerifyQRCode;
        this.traitCase_ = RESPONSE_VERIFY_QRCODE_FIELD_NUMBER;
    }

    private void setResponseVoid(Misc$ResponseVoid misc$ResponseVoid) {
        misc$ResponseVoid.getClass();
        this.trait_ = misc$ResponseVoid;
        this.traitCase_ = 50;
    }

    private void setReviveTransaction(PfmOuterClass$RequestReviveTransaction pfmOuterClass$RequestReviveTransaction) {
        pfmOuterClass$RequestReviveTransaction.getClass();
        this.trait_ = pfmOuterClass$RequestReviveTransaction;
        this.traitCase_ = REVIVE_TRANSACTION_FIELD_NUMBER;
    }

    private void setRevokeInviteUrl(GroupsOuterClass$RequestRevokeInviteUrl groupsOuterClass$RequestRevokeInviteUrl) {
        groupsOuterClass$RequestRevokeInviteUrl.getClass();
        this.trait_ = groupsOuterClass$RequestRevokeInviteUrl;
        this.traitCase_ = REVOKE_INVITE_URL_FIELD_NUMBER;
    }

    private void setSearchContacts(UsersOuterClass$RequestSearchContacts usersOuterClass$RequestSearchContacts) {
        usersOuterClass$RequestSearchContacts.getClass();
        this.trait_ = usersOuterClass$RequestSearchContacts;
        this.traitCase_ = SEARCH_CONTACTS_FIELD_NUMBER;
    }

    private void setSearchMedia(SearchOuterClass$RequestSearchMedia searchOuterClass$RequestSearchMedia) {
        searchOuterClass$RequestSearchMedia.getClass();
        this.trait_ = searchOuterClass$RequestSearchMedia;
        this.traitCase_ = SEARCH_MEDIA_FIELD_NUMBER;
    }

    private void setSearchMessages(SearchOuterClass$RequestSearchMessages searchOuterClass$RequestSearchMessages) {
        searchOuterClass$RequestSearchMessages.getClass();
        this.trait_ = searchOuterClass$RequestSearchMessages;
        this.traitCase_ = 217;
    }

    private void setSearchMessagesMore(SearchOuterClass$RequestSearchMessagesMore searchOuterClass$RequestSearchMessagesMore) {
        searchOuterClass$RequestSearchMessagesMore.getClass();
        this.trait_ = searchOuterClass$RequestSearchMessagesMore;
        this.traitCase_ = 222;
    }

    private void setSearchPeer(SearchOuterClass$RequestSearchPeer searchOuterClass$RequestSearchPeer) {
        searchOuterClass$RequestSearchPeer.getClass();
        this.trait_ = searchOuterClass$RequestSearchPeer;
        this.traitCase_ = SEARCH_PEER_FIELD_NUMBER;
    }

    private void setSendChangePhoneVerificationCode(AuthOuterClass$RequestSendChangePhoneVerificationCode authOuterClass$RequestSendChangePhoneVerificationCode) {
        authOuterClass$RequestSendChangePhoneVerificationCode.getClass();
        this.trait_ = authOuterClass$RequestSendChangePhoneVerificationCode;
        this.traitCase_ = SEND_CHANGE_PHONE_VERIFICATION_CODE_FIELD_NUMBER;
    }

    private void setSendDeleteAccountVerificationCode(AuthOuterClass$RequestSendDeleteAccountVerificationCode authOuterClass$RequestSendDeleteAccountVerificationCode) {
        authOuterClass$RequestSendDeleteAccountVerificationCode.getClass();
        this.trait_ = authOuterClass$RequestSendDeleteAccountVerificationCode;
        this.traitCase_ = SEND_DELETE_ACCOUNT_VERIFICATION_CODE_FIELD_NUMBER;
    }

    private void setSendFeedBack(Feedback$RequestSendFeedBack feedback$RequestSendFeedBack) {
        feedback$RequestSendFeedBack.getClass();
        this.trait_ = feedback$RequestSendFeedBack;
        this.traitCase_ = SEND_FEED_BACK_FIELD_NUMBER;
    }

    private void setSendGiftPacketWithWallet(Giftpacket$RequestSendGiftPacketWithWallet giftpacket$RequestSendGiftPacketWithWallet) {
        giftpacket$RequestSendGiftPacketWithWallet.getClass();
        this.trait_ = giftpacket$RequestSendGiftPacketWithWallet;
        this.traitCase_ = SEND_GIFT_PACKET_WITH_WALLET_FIELD_NUMBER;
    }

    private void setSendInlineCallbackData(KetfOuterClass$RequestSendInlineCallBackData ketfOuterClass$RequestSendInlineCallBackData) {
        ketfOuterClass$RequestSendInlineCallBackData.getClass();
        this.trait_ = ketfOuterClass$RequestSendInlineCallBackData;
        this.traitCase_ = SEND_INLINE_CALLBACK_DATA_FIELD_NUMBER;
    }

    private void setSendMessage(MessagingOuterClass$RequestSendMessage messagingOuterClass$RequestSendMessage) {
        messagingOuterClass$RequestSendMessage.getClass();
        this.trait_ = messagingOuterClass$RequestSendMessage;
        this.traitCase_ = 92;
    }

    private void setSendMultiMediaMessage(MessagingOuterClass$RequestSendMultiMediaMessage messagingOuterClass$RequestSendMultiMediaMessage) {
        messagingOuterClass$RequestSendMultiMediaMessage.getClass();
        this.trait_ = messagingOuterClass$RequestSendMultiMediaMessage;
        this.traitCase_ = SEND_MULTI_MEDIA_MESSAGE_FIELD_NUMBER;
    }

    private void setSendMyGiftPacket(SentenceOuterClass$RequestSendMyGiftPacket sentenceOuterClass$RequestSendMyGiftPacket) {
        sentenceOuterClass$RequestSendMyGiftPacket.getClass();
        this.trait_ = sentenceOuterClass$RequestSendMyGiftPacket;
        this.traitCase_ = SEND_MY_GIFT_PACKET_FIELD_NUMBER;
    }

    private void setSendReferral(WarriorOuterClass$RequestSendReferral warriorOuterClass$RequestSendReferral) {
        warriorOuterClass$RequestSendReferral.getClass();
        this.trait_ = warriorOuterClass$RequestSendReferral;
        this.traitCase_ = SEND_REFERRAL_FIELD_NUMBER;
    }

    private void setSendSerajEvent(Seraj$RequestSendSerajEvent seraj$RequestSendSerajEvent) {
        seraj$RequestSendSerajEvent.getClass();
        this.trait_ = seraj$RequestSendSerajEvent;
        this.traitCase_ = SEND_SERAJ_EVENT_FIELD_NUMBER;
    }

    private void setSeqUpdate(UpdateBoxStruct$SeqUpdate updateBoxStruct$SeqUpdate) {
        updateBoxStruct$SeqUpdate.getClass();
        this.trait_ = updateBoxStruct$SeqUpdate;
        this.traitCase_ = 13;
    }

    private void setSeqUpdateTooLong(UpdateBoxStruct$SeqUpdateTooLong updateBoxStruct$SeqUpdateTooLong) {
        updateBoxStruct$SeqUpdateTooLong.getClass();
        this.trait_ = updateBoxStruct$SeqUpdateTooLong;
        this.traitCase_ = 25;
    }

    private void setSetCanSeeMessages(GroupsOuterClass$RequestSetCanSeeMessages groupsOuterClass$RequestSetCanSeeMessages) {
        groupsOuterClass$RequestSetCanSeeMessages.getClass();
        this.trait_ = groupsOuterClass$RequestSetCanSeeMessages;
        this.traitCase_ = SET_CAN_SEE_MESSAGES_FIELD_NUMBER;
    }

    private void setSetDefaultCard(SapOuterClass$RequestSetDefaultCard sapOuterClass$RequestSetDefaultCard) {
        sapOuterClass$RequestSetDefaultCard.getClass();
        this.trait_ = sapOuterClass$RequestSetDefaultCard;
        this.traitCase_ = SET_DEFAULT_CARD_FIELD_NUMBER;
    }

    private void setSetGroupDefaultPermissions(GroupsOuterClass$RequestSetGroupDefaultPermissions groupsOuterClass$RequestSetGroupDefaultPermissions) {
        groupsOuterClass$RequestSetGroupDefaultPermissions.getClass();
        this.trait_ = groupsOuterClass$RequestSetGroupDefaultPermissions;
        this.traitCase_ = SET_GROUP_DEFAULT_PERMISSIONS_FIELD_NUMBER;
    }

    private void setSetMemberPermissions(GroupsOuterClass$RequestSetMemberPermissions groupsOuterClass$RequestSetMemberPermissions) {
        groupsOuterClass$RequestSetMemberPermissions.getClass();
        this.trait_ = groupsOuterClass$RequestSetMemberPermissions;
        this.traitCase_ = SET_MEMBER_PERMISSIONS_FIELD_NUMBER;
    }

    private void setSetOnline(PresenceOuterClass$RequestSetOnline presenceOuterClass$RequestSetOnline) {
        presenceOuterClass$RequestSetOnline.getClass();
        this.trait_ = presenceOuterClass$RequestSetOnline;
        this.traitCase_ = 29;
    }

    private void setSetRecentOrder(Saba$RequestSetRecentOrder saba$RequestSetRecentOrder) {
        saba$RequestSetRecentOrder.getClass();
        this.trait_ = saba$RequestSetRecentOrder;
        this.traitCase_ = SET_RECENT_ORDER_FIELD_NUMBER;
    }

    private void setSetRestriction(GroupsOuterClass$RequestSetRestriction groupsOuterClass$RequestSetRestriction) {
        groupsOuterClass$RequestSetRestriction.getClass();
        this.trait_ = groupsOuterClass$RequestSetRestriction;
        this.traitCase_ = SET_RESTRICTION_FIELD_NUMBER;
    }

    private void setSignOut(AuthOuterClass$RequestSignOut authOuterClass$RequestSignOut) {
        authOuterClass$RequestSignOut.getClass();
        this.trait_ = authOuterClass$RequestSignOut;
        this.traitCase_ = 84;
    }

    private void setSignSefte(SefteOuterClass$RequestSignSefte sefteOuterClass$RequestSignSefte) {
        sefteOuterClass$RequestSignSefte.getClass();
        this.trait_ = sefteOuterClass$RequestSignSefte;
        this.traitCase_ = SIGN_SEFTE_FIELD_NUMBER;
    }

    private void setSignUp(AuthOuterClass$RequestSignUp authOuterClass$RequestSignUp) {
        authOuterClass$RequestSignUp.getClass();
        this.trait_ = authOuterClass$RequestSignUp;
        this.traitCase_ = SIGN_UP_FIELD_NUMBER;
    }

    private void setSpinWheel(ClubOuterClass$RequestSpinWheel clubOuterClass$RequestSpinWheel) {
        clubOuterClass$RequestSpinWheel.getClass();
        this.trait_ = clubOuterClass$RequestSpinWheel;
        this.traitCase_ = SPIN_WHEEL_FIELD_NUMBER;
    }

    private void setSplitTransaction(PfmOuterClass$RequestSplitTransaction pfmOuterClass$RequestSplitTransaction) {
        pfmOuterClass$RequestSplitTransaction.getClass();
        this.trait_ = pfmOuterClass$RequestSplitTransaction;
        this.traitCase_ = SPLIT_TRANSACTION_FIELD_NUMBER;
    }

    private void setStartCall(MeetOuterClass$RequestStartCall meetOuterClass$RequestStartCall) {
        meetOuterClass$RequestStartCall.getClass();
        this.trait_ = meetOuterClass$RequestStartCall;
        this.traitCase_ = START_CALL_FIELD_NUMBER;
    }

    private void setStartPhoneAuth(AuthOuterClass$RequestStartPhoneAuth authOuterClass$RequestStartPhoneAuth) {
        authOuterClass$RequestStartPhoneAuth.getClass();
        this.trait_ = authOuterClass$RequestStartPhoneAuth;
        this.traitCase_ = START_PHONE_AUTH_FIELD_NUMBER;
    }

    private void setStopTyping(PresenceOuterClass$RequestStopTyping presenceOuterClass$RequestStopTyping) {
        presenceOuterClass$RequestStopTyping.getClass();
        this.trait_ = presenceOuterClass$RequestStopTyping;
        this.traitCase_ = 30;
    }

    private void setSubmitDialogAdOrder(AdvertisementOuterClass$RequestSubmitDialogAdOrder advertisementOuterClass$RequestSubmitDialogAdOrder) {
        advertisementOuterClass$RequestSubmitDialogAdOrder.getClass();
        this.trait_ = advertisementOuterClass$RequestSubmitDialogAdOrder;
        this.traitCase_ = SUBMIT_DIALOG_AD_ORDER_FIELD_NUMBER;
    }

    private void setSubscribeFromGroupOnline(PresenceOuterClass$RequestSubscribeFromGroupOnline presenceOuterClass$RequestSubscribeFromGroupOnline) {
        presenceOuterClass$RequestSubscribeFromGroupOnline.getClass();
        this.trait_ = presenceOuterClass$RequestSubscribeFromGroupOnline;
        this.traitCase_ = 75;
    }

    private void setSubscribeFromOnline(PresenceOuterClass$RequestSubscribeFromOnline presenceOuterClass$RequestSubscribeFromOnline) {
        presenceOuterClass$RequestSubscribeFromOnline.getClass();
        this.trait_ = presenceOuterClass$RequestSubscribeFromOnline;
        this.traitCase_ = 33;
    }

    private void setSubscribeToGroupOnline(PresenceOuterClass$RequestSubscribeToGroupOnline presenceOuterClass$RequestSubscribeToGroupOnline) {
        presenceOuterClass$RequestSubscribeToGroupOnline.getClass();
        this.trait_ = presenceOuterClass$RequestSubscribeToGroupOnline;
        this.traitCase_ = 74;
    }

    private void setSubscribeToOnline(PresenceOuterClass$RequestSubscribeToOnline presenceOuterClass$RequestSubscribeToOnline) {
        presenceOuterClass$RequestSubscribeToOnline.getClass();
        this.trait_ = presenceOuterClass$RequestSubscribeToOnline;
        this.traitCase_ = 32;
    }

    private void setTerminateAllSessions(AuthOuterClass$RequestTerminateAllSessions authOuterClass$RequestTerminateAllSessions) {
        authOuterClass$RequestTerminateAllSessions.getClass();
        this.trait_ = authOuterClass$RequestTerminateAllSessions;
        this.traitCase_ = 83;
    }

    private void setTerminateSession(AuthOuterClass$RequestTerminateSession authOuterClass$RequestTerminateSession) {
        authOuterClass$RequestTerminateSession.getClass();
        this.trait_ = authOuterClass$RequestTerminateSession;
        this.traitCase_ = 82;
    }

    private void setTransactionPoint(KifpoolOuterClass$RequestTransactionPoint kifpoolOuterClass$RequestTransactionPoint) {
        kifpoolOuterClass$RequestTransactionPoint.getClass();
        this.trait_ = kifpoolOuterClass$RequestTransactionPoint;
        this.traitCase_ = TRANSACTION_POINT_FIELD_NUMBER;
    }

    private void setTransferMoney(KifpoolOuterClass$RequestTransferMoney kifpoolOuterClass$RequestTransferMoney) {
        kifpoolOuterClass$RequestTransferMoney.getClass();
        this.trait_ = kifpoolOuterClass$RequestTransferMoney;
        this.traitCase_ = TRANSFER_MONEY_FIELD_NUMBER;
    }

    private void setTransferMoneyByCard(SapOuterClass$RequestTransferMoneyByCard sapOuterClass$RequestTransferMoneyByCard) {
        sapOuterClass$RequestTransferMoneyByCard.getClass();
        this.trait_ = sapOuterClass$RequestTransferMoneyByCard;
        this.traitCase_ = TRANSFER_MONEY_BY_CARD_FIELD_NUMBER;
    }

    private void setTransferOwnership(GroupsOuterClass$RequestTransferOwnership groupsOuterClass$RequestTransferOwnership) {
        groupsOuterClass$RequestTransferOwnership.getClass();
        this.trait_ = groupsOuterClass$RequestTransferOwnership;
        this.traitCase_ = TRANSFER_OWNERSHIP_FIELD_NUMBER;
    }

    private void setTyping(PresenceOuterClass$RequestTyping presenceOuterClass$RequestTyping) {
        presenceOuterClass$RequestTyping.getClass();
        this.trait_ = presenceOuterClass$RequestTyping;
        this.traitCase_ = 27;
    }

    private void setUnbindAllMoneyRequestDetails(ReactionsOuterClass$RequestUnbindAllMoneyRequestDetails reactionsOuterClass$RequestUnbindAllMoneyRequestDetails) {
        reactionsOuterClass$RequestUnbindAllMoneyRequestDetails.getClass();
        this.trait_ = reactionsOuterClass$RequestUnbindAllMoneyRequestDetails;
        this.traitCase_ = UNBIND_ALL_MONEY_REQUEST_DETAILS_FIELD_NUMBER;
    }

    private void setUnblockUser(UsersOuterClass$RequestUnblockUser usersOuterClass$RequestUnblockUser) {
        usersOuterClass$RequestUnblockUser.getClass();
        this.trait_ = usersOuterClass$RequestUnblockUser;
        this.traitCase_ = UNBLOCK_USER_FIELD_NUMBER;
    }

    private void setUnregisterAllPushCredentials(PushOuterClass$RequestUnregisterAllPushCredentials pushOuterClass$RequestUnregisterAllPushCredentials) {
        pushOuterClass$RequestUnregisterAllPushCredentials.getClass();
        this.trait_ = pushOuterClass$RequestUnregisterAllPushCredentials;
        this.traitCase_ = UNREGISTER_ALL_PUSH_CREDENTIALS_FIELD_NUMBER;
    }

    private void setUnregisterGooglePush(PushOuterClass$RequestUnregisterGooglePush pushOuterClass$RequestUnregisterGooglePush) {
        pushOuterClass$RequestUnregisterGooglePush.getClass();
        this.trait_ = pushOuterClass$RequestUnregisterGooglePush;
        this.traitCase_ = UNREGISTER_GOOGLE_PUSH_FIELD_NUMBER;
    }

    private void setUpdateClick(AdvertisementOuterClass$RequestUpdateClick advertisementOuterClass$RequestUpdateClick) {
        advertisementOuterClass$RequestUpdateClick.getClass();
        this.trait_ = advertisementOuterClass$RequestUpdateClick;
        this.traitCase_ = UPDATE_CLICK_FIELD_NUMBER;
    }

    private void setUpdateGroupStatus(AdvertisementOuterClass$RequestUpdateGroupStatus advertisementOuterClass$RequestUpdateGroupStatus) {
        advertisementOuterClass$RequestUpdateGroupStatus.getClass();
        this.trait_ = advertisementOuterClass$RequestUpdateGroupStatus;
        this.traitCase_ = UPDATE_GROUP_STATUS_FIELD_NUMBER;
    }

    private void setUpdateMessage(MessagingOuterClass$RequestUpdateMessage messagingOuterClass$RequestUpdateMessage) {
        messagingOuterClass$RequestUpdateMessage.getClass();
        this.trait_ = messagingOuterClass$RequestUpdateMessage;
        this.traitCase_ = UPDATE_MESSAGE_FIELD_NUMBER;
    }

    private void setUpdateView(AdvertisementOuterClass$RequestUpdateView advertisementOuterClass$RequestUpdateView) {
        advertisementOuterClass$RequestUpdateView.getClass();
        this.trait_ = advertisementOuterClass$RequestUpdateView;
        this.traitCase_ = UPDATE_VIEW_FIELD_NUMBER;
    }

    private void setUpgradeKifpool(KifpoolOuterClass$RequestUpgradeKifpool kifpoolOuterClass$RequestUpgradeKifpool) {
        kifpoolOuterClass$RequestUpgradeKifpool.getClass();
        this.trait_ = kifpoolOuterClass$RequestUpgradeKifpool;
        this.traitCase_ = UPGRADE_KIFPOOL_FIELD_NUMBER;
    }

    private void setUserHasCred(SefteOuterClass$RequestUserHasCred sefteOuterClass$RequestUserHasCred) {
        sefteOuterClass$RequestUserHasCred.getClass();
        this.trait_ = sefteOuterClass$RequestUserHasCred;
        this.traitCase_ = USER_HAS_CRED_FIELD_NUMBER;
    }

    private void setValidateCode(AuthOuterClass$RequestValidateCode authOuterClass$RequestValidateCode) {
        authOuterClass$RequestValidateCode.getClass();
        this.trait_ = authOuterClass$RequestValidateCode;
        this.traitCase_ = VALIDATE_CODE_FIELD_NUMBER;
    }

    private void setValidateMySentence(SentenceOuterClass$RequestValidateMySentence sentenceOuterClass$RequestValidateMySentence) {
        sentenceOuterClass$RequestValidateMySentence.getClass();
        this.trait_ = sentenceOuterClass$RequestValidateMySentence;
        this.traitCase_ = VALIDATE_MY_SENTENCE_FIELD_NUMBER;
    }

    private void setVerifyCashOut(WalletOuterClass$RequestVerifyCashOut walletOuterClass$RequestVerifyCashOut) {
        walletOuterClass$RequestVerifyCashOut.getClass();
        this.trait_ = walletOuterClass$RequestVerifyCashOut;
        this.traitCase_ = VERIFY_CASH_OUT_FIELD_NUMBER;
    }

    private void setVerifyCashOutKifpool(KifpoolOuterClass$RequestVerifyCashOutKifpool kifpoolOuterClass$RequestVerifyCashOutKifpool) {
        kifpoolOuterClass$RequestVerifyCashOutKifpool.getClass();
        this.trait_ = kifpoolOuterClass$RequestVerifyCashOutKifpool;
        this.traitCase_ = VERIFY_CASH_OUT_KIFPOOL_FIELD_NUMBER;
    }

    private void setVerifyPeer(WalletOuterClass$RequestVerifyPeer walletOuterClass$RequestVerifyPeer) {
        walletOuterClass$RequestVerifyPeer.getClass();
        this.trait_ = walletOuterClass$RequestVerifyPeer;
        this.traitCase_ = VERIFY_PEER_FIELD_NUMBER;
    }

    private void setVerifyPurchaseMessage(KifpoolOuterClass$RequestVerifyPurchaseMessage kifpoolOuterClass$RequestVerifyPurchaseMessage) {
        kifpoolOuterClass$RequestVerifyPurchaseMessage.getClass();
        this.trait_ = kifpoolOuterClass$RequestVerifyPurchaseMessage;
        this.traitCase_ = VERIFY_PURCHASE_MESSAGE_FIELD_NUMBER;
    }

    private void setVerifyQrcode(WalletOuterClass$RequestVerifyQRCode walletOuterClass$RequestVerifyQRCode) {
        walletOuterClass$RequestVerifyQRCode.getClass();
        this.trait_ = walletOuterClass$RequestVerifyQRCode;
        this.traitCase_ = VERIFY_QRCODE_FIELD_NUMBER;
    }

    private void setWeakFatUpdate(UpdateBoxStruct$WeakFatUpdate updateBoxStruct$WeakFatUpdate) {
        updateBoxStruct$WeakFatUpdate.getClass();
        this.trait_ = updateBoxStruct$WeakFatUpdate;
        this.traitCase_ = WEAK_FAT_UPDATE_FIELD_NUMBER;
    }

    private void setWeakUpdate(UpdateBoxStruct$WeakUpdate updateBoxStruct$WeakUpdate) {
        updateBoxStruct$WeakUpdate.getClass();
        this.trait_ = updateBoxStruct$WeakUpdate;
        this.traitCase_ = 26;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (W1.a[gVar.ordinal()]) {
            case 1:
                return new SetRpcStruct$ComposedRpc();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000ǳ\u0001\u0000\u0005\uf8b0\u0007ǳ\u0000\u0000\u0000\u0005<\u0000\u0007<\u0000\b<\u0000\t<\u0000\r<\u0000\u0017<\u0000\u0019<\u0000\u001a<\u0000\u001b<\u0000\u001d<\u0000\u001e<\u0000\u001f<\u0000 <\u0000!<\u0000-<\u00002<\u00003<\u00005<\u00007<\u00009<\u0000E<\u0000F<\u0000G<\u0000H<\u0000I<\u0000J<\u0000K<\u0000P<\u0000Q<\u0000R<\u0000S<\u0000T<\u0000U<\u0000V<\u0000W<\u0000X<\u0000Y<\u0000[<\u0000\\<\u0000`<\u0000b<\u0000c<\u0000d<\u0000e<\u0000f<\u0000g<\u0000h<\u0000i<\u0000p<\u0000q<\u0000r<\u0000s<\u0000v<\u0000w<\u0000x<\u0000\u0080<\u0000\u0081<\u0000\u0082<\u0000\u0086<\u0000\u0087<\u0000\u0088<\u0000\u0089<\u0000\u008f<\u0000\u0090<\u0000\u0091<\u0000\u0092<\u0000\u0099<\u0000\u009d<\u0000±<\u0000²<\u0000³<\u0000´<\u0000µ<\u0000»<\u0000½<\u0000¾<\u0000¿<\u0000Á<\u0000Ì<\u0000Í<\u0000Î<\u0000Ñ<\u0000Ò<\u0000Ô<\u0000Õ<\u0000Ø<\u0000Ù<\u0000Ú<\u0000Û<\u0000Ü<\u0000Þ<\u0000á<\u0000â<\u0000å<\u0000æ<\u0000é<\u0000ê<\u0000ë<\u0000î<\u0000ï<\u0000ð<\u0000ô<\u0000õ<\u0000ö<\u0000÷<\u0000ù<\u0000ǖ<\u0000Ǘ<\u0000ɘ<\u0000ə<\u0000˔<\u0000˕<\u0000˖<\u0000˘<\u0000˙<\u0000˚<\u0000Ґ<\u0000ਟ<\u0000ਯ<\u0000ੁ<\u0000\u0a44<\u0000\u0a45<\u0000ੇ<\u0000ੌ<\u0000੍<\u0000\u0a4e<\u0000\u0a4f<\u0000ਖ਼<\u0000ਗ਼<\u0000ਜ਼<\u0000ੜ<\u0000\u0a60<\u0000\u0a62<\u0000ੱ<\u0000\u0ade<\u0000\u0adf<\u0000ૠ<\u0000ૢ<\u0000ૣ<\u0000\u0ae5<\u0000૯<\u0000ૼ<\u0000૿<\u0000\u0b29<\u0000ଫ<\u0000ୁ<\u0000\u0b51<\u0000௯<\u0000௰<\u0000\u0bff<\u0000ఀ<\u0000\u0c11<\u0000ൄ<\u0000༐<\u0000ཡ<\u0000꩖<\u0000꩙<\u0000ꫢ<\u0000ꫣ<\u0000ꫤ<\u0000ꫥ<\u0000긠<\u0000퀈<\u0000퀉<\u0000퀊<\u0000퀋<\u0000\ue2fa\u0007<\u0000\uf2ad\u0007<\u0000\uf2ae\u0007<\u0000\uf2af\u0007<\u0000\uf2b0\u0007<\u0000\uf2b1\u0007<\u0000\uf2b2\u0007<\u0000\uf2b3\u0007<\u0000\uf2b4\u0007<\u0000\uf2b5\u0007<\u0000\uf2ba\u0007<\u0000\uf2e1\u0007<\u0000\uf2e4\u0007<\u0000\uf2e5\u0007<\u0000\uf3b9\u0007<\u0000\uf3bd\u0007<\u0000\uf3c0\u0007<\u0000\uf3c1\u0007<\u0000\uf3c2\u0007<\u0000\uf3c3\u0007<\u0000\uf3c6\u0007<\u0000\uf3c7\u0007<\u0000\uf3c8\u0007<\u0000\uf3c9\u0007<\u0000\uf3ca\u0007<\u0000\uf3cb\u0007<\u0000\uf3cc\u0007<\u0000\uf3ce\u0007<\u0000\uf400\u0007<\u0000\uf401\u0007<\u0000\uf509\u0007<\u0000\uf50a\u0007<\u0000\uf50b\u0007<\u0000\uf50d\u0007<\u0000\uf50e\u0007<\u0000\uf51a\u0007<\u0000\uf51b\u0007<\u0000\uf51c\u0007<\u0000\uf51d\u0007<\u0000\uf51e\u0007<\u0000\uf51f\u0007<\u0000\uf520\u0007<\u0000\uf524\u0007<\u0000\uf525\u0007<\u0000\uf526\u0007<\u0000\uf527\u0007<\u0000\uf528\u0007<\u0000\uf529\u0007<\u0000\uf52a\u0007<\u0000\uf52b\u0007<\u0000\uf52c\u0007<\u0000\uf530\u0007<\u0000\uf531\u0007<\u0000\uf532\u0007<\u0000\uf6ff\u0007<\u0000\uf700\u0007<\u0000\uf701\u0007<\u0000\uf704\u0007<\u0000\uf705\u0007<\u0000\uf706\u0007<\u0000\uf707\u0007<\u0000\uf708\u0007<\u0000\uf70b\u0007<\u0000\uf70c\u0007<\u0000\uf70d\u0007<\u0000\uf70e\u0007<\u0000\uf70f\u0007<\u0000\uf710\u0007<\u0000\uf711\u0007<\u0000\uf712\u0007<\u0000\uf713\u0007<\u0000\uf716\u0007<\u0000\uf717\u0007<\u0000\uf718\u0007<\u0000\uf719\u0007<\u0000\uf71a\u0007<\u0000\uf71b\u0007<\u0000\uf71c\u0007<\u0000\uf71d\u0007<\u0000\uf71e\u0007<\u0000\uf71f\u0007<\u0000\uf720\u0007<\u0000\uf721\u0007<\u0000\uf7a8\u0007<\u0000\uf7a9\u0007<\u0000\uf7aa\u0007<\u0000\uf7ab\u0007<\u0000\uf7ac\u0007<\u0000\uf7ad\u0007<\u0000\uf7ae\u0007<\u0000\uf7af\u0007<\u0000\uf7b0\u0007<\u0000\uf7b1\u0007<\u0000\uf7b2\u0007<\u0000\uf7b3\u0007<\u0000\uf7b4\u0007<\u0000\uf7b5\u0007<\u0000\uf7b6\u0007<\u0000\uf7b7\u0007<\u0000\uf7b8\u0007<\u0000\uf7b9\u0007<\u0000\uf7ba\u0007<\u0000\uf7bb\u0007<\u0000\uf7bc\u0007<\u0000\uf7bd\u0007<\u0000\uf7c4\u0007<\u0000\uf7c5\u0007<\u0000\uf7c6\u0007<\u0000\uf7c7\u0007<\u0000\uf7c8\u0007<\u0000\uf7c9\u0007<\u0000\uf7ca\u0007<\u0000\uf7cb\u0007<\u0000\uf7cc\u0007<\u0000\uf7cd\u0007<\u0000\uf7ce\u0007<\u0000\uf7cf\u0007<\u0000\uf7d1\u0007<\u0000\uf7d2\u0007<\u0000\uf7d3\u0007<\u0000\uf7d4\u0007<\u0000\uf7d5\u0007<\u0000\uf7d6\u0007<\u0000\uf7d7\u0007<\u0000\uf7d8\u0007<\u0000\uf7d9\u0007<\u0000\uf7da\u0007<\u0000\uf7db\u0007<\u0000\uf7dc\u0007<\u0000\uf7dd\u0007<\u0000\uf7de\u0007<\u0000\uf7df\u0007<\u0000\uf7e0\u0007<\u0000\uf7e1\u0007<\u0000\uf7e2\u0007<\u0000\uf7e3\u0007<\u0000\uf7e4\u0007<\u0000\uf7e5\u0007<\u0000\uf7e6\u0007<\u0000\uf7e7\u0007<\u0000\uf7e8\u0007<\u0000\uf7e9\u0007<\u0000\uf7ea\u0007<\u0000\uf7eb\u0007<\u0000\uf7ec\u0007<\u0000\uf7ed\u0007<\u0000\uf7ee\u0007<\u0000\uf7ef\u0007<\u0000\uf7f0\u0007<\u0000\uf7f1\u0007<\u0000\uf7f2\u0007<\u0000\uf7f3\u0007<\u0000\uf7f4\u0007<\u0000\uf7f5\u0007<\u0000\uf7f6\u0007<\u0000\uf7f9\u0007<\u0000\uf7fa\u0007<\u0000\uf7fc\u0007<\u0000\uf7fd\u0007<\u0000\uf7fe\u0007<\u0000\uf7ff\u0007<\u0000\uf800\u0007<\u0000\uf801\u0007<\u0000\uf802\u0007<\u0000\uf803\u0007<\u0000\uf804\u0007<\u0000\uf805\u0007<\u0000\uf807\u0007<\u0000\uf809\u0007<\u0000\uf80a\u0007<\u0000\uf80b\u0007<\u0000\uf80c\u0007<\u0000\uf80d\u0007<\u0000\uf80e\u0007<\u0000\uf80f\u0007<\u0000\uf810\u0007<\u0000\uf811\u0007<\u0000\uf812\u0007<\u0000\uf813\u0007<\u0000\uf814\u0007<\u0000\uf815\u0007<\u0000\uf816\u0007<\u0000\uf817\u0007<\u0000\uf818\u0007<\u0000\uf819\u0007<\u0000\uf81c\u0007<\u0000\uf81d\u0007<\u0000\uf81e\u0007<\u0000\uf81f\u0007<\u0000\uf820\u0007<\u0000\uf821\u0007<\u0000\uf822\u0007<\u0000\uf824\u0007<\u0000\uf825\u0007<\u0000\uf826\u0007<\u0000\uf827\u0007<\u0000\uf828\u0007<\u0000\uf829\u0007<\u0000\uf82a\u0007<\u0000\uf82b\u0007<\u0000\uf82c\u0007<\u0000\uf82d\u0007<\u0000\uf82e\u0007<\u0000\uf82f\u0007<\u0000\uf830\u0007<\u0000\uf831\u0007<\u0000\uf832\u0007<\u0000\uf833\u0007<\u0000\uf834\u0007<\u0000\uf835\u0007<\u0000\uf836\u0007<\u0000\uf837\u0007<\u0000\uf838\u0007<\u0000\uf839\u0007<\u0000\uf83a\u0007<\u0000\uf83b\u0007<\u0000\uf83c\u0007<\u0000\uf83d\u0007<\u0000\uf83e\u0007<\u0000\uf83f\u0007<\u0000\uf840\u0007<\u0000\uf841\u0007<\u0000\uf842\u0007<\u0000\uf843\u0007<\u0000\uf844\u0007<\u0000\uf845\u0007<\u0000\uf846\u0007<\u0000\uf847\u0007<\u0000\uf848\u0007<\u0000\uf849\u0007<\u0000\uf84a\u0007<\u0000\uf84b\u0007<\u0000\uf84c\u0007<\u0000\uf84d\u0007<\u0000\uf84e\u0007<\u0000\uf84f\u0007<\u0000\uf850\u0007<\u0000\uf851\u0007<\u0000\uf852\u0007<\u0000\uf853\u0007<\u0000\uf854\u0007<\u0000\uf855\u0007<\u0000\uf856\u0007<\u0000\uf857\u0007<\u0000\uf858\u0007<\u0000\uf859\u0007<\u0000\uf85a\u0007<\u0000\uf85b\u0007<\u0000\uf85c\u0007<\u0000\uf85d\u0007<\u0000\uf85e\u0007<\u0000\uf85f\u0007<\u0000\uf860\u0007<\u0000\uf861\u0007<\u0000\uf862\u0007<\u0000\uf863\u0007<\u0000\uf864\u0007<\u0000\uf865\u0007<\u0000\uf866\u0007<\u0000\uf867\u0007<\u0000\uf868\u0007<\u0000\uf869\u0007<\u0000\uf86a\u0007<\u0000\uf86b\u0007<\u0000\uf86c\u0007<\u0000\uf86d\u0007<\u0000\uf86e\u0007<\u0000\uf86f\u0007<\u0000\uf870\u0007<\u0000\uf871\u0007<\u0000\uf872\u0007<\u0000\uf873\u0007<\u0000\uf874\u0007<\u0000\uf875\u0007<\u0000\uf876\u0007<\u0000\uf877\u0007<\u0000\uf878\u0007<\u0000\uf879\u0007<\u0000\uf87a\u0007<\u0000\uf87b\u0007<\u0000\uf87c\u0007<\u0000\uf87d\u0007<\u0000\uf87e\u0007<\u0000\uf87f\u0007<\u0000\uf880\u0007<\u0000\uf881\u0007<\u0000\uf882\u0007<\u0000\uf883\u0007<\u0000\uf884\u0007<\u0000\uf885\u0007<\u0000\uf886\u0007<\u0000\uf887\u0007<\u0000\uf888\u0007<\u0000\uf889\u0007<\u0000\uf88a\u0007<\u0000\uf88b\u0007<\u0000\uf88c\u0007<\u0000\uf88d\u0007<\u0000\uf88e\u0007<\u0000\uf88f\u0007<\u0000\uf890\u0007<\u0000\uf891\u0007<\u0000\uf892\u0007<\u0000\uf893\u0007<\u0000\uf894\u0007<\u0000\uf895\u0007<\u0000\uf896\u0007<\u0000\uf897\u0007<\u0000\uf898\u0007<\u0000\uf899\u0007<\u0000\uf89a\u0007<\u0000\uf89b\u0007<\u0000\uf89c\u0007<\u0000\uf89d\u0007<\u0000\uf89e\u0007<\u0000\uf89f\u0007<\u0000\uf8a0\u0007<\u0000\uf8a1\u0007<\u0000\uf8a2\u0007<\u0000\uf8a3\u0007<\u0000\uf8a4\u0007<\u0000\uf8a5\u0007<\u0000\uf8a6\u0007<\u0000\uf8a7\u0007<\u0000\uf8a8\u0007<\u0000\uf8a9\u0007<\u0000\uf8aa\u0007<\u0000\uf8ab\u0007<\u0000\uf8ac\u0007<\u0000\uf8ad\u0007<\u0000\uf8ae\u0007<\u0000\uf8af\u0007<\u0000\uf8b0\u0007<\u0000", new Object[]{"trait_", "traitCase_", AuthOuterClass$ResponseAuth.class, UsersOuterClass$RequestImportContacts.class, UsersOuterClass$ResponseImportContacts.class, Sequence$RequestGetState.class, UpdateBoxStruct$SeqUpdate.class, Sequence$ResponseGetGroupState.class, UpdateBoxStruct$SeqUpdateTooLong.class, UpdateBoxStruct$WeakUpdate.class, PresenceOuterClass$RequestTyping.class, PresenceOuterClass$RequestSetOnline.class, PresenceOuterClass$RequestStopTyping.class, UsersOuterClass$RequestEditAvatar.class, PresenceOuterClass$RequestSubscribeToOnline.class, PresenceOuterClass$RequestSubscribeFromOnline.class, UpdateBoxStruct$NewSeqUpdate.class, Misc$ResponseVoid.class, PushOuterClass$RequestRegisterGooglePush.class, UsersOuterClass$RequestEditName.class, MessagingOuterClass$RequestMessageReceived.class, MessagingOuterClass$RequestMessageRead.class, GroupsOuterClass$RequestInviteUser.class, GroupsOuterClass$RequestLeaveGroup.class, GroupsOuterClass$RequestKickUser.class, Misc$ResponseSeq.class, UpdateBoxStruct$FatSeqUpdate.class, PresenceOuterClass$RequestSubscribeToGroupOnline.class, PresenceOuterClass$RequestSubscribeFromGroupOnline.class, AuthOuterClass$RequestGetAuthSessions.class, AuthOuterClass$ResponseGetAuthSessions.class, AuthOuterClass$RequestTerminateSession.class, AuthOuterClass$RequestTerminateAllSessions.class, AuthOuterClass$RequestSignOut.class, GroupsOuterClass$RequestEditGroupTitle.class, GroupsOuterClass$RequestEditGroupAvatar.class, UsersOuterClass$RequestGetContacts.class, UsersOuterClass$ResponseGetContacts.class, UsersOuterClass$RequestRemoveContact.class, UsersOuterClass$RequestRemoveAvatar.class, MessagingOuterClass$RequestSendMessage.class, UsersOuterClass$RequestEditUserLocalName.class, MessagingOuterClass$RequestDeleteMessage.class, MessagingOuterClass$RequestClearChat.class, MessagingOuterClass$RequestDeleteChat.class, GroupsOuterClass$RequestRemoveGroupAvatar.class, Misc$ResponseSeqDate.class, UsersOuterClass$ResponseEditAvatar.class, MessagingOuterClass$RequestLoadDialogs.class, MessagingOuterClass$ResponseLoadDialogs.class, UsersOuterClass$RequestSearchContacts.class, UsersOuterClass$ResponseSearchContacts.class, UsersOuterClass$RequestAddContact.class, GroupsOuterClass$ResponseEditGroupAvatar.class, MessagingOuterClass$RequestLoadHistory.class, MessagingOuterClass$ResponseLoadHistory.class, GroupsOuterClass$RequestEditGroupDefaultCardNumber.class, ConfigsOuterClass$RequestEditParameter.class, GroupsOuterClass$RequestGetGroupDefaultCardNumber.class, GroupsOuterClass$ResponseGetGroupDefaultCardNumber.class, ConfigsOuterClass$RequestGetParameters.class, ConfigsOuterClass$ResponseGetParameters.class, UsersOuterClass$RequestAddCard.class, KetfOuterClass$RequestGetUserContext.class, FilesOuterClass$RequestGetNasimFileUploadUrl.class, UsersOuterClass$RequestEditMyTimeZone.class, UsersOuterClass$RequestEditMyPreferredLanguages.class, KetfOuterClass$ResponseGetUserContext.class, Sequence$RequestGetGroupState.class, FilesOuterClass$ResponseGetNasimFileUploadUrl.class, GroupsOuterClass$RequestGetGroupInviteUrl.class, GroupsOuterClass$ResponseInviteUrl.class, GroupsOuterClass$RequestRevokeInviteUrl.class, GroupsOuterClass$RequestJoinGroup.class, GroupsOuterClass$ResponseJoinGroup.class, Sequence$RequestGetGroupDifference.class, AuthOuterClass$RequestValidateCode.class, AuthOuterClass$RequestSignUp.class, AuthOuterClass$RequestStartPhoneAuth.class, AuthOuterClass$ResponseStartPhoneAuth.class, Sequence$ResponseGetGroupDifference.class, UsersOuterClass$RequestEditNickName.class, UsersOuterClass$RequestCheckNickName.class, Misc$ResponseBool.class, AbacusOuterClass$RequestMessageSetReaction.class, UsersOuterClass$RequestEditAbout.class, GroupsOuterClass$RequestEditGroupAbout.class, GroupsOuterClass$ResponseCreateGroup.class, SearchOuterClass$RequestSearchMessages.class, SearchOuterClass$ResponseSearchMessages.class, AbacusOuterClass$ResponseReactionsResponse.class, AbacusOuterClass$RequestMessageRemoveReaction.class, SearchOuterClass$RequestSearchMessagesMore.class, MessagingOuterClass$RequestLoadGroupedDialogs.class, MessagingOuterClass$ResponseLoadGroupedDialogs.class, UsersOuterClass$RequestNotifyAboutDeviceInfo.class, GroupsOuterClass$RequestCreateGroup.class, SearchOuterClass$RequestSearchPeer.class, SearchOuterClass$ResponseSearchPeer.class, MessagingOuterClass$ResponseDialogsOrder.class, ImagesOuterClass$RequestLoadOwnStickers.class, ImagesOuterClass$ResponseLoadOwnStickers.class, ImagesOuterClass$ResponseStickersReponse.class, ImagesOuterClass$RequestAddStickerCollection.class, ImagesOuterClass$RequestRemoveStickerCollection.class, ImagesOuterClass$RequestLoadStickerCollection.class, ImagesOuterClass$ResponseLoadStickerCollection.class, KetfOuterClass$RequestGetBotWhiteList.class, GroupsOuterClass$RequestPinMessage.class, GroupsOuterClass$RequestRemovePin.class, AuthOuterClass$RequestGetJWTToken.class, AuthOuterClass$ResponseGetJWTToken.class, GroupsOuterClass$RequestSetCanSeeMessages.class, GroupsOuterClass$ResponseCanSeeMessages.class, GroupsOuterClass$RequestGetCanSeeMessages.class, GroupsOuterClass$RequestSetRestriction.class, GroupsOuterClass$RequestFetchGroupAdmins.class, GroupsOuterClass$ResponseFetchGroupAdmins.class, UpdateBoxStruct$NewFatSeqUpdate.class, FilesOuterClass$RequestGetNasimFileUrls.class, FilesOuterClass$ResponseGetNasimFileUrls.class, UpdateBoxStruct$CombinedUpdate.class, Sequence$RequestGetReferencedEntitites.class, Sequence$ResponseGetReferencedEntitites.class, PushOuterClass$RequestUnregisterGooglePush.class, UsersOuterClass$RequestBlockUser.class, UsersOuterClass$RequestUnblockUser.class, UsersOuterClass$RequestLoadBlockedUsers.class, UsersOuterClass$ResponseLoadBlockedUsers.class, UsersOuterClass$RequestLoadFullUsers.class, UsersOuterClass$ResponseLoadFullUsers.class, MessagingOuterClass$RequestLoadArchived.class, MessagingOuterClass$ResponseLoadArchived.class, UsersOuterClass$RequestLoadAvatars.class, MessagingOuterClass$RequestUpdateMessage.class, UpdateBoxStruct$WeakFatUpdate.class, GroupsOuterClass$RequestLoadFullGroups.class, GroupsOuterClass$ResponseLoadFullGroups.class, GroupsOuterClass$RequestMakeUserAdmin.class, GroupsOuterClass$RequestLoadMembers.class, GroupsOuterClass$ResponseLoadMembers.class, GroupsOuterClass$RequestTransferOwnership.class, FilesOuterClass$ResponseGetNasimFileUrl.class, UsersOuterClass$ResponseLoadAvatars.class, FilesOuterClass$RequestGetNasimFileUrl.class, ImagesOuterClass$RequestAddGif.class, ImagesOuterClass$RequestRemoveGif.class, GroupsOuterClass$RequestJoinPublicGroup.class, GroupsOuterClass$ResponseJoinPublicGroup.class, FilesOuterClass$ResponseGetNasimFileUploadResume.class, FilesOuterClass$ResponseGetNasimFilePublicUrl.class, FilesOuterClass$RequestGetNasimFileUploadResume.class, FilesOuterClass$RequestGetNasimFilePublicUrl.class, AuthOuterClass$ResponseSendDeleteAccountVerificationCode.class, GroupsOuterClass$RequestEditChannelNick.class, KetfOuterClass$ResponseGetBotWhiteList.class, KetfOuterClass$RequestSendInlineCallBackData.class, AuthOuterClass$RequestDeleteAccount.class, AuthOuterClass$RequestSendDeleteAccountVerificationCode.class, GroupsOuterClass$RequestGetMyGroups.class, GroupsOuterClass$ResponseGetMyGroups.class, GroupsOuterClass$RequestLoadGroupAvatars.class, GroupsOuterClass$ResponseLoadGroupAvatars.class, GroupsOuterClass$RequestRemoveUserAdmin.class, BankOuterClass$RequestGetPSProxyToken.class, BankOuterClass$ResponseGetPSProxyToken.class, BankOuterClass$RequestGetPSProxyPaymentToken.class, BankOuterClass$ResponseGetPSProxyPaymentToken.class, BankOuterClass$RequestGetRemainToken.class, BankOuterClass$RequestGetCardTransferToken.class, BankOuterClass$ResponseGetCardTransferToken.class, BankOuterClass$RequestGetPayMoneyRequestToken.class, BankOuterClass$ResponseGetPayMoneyRequestToken.class, UsersOuterClass$RequestChangeDefaultCardNumber.class, BankOuterClass$RequestGetPayvandCardList.class, BankOuterClass$ResponseGetPayvandCardList.class, BankOuterClass$RequestGetPayvandCard.class, BankOuterClass$ResponseGetPayvandCard.class, BankOuterClass$ResponseGetRemainToken.class, UsersOuterClass$RequestRemoveDefaultCardNumber.class, BankOuterClass$RequestGetSadadPSPPaymentToken.class, BankOuterClass$ResponseGetSadadPSPPaymentToken.class, Microbanki$RequestGetMoneyRequestDetails.class, BankOuterClass$RequestGrantBankiAccess.class, Microbanki$ResponseGetMoneyRequestDetails.class, Microbanki$RequestGetMoneyRequestPaymentList.class, Microbanki$ResponseGetMoneyRequestPaymentList.class, ReactionsOuterClass$RequestBindMoneyRequestDetails.class, Microbanki$RequestGetBamServiceToken.class, Microbanki$ResponseGetBamServiceToken.class, BankOuterClass$RequestGetPaymentToken.class, BankOuterClass$ResponseGetPaymentToken.class, ReactionsOuterClass$RequestBindMoneyRequestDetailsList.class, ReactionsOuterClass$RequestUnbindAllMoneyRequestDetails.class, BankOuterClass$RequestGetRecentCharges.class, BankOuterClass$ResponseGetRecentCharges.class, BankOuterClass$RequestBuyFastCharge.class, BankOuterClass$ResponseBuyFastCharge.class, WalletOuterClass$ResponseGetWalletInvoice.class, WalletOuterClass$RequestGetMyWallets.class, WalletOuterClass$ResponseGetMyWallets.class, WalletOuterClass$RequestGetWalletChargeToken.class, WalletOuterClass$ResponseGetWalletChargeToken.class, WalletOuterClass$RequestPayByWallet.class, WalletOuterClass$RequestGetPaymentTokenByCard.class, WalletOuterClass$ResponseGetPaymentTokenByCard.class, WalletOuterClass$RequestVerifyQRCode.class, WalletOuterClass$ResponseVerifyQRCode.class, WalletOuterClass$RequestPayMoneyRequestByWallet.class, WalletOuterClass$RequestGetWalletInvoice.class, WalletOuterClass$RequestVerifyPeer.class, WalletOuterClass$ResponseVerifyPeer.class, WalletOuterClass$RequestGetWalletContracts.class, WalletOuterClass$ResponseGetWalletContracts.class, WalletOuterClass$RequestActivateWallet.class, BankOuterClass$RequestGetOTPToken.class, WalletOuterClass$RequestVerifyCashOut.class, WalletOuterClass$ResponseVerifyCashOut.class, WalletOuterClass$RequestCashOutFromWallet.class, BankOuterClass$ResponseGetOTPToken.class, WalletOuterClass$RequestGetMoneyRequestPaymentTokenByCard.class, WalletOuterClass$ResponseGetMoneyRequestPaymentTokenByCard.class, Giftpacket$ResponseGetGiftPacketPaymentToken.class, Giftpacket$RequestGetGiftPacketPaymentToken.class, Giftpacket$RequestSendGiftPacketWithWallet.class, Giftpacket$RequestOpenGiftPacket.class, Giftpacket$ResponseOpenGiftPacket.class, Seraj$RequestSendSerajEvent.class, AbacusOuterClass$RequestLoadReactions.class, AbacusOuterClass$ResponseLoadReactions.class, MyBankOuterClass$RequestGetMyBank.class, MyBankOuterClass$ResponseGetMyBank.class, GroupsOuterClass$RequestLoadGroups.class, GroupsOuterClass$ResponseLoadGroups.class, UsersOuterClass$RequestLoadUsers.class, UsersOuterClass$ResponseLoadUsers.class, MessagingOuterClass$RequestLoadPeerDialogs.class, MessagingOuterClass$ResponseLoadPeerDialogs.class, PushOuterClass$RequestUnregisterAllPushCredentials.class, ReactionsOuterClass$RequestGetReactions.class, ReactionsOuterClass$ResponseGetReactions.class, VitrineOuterClass$RequestGetUserVitrine.class, VitrineOuterClass$ResponseGetUserVitrine.class, BankOuterClass$RequestGetOTPTokenV2.class, BankOuterClass$ResponseGetOTPTokenV2.class, AuthOuterClass$RequestGetBaleTicket.class, AuthOuterClass$ResponseGetTicket.class, SearchOuterClass$RequestSearchMedia.class, SearchOuterClass$ResponseSearchMedia.class, AdvertisementOuterClass$RequestGetChannelAds.class, AdvertisementOuterClass$ResponseGetChannelAds.class, KifpoolOuterClass$RequestGetMyKifpools.class, KifpoolOuterClass$ResponseGetMyKifpools.class, KifpoolOuterClass$RequestUpgradeKifpool.class, KifpoolOuterClass$ResponseUpgradeKifpool.class, KifpoolOuterClass$RequestCreateKifpool.class, KifpoolOuterClass$ResponseCreateKifpool.class, KifpoolOuterClass$ResponseGetChargePaymentToken.class, KifpoolOuterClass$RequestCashOutKifpool.class, KifpoolOuterClass$ResponseCashOutKifpool.class, KifpoolOuterClass$RequestInvoiceKifpool.class, KifpoolOuterClass$ResponseInvoiceKifpool.class, KifpoolOuterClass$RequestTransferMoney.class, KifpoolOuterClass$ResponseTransferMoney.class, KifpoolOuterClass$RequestCheckChargePermission.class, KifpoolOuterClass$ResponseCheckChargePermission.class, KifpoolOuterClass$RequestCharge.class, KifpoolOuterClass$ResponseCharge.class, KifpoolOuterClass$RequestGetChargePaymentToken.class, KifpoolOuterClass$RequestPurchaseMessage.class, KifpoolOuterClass$ResponsePurchaseMessage.class, KifpoolOuterClass$RequestGetKifpoolOwner.class, KifpoolOuterClass$ResponseGetKifpoolOwner.class, KifpoolOuterClass$RequestPurchaseMessageWithCharge.class, KifpoolOuterClass$ResponsePurchaseMessageWithCharge.class, KifpoolOuterClass$RequestVerifyPurchaseMessage.class, KifpoolOuterClass$ResponseVerifyPurchaseMessage.class, KifpoolOuterClass$RequestVerifyCashOutKifpool.class, KifpoolOuterClass$ResponseVerifyCashOutKifpool.class, KifpoolOuterClass$RequestGetPointBalance.class, KifpoolOuterClass$ResponseGetPointBalance.class, AdvertisementOuterClass$RequestGetChannelEarnMoneyStatus.class, AdvertisementOuterClass$ResponseGetChannelEarnMoneyStatus.class, AdvertisementOuterClass$RequestRegisterForEarnMoney.class, AdvertisementOuterClass$RequestUpdateGroupStatus.class, AdvertisementOuterClass$RequestGetUserStatus.class, AdvertisementOuterClass$ResponseGetUserStatus.class, PfmOuterClass$RequestGetUserAccounts.class, PfmOuterClass$ResponseGetUserAccounts.class, PfmOuterClass$RequestLoadTransactions.class, PfmOuterClass$ResponseLoadTransactions.class, AdvertisementOuterClass$RequestGetChannelEarnMoneyInfo.class, AdvertisementOuterClass$ResponseGetChannelEarnMoneyInfo.class, PfmOuterClass$RequestAddTransactionTags.class, PfmOuterClass$RequestRemoveTransactionTags.class, KifpoolOuterClass$RequestGetPointSummery.class, KifpoolOuterClass$ResponseGetPointSummery.class, AuthOuterClass$RequestChangePhone.class, AuthOuterClass$RequestSendChangePhoneVerificationCode.class, GroupsOuterClass$RequestSetMemberPermissions.class, GroupsOuterClass$RequestGetMemberPermissions.class, GroupsOuterClass$ResponseGetMemberPermissions.class, KifpoolOuterClass$RequestGetPointDetails.class, KifpoolOuterClass$ResponseGetPointDetails.class, ReferralOuterClass$RequestGetReferringUser.class, ReferralOuterClass$ResponseGetReferringUser.class, KifpoolOuterClass$RequestTransactionPoint.class, KifpoolOuterClass$ResponseTransactionPoint.class, ClubOuterClass$RequestChangePointToMoney.class, ClubOuterClass$ResponseChangePointToMoney.class, ClubOuterClass$RequestBuyWheelChance.class, ClubOuterClass$ResponseBuyWheelChance.class, ClubOuterClass$RequestGetWheel.class, ClubOuterClass$ResponseGetWheel.class, ClubOuterClass$RequestSpinWheel.class, ClubOuterClass$ResponseSpinWheel.class, ClubOuterClass$RequestGetVouchers.class, ClubOuterClass$ResponseGetVouchers.class, ClubOuterClass$RequestBuyVoucher.class, ClubOuterClass$ResponseBuyVoucher.class, GroupsOuterClass$RequestSetGroupDefaultPermissions.class, ReferralOuterClass$RequestGetReferredCount.class, ReferralOuterClass$ResponseGetReferredCount.class, Saba$RequestGetWebViewTrackingNumber.class, Saba$ResponseGetWebViewTrackingNumber.class, Saba$RequestGetChargeTopupPaymentToken.class, Saba$RequestGetChargeVoucherPaymentToken.class, Saba$ResponseGetPspPaymentToken.class, SapOuterClass$RequestEnrollNewCard.class, SapOuterClass$ResponseEnrollNewCard.class, SapOuterClass$RequestGetCardInfo.class, SapOuterClass$ResponseGetCardInfo.class, SapOuterClass$RequestGetDestinationCardInfo.class, SapOuterClass$ResponseGetDestinationCardInfo.class, SapOuterClass$RequestDeliverOtp.class, SapOuterClass$RequestTransferMoneyByCard.class, EnrichmentOuterClass$RequestGetLinkPreview.class, EnrichmentOuterClass$ResponseGetLinkPreview.class, GroupsOuterClass$RequestGetGroupMembersCount.class, ReferralOuterClass$RequestGetReferralCode.class, ReferralOuterClass$ResponseGetReferralCode.class, ReferralOuterClass$RequestRefer.class, ReferralOuterClass$ResponseRefer.class, GroupsOuterClass$ResponseGetGroupMembersCount.class, AuthOuterClass$ResponseSendChangePhoneVerificationCode.class, Saba$RequestSetRecentOrder.class, Saba$RequestGetRecentOrders.class, Saba$ResponseGetRecentOrders.class, Saba$RequestDeleteOrder.class, Saba$RequestGetChargeAmounts.class, Saba$ResponseGetChargeAmounts.class, Crowdfunding$RequestGetParticipants.class, Crowdfunding$ResponseGetParticipants.class, PfmOuterClass$RequestGetTransactionTags.class, PfmOuterClass$ResponseGetTransactionTags.class, PfmOuterClass$RequestAddUserTags.class, PfmOuterClass$RequestRemoveUserTags.class, PfmOuterClass$RequestGetUserTags.class, PfmOuterClass$ResponseGetUserTags.class, VitrineOuterClass$RequestGetUserBank.class, VitrineOuterClass$ResponseGetUserBank.class, AdvertisementOuterClass$RequestGetAdProvider.class, AdvertisementOuterClass$ResponseGetAdProvider.class, Crowdfunding$RequestGetTotalPaidAmount.class, Crowdfunding$ResponseGetTotalPaidAmount.class, Feedback$RequestSendFeedBack.class, Charnet$RequestGetInternetBundlePaymentToken.class, Charnet$ResponseGetInternetBundlePaymentToken.class, Charnet$RequestGetInternetBundleList.class, Charnet$ResponseGetInternetBundleList.class, Charnet$RequestGetRecentInternetBundleOrders.class, Charnet$ResponseGetRecentInternetBundleOrders.class, Charnet$RequestDeleteInternetBundleOrder.class, Charnet$RequestBuyCharge.class, Charnet$ResponseBuyCharge.class, Charnet$RequestBuyInternetBundle.class, Charnet$ResponseBuyInternetBundle.class, UsersOuterClass$RequestGetUsersDefaultCardNumber.class, UsersOuterClass$ResponseGetUsersDefaultCardNumber.class, BillOuterClass$RequestInquiryBill.class, BillOuterClass$ResponseInquiryBill.class, BillOuterClass$RequestPayBill.class, BillOuterClass$ResponsePayBill.class, BillOuterClass$RequestGetBillHistory.class, BillOuterClass$ResponseGetBillHistory.class, BillOuterClass$RequestCreateSavedBill.class, BillOuterClass$ResponseCreateSavedBill.class, BillOuterClass$RequestGetSavedBills.class, BillOuterClass$ResponseGetSavedBills.class, BillOuterClass$RequestRenameSavedBill.class, BillOuterClass$RequestDeleteSavedBills.class, SapOuterClass$RequestAddNewCards.class, SapOuterClass$ResponseAddNewCards.class, SapOuterClass$RequestRemoveCard.class, SapOuterClass$RequestGetCards.class, SapOuterClass$ResponseGetCards.class, AdvertisementOuterClass$RequestUpdateView.class, AdvertisementOuterClass$ResponseUpdateView.class, SapOuterClass$RequestSetDefaultCard.class, SapOuterClass$RequestGetDefaultCard.class, SapOuterClass$ResponseGetDefaultCard.class, SapOuterClass$RequestRemoveDefaultCard.class, SapOuterClass$RequestEditCardExpirationDate.class, AdvertisementOuterClass$RequestSubmitDialogAdOrder.class, AdvertisementOuterClass$RequestGetDialogAdOrderDetails.class, AdvertisementOuterClass$ResponseGetDialogAdOrderDetails.class, AdvertisementOuterClass$RequestChangeStatusDialogAdOrder.class, AdvertisementOuterClass$RequestGetDialogAdOrderPaymentToken.class, AdvertisementOuterClass$ResponseGetDialogAdOrderPaymentToken.class, SentenceOuterClass$RequestGetMySentence.class, SentenceOuterClass$ResponseGetMySentence.class, SentenceOuterClass$RequestValidateMySentence.class, SentenceOuterClass$ResponseValidateMySentence.class, SentenceOuterClass$RequestSendMyGiftPacket.class, MeetOuterClass$RequestStartCall.class, MeetOuterClass$RequestAcceptCall.class, MeetOuterClass$RequestDiscardCall.class, MeetOuterClass$ResponseCall.class, MelonOuterClass$RequestGetLoanInfo.class, MelonOuterClass$ResponseGetLoanInfo.class, MelonOuterClass$RequestGetLoansList.class, MelonOuterClass$ResponseGetLoansList.class, SapOuterClass$RequestGetDestinationCards.class, SapOuterClass$ResponseGetDestinationCards.class, SapOuterClass$RequestAddDestinationCards.class, SapOuterClass$ResponseAddDestinationCards.class, SapOuterClass$RequestRemoveDestinationCards.class, SapOuterClass$RequestReactivateApp.class, SapOuterClass$ResponseReactivateApp.class, WarriorOuterClass$RequestGetScoreBoard.class, WarriorOuterClass$ResponseGetScoreBoard.class, WarriorOuterClass$RequestGetUserScore.class, WarriorOuterClass$ResponseGetUserScore.class, WarriorOuterClass$RequestGetPacketsStatus.class, WarriorOuterClass$ResponseGetPacketsStatus.class, WarriorOuterClass$RequestGetUserRefers.class, WarriorOuterClass$ResponseGetUserRefers.class, WarriorOuterClass$RequestGetReferralContacts.class, WarriorOuterClass$ResponseGetReferralContacts.class, WarriorOuterClass$RequestSendReferral.class, WarriorOuterClass$RequestGetPacket.class, WarriorOuterClass$RequestAcceptReferralInvite.class, SefteOuterClass$RequestAuthorizeUser.class, SefteOuterClass$ResponseAuthorizeUser.class, SefteOuterClass$RequestInitP12.class, SefteOuterClass$ResponseInitP12.class, SefteOuterClass$RequestInitSefte.class, SefteOuterClass$ResponseInitSefte.class, SefteOuterClass$RequestSignSefte.class, SefteOuterClass$ResponseSignSefte.class, SefteOuterClass$RequestPaySefte.class, SefteOuterClass$RequestGetStates.class, SefteOuterClass$ResponseGetStates.class, SefteOuterClass$RequestGetCitiesOfState.class, SefteOuterClass$ResponseGetCitiesOfState.class, SefteOuterClass$RequestCheckStatusOfPayment.class, SefteOuterClass$RequestGetUserSeftes.class, SefteOuterClass$ResponseGetUserSeftes.class, AdvertisementOuterClass$RequestUpdateClick.class, AdvertisementOuterClass$ResponseUpdateClick.class, SefteOuterClass$RequestUserHasCred.class, SefteOuterClass$ResponseUserHasCred.class, SefteOuterClass$RequestGetRecipients.class, SefteOuterClass$ResponseGetRecipients.class, SefteOuterClass$RequestAddRecipient.class, KifpoolOuterClass$RequestGetCryptoChargePaymentToken.class, PfmOuterClass$RequestFilterTaggedTransactions.class, PfmOuterClass$ResponseFilterTaggedTransactions.class, KifpoolOuterClass$RequestCryptoTransfer.class, KifpoolOuterClass$ResponseCryptoTransfer.class, KifpoolOuterClass$RequestGetCryptoWallets.class, KifpoolOuterClass$ResponseGetCryptoWallets.class, SefteOuterClass$ResponsePaySefte.class, ClubOuterClass$RequestGetAcquiredVouchers.class, ClubOuterClass$ResponseGetAcquiredVouchers.class, Protobuf$RequestProto.class, Protobuf$ResponseProto.class, PfmOuterClass$RequestAddDetailToTransaction.class, PresenceOuterClass$RequestGetGroupMembersPresence.class, PresenceOuterClass$ResponseGetGroupMembersPresence.class, PresenceOuterClass$RequestGetUsersPresence.class, PresenceOuterClass$ResponseGetUsersPresence.class, PfmOuterClass$RequestRemoveTransaction.class, PfmOuterClass$RequestSplitTransaction.class, PfmOuterClass$ResponseSplitTransaction.class, PfmOuterClass$RequestLoadTransactionsByIDs.class, PfmOuterClass$ResponseLoadTransactionsByIDs.class, UsersOuterClass$RequestEditSex.class, UsersOuterClass$RequestEditBirthDate.class, PfmOuterClass$RequestGetSubTransactions.class, PfmOuterClass$ResponseGetSubTransactions.class, PfmOuterClass$RequestReviveTransaction.class, MelonOuterClass$RequestLoadLoanHistory.class, MelonOuterClass$ResponseLoadLoanHistory.class, MelonOuterClass$RequestRemoveLoan.class, MelonOuterClass$RequestLoadLastStates.class, MelonOuterClass$ResponseLoadLastStates.class, UsersOuterClass$RequestResetContacts.class, MessagingOuterClass$RequestSendMultiMediaMessage.class, MessagingOuterClass$RequestGetMessagesRepliesInfo.class, MessagingOuterClass$ResponseGetMessagesRepliesInfo.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SetRpcStruct$ComposedRpc.class) {
                        try {
                            cVar = PARSER;
                            if (cVar == null) {
                                cVar = new GeneratedMessageLite.c(DEFAULT_INSTANCE);
                                PARSER = cVar;
                            }
                        } finally {
                        }
                    }
                }
                return cVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public MeetOuterClass$RequestAcceptCall getAcceptCall() {
        return this.traitCase_ == 63579 ? (MeetOuterClass$RequestAcceptCall) this.trait_ : MeetOuterClass$RequestAcceptCall.getDefaultInstance();
    }

    public WarriorOuterClass$RequestAcceptReferralInvite getAcceptReferralInvite() {
        return this.traitCase_ == 63605 ? (WarriorOuterClass$RequestAcceptReferralInvite) this.trait_ : WarriorOuterClass$RequestAcceptReferralInvite.getDefaultInstance();
    }

    public WalletOuterClass$RequestActivateWallet getActivateWallet() {
        return this.traitCase_ == 62760 ? (WalletOuterClass$RequestActivateWallet) this.trait_ : WalletOuterClass$RequestActivateWallet.getDefaultInstance();
    }

    public UsersOuterClass$RequestAddCard getAddCard() {
        return this.traitCase_ == 136 ? (UsersOuterClass$RequestAddCard) this.trait_ : UsersOuterClass$RequestAddCard.getDefaultInstance();
    }

    public UsersOuterClass$RequestAddContact getAddContact() {
        return this.traitCase_ == 114 ? (UsersOuterClass$RequestAddContact) this.trait_ : UsersOuterClass$RequestAddContact.getDefaultInstance();
    }

    public SapOuterClass$RequestAddDestinationCards getAddDestinationCards() {
        return this.traitCase_ == 63588 ? (SapOuterClass$RequestAddDestinationCards) this.trait_ : SapOuterClass$RequestAddDestinationCards.getDefaultInstance();
    }

    public PfmOuterClass$RequestAddDetailToTransaction getAddDetailToTransaction() {
        return this.traitCase_ == 63641 ? (PfmOuterClass$RequestAddDetailToTransaction) this.trait_ : PfmOuterClass$RequestAddDetailToTransaction.getDefaultInstance();
    }

    public ImagesOuterClass$RequestAddGif getAddGif() {
        return this.traitCase_ == 2857 ? (ImagesOuterClass$RequestAddGif) this.trait_ : ImagesOuterClass$RequestAddGif.getDefaultInstance();
    }

    public SapOuterClass$RequestAddNewCards getAddNewCards() {
        return this.traitCase_ == 63555 ? (SapOuterClass$RequestAddNewCards) this.trait_ : SapOuterClass$RequestAddNewCards.getDefaultInstance();
    }

    public SefteOuterClass$RequestAddRecipient getAddRecipient() {
        return this.traitCase_ == 63628 ? (SefteOuterClass$RequestAddRecipient) this.trait_ : SefteOuterClass$RequestAddRecipient.getDefaultInstance();
    }

    public ImagesOuterClass$RequestAddStickerCollection getAddStickerCollection() {
        return this.traitCase_ == 244 ? (ImagesOuterClass$RequestAddStickerCollection) this.trait_ : ImagesOuterClass$RequestAddStickerCollection.getDefaultInstance();
    }

    public PfmOuterClass$RequestAddTransactionTags getAddTransactionTags() {
        return this.traitCase_ == 63449 ? (PfmOuterClass$RequestAddTransactionTags) this.trait_ : PfmOuterClass$RequestAddTransactionTags.getDefaultInstance();
    }

    public PfmOuterClass$RequestAddUserTags getAddUserTags() {
        return this.traitCase_ == 63518 ? (PfmOuterClass$RequestAddUserTags) this.trait_ : PfmOuterClass$RequestAddUserTags.getDefaultInstance();
    }

    public SefteOuterClass$RequestAuthorizeUser getAuthorizeUser() {
        return this.traitCase_ == 63606 ? (SefteOuterClass$RequestAuthorizeUser) this.trait_ : SefteOuterClass$RequestAuthorizeUser.getDefaultInstance();
    }

    public ReactionsOuterClass$RequestBindMoneyRequestDetails getBindMoneyRequestDetails() {
        return this.traitCase_ == 62403 ? (ReactionsOuterClass$RequestBindMoneyRequestDetails) this.trait_ : ReactionsOuterClass$RequestBindMoneyRequestDetails.getDefaultInstance();
    }

    public ReactionsOuterClass$RequestBindMoneyRequestDetailsList getBindMoneyRequestDetailsList() {
        return this.traitCase_ == 62410 ? (ReactionsOuterClass$RequestBindMoneyRequestDetailsList) this.trait_ : ReactionsOuterClass$RequestBindMoneyRequestDetailsList.getDefaultInstance();
    }

    public UsersOuterClass$RequestBlockUser getBlockUser() {
        return this.traitCase_ == 2636 ? (UsersOuterClass$RequestBlockUser) this.trait_ : UsersOuterClass$RequestBlockUser.getDefaultInstance();
    }

    public Charnet$RequestBuyCharge getBuyCharge() {
        return this.traitCase_ == 63537 ? (Charnet$RequestBuyCharge) this.trait_ : Charnet$RequestBuyCharge.getDefaultInstance();
    }

    public BankOuterClass$RequestBuyFastCharge getBuyFastCharge() {
        return this.traitCase_ == 62464 ? (BankOuterClass$RequestBuyFastCharge) this.trait_ : BankOuterClass$RequestBuyFastCharge.getDefaultInstance();
    }

    public Charnet$RequestBuyInternetBundle getBuyInternetBundle() {
        return this.traitCase_ == 63539 ? (Charnet$RequestBuyInternetBundle) this.trait_ : Charnet$RequestBuyInternetBundle.getDefaultInstance();
    }

    public ClubOuterClass$RequestBuyVoucher getBuyVoucher() {
        return this.traitCase_ == 63474 ? (ClubOuterClass$RequestBuyVoucher) this.trait_ : ClubOuterClass$RequestBuyVoucher.getDefaultInstance();
    }

    public ClubOuterClass$RequestBuyWheelChance getBuyWheelChance() {
        return this.traitCase_ == 63466 ? (ClubOuterClass$RequestBuyWheelChance) this.trait_ : ClubOuterClass$RequestBuyWheelChance.getDefaultInstance();
    }

    public WalletOuterClass$RequestCashOutFromWallet getCashOutFromWallet() {
        return this.traitCase_ == 62764 ? (WalletOuterClass$RequestCashOutFromWallet) this.trait_ : WalletOuterClass$RequestCashOutFromWallet.getDefaultInstance();
    }

    public KifpoolOuterClass$RequestCashOutKifpool getCashoutKifpool() {
        return this.traitCase_ == 63407 ? (KifpoolOuterClass$RequestCashOutKifpool) this.trait_ : KifpoolOuterClass$RequestCashOutKifpool.getDefaultInstance();
    }

    public UsersOuterClass$RequestChangeDefaultCardNumber getChangeDefaultCardNumber() {
        return this.traitCase_ == 62129 ? (UsersOuterClass$RequestChangeDefaultCardNumber) this.trait_ : UsersOuterClass$RequestChangeDefaultCardNumber.getDefaultInstance();
    }

    public AuthOuterClass$RequestChangePhone getChangePhone() {
        return this.traitCase_ == 63453 ? (AuthOuterClass$RequestChangePhone) this.trait_ : AuthOuterClass$RequestChangePhone.getDefaultInstance();
    }

    public ClubOuterClass$RequestChangePointToMoney getChangePointToMoney() {
        return this.traitCase_ == 63464 ? (ClubOuterClass$RequestChangePointToMoney) this.trait_ : ClubOuterClass$RequestChangePointToMoney.getDefaultInstance();
    }

    public AdvertisementOuterClass$RequestChangeStatusDialogAdOrder getChangeStatusDialogAdOrder() {
        return this.traitCase_ == 63570 ? (AdvertisementOuterClass$RequestChangeStatusDialogAdOrder) this.trait_ : AdvertisementOuterClass$RequestChangeStatusDialogAdOrder.getDefaultInstance();
    }

    public KifpoolOuterClass$RequestCharge getCharge() {
        return this.traitCase_ == 63415 ? (KifpoolOuterClass$RequestCharge) this.trait_ : KifpoolOuterClass$RequestCharge.getDefaultInstance();
    }

    public KifpoolOuterClass$RequestCheckChargePermission getCheckChargePermission() {
        return this.traitCase_ == 63413 ? (KifpoolOuterClass$RequestCheckChargePermission) this.trait_ : KifpoolOuterClass$RequestCheckChargePermission.getDefaultInstance();
    }

    public UsersOuterClass$RequestCheckNickName getCheckNickName() {
        return this.traitCase_ == 206 ? (UsersOuterClass$RequestCheckNickName) this.trait_ : UsersOuterClass$RequestCheckNickName.getDefaultInstance();
    }

    public SefteOuterClass$RequestCheckStatusOfPayment getCheckStatusOfPayment() {
        return this.traitCase_ == 63619 ? (SefteOuterClass$RequestCheckStatusOfPayment) this.trait_ : SefteOuterClass$RequestCheckStatusOfPayment.getDefaultInstance();
    }

    public MessagingOuterClass$RequestClearChat getClearChat() {
        return this.traitCase_ == 99 ? (MessagingOuterClass$RequestClearChat) this.trait_ : MessagingOuterClass$RequestClearChat.getDefaultInstance();
    }

    public UpdateBoxStruct$CombinedUpdate getCombinedUpdate() {
        return this.traitCase_ == 2625 ? (UpdateBoxStruct$CombinedUpdate) this.trait_ : UpdateBoxStruct$CombinedUpdate.getDefaultInstance();
    }

    public GroupsOuterClass$RequestCreateGroup getCreateGroup() {
        return this.traitCase_ == 230 ? (GroupsOuterClass$RequestCreateGroup) this.trait_ : GroupsOuterClass$RequestCreateGroup.getDefaultInstance();
    }

    public KifpoolOuterClass$RequestCreateKifpool getCreateKifpool() {
        return this.traitCase_ == 63404 ? (KifpoolOuterClass$RequestCreateKifpool) this.trait_ : KifpoolOuterClass$RequestCreateKifpool.getDefaultInstance();
    }

    public BillOuterClass$RequestCreateSavedBill getCreateSavedBill() {
        return this.traitCase_ == 63549 ? (BillOuterClass$RequestCreateSavedBill) this.trait_ : BillOuterClass$RequestCreateSavedBill.getDefaultInstance();
    }

    public KifpoolOuterClass$RequestCryptoTransfer getCryptoTransfer() {
        return this.traitCase_ == 63632 ? (KifpoolOuterClass$RequestCryptoTransfer) this.trait_ : KifpoolOuterClass$RequestCryptoTransfer.getDefaultInstance();
    }

    public AuthOuterClass$RequestDeleteAccount getDeleteAccount() {
        return this.traitCase_ == 43606 ? (AuthOuterClass$RequestDeleteAccount) this.trait_ : AuthOuterClass$RequestDeleteAccount.getDefaultInstance();
    }

    public MessagingOuterClass$RequestDeleteChat getDeleteChat() {
        return this.traitCase_ == 100 ? (MessagingOuterClass$RequestDeleteChat) this.trait_ : MessagingOuterClass$RequestDeleteChat.getDefaultInstance();
    }

    public Charnet$RequestDeleteInternetBundleOrder getDeleteInternetBundleOrder() {
        return this.traitCase_ == 63536 ? (Charnet$RequestDeleteInternetBundleOrder) this.trait_ : Charnet$RequestDeleteInternetBundleOrder.getDefaultInstance();
    }

    public MessagingOuterClass$RequestDeleteMessage getDeleteMessage() {
        return this.traitCase_ == 98 ? (MessagingOuterClass$RequestDeleteMessage) this.trait_ : MessagingOuterClass$RequestDeleteMessage.getDefaultInstance();
    }

    public Saba$RequestDeleteOrder getDeleteOrder() {
        return this.traitCase_ == 63509 ? (Saba$RequestDeleteOrder) this.trait_ : Saba$RequestDeleteOrder.getDefaultInstance();
    }

    public BillOuterClass$RequestDeleteSavedBills getDeleteSavedBills() {
        return this.traitCase_ == 63554 ? (BillOuterClass$RequestDeleteSavedBills) this.trait_ : BillOuterClass$RequestDeleteSavedBills.getDefaultInstance();
    }

    public SapOuterClass$RequestDeliverOtp getDeliverOtp() {
        return this.traitCase_ == 63493 ? (SapOuterClass$RequestDeliverOtp) this.trait_ : SapOuterClass$RequestDeliverOtp.getDefaultInstance();
    }

    public MeetOuterClass$RequestDiscardCall getDiscardCall() {
        return this.traitCase_ == 63580 ? (MeetOuterClass$RequestDiscardCall) this.trait_ : MeetOuterClass$RequestDiscardCall.getDefaultInstance();
    }

    public UsersOuterClass$RequestEditAbout getEditAbout() {
        return this.traitCase_ == 212 ? (UsersOuterClass$RequestEditAbout) this.trait_ : UsersOuterClass$RequestEditAbout.getDefaultInstance();
    }

    public UsersOuterClass$RequestEditAvatar getEditAvatar() {
        return this.traitCase_ == 31 ? (UsersOuterClass$RequestEditAvatar) this.trait_ : UsersOuterClass$RequestEditAvatar.getDefaultInstance();
    }

    public UsersOuterClass$RequestEditBirthDate getEditBirthDate() {
        return this.traitCase_ == 63652 ? (UsersOuterClass$RequestEditBirthDate) this.trait_ : UsersOuterClass$RequestEditBirthDate.getDefaultInstance();
    }

    public SapOuterClass$RequestEditCardExpirationDate getEditCardExpirationDate() {
        return this.traitCase_ == 63566 ? (SapOuterClass$RequestEditCardExpirationDate) this.trait_ : SapOuterClass$RequestEditCardExpirationDate.getDefaultInstance();
    }

    public GroupsOuterClass$RequestEditChannelNick getEditChannelNick() {
        return this.traitCase_ == 3396 ? (GroupsOuterClass$RequestEditChannelNick) this.trait_ : GroupsOuterClass$RequestEditChannelNick.getDefaultInstance();
    }

    public GroupsOuterClass$RequestEditGroupAbout getEditGroupAbout() {
        return this.traitCase_ == 213 ? (GroupsOuterClass$RequestEditGroupAbout) this.trait_ : GroupsOuterClass$RequestEditGroupAbout.getDefaultInstance();
    }

    public GroupsOuterClass$RequestEditGroupAvatar getEditGroupAvatar() {
        return this.traitCase_ == 86 ? (GroupsOuterClass$RequestEditGroupAvatar) this.trait_ : GroupsOuterClass$RequestEditGroupAvatar.getDefaultInstance();
    }

    public GroupsOuterClass$RequestEditGroupDefaultCardNumber getEditGroupDefaultCardNumber() {
        return this.traitCase_ == 120 ? (GroupsOuterClass$RequestEditGroupDefaultCardNumber) this.trait_ : GroupsOuterClass$RequestEditGroupDefaultCardNumber.getDefaultInstance();
    }

    public GroupsOuterClass$RequestEditGroupTitle getEditGroupTitle() {
        return this.traitCase_ == 85 ? (GroupsOuterClass$RequestEditGroupTitle) this.trait_ : GroupsOuterClass$RequestEditGroupTitle.getDefaultInstance();
    }

    public UsersOuterClass$RequestEditMyPreferredLanguages getEditMyPreferredLanguages() {
        return this.traitCase_ == 145 ? (UsersOuterClass$RequestEditMyPreferredLanguages) this.trait_ : UsersOuterClass$RequestEditMyPreferredLanguages.getDefaultInstance();
    }

    public UsersOuterClass$RequestEditMyTimeZone getEditMyTimeZone() {
        return this.traitCase_ == 144 ? (UsersOuterClass$RequestEditMyTimeZone) this.trait_ : UsersOuterClass$RequestEditMyTimeZone.getDefaultInstance();
    }

    public UsersOuterClass$RequestEditName getEditName() {
        return this.traitCase_ == 53 ? (UsersOuterClass$RequestEditName) this.trait_ : UsersOuterClass$RequestEditName.getDefaultInstance();
    }

    public UsersOuterClass$RequestEditNickName getEditNickName() {
        return this.traitCase_ == 205 ? (UsersOuterClass$RequestEditNickName) this.trait_ : UsersOuterClass$RequestEditNickName.getDefaultInstance();
    }

    public ConfigsOuterClass$RequestEditParameter getEditParameter() {
        return this.traitCase_ == 128 ? (ConfigsOuterClass$RequestEditParameter) this.trait_ : ConfigsOuterClass$RequestEditParameter.getDefaultInstance();
    }

    public UsersOuterClass$RequestEditSex getEditSex() {
        return this.traitCase_ == 63651 ? (UsersOuterClass$RequestEditSex) this.trait_ : UsersOuterClass$RequestEditSex.getDefaultInstance();
    }

    public UsersOuterClass$RequestEditUserLocalName getEditUserLocalName() {
        return this.traitCase_ == 96 ? (UsersOuterClass$RequestEditUserLocalName) this.trait_ : UsersOuterClass$RequestEditUserLocalName.getDefaultInstance();
    }

    public SapOuterClass$RequestEnrollNewCard getEnrollNewCard() {
        return this.traitCase_ == 63487 ? (SapOuterClass$RequestEnrollNewCard) this.trait_ : SapOuterClass$RequestEnrollNewCard.getDefaultInstance();
    }

    public UpdateBoxStruct$FatSeqUpdate getFatSeqUpdate() {
        return this.traitCase_ == 73 ? (UpdateBoxStruct$FatSeqUpdate) this.trait_ : UpdateBoxStruct$FatSeqUpdate.getDefaultInstance();
    }

    public GroupsOuterClass$RequestFetchGroupAdmins getFetchGroupAdmins() {
        return this.traitCase_ == 729 ? (GroupsOuterClass$RequestFetchGroupAdmins) this.trait_ : GroupsOuterClass$RequestFetchGroupAdmins.getDefaultInstance();
    }

    public PfmOuterClass$RequestFilterTaggedTransactions getFilterTaggedTransactions() {
        return this.traitCase_ == 63630 ? (PfmOuterClass$RequestFilterTaggedTransactions) this.trait_ : PfmOuterClass$RequestFilterTaggedTransactions.getDefaultInstance();
    }

    public ClubOuterClass$RequestGetAcquiredVouchers getGetAcquiredVouchers() {
        return this.traitCase_ == 63637 ? (ClubOuterClass$RequestGetAcquiredVouchers) this.trait_ : ClubOuterClass$RequestGetAcquiredVouchers.getDefaultInstance();
    }

    public AdvertisementOuterClass$RequestGetAdProvider getGetAdProvider() {
        return this.traitCase_ == 63525 ? (AdvertisementOuterClass$RequestGetAdProvider) this.trait_ : AdvertisementOuterClass$RequestGetAdProvider.getDefaultInstance();
    }

    public AuthOuterClass$RequestGetAuthSessions getGetAuthSessions() {
        return this.traitCase_ == 80 ? (AuthOuterClass$RequestGetAuthSessions) this.trait_ : AuthOuterClass$RequestGetAuthSessions.getDefaultInstance();
    }

    public AuthOuterClass$RequestGetBaleTicket getGetBaleTicket() {
        return this.traitCase_ == 63260 ? (AuthOuterClass$RequestGetBaleTicket) this.trait_ : AuthOuterClass$RequestGetBaleTicket.getDefaultInstance();
    }

    public Microbanki$RequestGetBamServiceToken getGetBamServiceToken() {
        return this.traitCase_ == 62406 ? (Microbanki$RequestGetBamServiceToken) this.trait_ : Microbanki$RequestGetBamServiceToken.getDefaultInstance();
    }

    public BillOuterClass$RequestGetBillHistory getGetBillHistory() {
        return this.traitCase_ == 63547 ? (BillOuterClass$RequestGetBillHistory) this.trait_ : BillOuterClass$RequestGetBillHistory.getDefaultInstance();
    }

    public KetfOuterClass$RequestGetBotWhiteList getGetBotWhiteList() {
        return this.traitCase_ == 249 ? (KetfOuterClass$RequestGetBotWhiteList) this.trait_ : KetfOuterClass$RequestGetBotWhiteList.getDefaultInstance();
    }

    public GroupsOuterClass$RequestGetCanSeeMessages getGetCanSeeMessages() {
        return this.traitCase_ == 726 ? (GroupsOuterClass$RequestGetCanSeeMessages) this.trait_ : GroupsOuterClass$RequestGetCanSeeMessages.getDefaultInstance();
    }

    public SapOuterClass$RequestGetCardInfo getGetCardInfo() {
        return this.traitCase_ == 63489 ? (SapOuterClass$RequestGetCardInfo) this.trait_ : SapOuterClass$RequestGetCardInfo.getDefaultInstance();
    }

    public BankOuterClass$RequestGetCardTransferToken getGetCardTransferToken() {
        return this.traitCase_ == 62125 ? (BankOuterClass$RequestGetCardTransferToken) this.trait_ : BankOuterClass$RequestGetCardTransferToken.getDefaultInstance();
    }

    public SapOuterClass$RequestGetCards getGetCards() {
        return this.traitCase_ == 63558 ? (SapOuterClass$RequestGetCards) this.trait_ : SapOuterClass$RequestGetCards.getDefaultInstance();
    }

    public AdvertisementOuterClass$RequestGetChannelAds getGetChannelAds() {
        return this.traitCase_ == 63264 ? (AdvertisementOuterClass$RequestGetChannelAds) this.trait_ : AdvertisementOuterClass$RequestGetChannelAds.getDefaultInstance();
    }

    public AdvertisementOuterClass$RequestGetChannelEarnMoneyInfo getGetChannelEarnMoneyInfo() {
        return this.traitCase_ == 63447 ? (AdvertisementOuterClass$RequestGetChannelEarnMoneyInfo) this.trait_ : AdvertisementOuterClass$RequestGetChannelEarnMoneyInfo.getDefaultInstance();
    }

    public AdvertisementOuterClass$RequestGetChannelEarnMoneyStatus getGetChannelEarnMoneyStatus() {
        return this.traitCase_ == 63436 ? (AdvertisementOuterClass$RequestGetChannelEarnMoneyStatus) this.trait_ : AdvertisementOuterClass$RequestGetChannelEarnMoneyStatus.getDefaultInstance();
    }

    public Saba$RequestGetChargeAmounts getGetChargeAmounts() {
        return this.traitCase_ == 63510 ? (Saba$RequestGetChargeAmounts) this.trait_ : Saba$RequestGetChargeAmounts.getDefaultInstance();
    }

    public KifpoolOuterClass$RequestGetChargePaymentToken getGetChargePaymentToken() {
        return this.traitCase_ == 63417 ? (KifpoolOuterClass$RequestGetChargePaymentToken) this.trait_ : KifpoolOuterClass$RequestGetChargePaymentToken.getDefaultInstance();
    }

    public Saba$RequestGetChargeTopupPaymentToken getGetChargeTopupPaymentToken() {
        return this.traitCase_ == 63484 ? (Saba$RequestGetChargeTopupPaymentToken) this.trait_ : Saba$RequestGetChargeTopupPaymentToken.getDefaultInstance();
    }

    public Saba$RequestGetChargeVoucherPaymentToken getGetChargeVoucherPaymentToken() {
        return this.traitCase_ == 63485 ? (Saba$RequestGetChargeVoucherPaymentToken) this.trait_ : Saba$RequestGetChargeVoucherPaymentToken.getDefaultInstance();
    }

    public SefteOuterClass$RequestGetCitiesOfState getGetCitiesOfState() {
        return this.traitCase_ == 63617 ? (SefteOuterClass$RequestGetCitiesOfState) this.trait_ : SefteOuterClass$RequestGetCitiesOfState.getDefaultInstance();
    }

    public UsersOuterClass$RequestGetContacts getGetContacts() {
        return this.traitCase_ == 87 ? (UsersOuterClass$RequestGetContacts) this.trait_ : UsersOuterClass$RequestGetContacts.getDefaultInstance();
    }

    public KifpoolOuterClass$RequestGetCryptoChargePaymentToken getGetCryptoChargePaymentToken() {
        return this.traitCase_ == 63629 ? (KifpoolOuterClass$RequestGetCryptoChargePaymentToken) this.trait_ : KifpoolOuterClass$RequestGetCryptoChargePaymentToken.getDefaultInstance();
    }

    public KifpoolOuterClass$RequestGetCryptoWallets getGetCryptoWallets() {
        return this.traitCase_ == 63634 ? (KifpoolOuterClass$RequestGetCryptoWallets) this.trait_ : KifpoolOuterClass$RequestGetCryptoWallets.getDefaultInstance();
    }

    public SapOuterClass$RequestGetDefaultCard getGetDefaultCard() {
        return this.traitCase_ == 63563 ? (SapOuterClass$RequestGetDefaultCard) this.trait_ : SapOuterClass$RequestGetDefaultCard.getDefaultInstance();
    }

    public SapOuterClass$RequestGetDestinationCardInfo getGetDestinationCardInfo() {
        return this.traitCase_ == 63491 ? (SapOuterClass$RequestGetDestinationCardInfo) this.trait_ : SapOuterClass$RequestGetDestinationCardInfo.getDefaultInstance();
    }

    public SapOuterClass$RequestGetDestinationCards getGetDestinationCards() {
        return this.traitCase_ == 63586 ? (SapOuterClass$RequestGetDestinationCards) this.trait_ : SapOuterClass$RequestGetDestinationCards.getDefaultInstance();
    }

    public AdvertisementOuterClass$RequestGetDialogAdOrderDetails getGetDialogAdOrderDetails() {
        return this.traitCase_ == 63568 ? (AdvertisementOuterClass$RequestGetDialogAdOrderDetails) this.trait_ : AdvertisementOuterClass$RequestGetDialogAdOrderDetails.getDefaultInstance();
    }

    public AdvertisementOuterClass$RequestGetDialogAdOrderPaymentToken getGetDialogAdOrderPaymentToken() {
        return this.traitCase_ == 63571 ? (AdvertisementOuterClass$RequestGetDialogAdOrderPaymentToken) this.trait_ : AdvertisementOuterClass$RequestGetDialogAdOrderPaymentToken.getDefaultInstance();
    }

    public Giftpacket$RequestGetGiftPacketPaymentToken getGetGiftPacketPaymentToken() {
        return this.traitCase_ == 63232 ? (Giftpacket$RequestGetGiftPacketPaymentToken) this.trait_ : Giftpacket$RequestGetGiftPacketPaymentToken.getDefaultInstance();
    }

    public GroupsOuterClass$RequestGetGroupDefaultCardNumber getGetGroupDefaultCardNumber() {
        return this.traitCase_ == 129 ? (GroupsOuterClass$RequestGetGroupDefaultCardNumber) this.trait_ : GroupsOuterClass$RequestGetGroupDefaultCardNumber.getDefaultInstance();
    }

    public Sequence$RequestGetGroupDifference getGetGroupDifference() {
        return this.traitCase_ == 187 ? (Sequence$RequestGetGroupDifference) this.trait_ : Sequence$RequestGetGroupDifference.getDefaultInstance();
    }

    public GroupsOuterClass$RequestGetGroupInviteUrl getGetGroupInviteUrl() {
        return this.traitCase_ == 177 ? (GroupsOuterClass$RequestGetGroupInviteUrl) this.trait_ : GroupsOuterClass$RequestGetGroupInviteUrl.getDefaultInstance();
    }

    public GroupsOuterClass$RequestGetGroupMembersCount getGetGroupMembersCount() {
        return this.traitCase_ == 63499 ? (GroupsOuterClass$RequestGetGroupMembersCount) this.trait_ : GroupsOuterClass$RequestGetGroupMembersCount.getDefaultInstance();
    }

    public PresenceOuterClass$RequestGetGroupMembersPresence getGetGroupMembersPresence() {
        return this.traitCase_ == 63642 ? (PresenceOuterClass$RequestGetGroupMembersPresence) this.trait_ : PresenceOuterClass$RequestGetGroupMembersPresence.getDefaultInstance();
    }

    public Sequence$RequestGetGroupState getGetGroupState() {
        return this.traitCase_ == 153 ? (Sequence$RequestGetGroupState) this.trait_ : Sequence$RequestGetGroupState.getDefaultInstance();
    }

    public Charnet$RequestGetInternetBundleList getGetInternetBundleList() {
        return this.traitCase_ == 63532 ? (Charnet$RequestGetInternetBundleList) this.trait_ : Charnet$RequestGetInternetBundleList.getDefaultInstance();
    }

    public Charnet$RequestGetInternetBundlePaymentToken getGetInternetBundlePaymentToken() {
        return this.traitCase_ == 63530 ? (Charnet$RequestGetInternetBundlePaymentToken) this.trait_ : Charnet$RequestGetInternetBundlePaymentToken.getDefaultInstance();
    }

    public AuthOuterClass$RequestGetJWTToken getGetJwtToken() {
        return this.traitCase_ == 600 ? (AuthOuterClass$RequestGetJWTToken) this.trait_ : AuthOuterClass$RequestGetJWTToken.getDefaultInstance();
    }

    public KifpoolOuterClass$RequestGetKifpoolOwner getGetKifpoolOwner() {
        return this.traitCase_ == 63420 ? (KifpoolOuterClass$RequestGetKifpoolOwner) this.trait_ : KifpoolOuterClass$RequestGetKifpoolOwner.getDefaultInstance();
    }

    public EnrichmentOuterClass$RequestGetLinkPreview getGetLinkPreview() {
        return this.traitCase_ == 63497 ? (EnrichmentOuterClass$RequestGetLinkPreview) this.trait_ : EnrichmentOuterClass$RequestGetLinkPreview.getDefaultInstance();
    }

    public MelonOuterClass$RequestGetLoanInfo getGetLoanInfo() {
        return this.traitCase_ == 63582 ? (MelonOuterClass$RequestGetLoanInfo) this.trait_ : MelonOuterClass$RequestGetLoanInfo.getDefaultInstance();
    }

    public MelonOuterClass$RequestGetLoansList getGetLoansList() {
        return this.traitCase_ == 63584 ? (MelonOuterClass$RequestGetLoansList) this.trait_ : MelonOuterClass$RequestGetLoansList.getDefaultInstance();
    }

    public GroupsOuterClass$RequestGetMemberPermissions getGetMemberPermissions() {
        return this.traitCase_ == 63456 ? (GroupsOuterClass$RequestGetMemberPermissions) this.trait_ : GroupsOuterClass$RequestGetMemberPermissions.getDefaultInstance();
    }

    public MessagingOuterClass$RequestGetMessagesRepliesInfo getGetMessagesRepliesInfo() {
        return this.traitCase_ == 63663 ? (MessagingOuterClass$RequestGetMessagesRepliesInfo) this.trait_ : MessagingOuterClass$RequestGetMessagesRepliesInfo.getDefaultInstance();
    }

    public Microbanki$RequestGetMoneyRequestDetails getGetMoneyRequestDetails() {
        return this.traitCase_ == 62393 ? (Microbanki$RequestGetMoneyRequestDetails) this.trait_ : Microbanki$RequestGetMoneyRequestDetails.getDefaultInstance();
    }

    public Microbanki$RequestGetMoneyRequestPaymentList getGetMoneyRequestPaymentList() {
        return this.traitCase_ == 62401 ? (Microbanki$RequestGetMoneyRequestPaymentList) this.trait_ : Microbanki$RequestGetMoneyRequestPaymentList.getDefaultInstance();
    }

    public WalletOuterClass$RequestGetMoneyRequestPaymentTokenByCard getGetMoneyRequestPaymentTokenByCard() {
        return this.traitCase_ == 62769 ? (WalletOuterClass$RequestGetMoneyRequestPaymentTokenByCard) this.trait_ : WalletOuterClass$RequestGetMoneyRequestPaymentTokenByCard.getDefaultInstance();
    }

    public MyBankOuterClass$RequestGetMyBank getGetMyBank() {
        return this.traitCase_ == 63243 ? (MyBankOuterClass$RequestGetMyBank) this.trait_ : MyBankOuterClass$RequestGetMyBank.getDefaultInstance();
    }

    public GroupsOuterClass$RequestGetMyGroups getGetMyGroups() {
        return this.traitCase_ == 43746 ? (GroupsOuterClass$RequestGetMyGroups) this.trait_ : GroupsOuterClass$RequestGetMyGroups.getDefaultInstance();
    }

    public KifpoolOuterClass$RequestGetMyKifpools getGetMyKifpools() {
        return this.traitCase_ == 63400 ? (KifpoolOuterClass$RequestGetMyKifpools) this.trait_ : KifpoolOuterClass$RequestGetMyKifpools.getDefaultInstance();
    }

    public SentenceOuterClass$RequestGetMySentence getGetMySentence() {
        return this.traitCase_ == 63573 ? (SentenceOuterClass$RequestGetMySentence) this.trait_ : SentenceOuterClass$RequestGetMySentence.getDefaultInstance();
    }

    public WalletOuterClass$RequestGetMyWallets getGetMyWallets() {
        return this.traitCase_ == 62730 ? (WalletOuterClass$RequestGetMyWallets) this.trait_ : WalletOuterClass$RequestGetMyWallets.getDefaultInstance();
    }

    public FilesOuterClass$RequestGetNasimFilePublicUrl getGetNasimFilePublicUrl() {
        return this.traitCase_ == 3072 ? (FilesOuterClass$RequestGetNasimFilePublicUrl) this.trait_ : FilesOuterClass$RequestGetNasimFilePublicUrl.getDefaultInstance();
    }

    public FilesOuterClass$RequestGetNasimFileUploadResume getGetNasimFileUploadResume() {
        return this.traitCase_ == 3071 ? (FilesOuterClass$RequestGetNasimFileUploadResume) this.trait_ : FilesOuterClass$RequestGetNasimFileUploadResume.getDefaultInstance();
    }

    public FilesOuterClass$RequestGetNasimFileUploadUrl getGetNasimFileUploadUrl() {
        return this.traitCase_ == 143 ? (FilesOuterClass$RequestGetNasimFileUploadUrl) this.trait_ : FilesOuterClass$RequestGetNasimFileUploadUrl.getDefaultInstance();
    }

    public FilesOuterClass$RequestGetNasimFileUrl getGetNasimFileUrl() {
        return this.traitCase_ == 2815 ? (FilesOuterClass$RequestGetNasimFileUrl) this.trait_ : FilesOuterClass$RequestGetNasimFileUrl.getDefaultInstance();
    }

    public FilesOuterClass$RequestGetNasimFileUrls getGetNasimFileUrls() {
        return this.traitCase_ == 2591 ? (FilesOuterClass$RequestGetNasimFileUrls) this.trait_ : FilesOuterClass$RequestGetNasimFileUrls.getDefaultInstance();
    }

    public BankOuterClass$RequestGetOTPTokenV2 getGetOtpTokenV2() {
        return this.traitCase_ == 63258 ? (BankOuterClass$RequestGetOTPTokenV2) this.trait_ : BankOuterClass$RequestGetOTPTokenV2.getDefaultInstance();
    }

    public BankOuterClass$RequestGetOTPToken getGetOtptoken() {
        return this.traitCase_ == 62761 ? (BankOuterClass$RequestGetOTPToken) this.trait_ : BankOuterClass$RequestGetOTPToken.getDefaultInstance();
    }

    public WarriorOuterClass$RequestGetPacket getGetPacket() {
        return this.traitCase_ == 63604 ? (WarriorOuterClass$RequestGetPacket) this.trait_ : WarriorOuterClass$RequestGetPacket.getDefaultInstance();
    }

    public WarriorOuterClass$RequestGetPacketsStatus getGetPacketsStatus() {
        return this.traitCase_ == 63597 ? (WarriorOuterClass$RequestGetPacketsStatus) this.trait_ : WarriorOuterClass$RequestGetPacketsStatus.getDefaultInstance();
    }

    public ConfigsOuterClass$RequestGetParameters getGetParameters() {
        return this.traitCase_ == 134 ? (ConfigsOuterClass$RequestGetParameters) this.trait_ : ConfigsOuterClass$RequestGetParameters.getDefaultInstance();
    }

    public Crowdfunding$RequestGetParticipants getGetParticipants() {
        return this.traitCase_ == 63512 ? (Crowdfunding$RequestGetParticipants) this.trait_ : Crowdfunding$RequestGetParticipants.getDefaultInstance();
    }

    public BankOuterClass$RequestGetPayMoneyRequestToken getGetPayMoneyRequestToken() {
        return this.traitCase_ == 62127 ? (BankOuterClass$RequestGetPayMoneyRequestToken) this.trait_ : BankOuterClass$RequestGetPayMoneyRequestToken.getDefaultInstance();
    }

    public BankOuterClass$RequestGetPaymentToken getGetPaymentToken() {
        return this.traitCase_ == 62408 ? (BankOuterClass$RequestGetPaymentToken) this.trait_ : BankOuterClass$RequestGetPaymentToken.getDefaultInstance();
    }

    public WalletOuterClass$RequestGetPaymentTokenByCard getGetPaymentTokenByCard() {
        return this.traitCase_ == 62747 ? (WalletOuterClass$RequestGetPaymentTokenByCard) this.trait_ : WalletOuterClass$RequestGetPaymentTokenByCard.getDefaultInstance();
    }

    public BankOuterClass$RequestGetPayvandCard getGetPayvandCard() {
        return this.traitCase_ == 62132 ? (BankOuterClass$RequestGetPayvandCard) this.trait_ : BankOuterClass$RequestGetPayvandCard.getDefaultInstance();
    }

    public BankOuterClass$RequestGetPayvandCardList getGetPayvandCardList() {
        return this.traitCase_ == 62130 ? (BankOuterClass$RequestGetPayvandCardList) this.trait_ : BankOuterClass$RequestGetPayvandCardList.getDefaultInstance();
    }

    public KifpoolOuterClass$RequestGetPointBalance getGetPointBalance() {
        return this.traitCase_ == 63434 ? (KifpoolOuterClass$RequestGetPointBalance) this.trait_ : KifpoolOuterClass$RequestGetPointBalance.getDefaultInstance();
    }

    public KifpoolOuterClass$RequestGetPointDetails getGetPointDetails() {
        return this.traitCase_ == 63458 ? (KifpoolOuterClass$RequestGetPointDetails) this.trait_ : KifpoolOuterClass$RequestGetPointDetails.getDefaultInstance();
    }

    public KifpoolOuterClass$RequestGetPointSummery getGetPointSummery() {
        return this.traitCase_ == 63451 ? (KifpoolOuterClass$RequestGetPointSummery) this.trait_ : KifpoolOuterClass$RequestGetPointSummery.getDefaultInstance();
    }

    public BankOuterClass$RequestGetPSProxyPaymentToken getGetPsproxyPaymentToken() {
        return this.traitCase_ == 53258 ? (BankOuterClass$RequestGetPSProxyPaymentToken) this.trait_ : BankOuterClass$RequestGetPSProxyPaymentToken.getDefaultInstance();
    }

    public BankOuterClass$RequestGetPSProxyToken getGetPsproxyToken() {
        return this.traitCase_ == 53256 ? (BankOuterClass$RequestGetPSProxyToken) this.trait_ : BankOuterClass$RequestGetPSProxyToken.getDefaultInstance();
    }

    public ReactionsOuterClass$RequestGetReactions getGetReactions() {
        return this.traitCase_ == 63254 ? (ReactionsOuterClass$RequestGetReactions) this.trait_ : ReactionsOuterClass$RequestGetReactions.getDefaultInstance();
    }

    public BankOuterClass$RequestGetRecentCharges getGetRecentCharges() {
        return this.traitCase_ == 62412 ? (BankOuterClass$RequestGetRecentCharges) this.trait_ : BankOuterClass$RequestGetRecentCharges.getDefaultInstance();
    }

    public Charnet$RequestGetRecentInternetBundleOrders getGetRecentInternetBundleOrders() {
        return this.traitCase_ == 63534 ? (Charnet$RequestGetRecentInternetBundleOrders) this.trait_ : Charnet$RequestGetRecentInternetBundleOrders.getDefaultInstance();
    }

    public Saba$RequestGetRecentOrders getGetRecentOrders() {
        return this.traitCase_ == 63507 ? (Saba$RequestGetRecentOrders) this.trait_ : Saba$RequestGetRecentOrders.getDefaultInstance();
    }

    public SefteOuterClass$RequestGetRecipients getGetRecipients() {
        return this.traitCase_ == 63626 ? (SefteOuterClass$RequestGetRecipients) this.trait_ : SefteOuterClass$RequestGetRecipients.getDefaultInstance();
    }

    public Sequence$RequestGetReferencedEntitites getGetReferencedEntitites() {
        return this.traitCase_ == 2628 ? (Sequence$RequestGetReferencedEntitites) this.trait_ : Sequence$RequestGetReferencedEntitites.getDefaultInstance();
    }

    public ReferralOuterClass$RequestGetReferralCode getGetReferralCode() {
        return this.traitCase_ == 63500 ? (ReferralOuterClass$RequestGetReferralCode) this.trait_ : ReferralOuterClass$RequestGetReferralCode.getDefaultInstance();
    }

    public WarriorOuterClass$RequestGetReferralContacts getGetReferralContacts() {
        return this.traitCase_ == 63601 ? (WarriorOuterClass$RequestGetReferralContacts) this.trait_ : WarriorOuterClass$RequestGetReferralContacts.getDefaultInstance();
    }

    public ReferralOuterClass$RequestGetReferredCount getGetReferredCount() {
        return this.traitCase_ == 63477 ? (ReferralOuterClass$RequestGetReferredCount) this.trait_ : ReferralOuterClass$RequestGetReferredCount.getDefaultInstance();
    }

    public ReferralOuterClass$RequestGetReferringUser getGetReferringUser() {
        return this.traitCase_ == 63460 ? (ReferralOuterClass$RequestGetReferringUser) this.trait_ : ReferralOuterClass$RequestGetReferringUser.getDefaultInstance();
    }

    public BankOuterClass$RequestGetRemainToken getGetRemainToken() {
        return this.traitCase_ == 58106 ? (BankOuterClass$RequestGetRemainToken) this.trait_ : BankOuterClass$RequestGetRemainToken.getDefaultInstance();
    }

    public BankOuterClass$RequestGetSadadPSPPaymentToken getGetSadadPsppaymentToken() {
        return this.traitCase_ == 62180 ? (BankOuterClass$RequestGetSadadPSPPaymentToken) this.trait_ : BankOuterClass$RequestGetSadadPSPPaymentToken.getDefaultInstance();
    }

    public BillOuterClass$RequestGetSavedBills getGetSavedBills() {
        return this.traitCase_ == 63551 ? (BillOuterClass$RequestGetSavedBills) this.trait_ : BillOuterClass$RequestGetSavedBills.getDefaultInstance();
    }

    public WarriorOuterClass$RequestGetScoreBoard getGetScoreBoard() {
        return this.traitCase_ == 63593 ? (WarriorOuterClass$RequestGetScoreBoard) this.trait_ : WarriorOuterClass$RequestGetScoreBoard.getDefaultInstance();
    }

    public Sequence$RequestGetState getGetState() {
        return this.traitCase_ == 9 ? (Sequence$RequestGetState) this.trait_ : Sequence$RequestGetState.getDefaultInstance();
    }

    public SefteOuterClass$RequestGetStates getGetStates() {
        return this.traitCase_ == 63615 ? (SefteOuterClass$RequestGetStates) this.trait_ : SefteOuterClass$RequestGetStates.getDefaultInstance();
    }

    public PfmOuterClass$RequestGetSubTransactions getGetSubTransactions() {
        return this.traitCase_ == 63653 ? (PfmOuterClass$RequestGetSubTransactions) this.trait_ : PfmOuterClass$RequestGetSubTransactions.getDefaultInstance();
    }

    public Crowdfunding$RequestGetTotalPaidAmount getGetTotalPaidAmount() {
        return this.traitCase_ == 63527 ? (Crowdfunding$RequestGetTotalPaidAmount) this.trait_ : Crowdfunding$RequestGetTotalPaidAmount.getDefaultInstance();
    }

    public PfmOuterClass$RequestGetTransactionTags getGetTransactionTags() {
        return this.traitCase_ == 63516 ? (PfmOuterClass$RequestGetTransactionTags) this.trait_ : PfmOuterClass$RequestGetTransactionTags.getDefaultInstance();
    }

    public PfmOuterClass$RequestGetUserAccounts getGetUserAccounts() {
        return this.traitCase_ == 63443 ? (PfmOuterClass$RequestGetUserAccounts) this.trait_ : PfmOuterClass$RequestGetUserAccounts.getDefaultInstance();
    }

    public VitrineOuterClass$RequestGetUserBank getGetUserBank() {
        return this.traitCase_ == 63522 ? (VitrineOuterClass$RequestGetUserBank) this.trait_ : VitrineOuterClass$RequestGetUserBank.getDefaultInstance();
    }

    public KetfOuterClass$RequestGetUserContext getGetUserContext() {
        return this.traitCase_ == 137 ? (KetfOuterClass$RequestGetUserContext) this.trait_ : KetfOuterClass$RequestGetUserContext.getDefaultInstance();
    }

    public WarriorOuterClass$RequestGetUserRefers getGetUserRefers() {
        return this.traitCase_ == 63599 ? (WarriorOuterClass$RequestGetUserRefers) this.trait_ : WarriorOuterClass$RequestGetUserRefers.getDefaultInstance();
    }

    public WarriorOuterClass$RequestGetUserScore getGetUserScore() {
        return this.traitCase_ == 63595 ? (WarriorOuterClass$RequestGetUserScore) this.trait_ : WarriorOuterClass$RequestGetUserScore.getDefaultInstance();
    }

    public SefteOuterClass$RequestGetUserSeftes getGetUserSeftes() {
        return this.traitCase_ == 63620 ? (SefteOuterClass$RequestGetUserSeftes) this.trait_ : SefteOuterClass$RequestGetUserSeftes.getDefaultInstance();
    }

    public AdvertisementOuterClass$RequestGetUserStatus getGetUserStatus() {
        return this.traitCase_ == 63441 ? (AdvertisementOuterClass$RequestGetUserStatus) this.trait_ : AdvertisementOuterClass$RequestGetUserStatus.getDefaultInstance();
    }

    public PfmOuterClass$RequestGetUserTags getGetUserTags() {
        return this.traitCase_ == 63520 ? (PfmOuterClass$RequestGetUserTags) this.trait_ : PfmOuterClass$RequestGetUserTags.getDefaultInstance();
    }

    public VitrineOuterClass$RequestGetUserVitrine getGetUserVitrine() {
        return this.traitCase_ == 63256 ? (VitrineOuterClass$RequestGetUserVitrine) this.trait_ : VitrineOuterClass$RequestGetUserVitrine.getDefaultInstance();
    }

    public UsersOuterClass$RequestGetUsersDefaultCardNumber getGetUsersDefaultCardNumber() {
        return this.traitCase_ == 63541 ? (UsersOuterClass$RequestGetUsersDefaultCardNumber) this.trait_ : UsersOuterClass$RequestGetUsersDefaultCardNumber.getDefaultInstance();
    }

    public PresenceOuterClass$RequestGetUsersPresence getGetUsersPresence() {
        return this.traitCase_ == 63644 ? (PresenceOuterClass$RequestGetUsersPresence) this.trait_ : PresenceOuterClass$RequestGetUsersPresence.getDefaultInstance();
    }

    public ClubOuterClass$RequestGetVouchers getGetVouchers() {
        return this.traitCase_ == 63472 ? (ClubOuterClass$RequestGetVouchers) this.trait_ : ClubOuterClass$RequestGetVouchers.getDefaultInstance();
    }

    public WalletOuterClass$RequestGetWalletChargeToken getGetWalletChargeToken() {
        return this.traitCase_ == 62733 ? (WalletOuterClass$RequestGetWalletChargeToken) this.trait_ : WalletOuterClass$RequestGetWalletChargeToken.getDefaultInstance();
    }

    public WalletOuterClass$RequestGetWalletContracts getGetWalletContracts() {
        return this.traitCase_ == 62758 ? (WalletOuterClass$RequestGetWalletContracts) this.trait_ : WalletOuterClass$RequestGetWalletContracts.getDefaultInstance();
    }

    public WalletOuterClass$RequestGetWalletInvoice getGetWalletInvoice() {
        return this.traitCase_ == 62752 ? (WalletOuterClass$RequestGetWalletInvoice) this.trait_ : WalletOuterClass$RequestGetWalletInvoice.getDefaultInstance();
    }

    public Saba$RequestGetWebViewTrackingNumber getGetWebviewTrackingNumber() {
        return this.traitCase_ == 63481 ? (Saba$RequestGetWebViewTrackingNumber) this.trait_ : Saba$RequestGetWebViewTrackingNumber.getDefaultInstance();
    }

    public ClubOuterClass$RequestGetWheel getGetWheel() {
        return this.traitCase_ == 63468 ? (ClubOuterClass$RequestGetWheel) this.trait_ : ClubOuterClass$RequestGetWheel.getDefaultInstance();
    }

    public BankOuterClass$RequestGrantBankiAccess getGrantBankiAccess() {
        return this.traitCase_ == 62397 ? (BankOuterClass$RequestGrantBankiAccess) this.trait_ : BankOuterClass$RequestGrantBankiAccess.getDefaultInstance();
    }

    public UsersOuterClass$RequestImportContacts getImportContacts() {
        return this.traitCase_ == 7 ? (UsersOuterClass$RequestImportContacts) this.trait_ : UsersOuterClass$RequestImportContacts.getDefaultInstance();
    }

    public SefteOuterClass$RequestInitP12 getInitP12() {
        return this.traitCase_ == 63608 ? (SefteOuterClass$RequestInitP12) this.trait_ : SefteOuterClass$RequestInitP12.getDefaultInstance();
    }

    public SefteOuterClass$RequestInitSefte getInitSefte() {
        return this.traitCase_ == 63610 ? (SefteOuterClass$RequestInitSefte) this.trait_ : SefteOuterClass$RequestInitSefte.getDefaultInstance();
    }

    public BillOuterClass$RequestInquiryBill getInquiryBill() {
        return this.traitCase_ == 63543 ? (BillOuterClass$RequestInquiryBill) this.trait_ : BillOuterClass$RequestInquiryBill.getDefaultInstance();
    }

    public GroupsOuterClass$RequestInviteUser getInviteUser() {
        return this.traitCase_ == 69 ? (GroupsOuterClass$RequestInviteUser) this.trait_ : GroupsOuterClass$RequestInviteUser.getDefaultInstance();
    }

    public KifpoolOuterClass$RequestInvoiceKifpool getInvoiceKifpool() {
        return this.traitCase_ == 63409 ? (KifpoolOuterClass$RequestInvoiceKifpool) this.trait_ : KifpoolOuterClass$RequestInvoiceKifpool.getDefaultInstance();
    }

    public GroupsOuterClass$RequestJoinGroup getJoinGroup() {
        return this.traitCase_ == 180 ? (GroupsOuterClass$RequestJoinGroup) this.trait_ : GroupsOuterClass$RequestJoinGroup.getDefaultInstance();
    }

    public GroupsOuterClass$RequestJoinPublicGroup getJoinPublicGroup() {
        return this.traitCase_ == 2881 ? (GroupsOuterClass$RequestJoinPublicGroup) this.trait_ : GroupsOuterClass$RequestJoinPublicGroup.getDefaultInstance();
    }

    public GroupsOuterClass$RequestKickUser getKickUser() {
        return this.traitCase_ == 71 ? (GroupsOuterClass$RequestKickUser) this.trait_ : GroupsOuterClass$RequestKickUser.getDefaultInstance();
    }

    public GroupsOuterClass$RequestLeaveGroup getLeaveGroup() {
        return this.traitCase_ == 70 ? (GroupsOuterClass$RequestLeaveGroup) this.trait_ : GroupsOuterClass$RequestLeaveGroup.getDefaultInstance();
    }

    public MessagingOuterClass$RequestLoadArchived getLoadArchived() {
        return this.traitCase_ == 2651 ? (MessagingOuterClass$RequestLoadArchived) this.trait_ : MessagingOuterClass$RequestLoadArchived.getDefaultInstance();
    }

    public UsersOuterClass$RequestLoadAvatars getLoadAvatars() {
        return this.traitCase_ == 2656 ? (UsersOuterClass$RequestLoadAvatars) this.trait_ : UsersOuterClass$RequestLoadAvatars.getDefaultInstance();
    }

    public UsersOuterClass$RequestLoadBlockedUsers getLoadBlockedUsers() {
        return this.traitCase_ == 2638 ? (UsersOuterClass$RequestLoadBlockedUsers) this.trait_ : UsersOuterClass$RequestLoadBlockedUsers.getDefaultInstance();
    }

    public MessagingOuterClass$RequestLoadDialogs getLoadDialogs() {
        return this.traitCase_ == 104 ? (MessagingOuterClass$RequestLoadDialogs) this.trait_ : MessagingOuterClass$RequestLoadDialogs.getDefaultInstance();
    }

    public GroupsOuterClass$RequestLoadFullGroups getLoadFullGroups() {
        return this.traitCase_ == 2782 ? (GroupsOuterClass$RequestLoadFullGroups) this.trait_ : GroupsOuterClass$RequestLoadFullGroups.getDefaultInstance();
    }

    public UsersOuterClass$RequestLoadFullUsers getLoadFullUsers() {
        return this.traitCase_ == 2649 ? (UsersOuterClass$RequestLoadFullUsers) this.trait_ : UsersOuterClass$RequestLoadFullUsers.getDefaultInstance();
    }

    public GroupsOuterClass$RequestLoadGroupAvatars getLoadGroupAvatars() {
        return this.traitCase_ == 43748 ? (GroupsOuterClass$RequestLoadGroupAvatars) this.trait_ : GroupsOuterClass$RequestLoadGroupAvatars.getDefaultInstance();
    }

    public MessagingOuterClass$RequestLoadGroupedDialogs getLoadGroupedDialogs() {
        return this.traitCase_ == 225 ? (MessagingOuterClass$RequestLoadGroupedDialogs) this.trait_ : MessagingOuterClass$RequestLoadGroupedDialogs.getDefaultInstance();
    }

    public GroupsOuterClass$RequestLoadGroups getLoadGroups() {
        return this.traitCase_ == 63245 ? (GroupsOuterClass$RequestLoadGroups) this.trait_ : GroupsOuterClass$RequestLoadGroups.getDefaultInstance();
    }

    public MessagingOuterClass$RequestLoadHistory getLoadHistory() {
        return this.traitCase_ == 118 ? (MessagingOuterClass$RequestLoadHistory) this.trait_ : MessagingOuterClass$RequestLoadHistory.getDefaultInstance();
    }

    public MelonOuterClass$RequestLoadLastStates getLoadLastStates() {
        return this.traitCase_ == 63659 ? (MelonOuterClass$RequestLoadLastStates) this.trait_ : MelonOuterClass$RequestLoadLastStates.getDefaultInstance();
    }

    public MelonOuterClass$RequestLoadLoanHistory getLoadLoanHistory() {
        return this.traitCase_ == 63656 ? (MelonOuterClass$RequestLoadLoanHistory) this.trait_ : MelonOuterClass$RequestLoadLoanHistory.getDefaultInstance();
    }

    public GroupsOuterClass$RequestLoadMembers getLoadMembers() {
        return this.traitCase_ == 2786 ? (GroupsOuterClass$RequestLoadMembers) this.trait_ : GroupsOuterClass$RequestLoadMembers.getDefaultInstance();
    }

    public ImagesOuterClass$RequestLoadOwnStickers getLoadOwnStickers() {
        return this.traitCase_ == 238 ? (ImagesOuterClass$RequestLoadOwnStickers) this.trait_ : ImagesOuterClass$RequestLoadOwnStickers.getDefaultInstance();
    }

    public MessagingOuterClass$RequestLoadPeerDialogs getLoadPeerDialogs() {
        return this.traitCase_ == 63249 ? (MessagingOuterClass$RequestLoadPeerDialogs) this.trait_ : MessagingOuterClass$RequestLoadPeerDialogs.getDefaultInstance();
    }

    public AbacusOuterClass$RequestLoadReactions getLoadReactions() {
        return this.traitCase_ == 63239 ? (AbacusOuterClass$RequestLoadReactions) this.trait_ : AbacusOuterClass$RequestLoadReactions.getDefaultInstance();
    }

    public ImagesOuterClass$RequestLoadStickerCollection getLoadStickerCollection() {
        return this.traitCase_ == 246 ? (ImagesOuterClass$RequestLoadStickerCollection) this.trait_ : ImagesOuterClass$RequestLoadStickerCollection.getDefaultInstance();
    }

    public PfmOuterClass$RequestLoadTransactions getLoadTransactions() {
        return this.traitCase_ == 63445 ? (PfmOuterClass$RequestLoadTransactions) this.trait_ : PfmOuterClass$RequestLoadTransactions.getDefaultInstance();
    }

    public PfmOuterClass$RequestLoadTransactionsByIDs getLoadTransactionsByIds() {
        return this.traitCase_ == 63649 ? (PfmOuterClass$RequestLoadTransactionsByIDs) this.trait_ : PfmOuterClass$RequestLoadTransactionsByIDs.getDefaultInstance();
    }

    public UsersOuterClass$RequestLoadUsers getLoadUsers() {
        return this.traitCase_ == 63247 ? (UsersOuterClass$RequestLoadUsers) this.trait_ : UsersOuterClass$RequestLoadUsers.getDefaultInstance();
    }

    public GroupsOuterClass$RequestMakeUserAdmin getMakeUserAdmin() {
        return this.traitCase_ == 2784 ? (GroupsOuterClass$RequestMakeUserAdmin) this.trait_ : GroupsOuterClass$RequestMakeUserAdmin.getDefaultInstance();
    }

    public MessagingOuterClass$RequestMessageRead getMessageRead() {
        return this.traitCase_ == 57 ? (MessagingOuterClass$RequestMessageRead) this.trait_ : MessagingOuterClass$RequestMessageRead.getDefaultInstance();
    }

    public MessagingOuterClass$RequestMessageReceived getMessageReceived() {
        return this.traitCase_ == 55 ? (MessagingOuterClass$RequestMessageReceived) this.trait_ : MessagingOuterClass$RequestMessageReceived.getDefaultInstance();
    }

    public AbacusOuterClass$RequestMessageRemoveReaction getMessageRemoveReaction() {
        return this.traitCase_ == 220 ? (AbacusOuterClass$RequestMessageRemoveReaction) this.trait_ : AbacusOuterClass$RequestMessageRemoveReaction.getDefaultInstance();
    }

    public AbacusOuterClass$RequestMessageSetReaction getMessageSetReaction() {
        return this.traitCase_ == 210 ? (AbacusOuterClass$RequestMessageSetReaction) this.trait_ : AbacusOuterClass$RequestMessageSetReaction.getDefaultInstance();
    }

    public UpdateBoxStruct$NewFatSeqUpdate getNewFatSeqUpdate() {
        return this.traitCase_ == 1168 ? (UpdateBoxStruct$NewFatSeqUpdate) this.trait_ : UpdateBoxStruct$NewFatSeqUpdate.getDefaultInstance();
    }

    public UpdateBoxStruct$NewSeqUpdate getNewSeqUpdate() {
        return this.traitCase_ == 45 ? (UpdateBoxStruct$NewSeqUpdate) this.trait_ : UpdateBoxStruct$NewSeqUpdate.getDefaultInstance();
    }

    public UsersOuterClass$RequestNotifyAboutDeviceInfo getNotifyAboutDeviceInfo() {
        return this.traitCase_ == 229 ? (UsersOuterClass$RequestNotifyAboutDeviceInfo) this.trait_ : UsersOuterClass$RequestNotifyAboutDeviceInfo.getDefaultInstance();
    }

    public Giftpacket$RequestOpenGiftPacket getOpenGiftPacket() {
        return this.traitCase_ == 63236 ? (Giftpacket$RequestOpenGiftPacket) this.trait_ : Giftpacket$RequestOpenGiftPacket.getDefaultInstance();
    }

    public BillOuterClass$RequestPayBill getPayBill() {
        return this.traitCase_ == 63545 ? (BillOuterClass$RequestPayBill) this.trait_ : BillOuterClass$RequestPayBill.getDefaultInstance();
    }

    public WalletOuterClass$RequestPayByWallet getPayByWallet() {
        return this.traitCase_ == 62746 ? (WalletOuterClass$RequestPayByWallet) this.trait_ : WalletOuterClass$RequestPayByWallet.getDefaultInstance();
    }

    public WalletOuterClass$RequestPayMoneyRequestByWallet getPayMoneyRequestByWallet() {
        return this.traitCase_ == 62751 ? (WalletOuterClass$RequestPayMoneyRequestByWallet) this.trait_ : WalletOuterClass$RequestPayMoneyRequestByWallet.getDefaultInstance();
    }

    public SefteOuterClass$RequestPaySefte getPaySefte() {
        return this.traitCase_ == 63614 ? (SefteOuterClass$RequestPaySefte) this.trait_ : SefteOuterClass$RequestPaySefte.getDefaultInstance();
    }

    public GroupsOuterClass$RequestPinMessage getPinMessage() {
        return this.traitCase_ == 470 ? (GroupsOuterClass$RequestPinMessage) this.trait_ : GroupsOuterClass$RequestPinMessage.getDefaultInstance();
    }

    public Protobuf$RequestProto getProto() {
        return this.traitCase_ == 63639 ? (Protobuf$RequestProto) this.trait_ : Protobuf$RequestProto.getDefaultInstance();
    }

    public KifpoolOuterClass$RequestPurchaseMessage getPurchaseMessage() {
        return this.traitCase_ == 63418 ? (KifpoolOuterClass$RequestPurchaseMessage) this.trait_ : KifpoolOuterClass$RequestPurchaseMessage.getDefaultInstance();
    }

    public KifpoolOuterClass$RequestPurchaseMessageWithCharge getPurchaseMessageWithCharge() {
        return this.traitCase_ == 63428 ? (KifpoolOuterClass$RequestPurchaseMessageWithCharge) this.trait_ : KifpoolOuterClass$RequestPurchaseMessageWithCharge.getDefaultInstance();
    }

    public SapOuterClass$RequestReactivateApp getReactivateApp() {
        return this.traitCase_ == 63591 ? (SapOuterClass$RequestReactivateApp) this.trait_ : SapOuterClass$RequestReactivateApp.getDefaultInstance();
    }

    public ReferralOuterClass$RequestRefer getRefer() {
        return this.traitCase_ == 63502 ? (ReferralOuterClass$RequestRefer) this.trait_ : ReferralOuterClass$RequestRefer.getDefaultInstance();
    }

    public AdvertisementOuterClass$RequestRegisterForEarnMoney getRegisterForEarnMoney() {
        return this.traitCase_ == 63438 ? (AdvertisementOuterClass$RequestRegisterForEarnMoney) this.trait_ : AdvertisementOuterClass$RequestRegisterForEarnMoney.getDefaultInstance();
    }

    public PushOuterClass$RequestRegisterGooglePush getRegisterGooglePush() {
        return this.traitCase_ == 51 ? (PushOuterClass$RequestRegisterGooglePush) this.trait_ : PushOuterClass$RequestRegisterGooglePush.getDefaultInstance();
    }

    public UsersOuterClass$RequestRemoveAvatar getRemoveAvatar() {
        return this.traitCase_ == 91 ? (UsersOuterClass$RequestRemoveAvatar) this.trait_ : UsersOuterClass$RequestRemoveAvatar.getDefaultInstance();
    }

    public SapOuterClass$RequestRemoveCard getRemoveCard() {
        return this.traitCase_ == 63557 ? (SapOuterClass$RequestRemoveCard) this.trait_ : SapOuterClass$RequestRemoveCard.getDefaultInstance();
    }

    public UsersOuterClass$RequestRemoveContact getRemoveContact() {
        return this.traitCase_ == 89 ? (UsersOuterClass$RequestRemoveContact) this.trait_ : UsersOuterClass$RequestRemoveContact.getDefaultInstance();
    }

    public SapOuterClass$RequestRemoveDefaultCard getRemoveDefaultCard() {
        return this.traitCase_ == 63565 ? (SapOuterClass$RequestRemoveDefaultCard) this.trait_ : SapOuterClass$RequestRemoveDefaultCard.getDefaultInstance();
    }

    public UsersOuterClass$RequestRemoveDefaultCardNumber getRemoveDefaultCardNumber() {
        return this.traitCase_ == 62177 ? (UsersOuterClass$RequestRemoveDefaultCardNumber) this.trait_ : UsersOuterClass$RequestRemoveDefaultCardNumber.getDefaultInstance();
    }

    public SapOuterClass$RequestRemoveDestinationCards getRemoveDestinationCards() {
        return this.traitCase_ == 63590 ? (SapOuterClass$RequestRemoveDestinationCards) this.trait_ : SapOuterClass$RequestRemoveDestinationCards.getDefaultInstance();
    }

    public ImagesOuterClass$RequestRemoveGif getRemoveGif() {
        return this.traitCase_ == 2859 ? (ImagesOuterClass$RequestRemoveGif) this.trait_ : ImagesOuterClass$RequestRemoveGif.getDefaultInstance();
    }

    public GroupsOuterClass$RequestRemoveGroupAvatar getRemoveGroupAvatar() {
        return this.traitCase_ == 101 ? (GroupsOuterClass$RequestRemoveGroupAvatar) this.trait_ : GroupsOuterClass$RequestRemoveGroupAvatar.getDefaultInstance();
    }

    public MelonOuterClass$RequestRemoveLoan getRemoveLoan() {
        return this.traitCase_ == 63658 ? (MelonOuterClass$RequestRemoveLoan) this.trait_ : MelonOuterClass$RequestRemoveLoan.getDefaultInstance();
    }

    public GroupsOuterClass$RequestRemovePin getRemovePin() {
        return this.traitCase_ == 471 ? (GroupsOuterClass$RequestRemovePin) this.trait_ : GroupsOuterClass$RequestRemovePin.getDefaultInstance();
    }

    public ImagesOuterClass$RequestRemoveStickerCollection getRemoveStickerCollection() {
        return this.traitCase_ == 245 ? (ImagesOuterClass$RequestRemoveStickerCollection) this.trait_ : ImagesOuterClass$RequestRemoveStickerCollection.getDefaultInstance();
    }

    public PfmOuterClass$RequestRemoveTransaction getRemoveTransaction() {
        return this.traitCase_ == 63646 ? (PfmOuterClass$RequestRemoveTransaction) this.trait_ : PfmOuterClass$RequestRemoveTransaction.getDefaultInstance();
    }

    public PfmOuterClass$RequestRemoveTransactionTags getRemoveTransactionTags() {
        return this.traitCase_ == 63450 ? (PfmOuterClass$RequestRemoveTransactionTags) this.trait_ : PfmOuterClass$RequestRemoveTransactionTags.getDefaultInstance();
    }

    public GroupsOuterClass$RequestRemoveUserAdmin getRemoveUserAdmin() {
        return this.traitCase_ == 44576 ? (GroupsOuterClass$RequestRemoveUserAdmin) this.trait_ : GroupsOuterClass$RequestRemoveUserAdmin.getDefaultInstance();
    }

    public PfmOuterClass$RequestRemoveUserTags getRemoveUserTags() {
        return this.traitCase_ == 63519 ? (PfmOuterClass$RequestRemoveUserTags) this.trait_ : PfmOuterClass$RequestRemoveUserTags.getDefaultInstance();
    }

    public BillOuterClass$RequestRenameSavedBill getRenameSavedBill() {
        return this.traitCase_ == 63553 ? (BillOuterClass$RequestRenameSavedBill) this.trait_ : BillOuterClass$RequestRenameSavedBill.getDefaultInstance();
    }

    public UsersOuterClass$RequestResetContacts getResetContacts() {
        return this.traitCase_ == 63661 ? (UsersOuterClass$RequestResetContacts) this.trait_ : UsersOuterClass$RequestResetContacts.getDefaultInstance();
    }

    public SapOuterClass$ResponseAddDestinationCards getResponseAddDestinationCards() {
        return this.traitCase_ == 63589 ? (SapOuterClass$ResponseAddDestinationCards) this.trait_ : SapOuterClass$ResponseAddDestinationCards.getDefaultInstance();
    }

    public SapOuterClass$ResponseAddNewCards getResponseAddNewCards() {
        return this.traitCase_ == 63556 ? (SapOuterClass$ResponseAddNewCards) this.trait_ : SapOuterClass$ResponseAddNewCards.getDefaultInstance();
    }

    public AuthOuterClass$ResponseAuth getResponseAuth() {
        return this.traitCase_ == 5 ? (AuthOuterClass$ResponseAuth) this.trait_ : AuthOuterClass$ResponseAuth.getDefaultInstance();
    }

    public SefteOuterClass$ResponseAuthorizeUser getResponseAuthorizeUser() {
        return this.traitCase_ == 63607 ? (SefteOuterClass$ResponseAuthorizeUser) this.trait_ : SefteOuterClass$ResponseAuthorizeUser.getDefaultInstance();
    }

    public Misc$ResponseBool getResponseBool() {
        return this.traitCase_ == 209 ? (Misc$ResponseBool) this.trait_ : Misc$ResponseBool.getDefaultInstance();
    }

    public Charnet$ResponseBuyCharge getResponseBuyCharge() {
        return this.traitCase_ == 63538 ? (Charnet$ResponseBuyCharge) this.trait_ : Charnet$ResponseBuyCharge.getDefaultInstance();
    }

    public BankOuterClass$ResponseBuyFastCharge getResponseBuyFastCharge() {
        return this.traitCase_ == 62465 ? (BankOuterClass$ResponseBuyFastCharge) this.trait_ : BankOuterClass$ResponseBuyFastCharge.getDefaultInstance();
    }

    public Charnet$ResponseBuyInternetBundle getResponseBuyInternetBundle() {
        return this.traitCase_ == 63540 ? (Charnet$ResponseBuyInternetBundle) this.trait_ : Charnet$ResponseBuyInternetBundle.getDefaultInstance();
    }

    public ClubOuterClass$ResponseBuyVoucher getResponseBuyVoucher() {
        return this.traitCase_ == 63475 ? (ClubOuterClass$ResponseBuyVoucher) this.trait_ : ClubOuterClass$ResponseBuyVoucher.getDefaultInstance();
    }

    public ClubOuterClass$ResponseBuyWheelChance getResponseBuyWheelChance() {
        return this.traitCase_ == 63467 ? (ClubOuterClass$ResponseBuyWheelChance) this.trait_ : ClubOuterClass$ResponseBuyWheelChance.getDefaultInstance();
    }

    public MeetOuterClass$ResponseCall getResponseCall() {
        return this.traitCase_ == 63581 ? (MeetOuterClass$ResponseCall) this.trait_ : MeetOuterClass$ResponseCall.getDefaultInstance();
    }

    public GroupsOuterClass$ResponseCanSeeMessages getResponseCanSeeMessages() {
        return this.traitCase_ == 725 ? (GroupsOuterClass$ResponseCanSeeMessages) this.trait_ : GroupsOuterClass$ResponseCanSeeMessages.getDefaultInstance();
    }

    public KifpoolOuterClass$ResponseCashOutKifpool getResponseCashoutKifpool() {
        return this.traitCase_ == 63408 ? (KifpoolOuterClass$ResponseCashOutKifpool) this.trait_ : KifpoolOuterClass$ResponseCashOutKifpool.getDefaultInstance();
    }

    public ClubOuterClass$ResponseChangePointToMoney getResponseChangePointToMoney() {
        return this.traitCase_ == 63465 ? (ClubOuterClass$ResponseChangePointToMoney) this.trait_ : ClubOuterClass$ResponseChangePointToMoney.getDefaultInstance();
    }

    public KifpoolOuterClass$ResponseCharge getResponseCharge() {
        return this.traitCase_ == 63416 ? (KifpoolOuterClass$ResponseCharge) this.trait_ : KifpoolOuterClass$ResponseCharge.getDefaultInstance();
    }

    public KifpoolOuterClass$ResponseCheckChargePermission getResponseCheckChargePermission() {
        return this.traitCase_ == 63414 ? (KifpoolOuterClass$ResponseCheckChargePermission) this.trait_ : KifpoolOuterClass$ResponseCheckChargePermission.getDefaultInstance();
    }

    public GroupsOuterClass$ResponseCreateGroup getResponseCreateGroup() {
        return this.traitCase_ == 216 ? (GroupsOuterClass$ResponseCreateGroup) this.trait_ : GroupsOuterClass$ResponseCreateGroup.getDefaultInstance();
    }

    public KifpoolOuterClass$ResponseCreateKifpool getResponseCreateKifpool() {
        return this.traitCase_ == 63405 ? (KifpoolOuterClass$ResponseCreateKifpool) this.trait_ : KifpoolOuterClass$ResponseCreateKifpool.getDefaultInstance();
    }

    public BillOuterClass$ResponseCreateSavedBill getResponseCreateSavedBill() {
        return this.traitCase_ == 63550 ? (BillOuterClass$ResponseCreateSavedBill) this.trait_ : BillOuterClass$ResponseCreateSavedBill.getDefaultInstance();
    }

    public KifpoolOuterClass$ResponseCryptoTransfer getResponseCryptoTransfer() {
        return this.traitCase_ == 63633 ? (KifpoolOuterClass$ResponseCryptoTransfer) this.trait_ : KifpoolOuterClass$ResponseCryptoTransfer.getDefaultInstance();
    }

    public MessagingOuterClass$ResponseDialogsOrder getResponseDialogsOrder() {
        return this.traitCase_ == 235 ? (MessagingOuterClass$ResponseDialogsOrder) this.trait_ : MessagingOuterClass$ResponseDialogsOrder.getDefaultInstance();
    }

    public UsersOuterClass$ResponseEditAvatar getResponseEditAvatar() {
        return this.traitCase_ == 103 ? (UsersOuterClass$ResponseEditAvatar) this.trait_ : UsersOuterClass$ResponseEditAvatar.getDefaultInstance();
    }

    public GroupsOuterClass$ResponseEditGroupAvatar getResponseEditGroupAvatar() {
        return this.traitCase_ == 115 ? (GroupsOuterClass$ResponseEditGroupAvatar) this.trait_ : GroupsOuterClass$ResponseEditGroupAvatar.getDefaultInstance();
    }

    public SapOuterClass$ResponseEnrollNewCard getResponseEnrollNewCard() {
        return this.traitCase_ == 63488 ? (SapOuterClass$ResponseEnrollNewCard) this.trait_ : SapOuterClass$ResponseEnrollNewCard.getDefaultInstance();
    }

    public GroupsOuterClass$ResponseFetchGroupAdmins getResponseFetchGroupAdmins() {
        return this.traitCase_ == 730 ? (GroupsOuterClass$ResponseFetchGroupAdmins) this.trait_ : GroupsOuterClass$ResponseFetchGroupAdmins.getDefaultInstance();
    }

    public PfmOuterClass$ResponseFilterTaggedTransactions getResponseFilterTaggedTransactions() {
        return this.traitCase_ == 63631 ? (PfmOuterClass$ResponseFilterTaggedTransactions) this.trait_ : PfmOuterClass$ResponseFilterTaggedTransactions.getDefaultInstance();
    }

    public ClubOuterClass$ResponseGetAcquiredVouchers getResponseGetAcquiredVouchers() {
        return this.traitCase_ == 63638 ? (ClubOuterClass$ResponseGetAcquiredVouchers) this.trait_ : ClubOuterClass$ResponseGetAcquiredVouchers.getDefaultInstance();
    }

    public AdvertisementOuterClass$ResponseGetAdProvider getResponseGetAdProvider() {
        return this.traitCase_ == 63526 ? (AdvertisementOuterClass$ResponseGetAdProvider) this.trait_ : AdvertisementOuterClass$ResponseGetAdProvider.getDefaultInstance();
    }

    public AuthOuterClass$ResponseGetAuthSessions getResponseGetAuthSessions() {
        return this.traitCase_ == 81 ? (AuthOuterClass$ResponseGetAuthSessions) this.trait_ : AuthOuterClass$ResponseGetAuthSessions.getDefaultInstance();
    }

    public Microbanki$ResponseGetBamServiceToken getResponseGetBamServiceToken() {
        return this.traitCase_ == 62407 ? (Microbanki$ResponseGetBamServiceToken) this.trait_ : Microbanki$ResponseGetBamServiceToken.getDefaultInstance();
    }

    public BillOuterClass$ResponseGetBillHistory getResponseGetBillHistory() {
        return this.traitCase_ == 63548 ? (BillOuterClass$ResponseGetBillHistory) this.trait_ : BillOuterClass$ResponseGetBillHistory.getDefaultInstance();
    }

    public KetfOuterClass$ResponseGetBotWhiteList getResponseGetBotWhiteList() {
        return this.traitCase_ == 3856 ? (KetfOuterClass$ResponseGetBotWhiteList) this.trait_ : KetfOuterClass$ResponseGetBotWhiteList.getDefaultInstance();
    }

    public SapOuterClass$ResponseGetCardInfo getResponseGetCardInfo() {
        return this.traitCase_ == 63490 ? (SapOuterClass$ResponseGetCardInfo) this.trait_ : SapOuterClass$ResponseGetCardInfo.getDefaultInstance();
    }

    public BankOuterClass$ResponseGetCardTransferToken getResponseGetCardTransferToken() {
        return this.traitCase_ == 62126 ? (BankOuterClass$ResponseGetCardTransferToken) this.trait_ : BankOuterClass$ResponseGetCardTransferToken.getDefaultInstance();
    }

    public SapOuterClass$ResponseGetCards getResponseGetCards() {
        return this.traitCase_ == 63559 ? (SapOuterClass$ResponseGetCards) this.trait_ : SapOuterClass$ResponseGetCards.getDefaultInstance();
    }

    public AdvertisementOuterClass$ResponseGetChannelAds getResponseGetChannelAds() {
        return this.traitCase_ == 63265 ? (AdvertisementOuterClass$ResponseGetChannelAds) this.trait_ : AdvertisementOuterClass$ResponseGetChannelAds.getDefaultInstance();
    }

    public AdvertisementOuterClass$ResponseGetChannelEarnMoneyInfo getResponseGetChannelEarnMoneyInfo() {
        return this.traitCase_ == 63448 ? (AdvertisementOuterClass$ResponseGetChannelEarnMoneyInfo) this.trait_ : AdvertisementOuterClass$ResponseGetChannelEarnMoneyInfo.getDefaultInstance();
    }

    public AdvertisementOuterClass$ResponseGetChannelEarnMoneyStatus getResponseGetChannelEarnMoneyStatus() {
        return this.traitCase_ == 63437 ? (AdvertisementOuterClass$ResponseGetChannelEarnMoneyStatus) this.trait_ : AdvertisementOuterClass$ResponseGetChannelEarnMoneyStatus.getDefaultInstance();
    }

    public Saba$ResponseGetChargeAmounts getResponseGetChargeAmounts() {
        return this.traitCase_ == 63511 ? (Saba$ResponseGetChargeAmounts) this.trait_ : Saba$ResponseGetChargeAmounts.getDefaultInstance();
    }

    public KifpoolOuterClass$ResponseGetChargePaymentToken getResponseGetChargePaymentToken() {
        return this.traitCase_ == 63406 ? (KifpoolOuterClass$ResponseGetChargePaymentToken) this.trait_ : KifpoolOuterClass$ResponseGetChargePaymentToken.getDefaultInstance();
    }

    public SefteOuterClass$ResponseGetCitiesOfState getResponseGetCitiesOfState() {
        return this.traitCase_ == 63618 ? (SefteOuterClass$ResponseGetCitiesOfState) this.trait_ : SefteOuterClass$ResponseGetCitiesOfState.getDefaultInstance();
    }

    public UsersOuterClass$ResponseGetContacts getResponseGetContacts() {
        return this.traitCase_ == 88 ? (UsersOuterClass$ResponseGetContacts) this.trait_ : UsersOuterClass$ResponseGetContacts.getDefaultInstance();
    }

    public KifpoolOuterClass$ResponseGetCryptoWallets getResponseGetCryptoWallets() {
        return this.traitCase_ == 63635 ? (KifpoolOuterClass$ResponseGetCryptoWallets) this.trait_ : KifpoolOuterClass$ResponseGetCryptoWallets.getDefaultInstance();
    }

    public SapOuterClass$ResponseGetDefaultCard getResponseGetDefaultCard() {
        return this.traitCase_ == 63564 ? (SapOuterClass$ResponseGetDefaultCard) this.trait_ : SapOuterClass$ResponseGetDefaultCard.getDefaultInstance();
    }

    public SapOuterClass$ResponseGetDestinationCardInfo getResponseGetDestinationCardInfo() {
        return this.traitCase_ == 63492 ? (SapOuterClass$ResponseGetDestinationCardInfo) this.trait_ : SapOuterClass$ResponseGetDestinationCardInfo.getDefaultInstance();
    }

    public SapOuterClass$ResponseGetDestinationCards getResponseGetDestinationCards() {
        return this.traitCase_ == 63587 ? (SapOuterClass$ResponseGetDestinationCards) this.trait_ : SapOuterClass$ResponseGetDestinationCards.getDefaultInstance();
    }

    public AdvertisementOuterClass$ResponseGetDialogAdOrderDetails getResponseGetDialogAdOrderDetails() {
        return this.traitCase_ == 63569 ? (AdvertisementOuterClass$ResponseGetDialogAdOrderDetails) this.trait_ : AdvertisementOuterClass$ResponseGetDialogAdOrderDetails.getDefaultInstance();
    }

    public AdvertisementOuterClass$ResponseGetDialogAdOrderPaymentToken getResponseGetDialogAdOrderPaymentToken() {
        return this.traitCase_ == 63572 ? (AdvertisementOuterClass$ResponseGetDialogAdOrderPaymentToken) this.trait_ : AdvertisementOuterClass$ResponseGetDialogAdOrderPaymentToken.getDefaultInstance();
    }

    public Giftpacket$ResponseGetGiftPacketPaymentToken getResponseGetGiftPacketPaymentToken() {
        return this.traitCase_ == 63231 ? (Giftpacket$ResponseGetGiftPacketPaymentToken) this.trait_ : Giftpacket$ResponseGetGiftPacketPaymentToken.getDefaultInstance();
    }

    public GroupsOuterClass$ResponseGetGroupDefaultCardNumber getResponseGetGroupDefaultCardNumber() {
        return this.traitCase_ == 130 ? (GroupsOuterClass$ResponseGetGroupDefaultCardNumber) this.trait_ : GroupsOuterClass$ResponseGetGroupDefaultCardNumber.getDefaultInstance();
    }

    public Sequence$ResponseGetGroupDifference getResponseGetGroupDifference() {
        return this.traitCase_ == 204 ? (Sequence$ResponseGetGroupDifference) this.trait_ : Sequence$ResponseGetGroupDifference.getDefaultInstance();
    }

    public GroupsOuterClass$ResponseGetGroupMembersCount getResponseGetGroupMembersCount() {
        return this.traitCase_ == 63504 ? (GroupsOuterClass$ResponseGetGroupMembersCount) this.trait_ : GroupsOuterClass$ResponseGetGroupMembersCount.getDefaultInstance();
    }

    public PresenceOuterClass$ResponseGetGroupMembersPresence getResponseGetGroupMembersPresence() {
        return this.traitCase_ == 63643 ? (PresenceOuterClass$ResponseGetGroupMembersPresence) this.trait_ : PresenceOuterClass$ResponseGetGroupMembersPresence.getDefaultInstance();
    }

    public Sequence$ResponseGetGroupState getResponseGetGroupState() {
        return this.traitCase_ == 23 ? (Sequence$ResponseGetGroupState) this.trait_ : Sequence$ResponseGetGroupState.getDefaultInstance();
    }

    public Charnet$ResponseGetInternetBundleList getResponseGetInternetBundleList() {
        return this.traitCase_ == 63533 ? (Charnet$ResponseGetInternetBundleList) this.trait_ : Charnet$ResponseGetInternetBundleList.getDefaultInstance();
    }

    public Charnet$ResponseGetInternetBundlePaymentToken getResponseGetInternetBundlePaymentToken() {
        return this.traitCase_ == 63531 ? (Charnet$ResponseGetInternetBundlePaymentToken) this.trait_ : Charnet$ResponseGetInternetBundlePaymentToken.getDefaultInstance();
    }

    public AuthOuterClass$ResponseGetJWTToken getResponseGetJwtToken() {
        return this.traitCase_ == 601 ? (AuthOuterClass$ResponseGetJWTToken) this.trait_ : AuthOuterClass$ResponseGetJWTToken.getDefaultInstance();
    }

    public KifpoolOuterClass$ResponseGetKifpoolOwner getResponseGetKifpoolOwner() {
        return this.traitCase_ == 63421 ? (KifpoolOuterClass$ResponseGetKifpoolOwner) this.trait_ : KifpoolOuterClass$ResponseGetKifpoolOwner.getDefaultInstance();
    }

    public EnrichmentOuterClass$ResponseGetLinkPreview getResponseGetLinkPreview() {
        return this.traitCase_ == 63498 ? (EnrichmentOuterClass$ResponseGetLinkPreview) this.trait_ : EnrichmentOuterClass$ResponseGetLinkPreview.getDefaultInstance();
    }

    public MelonOuterClass$ResponseGetLoanInfo getResponseGetLoanInfo() {
        return this.traitCase_ == 63583 ? (MelonOuterClass$ResponseGetLoanInfo) this.trait_ : MelonOuterClass$ResponseGetLoanInfo.getDefaultInstance();
    }

    public MelonOuterClass$ResponseGetLoansList getResponseGetLoansList() {
        return this.traitCase_ == 63585 ? (MelonOuterClass$ResponseGetLoansList) this.trait_ : MelonOuterClass$ResponseGetLoansList.getDefaultInstance();
    }

    public GroupsOuterClass$ResponseGetMemberPermissions getResponseGetMemberPermissions() {
        return this.traitCase_ == 63457 ? (GroupsOuterClass$ResponseGetMemberPermissions) this.trait_ : GroupsOuterClass$ResponseGetMemberPermissions.getDefaultInstance();
    }

    public MessagingOuterClass$ResponseGetMessagesRepliesInfo getResponseGetMessagesRepliesInfo() {
        return this.traitCase_ == 63664 ? (MessagingOuterClass$ResponseGetMessagesRepliesInfo) this.trait_ : MessagingOuterClass$ResponseGetMessagesRepliesInfo.getDefaultInstance();
    }

    public Microbanki$ResponseGetMoneyRequestDetails getResponseGetMoneyRequestDetails() {
        return this.traitCase_ == 62400 ? (Microbanki$ResponseGetMoneyRequestDetails) this.trait_ : Microbanki$ResponseGetMoneyRequestDetails.getDefaultInstance();
    }

    public Microbanki$ResponseGetMoneyRequestPaymentList getResponseGetMoneyRequestPaymentList() {
        return this.traitCase_ == 62402 ? (Microbanki$ResponseGetMoneyRequestPaymentList) this.trait_ : Microbanki$ResponseGetMoneyRequestPaymentList.getDefaultInstance();
    }

    public WalletOuterClass$ResponseGetMoneyRequestPaymentTokenByCard getResponseGetMoneyRequestPaymentTokenByCard() {
        return this.traitCase_ == 62770 ? (WalletOuterClass$ResponseGetMoneyRequestPaymentTokenByCard) this.trait_ : WalletOuterClass$ResponseGetMoneyRequestPaymentTokenByCard.getDefaultInstance();
    }

    public MyBankOuterClass$ResponseGetMyBank getResponseGetMyBank() {
        return this.traitCase_ == 63244 ? (MyBankOuterClass$ResponseGetMyBank) this.trait_ : MyBankOuterClass$ResponseGetMyBank.getDefaultInstance();
    }

    public GroupsOuterClass$ResponseGetMyGroups getResponseGetMyGroups() {
        return this.traitCase_ == 43747 ? (GroupsOuterClass$ResponseGetMyGroups) this.trait_ : GroupsOuterClass$ResponseGetMyGroups.getDefaultInstance();
    }

    public KifpoolOuterClass$ResponseGetMyKifpools getResponseGetMyKifpools() {
        return this.traitCase_ == 63401 ? (KifpoolOuterClass$ResponseGetMyKifpools) this.trait_ : KifpoolOuterClass$ResponseGetMyKifpools.getDefaultInstance();
    }

    public SentenceOuterClass$ResponseGetMySentence getResponseGetMySentence() {
        return this.traitCase_ == 63574 ? (SentenceOuterClass$ResponseGetMySentence) this.trait_ : SentenceOuterClass$ResponseGetMySentence.getDefaultInstance();
    }

    public WalletOuterClass$ResponseGetMyWallets getResponseGetMyWallets() {
        return this.traitCase_ == 62731 ? (WalletOuterClass$ResponseGetMyWallets) this.trait_ : WalletOuterClass$ResponseGetMyWallets.getDefaultInstance();
    }

    public FilesOuterClass$ResponseGetNasimFilePublicUrl getResponseGetNasimFilePublicUrl() {
        return this.traitCase_ == 3056 ? (FilesOuterClass$ResponseGetNasimFilePublicUrl) this.trait_ : FilesOuterClass$ResponseGetNasimFilePublicUrl.getDefaultInstance();
    }

    public FilesOuterClass$ResponseGetNasimFileUploadResume getResponseGetNasimFileUploadResume() {
        return this.traitCase_ == 3055 ? (FilesOuterClass$ResponseGetNasimFileUploadResume) this.trait_ : FilesOuterClass$ResponseGetNasimFileUploadResume.getDefaultInstance();
    }

    public FilesOuterClass$ResponseGetNasimFileUploadUrl getResponseGetNasimFileUploadUrl() {
        return this.traitCase_ == 157 ? (FilesOuterClass$ResponseGetNasimFileUploadUrl) this.trait_ : FilesOuterClass$ResponseGetNasimFileUploadUrl.getDefaultInstance();
    }

    public FilesOuterClass$ResponseGetNasimFileUrl getResponseGetNasimFileUrl() {
        return this.traitCase_ == 2799 ? (FilesOuterClass$ResponseGetNasimFileUrl) this.trait_ : FilesOuterClass$ResponseGetNasimFileUrl.getDefaultInstance();
    }

    public FilesOuterClass$ResponseGetNasimFileUrls getResponseGetNasimFileUrls() {
        return this.traitCase_ == 2607 ? (FilesOuterClass$ResponseGetNasimFileUrls) this.trait_ : FilesOuterClass$ResponseGetNasimFileUrls.getDefaultInstance();
    }

    public BankOuterClass$ResponseGetOTPTokenV2 getResponseGetOtpTokenV2() {
        return this.traitCase_ == 63259 ? (BankOuterClass$ResponseGetOTPTokenV2) this.trait_ : BankOuterClass$ResponseGetOTPTokenV2.getDefaultInstance();
    }

    public BankOuterClass$ResponseGetOTPToken getResponseGetOtptoken() {
        return this.traitCase_ == 62768 ? (BankOuterClass$ResponseGetOTPToken) this.trait_ : BankOuterClass$ResponseGetOTPToken.getDefaultInstance();
    }

    public WarriorOuterClass$ResponseGetPacketsStatus getResponseGetPacketsStatus() {
        return this.traitCase_ == 63598 ? (WarriorOuterClass$ResponseGetPacketsStatus) this.trait_ : WarriorOuterClass$ResponseGetPacketsStatus.getDefaultInstance();
    }

    public ConfigsOuterClass$ResponseGetParameters getResponseGetParameters() {
        return this.traitCase_ == 135 ? (ConfigsOuterClass$ResponseGetParameters) this.trait_ : ConfigsOuterClass$ResponseGetParameters.getDefaultInstance();
    }

    public Crowdfunding$ResponseGetParticipants getResponseGetParticipants() {
        return this.traitCase_ == 63513 ? (Crowdfunding$ResponseGetParticipants) this.trait_ : Crowdfunding$ResponseGetParticipants.getDefaultInstance();
    }

    public BankOuterClass$ResponseGetPayMoneyRequestToken getResponseGetPayMoneyRequestToken() {
        return this.traitCase_ == 62128 ? (BankOuterClass$ResponseGetPayMoneyRequestToken) this.trait_ : BankOuterClass$ResponseGetPayMoneyRequestToken.getDefaultInstance();
    }

    public BankOuterClass$ResponseGetPaymentToken getResponseGetPaymentToken() {
        return this.traitCase_ == 62409 ? (BankOuterClass$ResponseGetPaymentToken) this.trait_ : BankOuterClass$ResponseGetPaymentToken.getDefaultInstance();
    }

    public WalletOuterClass$ResponseGetPaymentTokenByCard getResponseGetPaymentTokenByCard() {
        return this.traitCase_ == 62748 ? (WalletOuterClass$ResponseGetPaymentTokenByCard) this.trait_ : WalletOuterClass$ResponseGetPaymentTokenByCard.getDefaultInstance();
    }

    public BankOuterClass$ResponseGetPayvandCard getResponseGetPayvandCard() {
        return this.traitCase_ == 62133 ? (BankOuterClass$ResponseGetPayvandCard) this.trait_ : BankOuterClass$ResponseGetPayvandCard.getDefaultInstance();
    }

    public BankOuterClass$ResponseGetPayvandCardList getResponseGetPayvandCardList() {
        return this.traitCase_ == 62131 ? (BankOuterClass$ResponseGetPayvandCardList) this.trait_ : BankOuterClass$ResponseGetPayvandCardList.getDefaultInstance();
    }

    public KifpoolOuterClass$ResponseGetPointBalance getResponseGetPointBalance() {
        return this.traitCase_ == 63435 ? (KifpoolOuterClass$ResponseGetPointBalance) this.trait_ : KifpoolOuterClass$ResponseGetPointBalance.getDefaultInstance();
    }

    public KifpoolOuterClass$ResponseGetPointDetails getResponseGetPointDetails() {
        return this.traitCase_ == 63459 ? (KifpoolOuterClass$ResponseGetPointDetails) this.trait_ : KifpoolOuterClass$ResponseGetPointDetails.getDefaultInstance();
    }

    public KifpoolOuterClass$ResponseGetPointSummery getResponseGetPointSummery() {
        return this.traitCase_ == 63452 ? (KifpoolOuterClass$ResponseGetPointSummery) this.trait_ : KifpoolOuterClass$ResponseGetPointSummery.getDefaultInstance();
    }

    public Saba$ResponseGetPspPaymentToken getResponseGetPspPaymentToken() {
        return this.traitCase_ == 63486 ? (Saba$ResponseGetPspPaymentToken) this.trait_ : Saba$ResponseGetPspPaymentToken.getDefaultInstance();
    }

    public BankOuterClass$ResponseGetPSProxyPaymentToken getResponseGetPsproxyPaymentToken() {
        return this.traitCase_ == 53259 ? (BankOuterClass$ResponseGetPSProxyPaymentToken) this.trait_ : BankOuterClass$ResponseGetPSProxyPaymentToken.getDefaultInstance();
    }

    public BankOuterClass$ResponseGetPSProxyToken getResponseGetPsproxyToken() {
        return this.traitCase_ == 53257 ? (BankOuterClass$ResponseGetPSProxyToken) this.trait_ : BankOuterClass$ResponseGetPSProxyToken.getDefaultInstance();
    }

    public ReactionsOuterClass$ResponseGetReactions getResponseGetReactions() {
        return this.traitCase_ == 63255 ? (ReactionsOuterClass$ResponseGetReactions) this.trait_ : ReactionsOuterClass$ResponseGetReactions.getDefaultInstance();
    }

    public BankOuterClass$ResponseGetRecentCharges getResponseGetRecentCharges() {
        return this.traitCase_ == 62414 ? (BankOuterClass$ResponseGetRecentCharges) this.trait_ : BankOuterClass$ResponseGetRecentCharges.getDefaultInstance();
    }

    public Charnet$ResponseGetRecentInternetBundleOrders getResponseGetRecentInternetBundleOrders() {
        return this.traitCase_ == 63535 ? (Charnet$ResponseGetRecentInternetBundleOrders) this.trait_ : Charnet$ResponseGetRecentInternetBundleOrders.getDefaultInstance();
    }

    public Saba$ResponseGetRecentOrders getResponseGetRecentOrders() {
        return this.traitCase_ == 63508 ? (Saba$ResponseGetRecentOrders) this.trait_ : Saba$ResponseGetRecentOrders.getDefaultInstance();
    }

    public SefteOuterClass$ResponseGetRecipients getResponseGetRecipients() {
        return this.traitCase_ == 63627 ? (SefteOuterClass$ResponseGetRecipients) this.trait_ : SefteOuterClass$ResponseGetRecipients.getDefaultInstance();
    }

    public Sequence$ResponseGetReferencedEntitites getResponseGetReferencedEntitites() {
        return this.traitCase_ == 2629 ? (Sequence$ResponseGetReferencedEntitites) this.trait_ : Sequence$ResponseGetReferencedEntitites.getDefaultInstance();
    }

    public ReferralOuterClass$ResponseGetReferralCode getResponseGetReferralCode() {
        return this.traitCase_ == 63501 ? (ReferralOuterClass$ResponseGetReferralCode) this.trait_ : ReferralOuterClass$ResponseGetReferralCode.getDefaultInstance();
    }

    public WarriorOuterClass$ResponseGetReferralContacts getResponseGetReferralContacts() {
        return this.traitCase_ == 63602 ? (WarriorOuterClass$ResponseGetReferralContacts) this.trait_ : WarriorOuterClass$ResponseGetReferralContacts.getDefaultInstance();
    }

    public ReferralOuterClass$ResponseGetReferredCount getResponseGetReferredCount() {
        return this.traitCase_ == 63478 ? (ReferralOuterClass$ResponseGetReferredCount) this.trait_ : ReferralOuterClass$ResponseGetReferredCount.getDefaultInstance();
    }

    public ReferralOuterClass$ResponseGetReferringUser getResponseGetReferringUser() {
        return this.traitCase_ == 63461 ? (ReferralOuterClass$ResponseGetReferringUser) this.trait_ : ReferralOuterClass$ResponseGetReferringUser.getDefaultInstance();
    }

    public BankOuterClass$ResponseGetRemainToken getResponseGetRemainToken() {
        return this.traitCase_ == 62138 ? (BankOuterClass$ResponseGetRemainToken) this.trait_ : BankOuterClass$ResponseGetRemainToken.getDefaultInstance();
    }

    public BankOuterClass$ResponseGetSadadPSPPaymentToken getResponseGetSadadPsppaymentToken() {
        return this.traitCase_ == 62181 ? (BankOuterClass$ResponseGetSadadPSPPaymentToken) this.trait_ : BankOuterClass$ResponseGetSadadPSPPaymentToken.getDefaultInstance();
    }

    public BillOuterClass$ResponseGetSavedBills getResponseGetSavedBills() {
        return this.traitCase_ == 63552 ? (BillOuterClass$ResponseGetSavedBills) this.trait_ : BillOuterClass$ResponseGetSavedBills.getDefaultInstance();
    }

    public WarriorOuterClass$ResponseGetScoreBoard getResponseGetScoreBoard() {
        return this.traitCase_ == 63594 ? (WarriorOuterClass$ResponseGetScoreBoard) this.trait_ : WarriorOuterClass$ResponseGetScoreBoard.getDefaultInstance();
    }

    public SefteOuterClass$ResponseGetStates getResponseGetStates() {
        return this.traitCase_ == 63616 ? (SefteOuterClass$ResponseGetStates) this.trait_ : SefteOuterClass$ResponseGetStates.getDefaultInstance();
    }

    public PfmOuterClass$ResponseGetSubTransactions getResponseGetSubTransactions() {
        return this.traitCase_ == 63654 ? (PfmOuterClass$ResponseGetSubTransactions) this.trait_ : PfmOuterClass$ResponseGetSubTransactions.getDefaultInstance();
    }

    public AuthOuterClass$ResponseGetTicket getResponseGetTicket() {
        return this.traitCase_ == 63261 ? (AuthOuterClass$ResponseGetTicket) this.trait_ : AuthOuterClass$ResponseGetTicket.getDefaultInstance();
    }

    public Crowdfunding$ResponseGetTotalPaidAmount getResponseGetTotalPaidAmount() {
        return this.traitCase_ == 63528 ? (Crowdfunding$ResponseGetTotalPaidAmount) this.trait_ : Crowdfunding$ResponseGetTotalPaidAmount.getDefaultInstance();
    }

    public PfmOuterClass$ResponseGetTransactionTags getResponseGetTransactionTags() {
        return this.traitCase_ == 63517 ? (PfmOuterClass$ResponseGetTransactionTags) this.trait_ : PfmOuterClass$ResponseGetTransactionTags.getDefaultInstance();
    }

    public PfmOuterClass$ResponseGetUserAccounts getResponseGetUserAccounts() {
        return this.traitCase_ == 63444 ? (PfmOuterClass$ResponseGetUserAccounts) this.trait_ : PfmOuterClass$ResponseGetUserAccounts.getDefaultInstance();
    }

    public VitrineOuterClass$ResponseGetUserBank getResponseGetUserBank() {
        return this.traitCase_ == 63524 ? (VitrineOuterClass$ResponseGetUserBank) this.trait_ : VitrineOuterClass$ResponseGetUserBank.getDefaultInstance();
    }

    public KetfOuterClass$ResponseGetUserContext getResponseGetUserContext() {
        return this.traitCase_ == 146 ? (KetfOuterClass$ResponseGetUserContext) this.trait_ : KetfOuterClass$ResponseGetUserContext.getDefaultInstance();
    }

    public WarriorOuterClass$ResponseGetUserRefers getResponseGetUserRefers() {
        return this.traitCase_ == 63600 ? (WarriorOuterClass$ResponseGetUserRefers) this.trait_ : WarriorOuterClass$ResponseGetUserRefers.getDefaultInstance();
    }

    public WarriorOuterClass$ResponseGetUserScore getResponseGetUserScore() {
        return this.traitCase_ == 63596 ? (WarriorOuterClass$ResponseGetUserScore) this.trait_ : WarriorOuterClass$ResponseGetUserScore.getDefaultInstance();
    }

    public SefteOuterClass$ResponseGetUserSeftes getResponseGetUserSeftes() {
        return this.traitCase_ == 63621 ? (SefteOuterClass$ResponseGetUserSeftes) this.trait_ : SefteOuterClass$ResponseGetUserSeftes.getDefaultInstance();
    }

    public AdvertisementOuterClass$ResponseGetUserStatus getResponseGetUserStatus() {
        return this.traitCase_ == 63442 ? (AdvertisementOuterClass$ResponseGetUserStatus) this.trait_ : AdvertisementOuterClass$ResponseGetUserStatus.getDefaultInstance();
    }

    public PfmOuterClass$ResponseGetUserTags getResponseGetUserTags() {
        return this.traitCase_ == 63521 ? (PfmOuterClass$ResponseGetUserTags) this.trait_ : PfmOuterClass$ResponseGetUserTags.getDefaultInstance();
    }

    public VitrineOuterClass$ResponseGetUserVitrine getResponseGetUserVitrine() {
        return this.traitCase_ == 63257 ? (VitrineOuterClass$ResponseGetUserVitrine) this.trait_ : VitrineOuterClass$ResponseGetUserVitrine.getDefaultInstance();
    }

    public UsersOuterClass$ResponseGetUsersDefaultCardNumber getResponseGetUsersDefaultCardNumber() {
        return this.traitCase_ == 63542 ? (UsersOuterClass$ResponseGetUsersDefaultCardNumber) this.trait_ : UsersOuterClass$ResponseGetUsersDefaultCardNumber.getDefaultInstance();
    }

    public PresenceOuterClass$ResponseGetUsersPresence getResponseGetUsersPresence() {
        return this.traitCase_ == 63645 ? (PresenceOuterClass$ResponseGetUsersPresence) this.trait_ : PresenceOuterClass$ResponseGetUsersPresence.getDefaultInstance();
    }

    public ClubOuterClass$ResponseGetVouchers getResponseGetVouchers() {
        return this.traitCase_ == 63473 ? (ClubOuterClass$ResponseGetVouchers) this.trait_ : ClubOuterClass$ResponseGetVouchers.getDefaultInstance();
    }

    public WalletOuterClass$ResponseGetWalletChargeToken getResponseGetWalletChargeToken() {
        return this.traitCase_ == 62734 ? (WalletOuterClass$ResponseGetWalletChargeToken) this.trait_ : WalletOuterClass$ResponseGetWalletChargeToken.getDefaultInstance();
    }

    public WalletOuterClass$ResponseGetWalletContracts getResponseGetWalletContracts() {
        return this.traitCase_ == 62759 ? (WalletOuterClass$ResponseGetWalletContracts) this.trait_ : WalletOuterClass$ResponseGetWalletContracts.getDefaultInstance();
    }

    public WalletOuterClass$ResponseGetWalletInvoice getResponseGetWalletInvoice() {
        return this.traitCase_ == 62729 ? (WalletOuterClass$ResponseGetWalletInvoice) this.trait_ : WalletOuterClass$ResponseGetWalletInvoice.getDefaultInstance();
    }

    public Saba$ResponseGetWebViewTrackingNumber getResponseGetWebviewTrackingNumber() {
        return this.traitCase_ == 63482 ? (Saba$ResponseGetWebViewTrackingNumber) this.trait_ : Saba$ResponseGetWebViewTrackingNumber.getDefaultInstance();
    }

    public ClubOuterClass$ResponseGetWheel getResponseGetWheel() {
        return this.traitCase_ == 63469 ? (ClubOuterClass$ResponseGetWheel) this.trait_ : ClubOuterClass$ResponseGetWheel.getDefaultInstance();
    }

    public UsersOuterClass$ResponseImportContacts getResponseImportContacts() {
        return this.traitCase_ == 8 ? (UsersOuterClass$ResponseImportContacts) this.trait_ : UsersOuterClass$ResponseImportContacts.getDefaultInstance();
    }

    public SefteOuterClass$ResponseInitP12 getResponseInitP12() {
        return this.traitCase_ == 63609 ? (SefteOuterClass$ResponseInitP12) this.trait_ : SefteOuterClass$ResponseInitP12.getDefaultInstance();
    }

    public SefteOuterClass$ResponseInitSefte getResponseInitSefte() {
        return this.traitCase_ == 63611 ? (SefteOuterClass$ResponseInitSefte) this.trait_ : SefteOuterClass$ResponseInitSefte.getDefaultInstance();
    }

    public BillOuterClass$ResponseInquiryBill getResponseInquiryBill() {
        return this.traitCase_ == 63544 ? (BillOuterClass$ResponseInquiryBill) this.trait_ : BillOuterClass$ResponseInquiryBill.getDefaultInstance();
    }

    public GroupsOuterClass$ResponseInviteUrl getResponseInviteUrl() {
        return this.traitCase_ == 178 ? (GroupsOuterClass$ResponseInviteUrl) this.trait_ : GroupsOuterClass$ResponseInviteUrl.getDefaultInstance();
    }

    public KifpoolOuterClass$ResponseInvoiceKifpool getResponseInvoiceKifpool() {
        return this.traitCase_ == 63410 ? (KifpoolOuterClass$ResponseInvoiceKifpool) this.trait_ : KifpoolOuterClass$ResponseInvoiceKifpool.getDefaultInstance();
    }

    public GroupsOuterClass$ResponseJoinGroup getResponseJoinGroup() {
        return this.traitCase_ == 181 ? (GroupsOuterClass$ResponseJoinGroup) this.trait_ : GroupsOuterClass$ResponseJoinGroup.getDefaultInstance();
    }

    public GroupsOuterClass$ResponseJoinPublicGroup getResponseJoinPublicGroup() {
        return this.traitCase_ == 2897 ? (GroupsOuterClass$ResponseJoinPublicGroup) this.trait_ : GroupsOuterClass$ResponseJoinPublicGroup.getDefaultInstance();
    }

    public MessagingOuterClass$ResponseLoadArchived getResponseLoadArchived() {
        return this.traitCase_ == 2652 ? (MessagingOuterClass$ResponseLoadArchived) this.trait_ : MessagingOuterClass$ResponseLoadArchived.getDefaultInstance();
    }

    public UsersOuterClass$ResponseLoadAvatars getResponseLoadAvatars() {
        return this.traitCase_ == 2812 ? (UsersOuterClass$ResponseLoadAvatars) this.trait_ : UsersOuterClass$ResponseLoadAvatars.getDefaultInstance();
    }

    public UsersOuterClass$ResponseLoadBlockedUsers getResponseLoadBlockedUsers() {
        return this.traitCase_ == 2639 ? (UsersOuterClass$ResponseLoadBlockedUsers) this.trait_ : UsersOuterClass$ResponseLoadBlockedUsers.getDefaultInstance();
    }

    public MessagingOuterClass$ResponseLoadDialogs getResponseLoadDialogs() {
        return this.traitCase_ == 105 ? (MessagingOuterClass$ResponseLoadDialogs) this.trait_ : MessagingOuterClass$ResponseLoadDialogs.getDefaultInstance();
    }

    public GroupsOuterClass$ResponseLoadFullGroups getResponseLoadFullGroups() {
        return this.traitCase_ == 2783 ? (GroupsOuterClass$ResponseLoadFullGroups) this.trait_ : GroupsOuterClass$ResponseLoadFullGroups.getDefaultInstance();
    }

    public UsersOuterClass$ResponseLoadFullUsers getResponseLoadFullUsers() {
        return this.traitCase_ == 2650 ? (UsersOuterClass$ResponseLoadFullUsers) this.trait_ : UsersOuterClass$ResponseLoadFullUsers.getDefaultInstance();
    }

    public GroupsOuterClass$ResponseLoadGroupAvatars getResponseLoadGroupAvatars() {
        return this.traitCase_ == 43749 ? (GroupsOuterClass$ResponseLoadGroupAvatars) this.trait_ : GroupsOuterClass$ResponseLoadGroupAvatars.getDefaultInstance();
    }

    public MessagingOuterClass$ResponseLoadGroupedDialogs getResponseLoadGroupedDialogs() {
        return this.traitCase_ == 226 ? (MessagingOuterClass$ResponseLoadGroupedDialogs) this.trait_ : MessagingOuterClass$ResponseLoadGroupedDialogs.getDefaultInstance();
    }

    public GroupsOuterClass$ResponseLoadGroups getResponseLoadGroups() {
        return this.traitCase_ == 63246 ? (GroupsOuterClass$ResponseLoadGroups) this.trait_ : GroupsOuterClass$ResponseLoadGroups.getDefaultInstance();
    }

    public MessagingOuterClass$ResponseLoadHistory getResponseLoadHistory() {
        return this.traitCase_ == 119 ? (MessagingOuterClass$ResponseLoadHistory) this.trait_ : MessagingOuterClass$ResponseLoadHistory.getDefaultInstance();
    }

    public MelonOuterClass$ResponseLoadLastStates getResponseLoadLastStates() {
        return this.traitCase_ == 63660 ? (MelonOuterClass$ResponseLoadLastStates) this.trait_ : MelonOuterClass$ResponseLoadLastStates.getDefaultInstance();
    }

    public MelonOuterClass$ResponseLoadLoanHistory getResponseLoadLoanHistory() {
        return this.traitCase_ == 63657 ? (MelonOuterClass$ResponseLoadLoanHistory) this.trait_ : MelonOuterClass$ResponseLoadLoanHistory.getDefaultInstance();
    }

    public GroupsOuterClass$ResponseLoadMembers getResponseLoadMembers() {
        return this.traitCase_ == 2787 ? (GroupsOuterClass$ResponseLoadMembers) this.trait_ : GroupsOuterClass$ResponseLoadMembers.getDefaultInstance();
    }

    public ImagesOuterClass$ResponseLoadOwnStickers getResponseLoadOwnStickers() {
        return this.traitCase_ == 239 ? (ImagesOuterClass$ResponseLoadOwnStickers) this.trait_ : ImagesOuterClass$ResponseLoadOwnStickers.getDefaultInstance();
    }

    public MessagingOuterClass$ResponseLoadPeerDialogs getResponseLoadPeerDialogs() {
        return this.traitCase_ == 63250 ? (MessagingOuterClass$ResponseLoadPeerDialogs) this.trait_ : MessagingOuterClass$ResponseLoadPeerDialogs.getDefaultInstance();
    }

    public AbacusOuterClass$ResponseLoadReactions getResponseLoadReactions() {
        return this.traitCase_ == 63240 ? (AbacusOuterClass$ResponseLoadReactions) this.trait_ : AbacusOuterClass$ResponseLoadReactions.getDefaultInstance();
    }

    public ImagesOuterClass$ResponseLoadStickerCollection getResponseLoadStickerCollection() {
        return this.traitCase_ == 247 ? (ImagesOuterClass$ResponseLoadStickerCollection) this.trait_ : ImagesOuterClass$ResponseLoadStickerCollection.getDefaultInstance();
    }

    public PfmOuterClass$ResponseLoadTransactions getResponseLoadTransactions() {
        return this.traitCase_ == 63446 ? (PfmOuterClass$ResponseLoadTransactions) this.trait_ : PfmOuterClass$ResponseLoadTransactions.getDefaultInstance();
    }

    public PfmOuterClass$ResponseLoadTransactionsByIDs getResponseLoadTransactionsByIds() {
        return this.traitCase_ == 63650 ? (PfmOuterClass$ResponseLoadTransactionsByIDs) this.trait_ : PfmOuterClass$ResponseLoadTransactionsByIDs.getDefaultInstance();
    }

    public UsersOuterClass$ResponseLoadUsers getResponseLoadUsers() {
        return this.traitCase_ == 63248 ? (UsersOuterClass$ResponseLoadUsers) this.trait_ : UsersOuterClass$ResponseLoadUsers.getDefaultInstance();
    }

    public Giftpacket$ResponseOpenGiftPacket getResponseOpenGiftPacket() {
        return this.traitCase_ == 63237 ? (Giftpacket$ResponseOpenGiftPacket) this.trait_ : Giftpacket$ResponseOpenGiftPacket.getDefaultInstance();
    }

    public BillOuterClass$ResponsePayBill getResponsePayBill() {
        return this.traitCase_ == 63546 ? (BillOuterClass$ResponsePayBill) this.trait_ : BillOuterClass$ResponsePayBill.getDefaultInstance();
    }

    public SefteOuterClass$ResponsePaySefte getResponsePaySefte() {
        return this.traitCase_ == 63636 ? (SefteOuterClass$ResponsePaySefte) this.trait_ : SefteOuterClass$ResponsePaySefte.getDefaultInstance();
    }

    public Protobuf$ResponseProto getResponseProto() {
        return this.traitCase_ == 63640 ? (Protobuf$ResponseProto) this.trait_ : Protobuf$ResponseProto.getDefaultInstance();
    }

    public KifpoolOuterClass$ResponsePurchaseMessage getResponsePurchaseMessage() {
        return this.traitCase_ == 63419 ? (KifpoolOuterClass$ResponsePurchaseMessage) this.trait_ : KifpoolOuterClass$ResponsePurchaseMessage.getDefaultInstance();
    }

    public KifpoolOuterClass$ResponsePurchaseMessageWithCharge getResponsePurchaseMessageWithCharge() {
        return this.traitCase_ == 63429 ? (KifpoolOuterClass$ResponsePurchaseMessageWithCharge) this.trait_ : KifpoolOuterClass$ResponsePurchaseMessageWithCharge.getDefaultInstance();
    }

    public AbacusOuterClass$ResponseReactionsResponse getResponseReactionsResponse() {
        return this.traitCase_ == 219 ? (AbacusOuterClass$ResponseReactionsResponse) this.trait_ : AbacusOuterClass$ResponseReactionsResponse.getDefaultInstance();
    }

    public SapOuterClass$ResponseReactivateApp getResponseReactivateApp() {
        return this.traitCase_ == 63592 ? (SapOuterClass$ResponseReactivateApp) this.trait_ : SapOuterClass$ResponseReactivateApp.getDefaultInstance();
    }

    public ReferralOuterClass$ResponseRefer getResponseRefer() {
        return this.traitCase_ == 63503 ? (ReferralOuterClass$ResponseRefer) this.trait_ : ReferralOuterClass$ResponseRefer.getDefaultInstance();
    }

    public UsersOuterClass$ResponseSearchContacts getResponseSearchContacts() {
        return this.traitCase_ == 113 ? (UsersOuterClass$ResponseSearchContacts) this.trait_ : UsersOuterClass$ResponseSearchContacts.getDefaultInstance();
    }

    public SearchOuterClass$ResponseSearchMedia getResponseSearchMedia() {
        return this.traitCase_ == 63263 ? (SearchOuterClass$ResponseSearchMedia) this.trait_ : SearchOuterClass$ResponseSearchMedia.getDefaultInstance();
    }

    public SearchOuterClass$ResponseSearchMessages getResponseSearchMessages() {
        return this.traitCase_ == 218 ? (SearchOuterClass$ResponseSearchMessages) this.trait_ : SearchOuterClass$ResponseSearchMessages.getDefaultInstance();
    }

    public SearchOuterClass$ResponseSearchPeer getResponseSearchPeer() {
        return this.traitCase_ == 234 ? (SearchOuterClass$ResponseSearchPeer) this.trait_ : SearchOuterClass$ResponseSearchPeer.getDefaultInstance();
    }

    public AuthOuterClass$ResponseSendChangePhoneVerificationCode getResponseSendChangePhoneVerificationCode() {
        return this.traitCase_ == 63505 ? (AuthOuterClass$ResponseSendChangePhoneVerificationCode) this.trait_ : AuthOuterClass$ResponseSendChangePhoneVerificationCode.getDefaultInstance();
    }

    public AuthOuterClass$ResponseSendDeleteAccountVerificationCode getResponseSendDeleteAccountVerificationCode() {
        return this.traitCase_ == 3089 ? (AuthOuterClass$ResponseSendDeleteAccountVerificationCode) this.trait_ : AuthOuterClass$ResponseSendDeleteAccountVerificationCode.getDefaultInstance();
    }

    public Misc$ResponseSeq getResponseSeq() {
        return this.traitCase_ == 72 ? (Misc$ResponseSeq) this.trait_ : Misc$ResponseSeq.getDefaultInstance();
    }

    public Misc$ResponseSeqDate getResponseSeqDate() {
        return this.traitCase_ == 102 ? (Misc$ResponseSeqDate) this.trait_ : Misc$ResponseSeqDate.getDefaultInstance();
    }

    public SefteOuterClass$ResponseSignSefte getResponseSignSefte() {
        return this.traitCase_ == 63613 ? (SefteOuterClass$ResponseSignSefte) this.trait_ : SefteOuterClass$ResponseSignSefte.getDefaultInstance();
    }

    public ClubOuterClass$ResponseSpinWheel getResponseSpinWheel() {
        return this.traitCase_ == 63471 ? (ClubOuterClass$ResponseSpinWheel) this.trait_ : ClubOuterClass$ResponseSpinWheel.getDefaultInstance();
    }

    public PfmOuterClass$ResponseSplitTransaction getResponseSplitTransaction() {
        return this.traitCase_ == 63648 ? (PfmOuterClass$ResponseSplitTransaction) this.trait_ : PfmOuterClass$ResponseSplitTransaction.getDefaultInstance();
    }

    public AuthOuterClass$ResponseStartPhoneAuth getResponseStartPhoneAuth() {
        return this.traitCase_ == 193 ? (AuthOuterClass$ResponseStartPhoneAuth) this.trait_ : AuthOuterClass$ResponseStartPhoneAuth.getDefaultInstance();
    }

    public ImagesOuterClass$ResponseStickersReponse getResponseStickersReponse() {
        return this.traitCase_ == 240 ? (ImagesOuterClass$ResponseStickersReponse) this.trait_ : ImagesOuterClass$ResponseStickersReponse.getDefaultInstance();
    }

    public KifpoolOuterClass$ResponseTransactionPoint getResponseTransactionPoint() {
        return this.traitCase_ == 63463 ? (KifpoolOuterClass$ResponseTransactionPoint) this.trait_ : KifpoolOuterClass$ResponseTransactionPoint.getDefaultInstance();
    }

    public KifpoolOuterClass$ResponseTransferMoney getResponseTransferMoney() {
        return this.traitCase_ == 63412 ? (KifpoolOuterClass$ResponseTransferMoney) this.trait_ : KifpoolOuterClass$ResponseTransferMoney.getDefaultInstance();
    }

    public AdvertisementOuterClass$ResponseUpdateClick getResponseUpdateClick() {
        return this.traitCase_ == 63623 ? (AdvertisementOuterClass$ResponseUpdateClick) this.trait_ : AdvertisementOuterClass$ResponseUpdateClick.getDefaultInstance();
    }

    public AdvertisementOuterClass$ResponseUpdateView getResponseUpdateView() {
        return this.traitCase_ == 63561 ? (AdvertisementOuterClass$ResponseUpdateView) this.trait_ : AdvertisementOuterClass$ResponseUpdateView.getDefaultInstance();
    }

    public KifpoolOuterClass$ResponseUpgradeKifpool getResponseUpgradeKifpool() {
        return this.traitCase_ == 63403 ? (KifpoolOuterClass$ResponseUpgradeKifpool) this.trait_ : KifpoolOuterClass$ResponseUpgradeKifpool.getDefaultInstance();
    }

    public SefteOuterClass$ResponseUserHasCred getResponseUserHasCred() {
        return this.traitCase_ == 63625 ? (SefteOuterClass$ResponseUserHasCred) this.trait_ : SefteOuterClass$ResponseUserHasCred.getDefaultInstance();
    }

    public SentenceOuterClass$ResponseValidateMySentence getResponseValidateMySentence() {
        return this.traitCase_ == 63576 ? (SentenceOuterClass$ResponseValidateMySentence) this.trait_ : SentenceOuterClass$ResponseValidateMySentence.getDefaultInstance();
    }

    public WalletOuterClass$ResponseVerifyCashOut getResponseVerifyCashOut() {
        return this.traitCase_ == 62763 ? (WalletOuterClass$ResponseVerifyCashOut) this.trait_ : WalletOuterClass$ResponseVerifyCashOut.getDefaultInstance();
    }

    public KifpoolOuterClass$ResponseVerifyCashOutKifpool getResponseVerifyCashOutKifpool() {
        return this.traitCase_ == 63433 ? (KifpoolOuterClass$ResponseVerifyCashOutKifpool) this.trait_ : KifpoolOuterClass$ResponseVerifyCashOutKifpool.getDefaultInstance();
    }

    public WalletOuterClass$ResponseVerifyPeer getResponseVerifyPeer() {
        return this.traitCase_ == 62757 ? (WalletOuterClass$ResponseVerifyPeer) this.trait_ : WalletOuterClass$ResponseVerifyPeer.getDefaultInstance();
    }

    public KifpoolOuterClass$ResponseVerifyPurchaseMessage getResponseVerifyPurchaseMessage() {
        return this.traitCase_ == 63431 ? (KifpoolOuterClass$ResponseVerifyPurchaseMessage) this.trait_ : KifpoolOuterClass$ResponseVerifyPurchaseMessage.getDefaultInstance();
    }

    public WalletOuterClass$ResponseVerifyQRCode getResponseVerifyQrcode() {
        return this.traitCase_ == 62750 ? (WalletOuterClass$ResponseVerifyQRCode) this.trait_ : WalletOuterClass$ResponseVerifyQRCode.getDefaultInstance();
    }

    public Misc$ResponseVoid getResponseVoid() {
        return this.traitCase_ == 50 ? (Misc$ResponseVoid) this.trait_ : Misc$ResponseVoid.getDefaultInstance();
    }

    public PfmOuterClass$RequestReviveTransaction getReviveTransaction() {
        return this.traitCase_ == 63655 ? (PfmOuterClass$RequestReviveTransaction) this.trait_ : PfmOuterClass$RequestReviveTransaction.getDefaultInstance();
    }

    public GroupsOuterClass$RequestRevokeInviteUrl getRevokeInviteUrl() {
        return this.traitCase_ == 179 ? (GroupsOuterClass$RequestRevokeInviteUrl) this.trait_ : GroupsOuterClass$RequestRevokeInviteUrl.getDefaultInstance();
    }

    public UsersOuterClass$RequestSearchContacts getSearchContacts() {
        return this.traitCase_ == 112 ? (UsersOuterClass$RequestSearchContacts) this.trait_ : UsersOuterClass$RequestSearchContacts.getDefaultInstance();
    }

    public SearchOuterClass$RequestSearchMedia getSearchMedia() {
        return this.traitCase_ == 63262 ? (SearchOuterClass$RequestSearchMedia) this.trait_ : SearchOuterClass$RequestSearchMedia.getDefaultInstance();
    }

    public SearchOuterClass$RequestSearchMessages getSearchMessages() {
        return this.traitCase_ == 217 ? (SearchOuterClass$RequestSearchMessages) this.trait_ : SearchOuterClass$RequestSearchMessages.getDefaultInstance();
    }

    public SearchOuterClass$RequestSearchMessagesMore getSearchMessagesMore() {
        return this.traitCase_ == 222 ? (SearchOuterClass$RequestSearchMessagesMore) this.trait_ : SearchOuterClass$RequestSearchMessagesMore.getDefaultInstance();
    }

    public SearchOuterClass$RequestSearchPeer getSearchPeer() {
        return this.traitCase_ == 233 ? (SearchOuterClass$RequestSearchPeer) this.trait_ : SearchOuterClass$RequestSearchPeer.getDefaultInstance();
    }

    public AuthOuterClass$RequestSendChangePhoneVerificationCode getSendChangePhoneVerificationCode() {
        return this.traitCase_ == 63454 ? (AuthOuterClass$RequestSendChangePhoneVerificationCode) this.trait_ : AuthOuterClass$RequestSendChangePhoneVerificationCode.getDefaultInstance();
    }

    public AuthOuterClass$RequestSendDeleteAccountVerificationCode getSendDeleteAccountVerificationCode() {
        return this.traitCase_ == 43609 ? (AuthOuterClass$RequestSendDeleteAccountVerificationCode) this.trait_ : AuthOuterClass$RequestSendDeleteAccountVerificationCode.getDefaultInstance();
    }

    public Feedback$RequestSendFeedBack getSendFeedBack() {
        return this.traitCase_ == 63529 ? (Feedback$RequestSendFeedBack) this.trait_ : Feedback$RequestSendFeedBack.getDefaultInstance();
    }

    public Giftpacket$RequestSendGiftPacketWithWallet getSendGiftPacketWithWallet() {
        return this.traitCase_ == 63233 ? (Giftpacket$RequestSendGiftPacketWithWallet) this.trait_ : Giftpacket$RequestSendGiftPacketWithWallet.getDefaultInstance();
    }

    public KetfOuterClass$RequestSendInlineCallBackData getSendInlineCallbackData() {
        return this.traitCase_ == 3937 ? (KetfOuterClass$RequestSendInlineCallBackData) this.trait_ : KetfOuterClass$RequestSendInlineCallBackData.getDefaultInstance();
    }

    public MessagingOuterClass$RequestSendMessage getSendMessage() {
        return this.traitCase_ == 92 ? (MessagingOuterClass$RequestSendMessage) this.trait_ : MessagingOuterClass$RequestSendMessage.getDefaultInstance();
    }

    public MessagingOuterClass$RequestSendMultiMediaMessage getSendMultiMediaMessage() {
        return this.traitCase_ == 63662 ? (MessagingOuterClass$RequestSendMultiMediaMessage) this.trait_ : MessagingOuterClass$RequestSendMultiMediaMessage.getDefaultInstance();
    }

    public SentenceOuterClass$RequestSendMyGiftPacket getSendMyGiftPacket() {
        return this.traitCase_ == 63577 ? (SentenceOuterClass$RequestSendMyGiftPacket) this.trait_ : SentenceOuterClass$RequestSendMyGiftPacket.getDefaultInstance();
    }

    public WarriorOuterClass$RequestSendReferral getSendReferral() {
        return this.traitCase_ == 63603 ? (WarriorOuterClass$RequestSendReferral) this.trait_ : WarriorOuterClass$RequestSendReferral.getDefaultInstance();
    }

    public Seraj$RequestSendSerajEvent getSendSerajEvent() {
        return this.traitCase_ == 63238 ? (Seraj$RequestSendSerajEvent) this.trait_ : Seraj$RequestSendSerajEvent.getDefaultInstance();
    }

    public UpdateBoxStruct$SeqUpdate getSeqUpdate() {
        return this.traitCase_ == 13 ? (UpdateBoxStruct$SeqUpdate) this.trait_ : UpdateBoxStruct$SeqUpdate.getDefaultInstance();
    }

    public UpdateBoxStruct$SeqUpdateTooLong getSeqUpdateTooLong() {
        return this.traitCase_ == 25 ? (UpdateBoxStruct$SeqUpdateTooLong) this.trait_ : UpdateBoxStruct$SeqUpdateTooLong.getDefaultInstance();
    }

    public GroupsOuterClass$RequestSetCanSeeMessages getSetCanSeeMessages() {
        return this.traitCase_ == 724 ? (GroupsOuterClass$RequestSetCanSeeMessages) this.trait_ : GroupsOuterClass$RequestSetCanSeeMessages.getDefaultInstance();
    }

    public SapOuterClass$RequestSetDefaultCard getSetDefaultCard() {
        return this.traitCase_ == 63562 ? (SapOuterClass$RequestSetDefaultCard) this.trait_ : SapOuterClass$RequestSetDefaultCard.getDefaultInstance();
    }

    public GroupsOuterClass$RequestSetGroupDefaultPermissions getSetGroupDefaultPermissions() {
        return this.traitCase_ == 63476 ? (GroupsOuterClass$RequestSetGroupDefaultPermissions) this.trait_ : GroupsOuterClass$RequestSetGroupDefaultPermissions.getDefaultInstance();
    }

    public GroupsOuterClass$RequestSetMemberPermissions getSetMemberPermissions() {
        return this.traitCase_ == 63455 ? (GroupsOuterClass$RequestSetMemberPermissions) this.trait_ : GroupsOuterClass$RequestSetMemberPermissions.getDefaultInstance();
    }

    public PresenceOuterClass$RequestSetOnline getSetOnline() {
        return this.traitCase_ == 29 ? (PresenceOuterClass$RequestSetOnline) this.trait_ : PresenceOuterClass$RequestSetOnline.getDefaultInstance();
    }

    public Saba$RequestSetRecentOrder getSetRecentOrder() {
        return this.traitCase_ == 63506 ? (Saba$RequestSetRecentOrder) this.trait_ : Saba$RequestSetRecentOrder.getDefaultInstance();
    }

    public GroupsOuterClass$RequestSetRestriction getSetRestriction() {
        return this.traitCase_ == 728 ? (GroupsOuterClass$RequestSetRestriction) this.trait_ : GroupsOuterClass$RequestSetRestriction.getDefaultInstance();
    }

    public AuthOuterClass$RequestSignOut getSignOut() {
        return this.traitCase_ == 84 ? (AuthOuterClass$RequestSignOut) this.trait_ : AuthOuterClass$RequestSignOut.getDefaultInstance();
    }

    public SefteOuterClass$RequestSignSefte getSignSefte() {
        return this.traitCase_ == 63612 ? (SefteOuterClass$RequestSignSefte) this.trait_ : SefteOuterClass$RequestSignSefte.getDefaultInstance();
    }

    public AuthOuterClass$RequestSignUp getSignUp() {
        return this.traitCase_ == 190 ? (AuthOuterClass$RequestSignUp) this.trait_ : AuthOuterClass$RequestSignUp.getDefaultInstance();
    }

    public ClubOuterClass$RequestSpinWheel getSpinWheel() {
        return this.traitCase_ == 63470 ? (ClubOuterClass$RequestSpinWheel) this.trait_ : ClubOuterClass$RequestSpinWheel.getDefaultInstance();
    }

    public PfmOuterClass$RequestSplitTransaction getSplitTransaction() {
        return this.traitCase_ == 63647 ? (PfmOuterClass$RequestSplitTransaction) this.trait_ : PfmOuterClass$RequestSplitTransaction.getDefaultInstance();
    }

    public MeetOuterClass$RequestStartCall getStartCall() {
        return this.traitCase_ == 63578 ? (MeetOuterClass$RequestStartCall) this.trait_ : MeetOuterClass$RequestStartCall.getDefaultInstance();
    }

    public AuthOuterClass$RequestStartPhoneAuth getStartPhoneAuth() {
        return this.traitCase_ == 191 ? (AuthOuterClass$RequestStartPhoneAuth) this.trait_ : AuthOuterClass$RequestStartPhoneAuth.getDefaultInstance();
    }

    public PresenceOuterClass$RequestStopTyping getStopTyping() {
        return this.traitCase_ == 30 ? (PresenceOuterClass$RequestStopTyping) this.trait_ : PresenceOuterClass$RequestStopTyping.getDefaultInstance();
    }

    public AdvertisementOuterClass$RequestSubmitDialogAdOrder getSubmitDialogAdOrder() {
        return this.traitCase_ == 63567 ? (AdvertisementOuterClass$RequestSubmitDialogAdOrder) this.trait_ : AdvertisementOuterClass$RequestSubmitDialogAdOrder.getDefaultInstance();
    }

    public PresenceOuterClass$RequestSubscribeFromGroupOnline getSubscribeFromGroupOnline() {
        return this.traitCase_ == 75 ? (PresenceOuterClass$RequestSubscribeFromGroupOnline) this.trait_ : PresenceOuterClass$RequestSubscribeFromGroupOnline.getDefaultInstance();
    }

    public PresenceOuterClass$RequestSubscribeFromOnline getSubscribeFromOnline() {
        return this.traitCase_ == 33 ? (PresenceOuterClass$RequestSubscribeFromOnline) this.trait_ : PresenceOuterClass$RequestSubscribeFromOnline.getDefaultInstance();
    }

    public PresenceOuterClass$RequestSubscribeToGroupOnline getSubscribeToGroupOnline() {
        return this.traitCase_ == 74 ? (PresenceOuterClass$RequestSubscribeToGroupOnline) this.trait_ : PresenceOuterClass$RequestSubscribeToGroupOnline.getDefaultInstance();
    }

    public PresenceOuterClass$RequestSubscribeToOnline getSubscribeToOnline() {
        return this.traitCase_ == 32 ? (PresenceOuterClass$RequestSubscribeToOnline) this.trait_ : PresenceOuterClass$RequestSubscribeToOnline.getDefaultInstance();
    }

    public AuthOuterClass$RequestTerminateAllSessions getTerminateAllSessions() {
        return this.traitCase_ == 83 ? (AuthOuterClass$RequestTerminateAllSessions) this.trait_ : AuthOuterClass$RequestTerminateAllSessions.getDefaultInstance();
    }

    public AuthOuterClass$RequestTerminateSession getTerminateSession() {
        return this.traitCase_ == 82 ? (AuthOuterClass$RequestTerminateSession) this.trait_ : AuthOuterClass$RequestTerminateSession.getDefaultInstance();
    }

    public b getTraitCase() {
        return b.j(this.traitCase_);
    }

    public KifpoolOuterClass$RequestTransactionPoint getTransactionPoint() {
        return this.traitCase_ == 63462 ? (KifpoolOuterClass$RequestTransactionPoint) this.trait_ : KifpoolOuterClass$RequestTransactionPoint.getDefaultInstance();
    }

    public KifpoolOuterClass$RequestTransferMoney getTransferMoney() {
        return this.traitCase_ == 63411 ? (KifpoolOuterClass$RequestTransferMoney) this.trait_ : KifpoolOuterClass$RequestTransferMoney.getDefaultInstance();
    }

    public SapOuterClass$RequestTransferMoneyByCard getTransferMoneyByCard() {
        return this.traitCase_ == 63495 ? (SapOuterClass$RequestTransferMoneyByCard) this.trait_ : SapOuterClass$RequestTransferMoneyByCard.getDefaultInstance();
    }

    public GroupsOuterClass$RequestTransferOwnership getTransferOwnership() {
        return this.traitCase_ == 2789 ? (GroupsOuterClass$RequestTransferOwnership) this.trait_ : GroupsOuterClass$RequestTransferOwnership.getDefaultInstance();
    }

    public PresenceOuterClass$RequestTyping getTyping() {
        return this.traitCase_ == 27 ? (PresenceOuterClass$RequestTyping) this.trait_ : PresenceOuterClass$RequestTyping.getDefaultInstance();
    }

    public ReactionsOuterClass$RequestUnbindAllMoneyRequestDetails getUnbindAllMoneyRequestDetails() {
        return this.traitCase_ == 62411 ? (ReactionsOuterClass$RequestUnbindAllMoneyRequestDetails) this.trait_ : ReactionsOuterClass$RequestUnbindAllMoneyRequestDetails.getDefaultInstance();
    }

    public UsersOuterClass$RequestUnblockUser getUnblockUser() {
        return this.traitCase_ == 2637 ? (UsersOuterClass$RequestUnblockUser) this.trait_ : UsersOuterClass$RequestUnblockUser.getDefaultInstance();
    }

    public PushOuterClass$RequestUnregisterAllPushCredentials getUnregisterAllPushCredentials() {
        return this.traitCase_ == 63251 ? (PushOuterClass$RequestUnregisterAllPushCredentials) this.trait_ : PushOuterClass$RequestUnregisterAllPushCredentials.getDefaultInstance();
    }

    public PushOuterClass$RequestUnregisterGooglePush getUnregisterGooglePush() {
        return this.traitCase_ == 2631 ? (PushOuterClass$RequestUnregisterGooglePush) this.trait_ : PushOuterClass$RequestUnregisterGooglePush.getDefaultInstance();
    }

    public AdvertisementOuterClass$RequestUpdateClick getUpdateClick() {
        return this.traitCase_ == 63622 ? (AdvertisementOuterClass$RequestUpdateClick) this.trait_ : AdvertisementOuterClass$RequestUpdateClick.getDefaultInstance();
    }

    public AdvertisementOuterClass$RequestUpdateGroupStatus getUpdateGroupStatus() {
        return this.traitCase_ == 63439 ? (AdvertisementOuterClass$RequestUpdateGroupStatus) this.trait_ : AdvertisementOuterClass$RequestUpdateGroupStatus.getDefaultInstance();
    }

    public MessagingOuterClass$RequestUpdateMessage getUpdateMessage() {
        return this.traitCase_ == 2658 ? (MessagingOuterClass$RequestUpdateMessage) this.trait_ : MessagingOuterClass$RequestUpdateMessage.getDefaultInstance();
    }

    public AdvertisementOuterClass$RequestUpdateView getUpdateView() {
        return this.traitCase_ == 63560 ? (AdvertisementOuterClass$RequestUpdateView) this.trait_ : AdvertisementOuterClass$RequestUpdateView.getDefaultInstance();
    }

    public KifpoolOuterClass$RequestUpgradeKifpool getUpgradeKifpool() {
        return this.traitCase_ == 63402 ? (KifpoolOuterClass$RequestUpgradeKifpool) this.trait_ : KifpoolOuterClass$RequestUpgradeKifpool.getDefaultInstance();
    }

    public SefteOuterClass$RequestUserHasCred getUserHasCred() {
        return this.traitCase_ == 63624 ? (SefteOuterClass$RequestUserHasCred) this.trait_ : SefteOuterClass$RequestUserHasCred.getDefaultInstance();
    }

    public AuthOuterClass$RequestValidateCode getValidateCode() {
        return this.traitCase_ == 189 ? (AuthOuterClass$RequestValidateCode) this.trait_ : AuthOuterClass$RequestValidateCode.getDefaultInstance();
    }

    public SentenceOuterClass$RequestValidateMySentence getValidateMySentence() {
        return this.traitCase_ == 63575 ? (SentenceOuterClass$RequestValidateMySentence) this.trait_ : SentenceOuterClass$RequestValidateMySentence.getDefaultInstance();
    }

    public WalletOuterClass$RequestVerifyCashOut getVerifyCashOut() {
        return this.traitCase_ == 62762 ? (WalletOuterClass$RequestVerifyCashOut) this.trait_ : WalletOuterClass$RequestVerifyCashOut.getDefaultInstance();
    }

    public KifpoolOuterClass$RequestVerifyCashOutKifpool getVerifyCashOutKifpool() {
        return this.traitCase_ == 63432 ? (KifpoolOuterClass$RequestVerifyCashOutKifpool) this.trait_ : KifpoolOuterClass$RequestVerifyCashOutKifpool.getDefaultInstance();
    }

    public WalletOuterClass$RequestVerifyPeer getVerifyPeer() {
        return this.traitCase_ == 62756 ? (WalletOuterClass$RequestVerifyPeer) this.trait_ : WalletOuterClass$RequestVerifyPeer.getDefaultInstance();
    }

    public KifpoolOuterClass$RequestVerifyPurchaseMessage getVerifyPurchaseMessage() {
        return this.traitCase_ == 63430 ? (KifpoolOuterClass$RequestVerifyPurchaseMessage) this.trait_ : KifpoolOuterClass$RequestVerifyPurchaseMessage.getDefaultInstance();
    }

    public WalletOuterClass$RequestVerifyQRCode getVerifyQrcode() {
        return this.traitCase_ == 62749 ? (WalletOuterClass$RequestVerifyQRCode) this.trait_ : WalletOuterClass$RequestVerifyQRCode.getDefaultInstance();
    }

    public UpdateBoxStruct$WeakFatUpdate getWeakFatUpdate() {
        return this.traitCase_ == 2673 ? (UpdateBoxStruct$WeakFatUpdate) this.trait_ : UpdateBoxStruct$WeakFatUpdate.getDefaultInstance();
    }

    public UpdateBoxStruct$WeakUpdate getWeakUpdate() {
        return this.traitCase_ == 26 ? (UpdateBoxStruct$WeakUpdate) this.trait_ : UpdateBoxStruct$WeakUpdate.getDefaultInstance();
    }

    public boolean hasAcceptCall() {
        return this.traitCase_ == 63579;
    }

    public boolean hasAcceptReferralInvite() {
        return this.traitCase_ == 63605;
    }

    public boolean hasActivateWallet() {
        return this.traitCase_ == 62760;
    }

    public boolean hasAddCard() {
        return this.traitCase_ == 136;
    }

    public boolean hasAddContact() {
        return this.traitCase_ == 114;
    }

    public boolean hasAddDestinationCards() {
        return this.traitCase_ == 63588;
    }

    public boolean hasAddDetailToTransaction() {
        return this.traitCase_ == 63641;
    }

    public boolean hasAddGif() {
        return this.traitCase_ == 2857;
    }

    public boolean hasAddNewCards() {
        return this.traitCase_ == 63555;
    }

    public boolean hasAddRecipient() {
        return this.traitCase_ == 63628;
    }

    public boolean hasAddStickerCollection() {
        return this.traitCase_ == 244;
    }

    public boolean hasAddTransactionTags() {
        return this.traitCase_ == 63449;
    }

    public boolean hasAddUserTags() {
        return this.traitCase_ == 63518;
    }

    public boolean hasAuthorizeUser() {
        return this.traitCase_ == 63606;
    }

    public boolean hasBindMoneyRequestDetails() {
        return this.traitCase_ == 62403;
    }

    public boolean hasBindMoneyRequestDetailsList() {
        return this.traitCase_ == 62410;
    }

    public boolean hasBlockUser() {
        return this.traitCase_ == 2636;
    }

    public boolean hasBuyCharge() {
        return this.traitCase_ == 63537;
    }

    public boolean hasBuyFastCharge() {
        return this.traitCase_ == 62464;
    }

    public boolean hasBuyInternetBundle() {
        return this.traitCase_ == 63539;
    }

    public boolean hasBuyVoucher() {
        return this.traitCase_ == 63474;
    }

    public boolean hasBuyWheelChance() {
        return this.traitCase_ == 63466;
    }

    public boolean hasCashOutFromWallet() {
        return this.traitCase_ == 62764;
    }

    public boolean hasCashoutKifpool() {
        return this.traitCase_ == 63407;
    }

    public boolean hasChangeDefaultCardNumber() {
        return this.traitCase_ == 62129;
    }

    public boolean hasChangePhone() {
        return this.traitCase_ == 63453;
    }

    public boolean hasChangePointToMoney() {
        return this.traitCase_ == 63464;
    }

    public boolean hasChangeStatusDialogAdOrder() {
        return this.traitCase_ == 63570;
    }

    public boolean hasCharge() {
        return this.traitCase_ == 63415;
    }

    public boolean hasCheckChargePermission() {
        return this.traitCase_ == 63413;
    }

    public boolean hasCheckNickName() {
        return this.traitCase_ == 206;
    }

    public boolean hasCheckStatusOfPayment() {
        return this.traitCase_ == 63619;
    }

    public boolean hasClearChat() {
        return this.traitCase_ == 99;
    }

    public boolean hasCombinedUpdate() {
        return this.traitCase_ == 2625;
    }

    public boolean hasCreateGroup() {
        return this.traitCase_ == 230;
    }

    public boolean hasCreateKifpool() {
        return this.traitCase_ == 63404;
    }

    public boolean hasCreateSavedBill() {
        return this.traitCase_ == 63549;
    }

    public boolean hasCryptoTransfer() {
        return this.traitCase_ == 63632;
    }

    public boolean hasDeleteAccount() {
        return this.traitCase_ == 43606;
    }

    public boolean hasDeleteChat() {
        return this.traitCase_ == 100;
    }

    public boolean hasDeleteInternetBundleOrder() {
        return this.traitCase_ == 63536;
    }

    public boolean hasDeleteMessage() {
        return this.traitCase_ == 98;
    }

    public boolean hasDeleteOrder() {
        return this.traitCase_ == 63509;
    }

    public boolean hasDeleteSavedBills() {
        return this.traitCase_ == 63554;
    }

    public boolean hasDeliverOtp() {
        return this.traitCase_ == 63493;
    }

    public boolean hasDiscardCall() {
        return this.traitCase_ == 63580;
    }

    public boolean hasEditAbout() {
        return this.traitCase_ == 212;
    }

    public boolean hasEditAvatar() {
        return this.traitCase_ == 31;
    }

    public boolean hasEditBirthDate() {
        return this.traitCase_ == 63652;
    }

    public boolean hasEditCardExpirationDate() {
        return this.traitCase_ == 63566;
    }

    public boolean hasEditChannelNick() {
        return this.traitCase_ == 3396;
    }

    public boolean hasEditGroupAbout() {
        return this.traitCase_ == 213;
    }

    public boolean hasEditGroupAvatar() {
        return this.traitCase_ == 86;
    }

    public boolean hasEditGroupDefaultCardNumber() {
        return this.traitCase_ == 120;
    }

    public boolean hasEditGroupTitle() {
        return this.traitCase_ == 85;
    }

    public boolean hasEditMyPreferredLanguages() {
        return this.traitCase_ == 145;
    }

    public boolean hasEditMyTimeZone() {
        return this.traitCase_ == 144;
    }

    public boolean hasEditName() {
        return this.traitCase_ == 53;
    }

    public boolean hasEditNickName() {
        return this.traitCase_ == 205;
    }

    public boolean hasEditParameter() {
        return this.traitCase_ == 128;
    }

    public boolean hasEditSex() {
        return this.traitCase_ == 63651;
    }

    public boolean hasEditUserLocalName() {
        return this.traitCase_ == 96;
    }

    public boolean hasEnrollNewCard() {
        return this.traitCase_ == 63487;
    }

    public boolean hasFatSeqUpdate() {
        return this.traitCase_ == 73;
    }

    public boolean hasFetchGroupAdmins() {
        return this.traitCase_ == 729;
    }

    public boolean hasFilterTaggedTransactions() {
        return this.traitCase_ == 63630;
    }

    public boolean hasGetAcquiredVouchers() {
        return this.traitCase_ == 63637;
    }

    public boolean hasGetAdProvider() {
        return this.traitCase_ == 63525;
    }

    public boolean hasGetAuthSessions() {
        return this.traitCase_ == 80;
    }

    public boolean hasGetBaleTicket() {
        return this.traitCase_ == 63260;
    }

    public boolean hasGetBamServiceToken() {
        return this.traitCase_ == 62406;
    }

    public boolean hasGetBillHistory() {
        return this.traitCase_ == 63547;
    }

    public boolean hasGetBotWhiteList() {
        return this.traitCase_ == 249;
    }

    public boolean hasGetCanSeeMessages() {
        return this.traitCase_ == 726;
    }

    public boolean hasGetCardInfo() {
        return this.traitCase_ == 63489;
    }

    public boolean hasGetCardTransferToken() {
        return this.traitCase_ == 62125;
    }

    public boolean hasGetCards() {
        return this.traitCase_ == 63558;
    }

    public boolean hasGetChannelAds() {
        return this.traitCase_ == 63264;
    }

    public boolean hasGetChannelEarnMoneyInfo() {
        return this.traitCase_ == 63447;
    }

    public boolean hasGetChannelEarnMoneyStatus() {
        return this.traitCase_ == 63436;
    }

    public boolean hasGetChargeAmounts() {
        return this.traitCase_ == 63510;
    }

    public boolean hasGetChargePaymentToken() {
        return this.traitCase_ == 63417;
    }

    public boolean hasGetChargeTopupPaymentToken() {
        return this.traitCase_ == 63484;
    }

    public boolean hasGetChargeVoucherPaymentToken() {
        return this.traitCase_ == 63485;
    }

    public boolean hasGetCitiesOfState() {
        return this.traitCase_ == 63617;
    }

    public boolean hasGetContacts() {
        return this.traitCase_ == 87;
    }

    public boolean hasGetCryptoChargePaymentToken() {
        return this.traitCase_ == 63629;
    }

    public boolean hasGetCryptoWallets() {
        return this.traitCase_ == 63634;
    }

    public boolean hasGetDefaultCard() {
        return this.traitCase_ == 63563;
    }

    public boolean hasGetDestinationCardInfo() {
        return this.traitCase_ == 63491;
    }

    public boolean hasGetDestinationCards() {
        return this.traitCase_ == 63586;
    }

    public boolean hasGetDialogAdOrderDetails() {
        return this.traitCase_ == 63568;
    }

    public boolean hasGetDialogAdOrderPaymentToken() {
        return this.traitCase_ == 63571;
    }

    public boolean hasGetGiftPacketPaymentToken() {
        return this.traitCase_ == 63232;
    }

    public boolean hasGetGroupDefaultCardNumber() {
        return this.traitCase_ == 129;
    }

    public boolean hasGetGroupDifference() {
        return this.traitCase_ == 187;
    }

    public boolean hasGetGroupInviteUrl() {
        return this.traitCase_ == 177;
    }

    public boolean hasGetGroupMembersCount() {
        return this.traitCase_ == 63499;
    }

    public boolean hasGetGroupMembersPresence() {
        return this.traitCase_ == 63642;
    }

    public boolean hasGetGroupState() {
        return this.traitCase_ == 153;
    }

    public boolean hasGetInternetBundleList() {
        return this.traitCase_ == 63532;
    }

    public boolean hasGetInternetBundlePaymentToken() {
        return this.traitCase_ == 63530;
    }

    public boolean hasGetJwtToken() {
        return this.traitCase_ == 600;
    }

    public boolean hasGetKifpoolOwner() {
        return this.traitCase_ == 63420;
    }

    public boolean hasGetLinkPreview() {
        return this.traitCase_ == 63497;
    }

    public boolean hasGetLoanInfo() {
        return this.traitCase_ == 63582;
    }

    public boolean hasGetLoansList() {
        return this.traitCase_ == 63584;
    }

    public boolean hasGetMemberPermissions() {
        return this.traitCase_ == 63456;
    }

    public boolean hasGetMessagesRepliesInfo() {
        return this.traitCase_ == 63663;
    }

    public boolean hasGetMoneyRequestDetails() {
        return this.traitCase_ == 62393;
    }

    public boolean hasGetMoneyRequestPaymentList() {
        return this.traitCase_ == 62401;
    }

    public boolean hasGetMoneyRequestPaymentTokenByCard() {
        return this.traitCase_ == 62769;
    }

    public boolean hasGetMyBank() {
        return this.traitCase_ == 63243;
    }

    public boolean hasGetMyGroups() {
        return this.traitCase_ == 43746;
    }

    public boolean hasGetMyKifpools() {
        return this.traitCase_ == 63400;
    }

    public boolean hasGetMySentence() {
        return this.traitCase_ == 63573;
    }

    public boolean hasGetMyWallets() {
        return this.traitCase_ == 62730;
    }

    public boolean hasGetNasimFilePublicUrl() {
        return this.traitCase_ == 3072;
    }

    public boolean hasGetNasimFileUploadResume() {
        return this.traitCase_ == 3071;
    }

    public boolean hasGetNasimFileUploadUrl() {
        return this.traitCase_ == 143;
    }

    public boolean hasGetNasimFileUrl() {
        return this.traitCase_ == 2815;
    }

    public boolean hasGetNasimFileUrls() {
        return this.traitCase_ == 2591;
    }

    public boolean hasGetOtpTokenV2() {
        return this.traitCase_ == 63258;
    }

    public boolean hasGetOtptoken() {
        return this.traitCase_ == 62761;
    }

    public boolean hasGetPacket() {
        return this.traitCase_ == 63604;
    }

    public boolean hasGetPacketsStatus() {
        return this.traitCase_ == 63597;
    }

    public boolean hasGetParameters() {
        return this.traitCase_ == 134;
    }

    public boolean hasGetParticipants() {
        return this.traitCase_ == 63512;
    }

    public boolean hasGetPayMoneyRequestToken() {
        return this.traitCase_ == 62127;
    }

    public boolean hasGetPaymentToken() {
        return this.traitCase_ == 62408;
    }

    public boolean hasGetPaymentTokenByCard() {
        return this.traitCase_ == 62747;
    }

    public boolean hasGetPayvandCard() {
        return this.traitCase_ == 62132;
    }

    public boolean hasGetPayvandCardList() {
        return this.traitCase_ == 62130;
    }

    public boolean hasGetPointBalance() {
        return this.traitCase_ == 63434;
    }

    public boolean hasGetPointDetails() {
        return this.traitCase_ == 63458;
    }

    public boolean hasGetPointSummery() {
        return this.traitCase_ == 63451;
    }

    public boolean hasGetPsproxyPaymentToken() {
        return this.traitCase_ == 53258;
    }

    public boolean hasGetPsproxyToken() {
        return this.traitCase_ == 53256;
    }

    public boolean hasGetReactions() {
        return this.traitCase_ == 63254;
    }

    public boolean hasGetRecentCharges() {
        return this.traitCase_ == 62412;
    }

    public boolean hasGetRecentInternetBundleOrders() {
        return this.traitCase_ == 63534;
    }

    public boolean hasGetRecentOrders() {
        return this.traitCase_ == 63507;
    }

    public boolean hasGetRecipients() {
        return this.traitCase_ == 63626;
    }

    public boolean hasGetReferencedEntitites() {
        return this.traitCase_ == 2628;
    }

    public boolean hasGetReferralCode() {
        return this.traitCase_ == 63500;
    }

    public boolean hasGetReferralContacts() {
        return this.traitCase_ == 63601;
    }

    public boolean hasGetReferredCount() {
        return this.traitCase_ == 63477;
    }

    public boolean hasGetReferringUser() {
        return this.traitCase_ == 63460;
    }

    public boolean hasGetRemainToken() {
        return this.traitCase_ == 58106;
    }

    public boolean hasGetSadadPsppaymentToken() {
        return this.traitCase_ == 62180;
    }

    public boolean hasGetSavedBills() {
        return this.traitCase_ == 63551;
    }

    public boolean hasGetScoreBoard() {
        return this.traitCase_ == 63593;
    }

    public boolean hasGetState() {
        return this.traitCase_ == 9;
    }

    public boolean hasGetStates() {
        return this.traitCase_ == 63615;
    }

    public boolean hasGetSubTransactions() {
        return this.traitCase_ == 63653;
    }

    public boolean hasGetTotalPaidAmount() {
        return this.traitCase_ == 63527;
    }

    public boolean hasGetTransactionTags() {
        return this.traitCase_ == 63516;
    }

    public boolean hasGetUserAccounts() {
        return this.traitCase_ == 63443;
    }

    public boolean hasGetUserBank() {
        return this.traitCase_ == 63522;
    }

    public boolean hasGetUserContext() {
        return this.traitCase_ == 137;
    }

    public boolean hasGetUserRefers() {
        return this.traitCase_ == 63599;
    }

    public boolean hasGetUserScore() {
        return this.traitCase_ == 63595;
    }

    public boolean hasGetUserSeftes() {
        return this.traitCase_ == 63620;
    }

    public boolean hasGetUserStatus() {
        return this.traitCase_ == 63441;
    }

    public boolean hasGetUserTags() {
        return this.traitCase_ == 63520;
    }

    public boolean hasGetUserVitrine() {
        return this.traitCase_ == 63256;
    }

    public boolean hasGetUsersDefaultCardNumber() {
        return this.traitCase_ == 63541;
    }

    public boolean hasGetUsersPresence() {
        return this.traitCase_ == 63644;
    }

    public boolean hasGetVouchers() {
        return this.traitCase_ == 63472;
    }

    public boolean hasGetWalletChargeToken() {
        return this.traitCase_ == 62733;
    }

    public boolean hasGetWalletContracts() {
        return this.traitCase_ == 62758;
    }

    public boolean hasGetWalletInvoice() {
        return this.traitCase_ == 62752;
    }

    public boolean hasGetWebviewTrackingNumber() {
        return this.traitCase_ == 63481;
    }

    public boolean hasGetWheel() {
        return this.traitCase_ == 63468;
    }

    public boolean hasGrantBankiAccess() {
        return this.traitCase_ == 62397;
    }

    public boolean hasImportContacts() {
        return this.traitCase_ == 7;
    }

    public boolean hasInitP12() {
        return this.traitCase_ == 63608;
    }

    public boolean hasInitSefte() {
        return this.traitCase_ == 63610;
    }

    public boolean hasInquiryBill() {
        return this.traitCase_ == 63543;
    }

    public boolean hasInviteUser() {
        return this.traitCase_ == 69;
    }

    public boolean hasInvoiceKifpool() {
        return this.traitCase_ == 63409;
    }

    public boolean hasJoinGroup() {
        return this.traitCase_ == 180;
    }

    public boolean hasJoinPublicGroup() {
        return this.traitCase_ == 2881;
    }

    public boolean hasKickUser() {
        return this.traitCase_ == 71;
    }

    public boolean hasLeaveGroup() {
        return this.traitCase_ == 70;
    }

    public boolean hasLoadArchived() {
        return this.traitCase_ == 2651;
    }

    public boolean hasLoadAvatars() {
        return this.traitCase_ == 2656;
    }

    public boolean hasLoadBlockedUsers() {
        return this.traitCase_ == 2638;
    }

    public boolean hasLoadDialogs() {
        return this.traitCase_ == 104;
    }

    public boolean hasLoadFullGroups() {
        return this.traitCase_ == 2782;
    }

    public boolean hasLoadFullUsers() {
        return this.traitCase_ == 2649;
    }

    public boolean hasLoadGroupAvatars() {
        return this.traitCase_ == 43748;
    }

    public boolean hasLoadGroupedDialogs() {
        return this.traitCase_ == 225;
    }

    public boolean hasLoadGroups() {
        return this.traitCase_ == 63245;
    }

    public boolean hasLoadHistory() {
        return this.traitCase_ == 118;
    }

    public boolean hasLoadLastStates() {
        return this.traitCase_ == 63659;
    }

    public boolean hasLoadLoanHistory() {
        return this.traitCase_ == 63656;
    }

    public boolean hasLoadMembers() {
        return this.traitCase_ == 2786;
    }

    public boolean hasLoadOwnStickers() {
        return this.traitCase_ == 238;
    }

    public boolean hasLoadPeerDialogs() {
        return this.traitCase_ == 63249;
    }

    public boolean hasLoadReactions() {
        return this.traitCase_ == 63239;
    }

    public boolean hasLoadStickerCollection() {
        return this.traitCase_ == 246;
    }

    public boolean hasLoadTransactions() {
        return this.traitCase_ == 63445;
    }

    public boolean hasLoadTransactionsByIds() {
        return this.traitCase_ == 63649;
    }

    public boolean hasLoadUsers() {
        return this.traitCase_ == 63247;
    }

    public boolean hasMakeUserAdmin() {
        return this.traitCase_ == 2784;
    }

    public boolean hasMessageRead() {
        return this.traitCase_ == 57;
    }

    public boolean hasMessageReceived() {
        return this.traitCase_ == 55;
    }

    public boolean hasMessageRemoveReaction() {
        return this.traitCase_ == 220;
    }

    public boolean hasMessageSetReaction() {
        return this.traitCase_ == 210;
    }

    public boolean hasNewFatSeqUpdate() {
        return this.traitCase_ == 1168;
    }

    public boolean hasNewSeqUpdate() {
        return this.traitCase_ == 45;
    }

    public boolean hasNotifyAboutDeviceInfo() {
        return this.traitCase_ == 229;
    }

    public boolean hasOpenGiftPacket() {
        return this.traitCase_ == 63236;
    }

    public boolean hasPayBill() {
        return this.traitCase_ == 63545;
    }

    public boolean hasPayByWallet() {
        return this.traitCase_ == 62746;
    }

    public boolean hasPayMoneyRequestByWallet() {
        return this.traitCase_ == 62751;
    }

    public boolean hasPaySefte() {
        return this.traitCase_ == 63614;
    }

    public boolean hasPinMessage() {
        return this.traitCase_ == 470;
    }

    public boolean hasProto() {
        return this.traitCase_ == 63639;
    }

    public boolean hasPurchaseMessage() {
        return this.traitCase_ == 63418;
    }

    public boolean hasPurchaseMessageWithCharge() {
        return this.traitCase_ == 63428;
    }

    public boolean hasReactivateApp() {
        return this.traitCase_ == 63591;
    }

    public boolean hasRefer() {
        return this.traitCase_ == 63502;
    }

    public boolean hasRegisterForEarnMoney() {
        return this.traitCase_ == 63438;
    }

    public boolean hasRegisterGooglePush() {
        return this.traitCase_ == 51;
    }

    public boolean hasRemoveAvatar() {
        return this.traitCase_ == 91;
    }

    public boolean hasRemoveCard() {
        return this.traitCase_ == 63557;
    }

    public boolean hasRemoveContact() {
        return this.traitCase_ == 89;
    }

    public boolean hasRemoveDefaultCard() {
        return this.traitCase_ == 63565;
    }

    public boolean hasRemoveDefaultCardNumber() {
        return this.traitCase_ == 62177;
    }

    public boolean hasRemoveDestinationCards() {
        return this.traitCase_ == 63590;
    }

    public boolean hasRemoveGif() {
        return this.traitCase_ == 2859;
    }

    public boolean hasRemoveGroupAvatar() {
        return this.traitCase_ == 101;
    }

    public boolean hasRemoveLoan() {
        return this.traitCase_ == 63658;
    }

    public boolean hasRemovePin() {
        return this.traitCase_ == 471;
    }

    public boolean hasRemoveStickerCollection() {
        return this.traitCase_ == 245;
    }

    public boolean hasRemoveTransaction() {
        return this.traitCase_ == 63646;
    }

    public boolean hasRemoveTransactionTags() {
        return this.traitCase_ == 63450;
    }

    public boolean hasRemoveUserAdmin() {
        return this.traitCase_ == 44576;
    }

    public boolean hasRemoveUserTags() {
        return this.traitCase_ == 63519;
    }

    public boolean hasRenameSavedBill() {
        return this.traitCase_ == 63553;
    }

    public boolean hasResetContacts() {
        return this.traitCase_ == 63661;
    }

    public boolean hasResponseAddDestinationCards() {
        return this.traitCase_ == 63589;
    }

    public boolean hasResponseAddNewCards() {
        return this.traitCase_ == 63556;
    }

    public boolean hasResponseAuth() {
        return this.traitCase_ == 5;
    }

    public boolean hasResponseAuthorizeUser() {
        return this.traitCase_ == 63607;
    }

    public boolean hasResponseBool() {
        return this.traitCase_ == 209;
    }

    public boolean hasResponseBuyCharge() {
        return this.traitCase_ == 63538;
    }

    public boolean hasResponseBuyFastCharge() {
        return this.traitCase_ == 62465;
    }

    public boolean hasResponseBuyInternetBundle() {
        return this.traitCase_ == 63540;
    }

    public boolean hasResponseBuyVoucher() {
        return this.traitCase_ == 63475;
    }

    public boolean hasResponseBuyWheelChance() {
        return this.traitCase_ == 63467;
    }

    public boolean hasResponseCall() {
        return this.traitCase_ == 63581;
    }

    public boolean hasResponseCanSeeMessages() {
        return this.traitCase_ == 725;
    }

    public boolean hasResponseCashoutKifpool() {
        return this.traitCase_ == 63408;
    }

    public boolean hasResponseChangePointToMoney() {
        return this.traitCase_ == 63465;
    }

    public boolean hasResponseCharge() {
        return this.traitCase_ == 63416;
    }

    public boolean hasResponseCheckChargePermission() {
        return this.traitCase_ == 63414;
    }

    public boolean hasResponseCreateGroup() {
        return this.traitCase_ == 216;
    }

    public boolean hasResponseCreateKifpool() {
        return this.traitCase_ == 63405;
    }

    public boolean hasResponseCreateSavedBill() {
        return this.traitCase_ == 63550;
    }

    public boolean hasResponseCryptoTransfer() {
        return this.traitCase_ == 63633;
    }

    public boolean hasResponseDialogsOrder() {
        return this.traitCase_ == 235;
    }

    public boolean hasResponseEditAvatar() {
        return this.traitCase_ == 103;
    }

    public boolean hasResponseEditGroupAvatar() {
        return this.traitCase_ == 115;
    }

    public boolean hasResponseEnrollNewCard() {
        return this.traitCase_ == 63488;
    }

    public boolean hasResponseFetchGroupAdmins() {
        return this.traitCase_ == 730;
    }

    public boolean hasResponseFilterTaggedTransactions() {
        return this.traitCase_ == 63631;
    }

    public boolean hasResponseGetAcquiredVouchers() {
        return this.traitCase_ == 63638;
    }

    public boolean hasResponseGetAdProvider() {
        return this.traitCase_ == 63526;
    }

    public boolean hasResponseGetAuthSessions() {
        return this.traitCase_ == 81;
    }

    public boolean hasResponseGetBamServiceToken() {
        return this.traitCase_ == 62407;
    }

    public boolean hasResponseGetBillHistory() {
        return this.traitCase_ == 63548;
    }

    public boolean hasResponseGetBotWhiteList() {
        return this.traitCase_ == 3856;
    }

    public boolean hasResponseGetCardInfo() {
        return this.traitCase_ == 63490;
    }

    public boolean hasResponseGetCardTransferToken() {
        return this.traitCase_ == 62126;
    }

    public boolean hasResponseGetCards() {
        return this.traitCase_ == 63559;
    }

    public boolean hasResponseGetChannelAds() {
        return this.traitCase_ == 63265;
    }

    public boolean hasResponseGetChannelEarnMoneyInfo() {
        return this.traitCase_ == 63448;
    }

    public boolean hasResponseGetChannelEarnMoneyStatus() {
        return this.traitCase_ == 63437;
    }

    public boolean hasResponseGetChargeAmounts() {
        return this.traitCase_ == 63511;
    }

    public boolean hasResponseGetChargePaymentToken() {
        return this.traitCase_ == 63406;
    }

    public boolean hasResponseGetCitiesOfState() {
        return this.traitCase_ == 63618;
    }

    public boolean hasResponseGetContacts() {
        return this.traitCase_ == 88;
    }

    public boolean hasResponseGetCryptoWallets() {
        return this.traitCase_ == 63635;
    }

    public boolean hasResponseGetDefaultCard() {
        return this.traitCase_ == 63564;
    }

    public boolean hasResponseGetDestinationCardInfo() {
        return this.traitCase_ == 63492;
    }

    public boolean hasResponseGetDestinationCards() {
        return this.traitCase_ == 63587;
    }

    public boolean hasResponseGetDialogAdOrderDetails() {
        return this.traitCase_ == 63569;
    }

    public boolean hasResponseGetDialogAdOrderPaymentToken() {
        return this.traitCase_ == 63572;
    }

    public boolean hasResponseGetGiftPacketPaymentToken() {
        return this.traitCase_ == 63231;
    }

    public boolean hasResponseGetGroupDefaultCardNumber() {
        return this.traitCase_ == 130;
    }

    public boolean hasResponseGetGroupDifference() {
        return this.traitCase_ == 204;
    }

    public boolean hasResponseGetGroupMembersCount() {
        return this.traitCase_ == 63504;
    }

    public boolean hasResponseGetGroupMembersPresence() {
        return this.traitCase_ == 63643;
    }

    public boolean hasResponseGetGroupState() {
        return this.traitCase_ == 23;
    }

    public boolean hasResponseGetInternetBundleList() {
        return this.traitCase_ == 63533;
    }

    public boolean hasResponseGetInternetBundlePaymentToken() {
        return this.traitCase_ == 63531;
    }

    public boolean hasResponseGetJwtToken() {
        return this.traitCase_ == 601;
    }

    public boolean hasResponseGetKifpoolOwner() {
        return this.traitCase_ == 63421;
    }

    public boolean hasResponseGetLinkPreview() {
        return this.traitCase_ == 63498;
    }

    public boolean hasResponseGetLoanInfo() {
        return this.traitCase_ == 63583;
    }

    public boolean hasResponseGetLoansList() {
        return this.traitCase_ == 63585;
    }

    public boolean hasResponseGetMemberPermissions() {
        return this.traitCase_ == 63457;
    }

    public boolean hasResponseGetMessagesRepliesInfo() {
        return this.traitCase_ == 63664;
    }

    public boolean hasResponseGetMoneyRequestDetails() {
        return this.traitCase_ == 62400;
    }

    public boolean hasResponseGetMoneyRequestPaymentList() {
        return this.traitCase_ == 62402;
    }

    public boolean hasResponseGetMoneyRequestPaymentTokenByCard() {
        return this.traitCase_ == 62770;
    }

    public boolean hasResponseGetMyBank() {
        return this.traitCase_ == 63244;
    }

    public boolean hasResponseGetMyGroups() {
        return this.traitCase_ == 43747;
    }

    public boolean hasResponseGetMyKifpools() {
        return this.traitCase_ == 63401;
    }

    public boolean hasResponseGetMySentence() {
        return this.traitCase_ == 63574;
    }

    public boolean hasResponseGetMyWallets() {
        return this.traitCase_ == 62731;
    }

    public boolean hasResponseGetNasimFilePublicUrl() {
        return this.traitCase_ == 3056;
    }

    public boolean hasResponseGetNasimFileUploadResume() {
        return this.traitCase_ == 3055;
    }

    public boolean hasResponseGetNasimFileUploadUrl() {
        return this.traitCase_ == 157;
    }

    public boolean hasResponseGetNasimFileUrl() {
        return this.traitCase_ == 2799;
    }

    public boolean hasResponseGetNasimFileUrls() {
        return this.traitCase_ == 2607;
    }

    public boolean hasResponseGetOtpTokenV2() {
        return this.traitCase_ == 63259;
    }

    public boolean hasResponseGetOtptoken() {
        return this.traitCase_ == 62768;
    }

    public boolean hasResponseGetPacketsStatus() {
        return this.traitCase_ == 63598;
    }

    public boolean hasResponseGetParameters() {
        return this.traitCase_ == 135;
    }

    public boolean hasResponseGetParticipants() {
        return this.traitCase_ == 63513;
    }

    public boolean hasResponseGetPayMoneyRequestToken() {
        return this.traitCase_ == 62128;
    }

    public boolean hasResponseGetPaymentToken() {
        return this.traitCase_ == 62409;
    }

    public boolean hasResponseGetPaymentTokenByCard() {
        return this.traitCase_ == 62748;
    }

    public boolean hasResponseGetPayvandCard() {
        return this.traitCase_ == 62133;
    }

    public boolean hasResponseGetPayvandCardList() {
        return this.traitCase_ == 62131;
    }

    public boolean hasResponseGetPointBalance() {
        return this.traitCase_ == 63435;
    }

    public boolean hasResponseGetPointDetails() {
        return this.traitCase_ == 63459;
    }

    public boolean hasResponseGetPointSummery() {
        return this.traitCase_ == 63452;
    }

    public boolean hasResponseGetPspPaymentToken() {
        return this.traitCase_ == 63486;
    }

    public boolean hasResponseGetPsproxyPaymentToken() {
        return this.traitCase_ == 53259;
    }

    public boolean hasResponseGetPsproxyToken() {
        return this.traitCase_ == 53257;
    }

    public boolean hasResponseGetReactions() {
        return this.traitCase_ == 63255;
    }

    public boolean hasResponseGetRecentCharges() {
        return this.traitCase_ == 62414;
    }

    public boolean hasResponseGetRecentInternetBundleOrders() {
        return this.traitCase_ == 63535;
    }

    public boolean hasResponseGetRecentOrders() {
        return this.traitCase_ == 63508;
    }

    public boolean hasResponseGetRecipients() {
        return this.traitCase_ == 63627;
    }

    public boolean hasResponseGetReferencedEntitites() {
        return this.traitCase_ == 2629;
    }

    public boolean hasResponseGetReferralCode() {
        return this.traitCase_ == 63501;
    }

    public boolean hasResponseGetReferralContacts() {
        return this.traitCase_ == 63602;
    }

    public boolean hasResponseGetReferredCount() {
        return this.traitCase_ == 63478;
    }

    public boolean hasResponseGetReferringUser() {
        return this.traitCase_ == 63461;
    }

    public boolean hasResponseGetRemainToken() {
        return this.traitCase_ == 62138;
    }

    public boolean hasResponseGetSadadPsppaymentToken() {
        return this.traitCase_ == 62181;
    }

    public boolean hasResponseGetSavedBills() {
        return this.traitCase_ == 63552;
    }

    public boolean hasResponseGetScoreBoard() {
        return this.traitCase_ == 63594;
    }

    public boolean hasResponseGetStates() {
        return this.traitCase_ == 63616;
    }

    public boolean hasResponseGetSubTransactions() {
        return this.traitCase_ == 63654;
    }

    public boolean hasResponseGetTicket() {
        return this.traitCase_ == 63261;
    }

    public boolean hasResponseGetTotalPaidAmount() {
        return this.traitCase_ == 63528;
    }

    public boolean hasResponseGetTransactionTags() {
        return this.traitCase_ == 63517;
    }

    public boolean hasResponseGetUserAccounts() {
        return this.traitCase_ == 63444;
    }

    public boolean hasResponseGetUserBank() {
        return this.traitCase_ == 63524;
    }

    public boolean hasResponseGetUserContext() {
        return this.traitCase_ == 146;
    }

    public boolean hasResponseGetUserRefers() {
        return this.traitCase_ == 63600;
    }

    public boolean hasResponseGetUserScore() {
        return this.traitCase_ == 63596;
    }

    public boolean hasResponseGetUserSeftes() {
        return this.traitCase_ == 63621;
    }

    public boolean hasResponseGetUserStatus() {
        return this.traitCase_ == 63442;
    }

    public boolean hasResponseGetUserTags() {
        return this.traitCase_ == 63521;
    }

    public boolean hasResponseGetUserVitrine() {
        return this.traitCase_ == 63257;
    }

    public boolean hasResponseGetUsersDefaultCardNumber() {
        return this.traitCase_ == 63542;
    }

    public boolean hasResponseGetUsersPresence() {
        return this.traitCase_ == 63645;
    }

    public boolean hasResponseGetVouchers() {
        return this.traitCase_ == 63473;
    }

    public boolean hasResponseGetWalletChargeToken() {
        return this.traitCase_ == 62734;
    }

    public boolean hasResponseGetWalletContracts() {
        return this.traitCase_ == 62759;
    }

    public boolean hasResponseGetWalletInvoice() {
        return this.traitCase_ == 62729;
    }

    public boolean hasResponseGetWebviewTrackingNumber() {
        return this.traitCase_ == 63482;
    }

    public boolean hasResponseGetWheel() {
        return this.traitCase_ == 63469;
    }

    public boolean hasResponseImportContacts() {
        return this.traitCase_ == 8;
    }

    public boolean hasResponseInitP12() {
        return this.traitCase_ == 63609;
    }

    public boolean hasResponseInitSefte() {
        return this.traitCase_ == 63611;
    }

    public boolean hasResponseInquiryBill() {
        return this.traitCase_ == 63544;
    }

    public boolean hasResponseInviteUrl() {
        return this.traitCase_ == 178;
    }

    public boolean hasResponseInvoiceKifpool() {
        return this.traitCase_ == 63410;
    }

    public boolean hasResponseJoinGroup() {
        return this.traitCase_ == 181;
    }

    public boolean hasResponseJoinPublicGroup() {
        return this.traitCase_ == 2897;
    }

    public boolean hasResponseLoadArchived() {
        return this.traitCase_ == 2652;
    }

    public boolean hasResponseLoadAvatars() {
        return this.traitCase_ == 2812;
    }

    public boolean hasResponseLoadBlockedUsers() {
        return this.traitCase_ == 2639;
    }

    public boolean hasResponseLoadDialogs() {
        return this.traitCase_ == 105;
    }

    public boolean hasResponseLoadFullGroups() {
        return this.traitCase_ == 2783;
    }

    public boolean hasResponseLoadFullUsers() {
        return this.traitCase_ == 2650;
    }

    public boolean hasResponseLoadGroupAvatars() {
        return this.traitCase_ == 43749;
    }

    public boolean hasResponseLoadGroupedDialogs() {
        return this.traitCase_ == 226;
    }

    public boolean hasResponseLoadGroups() {
        return this.traitCase_ == 63246;
    }

    public boolean hasResponseLoadHistory() {
        return this.traitCase_ == 119;
    }

    public boolean hasResponseLoadLastStates() {
        return this.traitCase_ == 63660;
    }

    public boolean hasResponseLoadLoanHistory() {
        return this.traitCase_ == 63657;
    }

    public boolean hasResponseLoadMembers() {
        return this.traitCase_ == 2787;
    }

    public boolean hasResponseLoadOwnStickers() {
        return this.traitCase_ == 239;
    }

    public boolean hasResponseLoadPeerDialogs() {
        return this.traitCase_ == 63250;
    }

    public boolean hasResponseLoadReactions() {
        return this.traitCase_ == 63240;
    }

    public boolean hasResponseLoadStickerCollection() {
        return this.traitCase_ == 247;
    }

    public boolean hasResponseLoadTransactions() {
        return this.traitCase_ == 63446;
    }

    public boolean hasResponseLoadTransactionsByIds() {
        return this.traitCase_ == 63650;
    }

    public boolean hasResponseLoadUsers() {
        return this.traitCase_ == 63248;
    }

    public boolean hasResponseOpenGiftPacket() {
        return this.traitCase_ == 63237;
    }

    public boolean hasResponsePayBill() {
        return this.traitCase_ == 63546;
    }

    public boolean hasResponsePaySefte() {
        return this.traitCase_ == 63636;
    }

    public boolean hasResponseProto() {
        return this.traitCase_ == 63640;
    }

    public boolean hasResponsePurchaseMessage() {
        return this.traitCase_ == 63419;
    }

    public boolean hasResponsePurchaseMessageWithCharge() {
        return this.traitCase_ == 63429;
    }

    public boolean hasResponseReactionsResponse() {
        return this.traitCase_ == 219;
    }

    public boolean hasResponseReactivateApp() {
        return this.traitCase_ == 63592;
    }

    public boolean hasResponseRefer() {
        return this.traitCase_ == 63503;
    }

    public boolean hasResponseSearchContacts() {
        return this.traitCase_ == 113;
    }

    public boolean hasResponseSearchMedia() {
        return this.traitCase_ == 63263;
    }

    public boolean hasResponseSearchMessages() {
        return this.traitCase_ == 218;
    }

    public boolean hasResponseSearchPeer() {
        return this.traitCase_ == 234;
    }

    public boolean hasResponseSendChangePhoneVerificationCode() {
        return this.traitCase_ == 63505;
    }

    public boolean hasResponseSendDeleteAccountVerificationCode() {
        return this.traitCase_ == 3089;
    }

    public boolean hasResponseSeq() {
        return this.traitCase_ == 72;
    }

    public boolean hasResponseSeqDate() {
        return this.traitCase_ == 102;
    }

    public boolean hasResponseSignSefte() {
        return this.traitCase_ == 63613;
    }

    public boolean hasResponseSpinWheel() {
        return this.traitCase_ == 63471;
    }

    public boolean hasResponseSplitTransaction() {
        return this.traitCase_ == 63648;
    }

    public boolean hasResponseStartPhoneAuth() {
        return this.traitCase_ == 193;
    }

    public boolean hasResponseStickersReponse() {
        return this.traitCase_ == 240;
    }

    public boolean hasResponseTransactionPoint() {
        return this.traitCase_ == 63463;
    }

    public boolean hasResponseTransferMoney() {
        return this.traitCase_ == 63412;
    }

    public boolean hasResponseUpdateClick() {
        return this.traitCase_ == 63623;
    }

    public boolean hasResponseUpdateView() {
        return this.traitCase_ == 63561;
    }

    public boolean hasResponseUpgradeKifpool() {
        return this.traitCase_ == 63403;
    }

    public boolean hasResponseUserHasCred() {
        return this.traitCase_ == 63625;
    }

    public boolean hasResponseValidateMySentence() {
        return this.traitCase_ == 63576;
    }

    public boolean hasResponseVerifyCashOut() {
        return this.traitCase_ == 62763;
    }

    public boolean hasResponseVerifyCashOutKifpool() {
        return this.traitCase_ == 63433;
    }

    public boolean hasResponseVerifyPeer() {
        return this.traitCase_ == 62757;
    }

    public boolean hasResponseVerifyPurchaseMessage() {
        return this.traitCase_ == 63431;
    }

    public boolean hasResponseVerifyQrcode() {
        return this.traitCase_ == 62750;
    }

    public boolean hasResponseVoid() {
        return this.traitCase_ == 50;
    }

    public boolean hasReviveTransaction() {
        return this.traitCase_ == 63655;
    }

    public boolean hasRevokeInviteUrl() {
        return this.traitCase_ == 179;
    }

    public boolean hasSearchContacts() {
        return this.traitCase_ == 112;
    }

    public boolean hasSearchMedia() {
        return this.traitCase_ == 63262;
    }

    public boolean hasSearchMessages() {
        return this.traitCase_ == 217;
    }

    public boolean hasSearchMessagesMore() {
        return this.traitCase_ == 222;
    }

    public boolean hasSearchPeer() {
        return this.traitCase_ == 233;
    }

    public boolean hasSendChangePhoneVerificationCode() {
        return this.traitCase_ == 63454;
    }

    public boolean hasSendDeleteAccountVerificationCode() {
        return this.traitCase_ == 43609;
    }

    public boolean hasSendFeedBack() {
        return this.traitCase_ == 63529;
    }

    public boolean hasSendGiftPacketWithWallet() {
        return this.traitCase_ == 63233;
    }

    public boolean hasSendInlineCallbackData() {
        return this.traitCase_ == 3937;
    }

    public boolean hasSendMessage() {
        return this.traitCase_ == 92;
    }

    public boolean hasSendMultiMediaMessage() {
        return this.traitCase_ == 63662;
    }

    public boolean hasSendMyGiftPacket() {
        return this.traitCase_ == 63577;
    }

    public boolean hasSendReferral() {
        return this.traitCase_ == 63603;
    }

    public boolean hasSendSerajEvent() {
        return this.traitCase_ == 63238;
    }

    public boolean hasSeqUpdate() {
        return this.traitCase_ == 13;
    }

    public boolean hasSeqUpdateTooLong() {
        return this.traitCase_ == 25;
    }

    public boolean hasSetCanSeeMessages() {
        return this.traitCase_ == 724;
    }

    public boolean hasSetDefaultCard() {
        return this.traitCase_ == 63562;
    }

    public boolean hasSetGroupDefaultPermissions() {
        return this.traitCase_ == 63476;
    }

    public boolean hasSetMemberPermissions() {
        return this.traitCase_ == 63455;
    }

    public boolean hasSetOnline() {
        return this.traitCase_ == 29;
    }

    public boolean hasSetRecentOrder() {
        return this.traitCase_ == 63506;
    }

    public boolean hasSetRestriction() {
        return this.traitCase_ == 728;
    }

    public boolean hasSignOut() {
        return this.traitCase_ == 84;
    }

    public boolean hasSignSefte() {
        return this.traitCase_ == 63612;
    }

    public boolean hasSignUp() {
        return this.traitCase_ == 190;
    }

    public boolean hasSpinWheel() {
        return this.traitCase_ == 63470;
    }

    public boolean hasSplitTransaction() {
        return this.traitCase_ == 63647;
    }

    public boolean hasStartCall() {
        return this.traitCase_ == 63578;
    }

    public boolean hasStartPhoneAuth() {
        return this.traitCase_ == 191;
    }

    public boolean hasStopTyping() {
        return this.traitCase_ == 30;
    }

    public boolean hasSubmitDialogAdOrder() {
        return this.traitCase_ == 63567;
    }

    public boolean hasSubscribeFromGroupOnline() {
        return this.traitCase_ == 75;
    }

    public boolean hasSubscribeFromOnline() {
        return this.traitCase_ == 33;
    }

    public boolean hasSubscribeToGroupOnline() {
        return this.traitCase_ == 74;
    }

    public boolean hasSubscribeToOnline() {
        return this.traitCase_ == 32;
    }

    public boolean hasTerminateAllSessions() {
        return this.traitCase_ == 83;
    }

    public boolean hasTerminateSession() {
        return this.traitCase_ == 82;
    }

    public boolean hasTransactionPoint() {
        return this.traitCase_ == 63462;
    }

    public boolean hasTransferMoney() {
        return this.traitCase_ == 63411;
    }

    public boolean hasTransferMoneyByCard() {
        return this.traitCase_ == 63495;
    }

    public boolean hasTransferOwnership() {
        return this.traitCase_ == 2789;
    }

    public boolean hasTyping() {
        return this.traitCase_ == 27;
    }

    public boolean hasUnbindAllMoneyRequestDetails() {
        return this.traitCase_ == 62411;
    }

    public boolean hasUnblockUser() {
        return this.traitCase_ == 2637;
    }

    public boolean hasUnregisterAllPushCredentials() {
        return this.traitCase_ == 63251;
    }

    public boolean hasUnregisterGooglePush() {
        return this.traitCase_ == 2631;
    }

    public boolean hasUpdateClick() {
        return this.traitCase_ == 63622;
    }

    public boolean hasUpdateGroupStatus() {
        return this.traitCase_ == 63439;
    }

    public boolean hasUpdateMessage() {
        return this.traitCase_ == 2658;
    }

    public boolean hasUpdateView() {
        return this.traitCase_ == 63560;
    }

    public boolean hasUpgradeKifpool() {
        return this.traitCase_ == 63402;
    }

    public boolean hasUserHasCred() {
        return this.traitCase_ == 63624;
    }

    public boolean hasValidateCode() {
        return this.traitCase_ == 189;
    }

    public boolean hasValidateMySentence() {
        return this.traitCase_ == 63575;
    }

    public boolean hasVerifyCashOut() {
        return this.traitCase_ == 62762;
    }

    public boolean hasVerifyCashOutKifpool() {
        return this.traitCase_ == 63432;
    }

    public boolean hasVerifyPeer() {
        return this.traitCase_ == 62756;
    }

    public boolean hasVerifyPurchaseMessage() {
        return this.traitCase_ == 63430;
    }

    public boolean hasVerifyQrcode() {
        return this.traitCase_ == 62749;
    }

    public boolean hasWeakFatUpdate() {
        return this.traitCase_ == 2673;
    }

    public boolean hasWeakUpdate() {
        return this.traitCase_ == 26;
    }

    public static a newBuilder(SetRpcStruct$ComposedRpc setRpcStruct$ComposedRpc) {
        return (a) DEFAULT_INSTANCE.createBuilder(setRpcStruct$ComposedRpc);
    }

    public static SetRpcStruct$ComposedRpc parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SetRpcStruct$ComposedRpc) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SetRpcStruct$ComposedRpc parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SetRpcStruct$ComposedRpc) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SetRpcStruct$ComposedRpc parseFrom(AbstractC2383g abstractC2383g) {
        return (SetRpcStruct$ComposedRpc) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SetRpcStruct$ComposedRpc parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SetRpcStruct$ComposedRpc) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SetRpcStruct$ComposedRpc parseFrom(byte[] bArr) {
        return (SetRpcStruct$ComposedRpc) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SetRpcStruct$ComposedRpc parseFrom(byte[] bArr, C2394s c2394s) {
        return (SetRpcStruct$ComposedRpc) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SetRpcStruct$ComposedRpc parseFrom(InputStream inputStream) {
        return (SetRpcStruct$ComposedRpc) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SetRpcStruct$ComposedRpc parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SetRpcStruct$ComposedRpc) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SetRpcStruct$ComposedRpc parseFrom(AbstractC2384h abstractC2384h) {
        return (SetRpcStruct$ComposedRpc) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SetRpcStruct$ComposedRpc parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SetRpcStruct$ComposedRpc) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
