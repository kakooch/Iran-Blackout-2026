package org.linphone.core;

import org.linphone.core.Call;
import org.linphone.core.PresenceActivity;

/* loaded from: classes3.dex */
public interface Core {
    void activateAudioSession(boolean z);

    int addAccount(Account account);

    int addAllToConference();

    void addAuthInfo(AuthInfo authInfo);

    void addContentTypeSupport(String str);

    void addFriendList(FriendList friendList);

    void addLdap(Ldap ldap);

    void addLinphoneSpec(String str);

    void addListener(CoreListener coreListener);

    int addProxyConfig(ProxyConfig proxyConfig);

    void addSupportedTag(String str);

    int addToConference(Call call);

    @Deprecated
    void audioRouteChanged();

    ChatRoomEphemeralMode chatRoomGetDefaultEphemeralMode();

    void chatRoomSetDefaultEphemeralMode(ChatRoomEphemeralMode chatRoomEphemeralMode);

    void checkForUpdate(String str);

    void clearAccounts();

    void clearAllAuthInfo();

    void clearCallLogs();

    void clearLdaps();

    void clearProxyConfig();

    String compressLogCollection();

    int configSync();

    void configureAudioSession();

    Account createAccount(AccountParams accountParams);

    AccountCreator createAccountCreator(String str);

    AccountParams createAccountParams();

    Address createAddress(String str);

    CallLog createCallLog(Address address, Address address2, Call.Dir dir, int i, long j, long j2, Call.Status status, boolean z, float f);

    CallParams createCallParams(Call call);

    @Deprecated
    ChatRoom createChatRoom(String str, Address[] addressArr);

    @Deprecated
    ChatRoom createChatRoom(Address address);

    @Deprecated
    ChatRoom createChatRoom(ChatRoomParams chatRoomParams, String str, Address[] addressArr);

    @Deprecated
    ChatRoom createChatRoom(ChatRoomParams chatRoomParams, Address address, String str, Address[] addressArr);

    @Deprecated
    ChatRoom createChatRoom(ChatRoomParams chatRoomParams, Address address, Address address2);

    ChatRoom createChatRoom(ChatRoomParams chatRoomParams, Address address, Address[] addressArr);

    @Deprecated
    ChatRoom createClientGroupChatRoom(String str, boolean z);

    @Deprecated
    ChatRoom createClientGroupChatRoom(String str, boolean z, boolean z2);

    ConferenceParams createConferenceParams(Conference conference);

    ConferenceScheduler createConferenceScheduler();

    Conference createConferenceWithParams(ConferenceParams conferenceParams);

    Config createConfig(String str);

    Content createContent();

    ChatRoomParams createDefaultChatRoomParams();

    Friend createFriend();

    FriendList createFriendList();

    Friend createFriendWithAddress(String str);

    InfoMessage createInfoMessage();

    Ldap createLdap();

    LdapParams createLdapParams();

    Ldap createLdapWithParams(LdapParams ldapParams);

    Player createLocalPlayer(String str, String str2, Object obj);

    MagicSearch createMagicSearch();

    NatPolicy createNatPolicy();

    Object createNativePreviewWindowId();

    Object createNativeVideoWindowId();

    Event createNotify(Address address, String str);

    Event createOneShotPublish(Address address, String str);

    PresenceActivity createPresenceActivity(PresenceActivity.Type type, String str);

    PresenceModel createPresenceModel();

    PresenceModel createPresenceModelWithActivity(PresenceActivity.Type type, String str);

    PresenceModel createPresenceModelWithActivityAndNote(PresenceActivity.Type type, String str, String str2, String str3);

    PresenceNote createPresenceNote(String str, String str2);

    PresencePerson createPresencePerson(String str);

    PresenceService createPresenceService(String str, PresenceBasicStatus presenceBasicStatus, String str2);

    Address createPrimaryContactParsed();

    ProxyConfig createProxyConfig();

    Event createPublish(Address address, String str, int i);

    Recorder createRecorder(RecorderParams recorderParams);

    RecorderParams createRecorderParams();

    Event createSubscribe(Address address, String str, int i);

    Event createSubscribe(Address address, ProxyConfig proxyConfig, String str, int i);

