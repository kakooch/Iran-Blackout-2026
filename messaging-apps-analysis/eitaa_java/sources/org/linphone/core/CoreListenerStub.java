package org.linphone.core;

import org.linphone.core.Call;
import org.linphone.core.ChatRoom;
import org.linphone.core.Conference;
import org.linphone.core.Core;

/* loaded from: classes3.dex */
public class CoreListenerStub implements CoreListener {
    @Override // org.linphone.core.CoreListener
    public void onAccountRegistrationStateChanged(Core core, Account account, RegistrationState registrationState, String str) {
    }

    @Override // org.linphone.core.CoreListener
    public void onAudioDeviceChanged(Core core, AudioDevice audioDevice) {
    }

    @Override // org.linphone.core.CoreListener
    public void onAudioDevicesListUpdated(Core core) {
    }

    @Override // org.linphone.core.CoreListener
    public void onAuthenticationRequested(Core core, AuthInfo authInfo, AuthMethod authMethod) {
    }

    @Override // org.linphone.core.CoreListener
    public void onBuddyInfoUpdated(Core core, Friend friend) {
    }

    @Override // org.linphone.core.CoreListener
    public void onCallCreated(Core core, Call call) {
    }

    @Override // org.linphone.core.CoreListener
    public void onCallEncryptionChanged(Core core, Call call, boolean z, String str) {
    }

    @Override // org.linphone.core.CoreListener
    public void onCallGoclearAckSent(Core core, Call call) {
    }

    @Override // org.linphone.core.CoreListener
    public void onCallIdUpdated(Core core, String str, String str2) {
    }

    @Override // org.linphone.core.CoreListener
    public void onCallLogUpdated(Core core, CallLog callLog) {
    }

    @Override // org.linphone.core.CoreListener
    public void onCallReceiveMasterKeyChanged(Core core, Call call, String str) {
    }

    @Override // org.linphone.core.CoreListener
    public void onCallSendMasterKeyChanged(Core core, Call call, String str) {
    }

    @Override // org.linphone.core.CoreListener
    public void onCallStateChanged(Core core, Call call, Call.State state, String str) {
    }

    @Override // org.linphone.core.CoreListener
    public void onCallStatsUpdated(Core core, Call call, CallStats callStats) {
    }

    @Override // org.linphone.core.CoreListener
    public void onChatRoomEphemeralMessageDeleted(Core core, ChatRoom chatRoom) {
    }

    @Override // org.linphone.core.CoreListener
    public void onChatRoomRead(Core core, ChatRoom chatRoom) {
    }

    @Override // org.linphone.core.CoreListener
    public void onChatRoomSessionStateChanged(Core core, ChatRoom chatRoom, Call.State state, String str) {
    }

    @Override // org.linphone.core.CoreListener
    public void onChatRoomStateChanged(Core core, ChatRoom chatRoom, ChatRoom.State state) {
    }

    @Override // org.linphone.core.CoreListener
    public void onChatRoomSubjectChanged(Core core, ChatRoom chatRoom) {
    }

    @Override // org.linphone.core.CoreListener
    public void onConferenceInfoReceived(Core core, ConferenceInfo conferenceInfo) {
    }

    @Override // org.linphone.core.CoreListener
    public void onConferenceStateChanged(Core core, Conference conference, Conference.State state) {
    }

    @Override // org.linphone.core.CoreListener
    public void onConfiguringStatus(Core core, ConfiguringState configuringState, String str) {
    }

    @Override // org.linphone.core.CoreListener
    public void onDtmfReceived(Core core, Call call, int i) {
    }

    @Override // org.linphone.core.CoreListener
    public void onEcCalibrationAudioInit(Core core) {
    }

    @Override // org.linphone.core.CoreListener
    public void onEcCalibrationAudioUninit(Core core) {
    }

    @Override // org.linphone.core.CoreListener
    public void onEcCalibrationResult(Core core, EcCalibratorStatus ecCalibratorStatus, int i) {
    }

    @Override // org.linphone.core.CoreListener
    public void onFirstCallStarted(Core core) {
    }

