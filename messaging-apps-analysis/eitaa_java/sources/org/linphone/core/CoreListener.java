package org.linphone.core;

import org.linphone.core.Call;
import org.linphone.core.ChatRoom;
import org.linphone.core.Conference;
import org.linphone.core.Core;

/* loaded from: classes3.dex */
public interface CoreListener {
    void onAccountRegistrationStateChanged(Core core, Account account, RegistrationState registrationState, String str);

    void onAudioDeviceChanged(Core core, AudioDevice audioDevice);

    void onAudioDevicesListUpdated(Core core);

    void onAuthenticationRequested(Core core, AuthInfo authInfo, AuthMethod authMethod);

    void onBuddyInfoUpdated(Core core, Friend friend);

    void onCallCreated(Core core, Call call);

    void onCallEncryptionChanged(Core core, Call call, boolean z, String str);

    void onCallGoclearAckSent(Core core, Call call);

    void onCallIdUpdated(Core core, String str, String str2);

    void onCallLogUpdated(Core core, CallLog callLog);

    void onCallReceiveMasterKeyChanged(Core core, Call call, String str);

    void onCallSendMasterKeyChanged(Core core, Call call, String str);

    void onCallStateChanged(Core core, Call call, Call.State state, String str);

    void onCallStatsUpdated(Core core, Call call, CallStats callStats);

    void onChatRoomEphemeralMessageDeleted(Core core, ChatRoom chatRoom);

    void onChatRoomRead(Core core, ChatRoom chatRoom);

    void onChatRoomSessionStateChanged(Core core, ChatRoom chatRoom, Call.State state, String str);

    void onChatRoomStateChanged(Core core, ChatRoom chatRoom, ChatRoom.State state);

    void onChatRoomSubjectChanged(Core core, ChatRoom chatRoom);

    void onConferenceInfoReceived(Core core, ConferenceInfo conferenceInfo);

    void onConferenceStateChanged(Core core, Conference conference, Conference.State state);

    void onConfiguringStatus(Core core, ConfiguringState configuringState, String str);

    void onDtmfReceived(Core core, Call call, int i);

    void onEcCalibrationAudioInit(Core core);

    void onEcCalibrationAudioUninit(Core core);

    void onEcCalibrationResult(Core core, EcCalibratorStatus ecCalibratorStatus, int i);

    void onFirstCallStarted(Core core);

    void onFriendListCreated(Core core, FriendList friendList);

    void onFriendListRemoved(Core core, FriendList friendList);

    void onGlobalStateChanged(Core core, GlobalState globalState, String str);

    void onImeeUserRegistration(Core core, boolean z, String str, String str2);

    void onInfoReceived(Core core, Call call, InfoMessage infoMessage);

    void onIsComposingReceived(Core core, ChatRoom chatRoom);

    void onLastCallEnded(Core core);

    void onLogCollectionUploadProgressIndication(Core core, int i, int i2);

    void onLogCollectionUploadStateChanged(Core core, Core.LogCollectionUploadState logCollectionUploadState, String str);

    void onMessageReceived(Core core, ChatRoom chatRoom, ChatMessage chatMessage);

    void onMessageReceivedUnableDecrypt(Core core, ChatRoom chatRoom, ChatMessage chatMessage);

    void onMessageSent(Core core, ChatRoom chatRoom, ChatMessage chatMessage);

    void onMessagesReceived(Core core, ChatRoom chatRoom, ChatMessage[] chatMessageArr);

    void onNetworkReachable(Core core, boolean z);

    void onNewSubscriptionRequested(Core core, Friend friend, String str);

    void onNotifyPresenceReceived(Core core, Friend friend);

    void onNotifyPresenceReceivedForUriOrTel(Core core, Friend friend, String str, PresenceModel presenceModel);

    void onNotifyReceived(Core core, Event event, String str, Content content);

    void onNotifySent(Core core, Event event, Content content);

    void onPreviewDisplayErrorOccurred(Core core, int i);

    void onPublishStateChanged(Core core, Event event, PublishState publishState);

    void onPushNotificationReceived(Core core, String str);

    void onQrcodeFound(Core core, String str);

    void onReferReceived(Core core, String str);

    void onRegistrationStateChanged(Core core, ProxyConfig proxyConfig, RegistrationState registrationState, String str);

    void onSubscribeReceived(Core core, Event event, String str, Content content);

    void onSubscriptionStateChanged(Core core, Event event, SubscriptionState subscriptionState);

    void onTransferStateChanged(Core core, Call call, Call.State state);

    void onVersionUpdateCheckResultReceived(Core core, VersionUpdateCheckResult versionUpdateCheckResult, String str, String str2);
}