    XmlRpcSession createXmlRpcSession(String str);

    void deleteChatRoom(ChatRoom chatRoom);

    void deleteConferenceInformation(ConferenceInfo conferenceInfo);

    void didRegisterForRemotePush(Object obj);

    void didRegisterForRemotePushWithStringifiedToken(String str);

    void disableChat(Reason reason);

    void enableChat();

    @Deprecated
    void enableLime(LimeState limeState);

    void enableLogCollection(LogCollectionState logCollectionState);

    @Deprecated
    void ensureRegistered();

    void enterBackground();

    @Deprecated
    int enterConference();

    void enterForeground();

    boolean fileFormatSupported(String str);

    AuthInfo findAuthInfo(String str, String str2, String str3);

    @Deprecated
    Call findCallFromUri(String str);

    CallLog findCallLog(String str, int i);

    CallLog findCallLogFromCallId(String str);

    @Deprecated
    ChatRoom findChatRoom(Address address, Address address2);

    ConferenceInfo findConferenceInformationFromUri(Address address);

    Address[] findContactsByChar(String str, boolean z);

    Friend findFriend(Address address);

    Friend findFriendByPhoneNumber(String str);

    Friend[] findFriends(Address address);

    @Deprecated
    ChatRoom findOneToOneChatRoom(Address address, Address address2, boolean z);

    Account getAccountByIdkey(String str);

    AccountCreatorBackend getAccountCreatorBackend();

    String getAccountCreatorUrl();

    Account[] getAccountList();

    String getAdaptiveRateAlgorithm();

    AudioDevice[] getAudioDevices();

    int getAudioDscp();

    int getAudioJittcomp();

    String getAudioMulticastAddr();

    int getAudioMulticastTtl();

    PayloadType[] getAudioPayloadTypes();

    int getAudioPort();

    Range getAudioPortsRange();

    AuthInfo[] getAuthInfoList();

    int getAutoIterateBackgroundSchedule();

    int getAutoIterateForegroundSchedule();

    AVPFMode getAvpfMode();

    int getAvpfRrInterval();

    Call getCallByCallid(String str);

    @Deprecated
    Call getCallByRemoteAddress(String str);

    Call getCallByRemoteAddress2(Address address);

    CallLog[] getCallHistory(Address address, Address address2);

    @Deprecated
    CallLog[] getCallHistoryForAddress(Address address);

    CallLog[] getCallLogs();

    @Deprecated
    String getCallLogsDatabasePath();

    Call[] getCalls();

    int getCallsNb();

    int getCameraSensorRotation();

    String getCaptureDevice();

    boolean getChatMessagesAggregationEnabled();

    @Deprecated
    ChatRoom getChatRoom(Address address);

    @Deprecated
    ChatRoom getChatRoom(Address address, Address address2);

    @Deprecated
    ChatRoom getChatRoomFromUri(String str);

    ChatRoom[] getChatRooms();

    Conference getConference();

    ConferenceInfo[] getConferenceInformationList();

    ConferenceInfo[] getConferenceInformationListAfterTime(long j);

    float getConferenceLocalInputVolume();

    ConferenceParticipantListType getConferenceParticipantListType();

    @Deprecated
    int getConferenceSize();

    Config getConfig();

    ConsolidatedPresence getConsolidatedPresence();

    Call getCurrentCall();

    Address getCurrentCallRemoteAddress();

    VideoDefinition getCurrentPreviewVideoDefinition();

    Account getDefaultAccount();

    ConferenceLayout getDefaultConferenceLayout();

    long getDefaultEphemeralLifetime();

    FriendList getDefaultFriendList();

    AudioDevice getDefaultInputAudioDevice();

    AudioDevice getDefaultOutputAudioDevice();

    ProxyConfig getDefaultProxyConfig();

    String getDefaultVideoDisplayFilter();

    int getDelayedTimeout();

    int getDeviceRotation();

    DigestAuthenticationPolicy getDigestAuthenticationPolicy();

    boolean getDisableRecordOnMute();

    boolean getDnsSetByApp();

    int getDownloadBandwidth();

    int getDownloadPtime();

    int getEchoCancellationCalibration();