    @Override // org.linphone.core.CoreListener
    public void onFriendListCreated(Core core, FriendList friendList) {
    }

    @Override // org.linphone.core.CoreListener
    public void onFriendListRemoved(Core core, FriendList friendList) {
    }

    @Override // org.linphone.core.CoreListener
    public void onGlobalStateChanged(Core core, GlobalState globalState, String str) {
    }

    @Override // org.linphone.core.CoreListener
    public void onImeeUserRegistration(Core core, boolean z, String str, String str2) {
    }

    @Override // org.linphone.core.CoreListener
    public void onInfoReceived(Core core, Call call, InfoMessage infoMessage) {
    }

    @Override // org.linphone.core.CoreListener
    public void onIsComposingReceived(Core core, ChatRoom chatRoom) {
    }

    @Override // org.linphone.core.CoreListener
    public void onLastCallEnded(Core core) {
    }

    @Override // org.linphone.core.CoreListener
    public void onLogCollectionUploadProgressIndication(Core core, int i, int i2) {
    }

    @Override // org.linphone.core.CoreListener
    public void onLogCollectionUploadStateChanged(Core core, Core.LogCollectionUploadState logCollectionUploadState, String str) {
    }

    @Override // org.linphone.core.CoreListener
    public void onMessageReceived(Core core, ChatRoom chatRoom, ChatMessage chatMessage) {
    }

    @Override // org.linphone.core.CoreListener
    public void onMessageReceivedUnableDecrypt(Core core, ChatRoom chatRoom, ChatMessage chatMessage) {
    }

    @Override // org.linphone.core.CoreListener
    public void onMessageSent(Core core, ChatRoom chatRoom, ChatMessage chatMessage) {
    }

    @Override // org.linphone.core.CoreListener
    public void onMessagesReceived(Core core, ChatRoom chatRoom, ChatMessage[] chatMessageArr) {
    }

    @Override // org.linphone.core.CoreListener
    public void onNetworkReachable(Core core, boolean z) {
    }

    @Override // org.linphone.core.CoreListener
    public void onNewSubscriptionRequested(Core core, Friend friend, String str) {
    }

    @Override // org.linphone.core.CoreListener
    public void onNotifyPresenceReceived(Core core, Friend friend) {
    }

    @Override // org.linphone.core.CoreListener
    public void onNotifyPresenceReceivedForUriOrTel(Core core, Friend friend, String str, PresenceModel presenceModel) {
    }

    @Override // org.linphone.core.CoreListener
    public void onNotifyReceived(Core core, Event event, String str, Content content) {
    }

    @Override // org.linphone.core.CoreListener
    public void onNotifySent(Core core, Event event, Content content) {
    }

    @Override // org.linphone.core.CoreListener
    public void onPreviewDisplayErrorOccurred(Core core, int i) {
    }

    @Override // org.linphone.core.CoreListener
    public void onPublishStateChanged(Core core, Event event, PublishState publishState) {
    }

    @Override // org.linphone.core.CoreListener
    public void onPushNotificationReceived(Core core, String str) {
    }

    @Override // org.linphone.core.CoreListener
    public void onQrcodeFound(Core core, String str) {
    }

    @Override // org.linphone.core.CoreListener
    public void onReferReceived(Core core, String str) {
    }

    @Override // org.linphone.core.CoreListener
    public void onRegistrationStateChanged(Core core, ProxyConfig proxyConfig, RegistrationState registrationState, String str) {
    }

    @Override // org.linphone.core.CoreListener
    public void onSubscribeReceived(Core core, Event event, String str, Content content) {
    }

    @Override // org.linphone.core.CoreListener
    public void onSubscriptionStateChanged(Core core, Event event, SubscriptionState subscriptionState) {
    }

    @Override // org.linphone.core.CoreListener
    public void onTransferStateChanged(Core core, Call call, Call.State state) {
    }

    @Override // org.linphone.core.CoreListener
    public void onVersionUpdateCheckResultReceived(Core core, VersionUpdateCheckResult versionUpdateCheckResult, String str, String str2) {
    }
}