    String getEchoCancellerFilterName();

    AudioDevice[] getExtendedAudioDevices();

    String getFileTransferServer();

    Friend getFriendByRefKey(String str);

    FriendList getFriendListByName(String str);

    String getFriendsDatabasePath();

    FriendList[] getFriendsLists();

    ConferenceInfo[] getFutureConferenceInformationList();

    GlobalState getGlobalState();

    boolean getGuessHostname();

    String getHttpProxyHost();

    int getHttpProxyPort();

    String getIdentity();

    ImNotifPolicy getImNotifPolicy();

    int getInCallTimeout();

    int getIncTimeout();

    AudioDevice getInputAudioDevice();

    CallLog getLastOutgoingCallLog();

    Ldap[] getLdapList();

    @Deprecated
    String getLimeX3DhServerUrl();

    String[] getLinphoneSpecsList();

    int getLogCollectionMaxFileSize();

    String getLogCollectionPath();

    String getLogCollectionPrefix();

    String getLogCollectionUploadServerUrl();

    int getMaxCalls();

    int getMaxSizeForAutoDownloadIncomingFiles();

    String getMediaDevice();

    MediaEncryption getMediaEncryption();

    MediaResourceMode getMediaResourceMode();

    org.linphone.mediastream.Factory getMediastreamerFactory();

    float getMicGainDb();

    int getMissedCallsCount();

    int getMtu();

    @Deprecated
    String getNatAddress();

    NatPolicy getNatPolicy();

    long getNativePointer();

    Object getNativePreviewWindowId();

    Object getNativeVideoWindowId();

    int getNortpTimeout();

    AudioDevice getOutputAudioDevice();

    PayloadType getPayloadType(String str, int i, int i2);

    String getPlayFile();

    String getPlaybackDevice();

    float getPlaybackGainDb();

    boolean getPostQuantumAvailable();

    float getPreferredFramerate();

    VideoDefinition getPreferredVideoDefinition();

    PresenceModel getPresenceModel();

    VideoDefinition getPreviewVideoDefinition();

    String getPrimaryContact();

    @Deprecated
    Address getPrimaryContactParsed();

    String getProvisioningUri();

    ProxyConfig getProxyConfigByIdkey(String str);

    ProxyConfig[] getProxyConfigList();

    int getPushIncomingCallTimeout();

    PushNotificationConfig getPushNotificationConfig();

    String getRecordFile();

    String getRemoteRingbackTone();

    String getRing();

    boolean getRingDuringIncomingEarlyMedia();

    String getRingback();

    String getRingerDevice();

    String getRootCa();

    int getSessionExpiresMinValue();

    SessionExpiresRefresher getSessionExpiresRefresherValue();

    int getSessionExpiresValue();

    int getSipDscp();

    int getSipTransportTimeout();

    @Deprecated
    String[] getSoundDevicesList();

    String getSrtpCryptoSuites();

    String getStaticPicture();

    float getStaticPictureFps();

    String getStunServer();

    String[] getSupportedFileFormatsList();

    SupportLevel getTag100RelSupportLevel();

    PayloadType[] getTextPayloadTypes();

    int getTextPort();

    Range getTextPortsRange();

    String getTlsCert();

    String getTlsCertPath();

    String getTlsKey();

    String getTlsKeyPath();

    Transports getTransports();

    Transports getTransportsUsed();

    Tunnel getTunnel();

    int getUnreadChatMessageCount();

    int getUnreadChatMessageCountFromActiveLocals();

    int getUnreadChatMessageCountFromLocal(Address address);

    int getUploadBandwidth();

    int getUploadPtime();

    String getUpnpExternalIpaddress();

    UpnpState getUpnpState();

    boolean getUseFiles();

    boolean getUseInfoForDtmf();

    boolean getUseRfc2833ForDtmf();

    String getUserAgent();

    String getUserCertificatesPath();

    Object getUserData();

    String getVersion();

    VideoActivationPolicy getVideoActivationPolicy();

    String getVideoDevice();

    String[] getVideoDevicesList();

    String getVideoDisplayFilter();

    int getVideoDscp();

    int getVideoJittcomp();

    String getVideoMulticastAddr();

    int getVideoMulticastTtl();

    PayloadType[] getVideoPayloadTypes();

    int getVideoPort();

    Range getVideoPortsRange();

    String getVideoPreset();

    ZrtpKeyAgreement[] getZrtpAvailableKeyAgreementList();

    ZrtpKeyAgreement[] getZrtpKeyAgreementList();

    String getZrtpSecretsFile();

    ZrtpPeerStatus getZrtpStatus(String str);

    boolean hasBuiltinEchoCanceller();

    boolean hasCrappyOpengl();

    boolean inCall();

    @Deprecated
    Address interpretUrl(String str);

    Address interpretUrl(String str, boolean z);

    Call invite(String str);

    Call inviteAddress(Address address);

    Call inviteAddressWithParams(Address address, CallParams callParams);

    Call inviteAddressWithParams(Address address, CallParams callParams, String str, Content content);

    Call inviteWithParams(String str, CallParams callParams);

    boolean isAdaptiveRateControlEnabled();

    boolean isAudioAdaptiveJittcompEnabled();

    boolean isAudioMulticastEnabled();

    boolean isAutoDownloadIcalendarsEnabled();

    boolean isAutoDownloadVoiceRecordingsEnabled();

    boolean isAutoIterateEnabled();

    boolean isAutoSendRingingEnabled();

    boolean isAutomaticHttpProxyDetectionEnabled();

    boolean isCallToneIndicationsEnabled();

    boolean isCallkitEnabled();

    boolean isCapabilityNegociationEnabled();

    boolean isCapabilityNegotiationReinviteEnabled();

    boolean isChatEnabled();

    boolean isConferenceIcsInMessageBodyEnabled();

    boolean isConferenceServerEnabled();

    boolean isContentTypeSupported(String str);

    boolean isDnsSearchEnabled();

    boolean isDnsSrvEnabled();

    boolean isEchoCancellationEnabled();

    boolean isEchoCancellerCalibrationRequired();

    boolean isEchoLimiterEnabled();

    boolean isForcedIceRelayEnabled();

    boolean isFriendListSubscriptionEnabled();

    boolean isGenericComfortNoiseEnabled();

    boolean isInBackground();

    @Deprecated
    boolean isInConference();

    boolean isIncomingInvitePending();

    boolean isIpv6Enabled();

    boolean isKeepAliveEnabled();

    boolean isLimeX3DhEnabled();

    boolean isLocalPermissionEnabled();

    boolean isMediaEncryptionMandatory();

    boolean isMediaEncryptionSupported(MediaEncryption mediaEncryption);

    boolean isMediaFilterSupported(String str);

    boolean isMicEnabled();

    boolean isNativeRingingEnabled();

    boolean isNetworkReachable();

    boolean isPushNotificationAvailable();

    boolean isPushNotificationEnabled();

    boolean isQrcodeVideoPreviewEnabled();

    boolean isRealtimeTextEnabled();

    boolean isRecordAwareEnabled();

    boolean isRetransmissionOnNackEnabled();

    boolean isRtpBundleEnabled();

    boolean isSdp200AckEnabled();

    boolean isSelfViewEnabled();

    boolean isSenderNameHiddenInForwardMessage();

    boolean isSessionExpiresEnabled();

    boolean isTcapLinesMergingEnabled();

    boolean isVerifyServerCertificates();

    boolean isVerifyServerCn();

    boolean isVibrationOnIncomingCallEnabled();

    boolean isVideoAdaptiveJittcompEnabled();

    boolean isVideoCaptureEnabled();

    boolean isVideoDisplayEnabled();

    boolean isVideoEnabled();

    boolean isVideoMulticastEnabled();

    boolean isVideoPreviewEnabled();

    boolean isWifiOnlyEnabled();

    boolean isZeroRtpPortForStreamInactiveEnabled();

    boolean isZrtpGoClearEnabled();

    void iterate();

    boolean ldapAvailable();

    @Deprecated
    int leaveConference();

    @Deprecated
    boolean limeAvailable();

    @Deprecated
    LimeState limeEnabled();

    boolean limeX3DhAvailable();

    void loadConfigFromXml(String str);

    LogCollectionState logCollectionEnabled();

    boolean mediaEncryptionSupported(MediaEncryption mediaEncryption);

    void migrateLogsFromRcToDb();

    int migrateToMultiTransport();

    void notifyAllFriends(PresenceModel presenceModel);

    void notifyNotifyPresenceReceived(Friend friend);

    void notifyNotifyPresenceReceivedForUriOrTel(Friend friend, String str, PresenceModel presenceModel);

    int pauseAllCalls();

    void playDtmf(char c, int i);

    int playLocal(String str);

    int preemptSoundResources();

    void previewOglRender();

    void processPushNotification(String str);

    Event publish(Address address, String str, int i, Content content);

    int realtimeTextGetKeepaliveInterval();

    void realtimeTextSetKeepaliveInterval(int i);

    void refreshRegisters();

    void rejectSubscriber(Friend friend);

    void reloadMsPlugins(String str);

    void reloadSoundDevices();

    void reloadVideoDevices();

    void removeAccount(Account account);

    void removeAuthInfo(AuthInfo authInfo);

    void removeCallLog(CallLog callLog);

    void removeContentTypeSupport(String str);

    void removeFriendList(FriendList friendList);

    int removeFromConference(Call call);

    void removeLdap(Ldap ldap);

    void removeLinphoneSpec(String str);

    void removeListener(CoreListener coreListener);

    void removeProxyConfig(ProxyConfig proxyConfig);

    void removeSupportedTag(String str);

    void resetEchoCancellationCalibration();

    void resetLogCollection();

    void resetMissedCallsCount();

    ChatRoom searchChatRoom(ChatRoomParams chatRoomParams, Address address, Address address2, Address[] addressArr);

    Conference searchConference(Address address);

    Conference searchConference(ConferenceParams conferenceParams, Address address, Address address2, Address[] addressArr);

    void serializeLogs();

    void setAccountCreatorBackend(AccountCreatorBackend accountCreatorBackend);

    void setAccountCreatorUrl(String str);

    void setAdaptiveRateAlgorithm(String str);

    void setAdaptiveRateControlEnabled(boolean z);

    void setAudioAdaptiveJittcompEnabled(boolean z);

    void setAudioDscp(int i);

    void setAudioJittcomp(int i);

    int setAudioMulticastAddr(String str);

    void setAudioMulticastEnabled(boolean z);

    int setAudioMulticastTtl(int i);

    void setAudioPayloadTypes(PayloadType[] payloadTypeArr);

    void setAudioPort(int i);

    void setAudioPortRange(int i, int i2);

    void setAutoDownloadIcalendarsEnabled(boolean z);

    void setAutoDownloadVoiceRecordingsEnabled(boolean z);

    void setAutoIterateBackgroundSchedule(int i);

    void setAutoIterateEnabled(boolean z);

    void setAutoIterateForegroundSchedule(int i);

    void setAutoSendRingingEnabled(boolean z);

    void setAutomaticHttpProxyDetectionEnabled(boolean z);

    void setAvpfMode(AVPFMode aVPFMode);

    void setAvpfRrInterval(int i);

    @Deprecated
    void setCallLogsDatabasePath(String str);

    void setCallToneIndicationsEnabled(boolean z);

    void setCallkitEnabled(boolean z);

    void setCapabilityNegociationEnabled(boolean z);

    void setCapabilityNegotiationReinviteEnabled(boolean z);

    int setCaptureDevice(String str);

    void setChatMessagesAggregationEnabled(boolean z);

    void setConferenceIcsInMessageBodyEnabled(boolean z);

    void setConferenceParticipantListType(ConferenceParticipantListType conferenceParticipantListType);

    void setConferenceServerEnabled(boolean z);

    void setConsolidatedPresence(ConsolidatedPresence consolidatedPresence);

    void setDefaultAccount(Account account);

    void setDefaultConferenceLayout(ConferenceLayout conferenceLayout);

    void setDefaultEphemeralLifetime(long j);

    void setDefaultInputAudioDevice(AudioDevice audioDevice);

    void setDefaultOutputAudioDevice(AudioDevice audioDevice);

    void setDefaultProxyConfig(ProxyConfig proxyConfig);

    void setDelayedTimeout(int i);

    void setDeviceRotation(int i);

    void setDigestAuthenticationPolicy(DigestAuthenticationPolicy digestAuthenticationPolicy);

    void setDisableRecordOnMute(boolean z);

    void setDnsSearchEnabled(boolean z);

    void setDnsServers(String[] strArr);

    void setDnsServersApp(String[] strArr);

    void setDnsSrvEnabled(boolean z);

    void setDownloadBandwidth(int i);

    void setDownloadPtime(int i);

    void setEchoCancellationEnabled(boolean z);

    void setEchoCancellerFilterName(String str);

    void setEchoLimiterEnabled(boolean z);

    void setEnableSipUpdate(int i);

    void setExpectedBandwidth(int i);

    void setFileTransferServer(String str);

    void setForcedIceRelayEnabled(boolean z);

    void setFriendListSubscriptionEnabled(boolean z);

    void setFriendsDatabasePath(String str);

    void setGenericComfortNoiseEnabled(boolean z);

    void setGuessHostname(boolean z);

    void setHttpProxyHost(String str);

    void setHttpProxyPort(int i);

    void setInCallTimeout(int i);

    void setIncTimeout(int i);

    void setInputAudioDevice(AudioDevice audioDevice);

    void setIpv6Enabled(boolean z);

    void setKeepAliveEnabled(boolean z);

    void setLimeX3DhEnabled(boolean z);

    @Deprecated
    void setLimeX3DhServerUrl(String str);

    void setLinphoneSpecsList(String[] strArr);

    void setLogCollectionMaxFileSize(int i);

    void setLogCollectionPath(String str);

    void setLogCollectionPrefix(String str);

    void setLogCollectionUploadServerUrl(String str);

    void setMaxCalls(int i);

    void setMaxSizeForAutoDownloadIncomingFiles(int i);

    int setMediaDevice(String str);

    int setMediaEncryption(MediaEncryption mediaEncryption);

    void setMediaEncryptionMandatory(boolean z);

    void setMediaNetworkReachable(boolean z);

    void setMediaResourceMode(MediaResourceMode mediaResourceMode);

    void setMicEnabled(boolean z);

    void setMicGainDb(float f);

    void setMtu(int i);

    @Deprecated
    void setNatAddress(String str);

    void setNatPolicy(NatPolicy natPolicy);

    void setNativePreviewWindowId(Object obj);

    void setNativeRingingEnabled(boolean z);

    void setNativeVideoWindowId(Object obj);

    void setNetworkReachable(boolean z);

    void setNortpTimeout(int i);

    void setOutputAudioDevice(AudioDevice audioDevice);

    void setPlayFile(String str);

    int setPlaybackDevice(String str);

    void setPlaybackGainDb(float f);

    void setPreferredFramerate(float f);

    void setPreferredVideoDefinition(VideoDefinition videoDefinition);

    void setPreferredVideoDefinitionByName(String str);

    void setPresenceModel(PresenceModel presenceModel);

    void setPreviewVideoDefinition(VideoDefinition videoDefinition);

    void setPreviewVideoDefinitionByName(String str);

    int setPrimaryContact(String str);

    int setProvisioningUri(String str);

    void setPushIncomingCallTimeout(int i);

    void setPushNotificationEnabled(boolean z);

    void setQrcodeDecodeRect(int i, int i2, int i3, int i4);

    void setQrcodeVideoPreviewEnabled(boolean z);

    void setRecordAwareEnabled(boolean z);

    void setRecordFile(String str);

    void setRemoteRingbackTone(String str);

    void setRetransmissionOnNackEnabled(boolean z);

    void setRing(String str);

    void setRingDuringIncomingEarlyMedia(boolean z);

    void setRingback(String str);

    int setRingerDevice(String str);

    void setRootCa(String str);

    void setRootCaData(String str);

    void setRtpBundleEnabled(boolean z);

    void setSdp200AckEnabled(boolean z);

    void setSelfViewEnabled(boolean z);

    void setSenderNameHiddenInForwardMessageEnabled(boolean z);

    void setSessionExpiresEnabled(boolean z);

    void setSessionExpiresMinValue(int i);

    void setSessionExpiresRefresherValue(SessionExpiresRefresher sessionExpiresRefresher);

    void setSessionExpiresValue(int i);

    void setSipDscp(int i);

    void setSipNetworkReachable(boolean z);

    void setSipTransportTimeout(int i);

    void setSrtpCryptoSuites(String str);

    int setStaticPicture(String str);

    int setStaticPictureFps(float f);

    void setStunServer(String str);

    void setSupportedTag(String str);

    void setTag100RelSupportLevel(SupportLevel supportLevel);

    void setTcapLineMergingEnabled(boolean z);

    void setTextPayloadTypes(PayloadType[] payloadTypeArr);

    void setTextPort(int i);

    void setTextPortRange(int i, int i2);

    void setTlsCert(String str);

    void setTlsCertPath(String str);

    void setTlsKey(String str);

    void setTlsKeyPath(String str);

    void setTone(ToneID toneID, String str);

    int setTransports(Transports transports);

    void setUploadBandwidth(int i);

    void setUploadPtime(int i);

    void setUseFiles(boolean z);

    void setUseInfoForDtmf(boolean z);

    void setUseRfc2833ForDtmf(boolean z);

    void setUserAgent(String str, String str2);

    void setUserCertificatesPath(String str);

    void setUserData(Object obj);

    void setVibrationOnIncomingCallEnabled(boolean z);

    void setVideoActivationPolicy(VideoActivationPolicy videoActivationPolicy);

    void setVideoAdaptiveJittcompEnabled(boolean z);

    void setVideoCaptureEnabled(boolean z);

    int setVideoDevice(String str);

    void setVideoDisplayEnabled(boolean z);

    void setVideoDisplayFilter(String str);

    void setVideoDscp(int i);

    void setVideoJittcomp(int i);

    int setVideoMulticastAddr(String str);

    void setVideoMulticastEnabled(boolean z);

    int setVideoMulticastTtl(int i);

    void setVideoPayloadTypes(PayloadType[] payloadTypeArr);

    void setVideoPort(int i);

    void setVideoPortRange(int i, int i2);

    void setVideoPreset(String str);

    void setVideoPreviewEnabled(boolean z);

    void setVideoSourceReuseEnabled(boolean z);

    void setWifiOnlyEnabled(boolean z);

    void setZeroRtpPortForStreamInactiveEnabled(boolean z);

    void setZrtpGoClearEnabled(boolean z);

    void setZrtpKeyAgreementSuites(ZrtpKeyAgreement[] zrtpKeyAgreementArr);

    void setZrtpSecretsFile(String str);

    @Deprecated
    boolean soundDeviceCanCapture(String str);

    @Deprecated
    boolean soundDeviceCanPlayback(String str);

    boolean soundResourcesLocked();

    int start();

    @Deprecated
    int startConferenceRecording(String str);

    int startEchoCancellerCalibration();

    int startEchoTester(int i);

    void stop();

    void stopAsync();

    @Deprecated
    int stopConferenceRecording();

    void stopDtmf();

    int stopEchoTester();

    void stopRinging();

    Event subscribe(Address address, String str, int i, Content content);

    int takePreviewSnapshot(String str);

    int terminateAllCalls();

    int terminateConference();

    String toString();

    boolean tunnelAvailable();

    void uploadLogCollection();

    boolean upnpAvailable();

    void usePreviewWindow(boolean z);

    boolean vcardSupported();

    void verifyServerCertificates(boolean z);

    void verifyServerCn(boolean z);

    boolean videoSupported();

    public enum LogCollectionUploadState {
        InProgress(0),
        Delivered(1),
        NotDelivered(2);

        protected final int mValue;

        LogCollectionUploadState(int i) {
            this.mValue = i;
        }

        public static LogCollectionUploadState fromInt(int i) throws RuntimeException {
            if (i == 0) {
                return InProgress;
            }
            if (i == 1) {
                return Delivered;
            }
            if (i == 2) {
                return NotDelivered;
            }
            throw new RuntimeException("Unhandled enum value " + i + " for LogCollectionUploadState");
        }

        public int toInt() {
            return this.mValue;
        }
    }
}
